package es.indra.sicc.entidades.edu;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="EDU_MATRI_CURSO_EXIGI")
@NamedQueries({
@NamedQuery(name="MatrizCursosExigidosLocal.FindAll",query="select object(o) from MatrizCursosExigidosLocal o"),
@NamedQuery(name="MatrizCursosExigidosLocal.FindByCurso",query="SELECT OBJECT(a) FROM MatrizCursosExigidosLocal AS a WHERE a.oidCurs=?1")
})
public class MatrizCursosExigidosLocal implements Serializable {

	public MatrizCursosExigidosLocal() {}

	public MatrizCursosExigidosLocal(Long oid, Long oidCurs, Long oidCursRequ)	{
	
		this.oid=oid;
                this.oidCurs=oidCurs;
                this.oidCursRequ=oidCursRequ;
	
	}

	@Id
	@Column(name="OID_MATR_CURS_RECI")
	private Long oid;
	@Column(name="MCUR_OID_CURS")
	private Long oidCurs;
	@Column(name="TICU_OID_TIPO_CURS")
	private Long oidCursRequ;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidCurs() {return oidCurs;}
      
	public void setOidCurs(Long oidCurs){this.oidCurs=oidCurs;}
		
	public Long getOidCursRequ() {return oidCursRequ;}
      
	public void setOidCursRequ(Long oidCursRequ){this.oidCursRequ=oidCursRequ;}
			
	
}
