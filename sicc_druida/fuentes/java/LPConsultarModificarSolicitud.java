//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionBasicaSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionClienteSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionAdministrativaSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionEconomicaSolicitud;
import es.indra.sicc.dtos.ped.DTOInformacionEstadoSolicitud;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;
import java.sql.Date;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;
import java.util.Vector;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

public class LPConsultarModificarSolicitud extends LPSICCBase {
    private Long pais = null;
    private Long idioma = null;
    private String accion =null;  
    private String soidCabeceraSolicitud = null;
    private Long oidCabeceraSolicitud = null;
    private String operacion = null;
    
    
    public void inicio() throws Exception{
        pagina("contenido_solicitud_visualizar");
    }

    public LPConsultarModificarSolicitud() 
    {
      super();
    }
  
    public void ejecucion() throws Exception {
        this.setTrazaFichero();
        try{
            traza("Entra a LPConsultarModificarSolicitud");
            this.rastreo();
            pais=UtilidadesSession.getPais(this);
            idioma=UtilidadesSession.getIdioma(this);
            accion = conectorParametro("accion");
            soidCabeceraSolicitud = conectorParametro("oidCabeceraSolicitud");            
            operacion = conectorParametro("operacion");                  
            try{
            oidCabeceraSolicitud = (soidCabeceraSolicitud==null||soidCabeceraSolicitud.equals(""))?null:new Long(soidCabeceraSolicitud);
            } catch (NumberFormatException ne) {
              //Vino un valor no vacio que no es un numero.
              oidCabeceraSolicitud = null;
            }
            operacion = (operacion==null?"":operacion);
            accion = (accion==null?"":accion);
            traza("accion"+accion);
            traza("operacion"+operacion);
            traza("oidCabeceraSolicitud"+oidCabeceraSolicitud);
            this.getConfiguracionMenu("LPConsultarModificarSolicitud","");
            this.getFormatosValidaciones();
            asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
            if (accion.equalsIgnoreCase("")){
                if (oidCabeceraSolicitud!=null&&(!oidCabeceraSolicitud.equals(""))){
                   consultarModificarSolicitud(oidCabeceraSolicitud, operacion);
                } else {
                   if (operacion.equalsIgnoreCase("Consultar")||operacion.equalsIgnoreCase("")) {
                       buscarSolicitudConsulta();
                   } else if (operacion.equalsIgnoreCase("Modificar")) {
                       buscarSolicitudModificacion();
                   }
                }
            }else if(accion.equalsIgnoreCase("Modificar")){
                modificarSolicitud();
            }else if(accion.equalsIgnoreCase("Posiciones")){
                modificarPosiciones();
            }else if( accion.equals("Modificar Codigo") ){
              	modificarCodigo();
            }
            
        }catch(Exception e){
            logStackTrace(e);
            e.printStackTrace();
            this.lanzarPaginaError(e);
        }
    }

    private void consultarModificarSolicitud(Long oidCabeceraSolicitud, String operacion) throws Exception{
      // Muestra en la página PGInformacionSolicitud(contenido_solicitud_visualizar), la información de la solicitud recibida 

      // Obtenemos la solicitud       
      DTOInformacionSolicitud dtoinfosoli = obtenerSolicitud(oidCabeceraSolicitud);
      
      // Obtenemos el cliente de la solicitud 
      Long oidCliente = dtoinfosoli.getDtoInformacionClienteSolicitud().getOidCliente(); 
      
      // Cargamos los combos de la página 
      cargarPaginaSolicitud(oidCliente, operacion);
      
      // Mostramos los datos de la solicitud 
      mostrarSolicitud(dtoinfosoli);
    }

    private DTOInformacionSolicitud obtenerSolicitud(Long oidCabeceraSolicitud) throws Exception{
      // Obtiene la información de la solicitud recibida
      //Creo un DTOOID con: 
      DTOOID dtooid = new DTOOID();
      dtooid.setOid(oidCabeceraSolicitud);
      dtooid.setOidIdioma(idioma);
      dtooid.setOidPais(pais);      
      //Creo un idBusiness = "PEDObtenerSolicitud" 
      MareBusinessID id = new MareBusinessID("PEDObtenerSolicitudN030");
      Vector vec = new Vector();
      vec.add(dtooid);
      vec.add(id);
      //Invoco a ConectorObtenerSolicitud 
      traza("antes de conectar ConectorObtenerSolicitud");
      DruidaConector conectorSalida = conectar("ConectorObtenerSolicitud",vec);
      //Recibo un DTOInformacionSolicitud 
      DTOInformacionSolicitud dtoinfosoli =  (DTOInformacionSolicitud)conectorSalida.objeto("dtoSalida");
      //Devuelvo DTOInformacionSolicitud      
      return dtoinfosoli;  
    }
    
    private void cargarPaginaSolicitud(Long oidCliente, String operacion) throws Exception{
      
      if (operacion.equalsIgnoreCase("Consultar")){
          //Habilita el botón btVisualizarPosiciones
          this.getConfiguracionMenu("LPConsultarModificarSolicitud","Consultar");
          asignarAtributoPagina("cod","0922");
          asignarAtributo("VAR","enablebtVisualizarPosiciones", "valor","S");
		  asignarAtributo("COMBO","cbAccesoFisico", "req","N");
		  
          
      } else if (operacion.equalsIgnoreCase("Modificar")){
          traza ("operacion.equalsIgnoreCase(Modificar)");
          //Habilita el botón btModificarPosiciones
          this.getConfiguracionMenu("LPConsultarModificarSolicitud","Modificar");
          asignarAtributoPagina("cod","0336");
          asignarAtributo("VAR","enablebtModificarPosiciones", "valor","S");
          //Llamo al método habilitarCamposModificar() 
          asignarAtributo("VAR","enableCamposModificar", "valor","S");
          habilitarCamposModificar();
      }   
      
      
      //Preparamos los parametros del subsistema
      //Creo un DTOBelcorp dtoe con: 
      DTOBelcorp dtoe = new DTOBelcorp();
      dtoe.setOidPais(pais);
      dtoe.setOidIdioma(idioma);
  
      //Crear una lista ComposerViewElementList 
      ComposerViewElementList lista = new ComposerViewElementList(); 
      // ACCESO FISICO     
      //Creo un elemento de tipo ComposerViewElement() 
      ComposerViewElement elem1 = new ComposerViewElement();
      elem1.setIDBusiness("PEDObtenerAccesoFisico"); 
      elem1.setDTOE(dtoe);
      //Añado el elemento a la lista 
      lista.addViewElement(elem1);
  
      // TIPO DESPACHO 
      //Creo un elemento de tipo ComposerViewElement() 
      ComposerViewElement elem2 = new ComposerViewElement();
      elem2.setIDBusiness("PEDObtenerTipoDespacho"); 
      elem2.setDTOE(dtoe);
      //Añado el elemento a la lista 
      lista.addViewElement(elem2);
  
      // FORMA DE PAGO 
      //Creo un elemento de tipo ComposerViewElement() 
      ComposerViewElement elem3 = new ComposerViewElement();
      elem3.setIDBusiness("BELFormasPagoPais"); 
      elem3.setDTOE(dtoe);
      //Añado el elemento a la lista 
      lista.addViewElement(elem3);
  
      // Datos asociados al cliente 
      //Creo un DTOOID dtooid con: 
      DTOOID dtooid = new DTOOID();
      dtooid.setOidPais(pais);
      dtooid.setOidIdioma(idioma);
      dtooid.setOid(oidCliente);
  
      // DESTINO 
      //Creo un elemento de tipo ComposerViewElement() 
      ComposerViewElement elem4 = new ComposerViewElement();
      elem4.setIDBusiness("MAEObtenerTiposDireccionCliente"); 
      elem4.setDTOE(dtooid);
      //Añado el elemento a la lista 
      lista.addViewElement(elem4);
  
      // TIPO DOCUMENTO 
      //Creo un elemento de tipo ComposerViewElement() 
      ComposerViewElement elem5 = new ComposerViewElement();
      elem5.setIDBusiness("MAEObtenerTiposDocumentoCliente"); 
      elem5.setDTOE(dtooid);
      //Añado el elemento a la lista 
      lista.addViewElement(elem5);
  
      //Invoco al subsistema GestorCargaPantalla 
      /* 
        Asigna y los combos: 
        - cbAccesoFisico 
        - cbFormaPago 
        - cbTipoDespacho 
        - cbDestino 
        - cbTipoDocumento 
      */		
      //Utilizamos el subsistema
      ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      
      //Cargamos los combos con los resultados
      asignar("COMBO", "cbAccesoFisico", resultados, "PEDObtenerAccesoFisico");
      asignar("COMBO", "cbFormaPago", resultados, "BELFormasPagoPais");
      asignar("COMBO", "cbTipoDespacho", resultados, "PEDObtenerTipoDespacho");
      asignar("COMBO", "cbDestino", resultados, "MAEObtenerTiposDireccionCliente");
      asignar("COMBO", "cbTipoDocumentoIdentidad", resultados, "MAEObtenerTiposDocumentoCliente");        
      
     
    }    

    private void habilitarCamposModificar() throws Exception{
        //Los habilito por js
    } 
    
    private void mostrarSolicitud(DTOInformacionSolicitud dtoinfosoli) throws Exception{      
      // Muestra la información de la solicitud en las distintas pestañas que componen la página PGInformacionSolicitud (contenido_solicitud_visualizar)
      
      // Información básica 
      mostrarInformacionBasica(dtoinfosoli.getDtoInformacionBasicaSolicitud());
      
      // Información cliente 
      mostrarInformacionCliente(dtoinfosoli.getDtoInformacionClienteSolicitud());
      
      // Información administrativa 
      mostrarInformacionAdministrativa(dtoinfosoli.getDtoInformacionAdministrativaSolicitud()); 
      
      // Información economica 
      mostrarInformacionEconomica(dtoinfosoli.getDtoInformacionEconomicaSolicitud()); 
      
      // Información estado 
      mostrarInformacionEstado(dtoinfosoli.getDtoInformacionEstadoSolicitud()); 
      
      //Envio a la pagina PGInformacionSolicitud: (contenido_solicitud_visualizar) - dtoinfosoli.oidCabeceraSolicitud
      String hoidCabeceraSolicitud = (dtoinfosoli.getOidCabeceraSolicitud()!=null)?dtoinfosoli.getOidCabeceraSolicitud().toString():"";
      asignarAtributo("VAR","hoidCabeceraSolicitud", "valor",hoidCabeceraSolicitud);
    }    

    private void mostrarInformacionBasica(DTOInformacionBasicaSolicitud dtoe) throws Exception{        
      // Muestra la información básica de la solicitud en la capa CapaInformacionBasica 
        asignarAtributo("LABELC", "lblTipoSolicitudXX", "valor",(dtoe.getTipoSolicitud() == null) ? "":dtoe.getTipoSolicitud());
        asignarAtributo("LABELC", "lblSubaccesoXX", "valor",(dtoe.getSubacceso() == null) ? "":dtoe.getSubacceso());
        asignarAtributo("LABELC", "lblNumeroSolicitudXX", "valor",(dtoe.getNumeroSolicitud() == null) ? "":dtoe.getNumeroSolicitud().toString());
        asignarAtributo("LABELC", "lblMarcaXX", "valor",(dtoe.getMarca() == null) ? "":dtoe.getMarca());
        asignarAtributo("LABELC", "lblCanalXX", "valor",(dtoe.getCanal() == null) ? "":dtoe.getCanal());
        asignarAtributo("LABELC", "lblPeriodoXX", "valor",(dtoe.getPeriodo() == null) ? "":dtoe.getPeriodo());
        asignarAtributo("LABELC", "lblAccesoXX", "valor",(dtoe.getAcceso() == null) ? "":dtoe.getAcceso());
        asignarAtributo("LABELC", "lblSociedadVentasXX", "valor",(dtoe.getSociedadVentas() == null) ? "":dtoe.getSociedadVentas());
        
        asignarAtributo("VAR","hcbAccesoFisico", "valor",(dtoe.getOidAccesoFisico() == null) ? "":dtoe.getOidAccesoFisico().toString());
        asignarAtributo("VAR","hcbTipoDespacho", "valor",(dtoe.getOidTipoDespacho() == null) ? "":dtoe.getOidTipoDespacho().toString());
        asignarAtributo("VAR","hoidTipoSolicitud", "valor",(dtoe.getOidTipoSolicitud() == null) ? "":dtoe.getOidTipoSolicitud().toString());
        asignarAtributo("VAR","hoidProceso", "valor",(dtoe.getOidProceso() == null) ? "":dtoe.getOidProceso().toString());
        
        asignarAtributo("VAR","hnroSolicitud", "valor",(dtoe.getNumeroSolicitud() == null) ? "":dtoe.getNumeroSolicitud().toString());
        asignarAtributo("VAR","hoidSubacceso", "valor",(dtoe.getOidSubacceso() == null) ? "":dtoe.getOidSubacceso().toString());
        asignarAtributo("VAR","hoidMarca", "valor",(dtoe.getOidMarca() == null) ? "":dtoe.getOidMarca().toString());
        asignarAtributo("VAR","hoidCanal", "valor",(dtoe.getOidCanal() == null) ? "":dtoe.getOidCanal().toString());
        asignarAtributo("VAR","hoidPeriodo", "valor",(dtoe.getOidPeriodo() == null) ? "":dtoe.getOidPeriodo().toString());
        asignarAtributo("VAR","hoidAcceso", "valor",(dtoe.getOidAcceso() == null) ? "":dtoe.getOidAcceso().toString());
    }    

    private void mostrarInformacionCliente(DTOInformacionClienteSolicitud dtoe) throws Exception{        
       // Muestra la información del cliente de la solicitud en la capa CapaInformacionCliente 
        asignarAtributo("LABELC", "lblCodigoClienteXX", "valor",(dtoe.getCodigoCliente() == null) ? "":dtoe.getCodigoCliente());
        asignarAtributo("LABELC", "lblNombreXX", "valor",(dtoe.getNombre() == null) ? "":dtoe.getNombre());
        asignarAtributo("LABELC", "lblApellidosXX", "valor",((dtoe.getApellido1() == null) ? "":dtoe.getApellido1())+" "+((dtoe.getApellido2() == null) ? "":dtoe.getApellido2()));
        asignarAtributo("LABELC", "lblTipoClienteXX", "valor",(dtoe.getTipoCliente() == null) ? "":dtoe.getTipoCliente());
        asignarAtributo("LABELC", "lblSubTipoClienteXX", "valor",(dtoe.getSubtipoCliente() == null) ? "":dtoe.getSubtipoCliente());
        asignarAtributo("LABELC", "lblSubgerenciaVentasXX", "valor",(dtoe.getSubgerenciaCliente() == null) ? "":dtoe.getSubgerenciaCliente());
        asignarAtributo("LABELC", "lblRegionXX", "valor",(dtoe.getRegionCliente() == null) ? "":dtoe.getRegionCliente());
        asignarAtributo("LABELC", "lblZonaXX", "valor",(dtoe.getZonaCliente() == null) ? "":dtoe.getZonaCliente());
        asignarAtributo("LABELC", "lblSeccionXX", "valor",(dtoe.getSeccionCliente() == null) ? "":dtoe.getSeccionCliente());
        asignarAtributo("LABELC", "lblTerritorioXX", "valor",(dtoe.getTerritorioCliente() == null) ? "":dtoe.getTerritorioCliente());
        asignarAtributo("LABELC", "lblUbigeoXX", "valor",(dtoe.getUbigeoCliente() == null) ? "":dtoe.getUbigeoCliente());        
        
        asignarAtributo("VAR","hcodCliente", "valor",(dtoe.getCodigoCliente() == null) ? "":dtoe.getCodigoCliente().toString());
        
        asignarAtributo("VAR","hoidCliente", "valor",(dtoe.getOidCliente() == null) ? "":dtoe.getOidCliente().toString());
        asignarAtributo("VAR","hoidTipoCliente", "valor",(dtoe.getOidTipoCliente() == null) ? "":dtoe.getOidTipoCliente().toString());
        asignarAtributo("VAR","hoidSubtipocliente", "valor",(dtoe.getOidSubtipocliente() == null) ? "":dtoe.getOidSubtipocliente().toString());
        asignarAtributo("VAR","hoidSubgerenciaventas", "valor",(dtoe.getOidSubgerenciaVentas() == null) ? "":dtoe.getOidSubgerenciaVentas().toString());
        asignarAtributo("VAR","hoidRegion", "valor",(dtoe.getOidRegion() == null) ? "":dtoe.getOidRegion().toString());
        asignarAtributo("VAR","hoidZona", "valor",(dtoe.getOidZona() == null) ? "":dtoe.getOidZona().toString());
        asignarAtributo("VAR","hoidSeccion", "valor",(dtoe.getOidSeccion() == null) ? "":dtoe.getOidSeccion().toString());
        asignarAtributo("VAR","hoidTerritorio", "valor",(dtoe.getOidTerritorio() == null) ? "":dtoe.getOidTerritorio().toString());
    }    
    
    private void mostrarInformacionAdministrativa(DTOInformacionAdministrativaSolicitud dtoe) throws Exception{        
        // Muestra la información administrativa de la solicitud en la capa CapaInformacionAdministrativa 
        asignarAtributo("CTEXTO", "txtConsultoraReferencia", "valor",(dtoe.getConsultoraAsociada() == null) ? "":dtoe.getConsultoraAsociada());
        asignarAtributo("CTEXTO", "txtReceptorFactura", "valor",(dtoe.getReceptorFactura() == null) ? "":dtoe.getReceptorFactura());
        asignarAtributo("CTEXTO", "txtPagadorFactura", "valor",(dtoe.getPagadorFactura() == null) ? "":dtoe.getPagadorFactura());
        asignarAtributo("CTEXTO", "txtNumeroClientes", "valor",((dtoe.getNumeroClientes() == null) ? ""
                                                                 :UtilidadesBelcorp.formateaNumeroSICC(dtoe.getNumeroClientes().toString(),this.FORMATO_DEFAULT,this)) );
        asignarAtributo("LABELC", "lblTipoDocumentoLegalXX", "valor",(dtoe.getTipoDocumentoLegal() == null) ? "":dtoe.getTipoDocumentoLegal());
        asignarAtributo("LABELC", "lblNumeroDocumentoLegalXX", "valor",(dtoe.getNumeroDocumentoLegal() == null) ? "":dtoe.getNumeroDocumentoLegal().toString());
        asignarAtributo("LABELC", "lblIndicadorImpuestosXX", "valor",(dtoe.getIndicadorImpuestos() == null) ? "":dtoe.getIndicadorImpuestos());                        
        
        asignarAtributo("VAR","hcbDestino", "valor",(dtoe.getOidDestino() == null) ? "":dtoe.getOidDestino().toString());        
        asignarAtributo("VAR","hcbTipoDocumentoIdentidad", "valor",(dtoe.getOidTipoDocumentoIdentidad() == null) ? "":dtoe.getOidTipoDocumentoIdentidad().toString());
        asignarAtributo("VAR","hcbFormaPago", "valor",(dtoe.getOidFormaPago() == null) ? "":dtoe.getOidFormaPago().toString());        
        
        asignarAtributo("VAR","hoidTipoDocumentoLegal", "valor",(dtoe.getOidTipoDocumento() == null) ? "":dtoe.getOidTipoDocumento().toString());        
        asignarAtributo("VAR","hoidNroDocumento", "valor",(dtoe.getNumeroDocumentoLegal() == null) ? "":dtoe.getNumeroDocumentoLegal().toString());
        
        asignarAtributo("VAR","hoidConsultora", "valor",(dtoe.getOidConsultoraAsociada() == null) ? "":dtoe.getOidConsultoraAsociada().toString());        
        asignarAtributo("VAR","hoidReceptor", "valor",(dtoe.getOidReceptorFactura() == null) ? "":dtoe.getOidReceptorFactura().toString());        
        asignarAtributo("VAR","hoidPagador", "valor",(dtoe.getOidPagadorFactura() == null) ? "":dtoe.getOidPagadorFactura().toString());        
        
    }    
    
    private void mostrarInformacionEconomica(DTOInformacionEconomicaSolicitud dtoe) throws Exception{        
        // Muestra la información económica de la solicitud en la capa CapaInformacionEconómica 
        asignarAtributo("LABELC", "lblMonedaXX", "valor",(dtoe.getMoneda() == null) ? "":dtoe.getMoneda());
        asignarAtributo("LABELC", "lblMontoDescuento1XX", "valor",(dtoe.getMontoDescuento1() == null) ? "":dtoe.getMontoDescuento1().toString());
        asignarAtributo("LABELC", "lblMontoDescuento2XX", "valor",(dtoe.getMontoDescuento2() == null) ? "":dtoe.getMontoDescuento2().toString());
        asignarAtributo("LABELC", "lblMontoDescuento3XX", "valor",(dtoe.getMontoDescuento3() == null) ? "":dtoe.getMontoDescuento3().toString());
        asignarAtributo("LABELC", "lblFletePagarXX", "valor",(dtoe.getFletePagar() == null) ? "":dtoe.getFletePagar().toString());
        asignarAtributo("LABELC", "lblTotalImpuestosXX", "valor",(dtoe.getTotalImpuestos() == null) ? "":dtoe.getTotalImpuestos().toString());
        
        // inc 12759
        traza ("(dtoe.getTotalPagar()" + dtoe.getTotalPagar());
        
        if ((dtoe.getTotalPagar() == null)|| (dtoe.getTotalPagar().equals(new BigDecimal(0)))){
            asignarAtributo("LABELC", "lblTotalPagarXX", "valor", ""); 
            traza ("CERO");
          }else{
                  traza ("no CERO");
                  asignarAtributo("LABELC", "lblTotalPagarXX", "valor", dtoe.getTotalPagar().toString());   
              }
          
        asignarAtributo("VAR","hoidMoneda", "valor",(dtoe.getOidMoneda() == null) ? "":dtoe.getOidMoneda().toString());
    }    
    
    private void mostrarInformacionEstado(DTOInformacionEstadoSolicitud dtoe) throws Exception{        
        // Muestra la información del estado de la solicitud en la capa CapaInformacionEstado 
        asignarAtributo("CTEXTO", "txtFechaPrevistaFacturacion", "valor",(dtoe.getFechaPrevistaFacturacion() == null) ? "":obtenerFechaFormatoPais(dtoe.getFechaPrevistaFacturacion()));
        asignarAtributo("LABELC", "lblFechaFacturacionXX", "valor",(dtoe.getFechaFacturacion() == null) ? "":obtenerFechaFormatoPais(dtoe.getFechaFacturacion()));
        //Incidencia BELC300023759 pzerbino 2/8/2006
		//asignarAtributo("LABELC", "lblEstadoCreditoXX", "valor",(dtoe.getEstadoCredito() == null) ? "":dtoe.getEstadoCredito());
		asignarAtributo("LABELC", "lblEstadoCreditoXX", "valor",(dtoe.getDescripcionEstado() == null) ? "":dtoe.getDescripcionEstado());
        asignarAtributo("LABELC", "lblGrupoProcesosXX", "valor",(dtoe.getGrupoProcesos() == null) ? "":dtoe.getGrupoProcesos());
        asignarAtributo("LABELC", "lblProcesoValidacionXX", "valor",(dtoe.getProcesoValidacion() == null) ? "":dtoe.getProcesoValidacion());
        asignarAtributo("LABELC", "lblEstadoSolicitudXX", "valor",(dtoe.getEstadoSolicitud() == null) ? "":dtoe.getEstadoSolicitud());        

        asignarAtributo("VAR","hoidEstadoSolicitud", "valor",(dtoe.getOidEstadoSolicitud() == null) ? "":dtoe.getOidEstadoSolicitud().toString());
        asignarAtributo("VAR","hoidGrupoProcesos", "valor",(dtoe.getOidGrupoProcesos() == null) ? "":dtoe.getOidGrupoProcesos().toString());        
    }        
    private void buscarSolicitudConsulta() throws Exception{
      /*
        Activar LPBuscarSolicitud con 
      - accion = "" 
      - operacion = "Consultar"
       */
        conectorAction("LPBuscarSolicitud");
        conectorParametroSesion("casoDeUso","consultar");
        conectorActionParametro("operacion","consultar");
        conectorActionParametro("accion","");
    }
    
    private void buscarSolicitudModificacion() throws Exception{
      /*
        Activar LPBuscarSolicitud con 
      - accion = "" 
      - operacion = "Modificar"  
       */    
        conectorAction("LPBuscarSolicitud");
        conectorParametroSesion("casoDeUso","modificar");
        conectorActionParametro("operacion","modificar");
        conectorActionParametro("accion","");        
    }    
    
    private void modificarSolicitud() throws Exception{
      // Recupera la información editable de la solicitud y la actualiza
      // Crea un DTOCabeceraSolicitud
      DTOCabeceraSolicitud dtocabesoli = crearDTOCabeceraSolicitud(); 
      //Creo un idBusiness = "PEDModificarCabeceraSolicitud" 
      MareBusinessID id = new MareBusinessID("PEDModificarCabeceraSolicitud");
      Vector vec = new Vector();
      vec.add(dtocabesoli);
      vec.add(id);
      // Actualiza la cabecera
      //Invoco a ConectorGrabarSolicitudDigitacion 
      traza("antes de conectar ConectorGrabarSolicitudDigitacion");
      pagina("salidaGenerica");
      asignarAtributo("VAR", "ejecutarError", "valor", "quitaOculto()");
      DruidaConector conectorSalida = conectar("ConectorGrabarSolicitudDigitacion",vec);        
      asignarAtributo("VAR","hcerrar","valor","S");
    }  
    
    private void modificarPosiciones() throws Exception{
      // Recupera la información  de la solicitud
      // Crea un DTOCabeceraSolicitud
      traza("modificarPosiciones"+conectorParametro("oidCabeceraSolicitud"));
      DTOCabeceraSolicitud dtocabesoli = crearDTOCabeceraSolicitud();       
      conectorAction("LPModificarPosiciones");
      conectorParametroSesion("DTOCabeceraSolicitud",dtocabesoli);
      conectorActionParametro("oidCabeceraSolicitud",conectorParametro("oidCabeceraSolicitud"));
      conectorParametroSesion("casoDeUso","");
      conectorActionParametro("accion","");
      
    }      

    private DTOCabeceraSolicitud crearDTOCabeceraSolicitud() throws Exception{
      // Crea un DTOCabeceraSolicitud con la información editable de la solicitud
      String oidCabeceraSolicitud = conectorParametro("hoidCabeceraSolicitud");
      String accesoFisico = conectorParametro("cbAccesoFisico");
      String tipoDespacho = conectorParametro("cbTipoDespacho");      
      String receptorFactura = conectorParametro("txtReceptorFactura");
      String pagadorFactura = conectorParametro("txtPagadorFactura");
      Integer numeroClientes = (conectorParametroNumero("txtNumeroClientes", this.FORMATO_DEFAULT)==null || conectorParametroNumero("txtNumeroClientes", this.FORMATO_DEFAULT).equals(""))?null:Integer.valueOf(conectorParametroNumero("txtNumeroClientes", this.FORMATO_DEFAULT));
      String destino = conectorParametro("cbDestino");
      String tipoDocumento = conectorParametro("cbTipoDocumentoIdentidad");
      String formaPago = conectorParametro("cbFormaPago");
      String fechaPrevistaFacturacion = conectorParametro("txtFechaPrevistaFacturacion");
      String oidTipoSolicitud = conectorParametro("hoidTipoSolicitud");
      String oidProceso = conectorParametro("hoidProceso");
      String codCliente = conectorParametro("hcodCliente");
      String oidSubacceso = conectorParametro("hoidSubacceso");
      String oidMarca = conectorParametro("hoidMarca");
      String oidCanal = conectorParametro("hoidCanal");
      String oidPeriodo = conectorParametro("hoidPeriodo");
      String oidAcceso = conectorParametro("hoidAcceso");    
      String oidTipoCliente = conectorParametro("hoidTipoCliente");
      String oidSubtipocliente = conectorParametro("hoidSubtipocliente");
      String oidSubgerenciaventas = conectorParametro("hoidSubgerenciaventas");
      String oidRegion = conectorParametro("hoidRegion");
      String oidZona = conectorParametro("hoidZona");
      String oidSeccion = conectorParametro("hoidSeccion");
      String oidTerritorio = conectorParametro("hoidTerritorio");
      String oidTipoDocumentoLegal = conectorParametro("hoidTipoDocumentoLegal");
      String oidNroDocumento = conectorParametro("hoidNroDocumento");
      String oidMoneda = conectorParametro("hoidMoneda");
      String oidEstadoSolicitud = conectorParametro("hoidEstadoSolicitud");
      String oidGrupoProcesos = conectorParametro("hoidGrupoProcesos");      
      String nroSolicitud = conectorParametro("hnroSolicitud"); 
      String oidCliente = conectorParametro("hoidCliente"); 
      
      String oidPagador = conectorParametro("hoidPagador"); 
      String oidReceptor = conectorParametro("hoidReceptor"); 
      String oidConsultoraAsociada = conectorParametro("hoidConsultora");
      
      traza("oidConsultoraAsociada"+oidConsultoraAsociada);
      
      DTOCabeceraSolicitud dtocabesoli = new DTOCabeceraSolicitud();
      dtocabesoli.setOidCabeceraSolicitud((oidCabeceraSolicitud!=null&&(!oidCabeceraSolicitud.equals("")))?new Long(oidCabeceraSolicitud):null);
      dtocabesoli.setAccesoFisico((accesoFisico!=null&&(!accesoFisico.equals("")))?new Long(accesoFisico):null);
      dtocabesoli.setTipoDespacho((tipoDespacho!=null&&(!tipoDespacho.equals("")))?new Long(tipoDespacho):null);
      dtocabesoli.setConsultoraAsociada((oidConsultoraAsociada!=null&&(!oidConsultoraAsociada.equals("")))?new Long(oidConsultoraAsociada):null);
      dtocabesoli.setReceptorFactura((receptorFactura!=null&&(!receptorFactura.equals("")))?receptorFactura:null);
      dtocabesoli.setOidReceptorFactura((oidReceptor!=null&&(!oidReceptor.equals("")))?new Long(oidReceptor):null);
      dtocabesoli.setPagadorFactura((pagadorFactura!=null&&(!pagadorFactura.equals("")))?pagadorFactura:null);
      dtocabesoli.setOidPagadorFactura((oidPagador!=null&&(!oidPagador.equals("")))?new Long(oidPagador):null);
      dtocabesoli.setDestino((destino!=null&&(!destino.equals("")))?new Long(destino):null);
      dtocabesoli.setTipoDocumento((tipoDocumento!=null&&(!tipoDocumento.equals("")))?new Long(tipoDocumento):null);
      dtocabesoli.setFormaPago((formaPago!=null&&(!formaPago.equals("")))?new Long(formaPago):null);
      dtocabesoli.setFechaPrevistaFacturacion((fechaPrevistaFacturacion!=null)?obtenerFechaFormatoDate(fechaPrevistaFacturacion):null);
      dtocabesoli.setTipoSolicitud((oidTipoSolicitud!=null&&(!oidTipoSolicitud.equals("")))?new Long(oidTipoSolicitud):null);
      dtocabesoli.setOidPais(pais);
      dtocabesoli.setOidIdioma(idioma);
      dtocabesoli.setProceso((oidProceso!=null&&(!oidProceso.equals("")))?new Long(oidProceso):null);
      dtocabesoli.setCliente(codCliente);            
      
      dtocabesoli.setNumeroClientes(numeroClientes);      
      dtocabesoli.setOidCliente((oidCliente!=null&&(!oidCliente.equals("")))?new Long(oidCliente):null);            
      dtocabesoli.setNumeroSolicitud(nroSolicitud);
      dtocabesoli.setSubacceso((oidSubacceso!=null&&(!oidSubacceso.equals("")))?new Long(oidSubacceso):null);
      dtocabesoli.setMarca((oidMarca!=null&&(!oidMarca.equals("")))?new Long(oidMarca):null);
      dtocabesoli.setCanal((oidCanal!=null&&(!oidCanal.equals("")))?new Long(oidCanal):null);
      dtocabesoli.setPeriodo((oidPeriodo!=null&&(!oidPeriodo.equals("")))?new Long(oidPeriodo):null);
      dtocabesoli.setAcceso((oidAcceso!=null&&(!oidAcceso.equals("")))?new Long(oidAcceso):null);      
      dtocabesoli.setTipoCliente((oidTipoCliente!=null&&(!oidTipoCliente.equals("")))?new Long(oidTipoCliente):null);
      dtocabesoli.setSubtipoCliente((oidSubtipocliente!=null&&(!oidSubtipocliente.equals("")))?new Long(oidSubtipocliente):null);
      dtocabesoli.setSubgerencia((oidSubgerenciaventas!=null&&(!oidSubgerenciaventas.equals("")))?new Long(oidSubgerenciaventas):null);
      dtocabesoli.setRegion((oidRegion!=null&&(!oidRegion.equals("")))?new Long(oidRegion):null);
      dtocabesoli.setZona((oidZona!=null&&(!oidZona.equals("")))?new Long(oidZona):null);
      dtocabesoli.setSeccion((oidSeccion!=null&&(!oidSeccion.equals("")))?new Long(oidSeccion):null);
      dtocabesoli.setTerritorio((oidTerritorio!=null&&(!oidTerritorio.equals("")))?new Long(oidTerritorio):null);      
      dtocabesoli.setTipoDocumentoLegal((oidTipoDocumentoLegal!=null&&(!oidTipoDocumentoLegal.equals("")))?new Long(oidTipoDocumentoLegal):null);
      dtocabesoli.setNumeroDocumentoOrigen((oidNroDocumento!=null&&(!oidNroDocumento.equals("")))?new Long(oidNroDocumento):null);
      dtocabesoli.setMoneda((oidMoneda!=null&&(!oidMoneda.equals("")))?new Long(oidMoneda):null);
      dtocabesoli.setEstado((oidEstadoSolicitud!=null&&(!oidEstadoSolicitud.equals("")))?new Long(oidEstadoSolicitud):null);
      dtocabesoli.setGrupoProcesos((oidGrupoProcesos!=null&&(!oidGrupoProcesos.equals("")))?new Long(oidGrupoProcesos):null);     
      dtocabesoli.setFecha(new Date(System.currentTimeMillis()));
      
      traza("dtocabesoli"+dtocabesoli);
      
      return dtocabesoli;
    }  
    
    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       09/01/2005
     * @version     3.3
     * @autor       Emilio Noziglia
     * Descripcion: Detalles de la implementación en el cuerpo del método.
     */
    private void modificarCodigo() throws Exception{
      traza("### Entro a modificarCodigo ###");            
      // idBusiness= "MAEBusquedaRapidaClientes" 
      MareBusinessID idBusiness = new MareBusinessID("MAEBusquedaRapidaCliente");
      // Creamos un DTOBusquedaRapidaClientes y lo rellenamos con: 
      // - pais 
      // - idioma 
      // - cod cliente
      DTOBusquedaRapidaCliente dto = new DTOBusquedaRapidaCliente();
      dto.setIndicadorSituacion(new Long(0));
      dto.setTamanioPagina(new Integer(1));
      dto.setOidPais(pais);
      dto.setOidIdioma(idioma);
  
      String codigoCliente = new String();
      String indBusquedaCodigo = conectorParametroLimpia("hIndicadorBusquedaCliente", "", true);
      if (indBusquedaCodigo.equals("C"))  {
        codigoCliente = conectorParametroLimpia("txtConsultoraReferencia", "", true);
      } else if (indBusquedaCodigo.equals("R"))  {
        codigoCliente = conectorParametroLimpia("txtReceptorFactura", "", true);
      } else if (indBusquedaCodigo.equals("P"))  {
        codigoCliente = conectorParametroLimpia("txtPagadorFactura", "", true);
      }
      pagina("salidaGenerica");
      asignarAtributo("VAR", "ejecutarError", "valor", "errorCodigoBusqueda('" + indBusquedaCodigo + "')");
      traza("Código de cliente capturado: " + codigoCliente);
      traza("capturado: " + indBusquedaCodigo);      
      dto.setCodigoCliente(codigoCliente);		
      // Llamamos al ConectorBusquedaRapidaCliente con el dto creado. 
      Vector parametros = new Vector();
      parametros.add(dto);
      parametros.add(idBusiness);
      traza("Conectando a ConectorBusquedaRapidaCliente... ");
      DruidaConector conector = conectar("ConectorBusquedaRapidaCliente", parametros);
      traza("Conectó.");
      // Recibe un DTOSalida (con un registro) 
      DTOSalida dtoRetornado = (DTOSalida)conector.objeto("DTOSalida");
      RecordSet retorno = dtoRetornado.getResultado();
      traza("Retornó: ");
      traza(" - OID: " + (BigDecimal)retorno.getValueAt(0, "OID"));
      traza(" - COD_CLIE: " + (String)retorno.getValueAt(0, "COD_CLIE"));
      traza(" - VAL_NOM1: " + (String)retorno.getValueAt(0, "VAL_NOM1"));
      traza(" - VAL_APE1: " + (String)retorno.getValueAt(0, "VAL_APE1"));		
  
      String oidCliente = ((BigDecimal)retorno.getValueAt(0, "OID")).toString();
      
      String funcion = new String("asignarDatosCliente('" + oidCliente + "','" + indBusquedaCodigo + "')");
  
      traza("Funcion a ejecutar: " + funcion);
      
      asignarAtributo("VAR", "ejecutar", "valor", funcion);
      asignarAtributo("VAR", "cerrarVentana", "valor", "0"); 
      traza("PASO");
    }    
    //------------------------------METODOS DE APOYO--------------------------------

    private void cargarInformes() throws Exception{
      traza("==============>  ENTRA A cargarInformes()");
      this.pagina("contenido_reportes_faltantes");
      this.getFormatosValidaciones();
      asignarAtributoPagina("cod","00611");
      getConfiguracionMenu();
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
     * Retorna string fecha en formato YYYY-MM-DD, tal como lo maneja Date.
     * Recibe el string fecha en formato en el formato del pais. 
     */
    private Timestamp obtenerFechaFormatoDate(String fecha) throws Exception {
        // obtenemos el formato de fecha segun el pais
        // String formatoFecha = conectorParametro("hFormatoFechaPais");
        String formatoFecha = UtilidadesSession.getFormatoFecha(this);
        // aseguro el indicador de mes a mayuscula  
        formatoFecha = formatoFecha.replace('m','M');
        //trabajamos con el formato del pais
        SimpleDateFormat formatoPais = new SimpleDateFormat(formatoFecha);
        //formateamos la fecha segun el formato Date yyyy-mmm-dd
        Timestamp fechaFormatoDate = new Timestamp(formatoPais.parse(fecha).getTime());
        //retorna la fecha formateada
        return fechaFormatoDate;
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
    private String obtenerHoraActual() throws Exception {
      // obtenemos el formato de fecha actual segun el pais
      Date hora = new Date(System.currentTimeMillis());
      String formatoHora = null;
         formatoHora = new String("hh:mm:ss");
      // aseguro el indicador de mes a mayuscula  

      //trabajamos con el formato del pais
      SimpleDateFormat formatoPais = new SimpleDateFormat(formatoHora);
      //formateamos la fecha segun el formato del pais
      String horaFormatoPaisStr = null;
      if (hora != null){
         horaFormatoPaisStr = formatoPais.format(hora);
      }
      //retorna la fecha formateada    
      return horaFormatoPaisStr;
    }
    //------------------------------METODOS DE APOYO--------------------------------
}

