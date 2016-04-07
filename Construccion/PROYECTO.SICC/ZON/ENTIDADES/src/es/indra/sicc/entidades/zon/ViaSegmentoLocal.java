package es.indra.sicc.entidades.zon;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;

@Entity
@Table(name="ZON_VIA_SEGME")
@NamedQueries({
@NamedQuery(name="ViaSegmentoLocal.FindByViaSegmento",query="SELECT OBJECT(a) "
+ " FROM ViaSegmentoLocal AS a  "
+ " WHERE a.oidVia = ?1 "
+ " AND a.numViaSegmento = ?2 "
+ " AND a.activo = TRUE"),
@NamedQuery(name="ViaSegmentoLocal.FindByVia",query="SELECT OBJECT(a) "
+ " FROM ViaSegmentoLocal AS a  "
+ " WHERE a.oidVia = ?1 "
+ " AND a.activo = true"),
@NamedQuery(name="ViaSegmentoLocal.FindByTerritorioViaSegmento",query="SELECT OBJECT(a) "
+ " FROM ViaSegmentoLocal AS a  "
+ " WHERE a.oidTerritorio = ?1 "
+ " AND a.oidVia = ?2 "
+ " AND a.numViaSegmento = ?3 "
+ " AND a.activo = true"),
@NamedQuery(name="ViaSegmentoLocal.FindByTerritorioVia",query="SELECT OBJECT(a) "
+ " FROM ViaSegmentoLocal AS a  "
+ " WHERE a.oidTerritorio = ?1 "
+ " AND a.oidVia = ?2 "),
@NamedQuery(name="ViaSegmentoLocal.FindByTerritorioViaInicioFin",query="SELECT OBJECT(a) "
+ " FROM ViaSegmentoLocal AS a  "
+ " WHERE a.oidTerritorio = ?1 "
+ " AND a.oidVia = ?2 "
+ " AND a.numeroInicialSegmento = ?3 "
+ " AND a.numeroFinalSegmento = ?4"),
@NamedQuery(name="ViaSegmentoLocal.FindByViaActivos",query="SELECT OBJECT(a) "
+ " FROM ViaSegmentoLocal AS a  "
+ " WHERE a.oidVia = ?1 "
+ " AND a.activo = 1"),
@NamedQuery(name="ViaSegmentoLocal.FindAll",query="SELECT OBJECT(a) FROM ViaSegmentoLocal AS a")
})
public class ViaSegmentoLocal implements Serializable {

    public ViaSegmentoLocal() {}

    public ViaSegmentoLocal(Long oid, Long oidTerritorio, Long oidVia, Integer numViaSegmento, Timestamp fechaReestructuracion) {
        this.oid=oid;
        this.oidTerritorio = oidTerritorio;
        this.oidVia = oidVia;
        this.numViaSegmento = numViaSegmento;
        this.fechaReestructuracion = fechaReestructuracion;
    }

    @Column(name="IND_ACTI")
    private Boolean activo;
    @Column(name="LADO_SEGM")
    private Character lado;
    @Column(name="NUM_FIN_SEGM")
    private Integer numeroFinalSegmento;
    @Column(name="NUM_INIC_SEGM")
    private Integer numeroInicialSegmento;
    @Id
    @Column(name="OID_VIA_SEGM")
    private Long oid;
    @Column(name="TERR_OID_TERR")
    private Long oidTerritorio;
    @Column(name="VIA_OID_VIA")
    private Long oidVia;
    @Column(name="SENT_SEGM")
    private Character sentido;
    @Column(name="NUM_SECU_VIA_SEGM")
    private Integer numViaSegmento;
    @Column(name="FEC_REES")
    private java.sql.Timestamp fechaReestructuracion;

    
    public Boolean getActivo() {return activo;}
  
    public void setActivo(Boolean activo){this.activo=activo;}
            
    public Character getLado() {return lado;}
  
    public void setLado(Character lado){this.lado=lado;}
            
    public Integer getNumeroFinalSegmento() {return numeroFinalSegmento;}
  
    public void setNumeroFinalSegmento(Integer numeroFinalSegmento){this.numeroFinalSegmento=numeroFinalSegmento;}
            
    public Integer getNumeroInicialSegmento() {return numeroInicialSegmento;}
  
    public void setNumeroInicialSegmento(Integer numeroInicialSegmento){this.numeroInicialSegmento=numeroInicialSegmento;}
            
    public Long getOid() {return oid;}
    
    public Long getPrimaryKey() {return oid;}		
            
    public Long getOidTerritorio() {return oidTerritorio;}
  
    public void setOidTerritorio(Long oidTerritorio){this.oidTerritorio=oidTerritorio;}
            
    public Long getOidVia() {return oidVia;}
  
    public void setOidVia(Long oidVia){this.oidVia=oidVia;}
            
    public Character getSentido() {return sentido;}
  
    public void setSentido(Character sentido){this.sentido=sentido;}
            
    public Integer getNumViaSegmento() {return numViaSegmento;}
  
    public void setNumViaSegmento(Integer numViaSegmento){this.numViaSegmento=numViaSegmento;}
            
    public java.sql.Timestamp getFechaReestructuracion() {return fechaReestructuracion;}
  
    public void setFechaReestructuracion(java.sql.Timestamp fechaReestructuracion){this.fechaReestructuracion=fechaReestructuracion;}
                    
	
}
