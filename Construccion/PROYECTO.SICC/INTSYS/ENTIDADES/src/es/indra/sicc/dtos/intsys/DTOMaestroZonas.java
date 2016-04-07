package es.indra.sicc.dtos.intsys;

public class DTOMaestroZonas  {
    private String codPais;
    private String codZona;
    private String codRegion;
    private String descripcionZona;
    private String codSociedad;
    private String marcaEstructural;
    private String canalBPS;
    private String subgerenciaVentas;

    public DTOMaestroZonas() {
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
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

    public String getDescripcionZona() {
        return descripcionZona;
    }

    public void setDescripcionZona(String descripcionZona) {
        this.descripcionZona = descripcionZona;
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
}