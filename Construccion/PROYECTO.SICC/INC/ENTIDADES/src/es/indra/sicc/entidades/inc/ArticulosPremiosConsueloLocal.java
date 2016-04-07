package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_ARTIC_PREMI_CONSU")
@NamedQueries({
@NamedQuery(name="ArticulosPremiosConsueloLocal.FindAll",query="select object(o) from ArticulosPremiosConsueloLocal o")
})
public class ArticulosPremiosConsueloLocal implements Serializable {

	public ArticulosPremiosConsueloLocal() {}

	public ArticulosPremiosConsueloLocal(Long oid, Long premioConsuelo, Long prodOidProd, Boolean indCentroServGar, String indTipoEntrega)	{
	
		this.oid=oid;
                this.setCodigoProducto(prodOidProd);
                this.setPremioConsuelo(premioConsuelo);
                this.setIndCentroServGar(indCentroServGar);
                this.setIndTipoEntrega(indTipoEntrega);
	
	}

	@Id
	@Column(name="OID_ARTI_PREM_CONS")
	private Long oid;
	@Column(name="PROD_OID_PROD")
	private Long codigoProducto;
	@Column(name="PRCO_OID_PREM_CONS")
	private Long premioConsuelo;
	@Column(name="IND_CENT_DIST_GARA")
	private Boolean indCentroServGar;
	@Column(name="CESE_OID_CESE_GARA")
	private Long oidCentroServGar;
	@Column(name="NUM_MESE_GARA")
	private Integer numMeses;
	@Column(name="OBS_CENT_DIST")
	private String observaciones;
	@Column(name="IND_TIPO_ENTR_PREM")
	private String indTipoEntrega;
	@Column(name="CESE_OID_CESE_ENTR")
	private Long oidCentroServEntrega;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCodigoProducto() {return codigoProducto;}
      
	public void setCodigoProducto(Long codigoProducto){this.codigoProducto=codigoProducto;}
		
	public Long getPremioConsuelo() {return premioConsuelo;}
      
	public void setPremioConsuelo(Long premioConsuelo){this.premioConsuelo=premioConsuelo;}
		
	public Boolean getIndCentroServGar() {return indCentroServGar;}
      
	public void setIndCentroServGar(Boolean indCentroServGar){this.indCentroServGar=indCentroServGar;}
		
	public Long getOidCentroServGar() {return oidCentroServGar;}
      
	public void setOidCentroServGar(Long oidCentroServGar){this.oidCentroServGar=oidCentroServGar;}
		
	public Integer getNumMeses() {return numMeses;}
      
	public void setNumMeses(Integer numMeses){this.numMeses=numMeses;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public String getIndTipoEntrega() {return indTipoEntrega;}
      
	public void setIndTipoEntrega(String indTipoEntrega){this.indTipoEntrega=indTipoEntrega;}
		
	public Long getOidCentroServEntrega() {return oidCentroServEntrega;}
      
	public void setOidCentroServEntrega(Long oidCentroServEntrega){this.oidCentroServEntrega=oidCentroServEntrega;}
			
	
}
