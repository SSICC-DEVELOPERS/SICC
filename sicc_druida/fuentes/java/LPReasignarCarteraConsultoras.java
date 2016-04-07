import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import java.math.BigDecimal;
import java.util.Vector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.cob.DTOAsignacionesCobranza;



public class LPReasignarCarteraConsultoras extends LPSICCBase {

  private String accion = null;  
  private String pais = null;
  private String idioma = null;
  private String formatoFechaPais = null;
  
  
  public LPReasignarCarteraConsultoras() {	
      super();	
  }


  public void inicio() throws Exception {	
    pagina("contenido_cartera_consultoras_reasignar");
    getFormatosValidaciones();
  }
  
  
  
  public void ejecucion() throws Exception {
      setTrazaFichero();
      accion     	= conectorParametroLimpia("accion", "", true);
      traza("accion>>>> " + accion);
      pais 	  	= UtilidadesSession.getPais(this).toString();
      traza("pais >>>>  "  +pais );
      idioma  	= UtilidadesSession.getIdioma(this).toString();
      traza("idioma >>>> " + idioma);	
      formatoFechaPais         = UtilidadesSession.getFormatoFecha(this);
      asignarAtributo("VAR","oidPais","valor", pais.toString());
      asignarAtributo("VAR","oidIdioma","valor", idioma.toString());
      asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());


	try {
			
      traza("antes de cargar>>>>");	
      rastreo();
      getConfiguracionMenu("LPReasignarCarteraConsultoras","");
			asignarAtributo("VAR","hFormatoFechaPais","valor",formatoFechaPais);     
      asignarAtributo("VAR","hPais","valor",pais);
		  asignarAtributo("VAR","hIdioma","valor",idioma);	     
			traza("FECHA>>>> " + formatoFechaPais);
   
      traza("accion>>>> " + accion);
      /*
       * 1) Si (accion == "") entonces 
          -> ejecutar "cargarPagina()" 
          (1) Si no Si (accion == "reasignar") entonces 
          -> ejecutar "reasignar()" 
          (1) Si no Si (accion == "activacionExterna") entonces 
          -> ejecutar "activacionExterna()" 
          (1) Fin Si   
       * 
       * */
      
      if (accion.equals("")) 
			{ 
			   cargarPagina();
      }
      else if (accion.equals("reasignar")){
        reasignar();    
      }     
      else if(accion.equals("activacionExterna")){
         activacionExterna();      
      }
      
      else if(accion.equals("Modificar cliente")){
         modificarCliente();      
      }
      
      
		
  }
    catch ( Exception e )  {
      traza("Exception en LPReasignarCarteraConsultoras");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
  
  
  
   private void cargarPagina() throws Exception
 {	
    traza("en cargarCombo >>>");
 	
    /**
     > Crear un DTOBelcorp con pais e idioma de la sesión 
      -> Llamar al subsistema "GestorCargaPantalla" con los siguientes datos: 
      - idBusiness = "SEGConsultaCanales" y DTOBelcorp => llena el combo de "canal" 
      - idBusiness = "SEGConsultaMarcas" => se llena el combo de "marca" 
      - idBusiness = "COBObtenerUsuariosCobCombo" y DTOBelcorp => se llena el combo "etapaDeuda" 
      - idBusiness = "MAEObtenerTipos" y DTOBelcorp => se llena el combo "tipoCliente" 
      -> Deshabilitar el botón "reasignar" 
      -> Asignar a la variable oculta "activacionExterna" = "false" 
      -> Mostrar página
     * 
     * 
     * */
    DTOBelcorp dtoe = new DTOBelcorp();
    dtoe.setOidIdioma(new Long(idioma));
    dtoe.setOidPais(new Long(pais));
    traza("PASO 1");
    ComposerViewElementList lista = new ComposerViewElementList();  
    traza("PASO 2");   
    
    
    /** Obtenemos los tipoCargo */
    ComposerViewElement cmb1 = new ComposerViewElement();
    cmb1.setIDBusiness("SEGConsultaCanales");
    cmb1.setDTOE(dtoe);  
    
    
    /** Obtenemos los usuarioCobranzas */
    ComposerViewElement cmb2 = new ComposerViewElement();
    cmb2.setIDBusiness("SEGConsultaMarcas");
    cmb2.setDTOE(dtoe); 
     
    
    /** Obtenemos las marcas */
   ComposerViewElement cmb3 = new ComposerViewElement();
   cmb3.setIDBusiness("COBObtenerUsuariosCobCombo"); 
   cmb3.setDTOE(dtoe);
  
    
    /** Obtenemos los canales */
   ComposerViewElement cmb4 = new ComposerViewElement();
    cmb4.setIDBusiness("MAEObtenerTipos"); 
    cmb4.setDTOE(dtoe);
    traza("cmb4***** " + cmb4);
  
    lista.addViewElement(cmb1);   
    lista.addViewElement(cmb2);
    lista.addViewElement(cmb3);
    lista.addViewElement(cmb4);  
    
    traza("PASO 3");
    ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
    traza("a");
    conector.ejecucion();
    traza("PASO 4");
    DruidaConector resultados = conector.getConector();   
    traza("resultados>>>>> " + resultados);
    
    asignar("COMBO","cbUsuOri", resultados,"COBObtenerUsuariosCobCombo");					
    asignar("COMBO","cbCanal", resultados,"SEGConsultaCanales");					
    asignar("COMBO","cbMarca", resultados,"SEGConsultaMarcas");	
    
    asignar("COMBO","cbTipoCli", resultados,"MAEObtenerTipos");	
   
    asignarAtributo("VAR","reasignarH","valor","SI"); 
    asignarAtributo("VAR","activacionExterna","valor","false");
    
    
    
  }
  
  private void reasignar() throws Exception{
 /*
  * 
  * /** LPReasignarCarteraConsultoras.reasignar() 
      Proceso: 
      -> Crear idBusiness = "COBReasignarCartera" 
      -> Crear objeto DTOAsignacionCobranza y hacer el siguiente mapeo: 
      
      -> DTOAsignacionCobranza.usuarioOrigen = usuarioOrigen de pantalla 
      -> DTOAsignacionCobranza.usuarioDestino = usuarioDestino de pantalla 
      -> DTOAsignacionCobranza.etapaDeuda = etapaDeuda de pantalla 
      -> DTOAsignacionCobranza.marca = marca de pantalla 
      -> DTOAsignacionCobranza.canal = canal de pantalla 
      -> DTOAsignacionCobranza.periodo = periodo de pantalla 
      -> DTOAsignacionCobranza.numeroClientes = numeroClientes de pantalla 
      -> DTOAsignacionCobranza.porcentajeClientes = porcentajeClientes de pantalla 
      -> DTOAsignacionCobranza.oidCliente = oidCliente de pantalla 
      -> DTOAsignacionCobranza.codigoCliente = codigoCliente de pantalla 
      -> DTOAsignacionCobranza.tipoCliente = tipoCliente de pantalla 
      -> DTOAsignacionCobranza.subtipoCliente = subtipoCliente de pantalla 
      -> Poner el resto de atributos a NULL 
      -> Asignar conector "ConectorReasignarCartera" con idBusiness y dto creados 
  * */
  
    
    String usuDes =  conectorParametroLimpia("usuarioDestino", "", true);
    
    String usuOri =  conectorParametroLimpia("usuarioOrigen", "", true);
    traza ("a3" + usuOri);
    String etapa = conectorParametroLimpia("etapaDeuda", "", true);
    traza ("a4" + etapa);
    String marca = conectorParametroLimpia("marca", "", true);
    traza ("a5" + marca);
    String canal= conectorParametroLimpia("canal", "", true);
    traza ("a6" + canal);
    String periodo = conectorParametroLimpia("periodo", "", true);
    traza ("a7" + periodo);
    String numeroClientes =  conectorParametroLimpia("numCliente", "", true);
    traza ("a8" + numeroClientes);
    String porcentajeClientes = conectorParametroLimpia("porCliente", "", true);
    traza ("a9" + porcentajeClientes);
    String oidClien = conectorParametroLimpia("oidCliente", "", true);
    traza ("a10" + oidClien);
    String codigoClien = conectorParametroLimpia("codCliente", "", true);
    traza ("a11" + codigoClien);
    String tipoCliente = conectorParametroLimpia("tipoCliente", "", true);
    traza ("a12" + tipoCliente);
    String subTipoCliente = conectorParametroLimpia("subTipoCliente", "", true); 
    traza ("a13" + subTipoCliente);
    
    DTOAsignacionesCobranza dto = new DTOAsignacionesCobranza();
    
    if ((idioma != null) && !(idioma.equals(""))){ 
          dto.setOidIdioma(new Long(idioma));
    }
    
    if ((pais != null) && !(pais.equals(""))){ 
        traza ("pais" + pais);
        dto.setOidPais(new Long(pais));   
    }   
    
    
    if ((usuDes != null) && !(usuDes.equals(""))){ 
        traza ("usuDes" + usuDes);
        dto.setUsuarioDestino(new Long(usuDes));
    }
    
    
    if ((usuOri != null) && !(usuOri.equals(""))){ 
      traza ("usuOri" + usuOri);
      dto.setUsuarioOrigen(new Long(usuOri));
    }
    
    if ((usuDes != null) && !(usuDes.equals(""))){ 
        traza ("usuDes" + usuDes);
        dto.setUsuarioDestino(new Long(usuDes));
    }
    
    
    if ((etapa != null) && !(etapa.equals(""))){ 
        traza ("etapa" + etapa);
          dto.setEtapaDeuda(new Long(etapa));
    }
    if ((marca != null) && !(marca.equals(""))){ 
        traza ("marca" + marca);
        dto.setMarca(new Long(marca));
    }
    if ((canal != null) && !(canal.equals(""))){ 
       traza ("canal" + canal);
       dto.setCanal(new Long(canal));
    }
    if ((periodo != null) && !(periodo.equals(""))){ 
        traza ("periodo" + periodo);
        dto.setPeriodo(new Long(periodo));
    }
    if ((numeroClientes != null) && !(numeroClientes.equals(""))){ 
        traza ("numeroClientes" + numeroClientes);
        dto.setNumeroClientes(new Integer(numeroClientes));
    }
    if ((porcentajeClientes != null) && !(porcentajeClientes.equals(""))){ 
       traza ("porcentajeClientes" + porcentajeClientes);
       dto.setPorcentajeClientes(new Float(porcentajeClientes));
    }
    if ((oidClien != null) && !(oidClien.equals(""))){ 
       traza ("oidClien" + oidClien);
       dto.setOidCliente(new Long(oidClien));
    }

	  if ((codigoClien != null) && !(codigoClien.equals(""))){ 
       traza ("codigoClien" + codigoClien);
       dto.setCodigoCliente(codigoClien.toString());
    }

    if ((tipoCliente != null) && !(tipoCliente.equals(""))){ 
        traza ("tipoCliente" + tipoCliente);
        dto.setTipoCliente(new Long(tipoCliente));
    }
    if ((subTipoCliente != null) && !(subTipoCliente.equals(""))){ 
        traza ("subTipoCliente" + subTipoCliente);
        dto.setSubtipoCliente(new Long(subTipoCliente));
    }
    
    
    dto.setImporteHasta(null);
    dto.setPaginado(null);
    dto.setPorcentajeHasta(null);
    dto.setRegion(null);
    dto.setSubgerencia(null);
    dto.setSeccion(null);
    dto.setTerritorio(null);
    dto.setZona(null);
    
    pagina("salidaGenerica"); 
    MareBusinessID id = new MareBusinessID("COBReasignarCartera");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dto);
		paramEntrada.add(id);

		traza("contenido del vector:::::: ++ " + paramEntrada);

		traza("antes del conector");
		DruidaConector conectorObjeto = conectar("ConectorReasignarCartera", paramEntrada);
		traza("despues del conector");
    this.asignarAtributo("VAR", "ejecutar", "valor", "buscar()");

  }
  
  
    private void activacionExterna() throws Exception
 {	
    traza("en activacionExterna >>>"); 	
    /* 
      -> Crear un DTOBelcorp con pais e idioma de la sesión 
      -> Llamar al subsistema "GestorCargaPantalla" con los siguientes datos: 
      - idBusiness = "SEGConsultaCanales" y DTOBelcorp => llena el combo de "canal" 
      - idBusiness = "SEGConsultaMarcas" => se llena el combo de "marca" 
      - idBusiness = "COBObtenerUsuariosCobCombo" y DTOBelcorp => se llena el 
      combo "etapaDeuda" 
      - idBusiness = "MAEObtenerTipos" y DTOBelcorp => se llena el combo 
      "tipoCliente" 
      -> Deshabilitar el Botón "reasignar" 
      -> Deshabilitar el Radio Button "seleccion" y activar la opción "Codigo Cliente" 
      
      -> Deshabilitar los atributos "numeroClientes", "porcentajeClientes", 
      "codigoCliente", "tipoCliente" y "subtipoCliente" 
      -> Tomar de sesión el valor del parámetro "codigoCliente" y asignarlo al 
      campo "codigoCliente" 
      -> Asignar a la variable oculta "activacionExterna" = "true" 
      -> Mostrar página
     * */
     DTOBelcorp dtoe = new DTOBelcorp();
     dtoe.setOidIdioma(new Long(idioma));
     dtoe.setOidPais(new Long(pais));     
     
     String codigoCliente = conectorParametroLimpia("oid", "", true);
     
     traza("PASO 1");
     ComposerViewElementList lista = new ComposerViewElementList();  
     traza("PASO 2");   
    
    
    /** Obtenemos los tipoCargo */
    ComposerViewElement cmb1 = new ComposerViewElement();
    cmb1.setIDBusiness("SEGConsultaCanales");
    cmb1.setDTOE(dtoe);  
    
    
    /** Obtenemos los usuarioCobranzas */
    ComposerViewElement cmb2 = new ComposerViewElement();
    cmb2.setIDBusiness("SEGConsultaMarcas");
    cmb2.setDTOE(dtoe); 
     
    
    /** Obtenemos las marcas */
   ComposerViewElement cmb3 = new ComposerViewElement();
   cmb3.setIDBusiness("COBObtenerUsuariosCobCombo"); 
   cmb3.setDTOE(dtoe);
  
    
    /** Obtenemos los canales */
   ComposerViewElement cmb4 = new ComposerViewElement();
    cmb4.setIDBusiness("MAEObtenerTipos"); 
    cmb4.setDTOE(dtoe);
    traza("cmb4***** " + cmb4);
  
    lista.addViewElement(cmb1);   
    lista.addViewElement(cmb2);
    lista.addViewElement(cmb3);
    lista.addViewElement(cmb4);  
    
    traza("PASO 3");
    ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
    traza("a");
    conector.ejecucion();
    traza("PASO 4");
    DruidaConector resultados = conector.getConector();   
    traza("resultados>>>>> " + resultados);
    
    
    
    asignar("COMBO","cbUsuOri", resultados,"COBObtenerUsuariosCobCombo");					
    asignar("COMBO","cbCanal", resultados,"SEGConsultaCanales");					
    asignar("COMBO","cbMarca", resultados,"SEGConsultaMarcas");	
    asignar("COMBO","cbTipoCli", resultados,"MAEObtenerTipos");	
    
    asignarAtributo("VAR","reasignarH","valor","SI"); 
    asignarAtributo("VAR","radioH","valor","SI"); 
    asignarAtributo("VAR","activacionExterna","valor","true");
    asignarAtributo("VAR", "codigoClienteH", "valor", "NO"); //habilitada
    asignarAtributo("CTEXTO","txtCodCli","valor",codigoCliente);
   // asignarAtribtuo("VAR", "codigo", "valor", codigoCliente);
    
    //Deshabilitadas
    asignarAtributo("VAR","numeroClientesH","valor","SI"); 
    asignarAtributo("VAR","porcentajeClientesH","valor","SI"); 
    asignarAtributo("VAR","codigoClienteH","valor","SI"); 
    asignarAtributo("VAR","tipoClienteH","valor","SI"); 
    asignarAtributo("VAR","subtipoClienteH","valor","SI"); 
 }
  
  
  	private void modificarCliente() throws Exception{
          traza("### Entro a modificarCliente ###");
          pagina("salidaGenerica");
          asignarAtributo("VAR", "cerrarVentana", "valor", "0");
      		asignarAtributo("VAR", "ejecutarError", "valor", "errorClienteBusqueda()");
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
      		String codigoCliente = new String();
      		codigoCliente = conectorParametroLimpia("codCliente", "", true);
      		asignarAtributo("VAR", "ejecutarError", "valor", "errorClienteBusqueda()");
          traza("Código de cliente capturado: " + codigoCliente);
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
          String oidCliente = ((BigDecimal)retorno.getValueAt(0, "OID")).toString();
      		String funcion = new String("asignarDatosCliente('" + oidCliente);
    }
  
}//Fin de la LP
