package es.indra.sicc.logicanegocio.rec;
import javax.ejb.EJBLocalObject;
import es.indra.mare.common.exception.MareException;

public interface MONCapturaProcesoReclamosLocal extends EJBLocalObject 
{
    void actualizarLineasOperacion(Long oid, Long estado, Boolean atendido, Long entregaMercaderia) throws MareException;
}