package es.indra.sicc.entidades.seg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="SEG_SUBAC")
@NamedQueries({
@NamedQuery(name="SubaccesoLocal.FindByUK",query="SELECT OBJECT(i) "
+ " FROM SubaccesoLocal AS i "
+ " WHERE i.codigo = ?1 and "
+ " i.oidAcceso = ?2"),
@NamedQuery(name="SubaccesoLocal.FindAll",query="SELECT OBJECT(i) FROM SubaccesoLocal AS i ")
})
public class SubaccesoLocal implements Serializable {

	public SubaccesoLocal() {}

	public SubaccesoLocal(Long oid, String codigo, Long oidAcceso)	{
		this.oid = oid;
		this.codigo = codigo;
		this.oidAcceso = oidAcceso;
	}

	@Id
	@Column(name="OID_SBAC")
	private Long oid;
	@Column(name="COD_SBAC")
	private String codigo;
	@Column(name="ACCE_OID_ACCE")
	private Long oidAcceso;

	
	public Long getOid() {return oid;}
      
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public Long getOidAcceso() {return oidAcceso;}
      
	public void setOidAcceso(Long oidAcceso){this.oidAcceso=oidAcceso;}
			
	
}
