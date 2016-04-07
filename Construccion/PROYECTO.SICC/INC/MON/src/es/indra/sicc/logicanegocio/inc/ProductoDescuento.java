package es.indra.sicc.logicanegocio.inc;
import java.io.Serializable;


/**
 * <p>Copyright 2005 © por Indra Sistemas,S.A - Todos los derechos reservados.<br>
 * Avda. de Bruselas, 35<br>
 * Parque Empresarial Arroyo de la Vega<br>
 * 28108 Alcobendas, Madrid<br>
 * España<br>
 * <p>Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * @date 28/04/2005
 * @author Gustavo Viñales
 */
public class ProductoDescuento implements Serializable {
    private Long oidProducto;
    private Long oidUnidadNegocio;
    private Long oidNegocio;
    private Long oidSuperGenerico;
    private Long oidGenerico;
    private Long oidMarcaProducto;

    public ProductoDescuento() {
    }

    public void setOidGenerico(Long oidGenerico) {
        this.oidGenerico = oidGenerico;
    }

    public Long getOidGenerico() {
        return oidGenerico;
    }

    public void setOidNegocio(Long oidNegocio) {
        this.oidNegocio = oidNegocio;
    }

    public Long getOidNegocio() {
        return oidNegocio;
    }

    public void setOidProducto(Long oidProducto) {
        this.oidProducto = oidProducto;
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidSuperGenerico(Long oidSuperGenerico) {
        this.oidSuperGenerico = oidSuperGenerico;
    }

    public Long getOidSuperGenerico() {
        return oidSuperGenerico;
    }

    public void setOidUnidadNegocio(Long oidUnidadNegocio) {
        this.oidUnidadNegocio = oidUnidadNegocio;
    }

    public Long getOidUnidadNegocio() {
        return oidUnidadNegocio;
    }

  public Long getOidMarcaProducto()
  {
    return oidMarcaProducto;
  }

  public void setOidMarcaProducto(Long oidMarcaProducto)
  {
    this.oidMarcaProducto = oidMarcaProducto;
  }
}
