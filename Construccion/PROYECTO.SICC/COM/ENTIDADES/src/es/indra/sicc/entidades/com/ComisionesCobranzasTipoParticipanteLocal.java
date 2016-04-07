package es.indra.sicc.entidades.com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigDecimal;

import java.io.Serializable;

@Entity
@Table(name="COM_COMIS_COBRA_TIPO_PARTI")
@NamedQueries({
@NamedQuery(name="ComisionesCobranzasTipoParticipanteLocal.FindAll",query="select object(o) from ComisionesCobranzasTipoParticipanteLocal o"),
@NamedQuery(name="ComisionesCobranzasTipoParticipanteLocal.FindByCobranza",query="select object(c) from ComisionesCobranzasTipoParticipanteLocal c where c.cobranza = ?1")
})
public class ComisionesCobranzasTipoParticipanteLocal implements Serializable {

	public ComisionesCobranzasTipoParticipanteLocal() {}

	public ComisionesCobranzasTipoParticipanteLocal(Long oid, Integer nivelTramo, BigDecimal porcentajeRecuperacion, Long cobranza, BigDecimal porcentajeComision)	{
	
		this.oid=oid;
                this.setNivelTramo(nivelTramo);
	        this.setPorcentajeRecuperacion(porcentajeRecuperacion);
	        this.setCobranza(cobranza);
	        this.setPorcentajeComision(porcentajeComision);
	
	}

	@Id
	@Column(name="OID_COMI_COBR_TIPO_PART")
	private Long oid;
	@Column(name="VAL_NIVE_TRAM")
	private Integer nivelTramo;
	@Column(name="NUM_DIAS_COMI")
	private Integer diasComision;
	@Column(name="VAL_PORC_RECU")
	private java.math.BigDecimal porcentajeRecuperacion;
	@Column(name="COCO_OID_COMI_COBR")
	private Long cobranza;
	@Column(name="VAL_PORC_COMI")
	private java.math.BigDecimal porcentajeComision;
        // vbongiov -- Cambio 20090913 -- 5/08/2009
        @Column(name="VAL_PORC_ACTI")
        private java.math.BigDecimal porcentajeActividad;

        // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
        @Column(name="VAL_PORC_COMI_ACTI")
        private java.math.BigDecimal porcentajeComisionActividad;
	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Integer getNivelTramo() {return nivelTramo;}
      
	public void setNivelTramo(Integer nivelTramo){this.nivelTramo=nivelTramo;}
		
	public Integer getDiasComision() {return diasComision;}
      
	public void setDiasComision(Integer diasComision){this.diasComision=diasComision;}
		
	public java.math.BigDecimal getPorcentajeRecuperacion() {return porcentajeRecuperacion;}
      
	public void setPorcentajeRecuperacion(java.math.BigDecimal porcentajeRecuperacion){this.porcentajeRecuperacion=porcentajeRecuperacion;}
		
	public Long getCobranza() {return cobranza;}
      
	public void setCobranza(Long cobranza){this.cobranza=cobranza;}
		
	public java.math.BigDecimal getPorcentajeComision() {return porcentajeComision;}
      
	public void setPorcentajeComision(java.math.BigDecimal porcentajeComision){this.porcentajeComision=porcentajeComision;}
        
        public BigDecimal getPorcentajeActividad()
        {
          return porcentajeActividad;
        }
        
        public void setPorcentajeActividad(BigDecimal porcentajeActividad)
        {
          this.porcentajeActividad = porcentajeActividad;
        }

        public BigDecimal getPorcentajeComisionActividad()
        {
          return porcentajeComisionActividad;
        }
        
        public void setPorcentajeComisionActividad(BigDecimal porcentajeComisionActividad)
        {
          this.porcentajeComisionActividad = porcentajeComisionActividad;
        }
			
	
}
