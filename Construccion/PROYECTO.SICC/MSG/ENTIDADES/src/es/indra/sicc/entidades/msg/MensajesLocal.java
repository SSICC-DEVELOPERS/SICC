package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name="MSG_MENSA")
@NamedQueries({
@NamedQuery(name="MensajesLocal.FindByUk",query="Select Object(i) from MensajesLocal as i where i.oidPais = ?1 and i.codMensaje = ?2 ")
})
public class MensajesLocal implements Serializable {

	public MensajesLocal() {}

	public MensajesLocal(Long oid, String cod_mens, Long pais_oid_pais, 
                            String desc_mens, String text, Long periodoDesde, Long periodoHasta, 
                            Long modu, Long tipo_msg, Long oid_tipo_perm)	{
	
		this.oid=oid;
                this.codMensaje=cod_mens;
                this.oidPais=pais_oid_pais;
                this.descripcion=desc_mens;
                this.texto=text;
                this.periodoDesde=periodoDesde;
                this.periodoHasta=periodoHasta;
                this.oidModulo=modu;
                this.tipoMensaje=tipo_msg;
                this.tipoPermanencia=oid_tipo_perm;
	
	}

	@Id
	@Column(name="OID_MENS")
	private Long oid;
	@Column(name="COD_MENS")
	private String codMensaje;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="DES_MENS")
	private String descripcion;
	@Column(name="VAL_BLOQ_GRUP_PERM")
	private String bloqueGrupoPertenece;
	@Column(name="FEC_PERM_HAST")
	private java.sql.Timestamp permanenciaHasta;
	@Column(name="VAL_TEXT")
	private String texto;
	@Column(name="MODU_OID_MODU")
	private Long oidModulo;
	@Column(name="PERI_OID_PERI_DESD")
	private Long periodoDesde;
	@Column(name="PERI_OID_PERI_HAST")
	private Long periodoHasta;
	@Column(name="TPER_OID_TIPO_PERM")
	private Long tipoPermanencia;
	@Column(name="TMEN_OID_TIPO_MENS")
	private Long tipoMensaje;
	@Column(name="FEC_PERM_DESD")
        private java.sql.Timestamp permanenciaDesde;
	@Column(name="IND_EXCL_TIPO")
	private Long exclusionTipologia;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodMensaje() {return codMensaje;}
      
	public void setCodMensaje(String codMensaje){this.codMensaje=codMensaje;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public String getBloqueGrupoPertenece() {return bloqueGrupoPertenece;}
      
	public void setBloqueGrupoPertenece(String bloqueGrupoPertenece){this.bloqueGrupoPertenece=bloqueGrupoPertenece;}
		
	public java.sql.Timestamp getPermanenciaHasta() {return permanenciaHasta;}
      
	public void setPermanenciaHasta(java.sql.Timestamp permanenciaHasta){this.permanenciaHasta=permanenciaHasta;}
		
	public String getTexto() {return texto;}
      
	public void setTexto(String texto){this.texto=texto;}
		
	public Long getOidModulo() {return oidModulo;}
      
	public void setOidModulo(Long oidModulo){this.oidModulo=oidModulo;}
		
	public Long getPeriodoDesde() {return periodoDesde;}
      
	public void setPeriodoDesde(Long periodoDesde){this.periodoDesde=periodoDesde;}
		
	public Long getPeriodoHasta() {return periodoHasta;}
      
	public void setPeriodoHasta(Long periodoHasta){this.periodoHasta=periodoHasta;}
		
	public Long getTipoPermanencia() {return tipoPermanencia;}
      
	public void setTipoPermanencia(Long tipoPermanencia){this.tipoPermanencia=tipoPermanencia;}
		
	public Long getTipoMensaje() {return tipoMensaje;}
      
	public void setTipoMensaje(Long tipoMensaje){this.tipoMensaje=tipoMensaje;}
		
	public java.sql.Timestamp getPermanenciaDesde() {return permanenciaDesde;}
      
	public void setPermanenciaDesde(java.sql.Timestamp permanenciaDesde){this.permanenciaDesde=permanenciaDesde;}
		
	public Long getExclusionTipologia() {return exclusionTipologia;}
      
	public void setExclusionTipologia(Long exclusionTipologia){this.exclusionTipologia=exclusionTipologia;}
			
	
}
