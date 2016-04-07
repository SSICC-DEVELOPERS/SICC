package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOOIDs;

public class DTOParametrizacionMAV extends DTOAuditableSICC  {
	private Long oidParametrizacionMAV;
	private Long numeroRegistrosAviso;
	private Long limitePrecioAutorizacion;
	private Boolean autorizacionEnvio;
	private String direccionElectronicaEnvio;
	private Long oidTipoClienteRegion;
	private Long oidTipoClienteZona;
	private DTOOIDs subtiposClienteGerenteRegion;
	private DTOOIDs subtiposClienteGerenteZona;
	private Long oidEstrategia;
	private Long oidAlmacen;
        
        // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
        private Long oidCatalogo;
        private Long oidCondicionPromocion;

	public DTOParametrizacionMAV() {
	}

	public Long getOidParametrizacionMAV() {
		return oidParametrizacionMAV;
	}

	public void setOidParametrizacionMAV(Long newOidParametrizacionMAV) {
		oidParametrizacionMAV = newOidParametrizacionMAV;
	}

	public Long getNumeroRegistrosAviso() {
		return numeroRegistrosAviso;
	}

	public void setNumeroRegistrosAviso(Long newNumeroRegistrosAviso) {
		numeroRegistrosAviso = newNumeroRegistrosAviso;
	}

	public Long getLimitePrecioAutorizacion() {
		return limitePrecioAutorizacion;
	}

	public void setLimitePrecioAutorizacion(Long newLimitePrecioAutorizacion) {
		limitePrecioAutorizacion = newLimitePrecioAutorizacion;
	}

	public Boolean getAutorizacionEnvio() {
		return autorizacionEnvio;
	}

	public void setAutorizacionEnvio(Boolean newAutorizacionEnvio) {
		autorizacionEnvio = newAutorizacionEnvio;
	}

	public String getDireccionElectronicaEnvio() {
		return direccionElectronicaEnvio;
	}

	public void setDireccionElectronicaEnvio(String newDireccionElectronicaEnvio) {
		direccionElectronicaEnvio = newDireccionElectronicaEnvio;
	}

	public Long getOidTipoClienteRegion() {
		return oidTipoClienteRegion;
	}

	public void setOidTipoClienteRegion(Long newOidTipoClienteRegion) {
		oidTipoClienteRegion = newOidTipoClienteRegion;
	}

	public Long getOidTipoClienteZona() {
		return oidTipoClienteZona;
	}

	public void setOidTipoClienteZona(Long newOidTipoClienteZona) {
		oidTipoClienteZona = newOidTipoClienteZona;
	}

	public DTOOIDs getSubtiposClienteGerenteRegion() {
		return subtiposClienteGerenteRegion;
	}

	public void setSubtiposClienteGerenteRegion(DTOOIDs newSubtiposClienteGerenteRegion) {
		subtiposClienteGerenteRegion = newSubtiposClienteGerenteRegion;
	}

	public DTOOIDs getSubtiposClienteGerenteZona() {
		return subtiposClienteGerenteZona;
	}

	public void setSubtiposClienteGerenteZona(DTOOIDs newSubtiposClienteGerenteZona) {
		subtiposClienteGerenteZona = newSubtiposClienteGerenteZona;
	}

	public Long getOidEstrategia() {
		return oidEstrategia;
	}

	public void setOidEstrategia(Long newOidEstrategia) {
		oidEstrategia = newOidEstrategia;
	}

	public Long getOidAlmacen() {
		return oidAlmacen;
	}

	public void setOidAlmacen(Long newOidAlmacen) {
		oidAlmacen = newOidAlmacen;
	}

    public void setOidCatalogo(Long oidCatalogo) {
        this.oidCatalogo = oidCatalogo;
    }

    public Long getOidCatalogo() {
        return oidCatalogo;
    }

    public void setOidCondicionPromocion(Long oidCondicionPromocion) {
        this.oidCondicionPromocion = oidCondicionPromocion;
    }

    public Long getOidCondicionPromocion() {
        return oidCondicionPromocion;
    }
}
