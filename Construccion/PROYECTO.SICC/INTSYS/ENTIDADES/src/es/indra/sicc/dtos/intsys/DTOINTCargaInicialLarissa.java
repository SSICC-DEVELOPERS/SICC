package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOINTCargaInicialLarissa extends DTOBelcorp {
    public DTOINTCargaInicialLarissa(){
        
    }
    
        private Long marca;                
        private Long canal;                
        private Long periodo;              
        private String codigoPeriodo;      
        private Long tipoPeriodo;          
        private String codigoTipoPeriodo;  
        private String numeroLote;         
        private String descripcionLote;    
        private String observaciones;      
        private ArrayList listaInterfaces; 
        private Boolean enviarEstimados;   

    public Long getCanal()
    {
        return canal;
    }

    public void setCanal(Long canal)
    {
        this.canal = canal;
    }

    public String getCodigoPeriodo()
    {
        return codigoPeriodo;
    }

    public void setCodigoPeriodo(String codigoPeriodo)
    {
        this.codigoPeriodo = codigoPeriodo;
    }

    public String getCodigoTipoPeriodo()
    {
        return codigoTipoPeriodo;
    }

    public void setCodigoTipoPeriodo(String codigoTipoPeriodo)
    {
        this.codigoTipoPeriodo = codigoTipoPeriodo;
    }

    public String getDescripcionLote()
    {
        return descripcionLote;
    }

    public void setDescripcionLote(String descripcionLote)
    {
        this.descripcionLote = descripcionLote;
    }

    public Boolean getEnviarEstimados()
    {
        return enviarEstimados;
    }

    public void setEnviarEstimados(Boolean enviarEstimados)
    {
        this.enviarEstimados = enviarEstimados;
    }

    public ArrayList getListaInterfaces()
    {
        return listaInterfaces;
    }

    public void setListaInterfaces(ArrayList listaInterfaces)
    {
        this.listaInterfaces = listaInterfaces;
    }

    public Long getMarca()
    {
        return marca;
    }

    public void setMarca(Long marca)
    {
        this.marca = marca;
    }

    public String getNumeroLote()
    {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote)
    {
        this.numeroLote = numeroLote;
    }

    public String getObservaciones()
    {
        return observaciones;
    }

    public void setObservaciones(String observaciones)
    {
        this.observaciones = observaciones;
    }

    public Long getPeriodo()
    {
        return periodo;
    }

    public void setPeriodo(Long periodo)
    {
        this.periodo = periodo;
    }

    public Long getTipoPeriodo()
    {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(Long tipoPeriodo)
    {
        this.tipoPeriodo = tipoPeriodo;
    }

}