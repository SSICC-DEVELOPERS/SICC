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
@Table(name="CRA_FERIA")
public class FeriadoLocal implements Serializable {

	public FeriadoLocal() {}

	public FeriadoLocal(Long oid, Long cgzo_oid_cabe_grup_zona, 
                      Long cact_oid_acti, Integer num_anio, 
                      Date fec_feri, Boolean ind_fest)	{
	
		this.oid=oid;
                this.oidGrupoZona = cgzo_oid_cabe_grup_zona;
                this.oidActividad = cact_oid_acti;
                this.anyo = num_anio;
                this.fechaFeriado = fec_feri;
                this.inFestivo = ind_fest;
	}

	@Id
	@Column(name="OID_FERI")
	private Long oid;
	@Column(name="CGZO_OID_CABE_GRUP_ZONA")
	private Long oidGrupoZona;
	@Column(name="CACT_OID_ACTI")
	private Long oidActividad;
	@Column(name="NUM_ANIO")
	private Integer anyo;
	@Column(name="FEC_FERI")
	private  java.sql.Date fechaFeriado;
	@Column(name="IND_FEST")
	private Boolean inFestivo;
	@Column(name="IND_NO_LABO")
	private Boolean inNoLaborable;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidGrupoZona() {return oidGrupoZona;}
      
	public void setOidGrupoZona(Long oidGrupoZona){this.oidGrupoZona=oidGrupoZona;}
		
	public Long getOidActividad() {return oidActividad;}
      
	public void setOidActividad(Long oidActividad){this.oidActividad=oidActividad;}
		
	public Integer getAnyo() {return anyo;}
      
	public void setAnyo(Integer anyo){this.anyo=anyo;}
		
	public  java.sql.Date getFechaFeriado() {return fechaFeriado;}
      
	public void setFechaFeriado( java.sql.Date fechaFeriado){this.fechaFeriado=fechaFeriado;}
		
	public Boolean getInFestivo() {return inFestivo;}
      
	public void setInFestivo(Boolean inFestivo){this.inFestivo=inFestivo;}
		
	public Boolean getInNoLaborable() {return inNoLaborable;}
      
	public void setInNoLaborable(Boolean inNoLaborable){this.inNoLaborable=inNoLaborable;}
			
	
}
