package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_SITUA_CUPON")
@NamedQueries({
@NamedQuery(name="SituacionCuponesLocal.FindByCodigoSituacion",query="SELECT OBJECT(s) FROM SituacionCuponesLocal s"
+ " WHERE s.codigoSituacion = ?1")
})
public class SituacionCuponesLocal implements Serializable {

	public SituacionCuponesLocal() {}

	public SituacionCuponesLocal(Long oid, String codigoSituacion, String descripcion) {
	
		this.oid=oid;
                this.codigoSituacion=codigoSituacion;
                this.descripcion=descripcion;
	
	}

	@Id
	@Column(name="OID_SITU_CUPO")
	private Long oid;
	@Column(name="COD_SITU_CUPO")
	private String codigoSituacion;
	@Column(name="VAL_DESC_SITU_CUPO")
	private String descripcion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoSituacion() {return codigoSituacion;}
      
	public void setCodigoSituacion(String codigoSituacion){this.codigoSituacion=codigoSituacion;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
			
	
}
