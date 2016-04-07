package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeTipoSolucData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MAETipoSolucBean implements SessionBean {
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

    public Vector query(MaeTipoSolucData maeTipoSolucFrom, 
                        MaeTipoSolucData maeTipoSolucTo, HashMap userProperties) throws MareException {
        DAOTipoSoluc daoTipoSoluc = new DAOTipoSoluc();
        return daoTipoSoluc.query(maeTipoSolucFrom, maeTipoSolucTo, userProperties);
    }

    public Vector query(MaeTipoSolucData maeTipoSolucFrom, 
                        MaeTipoSolucData maeTipoSolucTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        DAOTipoSoluc daoTipoSoluc = new DAOTipoSoluc();
        return daoTipoSoluc.query(maeTipoSolucFrom, maeTipoSolucTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector entities) throws MareException {
        DAOTipoSoluc daoTipoSoluc = new DAOTipoSoluc();
        daoTipoSoluc.remove(entities);    
    }

    public void update(MaeTipoSolucData maeTipoSoluc, 
                       Vector localizationLabels) throws MareException {
        DAOTipoSoluc daoTipoSoluc = new DAOTipoSoluc();
        daoTipoSoluc.update(maeTipoSoluc, localizationLabels);                    
    }

    public Hashtable guardar(MaeTipoSolucData maeTipoSoluc, 
                             Vector localizationLabels, HashMap userProperties) throws MareException {
        DAOTipoSoluc daoTipoSoluc = new DAOTipoSoluc();
        return daoTipoSoluc.guardar(maeTipoSoluc, localizationLabels, userProperties);    
                             
    }
}
