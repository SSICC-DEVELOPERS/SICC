package es.indra.sicc.cmn.negocio.busqueda;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBusquedaGenerica;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.CodigosError;


import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.EJBException;



public class MONBusquedaGenericaBean implements SessionBean {

  private SessionContext ctx;

  public void ejbCreate() { }

  public void ejbActivate(){ }

  public void ejbPassivate() { }

  public void ejbRemove() { }

  public void setSessionContext(SessionContext ctx) {
    this.ctx = ctx;
  }

  public DTOSalida RealizarBusqueda(DTOBusquedaGenerica dto) throws MareException {
    DTOSalida dtoSalida = new DTOSalida();
    RecordSet salida = null;  
    try{
      if(dto.getEsPaginado().booleanValue())      {
        salida = getService().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(dto.obtenerSQL(),dto));
      }else{
        salida = getService().dbService.executeStaticQuery(dto.obtenerSQL());
      }
      
    }catch(Exception e) {
      throw new MareException(e);
    }
    if(salida.esVacio()){
      throw new MareException(new Exception(),                                                            
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }
     
    dtoSalida.setResultado(salida);
    return dtoSalida;
}


  private BelcorpService getService() throws EJBException {
     try{
        BelcorpService belcorpService = BelcorpService.getInstance();
        return belcorpService;        
        
     } catch (MareMiiServiceNotFoundException mmsnfe) {
              throw new EJBException(mmsnfe);
     }     
  }        
}