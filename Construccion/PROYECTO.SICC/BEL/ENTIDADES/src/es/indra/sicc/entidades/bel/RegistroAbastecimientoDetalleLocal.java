package es.indra.sicc.entidades.bel;

import es.indra.mare.common.exception.MareException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_REGIS_ABAST_DETAL")
@NamedQueries({
@NamedQuery(name="RegistroAbastecimientoDetalleLocal.FindAll",query="select object(o) from RegistroAbastecimientoDetalleLocal o")
})
public class RegistroAbastecimientoDetalleLocal implements Serializable {

	public RegistroAbastecimientoDetalleLocal() {}

	public RegistroAbastecimientoDetalleLocal(Long oid, Long registroAbastecimientoCabecera, Long producto, Integer numeroLinea)	{
		this.oid=oid;
                this.registroAbastecimientoCabecera = registroAbastecimientoCabecera;
                this.producto = producto;
                this.numeroLinea = numeroLinea;
	}

	@Id
	@Column(name="OID_REGI_ABAS_DETA")
	private Long oid;
	@Column(name="NUM_STOC_MINI")
	private Long stockMinimo;
	@Column(name="NUM_STOC_MAXI")
	private Long stockMaximo;
	@Column(name="NUM_UNID_ENVI")
	private Long unidadesEnviadas;
	@Column(name="NUM_UNID_CONF")
	private Long unidadesConfirmadas;
	@Column(name="NUM_UNID_ATEN")
	private Long unidadesAtendidas;
	@Column(name="RABC_OID_REGI_ABAS_CABE")
	private Long registroAbastecimientoCabecera;
	@Column(name="PROD_OID_PROD")
	private Long producto;
	@Column(name="DEAT_OID_ESTA_ACTU")
	private Long tipoActuacion;
	@Column(name="NUM_LINE")
	private Integer numeroLinea;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getStockMinimo() {return stockMinimo;}
      
	public void setStockMinimo(Long stockMinimo){this.stockMinimo=stockMinimo;}
		
	public Long getStockMaximo() {return stockMaximo;}
      
	public void setStockMaximo(Long stockMaximo){this.stockMaximo=stockMaximo;}
		
	public Long getUnidadesEnviadas() {return unidadesEnviadas;}
      
	public void setUnidadesEnviadas(Long unidadesEnviadas){this.unidadesEnviadas=unidadesEnviadas;}
		
	public Long getUnidadesConfirmadas() {return unidadesConfirmadas;}
      
	public void setUnidadesConfirmadas(Long unidadesConfirmadas){this.unidadesConfirmadas=unidadesConfirmadas;}
		
	public Long getUnidadesAtendidas() {return unidadesAtendidas;}
      
	public void setUnidadesAtendidas(Long unidadesAtendidas){this.unidadesAtendidas=unidadesAtendidas;}
		
	public Long getRegistroAbastecimientoCabecera() {return registroAbastecimientoCabecera;}
      
	public void setRegistroAbastecimientoCabecera(Long registroAbastecimientoCabecera){this.registroAbastecimientoCabecera=registroAbastecimientoCabecera;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
		
	public Long getTipoActuacion() {return tipoActuacion;}
      
	public void setTipoActuacion(Long tipoActuacion){this.tipoActuacion=tipoActuacion;}
		
	public Integer getNumeroLinea() {return numeroLinea;}
      
	public void setNumeroLinea(Integer numeroLinea){this.numeroLinea=numeroLinea;}
			
	
}
