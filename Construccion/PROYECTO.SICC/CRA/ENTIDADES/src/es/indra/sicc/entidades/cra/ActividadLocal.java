package es.indra.sicc.entidades.cra;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CRA_ACTIV")
@NamedQueries({
@NamedQuery(name="ActividadLocal.FindByClaseActividad",query="SELECT OBJECT(m) "
+ " FROM ActividadLocal AS m " 
+ " WHERE m.clasificacionActividad = ?1 "),
@NamedQuery(name="ActividadLocal.findReferenciantes",query="SELECT OBJECT(m) "
+ " FROM ActividadLocal AS m "
+ " WHERE m.oidActividadOrigen = ?1 ")
})

public class ActividadLocal implements Serializable {

	public ActividadLocal() {}

	public ActividadLocal(Long oid, Long marc_oid_marc, Long cana_oid_cana, Long dpte_oid_depa, 
                          String cod_acti, Integer cod_tipo_acti, 
                          Boolean ind_ebel, Long clasificacion, Long pais) {
	
		this.oid=oid;
                this.oidMarca = marc_oid_marc;
                this.oidCanal = cana_oid_cana;
                this.oidDepartamento = dpte_oid_depa;
                this.codigoActividad = cod_acti;
                this.tipoActividad = cod_tipo_acti;
                this.ebelNoticias = ind_ebel;
                this.clasificacionActividad = clasificacion;
                this.oidPais = pais;
	}

	@Column(name="MARC_OID_MARC")
	private Long oidMarca;
	@Column(name="CANA_OID_CANA")
	private Long oidCanal;
	@Column(name="DPTE_OID_DEPA")
	private Long oidDepartamento;
	@Column(name="ACCE_OID_ACCE")
	private Long oidAcceso;
	@Id
	@Column(name="OID_ACTI")
	private Long oid;
	@Column(name="COD_ACTI")
	private String codigoActividad;
	@Column(name="CACT_OID_ACTI")
	private Long oidActividadOrigen;
	@Column(name="COD_TIPO_ACTI")
	private Integer tipoActividad;
	@Column(name="TIDC_OID_TIPO_DIRE")
	private Long tipoDireccion;
	@Column(name="NUM_DIAS_DESP")
	private Integer diasDesplazamiento;
	@Column(name="NUM_CAMP_ANTE")
	private Integer campanyaAntelacion;
	@Column(name="IND_EBEL")
	private Boolean ebelNoticias;
	@Column(name="IND_FEST")
	private Boolean inFestivo;
	@Column(name="IND_LABO")
	private Boolean inLaborables;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="CLAC_OID_CLAS_ACTI")
	private Long clasificacionActividad;
	@Column(name="NUM_CAMP_REFE")
	private Integer campanyasDesplazamiento;
        @Column(name="MENS_OID_MENS")
        private Long mensaje;

	
	public Long getOidMarca() {return oidMarca;}
      
	public void setOidMarca(Long oidMarca){this.oidMarca=oidMarca;}
		
	public Long getOidCanal() {return oidCanal;}
      
	public void setOidCanal(Long oidCanal){this.oidCanal=oidCanal;}
		
	public Long getOidDepartamento() {return oidDepartamento;}
      
	public void setOidDepartamento(Long oidDepartamento){this.oidDepartamento=oidDepartamento;}
		
	public Long getOidAcceso() {return oidAcceso;}
      
	public void setOidAcceso(Long oidAcceso){this.oidAcceso=oidAcceso;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoActividad() {return codigoActividad;}
      
	public void setCodigoActividad(String codigoActividad){this.codigoActividad=codigoActividad;}
		
	public Long getOidActividadOrigen() {return oidActividadOrigen;}
      
	public void setOidActividadOrigen(Long oidActividadOrigen){this.oidActividadOrigen=oidActividadOrigen;}
		
	public Integer getTipoActividad() {return tipoActividad;}
      
	public void setTipoActividad(Integer tipoActividad){this.tipoActividad=tipoActividad;}
		
	public Long getTipoDireccion() {return tipoDireccion;}
      
	public void setTipoDireccion(Long tipoDireccion){this.tipoDireccion=tipoDireccion;}
		
	public Integer getDiasDesplazamiento() {return diasDesplazamiento;}
      
	public void setDiasDesplazamiento(Integer diasDesplazamiento){this.diasDesplazamiento=diasDesplazamiento;}
		
	public Integer getCampanyaAntelacion() {return campanyaAntelacion;}
      
	public void setCampanyaAntelacion(Integer campanyaAntelacion){this.campanyaAntelacion=campanyaAntelacion;}
		
	public Boolean getEbelNoticias() {return ebelNoticias;}
      
	public void setEbelNoticias(Boolean ebelNoticias){this.ebelNoticias=ebelNoticias;}
		
	public Boolean getInFestivo() {return inFestivo;}
      
	public void setInFestivo(Boolean inFestivo){this.inFestivo=inFestivo;}
		
	public Boolean getInLaborables() {return inLaborables;}
      
	public void setInLaborables(Boolean inLaborables){this.inLaborables=inLaborables;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getClasificacionActividad() {return clasificacionActividad;}
      
	public void setClasificacionActividad(Long clasificacionActividad){this.clasificacionActividad=clasificacionActividad;}
		
	public Integer getCampanyasDesplazamiento() {return campanyasDesplazamiento;}
      
	public void setCampanyasDesplazamiento(Integer campanyasDesplazamiento){this.campanyasDesplazamiento=campanyasDesplazamiento;}
    
        public Long getMensaje() {return mensaje;}
    
        public void setMensaje(Long mensaje){this.mensaje=mensaje;}		
	
}
