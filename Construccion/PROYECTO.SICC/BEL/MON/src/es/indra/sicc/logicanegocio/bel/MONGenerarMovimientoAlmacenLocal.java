package es.indra.sicc.logicanegocio.bel;

import java.util.ArrayList;

import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOReportePedidos;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.bel.DTOReversionMovimiento;
import es.indra.sicc.dtos.bel.DTOGrabarStock;

public interface MONGenerarMovimientoAlmacenLocal extends EJBLocalObject  {
  DTOReportePedidos grabarMovimientoAlmacenYStock(DTOMovimientoAlmacen dto) throws MareException;

  void reversionMovimientoAlmacen(DTOReversionMovimiento dto) throws MareException;

  DTOGrabarStock grabarStock(DTOGrabarStock dtoGrabarStock) throws MareException;

    String ejecutarFuncionGeneraNumeros(ArrayList arrayParametros) throws MareException;
}
