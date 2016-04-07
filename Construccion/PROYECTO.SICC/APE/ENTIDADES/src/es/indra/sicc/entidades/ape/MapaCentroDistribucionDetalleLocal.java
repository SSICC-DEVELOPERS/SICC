package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_MAPA_CENTR_DISTR_DETAL")
@NamedQueries({
@NamedQuery(name="MapaCentroDistribucionDetalleLocal.FindAll",query="select object(o) from MapaCentroDistribucionDetalleLocal o"),
@NamedQuery(name="MapaCentroDistribucionDetalleLocal.FindByUK",query="select object(o) from MapaCentroDistribucionDetalleLocal o "
+ " where o.numeroAnaquel = ?1 and o.mapaCentroDistribucionCabecera = ?2")
})
public class MapaCentroDistribucionDetalleLocal implements Serializable {

    public MapaCentroDistribucionDetalleLocal() {}

    public MapaCentroDistribucionDetalleLocal(Long oid, String codAnaquel,
            Long capacidadAnaquel, Long oidMapaCDCabec, Long oidSublinea, Boolean expandido) {
            
        this.oid = oid;
        this.setNumeroAnaquel(codAnaquel);
        this.setCapacidad(capacidadAnaquel);
        this.setMapaCentroDistribucionCabecera(oidMapaCDCabec);
        this.setSublineaArmado(oidSublinea);
        this.setExpandido(expandido);
    }

    @Id
    @Column(name="OID_MAPA_CENT_DIST_DETA")
    private Long oid;
    @Column(name="NUM_ANAQ")
    private String numeroAnaquel;
    @Column(name="NUM_CAPA")
    private Long capacidad;
    @Column(name="IND_EXPA")
    private Boolean expandido;
    @Column(name="MCDC_OID_MAPA_CENT_DIST_CABE")
    private Long mapaCentroDistribucionCabecera;
    @Column(name="MCDD_OID_MAPA_CENT_DIST_DETA")
    private Long anaquelDestino;
    @Column(name="SBAR_OID_SUBL_ARMA")
    private Long sublineaArmado;

    
    public Long getOid() {return oid;}
    
    public String getNumeroAnaquel() {return numeroAnaquel;}
  
    public void setNumeroAnaquel(String numeroAnaquel){this.numeroAnaquel=numeroAnaquel;}
            
    public Long getCapacidad() {return capacidad;}
  
    public void setCapacidad(Long capacidad){this.capacidad=capacidad;}
            
    public Boolean getExpandido() {return expandido;}
  
    public void setExpandido(Boolean expandido){this.expandido=expandido;}
            
    public Long getMapaCentroDistribucionCabecera() {return mapaCentroDistribucionCabecera;}
  
    public void setMapaCentroDistribucionCabecera(Long mapaCentroDistribucionCabecera){this.mapaCentroDistribucionCabecera=mapaCentroDistribucionCabecera;}
            
    public Long getAnaquelDestino() {return anaquelDestino;}
  
    public void setAnaquelDestino(Long anaquelDestino){this.anaquelDestino=anaquelDestino;}
            
    public Long getSublineaArmado() {return sublineaArmado;}
  
    public void setSublineaArmado(Long sublineaArmado){this.sublineaArmado=sublineaArmado;}
			
	
}
