package es.indra.sicc.logicanegocio.inc;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * BELC300024358 - gPineda - 18/10/2006
 */
public class MetaTipoVenta implements Serializable 
{

  private Long oid;
  private Long oidConcurso;
  private BigDecimal valMeta;
  private BigDecimal montoVenta;
  private Integer unidadesVendidas;  
  private BigDecimal valorIncremento;

  public MetaTipoVenta()
  {
  }
  public String toString()
  {
      StringBuffer st = new StringBuffer("");
      
      st.append(" oid: " + oid );
      st.append("\n oidConcurso: " + oidConcurso );
      st.append("\n valMeta: " + valMeta );
      st.append("\n montoVenta: " + montoVenta );
      st.append("\n unidadesVendidas: " + unidadesVendidas );
      st.append("\n valorIncremento: " + valorIncremento );
      
      return st.toString();
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }


  public Long getOid()
  {
    return oid;
  }


  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }


  public Long getOidConcurso()
  {
    return oidConcurso;
  }


  public void setValMeta(BigDecimal valMeta)
  {
    this.valMeta = valMeta;
  }


  public BigDecimal getValMeta()
  {
    return valMeta;
  }


  public void setMontoVenta(BigDecimal montoVenta)
  {
    this.montoVenta = montoVenta;
  }


  public BigDecimal getMontoVenta()
  {
    return montoVenta;
  }


  public void setUnidadesVendidas(Integer unidadesVendidas)
  {
    this.unidadesVendidas = unidadesVendidas;
  }


  public Integer getUnidadesVendidas()
  {
    return unidadesVendidas;
  }


  public void setValorIncremento(BigDecimal valorIncremento)
  {
    this.valorIncremento = valorIncremento;
  }


  public BigDecimal getValorIncremento()
  {
    return valorIncremento;
  }
  
  
}