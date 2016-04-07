package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOReimprimirFichasInscripcion extends DTOAuditableSICC  {
    private Long[] clientes;
    private String motivos;

    public DTOReimprimirFichasInscripcion() {
    
    }

    public DTOReimprimirFichasInscripcion(Long[] clientes, String motivos) {
    setClientes(clientes);
    setMotivos(motivos);
    }
    public Long[] getClientes() {
        return clientes;
    }

    public void setClientes(Long[] newClientes) {
        clientes = newClientes;
    }

    public String getMotivos() {
        return motivos;
    }

    public void setMotivos(String newMotivos) {
        motivos = newMotivos;
    }
}