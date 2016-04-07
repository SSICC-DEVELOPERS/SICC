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

package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.ped.DTOMontoMinimo;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.entidades.ped.MontoMinimoLocalHome;
import es.indra.sicc.entidades.ped.MontoMinimoLocal;
import es.indra.sicc.logicanegocio.ped.DAOPED;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMontoMinimoBean implements SessionBean  {
    private SessionContext sessionContext;
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        sessionContext = ctx;
    }

    
    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       27/07/2004
     * @version     1.0
     * @autor       Marta Aurora Montiel
     * Descripcion: 
     */
    public void elimina(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONMontoMinimoBean.elimina(DTOOIDs dto): Entrada ");

        MontoMinimoLocal monMinimoL;
           
        try{
            MontoMinimoLocalHome montoMinLH = new MontoMinimoLocalHome();
            
            Long[] oids = dto.getOids();

            for(int i=0; i<oids.length; i++){
                // Elimina el registro
                monMinimoL = montoMinLH.findByPrimaryKey(oids[i]);
                try {
                    montoMinLH.remove(monMinimoL);
                } catch (PersistenceException pe) {
                    sessionContext.setRollbackOnly();
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }
            
         }catch (NoResultException nre) {
            UtilidadesLog.error("Exception: ",nre);
            sessionContext.setRollbackOnly();
            throw new MareException(nre,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         }catch (PersistenceException e) {
            UtilidadesLog.error("Exception: ",e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         } 
        UtilidadesLog.info("MONMontoMinimoBean.elimina(DTOOIDs dto): Salida ");
    }


    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       27/07/2004
     * @version     1.0
     * @autor       Marta Aurora Montiel
     * Descripcion: 
     */
    public void guarda(DTOMontoMinimo dto) throws  RemoteException, MareException {
        UtilidadesLog.info("MONMontoMinimoBean.guarda(DTOMontoMinimo dto): Entrada ");
        MontoMinimoLocal monMinimoL;

        try{
            DAOPED dao =new DAOPED();
            MontoMinimoLocalHome montoMinLH = new MontoMinimoLocalHome();
        
            int largo = 1 ;
             if(dto.getOidRegiones()!=null){
               largo = dto.getOidRegiones().size();
             }
             if(dto.getOidZonas()!=null){
               largo = dto.getOidZonas().size();
             }
             for(int i=0;i<largo;i++){
               
                if(dto.getOid()!=null){
                    // Modificación
                    monMinimoL = montoMinLH.findByPrimaryKey(dto.getOid());
                
                    monMinimoL.setNivel1(dto.getNivel1());
                    monMinimoL.setNivel2(dto.getNivel2());
                    monMinimoL.setNivel3(dto.getNivel3());
                    monMinimoL.setRecargo(dto.getRecargo());
                    monMinimoL.setMontoMinimo(dto.getMontoMinimo());
                    monMinimoL.setSubtipoCliente((dto.getOidSubtipoCliente()));
                    monMinimoL.setTipoClasificacion(dto.getOidTipoClasificacion());    
                    monMinimoL.setClasificacion(dto.getOidClasificacion());     
                
                } else {       
                    // Inserción
                    if(!dao.existenciaMontoMinimo(dto, i)){
                        try {
                            monMinimoL = montoMinLH.create(dto.getNivel1(), dto.getNivel2(), dto.getNivel3(), dto.getOidTipoCliente(), dto.getTipoSolicitudPais());
                        } catch (PersistenceException pe) {
                            UtilidadesLog.error("Exception: ",pe);
                            sessionContext.setRollbackOnly();
                            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                        
                        monMinimoL.setRecargo(dto.getRecargo());
                        monMinimoL.setMontoMinimo(dto.getMontoMinimo());
                        monMinimoL.setSubtipoCliente((dto.getOidSubtipoCliente()));
                        monMinimoL.setTipoClasificacion(dto.getOidTipoClasificacion());    
                        monMinimoL.setClasificacion(dto.getOidClasificacion());
                        if(dto.getOidRegiones()!=null){
                          monMinimoL.setRegion((Long)dto.getOidRegiones().get(i));
                        }
                        if(dto.getOidZonas()!=null){
                          monMinimoL.setZona((Long)dto.getOidZonas().get(i));
                        }

                    }else{
                          UtilidadesLog.warn("Ya existe un monto minimo para esos parametros");
                          throw new MareException(new Exception(), 
                          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                    }
                } 
                             
                try {
                    montoMinLH.merge(monMinimoL);
                } catch (PersistenceException pe) {
                    UtilidadesLog.error("Exception: ",pe);
                    sessionContext.setRollbackOnly();
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
             } 
        } catch (NoResultException e) {
            UtilidadesLog.error("Exception: ",e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe){
            UtilidadesLog.error("Exception: ",pe);
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMontoMinimoBean.guarda(DTOMontoMinimo dto): Salida ");
    }


    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       27/07/2004
     * @version     1.0
     * @autor       Marta Aurora Montiel
     * Descripcion: Consulta los montos mínimos con los criterios dados en el dto. 
        1.- Invoca a DAOPED.obtieneMontoMinimo(dto) y devuelve el DTOSalida. 
     */
    public DTOSalida consulta(DTOMontoMinimo dto) throws  RemoteException, MareException {
        UtilidadesLog.info("MONMontoMinimoBean.consulta(DTOMontoMinimo dto): Entrada ");
        String user = sessionContext.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);
		
		DTOSalida dtoSalida = dao.obtieneMontoMinimo(dto);
        UtilidadesLog.info("MONMontoMinimoBean.consulta(DTOMontoMinimo dto): Salida ");
		return dtoSalida;     
    }

    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       27/07/2004
     * @version     1.0
     * @autor       Marta Aurora Montiel
     * Descripcion: Consulta los detalles del monto mínimo identificado por dto.oid. 
     */
    public DTOMontoMinimo consultaDetalles(DTOOID dto) throws  RemoteException, MareException {
        UtilidadesLog.info("MONMontoMinimoBean.consultaDetalles(DTOOID dto): Entrada ");
       
        DTOMontoMinimo dtoMontoMin= new DTOMontoMinimo();
        try{                
                MontoMinimoLocalHome montoMinLH = new MontoMinimoLocalHome();
                
                MontoMinimoLocal monMinimoL = montoMinLH.findByPrimaryKey(dto.getOid());

                dtoMontoMin.setOid(dto.getOid());
                dtoMontoMin.setTipoSolicitudPais(monMinimoL.getTipoSolicitudPais());
                dtoMontoMin.setNivel1(monMinimoL.getNivel1());
                dtoMontoMin.setNivel2(monMinimoL.getNivel2());
                dtoMontoMin.setNivel3(monMinimoL.getNivel3());
                dtoMontoMin.setRecargo(monMinimoL.getRecargo());
                dtoMontoMin.setMontoMinimo(monMinimoL.getMontoMinimo());
                dtoMontoMin.setOidSubtipoCliente(monMinimoL.getSubtipoCliente());
                dtoMontoMin.setOidTipoClasificacion(monMinimoL.getTipoClasificacion());    
                dtoMontoMin.setOidClasificacion(monMinimoL.getClasificacion());           
                if(monMinimoL.getRegion()!=null){
                  ArrayList oidregion = new ArrayList();
                  oidregion.add(monMinimoL.getRegion());
                  dtoMontoMin.setOidRegiones(oidregion);
                }
                if(monMinimoL.getZona()!=null){
                    ArrayList oidZona = new ArrayList();
                    oidZona.add(monMinimoL.getZona());
                    dtoMontoMin.setOidZonas(oidZona);
                }
        }catch (NoResultException nre) {
            sessionContext.setRollbackOnly();
            throw new MareException(nre,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }catch (PersistenceException exception) {
		    sessionContext.setRollbackOnly();
			throw new MareException(exception,
				  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
		}

        UtilidadesLog.info("MONMontoMinimoBean.consultaDetalles(DTOOID dto): Salida ");
        return dtoMontoMin;
    }


}
