package es.indra.sicc.logicanegocio.fac;

import es.indra.belcorp.mso.FacImpreVirtuData;
import es.indra.belcorp.mso.FacTipoImpreData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONImpresoraVirtualBean implements SessionBean {
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

    public Vector query(FacTipoImpreData facTipoImpreFrom, FacTipoImpreData facTipoImpreTo, HashMap userProperties) throws MareException
    {
        DAOImpresoraVirtual daoImpresoraVirtual = new DAOImpresoraVirtual();
    
        return daoImpresoraVirtual.query(facTipoImpreFrom, facTipoImpreTo, userProperties) ;
    }

    public Hashtable guardar(FacImpreVirtuData facImpreVirtu, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOImpresoraVirtual daoImpresoraVirtual = new DAOImpresoraVirtual();
        
        return daoImpresoraVirtual.guardar(facImpreVirtu) ;
    }

    public Vector query(FacImpreVirtuData facImpreVirtuFrom, FacImpreVirtuData facImpreVirtuTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOImpresoraVirtual daoImpresoraVirtual = new DAOImpresoraVirtual();
        
        return daoImpresoraVirtual.query(facImpreVirtuFrom, facImpreVirtuTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector facImpreVirtuFrom) throws MareException
    {
        DAOImpresoraVirtual daoImpresoraVirtual = new DAOImpresoraVirtual();
        
        daoImpresoraVirtual.remove(facImpreVirtuFrom);
    }

    public void update(FacImpreVirtuData facImpreVirtu, Vector localizationLabels) throws MareException
    {
        DAOImpresoraVirtual daoImpresoraVirtual = new DAOImpresoraVirtual();
        
        daoImpresoraVirtual.update(facImpreVirtu);
    }

    /**
     * Cambio 20080765
     * Recupera el OID de la impresora virtual asociada al formulario cuya rutina de diseño
     * y subacceso son los recibidos por parametro.
     * Si no encuentra tal impresora, devuelve null
     * @param rutina
     * @param subacceso
     * @return OID de la impresora recuperada, null si no recupera ninguna
     * @throws MareException
     * @author dmorello
     * @since 21/08/2009
     */
    public Long obtenerImpresoraPorRutinaFormulario(String rutina, Long subacceso) throws MareException {
        UtilidadesLog.info("MONImpresoraVirtualBean.obtenerImpresoraPorRutinaFormulario(String rutina, Long subacceso): Entrada");
        Long oidImpresora = new DAOImpresoraVirtual().obtenerImpresoraPorRutinaFormulario(rutina, subacceso);
        UtilidadesLog.info("MONImpresoraVirtualBean.obtenerImpresoraPorRutinaFormulario(String rutina, Long subacceso): Salida");
        return oidImpresora;
    }
}
