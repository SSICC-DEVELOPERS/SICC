package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;
import java.util.Vector;

/**
 * 
 * @date 
 * @author pperanzola
 */
 
public class CadenaFiltro implements Serializable {
    private StringBuffer cadena;
    private Vector paramFiltro;
    
    public CadenaFiltro() {
        cadena = new StringBuffer();
        paramFiltro = new Vector();
    }
    
    public void concatenar (CadenaFiltro dtoEntrada){
        cadena.append(dtoEntrada.getCadena().toString());
        paramFiltro.addAll(dtoEntrada.getParamFiltro());
    }
    
    public void concatenar (StringBuffer strEntrada){
        cadena.append(strEntrada.toString());
    }
    
    public void concatenarParametro (Object objEntrada){
        paramFiltro.add(objEntrada);
    }
    
    public StringBuffer getCadena(){
        return cadena;
    }
    
    public void setCadena (StringBuffer cadena){
        this.cadena = cadena;
    }
    
    public Vector getParamFiltro (){
        return paramFiltro;
    }
    public void setParamFiltro (Vector paramFiltro){
        this.paramFiltro = paramFiltro;
    }
}