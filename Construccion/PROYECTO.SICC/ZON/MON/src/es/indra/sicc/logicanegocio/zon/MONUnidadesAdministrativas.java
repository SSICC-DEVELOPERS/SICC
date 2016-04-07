package es.indra.sicc.logicanegocio.zon;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.zon.DTOBuscarUA;
import es.indra.sicc.dtos.zon.DTOEstadoZona;
import es.indra.sicc.dtos.zon.DTOResponsable;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.dtos.zon.DTOBuscaZonaEstIni;
import es.indra.sicc.dtos.zon.DTOZona;
import java.rmi.RemoteException;

import javax.ejb.EJBObject;
import es.indra.sicc.dtos.zon.DTOPantallaAsignarEstado;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.dtos.zon.DTOUnidadesAdministrativas;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOString;


public interface MONUnidadesAdministrativas extends EJBObject {
    Integer consultaZonasAsignadas(Long gerente) throws MareException, RemoteException;

    DTOUnidadAdministrativa generaUATerritorio(Long pais, Long marca, Long canal, Long territorio, Long zona)
        throws MareException, RemoteException;

    void calcularNSE(DTOUnidadAdministrativa dtoe) throws MareException, RemoteException;

    RecordSet obtenerSecciones(DTOUnidadAdministrativa dtoe)
        throws RemoteException, MareException;

    RecordSet obtenerRegiones(DTOUnidadAdministrativa dtoe)
        throws RemoteException, MareException;

    RecordSet obtenerZonas(DTOUnidadAdministrativa dtoe) throws RemoteException, MareException;

    RecordSet obtenerSubgerenciaVentas(DTOUnidadAdministrativa dtoe)
        throws RemoteException, MareException;

    void actualizarUnidadesAdmMAE(Long marca, Long pais, Long canal, Long territorio, Long cliente, DTOAuditableSICC dto, Long indDirePrincipal)
        throws RemoteException, MareException;

    void evaluarZona(Long zona, Long tipoZona, Long periodo, Long tipoPeriodo)
        throws MareException, RemoteException;

    RecordSet obtenerTerritorios(DTOUnidadAdministrativa dtoe)
        throws RemoteException, MareException;

	void asignarEstadoZona(DTOColeccion dtoCol) throws RemoteException, MareException;

	//DTOPantallaAsignarEstado buscarZonasEstadoIni(DTOBuscaZonaEstIni dtBZEI) throws MareException, RemoteException;

	RecordSet obtenerTerritoriosAdministrativos(DTOUnidadAdministrativa dto) throws MareException, RemoteException;

	Long obtenerGerenteUniAdm(DTOUnidadAdministrativa dto) throws MareException, RemoteException;

  DTOSalida buscarZonasEstadoIni(DTOBuscaZonaEstIni arg) throws MareException, RemoteException;

  DTOSalida buscarEstadosZona(DTOBuscaZonaEstIni arg) throws MareException, RemoteException;

  RecordSet obtenerRegionesNoBorradas(DTOUnidadAdministrativa arg) throws MareException, RemoteException;

  RecordSet obtenerZonasNoBorradas(DTOUnidadAdministrativa arg) throws MareException, RemoteException;

  Long obtenerTerritorioAdministrativo(Long oidmarca, Long oidcliente) throws MareException, RemoteException;

  DTOSalida recargaRegiones(DTOUnidadAdministrativa dtoe) throws MareException, RemoteException;

    RecordSet obtenerSubgerenciaVentasSinFiltro(DTOUnidadAdministrativa dtoe) throws RemoteException, MareException;

    RecordSet obtenerRegionesSinFiltro(DTOUnidadAdministrativa dtoe) throws RemoteException, MareException;

    RecordSet obtenerZonasSinFiltro(DTOUnidadAdministrativa dtoe) throws RemoteException, MareException;

    RecordSet obtenerSeccionesSinFiltro(DTOUnidadAdministrativa dtoe) throws RemoteException, MareException;

    RecordSet obtenerTerritoriosSinFiltro(DTOUnidadAdministrativa dtoe) throws RemoteException, MareException;

    DTOSalida obtenerTerritoriosPorSeccion(DTOUnidadAdministrativa dtoin) throws RemoteException, MareException;

    DTOSalida obtenerSeccionesPorZona(DTOUnidadAdministrativa dtoin) throws RemoteException, MareException;

  DTOSalida obtenerRegionesPorSGV(DTOUnidadAdministrativa dtoin) throws MareException, RemoteException;

  DTOSalida obtenerZonasPorRegiones(DTOUnidadAdministrativa dtoin) throws MareException, RemoteException;

  DTOSalida recargaSubgerenciaVentas(DTOUnidadAdministrativa dtoe) throws RemoteException, MareException;

	DTOSalida recargaZonas(DTOUnidadAdministrativa dtoe) throws MareException, RemoteException;

	DTOSalida recargaSecciones(DTOUnidadAdministrativa dtoe) throws MareException, RemoteException;

	DTOSalida recargaTerritorios(DTOUnidadAdministrativa dtoe) throws MareException, RemoteException;

  DTOSalida obtenerRegionesPorPais(DTOBelcorp dto) throws RemoteException, MareException;

    void evaluacionEstadoZona(DTOFACProcesoCierre DTOE) throws MareException, RemoteException;

    void reestructurarUAdministrativasSegundaFase(DTOFACProcesoCierre DTOE) throws MareException, RemoteException;

    void actualizarEstado(DTOZona DTOE) throws MareException, RemoteException;

    DTOSalida buscarUnidadesAdministrativas(DTOBuscarUA dtoe) throws RemoteException, MareException;

    void asignarResponsable(DTOResponsable dtoe) throws MareException, RemoteException;

  DTOSalida obtenerTerritoriosporZonas(DTOBelcorp dtoIn) throws MareException, RemoteException;

    void enviarMensajeHistorico(Long oidGerenteAnterior, DTOResponsable dtoe) throws RemoteException, MareException;

    Long generarHistoricoResponsables(DTOResponsable dtoe, Long oidGerenteAnterior) throws RemoteException, MareException;

  DTOSalida obtenerDetalleResponsable(DTOOID dtoOid) throws MareException, RemoteException;

    DTOSalida recargaSeccionesCliente(DTOUnidadAdministrativa dto) throws MareException, RemoteException;

    DTOSalida recargaZonasCliente(DTOUnidadAdministrativa dto) throws MareException, RemoteException;

    DTOSalida recargaRegionesCliente(DTOUnidadAdministrativa dto) throws MareException, RemoteException;

  DTOSalida recargaUnidadesAdministrativasCliente(DTOUnidadAdministrativa dtoe) throws MareException, RemoteException;

    DTOSalida recargarZonasReg(DTOString dto) throws MareException, RemoteException;

    void asignarResponsableContinuar(DTOResponsable dtoe) throws MareException, RemoteException;


}