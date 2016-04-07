package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOValidarClientes extends DTOAuditableSICC  {

        private String[] clientesVinculo;
        private String clienteContacto;
        private Long tipoClienteContacto;
        private Long subtipoCliente;
        private Long paisContactado;
        private Long[] paisesVinculo;
    private Integer edad; // Agregado por SICC20070433 - Rafael Romero - 24/09/2007 - Se agregan metodos de acceso

    public String getClienteContacto() {
        return clienteContacto;
    }

    public void setClienteContacto(String newClienteContacto) {
        clienteContacto = newClienteContacto;
    }

    public Long getPaisContactado() {
        return paisContactado;
    }

    public void setPaisContactado(Long newPaisContactado) {
        paisContactado = newPaisContactado;
    }

    public Long getSubtipoCliente() {
        return subtipoCliente;
    }

    public void setSubtipoCliente(Long newSubtipoCliente) {
        subtipoCliente = newSubtipoCliente;
    }

    public Long getTipoClienteContacto() {
        return tipoClienteContacto;
    }

    public void setTipoClienteContacto(Long newTipoClienteContacto) {
        tipoClienteContacto = newTipoClienteContacto;
    }

    public String[] getClientesVinculo() {
        return clientesVinculo;
    }

    public void setClientesVinculo(String[] newClientesVinculo) {
        clientesVinculo = newClientesVinculo;
    }

    public Long[] getPaisesVinculo() {
        return paisesVinculo;
    }

    public void setPaisesVinculo(Long[] newPaisesVinculo) {
        paisesVinculo = newPaisesVinculo;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }





}