package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTDemandaAnormal extends DTOBelcorp  {
	private String codigoPais;
	private String codigoSociedad;
	private String codigoAlmacen;
	private String canalBPS;
	private String medio;
	private String codigoProducto;
	private String codigoTipoOferta;
	private String codigoCicloVida;
	private String codigoDemandaAnormal;

	public DTOINTDemandaAnormal() {
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getCodigoSociedad() {
		return codigoSociedad;
	}

	public void setCodigoSociedad(String codigoSociedad) {
		this.codigoSociedad = codigoSociedad;
	}

	public String getCodigoAlmacen() {
		return codigoAlmacen;
	}

	public void setCodigoAlmacen(String codigoAlmacen) {
		this.codigoAlmacen = codigoAlmacen;
	}

	public String getCanalBPS() {
		return canalBPS;
	}

	public void setCanalBPS(String canalBPS) {
		this.canalBPS = canalBPS;
	}

	public String getMedio() {
		return medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getCodigoTipoOferta() {
		return codigoTipoOferta;
	}

	public void setCodigoTipoOferta(String codigoTipoOferta) {
		this.codigoTipoOferta = codigoTipoOferta;
	}

	public String getCodigoCicloVida() {
		return codigoCicloVida;
	}

	public void setCodigoCicloVida(String codigoCicloVida) {
		this.codigoCicloVida = codigoCicloVida;
	}

	public String getCodigoDemandaAnormal() {
		return codigoDemandaAnormal;
	}

	public void setCodigoDemandaAnormal(String codigoDemandaAnormal) {
		this.codigoDemandaAnormal = codigoDemandaAnormal;
	}
}