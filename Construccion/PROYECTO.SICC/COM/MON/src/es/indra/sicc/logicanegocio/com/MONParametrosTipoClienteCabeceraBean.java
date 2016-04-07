package es.indra.sicc.logicanegocio.com;

import es.indra.belcorp.mso.ComTipoClienComisCabecData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONParametrosTipoClienteCabeceraBean implements SessionBean {
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

    public Vector query(ComTipoClienComisCabecData comTipoClienComisCabecFrom, 
                        ComTipoClienComisCabecData comTipoClienComisCabecTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
                        
    {   UtilidadesLog.info("MONParametrosTipoClienteCabecera.query(ComTipoClienComisCabecData comTipoClienComisCabecFrom, ComTipoClienComisCabecData comTipoClienComisCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOParametrosTipoClienteCabecera dao = new DAOParametrosTipoClienteCabecera();
        UtilidadesLog.info("MONParametrosTipoClienteCabecera.query(ComTipoClienComisCabecData comTipoClienComisCabecFrom, ComTipoClienComisCabecData comTipoClienComisCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        return dao.query(comTipoClienComisCabecFrom, comTipoClienComisCabecTo, userProperties, pageCount, pageSize);
    }

    public void update(ComTipoClienComisCabecData comTipoClienComisCabec, 
                       Vector localizationLabels) throws MareException
    {   UtilidadesLog.info("MONParametrosTipoClienteCabecera.update(ComTipoClienComisCabecData comTipoClienComisCabec, Vector localizationLabels): Entrada");
        DAOParametrosTipoClienteCabecera dao = new DAOParametrosTipoClienteCabecera();
        dao.update(comTipoClienComisCabec, localizationLabels);
        UtilidadesLog.info("MONParametrosTipoClienteCabecera.update(ComTipoClienComisCabecData comTipoClienComisCabec, Vector localizationLabels): Salida");
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONParametrosTipoClienteCabecera.remove(Vector entities):Entrada");
    
        DAOParametrosTipoClienteCabecera dao = new DAOParametrosTipoClienteCabecera();
        dao.remove(entities);
        UtilidadesLog.info("MONParametrosTipoClienteCabecera.remove(Vector entities):Salida");
    }

    public Hashtable guardar(ComTipoClienComisCabecData comTipoClienComisCabec, 
                             Vector localizationLabels, HashMap userProperties) throws MareException
    {   UtilidadesLog.info("MONParametrosTipoClienteCabecera.guardar(ComTipoClienComisCabecData comTipoClienComisCabec, Vector LocalizationLabels, HashMap userProperties):Entrada");
        DAOParametrosTipoClienteCabecera dao = new DAOParametrosTipoClienteCabecera();
        
        UtilidadesLog.info("MONParametrosTipoClienteCabecera.guardar(ComTipoClienComisCabecData comTipoClienComisCabec, Vector LocalizationLabels, HashMap userProperties):Salida");
    
    
        return dao.guardar(comTipoClienComisCabec, localizationLabels,userProperties);
    }
}
