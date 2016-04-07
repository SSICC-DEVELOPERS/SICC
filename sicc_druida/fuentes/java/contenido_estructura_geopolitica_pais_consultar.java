
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_estructura_geopolitica_pais_consultar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_estructura_geopolitica_pais_consultar" );
      ((Element)v.get(0)).setAttribute("cod","073" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar Estructura Geopolítica de País" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Elemento padre:2 / Elemento actual: 3   */
      v.add(doc.createTextNode("\r\rvar varNoLimpiarSICC = true;\racaboDeTabular = false; \r\r  function onLoadPag()   {\r  \r      DrdEnsanchaConMargenDcho('listado1',12);\r      eval (ON_RSZ);  \r      ocultarLista();\r\r	  configurarMenuSecundario('frmformula');\r	  mostrarCodigoError();\r      listado1.maxSel = 0;\r      \r   \r      if (get('frmformula.hCantPaises') != \"\") {\r          for (i = 5; i > parseInt(get('frmformula.hCantPaises'),10); i--) {\r              listado1.alternaVerColumna(i, false);\r          }\r          var nomCols = get('frmformula.hNomCols');\r          var pos;\r          var nom;\r          for (i = 0; i < parseInt(get('frmformula.hCantPaises'),10); i++) {\r             pos = nomCols.indexOf(\"|\");\r             nom = nomCols.substring(0,pos);\r             nomCols = nomCols.substring(pos+1, nomCols.length);\r             listado1.txtCab[i+1] = nom;\r          }\r          listado1.repinta();\r          mostrarLista();\r      }\r\r      var paisesSelec = get('frmformula.hPaisesSelec')\r      if (paisesSelec != \"\") {\r          var aCombo = new Array(); \r          var i = 0;\r          while (paisesSelec.length > 1) {\r              pos = paisesSelec.indexOf(\"|\");\r              nom = paisesSelec.substring(0,pos);\r              paisesSelec = paisesSelec.substring(pos+1, paisesSelec.length);\r              aCombo[i] = nom;	       \r              i++;\r          }\r                    set('frmformula.comboPais',aCombo);      \r      }\r\r      focaliza('frmformula.comboPais');\r\r	  \r	 }\r\r\r	function controlTab() {\r\r		document.onkeydown= function (evt)   { \r			  if(window.event.keyCode==9&&!acaboDeTabular){ \r				 acaboDeTabular=false; \r				 setTimeout(\"focalizaTAB(1)\",50); 				 return false; \r			  } \r			  acaboDeTabular=false; \r		}\r	}\r\r   function focalizaTAB(campo)   { \r	   acaboDeTabular=true; \r	   if(campo==1)\r			focaliza('frmformula.comboPais');\r	   else\r	        focalizaBotonHTML('botonContenido','btnBuscar');\r   } \r\r   function focalizaSHTAB(campo)   { \r	   acaboDeTabular=true; \r	   if(campo==1)\r			focaliza('frmformula.comboPais');\r	   else\r	        focalizaBotonHTML('botonContenido','btnBuscar');\r   } \r\r\r\r\r\r    function ocultarLista() {\r        document.all[\"Cplistado1\"].style.visibility='hidden';\r        document.all[\"CpLin1listado1\"].style.visibility='hidden';\r        document.all[\"CpLin2listado1\"].style.visibility='hidden';\r        document.all[\"CpLin3listado1\"].style.visibility='hidden';\r        document.all[\"CpLin4listado1\"].style.visibility='hidden';\r        document.all[\"primera1Div\"].style.visibility='hidden';\r        document.all[\"ret1Div\"].style.visibility='hidden';\r        document.all[\"ava1Div\"].style.visibility='hidden';\r        document.all[\"separaDiv\"].style.visibility='hidden';\r    }\r\r    function mostrarLista() {\r\r        document.all[\"Cplistado1\"].style.visibility='';\r        document.all[\"CpLin1listado1\"].style.visibility='';\r        document.all[\"CpLin2listado1\"].style.visibility='';\r        document.all[\"CpLin3listado1\"].style.visibility='';\r        document.all[\"CpLin4listado1\"].style.visibility='';\r                                \r            }\r\r\r	 function disparaBusqueda() \r	 {\r\r			var bContinua = chequeaCantPaisesSeleccionados();\r			if (bContinua == true)\r			{\r					if (get('frmformula.comboPais', 'T') != \"\")\r					{\r						\r						var str = \"\";\r						var arr = get('frmformula.comboPais');\r						for(var i=0; i<arr.length;i++){\r							str+=arr[i]+\",\";\r						}\r						set('frmformula.hidPaises', str);\r						set('frmformula.accion','Consultar');\r						set('frmformula.conectorAction', 'LPConsultarEG');\r						enviaSICC('frmformula');\r					} else \r						GestionarMensaje('8', null, null, null);\r\r		    } else {             focaliza(\"frmformula.comboPais\");\r        }\r  	}\r\r    function formarCadenaDT(idBusiness , dto, parametros) {\r     var cadena = idBusiness + \"|\" + dto + \"|\";\r \r          for(i=0;i<parametros.length;i++) {\r         cadena += parametros[i][0] + \"=\" + parametros[i][1];\r         if (i!= parametros.length-1) {\r            cadena += \"&\";\r         }\r     }     \r      return cadena;\r    }\r\r	 function chequeaCantPaisesSeleccionados()\r	 {\r			var cmbSeleccion = get('frmformula.comboPais');			\r			var longArray = cmbSeleccion.length;\r\r			if ((longArray == 0)) {\r				 GestionarMensaje('991');\r          var pos = combo_get( 'frmformula.comboPais', 'V', 0 );\r          set('frmformula.comboPais',new Array(pos));\r          set('frmformula.comboPais',new Array());\r				 return false;\r			} else  if (longArray > 5 ) {\r				GestionarMensaje('992');\r				return false;\r			};\r\r			return true;\r	 }\r\r	function mostrarCodigoError(){\r		 var vErrCodigo  = get('frmformula.errCodigo');\r		 var vErrDescrip = get('frmformula.errDescripcion');\r		  if (get('frmformula.errDescripcion')!=''){				\r				var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip); \r			} \r	}\r\r  function fLimpiar() {\r    \r    var pos = combo_get( 'frmformula.comboPais', 'V', 0 );\r    set('frmformula.comboPais',new Array(pos));\r    set('frmformula.comboPais',new Array());\r    focaliza('frmformula.comboPais');\r\r  }\r\r\r"));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","frmformula" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","hidPaises" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","hidPaisABuscar" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","LPConsultarEG" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hCantPaises" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hNomCols" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hPaisesSelec" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 4   */
      v.add(doc.createElement("table"));
      ((Element)v.get(15)).setAttribute("width","100%" );
      ((Element)v.get(15)).setAttribute("border","0" );
      ((Element)v.get(15)).setAttribute("cellspacing","0" );
      ((Element)v.get(15)).setAttribute("cellpadding","0" );
      ((Element)v.get(4)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).setAttribute("width","12" );
      ((Element)v.get(17)).setAttribute("align","center" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(18)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).setAttribute("width","12" );
      ((Element)v.get(18)).setAttribute("height","12" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","750" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(16)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("height","1" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:16   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(28)).setAttribute("class","legend" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(29)).setAttribute("nombre","lblSeleccionPais" );
      ((Element)v.get(29)).setAttribute("alto","13" );
      ((Element)v.get(29)).setAttribute("filas","1" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(29)).setAttribute("id","legend" );
      ((Element)v.get(29)).setAttribute("cod","00494" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("table"));
      ((Element)v.get(30)).setAttribute("width","100%" );
      ((Element)v.get(30)).setAttribute("border","0" );
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(30)).setAttribute("cellspacing","0" );
      ((Element)v.get(30)).setAttribute("cellpadding","0" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","400" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("align","left" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("colspan","8" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:37 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(41)).setAttribute("nombre","lblPais" );
      ((Element)v.get(41)).setAttribute("alto","13" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(41)).setAttribute("id","datosTitle" );
      ((Element)v.get(41)).setAttribute("cod","5" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","100%" );
      ((Element)v.get(37)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:37   */

      /* Empieza nodo:44 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(48)).setAttribute("nombre","comboPais" );
      ((Element)v.get(48)).setAttribute("id","datosCampos" );
      ((Element)v.get(48)).setAttribute("size","5" );
      ((Element)v.get(48)).setAttribute("multiple","S" );
      ((Element)v.get(48)).setAttribute("req","S" );
      ((Element)v.get(48)).setAttribute("onshtab","focalizaSHTAB(2);" );
      ((Element)v.get(48)).setAttribute("ontab","focalizaTAB(2);" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(50)).setAttribute("ID","1" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(51)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(51)).setAttribute("TIPO","STRING" );
      ((Element)v.get(51)).setAttribute("VALOR","00" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 50   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(52)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(52)).setAttribute("TIPO","STRING" );
      ((Element)v.get(52)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(50)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:50   */

      /* Empieza nodo:53 / Elemento padre: 49   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(53)).setAttribute("ID","2" );
      ((Element)v.get(49)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(54)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(54)).setAttribute("TIPO","STRING" );
      ((Element)v.get(54)).setAttribute("VALOR","01" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 53   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(55)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(55)).setAttribute("TIPO","STRING" );
      ((Element)v.get(55)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(53)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:53   */

      /* Empieza nodo:56 / Elemento padre: 49   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(56)).setAttribute("ID","3" );
      ((Element)v.get(49)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(57)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(57)).setAttribute("TIPO","STRING" );
      ((Element)v.get(57)).setAttribute("VALOR","02" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 56   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(58)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(58)).setAttribute("TIPO","STRING" );
      ((Element)v.get(58)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(56)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:56   */

      /* Empieza nodo:59 / Elemento padre: 49   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(59)).setAttribute("ID","4" );
      ((Element)v.get(49)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(60)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(60)).setAttribute("TIPO","STRING" );
      ((Element)v.get(60)).setAttribute("VALOR","03" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 59   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(61)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(61)).setAttribute("TIPO","STRING" );
      ((Element)v.get(61)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(59)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:59   */

      /* Empieza nodo:62 / Elemento padre: 49   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(62)).setAttribute("ID","5" );
      ((Element)v.get(49)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(63)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(63)).setAttribute("TIPO","STRING" );
      ((Element)v.get(63)).setAttribute("VALOR","04" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 62   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(64)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(64)).setAttribute("TIPO","STRING" );
      ((Element)v.get(64)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(62)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:62   */

      /* Empieza nodo:65 / Elemento padre: 49   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(65)).setAttribute("ID","6" );
      ((Element)v.get(49)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(66)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(66)).setAttribute("TIPO","STRING" );
      ((Element)v.get(66)).setAttribute("VALOR","05" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 65   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(67)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(67)).setAttribute("TIPO","STRING" );
      ((Element)v.get(67)).setAttribute("VALOR","xxxxxxxxxxxxxxxxxxxxxxxxxxxx1" );
      ((Element)v.get(65)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:65   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:68 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:44   */

      /* Empieza nodo:70 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("colspan","9" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:73 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:23   */

      /* Empieza nodo:75 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("table"));
      ((Element)v.get(80)).setAttribute("width","100%" );
      ((Element)v.get(80)).setAttribute("border","0" );
      ((Element)v.get(80)).setAttribute("align","center" );
      ((Element)v.get(80)).setAttribute("cellspacing","0" );
      ((Element)v.get(80)).setAttribute("cellpadding","0" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("class","botonera" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(83)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(83)).setAttribute("ID","botonContenido" );
      ((Element)v.get(83)).setAttribute("tipo","html" );
      ((Element)v.get(83)).setAttribute("accion","disparaBusqueda();" );
      ((Element)v.get(83)).setAttribute("estado","false" );
      ((Element)v.get(83)).setAttribute("cod","1" );
      ((Element)v.get(83)).setAttribute("onshtab","focalizaSHTAB(1);" );
      ((Element)v.get(83)).setAttribute("ontab","focalizaTAB(1);" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:84 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","12" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:75   */

      /* Empieza nodo:86 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","12" );
      ((Element)v.get(87)).setAttribute("align","center" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","12" );
      ((Element)v.get(88)).setAttribute("height","12" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","756" );
      ((Element)v.get(86)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","12" );
      ((Element)v.get(86)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","12" );
      ((Element)v.get(92)).setAttribute("height","1" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:86   */
      /* Termina nodo:15   */

      /* Empieza nodo:93 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(93)).setAttribute("nombre","listado1" );
      ((Element)v.get(93)).setAttribute("ancho","404" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).setAttribute("alto","270" );
      ((Element)v.get(93)).setAttribute("x","12" );
      ((Element)v.get(93)).setAttribute("y","170" );
      ((Element)v.get(93)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(93)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(94)).setAttribute("precarga","S" );
      ((Element)v.get(94)).setAttribute("conROver","S" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(95)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(95)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(95)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(95)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 94   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(96)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(96)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(96)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(96)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(94)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(97)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(97)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(94)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:94   */

      /* Empieza nodo:98 / Elemento padre: 93   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(93)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(99)).setAttribute("borde","1" );
      ((Element)v.get(99)).setAttribute("horizDatos","1" );
      ((Element)v.get(99)).setAttribute("horizCabecera","1" );
      ((Element)v.get(99)).setAttribute("vertical","1" );
      ((Element)v.get(99)).setAttribute("horizTitulo","1" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 98   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(100)).setAttribute("borde","#999999" );
      ((Element)v.get(100)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(100)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(100)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(100)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(100)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(98)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:98   */

      /* Empieza nodo:101 / Elemento padre: 93   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(101)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(101)).setAttribute("alto","22" );
      ((Element)v.get(101)).setAttribute("imgFondo","" );
      ((Element)v.get(101)).setAttribute("cod","00502" );
      ((Element)v.get(101)).setAttribute("ID","datosTitle" );
      ((Element)v.get(93)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 93   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(102)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(102)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(102)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(102)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(102)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(102)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(93)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("ancho","150" );
      ((Element)v.get(103)).setAttribute("minimizable","S" );
      ((Element)v.get(103)).setAttribute("minimizada","N" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("ancho","50" );
      ((Element)v.get(104)).setAttribute("minimizable","S" );
      ((Element)v.get(104)).setAttribute("minimizada","N" );
      ((Element)v.get(102)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("ancho","50" );
      ((Element)v.get(105)).setAttribute("minimizable","S" );
      ((Element)v.get(105)).setAttribute("minimizada","N" );
      ((Element)v.get(102)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("ancho","50" );
      ((Element)v.get(106)).setAttribute("minimizable","S" );
      ((Element)v.get(106)).setAttribute("minimizada","N" );
      ((Element)v.get(102)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("ancho","50" );
      ((Element)v.get(107)).setAttribute("minimizable","S" );
      ((Element)v.get(107)).setAttribute("minimizada","N" );
      ((Element)v.get(102)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 102   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("ancho","50" );
      ((Element)v.get(108)).setAttribute("minimizable","S" );
      ((Element)v.get(108)).setAttribute("minimizada","N" );
      ((Element)v.get(102)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:102   */

      /* Empieza nodo:109 / Elemento padre: 93   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(109)).setAttribute("alto","20" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(109)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(109)).setAttribute("imgFondo","" );
      ((Element)v.get(109)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(109)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(93)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("colFondo","" );
      ((Element)v.get(110)).setAttribute("ID","EstCab" );
      ((Element)v.get(110)).setAttribute("align","center" );
      ((Element)v.get(110)).setAttribute("cod","2202" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Elemento padre:110 / Elemento actual: 111   */
      v.add(doc.createTextNode("Niveles geográficos"));
      ((Element)v.get(110)).appendChild((Text)v.get(111));

      /* Termina nodo Texto:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(112)).setAttribute("colFondo","" );
      ((Element)v.get(112)).setAttribute("ID","EstCab" );
      ((Element)v.get(112)).setAttribute("cod","352" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Elemento padre:112 / Elemento actual: 113   */
      v.add(doc.createTextNode("País 01"));
      ((Element)v.get(112)).appendChild((Text)v.get(113));

      /* Termina nodo Texto:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("colFondo","" );
      ((Element)v.get(114)).setAttribute("ID","EstCab" );
      ((Element)v.get(114)).setAttribute("cod","353" );
      ((Element)v.get(109)).appendChild((Element)v.get(114));

      /* Elemento padre:114 / Elemento actual: 115   */
      v.add(doc.createTextNode("País 02"));
      ((Element)v.get(114)).appendChild((Text)v.get(115));

      /* Termina nodo Texto:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("colFondo","" );
      ((Element)v.get(116)).setAttribute("ID","EstCab" );
      ((Element)v.get(116)).setAttribute("cod","354" );
      ((Element)v.get(109)).appendChild((Element)v.get(116));

      /* Elemento padre:116 / Elemento actual: 117   */
      v.add(doc.createTextNode("País 03"));
      ((Element)v.get(116)).appendChild((Text)v.get(117));

      /* Termina nodo Texto:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("colFondo","" );
      ((Element)v.get(118)).setAttribute("ID","EstCab" );
      ((Element)v.get(118)).setAttribute("cod","355" );
      ((Element)v.get(109)).appendChild((Element)v.get(118));

      /* Elemento padre:118 / Elemento actual: 119   */
      v.add(doc.createTextNode("País 04"));
      ((Element)v.get(118)).appendChild((Text)v.get(119));

      /* Termina nodo Texto:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 109   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("colFondo","" );
      ((Element)v.get(120)).setAttribute("ID","EstCab" );
      ((Element)v.get(120)).setAttribute("cod","356" );
      ((Element)v.get(109)).appendChild((Element)v.get(120));

      /* Elemento padre:120 / Elemento actual: 121   */
      v.add(doc.createTextNode("País 05"));
      ((Element)v.get(120)).appendChild((Text)v.get(121));

      /* Termina nodo Texto:121   */
      /* Termina nodo:120   */
      /* Termina nodo:109   */

      /* Empieza nodo:122 / Elemento padre: 93   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(122)).setAttribute("alto","22" );
      ((Element)v.get(122)).setAttribute("accion","" );
      ((Element)v.get(122)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(122)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(122)).setAttribute("maxSel","-1" );
      ((Element)v.get(122)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(122)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(122)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(122)).setAttribute("onLoad","" );
      ((Element)v.get(122)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(93)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("tipo","texto" );
      ((Element)v.get(123)).setAttribute("ID","EstDat" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 122   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("tipo","texto" );
      ((Element)v.get(124)).setAttribute("ID","EstDat2" );
      ((Element)v.get(122)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("tipo","texto" );
      ((Element)v.get(125)).setAttribute("ID","EstDat" );
      ((Element)v.get(122)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 122   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("tipo","texto" );
      ((Element)v.get(126)).setAttribute("ID","EstDat2" );
      ((Element)v.get(122)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 122   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("tipo","texto" );
      ((Element)v.get(127)).setAttribute("ID","EstDat" );
      ((Element)v.get(122)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 122   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("tipo","texto" );
      ((Element)v.get(128)).setAttribute("ID","EstDat2" );
      ((Element)v.get(122)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:122   */

      /* Empieza nodo:129 / Elemento padre: 93   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(93)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 93   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(130)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(130)).setAttribute("ancho","404" );
      ((Element)v.get(130)).setAttribute("sep","$" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(130)).setAttribute("x","12" );
      ((Element)v.get(130)).setAttribute("class","botonera" );
      ((Element)v.get(130)).setAttribute("y","440" );
      ((Element)v.get(130)).setAttribute("control","|" );
      ((Element)v.get(130)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(130)).setAttribute("rowset","" );
      ((Element)v.get(130)).setAttribute("cargainicial","N" );
      ((Element)v.get(93)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(131)).setAttribute("nombre","ret1" );
      ((Element)v.get(131)).setAttribute("x","37" );
      ((Element)v.get(131)).setAttribute("y","436" );
      ((Element)v.get(131)).setAttribute("ID","botonContenido" );
      ((Element)v.get(131)).setAttribute("img","retroceder_on" );
      ((Element)v.get(131)).setAttribute("tipo","0" );
      ((Element)v.get(131)).setAttribute("estado","false" );
      ((Element)v.get(131)).setAttribute("alt","" );
      ((Element)v.get(131)).setAttribute("codigo","" );
      ((Element)v.get(131)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 130   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(132)).setAttribute("nombre","ava1" );
      ((Element)v.get(132)).setAttribute("x","52" );
      ((Element)v.get(132)).setAttribute("y","436" );
      ((Element)v.get(132)).setAttribute("ID","botonContenido" );
      ((Element)v.get(132)).setAttribute("img","avanzar_on" );
      ((Element)v.get(132)).setAttribute("tipo","0" );
      ((Element)v.get(132)).setAttribute("estado","false" );
      ((Element)v.get(132)).setAttribute("alt","" );
      ((Element)v.get(132)).setAttribute("codigo","" );
      ((Element)v.get(132)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(130)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:130   */
      /* Termina nodo:93   */

      /* Empieza nodo:133 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(133)).setAttribute("nombre","primera1" );
      ((Element)v.get(133)).setAttribute("x","20" );
      ((Element)v.get(133)).setAttribute("y","436" );
      ((Element)v.get(133)).setAttribute("ID","botonContenido" );
      ((Element)v.get(133)).setAttribute("img","primera_on" );
      ((Element)v.get(133)).setAttribute("tipo","0" );
      ((Element)v.get(133)).setAttribute("estado","false" );
      ((Element)v.get(133)).setAttribute("alt","" );
      ((Element)v.get(133)).setAttribute("codigo","" );
      ((Element)v.get(133)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(134)).setAttribute("nombre","separa" );
      ((Element)v.get(134)).setAttribute("x","59" );
      ((Element)v.get(134)).setAttribute("y","439" );
      ((Element)v.get(134)).setAttribute("ID","botonContenido" );
      ((Element)v.get(134)).setAttribute("img","separa_base" );
      ((Element)v.get(134)).setAttribute("tipo","0" );
      ((Element)v.get(134)).setAttribute("estado","false" );
      ((Element)v.get(134)).setAttribute("alt","" );
      ((Element)v.get(134)).setAttribute("codigo","" );
      ((Element)v.get(134)).setAttribute("accion","" );
      ((Element)v.get(4)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(135)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(135)).setAttribute("alto","12" );
      ((Element)v.get(135)).setAttribute("ancho","100%" );
      ((Element)v.get(135)).setAttribute("colorf","" );
      ((Element)v.get(135)).setAttribute("borde","0" );
      ((Element)v.get(135)).setAttribute("imagenf","" );
      ((Element)v.get(135)).setAttribute("repeat","" );
      ((Element)v.get(135)).setAttribute("padding","" );
      ((Element)v.get(135)).setAttribute("visibilidad","visible" );
      ((Element)v.get(135)).setAttribute("contravsb","" );
      ((Element)v.get(135)).setAttribute("x","0" );
      ((Element)v.get(135)).setAttribute("y","441" );
      ((Element)v.get(135)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:4   */


   }

}
