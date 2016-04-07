package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoPerfiPsicoData;
import es.indra.mare.common.exception.MareException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoPerfilPsicoBean implements SessionBean 
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
  
   public Hashtable insertar(MaeTipoPerfiPsicoData maeTipoPerfiPsicoData, Vector vector , HashMap userProperties) throws MareException
    {        
        DAOTipoPerfilPsico daoTipoPerfilPsico = new DAOTipoPerfilPsico();
    
        return daoTipoPerfilPsico.insertar( maeTipoPerfiPsicoData,  vector,  userProperties) ;
    }

  public Vector query(MaeTipoPerfiPsicoData maeTipoPerfiPsicoFrom, MaeTipoPerfiPsicoData maeTipoPerfiPsicoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
  {
      DAOTipoPerfilPsico daoTipoPerfilPsico = new DAOTipoPerfilPsico();
  
      return daoTipoPerfilPsico.query(maeTipoPerfiPsicoFrom, maeTipoPerfiPsicoTo, userProperties, pageCount, pageSize);
  }

  public void remove(Vector MaeTipoPerfiPsicoData ) throws MareException
  {
      DAOTipoPerfilPsico daoTipoPerfilPsico = new DAOTipoPerfilPsico();
  
      daoTipoPerfilPsico.remove(MaeTipoPerfiPsicoData);
  }

  public void update(MaeTipoPerfiPsicoData MaeTipoPerfiPsicoData, Vector localizationLabels) throws MareException
  {
      DAOTipoPerfilPsico daoTipoPerfilPsico = new DAOTipoPerfilPsico();
  
      daoTipoPerfilPsico.update(MaeTipoPerfiPsicoData, localizationLabels);
  }
  
}