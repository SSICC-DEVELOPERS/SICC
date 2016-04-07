package es.indra.sicc.entidades.bel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

import java.sql.Timestamp;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BEL_ALERT_STOCK")
@NamedQueries({
@NamedQuery(name="AlertasStockLocal.FindAll",query="select object(o) from AlertasStockLocal o")
})
public class AlertasStockLocal implements Serializable {

	public AlertasStockLocal() {}

	public AlertasStockLocal(Long oid, Timestamp fecAler, Long prodOidProd, Long subacceso, Long pais, BigDecimal indicador)	{
		this.oid=oid;
                this.fecha = fecAler;
                this.producto = prodOidProd;
                this.subacceso = subacceso;
                this.pais = pais;
                this.indicador = indicador;
	}
        
        public AlertasStockLocal(Long oid, Timestamp fecAler, Long prodOidProd)   {
                this.oid=oid;
                this.fecha = fecAler;
                this.producto = prodOidProd;
        }        

	@Id
	@Column(name="OID_ALER_STOC")
	private Long oid;
        @Column(name="FEC_ALER")
        //@Temporal(TemporalType.DATE)
        private java.sql.Timestamp fecha;
        @Column(name="SBAC_OID_SBAC")
	private Long subacceso;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="NUM_INDI")
	private java.math.BigDecimal indicador;
	@Column(name="PROD_OID_PROD")
	private Long producto;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.sql.Timestamp getFecha() {return fecha;}
      
	public void setFecha(java.sql.Timestamp fecha){this.fecha=fecha;}
		
	public Long getSubacceso() {return subacceso;}
      
	public void setSubacceso(Long subacceso){this.subacceso=subacceso;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public java.math.BigDecimal getIndicador() {return indicador;}
      
	public void setIndicador(java.math.BigDecimal indicador){this.indicador=indicador;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
			
	
}
