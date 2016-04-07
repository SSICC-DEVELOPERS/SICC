package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="INC_METAS_TIPO_VENTA")
@NamedQueries({
@NamedQuery(name="MetasTipoVentaLocal.FindAll",query="select object(o) from MetasTipoVentaLocal o"),
@NamedQuery(name="MetasTipoVentaLocal.FindByConcurso",query="SELECT OBJECT(a) FROM MetasTipoVentaLocal AS a WHERE a.concurso = ?1"),
@NamedQuery(name="MetasTipoVentaLocal.FindByConcursoCliente",query="SELECT OBJECT(a) FROM MetasTipoVentaLocal AS a WHERE a.concurso = ?1 AND a.cliente = ?2")
})
public class MetasTipoVentaLocal implements Serializable {

	public MetasTipoVentaLocal() {}

	public MetasTipoVentaLocal(Long oid, BigDecimal montoVenta, Integer unidadesVendidas, BigDecimal incremento, BigDecimal meta, Long cliente, Long concurso)	{
	
		this.oid=oid;
                this.setMontoVenta(montoVenta);
                this.setUnidadesVendidas(unidadesVendidas);
                this.setIncremento(incremento);
                this.setMeta(meta);
                this.setCliente(cliente);
                this.setConcurso(concurso);
	
	}
        
        public MetasTipoVentaLocal(Long oid, BigDecimal valMeta, Long clieOidClie, Long copaOidParaGral)      {
        
                this.oid=oid;
                this.setMeta(valMeta);
                this.setCliente(clieOidClie);
                this.setConcurso(copaOidParaGral);
        
        }

	@Id
	@Column(name="OID_META_TIPO_VENTA")
	private Long oid;
	@Column(name="IMP_MONTO_VENTA")
	private java.math.BigDecimal montoVenta;
	@Column(name="NUM_UNID_VEND")
	private Integer unidadesVendidas;
	@Column(name="VAL_INCR")
	private java.math.BigDecimal incremento;
	@Column(name="VAL_META")
	private java.math.BigDecimal meta;
	@Column(name="CLIE_OID_CLIE")
	private Long cliente;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getMontoVenta() {return montoVenta;}
      
	public void setMontoVenta(java.math.BigDecimal montoVenta){this.montoVenta=montoVenta;}
		
	public Integer getUnidadesVendidas() {return unidadesVendidas;}
      
	public void setUnidadesVendidas(Integer unidadesVendidas){this.unidadesVendidas=unidadesVendidas;}
		
	public java.math.BigDecimal getIncremento() {return incremento;}
      
	public void setIncremento(java.math.BigDecimal incremento){this.incremento=incremento;}
		
	public java.math.BigDecimal getMeta() {return meta;}
      
	public void setMeta(java.math.BigDecimal meta){this.meta=meta;}
		
	public Long getCliente() {return cliente;}
      
	public void setCliente(Long cliente){this.cliente=cliente;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
			
	
}
