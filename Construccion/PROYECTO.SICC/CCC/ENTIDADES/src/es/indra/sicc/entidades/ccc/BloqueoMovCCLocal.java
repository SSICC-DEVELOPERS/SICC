package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_BLOQU_MOVIM_CUECO")
@NamedQueries({
@NamedQuery(name="BloqueoMovCCLocal.FindByUk",query="select OBJECT(o) FROM BloqueoMovCCLocal o WHERE o.movimientoCC = ?1")
})
public class BloqueoMovCCLocal implements Serializable {

	public BloqueoMovCCLocal() {}

	public BloqueoMovCCLocal(Long oid, String usuario, Long tiempo, Long movimientoCC) {
	
		this.oid=oid;
                this.usuario=usuario;
                this.tiempo=tiempo;
                this.movimientoCC=movimientoCC;                
	
	}

	@Id
	@Column(name="OID_BLOQ_MOVI_CUCO")
	private Long oid;
	@Column(name="COD_USUA")
	private String usuario;
	@Column(name="VAL_TIEM")
	private Long tiempo;
	@Column(name="MVCC_OID_MOVI_CC")
	private Long movimientoCC;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getUsuario() {return usuario;}
      
	public void setUsuario(String usuario){this.usuario=usuario;}
		
	public Long getTiempo() {return tiempo;}
      
	public void setTiempo(Long tiempo){this.tiempo=tiempo;}
		
	public Long getMovimientoCC() {return movimientoCC;}
      
	public void setMovimientoCC(Long movimientoCC){this.movimientoCC=movimientoCC;}
			
	
}
