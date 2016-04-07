package es.indra.sicc.logicanegocio.cra;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cal.DTOConsultarFechasCronograma;
import es.indra.mare.common.exception.MareException;
import java.sql.Timestamp;

public interface IMONCronograma {
  public DTOSalida consultarFechasCronograma(DTOConsultarFechasCronograma dto) throws MareException;

  public DTOSalida buscarFechasFacPorZona(DTOOID dto) throws MareException;
  
  public Timestamp obtenerMayorFechaFacturacion(DTOOID dto) throws MareException;  
}

