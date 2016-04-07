package es.indra.sicc.dtos.ped;
import java.util.Date;
import java.util.ArrayList;
import java.sql.Timestamp;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOCabeceraSolicitud extends DTOAuditableSICC  {


        private Timestamp fechaPrevistaFacturacion;
        private Integer numeroClientes;
        private Long tipoSolicitud;
        private Long moneda;
        private Long tipoDespacho;
        private Long almacen;
        private Long modulo;
        private Long tipoCliente;
        private Long periodo;
        private String cliente;
        private Long oidCliente;
        private String receptorFactura;
        private Long oidReceptorFactura;
        private String pagadorFactura;
        private Long oidPagadorFactura;
        private Long destino;
        private Long tipoDocumento;
        private Long sociedad;
        private Long subacceso;
        private Long territorio;
        private Long zona;
        private String numeroSolicitud; 
        private String usuario;
        private Date fecha;
        private Boolean permiteUnionSolicitudes;
        private Boolean indPedidoPrueba;
        private Boolean indTSNoConsolidado;
        private String observaciones;
        private Long tipoDocumentoLegal;
        private Long ubigeo;
        private Long estado;
        private Long subtipoCliente;
        private Long accesoFisico;
        private Long formaPago;
        private Long claseSolicitud;
        private Long operacion;
        private Long proceso;
        private Boolean ordenCompra;
        private Long tipoConsolidado;
        private Long marca;
        private Long canal;
        private Long acceso;
        private Long subgerencia;
        private Long region;
        private Long seccion;
        private Boolean OK;
        private String mensajeError;
        private Boolean indMasSolicitudes;
        private Boolean indicadorDigitacion;
        private Long destinatario;
        private Long oidConcursoParametros;
        private Long oidDocumentoReferencia;
        private Integer numeroPremio;
        private Long consultoraAsociada;
        private Long oidCabeceraSolicitud;
        private Long numeroDocumentoOrigen;
        private ArrayList posiciones;
        private Double tipoCambio;
        private Long grupoProcesos;
        private Long oidTerritorioAdministrativo;
        private String codigoConsultoraAsociada;
        private Boolean verificacion;
        private String codPeriodoCorpo;
        //pperez 17/08/2005 incidencia 16500
        private String iP;
        private Boolean indicadorModulosExternos;
        private Long oidTipoSolicitudPais;
        private Long oidTipoSolicitud;
        private Boolean indSolNegativa;
        private Long alarmaNumUnidades;        
        private String pais;
        private String indInterfaz;
        private Boolean indOnLineOCR;
        private Boolean indCompletar;
        private Boolean indMonetariasOCR;
        private Long oidTipoProgramaIncentivos;
        private String codigoSubacceso;
        private Long oidTipoClasificacion;
        private Long oidClasificacion;  
        private Boolean modificarPosiciones;

    public DTOCabeceraSolicitud() {
    }

    public Boolean getOK() {
        return OK;
    }

    public void setOK(Boolean newOK) {
        OK = newOK;
    }

    public Long getAcceso() {
        return acceso;
    }

    public void setAcceso(Long newAcceso) {
        acceso = newAcceso;
    }

    public Long getAccesoFisico() {
        return accesoFisico;
    }

    public void setAccesoFisico(Long newAccesoFisico) {
        accesoFisico = newAccesoFisico;
    }

    public Long getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Long newAlmacen) {
        almacen = newAlmacen;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public Long getClaseSolicitud() {
        return claseSolicitud;
    }

    public void setClaseSolicitud(Long newClaseSolicitud) {
        claseSolicitud = newClaseSolicitud;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String newCliente) {
        cliente = newCliente;
    }

    public Long getConsultoraAsociada() {
        return consultoraAsociada;
    }

    public void setConsultoraAsociada(Long newConsultoraAsociada) {
        consultoraAsociada = newConsultoraAsociada;
    }

    public Long getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Long newDestinatario) {
        destinatario = newDestinatario;
    }

    public Long getDestino() {
        return destino;
    }

    public void setDestino(Long newDestino) {
        destino = newDestino;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long newEstado) {
        estado = newEstado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date newFecha) {
        fecha = newFecha;
    }

    public Timestamp getFechaPrevistaFacturacion() {
        return fechaPrevistaFacturacion;
    }

    public void setFechaPrevistaFacturacion(Timestamp newFechaPrevistaFacturacion) {
        fechaPrevistaFacturacion = newFechaPrevistaFacturacion;
    }

    public Long getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(Long newFormaPago) {
        formaPago = newFormaPago;
    }

    public Boolean getIndMasSolicitudes() {
        return indMasSolicitudes;
    }

    public void setIndMasSolicitudes(Boolean newIndMasSolicitudes) {
        indMasSolicitudes = newIndMasSolicitudes;
    }

    public Boolean getIndPedidoPrueba() {
        return indPedidoPrueba;
    }

    public void setIndPedidoPrueba(Boolean newIndPedidoPrueba) {
        indPedidoPrueba = newIndPedidoPrueba;
    }

    public Boolean getIndTSNoConsolidado() {
        return indTSNoConsolidado;
    }

    public void setIndTSNoConsolidado(Boolean newIndTSNoConsolidado) {
        indTSNoConsolidado = newIndTSNoConsolidado;
    }

    public Boolean getIndicadorDigitacion() {
        return indicadorDigitacion;
    }

    public void setIndicadorDigitacion(Boolean newIndicadorDigitacion) {
        indicadorDigitacion = newIndicadorDigitacion;
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String newMensajeError) {
        mensajeError = newMensajeError;
    }

    public Long getModulo() {
        return modulo;
    }

    public void setModulo(Long newModulo) {
        modulo = newModulo;
    }

    public Long getMoneda() {
        return moneda;
    }

    public void setMoneda(Long newMoneda) {
        moneda = newMoneda;
    }

    public Integer getNumeroClientes() {
        return numeroClientes;
    }

    public void setNumeroClientes(Integer newNumeroClientes) {
        numeroClientes = newNumeroClientes;
    }

    public Long getNumeroDocumentoOrigen() {
        return numeroDocumentoOrigen;
    }

    public void setNumeroDocumentoOrigen(Long newNumeroDocumentoOrigen) {
        numeroDocumentoOrigen = newNumeroDocumentoOrigen;
    }

    public Integer getNumeroPremio() {
        return numeroPremio;
    }

    public void setNumeroPremio(Integer newNumeroPremio) {
        numeroPremio = newNumeroPremio;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String newNumeroSolicitud) {
        numeroSolicitud = newNumeroSolicitud;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String newObservaciones) {
        observaciones = newObservaciones;
    }

    public Long getOidCabeceraSolicitud() {
        return oidCabeceraSolicitud;
    }

    public void setOidCabeceraSolicitud(Long newOidCabeceraSolicitud) {
        oidCabeceraSolicitud = newOidCabeceraSolicitud;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente) {
        oidCliente = newOidCliente;
    }

    public Long getOidConcursoParametros() {
        return oidConcursoParametros;
    }

    public void setOidConcursoParametros(Long newOidConcursoParametros) {
        oidConcursoParametros = newOidConcursoParametros;
    }

    public Long getOidDocumentoReferencia() {
        return oidDocumentoReferencia;
    }

    public void setOidDocumentoReferencia(Long newOidDocumentoReferencia) {
        oidDocumentoReferencia = newOidDocumentoReferencia;
    }

    public Long getOidPagadorFactura() {
        return oidPagadorFactura;
    }

    public void setOidPagadorFactura(Long newOidPagadorFactura) {
        oidPagadorFactura = newOidPagadorFactura;
    }

    public Long getOidReceptorFactura() {
        return oidReceptorFactura;
    }

    public void setOidReceptorFactura(Long newOidReceptorFactura) {
        oidReceptorFactura = newOidReceptorFactura;
    }

    public Long getOperacion() {
        return operacion;
    }

    public void setOperacion(Long newOperacion) {
        operacion = newOperacion;
    }

    public Boolean getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(Boolean newOrdenCompra) {
        ordenCompra = newOrdenCompra;
    }

    public String getPagadorFactura() {
        return pagadorFactura;
    }

    public void setPagadorFactura(String newPagadorFactura) {
        pagadorFactura = newPagadorFactura;
    }

    public Long getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Long newPeriodo) {
        periodo = newPeriodo;
    }

    public Boolean getPermiteUnionSolicitudes() {
        return permiteUnionSolicitudes;
    }

    public void setPermiteUnionSolicitudes(Boolean newPermiteUnionSolicitudes) {
        permiteUnionSolicitudes = newPermiteUnionSolicitudes;
    }

    public ArrayList getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList newPosiciones) {
        posiciones = newPosiciones;
    }

    public Long getProceso() {
        return proceso;
    }

    public void setProceso(Long newProceso) {
        proceso = newProceso;
    }

    public String getReceptorFactura() {
        return receptorFactura;
    }

    public void setReceptorFactura(String newReceptorFactura) {
        receptorFactura = newReceptorFactura;
    }

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long newRegion) {
        region = newRegion;
    }

    public Long getSeccion() {
        return seccion;
    }

    public void setSeccion(Long newSeccion) {
        seccion = newSeccion;
    }

    public Long getSociedad() {
        return sociedad;
    }

    public void setSociedad(Long newSociedad) {
        sociedad = newSociedad;
    }

    public Long getSubacceso() {
        return subacceso;
    }

    public void setSubacceso(Long newSubacceso) {
        subacceso = newSubacceso;
    }

    public Long getSubgerencia() {
        return subgerencia;
    }

    public void setSubgerencia(Long newSubgerencia) {
        subgerencia = newSubgerencia;
    }

    public Long getSubtipoCliente() {
        return subtipoCliente;
    }

    public void setSubtipoCliente(Long newSubtipoCliente) {
        subtipoCliente = newSubtipoCliente;
    }

    public Long getTerritorio() {
        return territorio;
    }

    public void setTerritorio(Long newTerritorio) {
        territorio = newTerritorio;
    }

    public Long getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Long newTipoCliente) {
        tipoCliente = newTipoCliente;
    }

    public Long getTipoConsolidado() {
        return tipoConsolidado;
    }

    public void setTipoConsolidado(Long newTipoConsolidado) {
        tipoConsolidado = newTipoConsolidado;
    }

    public Long getTipoDespacho() {
        return tipoDespacho;
    }

    public void setTipoDespacho(Long newTipoDespacho) {
        tipoDespacho = newTipoDespacho;
    }

    public Long getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Long newTipoDocumento) {
        tipoDocumento = newTipoDocumento;
    }

    public Long getTipoDocumentoLegal() {
        return tipoDocumentoLegal;
    }

    public void setTipoDocumentoLegal(Long newTipoDocumentoLegal) {
        tipoDocumentoLegal = newTipoDocumentoLegal;
    }

    public Long getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(Long newTipoSolicitud) {
        tipoSolicitud = newTipoSolicitud;
    }

    public Long getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Long newUbigeo) {
        ubigeo = newUbigeo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String newUsuario) {
        usuario = newUsuario;
    }

    public Long getZona() {
        return zona;
    }

    public void setZona(Long newZona) {
        zona = newZona;
    }

	public Double getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(Double newTipoCambio) {
		tipoCambio = newTipoCambio;
	}

	public Long getGrupoProcesos() {
		return grupoProcesos;
	}

	public void setGrupoProcesos(Long newGrupoProcesos) {
		grupoProcesos = newGrupoProcesos;
	}

  public Long getOidTerritorioAdministrativo()
  {
    return oidTerritorioAdministrativo;
  }

  public void setOidTerritorioAdministrativo(Long oidTerritorioAdministrativo)
  {
    this.oidTerritorioAdministrativo = oidTerritorioAdministrativo;
  }

  public String getCodigoConsultoraAsociada() {
    return codigoConsultoraAsociada;
  }

  public void setCodigoConsultoraAsociada(String codigoConsultoraAsociada) {
    this.codigoConsultoraAsociada = codigoConsultoraAsociada;
  }

  public Boolean getVerificacion() {
    return verificacion;
  }

  public void setVerificacion(Boolean verificacion) {
    this.verificacion = verificacion;
  }


    public void setIP(String iP) {
        this.iP = iP;
    }


    public String getIP() {
        return iP;
    }
    
  public String getCodPeriodoCorpo() {
    return codPeriodoCorpo;
  }

  public void setCodPeriodoCorpo(String codPeriodoCorpo) {
    this.codPeriodoCorpo = codPeriodoCorpo;
  }
  
  public void addPosicion (DTOPosicionSolicitud dto){
      if (this.posiciones == null){
          this.posiciones = new ArrayList();
      }
      this.posiciones.add(dto);
  }
  
    public Boolean getIndicadorModulosExternos() {
        return indicadorModulosExternos;
    }

    public void setIndicadorModulosExternos(Boolean newIndicadorModulosExternos) {
        indicadorModulosExternos = newIndicadorModulosExternos;
    }
    
    public Long getOidTipoSolicitud() {
        return oidTipoSolicitud;
    }

    public void setOidTipoSolicitud(Long newOidTipoSolicitud) {
        oidTipoSolicitud = newOidTipoSolicitud;       
    }

    public Long getOidTipoSolicitudPais() {
        return oidTipoSolicitudPais;
    }

    public void setOidTipoSolicitudPais(Long newOidTipoSolicitudPais) {
        oidTipoSolicitudPais = newOidTipoSolicitudPais;       
    }
    
    public Long getAlarmaNumUnidades() {
        return alarmaNumUnidades;
    }

    public void setAlarmaNumUnidades (Long newAlarmaNumUnidades) {
        alarmaNumUnidades = newAlarmaNumUnidades;       
    }
    
    public Boolean getIndSolNegativa() {
        return indSolNegativa;
    }

    public void setIndSolNegativa(Boolean newIndSolNegativa) {
        indSolNegativa = newIndSolNegativa;
    }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

    public String getIndInterfaz() {
        return indInterfaz;
    }

    public void setIndInterfaz(String indInterfaz) {
        this.indInterfaz = indInterfaz;
    }

  public Boolean getIndOnLineOCR()
  {
    return indOnLineOCR;
  }

  public void setIndOnLineOCR(Boolean indOnLineOCR)
  {
    this.indOnLineOCR = indOnLineOCR;
  }

    public Boolean getIndCompletar()
    {
        return indCompletar;
    }

    public void setIndCompletar(Boolean indCompletar)
    {
        this.indCompletar = indCompletar;
    }

  public Boolean getIndMonetariasOCR()
  {
    return indMonetariasOCR;
  }

  public void setIndMonetariasOCR(Boolean indMonetariasOCR)
  {
    this.indMonetariasOCR = indMonetariasOCR;
  }

    public Long getOidTipoProgramaIncentivos() {
        return oidTipoProgramaIncentivos;
    }

    public void setOidTipoProgramaIncentivos(Long oidTipoProgramaIncentivos) {
        this.oidTipoProgramaIncentivos = oidTipoProgramaIncentivos;
    }

    public String getCodigoSubacceso() {
        return codigoSubacceso;
    }

    public void setCodigoSubacceso(String codigoSubacceso) {
        this.codigoSubacceso = codigoSubacceso;
    }

    public void setOidTipoClasificacion(Long oidTipoClasificacion) {
        this.oidTipoClasificacion = oidTipoClasificacion;
    }

    public Long getOidTipoClasificacion() {
        return oidTipoClasificacion;
    }

    public void setOidClasificacion(Long oidClasificacion) {
        this.oidClasificacion = oidClasificacion;
    }

    public Long getOidClasificacion() {
        return oidClasificacion;
    }
    public Boolean getModificarPosiciones()
     {
       return modificarPosiciones;
     }

     public void setModificarPosiciones(Boolean modificarPosiciones)
     {
       
       this.modificarPosiciones = modificarPosiciones;
     }
}
