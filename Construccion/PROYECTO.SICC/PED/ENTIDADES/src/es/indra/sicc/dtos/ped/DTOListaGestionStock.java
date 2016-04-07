package es.indra.sicc.dtos.ped;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.ped.DTOGestionCV;
import es.indra.sicc.dtos.ped.DTOGestionStock;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import es.indra.sicc.util.DTOSalida;
import java.util.Vector;

public class DTOListaGestionStock  extends DTOSiccPaginacion {//extends DTOAuditableSICC {

	//private DTOGestionStock[] detalles;
	private Vector detalles;
  
	private Long eliminados;
	private Long marca;
	private Long canal;
	private Long periodo;
  
	//private DTOGestionCV[] codigosVenta;
	private Vector codigosVenta;
    private Long numID;
    
  
  private RecordSet resultado;
    private String codigoVentaBuscar;

	
	public DTOListaGestionStock(){}

	public Vector getDetalles(){
		return detalles;
	}
	
	public Long getEliminados(){
		return eliminados;
	}

    public Long getMarca(){
		return marca;
	}

	public Long getCanal(){
		return canal;
	}

	public Long getPeriodo(){
		return periodo;
	}

  public Vector getCodigosVenta(){
    return codigosVenta;
  }

	public void setDetalles(Vector newDetalles){
		this.detalles = newDetalles;
	}
	
	public void setEliminados(Long newEliminados){
		this.eliminados = newEliminados;
	}

    public void setMarca(Long newMarca){
		marca = newMarca;
	}

	public void setCanal(Long newCanal){
		canal = newCanal;
	}

	public void setPeriodo(Long newPeriodo){
		periodo = newPeriodo;
	}

  public void setCodigosVenta(Vector newCodigosVenta){
    codigosVenta = newCodigosVenta;
  }

  public Long getNumID(){
    return numID;
  }

  public void setNumID(Long newNumID){
    numID = newNumID;
  }
  
   public void setResultado(RecordSet resultado) {
      this.resultado = resultado;
   }

   public RecordSet getResultado() {
      return this.resultado;
   }

    public String getCodigoVentaBuscar()
    {
        return codigoVentaBuscar;
    }

    public void setCodigoVentaBuscar(String codigoVentaBuscar)
    {
        this.codigoVentaBuscar = codigoVentaBuscar;
    }
  	
}