package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_PARAM_BALAN_AREA_CHEQU")
@NamedQueries({
@NamedQuery(name="ParametrosBalanceoAreaChequeoLocal.FindAll",query="select object(o) from ParametrosBalanceoAreaChequeoLocal o")
})
public class ParametrosBalanceoAreaChequeoLocal implements Serializable {

    public ParametrosBalanceoAreaChequeoLocal() {}

    public ParametrosBalanceoAreaChequeoLocal(Long oid, Long numPediHoraArma, Long numUnidHoraPersCheq,
            Long numParaDist, Long ccdiOidConfCentDist, Long liarOidLineArma, Double horaDia, Long codAgru) {
        
        this.oid=oid;
        setCodAgru(codAgru);
        setNumPediHoraArma(numPediHoraArma);
        setNumUnidHoraPersCheq(numUnidHoraPersCheq);
        setNumParaDist(numParaDist);
        setCcdiOidConfCentDist(ccdiOidConfCentDist);
        setLiarOidLineArma(liarOidLineArma);
        setHoraDias(horaDia);
    }

    @Id
    @Column(name="OID_PARA_BALA_AREA_CHEQ")
    private Long oid;
    @Column(name="COD_AGRU")
    private Long codAgru;
    @Column(name="NUM_PEDI_HORA_ARMA")
    private Long numPediHoraArma;
    @Column(name="NUM_UNID_HORA_PERS_CHEQ")
    private Long numUnidHoraPersCheq;
    @Column(name="NUM_PARA_DIST")
    private Long numParaDist;
    @Column(name="CCDI_OID_CONF_CENT_DIST")
    private Long ccdiOidConfCentDist;
    @Column(name="LIAR_OID_LINE_ARMA")
    private Long liarOidLineArma;
    @Column(name="NUM_HORA_XDIA")
    private Double horaDias;

    
    public Long getOid() {return oid;}
    
    public Long getCodAgru() {return codAgru;}
  
    public void setCodAgru(Long codAgru){this.codAgru=codAgru;}
            
    public Long getNumPediHoraArma() {return numPediHoraArma;}
  
    public void setNumPediHoraArma(Long numPediHoraArma){this.numPediHoraArma=numPediHoraArma;}
            
    public Long getNumUnidHoraPersCheq() {return numUnidHoraPersCheq;}
  
    public void setNumUnidHoraPersCheq(Long numUnidHoraPersCheq){this.numUnidHoraPersCheq=numUnidHoraPersCheq;}
            
    public Long getNumParaDist() {return numParaDist;}
  
    public void setNumParaDist(Long numParaDist){this.numParaDist=numParaDist;}
            
    public Long getCcdiOidConfCentDist() {return ccdiOidConfCentDist;}
  
    public void setCcdiOidConfCentDist(Long ccdiOidConfCentDist){this.ccdiOidConfCentDist=ccdiOidConfCentDist;}
            
    public Long getLiarOidLineArma() {return liarOidLineArma;}
  
    public void setLiarOidLineArma(Long liarOidLineArma){this.liarOidLineArma=liarOidLineArma;}
            
    public Double getHoraDias() {return horaDias;}
  
    public void setHoraDias(Double horaDias){this.horaDias=horaDias;}
			
	
}
