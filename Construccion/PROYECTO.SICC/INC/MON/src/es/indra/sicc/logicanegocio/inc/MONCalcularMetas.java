package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOListaMetasTipoVenta;
import es.indra.sicc.dtos.inc.DTOListaMetasVentaProyectada;
import es.indra.sicc.dtos.inc.DTOMetTipVtaPag;
import es.indra.sicc.util.DTOOID;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.ejb.EJBObject;
import es.indra.sicc.util.DTOSalida;

public interface MONCalcularMetas
        extends EJBObject {
    DTOOID calcularMetasVentaProyectadaBatch(DTOConcurso dto)
            throws RemoteException, MareException;

    DTOSalidaBatch calcularMetasVentaProyectada(DTOBatch DTOE)
            throws RemoteException, MareException;

    Boolean estaTipificacionCliente(Long oidCliente, ArrayList listaClasiParti)
            throws RemoteException, MareException;

    Boolean esPrimerPeriodo(Long oidPeriodo, DTOListaMetasVentaProyectada listaMetas)
            throws RemoteException, MareException;

    Boolean esUltimoPeriodo(Long oidPeriodo, DTOListaMetasVentaProyectada listaMetas)
            throws RemoteException, MareException;

    DTOOID calcularMetasTipoVentaBatch(DTOConcurso DTOE)
            throws RemoteException, MareException;

    DTOSalidaBatch calcularMetasTipoVenta(DTOBatch DTOE)
            throws RemoteException, MareException;

    DTOListaMetasTipoVenta calcularMetasTipoVentaConsultoras(DTOConcurso DTOE)
            throws RemoteException, MareException;

    DTOListaMetasTipoVenta calcularMetasTipoVentaGerentes(DTOConcurso DTOE)
            throws RemoteException, MareException;

    DTOListaMetasTipoVenta obtenerMetasTipoVenta(Long oidConcurso)
            throws RemoteException, MareException;

    DTOListaMetasVentaProyectada obtenerMetasVentaProyectadaSubgerencia(Long oidConcurso)
            throws RemoteException, MareException;

    DTOListaMetasVentaProyectada obtenerMetasVentaProyectadaRegion(Long oidConcurso)
            throws RemoteException, MareException;

    DTOListaMetasVentaProyectada obtenerMetasVentaProyectadaZona(Long oidConcurso)
            throws RemoteException, MareException;

    void guardarMetasTipoVenta(Long oidConcurso, DTOListaMetasTipoVenta listaMetas)
            throws RemoteException, MareException;

    void guardarMetasVentaProyectadaSubgerencia(Long oidConcurso, DTOListaMetasVentaProyectada listaMetas)
            throws RemoteException, MareException;

    void guardarMetasVentaProyectadaRegion(Long oidConcurso, DTOListaMetasVentaProyectada listaMetas)
            throws RemoteException, MareException;

    void guardarMetasVentaProyectadaZona(Long oidConcurso, DTOListaMetasVentaProyectada listaMetas)
            throws RemoteException, MareException;

    DTOListaMetasVentaProyectada obtenerMetasVentaProyectadaSubgerencia(DTOOID oidConcurso)
            throws RemoteException, MareException;

    DTOListaMetasVentaProyectada obtenerMetasVentaProyectadaRegion(DTOOID oidConcurso)
            throws RemoteException, MareException;

    DTOListaMetasVentaProyectada obtenerMetasVentaProyectadaZona(DTOOID oidConcurso)
            throws RemoteException, MareException;

    DTOListaMetasTipoVenta obtenerMetasTipoVenta(DTOOID oid)
            throws MareException, RemoteException;

  Concurso obtenerConcursoValidadorEstatus(ArrayList estatusVentas) throws RemoteException, MareException;

  DTOSalida obtenerPrimerUltimoPeriodoAnio(DTOConcurso dtoe) throws RemoteException, MareException;

    DTOSalidaBatch procesarSegmento(DTOBatch dtoin) throws RemoteException, MareException;

    void calcularMetasTipoVentaConsultorasPerf(DTOConcurso DTOE, String idProc) throws RemoteException, MareException;

    DTOSalida consultarMetasTipoVenta(DTOMetTipVtaPag dtoe) throws MareException, RemoteException;

    DTOListaMetasTipoVenta existenMetasTipoVenta(Long oidConcurso) throws RemoteException, MareException;
}
