package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTOSeccion extends DTOAuditableSICC {

	private Long oidPatron;
	private Long oidSeccion;
	private String codigo;
	private Integer ordenSecuencia;
	private Long oidMetacaracter;
	private String desMetacaracter;
	private ArrayList mensajes;
  private String literalIdentificador;

        // sapaza -- PER-SiCC-2013-1035 -- 24/09/2013
        private String literalSuperiorInicio;
        private String literalSuperiorFin;

	public void setOidPatron(Long oidPatron)
	{
      this.oidPatron = oidPatron;
    }

    public Long getOidPatron()
    {
      return this.oidPatron;
    }

    public void setOidSeccion(Long oidSeccion)
	{
	  this.oidSeccion = oidSeccion;
	}

    public Long getOidSeccion()
	{
	  return this.oidSeccion;
	}

	public void setCodigo(String codigo)
    {
      this.codigo = codigo;
    }

    public String getCodigo()
	{
      return this.codigo;
    }

	public void setOrdenSecuencia(Integer ordenSecuencia){
	  this.ordenSecuencia = ordenSecuencia;		
	}

	public Integer getOrdenSecuencia()
	{
	  return this.ordenSecuencia;
	}

	public Long getOidMetacaracter() {
		return oidMetacaracter;
	}

	public void setOidMetacaracter(Long newOidMetacaracter) {
		oidMetacaracter = newOidMetacaracter;
	}

	public String getDesMetacaracter() {
		return desMetacaracter;
	}

	public void setDesMetacaracter(String newDesMetacaracter) {
		desMetacaracter = newDesMetacaracter;
	}

	public ArrayList getMensajes() {
		return mensajes;
	}

	public void setMensajes(ArrayList newMensajes) {
		mensajes = newMensajes;
	}
  
   /**Incidencia BELC300013090 */
  public String getLiteralIdentificador()
  {
    return literalIdentificador;
  }

  public void setLiteralIdentificador(String literalIdentificador)
  {
    this.literalIdentificador = literalIdentificador;
  }

    public void setLiteralSuperiorInicio(String literalSuperiorInicio) {
        this.literalSuperiorInicio = literalSuperiorInicio;
    }

    public String getLiteralSuperiorInicio() {
        return literalSuperiorInicio;
    }

    public void setLiteralSuperiorFin(String literalSuperiorFin) {
        this.literalSuperiorFin = literalSuperiorFin;
    }

    public String getLiteralSuperiorFin() {
        return literalSuperiorFin;
    }
}
