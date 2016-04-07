package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import java.util.ArrayList;
import es.indra.sicc.dtos.intsys.DTOAtributo;
import es.indra.sicc.dtos.intsys.DTOINTEnviarInfCliente;

public interface MONGis extends EJBObject 
{
  DTOSalidaBatch enviarInfoClienteBatch(DTOINTEnviarInfCliente dto) throws RemoteException, MareException;

  ArrayList consultarSaldo(ArrayList ListaOids, Long oidPeriodo, Long oidPais) throws RemoteException, MareException;

  ArrayList formarListaEnvio(ArrayList ListaClientes, ArrayList ListaAtributo1, ArrayList ListaAtributo3, ArrayList ListaAtributo5, ArrayList ListaAtributo6, ArrayList ListaVenta, ArrayList ListaDatosAdicionales) throws MareException, RemoteException;

  ArrayList aniadirAtributoA(ArrayList atributos, ArrayList Lista, Long oidCliente) throws RemoteException, MareException;

  ArrayList aniadirAtributoB(ArrayList atributos, ArrayList Lista, Long oidCliente, String constante) throws RemoteException, MareException;

  ArrayList aniadirAtributoC(ArrayList atributos, ArrayList Lista, Long oidCliente, String constante) throws RemoteException, MareException;

  DTOAtributo crearAtributo(Long oidCliente, String codAcceso, String codPeriodo, String codAtributo, String valorAtributo) throws RemoteException, MareException;

  DTOSalidaBatch enviarInfCliente(DTOBatch dto) throws MareException, RemoteException;
}