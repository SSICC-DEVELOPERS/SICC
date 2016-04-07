package es.indra.sicc.dtos.rec;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.util.DTOBelcorp;

public class DTOBuscarEnvia extends DTOSiccPaginacion {
    
    private Long oidCliente;
    private Long oidNumDocumento;
    private Long oidOperacion;
    private String indicadorMatriz;
  private String codigoVenta;
    
    public DTOBuscarEnvia() {
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public Long getOidNumDocumento() {
        return oidNumDocumento;
    }

    public void setOidNumDocumento(Long oidNumDocumento) {
        this.oidNumDocumento = oidNumDocumento;
    }

    public Long getOidOperacion() {
        return oidOperacion;
    }

    public void setOidOperacion(Long oidOperacion) {
        this.oidOperacion = oidOperacion;
    }

    public String getIndicadorMatriz() {
        return indicadorMatriz;
    }

    public void setIndicadorMatriz(String indicadorMatriz) {
        this.indicadorMatriz = indicadorMatriz;
    }

  public String getCodigoVenta()
  {
    return codigoVenta;
  }

  public void setCodigoVenta(String codigoVenta)
  {
    this.codigoVenta = codigoVenta;
  }
}