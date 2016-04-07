package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.dtos.ped.DTOSeguimientoPedidos;
import es.indra.mare.common.exception.MareException;

public interface ISeguimientoPedidos {

  void actualizarSeguimientoPedidos (DTOSeguimientoPedidos DTOE) throws MareException;

}