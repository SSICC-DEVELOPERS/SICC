
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_periodos_consultar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_periodos_consultar" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Consultar Períodos" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag(); inicializacion2(); posicionarCombo2()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","098" );
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
      v.add(doc.createTextNode(" \r     \r    \r          function onLoadPag() {  \r          \r          \r                   configurarMenuSecundario(\"frmConsultarPeriodos\");   \r                   fMostrarMensajeError();   \r                   DrdEnsanchaConMargenDcho('listado1',12);                 \r                   ocultarListaEditable();   \r                   eval (ON_RSZ);     \r          }   \r    \r    \r     function inicializacion2() {   \r                   txt_to('lblValorPais', get('frmConsultarPeriodos.hPaisDescripcion'));    \r                                          \r                   if(get('frmConsultarPeriodos.hListaVacia') == \"vacio\"){   \r                                                        GestionarMensaje('160','frmConsultarPeriodos.txtDescripcion');   \r                   }   \r    \r                   if (get('frmConsultarPeriodos.errDescripcion')!='') {   \r                            var wnd = fMostrarMensajeError(get('frmConsultarPeriodos.errCodigo'),   \r                                                                                                     get('frmConsultarPeriodos.errDescripcion'));   \r                   }   \r                   focaliza('frmConsultarPeriodos.cbMarcas','');   \r          }   \r    \r       \r     function posicionarCombo2() {   \r                   var iSeleccionadoM = new Array();   \r                   iSeleccionadoM[0] = get('frmConsultarPeriodos.hMarca');   \r                   set('frmConsultarPeriodos.cbMarcas',iSeleccionadoM);   \r    \r                   var iSeleccionado = new Array();   \r                   iSeleccionado[0] = get('frmConsultarPeriodos.hCanal');   \r                   set('frmConsultarPeriodos.cbCanales',iSeleccionado);   \r    \r                   var iSeleccionadoA = new Array();   \r                   iSeleccionadoA[0] = get('frmConsultarPeriodos.hAnio');   \r                   set('frmConsultarPeriodos.txtAnio',iSeleccionadoA);   \r    \r                   var iSeleccionadoP = new Array();   \r                   iSeleccionadoP[0] = get('frmConsultarPeriodos.hPeriodo');   \r                   set('frmConsultarPeriodos.txtPeriodo',iSeleccionadoP);   \r    \r                   var iSeleccionadoTP = new Array();   \r                   iSeleccionadoTP[0] = get('frmConsultarPeriodos.hTPeriodo');   \r                   set('frmConsultarPeriodos.txtTipoPeriodo',iSeleccionadoTP);   \r    \r                   var iSeleccionadoNP = new Array();   \r                   iSeleccionadoNP[0] = get('frmConsultarPeriodos.hNPeriodo');   \r                   set('frmConsultarPeriodos.txtNomPeriodo',iSeleccionadoNP);   \r     }   \r    \r                       \r	function cargarLista() {   \r		if(!sicc_validaciones_generales()) {   \r			 return false;   \r		}   \r\r		set('frmConsultarPeriodos.accion', 'consulta');   \r		set('frmConsultarPeriodos.conectorAction', 'LPConsultarPeriodos');   \r		obtenerPaisMarcaCanal();   \r\r		mostrarListaEditable();   \r\r		configurarPaginado(mipgndo, 'CRAConsultarPeriodos', 'ConectorObtenerTodosPeriodosConsulta',   \r													  'es.indra.sicc.dtos.cra.DTOCriteriosPeriodo', armarArrayParametrosDTO());   \r			}   \r    \r    \r           /*      function enviarFormulario() {   \r                   setTimeout(\"enviarFormulario2()\",100)   \r          }   \r    \r     function enviarFormulario2() {   \r                   if( fValidarCOMBO('frmConsultarPeriodos.cbMarcas') && fValidarCOMBO('frmConsultarPeriodos.cbCanales') &&   \r                            fValidarCTEXT('frmConsultarPeriodos.txtAnio') ) {   \r                                     obtenerPaisMarcaCanal();   \r                                     set('frmConsultarPeriodos.hAnio', get('frmConsultarPeriodos.txtAnio'));   \r                                     set('frmConsultarPeriodos.hPeriodo', get('frmConsultarPeriodos.txtPeriodo'));   \r                                     set('frmConsultarPeriodos.hTPeriodo', get('frmConsultarPeriodos.txtTipoPeriodo'));   \r                                     set('frmConsultarPeriodos.hNPeriodo', get('frmConsultarPeriodos.txtNomPeriodo'));   \r    \r                                     enviaSICC('frmConsultarPeriodos');   \r                   }   \r     }   \r */   \r    \r                    /*function prueba(error, ultima, rowset){   \r                   var i;   \r                   var indexCorto = 8;   \r                   var indexCruce = 9;   \r                   var si = GestionarMensaje(84);   \r                   var no = GestionarMensaje(86);   \r                   for( i = 0; i < rowset.length; i++ ){   \r                                                        if( rowset[i][indexCorto] == 'false')   \r                                     rowset[i][indexCorto] = no;   \r                            else   \r                                     rowset[i][indexCorto] = si;   \r                                                        if( rowset[i][indexCruce] == 'false')   \r                                     rowset[i][indexCruce] = no;   \r                            else   \r                                     rowset[i][indexCruce] = si;   \r                   }   \r                   return true;   \r          }*/   \r    \r          function prueba(ultima, rowset){   \r                   var i;   \r                   var indexCorto = 8;   \r                   var indexCruce = 9;   \r                   var si = GestionarMensaje(84);   \r                   var no = GestionarMensaje(86);   \r                   var tamano = rowset.length;   \r                   if (tamano > 0) {   \r                      mostrarListaEditable();   \r                      eval (ON_RSZ);                       \r                   } else {   \r                       ocultarListaEditable();   \r                       focaliza(\"frmConsultarPeriodos.cbMarcas\");    \r                       return false;   \r                   }   \r                   for( i = 0; i < rowset.length; i++ ){   \r                                                        if( rowset[i][indexCorto] == 'false')   \r                                     rowset[i][indexCorto] = no;   \r                            else   \r                                     rowset[i][indexCorto] = si;   \r                                                        if( rowset[i][indexCruce] == 'false')   \r                                     rowset[i][indexCruce] = no;   \r                            else   \r                                     rowset[i][indexCruce] = si;   \r                   }   \r                   focaliza(\"frmConsultarPeriodos.cbMarcas\");   \r                   return true;   \r          }   \r    \r    \r    \r     function obtenerPaisMarcaCanal(){   \r           set('frmConsultarPeriodos.hCanal', get('frmConsultarPeriodos.cbCanales'));   \r           set('frmConsultarPeriodos.hMarca', get('frmConsultarPeriodos.cbMarcas'));   \r           set('frmConsultarPeriodos.descCanal', get('frmConsultarPeriodos.cbCanales', 'T'));   \r           set('frmConsultarPeriodos.descMarca', get('frmConsultarPeriodos.cbMarcas', 'T'));   \r     }      \r    \r    \r     function fLimpiar() {    \r          set('frmConsultarPeriodos.cbCanales', '');   \r          set('frmConsultarPeriodos.cbMarcas', '');   \r          set('frmConsultarPeriodos.txtAnio', '');   \r          set('frmConsultarPeriodos.txtPeriodo', '');   \r          set('frmConsultarPeriodos.txtTipoPeriodo', '');   \r          set('frmConsultarPeriodos.txtNomPeriodo', '');   \r          focaliza('frmConsultarPeriodos.cbMarcas');   \r     }   \r    \r    \r          function ocultarListaEditable() {   \r                   document.all[\"Cplistado1\"].style.visibility='hidden';   \r                   document.all[\"CpLin1listado1\"].style.visibility='hidden';   \r                   document.all[\"CpLin2listado1\"].style.visibility='hidden';   \r                   document.all[\"CpLin3listado1\"].style.visibility='hidden';   \r                   document.all[\"CpLin4listado1\"].style.visibility='hidden';   \r                   document.all[\"prim1Div\"].style.visibility='hidden';   \r                   document.all[\"ret1Div\"].style.visibility='hidden';   \r                   document.all[\"ava1Div\"].style.visibility='hidden';   \r                   document.all[\"separaDiv\"].style.visibility='hidden';   \r          }   \r    \r    \r          function mostrarListaEditable() {   \r                   document.all[\"Cplistado1\"].style.visibility='visible';   \r                   document.all[\"CpLin1listado1\"].style.visibility='visible';   \r                   document.all[\"CpLin2listado1\"].style.visibility='visible';   \r                   document.all[\"CpLin3listado1\"].style.visibility='visible';   \r                   document.all[\"CpLin4listado1\"].style.visibility='visible';   \r                   document.all[\"prim1Div\"].style.visibility='visible';   \r                   document.all[\"ret1Div\"].style.visibility='visible';   \r                   document.all[\"ava1Div\"].style.visibility='visible';   \r                   document.all[\"separaDiv\"].style.visibility='visible';   \r          }   \r    \r    \r          function armarArrayParametrosDTO()  {   \r                   var array = new Array();   \r                   var i = 0;   \r                   array[i] = new Array('oidIdioma',get('frmConsultarPeriodos.hIdioma'));   \r    \r                   if (get('frmConsultarPeriodos.hPais') != '')  {   \r                            i++;   \r                            array[i] = new Array('pais',get('frmConsultarPeriodos.hPais'));   \r                   }   \r                   if (get('frmConsultarPeriodos.cbMarcas') != '')  {   \r                            i++;   \r                            array[i] = new Array('marca',get('frmConsultarPeriodos.cbMarcas'));   \r                   }   \r                   if (get('frmConsultarPeriodos.cbCanales') != '')  {   \r                            i++;   \r                            array[i] = new Array('canal',get('frmConsultarPeriodos.cbCanales'));   \r                   }   \r                   if (get('frmConsultarPeriodos.txtAnio') != '')  {   \r                            i++;   \r                            array[i] = new Array('anio',get('frmConsultarPeriodos.txtAnio'));   \r                   }   \r                   if (get('frmConsultarPeriodos.txtPeriodo') != '')  {   \r                            i++;   \r                            array[i] = new Array('periodo',get('frmConsultarPeriodos.txtPeriodo'));   \r                   }   \r                   if (get('frmConsultarPeriodos.txtTipoPeriodo') != '')  {   \r                            i++;   \r                            array[i] = new Array('codigoTipo',get('frmConsultarPeriodos.txtTipoPeriodo'));   \r                   }   \r                   if (get('frmConsultarPeriodos.txtNomPeriodo') != '')  {   \r                            i++;   \r                            array[i] = new Array('nombre',get('frmConsultarPeriodos.txtNomPeriodo'));   \r                   }   \r                                      return array;   \r          }   \r    \r    \r   "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbMarcas" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","6" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbCanales" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","7" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtAnio" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","171" );
      ((Element)v.get(9)).setAttribute("format","t" );
      ((Element)v.get(9)).setAttribute("chars","0-9" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:6   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(10)).setAttribute("nombre","frmConsultarPeriodos" );
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
      ((Element)v.get(12)).setAttribute("valor","LPConsultarPeriodos" );
      ((Element)v.get(10)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidErrCodigo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidErrDescripcion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hCasoDeUso" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hPais" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hPaisDescripcion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hMarca" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hCanal" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hAnio" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hPeriodo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hTPeriodo" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hNPeriodo" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","descPais" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","descMarca" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","descCanal" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hListaVacia" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 10   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","tipoBarra" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(10)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(32)).setAttribute("nombre","capaBuscar" );
      ((Element)v.get(10)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","100%" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(36)).setAttribute("height","12" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","750" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(34)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(40)).setAttribute("height","1" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:34   */

      /* Empieza nodo:41 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(46)).setAttribute("class","legend" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(47)).setAttribute("id","legend" );
      ((Element)v.get(47)).setAttribute("cod","0075" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("table"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(48)).setAttribute("border","0" );
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(48)).setAttribute("cellspacing","0" );
      ((Element)v.get(48)).setAttribute("cellpadding","0" );
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("table"));
      ((Element)v.get(51)).setAttribute("width","701" );
      ((Element)v.get(51)).setAttribute("border","0" );
      ((Element)v.get(51)).setAttribute("align","left" );
      ((Element)v.get(51)).setAttribute("cellspacing","0" );
      ((Element)v.get(51)).setAttribute("cellpadding","0" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("colspan","4" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(59)).setAttribute("nombre","lblPais" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","datosTitle" );
      ((Element)v.get(59)).setAttribute("cod","5" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","25" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(63)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("id","datosTitle" );
      ((Element)v.get(63)).setAttribute("cod","6" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","25" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","datosTitle" );
      ((Element)v.get(67)).setAttribute("cod","7" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","100%" );
      ((Element)v.get(55)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:55   */

      /* Empieza nodo:70 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(70)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblValorPais" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","datosCampos" );
      ((Element)v.get(74)).setAttribute("cod","5" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","25" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(70)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(78)).setAttribute("nombre","cbMarcas" );
      ((Element)v.get(78)).setAttribute("id","datosCampos" );
      ((Element)v.get(78)).setAttribute("size","1" );
      ((Element)v.get(78)).setAttribute("multiple","N" );
      ((Element)v.get(78)).setAttribute("req","S" );
      ((Element)v.get(78)).setAttribute("valorinicial","" );
      ((Element)v.get(78)).setAttribute("textoinicial","" );
      ((Element)v.get(78)).setAttribute("onshtab","focaliza('frmConsultarPeriodos.txtNomPeriodo');" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:80 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","25" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(70)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(83)).setAttribute("nombre","cbCanales" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).setAttribute("size","1" );
      ((Element)v.get(83)).setAttribute("multiple","N" );
      ((Element)v.get(83)).setAttribute("req","S" );
      ((Element)v.get(83)).setAttribute("valorinicial","" );
      ((Element)v.get(83)).setAttribute("textoinicial","" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:85 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","100%" );
      ((Element)v.get(70)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:70   */

      /* Empieza nodo:87 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("colspan","4" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:90 / Elemento padre: 48   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(48)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("table"));
      ((Element)v.get(92)).setAttribute("width","701" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("border","0" );
      ((Element)v.get(92)).setAttribute("align","left" );
      ((Element)v.get(92)).setAttribute("cellspacing","0" );
      ((Element)v.get(92)).setAttribute("cellpadding","0" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(97)).setAttribute("nombre","lblAnio" );
      ((Element)v.get(97)).setAttribute("alto","13" );
      ((Element)v.get(97)).setAttribute("filas","1" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(97)).setAttribute("id","datosTitle" );
      ((Element)v.get(97)).setAttribute("cod","171" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","25" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(101)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(101)).setAttribute("alto","17" );
      ((Element)v.get(101)).setAttribute("filas","1" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(101)).setAttribute("id","datosTitle" );
      ((Element)v.get(101)).setAttribute("cod","276" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","25" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(105)).setAttribute("nombre","lblTipoPeriodo" );
      ((Element)v.get(105)).setAttribute("alto","17" );
      ((Element)v.get(105)).setAttribute("filas","1" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(105)).setAttribute("id","datosTitle" );
      ((Element)v.get(105)).setAttribute("cod","132" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","25" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(109)).setAttribute("nombre","lblNombrePeriodo" );
      ((Element)v.get(109)).setAttribute("alto","17" );
      ((Element)v.get(109)).setAttribute("filas","1" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(109)).setAttribute("id","datosTitle" );
      ((Element)v.get(109)).setAttribute("cod","247" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(93)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:93   */

      /* Empieza nodo:112 / Elemento padre: 92   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(92)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).setAttribute("valign","top" );
      ((Element)v.get(112)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(116)).setAttribute("nombre","txtAnio" );
      ((Element)v.get(116)).setAttribute("id","datosCampos" );
      ((Element)v.get(116)).setAttribute("max","4" );
      ((Element)v.get(116)).setAttribute("tipo","" );
      ((Element)v.get(116)).setAttribute("onchange","" );
      ((Element)v.get(116)).setAttribute("req","S" );
      ((Element)v.get(116)).setAttribute("size","4" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(116)).setAttribute("validacion","fValidarNumero(valor,4,0,9999)" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","25" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).setAttribute("valign","bottom" );
      ((Element)v.get(112)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(120)).setAttribute("nombre","txtPeriodo" );
      ((Element)v.get(120)).setAttribute("id","datosCampos" );
      ((Element)v.get(120)).setAttribute("max","6" );
      ((Element)v.get(120)).setAttribute("tipo","" );
      ((Element)v.get(120)).setAttribute("onchange","" );
      ((Element)v.get(120)).setAttribute("req","N" );
      ((Element)v.get(120)).setAttribute("size","7" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("validacion","" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(123)).setAttribute("valign","bottom" );
      ((Element)v.get(112)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(124)).setAttribute("nombre","txtTipoPeriodo" );
      ((Element)v.get(124)).setAttribute("id","datosCampos" );
      ((Element)v.get(124)).setAttribute("max","2" );
      ((Element)v.get(124)).setAttribute("tipo","" );
      ((Element)v.get(124)).setAttribute("onchange","" );
      ((Element)v.get(124)).setAttribute("req","N" );
      ((Element)v.get(124)).setAttribute("size","2" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(124)).setAttribute("validacion","" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","25" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(127)).setAttribute("valign","bottom" );
      ((Element)v.get(112)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(128)).setAttribute("nombre","txtNomPeriodo" );
      ((Element)v.get(128)).setAttribute("id","datosCampos" );
      ((Element)v.get(128)).setAttribute("max","20" );
      ((Element)v.get(128)).setAttribute("tipo","" );
      ((Element)v.get(128)).setAttribute("onchange","" );
      ((Element)v.get(128)).setAttribute("req","N" );
      ((Element)v.get(128)).setAttribute("size","27" );
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(128)).setAttribute("validacion","" );
      ((Element)v.get(128)).setAttribute("ontab","document.selection.empty();focaliza('frmConsultarPeriodos.cbMarcas','');" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","100%" );
      ((Element)v.get(112)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:112   */

      /* Empieza nodo:131 / Elemento padre: 92   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(92)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("colspan","4" );
      ((Element)v.get(132)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:48   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:134 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:41   */

      /* Empieza nodo:136 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("width","100%" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("class","botonera" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(144)).setAttribute("nombre","btnCrear" );
      ((Element)v.get(144)).setAttribute("ID","botonContenido" );
      ((Element)v.get(144)).setAttribute("tipo","html" );
      ((Element)v.get(144)).setAttribute("accion","cargarLista();" );
      ((Element)v.get(144)).setAttribute("estado","false" );
      ((Element)v.get(144)).setAttribute("cod","1" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:145 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","12" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:136   */

      /* Empieza nodo:147 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("align","center" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(149)).setAttribute("height","12" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","750" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(147)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","12" );
      ((Element)v.get(153)).setAttribute("height","1" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:147   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:154 / Elemento padre: 10   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(154)).setAttribute("nombre","listado1" );
      ((Element)v.get(154)).setAttribute("ancho","704" );
      ((Element)v.get(154)).setAttribute("alto","317" );
      ((Element)v.get(154)).setAttribute("x","12" );
      ((Element)v.get(154)).setAttribute("y","169" );
      ((Element)v.get(154)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(154)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(10)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(155)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(155)).setAttribute("alto","22" );
      ((Element)v.get(155)).setAttribute("imgFondo","" );
      ((Element)v.get(155)).setAttribute("cod","00135" );
      ((Element)v.get(155)).setAttribute("ID","datosTitle" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 154   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(156)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(156)).setAttribute("alto","22" );
      ((Element)v.get(156)).setAttribute("imgFondo","" );
      ((Element)v.get(154)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(157)).setAttribute("precarga","S" );
      ((Element)v.get(157)).setAttribute("conROver","S" );
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(158)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(158)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(158)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(158)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 157   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(159)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(159)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(159)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(159)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(157)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(160)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(160)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:157   */

      /* Empieza nodo:161 / Elemento padre: 154   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(154)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(162)).setAttribute("borde","1" );
      ((Element)v.get(162)).setAttribute("horizDatos","1" );
      ((Element)v.get(162)).setAttribute("horizCabecera","1" );
      ((Element)v.get(162)).setAttribute("vertical","1" );
      ((Element)v.get(162)).setAttribute("horizTitulo","1" );
      ((Element)v.get(162)).setAttribute("horizBase","1" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 161   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(163)).setAttribute("borde","#999999" );
      ((Element)v.get(163)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(163)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(163)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(163)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(163)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(163)).setAttribute("horizBase","#999999" );
      ((Element)v.get(161)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:161   */

      /* Empieza nodo:164 / Elemento padre: 154   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(164)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(164)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(164)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(164)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(164)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(164)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(154)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("ancho","100" );
      ((Element)v.get(165)).setAttribute("minimizable","S" );
      ((Element)v.get(165)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("ancho","100" );
      ((Element)v.get(166)).setAttribute("minimizable","S" );
      ((Element)v.get(166)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("ancho","120" );
      ((Element)v.get(167)).setAttribute("minimizable","S" );
      ((Element)v.get(167)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("ancho","120" );
      ((Element)v.get(168)).setAttribute("minimizable","S" );
      ((Element)v.get(168)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("ancho","100" );
      ((Element)v.get(169)).setAttribute("minimizable","S" );
      ((Element)v.get(169)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("ancho","100" );
      ((Element)v.get(170)).setAttribute("minimizable","S" );
      ((Element)v.get(170)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(171)).setAttribute("ancho","100" );
      ((Element)v.get(171)).setAttribute("minimizable","S" );
      ((Element)v.get(171)).setAttribute("minimizada","N" );
      ((Element)v.get(171)).setAttribute("oculta","S" );
      ((Element)v.get(164)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("ancho","100" );
      ((Element)v.get(172)).setAttribute("minimizable","S" );
      ((Element)v.get(172)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("ancho","120" );
      ((Element)v.get(173)).setAttribute("minimizable","S" );
      ((Element)v.get(173)).setAttribute("minimizada","N" );
      ((Element)v.get(164)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:164   */

      /* Empieza nodo:174 / Elemento padre: 154   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(174)).setAttribute("alto","20" );
      ((Element)v.get(174)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(174)).setAttribute("imgFondo","" );
      ((Element)v.get(174)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(154)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("colFondo","" );
      ((Element)v.get(175)).setAttribute("ID","EstCab" );
      ((Element)v.get(175)).setAttribute("cod","132" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 174   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("colFondo","" );
      ((Element)v.get(176)).setAttribute("ID","EstCab" );
      ((Element)v.get(176)).setAttribute("cod","30" );
      ((Element)v.get(174)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 174   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("colFondo","" );
      ((Element)v.get(177)).setAttribute("ID","EstCab" );
      ((Element)v.get(177)).setAttribute("cod","247" );
      ((Element)v.get(174)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 174   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("colFondo","" );
      ((Element)v.get(178)).setAttribute("ID","EstCab" );
      ((Element)v.get(178)).setAttribute("cod","248" );
      ((Element)v.get(174)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 174   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("colFondo","" );
      ((Element)v.get(179)).setAttribute("ID","EstCab" );
      ((Element)v.get(179)).setAttribute("cod","274" );
      ((Element)v.get(174)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 174   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("colFondo","" );
      ((Element)v.get(180)).setAttribute("ID","EstCab" );
      ((Element)v.get(180)).setAttribute("cod","251" );
      ((Element)v.get(174)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 174   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("colFondo","" );
      ((Element)v.get(181)).setAttribute("ID","EstCab" );
      ((Element)v.get(174)).appendChild((Element)v.get(181));

      /* Elemento padre:181 / Elemento actual: 182   */
      v.add(doc.createTextNode("oidTipoPeriodo"));
      ((Element)v.get(181)).appendChild((Text)v.get(182));

      /* Termina nodo Texto:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 174   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("colFondo","" );
      ((Element)v.get(183)).setAttribute("ID","EstCab" );
      ((Element)v.get(183)).setAttribute("cod","2280" );
      ((Element)v.get(174)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 174   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("colFondo","" );
      ((Element)v.get(184)).setAttribute("ID","EstCab" );
      ((Element)v.get(184)).setAttribute("cod","2281" );
      ((Element)v.get(174)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:174   */

      /* Empieza nodo:185 / Elemento padre: 154   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(185)).setAttribute("alto","22" );
      ((Element)v.get(185)).setAttribute("accion","" );
      ((Element)v.get(185)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(185)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(185)).setAttribute("maxSel","-1" );
      ((Element)v.get(185)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(185)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(185)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(185)).setAttribute("onLoad","" );
      ((Element)v.get(185)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(154)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("tipo","texto" );
      ((Element)v.get(186)).setAttribute("ID","EstDat" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("tipo","texto" );
      ((Element)v.get(187)).setAttribute("ID","EstDat2" );
      ((Element)v.get(185)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("tipo","texto" );
      ((Element)v.get(188)).setAttribute("ID","EstDat" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(185)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("tipo","texto" );
      ((Element)v.get(189)).setAttribute("ID","EstDat2" );
      ((Element)v.get(185)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("tipo","texto" );
      ((Element)v.get(190)).setAttribute("ID","EstDat" );
      ((Element)v.get(185)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("tipo","texto" );
      ((Element)v.get(191)).setAttribute("ID","EstDat2" );
      ((Element)v.get(185)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("tipo","texto" );
      ((Element)v.get(192)).setAttribute("ID","EstDat" );
      ((Element)v.get(185)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("tipo","texto" );
      ((Element)v.get(193)).setAttribute("ID","EstDat" );
      ((Element)v.get(185)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 185   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("tipo","texto" );
      ((Element)v.get(194)).setAttribute("ID","EstDat2" );
      ((Element)v.get(185)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:185   */

      /* Empieza nodo:195 / Elemento padre: 154   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(154)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(196)).setAttribute("ID","1" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(197)).setAttribute("NOMBRE","dato1" );
      ((Element)v.get(197)).setAttribute("TIPO","STRING" );
      ((Element)v.get(197)).setAttribute("VALOR","COD0" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(198)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(198)).setAttribute("TIPO","STRING" );
      ((Element)v.get(198)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(199)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(199)).setAttribute("TIPO","STRING" );
      ((Element)v.get(199)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(200)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(200)).setAttribute("TIPO","STRING" );
      ((Element)v.get(200)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(201)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(201)).setAttribute("TIPO","STRING" );
      ((Element)v.get(201)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(202)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(202)).setAttribute("TIPO","STRING" );
      ((Element)v.get(202)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(203)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(203)).setAttribute("TIPO","STRING" );
      ((Element)v.get(203)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(204)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(204)).setAttribute("TIPO","STRING" );
      ((Element)v.get(204)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(205)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(205)).setAttribute("TIPO","STRING" );
      ((Element)v.get(205)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(206)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(206)).setAttribute("TIPO","STRING" );
      ((Element)v.get(206)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(207)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(207)).setAttribute("TIPO","STRING" );
      ((Element)v.get(207)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(208)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(208)).setAttribute("TIPO","STRING" );
      ((Element)v.get(208)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 196   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(209)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(209)).setAttribute("TIPO","STRING" );
      ((Element)v.get(209)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(210)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(210)).setAttribute("TIPO","STRING" );
      ((Element)v.get(210)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(211)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(211)).setAttribute("TIPO","STRING" );
      ((Element)v.get(211)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(212)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(212)).setAttribute("TIPO","STRING" );
      ((Element)v.get(212)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(213)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(213)).setAttribute("TIPO","STRING" );
      ((Element)v.get(213)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(214)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(214)).setAttribute("TIPO","STRING" );
      ((Element)v.get(214)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 196   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(215)).setAttribute("NOMBRE","dato4" );
      ((Element)v.get(215)).setAttribute("TIPO","STRING" );
      ((Element)v.get(215)).setAttribute("VALOR","" );
      ((Element)v.get(196)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:216 / Elemento padre: 154   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(216)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(216)).setAttribute("ancho","680" );
      ((Element)v.get(216)).setAttribute("sep","$" );
      ((Element)v.get(216)).setAttribute("x","12" );
      ((Element)v.get(216)).setAttribute("class","botonera" );
      ((Element)v.get(216)).setAttribute("y","463" );
      ((Element)v.get(216)).setAttribute("control","|" );
      ((Element)v.get(216)).setAttribute("conector","" );
      ((Element)v.get(216)).setAttribute("rowset","" );
      ((Element)v.get(216)).setAttribute("cargainicial","N" );
      ((Element)v.get(216)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'prueba(ultima, rowset);')" );
      ((Element)v.get(154)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(217)).setAttribute("nombre","ret1" );
      ((Element)v.get(217)).setAttribute("x","37" );
      ((Element)v.get(217)).setAttribute("y","467" );
      ((Element)v.get(217)).setAttribute("ID","botonContenido" );
      ((Element)v.get(217)).setAttribute("img","retroceder_on" );
      ((Element)v.get(217)).setAttribute("tipo","0" );
      ((Element)v.get(217)).setAttribute("estado","false" );
      ((Element)v.get(217)).setAttribute("alt","" );
      ((Element)v.get(217)).setAttribute("codigo","" );
      ((Element)v.get(217)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 216   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(218)).setAttribute("nombre","ava1" );
      ((Element)v.get(218)).setAttribute("x","52" );
      ((Element)v.get(218)).setAttribute("y","467" );
      ((Element)v.get(218)).setAttribute("ID","botonContenido" );
      ((Element)v.get(218)).setAttribute("img","avanzar_on" );
      ((Element)v.get(218)).setAttribute("tipo","0" );
      ((Element)v.get(218)).setAttribute("estado","false" );
      ((Element)v.get(218)).setAttribute("alt","" );
      ((Element)v.get(218)).setAttribute("codigo","" );
      ((Element)v.get(218)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(216)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:216   */
      /* Termina nodo:154   */

      /* Empieza nodo:219 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(219)).setAttribute("nombre","prim1" );
      ((Element)v.get(219)).setAttribute("x","20" );
      ((Element)v.get(219)).setAttribute("y","467" );
      ((Element)v.get(219)).setAttribute("ID","botonContenido" );
      ((Element)v.get(219)).setAttribute("img","primera_on" );
      ((Element)v.get(219)).setAttribute("tipo","-2" );
      ((Element)v.get(219)).setAttribute("estado","false" );
      ((Element)v.get(219)).setAttribute("alt","" );
      ((Element)v.get(219)).setAttribute("codigo","" );
      ((Element)v.get(219)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(10)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 10   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(220)).setAttribute("nombre","separa" );
      ((Element)v.get(220)).setAttribute("x","59" );
      ((Element)v.get(220)).setAttribute("y","463" );
      ((Element)v.get(220)).setAttribute("ID","botonContenido" );
      ((Element)v.get(220)).setAttribute("img","separa_base" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(220)).setAttribute("tipo","0" );
      ((Element)v.get(220)).setAttribute("estado","false" );
      ((Element)v.get(220)).setAttribute("alt","" );
      ((Element)v.get(220)).setAttribute("codigo","" );
      ((Element)v.get(220)).setAttribute("accion","" );
      ((Element)v.get(10)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 10   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(221)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(221)).setAttribute("alto","12" );
      ((Element)v.get(221)).setAttribute("ancho","50" );
      ((Element)v.get(221)).setAttribute("colorf","" );
      ((Element)v.get(221)).setAttribute("borde","0" );
      ((Element)v.get(221)).setAttribute("imagenf","" );
      ((Element)v.get(221)).setAttribute("repeat","" );
      ((Element)v.get(221)).setAttribute("padding","" );
      ((Element)v.get(221)).setAttribute("visibilidad","visible" );
      ((Element)v.get(221)).setAttribute("contravsb","" );
      ((Element)v.get(221)).setAttribute("x","0" );
      ((Element)v.get(221)).setAttribute("y","486" );
      ((Element)v.get(221)).setAttribute("zindex","" );
      ((Element)v.get(10)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:10   */


   }

}
