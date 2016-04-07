package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_PREMI_PUNTO")
@NamedQueries({
@NamedQuery(name="PremioPuntosLocal.FindAll",query="select object(o) from PremioPuntosLocal o"),
@NamedQuery(name="PremioPuntosLocal.FindByParametroNivelPremiacion",query="SELECT OBJECT(a) "
+ " FROM PremioPuntosLocal AS a "
+ " WHERE a.nivelPremiacion = ?1"),
@NamedQuery(name="PremioPuntosLocal.FindByUK",query="SELECT OBJECT(o) FROM PremioPuntosLocal o WHERE o.nivelPremiacion = ?1")
})
public class PremioPuntosLocal implements Serializable {

	public PremioPuntosLocal() {}

	public PremioPuntosLocal(Long oid, Integer numPrem, Long panpOidParaNivePrem, Long tppuOidTipoPremPunt, Long copaOidParaGral)	{
	
		this.oid=oid;
                this.setNumeroPremio(numPrem);
	        this.setNivelPremiacion(panpOidParaNivePrem);
	        this.setTipoPremioPuntos(tppuOidTipoPremPunt);
	        this.setConcursoDestino(copaOidParaGral);
	
	}

	@Id
	@Column(name="OID_PREM_PUNT")
	private Long oid;
	@Column(name="NUM_PREM")
	private Integer numeroPremio;
	@Column(name="VAL_CANT")
	private Integer cantidad;
	@Column(name="VAL_PORC")
	private java.math.BigDecimal porcentaje;
	@Column(name="PANP_OID_PARA_NIVE_PREM")
	private Long nivelPremiacion;
	@Column(name="TPPU_OID_TIPO_PREM_PUNT")
	private Long tipoPremioPuntos;
	@Column(name="COPA_OID_PARA_GRAL")
	private Long concursoDestino;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroPremio() {return numeroPremio;}
      
	public void setNumeroPremio(Integer numeroPremio){this.numeroPremio=numeroPremio;}
		
	public Integer getCantidad() {return cantidad;}
      
	public void setCantidad(Integer cantidad){this.cantidad=cantidad;}
		
	public java.math.BigDecimal getPorcentaje() {return porcentaje;}
      
	public void setPorcentaje(java.math.BigDecimal porcentaje){this.porcentaje=porcentaje;}
		
	public Long getNivelPremiacion() {return nivelPremiacion;}
      
	public void setNivelPremiacion(Long nivelPremiacion){this.nivelPremiacion=nivelPremiacion;}
		
	public Long getTipoPremioPuntos() {return tipoPremioPuntos;}
      
	public void setTipoPremioPuntos(Long tipoPremioPuntos){this.tipoPremioPuntos=tipoPremioPuntos;}
		
	public Long getConcursoDestino() {return concursoDestino;}
      
	public void setConcursoDestino(Long concursoDestino){this.concursoDestino=concursoDestino;}
			
	
}
