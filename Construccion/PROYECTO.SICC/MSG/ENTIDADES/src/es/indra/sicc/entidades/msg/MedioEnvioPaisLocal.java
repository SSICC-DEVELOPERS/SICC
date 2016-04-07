package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_MEDIO_ENVIO_PAIS")
public class MedioEnvioPaisLocal implements Serializable {

	public MedioEnvioPaisLocal() {}

	public MedioEnvioPaisLocal(Long oid, Long pais_oid_pais, Long meen_oid_medi_envi, String cod_esta)	{
	
		this.oid=oid;
                this.estado=cod_esta;
                this.oidPais=pais_oid_pais;
                this.oidMediosEnvio=meen_oid_medi_envi;
	
	}

	@Id
	@Column(name="OID_MEDI_ENVI_PAIS")
	private Long oid;
	@Column(name="COD_ESTA")
	private String estado;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="MEEN_OID_MEDI_ENVI")
	private Long oidMediosEnvio;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getEstado() {return estado;}
      
	public void setEstado(String estado){this.estado=estado;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidMediosEnvio() {return oidMediosEnvio;}
      
	public void setOidMediosEnvio(Long oidMediosEnvio){this.oidMediosEnvio=oidMediosEnvio;}
			
	
}
