package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOINTCargaInicialStockDiarios extends DTOBelcorp  {

    private String codAlmacen;
    private String codProducto;
    private Long valorStock;

  public DTOINTCargaInicialStockDiarios() {
  }
  
  public String getCodAlmacen()
  {
        return codAlmacen;
  }

    public void setCodAlmacen(String codAlmacen)
    {
        this.codAlmacen = codAlmacen;
    }
    public String getCodProducto()
    {
        return codProducto;
    }

    public void setCodProducto(String codProducto)
    {
        this.codProducto = codProducto;
    }

    public Long getValorStock()
    {
        return valorStock;
    }

    public void setValorStock(Long valorStock)
    {
        this.valorStock = valorStock;
    }

}