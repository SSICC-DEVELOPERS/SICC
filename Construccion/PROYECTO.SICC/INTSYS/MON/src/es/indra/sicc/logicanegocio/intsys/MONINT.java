package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTORecepcionarMovimientos;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.util.DTOString;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.intsys.DTOINTEnviarConsultorasDeuda;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.dtos.zon.DTOUnidadesAdministrativas;
import es.indra.sicc.dtos.intsys.DTOINTCargaInicialConsultorasDeudas;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import java.util.Date;

public interface MONINT extends EJBObject  {
    void recepcionarVia(DTOINT dto) throws MareException, RemoteException;

    DTOSalidaBatch recepcionarMovimientos(DTORecepcionarMovimientos dto) throws RemoteException, MareException;

    DTOCargaInicialInterfaz cargaInicial(DTOString dto) throws RemoteException, MareException;

    DTOSalidaBatch enviarConsultorasDeudasMovsDeudaPdte(DTOINTEnviarConsultorasDeuda dtoE) throws MareException, RemoteException;

    DTOSalidaBatch enviarConsultorasYDeudas(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOSalidaBatch enviarMovimientosDeudaPendiente(DTOBatch dtoBatch) throws MareException, RemoteException;

    DTOINTCargaInicialConsultorasDeudas cargaInicialConsultorasDeudas(DTOUnidadAdministrativa dtoe) throws RemoteException, MareException;

    Date obtenerUltimaFecha(Long []listaCriterios, String codigoInterfaz) throws MareException, RemoteException;

    DTOSalidaBatch recepcionarMovimientosBatchOLD(DTOBatch dtoBtch) throws RemoteException, MareException;

  DTOSalidaBatch recepcionarMovimientosBatch(DTOBatch dtoBtch) throws RemoteException, MareException;

    DTOSalidaBatch recepcionarMovimientosBatchDeamon(DTOBatch dtoBatch) throws MareException, RemoteException;
}