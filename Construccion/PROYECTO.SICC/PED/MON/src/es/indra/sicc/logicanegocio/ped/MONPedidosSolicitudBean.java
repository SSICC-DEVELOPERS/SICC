package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.car.DTOCalculoPedidos;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.exception.MareException;
import java.math.BigDecimal;
import es.indra.sicc.logicanegocio.ped.IPedidosSolicitud;
import es.indra.sicc.dtos.cal.DTOBuscarPedidosNoFacturados;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;

public class MONPedidosSolicitudBean implements SessionBean, IPedidosSolicitud {

  SessionContext ctx = null;

  public void ejbCreate(){}
  public void ejbActivate(){}
  public void ejbPassivate(){}
  public void ejbRemove(){}

  public void setSessionContext(SessionContext ctx){
    this.ctx=ctx;
  }
  
  public Boolean haPasadoPedidoPeriodo(Long cliente, Long periodoActual, 
                                      Boolean esFacturada) throws MareException{
    UtilidadesLog.info("MONPedidosSolicitudBean.haPasadoPedidoPeriodo(Long cliente, Long periodoActual, Boolean esFacturada): Entrada ");
    DAOPedidosSolicitud dao = new DAOPedidosSolicitud();
    UtilidadesLog.info("MONPedidosSolicitudBean.haPasadoPedidoPeriodo(Long cliente, Long periodoActual, Boolean esFacturada): Salida ");
    return dao.obtieneNroSolicitudesCompra(cliente, periodoActual, esFacturada);
  }

    public BigDecimal calcularPedidoPromedio(DTOCalculoPedidos dto) throws MareException {
        UtilidadesLog.info("MONPedidosSolicitudBean.calcularPedidoPromedio(DTOCalculoPedidos dto): Entrada ");
         DAOSolicitud dao = new DAOSolicitud();
        UtilidadesLog.info("MONPedidosSolicitudBean.calcularPedidoPromedio(DTOCalculoPedidos dto): Salida ");
         return dao.calcularPedidoPromedio(dto);
    }

  /**
   * @Autor Cortaberria
   * @throws es.indra.mare.common.exception.MareException
   * @return Integer
   * @param DTOCalculoPedidos dto
   * Permite calcular el nº de periodos con pedido que ha realizado una consultora entre dos periodos.
   */
  public Integer calcularPeriodosPedido(DTOCalculoPedidos dto) throws MareException {
    UtilidadesLog.info("MONPedidosSolicitudBean.calcularPeriodosPedido(DTOCalculoPedidos dto): Entrada ");
    DAOSolicitud dao = new DAOSolicitud();
    UtilidadesLog.info("MONPedidosSolicitudBean.calcularPeriodosPedido(DTOCalculoPedidos dto): Salida ");
    return dao.calcularPeriodosPedido(dto);    
  }
  
  /**
   * @Autor Cristian Valenzuela
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param DTOBuscarPedidosNoFacturados dto
   */
  public DTOSalida buscarPedidosNoFacturados(DTOBuscarPedidosNoFacturados dto) throws MareException {
    UtilidadesLog.info("MONPedidosSolicitudBean.buscarPedidosNoFacturados(DTOBuscarPedidosNoFacturados dto): Entrada ");
    /*Obtiene los pedidos no facturados de un periodo corporativo. 

    Proceso 
    ======== 
    Retorna el DTOSalida que devuelve el método DAOSolicitud.buscarPedidosNoFacturados(dto) */
    
    DTOSalida dtoSal = new DTOSalida();
    DAOSolicitud dao = new DAOSolicitud();
    dtoSal = dao.buscarPedidosNoFacturados(dto);
    UtilidadesLog.info("MONPedidosSolicitudBean.buscarPedidosNoFacturados(DTOBuscarPedidosNoFacturados dto): Salida ");
    return dtoSal;    
  }
  /*Marta Aurora Montiel
   * 22/03/05
   * Incidencia BELC300014706
   * */
  public DTOSalida obtenerPosicionesReclamo(DTOOID dto) throws MareException
  {
    UtilidadesLog.info("MONPedidosSolicitudBean.obtenerPosicionesReclamo(DTOOID dto): Entrada ");
    /* Obtiene las posiciones de una solicitud para crear lineas de operación en un reclamo */
     DAOPedidosSolicitud dao = new DAOPedidosSolicitud();
     DTOSalida dts = dao.obtenerPosicionesReclamo(dto.getOid());
     
     UtilidadesLog.info("MONPedidosSolicitudBean.obtenerPosicionesReclamo(DTOOID dto): Salida ");
     return dts;   
  }

  /*Marta Aurora Montiel
   * 22/03/05
   * Incidencia BELC300014962
   * */
  public DTOSalida obtenerIndicadoresRevision(DTOBelcorp dto) throws MareException
  {
    UtilidadesLog.info("MONPedidosSolicitudBean.obtenerIndicadoresRevision(DTOBelcorp dto): Entrada ");
      // Obtiene los indicadores de revisión 
     DAOPedidosSolicitud dao = new DAOPedidosSolicitud();
     DTOSalida dts = dao.obtenerIndicadoresRevision(dto);
    UtilidadesLog.info("MONPedidosSolicitudBean.obtenerIndicadoresRevision(DTOBelcorp dto): Salida ");
     return dts;  
  }
  
  /*
   * 16-06-2005 - rgiorgi: inc. 19261
   * */  
  public DTOSalida obtenerPosicionesReclamoAnulacion(DTOOID DTOOID) 
    throws MareException {

    return new DTOSalida(
          new DAOPedidosSolicitud().obtenerPosicionesReclamoAnulacion(DTOOID));
  }
  
}