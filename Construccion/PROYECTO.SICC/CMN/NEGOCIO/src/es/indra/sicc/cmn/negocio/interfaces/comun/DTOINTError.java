package es.indra.sicc.cmn.negocio.interfaces.comun;

import java.io.Serializable;

public class DTOINTError implements Serializable
{
  private InterfazInfo interfazInfo;
  private IRegistroSicc registro;
  private String descripcion;

  public DTOINTError(InterfazInfo interfazInfo, IRegistroSicc registro, String descripcion )
  {
	this.interfazInfo = interfazInfo;
	this.registro = registro;
	this.descripcion = descripcion;
  }

  public InterfazInfo getInterfazInfo()
  {
    return interfazInfo;
  }

  public IRegistroSicc getRegistro()
  {
    return registro;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

}