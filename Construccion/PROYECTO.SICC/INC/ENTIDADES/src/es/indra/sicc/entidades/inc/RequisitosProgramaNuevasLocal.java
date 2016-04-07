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
@Table(name="INC_REQUI_PROGR_NUEVA")
@NamedQueries({
@NamedQuery(name="RequisitosProgramaNuevasLocal.FindAll",query="select object(o) from RequisitosProgramaNuevasLocal o"),
@NamedQuery(name="RequisitosProgramaNuevasLocal.FindByProgramaNuevas",query="SELECT OBJECT(a) "
+ " FROM RequisitosProgramaNuevasLocal AS a "
+ " WHERE a.programaNuevas = ?1")
})
public class RequisitosProgramaNuevasLocal implements Serializable {

	public RequisitosProgramaNuevasLocal() {}

	public RequisitosProgramaNuevasLocal(Long oid, Integer numPedi, BigDecimal valExigMini, Long prnuOidProgNuev)	{
	
		this.oid=oid;
                this.setNumeroPedido(numPedi);
	        this.setExigenciaMinima(valExigMini);
	        this.setProgramaNuevas(prnuOidProgNuev);
	
	}

	@Id
	@Column(name="OID_REQU_PROG_NUEV")
	private Long oid;
	@Column(name="NUM_PEDI")
	private Integer numeroPedido;
	@Column(name="VAL_EXIG_MINI")
	private java.math.BigDecimal exigenciaMinima;
	@Column(name="PRNU_OID_PROG_NUEV")
	private Long programaNuevas;
	@Column(name="PANP_OID_PARA_NIVE_PREM")
	private Long nivelPremiacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroPedido() {return numeroPedido;}
      
	public void setNumeroPedido(Integer numeroPedido){this.numeroPedido=numeroPedido;}
		
	public java.math.BigDecimal getExigenciaMinima() {return exigenciaMinima;}
      
	public void setExigenciaMinima(java.math.BigDecimal exigenciaMinima){this.exigenciaMinima=exigenciaMinima;}
		
	public Long getProgramaNuevas() {return programaNuevas;}
      
	public void setProgramaNuevas(Long programaNuevas){this.programaNuevas=programaNuevas;}
		
	public Long getNivelPremiacion() {return nivelPremiacion;}
      
	public void setNivelPremiacion(Long nivelPremiacion){this.nivelPremiacion=nivelPremiacion;}
			
	
}
