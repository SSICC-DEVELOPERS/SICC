package es.indra.sicc.entidades.rep;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REP_REPOR")
@NamedQueries({
@NamedQuery(name="RepReporLocal.FindAll",query="select object(o) from RepReporLocal o"),
@NamedQuery(name="RepReporLocal.FindByUk",query="SELECT OBJECT(a) FROM RepReporLocal a WHERE a.codRepo = ?1")
})
public class RepReporLocal implements Serializable {

	public RepReporLocal() {}

	public RepReporLocal(Long oidRepo, String codReporte)	{
            this.oidRepo=oidRepo;
	    this.codRepo = codReporte;
	}

	@Id
	@Column(name="OID_REPO")
	private Long oidRepo;
	@Column(name="COD_REPO")
	private String codRepo;

	
	public Long getOidRepo() {return oidRepo;}
      
	//public void setOidRepo(Long oidRepo){this.oidRepo=oidRepo;}
	
	public Long getPrimaryKey() {return oidRepo;}		
		
	public String getCodRepo() {return codRepo;}
      
	public void setCodRepo(String codRepo){this.codRepo=codRepo;}
			
	
}
