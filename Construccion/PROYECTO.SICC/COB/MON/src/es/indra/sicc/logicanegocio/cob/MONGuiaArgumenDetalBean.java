package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobArgumData;
import es.indra.belcorp.mso.CobGuionArgumCabecData;
import es.indra.belcorp.mso.CobGuionArgumDetalData;
import es.indra.belcorp.mso.CobValorArgumData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONGuiaArgumenDetalBean implements SessionBean {
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

    public Vector query(CobValorArgumData cobValorArgumFrom, 
                        CobValorArgumData cobValorArgumTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCobGuiasArgumDetal.query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties):Entrada");
        DAOGuiaArgumenDetal dao = new  DAOGuiaArgumenDetal();
    
        UtilidadesLog.info("MONCobGuiasArgumDetal.query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties):Salida");
        return dao.query(cobValorArgumFrom, cobValorArgumTo, userProperties);
   
    }

    public Vector query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, HashMap userProperties) throws MareException
    {   UtilidadesLog.info("MONCobGuiasArgumDetal.query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, HashMap userProperties):Entrada");
        DAOGuiaArgumenDetal dao = new  DAOGuiaArgumenDetal();
        UtilidadesLog.info("MONCobGuiasArgumDetal.query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, HashMap userProperties):Salida");
        return dao.query(cobArgumFrom, cobArgumTo, userProperties);
    }

    public Vector query(CobGuionArgumCabecData cobGuionArgumCabecFrom, 
                        CobGuionArgumCabecData cobGuionArgumCabecTo, HashMap userProperties) throws MareException
    {   UtilidadesLog.info("MONCobGuiasArgumDetal.query(CobGuionArgumCabecData cobGuionArgumCabecFrom, CobGuionArgumCabecData cobGuionArgumCabecTo, HashMap userProperties):Entrada");
        DAOGuiaArgumenDetal dao = new  DAOGuiaArgumenDetal();
    
      UtilidadesLog.info("MONCobGuiasArgumDetal.query(CobGuionArgumCabecData cobGuionArgumCabecFrom, CobGuionArgumCabecData cobGuionArgumCabecTo, HashMap userProperties):Entrada");
        return dao.query(cobGuionArgumCabecFrom, cobGuionArgumCabecTo, userProperties );
  
    }

    public Vector query(CobGuionArgumDetalData cobGuionArgumDetalFrom, 
                        CobGuionArgumDetalData cobGuionArgumDetalTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {   UtilidadesLog.info("MONCobGuiasArgumDetal.query(CobGuionArgumDetalData cobGuionArgumDetalFrom, CobGuionArgumDetalData cobGuionArgumDetalTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOGuiaArgumenDetal dao = new  DAOGuiaArgumenDetal();
        UtilidadesLog.info("MONCobGuiasArgumDetal.query(CobGuionArgumDetalData cobGuionArgumDetalFrom, CobGuionArgumDetalData cobGuionArgumDetalTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        return dao.query(cobGuionArgumDetalFrom, cobGuionArgumDetalTo, userProperties, pageCount, pageSize);
    
    }

    public void remove(Vector entities) throws MareException
    {   UtilidadesLog.info("MONCobGuiasArgumDetal.remove(Vector entities):Entrada");
        DAOGuiaArgumenDetal dao = new  DAOGuiaArgumenDetal();
        dao.remove(entities);
        UtilidadesLog.info("MONCobGuiasArgumDetal.remove(Vector entities):Salida");
    }

    public void update(CobGuionArgumDetalData cobGuionArgumDetal, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONCobGuiasArgumDetal.update(CobGuionArgumDetalData cobGuionArgumDetal, Vector localizationLabels):Entrada");
        DAOGuiaArgumenDetal dao = new  DAOGuiaArgumenDetal();
        dao.update(cobGuionArgumDetal,localizationLabels );
        UtilidadesLog.info("MONCobGuiasArgumDetal.update(CobGuionArgumDetalData cobGuionArgumDetal, Vector localizationLabels):SAlida");
    }
    

    public Hashtable guardar(CobGuionArgumDetalData cobGuionArgumDetal, 
                             Vector localizationLabels, HashMap userProperties) throws MareException
    {   UtilidadesLog.info("MONCobGuiasArgumDetal.guardar(CobGuionArgumDetalData cobGuionArgumDetal, Vector localizationLabels, HashMap userProperties):Entrada");
        DAOGuiaArgumenDetal dao = new  DAOGuiaArgumenDetal();
        
    
        UtilidadesLog.info("MONCobGuiasArgumDetal.guardar(CobGuionArgumDetalData cobGuionArgumDetal, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardar(cobGuionArgumDetal, localizationLabels, userProperties);
    
    }
}
