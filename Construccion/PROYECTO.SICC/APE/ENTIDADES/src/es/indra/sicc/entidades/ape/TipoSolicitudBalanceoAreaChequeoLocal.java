package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_TIPOS_SOLIC_BALA_AREA_CHEQ")
@NamedQueries({
@NamedQuery(name="TipoSolicitudBalanceoAreaChequeoLocal.FindAll",query="select object(o) from TipoSolicitudBalanceoAreaChequeoLocal o"),
@NamedQuery(name="TipoSolicitudBalanceoAreaChequeoLocal.FindByParametros",query="select object(o) from TipoSolicitudBalanceoAreaChequeoLocal o where o.parametrosBalanceoAreaChequeo = ?1")
})
public class TipoSolicitudBalanceoAreaChequeoLocal implements Serializable {

    public TipoSolicitudBalanceoAreaChequeoLocal() {}
    
    public TipoSolicitudBalanceoAreaChequeoLocal(Long oid, Long pbacOidParaBalaAreaCheq, Long tspaOidTipoSoliPais) {
        this.oid=oid;
        setParametrosBalanceoAreaChequeo(pbacOidParaBalaAreaCheq);
        setTipoSolicitudPais(tspaOidTipoSoliPais);
    }
    
    @Id
    @Column(name="OID_TIPO_SOLI_BALA_AREA_CHEQ")
    private Long oid;
    @Column(name="PBAC_OID_PARA_BALA_AREA_CHEQ")
    private Long parametrosBalanceoAreaChequeo;
    @Column(name="TSPA_OID_TIPO_SOLI_PAIS")
    private Long tipoSolicitudPais;
    
    
    public Long getOid() {return oid;}
    
    public Long getParametrosBalanceoAreaChequeo() {return parametrosBalanceoAreaChequeo;}
    
    public void setParametrosBalanceoAreaChequeo(Long parametrosBalanceoAreaChequeo){this.parametrosBalanceoAreaChequeo=parametrosBalanceoAreaChequeo;}
        
    public Long getTipoSolicitudPais() {return tipoSolicitudPais;}
    
    public void setTipoSolicitudPais(Long tipoSolicitudPais){this.tipoSolicitudPais=tipoSolicitudPais;}
                
	
}
