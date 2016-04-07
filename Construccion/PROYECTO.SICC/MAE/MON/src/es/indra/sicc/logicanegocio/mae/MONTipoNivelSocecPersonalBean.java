package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoNivelSocecPersoData;
import es.indra.mare.common.exception.MareException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoNivelSocecPersonalBean implements SessionBean 
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
  
  public Hashtable insertar(MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoData, Vector vector , HashMap userProperties) throws MareException
    {        
        DAOTipoNivelSocecPersonal daoTipoNivelSocecPersonal = new DAOTipoNivelSocecPersonal();
    
        return daoTipoNivelSocecPersonal.insertar( maeTipoNivelSocecPersoData,  vector,  userProperties) ;
    }

  public Vector query(MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoFrom, MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
  {
      DAOTipoNivelSocecPersonal daoTipoNivelSocecPersonal = new DAOTipoNivelSocecPersonal();
  
      return daoTipoNivelSocecPersonal.query(maeTipoNivelSocecPersoFrom, maeTipoNivelSocecPersoTo, userProperties, pageCount, pageSize);
  }

  public void remove(Vector MaeTipoNivelSocecPersoData ) throws MareException
  {
      DAOTipoNivelSocecPersonal daoTipoNivelSocecPersonal = new DAOTipoNivelSocecPersonal();
  
      daoTipoNivelSocecPersonal.remove(MaeTipoNivelSocecPersoData);
  }

  public void update(MaeTipoNivelSocecPersoData MaeTipoNivelSocecPersoData, Vector localizationLabels) throws MareException
  {
      DAOTipoNivelSocecPersonal daoTipoNivelSocecPersonal = new DAOTipoNivelSocecPersonal();
  
      daoTipoNivelSocecPersonal.update(MaeTipoNivelSocecPersoData, localizationLabels);
  }
  
}