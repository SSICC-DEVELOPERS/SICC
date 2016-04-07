package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name="REC_CABEC_RECLA_DIGIT")
@NamedQueries({
@NamedQuery(name="CabeceraReclamoDigitadoLocal.FindAll",query="select object(o) from CabeceraReclamoDigitadoLocal o")
})
public class CabeceraReclamoDigitadoLocal implements Serializable {

	public CabeceraReclamoDigitadoLocal() {}

	public CabeceraReclamoDigitadoLocal(Long oid, Long numeroDocumentoReferencia, String codigoCliente, Long pais, Integer idReclamo)	{
	
		this.oid=oid;
                this.numeroDocumentoReferencia=numeroDocumentoReferencia;
                this.codigoCliente=codigoCliente;
                this.pais=pais;
                this.idReclamo=idReclamo;
	
	}

	@Id
	@Column(name="OID_CABE_RECL_DIGI")
	private Long oid;
	@Column(name="NUM_RECL")
	private Long numeroReclamo;
	@Column(name="NUM_DOCU_REFE")
	private Long numeroDocumentoReferencia;
	@Column(name="COD_CLIE")
	private String codigoCliente;
	@Column(name="COD_USUA")
	private String codigoUsuario;
	@Column(name="FEC_INGR")
	private java.sql.Date fechaIngreso;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="ESRE_OID_ESTA_RECL")
	private Long estado;
	@Column(name="TIIN_OID_TIPO_INGR")
	private Long tipoIngreso;
	@Column(name="VAL_IDEN_RECL")
	private Integer idReclamo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNumeroReclamo() {return numeroReclamo;}
      
	public void setNumeroReclamo(Long numeroReclamo){this.numeroReclamo=numeroReclamo;}
		
	public Long getNumeroDocumentoReferencia() {return numeroDocumentoReferencia;}
      
	public void setNumeroDocumentoReferencia(Long numeroDocumentoReferencia){this.numeroDocumentoReferencia=numeroDocumentoReferencia;}
		
	public String getCodigoCliente() {return codigoCliente;}
      
	public void setCodigoCliente(String codigoCliente){this.codigoCliente=codigoCliente;}
		
	public String getCodigoUsuario() {return codigoUsuario;}
      
	public void setCodigoUsuario(String codigoUsuario){this.codigoUsuario=codigoUsuario;}
		
	public java.util.Date getFechaIngreso() {return fechaIngreso;}
      
	public void setFechaIngreso(java.sql.Date fechaIngreso){this.fechaIngreso=fechaIngreso;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getEstado() {return estado;}
      
	public void setEstado(Long estado){this.estado=estado;}
		
	public Long getTipoIngreso() {return tipoIngreso;}
      
	public void setTipoIngreso(Long tipoIngreso){this.tipoIngreso=tipoIngreso;}
		
	public Integer getIdReclamo() {return idReclamo;}
      
	public void setIdReclamo(Integer idReclamo){this.idReclamo=idReclamo;}
			
	
}
