package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTODatosPedSAP extends DTOBelcorp  {
	private Long oidPeriodo;
	private Long oidSubAcceso;
	private Long oidAlmacen;
	private Long oidSociedad;
	private Long oidTipoSolicitud;
	private Long oidTipoCliente;
  
  /* BELC300024598 - dmorello, 04/01/2007 - Creo estos dos campos: */
  private Long numOrdenesDia;
  private Long numPedidosAcumulados;
  
    private Long oidMarcaProducto;

	public DTODatosPedSAP() {
	}

	public Long getOidPeriodo() {
		return oidPeriodo;
	}

	public void setOidPeriodo(Long oidPeriodo) {
		this.oidPeriodo = oidPeriodo;
	}

	public Long getOidSubAcceso() {
		return oidSubAcceso;
	}

	public void setOidSubAcceso(Long oidSubAcceso) {
		this.oidSubAcceso = oidSubAcceso;
	}

	public Long getOidAlmacen() {
		return oidAlmacen;
	}

	public void setOidAlmacen(Long oidAlmacen) {
		this.oidAlmacen = oidAlmacen;
	}

	public Long getOidSociedad() {
		return oidSociedad;
	}

	public void setOidSociedad(Long oidSociedad) {
		this.oidSociedad = oidSociedad;
	}

	public Long getOidTipoSolicitud() {
		return oidTipoSolicitud;
	}

	public void setOidTipoSolicitud(Long oidTipoSolicitud) {
		this.oidTipoSolicitud = oidTipoSolicitud;
	}

	public Long getOidTipoCliente() {
		return oidTipoCliente;
	}

	public void setOidTipoCliente(Long oidTipoCliente) {
		this.oidTipoCliente = oidTipoCliente;
	}

  public Long getNumOrdenesDia()
  {
    return numOrdenesDia;
  }

  public void setNumOrdenesDia(Long numOrdenesDia)
  {
    this.numOrdenesDia = numOrdenesDia;
  }

  public Long getNumPedidosAcumulados()
  {
    return numPedidosAcumulados;
  }

  public void setNumPedidosAcumulados(Long numPedidosAcumulados)
  {
    this.numPedidosAcumulados = numPedidosAcumulados;
  }


    public void setOidMarcaProducto(Long oidMarcaProducto) {
        this.oidMarcaProducto = oidMarcaProducto;
    }


    public Long getOidMarcaProducto() {
        return oidMarcaProducto;
    }
}