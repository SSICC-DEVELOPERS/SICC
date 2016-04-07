package es.indra.sicc.cmn.negocio.interfaces.fachada;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONGestorInterfaces extends EJBObject
{
  InterfazInfo crearInterfaz(String codigo, Long pais) 
	throws RemoteException, InterfacesException, MareException;

  void anyadirRegistro(InterfazInfo interfaz, IRegistroSicc registro) 
	throws RemoteException, InterfacesException, MareException;

  void enviarInterfaz(InterfazInfo interfazInfo) 
	throws InterfacesException, RemoteException, MareException;

  void recargarInterfaces() throws InterfacesException, RemoteException, MareException;

	void registrarError(DTOINTError dtoError) throws InterfacesException, RemoteException;

	InterfazInfo importarInterfaz(String codigoInterfaz, Long pais) throws RemoteException, MareException, InterfacesException;

	IRegistroSicc cargarRegistro(InterfazInfo interfazInfo) 
		throws InterfacesException, RemoteException, MareException;

  InterfazInfo obtenerInterfazInfo(String codigoInterfaz, Long pais) 
	throws RemoteException, InterfacesException, MareException;

	String obtenerNumeroLote() throws  MareException, InterfacesException, RemoteException;

	InterfazInfo crearInterfaz(InterfazInfo interfazInfo) 
		throws RemoteException, MareException, InterfacesException;

	InterfazInfo importarInterfaz(InterfazInfo info) 
		throws RemoteException, MareException, InterfacesException;

	IRegistroSicc cargarRegistro(InterfazInfo interfazInfo, boolean bCerrarInterfaz) throws  InterfacesException, MareException, RemoteException;

	void cerrarInterfaz(InterfazInfo interfazInfo) throws  InterfacesException, MareException, RemoteException;

    void reset(InterfazInfo interfazInfo) throws  MareException, InterfacesException, RemoteException;

    InterfazInfo importarInterfaz(InterfazInfo info, String nombreArchivo) throws  InterfacesException, MareException, RemoteException;

    String obtenerNumeroLoteInterno() throws MareException, RemoteException;
}
