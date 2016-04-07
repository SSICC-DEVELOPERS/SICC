package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import java.lang.String;

public interface IParametrosPedidos  {
  RecordSet obtenerTasasImpuestoPorPais(DTOBelcorp dto)throws MareException;

  RecordSet obtenerAtributosEspecialesModulo(String modulo)throws MareException;
  
  /**Autor: Hugo Andres Mansi
   * Fecha: 20/12/2004
   * Incidencia: BELC300011520
  **/
  DTOSalida obtenerCoeficienteImpuesto (DTOOID dto)throws MareException;
}