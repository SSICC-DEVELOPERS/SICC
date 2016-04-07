package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_LINEA_ARMAD")
@NamedQueries({
@NamedQuery(name="LineaArmadoLocal.FindAll",query="select object(o) from LineaArmadoLocal o"),
@NamedQuery(name="LineaArmadoLocal.FindByUK",query="SELECT OBJECT(o) FROM LineaArmadoLocal o WHERE o.codigoLinea = ?1")
})
public class LineaArmadoLocal implements Serializable {

    public LineaArmadoLocal() {}

    public LineaArmadoLocal(Long oid, Long codigo, Long longNunEtiq,
            Boolean LineaAFP, Boolean valDefecto, Long oidCD, Long oidFD) {

        this.oid = oid;
        setCodigoLinea(codigo);
        setLongitudNumeroEtiqueta(longNunEtiq);
        setValorDefecto(valDefecto);
        setLineaAFP(LineaAFP);
        setConfiguracionCentroDistribucion(oidCD);
        setFuncionDistribucion(oidFD);
    }

    @Id
    @Column(name="OID_LINE_ARMA")
    private Long oid;
    @Column(name="NUM_CODI_LINE")
    private Long codigoLinea;
    @Column(name="NUM_LONG_NUME_ETIQ")
    private Long longitudNumeroEtiqueta;
    @Column(name="NUM_LINE_AFP")
    private Boolean lineaAFP;
    @Column(name="NUM_PORC_VARI_ESTI")
    private java.math.BigDecimal porcentajeVariacionEstimado;
    @Column(name="FEC_HORA_REVI_ALAR")
    private java.sql.Timestamp fechaHoraRevisionAlarma;
    @Column(name="NUM_ETIQ")
    private Long numeroEtiquetasAFP;
    @Column(name="NUM_VALO_DEFE")
    private Boolean valorDefecto;
    @Column(name="FNDI_OID_FUNC_DIST")
    private Long funcionDistribucion;
    @Column(name="CCDI_OID_CONF_CENT_DIST")
    private Long configuracionCentroDistribucion;
    @Column(name="SICJ_OID_PROG_CUBI")
    private Long programaCubicaje;

    
    public Long getOid() {return oid;}
    
    public Long getCodigoLinea() {return codigoLinea;}
  
    public void setCodigoLinea(Long codigoLinea){this.codigoLinea=codigoLinea;}
            
    public Long getLongitudNumeroEtiqueta() {return longitudNumeroEtiqueta;}
  
    public void setLongitudNumeroEtiqueta(Long longitudNumeroEtiqueta){this.longitudNumeroEtiqueta=longitudNumeroEtiqueta;}
            
    public Boolean getLineaAFP() {return lineaAFP;}
  
    public void setLineaAFP(Boolean lineaAFP){this.lineaAFP=lineaAFP;}
            
    public java.math.BigDecimal getPorcentajeVariacionEstimado() {return porcentajeVariacionEstimado;}
  
    public void setPorcentajeVariacionEstimado(java.math.BigDecimal porcentajeVariacionEstimado){this.porcentajeVariacionEstimado=porcentajeVariacionEstimado;}
            
    public java.sql.Timestamp getFechaHoraRevisionAlarma() {return fechaHoraRevisionAlarma;}
  
    public void setFechaHoraRevisionAlarma(java.sql.Timestamp fechaHoraRevisionAlarma){this.fechaHoraRevisionAlarma=fechaHoraRevisionAlarma;}
            
    public Long getNumeroEtiquetasAFP() {return numeroEtiquetasAFP;}
  
    public void setNumeroEtiquetasAFP(Long numeroEtiquetasAFP){this.numeroEtiquetasAFP=numeroEtiquetasAFP;}
            
    public Boolean getValorDefecto() {return valorDefecto;}
  
    public void setValorDefecto(Boolean valorDefecto){this.valorDefecto=valorDefecto;}
            
    public Long getFuncionDistribucion() {return funcionDistribucion;}
  
    public void setFuncionDistribucion(Long funcionDistribucion){this.funcionDistribucion=funcionDistribucion;}
            
    public Long getConfiguracionCentroDistribucion() {return configuracionCentroDistribucion;}
  
    public void setConfiguracionCentroDistribucion(Long configuracionCentroDistribucion){this.configuracionCentroDistribucion=configuracionCentroDistribucion;}
            
    public Long getProgramaCubicaje() {return programaCubicaje;}
  
    public void setProgramaCubicaje(Long programaCubicaje){this.programaCubicaje=programaCubicaje;}
                    
	
}
