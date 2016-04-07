package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import java.util.ArrayList;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.pre.DTOOferta;

public interface MONCuadreCompuestaVariableLocal extends EJBLocalObject 
{
    DTOCabeceraSolicitud cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Integer cuadre, Boolean despachoAutomatico, Long tipoPosicion, Long subtipoPosicion) throws MareException;

    DTOCabeceraSolicitud cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Integer cuadre, Boolean despachoAutomatico, Long tipoPosicion, Long subtipoPosicion, DTOOferta dtoOferta) throws MareException;
}