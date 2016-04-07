package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="CCC_BLOQU_MOVIM_BANCO")
@NamedQueries({
@NamedQuery(name="BloqueoMovBancLocal.FindByUk",query="select OBJECT(o) FROM BloqueoMovBancLocal o WHERE o.movimientoBanc = ?1")
})
public class BloqueoMovBancLocal implements Serializable {

	public BloqueoMovBancLocal() {}

	public BloqueoMovBancLocal(Long oid, String usuario, BigDecimal tiempo, Long movimientoBanc) {
	
		this.oid=oid;
                this.usuario=usuario;
                this.tiempo=tiempo;
                this.movimientoBanc=movimientoBanc;                
                
	
	}

	@Id
	@Column(name="OID_BLOQ_MOVI")
	private Long oid;
	@Column(name="COD_USUA")
	private String usuario;
	@Column(name="VAL_TIEM")
	private java.math.BigDecimal tiempo;
	@Column(name="CMBA_OID_MOVI_BANC")
	private Long movimientoBanc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getUsuario() {return usuario;}
      
	public void setUsuario(String usuario){this.usuario=usuario;}
		
	public java.math.BigDecimal getTiempo() {return tiempo;}
      
	public void setTiempo(java.math.BigDecimal tiempo){this.tiempo=tiempo;}
		
	public Long getMovimientoBanc() {return movimientoBanc;}
      
	public void setMovimientoBanc(Long movimientoBanc){this.movimientoBanc=movimientoBanc;}
			
	
}
