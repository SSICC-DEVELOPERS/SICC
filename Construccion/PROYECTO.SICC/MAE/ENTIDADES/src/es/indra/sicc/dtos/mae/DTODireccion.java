package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Submódulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:           05/2/2004
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Juan Pablo Bosnjak
 * Modificado: SICC-GCC-MAE-005 - Cleal
 */
public class DTODireccion  extends DTOAuditableSICC{
  private Long tipoDireccion;
  private Long tipoVia;
  private Long unidadGeografica;
  private Long via;
  
  // V-PED001 - dmorello, 06/10/2006: Se cambia el tipo de Integer a String
  private String numeroPrincipal;
  
  private String codigoPostal;
  private Integer interior;
  private Integer manzana;
  private Integer lote;
  private Integer kilometro;
  private String observaciones;
  private Boolean esDireccionPrincipal;
  private Long oid;
  private String nombreVia;
  private String nombreUnidadGeografica;
  private String tipoDireccionDescripcion;
  private String tipoViaDescripcion;

  public DTODireccion() {
  }

  public Long getTipoDireccion() {
    return tipoDireccion;
  }

  public void setTipoDireccion(Long newTipoDireccion) {
    tipoDireccion = newTipoDireccion;
  }

  public Long getTipoVia() {
    return tipoVia;
  }

  public void setTipoVia(Long newTipoVia) {
    tipoVia = newTipoVia;
  }

  public Long getUnidadGeografica() {
    return unidadGeografica;
  }

  public void setUnidadGeografica(Long newUnidadGeografica) {
    unidadGeografica = newUnidadGeografica;
  }

  public Long getVia() {
    return via;
  }

  public void setVia(Long newVia) {
    via = newVia;
  }

  public String getNumeroPrincipal() {
    return numeroPrincipal;
  }

  public void setNumeroPrincipal(String newNumeroPrincipal) {
    numeroPrincipal = newNumeroPrincipal;
  }

  public String getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(String newCodigoPostal) {
    codigoPostal = newCodigoPostal;
  }

  public Integer getInterior() {
    return interior;
  }

  public void setInterior(Integer newInterior) {
    interior = newInterior;
  }

  public Integer getManzana() {
    return manzana;
  }

  public void setManzana(Integer newManzana) {
    manzana = newManzana;
  }

  public Integer getLote() {
    return lote;
  }

  public void setLote(Integer newLote) {
    lote = newLote;
  }

  public Integer getKilometro() {
    return kilometro;
  }

  public void setKilometro(Integer newKilometro) {
    kilometro = newKilometro;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String newObservaciones) {
    observaciones = newObservaciones;
  }

  public Boolean isEsDireccionPrincipal() {
    return esDireccionPrincipal;
  }

  public Boolean getEsDireccionPrincipal() {
    return esDireccionPrincipal;
  }

  public void setEsDireccionPrincipal(Boolean newEsDireccionPrincipal) {
    esDireccionPrincipal = newEsDireccionPrincipal;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }

  public String getNombreVia() {
    return nombreVia;
  }

  public void setNombreVia(String newNombreVia) {
    nombreVia = newNombreVia;
  }

	public String getNombreUnidadGeografica() {
		return nombreUnidadGeografica;
	}

	public void setNombreUnidadGeografica(String newNombreUnidadGeografica) {
		nombreUnidadGeografica = newNombreUnidadGeografica;
	}


    public void setTipoDireccionDescripcion(String tipoDireccionDescripcion)
    {
        this.tipoDireccionDescripcion = tipoDireccionDescripcion;
    }


    public String getTipoDireccionDescripcion()
    {
        return tipoDireccionDescripcion;
    }


    public void setTipoViaDescripcion(String tipoViaDescripcion)
    {
        this.tipoViaDescripcion = tipoViaDescripcion;
    }


    public String getTipoViaDescripcion()
    {
        return tipoViaDescripcion;
    }
  
}