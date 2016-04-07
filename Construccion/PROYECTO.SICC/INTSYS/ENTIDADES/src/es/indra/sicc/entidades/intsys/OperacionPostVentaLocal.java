package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_OPERA_POSTV_IVR")
@NamedQueries({
@NamedQuery(name="OperacionPostVentaLocal.FindAll",query="select object(o) from OperacionPostVentaLocal o")
})
public class OperacionPostVentaLocal implements Serializable {

	public OperacionPostVentaLocal() {}

	public OperacionPostVentaLocal(Long oid, String codigo, String descripcion)	{
            this.oid=oid;
	    this.codigo=codigo;
	    this.descripcion=descripcion;
	}

	@Id
	@Column(name="OID_OPER_POST_VENT_IVR")
	private Long oid;
	@Column(name="COD_OPER_POST_VENT_IVR")
	private String codigo;
	@Column(name="VAL_DESC")
	private String descripcion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
			
	
}
