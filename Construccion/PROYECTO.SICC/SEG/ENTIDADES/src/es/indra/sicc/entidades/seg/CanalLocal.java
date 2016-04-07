package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_CANAL")
@NamedQueries({
@NamedQuery(name="CanalLocal.FindByClaveUnica",query="SELECT OBJECT(a)"
+ " FROM CanalLocal AS a "
+ " WHERE a.codCanal = ?1"),
@NamedQuery(name="CanalLocal.FindByUK",query="select Object(c) from CanalLocal c"
+ " where c.codCanal = ?1"),
@NamedQuery(name="CanalLocal.FindAll", query="SELECT Object(c) FROM CanalLocal c")
})
public class CanalLocal implements Serializable {

	public CanalLocal() {}

	public CanalLocal(Long oid, String codCanal, Long oidTipoPeriodo)	{
		this.oid=oid;
		this.codCanal = codCanal;
		this.oidTipoPeriodo = oidTipoPeriodo;
	}

	@Id
	@Column(name="OID_CANA")
	private Long oid;
	@Column(name="COD_CANA")
	private String codCanal;
	@Column(name="TIPE_OID_TIPO_PERI")
	private Long oidTipoPeriodo;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodCanal() {return codCanal;}
      
	public void setCodCanal(String codCanal){this.codCanal=codCanal;}
		
	public Long getOidTipoPeriodo() {return oidTipoPeriodo;}
      
	public void setOidTipoPeriodo(Long oidTipoPeriodo){this.oidTipoPeriodo=oidTipoPeriodo;}
			
	
}
