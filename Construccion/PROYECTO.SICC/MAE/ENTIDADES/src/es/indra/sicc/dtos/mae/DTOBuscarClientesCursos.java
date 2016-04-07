package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarClientesCursos extends DTOSiccPaginacion  {

    private Long marca;
    private Long canal;
    private String codigo;
    private Long subgerencia;
    private Long region;
    private Long zona;
    private Long seccion;
    private Long territorio;


    public DTOBuscarClientesCursos() {
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String newCodigo) {
        codigo = newCodigo;
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long newRegion) {
        region = newRegion;
    }

    public Long getSeccion() {
        return seccion;
    }

    public void setSeccion(Long newSeccion) {
        seccion = newSeccion;
    }

    public Long getSubgerencia() {
        return subgerencia;
    }

    public void setSubgerencia(Long newSubgerencia) {
        subgerencia = newSubgerencia;
    }

    public Long getTerritorio() {
        return territorio;
    }

    public void setTerritorio(Long newTerritorio) {
        territorio = newTerritorio;
    }

    public Long getZona() {
        return zona;
    }

    public void setZona(Long newZona) {
        zona = newZona;
    }

}