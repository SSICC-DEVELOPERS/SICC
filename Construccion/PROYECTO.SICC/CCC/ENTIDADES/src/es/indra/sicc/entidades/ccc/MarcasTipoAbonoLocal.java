package es.indra.sicc.entidades.ccc;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="CCC_MARCA_TIPO_ABONO")
@NamedQueries({
@NamedQuery(name="MarcasTipoAbonoLocal.FindByTipoAbonoSubproceso",query="SELECT OBJECT(m) FROM MarcasTipoAbonoLocal AS m WHERE m.tipoAbonoSubproceso = ?1"),
@NamedQuery(name="MarcasTipoAbonoLocal.FindByTipoAbonoSubprocesoEoS",query="SELECT OBJECT(m) FROM MarcasTipoAbonoLocal AS m WHERE m.tipoAbonoSubproceso=?1 AND m.idEntradaSalida=?2")
})
public class MarcasTipoAbonoLocal implements Serializable {

	public MarcasTipoAbonoLocal() {}

	public MarcasTipoAbonoLocal(Long oid, Long tipoAbonoSubproceso)	{
	
		this.oid=oid;
                this.tipoAbonoSubproceso=tipoAbonoSubproceso;
	
	}

        public MarcasTipoAbonoLocal(Long oid, String idEntradaSalida, String observaciones, Long marca, Long tipoAbonoSubproceso) {
        
                this.oid=oid;
                this.tipoAbonoSubproceso=tipoAbonoSubproceso;
                this.idEntradaSalida=idEntradaSalida;
                this.observaciones=observaciones;
                this.marca=marca;                
        
        }

	@Id
	@Column(name="OID_MARC_TIPO_ABON")
	private Long oid;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="MASI_OID_MARC_SALI")
	private Long marca;
	@Column(name="IND_ENTR_SALI")
	private String idEntradaSalida;
	@Column(name="TASP_OID_TIPO_ABON_SUBP")
	private Long tipoAbonoSubproceso;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getMarca() {return marca;}
      
	public void setMarca(Long marca){this.marca=marca;}
		
	public String getIdEntradaSalida() {return idEntradaSalida;}
      
	public void setIdEntradaSalida(String idEntradaSalida){this.idEntradaSalida=idEntradaSalida;}
		
	public Long getTipoAbonoSubproceso() {return tipoAbonoSubproceso;}
      
	public void setTipoAbonoSubproceso(Long tipoAbonoSubproceso){this.tipoAbonoSubproceso=tipoAbonoSubproceso;}
			
	
}
