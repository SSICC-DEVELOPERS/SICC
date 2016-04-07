package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_CONDI_PROMO")
@NamedQueries({
@NamedQuery(name="CondicionPromocionLocal.FindByUK",query="SELECT OBJECT(c) "
+"FROM CondicionPromocionLocal AS c WHERE c.codigoCondicionPromocion = ?1")
})
public class CondicionPromocionLocal implements Serializable {

	public CondicionPromocionLocal() {}

	public CondicionPromocionLocal(Long oid, String cod_cond_prom) {
	
		this.oid=oid;
                this.codigoCondicionPromocion=cod_cond_prom;
	
	}

	@Id
	@Column(name="OID_COND_PROM")
	private Long oid;
	@Column(name="COD_COND_PROM")
	private String codigoCondicionPromocion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoCondicionPromocion() {return codigoCondicionPromocion;}
      
	public void setCodigoCondicionPromocion(String codigoCondicionPromocion){this.codigoCondicionPromocion=codigoCondicionPromocion;}
			
	
}
