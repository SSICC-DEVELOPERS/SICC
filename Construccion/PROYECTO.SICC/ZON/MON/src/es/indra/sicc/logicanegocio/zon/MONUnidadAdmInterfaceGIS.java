package es.indra.sicc.logicanegocio.zon;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOListaFicheroDisp;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.sicc.logicanegocio.zon.IManagerFileInterface;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;


public interface MONUnidadAdmInterfaceGIS extends EJBObject {
    /*void procesarCrearUA(Long iDProc, String filePath, String typeProc)
        throws MareException, RemoteException;
*/
    void procesarEliminarUA(Long iDProc, String filePath, String typeProc)
        throws MareException, RemoteException;
    
    void procesar(Long idProc, String filePath, String typeProc, String filename) throws RemoteException, MareException;

    DTOManagerFileResult procesarsinc(DTOFicheroDisp datos)
        throws MareException, RemoteException;

    Boolean validarCabecera(Object datos, String typeProc, String filePath, String fileName) throws MareException, RemoteException;
    DTOManagerFileResult obtenerResultado(Long iDproc) throws RemoteException, MareException;

    DTOListaFicheroDisp ficherosDisponibles(String typeProc)
        throws RemoteException, MareException;
}