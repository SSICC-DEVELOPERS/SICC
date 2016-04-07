package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;


public class DTOFACDocumentoContable extends DTOBelcorp  {

	private DTOFACDocumentoContableCabecera cabecera;
	private ArrayList detalle;
    private ArrayList movimientos; //añadido por incidencia 11135

  public DTOFACDocumentoContable()
  {
    detalle=new ArrayList();
    movimientos = new ArrayList();
  }
  
  
  public DTOFACDocumentoContableCabecera getCabecera() {
		return this.cabecera;
	}

	public void setCabecera(DTOFACDocumentoContableCabecera newCabecera) {
		this.cabecera = newCabecera;
	}

	public ArrayList getDetalle() {
		return this.detalle;
	}

	public void setDetalle(ArrayList newDetalle) {
		this.detalle = newDetalle;
	}

  public void addDetelle(Object entrada)
  {
    detalle.add(entrada);
  }
  
  public ArrayList getMovimientos() {
		return this.movimientos;
	}

	public void setMovimientos(ArrayList newMovimientos) {
		this.movimientos = newMovimientos;
	}

  public void addMovimientos(Object entrada)
  {
    movimientos.add(entrada);
  }
  
}