/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.logicanegocio.fac;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTOAsignacionImpresoras;
import es.indra.sicc.entidades.fac.AsignacionImpresoraLocal;
import es.indra.sicc.entidades.fac.AsignacionImpresoraLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoImpresorasBean implements SessionBean 
{
   	private SessionContext ctx;
    
    public void ejbCreate()
    {
    }

    public void ejbActivate()
    {
    }

    public void ejbPassivate()
    {
    }

    public void ejbRemove()
    {
    }

    public void setSessionContext(SessionContext ctx)
    {
        this.ctx = ctx;
    }

    public DTOSalida obtenerImpresorasVirtuales() throws MareException  {
        UtilidadesLog.info("MONMantenimientoImpresorasBean.obtenerImpresorasVirtuales(): Entrada");
        
        DAOAsignacionImpresoras dao = new DAOAsignacionImpresoras();             
        DTOSalida dto = dao.obtenerImpresorasVirtuales();
        
        UtilidadesLog.info("MONMantenimientoImpresorasBean.obtenerImpresorasVirtuales(): Salida");
        return dto;
    }

    public void guardarAsignacionImpresoras(DTOAsignacionImpresoras dtoe) throws MareException {
       UtilidadesLog.info("MONMantenimientoImpresorasBean.guardarAsignacionImpresoras(DTOAsignacionImpresoras dtoe): Entrada");
       UtilidadesLog.debug("dtoe:" + dtoe);
       
       String codigoError;
       AsignacionImpresoraLocalHome home;
       AsignacionImpresoraLocal asigImpre;
       
        try{
            home = getAsignacionImpresoraLocalHome();
            asigImpre = home.create(dtoe.getImpresoraVirtual(), dtoe.getSubAcceso(),dtoe.getFormulario());
        } catch (PersistenceException e) {
            codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
              
         UtilidadesLog.info("MONMantenimientoImpresorasBean.guardarAsignacionImpresoras(DTOAsignacionImpresoras dtoe): Salida");               
    }

    public DTOSalida consultarAsignacionImpresoras(DTOAsignacionImpresoras DTOE) throws MareException {
        UtilidadesLog.info("MONMantenimientoImpresorasBean.consultarAsignacionImpresoras(DTOAsignacionImpresoras DTOE): Entrada");
        UtilidadesLog.debug("dtoe:" + DTOE);
        
        DAOAsignacionImpresoras dao = new DAOAsignacionImpresoras();             
        DTOSalida dto = dao.consultarAsignacionImpresoras(DTOE);
        
        UtilidadesLog.info("MONMantenimientoImpresorasBean.consultarAsignacionImpresoras(DTOAsignacionImpresoras DTOE): Entrada");
        return dto;
    }

    public void eliminarAsignacionImpresoras(DTOOIDs dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoImpresorasBean.eliminarAsignacionImpresoras(DTOOIDs dtoe): Entrada");  
     
       String codigoError;
       AsignacionImpresoraLocalHome home;
       
       home = getAsignacionImpresoraLocalHome();
        
        for (int i=0; i < dtoe.getOids().length ; i++) {        
            try {    
               UtilidadesLog.debug("Oid del elemento buscar" + dtoe.getOids()[i]);
               AsignacionImpresoraLocal asigImp = home.findByPrimaryKey(dtoe.getOids()[i]);   
               UtilidadesLog.debug("Se encontro el entity");
               home.remove(asigImp);               
               UtilidadesLog.debug("Se pudo borrar");
            } catch (NoResultException e) {
                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            } catch (PersistenceException e) {		
                codigoError = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
        
        }
        
        UtilidadesLog.info("MONMantenimientoImpresorasBean.eliminarAsignacionImpresoras(DTOOIDs dtoe): Salida");
    }

    private AsignacionImpresoraLocalHome getAsignacionImpresoraLocalHome() throws MareException {
        return new AsignacionImpresoraLocalHome();
    }

}
