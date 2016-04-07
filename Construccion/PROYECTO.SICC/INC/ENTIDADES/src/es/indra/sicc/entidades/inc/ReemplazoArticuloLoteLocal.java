package es.indra.sicc.entidades.inc;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="INC_REEMP_ARTIC_LOTE")
@NamedQueries({
@NamedQuery(name="ReemplazoArticuloLoteLocal.FindAll",query="select object(o) from ReemplazoArticuloLoteLocal o")
})

public class ReemplazoArticuloLoteLocal implements Serializable {
    public ReemplazoArticuloLoteLocal() { }
    public ReemplazoArticuloLoteLocal(Long oid,  Long indDesp, BigDecimal impPrecPubi, Long numUnid, String codVentFict, 
                                      Long prodOidProd, Long indCentDistGara, String indTipoEntrPrem, Long ctreOidCritReem, Long valCritReem,
                                      Long arloOidArtiLote, Long numOrde, Long indActi, Long indComu, String valUsua) {
        
        this.oid=oid;
        this.setIndicadorDesp(indDesp);
        this.setPrecioPublico(impPrecPubi);
        this.setUnidad(numUnid);
        this.setCodigoVentaFicticio(codVentFict);
        this.setOidProducto(prodOidProd);
        this.setGarantia(indCentDistGara);
        this.setEntregaPremio(indTipoEntrPrem);
        this.setCriterioReemplazo(ctreOidCritReem);
        this.setValorCriterioReemplazo(valCritReem);
        this.setOidArticuloLote(arloOidArtiLote);
        this.setnumeroOrden(numOrde);
        this.setIndicadorActivo(indActi);
        this.setIndComunicacion(indComu);
        //this.setIndicadorReemplazo(indReemVali);
        this.setValUsua(valUsua);
        
    }
    @Id
    @Column(name="OID_REEM_ARTI_LOTE")
    private Long oid;
    @Column(name="IND_DESP")
    private Long indicadorDesp;
    @Column(name="IMP_PREC_PUBL")
    private BigDecimal precioPublico;
    @Column(name="NUM_UNID")
    private Long unidad;
    @Column(name="COD_VENT_FICT")
    private String codigoVentaFicticio;
    @Column(name="PROD_OID_PROD")
    private Long oidProducto;
    @Column(name="IND_CENT_DIST_GARA")
    private Long garantia;
    @Column(name="IND_TIPO_ENTR_PREM")
    private String entregaPremio;
    @Column(name="CTRE_OID_CRIT_REEM")
    private Long criterioReemplazo;
    @Column(name="VAL_CRIT_REEM")
    private Long valorCriterioReemplazo;
    @Column(name="ARLO_OID_ARTI_LOTE")
    private Long oidArticuloLote;
    @Column(name="NUM_ORDE")
    private Long numeroOrden;
    @Column(name="IND_ACTI")
    private Long indicadorActivo;
    @Column(name="IND_COMU")
    private Long indComunicacion;
    //@Column(name="IND_REEM_VALI")
   // private Long indicadorReemplazo;
    @Column(name="VAL_OBSE_CENT_DIST")
    private String valObseCentDist;
    @Column(name="NUM_MESE_GARA")
    private Long numMeseGara;
    @Column(name="CESE_OID_CESE_ENTR")
    private Long ceseOidCeseEntr;
    @Column(name="CESE_OID_CESE_GARA")
    private Long ceseOidCeseGara;
    @Column(name="VAL_USUA")
    private String valUsua;
    public Long getOid() {return oid;}
    
    // sapaza -- PER-SiCC-2012-0322 -- 18/04/2012
    @Column(name="USU_CREA")
    private String usuarioCreacion;
    @Column(name="FEC_CREA")
    private java.sql.Timestamp fechaCreacion;
    @Column(name="USU_MODI")
    private String usuarioModificacion;
    @Column(name="FEC_MODI")
    private java.sql.Timestamp fechaModificacion;
        
    //public void setOid(Long oid){this.oid=oid;}
    
    public Long getPrimaryKey() {return oid;}               
            
    public Long getIndicadorDesp() {return indicadorDesp;}
    
    public void setIndicadorDesp(Long indicadorDesp){this.indicadorDesp=indicadorDesp;}
            
    public BigDecimal getPrecioPublico() {return precioPublico;}
    
    public void setPrecioPublico(BigDecimal precioPublico){this.precioPublico=precioPublico;}
    
    public Long getUnidad() {return unidad;}
    
    public void setUnidad(Long unidad){this.unidad=unidad;}
    
    public String getCodigoVentaFicticio() {return codigoVentaFicticio;}
    
    public void setCodigoVentaFicticio(String codigoVentaFicticio){this.codigoVentaFicticio=codigoVentaFicticio;}
    
    public Long getOidProducto() {return oidProducto;}
    
    public void setOidProducto(Long oidProducto){this.oidProducto=oidProducto;}
    
    public Long getGarantia() {return garantia;}
    
    public void setGarantia(Long garantia){this.garantia=garantia;}
    
    public String getEntregaPremio() {return entregaPremio;}
    
    public void setEntregaPremio(String entregaPremio){this.entregaPremio=entregaPremio;}
    
    public Long getCriterioReemplazo() {return criterioReemplazo;}
    
    public void setCriterioReemplazo(Long criterioReemplazo){this.criterioReemplazo=criterioReemplazo;}
    
    public Long getValorCriterioReemplazo() {return valorCriterioReemplazo;}
    
    public void setValorCriterioReemplazo(Long valorCriterioReemplazo){this.valorCriterioReemplazo=valorCriterioReemplazo;}
    
    public Long getOidArticuloLote() {return oidArticuloLote;}
    
    public void setOidArticuloLote(Long oidArticuloLote){this.oidArticuloLote=oidArticuloLote;}
    
    public Long getNumeroOrden() {return numeroOrden;}
    
    public void setnumeroOrden(Long numeroOrden){this.numeroOrden=numeroOrden;}
    
    public Long getIndicadorActivo() {return indicadorActivo;}
    
    public void setIndicadorActivo(Long indicadorActivo){this.indicadorActivo=indicadorActivo;}
    
    public Long getIndComunicacion() {return indComunicacion;}
    
    public void setIndComunicacion(Long indComunicacion){this.indComunicacion=indComunicacion;}
    
  //  public Long getIndicadorReemplazo() {return indicadorReemplazo;}
    
   // public void setIndicadorReemplazo(Long indicadorReemplazo){this.indicadorReemplazo=indicadorReemplazo;}
    
    //Remplazar por los campos no obligatorios
    
    public String getValObseCentDist() {return valObseCentDist;}
    
    public void setValObseCentDist(String valObseCentDist){this.valObseCentDist=valObseCentDist;}
    
    public Long getNumMeseGara() {return numMeseGara;}
    
    public void setNumMeseGara(Long numMeseGara){this.numMeseGara=numMeseGara;}
    
    public Long getCeseOidCeseEntr() {return ceseOidCeseEntr;}
    
    public void setCeseOidCeseEntr(Long ceseOidCeseEntr){this.ceseOidCeseEntr=ceseOidCeseEntr;}
    
    public Long getCeseOidCeseGara() {return ceseOidCeseGara;}
    
    public void setCeseOidCeseGara(Long ceseOidCeseGara){this.ceseOidCeseGara=ceseOidCeseGara;}
    
    public String getValUsua() {return valUsua;}
    
    public void setValUsua(String valUsua){this.valUsua=valUsua;}

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setFechaModificacion(Timestamp fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Timestamp getFechaModificacion() {
        return fechaModificacion;
    }
}
