package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.ped.DTODetalleFlete;
import es.indra.sicc.util.DTOOIDs;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Vector;

public class DTOFlete extends DTOSiccPaginacion {

	private String descripcion;
	private String ubigeo;
	private Long oidUbigeo;
	private Long zona;
	private BigDecimal montoFijo;
	private BigDecimal tasa;
	private BigDecimal fleteMin;
	private BigDecimal fleteMax;
	private BigDecimal contraEntrega;
	private Long oid;
	private Long oidMarca;
	private Long oidCanal;
	private Long oidTipoDespacho;
	private Long oidTipoCliente;
	private Vector attriTraducible;
	private Long oidSubtipoCliente;
	private Long oidTipoClasificacion;
	private Long oidClasificacion;
        private ArrayList rangosFlete;
	


	public DTOFlete() {
	}

	public String getDescripcion(){
		return this.descripcion;
	}

	public String getUbigeo(){
		return this.ubigeo;
	}

	public Long getOidUbigeo(){
		return this.oidUbigeo;
	}	

	public Long getZona(){
		return this.zona;
	}

	public BigDecimal getMontoFijo(){
		return this.montoFijo;
	}

	public BigDecimal getTasa(){
		return this.tasa;
	}		
	
	public BigDecimal getFleteMin(){
		return this.fleteMin;
	}

	public BigDecimal getFleteMax(){
		return this.fleteMax;
	}

	public BigDecimal getContraEntrega(){
		return this.contraEntrega;
	}

	public Long getOid(){
		return this.oid;
	}

	public Long getOidMarca(){
		return this.oidMarca;
	}

	public Long getOidCanal(){
		return this.oidCanal;
	}

	public Long getOidTipoDespacho(){
		return this.oidTipoDespacho;
	}

	public Long getOidTipoCliente(){
		return this.oidTipoCliente;
	}

	public Vector getAttriTraducible(){
		return this.attriTraducible;
	}

	public Long getOidSubtipoCliente(){
		return this.oidSubtipoCliente;
	}

	public Long getOidTipoClasificacion(){
		return this.oidTipoClasificacion;
	}

	public Long getOidClasificacion(){
		return this.oidClasificacion;
	}
	
	public void setDescripcion(String newDescripcion){
		descripcion = newDescripcion;
	}

	public void setUbigeo(String newUbigeo){
		ubigeo = newUbigeo;
	}

	public void setOidUbigeo(Long newOidUbigeo){
		oidUbigeo = newOidUbigeo;
	}	

	public void setZona(Long newZona){
		zona = newZona;
	}

	public void setMontoFijo(BigDecimal newMontoFijo){
		montoFijo = newMontoFijo;
	}

	public void setTasa(BigDecimal newTasa){
		tasa = newTasa;
	}		
	
	public void setFleteMin(BigDecimal newFleteMin){
		fleteMin = newFleteMin;
	}

	public void setFleteMax(BigDecimal newFleteMax){
		fleteMax = newFleteMax;
	}

	public void setContraEntrega(BigDecimal  newContraEntrega){
		contraEntrega = newContraEntrega;
	}

	public void setOid(Long newOid){
		oid = newOid;
	}

	public void setOidMarca(Long newOidMarca){
		oidMarca = newOidMarca;
	}

	public void setOidCanal(Long newOidCanal){
		oidCanal = newOidCanal;
	}

	public void setOidTipoDespacho(Long newOidTipoDespacho){
		oidTipoDespacho = newOidTipoDespacho;
	}

	public void setOidTipoCliente(Long newOidTipoCliente){
		oidTipoCliente = newOidTipoCliente;
	}

	public void  setAttriTraducible(Vector newAttriTraducible){
		attriTraducible = newAttriTraducible;
	}

	public void setOidSubtipoCliente(Long newOidSubtipoCliente){
		oidSubtipoCliente = newOidSubtipoCliente;
	}

	public void setOidTipoClasificacion(Long newOidTipoClasificacion){
		oidTipoClasificacion = newOidTipoClasificacion;
	}

	public void setOidClasificacion(Long newOidClasificacion){
		oidClasificacion = newOidClasificacion;
	}

    public void setRangosFlete(ArrayList rangosFlete) {
        this.rangosFlete = rangosFlete;
    }

    public ArrayList getRangosFlete() {
        return rangosFlete;
    }
}
