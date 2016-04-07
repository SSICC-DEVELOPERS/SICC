package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Date;
import java.io.Serializable;

@Entity
@Table(name="CAL_TEMPO_LLAMA_IVR")
@NamedQueries({
@NamedQuery(name="TemporalLlamadasIVRLocal.FindAll",query="select object(o) from TemporalLlamadasIVRLocal o "),
@NamedQuery(name="TemporalLlamadasIVRLocal.FindByUK",query="SELECT OBJECT(a) "
 + "FROM TemporalLlamadasIVRLocal AS a "
 + "WHERE a.telefono = ?1 AND a.pais = ?2")
})
public class TemporalLlamadasIVRLocal implements Serializable {

	public TemporalLlamadasIVRLocal() {}

	public TemporalLlamadasIVRLocal(Long oid, Long numTelf, Date fecLlam, Long paisOidPais)	{
	
		    this.oid=oid;
	            this.setTelefono(numTelf);
	            this.setFecha(fecLlam);
	            this.setPais(paisOidPais);
	
	}

	@Column(name="NUM_TELF")
	private Long telefono;
	@Column(name="FEC_LLAM")
	private java.sql.Date fecha;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_CLIE")
	private String codigoCliente;
	@Column(name="COD_TIPO_CLIEN")
	private String codigoTipoCliente;
	@Id
	@Column(name="OID_LLAM_IVR")
	private Long oid;

	
	public Long getTelefono() {return telefono;}
      
	public void setTelefono(Long telefono){this.telefono=telefono;}
		
	public java.sql.Date getFecha() {return fecha;}
      
	public void setFecha(java.sql.Date fecha){this.fecha=fecha;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigoCliente() {return codigoCliente;}
      
	public void setCodigoCliente(String codigoCliente){this.codigoCliente=codigoCliente;}
		
	public String getCodigoTipoCliente() {return codigoTipoCliente;}
      
	public void setCodigoTipoCliente(String codigoTipoCliente){this.codigoTipoCliente=codigoTipoCliente;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
