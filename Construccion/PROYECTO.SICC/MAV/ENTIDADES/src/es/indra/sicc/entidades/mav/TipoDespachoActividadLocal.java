package es.indra.sicc.entidades.mav;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="MAV_ACTIV_TIPO_DESPA")
@NamedQueries({
@NamedQuery(name="TipoDespachoActividadLocal.FindByOidActividad",query="SELECT OBJECT(a) "+
" FROM TipoDespachoActividadLocal AS a "+
" WHERE a.oidActividad = ?1") ,
@NamedQuery(name="TipoDespachoActividadLocal.FindByCampos",query="SELECT OBJECT(a) "+
" FROM TipoDespachoActividadLocal AS a "+
" WHERE a.oidTipoDespachoMAV = ?1 "+
" AND a.oidActividad = ?2 "+
" AND a.oidEnvioConSolicitud = ?3 ")
})
public class TipoDespachoActividadLocal implements Serializable {

	public TipoDespachoActividadLocal() {}

	public TipoDespachoActividadLocal(Long oid, Long oidActividad, Long oidTipoDespacho)	{
	
		this.oid=oid;
                this.oidActividad=oidActividad;
                this.oidTipoDespachoMAV=oidTipoDespacho;                
	
	}

	@Id
	@Column(name="OID_ACTI_TIPO_DESP")
	private Long oid;
	@Column(name="ACTI_OID_ACTI")
	private Long oidActividad;
	@Column(name="TDCH_OID_TIPO_DESP")
	private Long oidTipoDespachoMAV;
	@Column(name="ENVS_OID_ENVI_SOLI")
	private Long oidEnvioConSolicitud;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
		
	public Long getOidTipoDespachoMAV() {return oidTipoDespachoMAV;}
      
	public void setOidTipoDespachoMAV(Long oidTipoDespachoMAV){this.oidTipoDespachoMAV=oidTipoDespachoMAV;}
		
	public Long getOidEnvioConSolicitud() {return oidEnvioConSolicitud;}
      
	public void setOidEnvioConSolicitud(Long oidEnvioConSolicitud){this.oidEnvioConSolicitud=oidEnvioConSolicitud;}
			
	
}
