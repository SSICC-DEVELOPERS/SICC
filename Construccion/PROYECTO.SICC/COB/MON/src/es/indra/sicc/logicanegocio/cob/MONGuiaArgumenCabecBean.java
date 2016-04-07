package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobGuionArgumCabecData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONGuiaArgumenCabecBean implements SessionBean {
    private SessionContext _context;

    public void ejbCreate() {
    }

    public void setSessionContext(SessionContext context) throws EJBException {
        _context = context;
    }

    public void ejbRemove() throws EJBException {
    }

    public void ejbActivate() throws EJBException {
    }

    public void ejbPassivate() throws EJBException {
    }

    public Vector query(CobGuionArgumCabecData cobGuionArgumCabecFrom, 
                        CobGuionArgumCabecData cobGuionArgumCabecTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONCobGuiasArgumCabec.query(CobGuionArgumCabecData cobGuionArgumCabecFrom, CobGuionArgumCabecData cobGuionArgumCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOGuiaArgumenCabec dao = new DAOGuiaArgumenCabec();
        
        UtilidadesLog.info("MONCobGuiasArgumCabec.query(CobGuionArgumCabecData cobGuionArgumCabecFrom, CobGuionArgumCabecData cobGuionArgumCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        return dao.query(cobGuionArgumCabecFrom, cobGuionArgumCabecTo, userProperties, pageCount, pageSize);
   
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONCobGuiasArgumCabec.remove(Vector entities):Entrada");
        DAOGuiaArgumenCabec dao = new DAOGuiaArgumenCabec();
        dao.remove(entities);
        UtilidadesLog.info("MONCobGuiasArgumCabec.remove(Vector entities):Salida");
    }

    public void update(CobGuionArgumCabecData cobGuionArgumCabec, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONCobGuiasArgumCabec.update(CobGuionArgumCabecData cobGuionArgumCabec, Vector localizationLabels):Entrada");
        DAOGuiaArgumenCabec dao = new DAOGuiaArgumenCabec();
        dao.update(cobGuionArgumCabec, localizationLabels);
        UtilidadesLog.info("MONCobGuiasArgumCabec.update(CobGuionArgumCabecData cobGuionArgumCabec, Vector localizationLabels):Salida");
    }

    public Hashtable guardar(CobGuionArgumCabecData cobGuionArgumCabec, 
                             Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCobGuiasArgumCabec.guardar(CobGuionArgumCabecData cobGuionArgumCabec, Vector localizationLabels, HashMap userProperties):Entrada");
        DAOGuiaArgumenCabec dao = new DAOGuiaArgumenCabec();
    
        UtilidadesLog.info("MONCobGuiasArgumCabec.guardar(CobGuionArgumCabecData cobGuionArgumCabec, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardar(cobGuionArgumCabec, localizationLabels, userProperties);
   
    }
}
