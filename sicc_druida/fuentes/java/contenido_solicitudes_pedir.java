
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_solicitudes_pedir  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML900(doc);
         

      getXML990(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_solicitudes_pedir" );
      ((Element)v.get(0)).setAttribute("cod","0280" );
      ((Element)v.get(0)).setAttribute("titulo","Realizar simulación de descuento" );
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
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {\r    configurarMenuSecundario(\"formulario\");\r    fMostrarMensajeError();\r            accion('formulario.cbAcceso','.disabled=true');\r    focaliza('formulario.txtCodCliente');\r\r    DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='hidden';\r    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"btnDetalleDiv\"].style.visibility='hidden';\r    document.all[\"btnAnadirDiv\"].style.visibility='hidden';\r    \r    DrdEnsanchaConMargenDcho('listado2',12);\r    document.all[\"Cplistado2\"].style.visibility='hidden';\r    document.all[\"CpLin1listado2\"].style.visibility='hidden';\r    document.all[\"CpLin2listado2\"].style.visibility='hidden';\r    document.all[\"CpLin3listado2\"].style.visibility='hidden';\r    document.all[\"CpLin4listado2\"].style.visibility='hidden';\r    document.all[\"primera2Div\"].style.visibility='hidden';\r    document.all[\"ret2Div\"].style.visibility='hidden';\r    document.all[\"ava2Div\"].style.visibility='hidden';\r    document.all[\"separa2Div\"].style.visibility='hidden';\r    document.all[\"btnEliminarDiv\"].style.visibility='hidden';\r    document.all[\"btnAceptarDiv\"].style.visibility='hidden';\r    eval (ON_RSZ);  \r\r   }\r\r\r  function accionBuscarCliente()  {\r    var obj = new Object();\r    var whnd = mostrarModalSICC('LPBusquedaRapidaCliente','',obj);\r    if (whnd != null)  {\r      var oid = whnd[0];\r      var cod = whnd[1];\r      set(\"formulario.txtCodCliente\",cod);\r      set(\"formulario.hOidCliente\",oid);\r    }\r  }\r  function accionBuscar()  {\r      ocultarLista1();\r        configurarPaginado( mipgndo, 'PEDBuscarSolicitudesDTO','ConectorPedirSolicitudes','es.indra.sicc.dtos.dto.DTOBuscarSolicitudesDTO',armarArray() );\r  }\r\r  function armarArray()  {\r    var array = new Array();\r    var i = 0;\r    array[i] = new Array('oidIdioma',get('formulario.hOidIdioma'));\r\r        if (get('formulario.hidOidCliente') != '')  {\r      i++;\r      array[i] = new Array('oidCliente',get('formulario.hOidCliente'));\r    }\r    if (get('formulario.txtCodCliente') != '')  {\r      i++;\r      array[i] = new Array('codigoCliente',get('formulario.txtCodCliente'));\r    }\r\r    if (get('formulario.txtCodVentaProducto') != '')  {\r      i++;\r      array[i] = new Array('codigoVenta',get('formulario.txtCodVentaProducto'));\r    }\r    if (get('formulario.cbMarca') != '')  {\r      i++;\r      array[i] = new Array('oidMarca',get('formulario.cbMarca'));\r    }\r    if (get('formulario.cbCanal') != '')  {\r      i++;\r      array[i] = new Array('oidCanal',get('formulario.cbCanal'));\r    }\r    if (get('formulario.cbAcceso') != '')  {\r      i++;\r      array[i] = new Array('oidAcceso',get('formulario.cbAcceso'));\r    }\r    return array;\r  }\r\r\r  function visibilidadLista(rowset)  {\r    if (rowset.length == 0) {\r      btnProxy(4,'0');\r      ocultarLista1();\r      return false;\r    } else {\r      btnProxy(4,'1');\r      listado1.setDatos(rowset);\r      listado1.display();\r      mostrarLista1();\r      mostrarLista2();\r      return true;\r    }\r  }\r\r\r  function ocultarLista1()  {\r    document.all[\"Cplistado1\"].style.visibility='hidden';\r    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"btnDetalleDiv\"].style.visibility='hidden';\r    document.all[\"btnAnadirDiv\"].style.visibility='hidden';\r  }\r\r\r  function ocultarLista2()  {\r    document.all[\"Cplistado2\"].style.visibility='hidden';\r    document.all[\"CpLin1listado2\"].style.visibility='hidden';\r    document.all[\"CpLin2listado2\"].style.visibility='hidden';\r    document.all[\"CpLin3listado2\"].style.visibility='hidden';\r    document.all[\"CpLin4listado2\"].style.visibility='hidden';\r    document.all[\"primera2Div\"].style.visibility='hidden';\r    document.all[\"ret2Div\"].style.visibility='hidden';\r    document.all[\"ava2Div\"].style.visibility='hidden';\r    document.all[\"separa2Div\"].style.visibility='hidden';\r    document.all[\"btnEliminarDiv\"].style.visibility='hidden';\r    document.all[\"btnAceptarDiv\"].style.visibility='hidden';\r  }\r\r\r  function mostrarLista1()  {\r    document.all[\"Cplistado1\"].style.visibility='visible';\r    document.all[\"CpLin1listado1\"].style.visibility='visible';\r    document.all[\"CpLin2listado1\"].style.visibility='visible';\r    document.all[\"CpLin3listado1\"].style.visibility='visible';\r    document.all[\"CpLin4listado1\"].style.visibility='visible';\r    document.all[\"primera1Div\"].style.visibility='visible';\r    document.all[\"ret1Div\"].style.visibility='visible';\r    document.all[\"ava1Div\"].style.visibility='visible';\r    document.all[\"separaDiv\"].style.visibility='visible';\r    document.all[\"btnDetalleDiv\"].style.visibility='visible';\r    document.all[\"btnAnadirDiv\"].style.visibility='visible';\r  }\r\r\r  function mostrarLista2()  {\r    document.all[\"Cplistado2\"].style.visibility='visible';\r    document.all[\"CpLin1listado2\"].style.visibility='visible';\r    document.all[\"CpLin2listado2\"].style.visibility='visible';\r    document.all[\"CpLin3listado2\"].style.visibility='visible';\r    document.all[\"CpLin4listado2\"].style.visibility='visible';\r    document.all[\"primera2Div\"].style.visibility='visible';\r    document.all[\"ret2Div\"].style.visibility='visible';\r    document.all[\"ava2Div\"].style.visibility='visible';\r    document.all[\"separa2Div\"].style.visibility='visible';\r    document.all[\"btnEliminarDiv\"].style.visibility='visible';\r    document.all[\"btnAceptarDiv\"].style.visibility='visible';\r  }\r\rfunction fLimpiar() {\r\rlistado1.limpia(true);\rlistado2.limpia(true);\rocultarLista2()\rocultarLista1()\r\r}\r\r\r\r\r  function accionDetalle()  {\r            if ( listado1.codSeleccionados().length == 1 )  {\r      var parametros = new Object();\r      codigo = listado1.codSeleccionados();\r      parametros.hOidSolicitud = codigo[0].toString();\r      parametros.hCodCliente = listado1.extraeDato(codigo[0] ,0);\r      parametros.hNombreCliente = listado1.extraeDato(codigo[0] ,1);\r      parametros.hCampaniaSolicitud = listado1.extraeDato(codigo[0] ,2);\r      parametros.hFechaSolicitud = listado1.extraeDato(codigo[0] ,3);\r      parametros.hMontoTotalSolicitud = listado1.extraeDato(codigo[0] ,4);\r      mostrarModalSICC(\"LPPedirSolicitudes\",\"detalle\", parametros );\r    } else {\r        GestionarMensaje('2525');\r        document.all.btnDetalle.focus();\r      } \r  }\r      function accionAnyadir()  {\r    cantidadSel = listado1.codSeleccionados().length;\r\r    if ( cantidadSel != 0 )  {\r      codigosAnyadir = listado1.codSeleccionados();\r      var registro = new Array();\r      var e;\r      var noExiste;\r\r			for( f = 0; f < cantidadSel ; f++)  {\r        registro[f] = new Array();\r                e = 0;\r        noExiste = 'true';\r\r        while ( (e < listado2.codigos().length) && (noExiste == 'true') )  {\r          if ( codigosAnyadir[f] != listado2.codigos()[e] )  {\r            noExiste = 'true';\r          }\r          else {\r            noExiste = 'false';\r          }\r          e++;\r        }\r        if ( noExiste == 'true' )  {\r          registro[f][0] = codigosAnyadir[f];\r\r          for ( c = 0; c < 5; c++ )  {\r            registro[f][c+1] = listado1.extraeDato(codigosAnyadir[f],c);\r          }\r          listado2.insertar( registro[f] );\r        }\r\r      }\r    } else {\r        GestionarMensaje('1021');\r        document.all.btnAnadir.focus();\r      }\r  }\r  function accionEliminar()  {\r        if (listado2.numSelecc() != 0)  {\r      listado2.eliminarSelecc();\r    } else {\r        GestionarMensaje('1021');\r      }\r  }\r\r  function fBorrar()  {\r    accionEliminar();\r  }\r  function accionAceptar()  {\r                    var oidsRegistros = listado2.codigos();\r    if (oidsRegistros.length != 0)  {\r      set('formulario.accion','aceptar');\r      var oidsSeleccionados = '';\r      for ( f=0; f<oidsRegistros.length; f++ )  {\r        oidsSeleccionados = oidsSeleccionados + oidsRegistros[f] + \"|\";\r      }\r      set('formulario.hOidsSolicSelec', oidsSeleccionados );\r      enviaSICC('formulario');\r    } else {\r        GestionarMensaje('UIDTO0001');\r      }\r  }\r  function accionCanalOnChange()  {\r        accion('formulario.cbAcceso','.disabled=false');\r    var arr = new Array();\r    arr[arr.length] = new Array(\"oidIdioma\",get('formulario.hOidIdioma'));\r    arr[arr.length] = new Array(\"oidCanal\", get('formulario.cbCanal') );\r    recargaCombo('formulario.cbAcceso','SEGObtenerAccesosPorCanal','es.indra.sicc.dtos.seg.DTOAccesosPorCanal', arr );\r  }\r  function focalizarOnTabBB()  {\r    try {\r      document.all.btnDetalle.focus();\r    } catch (e)  {\r        focaliza('formulario.txtCodCliente');\r      }\r  }\r\r  function focalizarOnShTabTCVP()  {\r    try {\r      document.all.btnAceptar.focus();\r    } catch (e)  {\r        document.all.btnBuscar.focus();\r      }\r  }\r\r  function focalizarOnTabBD()  {\r    document.all.btnAnadir.focus();\r  }\r\r  function focalizarOnShTabBD()  {\r    document.all.btnBuscar.focus();\r  }\r\r  function focalizarOnTabBAn()  {\r    document.all.btnEliminar.focus();\r  }\r\r  function focalizarOnShTabBAn()  {\r    document.all.btnDetalle.focus();\r  }\r\r  function focalizarOnTabBE()  {\r    document.all.btnAceptar.focus();\r  }\r\r  function focalizarOnShTabBE()  {\r    document.all.btnAnadir.focus();\r  }\r\r  function focalizarOnTabBAc()  {\r    focaliza('formulario.txtCodCliente');\r  }\r\r  function focalizarOnShTabBAc()  {\r    document.all.btnEliminar.focus();\r  }\r\r\r\r  function onchange_codCliente(){\r          var codCliente = get('formulario.txtCodCliente');\r	      if (codCliente.length != 0)  {\r					 codigoCompleto = validarLongCodCliene(codCliente);\r					 set('formulario.txtCodCliente', codigoCompleto);\r          }\r   }\r\r\r  function validarLongCodCliene(codCliente) {\r			  var longiCod = get('formulario.hLongitudCodCliente');\r			  var faltantes = longiCod -  codCliente.length;\r			  var resultCod = new String(\"\");\r			  if(faltantes > 0){\r							for(var t = 0 ; t<faltantes; t++){\r															resultCod = resultCod + \"0\";\r							}\r							resultCod = resultCod + codCliente;\r							return resultCod;\r			  }\r			  return codCliente;\r   }\r\r\r\r    function fVolver()\r    {\r        set('formulario.conectorAction', 'LPSeleccionarDescuentos');\r        set('formulario.accion', '');\r        enviaSICC('formulario');\r    }\r\r\r\r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","LPPedirSolicitudes" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hOidIdioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hOidDescSel" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidDescSel" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hOidCliente" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hOidsSolicSelec" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hLongitudCodCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(17)).setAttribute("width","100%" );
      ((Element)v.get(17)).setAttribute("border","0" );
      ((Element)v.get(17)).setAttribute("cellspacing","0" );
      ((Element)v.get(17)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","12" );
      ((Element)v.get(19)).setAttribute("align","center" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("height","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","750" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","1" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:18   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(30)).setAttribute("class","legend" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(31)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(31)).setAttribute("alto","13" );
      ((Element)v.get(31)).setAttribute("filas","1" );
      ((Element)v.get(31)).setAttribute("id","legend" );
      ((Element)v.get(31)).setAttribute("cod","0075" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("align","center" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","687" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("align","left" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("colspan","4" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","8" );
      ((Element)v.get(38)).setAttribute("height","8" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:39 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("colspan","3" );
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(43)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(43)).setAttribute("alto","13" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(43)).setAttribute("id","datosTitle" );
      ((Element)v.get(43)).setAttribute("cod","263" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","25" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblCodVentaProducto" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","602" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(39)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:39   */

      /* Empieza nodo:50 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(50));

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
      ((Element)v.get(53)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(54)).setAttribute("nombre","txtCodCliente" );
      ((Element)v.get(54)).setAttribute("id","datosCampos" );
      ((Element)v.get(54)).setAttribute("max","15" );
      ((Element)v.get(54)).setAttribute("tipo","" );
      ((Element)v.get(54)).setAttribute("onshtab","focalizarOnShTabTCVP();" );
      ((Element)v.get(54)).setAttribute("onchange","onchange_codCliente();" );
      ((Element)v.get(54)).setAttribute("req","N" );
      ((Element)v.get(54)).setAttribute("size","19" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(54)).setAttribute("validacion","" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(58)).setAttribute("onclick","accionBuscarCliente();" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","25" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(62)).setAttribute("nombre","txtCodVentaProducto" );
      ((Element)v.get(62)).setAttribute("id","datosCampos" );
      ((Element)v.get(62)).setAttribute("max","18" );
      ((Element)v.get(62)).setAttribute("tipo","" );
      ((Element)v.get(62)).setAttribute("onchange","" );
      ((Element)v.get(62)).setAttribute("req","N" );
      ((Element)v.get(62)).setAttribute("size","18" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(62)).setAttribute("validacion","" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(50)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:50   */

      /* Empieza nodo:65 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("colspan","4" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:68 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("table"));
      ((Element)v.get(70)).setAttribute("width","687" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).setAttribute("border","0" );
      ((Element)v.get(70)).setAttribute("align","left" );
      ((Element)v.get(70)).setAttribute("cellspacing","0" );
      ((Element)v.get(70)).setAttribute("cellpadding","0" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(75)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(75)).setAttribute("alto","13" );
      ((Element)v.get(75)).setAttribute("filas","1" );
      ((Element)v.get(75)).setAttribute("id","datosTitle" );
      ((Element)v.get(75)).setAttribute("cod","6" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","25" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(79)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(79)).setAttribute("alto","13" );
      ((Element)v.get(79)).setAttribute("filas","1" );
      ((Element)v.get(79)).setAttribute("id","datosTitle" );
      ((Element)v.get(79)).setAttribute("cod","7" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","25" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(83)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("id","datosTitle" );
      ((Element)v.get(83)).setAttribute("cod","10" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","100%" );
      ((Element)v.get(71)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:71   */

      /* Empieza nodo:86 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(86)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(90)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(90)).setAttribute("id","datosCampos" );
      ((Element)v.get(90)).setAttribute("size","1" );
      ((Element)v.get(90)).setAttribute("multiple","N" );
      ((Element)v.get(90)).setAttribute("req","N" );
      ((Element)v.get(90)).setAttribute("valorinicial","" );
      ((Element)v.get(90)).setAttribute("textoinicial","" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).setAttribute("width","25" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(86)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(95)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(95)).setAttribute("onchange","accionCanalOnChange();" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("size","1" );
      ((Element)v.get(95)).setAttribute("multiple","N" );
      ((Element)v.get(95)).setAttribute("req","N" );
      ((Element)v.get(95)).setAttribute("valorinicial","" );
      ((Element)v.get(95)).setAttribute("textoinicial","" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:97 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","25" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(86)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(100)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(100)).setAttribute("id","datosCampos" );
      ((Element)v.get(100)).setAttribute("size","1" );
      ((Element)v.get(100)).setAttribute("multiple","N" );
      ((Element)v.get(100)).setAttribute("req","N" );
      ((Element)v.get(100)).setAttribute("valorinicial","" );
      ((Element)v.get(100)).setAttribute("textoinicial","" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:102 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","100%" );
      ((Element)v.get(86)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:86   */

      /* Empieza nodo:104 / Elemento padre: 70   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("colspan","4" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:32   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:107 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:25   */

      /* Empieza nodo:109 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("table"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(114)).setAttribute("border","0" );
      ((Element)v.get(114)).setAttribute("align","center" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("cellpadding","0" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("class","botonera" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(117)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(117)).setAttribute("ontab","focalizarOnTabBB();" );
      ((Element)v.get(117)).setAttribute("ID","botonContenido" );
      ((Element)v.get(117)).setAttribute("tipo","html" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(117)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(117)).setAttribute("estado","false" );
      ((Element)v.get(117)).setAttribute("cod","1" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:118 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","12" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:109   */

      /* Empieza nodo:120 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","12" );
      ((Element)v.get(121)).setAttribute("align","center" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","12" );
      ((Element)v.get(122)).setAttribute("height","12" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","756" );
      ((Element)v.get(120)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","12" );
      ((Element)v.get(120)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","12" );
      ((Element)v.get(126)).setAttribute("height","1" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:120   */
      /* Termina nodo:17   */

      /* Empieza nodo:127 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(127)).setAttribute("nombre","listado1" );
      ((Element)v.get(127)).setAttribute("ancho","691" );
      ((Element)v.get(127)).setAttribute("alto","301" );
      ((Element)v.get(127)).setAttribute("x","12" );
      ((Element)v.get(127)).setAttribute("y","163" );
      ((Element)v.get(127)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(127)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(128)).setAttribute("precarga","S" );
      ((Element)v.get(128)).setAttribute("conROver","S" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(129)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(129)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(129)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(129)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 128   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(130)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(130)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(130)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(130)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(128)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(131)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(131)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:128   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(133)).setAttribute("borde","1" );
      ((Element)v.get(133)).setAttribute("horizDatos","1" );
      ((Element)v.get(133)).setAttribute("horizCabecera","1" );
      ((Element)v.get(133)).setAttribute("vertical","1" );
      ((Element)v.get(133)).setAttribute("horizTitulo","1" );
      ((Element)v.get(133)).setAttribute("horizBase","1" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 132   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(134)).setAttribute("borde","#999999" );
      ((Element)v.get(134)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(134)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(134)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(134)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(134)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(134)).setAttribute("horizBase","#999999" );
      ((Element)v.get(132)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:132   */

      /* Empieza nodo:135 / Elemento padre: 127   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(135)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(135)).setAttribute("alto","22" );
      ((Element)v.get(135)).setAttribute("imgFondo","" );
      ((Element)v.get(135)).setAttribute("cod","00135" );
      ((Element)v.get(135)).setAttribute("ID","datosTitle" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(127)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 127   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(136)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(136)).setAttribute("alto","22" );
      ((Element)v.get(136)).setAttribute("imgFondo","" );
      ((Element)v.get(127)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 127   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(137)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(137)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(137)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(137)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(137)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(137)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(127)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("ancho","26" );
      ((Element)v.get(138)).setAttribute("minimizable","S" );
      ((Element)v.get(138)).setAttribute("minimizada","N" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("ancho","40" );
      ((Element)v.get(139)).setAttribute("minimizable","S" );
      ((Element)v.get(139)).setAttribute("minimizada","N" );
      ((Element)v.get(139)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(137)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("ancho","13" );
      ((Element)v.get(140)).setAttribute("minimizable","S" );
      ((Element)v.get(140)).setAttribute("minimizada","N" );
      ((Element)v.get(137)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("ancho","26" );
      ((Element)v.get(141)).setAttribute("minimizable","S" );
      ((Element)v.get(141)).setAttribute("minimizada","N" );
      ((Element)v.get(137)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 137   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("ancho","23" );
      ((Element)v.get(142)).setAttribute("minimizable","S" );
      ((Element)v.get(142)).setAttribute("minimizada","N" );
      ((Element)v.get(142)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(137)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:137   */

      /* Empieza nodo:143 / Elemento padre: 127   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(143)).setAttribute("alto","20" );
      ((Element)v.get(143)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(143)).setAttribute("imgFondo","" );
      ((Element)v.get(143)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(127)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("colFondo","" );
      ((Element)v.get(144)).setAttribute("ID","EstCab" );
      ((Element)v.get(144)).setAttribute("align","center" );
      ((Element)v.get(144)).setAttribute("cod","263" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Elemento padre:144 / Elemento actual: 145   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(144)).appendChild((Text)v.get(145));

      /* Termina nodo Texto:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("colFondo","" );
      ((Element)v.get(146)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).setAttribute("cod","264" );
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Elemento padre:146 / Elemento actual: 147   */
      v.add(doc.createTextNode("Nombre cliente"));
      ((Element)v.get(146)).appendChild((Text)v.get(147));

      /* Termina nodo Texto:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("colFondo","" );
      ((Element)v.get(148)).setAttribute("ID","EstCab" );
      ((Element)v.get(148)).setAttribute("cod","810" );
      ((Element)v.get(143)).appendChild((Element)v.get(148));

      /* Elemento padre:148 / Elemento actual: 149   */
      v.add(doc.createTextNode("Campaña"));
      ((Element)v.get(148)).appendChild((Text)v.get(149));

      /* Termina nodo Texto:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("colFondo","" );
      ((Element)v.get(150)).setAttribute("ID","EstCab" );
      ((Element)v.get(150)).setAttribute("cod","188" );
      ((Element)v.get(143)).appendChild((Element)v.get(150));

      /* Elemento padre:150 / Elemento actual: 151   */
      v.add(doc.createTextNode("Fecha"));
      ((Element)v.get(150)).appendChild((Text)v.get(151));

      /* Termina nodo Texto:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 143   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("colFondo","" );
      ((Element)v.get(152)).setAttribute("ID","EstCab" );
      ((Element)v.get(152)).setAttribute("cod","920" );
      ((Element)v.get(143)).appendChild((Element)v.get(152));

      /* Elemento padre:152 / Elemento actual: 153   */
      v.add(doc.createTextNode("Monto total"));
      ((Element)v.get(152)).appendChild((Text)v.get(153));

      /* Termina nodo Texto:153   */
      /* Termina nodo:152   */
      /* Termina nodo:143   */

      /* Empieza nodo:154 / Elemento padre: 127   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(154)).setAttribute("alto","22" );
      ((Element)v.get(154)).setAttribute("accion","" );
      ((Element)v.get(154)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(154)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(154)).setAttribute("maxSel","-1" );
      ((Element)v.get(154)).setAttribute("msgErrMaxSel","" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(154)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(154)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(154)).setAttribute("onLoad","" );
      ((Element)v.get(154)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(127)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("tipo","texto" );
      ((Element)v.get(155)).setAttribute("ID","EstDat" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("tipo","texto" );
      ((Element)v.get(156)).setAttribute("ID","EstDat2" );
      ((Element)v.get(154)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("tipo","texto" );
      ((Element)v.get(157)).setAttribute("ID","EstDat" );
      ((Element)v.get(154)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("tipo","texto" );
      ((Element)v.get(158)).setAttribute("ID","EstDat2" );
      ((Element)v.get(154)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("tipo","texto" );
      ((Element)v.get(159)).setAttribute("ID","EstDat" );
      ((Element)v.get(154)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:154   */

      /* Empieza nodo:160 / Elemento padre: 127   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(127)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 127   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(161)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(161)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'visibilidadLista(rowset)')" );
      ((Element)v.get(161)).setAttribute("ancho","691" );
      ((Element)v.get(161)).setAttribute("sep","$" );
      ((Element)v.get(161)).setAttribute("x","12" );
      ((Element)v.get(161)).setAttribute("class","botonera" );
      ((Element)v.get(161)).setAttribute("y","441" );
      ((Element)v.get(161)).setAttribute("control","|" );
      ((Element)v.get(161)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(161)).setAttribute("rowset","" );
      ((Element)v.get(161)).setAttribute("cargainicial","N" );
      ((Element)v.get(127)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(162)).setAttribute("nombre","ret1" );
      ((Element)v.get(162)).setAttribute("x","37" );
      ((Element)v.get(162)).setAttribute("y","445" );
      ((Element)v.get(162)).setAttribute("ID","botonContenido" );
      ((Element)v.get(162)).setAttribute("img","retroceder_on" );
      ((Element)v.get(162)).setAttribute("tipo","0" );
      ((Element)v.get(162)).setAttribute("estado","false" );
      ((Element)v.get(162)).setAttribute("alt","" );
      ((Element)v.get(162)).setAttribute("codigo","" );
      ((Element)v.get(162)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 161   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(163)).setAttribute("nombre","ava1" );
      ((Element)v.get(163)).setAttribute("x","52" );
      ((Element)v.get(163)).setAttribute("y","445" );
      ((Element)v.get(163)).setAttribute("ID","botonContenido" );
      ((Element)v.get(163)).setAttribute("img","avanzar_on" );
      ((Element)v.get(163)).setAttribute("tipo","0" );
      ((Element)v.get(163)).setAttribute("estado","false" );
      ((Element)v.get(163)).setAttribute("alt","" );
      ((Element)v.get(163)).setAttribute("codigo","" );
      ((Element)v.get(163)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(161)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:161   */
      /* Termina nodo:127   */

      /* Empieza nodo:164 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(164)).setAttribute("nombre","primera1" );
      ((Element)v.get(164)).setAttribute("x","20" );
      ((Element)v.get(164)).setAttribute("y","445" );
      ((Element)v.get(164)).setAttribute("ID","botonContenido" );
      ((Element)v.get(164)).setAttribute("img","primera_on" );
      ((Element)v.get(164)).setAttribute("tipo","-2" );
      ((Element)v.get(164)).setAttribute("estado","false" );
      ((Element)v.get(164)).setAttribute("alt","" );
      ((Element)v.get(164)).setAttribute("codigo","" );
      ((Element)v.get(164)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(165)).setAttribute("nombre","separa" );
      ((Element)v.get(165)).setAttribute("x","59" );
      ((Element)v.get(165)).setAttribute("y","441" );
      ((Element)v.get(165)).setAttribute("ID","botonContenido" );
      ((Element)v.get(165)).setAttribute("img","separa_base" );
      ((Element)v.get(165)).setAttribute("tipo","0" );
      ((Element)v.get(165)).setAttribute("estado","false" );
      ((Element)v.get(165)).setAttribute("alt","" );
      ((Element)v.get(165)).setAttribute("codigo","" );
      ((Element)v.get(165)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(166)).setAttribute("nombre","btnDetalle" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(166)).setAttribute("ontab","focalizarOnTabBD();" );
      ((Element)v.get(166)).setAttribute("onshtab","focalizarOnShTabBD();" );
      ((Element)v.get(166)).setAttribute("accion","accionDetalle();" );
      ((Element)v.get(166)).setAttribute("x","80" );
      ((Element)v.get(166)).setAttribute("y","442" );
      ((Element)v.get(166)).setAttribute("ID","botonContenido" );
      ((Element)v.get(166)).setAttribute("tipo","html" );
      ((Element)v.get(166)).setAttribute("estado","false" );
      ((Element)v.get(166)).setAttribute("cod","3" );
      ((Element)v.get(6)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(167)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(167)).setAttribute("ontab","focalizarOnTabBAn();" );
      ((Element)v.get(167)).setAttribute("onshtab","focalizarOnShTabBAn();" );
      ((Element)v.get(167)).setAttribute("accion","accionAnyadir();" );
      ((Element)v.get(167)).setAttribute("x","128" );
      ((Element)v.get(167)).setAttribute("y","442" );
      ((Element)v.get(167)).setAttribute("ID","botonContenido" );
      ((Element)v.get(167)).setAttribute("tipo","html" );
      ((Element)v.get(167)).setAttribute("estado","false" );
      ((Element)v.get(167)).setAttribute("cod","404" );
      ((Element)v.get(6)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(168)).setAttribute("nombre","listado2" );
      ((Element)v.get(168)).setAttribute("ancho","691" );
      ((Element)v.get(168)).setAttribute("alto","301" );
      ((Element)v.get(168)).setAttribute("x","12" );
      ((Element)v.get(168)).setAttribute("y","488" );
      ((Element)v.get(168)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(168)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(169)).setAttribute("precarga","S" );
      ((Element)v.get(169)).setAttribute("conROver","S" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(170)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(170)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(170)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(170)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 169   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(171)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(171)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(171)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(171)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(172)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(172)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:169   */

      /* Empieza nodo:173 / Elemento padre: 168   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(168)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(174)).setAttribute("borde","1" );
      ((Element)v.get(174)).setAttribute("horizDatos","1" );
      ((Element)v.get(174)).setAttribute("horizCabecera","1" );
      ((Element)v.get(174)).setAttribute("vertical","1" );
      ((Element)v.get(174)).setAttribute("horizTitulo","1" );
      ((Element)v.get(174)).setAttribute("horizBase","1" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 173   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(175)).setAttribute("borde","#999999" );
      ((Element)v.get(175)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(175)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(175)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(175)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(175)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(175)).setAttribute("horizBase","#999999" );
      ((Element)v.get(173)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:173   */

      /* Empieza nodo:176 / Elemento padre: 168   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(176)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(176)).setAttribute("alto","22" );
      ((Element)v.get(176)).setAttribute("imgFondo","" );
      ((Element)v.get(176)).setAttribute("cod","00619" );
      ((Element)v.get(176)).setAttribute("ID","datosTitle" );
      ((Element)v.get(168)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 168   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(177)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(177)).setAttribute("alto","22" );
      ((Element)v.get(177)).setAttribute("imgFondo","" );
      ((Element)v.get(168)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 168   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(178)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(178)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(178)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(178)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(178)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(178)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(168)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("ancho","26" );
      ((Element)v.get(179)).setAttribute("minimizable","S" );
      ((Element)v.get(179)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("ancho","40" );
      ((Element)v.get(180)).setAttribute("minimizable","S" );
      ((Element)v.get(180)).setAttribute("minimizada","N" );
      ((Element)v.get(180)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(178)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("ancho","13" );
      ((Element)v.get(181)).setAttribute("minimizable","S" );
      ((Element)v.get(181)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("ancho","26" );
      ((Element)v.get(182)).setAttribute("minimizable","S" );
      ((Element)v.get(182)).setAttribute("minimizada","N" );
      ((Element)v.get(178)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("ancho","23" );
      ((Element)v.get(183)).setAttribute("minimizable","S" );
      ((Element)v.get(183)).setAttribute("minimizada","N" );
      ((Element)v.get(183)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(178)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:178   */

      /* Empieza nodo:184 / Elemento padre: 168   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(184)).setAttribute("alto","20" );
      ((Element)v.get(184)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(184)).setAttribute("imgFondo","" );
      ((Element)v.get(184)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(168)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("colFondo","" );
      ((Element)v.get(185)).setAttribute("ID","EstCab" );
      ((Element)v.get(185)).setAttribute("align","center" );
      ((Element)v.get(185)).setAttribute("cod","263" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Elemento padre:185 / Elemento actual: 186   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(185)).appendChild((Text)v.get(186));

      /* Termina nodo Texto:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("colFondo","" );
      ((Element)v.get(187)).setAttribute("ID","EstCab" );
      ((Element)v.get(187)).setAttribute("cod","264" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));

      /* Elemento padre:187 / Elemento actual: 188   */
      v.add(doc.createTextNode("Nombre cliente"));
      ((Element)v.get(187)).appendChild((Text)v.get(188));

      /* Termina nodo Texto:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("colFondo","" );
      ((Element)v.get(189)).setAttribute("ID","EstCab" );
      ((Element)v.get(189)).setAttribute("cod","810" );
      ((Element)v.get(184)).appendChild((Element)v.get(189));

      /* Elemento padre:189 / Elemento actual: 190   */
      v.add(doc.createTextNode("Campaña"));
      ((Element)v.get(189)).appendChild((Text)v.get(190));

      /* Termina nodo Texto:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("colFondo","" );
      ((Element)v.get(191)).setAttribute("ID","EstCab" );
      ((Element)v.get(191)).setAttribute("cod","188" );
      ((Element)v.get(184)).appendChild((Element)v.get(191));

      /* Elemento padre:191 / Elemento actual: 192   */
      v.add(doc.createTextNode("Fecha"));
      ((Element)v.get(191)).appendChild((Text)v.get(192));

      /* Termina nodo Texto:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("colFondo","" );
      ((Element)v.get(193)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).setAttribute("cod","920" );
      ((Element)v.get(184)).appendChild((Element)v.get(193));

      /* Elemento padre:193 / Elemento actual: 194   */
      v.add(doc.createTextNode("Monto total"));
      ((Element)v.get(193)).appendChild((Text)v.get(194));

      /* Termina nodo Texto:194   */
      /* Termina nodo:193   */
      /* Termina nodo:184   */

      /* Empieza nodo:195 / Elemento padre: 168   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(195)).setAttribute("alto","22" );
      ((Element)v.get(195)).setAttribute("accion","" );
      ((Element)v.get(195)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(195)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(195)).setAttribute("maxSel","-1" );
      ((Element)v.get(195)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(195)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(195)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(195)).setAttribute("onLoad","" );
      ((Element)v.get(195)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(168)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("tipo","texto" );
      ((Element)v.get(196)).setAttribute("ID","EstDat" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("tipo","texto" );
      ((Element)v.get(197)).setAttribute("ID","EstDat2" );
      ((Element)v.get(195)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(198)).setAttribute("tipo","texto" );
      ((Element)v.get(198)).setAttribute("ID","EstDat" );
      ((Element)v.get(195)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("tipo","texto" );
      ((Element)v.get(199)).setAttribute("ID","EstDat2" );
      ((Element)v.get(195)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 195   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("tipo","texto" );
      ((Element)v.get(200)).setAttribute("ID","EstDat" );
      ((Element)v.get(195)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:195   */

      /* Empieza nodo:201 / Elemento padre: 168   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(168)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 168   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(202)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(202)).setAttribute("ancho","691" );
      ((Element)v.get(202)).setAttribute("sep","$" );
      ((Element)v.get(202)).setAttribute("x","12" );
      ((Element)v.get(202)).setAttribute("class","botonera" );
      ((Element)v.get(202)).setAttribute("y","766" );
      ((Element)v.get(202)).setAttribute("control","|" );
      ((Element)v.get(202)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(202)).setAttribute("rowset","" );
      ((Element)v.get(202)).setAttribute("cargainicial","N" );
      ((Element)v.get(168)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(203)).setAttribute("nombre","ret2" );
      ((Element)v.get(203)).setAttribute("x","37" );
      ((Element)v.get(203)).setAttribute("y","770" );
      ((Element)v.get(203)).setAttribute("ID","botonContenido" );
      ((Element)v.get(203)).setAttribute("img","retroceder_on" );
      ((Element)v.get(203)).setAttribute("tipo","0" );
      ((Element)v.get(203)).setAttribute("estado","false" );
      ((Element)v.get(203)).setAttribute("alt","" );
      ((Element)v.get(203)).setAttribute("codigo","" );
      ((Element)v.get(203)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 202   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(204)).setAttribute("nombre","ava2" );
      ((Element)v.get(204)).setAttribute("x","52" );
      ((Element)v.get(204)).setAttribute("y","770" );
      ((Element)v.get(204)).setAttribute("ID","botonContenido" );
      ((Element)v.get(204)).setAttribute("img","avanzar_on" );
      ((Element)v.get(204)).setAttribute("tipo","0" );
      ((Element)v.get(204)).setAttribute("estado","false" );
      ((Element)v.get(204)).setAttribute("alt","" );
      ((Element)v.get(204)).setAttribute("codigo","" );
      ((Element)v.get(204)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(202)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:202   */
      /* Termina nodo:168   */

      /* Empieza nodo:205 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(205)).setAttribute("nombre","primera2" );
      ((Element)v.get(205)).setAttribute("x","20" );
      ((Element)v.get(205)).setAttribute("y","770" );
      ((Element)v.get(205)).setAttribute("ID","botonContenido" );
      ((Element)v.get(205)).setAttribute("img","primera_on" );
      ((Element)v.get(205)).setAttribute("tipo","-2" );
      ((Element)v.get(205)).setAttribute("estado","false" );
      ((Element)v.get(205)).setAttribute("alt","" );
      ((Element)v.get(205)).setAttribute("codigo","" );
      ((Element)v.get(205)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(206)).setAttribute("nombre","separa2" );
      ((Element)v.get(206)).setAttribute("x","59" );
      ((Element)v.get(206)).setAttribute("y","766" );
      ((Element)v.get(206)).setAttribute("ID","botonContenido" );
      ((Element)v.get(206)).setAttribute("img","separa_base" );
      ((Element)v.get(206)).setAttribute("tipo","0" );
      ((Element)v.get(206)).setAttribute("estado","false" );
      ((Element)v.get(206)).setAttribute("alt","" );
      ((Element)v.get(206)).setAttribute("codigo","" );
      ((Element)v.get(206)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(207)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(207)).setAttribute("ontab","focalizarOnTabBE();" );
      ((Element)v.get(207)).setAttribute("onshtab","focalizarOnShTabBE();" );
      ((Element)v.get(207)).setAttribute("accion","accionEliminar();" );
      ((Element)v.get(207)).setAttribute("x","13" );
      ((Element)v.get(207)).setAttribute("y","767" );
      ((Element)v.get(207)).setAttribute("ID","botonContenido" );
      ((Element)v.get(207)).setAttribute("tipo","html" );
      ((Element)v.get(207)).setAttribute("estado","false" );
      ((Element)v.get(207)).setAttribute("cod","1254" );
      ((Element)v.get(6)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(208)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(208)).setAttribute("ontab","focalizarOnTabBAc();" );
      ((Element)v.get(208)).setAttribute("onshtab","focalizarOnShTabBAc();" );
      ((Element)v.get(208)).setAttribute("accion","accionAceptar();" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(208)).setAttribute("x","67" );
      ((Element)v.get(208)).setAttribute("y","767" );
      ((Element)v.get(208)).setAttribute("ID","botonContenido" );
      ((Element)v.get(208)).setAttribute("tipo","html" );
      ((Element)v.get(208)).setAttribute("estado","false" );
      ((Element)v.get(208)).setAttribute("cod","12" );
      ((Element)v.get(6)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(209)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(209)).setAttribute("alto","12" );
      ((Element)v.get(209)).setAttribute("ancho","100%" );
      ((Element)v.get(209)).setAttribute("colorf","" );
      ((Element)v.get(209)).setAttribute("borde","0" );
      ((Element)v.get(209)).setAttribute("imagenf","" );
      ((Element)v.get(209)).setAttribute("repeat","" );
      ((Element)v.get(209)).setAttribute("padding","" );
      ((Element)v.get(209)).setAttribute("visibilidad","visible" );
      ((Element)v.get(209)).setAttribute("contravsb","" );
      ((Element)v.get(209)).setAttribute("x","0" );
      ((Element)v.get(209)).setAttribute("y","789" );
      ((Element)v.get(209)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:6   */


   }

}
