/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTOComisionesClientes
 * Fecha:             07/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-DTO-201-334-N024-1
 * Descripcion:       DTOComisionesClientes
 * @version           1.0
 * @autor             Carlos Leal
 */

package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;
import java.sql.Date;

public class DTOComisionesClientes extends DTOAuditableSICC {
  private Long oid;
  private Long oidComisiones;
  private Integer numero;
  private BigDecimal topeMaximo;
  private BigDecimal topeMinimo;
  private Date fecAntiguedadDesde;
  private Date fecAntiguedadHasta;
  private Long oidTipoClienteComisionesCabecera;
  private String descTipoClienteComisionesCabecera;
  private Long oidSubgerencia;
  private String descSubgerencia;  
  private Long oidRegion;
  private String descRegion;    
  private Long oidZona;
  private String descZona;  
  private Long oidSeccion;
  private String descSeccion;  
  private Long oidTerritorio;
  private String descTerritorio;

  public DTOComisionesClientes() { }
  
  public String getDescTerritorio()  {
    return this.descTerritorio;
  }
  
  public void setDescTerritorio(String newDescTerritorio)  {
    this.descTerritorio = newDescTerritorio;
  }   
  
  public String getDescSeccion()  {
    return this.descSeccion;
  }
  
  public void setDescSeccion(String newDescSeccion) {
    this.descSeccion = newDescSeccion;
  }
  
  public String getDescZona() {
    return this.descZona;
  }
  
  public void setDescZona(String newDescZona) {
    this.descZona = newDescZona;
  } 
  
  public String getDescRegion()  {
    return this.descRegion;
  }
  
  public void setDescRegion(String newDescRegion) {
    this.descRegion = newDescRegion;
  }  
  
  public String getDescSubgerencia() {
    return this.descSubgerencia;
  }
  
  public void setDescSubgerencia(String newDescSubgerencia) {
    this.descSubgerencia = newDescSubgerencia;
  }
  
  public String getDescTipoClienteComisionesCabecera() {
    return this.descTipoClienteComisionesCabecera;    
  }
  
  public void setDescTipoClienteComisionesCabecera(String newDescTipoClienteComisionesCabecera) {
    this.descTipoClienteComisionesCabecera = newDescTipoClienteComisionesCabecera;
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidComisiones()
  {
    return oidComisiones;
  }

  public void setOidComisiones(Long oidComisiones)
  {
    this.oidComisiones = oidComisiones;
  }

  public Integer getNumero()
  {
    return numero;
  }

  public void setNumero(Integer numero)
  {
    this.numero = numero;
  }

  public BigDecimal getTopeMaximo()
  {
    return topeMaximo;
  }

  public void setTopeMaximo(BigDecimal topeMaximo)
  {
    this.topeMaximo = topeMaximo;
  }

  public BigDecimal getTopeMinimo()
  {
    return topeMinimo;
  }

  public void setTopeMinimo(BigDecimal topeMinimo)
  {
    this.topeMinimo = topeMinimo;
  }

  public Date getFecAntiguedadDesde()
  {
    return fecAntiguedadDesde;
  }

  public void setFecAntiguedadDesde(Date fecAntiguedadDesde)
  {
    this.fecAntiguedadDesde = fecAntiguedadDesde;
  }

  public Date getFecAntiguedadHasta()
  {
    return fecAntiguedadHasta;
  }

  public void setFecAntiguedadHasta(Date fecAntiguedadHasta)
  {
    this.fecAntiguedadHasta = fecAntiguedadHasta;
  }

  public Long getOidTipoClienteComisionesCabecera()
  {
    return oidTipoClienteComisionesCabecera;
  }

  public void setOidTipoClienteComisionesCabecera(Long oidTipoClienteComisionesCabecera)
  {
    this.oidTipoClienteComisionesCabecera = oidTipoClienteComisionesCabecera;
  }

  public Long getOidSubgerencia()
  {
    return oidSubgerencia;
  }

  public void setOidSubgerencia(Long oidSubgerencia)
  {
    this.oidSubgerencia = oidSubgerencia;
  }

  public Long getOidRegion()
  {
    return oidRegion;
  }

  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public Long getOidSeccion()
  {
    return oidSeccion;
  }

  public void setOidSeccion(Long oidSeccion)
  {
    this.oidSeccion = oidSeccion;
  }

  public Long getOidTerritorio()
  {
    return oidTerritorio;
  }

  public void setOidTerritorio(Long oidTerritorio)
  {
    this.oidTerritorio = oidTerritorio;
  }
}