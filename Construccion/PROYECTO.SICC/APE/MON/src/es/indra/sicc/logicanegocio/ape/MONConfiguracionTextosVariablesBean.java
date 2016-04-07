package es.indra.sicc.logicanegocio.ape;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ape.DTODatosTextoVariable;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.entidades.ape.ConfiguracionTextoVariableLocalHome;
import es.indra.sicc.entidades.ape.ConfiguracionTextoVariableLocal;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONConfiguracionTextosVariablesBean implements SessionBean {
    private SessionContext ctx;    
    public void ejbCreate()  {  }
    public void ejbActivate()  {  }
    public void ejbPassivate()  {   }
    public void ejbRemove()  {   }
    public void setSessionContext(SessionContext ctx)  { this.ctx = ctx;  }
      
    /** 
     * Autor: Cristian Valenzuela
     * Fecha: 24/1/2007
     * 
     * CHANGELOG
     * ---------
     * dmorello, 08/01/2009 - Subtipo/Tipo clasif/Clasif se setean ahora en el create
     */
    public void guardarConfiguracionTextoVariable(DTODatosTextoVariable dtoe) 
    throws MareException    {
        UtilidadesLog.info("MONConfiguracionTextosVariablesBean.guardarConfiguracionTextoVariable"+
        "(DTODatosTextoVariable dtoe): Entrada");
        
        UtilidadesLog.debug("*** DTODatosTextoVariable " + dtoe);
        
        if(dtoe.getOidConfiguracionTextoVariable()==null) {
            UtilidadesLog.debug("*** insercion");
            
            try {
                ConfiguracionTextoVariableLocalHome ctvhl = new ConfiguracionTextoVariableLocalHome();
                ConfiguracionTextoVariableLocal ctvl = ctvhl.create(dtoe.getTextoVariable(), 
                    dtoe.getOidPais(), dtoe.getOidTipoCliente(), dtoe.getOidSubtipoCliente(), 
                    dtoe.getOidTipoClasificacion(), dtoe.getOidClasificacion());             
            } catch (EntityExistsException e) {
                UtilidadesLog.error("ERROR ", e);
                ctx.setRollbackOnly();
                throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
            } catch (PersistenceException e) {
                UtilidadesLog.error("ERROR ", e);
                ctx.setRollbackOnly();
                throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }                      
        }
        else {
            UtilidadesLog.debug("*** modificacion");
            
            try {
                ConfiguracionTextoVariableLocalHome ctvhl = new ConfiguracionTextoVariableLocalHome();
                ConfiguracionTextoVariableLocal ctvl =                 
                ctvhl.findByPrimaryKey(dtoe.getOidConfiguracionTextoVariable());
                
                ctvl.setTextoVariable(dtoe.getTextoVariable());
                ctvl.setOidPais(dtoe.getOidPais());
                ctvl.setOidTipoCliente(dtoe.getOidTipoCliente());
                ctvl.setOidTipoClasificacion(dtoe.getOidTipoClasificacion());
                ctvl.setOidSubtipoCliente(dtoe.getOidSubtipoCliente());
                ctvl.setOidClasificacion(dtoe.getOidClasificacion());              
                
                try {
                    ctvhl.merge(ctvl);
                } catch (PersistenceException e) {
                    UtilidadesLog.error("ERROR ", e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } catch (NoResultException e) {
                UtilidadesLog.error("ERROR ", e);
                ctx.setRollbackOnly();
                throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                UtilidadesLog.error("ERROR ", e);
                ctx.setRollbackOnly();
                throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }                
        }   
    
        UtilidadesLog.info("MONConfiguracionTextosVariablesBean.guardarConfiguracionTextoVariable"+
        "(DTODatosTextoVariable dtoe): Salida");
    }
 
 /** 
   * Autor: Cristian Valenzuela
   * Fecha: 24/1/2007
   */
    public DTOSalida consultarConfiguracionTextoVariable(DTODatosTextoVariable dtoe) 
    throws MareException  {
        UtilidadesLog.info("MONConfiguracionTextosVariablesBean.consultarConfiguracionTextoVariable"+
        "(DTODatosTextoVariable dtoe): Entrada");         
        DAOConfiguracionTextoVariable dao = new DAOConfiguracionTextoVariable();
        DTOSalida dtoSalida = dao.consultarConfiguarcionTextoVariable(dtoe);                    
        UtilidadesLog.info("MONConfiguracionTextosVariablesBean.consultarConfiguracionTextoVariable"+
        "(DTODatosTextoVariable dtoe): Salida");
        return dtoSalida;
    }
 
 /** 
   * Autor: Cristian Valenzuela
   * Fecha: 24/1/2007
   */
    public void eliminar(DTOOIDs dtoe) throws MareException  {
        UtilidadesLog.info("MONConfiguracionTextosVariablesBean.eliminar"+
        "(DTOOIDs dtoe): Entrada");
        
        try   {
            Long[] oids = dtoe.getOids();        
            int longitud = oids.length;
            UtilidadesLog.debug("*** longitud:" + longitud);
            
            ConfiguracionTextoVariableLocal ctvl = null;
            ConfiguracionTextoVariableLocalHome ctvlh = new ConfiguracionTextoVariableLocalHome();
            
            for(int i=0; i< longitud ; i++) {                   
                ctvl = ctvlh.findByPrimaryKey(oids[i]);
                try {
                    ctvlh.remove(ctvl);
                } catch (PersistenceException e) {
                    UtilidadesLog.error("ERROR ", e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }                       
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR ", e);
            String sCodigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(sCodigoError));
        }        
        
        UtilidadesLog.info("MONConfiguracionTextosVariablesBean.eliminar"+
        "(DTOOIDs dtoe): Salida");
    }

}