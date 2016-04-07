package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTOCronogramaGenerado extends DTOAuditableSICC 
{
  String mensaje;
  ArrayList cronograma;

  public DTOCronogramaGenerado()
  {
  }

  public String getMensaje()
  {
    return mensaje;
  }

  public void setMensaje(String mensaje)
  {
    this.mensaje = mensaje;
  }

  public ArrayList getCronograma()
  {
    return cronograma;
  }

  public void setCronograma(ArrayList cronograma)
  {
    this.cronograma = cronograma;
  }
}