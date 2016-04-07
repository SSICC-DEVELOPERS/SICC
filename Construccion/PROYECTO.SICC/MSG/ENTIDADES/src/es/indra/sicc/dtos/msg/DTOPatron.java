package es.indra.sicc.dtos.msg;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.ArrayList;

public class DTOPatron extends DTOSiccPaginacion {
   private Long oidPatron;
   private String codigo;
   private String descripcion;
   private Long oidFormulario;
   private String codigoFormulario;
   private Long oidMedioEnvio;
   private String descripcionMedioEnvio;
   private Boolean activo;
   private Boolean patronPeriodo;
   private Long oidPatronOrigen;
   private Long oidPeriodo;
   private Long oidPatronPeriodo;
   private ArrayList secciones;
   
   //inc. 14024
   private Long oidTipoPeriodo;
   private String desPeriodo;
   private String desTipoPeriodo;

   public void setOidPatron(Long oidPatron)
   {
      this.oidPatron = oidPatron;
   }

   public void setOidFormulario(Long oidFormulario)
   {
      this.oidFormulario = oidFormulario;
   }

   public void setOidMedioEnvio(Long oidMedioEnvio)
   {
      this.oidMedioEnvio = oidMedioEnvio;
   }

   public void setOidPatronOrigen(Long oidPatronOrigen)
   {
      this.oidPatronOrigen = oidPatronOrigen;
   }

   public void setOidPeriodo(Long oidPeriodo)
   {
      this.oidPeriodo = oidPeriodo;
   }

   public void setOidPatronPeriodo(Long oidPatronPeriodo)
   {
      this.oidPatronPeriodo = oidPatronPeriodo;
   }



   public void setDescripcion(String descripcion)
   {
      this.descripcion = descripcion;
   }

   public void setCodigoFormulario(String codigoFormulario)
   {
      this.codigoFormulario = codigoFormulario;
   }

   public void setDescripcionMedioEnvio(String descripcionMedioEnvio)
   {
      this.descripcionMedioEnvio = descripcionMedioEnvio;
   }

   public void setCodigo(String codigo)
   {
      this.codigo = codigo;
   }

   public void setActivo(Boolean activo)
   {
      this.activo = activo;
   }

   public void setPatronPeriodo(Boolean patronPeriodo)
   {
      this.patronPeriodo = patronPeriodo;
   }

   public Long getOidPatron()
   {
      return this.oidPatron;
   }

   public Long getOidFormulario()
   {
      return this.oidFormulario;
   }

   public Long getOidMedioEnvio()
   {
      return this.oidMedioEnvio;
   }

   public Long getOidPatronOrigen()
   {
      return this.oidPatronOrigen;
   }

   public Long getOidPeriodo()
   {
      return this.oidPeriodo;
   }



   public String getCodigo()
   {
      return this.codigo;
   }

   public String getDescripcion()
   {
      return this.descripcion;
   }

   public String getCodigoFormulario()
   {
      return this.codigoFormulario;
   }

   public String getDescripcionMedioEnvio()
   {
      return this.descripcionMedioEnvio;
   }

   public Boolean getActivo()
   {
      return this.activo;
   }

   public Boolean getPatronPeriodo()
   {
      return this.patronPeriodo;
   }
   
  public Long getOidPatronPeriodo()
   {
     return  this.oidPatronPeriodo;
   }

	public ArrayList getSecciones() {
		return secciones;
	}

	public void setSecciones(ArrayList newSecciones) {
		secciones = newSecciones;
	}


  public void setOidTipoPeriodo(Long oidTipoPeriodo)
  {
    this.oidTipoPeriodo = oidTipoPeriodo;
  }


  public Long getOidTipoPeriodo()
  {
    return oidTipoPeriodo;
  }


  public void setDesPeriodo(String desPeriodo)
  {
    this.desPeriodo = desPeriodo;
  }


  public String getDesPeriodo()
  {
    return desPeriodo;
  }


  public void setDesTipoPeriodo(String desTipoPeriodo)
  {
    this.desTipoPeriodo = desTipoPeriodo;
  }


  public String getDesTipoPeriodo()
  {
    return desTipoPeriodo;
  }
   
}