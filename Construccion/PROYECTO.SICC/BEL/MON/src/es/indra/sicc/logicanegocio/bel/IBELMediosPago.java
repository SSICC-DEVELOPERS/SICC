package es.indra.sicc.logicanegocio.bel;
import es.indra.mare.common.exception.MareException;
public interface IBELMediosPago  {

	Long obtenerOidMedioPago(Long pais, String codigo) throws MareException;
}