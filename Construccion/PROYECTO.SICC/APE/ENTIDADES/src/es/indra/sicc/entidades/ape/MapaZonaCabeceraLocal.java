package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_MAPA_ZONA_CABEC")
@NamedQueries({
@NamedQuery(name="MapaZonaCabeceraLocal.FindAll",query="select object(o) from MapaZonaCabeceraLocal o")
})
public class MapaZonaCabeceraLocal implements Serializable {

    public MapaZonaCabeceraLocal() {}

    public MapaZonaCabeceraLocal(Long oid, Boolean valDefe, Long mcdcOidMapaCentDistCabe)	{
        this.oid=oid;
        this.setValorDefecto(valDefe);
        this.setMapaCentroDistribucionCabecera(mcdcOidMapaCentDistCabe);
    }

    @Id
    @Column(name="OID_MAPA_ZONA_CABE")
    private Long oid;
    @Column(name="COD_MAPA_ZONA")
    private Long codigoMapaZonas;
    @Column(name="VAL_DEFE")
    private Boolean valorDefecto;
    @Column(name="MCDC_OID_MAPA_CENT_DIST_CABE")
    private Long mapaCentroDistribucionCabecera;

    
    public Long getOid() {return oid;}
    
    public Long getCodigoMapaZonas() {return codigoMapaZonas;}
  
    public void setCodigoMapaZonas(Long codigoMapaZonas){this.codigoMapaZonas=codigoMapaZonas;}
            
    public Boolean getValorDefecto() {return valorDefecto;}
  
    public void setValorDefecto(Boolean valorDefecto){this.valorDefecto=valorDefecto;}
            
    public Long getMapaCentroDistribucionCabecera() {return mapaCentroDistribucionCabecera;}
  
    public void setMapaCentroDistribucionCabecera(Long mapaCentroDistribucionCabecera){this.mapaCentroDistribucionCabecera=mapaCentroDistribucionCabecera;}
                    
	
}
