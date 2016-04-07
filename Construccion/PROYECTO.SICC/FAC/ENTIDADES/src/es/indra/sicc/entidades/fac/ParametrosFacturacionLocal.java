package es.indra.sicc.entidades.fac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="FAC_PARAM_FACTU")
@NamedQueries({
@NamedQuery(name="ParametrosFacturacionLocal.FindByPais",query="SELECT OBJECT(t) FROM ParametrosFacturacionLocal AS t WHERE t.pais = ?1")
})
public class ParametrosFacturacionLocal implements Serializable {

	public ParametrosFacturacionLocal() {}

	public ParametrosFacturacionLocal(Long oid, Long pais, Byte maxCampanyasPDR, Short maxPedidosProyeccion, Long esDocumentoMonopagina, Boolean chequeoClienteNuevo, Boolean indTipoProyeccionRegion, Boolean indPrecioContable, Boolean mostrarVctoCupon)	{
            this.oid=oid;
	    this.pais = pais;
	    this.maxCampanyasPRD = maxCampanyasPDR; 
	    this.maxPedidosProyeccion = maxPedidosProyeccion;
	    this.esDocumentoMonopagina = esDocumentoMonopagina;
	    this.chequeoclienteNuevo = chequeoClienteNuevo;
	    this.indTipoProyeccionRegion = indTipoProyeccionRegion;
	    this.indPrecioContable = indPrecioContable;
	    this.mostrarVctoCupon = mostrarVctoCupon;
        }

        public ParametrosFacturacionLocal(Long oid,Long pais, Integer montoLimiteUIT, Byte maxCampanyasPDR, Short maxPedidosProyeccion, Long esDocumentoMonopagina, Boolean chequeoClienteNuevo, Boolean indTipoProyeccionRegion, Boolean indPrecioContable, Boolean mostrarVctoCupon)     {
            this.oid=oid;
            this.pais = pais;
            this.montoLimiteUIT = montoLimiteUIT;
            this.maxCampanyasPRD = maxCampanyasPDR; 
            this.maxPedidosProyeccion = maxPedidosProyeccion;
            this.esDocumentoMonopagina = esDocumentoMonopagina;
            this.chequeoclienteNuevo = chequeoClienteNuevo;
            this.indTipoProyeccionRegion = indTipoProyeccionRegion;
            this.indPrecioContable = indPrecioContable;
            this.mostrarVctoCupon = mostrarVctoCupon;
        }

	@Id
	@Column(name="OID_PARA")
	private Long oid;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="VAL_MONT_LIMI_UIT")
	private Integer montoLimiteUIT;
	@Column(name="NUM_MAXI_CAMP_PRD")
	private Byte maxCampanyasPRD;
	@Column(name="NUM_MAXI_PEDI_PROY")
	private Short maxPedidosProyeccion;
	@Column(name="IND_DOCU_MONO_PAGI")
	private Long esDocumentoMonopagina;
	@Column(name="IND_CHEQ_CLIE_NUEV")
	private Boolean chequeoclienteNuevo;
	@Column(name="IND_TIPO_PROY_REGI")
	private Boolean indTipoProyeccionRegion;
	@Column(name="IND_PREC_CONT")
	private Boolean indPrecioContable;
	@Column(name="IND_MOST_VENC_CUPO")
	private Boolean mostrarVctoCupon;
	@Column(name="COD_MODA_DIST")
	private String modalidadDistribucion;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Integer getMontoLimiteUIT() {return montoLimiteUIT;}
      
	public void setMontoLimiteUIT(Integer montoLimiteUIT){this.montoLimiteUIT=montoLimiteUIT;}
		
	public Byte getMaxCampanyasPRD() {return maxCampanyasPRD;}
      
	public void setMaxCampanyasPRD(Byte maxCampanyasPRD){this.maxCampanyasPRD=maxCampanyasPRD;}
		
	public Short getMaxPedidosProyeccion() {return maxPedidosProyeccion;}
      
	public void setMaxPedidosProyeccion(Short maxPedidosProyeccion){this.maxPedidosProyeccion=maxPedidosProyeccion;}
		
	public Long getEsDocumentoMonopagina() {return esDocumentoMonopagina;}
      
	public void setEsDocumentoMonopagina(Long esDocumentoMonopagina){this.esDocumentoMonopagina=esDocumentoMonopagina;}
		
	public Boolean getChequeoclienteNuevo() {return chequeoclienteNuevo;}
      
	public void setChequeoclienteNuevo(Boolean chequeoclienteNuevo){this.chequeoclienteNuevo=chequeoclienteNuevo;}
		
	public Boolean getIndTipoProyeccionRegion() {return indTipoProyeccionRegion;}
      
	public void setIndTipoProyeccionRegion(Boolean indTipoProyeccionRegion){this.indTipoProyeccionRegion=indTipoProyeccionRegion;}
		
	public Boolean getIndPrecioContable() {return indPrecioContable;}
      
	public void setIndPrecioContable(Boolean indPrecioContable){this.indPrecioContable=indPrecioContable;}
		
	public Boolean getMostrarVctoCupon() {return mostrarVctoCupon;}
      
	public void setMostrarVctoCupon(Boolean mostrarVctoCupon){this.mostrarVctoCupon=mostrarVctoCupon;}
		
	public String getModalidadDistribucion() {return modalidadDistribucion;}
      
	public void setModalidadDistribucion(String modalidadDistribucion){this.modalidadDistribucion=modalidadDistribucion;}
			
	
}
