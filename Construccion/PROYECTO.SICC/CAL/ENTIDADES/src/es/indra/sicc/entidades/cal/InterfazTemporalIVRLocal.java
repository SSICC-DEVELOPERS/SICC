package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CAL_TEMPO_LLAMA_IVR")
@NamedQueries({
 @NamedQuery(name="InterfazTemporalIVRLocal.FindAll",query="SELECT OBJECT(a) FROM InterfazTemporalIVRLocal AS a")
})
public class InterfazTemporalIVRLocal implements Serializable {

	public InterfazTemporalIVRLocal() {}

	public InterfazTemporalIVRLocal(Long oid, Long num_telf, String fec_llam, Long pais_oid_pais)	{
	
		this.oid=oid;
	        setTelefono(num_telf);
	        setFecha(fec_llam);
	        setPais(pais_oid_pais);

	
	}

	@Id
	@Column(name="OID_LLAM_IVR")
	private Long oid;
	@Column(name="NUM_TELF")
	private Long telefono;
	@Column(name="FEC_LLAM")
	private String fecha;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="COD_CLIE")
	private String codigoCliente;
	@Column(name="COD_TIPO_CLIEN")
	private String codigoTipoCliente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getTelefono() {return telefono;}
      
	public void setTelefono(Long telefono){this.telefono=telefono;}
		
	public String getFecha() {return fecha;}
      
	public void setFecha(String fecha){this.fecha=fecha;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getCodigoCliente() {return codigoCliente;}
      
	public void setCodigoCliente(String codigoCliente){this.codigoCliente=codigoCliente;}
		
	public String getCodigoTipoCliente() {return codigoTipoCliente;}
      
	public void setCodigoTipoCliente(String codigoTipoCliente){this.codigoTipoCliente=codigoTipoCliente;}
			
	
}
