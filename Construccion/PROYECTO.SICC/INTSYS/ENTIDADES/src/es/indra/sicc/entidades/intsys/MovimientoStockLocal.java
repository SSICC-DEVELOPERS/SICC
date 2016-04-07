package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_MOVIM_STOCK")
@NamedQueries({
@NamedQuery(name="MovimientoStockLocal.FindAll",query="select object(o) from MovimientoStockLocal o"),
@NamedQuery(name="MovimientoStockLocal.FindByUK",query="select object(i) from MovimientoStockLocal i where i.oidPais=?1")
})
public class MovimientoStockLocal implements Serializable {

	public MovimientoStockLocal() {}

	public MovimientoStockLocal(Long oid, Long tmalOidTipoNegaAlma, Long paisOidPais, Long tmalOidTipoMoviAlma) {
            this.oid=oid;
	    this.tipoMovNegativo=tmalOidTipoNegaAlma;
	    this.oidPais=paisOidPais;
	    this.tipoMovPositivo=tmalOidTipoMoviAlma;
	}

	@Column(name="TMAL_OID_TIPO_NEGA_ALMA")
	private Long tipoMovNegativo;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="TMAL_OID_TIPO_MOVI_ALMA")
	private Long tipoMovPositivo;
	@Id
	@Column(name="OID_MOVI_STOC")
	private Long oid;

	
	public Long getTipoMovNegativo() {return tipoMovNegativo;}
      
	public void setTipoMovNegativo(Long tipoMovNegativo){this.tipoMovNegativo=tipoMovNegativo;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getTipoMovPositivo() {return tipoMovPositivo;}
      
	public void setTipoMovPositivo(Long tipoMovPositivo){this.tipoMovPositivo=tipoMovPositivo;}
		
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
			
	
}
