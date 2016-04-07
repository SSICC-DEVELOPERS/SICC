package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_PESOS_MODUL_11")
@NamedQueries({
@NamedQuery(name="PesosModulo11Local.FindAll", query="SELECT OBJECT(o) FROM PesosModulo11Local AS o")
})
public class PesosModulo11Local implements Serializable {

	public PesosModulo11Local() {}

	public PesosModulo11Local(Long oid, Long num_posi, Long val_peso_apli)	{
            this.oid=oid;
            this.num_posi = num_posi;
            this.val_peso_apli = val_peso_apli;
	}

	@Id
	@Column(name="OID_PESO_MODU_11")
	private Long oid;
	@Column(name="NUM_POSI")
	private Long num_posi;
	@Column(name="VAL_PESO_APLI")
	private Long val_peso_apli;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNum_posi() {return num_posi;}
      
	public void setNum_posi(Long num_posi){this.num_posi=num_posi;}
		
	public Long getVal_peso_apli() {return val_peso_apli;}
      
	public void setVal_peso_apli(Long val_peso_apli){this.val_peso_apli=val_peso_apli;}
			
	
}
