/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.men;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.exception.MareSystemLevelException;
import es.indra.mare.common.mgu.MGUService;
import es.indra.mare.common.mgu.exception.MareMguInvalidCredentials;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mgu.manager.RoleImpl;
import es.indra.mare.common.mgu.manager.UserIDImpl;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.men.DTOEntradaBorrarUsuario;
import es.indra.sicc.dtos.men.DTOEntradaCambiarPais;
import es.indra.sicc.dtos.men.DTOEntradaCambiarPassword;
import es.indra.sicc.dtos.men.DTOEntradaConsultarUsuario;
import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusquedaUsuarios;
import es.indra.sicc.dtos.men.DTOEntradaInsertarUsuarios;
import es.indra.sicc.dtos.men.DTOIdentUsuario;
import es.indra.sicc.dtos.men.DTOSalidaDepartamentosPerfiles;
import es.indra.sicc.dtos.men.DTOSalidaMantenimientoUsuarios;
import es.indra.sicc.dtos.men.DTOEntradaMENSeguridad;
import es.indra.sicc.dtos.seg.DTOInternacional;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativasHome;
import es.indra.sicc.mgu.UserIDSICC;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

/**
 * Sistema:           Belcorp - SICC
 * Modulo:            MEN - Menu
 * Componente:        MONUsuarios - Clase Bean
 * Fecha:             17/10/2003
 * Observaciones:     El presente MON utiliza MGUMON para realizar la
 *                    administración de los usuarios del sistema SICC
 *
 * @version           2.0
 * @author            Pablo Daniel Iorio
 */
public class MONUsuariosBean implements SessionBean, IUsuarios {
    //private static final String NOMBRE_SERVICIO_MGUSERVICE = "MGUService"; //Nombre del servicio de MGU.

    /*
     * Definicion de atributos privados de clase
     */
    private SessionContext ctx;
    private BelcorpService belcorpService;
    //private MareCredentials crendenciales;

    //Arreglo con los campos clave
    private String[] campos = {
        new String("IdUsuario"), new String("ClaveAcceso"),
        new String("IndicacionClaveInicial") //, new String("Perfil")
    };

    //Arreglo con las longitudes de los campos clave
    private Integer[] longitudes = {
        new Integer(50), new Integer(20), new Integer(2), new Integer(50)
    };

    //Arreglo con las propiedades simples
    private String[] aCamposSimples = {
        new String("AccesoPorDefecto"), new String("ApellidoCasada"),
        new String("CanalPorDefecto"), new String("Departamento"),
        new String("Email"), new String("FechaFinalRastreo"),
        new String("FechaInicioRastreo"), new String("FechaSustitucionDesde"),
        new String("FechaSustitucionHasta"), //DMCO 303 new String("FormatoFecha"), new String("FormatoNumerico"), new String("FormatoNumericoSeparadorDecimales"), new String("FormatoNumericoSeparadorMiles"), 
        new String("IdentificadorPc"), new String("Idioma"),
        new String("IndicacionClaveInicial"), new String("MarcaPorDefecto"),
        new String("ObservacionesSustitucion"), new String("PaisDefecto"),
        new String("PantallaInicioAsociada"),
        new String("PeriodoValidezFechaDesde"),
        new String("PeriodoValidezFechaHasta"), new String("PrimerApellido"),
        new String("PrimerNombre"), new String("RastreoAcceso"),
        new String("RegionPorDefecto"), new String("SeccionDefecto"),
        new String("SegundoApellido"), new String("SegundoNombre"),
        new String("SociedadPorDefecto"), new String("SubaccesoPorDefecto"),
        new String("SubgerenciaVentasDefecto"), new String("TelefonoContacto"),
        new String("TerritorioPorDefecto"), new String("TipoUsuario"),
        new String("UsuarioHabilitado"), new String("UsuarioSustitucion"),
        new String("ZonaPorDefecto"), new String("indNDG"),
        new String("indAdmNDG")
    };

    //Arreglo con las propiedades multivaluadas
    private String[] aCamposMultiValor = {
        new String("Sociedad"), new String("Acceso"), new String("Canal"),
        new String("Marca"), new String("Pais"), new String("Region"),
        new String("Seccion"), new String("SubgerenciaVentas"),
        new String("SubnivelAcceso"), new String("Territorio"),
        new String("Zona")
    };

    public void ejbCreate() {
        UtilidadesLog.info("MONUsuariosBean.ejbCreate(): Entrada");
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " + mmsnfe.getMessage(), mmsnfe);
        }
        
        UtilidadesLog.info("MONUsuariosBean.ejbCreate(): Salida");
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
       * El método inserta un nuevo usuario en la base de datos utilizando el
       * módulo de gestión de usuariosde acuerdo a los parametros ingresados en el
       * dto de entrada. Dentro del dto se le pasa el userId, clave de acceso,
       * rol/es y propiedad/es.
       * precondicion: que no este creado anteriormente
       *       
       * @return void
       * @throws MareException
      */
    public void createUsuario(DTOEntradaInsertarUsuarios dtoe) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.createUsuario(DTOEntradaInsertarUsuarios dtoe): Entrada");
        
        String codigoError;

        /*
         * Se valida que en el dto de entrada esten el id de usuario, la clave de
         * acceso, la indicacion si es incial y el perfil
         */
        if (!this.validaCamposObligatorios(dtoe)) {
            this.ctx.setRollbackOnly();
            UtilidadesLog.info("MONUsuariosBean.createUsuario(DTOEntradaInsertarUsuarios dtoe): Salida");
            codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        /*
         * Se crea un UserIDSICC a partir del DTOEntrada.idUsuario
         */
        String idUsuario = dtoe.getIdUsuario().toUpperCase();
        UserIDSICC userIdSicc = new UserIDSICC(idUsuario);


        //Se instancia el MGUMON
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dtoe.getUsuario()),dtoe.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));

        /*
         * Obtencion del Rol
         */
        Collection cRoles = new ArrayList();

        //if(!((dtoe.getTipoUsuario() == null) ? "" : dtoe.getTipoUsuario()).equalsIgnoreCase("BATCH")) {
        cRoles.add(new RoleImpl("JNDIUsers"));
        cRoles.add(new RoleImpl("RMIUsers"));

        Iterator aux = dtoe.getPerfil().iterator();

        while (aux.hasNext())
            cRoles.add(new RoleImpl((String) aux.next()));

        //}

        /*
         * Carga de los campos simples en propiedades simples
         */
        Collection cPropiedades = null;

        try {
            cPropiedades = this.cargarPropiedades(dtoe);
        } catch (MareException e) {
            UtilidadesLog.error(e);		
            this.ctx.setRollbackOnly();
            throw e;
        }

        /*
         * Creacion de un usuario
         */
        try {
            mgumon.createUser(userIdSicc, //Usuario
                dtoe.getClaveAcceso(), //Clave de Acceso
                cRoles, //Roles asignados
                cPropiedades); //Propiedades asignadas
        } catch (Exception me) {
            if (me.getCause() instanceof EJBException) {                
                throw new MareException(me, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
            } else {
                throw new MareException(me, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        
        UtilidadesLog.info("MONUsuariosBean.createUsuario(DTOEntradaInsertarUsuarios dtoe): Salida");
    }

    /**
       * El método modifica alguno de los parámetros del usuario
       * preCondicion: Que exista el usuario
       *       
       * @return void
       * @throws MareException
      */
    public void modificarUsuario(DTOEntradaInsertarUsuarios dtoe) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.modificarUsuario(DTOEntradaInsertarUsuarios dtoe): Entrada");
      
        String codigoError;

        /*
         * Se crea un UserIDSICC a partir del DTOEntrada.idUsuario
         */
        if ((dtoe.getIdUsuario() == "") || (dtoe.getIdUsuario() == null)) {
            this.ctx.setRollbackOnly();
            UtilidadesLog.info("MONUsuariosBean.modificarUsuario(DTOEntradaInsertarUsuarios dtoe): Salida");
            throw new MareException("Se produjo un error en la aplicación. " + "No se encontro el ID de usuario.");
        }
        //Usuario de Sustitucion.
        //final Property userP = (Property) propiedasdesMGU.get("TipoUsuario");
        //String tipoUsuar = (String)userP.getValue();
        //UtilidadesLog.debug(tipoUsuar);

        String idUsuario = dtoe.getIdUsuario();
        UserIDSICC userIdSicc = new UserIDSICC(idUsuario);        

        //Se localiza el MGUMON
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dtoe.getUsuario()),dtoe.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));

        //enozigli 8/8/8 - 20080684
        boolean paso = false;        
        try {
            String sPassword = ((dtoe.getClaveAcceso() == null) ? "" : dtoe.getClaveAcceso());
            
            if (!sPassword.equals("")) {
                // Modificado por HRCS - Incidencia Sicc20080572
                //mgumon.setPassword(userIdSicc, sPassword);
                 //enozigli 8/8/8 - 20080684
                paso = true;
                mgumon.setPassword(userIdSicc, sPassword, (dtoe.getString("UsuarioHabilitado")).equals("S")?Boolean.FALSE:Boolean.TRUE);
            }
        }catch(MareMguInvalidCredentials mgue){ 
            if (mgue.getCode() == MareMguInvalidCredentials.EXPIRED) {
                UtilidadesLog.info("MONUsuariosBean.modificarUsuario(DTOEntradaInsertarUsuarios dtoe): Salida");
                codigoError = CodigosError.ERROR_CLAVE_CADUCADA;
                throw new MareException(mgue, UtilidadesError.armarCodigoError(codigoError));
            }

            if (mgue.getCode() == MareMguInvalidCredentials.IN_HISTORY) {
                UtilidadesLog.info("MONUsuariosBean.modificarUsuario(DTOEntradaInsertarUsuarios dtoe): Salida");
                codigoError = CodigosError.ERROR_CLAVE_UTILIZADA;
                throw new MareException(mgue, UtilidadesError.armarCodigoError(codigoError));
            }

            if (mgue.getCode() == MareMguInvalidCredentials.LOW_QUALITY) {
                UtilidadesLog.info("MONUsuariosBean.modificarUsuario(DTOEntradaInsertarUsuarios dtoe): Salida");
                codigoError = CodigosError.ERROR_CLAVE_TRIVIAL;
                throw new MareException(mgue, UtilidadesError.armarCodigoError(codigoError));
            }
        }catch (MareException re) {
            MareMguInvalidCredentials mgue = null;
            if(re.getCause()!=null && re.getCause() instanceof MareMguInvalidCredentials){
                mgue = (MareMguInvalidCredentials) re.getCause();
            }
            
            if(mgue==null){
                throw re;
            }
            if (mgue.getCode() == MareMguInvalidCredentials.EXPIRED) {
                UtilidadesLog.info("MONUsuariosBean.modificarUsuario(DTOEntradaInsertarUsuarios dtoe): Salida");
                codigoError = CodigosError.ERROR_CLAVE_CADUCADA;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }

            if (mgue.getCode() == MareMguInvalidCredentials.IN_HISTORY) {
                UtilidadesLog.info("MONUsuariosBean.modificarUsuario(DTOEntradaInsertarUsuarios dtoe): Salida");
                codigoError = CodigosError.ERROR_CLAVE_UTILIZADA;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }

            if (mgue.getCode() == MareMguInvalidCredentials.LOW_QUALITY) {
                UtilidadesLog.info("MONUsuariosBean.modificarUsuario(DTOEntradaInsertarUsuarios dtoe): Salida");
                codigoError = CodigosError.ERROR_CLAVE_TRIVIAL;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
            
        }

        /*
         * Obtencion del perfil
         */
        RecordSet rsPerfil = new RecordSet();
        String sQueryPerfil = "SELECT p.name " + "FROM memberof m, principals p " + "WHERE m.idrole IN " + "(SELECT p.idprincipal FROM principals p, principals p2, memberof m1 " + "where p2.name = 'PerfilesSICC' and m1.idmember = p2.idprincipal and " + "m1.idrole = p.idprincipal) " + "and m.idmember = " + "(SELECT p.idprincipal FROM principals p where p.name = '" + idUsuario + "') " + "and m.idrole = p.idprincipal ";

        try {
            rsPerfil = belcorpService.dbService.executeStaticQuery(sQueryPerfil);
        } catch (MareSystemLevelException e) {
            throw new EJBException("Error de base de datos", e);
        } catch (MareException me) {
            UtilidadesLog.error(me);		
            ctx.setRollbackOnly();
            throw me;
        } catch (Exception e) {
            throw new EJBException(e);
        }

        /*
         * Modificacion del perfil
         */
        HashSet hsRoles = null;

        try {
            hsRoles = (HashSet)mgumon.getRoles(new UserIDSICC(idUsuario));

            //Se eliminar los perfiles anteriores
            Iterator it2 = rsPerfil.getRecords().listIterator();

            while (it2.hasNext()) {
                String vec = (String) ((Vector) it2.next()).get(0);

                if (hsRoles.contains(new RoleImpl(vec))) {
                    mgumon.removeRole(new UserIDSICC(idUsuario), new RoleImpl(vec));
                }
            }

            Iterator aux = dtoe.getPerfil().iterator();

            while (aux.hasNext()) {
                String perf = (String) aux.next();
                mgumon.grantRole(userIdSicc, new RoleImpl(perf));
            }
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_ROLES;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        /*
         * Modificacion de propiedades simples
         */
        HashMap hmCamposFecha = new HashMap();
        hmCamposFecha.put(new String("FechaSustitucionDesde"), dtoe.getFechaSustitucionDesde());
        hmCamposFecha.put(new String("FechaSustitucionHasta"), dtoe.getFechaSustitucionHasta());
        hmCamposFecha.put(new String("FechaInicioRastreo"), dtoe.getFechaInicioRastreo());
        hmCamposFecha.put(new String("FechaFinalRastreo"), dtoe.getFechaFinalRastreo());
        hmCamposFecha.put(new String("PeriodoValidezFechaDesde"), dtoe.getPeriodoValidezFechaDesde());
        hmCamposFecha.put(new String("PeriodoValidezFechaHasta"), dtoe.getPeriodoValidezFechaHasta());

        for (int i = 0; i < this.aCamposSimples.length; i++) {
            try {
                if (!(hmCamposFecha.containsKey((String) this.aCamposSimples[i]))) {
                    mgumon.setProperty(userIdSicc, new Property(this.aCamposSimples[i], ((dtoe.getString(this.aCamposSimples[i]) == null) ? "" : dtoe.getString(this.aCamposSimples[i]))));
                                        
                     //enozigli 8/8/8 - 20080684
                    if (!paso) {
                        /* Modificado Incidencia Sicc20080572*/
                        UtilidadesLog.debug("this.aCamposSimples[i]: " + this.aCamposSimples[i]);
                        // Se bloquea o desbloquea el usuario segun el seteo de habilitacion del usuario
                        if(this.aCamposSimples[i].equals("UsuarioHabilitado")){
                            UtilidadesLog.debug("dtoe.getString(this.aCamposSimples[i]): " + dtoe.getString(this.aCamposSimples[i]));
                            this.setBlocked(idUsuario, (dtoe.getString(this.aCamposSimples[i]).equals("S")?Boolean.FALSE:Boolean.TRUE));
                        }
                    }
                }
            } catch (Exception e) {
                throw new EJBException(e);
            }
        }

        //**** INI - Conversión fechas usuario a long ****//
        String formatoFecha = dtoe.getFormatoFecha();
        formatoFecha = formatoFecha.replace('m', 'M'); //minute por MONTH, viene solo fecha.

        SimpleDateFormat simpledateformat = new SimpleDateFormat(formatoFecha);

        java.util.Date dFechaTmp;
        long lFechaTmp;

        Iterator it = hmCamposFecha.keySet().iterator();
        String clave = null;        

        while (it.hasNext()) {
            clave = (String) it.next();

            if ((((String) hmCamposFecha.get(clave)) != null) && (!((String) hmCamposFecha.get(clave)).equals(""))) {
                try {
                    dFechaTmp = simpledateformat.parse(((String) hmCamposFecha.get(clave)));
                    lFechaTmp = dFechaTmp.getTime();
                    mgumon.setProperty(userIdSicc, new Property(clave, "" + lFechaTmp));
                } catch (Exception e) {
                    throw new EJBException(e);
                }
            }
        }

        //**** FIN - Conversión fechas usuario a long ****//

        /*
         * Modificacion de las propiedades multivaluadas
         */
        for (int j = 0; j < this.aCamposMultiValor.length; j++) {
            ArrayList values = new ArrayList();
            String sValorCampo = ((dtoe.getString(this.aCamposMultiValor[j]) == null) ? "" : dtoe.getString(this.aCamposMultiValor[j]));

            while ((sValorCampo.indexOf("|") != -1) && (sValorCampo != "")) {
                int iPosicion = sValorCampo.indexOf("|");
                String sParteInicial = sValorCampo.substring(0, iPosicion);
                String sParteFinal = sValorCampo.substring(iPosicion + 1);
                sValorCampo = sParteFinal;
                values.add(new String(sParteInicial));
            }

            if (sValorCampo.length() > 0) {
                values.add(new String(sValorCampo));
            }

            try {
                mgumon.setProperty(userIdSicc, new Property(this.aCamposMultiValor[j], values));
            } catch (Exception e) {
                codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
        }
        
        UtilidadesLog.info("MONUsuariosBean.modificarUsuario(DTOEntradaInsertarUsuarios dtoe): Salida");
    }

    /**
       * El método elimina un usuario de la base de datos utilizando el módulo de
       * gestión de usuarios.
       * preCondicion: Que el usuario a eliminar exista
       *       
       * @return void
       * @throws MareException
      */
    public void removeUsuario(DTOEntradaBorrarUsuario dtoe) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.removeUsuario(DTOEntradaBorrarUsuario dtoe)): Entrada");
        
        String codigoError;

        /*
         * Se crea un UserIDSICC a partir del DTOEntrada.idUsuario
         */
        if ((dtoe.getIdUsuario() == "") || (dtoe.getIdUsuario() == null)) {
            UtilidadesLog.info("MONUsuariosBean.removeUsuario(DTOEntradaBorrarUsuario dtoe): Salida");
            this.ctx.setRollbackOnly();
            throw new MareException("Se produjo un error en la aplicación. " + "No se encontro el ID de usuario.");
        }

        String idUsuario = dtoe.getIdUsuario();
        UserIDSICC userIdSicc = new UserIDSICC(idUsuario);
        
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dtoe.getUsuario()),dtoe.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));
        try {
            //Se elimina el usuario
            mgumon.removeUser(userIdSicc);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONUsuariosBean.removeUsuario(DTOEntradaBorrarUsuario dtoe): Salida");
    }

    /**
       * El método realiza una busqueda de los usuarios que correspondan con los
       * argumentos enviados en el dto de entrada
       *       
       * @return DTOSalida
       * @throws MareException
      */
    public DTOSalida buscarUsuario(DTOEntradaCriteriosDeBusquedaUsuarios dtoe) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.buscarUsuario(DTOEntradaCriteriosDeBusquedaUsuarios dtoe): Entrada");
        
        RecordSet rsUsuarios = null;
        String codigoError;

        /*
         * Obtencion de datos del dto de entrada
         */
        String sIdUsuario = ((dtoe.getIdUsuario() == null) ? "" : dtoe.getIdUsuario().toUpperCase());
        String sPrimerApellido = ((dtoe.getApellidoUsuario1() == null) ? "" : dtoe.getApellidoUsuario1());
        String sSegundoApellido = ((dtoe.getApellidoUsuario2() == null) ? "" : dtoe.getApellidoUsuario2());
        String sPrimerNombre = ((dtoe.getNombreUsuario1() == null) ? "" : dtoe.getNombreUsuario1());
        String sSegundoNombre = ((dtoe.getNombreUsuario2() == null) ? "" : dtoe.getNombreUsuario2());
        String sTelefono = ((dtoe.getTelefonoContacto() == null) ? "" : dtoe.getTelefonoContacto());
        String sDepartamento = ((dtoe.getDepartamento() == null) ? "" : dtoe.getDepartamento());
        String sValidaezHasta = ((dtoe.getValidezHasta() == null) ? "" : dtoe.getValidezHasta());
        String sValidaezDesde = ((dtoe.getValidezDesde() == null) ? "" : dtoe.getValidezDesde());
        String sTipoUsuario = ((dtoe.getTipoUsuario() == null) ? "" : dtoe.getTipoUsuario());
        String sHabilitado = ((dtoe.getUsuarioHabilitado() == null) ? "" : dtoe.getUsuarioHabilitado());
        String sPerfil = ((dtoe.getPerfil() == null) ? "" : dtoe.getPerfil());

        //**** INI - Conversión fechas usuario a long ****//
        String formatoFecha = dtoe.getFormatoFecha();
        formatoFecha = formatoFecha.replace('m', 'M'); //minute por MONTH, viene solo fecha.

        SimpleDateFormat simpledateformat = new SimpleDateFormat(formatoFecha);

        java.util.Date dFechaTmp;
        long lFechaTmp;

        try {
            if ((sValidaezDesde != null) && !(sValidaezDesde.equals(""))) {
                dFechaTmp = simpledateformat.parse(sValidaezDesde);
                lFechaTmp = dFechaTmp.getTime();
                sValidaezDesde = "" + lFechaTmp;
            }

            if ((sValidaezHasta != null) && !(sValidaezHasta.equals(""))) {
                dFechaTmp = simpledateformat.parse(sValidaezHasta);
                lFechaTmp = dFechaTmp.getTime();
                sValidaezHasta = "" + lFechaTmp;
            }
        } catch (Exception e) {
            throw new MareException(e);
        }

        //**** FIN - Conversión fechas usuario a long ****//
        String query = " SELECT * FROM ( " + " SELECT ROWNUM OID, u.nombreusuario, u.primerapellido, u.primernombre, u.tipousuario " + " FROM ( " + " SELECT  distinct  t1.NAME nombreUsuario, t2.stringvalue PrimerApellido, " + " t4.stringvalue PrimerNombre, t10.stringvalue TipoUsuario " + "from PRINCIPALS t1, PROPERTYVALUES t2, PROPERTYVALUES t3, " + "PROPERTYVALUES t4, PROPERTYVALUES t5,  PROPERTYVALUES t6," + "PROPERTYVALUES t7, PROPERTYVALUES t8,  PROPERTYVALUES t9," + "PROPERTYVALUES t10, PROPERTYVALUES t11, " + " (SELECT usuarios.NAME, perfiles.NAME perfil " + "  FROM memberof m, " + " (SELECT p.idprincipal, p.NAME " + " FROM users u, principals p " + " WHERE u.iduser = p.idprincipal) usuarios, " + " (SELECT p.idprincipal, p.NAME " + " FROM principals p, principals p2, memberof m " + " WHERE p2.NAME = 'PerfilesSICC' " + " AND m.idmember = p2.idprincipal " + " AND m.idrole = p.idprincipal) perfiles " + " WHERE m.idrole = perfiles.idprincipal " + " AND usuarios.idprincipal = m.idmember ";

        if (!sIdUsuario.equals("")) {
            query = query + " AND UPPER(usuarios.name) like replace( UPPER('" + sIdUsuario + "'), ";
            query = query + " '_', '/_') ESCAPE '/' ";
        } else {
            query = query + " AND usuarios.name like '%' ";
        }

        query = query + " UNION SELECT usuarios.NAME, '' perfil " + "  FROM memberof m, " + " (SELECT p.idprincipal, p.NAME " + " FROM users u, principals p " + " WHERE u.iduser = p.idprincipal) usuarios, " + " (SELECT p.idprincipal, p.NAME " + " FROM principals p, principals p2, memberof m " + " WHERE p2.NAME = 'PerfilesSICC' " + " AND m.idmember = p2.idprincipal " + " AND m.idrole = p.idprincipal) perfiles " + " WHERE usuarios.idprincipal not in (select distinct idmember from memberof)";

        if (!sIdUsuario.equals("")) {
            query = query + " AND UPPER(usuarios.name) like replace( UPPER('" + sIdUsuario + "'), ";
            query = query + " '_', '/_') ESCAPE '/' ) p1 ";
        } else {
            query = query + " AND usuarios.name like '%') p1 ";
        }

        query = query + "where t1.idprincipal = t2.idprincipal " + " and t2.idprincipal = t3.idprincipal " + " and t3.idprincipal = t4.idprincipal " + " and t4.idprincipal = t5.idprincipal " + " and t3.idprincipal = t6.idprincipal " + " and t4.idprincipal = t7.idprincipal " + " and t3.idprincipal = t8.idprincipal " + " and t4.idprincipal = t9.idprincipal " + " and t3.idprincipal = t10.idprincipal " + " and t4.idprincipal = t11.idprincipal " + " and t2.idproperty = '2' " + " and t3.idproperty = '3' " + " and t4.idproperty = '5' " + " and t5.idproperty = '6' " + " and t6.idproperty = '8' " + " and t7.idproperty = '9' " + " and t8.idproperty = '12' " + " and t9.idproperty = '11' " + " and t10.idproperty = '13' " + " and t11.idproperty = '23' " + "  AND t1.NAME = p1.name ";

        if (!sIdUsuario.equals("")) {
            query = query + " AND UPPER(t1.name) like replace( UPPER('" + sIdUsuario + "'), ";
            query = query + " '_', '/_') ESCAPE '/' ";
        } else {
            query = query + " and upper(t1.name) like upper('%') ";
        }

        if (!sPrimerApellido.equals("")) {
            query = query + " and upper(t2.stringvalue) like upper('" + sPrimerApellido + "') ";
        }

        if (!sSegundoApellido.equals("")) {
            query = query + " and upper(t3.stringvalue) like upper('" + sSegundoApellido + "') "; //SegundoApellido
        }

        if (!sPrimerNombre.equals("")) {
            query = query + " and upper(t4.stringvalue) like upper('" + sPrimerNombre + "')  "; //PrimerNombre
        }

        if (!sSegundoNombre.equals("")) {
            query = query + " and upper(t5.stringvalue) like upper('" + sSegundoNombre + "')  "; //SegundoNombre
        }

        if (!sTelefono.equals("")) {
            query = query + " and upper(t6.stringvalue) like upper('" + sTelefono + "')  "; //Telefono
        }

        if (!sDepartamento.equals("")) {
            query = query + " and upper(t7.stringvalue) like upper('" + sDepartamento + "')  "; //Departamento
        }

        if (!sValidaezHasta.equals("")) {
            query = query + " and upper(t8.stringvalue) like upper('" + sValidaezHasta + "')  ";
        }

        if (!sValidaezDesde.equals("")) {
            query = query + " and upper(t9.stringvalue) like upper('" + sValidaezDesde + "')  ";
        }

        if (!sTipoUsuario.equals("")) {
            query = query + " and upper(t10.stringvalue) like upper('" + sTipoUsuario + "')  ";
        }

        if (!sHabilitado.equals("")) {
            query = query + " and upper(t11.stringvalue) like upper('" + sHabilitado + "')  ";
        }

        ArrayList perfiles = new ArrayList();

        if (!sPerfil.equals("")) {
            StringTokenizer tokenizer = new StringTokenizer(sPerfil, "|");

            while (tokenizer.hasMoreTokens()) {
                perfiles.add(tokenizer.nextToken());
            }
        }

        if ((perfiles != null) && (perfiles.size() > 0)) {
            query = query + " and (";

            Iterator it = perfiles.iterator();

            while (it.hasNext())
                query = query + " upper(p1.PERFIL) like upper('" + it.next() + "') OR ";

            query = query + "1!=1 )";
        }

        query = query + " order by 1, 2, 3, 4) u" + " ORDER BY OID )" + " WHERE ROWNUM <= " + dtoe.getTamanioPagina() + " AND OID > " + dtoe.getIndicadorSituacion();

        try {
            rsUsuarios = belcorpService.dbService.executeStaticQuery(query);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (rsUsuarios.esVacio()) {
            UtilidadesLog.debug("ESTA VACIO " + rsUsuarios);
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        rsUsuarios.addColumn("Perfiles");

        for (int i = 0; i < rsUsuarios.getRowCount(); i++)
            rsUsuarios.setValueAt(obtenerPerfilConsulta((String) rsUsuarios.getValueAt(i, 1)), i, 5);

        UtilidadesLog.info("MONUsuariosBean.buscarUsuario(DTOEntradaCriteriosDeBusquedaUsuarios dtoe): Salida");
        return new DTOSalida(rsUsuarios);
    }

    /**
       * El método carga los atributos del dto de entrada en una Collection de
       * Properties. El método distingue entre campos simples y multivaluados
       *       
       * @return Collection
       * @throws MareException
      */
    private Collection cargarPropiedades(DTOEntradaInsertarUsuarios dtoe) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.cargarPropiedades(DTOBelcorp dtoe): Entrada");
        
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dtoe.getUsuario()),dtoe.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));

        /*
         * Se crea una coleccion con todas las propiedades
         */
        Collection cTodasProps = null;

        try {
            cTodasProps = mgumon.getProperties().values();
        } catch (Exception me) {
            throw new EJBException(me);
        }

        /*
         * Se crea una coleccion con las propiedades obtenidas del DTO
         */
        Collection cPropiedades = new ArrayList();

        HashMap hmCamposFecha = new HashMap();
        hmCamposFecha.put(new String("FechaSustitucionDesde"), dtoe.getFechaSustitucionDesde());
        hmCamposFecha.put(new String("FechaSustitucionHasta"), dtoe.getFechaSustitucionHasta());
        hmCamposFecha.put(new String("FechaInicioRastreo"), dtoe.getFechaInicioRastreo());
        hmCamposFecha.put(new String("FechaFinalRastreo"), dtoe.getFechaFinalRastreo());
        hmCamposFecha.put(new String("PeriodoValidezFechaDesde"), dtoe.getPeriodoValidezFechaDesde());
        hmCamposFecha.put(new String("PeriodoValidezFechaHasta"), dtoe.getPeriodoValidezFechaHasta());

        try {
            /*
             * Se setean las propiedades con un solo valor
             * Si no existe la propiedad se crea
             */
            for (int i = 0; i < this.aCamposSimples.length; i++) {
                if (!this.contienePropiedad(cTodasProps, this.aCamposSimples[i])) {
                    mgumon.createProperty(new Property(this.aCamposSimples[i], "Descripcion " + this.aCamposSimples[i]));
                }

                if (!(hmCamposFecha.containsKey((String) this.aCamposSimples[i]))) {
                    cPropiedades.add(new Property(this.aCamposSimples[i], ((dtoe.getString(this.aCamposSimples[i]) == null) ? "" : dtoe.getString(this.aCamposSimples[i]))));
                }
            }

            //**** INI - Conversión fechas usuario a long ****//
            String formatoFecha =  dtoe.getFormatoFecha();
            formatoFecha = formatoFecha.replace('m', 'M'); //minute por MONTH, viene solo fecha.

            SimpleDateFormat simpledateformat = new SimpleDateFormat(formatoFecha);

            java.util.Date dFechaTmp;
            long lFechaTmp;

            Iterator it = hmCamposFecha.keySet().iterator();
            String clave = null;            

            while (it.hasNext()) {
                clave = (String) it.next();

                if ((((String) hmCamposFecha.get(clave)) != null) && (!((String) hmCamposFecha.get(clave)).equals(""))) {
                    dFechaTmp = simpledateformat.parse(((String) hmCamposFecha.get(clave)));
                    lFechaTmp = dFechaTmp.getTime();
                    cPropiedades.add(new Property(clave, "" + lFechaTmp));
                }
            }

            //**** FIN - Conversión fechas usuario a long ****//

            /*
             * Se setean las propiedades con multi valor
             * Si no existe la propiedad se crea
             */
            for (int j = 0; j < this.aCamposMultiValor.length; j++) {
                if (!this.contienePropiedad(cTodasProps, this.aCamposMultiValor[j])) {
                    mgumon.createProperty(new Property(this.aCamposMultiValor[j], "Descripcion " + this.aCamposMultiValor[j], false, true, true));
                }

                ArrayList values = new ArrayList();
                String sValorCampo = ((dtoe.getString(this.aCamposMultiValor[j]) == null) ? "" : dtoe.getString(this.aCamposMultiValor[j]));

                while ((sValorCampo.indexOf("|") != -1) && (sValorCampo != "")) {
                    int iPosicion = sValorCampo.indexOf("|");
                    String sParteInicial = sValorCampo.substring(0, iPosicion);
                    String sParteFinal = sValorCampo.substring(iPosicion + 1);
                    sValorCampo = sParteFinal;
                    values.add(new String(sParteInicial));
                }

                if (sValorCampo.length() > 0) {
                    values.add(new String(sValorCampo));
                }

                cPropiedades.add(new Property(this.aCamposMultiValor[j], values));
            }
        } catch (Exception e) {
            throw new MareException(e);
        }

        UtilidadesLog.info("MONUsuariosBean.cargarPropiedades(DTOBelcorp dtoe): Salida");
        return cPropiedades;
    }

    /**
       * El método valida la nulidad y ausencia de los campos obligatorios para
       * insertar usuarios
       *       
       * @return boolean
       * @throws
      */
    private boolean validaCamposObligatorios(DTOEntradaInsertarUsuarios dtoe) {
        UtilidadesLog.info("MONUsuariosBean.validaCamposObligatorios(DTOBelcorp dtoe): Entrada");
        
        for (int i = 0; i < this.campos.length; i++) {
            if ((dtoe.getString(this.campos[i]) == null) || (dtoe.getString(this.campos[i]) == "")) {
                UtilidadesLog.info("MONUsuariosBean.validaCamposObligatorios(DTOBelcorp dtoe): Salida");
                return false;
            } else {
                Integer largo = new Integer(dtoe.getString(this.campos[i]).length());

                if (largo.intValue() > this.longitudes[i].intValue()) {
                    UtilidadesLog.info("MONUsuariosBean.validaCamposObligatorios(DTOBelcorp dtoe): Salida");
                    return false;
                }
            }
        }
        
        UtilidadesLog.info("MONUsuariosBean.validaCamposObligatorios(DTOBelcorp dtoe): Salida");
        return true;
    }

    /**
     * El método verifica si la colección (primer argumento) contiene la propidad
     * pasada como segundo argumento
     *     
     * @return boolean
     * @throws
    */
    private boolean contienePropiedad(Collection cPropiedades, String sPropiedad) {
        UtilidadesLog.info("MONUsuariosBean.contienePropiedad(Collection cPropiedades, String sPropiedad): Entrada");
        
        Iterator iterador = cPropiedades.iterator();

        while (iterador.hasNext()) {
            Property pPropiedad = (Property) iterador.next();

            if ((pPropiedad != null) && (pPropiedad.getName() != null)) {
                String valor = pPropiedad.getName().toString();

                if (valor.equals(sPropiedad)) {
                    UtilidadesLog.info("MONUsuariosBean.contienePropiedad(Collection cPropiedades, String sPropiedad): Salida");
                    return true;
                }
            }
        }

        UtilidadesLog.info("MONUsuariosBean.contienePropiedad(Collection cPropiedades, String sPropiedad): Salida");
        return false;
    }

    /**
       * El método consulta las propiedades del usuario recibido en el argumento
       * de entrada
       *       
       * @return DTOSalida
       * @throws MareException
      */
    public DTOSalida consultarUsuario(DTOEntradaConsultarUsuario dtoe) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.consultarUsuario(DTOEntradaConsultarUsuario dtoe): Entrada");

        /*
         * Se crea un UserIDSICC a partir del DTOEntrada.idUsuario
         */
        if ((dtoe.getIdUsuario() == "") || (dtoe.getIdUsuario() == null)) {
            this.ctx.setRollbackOnly();
            UtilidadesLog.info("MONUsuariosBean.consultarUsuario(DTOEntradaConsultarUsuario dtoe): Salida");
            throw new MareException("Se produjo un error en la aplicación. " + "No se encontro el ID de usuario.");
        }

        String idUsuario = dtoe.getIdUsuario();
        UserIDSICC userIdSicc = new UserIDSICC(idUsuario);
        
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dtoe.getUsuario()),dtoe.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));

        /*
         * Obtencion del perfil
         */
        RecordSet rsPerfil = new RecordSet();
        String sQueryPerfil = " SELECT perfiles.NAME  perfil" + " FROM memberof m, principals p, " + " (SELECT p.idprincipal, p.NAME " + " FROM principals p, principals p2, memberof m " + " WHERE p2.NAME = 'PerfilesSICC' " + " AND m.idmember = p2.idprincipal " + " AND m.idrole = p.idprincipal) perfiles " + " WHERE m.idrole = perfiles.idprincipal " + " AND p.idprincipal = m.idmember " + " AND p.NAME = '" + idUsuario + "'";

        try {
            rsPerfil = belcorpService.dbService.executeStaticQuery(sQueryPerfil);
        } catch (MareSystemLevelException e) {
            throw new EJBException("Error de base de datos", e);
        } catch (MareException me) {
            UtilidadesLog.error(me);		
            ctx.setRollbackOnly();
            throw me;
        } catch (Exception e) {
            throw new EJBException(e);
        }

        Vector vPerfiles = rsPerfil.getRecords();
        vPerfiles.trimToSize();

        Iterator it = vPerfiles.iterator();
        String sPerfil = "";

        while (it.hasNext()) {
            Vector perfil = (Vector) it.next();
            sPerfil += ("|" + perfil.elementAt(0));
        }

        if (sPerfil.length() > 1) {
            sPerfil = sPerfil.substring(1, sPerfil.length());
        }

        /*
         * Obtencion de las propiedades
         */
        HashMap hmPropiedades = null;

        try {
            hmPropiedades = (HashMap)mgumon.getProperties(userIdSicc);
        } catch (MareException me) {
            throw new EJBException("Se produjo un error de sistema." + "No se pudo obtener las propiedades del usuario.", me);
        }

        /*
         * Armado del RecordSet
         */
        RecordSet rsUsuarios = new RecordSet();
        rsUsuarios.addColumn("IdUsuario");
        rsUsuarios.addColumn("Perfil");

        for (int i = 0; i < this.aCamposSimples.length; i++)
            rsUsuarios.addColumn(this.aCamposSimples[i]);

        for (int j = 0; j < this.aCamposMultiValor.length; j++)
            rsUsuarios.addColumn(this.aCamposMultiValor[j]);

        /*
         * Armado de fila de datos
         */
        String sIdUsuario = dtoe.getIdUsuario();

        int iCamposAdicionales = 2; //idUsuario + perfil
        int largoArreglo = this.aCamposSimples.length + this.aCamposMultiValor.length + iCamposAdicionales;
        Object[] aFila = new Object[largoArreglo];

        for (int k = 0; k < largoArreglo; k++)
            aFila[k] = "";

        aFila[0] = new String(sIdUsuario);
        aFila[1] = new String(sPerfil);

        Integer iPosicion = null;

        for (int i = 0; i < this.aCamposSimples.length; i++) {
            if (hmPropiedades.containsKey(this.aCamposSimples[i])) {
                if (!this.aCamposSimples[i].equalsIgnoreCase("UsuarioSustitucion")) {
                    Property pPropiedad = (Property) hmPropiedades.get(this.aCamposSimples[i]);
                    aFila[i + iCamposAdicionales] = new String(((pPropiedad.getValue() == null) ? "" : pPropiedad.getValue().toString()));
                    UtilidadesLog.debug("no es usuario sus " + this.aCamposSimples[i]);
                    UtilidadesLog.debug(aFila[i + iCamposAdicionales]);
                    iPosicion = new Integer(i + 1);
                } else {
                    Property pPropiedad = (Property) hmPropiedades.get(this.aCamposSimples[i]);
                    aFila[i + iCamposAdicionales] = obtenerNombreyApellidos((String) pPropiedad.getValue());
                    UtilidadesLog.debug("es usuer sustit " + this.aCamposSimples[i]);
                    UtilidadesLog.debug(aFila[i + iCamposAdicionales]);
                    iPosicion = new Integer(i + 1);
                }
            }
        }

        for (int j = 0; j < this.aCamposMultiValor.length; j++) {
            if (hmPropiedades.containsKey(this.aCamposMultiValor[j])) {
                Property pPropiedad = (Property) hmPropiedades.get(this.aCamposMultiValor[j]);
                String sValorProp = new String(((pPropiedad.getValue() == null) ? "" : pPropiedad.getValue().toString()));

                if (sValorProp != "") {
                    String sValorCampo = "";

                    if (sValorProp.startsWith("[")) {
                        sValorCampo = sValorProp.substring(1, sValorProp.length() - 1);
                    }

                    int iPosicionComa = 0;

                    while ((sValorCampo.indexOf(",") != -1) && (sValorCampo != "")) {
                        iPosicionComa = sValorCampo.indexOf(",");

                        String sParteInicial = sValorCampo.substring(0, iPosicionComa);
                        String sParteFinal = sValorCampo.substring(iPosicionComa + 1);
                        sValorCampo = sParteFinal;
                        aFila[j + iPosicion.intValue() + iCamposAdicionales] = aFila[j + iPosicion.intValue() + iCamposAdicionales] + (new String(sParteInicial)).trim() + "|";
                    }

                    if (sValorCampo.length() > 0) {
                        aFila[j + iPosicion.intValue() + iCamposAdicionales] = aFila[j + iPosicion.intValue() + iCamposAdicionales] + (new String(sValorCampo)).trim();
                    }
                }
            }
        }

        rsUsuarios.addRow(aFila);
        UtilidadesLog.debug(rsUsuarios.toStringTabFormat());

        /*
         * Armado de retorno de datos
         */
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rsUsuarios);
        UtilidadesLog.debug(dtos);
        
        UtilidadesLog.info("MONUsuariosBean.consultarUsuario(DTOEntradaConsultarUsuario dtoe)): Salida");

        return dtos;
    }

    public DTOSalidaDepartamentosPerfiles preparaMantenimientoBusqueda(Long idioma) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.preparaMantenimientoBusqueda(Long idioma): Entrada");

        String codigoError;
        DTOInternacional dtoe;

        MONPerfilesHome monPerfilesHome;
        MONMantenimientoSEGHome monSegHome;

        DTOSalidaDepartamentosPerfiles dtos = new DTOSalidaDepartamentosPerfiles();

        try {
            monPerfilesHome = (MONPerfilesHome) belcorpService.ejbLocator.getHome("MONPerfiles", MONPerfilesHome.class);
            monSegHome = (MONMantenimientoSEGHome) belcorpService.ejbLocator.getHome("MONMantenimientoSEG", MONMantenimientoSEGHome.class);
        } catch (MareServiceException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            dtoe = new DTOInternacional();
            dtoe.setOidIdioma(idioma);
            dtos.setDepartamentos(monSegHome.create().recuperarDepartamentos(dtoe).getResultado());
            dtos.setPerfiles(monPerfilesHome.create().recuperaTodos());
        } catch (RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUsuariosBean.preparaMantenimientoBusqueda(Long idioma): Salida");
        return dtos;
    }

    public DTOSalidaMantenimientoUsuarios prepararMantenimiento(DTOEntradaMENSeguridad dtoe) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.prepararMantenimiento(Long idioma): Entrada");

        String codigoError;
        DTOInternacional dtoInt;
        DTOUnidadAdministrativa dtoUA = new DTOUnidadAdministrativa();

        MONMantenimientoSEGHome monSegHome;
        MONPerfilesHome monPerfilesHome;
        MONUnidadesAdministrativasHome monUnidAdm;

        DTOSalidaMantenimientoUsuarios dtos = new DTOSalidaMantenimientoUsuarios();

        try {
            monSegHome = (MONMantenimientoSEGHome) belcorpService.ejbLocator.getHome("MONMantenimientoSEG", MONMantenimientoSEGHome.class);
            monPerfilesHome = (MONPerfilesHome) belcorpService.ejbLocator.getHome("MONPerfiles", MONPerfilesHome.class);
            monUnidAdm = (MONUnidadesAdministrativasHome) belcorpService.ejbLocator.getHome("MONUnidadesAdministrativas", MONUnidadesAdministrativasHome.class);
        } catch (MareServiceException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            MONMantenimientoSEG monSeg = monSegHome.create();
            dtoInt = new DTOInternacional();
            dtoInt.setOidIdioma(dtoe.getIdioma());

            DTOOID dtooid = new DTOOID();
            dtooid.setOidIdioma(dtoe.getIdioma());

            dtos.setAccesos(monSeg.obtenerAccesosSinFiltro(dtooid).getResultado());
            dtos.setSubaccesos(monSeg.obtenerSubaccesosSinFiltro(dtooid).getResultado());
            dtos.setSubgerencias(monUnidAdm.create().obtenerSubgerenciaVentasSinFiltro(dtoUA));
            dtos.setRegiones(monUnidAdm.create().obtenerRegionesSinFiltro(dtoUA));
            dtos.setSecciones(monUnidAdm.create().obtenerSeccionesSinFiltro(dtoUA));
            dtos.setZonas(monUnidAdm.create().obtenerZonasSinFiltro(dtoUA));
            dtos.setTerritorios(monUnidAdm.create().obtenerTerritoriosSinFiltro(dtoUA));
        } catch (RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        /*
         * Obtencion de usuarios
         */
        
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dtoe.getUsuario()),dtoe.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));

        RecordSet rsUsuarios = new RecordSet();

        StringBuffer sQueryUsuarios = new StringBuffer("");
        boolean bHayUsuarios = false;

        try {
            Collection cUsuarios = mgumon.getUsers(null,null);
            Iterator iterador = cUsuarios.iterator();

            int nLoops = cUsuarios.size();

            // En el caso que no haya usuarios, devuelve un RecordSet Vacio
            if (nLoops == 0) {
                UtilidadesLog.debug("No hay usuarios");
                dtos.setUsuariosSustitucion(rsUsuarios);
            }

            // Si hay 1 unico usuario, chequea que no sea admin
            // antes de proseguir.
            if (nLoops == 1) {
                UtilidadesLog.debug("Hay un unico usuario - Debe chequear que no sea admin");

                UserIDImpl uUsuario = (UserIDImpl) iterador.next();
                String sNombreUsuario = uUsuario.getName();

                if (sNombreUsuario.equals("admin")) {
                    UtilidadesLog.debug("El usuario es admin");

                    // Devuelve RecordSet vacio.
                    // Setea esta condicion para que nunca traiga registros.
                    //sQueryUsuarios.append("AND (1=2) ");
                    //rsUsuarios = this.obtieneUsuarios(sQueryUsuarios);
                    UtilidadesLog.debug("rsUsuarios: " + rsUsuarios.toString());
                    dtos.setUsuariosSustitucion(rsUsuarios);

                    return dtos;
                }
            }

            iterador = cUsuarios.iterator();
            sQueryUsuarios.append("AND (");

            for (int i = 0; i < nLoops; i++) {
                UserIDImpl uUsuario = (UserIDImpl) iterador.next();
                String sNombreUsuario = uUsuario.getName();

                if ((i != 0) && (i != nLoops) && !sNombreUsuario.equals("admin") && !sQueryUsuarios.toString().equals("AND (")) {
                    sQueryUsuarios.append(" OR ");
                }

                //UtilidadesLog.debug("Nombre Usuario en Loop " + i + ": " + sNombreUsuario);
                if (!sNombreUsuario.equalsIgnoreCase("admin")) {
                    sQueryUsuarios.append("pp.name = '" + sNombreUsuario + "'");
                    bHayUsuarios = true; // Se setea a true para indicar mas adelante
                                         // que hay al menos 1 usuario distinto de "admin"
                }
            }

            sQueryUsuarios.append(")");
            UtilidadesLog.debug("sQueryUsuarios: " + sQueryUsuarios.toString());
            rsUsuarios = this.obtieneUsuarios(sQueryUsuarios);
            UtilidadesLog.debug("rsUsuarios: " + rsUsuarios.toString());

            dtos.setUsuariosSustitucion(rsUsuarios);

            UtilidadesLog.info("MONUsuariosBean.prepararMantenimiento(Long idioma): Salida");
            return dtos;
        } catch (Exception e) {
            throw new EJBException("Se produjo un " + "error. No se pudo recuperar los usuarios.", e);
        }
    }

    private RecordSet obtieneUsuarios(StringBuffer sQueryUsuarios) throws MareException, EJBException {
        UtilidadesLog.info("MONUsuariosBean.obtieneUsuarios(StringBuffer sQueryUsuarios): Entrada");
        
        /*
         *  Llamado por prepararMantenimiento, recibe una parte de la Query
         *  que obtiene un recordset con formato "username, Apellido, Nombre" x tupla.
         */
        RecordSet rsUsuarios = new RecordSet();
        StringBuffer sQuery = new StringBuffer("");

        // ***********************
        //   Arma la Query mayor.
        // ***********************
        sQuery.append(" SELECT DISTINCT apellido.NAME, nombre.nombre APE, apellido.ape || '  ' || apellido2.ape2 NOMBRE ");
        sQuery.append("FROM ");
        sQuery.append("(SELECT pp.NAME, pp.idprincipal AS ID, pv.stringvalue AS ape ");
        sQuery.append("FROM propertyvalues pv, principals pp ");
        sQuery.append("WHERE pv.idproperty = '2' ");
        sQuery.append("AND (pv.idprincipal = pp.idprincipal) ");
        sQuery.append(sQueryUsuarios.toString());
        sQuery.append(") apellido, ");
        sQuery.append("(SELECT pp.NAME, pp.idprincipal AS ID, pv.stringvalue AS ape2 ");
        sQuery.append("FROM propertyvalues pv, principals pp ");
        sQuery.append("WHERE pv.idproperty = '3' ");
        sQuery.append("AND (pv.idprincipal = pp.idprincipal) ");
        sQuery.append(sQueryUsuarios.toString());
        sQuery.append(") apellido2, ");
        sQuery.append("(SELECT pp.NAME, pp.idprincipal AS ID, pv.stringvalue AS nombre ");
        sQuery.append("FROM propertyvalues pv, principals pp ");
        sQuery.append("WHERE pv.idproperty = '5' ");
        sQuery.append(" AND (pv.idprincipal = pp.idprincipal) ");
        sQuery.append(sQueryUsuarios.toString());
        sQuery.append(") nombre ");
        sQuery.append("WHERE nombre.ID = apellido.ID ");
        sQuery.append("  AND nombre.ID = apellido2.ID ");

        UtilidadesLog.debug("sQuery a invocar: " + sQuery.toString());

        try {
            rsUsuarios = belcorpService.dbService.executeStaticQuery(sQuery.toString());
        } catch (MareSystemLevelException e) {
            throw new EJBException("Error de base de datos", e);
        } catch (MareException me) {
            UtilidadesLog.error(me);		
            ctx.setRollbackOnly();
            throw me;
        } catch (Exception e) {
            throw new EJBException(e);
        }

        UtilidadesLog.debug("rsUsuarioS: " + rsUsuarios.toString());

        UtilidadesLog.info("MONUsuariosBean.obtieneUsuarios(StringBuffer sQueryUsuarios): Salida");
        return rsUsuarios;
    }

    public String modificaPaisDefecto(DTOEntradaCambiarPais dtoe) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.modificaPaisDefecto(DTOEntradaCambiarPais dtoe): Entrada");
        
        
        String codigoError;
        String codPais = "";
        String salida = "";

        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dtoe.getUsuario()),dtoe.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));

        codPais = dtoe.getNuevoPais().toString(); //No puede ser null		

        MONMantenimientoSEGHome monSegHome;

        try {
            monSegHome = (MONMantenimientoSEGHome) belcorpService.ejbLocator.getHome("MONMantenimientoSEG", MONMantenimientoSEGHome.class);

            MONMantenimientoSEG monSeg = monSegHome.create();
            DTOOID dto = new DTOOID();
            dto.setOid(new Long(dtoe.getNuevoPais().longValue()));
            dto.setOidIdioma(dtoe.getOidIdioma());

            RecordSet aux = monSeg.recuperarPais(dto).getResultado();
            salida = (String) aux.getValueAt(0, "VAL_URL");
        } catch (MareServiceException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONUsuariosBean.modificaPaisDefecto(DTOEntradaCambiarPais dtoe): Salida");
        return salida;
    }

    private String obtenerPerfilConsulta(String usuario) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.obtenerPerfilConsulta(String usuario): Entrada");
        
        String codigoError;
        RecordSet resul = new RecordSet();
        StringBuffer sQuery = new StringBuffer();
        StringBuffer salida = new StringBuffer();
        sQuery.append(" SELECT usuarios.NAME, perfiles.NAME perfil ");
        sQuery.append(" FROM memberof m, ");
        sQuery.append("  (SELECT p.idprincipal, p.NAME ");
        sQuery.append("  FROM users u, principals p ");
        sQuery.append("  WHERE u.iduser = p.idprincipal) usuarios, ");
        sQuery.append("  (SELECT p.idprincipal, p.NAME ");
        sQuery.append("  FROM principals p, principals p2, memberof m ");
        sQuery.append("  WHERE p2.NAME = 'PerfilesSICC' ");
        sQuery.append("   AND m.idmember = p2.idprincipal ");
        sQuery.append("   AND m.idrole = p.idprincipal) perfiles ");
        sQuery.append("  WHERE m.idrole = perfiles.idprincipal ");
        sQuery.append("  AND usuarios.idprincipal = m.idmember ");
        sQuery.append("  AND UPPER (usuarios.NAME) LIKE ");
        sQuery.append("  REPLACE (UPPER ('" + usuario + "'), '_', '/_') ESCAPE '/' ");

        try {
            resul = belcorpService.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        int lineas = resul.getRowCount();

        if (lineas > 0) {
            for (int i = 0; i < (lineas - 1); i++) {
                salida.append(resul.getValueAt(i, 1).toString());
                salida.append(", ");
            }

            salida.append(resul.getValueAt(lineas - 1, 1).toString());
        }

        UtilidadesLog.info("MONUsuariosBean.obtenerPerfilConsulta(String usuario): Salida");
        return salida.toString();
    }

    public String obtenerPaginaInicio(DTOEntradaMENSeguridad dtoe) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.obtenerPaginaInicio(): Entrada");

        
        HashSet roles = null;

        MareCredentials credenciales = new MareCredentials(new UserIDSICC(dtoe.getUsuario()), dtoe.getPassword());
        MGUService mgu = (MGUService) MareMii.getService(new MareTopic(MareMii.SERVICE_MGU, credenciales));
        roles = mgu.getRoles();

        //MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));
        Iterator it = roles.iterator();
        HashMap prop = null;
        RoleImpl rol = null;
        Property t = null;

        while (it.hasNext()) {
            rol = (RoleImpl) it.next();
            prop = (HashMap)mgu.getProperties(rol);
            t = (Property) prop.get(ConstantesMEN.PANTALLA_INICIO_PROPERTY);

            if (t != null) {
                UtilidadesLog.debug("estoy retornando " + t.getValue());
                UtilidadesLog.info("MONUsuariosBean.obtenerPaginaInicio(): Salida");
                return (String) t.getValue();
            }
        }

        UtilidadesLog.debug("estoy retornando null");

        UtilidadesLog.info("MONUsuariosBean.obtenerPaginaInicio(): Salida");
        return null;
    }

    private String obtenerNombreyApellidos(String usuario) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.obtenerNombreyApellidos(String usuario): Entrada");
        
        if ((usuario == null) || (usuario.equalsIgnoreCase(""))) {
            return "";
        }

        RecordSet resul = new RecordSet();
        StringBuffer sQuery = new StringBuffer();
        String salida = "";
        sQuery.append("SELECT DISTINCT apellido.NAME ||'|'|| nombre.nombre || ', ' || apellido.ape || '  ' || apellido2.ape2 APE	");
        sQuery.append("           FROM 	");
        sQuery.append("		       (SELECT pp.NAME, pp.idprincipal AS ID, pv.stringvalue AS ape	");
        sQuery.append("                   FROM propertyvalues pv, principals pp	");
        sQuery.append("                  WHERE pv.idproperty = '2'	");
        sQuery.append("                    AND (pv.idprincipal = pp.idprincipal)	");
        sQuery.append("                    AND (   pp.NAME = '" + usuario + "'	");
        sQuery.append("                        )) apellido,	");
        sQuery.append("		       (SELECT pp.NAME, pp.idprincipal AS ID, pv.stringvalue AS ape2	");
        sQuery.append("                   FROM propertyvalues pv, principals pp	");
        sQuery.append("                  WHERE pv.idproperty = '3'	");
        sQuery.append("                    AND (pv.idprincipal = pp.idprincipal)	");
        sQuery.append("                    AND (   pp.NAME = '" + usuario + "'	");
        sQuery.append("                        )) apellido2,	");
        sQuery.append("                (SELECT pp.NAME, pp.idprincipal AS ID,	");
        sQuery.append("                        pv.stringvalue AS nombre	");
        sQuery.append("                   FROM propertyvalues pv, principals pp	");
        sQuery.append("                  WHERE pv.idproperty = '5'	");
        sQuery.append("                    AND (pv.idprincipal = pp.idprincipal)	");
        sQuery.append("                    AND (   pp.NAME = '" + usuario + "'	");
        sQuery.append("                        )) nombre	");
        sQuery.append("          WHERE nombre.ID = apellido.ID	");
        sQuery.append("		    AND nombre.ID = apellido2.ID	");

        try {
            resul = belcorpService.dbService.executeStaticQuery(sQuery.toString());
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (!resul.esVacio()) {
            salida = (String) resul.getValueAt(0, 0);
        }

        UtilidadesLog.info("MONUsuariosBean.obtenerNombreyApellidos(String usuario): Salida");
        return salida;
    }
    
    /**
     * Busca usuario con "codigo usuario" ingresado, si encuentra lo retorna,
     * si no lo encuentra muestra mensaje correspondiente.
     */
    public DTOSalida obtenerUsuarios(DTOBelcorp dtoin) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.obtenerUsuarios(DTOBelcorp dtoin): Entrada");
        
        DAOUsuarios dao = new DAOUsuarios();
        
        return new DTOSalida(dao.consultaUsuarios(null, dtoin.getOidPais()));    
    }

    /**@Autor: Hugo A. Mansi
     * @Fecha: 03/11/2004
     * @DMCO: Ver Incidencia 9802
     * @Modifico: --
     * @Modificado: --
     * @Descripción: Llama al metodo DAOUsuarios.consultaCodUsuarios pasandole
     *               el dtoin.gerPais().
     *               Con el RecordSet recibido se crea un DTOSalida que retorna
     *               el metodo.
     * @Construido en Buenos Aires por INDRA-CDOS Rep. Argentina
     *
     */
    public DTOSalida obtenerCodUsuarios(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONUsuariosBean.obtenerCodUsuarios(DTOBelcorp dto): Entrada");
        
        DTOSalida dtoOut = new DTOSalida();
        DAOUsuarios miDao = new DAOUsuarios();
        dtoOut.setResultado(miDao.consultaCodUsuarios(dto.getOidPais()));
    
        UtilidadesLog.info("MONUsuariosBean.obtenerCodUsuarios(DTOBelcorp dto): Salida");
        return dtoOut;
    }

  public DTOIdentUsuario obtenerUsuario(DTOIdentUsuario dtoe) throws MareException {
    UtilidadesLog.info("MONUsuariosBean.obtenerUsuario(DTOIdentUsuario dtoe): Entrada");
    
    DAOUsuarios daoUsuarios = new DAOUsuarios();  
    DTOIdentUsuario dtoUsuario = daoUsuarios.obtenerUsuario(dtoe);   
    
    UtilidadesLog.info("MONUsuariosBean.obtenerUsuario(DTOIdentUsuario dtoe): Salida");
    return dtoUsuario;   
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       9/01/2006
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  private void setBlocked(String oidUsuario, Boolean blocked) throws MareException {
  
      UtilidadesLog.info("MONUsuariosBean.setBlocked(UserID userID, Boolean blocked): Entrada");
      UtilidadesLog.info("setBlocked (" + oidUsuario + ", " + blocked + ")");
        
      BelcorpService belcorpService = null;
      
      try {
          Vector params = new Vector(2);
          params.add(blocked);
          params.add(oidUsuario);
          belcorpService.getInstance().dbService.executePreparedUpdate("update USERS set BLOCKED = ? where IDUSER = (select IDPRINCIPAL from PRINCIPALS where NAME = ?)", params);
          
      } catch(Exception e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(
                                     CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      UtilidadesLog.info("MONUsuariosBean.setBlocked(UserID userID, Boolean blocked): Salida");
  }

  public DTOSalida recargarFuncionesMenu(DTOString dto) throws MareException {
         UtilidadesLog.info(" MONUsuariosBean.recargarFuncionesMenu(DTOString) : Entrada");	
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet(); 
         DTOSalida dtoS = new DTOSalida();
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
        query.append(" SELECT DISTINCT idioma.lp, idioma.funcionmen, p2.NAME n_member ");
        query.append("            FROM memberof m, ");
        query.append("                 principals p1, ");
        query.append("                 principals p2, ");
        query.append("                 (SELECT mf.oid_func OID, mf.val_nomb_prog lp, ");
        query.append("                         i.val_i18n funcionmen ");
        query.append("                    FROM men_funci mf, v_gen_i18n_sicc i ");
        query.append("                   WHERE mf.val_nomb_prog IS NOT NULL ");
        query.append("                     AND i.attr_enti = 'MEN_FUNCI' ");
        query.append("                     AND i.attr_num_atri = 1 ");
        query.append("                     AND i.idio_oid_idio =  " + dto.getOidIdioma());
        query.append("                     AND i.val_oid = mf.oid_func) idioma ");
        query.append("           WHERE p1.idprincipal = m.idrole ");
        query.append("             AND p2.idprincipal = m.idmember ");
        query.append("             AND TO_CHAR (idioma.OID) = TO_CHAR (p1.NAME) ");
        query.append("             AND p2.NAME in('" + convertirStringTOStringComasConComillas(dto.getCadena()) + "') ");
        query.append("        ORDER BY  3, 2 ");
                   
         try{
              rs = bs.dbService.executeStaticQuery(query.toString());    
         }catch (Exception e){
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(
                   CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
             
         UtilidadesLog.info("MONUsuariosBean.recargarFuncionesMenu(DTOString dto):Salida");
         dtoS.setResultado(rs);
         return dtoS;
    }
    
    private String convertirStringTOStringComasConComillas(String cadena) throws MareException {
       //Recibe un string separado por x y ldevuelve un string separado por comas
       StringTokenizer st = new StringTokenizer(cadena, "x");
       String cadenaSalida = new String();
       while (st.countTokens()> 0) {
          cadenaSalida = cadenaSalida + st.nextToken();
          if(cadenaSalida!=null){
             cadenaSalida = cadenaSalida + "','";
          }
       }
       
       cadenaSalida = cadenaSalida.substring(0, cadenaSalida.length() -3);
       return cadenaSalida;
    }    

    /**
     * Metodo para obtener los accesos filtrados por canales
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con Recorset que contien la informacion
     * @param dtoe con OIDs de canales de los que se desea sus accesos
     * @date 14/05/2007
     */
    public DTOSalida recargaAccesosScr(DTOString dtoe) throws MareException {
        return (new DAOUsuarios()).recargaAccesosScr(dtoe);
    }

    /**
     * Metodo para obtener los subaccesos filtrados por accesos, para la pantalla de mantenimiento de usuarios
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con Recorset que contien la informacion
     * @param dtoe con OIDs de los accesos de los que se desea sus subaccesos
     * @date 14/05/2007
     */
    public DTOSalida recargaSubAccesosScr(DTOString dtoe) throws MareException {
        return (new DAOUsuarios()).recargaSubAccesosScr(dtoe);
    }

    /**
     * Metodo para obtener las Sociedades filtradas por Paises
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de las sociedades filtradas por Pais
     * @param dtoe con OIDs de paises que serviran de filtro
     * @date 15/05/2007
     */
    public DTOSalida recargaSociedadesScr(DTOString dtoe) throws MareException {
        return (new DAOUsuarios()).recargaSociedadesScr(dtoe);
    }

    /**
     * Metodo para obtener las Sub Gerencias de Ventas filtradas por Paises, Marcas y Canales.
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de las subgerencias filtradas por Pais, Marca y Canal
     * @param dtoe con expresion de filtro para obtener subgerencias
     * @date 14/05/2007
     */
    public DTOSalida recargaSubGerenciasScr(DTOString dtoe) throws MareException {
        return (new DAOUsuarios()).recargaSubGerenciasScr(dtoe);
    }

    /**
     * Metodo para obtener las Regiones filtradas por SGVs
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de las Regiones
     * @param dtoe con OIDs de SGV que serviran de filtro
     * @date 15/05/2007
     */
    public DTOSalida recargaRegionesScr(DTOString dtoe) throws MareException {
        return (new DAOUsuarios()).recargaRegionesScr(dtoe);
    }

    /**
     * Metodo para obtener las Zonas filtradas por Regiones
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de las Zonas
     * @param dtoe con OIDs de regiones que serviran de filtro
     * @date 15/05/2007
     */
    public DTOSalida recargaZonasScr(DTOString dtoe) throws MareException {
        return (new DAOUsuarios()).recargaZonasScr(dtoe);
    }

    /**
     * Metodo para obtener las Secciones filtradas por Zonas
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de las Secciones
     * @param dtoe con OIDs de zonas que serviran de filtro
     * @date 15/05/2007
     */
    public DTOSalida recargaSeccionesScr(DTOString dtoe) throws MareException {
        return (new DAOUsuarios()).recargaSeccionesScr(dtoe);
    }

    /**
     * Metodo para obtener los Territorios filtrados por Secciones
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de los Territorios
     * @param dtoe con OIDs de secciones que serviran de filtro
     * @date 15/05/2007
     */
    public DTOSalida recargaTerritoriosPorSeccionesScr(DTOString dtoe) throws MareException {
        return (new DAOUsuarios()).recargaTerritoriosPorSeccionesScr(dtoe);
    }

    /**
     * Metodo para obtener los usuarios de sustitucion
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con informacion de los Territorios
     * @param dtoe con OIDs de secciones que serviran de filtro
     * @date 15/05/2007
     */
    public DTOSalida recuperaUsuariosSustitucion(DTOString dtoe) throws MareException {
        //if(dtoe.getCadena()==null){
        //    UtilidadesLog.debug("Recupera Usuario desde el contexto: ["+ctx.getCallerPrincipal().getName()+"]");
        //    dtoe.setCadena(ctx.getCallerPrincipal().getName());
        //}
        return (new DAOUsuarios()).recuperaUsuarios(dtoe);
    }
    
    /**
       * El método consulta las propiedades del usuario recibido en el argumento
       * de entrada y obtiene las descripciones de los OIDs relacionados
       *       
       * @return DTOSalida
       * @throws MareException
      */
    public DTOSalida consultarUsuario2(DTOEntradaConsultarUsuario dtoe) throws MareException {
        DTOSalida dtos = null;
        DAOUsuarios dao = new DAOUsuarios(ctx.getCallerPrincipal().getName());
        RecordSet rs1 = dao.consultarPerfilesUsuario(dtoe).getResultado();
        RecordSet rs2 = dao.consultarUsuario2(dtoe).getResultado();
        
        Object[] aObj = null;
        
        for(int i = 0; i < rs1.getRowCount(); i++){
            aObj = new Object[5];
            aObj[0]=new BigDecimal(-1);
            aObj[1]=new BigDecimal(0);
            aObj[2]=new String("Perfiles");
            aObj[3]=rs1.getValueAt(i,0);
            aObj[4]=rs1.getValueAt(i,0);
            rs2.addRow(aObj);
        }
        
        dtos = new DTOSalida(rs2);
        return dtos;
    }

    public HashMap getMergedProperties(DTOEntradaConsultarUsuario dtoe) throws MareException {
        MareCredentials credenciales = new MareCredentials(new UserIDSICC(dtoe.getUsuario()), dtoe.getPassword());
        MGUService mgu =(MGUService) MareMii.getService(new MareTopic(MareMii.SERVICE_MGU, credenciales));
        return mgu.getMergedProperties();
    }

    public HashMap getProperties(UserIDImpl usr) throws MareException {
        MareCredentials credenciales = new MareCredentials(usr, null);
        MGUService mgu =(MGUService) MareMii.getService(new MareTopic(MareMii.SERVICE_MGU, credenciales));
        return mgu.getProperties();
    }

    public void cambiarPassword(DTOEntradaCambiarPassword dtoe) throws MareException {
        UtilidadesLog.info(" MONUsuariosBean.cambiarPassword(DTOEntradaCambiarPassword) : Entrada");
        
        String newPass = (String)dtoe.getNewPass();
        String passConfirm = (String)dtoe.getNewPassConfirm();
        String usuario = dtoe.getUserName();
        String passwordActual = dtoe.getPassword();
        
        if(newPass==null || passConfirm==null || usuario==null){
            String codigoError = CodigosError.ERROR_PARAMETROS_INCORRECTOS;
            throw new MareException(new Exception("El password, el usuario y la confirmacion no pueden ser nulos"),
                                UtilidadesError.armarCodigoError(codigoError));
        }
        
        if(!newPass.equals(passConfirm)){
            String codigoError = CodigosError.ERROR_CLAVES_DISTINTAS;
            throw new MareException(new Exception("El password y la confirmacion deben ser identicos"),
                                UtilidadesError.armarCodigoError(codigoError));
        }
        
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(usuario), passwordActual);
        MGUService mgu = (MGUService) MareMii.getService(new MareTopic(MareMii.SERVICE_MGU, credenciales));
        mgu.setPassword(newPass);
        UtilidadesLog.info(" MONUsuariosBean.cambiarPassword(DTOEntradaCambiarPassword) : Salida");
    }

    public DTOSalida getProperties2(UserIDImpl usr) throws MareException {
        DTOSalida salida = new DTOSalida();
        salida.setProperty("propiedades",(Object)getProperties(usr));
        return salida;
    }
}
