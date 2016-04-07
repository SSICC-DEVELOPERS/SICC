package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeTipoPrefeData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MAETipoPreferBean implements SessionBean {
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

    public Vector query(MaeTipoPrefeData maeTipoPrefeFrom, 
                        MaeTipoPrefeData maeTipoPrefeTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        DAOTipoPrefer daoTipoPrefer = new DAOTipoPrefer();
        return daoTipoPrefer.query(maeTipoPrefeFrom, maeTipoPrefeTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector entities) throws MareException {
        DAOTipoPrefer daoTipoPrefer = new DAOTipoPrefer();
        daoTipoPrefer.remove(entities);
    }

    public Hashtable guardar(MaeTipoPrefeData maeTipoPrefe, 
                             Vector localizationLabels, HashMap userProperties) throws MareException {
        DAOTipoPrefer daoTipoPrefer = new DAOTipoPrefer();
        return daoTipoPrefer.guardar(maeTipoPrefe, localizationLabels, userProperties);
    }

    public void update(MaeTipoPrefeData maeTipoPrefe, 
                       Vector localizationLabels) throws MareException {
        DAOTipoPrefer daoTipoPrefer = new DAOTipoPrefer();
        daoTipoPrefer.update(maeTipoPrefe, localizationLabels);               
    }
}
