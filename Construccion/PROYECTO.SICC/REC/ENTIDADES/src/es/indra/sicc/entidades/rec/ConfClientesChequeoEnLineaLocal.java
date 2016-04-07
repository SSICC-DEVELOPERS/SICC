package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_CONFI_LINEA")
@NamedQueries({
@NamedQuery(name="ConfClientesChequeoEnLineaLocal.FindAll",query="select object(o) from ConfClientesChequeoEnLineaLocal o")
})
public class ConfClientesChequeoEnLineaLocal implements Serializable {

	public ConfClientesChequeoEnLineaLocal() {}

	public ConfClientesChequeoEnLineaLocal(Long oid, Integer cantidadMinimaReclamos, Boolean indChequearNuevas, Boolean indGenerado, Long periodo, Long periodoFinal, Long zona, Long region, Long subgerenciaVentas, Long seccion, Long periodoInicial)	{
	
		this.oid=oid;
                this.cantidadMinimaReclamos=cantidadMinimaReclamos;
                this.indChequearNuevas=indChequearNuevas; 
                this.indGenerado=indGenerado;
                this.periodo=periodo;
                this.periodoFinal=periodoFinal;
                this.zona=zona;
                this.region=region;
                this.subgerenciaVentas=subgerenciaVentas;
                this.seccion=seccion;
                this.periodoInicial=periodoInicial;
	
	}
        public ConfClientesChequeoEnLineaLocal(Long oid, Integer cantidadMinimaReclamos, Boolean indChequearNuevas, Boolean indGenerado, Long periodo, Long periodoFinal, Long subgerenciaVentas, Long periodoInicial)  {
        
            this.oid=oid;
            this.cantidadMinimaReclamos=cantidadMinimaReclamos;
            this.indChequearNuevas=indChequearNuevas; 
            this.indGenerado=indGenerado;
            this.periodo=periodo;
            this.periodoFinal=periodoFinal;
            this.subgerenciaVentas=subgerenciaVentas;
            this.periodoInicial=periodoInicial;
        }

	@Id
	@Column(name="OID_CONF_LINE")
	private Long oid;
	@Column(name="NUM_CANT_MINI_RECL")
	private Integer cantidadMinimaReclamos;
	@Column(name="IND_CHEQ_NUEV")
	private Boolean indChequearNuevas;
	@Column(name="IND_GENE")
	private Boolean indGenerado;
	@Column(name="PERD_OID_PERI")
	private Long periodo;
	@Column(name="PERD_OID_PERI_FINA")
	private Long periodoFinal;
	@Column(name="ZZON_OID_ZONA")
	private Long zona;
	@Column(name="ZORG_OID_REGI")
	private Long region;
	@Column(name="ZSGV_OID_SUBG_VENT")
	private Long subgerenciaVentas;
	@Column(name="ZSCC_OID_SECC")
	private Long seccion;
	@Column(name="PERD_OID_PERI_INIC")
	private Long periodoInicial;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getCantidadMinimaReclamos() {return cantidadMinimaReclamos;}
      
	public void setCantidadMinimaReclamos(Integer cantidadMinimaReclamos){this.cantidadMinimaReclamos=cantidadMinimaReclamos;}
		
	public Boolean getIndChequearNuevas() {return indChequearNuevas;}
      
	public void setIndChequearNuevas(Boolean indChequearNuevas){this.indChequearNuevas=indChequearNuevas;}
		
	public Boolean getIndGenerado() {return indGenerado;}
      
	public void setIndGenerado(Boolean indGenerado){this.indGenerado=indGenerado;}
		
	public Long getPeriodo() {return periodo;}
      
	public void setPeriodo(Long periodo){this.periodo=periodo;}
		
	public Long getPeriodoFinal() {return periodoFinal;}
      
	public void setPeriodoFinal(Long periodoFinal){this.periodoFinal=periodoFinal;}
		
	public Long getZona() {return zona;}
      
	public void setZona(Long zona){this.zona=zona;}
		
	public Long getRegion() {return region;}
      
	public void setRegion(Long region){this.region=region;}
		
	public Long getSubgerenciaVentas() {return subgerenciaVentas;}
      
	public void setSubgerenciaVentas(Long subgerenciaVentas){this.subgerenciaVentas=subgerenciaVentas;}
		
	public Long getSeccion() {return seccion;}
      
	public void setSeccion(Long seccion){this.seccion=seccion;}
		
	public Long getPeriodoInicial() {return periodoInicial;}
      
	public void setPeriodoInicial(Long periodoInicial){this.periodoInicial=periodoInicial;}
			
	
}
