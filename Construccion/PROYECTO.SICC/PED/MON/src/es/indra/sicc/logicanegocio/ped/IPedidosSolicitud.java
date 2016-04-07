package es.indra.sicc.logicanegocio.ped;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cal.DTOBuscarPedidosNoFacturados;

public interface IPedidosSolicitud {
  public DTOSalida buscarPedidosNoFacturados(DTOBuscarPedidosNoFacturados dto) throws MareException;
  
  
  
  /* Marta Montiel -  22/03/05
   * Incidencia BELC300014706
   * */
   public DTOSalida obtenerPosicionesReclamo(DTOOID dto) throws MareException;
   
   
    /* Marta Montiel -  22/03/05
   * Incidencia BELC300014962
   * */
   public DTOSalida obtenerIndicadoresRevision(DTOBelcorp dto) throws MareException;
   
   /*
    * 16-06-2005 - rgiorgi: inc. 19261
    * */
   public DTOSalida obtenerPosicionesReclamoAnulacion(DTOOID DTOOID) throws MareException;
   
}