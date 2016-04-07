package es.indra.sicc.entidades.pre;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="PRE_OFERT")
@NamedQueries({
@NamedQuery(name="OfertaLocal.FindByOidCabe",query="SELECT OBJECT(a) "
+"FROM OfertaLocal AS a WHERE a.oidCabe = ?1"),
@NamedQuery(name="OfertaLocal.FindByOidCabeOrde",query="SELECT OBJECT(a) "
+"FROM OfertaLocal AS a WHERE a.oidCabe = ?1 order by a.oid"),
@NamedQuery(name="OfertaLocal.FindByOidCabeOidEstr",query="SELECT OBJECT(a) "
+" FROM OfertaLocal AS a WHERE a.oidCabe = ?1 AND a.oidEstr = ?2"),
@NamedQuery(name="OfertaLocal.FindByMFGenerada",query="SELECT OBJECT(a) "
+" FROM OfertaLocal AS a WHERE a.oidCabe = ?1 and ((?2=1 and a.matrizFacturacionGenerada = TRUE) "
+" or (?2=0 and (a.matrizFacturacionGenerada = FALSE or a.matrizFacturacionGenerada IS NULL)))")
})

public class OfertaLocal implements Serializable {

	public OfertaLocal() {}

	public OfertaLocal(Long oid, Long coes_oid_estr, Integer num_ofer,
                    Long argv_oid_argu_vent, Long mfca_oid_cabe, Long oidCatalogo) {
	
		this.oid=oid;
                this.oidEstr=coes_oid_estr;
                this.numeroOferta=num_ofer;
                this.oidArguVent=argv_oid_argu_vent;
                this.oidCabe=mfca_oid_cabe;
                this.oidCatalogo=oidCatalogo;
	
	}

	@Id
	@Column(name="OID_OFER")
	private Long oid;
	@Column(name="COES_OID_ESTR")
	private Long oidEstr;
	@Column(name="NUM_OFER")
	private Integer numeroOferta;
	@Column(name="NUM_ORDE")
	private Integer numeroOrden;
	@Column(name="NUM_GRUP")
	private Integer numeroGrupos;
	@Column(name="NUM_GRUP_CNDT")
	private Integer numeroGruposCondicionantes;
	@Column(name="NUM_GRUP_COND")
	private Integer numeroGruposCondicionados;
	@Column(name="VAL_COND_G1_CNDT")
	private String condicionCondicionantes;
	@Column(name="VAL_COND_G2_CNDO")
	private String condicionCondicionados;
	@Column(name="NUM_PAQU")
	private Integer numeroPaquetes;
	@Column(name="NUM_PRIM_POSI_RANK")
	private Integer primeraPosicionRanking;
	@Column(name="NUM_ULTI_POSI_RANK")
	private Integer ultimaPosicionRanking;
	@Column(name="FOPA_OID_FORM_PAGO")
	private Long oidFormPago;
	@Column(name="SBAC_OID_SBAC")
	private Long oidSbac;
	@Column(name="ARGV_OID_ARGU_VENT")
	private Long oidArguVent;
	@Column(name="ACCE_OID_ACCE")
	private Long oidAcceso;
	@Column(name="MFCA_OID_CABE")
	private Long oidCabe;
	@Column(name="IND_CODI_VENT_GENE")
	private Boolean codigoVentaGenerado;
	@Column(name="IND_DESP_COMPL")
	private Boolean despachoCompleto;
	@Column(name="IND_DESP_AUTO")
	private Boolean despachoAutomatico;
	@Column(name="IND_MATR_FACT_GENE")
	private Boolean matrizFacturacionGenerada;
	@Column(name="IND_RECU_OBLI")
	private Boolean recuperacionObligatoria;
	@Column(name="IND_REGI_ESTA_GENE")
	private Boolean registroEstadisticoGenerado;
	@Column(name="OCAT_OID_CATA")
	private Long oidCatalogo;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getOidEstr() {return oidEstr;}
      
	public void setOidEstr(Long oidEstr){this.oidEstr=oidEstr;}
		
	public Integer getNumeroOferta() {return numeroOferta;}
      
	public void setNumeroOferta(Integer numeroOferta){this.numeroOferta=numeroOferta;}
		
	public Integer getNumeroOrden() {return numeroOrden;}
      
	public void setNumeroOrden(Integer numeroOrden){this.numeroOrden=numeroOrden;}
		
	public Integer getNumeroGrupos() {return numeroGrupos;}
      
	public void setNumeroGrupos(Integer numeroGrupos){this.numeroGrupos=numeroGrupos;}
		
	public Integer getNumeroGruposCondicionantes() {return numeroGruposCondicionantes;}
      
	public void setNumeroGruposCondicionantes(Integer numeroGruposCondicionantes){this.numeroGruposCondicionantes=numeroGruposCondicionantes;}
		
	public Integer getNumeroGruposCondicionados() {return numeroGruposCondicionados;}
      
	public void setNumeroGruposCondicionados(Integer numeroGruposCondicionados){this.numeroGruposCondicionados=numeroGruposCondicionados;}
		
	public String getCondicionCondicionantes() {return condicionCondicionantes;}
      
	public void setCondicionCondicionantes(String condicionCondicionantes){this.condicionCondicionantes=condicionCondicionantes;}
		
	public String getCondicionCondicionados() {return condicionCondicionados;}
      
	public void setCondicionCondicionados(String condicionCondicionados){this.condicionCondicionados=condicionCondicionados;}
		
	public Integer getNumeroPaquetes() {return numeroPaquetes;}
      
	public void setNumeroPaquetes(Integer numeroPaquetes){this.numeroPaquetes=numeroPaquetes;}
		
	public Integer getPrimeraPosicionRanking() {return primeraPosicionRanking;}
      
	public void setPrimeraPosicionRanking(Integer primeraPosicionRanking){this.primeraPosicionRanking=primeraPosicionRanking;}
		
	public Integer getUltimaPosicionRanking() {return ultimaPosicionRanking;}
      
	public void setUltimaPosicionRanking(Integer ultimaPosicionRanking){this.ultimaPosicionRanking=ultimaPosicionRanking;}
		
	public Long getOidFormPago() {return oidFormPago;}
      
	public void setOidFormPago(Long oidFormPago){this.oidFormPago=oidFormPago;}
		
	public Long getOidSbac() {return oidSbac;}
      
	public void setOidSbac(Long oidSbac){this.oidSbac=oidSbac;}
		
	public Long getOidArguVent() {return oidArguVent;}
      
	public void setOidArguVent(Long oidArguVent){this.oidArguVent=oidArguVent;}
		
	public Long getOidAcceso() {return oidAcceso;}
      
	public void setOidAcceso(Long oidAcceso){this.oidAcceso=oidAcceso;}
		
	public Long getOidCabe() {return oidCabe;}
      
	public void setOidCabe(Long oidCabe){this.oidCabe=oidCabe;}
		
	public Boolean getCodigoVentaGenerado() {return codigoVentaGenerado;}
      
	public void setCodigoVentaGenerado(Boolean codigoVentaGenerado){this.codigoVentaGenerado=codigoVentaGenerado;}
		
	public Boolean getDespachoCompleto() {return despachoCompleto;}
      
	public void setDespachoCompleto(Boolean despachoCompleto){this.despachoCompleto=despachoCompleto;}
		
	public Boolean getDespachoAutomatico() {return despachoAutomatico;}
      
	public void setDespachoAutomatico(Boolean despachoAutomatico){this.despachoAutomatico=despachoAutomatico;}
		
	public Boolean getMatrizFacturacionGenerada() {return matrizFacturacionGenerada;}
      
	public void setMatrizFacturacionGenerada(Boolean matrizFacturacionGenerada){this.matrizFacturacionGenerada=matrizFacturacionGenerada;}
		
	public Boolean getRecuperacionObligatoria() {return recuperacionObligatoria;}
      
	public void setRecuperacionObligatoria(Boolean recuperacionObligatoria){this.recuperacionObligatoria=recuperacionObligatoria;}
		
	public Boolean getRegistroEstadisticoGenerado() {return registroEstadisticoGenerado;}
      
	public void setRegistroEstadisticoGenerado(Boolean registroEstadisticoGenerado){this.registroEstadisticoGenerado=registroEstadisticoGenerado;}
		
	public Long getOidCatalogo() {return oidCatalogo;}
      
	public void setOidCatalogo(Long oidCatalogo){this.oidCatalogo=oidCatalogo;}
			
	
}
