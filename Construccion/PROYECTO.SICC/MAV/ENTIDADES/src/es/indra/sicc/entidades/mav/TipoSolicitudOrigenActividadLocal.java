package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_ACTIV_TIPO_SOLIC")
@NamedQueries({
@NamedQuery(name="TipoSolicitudOrigenActividadLocal.FindByOidActividad",query="SELECT OBJECT(a) "+
" FROM TipoSolicitudOrigenActividadLocal AS a "+
" WHERE a.oidActividad = ?1")
})
public class TipoSolicitudOrigenActividadLocal implements Serializable {

	public TipoSolicitudOrigenActividadLocal() {}

	public TipoSolicitudOrigenActividadLocal(Long oid, Long oidActividad, Long oidTipoSolicitudPais)	{
	
		this.oid=oid;
                this.oidActividad=oidActividad;
                this.oidTiposSolicitudPais=oidTipoSolicitudPais;                
	
	}

	@Id
	@Column(name="OID_TIPO_SOLI_ORIG")
	private Long oid;
	@Column(name="ACTI_OID_ACTI")
	private Long oidActividad;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS")
	private Long oidTiposSolicitudPais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
		
	public Long getOidTiposSolicitudPais() {return oidTiposSolicitudPais;}
      
	public void setOidTiposSolicitudPais(Long oidTiposSolicitudPais){this.oidTiposSolicitudPais=oidTiposSolicitudPais;}
			
	
}
