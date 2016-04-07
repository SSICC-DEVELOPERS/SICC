package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.ArrayList;
import java.lang.Character;

public class DTOECBRegistrosMAV extends DTOSiccPaginacion  {
	private Long oidMarca;
	private Long oidCanal;
	private ArrayList subgerencia;
	private ArrayList region;
	private ArrayList zona;
	private Long oidActividadMAV;
	private Long oidPeriodo;
	private Character estadoEnvio;
	private Long oidTipoEstadoProceso;
	private ArrayList tipoCliente;
	private ArrayList tipoDespacho;
	private ArrayList productos;

	public DTOECBRegistrosMAV() {
	}

	public Long getOidMarca() {
		return oidMarca;
	}

	public void setOidMarca(Long newOidMarca) {
		oidMarca = newOidMarca;
	}

	public Long getOidCanal() {
		return oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		oidCanal = newOidCanal;
	}

	public ArrayList getSubgerencia() {
		return subgerencia;
	}

	public void setSubgerencia(ArrayList newSubgerencia) {
		subgerencia = newSubgerencia;
	}

	public ArrayList getRegion() {
		return region;
	}

	public void setRegion(ArrayList newRegion) {
		region = newRegion;
	}

	public ArrayList getZona() {
		return zona;
	}

	public void setZona(ArrayList newZona) {
		zona = newZona;
	}

	public Long getOidActividadMAV() {
		return oidActividadMAV;
	}

	public void setOidActividadMAV(Long newOidActividadMAV) {
		oidActividadMAV = newOidActividadMAV;
	}

	public Long getOidPeriodo() {
		return oidPeriodo;
	}

	public void setOidPeriodo(Long newOidPeriodo) {
		oidPeriodo = newOidPeriodo;
	}

	public Character getEstadoEnvio() {
		return estadoEnvio;
	}

	public void setEstadoEnvio(Character newEstadoEnvio) {
		estadoEnvio = newEstadoEnvio;
	}

	public Long getOidTipoEstadoProceso() {
		return oidTipoEstadoProceso;
	}

	public void setOidTipoEstadoProceso(Long newOidTipoEstadoProceso) {
		oidTipoEstadoProceso = newOidTipoEstadoProceso;
	}

	public ArrayList getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(ArrayList newTipoCliente) {
		tipoCliente = newTipoCliente;
	}

	public ArrayList getTipoDespacho() {
		return tipoDespacho;
	}

	public void setTipoDespacho(ArrayList newTipoDespacho) {
		tipoDespacho = newTipoDespacho;
	}

	public ArrayList getProductos() {
		return productos;
	}

	public void setProductos(ArrayList newProductos) {
		productos = newProductos;
	}
}