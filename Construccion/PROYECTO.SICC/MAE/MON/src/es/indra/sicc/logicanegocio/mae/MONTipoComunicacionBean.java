package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoComunData;
import es.indra.mare.common.exception.MareException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoComunicacionBean implements SessionBean 
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
  
  public Hashtable insertar(MaeTipoComunData maeTipoComunData, Vector vector , HashMap userProperties) throws MareException
    {        
        DAOTipoComunicacion daoTipoComunicacion = new DAOTipoComunicacion();
    
        return daoTipoComunicacion.insertar( maeTipoComunData,  vector,  userProperties) ;
    }

  public Vector query(MaeTipoComunData maeTipoComunFrom, MaeTipoComunData maeTipoComunTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
  {
      DAOTipoComunicacion daoTipoComunicacion = new DAOTipoComunicacion();
  
      return daoTipoComunicacion.query(maeTipoComunFrom, maeTipoComunTo, userProperties, pageCount, pageSize);
  }

  public void remove(Vector MaeTipoComunData ) throws MareException
  {
      DAOTipoComunicacion daoTipoComunicacion = new DAOTipoComunicacion();
  
      daoTipoComunicacion.remove(MaeTipoComunData);
  }

  public void update(MaeTipoComunData MaeTipoComunData, Vector localizationLabels) throws MareException
  {
      DAOTipoComunicacion daoTipoComunicacion = new DAOTipoComunicacion();
  
      daoTipoComunicacion.update(MaeTipoComunData, localizationLabels);
  }
  
}