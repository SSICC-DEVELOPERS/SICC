package es.indra.sicc.dtos.ccc;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Date;

public class DTOBuscarLotesTrabajo extends DTOSiccPaginacion  {

    private String numeroLote;
    private Date fechaMovimiento;
    private Long cuentaCorriente;
    private Long banco;

    public Long getBanco() {
        return banco;
    }

    public void setBanco(Long newBanco) {
        banco = newBanco;
    }

    public Long getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(Long newCuentaCorriente) {
        cuentaCorriente = newCuentaCorriente;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date newFechaMovimiento) {
        fechaMovimiento = newFechaMovimiento;
    }


    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String newNumeroLote) {
        numeroLote = newNumeroLote;
    }

}