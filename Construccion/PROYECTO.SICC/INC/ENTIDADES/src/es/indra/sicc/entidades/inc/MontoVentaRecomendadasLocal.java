package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_MONTO_VENTA_RECOM")
@NamedQueries({
@NamedQuery(name="MontoVentaRecomendadasLocal.FindAll",query="select object(o) from MontoVentaRecomendadasLocal o"),
@NamedQuery(name="MontoVentaRecomendadasLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM MontoVentaRecomendadasLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class MontoVentaRecomendadasLocal implements Serializable {

	public MontoVentaRecomendadasLocal() {}

	public MontoVentaRecomendadasLocal(Long oid, Long copaOidParaGral, Long tmvrOidTipoMontVentReco)	{
	
		this.oid=oid;
                this.setConcurso(copaOidParaGral);
	        this.setTipoMontoVenta(tmvrOidTipoMontVentReco);
	
	}

	@Id
	@Column(name="OID_MONT_VENT_RECO")
	private Long oid;
	@Column(name="VAL_CANT_MONT_VENT")
	private java.math.BigDecimal cantidadMontoVenta;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="TMVR_OID_TIPO_MONT_VENT_RECO")
	private Long tipoMontoVenta;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public java.math.BigDecimal getCantidadMontoVenta() {return cantidadMontoVenta;}
      
	public void setCantidadMontoVenta(java.math.BigDecimal cantidadMontoVenta){this.cantidadMontoVenta=cantidadMontoVenta;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getTipoMontoVenta() {return tipoMontoVenta;}
      
	public void setTipoMontoVenta(Long tipoMontoVenta){this.tipoMontoVenta=tipoMontoVenta;}
			
	
}
