package es.indra.sicc.logicanegocio.zon;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.Vector;
import es.indra.belcorp.mso.ZonSubesGeopoData;
import java.util.HashMap;
import es.indra.mare.common.exception.MareException;

public class MONSubesGeopolBean implements SessionBean 
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

    public Vector query(ZonSubesGeopoData zonSubesGeopoFrom, ZonSubesGeopoData zonSubesGeopoTo, HashMap userProperties, 
                        Integer pageCount, Integer pageSize) throws MareException
    {
        DAOSubesGeopol daoSubesGeopol = new DAOSubesGeopol();
        return daoSubesGeopol.query(zonSubesGeopoFrom, zonSubesGeopoTo, userProperties, pageCount, pageSize);
    }
    
    
}