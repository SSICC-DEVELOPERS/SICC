package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PUNTA_PRODU_EXIGI")
@NamedQueries({
@NamedQuery(name="PuntajeProductosExigidosLocal.FindAll",query="select object(o) from PuntajeProductosExigidosLocal o"),
@NamedQuery(name="PuntajeProductosExigidosLocal.FindByConcurso",query="SELECT OBJECT(a) "
+ " FROM PuntajeProductosExigidosLocal AS a "
+ " WHERE a.concurso = ?1")
})
public class PuntajeProductosExigidosLocal implements Serializable {

	public PuntajeProductosExigidosLocal() {}

	public PuntajeProductosExigidosLocal(Long oid, Double impMont, Long numUnid, Long numPunt, Long copaOidParaGral, Long pre2OidProdExig, Long socaOidSoliCabe)	{
	
		this.oid=oid;
                this.setMonto(impMont);
	        this.setUnidades(numUnid);
	        this.setPuntos(numPunt);
	        this.setConcurso(copaOidParaGral);
	        this.setProductoExigido(pre2OidProdExig);
	        this.setSolicitud(socaOidSoliCabe);
	
	}

	@Id
	@Column(name="OID_PUNT_PROD_EXIG")
	private Long oid;
	@Column(name="IMP_MONT")
	private Double monto;
	@Column(name="NUM_UNID")
	private Long unidades;
	@Column(name="NUM_PUNT")
	private Long puntos;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concurso;
	@Column(name="PRE2_OID_PROD_EXIG")
	private Long productoExigido;
	@Column(name="SOCA_OID_SOLI_CABE")
	private Long solicitud;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Double getMonto() {return monto;}
      
	public void setMonto(Double monto){this.monto=monto;}
		
	public Long getUnidades() {return unidades;}
      
	public void setUnidades(Long unidades){this.unidades=unidades;}
		
	public Long getPuntos() {return puntos;}
      
	public void setPuntos(Long puntos){this.puntos=puntos;}
		
	public Long getConcurso() {return concurso;}
      
	public void setConcurso(Long concurso){this.concurso=concurso;}
		
	public Long getProductoExigido() {return productoExigido;}
      
	public void setProductoExigido(Long productoExigido){this.productoExigido=productoExigido;}
		
	public Long getSolicitud() {return solicitud;}
      
	public void setSolicitud(Long solicitud){this.solicitud=solicitud;}
			
	
}
