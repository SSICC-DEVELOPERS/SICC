
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_vinculo_jerarquia_consultar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_vinculo_jerarquia_consultar" );
      ((Element)v.get(0)).setAttribute("cod","0640" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar vínculo de jerarquía" );
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
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r   \r  var varNoLimpiarSICC = true;\r\r  function onLoadPag()   {\r\r    DrdEnsanchaConMargenDcho('listado1',12);\r	 eval (ON_RSZ);  \r    ocultarLista();\r\r    configurarMenuSecundario(\"frmVinculo\");\r\r    focaliza('frmVinculo.cbMarca'); \r    if (get('frmVinculo.hContDefCbAcceso') == \"\")\r        guardarContCombos('frmVinculo.cbAcceso', 'frmVinculo.hContDefCbAcceso');\r    if (get('frmVinculo.hContDefCbSubacceso') == \"\")\r        guardarContCombos('frmVinculo.cbSubacceso', 'frmVinculo.hContDefCbSubacceso');\r    \r  	mostrarCodigoError();\r    if (get('frmVinculo.hCanal') == \"\")\r        accion('frmVinculo.cbAcceso','.disabled=true');\r    if (get('frmVinculo.hAcceso') == \"\")\r        accion('frmVinculo.cbSubacceso','.disabled=true');\r    posicionarCombos();\r\r    var aCombo = new Array(new Array(\"\",\"\"));\r    set_combo('frmVinculo.cbSubacceso',aCombo, []);\r    set_combo('frmVinculo.cbAcceso',aCombo, []);    \r\r	btnProxy(4, '0');\r\r	if (get('frmVinculo.casoDeUso') ==\"consultar\")\r		 listado1.maxSel = 1;\r\r\r   }\r\r    function guardarContCombos( cmb, hidd ){\r\r      var longitud = combo_get( cmb, 'L' );\r      var strArray = '[';\r      var i;\r\r      for( i = 0; i < longitud; i++ ){\r        strArray = strArray + '[\"' + combo_get( cmb, 'V', i ) + '\", \"' + combo_get( cmb, 'T', i ) + '\"]';\r        if( i < (longitud - 1) ){\r          strArray = strArray + ', ';\r        }\r      }\r      strArray = strArray + ']';\r\r      set( hidd, strArray );\r    }\r\r\r\r   function posicionarCombos() \r   {\r      var aCombo = new Array();\r      if (get('frmVinculo.hMarca') != \"\") {\r        aCombo[0] = get('frmVinculo.hMarca');\r        set('frmVinculo.cbMarca',aCombo);\r      }\r      if (get('frmVinculo.hCanal') != \"\") {\r        aCombo[0] = get('frmVinculo.hCanal');\r        set('frmVinculo.cbCanal',aCombo);\r      }\r      if (get('frmVinculo.hAcceso') != \"\") {\r        aCombo[0] = get('frmVinculo.hAcceso');\r        set('frmVinculo.cbAcceso',aCombo);\r      }\r      if (get('frmVinculo.hSubacceso') != \"\") {\r        aCombo[0] = get('frmVinculo.hSubacceso');\r        set('frmVinculo.cbSubacceso',aCombo);\r      }\r      if (get('frmVinculo.hEmpresa') != \"\") {\r        aCombo[0] = get('frmVinculo.hEmpresa');\r        set('frmVinculo.cbEmpresa',aCombo);\r      }\r   }\r\r   function mostrarCodigoError() {  \r	     \r		  var vErrCodigo = get('frmVinculo.errCodigo');\r		  var vErrDescrip = get('frmVinculo.errDescripcion');\r\r		  if (get('frmVinculo.errDescripcion')!=''){\r      		var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);\r      }		\r	       \r    }\r\r    function ocultarLista() {\r        document.all[\"Cplistado1\"].style.visibility='hidden';\r        document.all[\"CpLin1listado1\"].style.visibility='hidden';\r        document.all[\"CpLin2listado1\"].style.visibility='hidden';\r        document.all[\"CpLin3listado1\"].style.visibility='hidden';\r        document.all[\"CpLin4listado1\"].style.visibility='hidden';\r        document.all[\"primera1Div\"].style.visibility='hidden';\r        document.all[\"ret1Div\"].style.visibility='hidden';\r        document.all[\"ava1Div\"].style.visibility='hidden';\r        document.all[\"separaDiv\"].style.visibility='hidden';\r        document.all[\"DetalleDiv\"].style.visibility='hidden';\r    }\r\r    function mostrarLista() {\r        document.all[\"Cplistado1\"].style.visibility='';\r        document.all[\"CpLin1listado1\"].style.visibility='';\r        document.all[\"CpLin2listado1\"].style.visibility='';\r        document.all[\"CpLin3listado1\"].style.visibility='';\r        document.all[\"CpLin4listado1\"].style.visibility='';\r        document.all[\"primera1Div\"].style.visibility='';\r        document.all[\"ret1Div\"].style.visibility='';\r        document.all[\"ava1Div\"].style.visibility='';\r        document.all[\"separaDiv\"].style.visibility='';\r        document.all[\"DetalleDiv\"].style.visibility='';\r\r        \r        \r    }\r\r    function canalOnChange () {  \r\r      if (get('frmVinculo.cbCanal')!='') {\r          var arr = new Array();\r          arr[arr.length]=new Array('oid', get('frmVinculo.cbCanal'));\r          arr[arr.length]=new Array('oidIdioma', get('frmVinculo.hIdioma'));\r\r          recargaCombo('frmVinculo.cbAcceso', 'SEGObtenerAccesosSinFiltro', 'es.indra.sicc.util.DTOOID', arr);\r          accion('frmVinculo.cbAcceso','.disabled=false');\r \r          var  aComboS = new Array();\r          aComboS[0] = \"\";\r          set('frmVinculo.cbSubacceso',aComboS);\r          accion('frmVinculo.cbSubacceso','.disabled=true');\r\r      } else {\r          accion('frmVinculo.cbAcceso','.disabled=true');\r          accion('frmVinculo.cbSubacceso','.disabled=true');\r          var aCombo = new Array(new Array(\"\",\"\"));\r          set_combo('frmVinculo.cbSubacceso',aCombo, []);\r          set_combo('frmVinculo.cbAcceso',aCombo, []);\r      }\r      \r    }\r\r    function accesoOnChange () {  \r\r      if (get('frmVinculo.cbAcceso')!='') {\r          var arr = new Array();\r          arr[arr.length]=new Array('oid', get('frmVinculo.cbAcceso') == null ? \"\" : get('frmVinculo.cbAcceso'));\r          arr[arr.length]=new Array('oidIdioma', get('frmVinculo.hIdioma'));\r\r          recargaCombo('frmVinculo.cbSubacceso', 'SEGObtenerSubccesosSinFiltro', 'es.indra.sicc.util.DTOOID', arr);\r          accion('frmVinculo.cbSubacceso','.disabled=false');\r      } else {\r          accion('frmVinculo.cbSubacceso','.disabled=true');\r          var aCombo = new Array(new Array(\"\",\"\"));\r          set_combo('frmVinculo.cbSubacceso',aCombo, []);\r      }\r      \r\r    }\r\r\r    function verDetalle(){\r     if( (get('frmVinculo.casoDeUso').toString()==\"consultar\")||(get('frmVinculo.casoDeUso').toString()==\"eliminar\") ) {\r        if (listado1.numSelecc()== 1)\r          {		\r              var arrAux = new Array();\r              arrAux = listado1.codSeleccionados();\r              var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);		\r              var obj = new Object();\r              obj.hListaMarca=listado1.datos[posicion][1];\r              obj.hListaCanal=listado1.datos[posicion][2];\r              obj.hListaAcceso=listado1.datos[posicion][3];\r              obj.hListaSubacceso=listado1.datos[posicion][4];\r              obj.hListaEmpresa=listado1.datos[posicion][5];\r              obj.hCasoDeUsoDeta=get('frmVinculo.casoDeUso').toString();\r              set('frmVinculo.hCasoDeUsoDeta', get('frmVinculo.casoDeUso'));\r              mostrarModalSICC('LPMantenimientoVinculosJerarquia','detalle',obj,540,280);\r          }\r          else {\r              if (listado1.numSelecc() > 1) {\r                 GestionarMensaje('2525');\r                 var cant = listado1.numSelecc();\r                 var arrSel = listado1.codSeleccionados();\r                 var fila;\r                 for (i = 0; i < cant; i ++) {\r\r                    fila=DrIndiceEnArray(listado1.datos,arrSel[i],0);\r\r                    listado1.deselecciona(fila);\r                 }\r              } else {\r                 GestionarMensaje('4');\r              }\r\r              focaliza('frmVinculo.cbMarca'); \r          }\r       }  \r    }\r\r    function obtenerPosicionListaEditable(clave, lista){\r        this.posicion = 0;\r        if (lista.codSeleccionados().length > 0){\r           for(var k=0;k<lista.datos.length;k++) {\r                 if (lista.datos[k][0] == clave) {\r                    posicion=k;\r                    break;\r                 }\r        }         \r      return posicion;\r      }\r    }\r\r\r    function enviarFormulario() \r    {\r                set('frmVinculo.hMarca', get('frmVinculo.cbMarca'));\r        set('frmVinculo.hCanal', get('frmVinculo.cbCanal'));\r        set('frmVinculo.hAcceso', get('frmVinculo.cbAcceso'));\r        set('frmVinculo.hSubacceso', get('frmVinculo.cbSubacceso'));\r        set('frmVinculo.hEmpresa', get('frmVinculo.cbEmpresa'));\r        set('frmVinculo.casoDeUso', get('frmVinculo.casoDeUso'));\r        \r        enviaSICC('frmVinculo');\r    }\r\r        function buscar()\r    {\r        ocultarLista(); \r        var arr = new Array();\r        arr[arr.length]=new Array('oidMarca', get('frmVinculo.cbMarca'));\r        arr[arr.length]=new Array('oidCanal', get('frmVinculo.cbCanal'));\r        arr[arr.length]=new Array('oidAcceso', get('frmVinculo.cbAcceso'));\r        arr[arr.length]=new Array('oidSubacceso', get('frmVinculo.cbSubacceso'));\r        arr[arr.length]=new Array('oidEmpresa', get('frmVinculo.cbEmpresa'));\r        arr[arr.length]=new Array('oidIdioma', get('frmVinculo.hIdioma'));\r        arr[arr.length]=new Array('oidPais', get('frmVinculo.hPais'));\r        arr[arr.length]=new Array('indicadorSituacion', '1');\r        arr[arr.length]=new Array('tamanioPagina', '2');\r\r      \r        configurarPaginado(mipgndo,\"SEGBuscarVinculosJerarquia\",\"ConectorBuscarVinculosJerarquia\",\"es.indra.sicc.dtos.seg.DTOEBuscarVinculosJerarquia\", arr);\r\r      \r    }\r	\r\r    function fBorrar(){\r      if (get('frmVinculo.casoDeUso') ==\"eliminar\") {\r          if (listado1.numSelecc() > 0)\r              eliminarFilas(listado1.codSeleccionados(),\"SEGEliminarVinculosJerarquia\", mipgndo);\r          else\r             GestionarMensaje('4');\r             \r          focaliza('frmVinculo.cbMarca'); \r      }\r    }\r\r    function fLimpiar2() {\r        var aCombo = new Array();\r        aCombo[0] = get('frmVinculo.hDefMarca');\r        set('frmVinculo.cbMarca',aCombo);\r\r        aCombo[0] = get('frmVinculo.hDefCanal');\r        set('frmVinculo.cbCanal',aCombo);\r\r        aCombo[0] = get('frmVinculo.hDefEmpresa');\r        set('frmVinculo.cbEmpresa',aCombo);\r\r        accion('frmVinculo.cbAcceso','.disabled=false');\r        accion('frmVinculo.cbSubacceso','.disabled=false');\r        var aComboA = new Array();\r        aComboA[0] = get('frmVinculo.hDefAcceso');\r        set_combo( 'frmVinculo.cbAcceso', eval(get( 'frmVinculo.hContDefCbAcceso' )), aComboA );\r\r        var aComboS = new Array();\r        aComboS[0] = get('frmVinculo.hDefSubacceso');\r        set_combo( 'frmVinculo.cbSubacceso', eval(get( 'frmVinculo.hContDefCbSubacceso' )), aComboS );\r\r        focaliza('frmVinculo.cbMarca'); \r    }\r\r    function fLimpiar() {\r          var aCombo = new Array();\r          aCombo[0] = get('frmVinculo.hDefMarca');\r          set('frmVinculo.cbMarca',aCombo);\r\r          aCombo[0] = get('frmVinculo.hDefCanal');\r          set('frmVinculo.cbCanal',aCombo);\r\r          aCombo[0] = get('frmVinculo.hDefEmpresa');\r          set('frmVinculo.cbEmpresa',aCombo);\r\r          var aCombo = new Array();\r          aCombo[0] = get('frmVinculo.hDefAcceso');\r          set_combo( 'frmVinculo.cbAcceso', eval(get( 'frmVinculo.hContDefCbAcceso' )), aCombo );\r          if (get('frmVinculo.hDefCanal')!='') {\r\r              var arr = new Array();\r              arr[arr.length]=new Array('oid', get('frmVinculo.cbCanal'));\r              arr[arr.length]=new Array('oidIdioma', get('frmVinculo.hIdioma'));\r\r              asignar([['COMBO', 'frmVinculo.cbAcceso', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',\r                      formarCadenaDT('SEGObtenerAccesosSinFiltro', 'es.indra.sicc.util.DTOOID', arr), 'setearCbAcceso(datos);']]);\r              accion('frmVinculo.cbAcceso','.disabled=false');\r\r              if (get('frmVinculo.hDefAcceso')!='') {\r                  arr = new Array();\r                  arr[arr.length]=new Array('oid', get('frmVinculo.cbAcceso') == null ? \"\" : get('frmVinculo.cbAcceso'));\r                  arr[arr.length]=new Array('oidIdioma', get('frmVinculo.hIdioma'));\r\r                  asignar([['COMBO', 'frmVinculo.cbSubacceso', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',\r                          formarCadenaDT('SEGObtenerSubccesosSinFiltro', 'es.indra.sicc.util.DTOOID', arr), 'setearCbSubacceso(datos);']]);\r                  accion('frmVinculo.cbSubacceso','.disabled=false');\r              }\r          } else {\r              set_combo('frmVinculo.cbAcceso',['','']);\r              set_combo('frmVinculo.cbSubacceso',['','']);\r              accion('frmVinculo.cbAcceso','.disabled=true');\r              accion('frmVinculo.cbSubacceso','.disabled=true');\r          }\r\r          focaliza('frmVinculo.cbMarca'); \r\r    }\r\r/*----------------------------------------------------------------------------------------------*/\r\rfunction ocultaCapas(){\r document.all[\"Cplistado1\"].style.visibility='hidden';\r        document.all[\"CpLin1listado1\"].style.visibility='hidden';\r        document.all[\"CpLin2listado1\"].style.visibility='hidden';\r        document.all[\"CpLin3listado1\"].style.visibility='hidden';\r        document.all[\"CpLin4listado1\"].style.visibility='hidden';\r        document.all[\"primera1Div\"].style.visibility='hidden';\r        document.all[\"ret1Div\"].style.visibility='hidden';\r        document.all[\"ava1Div\"].style.visibility='hidden';\r        document.all[\"separaDiv\"].style.visibility='hidden';\r        document.all[\"DetalleDiv\"].style.visibility='hidden';\r\r}\r\r\rfunction muestraCapas(){\r		document.all[\"Cplistado1\"].style.visibility='';\r        document.all[\"CpLin1listado1\"].style.visibility='';\r        document.all[\"CpLin2listado1\"].style.visibility='';\r        document.all[\"CpLin3listado1\"].style.visibility='';\r        document.all[\"CpLin4listado1\"].style.visibility='';\r        document.all[\"primera1Div\"].style.visibility='';\r        document.all[\"ret1Div\"].style.visibility='';\r        document.all[\"ava1Div\"].style.visibility='';\r        document.all[\"separaDiv\"].style.visibility='';\r        document.all[\"DetalleDiv\"].style.visibility='';\r\r\r}\r          function muestraLista( ultima, rowset, error){\r                    var tamano = rowset.length;\r\r                                      if (tamano > 0){\r									 \r\r                                      var casoDeUso = get(\"frmVinculo.casoDeUso\");\r                    if (casoDeUso == 'consultar') {\r\r                              document.all[\"DetalleDiv\"].style.visibility='';         \r                             \r                    } else {\r							if( casoDeUso == 'eliminar' ){\r							 										 btnProxy(4, '1');\r                                         document.all[\"DetalleDiv\"].style.visibility='';          \r\r                              }else {\r                                         document.all[\"DetalleDiv\"].style.visibility='hidden';          \r                                                                 }\r                    }\r							eval (ON_RSZ);\r                              muestraCapas();\r\r							focaliza(\"frmVinculo.cbMarca\"); \r                              return true;\r                    } else {\r                      eval (ON_RSZ);                  \r					  ocultaCapas();\r					  btnProxy(4, '0');\r					  focaliza(\"frmVinculo.cbMarca\"); \r                      cdos_mostrarAlert(error);\r                      return false;\r                     }\r          }\r\r/*-----------------------------------------------------------------------------------------------*/\r\r     function setearCbSubacceso(datos){\r                        var blanco = new Array(new Array(\"\",\"\"));\r            if (datos.length > 0) {\r                if (datos[0] != \"\") \r                    blanco = blanco.concat(datos);\r            }\r            set_combo('frmVinculo.cbSubacceso',blanco, []);\r            if (get('frmVinculo.hDefSubacceso')!=''){\r                            iSeleccionadob = new Array();         \r              iSeleccionadob[0] = get('frmVinculo.hDefSubacceso');      \r              set('frmVinculo.cbSubacceso',iSeleccionadob);       \r            }\r     }\r    \r     function setearCbAcceso(datos){\r                        var blanco = new Array(new Array(\"\",\"\"));\r            if (datos.length > 0) {\r                if (datos[0] != \"\") \r                    blanco = blanco.concat(datos);\r            }\r            set_combo('frmVinculo.cbAcceso',blanco, []);\r            if (get('frmVinculo.hDefAcceso')!=''){\r                            iSeleccionadob = new Array();         \r              iSeleccionadob[0] = get('frmVinculo.hDefAcceso');      \r              set('frmVinculo.cbAcceso',iSeleccionadob);       \r            }\r     }\r     \r    function focalizaBotonShtab() {\r      if (document.all.Cplistado1.style.visibility != \"hidden\")\r          document.all.Detalle.focus();\r      else {\r                    focalizaBotonHTML('botonContenido','btnBuscar');\r       }\r    }\r\r    function focalizaBotonTab() {\r      if (document.all.Cplistado1.style.visibility != \"hidden\") {\r          		  focalizaBotonHTML_XY(\"Detalle\");\r		  }\r\r      else\r          focaliza('frmVinculo.cbMarca');\r    }\r\r\r    function pruebaSet() {\r      alert(\"En set\");\r    }\r\r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("ESTILO"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Elemento padre:6 / Elemento actual: 7   */
      v.add(doc.createTextNode(" \r    	#estComboF {width:50px} \r   "));
      ((Element)v.get(6)).appendChild((Text)v.get(7));

      /* Termina nodo Texto:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","frmVinculo" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
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
      ((Element)v.get(14)).setAttribute("nombre","hMarca" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hCanal" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hAcceso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hSubacceso" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hEmpresa" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hPais" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hListaMarca" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hListaCanal" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hListaAcceso" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 8   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hListaSubacceso" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hListaEmpresa" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hDefMarca" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hDefCanal" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hDefAcceso" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hDefSubacceso" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hDefEmpresa" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hContDefCbAcceso" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hContDefCbSubacceso" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hCasoDeUsoDeta" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 8   */
      v.add(doc.createElement("table"));
      ((Element)v.get(34)).setAttribute("width","100%" );
      ((Element)v.get(34)).setAttribute("border","0" );
      ((Element)v.get(34)).setAttribute("cellspacing","0" );
      ((Element)v.get(34)).setAttribute("cellpadding","0" );
      ((Element)v.get(8)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(37)).setAttribute("height","12" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","750" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(35)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(41)).setAttribute("height","1" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:35   */

      /* Empieza nodo:42 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(47)).setAttribute("class","legend" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","CriteriosBusqueda" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("id","legend" );
      ((Element)v.get(48)).setAttribute("cod","0075" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","100%" );
      ((Element)v.get(49)).setAttribute("border","0" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("cellpadding","0" );
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("table"));
      ((Element)v.get(52)).setAttribute("width","633" );
      ((Element)v.get(52)).setAttribute("border","0" );
      ((Element)v.get(52)).setAttribute("align","left" );
      ((Element)v.get(52)).setAttribute("cellspacing","0" );
      ((Element)v.get(52)).setAttribute("cellpadding","0" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("colspan","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:56 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","datosTitle" );
      ((Element)v.get(60)).setAttribute("cod","6" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","25" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("cod","7" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","25" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(68)).setAttribute("alto","13" );
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(68)).setAttribute("id","datosTitle" );
      ((Element)v.get(68)).setAttribute("cod","10" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","100%" );
      ((Element)v.get(56)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:56   */

      /* Empieza nodo:71 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(71));

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(75)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(75)).setAttribute("id","datosCampos" );
      ((Element)v.get(75)).setAttribute("size","1" );
      ((Element)v.get(75)).setAttribute("multiple","N" );
      ((Element)v.get(75)).setAttribute("req","N" );
      ((Element)v.get(75)).setAttribute("valorinicial","" );
      ((Element)v.get(75)).setAttribute("textoinicial","" );
      ((Element)v.get(75)).setAttribute("onshtab","focalizaBotonShtab();" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(77)).setAttribute("ID","01" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(78)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(78)).setAttribute("TIPO","STRING" );
      ((Element)v.get(78)).setAttribute("VALOR","01" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 77   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(79)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(79)).setAttribute("TIPO","STRING" );
      ((Element)v.get(79)).setAttribute("VALOR","" );
      ((Element)v.get(77)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(83)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).setAttribute("size","1" );
      ((Element)v.get(83)).setAttribute("multiple","N" );
      ((Element)v.get(83)).setAttribute("req","N" );
      ((Element)v.get(83)).setAttribute("valorinicial","" );
      ((Element)v.get(83)).setAttribute("textoinicial","" );
      ((Element)v.get(83)).setAttribute("onchange","canalOnChange();" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:85 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(88)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).setAttribute("size","1" );
      ((Element)v.get(88)).setAttribute("multiple","N" );
      ((Element)v.get(88)).setAttribute("req","N" );
      ((Element)v.get(88)).setAttribute("valorinicial","" );
      ((Element)v.get(88)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).setAttribute("onchange","accesoOnChange();" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(90)).setAttribute("ID","01" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(91)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(91)).setAttribute("TIPO","STRING" );
      ((Element)v.get(91)).setAttribute("VALOR","01" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 90   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(92)).setAttribute("NOMBRE","DESCRIPCION" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("TIPO","STRING" );
      ((Element)v.get(92)).setAttribute("VALOR","" );
      ((Element)v.get(90)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:90   */

      /* Empieza nodo:93 / Elemento padre: 89   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(93)).setAttribute("ID","02" );
      ((Element)v.get(89)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(94)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(94)).setAttribute("TIPO","STRING" );
      ((Element)v.get(94)).setAttribute("VALOR","01" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 93   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(95)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(95)).setAttribute("TIPO","STRING" );
      ((Element)v.get(95)).setAttribute("VALOR","...................." );
      ((Element)v.get(93)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:93   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:96 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(71)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:71   */

      /* Empieza nodo:98 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("colspan","9" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:101 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("table"));
      ((Element)v.get(103)).setAttribute("width","633" );
      ((Element)v.get(103)).setAttribute("border","0" );
      ((Element)v.get(103)).setAttribute("align","left" );
      ((Element)v.get(103)).setAttribute("cellspacing","0" );
      ((Element)v.get(103)).setAttribute("cellpadding","0" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("cod","122" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblEmpresa" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","datosTitle" );
      ((Element)v.get(112)).setAttribute("cod","57" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(104)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:104   */

      /* Empieza nodo:115 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(103)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(119)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("size","1" );
      ((Element)v.get(119)).setAttribute("multiple","N" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).setAttribute("textoinicial","" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(121)).setAttribute("ID","01" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(122)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(122)).setAttribute("TIPO","STRING" );
      ((Element)v.get(122)).setAttribute("VALOR","01" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 121   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(123)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(123)).setAttribute("TIPO","STRING" );
      ((Element)v.get(123)).setAttribute("VALOR","" );
      ((Element)v.get(121)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:121   */

      /* Empieza nodo:124 / Elemento padre: 120   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(124)).setAttribute("ID","02" );
      ((Element)v.get(120)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(125)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(125)).setAttribute("TIPO","STRING" );
      ((Element)v.get(125)).setAttribute("VALOR","01" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 124   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(126)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(126)).setAttribute("TIPO","STRING" );
      ((Element)v.get(126)).setAttribute("VALOR","...................." );
      ((Element)v.get(124)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:124   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:127 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","25" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(130)).setAttribute("nombre","cbEmpresa" );
      ((Element)v.get(130)).setAttribute("id","datosCampos" );
      ((Element)v.get(130)).setAttribute("size","1" );
      ((Element)v.get(130)).setAttribute("multiple","N" );
      ((Element)v.get(130)).setAttribute("req","N" );
      ((Element)v.get(130)).setAttribute("valorinicial","" );
      ((Element)v.get(130)).setAttribute("textoinicial","" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:132 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(115)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:115   */

      /* Empieza nodo:134 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("colspan","4" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:49   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:137 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:42   */

      /* Empieza nodo:139 / Elemento padre: 34   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(144)).setAttribute("width","100%" );
      ((Element)v.get(144)).setAttribute("border","0" );
      ((Element)v.get(144)).setAttribute("align","center" );
      ((Element)v.get(144)).setAttribute("cellspacing","0" );
      ((Element)v.get(144)).setAttribute("cellpadding","0" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("class","botonera" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(147)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(147)).setAttribute("ID","botonContenido" );
      ((Element)v.get(147)).setAttribute("tipo","html" );
      ((Element)v.get(147)).setAttribute("accion","buscar();" );
      ((Element)v.get(147)).setAttribute("estado","false" );
      ((Element)v.get(147)).setAttribute("cod","1" );
      ((Element)v.get(147)).setAttribute("ontab","focalizaBotonTab();" );
      ((Element)v.get(147)).setAttribute("onshtab","focaliza('frmVinculo.cbEmpresa');" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:148 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","12" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:139   */

      /* Empieza nodo:150 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("width","12" );
      ((Element)v.get(151)).setAttribute("align","center" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(152)).setAttribute("height","12" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("width","756" );
      ((Element)v.get(150)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","12" );
      ((Element)v.get(150)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(156)).setAttribute("height","1" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:150   */
      /* Termina nodo:34   */

      /* Empieza nodo:157 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(157)).setAttribute("nombre","listado1" );
      ((Element)v.get(157)).setAttribute("ancho","637" );
      ((Element)v.get(157)).setAttribute("alto","317" );
      ((Element)v.get(157)).setAttribute("x","12" );
      ((Element)v.get(157)).setAttribute("y","162" );
      ((Element)v.get(157)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(157)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(158)).setAttribute("precarga","S" );
      ((Element)v.get(158)).setAttribute("conROver","S" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(159)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(159)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(159)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(159)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 158   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(160)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(160)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(160)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(160)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(158)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 158   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(161)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(161)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(158)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:158   */

      /* Empieza nodo:162 / Elemento padre: 157   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(157)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(163)).setAttribute("borde","1" );
      ((Element)v.get(163)).setAttribute("horizDatos","1" );
      ((Element)v.get(163)).setAttribute("horizCabecera","1" );
      ((Element)v.get(163)).setAttribute("vertical","1" );
      ((Element)v.get(163)).setAttribute("horizTitulo","1" );
      ((Element)v.get(163)).setAttribute("horizBase","1" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 162   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(164)).setAttribute("borde","#999999" );
      ((Element)v.get(164)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(164)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(164)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(164)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(164)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(164)).setAttribute("horizBase","#999999" );
      ((Element)v.get(162)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:162   */

      /* Empieza nodo:165 / Elemento padre: 157   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(165)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(165)).setAttribute("alto","22" );
      ((Element)v.get(165)).setAttribute("imgFondo","" );
      ((Element)v.get(165)).setAttribute("cod","00135" );
      ((Element)v.get(165)).setAttribute("ID","datosTitle" );
      ((Element)v.get(157)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 157   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(166)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(166)).setAttribute("alto","22" );
      ((Element)v.get(166)).setAttribute("imgFondo","" );
      ((Element)v.get(157)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 157   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(167)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(167)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(167)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(167)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(167)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(167)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(157)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("ancho","80" );
      ((Element)v.get(168)).setAttribute("minimizable","S" );
      ((Element)v.get(168)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("ancho","80" );
      ((Element)v.get(169)).setAttribute("minimizable","S" );
      ((Element)v.get(169)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("ancho","50" );
      ((Element)v.get(170)).setAttribute("minimizable","S" );
      ((Element)v.get(170)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("ancho","80" );
      ((Element)v.get(171)).setAttribute("minimizable","S" );
      ((Element)v.get(171)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 167   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("ancho","50" );
      ((Element)v.get(172)).setAttribute("minimizable","S" );
      ((Element)v.get(172)).setAttribute("minimizada","N" );
      ((Element)v.get(167)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:167   */

      /* Empieza nodo:173 / Elemento padre: 157   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(173)).setAttribute("alto","20" );
      ((Element)v.get(173)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(173)).setAttribute("imgFondo","" );
      ((Element)v.get(173)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(173)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(157)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("colFondo","" );
      ((Element)v.get(174)).setAttribute("ID","EstCab" );
      ((Element)v.get(174)).setAttribute("align","center" );
      ((Element)v.get(174)).setAttribute("cod","6" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Elemento padre:174 / Elemento actual: 175   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(174)).appendChild((Text)v.get(175));

      /* Termina nodo Texto:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 173   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("colFondo","" );
      ((Element)v.get(176)).setAttribute("ID","EstCab" );
      ((Element)v.get(176)).setAttribute("cod","7" );
      ((Element)v.get(173)).appendChild((Element)v.get(176));

      /* Elemento padre:176 / Elemento actual: 177   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(176)).appendChild((Text)v.get(177));

      /* Termina nodo Texto:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 173   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("colFondo","" );
      ((Element)v.get(178)).setAttribute("ID","EstCab" );
      ((Element)v.get(178)).setAttribute("cod","10" );
      ((Element)v.get(173)).appendChild((Element)v.get(178));

      /* Elemento padre:178 / Elemento actual: 179   */
      v.add(doc.createTextNode("Acceso"));
      ((Element)v.get(178)).appendChild((Text)v.get(179));

      /* Termina nodo Texto:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 173   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("colFondo","" );
      ((Element)v.get(180)).setAttribute("ID","EstCab" );
      ((Element)v.get(180)).setAttribute("cod","122" );
      ((Element)v.get(173)).appendChild((Element)v.get(180));

      /* Elemento padre:180 / Elemento actual: 181   */
      v.add(doc.createTextNode("Subacceso"));
      ((Element)v.get(180)).appendChild((Text)v.get(181));

      /* Termina nodo Texto:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 173   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("colFondo","" );
      ((Element)v.get(182)).setAttribute("ID","EstCab" );
      ((Element)v.get(182)).setAttribute("cod","57" );
      ((Element)v.get(173)).appendChild((Element)v.get(182));

      /* Elemento padre:182 / Elemento actual: 183   */
      v.add(doc.createTextNode("Empresa"));
      ((Element)v.get(182)).appendChild((Text)v.get(183));

      /* Termina nodo Texto:183   */
      /* Termina nodo:182   */
      /* Termina nodo:173   */

      /* Empieza nodo:184 / Elemento padre: 157   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(184)).setAttribute("alto","22" );
      ((Element)v.get(184)).setAttribute("accion","" );
      ((Element)v.get(184)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(184)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(184)).setAttribute("maxSel","-1" );
      ((Element)v.get(184)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(184)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(184)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(184)).setAttribute("onLoad","" );
      ((Element)v.get(184)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(157)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("tipo","texto" );
      ((Element)v.get(185)).setAttribute("ID","EstDat" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("tipo","texto" );
      ((Element)v.get(186)).setAttribute("ID","EstDat2" );
      ((Element)v.get(184)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("tipo","texto" );
      ((Element)v.get(187)).setAttribute("ID","EstDat" );
      ((Element)v.get(184)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("tipo","texto" );
      ((Element)v.get(188)).setAttribute("ID","EstDat2" );
      ((Element)v.get(184)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("tipo","texto" );
      ((Element)v.get(189)).setAttribute("ID","EstDat" );
      ((Element)v.get(184)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:184   */

      /* Empieza nodo:190 / Elemento padre: 157   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(157)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 157   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(191)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(191)).setAttribute("ancho","637" );
      ((Element)v.get(191)).setAttribute("sep","$" );
      ((Element)v.get(191)).setAttribute("x","12" );
      ((Element)v.get(191)).setAttribute("class","botonera" );
      ((Element)v.get(191)).setAttribute("y","456" );
      ((Element)v.get(191)).setAttribute("control","|" );
      ((Element)v.get(191)).setAttribute("conector","" );
      ((Element)v.get(191)).setAttribute("rowset","" );
      ((Element)v.get(191)).setAttribute("cargainicial","N" );
      ((Element)v.get(191)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(157)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(192)).setAttribute("nombre","ret1" );
      ((Element)v.get(192)).setAttribute("x","37" );
      ((Element)v.get(192)).setAttribute("y","460" );
      ((Element)v.get(192)).setAttribute("ID","botonContenido" );
      ((Element)v.get(192)).setAttribute("img","retroceder_on" );
      ((Element)v.get(192)).setAttribute("tipo","0" );
      ((Element)v.get(192)).setAttribute("estado","false" );
      ((Element)v.get(192)).setAttribute("alt","" );
      ((Element)v.get(192)).setAttribute("codigo","" );
      ((Element)v.get(192)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 191   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(193)).setAttribute("nombre","ava1" );
      ((Element)v.get(193)).setAttribute("x","52" );
      ((Element)v.get(193)).setAttribute("y","460" );
      ((Element)v.get(193)).setAttribute("ID","botonContenido" );
      ((Element)v.get(193)).setAttribute("img","avanzar_on" );
      ((Element)v.get(193)).setAttribute("tipo","0" );
      ((Element)v.get(193)).setAttribute("estado","false" );
      ((Element)v.get(193)).setAttribute("alt","" );
      ((Element)v.get(193)).setAttribute("codigo","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(193)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(191)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:191   */
      /* Termina nodo:157   */

      /* Empieza nodo:194 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(194)).setAttribute("nombre","primera1" );
      ((Element)v.get(194)).setAttribute("x","20" );
      ((Element)v.get(194)).setAttribute("y","460" );
      ((Element)v.get(194)).setAttribute("ID","botonContenido" );
      ((Element)v.get(194)).setAttribute("img","primera_on" );
      ((Element)v.get(194)).setAttribute("tipo","-2" );
      ((Element)v.get(194)).setAttribute("estado","false" );
      ((Element)v.get(194)).setAttribute("alt","" );
      ((Element)v.get(194)).setAttribute("codigo","" );
      ((Element)v.get(194)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(195)).setAttribute("nombre","separa" );
      ((Element)v.get(195)).setAttribute("x","59" );
      ((Element)v.get(195)).setAttribute("y","456" );
      ((Element)v.get(195)).setAttribute("ID","botonContenido" );
      ((Element)v.get(195)).setAttribute("img","separa_base" );
      ((Element)v.get(195)).setAttribute("tipo","0" );
      ((Element)v.get(195)).setAttribute("estado","false" );
      ((Element)v.get(195)).setAttribute("alt","" );
      ((Element)v.get(195)).setAttribute("codigo","" );
      ((Element)v.get(195)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(196)).setAttribute("nombre","Detalle" );
      ((Element)v.get(196)).setAttribute("x","80" );
      ((Element)v.get(196)).setAttribute("y","457" );
      ((Element)v.get(196)).setAttribute("ID","botonContenido" );
      ((Element)v.get(196)).setAttribute("tipo","html" );
      ((Element)v.get(196)).setAttribute("estado","false" );
      ((Element)v.get(196)).setAttribute("cod","3" );
      ((Element)v.get(196)).setAttribute("accion","verDetalle();" );
      ((Element)v.get(196)).setAttribute("ontab","focaliza('frmVinculo.cbMarca');" );
      ((Element)v.get(196)).setAttribute("onshtab","document.all.btnBuscar.focus();" );
      ((Element)v.get(8)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(197)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(197)).setAttribute("alto","12" );
      ((Element)v.get(197)).setAttribute("ancho","100%" );
      ((Element)v.get(197)).setAttribute("colorf","" );
      ((Element)v.get(197)).setAttribute("borde","0" );
      ((Element)v.get(197)).setAttribute("imagenf","" );
      ((Element)v.get(197)).setAttribute("repeat","" );
      ((Element)v.get(197)).setAttribute("padding","" );
      ((Element)v.get(197)).setAttribute("visibilidad","visible" );
      ((Element)v.get(197)).setAttribute("contravsb","" );
      ((Element)v.get(197)).setAttribute("x","0" );
      ((Element)v.get(197)).setAttribute("y","479" );
      ((Element)v.get(197)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:8   */


   }

}
