/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.bel.applet;

import es.indra.mare.common.dto.MareDTO;

import es.indra.sicc.bel.applet.componentes.CobrosDevolucionesDetalleCabeceraController;
import es.indra.sicc.bel.applet.componentes.CobrosDevolucionesDetalleController;
import es.indra.sicc.bel.applet.componentes.TablaDetalle;
import es.indra.sicc.comunapplet.Communicator;
import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.comunapplet.Dialogos;
import es.indra.sicc.comunapplet.UtilApplet;
import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.dtos.bel.DTOCobroBelcenter;
import es.indra.sicc.dtos.bel.DTOComprobarInicioCobro;
import es.indra.sicc.dtos.bel.DTODatosCobroDevolucion;
import es.indra.sicc.dtos.bel.DTOMovimientoCaja;
import es.indra.sicc.dtos.ped.applet.DTOCargaRegistroOnline;
import es.indra.sicc.ped.applet.RegistroCache;

import netscape.javascript.JSObject;

import java.math.BigDecimal;

import java.net.URL;

import java.sql.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;


/**
 * @autor Cortaberría
 */

/*
 * rgiorgi - 23/08/2005: se formatea la clase
 * */
public class GestorCobrosDevolucionesApplet extends GestorCobrosDevoluciones {
    private DTOComprobarInicioCobro dtoComprobarInicioCobro = null;

    protected void btnGuardar_click() throws AppletException {
        //System.out.println("accion en guardar: " + this.accion);
        if ("Devolucion".equals(this.accion)) {
            try {
                this.validarImporteTotal();

                // Graba el cobro 
                this.grabarCobro();
            } catch (AppletException e) {
                UtilApplet.procesarError(e, this);
            }
        } else { // accion == "Cobro" 

            // Graba el cobro 
            this.grabarCobro();
        }
    }

    /**
     * rgiorgi - 23/8/2005: inc. BEL-03, se cambia la comparación
     * Comprueba que la suma de los importes sea diferente a 0
     * @throws es.indra.sicc.ped.applet.exceptions.AppletException
     */
    protected void validarImporteTotal() throws AppletException {
        this.totalPagado = calcularTotal();
        //if(this.totalPagado == null || !this.totalPagado.equals(new BigDecimal(0)) ) {
        if ((this.totalPagado == null) || !(this.totalPagado.compareTo(new BigDecimal(0)) == 0)) {
            throw new AppletException(ConstantesApplet.BEL_0017);

            //TODO Genera una excepción con código de error: BEL-0017 
        }
    }
    
    private BigDecimal calcularTotal(){
      BigDecimal totalPagar = new BigDecimal(0);
      for(int i = 0 ; i < this.tablaDetalle.getRowCount() ; i++){
          if (this.tablaDetalle.getValueAt(i, 2) !=null){
              totalPagar = totalPagar.add(new BigDecimal(this.tablaDetalle.getValueAt(i, 2).toString()));
          }
      }
      return totalPagar;      
  }

    protected void grabarCobro() throws AppletException {
        if ((this.tablaDetalle.getRowCount() > 0) && !"".equals(this.tablaDetalle.colMedioPago.getText(0).trim())) {
            DTOCobroBelcenter dtoCobro = new DTOCobroBelcenter();
            dtoCobro.setMovimientoCaja(this.crearDTOMovimientoCaja());
            dtoCobro.setMovimientoCajaDetalle(this.movimientosCaja);
            dtoCobro.setOidCanal(this.cache.getOidCanal());
            dtoCobro.setOidAcceso(this.cache.getOidAcceso());
            dtoCobro.setOidSubacceso(this.cache.getOidSubAcceso());
            dtoCobro.setTotalImporte(this.totalPagado);
            dtoCobro.setOidPais(this.oidPais);

            //dtoCobro.setMovimientoCaja();
            if ("Cobro".equals(this.accion)) {
                dtoCobro.setEnviarMensaje(Boolean.TRUE);
                dtoCobro.setContinuaFacturacion(Boolean.FALSE);
            } else if ("Devolucion".equals(this.accion)) {
                dtoCobro.setEnviarMensaje(Boolean.FALSE);

                if ((dtoCobro.getMovimientoCaja() != null) && (dtoCobro.getMovimientoCaja().getOidSolicitudCabecera() != null)) {
                    dtoCobro.setContinuaFacturacion(Boolean.TRUE);
                } else {
                    dtoCobro.setContinuaFacturacion(Boolean.FALSE);
                }
            }

            // Obtiene la información del stock del producto 
            this.ejecutarNegocio("BELGrabarCobroBelcenter", "es.indra.sicc.dtos.bel.DTOCobroBelcenter", dtoCobro);

            // Reinicia para la introducción de nuevas operaciones 
            this.reiniciar();
        } else {
            Dialogos.mensajeError(ConstantesApplet.FALTA_ANADIR_CLIENTES, this);
        }
    }

    protected void ejecutarJava() throws AppletException {
        //
    }

    protected DTOMovimientoCaja crearDTOMovimientoCaja() throws AppletException {
        DTOMovimientoCaja dto = new DTOMovimientoCaja();
        dto.setOidPais(this.oidPais);
        dto.setOidCaja(this.oidCaja);
        dto.setUsuario(this.usuario);
        dto.setFecha(this.fechaSistemaDate);
        dto.setOidCliente(this.marcoCobrosDevolucionesDetalleCabecera.getOidCliente());
        dto.setObservaciones(this.txtObservaciones.getText());

        return dto;
    }

    public Object ejecutarWeb(String nombreFuncionJS, String url) { // throws AppletException {

        JSObject win = JSObject.getWindow(this);
        Object obj = null;
        obj = win.eval(nombreFuncionJS + "(" + url + ")");

        //System.out.println("Se llamo termino la ejecucion de ejecutarWeb");
        return obj;
    }

    public MareDTO ejecutarNegocio(String idBusiness, String nombreDTO, MareDTO dto) throws AppletException {
        Communicator comunicator = new Communicator();

        MareDTO mareDTO = comunicator.ejecutarNegocio(this.url, idBusiness, nombreDTO, dto);

        if (mareDTO instanceof es.indra.sicc.comunapplet.dtos.applet.DTOSessionExpired) {
            try {
                URL _url = new URL(urlLogin);
                getAppletContext().showDocument(_url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mareDTO;
    }

    /**
     * Buscar los parametros recibido en la pagina
     * @throws es.indra.sicc.communapplet.exceptions.AppletException
     */
    protected void GestorCobrosDevoluciones_onload() throws AppletException {
        try {
            this.marcoCobrosDevolucionesDetalleCabecera = new CobrosDevolucionesDetalleCabeceraController(this);
            this.marcoCobrosDevolucionesDetalle = new CobrosDevolucionesDetalleController(this);

            //boolean recibido = true;
            if (this.getParameter("oidPais") != null) {
                this.oidPais = new Long(this.getParameter("oidPais"));
            } else {
                Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_PARAMETRO_OBLIGATORIO_PAIS, this);
            }

            if (this.getParameter("oidIdioma") != null) {
                this.oidIdioma = new Long(this.getParameter("oidIdioma"));

                //System.out.println("oidIdioma: " + oidIdioma);
            } else {
                Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_PARAMETRO_OBLIGATORIO_IDIOMA, this);
            }

            if (this.getParameter("fechaSistema") != null) {
                this.fechaSistema = this.getParameter("fechaSistema");

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    this.fechaSistemaDate = new Date(sdf.parse(this.fechaSistema).getTime());

                    //System.out.println("fechaSistemaDate: " + fechaSistemaDate);
                } catch (ParseException e) {
                    this.fechaSistemaDate = new Date(System.currentTimeMillis());
                }
            }

            if (this.getParameter("belcenter") != null) {
                this.belcenter = this.getParameter("belcenter");

                //System.out.println("belcenter: " + belcenter);
            }

            if (this.getParameter("usuario") != null) {
                this.usuario = this.getParameter("usuario");

                //System.out.println("usuario: " + usuario);
            }

            if (this.getParameter("accion") != null) {
                this.accion = this.getParameter("accion");

                //System.out.println("accion: " + accion);
            }

            if (this.getParameter("ip") != null) {
                this.ip = this.getParameter("ip");

                //System.out.println("ip: " + ip);
            }

            if (this.getParameter("login") != null) {
                this.urlLogin = this.getParameter("login");
                String aux = this.getCodeBase().toString();
                //aux = aux.substring(0, aux.indexOf("sicc/") + "sicc/".length());
                aux = aux.substring(0, aux.indexOf("/sicc") + 1);
                this.urlLogin = aux + this.urlLogin;
                System.out.println("urlLogin: " + urlLogin);
            }

            if ((this.getParameter("url") != null) && !this.getParameter("url").equals("")) {
                this.url = this.getParameter("url");
                String aux = this.getCodeBase().toString();
                aux = aux.substring(0, aux.indexOf("/sicc") + 1);
                this.url = aux + this.url;
                System.out.println("url: " + url); 
                /* 
                String auxURL = this.getParameter("url");
                this.url = this.getCodeBase().toString();
                this.url = this.url.substring(0, this.url.indexOf("sicc/") + "sicc/".length());
                this.url += auxURL;
                */
            } //url="http://192.168.118.101:7777/sicc/ServletApplet"

            if ((this.getParameter("longitudCodigoCliente") != null) && !this.getParameter("longitudCodigoCliente").equals("")) {
                this.longCodClie = Integer.parseInt(this.getParameter("longitudCodigoCliente"));
            }

            /*
            this.oidIdioma = new Long(1);
            this.oidPais = new Long(1);
            this.fechaSistema = "14/03/2005";
            try {
              SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
              this.fechaSistemaDate = new Date(sdf.parse(this.fechaSistema).getTime());
            } catch (ParseException e) {
              this.fechaSistemaDate = new Date(System.currentTimeMillis());
            }
            this.belcenter = "true";
            this.ip = "192.168.119.155";
            url="http://192.168.118.101:7777/sicc/ServletApplet";
            this.usuario = "usuario1";
            this.accion = "Devolucion";
            */
            this.cargarDatosIniciales();
        } catch (Exception e) {
            e.printStackTrace();
            UtilApplet.procesarError(e, this);
        }
    }

    protected void cargarDatosIniciales() throws AppletException {
        if ((this.cache == null) || Boolean.FALSE.equals(this.cache.getCargado())) {
            this.cargarCache();
        }

        // Comprueba el estado de la caja 
        try {
            this.dtoComprobarInicioCobro = this.comprobarEstadoCaja();
            this.reiniciar();
        } catch (AppletException e) {
            UtilApplet.procesarError(e, this);
            this.deshabilitarTodo();

        }
    }

    /**
     * Comprueba el estado de la caja
     * @throws es.indra.sicc.ped.applet.exceptions.AppletException
     * @return
     */
    protected DTOComprobarInicioCobro comprobarEstadoCaja() throws AppletException {
        DTOComprobarInicioCobro dto = new DTOComprobarInicioCobro();
        dto.setOidPais(this.oidPais);
        dto.setOidIdioma(this.oidIdioma);
        dto.setIP(this.ip);
        dto.setOidSubacceso(this.cache.getOidSubAcceso());
        dto.setCobrarBelcenter(Boolean.FALSE);

        MareDTO mareDTO = this.ejecutarNegocio("BELComprobarInicioCobro", "es.indra.sicc.dtos.bel.DTOComprobarInicioCobro", dto);

        if (mareDTO instanceof DTOComprobarInicioCobro) {
            this.dtoComprobarInicioCobro = (DTOComprobarInicioCobro) mareDTO;
            this.oidTipoMovimientoCobrar = this.dtoComprobarInicioCobro.getOidTipoMovimientoCobrar();
            this.oidCuentaCorriente = this.dtoComprobarInicioCobro.getOidCuentaCorriente();
            this.oidEmpresa = this.dtoComprobarInicioCobro.getOidEmpresa();
            this.oidTipoTransaccion = this.dtoComprobarInicioCobro.getOidTipoTransaccion();

            return this.dtoComprobarInicioCobro;
        } //else {

        //}
        return null;
    }

    protected void cargarCache() throws AppletException {
        DTOCargaRegistroOnline dtoCargaRegistroOnline = new DTOCargaRegistroOnline();
        dtoCargaRegistroOnline.setOidPais(this.oidPais);
        dtoCargaRegistroOnline.setOidIdioma(this.oidIdioma);
        dtoCargaRegistroOnline.setCodUsuario(this.usuario);
        dtoCargaRegistroOnline.setBelcenter(Boolean.valueOf(this.belcenter));
        dtoCargaRegistroOnline.setIP(this.ip);

        //dtoCargaRegistroOnline.setOidSubAcceso(this.oidSubAcceso);
        dtoCargaRegistroOnline.setUserName(this.usuario);

        MareDTO mareDTO = this.ejecutarNegocio("PEDObtenerCargaInicialRegistro", "es.indra.sicc.dtos.ped.applet.DTOCargaRegistroOnline", dtoCargaRegistroOnline);

        if (mareDTO instanceof DTOCargaRegistroOnline) {
            DTOCargaRegistroOnline dtoR = (DTOCargaRegistroOnline) mareDTO;

            if (this.cache == null) {
                this.cache = RegistroCache.getInstance();
            }

            cache.setAccesosFisicos(dtoR.getAccesosFisico());
            cache.setFormaPago(dtoR.getFormasPago());
            cache.setOidSubAcceso(dtoR.getOidSubAcceso());
            cache.setPeriodos(dtoR.getPeriodos());
            cache.setTiposDespacho(dtoR.getTiposDespacho());
            cache.setTiposSolicitud(dtoR.getTiposSolicitud());
            cache.setTxtSubAcceso(dtoR.getTxtsubAcceso());
            cache.setTxtCanal(dtoR.getTxtCanal());
            cache.setTxtAcceso(dtoR.getTxtAcceso());
            cache.setCargado(Boolean.TRUE);
        } else {
            Dialogos.mensajeError(ConstantesApplet.ERROR_CARGA_INICIAL, this);
        }
    }

    protected void reiniciar() throws AppletException {
        if (this.dtoComprobarInicioCobro == null) {
            this.dtoComprobarInicioCobro = this.comprobarEstadoCaja();
        }

        this.totalPagado = new BigDecimal(0);
        this.oidTipoMovimientoCobrar = this.dtoComprobarInicioCobro.getOidTipoMovimientoCobrar();
        this.oidCaja = this.dtoComprobarInicioCobro.getOidCaja();

        //Muestra la siguiente información en pantalla: 
        //+ CobrosDevolucionesDetalleCabecera 
        this.lbCanal.setText(this.cache.getTxtCanal());
        this.lbAcceso.setText(this.cache.getTxtAcceso());
        this.lbSubAcceso.setText(this.cache.getTxtSubAcceso());
        this.lbCaja.setText(this.dtoComprobarInicioCobro.getCaja());
        this.lbFecha.setText("Cobro".equals(this.accion) ? this.fechaSistema : "");
        this.txtCodCliente.setText("");
        this.txtObservaciones.setText("");

        this.tablaDetalle.deleteRows();
        this.tablaDetalle.newRow();
        this.setMovimientoCaja(null);

        //+ CobrosDevolucionesDetalleCabecera     
        if ("Cobro".equals(this.accion)) {
            this.tablaDetalle.colNroNotaCredito.setVisible(false);
        } else {
            this.tablaDetalle.colNroNotaCredito.setVisible(true);
        }
    }

    public void setOidCliente(String oid) {
        this.oidCliente = new Long(oid);
    }

    public void setOidCliente(Long oid) {
        this.oidCliente = oid;
    }

    public void setCodigoCliente(String cod) {
        this.txtCodCliente.setText(cod);
    }

    public void setObservaciones(String str) {
        this.txtObservaciones.setText(str);
    }

    public void setCodigoClienteFocus() {
        this.txtCodCliente.requestFocus();
    }

    public String getTxtCodCliente() {
        return this.txtCodCliente.getText();
    }

    public ArrayList getMovimientoCaja() {
        return this.movimientosCaja;
    }

    public void setMovimientoCaja(ArrayList array) {
        this.movimientosCaja = array;
    }

    public void setTotalPagado(BigDecimal b) {
        this.totalPagado = b;
    }

    public BigDecimal getTotalPagado() {
        return this.totalPagado;
    }

    public TablaDetalle getTablaDetalle() {
        return this.tablaDetalle;
    }

    public Long getOidTipoMovimientoCobrar() {
        return this.oidTipoMovimientoCobrar;
    }

    public Long getOidMoneda() {
        return this.oidMoneda;
    }

    public void setOidMoneda(Long l) {
        this.oidMoneda = l;
    }

    public Long getOidMedioPago() {
        return this.oidMedioPago;
    }

    public void setOidMedioPago(Long l) {
        this.oidMedioPago = l;
    }

    public Date getFechaSistemaDate() {
        return this.fechaSistemaDate;
    }

    public DTODatosCobroDevolucion getCargaDatosDetalle() {
        return this.cargaDatosDetalle;
    }

    public void setCargaDatosDetalle(DTODatosCobroDevolucion dto) {
        this.cargaDatosDetalle = dto;
    }

    public Long getOidPais() {
        return this.oidPais;
    }

    public Long getOidIdioma() {
        return this.oidIdioma;
    }

    public String getAccion() {
        return this.accion;
    }

    public RegistroCache getCache() {
        return this.cache;
    }

    public String getUsuario() {
        return this.usuario;
    }
}
