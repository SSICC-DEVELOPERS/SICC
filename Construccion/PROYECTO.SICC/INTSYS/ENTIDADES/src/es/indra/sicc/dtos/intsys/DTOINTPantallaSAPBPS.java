package es.indra.sicc.dtos.intsys;

public class DTOINTPantallaSAPBPS extends DTOEnviarPedidosSAP  {
	private Long marca;
	private Long canal;
	private Long periodo;
  
  /* SICC-GCC-INT-SAB-004 - dmorello, 23/11/2006 */
  private String codigo;

	public DTOINTPantallaSAPBPS() {
	}

	public Long getMarca() {
		return marca;
	}

	public void setMarca(Long marca) {
		this.marca = marca;
	}

	public Long getCanal() {
		return canal;
	}

	public void setCanal(Long canal) {
		this.canal = canal;
	}

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long periodo) {
		this.periodo = periodo;
	}

  public String getCodigo()
  {
    return codigo;
  }

  public void setCodigo(String codigo)
  {
    this.codigo = codigo;
  }
}