package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="BEL_CONTR_ALMAC")
@NamedQueries({
@NamedQuery(name="ControlesDeAlmacenLocal.FindByUK",query="SELECT OBJECT(o) FROM ControlesDeAlmacenLocal o WHERE o.subAcceso = ?1 AND o.producto = ?2 AND o.almacen = ?3")
})
public class ControlesDeAlmacenLocal implements Serializable {

	public ControlesDeAlmacenLocal() {}

	public ControlesDeAlmacenLocal(Long oid, Long subAcceso, Long producto, Long almacen)	{
		this.oid=oid;
                this.subAcceso = subAcceso;
                this.producto = producto;
                this.almacen = almacen;
	
	}
        
    public ControlesDeAlmacenLocal(Long oid, Long subAcceso, Long producto, Long stockMinimo, Long stockMaximo, Long stockReposicion, Character activado, Long almacen)   {
            this.oid=oid;
            this.subAcceso = subAcceso;
            this.producto = producto;
            this.stockMinimo = stockMinimo;
            this.stockMaximo = stockMaximo;
            this.stockReposicion = stockReposicion;
            this.activado = activado;
            this.almacen = almacen;
    }        
        
	@Id
	@Column(name="OID_CTRL_ALMA")
	private Long oid;
	@Column(name="SBAC_OID_SBAC")
	private Long subAcceso;
	@Column(name="PROD_OID_PROD")
	private Long producto;
	@Column(name="VAL_STOC_MINI")
	private Long stockMinimo;
	@Column(name="VAL_STOC_MAXI")
	private Long stockMaximo;
	@Column(name="VAL_STOC_REPO")
	private Long stockReposicion;
	@Column(name="IND_ACTI")
	private Character activado;
	@Column(name="ALMC_OID_ALMA")
	private Long almacen;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getSubAcceso() {return subAcceso;}
      
	public void setSubAcceso(Long subAcceso){this.subAcceso=subAcceso;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
		
	public Long getStockMinimo() {return stockMinimo;}
      
	public void setStockMinimo(Long stockMinimo){this.stockMinimo=stockMinimo;}
		
	public Long getStockMaximo() {return stockMaximo;}
      
	public void setStockMaximo(Long stockMaximo){this.stockMaximo=stockMaximo;}
		
	public Long getStockReposicion() {return stockReposicion;}
      
	public void setStockReposicion(Long stockReposicion){this.stockReposicion=stockReposicion;}
		
	public Character getActivado() {return activado;}
      
	public void setActivado(Character activado){this.activado=activado;}
		
	public Long getAlmacen() {return almacen;}
      
	public void setAlmacen(Long almacen){this.almacen=almacen;}
			
	
}
