package es.indra.sicc.entidades.cal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="CAL_CONTA")
@NamedQueries({
 @NamedQuery(name="ContactoLocal.FindAll",query="SELECT OBJECT(a) FROM ContactoLocal AS a")
})
public class ContactoLocal implements Serializable {

	public ContactoLocal() {}

	public ContactoLocal(Long oid, Long cod_cont, String cod_oper, Date fec_cont, Timestamp val_hora_inic, Long pais_oid_pais, Long clie_oid_clie, Long moco_oid, Long atec_oid)	{
	
		this.oid=oid;
	        setCodContacto(cod_cont);
	        setCodOperador(cod_oper);
	        setFechaContacto(fec_cont);
	        setHoraInicio(val_hora_inic);
	        setPais(pais_oid_pais);
	        setOidCliente(clie_oid_clie);
	        setMotivo(moco_oid);
	        setAtributoEstado(atec_oid);
	
	}

	@Id
	@Column(name="OID_CONT")
	private Long oid;
	@Column(name="COD_CONT")
	private Long codContacto;
	@Column(name="COD_OPER")
	private String codOperador;
	@Column(name="FEC_CONT")
	private java.sql.Date fechaContacto;
	@Column(name="VAL_HORA_INIC")
	private java.sql.Timestamp horaInicio;
	@Column(name="VAL_HORA_FIN")
	private java.sql.Timestamp horaFin;
	@Column(name="FEC_HORA_CIER")
	private java.sql.Timestamp fechaHoraCierre;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="CLIE_OID_CLIE")
	private Long oidCliente;
	@Column(name="MOCO_OID_MOTI_CONT")
	private Long motivo;
	@Column(name="ATEC_OID_ATRI_ESTA_CONT")
	private Long atributoEstado;
	@Column(name="TICL_OID_TIPO_CLIE")
	private Long tipoCliente;
	@Column(name="SBTI_OID_SUBT_CLIE")
	private Long subTipoCliente;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCodContacto() {return codContacto;}
      
	public void setCodContacto(Long codContacto){this.codContacto=codContacto;}
		
	public String getCodOperador() {return codOperador;}
      
	public void setCodOperador(String codOperador){this.codOperador=codOperador;}
		
	public java.sql.Date getFechaContacto() {return fechaContacto;}
      
	public void setFechaContacto(java.sql.Date fechaContacto){this.fechaContacto=fechaContacto;}
		
	public java.sql.Timestamp getHoraInicio() {return horaInicio;}
      
	public void setHoraInicio(java.sql.Timestamp horaInicio){this.horaInicio=horaInicio;}
		
	public java.sql.Timestamp getHoraFin() {return horaFin;}
      
	public void setHoraFin(java.sql.Timestamp horaFin){this.horaFin=horaFin;}
		
	public java.sql.Timestamp getFechaHoraCierre() {return fechaHoraCierre;}
      
	public void setFechaHoraCierre(java.sql.Timestamp fechaHoraCierre){this.fechaHoraCierre=fechaHoraCierre;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getOidCliente() {return oidCliente;}
      
	public void setOidCliente(Long oidCliente){this.oidCliente=oidCliente;}
		
	public Long getMotivo() {return motivo;}
      
	public void setMotivo(Long motivo){this.motivo=motivo;}
		
	public Long getAtributoEstado() {return atributoEstado;}
      
	public void setAtributoEstado(Long atributoEstado){this.atributoEstado=atributoEstado;}
		
	public Long getTipoCliente() {return tipoCliente;}
      
	public void setTipoCliente(Long tipoCliente){this.tipoCliente=tipoCliente;}
		
	public Long getSubTipoCliente() {return subTipoCliente;}
      
	public void setSubTipoCliente(Long subTipoCliente){this.subTipoCliente=subTipoCliente;}
			
	
}
