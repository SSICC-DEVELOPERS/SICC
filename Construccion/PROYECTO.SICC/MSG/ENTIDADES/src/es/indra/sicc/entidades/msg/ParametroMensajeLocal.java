package es.indra.sicc.entidades.msg;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Timestamp;


@Entity
@Table(name="MSG_PARAM_MENSA")
public class ParametroMensajeLocal implements Serializable {

	public ParametroMensajeLocal() {}

	public ParametroMensajeLocal(Long oid, String cod_dato_vari, String desc_dato_vari, String modu_orig, Timestamp fech_de_sist, Long pais_oid_pais)	{
	
		this.oid=oid;
	        this.codigoVariable=cod_dato_vari;
                this.descripcion=desc_dato_vari;
                this.modulo=modu_orig;
                this.fechaSistema=fech_de_sist;
                this.oidPais=pais_oid_pais;
	
	}

	@Id
	@Column(name="OID_PARA_MENS")
	private Long oid;
	@Column(name="COD_DATO_VARI")
	private String codigoVariable;
	@Column(name="DES_DATO_VARI")
	private String descripcion;
	@Column(name="MODU_OID_MODU")
	private String modulo;
	@Column(name="COD_LIST_CONS")
	private String listaConsultoras;
	@Column(name="COD_TIPO_MENS")
	private String tipoMensaje;
	@Column(name="FECH_SIST")
	private java.sql.Timestamp fechaSistema;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoVariable() {return codigoVariable;}
      
	public void setCodigoVariable(String codigoVariable){this.codigoVariable=codigoVariable;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public String getModulo() {return modulo;}
      
	public void setModulo(String modulo){this.modulo=modulo;}
		
	public String getListaConsultoras() {return listaConsultoras;}
      
	public void setListaConsultoras(String listaConsultoras){this.listaConsultoras=listaConsultoras;}
		
	public String getTipoMensaje() {return tipoMensaje;}
      
	public void setTipoMensaje(String tipoMensaje){this.tipoMensaje=tipoMensaje;}
		
	public java.sql.Timestamp getFechaSistema() {return fechaSistema;}
      
	public void setFechaSistema(java.sql.Timestamp fechaSistema){this.fechaSistema=fechaSistema;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
			
	
}
