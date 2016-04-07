package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeTipoVincuData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MAETipoVincuBean implements SessionBean {
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

    public Vector query(MaeTipoVincuData maeTipoVincuFrom, 
                        MaeTipoVincuData maeTipoVincuTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
         DAOTipoVincu daoTipoVincu = new DAOTipoVincu();
         return daoTipoVincu.query(maeTipoVincuFrom, maeTipoVincuTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector entities) throws MareException {
        DAOTipoVincu daoTipoVincu = new DAOTipoVincu();
        daoTipoVincu.remove(entities);
    }

    public void update(MaeTipoVincuData maeTipoVincu, 
                       Vector localizationLabels) throws MareException {
        DAOTipoVincu daoTipoVincu = new DAOTipoVincu();
        daoTipoVincu.update(maeTipoVincu, localizationLabels);                       
    }

    public Hashtable guardar(MaeTipoVincuData maeTipoVincu, 
                             Vector localizationLabels, HashMap userProperties) throws MareException {
        DAOTipoVincu daoTipoVincu = new DAOTipoVincu();
        return daoTipoVincu.guardar(maeTipoVincu, localizationLabels, userProperties);        
    }
}
