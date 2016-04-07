
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_lista_consultoras_modificar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_lista_consultoras_modificar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","0325" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","sicc_util.js" );
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
      v.add(doc.createTextNode("\r   \r\r  var varNoLimpiarSICC = true; \r\r  function onLoadPag()   {  \r  \r    DrdEnsanchaConMargenDcho('listado1',12);\r    configurarMenuSecundario(\"Formulario\");    \r                                  \r    \r\r    document.all[\"Cplistado1\"].style.visibility='hidden';\r    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"separa1Div\"].style.visibility='hidden';\r    document.all[\"btnModificarDiv\"].style.visibility='hidden';\r    document.all[\"btnDetalleDiv\"].style.visibility='hidden';\r    eval (ON_RSZ);  \r\r    focaliza('Formulario.txtCodMensaje')\r\r    \r\r   }\r\r   function accionBuscar(){\r\r      var codM = get('Formulario.txtCodMensaje');\r      var codC = get('Formulario.txtCodCliente');\r      var arrayDatos = new Array();\r\r      arrayDatos[arrayDatos.length] = new Array('codMensaje',codM.toUpperCase());\r      arrayDatos[arrayDatos.length] = new Array('codCliente',codC.toUpperCase());\r      \r      var opcionMenu = get('Formulario.opcionMenu');\r\r      var id;\r      var conector;\r\r      if(opcionMenu == 'Modificar mensaje' || opcionMenu == 'Eliminar mensaje'){\r         id       = 'MSGCargarListaConsultoras';\r         conector = 'ConectorBuscarListaConsultoras'; \r      }else if(opcionMenu == 'Consultar mensaje'){\r         id       = 'MSGConsultarConsultoras';\r         conector = 'ConectorConsultarConsultoras';         \r      }\r    \r      if(!sicc_validaciones_generales()){\r         return;\r      }else{\r         configurarPaginado( mipgndo, id, conector, \"es.indra.sicc.dtos.msg.DTOBuscarConsultoras\", arrayDatos );\r      }\r\r   }\r   \r\r   function buscarCliente(){\r			var obj = new Object();\r			var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);\r      if(whnd != null){\r        set(\"Formulario.txtCodCliente\",whnd[1]);\r      }\r	\r		}\r\r   \r  function accionModificar(){   \r    if (listado1.codSeleccionados().length == 1) {    \r           var a = new Object();\r           a.oid = listado1.codSeleccionados();   \r           a.opcionMenu = get('Formulario.opcionMenu');\r           a.accion = 'Modificar';\r			  a.clientes = tomarCodigosLista();            mostrarModalSICC('LPMantenimientoConsultoras', 'Modificar', a, 795, 505);\r           accionBuscar();\r    }else {   \r           GestionarMensaje('4');   \r    }   \r  }   \r\r\r   function accionDetalle(){   \r    if (listado1.codSeleccionados().length == 1) {    \r           var a = new Object();   \r           a.oid = listado1.codSeleccionados();   \r           a.opcionMenu = get('Formulario.opcionMenu' );\r           a.accion = 'Detalle';\r           mostrarModalSICC('LPMantenimientoConsultoras', 'Detalle', a, 795, 505);\r           accionBuscar();\r    }else {\r           GestionarMensaje('4');   \r    }   \r  }   \r\r\r   function fBorrar(){   \r    if (listado1.codSeleccionados().length > 0) {   \r           eliminarFilas(listado1.codSeleccionados(),\"MSGEliminarDatosConsultora\", mipgndo);   \r    }else {   \r           GestionarMensaje('4');   \r    }   \r  }\r\r\r   function fLimpiar(){\r      set('Formulario.txtCodMensaje', '');\r      set('Formulario.txtCodCliente', '');\r      focaliza('Formulario.txtCodMensaje');\r\r   }\r   \r\r  function muestraLista( ultima, rowset){   \r      var tamano = rowset.length;  \r      if (tamano > 0) {\r             mostrarLista(); \r             configuraPantalla();\r             eval (ON_RSZ);                                 \r             return true;   \r      }else{   \r             ocultarLista();   \r             return false;   \r      } \r\r       focaliza('Formulario.txtCodMensaje');\r  }  \r\r\r\r  function mostrarLista(){   \r    document.all[\"Cplistado1\"].style.visibility='visible';   \r    document.all[\"CpLin1listado1\"].style.visibility='visible';   \r    document.all[\"CpLin2listado1\"].style.visibility='visible';   \r    document.all[\"CpLin3listado1\"].style.visibility='visible';   \r    document.all[\"CpLin4listado1\"].style.visibility='visible';   \r    document.all[\"primera1Div\"].style.visibility='visible';   \r    document.all[\"ret1Div\"].style.visibility='visible';   \r    document.all[\"ava1Div\"].style.visibility='visible';   \r    document.all[\"separa1Div\"].style.visibility='visible';   \r    document.all[\"primera1Div\"].style.visibility='visible';   \r                   \r  }   \r  function ocultarLista(){   \r    document.all[\"Cplistado1\"].style.visibility='hidden';   \r    document.all[\"CpLin1listado1\"].style.visibility='hidden';   \r    document.all[\"CpLin2listado1\"].style.visibility='hidden';   \r    document.all[\"CpLin3listado1\"].style.visibility='hidden';   \r    document.all[\"CpLin4listado1\"].style.visibility='hidden';   \r    document.all[\"primera1Div\"].style.visibility='hidden';   \r    document.all[\"ret1Div\"].style.visibility='hidden';   \r    document.all[\"ava1Div\"].style.visibility='hidden';   \r    document.all[\"separa1Div\"].style.visibility='hidden';   \r    document.all[\"btnModificarDiv\"].style.visibility='hidden';\r    document.all[\"btnDetalleDiv\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';   \r  }   \r\r\r  function configuraPantalla(){   \r      \r    if (get('Formulario.opcionMenu')=='Consultar mensaje'){   \r           document.all[\"btnDetalleDiv\"].style.visibility='visible'; \r           document.all[\"btnModificarDiv\"].style.visibility='hidden';   \r           listado1.maxSel=1;   \r    }   \r    if (get('Formulario.opcionMenu')=='Modificar mensaje'){   \r           document.all[\"btnDetalleDiv\"].style.visibility='hidden';   \r           document.all[\"btnModificarDiv\"].style.visibility='visible';   \r           listado1.maxSel=1;   \r    }   \r    if (get('Formulario.opcionMenu')=='Eliminar mensaje'){   \r           document.all[\"btnDetalleDiv\"].style.visibility='visible';   \r           document.all[\"btnModificarDiv\"].style.visibility='hidden';   \r           listado1.maxSel=\"-1\";   \r    }   \r  }   \r   \r\r   function clienteOnBlur() {\r\r       var longiCod = get('Formulario.hLongCliente');\r       var elTexto = get('Formulario.txtCodCliente');\r\r       if(elTexto.length != 0){\r          var faltantes = longiCod -  elTexto.length;\r          var resultCod = new String(\"\");\r          if(faltantes > 0){\r             for(var t = 0 ; t<faltantes; t++){\r                resultCod = resultCod + \"0\";\r             }\r          }\r          resultCod = resultCod + elTexto;\r          set('Formulario.txtCodCliente', resultCod);\r       }\r    \r   }\r\r/*toma todos los codigo de cliente que se encuentran en la lista de consultoras*/\r	function tomarCodigosLista(){\r			var listCli = listado1.datos;\r			var actual = listado1.codSeleccionados();\r			var cli = new Array();\r			var j = 0;\r\r			for(var i=0; i < listCli.length; i++){\r				 var regis = listCli[i]; \r				 if(regis[0] != actual){\r					 cli[j] = regis[1];\r					 j++;\r				 }\r			}\r			return cli;\r	}\r\r   \r  "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(4)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtCodMensaje" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","821" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */
      /* Termina nodo:6   */
      /* Termina nodo:4   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hLongCliente" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","clientes" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("table"));
      ((Element)v.get(16)).setAttribute("width","100%" );
      ((Element)v.get(16)).setAttribute("border","0" );
      ((Element)v.get(16)).setAttribute("cellspacing","0" );
      ((Element)v.get(16)).setAttribute("cellpadding","0" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));

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
      ((Element)v.get(30)).setAttribute("nombre","CriteriosBusqueda" );
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
      ((Element)v.get(34)).setAttribute("width","652" );
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
      ((Element)v.get(36)).setAttribute("colspan","8" );
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
      ((Element)v.get(42)).setAttribute("nombre","lblCodMensaje" );
      ((Element)v.get(42)).setAttribute("alto","13" );
      ((Element)v.get(42)).setAttribute("filas","1" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(42)).setAttribute("id","datosTitle" );
      ((Element)v.get(42)).setAttribute("cod","821" );
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
      ((Element)v.get(45)).setAttribute("colspan","3" );
      ((Element)v.get(38)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(46)).setAttribute("id","datosTitle" );
      ((Element)v.get(46)).setAttribute("cod","263" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("width","100%" );
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
      ((Element)v.get(52)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(53)).setAttribute("nombre","txtCodMensaje" );
      ((Element)v.get(53)).setAttribute("id","datosCampos" );
      ((Element)v.get(53)).setAttribute("max","5" );
      ((Element)v.get(53)).setAttribute("tipo","" );
      ((Element)v.get(53)).setAttribute("onchange","" );
      ((Element)v.get(53)).setAttribute("req","S" );
      ((Element)v.get(53)).setAttribute("size","5" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("validacion","" );
      ((Element)v.get(53)).setAttribute("onshtab","focalizaBotonHTML('botonContenido', 'btnBuscar')" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","25" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(56)).setAttribute("valign","bottom" );
      ((Element)v.get(49)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(57)).setAttribute("nombre","txtCodCliente" );
      ((Element)v.get(57)).setAttribute("id","datosCampos" );
      ((Element)v.get(57)).setAttribute("max","15" );
      ((Element)v.get(57)).setAttribute("tipo","" );
      ((Element)v.get(57)).setAttribute("onchange","" );
      ((Element)v.get(57)).setAttribute("req","N" );
      ((Element)v.get(57)).setAttribute("size","19" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("validacion","" );
      ((Element)v.get(57)).setAttribute("onblur","clienteOnBlur();" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(61)).setAttribute("onclick","buscarCliente();" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","100%" );
      ((Element)v.get(49)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:49   */

      /* Empieza nodo:64 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("colspan","9" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:67 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:24   */

      /* Empieza nodo:69 / Elemento padre: 16   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("table"));
      ((Element)v.get(74)).setAttribute("width","100%" );
      ((Element)v.get(74)).setAttribute("border","0" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(74)).setAttribute("cellspacing","0" );
      ((Element)v.get(74)).setAttribute("cellpadding","0" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("class","botonera" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(77)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(77)).setAttribute("ID","botonContenido" );
      ((Element)v.get(77)).setAttribute("tipo","html" );
      ((Element)v.get(77)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(77)).setAttribute("estado","false" );
      ((Element)v.get(77)).setAttribute("cod","1" );
      ((Element)v.get(77)).setAttribute("ontab","focaliza('Formulario.txtCodMensaje')" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:78 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","12" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:69   */

      /* Empieza nodo:80 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","12" );
      ((Element)v.get(81)).setAttribute("align","center" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","12" );
      ((Element)v.get(82)).setAttribute("height","12" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","756" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","12" );
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","12" );
      ((Element)v.get(86)).setAttribute("height","1" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:80   */
      /* Termina nodo:16   */

      /* Empieza nodo:87 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(87)).setAttribute("nombre","listado1" );
      ((Element)v.get(87)).setAttribute("ancho","708" );
      ((Element)v.get(87)).setAttribute("alto","317" );
      ((Element)v.get(87)).setAttribute("x","12" );
      ((Element)v.get(87)).setAttribute("y","127" );
      ((Element)v.get(87)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(87)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(88)).setAttribute("precarga","S" );
      ((Element)v.get(88)).setAttribute("conROver","S" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(89)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(89)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(89)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(89)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 88   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(90)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(90)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(90)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(90)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(88)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("BTNORDENAR"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(91)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(91)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:88   */

      /* Empieza nodo:92 / Elemento padre: 87   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(87)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(93)).setAttribute("borde","1" );
      ((Element)v.get(93)).setAttribute("horizDatos","1" );
      ((Element)v.get(93)).setAttribute("horizCabecera","1" );
      ((Element)v.get(93)).setAttribute("vertical","1" );
      ((Element)v.get(93)).setAttribute("horizTitulo","1" );
      ((Element)v.get(93)).setAttribute("horizBase","1" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 92   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(94)).setAttribute("borde","#999999" );
      ((Element)v.get(94)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(94)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(94)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(94)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(94)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(94)).setAttribute("horizBase","#999999" );
      ((Element)v.get(92)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:92   */

      /* Empieza nodo:95 / Elemento padre: 87   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(95)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(95)).setAttribute("alto","22" );
      ((Element)v.get(95)).setAttribute("imgFondo","" );
      ((Element)v.get(95)).setAttribute("cod","00401" );
      ((Element)v.get(95)).setAttribute("ID","datosTitle" );
      ((Element)v.get(87)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 87   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(96)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(96)).setAttribute("alto","22" );
      ((Element)v.get(96)).setAttribute("imgFondo","" );
      ((Element)v.get(87)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 87   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(97)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(97)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(97)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(97)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(97)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(97)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(87)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("ancho","18" );
      ((Element)v.get(98)).setAttribute("minimizable","S" );
      ((Element)v.get(98)).setAttribute("minimizada","N" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 97   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("ancho","27" );
      ((Element)v.get(99)).setAttribute("minimizable","S" );
      ((Element)v.get(99)).setAttribute("minimizada","N" );
      ((Element)v.get(97)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("ancho","20" );
      ((Element)v.get(100)).setAttribute("minimizable","S" );
      ((Element)v.get(100)).setAttribute("minimizada","N" );
      ((Element)v.get(97)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 97   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("ancho","20" );
      ((Element)v.get(101)).setAttribute("minimizable","S" );
      ((Element)v.get(101)).setAttribute("minimizada","N" );
      ((Element)v.get(97)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("ancho","20" );
      ((Element)v.get(102)).setAttribute("minimizable","S" );
      ((Element)v.get(102)).setAttribute("minimizada","N" );
      ((Element)v.get(97)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 97   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("ancho","20" );
      ((Element)v.get(103)).setAttribute("minimizable","S" );
      ((Element)v.get(103)).setAttribute("minimizada","N" );
      ((Element)v.get(97)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 97   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("ancho","20" );
      ((Element)v.get(104)).setAttribute("minimizable","S" );
      ((Element)v.get(104)).setAttribute("minimizada","N" );
      ((Element)v.get(97)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 97   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("ancho","20" );
      ((Element)v.get(105)).setAttribute("minimizable","S" );
      ((Element)v.get(105)).setAttribute("minimizada","N" );
      ((Element)v.get(97)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 97   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("ancho","20" );
      ((Element)v.get(106)).setAttribute("minimizable","S" );
      ((Element)v.get(106)).setAttribute("minimizada","N" );
      ((Element)v.get(97)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 97   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","20" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(107)).setAttribute("minimizada","N" );
      ((Element)v.get(97)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 97   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("ancho","20" );
      ((Element)v.get(108)).setAttribute("minimizable","S" );
      ((Element)v.get(108)).setAttribute("minimizada","N" );
      ((Element)v.get(97)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:97   */

      /* Empieza nodo:109 / Elemento padre: 87   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(109)).setAttribute("alto","20" );
      ((Element)v.get(109)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(109)).setAttribute("imgFondo","" );
      ((Element)v.get(109)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(109)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(87)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("colFondo","" );
      ((Element)v.get(110)).setAttribute("ID","EstCab" );
      ((Element)v.get(110)).setAttribute("cod","263" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("colFondo","" );
      ((Element)v.get(111)).setAttribute("ID","EstCab" );
      ((Element)v.get(111)).setAttribute("cod","943" );
      ((Element)v.get(109)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("colFondo","" );
      ((Element)v.get(112)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).setAttribute("cod","1025" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("colFondo","" );
      ((Element)v.get(113)).setAttribute("ID","EstCab" );
      ((Element)v.get(113)).setAttribute("cod","1026" );
      ((Element)v.get(109)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("colFondo","" );
      ((Element)v.get(114)).setAttribute("ID","EstCab" );
      ((Element)v.get(114)).setAttribute("cod","1027" );
      ((Element)v.get(109)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("colFondo","" );
      ((Element)v.get(115)).setAttribute("ID","EstCab" );
      ((Element)v.get(115)).setAttribute("cod","1028" );
      ((Element)v.get(109)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("colFondo","" );
      ((Element)v.get(116)).setAttribute("ID","EstCab" );
      ((Element)v.get(116)).setAttribute("cod","1029" );
      ((Element)v.get(109)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("colFondo","" );
      ((Element)v.get(117)).setAttribute("ID","EstCab" );
      ((Element)v.get(117)).setAttribute("cod","1030" );
      ((Element)v.get(109)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("colFondo","" );
      ((Element)v.get(118)).setAttribute("ID","EstCab" );
      ((Element)v.get(118)).setAttribute("cod","1031" );
      ((Element)v.get(109)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("colFondo","" );
      ((Element)v.get(119)).setAttribute("ID","EstCab" );
      ((Element)v.get(119)).setAttribute("cod","1032" );
      ((Element)v.get(109)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("colFondo","" );
      ((Element)v.get(120)).setAttribute("ID","EstCab" );
      ((Element)v.get(120)).setAttribute("cod","1024" );
      ((Element)v.get(109)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:109   */

      /* Empieza nodo:121 / Elemento padre: 87   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(121)).setAttribute("alto","22" );
      ((Element)v.get(121)).setAttribute("accion","" );
      ((Element)v.get(121)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(121)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(121)).setAttribute("maxSel","-1" );
      ((Element)v.get(121)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(121)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(121)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(121)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(87)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("tipo","texto" );
      ((Element)v.get(122)).setAttribute("ID","EstDat" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("tipo","texto" );
      ((Element)v.get(123)).setAttribute("ID","EstDat2" );
      ((Element)v.get(121)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("tipo","texto" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(124)).setAttribute("ID","EstDat" );
      ((Element)v.get(121)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("tipo","texto" );
      ((Element)v.get(125)).setAttribute("ID","EstDat2" );
      ((Element)v.get(121)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("tipo","texto" );
      ((Element)v.get(126)).setAttribute("ID","EstDat" );
      ((Element)v.get(121)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("tipo","texto" );
      ((Element)v.get(127)).setAttribute("ID","EstDat2" );
      ((Element)v.get(121)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","texto" );
      ((Element)v.get(128)).setAttribute("ID","EstDat" );
      ((Element)v.get(121)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("tipo","texto" );
      ((Element)v.get(129)).setAttribute("ID","EstDat2" );
      ((Element)v.get(121)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("tipo","texto" );
      ((Element)v.get(130)).setAttribute("ID","EstDat" );
      ((Element)v.get(121)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("tipo","texto" );
      ((Element)v.get(131)).setAttribute("ID","EstDat2" );
      ((Element)v.get(121)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("tipo","texto" );
      ((Element)v.get(132)).setAttribute("ID","EstDat" );
      ((Element)v.get(121)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:121   */

      /* Empieza nodo:133 / Elemento padre: 87   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(87)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 87   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(134)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(134)).setAttribute("ancho","708" );
      ((Element)v.get(134)).setAttribute("sep","$" );
      ((Element)v.get(134)).setAttribute("x","12" );
      ((Element)v.get(134)).setAttribute("class","botonera" );
      ((Element)v.get(134)).setAttribute("y","421" );
      ((Element)v.get(134)).setAttribute("control","|" );
      ((Element)v.get(134)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(134)).setAttribute("rowset","" );
      ((Element)v.get(134)).setAttribute("cargainicial","N" );
      ((Element)v.get(134)).setAttribute("onload","procesarPaginado(mipgndo,msgError,ultima,rowset,'muestraLista(ultima,rowset)');" );
      ((Element)v.get(87)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(135)).setAttribute("nombre","ret1" );
      ((Element)v.get(135)).setAttribute("x","37" );
      ((Element)v.get(135)).setAttribute("y","425" );
      ((Element)v.get(135)).setAttribute("ID","botonContenido" );
      ((Element)v.get(135)).setAttribute("img","retroceder_on" );
      ((Element)v.get(135)).setAttribute("tipo","0" );
      ((Element)v.get(135)).setAttribute("estado","false" );
      ((Element)v.get(135)).setAttribute("alt","" );
      ((Element)v.get(135)).setAttribute("codigo","" );
      ((Element)v.get(135)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 134   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(136)).setAttribute("nombre","ava1" );
      ((Element)v.get(136)).setAttribute("x","52" );
      ((Element)v.get(136)).setAttribute("y","425" );
      ((Element)v.get(136)).setAttribute("ID","botonContenido" );
      ((Element)v.get(136)).setAttribute("img","avanzar_on" );
      ((Element)v.get(136)).setAttribute("tipo","0" );
      ((Element)v.get(136)).setAttribute("estado","false" );
      ((Element)v.get(136)).setAttribute("alt","" );
      ((Element)v.get(136)).setAttribute("codigo","" );
      ((Element)v.get(136)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(134)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:134   */
      /* Termina nodo:87   */

      /* Empieza nodo:137 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(137)).setAttribute("nombre","primera1" );
      ((Element)v.get(137)).setAttribute("x","20" );
      ((Element)v.get(137)).setAttribute("y","425" );
      ((Element)v.get(137)).setAttribute("ID","botonContenido" );
      ((Element)v.get(137)).setAttribute("img","primera_on" );
      ((Element)v.get(137)).setAttribute("tipo","1" );
      ((Element)v.get(137)).setAttribute("estado","false" );
      ((Element)v.get(137)).setAttribute("alt","" );
      ((Element)v.get(137)).setAttribute("codigo","" );
      ((Element)v.get(137)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(138)).setAttribute("nombre","separa1" );
      ((Element)v.get(138)).setAttribute("x","59" );
      ((Element)v.get(138)).setAttribute("y","421" );
      ((Element)v.get(138)).setAttribute("ID","botonContenido" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(138)).setAttribute("img","separa_base" );
      ((Element)v.get(138)).setAttribute("tipo","0" );
      ((Element)v.get(138)).setAttribute("estado","false" );
      ((Element)v.get(138)).setAttribute("alt","" );
      ((Element)v.get(138)).setAttribute("codigo","" );
      ((Element)v.get(138)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(139)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(139)).setAttribute("x","80" );
      ((Element)v.get(139)).setAttribute("y","422" );
      ((Element)v.get(139)).setAttribute("ID","botonContenido" );
      ((Element)v.get(139)).setAttribute("estado","false" );
      ((Element)v.get(139)).setAttribute("accion","accionModificar();" );
      ((Element)v.get(139)).setAttribute("tipo","html" );
      ((Element)v.get(139)).setAttribute("cod","2" );
      ((Element)v.get(8)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(140)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(140)).setAttribute("x","80" );
      ((Element)v.get(140)).setAttribute("y","422" );
      ((Element)v.get(140)).setAttribute("ID","botonContenido" );
      ((Element)v.get(140)).setAttribute("estado","false" );
      ((Element)v.get(140)).setAttribute("accion","accionDetalle();" );
      ((Element)v.get(140)).setAttribute("tipo","html" );
      ((Element)v.get(140)).setAttribute("cod","3" );
      ((Element)v.get(8)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(141)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(141)).setAttribute("alto","18" );
      ((Element)v.get(141)).setAttribute("ancho","100" );
      ((Element)v.get(141)).setAttribute("colorf","" );
      ((Element)v.get(141)).setAttribute("borde","0" );
      ((Element)v.get(141)).setAttribute("imagenf","" );
      ((Element)v.get(141)).setAttribute("repeat","" );
      ((Element)v.get(141)).setAttribute("padding","" );
      ((Element)v.get(141)).setAttribute("visibilidad","visible" );
      ((Element)v.get(141)).setAttribute("contravsb","" );
      ((Element)v.get(141)).setAttribute("x","0" );
      ((Element)v.get(141)).setAttribute("y","332" );
      ((Element)v.get(141)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:8   */


   }

}
