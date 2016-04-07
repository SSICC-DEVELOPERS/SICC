package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_MOTIV_INCOB")
@NamedQueries({
@NamedQuery(name="MotivosNoCobroLocal.FindAll",query="select object(o) from MotivosNoCobroLocal o")
})
public class MotivosNoCobroLocal implements Serializable {

	public MotivosNoCobroLocal() {}

	public MotivosNoCobroLocal(Long oid, String codigoMotivoNoCobro, String descripcionMotivoNoCobro, Long pais)	{
	
		this.oid=oid;
                this.setCodigoMotivoNoCobro(codigoMotivoNoCobro);
	        this.setDescripcionMotivoNoCobro(descripcionMotivoNoCobro);
	        this.setPais(pais);
	
	}

	@Id
	@Column(name="OID_MOTI_COBR")
	private Long oid;
	@Column(name="COD_MOTI_COBR")
	private String codigoMotivoNoCobro;
	@Column(name="VAL_DESC_MOTI_COBR")
	private String descripcionMotivoNoCobro;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoMotivoNoCobro() {return codigoMotivoNoCobro;}
      
	public void setCodigoMotivoNoCobro(String codigoMotivoNoCobro){this.codigoMotivoNoCobro=codigoMotivoNoCobro;}
		
	public String getDescripcionMotivoNoCobro() {return descripcionMotivoNoCobro;}
      
	public void setDescripcionMotivoNoCobro(String descripcionMotivoNoCobro){this.descripcionMotivoNoCobro=descripcionMotivoNoCobro;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
