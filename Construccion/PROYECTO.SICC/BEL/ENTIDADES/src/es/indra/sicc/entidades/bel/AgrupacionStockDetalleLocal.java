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
@Table(name="BEL_AGRUP_STOCK_DETAL")
@NamedQueries({
@NamedQuery(name="AgrupacionStockDetalleLocal.FindByAgrupacionStockCabecera",query="SELECT OBJECT(a) FROM AgrupacionStockDetalleLocal AS a WHERE a.agrupacionStockCabecera=?1")
})
public class AgrupacionStockDetalleLocal implements Serializable {

	public AgrupacionStockDetalleLocal() {}

	public AgrupacionStockDetalleLocal(Long oid, Long agrupacionStockCabecera, Long estadoMercancia, Character operacion) {	
		this.oid=oid;
                this.agrupacionStockCabecera = agrupacionStockCabecera;
                this.estadoMercancia = estadoMercancia;
                this.operacion = operacion;
	}

	@Id
	@Column(name="OID_AGRU_STOC_DETA")
	private Long oid;
	@Column(name="AGSC_OID_AGRU_STOC_CABE")
	private Long agrupacionStockCabecera;
	@Column(name="ESME_OID_ESTA_MERC")
	private Long estadoMercancia;
	@Column(name="COD_OPER")
	private Character operacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getAgrupacionStockCabecera() {return agrupacionStockCabecera;}
      
	public void setAgrupacionStockCabecera(Long agrupacionStockCabecera){this.agrupacionStockCabecera=agrupacionStockCabecera;}
		
	public Long getEstadoMercancia() {return estadoMercancia;}
      
	public void setEstadoMercancia(Long estadoMercancia){this.estadoMercancia=estadoMercancia;}
		
	public Character getOperacion() {return operacion;}
      
	public void setOperacion(Character operacion){this.operacion=operacion;}
			
	
}
