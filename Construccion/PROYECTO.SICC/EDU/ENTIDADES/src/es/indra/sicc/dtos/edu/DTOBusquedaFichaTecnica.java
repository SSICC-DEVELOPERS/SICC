package es.indra.sicc.dtos.edu;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Date;

public class DTOBusquedaFichaTecnica extends DTOSiccPaginacion{
  private Long oidTipoCurso;
  private String codigoCurso;
  private Date fechaDisponible;
  private Date fechaLanzamiento;
  private Date fechaFinCurso;
  
  public DTOBusquedaFichaTecnica() {
	
  }
  
  public Date getFechaDisponible(){
    return fechaDisponible;
  }

  public void setFechaDisponible(Date newFechaDisponible){
    fechaDisponible = newFechaDisponible;
  }

  public Date getFechaFinCurso(){
    return fechaFinCurso;
  }

  public void setFechaFinCurso(Date newFechaFinCurso){
    fechaFinCurso = newFechaFinCurso;
  }

  public Date getFechaLanzamiento(){
    return fechaLanzamiento;
  }

  public void setFechaLanzamiento(Date newFechaLanzamiento){
    fechaLanzamiento = newFechaLanzamiento;
  }

  public String getCodigoCurso(){
    return codigoCurso;
  }

  public void setCodigoCurso(String newCodigoCurso){
    codigoCurso = newCodigoCurso;
  }

  public Long getOidTipoCurso(){
    return oidTipoCurso;
  }

  public void setOidTipoCurso(Long newOidTipoCurso){
   oidTipoCurso = newOidTipoCurso;
  }

  
  
}