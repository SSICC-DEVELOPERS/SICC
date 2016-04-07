package es.indra.sicc.entidades.pre;

import es.indra.mare.common.exception.MareException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_ESTIM_VENTA")
@NamedQueries({
@NamedQuery(name="EstimadosVentaLocal.FindByUK",query="SELECT OBJECT(a) "
+ "FROM EstimadosVentaLocal AS a WHERE a.oidProd = ?1 AND a.oidPeri = ?2 AND a.oidTipoOfer = ?3 AND a.oidCicloVida = ?4")
})
public class EstimadosVentaLocal implements Serializable {

	public EstimadosVentaLocal() {}

	public EstimadosVentaLocal(Long oid, Long prod_oid_prod, Long perd_oid_peri, Long fopa_oid_form_pago, 
                                    Long argv_oid_argu_vent, Long cndp_oid_cond_prom, Long coes_oid_estr, Long mone_oid_mone, 
                                        Long tofe_oid_tipo_ofer, Long civi_oid_cicl_vida, Long ocat_oid_cata) {
	
		this.oid=oid;
                this.oidProd=prod_oid_prod;
                this.oidPeri=perd_oid_peri;
                this.oidFormPago=fopa_oid_form_pago;
                this.oidArguVent=argv_oid_argu_vent;
                this.oidCondProm=cndp_oid_cond_prom;
                this.oidEstr=coes_oid_estr;
                this.oidMoneda=mone_oid_mone;
                this.oidTipoOfer=tofe_oid_tipo_ofer;
                this.oidCicloVida=civi_oid_cicl_vida;
                this.oidCata=ocat_oid_cata;
	
	}

	@Id
	@Column(name="OID_ESTIM_VENT")
	private Long oid;
	@Column(name="NUM_UNID_ESTI")
	private Long unidadesEstimadas;
	@Column(name="NUM_PAGI_CATA")
	private Integer paginaCatalogo;
	@Column(name="IMP_PREC_CATA")
	private Double precioCatalogo;
	@Column(name="IMP_VENT_NETA_ESTI")
	private Double ventaNetaEstimada;
	@Column(name="IMP_PREC_POSI")
	private Double precioPosicionamiento;
	@Column(name="PROD_OID_PROD")
	private Long oidProd;
	@Column(name="PERD_OID_PERI")
	private Long oidPeri;
	@Column(name="FOPA_OID_FORM_PAGO")
	private Long oidFormPago;
	@Column(name="ARGV_OID_ARGU_VENT")
	private Long oidArguVent;
	@Column(name="CNDP_OID_COND_PROM")
	private Long oidCondProm;
	@Column(name="COES_OID_ESTR")
	private Long oidEstr;
	@Column(name="MONE_OID_MONE")
	private Long oidMoneda;
	@Column(name="TOFE_OID_TIPO_OFER")
	private Long oidTipoOfer;
	@Column(name="CIVI_OID_CICL_VIDA")
	private Long oidCicloVida;
	@Column(name="OCAT_OID_CATA")
	private Long oidCata;
	@Column(name="VAL_POSI_PAGI")
	private Integer posicionPagina;
	@Column(name="VAL_CENT")
	private String centro;
	@Column(name="IND_OFER_GENE")
	private Boolean ofertaGenerada;
	@Column(name="VAL_COST_ESTA")
	private Double costeEstandar;
	@Column(name="ACCE_OID_ACCE")
	private Long oidAcceso;
	@Column(name="SBAC_OID_SBAC")
	private Long oidSbac;
	@Column(name="VARI_OID_VARI")
	private Long variante;
	@Column(name="PRFI_OID_PROG_FIDE")
	private Long programaFidelizacion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getUnidadesEstimadas() {return unidadesEstimadas;}
      
	public void setUnidadesEstimadas(Long unidadesEstimadas){this.unidadesEstimadas=unidadesEstimadas;}
		
	public Integer getPaginaCatalogo() {return paginaCatalogo;}
      
	public void setPaginaCatalogo(Integer paginaCatalogo){this.paginaCatalogo=paginaCatalogo;}
		
	public Double getPrecioCatalogo() {return precioCatalogo;}
      
	public void setPrecioCatalogo(Double precioCatalogo){this.precioCatalogo=precioCatalogo;}
		
	public Double getVentaNetaEstimada() {return ventaNetaEstimada;}
      
	public void setVentaNetaEstimada(Double ventaNetaEstimada){this.ventaNetaEstimada=ventaNetaEstimada;}
		
	public Double getPrecioPosicionamiento() {return precioPosicionamiento;}
      
	public void setPrecioPosicionamiento(Double precioPosicionamiento){this.precioPosicionamiento=precioPosicionamiento;}
		
	public Long getOidProd() {return oidProd;}
      
	public void setOidProd(Long oidProd){this.oidProd=oidProd;}
		
	public Long getOidPeri() {return oidPeri;}
      
	public void setOidPeri(Long oidPeri){this.oidPeri=oidPeri;}
		
	public Long getOidFormPago() {return oidFormPago;}
      
	public void setOidFormPago(Long oidFormPago){this.oidFormPago=oidFormPago;}
		
	public Long getOidArguVent() {return oidArguVent;}
      
	public void setOidArguVent(Long oidArguVent){this.oidArguVent=oidArguVent;}
		
	public Long getOidCondProm() {return oidCondProm;}
      
	public void setOidCondProm(Long oidCondProm){this.oidCondProm=oidCondProm;}
		
	public Long getOidEstr() {return oidEstr;}
      
	public void setOidEstr(Long oidEstr){this.oidEstr=oidEstr;}
		
	public Long getOidMoneda() {return oidMoneda;}
      
	public void setOidMoneda(Long oidMoneda){this.oidMoneda=oidMoneda;}
		
	public Long getOidTipoOfer() {return oidTipoOfer;}
      
	public void setOidTipoOfer(Long oidTipoOfer){this.oidTipoOfer=oidTipoOfer;}
		
	public Long getOidCicloVida() {return oidCicloVida;}
      
	public void setOidCicloVida(Long oidCicloVida){this.oidCicloVida=oidCicloVida;}
		
	public Long getOidCata() {return oidCata;}
      
	public void setOidCata(Long oidCata){this.oidCata=oidCata;}
		
	public Integer getPosicionPagina() {return posicionPagina;}
      
	public void setPosicionPagina(Integer posicionPagina){this.posicionPagina=posicionPagina;}
		
	public String getCentro() {return centro;}
      
	public void setCentro(String centro){this.centro=centro;}
		
	public Boolean getOfertaGenerada() {return ofertaGenerada;}
      
	public void setOfertaGenerada(Boolean ofertaGenerada){this.ofertaGenerada=ofertaGenerada;}
		
	public Double getCosteEstandar() {return costeEstandar;}
      
	public void setCosteEstandar(Double costeEstandar){this.costeEstandar=costeEstandar;}
		
	public Long getOidAcceso() {return oidAcceso;}
      
	public void setOidAcceso(Long oidAcceso){this.oidAcceso=oidAcceso;}
		
	public Long getOidSbac() {return oidSbac;}
      
	public void setOidSbac(Long oidSbac){this.oidSbac=oidSbac;}
		
	public Long getVariante() {return variante;}
      
	public void setVariante(Long variante){this.variante=variante;}
		
	public Long getProgramaFidelizacion() {return programaFidelizacion;}
      
	public void setProgramaFidelizacion(Long programaFidelizacion){this.programaFidelizacion=programaFidelizacion;}
			
	
}
