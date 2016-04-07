package es.indra.sicc.cmn.negocio.interfaces;

import es.indra.sicc.cmn.negocio.interfaces.notificacion.Notificador;
import java.util.ArrayList;
import java.util.List;



public class InterfazDef 
{
  private String codigo;
  private String descripcion;
  private String tipo;
  private String extension;
  private String formatoCompresion;
  private String nivelLog;
  private String patronLog;
  private boolean logErrores;
  private boolean logTransferencia;
  private String tipoProcesamiento;
  private String tipoEjecucion;
  private String procesosRequisito;
  private String procesoPosterior;
  private String pathBuzonES;
  private String pathBuzonTemporal;
  private String pathBuzonHistorico;
  private Registro registro;
	private List notificadores;
	private Sistema sistemaOrigen;
	private Sistema sistemaDestino;
	private String patronNombreFicheros;
	private String pathLog;
    private boolean comillas;

  public InterfazDef()
  {
    notificadores = new ArrayList();
  }

  public String getCodigo()
  {
    return codigo;
  }

  public void setCodigo(String newCodigo)
  {
    codigo = newCodigo;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public void setDescripcion(String newDescripcion)
  {
    descripcion = newDescripcion;
  }

  public String getExtension()
  {
    return extension;
  }

  public void setExtension(String newExtension)
  {
    extension = newExtension;
  }

  public String getFormatoCompresion()
  {
    return formatoCompresion;
  }

  public void setFormatoCompresion(String newFormatoCompresion)
  {
    formatoCompresion = newFormatoCompresion;
  }

  public boolean isLogErrores()
  {
    return logErrores;
  }

  public void setLogErrores(boolean newLogErrores)
  {
    logErrores = newLogErrores;
  }

  public boolean isLogTransferencia()
  {
    return logTransferencia;
  }

  public void setLogTransferencia(boolean newLogTransferencia)
  {
    logTransferencia = newLogTransferencia;
  }

  public String getNivelLog()
  {
    return nivelLog;
  }

  public void setNivelLog(String newNivelLog)
  {
    nivelLog = newNivelLog;
  }

  public String getPathBuzonES()
  {
    return pathBuzonES;
  }

  public void setPathBuzonES(String newPathBuzonES)
  {
    pathBuzonES = newPathBuzonES;
  }

  public String getPathBuzonHistorico()
  {
    return pathBuzonHistorico;
  }

  public void setPathBuzonHistorico(String newPathBuzonHistorico)
  {
    pathBuzonHistorico = newPathBuzonHistorico;
  }

  public String getPathBuzonTemporal()
  {
    return pathBuzonTemporal;
  }

  public void setPathBuzonTemporal(String newPathBuzonTemporal)
  {
    pathBuzonTemporal = newPathBuzonTemporal;
  }

  public String getPatronLog()
  {
    return patronLog;
  }

  public void setPatronLog(String newPatronLog)
  {
    patronLog = newPatronLog;
  }

  public String getProcesoPosterior()
  {
    return procesoPosterior;
  }

  public void setProcesoPosterior(String newProcesoPosterior)
  {
    procesoPosterior = newProcesoPosterior;
  }

  public String getProcesosRequisito()
  {
    return procesosRequisito;
  }

  public void setProcesosRequisito(String newProcesosRequisito)
  {
    procesosRequisito = newProcesosRequisito;
  }

  public String getTipo()
  {
    return tipo;
  }

  public void setTipo(String newTipo)
  {
    tipo = newTipo;
  }

  public String getTipoEjecucion()
  {
    return tipoEjecucion;
  }

  public void setTipoEjecucion(String newTipoEjecucion)
  {
    tipoEjecucion = newTipoEjecucion;
  }

  public String getTipoProcesamiento()
  {
    return tipoProcesamiento;
  }

  public void setTipoProcesamiento(String newTipoProcesamiento)
  {
    tipoProcesamiento = newTipoProcesamiento;
  }

  public Registro getRegistro()
  {
    return registro;
  }

  public void setRegistro(Registro newRegistro)
  {
    registro = newRegistro;
  }

	public List getNotificadores() {
		return notificadores;
	}

	public void setNotificadores(List notificadores) {
		this.notificadores = notificadores;
	}

	public Sistema getSistemaOrigen() {
		return sistemaOrigen;
	}

	public void setSistemaOrigen(Sistema sistemaOrigen) {
		this.sistemaOrigen = sistemaOrigen;
	}

	public Sistema getSistemaDestino() {
		return sistemaDestino;
	}

	public void setSistemaDestino(Sistema sistemaDestino) {
		this.sistemaDestino = sistemaDestino;
	}

	public String getPatronNombreFicheros() {
		return patronNombreFicheros;
	}

	public void setPatronNombreFicheros(String patronNombreFicheros) {
		this.patronNombreFicheros = patronNombreFicheros;
	}

	public String getPathLog() {
		return pathLog;
	}

	public void setPathLog(String pathLog) {
		this.pathLog = pathLog;
	}

  public void anyadirNotificador( Notificador n )
  {
    notificadores.add( n );
  }

    public boolean isComillas() {
        return comillas;
    }

    public void setComillas(boolean comillas) {
        this.comillas = comillas;
    }



}