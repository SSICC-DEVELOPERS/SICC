
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cartera_territorios_reasignar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_cartera_territorios_reasignar" );
      ((Element)v.get(0)).setAttribute("cod","0285" );
      ((Element)v.get(0)).setAttribute("titulo","" );
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
      v.add(doc.createTextNode("\r     \r      \r	function onLoadPag()   \r	{\r      ocultarLista();\r      configurarMenuSecundario(\"frmContenido\");\r	    DrdEnsanchaConMargenDcho('listado1',12);\r	    eval (ON_RSZ);  \r      focaliza('frmContenido.cbUsuarioOrigen');\r	}\r\r     function usuarioOrigenOnChange() {\r            var arra = new Array();\r            arra[0] = [\"oidPais\",get('frmContenido.oidPais')];\r            arra[1] = [\"oidIdioma\",get('frmContenido.oidIdioma')];      \r            arra[2] = [\"oid\",get('frmContenido.cbUsuarioOrigen')];\r            recargaCombo(\"frmContenido.cbUsuarioDestino\",\"COBObtenerUsuariosCobComboMenos1\",\"es.indra.sicc.util.DTOOID\",arra);\r            recargaCombo(\"frmContenido.cbCodEtDeuda\",\"COBObtenerEtapasUsuarioCOB\",\"es.indra.sicc.util.DTOOID\",arra);\r            ocultarLista();\r      }\r\r      function recargaPeriodo(){\r         \r                 var arra = new Array();\r                 var arra1 = new Array();\r                 arra[0] = [\"oidPais\",get('frmContenido.oidPais')];\r                 arra1[0] = [\"oidPais\",get('frmContenido.oidPais')];\r                 arra[1] = [\"oidCanal\",get('frmContenido.cbCanal')];\r                 arra[2] = [\"oidMarca\",get('frmContenido.cbMarca')];\r                 arra1[1] = [\"canal\",get('frmContenido.cbCanal')];\r                 arra1[2] = [\"marca\",get('frmContenido.cbMarca')];\r                 recargaCombo(\"frmContenido.cbSubgerenciaVentas\",\"ZONRecargaSubgerenciaVentas\",\"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\",arra);\r                 recargaCombo(\"frmContenido.cbCodPeriodo\",\"CRAObtienePeriodos\",\"es.indra.sicc.dtos.cra.DTOPeriodo\",arra1);\r                 ocultarLista();\r      }\r\r\r      function subgerenciaOnChange(){\r			 var arra = new Array();\r			 arra[0] = [\"oidPais\",get('frmContenido.oidPais')];\r			 arra[1] = [\"oidCanal\",get('frmContenido.cbCanal')];\r		     arra[2] = [\"oidMarca\",get('frmContenido.cbMarca')];\r			 recargaCombo(\"frmContenido.cbRegion\",\"ZONRecargaRegiones\",\"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\",arra);\r       ocultarLista();\r      }\r\r\r       function regionOnChange(){\r			 limpiarZona();\r			 limpiarSeccion();\r			 var arra = new Array();\r			 arra[0] = [\"oidPais\",get('frmContenido.oidPais')];\r			 arra[1] = [\"oidCanal\",get('frmContenido.cbCanal')];\r			 arra[2] = [\"oidMarca\",get('frmContenido.cbMarca')];\r			 arra[3] = [\"oidRegion\",get('frmContenido.cbRegion')];\r			 recargaCombo(\"frmContenido.cbZona\",\"ZONRecargaZonas\",\"es.indra.sicc.dtos.zon.DTOUnidadAdministrativa\",arra);\r			 ocultarLista();\r      }\r	\r\r       function zonaOnChange (){\r			limpiarSeccion();\r			combo_add('frmContenido.cbSeccion', '', '');\r			var zonas = get('frmContenido.cbZona');\r			var pais = get('frmContenido.pais');\r			var zonaConc = new String();\r			for(i=0;i<zonas.length;i++){\r				zonaConc += zonas[i] + \"x\";\r			}\r			zonaConc = zonaConc.substring(0, zonaConc.length-1);\r			var arr = new Array();\r			arr[arr.length] = ['cadena', zonaConc];\r			arr[arr.length] = ['oidPais', pais]\r			if(zonaConc != ''){\r				recargaCombo(\"frmContenido.cbSeccion\", \"REPRecargaSecciones\", \"es.indra.sicc.util.DTOString\",arr);\r			}\r			ocultarLista();\r        }\r        \r        \r        function  buscarOnClick(){\r            if(!sicc_validaciones_generales(\"gr\")){\r                return false;\r            }  \r                configurarPaginado(mipgndo,\"COBBuscarAsignacionesCobranza\",\"ConectorBuscarAsignacionesCobranza\",\"es.indra.sicc.dtos.cob.DTOAsignacionesCobranza\", armarArray());          \r         }     \r         \r         \r         function armarArray(){\r            var arra = new Array();\r            var pos = 0;\r            \r            if(get(\"frmContenido.cbUsuarioOrigen\")!=\"\" && get(\"frmContenido.cbUsuarioOrigen\")!=null){\r                arra[pos] = [\"usuarioOrigen\",get('frmContenido.cbUsuarioOrigen')];\r                set ('frmContenido.usuarioOrigen',get('frmContenido.cbUsuarioOrigen'));\r                pos++;\r             }\r             \r             if(get(\"frmContenido.cbUsuarioDestino\")!=\"\" && get(\"frmContenido.cbUsuarioDestino\")!=null){\r                arra[pos] = [\"usuarioDestino\",get('frmContenido.cbUsuarioDestino')];\r                /*\r				 * INC 22282 - dmorello, 06/01/2006\r				 * Se estaba asignando el valor del combo Usuario destino a la variable usuarioOrigen.\r				 * Se corrige para que lo asigne a usuarioDestino.\r				 */\r				set ('frmContenido.usuarioDestino',get('frmContenido.cbUsuarioDestino'));\r                pos++;\r             }\r             \r             \r             if(get(\"frmContenido.cbCodEtDeuda\")!=\"\" && get(\"frmContenido.cbCodEtDeuda\")!=null){\r                arra[pos] = [\"etapaDeuda\",get('frmContenido.cbCodEtDeuda')];\r                set ('frmContenido.etapaDeuda',get('frmContenido.cbCodEtDeuda'));\r                pos++;\r             }\r             \r             \r             if(get(\"frmContenido.cbMarca\")!=\"\" && get(\"frmContenido.cbMarca\")!=null){\r                arra[pos] = [\"marca\",get('frmContenido.cbMarca')];\r                set ('frmContenido.marca',get('frmContenido.cbMarca'));\r                pos++;\r             }\r             \r             \r             if(get(\"frmContenido.cbCanal\")!=\"\" && get(\"frmContenido.cbCanal\")!=null){\r                arra[pos] = [\"canal\",get('frmContenido.cbCanal')];\r                set ('frmContenido.canal',get('frmContenido.cbCanal'));\r                pos++;\r             }\r             \r             \r             if(get(\"frmContenido.cbCodPeriodo\")!=\"\" && get(\"frmContenido.cbCodPeriodo\")!=null){\r                arra[pos] = [\"periodo\",get('frmContenido.cbCodPeriodo')];\r                set ('frmContenido.periodo',get('frmContenido.cbCodPeriodo'));\r                pos++;\r             }\r             \r             \r             if(get(\"frmContenido.cbSubgerenciaVentas\")!=\"\" && get(\"frmContenido.cbSubgerenciaVentas\")!=null){\r                arra[pos] = [\"subgerencia\",get('frmContenido.cbSubgerenciaVentas')];\r                set ('frmContenido.subGerencia',get('frmContenido.cbSubgerenciaVentas'));\r                pos++;\r             }\r             \r             \r             if(get(\"frmContenido.cbZona\")!=\"\" && get(\"frmContenido.cbZona\")!=null){\r                arra[pos] = [\"zona\",get('frmContenido.cbZona')];\r                set ('frmContenido.zona',get('frmContenido.cbZona'));\r                pos++;\r             }\r             \r             \r             if(get(\"frmContenido.cbRegion\")!=\"\" && get(\"frmContenido.cbRegion\")!=null){\r                arra[pos] = [\"region\",get('frmContenido.cbRegion')];\r                set ('frmContenido.region',get('frmContenido.cbRegion'));\r                pos++;\r             }\r             \r             \r             if(get(\"frmContenido.cbSeccion\")!=\"\" && get(\"frmContenido.cbSeccion\")!=null){\r                arra[pos] = [\"seccion\",get('frmContenido.cbSeccion')];\r                set ('frmContenido.seccion',get('frmContenido.cbSeccion'));\r                pos++;\r             }\r             \r             \r             arra[pos] = [\"paginado\",\"1\"];\r			 set ('frmContenido.territorio',get('frmContenido.txtTerritorio'));\r			 pos++;\r			 \r			 if(get(\"frmContenido.txtTerritorio\")!=\"\" && get(\"frmContenido.txtTerritorio\")!=null){\r                arra[pos] = [\"territorio\",get('frmContenido.txtTerritorio')];\r             }\r         \r      return arra;\r    }\r    \r    function tabSimple(nombre){\r        document.selection.empty();\r        focaliza(nombre);\r    }\r    \r    \r    function tabHTML (nombre){\r        document.selection.empty();\r        focaliza(nombre);\r    }\r    \r\r   function muestraLista(ultima, rowset) {\r        var tamano = rowset.length;\r        if (tamano > 0) {\r			mostrarLista();\r        }else{\r			ocultarLista();\r			return false;\r        }\r				return true;\r	}   \r\r\r    function ocultarLista(){\r	    document.all[\"Cplistado1\"].style.visibility='hidden';\r	    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r	    document.all[\"primera1Div\"].style.visibility='hidden';\r	    document.all[\"ret1Div\"].style.visibility='hidden';\r	    document.all[\"ava1Div\"].style.visibility='hidden';\r	    document.all[\"separaDiv\"].style.visibility='hidden';\r      document.all[\"Reasignar\"].style.visibility='hidden';\r	    eval (ON_RSZ);  \r	    \r	}\r  \r  	function mostrarLista(){\r          DrdEnsanchaConMargenDcho('listado1',12);\r          document.all[\"Cplistado1\"].style.visibility='visible';\r          document.all[\"CpLin1listado1\"].style.visibility='visible';\r          document.all[\"CpLin2listado1\"].style.visibility='visible';\r          document.all[\"CpLin3listado1\"].style.visibility='visible';\r          document.all[\"CpLin4listado1\"].style.visibility='visible';\r          document.all[\"primera1Div\"].style.visibility='visible';\r          document.all[\"ret1Div\"].style.visibility='visible';\r          document.all[\"ava1Div\"].style.visibility='visible';\r          document.all[\"separaDiv\"].style.visibility='visible';\r          document.all[\"Reasignar\"].style.visibility='visible';\r          eval (ON_RSZ);  \r	}\r         \r         \r   function fLimpiar(){\r        set_combo('frmContenido.cbUsuarioDestino', [[''],['']]);\r        set_combo('frmContenido.cbCodEtDeuda', [[''],['']]);\r        set_combo('frmContenido.cbCodPeriodo', [[''],['']]);\r        set_combo('frmContenido.cbSubgerenciaVentas', [[''],['']]);        \r        set_combo('frmContenido.cbRegion', [[''],['']]);        \r        set_combo('frmContenido.cbZona', [[''],['']]);        \r        set_combo('frmContenido.cbSeccion', [[''],['']]);        \r        ocultarLista();\r        focaliza('frmContenido.cbUsuarioOrigen','');\r	}\r         \r   function reasignarOnClick(){\r    set('frmContenido.accion','reasignar');         \r    set('frmContenido.conectorAction','LPReasignarCarteraTerritorios');\r    eval(\"frmContenido\").oculto=\"S\";\r    enviaSICC('frmContenido', '', '', 'N');\r    buscarOnClick();\r   \r  }\r  function quitaOculto(){\r    eval(\"frmContenido\").oculto=\"N\";\r  }      \r\r\r    function desSeleccionar(){\r      document.selection.empty();         \r    }\r\r   function limpiarZona(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('frmContenido.cbZona', aCombo, []);\r   }\r\r   function limpiarSeccion(){\r      var aCombo = new Array(new Array(\"\",\"\"));\r      set_combo('frmContenido.cbSeccion', aCombo, []); \r   }	\r\r   function focalizaBotonReasignar(){\r		 focalizaBotonHTML_XY('Reasignar');\r   }\r\r  \r  "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbUsuarioOrigen" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","1048" );
      ((Element)v.get(7)).setAttribute("group","gr" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbUsuarioDestino" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","1020" );
      ((Element)v.get(8)).setAttribute("group","gr" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbCodEtDeuda" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","818" );
      ((Element)v.get(9)).setAttribute("group","gr" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbMarca" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","6" );
      ((Element)v.get(10)).setAttribute("group","gr" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbCanal" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","7" );
      ((Element)v.get(11)).setAttribute("group","gr" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbCodPeriodo" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","30" );
      ((Element)v.get(12)).setAttribute("group","gr" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbSubgerenciaVentas" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","124" );
      ((Element)v.get(13)).setAttribute("group","gr" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:6   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(14)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","accion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(19)).setAttribute("valor","LPReasignarCarteraTerritorios" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 14   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidPais" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","usuarioOrigen" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","usuarioDestino" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","etapaDeuda" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","marca" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","canal" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","periodo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","subGerencia" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","zona" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","region" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","seccion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","territorio" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(33)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(34)).setAttribute("width","100%" );
      ((Element)v.get(34)).setAttribute("border","0" );
      ((Element)v.get(34)).setAttribute("cellspacing","0" );
      ((Element)v.get(34)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

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
   }

   private void getXML180(Document doc) {
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
      ((Element)v.get(48)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","Datos Búsqueda" );
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
      ((Element)v.get(52)).setAttribute("width","640" );
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
      ((Element)v.get(54)).setAttribute("colspan","4" );
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
      ((Element)v.get(60)).setAttribute("nombre","lblUsuarioOrigen" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","datosTitle" );
      ((Element)v.get(60)).setAttribute("cod","1048" );
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
      ((Element)v.get(64)).setAttribute("nombre","lblUsuarioDestino" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("cod","1020" );
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
   }

   private void getXML270(Document doc) {
      ((Element)v.get(56)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","lblCodEtapaDeuda" );
      ((Element)v.get(68)).setAttribute("alto","13" );
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(68)).setAttribute("id","datosTitle" );
      ((Element)v.get(68)).setAttribute("cod","818" );
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
      ((Element)v.get(74)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(75)).setAttribute("nombre","cbUsuarioOrigen" );
      ((Element)v.get(75)).setAttribute("id","datosCampos" );
      ((Element)v.get(75)).setAttribute("size","1" );
      ((Element)v.get(75)).setAttribute("multiple","N" );
      ((Element)v.get(75)).setAttribute("req","S" );
      ((Element)v.get(75)).setAttribute("valorinicial","" );
      ((Element)v.get(75)).setAttribute("textoinicial","" );
      ((Element)v.get(75)).setAttribute("onchange","usuarioOrigenOnChange();" );
      ((Element)v.get(75)).setAttribute("ontab","tabSimple('frmContenido.cbUsuarioDestino')" );
      ((Element)v.get(75)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar')" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:77 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","25" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(71)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(80)).setAttribute("nombre","cbUsuarioDestino" );
      ((Element)v.get(80)).setAttribute("id","datosCampos" );
      ((Element)v.get(80)).setAttribute("size","1" );
      ((Element)v.get(80)).setAttribute("multiple","N" );
      ((Element)v.get(80)).setAttribute("req","S" );
      ((Element)v.get(80)).setAttribute("valorinicial","" );
      ((Element)v.get(80)).setAttribute("textoinicial","" );
      ((Element)v.get(80)).setAttribute("ontab","tabSimple('frmContenido.cbCodEtDeuda')" );
      ((Element)v.get(80)).setAttribute("onshtab","tabSimple('frmContenido.cbUsuarioOrigen')" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:82 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","25" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(71)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(85)).setAttribute("nombre","cbCodEtDeuda" );
      ((Element)v.get(85)).setAttribute("id","datosCampos" );
      ((Element)v.get(85)).setAttribute("size","1" );
      ((Element)v.get(85)).setAttribute("multiple","N" );
      ((Element)v.get(85)).setAttribute("req","S" );
      ((Element)v.get(85)).setAttribute("valorinicial","" );
      ((Element)v.get(85)).setAttribute("textoinicial","" );
      ((Element)v.get(85)).setAttribute("ontab","tabSimple('frmContenido.cbMarca')" );
      ((Element)v.get(85)).setAttribute("onshtab","tabSimple('frmContenido.cbUsuarioDestino')" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:87 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(71)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:71   */

      /* Empieza nodo:89 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("colspan","4" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:92 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("table"));
      ((Element)v.get(94)).setAttribute("width","640" );
      ((Element)v.get(94)).setAttribute("border","0" );
      ((Element)v.get(94)).setAttribute("align","left" );
      ((Element)v.get(94)).setAttribute("cellspacing","0" );
      ((Element)v.get(94)).setAttribute("cellpadding","0" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

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
      ((Element)v.get(95)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(99)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(99)).setAttribute("alto","13" );
      ((Element)v.get(99)).setAttribute("filas","1" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(99)).setAttribute("id","datosTitle" );
      ((Element)v.get(99)).setAttribute("cod","6" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","25" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("id","datosTitle" );
      ((Element)v.get(103)).setAttribute("cod","7" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(107)).setAttribute("nombre","lblCodPeriodo" );
      ((Element)v.get(107)).setAttribute("alto","13" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(107)).setAttribute("id","datosTitle" );
      ((Element)v.get(107)).setAttribute("cod","30" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(95)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:95   */

      /* Empieza nodo:110 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(94)).appendChild((Element)v.get(110));

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
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(114)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(114)).setAttribute("id","datosCampos" );
      ((Element)v.get(114)).setAttribute("size","1" );
      ((Element)v.get(114)).setAttribute("multiple","N" );
      ((Element)v.get(114)).setAttribute("req","S" );
      ((Element)v.get(114)).setAttribute("valorinicial","" );
      ((Element)v.get(114)).setAttribute("textoinicial","" );
      ((Element)v.get(114)).setAttribute("onchange","recargaPeriodo();" );
      ((Element)v.get(114)).setAttribute("ontab","tabSimple('frmContenido.cbCanal')" );
      ((Element)v.get(114)).setAttribute("onshtab","tabSimple('frmContenido.cbCodEtDeuda')" );
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
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(119)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("size","1" );
      ((Element)v.get(119)).setAttribute("multiple","N" );
      ((Element)v.get(119)).setAttribute("req","S" );
      ((Element)v.get(119)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).setAttribute("textoinicial","" );
      ((Element)v.get(119)).setAttribute("onchange","recargaPeriodo();" );
      ((Element)v.get(119)).setAttribute("ontab","tabSimple('frmContenido.cbCodPeriodo')" );
      ((Element)v.get(119)).setAttribute("onshtab","tabSimple('frmContenido.cbMarca')" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:121 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(124)).setAttribute("nombre","cbCodPeriodo" );
      ((Element)v.get(124)).setAttribute("id","datosCampos" );
      ((Element)v.get(124)).setAttribute("size","1" );
      ((Element)v.get(124)).setAttribute("multiple","N" );
      ((Element)v.get(124)).setAttribute("req","S" );
      ((Element)v.get(124)).setAttribute("valorinicial","" );
      ((Element)v.get(124)).setAttribute("textoinicial","" );
      ((Element)v.get(124)).setAttribute("ontab","tabSimple('frmContenido.cbSubgerenciaVentas')" );
      ((Element)v.get(124)).setAttribute("onshtab","tabSimple('frmContenido.cbCanal')" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:126 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(110)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:110   */

      /* Empieza nodo:128 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("colspan","4" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:131 / Elemento padre: 49   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("table"));
      ((Element)v.get(133)).setAttribute("width","640" );
      ((Element)v.get(133)).setAttribute("border","0" );
      ((Element)v.get(133)).setAttribute("align","left" );
      ((Element)v.get(133)).setAttribute("cellspacing","0" );
      ((Element)v.get(133)).setAttribute("cellpadding","0" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(138)).setAttribute("alto","13" );
      ((Element)v.get(138)).setAttribute("filas","1" );
      ((Element)v.get(138)).setAttribute("valor","" );
      ((Element)v.get(138)).setAttribute("id","datosTitle" );
      ((Element)v.get(138)).setAttribute("cod","124" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","25" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(142)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(142)).setAttribute("alto","13" );
      ((Element)v.get(142)).setAttribute("filas","1" );
      ((Element)v.get(142)).setAttribute("valor","" );
      ((Element)v.get(142)).setAttribute("id","datosTitle" );
      ((Element)v.get(142)).setAttribute("cod","109" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(134)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:134   */

      /* Empieza nodo:145 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(145)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(149)).setAttribute("nombre","cbSubgerenciaVentas" );
      ((Element)v.get(149)).setAttribute("id","datosCampos" );
      ((Element)v.get(149)).setAttribute("size","1" );
      ((Element)v.get(149)).setAttribute("multiple","N" );
      ((Element)v.get(149)).setAttribute("req","S" );
      ((Element)v.get(149)).setAttribute("valorinicial","" );
      ((Element)v.get(149)).setAttribute("textoinicial","" );
      ((Element)v.get(149)).setAttribute("onchange","subgerenciaOnChange();" );
      ((Element)v.get(149)).setAttribute("ontab","tabSimple('frmContenido.cbRegion')" );
      ((Element)v.get(149)).setAttribute("onshtab","tabSimple('frmContenido.cbCodPeriodo')" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:151 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","25" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("nowrap","nowrap" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(153)).setAttribute("valign","bottom" );
      ((Element)v.get(145)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(154)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(154)).setAttribute("id","datosCampos" );
      ((Element)v.get(154)).setAttribute("size","1" );
      ((Element)v.get(154)).setAttribute("multiple","N" );
      ((Element)v.get(154)).setAttribute("req","N" );
      ((Element)v.get(154)).setAttribute("valorinicial","" );
      ((Element)v.get(154)).setAttribute("textoinicial","" );
      ((Element)v.get(154)).setAttribute("onchange","regionOnChange();" );
      ((Element)v.get(154)).setAttribute("ontab","tabSimple('frmContenido.cbZona')" );
      ((Element)v.get(154)).setAttribute("onshtab","tabSimple('frmContenido.cbSubgerenciaVentas')" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:156 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("width","100%" );
      ((Element)v.get(145)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","8" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:145   */

      /* Empieza nodo:158 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("colspan","4" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:161 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("table"));
      ((Element)v.get(163)).setAttribute("width","640" );
      ((Element)v.get(163)).setAttribute("border","0" );
      ((Element)v.get(163)).setAttribute("align","left" );
      ((Element)v.get(163)).setAttribute("cellspacing","0" );
      ((Element)v.get(163)).setAttribute("cellpadding","0" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(168)).setAttribute("nombre","lblZona" );
      ((Element)v.get(168)).setAttribute("alto","13" );
      ((Element)v.get(168)).setAttribute("filas","1" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("id","datosTitle" );
      ((Element)v.get(168)).setAttribute("cod","143" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","25" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(172)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(172)).setAttribute("alto","13" );
      ((Element)v.get(172)).setAttribute("filas","1" );
      ((Element)v.get(172)).setAttribute("valor","" );
      ((Element)v.get(172)).setAttribute("id","datosTitle" );
      ((Element)v.get(172)).setAttribute("cod","112" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).setAttribute("width","100%" );
      ((Element)v.get(164)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:164   */

      /* Empieza nodo:175 / Elemento padre: 163   */
      v.add(doc.createElement("tr"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(163)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(175)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(179)).setAttribute("nombre","cbZona" );
      ((Element)v.get(179)).setAttribute("id","datosCampos" );
      ((Element)v.get(179)).setAttribute("size","1" );
      ((Element)v.get(179)).setAttribute("multiple","N" );
      ((Element)v.get(179)).setAttribute("req","N" );
      ((Element)v.get(179)).setAttribute("valorinicial","" );
      ((Element)v.get(179)).setAttribute("textoinicial","" );
      ((Element)v.get(179)).setAttribute("onchange","zonaOnChange();" );
      ((Element)v.get(179)).setAttribute("ontab","tabSimple('frmContenido.cbSeccion')" );
      ((Element)v.get(179)).setAttribute("onshtab","tabSimple('frmContenido.cbRegion')" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:181 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","25" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(175)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(184)).setAttribute("nombre","cbSeccion" );
      ((Element)v.get(184)).setAttribute("id","datosCampos" );
      ((Element)v.get(184)).setAttribute("size","1" );
      ((Element)v.get(184)).setAttribute("multiple","N" );
      ((Element)v.get(184)).setAttribute("req","N" );
      ((Element)v.get(184)).setAttribute("valorinicial","" );
      ((Element)v.get(184)).setAttribute("textoinicial","" );
      ((Element)v.get(184)).setAttribute("ontab","tabSimple('frmContenido.txtTerritorio')" );
      ((Element)v.get(184)).setAttribute("onshtab","tabSimple('frmContenido.cbZona')" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:186 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("width","100%" );
      ((Element)v.get(175)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:175   */

      /* Empieza nodo:188 / Elemento padre: 163   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(163)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("colspan","4" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:191 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("table"));
      ((Element)v.get(193)).setAttribute("width","640" );
      ((Element)v.get(193)).setAttribute("border","0" );
      ((Element)v.get(193)).setAttribute("align","left" );
      ((Element)v.get(193)).setAttribute("cellspacing","0" );
      ((Element)v.get(193)).setAttribute("cellpadding","0" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(198)).setAttribute("nombre","lblTerritorio" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(198)).setAttribute("alto","13" );
      ((Element)v.get(198)).setAttribute("filas","1" );
      ((Element)v.get(198)).setAttribute("valor","" );
      ((Element)v.get(198)).setAttribute("id","datosTitle" );
      ((Element)v.get(198)).setAttribute("cod","126" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("width","100%" );
      ((Element)v.get(194)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:194   */

      /* Empieza nodo:201 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(205)).setAttribute("nombre","txtTerritorio" );
      ((Element)v.get(205)).setAttribute("id","datosCampos" );
      ((Element)v.get(205)).setAttribute("max","40" );
      ((Element)v.get(205)).setAttribute("tipo","" );
      ((Element)v.get(205)).setAttribute("onchange","ocultarLista();" );
      ((Element)v.get(205)).setAttribute("req","N" );
      ((Element)v.get(205)).setAttribute("size","40" );
      ((Element)v.get(205)).setAttribute("valor","" );
      ((Element)v.get(205)).setAttribute("validacion","" );
      ((Element)v.get(205)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnBuscar'); document.selection.empty();" );
      ((Element)v.get(205)).setAttribute("onshtab","tabSimple('frmContenido.cbSeccion')" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).setAttribute("width","100%" );
      ((Element)v.get(201)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","8" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:201   */

      /* Empieza nodo:208 / Elemento padre: 193   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(193)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("colspan","4" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","8" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:49   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:211 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:42   */

      /* Empieza nodo:213 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("table"));
      ((Element)v.get(218)).setAttribute("width","100%" );
      ((Element)v.get(218)).setAttribute("border","0" );
      ((Element)v.get(218)).setAttribute("align","center" );
      ((Element)v.get(218)).setAttribute("cellspacing","0" );
      ((Element)v.get(218)).setAttribute("cellpadding","0" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("class","botonera" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(221)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(221)).setAttribute("ID","botonContenido" );
      ((Element)v.get(221)).setAttribute("tipo","html" );
      ((Element)v.get(221)).setAttribute("accion","buscarOnClick();" );
      ((Element)v.get(221)).setAttribute("estado","false" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(221)).setAttribute("cod","1" );
      ((Element)v.get(221)).setAttribute("onclick","buscarOnClick();" );
      ((Element)v.get(221)).setAttribute("ontab","tabSimple('frmContenido.cbUsuarioOrigen')" );
      ((Element)v.get(221)).setAttribute("onshtab","tabSimple('frmContenido.txtTerritorio')" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:222 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","8" );
      ((Element)v.get(223)).setAttribute("height","12" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:213   */

      /* Empieza nodo:224 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).setAttribute("width","12" );
      ((Element)v.get(225)).setAttribute("align","center" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","12" );
      ((Element)v.get(226)).setAttribute("height","12" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("width","750" );
      ((Element)v.get(224)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("width","12" );
      ((Element)v.get(224)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","12" );
      ((Element)v.get(230)).setAttribute("height","1" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:224   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:231 / Elemento padre: 14   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(231)).setAttribute("nombre","listado1" );
      ((Element)v.get(231)).setAttribute("ancho","644" );
      ((Element)v.get(231)).setAttribute("alto","317" );
      ((Element)v.get(231)).setAttribute("x","12" );
      ((Element)v.get(231)).setAttribute("y","289" );
      ((Element)v.get(231)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(231)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(232)).setAttribute("precarga","S" );
      ((Element)v.get(232)).setAttribute("conROver","S" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(233)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(233)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(233)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(233)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 232   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(234)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(234)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(234)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(234)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(232)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 232   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(235)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(235)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(232)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:232   */

      /* Empieza nodo:236 / Elemento padre: 231   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(231)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(237)).setAttribute("borde","1" );
      ((Element)v.get(237)).setAttribute("horizDatos","1" );
      ((Element)v.get(237)).setAttribute("horizCabecera","1" );
      ((Element)v.get(237)).setAttribute("vertical","1" );
      ((Element)v.get(237)).setAttribute("horizTitulo","1" );
      ((Element)v.get(237)).setAttribute("horizBase","1" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 236   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(238)).setAttribute("borde","#999999" );
      ((Element)v.get(238)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(238)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(238)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(238)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(238)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(238)).setAttribute("horizBase","#999999" );
      ((Element)v.get(236)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:236   */

      /* Empieza nodo:239 / Elemento padre: 231   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(239)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(239)).setAttribute("alto","22" );
      ((Element)v.get(239)).setAttribute("imgFondo","" );
      ((Element)v.get(239)).setAttribute("cod","00135" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(239)).setAttribute("ID","datosTitle" );
      ((Element)v.get(231)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 231   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(240)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(240)).setAttribute("alto","22" );
      ((Element)v.get(240)).setAttribute("imgFondo","" );
      ((Element)v.get(231)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 231   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(241)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(241)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(241)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(241)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(241)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(241)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(231)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("ancho","130" );
      ((Element)v.get(242)).setAttribute("minimizable","S" );
      ((Element)v.get(242)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("ancho","130" );
      ((Element)v.get(243)).setAttribute("minimizable","S" );
      ((Element)v.get(243)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("ancho","100" );
      ((Element)v.get(244)).setAttribute("minimizable","S" );
      ((Element)v.get(244)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("ancho","100" );
      ((Element)v.get(245)).setAttribute("minimizable","S" );
      ((Element)v.get(245)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("ancho","100" );
      ((Element)v.get(246)).setAttribute("minimizable","S" );
      ((Element)v.get(246)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("ancho","150" );
      ((Element)v.get(247)).setAttribute("minimizable","S" );
      ((Element)v.get(247)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("ancho","100" );
      ((Element)v.get(248)).setAttribute("minimizable","S" );
      ((Element)v.get(248)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("ancho","100" );
      ((Element)v.get(249)).setAttribute("minimizable","S" );
      ((Element)v.get(249)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("ancho","100" );
      ((Element)v.get(250)).setAttribute("minimizable","S" );
      ((Element)v.get(250)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("ancho","100" );
      ((Element)v.get(251)).setAttribute("minimizable","S" );
      ((Element)v.get(251)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("ancho","100" );
      ((Element)v.get(252)).setAttribute("minimizable","S" );
      ((Element)v.get(252)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("ancho","200" );
      ((Element)v.get(253)).setAttribute("minimizable","S" );
      ((Element)v.get(253)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("ancho","200" );
      ((Element)v.get(254)).setAttribute("minimizable","S" );
      ((Element)v.get(254)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 241   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("ancho","200" );
      ((Element)v.get(255)).setAttribute("minimizable","S" );
      ((Element)v.get(255)).setAttribute("minimizada","N" );
      ((Element)v.get(241)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:241   */

      /* Empieza nodo:256 / Elemento padre: 231   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(256)).setAttribute("alto","20" );
      ((Element)v.get(256)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(256)).setAttribute("imgFondo","" );
      ((Element)v.get(256)).setAttribute("colFondo","#CCCCCC" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(231)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("colFondo","" );
      ((Element)v.get(257)).setAttribute("ID","EstCab" );
      ((Element)v.get(257)).setAttribute("cod","1219" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("colFondo","" );
      ((Element)v.get(258)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).setAttribute("cod","1061" );
      ((Element)v.get(256)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("colFondo","" );
      ((Element)v.get(259)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).setAttribute("cod","999" );
      ((Element)v.get(256)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("colFondo","" );
      ((Element)v.get(260)).setAttribute("ID","EstCab" );
      ((Element)v.get(260)).setAttribute("cod","6" );
      ((Element)v.get(256)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("colFondo","" );
      ((Element)v.get(261)).setAttribute("ID","EstCab" );
      ((Element)v.get(261)).setAttribute("cod","7" );
      ((Element)v.get(256)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("colFondo","" );
      ((Element)v.get(262)).setAttribute("ID","EstCab" );
      ((Element)v.get(262)).setAttribute("cod","30" );
      ((Element)v.get(256)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("colFondo","" );
      ((Element)v.get(263)).setAttribute("ID","EstCab" );
      ((Element)v.get(263)).setAttribute("cod","124" );
      ((Element)v.get(256)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("colFondo","" );
      ((Element)v.get(264)).setAttribute("ID","EstCab" );
      ((Element)v.get(264)).setAttribute("cod","109" );
      ((Element)v.get(256)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("colFondo","" );
      ((Element)v.get(265)).setAttribute("ID","EstCab" );
      ((Element)v.get(265)).setAttribute("cod","143" );
      ((Element)v.get(256)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("colFondo","" );
      ((Element)v.get(266)).setAttribute("ID","EstCab" );
      ((Element)v.get(266)).setAttribute("cod","112" );
      ((Element)v.get(256)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("colFondo","" );
      ((Element)v.get(267)).setAttribute("ID","EstCab" );
      ((Element)v.get(267)).setAttribute("cod","263" );
      ((Element)v.get(256)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("colFondo","" );
      ((Element)v.get(268)).setAttribute("ID","EstCab" );
      ((Element)v.get(268)).setAttribute("cod","895" );
      ((Element)v.get(256)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("colFondo","" );
      ((Element)v.get(269)).setAttribute("ID","EstCab" );
      ((Element)v.get(269)).setAttribute("cod","2128" );
      ((Element)v.get(256)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("colFondo","" );
      ((Element)v.get(270)).setAttribute("ID","EstCab" );
      ((Element)v.get(270)).setAttribute("cod","1660" );
      ((Element)v.get(256)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:256   */

      /* Empieza nodo:271 / Elemento padre: 231   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(271)).setAttribute("alto","22" );
      ((Element)v.get(271)).setAttribute("accion","" );
      ((Element)v.get(271)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(271)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(271)).setAttribute("maxSel","0" );
      ((Element)v.get(271)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(271)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(271)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(271)).setAttribute("onLoad","" );
      ((Element)v.get(271)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(231)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("tipo","texto" );
      ((Element)v.get(272)).setAttribute("ID","EstDat" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("tipo","texto" );
      ((Element)v.get(273)).setAttribute("ID","EstDat2" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(271)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("tipo","texto" );
      ((Element)v.get(274)).setAttribute("ID","EstDat" );
      ((Element)v.get(271)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("tipo","texto" );
      ((Element)v.get(275)).setAttribute("ID","EstDat2" );
      ((Element)v.get(271)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("tipo","texto" );
      ((Element)v.get(276)).setAttribute("ID","EstDat" );
      ((Element)v.get(271)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("tipo","texto" );
      ((Element)v.get(277)).setAttribute("ID","EstDat2" );
      ((Element)v.get(271)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("tipo","texto" );
      ((Element)v.get(278)).setAttribute("ID","EstDat" );
      ((Element)v.get(271)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("tipo","texto" );
      ((Element)v.get(279)).setAttribute("ID","EstDat2" );
      ((Element)v.get(271)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("tipo","texto" );
      ((Element)v.get(280)).setAttribute("ID","EstDat" );
      ((Element)v.get(271)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("tipo","texto" );
      ((Element)v.get(281)).setAttribute("ID","EstDat2" );
      ((Element)v.get(271)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("tipo","texto" );
      ((Element)v.get(282)).setAttribute("ID","EstDat" );
      ((Element)v.get(271)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("tipo","texto" );
      ((Element)v.get(283)).setAttribute("ID","EstDat2" );
      ((Element)v.get(271)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("tipo","texto" );
      ((Element)v.get(284)).setAttribute("ID","EstDat" );
      ((Element)v.get(271)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 271   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("tipo","texto" );
      ((Element)v.get(285)).setAttribute("ID","EstDat2" );
      ((Element)v.get(271)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:271   */

      /* Empieza nodo:286 / Elemento padre: 231   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(231)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 231   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(287)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(287)).setAttribute("ancho","644" );
      ((Element)v.get(287)).setAttribute("sep","$" );
      ((Element)v.get(287)).setAttribute("x","12" );
      ((Element)v.get(287)).setAttribute("class","botonera" );
      ((Element)v.get(287)).setAttribute("y","583" );
      ((Element)v.get(287)).setAttribute("control","|" );
      ((Element)v.get(287)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(287)).setAttribute("rowset","" );
      ((Element)v.get(287)).setAttribute("cargainicial","N" );
      ((Element)v.get(287)).setAttribute("onload","procesarPaginado(mipgndo,msgError,ultima,rowset,'muestraLista(ultima,rowset)');" );
      ((Element)v.get(231)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(288)).setAttribute("nombre","ret1" );
      ((Element)v.get(288)).setAttribute("x","37" );
      ((Element)v.get(288)).setAttribute("y","587" );
      ((Element)v.get(288)).setAttribute("ID","botonContenido" );
      ((Element)v.get(288)).setAttribute("img","retroceder_on" );
      ((Element)v.get(288)).setAttribute("tipo","0" );
      ((Element)v.get(288)).setAttribute("estado","false" );
      ((Element)v.get(288)).setAttribute("alt","" );
      ((Element)v.get(288)).setAttribute("codigo","" );
      ((Element)v.get(288)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 287   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(289)).setAttribute("nombre","ava1" );
      ((Element)v.get(289)).setAttribute("x","52" );
      ((Element)v.get(289)).setAttribute("y","587" );
      ((Element)v.get(289)).setAttribute("ID","botonContenido" );
      ((Element)v.get(289)).setAttribute("img","avanzar_on" );
      ((Element)v.get(289)).setAttribute("tipo","0" );
      ((Element)v.get(289)).setAttribute("estado","false" );
      ((Element)v.get(289)).setAttribute("alt","" );
      ((Element)v.get(289)).setAttribute("codigo","" );
      ((Element)v.get(289)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(287)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:287   */
      /* Termina nodo:231   */

      /* Empieza nodo:290 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(290)).setAttribute("nombre","primera1" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(290)).setAttribute("x","20" );
      ((Element)v.get(290)).setAttribute("y","587" );
      ((Element)v.get(290)).setAttribute("ID","botonContenido" );
      ((Element)v.get(290)).setAttribute("img","primera_on" );
      ((Element)v.get(290)).setAttribute("tipo","-2" );
      ((Element)v.get(290)).setAttribute("estado","false" );
      ((Element)v.get(290)).setAttribute("alt","" );
      ((Element)v.get(290)).setAttribute("codigo","" );
      ((Element)v.get(290)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(14)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(291)).setAttribute("nombre","separa" );
      ((Element)v.get(291)).setAttribute("x","59" );
      ((Element)v.get(291)).setAttribute("y","583" );
      ((Element)v.get(291)).setAttribute("ID","botonContenido" );
      ((Element)v.get(291)).setAttribute("img","separa_base" );
      ((Element)v.get(291)).setAttribute("tipo","0" );
      ((Element)v.get(291)).setAttribute("estado","false" );
      ((Element)v.get(291)).setAttribute("alt","" );
      ((Element)v.get(291)).setAttribute("codigo","" );
      ((Element)v.get(291)).setAttribute("accion","" );
      ((Element)v.get(14)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(292)).setAttribute("nombre","Reasignar" );
      ((Element)v.get(292)).setAttribute("x","80" );
      ((Element)v.get(292)).setAttribute("y","584" );
      ((Element)v.get(292)).setAttribute("ID","botonContenido" );
      ((Element)v.get(292)).setAttribute("tipo","html" );
      ((Element)v.get(292)).setAttribute("estado","false" );
      ((Element)v.get(292)).setAttribute("cod","977" );
      ((Element)v.get(292)).setAttribute("accion","reasignarOnClick();" );
      ((Element)v.get(14)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(293)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(293)).setAttribute("alto","12" );
      ((Element)v.get(293)).setAttribute("ancho","50" );
      ((Element)v.get(293)).setAttribute("colorf","" );
      ((Element)v.get(293)).setAttribute("borde","0" );
      ((Element)v.get(293)).setAttribute("imagenf","" );
      ((Element)v.get(293)).setAttribute("repeat","" );
      ((Element)v.get(293)).setAttribute("padding","" );
      ((Element)v.get(293)).setAttribute("visibilidad","visible" );
      ((Element)v.get(293)).setAttribute("contravsb","" );
      ((Element)v.get(293)).setAttribute("x","0" );
      ((Element)v.get(293)).setAttribute("y","606" );
      ((Element)v.get(293)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:14   */


   }

}
