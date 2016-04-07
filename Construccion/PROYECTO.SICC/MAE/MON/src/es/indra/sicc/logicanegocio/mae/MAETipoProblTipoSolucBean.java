package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeTipoProblTipoSolucData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MAETipoProblTipoSolucBean implements SessionBean {
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

    public Vector query(MaeTipoProblTipoSolucData maeTipoProblTipoSolucFrom, 
                        MaeTipoProblTipoSolucData maeTipoProblTipoSolucTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
                        
        DAOTipoProblTipoSoluc daoTipoProblTipoSoluc = new DAOTipoProblTipoSoluc();
        return daoTipoProblTipoSoluc.query(maeTipoProblTipoSolucFrom, maeTipoProblTipoSolucTo, userProperties, pageCount, pageSize);
    }

    public Hashtable guardar(MaeTipoProblTipoSolucData maeTipoProblTipoSoluc, 
                             Vector localizationLabels, HashMap userProperties) throws MareException {
        DAOTipoProblTipoSoluc daoTipoProblTipoSoluc = new DAOTipoProblTipoSoluc();
        return daoTipoProblTipoSoluc.guardar(maeTipoProblTipoSoluc, localizationLabels, userProperties);
    }

    public void remove(Vector entities) throws MareException {
        DAOTipoProblTipoSoluc daoTipoProblTipoSoluc = new DAOTipoProblTipoSoluc();
        daoTipoProblTipoSoluc.remove(entities);
    }

    public void update(MaeTipoProblTipoSolucData maeTipoProblTipoSoluc, 
                       Vector localizationLabels) throws MareException {
        DAOTipoProblTipoSoluc daoTipoProblTipoSoluc = new DAOTipoProblTipoSoluc();
        daoTipoProblTipoSoluc.update(maeTipoProblTipoSoluc, localizationLabels);               
    }
}
