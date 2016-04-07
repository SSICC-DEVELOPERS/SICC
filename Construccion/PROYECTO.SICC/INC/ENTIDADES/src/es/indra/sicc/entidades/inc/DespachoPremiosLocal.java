package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_DESPA_PREMI")
@NamedQueries({
@NamedQuery(name="DespachoPremiosLocal.FindAll",query="select object(o) from DespachoPremiosLocal o"),
@NamedQuery(name="DespachoPremiosLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM DespachoPremiosLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class DespachoPremiosLocal implements Serializable {

	public DespachoPremiosLocal() {}

	public DespachoPremiosLocal(Long oid, Boolean indComuDespAuto, Boolean indComuDespManu, Long copaOidParaGral)	{
	
		this.oid=oid;
                this.setComunicacionDespachoAutomatico(indComuDespAuto);
	        this.setComunicacionDespachoManual(indComuDespManu);
	        this.setConcurso(copaOidParaGral);
	
	}

	@Id
	@Column(name="OID_DESP_PREM")
	private Long oid;
	@Column(name="IND_COMU_DESP_AUTO")
	private Boolean comunicacionDespachoAutomatico;
	@Column(name="IND_COMU_DESP_MANU")
	private Boolean comunicacionDespachoManual;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="MENS_OID_MENS_AUTO")
	private Long mensajeDespachoAutomatico;
	@Column(name="MENS_OID_MENS_MANU")
	private Long mensajeDespachoManual;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getComunicacionDespachoAutomatico() {return comunicacionDespachoAutomatico;}
      
	public void setComunicacionDespachoAutomatico(Boolean comunicacionDespachoAutomatico){this.comunicacionDespachoAutomatico=comunicacionDespachoAutomatico;}
		
	public Boolean getComunicacionDespachoManual() {return comunicacionDespachoManual;}
      
	public void setComunicacionDespachoManual(Boolean comunicacionDespachoManual){this.comunicacionDespachoManual=comunicacionDespachoManual;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getMensajeDespachoAutomatico() {return mensajeDespachoAutomatico;}
      
	public void setMensajeDespachoAutomatico(Long mensajeDespachoAutomatico){this.mensajeDespachoAutomatico=mensajeDespachoAutomatico;}
		
	public Long getMensajeDespachoManual() {return mensajeDespachoManual;}
      
	public void setMensajeDespachoManual(Long mensajeDespachoManual){this.mensajeDespachoManual=mensajeDespachoManual;}
			
	
}
