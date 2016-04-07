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
@Table(name="CRA_PERIO")
@NamedQueries({
@NamedQuery(name="PeriodoLocal.FindByUk",query="SELECT OBJECT(a) "
+ " FROM PeriodoLocal AS a "
+ " WHERE a.oidPeriodoCorporativo = ?1 "
+ " AND a.oidMarca = ?2 "
+ " AND a.oidPais = ?3 "
+ " AND a.oidCanal = ?4 ")
})
public class PeriodoLocal implements Serializable {

	public PeriodoLocal() {}

	public PeriodoLocal(Long oid, Long cana_oid_cana, 
                         Long marc_oid_marc, Long pais_oid_pais, Long peri_oid_peri,
                         Date fec_inic, Date fec_fina, Boolean val_esta, 
                         String val_nomb_peri, Long acce_oid_acce)	{
	
		this.oid=oid;
                this.oidCanal = cana_oid_cana;
                this.oidMarca = marc_oid_marc;
                this.oidPais = pais_oid_pais;
                this.oidPeriodoCorporativo = peri_oid_peri;
                this.fechainicio = fec_inic;
                this.fechaFin = fec_fina;
                this.status = val_esta;
                this.nombrePeriodo = val_nomb_peri;
                this.oidAcceso = acce_oid_acce;
	}

	@Id
	@Column(name="OID_PERI")
	private Long oid;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="MARC_OID_MARC")
	private Long oidMarca;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="ACCE_OID_ACCE")
	private Long oidAcceso;
	@Column(name="PERI_OID_PERI")
	private Long oidPeriodoCorporativo;
	@Column(name="FEC_INIC")
	private java.sql.Date fechainicio;
	@Column(name="FEC_FINA")
	private java.sql.Date fechaFin;
	@Column(name="VAL_NOMB_PERI")
	private String nombrePeriodo;
	@Column(name="VAL_ESTA")
	private Boolean status;
	@Column(name="IND_PERI_CORT")
	private Boolean periodoCorto;
	@Column(name="IND_PERI_CRUC")
	private Boolean periodoCruce;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidAcceso() {return oidAcceso;}
      
	public void setOidAcceso(Long oidAcceso){this.oidAcceso=oidAcceso;}
		
	public Long getOidPeriodoCorporativo() {return oidPeriodoCorporativo;}
      
	public void setOidPeriodoCorporativo(Long oidPeriodoCorporativo){this.oidPeriodoCorporativo=oidPeriodoCorporativo;}
		
	public java.sql.Date getFechainicio() {return fechainicio;}
      
	public void setFechainicio(java.sql.Date fechainicio){this.fechainicio=fechainicio;}
		
	public java.sql.Date getFechaFin() {return fechaFin;}
      
	public void setFechaFin(java.sql.Date fechaFin){this.fechaFin=fechaFin;}
		
	public String getNombrePeriodo() {return nombrePeriodo;}
      
	public void setNombrePeriodo(String nombrePeriodo){this.nombrePeriodo=nombrePeriodo;}
		
	public Boolean getStatus() {return status;}
      
	public void setStatus(Boolean status){this.status=status;}
		
	public Boolean getPeriodoCorto() {return periodoCorto;}
      
	public void setPeriodoCorto(Boolean periodoCorto){this.periodoCorto=periodoCorto;}
		
	public Boolean getPeriodoCruce() {return periodoCruce;}
      
	public void setPeriodoCruce(Boolean periodoCruce){this.periodoCruce=periodoCruce;}
			
	
}
