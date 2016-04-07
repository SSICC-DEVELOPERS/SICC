package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_GUION_ARGUM_DETAL")
@NamedQueries({
@NamedQuery(name="GuiasArgumentacionDetalleLocal.FindAll",query="select object(o) from GuiasArgumentacionDetalleLocal o")
})
public class GuiasArgumentacionDetalleLocal implements Serializable {

	public GuiasArgumentacionDetalleLocal() {}

	public GuiasArgumentacionDetalleLocal(Long oid, Long ordenArgumento, Boolean valorDefecto, Boolean activarAtributoObservaciones, Long codigoArgumento, Long guiaArgumentalCabecera, Long indObligatorioVoluntario)	{
	
		this.oid=oid;
                this.setOrdenArgumento(ordenArgumento);
	        this.setActivarAtributoObservaciones(activarAtributoObservaciones);
	        this.setCodigoArgumento(codigoArgumento);
	        this.setGuiaArgumentalCabecera(guiaArgumentalCabecera);
	
	}

	@Id
	@Column(name="OID_GUIO_ARGU_DETA")
	private Long oid;
	@Column(name="NUM_ORDE_ARGU")
	private Long ordenArgumento;
	@Column(name="IND_ACTI_ATRI_OBSE")
	private Boolean activarAtributoObservaciones;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="ARGU_OID_ARGU")
	private Long codigoArgumento;
	@Column(name="GACA_OID_GUIO_ARGU_CABE")
	private Long guiaArgumentalCabecera;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOrdenArgumento() {return ordenArgumento;}
      
	public void setOrdenArgumento(Long ordenArgumento){this.ordenArgumento=ordenArgumento;}
		
	public Boolean getActivarAtributoObservaciones() {return activarAtributoObservaciones;}
      
	public void setActivarAtributoObservaciones(Boolean activarAtributoObservaciones){this.activarAtributoObservaciones=activarAtributoObservaciones;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getCodigoArgumento() {return codigoArgumento;}
      
	public void setCodigoArgumento(Long codigoArgumento){this.codigoArgumento=codigoArgumento;}
		
	public Long getGuiaArgumentalCabecera() {return guiaArgumentalCabecera;}
      
	public void setGuiaArgumentalCabecera(Long guiaArgumentalCabecera){this.guiaArgumentalCabecera=guiaArgumentalCabecera;}
			
	
}
