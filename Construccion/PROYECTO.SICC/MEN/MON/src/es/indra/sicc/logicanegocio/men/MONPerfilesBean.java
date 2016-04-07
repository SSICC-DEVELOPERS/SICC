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
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mgu.manager.Role;
import es.indra.mare.common.mgu.manager.RoleImpl;
import es.indra.mare.common.mgu.manager.UserIDImpl;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.men.DTOCargaPerfil;
import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusqueda;
import es.indra.sicc.dtos.men.DTOEntradaEliminarPerfil;
import es.indra.sicc.dtos.men.DTOEntradaInsertarPerfiles;
import es.indra.sicc.dtos.men.DTOEntradaModificarPerfiles;
import es.indra.sicc.dtos.men.DTOPerfil;
import es.indra.sicc.dtos.men.DTOString;
import es.indra.sicc.dtos.men.DTOStrings;
import es.indra.sicc.entidades.men.FuncionLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.persistence.NoResultException;
import es.indra.sicc.dtos.men.DTOEntradaAgregarRoles;


/**
 * Sistema:          Belcorp - SICC
 * Modulo:           MEN - Menu
 * Componente:       MONPerfiles
 * Fecha:            07/04/2003
 * Dcoumentacion:    Este componente se construyó de acuerdo a los siguientes
 *                   documentos:
 *                   - SICC-DMCO-MEN-001-200 (publicado el 06/03/2003)
 * Observaciones:    El presente MON utiliza MGUMON para realizar la
 *                   administración de los perfiles de usuario del sistema SICC
 *
 * @version          1.0
 * @author           Pablo Daniel Iorio
 */
public class MONPerfilesBean implements SessionBean {
    private BelcorpService belcorpService;
    private SessionContext ctx;

    public void ejbCreate() {
        UtilidadesLog.info("MONPerfilesBean.ejbCreate(): Entrada");
        
        try {
            belcorpService = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " + mmsnfe.getMessage(), mmsnfe);
        }
        
        UtilidadesLog.info("MONPerfilesBean.ejbCreate(): Salida");
    }

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    /**
       * El método inserta un nuevo perfil en la base de datos utilizando el módulo
       * de gestión de usuarios de acuerdo a los parametros ingresados en el dto de
       * entrada.
       *
       * @return void
       * @throws MareException
      */
    public void createPerfiles(DTOEntradaInsertarPerfiles dtoe)
        throws MareException {
        
        UtilidadesLog.info("MONPerfilesBean.createPerfiles(DTOEntradaInsertarPerfiles dtoe): Entrada");
        
        String codigoError;
        /*
         * Validaciones del dto de entrada
         */
        if((dtoe.getNombreDePerfil() == null) || (dtoe.getNombreDePerfil() == "")) {            
            this.ctx.setRollbackOnly();
            UtilidadesLog.info("MONPerfilesBean.createPerfiles(DTOEntradaInsertarPerfiles dtoe): Salida");
            codigoError = CodigosError.ERROR_CAMPO_OBLIGATORIO_NO_DEFINIDO;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dtoe.getUsuario()),dtoe.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));


        /*
         * Se crea un Rol a partir del DTOEntrada.
         */
        String sNombrePerfil = dtoe.getNombreDePerfil();
        RoleImpl rRol = new RoleImpl(sNombrePerfil);

        /*
         * Se valida que no exista el rol
         */
        Collection cRoles = null;

        try {
            cRoles = mgumon.getRoles();
        } catch(Exception e) {
            throw new EJBException(e);
        }

        if(this.contieneRol(cRoles, sNombrePerfil)) {
            this.ctx.setRollbackOnly();
            UtilidadesLog.info("MONPerfilesBean.createPerfiles(DTOEntradaInsertarPerfiles dtoe): Salida");
            codigoError = CodigosError.ERROR_DE_CLAVE_DUPLICADA;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        ArrayList roles = new ArrayList();
        roles.add(new RoleImpl("1")); //Menu
        roles.add(new RoleImpl("2")); //Favoritas
        RecordSet rsFuncionPadre = new RecordSet();
        Vector vFuncionesAgregadas = new Vector();

        if(dtoe.getListaDeFuncionesAcciones() != null) {
            //Se crea una collection de roles asociados
            Vector vFuncionesAcciones = dtoe.getListaDeFuncionesAcciones();

            //Vector vFuncionesAcciones = new Vector();
            for(int i = 0; i < vFuncionesAcciones.size(); i++) {
                String sQueryFuncionPadre = "SELECT OID_FUNC FROM MEN_FUNCI " + " where oid_func <> 1 "
                    + " CONNECT BY PRIOR FUNC_OID_FUNC = OID_FUNC " + " START WITH OID_FUNC = " + vFuncionesAcciones.get(i).toString();

                try {
                    rsFuncionPadre = belcorpService.dbService.executeStaticQuery(sQueryFuncionPadre);
                } catch(Exception e) {
                    UtilidadesLog.error(e);		
                    ctx.setRollbackOnly();
                    codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                    throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                }

                Vector vFuncionPadre = rsFuncionPadre.getRecords();
                vFuncionPadre.trimToSize();

                String sFuncionPadre = "";

                // Recuperacion de padres del elemento de menu
                for(int counter = 0; counter < vFuncionPadre.size(); counter++) {
                    Vector vFila = (Vector)vFuncionPadre.get(counter);

                    if(vFila != null)
                        sFuncionPadre = ((vFila.get(0) == null) ? "" : vFila.get(0).toString());

                    if(!vFuncionesAgregadas.contains(sFuncionPadre)) {
                        roles.add(new RoleImpl(sFuncionPadre));
                        vFuncionesAgregadas.add(sFuncionPadre);
                    }
                }

                //fin del for recuperacion padres
            }

            //fin del for lista de funciones
        }

        //Se crea una collection de propiedades
        ArrayList properties = new ArrayList();

        /*
         * Obtiene todas las propiedades
         */
        Collection cPropiedades = null;

        try {
            cPropiedades = mgumon.getProperties().values();
        } catch(Exception e) {
            throw new EJBException(e);
        }

        /*
         * Seteo de la pantalla inicio de aplicacion asociada
         */
        if(!this.contienePropiedad(cPropiedades, "PantallaInicioDeAplicacionAsociada")){
            mgumon.createProperty(new Property("PantallaInicioDeAplicacionAsociada",
                    "Descripcion Pantalla de Inicio de Aplicacion Asociada"));
        }
                    
            
        if(dtoe.getPantallaInicioDeAplicacionAsociada() != null) {
            /*
             * Obtencion de la pantalla de incio
             */
            /*            String sQueryPantallaIncio = "select VAL_NOMB_PROG, I.VAL_I18N " +
                  " from men_funci F, V_gen_i18n_sicc I " +
                  " where I.ATTR_ENTI = 'MEN_FUNCI' " +
                  " and I.VAL_OID = F.OID_FUNC " +
                  " and I.IDIO_OID_IDIO = " + dtoe.getOidIdioma() +
                  " and F.oid_func = '" + dtoe.getPantallaInicioDeAplicacionAsociada() + "'";*/
            String sQueryPantallaIncio = "SELECT val_nomb_prog " + "  FROM men_funci f " + " where F.oid_func = '"
                + dtoe.getPantallaInicioDeAplicacionAsociada() + "'";

            RecordSet rsPantallaInicio = new RecordSet();

            try {
                rsPantallaInicio = belcorpService.dbService.executeStaticQuery(sQueryPantallaIncio);
            } catch(MareSystemLevelException e) {
                throw new EJBException("Error de base de datos", e);
            } catch(MareException me) {
                UtilidadesLog.error(me);		
                ctx.setRollbackOnly();
                throw me;
            } catch(Exception e) {
                throw new EJBException(e);
            }

            Vector vPantallaInicio = rsPantallaInicio.getRecords();
            vPantallaInicio.trimToSize();

            String sFuncionPantallaInicio = "";
            String sFuncionEjecutable = "";

            if(vPantallaInicio.size() == 1) {
                Vector vFilaPantallaIncio = (Vector)vPantallaInicio.firstElement();

                if(vFilaPantallaIncio != null) {
                    sFuncionPantallaInicio = vFilaPantallaIncio.get(0).toString();
                    //                    sFuncionEjecutable = vFilaPantallaIncio.get(1).toString();
                    //                    sFuncionEjecutable = dtoe.getPantallaInicioDeAplicacionAsociada();
                }
            }

            /*            if((sFuncionPantallaInicio != null) && !sFuncionPantallaInicio.equals(""))
                            properties.add(new Property("NombrePantallaInicioEjecutablePerfil", sFuncionPantallaInicio));
                        if((sFuncionEjecutable != null) && !sFuncionEjecutable.equals(""))
                            properties.add(new Property("PantallaInicioDeAplicacionAsociada", sFuncionEjecutable));
            */
            if((sFuncionEjecutable != null) && !sFuncionEjecutable.equals(""))
                properties.add(new Property("PantallaInicioDeAplicacionAsociada", sFuncionEjecutable));
        }

        /*
         * Se crea el rol
         */
        try {
            //Crea el rol que representa perfiles
            mgumon.createRole(rRol, roles, properties);
            //Asocia el rol creado a PerfilesSICC
            mgumon.grantRole(new RoleImpl("PerfilesSICC"), rRol);
        } catch(Exception e) {
            UtilidadesLog.error(e);		
            this.ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_DE_CLAVE_DUPLICADA;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONPerfilesBean.createPerfiles(DTOEntradaInsertarPerfiles dtoe): Salida");
    }

    /**
       * El método borra un perfil de acuerdo al nombre de perfil recibido en el
       * dto de entrada
       * preCondicion: que exista el perfil
       *       
       * @return void
       * @throws MareException
      */
    public void removePerfiles(DTOEntradaEliminarPerfil dtoe)
        throws MareException {
        
        UtilidadesLog.info("MONPerfilesBean.removePerfiles(DTOEntradaEliminarPerfil dtoe): Entrada");
        
        String codigoError;
        
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dtoe.getUsuario()),dtoe.getPassword());
        MGUService  mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));

        /*
         * Se crea un Rol a partir del DTOEntrada.
         */
        String sNombrePerfil = dtoe.getNombrePerfil();

        if((sNombrePerfil == null) || (sNombrePerfil == "")) {        
            this.ctx.setRollbackOnly();
            UtilidadesLog.info("MONPerfilesBean.removePerfiles(DTOEntradaEliminarPerfil dtoe): Salida");
            codigoError = CodigosError.ERROR_BORRADO_PERFIL;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        RoleImpl rRol = new RoleImpl(sNombrePerfil);

        /*
         * Se valida que exista el perfil a eliminar
         */
        Collection cRoles = null;

        try {
            cRoles = mgumon.getRoles();
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_ROLES;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        if(!this.contieneRol(cRoles, sNombrePerfil)) {
            this.ctx.setRollbackOnly();
            UtilidadesLog.info("MONPerfilesBean.removePerfiles(DTOEntradaEliminarPerfil dtoe): Salida");
            codigoError = CodigosError.ERROR_BORRADO_PERFIL;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        /*
         * Se elimina el perfil obtenido
         */
        try {
            RecordSet rsCantidadAsoc;
            String sQueryCantidadPerfilesAsociados = "select count(*) " + "from principals p, memberof m "
                + "where p.idprincipal = m.idrole and p.name = '" + sNombrePerfil + "'";

            try {
                rsCantidadAsoc = belcorpService.dbService.executeStaticQuery(sQueryCantidadPerfilesAsociados);
            } catch(Exception e) {
                UtilidadesLog.error(e);		
                ctx.setRollbackOnly();
                codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }

            Vector vCantidadAsoc = rsCantidadAsoc.getRecords();
            vCantidadAsoc.trimToSize();

            String sCantidadPerfilesAsociados = "";

            if(vCantidadAsoc.size() == 1) {
                Vector vFila = (Vector)vCantidadAsoc.firstElement();

                if(vFila != null)
                    sCantidadPerfilesAsociados = ((vFila.get(0) == null) ? "" : vFila.get(0).toString());
            }

            if(sCantidadPerfilesAsociados.equals("1"))
                mgumon.removeRole(rRol);
            else {
                codigoError = CodigosError.ERROR_BORRADO_PERFIL;
                throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
            }
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_BORRADO_PERFIL;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONPerfilesBean.removePerfiles(DTOEntradaEliminarPerfil dtoe): Salida");
    }

    /*
       * El método modifica las propiedades del perfil
       * preCondicion: que exista el perfil
       *
       * @param DTOEntradaModificarPerfiles dtoe
       * @return void
       * @throws MareException
      */
    public void modificarPerfiles(DTOEntradaModificarPerfiles dtoe)
        throws MareException {
        
        UtilidadesLog.info("MONPerfilesBean.modificarPerfiles(DTOEntradaModificarPerfiles dtoe): Entrada");
        
        String codigoError;
        
        //Se localiza el MGUMON
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dtoe.getUsuario()),dtoe.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));

        try {
            String sNombrePerfilNuevo = ((dtoe.getNombreDePerfil() == null) ? "" : dtoe.getNombreDePerfil());
            String sNombrePerfilViejo = ((dtoe.getNombreDePerfilViejo() == null) ? "" : dtoe.getNombreDePerfilViejo());

            RoleImpl rRolViejo = new RoleImpl(sNombrePerfilViejo);

            if(sNombrePerfilNuevo.equals(""))
                sNombrePerfilNuevo = sNombrePerfilViejo;

            RoleImpl rRolNuevo = new RoleImpl(sNombrePerfilNuevo);

            //Se procede a cambiar el nombre del rol
            mgumon.renameRole(rRolViejo, sNombrePerfilNuevo);

            //Se procede a establecer los roles del perfil
            RecordSet rsFuncionPadre = new RecordSet();
            Vector vFuncionesAgregadas = new Vector(); //Almacena las agregadas
            HashSet hsRoles = new HashSet();
            hsRoles.add(new RoleImpl("1")); //Menu
            hsRoles.add(new RoleImpl("2")); //Favoritas

            Vector vFunciones = dtoe.getListaDeFuncionesAcciones();
            vFunciones.trimToSize();

            for(int i = 0; i < vFunciones.size(); i++) {
                String sQueryFuncionPadre = "SELECT OID_FUNC FROM MEN_FUNCI " + " where oid_func <> 1 "
                    + " CONNECT BY PRIOR FUNC_OID_FUNC = OID_FUNC " + " START WITH OID_FUNC = " + vFunciones.get(i).toString();

                try {
                    rsFuncionPadre = belcorpService.dbService.executeStaticQuery(sQueryFuncionPadre);
                } catch(Exception e) {
                    UtilidadesLog.error(e);		
                    ctx.setRollbackOnly();
                    codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                    throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                }

                Vector vFuncionPadre = rsFuncionPadre.getRecords();
                vFuncionPadre.trimToSize();

                String sFuncionPadre = "";

                // Recuperacion de padres del elemento de menu
                for(int counter = 0; counter < vFuncionPadre.size(); counter++) {
                    Vector vFila = (Vector)vFuncionPadre.get(counter);

                    if(vFila != null)
                        sFuncionPadre = ((vFila.get(0) == null) ? "" : vFila.get(0).toString());

                    if(!vFuncionesAgregadas.contains(sFuncionPadre)) {
                        hsRoles.add(new RoleImpl(sFuncionPadre));
                        vFuncionesAgregadas.add(sFuncionPadre);
                    }
                }

                //fin del for recuperacion padres
            }

            //fin del for
            DTOEntradaAgregarRoles dtoAgregar = new DTOEntradaAgregarRoles();
            dtoAgregar.setPrincipal(rRolNuevo);
            dtoAgregar.setUsuario(dtoe.getUsuario());
            dtoAgregar.setPassword(dtoe.getPassword());
            this.setRoles(dtoAgregar, hsRoles);

            //Seteo de la pantalla inicio de aplicacion asociada
            //Se crea una collection de propiedades
            if((dtoe.getPantallaInicioDeAplicacionAsociada() != null) && !dtoe.getPantallaInicioDeAplicacionAsociada().equals("")) {
                // Obtencion de la pantalla de incio

                /*                String sQueryPantallaIncio = "select VAL_NOMB_PROG, I.VAL_I18N " +
                      " from men_funci F, V_gen_i18n_sicc I " +
                      " where I.ATTR_ENTI = 'MEN_FUNCI' " +
                      " and I.VAL_OID = F.OID_FUNC " +
                      " and I.IDIO_OID_IDIO = " + dtoe.getOidIdioma() +
                      " and F.oid_func = '" + dtoe.getPantallaInicioDeAplicacionAsociada() + "'";*/
                String sQueryPantallaIncio = "SELECT val_nomb_prog " + "  FROM men_funci f " + " where F.oid_func = '"
                    + dtoe.getPantallaInicioDeAplicacionAsociada() + "'";

                RecordSet rsPantallaInicio = new RecordSet();

                try {
                    rsPantallaInicio = belcorpService.dbService.executeStaticQuery(sQueryPantallaIncio);
                } catch(Exception e) {
                    UtilidadesLog.error(e);		
                    ctx.setRollbackOnly();
                    codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
                    throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                }

                Vector vPantallaInicio = rsPantallaInicio.getRecords();
                vPantallaInicio.trimToSize();

                String sFuncionPantallaInicio = "";
                String sFuncionEjecutable = "";

                if(vPantallaInicio.size() == 1) {
                    Vector vFilaPantallaIncio = (Vector)vPantallaInicio.firstElement();

                    if(vFilaPantallaIncio != null) {
                        sFuncionPantallaInicio = vFilaPantallaIncio.get(0).toString();
                        //                      sFuncionEjecutable = vFilaPantallaIncio.get(1).toString();
                        //                        sFuncionEjecutable = dtoe.getPantallaInicioDeAplicacionAsociada();
                    }
                }

                /*                if((sFuncionPantallaInicio != null) && !sFuncionPantallaInicio.equals(""))
                                    mgumon.setProperty(new UserIDImpl(sNombrePerfilNuevo),
                                        new Property("NombrePantallaInicioEjecutablePerfil", sFuncionPantallaInicio));
                                if((sFuncionEjecutable != null) && !sFuncionEjecutable.equals(""))
                                    mgumon.setProperty(new UserIDImpl(sNombrePerfilNuevo),
                                        new Property("PantallaInicioDeAplicacionAsociada", sFuncionEjecutable));*/
                if((sFuncionPantallaInicio != null) && !sFuncionPantallaInicio.equals(""))
                    mgumon.setProperty(new UserIDImpl(sNombrePerfilNuevo),
                        new Property("PantallaInicioDeAplicacionAsociada", sFuncionEjecutable));
            } else
                //No viene la pantalla de inicio
                //                mgumon.unSetProperty(new UserIDImpl(sNombrePerfilNuevo), new Property("NombrePantallaInicioEjecutablePerfil"));
                mgumon.unSetProperty(new UserIDImpl(sNombrePerfilNuevo), new Property("PantallaInicioDeAplicacionAsociada"));
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_CLAVE_DUPLICADA;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONPerfilesBean.modificarPerfiles(DTOEntradaModificarPerfiles dtoe): Salida");
    }

    /**
     * El método setea los roles del perfil
     *       
     * @return void
     * @throws MareException
     */
    public void setRoles(DTOEntradaAgregarRoles dto, HashSet roles) throws MareException {

        UtilidadesLog.info("MONPerfilesBean.setRoles(MarePrincipal principal, HashSet roles): Entrada");
        try {
            MareCredentials credenciales = new MareCredentials(new UserIDImpl(dto.getUsuario()),dto.getPassword());
            MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));
            mgumon.setRoles(dto.getPrincipal(),roles);
        } catch(Exception e) {
            UtilidadesLog.debug(e);
        }

        UtilidadesLog.info("MONPerfilesBean.setRoles(MarePrincipal principal, HashSet roles): Salida");
    }

    /**
     * El método busca los perfiles que coincidan con los parametros ingresados
     *       
     * @return DTOSalida
     * @throws MareException
     */
    public DTOSalida buscarPerfiles(DTOEntradaCriteriosDeBusqueda dtoe)
        throws MareException {
        
        UtilidadesLog.info("MONPerfilesBean.buscarPerfiles(DTOEntradaCriteriosDeBusqueda dtoe): Entrada");
        
        /*
         * Obtencion de roles que representan perfiles
         */
        RecordSet rsPerfiles = new RecordSet();
        String codigoError;

        String sNombrePerfil = (((dtoe.getNombrePerfil() == null) || dtoe.getNombrePerfil().equals("")) ? "%" : dtoe.getNombrePerfil());

        /*
         * Obtencion de datos del dto de entrada
         */
        String sPerfiles = "SELECT " + "p.idprincipal OID, p.NAME " + "FROM principals p, principals p2, memberof m "
            + "WHERE p2.name = 'PerfilesSICC' " + "and m.idmember = p2.idprincipal " + "and m.idrole = p.idprincipal "
            + "and upper (p.name) LIKE upper('" + sNombrePerfil + "') " + "order by OID ";

        try {
            rsPerfiles = belcorpService.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(sPerfiles, dtoe));
        } catch(Exception e) {
            UtilidadesLog.error(e);		
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if(rsPerfiles.esVacio()) {
            UtilidadesLog.info("MONPerfilesBean.buscarPerfiles(DTOEntradaCriteriosDeBusqueda dtoe): Salida");
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        /*
         * Armado de retorno de datos
         */
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rsPerfiles);
        
        UtilidadesLog.info("MONPerfilesBean.buscarPerfiles(DTOEntradaCriteriosDeBusqueda dtoe): Salida");
        return dtos;
    }

    /*
       * El método consulta un perfil y retorna la informacion detallada del perfil
       * preCondicion: que exista el perfil
       *
       * @param DTOEntradaCriteriosDeBusqueda dtoe
       * @return DTOSalida
       * @throws MareException
      */
    public DTOSalida consultarPerfiles(DTOEntradaCriteriosDeBusqueda dtoe)
        throws MareException {
        
        UtilidadesLog.info("MONPerfilesBean.consultarPerfiles(DTOEntradaCriteriosDeBusqueda dtoe): Entrada");
        
        /*
         * Se valida que contenga nombre de perfil
         */
        String codigoError;

        if(dtoe.getNombrePerfil() == null) {
            this.ctx.setRollbackOnly();
            throw new MareException("Se produjo un error. No se encontro nombre " + "de perfil para la busqueda.");
        }

        //Se instancia el MGUMON
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dtoe.getUsuario()),dtoe.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));


        /*
         * Se crea un Rol a partir del DTOEntrada.
         */
        String sNombrePerfil = dtoe.getNombrePerfil();
        RoleImpl rRol = new RoleImpl(sNombrePerfil);

        /*
         * Se obtienen las propiedades asociadas al rol
         */
        HashMap hmPropiedades = null;

        try {
            hmPropiedades = (HashMap)mgumon.getProperties(rRol);
        } catch(Exception e) {
            throw new EJBException(e);
        }

        //        Property pPantallaIncial = (Property)hmPropiedades.get("NombrePantallaInicioEjecutablePerfil");
        Property pPantallaIncial = (Property)hmPropiedades.get("PantallaInicioDeAplicacionAsociada");
        String sPantallaInicial = "";

        if((pPantallaIncial != null) && (pPantallaIncial.getValue() != null))
            sPantallaInicial = pPantallaIncial.getValue().toString();

        /*
         * Se obtienen los roles que representan funciones asociados al perfil
         */
        HashSet hsRoles = null;
        String sParteIn = "(";

        try {
            hsRoles = (HashSet)mgumon.getRoles(rRol);
            Iterator iterador = hsRoles.iterator();

            while(iterador.hasNext()) {
                RoleImpl riRol = (RoleImpl)iterador.next();

                sParteIn = sParteIn + "'" + riRol.getName() + "',";
            }

            sParteIn = sParteIn.substring(0, sParteIn.length() - 1) + ")";
        } catch(MareException me) {
            UtilidadesLog.error(me);		
            ctx.setRollbackOnly();
            throw me;
        } catch(Exception e) {
            throw new EJBException(e);
        }

        /*
         * Consulta para filtrar las funciones finales
         */
        String sQueryFunciones = "";
        RecordSet rsFunciones = new RecordSet();

        sQueryFunciones = " SELECT f.oid_func AS idfuncion, v.val_i18n AS nombreprograma, " //				" DECODE (F.VAL_NOMB_PROG, '" + sPantallaInicial + "', '1','0') " + 
            + " DECODE (F.OID_FUNC, '" + sPantallaInicial + "', '1','0') " + " AS pantallainicial "
            + "    FROM men_funci f, v_gen_i18n_sicc v " + "   WHERE TO_CHAR (f.oid_func) IN " + sParteIn + "     AND f.ind_nive = 1 "
            + "     AND v.attr_enti = 'MEN_FUNCI' " + "     AND v.val_oid = f.oid_func " + "     AND v.idio_oid_idio = "
            + dtoe.getOidIdioma() + " ORDER BY f.oid_func		";

        try {
            rsFunciones = belcorpService.dbService.executeStaticQuery(sQueryFunciones);
        } catch(Exception e) {
            UtilidadesLog.error(e);		
            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        /*
         * Armado de retorno de datos
         */
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rsFunciones);
        
        UtilidadesLog.info("MONPerfilesBean.consultarPerfiles(DTOEntradaCriteriosDeBusqueda dtoe): Salida");
        return dtos;
    }

    /**
       * El método verifica si la colección (primer argumento) contiene la propidad
       * pasada como segundo argumento
       *       
       * @return boolean
       * @throws
      */
    private boolean contienePropiedad(Collection cPropiedades, String sPropiedad) {
        UtilidadesLog.info("MONPerfilesBean.contienePropiedad(Collection cPropiedades, String sPropiedad): Entrada");
        
        Iterator iterador = cPropiedades.iterator();

        while(iterador.hasNext()) {
            Property pPropiedad = (Property)iterador.next();

            if((pPropiedad != null) && (pPropiedad.getName() != null)) {
                String valor = pPropiedad.getName().toString();

                if(valor.equalsIgnoreCase(sPropiedad)){
                    UtilidadesLog.info("MONPerfilesBean.contienePropiedad(Collection cPropiedades, String sPropiedad): Salida");
                    return true;
                }
            }
        }

        UtilidadesLog.info("MONPerfilesBean.contienePropiedad(Collection cPropiedades, String sPropiedad): Salida");
        return false;
    }

    /**
       * El método verifica si la colección (primer argumento) contiene el rol
       * pasado como segundo argumento
       *       
       * @return boolean
       * @throws
      */
    private boolean contieneRol(Collection cRoles, String sRol) {
    
        UtilidadesLog.info("MONPerfilesBean.contieneRol(Collection cRoles, String sRol): Entrada");
        
        Iterator iterador = cRoles.iterator();

        while(iterador.hasNext()) {
            RoleImpl riRol = (RoleImpl)iterador.next();

            if(riRol != null) {
                String valor = riRol.toString();

                if(valor.equalsIgnoreCase(sRol)){
                    UtilidadesLog.info("MONPerfilesBean.contieneRol(Collection cRoles, String sRol): Salida");
                    return true;
                }
            }
        }

        UtilidadesLog.info("MONPerfilesBean.contieneRol(Collection cRoles, String sRol): Salida");
        return false;
    }

    public RecordSet recuperaTodos() throws MareException {
    
        UtilidadesLog.info("MONPerfilesBean.recuperaTodos(): Entrada");
        
        StringBuffer query = new StringBuffer();
        RecordSet rsPerfil = new RecordSet();

        query.append(" SELECT p.NAME nombre, p.NAME Perfil ");
        query.append(" FROM principals p, principals p2, memberof m ");
        query.append(" WHERE p2.NAME = 'PerfilesSICC' ");
        query.append(" AND m.idmember = p2.idprincipal ");
        query.append(" AND m.idrole = p.idprincipal ");
        query.append(" order by 1 ");

        try {
            rsPerfil = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch(MareSystemLevelException e) {
            throw new EJBException("Error de base de datos", e);
        } catch(MareException me) {
            UtilidadesLog.error(me);		
            ctx.setRollbackOnly();
            throw me;
        } catch(Exception e) {
            throw new EJBException(e);
        }

        if(rsPerfil.esVacio()){
            UtilidadesLog.info("MONPerfilesBean.recuperaTodos(): Salida");
            throw new MareException("no hay perfiles");
        }

        UtilidadesLog.info("MONPerfilesBean.recuperaTodos(): Salida");
        return rsPerfil;
    }

    public DTOCargaPerfil cargaInicial(DTOString dto) throws MareException {
    
        UtilidadesLog.info("MONPerfilesBean.cargaInicial(DTOString dto): Entrada");
        
        DTOCargaPerfil salida = new DTOCargaPerfil();
        DTOBoolean dtob = new DTOBoolean();
        dtob.setOidPais(dto.getOidPais());
        dtob.setOidIdioma(dto.getOidIdioma());
        dtob.setValor(true);

        try {
            MONFuncionesMenu monMenu = this.getMONFuncionesMenuHome().create();
            salida.setArbol(monMenu.obtenerMenuCompleto(dtob));
        } catch(RemoteException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        if(dto.getValor() == null)
            salida.setFunciones(new RecordSet()); //metemos en funciones un RecordSet vacio 
        else
            salida.setFunciones(this.obtenerFuncionesPerfil(dto)); //funciones = obtenerFuncionesPerfil(dto); 

        UtilidadesLog.info("MONPerfilesBean.cargaInicial(DTOString dto): Salida");
        return salida;
    }

    public void crear(DTOPerfil dto) throws MareException {
        UtilidadesLog.info("MONPerfilesBean.crear(DTOPerfil dto): Entrada");
        
        String usuario = ctx.getCallerPrincipal().getName();
        DAOMenu daoMenu = new DAOMenu(usuario);        
        HashSet roles = new HashSet();
        Long[] funciones = dto.getFunciones();

        for(int i = 0; i < funciones.length; i++)
            roles.add(new RoleImpl(funciones[i].toString()));

        Long[] funcionesPadres = daoMenu.obtenerPadresFunciones(funciones);

        for(int i = 0; i < funcionesPadres.length; i++)
            roles.add(new RoleImpl(funcionesPadres[i].toString()));

        roles.add(new RoleImpl("" + ConstantesMEN.NODO_FAVORITOS));
        RoleImpl rRol = new RoleImpl(dto.getNombre().toUpperCase());

        
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dto.getUsuario()),dto.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));


        try {
            //Crea el rol que representa perfiles
            mgumon.createRole(rRol, roles, this.obtenerPropiedadesInicio(dto.getInicio()));
            //Asocia el rol creado a PerfilesSICC
            mgumon.grantRole(new RoleImpl(ConstantesMEN.PERFIL_RAIZ), rRol);
        } catch(Exception e) {
            UtilidadesLog.error(e);		
            this.ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        }
        
        UtilidadesLog.info("MONPerfilesBean.crear(DTOPerfil dto): Salida");
    }

    public RecordSet obtenerFuncionesPerfil(DTOString dto) throws MareException {
    
        UtilidadesLog.info("MONPerfilesBean.obtenerFuncionesPerfil(DTOString dto): Entrada");
        
        String usuario = ctx.getCallerPrincipal().getName();
        DAOMenu daoMenu = new DAOMenu(usuario);

        
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dto.getUsuario()),dto.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));


        HashMap proper = (HashMap)mgumon.getProperties(new RoleImpl(dto.getValor()));
        Property inicio = (Property)proper.get(ConstantesMEN.PANTALLA_INICIO_OID_PROPERTY);
        String paginaInicio = null;
        Long oidPaginaInicio = null;

        if(inicio != null) {
            paginaInicio = (String)inicio.getValue();
            oidPaginaInicio = new Long(paginaInicio);
        }

        Set roles = mgumon.getRoles(new RoleImpl(dto.getValor()));
        RecordSet salida = new RecordSet();
        salida.addColumn("oid");
        salida.addColumn("nombre");
        salida.addColumn("inicio");

        Iterator it = roles.iterator();
        Set finales = daoMenu.obtenerFuncionesFinales();
        Set rolesPerfil = new HashSet();

        //Obtengo los que son funciones no indirectas.
        while(it.hasNext()) {            
            RoleImpl r = (RoleImpl)it.next();

            String rol = (r).getName();

            try {
                Long oid = new Long(Long.parseLong(rol));

                if(r.isIndirect() || !finales.contains(oid))
                    continue;

                rolesPerfil.add(oid);
            } catch(NumberFormatException e) {
                UtilidadesLog.debug("No es un numero --> no es una funcion");
            }
        }

        Map ruta = new HashMap();
        if (!rolesPerfil.isEmpty()) {
          ruta = daoMenu.obtenerRutaCompletaFuncion(rolesPerfil, dto.getOidIdioma());
        }
        Iterator it2 = rolesPerfil.iterator();

        while(it2.hasNext()) {
            Vector vec = new Vector();
            Long oid = (Long)it2.next();

            //  Si (la llamada al método isIndirect del Role devuelve true) ||
            //      (la llamada a contains() del set de funciones finales pasandole el role en forma de Long devuelve false) continue
            vec.add(oid);
            //				vec.add(daoMenu.obtenerRutaCompletaFuncion(oid, dto.getOidIdioma()));
            vec.add(ruta.get(oid.toString()));

            if(oidPaginaInicio != null) {
                if(oid.intValue() == oidPaginaInicio.intValue())
                    vec.add("S");
                else
                    vec.add("N");
            } else
                vec.add("N");

            salida.addRow(vec);
        }

        salida.sortByColumn(1, true);
        
        UtilidadesLog.info("MONPerfilesBean.obtenerFuncionesPerfil(DTOString dto): Salida");

        return salida;
    }

    public void eliminar(DTOStrings dto) throws MareException {
        UtilidadesLog.info("MONPerfilesBean.eliminar(DTOStrings dto): Entrada");
        
        String[] valores = dto.getValor();
        
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dto.getUsuario()),dto.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));


        for(int i = 0; i < valores.length; i++) {
            if(!this.tieneUsuariosAsociados(valores[i])) {
                RoleImpl rol = new RoleImpl(valores[i]);
                mgumon.deleteRole(rol);
            } else {
                String codigoError = CodigosError.ERROR_BORRADO_PERFIL;
                ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(),
                        UtilidadesError.armarCodigoError(codigoError));
                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                ex.addParameter(valores[i]);
                throw ex;
            }
        }
        
        UtilidadesLog.info("MONPerfilesBean.eliminar(DTOStrings dto): Salida");
    }

    public void modificar(DTOPerfil dto) throws MareException {
    
        UtilidadesLog.info("MONPerfilesBean.modificar(DTOPerfil dto): Entrada");
        
        
        String usuario = ctx.getCallerPrincipal().getName();
        DAOMenu daoMenu = new DAOMenu(usuario);        
        HashSet roles = new HashSet();
        Long[] funciones = dto.getFunciones();
        Role rol = new RoleImpl(dto.getNombre());

        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dto.getUsuario()),dto.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));

        if(dto.getInicio() != null) {
            Collection prop = this.obtenerPropiedadesInicio(dto.getInicio());
            Iterator it = prop.iterator();
            
            while(it.hasNext())
                mgumon.setProperty(rol, (Property)it.next());
        } else {
            mgumon.unSetProperty(rol, new Property(ConstantesMEN.PANTALLA_INICIO_OID_PROPERTY));
            mgumon.unSetProperty(rol, new Property(ConstantesMEN.PANTALLA_INICIO_PROPERTY));
        }

        for(int i = 0; i < funciones.length; i++)
            roles.add(new RoleImpl(funciones[i].toString()));

        Long[] funcionesPadres = daoMenu.obtenerPadresFunciones(funciones);

        for(int i = 0; i < funcionesPadres.length; i++)
            roles.add(new RoleImpl(funcionesPadres[i].toString()));

        roles.add(new RoleImpl("" + ConstantesMEN.NODO_FAVORITOS));
        //RoleImpl rRol = new RoleImpl(dto.getNombre());

        try {
            //Llamamos a setRoles del MGUMON pasandole dto.nombre en forma de MarePrincipal y el hashset con todos los roles
            //            mgumon.setRoles(rRol, roles);
             DTOEntradaAgregarRoles dtoAgregar = new DTOEntradaAgregarRoles();
             dtoAgregar.setPrincipal(rol);
             dtoAgregar.setUsuario(dto.getUsuario());
             dtoAgregar.setPassword(dto.getPassword());
             this.setRoles(dtoAgregar, roles);
        } catch(Exception e) {
            UtilidadesLog.error(e);		
            this.ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        }
        
        UtilidadesLog.info("MONPerfilesBean.modificar(DTOPerfil dto): Salida");

        /*


        Además creamos otro rol utilizando la constante ConstantesMEN.NODO_FAVORITOS,
        lo añadimos al hashset Llamamos a setRoles del MGUMON pasandole
        dto.nombre en forma de MarePrincipal y el hashset con todos los roles.
        */
       
    }

    public DTOSalida buscar(DTOString dto) throws MareException {
        UtilidadesLog.info("MONPerfilesBean.buscar(DTOString dto): Entrada");
        
        //Hacemos la búsqueda del perfil teniendo en cuenta la paginación. 
        String perfil = (dto.getValor() == null) ? "" : dto.getValor().toUpperCase();
        String[] perfiles = this.getListaPerfiles(perfil, dto);
        RecordSet rs = new RecordSet();
        rs.addColumn("oid");
        rs.addColumn("nombre");

        for(int i = dto.getIndicadorSituacion().intValue(); i < perfiles.length; i++) {
            if(rs.getRowCount() < dto.getTamanioPagina().intValue()) {
                //Añadimos una fila poniendo en la primera columna i+1 y en la segunda perfiles[i]; 
                Vector fila = new Vector();
                fila.add(new Integer(i + 1));
                fila.add(perfiles[i]);
                rs.addRow(fila);
            } else {
                UtilidadesLog.info("MONPerfilesBean.buscar(DTOString dto): Salida");
                return new DTOSalida(rs);
            }
        }

        if(rs.esVacio()) {
            UtilidadesLog.info("MONPerfilesBean.buscar(DTOString dto): Salida");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.info("MONPerfilesBean.buscar(DTOString dto): Salida");
        return new DTOSalida(rs);
    }

    private String[] getListaPerfiles(String criterio, DTOString dto) throws MareException {
        UtilidadesLog.info("MONPerfilesBean.getListaPerfiles(String criterio): Entrada");
        
        //Devuelve la lista de perfiles que coinciden con el criterio indicado 
        
        MareCredentials credenciales = new MareCredentials(new UserIDImpl(dto.getUsuario()),dto.getPassword());
        MGUService mgumon = (MGUService)MareMii.getService(new MareTopic(MareMii.SERVICE_MGU,credenciales));

        HashSet roles = (HashSet)mgumon.getRoles(new RoleImpl(ConstantesMEN.PERFIL_RAIZ));

        TreeSet perfiles = new TreeSet();

        Iterator it = roles.iterator();

        while(it.hasNext()) {
            RoleImpl rol = (RoleImpl)it.next();

            if(!rol.isIndirect()) {
                String nombreRol = rol.getName();

                if(matchCriteria(nombreRol, criterio))
                    perfiles.add(nombreRol);
            } else
                continue;
        }

        UtilidadesLog.info("MONPerfilesBean.getListaPerfiles(String criterio): Salida");
        return (String[])perfiles.toArray(new String[0]);
    }

    private boolean matchCriteria(String nombreRol, String criterio)
        throws MareException {
        
        //UtilidadesLog.info("MONPerfilesBean.matchCriteria(String nombreRol, String criterio): Entrada");
        
        if((criterio == null) || criterio.equals("")) {
            //UtilidadesLog.info("MONPerfilesBean.matchCriteria(String nombreRol, String criterio): Salida");
            return true; //No hay criterio de restriccion 
        }

        if((criterio.startsWith("%")) && (criterio.endsWith("%")) && (criterio.length() > 1)) {
			String g = criterio.substring(1, criterio.length()). substring(0, criterio.length() - 2);
      
            //UtilidadesLog.info("MONPerfilesBean.matchCriteria(String nombreRol, String criterio): Salida");
            return (nombreRol.indexOf(g)!=-1);
		}

        if(criterio.startsWith("%")) {
            //UtilidadesLog.info("MONPerfilesBean.matchCriteria(String nombreRol, String criterio): Salida");
            return nombreRol.endsWith(criterio.substring(1, criterio.length()));
        }

        if(criterio.endsWith("%")) {
            //UtilidadesLog.info("MONPerfilesBean.matchCriteria(String nombreRol, String criterio): Salida");
            return nombreRol.startsWith(criterio.substring(0, criterio.length() - 1));
        }

        //UtilidadesLog.info("MONPerfilesBean.matchCriteria(String nombreRol, String criterio): Salida");
        return nombreRol.equals(criterio);
    }

    private MONFuncionesMenuHome getMONFuncionesMenuHome() throws MareException {
        UtilidadesLog.info("MONPerfilesBean.getMONFuncionesMenuHome(): Entrada");
        
        MONFuncionesMenuHome localHome = (MONFuncionesMenuHome)UtilidadesEJB.getHome("MONFuncionesMenu", MONFuncionesMenuHome.class);
        
        UtilidadesLog.info("MONPerfilesBean.getMONFuncionesMenuHome(): Salida");
        return localHome;
    }

    private FuncionLocalHome getFuncionLocalHome() throws MareException {
        return new FuncionLocalHome();
    }

    public Collection obtenerPropiedadesInicio(Long oidFuncion)
        throws MareException {
        
        UtilidadesLog.info("MONPerfilesBean.obtenerPropiedadesInicio(Long oidFuncion): Entrada");
        
        ArrayList properties = new ArrayList();

        if(oidFuncion != null) {
            String nombreLP = "";

            try {
                //Obtener nombre LP
                nombreLP = this.getFuncionLocalHome().findByPrimaryKey(oidFuncion).getNombrePrograma();
            } catch(NoResultException e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            properties.add(new Property(ConstantesMEN.PANTALLA_INICIO_PROPERTY, nombreLP));
            properties.add(new Property(ConstantesMEN.PANTALLA_INICIO_OID_PROPERTY, oidFuncion.toString()));
        }

        UtilidadesLog.info("MONPerfilesBean.obtenerPropiedadesInicio(Long oidFuncion): Salida");
        return properties;
    }

    private boolean tieneUsuariosAsociados(String perfil) throws MareException {
        UtilidadesLog.info("MONPerfilesBean.tieneUsuariosAsociados(String perfil): Entrada");
        
        RecordSet rs = new RecordSet();

        try {
            StringBuffer query = new StringBuffer();
            query.append(" select count(*) from principals p, memberof m  ");
            query.append(" where p.idprincipal = m.idrole  ");
            query.append(" and p.name = '" + perfil + "' ");

            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch(Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        if(rs.getValueAt(0, 0) != null) {
            if(rs.getValueAt(0, 0).toString().equals("1")) {
                UtilidadesLog.info("MONPerfilesBean.tieneUsuariosAsociados(String perfil): Salida");
                return false;
            }
        }

        UtilidadesLog.info("MONPerfilesBean.tieneUsuariosAsociados(String perfil): Salida");
        return true;
    }

    /**
     * Metodo para recuperar todos los perfiles
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida con RecordSet que contiene los perfiles
     */
    public DTOSalida recuperaPerfiles() throws MareException {
        UtilidadesLog.info("MONPerfilesBean.recuperaPerfiles(): Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rsPerfil = new RecordSet();
        DTOSalida droSalida = new DTOSalida();
        query.append(" SELECT p.NAME nombre, p.NAME Perfil ");
        query.append(" FROM principals p, principals p2, memberof m ");
        query.append(" WHERE p2.NAME = 'PerfilesSICC' ");
        query.append(" AND m.idmember = p2.idprincipal ");
        query.append(" AND m.idrole = p.idprincipal ");
        query.append(" order by 1 ");
        try {
            rsPerfil = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch(MareSystemLevelException e) {
            throw new EJBException("Error de base de datos", e);
        } catch(MareException me) {
            UtilidadesLog.error(me);		
            ctx.setRollbackOnly();
            throw me;
        } catch(Exception e) {
            throw new EJBException(e);
        }
        if(rsPerfil.esVacio()){
            UtilidadesLog.info("MONPerfilesBean.recuperaPerfiles(): Salida");
            throw new MareException("no hay perfiles");
        }
        droSalida.setResultado(rsPerfil);
        UtilidadesLog.info("MONPerfilesBean.recuperaPerfiles(DTOBelcorp):Salida");
        return droSalida; 
        //return rsPerfil;       
    }   
}