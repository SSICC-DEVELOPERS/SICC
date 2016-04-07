package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeParamClienData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoAsignacionCodigoBean implements SessionBean {
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

    public Hashtable guardarTipoAsignacionCodigo(MaeParamClienData maeParamClien, 
                                                 Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONTipoAsignacionCodigoBean(MaeParamClienData maeParamClien, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOTipoAsignacionCodigo dao = new DAOTipoAsignacionCodigo();
        UtilidadesLog.info("MONTipoAsignacionCodigoBean(MaeParamClienData maeParamClien, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarTipoAsignacionCodigo(maeParamClien, localizationLabels, userProperties);
    }

    public Vector query(MaeParamClienData maeParamClienFrom, 
                        MaeParamClienData maeParamClienTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONTipoAsignacionCodigoBean.query(MaeParamClienData maeParamClienFrom, MaeParamClienData maeParamClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOTipoAsignacionCodigo dao = new DAOTipoAsignacionCodigo();
        UtilidadesLog.info("MONTipoAsignacionCodigoBean.query(MaeParamClienData maeParamClienFrom, MaeParamClienData maeParamClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeParamClienFrom, maeParamClienTo, userProperties, pageCount, pageSize);
    }
}
