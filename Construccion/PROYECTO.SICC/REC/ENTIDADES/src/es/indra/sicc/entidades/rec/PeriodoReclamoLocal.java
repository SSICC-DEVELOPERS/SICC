package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_PERIO_RECLA")
@NamedQueries({
@NamedQuery(name="PeriodoReclamoLocal.FindAll",query="select object(o) from PeriodoReclamoLocal o")
})
public class PeriodoReclamoLocal implements Serializable {

	public PeriodoReclamoLocal() {}

	public PeriodoReclamoLocal(Long oid, String codPeriodoReclamo)	{
	
		this.oid=oid;
                this.codPeriodoReclamo=codPeriodoReclamo;
	
	}

	@Id
	@Column(name="OID_PERI_RECL")
	private Long oid;
	@Column(name="COD_PERI_RECL")
	private String codPeriodoReclamo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodPeriodoReclamo() {return codPeriodoReclamo;}
      
	public void setCodPeriodoReclamo(String codPeriodoReclamo){this.codPeriodoReclamo=codPeriodoReclamo;}
			
	
}
