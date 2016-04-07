package es.indra.sicc.entidades.rec;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import java.sql.Date;


@Entity
@Table(name="REC_BOLET_RECOJ_TEMPO")
@NamedQueries({
@NamedQuery(name="BoletaRecojoTemporalLocal.FindAll",query="select object(o) from BoletaRecojoTemporalLocal o")
})
public class BoletaRecojoTemporalLocal implements Serializable {

	public BoletaRecojoTemporalLocal() {}

	public BoletaRecojoTemporalLocal(Long oid, Long numBole, Date fecCapt, String valUsua, Long numOrdeIngr, Long paisOidPais, Long erecOidEstaReco)	{
	
		this.oid=oid;
                this.numeroBoleta=numBole;
                this.fechaCaptura=fecCapt; 
                this.usuario=valUsua;
                this.ordenIngreso=numOrdeIngr;
                this.oidPais=paisOidPais;
                this.oidEstado=erecOidEstaReco;
	
	}

	@Id
	@Column(name="OID_BOLE_RECO_TEMP")
	private Long oid;
	@Column(name="NUM_BOLE")
	private Long numeroBoleta;
	@Column(name="FEC_CAPT")
        private Date fechaCaptura;
	@Column(name="VAL_USUA")
	private String usuario;
	@Column(name="NUM_ORDE_INGR")
	private Long ordenIngreso;
	@Column(name="PAIS_OID_PAIS")
	private Long oidPais;
	@Column(name="EREC_OID_ESTA_RECO")
	private Long oidEstado;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getNumeroBoleta() {return numeroBoleta;}
      
	public void setNumeroBoleta(Long numeroBoleta){this.numeroBoleta=numeroBoleta;}
		
	public java.sql.Date getFechaCaptura() {return fechaCaptura;}
      
	public void setFechaCaptura(java.sql.Date fechaCaptura){this.fechaCaptura=fechaCaptura;}
		
	public String getUsuario() {return usuario;}
      
	public void setUsuario(String usuario){this.usuario=usuario;}
		
	public Long getOrdenIngreso() {return ordenIngreso;}
      
	public void setOrdenIngreso(Long ordenIngreso){this.ordenIngreso=ordenIngreso;}
		
	public Long getOidPais() {return oidPais;}
      
	public void setOidPais(Long oidPais){this.oidPais=oidPais;}
		
	public Long getOidEstado() {return oidEstado;}
      
	public void setOidEstado(Long oidEstado){this.oidEstado=oidEstado;}
			
	
}
