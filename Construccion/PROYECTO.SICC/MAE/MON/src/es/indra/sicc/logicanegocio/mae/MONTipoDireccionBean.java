package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoDirecData;
import es.indra.mare.common.exception.MareException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoDireccionBean implements SessionBean 
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
  
   public Hashtable insertar(MaeTipoDirecData maeTipoDirecData, Vector vector , HashMap userProperties) throws MareException
    {        
        DAOTipoDireccion daoTipoDireccion = new DAOTipoDireccion();
    
        return daoTipoDireccion.insertar( maeTipoDirecData,  vector,  userProperties) ;
    }

  public Vector query(MaeTipoDirecData maeTipoClasiClienFrom, MaeTipoDirecData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
  {
      DAOTipoDireccion daoTipoDireccion = new DAOTipoDireccion();
  
      return daoTipoDireccion.query(maeTipoClasiClienFrom, maeTipoClasiClienTo, userProperties, pageCount, pageSize);
  }

  public void remove(Vector MaeTipoDirecData ) throws MareException
  {
      DAOTipoDireccion daoTipoDireccion = new DAOTipoDireccion();
  
      daoTipoDireccion.remove(MaeTipoDirecData);
  }

  public void update(MaeTipoDirecData MaeTipoDirecData, Vector localizationLabels) throws MareException
  {
      DAOTipoDireccion daoTipoDireccion = new DAOTipoDireccion();
  
      daoTipoDireccion.update(MaeTipoDirecData, localizationLabels);
  }
  
}