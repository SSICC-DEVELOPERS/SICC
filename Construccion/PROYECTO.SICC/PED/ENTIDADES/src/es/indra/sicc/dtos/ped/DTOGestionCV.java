package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOGestionCV  extends DTOAuditableSICC {
	private String txtCodigoVenta;
	private Long codigoVenta;
	private String catalogo;
	private Integer numPagina;
    /*
     * Propiedades agregada por cambio SiCC 20070284
     * Rafael Romero - 07/06/2007
     */
	private String codigoSAP;
    private String descripcionSAP;
    private BigDecimal precioCatalogo;


	public DTOGestionCV() {
	}

	public String getTxtCodigoVenta(){
		return txtCodigoVenta;
	}

	public Long getCodigoVenta(){
		return codigoVenta;
	}

	public String getCatalogo(){
		return catalogo;
	}

	public Integer getNumPagina(){
		return numPagina;
	}

	public void setTxtCodigoVenta(String newTxtCodigoVenta){
		txtCodigoVenta = newTxtCodigoVenta;
	}

	public void setCodigoVenta(Long newCodigoVenta){
		codigoVenta = newCodigoVenta;
	}

	public void setCatalogo(String newCatalogo){
		catalogo = newCatalogo;
	}

	public void setNumPagina(Integer newNumPagina){
		numPagina = newNumPagina;
	}


    public void setCodigoSAP(String codigoSAP) {
        this.codigoSAP = codigoSAP;
    }


    public String getCodigoSAP() {
        return codigoSAP;
    }


    public void setDescripcionSAP(String descripcionSAP) {
        this.descripcionSAP = descripcionSAP;
    }


    public String getDescripcionSAP() {
        return descripcionSAP;
    }


    public void setPrecioCatalogo(BigDecimal precioCatalogo) {
        this.precioCatalogo = precioCatalogo;
    }


    public BigDecimal getPrecioCatalogo() {
        return precioCatalogo;
    }
}