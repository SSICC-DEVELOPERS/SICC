package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_MAPA_CENTR_DISTR_CABEC")
@NamedQueries({
@NamedQuery(name="MapaCentroDistribucionCabeceraLocal.FindAll",query="select object(o) from MapaCentroDistribucionCabeceraLocal o")
})
public class MapaCentroDistribucionCabeceraLocal implements Serializable {

    public MapaCentroDistribucionCabeceraLocal() {}

    public MapaCentroDistribucionCabeceraLocal(Long oid, Long codigoMapa, Long oidConfiguracionCD) {
        this.oid = oid;
        this.setCodigoMapa(codigoMapa);
        this.setConfiguracionCentroDistribucion(oidConfiguracionCD);
    }

    @Id
    @Column(name="OID_MAPA_CENT_DIST_CABE")
    private Long oid;
    @Column(name="NUM_CODI_MAPA")
    private Long codigoMapa;
    @Column(name="CCDI_OID_CONF_CENT_DIST")
    private Long configuracionCentroDistribucion;

    
    public Long getOid() {return oid;}
    
    public Long getCodigoMapa() {return codigoMapa;}
  
    public void setCodigoMapa(Long codigoMapa){this.codigoMapa=codigoMapa;}
            
    public Long getConfiguracionCentroDistribucion() {return configuracionCentroDistribucion;}
  
    public void setConfiguracionCentroDistribucion(Long configuracionCentroDistribucion){this.configuracionCentroDistribucion=configuracionCentroDistribucion;}
                    
	
}
