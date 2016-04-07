package es.indra.sicc.logicanegocio.bel;
import java.util.Hashtable;
import java.util.Vector;
import java.util.HashMap;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.belcorp.mso.BelEstadMercaData;
import es.indra.mare.common.exception.MareException;

public class MONEstadosMercanciaBean implements SessionBean 
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
  
  public Hashtable insertar(BelEstadMercaData belEstadMercaData, Vector vector , HashMap userProperties) throws MareException
    {        
        DAOEstadosMercaderia daoEstadosMercaderia = new DAOEstadosMercaderia();
    
        return daoEstadosMercaderia.insertar( belEstadMercaData,  vector,  userProperties) ;
    }

    public Vector query(BelEstadMercaData belEstadMercaFrom, BelEstadMercaData belEstadMercaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOEstadosMercaderia daoEstadosMercaderia = new DAOEstadosMercaderia();
    
        return daoEstadosMercaderia.query(belEstadMercaFrom, belEstadMercaTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector belEstadMerca ) throws MareException
    {
        DAOEstadosMercaderia daoEstadosMercaderia = new DAOEstadosMercaderia();
    
        daoEstadosMercaderia.remove(belEstadMerca);
    }

    public void update(BelEstadMercaData belEstadMercaData, Vector localizationLabels) throws MareException
    {
        DAOEstadosMercaderia daoEstadosMercaderia = new DAOEstadosMercaderia();
    
        daoEstadosMercaderia.update(belEstadMercaData, localizationLabels);
    }
  
}