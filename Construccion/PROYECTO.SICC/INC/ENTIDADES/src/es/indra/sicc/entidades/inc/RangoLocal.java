package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="INC_RANGO")
@NamedQueries({
@NamedQuery(name="RangoLocal.FindAll",query="select object(o) from RangoLocal o"),
@NamedQuery(name="RangoLocal.FindByConcurso",query="SELECT OBJECT (a) "
+ " FROM RangoLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class RangoLocal implements Serializable {

	public RangoLocal() {}

	public RangoLocal(Long oid, BigDecimal valDesd, BigDecimal valHast, BigDecimal valIncr, Long copaOidParaGral)	{
	
		this.oid=oid;
                this.setDesde(valDesd);
	        this.setHasta(valHast);
	        this.setIncremento(valIncr);
	        this.setConcurso(copaOidParaGral);
	
	}

	@Id
	@Column(name="OID_RANG")
	private Long oid;
	@Column(name="VAL_DESD")
	private java.math.BigDecimal desde;
	@Column(name="VAL_HAST")
	private java.math.BigDecimal hasta;
	@Column(name="VAL_INCR")
	private java.math.BigDecimal incremento;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getDesde() {return desde;}
      
	public void setDesde(java.math.BigDecimal desde){this.desde=desde;}
		
	public java.math.BigDecimal getHasta() {return hasta;}
      
	public void setHasta(java.math.BigDecimal hasta){this.hasta=hasta;}
		
	public java.math.BigDecimal getIncremento() {return incremento;}
      
	public void setIncremento(java.math.BigDecimal incremento){this.incremento=incremento;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
			
	
}
