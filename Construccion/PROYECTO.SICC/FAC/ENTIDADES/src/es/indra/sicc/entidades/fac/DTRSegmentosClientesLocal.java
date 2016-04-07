package es.indra.sicc.entidades.fac;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTR_SEGME_CLIEN")
public class DTRSegmentosClientesLocal implements Serializable {

	public DTRSegmentosClientesLocal() {}

	public DTRSegmentosClientesLocal(Long oid, Long clieOidClie, Long zorgOidRegi, Long zzonOidZona, Long perdOidPeri, Long nvsgOidNiveSegm, Long npedidos, Double venta, Double pmnp, Double impDes1, Double impDes3)	{
            this.oid=oid;
	    this.clieOidClie = clieOidClie;
	    this.zorgOidRegi = zorgOidRegi;
	    this.zzonOidZona = zzonOidZona;
	    this.perdOidPeri = perdOidPeri;
	    this.nvsgOidNiveSegm = nvsgOidNiveSegm;
	    this.numPedi = npedidos;
	    this.valPmnp = venta;
	    this.valVent = pmnp;
	    this.impDes1 = impDes1;
	    this.impDes3 = impDes3;
	}

        public DTRSegmentosClientesLocal(Long oid, Long clieOidClie, Long zorgOidRegi, Long zzonOidZona, Long perdOidPeri)      {
            this.oid=oid;
            this.clieOidClie = clieOidClie;
            this.zorgOidRegi = zorgOidRegi;
            this.zzonOidZona = zzonOidZona;
            this.perdOidPeri = perdOidPeri;
        }


	@Id
	@Column(name="OID_SEGM_CLIE")
	private Long oid;
	@Column(name="VAL_VENT")
	private Double valVent;
	@Column(name="NUM_PEDI")
	private Long numPedi;
	@Column(name="VAL_PMNP")
	private Double valPmnp;
	@Column(name="IMP_DES1")
	private Double impDes1;
	@Column(name="IMP_DES3")
	private Double impDes3;
	@Column(name="CLIE_OID_CLIE")
	private Long clieOidClie;
	@Column(name="ZORG_OID_REGI")
	private Long zorgOidRegi;
	@Column(name="ZZON_OID_ZONA")
	private Long zzonOidZona;
	@Column(name="PERD_OID_PERI")
	private Long perdOidPeri;
	@Column(name="NVSG_OID_NIVE_SEGM")
	private Long nvsgOidNiveSegm;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Double getValVent() {return valVent;}
      
	public void setValVent(Double valVent){this.valVent=valVent;}
		
	public Long getNumPedi() {return numPedi;}
      
	public void setNumPedi(Long numPedi){this.numPedi=numPedi;}
		
	public Double getValPmnp() {return valPmnp;}
      
	public void setValPmnp(Double valPmnp){this.valPmnp=valPmnp;}
		
	public Double getImpDes1() {return impDes1;}
      
	public void setImpDes1(Double impDes1){this.impDes1=impDes1;}
		
	public Double getImpDes3() {return impDes3;}
      
	public void setImpDes3(Double impDes3){this.impDes3=impDes3;}
		
	public Long getClieOidClie() {return clieOidClie;}
      
	public void setClieOidClie(Long clieOidClie){this.clieOidClie=clieOidClie;}
		
	public Long getZorgOidRegi() {return zorgOidRegi;}
      
	public void setZorgOidRegi(Long zorgOidRegi){this.zorgOidRegi=zorgOidRegi;}
		
	public Long getZzonOidZona() {return zzonOidZona;}
      
	public void setZzonOidZona(Long zzonOidZona){this.zzonOidZona=zzonOidZona;}
		
	public Long getPerdOidPeri() {return perdOidPeri;}
      
	public void setPerdOidPeri(Long perdOidPeri){this.perdOidPeri=perdOidPeri;}
		
	public Long getNvsgOidNiveSegm() {return nvsgOidNiveSegm;}
      
	public void setNvsgOidNiveSegm(Long nvsgOidNiveSegm){this.nvsgOidNiveSegm=nvsgOidNiveSegm;}
			
	
}
