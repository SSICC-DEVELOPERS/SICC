package es.indra.sicc.logicanegocio.cra;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.util.DTOSalida;
/**
 * Sistema:         Belcorp
 * Modulo:          CRA - Cronograma de Actividades
 * Componente:      IPeriodos
 * Fecha:           22/3/2005
 * Observaciones:   
 *
 * @version         BELC300015141 1.0
 * @author          Marta Montiel
 */
public interface IPeriodos 
{
  public DTOSalida obtenerListaPeriodosPosteriores(DTOPeriodo dto) throws MareException;
}