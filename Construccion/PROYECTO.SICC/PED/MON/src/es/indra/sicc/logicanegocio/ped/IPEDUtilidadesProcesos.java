package es.indra.sicc.logicanegocio.ped;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;

/*Autor Marta Aurora Montiel
 * Fecha 21/03/05
 * SICC-DMCO-PED-201-354-N045.zip
 * */
public interface IPEDUtilidadesProcesos 
{

 DTOSalida consultaClasesSolicitudOrdenCompra(DTOBelcorp dto) throws MareException;
 
 /* Incidencia BELC300013964
  * Marta Montiel*/
 DTOSalida consultaTipoSolicitudPais(DTOBelcorp dto) throws MareException;
 
 
 /*
  * Fecha de Creacion: 28/04/2005
  * Autor: Damasia Maneiro
  * */
 DTOOID generaSolicitud (DTOCabeceraSolicitud dote) throws MareException;
}





 
