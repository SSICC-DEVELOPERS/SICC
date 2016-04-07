package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEValidarProducto extends DTOAuditableSICC  {
	private Long pais;
	private Long marca;
	private Long canal;
	private Long periodo;
	private Long periodoFin;
	private Long tipoOferta;
	private Long cicloVida;
	private Long formaPago;
	private String codigoSAP;
	private Double precioCatalogo;
	private Double precioContable;
  private Long oidAcceso;
  private Long oidSubacceso;

	public DTOEValidarProducto() {
	}

	public Long getPais() {
		return pais;
	}

	public void setPais(Long newPais) {
		pais = newPais;
	}

	public Long getMarca() {
		return marca;
	}

	public void setMarca(Long newMarca) {
		marca = newMarca;
	}

	public Long getCanal() {
		return canal;
	}

	public void setCanal(Long newCanal) {
		canal = newCanal;
	}

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long newPeriodo) {
		periodo = newPeriodo;
	}

	public Long getPeriodoFin() {
		return periodoFin;
	}

	public void setPeriodoFin(Long newPeriodoFin) {
		periodoFin = newPeriodoFin;
	}

	public Long getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(Long newTipoOferta) {
		tipoOferta = newTipoOferta;
	}

	public Long getCicloVida() {
		return cicloVida;
	}

	public void setCicloVida(Long newCicloVida) {
		cicloVida = newCicloVida;
	}

	public Long getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(Long newFormaPago) {
		formaPago = newFormaPago;
	}

	public String getCodigoSAP() {
		return codigoSAP;
	}

	public void setCodigoSAP(String newCodigoSAP) {
		codigoSAP = newCodigoSAP;
	}

	public Double getPrecioCatalogo() {
		return precioCatalogo;
	}

	public void setPrecioCatalogo(Double newPrecioCatalogo) {
		precioCatalogo = newPrecioCatalogo;
	}

	public Double getPrecioContable() {
		return precioContable;
	}

	public void setPrecioContable(Double newPrecioContable) {
		precioContable = newPrecioContable;
	}

  public Long getOidAcceso() {
    return oidAcceso;
  }

  public void setOidAcceso(Long newOidAcceso) {
    oidAcceso = newOidAcceso;
  }

  public Long getOidSubacceso() {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long newOidSubacceso) {
    oidSubacceso = newOidSubacceso;
  }
  
}