package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_ESTIM_PRODU")
@NamedQueries({
@NamedQuery(name="EstimadosProductoLocal.FindAll",query="select object(o) from EstimadosProductoLocal o"),
@NamedQuery(name="EstimadosProductoLocal.FindByUK",query="select object(o) from EstimadosProductoLocal o "
+ " WHERE o.oidLineArma = ?1 AND o.oidPeri = ?2 AND "
+ " o.oidProc = ?3 AND o.oidProd = ?4 AND o.indFuerPedi = ?5"),
@NamedQuery(name="EstimadosProductoLocal.FindByLineaPeriodo",query="select object(o)  "
+ " from EstimadosProductoLocal o "
+ " WHERE o.oidPeri = ?3 "
+ " AND (o.oidLineArma = ?1 OR o.oidLineArma = ?2)")
})
public class EstimadosProductoLocal implements Serializable {

    public EstimadosProductoLocal() {}

    public EstimadosProductoLocal(Long oid, Long numUnidEsti, Boolean indFuerPedi,
            Long prceOidProc, Long liarOidLineArma, Long perdOidPeri, Long prodOidProd)	{

        this.oid = oid;
        setNumUnidEsti(numUnidEsti);
        setIndFuerPedi(indFuerPedi);
        setOidProc(prceOidProc);
        setOidLineArma(liarOidLineArma);
        setOidPeri(perdOidPeri);
        setOidProd(prodOidProd);
    }

    @Id
    @Column(name="OID_ESTI_PROD")
    private Long oid;
    @Column(name="NUM_UNID_ESTI")
    private Long numUnidEsti;
    @Column(name="IND_FUER_PEDI")
    private Boolean indFuerPedi;
    @Column(name="PRCE_OID_PROC")
    private Long oidProc;
    @Column(name="LIAR_OID_LINE_ARMA")
    private Long oidLineArma;
    @Column(name="PERD_OID_PERI")
    private Long oidPeri;
    @Column(name="PROD_OID_PROD")
    private Long oidProd;

    
    public Long getOid() {return oid;}
    
    public Long getNumUnidEsti() {return numUnidEsti;}
  
    public void setNumUnidEsti(Long numUnidEsti){this.numUnidEsti=numUnidEsti;}
            
    public Boolean getIndFuerPedi() {return indFuerPedi;}
  
    public void setIndFuerPedi(Boolean indFuerPedi){this.indFuerPedi=indFuerPedi;}
            
    public Long getOidProc() {return oidProc;}
  
    public void setOidProc(Long oidProc){this.oidProc=oidProc;}
            
    public Long getOidLineArma() {return oidLineArma;}
  
    public void setOidLineArma(Long oidLineArma){this.oidLineArma=oidLineArma;}
            
    public Long getOidPeri() {return oidPeri;}
  
    public void setOidPeri(Long oidPeri){this.oidPeri=oidPeri;}
            
    public Long getOidProd() {return oidProd;}
  
    public void setOidProd(Long oidProd){this.oidProd=oidProd;}
	
}
