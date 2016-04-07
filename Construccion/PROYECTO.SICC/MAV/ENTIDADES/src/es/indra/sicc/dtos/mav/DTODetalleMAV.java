package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;

import java.util.Map;

public class DTODetalleMAV extends DTOSiccPaginacion  {
	private Long oid;
	private Long marca;
	private Long canal;
	private Double precioEstandar;
	private Double precio;
	private Double precioContable;
	private String observaciones;
	private Long baseEstimadosDestinatarios;
	private Double factorCorreccion;
	private BigDecimal unidadesEstimadas;
	private Long unidadesTotalesEstimadas;
	private String criterio;
	private Long indicadorEnvio;
	private Integer campagnaEvaluacion;
	private String numeroAniversario; // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
	private Integer unidadesPorCliente;
	private Integer unidadesTotales;
	private Boolean enviarMensaje;
	private Long actividad;
	private Long catalogo;
	private Long cicloVida;
	private Long curso;
	private Long mensaje;
	private Long codigoVenta;
	private Long criterioAsignacion;
	private Long estadoMAV;
	private Long formaCobro;
	private Long listaClientes;
	private Long marcaCondicion;
	private Long negocio;
	private Long formaPago;
	private Long periodo;
	private Long periodoFin;
	private Long periodoFinMonto;
	private Long periodoIniMonto;
	private Long estadoProceso;
	private Long tipoCliente;
	private Long tipoDespacho;
	private Long tipoOferta;
	private Long unidadNegocio;
	private Long clasificacion;
	private Long tipoClasificacion;
	private Long producto;
	private Double monto;
	private Long periodoCurso;
	private String procedencia;
	private Long[] subtiposCliente;
	private Long[] subaccesos;
	private Long[] subgerencias;
	private Long[] regiones;
	private Long[] zonas;
  private Long[] accesos;  // Creado por inc. 6686
	private Long subcriterio;
	private String textoMarca;
	private String textoCanal;
	private String textoPeriodo;
	private String textoActividad;
	private String textoTipoCliente;
  private Long edadDesde;  // Creado por inc. 6686.
  private Long edadHasta;  // Idem

	// by ssantana, 28/11/2004
  private String prodCodSAP;
  private String desProducto;  
  // by ssantana, 6/12/2004
  // inc. BELC300011056
  private String sCodigoVenta; 
    private boolean validado;

  //<inicio>SiCC-20070232, modificado por Sapaza
	private Long[] subgerenciasTodas;
	private Long[] regionesTodas;
  //<fin>SiCC-20070232

   // sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
   private Long[] tiposClasificacion;
   private Long[] clasificaciones;
   private Boolean indExclusionTipoClasificacion;
   
   // sapaza -- PER-SiCC-2010-0674 -- 25/11/2010
   private Long tipoClienteCriterio;
   private Long subTipoCliente;
   
    // sapaza -- PER-SiCC-2010-0699 -- 14/12/2010
   private Map unidadesRegionZona;
   
	public DTODetalleMAV() {
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Long getMarca() {
		return marca;
	}

	public void setMarca(Long newMarca) {
		marca = newMarca;
	}

	public Long getCanal() {
		return canal;
	}

	public void setCanal(Long newCanal) {
		canal = newCanal;
	}

	public Double getPrecioEstandar() {
		return precioEstandar;
	}

	public void setPrecioEstandar(Double newPrecioEstandar) {
		precioEstandar = newPrecioEstandar;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double newPrecio) {
		precio = newPrecio;
	}

	public Double getPrecioContable() {
		return precioContable;
	}

	public void setPrecioContable(Double newPrecioContable) {
		precioContable = newPrecioContable;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String newObservaciones) {
		observaciones = newObservaciones;
	}

	public Long getBaseEstimadosDestinatarios() {
		return baseEstimadosDestinatarios;
	}

	public void setBaseEstimadosDestinatarios(Long newBaseEstimadosDestinatarios) {
		baseEstimadosDestinatarios = newBaseEstimadosDestinatarios;
	}

	public Double getFactorCorreccion() {
		return factorCorreccion;
	}

	public void setFactorCorreccion(Double newFactorCorreccion) {
		factorCorreccion = newFactorCorreccion;
	}

	public BigDecimal getUnidadesEstimadas() {
		return unidadesEstimadas;
	}

	public void setUnidadesEstimadas(BigDecimal newUnidadesEstimadas) {
		unidadesEstimadas = newUnidadesEstimadas;
	}

	public Long getUnidadesTotalesEstimadas() {
		return unidadesTotalesEstimadas;
	}

	public void setUnidadesTotalesEstimadas(Long newUnidadesTotalesEstimadas) {
		unidadesTotalesEstimadas = newUnidadesTotalesEstimadas;
	}

	public String getCriterio() {
		return criterio;
	}

	public void setCriterio(String newCriterio) {
		criterio = newCriterio;
	}

	public Long getIndicadorEnvio() {
		return indicadorEnvio;
	}

	public void setIndicadorEnvio(Long newIndicadorEnvio) {
		indicadorEnvio = newIndicadorEnvio;
	}

	public Integer getCampagnaEvaluacion() {
		return campagnaEvaluacion;
	}

	public void setCampagnaEvaluacion(Integer newCampagnaEvaluacion) {
		campagnaEvaluacion = newCampagnaEvaluacion;
	}

	public String getNumeroAniversario() {
		return numeroAniversario;
	}

	public void setNumeroAniversario(String newNumeroAniversario) {
		numeroAniversario = newNumeroAniversario;
	}

	public Integer getUnidadesPorCliente() {
		return unidadesPorCliente;
	}

	public void setUnidadesPorCliente(Integer newUnidadesPorCliente) {
		unidadesPorCliente = newUnidadesPorCliente;
	}

	public Integer getUnidadesTotales() {
		return unidadesTotales;
	}

	public void setUnidadesTotales(Integer newUnidadesTotales) {
		unidadesTotales = newUnidadesTotales;
	}

	public Boolean getEnviarMensaje() {
		return enviarMensaje;
	}

	public void setEnviarMensaje(Boolean newEnviarMensaje) {
		enviarMensaje = newEnviarMensaje;
	}

	public Long getActividad() {
		return actividad;
	}

	public void setActividad(Long newActividad) {
		actividad = newActividad;
	}

	public Long getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Long newCatalogo) {
		catalogo = newCatalogo;
	}

	public Long getCicloVida() {
		return cicloVida;
	}

	public void setCicloVida(Long newCicloVida) {
		cicloVida = newCicloVida;
	}

	public Long getCurso() {
		return curso;
	}

	public void setCurso(Long newCurso) {
		curso = newCurso;
	}

	public Long getMensaje() {
		return mensaje;
	}

	public void setMensaje(Long newMensaje) {
		mensaje = newMensaje;
	}

	public Long getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(Long newCodigoVenta) {
		codigoVenta = newCodigoVenta;
	}

	public Long getCriterioAsignacion() {
		return criterioAsignacion;
	}

	public void setCriterioAsignacion(Long newCriterioAsignacion) {
		criterioAsignacion = newCriterioAsignacion;
	}

	public Long getEstadoMAV() {
		return estadoMAV;
	}

	public void setEstadoMAV(Long newEstadoMAV) {
		estadoMAV = newEstadoMAV;
	}

	public Long getFormaCobro() {
		return formaCobro;
	}

	public void setFormaCobro(Long newFormaCobro) {
		formaCobro = newFormaCobro;
	}

	public Long getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(Long newListaClientes) {
		listaClientes = newListaClientes;
	}

	public Long getMarcaCondicion() {
		return marcaCondicion;
	}

	public void setMarcaCondicion(Long newMarcaCondicion) {
		marcaCondicion = newMarcaCondicion;
	}

	public Long getNegocio() {
		return negocio;
	}

	public void setNegocio(Long newNegocio) {
		negocio = newNegocio;
	}

	public Long getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(Long newFormaPago) {
		formaPago = newFormaPago;
	}

	public Long getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Long newPeriodo) {
		periodo = newPeriodo;
	}

	public Long getPeriodoFin() {
		return periodoFin;
	}

	public void setPeriodoFin(Long newPeriodoFin) {
		periodoFin = newPeriodoFin;
	}

	public Long getPeriodoFinMonto() {
		return periodoFinMonto;
	}

	public void setPeriodoFinMonto(Long newPeriodoFinMonto) {
		periodoFinMonto = newPeriodoFinMonto;
	}

	public Long getPeriodoIniMonto() {
		return periodoIniMonto;
	}

	public void setPeriodoIniMonto(Long newPeriodoIniMonto) {
		periodoIniMonto = newPeriodoIniMonto;
	}

	public Long getEstadoProceso() {
		return estadoProceso;
	}

	public void setEstadoProceso(Long newEstadoProceso) {
		estadoProceso = newEstadoProceso;
	}

	public Long getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Long newTipoCliente) {
		tipoCliente = newTipoCliente;
	}

	public Long getTipoDespacho() {
		return tipoDespacho;
	}

	public void setTipoDespacho(Long newTipoDespacho) {
		tipoDespacho = newTipoDespacho;
	}

	public Long getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(Long newTipoOferta) {
		tipoOferta = newTipoOferta;
	}

	public Long getUnidadNegocio() {
		return unidadNegocio;
	}

	public void setUnidadNegocio(Long newUnidadNegocio) {
		unidadNegocio = newUnidadNegocio;
	}

	public Long getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Long newClasificacion) {
		clasificacion = newClasificacion;
	}

	public Long getTipoClasificacion() {
		return tipoClasificacion;
	}

	public void setTipoClasificacion(Long newTipoClasificacion) {
		tipoClasificacion = newTipoClasificacion;
	}

	public Long getProducto() {
		return producto;
	}

	public void setProducto(Long newProducto) {
		producto = newProducto;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double newMonto) {
		monto = newMonto;
	}

	public Long getPeriodoCurso() {
		return periodoCurso;
	}

	public void setPeriodoCurso(Long newPeriodoCurso) {
		periodoCurso = newPeriodoCurso;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(String newProcedencia) {
		procedencia = newProcedencia;
	}

	public Long[] getSubtiposCliente() {
		return subtiposCliente;
	}

	public void setSubtiposCliente(Long[] newSubtiposCliente) {
		subtiposCliente = newSubtiposCliente;
	}

	public Long[] getSubaccesos() {
		return subaccesos;
	}

	public void setSubaccesos(Long[] newSubaccesos) {
		subaccesos = newSubaccesos;
	}

	public Long[] getSubgerencias() {
		return subgerencias;
	}

	public void setSubgerencias(Long[] newSubgerencias) {
		subgerencias = newSubgerencias;
	}

	public Long[] getRegiones() {
		return regiones;
	}

	public void setRegiones(Long[] newRegiones) {
		regiones = newRegiones;
	}

	public Long[] getZonas() {
		return zonas;
	}

	public void setZonas(Long[] newZonas) {
		zonas = newZonas;
	}

	public Long[] getAccesos() {
		return this.accesos;
	}

	public void setAccesos(Long[] newAccesos) {
		this.accesos = newAccesos;
	}  

	public Long getSubcriterio() {
		return subcriterio;
	}

	public void setSubcriterio(Long newSubcriterio) {
		subcriterio = newSubcriterio;
	}

	public String getTextoMarca() {
		return textoMarca;
	}

	public void setTextoMarca(String newTextoMarca) {
		textoMarca = newTextoMarca;
	}

	public String getTextoCanal() {
		return textoCanal;
	}

	public void setTextoCanal(String newTextoCanal) {
		textoCanal = newTextoCanal;
	}

	public String getTextoPeriodo() {
		return textoPeriodo;
	}

	public void setTextoPeriodo(String newTextoPeriodo) {
		textoPeriodo = newTextoPeriodo;
	}

	public String getTextoActividad() {
		return textoActividad;
	}

	public void setTextoActividad(String newTextoActividad) {
		textoActividad = newTextoActividad;
	}

	public String getTextoTipoCliente() {
		return textoTipoCliente;
	}

	public void setTextoTipoCliente(String newTextoTipoCliente) {
		textoTipoCliente = newTextoTipoCliente;
	}

	public Long getEdadDesde() {
		return this.edadDesde;
	}

	public void setEdadDesde(Long edadDesde) {
    this.edadDesde = edadDesde;
	}  

	public Long getEdadHasta() {
		return this.edadHasta;
	}

	public void setEdadHasta(Long edadHasta) {
    this.edadHasta = edadHasta;
	}  

	public String getProdCodSAP() {
		return this.prodCodSAP;
	}

	public void setProdCodSAP(String prodCodSAP) {
    this.prodCodSAP = prodCodSAP;
	}    

  public void setSCodigoVenta(String sCodigoVenta) {
    this.sCodigoVenta = sCodigoVenta;
  }

  public String getSCodigoVenta() {
    return this.sCodigoVenta;
  }

    public boolean getValidado()
    {
        return validado;
    }

    public void setValidado(boolean validado)
    {
        this.validado = validado;
    }


  public void setSubgerenciasTodas(Long[] subgerenciasTodas)
  {
    this.subgerenciasTodas = subgerenciasTodas;
  }


  public Long[] getSubgerenciasTodas()
  {
    return subgerenciasTodas;
  }


  public void setRegionesTodas(Long[] regionesTodas)
  {
    this.regionesTodas = regionesTodas;
  }


  public Long[] getRegionesTodas()
  {
    return regionesTodas;
  }
  
  public void setDesProducto(String desProducto) {
      this.desProducto = desProducto;
  }

  public String getDesProducto() {
      return this.desProducto;
  }

    public void setTiposClasificacion(Long[] tiposClasificacion) {
        this.tiposClasificacion = tiposClasificacion;
    }

    public Long[] getTiposClasificacion() {
        return tiposClasificacion;
    }

    public void setClasificaciones(Long[] clasificaciones) {
        this.clasificaciones = clasificaciones;
    }

    public Long[] getClasificaciones() {
        return clasificaciones;
    }

    public void setIndExclusionTipoClasificacion(Boolean indExclusionTipoClasificacion) {
        this.indExclusionTipoClasificacion = indExclusionTipoClasificacion;
    }

    public Boolean getIndExclusionTipoClasificacion() {
        return indExclusionTipoClasificacion;
    }

    public void setSubTipoCliente(Long subTipoCliente) {
        this.subTipoCliente = subTipoCliente;
    }

    public Long getSubTipoCliente() {
        return subTipoCliente;
    }

    public void setTipoClienteCriterio(Long tipoClienteCriterio) {
        this.tipoClienteCriterio = tipoClienteCriterio;
    }

    public Long getTipoClienteCriterio() {
        return tipoClienteCriterio;
    }

    public void setUnidadesRegionZona(Map unidadesRegionZona) {
        this.unidadesRegionZona = unidadesRegionZona;
    }

    public Map getUnidadesRegionZona() {
        return unidadesRegionZona;
    }
}
