
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_marcas_situacion_relacionadas_insertar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_marcas_situacion_relacionadas_insertar" );
      ((Element)v.get(0)).setAttribute("cod","0404" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar marcas de situación relacionadas por tipo de abono" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar marcas de situación relacionadas por tipo de abono" );
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
      v.add(doc.createTextNode("\r   \r   var LPName = \"LPMarcasTipo\";\r   var varNoLimpiarSICC = true;\r   var datosLista;\r   var arrayLista;\r   var seteoArray;\r\r   var subProcesoHabilitado = false;\r   var tipoAbonoHabilitado = false;   \r\r   function creaArray(array) {\r      arrayLista = new Array();\r      var cantFilas = array.length;\r      if(array.length > 0){\r	     var cantCols = array[0].length;      \r      \r      for(var i=0 ; i<cantFilas ; i++ ) {\r          var nuevaFila = new Array();\r          for(var j=0 ; j<cantCols; j++) {\r              var dato = array[i][j];\r              nuevaFila[j] = dato;\r          }\r          arrayLista[i] = nuevaFila;\r        }\r		\r	}\r      return arrayLista;\r   }\r\r   function onLoadPag() {                                         datosLista = listado1.datos;\r      seteoArray = creaArray(datosLista);\r\r      DrdEnsanchaConMargenDcho('listado1',12); \r      eval(ON_RSZ); 	\r      configurarMenuSecundario(\"frmMarcas\");                \r      if (get(\"frmMarcas.casoDeUso\")== \"modificar\" ) {\r        focaliza('frmMarcas.areaObservaciones','');                    \r      }\r      else {\r        focaliza(\"frmMarcas.cmbProcesos\");                    \r      }\r\r            document.all[\"Cplistado1\"].style.visibility='';\r      document.all[\"CpLin1listado1\"].style.visibility='';\r      document.all[\"CpLin2listado1\"].style.visibility='';\r      document.all[\"CpLin3listado1\"].style.visibility='';\r      document.all[\"CpLin4listado1\"].style.visibility='';\r                        \r            \r            \r      if ((get(\"frmMarcas.casoDeUso\")== \"consultar\" ) || (get(\"frmMarcas.casoDeUso\")== \"modificar\" ) || (get(\"frmMarcas.casoDeUso\")== \"eliminar\" )) {	\r        combo_add(\"frmMarcas.cmbProcesos\",\"1\",get(\"frmMarcas.hProcesos\"));\r        set(\"frmMarcas.cmbProcesos\",new Array(\"1\"));\r\r        combo_add(\"frmMarcas.cmbSubProcesos\",\"2\",get(\"frmMarcas.hSubProcesos\"));\r        set(\"frmMarcas.cmbSubProcesos\",new Array(\"2\"));\r\r        combo_add(\"frmMarcas.cmbTipoCargo\",\"3\",get(\"frmMarcas.hTipoCargo\"));\r        set(\"frmMarcas.cmbTipoCargo\",new Array(\"3\"));\r\r        set(\"frmMarcas.areaObservaciones\",get(\"frmMarcas.hObservaciones\"));\r      }\r\r      if ((get(\"frmMarcas.casoDeUso\")== \"consultar\") || (get(\"frmMarcas.casoDeUso\")== \"eliminar\")) {\r        accion(\"frmMarcas.cmbProcesos\",\".disabled=true\");\r        accion(\"frmMarcas.cmbSubProcesos\",\".disabled=true\");\r        accion(\"frmMarcas.cmbTipoCargo\",\".disabled=true\");\r\r        listado1.tiposCol[1][6]=true; \r        listado1.tiposCol[2][6]=true;\r        listado1.actualizaDat();\r        listado1.repinta();      \r      }\r\r      if (get(\"frmMarcas.casoDeUso\")== \"modificar\" ) {\r        accion(\"frmMarcas.cmbProcesos\",\".disabled=true\");\r        accion(\"frmMarcas.cmbSubProcesos\",\".disabled=true\");\r        accion(\"frmMarcas.cmbTipoCargo\",\".disabled=true\");\r      }  \r    \r      var caso = get(\"frmMarcas.casoDeUso\");	\r\r      if (get('frmMarcas.errDescripcion')!='') {\r        var wnd = fMostrarMensajeError(get('frmMarcas.errCodigo'), get('frmMarcas.errDescripcion'));\r      }\r\r      accion(\"frmMarcas.cmbSubProcesos\",\".disabled=true\");\r      accion(\"frmMarcas.cmbTipoCargo\",\".disabled=true\");      \r   }   \r  \r  function inicioOnChange(filaCambiada) {      \r      listado1.actualizaDat();\r      var listadoDatos = listado1.datos;\r      var cantCodigos = listado1.codigos().length;\r      listado1.actualizaDat();\r      for ( var i = 0; i < cantCodigos; i++) {\r        if ( i != filaCambiada)\r        listadoDatos[i][3] = \"N\";\r      }                   \r      listado1.setDatos(listadoDatos); 			\r    }\r\r    function fLimpiar() {          \r      var objArr = document.all['cmbProcesos'];\r      for(var i=0; i < objArr.length; i++){\r        if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r          if (!objArr[i].disabled)\r              set('frmMarcas.cmbProcesos','');					\r        }\r      }\r\r      var objArr = document.all['cmbTipoCargo'];\r      for(var i=0; i < objArr.length; i++){\r        if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r          if (!objArr[i].disabled) {\r            var aCombo = new Array(new Array(\"\",\"\"));\r            set_combo('frmMarcas.cmbTipoCargo',aCombo, []);\r          }\r        }\r      }\r      \r      var objArr = document.all['cmbSubProcesos'];\r      for(var i=0; i < objArr.length; i++){\r        if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r          if (!objArr[i].disabled) {\r            var aCombo = new Array(new Array(\"\",\"\"));\r            set_combo('frmMarcas.cmbSubProcesos',aCombo, []);				\r          }\r        }\r      }\r\r	    set('frmMarcas.areaObservaciones', get('frmMarcas.hObservaciones'));\r      listado1.setDatos(seteoArray);\r      seteoArray = creaArray(seteoArray);   \r\r      accion(\"frmMarcas.cmbSubProcesos\",\".disabled=true\");  \r      accion(\"frmMarcas.cmbTipoCargo\",\".disabled=true\");\r      subProcesoHabilitado = false;\r      tipoAbonoHabilitado = false;   \r      focaliza(\"frmMarcas.cmbProcesos\");\r    }\r\r    function procesoOnChange(){\r      var valor = get(\"frmMarcas.cmbProcesos\");\r      if(valor==\"\") {\r\r        var objArr = document.all['cmbSubProcesos'];\r        for(var i=0; i < objArr.length; i++){\r          if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r            if (!objArr[i].disabled) {\r              var aCombo = new Array(new Array(\"\",\"\"));\r              set_combo('frmMarcas.cmbSubProcesos',aCombo, []);				\r            }\r          }\r        }\r\r        var objArr = document.all['cmbTipoCargo'];\r        for(var i=0; i < objArr.length; i++){\r          if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r            if (!objArr[i].disabled) {\r              var aCombo = new Array(new Array(\"\",\"\"));\r              set_combo('frmMarcas.cmbTipoCargo',aCombo, []);\r            }\r          }\r        }\r\r        accion(\"frmMarcas.cmbSubProcesos\",\".disabled=true\");\r        accion(\"frmMarcas.cmbTipoCargo\",\".disabled=true\");\r        subProcesoHabilitado = false;\r        return;\r      }\r    \r      var arr = new Array();\r      arr[arr.length]=new Array(\"oid\", get(\"frmMarcas.cmbProcesos\"));\r      recargaCombo(\"frmMarcas.cmbSubProcesos\", 'CCCobtieneSubprocesos', 'es.indra.sicc.util.DTOOID', arr);\r      \r      accion(\"frmMarcas.cmbSubProcesos\",\".disabled=false\");\r\r      var objArr = document.all['cmbTipoCargo'];\r      for(var i=0; i < objArr.length; i++){\r        if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r          if (!objArr[i].disabled) {\r            var aCombo = new Array(new Array(\"\",\"\"));\r            set_combo('frmMarcas.cmbTipoCargo',aCombo, []);\r          }\r        }\r      }\r      \r      accion(\"frmMarcas.cmbTipoCargo\",\".disabled=true\");\r      subProcesoHabilitado = true;\r    }\r\r    function subprocesoOnChange() {\r      var valor = get(\"frmMarcas.cmbSubProcesos\");\r      if(valor==\"\") {\r        var objArr = document.all['cmbTipoCargo'];\r        for(var i=0; i < objArr.length; i++){\r          if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r            if (!objArr[i].disabled) {\r              var aCombo = new Array(new Array(\"\",\"\"));\r              set_combo('frmMarcas.cmbTipoCargo',aCombo, []);\r            }\r          }\r        }      \r        accion(\"frmMarcas.cmbTipoCargo\",\".disabled=true\");\r        tipoAbonoHabilitado = false;\r        return;      \r      }\r      \r      var arr = new Array();      \r      arr[arr.length]=new Array(\"oid\", get(\"frmMarcas.cmbSubProcesos\"));\r      arr[arr.length]=new Array(\"oidIdioma\", get(\"frmMarcas.hIdioma\"));      \r      recargaCombo(\"frmMarcas.cmbTipoCargo\", 'CCCObtenerTIposAbonosSubproceso', 'es.indra.sicc.util.DTOOID', arr);\r      accion(\"frmMarcas.cmbTipoCargo\",\".disabled=false\");\r      tipoAbonoHabilitado = true;\r    }\r\r  function fGuardar() {\r        if( !sicc_validaciones_generales() )\r  		return;\r\r            \r    var lista = listado1.datos;\r    var validoEntrada = false;\r    var validoSalida = false;\r\r    for(var i = 0; i< listado1.datos.length; i++) {\r      var radioEntrada = document.getElementById(\"RbEntrada_\" + i);\r      var radioSalida = document.getElementById(\"RbEntrada1_\" + i);\r      \r      if(radioEntrada.checked) {\r        validoEntrada = true;\r      }\r\r      if(radioSalida.checked) {         \r        validoSalida = true;\r      }       \r    }\r\r    if((validoEntrada == false) && (validoSalida == false)) {\r        GestionarMensaje('1280',null,null,null); \r        focaliza(\"frmMarcas.cmbProcesos\");\r        return false;           \r      }\r\r    \r    var marcaSituacionSalida = \"\"; \r    var lista = listado1.datos;\r    var j = 0;\r    \r    for ( var i = 0; i < listado1.datos.length; i++) {        \r      var radio = document.getElementById(\"RbEntrada1_\" + i);\r      if(radio.checked) {                              \r        marcaSituacionSalida = lista[i][0];  \r      }     \r    }\r\r        \r    var marcaSituacionEntrada = \"\"; \r    var lista = listado1.datos;\r    var j = 0;\r    var valor1=\"\";\r    var valor2=\"\";\r    \r    for ( var i = 0; i < listado1.datos.length; i++) {        \r        var radio = document.getElementById(\"RbEntrada_\" + i);\r        if(radio.checked) {\r            if(marcaSituacionEntrada==\"\") {\r                marcaSituacionEntrada = lista[i][0];\r            }\r            else {\r                marcaSituacionEntrada = marcaSituacionEntrada + \",\" + lista[i][0];\r            }\r        }     \r    } \r\r        \r    var observaciones = get(\"frmMarcas.areaObservaciones\");\r    var tipoabono = get(\"frmMarcas.cmbTipoCargo\");\r    var oidvalor = get(\"frmMarcas.oid\");\r\r    \r        \r    var caso = get(\"frmMarcas.casoDeUso\");\r    \r    if(caso == \"modificar\" ) {\r      var tipoabo = get(\"frmMarcas.oiTipoAbono\");\r    \r      set(\"frmMarcas.varTipoAbono\", tipoabo);   \r      set(\"frmMarcas.oid\", oidvalor);\r      set(\"frmMarcas.varObservaciones\", observaciones);\r      set(\"frmMarcas.varMarcaSituacionSalida\", marcaSituacionSalida);\r      set(\"frmMarcas.varMarcaSituacionEntrada\", marcaSituacionEntrada);\r\r      eval(\"frmMarcas\").oculto= \"S\";\r    \r      set(\"frmMarcas.conectorAction\", \"LPMarcasTipo\");\r      set(\"frmMarcas.accion\", \"guardar\");\r      enviaSICC(\"frmMarcas\");       \r    }\r\r    \r            \r    if(caso == \"insertar\" ) {                  \r      set(\"frmMarcas.varTipoAbono\", tipoabono);\r      set(\"frmMarcas.oid\", oidvalor);\r      set(\"frmMarcas.varObservaciones\", observaciones);\r      set(\"frmMarcas.varMarcaSituacionSalida\", marcaSituacionSalida);\r      set(\"frmMarcas.varMarcaSituacionEntrada\", marcaSituacionEntrada);\r      \r      eval(\"frmMarcas\").oculto= \"S\";\r      \r      set(\"frmMarcas.conectorAction\", \"LPMarcasTipo\");\r      set(\"frmMarcas.accion\", \"guardar\");\r      enviaSICC(\"frmMarcas\");    \r     }    \r    }\r\r    function comboProcesos() {\r      var caso = get(\"frmMarcas.casoDeUso\");\r      if(caso==\"modificar\") {\r        return;\r      }\r      else {\r        focaliza(\"frmMarcas.cmbProcesos\");\r      }\r    }\r\r    function comboSubProcesos() {  \r      if(subProcesoHabilitado==false) {\r        focaliza(\"frmMarcas.areaObservaciones\");\r        return;\r      }\r      focaliza(\"frmMarcas.cmbSubProcesos\");\r    }\r\r    function comboTipo() {\r      document.selection.empty();\r\r      var caso = get(\"frmMarcas.casoDeUso\");\r\r      if(caso ==\"modificar\") {\r        checkSalida();\r        return;\r      }\r      \r      if((subProcesoHabilitado==false) && (tipoAbonoHabilitado==false)) {\r        focaliza(\"frmMarcas.cmbProcesos\");\r        return;\r      }\r\r      if((subProcesoHabilitado==true) && (tipoAbonoHabilitado==false)) {\r        focaliza(\"frmMarcas.cmbSubProcesos\");\r        return;\r      }\r\r      if((subProcesoHabilitado==true) && (tipoAbonoHabilitado==true)) {\r        focaliza(\"frmMarcas.cmbTipoCargo\");\r        return;\r      }            \r    }\r\r    function fVolver() {    \r      window.close();\r    }\r\r    function reInicio() {\r      eval(\"frmMarcas\").oculto= \"N\";\r      fLimpiar();\r    }\r\r    function reModifica() {\r      eval(\"frmMarcas\").oculto= \"N\";\r      window.close();\r    }\r\r    function fErrorAlGuardarI() {\r      focaliza('frmMarcas.cmbProcesos');\r    }\r\r	 function fErrorAlGuardarM() {\r      focaliza('frmMarcas.areaObservaciones');\r    }\r\r    function focalizaListaTab(FILAEVENTO) {\r      if(FILAEVENTO == (listado1.datos.length - 1)) {\r          if (get(\"frmMarcas.casoDeUso\")== \"modificar\" ) {\r              setTimeout(\"focaliza('frmMarcas.areaObservaciones','')\",10);\r          }\r          else {\r              setTimeout(\"focaliza('frmMarcas.cmbProcesos','')\",10); \r          }                         \r      }\r    }\r\r    function focalizaListaShTab(FILAEVENTO) {\r      if(FILAEVENTO == 0){      \r        setTimeout(\"focaliza('frmMarcas.areaObservaciones','')\",10); \r        focaliza('frmMarcas.areaObservaciones','');\r      }       \r    }\r\r    function checkEntrada() {\r      document.selection.empty();\r      var nombrelistado = \"listado1\";\r      var nombreCheckBox = \"RbEntrada\";\r      var indiceFila = 0;\r\r      eval(nombrelistado+\".preparaCamposDR()\");\r      focaliza('frm'+nombrelistado+'.'+nombreCheckBox+'_'+indiceFila,'');\r    }\r\r    function checkSalida(){\r      var nombrelistado = \"listado1\";\r      var nombreCheckBox = \"RbEntrada1\";\r      var indiceFila = listado1.datos.length - 1;\r\r      eval(nombrelistado+\".preparaCamposDR()\");\r      focaliza('frm'+nombrelistado+'.'+nombreCheckBox+'_'+indiceFila,'');\r    }\r\r   \r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cmbProcesos" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","689" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cmbSubProcesos" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","696" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cmbTipoCargo" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1357" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:6   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","frmMarcas" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hIdioma" );
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
      ((Element)v.get(13)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","varExitoInserta" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","varExitoModifica" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oid" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hProcesos" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hSubProcesos" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hTipoCargo" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hObservaciones" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","elementosSeleccionados" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hMarcaSituacionSalida" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hMarcaSituacionSalidaDesc" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hMarcaSituacionEntrada" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hMarcaSituacionEntradaDesc" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","varObservaciones" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","varSubprocesos" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","varTipoAbono" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","varMarcaSituacionSalida" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","varMarcaSituacionEntrada" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","oiSubproceso" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","oiTipoAbono" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 10   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(10)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(39)).setAttribute("height","12" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","750" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(37)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","1" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:37   */

      /* Empieza nodo:44 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(49)).setAttribute("class","legend" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lblDatos" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("id","legend" );
      ((Element)v.get(50)).setAttribute("cod","00146" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(51)).setAttribute("width","100%" );
      ((Element)v.get(51)).setAttribute("border","0" );
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(51)).setAttribute("cellspacing","0" );
      ((Element)v.get(51)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("table"));
      ((Element)v.get(54)).setAttribute("width","570" );
      ((Element)v.get(54)).setAttribute("border","0" );
      ((Element)v.get(54)).setAttribute("align","left" );
      ((Element)v.get(54)).setAttribute("cellspacing","0" );
      ((Element)v.get(54)).setAttribute("cellpadding","0" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("colspan","4" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:58 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lblProceso" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("id","datosTitle" );
      ((Element)v.get(62)).setAttribute("cod","689" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","25" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblSubproceso" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("id","datosTitle" );
      ((Element)v.get(66)).setAttribute("cod","696" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","100%" );
      ((Element)v.get(58)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:58   */

      /* Empieza nodo:69 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(73)).setAttribute("nombre","cmbProcesos" );
      ((Element)v.get(73)).setAttribute("size","1" );
      ((Element)v.get(73)).setAttribute("multiple","N" );
      ((Element)v.get(73)).setAttribute("req","S" );
      ((Element)v.get(73)).setAttribute("valorinicial","" );
      ((Element)v.get(73)).setAttribute("textoinicial","" );
      ((Element)v.get(73)).setAttribute("id","datosCampos" );
      ((Element)v.get(73)).setAttribute("onchange","procesoOnChange();" );
      ((Element)v.get(73)).setAttribute("ontab","comboSubProcesos();" );
      ((Element)v.get(73)).setAttribute("onshtab","checkSalida();" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:75 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","25" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(78)).setAttribute("nombre","cmbSubProcesos" );
      ((Element)v.get(78)).setAttribute("size","1" );
      ((Element)v.get(78)).setAttribute("multiple","N" );
      ((Element)v.get(78)).setAttribute("req","S" );
      ((Element)v.get(78)).setAttribute("valorinicial","" );
      ((Element)v.get(78)).setAttribute("textoinicial","" );
      ((Element)v.get(78)).setAttribute("id","datosCampos" );
      ((Element)v.get(78)).setAttribute("onchange","subprocesoOnChange();" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:80 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","100%" );
      ((Element)v.get(69)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:69   */

      /* Empieza nodo:82 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("colspan","4" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:85 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("table"));
      ((Element)v.get(87)).setAttribute("width","570" );
      ((Element)v.get(87)).setAttribute("border","0" );
      ((Element)v.get(87)).setAttribute("align","left" );
      ((Element)v.get(87)).setAttribute("cellspacing","0" );
      ((Element)v.get(87)).setAttribute("cellpadding","0" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(92)).setAttribute("nombre","lblTipoAbono" );
      ((Element)v.get(92)).setAttribute("alto","13" );
      ((Element)v.get(92)).setAttribute("filas","1" );
      ((Element)v.get(92)).setAttribute("id","datosTitle" );
      ((Element)v.get(92)).setAttribute("cod","1357" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 88   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","100%" );
      ((Element)v.get(88)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:88   */

      /* Empieza nodo:95 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(95)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(99)).setAttribute("nombre","cmbTipoCargo" );
      ((Element)v.get(99)).setAttribute("size","1" );
      ((Element)v.get(99)).setAttribute("multiple","N" );
      ((Element)v.get(99)).setAttribute("req","S" );
      ((Element)v.get(99)).setAttribute("valorinicial","" );
      ((Element)v.get(99)).setAttribute("textoinicial","" );
      ((Element)v.get(99)).setAttribute("id","datosCampos" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:101 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","100%" );
      ((Element)v.get(95)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:95   */

      /* Empieza nodo:103 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("colspan","4" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:106 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("table"));
      ((Element)v.get(108)).setAttribute("width","570" );
      ((Element)v.get(108)).setAttribute("border","0" );
      ((Element)v.get(108)).setAttribute("align","left" );
      ((Element)v.get(108)).setAttribute("cellspacing","0" );
      ((Element)v.get(108)).setAttribute("cellpadding","0" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
      ((Element)v.get(113)).setAttribute("id","datosTitle" );
      ((Element)v.get(113)).setAttribute("cod","169" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(109)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:109   */

      /* Empieza nodo:116 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(120)).setAttribute("max","100" );
      ((Element)v.get(120)).setAttribute("readonly","N" );
      ((Element)v.get(120)).setAttribute("nombre","areaObservaciones" );
      ((Element)v.get(120)).setAttribute("id","datosCampos" );
      ((Element)v.get(120)).setAttribute("rows","3" );
      ((Element)v.get(120)).setAttribute("cols","50" );
      ((Element)v.get(120)).setAttribute("ontab","checkEntrada();" );
      ((Element)v.get(120)).setAttribute("onshtab","comboTipo();" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(116)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:116   */

      /* Empieza nodo:123 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(123));

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
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:51   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:126 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:44   */

      /* Empieza nodo:128 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(128));

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
      /* Termina nodo:36   */

      /* Empieza nodo:135 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(135)).setAttribute("nombre","listado1" );
      ((Element)v.get(135)).setAttribute("ancho","574" );
      ((Element)v.get(135)).setAttribute("alto","277" );
      ((Element)v.get(135)).setAttribute("x","12" );
      ((Element)v.get(135)).setAttribute("y","207" );
      ((Element)v.get(135)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(135)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(136)).setAttribute("precarga","S" );
      ((Element)v.get(136)).setAttribute("conROver","S" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(137)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(137)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(137)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(137)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 136   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(138)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(138)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(138)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(138)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 136   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(139)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(139)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:136   */

      /* Empieza nodo:140 / Elemento padre: 135   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(135)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(141)).setAttribute("borde","1" );
      ((Element)v.get(141)).setAttribute("horizDatos","1" );
      ((Element)v.get(141)).setAttribute("horizCabecera","1" );
      ((Element)v.get(141)).setAttribute("vertical","0" );
      ((Element)v.get(141)).setAttribute("horizTitulo","1" );
      ((Element)v.get(141)).setAttribute("horizBase","1" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 140   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(142)).setAttribute("borde","#999999" );
      ((Element)v.get(142)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(142)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(142)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(142)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(142)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(142)).setAttribute("horizBase","#999999" );
      ((Element)v.get(140)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:140   */

      /* Empieza nodo:143 / Elemento padre: 135   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(143)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(143)).setAttribute("alto","22" );
      ((Element)v.get(143)).setAttribute("imgFondo","" );
      ((Element)v.get(143)).setAttribute("cod","00147" );
      ((Element)v.get(143)).setAttribute("ID","datosTitle" );
      ((Element)v.get(135)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 135   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(144)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(144)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(144)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(144)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(144)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(144)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(135)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("ancho","100" );
      ((Element)v.get(145)).setAttribute("minimizable","S" );
      ((Element)v.get(145)).setAttribute("minimizada","N" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 144   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("ancho","50" );
      ((Element)v.get(146)).setAttribute("minimizable","S" );
      ((Element)v.get(146)).setAttribute("minimizada","N" );
      ((Element)v.get(146)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(144)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 144   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("ancho","48" );
      ((Element)v.get(147)).setAttribute("minimizable","S" );
      ((Element)v.get(147)).setAttribute("minimizada","N" );
      ((Element)v.get(144)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:144   */

      /* Empieza nodo:148 / Elemento padre: 135   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(148)).setAttribute("alto","20" );
      ((Element)v.get(148)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(148)).setAttribute("imgFondo","" );
      ((Element)v.get(148)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(135)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("colFondo","" );
      ((Element)v.get(149)).setAttribute("ID","EstCab" );
      ((Element)v.get(149)).setAttribute("align","center" );
      ((Element)v.get(149)).setAttribute("cod","1358" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("colFondo","" );
      ((Element)v.get(150)).setAttribute("ID","EstCab" );
      ((Element)v.get(150)).setAttribute("cod","1359" );
      ((Element)v.get(148)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 148   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("colFondo","" );
      ((Element)v.get(151)).setAttribute("ID","EstCab" );
      ((Element)v.get(151)).setAttribute("cod","1360" );
      ((Element)v.get(148)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:148   */

      /* Empieza nodo:152 / Elemento padre: 135   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(152)).setAttribute("alto","22" );
      ((Element)v.get(152)).setAttribute("accion","" );
      ((Element)v.get(152)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(152)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(152)).setAttribute("maxSel","0" );
      ((Element)v.get(152)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(152)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(152)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(152)).setAttribute("onLoad","" );
      ((Element)v.get(152)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(135)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("tipo","texto" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(153)).setAttribute("ID","EstDat" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("tipo","checkbox" );
      ((Element)v.get(154)).setAttribute("nombre","RbEntrada" );
      ((Element)v.get(154)).setAttribute("ID","EstDat2" );
      ((Element)v.get(154)).setAttribute("onShTab","focalizaListaShTab(FILAEVENTO);" );
      ((Element)v.get(152)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("tipo","checkbox" );
      ((Element)v.get(155)).setAttribute("nombre","RbEntrada1" );
      ((Element)v.get(155)).setAttribute("ID","EstDat" );
      ((Element)v.get(155)).setAttribute("onchange","inicioOnChange(FILAEVENTO);" );
      ((Element)v.get(155)).setAttribute("onTab","focalizaListaTab(FILAEVENTO)" );
      ((Element)v.get(152)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:152   */

      /* Empieza nodo:156 / Elemento padre: 135   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(135)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:135   */

      /* Empieza nodo:157 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(157)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(157)).setAttribute("alto","12" );
      ((Element)v.get(157)).setAttribute("ancho","100%" );
      ((Element)v.get(157)).setAttribute("colorf","" );
      ((Element)v.get(157)).setAttribute("borde","0" );
      ((Element)v.get(157)).setAttribute("imagenf","" );
      ((Element)v.get(157)).setAttribute("repeat","" );
      ((Element)v.get(157)).setAttribute("padding","" );
      ((Element)v.get(157)).setAttribute("visibilidad","visible" );
      ((Element)v.get(157)).setAttribute("contravsb","" );
      ((Element)v.get(157)).setAttribute("x","0" );
      ((Element)v.get(157)).setAttribute("y","484" );
      ((Element)v.get(157)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:10   */


   }

}
