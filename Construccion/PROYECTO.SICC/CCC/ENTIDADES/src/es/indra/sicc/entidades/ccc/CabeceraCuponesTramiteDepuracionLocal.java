package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;

@Entity
@Table(name="CCC_CUPON_TRAMI_DEPUR")
public class CabeceraCuponesTramiteDepuracionLocal implements Serializable {

	public CabeceraCuponesTramiteDepuracionLocal() {}

	public CabeceraCuponesTramiteDepuracionLocal(Long oid, Long subacceso, Integer numero, 
                    String anio, String periodoMes, Date fechaDocumento, Long pais)	{
	
		this.oid=oid;
                this.subacceso=subacceso;
                this.numero=numero;
                this.anio=anio;
                this.periodoMes=periodoMes;
                this.fechaDocumento=fechaDocumento;
                this.pais=pais;	
	}

        public CabeceraCuponesTramiteDepuracionLocal(Long oid, Long subacceso, Integer numero, 
                        String anio, String periodoMes, Date fechaDocumento, Long pais, 
                        String referenciaExterna, String observaciones)     {
        
                this.oid=oid;
                this.subacceso=subacceso;
                this.numero=numero;
                this.anio=anio;
                this.periodoMes=periodoMes;
                this.fechaDocumento=fechaDocumento;
                this.pais=pais; 
                this.referenciaExterna=referenciaExterna;
                this.observaciones=observaciones;
        }
        
	@Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Id
	@Column(name="OID_CUPO_TRAM_DEPU")
	private Long oid;
	@Column(name="NUM_CUPE")
	private Integer numero;
	@Column(name="VAL_ANIO")
	private String anio;
	@Column(name="VAL_PERI_MES")
	private String periodoMes;
	@Column(name="FEC_DOCU")        
	private java.sql.Date fechaDocumento;
	@Column(name="VAL_REFE_EXTE")
	private String referenciaExterna;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;

	
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumero() {return numero;}
      
	public void setNumero(Integer numero){this.numero=numero;}
		
	public String getAnio() {return anio;}
      
	public void setAnio(String anio){this.anio=anio;}
		
	public String getPeriodoMes() {return periodoMes;}
      
	public void setPeriodoMes(String periodoMes){this.periodoMes=periodoMes;}
		
	public java.sql.Date getFechaDocumento() {return fechaDocumento;}
      
	public void setFechaDocumento(java.sql.Date fechaDocumento){this.fechaDocumento=fechaDocumento;}
		
	public String getReferenciaExterna() {return referenciaExterna;}
      
	public void setReferenciaExterna(String referenciaExterna){this.referenciaExterna=referenciaExterna;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
			
	
}
