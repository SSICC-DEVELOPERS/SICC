package es.indra.sicc.dtos.seg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.lang.Long;
import java.lang.String;
import java.util.Vector;

public class AyudaDTO extends DTOAuditableSICC
{
  private Long oidAyuda;
  private Long oidFuncion;
  private String textoAyuda;
    private Vector vectorTraducciones;
  
  public AyudaDTO()
  {
    super();
  }

  public Long getOidAyuda()
  {
    return this.oidAyuda;
  }

  public void setOidAyuda(Long oidAyuda)
  {
    this.oidAyuda = oidAyuda;
    return;
  }


  public Long getOidFuncion()
  {
    return this.oidFuncion;
  }

  public void setOidFuncion(Long oidFuncion)
  {
    this.oidFuncion = oidFuncion;
    return;
  }




  public String getTextoAyuda()
  {
    return this.textoAyuda;
  }

  public void setTextoAyuda(String textoAyuda)
  {
    this.textoAyuda = textoAyuda;
    return;
  }

    public Vector getVectorTraducciones() {
        return vectorTraducciones;
    }

    public void setVectorTraducciones(Vector newVectorTraducciones) {
        vectorTraducciones = newVectorTraducciones;
    }
  
}