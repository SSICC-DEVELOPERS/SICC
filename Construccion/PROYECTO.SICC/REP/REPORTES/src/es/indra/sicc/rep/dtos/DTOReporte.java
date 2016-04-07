package es.indra.sicc.rep.dtos;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.HashMap;

public class DTOReporte extends DTOAuditableSICC{
    private String  idReporte;
    private HashMap parametros; 
    private byte[]  resultados;
    private String  nombreResultados;
    private Long oidReporte;
  
    public DTOReporte(){
    }

    public String getIdReporte(){
      return idReporte;
    }
  
    public void setIdReporte(String idReporte){
      this.idReporte = idReporte;
    }

    public HashMap getParametros(){
      return parametros;
    }
  
    public void setParametros(HashMap parametros){
      this.parametros = parametros;
    }

    public byte[] getResultados(){
      return resultados;
    }
  
    public void setResultados(byte[] resultados){
      this.resultados = resultados;
    }

    public void setNombreResultados(String nombre)
    {
      this.nombreResultados = nombre;
    }
    
    public String getNombreResultados()
    {
      return nombreResultados;
    }

    public void setOidReporte(Long oid)
    {
      this.oidReporte = oid;
    }
    
    public Long getOidReporte()
    {
      return oidReporte;
    }
   
}