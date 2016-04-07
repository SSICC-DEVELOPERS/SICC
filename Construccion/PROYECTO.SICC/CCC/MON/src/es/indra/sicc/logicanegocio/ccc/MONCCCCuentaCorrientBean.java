package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccBancoData;
import es.indra.belcorp.mso.CccCuentContaData;
import es.indra.belcorp.mso.CccCuentCorriBancaData;
import es.indra.belcorp.mso.CccSucurData;
import es.indra.belcorp.mso.SegSocieData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCCCCuentaCorrientBean implements SessionBean {
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

    public Vector query(CccCuentContaData cccCuentContaFrom, 
                        CccCuentContaData cccCuentContaTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCCCCuentaCorrentBean.query(CccCuentContaData cccCuentContaFrom, CccCuentContaData cccCuentContaTo, HashMap userProperties): Entrada");
        DAOCuentaCorriente dao = new DAOCuentaCorriente();
        UtilidadesLog.info("MONCCCCuentaCorrentBean.query(CccCuentContaData cccCuentContaFrom, CccCuentContaData cccCuentContaTo, HashMap userProperties): Salida");
        return dao.query(cccCuentContaFrom , cccCuentContaTo, userProperties);
    }

    public Vector query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCCCCuentaCorrientBean.query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, HashMap userProperties): Entrada");
        DAOCuentaCorriente dao = new DAOCuentaCorriente();
        UtilidadesLog.info("MONCCCCuentaCorrientBean.query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, HashMap userProperties): Salida");
        return dao.query(cccSucurFrom, cccSucurTo, userProperties);
    }

    public Vector query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, 
                        HashMap userProperties, Boolean applyStructuralSecurity) throws MareException {
        UtilidadesLog.info("MONCCCCuentaCorrientBean.query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, HashMap userProperties, Boolean applyStructuralSecurity): Entrada");
        DAOCuentaCorriente dao = new DAOCuentaCorriente();
        UtilidadesLog.info("MONCCCCuentaCorrientBean.query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, HashMap userProperties, Boolean applyStructuralSecurity): Salida");
        return dao.query(cccSucurFrom, cccSucurTo, userProperties, applyStructuralSecurity);
    }

    public Vector query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCCCCuentaCorrientBean.query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, HashMap userProperties): Entrada");
        DAOCuentaCorriente dao = new DAOCuentaCorriente();
        UtilidadesLog.info("MONCCCCuentaCorrientBean.query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, HashMap userProperties): Salida");
        return dao.query(cccBancoFrom, cccBancoTo, userProperties);
    }

    public Vector query(SegSocieData segSocieFrom, SegSocieData segSocieTo, HashMap userProperties) throws MareException {
    
        UtilidadesLog.info("MONCCCCuentaCorrientBean.query(SegSocieData segSocieFrom, SegSocieData segSocieTo, HashMap userProperties): Entrada");
        DAOCuentaCorriente dao = new DAOCuentaCorriente();
        UtilidadesLog.info("MONCCCCuentaCorrientBean.query(SegSocieData segSocieFrom, SegSocieData segSocieTo, HashMap userProperties): Salida");
        return dao.query(segSocieFrom, segSocieTo, userProperties);
    }

    public Hashtable guradarCuentaCorrient(CccCuentCorriBancaData cccCuentCorriBanca, 
                                           Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCCCCuentaCorrientBean.guardarCuentaCorrient(CccCuentCorriBancaData cccCuentCorriBanca, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOCuentaCorriente dao = new DAOCuentaCorriente();
        UtilidadesLog.info("MONCCCCuentaCorrientBean.guardarCuentaCorrient(CccCuentCorriBancaData cccCuentCorriBanca, Vector localizationLabels, HashMap userProperties): Entrada");
        return dao.guardarCuentaCorrient(cccCuentCorriBanca, localizationLabels, userProperties);
    }

    public Vector query(CccCuentCorriBancaData cccCuentCorriBancaFrom, 
                        CccCuentCorriBancaData cccCuentCorriBancaTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONCCCCuentaCorrintBean.query(CccCuentCorriBancaData cccCuentCorriBancaFrom, CccCuentCorriBancaData cccCuentCorriBancaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCuentaCorriente dao = new DAOCuentaCorriente();
        UtilidadesLog.info("MONCCCCuentaCorrintBean.query(CccCuentCorriBancaData cccCuentCorriBancaFrom, CccCuentCorriBancaData cccCuentCorriBancaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(cccCuentCorriBancaFrom, cccCuentCorriBancaTo, userProperties, pageCount, pageSize);
    }

    public void update(CccCuentCorriBancaData cccCuentCorriBanca, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info(" MONCCCCuentaCorrintBean.update(CccCuentCorriBancaData cccCuentCorriBanca, Vector localizationLabels): Entrada");
        DAOCuentaCorriente dao = new DAOCuentaCorriente();
        dao.update(cccCuentCorriBanca, localizationLabels);
        UtilidadesLog.info(" MONCCCCuentaCorrintBean.update(CccCuentCorriBancaData cccCuentCorriBanca, Vector localizationLabels): Entrada");               
    }

    public void remove(Vector cccCuentCorriBanca) throws MareException {
        UtilidadesLog.info("MONCCCCuentaCorrientBean.remove(Vector cccCuentaCorriente): Entrada");
        DAOCuentaCorriente dao = new DAOCuentaCorriente();
        dao.remove(cccCuentCorriBanca);
        UtilidadesLog.info("MONCCCCuentaCorrientBean.remove(Vector cccCuentaCorriente): Salida");
    }
}
