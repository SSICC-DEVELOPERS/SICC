package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.pre.DTOAgregarProductoSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.mare.common.exception.MareException;

public interface MONCuadreProductosLocal extends EJBLocalObject 
{
    DTOCabeceraSolicitud agregarProductos(DTOCabeceraSolicitud dtoCabeceraSolicitud, DTOAgregarProductoSolicitud dtoAgregarProductoSolicitud, DTOPosicionSolicitud dtoPosicionSolicitud) throws MareException;

    DTOCabeceraSolicitud eliminarProductos(DTOCabeceraSolicitud dtoe, Long posicion, Long unidadesEliminar) throws Exception;

    void completarPosicion(DTOCabeceraSolicitud dtoCabeceraSolicitud) throws Exception;
}