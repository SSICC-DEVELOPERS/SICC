package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_GUION_ARGUM_CABEC")
@NamedQueries({
@NamedQuery(name="GuiasArgumentacionCabeceraLocal.FindAll",query="select object(o) from GuiasArgumentacionCabeceraLocal o")
})
public class GuiasArgumentacionCabeceraLocal implements Serializable {

	public GuiasArgumentacionCabeceraLocal() {}

	public GuiasArgumentacionCabeceraLocal(Long oid, String codigoGuiaArgumental, Long pais, String descripcion)	{
	
		this.oid=oid;
                this.setCodigoGuiaArgumental(codigoGuiaArgumental);
	        this.setPais(pais);
	        this.setValDesc(descripcion);
	
	}

	@Id
	@Column(name="OID_GUIO_ARGU_CABE")
	private Long oid;
	@Column(name="COD_GUIA_ARGU")
	private String codigoGuiaArgumental;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="VAL_DESC")
	private String valDesc;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoGuiaArgumental() {return codigoGuiaArgumental;}
      
	public void setCodigoGuiaArgumental(String codigoGuiaArgumental){this.codigoGuiaArgumental=codigoGuiaArgumental;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public String getValDesc() {return valDesc;}
      
	public void setValDesc(String valDesc){this.valDesc=valDesc;}
			
	
}
