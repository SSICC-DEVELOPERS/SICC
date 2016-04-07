
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_periodos_eliminar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_periodos_eliminar" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Eliminar Períodos" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag(); inicializacion();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","097" );
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
      v.add(doc.createTextNode("   \r      \r    \r          function onLoadPag()   {           \r                   DrdEnsanchaConMargenDcho('listado1',12);                    \r                   if (get('frmEliminarPeriodos.hListadoDisponible') == \"SI\") {   \r                            mostrarListaEditable();   \r                   } else {    \r                            ocultarListaEditable();   \r                   }   \r                   eval (ON_RSZ);                      \r          }           \r    \r    \r                    function inicializacion() {   \r                   txt_to('lblValorPais', get('frmEliminarPeriodos.hPaisDescripcion'));    \r                   configurarMenuSecundario(\"frmEliminarPeriodos\");   \r    \r                   posicionarCombo();   \r                   set('frmEliminarPeriodos.Anio', get('frmEliminarPeriodos.hAnio'));   \r    \r                                      if (get('frmEliminarPeriodos.errDescripcion')!='') {   \r                            var wnd = fMostrarMensajeError(get('frmEliminarPeriodos.errCodigo'), get('frmEliminarPeriodos.errDescripcion'));   \r                   } else {   \r                            if ((get('frmEliminarPeriodos.accion')) == 'guardar') {   \r                                     set('frmEliminarPeriodos.accion', '');   \r                            }   \r                   }      \r    \r                   focaliza('frmEliminarPeriodos.comboMarca');   \r    \r                                      listado1.save();   \r                   listado1.repintaDat();   \r    \r                                      listado1.datos = adecuarListaVisible(listado1.datos);   \r    \r                                      compruebaCruces();   \r    \r                                      listado1.save();   \r                   listado1.repintaDat();   \r    \r                   set('frmEliminarPeriodos.hListaPeriodos', listado1.datos);    \r          }    \r    \r    \r     	function fBuscar() {   \r		if(!sicc_validaciones_generales()){   \r			return false;   \r		}   \r		obtenerPaisMarcaCanalAnio();   \r					\r				\r		mostrarListaEditable();   \r\r		configurarPaginado(mipgndo, 'CRAConsultarPeriodos', 'ConectorObtenerTodosPeriodosConsulta',   \r													  'es.indra.sicc.dtos.cra.DTOCriteriosPeriodo', armarArrayParametrosDTO()); \r\r				btnProxy(4, '1');   \r     }   \r    \r    \r                    function obtenerPaisMarcaCanalAnio(){    \r                   set('frmEliminarPeriodos.hCanal', get('frmEliminarPeriodos.comboCanal'));    \r                   set('frmEliminarPeriodos.hMarca', get('frmEliminarPeriodos.comboMarca'));    \r                   set('frmEliminarPeriodos.hAnio', get('frmEliminarPeriodos.Anio'));  \r				   set('frmEliminarPeriodos.hAcceso', get('frmEliminarPeriodos.comboAcceso'));  \r          }    \r     \r    \r          function posicionarCombo() {    \r                   var iSeleccionadoM = new Array();    \r                   iSeleccionadoM[0] = get('frmEliminarPeriodos.hMarca');    \r                   set('frmEliminarPeriodos.comboMarca',iSeleccionadoM);    \r    \r                   var iSeleccionado = new Array();    \r                   iSeleccionado[0] = get('frmEliminarPeriodos.hCanal');    \r                   set('frmEliminarPeriodos.comboCanal',iSeleccionado);    \r          }    \r              \r    \r                    function fLimpiar() {    \r                   set('frmEliminarPeriodos.comboCanal', '');    \r                   set('frmEliminarPeriodos.comboMarca', '');   \r                   set('frmEliminarPeriodos.comboAcceso', '');\r                   set('frmEliminarPeriodos.Anio', '');    \r                   set('frmEliminarPeriodos.hListadoDisponible', '');    \r                   focaliza('frmEliminarPeriodos.comboMarca','');   \r          }    \r     \r    \r          function fBorrar() {   \r                                      if (listado1.codSeleccionados()!= '') {   \r                                                        set('frmEliminarPeriodos.hListaPeriodos', listado1.datos);    \r    \r                                                        set('frmEliminarPeriodos.hPeriodosSeleccionados', listado1.codSeleccionados());   \r    \r                                                        if ( estaPorEliminarTodos() ) {   \r                                                                          eliminarFilas(listado1.codSeleccionados(), 'CRAEliminaVariosPeriodos', mipgndo, 'resultadoOperacionVacio(datos)');   \r                            } else {   \r                                                                          eliminarFilas(listado1.codSeleccionados(), 'CRAEliminaVariosPeriodos', mipgndo, 'resultadoOperacionPropio(datos)');    \r                            }   \r                   } else {   \r                            GestionarMensaje('416');   \r                   }   \r          }   \r    \r    \r                    function resultadoOperacionPropio(datos) {   \r                                      boolResultadoEliminacionSICC = true;   \r    \r                                      var mensajeError = \"\";   \r                   if(datos != null && (typeof(datos)).toUpperCase() == \"OBJECT\"){   \r                            mensajeError  = datos[0];   \r                   }else if(datos != null && (typeof(datos)).toUpperCase() == \"STRING\"){   \r                            mensajeError = datos;   \r                   }   \r                   if(mensajeError==\"\"){   \r                            if(boolResultadoEliminacionSICC){   \r                                     cdos_mostrarConfirm(GestionarMensaje(\"989\"));   \r                            }   \r                   }else{   \r                            mostrarErrorSubsistema(mensajeError );   \r                            return false;   \r                   }   \r             \r                                      var arrPeriodos = listado1.datos;   \r                      \r                                      if (objetoPaginado != null) {   \r                            listado1.save();   \r                            listado1.repintaDat();   \r                            objetoPaginado.recargar();    \r                   }   \r                                      setTimeout(\"fantasma()\",100);   \r    \r                                      recalcularPeriodos(arrPeriodos);   \r    \r                   return true;   \r          }   \r    \r    \r                    function resultadoOperacionVacio(datos) {   \r                                      boolResultadoEliminacionSICC = true;   \r                      \r                                      var mensajeError = \"\";   \r                   if(datos != null && (typeof(datos)).toUpperCase() == \"OBJECT\"){   \r                            mensajeError  = datos[0];   \r                   }else if(datos != null && (typeof(datos)).toUpperCase() == \"STRING\"){   \r                            mensajeError = datos;   \r                   }   \r                   if(mensajeError==\"\"){   \r                            if(boolResultadoEliminacionSICC){   \r                                     cdos_mostrarConfirm(GestionarMensaje(\"989\"));   \r                            }   \r                   }else{   \r                            mostrarErrorSubsistema(mensajeError );   \r                            return false;   \r                   }   \r    \r                                      ocultarListaEditable();   \r                   focaliza(\"frmEliminarPeriodos.comboMarca\");    \r                   return false;    \r          }   \r    \r    \r          function recalcularPeriodos(arrPeriodos) {   \r                                      if (GestionarMensaje('724')) {   \r                                                        var periodosAdecuados = adecuarListaOcultaRec(arrPeriodos);   \r                                                        set('frmEliminarPeriodos.hListaPeriodos', periodosAdecuados);    \r                               \r                            set('frmEliminarPeriodos.accion', 'recalcularPeriodos');   \r                            enviaSICC('frmEliminarPeriodos');   \r                   }   \r     }   \r    \r    \r          function estaPorEliminarTodos() {   \r                   var codigos = new String(listado1.codigos());   \r                   var arrayCodigos = codigos.split(',');   \r                   var seleccionados = new String(listado1.codSeleccionados());   \r                   var arraySeleccionados = seleccionados.split(',');   \r                                                         if (arrayCodigos.length == arraySeleccionados.length) {   \r                            return true;   \r                   }else{   \r                            return false;   \r                   }   \r          }   \r    \r    \r                    function muestraLista(ultima, rowset){   \r                   var i;   \r                   var indexCorto = 8;   \r                   var indexCruce = 9;   \r                   var si = GestionarMensaje(84);   \r                   var no = GestionarMensaje(86);   \r                   var tamano = rowset.length;   \r                                      if (tamano != 0) {   \r                      mostrarListaEditable();   \r                      eval (ON_RSZ);   \r                   } else {   \r                            ocultarListaEditable();   \r                            focaliza(\"frmEliminarPeriodos.comboMarca\");    \r                            return false;   \r                   }   \r                   for( i = 0; i < rowset.length; i++ ){   \r                                                        if( rowset[i][indexCorto] == 'false')   \r                                     rowset[i][indexCorto] = 'N';   \r                            else   \r                                     rowset[i][indexCorto] = 'S';   \r                                                        if( rowset[i][indexCruce] == 'false')   \r                                     rowset[i][indexCruce] = no;   \r                            else   \r                                     rowset[i][indexCruce] = si;   \r                   }   \r                   focaliza(\"frmEliminarPeriodos.comboMarca\");   \r                   return true;   \r          }   \r    \r    \r                              function adecuarListaVisible(rowset) {   \r                   var i;   \r                   var indexCorto = 8;   \r                   var indexCruce = 9;   \r                   var si = GestionarMensaje(84);   \r                   var no = GestionarMensaje(86);   \r                   for( i = 0; i < rowset.length; i++ ){   \r                                                        if( rowset[i][indexCruce] == 'false')   \r                                     rowset[i][indexCruce] = no;   \r                            else   \r                                     rowset[i][indexCruce] = si;   \r                   }   \r                   return rowset;   \r          }   \r    \r    \r                    function adecuarListaOcultaRec(arrPeriodos) {   \r                   var i;   \r                   var indexCorto = 8;   \r                   var indexCruce = 9;   \r                   var si = GestionarMensaje(84);   \r                   var no = GestionarMensaje(86);   \r                                      var listaPeriodos = arrPeriodos;    \r                                      for( i = 0; i < listaPeriodos.length; i++ ){   \r                                                        if( listaPeriodos[i][indexCorto] == 'N')   \r                                     listaPeriodos[i][indexCorto] = 'false';   \r                            else   \r                                     listaPeriodos[i][indexCorto] = 'true';   \r                                                        if( listaPeriodos[i][indexCruce] == no)   \r                                     listaPeriodos[i][indexCruce] = 'false';   \r                            else   \r                                     listaPeriodos[i][indexCruce] = 'true';   \r                   }   \r                   return listaPeriodos;   \r          }   \r    \r    \r                    function compruebaCruces() {   \r                   var periodos = listado1.datos;   \r                   var indexFechaFin = 6;   \r                   var indexFechaInicio = 5;   \r                   var indexPeriodoCruce = 9;   \r                   var fechaFinActual;   \r                   var fechaInicioSiguiente;   \r                   var fechaFinActualMilis;   \r                   var fechaInicioSiguienteMilis;   \r                   var si = GestionarMensaje(84);   \r                   var no = GestionarMensaje(86);   \r    \r                                      for (var i=0; i < (periodos.length - 1); i++) {   \r                            fechaFinActual = periodos[i][indexFechaFin];   \r                            fechaInicioSiguiente = periodos[i+1][indexFechaInicio];   \r                            fechaFinActualMilis = dameMilis(fechaFinActual);   \r                            fechaInicioSiguienteMilis = dameMilis(fechaInicioSiguiente);   \r                                                            \r                            if (fechaFinActualMilis >= fechaInicioSiguienteMilis) {   \r                                                                          periodos[i][indexPeriodoCruce] = si;   \r                            } else {   \r                                                                          periodos[i][indexPeriodoCruce] = no;   \r                            }   \r                   }   \r                                      if (periodos.length != 0) {   \r                            periodos[periodos.length-1][indexPeriodoCruce] = no;   \r                   }   \r    \r                                      listado1.datos = periodos;   \r    \r                                      listado1.save();   \r                   listado1.repintaDat();   \r          }   \r    \r    \r                    function dameMilis( valorFecha ) {   \r                                                         var fecha1 = obtenerFormatoFecha(valorFecha);   \r                   var d1,d2;   \r                   var dias = 0;   \r                   var arrFecha = fecha1.split(\"/\");   \r                   d1 = new Date(arrFecha[2],arrFecha[1]-1,arrFecha[0]);   \r                   d2 = d1.getTime();                    return d2;   \r          }   \r    \r    \r          function fantasma() {   \r                   return true;   \r          }   \r    \r          function ocultarListaEditable() {   \r                   document.all[\"Cplistado1\"].style.visibility='hidden';   \r                   document.all[\"CpLin1listado1\"].style.visibility='hidden';   \r                   document.all[\"CpLin2listado1\"].style.visibility='hidden';   \r                   document.all[\"CpLin3listado1\"].style.visibility='hidden';   \r                   document.all[\"CpLin4listado1\"].style.visibility='hidden';   \r                   document.all[\"prim1Div\"].style.visibility='hidden';   \r                   document.all[\"ret1Div\"].style.visibility='hidden';   \r                   document.all[\"ava1Div\"].style.visibility='hidden';   \r                   document.all[\"separaDiv\"].style.visibility='hidden';   \r                             }   \r    \r    \r          function mostrarListaEditable() {   \r                   document.all[\"Cplistado1\"].style.visibility='visible';   \r                   document.all[\"CpLin1listado1\"].style.visibility='visible';   \r                   document.all[\"CpLin2listado1\"].style.visibility='visible';   \r                   document.all[\"CpLin3listado1\"].style.visibility='visible';   \r                   document.all[\"CpLin4listado1\"].style.visibility='visible';   \r                   document.all[\"prim1Div\"].style.visibility='visible';   \r                   document.all[\"ret1Div\"].style.visibility='visible';   \r                   document.all[\"ava1Div\"].style.visibility='visible';   \r                   document.all[\"separaDiv\"].style.visibility='visible';   \r                             }   \r    \r    \r          function armarArrayParametrosDTO()  {   \r                   var array = new Array();   \r                   var i = 0;   \r                   array[i] = new Array('oidIdioma',get('frmEliminarPeriodos.hIdioma'));   \r    \r                   if (get('frmEliminarPeriodos.hPais') != '')  {   \r                            i++;   \r                            array[i] = new Array('pais',get('frmEliminarPeriodos.hPais'));   \r                   }   \r                   if (get('frmEliminarPeriodos.comboMarca') != '')  {   \r                            i++;   \r                            array[i] = new Array('marca',get('frmEliminarPeriodos.comboMarca'));   \r                   }   \r                   if (get('frmEliminarPeriodos.comboCanal') != '')  {   \r                            i++;   \r                            array[i] = new Array('canal',get('frmEliminarPeriodos.comboCanal'));   \r                   }   \r				   if (get('frmEliminarPeriodos.comboAcceso') != '')  {   \r                            i++;   \r                            array[i] = new Array('acceso',get('frmEliminarPeriodos.comboAcceso'));   \r                   }   \r                   if (get('frmEliminarPeriodos.Anio') != '')  {   \r                            i++;   \r                            array[i] = new Array('anio',get('frmEliminarPeriodos.Anio'));   \r                   }   \r    \r                                      return array;   \r          } \r		  \r		   function onChangeCanal() {\r						  var oidCanal = get('frmEliminarPeriodos.comboCanal', 'V');\r						  set('frmEliminarPeriodos.hCanal', oidCanal); \r						  if (oidCanal != '') {\r							  set('frmEliminarPeriodos.hIdioma', 1);\r									var array = new Array();\r									array[0] = new Array('oid',oidCanal);\r									array[1] = new Array('oidIdioma',get('frmEliminarPeriodos.hIdioma'));\r												  \r									set_combo('frmEliminarPeriodos.comboAcceso', arrayVacio());\r									recargaCombo('frmEliminarPeriodos.comboAcceso',\r																   'SEGObtieneAccesosPorCanal',\r																   'es.indra.sicc.util.DTOOID',\r																   array,\r																   'setearcbAcceso(datos)');                   \r													  \r\r						  } else {\r									set_combo('frmEliminarPeriodos.comboAcceso', arrayVacio());\r													  \r						  }\r			}\r			function arrayVacio(){  \r				var array = new Array();              \r					 array[0] = new Array('','');\r			  \r				return array;\r			}\r			function setearcbAcceso(datos) {\r					  var arrayNuevo = new Array();\r					  arrayNuevo[0] = new Array('','');\r					  arrayNuevo = arrayNuevo.concat(datos);\r					  set_combo('frmEliminarPeriodos.comboAcceso',arrayNuevo);\r			}\r    \r    \r     \r   "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","comboMarca" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","6" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","comboCanal" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","7" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","Anio" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","171" );
      ((Element)v.get(9)).setAttribute("format","t" );
      ((Element)v.get(9)).setAttribute("chars","0-9" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:6   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","frmEliminarPeriodos" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hCasoDeUso" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(13)).setAttribute("valor","LPEliminarPeriodos" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hFormatoFechaPais" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hPais" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hPaisDescripcion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hMarca" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hCanal" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hAnio" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hTipoPeriodo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hNombrePeriodo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hDuracionPeriodo" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hfInicio" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hfFin" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","msgValidaDatos" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","errorValidaDatos" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hPeriodoSeleccionado" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hListadoDisponible" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hEnableSave" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hListaPeriodos" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hPeriodoModificado" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hPeriodosSeleccionados" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hAcceso" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(37)).setAttribute("nombre","capaBuscar" );
      ((Element)v.get(10)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(41)).setAttribute("height","12" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","750" );
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("width","12" );
      ((Element)v.get(39)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","12" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("height","1" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:39   */

      /* Empieza nodo:46 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(51)).setAttribute("class","legend" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(52)).setAttribute("id","legend" );
      ((Element)v.get(52)).setAttribute("cod","0075" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 50   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(53)).setAttribute("border","0" );
      ((Element)v.get(53)).setAttribute("align","center" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("cellpadding","0" );
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(56)).setAttribute("width","718" );
      ((Element)v.get(56)).setAttribute("border","0" );
      ((Element)v.get(56)).setAttribute("align","left" );
      ((Element)v.get(56)).setAttribute("cellspacing","0" );
      ((Element)v.get(56)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("colspan","4" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:60 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lblPais" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("cod","5" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","25" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(68)).setAttribute("alto","13" );
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(68)).setAttribute("id","datosTitle" );
      ((Element)v.get(68)).setAttribute("cod","6" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","25" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("id","datosTitle" );
      ((Element)v.get(72)).setAttribute("cod","7" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","25" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","10" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","25" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblAnio" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","171" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(60)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:60   */

      /* Empieza nodo:83 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(83));

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
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lblValorPais" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).setAttribute("codi","5" );
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
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(91)).setAttribute("nombre","comboMarca" );
      ((Element)v.get(91)).setAttribute("id","datosCampos" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(91)).setAttribute("size","1" );
      ((Element)v.get(91)).setAttribute("multiple","N" );
      ((Element)v.get(91)).setAttribute("req","S" );
      ((Element)v.get(91)).setAttribute("valorinicial","" );
      ((Element)v.get(91)).setAttribute("textoinicial","" );
      ((Element)v.get(91)).setAttribute("onshtab","focaliza('frmEliminarPeriodos.Anio');" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:93 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","25" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(96)).setAttribute("nombre","comboCanal" );
      ((Element)v.get(96)).setAttribute("id","datosCampos" );
      ((Element)v.get(96)).setAttribute("size","1" );
      ((Element)v.get(96)).setAttribute("multiple","N" );
      ((Element)v.get(96)).setAttribute("req","S" );
      ((Element)v.get(96)).setAttribute("valorinicial","" );
      ((Element)v.get(96)).setAttribute("textoinicial","" );
      ((Element)v.get(96)).setAttribute("onchange","onChangeCanal();" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:98 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","25" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(101)).setAttribute("nombre","comboAcceso" );
      ((Element)v.get(101)).setAttribute("id","datosCampos" );
      ((Element)v.get(101)).setAttribute("size","1" );
      ((Element)v.get(101)).setAttribute("multiple","N" );
      ((Element)v.get(101)).setAttribute("req","N" );
      ((Element)v.get(101)).setAttribute("valorinicial","" );
      ((Element)v.get(101)).setAttribute("textoinicial","" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:103 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","25" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(106)).setAttribute("nombre","Anio" );
      ((Element)v.get(106)).setAttribute("id","datosCampos" );
      ((Element)v.get(106)).setAttribute("max","4" );
      ((Element)v.get(106)).setAttribute("tipo","" );
      ((Element)v.get(106)).setAttribute("onchange","" );
      ((Element)v.get(106)).setAttribute("req","S" );
      ((Element)v.get(106)).setAttribute("size","4" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(106)).setAttribute("ontab","focaliza('frmEliminarPeriodos.comboMarca');" );
      ((Element)v.get(106)).setAttribute("validacion","fValidarNumero(valor,4,0,9999);" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(83)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:83   */

      /* Empieza nodo:109 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("colspan","4" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:112 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:46   */

      /* Empieza nodo:114 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("table"));
      ((Element)v.get(119)).setAttribute("width","100%" );
      ((Element)v.get(119)).setAttribute("border","0" );
      ((Element)v.get(119)).setAttribute("align","center" );
      ((Element)v.get(119)).setAttribute("cellspacing","0" );
      ((Element)v.get(119)).setAttribute("cellpadding","0" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("class","botonera" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(122)).setAttribute("nombre","btnCrear" );
      ((Element)v.get(122)).setAttribute("ID","botonContenido" );
      ((Element)v.get(122)).setAttribute("tipo","html" );
      ((Element)v.get(122)).setAttribute("accion","fBuscar();" );
      ((Element)v.get(122)).setAttribute("estado","false" );
      ((Element)v.get(122)).setAttribute("cod","1" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:123 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","12" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:114   */

      /* Empieza nodo:125 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","12" );
      ((Element)v.get(126)).setAttribute("align","center" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","12" );
      ((Element)v.get(127)).setAttribute("height","12" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","750" );
      ((Element)v.get(125)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","12" );
      ((Element)v.get(125)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","12" );
      ((Element)v.get(131)).setAttribute("height","1" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:125   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:132 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(132)).setAttribute("nombre","listado1" );
      ((Element)v.get(132)).setAttribute("ancho","721" );
      ((Element)v.get(132)).setAttribute("alto","317" );
      ((Element)v.get(132)).setAttribute("x","12" );
      ((Element)v.get(132)).setAttribute("y","124" );
      ((Element)v.get(132)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(132)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(133)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(133)).setAttribute("alto","22" );
      ((Element)v.get(133)).setAttribute("imgFondo","" );
      ((Element)v.get(133)).setAttribute("cod","00135" );
      ((Element)v.get(133)).setAttribute("ID","datosTitle" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 132   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(134)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(134)).setAttribute("alto","22" );
      ((Element)v.get(134)).setAttribute("imgFondo","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(132)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(135)).setAttribute("precarga","S" );
      ((Element)v.get(135)).setAttribute("conROver","S" );
      ((Element)v.get(132)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(136)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(136)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(136)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(136)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 135   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(137)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(137)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(137)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(137)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(135)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 135   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(138)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(138)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(135)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:135   */

      /* Empieza nodo:139 / Elemento padre: 132   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(132)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(140)).setAttribute("borde","1" );
      ((Element)v.get(140)).setAttribute("horizDatos","1" );
      ((Element)v.get(140)).setAttribute("horizCabecera","1" );
      ((Element)v.get(140)).setAttribute("vertical","1" );
      ((Element)v.get(140)).setAttribute("horizTitulo","1" );
      ((Element)v.get(140)).setAttribute("horizBase","1" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 139   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(141)).setAttribute("borde","#999999" );
      ((Element)v.get(141)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(141)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(141)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(141)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(141)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(141)).setAttribute("horizBase","#999999" );
      ((Element)v.get(139)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:139   */

      /* Empieza nodo:142 / Elemento padre: 132   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(142)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(142)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(142)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(142)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(142)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(142)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(132)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("ancho","60" );
      ((Element)v.get(143)).setAttribute("minimizable","S" );
      ((Element)v.get(143)).setAttribute("minimizada","N" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("ancho","70" );
      ((Element)v.get(144)).setAttribute("minimizable","S" );
      ((Element)v.get(144)).setAttribute("minimizada","N" );
      ((Element)v.get(144)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(142)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("ancho","100" );
      ((Element)v.get(145)).setAttribute("minimizable","S" );
      ((Element)v.get(145)).setAttribute("minimizada","N" );
      ((Element)v.get(142)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("ancho","100" );
      ((Element)v.get(146)).setAttribute("minimizable","S" );
      ((Element)v.get(146)).setAttribute("minimizada","N" );
      ((Element)v.get(142)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("ancho","100" );
      ((Element)v.get(147)).setAttribute("minimizable","S" );
      ((Element)v.get(147)).setAttribute("minimizada","N" );
      ((Element)v.get(147)).setAttribute("orden","numerico" );
      ((Element)v.get(142)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("ancho","100" );
      ((Element)v.get(148)).setAttribute("minimizable","S" );
      ((Element)v.get(148)).setAttribute("minimizada","N" );
      ((Element)v.get(142)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("ancho","100" );
      ((Element)v.get(149)).setAttribute("minimizable","S" );
      ((Element)v.get(149)).setAttribute("minimizada","N" );
      ((Element)v.get(149)).setAttribute("oculta","S" );
      ((Element)v.get(142)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("ancho","100" );
      ((Element)v.get(150)).setAttribute("minimizable","S" );
      ((Element)v.get(150)).setAttribute("minimizada","N" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(142)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 142   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("ancho","100" );
      ((Element)v.get(151)).setAttribute("minimizable","S" );
      ((Element)v.get(151)).setAttribute("minimizada","N" );
      ((Element)v.get(142)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:142   */

      /* Empieza nodo:152 / Elemento padre: 132   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(152)).setAttribute("alto","20" );
      ((Element)v.get(152)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(152)).setAttribute("imgFondo","" );
      ((Element)v.get(152)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(132)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("colFondo","" );
      ((Element)v.get(153)).setAttribute("ID","EstCab" );
      ((Element)v.get(153)).setAttribute("align","center" );
      ((Element)v.get(153)).setAttribute("cod","132" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Elemento padre:153 / Elemento actual: 154   */
      v.add(doc.createTextNode("Identificador"));
      ((Element)v.get(153)).appendChild((Text)v.get(154));

      /* Termina nodo Texto:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("colFondo","" );
      ((Element)v.get(155)).setAttribute("ID","EstCab" );
      ((Element)v.get(155)).setAttribute("cod","30" );
      ((Element)v.get(152)).appendChild((Element)v.get(155));

      /* Elemento padre:155 / Elemento actual: 156   */
      v.add(doc.createTextNode("Nombre 1"));
      ((Element)v.get(155)).appendChild((Text)v.get(156));

      /* Termina nodo Texto:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("colFondo","" );
      ((Element)v.get(157)).setAttribute("ID","EstCab" );
      ((Element)v.get(157)).setAttribute("cod","247" );
      ((Element)v.get(152)).appendChild((Element)v.get(157));

      /* Elemento padre:157 / Elemento actual: 158   */
      v.add(doc.createTextNode("Apellido 1"));
      ((Element)v.get(157)).appendChild((Text)v.get(158));

      /* Termina nodo Texto:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("colFondo","" );
      ((Element)v.get(159)).setAttribute("ID","EstCab" );
      ((Element)v.get(159)).setAttribute("cod","248" );
      ((Element)v.get(152)).appendChild((Element)v.get(159));

      /* Elemento padre:159 / Elemento actual: 160   */
      v.add(doc.createTextNode("Tipo usuario"));
      ((Element)v.get(159)).appendChild((Text)v.get(160));

      /* Termina nodo Texto:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("colFondo","" );
      ((Element)v.get(161)).setAttribute("ID","EstCab" );
      ((Element)v.get(161)).setAttribute("cod","274" );
      ((Element)v.get(152)).appendChild((Element)v.get(161));

      /* Elemento padre:161 / Elemento actual: 162   */
      v.add(doc.createTextNode("Perfil"));
      ((Element)v.get(161)).appendChild((Text)v.get(162));

      /* Termina nodo Texto:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("colFondo","" );
      ((Element)v.get(163)).setAttribute("ID","EstCab" );
      ((Element)v.get(163)).setAttribute("cod","251" );
      ((Element)v.get(152)).appendChild((Element)v.get(163));

      /* Elemento padre:163 / Elemento actual: 164   */
      v.add(doc.createTextNode("Tipo usuario"));
      ((Element)v.get(163)).appendChild((Text)v.get(164));

      /* Termina nodo Texto:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("colFondo","" );
      ((Element)v.get(165)).setAttribute("ID","EstCab" );
      ((Element)v.get(152)).appendChild((Element)v.get(165));

      /* Elemento padre:165 / Elemento actual: 166   */
      v.add(doc.createTextNode("oidTipoPeriodo"));
      ((Element)v.get(165)).appendChild((Text)v.get(166));

      /* Termina nodo Texto:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("colFondo","" );
      ((Element)v.get(167)).setAttribute("ID","EstCab" );
      ((Element)v.get(167)).setAttribute("cod","2280" );
      ((Element)v.get(152)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("colFondo","" );
      ((Element)v.get(168)).setAttribute("ID","EstCab" );
      ((Element)v.get(168)).setAttribute("cod","2281" );
      ((Element)v.get(152)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:152   */

      /* Empieza nodo:169 / Elemento padre: 132   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(169)).setAttribute("alto","22" );
      ((Element)v.get(169)).setAttribute("accion","" );
      ((Element)v.get(169)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(169)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(169)).setAttribute("maxSel","-1" );
      ((Element)v.get(169)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(169)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(169)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(169)).setAttribute("onLoad","" );
      ((Element)v.get(169)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(132)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("tipo","texto" );
      ((Element)v.get(170)).setAttribute("ID","EstDat" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("tipo","texto" );
      ((Element)v.get(171)).setAttribute("ID","EstDat2" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(169)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(172)).setAttribute("nombre","txtNombrePeriodo" );
      ((Element)v.get(172)).setAttribute("size","26" );
      ((Element)v.get(172)).setAttribute("max","20" );
      ((Element)v.get(172)).setAttribute("ID","EstDat" );
      ((Element)v.get(172)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(172)).setAttribute("validacion","" );
      ((Element)v.get(172)).setAttribute("req","S" );
      ((Element)v.get(172)).setAttribute("onchange","cambioNombrePeriodo();" );
      ((Element)v.get(172)).setAttribute("deshabilitado","S" );
      ((Element)v.get(169)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(173)).setAttribute("nombre","txtDuracionPeriodo" );
      ((Element)v.get(173)).setAttribute("size","4" );
      ((Element)v.get(173)).setAttribute("max","4" );
      ((Element)v.get(173)).setAttribute("ID","EstDat2" );
      ((Element)v.get(173)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(173)).setAttribute("req","S" );
      ((Element)v.get(173)).setAttribute("onchange","cambioDuracion();" );
      ((Element)v.get(173)).setAttribute("deshabilitado","S" );
      ((Element)v.get(169)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(174)).setAttribute("nombre","txtFinicio" );
      ((Element)v.get(174)).setAttribute("size","12" );
      ((Element)v.get(174)).setAttribute("max","10" );
      ((Element)v.get(174)).setAttribute("ID","EstDat" );
      ((Element)v.get(174)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(174)).setAttribute("validacion","" );
      ((Element)v.get(174)).setAttribute("req","S" );
      ((Element)v.get(174)).setAttribute("onchange","cambioFechaInicio();" );
      ((Element)v.get(174)).setAttribute("deshabilitado","S" );
      ((Element)v.get(169)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(175)).setAttribute("nombre","txtFfin" );
      ((Element)v.get(175)).setAttribute("size","12" );
      ((Element)v.get(175)).setAttribute("max","10" );
      ((Element)v.get(175)).setAttribute("ID","EstDat2" );
      ((Element)v.get(175)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(175)).setAttribute("validacion","" );
      ((Element)v.get(175)).setAttribute("req","S" );
      ((Element)v.get(175)).setAttribute("onchange","cambioFechaFin();" );
      ((Element)v.get(175)).setAttribute("deshabilitado","S" );
      ((Element)v.get(169)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("tipo","texto" );
      ((Element)v.get(176)).setAttribute("ID","EstDat" );
      ((Element)v.get(169)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("tipo","checkbox" );
      ((Element)v.get(177)).setAttribute("nombre","ck1" );
      ((Element)v.get(177)).setAttribute("ID","EstDat" );
      ((Element)v.get(177)).setAttribute("deshabilitado","S" );
      ((Element)v.get(169)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("tipo","texto" );
      ((Element)v.get(178)).setAttribute("ID","EstDat2" );
      ((Element)v.get(169)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:169   */

      /* Empieza nodo:179 / Elemento padre: 132   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(132)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 132   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(180)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(180)).setAttribute("ancho","680" );
      ((Element)v.get(180)).setAttribute("sep","$" );
      ((Element)v.get(180)).setAttribute("x","12" );
      ((Element)v.get(180)).setAttribute("class","botonera" );
      ((Element)v.get(180)).setAttribute("y","418" );
      ((Element)v.get(180)).setAttribute("control","|" );
      ((Element)v.get(180)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(180)).setAttribute("rowset","" );
      ((Element)v.get(180)).setAttribute("cargainicial","N" );
      ((Element)v.get(180)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset);')" );
      ((Element)v.get(132)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(181)).setAttribute("nombre","ret1" );
      ((Element)v.get(181)).setAttribute("x","37" );
      ((Element)v.get(181)).setAttribute("y","422" );
      ((Element)v.get(181)).setAttribute("ID","botonContenido" );
      ((Element)v.get(181)).setAttribute("img","retroceder_on" );
      ((Element)v.get(181)).setAttribute("tipo","0" );
      ((Element)v.get(181)).setAttribute("estado","false" );
      ((Element)v.get(181)).setAttribute("alt","" );
      ((Element)v.get(181)).setAttribute("codigo","" );
      ((Element)v.get(181)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 180   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(182)).setAttribute("nombre","ava1" );
      ((Element)v.get(182)).setAttribute("x","52" );
      ((Element)v.get(182)).setAttribute("y","422" );
      ((Element)v.get(182)).setAttribute("ID","botonContenido" );
      ((Element)v.get(182)).setAttribute("img","avanzar_on" );
      ((Element)v.get(182)).setAttribute("tipo","0" );
      ((Element)v.get(182)).setAttribute("estado","false" );
      ((Element)v.get(182)).setAttribute("alt","" );
      ((Element)v.get(182)).setAttribute("codigo","" );
      ((Element)v.get(182)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(180)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:180   */
      /* Termina nodo:132   */

      /* Empieza nodo:183 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(183)).setAttribute("nombre","prim1" );
      ((Element)v.get(183)).setAttribute("x","20" );
      ((Element)v.get(183)).setAttribute("y","422" );
      ((Element)v.get(183)).setAttribute("ID","botonContenido" );
      ((Element)v.get(183)).setAttribute("img","primera_on" );
      ((Element)v.get(183)).setAttribute("tipo","-2" );
      ((Element)v.get(183)).setAttribute("estado","false" );
      ((Element)v.get(183)).setAttribute("alt","" );
      ((Element)v.get(183)).setAttribute("codigo","" );
      ((Element)v.get(183)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(10)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(184)).setAttribute("nombre","separa" );
      ((Element)v.get(184)).setAttribute("x","59" );
      ((Element)v.get(184)).setAttribute("y","418" );
      ((Element)v.get(184)).setAttribute("ID","botonContenido" );
      ((Element)v.get(184)).setAttribute("img","separa_base" );
      ((Element)v.get(184)).setAttribute("tipo","0" );
      ((Element)v.get(184)).setAttribute("estado","false" );
      ((Element)v.get(184)).setAttribute("alt","" );
      ((Element)v.get(184)).setAttribute("codigo","" );
      ((Element)v.get(184)).setAttribute("accion","" );
      ((Element)v.get(10)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(185)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(185)).setAttribute("alto","12" );
      ((Element)v.get(185)).setAttribute("ancho","50" );
      ((Element)v.get(185)).setAttribute("colorf","" );
      ((Element)v.get(185)).setAttribute("borde","0" );
      ((Element)v.get(185)).setAttribute("imagenf","" );
      ((Element)v.get(185)).setAttribute("repeat","" );
      ((Element)v.get(185)).setAttribute("padding","" );
      ((Element)v.get(185)).setAttribute("visibilidad","visible" );
      ((Element)v.get(185)).setAttribute("contravsb","" );
      ((Element)v.get(185)).setAttribute("x","0" );
      ((Element)v.get(185)).setAttribute("y","441" );
      ((Element)v.get(185)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:10   */


   }

}
