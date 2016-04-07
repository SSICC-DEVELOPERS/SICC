package es.indra.sicc.dtos.rec;
import es.indra.sicc.util.DTOBelcorp;

public class DTOIndicadoresOperacionREC extends DTOBelcorp {

    private Long oidOperacion;   
    private Long oidTipoOperacion;   
    private Boolean ingresaDevuelve;   
    private Boolean ingresaEnvia;   
    private Boolean devuelveFisicoFactura;   
    private Boolean devuelveFactura;   
    private Boolean enviaFactura;
    private Boolean devuelveGeneraEnvia;
    private Boolean enviaGeneraDevuelve;
    private String chequeoFisico;
    private Boolean indicadorAnulacion;
    private Boolean indicadorPerdida;
    private String precioEnvia;
    private Boolean indicadorRecojo;
    private String matriz;


    public DTOIndicadoresOperacionREC() {
        super();
    }

    public Boolean getDevuelveFactura()
    {
        return devuelveFactura;
    }

    public void setDevuelveFactura(Boolean devuelveFactura)
    {
        this.devuelveFactura = devuelveFactura;
    }

    public Boolean getDevuelveFisicoFactura()
    {
        return devuelveFisicoFactura;
    }

    public void setDevuelveFisicoFactura(Boolean devuelveFisicoFactura)
    {
        this.devuelveFisicoFactura = devuelveFisicoFactura;
    }

    public Boolean getEnviaFactura()
    {
        return enviaFactura;
    }

    public void setEnviaFactura(Boolean enviaFactura)
    {
        this.enviaFactura = enviaFactura;
    }

    public Boolean getIngresaDevuelve()
    {
        return ingresaDevuelve;
    }

    public void setIngresaDevuelve(Boolean ingresaDevuelve)
    {
        this.ingresaDevuelve = ingresaDevuelve;
    }

    public Boolean getIngresaEnvia()
    {
        return ingresaEnvia;
    }

    public void setIngresaEnvia(Boolean ingresaEnvia)
    {
        this.ingresaEnvia = ingresaEnvia;
    }

    public Long getOidOperacion()
    {
        return oidOperacion;
    }

    public void setOidOperacion(Long oidOperacion)
    {
        this.oidOperacion = oidOperacion;
    }

    public Long getOidTipoOperacion()
    {
        return oidTipoOperacion;
    }

    public void setOidTipoOperacion(Long oidTipoOperacion)
    {
        this.oidTipoOperacion = oidTipoOperacion;
    }

    public Boolean getDevuelveGeneraEnvia(){
        return devuelveGeneraEnvia;
    }

    public void setDevuelveGeneraEnvia(Boolean devuelveGeneraEnvia){
        this.devuelveGeneraEnvia = devuelveGeneraEnvia;
    }
    
    public Boolean getEnviaGeneraDevuelve(){
        return enviaGeneraDevuelve;
    }

    public void setEnviaGeneraDevuelve(Boolean enviaGeneraDevuelve){
        this.enviaGeneraDevuelve = enviaGeneraDevuelve;
    }

  public String getChequeoFisico() {
    return chequeoFisico;
  }

  public void setChequeoFisico(String chequeoFisico) {
    this.chequeoFisico = chequeoFisico;
  }

  public Boolean getIndicadorAnulacion() {
    return indicadorAnulacion;
  }

  public void setIndicadorAnulacion(Boolean indicadorAnulacion) {
    this.indicadorAnulacion = indicadorAnulacion;
  }

  public Boolean getIndicadorPerdida() {
    return indicadorPerdida;
  }

  public void setIndicadorPerdida(Boolean indicadorPerdida) {
    this.indicadorPerdida = indicadorPerdida;
  }

  public String getPrecioEnvia()
  {
    return precioEnvia;
  }

  public void setPrecioEnvia(String precioEnvia)
  {
    this.precioEnvia = precioEnvia;
  }

    public String getMatriz() {
        return matriz;
    }

    public void setMatriz(String matriz) {
        this.matriz = matriz;
    }


    public void setIndicadorRecojo(Boolean indicadorRecojo) {
        this.indicadorRecojo = indicadorRecojo;
    }

    public Boolean getIndicadorRecojo() {
        return indicadorRecojo;
    }
}
