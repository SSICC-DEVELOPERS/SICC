package es.indra.sicc.logicanegocio.msg;

import es.indra.belcorp.mso.MsgMetacData;
import es.indra.belcorp.mso.MsgTipoMetacData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONMetacaracteresBean implements SessionBean {
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

    public Vector query(MsgTipoMetacData msgTipoMetacFrom, 
                        MsgTipoMetacData msgTipoMetacTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MonMetacaracteresData.query(MsgTipoMetacData msgTipoMetacFrom, MsgTipoMetacData msgTipoMetacTo, HashMap userProperties):Entrada ");
        DAOMetacaracteres dao = new DAOMetacaracteres ();
    
        UtilidadesLog.info("MonMetacaracteresData.query(MsgTipoMetacData msgTipoMetacFrom, MsgTipoMetacData msgTipoMetacTo, HashMap userProperties):Salida ");
    
        return dao.query(msgTipoMetacFrom, msgTipoMetacTo, userProperties );
    
    }

    public Vector query(MsgMetacData msgMetacFrom, MsgMetacData msgMetacTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MonMsgMetacData.query(MsgMetacData msgMetacFrom, MsgMetacData msgMetacTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada ");
        DAOMetacaracteres dao = new DAOMetacaracteres ();
    
        UtilidadesLog.info("MonMsgMetacData.query(MsgMetacData msgMetacFrom, MsgMetacData msgMetacTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada ");
        return dao.query(msgMetacFrom,msgMetacTo, userProperties, pageCount, pageSize);
    
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MonMetacaracteresData.remove(Vector entities):Entrada ");
    
        DAOMetacaracteres dao = new DAOMetacaracteres ();
        dao.remove(entities);
    
        UtilidadesLog.info("MonMetacaracteresData.remove(Vector entities):Salida ");
    }

    public void update(MsgMetacData msgMetac, 
                       Vector localizationLabels) throws MareException 
    {
        UtilidadesLog.info("MonMetacaracteresData.update(MsgMetacData msgMetac, Vector localizationLabels):Entrada ");
        DAOMetacaracteres dao = new DAOMetacaracteres ();
        dao.update(msgMetac, localizationLabels);
        UtilidadesLog.info("MonMetacaracteresData.update(MsgMetacData msgMetac, Vector localizationLabels):Salida ");
    }

    public Hashtable guardarMetac(MsgMetacData msgMetac, 
                                  Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MonMetacaracteresData.guardarMetac(MsgMetacData msgMetac, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOMetacaracteres dao = new DAOMetacaracteres ();
        UtilidadesLog.info("MonMetacaracteresData.guardarMetac(MsgMetacData msgMetac, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarMetac(msgMetac, localizationLabels, userProperties );
    
    }
}
