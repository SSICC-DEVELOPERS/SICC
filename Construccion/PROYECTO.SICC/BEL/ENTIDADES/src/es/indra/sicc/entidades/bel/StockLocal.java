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
@Table(name="BEL_STOCK")
@NamedQueries({
@NamedQuery(name="StockLocal.FindByClaveUnica",query="SELECT OBJECT(a) FROM StockLocal AS a WHERE a.almacen=?1 AND a.estadoMercancia=?2 AND a.producto=?3")
})
public class StockLocal implements Serializable {

	public StockLocal() {}

	public StockLocal(Long oid, Long almacen, Long estadoMercancia, Long producto, Long saldo) {
		this.oid=oid;
                this.almacen = almacen;
                this.estadoMercancia = estadoMercancia;
                this.producto = producto;
                this.saldo = saldo;
	}

	@Id
	@Column(name="OID_STOC")
	private Long oid;
	@Column(name="ALMC_OID_ALMA")
	private Long almacen;
	@Column(name="ESME_OID_ESTA_MERC")
	private Long estadoMercancia;
	@Column(name="PROD_OID_PROD")
	private Long producto;
	@Column(name="VAL_SALD")
	private Long saldo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getAlmacen() {return almacen;}
      
	public void setAlmacen(Long almacen){this.almacen=almacen;}
		
	public Long getEstadoMercancia() {return estadoMercancia;}
      
	public void setEstadoMercancia(Long estadoMercancia){this.estadoMercancia=estadoMercancia;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
		
	public Long getSaldo() {return saldo;}
      
	public void setSaldo(Long saldo){this.saldo=saldo;}
			
	
}
