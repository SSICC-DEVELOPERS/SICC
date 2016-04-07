package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOObtenerPestanya4 extends DTOAuditableSICC  {

private Long[] subtipoCliente;
private Long[] marcasElegidas;

    public Long[] getMarcasElegidas() {
        return marcasElegidas;
    }

    public void setMarcasElegidas(Long[] newMarcasElegidas) {
        marcasElegidas = newMarcasElegidas;
    }

    public Long[] getSubtipoCliente() {
        return subtipoCliente;
    }

    public void setSubtipoCliente(Long[] newSubtipoCliente) {
        subtipoCliente = newSubtipoCliente;
    }

}