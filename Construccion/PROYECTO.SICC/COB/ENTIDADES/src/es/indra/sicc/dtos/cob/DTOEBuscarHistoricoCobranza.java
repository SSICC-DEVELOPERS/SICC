package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEBuscarHistoricoCobranza extends DTOSiccPaginacion  {
    
    private Long periodo;
    private String codigoCliente;
    private Long marca;
    private Long canal;


    public void setPeriodo(Long periodo) {
        this.periodo = periodo;
    }


    public Long getPeriodo() {
        return periodo;
    }


    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }


    public String getCodigoCliente() {
        return codigoCliente;
    }


    public void setMarca(Long marca) {
        this.marca = marca;
    }


    public Long getMarca() {
        return marca;
    }


    public void setCanal(Long canal) {
        this.canal = canal;
    }


    public Long getCanal() {
        return canal;
    }
    
}