package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ccc.DTOCodigoProceso;
import es.indra.sicc.dtos.ccc.DTOConsultarMarcasTipoAbono;
import es.indra.sicc.dtos.ccc.DTOMarcasPorTipoAbono;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface MONMarcasPorTipoAbono extends EJBObject  {

  DTOSalida cargaMarcasSituacion(DTOBelcorp dto) throws RemoteException, MareException;

  DTOSalida buscar(DTOMarcasPorTipoAbono dto) throws MareException, RemoteException;

  void guardar(DTOMarcasPorTipoAbono dto) throws RemoteException, MareException;

  void elimina(DTOOIDs dto) throws MareException, RemoteException;

  DTOSalida obtieneSubprocesos(DTOOID dto) throws MareException, RemoteException;


  DTOSalida obtieneTiposAbonoSubproceso(DTOOID dto) throws MareException, RemoteException;

	DTOSalida obtieneSubprocesosProcesoPais(DTOCodigoProceso dto) throws MareException, RemoteException;

    DTOSalida obtieneProcesos(DTOBelcorp dto) throws MareException, RemoteException;

    DTOSalida obtieneSubprocesosMarcas(DTOOID dto) throws MareException, RemoteException;

    DTOConsultarMarcasTipoAbono consultar(DTOMarcasPorTipoAbono dto) throws MareException, RemoteException;
}
