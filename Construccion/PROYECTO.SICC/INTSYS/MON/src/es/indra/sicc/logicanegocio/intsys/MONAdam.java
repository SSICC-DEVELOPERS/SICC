package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import java.math.BigDecimal;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.intsys.DTOEnviarComInc;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.intsys.DTOCargaAdam;
import es.indra.sicc.dtos.intsys.DTOMostrarDeuda;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.intsys.DTOGenerarFichero;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.dtos.intsys.DTOEstatus;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOIndError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.intsys.DTOBusquedaDescuentos;
import es.indra.sicc.util.DTODate;
import es.indra.sicc.dtos.intsys.DTODescPers;

public interface MONAdam extends EJBObject  {
    void ingresarComisionesEIncentivos(Long moduloGenerador, Long oidCliente, BigDecimal importe) throws RemoteException, MareException;

    DTOSalidaBatch enviarComisionesBatch(DTOEnviarComInc dtoe) throws RemoteException, MareException;

    DTOSalidaBatch enviarComisiones(DTOBatch dtoe) throws RemoteException, MareException;

    DTOSalidaBatch enviarIncentivosBatch(DTOEnviarComInc dtoe) throws RemoteException, MareException;

    DTOSalidaBatch enviarIncentivos(DTOBatch dtoe) throws RemoteException, MareException;

    DTOCargaAdam obtenerCombosEstado(DTOBelcorp dtoe) throws RemoteException, MareException;

    DTOMostrarDeuda obtenerDatosAdam(DTODescPers dtoe) throws RemoteException, MareException;

    RecordSet calcularLineaCreditoDisp(RecordSet listaClient, Long oidIdioma, Long oidPais) throws RemoteException, MareException;

    DTOString generarFichero(DTOGenerarFichero dtoe) throws RemoteException, MareException;

    DTOSalidaBatch enviarDescuentosBatch(DTOGenerarFichero dtoe) throws RemoteException, MareException;

    DTOSalidaBatch enviarDescuentos(DTOBatch dtoe) throws RemoteException, MareException;

    DTOEstatus guardarDescuento(DTOGenerarFichero dtoe) throws RemoteException, MareException;

    DTOEstatus generarDescuentosDeuda(DTOGenerarFichero dtoe) throws RemoteException, MareException;

    DTOIndError comprobarBatch(DTOINT dtoe) throws RemoteException, MareException;

    DTOGenerarFichero recuperarLote(DTOOID dtoe) throws RemoteException, MareException;

    DTOSalida recuperarEstatus(DTOBelcorp dtoe) throws RemoteException, MareException;

    DTOSalida buscarDescuentos(DTOBusquedaDescuentos dtoe) throws RemoteException, MareException;

    DTODate obtenerFechaDesde(DTOINT dtoe) throws RemoteException, MareException;
}