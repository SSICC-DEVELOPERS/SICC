package es.indra.sicc.logicanegocio.mae;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mae.DTOCliente;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;
import es.indra.sicc.dtos.mae.DTOConsultaCliente;
import es.indra.sicc.dtos.mae.DTOCrearClienteBasico;
import es.indra.sicc.dtos.mae.DTOCrearLotesClientes;
import es.indra.sicc.dtos.mae.DTODireccion;
import es.indra.sicc.dtos.mae.DTOGenerarCodigoCliente;
import es.indra.sicc.dtos.mae.DTOPestanya1Base;
import es.indra.sicc.dtos.mae.DTOPestanya2;
import es.indra.sicc.dtos.mae.DTOPestanya2Base;
import es.indra.sicc.dtos.mae.DTOPestanya3;
import es.indra.sicc.dtos.mae.DTOPestanya3Base;
import es.indra.sicc.dtos.mae.DTOPestanya4;
import es.indra.sicc.dtos.mae.DTOPestanyaBusqueda1;
import es.indra.sicc.dtos.mae.DTOPremioRecomendacion;
import es.indra.sicc.dtos.mae.DTOValidarClientes;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;


import es.indra.sicc.util.DTOString;
import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.mae.DTOModificarCliente;
import es.indra.sicc.dtos.mae.DTOObtenerPestanya4;
import es.indra.sicc.dtos.mae.DTODireccion;
import es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarClientesCursos;
import es.indra.sicc.dtos.mae.DTOClienteSubtipos;
import es.indra.sicc.dtos.mae.DTOClientesAsignarAptas;
import es.indra.sicc.dtos.mae.DTOREPHistorialCreditoCliente;
import es.indra.sicc.dtos.mae.DTOREPClienteDatosBasicos;
import es.indra.sicc.dtos.mae.DTOREPSolicitudMasAntiguaNoCancelada;
import es.indra.sicc.dtos.mae.DTOREPCuentasCorrientes;
import es.indra.sicc.dtos.mae.DTOREPCobranzas;
import es.indra.sicc.dtos.mae.DTOREPCredito;
import es.indra.sicc.dtos.cob.DTODatosClienteCOB;
import es.indra.sicc.dtos.mae.DTOREPSolicitudesBloqueadas;
import es.indra.sicc.dtos.mae.DTOClienteIndicador;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.dtos.inc.DTOBusquedaZonaTerritorioUA;
import es.indra.sicc.entidades.edu.MatrizCursosLocal;

public interface MONClientes extends EJBObject {
    String calcularModaNSEConsultoras(DTOUnidadAdministrativa unidadAdministrativa) throws MareException, RemoteException;
    Boolean hayConsultorasTerrAdm(Long[] territorios) throws MareException, RemoteException;
    Long obtenerOidCliente(Long pais, String codCliente) throws RemoteException, MareException;
    DTOSalida listaClientesPais(DTOBelcorp dto) throws MareException, RemoteException;
    Long[] obtenerConsultorasTerritorios(Long[] territorios) throws MareException, RemoteException;
    RecordSet listadoClientes() throws MareException, RemoteException;
    DTOBoolean esCodigoClienteAutomatico(DTOBelcorp dtoBelcorp) throws MareException, RemoteException;
    DTOSalida crearLotesClientes(DTOCrearLotesClientes dto) throws MareException, RemoteException;
    Long obtenerTerritorio(DTODireccion direccion, Boolean georeferenciador) throws MareException, RemoteException;
    String generarDigitoControl(Long codigoCliente) throws MareException, RemoteException;
    DTOPestanya1Base pestanya1Base(DTOBelcorp dto) throws RemoteException, MareException;
    DTOPestanya2Base pestanya2Base(DTOCodigoCliente dto) throws  RemoteException, MareException , RemoteException;
    DTOPestanya3Base pestanya3Base(DTOOIDs subtipoCliente) throws RemoteException, MareException;
    DTOPestanyaBusqueda1 pestanya1Busqueda(DTOBelcorp dto) throws MareException, RemoteException;
    void insertarCriteriosBusqueda(ClienteDatosBasicosLocal clienteDatosBasicos, ClienteDatosAdicionalesLocal clienteDatosAdicionales, Long idioma) throws RemoteException, MareException;
    DTOSalida obtenerVias(DTOOID dtoid) throws RemoteException, MareException;
    DTOConsultaCliente consultar(DTOOID oid) throws MareException, RemoteException;
    DTOPestanya2 pestanya2Busqueda(DTOBelcorp dto) throws MareException, RemoteException;
    DTOOID crearClienteBasico(DTOCrearClienteBasico dto) throws RemoteException, MareException;
    DTOPremioRecomendacion insertar(DTOCliente dto) throws RemoteException, MareException;
    DTOPestanya3 pestanya3Busqueda(DTOBelcorp dtoBelcorp) throws MareException, RemoteException;
    DTOCliente obtenerCliente(DTOOID oid) throws MareException, RemoteException;
    DTOPestanya4 pestanya4Busqueda(DTOBelcorp dto) throws MareException, RemoteException;
    DTOPestanya2 pestanya2(DTOCodigoCliente dto) throws MareException, RemoteException;
    DTOPestanya4 pestanya4(DTOObtenerPestanya4 dto) throws MareException, RemoteException;
    DTOSalida buscar(DTOCliente dto) throws MareException, RemoteException;
    Boolean comprobarCodigosCliente(DTOValidarClientes dto, DTOPestanya3 resultado) throws MareException, RemoteException;
    DTOPestanya3 pestanya3(DTOValidarClientes dto) throws MareException, RemoteException;
    DTOSalida busquedaRapida(DTOBusquedaRapidaCliente dto) throws RemoteException, MareException;
    void actualizarUnidadesAdmMAE(Long marca, Long pais, Long canal, Long territorio, Long cliente, DTOAuditableSICC dto, Long indDirePrincipal) throws RemoteException, MareException;
  	DTOPremioRecomendacion modificar(DTOModificarCliente dto) throws RemoteException, MareException;
    boolean ponerbloqueoFinanciero(Long cliente, String motivo, String observaciones) throws RemoteException, MareException;
    boolean quitarBloqueoFinanciero(Long cliente) throws MareException, RemoteException;
    DTODireccion[] obtenerDireccionCliente(Long oidCliente, Long oidTipoDireccion) throws MareException, RemoteException;
    String obtenerDireccion(DTOOID dto) throws MareException, RemoteException;
    DTOSalida buscarClientesBloqueoFinanciero(DTOBuscarClienteBloqueo criterios) throws MareException, RemoteException;
  	DTOSalida obtenerTiposDireccionCliente(DTOOID cliente) throws MareException, RemoteException;
    DTOUnidadAdministrativa obtenerUnidadAdministrativa(Long cliente, Long periodo) throws MareException, RemoteException;
    DTOSalida buscarClientesParaCurso(DTOBuscarClientesCursos dto) throws MareException, RemoteException;
    boolean estaClienteBloqueado(Long cliente, String tipoBloqueo) throws MareException, RemoteException;
    DTOClienteSubtipos obtieneClienteSubtiposAptas(DTOCodigoCliente dto) throws MareException, RemoteException;
    DTOSalida obtieneClientesAsignarAptas(DTOClientesAsignarAptas dto) throws MareException, RemoteException;
    Boolean hayClientesTerrAdm(Long terrAdm) throws  MareException, RemoteException;
    DTOSalida buscarClientesDesBloqueoFinanciero(DTOBuscarClienteBloqueo dto) throws MareException, RemoteException;
    DTOSalida obtenerMarcasClienteUnidadAdministrativa(DTOCodigoCliente dto) throws MareException, RemoteException;
    DTOSalida obtenerCanalesClienteUnidadAdministrativa(DTOCodigoCliente dto) throws MareException, RemoteException;
    DTOSalida consultarGerenteZona(DTOOID dto) throws MareException, RemoteException;
    DTOSalida obtenerZonaMarcaCanal(DTOOID dto) throws MareException, RemoteException;
  DTOGenerarCodigoCliente generaCodigoCliente(DTOBelcorp dtoe) throws MareException, RemoteException;

  DTOSalida obtenerGerentesRegion(DTOOID dto) throws MareException, RemoteException;

  DTOREPHistorialCreditoCliente obtenerHistorialCreditoCliente(DTOCodigoCliente dtoE) throws MareException, RemoteException;

  DTOREPClienteDatosBasicos obtenerDatosBasicosCliente(DTOCodigoCliente dtoE) throws MareException, RemoteException;

  DTOREPSolicitudMasAntiguaNoCancelada obtenerSolicitudMasAntiguaNoCancelada(DTOCodigoCliente dtoE) throws MareException, RemoteException;

  DTOREPCuentasCorrientes obtenerCuentaCorriente(DTOCodigoCliente dtoE) throws MareException, RemoteException;

  DTOREPCobranzas obtenerCobranzas(DTOCodigoCliente dtoE) throws MareException, RemoteException;

  DTOREPCredito obtenerDatosCredito(DTOCodigoCliente dtoE) throws MareException, RemoteException;

  DTODatosClienteCOB consultarDatosClienteCOB(DTOString dto) throws MareException, RemoteException;

  DTOREPSolicitudesBloqueadas obtenerSolicitudesBloqueadas(DTOCodigoCliente dtoE) throws MareException, RemoteException;

  DTOSalida obtenerUsuarioResponsable(DTOBelcorp dto) throws MareException, RemoteException;

  void desactivar(DTOClienteIndicador dTOClieInd) throws RemoteException, MareException;

    DTODireccion[] obtenerDireccionesPorTipo(Long oidCliente, Long oidTipoDireccion, Long idioma) throws RemoteException, MareException;

    DTOString validarDocumento(DTOColeccion dto) throws RemoteException, MareException;

  DTOUnidadAdministrativa obtenerUAActiva(Long oidCliente, Long oidPeriodo) throws MareException, RemoteException;

  DTOSalida obtenerZonaTerritorioUA(DTOBusquedaZonaTerritorioUA dto) throws RemoteException, MareException;

    int obtieneClientesAsignarAptasInBD(MatrizCursosLocal matCur, DTOClientesAsignarAptas dto, Long oidAsigna) throws MareException, RemoteException;

    DTOBoolean validarRecomendanteEnHijaDupla(DTOCodigoCliente dto) throws MareException, RemoteException;

    DTOSalida obtenerTodosTiposVinculo(es.indra.sicc.util.DTOOID dto) throws MareException, RemoteException;

    DTOBoolean validarEdadHijaDupla(DTOCodigoCliente dto) throws MareException, RemoteException;

    DTOSalida recuperarTipoSubtipoCliente(DTOCodigoCliente dto) throws MareException, RemoteException;

    DTOBoolean enviarMensajeRechazoDupla(DTOCodigoCliente dto) throws RemoteException, MareException;
    
    boolean existeClienteVinculo(Long pais, Long vinculante, Long vinculando, Long tipo, Boolean fechaNula) throws RemoteException, MareException;
    
    RecordSet obtenerPeriodoActualPorFecha(Long pais, Long marca, Long canal) throws RemoteException, MareException;
    
    Long buscarClienteVinculoDuplaCyzone(Long cliente, java.sql.Date fecha ) throws RemoteException, MareException;
    
    void actualizarFechaHastaClienteVinculo(Long oidClienteVinculo) throws RemoteException, MareException;
    
    void crearClasificacionDuplaCyzone(Long cliente, Long periodo, java.sql.Date fecha ) throws RemoteException, MareException;
    
    void actualizarAnteriorVinculanteDuplaCyzone(Long cliente, java.sql.Date fecha ) throws RemoteException, MareException;
    
    void comunicarBienvenidaDuplaCyzone(Long cliente, Long pais, Long idioma) throws RemoteException, MareException;

    DTOSalida busquedaRapidaNombreCompleto(DTOBusquedaRapidaCliente dto) throws MareException, RemoteException;
}
