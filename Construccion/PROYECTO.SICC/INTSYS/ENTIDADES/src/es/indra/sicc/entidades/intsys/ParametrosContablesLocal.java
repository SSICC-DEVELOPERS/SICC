package es.indra.sicc.entidades.intsys;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="INT_PARAM_CONTA_FACTU")
@NamedQueries({
@NamedQuery(name="ParametrosContablesLocal.FindAll",query="select object(o) from ParametrosContablesLocal o")
})
public class ParametrosContablesLocal implements Serializable {

	public ParametrosContablesLocal() {}

	public ParametrosContablesLocal(Long oid, String codigoApunte, String tipoAsiento, String identificadorCabeceraDetalle, String descripcion, String indicadorDebeHaber, Long pais, Long cuentaContable, Long importeAContabilizar)	{
            this.oid=oid;
	    this.codigoApunte=codigoApunte;
	    this.tipoAsiento=tipoAsiento;
	    this.identificadorCabeceraDetalle=identificadorCabeceraDetalle;
	    this.descripcion=descripcion;
	    this.indicadorDebeHaber=indicadorDebeHaber;
	    this.pais=pais;
	    this.cuentaContable=cuentaContable;
	    this.importeAContabilizar=importeAContabilizar;
	
	}
        
	@Id
	@Column(name="OID_PARA_CONT_FACT")
	private Long oid;
	@Column(name="COD_APUN")
	private String codigoApunte;
	@Column(name="VAL_TIPO_ASIE")
	private String tipoAsiento;
	@Column(name="VAL_IDEN_CABE_DETA")
	private String identificadorCabeceraDetalle;
	@Column(name="VAL_DESC")
	private String descripcion;
	@Column(name="VAL_GRUP_ARTI")
	private String grupoArticulos;
	@Column(name="VAL_INDI_DEBE_HABE")
	private String indicadorDebeHaber;
	@Column(name="PAIS_OID_PAIS")
	private Long pais;
	@Column(name="PROD_OID_PROD")
	private Long producto;
	@Column(name="CUCO_OID_CUEN_CONT")
	private Long cuentaContable;
	@Column(name="MAPR_OID_MARC_PROD")
	private Long marcaProducto;
	@Column(name="NEGO_OID_NEGO")
	private Long negocio;
	@Column(name="IMCF_OID_IMPO_CONT_FACT")
	private Long importeAContabilizar;

	
	public Long getOid() {return oid;}
      
	//public void setOid(Long oid){this.oid=oid;}
	
	public Long getPrimaryKey() {return oid;}		
		
	public String getCodigoApunte() {return codigoApunte;}
      
	public void setCodigoApunte(String codigoApunte){this.codigoApunte=codigoApunte;}
		
	public String getTipoAsiento() {return tipoAsiento;}
      
	public void setTipoAsiento(String tipoAsiento){this.tipoAsiento=tipoAsiento;}
		
	public String getIdentificadorCabeceraDetalle() {return identificadorCabeceraDetalle;}
      
	public void setIdentificadorCabeceraDetalle(String identificadorCabeceraDetalle){this.identificadorCabeceraDetalle=identificadorCabeceraDetalle;}
		
	public String getDescripcion() {return descripcion;}
      
	public void setDescripcion(String descripcion){this.descripcion=descripcion;}
		
	public String getGrupoArticulos() {return grupoArticulos;}
      
	public void setGrupoArticulos(String grupoArticulos){this.grupoArticulos=grupoArticulos;}
		
	public String getIndicadorDebeHaber() {return indicadorDebeHaber;}
      
	public void setIndicadorDebeHaber(String indicadorDebeHaber){this.indicadorDebeHaber=indicadorDebeHaber;}
		
	public Long getPais() {return pais;}
      
	public void setPais(Long pais){this.pais=pais;}
		
	public Long getProducto() {return producto;}
      
	public void setProducto(Long producto){this.producto=producto;}
		
	public Long getCuentaContable() {return cuentaContable;}
      
	public void setCuentaContable(Long cuentaContable){this.cuentaContable=cuentaContable;}
		
	public Long getMarcaProducto() {return marcaProducto;}
      
	public void setMarcaProducto(Long marcaProducto){this.marcaProducto=marcaProducto;}
		
	public Long getNegocio() {return negocio;}
      
	public void setNegocio(Long negocio){this.negocio=negocio;}
		
	public Long getImporteAContabilizar() {return importeAContabilizar;}
      
	public void setImporteAContabilizar(Long importeAContabilizar){this.importeAContabilizar=importeAContabilizar;}
			
	
}
