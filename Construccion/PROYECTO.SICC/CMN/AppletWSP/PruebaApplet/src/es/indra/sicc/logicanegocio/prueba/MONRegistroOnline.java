package es.indra.sicc.logicanegocio.prueba;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.prueba.DTOCargaRegistroOnline;
import es.indra.sicc.dtos.prueba.DTODatosCliente;

public interface MONRegistroOnline extends EJBObject  {
  DTOCargaRegistroOnline obtenerCargaInicial(Long oidPais, String codUsuario) throws RemoteException, Exception;

  DTODatosCliente buscarDatosCliente(String codCliente, Long oidPais) throws Exception, RemoteException;

  void validarCabecera() throws RemoteException;
}