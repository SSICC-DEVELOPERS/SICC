package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_ARGUM")
@NamedQueries({
@NamedQuery(name="ArgumentosLocal.FindAll",query="select object(o) from ArgumentosLocal o")
})
public class ArgumentosLocal implements Serializable {

	public ArgumentosLocal() {}

	public ArgumentosLocal(Long oid, String codigoArgumento, String descripcion, Long pais)	{
	
		this.oid=oid;
                this.setCodigoArgumento(codigoArgumento);
	        this.setDescripcion(descripcion);
	        this.setPais(pais);
	
	}

	@Id
	@Column(name="OID_ARGU")
	private Long oid;
	@Column(name="COD_ARGU")
	private String codigoArgumento;
	@Column(name="VAL_DESC")
	private String descripcion;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoArgumento() {return codigoArgumento;}
      
	public void setCodigoArgumento(String codigoArgumento){this.codigoArgumento=codigoArgumento;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
