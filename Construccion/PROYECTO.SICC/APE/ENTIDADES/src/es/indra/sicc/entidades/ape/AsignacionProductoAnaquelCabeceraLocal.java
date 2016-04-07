package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_ASIGN_PRODU_ANAQU_CABEC")
@NamedQueries({
@NamedQuery(name="AsignacionProductoAnaquelCabeceraLocal.FindAll",query="select object(o) from AsignacionProductoAnaquelCabeceraLocal o"),
@NamedQuery(name="AsignacionProductoAnaquelCabeceraLocal.FindByUk",query="select object(o) from AsignacionProductoAnaquelCabeceraLocal o "
+ " where o.mapaCentroDistribucionCabecera = ?1 and o.version = ?2 "
+ " and o.periodo = ?3"),
@NamedQuery(name="AsignacionProductoAnaquelCabeceraLocal.FindByActivoFacturacion",
    query="SELECT OBJECT(o) FROM AsignacionProductoAnaquelCabeceraLocal AS o WHERE o.activoFacturacion='S'"),
@NamedQuery(name="AsignacionProductoAnaquelCabeceraLocal.FindByMapaCDPeriodoActivoFacturacion",
    query="select object(o) from AsignacionProductoAnaquelCabeceraLocal o "
        + "where o.mapaCentroDistribucionCabecera = ?1 and o.periodo = ?2 and o.activoFacturacion = 'S'")
})
public class AsignacionProductoAnaquelCabeceraLocal implements Serializable {

	public AsignacionProductoAnaquelCabeceraLocal() {}

	public AsignacionProductoAnaquelCabeceraLocal(Long oid, String version,
                String indActivoFacturacion, Long oidPeriodo, Long oidMapaCDCabec, Long oidMapaZonaCabec) {
	
	    this.oid = oid;
	    this.setVersion(version);
	    this.setActivoFacturacion(indActivoFacturacion);
	    this.setPeriodo(oidPeriodo);
	    this.setMapaCentroDistribucionCabecera(oidMapaCDCabec);
	    this.setMapaZonaCabecera(oidMapaZonaCabec);
	}

	@Id
	@Column(name="OID_ASIG_PROD_ANAQ_CABE")
	private Long oid;
	@Column(name="VAL_VERS")
	private String version;
	@Column(name="IND_ACTI_FACT")
	private String activoFacturacion;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="MCDC_OID_MAPA_CENT_DIST_CABE")
	private Long mapaCentroDistribucionCabecera;
	@Column(name="MZCA_OID_MAPA_ZONA_CABE")
	private Long mapaZonaCabecera;

	
	public Long getOid() {return oid;}
      	
	public String getVersion() {return version;}
      
	public void setVersion(String version){this.version=version;}
		
	public String getActivoFacturacion() {return activoFacturacion;}
      
	public void setActivoFacturacion(String activoFacturacion){this.activoFacturacion=activoFacturacion;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getMapaCentroDistribucionCabecera() {return mapaCentroDistribucionCabecera;}
      
	public void setMapaCentroDistribucionCabecera(Long mapaCentroDistribucionCabecera){this.mapaCentroDistribucionCabecera=mapaCentroDistribucionCabecera;}
		
	public Long getMapaZonaCabecera() {return mapaZonaCabecera;}
      
	public void setMapaZonaCabecera(Long mapaZonaCabecera){this.mapaZonaCabecera=mapaZonaCabecera;}
			
	
}
