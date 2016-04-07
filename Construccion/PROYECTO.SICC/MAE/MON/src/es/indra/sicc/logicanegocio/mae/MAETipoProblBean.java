package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeTipoProblData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.mare.common.exception.MareException;

public class MAETipoProblBean implements SessionBean {
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

    public Vector query(MaeTipoProblData maeTipoProblFrom, 
                        MaeTipoProblData maeTipoProblTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        DAOTipoProbl daoTipoProbl = new DAOTipoProbl();
        return daoTipoProbl.query(maeTipoProblFrom, maeTipoProblTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector entities) throws MareException {
        DAOTipoProbl daoTipoProbl = new DAOTipoProbl();
        daoTipoProbl.remove(entities);
    }

    public void update(MaeTipoProblData maeTipoProbl, 
                       Vector localizationLabels) throws MareException {
        DAOTipoProbl daoTipoProbl = new DAOTipoProbl();
        daoTipoProbl.update(maeTipoProbl, localizationLabels);               
    }

    public Hashtable guardar(MaeTipoProblData maeTipoProbl, 
                             Vector localizationLabels, HashMap userProperties) throws MareException {
        DAOTipoProbl daoTipoProbl = new DAOTipoProbl();
        return daoTipoProbl.guardar(maeTipoProbl, localizationLabels, userProperties);
    }

    public Vector query(MaeTipoProblData maeTipoProblFrom, 
                        MaeTipoProblData maeTipoProblTo, HashMap userProperties) throws MareException{
        DAOTipoProbl daoTipoProbl = new DAOTipoProbl();
        return daoTipoProbl.query(maeTipoProblFrom, maeTipoProblTo, userProperties);
    }
}
