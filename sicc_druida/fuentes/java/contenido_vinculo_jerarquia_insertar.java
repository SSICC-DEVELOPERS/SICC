
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_vinculo_jerarquia_insertar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_vinculo_jerarquia_insertar" );
      ((Element)v.get(0)).setAttribute("cod","0639" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r   \r\r  var limpiar = \"\";\r  var varNoLimpiarSICC = true;\r\r  function onLoadPag()   {\r\r      configurarMenuSecundario(\"frmVinculo\");\r      \r      if (get('frmVinculo.hContDefCbAcceso') == \"\")\r          guardarContCombos('frmVinculo.cbAcceso', 'frmVinculo.hContDefCbAcceso');\r      if (get('frmVinculo.hContDefCbSubacceso') == \"\")\r          guardarContCombos('frmVinculo.cbSubacceso', 'frmVinculo.hContDefCbSubacceso');\r\r		  if (get('frmVinculo.errDescripcion')!='') {\r          cargarCombosDependientes();\r          posicionarCombos();\r        	mostrarCodigoError();\r          focaliza('frmVinculo.cbMarca'); \r      } else {\r          if (get('frmVinculo.accion') == \"detalle\") {\r              accionDetalle();\r          } else {\r              posicionarCombos();\r              focaliza('frmVinculo.cbMarca'); \r              if (get('frmVinculo.hCanal') == \"\")\r                  accion('frmVinculo.cbAcceso','.disabled=true');\r              if (get('frmVinculo.hAcceso') == \"\")\r                  accion('frmVinculo.cbSubacceso','.disabled=true');\r          }\r      }\r    \r  }\r\r   function mostrarCodigoError() {  \r	     \r		  var vErrCodigo = get('frmVinculo.errCodigo');\r		  var vErrDescrip = get('frmVinculo.errDescripcion');\r\r		  if (get('frmVinculo.errDescripcion')!=''){\r      		var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);\r      }		\r	       \r    }\r\r    function cargarCombosDependientes() {\r          cbSubacceso.disabled = true;\r          if( get( 'frmVinculo.hContCbAcceso' ) != '' ) {\r            var aComboA = new Array();\r            if( get('frmVinculo.hAcceso') != '' ) {\r                aComboA[0] = get('frmVinculo.hAcceso');\r                cbSubacceso.disabled = false;\r            } else {\r                cbSubacceso.disabled = true;\r            }\r            set_combo( 'frmVinculo.cbAcceso', eval(get( 'frmVinculo.hContCbAcceso' )), aComboA );\r          } else {\r            cbAcceso.disabled = true;\r          }\r\r          if( get( 'frmVinculo.hContCbSubacceso' ) != '' ) {\r            var aComboS = new Array();\r            if( get('frmVinculo.hSubacceso') != '' ) {\r                aComboS[0] = get('frmVinculo.hSubacceso');\r            }\r            set_combo( 'frmVinculo.cbSubacceso', eval(get( 'frmVinculo.hContCbSubacceso' )), aComboS );\r          }\r\r\r    }\r\r   function posicionarCombos() \r   {\r      var aCombo = new Array();\r      if (get('frmVinculo.hMarca') != \"\") {\r        aCombo[0] = get('frmVinculo.hMarca');\r        set('frmVinculo.cbMarca',aCombo);\r      }\r      if (get('frmVinculo.hCanal') != \"\") {\r        aCombo[0] = get('frmVinculo.hCanal');\r        set('frmVinculo.cbCanal',aCombo);\r      }\r      if (get('frmVinculo.hAcceso') != \"\") {\r        aCombo[0] = get('frmVinculo.hAcceso');\r        set('frmVinculo.cbAcceso',aCombo);\r      }\r      if (get('frmVinculo.hSubacceso') != \"\") {\r        aCombo[0] = get('frmVinculo.hSubacceso');\r        set('frmVinculo.cbSubacceso',aCombo);\r      }\r      if (get('frmVinculo.hEmpresa') != \"\") {\r        aCombo[0] = get('frmVinculo.hEmpresa');\r        set('frmVinculo.cbEmpresa',aCombo);\r      }\r   }\r\r\r  function accionDetalle() {\r          accion('frmVinculo.cbMarca','.disabled=true');\r          accion('frmVinculo.cbCanal','.disabled=true');\r          accion('frmVinculo.cbAcceso','.disabled=true');\r          accion('frmVinculo.cbSubacceso','.disabled=true');\r          accion('frmVinculo.cbEmpresa','.disabled=true');\r          if (get('frmVinculo.hCasoDeUsoDeta') ==\"eliminar\")\r              parent.frames[\"iconos\"].txt_to(\"etiqueta1\",GestionarMensaje(\"1524\"));\r          else\r              parent.frames[\"iconos\"].txt_to(\"etiqueta1\",GestionarMensaje(\"1523\"));\r          \r          var aCombo = new Array();\r          var datos;\r          if (get('frmVinculo.hListaMarca') != \"\") {\r            datos = [[\"1\", get('frmVinculo.hListaMarca')]];\r      			set_combo('frmVinculo.cbMarca', eval(datos), aCombo);\r          }\r          if (get('frmVinculo.hListaCanal') != \"\") {\r            datos = [[\"1\", get('frmVinculo.hListaCanal')]];\r      			set_combo('frmVinculo.cbCanal', eval(datos), aCombo);\r          }\r          if (get('frmVinculo.hListaAcceso') != \"\") {\r            datos = [[\"1\", get('frmVinculo.hListaAcceso')]];\r      			set_combo('frmVinculo.cbAcceso', eval(datos), aCombo);\r          }\r          if (get('frmVinculo.hListaSubacceso') != \"\") {\r            datos = [[\"1\", get('frmVinculo.hListaSubacceso')]];\r      			set_combo('frmVinculo.cbSubacceso', eval(datos), aCombo);\r          }\r          if (get('frmVinculo.hListaEmpresa') != \"\") {\r            datos = [[\"1\", get('frmVinculo.hListaEmpresa')]];\r      			set_combo('frmVinculo.cbEmpresa', eval(datos), aCombo);\r          }\r  }\r\r\r    function canalOnChange () {  \r\r      if (get('frmVinculo.cbCanal')!='') {\r          var arr = new Array();\r          arr[arr.length]=new Array('oid', get('frmVinculo.cbCanal'));\r          arr[arr.length]=new Array('oidIdioma', get('frmVinculo.hIdioma'));\r\r          recargaCombo('frmVinculo.cbAcceso', 'SEGObtenerAccesosSinFiltro', 'es.indra.sicc.util.DTOOID', arr);\r          accion('frmVinculo.cbAcceso','.disabled=false');\r \r          var  aComboS = new Array();\r          aComboS[0] = \"\";\r          set('frmVinculo.cbSubacceso',aComboS);\r          accion('frmVinculo.cbSubacceso','.disabled=true');\r\r          \r      } else {\r         accion('frmVinculo.cbAcceso','.disabled=true');\r          accion('frmVinculo.cbSubacceso','.disabled=true');\r          var aCombo = new Array(new Array(\"\",\"\"));\r          set_combo('frmVinculo.cbSubacceso',aCombo, []);\r          set_combo('frmVinculo.cbAcceso',aCombo, []);\r                          }\r      \r    }\r\r    function accesoOnChange () {  \r\r      if (get('frmVinculo.cbAcceso')!='') {\r          var arr = new Array();\r          arr[arr.length]=new Array('oid', get('frmVinculo.cbAcceso') == null ? \"\" : get('frmVinculo.cbAcceso'));\r          arr[arr.length]=new Array('oidIdioma', get('frmVinculo.hIdioma'));\r\r          recargaCombo('frmVinculo.cbSubacceso', 'SEGObtenerSubccesosSinFiltro', 'es.indra.sicc.util.DTOOID', arr);\r          accion('frmVinculo.cbSubacceso','.disabled=false');\r      } else {\r          accion('frmVinculo.cbSubacceso','.disabled=true');\r          var aCombo = new Array();\r          aCombo[0] = \"\";\r          set('frmVinculo.cbSubacceso',aCombo);\r      }\r\r    }\r\r\r    function guardarContCombos( cmb, hidd ){\r\r      var longitud = combo_get( cmb, 'L' );\r      var strArray = '[';\r      var i;\r\r      for( i = 0; i < longitud; i++ ){\r        strArray = strArray + '[\"' + combo_get( cmb, 'V', i ) + '\", \"' + combo_get( cmb, 'T', i ) + '\"]';\r        if( i < (longitud - 1) ){\r          strArray = strArray + ', ';\r        }\r      }\r      strArray = strArray + ']';\r\r                        set( hidd, strArray );\r    }\r\r    \r    function enviarFormulario() \r    {\r                set('frmVinculo.hMarca', get('frmVinculo.cbMarca'));\r        set('frmVinculo.hCanal', get('frmVinculo.cbCanal'));\r        set('frmVinculo.hAcceso', get('frmVinculo.cbAcceso'));\r        set('frmVinculo.hSubacceso', get('frmVinculo.cbSubacceso'));\r        set('frmVinculo.hEmpresa', get('frmVinculo.cbEmpresa'));\r        \r        enviaSICC('frmVinculo');\r    }\r\r    function fGuardar() {\r        if (get('frmVinculo.cbMarca') == \"\" && get('frmVinculo.cbCanal') == \"\" && get('frmVinculo.cbAcceso') == \"\" &&\r           get('frmVinculo.cbSubacceso') == \"\" && get('frmVinculo.cbEmpresa') == \"\") {\r              GestionarMensaje(\"1513\");\r              focaliza('frmVinculo.cbMarca'); \r              return;\r        }\r\r        guardarContCombos('frmVinculo.cbAcceso', 'frmVinculo.hContCbAcceso');\r        guardarContCombos('frmVinculo.cbSubacceso', 'frmVinculo.hContCbSubacceso');\r        \r        set( 'frmVinculo.accion', 'guardar' );\r        set( 'frmVinculo.casoDeUso', 'insertar' );\r        set( 'frmVinculo.conectorAction', 'LPMantenimientoVinculosJerarquia' );\r\r        set('frmVinculo.hMarca', get('frmVinculo.cbMarca'));\r        set('frmVinculo.hCanal', get('frmVinculo.cbCanal'));\r        set('frmVinculo.hAcceso', get('frmVinculo.cbAcceso'));\r        set('frmVinculo.hSubacceso', get('frmVinculo.cbSubacceso'));\r        set('frmVinculo.hEmpresa', get('frmVinculo.cbEmpresa'));\r        eval('frmVinculo').oculto = 'S';\r        enviaSICC('frmVinculo', '', '', 'N');   \r        \r            }\r\r    function fLimpiar() {\r        eval('frmVinculo').oculto = 'N';\r        limpiar = \"S\";\r        var aCombo = new Array();\r        aCombo[0] = get('frmVinculo.hDefMarca');\r        set('frmVinculo.cbMarca',aCombo);\r\r        aCombo[0] = get('frmVinculo.hDefCanal');\r        set('frmVinculo.cbCanal',aCombo);\r\r        aCombo[0] = get('frmVinculo.hDefEmpresa');\r        set('frmVinculo.cbEmpresa',aCombo);\r\r        accion('frmVinculo.cbAcceso','.disabled=false');\r        accion('frmVinculo.cbSubacceso','.disabled=false');\r        var aComboA = new Array();\r        aComboA[0] = get('frmVinculo.hDefAcceso');\r        set_combo( 'frmVinculo.cbAcceso', eval(get( 'frmVinculo.hContDefCbAcceso' )), aComboA );\r\r        var aComboS = new Array();\r        aComboS[0] = get('frmVinculo.hDefSubacceso');\r        set_combo( 'frmVinculo.cbSubacceso', eval(get( 'frmVinculo.hContDefCbSubacceso' )), aComboS );\r\r        focaliza('frmVinculo.cbMarca'); \r\r    }\r\r    function prueba() {\r      alert(\"event: \"+event.propertyName);\r\r    }\r\r      function fVolver(){\r          window.close();		\r      }\r\r      function setTabFocus(obj) { \r          focaliza('frmVinculo.'+obj); \r      }\r      \r            function persistioOk() {\r\r         eval('frmVinculo').oculto = 'N';\r         fLimpiar();\r\r         /*set(\"frmVinculo.hMarca\", p1);\r         set(\"frmVinculo.hCanal\", p2);\r         set(\"frmVinculo.hAcceso\", p3);\r         set(\"frmVinculo.hSubacceso\", p4);\r         set(\"frmVinculo.hEmpresa\", p5);\r         \r         \r         set( 'frmVinculo.accion', 'insertar' );\r         set( 'frmVinculo.casoDeUso', 'insertar' );\r         set( 'frmVinculo.conectorAction', 'LPMantenimientoVinculosJerarquia' );\r\r         enviaSICC('frmVinculo');*/\r      \r      }\r      \r      function ejecucionERROR() {\r        focaliza('frmVinculo.cbMarca');\r        eval('frmVinculo').oculto = 'N';\r      }\r\r   \r"));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","frmVinculo" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","accion" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorActionOculto" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","oculto" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hMarca" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hCanal" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hAcceso" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hSubacceso" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hEmpresa" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hListaMarca" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hListaCanal" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hListaAcceso" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hListaSubacceso" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hListaEmpresa" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hContCbAcceso" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(5)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hContCbSubacceso" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hDefMarca" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hDefCanal" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hDefAcceso" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hDefSubacceso" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hDefEmpresa" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hContDefCbAcceso" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hContDefCbSubacceso" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hCasoDeUsoDeta" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(34)).setAttribute("nombre","capa" );
      ((Element)v.get(5)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(38)).setAttribute("height","12" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","750" );
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(36)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("height","1" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:36   */

      /* Empieza nodo:43 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("legend"));
      ((Element)v.get(48)).setAttribute("class","legend" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblAlta" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","legend" );
      ((Element)v.get(49)).setAttribute("cod","00127" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("cellpadding","0" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("width","500" );
      ((Element)v.get(53)).setAttribute("border","0" );
      ((Element)v.get(53)).setAttribute("align","left" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("colspan","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:57 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(57));

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
      ((Element)v.get(57)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("id","datosTitle" );
      ((Element)v.get(61)).setAttribute("cod","6" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","25" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(65)).setAttribute("alto","13" );
      ((Element)v.get(65)).setAttribute("filas","1" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(65)).setAttribute("id","datosTitle" );
      ((Element)v.get(65)).setAttribute("cod","7" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","25" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("id","datosTitle" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("cod","10" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","100%" );
      ((Element)v.get(57)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:57   */

      /* Empieza nodo:72 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(72));

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(76)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(76)).setAttribute("id","datosCampos" );
      ((Element)v.get(76)).setAttribute("size","1" );
      ((Element)v.get(76)).setAttribute("multiple","N" );
      ((Element)v.get(76)).setAttribute("req","N" );
      ((Element)v.get(76)).setAttribute("valorinicial","" );
      ((Element)v.get(76)).setAttribute("textoinicial","" );
      ((Element)v.get(76)).setAttribute("onshtab","focaliza('frmVinculo.cbEmpresa');" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(78)).setAttribute("ID","01" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(79)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(79)).setAttribute("TIPO","STRING" );
      ((Element)v.get(79)).setAttribute("VALOR","01" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 78   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(80)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(80)).setAttribute("TIPO","STRING" );
      ((Element)v.get(80)).setAttribute("VALOR","" );
      ((Element)v.get(78)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:81 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","25" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(84)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("size","1" );
      ((Element)v.get(84)).setAttribute("multiple","N" );
      ((Element)v.get(84)).setAttribute("req","N" );
      ((Element)v.get(84)).setAttribute("valorinicial","" );
      ((Element)v.get(84)).setAttribute("textoinicial","" );
      ((Element)v.get(84)).setAttribute("onchange","canalOnChange();" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:86 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","25" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(89)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("size","1" );
      ((Element)v.get(89)).setAttribute("multiple","N" );
      ((Element)v.get(89)).setAttribute("req","N" );
      ((Element)v.get(89)).setAttribute("valorinicial","" );
      ((Element)v.get(89)).setAttribute("textoinicial","" );
      ((Element)v.get(89)).setAttribute("onchange","accesoOnChange();" );
      ((Element)v.get(89)).setAttribute("onpropertychange","prueba();" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:91 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(72)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:72   */

      /* Empieza nodo:93 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("colspan","9" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:96 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(98)).setAttribute("width","500" );
      ((Element)v.get(98)).setAttribute("border","0" );
      ((Element)v.get(98)).setAttribute("align","left" );
      ((Element)v.get(98)).setAttribute("cellspacing","0" );
      ((Element)v.get(98)).setAttribute("cellpadding","0" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("id","datosTitle" );
      ((Element)v.get(103)).setAttribute("cod","122" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(107)).setAttribute("nombre","lblEmpresa" );
      ((Element)v.get(107)).setAttribute("alto","13" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(107)).setAttribute("id","datosTitle" );
      ((Element)v.get(107)).setAttribute("cod","57" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(99)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:99   */

      /* Empieza nodo:110 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(114)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(114)).setAttribute("id","datosCampos" );
      ((Element)v.get(114)).setAttribute("size","1" );
      ((Element)v.get(114)).setAttribute("multiple","N" );
      ((Element)v.get(114)).setAttribute("req","N" );
      ((Element)v.get(114)).setAttribute("valorinicial","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).setAttribute("textoinicial","" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:116 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","25" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(119)).setAttribute("nombre","cbEmpresa" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("size","1" );
      ((Element)v.get(119)).setAttribute("multiple","N" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).setAttribute("textoinicial","" );
      ((Element)v.get(119)).setAttribute("ontab","setTabFocus('cbMarca');" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:121 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(110)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:110   */

      /* Empieza nodo:123 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("colspan","4" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:50   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:126 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:43   */

      /* Empieza nodo:128 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","12" );
      ((Element)v.get(130)).setAttribute("height","12" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","756" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","12" );
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","12" );
      ((Element)v.get(134)).setAttribute("height","1" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:128   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:5   */


   }

}
