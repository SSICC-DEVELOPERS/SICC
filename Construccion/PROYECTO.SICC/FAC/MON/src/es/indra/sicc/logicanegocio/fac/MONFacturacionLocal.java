package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOArranqueGP;
import es.indra.mare.common.exception.MareException;
import java.util.ArrayList;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.dtos.fac.DTOGenerarConsolidado;
import es.indra.sicc.dtos.fac.DTOFACCalculosCabeceraEntrada;
import es.indra.sicc.dtos.fac.DTOFACCalculosCabeceraSalida;
import es.indra.sicc.dtos.fac.DTOFACCalculosImpuestosEntrada;
import es.indra.sicc.dtos.fac.DTOFACCalculosImpuestosSalida;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.ped.DTOParametroMonitor;

public interface MONFacturacionLocal extends EJBLocalObject 
{
    void arrancarFacturacion(DTOArranqueGP dtoE) throws MareException;

    void arrancarFacturacionReal(DTOArranqueGP dtoE) throws MareException;

    void balancearAreaChequeo() throws MareException;

    ArrayList completarDatosConsolidados() throws MareException;

    ArrayList crearConsolidados(ArrayList listaCabecerasSolicitud) throws MareException;

    void ejecucionBatch(ArrayList listaSegmentos, String IDProceso) throws MareException;

    MareDTO ejecucionOnline(ArrayList listaSegmentos) throws MareException;

    void esperarProcesamiento(String codigoProceso) throws MareException, InterruptedException;

    ArrayList filtrarSolicitudesPermitenUnion(ArrayList listaSolicitudes) throws MareException;

    ArrayList generarConsolidados(DTOGenerarConsolidado dtoE) throws MareException;

    void lanzarProcesosFacturacion(ArrayList listaConsolidados, DTOParametroMonitor parametros, Integer numDecimales) throws MareException;

    DTOFACCalculosCabeceraSalida realizarCalculosCabecera(DTOFACCalculosCabeceraEntrada dtoe) throws MareException;

    DTOFACCalculosImpuestosSalida realizarCalculosImpuestos(DTOFACCalculosImpuestosEntrada dtoe) throws MareException;

    void realizarDemandaAnticipada(ArrayList listaSolicitudes);

    void realizarProyeccionDemandaReal(ArrayList listaSolicitudes);

    void generarNumerosDocumentoInternos(Boolean indicadorOnLine, Long idSpool) throws MareException;

    void balancearAreaChequeo(DTOFACConsolidado consolidado, Character indicadorAreaChequeo) throws MareException;

  void generarCodigosListasPicado(Boolean indOnline, Long oidPais) throws MareException;

  void generarNumerosEtiquetas(Boolean indOnline, Long oidPais) throws MareException;

    ArrayList obtenerCabecerasSolicitud(ArrayList listaOIDs) throws MareException;

    void generarNumerosSecuenciaEtiquetas(Boolean indOnline, 
                                          Long oidPais) throws MareException;

    void asignarNroUnicoCajaListasPicado(Boolean indOnline, 
                                         Long idSpool) throws MareException;

    void actualizarProductosCampana(Boolean indOnline, 
                                    String fechaFacturacion) throws MareException;

    void generarOlas(Boolean indOnline, Long oidPais) throws MareException;

    void procesarGastosAdministrativos(Boolean indOnline, 
                                       Long oidPais) throws MareException;
}
