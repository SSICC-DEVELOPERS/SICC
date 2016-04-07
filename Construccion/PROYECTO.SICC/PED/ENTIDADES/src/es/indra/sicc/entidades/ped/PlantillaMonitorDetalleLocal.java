package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_PLANT_MONIT_DETAL")
@NamedQueries({
@NamedQuery(name="PlantillaMonitorDetalleLocal.FindAll", query="SELECT OBJECT(o) FROM PlantillaMonitorDetalleLocal AS o"),
@NamedQuery(name="PlantillaMonitorDetalleLocal.FindByPlantillaMonitor", query="SELECT OBJECT(o) "
+ " FROM PlantillaMonitorDetalleLocal AS o"
+ " WHERE o.plantilla = ?1")
})
public class PlantillaMonitorDetalleLocal implements Serializable {

    public PlantillaMonitorDetalleLocal() {}

    public PlantillaMonitorDetalleLocal(Long oid, Long num_secu, Long tspa_oid_tipo_soli_pais,
            Long zzon_oid_zona, Long plsm_oid_plan_moni, Long grpr_oid_grup_proc) {
            
        this.oid=oid;
        this.numSecuencia = num_secu;
        this.tipoSolicitud = tspa_oid_tipo_soli_pais;
        this.zona = zzon_oid_zona;
        this.plantilla = plsm_oid_plan_moni;
        this.grupoProcesos = grpr_oid_grup_proc;
    }

    @Id
    @Column(name="OID_PLAN_MONI_DETA")
    private Long oid;
    @Column(name="NUM_SECU")
    private Long numSecuencia;
    @Column(name="ZZON_OID_ZONA")
    private Long zona;
    @Column(name="TSPA_OID_TIPO_SOLI_PAIS")
    private Long tipoSolicitud;
    @Column(name="ZORG_OID_REGI")
    private Long region;
    @Column(name="GRPR_OID_GRUP_PROC")
    private Long grupoProcesos;
    @Column(name="PLSM_OID_PLAN_MONI")
    private Long plantilla;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getNumSecuencia() {return numSecuencia;}
  
    public void setNumSecuencia(Long numSecuencia){this.numSecuencia=numSecuencia;}
            
    public Long getZona() {return zona;}
  
    public void setZona(Long zona){this.zona=zona;}
            
    public Long getTipoSolicitud() {return tipoSolicitud;}
  
    public void setTipoSolicitud(Long tipoSolicitud){this.tipoSolicitud=tipoSolicitud;}
            
    public Long getRegion() {return region;}
  
    public void setRegion(Long region){this.region=region;}
            
    public Long getGrupoProcesos() {return grupoProcesos;}
  
    public void setGrupoProcesos(Long grupoProcesos){this.grupoProcesos=grupoProcesos;}
            
    public Long getPlantilla() {return plantilla;}
  
    public void setPlantilla(Long plantilla){this.plantilla=plantilla;}
			
	
}
