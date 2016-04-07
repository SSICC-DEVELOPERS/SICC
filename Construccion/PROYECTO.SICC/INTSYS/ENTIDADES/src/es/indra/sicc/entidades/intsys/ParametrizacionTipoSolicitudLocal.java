package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_PARAM_TIPO_SOLIC")
@NamedQueries({
@NamedQuery(name="ParametrizacionTipoSolicitudLocal.FindAll",query="select object(o) from ParametrizacionTipoSolicitudLocal o")
})
public class ParametrizacionTipoSolicitudLocal implements Serializable {

	public ParametrizacionTipoSolicitudLocal() {}

	public ParametrizacionTipoSolicitudLocal(Long oid, Long tipoSolicitud)	{
            this.oid=oid;
	    this.tipoSolicitud=tipoSolicitud;
	
	}

	@Id
	@Column(name="OID_PARA_TIPO_SOLI")
	private Long oid;
	@Column(name="NUM_UNID_VEND")
	private Boolean unidadesVendidas;
	@Column(name="NUM_UNID_FALT")
	private Boolean unidadesFaltantes;
	@Column(name="NUM_UNID_DEVU")
	private Boolean unidadesDevueltas;
	@Column(name="NUM_UNID_ANUL")
	private Boolean unidadesAnuladas;
	@Column(name="NUM_UNID_CANJ")
	private Boolean unidadesCanje;
	@Column(name="NUM_UNID_TRUE")
	private Boolean unidadesTrueque;
	@Column(name="TSPA_OID_TIPO_SOLI_PAIS")
	private Long tipoSolicitud;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Boolean getUnidadesVendidas() {return unidadesVendidas;}
      
	public void setUnidadesVendidas(Boolean unidadesVendidas){this.unidadesVendidas=unidadesVendidas;}
		
	public Boolean getUnidadesFaltantes() {return unidadesFaltantes;}
      
	public void setUnidadesFaltantes(Boolean unidadesFaltantes){this.unidadesFaltantes=unidadesFaltantes;}
		
	public Boolean getUnidadesDevueltas() {return unidadesDevueltas;}
      
	public void setUnidadesDevueltas(Boolean unidadesDevueltas){this.unidadesDevueltas=unidadesDevueltas;}
		
	public Boolean getUnidadesAnuladas() {return unidadesAnuladas;}
      
	public void setUnidadesAnuladas(Boolean unidadesAnuladas){this.unidadesAnuladas=unidadesAnuladas;}
		
	public Boolean getUnidadesCanje() {return unidadesCanje;}
      
	public void setUnidadesCanje(Boolean unidadesCanje){this.unidadesCanje=unidadesCanje;}
		
	public Boolean getUnidadesTrueque() {return unidadesTrueque;}
      
	public void setUnidadesTrueque(Boolean unidadesTrueque){this.unidadesTrueque=unidadesTrueque;}
		
	public Long getTipoSolicitud() {return tipoSolicitud;}
      
	public void setTipoSolicitud(Long tipoSolicitud){this.tipoSolicitud=tipoSolicitud;}
			
	
}
