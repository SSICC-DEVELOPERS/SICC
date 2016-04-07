package es.indra.sicc.entidades.fac;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="FAC_FORMU")
@NamedQueries({
@NamedQuery(name="FormularioLocal.FindAll",query="select object(o) from FormularioLocal o"),
@NamedQuery(name="FormularioLocal.FindByTipoDocumento",query="SELECT OBJECT(o) FROM FormularioLocal AS o WHERE o.tipoDocumento=?1")
})
public class FormularioLocal implements Serializable {

	public FormularioLocal() {}

	public FormularioLocal(Long oid, String codigo, Short numLineasPagina, String tamanio, String rutinaDisenyoFormato, Boolean imprimible, Boolean preimpreso, Boolean spoolIndividualPaquetei, Long tecnologia, String nombre, Boolean activo, Boolean numeracionOficial, Short numLineasSaltoPagina, Long tipoDocumento, Long destino)	{
            this.oid=oid;
	    this.codigo = codigo;
	    this.numLineasPagina = numLineasPagina;
	    this.tamanyo = tamanio;
	    this.rutinaDisenyoFormato = rutinaDisenyoFormato;
	    this.imprimible = imprimible;
	    this.preimpreso = preimpreso;
	    this.spoolIndividualPaquete = spoolIndividualPaquetei;
	    this.tecnologia = tecnologia;
	    this.nombre = nombre;
	    this.activo = activo;
	    this.numeracionOficial = numeracionOficial;
	    this.numLineasSaltoPagina = numLineasSaltoPagina;
	    this.tipoDocumento = tipoDocumento;
	    this.destino = destino;
	}


        public FormularioLocal(Long oid, String codigo, Short numLineasPagina, String tamanio, String rutinaDisenyoFormato, Boolean imprimible, Boolean preimpreso, Boolean spoolIndividualPaquetei, Long tecnologia, String nombre, Boolean activo, Boolean numeracionOficial, Short numLineasSaltoPagina, Long tipoDocumento, Long destino, Long TipoFormulario)   {
            this.oid=oid;
            this.codigo = codigo;
            this.numLineasPagina = numLineasPagina;
            this.tamanyo = tamanio;
            this.rutinaDisenyoFormato = rutinaDisenyoFormato;
            this.imprimible = imprimible;
            this.preimpreso = preimpreso;
            this.spoolIndividualPaquete = spoolIndividualPaquetei;
            this.tecnologia = tecnologia;
            this.nombre = nombre;
            this.activo = activo;
            this.numeracionOficial = numeracionOficial;
            this.numLineasSaltoPagina = numLineasSaltoPagina;
            this.tipoDocumento = tipoDocumento;
            this.destino = destino;
            this.tipoFormulario = TipoFormulario;
        }

	@Id
	@Column(name="OID_FORM")
	private Long oid;
	@Column(name="COD_FORM")
	private String codigo;
	@Column(name="NUM_LINE")
	private Short numLineasPagina;
	@Column(name="VAL_TAMA_FORM")
	private String tamanyo;
	@Column(name="VAL_RUTI_DISE_FORM")
	private String rutinaDisenyoFormato;
	@Column(name="IND_IMPR")
	private Boolean imprimible;
	@Column(name="IND_PREI")
	private Boolean preimpreso;
	@Column(name="IND_SPOO_INDI")
	private Boolean spoolIndividualPaquete;
	@Column(name="TEIM_OID_TECN")
	private Long tecnologia;
	@Column(name="VAL_NOMB_FORM")
	private String nombre;
	@Column(name="IND_ACTI")
	private Boolean activo;
	@Column(name="IND_NUM_OFIC")
	private Boolean numeracionOficial;
	@Column(name="NUM_LINE_SALT_PAGI")
	private Short numLineasSaltoPagina;
	@Column(name="TIDO_OID_TIPO_DOCU")
	private Long tipoDocumento;
	@Column(name="DEIM_OID_DEST_IMPR")
	private Long destino;
	@Column(name="TIFO_OID_TIPO_FORM")
	private Long tipoFormulario;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigo() {return codigo;}
      
	public void setCodigo(String codigo){this.codigo=codigo;}
		
	public Short getNumLineasPagina() {return numLineasPagina;}
      
	public void setNumLineasPagina(Short numLineasPagina){this.numLineasPagina=numLineasPagina;}
		
	public String getTamanyo() {return tamanyo;}
      
	public void setTamanyo(String tamanyo){this.tamanyo=tamanyo;}
		
	public String getRutinaDisenyoFormato() {return rutinaDisenyoFormato;}
      
	public void setRutinaDisenyoFormato(String rutinaDisenyoFormato){this.rutinaDisenyoFormato=rutinaDisenyoFormato;}
		
	public Boolean getImprimible() {return imprimible;}
      
	public void setImprimible(Boolean imprimible){this.imprimible=imprimible;}
		
	public Boolean getPreimpreso() {return preimpreso;}
      
	public void setPreimpreso(Boolean preimpreso){this.preimpreso=preimpreso;}
		
	public Boolean getSpoolIndividualPaquete() {return spoolIndividualPaquete;}
      
	public void setSpoolIndividualPaquete(Boolean spoolIndividualPaquete){this.spoolIndividualPaquete=spoolIndividualPaquete;}
		
	public Long getTecnologia() {return tecnologia;}
      
	public void setTecnologia(Long tecnologia){this.tecnologia=tecnologia;}
		
	public String getNombre() {return nombre;}
      
	public void setNombre(String nombre){this.nombre=nombre;}
		
	public Boolean getActivo() {return activo;}
      
	public void setActivo(Boolean activo){this.activo=activo;}
		
	public Boolean getNumeracionOficial() {return numeracionOficial;}
      
	public void setNumeracionOficial(Boolean numeracionOficial){this.numeracionOficial=numeracionOficial;}
		
	public Short getNumLineasSaltoPagina() {return numLineasSaltoPagina;}
      
	public void setNumLineasSaltoPagina(Short numLineasSaltoPagina){this.numLineasSaltoPagina=numLineasSaltoPagina;}
		
	public Long getTipoDocumento() {return tipoDocumento;}
      
	public void setTipoDocumento(Long tipoDocumento){this.tipoDocumento=tipoDocumento;}
		
	public Long getDestino() {return destino;}
      
	public void setDestino(Long destino){this.destino=destino;}
		
	public Long getTipoFormulario() {return tipoFormulario;}
      
	public void setTipoFormulario(Long tipoFormulario){this.tipoFormulario=tipoFormulario;}
			
	
}
