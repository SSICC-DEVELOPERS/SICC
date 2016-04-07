package es.indra.sicc.logicanegocio.bel;
import es.indra.belcorp.mso.BelMedioPagoData;
import es.indra.belcorp.mso.BelTipoMedioPagoData;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import javax.ejb.EJBObject;

public interface MONMedioPago extends EJBObject 
{

    public Hashtable insertar(BelMedioPagoData belMedioPagoData, Vector vector , HashMap userProperties) throws MareException, RemoteException;
    
    public Vector query(BelMedioPagoData belMedioPagoFrom, BelMedioPagoData belMedioPagoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException, RemoteException;
    
    public void remove(Vector belMedioPagoData ) throws MareException, RemoteException;
    
    public void update(BelMedioPagoData belMedioPagoData, Vector localizationLabels) throws MareException, RemoteException;
    
    public Vector query(BelTipoMedioPagoData belTipoMedioPagoFrom, BelTipoMedioPagoData belTipoMedioPagoTo, HashMap userProperties) throws MareException, RemoteException;
}