package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="REC_MOTIV_DEVOL_OPERA")
@NamedQueries({
@NamedQuery(name="MotivosDevolucionOperacionLocal.FindAll",query="select object(o) from MotivosDevolucionOperacionLocal o")
})
public class MotivosDevolucionOperacionLocal implements Serializable {

	public MotivosDevolucionOperacionLocal() {}

	public MotivosDevolucionOperacionLocal(Long oid, Long codMotivoDevolucion, Long pais, Long operacion)	{
	
		this.oid=oid;
                this.codMotivoDevolucion=codMotivoDevolucion;
                this.pais=pais;
                this.operacion=operacion;
	
	}

	@Id
	@Column(name="OID_MOTI_DEVO_OPER")
	private Long oid;
	@Column(name="MODV_OID_MOTI_DEVO")
	private Long codMotivoDevolucion;
	@Column(name="VAL_MARC_DEFE")
	private Long marcaDefecto;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="ROPE_OID_OPER")
	private Long operacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCodMotivoDevolucion() {return codMotivoDevolucion;}
      
	public void setCodMotivoDevolucion(Long codMotivoDevolucion){this.codMotivoDevolucion=codMotivoDevolucion;}
		
	public Long getMarcaDefecto() {return marcaDefecto;}
      
	public void setMarcaDefecto(Long marcaDefecto){this.marcaDefecto=marcaDefecto;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getOperacion() {return operacion;}
      
	public void setOperacion(Long operacion){this.operacion=operacion;}
			
	
}
