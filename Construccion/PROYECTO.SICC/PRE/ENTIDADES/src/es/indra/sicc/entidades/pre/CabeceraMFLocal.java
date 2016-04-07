package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_MATRI_FACTU_CABEC")
@NamedQueries({
@NamedQuery(name="CabeceraMFLocal.FindByUK",query="SELECT OBJECT(a) "
+" FROM CabeceraMFLocal AS a WHERE a.oidPeri = ?1")
})
public class CabeceraMFLocal implements Serializable {

	public CabeceraMFLocal() {}

	public CabeceraMFLocal(Long oid, Long perd_oid_peri, Long num_pedi_esti, Long num_unid_esti, Long num_clie_esti, Long tota_mont_vent_neta) {
	
		this.oid=oid;
                this.oidPeri=perd_oid_peri;
                this.numeroPedidosEstimados=num_pedi_esti;
                this.unidadesEstimadas=num_unid_esti;
                this.clientesEstimados=num_clie_esti;
                this.totalMontoVentaNeta=tota_mont_vent_neta;
	
	}

	@Id
	@Column(name="OID_CABE")
	private Long oid;
	@Column(name="PERD_OID_PERI")
	private Long oidPeri;
	@Column(name="NUM_PEDI_ESTI")
	private Long numeroPedidosEstimados;
	@Column(name="NUM_UNID_ESTI")
	private Long unidadesEstimadas;
	@Column(name="NUM_CLIE_ESTI")
	private Long clientesEstimados;
	@Column(name="TOTA_MONT_VENT_NETA")
	private Long totalMontoVentaNeta;
	@Column(name="VAL_TIPO_CAMB")
	private Double tipoCambio;
	@Column(name="IND_MATR_FACT_GENE")
	private Boolean matrizGenerada;
	@Column(name="IND_REGI_ESTA_GENE")
	private Boolean registroEstadisticoGenerado;
	@Column(name="IND_MATR_FACT")
	private Boolean matrizFacturada;
	@Column(name="MONE_OID_MONE")
	private Long moneda;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidPeri() {return oidPeri;}
      
	public void setOidPeri(Long oidPeri){this.oidPeri=oidPeri;}
		
	public Long getNumeroPedidosEstimados() {return numeroPedidosEstimados;}
      
	public void setNumeroPedidosEstimados(Long numeroPedidosEstimados){this.numeroPedidosEstimados=numeroPedidosEstimados;}
		
	public Long getUnidadesEstimadas() {return unidadesEstimadas;}
      
	public void setUnidadesEstimadas(Long unidadesEstimadas){this.unidadesEstimadas=unidadesEstimadas;}
		
	public Long getClientesEstimados() {return clientesEstimados;}
      
	public void setClientesEstimados(Long clientesEstimados){this.clientesEstimados=clientesEstimados;}
		
	public Long getTotalMontoVentaNeta() {return totalMontoVentaNeta;}
      
	public void setTotalMontoVentaNeta(Long totalMontoVentaNeta){this.totalMontoVentaNeta=totalMontoVentaNeta;}
		
	public Double getTipoCambio() {return tipoCambio;}
      
	public void setTipoCambio(Double tipoCambio){this.tipoCambio=tipoCambio;}
		
	public Boolean getMatrizGenerada() {return matrizGenerada;}
      
	public void setMatrizGenerada(Boolean matrizGenerada){this.matrizGenerada=matrizGenerada;}
		
	public Boolean getRegistroEstadisticoGenerado() {return registroEstadisticoGenerado;}
      
	public void setRegistroEstadisticoGenerado(Boolean registroEstadisticoGenerado){this.registroEstadisticoGenerado=registroEstadisticoGenerado;}
		
	public Boolean getMatrizFacturada() {return matrizFacturada;}
      
	public void setMatrizFacturada(Boolean matrizFacturada){this.matrizFacturada=matrizFacturada;}
		
	public Long getMoneda() {return moneda;}
      
	public void setMoneda(Long moneda){this.moneda=moneda;}
			
	
}
