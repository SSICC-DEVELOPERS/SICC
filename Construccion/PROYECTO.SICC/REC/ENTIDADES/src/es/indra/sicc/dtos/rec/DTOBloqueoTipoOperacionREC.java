package es.indra.sicc.dtos.rec;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOBloqueoTipoOperacionREC extends DTOBelcorp  {

    private Long bloqueoUnidades;  
    private Long bloqueoImporte; 
    private Long bloqueoDiferencia;   
    private Long bloqueoAnterior; 
    private BigDecimal importeMaximo;   
    private BigDecimal montoMaximo;

    
    public DTOBloqueoTipoOperacionREC() {
    }

    public Long getBloqueoDiferencia() {
        return bloqueoDiferencia;
    }

    public void setBloqueoDiferencia(Long bloqueoDiferencia) {
        this.bloqueoDiferencia = bloqueoDiferencia;
    }

    public Long getBloqueoImporte() {
        return bloqueoImporte;
    }

    public void setBloqueoImporte(Long bloqueoImporte) {
        this.bloqueoImporte = bloqueoImporte;
    }

    public Long getBloqueoUnidades() {
        return bloqueoUnidades;
    }

    public void setBloqueoUnidades(Long bloqueoUnidades) {
        this.bloqueoUnidades = bloqueoUnidades;
    }

    public BigDecimal getImporteMaximo() {
        return importeMaximo;
    }

    public void setImporteMaximo(BigDecimal importeMaximo) {
        this.importeMaximo = importeMaximo;
    }

    public BigDecimal getMontoMaximo() {
        return montoMaximo;
    }

    public void setMontoMaximo(BigDecimal montoMaximo) {
        this.montoMaximo = montoMaximo;
    }


    public void setBloqueoAnterior(Long bloqueoAnterior) {
        this.bloqueoAnterior = bloqueoAnterior;
    }


    public Long getBloqueoAnterior() {
        return bloqueoAnterior;
    }
}