package es.indra.sicc.entidades.fac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="FAC_DOCUM_CONTA_ACUMU_IMPUE")
@NamedQueries({
@NamedQuery(name="AcumuladoImpuestosLocal.FindByUK",query="SELECT OBJECT(t) FROM AcumuladoImpuestosLocal AS t WHERE t.oidSolCabe = ?1 AND t.oidTasaImpu = ?2")
})
public class AcumuladoImpuestosLocal implements Serializable {

	public AcumuladoImpuestosLocal() {}

	public AcumuladoImpuestosLocal(Long oidAcum, Float baseImpPosLocal, Float totalPreciosPosLocal, Float totalDescuentoCabLocal, Float baseImpDescuentoCabLocal, Float baseImpPrecioContableLocal, Float baseImpFleteLocal, Float baseImpTotalLocal, Float totalImpuestoLocal, Float totalImporteLocal, Float baseImpoPosDoc, Float totalPreciosPosDoc, Float totalDescuentoCabDoc, Float baseImpDescuentoCabDoc, Float baseImpPrecioContableDoc, Float baseImpFleteDoc, Float baseImpTotalDoc, Float totalImpuestoDoc, 
            Float totalImporteDoc, Long indicadorImpuestos, Long cabecera) 	{
		this.oidAcum=oidAcum;                
                this.baseImponiblePosLocal = baseImpPosLocal;
                this.totalPreciosPosLocal = totalPreciosPosLocal;
                this.totalDescuentoCabLocal = totalDescuentoCabLocal;
                this.biDescuentoCabLocal = baseImpDescuentoCabLocal;
                this.biPrecioContableLocal = baseImpPrecioContableLocal;
                this.baseImponibleFleteLocal = baseImpFleteLocal;
                this.totalBaseImponibleLocal = baseImpTotalLocal;
                this.totalImpuestosLocal = totalImpuestoLocal;
                this.totalImporteLocal = totalImporteLocal;
                this.baseImponiblePosDocumento = baseImpoPosDoc;
                this.totalPreciosPosDocumento = totalPreciosPosDoc;
                this.totalDescuentoCabDocumento = totalDescuentoCabDoc;       
                this.biDescuentoCabDocumento = baseImpDescuentoCabDoc;
                this.biPrecioContableDocumento = baseImpPrecioContableDoc;
                this.baseImponibleFleteDocumento = baseImpFleteDoc;
                this.totalBaseImponibleDocumento = baseImpTotalDoc;
                this.totalImpuestosDocumento = totalImpuestoDoc;
                this.totalImporteDocumento = totalImporteDoc;
                this.oidTasaImpu = indicadorImpuestos;
                this.oidSolCabe = cabecera;
        }

	@Id
	@Column(name="OID_DOC_CONT_ACUM_IMPU")
	private Long oidAcum;
	@Column(name="NUM_BASE_IMPO_POSI_LOCA")
	private Float baseImponiblePosLocal;
	@Column(name="NUM_TOTA_PREC_POSI_LOCA")
	private Float totalPreciosPosLocal;
	@Column(name="NUM_TOTA_DESC_CABE_LOCA")
	private Float totalDescuentoCabLocal;
	@Column(name="NUM_BASE_IMPO_DESC_CABE_LOCA")
	private Float biDescuentoCabLocal;
	@Column(name="NUM_BASE_IMPO_PREC_CONT_LOCA")
	private Float biPrecioContableLocal;
	@Column(name="NUM_BASE_IMPO_FLET_LOCA")
	private Float baseImponibleFleteLocal;
	@Column(name="NUM_BASE_IMPO_TOTA_LOCA")
	private Float totalBaseImponibleLocal;
	@Column(name="NUM_TOTA_IMPU_LOCA")
	private Float totalImpuestosLocal;
	@Column(name="NUM_TOTA_IMPO_LOCA")
	private Float totalImporteLocal;
	@Column(name="NUM_BASE_IMPO_POSI_DOCU")
	private Float baseImponiblePosDocumento;
	@Column(name="NUM_TOTA_PREC_POSI_DOCU")
	private Float totalPreciosPosDocumento;
	@Column(name="NUM_TOTA_DESC_CABE_DOCU")
	private Float totalDescuentoCabDocumento;
	@Column(name="NUM_BASE_IMPO_DESC_CABE_DOCU")
	private Float biDescuentoCabDocumento;
	@Column(name="NUM_BASE_IMPO_PREC_CONT_DOCU")
	private Float biPrecioContableDocumento;
	@Column(name="NUM_BASE_IMPO_FLET_DOCU")
	private Float baseImponibleFleteDocumento;
	@Column(name="NUM_BASE_IMPO_TOTA_DOCU")
	private Float totalBaseImponibleDocumento;
	@Column(name="NUM_TOTA_IMPU_DOCU")
	private Float totalImpuestosDocumento;
	@Column(name="NUM_TOTA_IMPO_DOCU")
	private Float totalImporteDocumento;
	@Column(name="TAIM_OID_TASA_IMPU")
	private Long oidTasaImpu;
	@Column(name="DCCA_OID_CABE")
	private Long oidSolCabe;

	
	public Long getOidAcum() {return oidAcum;}
      
	//public void setOidAcum(Long oidAcum){this.oidAcum=oidAcum;}
	
	public Long getPrimaryKey() {return oidAcum;}		
		
	public Float getBaseImponiblePosLocal() {return baseImponiblePosLocal;}
      
	public void setBaseImponiblePosLocal(Float baseImponiblePosLocal){this.baseImponiblePosLocal=baseImponiblePosLocal;}
		
	public Float getTotalPreciosPosLocal() {return totalPreciosPosLocal;}
      
	public void setTotalPreciosPosLocal(Float totalPreciosPosLocal){this.totalPreciosPosLocal=totalPreciosPosLocal;}
		
	public Float getTotalDescuentoCabLocal() {return totalDescuentoCabLocal;}
      
	public void setTotalDescuentoCabLocal(Float totalDescuentoCabLocal){this.totalDescuentoCabLocal=totalDescuentoCabLocal;}
		
	public Float getBiDescuentoCabLocal() {return biDescuentoCabLocal;}
      
	public void setBiDescuentoCabLocal(Float biDescuentoCabLocal){this.biDescuentoCabLocal=biDescuentoCabLocal;}
		
	public Float getBiPrecioContableLocal() {return biPrecioContableLocal;}
      
	public void setBiPrecioContableLocal(Float biPrecioContableLocal){this.biPrecioContableLocal=biPrecioContableLocal;}
		
	public Float getBaseImponibleFleteLocal() {return baseImponibleFleteLocal;}
      
	public void setBaseImponibleFleteLocal(Float baseImponibleFleteLocal){this.baseImponibleFleteLocal=baseImponibleFleteLocal;}
		
	public Float getTotalBaseImponibleLocal() {return totalBaseImponibleLocal;}
      
	public void setTotalBaseImponibleLocal(Float totalBaseImponibleLocal){this.totalBaseImponibleLocal=totalBaseImponibleLocal;}
		
	public Float getTotalImpuestosLocal() {return totalImpuestosLocal;}
      
	public void setTotalImpuestosLocal(Float totalImpuestosLocal){this.totalImpuestosLocal=totalImpuestosLocal;}
		
	public Float getTotalImporteLocal() {return totalImporteLocal;}
      
	public void setTotalImporteLocal(Float totalImporteLocal){this.totalImporteLocal=totalImporteLocal;}
		
	public Float getBaseImponiblePosDocumento() {return baseImponiblePosDocumento;}
      
	public void setBaseImponiblePosDocumento(Float baseImponiblePosDocumento){this.baseImponiblePosDocumento=baseImponiblePosDocumento;}
		
	public Float getTotalPreciosPosDocumento() {return totalPreciosPosDocumento;}
      
	public void setTotalPreciosPosDocumento(Float totalPreciosPosDocumento){this.totalPreciosPosDocumento=totalPreciosPosDocumento;}
		
	public Float getTotalDescuentoCabDocumento() {return totalDescuentoCabDocumento;}
      
	public void setTotalDescuentoCabDocumento(Float totalDescuentoCabDocumento){this.totalDescuentoCabDocumento=totalDescuentoCabDocumento;}
		
	public Float getBiDescuentoCabDocumento() {return biDescuentoCabDocumento;}
      
	public void setBiDescuentoCabDocumento(Float biDescuentoCabDocumento){this.biDescuentoCabDocumento=biDescuentoCabDocumento;}
		
	public Float getBiPrecioContableDocumento() {return biPrecioContableDocumento;}
      
	public void setBiPrecioContableDocumento(Float biPrecioContableDocumento){this.biPrecioContableDocumento=biPrecioContableDocumento;}
		
	public Float getBaseImponibleFleteDocumento() {return baseImponibleFleteDocumento;}
      
	public void setBaseImponibleFleteDocumento(Float baseImponibleFleteDocumento){this.baseImponibleFleteDocumento=baseImponibleFleteDocumento;}
		
	public Float getTotalBaseImponibleDocumento() {return totalBaseImponibleDocumento;}
      
	public void setTotalBaseImponibleDocumento(Float totalBaseImponibleDocumento){this.totalBaseImponibleDocumento=totalBaseImponibleDocumento;}
		
	public Float getTotalImpuestosDocumento() {return totalImpuestosDocumento;}
      
	public void setTotalImpuestosDocumento(Float totalImpuestosDocumento){this.totalImpuestosDocumento=totalImpuestosDocumento;}
		
	public Float getTotalImporteDocumento() {return totalImporteDocumento;}
      
	public void setTotalImporteDocumento(Float totalImporteDocumento){this.totalImporteDocumento=totalImporteDocumento;}
		
	public Long getOidTasaImpu() {return oidTasaImpu;}
      
	public void setOidTasaImpu(Long oidTasaImpu){this.oidTasaImpu=oidTasaImpu;}
		
	public Long getOidSolCabe() {return oidSolCabe;}
      
	public void setOidSolCabe(Long oidSolCabe){this.oidSolCabe=oidSolCabe;}
			
	
}
