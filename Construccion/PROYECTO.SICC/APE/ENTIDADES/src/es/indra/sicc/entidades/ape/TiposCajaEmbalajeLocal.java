package es.indra.sicc.entidades.ape;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APE_TIPO_CAJA_EMBAL")
@NamedQueries({
@NamedQuery(name="TiposCajaEmbalajeLocal.FindAll",query="select object(o) from TiposCajaEmbalajeLocal o")
})
public class TiposCajaEmbalajeLocal implements Serializable {

    public TiposCajaEmbalajeLocal() {}

    public TiposCajaEmbalajeLocal(Long oid, String valTipoCaja, Double numCapa, Double numCapaMini, String indCubi, Double numPorcSegu, Double numNiveApli, Long numEtiq, Double valAlto, Double valLarg, Double valAnch, Long paisOidPais, Long unmdOidUnidMediCapa, Long unmdOidUnidMediExte)	{
        this.oid=oid;
        setValTipoCaja(valTipoCaja);
        setNumCapa(numCapa);
        setNumCapaMini(numCapaMini);
        setIndCubi(indCubi);
        setNumPorcSegu(numPorcSegu);
        setNumNiveApli(numNiveApli);
        setNumEtiq(numEtiq);
        setValAlto(valAlto);
        setValLarg(valLarg);
        setValAnch(valAnch);
        setPaisOidPais(paisOidPais);
        setUnmdOidUnidMediCapa(unmdOidUnidMediCapa);
        setUnmdOidUnidMediExte(unmdOidUnidMediExte);
    }

    @Id
    @Column(name="OID_TIPO_CAJA_EMBA")
    private Long oid;
    @Column(name="VAL_TIPO_CAJA")
    private String valTipoCaja;
    @Column(name="NUM_CAPA")
    private Double numCapa;
    @Column(name="NUM_CAPA_MINI")
    private Double numCapaMini;
    @Column(name="IND_CUBI")
    private String indCubi;
    @Column(name="NUM_PORC_SEGU")
    private Double numPorcSegu;
    @Column(name="NUM_NIVE_APLI")
    private Double numNiveApli;
    @Column(name="NUM_ETIQ")
    private Long numEtiq;
    @Column(name="VAL_ALTO")
    private Double valAlto;
    @Column(name="VAL_LARG")
    private Double valLarg;
    @Column(name="VAL_ANCH")
    private Double valAnch;
    @Column(name="PAIS_OID_PAIS")
    private Long paisOidPais;
    @Column(name="UNMD_OID_UNID_MEDI_CAPA")
    private Long unmdOidUnidMediCapa;
    @Column(name="UNMD_OID_UNID_MEDI_EXTE")
    private Long unmdOidUnidMediExte;

    
    public Long getOid() {return oid;}
    
    public String getValTipoCaja() {return valTipoCaja;}
  
    public void setValTipoCaja(String valTipoCaja){this.valTipoCaja=valTipoCaja;}
            
    public Double getNumCapa() {return numCapa;}
  
    public void setNumCapa(Double numCapa){this.numCapa=numCapa;}
            
    public Double getNumCapaMini() {return numCapaMini;}
  
    public void setNumCapaMini(Double numCapaMini){this.numCapaMini=numCapaMini;}
            
    public String getIndCubi() {return indCubi;}
  
    public void setIndCubi(String indCubi){this.indCubi=indCubi;}
            
    public Double getNumPorcSegu() {return numPorcSegu;}
  
    public void setNumPorcSegu(Double numPorcSegu){this.numPorcSegu=numPorcSegu;}
            
    public Double getNumNiveApli() {return numNiveApli;}
  
    public void setNumNiveApli(Double numNiveApli){this.numNiveApli=numNiveApli;}
            
    public Long getNumEtiq() {return numEtiq;}
  
    public void setNumEtiq(Long numEtiq){this.numEtiq=numEtiq;}
            
    public Double getValAlto() {return valAlto;}
  
    public void setValAlto(Double valAlto){this.valAlto=valAlto;}
            
    public Double getValLarg() {return valLarg;}
  
    public void setValLarg(Double valLarg){this.valLarg=valLarg;}
            
    public Double getValAnch() {return valAnch;}
  
    public void setValAnch(Double valAnch){this.valAnch=valAnch;}
            
    public Long getPaisOidPais() {return paisOidPais;}
  
    public void setPaisOidPais(Long paisOidPais){this.paisOidPais=paisOidPais;}
            
    public Long getUnmdOidUnidMediCapa() {return unmdOidUnidMediCapa;}
  
    public void setUnmdOidUnidMediCapa(Long unmdOidUnidMediCapa){this.unmdOidUnidMediCapa=unmdOidUnidMediCapa;}
            
    public Long getUnmdOidUnidMediExte() {return unmdOidUnidMediExte;}
  
    public void setUnmdOidUnidMediExte(Long unmdOidUnidMediExte){this.unmdOidUnidMediExte=unmdOidUnidMediExte;}
			
	
}
