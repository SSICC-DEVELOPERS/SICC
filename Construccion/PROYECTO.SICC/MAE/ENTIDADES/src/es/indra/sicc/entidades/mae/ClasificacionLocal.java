package es.indra.sicc.entidades.mae;	

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAE_CLASI")
@NamedQueries({
@NamedQuery(name="ClasificacionLocal.FindAll",query="select object(o) from ClasificacionLocal o"),
@NamedQuery(name="ClasificacionLocal.FindByUK",query="select object(c) from ClasificacionLocal c where c.tipoClasificacion = ?1 and c.codigo = ?2")
})
public class ClasificacionLocal implements Serializable {

	public ClasificacionLocal() {}

	public ClasificacionLocal(Long oid, Long tipoClasificacion, String codigo) {
	
		this.oid=oid;
                this.tipoClasificacion = tipoClasificacion;
                this.codigo = codigo;
	
	}

	@Id
	@Column(name="OID_CLAS")
	private Long oid;
	@Column(name="TCCL_OID_TIPO_CLAS")
	private Long tipoClasificacion;
	@Column(name="COD_CLAS")
	private String codigo;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public Long getTipoClasificacion() {return tipoClasificacion;}
      
	public void setTipoClasificacion(Long tipoClasificacion){this.tipoClasificacion=tipoClasificacion;}
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
			
	
}
