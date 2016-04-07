package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CALIF_AGRUP")
@NamedQueries({
@NamedQuery(name="CalificacionAgrupacionLocal.FindAll",query="select object(o) from CalificacionAgrupacionLocal o")
})
public class CalificacionAgrupacionLocal implements Serializable {

	public CalificacionAgrupacionLocal() {}

	public CalificacionAgrupacionLocal(Long oid, Long copaOidParaGral, Long agruOidAgru)	{
	
		this.oid=oid;
                this.setConcurso(copaOidParaGral);
                this.setAgrupacion(agruOidAgru);
	
	}

	@Id
	@Column(name="OID_CALI_AGRU")
	private Long oid;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="AGRU_OID_AGRU")
	private Long agrupacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getAgrupacion() {return agrupacion;}
      
	public void setAgrupacion(Long agrupacion){this.agrupacion=agrupacion;}
			
	
}
