package es.indra.sicc.entidades.fac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="FAC_RANGO_NUMER_OFICI")
@NamedQueries({
@NamedQuery(name="RangosNumeracionOficialLocal.FindByUK",query="SELECT OBJECT(t) FROM RangosNumeracionOficialLocal AS t WHERE t.pais=?1 AND t.subacceso=?2 AND t.empresa=?3 AND t.tipoDocumento=?4 AND t.ordenUtilizacion=?5")
})
public class RangosNumeracionOficialLocal implements Serializable {

	public RangosNumeracionOficialLocal() {}

	public RangosNumeracionOficialLocal(Long oid,Long pais, Long empresa, Long subacceso, Long tipoDocumento, Long ordenUtilizacion, String serieDocumento, Long inicioRangoNumeracion, Long finRangoNumeracion)	{
        	this.oid=oid;
	
	}

	@Id
	@Column(name="OID_RANG")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="SOCI_OID_SOCI")
	private Long empresa;
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Column(name="TIDO_OID_TIPO_DOCU")
	private Long tipoDocumento;
	@Column(name="NUM_ORDE_UTIL")
	private Long ordenUtilizacion;
	@Column(name="VAL_SERI_DOCU")
	private String serieDocumento;
	@Column(name="VAL_INIC_RANG_NUME")
	private Long inicioRangoNumeracion;
	@Column(name="VAL_FINA_RANG_NUME")
	private Long finRangoNumeracion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getEmpresa() {return empresa;}
      
	public void setEmpresa(Long empresa){this.empresa=empresa;}
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public Long getTipoDocumento() {return tipoDocumento;}
      
	public void setTipoDocumento(Long tipoDocumento){this.tipoDocumento=tipoDocumento;}
		
	public Long getOrdenUtilizacion() {return ordenUtilizacion;}
      
	public void setOrdenUtilizacion(Long ordenUtilizacion){this.ordenUtilizacion=ordenUtilizacion;}
		
	public String getSerieDocumento() {return serieDocumento;}
      
	public void setSerieDocumento(String serieDocumento){this.serieDocumento=serieDocumento;}
		
	public Long getInicioRangoNumeracion() {return inicioRangoNumeracion;}
      
	public void setInicioRangoNumeracion(Long inicioRangoNumeracion){this.inicioRangoNumeracion=inicioRangoNumeracion;}
		
	public Long getFinRangoNumeracion() {return finRangoNumeracion;}
      
	public void setFinRangoNumeracion(Long finRangoNumeracion){this.finRangoNumeracion=finRangoNumeracion;}
			
	
}
