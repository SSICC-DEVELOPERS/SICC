package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_ARTIC_PREMI_ALTER")
@NamedQueries({
@NamedQuery(name="ArticulosPremioAlternativoLocal.FindAll",query="select object(o) from ArticulosPremioAlternativoLocal o")
})
public class ArticulosPremioAlternativoLocal implements Serializable {

	public ArticulosPremioAlternativoLocal() {}

	public ArticulosPremioAlternativoLocal(Long oid, Integer premioAlternativo, Integer cantidad, Long faltante, Long codigoProducto)	{
	
		this.oid=oid;
                this.setPremioAlternativo(premioAlternativo);
	        this.setCantidad(cantidad);
	        this.setFaltante(faltante);
	        this.setCodigoProducto(codigoProducto);
	
	}

	@Id
	@Column(name="OID_ARTI_PREM_ALTE")
	private Long oid;
	@Column(name="VAL_PREM_ALTE")
	private Integer premioAlternativo;
	@Column(name="VAL_CANT")
	private Integer cantidad;
	@Column(name="BOFA_OID_BOLS_FALT")
	private Long faltante;
	@Column(name="PROD_OID_PROD")
	private Long codigoProducto;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getPremioAlternativo() {return premioAlternativo;}
      
	public void setPremioAlternativo(Integer premioAlternativo){this.premioAlternativo=premioAlternativo;}
		
	public Integer getCantidad() {return cantidad;}
      
	public void setCantidad(Integer cantidad){this.cantidad=cantidad;}
		
	public Long getFaltante() {return faltante;}
      
	public void setFaltante(Long faltante){this.faltante=faltante;}
		
	public Long getCodigoProducto() {return codigoProducto;}
      
	public void setCodigoProducto(Long codigoProducto){this.codigoProducto=codigoProducto;}
			
	
}
