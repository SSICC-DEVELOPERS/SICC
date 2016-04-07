package es.indra.sicc.entidades.cra;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CRA_MATRI_DIAS")
@NamedQueries({
@NamedQuery(name= "MatrizDiasLocal.FindByActividadGrupo",query="SELECT OBJECT(md) "
+ " FROM MatrizDiasLocal AS md "
+ " WHERE md.actividad = ?1 "
+ " AND md.grupoZona = ?2")
})
public class MatrizDiasLocal implements Serializable {

	public MatrizDiasLocal() {}

	public MatrizDiasLocal(Long oid, Long cgzo_oid_cabe_grup_zona, Long cact_oid_acti, 
                                Long num_dias_refe)	{
	
		this.oid=oid;
                this.grupoZona = cgzo_oid_cabe_grup_zona;
                this.actividad = cact_oid_acti;
                this.dias = num_dias_refe;
	}

	@Id
	@Column(name="OID_MATR_DIAS")
	private Long oid;
	@Column(name="CGZO_OID_CABE_GRUP_ZONA")
	private Long grupoZona;
	@Column(name="CACT_OID_ACTI")
	private Long actividad;
	@Column(name="NUM_DIAS_REFE")
	private Long dias;
	@Column(name="NUM_DIAS_FINA")
	private Long diasFinal;
	@Column(name="NUM_DIAS_INTE")
	private Long diasIntervalo;
	@Column(name="CACT_OID_ACTI_ORIG")
	private Long actividadOrigen;
	@Column(name="NUM_CAMP_REFE")
	private Integer campDesplazamiento;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getGrupoZona() {return grupoZona;}
      
	public void setGrupoZona(Long grupoZona){this.grupoZona=grupoZona;}
		
	public Long getActividad() {return actividad;}
      
	public void setActividad(Long actividad){this.actividad=actividad;}
		
	public Long getDias() {return dias;}
      
	public void setDias(Long dias){this.dias=dias;}
		
	public Long getDiasFinal() {return diasFinal;}
      
	public void setDiasFinal(Long diasFinal){this.diasFinal=diasFinal;}
		
	public Long getDiasIntervalo() {return diasIntervalo;}
      
	public void setDiasIntervalo(Long diasIntervalo){this.diasIntervalo=diasIntervalo;}
		
	public Long getActividadOrigen() {return actividadOrigen;}
      
	public void setActividadOrigen(Long actividadOrigen){this.actividadOrigen=actividadOrigen;}
		
	public Integer getCampDesplazamiento() {return campDesplazamiento;}
      
	public void setCampDesplazamiento(Integer campDesplazamiento){this.campDesplazamiento=campDesplazamiento;}
			
	
}
