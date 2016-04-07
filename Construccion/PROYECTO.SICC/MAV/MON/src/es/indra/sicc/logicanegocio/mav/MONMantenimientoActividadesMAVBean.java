package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.MONI18n;
import es.indra.sicc.cmn.negocio.i18n.MONI18nHome;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.mav.DTOActividadMAV;
import es.indra.sicc.dtos.mav.DTOEBuscarActividadesMAV;
import es.indra.sicc.dtos.mav.DTOLineaCombo;
import es.indra.sicc.dtos.mav.DTOSCargaPaginaInsertarActividades;
import es.indra.sicc.entidades.mav.ActividadesMAVLocal;
import es.indra.sicc.entidades.mav.ActividadesMAVLocalHome;
import es.indra.sicc.entidades.mav.CicloVidaActividadLocal;
import es.indra.sicc.entidades.mav.CicloVidaActividadLocalHome;
import es.indra.sicc.entidades.mav.CriterioAsignacionActividadLocal;
import es.indra.sicc.entidades.mav.CriterioAsignacionActividadLocalHome;
import es.indra.sicc.entidades.mav.EstadosActividadLocal;
import es.indra.sicc.entidades.mav.EstadosActividadLocalHome;
import es.indra.sicc.entidades.mav.SubtipoClienteActividadLocal;
import es.indra.sicc.entidades.mav.SubtipoClienteActividadLocalHome;
import es.indra.sicc.entidades.mav.TipoDespachoActividadLocal;
import es.indra.sicc.entidades.mav.TipoDespachoActividadLocalHome;
import es.indra.sicc.entidades.mav.TipoOfertaActividadLocal;
import es.indra.sicc.entidades.mav.TipoOfertaActividadLocalHome;
import es.indra.sicc.entidades.mav.TipoSolicitudOrigenActividadLocal;
import es.indra.sicc.entidades.mav.TipoSolicitudOrigenActividadLocalHome;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientesHome;
import es.indra.sicc.logicanegocio.ped.PEDTaponConsultas;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


public class MONMantenimientoActividadesMAVBean implements SessionBean {
    SessionContext ctx = null;

    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    /**
* Sistema:     Belcorp
* Modulo:      MAV
* Fecha:       05/08/2004
* @version     2.0
* @autor       Maximiliano Dello Russo
* Descripcion: 
*/
    public void eliminarActividades(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.eliminarActividades(DTOOIDs dto):Entrada");
        try {
            ActividadesMAVLocalHome actividadesHome = new ActividadesMAVLocalHome();
            SubtipoClienteActividadLocalHome subtipoClienteActividadHome = new SubtipoClienteActividadLocalHome();
            TipoOfertaActividadLocalHome tipoOfertaActividadHome = new TipoOfertaActividadLocalHome();
            CicloVidaActividadLocalHome cicloVidaActividadHome = new CicloVidaActividadLocalHome();
            TipoDespachoActividadLocalHome tipoDespachoActividadHome = new TipoDespachoActividadLocalHome();
            CriterioAsignacionActividadLocalHome criterioAsignacionActividadHome = new CriterioAsignacionActividadLocalHome();
            EstadosActividadLocalHome estadosActividadHome = new EstadosActividadLocalHome();
            TipoSolicitudOrigenActividadLocalHome tipoSolicitudOrigenActividadHome = new TipoSolicitudOrigenActividadLocalHome();

            UtilidadesLog.debug("PASO 1");

            ActividadesMAVLocal actividad = null;

            // Para cada oid contenido en el array del dto de entrada hacer: 
            // Hacer findByPrimaryKey() sobre la entidad "ActividadMAV" 
            // Hacer remove() 
            // Se borrarán en cascada por BD los registros de las siguientes entidades para el oid de 
            // actividad recibido: 
            // SubtipoClienteActividad, TipoOfertaActividad, CicloVidaActividad, 
            // TipoDespachoActividad, CriterioAsignacionActividad, EstadosActividad y 
            // TipoSolicitudOrigenActividad. 
            Long[] vecOids = dto.getOids();

            for(int i = 0; i < vecOids.length; i++) {
                Collection res = subtipoClienteActividadHome.findByOidActividad(vecOids[i]);
                Iterator itRes = res.iterator();
                while (itRes.hasNext()) {
                    subtipoClienteActividadHome.remove((SubtipoClienteActividadLocal)itRes.next());
                }
                res = tipoOfertaActividadHome.findByOidActividad(vecOids[i]);
                itRes = res.iterator();
                while (itRes.hasNext()) {
                    tipoOfertaActividadHome.remove((TipoOfertaActividadLocal)itRes.next());
                }
                res = cicloVidaActividadHome.findByOidActividad(vecOids[i]);
                itRes = res.iterator();
                while (itRes.hasNext()) {
                    cicloVidaActividadHome.remove((CicloVidaActividadLocal)itRes.next());
                }
                res = tipoDespachoActividadHome.findByOidActividad(vecOids[i]);
                itRes = res.iterator();
                while (itRes.hasNext()) {
                    tipoDespachoActividadHome.remove((TipoDespachoActividadLocal)itRes.next());
                }
                res = criterioAsignacionActividadHome.findByOidActividad(vecOids[i]);
                itRes = res.iterator();
                while (itRes.hasNext()) {
                    criterioAsignacionActividadHome.remove((CriterioAsignacionActividadLocal)itRes.next());
                }
                res = estadosActividadHome.findByOidActividad(vecOids[i]);
                itRes = res.iterator();
                while (itRes.hasNext()) {
                    estadosActividadHome.remove((EstadosActividadLocal)itRes.next());
                }
                res = tipoSolicitudOrigenActividadHome.findByOidActividad(vecOids[i]);
                itRes = res.iterator();
                while (itRes.hasNext()) {
                    tipoSolicitudOrigenActividadHome.remove((TipoSolicitudOrigenActividadLocal)itRes.next());
                }
                actividad = actividadesHome.findByPrimaryKey(vecOids[i]);
                actividadesHome.remove(actividad);
            }
        } catch(NoResultException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(PersistenceException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.eliminarActividades(DTOOIDs dto):Salida");
    }

    public DTOSalida buscarActividades(DTOEBuscarActividadesMAV dto)
        throws MareException {
        // Llamar al método "DAOActividadMAV.buscarActividades()" pasándo como 
        // parámetro el dto de entrada 
        // Devolver DTOSalida obtenido en la actividad anterior
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.buscarActividades(DTOEBuscarActividadesMAV dto):Entrada");
        DTOSalida dtoSalida = null;
        DAOActividadesMAV daoActividades = new DAOActividadesMAV(ctx.getCallerPrincipal().getName());
        UtilidadesLog.debug("Busca Actividades 1");
        dtoSalida = daoActividades.buscarActividades(dto);
        UtilidadesLog.debug("Busca Actividades 2");        
        UtilidadesLog.debug("dtoSalida: " + dtoSalida);
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.buscarActividades(DTOEBuscarActividadesMAV dto):Salida");
        return dtoSalida;
    }

    /**
* Sistema:     Belcorp
* Modulo:      MAV
* Fecha:       05/08/2004
* @version     1.0
* @autor       Maximiliano Dello Russo
* Descripcion: 
*/
    public void guardarActividad(DTOActividadMAV dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.guardarActividad(DTOActividadMAV dto):Entrada");
        try {
            TipoOfertaActividadLocalHome tipoOfertaHome = new TipoOfertaActividadLocalHome();
            CicloVidaActividadLocalHome cicloVidaHome = new CicloVidaActividadLocalHome();
            TipoDespachoActividadLocalHome tipoDespachoHome = new TipoDespachoActividadLocalHome();
            TipoSolicitudOrigenActividadLocalHome tipoSolicitudOrigenHome = new TipoSolicitudOrigenActividadLocalHome();
            SubtipoClienteActividadLocalHome subtipoClienteHome = new SubtipoClienteActividadLocalHome();
            EstadosActividadLocalHome estadosHome = new EstadosActividadLocalHome();
            CriterioAsignacionActividadLocalHome criterioAsignacionHome = new CriterioAsignacionActividadLocalHome();
            Long oidActividadNueva = null;

            UtilidadesLog.debug("Dto recibido: " + dto);

            // Hacer una llamada al método privado de este mismo MON "validarTipoSubtipoCliente" pasándole el dto de entrada 
            // Si la llamada al método en actividad anterior devuelve "true" entonces 
            UtilidadesLog.debug("### Paso 1");

            if(this.validarTipoSubtipoCliente(dto).booleanValue()) {
            
                MONI18n mon = null;
                try {
                    mon = this.getMONI18nHome().create();
                } catch (CreateException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
            
                // Si (oidActividad = null) entonces 
                if(dto.getOidActividad() == null) {
                    UtilidadesLog.debug("### Entro a NULL");
                    ActividadesMAVLocalHome actividadesHome = new ActividadesMAVLocalHome();                                        
                    UtilidadesLog.debug("### Creando nueva actividad...");
                    // Hacer un "create" sobre la entidad "ActividadesMAV" 
                    ActividadesMAVLocal actividadNueva = actividadesHome.create(dto.getOidPais(), dto.getOidTipoCondicionPago(),
                            dto.getOidCanal(), dto.getOidFormaPago(), dto.getDescripcionDetallada(), dto.getOidMarca(),
                            dto.getOidTipoCliente());
                    UtilidadesLog.debug("   ###  Se creo nueva ActividadesMAV ### ");
                    // Setear todos los atributos de la actividad creada 
                    actividadNueva.setCampagnaEvaluacion(dto.getCampagnaEvaluacion());
                    actividadNueva.setFacturaIntercompagnias(dto.getFacturaIntercompanias());
                    actividadNueva.setOidClienteDatosBasicos(dto.getOidCliente());
                    actividadNueva.setOidEmpresa(dto.getOidEmpresa());
                    actividadNueva.setOidSubtipoPosicionEnvio(dto.getOidSubtipoPosicionEnvio());
                    actividadNueva.setOidSubtipoPosicionParaPago(dto.getOidSubtipoPosicionParaPago());
                    //					actividadNueva.setOidTipoPosicionDestino();
                    actividadNueva.setOidTipoPosicionParaPago(dto.getOidTipoPosicionParaPago());
                    actividadNueva.setOidTipoSolicitudDestino(dto.getOidTipoSolicitudDestino());
                    actividadNueva.setOidTipoSolicitudParaPago(dto.getOidTipoSolicitudParaPago());
                    actividadNueva.setPorcentajeSobreCosto(dto.getCosto());
                    actividadNueva.setOidTipoPosicionDestino(dto.getOidTipoPosicionEnvio());
                    
                    // sapaza -- PER-SiCC-2013-0432 -- 18/04/2013
                    actividadNueva.setUsuarioCreacion(ctx.getCallerPrincipal().getName());
                    actividadNueva.setFechaCreacion(new Timestamp(new Date(System.currentTimeMillis()).getTime()));

                    // Para cada posición del array "attTraducible" hacer: 
                    // -> Hacer un "create" sobre la entidad "Entidadi18n" y setear los datos con el DTOi18nSICC de la posición 
                    /*Vector vecDescrip = dto.getAttTraducible();
                    Iterator it = vecDescrip.iterator();
                    DTOI18nSICC descripcionI18N = null;
                    Entidadi18nLocalHome i18nHome = null;

                    while(it.hasNext()) {
                        descripcionI18N = (DTOI18nSICC)it.next();
                        i18nHome = new Entidadi18nLocalHome();
                        i18nHome.create("MAV_ACTIV", descripcionI18N.getOidAtriuto(), descripcionI18N.getOidIdioma(),
                            descripcionI18N.getValorI18n(), actividadNueva.getOid());
                        UtilidadesLog.debug("Se creo nueva entrada en i18n");
                    }*/
                    
                    mon.insertarTraducciones("MAV_ACTIV", actividadNueva.getOid(), dto.getAttTraducible());

                    // Tomar oid de actividad generado en el "create" 
                    oidActividadNueva = actividadNueva.getOid();
                    
                    actividadesHome.merge(actividadNueva);
                } else {
                    UtilidadesLog.debug(">>>>>>>> ENTRA POR ELSE <<<<<<<<<<<<");

                    // Hacer un "findByPrimariKey" sobre la entidad "ActividadesMAV" usando el atributo 
                    // "oidActividad" del dto de entrada.
                    ActividadesMAVLocalHome actividadesHome = new ActividadesMAVLocalHome();                    
                    ActividadesMAVLocal actividad = actividadesHome.findByPrimaryKey(dto.getOidActividad());

                    // Setear todos los atributos de la actividad encontrada 
                    actividad.setCampagnaEvaluacion(dto.getCampagnaEvaluacion());
                    actividad.setDescripcionDetallada(dto.getDescripcionDetallada());
                    actividad.setFacturaIntercompagnias(dto.getFacturaIntercompanias());
                    actividad.setOidCanal(dto.getOidCanal());
                    actividad.setOidClienteDatosBasicos(dto.getOidCliente());
                    actividad.setOidEmpresa(dto.getOidEmpresa());
                    actividad.setOidFormaPago(dto.getOidFormaPago());
                    actividad.setOidMarca(dto.getOidMarca());
                    actividad.setOidPais(dto.getOidPais());
                    actividad.setOidSubtipoPosicionEnvio(dto.getOidSubtipoPosicionEnvio());
                    actividad.setOidSubtipoPosicionParaPago(dto.getOidSubtipoPosicionParaPago());
                    actividad.setOidTipoCliente(dto.getOidTipoCliente());
                    actividad.setOidTipoCondicionPago(dto.getOidTipoCondicionPago());
                    actividad.setOidTipoPosicionDestino(dto.getOidTipoPosicionEnvio());
                    actividad.setOidTipoPosicionParaPago(dto.getOidTipoPosicionParaPago());
                    actividad.setOidTipoSolicitudDestino(dto.getOidTipoSolicitudDestino());
                    actividad.setOidTipoSolicitudParaPago(dto.getOidTipoSolicitudParaPago());
                    actividad.setPorcentajeSobreCosto(dto.getCosto());
                    
                    // sapaza -- PER-SiCC-2013-0432 -- 18/04/2013
                    actividad.setUsuarioModificacion(ctx.getCallerPrincipal().getName());
                    actividad.setFechaModificacion(new Timestamp(new Date(System.currentTimeMillis()).getTime()));

                    // Para cada posición del array "attTraducible" hacer: 
                    // -> Hacer un "findByPrimaryKey" sobre la entidad "Entidadi18n" y 
                    // setear los datos con el DTOi18nSICC de la posición.
                    /*Vector vecDescripciones = dto.getAttTraducible();
                    Iterator it = vecDescripciones.iterator();
                    DTOI18nSICC descripcionI18N = null;
                    Entidadi18nLocalHome i18nHome = null;
                    Entidadi18nLocal i18n = null;

                    while(it.hasNext()) {
                        descripcionI18N = (DTOI18nSICC)it.next();
                        i18nHome = new Entidadi18nLocalHome();
                        i18n = i18nHome.findByEntAtrIdioPK("MAV_ACTIV", descripcionI18N.getOidAtriuto(),
                                descripcionI18N.getOidIdioma(), dto.getOidActividad());
                        i18n.setDetalle(descripcionI18N.getValorI18n());
                    }*/
                    mon.actualizaTraducciones("MAV_ACTIV", dto.getOidActividad(), dto.getAttTraducible());

                    // Borrar en las siguientes entidades los registros donde el campo ACTI_OID_ACTI = "oidActividad" 
                    // del dto de entrada:
                    // MAV_ACTIV_TIPO_OFERT, MAV_ACTIV_CICLO_VIDA, MAV_ACTIV_TIPO_DESPA, MAV_ACTIV_TIPO_SOLIC,
                    // MAV_ACTIV_SUBTI_CLIEN, MAV_ACTIV_ESTAD, MAV_CRITE_ASIGN_ACTIV 
                    TipoOfertaActividadLocal tipoOferta = null;
                    CicloVidaActividadLocal cicloVida = null;
                    TipoDespachoActividadLocal tipoDespacho = null;
                    TipoSolicitudOrigenActividadLocal tipoSolicitudOrigen = null;
                    SubtipoClienteActividadLocal subtipoCliente = null;
                    EstadosActividadLocal estados = null;
                    CriterioAsignacionActividadLocal criterioAsignacion = null;

                    Collection coleccion = null;
                    Iterator itAux = null;

                    tipoOfertaHome = new TipoOfertaActividadLocalHome();
                    coleccion = tipoOfertaHome.findByOidActividad(dto.getOidActividad());
                    itAux = coleccion.iterator();

                    while(itAux.hasNext()) {
                        tipoOferta = (TipoOfertaActividadLocal)itAux.next();
                        tipoOfertaHome.remove(tipoOferta);
                    }

                    cicloVidaHome = new CicloVidaActividadLocalHome();                    
                    coleccion = cicloVidaHome.findByOidActividad(dto.getOidActividad());
                    itAux = coleccion.iterator();

                    while(itAux.hasNext()) {
                        cicloVida = (CicloVidaActividadLocal)itAux.next();
                        cicloVidaHome.remove(cicloVida);
                    }

                    tipoDespachoHome = new TipoDespachoActividadLocalHome();                    
                    coleccion = tipoDespachoHome.findByOidActividad(dto.getOidActividad());
                    itAux = coleccion.iterator();

                    while(itAux.hasNext()) {
                        UtilidadesLog.debug(">>>>>>>> ENTRA POR TipoDespachoActividad para remover <<<<<<<<<<<<");
                        tipoDespacho = (TipoDespachoActividadLocal)itAux.next();
                        tipoDespachoHome.remove(tipoDespacho);
                    }

                    tipoSolicitudOrigenHome = new TipoSolicitudOrigenActividadLocalHome();                    
                    coleccion = tipoSolicitudOrigenHome.findByOidActividad(dto.getOidActividad());
                    itAux = coleccion.iterator();

                    while(itAux.hasNext()) {
                        tipoSolicitudOrigen = (TipoSolicitudOrigenActividadLocal)itAux.next();
                        tipoSolicitudOrigenHome.remove(tipoSolicitudOrigen);
                    }

                    subtipoClienteHome = new SubtipoClienteActividadLocalHome();                    
                    coleccion = subtipoClienteHome.findByOidActividad(dto.getOidActividad());
                    itAux = coleccion.iterator();

                    while(itAux.hasNext()) {
                        subtipoCliente = (SubtipoClienteActividadLocal)itAux.next();
                        subtipoClienteHome.remove(subtipoCliente);
                    }

                    estadosHome = new EstadosActividadLocalHome();
                    coleccion = estadosHome.findByOidActividad(dto.getOidActividad());
                    itAux = coleccion.iterator();

                    while(itAux.hasNext()) {
                        estados = (EstadosActividadLocal)itAux.next();
                        estadosHome.remove(estados);
                    }

                    criterioAsignacionHome = new CriterioAsignacionActividadLocalHome();                    
                    coleccion = criterioAsignacionHome.findByOidActividad(dto.getOidActividad());
                    itAux = coleccion.iterator();

                    while(itAux.hasNext()) {
                        criterioAsignacion = (CriterioAsignacionActividadLocal)itAux.next();
                        criterioAsignacionHome.remove(criterioAsignacion);
                    }

                    // Tomar oid de actividad generado en el "create" 
                    oidActividadNueva = actividad.getOid();
                    
                    actividadesHome.merge(actividad);
                }
                
                UtilidadesLog.debug(">>>>>>>> SALE DEL ELSE <<<<<<<<<<<<");
                
                // Para cada atributo de tipo arrayList hacer "creates" con el oid de la 
                // actividad anterior en sus correspondientes entidades siguiendo la siguiente correspondencia: 
                // Atributo DTOOIDs => Entidad 
                Vector dtos = null;
                Iterator it = null;
                DTOLineaCombo dtoLineaCombo = null;

                // tipoOferta => TipoOfertaActividad 
                dtos = dto.getTipoOferta();
                UtilidadesLog.debug("+++++ oidActividadNueva: " + oidActividadNueva.toString());
                UtilidadesLog.debug("+++++ OIDS: ");
                it = dtos.iterator();

                while(it.hasNext()) {
                    dtoLineaCombo = (DTOLineaCombo)it.next();
                    UtilidadesLog.debug(dtoLineaCombo.getOid() + ", ");
                    tipoOfertaHome.create(oidActividadNueva, dtoLineaCombo.getOid());
                }

                // cicloVida => CicloVidaActividad 
                dtos = dto.getCicloVida();
                it = dtos.iterator();

                while(it.hasNext()) {
                    dtoLineaCombo = (DTOLineaCombo)it.next();
                    cicloVidaHome.create(oidActividadNueva, dtoLineaCombo.getOid());
                }

                // tipoDespacho => TipoDespachoActividad 
                // (usar el atributo oidEnvioConSolicitud del dto de entrada para 
                // todos los tipos de despacho del dto que se creen) 
                dtos = dto.getTipoDespacho();
                it = dtos.iterator();
                UtilidadesLog.debug("+++++ TIPO DESPACHO");
                UtilidadesLog.debug("+++ Oids: ");

                while(it.hasNext()) 
                {
                    dtoLineaCombo = (DTOLineaCombo)it.next();
                    UtilidadesLog.debug(dtoLineaCombo.getOid() + ", ");
                    UtilidadesLog.debug(">>>>>>>> ENTRAMOS A CREAR  tipoDespachoActividad<<<<<<<<<<<<");
                    TipoDespachoActividadLocal tipoDespacho = tipoDespachoHome.create(oidActividadNueva, dtoLineaCombo.getOid());                    

                    //          Modificacion x ssantana, inc. 11652
                    // -----------------------------------------------------------
                    // Si Tipo Despacho es de tipo 1 o 2 (en MAV_TIPO_DESPA seria 
                    //   "Por Solicitud" y "Por Solicitud Servicio", entonces toma 
                    // el valor de Envio con Solicitud y lo graba en 
                    // MAV_ACTIV_TIPO_DESPA.ENVS_OID_ENVI_SOLI. Si no, guarda NULL
                    // en este campo .
                    if ( dtoLineaCombo.getOid().equals(new Long(1)) || dtoLineaCombo.getOid().equals(new Long(2) ) )
                    {
                        UtilidadesLog.debug("Graba Envio Con Solicitud");
                        tipoDespacho.setOidEnvioConSolicitud(dto.getOidEnvioConSolicitud());
                    }
                    else
                    {
                        UtilidadesLog.debug("No graba Envio con solicitud - Guardar NULL");
                        tipoDespacho.setOidEnvioConSolicitud(null);                      
                    }
                    
                    tipoDespachoHome.merge(tipoDespacho);

                }

                // tipoSolicitudOrigen => TipoSolicitudOrigenActividad 
                if(dto.getTipoSolicitudOrigen() != null) {
                    UtilidadesLog.debug("+++++ TIPO SOLICITUD ORIGEN");
                    UtilidadesLog.debug("+++ Oids: ");
                    dtos = dto.getTipoSolicitudOrigen();
                    it = dtos.iterator();

                    while(it.hasNext()) {
                        dtoLineaCombo = (DTOLineaCombo)it.next();
                        UtilidadesLog.debug(dtoLineaCombo.getOid() + ", ");
                        tipoSolicitudOrigenHome.create(oidActividadNueva, dtoLineaCombo.getOid());
                    }
                }

                // subtipoCliente => SubtipoClienteActividad 
                if(dto.getSubtipoCliente() != null) {
                    UtilidadesLog.debug("+++++ SUBTIPOCLIENTE");
                    UtilidadesLog.debug("+++ Oids: ");
                    dtos = dto.getSubtipoCliente();
                    it = dtos.iterator();

                    while(it.hasNext()) {
                        dtoLineaCombo = (DTOLineaCombo)it.next();
                        UtilidadesLog.debug(dtoLineaCombo.getOid() + ", ");
                        subtipoClienteHome.create(oidActividadNueva, dtoLineaCombo.getOid());
                    }
                }

                // estado => EstadosActividad 
                dtos = dto.getEstado();
                if (dtos != null)
                {
                    UtilidadesLog.debug("Entro a Estados Actividad");
                    it = dtos.iterator();
                    UtilidadesLog.debug("+++++ ESTADOS");
                    UtilidadesLog.debug("++++ Oids: ");

                    while(it.hasNext()) {
                        dtoLineaCombo = (DTOLineaCombo)it.next();
                        UtilidadesLog.debug(dtoLineaCombo.getOid() + ", ");
                        estadosHome.create(oidActividadNueva, dtoLineaCombo.getOid());
                    }
                } else
                {
                  UtilidadesLog.debug("Vector Estado es NULL");
                }

                // criterioAsignacion => CriterioAsignacionActividad 
                UtilidadesLog.debug("+++++ CRITERIO ASIGNACION");
                UtilidadesLog.debug("++++ Oids: ");
                dtos = dto.getCriterioAsignacion();
                it = dtos.iterator();

                while(it.hasNext()) {
                    dtoLineaCombo = (DTOLineaCombo)it.next();
                    UtilidadesLog.debug(dtoLineaCombo.getOid() + ", ");
                    criterioAsignacionHome.create(oidActividadNueva, dtoLineaCombo.getOid());
                }
            } else {
                // Lanzar MareException con código de error "MAV-0001" 
                // Se levanto una incidencia para chequear este punto.
                UtilidadesLog.debug(">>>>>>>>>>>>>>>>>> TIRAR EXCEPCION MAV_0001 <<<<<<<<<<<<<<<<<<<<<<");
                throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV, "", ErroresNegocio.MAV_0001));
            }
        } catch(NoResultException e) {
            UtilidadesLog.debug(">>>>>>>>>>>>>>>>>> TIRAR FINDER EXCEPTION <<<<<<<<<<<<<<<<<<<<<<");
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(PersistenceException Re) {
            UtilidadesLog.debug(">>>>>>>>>>>>>>>>>> TIRAR REMOVE EXCEPTION <<<<<<<<<<<<<<<<<<<<<<");
            UtilidadesLog.error(Re);
            ctx.setRollbackOnly();
            UtilidadesLog.debug(">>>>>>>>>>>>>>>>>> TIRAR EXCEPCION MAV_0015 <<<<<<<<<<<<<<<<<<<<<<");
            throw new MareException(new Exception(),
            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV, "", ErroresNegocio.MAV_0015));
           
        } catch(Exception ex) {
            if(ex instanceof MareException)
                throw (MareException)ex;

            UtilidadesLog.error(ex);
            ctx.setRollbackOnly();
            UtilidadesLog.debug(">>>>>>>>>>>>>>>>>> TIRAR OTRA EXCEPTION <<<<<<<<<<<<<<<<<<<<<<");
            UtilidadesLog.debug(">>>>>>>>>>>>>>>>>> TIRAR EXCEPCION MAV_0015 <<<<<<<<<<<<<<<<<<<<<<");
            throw new MareException(new Exception(),
            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV, "", ErroresNegocio.MAV_0015));
            //throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));          
         
        }
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.guardarActividad(DTOActividadMAV dto):Salida");
        
    }

    /**
* Sistema:     Belcorp
* Modulo:      MAV
* Fecha:       05/08/2004
* @version     2.0
* @autor       Maximiliano Dello Russo
* Descripcion: 
*/
    public DTOActividadMAV consultarActividad(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.consultarActividad(DTOOID dto):Entrada");
        try {
            UtilidadesLog.debug("## ENTRO EN consultarActividad");

            // Segun incidencia 7401:
            // Llamar al método "DAOActividadMAV.consultaActividad(dto : DTOOID) : DTOActividadMAV" pasando el dto de entrada
            // Devolver DTOActividadMAV creado.
            DAOActividadesMAV dao = new DAOActividadesMAV(ctx.getCallerPrincipal().getName());
            DTOActividadMAV dtoActividad = dao.consultaActividad(dto);
            UtilidadesLog.debug("DTORetornado: " + dtoActividad);
            UtilidadesLog.info("MONMantenimientoActividadesMAVBean.consultarActividad(DTOOID dto):Entrada");
            return dtoActividad;
        } catch(MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch(Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    public DTOSalida obtenerSubtiposCliente(DTOBelcorp dto)
        throws MareException {
        
        // Llamar al método "MONConfiguracionClientes.obtenerTipoSubtipo()" pasando como parámetro el dto de entrada 
        // Recuperar RecordSet de Subtipos de cliente del objeto "DTOTipoSubtipo" devuelto en actividad anterior 
        // Devolver RecordSet obtenido en objeto DTOSalida
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.obtenerSubtiposCliente(DTOBelcorp dto):Entrada");
        try {
            DTOSalida dtoSalida = new DTOSalida();
            DTOTipoSubtipo dtoTipoSubtipo = new DTOTipoSubtipo();
            RecordSet rs = null;

            MONConfiguracionClientesHome monConfigClientesHome = this.getMONConfiguracionClientesHome();
            MONConfiguracionClientes monConfigClientes = monConfigClientesHome.create();
            dtoTipoSubtipo = monConfigClientes.obtenerTipoSubtipo(dto);
            rs = dtoTipoSubtipo.getSubtipos();
            dtoSalida.setResultado(rs);
            UtilidadesLog.info("MONMantenimientoActividadesMAVBean.obtenerSubtiposCliente(DTOBelcorp dto):Salida");
            return dtoSalida;
        } catch(NamingException Ne) {
            UtilidadesLog.error(Ne);
            throw new MareException(Ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(RemoteException Re) {
            UtilidadesLog.error(Re);
            throw new MareException(Re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException Ce) {
            UtilidadesLog.error(Ce);
            throw new MareException(Ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtieneActividadesMAV(DTOActividadMAV dto)
        throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.obtieneActividadesMAV(DTOActividadMAV dto):Entrada");
        // Invoca a DAOActividadMAV.obtieneActividadesMAV(dto) 
        // Devuelve DTOSalida obtenido en actividad anterior 
        DAOActividadesMAV dao = new DAOActividadesMAV(ctx.getCallerPrincipal().getName());
        DTOSalida dtoSalida = null;
        dtoSalida = dao.obtieneActividadesMAV(dto);
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.obtieneActividadesMAV(DTOActividadMAV dto):Salida");
        return dtoSalida;
    }

    public DTOSCargaPaginaInsertarActividades cargaPaginaInsertarActividades(DTOBelcorp dto)
        throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.cargaPaginaInsertarActividades(DTOBelcorp dto):Entrada");
        DTOSCargaPaginaInsertarActividades dtoCarga = new DTOSCargaPaginaInsertarActividades();
        DTOSalida dtoSalida = null;

        // Llamar el método "obtieneTiposSolicitudPais(dto : DTOBelcorp) : DTOSalida" del tapón "PEDTaponConsultas" 
        // Extraer "RecordSet" de "DTOSalida" anterior y asignar al atributo "tipoSolicitudDestino" del dto creado al inicio 
        // Incidencia levantada, consultando que carajo es PEDTaponConsultas
        PEDTaponConsultas taponConsultas = new PEDTaponConsultas();
        dtoCarga.setTipoSolicitudDestino(taponConsultas.obtieneTiposSolicitudPais(dto).getResultado());
        // Llamar el método "obtieneTiposPosicion(dto : DTOBelcorp) : DTOSalida" del tapón "PEDTaponConsultas" 
        // Extraer "RecordSet" de "DTOSalida" anterior y asignar al atributo "tipoPosicionEnvio" del dto creado al inicio 
        // Mismo que lo anterior.
        dtoCarga.setTipoPosicionEnvio(taponConsultas.obtieneTiposPosicion(dto).getResultado());
        // Llamar al método de este MON, de nombre "obtenerSubtiposCliente" pasándole el dto de entrada 
        // Tomar "DTOSalida" que devuelve la llamada anterior 
        dtoSalida = this.obtenerSubtiposCliente(dto);
        // Extraer "RecordSet" de "DTOSalida" anterior y asignar al atributo "subtipoClientes" del dto creado al inicio 
        dtoCarga.setSubtipoCliente(dtoSalida.getResultado());
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.cargaPaginaInsertarActividades(DTOBelcorp dto):Salida");
        return dtoCarga;
    }

    private Boolean validarTipoSubtipoCliente(DTOActividadMAV actividad)
        throws MareException {
        // Segun incidencia 7422:
        // -> Obtener el atributo "criterioAsignacion" del dto de entrada (DTOOIDs)
        // Si alguno de los oid = "2" o "3" entonces
        // -> Tomar valor de DTOActividadMAV.subtiposCliente y asignarlo a una variable llamada
        // subtiposCliente de tipo DTOOIDs
        // -> Crear variable de tipo DTOOIDs llamada tiposCliente y añadir a la misma el atributo
        // DTOActividadMAV.oidTipoCliente
        // -> Llamar al método
        // "DAOActividadMAV.obtenerParametrizacionMavPorTipoSubtipoCliente(tiposCliente : DTOOIDs,
        // subtiposCliente : DTOOIDs) : DTOSalida" pasando los datos obtenidos
        // -> Si el DTOSalida contiene registros devolver "True" en un objeto "Boolean", si no entonces
        // devolver "False"
        // Si no entonces
        //    -> Devolver "True" en un objeto "Boolean"
        // Fin Si
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.validarTipoSubtipoCliente(DTOActividadMAV actividad):Entrada");
        DAOActividadesMAV dao = new DAOActividadesMAV(ctx.getCallerPrincipal().getName());
        DTOSalida dtoSalida = null;
        Vector criterios = actividad.getCriterioAsignacion();
        Iterator it = criterios.iterator();
        DTOLineaCombo lineaCombo = null;

        while(it.hasNext()) {
            lineaCombo = (DTOLineaCombo)it.next();
            UtilidadesLog.debug("### oids: " + lineaCombo.getOid().toString());

            if((lineaCombo.getOid().longValue() == 2L) || (lineaCombo.getOid().longValue() == 3L)) {
                UtilidadesLog.debug("ENTROSE");
                DTOOIDs subtiposCliente = new DTOOIDs();
                UtilidadesLog.debug("1");
                Vector vecOids = actividad.getSubtipoCliente();
                UtilidadesLog.debug("2");
                UtilidadesLog.debug("SIZE: " + vecOids.size());
                Long[] oids = new Long[vecOids.size()];
                UtilidadesLog.debug("3");
                Iterator itOids = vecOids.iterator();
                UtilidadesLog.debug("4");
                DTOLineaCombo dtoCombo = null;
                UtilidadesLog.debug("5");

                for(int i = 0; itOids.hasNext(); i++) {
                    dtoCombo = (DTOLineaCombo)itOids.next();
                    oids[i] = dtoCombo.getOid();
                }

                UtilidadesLog.debug("6");
                subtiposCliente.setOids(oids);
                UtilidadesLog.debug("7");
                DTOOIDs tiposCliente = new DTOOIDs();
                UtilidadesLog.debug("8");
                Long[] oidTiposCliente = new Long[1];
                UtilidadesLog.debug("9");
                oidTiposCliente[0] = actividad.getOidTipoCliente();
                UtilidadesLog.debug("10");
                tiposCliente.setOids(oidTiposCliente);
                UtilidadesLog.debug("11");
                dtoSalida = dao.obtenerParametrizacionMavPorTipoSubtipoCliente(tiposCliente, subtiposCliente);
                UtilidadesLog.debug("SALIO DAO");
                RecordSet rs = dtoSalida.getResultado();
                UtilidadesLog.debug("### DAO OK...");

                if(rs.esVacio()) {
                    UtilidadesLog.info("MONMantenimientoActividadesMAVBean.validarTipoSubtipoCliente(DTOActividadMAV actividad):Salida");
                    return new Boolean(false);
                }
                else {
                    UtilidadesLog.info("MONMantenimientoActividadesMAVBean.validarTipoSubtipoCliente(DTOActividadMAV actividad):Salida");
                    return new Boolean(true);
                }
            }
        }
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.validarTipoSubtipoCliente(DTOActividadMAV actividad):Salida");
        return new Boolean(true);
    }


    private MONConfiguracionClientesHome getMONConfiguracionClientesHome()
        throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONConfiguracionClientesHome)PortableRemoteObject.narrow(context.lookup("MONConfiguracionClientes"),
            MONConfiguracionClientesHome.class);
    }


    /**
     * @author: ssantana
     * @inc: 16866
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @param  DTOE
     */
  public DTOSalida obtenerSubtiposClienteMAV(DTOOID DTOE) throws MareException {
    UtilidadesLog.info("MONMantenimientoActividadesMAVBean.obtenerSubtiposClienteMAV(DTOOID DTOE):Entrada");
    
    DAOActividadesMAV daoActividadesMAV = 
                                new DAOActividadesMAV(ctx.getCallerPrincipal().getName());
    DTOSalida dtoSalida = daoActividadesMAV.obtenerSubtiposClienteMAV(DTOE);
    
    UtilidadesLog.info("MONMantenimientoActividadesMAVBean.obtenerSubtiposClienteMAV(DTOOID DTOE):Salida");
    return dtoSalida;
  }

  /**
   * 19-06-2007   agregado por Sapaza, incidencia Sicc-20070288. Consulta actividades MAV por tipo de
   *              despacho, pais, marca y canal.
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dto
   */
    public DTOSalida obtenerActividadesTipoDespacho(DTOEBuscarActividadesMAV dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.obtenerActividadesTipoDespacho(DTOEBuscarActividadesMAV dto):Entrada");
        DTOSalida dtoSalida = null;
        
        DAOActividadesMAV daoActividades = new DAOActividadesMAV(ctx.getCallerPrincipal().getName());
        UtilidadesLog.debug("Busca Actividades 1");
        dtoSalida = daoActividades.obtenerActividadesTipoDespacho(dto);
        UtilidadesLog.debug("Busca Actividades 2");        
        UtilidadesLog.debug("dtoSalida: " + dtoSalida);
        
        UtilidadesLog.info("MONMantenimientoActividadesMAVBean.obtenerActividadesTipoDespacho(DTOEBuscarActividadesMAV dto):Salida");
        return dtoSalida;
    }

    private MONI18nHome getMONI18nHome() throws NamingException {
        final InitialContext ctx = new InitialContext();
        return (MONI18nHome) PortableRemoteObject.narrow(ctx.lookup("java:comp/env/MONI18n"), MONI18nHome.class );
    }
}
