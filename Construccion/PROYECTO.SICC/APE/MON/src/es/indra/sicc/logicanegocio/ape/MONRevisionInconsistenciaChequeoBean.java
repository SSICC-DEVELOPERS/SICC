package es.indra.sicc.logicanegocio.ape;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ape.DTODate;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;

public class MONRevisionInconsistenciaChequeoBean implements SessionBean {
    private SessionContext ctx;    
    public void ejbCreate()   {   }
    public void ejbActivate()   {   }
    public void ejbPassivate()   {   }
    public void ejbRemove()   {   }
    public void setSessionContext(SessionContext ctx) { this.ctx = ctx; }

   /** 
    * Autor: Cristian Valenzuela
    * Fecha: 30/05/2007
    */
    public DTOSalida buscarInconsistenciaChequeo(DTODate dtoe) 
        throws MareException  {        
        UtilidadesLog.info("MONRevisionInconsistenciaChequeoBean.buscarInconsistenciaChequeo"+
        "(DTODate dtoe): Entrada");        
        DAORevisionInconsistenciaChequeo dao = new DAORevisionInconsistenciaChequeo();            
        DTOSalida dtoSalida = dao.buscarInconsistenciaChequeo(dtoe);        
        UtilidadesLog.info("MONRevisionInconsistenciaChequeoBean.buscarInconsistenciaChequeo"+
        "(DTODate dtoe): Salida");
        return dtoSalida;
    }
    
   /** 
    * Autor: Cristian Valenzuela
    * Fecha: 30/05/2007
    */
    public DTOSalida revisarCaja(DTOListaPicadoDetalle dtoe) 
        throws MareException  {       
        UtilidadesLog.info("MONRevisionInconsistenciaChequeoBean.revisarCaja"+
        "(DTODate dtoe): Entrada");        
        DAORevisionInconsistenciaChequeo dao = new DAORevisionInconsistenciaChequeo();            
        DTOSalida dtoSalida = dao.revisarCaja(dtoe);
        UtilidadesLog.info("MONRevisionInconsistenciaChequeoBean.revisarCaja"+
        "(DTODate dtoe): Salida");
        return dtoSalida;
    }

   /** 
    * Autor: Cristian Valenzuela
    * Fecha: 30/05/2007
    */
    
    /* Modificado por: Cristian Valenzuela
     * Fecha: 25/6/2007
     * Incidencia: BELC400000526 
     */    
    public void guardarInconsistenciaChequeo(DTOColeccion dtoe) 
        throws MareException  {            
        UtilidadesLog.info("MONRevisionInconsistenciaChequeoBean.guardarInconsistenciaChequeo"+
        "(DTOColeccion dtoe): Entrada");      
        
        ArrayList lista = dtoe.getLista();
        int cant = lista.size();
        UtilidadesLog.debug("********* cant: " + cant);
        DAORevisionInconsistenciaChequeo dao = new DAORevisionInconsistenciaChequeo();
        DAOChequeoCajas daoChequeoCajas = new DAOChequeoCajas();
        DTOListaPicadoDetalle dtoDetalle = null;
        
        try {
            for(int i=0; i<cant; i++) {
                dtoDetalle = (DTOListaPicadoDetalle)lista.get(i);
                UtilidadesLog.debug("********* DTOListaPicadoDetalle: " + dtoDetalle);
                
                //BELC400000526 
                //if(dtoDetalle.getNombrePicador()==null) {            
                if(dtoDetalle.getCodigoError()!=null && 
                dtoDetalle.getCodigoError().equals(ConstantesAPE.SOBRANTE_FACTURA)) {
                    /* dmorello, 11/09/2007 - Por cambio en CU */
                    /* Fin dmorello 11/09/2007 */
                    UtilidadesLog.debug("********* Llamando a guardarHistoricoListaPicadoErrorSF");
                    dao.guardarHistoricoListaPicadoErrorSF(dtoDetalle);
                    UtilidadesLog.debug("********* Llamando a eliminarDetalle");
                    dao.eliminarDetalle(dtoDetalle);
                }
                else {
                    UtilidadesLog.debug("********* Llamando a actualizarDetalle");
                    dao.actualizarDetalle(dtoDetalle);
                    // dmorello, 14/09/2007: La etiqueta se actualiza incondicionalmente
                    //dao.actualizaEstadoEtiqueta(dtoDetalle);
                }
                
                // dmorello, 14/09/2007: La etiqueta se actualiza incondicionalmente
                UtilidadesLog.debug("********* Llamando a actualizaEstadoEtiqueta");
                dao.actualizaEstadoEtiqueta(dtoDetalle);
            }  
        } catch (MareException e) {
            ctx.setRollbackOnly();
            throw e;
        }
        
        // vbongiov -- Cambio APE-012 -- 20/05/2008        
        Long oidCabecera = null;
        if(daoChequeoCajas.todasEtiquetaCheq(dtoDetalle).booleanValue()){
            oidCabecera = daoChequeoCajas.validarClienteChequear(dtoDetalle);
            
            if(oidCabecera != null){
               daoChequeoCajas.actualizarResultRevision(oidCabecera);
            }
        }
        
        UtilidadesLog.info("MONRevisionInconsistenciaChequeoBean.guardarInconsistenciaChequeo"+
        "(DTOColeccion dtoe): Salida");        
    }

}
