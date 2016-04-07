/**
 * @Autor: Hugo Mansi
 * @Fecha: 12/10/2004
 * 
 */
package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.mare.common.exception.MareException;


public interface IGenerarNumeroDocumento   {
  String generaNumeroDocumento (DTONumeroSolicitud dto) throws MareException;
  
  String generaSecuenciaDocumento (DTONumeroSolicitud dto) throws MareException;  
}