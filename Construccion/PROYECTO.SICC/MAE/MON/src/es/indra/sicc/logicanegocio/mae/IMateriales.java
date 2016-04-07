package es.indra.sicc.logicanegocio.mae;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cal.DTOBuscarInformacionProductos;
import es.indra.sicc.util.DTOOID;

public interface IMateriales {
  public DTOSalida buscarInformacionProductos(DTOBuscarInformacionProductos dto) throws MareException;
  public DTOSalida detalleInformacionProducto(DTOOID dto) throws MareException;
  
}