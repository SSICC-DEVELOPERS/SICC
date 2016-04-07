package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_CONFI_CAMPO")
@NamedQueries({
@NamedQuery(name="ConfClientesChequeoEnCampoLocal.FindByUK",query="SELECT OBJECT(o) FROM ConfClientesChequeoEnCampoLocal AS o WHERE o.periodo = ?1"),
@NamedQuery(name="ConfClientesChequeoEnCampoLocal.FindAll",query="select object(o) from ConfClientesChequeoEnCampoLocal o")
})
public class ConfClientesChequeoEnCampoLocal implements Serializable {

	public ConfClientesChequeoEnCampoLocal() {}

	public ConfClientesChequeoEnCampoLocal(Long oid, String cantidadTotalConsultoras, String periodoReclamo, Boolean indChequearNuevas, Boolean indGenerado, Long periodo, Long periodoInicial, Long periodofinal)	{
	
		this.oid=oid;
                this.cantidadTotalConsultoras=cantidadTotalConsultoras;
                this.periodoReclamo=periodoReclamo;
                this.indChequearNuevas=indChequearNuevas;
                this.indGenerado=indGenerado;
                this.periodo=periodo;
                this.periodoInicial=periodoInicial;
                this.periodoFinal=periodofinal;
	
	}

	@Id
	@Column(name="OID_CONF_CAMP")
	private Long oid;
	@Column(name="NUM_CANT_TOTA_CONS")
	private String cantidadTotalConsultoras;
	@Column(name="PERE_OID_PERI_RECL ")
	private String periodoReclamo;
	@Column(name="IND_CHEQ_NUEV")
	private Boolean indChequearNuevas;
	@Column(name="IND_GENE")
	private Boolean indGenerado;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="PERD_OID_PERI_INIC")
	private Long periodoInicial;
	@Column(name="PERD_OID_PERI_FINA")
	private Long periodoFinal;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCantidadTotalConsultoras() {return cantidadTotalConsultoras;}
      
	public void setCantidadTotalConsultoras(String cantidadTotalConsultoras){this.cantidadTotalConsultoras=cantidadTotalConsultoras;}
		
	public String getPeriodoReclamo() {return periodoReclamo;}
      
	public void setPeriodoReclamo(String periodoReclamo){this.periodoReclamo=periodoReclamo;}
		
	public Boolean getIndChequearNuevas() {return indChequearNuevas;}
      
	public void setIndChequearNuevas(Boolean indChequearNuevas){this.indChequearNuevas=indChequearNuevas;}
		
	public Boolean getIndGenerado() {return indGenerado;}
      
	public void setIndGenerado(Boolean indGenerado){this.indGenerado=indGenerado;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getPeriodoInicial() {return periodoInicial;}
      
	public void setPeriodoInicial(Long periodoInicial){this.periodoInicial=periodoInicial;}
		
	public Long getPeriodoFinal() {return periodoFinal;}
      
	public void setPeriodoFinal(Long periodoFinal){this.periodoFinal=periodoFinal;}
			
	
}
