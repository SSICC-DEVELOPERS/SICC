package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name="CCC_DETAL_MARCA_ENTRA")
@NamedQueries({
@NamedQuery(name="MarcaDetalleLocal.FindByMarcaTipoAbonoSubproceso",query="SELECT OBJECT(d) FROM MarcaDetalleLocal AS d WHERE d.marcaTipoAbono = ?1 ")
})
public class MarcaDetalleLocal implements Serializable {

	public MarcaDetalleLocal() {}

	public MarcaDetalleLocal(Long oid, Long mtab_oid_marc_tipo_abon, Long masi_oid_marc_situ) {
	
		this.oid=oid;
                this.marcaTipoAbono=mtab_oid_marc_tipo_abon;
                this.marcaSituacion=masi_oid_marc_situ;                
	
	}

	@Id
	@Column(name="OID_DETA_MARC_ENTR")
	private Long oid;
	@Column(name="MTAB_OID_MARC_TIPO_ABON")
	private Long marcaTipoAbono;
	@Column(name="MASI_OID_MARC_SITU")
	private Long marcaSituacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getMarcaTipoAbono() {return marcaTipoAbono;}
      
	public void setMarcaTipoAbono(Long marcaTipoAbono){this.marcaTipoAbono=marcaTipoAbono;}
		
	public Long getMarcaSituacion() {return marcaSituacion;}
      
	public void setMarcaSituacion(Long marcaSituacion){this.marcaSituacion=marcaSituacion;}
			
	
}
