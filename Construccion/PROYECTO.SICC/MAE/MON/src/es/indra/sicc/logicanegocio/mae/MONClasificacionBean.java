package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeClasiData;
import es.indra.belcorp.mso.MaeSubtiClienData;
import es.indra.belcorp.mso.MaeTipoClasiClienData;
import es.indra.belcorp.mso.MaeTipoClienData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONClasificacionBean implements SessionBean {
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

    public Vector query(MaeTipoClienData maeTipoClienFrom, 
                        MaeTipoClienData maeTipoClienTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONClasificacionBean.query(MaeTipoClienData maeTipoClienFrom, MaeTipoClienData maeTipoClienTo, HashMap userProperties): Entrada");
        DAOClasificacion dao = new DAOClasificacion();
        UtilidadesLog.info("MONClasificacionBean.query(MaeTipoClienData maeTipoClienFrom, MaeTipoClienData maeTipoClienTo, HashMap userProperties): Salida");
        return dao.query(maeTipoClienFrom, maeTipoClienTo, userProperties);
    }

    public Vector query(MaeSubtiClienData maeSubtiClienFrom, 
                        MaeSubtiClienData maeSubtiClienTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONClasificacionBean.query(MaeSubtiClienData maeSubtiClienFrom, MaeSubtiClienData maeSubtiClienTo, HashMap userProperties): Entrada");
        DAOClasificacion dao = new DAOClasificacion();
        UtilidadesLog.info("MONClasificacionBean.query(MaeSubtiClienData maeSubtiClienFrom, MaeSubtiClienData maeSubtiClienTo, HashMap userProperties): Salida");
        return dao.query(maeSubtiClienFrom, maeSubtiClienTo, userProperties);
    }

    public Vector query(MaeSubtiClienData maeSubtiClienFrom, 
                        MaeSubtiClienData maeSubtiClienTo, 
                        HashMap userProperties, Boolean applyStructuralSecurity) throws MareException {
        UtilidadesLog.info("MONClasificacionBean.query(MaeSubtiClienData maeSubtiClienFrom, MaeSubtiClienData maeSubtiClienTo, HashMap userProperties, Boolean applyStructuralSecurity): Entrada");
        DAOClasificacion dao = new DAOClasificacion();
        UtilidadesLog.info("MONClasificacionBean.query(MaeSubtiClienData maeSubtiClienFrom, MaeSubtiClienData maeSubtiClienTo, HashMap userProperties, Boolean applyStructuralSecurity): Salida");
        return dao.query(maeSubtiClienFrom, maeSubtiClienTo, userProperties, applyStructuralSecurity);
    }

    public Vector query(MaeTipoClasiClienData maeTipoClasiClienFrom, 
                        MaeTipoClasiClienData maeTipoClasiClienTo, 
                        HashMap userProperties, Boolean applyStructuralSecurity) throws MareException {
        UtilidadesLog.info("MONClasificacionBean.quer(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties, Boolean applyStructuralSecurity): Entrada");
        DAOClasificacion dao = new DAOClasificacion();
        UtilidadesLog.info("MONClasificacionBean.quer(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties, Boolean applyStructuralSecurity): Salida");
        return dao.query(maeTipoClasiClienFrom, maeTipoClasiClienTo, userProperties, applyStructuralSecurity);
    }

    public Vector query(MaeTipoClasiClienData maeTipoClasiClienFrom, 
                        MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONClasificacionBean.quer(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties): Entrada");
        DAOClasificacion dao = new DAOClasificacion();
        UtilidadesLog.info("MONClasificacionBean.quer(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties): Salida");
        return dao.query(maeTipoClasiClienFrom, maeTipoClasiClienTo, userProperties);
    }

    public Hashtable guardarClasificacion(MaeClasiData maeClasi, 
                                          Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONClasificacionBean.guardaClasificacion(MaeClasiData maeClasi, Vector localizationLabels, HashMap userProperties):Entrada"); 
        DAOClasificacion dao = new DAOClasificacion();
        UtilidadesLog.info("MONClasificacionBean.guardaClasificacion(MaeClasiData maeClasi, Vector localizationLabels, HashMap userProperties):Salida"); 
        return dao.guardarClasificacion(maeClasi,localizationLabels,userProperties);
    }

    public Vector query(MaeClasiData maeClasiFrom, MaeClasiData maeClasiTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONClasificacionBean.query(MaeClasiData maeClasiFrom, MaeClasiData maeClasiTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOClasificacion dao = new DAOClasificacion();
        UtilidadesLog.info("MONClasificacionBean.query(MaeClasiData maeClasiFrom, MaeClasiData maeClasiTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        return dao.query(maeClasiFrom, maeClasiTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeClasiData maeClasi, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONClasificacionBean.update(MaeClasiData maeClasi, Vector localizationLabels): Entrada ");
        DAOClasificacion dao = new DAOClasificacion();
        dao.update(maeClasi, localizationLabels);
        UtilidadesLog.info("MONClasificacionBean.update(MaeClasiData maeClasi, Vector localizationLabels): Salida ");               
    }

    public void remove(Vector maeClasi) throws MareException {
        UtilidadesLog.info("MONClasificacionBean.remove(Vector maeClasifi): Entrada");
        DAOClasificacion dao = new DAOClasificacion();
        dao.remove(maeClasi);
        UtilidadesLog.info("MONClasificacionBean.remove(Vector maeClasifi): Salida");
    }
}
