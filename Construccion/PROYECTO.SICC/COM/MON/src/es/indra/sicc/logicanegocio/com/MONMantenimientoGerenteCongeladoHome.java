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
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
    /**    
    *@Author: lcordoba
    *@Fecha:  03-01-2006
    */
public interface MONMantenimientoGerenteCongeladoHome extends EJBHome 
{
    MONMantenimientoGerenteCongelado create() throws RemoteException, CreateException;
}