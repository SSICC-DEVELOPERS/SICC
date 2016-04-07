package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_ASIGN_IMPRE")
@NamedQueries({
@NamedQuery(name="AsignacionImpresoraAPELocal.FindAll",query="select object(o) from AsignacionImpresoraAPELocal o"),
@NamedQuery(name="AsignacionImpresoraAPELocal.FindByUk",query="SELECT OBJECT(o) FROM AsignacionImpresoraAPELocal o WHERE o.sbarOidSublArma = ?1")
})
public class AsignacionImpresoraAPELocal implements Serializable {

    public AsignacionImpresoraAPELocal() {}

    public AsignacionImpresoraAPELocal(Long oid, Long imviOidImpr, Long sbarOidSublArma, Long teimOidTecn)	{
        this.oid = oid;
        this.imviOidImpr = imviOidImpr;
        this.sbarOidSublArma = sbarOidSublArma;
        this.teimOidTecn = teimOidTecn;
    }

    @Id
    @Column(name="OID_ASIGN_IMPRE")
    private Long oid;
    @Column(name="IMVI_OID_IMPR")
    private Long imviOidImpr;
    @Column(name="SBAR_OID_SUBL_ARMA")
    private Long sbarOidSublArma;
    @Column(name="TEIM_OID_TECN")
    private Long teimOidTecn;
    @Column(name="NUM_IMPR_PTL")
    private Long numImprPtl;

    
    public Long getOid() {return oid;}
    
    public Long getImviOidImpr() {return imviOidImpr;}
  
    public void setImviOidImpr(Long imviOidImpr){this.imviOidImpr=imviOidImpr;}
            
    public Long getSbarOidSublArma() {return sbarOidSublArma;}
  
    public void setSbarOidSublArma(Long sbarOidSublArma){this.sbarOidSublArma=sbarOidSublArma;}
            
    public Long getTeimOidTecn() {return teimOidTecn;}
  
    public void setTeimOidTecn(Long teimOidTecn){this.teimOidTecn=teimOidTecn;}
            
    public Long getNumImprPtl() {return numImprPtl;}
  
    public void setNumImprPtl(Long numImprPtl){this.numImprPtl=numImprPtl;}
			
	
}
