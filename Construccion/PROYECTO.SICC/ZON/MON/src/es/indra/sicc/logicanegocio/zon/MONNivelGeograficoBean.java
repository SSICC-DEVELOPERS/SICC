package es.indra.sicc.logicanegocio.zon;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.belcorp.mso.ZonNivelGeogrData;
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.exception.MareException;
import java.util.Hashtable;
import es.indra.mare.common.exception.MareException;

public class MONNivelGeograficoBean implements SessionBean 
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

    public Vector query(ZonNivelGeogrData zonNivelGeogrFrom, ZonNivelGeogrData zonNivelGeogrTo, 
    HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAONivelGeografico daoNivelGeografico = new DAONivelGeografico();
        return daoNivelGeografico.query(zonNivelGeogrFrom, zonNivelGeogrTo, userProperties, pageCount, pageSize);
    }

    public Hashtable guardar(ZonNivelGeogrData zonNivelGeogr, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAONivelGeografico daoNivelGeografico = new DAONivelGeografico();
        return daoNivelGeografico.guardar(zonNivelGeogr, localizationLabels, userProperties) ;
    }

    public void remove(Vector entities) throws MareException
    {
        DAONivelGeografico daoNivelGeografico = new DAONivelGeografico();
        daoNivelGeografico.remove(entities);
    }

    public void update(ZonNivelGeogrData zonNivelGeogr, Vector localizationLabels) throws MareException
    {
        DAONivelGeografico daoNivelGeografico = new DAONivelGeografico();
        daoNivelGeografico.update(zonNivelGeogr, localizationLabels);
    }
    
}