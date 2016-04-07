package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_VALOR_ARGUM")
@NamedQueries({
@NamedQuery(name="ValoresArgumentosLocal.FindAll",query="select object(o) from ValoresArgumentosLocal o")
})
public class ValoresArgumentosLocal implements Serializable {

	public ValoresArgumentosLocal() {}

	public ValoresArgumentosLocal(Long oid, String valorArgumento, String descripcionValorArgumento, Long codigoArgumento)	{
	
		this.oid=oid;
                this.setValorArgumento(valorArgumento);
	        this.setDescripcionValorArgumento(descripcionValorArgumento);
	        this.setCodigoArgumento(codigoArgumento);
	
	}

	@Id
	@Column(name="OID_VALO_ARGU")
	private Long oid;
	@Column(name="VAL_ARGU")
	private String valorArgumento;
	@Column(name="VAL_DESC_VALO_ARGU")
	private String descripcionValorArgumento;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="ARGU_OID_ARGU")
	private Long codigoArgumento;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getValorArgumento() {return valorArgumento;}
      
	public void setValorArgumento(String valorArgumento){this.valorArgumento=valorArgumento;}
		
	public String getDescripcionValorArgumento() {return descripcionValorArgumento;}
      
	public void setDescripcionValorArgumento(String descripcionValorArgumento){this.descripcionValorArgumento=descripcionValorArgumento;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getCodigoArgumento() {return codigoArgumento;}
      
	public void setCodigoArgumento(Long codigoArgumento){this.codigoArgumento=codigoArgumento;}
			
	
}
