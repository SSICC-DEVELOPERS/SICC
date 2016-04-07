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
 *
 */
 
package es.indra.sicc.logicanegocio.dto;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.SessionBean;
import java.rmi.RemoteException;
import javax.ejb.SessionContext;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.dto.DTOAprobarDescuento;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOID; 
import es.indra.sicc.dtos.dto.DTOAprobacionDescuento;
import es.indra.sicc.dtos.dto.DTOSolicitudSeleccionada;

import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.dto.DescuentoLocalHome;
import es.indra.sicc.entidades.dto.DescuentoLocal;
import es.indra.sicc.dtos.dto.DTODescuento;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


/**
 * Sistema:           Belcorp
 * Modulo:            DTO
 * Submódulo:           
 * Componente:        MONSimulacionDescuentoBean
 * Fecha:             28/07/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 *
 * @version           1.0
 * @autor             Federico I. Hofman
 */
public class MONSimulacionDescuentoBean implements SessionBean {

    private SessionContext ctx;

    public void ejbCreate() {
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
     * 
     */
    public DTOColeccion cargarSolicitudes(DTOColeccion dto) throws MareException {
        UtilidadesLog.info("MONSimulacionDescuentoBean.cargarSolicitudes(): Entrada");
        /*
        Documentation
        Entrada: 
        - dto : DTOColeccion (contiene un array de oidSolicitud) 
        Proceso: 
        -> Crear variable llamada listaSalida de tipo arrayList 
        -> Recorrer el atributo dto.lista de tipo arrayList 
        Para cada oid contenido en el array hacer: 
        -> Crear variable llamada solicitudSeleccionada de tipo      
        - cabecera : DTOObtenerCabeceraDTO 
        - detalle : RecordSet 
        -> Llamar al método "DAOSolicitud.obtenerCabaceraDTO(oidSolicitud : Long) : DTOObtenerCabeceraDTO" pasando el oid 
        -> solicitudSeleccionada.cabecra <= DTOObtenerCabeceraDTO obtenido 
        -> Llamar al método "DAOSolicitud.obtenerPosicionesDTO(oidSolicitud : Long) : DTOSalida" pasando el oid 
        -> solicitudSeleccionada.detalle <= RecordSet del DTOSalida obtenido en llamada anterior 
        -> Añadir solicitudSeleccionada a la variable listaSalida 
        Fin Para 
        Devolver listaSalida dentro de un DTOColeccion
        */
        DTOColeccion col;
        ArrayList listaSalida =  new ArrayList();
        try {
            ArrayList lista  = dto.getLista();  
            Iterator listaIter = lista.iterator();
        
            while(listaIter.hasNext()){
                Long oidSolicitud = (Long)listaIter.next();
                DTOSolicitudSeleccionada solicitudSeleccionada = new DTOSolicitudSeleccionada();
                DAOSolicitud daoSol = new DAOSolicitud();
                solicitudSeleccionada.setCabecera(daoSol.obtenerCabeceraDTO(oidSolicitud));
                DTOSalida dtoSal =  daoSol.obtenerPosicionesDTO(oidSolicitud);
                solicitudSeleccionada.setDetalle(dtoSal.getResultado());
                listaSalida.add(solicitudSeleccionada);
            }
            col = new DTOColeccion();
            col.setLista(listaSalida);        
        } catch(MareException me) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(me);
            throw me;
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONSimulacionDescuentoBean.cargarSolicitudes(): Salida");
        return col;
    }


    /**
     * 
     */
    public DTOSalida pedirSolicitudesDetalle(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONSimulacionDescuentoBean.pedirSolicitudesDetalle(): Entrada");
        /*
        Documentation
        Entrada: 
        - dto : DTOOID 
        Proceso: 
        -> Llamar al método "DAOSolicitud.obtenerPosicionesDTO(oidSolicitud : Long) : DTOSalida" pasando el oid del dto de entrada 
        -> Devolver DTOSalida de respuesta
        */
        DTOSalida dtoSalida = new DTOSalida();
        try {
            DAOSolicitud daoSol = new DAOSolicitud();
            dtoSalida = daoSol.obtenerPosicionesDTO(dto.getOid());

        } catch(MareException me) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(me);
            throw me;
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONSimulacionDescuentoBean.pedirSolicitudesDetalle(): Salida");
        return dtoSalida;
    }


    /**
     * 
     */
    public DTOAprobarDescuento cargarAprobarDescuento(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONSimulacionDescuentoBean.cargarAprobarDescuento(): Entrada");
        /*
        Documentation
        Entrada: 
        - dto : DTOOID (oid de descuento) 
        Proceso: 
            -> Llamar al método "MONMantenimientoDTO.obtenerDescuento(dto : DTOOID) : DTODescuento" con dto de entrada 
        -> Crear objeto DTOAprobarDescuento haciendo el siguiente mapeo: 
        -> DTOAprobarDescuento.descripcion <= DTODescuento.datosGenerales.descripcionDescuento 
        -> DTOAprobarDescuento.descripcionPeriodoDesde <= DTODescuento.datosGenerales.descripcion 
        -> Tomar el atributo DTODescuento.datosGenerales.oidPeriodoDesde para la siguiente llamada 
        -> Hacer findByPrimayKey sobre la entidad Periodo 
        -> DTOAprobarDescuento.descripcionPeriodoDesde <= Periodo.nombrePeriodo 
        -> Tomar el atributo DTODescuento.datosGenerales.oidPeriodoHasta para la siguiente llamada 
        -> Hacer findByPrimayKey sobre la entidad Periodo 
        -> DTOAprobarDescuento.descripcionPeriodoHasta <= Periodo.nombrePeriodo 
        -> DTOAprobarDescuento.indicadorActivo <= DTODescuento.datosGenerales.activo 
        -> DTOAprobarDescuento.indicadorAprobado <= DTODescuento.datosGenerales.aprobado 
        -> Crear una variable de tipo arrayList llamada listaTiposCliente 
        -> Recorrer el atributo DTODescuento.alcanceTipoCliente.tiposCliente de tipo RecordSet 
        Para cada registro hacer: 
        -> Añadir a listaTiposCliente la descripción de tipo cliente contenida en el RecordSet 
        Fin Para 
        -> DTOAprobarDescuento.listaTiposCliente <= listaTiposCliente creada 
        -> Devolver DTOAprobarDescuento creado 
        */
        DTOAprobarDescuento apro = null;
        try{
            UtilidadesLog.debug("Entrando a cargarAprobarDescuento");
            MONMantenimientoDTOHome descHome = getMONMantenimientoDTOHome();
            MONMantenimientoDTO desc = descHome.create();   
            
            DTODescuento dtoDesc = desc.obtenerDescuento(dto);
            UtilidadesLog.debug("Datos del descuento obtenido");
            apro  = new DTOAprobarDescuento();
            apro.setDescripcionDescuento(dtoDesc.getDatosGenerales().getDescripcion());
            PeriodoLocalHome periodo = new PeriodoLocalHome();
            PeriodoLocal periD = periodo.findByPrimaryKey(dtoDesc.getDatosGenerales().getOidPeriodoDesde());
            apro.setDescripcionPeriodoDesde(periD.getNombrePeriodo());

            //Se corrige porque no es obligatorio el fin del período           
            if ( dtoDesc.getDatosGenerales().getOidPeriodoHasta() != null)
            {
                PeriodoLocal periH = periodo.findByPrimaryKey(dtoDesc.getDatosGenerales().getOidPeriodoHasta());
                apro.setDescripcionPeriodoDesde(periH.getNombrePeriodo());
            }

            apro.setIndicadorActivo(dtoDesc.getDatosGenerales().getActivo());
            apro.setIndicadorAprobado(dtoDesc.getDatosGenerales().getAprobado());

            ArrayList listaTiposCliente = new ArrayList();  

            RecordSet rs = dtoDesc.getAlcanceTipoCliente().getTiposCliente();
            for (int i = 0;  i < rs.getRowCount() ;  i++){
                listaTiposCliente.add(rs.getValueAt(i,1));
            }
            apro.setListaTiposCliente(listaTiposCliente);
            
        }catch(CreateException eee){
            ctx.setRollbackOnly();
             throw new MareException(eee,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }catch(NoResultException eeee){
            ctx.setRollbackOnly();
             throw new MareException(eeee,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } catch(MareException me) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(me);
            throw me;
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONSimulacionDescuentoBean.cargarAprobarDescuento(): Salida");
        return apro;
    }


    /**
     * 
     */
    public void aprobarDescuento(DTOAprobacionDescuento dto) throws MareException { 
        UtilidadesLog.info("MONSimulacionDescuentoBean.aprobarDescuento(): Entrada");
        /*
        Documentation
        Entrada: 
        - dto : DTOAprobacionDescuento 
        Proceso: 
        -> Hacer findByPrimaryKey sobre la entidad Descuento con el oid contenido en el dto de entrada 
        -> Actualizar el atributo aprobado con el dato del dto de entrada
         */
        try{
            DescuentoLocalHome desclh = new DescuentoLocalHome();
            DescuentoLocal desc =  desclh.findByPrimaryKey(dto.getOidDescuento());
            desc.setInd_apro(UtilidadesDTO.getLong(dto.getAprobado()));
        
        }catch(NoResultException eeee){
            ctx.setRollbackOnly();
             throw new MareException(eeee,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(MareException me) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(me);
            throw me;
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONSimulacionDescuentoBean.aprobarDescuento(): Salida");
    }


    private MONMantenimientoDTOHome getMONMantenimientoDTOHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONMantenimientoDTOHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoDTO"), MONMantenimientoDTOHome.class);
    }


}
