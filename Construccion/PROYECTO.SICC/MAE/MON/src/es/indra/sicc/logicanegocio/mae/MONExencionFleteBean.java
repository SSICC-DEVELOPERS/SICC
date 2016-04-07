package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeClasiViewData;
import es.indra.belcorp.mso.MaeExencFleteData;
import es.indra.belcorp.mso.MaeSubtiClienViewData;
import es.indra.belcorp.mso.MaeTipoClasiClienViewData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONExencionFleteBean implements SessionBean {
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

    public Vector query(MaeSubtiClienViewData maeSubtiClienViewFrom, 
                        MaeSubtiClienViewData maeSubtiClienViewTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONExencionFleteBean.query(MaeSubtiClienViewData maeSubtiClienViewFrom, MaeSubtiClienViewData maeSubtiClienViewTo, HashMap userProperties): Entrada");
        DAOExencionFlete dao = new DAOExencionFlete();
        UtilidadesLog.info("MONExencionFleteBean.query(MaeSubtiClienViewData maeSubtiClienViewFrom, MaeSubtiClienViewData maeSubtiClienViewTo, HashMap userProperties): Salida");
        return dao.query(maeSubtiClienViewFrom, maeSubtiClienViewTo, userProperties);
    }

    public Vector query(MaeTipoClasiClienViewData maeTipoClasiClienViewFrom, 
                        MaeTipoClasiClienViewData maeTipoClasiClienViewTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONExencionFlete.query(MaeTipoClasiClienViewData maeTipoClasiClienViewFrom, MaeTipoClasiClienViewData maeTipoClasiClienViewTo, HashMap userProperties): Entrada");
        DAOExencionFlete dao = new DAOExencionFlete();
        UtilidadesLog.info("MONExencionFlete.query(MaeTipoClasiClienViewData maeTipoClasiClienViewFrom, MaeTipoClasiClienViewData maeTipoClasiClienViewTo, HashMap userProperties): Salida");
        return dao.query(maeTipoClasiClienViewFrom, maeTipoClasiClienViewTo, userProperties);
    }

    public Vector query(MaeClasiViewData maeClasiViewFrom, 
                        MaeClasiViewData maeClasiViewTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONExencionFlete.query(MaeClasiViewData maeClasiViewFrom, MaeClasiViewData maeClasiViewTo, HashMap userProperties):Entrada");
        DAOExencionFlete dao = new DAOExencionFlete();
        UtilidadesLog.info("MONExencionFlete.query(MaeClasiViewData maeClasiViewFrom, MaeClasiViewData maeClasiViewTo, HashMap userProperties):Salida");
        return dao.query(maeClasiViewFrom, maeClasiViewTo, userProperties);
    }

    public Hashtable guardarExencionFlete(MaeExencFleteData maeExencFlete, 
                                          Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONExencionFlete.guardarExencionFlete(MaeExencFleteData maeExencFlete, Vector localizationLabels, HashMap userProperties): Entrada ");
        DAOExencionFlete dao = new DAOExencionFlete();
        UtilidadesLog.info("MONExencionFlete.guardarExencionFlete(MaeExencFleteData maeExencFlete, Vector localizationLabels, HashMap userProperties): Salida ");
        return dao.guardarExencionFlete(maeExencFlete, localizationLabels, userProperties);
    }

    public Vector query(MaeExencFleteData maeExencFleteFrom, 
                        MaeExencFleteData maeExencFleteTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONExencionFleteBean.query(MaeExencFleteData maeExencFleteFrom, MaeExencFleteData maeExencFleteTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");  
        DAOExencionFlete dao = new DAOExencionFlete();
        UtilidadesLog.info("MONExencionFleteBean.query(MaeExencFleteData maeExencFleteFrom, MaeExencFleteData maeExencFleteTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");  
        return dao.query(maeExencFleteFrom, maeExencFleteTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeExencFleteData maeExencFlete, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONExencionFleteBean.update(MaeExencFleteData maeExencFlete, Vector localizationLabels): Entrada");
        DAOExencionFlete dao = new DAOExencionFlete();
        dao.update(maeExencFlete, localizationLabels);
        UtilidadesLog.info("MONExencionFleteBean.update(MaeExencFleteData maeExencFlete, Vector localizationLabels): Salida");                
    }

    public void remove(Vector maeExencFlete) throws MareException {
        UtilidadesLog.info("MONExencionFlete.remove(Vector maeExencionFlete ): Entrada ");
        DAOExencionFlete dao = new DAOExencionFlete();
        dao.remove(maeExencFlete);
        UtilidadesLog.info("MONExencionFlete.remove(Vector maeExencionFlete ): Salida ");
    }
}
