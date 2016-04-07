package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_TIPO_SOLIC_LINEA")
@NamedQueries({
@NamedQuery(name="TipoSolicitudLineaLocal.FindAll",query="select object(o) from TipoSolicitudLineaLocal o")
})
public class TipoSolicitudLineaLocal implements Serializable {

    public TipoSolicitudLineaLocal() {}
    
    public TipoSolicitudLineaLocal(Long oid, Long tspaOidTipoSoliPais, Long liarOidLineArma)	{
    
        this.oid=oid;
        this.tspaOidTipoSoliPais=tspaOidTipoSoliPais;
        this.liarOidLineArma=liarOidLineArma;
    
    }
    
    @Id
    @Column(name="OID_TIPO_SOLI_LINE")
    private Long oid;
    @Column(name="TSPA_OID_TIPO_SOLI_PAIS")
    private Long tspaOidTipoSoliPais;
    @Column(name="LIAR_OID_LINE_ARMA")
    private Long liarOidLineArma;
    
    
    public Long getOid() {return oid;}
    
    public Long getTspaOidTipoSoliPais() {return tspaOidTipoSoliPais;}
    
    public void setTspaOidTipoSoliPais(Long tspaOidTipoSoliPais){this.tspaOidTipoSoliPais=tspaOidTipoSoliPais;}
        
    public Long getLiarOidLineArma() {return liarOidLineArma;}
    
    public void setLiarOidLineArma(Long liarOidLineArma){this.liarOidLineArma=liarOidLineArma;}
                
    
}
