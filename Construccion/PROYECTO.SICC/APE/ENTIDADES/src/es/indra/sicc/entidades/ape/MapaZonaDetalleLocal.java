package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_MAPA_ZONA_DETAL")
@NamedQueries({
@NamedQuery(name="MapaZonaDetalleLocal.FindAll",query="select object(o) from MapaZonaDetalleLocal o")
})
public class MapaZonaDetalleLocal implements Serializable {

    public MapaZonaDetalleLocal() {}

    public MapaZonaDetalleLocal(Long oid, Long numIdzo, Long numBahiDesd,
            Long numBahiHast, Long sbarOidSublArma, Long mzcaOidMapaZonaCabe) {
    
        this.oid=oid;
        this.setIdZona(numIdzo);
        this.setBahiaDesde(numBahiDesd);
        this.setBahiaHasta(numBahiHast);
        this.setSublineaArmado(sbarOidSublArma);
        this.setMapaZonaCabecera(mzcaOidMapaZonaCabe);
    }

    @Id
    @Column(name="OID_MAPA_ZONA_DETA")
    private Long oid;
    @Column(name="NUM_IDZO")
    private Long idZona;
    @Column(name="NUM_BAHI_DESD")
    private Long bahiaDesde;
    @Column(name="NUM_BAHI_HAST")
    private Long bahiaHasta;
    @Column(name="SBAR_OID_SUBL_ARMA")
    private Long sublineaArmado;
    @Column(name="MZCA_OID_MAPA_ZONA_CABE")
    private Long mapaZonaCabecera;

    
    public Long getOid() {return oid;}
    
    public Long getIdZona() {return idZona;}
  
    public void setIdZona(Long idZona){this.idZona=idZona;}
            
    public Long getBahiaDesde() {return bahiaDesde;}
  
    public void setBahiaDesde(Long bahiaDesde){this.bahiaDesde=bahiaDesde;}
            
    public Long getBahiaHasta() {return bahiaHasta;}
  
    public void setBahiaHasta(Long bahiaHasta){this.bahiaHasta=bahiaHasta;}
            
    public Long getSublineaArmado() {return sublineaArmado;}
  
    public void setSublineaArmado(Long sublineaArmado){this.sublineaArmado=sublineaArmado;}
            
    public Long getMapaZonaCabecera() {return mapaZonaCabecera;}
  
    public void setMapaZonaCabecera(Long mapaZonaCabecera){this.mapaZonaCabecera=mapaZonaCabecera;}
                    
	
}
