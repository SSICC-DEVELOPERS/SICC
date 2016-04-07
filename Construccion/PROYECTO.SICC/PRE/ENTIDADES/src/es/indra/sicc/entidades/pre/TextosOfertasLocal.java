package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_TEXTO_OFERT")
@NamedQueries({
@NamedQuery(name="TextosOfertasLocal.FindByNumeroOrdenYCabe",query="SELECT OBJECT(a) "
+"FROM TextosOfertasLocal AS a WHERE a.numeroOrden = ?1 and a.oidCabe = ?2")
})
public class TextosOfertasLocal implements Serializable {

	public TextosOfertasLocal() {}

	public TextosOfertasLocal(Long oid, Integer num_orde, Long mfca_oid_cabe, String val_text, Long oidCatalogo) {
	
		this.oid=oid;
                this.numeroOrden=num_orde;
                this.oidCabe=mfca_oid_cabe;
                this.texto=val_text;
                this.oidCatalogo=oidCatalogo;
	
	}

	@Id
	@Column(name="OID_TEXT_OFER")
	private Long oid;
	@Column(name="NUM_ORDE")
	private Integer numeroOrden;
	@Column(name="MFCA_OID_CABE")
	private Long oidCabe;
	@Column(name="VAL_TEXT")
	private String texto;
	@Column(name="OCAT_OID_CATA")
	private Long oidCatalogo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroOrden() {return numeroOrden;}
      
	public void setNumeroOrden(Integer numeroOrden){this.numeroOrden=numeroOrden;}
		
	public Long getOidCabe() {return oidCabe;}
      
	public void setOidCabe(Long oidCabe){this.oidCabe=oidCabe;}
		
	public String getTexto() {return texto;}
      
	public void setTexto(String texto){this.texto=texto;}
		
	public Long getOidCatalogo() {return oidCatalogo;}
      
	public void setOidCatalogo(Long oidCatalogo){this.oidCatalogo=oidCatalogo;}
			
	
}
