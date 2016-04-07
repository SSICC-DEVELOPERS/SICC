import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;
import es.indra.sicc.dtos.mae.DTOREPClienteDatosBasicos;
import es.indra.sicc.dtos.mae.DTOREPCobranzas;
import es.indra.sicc.dtos.mae.DTOREPCredito;
import es.indra.sicc.dtos.mae.DTOREPCuentasCorrientes;
import es.indra.sicc.dtos.mae.DTOREPHistorialCreditoCliente;
import es.indra.sicc.dtos.mae.DTOREPSolicitudMasAntiguaNoCancelada;
import es.indra.sicc.dtos.mae.DTOREPSolicitudesBloqueadas;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;


public class CARHistorialCredito extends LPSICCBase {           
  
  Long pais = null;
  Long idioma = null;
  
   public CARHistorialCredito() {	 
     super();
  }

  public void inicio() throws Exception { 
     
  }

  public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     setTrazaFichero();
     try {
        this.rastreo();
        pais=UtilidadesSession.getPais(this);
        idioma=UtilidadesSession.getIdioma(this);
        
        if (accion.equals("generar")){
           generarReporte(); 
           traza("termino de generar el reporte");
          //cargarPagina();
        } else if (accion.equals("casoDeUso")){        
           obtenerHistorialCreditoCliente();
           cargarPenstaniaClientes();
        } else if (accion.equals("Cliente")){
           cargarPenstaniaClientes();
        } else if (accion.equals("Solicitud")){           
           cargarPenstaniaSolicitud();
        } else if (accion.equals("Cuenta Corriente")){           
           cargarPenstaniaCuentaCorriente();
        } else if (accion.equals("Cobranza")){           
           cargarPenstaniaCobranza();
        } else if (accion.equals("Credito")){           
           cargarPenstaniaCredito();
        } else if (accion.equals("Solicitudes Bloqueadas")){
           cargarPenstaniaSolicitudesBloqueadas();
        }  else {
           cargarPagina();
           getConfiguracionMenu("CARHistorialCredito");
        }
     
     } catch (Exception ex) {
     			
      // cargarPagina();
      
        logStackTrace(ex);
		    lanzarPaginaError(ex);

     }

    
  }
  
  private void cargarPagina() throws Exception{
     pagina("contenido_historial_credito_cliente_obtener");   
        
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     asignarAtributo("VAR", "hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
         
   
  }
  private void cargarMenuSecundario() throws Exception{
      this.getConfiguracionMenu("CARHistorialCredito", "CU");
      this.asignarAtributoPagina("cod", "0763");   
  }  

          
  
 private void generarReporte() throws Exception{
          
     HashMap datos = new HashMap();
     datos.put("MODULO", "CAR");
     
     //comienzo de los parametrso de filtrado
       
     String codigoCliente        = conectorParametroLimpia("codigoCliente", "", true);
     if(!codigoCliente.equals("")){
        datos.put(ConstantesREP.CODIGOCLIENTE, codigoCliente);     
     }
          
     
       
     datos.put(ConstantesREP.TITULO, "Historial de Credito del Cliente");     
     traza("++++++Antes de enviar a reportes " + datos); 
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-157", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-157", "pdf");
          
  } 
 /**
  * @Autor: Emilio Noziglia
  * @Fecha : 26/05/2005
  * @Recibe: void
  * @Retorna: void
  * @Descripción: Obtiene la información del historial de credito del cliente dado el cliente 
  *               y lo coloca en sesion.
  */ 
  private void obtenerHistorialCreditoCliente() throws Exception {
      
      traza("entra en obtenerHistorialCreditoCliente");
      String codigoCliente = conectorParametroLimpia("codigoCliente", "", true);
      //Creo un DTOCodigoCliente con: 
      DTOCodigoCliente dtoCodCliente = new DTOCodigoCliente();
      dtoCodCliente.setCodigoCliente(codigoCliente);
      dtoCodCliente.setOidIdioma(idioma);
      dtoCodCliente.setOidPais(pais); 
      
      //Creo un idBusiness = "MAEObtenerHistorialCreditoCliente" 
      MareBusinessID id = new MareBusinessID("MAEObtenerHistorialCreditoCliente");
      Vector vec = new Vector();
      vec.add(dtoCodCliente);
      vec.add(id);
      
      //Invoco a ConectorObjeto 
      traza("antes de conectar ConectorObjeto");
      DruidaConector conectorSalida = conectar("ConectorObjeto",vec);
      //Recibo un DTOREPHistorialCreditoCliente 
      DTOREPHistorialCreditoCliente dtoHistoCredi = (DTOREPHistorialCreditoCliente)conectorSalida.objeto("DTOSalida");
      
      //Coloco en sesion DTOREPHistorialCreditoCliente
      this.conectorParametroSesion("DTOREPHistorialCreditoCliente",dtoHistoCredi);      
      traza("sale de obtenerHistorialCreditoCliente");
  
  }
/**
 * @Autor: Emilio Noziglia
 * @Fecha : 26/05/2005
 * @Recibe: void 
 * @Retorna: void
 * @Descripción: Obtiene de sesion los datos basicos de cliente y carga la pantalla correspondiente
 *               con lo obtenido
 */ 
  private void cargarPenstaniaClientes() throws Exception {
    traza("entra a cargarPenstaniaClientes");
    this.pagina("contenido_datos_basicos_clientes_consultar");
    DTOREPHistorialCreditoCliente dtoHistoCredi = (DTOREPHistorialCreditoCliente)this.conectorParametroSesion("DTOREPHistorialCreditoCliente");
    DTOREPClienteDatosBasicos dtoCliente = dtoHistoCredi.getDatosBasicosCliente();
    traza("Datos Basicos Cliente:"+dtoCliente);
    asignarAtributo("LABELC", "lblCodClientedt", "valor", dtoCliente.getCodigoCliente()!=null?dtoCliente.getCodigoCliente():"");
    asignarAtributo("LABELC", "lblNombredt", "valor", dtoCliente.getNombreCliente()!=null?dtoCliente.getNombreCliente():"");
    asignarAtributo("LABELC", "lblEstatusdt", "valor", dtoCliente.getStatusCliente()!=null?dtoCliente.getStatusCliente():"");
    asignarAtributo("LABELC", "lblTelefonodt", "valor", dtoCliente.getTelefono()!=null?dtoCliente.getTelefono():"");
    asignarAtributo("LABELC", "lblEmaildt", "valor", dtoCliente.getEmail()!=null?dtoCliente.getEmail():"");
    asignarAtributo("LABELC", "lblMarcadt", "valor", dtoCliente.getMarca()!=null?dtoCliente.getMarca():"");
    asignarAtributo("LABELC", "lblCanaldt", "valor", dtoCliente.getCanal()!=null?dtoCliente.getCanal():"");
    asignarAtributo("LABELC", "lblCampanaIngresodt", "valor", dtoCliente.getPeriodo()!=null?dtoCliente.getPeriodo():"");
    asignarAtributo("LABELC", "lblFechaIngresodt", "valor", this.obtenerFechaFormatoPais(dtoCliente.getFechaDeIngreso()));
    asignarAtributo("LABELC", "lblBloqueoAdministrativodt", "valor", ((dtoCliente.getBloqueoAdministrativo()!=null)&&(dtoCliente.getBloqueoAdministrativo().equals(new Boolean(true))))?"Si":"No");
    asignarAtributo("LABELC", "lblMotivodt", "valor", dtoCliente.getMotivoBloqueoAdministrativo()!=null?dtoCliente.getMotivoBloqueoAdministrativo():"");
    asignarAtributo("LABELC", "lblBloqueoFinancierodt", "valor", ((dtoCliente.getBloqueoFinanciero()!=null)&&(dtoCliente.getBloqueoFinanciero().equals(new Boolean(true))))?"Si":"No");
    
    cargarMenuSecundario();
    traza("sale de cargarPenstaniaClientes");  
  }  
/**
 * @Autor: Emilio Noziglia
 * @Fecha : 26/05/2005
 * @Recibe: void 
 * @Retorna: void
 * @Descripción: Obtiene de sesion los datos de la soliocitud y carga la pantalla correspondiente
 *               con lo obtenido
 */   
  private void cargarPenstaniaSolicitud() throws Exception {
    traza("entra a cargarPenstaniaSolicitud");
    this.pagina("contenido_solicitud_antigua_consultar");
    DTOREPHistorialCreditoCliente dtoHistoCredi = (DTOREPHistorialCreditoCliente)this.conectorParametroSesion("DTOREPHistorialCreditoCliente");
    DTOREPSolicitudMasAntiguaNoCancelada dtoSolicitud = dtoHistoCredi.getSolicitudMasAntiguaNoCancelada();
    traza("Solicitud:"+dtoSolicitud);
    asignarAtributo("LABELC", "lbldtTipoSolicitud", "valor", dtoSolicitud.getTipoSolicitud()!=null?dtoSolicitud.getTipoSolicitud():"");
    asignarAtributo("LABELC", "lbldtNumSolicitud", "valor", dtoSolicitud.getNumeroSolicitud()!=null?dtoSolicitud.getNumeroSolicitud().toString():"");
    asignarAtributo("LABELC", "lbldtSociedad", "valor", dtoSolicitud.getSociedad()!=null?dtoSolicitud.getSociedad():"");
    asignarAtributo("LABELC", "lbldtFechaFacturacion", "valor", dtoSolicitud.getFechaFacturacion()!=null?this.obtenerFechaFormatoPais(dtoSolicitud.getFechaFacturacion()):"");
    asignarAtributo("LABELC", "lbldtFechaVencimiento", "valor", dtoSolicitud.getFechaVencimiento()!=null?this.obtenerFechaFormatoPais(dtoSolicitud.getFechaVencimiento()):"");
    asignarAtributo("LABELC", "lbldtCondicionPago", "valor", dtoSolicitud.getCondicionPago()!=null?dtoSolicitud.getCondicionPago():"");
    asignarAtributo("LABELC", "lbldtMontoPedido", "valor", dtoSolicitud.getMontoPedido()!=null?UtilidadesBelcorp.formateaNumeroSICC(dtoSolicitud.getMontoPedido().toString(),  this.FORMATO_DEFAULT,this):"");
    asignarAtributo("LABELC", "lbldtMontoSaldo", "valor", dtoSolicitud.getMontoSaldo()!=null?UtilidadesBelcorp.formateaNumeroSICC(dtoSolicitud.getMontoSaldo().toString(), this.FORMATO_DEFAULT,this):"");    
    cargarMenuSecundario();
    traza("sale de cargarPenstaniaSolicitud");    
  }  
/**
 * @Autor: Emilio Noziglia
 * @Fecha : 26/05/2005
 * @Recibe: void 
 * @Retorna: void
 * @Descripción: Obtiene de sesion los datos de cuenta corriente y carga la pantalla correspondiente
 *               con lo obtenido
 */   
  private void cargarPenstaniaCuentaCorriente() throws Exception {
    traza("entra a cargarPenstaniaCuentaCorriente");
    this.pagina("contenido_datos_cuentas_corrientes_consultar");
    DTOREPHistorialCreditoCliente dtoHistoCredi = (DTOREPHistorialCreditoCliente)this.conectorParametroSesion("DTOREPHistorialCreditoCliente");
    DTOREPCuentasCorrientes dtoCuentaCorriente = dtoHistoCredi.getCuentasCorrientes();
    traza("Cuentas Corrientes:"+dtoCuentaCorriente);
    asignarAtributo("VAR", "codigoCliente","valor",dtoHistoCredi.getDatosBasicosCliente().getCodigoCliente());
    asignarAtributo("LABELC", "lblSaldoActualdt", "valor", dtoCuentaCorriente.getSaldoActual()!=null?UtilidadesBelcorp.formateaNumeroSICC(dtoCuentaCorriente.getSaldoActual().toString(), this.FORMATO_MONEDA,this):"");
    asignarAtributo("LABELC", "lblNVecesProntoPagodt", "valor", dtoCuentaCorriente.getNroVecesProntoPago()!=null?dtoCuentaCorriente.getNroVecesProntoPago().toString():"");
    asignarAtributo("LABELC", "lblNVecesRecatgoFinancierodt", "valor", dtoCuentaCorriente.getNroVecesRecargoFinanciero()!=null?dtoCuentaCorriente.getNroVecesRecargoFinanciero().toString():"");
    asignarAtributo("LABELC", "lblDiasMoradt", "valor", dtoCuentaCorriente.getPromedioDiasMora()!=null?dtoCuentaCorriente.getPromedioDiasMora().toString():"");
    asignarAtributo("LABELC", "lblValorTotaldt", "valor", dtoCuentaCorriente.getValorTotalMora()!=null?UtilidadesBelcorp.formateaNumeroSICC(dtoCuentaCorriente.getValorTotalMora().toString(), this.FORMATO_MONEDA,this):"");
    asignarAtributo("LABELC", "lblPorCientoFacturadt", "valor", dtoCuentaCorriente.getPorcDeFactura()!=null?dtoCuentaCorriente.getPorcDeFactura().toString()+" %":"0 %");
    cargarMenuSecundario();
    traza("sale de cargarPenstaniaCuentaCorriente");    
  }  
  /**
 * @Autor: Emilio Noziglia
 * @Fecha : 26/05/2005
 * @Recibe: void 
 * @Retorna: void
 * @Descripción: Obtiene de sesion los datos de cobranza y carga la pantalla correspondiente
 *               con lo obtenido
 */ 
  private void cargarPenstaniaCobranza() throws Exception {
    traza("entra a cargarPenstaniaCobranza");
    this.pagina("contenido_datos_cobranzas_consultar");
    DTOREPHistorialCreditoCliente dtoHistoCredi = (DTOREPHistorialCreditoCliente)this.conectorParametroSesion("DTOREPHistorialCreditoCliente");
    DTOREPCobranzas dtoCobranza = dtoHistoCredi.getCobranzas();
    traza("Cobranzas:"+dtoCobranza);
    asignarAtributo("VAR", "codigoCliente","valor",dtoHistoCredi.getDatosBasicosCliente().getCodigoCliente());
    asignarAtributo("LABELC", "lblActualmanteCobranzasdt", "valor", ((dtoCobranza.getActualmenteEnCobranzas()!=null)&&(dtoCobranza.getActualmenteEnCobranzas().equals(new Boolean(true))))?"Si":"No");
    RecordSet recordSet = ((dtoCobranza.getDatosEtapa()!=null)&&(dtoCobranza.getDatosEtapa().getResultado()!=null))?dtoCobranza.getDatosEtapa().getResultado():null;
    if (recordSet!=null){    
      if (recordSet.esVacio()) traza("DatosEtapa vacios");
      
      asignar("LISTADOA", "listado1",
            UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
                recordSet.getColumnIdentifiers()), "dtoSalida");    
    } else {
      traza("DatosEtapa nulos");
    }
    cargarMenuSecundario();
    traza("sale de cargarPenstaniaCobranza");    
  }  
/**
 * @Autor: Emilio Noziglia
 * @Fecha : 26/05/2005
 * @Recibe: void 
 * @Retorna: void
 * @Descripción: Obtiene de sesion los datos de credito y carga la pantalla correspondiente
 *               con lo obtenido
 */ 
  private void cargarPenstaniaCredito() throws Exception {
    traza("entra a cargarPenstaniaCredito");
    this.pagina("contenido_datos_credito_consultar");
    DTOREPHistorialCreditoCliente dtoHistoCredi = (DTOREPHistorialCreditoCliente)this.conectorParametroSesion("DTOREPHistorialCreditoCliente");
    DTOREPCredito dtoCredito = dtoHistoCredi.getCredito();
    traza("Credito:"+dtoCredito);
    asignarAtributo("LABELC", "lblResponsabledt", "valor", dtoCredito.getResponsableCredito()!=null?dtoCredito.getResponsableCredito():"");
    asignarAtributo("LABELC", "lblLineaCreditoActualdt", "valor", dtoCredito.getLineaCreditoActual()!=null?UtilidadesBelcorp.formateaNumeroSICC(dtoCredito.getLineaCreditoActual().toString(), this.FORMATO_DEFAULT,this):"");
    asignarAtributo("LABELC", "lblLineaCreditoDisponibledt", "valor", dtoCredito.getLineaCreditoDisponible()!=null?UtilidadesBelcorp.formateaNumeroSICC(dtoCredito.getLineaCreditoDisponible().toString(), this.FORMATO_DEFAULT,this):"");
    traza("dtoCredito.getPeriodoLineaCredito():"+dtoCredito.getPeriodoLineaCredito());
    asignarAtributo("LABELC", "lblPeriodoUltimaEvaluaciondt", "valor", dtoCredito.getPeriodoLineaCredito()!=null?dtoCredito.getPeriodoLineaCredito():"");
    asignarAtributo("LABELC", "lblPeriodoPromediodt", "valor", dtoCredito.getPedidoPromedioUltimaEvaluacion()!=null?dtoCredito.getPedidoPromedioUltimaEvaluacion().toString():"");
    asignarAtributo("LABELC", "lblLineaCreditoConsumidadt", "valor", dtoCredito.getPorcLineaCreditoActualConsumida()!=null?UtilidadesBelcorp.formateaNumeroSICC(dtoCredito.getPorcLineaCreditoActualConsumida().toString(), this.FORMATO_DEFAULT,this)+" %":"0 %");
    asignarAtributo("LABELC", "lblNivelRiesgoActualdt", "valor", dtoCredito.getNivelRiesgo()!=null?dtoCredito.getNivelRiesgo():"");
    asignarAtributo("LABELC", "lblPeriodoUltimaEvaluaciondt2", "valor", dtoCredito.getPeriodoUltimaEvaluacion()!=null?dtoCredito.getPeriodoUltimaEvaluacion():"");
    asignarAtributo("LABELC", "lblNumPeriodosdt", "valor", dtoCredito.getNroPeriodosPedidoUltEval()!=null?dtoCredito.getNroPeriodosPedidoUltEval().toString():"");
    cargarMenuSecundario();
    traza("sale de cargarPenstaniaCredito");    
  }  
/**
 * @Autor: Emilio Noziglia
 * @Fecha : 26/05/2005
 * @Recibe: void 
 * @Retorna: void
 * @Descripción: Obtiene de sesion los datos de solicitudes bloqueadas y carga la pantalla
 *               correspondiente con lo obtenido
 */ 
  private void cargarPenstaniaSolicitudesBloqueadas() throws Exception {
    traza("entra a cargarPenstaniaSolicitudesBloqueadas");
    this.pagina("contenido_solicitudes_bloqueadas_consultar");
    DTOREPHistorialCreditoCliente dtoHistoCredi = (DTOREPHistorialCreditoCliente)this.conectorParametroSesion("DTOREPHistorialCreditoCliente");
    DTOREPSolicitudesBloqueadas dtoSoliBloq = dtoHistoCredi.getSolicitudesBloquedas();
    traza("Solicitudes Bloqueadas:"+dtoSoliBloq);
    RecordSet recordSet = ((dtoSoliBloq.getSoliBloqUltimosSeisMeses()!=null)&&(dtoSoliBloq.getSoliBloqUltimosSeisMeses().getResultado()!=null))?dtoSoliBloq.getSoliBloqUltimosSeisMeses().getResultado():null;
    if (recordSet!=null){    
      if (recordSet.esVacio()) traza("SoliBloqUltimosSeisMeses vacios");
      
      asignar("LISTADOA", "listado1",
            UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
                recordSet.getColumnIdentifiers()), "dtoSalida");    
    } else {
      traza("SoliBloqUltimosSeisMeses nulos");
    }    
    cargarMenuSecundario();
    traza("sale de cargarPenstaniaSolicitudesBloqueadas");    
  }    
  
    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
    }

    /**
     * Retorna el string fecha segun el formato por pais.
     * La fecha a formatear viene en formato Date YYYY-MM-DD.
     */
    private String obtenerFechaFormatoPais(Date fecha) throws Exception {
      // obtenemos el formato de fecha actual segun el pais
      String formatoFecha = null;
         formatoFecha = UtilidadesSession.getFormatoFecha(this);
      // aseguro el indicador de mes a mayuscula  
      formatoFecha = formatoFecha.replace('m','M');
      //trabajamos con el formato del pais
      SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
      //formateamos la fecha segun el formato del pais
      String fechaFormatoPaisStr = null;
      if (fecha != null){
         fechaFormatoPaisStr = formatoPais.format(fecha);
      }
      //retorna la fecha formateada    
      return fechaFormatoPaisStr;
    }  
}











