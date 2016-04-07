package es.indra.sicc.dtos.intsys;

public class DTOMaestroTerritorios  {
    private String codPais;
    private String codSociedad;
    private String marcaEstructural;
    private String territorio;
    private String codZona;
    private String codRegion;
    private String canalBPS;
    private String subgerenciaVentas;
    private String seccion;

    public DTOMaestroTerritorios() {
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getCodSociedad() {
        return codSociedad;
    }

    public void setCodSociedad(String codSociedad) {
        this.codSociedad = codSociedad;
    }

    public String getMarcaEstructural() {
        return marcaEstructural;
    }

    public void setMarcaEstructural(String marcaEstructural) {
        this.marcaEstructural = marcaEstructural;
    }

    public String getTerritorio() {
        return territorio;
    }

    public void setTerritorio(String territorio) {
        this.territorio = territorio;
    }

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public String getCanalBPS() {
        return canalBPS;
    }

    public void setCanalBPS(String canalBPS) {
        this.canalBPS = canalBPS;
    }

    public String getSubgerenciaVentas() {
        return subgerenciaVentas;
    }

    public void setSubgerenciaVentas(String subgerenciaVentas) {
        this.subgerenciaVentas = subgerenciaVentas;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
}