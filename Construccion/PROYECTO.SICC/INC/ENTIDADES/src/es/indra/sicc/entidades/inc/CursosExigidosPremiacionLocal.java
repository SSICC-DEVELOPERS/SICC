package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_CURSO_EXIGI_PREMI")
@NamedQueries({
@NamedQuery(name="CursosExigidosPremiacionLocal.FindAll",query="select object(o) from CursosExigidosPremiacionLocal o"),
@NamedQuery(name="CursosExigidosPremiacionLocal.FindByRequisito",query="SELECT OBJECT (a) "
+ " FROM CursosExigidosPremiacionLocal AS a "
+ " WHERE a.reprOidRequPrem = ?1")
})
public class CursosExigidosPremiacionLocal implements Serializable {

	public CursosExigidosPremiacionLocal() {}

	public CursosExigidosPremiacionLocal(Long oid, Long oidTipoCurso, Long oidReqPrem)	{
	
		this.oid=oid;
                this.setTicuOidTipoCurs(oidTipoCurso);
	        this.setReprOidRequPrem(oidReqPrem);
	
	}

	@Id
	@Column(name="OID_CURS_EXIG_PREM")
	private Long oid;
	@Column(name="TICU_OID_TIPO_CURS")
	private Long ticuOidTipoCurs;
	@Column(name="REPR_OID_REQU_PREM")
	private Long reprOidRequPrem;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getTicuOidTipoCurs() {return ticuOidTipoCurs;}
      
	public void setTicuOidTipoCurs(Long ticuOidTipoCurs){this.ticuOidTipoCurs=ticuOidTipoCurs;}
		
	public Long getReprOidRequPrem() {return reprOidRequPrem;}
      
	public void setReprOidRequPrem(Long reprOidRequPrem){this.reprOidRequPrem=reprOidRequPrem;}
			
	
}
