package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PED_SOLIC_CABEC_SECUE")
@NamedQueries({
@NamedQuery(name="SolicitudCabeceraSecuenciaLocal.FindAll",query="SELECT OBJECT(p) from SolicitudCabeceraSecuenciaLocal p")
})
public class SolicitudCabeceraSecuenciaLocal implements Serializable {

    public SolicitudCabeceraSecuenciaLocal() {}

    public SolicitudCabeceraSecuenciaLocal(Long oid)	{
        this.oid=oid;
    }

    @Id
    @Column(name="SOCA_OID_SOLI_CABE")
    private Long oid;
    @Column(name="RUTR_OID_RUTA_TRAN")
    private Long ruta;
    @Column(name="NUM_SECU_FACT_DIAR")
    private Long numSecuenciaFacturacionDiaria;
    @Column(name="VAL_SECU_RUTA_TERR")
    private String secuenciaRutaTerritorio;
    @Column(name="NUM_SECU_ZONA_RUTA")
    private Long numSecuenciaZonasRutas;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Long getRuta() {return ruta;}
  
    public void setRuta(Long ruta){this.ruta=ruta;}
            
    public Long getNumSecuenciaFacturacionDiaria() {return numSecuenciaFacturacionDiaria;}
  
    public void setNumSecuenciaFacturacionDiaria(Long numSecuenciaFacturacionDiaria){this.numSecuenciaFacturacionDiaria=numSecuenciaFacturacionDiaria;}
            
    public String getSecuenciaRutaTerritorio() {return secuenciaRutaTerritorio;}
  
    public void setSecuenciaRutaTerritorio(String secuenciaRutaTerritorio){this.secuenciaRutaTerritorio=secuenciaRutaTerritorio;}
            
    public Long getNumSecuenciaZonasRutas() {return numSecuenciaZonasRutas;}
  
    public void setNumSecuenciaZonasRutas(Long numSecuenciaZonasRutas){this.numSecuenciaZonasRutas=numSecuenciaZonasRutas;}
	
}
