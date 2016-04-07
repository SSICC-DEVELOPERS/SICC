package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.RecMotivDevolData;
import es.indra.belcorp.mso.RecMotivDevolOperaData;
import es.indra.belcorp.mso.RecOperaViewData;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

public class MONRECMotivDevolReclaOperaBean implements SessionBean {
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

    public Vector query(RecMotivDevolData recMotivDevolFrom, 
                        RecMotivDevolData recMotivDevolTo, HashMap userProperties) throws MareException {
            UtilidadesLog.info("MONRECMotivDevolReclaOperaBean.query(RecMotivDevolData recMotivDevolFrom, RecMotivDevolData recMotivDevolTo, HashMap userProperties): Entrada");
            DAORECMotivDevolReclamoOperacion dao = new DAORECMotivDevolReclamoOperacion();
            UtilidadesLog.info("MONRECMotivDevolReclaOperaBean.query(RecMotivDevolData recMotivDevolFrom, RecMotivDevolData recMotivDevolTo, HashMap userProperties): Salida");
            return dao.query(recMotivDevolFrom, recMotivDevolTo, userProperties);
    }

    public Vector query(RecOperaViewData recOperaViewFrom, 
                        RecOperaViewData recOperaViewTo, HashMap userProperties) throws MareException {
            UtilidadesLog.info("MONRECMotivDevolReclaOperaBean.query(RecOperaViewData recOperaViewFrom, RecOperaViewData recOperaViewTo, HashMap userProperties): Entrada");
            DAORECMotivDevolReclamoOperacion dao = new DAORECMotivDevolReclamoOperacion();
            UtilidadesLog.info("MONRECMotivDevolReclaOperaBean.query(RecOperaViewData recOperaViewFrom, RecOperaViewData recOperaViewTo, HashMap userProperties): Salida");
            return dao.query(recOperaViewFrom, recOperaViewTo, userProperties);
    }

    public Hashtable guardarMotivoDevolucion(RecMotivDevolOperaData recMotivDevolOpera, 
                                             Vector localizationLabels, HashMap userProperties) throws MareException {
            UtilidadesLog.info("MONRECMotivDevolReclaOperaBean.guardarMotivoDecolucion(RecMotivDevolOperaData recMotivDevolOpera, Vector localizationLabels, HashMap userProperties): Entrada");
            ExtensionRECBean ext = new ExtensionRECBean();
            MareDTO dto = new MareDTO();
            dto.addProperty("paisOidPais", recMotivDevolOpera.getPaisOidPais().getId());
            dto.addProperty("ropeOidOper", recMotivDevolOpera.getRopeOidOper().getId());
            dto.addProperty("valMarcDefe", recMotivDevolOpera.getValMarcDefe());
            ext.validarMotivoDevolucionS(dto);
            DAORECMotivDevolReclamoOperacion dao = new DAORECMotivDevolReclamoOperacion();
            UtilidadesLog.info("MONRECMotivDevolReclaOperaBean.guardarMotivoDecolucion(RecMotivDevolOperaData recMotivDevolOpera, Vector localizationLabels, HashMap userProperties): Salida");
            return dao.guardarMotivoDevolucionReclamo(recMotivDevolOpera, localizationLabels, userProperties);
    }

    public Vector query(RecMotivDevolOperaData recMotivDevolOperaFrom, 
                        RecMotivDevolOperaData recMotivDevolOperaTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
            UtilidadesLog.info("MONRECMOtivDevolReclaOperaBean.query(RecMotivDevolOperaData recMotivDevolOperaFrom, RecMotivDevolOperaData recMotivDevolOperaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
            DAORECMotivDevolReclamoOperacion dao = new DAORECMotivDevolReclamoOperacion();
            UtilidadesLog.info("MONRECMOtivDevolReclaOperaBean.query(RecMotivDevolOperaData recMotivDevolOperaFrom, RecMotivDevolOperaData recMotivDevolOperaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return dao.query(recMotivDevolOperaFrom, recMotivDevolOperaTo, userProperties, pageCount, pageSize);
    }

    public void update(RecMotivDevolOperaData recMotivDevolOpera, 
                       Vector localizationLabels) throws MareException {
            UtilidadesLog.info("MONRECMOtivDevolReclaOperaBean.update(RecMotivDevolOperaData recMotivDevolOpera, Vector localizationLabels): Entrada");
            DAORECMotivDevolReclamoOperacion dao = new DAORECMotivDevolReclamoOperacion();
            ExtensionRECBean ext = new ExtensionRECBean();
            MareDTO dto = new MareDTO();
            dto.addProperty("paisOidPais", recMotivDevolOpera.getPaisOidPais().getId());
            dto.addProperty("ropeOidOper", recMotivDevolOpera.getRopeOidOper().getId());
            dto.addProperty("valMarcDefe", recMotivDevolOpera.getValMarcDefe());
            ext.validarMotivoDevolucionS(dto);
            dao.update(recMotivDevolOpera, localizationLabels);
            UtilidadesLog.info("MONRECMOtivDevolReclaOperaBean.update(RecMotivDevolOperaData recMotivDevolOpera, Vector localizationLabels): Salida");           
    }

    public void remove(Vector entities) throws MareException {
           UtilidadesLog.info("MONRECMOtivDevolReclaOperaBean.remove(Vector recMotivDevolOpera): Entrada");
           DAORECMotivDevolReclamoOperacion dao = new DAORECMotivDevolReclamoOperacion();
           dao.remove(entities);
           UtilidadesLog.info("MONRECMOtivDevolReclaOperaBean.remove(Vector recMotivDevolOpera): Salida");
    }

    private ExtensionRECHome getExtensionRECHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (ExtensionRECHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/ExtensionREC" ), ExtensionRECHome.class );
    }
}
