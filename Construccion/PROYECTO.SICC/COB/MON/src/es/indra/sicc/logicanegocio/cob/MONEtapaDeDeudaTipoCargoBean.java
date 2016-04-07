package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CccTipoCargoAbonoData;
import es.indra.belcorp.mso.CobEtapaDeudaData;
import es.indra.belcorp.mso.CobEtapaDeudaTipoCargoData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONEtapaDeDeudaTipoCargoBean implements SessionBean {
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

    public Vector query(CccTipoCargoAbonoData cccTipoCargoAbonoFrom, 
                        CccTipoCargoAbonoData cccTipoCargoAbonoTo, HashMap userProperties) throws MareException
    {   UtilidadesLog.info("MONCobEtapaDeudaTipoCargo.query(CccTipoCargoAbonoData cccTipoCargoAbonoFrom, CccTipoCargoAbonoData cccTipoCargoAbonoTo, HashMap userProperties):Entrada");
        DAOEtapaDeDeudaTipoCargo dao = new DAOEtapaDeDeudaTipoCargo();
        UtilidadesLog.info("MONCobEtapaDeudaTipoCargo.query(CccTipoCargoAbonoData cccTipoCargoAbonoFrom, CccTipoCargoAbonoData cccTipoCargoAbonoTo, HashMap userProperties):Salida");
        
        return dao.query(cccTipoCargoAbonoFrom, cccTipoCargoAbonoTo, userProperties );
    
   
    }

    public Vector query(CobEtapaDeudaData cobEtapaDeudaFrom, 
                        CobEtapaDeudaData cobEtapaDeudaTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCobEtapaDeudaTipoCargo.query(CobEtapaDeudaData cobEtapaDeudaFrom, CobEtapaDeudaData cobEtapaDeudaTo, HashMap userProperties):Entrada");
        DAOEtapaDeDeudaTipoCargo dao = new DAOEtapaDeDeudaTipoCargo();
    
        UtilidadesLog.info("MONCobEtapaDeudaTipoCargo.query(CobEtapaDeudaData cobEtapaDeudaFrom, CobEtapaDeudaData cobEtapaDeudaTo, HashMap userProperties):Salida");
        return dao.query(cobEtapaDeudaFrom,cobEtapaDeudaTo, userProperties );

    }

    public Vector query(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoFrom, 
                        CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONCobEtapaDeudaTipoCargo.query(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoFrom, CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOEtapaDeDeudaTipoCargo dao = new DAOEtapaDeDeudaTipoCargo();
        UtilidadesLog.info("MONCobEtapaDeudaTipoCargo.query(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoFrom, CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        return dao.query(cobEtapaDeudaTipoCargoFrom, cobEtapaDeudaTipoCargoTo, userProperties, pageCount,pageSize);
    
   
    }

    public void update(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, 
                       Vector localizationLabels) throws MareException
    {   UtilidadesLog.info("MONCobEtapaDeudaTipoCargo.update(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, Vector localizationLabels):Entrada");
        DAOEtapaDeDeudaTipoCargo dao = new DAOEtapaDeDeudaTipoCargo();
        dao.update(cobEtapaDeudaTipoCargo, localizationLabels);
        UtilidadesLog.info("MONCobEtapaDeudaTipoCargo.update(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, Vector localizationLabels):Entrada");
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONCobEtapaDeudaTipoCargo.remove(Vector entities):Entrada");
        DAOEtapaDeDeudaTipoCargo dao = new DAOEtapaDeDeudaTipoCargo();
        dao.remove(entities);
        UtilidadesLog.info("MONCobEtapaDeudaTipoCargo.remove(Vector entities):Salida");
    }

    public Hashtable guardar(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, 
                             Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCobEtapaDeudaTipoCargo.guardar(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, Vector localizationLabels, HashMap userProperties):Entrada");
        DAOEtapaDeDeudaTipoCargo dao = new DAOEtapaDeDeudaTipoCargo();
        UtilidadesLog.info("MONCobEtapaDeudaTipoCargo.guardar(CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargo, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardar(cobEtapaDeudaTipoCargo,localizationLabels, userProperties);
    
    
    }
}
