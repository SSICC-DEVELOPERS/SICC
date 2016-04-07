package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COM_COMIS_ACCES")
@NamedQueries({
@NamedQuery(name="ComisionesAccesoLocal.FindAll",query="select object(o) from ComisionesAccesoLocal o"),
@NamedQuery(name="ComisionesAccesoLocal.FindbyComision",query="select object(c) from ComisionesAccesoLocal c where c.comision = ?1")
})
public class ComisionesAccesoLocal implements Serializable {

	public ComisionesAccesoLocal() {}

	public ComisionesAccesoLocal(Long oid, Long acceso, Long comision, Long canal)	{
	
		this.oid=oid;
                this.setComision(comision);
	        this.setAcceso(acceso);
	        this.setCanal(canal);
	
	}

	@Id
	@Column(name="OID_COMI_ACCE")
	private Long oid;
	@Column(name="PLCA_OID_PLAN_COMI_ACCE")
	private Long acceso;
	@Column(name="COMI_OID_COMI")
	private Long comision;
	@Column(name="CANA_OID_CANA")
	private Long canal;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getAcceso() {return acceso;}
      
	public void setAcceso(Long acceso){this.acceso=acceso;}
		
	public Long getComision() {return comision;}
      
	public void setComision(Long comision){this.comision=comision;}
		
	public Long getCanal() {return canal;}
      
	public void setCanal(Long canal){this.canal=canal;}
			
	
}
