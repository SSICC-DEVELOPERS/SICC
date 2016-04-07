
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_buzon_crear  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_buzon_crear" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Crear buzón" );
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
      v.add(doc.createTextNode("\r  \r\r  function ocultaLista1() {\r	DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='hidden';\r    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"btnInsertarCabeceraDiv\"].style.visibility='hidden';\r    document.all[\"btnInsertarDetalleDiv\"].style.visibility='hidden';    \r  }\r\r  function ocultaLista2() {\r    DrdEnsanchaConMargenDcho('listado2',12);\r    document.all[\"Cplistado2\"].style.visibility='hidden';\r    document.all[\"CpLin1listado2\"].style.visibility='hidden';\r    document.all[\"CpLin2listado2\"].style.visibility='hidden';\r    document.all[\"CpLin3listado2\"].style.visibility='hidden';\r    document.all[\"CpLin4listado2\"].style.visibility='hidden';\r    document.all[\"separa2Div\"].style.visibility='hidden';\r    document.all[\"primera2Div\"].style.visibility='hidden';\r    document.all[\"ret2Div\"].style.visibility='hidden';\r    document.all[\"ava2Div\"].style.visibility='hidden';\r    document.all[\"btnRedirigirDiv\"].style.visibility='hidden';\r    document.all[\"btnActualizarDiv\"].style.visibility='hidden';\r    document.all[\"btnProcesarActividadDiv\"].style.visibility='hidden';\r  }\r\r  function muestraLista1() {\r  	DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='';\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r     \r	\r	if( get(\"formulario.opcionMenu\")==\"Crear Buzon\"){\r		document.all[\"btnInsertarCabeceraDiv\"].style.visibility='';\r	    document.all[\"btnInsertarDetalleDiv\"].style.visibility='';\r\r	}else if(get(\"formulario.opcionMenu\")==\"Redirigir Buzon\" || get(\"formulario.opcionMenu\")==\"Actualizar Buzon\"){		\r		document.all[\"btnInsertarCabeceraDiv\"].style.visibility='hidden';\r	    document.all[\"btnInsertarDetalleDiv\"].style.visibility='hidden'; \r	\r	}else{\r		document.all[\"btnInsertarCabeceraDiv\"].style.visibility='hidden';\r	    document.all[\"btnInsertarDetalleDiv\"].style.visibility='hidden';\r	}\r  }\r\r  function muestraLista2() {\r	if( get(\"formulario.opcionMenu\")==\"Crear Buzon\"){\r		document.all[\"btnProcesarActividadDiv\"].style.visibility='hidden';\r		document.all[\"btnRedirigirDiv\"].style.visibility='hidden';\r	    document.all[\"btnActualizarDiv\"].style.visibility='hidden';\r\r	}else if(get(\"formulario.opcionMenu\")==\"Redirigir Buzon\"){		\r		document.all[\"btnRedirigirDiv\"].style.visibility='';\r		document.all[\"btnProcesarActividadDiv\"].style.visibility='hidden';\r		document.all[\"btnActualizarDiv\"].style.visibility='hidden';\r\r	}else if( get(\"formulario.opcionMenu\")==\"Actualizar Buzon\" ){\r		document.all[\"btnRedirigirDiv\"].style.visibility='hidden';\r		document.all[\"btnProcesarActividadDiv\"].style.visibility='hidden';\r		document.all[\"btnActualizarDiv\"].style.visibility='';\r	\r	}else{\r		document.all[\"btnProcesarActividadDiv\"].style.visibility='';\r		document.all[\"btnRedirigirDiv\"].style.visibility='';\r	    document.all[\"btnActualizarDiv\"].style.visibility='';\r	}\r\r    DrdEnsanchaConMargenDcho('listado2',12);\r    document.all[\"Cplistado2\"].style.visibility='';\r    document.all[\"CpLin1listado2\"].style.visibility='';\r    document.all[\"CpLin2listado2\"].style.visibility='';\r    document.all[\"CpLin3listado2\"].style.visibility='';\r    document.all[\"CpLin4listado2\"].style.visibility='';\r    document.all[\"separa2Div\"].style.visibility='';\r    document.all[\"primera2Div\"].style.visibility='';\r    document.all[\"ret2Div\"].style.visibility='';\r    document.all[\"ava2Div\"].style.visibility='';\r    \r    \r  }\r\r  function onLoadPag(){ \r  \r	configurarMenuSecundario(\"formulario\");\r	muestraLista1();\r	ocultaLista2();\r	if(get(\"formulario.accion\")==\"\" && get(\"formulario.opcionMenu\")==\"Crear Buzon\"){\r		btnProxy(1,0);\r		btnProxy(5,0);\r\r				listado2.alternaVerColumna(6,false,false);\r		listado2.alternaVerColumna(7,false,false);\r		listado2.repinta();\r\r	}\r	if( get(\"formulario.opcionMenu\")== \"ConsultarBuzon\" ){\r		btnProxy(5,0);	\r\r				listado2.alternaVerColumna(6,true,false);\r		listado2.alternaVerColumna(7,true,false);\r		listado2.repinta();\r\r	}\r	fMostrarMensajeError();	\r	eval (ON_RSZ);	   \r	focoBotonDetalle();\r }\r\r\r\r   function focoBotonDetalle() {\r		focalizaBotonHTML_XY('btnDetalle');\r   }\r\r   function focoBotonInsCabecera() {	\r		focalizaBotonHTML_XY('btnInsertarCabecera');\r   }\r\r   function focoBotonInsDetalle() {\r 	    focalizaBotonHTML_XY('btnInsertarDetalle');		  \r   }\r\r   function onClickInsertarCabecera() {\r			\r	var obj = new Object();\r	eval(\"formulario\").oculto = \"N\";\r	set(\"formulario.conectorAction\", \"LPBuzon\");\r    set(\"formulario.accion\", \"mostrar cabecera\");\r    enviaSICC(\"formulario\");\r   }\r\r   function onClickInsertarDetalle() {\r				\r	\r	\r	if (listado1.numSelecc()!=0) {\r        var obj = new Object();\r\r        obj.oidCabecera = listado1.codSeleccionados().toString();\r		obj.accion = \"mostrar detalle\";\r		obj.opcionMenu = get(\"formulario.opcionMenu\");\r        mostrarModalSICC('LPBuzon','mostrar detalle',obj,800,300);	\r		onClickDetalle();\r    } \r	else {\r       GestionarMensaje('1022',null,null,null);\r       return false;\r	}\r   }\r\r   function onClickDetalle() {\r	\r		\r															\r	if (listado1.numSelecc()!=0) {   \r	   if( get(\"formulario.opcionMenu\")== \"ConsultarBuzon\" ){\r			btnProxy(5,0);	   \r	   }\r	   set(\"formulario.oidCabecera\", listado1.codSeleccionados());\r       set(\"formulario.codBuzon\", listado1.extraeDato(listado1.codSeleccionados(),0)); configurarPaginado(mipgndo2,'CALObtenerDetalleBuzon','ConectorObtenerDetalleBuzon','es.indra.sicc.dtos.cal.DTOBusqueda', armarArray()); \r		\r    } \r	else {\r       GestionarMensaje('1021',null,null,null);\r       return false;\r	}    \r   }\r\r\r   function armarArray()  {\r	     var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r	  	 var codBuzon = listado1.datos[posicion][1];	\r\r         var vArray = new Array();\r\r         var i = 0;\r\r		 		 \r         vArray[i] = new Array('oidIdioma',get(\"formulario.oidIdioma\"));\r         i++;\r         vArray[i] = new Array('oidPais',get(\"formulario.oidPais\"));\r         i++;\r		 vArray[i] = new Array('oidCabecera',listado1.codSeleccionados().toString());\r         i++;\r         vArray[i] = new Array('codBuzon',codBuzon);\r         i++;\r         \r         if (get('formulario.descripcionBuzon')!=''){\r             vArray[i] = new Array('descripBuzon',get('formulario.descripcionBuzon'));\r             i++;\r         }\r\r         if (get('formulario.secActividad')!=''){\r             vArray[i] = new Array('secActividad',get('formulario.secActividad'));\r             i++;\r         }	 \r		 \r		 if (get('formulario.descripActividad')!=''){\r             vArray[i] = new Array('descripActividad',get('formulario.descripActividad'));\r             i++;\r         }\r\r         if (get('formulario.codCliente')!=''){\r             vArray[i] = new Array('codCliente',get('formulario.codCliente'));\r             i++;\r         }\r\r		 if (get('formulario.fechaActividadDesde')!=''){\r             vArray[i] = new Array('fechaActividadDesde',get('formulario.fechaActividadDesde'));\r             i++;\r         }\r\r         if (get('formulario.fechaActividadHasta')!=''){\r             vArray[i] = new Array('fechaActividadHasta',get('formulario.fechaActividadHasta'));\r             i++;\r         }\r\r         return vArray;\r    }\r\r\r   function onClickRedirigir() {\r				\r	\r	var oidCabecera = get('formulario.oidCabecera');\r	var codBuzon = listado1.extraeDato(listado1.codSeleccionados(),1);\r	\r	if (listado2.numSelecc()!= 0 ) {\r        var obj = new Object();\r\r        obj.oidsDetalle = listado2.codSeleccionados();\r		obj.oidCabecera = oidCabecera;\r		obj.codBuzon = get(\"formulario.codBuzon\");\r        obj.accion = \"redirigir detalle\";\r\r        mostrarModalSICC('LPBuzon','redirigir detalle',obj,800,300);\r		onClickDetalle();\r    } \r	else {\r       GestionarMensaje('1022',null,null,null);\r       return false;\r	}\r\r   }\r\r   function onCLickActualizar() {\r			\r							\r	\r	if (listado2.numSelecc()== 1) {\r		var posicion = obtenerPosicionListaEditable(listado2.codSeleccionados(),listado2);\r        var obj = new Object();\r\r		obj.oidCabecera = get(\"formulario.oidCabecera\");\r        obj.oidDetalle = listado2.datos[posicion][0];\r		obj.secuenciaActividad = listado2.datos[posicion][1];\r		obj.descripcionActividad = listado2.datos[posicion][2];\r		obj.codCliente = listado2.datos[posicion][3];\r		obj.oidContacto = listado2.datos[posicion][4];\r		obj.oidGestion = listado2.datos[posicion][5];\r		obj.observaciones = listado2.datos[posicion][6];\r\r        obj.accion = \"actualizar detalle\";\r\r		obj.opcionMenu = get(\"formulario.opcionMenu\");\r        mostrarModalSICC('LPBuzon','actualizar detalle',obj,800,600);	\r		onClickDetalle();\r    } \r	else {\r\r       GestionarMensaje('1022',null,null,null);\r       return false;\r	}\r\r   }\r\r   function onClickProcesarActividad() {\r						\r	if (listado2.numSelecc()== 1) {\r		eval(\"formulario\").oculto = 'S';\r		set(\"formulario.conectorAction\", \"LPBuzon\");\r		set(\"formulario.accion\", \"procesar actividad\");\r		set('formulario.oidDetalle', listado2.codSeleccionados().toString());\r	    enviaSICC(\"formulario\");  \r    } \r	else {\r       GestionarMensaje('1022',null,null,null);\r       return false;\r	}\r\r   }   \r\r   function obtenerPosicionListaEditable(clave, lista){\r      this.posicion = 0;\r      if (lista.codSeleccionados().length > 0){\r         for(var k=0;k<lista.datos.length;k++) {\r               if (lista.datos[k][0] == clave) {\r                  posicion=k;\r                  break;\r               }\r		     }         \r	       return posicion;\r	     }\r   }\r\r\r  function reInicio(){\r\r	onClickDetalle();\r	eval(\"formulario\").oculto = \"N\";\r  }\r\r  \r\r   function muestraLista( ultima, rowset, error){\r    var tamano = rowset.length;\r    if (tamano > 0){\r	  muestraLista2();\r      eval (ON_RSZ);      \r      return true;\r    }\r    else {\r	  ocultaLista2();\r      eval (ON_RSZ);                      \r      return false;\r    }\r  }\r\r \r    \r  "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(6)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","oidDetalle" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","secuenciaActividad" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","descripcionActividad" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","codCliente" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidContacto" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidGestion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","observaciones" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidCabecera" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","codBuzon" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidsDetalle" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","oidPais" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(24)).setAttribute("width","100%" );
      ((Element)v.get(24)).setAttribute("border","0" );
      ((Element)v.get(24)).setAttribute("cellspacing","0" );
      ((Element)v.get(24)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","100%" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","524" );
      ((Element)v.get(27)).setAttribute("height","8" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(28)).setAttribute("nombre","listado1" );
      ((Element)v.get(28)).setAttribute("ancho","500" );
      ((Element)v.get(28)).setAttribute("alto","301" );
      ((Element)v.get(28)).setAttribute("x","12" );
      ((Element)v.get(28)).setAttribute("y","12" );
      ((Element)v.get(28)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(28)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(29)).setAttribute("precarga","S" );
      ((Element)v.get(29)).setAttribute("conROver","S" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(30)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(30)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(30)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(30)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 29   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(31)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(31)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(31)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(31)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(32)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(32)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:29   */

      /* Empieza nodo:33 / Elemento padre: 28   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(28)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(34)).setAttribute("borde","1" );
      ((Element)v.get(34)).setAttribute("horizDatos","1" );
      ((Element)v.get(34)).setAttribute("horizCabecera","1" );
      ((Element)v.get(34)).setAttribute("vertical","0" );
      ((Element)v.get(34)).setAttribute("horizTitulo","1" );
      ((Element)v.get(34)).setAttribute("horizBase","1" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 33   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(35)).setAttribute("borde","#999999" );
      ((Element)v.get(35)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(35)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(35)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(35)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(35)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(35)).setAttribute("horizBase","#999999" );
      ((Element)v.get(33)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:33   */

      /* Empieza nodo:36 / Elemento padre: 28   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(36)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(36)).setAttribute("alto","22" );
      ((Element)v.get(36)).setAttribute("imgFondo","" );
      ((Element)v.get(36)).setAttribute("cod","00419" );
      ((Element)v.get(36)).setAttribute("ID","datosTitle" );
      ((Element)v.get(28)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 28   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(37)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(37)).setAttribute("alto","22" );
      ((Element)v.get(37)).setAttribute("imgFondo","" );
      ((Element)v.get(28)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 28   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(38)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(38)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(38)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(38)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(38)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(38)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(28)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("COL"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(39)).setAttribute("ancho","50" );
      ((Element)v.get(39)).setAttribute("minimizable","S" );
      ((Element)v.get(39)).setAttribute("minimizada","N" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 38   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("ancho","100" );
      ((Element)v.get(40)).setAttribute("minimizable","S" );
      ((Element)v.get(40)).setAttribute("minimizada","N" );
      ((Element)v.get(40)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(38)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 38   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("ancho","80" );
      ((Element)v.get(41)).setAttribute("minimizable","S" );
      ((Element)v.get(41)).setAttribute("minimizada","N" );
      ((Element)v.get(38)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:38   */

      /* Empieza nodo:42 / Elemento padre: 28   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(42)).setAttribute("alto","20" );
      ((Element)v.get(42)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(42)).setAttribute("imgFondo","" );
      ((Element)v.get(42)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(28)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("colFondo","" );
      ((Element)v.get(43)).setAttribute("ID","EstCab" );
      ((Element)v.get(43)).setAttribute("align","center" );
      ((Element)v.get(43)).setAttribute("cod","2026" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Elemento padre:43 / Elemento actual: 44   */
      v.add(doc.createTextNode("Cód. buzón"));
      ((Element)v.get(43)).appendChild((Text)v.get(44));

      /* Termina nodo Texto:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("colFondo","" );
      ((Element)v.get(45)).setAttribute("ID","EstCab" );
      ((Element)v.get(45)).setAttribute("cod","2027" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Elemento padre:45 / Elemento actual: 46   */
      v.add(doc.createTextNode("Descripción buzón"));
      ((Element)v.get(45)).appendChild((Text)v.get(46));

      /* Termina nodo Texto:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("colFondo","" );
      ((Element)v.get(47)).setAttribute("ID","EstCab" );
      ((Element)v.get(47)).setAttribute("cod","136" );
      ((Element)v.get(42)).appendChild((Element)v.get(47));

      /* Elemento padre:47 / Elemento actual: 48   */
      v.add(doc.createTextNode("Usuario"));
      ((Element)v.get(47)).appendChild((Text)v.get(48));

      /* Termina nodo Texto:48   */
      /* Termina nodo:47   */
      /* Termina nodo:42   */

      /* Empieza nodo:49 / Elemento padre: 28   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(49)).setAttribute("alto","22" );
      ((Element)v.get(49)).setAttribute("accion","" );
      ((Element)v.get(49)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(49)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(49)).setAttribute("maxSel","1" );
      ((Element)v.get(49)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(49)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(49)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(49)).setAttribute("onLoad","" );
      ((Element)v.get(49)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(28)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("tipo","texto" );
      ((Element)v.get(50)).setAttribute("ID","EstDat" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("tipo","texto" );
      ((Element)v.get(51)).setAttribute("ID","EstDat2" );
      ((Element)v.get(49)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("tipo","texto" );
      ((Element)v.get(52)).setAttribute("ID","EstDat" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:49   */

      /* Empieza nodo:53 / Elemento padre: 28   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(28)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 28   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(54)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(54)).setAttribute("ancho","500" );
      ((Element)v.get(54)).setAttribute("sep","$" );
      ((Element)v.get(54)).setAttribute("x","12" );
      ((Element)v.get(54)).setAttribute("class","botonera" );
      ((Element)v.get(54)).setAttribute("y","290" );
      ((Element)v.get(54)).setAttribute("control","|" );
      ((Element)v.get(54)).setAttribute("conector","" );
      ((Element)v.get(54)).setAttribute("rowset","" );
      ((Element)v.get(54)).setAttribute("cargainicial","N" );
      ((Element)v.get(28)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(55)).setAttribute("nombre","ret1" );
      ((Element)v.get(55)).setAttribute("x","37" );
      ((Element)v.get(55)).setAttribute("y","294" );
      ((Element)v.get(55)).setAttribute("ID","botonContenido" );
      ((Element)v.get(55)).setAttribute("img","retroceder_on" );
      ((Element)v.get(55)).setAttribute("tipo","0" );
      ((Element)v.get(55)).setAttribute("estado","false" );
      ((Element)v.get(55)).setAttribute("alt","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(55)).setAttribute("codigo","" );
      ((Element)v.get(55)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 54   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(56)).setAttribute("nombre","ava1" );
      ((Element)v.get(56)).setAttribute("x","52" );
      ((Element)v.get(56)).setAttribute("y","294" );
      ((Element)v.get(56)).setAttribute("ID","botonContenido" );
      ((Element)v.get(56)).setAttribute("img","avanzar_on" );
      ((Element)v.get(56)).setAttribute("tipo","0" );
      ((Element)v.get(56)).setAttribute("estado","false" );
      ((Element)v.get(56)).setAttribute("alt","" );
      ((Element)v.get(56)).setAttribute("codigo","" );
      ((Element)v.get(56)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(54)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:54   */
      /* Termina nodo:28   */

      /* Empieza nodo:57 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(57)).setAttribute("nombre","primera1" );
      ((Element)v.get(57)).setAttribute("x","20" );
      ((Element)v.get(57)).setAttribute("y","294" );
      ((Element)v.get(57)).setAttribute("ID","botonContenido" );
      ((Element)v.get(57)).setAttribute("img","primera_on" );
      ((Element)v.get(57)).setAttribute("tipo","-2" );
      ((Element)v.get(57)).setAttribute("estado","false" );
      ((Element)v.get(57)).setAttribute("alt","" );
      ((Element)v.get(57)).setAttribute("codigo","" );
      ((Element)v.get(57)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(58)).setAttribute("nombre","separa" );
      ((Element)v.get(58)).setAttribute("x","59" );
      ((Element)v.get(58)).setAttribute("y","290" );
      ((Element)v.get(58)).setAttribute("ID","botonContenido" );
      ((Element)v.get(58)).setAttribute("img","separa_base" );
      ((Element)v.get(58)).setAttribute("tipo","0" );
      ((Element)v.get(58)).setAttribute("estado","false" );
      ((Element)v.get(58)).setAttribute("alt","" );
      ((Element)v.get(58)).setAttribute("codigo","" );
      ((Element)v.get(58)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(59)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(59)).setAttribute("x","80" );
      ((Element)v.get(59)).setAttribute("y","291" );
      ((Element)v.get(59)).setAttribute("ID","botonContenido" );
      ((Element)v.get(59)).setAttribute("tipo","html" );
      ((Element)v.get(59)).setAttribute("estado","false" );
      ((Element)v.get(59)).setAttribute("cod","3" );
      ((Element)v.get(59)).setAttribute("accion","onClickDetalle();" );
      ((Element)v.get(59)).setAttribute("onshtab","focoBotonInsDetalle();" );
      ((Element)v.get(6)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(60)).setAttribute("nombre","btnInsertarCabecera" );
      ((Element)v.get(60)).setAttribute("x","128" );
      ((Element)v.get(60)).setAttribute("y","291" );
      ((Element)v.get(60)).setAttribute("ID","botonContenido" );
      ((Element)v.get(60)).setAttribute("tipo","html" );
      ((Element)v.get(60)).setAttribute("estado","false" );
      ((Element)v.get(60)).setAttribute("cod","2029" );
      ((Element)v.get(60)).setAttribute("accion","onClickInsertarCabecera();" );
      ((Element)v.get(6)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(61)).setAttribute("nombre","btnInsertarDetalle" );
      ((Element)v.get(61)).setAttribute("x","257" );
      ((Element)v.get(61)).setAttribute("y","291" );
      ((Element)v.get(61)).setAttribute("ID","botonContenido" );
      ((Element)v.get(61)).setAttribute("tipo","html" );
      ((Element)v.get(61)).setAttribute("estado","false" );
      ((Element)v.get(61)).setAttribute("cod","2028" );
      ((Element)v.get(61)).setAttribute("accion","onClickInsertarDetalle();" );
      ((Element)v.get(61)).setAttribute("ontab","focoBotonDetalle();" );
      ((Element)v.get(6)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(62)).setAttribute("nombre","listado2" );
      ((Element)v.get(62)).setAttribute("ancho","500" );
      ((Element)v.get(62)).setAttribute("alto","317" );
      ((Element)v.get(62)).setAttribute("x","12" );
      ((Element)v.get(62)).setAttribute("y","337" );
      ((Element)v.get(62)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(62)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(63)).setAttribute("precarga","S" );
      ((Element)v.get(63)).setAttribute("conROver","S" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(64)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(64)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(64)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(64)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 63   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(65)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(65)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(65)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(65)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(63)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 63   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(66)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(66)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(63)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:63   */

      /* Empieza nodo:67 / Elemento padre: 62   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(62)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(68)).setAttribute("borde","1" );
      ((Element)v.get(68)).setAttribute("horizDatos","1" );
      ((Element)v.get(68)).setAttribute("horizCabecera","1" );
      ((Element)v.get(68)).setAttribute("vertical","0" );
      ((Element)v.get(68)).setAttribute("horizTitulo","1" );
      ((Element)v.get(68)).setAttribute("horizBase","1" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 67   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(69)).setAttribute("borde","#999999" );
      ((Element)v.get(69)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(69)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(69)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(69)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(69)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(69)).setAttribute("horizBase","#999999" );
      ((Element)v.get(67)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:67   */

      /* Empieza nodo:70 / Elemento padre: 62   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(70)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(70)).setAttribute("alto","22" );
      ((Element)v.get(70)).setAttribute("imgFondo","" );
      ((Element)v.get(70)).setAttribute("cod","00420" );
      ((Element)v.get(70)).setAttribute("ID","datosTitle" );
      ((Element)v.get(62)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 62   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(71)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(71)).setAttribute("alto","22" );
      ((Element)v.get(71)).setAttribute("imgFondo","" );
      ((Element)v.get(62)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 62   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(72)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(72)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(72)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(72)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(72)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(72)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(62)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(73)).setAttribute("ancho","130" );
      ((Element)v.get(73)).setAttribute("minimizable","S" );
      ((Element)v.get(73)).setAttribute("minimizada","N" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 72   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("ancho","130" );
      ((Element)v.get(74)).setAttribute("minimizable","S" );
      ((Element)v.get(74)).setAttribute("minimizada","N" );
      ((Element)v.get(74)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(72)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(75)).setAttribute("ancho","100" );
      ((Element)v.get(75)).setAttribute("minimizable","S" );
      ((Element)v.get(75)).setAttribute("minimizada","N" );
      ((Element)v.get(72)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 72   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("ancho","100" );
      ((Element)v.get(76)).setAttribute("minimizable","S" );
      ((Element)v.get(76)).setAttribute("minimizada","N" );
      ((Element)v.get(72)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 72   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(77)).setAttribute("ancho","100" );
      ((Element)v.get(77)).setAttribute("minimizable","S" );
      ((Element)v.get(77)).setAttribute("minimizada","N" );
      ((Element)v.get(77)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(72)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 72   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("ancho","100" );
      ((Element)v.get(78)).setAttribute("minimizable","S" );
      ((Element)v.get(78)).setAttribute("minimizada","N" );
      ((Element)v.get(72)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 72   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("ancho","100" );
      ((Element)v.get(79)).setAttribute("minimizable","S" );
      ((Element)v.get(79)).setAttribute("minimizada","N" );
      ((Element)v.get(72)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 72   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(80)).setAttribute("ancho","100" );
      ((Element)v.get(80)).setAttribute("minimizable","S" );
      ((Element)v.get(80)).setAttribute("minimizada","N" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(72)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:72   */

      /* Empieza nodo:81 / Elemento padre: 62   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(81)).setAttribute("alto","20" );
      ((Element)v.get(81)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(81)).setAttribute("imgFondo","" );
      ((Element)v.get(81)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(62)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(82)).setAttribute("colFondo","" );
      ((Element)v.get(82)).setAttribute("ID","EstCab" );
      ((Element)v.get(82)).setAttribute("cod","2030" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("colFondo","" );
      ((Element)v.get(83)).setAttribute("ID","EstCab" );
      ((Element)v.get(83)).setAttribute("cod","2031" );
      ((Element)v.get(81)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("colFondo","" );
      ((Element)v.get(84)).setAttribute("ID","EstCab" );
      ((Element)v.get(84)).setAttribute("cod","263" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("colFondo","" );
      ((Element)v.get(85)).setAttribute("ID","EstCab" );
      ((Element)v.get(85)).setAttribute("cod","2032" );
      ((Element)v.get(81)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("colFondo","" );
      ((Element)v.get(86)).setAttribute("ID","EstCab" );
      ((Element)v.get(86)).setAttribute("cod","2033" );
      ((Element)v.get(81)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("colFondo","" );
      ((Element)v.get(87)).setAttribute("ID","EstCab" );
      ((Element)v.get(87)).setAttribute("cod","169" );
      ((Element)v.get(81)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(88)).setAttribute("colFondo","" );
      ((Element)v.get(88)).setAttribute("ID","EstCab" );
      ((Element)v.get(88)).setAttribute("cod","2034" );
      ((Element)v.get(81)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 81   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("colFondo","" );
      ((Element)v.get(89)).setAttribute("ID","EstCab" );
      ((Element)v.get(89)).setAttribute("cod","3074" );
      ((Element)v.get(81)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:81   */

      /* Empieza nodo:90 / Elemento padre: 62   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(90)).setAttribute("alto","22" );
      ((Element)v.get(90)).setAttribute("accion","" );
      ((Element)v.get(90)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(90)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(90)).setAttribute("maxSel","-1" );
      ((Element)v.get(90)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(90)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(90)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(90)).setAttribute("onLoad","" );
      ((Element)v.get(90)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(62)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("tipo","texto" );
      ((Element)v.get(91)).setAttribute("ID","EstDat" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("tipo","texto" );
      ((Element)v.get(92)).setAttribute("ID","EstDat2" );
      ((Element)v.get(90)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("tipo","texto" );
      ((Element)v.get(93)).setAttribute("ID","EstDat" );
      ((Element)v.get(90)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("tipo","texto" );
      ((Element)v.get(94)).setAttribute("ID","EstDat2" );
      ((Element)v.get(90)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("tipo","texto" );
      ((Element)v.get(95)).setAttribute("ID","EstDat" );
      ((Element)v.get(90)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("tipo","texto" );
      ((Element)v.get(96)).setAttribute("ID","EstDat2" );
      ((Element)v.get(90)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(97)).setAttribute("tipo","texto" );
      ((Element)v.get(97)).setAttribute("ID","EstDat" );
      ((Element)v.get(90)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 90   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(98)).setAttribute("tipo","texto" );
      ((Element)v.get(98)).setAttribute("ID","EstDat2" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(90)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:90   */

      /* Empieza nodo:99 / Elemento padre: 62   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(62)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 62   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(100)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(100)).setAttribute("ancho","500" );
      ((Element)v.get(100)).setAttribute("sep","$" );
      ((Element)v.get(100)).setAttribute("x","12" );
      ((Element)v.get(100)).setAttribute("class","botonera" );
      ((Element)v.get(100)).setAttribute("y","631" );
      ((Element)v.get(100)).setAttribute("control","|" );
      ((Element)v.get(100)).setAttribute("conector","" );
      ((Element)v.get(100)).setAttribute("rowset","" );
      ((Element)v.get(100)).setAttribute("cargainicial","N" );
      ((Element)v.get(100)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(62)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(101)).setAttribute("nombre","ret2" );
      ((Element)v.get(101)).setAttribute("x","37" );
      ((Element)v.get(101)).setAttribute("y","635" );
      ((Element)v.get(101)).setAttribute("ID","botonContenido" );
      ((Element)v.get(101)).setAttribute("img","retroceder_on" );
      ((Element)v.get(101)).setAttribute("tipo","0" );
      ((Element)v.get(101)).setAttribute("estado","false" );
      ((Element)v.get(101)).setAttribute("alt","" );
      ((Element)v.get(101)).setAttribute("codigo","" );
      ((Element)v.get(101)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 100   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(102)).setAttribute("nombre","ava2" );
      ((Element)v.get(102)).setAttribute("x","52" );
      ((Element)v.get(102)).setAttribute("y","635" );
      ((Element)v.get(102)).setAttribute("ID","botonContenido" );
      ((Element)v.get(102)).setAttribute("img","avanzar_on" );
      ((Element)v.get(102)).setAttribute("tipo","0" );
      ((Element)v.get(102)).setAttribute("estado","false" );
      ((Element)v.get(102)).setAttribute("alt","" );
      ((Element)v.get(102)).setAttribute("codigo","" );
      ((Element)v.get(102)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(100)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:100   */
      /* Termina nodo:62   */

      /* Empieza nodo:103 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(103)).setAttribute("nombre","primera2" );
      ((Element)v.get(103)).setAttribute("x","20" );
      ((Element)v.get(103)).setAttribute("y","635" );
      ((Element)v.get(103)).setAttribute("ID","botonContenido" );
      ((Element)v.get(103)).setAttribute("img","primera_on" );
      ((Element)v.get(103)).setAttribute("tipo","-2" );
      ((Element)v.get(103)).setAttribute("estado","false" );
      ((Element)v.get(103)).setAttribute("alt","" );
      ((Element)v.get(103)).setAttribute("codigo","" );
      ((Element)v.get(103)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(104)).setAttribute("nombre","separa2" );
      ((Element)v.get(104)).setAttribute("x","59" );
      ((Element)v.get(104)).setAttribute("y","631" );
      ((Element)v.get(104)).setAttribute("ID","botonContenido" );
      ((Element)v.get(104)).setAttribute("img","separa_base" );
      ((Element)v.get(104)).setAttribute("tipo","0" );
      ((Element)v.get(104)).setAttribute("estado","false" );
      ((Element)v.get(104)).setAttribute("alt","" );
      ((Element)v.get(104)).setAttribute("codigo","" );
      ((Element)v.get(104)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(105)).setAttribute("nombre","btnRedirigir" );
      ((Element)v.get(105)).setAttribute("x","80" );
      ((Element)v.get(105)).setAttribute("y","632" );
      ((Element)v.get(105)).setAttribute("ID","botonContenido" );
      ((Element)v.get(105)).setAttribute("tipo","html" );
      ((Element)v.get(105)).setAttribute("estado","false" );
      ((Element)v.get(105)).setAttribute("cod","2053" );
      ((Element)v.get(105)).setAttribute("accion","onClickRedirigir();" );
      ((Element)v.get(6)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(106)).setAttribute("nombre","btnActualizar" );
      ((Element)v.get(106)).setAttribute("x","80" );
      ((Element)v.get(106)).setAttribute("y","632" );
      ((Element)v.get(106)).setAttribute("ID","botonContenido" );
      ((Element)v.get(106)).setAttribute("tipo","html" );
      ((Element)v.get(106)).setAttribute("estado","false" );
      ((Element)v.get(106)).setAttribute("cod","4" );
      ((Element)v.get(106)).setAttribute("accion","onCLickActualizar();" );
      ((Element)v.get(6)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(107)).setAttribute("nombre","btnProcesarActividad" );
      ((Element)v.get(107)).setAttribute("x","80" );
      ((Element)v.get(107)).setAttribute("y","632" );
      ((Element)v.get(107)).setAttribute("ID","botonContenido" );
      ((Element)v.get(107)).setAttribute("tipo","html" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(107)).setAttribute("estado","false" );
      ((Element)v.get(107)).setAttribute("cod","2261" );
      ((Element)v.get(107)).setAttribute("accion","onClickProcesarActividad();" );
      ((Element)v.get(6)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(108)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(108)).setAttribute("alto","12" );
      ((Element)v.get(108)).setAttribute("ancho","100%" );
      ((Element)v.get(108)).setAttribute("colorf","" );
      ((Element)v.get(108)).setAttribute("borde","0" );
      ((Element)v.get(108)).setAttribute("imagenf","" );
      ((Element)v.get(108)).setAttribute("repeat","" );
      ((Element)v.get(108)).setAttribute("padding","" );
      ((Element)v.get(108)).setAttribute("visibilidad","visible" );
      ((Element)v.get(108)).setAttribute("contravsb","" );
      ((Element)v.get(108)).setAttribute("x","0" );
      ((Element)v.get(108)).setAttribute("y","654" );
      ((Element)v.get(108)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:6   */


   }

}
