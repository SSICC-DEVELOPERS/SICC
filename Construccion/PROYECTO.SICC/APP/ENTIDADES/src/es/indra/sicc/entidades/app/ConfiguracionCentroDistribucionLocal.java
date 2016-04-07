package es.indra.sicc.entidades.app;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="APP_CONFI_CENTR_DISTR")
@NamedQueries({
@NamedQuery(name="ConfiguracionCentroDistribucionLocal.FindAll",query="select object(o) from ConfiguracionCentroDistribucionLocal o")
})
public class ConfiguracionCentroDistribucionLocal implements Serializable {

	public ConfiguracionCentroDistribucionLocal() {}

	public ConfiguracionCentroDistribucionLocal(Long oid, Long pais, Long nivelOut, Long ordProd, Long ordenListaPicado, Long agrupacionDefaultAFP,  Long imprDatoBasiClie, Long OidOrdeVisuCheq, String valOrdeVisuCheq )	{
            this.oid=oid;
	    this.pais = pais;
	    this.setCodCentroDist(new Long(oid.longValue() % 10000));
	    this.nivelOutsourcing = nivelOut;
	    this.ordenAscDesc = ordProd;
	    this.ordenListaPicado = ordenListaPicado;
	    this.agrupacionDefaultAFP = agrupacionDefaultAFP;
            this.impresionDatosBasicos = imprDatoBasiClie;
            this.oidOredenVisualChequeo = OidOrdeVisuCheq;
            this.ordenVisualChequeo = valOrdeVisuCheq;

	}

	@Id
	@Column(name="OID_CONF_CENT_DIST")
	private Long oid;
	@Column(name="COD_CENT_DIST")
	private Long codCentroDist;
	@Column(name="VAL_FUER_PEDI_DEFA")
	private String fueraPedidoDefault;
	@Column(name="VAL_TEXT_CHEQ")
	private String textoChequeos;
	@Column(name="VAL_TEXT_PRIM_PEDI")
	private String textoPrimerPedido;
	@Column(name="NUM_LONG_ETIQ")
	private Long longitudEtiqueta;
	@Column(name="VAL_DEFE")
	private String valorDefecto;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="NIOU_OID_NIVE_OUTS")
	private Long nivelOutsourcing;
	@Column(name="ORPR_OID_ORDE_PROD")
	private Long ordenAscDesc;
	@Column(name="ORLP_OID_ORDE_LIST_PICA")
	private Long ordenListaPicado;
	@Column(name="AAFP_OID_AAFP")
	private Long agrupacionDefaultAFP;
        //Agregado por cambio 20090839 
        @Column(name="IND_IMPR_DATO_BASI_CLIE")
        private Long impresionDatosBasicos;
        @Column(name="OVCH_OID_ORDE_VISU_CHEQ")
        private Long oidOredenVisualChequeo;
        @Column(name="VAL_ORDE_VISU_CHEQ")
        private String ordenVisualChequeo;
	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getCodCentroDist() {return codCentroDist;}
      
	public void setCodCentroDist(Long codCentroDist){this.codCentroDist=codCentroDist;}
		
	public String getFueraPedidoDefault() {return fueraPedidoDefault;}
      
	public void setFueraPedidoDefault(String fueraPedidoDefault){this.fueraPedidoDefault=fueraPedidoDefault;}
		
	public String getTextoChequeos() {return textoChequeos;}
      
	public void setTextoChequeos(String textoChequeos){this.textoChequeos=textoChequeos;}
		
	public String getTextoPrimerPedido() {return textoPrimerPedido;}
      
	public void setTextoPrimerPedido(String textoPrimerPedido){this.textoPrimerPedido=textoPrimerPedido;}
		
	public Long getLongitudEtiqueta() {return longitudEtiqueta;}
      
	public void setLongitudEtiqueta(Long longitudEtiqueta){this.longitudEtiqueta=longitudEtiqueta;}
		
	public String getValorDefecto() {return valorDefecto;}
      
	public void setValorDefecto(String valorDefecto){this.valorDefecto=valorDefecto;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getNivelOutsourcing() {return nivelOutsourcing;}
      
	public void setNivelOutsourcing(Long nivelOutsourcing){this.nivelOutsourcing=nivelOutsourcing;}
		
	public Long getOrdenAscDesc() {return ordenAscDesc;}
      
	public void setOrdenAscDesc(Long ordenAscDesc){this.ordenAscDesc=ordenAscDesc;}
		
	public Long getOrdenListaPicado() {return ordenListaPicado;}
      
	public void setOrdenListaPicado(Long ordenListaPicado){this.ordenListaPicado=ordenListaPicado;}
		
	public Long getAgrupacionDefaultAFP() {return agrupacionDefaultAFP;}
      
	public void setAgrupacionDefaultAFP(Long agrupacionDefaultAFP){this.agrupacionDefaultAFP=agrupacionDefaultAFP;}

        //Agregado por cambio 20090839            
        public Long getImpresionDatosBasicos() {return impresionDatosBasicos;}
        
        public void setImpresionDatosBasicos(Long impresionDatosBasicos){this.impresionDatosBasicos=impresionDatosBasicos;}
        
        public Long getOidOredenVisualChequeo() {return oidOredenVisualChequeo;}
        
        public void setOidOredenVisualChequeo(Long oidOredenVisualChequeo){this.oidOredenVisualChequeo=oidOredenVisualChequeo;}
        
        public String getOrdenVisualChequeo() {return ordenVisualChequeo;}
        
        public void setOrdenVisualChequeo(String ordenVisualChequeo){this.ordenVisualChequeo=ordenVisualChequeo;}
			
	
}
