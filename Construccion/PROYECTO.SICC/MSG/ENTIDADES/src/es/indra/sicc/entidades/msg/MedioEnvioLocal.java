package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MSG_MEDIO_ENVIO")
public class MedioEnvioLocal implements Serializable {

	public MedioEnvioLocal() {}

	public MedioEnvioLocal(Long oid,String cod_medi_envio, String des_medi_envi)	{
	
		this.oid=oid;
                this.cod_medi_envi=cod_medi_envio;
                this.des_medi_envi=des_medi_envi;
	
	}

	@Id
	@Column(name="OID_MEDI_ENVI")
	private Long oid;
	@Column(name="COD_MEDI_ENVI")
	private String cod_medi_envi;
	@Column(name="DES_MEDI_ENVI")
	private String des_medi_envi;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCod_medi_envi() {return cod_medi_envi;}
      
	public void setCod_medi_envi(String cod_medi_envi){this.cod_medi_envi=cod_medi_envi;}
		
	public String getDes_medi_envi() {return des_medi_envi;}
      
	public void setDes_medi_envi(String des_medi_envi){this.des_medi_envi=des_medi_envi;}
			
	
}
