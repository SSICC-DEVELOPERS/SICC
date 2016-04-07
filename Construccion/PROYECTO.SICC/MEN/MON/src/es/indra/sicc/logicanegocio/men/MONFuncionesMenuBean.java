package es.indra.sicc.logicanegocio.men;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.MGUService;
import es.indra.mare.common.mgu.manager.RoleImpl;
import es.indra.mare.common.mgu.manager.UserIDImpl;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.MONI18n;
import es.indra.sicc.cmn.negocio.i18n.MONI18nHome;
import es.indra.sicc.dtos.men.DTOElementoMenu;
import es.indra.sicc.dtos.men.DTOEntradaFuncionSeleccionada;
import es.indra.sicc.dtos.men.DTOEntradaInsertarElementodeMenu;
import es.indra.sicc.dtos.men.DTOEntradaObtieneFuncion;
import es.indra.sicc.dtos.men.DTOEntradaPresentarMenu;
import es.indra.sicc.dtos.men.DTOFuncionMenu;
import es.indra.sicc.dtos.men.DTOString;
import es.indra.sicc.dtos.men.DTOModificarElementoMenu;
import es.indra.sicc.entidades.men.FuncionLocal;
import es.indra.sicc.entidades.men.FuncionLocalHome;
import es.indra.sicc.entidades.seg.AyudaLocal;
import es.indra.sicc.entidades.seg.AyudaLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CMNEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.men.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONFuncionesMenuBean implements SessionBean {
    private SessionContext ctx;
    private BelcorpService belcorpService;

    public void ejbCreate() throws CreateException {

        UtilidadesLog.info("MONFuncionesMenuBean.ejbCreate(): Entrada");
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " + mmsnfe.getMessage(), mmsnfe);
        }

        UtilidadesLog.info("MONFuncionesMenuBean.ejbCreate(): Salida");
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    /**
     * Este m&eacute;todo realiza una inserci&oacute;n en Funcion a partir de
     * la funci&oacute;n create() de la clase, guardando en ella los datos
     * introducidos por el usuario, en este caso los par&aacute;metros pasados
     * en el m&eacute;todo, poniendo en el campo Jerarquia el identificador
     * de la funci&oacute;n que ha sido seleccionada como padre.
     *
     * Ademas crea llamando al MGUMON un nuevo rol para esa funci&oacute;n.
     * Si en alguno de los casos se produce un error se devuelve la
     * excepci&oacute;n para mostrar el mensaje de error correspondiente.
     *     
     * @return DTOSalida
     * @exception MareException
     */
    public void insertar(DTOEntradaInsertarElementodeMenu dtoe) throws MareException {

        UtilidadesLog.info("MONFuncionesMenuBean.insertar(DTOEntradaInsertarElementodeMenu dtoe): Entrada");

        String codigoError;
        FuncionLocalHome funcionLocalHome = null;

        funcionLocalHome = (FuncionLocalHome)belcorpService.ejbLocator.getEntityLocalHome("java:comp/env/Funcion");
        FuncionLocal funcionLocal = null;
        try {
            funcionLocal = funcionLocalHome.create(dtoe.getIndicadorFuncionFinal(), dtoe.getIndicadorDeRastreo(), dtoe.getIdIdioma(), dtoe.getIdFuncJerarquia());
            funcionLocal.setNombrePrograma(dtoe.getNombreProgramaEjecutable());
            funcionLocalHome.merge(funcionLocal);


        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_CLAVE_DUPLICADA;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dtoe.getUsuario()), dtoe.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU, credenciales));
        mgumon.createRole(new RoleImpl(funcionLocal.getOid().toString()), new ArrayList(), new ArrayList());
        UtilidadesLog.info("MONFuncionesMenuBean.insertar(DTOEntradaInsertarElementodeMenu dtoe): Salida");
    }

    /**
     * Este m&eacute;todo realiza el borrado de la funci&oacute;n pasada en
     * por par&aacute;metro. Ademas realizando una llamada el MGUMON al
     * m&eacute;todo removeRole() elimina tambi&eacute;n el rol de dicha
     * funci&oacute;n.
     * Si en alguno de los casos se produce un error se devuelve la
     * excepci&oacute;n para mostrar el error correspondiente.
     *     
     * @return DTOSalida
     * @exception MareException
     */
    public void elimina(DTOEntradaFuncionSeleccionada dtoe) throws MareException {

        UtilidadesLog.info("MONFuncionesMenuBean.elimina(DTOEntradaFuncionSeleccionada dtoe): Entrada");

        String codigoError;
        FuncionLocalHome funcionLocalHome = null;
        AyudaLocalHome ayudaLocalhome = null;
        Long oidFunc = null;

        UtilidadesLog.debug("******** Entrada a elimina *********** ");

        funcionLocalHome = getFuncionLocalHome();
        ayudaLocalhome = getAyudaLocalHome();

        try {
            Collection ayudaLocals = ayudaLocalhome.findOidFunc(dtoe.getId());

            /*
             * Borro los registros de ayuda para esta funcion
             */
            for (Iterator ayudaIte = ayudaLocals.iterator(); ayudaIte.hasNext(); )
                ayudaLocalhome.remove((AyudaLocal)ayudaIte.next());

            /*
             * Borro los registro de Texto de Ayuda de GEN_I18N para esta funcion
             *
             */
            UtilidadesLog.debug("Procede a borrar los registros de texto de ayuda de GEN_I18N");
            MONI18nHome i18Home = CMNEjbLocators.getMONI18nHome();
            MONI18n i18 = null;

            try {
                UtilidadesLog.debug("Obtiene la local de i18");
                i18 = i18Home.create();
            } catch (RemoteException ex) {
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (CreateException cex) {
                throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            i18.eliminarTraducciones("SEG_AYUDA", dtoe.getId());
            UtilidadesLog.debug("funcionLocalHome.findByPrimaryKey");

            FuncionLocal funcionLocal = funcionLocalHome.findByPrimaryKey(dtoe.getId());

            oidFunc = funcionLocal.getOid();

            if (oidFunc == null)
                UtilidadesLog.debug("oidFunc es null");
            else
                UtilidadesLog.debug("oidFunc: " + oidFunc.toString());

            funcionLocalHome.remove(funcionLocal);

        } catch (Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        /*
        * Incidencia 211, creacion de roles
        * en V3 los roles se crean con el id de funciones
         */
        UtilidadesLog.debug("Procede a remover los roles de PRINCIPAL");
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dtoe.getUsuario()), dtoe.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU, credenciales));
        RoleImpl riRol = new RoleImpl(oidFunc.toString());
        mgumon.deleteRole(riRol);

        UtilidadesLog.info("MONFuncionesMenuBean.elimina(DTOEntradaFuncionSeleccionada dtoe): Salida");
    }

    /**
     * Este m&eacute;todo realiza una modificaci&oacute;n por JDBC sobre la
     * entidad Funcion, modificando en ella los datos introducidos por el
     * usuario, en este caso los par&aacute;metros pasados en el m&eacute;todo.
     *    
     * @return DTOSalida
     * @exception MareException
     */
    public void modifica(DTOModificarElementoMenu dtoe) throws MareException {
        UtilidadesLog.info("MONFuncionesMenuBean.modifica(DTOModificarElementoMenu dtoe): Entrada");

        String codigoError;
        FuncionLocalHome funcionLocalHome = null;

        //Obtencion del local home de Funcion
        funcionLocalHome = this.getFuncionLocalHome();

        try {
            //Obtencion del local de Funcion
            FuncionLocal funcionLocal = funcionLocalHome.findByPrimaryKey(dtoe.getIdFuncion());

            /*
             * Incidencia 211, creacion de roles
             * en V3 los roles se crean con el id de funciones, por lo tanto el
             * rol de la de funcion no se modifica
             */
            funcionLocal.setNombrePrograma(dtoe.getProgramaEjecutable());
            funcionLocal.setFuncOid(dtoe.getIdFuncionJerarquiaDestino());
            funcionLocal.setIndicadorNivel(dtoe.getIndicadorFuncionFinal());
            funcionLocal.setIndicadorRastreo(dtoe.getIndicadorRastreo());
            funcionLocal.setTraducciones(dtoe.getNombreFuncion());
            funcionLocalHome.merge(funcionLocal);

            UtilidadesLog.info("MONFuncionesMenuBean.modifica(DTOModificarElementoMenu dtoe): Salida");

        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_CLAVE_DUPLICADA;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    /**
     * Va a realizar la b&uacute;squeda por JDBC de todo el men&uacute;, de
     * todas las funciones, asi como la jerarqu&iacute;a, con la que se debe
     * presentar en el men&uacute;, en la entidad Funcion.
     * Tambi&eacute;n se utiliza para mostrar la jerarqu&iacute;a de
     * funciones en la pantalla SelecciondeJerarquia.
     *
     * @param dTOEntradaPresentarMenu
     * @return DTOSalida
     * @exception MareException
     */
    public DTOSalida obtieneFunciones(DTOEntradaPresentarMenu dTOEntradaPresentarMenu) throws MareException {

        UtilidadesLog.info("MONFuncionesMenuBean.obtieneFunciones(DTOEntradaPresentarMenu dTOEntradaPresentarMenu): Entrada");

        RecordSet recordSet = null;
        String codigoError;
        StringBuffer query = new StringBuffer();

        if (dTOEntradaPresentarMenu.getOID_FUNC() == null)
            dTOEntradaPresentarMenu.setOID_FUNC(new Long(1));

        query.append(" SELECT OID_FUNC, nom_func, VAL_NOMB_PROG, IND_NIVE, FUNC_OID_FUNC, 1 as habilitado, LEVEL - 1 AS nivel" + " FROM (SELECT OID_FUNC, VAL_I18N as nom_func, VAL_NOMB_PROG, IND_NIVE, FUNC_OID_FUNC" + " FROM men_funci, GEN_I18N_SICC" + " where ATTR_ENTI = 'MEN_FUNCI' and ATTR_NUM_ATRI = 1 and IDIO_OID_IDIO = 1 and VAL_OID = OID_FUNC" + " UNION" + " SELECT OID_FUNC, VAL_I18N as nom_func, VAL_NOMB_PROG, IND_NIVE,2" + " FROM men_favor, men_funci, GEN_I18N_SICC" + " WHERE men_favor.FUNC_OID_FUNC = men_funci.OID_FUNC" + " and ATTR_ENTI = 'MEN_FUNCI'" + " and ATTR_NUM_ATRI = 1" + " and IDIO_OID_IDIO = " + dTOEntradaPresentarMenu.getIdIdioma() + " " + " and VAL_OID = OID_FUNC)" + " CONNECT BY PRIOR OID_FUNC = FUNC_OID_FUNC" + " START WITH OID_FUNC = " + dTOEntradaPresentarMenu.getOID_FUNC());

        try {
            recordSet = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONFuncionesMenuBean.obtieneFunciones(DTOEntradaPresentarMenu dTOEntradaPresentarMenu): Salida");
        return new DTOSalida(recordSet);
    }

    /**
     * Se va a obtener el men&uacute; teniendo en cuenta el tipo de usuario,
     * todos los datos del usuario los obtiene del MGUService, para establecer
     * como van los datos para ser presentados en el men&uacute;.    
     *
     * @return DTOSalida
     * @exception MareException
     */
    public DTOSalida obtieneMenu(DTOEntradaObtieneFuncion dtoe) throws MareException {

        UtilidadesLog.info("MONFuncionesMenuBean.obtieneMenu(DTOEntradaObtieneFuncion dtoe): Entrada");

        String codigoError;
        RecordSet recordSet = null;
        RecordSet recordSetTipoUsuario = null;
        String sIdUsuario = "";
        String sTipoUsuario = "";
        Long idIdioma;

        /*
         * Validacion de Id de Usuario
         */
        if ((dtoe.getIdUsuario() == null) || (dtoe.getIdUsuario() == "")) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        } else
            sIdUsuario = dtoe.getIdUsuario();

        /*
         * Obtencion del idIdioma, sino se envia se toma como default el 1
         */
        if (dtoe.getIdIdioma() == null)
            idIdioma = new Long(1);
        else
            idIdioma = dtoe.getIdIdioma();

        /*
         * Obtencion del tipo de Usuario
         */
        try {
            String sConsultaTipoUsuario = this.armaConsultaTipoUsuario(sIdUsuario);
            recordSetTipoUsuario = belcorpService.dbService.executeStaticQuery(sConsultaTipoUsuario);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        sTipoUsuario = (String)recordSetTipoUsuario.getRow(0).get(0);

        /*
         * Tipo de Usuario Batch
         */
        if (sTipoUsuario.equalsIgnoreCase("BATCH")) {
            RecordSet rsSalida = null;
            rsSalida = new RecordSet();
            rsSalida.addColumn("idfuncion");
            rsSalida.addColumn("nombrefuncion");
            rsSalida.addColumn("nombreprograma");
            rsSalida.addColumn("jerarquia");
            rsSalida.addColumn("nodofinal");
            rsSalida.addColumn("habilitado");

            /*
             * Se retorna unicamente la raiz del menu
             */
            rsSalida.addRow(new Object[] { new String("F0001"), new String("Menu"), new String(""), new String("F0001"), new String("0"), new String("1") });

            DTOSalida dtos = new DTOSalida();
            dtos.setResultado(rsSalida);

            UtilidadesLog.info("MONFuncionesMenuBean.obtieneMenu(DTOEntradaObtieneFuncion dtoe): Salida");
            return dtos;
        }

        /*
         * Tipo de Usuario Tercero o Interactivo
         */
        try {
            recordSet = belcorpService.dbService.executeStaticQuery(this.armaConsultaMenu(sTipoUsuario, sIdUsuario, idIdioma));
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        /*
         * Armado de retorno de datos
         */
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(recordSet);


        UtilidadesLog.info("MONFuncionesMenuBean.obtieneMenu(DTOEntradaObtieneFuncion dtoe): Salida");
        return dtos;
    }

    private String armaConsultaTipoUsuario(String sIdUsuario) {
        UtilidadesLog.info("MONFuncionesMenuBean.armaConsultaTipoUsuario(String sIdUsuario)): Entrada");

        String sConsulta = "select pv.stringvalue as TipoUsuario " + "from principals pri, properties pro, propertyvalues pv " + "where pri.idprincipal = pv.idprincipal and " + "pro.idproperty = pv.idproperty and pri.name='" + sIdUsuario + "' and pv.idproperty = 13 ";

        UtilidadesLog.info("MONFuncionesMenuBean.armaConsultaTipoUsuario(String sIdUsuario)): Salida");
        return sConsulta;
    }

    private String armaConsultaMenu(String sTipoUsuario, String sIdUsuario, Long idIdioma) {
        UtilidadesLog.info("MONFuncionesMenuBean.armaConsultaMenu(String sTipoUsuario, String sIdUsuario, Long idIdioma): Entrada");

        StringBuffer sConsulta = new StringBuffer();

        //Jrivas se cambio la consulta para que use la vista en lugar de las tablas...
        //28/4/2005


        sConsulta.append(" SELECT   oid_func, nom_func, val_nomb_prog, func_oid_func, ind_nive,");
        sConsulta.append(" DECODE (NAME, NULL, 0, 1) AS habilitado, nivel");
        sConsulta.append(" FROM (select LEVEL - 1 AS nivel,nom_func, oid_func, val_nomb_prog, ind_nive, func_oid_func,SYS_CONNECT_BY_PATH (nom_func, '#') AS PATH ");
        sConsulta.append(" from (select nom_func, oid_func, val_nomb_prog, ind_nive, func_oid_func ");
        sConsulta.append(" FROM mv_funciones_menu");
        sConsulta.append(" where");
        sConsulta.append(" (val_usua = '" + sIdUsuario + "' or val_usua is null)");
        sConsulta.append(" AND idio_oid_idio = " + idIdioma.toString() + ")");
        sConsulta.append(" START WITH oid_func = 1");
        sConsulta.append(" CONNECT BY NOCYCLE PRIOR oid_func =  func_oid_func");
        sConsulta.append(" ),");
        sConsulta.append(" (SELECT DISTINCT (SELECT NAME");
        sConsulta.append(" FROM principals");
        sConsulta.append(" WHERE idprincipal = idrole) AS NAME");
        sConsulta.append(" FROM memberof");
        sConsulta.append(" CONNECT BY PRIOR idrole = idmember");
        sConsulta.append(" START WITH idmember IN (");
        sConsulta.append(" SELECT idprincipal");
        sConsulta.append(" FROM principals");
        sConsulta.append(" WHERE NAME IN (");
        sConsulta.append(" SELECT perfiles.NAME");
        sConsulta.append(" FROM memberof m,");
        sConsulta.append(" principals p,");
        sConsulta.append(" (SELECT p.idprincipal, p.NAME");
        sConsulta.append(" FROM principals p,");
        sConsulta.append(" principals p2,");
        sConsulta.append(" memberof m");
        sConsulta.append(" WHERE p2.NAME = 'PerfilesSICC'");
        sConsulta.append(" AND m.idmember = p2.idprincipal");
        sConsulta.append(" AND m.idrole = p.idprincipal) perfiles");
        sConsulta.append(" WHERE m.idrole = perfiles.idprincipal");
        sConsulta.append(" AND p.idprincipal = m.idmember");
        sConsulta.append(" AND p.idprincipal = m.idmember");
        sConsulta.append(" AND p.NAME = '" + sIdUsuario + "')))");
        if (sTipoUsuario.equalsIgnoreCase("TERCERO"))
            sConsulta.append("WHERE NAME = to_char(OID_FUNC) ORDER BY PATH ");
        else {
            if (sTipoUsuario.equalsIgnoreCase("INTERACTIVO"))
                sConsulta.append("WHERE NAME(+) = to_char(OID_FUNC) ORDER BY PATH ");
        }

        UtilidadesLog.info("MONFuncionesMenuBean.armaConsultaMenu(String sTipoUsuario, String sIdUsuario, Long idIdioma): Salida");
        return sConsulta.toString();
    }

    public DTOSalida obtieneFuncion(DTOEntradaObtieneFuncion dtoe) throws MareException {

        UtilidadesLog.info("MONFuncionesMenuBean.obtieneFuncion(DTOEntradaObtieneFuncion dtoe): Entrada");

        RecordSet recordSet = null;
        String codigoError;
        StringBuffer query = new StringBuffer();

        if ((dtoe.getIdFuncion() == "") || (dtoe.getIdFuncion() == null)) {
            UtilidadesLog.info("MONFuncionesMenuBean.generarRegistroCC(DTOFACConsolidado dtoConso): Salida");
            throw new MareException("Se produjo un error en la aplicaci�n. " + "No se encontro el ID de funci�n.");
        }
        query.append(" SELECT OID_FUNC AS idfuncion, ");
        query.append(" VAL_I18N AS nombrefuncion, ");
        query.append(" VAL_NOMB_PROG AS nombreprograma, ");
        query.append(" FUNC_OID_FUNC AS jerarquia, ");
        query.append(" IND_NIVE AS nodofinal ");
        query.append(" FROM MEN_FUNCI F, GEN_I18N_SICC G ");
        query.append(" WHERE ATTR_ENTI = 'MEN_FUNCI' and ATTR_NUM_ATRI = 1 ");
        query.append(" and VAL_OID = OID_FUNC ");
        query.append(" and IDIO_OID_IDIO = " + dtoe.getIdIdioma().toString());
        query.append(" and OID_FUNC = " + dtoe.getIdFuncion());

        try {
            recordSet = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        /*
         * Armado de retorno de datos
         */
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(recordSet);

        UtilidadesLog.info("MONFuncionesMenuBean.obtieneFuncion(DTOEntradaObtieneFuncion dtoe): Salida");

        return dtos;
    }

    /**
     * El m�todo obtiene la interfaz local del entity Ayuda
     * preCondicion: que exista el entity Ayuda
     *
     * @param
     * @return FuncionLocalHome     
     */
    private AyudaLocalHome getAyudaLocalHome() throws MareException {

        UtilidadesLog.info("MONFuncionesMenuBean.getAyudaLocalHome(): Entrada");

        AyudaLocalHome localHome = new AyudaLocalHome();

        UtilidadesLog.info("MONFuncionesMenuBean.getAyudaLocalHome(): Salida");
        return localHome;
    }

    /**
     * El m�todo obtiene la interfaz local del entity Funcion
     * preCondicion: que exista el entity Funcion
     *
     * @param
     * @return FuncionLocalHome      
     */
    private FuncionLocalHome getFuncionLocalHome() throws MareException {
        UtilidadesLog.info("MONFuncionesMenuBean.getFuncionLocalHome(): Entrada");

        FuncionLocalHome localHome = new FuncionLocalHome();

        UtilidadesLog.info("MONFuncionesMenuBean.getFuncionLocalHome(): Salida");
        return localHome;
    }

    /**
     * El m�todo obtiene las funciones hojas para el usuario y el idioma,
     * que se pasan como par�metros.
     *
     * @param  usuario, idIdioma
     * @return DTOSalidaFunciones
     * @throws MareException
     */
    public RecordSet obtieneFuncionesConfigurarAyuda(String usuario, Long idIdioma) throws MareException {

        UtilidadesLog.info("MONFuncionesMenuBean.obtieneFuncionesConfigurarAyuda(String usuario, Long idIdioma): Entrada");

        String codigoError = null;
        BelcorpService bs = null;
        RecordSet recordSet = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
        }

        // Arma la Query.
        StringBuffer sConsulta = new StringBuffer();
        String sConsultaPerfil = "select perfiles.name " + "from memberof m, principals p, " + "(SELECT p.idprincipal, p.name FROM principals p, principals p2, memberof m where p2.name = 'PerfilesSICC' and m.idmember = p2.idprincipal and m.idrole = p.idprincipal) perfiles " + "where m.idrole = perfiles.idprincipal and p.idprincipal = m.idmember and p.name = '" + usuario + "' ";

        sConsulta.append(" SELECT OID_FUNC, nom_func, path ");
        sConsulta.append(" FROM (SELECT LEVEL - 1 AS nivel, OID_FUNC, nom_func, VAL_NOMB_PROG, IND_NIVE, FUNC_OID_FUNC,SYS_CONNECT_BY_PATH (nom_func, '#') AS PATH ");
        sConsulta.append(" FROM (SELECT OID_FUNC, VAL_I18N as nom_func, VAL_NOMB_PROG, IND_NIVE, FUNC_OID_FUNC ");
        sConsulta.append(" FROM men_funci, v_GEN_I18N_SICC where ATTR_ENTI = 'MEN_FUNCI' and ATTR_NUM_ATRI = 1 and IDIO_OID_IDIO = " + idIdioma.toString() + " and VAL_OID = OID_FUNC) ");
        sConsulta.append(" CONNECT BY PRIOR OID_FUNC = FUNC_OID_FUNC ");
        sConsulta.append(" START WITH OID_FUNC = 1),(SELECT DISTINCT (SELECT NAME FROM principals WHERE idprincipal = idrole) AS NAME FROM memberof CONNECT BY PRIOR idrole = idmember START WITH idmember IN (SELECT idprincipal FROM principals WHERE NAME IN (" + sConsultaPerfil + "))) ");
        sConsulta.append("WHERE NAME = to_char(OID_FUNC) and ind_nive = 1 ORDER BY 1, 2 ");

        //Ejecuta la super consulta
        try {
            recordSet = belcorpService.dbService.executeStaticQuery(sConsulta.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e.getLocalizedMessage(), UtilidadesError.armarCodigoError(codigoError));
        }

        //Obtenemos el padre de cada funcion hoja
        int cantRegistros = recordSet.getRowCount();
        String path;
        String nombrePadreHijo;

        for (int i = 0; i < cantRegistros; i++) {
            path = (String)recordSet.getValueAt(i, 2);
            nombrePadreHijo = obtenerNombreFuncionPadreHijo(path);
            recordSet.setValueAt(nombrePadreHijo, i, 1);
        }

        UtilidadesLog.debug("obtieneFuncionesConfigurarAyuda obtenidas: " + cantRegistros);
        UtilidadesLog.info("MONFuncionesMenuBean.obtieneFuncionesConfigurarAyuda(String usuario, Long idIdioma): Salida");

        return recordSet;
    }

    public DTOSalida consulta(DTOEntradaFuncionSeleccionada dtoe) throws MareException {

        UtilidadesLog.info("MONFuncionesMenuBean.consulta(DTOEntradaFuncionSeleccionada dtoe): Entrada");

        /*
        * Hacemos un findByPrimaryKey en el entity Funcion y copiamos los atributos en un DTOFuncionMenu.
        * Llamamos a MONI18N.recuperarTraducciones para rellenar el atributo attriTraducible
        * Devolvemos el DTOFuncionMenu
        */
        RecordSet recordSet = null;
        String codigoError;
        StringBuffer query = new StringBuffer();

        if ((dtoe.getId() == null) || dtoe.getId().toString().equals(""))
            throw new MareException("Se produjo un error en la aplicaci�n. " + "No se encontro el ID de funci�n.");

        query.append("SELECT OID_FUNC AS idfuncion, ");
        query.append(" VAL_I18N AS nombrefuncion, ");
        query.append(" VAL_NOMB_PROG AS nombreprograma, ");
        query.append(" FUNC_OID_FUNC AS jerarquia, ");
        query.append(" IND_NIVE AS nodofinal, ");
        query.append(" IND_RAST as indicadorrastreo ");
        query.append(" FROM MEN_FUNCI F, V_GEN_I18N_SICC G ");
        query.append(" WHERE ATTR_ENTI = 'MEN_FUNCI' and ATTR_NUM_ATRI = 1 ");
        query.append(" and VAL_OID = OID_FUNC ");
        query.append(" and IDIO_OID_IDIO = " + dtoe.getOidIdioma().toString());
        query.append(" and OID_FUNC = " + dtoe.getId());

        try {
            recordSet = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        /*
         * Armado de retorno de datos
         */
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(recordSet);

        UtilidadesLog.info("MONFuncionesMenuBean.consulta(DTOEntradaFuncionSeleccionada dtoe): Salida");

        return dtos;
    }

    public DTOElementoMenu obtenerMenuUsuario(DTOBoolean dto) throws MareException {

        UtilidadesLog.info("MONFuncionesMenuBean.obtenerMenuUsuario(DTOBoolean dto): Entrada");

        String usuario = ctx.getCallerPrincipal().getName();
        UtilidadesLog.debug("usuario " + usuario);
        DAOMenu daoMenu = new DAOMenu(usuario);
        RecordSet menu = daoMenu.obtenerMenuUsuario(dto.getOidIdioma());
        UtilidadesLog.debug("menu " + menu);
        Map nodos = new HashMap();

        int lineas = menu.getRowCount();

        for (int i = 0; i < lineas; i++) {
            boolean hoja = menu.getValueAt(i, 3).toString().equals("1") ? 
                           true : 
                           false;

            if (!dto.getValor() && hoja)
                continue;

            Long oid = new Long(((BigDecimal)menu.getValueAt(i, 0)).longValue());
            String nombre = (String)menu.getValueAt(i, 1);
            DTOElementoMenu dtoEM = new DTOElementoMenu(oid, nombre, Boolean.valueOf(hoja));
            Long padre = (menu.getValueAt(i, 4) != null) ? 
                         new Long(((BigDecimal)menu.getValueAt(i, 4)).longValue()) : 
                         null;
            DTOElementoMenu dtoEM2 = (DTOElementoMenu)nodos.get(padre);

            if (dtoEM2 != null)
                dtoEM2.addHijo(dtoEM);

            nodos.put(oid, dtoEM);
        }

        UtilidadesLog.info("MONFuncionesMenuBean.obtenerMenuUsuario(DTOBoolean dto): Salida");
        return (DTOElementoMenu)nodos.get(new Long(ConstantesMEN.NODO_RAIZ));
    }


    public void guarda(DTOFuncionMenu dto) throws MareException {

        UtilidadesLog.info("MONFuncionesMenuBean.guarda(DTOFuncionMenu dto): Entrada");

        String codigoError;
        FuncionLocalHome funcionLH = getFuncionLocalHome();
        FuncionLocal funcionLocal;

        try {
            MONI18n i18 = CMNEjbLocators.getMONI18nHome().create();
            if (dto.getOid() == null) {
                funcionLocal = funcionLH.create(dto.getNivel(), dto.getRastreo(), dto.getPadre());
                i18.insertarTraducciones("MEN_FUNCI", funcionLocal.getOid(), new Vector(dto.getAttriTraducible()));
            } else {
                funcionLocal = funcionLH.findByPrimaryKey(dto.getOid());
                funcionLocal.setIndicadorNivel(dto.getNivel());
                funcionLocal.setIndicadorRastreo(dto.getRastreo());
                funcionLocal.setFuncOid(dto.getPadre());
                funcionLH.merge(funcionLocal);

                i18.actualizaTraducciones("MEN_FUNCI", funcionLocal.getOid(), new Vector(dto.getAttriTraducible()));

            }
            funcionLocal.setNombrePrograma(dto.getProgramaEjecutable());

            try {
                funcionLH.merge(funcionLocal);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (PersistenceException e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (dto.getOid() == null) {
            MareCredentials credenciales = new MareCredentials(new UserIDImpl(dto.getUsuario()), dto.getPassword());
            MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU, credenciales));
            mgumon.createRole(new RoleImpl(funcionLocal.getOid().toString()), new ArrayList(), new ArrayList());
        }

        UtilidadesLog.info("MONFuncionesMenuBean.guarda(DTOFuncionMenu dto): Salida");
    }
    

    public DTOFuncionMenu consulta(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONFuncionesMenuBean.consulta(DTOOID dto): Entrada");

        String codigoError;
        FuncionLocalHome funcionLH = getFuncionLocalHome();
        MONI18nHome i18Home = CMNEjbLocators.getMONI18nHome();
        FuncionLocal funcionLocal;
        MONI18n i18 = null;
        DTOFuncionMenu salida = new DTOFuncionMenu();

        try {
            i18 = i18Home.create();
            funcionLocal = funcionLH.findByPrimaryKey(dto.getOid());
            salida.setNivel(funcionLocal.getIndicadorNivel());
            salida.setOid(funcionLocal.getOid());
            salida.setPadre(funcionLocal.getFuncOid());
            salida.setRastreo(funcionLocal.getIndicadorRastreo());
            salida.setProgramaEjecutable(funcionLocal.getNombrePrograma());
            DTOSalida f = i18.recuperarTraducciones("MEN_FUNCI", dto.getOid());
            RecordSet d = f.getResultado();
            Vector p = d.getRecords();
            salida.setAttriTraducible(p);
        } catch (NoResultException e) {
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (PersistenceException e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        /*copiamos los atributos en un DTOFuncionMenu.
        Llamamos a MONI18N.recuperarTraducciones para rellenar el atributo attriTraducible
        Devolvemos el DTOFuncionMenu*/

        UtilidadesLog.info("MONFuncionesMenuBean.consulta(DTOOID dto): Salida");
        return salida;
    }

    /*
     * Obtiene el nombre de la funcion mas el nombre de la funcion padre.
     */

    private String obtenerNombreFuncionPadreHijo(String path) {
        //UtilidadesLog.info("MONFuncionesMenuBean.obtenerNombreFuncionPadreHijo(String path): Entrada");

        path = path.replaceFirst("#Menu#", "");
        path = path.replaceAll("#", "/");

        //UtilidadesLog.info("MONFuncionesMenuBean.obtenerNombreFuncionPadreHijo(String path): Salida " + path);        
        return path;
    }

    public DTOElementoMenu obtenerMenuCompleto(DTOBelcorp dto) throws MareException {

        UtilidadesLog.info("MONFuncionesMenuBean.obtenerMenuCompleto(DTOBelcorp dto): Entrada");

        String usuario = ctx.getCallerPrincipal().getName();
        UtilidadesLog.debug("usuario " + usuario);
        DAOMenu daoMenu = new DAOMenu(usuario);
        RecordSet rs = daoMenu.obtenerMenuCompleto(dto.getOidIdioma());
        boolean traerHojas = true;
        if (dto instanceof DTOBoolean)
            traerHojas = ((DTOBoolean)dto).getValor();

        return this.construirArbolMenu(traerHojas, rs);
    }

    public DTOElementoMenu construirArbolMenu(boolean hojas, RecordSet elementos) throws MareException {

        UtilidadesLog.info("MONFuncionesMenuBean.construirArbolMenu(boolean hojas, RecordSet elementos): Entrada");

        Map nodos = new HashMap();

        int lineas = elementos.getRowCount();

        for (int i = 0; i < lineas; i++) {
            boolean hoja = elementos.getValueAt(i, 3).toString().equals("1") ? 
                           true : 
                           false;

            if (!hojas && hoja)
                continue;

            Long oid = new Long(((BigDecimal)elementos.getValueAt(i, 0)).longValue());
            String nombre = (String)elementos.getValueAt(i, 1);
            DTOElementoMenu dtoEM = new DTOElementoMenu(oid, nombre, Boolean.valueOf(hoja));
            Long padre = (elementos.getValueAt(i, 4) != null) ? 
                         new Long(((BigDecimal)elementos.getValueAt(i, 4)).longValue()) : 
                         null;
            DTOElementoMenu dtoEM2 = (DTOElementoMenu)nodos.get(padre);

            if (dtoEM2 != null)
                dtoEM2.addHijo(dtoEM);

            nodos.put(oid, dtoEM);
        }

        UtilidadesLog.info("MONFuncionesMenuBean.construirArbolMenu(boolean hojas, RecordSet elementos): Salida");

        return (DTOElementoMenu)nodos.get(new Long(ConstantesMEN.NODO_RAIZ));
    }

    public DTOSalida obtieneFuncionesUsuario(DTOString usuario) throws MareException {

        UtilidadesLog.info("MONFuncionesMenuBean.obtieneFuncionesUsuario(DTOString usuario): Entrada");

        StringBuffer query = new StringBuffer();
        StringBuffer inClause = new StringBuffer();
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(usuario.getUsuario()), usuario.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU, credenciales));

        Iterator it = mgumon.getRoles(new UserIDImpl(usuario.getValor())).iterator();

        inClause.append("(");
        while (it.hasNext()) {
            RoleImpl rol = (RoleImpl)it.next();
            try {
                Long oid = new Long(Long.parseLong(rol.getName()));
                inClause.append(oid + ", ");
            } catch (NumberFormatException e) {
                UtilidadesLog.debug("No es un numero --> no es una funcion");
            }
        }
        //Le saco la ", " final
        if (inClause.length() > 2) {
            inClause = new StringBuffer(inClause.substring(0, inClause.length() - 2));
        }

        inClause.append(")");

        query.append(" SELECT H.OID_FUNC,CONCAT(V2.VAL_I18N , CONCAT('-', V1.VAL_I18N)) ");
        query.append(" FROM MEN_FUNCI H,V_GEN_I18N_SICC V1,V_GEN_I18N_SICC V2 ");
        query.append(" WHERE H.VAL_NOMB_PROG IS NOT NULL ");
        query.append(" AND h.IND_NIVE = 1 ");
        query.append(" AND V1.VAL_OID=H.OID_FUNC ");
        query.append(" AND V1.ATTR_ENTI='MEN_FUNCI' ");
        query.append(" AND V1.IDIO_OID_IDIO= " + usuario.getOidIdioma());
        query.append(" AND V2.VAL_OID=H.FUNC_OID_FUNC ");
        query.append(" AND V2.ATTR_ENTI='MEN_FUNCI' ");
        query.append(" AND V2.IDIO_OID_IDIO= " + usuario.getOidIdioma());
        query.append(" AND H.OID_FUNC IN " + inClause.toString());
        query.append(" AND order by 2 ");
        RecordSet rs = null;

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        UtilidadesLog.info("MONFuncionesMenuBean.obtieneFuncionesUsuario(DTOString usuario): Salida");
        return new DTOSalida(rs);
    }


    public void elimina(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONFuncionesMenuBean.elimina(DTOOIDs dto): Entrada");

        String codigoError;
        FuncionLocalHome funcionLH = getFuncionLocalHome();
        MONI18nHome i18Home = CMNEjbLocators.getMONI18nHome();
        FuncionLocal funcionLocal;
        MONI18n i18 = null;

        try {
            i18 = i18Home.create();
            Long[] oids = dto.getOids();
            MareCredentials credenciales = new MareCredentials(new UserIDImpl(dto.getUsuario()), dto.getPassword());
            MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU, credenciales));

            for (int i = 0; i < oids.length; i++) {
                UtilidadesLog.debug("oid: " + oids[i]);
                funcionLocal = funcionLH.findByPrimaryKey(oids[i]);
                UtilidadesLog.debug("a eliminar :" + oids[i]);
                funcionLH.remove(funcionLocal);
                i18.eliminarTraducciones("MEN_FUNCI", oids[i]);
                RoleImpl riRol = new RoleImpl(oids[i].toString());
                mgumon.deleteRole(riRol);
            }

            UtilidadesLog.info("MONFuncionesMenuBean.elimina(DTOOIDs dto): Salida");

        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }
}
