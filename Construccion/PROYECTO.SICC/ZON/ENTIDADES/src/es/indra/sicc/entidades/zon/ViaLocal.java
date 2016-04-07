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
@Table(name="ZON_VIA")
@NamedQueries({
@NamedQuery(name="ViaLocal.FindByPaisSecuencial",query="SELECT OBJECT(a) "
+ " FROM ViaLocal AS a "
+ " WHERE a.oidPais = ?1 "
+ " AND a.secuencial = ?2 "
+ " AND a.activo = TRUE"),
@NamedQuery(name="ViaLocal.FindByPaisNombreTipoViaActivas", query="SELECT OBJECT(a)"
+ " FROM ViaLocal AS a "
+ " WHERE a.nombre = ?1 and a.oidTipoVia = ?2 and a.oidPais = ?3 and a.activo = ?4"),
//findByPaisNombreTipoVia
@NamedQuery(name="ViaLocal.FindByPaisNombreTipoVia", query="SELECT OBJECT(a)"
+ " FROM ViaLocal AS a "
+ " WHERE a.nombre = ?1 and a.oidTipoVia = ?2 and a.oidPais = ?3"),
@NamedQuery(name="ViaLocal.FindAll", query="SELECT OBJECT(a) FROM ViaLocal AS a ")
})
public class ViaLocal implements Serializable {

    public ViaLocal() {}

    public ViaLocal(Long oid, Boolean activo, Long oidPais, String nombre, Integer secuencia) {
        this.oid=oid;
        this.activo = activo;
        this.oidPais = oidPais;
        this.nombre = nombre;
        this.secuencial = secuencia;
    }

    @Id
    @Column(name="OID_VIA")
    private Long oid;
    @Column(name="IND_ACTI_VIA")
    private Boolean activo;
    @Column(name="NOM_VIA")
    private String nombre;
    @Column(name="PAIS_OID_PAIS")
    private Long oidPais;
    @Column(name="TIVI_OID_TIPO_VIA")
    private Long oidTipoVia;
    @Column(name="FEC_REES")
    private Timestamp fechaReestructuracion;
    @Column(name="COD_VIA")
    private Integer secuencial;

    
    public Long getOid() {return oid;}
  
    public Long getPrimaryKey() {return oid;}		
            
    public Boolean getActivo() {return activo;}
  
    public void setActivo(Boolean activo){this.activo=activo;}
            
    public String getNombre() {return nombre;}
  
    public void setNombre(String nombre){this.nombre=nombre;}
            
    public Long getOidPais() {return oidPais;}
  
    public void setOidPais(Long oidPais){this.oidPais=oidPais;}
            
    public Long getOidTipoVia() {return oidTipoVia;}
  
    public void setOidTipoVia(Long oidTipoVia){this.oidTipoVia=oidTipoVia;}
            
    public Timestamp getFechaReestructuracion() {return fechaReestructuracion;}
  
    public void setFechaReestructuracion(Timestamp fechaReestructuracion){this.fechaReestructuracion=fechaReestructuracion;}
            
    public Integer getSecuencial() {return secuencial;}
  
    public void setSecuencial(Integer secuencial){this.secuencial=secuencial;}
                    
	
}
