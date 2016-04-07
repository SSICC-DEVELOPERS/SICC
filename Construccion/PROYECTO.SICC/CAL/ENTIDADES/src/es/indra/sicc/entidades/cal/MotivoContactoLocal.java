package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAL_MOTIV_CONTA")
@NamedQueries({
   @NamedQuery(name="MotivoContactoLocal.FindAll",query="SELECT OBJECT(a) FROM MotivoContactoLocal AS a")
})
public class MotivoContactoLocal implements Serializable {

	public MotivoContactoLocal() {}

	public MotivoContactoLocal(Long oid, String cod_moti)	{
	
		this.oid=oid;
	        setCodMotivo(cod_moti);
	
	}

	@Id
	@Column(name="OID_MOTI_CONT")
	private Long oid;
	@Column(name="COD_MOTI")
	private String codMotivo;
	@Column(name="COD_PROC")
	private String codProceso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodMotivo() {return codMotivo;}
      
	public void setCodMotivo(String codMotivo){this.codMotivo=codMotivo;}
		
	public String getCodProceso() {return codProceso;}
      
	public void setCodProceso(String codProceso){this.codProceso=codProceso;}
			
	
}
