
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_mantenimiento_gerente_congelado_insertar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_mantenimiento_gerente_congelado_insertar" );
      ((Element)v.get(0)).setAttribute("cod","ComConge.create.label" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r   \r\rfunction onLoadPag(){\r	\r  configurarMenuSecundario('formulario'); \r  \r  if (get('formulario.errDescripcion')!='') {\r    var wnd = fMostrarMensajeError(get('formulario.errCodigo'), get('formulario.errDescripcion'));\r  }\r  \r  focaliza('formulario.txtCodCliente','');\r\r}\r\r\rfunction fVolver(){\r}\r\r\rfunction fEliminar(){\r}\r\rfunction fGuardar(){\r\r	if(sicc_validaciones_generales())\r	{\r		 if ( get('formulario.codigoCliente') != get('formulario.txtCodCliente'))  {\r			set(\"formulario.codigoCliente\", get('formulario.txtCodCliente'));\r			set(\"formulario.oidCliente\", \"\");\r		}\r\r	    /* inicio Validacion de FechaDesde menor o igual que FechaHasta */\r		var fecha1 = get('formulario.txtFechaDesde');\r		var fecha2 = get('formulario.txtFechaHasta');\r		var resultadoComparacion = ComparaFechas(fecha1, fecha2);  		if (resultadoComparacion != 0 && resultadoComparacion != 1 ) {\r			GestionarMensaje('UICOM0011'); 			focaliza('formulario.txtFechaHasta');\r			return false;\r		}\r       /* fin de Validacion de FechaDesde menor o igual que FechaHasta */\r    \r		 set(\"formulario.fechaDesde\",obtenerFormatoFecha(intercambiar(get('formulario.txtFechaDesde'))));\r		 set(\"formulario.fechaHasta\",obtenerFormatoFecha(intercambiar(get('formulario.txtFechaHasta'))));\r		 \r		 var importeFormatoDruida= get('formulario.txtImporte');\r		 var  importeFormatoJava;\r		 if (importeFormatoDruida != \"\" &&		importeFormatoDruida !=  null 	){\r					importeFormatoJava = numeroDeFormatoSICC(importeFormatoDruida); \r		 }\r\r		set(\"formulario.importe\", importeFormatoJava);\r		set(\"formulario.descongelacionAutomatica\",get('formulario.ckDescongelacionAutomatica'));		\r		set(\"formulario.accion\", \"insertar\");		\r		set(\"formulario.conectorAction\", \"LPMantenimientoGerenteCongelado\");\r    \r    enviaSICC(\"formulario\");\r    \r  }\r}\r\r\rfunction intercambiar(fecha){\r  \r  var posicionGuion = fecha.indexOf(\"-\");\r  var posicionBarra = fecha.indexOf(\"/\");\r  \r  if (posicionGuion != -1){\r    var fechaEntrada = fecha.split(\"-\");\r    var fechaSalida = fechaEntrada[1] + \"-\" + fechaEntrada[0] + \"-\" + fechaEntrada[2]\r  }\r  \r  if (posicionBarra != -1){\r    var fechaEntrada = fecha.split(\"/\");\r    var fechaSalida = fechaEntrada[1] + \"/\" + fechaEntrada[0] + \"/\" + fechaEntrada[2]\r  }\r  \r  return fechaSalida;\r  \r}\r\r\rfunction ontabsh_txtCodCliente(){\r	focaliza('formulario.ckDescongelacionAutomatica');\r}\r\rfunction ontab_ckDescongelacionAutomatica(){\r	focaliza('formulario.txtCodCliente');\r}\r\rfunction buscarClienteOnClick (){\r			var obj = new Object();\r			var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);\r			if(whnd!=null){\r				var oid = whnd[0];\r				var cod = whnd[1];\r				set(\"formulario.txtCodCliente\", cod);\r				set(\"formulario.codigoCliente\", cod);\r				set(\"formulario.oidCliente\", oid);\r			}\r		}\r\rfunction buscarOnClick (){\r		\r		 if(sicc_validaciones_generales()){\r			if (get('formulario.txtCodCliente') != get('formulario.codigoCliente')){					\r				set('formulario.codigoCliente', get('formulario.txtCodCliente'));\r				set('formulario.oidCliente','');\r			}\r			\r			var arr = armarArray();\r			\r			configurarPaginado(mipgndo, \"COMBuscarGerenteCongelado\",	\r										\"ConectorBuscarGerentesCongelados\", \r										\"es.indra.sicc.dtos.com.DTODatosGerenteCongelacion\",arr); 						\r	}\r}\r\rfunction onChangeCodigoCliente() {\r    set('formulario.oidCliente','');\r    if (get('formulario.txtCodCliente')!='') {\r	    var codigo = get('formulario.txtCodCliente');\r	    var longitudMax = get('formulario.hLongitudCodCliente');\r	    var longitud =  codigo.length\r	    set('formulario.txtCodCliente', rellenaCeros(codigo, longitudMax, longitud));\r    }\r}\r\rfunction armarArray(){        \r\r    var descAuto;\r	var vig= true;\r\r    if (get('formulario.tieneVigentes')==\"S\") {\r        	if(get('formulario.ckVigentes')==\"S\"){\r				vig= true;\r			}else{\r				vig= false;\r			}\r    }\r\r    if(get('formulario.ckDescongelacionAutomatica')==\"S\") {\r        descAuto= true;\r    }else{\r        descAuto= false;\r    }\r\r   /* var arr = [ ['oidPais', get('formulario.varPais')], \r        ['oidIdioma', get('formulario.varIdioma')],                                  \r        ['fechaDesde', obtenerFormatoFecha(get('formulario.txtFechaDesde'))], \r        ['fechaHasta', obtenerFormatoFecha(get('formulario.txtFechaHasta'))], \r        ['importe', transformarImporte(get('formulario.txtImporte'))], \r        ['codigoCliente', get('formulario.txtCodCliente')], \r        ['descongelacion', descAuto], \r        ['vigente', 'true'],    \r        ['oidCliente', get('formulario.oidCliente')] ];						*/\r    \r    var arrDatos = new Array();\r	var i=0;\r\r	arrDatos[i] = new Array('oidPais',get('formulario.varPais'));\r	i++;\r\r	arrDatos[i] = new Array('oidIdioma',get('formulario.varIdioma'));\r 		\r		     i++;																																																				 \r\r	 if (get('formulario.txtFechaDesde')!=''){\r           var fechaD=obtenerFormatoFecha(get('formulario.txtFechaDesde'));\r	\r			arrDatos[i] = new Array('fechaDesde',fechaD);\r            i++;\r      }\r\r	if (get('formulario.txtFechaHasta')!=''){\r				var fechaH= obtenerFormatoFecha(get('formulario.txtFechaHasta'));\r            arrDatos[i] = new Array('fechaHasta',fechaH);\r            i++;\r      }\r\r	if (get('formulario.txtImporte')!=''){				\r				var	 importe1 =  get('formulario.txtImporte');\r				\r				var importe2= numeroDeFormatoSICC(importe1); \r            \r				arrDatos[i] = new Array('importe',importe2);\r            i++;\r     }\r\r	if (get('formulario.txtCodCliente')!=''){\r            arrDatos[i] = new Array('codigoCliente',get('formulario.txtCodCliente'));\r            i++;\r     }\r     \r	arrDatos[i] = new Array('descongelacion',descAuto);\r	i++;\r	\r	arrDatos[i] = new Array('vigente',vig);\r	i++;\r\r	if (get('formulario.oidCliente')!=''){\r		arrDatos[i] = new Array('oidCliente',get('formulario.oidCliente'));\r		\r  }\r	\r    return arrDatos;        \r  }\r\rfunction mostrarLista(){\r    DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='visible';\r    document.all[\"CpLin1listado1\"].style.visibility='visible';\r    document.all[\"CpLin2listado1\"].style.visibility='visible';\r    document.all[\"CpLin3listado1\"].style.visibility='visible';\r    document.all[\"CpLin4listado1\"].style.visibility='visible';\r    document.all[\"primera1Div\"].style.visibility='visible';\r    document.all[\"ret1Div\"].style.visibility='visible';\r    document.all[\"ava1Div\"].style.visibility='visible';\r    document.all[\"separaDiv\"].style.visibility='visible';\r	agregaBoton('visible');\r    eval (ON_RSZ);\r}\r\rfunction ocultarLista() {\r    document.all[\"Cplistado1\"].style.visibility='hidden';\r    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r    document.all[\"CpLin2listado1\" ].style.visibility='hidden';\r    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r	agregaBoton('hidden');\r}\r\rfunction muestraLista( ultima, rowset){                                                        \r                                                                                                    \r         var tamano = rowset.length;                                                           \r    if (tamano > 0) {                                                                      \r         mostrarLista();                                                              \r         return true;                                                                  \r    } else {                                                                                 \r         ocultarLista();                                                              \r                                    return false;                                                                        \r    }                                                                                        \r}\r\rfunction transformarImporte(importe){\r	var index;\r	var pEnt;\r\r	index= importe.indexOf(\",\");\r	if(index > 0)\r	{ \r		pEnt= importe.substring(0,index)+ importe.substring(index+1, importe.length);	\r		return pEnt;\r	}\r	return importe;\r}\r\r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtCodCliente" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","263" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtFechaDesde" );
      ((Element)v.get(8)).setAttribute("format","f" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","ComConge.fecDesd.label" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtFechaHasta" );
      ((Element)v.get(9)).setAttribute("format","f" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","ComConge.fecHast.label" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtImporte" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("max","9999999999.99" );
      ((Element)v.get(10)).setAttribute("format","n" );
      ((Element)v.get(10)).setAttribute("cod","ComConge.impCong.label" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:6   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(11)).setAttribute("nombre","formulario" );
      ((Element)v.get(11)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","accion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","varPais" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(20)).setAttribute("valor","insertar" );
      ((Element)v.get(11)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 11   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","fechaHasta" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","fechaDesde" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","importe" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","descongelacionAutomatica" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(11)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","tieneVigentes" );
      ((Element)v.get(25)).setAttribute("valor","N" );
      ((Element)v.get(11)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 11   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hLongitudCodCliente" );
      ((Element)v.get(26)).setAttribute("valor","11" );
      ((Element)v.get(11)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 11   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(27)).setAttribute("nombre","capa1" );
      ((Element)v.get(11)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("table"));
      ((Element)v.get(28)).setAttribute("width","100%" );
      ((Element)v.get(28)).setAttribute("border","0" );
      ((Element)v.get(28)).setAttribute("cellspacing","0" );
      ((Element)v.get(28)).setAttribute("cellpadding","0" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(31)).setAttribute("height","12" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","750" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(29)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(35)).setAttribute("height","1" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:29   */

      /* Empieza nodo:36 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(41)).setAttribute("class","legend" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(42)).setAttribute("nombre","lblDatosGerenteCongelado" );
      ((Element)v.get(42)).setAttribute("alto","13" );
      ((Element)v.get(42)).setAttribute("filas","1" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(42)).setAttribute("id","legend" );
      ((Element)v.get(42)).setAttribute("cod","ComConge.legend.label" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("table"));
      ((Element)v.get(43)).setAttribute("width","100%" );
      ((Element)v.get(43)).setAttribute("border","0" );
      ((Element)v.get(43)).setAttribute("align","center" );
      ((Element)v.get(43)).setAttribute("cellspacing","0" );
      ((Element)v.get(43)).setAttribute("cellpadding","0" );
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("table"));
      ((Element)v.get(46)).setAttribute("width","499" );
      ((Element)v.get(46)).setAttribute("border","0" );
      ((Element)v.get(46)).setAttribute("align","left" );
      ((Element)v.get(46)).setAttribute("cellspacing","0" );
      ((Element)v.get(46)).setAttribute("cellpadding","0" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("colspan","4" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:50 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("colspan","3" );
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("cod","263" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(50)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:50   */

      /* Empieza nodo:57 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(57)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(61)).setAttribute("nombre","txtCodCliente" );
      ((Element)v.get(61)).setAttribute("id","datosCampos" );
      ((Element)v.get(61)).setAttribute("max","15" );
      ((Element)v.get(61)).setAttribute("tipo","" );
      ((Element)v.get(61)).setAttribute("onchange","onChangeCodigoCliente();" );
      ((Element)v.get(61)).setAttribute("req","S" );
      ((Element)v.get(61)).setAttribute("size","22" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("validacion","" );
      ((Element)v.get(61)).setAttribute("onshtab","ontabsh_txtCodCliente();" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(63)).setAttribute("onclick","buscarClienteOnClick ();" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","100%" );
      ((Element)v.get(57)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:57   */

      /* Empieza nodo:66 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("colspan","4" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:69 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("table"));
      ((Element)v.get(71)).setAttribute("width","499" );
      ((Element)v.get(71)).setAttribute("border","0" );
      ((Element)v.get(71)).setAttribute("align","left" );
      ((Element)v.get(71)).setAttribute("cellspacing","0" );
      ((Element)v.get(71)).setAttribute("cellpadding","0" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblFechaDesde" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","ComConge.fecDesd.label" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","25" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblFechaHasta" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","ComConge.fecHast.label" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(72)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:72   */

      /* Empieza nodo:83 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(86)).setAttribute("valign","bottom" );
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(87)).setAttribute("nombre","txtFechaDesde" );
      ((Element)v.get(87)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).setAttribute("max","15" );
      ((Element)v.get(87)).setAttribute("tipo","" );
      ((Element)v.get(87)).setAttribute("onchange","" );
      ((Element)v.get(87)).setAttribute("req","S" );
      ((Element)v.get(87)).setAttribute("size","15" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("validacion","" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","25" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 83   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).setAttribute("valign","bottom" );
      ((Element)v.get(83)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(91)).setAttribute("nombre","txtFechaHasta" );
      ((Element)v.get(91)).setAttribute("id","datosCampos" );
      ((Element)v.get(91)).setAttribute("max","15" );
      ((Element)v.get(91)).setAttribute("tipo","" );
      ((Element)v.get(91)).setAttribute("onchange","" );
      ((Element)v.get(91)).setAttribute("req","S" );
      ((Element)v.get(91)).setAttribute("size","15" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("validacion","" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","100%" );
      ((Element)v.get(83)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:83   */

      /* Empieza nodo:94 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("colspan","4" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:97 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("table"));
      ((Element)v.get(99)).setAttribute("width","499" );
      ((Element)v.get(99)).setAttribute("border","0" );
      ((Element)v.get(99)).setAttribute("align","left" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("cellpadding","0" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(104)).setAttribute("nombre","lblImporte" );
      ((Element)v.get(104)).setAttribute("alto","13" );
      ((Element)v.get(104)).setAttribute("filas","1" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(104)).setAttribute("id","datosTitle" );
      ((Element)v.get(104)).setAttribute("cod","ComConge.impCong.label" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","25" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblDescongelacionAutomatica" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("cod","ComConge.indDescAuto.label" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("width","100%" );
      ((Element)v.get(100)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:100   */

      /* Empieza nodo:111 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(114)).setAttribute("valign","bottom" );
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(115)).setAttribute("nombre","txtImporte" );
      ((Element)v.get(115)).setAttribute("id","datosCampos" );
      ((Element)v.get(115)).setAttribute("max","13" );
      ((Element)v.get(115)).setAttribute("tipo","" );
      ((Element)v.get(115)).setAttribute("onchange","" );
      ((Element)v.get(115)).setAttribute("req","S" );
      ((Element)v.get(115)).setAttribute("size","13" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("validacion","" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","25" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(118)).setAttribute("valign","bottom" );
      ((Element)v.get(111)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(119)).setAttribute("nombre","ckDescongelacionAutomatica" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("onclick","" );
      ((Element)v.get(119)).setAttribute("check","N" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("ontab","ontab_ckDescongelacionAutomatica();" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","100%" );
      ((Element)v.get(111)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:111   */

      /* Empieza nodo:122 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("colspan","4" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:43   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:125 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:36   */

      /* Empieza nodo:127 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(129)).setAttribute("height","12" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","756" );
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","12" );
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","12" );
      ((Element)v.get(133)).setAttribute("height","1" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:127   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:11   */


   }

}
