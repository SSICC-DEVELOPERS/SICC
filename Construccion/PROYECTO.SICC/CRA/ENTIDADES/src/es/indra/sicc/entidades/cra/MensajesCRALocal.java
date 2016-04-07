package es.indra.sicc.entidades.cra;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="CRA_MENSA")
@NamedQueries({
@NamedQuery(name="MensajesCRALocal.FindByPeriodo",query="SELECT OBJECT(m) FROM MensajesCRALocal AS m"
+ " WHERE m.oidPeriodo = ?1 ")
})
public class MensajesCRALocal implements Serializable {

	public MensajesCRALocal() {}

	public MensajesCRALocal(Long oid, Long clie_oid_clie, Long zona,
                          Long num_mens, Date fec_mens,
                          Long actividad, Long periodo)	{
	
		this.oid=oid;
                this.oidCodigoConsultora = clie_oid_clie;
                this.oidZona = zona;
                this.numMensaje = num_mens;
                this.fecha = fec_mens;
                this.oidActividad = actividad;
                this.oidPeriodo = periodo;
	}

	@Id
	@Column(name="OID_MENS_CRA")
	private Long oid;
	@Column(name="CLIE_OID_CLIE")
	private Long oidCodigoConsultora;
	@Column(name="ZSCC_OID_SECC")
	private Long oidSeccion;
	@Column(name="NUM_MENS")
	private Long numMensaje;
	@Column(name="FEC_MENS")
	private java.sql.Date fecha;
	@Column(name="CACT_OID_ACTI")
	private Long oidActividad;
	@Column(name="PERD_OID_PERI")
	private Long oidPeriodo;
	@Column(name="ZZON_OID_ZONA")
	private Long oidZona;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidCodigoConsultora() {return oidCodigoConsultora;}
      
	public void setOidCodigoConsultora(Long oidCodigoConsultora){this.oidCodigoConsultora=oidCodigoConsultora;}
		
	public Long getOidSeccion() {return oidSeccion;}
      
	public void setOidSeccion(Long oidSeccion){this.oidSeccion=oidSeccion;}
		
	public Long getNumMensaje() {return numMensaje;}
      
	public void setNumMensaje(Long numMensaje){this.numMensaje=numMensaje;}
		
	public java.sql.Date getFecha() {return fecha;}
      
	public void setFecha(java.sql.Date fecha){this.fecha=fecha;}
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
		
	public Long getOidPeriodo() {return oidPeriodo;}
      
	public void setOidPeriodo(Long oidPeriodo){this.oidPeriodo=oidPeriodo;}
		
	public Long getOidZona() {return oidZona;}
      
	public void setOidZona(Long oidZona){this.oidZona=oidZona;}
			
	
}
