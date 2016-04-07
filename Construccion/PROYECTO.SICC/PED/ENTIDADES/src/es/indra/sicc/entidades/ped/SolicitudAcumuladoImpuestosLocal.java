package es.indra.sicc.entidades.ped;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="PED_SOLIC_ACUMU_IMPUE")
@NamedQueries({
@NamedQuery(name="SolicitudAcumuladoImpuestosLocal.FindByUK",query="SELECT OBJECT (a) "
+ " FROM SolicitudAcumuladoImpuestosLocal AS a "
+ " WHERE a.oidSolCabe = ?1 "
+ " AND a.oidTasaImpu = ?2"),
@NamedQuery(name="SolicitudAcumuladoImpuestosLocal.FindAll",query="SELECT OBJECT(p) from SolicitudAcumuladoImpuestosLocal p")
})
public class SolicitudAcumuladoImpuestosLocal implements Serializable {

    public SolicitudAcumuladoImpuestosLocal() {}

    public SolicitudAcumuladoImpuestosLocal(Long oidAcum, Long oidTasaImpu, Long oidSolCabe, 
            BigDecimal baseImponiblePosLocal, BigDecimal totalPreciosPosLocal, BigDecimal totalDescuentoCabLocal, 
            BigDecimal baseImponibleDescuentoCabLocal, BigDecimal baseImponiblePrecioContableLocal,
            BigDecimal baseImponibleFleteLocal, BigDecimal totalBaseImponibleLocal, BigDecimal totalImpuestosLocal,
            BigDecimal baseImponiblePosDocumento, BigDecimal totalImporteLocal, BigDecimal totalPreciosPosDocumento,
            BigDecimal totalDescuentoCabDocumento, BigDecimal baseImponibleDescuentoCabDocumento,
            BigDecimal baseImponiblePrecioContableDocumento, BigDecimal baseImponibleFleteDocumento, 
            BigDecimal totalBaseImponibleDocumento, BigDecimal totalImpuestosDocumento, BigDecimal totalImporteDocumento) {
    
        this.oidAcum = oidAcum;
        setOidTasaImpu(oidTasaImpu);
        setOidSolCabe(oidSolCabe);
        setBaseImponiblePosLocal(baseImponiblePosLocal);
        setTotalPreciosPosLocal(totalPreciosPosLocal);
        setTotalDescuentoCabLocal(totalDescuentoCabLocal);
        setBiDescuentoCabLocal(baseImponibleDescuentoCabLocal);
        setBiPrecioContableLocal(baseImponiblePrecioContableLocal);
        setBaseImponibleFleteLocal(baseImponibleFleteLocal);
        setTotalBaseImponibleLocal(totalBaseImponibleLocal);
        setTotalImpuestosLocal(totalImpuestosLocal);
        setBaseImponiblePosDocumento(baseImponiblePosDocumento);
        setTotalImporteLocal(totalImporteLocal);
        setTotalPreciosPosDocumento(totalPreciosPosDocumento);
        setTotalDescuentoCabDocumento(totalDescuentoCabDocumento);
        setBiDescuentoCabDocumento(baseImponibleDescuentoCabDocumento);
        setBiPrecioContableDocumento(baseImponiblePrecioContableDocumento);
        setBaseImponibleFleteDocumento(baseImponibleFleteDocumento);
        setTotalBaseImponibleDocumento(totalBaseImponibleDocumento);
        setTotalImpuestosDocumento(totalImpuestosDocumento);
        setTotalImporteDocumento(totalImporteDocumento);
    }

    @Id
    @Column(name="OID_ACUM")
    private Long oidAcum;
    @Column(name="TAIM_OID_TASA_IMPU")
    private Long oidTasaImpu;
    @Column(name="SOCA_OID_SOLI_CABE")
    private Long oidSolCabe;
    @Column(name="VAL_BASE_IMPO_POSI_LOCA")
    private BigDecimal baseImponiblePosLocal;
    @Column(name="VAL_TOTA_PREC_POSI_LOCA")
    private BigDecimal totalPreciosPosLocal;
    @Column(name="VAL_TOTA_DESC_CABE_LOCA")
    private BigDecimal totalDescuentoCabLocal;
    @Column(name="VAL_BASE_IMPO_DESC_CABE")
    private BigDecimal biDescuentoCabLocal;
    @Column(name="VAL_BASE_IMPO_PREC_CONT")
    private BigDecimal biPrecioContableLocal;
    @Column(name="VAL_BASE_IMPO_FLET_LOCA")
    private BigDecimal baseImponibleFleteLocal;
    @Column(name="VAL_TOTA_BASE_IMPO_LOCA")
    private BigDecimal totalBaseImponibleLocal;
    @Column(name="VAL_TOTA_IMPU_LOCA")
    private BigDecimal totalImpuestosLocal;
    @Column(name="VAL_BASE_IMPO_POSI_DOCU")
    private BigDecimal baseImponiblePosDocumento;
    @Column(name="VAL_TOTA_IMPO_LOCA")
    private BigDecimal totalImporteLocal;
    @Column(name="VAL_TOTA_PREC_POSI_DOCU")
    private BigDecimal totalPreciosPosDocumento;
    @Column(name="VAL_TOTA_DESC_CABE_DOCU")
    private BigDecimal totalDescuentoCabDocumento;
    @Column(name="VAL_BASE_IMPO_DESC_CABE_DOCU")
    private BigDecimal biDescuentoCabDocumento;
    @Column(name="VAL_BASE_IMPO_PREC_CONT_DOCU")
    private BigDecimal biPrecioContableDocumento;
    @Column(name="VAL_BASE_IMPO_FLET_DOCU")
    private BigDecimal baseImponibleFleteDocumento;
    @Column(name="VAL_TOTA_BASE_IMPO_DOCU")
    private BigDecimal totalBaseImponibleDocumento;
    @Column(name="VAL_TOTA_IMPU_DOCU")
    private BigDecimal totalImpuestosDocumento;
    @Column(name="VAL_TOTA_IMPO_DOCU")
    private BigDecimal totalImporteDocumento;

    
    public Long getOidAcum() {return oidAcum;}
  
    public Long getPrimaryKey() {return oidAcum;}		
            
    public Long getOidTasaImpu() {return oidTasaImpu;}
  
    public void setOidTasaImpu(Long oidTasaImpu){this.oidTasaImpu=oidTasaImpu;}
            
    public Long getOidSolCabe() {return oidSolCabe;}
  
    public void setOidSolCabe(Long oidSolCabe){this.oidSolCabe=oidSolCabe;}
            
    public BigDecimal getBaseImponiblePosLocal() {return baseImponiblePosLocal;}
  
    public void setBaseImponiblePosLocal(BigDecimal baseImponiblePosLocal){this.baseImponiblePosLocal=baseImponiblePosLocal;}
            
    public BigDecimal getTotalPreciosPosLocal() {return totalPreciosPosLocal;}
  
    public void setTotalPreciosPosLocal(BigDecimal totalPreciosPosLocal){this.totalPreciosPosLocal=totalPreciosPosLocal;}
            
    public BigDecimal getTotalDescuentoCabLocal() {return totalDescuentoCabLocal;}
  
    public void setTotalDescuentoCabLocal(BigDecimal totalDescuentoCabLocal){this.totalDescuentoCabLocal=totalDescuentoCabLocal;}
            
    public BigDecimal getBiDescuentoCabLocal() {return biDescuentoCabLocal;}
  
    public void setBiDescuentoCabLocal(BigDecimal biDescuentoCabLocal){this.biDescuentoCabLocal=biDescuentoCabLocal;}
            
    public BigDecimal getBiPrecioContableLocal() {return biPrecioContableLocal;}
  
    public void setBiPrecioContableLocal(BigDecimal biPrecioContableLocal){this.biPrecioContableLocal=biPrecioContableLocal;}
            
    public BigDecimal getBaseImponibleFleteLocal() {return baseImponibleFleteLocal;}
  
    public void setBaseImponibleFleteLocal(BigDecimal baseImponibleFleteLocal){this.baseImponibleFleteLocal=baseImponibleFleteLocal;}
            
    public BigDecimal getTotalBaseImponibleLocal() {return totalBaseImponibleLocal;}
  
    public void setTotalBaseImponibleLocal(BigDecimal totalBaseImponibleLocal){this.totalBaseImponibleLocal=totalBaseImponibleLocal;}
            
    public BigDecimal getTotalImpuestosLocal() {return totalImpuestosLocal;}
  
    public void setTotalImpuestosLocal(BigDecimal totalImpuestosLocal){this.totalImpuestosLocal=totalImpuestosLocal;}
            
    public BigDecimal getBaseImponiblePosDocumento() {return baseImponiblePosDocumento;}
  
    public void setBaseImponiblePosDocumento(BigDecimal baseImponiblePosDocumento){this.baseImponiblePosDocumento=baseImponiblePosDocumento;}
            
    public BigDecimal getTotalImporteLocal() {return totalImporteLocal;}
  
    public void setTotalImporteLocal(BigDecimal totalImporteLocal){this.totalImporteLocal=totalImporteLocal;}
            
    public BigDecimal getTotalPreciosPosDocumento() {return totalPreciosPosDocumento;}
  
    public void setTotalPreciosPosDocumento(BigDecimal totalPreciosPosDocumento){this.totalPreciosPosDocumento=totalPreciosPosDocumento;}
            
    public BigDecimal getTotalDescuentoCabDocumento() {return totalDescuentoCabDocumento;}
  
    public void setTotalDescuentoCabDocumento(BigDecimal totalDescuentoCabDocumento){this.totalDescuentoCabDocumento=totalDescuentoCabDocumento;}
            
    public BigDecimal getBiDescuentoCabDocumento() {return biDescuentoCabDocumento;}
  
    public void setBiDescuentoCabDocumento(BigDecimal biDescuentoCabDocumento){this.biDescuentoCabDocumento=biDescuentoCabDocumento;}
            
    public BigDecimal getBiPrecioContableDocumento() {return biPrecioContableDocumento;}
  
    public void setBiPrecioContableDocumento(BigDecimal biPrecioContableDocumento){this.biPrecioContableDocumento=biPrecioContableDocumento;}
            
    public BigDecimal getBaseImponibleFleteDocumento() {return baseImponibleFleteDocumento;}
  
    public void setBaseImponibleFleteDocumento(BigDecimal baseImponibleFleteDocumento){this.baseImponibleFleteDocumento=baseImponibleFleteDocumento;}
            
    public BigDecimal getTotalBaseImponibleDocumento() {return totalBaseImponibleDocumento;}
  
    public void setTotalBaseImponibleDocumento(BigDecimal totalBaseImponibleDocumento){this.totalBaseImponibleDocumento=totalBaseImponibleDocumento;}
            
    public BigDecimal getTotalImpuestosDocumento() {return totalImpuestosDocumento;}
  
    public void setTotalImpuestosDocumento(BigDecimal totalImpuestosDocumento){this.totalImpuestosDocumento=totalImpuestosDocumento;}
            
    public BigDecimal getTotalImporteDocumento() {return totalImporteDocumento;}
  
    public void setTotalImporteDocumento(BigDecimal totalImporteDocumento){this.totalImporteDocumento=totalImporteDocumento;}
                    
	
}
