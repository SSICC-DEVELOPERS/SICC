package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeEncueNseData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mae.DTOTipoEncuesta;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONEncuestaNSEBean implements SessionBean {
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

    public Hashtable guardarEncuestaNse(MaeEncueNseData maeEncueNse, 
                                        Vector localizationLabels, HashMap userProperties) throws MareException{
        UtilidadesLog.info("MONEncuestaNSEBean.guardarEncuestaNse(MaeEncueNseData maeEncueNse, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOEncuestaNSE dao = new DAOEncuestaNSE();
        UtilidadesLog.info("MONEncuestaNSEBean.guardarEncuestaNse(MaeEncueNseData maeEncueNse, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarEncuestaNSE(maeEncueNse, localizationLabels, userProperties);                              
    }

    public Vector query(MaeEncueNseData maeEncueNseFrom, 
                        MaeEncueNseData maeEncueNseTo, HashMap userProperties, 
                        Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONEncuestaNSE.query(MaeEncueNseData maeEncueNseFrom, MaeEncueNseData maeEncueNseTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada ");
        DAOEncuestaNSE dao = new DAOEncuestaNSE();
        UtilidadesLog.info("MONEncuestaNSE.query(MaeEncueNseData maeEncueNseFrom, MaeEncueNseData maeEncueNseTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada ");
            
        return dao.query(maeEncueNseFrom, maeEncueNseTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeEncueNseData maeEncueNse, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONEncuestaNSE.update(MaeEncueNseData maeEncueNse, Vector localizationLabels): Entrada");
        DAOEncuestaNSE dao = new DAOEncuestaNSE();
        dao.update(maeEncueNse, localizationLabels);
        UtilidadesLog.info("MONEncuestaNSE.update(MaeEncueNseData maeEncueNse, Vector localizationLabels): Salida");                
    }

    public void remove(DTOOIDs maeEncueNse) throws MareException {
        UtilidadesLog.info("MONEncuestaNse.remove(Vector encueNse): Entrada");
        DAOEncuestaNSE dao = new DAOEncuestaNSE();
        dao.remove(maeEncueNse);
        UtilidadesLog.info("MONEncuestaNse.remove(Vector encueNse): Salida");
    }

    public DTOSalida buscarEncuestaNSE(DTOTipoEncuesta dtoe) throws MareException {
        UtilidadesLog.info("MONEncuestaNSE.buscarEncuestaNse(DTOTipoEncuesta dtoe): Entrada");
        DAOEncuestaNSE dao = new DAOEncuestaNSE();
        DTOSalida dtoSalida = dao.buscarEncuestasNSE(dtoe);
        UtilidadesLog.info("MONEncuestaNSE.buscarEncuestaNse(DTOTipoEncuesta dtoe): Salida");
        return dtoSalida;
    }
}
