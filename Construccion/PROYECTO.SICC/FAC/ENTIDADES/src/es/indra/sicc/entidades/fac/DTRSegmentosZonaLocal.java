package es.indra.sicc.entidades.fac;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DTR_SEGME_ZONAS")
public class DTRSegmentosZonaLocal implements Serializable {

	public DTRSegmentosZonaLocal() {}

	public DTRSegmentosZonaLocal(Long oid, Long zorgOidRegi, Long zzonOidZona, Long perdOidPeri, Long npedidos, Double venta, Double pmnp)	{
            this.oid=oid;
	    this.zorgOidRegi = zorgOidRegi;
	    this.zzonOidZona = zzonOidZona;
	    this.perdOidPeri = perdOidPeri;
	    this.valPmnp = pmnp;
	    this.valVent = venta;
	    this.numPedi = npedidos;	
	}


        public DTRSegmentosZonaLocal(Long oid, Long zorgOidRegi, Long zzonOidZona, Long perdOidPeri)  {
            this.oid=oid;
            this.zorgOidRegi = zorgOidRegi;
            this.zzonOidZona = zzonOidZona;
            this.perdOidPeri = perdOidPeri;
        }

	@Id
	@Column(name="OID_SEGM_ZONA")
	private Long oid;
	@Column(name="VAL_VENT")
	private Double valVent;
	@Column(name="NUM_PEDI")
	private Long numPedi;
	@Column(name="VAL_PMNP")
	private Double valPmnp;
	@Column(name="ZORG_OID_REGI")
	private Long zorgOidRegi;
	@Column(name="ZZON_OID_ZONA")
	private Long zzonOidZona;
	@Column(name="PERD_OID_PERI")
	private Long perdOidPeri;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Double getValVent() {return valVent;}
      
	public void setValVent(Double valVent){this.valVent=valVent;}
		
	public Long getNumPedi() {return numPedi;}
      
	public void setNumPedi(Long numPedi){this.numPedi=numPedi;}
		
	public Double getValPmnp() {return valPmnp;}
      
	public void setValPmnp(Double valPmnp){this.valPmnp=valPmnp;}
		
	public Long getZorgOidRegi() {return zorgOidRegi;}
      
	public void setZorgOidRegi(Long zorgOidRegi){this.zorgOidRegi=zorgOidRegi;}
		
	public Long getZzonOidZona() {return zzonOidZona;}
      
	public void setZzonOidZona(Long zzonOidZona){this.zzonOidZona=zzonOidZona;}
		
	public Long getPerdOidPeri() {return perdOidPeri;}
      
	public void setPerdOidPeri(Long perdOidPeri){this.perdOidPeri=perdOidPeri;}
			
	
}
