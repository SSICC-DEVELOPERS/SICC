package es.indra.sicc.logicanegocio.zon;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.belcorp.mso.SegMarcaData;
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.exception.MareException;
import es.indra.belcorp.mso.SegMarcaData;
import es.indra.belcorp.mso.ZonEstadZonaData;
import java.util.Hashtable;

public class MONEstadosZonasBean implements SessionBean 
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
    
    public Vector query(SegMarcaData segMarcaFrom, SegMarcaData segMarcaTo, HashMap userProperties) throws MareException
    {
        DAOEstadosZonas daoEstadosZonas = new DAOEstadosZonas();
    
        return daoEstadosZonas.query(segMarcaFrom, segMarcaTo, userProperties);
    }

    public Hashtable guardar(ZonEstadZonaData zonEstadZona, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOEstadosZonas daoEstadosZonas = new DAOEstadosZonas(); 
        
        return daoEstadosZonas.guardar(zonEstadZona, localizationLabels, userProperties) ;
    }
    
    public void update(ZonEstadZonaData zonEstadZona, Vector localizationLabels) throws MareException
    {
        DAOEstadosZonas daoEstadosZonas = new DAOEstadosZonas(); 
        daoEstadosZonas.update(zonEstadZona, localizationLabels);
    }

    public void remove(Vector zonEstadZonaOids) throws MareException
    {
        DAOEstadosZonas daoEstadosZonas = new DAOEstadosZonas();
        daoEstadosZonas.remove(zonEstadZonaOids);
    }

    public Vector query(ZonEstadZonaData zonEstadZonaFrom, ZonEstadZonaData zonEstadZonaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOEstadosZonas daoEstadosZonas = new DAOEstadosZonas();
    
        return daoEstadosZonas.query(zonEstadZonaFrom, zonEstadZonaTo, userProperties, pageCount, pageSize);
    }
    
}