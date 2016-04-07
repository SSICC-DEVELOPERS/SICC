package es.indra.sicc.entidades.inc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INC_LOTE_PREMI_ARTIC")
@NamedQueries({
@NamedQuery(name="LotePremioArticulosLocal.FindAll",query="select object(o) from LotePremioArticulosLocal o"),
@NamedQuery(name="LotePremioArticulosLocal.FindByLotePremioArticulo",query="SELECT OBJECT(a) "
+ " FROM LotePremioArticulosLocal AS a "
+ " WHERE a.premioArticulo = ?1")
})
public class LotePremioArticulosLocal implements Serializable {

	public LotePremioArticulosLocal() {}

	public LotePremioArticulosLocal(Long oid, Integer numLote, Integer numPrem, Long prarOidPremArti)	{
	
		this.oid=oid;
                this.setNumeroLote(numLote);
	        this.setNumeroPremio(numPrem);
	        this.setPremioArticulo(prarOidPremArti);
	
	}

	@Id
	@Column(name="OID_LOTE_PREM_ARTI")
	private Long oid;
	@Column(name="NUM_LOTE")
	private Integer numeroLote;
	@Column(name="NUM_PREM")
	private Integer numeroPremio;
	@Column(name="PRAR_OID_PREM_ARTI")
	private Long premioArticulo;
	@Column(name="VAL_DESC_LOTE_PREM_ARTI")
	private String descripcion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNumeroLote() {return numeroLote;}
      
	public void setNumeroLote(Integer numeroLote){this.numeroLote=numeroLote;}
		
	public Integer getNumeroPremio() {return numeroPremio;}
      
	public void setNumeroPremio(Integer numeroPremio){this.numeroPremio=numeroPremio;}
		
	public Long getPremioArticulo() {return premioArticulo;}
      
	public void setPremioArticulo(Long premioArticulo){this.premioArticulo=premioArticulo;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
			
	
}
