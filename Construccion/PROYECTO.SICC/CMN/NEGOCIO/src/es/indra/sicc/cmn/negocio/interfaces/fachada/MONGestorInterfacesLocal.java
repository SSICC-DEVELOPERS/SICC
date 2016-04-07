package es.indra.sicc.cmn.negocio.interfaces.fachada;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;

import javax.ejb.EJBLocalObject;

public interface MONGestorInterfacesLocal extends EJBLocalObject
{
  InterfazInfo crearInterfaz(String codigo, Long pais) 
	throws InterfacesException, MareException;

  void enviarInterfaz(InterfazInfo interfazInfo) 
	throws InterfacesException, MareException;

  void recargarInterfaces() throws InterfacesException, MareException;

	void registrarError(DTOINTError dtoError) throws InterfacesException;

	InterfazInfo importarInterfaz(String codigoInterfaz, Long pais) throws MareException, InterfacesException;

	IRegistroSicc cargarRegistro(InterfazInfo interfazInfo) 
		throws InterfacesException, MareException;

  InterfazInfo obtenerInterfazInfo(String codigoInterfaz, Long pais) 
	throws InterfacesException, MareException;

	String obtenerNumeroLote() throws  MareException, InterfacesException;

	InterfazInfo crearInterfaz(InterfazInfo interfazInfo)
		throws MareException, InterfacesException;;

	InterfazInfo importarInterfaz(InterfazInfo info)
		throws MareException, InterfacesException;

	IRegistroSicc cargarRegistro(InterfazInfo interfazInfo, boolean bCerrarInterfaz) throws  InterfacesException, MareException;

	void cerrarInterfaz(InterfazInfo interfazInfo) throws  InterfacesException, MareException;

    void reset(InterfazInfo interfazInfo) throws  MareException, InterfacesException;

    InterfazInfo importarInterfaz(InterfazInfo info, String nombreArchivo) throws  InterfacesException, MareException;

    String obtenerNumeroLoteInterno() throws MareException;
}
