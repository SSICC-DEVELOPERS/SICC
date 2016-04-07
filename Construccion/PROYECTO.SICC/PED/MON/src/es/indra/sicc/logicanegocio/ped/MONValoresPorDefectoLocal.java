package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOValoresPorDefecto;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOColeccion;

public interface MONValoresPorDefectoLocal extends EJBLocalObject 
{
    DTOSalida consulta(DTOValoresPorDefecto dto) throws MareException;

    void eliminar(DTOOIDs dto) throws MareException;

    void guarda(DTOColeccion dto) throws MareException;

    void modifica(DTOColeccion dto) throws MareException;
}