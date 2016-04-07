
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_programa_nuevos_mantener  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1080(doc);
         

      getXML1170(doc);
         

      getXML1260(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_programa_nuevos_mantener" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Mantener programas nuevos" );
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
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","pestanyas_concurso_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","validaciones_sicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Elemento padre:7 / Elemento actual: 8   */
      v.add(doc.createTextNode("\r \r\rvar btn = false;\rvar OK = false;\r\rfunction onLoadPag(){   \r         configurarMenuSecundario(\"formulario\");\r    btnProxy(2, 0);\r\r                  var listaVisible = get(\"formulario.mostrarLista\");\r         cambiaCombo();\r         if ( listaVisible == \"S\") {\r                  ponerListaVisible();\r         }\r         else {\r             ocultarLista();\r         }\r         \r         var opcionMenu = get(\"formulario.opcionMenu\");\r\r         if(opcionMenu==\"Consultar Concurso\") {\r         accion(\"formulario.txtNumPeriodoEvaluar\", \".disabled=true\"); \r         accion(\"formulario.cbTipoExigencia\", \".disabled=true\"); \r         accion(\"formulario.cbTipoRequisito\", \".disabled=true\"); \r         accion(\"formulario.txtNumPedidosPremiar\", \".disabled=true\");                        \r         deshabilitarHabilitarBoton('botonContenido','btnAceptar','D');\r         btnProxy(1, 0);\r             btnProxy(2, 1);\r         btnProxy(3, 0);\r         btnProxy(5, 0);\r                  btnProxy(7, 0);\r         btnProxy(8, 0);\r         btnProxy(9, 0);    \r         }\r         else if(opcionMenu==\"Modificar Concurso\") {\r                  btnProxy(2,'1');\r                  btnProxy(3,'0');\r                  btnProxy(7,'0');\r                  btnProxy(8,'0');\r                  btnProxy(9,'0');\r         }\r         else{    \r                  focaliza(\"formulario.txtNumPeriodoEvaluar\");\r    }    \r    \r    if (get('formulario.errDescripcion')!='') {\r                  var wnd = fMostrarMensajeError(get('formulario.errCodigo'), get('formulario.errDescripcion'));\r         ocultarLista( get('formulario.errDescripcion'));\r    }\r      \r    var errorINC =  get(\"formulario.errCarga\");\r         \r    if(errorINC == 'INC-0015'){\r                  GestionarMensaje('INC-0015',null,null,null);	\r                  focaliza(\"formulario.txtNumPeriodoEvaluar\");\r    }\r\r                           var oidTipoExigencia = get(\"formulario.cbTipoExi\");\r         var oidTipoRequisito = get(\"formulario.cbTipoRequi\");\r         set(\"formulario.cbTipoExigencia\", new Array(oidTipoExigencia) );\r         set(\"formulario.cbTipoRequisito\", new Array(oidTipoRequisito) );\r         finCargaPagina = true;    \r  }\r\r  function fVolver() {\r         window.close();\r}\r\r  function ponerListaVisible() {\r    DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='visible';\r    document.all[\"CpLin1listado1\"].style.visibility='visible';\r    document.all[\"CpLin2listado1\"].style.visibility='visible';\r    document.all[\"CpLin3listado1\"].style.visibility='visible';\r    document.all[\"CpLin4listado1\"].style.visibility='visible';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    eval (ON_RSZ);        \r  }  \r  \r \r  function mandaElFoco(){\r  \r    document.selection.empty();  \r    var nombrelistado=\"listado1\";\r   \r   \r    var nombreCajaText=\"txtExigenciaMinima\";\r    var nombreCbNivel= \"cbNivelPremiacion\"   \r   \r    var indiceFila=0; \r    eval(nombrelistado+\".preparaCamposDR()\");\r  \r   \r   }\r\r  \r  \r  \r  function ocultarLista() {\r    DrdEnsanchaConMargenDcho('listado1',12);\r    document.all[\"Cplistado1\"].style.visibility='hidden';\r    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    eval (ON_RSZ);\r  \r  }\r\rfunction cambiaCombo()  {   \r         var lacolumna=1;\r         var datos  =get(\"formulario.hdCombo\");   \r         var fila = datos.split('|');\r         var elcontenido = new Array();\r         var ar1 = new Array();\r         \r         elcontenido[0]= new Array(\"\",\"\");\r   \r         for(i=0;i<fila.length;i++){         \r             if (fila[i] != ''){           \r                  var newRow = new Array();\r                      newRow = fila[i].split(\",\");           \r                           var dat = fila[i].split(\",\");          \r                           elcontenido[elcontenido.length] = dat;         \r         }          \r         listado1.tiposCol[lacolumna][2]=elcontenido;  \r         listado1.repinta();\r     }     \r } \r \r function aceptar(){\r\r	if(sicc_validaciones_generales('grupoAceptar')) {\r  \r	   var cantidad = get(\"formulario.txtNumPedidosPremiar\"); \r	   set(\"formulario.valoresOID\",cantidad);\r	   var valores;         \r			\r	   listado1.setDatos(new Array());          \r	   \r	   var datosLista = new Array();\r	   var secuencia = 1;         \r          \r	   if (cantidad!= ''){            \r         var datos  =  get(\"formulario.hidLstPremiar\");\r         \r         if (datos != \"\" ){\r              var exi= datos.split(\"$\"); \r        } \r          \r         \r         var sel = new Array(); \r            \r            for ( var i = 0; i < cantidad; i++){                     \r                     \r                var posi = parseInt(secuencia,10);                                          \r                var codigo = listado1.generaCodigo(posi);                 \r                                    \r                var sel = new Array();            \r                var newRow = new Array();\r                      \r                \r                if (datos != \"\" ){     \r                    newRow = datos.split(\"|\"); \r                 }                \r                 else{\r                    newRow[0] = codigo;\r                    newRow[1] = codigo;\r                    newRow[2] = codigo;\r                    newRow[3] = \"\";\r                    \r                 }                 \r \r              listado1.insertar(newRow);          \r              secuencia = codigo; \r              \r              valoresOID = codigo + \"|\" + newRow + \"|\";                      \r             \r              }                \r                OK =true;\r                set(\"formulario.cantidad\", i)\r                      \r              \r         cambiaCombo();  \r         mandaElFoco();  \r     \r       }     \r       ponerListaVisible();\r    }\r \r } \r function comprobarDatosObligatorios() {         \r         listado1.actualizaDat();\r\r         if((get(\"formulario.txtNumPeriodoEvaluar\")!=\"\") && (get(\"formulario.cbTipoExigencia\")!=\"\") &&\r            (get(\"formulario.cbTipoRequisito\")!=\"\") && (get(\"formulario.txtNumPedidosPremiar\")!=\"\")) {\r                  \r                  var todos = listado1.datos;\r                  var incompleto = \"false\";\r\r                  for(var i=0; i<todos.length; i++) {		\r                           if(todos[i][3]==\"\") incompleto = \"true\";\r                  }\r\r                  if(incompleto==\"true\") return false;\r                  else return true;\r         }\r         else {\r                  return false;\r         }    \r } \r  \r function focalizaTab(){\r  document.selection.empty(); \r  var nombrelistado=\"listado1\";\r \r  var nombreCbNivel= \"cbNivelPremiacion\";\r  \r  if (btn == false && OK == false){\r    focaliza(\"formulario.txtNumPeriodoEvaluar\");\r  }\r  else { \r      \r        var indiceFila=0;\r        eval(nombrelistado+\".preparaCamposDR()\");\r        focaliza('frm'+nombrelistado+'.'+nombreCbNivel+'_'+indiceFila,'');\r     \r    } \r     \r  }\r\rfunction focalizaShTab(){  \r if(OK == false){\r  focalizaBotonHTML('botonContenido','btnAceptar')\r }\r \r else{   \r         if(document.all[\"Cplistado1\"].style.visibility=='hidden'){\r             document.selection.empty(); \r             var nombrelistado=\"listado1\";\r             var nombreCbNivel= \"cbNivelPremiacion\";\r             var indiceFila=0;\r             eval(nombrelistado+\".preparaCamposDR()\");\r             focaliza('frm'+nombrelistado+'.'+nombreCbNivel+'_'+indiceFila,'');  \r         }\r         else{\r         \r                document.selection.empty(); \r                var nombrelistado=\"listado1\";\r                var nombreCajaText=\"txtExigenciaMinima\";\r                var indiceFila=listado1.datos.length - 1;\r              eval(nombrelistado+\".preparaCamposDR()\");\r              focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+indiceFila,'');         \r          }\r   }      \r }\r \r \rfunction fLimpiar(){\r         onLoadPag();\r}\r \r function muestraLista(ultima, rowset) { \r  var tamanio = rowset.length;\r  if (tamanio > 0) { \r                           muestraLista();\r                           mipgndo.lista.maxSel = -1;\r      btn = true;\r                           return true;\r }\r else {\r                           ocultarLista();\r                           return false;\r                  }\r}\r  \r function focalizaTab1(FILAEVENTO){ \r      if(FILAEVENTO == (listado1.datos.length - 1)) {  \r          setTimeout(\"focaliza('formulario.txtNumPeriodoEvaluar')\",10);     \r        } \r }        \r \rfunction focalizaListaShTab(FILAEVENTO) {\r    if(FILAEVENTO == 0){         \r          \r      setTimeout(\"focalizaBotonHTML('botonContenido','btnAceptar')\",10);    \r    }         \r  }  \r \rfunction cargaLista() {\r     var listaItems = get('formulario.hidLstPremiar');\r      \r     listaItems = '11|12|13|14|15|$21|22|23|24|25';\r      \r     var fila = listaItems.split('$');\r      \r     for(i=0;i<fila.length;i++){         \r              if (fila[i] != ''){\r                        var newRow = new Array();\r                            newRow = fila[i].split(\"|\");\r                        listado1.insertar(newRow);\r          }\r     }\r }\r\rfunction tomarValoresPantalla() {\r                  set(\"formulario.numPedidos\", get(\"formulario.txtNumPeriodoEvaluar\"));\r         set(\"formulario.cbTipoExi\", get(\"formulario.cbTipoExigencia\"));\r         set(\"formulario.cbTipoRequi\", get(\"formulario.cbTipoRequisito\"));\r         set(\"formulario.numPedidosPrem\", get(\"formulario.txtNumPedidosPremiar\"));\r         var datosObli = comprobarDatosObligatorios();\r         set(\"formulario.hdatosObligatorios\", datosObli);\r\r                  listado1.actualizaDat();\r         var lista = listado1.datos;\r         var datoLista = \"\";          \r\r         for(i=0; i<lista.length; i++) {\r                  if ( i != 0 ) \r                           datoLista = datoLista + \"|\";\r\r                  for (j=0; j<lista[i].length; j++) {\r                           if ( j != 0)\r                                    datoLista = datoLista + \"*\";\r\r                           if (lista[i][j] != '') {                \r                                    datoLista= datoLista + lista[i][j];\r                           }\r                           else {\r                                     datoLista = datoLista + \"&\";\r                           }\r                  }\r         }\r\r         set(\"formulario.valoresLista\", datoLista);	\r}\r\rfunction fGuardar(){ \r                  if(!sicc_validaciones_generales('grupoObligatorio')) {                           return;\r         }\r\r                  var retorno = sicc_valida_numero_LE('txtExigenciaMinima', GestionarMensaje(\"1559\", null, null, null), 0, 9999999999.99, 'Numerico', 'listado1', 3);\r\r         if(retorno==true) {\r                  tomarValoresPantalla();\r                  eval(\"formulario\").oculto= \"S\";\r                  set(\"formulario.conectorAction\",\"LPMantenerProgramaNuevas\");\r                  set(\"formulario.accion\",\"guardar\");         \r                  enviaSICC('formulario', '', '', 'N');\r         }\r         else {\r                  return;\r         }\r}\r \rfunction seteaVarsOcultas(idPestanya) {\r                           if(!sicc_validaciones_generales('grupoObligatorio')) {                  return;\r         }\r\r                  listado1.actualizaDat();\r         var retorno = sicc_valida_numero_LE('txtExigenciaMinima', GestionarMensaje(\"1559\", null, null, null), 0, 9999999999.99, 'Numerico', 'listado1', 3);\r\r         if(retorno==true) {\r                  tomarValoresPantalla();\r                  onClickPestanyaHabilitada(idPestanya, \"formulario\", \"LPMantenerProgramaNuevas\");\r         }\r         else {\r                  return;\r         }\r}\r  \r \r  \r"));
      ((Element)v.get(7)).appendChild((Text)v.get(8));

      /* Termina nodo Texto:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(7)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtNumPeriodoEvaluar" );
      ((Element)v.get(10)).setAttribute("group","grupoOpcional" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("max","999" );
      ((Element)v.get(10)).setAttribute("format","e" );
      ((Element)v.get(10)).setAttribute("cod","1675" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbTipoExigencia" );
      ((Element)v.get(11)).setAttribute("group","grupoOpcional" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","2441" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbTipoRequisito" );
      ((Element)v.get(12)).setAttribute("group","grupoOpcional" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","2442" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtNumPedidosPremiar" );
      ((Element)v.get(13)).setAttribute("group","grupoOpcional" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("min","0" );
      ((Element)v.get(13)).setAttribute("max","999" );
      ((Element)v.get(13)).setAttribute("format","e" );
      ((Element)v.get(13)).setAttribute("cod","2437" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtNumPeriodoEvaluar" );
      ((Element)v.get(14)).setAttribute("group","grupoObligatorio" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("min","0" );
      ((Element)v.get(14)).setAttribute("max","999" );
      ((Element)v.get(14)).setAttribute("format","e" );
      ((Element)v.get(14)).setAttribute("cod","1675" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","cbTipoExigencia" );
      ((Element)v.get(15)).setAttribute("group","grupoObligatorio" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("cod","2441" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","cbTipoRequisito" );
      ((Element)v.get(16)).setAttribute("group","grupoObligatorio" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","2442" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtNumPedidosPremiar" );
      ((Element)v.get(17)).setAttribute("group","grupoObligatorio" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("min","0" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(17)).setAttribute("max","999" );
      ((Element)v.get(17)).setAttribute("format","e" );
      ((Element)v.get(17)).setAttribute("cod","2437" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","txtNumPedidosPremiar" );
      ((Element)v.get(18)).setAttribute("group","grupoAceptar" );
      ((Element)v.get(18)).setAttribute("required","true" );
      ((Element)v.get(18)).setAttribute("min","0" );
      ((Element)v.get(18)).setAttribute("max","999" );
      ((Element)v.get(18)).setAttribute("format","e" );
      ((Element)v.get(18)).setAttribute("cod","2437" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:9   */
      /* Termina nodo:7   */

      /* Empieza nodo:19 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(19)).setAttribute("nombre","formulario" );
      ((Element)v.get(19)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","accion" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","errCarga" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","dObligatorios" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","valoresLista" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","valoresOID" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","campos" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","boton" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","cantidad" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hdCombo" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hPais" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidLstPremiar" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hdatosObligatorios" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(38)).setAttribute("nombre","cbTipoExi" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","cbTipoRequi" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","numPedidosPrem" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","numPedidos" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hIndEstadoProductos" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hIndEstadoAmbitoGeografico" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hIndEstadoCalificion" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hIndEstadoGerentes" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hIndEstadoConsultoras" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hIndEstadoProgramaNuevas" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hIndEstadoMultinivel" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 19   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","mostrarLista" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(19)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(50)).setAttribute("height","100%" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(50)).setAttribute("cellpadding","0" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("class","menu4" );
      ((Element)v.get(19)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","12" );
      ((Element)v.get(52)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(52)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","12" );
      ((Element)v.get(53)).setAttribute("height","30" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(54)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(54));

      /* Elemento padre:54 / Elemento actual: 55   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(54)).appendChild((Text)v.get(55));

      /* Termina nodo Texto:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","10" );
      ((Element)v.get(56)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(56)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","10" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","92" );
      ((Element)v.get(58)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(58)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("table"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(59)).setAttribute("width","75" );
      ((Element)v.get(59)).setAttribute("border","1" );
      ((Element)v.get(59)).setAttribute("align","center" );
      ((Element)v.get(59)).setAttribute("cellpadding","1" );
      ((Element)v.get(59)).setAttribute("cellspacing","0" );
      ((Element)v.get(59)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(59)).setAttribute("onmouseover","activarPuntero('formulario',1,'lblParametrosGenerales');" );
      ((Element)v.get(59)).setAttribute("onclick","seteaVarsOcultas(1);" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).setAttribute("align","center" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lblParametrosGenerales" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(62)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(62)).setAttribute("cod","00393" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:63 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","10" );
      ((Element)v.get(63)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","10" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","20" );
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(66)).setAttribute("width","75" );
      ((Element)v.get(66)).setAttribute("border","1" );
      ((Element)v.get(66)).setAttribute("align","center" );
      ((Element)v.get(66)).setAttribute("cellpadding","1" );
      ((Element)v.get(66)).setAttribute("cellspacing","0" );
      ((Element)v.get(66)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(66)).setAttribute("onmouseover","activarPuntero('formulario',5,'lblProductos');" );
      ((Element)v.get(66)).setAttribute("onclick","seteaVarsOcultas(5);" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(69)).setAttribute("cod","0094" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:70 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","10" );
      ((Element)v.get(70)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","10" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","20" );
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","75" );
      ((Element)v.get(73)).setAttribute("border","1" );
      ((Element)v.get(73)).setAttribute("align","center" );
      ((Element)v.get(73)).setAttribute("cellpadding","1" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(73)).setAttribute("onmouseover","activarPuntero('formulario',6,'lblPremios');" );
      ((Element)v.get(73)).setAttribute("onclick","seteaVarsOcultas(6);" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("nowrap","nowrap" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(76)).setAttribute("cod","00394" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:77 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","10" );
      ((Element)v.get(77)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","10" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","20" );
      ((Element)v.get(79)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(79)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("table"));
      ((Element)v.get(80)).setAttribute("width","75" );
      ((Element)v.get(80)).setAttribute("border","1" );
      ((Element)v.get(80)).setAttribute("align","center" );
      ((Element)v.get(80)).setAttribute("cellpadding","1" );
      ((Element)v.get(80)).setAttribute("cellspacing","0" );
      ((Element)v.get(80)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(80)).setAttribute("onmouseover","activarPuntero('formulario',7,'lblRequisitos');" );
      ((Element)v.get(80)).setAttribute("onclick","seteaVarsOcultas(7);" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).setAttribute("align","center" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(83)).setAttribute("nombre","lblRequisitos" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(83)).setAttribute("cod","00395" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:84 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","10" );
      ((Element)v.get(84)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","10" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","20" );
      ((Element)v.get(86)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(86)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("table"));
      ((Element)v.get(87)).setAttribute("width","75" );
      ((Element)v.get(87)).setAttribute("border","1" );
      ((Element)v.get(87)).setAttribute("align","center" );
      ((Element)v.get(87)).setAttribute("cellpadding","1" );
      ((Element)v.get(87)).setAttribute("cellspacing","0" );
      ((Element)v.get(87)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(87)).setAttribute("onmouseover","activarPuntero('formulario',4,'lblObtencionPuntos');" );
      ((Element)v.get(87)).setAttribute("onclick","seteaVarsOcultas(4);" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(88)).setAttribute("align","center" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblObtencionPuntos" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(90)).setAttribute("cod","00396" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:91 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","10" );
      ((Element)v.get(91)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","10" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","20" );
      ((Element)v.get(93)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("table"));
      ((Element)v.get(94)).setAttribute("width","75" );
      ((Element)v.get(94)).setAttribute("border","1" );
      ((Element)v.get(94)).setAttribute("align","center" );
      ((Element)v.get(94)).setAttribute("cellpadding","1" );
      ((Element)v.get(94)).setAttribute("cellspacing","0" );
      ((Element)v.get(94)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(94)).setAttribute("onmouseover","activarPuntero('formulario',8,'lblDespachoPremios');" );
      ((Element)v.get(94)).setAttribute("onclick","seteaVarsOcultas(8);" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(95)).setAttribute("align","center" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(97)).setAttribute("nombre","lblDespachoPremios" );
      ((Element)v.get(97)).setAttribute("alto","13" );
      ((Element)v.get(97)).setAttribute("filas","1" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(97)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(97)).setAttribute("cod","00397" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:98 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","16" );
      ((Element)v.get(98)).setAttribute("class","menu5texto" );
      ((Element)v.get(51)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","12" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:100 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(100)).setAttribute("width","100%" );
      ((Element)v.get(100)).setAttribute("height","100%" );
      ((Element)v.get(100)).setAttribute("border","0" );
      ((Element)v.get(100)).setAttribute("align","center" );
      ((Element)v.get(100)).setAttribute("cellpadding","0" );
      ((Element)v.get(100)).setAttribute("cellspacing","0" );
      ((Element)v.get(100)).setAttribute("class","menu4" );
      ((Element)v.get(19)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(102)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","12" );
      ((Element)v.get(103)).setAttribute("height","30" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(104)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(104));

      /* Elemento padre:104 / Elemento actual: 105   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(104)).appendChild((Text)v.get(105));

      /* Termina nodo Texto:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","10" );
      ((Element)v.get(106)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(106)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","10" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","70" );
      ((Element)v.get(108)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(108)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("table"));
      ((Element)v.get(109)).setAttribute("width","75" );
      ((Element)v.get(109)).setAttribute("border","1" );
      ((Element)v.get(109)).setAttribute("align","center" );
      ((Element)v.get(109)).setAttribute("cellpadding","1" );
      ((Element)v.get(109)).setAttribute("cellspacing","0" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(109)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(109)).setAttribute("onmouseover","activarPuntero('formulario',3,'lblAmbitoGeografico');" );
      ((Element)v.get(109)).setAttribute("onclick","seteaVarsOcultas(3);" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).setAttribute("align","center" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblAmbitoGeografico" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(112)).setAttribute("cod","2801" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:113 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","10" );
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(113)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","10" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","70" );
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("table"));
      ((Element)v.get(116)).setAttribute("width","75" );
      ((Element)v.get(116)).setAttribute("border","1" );
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(116)).setAttribute("cellpadding","1" );
      ((Element)v.get(116)).setAttribute("cellspacing","0" );
      ((Element)v.get(116)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(116)).setAttribute("onmouseover","activarPuntero('formulario',9,'lblCalificacion');" );
      ((Element)v.get(116)).setAttribute("onclick","seteaVarsOcultas(9);" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).setAttribute("align","center" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblCalificacion" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(119)).setAttribute("cod","00398" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:120 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","10" );
      ((Element)v.get(120)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","10" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("width","20" );
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("table"));
      ((Element)v.get(123)).setAttribute("width","75" );
      ((Element)v.get(123)).setAttribute("border","1" );
      ((Element)v.get(123)).setAttribute("align","center" );
      ((Element)v.get(123)).setAttribute("cellpadding","1" );
      ((Element)v.get(123)).setAttribute("cellspacing","0" );
      ((Element)v.get(123)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(123)).setAttribute("onmouseover","activarPuntero('formulario',10,'lblGerentes');" );
      ((Element)v.get(123)).setAttribute("onclick","seteaVarsOcultas(10);" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(126)).setAttribute("nombre","lblGerentes" );
      ((Element)v.get(126)).setAttribute("alto","13" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(126)).setAttribute("filas","1" );
      ((Element)v.get(126)).setAttribute("valor","" );
      ((Element)v.get(126)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(126)).setAttribute("cod","00399" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:127 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","10" );
      ((Element)v.get(127)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","10" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","20" );
      ((Element)v.get(129)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(129)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("table"));
      ((Element)v.get(130)).setAttribute("width","75" );
      ((Element)v.get(130)).setAttribute("border","1" );
      ((Element)v.get(130)).setAttribute("align","center" );
      ((Element)v.get(130)).setAttribute("cellpadding","1" );
      ((Element)v.get(130)).setAttribute("cellspacing","0" );
      ((Element)v.get(130)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(130)).setAttribute("onmouseover","activarPuntero('formulario',11,'lblConsultoras');" );
      ((Element)v.get(130)).setAttribute("onclick","seteaVarsOcultas(11);" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(133)).setAttribute("nombre","lblConsultoras" );
      ((Element)v.get(133)).setAttribute("alto","13" );
      ((Element)v.get(133)).setAttribute("filas","1" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(133)).setAttribute("cod","00401" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:134 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","10" );
      ((Element)v.get(134)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","10" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","20" );
      ((Element)v.get(136)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("table"));
      ((Element)v.get(137)).setAttribute("width","75" );
      ((Element)v.get(137)).setAttribute("border","1" );
      ((Element)v.get(137)).setAttribute("align","center" );
      ((Element)v.get(137)).setAttribute("cellpadding","1" );
      ((Element)v.get(137)).setAttribute("cellspacing","0" );
      ((Element)v.get(137)).setAttribute("ID","DatosGenerales" );
      ((Element)v.get(137)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(137)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(137)).setAttribute("onmouseover","" );
      ((Element)v.get(137)).setAttribute("onclick","" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(138)).setAttribute("align","center" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblProgramaNuevas" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(140)).setAttribute("cod","00590" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:141 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","10" );
      ((Element)v.get(141)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","10" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","20" );
      ((Element)v.get(143)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("table"));
      ((Element)v.get(144)).setAttribute("width","75" );
      ((Element)v.get(144)).setAttribute("border","1" );
      ((Element)v.get(144)).setAttribute("align","center" );
      ((Element)v.get(144)).setAttribute("cellpadding","1" );
      ((Element)v.get(144)).setAttribute("cellspacing","0" );
      ((Element)v.get(144)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(144)).setAttribute("onmouseover","activarPuntero('formulario',12,'lblMultinivel');" );
      ((Element)v.get(144)).setAttribute("onclick","seteaVarsOcultas(12);" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(147)).setAttribute("nombre","lblMultinivel" );
      ((Element)v.get(147)).setAttribute("alto","13" );
      ((Element)v.get(147)).setAttribute("filas","1" );
      ((Element)v.get(147)).setAttribute("valor","" );
      ((Element)v.get(147)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(147)).setAttribute("cod","00400" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:148 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","16" );
      ((Element)v.get(148)).setAttribute("class","menu5texto" );
      ((Element)v.get(101)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:150 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(150)).setAttribute("border","0" );
      ((Element)v.get(150)).setAttribute("cellspacing","0" );
      ((Element)v.get(150)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(152)).setAttribute("align","center" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","12" );
      ((Element)v.get(153)).setAttribute("height","12" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("width","750" );
      ((Element)v.get(151)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(151)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","12" );
      ((Element)v.get(157)).setAttribute("height","1" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:151   */

      /* Empieza nodo:158 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(163)).setAttribute("class","legend" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lblDatosGeneracion" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("valor","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(164)).setAttribute("id","legend" );
      ((Element)v.get(164)).setAttribute("cod","002" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("table"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(165)).setAttribute("border","0" );
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(165)).setAttribute("cellspacing","0" );
      ((Element)v.get(165)).setAttribute("cellpadding","0" );
      ((Element)v.get(162)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("table"));
      ((Element)v.get(168)).setAttribute("width","483" );
      ((Element)v.get(168)).setAttribute("border","0" );
      ((Element)v.get(168)).setAttribute("align","left" );
      ((Element)v.get(168)).setAttribute("cellspacing","0" );
      ((Element)v.get(168)).setAttribute("cellpadding","0" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("colspan","4" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:172 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblNumPeriodoEvaluar" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","1675" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","25" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(180)).setAttribute("nombre","lblTipoExigencia" );
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("filas","1" );
      ((Element)v.get(180)).setAttribute("valor","" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("cod","2441" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","25" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblTipoRequisito" );
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","2442" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","25" );
      ((Element)v.get(186)).setAttribute("height","8" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblNumPedidosPremiar" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","2437" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","9" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:172   */

      /* Empieza nodo:191 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(191)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(195)).setAttribute("nombre","txtNumPeriodoEvaluar" );
      ((Element)v.get(195)).setAttribute("id","datosCampos" );
      ((Element)v.get(195)).setAttribute("max","3" );
      ((Element)v.get(195)).setAttribute("tipo","" );
      ((Element)v.get(195)).setAttribute("onchange","" );
      ((Element)v.get(195)).setAttribute("req","S" );
      ((Element)v.get(195)).setAttribute("size","8" );
      ((Element)v.get(195)).setAttribute("valor","" );
      ((Element)v.get(195)).setAttribute("validacion","" );
      ((Element)v.get(195)).setAttribute("onshtab","focalizaShTab();" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","25" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(191)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(199)).setAttribute("nombre","cbTipoExigencia" );
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(199)).setAttribute("size","1" );
      ((Element)v.get(199)).setAttribute("multiple","N" );
      ((Element)v.get(199)).setAttribute("req","S" );
      ((Element)v.get(199)).setAttribute("valorinicial","" );
      ((Element)v.get(199)).setAttribute("textoinicial","" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:201 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","25" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(191)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(204)).setAttribute("nombre","cbTipoRequisito" );
      ((Element)v.get(204)).setAttribute("id","datosCampos" );
      ((Element)v.get(204)).setAttribute("size","1" );
      ((Element)v.get(204)).setAttribute("multiple","N" );
      ((Element)v.get(204)).setAttribute("req","S" );
      ((Element)v.get(204)).setAttribute("valorinicial","" );
      ((Element)v.get(204)).setAttribute("textoinicial","" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:206 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","8" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(191)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(209)).setAttribute("nombre","txtNumPedidosPremiar" );
      ((Element)v.get(209)).setAttribute("id","datosCampos" );
      ((Element)v.get(209)).setAttribute("max","3" );
      ((Element)v.get(209)).setAttribute("tipo","" );
      ((Element)v.get(209)).setAttribute("onchange","" );
      ((Element)v.get(209)).setAttribute("req","S" );
      ((Element)v.get(209)).setAttribute("size","8" );
      ((Element)v.get(209)).setAttribute("valor","" );
      ((Element)v.get(209)).setAttribute("validacion","" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(191)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","9" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:191   */

      /* Empieza nodo:212 / Elemento padre: 168   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).setAttribute("colspan","4" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:215 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:158   */

      /* Empieza nodo:217 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("table"));
      ((Element)v.get(222)).setAttribute("width","100%" );
      ((Element)v.get(222)).setAttribute("border","0" );
      ((Element)v.get(222)).setAttribute("align","center" );
      ((Element)v.get(222)).setAttribute("cellspacing","0" );
      ((Element)v.get(222)).setAttribute("cellpadding","0" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("class","botonera" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(225)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(225)).setAttribute("ID","botonContenido" );
      ((Element)v.get(225)).setAttribute("tipo","html" );
      ((Element)v.get(225)).setAttribute("accion","aceptar();" );
      ((Element)v.get(225)).setAttribute("estado","false" );
      ((Element)v.get(225)).setAttribute("cod","12" );
      ((Element)v.get(225)).setAttribute("ontab","focalizaTab();" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:226 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","12" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:217   */

      /* Empieza nodo:228 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("width","12" );
      ((Element)v.get(229)).setAttribute("align","center" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","12" );
      ((Element)v.get(230)).setAttribute("height","12" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(231)).setAttribute("width","756" );
      ((Element)v.get(228)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).setAttribute("width","12" );
      ((Element)v.get(228)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","12" );
      ((Element)v.get(234)).setAttribute("height","1" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:228   */
      /* Termina nodo:150   */

      /* Empieza nodo:235 / Elemento padre: 19   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(235)).setAttribute("nombre","listado1" );
      ((Element)v.get(235)).setAttribute("ancho","487" );
      ((Element)v.get(235)).setAttribute("alto","301" );
      ((Element)v.get(235)).setAttribute("x","12" );
      ((Element)v.get(235)).setAttribute("y","180" );
      ((Element)v.get(235)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(235)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(19)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(236)).setAttribute("precarga","S" );
      ((Element)v.get(236)).setAttribute("conROver","S" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(237)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(237)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(237)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(237)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 236   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(238)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(238)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(238)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(238)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(236)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(239)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(239)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(236)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:236   */

      /* Empieza nodo:240 / Elemento padre: 235   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(235)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(241)).setAttribute("borde","1" );
      ((Element)v.get(241)).setAttribute("horizDatos","1" );
      ((Element)v.get(241)).setAttribute("horizCabecera","1" );
      ((Element)v.get(241)).setAttribute("vertical","0" );
      ((Element)v.get(241)).setAttribute("horizTitulo","1" );
      ((Element)v.get(241)).setAttribute("horizBase","1" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 240   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(242)).setAttribute("borde","#999999" );
      ((Element)v.get(242)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(242)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(242)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(242)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(242)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(242)).setAttribute("horizBase","#999999" );
      ((Element)v.get(240)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:240   */

      /* Empieza nodo:243 / Elemento padre: 235   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(243)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(243)).setAttribute("alto","22" );
      ((Element)v.get(243)).setAttribute("imgFondo","" );
      ((Element)v.get(243)).setAttribute("ID","datosTitle" );
      ((Element)v.get(243)).setAttribute("cod","00602" );
      ((Element)v.get(235)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 235   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(244)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(244)).setAttribute("alto","22" );
      ((Element)v.get(244)).setAttribute("imgFondo","" );
      ((Element)v.get(235)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 235   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(245)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(245)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(245)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(245)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(245)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(245)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(235)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("ancho","100" );
      ((Element)v.get(246)).setAttribute("minimizable","S" );
      ((Element)v.get(246)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("ancho","100" );
      ((Element)v.get(247)).setAttribute("minimizable","S" );
      ((Element)v.get(247)).setAttribute("minimizada","N" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(245)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("ancho","100" );
      ((Element)v.get(248)).setAttribute("minimizable","S" );
      ((Element)v.get(248)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:245   */

      /* Empieza nodo:249 / Elemento padre: 235   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(249)).setAttribute("alto","20" );
      ((Element)v.get(249)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(249)).setAttribute("imgFondo","" );
      ((Element)v.get(249)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(235)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("colFondo","" );
      ((Element)v.get(250)).setAttribute("ID","EstCab" );
      ((Element)v.get(250)).setAttribute("cod","2440" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("colFondo","" );
      ((Element)v.get(251)).setAttribute("ID","EstCab" );
      ((Element)v.get(251)).setAttribute("cod","2438" );
      ((Element)v.get(249)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 249   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("colFondo","" );
      ((Element)v.get(252)).setAttribute("ID","EstCab" );
      ((Element)v.get(252)).setAttribute("align","center" );
      ((Element)v.get(252)).setAttribute("cod","2439" );
      ((Element)v.get(249)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:249   */

      /* Empieza nodo:253 / Elemento padre: 235   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(253)).setAttribute("alto","22" );
      ((Element)v.get(253)).setAttribute("accion","" );
      ((Element)v.get(253)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(253)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(253)).setAttribute("maxSel","1" );
      ((Element)v.get(253)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(253)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(253)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(253)).setAttribute("onLoad","" );
      ((Element)v.get(253)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(235)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("tipo","texto" );
      ((Element)v.get(254)).setAttribute("ID","EstDat" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 253   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("tipo","combo" );
      ((Element)v.get(255)).setAttribute("nombre","cbNivelPremiacion" );
      ((Element)v.get(255)).setAttribute("ID","EstDat2" );
      ((Element)v.get(255)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(255)).setAttribute("onShTab","focalizaListaShTab(FILAEVENTO);" );
      ((Element)v.get(253)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 253   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(256)).setAttribute("nombre","txtExigenciaMinima" );
      ((Element)v.get(256)).setAttribute("onTab","focalizaTab1(FILAEVENTO)" );
      ((Element)v.get(256)).setAttribute("size","18" );
      ((Element)v.get(256)).setAttribute("max","16" );
      ((Element)v.get(256)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(256)).setAttribute("ID","EstDat" );
      ((Element)v.get(253)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:253   */

      /* Empieza nodo:257 / Elemento padre: 235   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(235)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 235   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(258)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(258)).setAttribute("ancho","404" );
      ((Element)v.get(258)).setAttribute("sep","$" );
      ((Element)v.get(258)).setAttribute("x","12" );
      ((Element)v.get(258)).setAttribute("class","botonera" );
      ((Element)v.get(258)).setAttribute("y","406" );
      ((Element)v.get(258)).setAttribute("control","|" );
      ((Element)v.get(258)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(258)).setAttribute("rowset","" );
      ((Element)v.get(258)).setAttribute("cargainicial","N" );
      ((Element)v.get(258)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(235)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(259)).setAttribute("nombre","ret1" );
      ((Element)v.get(259)).setAttribute("x","37" );
      ((Element)v.get(259)).setAttribute("y","410" );
      ((Element)v.get(259)).setAttribute("ID","botonContenido" );
      ((Element)v.get(259)).setAttribute("img","retroceder_on" );
      ((Element)v.get(259)).setAttribute("tipo","0" );
      ((Element)v.get(259)).setAttribute("estado","false" );
      ((Element)v.get(259)).setAttribute("alt","" );
      ((Element)v.get(259)).setAttribute("codigo","" );
      ((Element)v.get(259)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 258   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(260)).setAttribute("nombre","ava1" );
      ((Element)v.get(260)).setAttribute("x","52" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(260)).setAttribute("y","410" );
      ((Element)v.get(260)).setAttribute("ID","botonContenido" );
      ((Element)v.get(260)).setAttribute("img","avanzar_on" );
      ((Element)v.get(260)).setAttribute("tipo","0" );
      ((Element)v.get(260)).setAttribute("estado","false" );
      ((Element)v.get(260)).setAttribute("alt","" );
      ((Element)v.get(260)).setAttribute("codigo","" );
      ((Element)v.get(260)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(258)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:258   */
      /* Termina nodo:235   */

      /* Empieza nodo:261 / Elemento padre: 19   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(261)).setAttribute("nombre","primera1" );
      ((Element)v.get(261)).setAttribute("x","20" );
      ((Element)v.get(261)).setAttribute("y","410" );
      ((Element)v.get(261)).setAttribute("ID","botonContenido" );
      ((Element)v.get(261)).setAttribute("img","primera_on" );
      ((Element)v.get(261)).setAttribute("tipo","-2" );
      ((Element)v.get(261)).setAttribute("estado","false" );
      ((Element)v.get(261)).setAttribute("alt","" );
      ((Element)v.get(261)).setAttribute("codigo","" );
      ((Element)v.get(261)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(19)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 19   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(262)).setAttribute("nombre","separa" );
      ((Element)v.get(262)).setAttribute("x","59" );
      ((Element)v.get(262)).setAttribute("y","406" );
      ((Element)v.get(262)).setAttribute("ID","botonContenido" );
      ((Element)v.get(262)).setAttribute("img","separa_base" );
      ((Element)v.get(262)).setAttribute("tipo","0" );
      ((Element)v.get(262)).setAttribute("estado","false" );
      ((Element)v.get(262)).setAttribute("alt","" );
      ((Element)v.get(262)).setAttribute("codigo","" );
      ((Element)v.get(262)).setAttribute("accion","" );
      ((Element)v.get(19)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 19   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(263)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(263)).setAttribute("alto","12" );
      ((Element)v.get(263)).setAttribute("ancho","100%" );
      ((Element)v.get(263)).setAttribute("colorf","" );
      ((Element)v.get(263)).setAttribute("borde","0" );
      ((Element)v.get(263)).setAttribute("imagenf","" );
      ((Element)v.get(263)).setAttribute("repeat","" );
      ((Element)v.get(263)).setAttribute("padding","" );
      ((Element)v.get(263)).setAttribute("visibilidad","visible" );
      ((Element)v.get(263)).setAttribute("contravsb","" );
      ((Element)v.get(263)).setAttribute("x","0" );
      ((Element)v.get(263)).setAttribute("y","429" );
      ((Element)v.get(263)).setAttribute("zindex","" );
      ((Element)v.get(19)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:19   */


   }

}
