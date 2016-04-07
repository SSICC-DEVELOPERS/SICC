import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
 import java.util.Vector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.msg.DTOSeleccionMensajes;
import es.indra.sicc.logicanegocio.fac.generaciondocumentos.DTODocumento;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;



public class LPConsultarMensajes extends LPSICCBase {

  private String accion = null;  
  private String pais = null;
  private String idioma = null;
  private String casoDeUso = null;
  
  private String oidPatron  = null;
  private String codigoCliente = null;
  private String oidPeriodo = null;
  private String nombreLP = null;	
  private String formatoFechaPais = null;

  private String numeroLoteImpresion = null;
  private String fechaImpresion = null;
  
  private String oidTipoPeriodo = null;
  
  
  public LPConsultarMensajes() {	
	super();	
   }

  public void inicio() throws Exception {	
}
  
  public void ejecucion() throws Exception {
  setTrazaFichero();

	accion     	= conectorParametroLimpia("accion", "", true);
	traza("accion>>>> " + accion);
	
	pais 	  	= UtilidadesSession.getPais(this).toString();
	traza("pais >>>>  "  +pais );
	
  idioma  	= UtilidadesSession.getIdioma(this).toString();
	traza("idioma >>>> " + idioma);
	
	casoDeUso   = conectorParametroLimpia("casoDeUso", "", true); 
	traza("caso de uso>>>> " + casoDeUso);
	
	oidPatron     	= conectorParametroLimpia("oidPatron", "", true);
	traza("oidPatron>>>>>> " + oidPatron);
	
	codigoCliente   = conectorParametroLimpia("codigoCliente", "", true);
	traza("codigoCliente>>>>> " + codigoCliente);
	
	oidPeriodo      = conectorParametroLimpia("oidPeriodo", "", true);
	traza("oidPeriodo>>>>>>> " + oidPeriodo);

	nombreLP        = conectorParametroLimpia("LP", "", true);
	traza("nombreLP>>>>>>> " + nombreLP); 
  
  formatoFechaPais         = UtilidadesSession.getFormatoFecha(this);

	try {
			traza("antes de cargar>>>>");	
      rastreo();
      cargarPaginas();
			asignarAtributo("VAR","hFormatoFechaPais","valor",formatoFechaPais);     
      asignarAtributo("VAR","hPais","valor",pais);
		  asignarAtributo("VAR","hIdioma","valor",idioma);	     
			traza("FECHA>>>> " + formatoFechaPais);
      
      String fec = conectorParametroLimpia("hFormatoFechaPais", "", true);
      traza("fec- " + fec.toString()); 		

			traza("accion>>>> " + accion);
      
         if (accion.equals("")) {
             this.inicializar(); 
         } else {
      
			if (accion.equals("Simular mensajes")) 
			{ 
						getConfiguracionMenu("LPConsultarMensajes","Simular mensajes");
						asignarAtributoPagina("cod", "0331");
						traza("AAAAAAAA>>>> " + accion);
						pagina("contenido_pantalla_vacia");
					//	DTODocumento dtoDocumento = new DTODocumento();
						traza("antes de simular mensajes>>><");
						DTODocumento dtoDocumento = simularMensajes();
            traza("despues de dtoDocumento>>>> " );
						this.cargarPGDocumentoMensajes(dtoDocumento);
            asignarAtributo("VAR","accion","valor",accion);	   
			} 
			else{

							if (accion.equals("Consultar mensajes consultora")) 
							{ 
							  getConfiguracionMenu("LPConsultarMensajes","Consulta Mensajes por Consultora");
								asignarAtributoPagina("cod", "0332");

								traza("entro por la accion de Buscar!!!!!!!!");							 
								DTOSalida dtoSalida = new DTOSalida(); 
								traza("antes de consultarAAA");
							    pagina("salidaGenerica");
								dtoSalida = consultarMensajesDesdeConsultora();
								traza("contenido>>>>>" + dtoSalida);
								mostrarListaMensajes(dtoSalida);
                
							}
					}

			}
  }
    catch ( Exception e )  {
      traza("Exception en LPConsultarMensajes");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }




  private void inicializar() throws Exception{
	if (casoDeUso.equals("Simulacion Mensajes")){
	  	cargarPGSimulacionMensajes();
	}else{
       if (casoDeUso.equals("Consulta Mensajes por Consultora")){
		 cargarPGConsultarMensajesPorConsultora();
         getConfiguracionMenu("LPConsultarMensajes", "");	
         asignarAtributoPagina("cod", "0332");
         asignarAtributo("VAR","hFormatoFechaPais","valor",formatoFechaPais);     
         asignarAtributo("VAR","hPais","valor",pais);
 		 asignarAtributo("VAR", "hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
		 asignarAtributo("VAR","hIdioma","valor",idioma);	
			}
	} 
 }
 
  private void cargarPGConsultarMensajesPorConsultora() throws Exception
 {
	/** 
	 *	Mostrar la página PGConsultarMensajesPorConsultora
	 * 
	 */
   
   traza("aaaaaaaaaaaaaaa");
   getConfiguracionMenu("LPConsultarMensajes", "");	
	 asignarAtributoPagina("cod", "0332");
   asignarAtributo("VAR","hFormatoFechaPais","valor",formatoFechaPais);     
   asignarAtributo("VAR","hPais","valor",pais);
	 asignarAtributo("VAR","hIdioma","valor",idioma);	
   
   traza("en el metodo de cargar");
   
	 DTOBelcorp dto1 = new DTOBelcorp();
	 dto1.setOidIdioma(new Long(idioma));
	 dto1.setOidPais(new Long(pais));

   pagina("contenido_msg_consultora_consultar");
   // INC 22027 - dmorello, 05/01/2006
   this.getFormatosValidaciones();

	 ComposerViewElementList lista = new ComposerViewElementList();

    /** Obtenemos los patrones */
    ComposerViewElement cmb1 = new ComposerViewElement();
    cmb1.setIDBusiness("MSGObtenerTodosPatrones");
    cmb1.setDTOE(dto1);
 
   /** Obtenemos los tipos de períodos */
    ComposerViewElement cmb2 = new ComposerViewElement();
    cmb2.setIDBusiness("SEGObtenerTiposPeriodo"); 
    cmb2.setDTOE(dto1);
  
    lista.addViewElement(cmb1);
    lista.addViewElement(cmb2);
    
    ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
    conector.ejecucion();
    DruidaConector resultados = conector.getConector();
   
    asignar("COMBO","cbCodPatron", resultados,"MSGObtenerTodosPatrones");					
    asignar("COMBO","comboTipoPeriodo", resultados, "SEGObtenerTiposPeriodo");
    traza("despues de asignar>>> " );
    getConfiguracionMenu("LPConsultarMensajes", "");	
	  asignarAtributoPagina("cod", "0332");
    
    asignarAtributo("VAR","hFormatoFechaPais","valor",formatoFechaPais);     
    asignarAtributo("VAR","hPais","valor",pais);
	  asignarAtributo("VAR","hIdioma","valor",idioma);
      // Inc. DBLG700000144 Seteo automáticamente el codigo de cliente que viene de Callcenter
      if (codigoCliente != null && !codigoCliente.equals("")) {
          asignarAtributo("CTEXTO", "codCliente", "valor", codigoCliente);
      }
      
	}
  
 
 private void cargarPGSimulacionMensajes() throws Exception
 {	
    traza("en simular mensajesZZZz");
 	
    DTOBelcorp dto1 = new DTOBelcorp();
    dto1.setOidIdioma(new Long(idioma));
    dto1.setOidPais(new Long(pais));
    
    ComposerViewElementList lista = new ComposerViewElementList();  
    
    /** Obtenemos los patrones */
    ComposerViewElement cmb1 = new ComposerViewElement();
    cmb1.setIDBusiness("MSGObtenerTodosPatrones");
    cmb1.setDTOE(dto1);  
    
    /** Obtenemos los tipos de períodos */
    ComposerViewElement cmb2 = new ComposerViewElement();
    cmb2.setIDBusiness("SEGObtenerTiposPeriodo"); 
    cmb2.setDTOE(dto1);
  
    lista.addViewElement(cmb1);
    lista.addViewElement(cmb2);
    
    ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
    conector.ejecucion();
    DruidaConector resultados = conector.getConector();
    
    asignar("COMBO","comboPatron", resultados,"MSGObtenerTodosPatrones");					
    asignar("COMBO","comboTipoPeriodo", resultados, "SEGObtenerTiposPeriodo");
	asignarAtributo("VAR", "hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());

  }
	



 private void cargarPaginas() throws Exception
 {
	traza("nombreLP>>>>x**** " + nombreLP);
	if (nombreLP.equals("LPSimulacionMensajes")){
		pagina("contenido_msg_simulacion");
    getConfiguracionMenu("LPConsultarMensajes", "");	
		asignarAtributoPagina("cod", "0331");

	}else{
			if (nombreLP.equals("LPConsultaMensajesPorConsultora")){        
				pagina("contenido_msg_consultora_consultar"); 
        getConfiguracionMenu("LPConsultarMensajes", "");	
				asignarAtributoPagina("cod", "0332");
			}
      pagina("contenido_msg_consultora_consultar");
      getConfiguracionMenu("LPConsultarMensajes", "");	
			asignarAtributoPagina("cod", "0332");
	}
  
  if(!casoDeUso.equals(null)){
      if (casoDeUso.equals("Simular mensajes")){
          pagina("contenido_pantalla_vacia");
      }
  
  }
	 this.getFormatosValidaciones();
	
 }
 
 
 private void cargarPGDocumentoMensajes(DTODocumento dto) throws Exception
 {
	// Muestra en la página PGDocumentoMensajes la información del documento 
	//contenido en el DTODocumento 
  
  pagina("contenido_pantalla_vacia");
  getConfiguracionMenu("LPConsultarMensajes","Simular mensajes");	  
	asignarAtributoPagina("cod", "0331");
  traza("aaaa>>>>> " + dto.getNumSecuencia());
  traza("bbbbb>>>>> " + dto.getTipoDocumento());
  
  traza("docuemento Z>>>>> " + dto.toString());  
  
  
  String a = dto.getDocumento();
  
//asignarAtributo("VAR","label","valor",a);  
  traza("a>Z>>>>> " + a);
  /* dmorello, 13/03/2006: Se mostrarán en pantalla los datos recuperados. */
  //asignarAtributo("VAR","label","valor",a); 
  asignarAtributo("AREATEXTO","lblLabel","valor",a);
  
 //  asignarAtributo("LABELC","lblLabel","valor", a);
	
 }	
private DTODocumento simularMensajes() throws Exception
 {
	/** 
    	Crea un idBusiness="MSGSimularMensajes" 
		Invoca a ConectorImprimirMensajeDesdeEditor y obtiene un DTODocumento 
	 */
   
   DTODocumento dtoD = new DTODocumento();
   
	 DTOSeleccionMensajes dto = new DTOSeleccionMensajes();
	 dto.setOidPais(new Long(pais));
	 dto.setOidPatron(new Long(oidPatron));
	 dto.setCodigoCliente(codigoCliente);  
	 dto.setOidPeriodo(new Long(oidPeriodo));
   dto.setOidIdioma(new Long(idioma));

	 traza("contenido del DTOSeleccionMensajes***" + dto.toString());

	 MareBusinessID id = new MareBusinessID("MSGSimularMensajes");
	 Vector paramEntrada = new Vector();
	 paramEntrada.add(dto);
	 paramEntrada.add(id);

   traza("antes del conector");					
   DruidaConector conectorImp= conectar("ConectorSimularMensajes", paramEntrada);
   traza("despues del conector");	
        
   //  DTODocumento dtoD = (DTODocumento)conectorImp.objeto("DTODocumento");
   dtoD = (DTODocumento)conectorImp.objeto("DTODocumento");
   traza("contenido de dtoD>>>> " + dtoD.toString());
    
	 return dtoD;	 
 
 }

	private DTOSalida consultarMensajesDesdeConsultora() throws Exception
	{
	/**
		Invoca a ConectorConsultarMensajesPorConsultora y obtiene un DTOSalida
	*/
	//  pagina("salidaGenerica");
	//	pagina("contenido_msg_consultora_consultar");

		numeroLoteImpresion = conectorParametroLimpia("lote", "", true);
		fechaImpresion      = conectorParametroLimpia("impresion", "", true);
    
		oidPeriodo = conectorParametroLimpia("oidPeriodo", "", true);
		oidPatron  = conectorParametroLimpia("oidPatronH", "", true);
    
	    codigoCliente	= conectorParametroLimpia("codigoClienteH", "", true);
		oidTipoPeriodo  = conectorParametroLimpia("oidPeriodoH", "", true);

		DTOSeleccionMensajes dtoSelec = new DTOSeleccionMensajes();

		traza("codigoCliente>>>>> " + codigoCliente);
		dtoSelec.setCodigoCliente(codigoCliente);	
	    asignarAtributo("VAR","codigoClienteH","valor", codigoCliente);
    
		traza("oidPeriodo>>>> " +oidPeriodo);    
		dtoSelec.setOidPeriodo(new Long(oidPeriodo));	
	    asignarAtributo("VAR","oidPeriodo","valor", oidPeriodo);

		if (!oidPatron.equals("")){
			dtoSelec.setOidPatron(new Long(oidPatron));	
		    asignarAtributo("VAR","oidPatronH","valor", oidPatron);
		}	
        traza("1");
    
		if(!numeroLoteImpresion.equals("")){
			dtoSelec.setNumeroLoteImpresion(new Long(numeroLoteImpresion));
		    asignarAtributo("VAR","lote","valor", numeroLoteImpresion);
		}
	    traza("2");

		if(!fechaImpresion.equals("")){
			dtoSelec.setFechaImpresion(fechaImpresion);
			asignarAtributo("VAR","impresion","valor", fechaImpresion);
		}

	    traza("3");
		dtoSelec.setOidPais(new Long(pais));

		MareBusinessID id = new MareBusinessID("MSGConsultarMensajesPorConsultora");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoSelec);
		paramEntrada.add(id);

		traza("antes del conector");					
		DruidaConector conector= conectar("ConectorConsultarMensajesPorConsultora", paramEntrada);
		traza("despues del conector");
		traza("obtuvo "+conector); 
		DTOSalida dtoS = (DTOSalida)conector.objeto("DTOSalida");
    
   //   pagina("contenido_msg_consultora_consultar");
		traza("devuelve "+dtoS);
		return dtoS;	
	
 }	


    private void mostrarListaMensajes(DTOSalida DTOE) throws Exception
    {
	
		traza("el DTO entrada es: "+DTOE);
	    RecordSet rs = DTOE.getResultado();
        StringBuffer linea = new StringBuffer("");  
        traza("el rs es: "+rs);
        traza("cantidad>>>> " + rs.getRowCount());

                 
		for ( int i = 0; i < rs.getRowCount(); i++)
		{
		    traza("i-----" + i);
    
		    String uno = (String)rs.getValueAt(i, 0);
		    String dos = (String)rs.getValueAt(i, 1);
		/*  String tres = (String)rs.getValueAt(i, 2);
		    String cuatro = (String)rs.getValueAt(i, 3);  */
    
		    if (!linea.toString().equals("")){        
				linea.append("|");
	        traza("linea>>>>> " + linea);
			}
    
		    if(uno != null && !uno.equals("")){
				linea.append(uno);
		        traza("1");
		    }else{
				linea.append(" ");
            }
     
			 linea.append("@");
     
    
		    if(dos != null && !dos.equals("")){
				linea.append(dos);
		    }else{
				linea.append(" ");
			}
		//  linea.append("@");     
    
		/*  if(tres != null && !tres.equals(""))
		        linea.append(tres);
            else
			    linea.append(" ");
     
		//  linea.append("@");  

		    if(cuatro != null && !cuatro.equals(""))
				linea.append(cuatro);
			else
		        linea.append(" "); 
		*/  
        
			traza("******** linea *********** " + linea);

   
		}//end - primer for
	//  String a = new String("a");
	//  linea.append("|");

		  /*
		   * dmorello, 13/01/2006
		   * Se observó que, si el texto del mensaje se compone de varias líneas,
		   * no se muestra la lista de resultados en pantalla. Esto se debe a que la llamada
		   * a seteaValores queda formada también por esos saltos de línea, resultando, por
		   * ejemplo:
		   *          seteaValores('<txt>Linea 1</txt>
		   * 
		   *          <txt/>')
		   *
		   * De este modo, nos queda una llamada a JavaScript incorrecta.
		   * Para evitar esto, se buscará reemplazar los cambios de línea por otro carácter
		   * y el proceso inverso se realizará en la página, a fin de restaurar el String original.
		   */
		  String param = quitarCambiosDeLinea(linea);
		  traza("param: "+param);
		  
		  traza("A setear en variable de formulario: " + param );
		  asignarAtributo("VAR", "ejecutar", "valor", "seteaValores('"+ param +"');");
	  } 

	  
	  /*
	   * dmorello, 18/01/2006
	   * Quita los cambios de línea del StringBuffer y los reemplaza por un carácter ~.
	   * Se escriben cada vez dos contrabarras para que la sintaxis JavaScript quede correcta.
	   * Devuelve el String resultante
	   */
	  private String quitarCambiosDeLinea(StringBuffer sb) {
	  	  final String cambioLinea = "\r\n";
	  	  final String reemplazo = "~";
		  int indexOf;
		  while ((indexOf = sb.indexOf(cambioLinea)) != -1) {
			  sb.replace(indexOf,indexOf+cambioLinea.length(),reemplazo);
		  }
		  return sb.toString();
	  }

 
}
