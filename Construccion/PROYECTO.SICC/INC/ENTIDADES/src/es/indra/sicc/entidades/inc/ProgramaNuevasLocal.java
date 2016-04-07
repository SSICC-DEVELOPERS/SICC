package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PROGR_NUEVA")
@NamedQueries({
@NamedQuery(name="ProgramaNuevasLocal.FindAll",query="select object(o) from ProgramaNuevasLocal o"),
@NamedQuery(name="ProgramaNuevasLocal.FindByConcurso",query="SELECT OBJECT(p) "
+ " FROM ProgramaNuevasLocal AS p "
+ " WHERE p.concurso = ?1")
})
public class ProgramaNuevasLocal implements Serializable {

	public ProgramaNuevasLocal() {}

	public ProgramaNuevasLocal(Long oid, Integer numPediEval, Long copaOidParaGral, Long treqOidTipoRequ, Integer numPediPrem)	{
	
		this.oid=oid;
                this.setNumeroPedidosEvaluar(numPediEval);
	        this.setConcurso(copaOidParaGral);
	        this.setTipoRequisito(treqOidTipoRequ);
	        this.setNumeroPedidosAPremiar(numPediPrem);
	
	}

	@Id
	@Column(name="OID_PROG_NUEV")
	private Long oid;
	@Column(name="NUM_PEDI_EVAL")
	private Integer numeroPedidosEvaluar;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="TREQ_OID_TIPO_REQU")
	private Long tipoRequisito;
	@Column(name="NUM_PEDI_PREM")
	private Integer numeroPedidosAPremiar;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroPedidosEvaluar() {return numeroPedidosEvaluar;}
      
	public void setNumeroPedidosEvaluar(Integer numeroPedidosEvaluar){this.numeroPedidosEvaluar=numeroPedidosEvaluar;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getTipoRequisito() {return tipoRequisito;}
      
	public void setTipoRequisito(Long tipoRequisito){this.tipoRequisito=tipoRequisito;}
		
	public Integer getNumeroPedidosAPremiar() {return numeroPedidosAPremiar;}
      
	public void setNumeroPedidosAPremiar(Integer numeroPedidosAPremiar){this.numeroPedidosAPremiar=numeroPedidosAPremiar;}
			
	
}
