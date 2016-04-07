/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.dtos.intsys;


import es.indra.sicc.util.DTOBelcorp;

import java.util.Date;
import java.math.BigDecimal;

public class DTOINTDocumentoContable extends DTOBelcorp {

    private String codigoPais;
    private Date fecha;
    private Long empresa;   
    private String codigoEmpresa;
    private String codigoCanal;
    private Long subacceso;
    private Long periodo;
    private String codigoPeriodo;   
    private String RUC;   
    private Long producto;
    private Long marcaProducto;
    private String codigoGrupoProductos;
    private Long negocio;
    private Long tipoOferta;
    private Long cicloVida;
    //modificado el tipo de String a Long por inc 21788
    private Long codigoApunte;
    private BigDecimal importe01;
    private BigDecimal importe03;
    // vbongiov -- Cambio 20090922 -- 28/05/2009
    private BigDecimal importe04;
    private BigDecimal importe05;
    private BigDecimal importe07;
    private String tipoAsiento;
    private String tipoMovimientoSAPFI;
    private String indicadorDebeHaber;
    private Long importeAContabilizar;
    private BigDecimal importe;
    private BigDecimal importe50;
    private BigDecimal importe55;
    private BigDecimal importe60;
    private BigDecimal importe70;
    private BigDecimal importe80;
    private BigDecimal importe84;
    private BigDecimal importe88;   
    //cambio SAPFI-001  (SCS-07/05/08)
    private BigDecimal importe90;   
    private String codigoAcceso;
    private String codigoSubacceso;
    private String codigoTipoPeriodo;
    private String codigoProducto;
    private String codigoMarcaProducto;
    private String codigoNegocio;
    private String codigoTipoOferta;
    private String codigoCicloVida;
    private String codigoImporteAContabilizar;
    private String ejercicioComercial; // añadido por incidencia 18180
    private Long cuentaContable; // incidencia 18477
    
    //--Paola Cabrera
    //--Agregado por incidencia 21244        
    private String descripcionCanal;
    private Long oidCabecera;
    private String codigoCliente;

    //--Fin agregado--------


    // se crea este constructor porque se necesita para realizar los cambios
    // indicados en incidencia BELC300013756
    // se utiliza en MONINTSAPFI.obtenerParametroContable
    public DTOINTDocumentoContable(DTOINTDocumentoContable dto) {
         setCodigoPais(dto.getCodigoPais());
         setFecha(dto.getFecha());
         setEmpresa(dto.getEmpresa());
         setCodigoEmpresa(dto.getCodigoEmpresa());
         setCodigoCanal(dto.getCodigoCanal());
         setSubacceso(dto.getSubacceso());
         setPeriodo(dto.getPeriodo());
         setCodigoPeriodo(dto.getCodigoPeriodo());
         setRUC(dto.getRUC());
         setProducto(dto.getProducto());
         setMarcaProducto(dto.getMarcaProducto());
         setCodigoGrupoProductos(dto.getCodigoGrupoProductos());
         setNegocio(dto.getNegocio());
         setTipoOferta(dto.getTipoOferta());
         setCicloVida(dto.getCicloVida());
         setCodigoApunte(dto.getCodigoApunte());
         setImporte01(dto.getImporte01());
         setImporte03(dto.getImporte03());
        // vbongiov -- Cambio 20090922 -- 28/05/2009
         setImporte04(dto.getImporte04());
         setImporte05(dto.getImporte05());
         setImporte07(dto.getImporte07());
         setTipoAsiento(dto.getTipoAsiento());
         setTipoMovimientoSAPFI(dto.getTipoMovimientoSAPFI());
         setIndicadorDebeHaber(dto.getIndicadorDebeHaber());
         setImporteAContabilizar(dto.getImporteAContabilizar());
         setImporte(dto.getImporte());
         setImporte50(dto.getImporte50());
         setImporte55(dto.getImporte55());
         setImporte60(dto.getImporte60());
         setImporte70(dto.getImporte70());
         setImporte80(dto.getImporte80());
         setImporte84(dto.getImporte84());
         setImporte88(dto.getImporte88());
         setImporte90(dto.getImporte90());
         setCodigoAcceso(dto.getCodigoAcceso());
         setCodigoSubacceso(dto.getCodigoSubacceso());
         setCodigoTipoPeriodo(dto.getCodigoTipoPeriodo());
         setCodigoProducto(dto.getCodigoProducto());
         setCodigoMarcaProducto(dto.getCodigoMarcaProducto());
         setCodigoNegocio(dto.getCodigoNegocio());
         setCodigoTipoOferta(dto.getCodigoTipoOferta());
         setCodigoCicloVida(dto.getCodigoCicloVida());
         setCodigoImporteAContabilizar(dto.getCodigoImporteAContabilizar());
         setEjercicioComercial(dto.getEjercicioComercial());
         setCuentaContable(dto.getCuentaContable());
         this.setDescripcionCanal(dto.getDescripcionCanal());
         this.setOidCabecera(dto.getOidCabecera());
         this.setCodigoCliente(dto.getCodigoCliente());
    }

    public DTOINTDocumentoContable()
    {
    }

    public String getRUC()
    {
        return RUC;
    }

    public void setRUC(String RUC)
    {
        this.RUC = RUC;
    }

    public Long getCicloVida()
    {
        return cicloVida;
    }

    public void setCicloVida(Long cicloVida)
    {
        this.cicloVida = cicloVida;
    }

    public String getCodigoAcceso()
    {
        return codigoAcceso;
    }

    public void setCodigoAcceso(String codigoAcceso)
    {
        this.codigoAcceso = codigoAcceso;
    }
    
    //modificado el tipo de String a Long por inc 21788
    public Long getCodigoApunte()
    {
        return codigoApunte;
    }
    
    //modificado el tipo de String a Long por inc 21788
    public void setCodigoApunte(Long codigoApunte)
    {
        this.codigoApunte = codigoApunte;
    }

    public String getCodigoCanal()
    {
        return codigoCanal;
    }

    public void setCodigoCanal(String codigoCanal)
    {
        this.codigoCanal = codigoCanal;
    }

    public String getCodigoCicloVida()
    {
        return codigoCicloVida;
    }

    public void setCodigoCicloVida(String codigoCicloVida)
    {
        this.codigoCicloVida = codigoCicloVida;
    }

    public String getCodigoEmpresa()
    {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa)
    {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getCodigoGrupoProductos()
    {
        return codigoGrupoProductos;
    }

    public void setCodigoGrupoProductos(String codigoGrupoProductos)
    {
        this.codigoGrupoProductos = codigoGrupoProductos;
    }

    public String getCodigoImporteAContabilizar()
    {
        return codigoImporteAContabilizar;
    }

    public void setCodigoImporteAContabilizar(String codigoImporteAContabilizar)
    {
        this.codigoImporteAContabilizar = codigoImporteAContabilizar;
    }

    public String getCodigoMarcaProducto()
    {
        return codigoMarcaProducto;
    }

    public void setCodigoMarcaProducto(String codigoMarcaProducto)
    {
        this.codigoMarcaProducto = codigoMarcaProducto;
    }

    public String getCodigoNegocio()
    {
        return codigoNegocio;
    }

    public void setCodigoNegocio(String codigoNegocio)
    {
        this.codigoNegocio = codigoNegocio;
    }

    public String getCodigoPais()
    {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais)
    {
        this.codigoPais = codigoPais;
    }

    public String getCodigoPeriodo()
    {
        return codigoPeriodo;
    }

    public void setCodigoPeriodo(String codigoPeriodo)
    {
        this.codigoPeriodo = codigoPeriodo;
    }

    public String getCodigoProducto()
    {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto)
    {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoSubacceso()
    {
        return codigoSubacceso;
    }

    public void setCodigoSubacceso(String codigoSubacceso)
    {
        this.codigoSubacceso = codigoSubacceso;
    }

    public String getCodigoTipoOferta()
    {
        return codigoTipoOferta;
    }

    public void setCodigoTipoOferta(String codigoTipoOferta)
    {
        this.codigoTipoOferta = codigoTipoOferta;
    }

    public String getCodigoTipoPeriodo()
    {
        return codigoTipoPeriodo;
    }

    public void setCodigoTipoPeriodo(String codigoTipoPeriodo)
    {
        this.codigoTipoPeriodo = codigoTipoPeriodo;
    }

    public Long getEmpresa()
    {
        return empresa;
    }

    public void setEmpresa(Long empresa)
    {
        this.empresa = empresa;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public BigDecimal getImporte()
    {
        return importe;
    }

    public void setImporte(BigDecimal importe)
    {
        this.importe = importe;
    }

    public BigDecimal getImporte01()
    {
        return importe01;
    }

    public void setImporte01(BigDecimal importe01)
    {
        this.importe01 = importe01;
    }

    public BigDecimal getImporte03()
    {
        return importe03;
    }

    public void setImporte03(BigDecimal importe03)
    {
        this.importe03 = importe03;
    }
    
    public BigDecimal getImporte04()
    {
        return importe04;
    }

    public void setImporte04(BigDecimal importe04)
    {
        this.importe04 = importe04;
    }

    public BigDecimal getImporte50()
    {
        return importe50;
    }

    public void setImporte50(BigDecimal importe50)
    {
        this.importe50 = importe50;
    }

    public BigDecimal getImporte55()
    {
        return importe55;
    }

    public void setImporte55(BigDecimal importe55)
    {
        this.importe55 = importe55;
    }

    public BigDecimal getImporte60()
    {
        return importe60;
    }

    public void setImporte60(BigDecimal importe60)
    {
        this.importe60 = importe60;
    }

    public BigDecimal getImporte70()
    {
        return importe70;
    }

    public void setImporte70(BigDecimal importe70)
    {
        this.importe70 = importe70;
    }

    public BigDecimal getImporte80()
    {
        return importe80;
    }

    public void setImporte80(BigDecimal importe80)
    {
        this.importe80 = importe80;
    }

    public BigDecimal getImporte84()
    {
        return importe84;
    }

    public void setImporte84(BigDecimal importe84)
    {
        this.importe84 = importe84;
    }

    public BigDecimal getImporte88()
    {
        return importe88;
    }

    public void setImporte88(BigDecimal importe88)
    {
        this.importe88 = importe88;
    }

    public Long getImporteAContabilizar()
    {
        return importeAContabilizar;
    }

    public void setImporteAContabilizar(Long importeAContabilizar)
    {
        this.importeAContabilizar = importeAContabilizar;
    }

    public String getIndicadorDebeHaber()
    {
        return indicadorDebeHaber;
    }

    public void setIndicadorDebeHaber(String indicadorDebeHaber)
    {
        this.indicadorDebeHaber = indicadorDebeHaber;
    }

    public Long getMarcaProducto()
    {
        return marcaProducto;
    }

    public void setMarcaProducto(Long marcaProducto)
    {
        this.marcaProducto = marcaProducto;
    }

    public Long getNegocio()
    {
        return negocio;
    }

    public void setNegocio(Long negocio)
    {
        this.negocio = negocio;
    }

    public Long getPeriodo()
    {
        return periodo;
    }

    public void setPeriodo(Long periodo)
    {
        this.periodo = periodo;
    }

    public Long getProducto()
    {
        return producto;
    }

    public void setProducto(Long producto)
    {
        this.producto = producto;
    }

    public Long getSubacceso()
    {
        return subacceso;
    }

    public void setSubacceso(Long subacceso)
    {
        this.subacceso = subacceso;
    }

    public String getTipoAsiento()
    {
        return tipoAsiento;
    }

    public void setTipoAsiento(String tipoAsiento)
    {
        this.tipoAsiento = tipoAsiento;
    }

    public String getTipoMovimientoSAPFI()
    {
        return tipoMovimientoSAPFI;
    }

    public void setTipoMovimientoSAPFI(String tipoMovimientoSAPFI)
    {
        this.tipoMovimientoSAPFI = tipoMovimientoSAPFI;
    }

    public Long getTipoOferta()
    {
        return tipoOferta;
    }

    public void setTipoOferta(Long tipoOferta)
    {
        this.tipoOferta = tipoOferta;
    }

   public String getEjercicioComercial() {
      return ejercicioComercial;
   }

   public void setEjercicioComercial(String ejercicioComercial) {
      this.ejercicioComercial = ejercicioComercial;
   }

    public Long getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(Long cuentaContable) {
        this.cuentaContable = cuentaContable;
    }

    public String getDescripcionCanal()
    {
        return descripcionCanal;
    }

    public void setDescripcionCanal(String descripcionCanal)
    {
        this.descripcionCanal = descripcionCanal;
    }

    public Long getOidCabecera()
    {
        return oidCabecera;
    }

    public void setOidCabecera(Long oidCabecera)
    {
        this.oidCabecera = oidCabecera;
    }

    public String getCodigoCliente()
    {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente)
    {
        this.codigoCliente = codigoCliente;
    }

    public BigDecimal getImporte05() {
        return importe05;
    }

    public void setImporte05(BigDecimal importe05) {
        this.importe05 = importe05;
    }

    public BigDecimal getImporte07() {
        return importe07;
    }

    public void setImporte07(BigDecimal importe07) {
        this.importe07 = importe07;
    }
    
    
    public void setImporte90(BigDecimal importe90)
    {
        this.importe90 = importe90;
    }


    public BigDecimal getImporte90()
    {
        return importe90;
    }
}