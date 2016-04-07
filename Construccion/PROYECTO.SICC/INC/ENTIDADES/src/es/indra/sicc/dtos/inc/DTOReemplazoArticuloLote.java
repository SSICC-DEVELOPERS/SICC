package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class DTOReemplazoArticuloLote extends DTOBelcorp{
   
    private Long oidReemArtiLote;
    private Long indDesp;                               
    private BigDecimal impPrecPubi;   
    private Long numUnid;
    private String codVentFict;
    private Long prodOidProd;
    private Long indCentDistGara;
    private String indTipoEntrPrem;
    private String valObseCentDist;
    private Long numMeseGara;
    private Long ceseOidCeseEntr;
    private Long ceseOidCeseGara;
    private Long ctreOidCritReem;
    private Long valCritReem;
    private Long arloOidArtiLote;
    private Long numOrde;
    private Long indActi;
    private Long indComu;
    private Long indReemVali;
    private String valUsua;
    private String codigoSapNuevoProducto;
    private ArrayList oidZona;
    private ArrayList oidRegion;
    private HashMap zonaRegion;
    private ArrayList registrosEliminados;
    private Long oidConcurso;
    
    // sapaza -- COL-SiCC-2014-0174 -- 20/06/2014
    private String tipoAgrupacion;
    
    public DTOReemplazoArticuloLote() {
    }
    
    public Long getOidReemArtiLote(){
        return oidReemArtiLote;
    }
    public void setOidReemArtiLote(Long oidReemArtiLote){
         this.oidReemArtiLote = oidReemArtiLote;
    }
    public Long getIndDesp(){
        return indDesp;
    }
    public void setIndDesp(Long indDesp){
         this.indDesp = indDesp;
    }
    public BigDecimal getImpPrecPubi(){
        return impPrecPubi;
    }
    public void setImpPrecPubi(BigDecimal impPrecPubi){
         this.impPrecPubi = impPrecPubi;
    }
    public Long getNumUnid(){
        return numUnid;
    }
    public void setNumUnid(Long numUnid){
         this.numUnid = numUnid;
    }
    public String getCodVentFict(){
        return codVentFict;
    }
    public void setCodVentFict(String codVentFict){
         this.codVentFict = codVentFict;
    }
    public Long getProdOidProd(){
        return prodOidProd;
    }
    public void setProdOidProd(Long prodOidProd){
         this.prodOidProd = prodOidProd;
    }
    public Long getIndCentDistGara(){
        return indCentDistGara;
    }
    public void setIndCentDistGara(Long indCentDistGara){
         this.indCentDistGara = indCentDistGara;
    }
    public String getIndTipoEntrPrem(){
        return indTipoEntrPrem;
    }
    public void setIndTipoEntrPrem(String indTipoEntrPrem){
         this.indTipoEntrPrem = indTipoEntrPrem;
    }
    public String getValObseCentDist(){
        return valObseCentDist;
    }
    public void setValObseCentDist(String valObseCentDist){
         this.valObseCentDist = valObseCentDist;
    }
    public Long getNumMeseGara(){
        return numMeseGara;
    }
    public void setNumMeseGara(Long numMeseGara){
         this.numMeseGara = numMeseGara;
    }
    public Long getCeseOidCeseEntr(){
        return ceseOidCeseEntr;
    }
    public void setCeseOidCeseEntr(Long ceseOidCeseEntr){
         this.ceseOidCeseEntr = ceseOidCeseEntr;
    }
    public Long getCeseOidCeseGara(){
        return ceseOidCeseGara;
    }
    public void setCeseOidCeseGara(Long ceseOidCeseGara){
         this.ceseOidCeseGara = ceseOidCeseGara;
    }
    public Long getCtreOidCritReem(){
        return ctreOidCritReem;
    }
    public void setCtreOidCritReem(Long ctreOidCritReem){
         this.ctreOidCritReem = ctreOidCritReem;
    }
    public Long getValCritReem(){
        return valCritReem;
    }
    public void setValCritReem(Long valCritReem){
         this.valCritReem = valCritReem;
    }
    public Long getArloOidArtiLote(){
        return arloOidArtiLote;
    }
    public void setArloOidArtiLote(Long arloOidArtiLote){
         this.arloOidArtiLote = arloOidArtiLote;
    }
    public Long getNumOrde(){
        return numOrde;
    }
    public void setNumOrde(Long numOrde){
         this.numOrde = numOrde;
    }
    public Long getIndActi(){
        return indActi;
    }
    public void setIndActi(Long indActi){
         this.indActi = indActi;
    }
    public Long getIndComu(){
        return indComu;
    }
    public void setIndComu(Long indComu){
         this.indComu = indComu;
    }
    public Long getIndReemVali(){
        return indReemVali;
    }
    public void setIndReemVali(Long indReemVali){
         this.indReemVali = indReemVali;
    }
    public String getValUsua(){
        return valUsua;
    }
    public void setValUsua(String valUsua){
         this.valUsua = valUsua;
    }
    public String getCodigoSapNuevoProducto(){
        return codigoSapNuevoProducto;
    }
    public void setCodigoSapNuevoProducto(String codigoSapNuevoProducto){
         this.codigoSapNuevoProducto = codigoSapNuevoProducto;
    }
    public ArrayList getOidZona(){
        return oidZona;
    }
    public void setOidZona(ArrayList oidZona){
         this.oidZona = oidZona;
    }
    
    public ArrayList getOidRegion(){
        return oidRegion;
    }
    public void setOidRegion(ArrayList oidRegion){
         this.oidRegion = oidRegion;
    }
    public HashMap getZonaRegion(){
        return zonaRegion;
    }
    public void setZonaRegion(HashMap zonaRegion){
         this.zonaRegion = zonaRegion;
    }  
    public ArrayList getRegistrosEliminados(){
        return registrosEliminados;
    }
    public void setRegistrosEliminados(ArrayList registrosEliminados){
         this.registrosEliminados = registrosEliminados;
    }  
    public Long getOidConcurso(){
        return oidConcurso;
    }
    public void setOidConcurso(Long oidConcurso){
         this.oidConcurso = oidConcurso;
    }

    public void setTipoAgrupacion(String tipoAgrupacion) {
        this.tipoAgrupacion = tipoAgrupacion;
    }

    public String getTipoAgrupacion() {
        return tipoAgrupacion;
    }
}
