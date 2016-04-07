package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_MODO_EJECU")
@NamedQueries({
@NamedQuery(name="ModoEjecucionLocal.FindAll",query="select object(o) from ModoEjecucionLocal o")
})
public class ModoEjecucionLocal implements Serializable {

	public ModoEjecucionLocal() {}

	public ModoEjecucionLocal(Long oid, Long oidModoEjec, String descModoEjec)	{
            this.oid=oid;
	    this.oidModoEjec=oidModoEjec;
	    this.descModoEjec=descModoEjec;
	}

	@Column(name="OID_MODO_EJEC")
	private Long oidModoEjec;
	@Id
	@Column(name="COD_MODO_EJEC")
	private Long oid;
	@Column(name="DESC_MODO_EJEC")
	private String descModoEjec;

	
	public Long getOidModoEjec() {return oidModoEjec;}
      
	public void setOidModoEjec(Long oidModoEjec){this.oidModoEjec=oidModoEjec;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getDescModoEjec() {return descModoEjec;}
      
	public void setDescModoEjec(String descModoEjec){this.descModoEjec=descModoEjec;}
			
	
}
