package es.indra.sicc.dtos.intsys;

public class DTOMaestroRegiones  {
    private String codPais;
    private String codRegion;
    private String descripcionRegion;
    private String codSociedad;
    private String marcaEstructural;
    private String canalBPS;
    private String subgerenciaVentas;

    public DTOMaestroRegiones() {
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getCodRegion() {
        return codRegion;
    }

    public void setCodRegion(String codRegion) {
        this.codRegion = codRegion;
    }

    public String getDescripcionRegion() {
        return descripcionRegion;
    }

    public void setDescripcionRegion(String descripcionRegion) {
        this.descripcionRegion = descripcionRegion;
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