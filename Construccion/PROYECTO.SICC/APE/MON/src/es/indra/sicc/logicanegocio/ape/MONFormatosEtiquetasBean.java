package es.indra.sicc.logicanegocio.ape;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ape.DTODatosEtiqueta;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.entidades.ape.FormatoEtiquetaLocalHome;
import es.indra.sicc.entidades.ape.FormatoEtiquetaLocal;
import es.indra.sicc.util.DTOBelcorp;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONFormatosEtiquetasBean implements SessionBean {
    private SessionContext ctx;    
    public void ejbCreate() {  }
    public void ejbActivate()  {   }
    public void ejbPassivate()   {   }
    public void ejbRemove()   {   }
    public void setSessionContext(SessionContext ctx) { this.ctx = ctx; }

  /** 
   * Autor: Cristian Valenzuela
   * Fecha: 11/1/2007
   */
    public void insertarFormatosEtiquetas(DTODatosEtiqueta dtoe) throws MareException  {        
        UtilidadesLog.info("MONFormatosEtiquetasBean.insertarFormatosEtiquetas"+
       "(DTODatosEtiqueta dto): Entrada");              
       
       UtilidadesLog.debug("*** DTODatosEtiqueta:" + dtoe);
       
        if(dtoe.getOidFormatoEtiqueta()==null) {
            UtilidadesLog.debug("*** insercion");
            try {
                FormatoEtiquetaLocalHome felh = new FormatoEtiquetaLocalHome();         
                felh.create(dtoe.getOidProgramaEtiqueta(), dtoe.getOidSublineaArmado());
            } catch (PersistenceException e) {
                UtilidadesLog.error("ERROR ", e);
                ctx.setRollbackOnly();                
                throw new MareException(e,
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE +
                    ErroresDeNegocio.APE_0026));
            }           
        }
        else {
            UtilidadesLog.debug("*** modificacion");
            try {
                FormatoEtiquetaLocalHome felh = new FormatoEtiquetaLocalHome();       
                FormatoEtiquetaLocal fel = felh.findByPrimaryKey(dtoe.getOidFormatoEtiqueta());
                /* BELC300024733 - dmorello, 18/04/2007 */
                //fel.setValorFormatoEtiqueta(dtoe.getFormato());
                fel.setOidProgramaEtiqueta(dtoe.getOidProgramaEtiqueta());
                /* Fin BELC300024733 dmorello 18/04/2007 */
                fel.setOidSublinea(dtoe.getOidSublineaArmado());            
                
                try {
                    felh.merge(fel);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } catch (NoResultException e) {
                UtilidadesLog.error("ERROR ", e);
                ctx.setRollbackOnly();
                throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }                
        }    
        UtilidadesLog.info("MONFormatosEtiquetasBean.insertarFormatosEtiquetas"+
        "(DTODatosEtiqueta dto): Salida");              
    }

  /** 
   * Autor: Cristian Valenzuela
   * Fecha: 11/1/2007
   */
    public DTOSalida consultarFormatosEtiquetas(DTODatosEtiqueta dtoe) throws MareException {       
       UtilidadesLog.info("MONFormatosEtiquetasBean.consultarFormatosEtiquetas"+
       "(DTODatosEtiqueta dto): Entrada");              
       DAOFormatosEtiquetas dao = new DAOFormatosEtiquetas();
       DTOSalida dtoSalida = dao.consultarFormatosEtiquetas(dtoe);       
       UtilidadesLog.info("MONFormatosEtiquetasBean.consultarFormatosEtiquetas"+
       "(DTODatosEtiqueta dto): Salida");
       return dtoSalida;
    }

  /** 
   * Autor: Cristian Valenzuela
   * Fecha: 11/1/2007
   */
    public void eliminar(DTOOIDs dtoe) throws MareException {
        UtilidadesLog.info("MONFormatosEtiquetasBean.eliminar(DTOOIDs dtoeo): Entrada");       
        try {       
            Long[] oids = dtoe.getOids();        
            int longitud = oids.length;
            UtilidadesLog.debug("*** longitud:" + longitud);
            
            FormatoEtiquetaLocal fe = null;
            FormatoEtiquetaLocalHome felh = new FormatoEtiquetaLocalHome();
            
            for(int i=0; i<longitud; i++) {                   
                fe = felh.findByPrimaryKey(oids[i]);
                try {
                    felh.remove(fe);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }           
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR ", e);
            String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(sCodigoError));
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
        
        UtilidadesLog.info("MONFormatosEtiquetasBean.eliminar(DTOOIDs dtoeo): Salida");       
    }

    /**
     * Creado por incidencia BELC300024733
     * @author dmorello
     * @since 11-04-2007
     */
    public DTOSalida obtenerProgramasEtiquetas(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONFormatosEtiquetasBean.obtenerProgramasEtiquetas(DTOBelcorp dtoe): Entrada");
        DTOSalida dto = new DAOFormatosEtiquetas().obtenerProgramasEtiquetas(dtoe);
        UtilidadesLog.info("MONFormatosEtiquetasBean.obtenerProgramasEtiquetas(DTOBelcorp dtoe): Salida");
        return dto;
    }
}