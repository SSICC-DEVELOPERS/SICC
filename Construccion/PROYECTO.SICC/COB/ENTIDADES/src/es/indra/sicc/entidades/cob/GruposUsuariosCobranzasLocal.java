package es.indra.sicc.entidades.cob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="COB_GRUPO_USUAR_COBRA")
@NamedQueries({
@NamedQuery(name="GruposUsuariosCobranzasLocal.FindAll",query="select object(o) from GruposUsuariosCobranzasLocal o")
})
public class GruposUsuariosCobranzasLocal implements Serializable {

	public GruposUsuariosCobranzasLocal() {}

	public GruposUsuariosCobranzasLocal(Long oid, Long codigoGrupoUsuario, String descripcion, Long pais)	{
	
		this.oid=oid;
                this.setCodigoGrupoUsuario(codigoGrupoUsuario);
	        this.setDescripcion(descripcion);
	        this.setPais(pais);
	
	}

	@Id
	@Column(name="OID_GRUP_USUA_COBR")
	private Long oid;
	@Column(name="COD_GRUP_USUA")
	private Long codigoGrupoUsuario;
	@Column(name="VAL_DESC")
	private String descripcion;
	@Column(name="FEC_ULTI_ESTA")
	private java.sql.Date fechaUltimaEstado;
	@Column(name="IND_USUA_EXTE")
	private Boolean indUsuarioExterno;
	@Column(name="VAL_TURN_HORA_ENTR")
	private String turnoHorarioEntrada;
	@Column(name="VAL_TURN_HORA_SALI")
	private String turnoHorarioSalida;
	@Column(name="VAL_OBSE")
	private String observaciones;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="ESGR_OID_ESTA_GRUP_USUA")
	private Long estadoGrupoUsuario;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCodigoGrupoUsuario() {return codigoGrupoUsuario;}
      
	public void setCodigoGrupoUsuario(Long codigoGrupoUsuario){this.codigoGrupoUsuario=codigoGrupoUsuario;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public java.sql.Date getFechaUltimaEstado() {return fechaUltimaEstado;}
      
	public void setFechaUltimaEstado(java.sql.Date fechaUltimaEstado){this.fechaUltimaEstado=fechaUltimaEstado;}
		
	public Boolean getIndUsuarioExterno() {return indUsuarioExterno;}
      
	public void setIndUsuarioExterno(Boolean indUsuarioExterno){this.indUsuarioExterno=indUsuarioExterno;}
		
	public String getTurnoHorarioEntrada() {return turnoHorarioEntrada;}
      
	public void setTurnoHorarioEntrada(String turnoHorarioEntrada){this.turnoHorarioEntrada=turnoHorarioEntrada;}
		
	public String getTurnoHorarioSalida() {return turnoHorarioSalida;}
      
	public void setTurnoHorarioSalida(String turnoHorarioSalida){this.turnoHorarioSalida=turnoHorarioSalida;}
		
	public String getObservaciones() {return observaciones;}
      
	public void setObservaciones(String observaciones){this.observaciones=observaciones;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getEstadoGrupoUsuario() {return estadoGrupoUsuario;}
      
	public void setEstadoGrupoUsuario(Long estadoGrupoUsuario){this.estadoGrupoUsuario=estadoGrupoUsuario;}
			
	
}
