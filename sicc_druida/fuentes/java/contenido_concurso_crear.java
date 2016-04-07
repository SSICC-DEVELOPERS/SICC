
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_concurso_crear  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_concurso_crear" );
      ((Element)v.get(0)).setAttribute("cod","0491" );
      ((Element)v.get(0)).setAttribute("titulo","Crear Concurso" );
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
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r   \r\rfunction onLoadPag(){\r	fMostrarMensajeError();\r	configurarMenuSecundario(\"formulario\");\r	DrdEnsanchaConMargenDcho('listado1', 12);\r	ocultaCapas();\r	eval(ON_RSZ);\r	focoComboNumero();\r									if (window.dialogArguments) {             btnProxy(2,1);              btnProxy(3,0);          }\r\r\r     }\r\r	function fVolver(){     \r					  window.close();\r	}\r\r\r\rfunction fLimpiar() {\r	onLoadPag();\r}\r\rfunction focoComboNumero() {\r	focaliza(\"formulario.cbNumPlantilla\");\r}\r\rfunction onTabBotonBuscar() {\r	if(document.all[\"Cplistado1\"].style.visibility=='hidden') {\r		focoComboNumero();\r	}\r	else {\r		focoBotonCrear();\r	}\r}\r\rfunction focoBotonCrear() {\r	focalizaBotonHTML_XY('btnCrear');\r}\r\rfunction focoBotonBuscar() {\r	focalizaBotonHTML('botonContenido','btnBuscar');\r}\r\rfunction onShTabNumeroPlantilla() {\r	if(document.all[\"Cplistado1\"].style.visibility=='hidden') {\r		focoBotonBuscar();\r	}\r	else {\r		focoBotonCrear();\r	}\r}\r\rfunction ocultaCapas(){\r    document.all[\"Cplistado1\"].style.visibility='hidden';\r    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"btnCrearDiv\"].style.visibility='hidden';\r}\r\rfunction muestraCapas() {\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='';\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r    document.all[\"btnCrearDiv\"].style.visibility='';\r}\r\rfunction accionBuscar(){\r\r					\r	var nroPlantilla = get('formulario.cbNumPlantilla', 'V');\r	var nombrePlantilla = get('formulario.txtNombrePlantilla', 'V');\r	var pais = get('formulario.hPais');\r	var idioma = get('formulario.hIdioma');\r\r	\r					\r	var arr = new Array();\r	arr[arr.length] = new Array(\"nroPlantilla\", nroPlantilla);\r	arr[arr.length] = new Array(\"nombrePlantilla\", nombrePlantilla);\r	arr[arr.length] = new Array(\"oidPais\", pais);\r	arr[arr.length] = new Array(\"oidIdioma\", idioma);  \r	\r			\r		\r	configurarPaginado(mipgndo, \"INCBuscarListaPlantillas\", \"ConectorBuscarListaPlantillas\", \"es.indra.sicc.dtos.inc.DTOBuscarPlantillas\", arr);\r\r\r	muestraCapas();\r}\r\rfunction accionCrear(){\r\r	if (listado1.numSelecc()!= 1) {\r		GestionarMensaje('1022',null,null,null);\r		return false;\r	}\r	else {\r		\r								\r		set('formulario.conectorAction', 'LPMantenerParametrosGenerales');\r		set('formulario.accion', '');\r		\r		var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);		\r		var oidPlantilla = listado1.datos[posicion][0];\r\r		set('formulario.oidPlantilla', oidPlantilla);\r    \r        \r		enviaSICC(\"formulario\");   \r	}\r\r}\r\rfunction obtenerPosicionListaEditable(clave, lista){\r  this.posicion = 0;\r  if (lista.codSeleccionados().length > 0){\r    for(var k=0;k<lista.datos.length;k++) {\r      if (lista.datos[k][0] == clave) {\r        posicion=k;\r        break;\r      }\r		}         \r	  return posicion;\r	}\r}\r\rfunction muestraLista(ultima, rowset, error){\r	var tamano = rowset.length;\r	\r	if (tamano > 0) {\r		muestraCapas();\r		eval (ON_RSZ);\r				return true;\r	} else {\r		ocultaCapas();\r				return false;\r	}\r}\r\r\r   \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hPais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidPlantilla" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(16)).setAttribute("width","100%" );
      ((Element)v.get(16)).setAttribute("border","0" );
      ((Element)v.get(16)).setAttribute("cellspacing","0" );
      ((Element)v.get(16)).setAttribute("cellpadding","0" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(18)).setAttribute("width","12" );
      ((Element)v.get(18)).setAttribute("align","center" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(19)).setAttribute("src","b.gif" );
      ((Element)v.get(19)).setAttribute("width","12" );
      ((Element)v.get(19)).setAttribute("height","12" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:20 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","750" );
      ((Element)v.get(17)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(17)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).setAttribute("width","12" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("height","1" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:17   */

      /* Empieza nodo:24 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(29)).setAttribute("class","legend" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(30)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(30)).setAttribute("alto","13" );
      ((Element)v.get(30)).setAttribute("filas","1" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(30)).setAttribute("id","legend" );
      ((Element)v.get(30)).setAttribute("cod","0075" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("table"));
      ((Element)v.get(31)).setAttribute("width","100%" );
      ((Element)v.get(31)).setAttribute("border","0" );
      ((Element)v.get(31)).setAttribute("align","center" );
      ((Element)v.get(31)).setAttribute("cellspacing","0" );
      ((Element)v.get(31)).setAttribute("cellpadding","0" );
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(34)).setAttribute("width","696" );
      ((Element)v.get(34)).setAttribute("border","0" );
      ((Element)v.get(34)).setAttribute("align","left" );
      ((Element)v.get(34)).setAttribute("cellspacing","0" );
      ((Element)v.get(34)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("colspan","4" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","8" );
      ((Element)v.get(37)).setAttribute("height","8" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:38 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","8" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(42)).setAttribute("nombre","lblNumPlantilla" );
      ((Element)v.get(42)).setAttribute("alto","13" );
      ((Element)v.get(42)).setAttribute("filas","1" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(42)).setAttribute("id","datosTitle" );
      ((Element)v.get(42)).setAttribute("cod","1606" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","25" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblNombrePlantilla" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(46)).setAttribute("id","datosTitle" );
      ((Element)v.get(46)).setAttribute("cod","743" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","100%" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(38)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","8" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:38   */

      /* Empieza nodo:49 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(53)).setAttribute("nombre","cbNumPlantilla" );
      ((Element)v.get(53)).setAttribute("id","datosCampos" );
      ((Element)v.get(53)).setAttribute("size","1" );
      ((Element)v.get(53)).setAttribute("multiple","N" );
      ((Element)v.get(53)).setAttribute("req","N" );
      ((Element)v.get(53)).setAttribute("valorinicial","" );
      ((Element)v.get(53)).setAttribute("textoinicial","" );
      ((Element)v.get(53)).setAttribute("onshtab","onShTabNumeroPlantilla();" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","25" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(49)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(58)).setAttribute("nombre","txtNombrePlantilla" );
      ((Element)v.get(58)).setAttribute("id","datosCampos" );
      ((Element)v.get(58)).setAttribute("max","75" );
      ((Element)v.get(58)).setAttribute("tipo","" );
      ((Element)v.get(58)).setAttribute("onchange","" );
      ((Element)v.get(58)).setAttribute("req","N" );
      ((Element)v.get(58)).setAttribute("size","75" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("validacion","" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(49)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:49   */

      /* Empieza nodo:61 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("colspan","4" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:64 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:24   */

      /* Empieza nodo:66 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("table"));
      ((Element)v.get(71)).setAttribute("width","100%" );
      ((Element)v.get(71)).setAttribute("border","0" );
      ((Element)v.get(71)).setAttribute("align","center" );
      ((Element)v.get(71)).setAttribute("cellspacing","0" );
      ((Element)v.get(71)).setAttribute("cellpadding","0" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("class","botonera" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(74)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(74)).setAttribute("ID","botonContenido" );
      ((Element)v.get(74)).setAttribute("tipo","html" );
      ((Element)v.get(74)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(74)).setAttribute("estado","false" );
      ((Element)v.get(74)).setAttribute("cod","1" );
      ((Element)v.get(74)).setAttribute("ontab","onTabBotonBuscar();" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:75 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","12" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:66   */

      /* Empieza nodo:77 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(78)).setAttribute("align","center" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(79)).setAttribute("height","12" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","756" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","12" );
      ((Element)v.get(77)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","12" );
      ((Element)v.get(83)).setAttribute("height","1" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:77   */
      /* Termina nodo:16   */

      /* Empieza nodo:84 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(84)).setAttribute("nombre","listado1" );
      ((Element)v.get(84)).setAttribute("ancho","700" );
      ((Element)v.get(84)).setAttribute("alto","301" );
      ((Element)v.get(84)).setAttribute("x","12" );
      ((Element)v.get(84)).setAttribute("y","124" );
      ((Element)v.get(84)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(84)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(85)).setAttribute("precarga","S" );
      ((Element)v.get(85)).setAttribute("conROver","S" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(86)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(86)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(86)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(86)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 85   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(87)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(87)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(87)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(87)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(85)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 85   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(88)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(88)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(85)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:85   */

      /* Empieza nodo:89 / Elemento padre: 84   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(84)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(90)).setAttribute("borde","1" );
      ((Element)v.get(90)).setAttribute("horizDatos","1" );
      ((Element)v.get(90)).setAttribute("horizCabecera","1" );
      ((Element)v.get(90)).setAttribute("vertical","0" );
      ((Element)v.get(90)).setAttribute("horizTitulo","1" );
      ((Element)v.get(90)).setAttribute("horizBase","1" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 89   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(91)).setAttribute("borde","#999999" );
      ((Element)v.get(91)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(91)).setAttribute("vertDatos","#FFFFFF" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(91)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(91)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(91)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(91)).setAttribute("horizBase","#999999" );
      ((Element)v.get(89)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 84   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(92)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(92)).setAttribute("alto","22" );
      ((Element)v.get(92)).setAttribute("imgFondo","" );
      ((Element)v.get(92)).setAttribute("cod","00135" );
      ((Element)v.get(92)).setAttribute("ID","datosTitle" );
      ((Element)v.get(84)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 84   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(93)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(93)).setAttribute("alto","22" );
      ((Element)v.get(93)).setAttribute("imgFondo","" );
      ((Element)v.get(84)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 84   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(94)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(94)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(94)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(94)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(94)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(94)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(84)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("ancho","10" );
      ((Element)v.get(95)).setAttribute("minimizable","S" );
      ((Element)v.get(95)).setAttribute("minimizada","N" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 94   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("ancho","50" );
      ((Element)v.get(96)).setAttribute("minimizable","S" );
      ((Element)v.get(96)).setAttribute("minimizada","N" );
      ((Element)v.get(94)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("ancho","15" );
      ((Element)v.get(97)).setAttribute("minimizable","S" );
      ((Element)v.get(97)).setAttribute("minimizada","N" );
      ((Element)v.get(94)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:94   */

      /* Empieza nodo:98 / Elemento padre: 84   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(98)).setAttribute("alto","20" );
      ((Element)v.get(98)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(98)).setAttribute("imgFondo","" );
      ((Element)v.get(98)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(84)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("colFondo","" );
      ((Element)v.get(99)).setAttribute("ID","EstCab" );
      ((Element)v.get(99)).setAttribute("align","center" );
      ((Element)v.get(99)).setAttribute("cod","1606" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Elemento padre:99 / Elemento actual: 100   */
      v.add(doc.createTextNode("Nº plantilla"));
      ((Element)v.get(99)).appendChild((Text)v.get(100));

      /* Termina nodo Texto:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("colFondo","" );
      ((Element)v.get(101)).setAttribute("ID","EstCab" );
      ((Element)v.get(101)).setAttribute("cod","743" );
      ((Element)v.get(98)).appendChild((Element)v.get(101));

      /* Elemento padre:101 / Elemento actual: 102   */
      v.add(doc.createTextNode("Nombre plantilla"));
      ((Element)v.get(101)).appendChild((Text)v.get(102));

      /* Termina nodo Texto:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("colFondo","" );
      ((Element)v.get(103)).setAttribute("ID","EstCab" );
      ((Element)v.get(103)).setAttribute("cod","1181" );
      ((Element)v.get(98)).appendChild((Element)v.get(103));

      /* Elemento padre:103 / Elemento actual: 104   */
      v.add(doc.createTextNode("Base cálculo"));
      ((Element)v.get(103)).appendChild((Text)v.get(104));

      /* Termina nodo Texto:104   */
      /* Termina nodo:103   */
      /* Termina nodo:98   */

      /* Empieza nodo:105 / Elemento padre: 84   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(105)).setAttribute("alto","22" );
      ((Element)v.get(105)).setAttribute("accion","" );
      ((Element)v.get(105)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(105)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(105)).setAttribute("maxSel","1" );
      ((Element)v.get(105)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(105)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(105)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(105)).setAttribute("onLoad","" );
      ((Element)v.get(105)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(84)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("tipo","texto" );
      ((Element)v.get(106)).setAttribute("ID","EstDat" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("tipo","texto" );
      ((Element)v.get(107)).setAttribute("ID","EstDat2" );
      ((Element)v.get(105)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("tipo","texto" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(108)).setAttribute("ID","EstDat" );
      ((Element)v.get(105)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:105   */

      /* Empieza nodo:109 / Elemento padre: 84   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(84)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 84   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(110)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(110)).setAttribute("ancho","700" );
      ((Element)v.get(110)).setAttribute("sep","$" );
      ((Element)v.get(110)).setAttribute("x","12" );
      ((Element)v.get(110)).setAttribute("class","botonera" );
      ((Element)v.get(110)).setAttribute("y","402" );
      ((Element)v.get(110)).setAttribute("control","|" );
      ((Element)v.get(110)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(110)).setAttribute("rowset","" );
      ((Element)v.get(110)).setAttribute("cargainicial","N" );
      ((Element)v.get(110)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(84)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(111)).setAttribute("nombre","ret1" );
      ((Element)v.get(111)).setAttribute("x","37" );
      ((Element)v.get(111)).setAttribute("y","406" );
      ((Element)v.get(111)).setAttribute("ID","botonContenido" );
      ((Element)v.get(111)).setAttribute("img","retroceder_on" );
      ((Element)v.get(111)).setAttribute("tipo","0" );
      ((Element)v.get(111)).setAttribute("estado","false" );
      ((Element)v.get(111)).setAttribute("alt","" );
      ((Element)v.get(111)).setAttribute("codigo","" );
      ((Element)v.get(111)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 110   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(112)).setAttribute("nombre","ava1" );
      ((Element)v.get(112)).setAttribute("x","52" );
      ((Element)v.get(112)).setAttribute("y","406" );
      ((Element)v.get(112)).setAttribute("ID","botonContenido" );
      ((Element)v.get(112)).setAttribute("img","avanzar_on" );
      ((Element)v.get(112)).setAttribute("tipo","0" );
      ((Element)v.get(112)).setAttribute("estado","false" );
      ((Element)v.get(112)).setAttribute("alt","" );
      ((Element)v.get(112)).setAttribute("codigo","" );
      ((Element)v.get(112)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(110)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:110   */
      /* Termina nodo:84   */

      /* Empieza nodo:113 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(113)).setAttribute("nombre","primera1" );
      ((Element)v.get(113)).setAttribute("x","20" );
      ((Element)v.get(113)).setAttribute("y","406" );
      ((Element)v.get(113)).setAttribute("ID","botonContenido" );
      ((Element)v.get(113)).setAttribute("img","primera_on" );
      ((Element)v.get(113)).setAttribute("tipo","-2" );
      ((Element)v.get(113)).setAttribute("estado","false" );
      ((Element)v.get(113)).setAttribute("alt","" );
      ((Element)v.get(113)).setAttribute("codigo","" );
      ((Element)v.get(113)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(114)).setAttribute("nombre","separa" );
      ((Element)v.get(114)).setAttribute("x","59" );
      ((Element)v.get(114)).setAttribute("y","402" );
      ((Element)v.get(114)).setAttribute("ID","botonContenido" );
      ((Element)v.get(114)).setAttribute("img","separa_base" );
      ((Element)v.get(114)).setAttribute("tipo","0" );
      ((Element)v.get(114)).setAttribute("estado","false" );
      ((Element)v.get(114)).setAttribute("alt","" );
      ((Element)v.get(114)).setAttribute("codigo","" );
      ((Element)v.get(114)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(115)).setAttribute("nombre","btnCrear" );
      ((Element)v.get(115)).setAttribute("x","80" );
      ((Element)v.get(115)).setAttribute("y","403" );
      ((Element)v.get(115)).setAttribute("ID","botonContenido" );
      ((Element)v.get(115)).setAttribute("tipo","html" );
      ((Element)v.get(115)).setAttribute("estado","false" );
      ((Element)v.get(115)).setAttribute("cod","835" );
      ((Element)v.get(115)).setAttribute("accion","accionCrear();" );
      ((Element)v.get(115)).setAttribute("ontab","focoComboNumero();" );
      ((Element)v.get(115)).setAttribute("onshtab","focoBotonBuscar();" );
      ((Element)v.get(7)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(116)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(116)).setAttribute("alto","12" );
      ((Element)v.get(116)).setAttribute("ancho","100%" );
      ((Element)v.get(116)).setAttribute("colorf","" );
      ((Element)v.get(116)).setAttribute("borde","0" );
      ((Element)v.get(116)).setAttribute("imagenf","" );
      ((Element)v.get(116)).setAttribute("repeat","" );
      ((Element)v.get(116)).setAttribute("padding","" );
      ((Element)v.get(116)).setAttribute("visibilidad","visible" );
      ((Element)v.get(116)).setAttribute("contravsb","" );
      ((Element)v.get(116)).setAttribute("x","0" );
      ((Element)v.get(116)).setAttribute("y","425" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(116)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:7   */


   }

}
