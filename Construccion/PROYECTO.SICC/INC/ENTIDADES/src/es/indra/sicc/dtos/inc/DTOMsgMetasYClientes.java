package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOMsgMetasYClientes extends DTOBelcorp {   
    private BigDecimal meta;
    private BigDecimal incremento;
    private Long cliente;
    private String nombre1;
    private String apellido1;
    private String codCliente;
    private String codZona;
    private Long codTerritorio;
    
    public BigDecimal getMeta() {
        return this.meta;
    }
    
    public void setMeta(BigDecimal meta) {
        this.meta = meta;
    }
    
    public BigDecimal getIncremento() {
        return this.incremento;
    }
    
    public void setIncremento(BigDecimal incremento) {
        this.incremento = incremento;
    }
    
    public Long getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }
    
    public String getNombre1() {
        return this.nombre1;
    }
    
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }
    
    public String getApellido1() {
        return this.apellido1;
    }
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    
    public String getCodCliente() {
        return this.codCliente;
    }
    
    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }
    
    public String getCodZona() {
        return this.codZona;
    }
    
    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }
    
    public Long getCodTerritorio() {
        return this.codTerritorio;
    }
    
    public void setCodTerritorio(Long codTerritorio) {
        this.codTerritorio = codTerritorio;
    }
}