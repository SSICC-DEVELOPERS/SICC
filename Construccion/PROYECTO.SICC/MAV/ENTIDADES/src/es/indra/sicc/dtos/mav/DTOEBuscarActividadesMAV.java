package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEBuscarActividadesMAV  extends DTOSiccPaginacion{
  private Long codigo;
  private String descripcion;
  private Long canal;
	private Long marca;

  public DTOEBuscarActividadesMAV() {
  }

  public Long getCodigo() {
    return codigo;
  }

  public void setCodigo(Long newCodigo) {
    codigo = newCodigo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String newDescripcion) {
    descripcion = newDescripcion;
  }

  public Long getCanal() {
		return canal;
  }

  public void setCanal(Long newCanal) {
		canal = newCanal;
  }

	public Long getMarca() {
		return marca;
	}

	public void setMarca(Long newMarca) {
		marca = newMarca;
	}
}