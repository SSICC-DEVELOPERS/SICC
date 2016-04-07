package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOMetasTipoVenta extends DTOBelcorp 
{
  private Long oid;
  private BigDecimal impMontoVenta;
  private Integer numUnidadesVendidas;
  private BigDecimal valorIncremento;
  private BigDecimal valorMetas;
  private Long oidCliente;
  private String codigoCliente;
  private Long oidConcurso;
    // Agregado por HRCS - Fecha 06/07/2007
    private String dpCodCliente;
    private String dpNombre1;
    private String dpApellido1;
    private String dpCodZona;
    private String dpCodTerritorio;
    
  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public BigDecimal getImpMontoVenta()
  {
    return impMontoVenta;
  }

  public void setImpMontoVenta(BigDecimal impMontoVenta)
  {
    this.impMontoVenta = impMontoVenta;
  }

  public Integer getNumUnidadesVendidas()
  {
    return numUnidadesVendidas;
  }

  public void setNumUnidadesVendidas(Integer numUnidadesVendidas)
  {
    this.numUnidadesVendidas = numUnidadesVendidas;
  }

  public BigDecimal getValorIncremento()
  {
    return valorIncremento;
  }

  public void setValorIncremento(BigDecimal valorIncremento)
  {
    this.valorIncremento = valorIncremento;
  }

  public BigDecimal getValorMetas()
  {
    return valorMetas;
  }

  public void setValorMetas(BigDecimal valorMetas)
  {
    this.valorMetas = valorMetas;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public String getCodigoCliente()
  {
    return codigoCliente;
  }

  public void setCodigoCliente(String codigoCliente)
  {
    this.codigoCliente = codigoCliente;
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }


    public void setDpCodCliente(String dpCodCliente) {
        this.dpCodCliente = dpCodCliente;
    }


    public String getDpCodCliente() {
        return dpCodCliente;
    }


    public void setDpCodZona(String dpCodZona) {
        this.dpCodZona = dpCodZona;
    }


    public String getDpCodZona() {
        return dpCodZona;
    }


    public void setDpCodTerritorio(String dpCodTerritorio) {
        this.dpCodTerritorio = dpCodTerritorio;
    }


    public String getDpCodTerritorio() {
        return dpCodTerritorio;
    }


    public void setDpNombre1(String dpNombre1) {
        this.dpNombre1 = dpNombre1;
    }


    public String getDpNombre1() {
        return dpNombre1;
    }


    public void setDpApellido1(String dpApellido1) {
        this.dpApellido1 = dpApellido1;
    }


    public String getDpApellido1() {
        return dpApellido1;
    }
}