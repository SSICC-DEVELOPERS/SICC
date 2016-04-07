package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.io.Serializable;

@Entity
@Table(name="CAL_GUIAS")
@NamedQueries({
 @NamedQuery(name="GuiasLocal.FindAll",query="SELECT OBJECT(a) FROM GuiasLocal AS a")
})
public class GuiasLocal implements Serializable {

	public GuiasLocal() {}

	public GuiasLocal(Long oid, String cod_guia, String val_titu, Timestamp fec_inic_vali, Timestamp fec_fin_vali, String val_desc_guia, Long pais_oid_pais, Long dpte_oid_depa)	{
	
		this.oid=oid;
	        setCodGuia(cod_guia);
	        setTitulo(val_titu);
	        setFechaInicioValidez(fec_inic_vali);
	        setFechaFinValidez(fec_fin_vali);
	        setDescripcionGuia(val_desc_guia);
	        setPais(pais_oid_pais);
	        setDepartamento(dpte_oid_depa);

	
	}

	@Id
	@Column(name="OID_GUIA")
	private Long oid;
	@Column(name="COD_GUIA")
	private String codGuia;
	@Column(name="VAL_TITU")
	private String titulo;
	@Column(name="FEC_INIC_VALI")
	private java.sql.Timestamp fechaInicioValidez;
	@Column(name="FEC_FIN_VALI")
	private java.sql.Timestamp fechaFinValidez;
	@Column(name="VAL_DESC_GUIA")
	private String descripcionGuia;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="DPTE_OID_DEPA")
	private Long departamento;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodGuia() {return codGuia;}
      
	public void setCodGuia(String codGuia){this.codGuia=codGuia;}
		
	public String getTitulo() {return titulo;}
      
	public void setTitulo(String titulo){this.titulo=titulo;}
		
	public java.sql.Timestamp getFechaInicioValidez() {return fechaInicioValidez;}
      
	public void setFechaInicioValidez(java.sql.Timestamp fechaInicioValidez){this.fechaInicioValidez=fechaInicioValidez;}
		
	public java.sql.Timestamp getFechaFinValidez() {return fechaFinValidez;}
      
	public void setFechaFinValidez(java.sql.Timestamp fechaFinValidez){this.fechaFinValidez=fechaFinValidez;}
		
	public String getDescripcionGuia() {return descripcionGuia;}
      
	public void setDescripcionGuia(String descripcionGuia){this.descripcionGuia=descripcionGuia;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getDepartamento() {return departamento;}
      
	public void setDepartamento(Long departamento){this.departamento=departamento;}
			
	
}
