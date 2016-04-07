package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOParametroDBP extends DTOSiccPaginacion  {
    private Long oidParametro;
    private String codigo;
    private String valor;
    private String entidad;
    private String campo;
    private String nombreParametro;
    private String nomCampoOidEntidad;
    private Long oidActividad;

    public DTOParametroDBP() {
    }

    public Long getOidParametro() {
        return oidParametro;
    }

    public void setOidParametro(Long oidParametro) {
        this.oidParametro = oidParametro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    public String getNomCampoOidEntidad() {
        return nomCampoOidEntidad;
    }

    public void setNomCampoOidEntidad(String nomCampoOidEntidad) {
        this.nomCampoOidEntidad = nomCampoOidEntidad;
    }

    public Long getOidActividad() {
        return oidActividad;
    }

    public void setOidActividad(Long oidActividad) {
        this.oidActividad = oidActividad;
    }
}