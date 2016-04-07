package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoClasiClienData;
import es.indra.mare.common.exception.MareException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoClasificacionClienteBean implements SessionBean 
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
  
  public Hashtable insertar(MaeTipoClasiClienData maeTipoClasiClienData, Vector vector , HashMap userProperties) throws MareException
    {        
        DAOTipoClasificacionCliente daoTipoClasificacionCliente = new DAOTipoClasificacionCliente();
    
        return daoTipoClasificacionCliente.insertar( maeTipoClasiClienData,  vector,  userProperties) ;
    }

  public Vector query(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
  {
      DAOTipoClasificacionCliente daoTipoClasificacionCliente = new DAOTipoClasificacionCliente();
  
      return daoTipoClasificacionCliente.query(maeTipoClasiClienFrom, maeTipoClasiClienTo, userProperties, pageCount, pageSize);
  }

  public void remove(Vector MaeTipoClasiClienData ) throws MareException
  {
      DAOTipoClasificacionCliente daoTipoClasificacionCliente = new DAOTipoClasificacionCliente();
  
      daoTipoClasificacionCliente.remove(MaeTipoClasiClienData);
  }

  public void update(MaeTipoClasiClienData MaeTipoClasiClienData, Vector localizationLabels) throws MareException
  {
      DAOTipoClasificacionCliente daoTipoClasificacionCliente = new DAOTipoClasificacionCliente();
  
      daoTipoClasificacionCliente.update(MaeTipoClasiClienData, localizationLabels);
  }
  
}