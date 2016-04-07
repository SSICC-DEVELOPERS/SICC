
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_comisiones_insertar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         

      getXML630(doc);
         

      getXML720(doc);
         

      getXML810(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_comisiones_insertar" );
      ((Element)v.get(0)).setAttribute("cod","0515" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar comisiones" );
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
      v.add(doc.createTextNode("\r \r\rfunction onLoadPag() {\r  DrdEnsanchaConMargenDcho('listado1',12);   \r  eval (ON_RSZ);  \r  ocultaCapas();  \r  configurarMenuSecundario(\"formulario\");           \r  onTabBotonBuscar();\r}  \r  \rfunction ocultaCapas(){	\r  document.all[\"Cplistado1\"].style.visibility='hidden';\r  document.all[\"CpLin1listado1\"].style.visibility='hidden';\r  document.all[\"CpLin2listado1\"].style.visibility='hidden';\r  document.all[\"CpLin3listado1\"].style.visibility='hidden';\r  document.all[\"CpLin4listado1\"].style.visibility='hidden';\r  document.all[\"separaDiv\"].style.visibility='hidden';\r  document.all[\"primera1Div\"].style.visibility='hidden';\r  document.all[\"ret1Div\"].style.visibility='hidden';\r  document.all[\"ava1Div\"].style.visibility='hidden';\r  document.all[\"btnAceptarDiv\"].style.visibility='hidden';\r}\r\rfunction muestraCapas() {\r  document.all[\"Cplistado1\"].style.visibility='';\r  document.all[\"CpLin1listado1\"].style.visibility='';\r  document.all[\"CpLin2listado1\"].style.visibility='';\r  document.all[\"CpLin3listado1\"].style.visibility='';\r  document.all[\"CpLin4listado1\"].style.visibility='';\r  document.all[\"separaDiv\"].style.visibility='';\r  document.all[\"primera1Div\"].style.visibility='';\r  document.all[\"ret1Div\"].style.visibility='';\r  document.all[\"ava1Div\"].style.visibility='';\r  document.all[\"btnAceptarDiv\"].style.visibility='';\r}\r\rfunction onTabBotonBuscar() {\r  var oculto = document.all[\"Cplistado1\"].style.visibility;\r  if(oculto=='hidden') {\r    focaliza(\"formulario.cbDescripcion\");\r  }\r  else {\r    focalizaBotonHTML_XY('btnAceptar');\r  }  \r}\r\rfunction onTabBotonAceptar() {\r  focaliza(\"formulario.cbDescripcion\");\r}\r\rfunction onShTabBotonAceptar() {\r  focalizaBotonHTML('botonContenido','btnBuscar');\r}\r\rfunction onShTabComboDescripcion() {\r  var oculto = document.all[\"Cplistado1\"].style.visibility;\r  if(oculto=='hidden') {\r    focalizaBotonHTML('botonContenido','btnBuscar');\r  }\r  else {\r    focalizaBotonHTML_XY('btnAceptar');\r  }  \r}\r\rfunction fLimpiar() {\r  ocultaCapas();\r  onTabBotonAceptar();\r}\r\rfunction onClickBuscar() {  \r  var arr = new Array();\r      arr[arr.length] = new Array(\"oidPlantilla\", get(\"formulario.cbDescripcion\",\"V\")+\"\");\r  arr[arr.length] = new Array(\"oidMarca\", get(\"formulario.cbMarca\")+\"\");\r  arr[arr.length] = new Array(\"oidCanal\", get(\"formulario.cbCanal\")+\"\");\r  arr[arr.length] = new Array(\"oidAcceso\", get(\"formulario.cbAcceso\")+\"\");\r  arr[arr.length] = new Array(\"oidPais\", get(\"formulario.varPais\")+\"\");\r  arr[arr.length] = new Array(\"oidIdioma\", get(\"formulario.varIdioma\")+\"\");  \r      \r  configurarPaginado(mipgndo,\"COMBuscarInsertarComisiones\", \"ConectorBuscarInsertarComisiones\",\"es.indra.sicc.dtos.com.DTOBuscarInsertarComisiones\",arr);\r  muestraCapas();\r}\r\rfunction onClickAceptar() {\r  if (listado1.numSelecc()!= 1) {\r    GestionarMensaje('1022',null,null,null);\r		return false;\r  }\r  else {  \r		var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);		\r    \r    var oidPlantilla = listado1.datos[posicion][0];\r    var canal = listado1.datos[posicion][4];\r    var varIndComparativo = listado1.datos[posicion][7];  \r    var varIndTratamientoDif = listado1.datos[posicion][8];  \r    var oidCanal = listado1.datos[posicion][10];  \r    var oidTipoPlantilla = listado1.datos[posicion][11];  \r    \r    if(varIndComparativo!=\"\") {\r      if(varIndComparativo==\"SI\") {\r        varIndComparativo = \"true\";\r      }\r      else {\r        varIndComparativo = \"false\";\r      } \r    }\r    else {\r        varIndComparativo = \"\";\r    }\r    \r    if(varIndTratamientoDif!=\"\") {\r      if(varIndTratamientoDif==\"SI\") {\r        varIndTratamientoDif = \"true\";\r      }\r      else {\r        varIndTratamientoDif = \"false\";\r      }\r    }\r    else {\r      varIndTratamientoDif = \"\";\r    }\r  \r    set(\"formulario.oidPlantilla\", oidPlantilla);\r    set(\"formulario.canal\", canal);\r    set(\"formulario.varIndComparativo\", varIndComparativo);\r    set(\"formulario.varIndTratamientoDif\", varIndTratamientoDif);\r    set(\"formulario.oidCanal\", oidCanal);\r    set(\"formulario.oidTipoPlantilla\", oidTipoPlantilla);\r      \r    set(\"formulario.conectorAction\", \"LPMantenimientoComisionesDatosGenerales\");\r    set(\"formulario.accion\", \"\");\r    set(\"formulario.opcionMenu\", \"insertar\");\r	\r    enviaSICC(\"formulario\");   \r  }\r}\r\rfunction obtenerPosicionListaEditable(clave, lista){\r  this.posicion = 0;\r  if (lista.codSeleccionados().length > 0){\r    for(var k=0;k<lista.datos.length;k++) {\r      if (lista.datos[k][0] == clave) {\r        posicion=k;\r        break;\r      }\r		}         \r	  return posicion;\r	}\r}\r\rfunction muestraLista(ultima, rowset, error){\r  var tamano = rowset.length;\r	\r  if (tamano > 0) {\r    muestraCapas();\r    eval (ON_RSZ);\r		onTabBotonAceptar();\r		return true;\r  }\r  else {\r    ocultaCapas();\r    onTabBotonAceptar();\r    return false;\r  }\r}\r\r \r"));
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
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","opcionMenu" );
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
      ((Element)v.get(13)).setAttribute("nombre","varPais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","varIdioma" );
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
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","canal" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","indComparativo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","indTratamientoDif" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidCanal" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidTipoPlantilla" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","varIndComparativo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","varIndTratamientoDif" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("nombre","capa1" );
      ((Element)v.get(7)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("table"));
      ((Element)v.get(24)).setAttribute("width","100%" );
      ((Element)v.get(24)).setAttribute("border","0" );
      ((Element)v.get(24)).setAttribute("cellspacing","0" );
      ((Element)v.get(24)).setAttribute("cellpadding","0" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("align","center" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","12" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","750" );
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(25)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(31)).setAttribute("height","1" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:25   */

      /* Empieza nodo:32 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(37)).setAttribute("class","legend" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(38)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(38)).setAttribute("alto","13" );
      ((Element)v.get(38)).setAttribute("filas","1" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(38)).setAttribute("id","legend" );
      ((Element)v.get(38)).setAttribute("cod","0075" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","100%" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("align","center" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("table"));
      ((Element)v.get(42)).setAttribute("width","574" );
      ((Element)v.get(42)).setAttribute("border","0" );
      ((Element)v.get(42)).setAttribute("align","left" );
      ((Element)v.get(42)).setAttribute("cellspacing","0" );
      ((Element)v.get(42)).setAttribute("cellpadding","0" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("colspan","4" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:46 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(50)).setAttribute("id","datosTitle" );
      ((Element)v.get(50)).setAttribute("cod","9" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","25" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("cod","6" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(46)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:46   */

      /* Empieza nodo:57 / Elemento padre: 42   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(57));

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(61)).setAttribute("nombre","cbDescripcion" );
      ((Element)v.get(61)).setAttribute("id","datosCampos" );
      ((Element)v.get(61)).setAttribute("size","1" );
      ((Element)v.get(61)).setAttribute("multiple","N" );
      ((Element)v.get(61)).setAttribute("req","N" );
      ((Element)v.get(61)).setAttribute("valorinicial","" );
      ((Element)v.get(61)).setAttribute("textoinicial","" );
      ((Element)v.get(61)).setAttribute("onshtab","onShTabComboDescripcion();" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:63 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","25" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(57)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(66)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(66)).setAttribute("id","datosCampos" );
      ((Element)v.get(66)).setAttribute("size","1" );
      ((Element)v.get(66)).setAttribute("multiple","N" );
      ((Element)v.get(66)).setAttribute("req","N" );
      ((Element)v.get(66)).setAttribute("valorinicial","" );
      ((Element)v.get(66)).setAttribute("textoinicial","" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:68 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","100%" );
      ((Element)v.get(57)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:57   */

      /* Empieza nodo:70 / Elemento padre: 42   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(42)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("colspan","4" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:73 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("table"));
      ((Element)v.get(75)).setAttribute("width","574" );
      ((Element)v.get(75)).setAttribute("border","0" );
      ((Element)v.get(75)).setAttribute("align","left" );
      ((Element)v.get(75)).setAttribute("cellspacing","0" );
      ((Element)v.get(75)).setAttribute("cellpadding","0" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","7" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","25" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("id","datosTitle" );
      ((Element)v.get(84)).setAttribute("cod","10" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","100%" );
      ((Element)v.get(76)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:76   */

      /* Empieza nodo:87 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(87)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(91)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(91)).setAttribute("id","datosCampos" );
      ((Element)v.get(91)).setAttribute("size","1" );
      ((Element)v.get(91)).setAttribute("multiple","N" );
      ((Element)v.get(91)).setAttribute("req","N" );
      ((Element)v.get(91)).setAttribute("valorinicial","" );
      ((Element)v.get(91)).setAttribute("textoinicial","" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:93 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","25" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(87)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(96)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(96)).setAttribute("id","datosCampos" );
      ((Element)v.get(96)).setAttribute("size","1" );
      ((Element)v.get(96)).setAttribute("multiple","N" );
      ((Element)v.get(96)).setAttribute("req","N" );
      ((Element)v.get(96)).setAttribute("valorinicial","" );
      ((Element)v.get(96)).setAttribute("textoinicial","" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:98 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(87)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:87   */

      /* Empieza nodo:100 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("colspan","4" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:39   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:103 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:32   */

      /* Empieza nodo:105 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("table"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(110)).setAttribute("border","0" );
      ((Element)v.get(110)).setAttribute("align","center" );
      ((Element)v.get(110)).setAttribute("cellspacing","0" );
      ((Element)v.get(110)).setAttribute("cellpadding","0" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("class","botonera" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(113)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(113)).setAttribute("ID","botonContenido" );
      ((Element)v.get(113)).setAttribute("tipo","html" );
      ((Element)v.get(113)).setAttribute("estado","false" );
      ((Element)v.get(113)).setAttribute("cod","1" );
      ((Element)v.get(113)).setAttribute("ontab","onTabBotonBuscar();" );
      ((Element)v.get(113)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:114 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","12" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:105   */

      /* Empieza nodo:116 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","12" );
      ((Element)v.get(117)).setAttribute("align","center" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","12" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(118)).setAttribute("height","12" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("width","750" );
      ((Element)v.get(116)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","12" );
      ((Element)v.get(116)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","12" );
      ((Element)v.get(122)).setAttribute("height","1" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:116   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:123 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(123)).setAttribute("nombre","listado1" );
      ((Element)v.get(123)).setAttribute("ancho","578" );
      ((Element)v.get(123)).setAttribute("alto","317" );
      ((Element)v.get(123)).setAttribute("x","12" );
      ((Element)v.get(123)).setAttribute("y","163" );
      ((Element)v.get(123)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(123)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(124)).setAttribute("precarga","S" );
      ((Element)v.get(124)).setAttribute("conROver","S" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(125)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(125)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(125)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(125)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 124   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(126)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(126)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(126)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(126)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(124)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(127)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(127)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(124)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:124   */

      /* Empieza nodo:128 / Elemento padre: 123   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(123)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(129)).setAttribute("borde","1" );
      ((Element)v.get(129)).setAttribute("horizDatos","1" );
      ((Element)v.get(129)).setAttribute("horizCabecera","1" );
      ((Element)v.get(129)).setAttribute("vertical","0" );
      ((Element)v.get(129)).setAttribute("horizTitulo","1" );
      ((Element)v.get(129)).setAttribute("horizBase","1" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 128   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(130)).setAttribute("borde","#999999" );
      ((Element)v.get(130)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(130)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(130)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(130)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(130)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(130)).setAttribute("horizBase","#999999" );
      ((Element)v.get(128)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:128   */

      /* Empieza nodo:131 / Elemento padre: 123   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(131)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(131)).setAttribute("alto","22" );
      ((Element)v.get(131)).setAttribute("imgFondo","" );
      ((Element)v.get(131)).setAttribute("cod","00135" );
      ((Element)v.get(131)).setAttribute("ID","datosTitle" );
      ((Element)v.get(123)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 123   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(132)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(132)).setAttribute("alto","22" );
      ((Element)v.get(132)).setAttribute("imgFondo","" );
      ((Element)v.get(123)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 123   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(133)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(133)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(133)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(133)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(133)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(133)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(123)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("ancho","100" );
      ((Element)v.get(134)).setAttribute("minimizable","S" );
      ((Element)v.get(134)).setAttribute("minimizada","N" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(135)).setAttribute("ancho","100" );
      ((Element)v.get(135)).setAttribute("minimizable","S" );
      ((Element)v.get(135)).setAttribute("minimizada","N" );
      ((Element)v.get(135)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(133)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("ancho","100" );
      ((Element)v.get(136)).setAttribute("minimizable","S" );
      ((Element)v.get(136)).setAttribute("minimizada","N" );
      ((Element)v.get(133)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("ancho","100" );
      ((Element)v.get(137)).setAttribute("minimizable","S" );
      ((Element)v.get(137)).setAttribute("minimizada","N" );
      ((Element)v.get(133)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("ancho","100" );
      ((Element)v.get(138)).setAttribute("minimizable","S" );
      ((Element)v.get(138)).setAttribute("minimizada","N" );
      ((Element)v.get(138)).setAttribute("orden","numerico" );
      ((Element)v.get(133)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("ancho","100" );
      ((Element)v.get(139)).setAttribute("minimizable","S" );
      ((Element)v.get(139)).setAttribute("minimizada","N" );
      ((Element)v.get(133)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("ancho","100" );
      ((Element)v.get(140)).setAttribute("minimizable","S" );
      ((Element)v.get(140)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(133)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("ancho","140" );
      ((Element)v.get(141)).setAttribute("minimizable","S" );
      ((Element)v.get(141)).setAttribute("minimizada","N" );
      ((Element)v.get(133)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("ancho","100" );
      ((Element)v.get(142)).setAttribute("minimizable","S" );
      ((Element)v.get(142)).setAttribute("minimizada","N" );
      ((Element)v.get(133)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("ancho","140" );
      ((Element)v.get(143)).setAttribute("minimizable","S" );
      ((Element)v.get(143)).setAttribute("minimizada","N" );
      ((Element)v.get(143)).setAttribute("oculta","S" );
      ((Element)v.get(133)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("ancho","100" );
      ((Element)v.get(144)).setAttribute("minimizable","S" );
      ((Element)v.get(144)).setAttribute("minimizada","N" );
      ((Element)v.get(144)).setAttribute("oculta","S" );
      ((Element)v.get(133)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("ancho","140" );
      ((Element)v.get(145)).setAttribute("minimizable","S" );
      ((Element)v.get(145)).setAttribute("minimizada","N" );
      ((Element)v.get(145)).setAttribute("oculta","S" );
      ((Element)v.get(133)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:133   */

      /* Empieza nodo:146 / Elemento padre: 123   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(146)).setAttribute("alto","20" );
      ((Element)v.get(146)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(146)).setAttribute("imgFondo","" );
      ((Element)v.get(146)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(123)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("colFondo","" );
      ((Element)v.get(147)).setAttribute("ID","EstCab" );
      ((Element)v.get(147)).setAttribute("cod","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("colFondo","" );
      ((Element)v.get(148)).setAttribute("ID","EstCab" );
      ((Element)v.get(148)).setAttribute("cod","9" );
      ((Element)v.get(146)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("colFondo","" );
      ((Element)v.get(149)).setAttribute("ID","EstCab" );
      ((Element)v.get(149)).setAttribute("cod","6" );
      ((Element)v.get(146)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("colFondo","" );
      ((Element)v.get(150)).setAttribute("ID","EstCab" );
      ((Element)v.get(150)).setAttribute("cod","7" );
      ((Element)v.get(146)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("colFondo","" );
      ((Element)v.get(151)).setAttribute("ID","EstCab" );
      ((Element)v.get(151)).setAttribute("cod","10" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(146)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("colFondo","" );
      ((Element)v.get(152)).setAttribute("ID","EstCab" );
      ((Element)v.get(152)).setAttribute("cod","1857" );
      ((Element)v.get(146)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("colFondo","" );
      ((Element)v.get(153)).setAttribute("ID","EstCab" );
      ((Element)v.get(153)).setAttribute("cod","1719" );
      ((Element)v.get(146)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("colFondo","" );
      ((Element)v.get(154)).setAttribute("ID","EstCab" );
      ((Element)v.get(154)).setAttribute("cod","1720" );
      ((Element)v.get(146)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("colFondo","" );
      ((Element)v.get(155)).setAttribute("ID","EstCab" );
      ((Element)v.get(155)).setAttribute("cod","400" );
      ((Element)v.get(146)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("colFondo","" );
      ((Element)v.get(156)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("colFondo","" );
      ((Element)v.get(157)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("colFondo","" );
      ((Element)v.get(158)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:146   */

      /* Empieza nodo:159 / Elemento padre: 123   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(159)).setAttribute("alto","22" );
      ((Element)v.get(159)).setAttribute("accion","" );
      ((Element)v.get(159)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(159)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(159)).setAttribute("maxSel","1" );
      ((Element)v.get(159)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(159)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(159)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(159)).setAttribute("onLoad","" );
      ((Element)v.get(159)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(123)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("tipo","texto" );
      ((Element)v.get(160)).setAttribute("ID","EstDat" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("tipo","texto" );
      ((Element)v.get(161)).setAttribute("ID","EstDat2" );
      ((Element)v.get(159)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("tipo","texto" );
      ((Element)v.get(162)).setAttribute("ID","EstDat" );
      ((Element)v.get(159)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("tipo","texto" );
      ((Element)v.get(163)).setAttribute("ID","EstDat2" );
      ((Element)v.get(159)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("tipo","texto" );
      ((Element)v.get(164)).setAttribute("ID","EstDat" );
      ((Element)v.get(159)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("tipo","texto" );
      ((Element)v.get(165)).setAttribute("ID","EstDat2" );
      ((Element)v.get(159)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("tipo","texto" );
      ((Element)v.get(166)).setAttribute("ID","EstDat" );
      ((Element)v.get(159)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("tipo","texto" );
      ((Element)v.get(167)).setAttribute("ID","EstDat2" );
      ((Element)v.get(159)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("tipo","texto" );
      ((Element)v.get(168)).setAttribute("ID","EstDat" );
      ((Element)v.get(159)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("tipo","texto" );
      ((Element)v.get(169)).setAttribute("ID","EstDat2" );
      ((Element)v.get(159)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("tipo","texto" );
      ((Element)v.get(170)).setAttribute("ID","EstDat" );
      ((Element)v.get(159)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 159   */
      v.add(doc.createElement("COL"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(171)).setAttribute("tipo","texto" );
      ((Element)v.get(171)).setAttribute("ID","EstDat2" );
      ((Element)v.get(159)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:159   */

      /* Empieza nodo:172 / Elemento padre: 123   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(123)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 123   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(173)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(173)).setAttribute("ancho","578" );
      ((Element)v.get(173)).setAttribute("sep","$" );
      ((Element)v.get(173)).setAttribute("x","12" );
      ((Element)v.get(173)).setAttribute("class","botonera" );
      ((Element)v.get(173)).setAttribute("y","457" );
      ((Element)v.get(173)).setAttribute("control","|" );
      ((Element)v.get(173)).setAttribute("conector","" );
      ((Element)v.get(173)).setAttribute("rowset","" );
      ((Element)v.get(173)).setAttribute("cargainicial","N" );
      ((Element)v.get(173)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(123)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(174)).setAttribute("nombre","ret1" );
      ((Element)v.get(174)).setAttribute("x","37" );
      ((Element)v.get(174)).setAttribute("y","461" );
      ((Element)v.get(174)).setAttribute("ID","botonContenido" );
      ((Element)v.get(174)).setAttribute("img","retroceder_on" );
      ((Element)v.get(174)).setAttribute("tipo","0" );
      ((Element)v.get(174)).setAttribute("estado","false" );
      ((Element)v.get(174)).setAttribute("alt","" );
      ((Element)v.get(174)).setAttribute("codigo","" );
      ((Element)v.get(174)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 173   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(175)).setAttribute("nombre","ava1" );
      ((Element)v.get(175)).setAttribute("x","52" );
      ((Element)v.get(175)).setAttribute("y","461" );
      ((Element)v.get(175)).setAttribute("ID","botonContenido" );
      ((Element)v.get(175)).setAttribute("img","avanzar_on" );
      ((Element)v.get(175)).setAttribute("tipo","0" );
      ((Element)v.get(175)).setAttribute("estado","false" );
      ((Element)v.get(175)).setAttribute("alt","" );
      ((Element)v.get(175)).setAttribute("codigo","" );
      ((Element)v.get(175)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(173)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:173   */
      /* Termina nodo:123   */

      /* Empieza nodo:176 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(176)).setAttribute("nombre","primera1" );
      ((Element)v.get(176)).setAttribute("x","20" );
      ((Element)v.get(176)).setAttribute("y","461" );
      ((Element)v.get(176)).setAttribute("ID","botonContenido" );
      ((Element)v.get(176)).setAttribute("img","primera_on" );
      ((Element)v.get(176)).setAttribute("tipo","-2" );
      ((Element)v.get(176)).setAttribute("estado","false" );
      ((Element)v.get(176)).setAttribute("alt","" );
      ((Element)v.get(176)).setAttribute("codigo","" );
      ((Element)v.get(176)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(177)).setAttribute("nombre","separa" );
      ((Element)v.get(177)).setAttribute("x","59" );
      ((Element)v.get(177)).setAttribute("y","457" );
      ((Element)v.get(177)).setAttribute("ID","botonContenido" );
      ((Element)v.get(177)).setAttribute("img","separa_base" );
      ((Element)v.get(177)).setAttribute("tipo","0" );
      ((Element)v.get(177)).setAttribute("estado","false" );
      ((Element)v.get(177)).setAttribute("alt","" );
      ((Element)v.get(177)).setAttribute("codigo","" );
      ((Element)v.get(177)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(178)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(178)).setAttribute("x","80" );
      ((Element)v.get(178)).setAttribute("y","458" );
      ((Element)v.get(178)).setAttribute("ID","botonContenido" );
      ((Element)v.get(178)).setAttribute("tipo","html" );
      ((Element)v.get(178)).setAttribute("estado","false" );
      ((Element)v.get(178)).setAttribute("cod","12" );
      ((Element)v.get(178)).setAttribute("accion","onClickAceptar();" );
      ((Element)v.get(178)).setAttribute("ontab","onTabBotonAceptar();" );
      ((Element)v.get(178)).setAttribute("onshtab","onShTabBotonAceptar();" );
      ((Element)v.get(7)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(179)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(179)).setAttribute("alto","12" );
      ((Element)v.get(179)).setAttribute("ancho","100%" );
      ((Element)v.get(179)).setAttribute("colorf","" );
      ((Element)v.get(179)).setAttribute("borde","0" );
      ((Element)v.get(179)).setAttribute("imagenf","" );
      ((Element)v.get(179)).setAttribute("repeat","" );
      ((Element)v.get(179)).setAttribute("padding","" );
      ((Element)v.get(179)).setAttribute("visibilidad","visible" );
      ((Element)v.get(179)).setAttribute("contravsb","" );
      ((Element)v.get(179)).setAttribute("x","0" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(179)).setAttribute("y","480" );
      ((Element)v.get(179)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:7   */


   }

}
