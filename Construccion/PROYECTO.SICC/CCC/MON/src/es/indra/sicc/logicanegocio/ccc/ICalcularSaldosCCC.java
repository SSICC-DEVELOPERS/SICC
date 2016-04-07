package es.indra.sicc.logicanegocio.ccc;
import es.indra.mare.common.exception.MareException;

public interface ICalcularSaldosCCC  {
    public String calcularSaldosCuentaCorriente (Long pais, Long codCliente)throws MareException;
}