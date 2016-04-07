package es.indra.sicc.dtos.inc;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

/**
 * DTO para gestionar el paginado de la consulta de Metas Tipo Venta
 */
public class DTOMetTipVtaPag extends DTOSiccPaginacion{

    private String codCliente;
    private Long oidConcurso;

    public DTOMetTipVtaPag() {
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }
    
}