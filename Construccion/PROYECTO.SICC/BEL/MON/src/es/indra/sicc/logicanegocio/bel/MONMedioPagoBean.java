package es.indra.sicc.logicanegocio.bel;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.Hashtable;
import java.util.Vector;
import java.util.HashMap;
import es.indra.belcorp.mso.BelMedioPagoData;
import es.indra.belcorp.mso.BelTipoMedioPagoData;
import es.indra.mare.common.exception.MareException;

public class MONMedioPagoBean implements SessionBean 
{
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
  }

  
  public Hashtable insertar(BelMedioPagoData belMedioPagoData, Vector vector , HashMap userProperties) throws MareException
    {        
        DAOMedioPago daoMedioPago = new DAOMedioPago();
    
        return daoMedioPago.insertar( belMedioPagoData,  vector,  userProperties) ;
    }

  public Vector query(BelMedioPagoData belMedioPagoFrom, BelMedioPagoData belMedioPagoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
  {
      DAOMedioPago daoMedioPago = new DAOMedioPago();
  
      return daoMedioPago.query(belMedioPagoFrom, belMedioPagoTo, userProperties, pageCount, pageSize);
  }

  public void remove(Vector belMedioPagoData ) throws MareException
  {
      DAOMedioPago daoMedioPago = new DAOMedioPago();
  
      daoMedioPago.remove(belMedioPagoData);
  }

  public void update(BelMedioPagoData belMedioPagoData, Vector localizationLabels) throws MareException
  {
      DAOMedioPago daoMedioPago = new DAOMedioPago();
  
      daoMedioPago.update(belMedioPagoData, localizationLabels);
  }

  public Vector query(BelTipoMedioPagoData belTipoMedioPagoFrom, BelTipoMedioPagoData belTipoMedioPagoTo, HashMap userProperties) throws MareException
  {
    DAOMedioPago daoMedioPago = new DAOMedioPago();

    return daoMedioPago.query(belTipoMedioPagoFrom, belTipoMedioPagoTo, userProperties);
 }
 
  
}