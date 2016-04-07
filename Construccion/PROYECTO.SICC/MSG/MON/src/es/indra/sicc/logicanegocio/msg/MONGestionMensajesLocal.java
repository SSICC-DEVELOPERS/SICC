package es.indra.sicc.logicanegocio.msg;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;

public interface MONGestionMensajesLocal extends EJBLocalObject 
{
    DTOBuzonMensajes grabarBuzon(Long mensaje, DTOBuzonMensajes dto) throws MareException;

    DTOBuzonMensajes insertaDatosMensajeBatch(DTOBuzonMensajes dto) throws MareException;

    void eliminaDatosMensaje(DTOBuzonMensajes dto) throws MareException;

    void eliminaMensajesFaltantesAnunciados(DTOBuzonMensajes dto) throws MareException;

    DTOBuzonMensajes insertaDatosMensaje(DTOBuzonMensajes dto) throws MareException;

    DTOBuzonMensajes[] insertarDatosMensajesBatch(DTOBuzonMensajes[] dto) throws MareException;

    DTOBuzonMensajes[] grabarBuzon(DTOBuzonMensajes[] dto) throws MareException;
}