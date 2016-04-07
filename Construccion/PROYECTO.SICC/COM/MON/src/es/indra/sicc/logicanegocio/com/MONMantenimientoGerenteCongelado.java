/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        MONMantenimientoGerenteCongelado
 * Fecha:             03-01-2006
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes DMCO-SICC-COM-H34
 * Descripcion:       MONMantenimientoGerenteCongelado
 * @version           1.0
 * @autor             lcordoba
 */
package es.indra.sicc.logicanegocio.com;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.com.DTODatosGerenteCongelacion;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
    /**    
    *@Author: lcordoba
    *@Fecha:  03-01-2006
    */
public interface MONMantenimientoGerenteCongelado extends EJBObject 
{
    void insertarGerenteCongelado(DTODatosGerenteCongelacion dto) throws MareException, RemoteException;

    void guardarGerenteCongelado(DTODatosGerenteCongelacion dto) throws MareException, RemoteException;

    DTOSalida buscarGerentesCongelados(DTODatosGerenteCongelacion dto) throws MareException, RemoteException;

    void eliminarGerentesCongelados(DTOOIDs dto) throws MareException, RemoteException;
}