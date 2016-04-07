package es.indra.sicc.dtos.intsys;

public class DTOINTDirecciones  {
    private Long oid;
    private String codPais;
    private String codClie;
    private String codTipoDir;
    private String tipoVia;
    private String nombreVia;
    private String numero;
    private Integer interior;
    private Integer manzana;
    private Integer lote;
    private Integer kilometro;
    private String codUbiNivel1;
    private String codUbiNivel2;
    private String codUbiNivel3;
    private String codUbiNivel4;
    private String nivelSocioEcon;
    private Long coordX;
    private Long coordY;
    private Long coordZ;
    private String codTerri;
    private Character ctrlIntGeoreferenciador;

    public DTOINTDirecciones() {
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getCodClie() {
        return codClie;
    }

    public void setCodClie(String codClie) {
        this.codClie = codClie;
    }

    public String getCodTipoDir() {
        return codTipoDir;
    }

    public void setCodTipoDir(String codTipoDir) {
        this.codTipoDir = codTipoDir;
    }

    public String getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getInterior() {
        return interior;
    }

    public void setInterior(Integer interior) {
        this.interior = interior;
    }

    public Integer getManzana() {
        return manzana;
    }

    public void setManzana(Integer manzana) {
        this.manzana = manzana;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public Integer getKilometro() {
        return kilometro;
    }

    public void setKilometro(Integer kilometro) {
        this.kilometro = kilometro;
    }

    public String getCodUbiNivel1() {
        return codUbiNivel1;
    }

    public void setCodUbiNivel1(String codUbiNivel1) {
        this.codUbiNivel1 = codUbiNivel1;
    }

    public String getCodUbiNivel2() {
        return codUbiNivel2;
    }

    public void setCodUbiNivel2(String codUbiNivel2) {
        this.codUbiNivel2 = codUbiNivel2;
    }

    public String getCodUbiNivel3() {
        return codUbiNivel3;
    }

    public void setCodUbiNivel3(String codUbiNivel3) {
        this.codUbiNivel3 = codUbiNivel3;
    }

    public String getCodUbiNivel4() {
        return codUbiNivel4;
    }

    public void setCodUbiNivel4(String codUbiNivel4) {
        this.codUbiNivel4 = codUbiNivel4;
    }

    public String getNivelSocioEcon() {
        return nivelSocioEcon;
    }

    public void setNivelSocioEcon(String nivelSocioEcon) {
        this.nivelSocioEcon = nivelSocioEcon;
    }

    public Long getCoordX() {
        return coordX;
    }

    public void setCoordX(Long coordX) {
        this.coordX = coordX;
    }

    public Long getCoordY() {
        return coordY;
    }

    public void setCoordY(Long coordY) {
        this.coordY = coordY;
    }

    public Long getCoordZ() {
        return coordZ;
    }

    public void setCoordZ(Long coordZ) {
        this.coordZ = coordZ;
    }

    public String getCodTerri() {
        return codTerri;
    }

    public void setCodTerri(String codTerri) {
        this.codTerri = codTerri;
    }

    public Character getCtrlIntGeoreferenciador() {
        return ctrlIntGeoreferenciador;
    }

    public void setCtrlIntGeoreferenciador(Character ctrlIntGeoreferenciador) {
        this.ctrlIntGeoreferenciador = ctrlIntGeoreferenciador;
    }
}