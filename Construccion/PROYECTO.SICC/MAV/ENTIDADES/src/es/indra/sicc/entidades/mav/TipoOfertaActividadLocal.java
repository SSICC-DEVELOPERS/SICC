package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_ACTIV_TIPO_OFERT")
@NamedQueries({
@NamedQuery(name="TipoOfertaActividadLocal.FindByOidActividad",query="SELECT OBJECT(a) "+
" FROM TipoOfertaActividadLocal AS a "+
" WHERE a.oidActividad = ?1 ")
})
public class TipoOfertaActividadLocal implements Serializable {

	public TipoOfertaActividadLocal() {}

	public TipoOfertaActividadLocal(Long oid, Long oidActividad, Long oidTipoOferta)	{
	
		this.oid=oid;
                this.oidActividad=oidActividad;
                this.oidTipoOferta=oidTipoOferta;                
	
	}

	@Id
	@Column(name="OID_TIPO_OFER_ACTI")
	private Long oid;
	@Column(name="ACTI_OID_ACTI")
	private Long oidActividad;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long oidTipoOferta;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
		
	public Long getOidTipoOferta() {return oidTipoOferta;}
      
	public void setOidTipoOferta(Long oidTipoOferta){this.oidTipoOferta=oidTipoOferta;}
			
	
}
