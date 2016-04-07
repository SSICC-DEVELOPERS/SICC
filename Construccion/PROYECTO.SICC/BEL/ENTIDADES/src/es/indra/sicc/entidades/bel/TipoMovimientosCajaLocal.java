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
@Table(name="BEL_TIPO_MOVIM_CAJA")
public class TipoMovimientosCajaLocal implements Serializable {

	public TipoMovimientosCajaLocal() {}

	public TipoMovimientosCajaLocal(Long oid, String descripcion, String signo, Character indicador) {
		this.oid=oid;
                this.descripcion = descripcion;
                this.signo = signo;
                this.indicador = indicador;
	}

	@Id
	@Column(name="OID_TIPO_MOVI_CAJA")
	private Long oid;
	@Column(name="DES_TIPO_MOVI_CAJA")
	private String descripcion;
	@Column(name="VAL_SIGN")
	private String signo;
	@Column(name="IND_AUTO")
	private Character indicador;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public String getSigno() {return signo;}
      
	public void setSigno(String signo){this.signo=signo;}
		
	public Character getIndicador() {return indicador;}
      
	public void setIndicador(Character indicador){this.indicador=indicador;}
			
	
}
