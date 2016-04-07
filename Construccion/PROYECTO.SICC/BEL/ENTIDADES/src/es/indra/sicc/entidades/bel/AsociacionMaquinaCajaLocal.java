package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_ASOCI_MAQUI_CAJA")
@NamedQueries({
@NamedQuery(name="AsociacionMaquinaCajaLocal.FindByUK",query="SELECT OBJECT(a) FROM AsociacionMaquinaCajaLocal AS a WHERE a.maquina = ?1")
})
public class AsociacionMaquinaCajaLocal implements Serializable {

	public AsociacionMaquinaCajaLocal() {}

	public AsociacionMaquinaCajaLocal(Long oid, String val_maqu, Long caja_oid_caja)	{
		this.oid=oid;
                this.maquina = val_maqu;
                this.oidCaja = caja_oid_caja;
	}

	@Id
	@Column(name="OID_ASOC_MAQU_CAJA")
	private Long oid;
	@Column(name="VAL_MAQU")
	private String maquina;
	@Column(name="CAJA_OID_CAJA")
	private Long oidCaja;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getMaquina() {return maquina;}
      
	public void setMaquina(String maquina){this.maquina=maquina;}
		
	public Long getOidCaja() {return oidCaja;}
      
	public void setOidCaja(Long oidCaja){this.oidCaja=oidCaja;}
			
	
}
