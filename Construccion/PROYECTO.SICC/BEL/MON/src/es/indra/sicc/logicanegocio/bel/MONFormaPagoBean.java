package es.indra.sicc.logicanegocio.bel;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.Hashtable;
import java.util.Vector;
import java.util.HashMap;
import es.indra.belcorp.mso.BelFormaPagoData;
import es.indra.mare.common.exception.MareException;

public class MONFormaPagoBean implements SessionBean 
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
  
  public Hashtable insertar(BelFormaPagoData belFormaPagoData, Vector vector , HashMap userProperties) throws MareException
    {        
        DAOFormaPago daoFormaPago = new DAOFormaPago();
    
        return daoFormaPago.insertar( belFormaPagoData,  vector,  userProperties) ;
    }

 public Vector query(BelFormaPagoData belFormaPagoDataFrom, BelFormaPagoData belFormaPagoDataTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOFormaPago daoFormaPago = new DAOFormaPago();
    
        return daoFormaPago.query(belFormaPagoDataFrom, belFormaPagoDataTo, userProperties, pageCount, pageSize);
    }

 public void remove(Vector belFormaPago ) throws MareException
    {
        DAOFormaPago daoFormaPago = new DAOFormaPago();
    
        daoFormaPago.remove(belFormaPago);
    }

 public void update(BelFormaPagoData belFormaPagoData, Vector localizationLabels) throws MareException
    {
        DAOFormaPago daoFormaPago = new DAOFormaPago();
    
        daoFormaPago.update(belFormaPagoData, localizationLabels);
    }
  
}