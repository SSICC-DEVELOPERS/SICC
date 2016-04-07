/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.zon;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOSalida;
import java.rmi.RemoteException;

public interface IServiceUnidadesAdministrativas  {

    public RecordSet obtenerZonas(DTOUnidadAdministrativa dtoe) throws MareException;

    public RecordSet obtenerRegiones(DTOUnidadAdministrativa dtoe) throws MareException;

    public RecordSet obtenerSecciones(DTOUnidadAdministrativa dtoe) throws MareException;

    public RecordSet obtenerSubgerenciaVentas(DTOUnidadAdministrativa dtoe) throws MareException;

    public RecordSet obtenerTerritorios(DTOUnidadAdministrativa dtoe) throws MareException;

    public void actualizarUnidadesAdmMAE(Long marca, Long pais, Long canal, Long territorio, Long cliente, DTOAuditableSICC dto, Long indDirePrincipal) throws MareException, RemoteException;;

    public RecordSet obtenerTerritoriosAdministrativos(DTOUnidadAdministrativa dtoe) throws MareException;

    public Long obtenerGerenteUniAdm(DTOUnidadAdministrativa dto) throws MareException;

    public Long obtenerTerritorioAdministrativo(Long oidmarca, Long oidcliente) throws MareException;

    public RecordSet obtenerSubgerenciaVentasSinFiltro(DTOUnidadAdministrativa dtoe) throws  MareException;

    public RecordSet obtenerRegionesSinFiltro(DTOUnidadAdministrativa dtoe) throws MareException;

    public RecordSet obtenerZonasSinFiltro(DTOUnidadAdministrativa dtoe) throws MareException;

    public RecordSet obtenerSeccionesSinFiltro(DTOUnidadAdministrativa dtoe) throws MareException;

    public DTOSalida obtenerRegionesPorSGV(DTOUnidadAdministrativa dtoe) throws MareException;

    public DTOSalida obtenerZonasPorRegiones(DTOUnidadAdministrativa dtoe) throws MareException;

    public DTOSalida recargaSubgerenciaVentas(DTOUnidadAdministrativa dtoe) throws MareException;

    public DTOSalida recargaRegiones(DTOUnidadAdministrativa dtoe) throws MareException;

    public DTOSalida recargaZonas(DTOUnidadAdministrativa dtoe) throws MareException;

    public DTOSalida recargaSecciones(DTOUnidadAdministrativa dtoe) throws MareException;

    public DTOSalida recargaTerritorios(DTOUnidadAdministrativa dtoe) throws MareException;   

}