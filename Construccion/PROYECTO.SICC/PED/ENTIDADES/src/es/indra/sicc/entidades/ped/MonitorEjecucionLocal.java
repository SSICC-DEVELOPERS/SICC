package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_MONIT_EJECU")
@NamedQueries({
@NamedQuery(name="MonitorEjecucionLocal.FindAll",query="select object(o) from MonitorEjecucionLocal o"),
@NamedQuery(name="MonitorEjecucionLocal.FindByUK",query="SELECT OBJECT(a) "
+ " FROM MonitorEjecucionLocal AS a "
+ " WHERE a.solicitudPais = ?1 AND "
+ " a.zona = ?2 AND "
+ " a.grupoProcroceso = ?3")
})
public class MonitorEjecucionLocal implements Serializable {

    public MonitorEjecucionLocal() {}

    public MonitorEjecucionLocal(Long oid, Long valTipoSoliPais, Long valGrupProc, Long valZona, String codProc)	{
        this.oid=oid;
        this.solicitudPais = valTipoSoliPais;
        this.grupoProcroceso = valGrupProc;
        this.zona = valZona;
        this.codProceso = codProc;
    }

    @Id
    @Column(name="OID_MONI_EJEC")
    private Long oid;
    @Column(name="VAL_TIPO_SOLI_PAIS")
    private Long solicitudPais;
    @Column(name="VAL_GRUP_PROC")
    private Long grupoProcroceso;
    @Column(name="VAL_ZONA")
    private Long zona;
    @Column(name="COD_PROC")
    private String codProceso;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getSolicitudPais() {return solicitudPais;}
  
    public void setSolicitudPais(Long solicitudPais){this.solicitudPais=solicitudPais;}
            
    public Long getGrupoProcroceso() {return grupoProcroceso;}
  
    public void setGrupoProcroceso(Long grupoProcroceso){this.grupoProcroceso=grupoProcroceso;}
            
    public Long getZona() {return zona;}
  
    public void setZona(Long zona){this.zona=zona;}
            
    public String getCodProceso() {return codProceso;}
  
    public void setCodProceso(String codProceso){this.codProceso=codProceso;}
                    
}
