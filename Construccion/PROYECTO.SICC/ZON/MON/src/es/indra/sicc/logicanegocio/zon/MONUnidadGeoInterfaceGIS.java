package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.sicc.dtos.zon.DTOListaFicheroDisp;

public interface MONUnidadGeoInterfaceGIS extends EJBObject  {
    /*
     * Autor: Cortaberria
     * Fecha: 27/06/2005
     * Se modifica el tipo de retorno de manera que retorne true si la operacion se realizo ok
     * o si no se debe ejecutar el rollback, y false en el caso contrario.
     * Se realizo este cambio debido a que si se hace el rollback aqui y luego se intenta consultar
     * en la bd el resultado de la operación se genera un error.
     */
    boolean procesarMantener(Long idProc, String filePath, String filename) throws RemoteException, MareException;

    /*
     * Autor: Cortaberria
     * Fecha: 27/06/2005
     * Mismo motivo que procesarMantener
    */
    boolean procesarAsociarTerritorio(Long idProc, String filePath, String filename) throws RemoteException, MareException;

    Boolean validarCabecera(Object datos, String typePro, String filePath, String filename) throws RemoteException, MareException;

    DTOManagerFileResult procesarsinc(DTOFicheroDisp datos) throws RemoteException, MareException;

    void procesar(Long idProc, String filePath, String typeProc, String filename) throws RemoteException, MareException;

    Integer estadoProc(Long idProc) throws RemoteException, MareException;

    DTOManagerFileResult obtenerResultado(Long idProc) throws RemoteException, MareException;

    DTOListaFicheroDisp ficherosDisponibles(String typeProc) throws RemoteException, MareException;
}