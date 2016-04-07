package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.io.Serializable;

@Entity
@Table(name="CAL_DETAL_BUZON")
@NamedQueries({
 @NamedQuery(name="DetalleBuzonLocal.FindAll",query="SELECT OBJECT(a) FROM DetalleBuzonLocal AS a")
})
public class DetalleBuzonLocal implements Serializable {

	public DetalleBuzonLocal() {}

	public DetalleBuzonLocal(Long oid, Long cod_acti, String val_desc_acti, Timestamp fec_hora_crea, String cod_usua, Long cabu_oid, Long cont_oid, Long oid_estatus_actividad_contacto)	{
	
		this.oid=oid;
	        setDescripcionActividad(val_desc_acti);
	        setFechaHoraCreacion(fec_hora_crea);
	        setCodUsuario(cod_usua);
	        setOidCabeceraBuzon(cabu_oid);
	        setOidContacto(cont_oid);
	        setEstatusActividad(oid_estatus_actividad_contacto);
	        setCodActividad(cod_acti);
	
	}

	@Id
	@Column(name="OID_DETA_BUZO")
	private Long oid;
	@Column(name="COD_ACTI")
	private Long codActividad;
	@Column(name="VAL_DESC_ACTI")
	private String descripcionActividad;
	@Column(name="FEC_HORA_CREA")
	private java.sql.Timestamp fechaHoraCreacion;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="COD_USUA")
	private String codUsuario;
	@Column(name="CABU_OID_CABE_BUZO")
	private Long oidCabeceraBuzon;
	@Column(name="CONT_OID_CONT")
	private Long oidContacto;
	@Column(name="TGCL_OID_TIPO_GEST_CLIE")
	private Long oidTipoGestion;
	@Column(name="ESAC_OID_ESTA_ACTI_CONT")
	private Long estatusActividad;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCodActividad() {return codActividad;}
      
	public void setCodActividad(Long codActividad){this.codActividad=codActividad;}
		
	public String getDescripcionActividad() {return descripcionActividad;}
      
	public void setDescripcionActividad(String descripcionActividad){this.descripcionActividad=descripcionActividad;}
		
	public java.sql.Timestamp getFechaHoraCreacion() {return fechaHoraCreacion;}
      
	public void setFechaHoraCreacion(java.sql.Timestamp fechaHoraCreacion){this.fechaHoraCreacion=fechaHoraCreacion;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public String getCodUsuario() {return codUsuario;}
      
	public void setCodUsuario(String codUsuario){this.codUsuario=codUsuario;}
		
	public Long getOidCabeceraBuzon() {return oidCabeceraBuzon;}
      
	public void setOidCabeceraBuzon(Long oidCabeceraBuzon){this.oidCabeceraBuzon=oidCabeceraBuzon;}
		
	public Long getOidContacto() {return oidContacto;}
      
	public void setOidContacto(Long oidContacto){this.oidContacto=oidContacto;}
		
	public Long getOidTipoGestion() {return oidTipoGestion;}
      
	public void setOidTipoGestion(Long oidTipoGestion){this.oidTipoGestion=oidTipoGestion;}
		
	public Long getEstatusActividad() {return estatusActividad;}
      
	public void setEstatusActividad(Long estatusActividad){this.estatusActividad=estatusActividad;}
			
	
}
