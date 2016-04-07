package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;
import es.indra.sicc.dtos.inc.DTOListaMetasVentaProyectada;
import es.indra.sicc.dtos.inc.DTOListaMetasTipoVenta;
import java.math.BigDecimal;

public class DTOParametrosCalificacion extends DTOBelcorp {
  private Long oidParamCalificacion;
  private Boolean indDevoluciones;
  private Boolean indAnulaciones;
  private Boolean indFaltantesNoAnunciados;
  private Boolean indMetasModificables;
  private Long oidDirigidoA;
  private Long oidFormaCalculo;
  private Boolean indComunicacion;
  private String mensaje;
  private Long oidPeriodoDesde;
  private Long oidPeriodoHasta;
  private Long oidTipoDeterminacionMetas;
  private Long oidTipoIncremento;
  private Long oidTipoVentaCalificacion;
  private Long oidTipoVentaHistorica;
  private Long oidTipoVentaIncremental;
  private ArrayList lstIncrementosPorRango;
  private Boolean indMetasBloqueadas;
  private DTOListaMetasVentaProyectada listaMetasVentaProyectada;
  private DTOListaMetasTipoVenta listaMetasTipoVenta;
  private Long oidAgrupacion;
  private BigDecimal valorIncremento;
  //Agregado por Cristian Valenzuela - 22/2/2006
  //Incidencia 22393
  private DTOListaMetasVentaProyectada listaMetasVentaProyectadaRegion;
  private DTOListaMetasVentaProyectada listaMetasVentaProyectadaZona;  
  //FIN - Agregado por Cristian Valenzuela
  
  public DTOListaMetasVentaProyectada getListaMetasVentaProyectadaRegion() 
  {
    return this.listaMetasVentaProyectadaRegion;
  }
  
  public void setListaMetasVentaProyectadaRegion(DTOListaMetasVentaProyectada dto) 
  {
    this.listaMetasVentaProyectadaRegion = dto;
  }
  
  public DTOListaMetasVentaProyectada getListaMetasVentaProyectadaZona() 
  {
    return this.listaMetasVentaProyectadaZona;
  }
  
  public void setListaMetasVentaProyectadaZona(DTOListaMetasVentaProyectada dto) 
  {
    this.listaMetasVentaProyectadaZona = dto;
  } 

  public Long getOidParamCalificacion()
  {
    return oidParamCalificacion;
  }

  public void setOidParamCalificacion(Long oidParamCalificacion)
  {
    this.oidParamCalificacion = oidParamCalificacion;
  }

  public Boolean getIndDevoluciones()
  {
    return indDevoluciones;
  }

  public void setIndDevoluciones(Boolean indDevoluciones)
  {
    this.indDevoluciones = indDevoluciones;
  }

  public Boolean getIndAnulaciones()
  {
    return indAnulaciones;
  }

  public void setIndAnulaciones(Boolean indAnulaciones)
  {
    this.indAnulaciones = indAnulaciones;
  }

  public Boolean getIndFaltantesNoAnunciados()
  {
    return indFaltantesNoAnunciados;
  }

  public void setIndFaltantesNoAnunciados(Boolean indFaltantesNoAnunciados)
  {
    this.indFaltantesNoAnunciados = indFaltantesNoAnunciados;
  }

  public Boolean getIndMetasModificables()
  {
    return indMetasModificables;
  }

  public void setIndMetasModificables(Boolean indMetasModificables)
  {
    this.indMetasModificables = indMetasModificables;
  }

  public Long getOidDirigidoA()
  {
    return oidDirigidoA;
  }

  public void setOidDirigidoA(Long oidDirigidoA)
  {
    this.oidDirigidoA = oidDirigidoA;
  }

  public Long getOidFormaCalculo()
  {
    return oidFormaCalculo;
  }

  public void setOidFormaCalculo(Long oidFormaCalculo)
  {
    this.oidFormaCalculo = oidFormaCalculo;
  }

  public Boolean getIndComunicacion()
  {
    return indComunicacion;
  }

  public void setIndComunicacion(Boolean indComunicacion)
  {
    this.indComunicacion = indComunicacion;
  }

  public String getMensaje()
  {
    return mensaje;
  }

  public void setMensaje(String mensaje)
  {
    this.mensaje = mensaje;
  }

  public Long getOidPeriodoDesde()
  {
    return oidPeriodoDesde;
  }

  public void setOidPeriodoDesde(Long oidPeriodoDesde)
  {
    this.oidPeriodoDesde = oidPeriodoDesde;
  }

  public Long getOidPeriodoHasta()
  {
    return oidPeriodoHasta;
  }

  public void setOidPeriodoHasta(Long oidPeriodoHasta)
  {
    this.oidPeriodoHasta = oidPeriodoHasta;
  }

  public Long getOidTipoDeterminacionMetas()
  {
    return oidTipoDeterminacionMetas;
  }

  public void setOidTipoDeterminacionMetas(Long oidTipoDeterminacionMetas)
  {
    this.oidTipoDeterminacionMetas = oidTipoDeterminacionMetas;
  }

  public Long getOidTipoIncremento()
  {
    return oidTipoIncremento;
  }

  public void setOidTipoIncremento(Long oidTipoIncremento)
  {
    this.oidTipoIncremento = oidTipoIncremento;
  }

  public Long getOidTipoVentaCalificacion()
  {
    return oidTipoVentaCalificacion;
  }

  public void setOidTipoVentaCalificacion(Long oidTipoVentaCalificacion)
  {
    this.oidTipoVentaCalificacion = oidTipoVentaCalificacion;
  }

  public Long getOidTipoVentaHistorica()
  {
    return oidTipoVentaHistorica;
  }

  public void setOidTipoVentaHistorica(Long oidTipoVentaHistorica)
  {
    this.oidTipoVentaHistorica = oidTipoVentaHistorica;
  }

  public Long getOidTipoVentaIncremental()
  {
    return oidTipoVentaIncremental;
  }

  public void setOidTipoVentaIncremental(Long oidTipoVentaIncremental)
  {
    this.oidTipoVentaIncremental = oidTipoVentaIncremental;
  }

  public ArrayList getLstIncrementosPorRango()
  {
    return lstIncrementosPorRango;
  }

  public void setLstIncrementosPorRango(ArrayList lstIncrementosPorRango)
  {
    this.lstIncrementosPorRango = lstIncrementosPorRango;
  }

  public Boolean getIndMetasBloqueadas()
  {
    return indMetasBloqueadas;
  }

  public void setIndMetasBloqueadas(Boolean indMetasBloqueadas)
  {
    this.indMetasBloqueadas = indMetasBloqueadas;
  }

  public DTOListaMetasVentaProyectada getListaMetasVentaProyectada(){
    return this.listaMetasVentaProyectada;
  }
  
  public void setListaMetasVentaProyectada(DTOListaMetasVentaProyectada dto){
    this.listaMetasVentaProyectada = dto;
  }

   //private DTOListaMetasTipoVenta listaMetasTipoVenta;

  public DTOListaMetasTipoVenta getListaMetasTipoVenta(){
    return this.listaMetasTipoVenta;
  }
  
  public void setListaMetasTipoVenta(DTOListaMetasTipoVenta dto){
    this.listaMetasTipoVenta = dto;
  }
 
  public Long getOidAgrupacion(){
    return this.oidAgrupacion;
  }
  
  public void setOidAgrupacion(Long oidAgrupacion){
    this.oidAgrupacion = oidAgrupacion;
  }
  
    public BigDecimal getValorIncremento(){
        return this.valorIncremento;
    }

    public void setValorIncremento(BigDecimal valorIncremento){
        this.valorIncremento = valorIncremento;
    }
}