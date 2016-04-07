package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="INC_BOLSA_FALTA")
@NamedQueries({
@NamedQuery(name="BolsaFantantesLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM BolsaFantantesLocal AS a "
+ " WHERE a.oidSolicitudPosicion = ?1"),
@NamedQuery(name="BolsaFantantesLocal.FindAll",query="select object(o) from BolsaFantantesLocal o")
})
public class BolsaFantantesLocal implements Serializable {

	public BolsaFantantesLocal() {}

	public BolsaFantantesLocal(Long oid, Long num_unid_falt, Timestamp fec_alta, Long sopo_oid_soli_posi)	{
	
		this.oid=oid;
	        this.setNumeroUnidadesFaltantes(num_unid_falt);
	        this.setFechaAlta(fec_alta);
	        this.setOidSolicitudPosicion(sopo_oid_soli_posi);
	
	}

	@Id
	@Column(name="OID_BOLS_FALT")
	private Long oid;
	@Column(name="NUM_UNID_FALT")
	private Long numeroUnidadesFaltantes;
	@Column(name="FEC_ALTA")
	private java.sql.Timestamp fechaAlta;
	@Column(name="FEC_SOLU")
	private java.sql.Timestamp fechaSolucion;
	@Column(name="VAL_OBSE")
	private String valObser;
	@Column(name="SOPO_OID_SOLI_POSI")
	private Long oidSolicitudPosicion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNumeroUnidadesFaltantes() {return numeroUnidadesFaltantes;}
      
	public void setNumeroUnidadesFaltantes(Long numeroUnidadesFaltantes){this.numeroUnidadesFaltantes=numeroUnidadesFaltantes;}
		
	public java.sql.Timestamp getFechaAlta() {return fechaAlta;}
      
	public void setFechaAlta(java.sql.Timestamp fechaAlta){this.fechaAlta=fechaAlta;}
		
	public java.sql.Timestamp getFechaSolucion() {return fechaSolucion;}
      
	public void setFechaSolucion(java.sql.Timestamp fechaSolucion){this.fechaSolucion=fechaSolucion;}
		
	public String getValObser() {return valObser;}
      
	public void setValObser(String valObser){this.valObser=valObser;}
		
	public Long getOidSolicitudPosicion() {return oidSolicitudPosicion;}
      
	public void setOidSolicitudPosicion(Long oidSolicitudPosicion){this.oidSolicitudPosicion=oidSolicitudPosicion;}
			
	
}
