package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Date;
import java.math.BigDecimal;

import java.io.Serializable;

@Entity
@Table(name="COM_CONGE")
@NamedQueries({
@NamedQuery(name="CongeladosLocal.FindAll",query="select object(o) from CongeladosLocal o")
})
public class CongeladosLocal implements Serializable {

	public CongeladosLocal() {}

	public CongeladosLocal(Long oid, Long codCong, Date fecDesd, Date fecHast, BigDecimal impCong, Boolean indDescAuto, Long clieOidClie)	{
	
		this.oid=oid;
                this.setIdCongelado(codCong);        
                this.setImporte(impCong);
                this.setIndDescongAutomatic(indDescAuto);
                this.setClienteDatosBasicos(clieOidClie);
                this.setFechaDesde(fecDesd);
                this.setFechaHasta(fecHast);
	
	}

	@Id
	@Column(name="OID_CONG")
	private Long oid;
	@Column(name="COD_CONG")
	private Long idCongelado;
	@Column(name="FEC_DESD")
	private java.sql.Date fechaDesde;
	@Column(name="FEC_HAST")
	private java.sql.Date fechaHasta;
	@Column(name="IMP_CONG")
	private java.math.BigDecimal importe;
	@Column(name="IND_DESC_AUTO")
	private Boolean indDescongAutomatic;
	@Column(name="CLIE_OID_CLIE")
	private Long clienteDatosBasicos;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getIdCongelado() {return idCongelado;}
      
	public void setIdCongelado(Long idCongelado){this.idCongelado=idCongelado;}
		
	public java.sql.Date getFechaDesde() {return fechaDesde;}
      
	public void setFechaDesde(java.sql.Date fechaDesde){this.fechaDesde=fechaDesde;}
		
	public java.sql.Date getFechaHasta() {return fechaHasta;}
      
	public void setFechaHasta(java.sql.Date fechaHasta){this.fechaHasta=fechaHasta;}
		
	public java.math.BigDecimal getImporte() {return importe;}
      
	public void setImporte(java.math.BigDecimal importe){this.importe=importe;}
		
	public Boolean getIndDescongAutomatic() {return indDescongAutomatic;}
      
	public void setIndDescongAutomatic(Boolean indDescongAutomatic){this.indDescongAutomatic=indDescongAutomatic;}
		
	public Long getClienteDatosBasicos() {return clienteDatosBasicos;}
      
	public void setClienteDatosBasicos(Long clienteDatosBasicos){this.clienteDatosBasicos=clienteDatosBasicos;}
			
	
}
