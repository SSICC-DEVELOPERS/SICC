package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Timestamp;

import java.io.Serializable;

@Entity
@Table(name="COM_COMIS")
@NamedQueries({
@NamedQuery(name="ComisionesLocal.FindAll",query="select object(o) from ComisionesLocal o")
})
public class ComisionesLocal implements Serializable {

	public ComisionesLocal() {}

	public ComisionesLocal(Long oid, String codComi, Integer numVers, Long plcpOidPlanComiPais, Long plcmOidPlanComiMarc, Long perdOidPeri, Long tplaOidTipoPlan, Long perdOidPeriHast, Long estado, Long plcoOidPlanComi, String indVentCob)	{
	
		this.oid=oid;
                this.setCodComi(codComi);
	        this.setNumVers(numVers);
	        this.setPlcpOidPlanComiPais(plcpOidPlanComiPais);
	        this.setPlcmOidPlanComiMarc(plcmOidPlanComiMarc);
	        this.setPerdOidPeri(perdOidPeri);
	        this.setTplaOidTipoPlan(tplaOidTipoPlan);
	        this.setPerdOidPeriHast(perdOidPeriHast);
	        this.setEstado(estado);
	        this.setPlcoOidPlanComi(plcoOidPlanComi);
	        this.setIndVentCob(indVentCob);
	
	}

	@Id
	@Column(name="OID_COMI")
	private Long oid;
	@Column(name="COD_COMI")
	private String codComi;
	@Column(name="NUM_VERS")
	private Integer numVers;
	@Column(name="NUM_PERI_ESPE")
	private Integer numPeriEspe;
	@Column(name="VAL_CONC")
	private String valConc;
	@Column(name="IND_COMP")
	private Boolean indComp;
	@Column(name="IND_TRAT_DIFE")
	private Boolean indTratDife;
	@Column(name="FEC_ULTI_ESTA")
	private Timestamp fecUltiEsta;
	@Column(name="VAL_OBSE")
	private String valObse;
	@Column(name="PLCP_OID_PLAN_COMI_PAIS")
	private Long plcpOidPlanComiPais;
	@Column(name="PLCM_OID_PLAN_COMI_MARC")
	private Long plcmOidPlanComiMarc;
	@Column(name="PERD_OID_PERI")
	private Long perdOidPeri;
	@Column(name="TPLA_OID_TIPO_PLAN")
	private Long tplaOidTipoPlan;
	@Column(name="PERD_OID_PERI_HAST")
	private Long perdOidPeriHast;
	@Column(name="CECO_OID_ESTA_COMI")
	private Long estado;
	@Column(name="PERD_OID_PERI_VIGO_MODI")
	private Long perdOidPeriVigoModi;
	@Column(name="PLCO_OID_PLAN_COMI")
	private Long plcoOidPlanComi;
	@Column(name="IND_VENT_COBR")
	private String indVentCob;
        
       // vbongiov -- Cambio 20090913 -- 5/08/2009
        @Column(name="IND_CONS_SABA_DOMI_FERI")
        private Boolean consideraSabDomFer;
        @Column(name="IND_DESC_IMPO_VENT_PAGO")
        private Boolean dsctoImpstoVtaPagos;

        // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
        @Column(name="IND_COMI_ESCA")
        private Boolean comisionEscalonada;
	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodComi() {return codComi;}
      
	public void setCodComi(String codComi){this.codComi=codComi;}
		
	public Integer getNumVers() {return numVers;}
      
	public void setNumVers(Integer numVers){this.numVers=numVers;}
		
	public Integer getNumPeriEspe() {return numPeriEspe;}
      
	public void setNumPeriEspe(Integer numPeriEspe){this.numPeriEspe=numPeriEspe;}
		
	public String getValConc() {return valConc;}
      
	public void setValConc(String valConc){this.valConc=valConc;}
		
	public Boolean getIndComp() {return indComp;}
      
	public void setIndComp(Boolean indComp){this.indComp=indComp;}
		
	public Boolean getIndTratDife() {return indTratDife;}
      
	public void setIndTratDife(Boolean indTratDife){this.indTratDife=indTratDife;}
		
	public Timestamp getFecUltiEsta() {return fecUltiEsta;}
      
	public void setFecUltiEsta(Timestamp fecUltiEsta){this.fecUltiEsta=fecUltiEsta;}
		
	public String getValObse() {return valObse;}
      
	public void setValObse(String valObse){this.valObse=valObse;}
		
	public Long getPlcpOidPlanComiPais() {return plcpOidPlanComiPais;}
      
	public void setPlcpOidPlanComiPais(Long plcpOidPlanComiPais){this.plcpOidPlanComiPais=plcpOidPlanComiPais;}
		
	public Long getPlcmOidPlanComiMarc() {return plcmOidPlanComiMarc;}
      
	public void setPlcmOidPlanComiMarc(Long plcmOidPlanComiMarc){this.plcmOidPlanComiMarc=plcmOidPlanComiMarc;}
		
	public Long getPerdOidPeri() {return perdOidPeri;}
      
	public void setPerdOidPeri(Long perdOidPeri){this.perdOidPeri=perdOidPeri;}
		
	public Long getTplaOidTipoPlan() {return tplaOidTipoPlan;}
      
	public void setTplaOidTipoPlan(Long tplaOidTipoPlan){this.tplaOidTipoPlan=tplaOidTipoPlan;}
		
	public Long getPerdOidPeriHast() {return perdOidPeriHast;}
      
	public void setPerdOidPeriHast(Long perdOidPeriHast){this.perdOidPeriHast=perdOidPeriHast;}
		
	public Long getEstado() {return estado;}
      
	public void setEstado(Long estado){this.estado=estado;}
		
	public Long getPerdOidPeriVigoModi() {return perdOidPeriVigoModi;}
      
	public void setPerdOidPeriVigoModi(Long perdOidPeriVigoModi){this.perdOidPeriVigoModi=perdOidPeriVigoModi;}
		
	public Long getPlcoOidPlanComi() {return plcoOidPlanComi;}
      
	public void setPlcoOidPlanComi(Long plcoOidPlanComi){this.plcoOidPlanComi=plcoOidPlanComi;}
		
	public String getIndVentCob() {return indVentCob;}
      
	public void setIndVentCob(String indVentCob){this.indVentCob=indVentCob;}
        
        public Boolean getConsideraSabDomFer()  {
          return this.consideraSabDomFer;
        }
        
        public void setConsideraSabDomFer(Boolean consideraSabDomFer) {
          this.consideraSabDomFer = consideraSabDomFer;
        }
        
        public Boolean getDsctoImpstoVtaPagos()  {
          return this.dsctoImpstoVtaPagos;
        }
        
        public void setDsctoImpstoVtaPagos(Boolean dsctoImpstoVtaPagos) {
          this.dsctoImpstoVtaPagos = dsctoImpstoVtaPagos;
        }

        public Boolean getComisionEscalonada() {
            return this.comisionEscalonada;
        }
                            
        public void setComisionEscalonada(Boolean comisionEscalonada) {
            this.comisionEscalonada = comisionEscalonada;
        }
	
}
