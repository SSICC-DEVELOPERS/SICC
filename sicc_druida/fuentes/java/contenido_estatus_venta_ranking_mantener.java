
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_estatus_venta_ranking_mantener  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_estatus_venta_ranking_mantener" );
      ((Element)v.get(0)).setAttribute("cod","0507" );
      ((Element)v.get(0)).setAttribute("titulo","Mantener estatus de venta" );
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
      ((Element)v.get(4)).setAttribute("src","pestanyas_concurso_ranking_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r \r\rfunction onLoadPag()   {  \r         DrdEnsanchaConMargenDcho('listado1',12);\r         document.all[\"Cplistado1\"].style.visibility='';\r         document.all[\"CpLin1listado1\"].style.visibility='';\r         document.all[\"CpLin2listado1\"].style.visibility='';\r         document.all[\"CpLin3listado1\"].style.visibility='';\r         document.all[\"CpLin4listado1\"].style.visibility='';\r         document.all[\"separaDiv\"].style.visibility='hidden';\r         document.all[\"primera1Div\"].style.visibility='hidden';\r         document.all[\"ret1Div\"].style.visibility='hidden';\r         document.all[\"ava1Div\"].style.visibility='hidden';\r         document.all[\"btnAceptar1Div\"].style.visibility='';\r         eval (ON_RSZ);  \r         \r         configurarMenuSecundario('formulario');\r         \r         btnProxy(1,'0');\r        \r        if (get(\"formulario.opcionMenu\") == \"Modificar Concurso Ranking\"){\r            btnProxy(2,'1');\r            btnProxy(7, 0);\r			btnProxy(8, 0);\r			btnProxy(9, 0);\r        }\r        \r         if ( get('formulario.hidLstEstatusVta')!= null ) {\r             var listaItems = get('formulario.hidLstEstatusVta');\r         }         \r         actualizaListado(listaItems);             \r         \r         if ( get('formulario.opcionMenu') == 'Consultar Concurso Ranking') {\r             deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');             \r             document.getElementById(\"btnAceptar1\").disabled = true;	         \r             document.getElementById(\"cbEstatusVentaMAE\").disabled = true;	         \r             document.getElementById(\"cbPeriodoDesde\").disabled = true;	         \r             document.getElementById(\"cbPeriodoHasta\").disabled = true;	  \r                           \r             btnProxy(2,'1');\r			 btnProxy(4, 0);			\r			 btnProxy(5, 0);\r			 btnProxy(7, 0);\r			 btnProxy(8, 0);\r			 btnProxy(9, 0);\r          }\r           else {\r                 focaliza('formulario.cbEstatusVentaMAE');\r           }\r     }\r   \r   function accionAniadir()\r   {\r         var vOidEstatusVtaMae = get('formulario.cbEstatusVentaMAE','V');        \r         var vOidPeridoD  = get('formulario.cbPeriodoDesde','V');\r         var vOidPeridoH  = get('formulario.cbPeriodoHasta','V');         \r         var vEstatusVtaMae = get('formulario.cbEstatusVentaMAE','T');\r         var vPeridoD  = get('formulario.cbPeriodoDesde','T');\r         var vPeridoH  = get('formulario.cbPeriodoHasta','T');\r         \r         if(sicc_validaciones_generales(\"g1\")){\r							if(vPeridoH==null || vPeridoH==\"\"){\r					vOidPeridoH = vOidPeridoD;\r					vPeridoH = vPeridoD;\r				}\r         \r             var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);\r             var codigo = listado1.generaCodigo( posi );\r             var datos = codigo + \"|\" + null ;  \r             \r             datos = datos + \"|\" + vOidEstatusVtaMae + \"|\" + vOidPeridoD + \"|\" + vOidPeridoH;\r            \r             datos = datos + \"|\" + vEstatusVtaMae + \"|\" + vPeridoD + \"|\" + vPeridoH;\r           \r             if (!existeFila(datos))\r             {\r                  var newRow = new Array();\r                  newRow = datos.split(\"|\");\r                  \r                  listado1.insertar(newRow);                  \r                  set('formulario.hidUltimoElementoEnLaLista', codigo);\r                  \r                  seteaCombosAniadir();\r   \r              }else{              \r              }                           \r         }    \r    }   \r   \r   function accionAceptar()\r   {\r         var datosAplanados = listado1Tostring();   \r         var arr = new Array();\r         arr[0] = datosAplanados;\r         arr[1] = listado1.datos;  \r         set(\"formulario.hidLstEstatusVta\", arr); \r         \r         returnValue = arr;         \r         close();\r   }\r   \r   function fBorrar()\r   {\r         accionEliminar();\r   }\r   \r   function actualizaListado(listaItems){\r                           var fila = listaItems.split('$');\r                  for(i=0;i<fila.length;i++){\r                           if (fila[i] != ''){\r                                                      var newRow = new Array();\r                                    newRow = fila[i].split(\"|\");\r                                    listado1.insertar(newRow);\r                           }\r                  }\r         }\r   \r    function listado1Tostring(){      \r         var codigo = listado1.codigos();\r                  var total = \"\";\r         lon = listado1.datos.length\r                  for(var a = 0; a < lon ; a++){\r                                                          \r             var toAdd = \"\";\r             toAdd = \"oid:\"+ codigo[a];\r             \r                           if(listado1.extraeDato(codigo[a], 0)!= null && listado1.extraeDato(codigo[a], 0)!=\"\")\r                                    toAdd = toAdd + \"|\" + \"oEv:\" + listado1.extraeDato(codigo[a], 0);                      \r             if(listado1.extraeDato(codigo[a], 1)!= null && listado1.extraeDato(codigo[a], 1)!=\"\")\r                                    toAdd = toAdd + \"|\" + \"oEM:\" + listado1.extraeDato(codigo[a], 1);                 if(listado1.extraeDato(codigo[a], 2)!= null && listado1.extraeDato(codigo[a], 2)!=\"\")\r                                    toAdd = toAdd + \"|\" + \"oPd:\" + listado1.extraeDato(codigo[a], 2);                               if(listado1.extraeDato(codigo[a], 3)!= null && listado1.extraeDato(codigo[a], 3)!=\"\")\r                                    toAdd = toAdd + \"|\" + \"oPh:\"  + listado1.extraeDato(codigo[a], 3);                               if(listado1.extraeDato(codigo[a], 4)!= null && listado1.extraeDato(codigo[a], 4)!=\"\")\r                  toAdd = toAdd + \"|\" + \"dEv:\"  + listado1.extraeDato(codigo[a], 4);                      \r                           if(listado1.extraeDato(codigo[a], 5)!= null && listado1.extraeDato(codigo[a], 5)!=\"\")\r                  toAdd = toAdd + \"|\" + \"dPd:\"  + listado1.extraeDato(codigo[a], 5);                               if(listado1.extraeDato(codigo[a], 6)!= null && listado1.extraeDato(codigo[a], 6)!=\"\")\r                  toAdd = toAdd + \"|\" + \"dPh:\"  + listado1.extraeDato(codigo[a], 6);    \r                           total = total + \"$\" + toAdd;\r      \r      \r                  }		\r                  return total;\r         }\r    \r    function accionEliminar()\r    {\r\r         var vMostrarMensaje ='';\r         var cantElementosL1 = listado1.codSeleccionados();                \r         \r         if ( cantElementosL1.length == 0){\r             GestionarMensaje(\"4\", null, null, null);\r             return;\r         }\r         if ( cantElementosL1.length > 0 )\r             listado1.eliminarSelecc();\r    }\r    \r    function fBorrar()\r    {\r         accionEliminar();\r         focaliza(\"cbEstatusVentaMAE\");\r         \r    }\r   \r    function fVolver()\r    {\r         window.close();\r    }\r    \r    \r    function existeFila(datos)\r    {\r         listado1.actualizaDat();\r         var codigo =\"\";\r         \r         var dat = listado1.datos;\r          \r         if (listado1.codigos() !=\"\")\r            codigo = listado1.codigos(); \r             \r         var newRow = new Array();\r         newRow = datos.split(\"|\");\r         \r         var flag = false;\r         var a = 0;\r         \r         var dato1= newRow[2];\r         var dato2= newRow[3];\r         var dato3= newRow[4];\r         \r         if (dat != \"\"){\r             var datoLista1 = listado1.extraeDato(codigo[a], 1);         \r             var datoLista2 = listado1.extraeDato(codigo[a], 2);\r             var datoLista3 = listado1.extraeDato(codigo[a], 3);\r            \r             if ((dato1 == datoLista1) && (dato2 == datoLista2) && (dato3 == datoLista3)){\r                  \r				  set(\"formulario.cbEstatusVentaMAE\",\" \"); \r                  set(\"formulario.cbPeriodoDesde\",\" \"); \r                  set(\"formulario.cbPeriodoHasta\",\" \");      \r\r                  focaliza(\"formulario.cbEstatusVentaMAE\");\r                  \r                  flag = true;\r             }else{\r             }\r             \r         }\r         return flag;\r    }\r  \r    \r    \r    function seteaCombosAniadir(){\r        set(\"formulario.cbEstatusVentaMAE\",\" \"); \r		set(\"formulario.cbPeriodoDesde\",\" \"); \r		set(\"formulario.cbPeriodoHasta\",\" \");      \r		 \r		focaliza(\"formulario.cbEstatusVentaMAE\");      \r   \r    }\r    \r    \r    function fLimpiar(){\r	  if(get('formulario.opcionMenu')!=\"Modificar Concurso Ranking\"){   \r		  set(\"formulario.cbEstatusVentaMAE\",\" \");\r		  set(\"formulario.cbPeriodoDesde\",\" \"); \r		  set(\"formulario.cbPeriodoHasta\",\" \"); \r					  \r		  focaliza(\"formulario.cbEstatusVentaMAE\");\r		\r	  } else { \r			set('formulario.conectorAction', 'LPMantenerParametrosConsultorasRanking');  \r			set('formulario.accion', 'cargar estatus venta ranking'); \r			eval('formulario').oculto = 'N'; \r			enviaSICC('formulario',null,null,'N'); \r	  } \r    \r    }\r\r    \r \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbEstatusVentaMAE" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","1705" );
      ((Element)v.get(8)).setAttribute("group","g1" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbPeriodoDesde" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1175" );
      ((Element)v.get(9)).setAttribute("group","g1" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:7   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidLstEstatusVta" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidUltimoElementoEnLaLista" );
      ((Element)v.get(15)).setAttribute("valor","1" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("table"));
      ((Element)v.get(16)).setAttribute("width","100%" );
      ((Element)v.get(16)).setAttribute("border","0" );
      ((Element)v.get(16)).setAttribute("cellspacing","0" );
      ((Element)v.get(16)).setAttribute("cellpadding","0" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));

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
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).setAttribute("width","12" );
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
      ((Element)v.get(30)).setAttribute("nombre","lblDatos" );
      ((Element)v.get(30)).setAttribute("alto","13" );
      ((Element)v.get(30)).setAttribute("filas","1" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(30)).setAttribute("id","legend" );
      ((Element)v.get(30)).setAttribute("cod","00282" );
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
      ((Element)v.get(34)).setAttribute("width","426" );
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
      ((Element)v.get(42)).setAttribute("nombre","lblEstatusVentaMAE" );
      ((Element)v.get(42)).setAttribute("alto","13" );
      ((Element)v.get(42)).setAttribute("filas","1" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(42)).setAttribute("id","datosTitle" );
      ((Element)v.get(42)).setAttribute("cod","1705" );
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
      ((Element)v.get(46)).setAttribute("nombre","lblPeriodoDesde" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(46)).setAttribute("id","datosTitle" );
      ((Element)v.get(46)).setAttribute("cod","1175" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 38   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","25" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lblPeriodoHasta" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(50)).setAttribute("id","datosTitle" );
      ((Element)v.get(50)).setAttribute("cod","1176" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","100%" );
      ((Element)v.get(38)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:38   */

      /* Empieza nodo:53 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(53)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(57)).setAttribute("nombre","cbEstatusVentaMAE" );
      ((Element)v.get(57)).setAttribute("id","datosCampos" );
      ((Element)v.get(57)).setAttribute("size","1" );
      ((Element)v.get(57)).setAttribute("multiple","N" );
      ((Element)v.get(57)).setAttribute("req","S" );
      ((Element)v.get(57)).setAttribute("valorinicial","" );
      ((Element)v.get(57)).setAttribute("textoinicial","" );
      ((Element)v.get(57)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAceptar1');" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:59 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","25" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(53)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(62)).setAttribute("nombre","cbPeriodoDesde" );
      ((Element)v.get(62)).setAttribute("id","datosCampos" );
      ((Element)v.get(62)).setAttribute("size","1" );
      ((Element)v.get(62)).setAttribute("multiple","N" );
      ((Element)v.get(62)).setAttribute("req","S" );
      ((Element)v.get(62)).setAttribute("valorinicial","" );
      ((Element)v.get(62)).setAttribute("textoinicial","" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:64 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","25" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(53)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(67)).setAttribute("nombre","cbPeriodoHasta" );
      ((Element)v.get(67)).setAttribute("id","datosCampos" );
      ((Element)v.get(67)).setAttribute("size","1" );
      ((Element)v.get(67)).setAttribute("multiple","N" );
      ((Element)v.get(67)).setAttribute("req","N" );
      ((Element)v.get(67)).setAttribute("valorinicial","" );
      ((Element)v.get(67)).setAttribute("textoinicial","" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:69 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","100%" );
      ((Element)v.get(53)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:53   */

      /* Empieza nodo:71 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("colspan","4" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:74 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:24   */

      /* Empieza nodo:76 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("table"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(81)).setAttribute("border","0" );
      ((Element)v.get(81)).setAttribute("align","center" );
      ((Element)v.get(81)).setAttribute("cellspacing","0" );
      ((Element)v.get(81)).setAttribute("cellpadding","0" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("class","botonera" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(84)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(84)).setAttribute("ID","botonContenido" );
      ((Element)v.get(84)).setAttribute("tipo","html" );
      ((Element)v.get(84)).setAttribute("accion","accionAniadir();" );
      ((Element)v.get(84)).setAttribute("estado","false" );
      ((Element)v.get(84)).setAttribute("cod","404" );
      ((Element)v.get(84)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnAceptar1');" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:85 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","12" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:76   */

      /* Empieza nodo:87 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","12" );
      ((Element)v.get(88)).setAttribute("align","center" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","12" );
      ((Element)v.get(89)).setAttribute("height","12" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","756" );
      ((Element)v.get(87)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","12" );
      ((Element)v.get(87)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","12" );
      ((Element)v.get(93)).setAttribute("height","1" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:87   */
      /* Termina nodo:16   */

      /* Empieza nodo:94 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(94)).setAttribute("nombre","listado1" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(94)).setAttribute("ancho","430" );
      ((Element)v.get(94)).setAttribute("alto","301" );
      ((Element)v.get(94)).setAttribute("x","12" );
      ((Element)v.get(94)).setAttribute("y","126" );
      ((Element)v.get(94)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(94)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(95)).setAttribute("precarga","S" );
      ((Element)v.get(95)).setAttribute("conROver","S" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(96)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(96)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(96)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(96)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 95   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(97)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(97)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(97)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(97)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(95)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(98)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(98)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(95)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:95   */

      /* Empieza nodo:99 / Elemento padre: 94   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(94)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(100)).setAttribute("borde","1" );
      ((Element)v.get(100)).setAttribute("horizDatos","1" );
      ((Element)v.get(100)).setAttribute("horizCabecera","1" );
      ((Element)v.get(100)).setAttribute("vertical","0" );
      ((Element)v.get(100)).setAttribute("horizTitulo","1" );
      ((Element)v.get(100)).setAttribute("horizBase","1" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 99   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(101)).setAttribute("borde","#999999" );
      ((Element)v.get(101)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(101)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(101)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(101)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(101)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(101)).setAttribute("horizBase","#999999" );
      ((Element)v.get(99)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:99   */

      /* Empieza nodo:102 / Elemento padre: 94   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(102)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(102)).setAttribute("alto","22" );
      ((Element)v.get(102)).setAttribute("imgFondo","" );
      ((Element)v.get(102)).setAttribute("cod","00317" );
      ((Element)v.get(102)).setAttribute("ID","datosTitle" );
      ((Element)v.get(94)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 94   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(103)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(103)).setAttribute("alto","22" );
      ((Element)v.get(103)).setAttribute("imgFondo","" );
      ((Element)v.get(94)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 94   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(104)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(104)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(104)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(104)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(104)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(104)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(94)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("ancho","30" );
      ((Element)v.get(105)).setAttribute("minimizable","S" );
      ((Element)v.get(105)).setAttribute("minimizada","N" );
      ((Element)v.get(105)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("ancho","30" );
      ((Element)v.get(106)).setAttribute("minimizable","S" );
      ((Element)v.get(106)).setAttribute("minimizada","N" );
      ((Element)v.get(106)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","30" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
      ((Element)v.get(107)).setAttribute("minimizada","N" );
      ((Element)v.get(107)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("ancho","30" );
      ((Element)v.get(108)).setAttribute("minimizable","S" );
      ((Element)v.get(108)).setAttribute("minimizada","N" );
      ((Element)v.get(108)).setAttribute("oculta","S" );
      ((Element)v.get(104)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 104   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("ancho","10" );
      ((Element)v.get(109)).setAttribute("minimizable","S" );
      ((Element)v.get(109)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("ancho","5" );
      ((Element)v.get(110)).setAttribute("minimizable","S" );
      ((Element)v.get(110)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("ancho","5" );
      ((Element)v.get(111)).setAttribute("minimizable","S" );
      ((Element)v.get(111)).setAttribute("minimizada","N" );
      ((Element)v.get(104)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:104   */

      /* Empieza nodo:112 / Elemento padre: 94   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(112)).setAttribute("alto","20" );
      ((Element)v.get(112)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(112)).setAttribute("imgFondo","" );
      ((Element)v.get(112)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(94)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("colFondo","" );
      ((Element)v.get(113)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Elemento padre:113 / Elemento actual: 114   */
      v.add(doc.createTextNode("oidStatusVta"));
      ((Element)v.get(113)).appendChild((Text)v.get(114));

      /* Termina nodo Texto:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("colFondo","" );
      ((Element)v.get(115)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).appendChild((Element)v.get(115));

      /* Elemento padre:115 / Elemento actual: 116   */
      v.add(doc.createTextNode("oidStatusVtaMAE"));
      ((Element)v.get(115)).appendChild((Text)v.get(116));

      /* Termina nodo Texto:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("colFondo","" );
      ((Element)v.get(117)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).appendChild((Element)v.get(117));

      /* Elemento padre:117 / Elemento actual: 118   */
      v.add(doc.createTextNode("oidPeriodoDesde"));
      ((Element)v.get(117)).appendChild((Text)v.get(118));

      /* Termina nodo Texto:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("colFondo","" );
      ((Element)v.get(119)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).appendChild((Element)v.get(119));

      /* Elemento padre:119 / Elemento actual: 120   */
      v.add(doc.createTextNode("oidPeriodoHasta"));
      ((Element)v.get(119)).appendChild((Text)v.get(120));

      /* Termina nodo Texto:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("colFondo","" );
      ((Element)v.get(121)).setAttribute("ID","EstCab" );
      ((Element)v.get(121)).setAttribute("align","center" );
      ((Element)v.get(121)).setAttribute("cod","1705" );
      ((Element)v.get(112)).appendChild((Element)v.get(121));

      /* Elemento padre:121 / Elemento actual: 122   */
      v.add(doc.createTextNode("Estatus venta MAE"));
      ((Element)v.get(121)).appendChild((Text)v.get(122));

      /* Termina nodo Texto:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("colFondo","" );
      ((Element)v.get(123)).setAttribute("ID","EstCab" );
      ((Element)v.get(123)).setAttribute("cod","1175" );
      ((Element)v.get(112)).appendChild((Element)v.get(123));

      /* Elemento padre:123 / Elemento actual: 124   */
      v.add(doc.createTextNode("Período desde"));
      ((Element)v.get(123)).appendChild((Text)v.get(124));

      /* Termina nodo Texto:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("colFondo","" );
      ((Element)v.get(125)).setAttribute("ID","EstCab" );
      ((Element)v.get(125)).setAttribute("cod","1176" );
      ((Element)v.get(112)).appendChild((Element)v.get(125));

      /* Elemento padre:125 / Elemento actual: 126   */
      v.add(doc.createTextNode("Período hasta"));
      ((Element)v.get(125)).appendChild((Text)v.get(126));

      /* Termina nodo Texto:126   */
      /* Termina nodo:125   */
      /* Termina nodo:112   */

      /* Empieza nodo:127 / Elemento padre: 94   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(127)).setAttribute("alto","22" );
      ((Element)v.get(127)).setAttribute("accion","" );
      ((Element)v.get(127)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(127)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(127)).setAttribute("maxSel","-1" );
      ((Element)v.get(127)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(127)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(127)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(127)).setAttribute("onLoad","" );
      ((Element)v.get(127)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(94)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","texto" );
      ((Element)v.get(128)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("tipo","texto" );
      ((Element)v.get(129)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("tipo","texto" );
      ((Element)v.get(130)).setAttribute("ID","EstDat2" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(127)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("tipo","texto" );
      ((Element)v.get(131)).setAttribute("ID","EstDat2" );
      ((Element)v.get(127)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("tipo","texto" );
      ((Element)v.get(132)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("tipo","texto" );
      ((Element)v.get(133)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 127   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("tipo","texto" );
      ((Element)v.get(134)).setAttribute("ID","EstDat" );
      ((Element)v.get(127)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:127   */

      /* Empieza nodo:135 / Elemento padre: 94   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(94)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 94   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(136)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(136)).setAttribute("ancho","726" );
      ((Element)v.get(136)).setAttribute("sep","$" );
      ((Element)v.get(136)).setAttribute("x","12" );
      ((Element)v.get(136)).setAttribute("class","botonera" );
      ((Element)v.get(136)).setAttribute("y","404" );
      ((Element)v.get(136)).setAttribute("control","|" );
      ((Element)v.get(136)).setAttribute("conector","" );
      ((Element)v.get(136)).setAttribute("rowset","" );
      ((Element)v.get(136)).setAttribute("cargainicial","N" );
      ((Element)v.get(94)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(137)).setAttribute("nombre","ret1" );
      ((Element)v.get(137)).setAttribute("x","37" );
      ((Element)v.get(137)).setAttribute("y","408" );
      ((Element)v.get(137)).setAttribute("ID","botonContenido" );
      ((Element)v.get(137)).setAttribute("img","retroceder_on" );
      ((Element)v.get(137)).setAttribute("tipo","0" );
      ((Element)v.get(137)).setAttribute("estado","false" );
      ((Element)v.get(137)).setAttribute("alt","" );
      ((Element)v.get(137)).setAttribute("codigo","" );
      ((Element)v.get(137)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 136   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(138)).setAttribute("nombre","ava1" );
      ((Element)v.get(138)).setAttribute("x","52" );
      ((Element)v.get(138)).setAttribute("y","408" );
      ((Element)v.get(138)).setAttribute("ID","botonContenido" );
      ((Element)v.get(138)).setAttribute("img","avanzar_on" );
      ((Element)v.get(138)).setAttribute("tipo","0" );
      ((Element)v.get(138)).setAttribute("estado","false" );
      ((Element)v.get(138)).setAttribute("alt","" );
      ((Element)v.get(138)).setAttribute("codigo","" );
      ((Element)v.get(138)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(136)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:136   */
      /* Termina nodo:94   */

      /* Empieza nodo:139 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(139)).setAttribute("nombre","primera1" );
      ((Element)v.get(139)).setAttribute("x","20" );
      ((Element)v.get(139)).setAttribute("y","408" );
      ((Element)v.get(139)).setAttribute("ID","botonContenido" );
      ((Element)v.get(139)).setAttribute("img","primera_on" );
      ((Element)v.get(139)).setAttribute("tipo","-2" );
      ((Element)v.get(139)).setAttribute("estado","false" );
      ((Element)v.get(139)).setAttribute("alt","" );
      ((Element)v.get(139)).setAttribute("codigo","" );
      ((Element)v.get(139)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(10)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(140)).setAttribute("nombre","separa" );
      ((Element)v.get(140)).setAttribute("x","59" );
      ((Element)v.get(140)).setAttribute("y","404" );
      ((Element)v.get(140)).setAttribute("ID","botonContenido" );
      ((Element)v.get(140)).setAttribute("img","separa_base" );
      ((Element)v.get(140)).setAttribute("tipo","0" );
      ((Element)v.get(140)).setAttribute("estado","false" );
      ((Element)v.get(140)).setAttribute("alt","" );
      ((Element)v.get(140)).setAttribute("codigo","" );
      ((Element)v.get(140)).setAttribute("accion","" );
      ((Element)v.get(10)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(141)).setAttribute("nombre","btnAceptar1" );
      ((Element)v.get(141)).setAttribute("x","17" );
      ((Element)v.get(141)).setAttribute("y","405" );
      ((Element)v.get(141)).setAttribute("ID","botonContenido" );
      ((Element)v.get(141)).setAttribute("tipo","html" );
      ((Element)v.get(141)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(141)).setAttribute("estado","false" );
      ((Element)v.get(141)).setAttribute("cod","12" );
      ((Element)v.get(141)).setAttribute("ontab","focaliza('formulario.cbEstatusVentaMAE');" );
      ((Element)v.get(141)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAnadir');" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(10)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(142)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(142)).setAttribute("alto","12" );
      ((Element)v.get(142)).setAttribute("ancho","100%" );
      ((Element)v.get(142)).setAttribute("colorf","" );
      ((Element)v.get(142)).setAttribute("borde","0" );
      ((Element)v.get(142)).setAttribute("imagenf","" );
      ((Element)v.get(142)).setAttribute("repeat","" );
      ((Element)v.get(142)).setAttribute("padding","" );
      ((Element)v.get(142)).setAttribute("visibilidad","visible" );
      ((Element)v.get(142)).setAttribute("contravsb","" );
      ((Element)v.get(142)).setAttribute("x","0" );
      ((Element)v.get(142)).setAttribute("y","427" );
      ((Element)v.get(142)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:10   */


   }

}
