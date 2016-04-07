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
 
import es.indra.druida.DruidaConector;  
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.cob.DTOGestionDeCobranza;
import java.lang.reflect.InvocationTargetException;
import com.evermind.server.rmi.OrionRemoteException;

import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import java.math.BigDecimal;

/*Imports para el uso del subsistema GestorCargaPantalla */
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

public class LPTratarPendientesGestion extends LPSICCBase{
    private Long lIdioma = null;
    private Long lPais = null;
 
    public LPTratarPendientesGestion(){
    }
    
    public void inicio()throws Exception {
        pagina("contenido_pendientes_gestion_tratar");
    }
    
    public void ejecucion()throws Exception {
        String sAccion = null;
        setTrazaFichero();
        traza("+++++++++++ Inicializando LPTratarPendientesGestion +++++++++++++++");
        try{
            sAccion = conectorParametro("accion")==null?"":conectorParametro("accion");
            traza("Accion: "+sAccion);
            lPais = UtilidadesSession.getPais(this);
            lIdioma = UtilidadesSession.getIdioma(this);
            traza("+++++++++++ Idioma:  " + lIdioma);
            traza("+++++++++++ Pais:    " + lPais);
            asignarAtributo("VAR","oidPais","valor",lPais.toString());
            
//Si (accion == "") entonces 
//-> ejecutar el método privado "cargarPagina()" 
//Si no Si (accion == "detalle") entonces 
//-> ejecutar el método privado "detalle()" 
//Si no Si (accion == "gestionar") entonces 
//-> ejecutar el método privado "gestionar()" 
//Si no Si (accion == "asignar") entonces 
//-> ejecutar el método privado "asignar()" 
//Si no Si (accion == "historicoGestion") entonces 
//-> ejecutar el método privado "historicoGestion()" 
//Si no Si (accion == "compromisoPago") entonces 
//-> ejecutar el método privado "compromisoPago()" 

            if (sAccion.equals("")) 
                cargarPagina();
            else if (sAccion.equals("detalle"))
                detalle();
            else if (sAccion.equals("gestionar"))
                gestionar();
            else if (sAccion.equals("asignar"))
                asignar();
            else if (sAccion.equals("historicoGestion"))
                historicoGestion();
            else if (sAccion.equals("compromisoPago"))
                compromisoPago();
            else if (sAccion.equals("guardarGestion"))
                guardarGestion();
            else if( sAccion.equals("validarCliente") )
				this.validarCliente();    
            
         }catch(Exception ex) {
             logStackTrace(ex);
             this.lanzarPaginaError(ex);
             
         }
     }
 
     private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        if (e instanceof MareException) {
          MareException e2=(MareException)e;
          traza("Es una mare Exception con codigo de error: "+e2.getCode());
        }
        /*=============*/
        if (e instanceof InvocationTargetException){
            if (((InvocationTargetException)e).getTargetException() instanceof MareException) {
                MareException me = (MareException) ((InvocationTargetException)e).getTargetException();
                traza("el codigo del getCode es");
                traza(me.getCode() + "");
                asignarAtributo("VAR","errCodigo", "valor", "" + me.getCode() );
                asignarAtributo("VAR","errDescripcion", "valor", "Error: " + me.getCode()) ;
            }else{
                    traza("estoy entrando por otra excepcion");
                    asignarAtributo("VAR","errCodigo", "valor", "" + e.getMessage() );
                    asignarAtributo("VAR","errDescripcion", "valor", "Error: " + e.getMessage());
            }
        }else {
            traza("final");
            asignarAtributo("VAR","errCodigo", "valor", "" + e.getMessage() );
            asignarAtributo("VAR","errDescripcion", "valor", "Error: " + e.getMessage());
        }
        
        /*=============*/
        e.printStackTrace(out);
        traza("stack Trace : " +  pila.toString());
        traza("exception: " + e);
     }
     
     
    private void recargaPostError(Exception ex) throws Exception {
        traza("metodo recargaPostError");
        // si no es Error peticion de datos no existente, reinicia la simulacion.
        if (ex instanceof InvocationTargetException){
            if (((InvocationTargetException)ex).getTargetException() instanceof MareException) {
                MareException me = (MareException) ((InvocationTargetException)ex).getTargetException();
                traza("el codigo del getCode es");
                traza(me.getCode() + "");
                asignarAtributo("VAR","errCodigo", "valor", "" + me.getCode() );
                asignarAtributo("VAR","errDescripcion", "valor", "Error: " + me.getCode()) ;
            }else{
                if (((InvocationTargetException)ex).getTargetException() instanceof OrionRemoteException) {
                    OrionRemoteException me = (OrionRemoteException) ((InvocationTargetException)ex).getTargetException();
                    traza(me.detail + "");
                    asignarAtributo("VAR","errCodigo", "valor", "" + me.detail );
                    asignarAtributo("VAR","errDescripcion", "valor", "Error: " + me.detail);
                }else {
                    traza("estoy entrando por otra excepcion");
                    asignarAtributo("VAR","errCodigo", "valor", "" + ex.getMessage() );
                    asignarAtributo("VAR","errDescripcion", "valor", "Error: " + ex.getMessage());
                }
            }
        }else {
            traza("final");
            asignarAtributo("VAR","errCodigo", "valor", "" + ex.getMessage() );
            asignarAtributo("VAR","errDescripcion", "valor", "Error: " + ex.getMessage());
        }
    }

    
    
    private void obtenerEstadoInicial()
    {
    }
    
    private void inicioSimulacion()
    {
    }
    
    
    private void cargarPagina()throws Exception {
// Crear un DTOBelcorp con pais e idioma de la sesión 
// Llamar al subsistema "GestorCargaPantalla" con los siguientes datos: 
//- idBusiness = "COBObtenerUsuariosCobCombo" y el DTOBelcorp => llena el combo "usuarioCobranza" 
//-idBusiness = "SEGConsultaCanales" y el DTOBelcorp => llena el combo de "Canal" 
//-idBusiness = "SEGConsultaMarcas" => se llena el combo de "Marca"
traza("Entrando a cargarPagina" );
        DTOBelcorp dtoB = new DTOBelcorp();
        dtoB.setOidIdioma(lIdioma);
        dtoB.setOidPais(lPais); 
        // Combos de marca y canal
        cargarMarcaCanalUsuarios(dtoB);
        asignarAtributoPagina("cod","0306");
        getConfiguracionMenu("LPTratarPendientesGestion","");
        
        // Longitud del Codigo de cliente
		asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
		traza("LongitudCodigoCliente: " + this.obtenerLongitudCodigoCliente().toString());
        
traza("Saliendo de cargarPagina" );
    }
 
    private void gestionar()throws Exception {
//1. Recuperar el oid del registro seleccionado en la lista editable de la ventana llamante 
//2. Asignar la pantalla de la ventana "Contenido_pendientes_gestion_tratar_2" 
//3. Asignar el oid a la variable oculta oidGestionDeCobranza 
//4. Mostrar página 
        String sOidSel = conectorParametro("oidRegistroSel")==null?"":conectorParametro("oidRegistroSel");
        
traza("Registro Sel:  " + sOidSel);        
        pagina("contenido_pendientes_gestion_tratar_2");
        asignarAtributoPagina("cod","0306");
        getConfiguracionMenu("LPTratarPendientesGestion","gestionar");
        asignarAtributo("VAR","oidGestionDeCobranza","valor",sOidSel);
    }
    
    private void guardarGestion()throws Exception {
//->Crear un DTOGestionDeCobranza con: 
//=> oid , get(oid) 
//=> observaciones, get(observaciones) 
//=> Se crea el IDBusiness = COBGuardarGestion 
//=> Asignar el conector ConectorGuardarGestion con IDBusiness y DTOGestionDeCobranza
traza("Entrando a guardarGestion");
    pagina("salidaGenerica");	/*Envio oculto!*/
        String sOidSel = conectorParametro("oidGestionDeCobranza")==null?"":conectorParametro("oidGestionDeCobranza");
        String sObservacion = conectorParametro("hObservacion")==null?"":conectorParametro("hObservacion");

traza("OID: "+ sOidSel);
traza("Observacion:   "+ sObservacion);

        DTOGestionDeCobranza dtoG = new DTOGestionDeCobranza();
        dtoG.setOidIdioma(lIdioma);
        dtoG.setOidPais(lPais);
        dtoG.setOid(new Long(sOidSel));
        dtoG.setObservaciones(sObservacion);
        
        MareBusinessID id = new MareBusinessID("COBGuardarGestion");
        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoG);
        paramEntrada.add(id);
        traza("antes de ConectorGuardarGestion");
        DruidaConector conector = conectar("ConectorGuardarGestion", paramEntrada);
        traza("despues de ConectorGuardarGestion");
        
        asignarAtributo("VAR","ejecutar","valor","accionExitosa()");
        asignarAtributo("VAR","ejecutarError","valor","accionError()");
    }
    
    private void detalle()throws Exception {
// 1. Recuperar el oid del registro seleccionado en la lista editable de la ventana llamante 
// 2. Crear un DTOOID con el oidGestionCobranza seleccionado 
// 3. Crear idBusiness = "COBDetalleGestion" 
// 4. Asignar el conector ConectorDetalleGestion con IDBusiness y DTOOID 
// 5. Asignar página "contenido_seguimiento_telecobranza_realizar_detalle" 
        String sOidSel = conectorParametro("oidRegistroSel")==null?"":conectorParametro("oidRegistroSel");
traza("Registro Sel:  " + sOidSel);
        DTOOID dto = new DTOOID();
        dto.setOidIdioma(lIdioma);
        dto.setOidPais(lPais);
        
        dto.setOid(new Long(sOidSel));
        
        MareBusinessID id = new MareBusinessID("COBDetalleGestion");
        Vector paramEntrada = new Vector();
        paramEntrada.add(dto);
        paramEntrada.add(id);
        traza("antes de ConectorDetalleGestion");
        
        pagina("contenido_seguimiento_telecobranza_realizar_detalle");
        asignarAtributoPagina("cod","0281");
        getConfiguracionMenu("LPTratarPendientesGestion","detalle");
        
        DruidaConector conector = conectar("ConectorDetalleGestion", paramEntrada);
        traza("despues de ConectorDetalleGestion");
        DTOGestionDeCobranza dtoGC = (DTOGestionDeCobranza) conector.objeto("dtoSalida");
traza(" dtoGC:    " + dtoGC);
        if (dtoGC != null)
        {
            vAsignaValoresPantalla(dtoGC);
            asignarAtributo("VAR","oidGestionCobranza","valor",sOidSel);
        }
    }
    
    private void asignar()throws Exception {
//->Poner en sesion el codigoCliente
//->Llamar a la LPReasignarCarteraConsultora  con accion ="activacionExterna" 
/*
        String sCodigoCliente = conectorParametro("codigoCliente")==null?"":conectorParametro("codigoCliente");
        conectorParametroSesion("codigoCliente", sCodigoCliente);
        traza("asignar - Poniendo en sesion CodigoCliente:  " + sCodigoCliente);
        
        conectorAction("LPReasignarCarteraConsultoras");
        conectorActionParametro("accion","activacionExterna");*/
    }   
    
    private void historicoGestion()throws Exception {
//->Poner en sesion el codigoCliente
//-> Llamar a la LPConsultaHistoricoCobranza con accion ="clienteSeleccionado" 

/*  GDMARZI - Indica que se debe mostrar en ventana modal
        String sCodigoCliente = conectorParametro("codigoCliente")==null?"":conectorParametro("codigoCliente");
        conectorParametroSesion("codigoCliente", sCodigoCliente);
traza("historicoGestion- Poniendo en sesion CodigoCliente:  " + sCodigoCliente);
        conectorAction("LPConsultarHistoricoCobranza");        
        conectorActionParametro("accion","clienteSeleccionado");
        */
    }
    
    private void compromisoPago()throws Exception {
    
//1. Recuperar el oid del registro seleccionado en la lista editable de la ventana llamante
//2. Asignar página "contenido_seguimiento_telecobranza_realizar_compromiso_pago"
//3. Setear hidden "oidGestionCobranza" con el oidGestionCobranza seleccionado en la página
//asignada de   
        String sOidSel = conectorParametro("oidRegistroSel")==null?"":conectorParametro("oidRegistroSel");
        traza("Registro Sel:  " + sOidSel);
        pagina("contenido_seguimiento_telecobranza_realizar_compromiso_pago");
        
        asignarAtributo("VAR","oidGestionCobranza","valor",sOidSel);
        asignarAtributo("VAR","oidIdioma","valor",lIdioma.toString());
        asignarAtributo("VAR","oidPais","valor",lPais.toString());
        
        asignarAtributoPagina("cod","0306");
        getConfiguracionMenu("LPTratarPendientesGestion","detalle");
    }
    
        /*=================Uso del subsistema GestorCargaPantalla==================*/
    private void cargarMarcaCanalUsuarios(DTOBelcorp dtoBel) throws Exception{
        //Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosEntradaMarcaCanal(dtoBel);
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
		//Cargamos los combos con los resultados
		asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
		asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
        asignar("COMBO", "cbUsuarioCobranza", resultados, "COBObtenerUsuariosCobCombo");

        traza(">>>>>>>> Salio de cargarMarcaCanalUsuarios");
    }
    
     private ComposerViewElementList crearParametrosEntradaMarcaCanal(DTOBelcorp dtoBel){
        
		ComposerViewElementList lista = new ComposerViewElementList();
		//Combo Marca
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("SEGConsultaMarcas");
		//Combo Canal
		ComposerViewElement ci2 = new ComposerViewElement();
		ci2.setIDBusiness("SEGConsultaCanales");
		ci2.setDTOE(dtoBel);
        //Combo Usuarios
        ComposerViewElement ci3 = new ComposerViewElement();
		ci3.setIDBusiness("COBObtenerUsuariosCobCombo");
        ci3.setDTOE(dtoBel);

		lista.addViewElement(ci1);
		lista.addViewElement(ci2);
        lista.addViewElement(ci3);
        
		return lista;
	}
    
    private void vAsignaValoresPantalla(DTOGestionDeCobranza dtoGC) throws Exception{
traza("Entrando a vAsignaValoresPantalla" );
        if (dtoGC != null )
        {
            vAsignaValor("lbldtUsuarioCobranza", dtoGC.getUsuarioCobranza());
            vAsignaValor("lbldtEtapaDeuda", dtoGC.getEtapaDeuda());
            vAsignaValor("lbldtMarca", dtoGC.getMarca());
            vAsignaValor("lbldtCanal", dtoGC.getCanal());
            vAsignaValor("lbldtCodigoPeriodo", dtoGC.getPeriodo());
            vAsignaValor("lbldtTipoCargo", dtoGC.getTipoCargo());
            vAsignaValor("lbldtSubgerenciaVenta", dtoGC.getSubgerenciaVentas());
            vAsignaValor("lbldtRegion", dtoGC.getRegion());
            vAsignaValor("lbldtZona", dtoGC.getZona());
            vAsignaValor("lbldtSeccion", dtoGC.getSeccion());
            vAsignaValor("lbldtTerritorio", dtoGC.getTerritorio());
            vAsignaValor("lbldtCodigoCliente", dtoGC.getCodigoCliente());
            vAsignaValor("lbldtNombre", dtoGC.getNombre());
            vAsignaValor("lbldtApellidos", dtoGC.getApellidos());
            vAsignaValor("lbldtAccion", dtoGC.getAccion());
            if (dtoGC.getFechaSeguimiento()!= null)
                vAsignaValor("lbldtFechaSeguimiento", dtoGC.getFechaSeguimiento().toString());
            vAsignaValor("lbldtHoraSeguimiento", dtoGC.getHoraSeguimiento());
            if (dtoGC.getCodCompromisoPago() != null)
                vAsignaValor("lbldtCodigoCompromisoPago", dtoGC.getCodCompromisoPago().toString());
            if (dtoGC.getFechaReprogramacion() != null)
                vAsignaValor("lbldtFechaReprogramacion", dtoGC.getFechaReprogramacion().toString());
            vAsignaValor("lbldtHoraReprogramacion", dtoGC.getHoraReprogramacion());
            vAsignaValorHidden("hDtAportaPrueba", obtenerValor(dtoGC.getAportaPrueba()));
            vAsignaValor("lbldtDescripcionPrueba", dtoGC.getDescripcionPrueba());
            vAsignaValor("lbldtNumeroDocumentoSoporte", dtoGC.getNumeroDocSoporte());
            vAsignaValor("lbldtTipoDocumentoPago", dtoGC.getTipoDocPago());
            vAsignaValor("lbldtBanco", dtoGC.getCodigoBanco());
            vAsignaValor("lbldtSucursal", dtoGC.getCodigoSucursal());
            vAsignaValor("lbldtNuevaDirreccion", dtoGC.getNuevaDireccion());
            vAsignaValor("lbldtNuevoTelefono", dtoGC.getNuevoTelefono());
            vAsignaValorHidden("hDtPasaAdministrador", obtenerValor(dtoGC.getPasaAdministrador()));
            vAsignaValorHidden("hDtPeticionBloqueoAdministrativo", obtenerValor(dtoGC.getPeticionBloqueoAdmin()));
            vAsignaValorHidden("hDdtPeticionDesBloqueoAdministrativo", obtenerValor(dtoGC.getPeticionDesbloqueoAdmin()));
            vAsignaValorHidden("hDdtVisadoAdministrativo", obtenerValor(dtoGC.getVisadoAdministrador()));
            vAsignaValorHidden("hDtMarcaComisionCalculada", obtenerValor(dtoGC.getMarcaComisionCalculada()));
            vAsignaValor("lbldtMotivoNoCobro", dtoGC.getMotivoNoCobro());
            vAsignaValor("lbldtObservaciones", dtoGC.getObservaciones());;
        }
traza("Saliendo de vAsignaValoresPantalla" );
    }
    
    private void vAsignaValor(String sLabel, String sValor) throws Exception{
        asignarAtributo("LABELC", sLabel, "valor", (sValor==null? "": sValor));    
    }
    
    private void vAsignaValor(String sLabel, Long lValor) throws Exception{
    if (lValor != null)
            asignarAtributo("LABELC", sLabel, "valor", (lValor.toString()==null? "": lValor.toString()));    
    }

	private void vAsignaValorHidden(String nombre, String lValor) throws Exception{
        if (lValor != null)
            asignarAtributo("VAR", nombre, "valor", lValor);    
    }

    private String obtenerValor(Boolean bool) throws Exception{
        if (bool != null) {
            if(bool.booleanValue()) {
                return "S";
			} else if(!bool.booleanValue()) {
                return "N";
			}
        } if (bool == null) {
			traza("retorna nulo");
			return "";
		}

		return "";
	}
    
    
    /*------------------------------------------------------------------------*/
    /*                  VALIDACIONES DEL CODIGO DE CLIENTE                    */
    /*------------------------------------------------------------------------*/
    private void validarCliente() throws Exception{
		traza("metodo validarCliente");
		pagina("salidaGenerica");

		try	{
				
			String codigoCliente = conectorParametroLimpia("txtCodigoCliente", "", true);

			// idBusiness= "MAEBusquedaRapidaClientes" 
			MareBusinessID idBusiness = new MareBusinessID("MAEBusquedaRapidaCliente");
			// Creamos un DTOBusquedaRapidaClientes y lo rellenamos con: 
			// - pais 
			// - idioma 
			// - codigoCliente: Valor introducido en txtCliente 
			DTOBusquedaRapidaCliente dto = new DTOBusquedaRapidaCliente();
			dto.setIndicadorSituacion(new Long(0));
			dto.setTamanioPagina(new Integer(1));
			dto.setOidPais(UtilidadesSession.getPais(this));
			dto.setOidIdioma(UtilidadesSession.getIdioma(this));

			dto.setCodigoCliente(codigoCliente);
			traza("Código de cliente: " + codigoCliente);

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
			traza(" - COD_CLIE: " + (String)retorno.getValueAt(0, "COD_CLIE"));
            String codCliente = (String)retorno.getValueAt(0, "COD_CLIE");
            
			String funcion = new String("asignarDatosCliente('" + codCliente + "')");
			traza("Funcion a ejecutar: " + funcion);
			asignarAtributo("VAR", "ejecutar", "valor", funcion);
		}catch (Exception e){   

		   asignarAtributo("VAR", "ejecutarError", "valor", "errorCliente()");
		   throw e;
		}
	}
        
}
