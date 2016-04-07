package es.indra.sicc.logicanegocio.bel;
import es.indra.belcorp.mso.BelTipoMovimCajaData;
import es.indra.mare.common.exception.MareException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoMovimientoCajaBean implements SessionBean 
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
  
  public Hashtable insertar(BelTipoMovimCajaData belTipoMovimCajaData, Vector vector , HashMap userProperties) throws MareException
    {        
        DAOTipoMovimientoCaja daoTipoMovimientoCaja = new DAOTipoMovimientoCaja();
    
        return daoTipoMovimientoCaja.insertar( belTipoMovimCajaData,  vector,  userProperties) ;
    }

 public Vector query(BelTipoMovimCajaData belTipoMovimCajaFrom, BelTipoMovimCajaData belTipoMovimCajaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOTipoMovimientoCaja daoTipoMovimientoCaja = new DAOTipoMovimientoCaja();
    
        return daoTipoMovimientoCaja.query(belTipoMovimCajaFrom, belTipoMovimCajaTo, userProperties, pageCount, pageSize);
    }

 public void remove(Vector belTipoMovimCaja ) throws MareException
    {
        DAOTipoMovimientoCaja daoTipoMovimientoCaja = new DAOTipoMovimientoCaja();
    
        daoTipoMovimientoCaja.remove(belTipoMovimCaja);
    }

 public void update(BelTipoMovimCajaData belTipoMovimCajaData, Vector localizationLabels) throws MareException
    {
        DAOTipoMovimientoCaja daoTipoMovimientoCaja = new DAOTipoMovimientoCaja();
    
        daoTipoMovimientoCaja.update(belTipoMovimCajaData, localizationLabels);
    }
}