package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_TIPO_TRANS")
public class TiposTransaccionLocal implements Serializable {

	public TiposTransaccionLocal() {}

	public TiposTransaccionLocal(Long oid, Long pais, String codigo, Character tipoTransaccionCheque) {
	
		this.oid=oid;
                this.pais=pais;
                this.codigo=codigo;
                this.tipoTransaccionCheque=tipoTransaccionCheque;
	
	}

	@Id
	@Column(name="OID_TIPO_TRAN")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_TIPO_TRAN")
	private String codigo;
	@Column(name="COD_TIPO_TRAN_CHEQ")
	private Character tipoTransaccionCheque;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public Character getTipoTransaccionCheque() {return tipoTransaccionCheque;}
      
	public void setTipoTransaccionCheque(Character tipoTransaccionCheque){this.tipoTransaccionCheque=tipoTransaccionCheque;}
			
	
}
