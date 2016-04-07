package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_METOD_LIQUI")
@NamedQueries({
@NamedQuery(name="MetodosLiquidacionLocal.FindAll",query="select object(o) from MetodosLiquidacionLocal o")
})
public class MetodosLiquidacionLocal implements Serializable {

	public MetodosLiquidacionLocal() {}

	public MetodosLiquidacionLocal(Long oid, String codigoMetodoLiquidacion, String descripcion, Boolean indLiquidacion, Boolean indLiquidacionGrupoUsuarios, Long pais, Long baseEscala)	{
	
		this.oid=oid;
                this.setCodigoMetodoLiquidacion(codigoMetodoLiquidacion);
	        this.setDescripcion(descripcion);
	        this.setIndLiquidacion(indLiquidacion);
	        this.setIndLiquidacionGrupoUsuarios(indLiquidacionGrupoUsuarios);
	        this.setPais(pais);
	        this.setBaseEscala(baseEscala);
	
	}

	@Id
	@Column(name="OID_METO_LIQU_COBR")
	private Long oid;
	@Column(name="COD_METO_LIQU")
	private String codigoMetodoLiquidacion;
	@Column(name="VAL_DESC_METO_LIQU")
	private String descripcion;
	@Column(name="IND_LIQU")
	private Boolean indLiquidacion;
	@Column(name="IND_LIQU_GRUP_USUA")
	private Boolean indLiquidacionGrupoUsuarios;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="BAES_OID_BASE_ESCA")
	private Long baseEscala;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoMetodoLiquidacion() {return codigoMetodoLiquidacion;}
      
	public void setCodigoMetodoLiquidacion(String codigoMetodoLiquidacion){this.codigoMetodoLiquidacion=codigoMetodoLiquidacion;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public Boolean getIndLiquidacion() {return indLiquidacion;}
      
	public void setIndLiquidacion(Boolean indLiquidacion){this.indLiquidacion=indLiquidacion;}
		
	public Boolean getIndLiquidacionGrupoUsuarios() {return indLiquidacionGrupoUsuarios;}
      
	public void setIndLiquidacionGrupoUsuarios(Boolean indLiquidacionGrupoUsuarios){this.indLiquidacionGrupoUsuarios=indLiquidacionGrupoUsuarios;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getBaseEscala() {return baseEscala;}
      
	public void setBaseEscala(Long baseEscala){this.baseEscala=baseEscala;}
			
	
}
