package es.indra.sicc.cmn.negocio.integracion;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase de Entrada que seria enviadas desde SSICC
 * 
 * @author <a href="mailto:sapaza@belcorp.biz">Sergio Apaza</a>
 */
public class DTOEntradaSICC implements Serializable {

    //Datos basicos que siempre deben ser enviados desde SSICC
    private String codigoPais;
    private String codigoIsoIdioma;
    private String codigoUsuario;
    private String procesoNegocio; //este es el proceso de Negocio a Ejecutarse
    
    private Long oidPais; //estos seran llenados en SICC
    private Long oidIdioma; //estos seran llenados en SICC
    private Long oidPeriodo; //estos seran llenados en SICC
    
    //Datos muy comunes a ser enviados desde SSICC
    private String codigoPeriodo;
    private String fechaProceso;
    
    //Datos Auxiliares
    private String codigoMarca;
    private String codigoCanal;
    private String formatoFecha;
    
    //Datos Auxiliares propios del Proceso de Negocio a ser invocado desde SSICC
    private Map parametros;

    public DTOEntradaSICC() {
        this.codigoMarca = ConstantesIntegracion.codigoMarcaDefault;
        this.codigoCanal = ConstantesIntegracion.codigoCanalDefault;
        this.formatoFecha = ConstantesIntegracion.formatoFechaDefault;
        
        this.parametros = new HashMap();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("DTOEntradaSICC: ");
        
        sb.append("\ncodigoPais:" + this.getCodigoPais());
        sb.append("\ncodigoIsoIdioma:" + this.getCodigoIsoIdioma());
        sb.append("\ncodigoUsuario:" + this.getCodigoUsuario());
        sb.append("\nprocesoNegocio:" + this.getProcesoNegocio());
        
        sb.append("\ncodigoPeriodo:" + this.getCodigoPeriodo());
        sb.append("\nfechaProceso:" + this.getFechaProceso());
        sb.append("\nformatoFecha:" + this.getFormatoFecha());
        
        sb.append("\ncodigoMarca:" + this.getCodigoMarca());
        sb.append("\ncodigoCanal:" + this.getCodigoCanal());
        sb.append("\nparametros:" + this.getParametros());

        return sb.toString();
    }
    
    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoIsoIdioma(String codigoIsoIdioma) {
        this.codigoIsoIdioma = codigoIsoIdioma;
    }

    public String getCodigoIsoIdioma() {
        return codigoIsoIdioma;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoPeriodo(String codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public void setFechaProceso(String fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public String getFechaProceso() {
        return fechaProceso;
    }

    public void setCodigoMarca(String codigoMarca) {
        this.codigoMarca = codigoMarca;
    }

    public String getCodigoMarca() {
        return codigoMarca;
    }

    public void setCodigoCanal(String codigoCanal) {
        this.codigoCanal = codigoCanal;
    }

    public String getCodigoCanal() {
        return codigoCanal;
    }

    public void setFormatoFecha(String formatoFecha) {
        this.formatoFecha = formatoFecha;
    }

    public String getFormatoFecha() {
        return formatoFecha;
    }

    public void setParametros(Map parametros) {
        this.parametros = parametros;
    }

    public Map getParametros() {
        return parametros;
    }

    public void setProcesoNegocio(String procesoNegocio) {
        this.procesoNegocio = procesoNegocio;
    }

    public String getProcesoNegocio() {
        return procesoNegocio;
    }

    public void setOidPais(Long oidPais) {
        this.oidPais = oidPais;
    }

    public Long getOidPais() {
        return oidPais;
    }

    public void setOidIdioma(Long oidIdioma) {
        this.oidIdioma = oidIdioma;
    }

    public Long getOidIdioma() {
        return oidIdioma;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }
}
