package es.indra.sicc.logicanegocio.zon;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.belcorp.mso.ZonEstruGeopoData;
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.exception.MareException;
import es.indra.belcorp.mso.ZonSubesGeopoData;
import java.util.Hashtable;

public class MONEstruGeopolBean implements SessionBean 
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

    public Vector query(ZonEstruGeopoData zonEstruGeopoFrom, ZonEstruGeopoData zonEstruGeopoTo, HashMap userProperties) throws MareException
    {
        DAOEstruGeopol daoEstruGeopol = new DAOEstruGeopol();
        return daoEstruGeopol.query(zonEstruGeopoFrom, zonEstruGeopoTo, userProperties);
    }

    public Hashtable guardar(ZonSubesGeopoData zonSubesGeopo, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOEstruGeopol daoEstruGeopol = new DAOEstruGeopol();
        return daoEstruGeopol.guardar(zonSubesGeopo, localizationLabels, userProperties);
    }

    public void update(ZonSubesGeopoData zonSubesGeopo, Vector localizationLabels) throws MareException
    {
        DAOEstruGeopol daoEstruGeopol = new DAOEstruGeopol();
        daoEstruGeopol.update(zonSubesGeopo, localizationLabels);
    }

    public void remove(Vector entities) throws MareException
    {
        DAOEstruGeopol daoEstruGeopol = new DAOEstruGeopol();
        daoEstruGeopol.remove(entities);
    }
    
}