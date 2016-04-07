package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.math.BigDecimal;

@Entity
@Table(name="REC_AUTOR")
@NamedQueries({
@NamedQuery(name="AutorizacionesLocal.FindAll",query="select object(o) from AutorizacionesLocal o"),
@NamedQuery(name="AutorizacionesLocal.FindByUK",query="SELECT OBJECT(s) FROM AutorizacionesLocal s WHERE s.pais = ?1 AND s.tipoOperacion =?2 AND s.idUsuario =?3")
})
public class AutorizacionesLocal implements Serializable {

	public AutorizacionesLocal() {}

	public AutorizacionesLocal(Long oid, Integer idUsuario, Long pais, Long tipoOperacion)	{
	
		this.oid=oid;
                this.idUsuario=idUsuario;
                this.pais=pais;
                this.tipoOperacion=tipoOperacion;
	
	}

	@Id
	@Column(name="OID_AUTO")
	private Long oid;
	@Column(name="IMP_MAXI")
	private BigDecimal importeMaximo;
	@Column(name="IMP_MONT_MAXI_DIFE")
	private BigDecimal montoMaximoDiferencia;
	@Column(name="IND_INGR")
	private Boolean ingreso;
	@Column(name="IND_DESB")
	private Boolean desbloqueo;
	@Column(name="USER_OID_USER")
	private Integer idUsuario;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="TIOP_OID_TIPO_OPER")
	private Long tipoOperacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public BigDecimal getImporteMaximo() {return importeMaximo;}
      
	public void setImporteMaximo(BigDecimal importeMaximo){this.importeMaximo=importeMaximo;}
		
	public BigDecimal getMontoMaximoDiferencia() {return montoMaximoDiferencia;}
      
	public void setMontoMaximoDiferencia(BigDecimal montoMaximoDiferencia){this.montoMaximoDiferencia=montoMaximoDiferencia;}
		
	public Boolean getIngreso() {return ingreso;}
      
	public void setIngreso(Boolean ingreso){this.ingreso=ingreso;}
		
	public Boolean getDesbloqueo() {return desbloqueo;}
      
	public void setDesbloqueo(Boolean desbloqueo){this.desbloqueo=desbloqueo;}
		
	public Integer getIdUsuario() {return idUsuario;}
      
	public void setIdUsuario(Integer idUsuario){this.idUsuario=idUsuario;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getTipoOperacion() {return tipoOperacion;}
      
	public void setTipoOperacion(Long tipoOperacion){this.tipoOperacion=tipoOperacion;}
			
	
}
