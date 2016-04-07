package es.indra.sicc.cmn.negocio.integracion;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase de Salida que sera la respuesta enviadas desde SICC
 * 
 * @author <a href="mailto:sapaza@belcorp.biz">Sergio Apaza</a>
 */
public class DTOSalidaSICC implements Serializable {

    private String idProcesoBatch; //Codigo Proceso Batch
    private Map datos;             //datos auxiliares 
    private RecordSet resultados; //resultados de una query
    private String numeroLote;    //Numero Lote

    public DTOSalidaSICC() {
        this.datos = new HashMap();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("DTOEntradaSICC: ");
        
        sb.append("\nidProcesoBatch:" + this.getIdProcesoBatch());
        sb.append("\ndatos:" + this.getDatos());
        sb.append("\nresultados:" + this.getResultados());

        return sb.toString();
    }
    
    public void setIdProcesoBatch(String idProcesoBatch) {
        this.idProcesoBatch = idProcesoBatch;
    }

    public String getIdProcesoBatch() {
        return idProcesoBatch;
    }

    public void setDatos(Map datos) {
        this.datos = datos;
    }

    public Map getDatos() {
        return datos;
    }

    public void setResultados(RecordSet resultados) {
        this.resultados = resultados;
    }

    public RecordSet getResultados() {
        return resultados;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getNumeroLote() {
        return numeroLote;
    }
    
}
