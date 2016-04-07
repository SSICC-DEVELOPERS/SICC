package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoClienData;
import es.indra.mare.common.exception.MareException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


public class MONTipoClienteBean implements SessionBean 
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
  
   public Hashtable insertar(MaeTipoClienData maeTipoClienData, Vector vector , HashMap userProperties) throws MareException
    {        
        DAOTipoCliente daoTipoCliente = new DAOTipoCliente();
    
        return daoTipoCliente.insertar( maeTipoClienData,  vector,  userProperties) ;
    }

  public Vector query(MaeTipoClienData maeTipoClasiClienFrom, MaeTipoClienData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
  {
      DAOTipoCliente daoTipoCliente = new DAOTipoCliente();
  
      return daoTipoCliente.query(maeTipoClasiClienFrom, maeTipoClasiClienTo, userProperties, pageCount, pageSize);
  }

  public void remove(Vector maeTipoClienData ) throws MareException
  {
      DAOTipoCliente daoTipoCliente = new DAOTipoCliente();
  
      daoTipoCliente.remove(maeTipoClienData);
  }

  public void update(MaeTipoClienData MaeTipoClienData, Vector localizationLabels) throws MareException
  {
      DAOTipoCliente daoTipoCliente = new DAOTipoCliente();
  
      daoTipoCliente.update(MaeTipoClienData, localizationLabels);
  }
  
}