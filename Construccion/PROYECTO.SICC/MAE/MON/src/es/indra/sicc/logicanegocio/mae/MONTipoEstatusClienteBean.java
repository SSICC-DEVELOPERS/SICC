package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoEstatClienData;
import es.indra.mare.common.exception.MareException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoEstatusClienteBean implements SessionBean 
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
  
  public Hashtable insertar(MaeTipoEstatClienData maeTipoEstatClienData, Vector vector , HashMap userProperties) throws MareException
    {        
        DAOTipoEstatusCliente daoTipoEstatusCliente = new DAOTipoEstatusCliente();
    
        return daoTipoEstatusCliente.insertar( maeTipoEstatClienData,  vector,  userProperties) ;
    }

  public Vector query(MaeTipoEstatClienData maeTipoEstatClienFrom, MaeTipoEstatClienData maeTipoEstatClienTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
  {
      DAOTipoEstatusCliente daoTipoEstatusCliente = new DAOTipoEstatusCliente();
  
      return daoTipoEstatusCliente.query(maeTipoEstatClienFrom, maeTipoEstatClienTo, userProperties, pageCount, pageSize);
  }

  public void remove(Vector MaeTipoEstatClienData ) throws MareException
  {
      DAOTipoEstatusCliente daoTipoEstatusCliente = new DAOTipoEstatusCliente();
  
      daoTipoEstatusCliente.remove(MaeTipoEstatClienData);
  }

  public void update(MaeTipoEstatClienData MaeTipoEstatClienData, Vector localizationLabels) throws MareException
  {
      DAOTipoEstatusCliente daoTipoEstatusCliente = new DAOTipoEstatusCliente();
  
      daoTipoEstatusCliente.update(MaeTipoEstatClienData, localizationLabels);
  }
  
}