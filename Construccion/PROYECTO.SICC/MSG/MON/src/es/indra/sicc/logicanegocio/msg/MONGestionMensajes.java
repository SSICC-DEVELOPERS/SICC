package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBObject;
import es.indra.sicc.dtos.msg.*;
import es.indra.mare.common.exception.MareException;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;

public interface MONGestionMensajes extends EJBObject  {




    public DTOBuzonMensajes[] insertarDatosMensajesBatch(DTOBuzonMensajes[] dto) throws MareException;


  DTOBuzonMensajes insertaDatosMensaje(DTOBuzonMensajes dto) throws RemoteException, MareException;

  void eliminaDatosMensaje(DTOBuzonMensajes dto) throws RemoteException, MareException;

  void eliminaMensajesFaltantesAnunciados(DTOBuzonMensajes dto) throws RemoteException, MareException;

    DTOBuzonMensajes grabarBuzon(Long mensaje, DTOBuzonMensajes dto) throws RemoteException, MareException;

    DTOBuzonMensajes insertaDatosMensajeBatch(DTOBuzonMensajes dto) throws RemoteException, MareException;


}