package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_FUENT_VENTAS_REAL")
@NamedQueries({
@NamedQuery(name="FuenteVentasRealLocal.FindAll",query="select object(o) from FuenteVentasRealLocal o"),
@NamedQuery(name="FuenteVentasRealLocal.FindByUK",query="SELECT OBJECT(a) FROM FuenteVentasRealLocal a WHERE a.pais = ?1 AND a.periodo = ?2 AND a.region = ?3 AND a.zona = ?4 AND a.territorio = ?5")
})
public class FuenteVentasRealLocal implements Serializable {

	public FuenteVentasRealLocal() {}

	public FuenteVentasRealLocal(Long oid, Long zona, Long pais, Long periodo, Long region, Long territorio) {
            this.oid=oid;
	    this.zona=zona;
	    this.pais=pais;
	    this.periodo=periodo;
	    this.region=region;
	    this.territorio=territorio;
	}

	@Id
	@Column(name="OID_FUEN_VENT_REAL")
	private Long oid;
	@Column(name="VAL_CENT")
	private String centro;
	@Column(name="VAL_ANIO_COME")
	private Integer annioComercial;
	@Column(name="NUM_ACTI_INIC")
	private Long activasIniciales;
	@Column(name="NUM_ACTI_FINA")
	private Long activasFinales;
	@Column(name="NUM_INGR")
	private Long ingresos;
	@Column(name="NUM_REIN")
	private Long reingresos;
	@Column(name="NUM_EGRE")
	private Long egresos;
	@Column(name="NUM_REZO_RECI")
	private Long rezonificadasRecibidas;
	@Column(name="NUM_REZO_ENTR")
	private Long rezonificadasEntregadas;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="ZORG_OID_REGI")
	private Long region;
	@Column(name="TERR_OID_TERR")
	private Long territorio;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCentro() {return centro;}
      
	public void setCentro(String centro){this.centro=centro;}
		
	public Integer getAnnioComercial() {return annioComercial;}
      
	public void setAnnioComercial(Integer annioComercial){this.annioComercial=annioComercial;}
		
	public Long getActivasIniciales() {return activasIniciales;}
      
	public void setActivasIniciales(Long activasIniciales){this.activasIniciales=activasIniciales;}
		
	public Long getActivasFinales() {return activasFinales;}
      
	public void setActivasFinales(Long activasFinales){this.activasFinales=activasFinales;}
		
	public Long getIngresos() {return ingresos;}
      
	public void setIngresos(Long ingresos){this.ingresos=ingresos;}
		
	public Long getReingresos() {return reingresos;}
      
	public void setReingresos(Long reingresos){this.reingresos=reingresos;}
		
	public Long getEgresos() {return egresos;}
      
	public void setEgresos(Long egresos){this.egresos=egresos;}
		
	public Long getRezonificadasRecibidas() {return rezonificadasRecibidas;}
      
	public void setRezonificadasRecibidas(Long rezonificadasRecibidas){this.rezonificadasRecibidas=rezonificadasRecibidas;}
		
	public Long getRezonificadasEntregadas() {return rezonificadasEntregadas;}
      
	public void setRezonificadasEntregadas(Long rezonificadasEntregadas){this.rezonificadasEntregadas=rezonificadasEntregadas;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getRegion() {return region;}
      
	public void setRegion(Long region){this.region=region;}
		
	public Long getTerritorio() {return territorio;}
      
	public void setTerritorio(Long territorio){this.territorio=territorio;}
			
	
}
