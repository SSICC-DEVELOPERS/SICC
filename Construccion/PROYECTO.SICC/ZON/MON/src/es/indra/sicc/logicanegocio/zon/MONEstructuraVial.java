package es.indra.sicc.logicanegocio.zon;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.sicc.dtos.zon.DTOListaFicheroDisp;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.dtos.zon.DTOConsultaEstructuraVialPantalla;
import es.indra.sicc.dtos.zon.DTOELocalizacionDirecciones;
import es.indra.sicc.dtos.zon.DTOUBIGEOS;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

public interface MONEstructuraVial extends EJBObject  {

    public void procesar(Long iDproc, String filePath, String typeProc, String filename) throws RemoteException, MareException;

    public DTOListaFicheroDisp  ficherosDisponibles(String typeProc) throws RemoteException, MareException;

    public Integer estadoProc(Long idProc) throws RemoteException, MareException;

    public  DTOManagerFileResult obtenerResultado(Long iDproc) throws RemoteException, MareException;

    public DTOManagerFileResult procesarsinc(DTOFicheroDisp datos) throws RemoteException, MareException;

    public DTOConsultaEstructuraVialPantalla consultaDatosPantalla(DTOPais dtoPais) throws  RemoteException, MareException, RemoteException;

  DTOUBIGEOS localizarDireccion(DTOELocalizacionDirecciones datosdir) throws MareException, RemoteException;

    DTOSalida obtenerViasPais(DTOOID dtooid) throws MareException, RemoteException;

    DTOSalida consultaEstructuraVial(DTOELocalizacionDirecciones dto) throws  RemoteException, MareException, RemoteException;

}