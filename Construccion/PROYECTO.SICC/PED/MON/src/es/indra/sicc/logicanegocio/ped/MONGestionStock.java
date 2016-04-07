package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ped.DTOGestionStock;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOListaGestionStock;

public interface MONGestionStock extends EJBObject 
{
  void inserta(Long periodo, DTOGestionStock dto, int id) throws RemoteException, MareException;

  void modifica(DTOGestionStock dto, int id) throws RemoteException, MareException;

  void guarda(DTOListaGestionStock dto) throws RemoteException, MareException;

  void elimina(Long oid) throws RemoteException, MareException;

  DTOListaGestionStock consulta(DTOListaGestionStock dto) throws RemoteException, MareException;
}