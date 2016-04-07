package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.util.DTOBelcorp;

public class DTOFACFormulario extends DTOBelcorp
{
 

 
private Long oidFormulario;
private String codFormulario;
private Long numLineas;      
private String valTamañoFormulario;
private String rutinaDiseñoFormulario;
private boolean indicadorImpresion;     
private boolean indicadorDePreimpreso;
private boolean indicadorSpoolIndividual;
private Long oidSecuanciaTecnologia;
private String nombreFormulario; 
private boolean indicadorActivo;
private boolean indicadorNumeracionOficial;
private Long numeroLineasParaSaltoPagina;
private Long oidTipoDocumentoLegal;
private Long oidDestinoImpresion;
private Long oidTipoFormulario;
private Long oidImpresoraVirtual;      
private Long oidNumOrdenSecuencia;      
 
 
 
 
  public DTOFACFormulario()
  {
  }

  public String getCodFormulario()
  {
    return codFormulario;
  }

  public void setCodFormulario(String newCodFormulario)
  {
    codFormulario = newCodFormulario;
  }

  public boolean isIndicadorActivo()
  {
    return indicadorActivo;
  }
  
  public boolean getIndicadorActivo()
  {
    return indicadorActivo;
  }

  public void setIndicadorActivo(boolean newIndicadorActivo)
  {
    indicadorActivo = newIndicadorActivo;
  }

  public boolean isIndicadorDePreimpreso()
  {
    return indicadorDePreimpreso;
  }
  
  public boolean getIndicadorDePreimpreso()
  {
    return indicadorDePreimpreso;
  }

  public void setIndicadorDePreimpreso(boolean newIndicadorDePreimpreso)
  {
    indicadorDePreimpreso = newIndicadorDePreimpreso;
  }

  public boolean isIndicadorImpresion()
  {
    return indicadorImpresion;
  }
  
  public boolean getIndicadorImpresion()
  {
    return indicadorImpresion;
  }

  public void setIndicadorImpresion(boolean newIndicadorImpresion)
  {
    indicadorImpresion = newIndicadorImpresion;
  }

  public boolean isIndicadorNumeracionOficial()
  {
    return indicadorNumeracionOficial;
  }
  
  public boolean getIndicadorNumeracionOficial()
  {
    return indicadorNumeracionOficial;
  }

  public void setIndicadorNumeracionOficial(boolean newIndicadorNumeracionOficial)
  {
    indicadorNumeracionOficial = newIndicadorNumeracionOficial;
  }

  public boolean isIndicadorSpoolIndividual()
  {
    return indicadorSpoolIndividual;
  }
  
  public boolean getIndicadorSpoolIndividual()
  {
    return indicadorSpoolIndividual;
  }

  public void setIndicadorSpoolIndividual(boolean newIndicadorSpoolIndividual)
  {
    indicadorSpoolIndividual = newIndicadorSpoolIndividual;
  }

  public String getNombreFormulario()
  {
    return nombreFormulario;
  }

  public void setNombreFormulario(String newNombreFormulario)
  {
    nombreFormulario = newNombreFormulario;
  }

  public String getValTamañoFormulario()
  {
    return valTamañoFormulario;
  }

  public void setValTamañoFormulario(String newValTamañoFormulario)
  {
    valTamañoFormulario = newValTamañoFormulario;
  }

  public String getRutinaDiseñoFormulario()
  {
    return rutinaDiseñoFormulario;
  }

  public void setRutinaDiseñoFormulario(String newRutinaDiseñoFormulario)
  {
    rutinaDiseñoFormulario = newRutinaDiseñoFormulario;
  }

  public Long getOidTipoFormulario()
  {
    return oidTipoFormulario;
  }

  public void setOidTipoFormulario(Long newOidTipoFormulario)
  {
    oidTipoFormulario = newOidTipoFormulario;
  }

  public Long getOidTipoDocumentoLegal()
  {
    return oidTipoDocumentoLegal;
  }

  public void setOidTipoDocumentoLegal(Long newOidTipoDocumentoLegal)
  {
    oidTipoDocumentoLegal = newOidTipoDocumentoLegal;
  }

  public Long getOidSecuanciaTecnologia()
  {
    return oidSecuanciaTecnologia;
  }

  public void setOidSecuanciaTecnologia(Long newOidSecuanciaTecnologia)
  {
    oidSecuanciaTecnologia = newOidSecuanciaTecnologia;
  }

  public Long getOidNumOrdenSecuencia()
  {
    return oidNumOrdenSecuencia;
  }

  public void setOidNumOrdenSecuencia(Long newOidNumOrdenSecuencia)
  {
    oidNumOrdenSecuencia = newOidNumOrdenSecuencia;
  }

  public Long getOidImpresoraVirtual()
  {
    return oidImpresoraVirtual;
  }

  public void setOidImpresoraVirtual(Long newOidImpresoraVirtual)
  {
    oidImpresoraVirtual = newOidImpresoraVirtual;
  }

  public Long getOidFormulario()
  {
    return oidFormulario;
  }

  public void setOidFormulario(Long newOidFormulario)
  {
    oidFormulario = newOidFormulario;
  }

  public Long getOidDestinoImpresion()
  {
    return oidDestinoImpresion;
  }

  public void setOidDestinoImpresion(Long newOidDestinoImpresion)
  {
    oidDestinoImpresion = newOidDestinoImpresion;
  }

  public Long getNumeroLineasParaSaltoPagina()
  {
    return numeroLineasParaSaltoPagina;
  }

  public void setNumeroLineasParaSaltoPagina(Long newNumeroLineasParaSaltoPagina)
  {
    numeroLineasParaSaltoPagina = newNumeroLineasParaSaltoPagina;
  }

  public Long getNumLineas()
  {
    return numLineas;
  }

  public void setNumLineas(Long newNumLineas)
  {
    numLineas = newNumLineas;
  }

}