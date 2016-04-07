package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOGestionStock  extends DTOAuditableSICC  {

 private String txtCodigoVenta;   
 private Long limiteVenta;
 private Boolean indUltNoticias;    
 private Boolean controlLiquidacion;    
 private Double valorPorcentual;    
 private Long valorUnidades;    
 private Long oid;    
 private Long codigoVenta;    
 private Long clasificacion;    
 private String txtClasificacion;    
 private Long tipoClasificacion;    
 private String txtTipoClasificacion;    
 private Long subtipoCliente;    
 private String txtSubtipoCliente;    
 private Long tipoCliente;    
 private String txtTipoCliente;    
 private Long region;    
 private String txtRegion;    
 private Long zona;    
 private String txtZona;    
 private String txtCatalogo;    
 private Integer numPagina;
  private Boolean indEliminar;
  private Integer indSecuencial;
  private Integer id;

	public DTOGestionStock() {
	}

	public String getTxtCodigoVenta(){
		return txtCodigoVenta;
	}

	public Long getLimiteVenta(){
		return limiteVenta;
	}

	public Boolean getIndUltNoticias(){
		return indUltNoticias;
	}

	public Boolean getControlLiquidacion(){
		return controlLiquidacion;
	}

	public Double getValorPorcentual(){
		return valorPorcentual;
	}

	public Long getValorUnidades(){
		return valorUnidades;
	}

	public Long getOid(){
		return oid;
	}

	public Long getCodigoVenta(){
		return codigoVenta;
	}

	public Long getClasificacion(){
		return clasificacion;
	}

	public String getTxtClasificacion(){
		return txtClasificacion;
	}

	public Long getTipoClasificacion(){
		return tipoClasificacion;
	}

	public String getTxtTipoClasificacion(){
		return txtTipoClasificacion;
	}

	public Long getSubtipoCliente(){
		return subtipoCliente;
	}

	public String getTxtSubtipoCliente(){
		return txtSubtipoCliente;
	}

	public Long getTipoCliente(){
		return tipoCliente;
	}

	public String getTxtTipoCliente(){
		return txtTipoCliente;
	}

	public Long getRegion(){
		return region;
	}

	public String getTxtRegion(){
		return txtRegion;
	}

	public Long getZona(){
		return zona;
	}

	public String getTxtZona(){
		return txtZona;
	}

	public String getTxtCatalogo(){
		return txtCatalogo;
	}

	public Integer getNumPagina(){
		return numPagina;
	}

	public void setTxtCodigoVenta(String newTxtCodigoVenta){
		txtCodigoVenta = newTxtCodigoVenta;
	}

	public void setLimiteVenta(Long newLimiteVenta){
		limiteVenta = newLimiteVenta;
	}

	public void setIndUltNoticias(Boolean newIndUltNoticias){
		indUltNoticias = newIndUltNoticias;
	}

	public void setControlLiquidacion(Boolean newControlLiquidacion){
		controlLiquidacion = newControlLiquidacion;
	}

	public void setValorPorcentual(Double newValorPorcentual){
		valorPorcentual = newValorPorcentual;
	}

	public void setValorUnidades(Long newValorUnidades){
		valorUnidades = newValorUnidades;
	}

	public void setOid(Long newOid){
		oid = newOid;
	}

	public void setCodigoVenta(Long newCodigoVenta){
		codigoVenta = newCodigoVenta;
	}

	public void setClasificacion(Long newClasificacion){
		clasificacion =  newClasificacion;
	}

	public void setTxtClasificacion(String newTxtClasificacion){
		txtClasificacion = newTxtClasificacion;
	}

	public void setTipoClasificacion(Long newTipoClasificacion){
		tipoClasificacion = newTipoClasificacion;
	}

	public void setTxtTipoClasificacion(String newTxtTipoClasificacion){
		txtTipoClasificacion = newTxtTipoClasificacion;
	}

	public void setSubtipoCliente(Long newSubtipoCliente){
		subtipoCliente = newSubtipoCliente;
	}

	public void setTxtSubtipoCliente(String newTxtSubtipoCliente){
		txtSubtipoCliente = newTxtSubtipoCliente;
	}

	public void setTipoCliente(Long newTipoCliente){
		tipoCliente = newTipoCliente;
	}

	public void setTxtTipoCliente(String newTxtTipoCliente){
		txtTipoCliente = newTxtTipoCliente;
	}

	public void setRegion(Long newRegion){
		region = newRegion;
	}

	public void setTxtRegion(String newTxtRegion){
		txtRegion = newTxtRegion;
	}

	public void setZona(Long newZona){
		zona = newZona;
	}

	public void setTxtZona(String newTxtZona){
		txtZona = newTxtZona;
	}

	public void setTxtCatalogo(String newTxtCatalogo){
		txtCatalogo = newTxtCatalogo;
	}

	public void setNumPagina(Integer newNumPagina){
		numPagina = newNumPagina;
	}

  public Boolean getIndEliminar(){
    return indEliminar;
  }

  public void setIndEliminar(Boolean newIndEliminar){
    indEliminar = newIndEliminar;
  }

  public Integer getIndSecuencial()
  {
    return indSecuencial;
  }

  public void setIndSecuencial(Integer newIndSecuencial)
  {
    indSecuencial = newIndSecuencial;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer newId)
  {
    id = newId;
  }
	
	
}