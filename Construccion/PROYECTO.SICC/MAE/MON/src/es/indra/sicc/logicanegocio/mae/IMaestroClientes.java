package es.indra.sicc.logicanegocio.mae;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.dtos.mae.DTODireccion;
import es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.ArrayList;

public interface IMaestroClientes {
//public Long obtenerIDCliente(Long pais, String codCliente) throws MareException;
  public DTOSalida listaClientesPais(DTOBelcorp dto) throws MareException;
  public Boolean hayConsultorasTerrAdm(Long[] terrAdm) throws MareException;
  public String calcularModaNSEConsultoras(DTOUnidadAdministrativa adm) throws MareException;  
  public Long[] obtenerConsultorasTerritorios(Long[] territorios) throws MareException;
  public DTODireccion[] obtenerDireccionCliente (Long oidCliente, Long oidTipoDireccion) throws MareException; 
  public RecordSet listadoClientes() throws MareException;
  public String obtenerDireccion(DTOOID dto) throws MareException;
  public DTOSalida buscarClientesBloqueoFinanciero (DTOBuscarClienteBloqueo criterios) throws MareException;
  public boolean ponerbloqueoFinanciero(Long cliente, String motivo, String observaciones) throws MareException;
  public DTOSalida obtenerTiposDireccionCliente(DTOOID cliente) throws MareException;
  public DTOUnidadAdministrativa obtenerUnidadAdministrativa(Long cliente, Long periodo) throws MareException;
  public boolean estaClienteBloqueado(Long cliente, String tipoBloqueo) throws MareException;
  public Long obtenerOidCliente(Long pais, String codCliente) throws MareException;
  public Boolean hayClientesTerrAdm(Long terrAdm) throws MareException;
  public DTOSalida consultarGerenteZona(DTOOID dto) throws MareException;
  public DTOSalida obtenerZonaMarcaCanal (DTOOID dto) throws MareException;
  public DTODireccion[] obtenerDireccionesPorTipo(Long oidCliente, Long oidTipoDireccion, Long idioma) throws MareException;
  //public DTOUnidadAdministrativa obtenerUAActiva(Long oidCliente, Long oidPeriodo) throws MareException;
}