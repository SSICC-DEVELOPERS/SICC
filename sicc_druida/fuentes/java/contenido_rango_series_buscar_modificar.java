
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_rango_series_buscar_modificar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_rango_series_modificar" );
      ((Element)v.get(0)).setAttribute("cod","0598" );
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
      v.add(doc.createTextNode("\r \r\r    function onLoadPag() {\r        ocultarLista();\r        DrdEnsanchaConMargenDcho('listado1',12);\r        eval (ON_RSZ);\r        init();\r        btnProxy(4,0);\r        btnProxy(2,0);\r        btnProxy(1,0);\r        btnProxy(3,1);\r        btnProxy(5,1);\r        btnProxy(6,1);\r        btnProxy(7,1);\r        btnProxy(8,1);\r        btnProxy(9,1);\r        btnProxy(10,1);\r    }\r\r    function init() {\r        configurarMenuSecundario(\"frmContenido\");\r        fMostrarMensajeError();\r        setearValoresPorDefecto();\r        focaliza(\"frmContenido.cbMarca\");\r    }\r\r\r    function ocultarLista() {\r        document.all[\"Cplistado1\"].style.visibility='hidden'; \r        document.all[\"CpLin1listado1\"].style.visibility='hidden' \r        document.all[\"CpLin2listado1\"].style.visibility='hidden' \r        document.all[\"CpLin3listado1\"].style.visibility='hidden' \r        document.all[\"CpLin4listado1\"].style.visibility='hidden'\r        document.all[\"primera1Div\"].style.visibility='hidden';\r        document.all[\"separaDiv\"].style.visibility='hidden';\r        document.all[\"ret1Div\"].style.visibility='hidden'; \r        document.all[\"ava1Div\"].style.visibility='hidden';   \r        document.all[\"ModificarDiv\"].style.visibility='hidden';\r        document.all[\"DetalleDiv\"].style.visibility='hidden'; \r    }\r\r    function mostrarLista(){\r        document.all[\"Cplistado1\"].style.visibility='visible'; \r        document.all[\"CpLin1listado1\"].style.visibility='visible' \r        document.all[\"CpLin2listado1\"].style.visibility='visible' \r        document.all[\"CpLin3listado1\"].style.visibility='visible' \r        document.all[\"CpLin4listado1\"].style.visibility='visible'\r        document.all[\"primera1Div\"].style.visibility='visible';\r        document.all[\"separaDiv\"].style.visibility='visible';\r        document.all[\"ret1Div\"].style.visibility='visible'; \r        document.all[\"ava1Div\"].style.visibility='visible';   \r                    }\r\r/*---------------------------------------------------------------------------*/\r\r    function fLimpiar(){\r        focaliza(\"frmContenido.cbMarca\");\r        setearValoresPorDefecto();\r    }\r    function muestraLista( ultima, rowset){\r        var tamano = rowset.length;\r        if (tamano > 0) {\r            var casoDeUso = get(\"frmContenido.casoDeUso\");\r            if (casoDeUso == 'consultar') {\r                document.all[\"DetalleDiv\"].style.visibility='visible'; \r                document.all[\"ModificarDiv\"].style.visibility='hidden';\r            } else if (casoDeUso == 'modificar') {\r                document.all[\"ModificarDiv\"].style.visibility='visible';\r            } else if( casoDeUso == 'eliminar' ){\r                btnProxy(4,1);\r                document.all[\"DetalleDiv\"].style.visibility='visible'; \r                document.all[\"ModificarDiv\"].style.visibility='hidden';\r            }else {\r                document.all[\"ModificarDiv\"].style.visibility='hidden';\r                document.all[\"DetalleDiv\"].style.visibility='visible'; \r            }\r            mostrarLista();\r            eval (ON_RSZ);\r            focaliza(\"frmContenido.cbMarca\"); \r            return true;\r        } else {\r            btnProxy(4,0);\r            ocultarLista();\r            focaliza(\"frmContenido.cbMarca\"); \r            return false;\r        }\r    }\r\r    function fBorrar() {\r        if (listado1.numSelecc()== 0) {\r            GestionarMensaje('1021',null,null,null);\r            return false;\r        }  \r        eliminarFilas(listado1.codSeleccionados(),\"PREEliminarRangoSerie\", mipgndo);\r    }\r\r    function accionBuscar() {\r        var codigos = listado1.codigos();\r        var longitud = codigos.length;\r        for(var i=0;i<longitud;i++) {\r            listado1.deselecciona(i);    \r        }\r        var menu = get(\"frmContenido.casoDeUso\");\r        if(menu==\"Modificar\"){\r            listado1.maxSel=1;\r            document.all[\"ModificarDiv\"].style.visibility='visible';\r        }\r        if(menu==\"Consultar\"){\r            listado1.maxSel=1;\r        }  \r        configurarPaginado(mipgndo,\"PREBuscarRangoSerie\",\"ConectorBuscarRangoSerie\",\"es.indra.sicc.dtos.pre.DTOEBuscarRangoSerie\", armarArray());\r        listado1.reajusta();\r    }\r\r\r    function armarArray(){\r          var arrDatos = new Array();\r          var i=0;\r          if (get('frmContenido.cbEstrategia')!='') {\r            arrDatos[i] = new Array('oidEstrategia',get('frmContenido.cbEstrategia'));\r            i++;\r          }\r          if (get('frmContenido.cbMarca')!='') {\r            arrDatos[i] = new Array('oidMarca',get('frmContenido.cbMarca'));\r            i++;\r          }\r          if (get('frmContenido.cbCanal')!='') {\r            arrDatos[i] = new Array('oidCanal',get('frmContenido.cbCanal'));\r            i++;         \r          }\r          arrDatos[i] = new Array('oidIdioma',get('frmContenido.varIdioma'));  \r          return arrDatos;\r    }\r\r    function accionModificar() {\r        if (listado1.numSelecc()!= 1) {\r            GestionarMensaje('1022',null,null,null);\r            return false;\r        }\r        var arrAux = new Array();\r        arrAux = listado1.codSeleccionados();\r        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r        var obj = new Object();  \r\r        obj.oidRangoSerie=listado1.datos[posicion][0];\r        obj.varPais=listado1.datos[posicion][1];\r        obj.varEstrategia=listado1.datos[posicion][4];\r        obj.varMarca=listado1.datos[posicion][2];\r        obj.varCanal=listado1.datos[posicion][3];\r        obj.txtNSerDesde=listado1.datos[posicion][5];\r        obj.txtNSerHasta=listado1.datos[posicion][6];\r        obj.casoDeUso = get(\"frmContenido.casoDeUso\");\r\r        mostrarModalSICC('LPMantenimientoRangoSeries','modificar',obj,496,380);\r        accionBuscar();\r    }\r\r    function accionDetalle() {\r        if (listado1.numSelecc()!= 1) {\r            GestionarMensaje('1022',null,null,null);\r            return false;\r        }\r        var arrAux = new Array();\r        arrAux = listado1.codSeleccionados();\r        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r        var obj = new Object();  \r\r        obj.oidRangoSerie=listado1.datos[posicion][0];\r        obj.varPais=listado1.datos[posicion][1];\r        obj.varEstrategia=listado1.datos[posicion][4];\r        obj.varMarca=listado1.datos[posicion][2];\r        obj.varCanal=listado1.datos[posicion][3];\r        obj.txtNSerDesde=listado1.datos[posicion][5];\r        obj.txtNSerHasta=listado1.datos[posicion][6];\r        obj.casoDeUso = get(\"frmContenido.casoDeUso\");\r\r        mostrarModalSICC('LPMantenimientoRangoSeries','Mostrar datos',obj,496,380);\r        accionBuscar();\r    }\r\r    function obtenerPosicionListaEditable(clave, lista) {\r        this.posicion = 0;\r        if (lista.codSeleccionados().length > 0) {\r            for(var k=0;k<lista.datos.length;k++) {\r                if (lista.datos[k][0] == clave) {\r                    posicion=k;\r                    break;\r                }\r            }         \r            return posicion;\r        }\r    }\r\r    function setearValoresPorDefecto(){\r        var array = new Array();\r        array[0] = get('frmContenido.marca');\r        set('frmContenido.cbMarca',array);\r        array[0] = get('frmContenido.canal');\r        set('frmContenido.cbCanal',array);\r    }\r\r  \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","casoDeUso" );
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
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","LPMantenimientoRangoSeries" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","NSerDesde" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidRangoSerie" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","marca" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","canal" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(17)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(17)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(17)).setAttribute("borde","0" );
      ((Element)v.get(17)).setAttribute("imagenf","" );
      ((Element)v.get(17)).setAttribute("repeat","" );
      ((Element)v.get(17)).setAttribute("padding","" );
      ((Element)v.get(17)).setAttribute("visibilidad","" );
      ((Element)v.get(17)).setAttribute("contravsb","" );
      ((Element)v.get(17)).setAttribute("x","0" );
      ((Element)v.get(17)).setAttribute("y","0" );
      ((Element)v.get(17)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(18)).setAttribute("width","100%" );
      ((Element)v.get(18)).setAttribute("border","0" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("cellpadding","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("align","center" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("height","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","750" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","1" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:19   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(31)).setAttribute("class","legend" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(32)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(32)).setAttribute("alto","13" );
      ((Element)v.get(32)).setAttribute("filas","1" );
      ((Element)v.get(32)).setAttribute("valor","Datos de rango" );
      ((Element)v.get(32)).setAttribute("id","legend" );
      ((Element)v.get(32)).setAttribute("cod","0075" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","100%" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","684" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","left" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("colspan","4" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:40 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(44)).setAttribute("nombre","lblPais" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(44)).setAttribute("id","datosTitle" );
      ((Element)v.get(44)).setAttribute("cod","5" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(40)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","25" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("id","datosTitle" );
      ((Element)v.get(48)).setAttribute("cod","6" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","25" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","datosTitle" );
      ((Element)v.get(52)).setAttribute("cod","7" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(40)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:40   */

      /* Empieza nodo:55 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(55));

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
      ((Element)v.get(59)).setAttribute("nombre","lblPaisX" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","datosCampos" );
      ((Element)v.get(59)).setAttribute("codi","5" );
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
      ((Element)v.get(62)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(63)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(63)).setAttribute("id","datosCampos" );
      ((Element)v.get(63)).setAttribute("size","1" );
      ((Element)v.get(63)).setAttribute("multiple","N" );
      ((Element)v.get(63)).setAttribute("req","N" );
      ((Element)v.get(63)).setAttribute("valorinicial","" );
      ((Element)v.get(63)).setAttribute("textoinicial","" );
      ((Element)v.get(63)).setAttribute("onshtab","document.all.btnBuscar.focus();" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:65 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","25" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("nowrap","nowrap" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("valign","top" );
      ((Element)v.get(55)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(68)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(68)).setAttribute("id","datosCampos" );
      ((Element)v.get(68)).setAttribute("size","1" );
      ((Element)v.get(68)).setAttribute("multiple","N" );
      ((Element)v.get(68)).setAttribute("req","N" );
      ((Element)v.get(68)).setAttribute("valorinicial","" );
      ((Element)v.get(68)).setAttribute("textoinicial","" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:70 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","100%" );
      ((Element)v.get(55)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:55   */

      /* Empieza nodo:72 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("colspan","4" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:75 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("table"));
      ((Element)v.get(77)).setAttribute("width","684" );
      ((Element)v.get(77)).setAttribute("border","0" );
      ((Element)v.get(77)).setAttribute("align","left" );
      ((Element)v.get(77)).setAttribute("cellspacing","0" );
      ((Element)v.get(77)).setAttribute("cellpadding","0" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblEstrategia" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","478" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(78)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:78   */

      /* Empieza nodo:85 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(89)).setAttribute("nombre","cbEstrategia" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("size","1" );
      ((Element)v.get(89)).setAttribute("multiple","N" );
      ((Element)v.get(89)).setAttribute("req","N" );
      ((Element)v.get(89)).setAttribute("valorinicial","" );
      ((Element)v.get(89)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:91 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(85)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:85   */

      /* Empieza nodo:93 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("colspan","4" );
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
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:33   */

      /* Empieza nodo:96 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("table"));
      ((Element)v.get(101)).setAttribute("width","100%" );
      ((Element)v.get(101)).setAttribute("border","0" );
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(101)).setAttribute("cellspacing","0" );
      ((Element)v.get(101)).setAttribute("cellpadding","0" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("class","botonera" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(104)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(104)).setAttribute("ID","botonContenido" );
      ((Element)v.get(104)).setAttribute("tipo","html" );
      ((Element)v.get(104)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(104)).setAttribute("estado","false" );
      ((Element)v.get(104)).setAttribute("cod","1" );
      ((Element)v.get(104)).setAttribute("ontab","focaliza('frmContenido.cbMarca');" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:105 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","12" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:96   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:107 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:26   */

      /* Empieza nodo:109 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","12" );
      ((Element)v.get(110)).setAttribute("align","center" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","12" );
      ((Element)v.get(111)).setAttribute("height","12" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","750" );
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","12" );
      ((Element)v.get(109)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","12" );
      ((Element)v.get(115)).setAttribute("height","1" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:109   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:116 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(116)).setAttribute("nombre","listado1" );
      ((Element)v.get(116)).setAttribute("ancho","687" );
      ((Element)v.get(116)).setAttribute("alto","317" );
      ((Element)v.get(116)).setAttribute("x","12" );
      ((Element)v.get(116)).setAttribute("y","162" );
      ((Element)v.get(116)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(116)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(117)).setAttribute("precarga","S" );
      ((Element)v.get(117)).setAttribute("conROver","S" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(118)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(118)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(118)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(118)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 117   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(119)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(119)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(119)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(119)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(117)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 117   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(120)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(120)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(117)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:117   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(116)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(122)).setAttribute("borde","1" );
      ((Element)v.get(122)).setAttribute("horizDatos","1" );
      ((Element)v.get(122)).setAttribute("horizCabecera","1" );
      ((Element)v.get(122)).setAttribute("vertical","1" );
      ((Element)v.get(122)).setAttribute("horizTitulo","1" );
      ((Element)v.get(122)).setAttribute("horizBase","1" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 121   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(123)).setAttribute("borde","#999999" );
      ((Element)v.get(123)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(123)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(123)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(123)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(123)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(123)).setAttribute("horizBase","#999999" );
      ((Element)v.get(121)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:121   */

      /* Empieza nodo:124 / Elemento padre: 116   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(124)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(124)).setAttribute("alto","22" );
      ((Element)v.get(124)).setAttribute("imgFondo","" );
      ((Element)v.get(124)).setAttribute("cod","00135" );
      ((Element)v.get(124)).setAttribute("ID","datosTitle" );
      ((Element)v.get(116)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 116   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(125)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(125)).setAttribute("alto","22" );
      ((Element)v.get(125)).setAttribute("imgFondo","" );
      ((Element)v.get(116)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 116   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(126)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(126)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(126)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(126)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(126)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(126)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(116)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("ancho","100" );
      ((Element)v.get(127)).setAttribute("minimizable","S" );
      ((Element)v.get(127)).setAttribute("minimizada","N" );
      ((Element)v.get(127)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("ancho","100" );
      ((Element)v.get(128)).setAttribute("minimizable","S" );
      ((Element)v.get(128)).setAttribute("minimizada","N" );
      ((Element)v.get(128)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(126)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("ancho","100" );
      ((Element)v.get(129)).setAttribute("minimizable","S" );
      ((Element)v.get(129)).setAttribute("minimizada","N" );
      ((Element)v.get(129)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("ancho","100" );
      ((Element)v.get(130)).setAttribute("minimizable","S" );
      ((Element)v.get(130)).setAttribute("minimizada","N" );
      ((Element)v.get(130)).setAttribute("orden","alfanumerico" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(126)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("ancho","70" );
      ((Element)v.get(131)).setAttribute("minimizable","S" );
      ((Element)v.get(131)).setAttribute("minimizada","N" );
      ((Element)v.get(131)).setAttribute("orden","numerico" );
      ((Element)v.get(126)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 126   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("ancho","70" );
      ((Element)v.get(132)).setAttribute("minimizable","S" );
      ((Element)v.get(132)).setAttribute("minimizada","N" );
      ((Element)v.get(132)).setAttribute("orden","numerico" );
      ((Element)v.get(126)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:126   */

      /* Empieza nodo:133 / Elemento padre: 116   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(133)).setAttribute("alto","20" );
      ((Element)v.get(133)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(133)).setAttribute("imgFondo","" );
      ((Element)v.get(133)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(116)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("colFondo","" );
      ((Element)v.get(134)).setAttribute("ID","EstCab" );
      ((Element)v.get(134)).setAttribute("cod","5" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("colFondo","" );
      ((Element)v.get(135)).setAttribute("ID","EstCab" );
      ((Element)v.get(135)).setAttribute("cod","6" );
      ((Element)v.get(133)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("colFondo","" );
      ((Element)v.get(136)).setAttribute("ID","EstCab" );
      ((Element)v.get(136)).setAttribute("cod","7" );
      ((Element)v.get(133)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("colFondo","" );
      ((Element)v.get(137)).setAttribute("ID","EstCab" );
      ((Element)v.get(137)).setAttribute("cod","478" );
      ((Element)v.get(133)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("colFondo","" );
      ((Element)v.get(138)).setAttribute("ID","EstCab" );
      ((Element)v.get(138)).setAttribute("cod","2091" );
      ((Element)v.get(133)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 133   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("colFondo","" );
      ((Element)v.get(139)).setAttribute("ID","EstCab" );
      ((Element)v.get(139)).setAttribute("cod","2092" );
      ((Element)v.get(133)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:133   */

      /* Empieza nodo:140 / Elemento padre: 116   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(140)).setAttribute("alto","22" );
      ((Element)v.get(140)).setAttribute("accion","" );
      ((Element)v.get(140)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(140)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(140)).setAttribute("maxSel","-1" );
      ((Element)v.get(140)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(140)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(140)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(140)).setAttribute("onLoad","" );
      ((Element)v.get(140)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(116)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("tipo","texto" );
      ((Element)v.get(141)).setAttribute("ID","EstDat" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("tipo","texto" );
      ((Element)v.get(142)).setAttribute("ID","EstDat2" );
      ((Element)v.get(140)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("tipo","texto" );
      ((Element)v.get(143)).setAttribute("ID","EstDat" );
      ((Element)v.get(140)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("tipo","texto" );
      ((Element)v.get(144)).setAttribute("ID","EstDat2" );
      ((Element)v.get(140)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("tipo","texto" );
      ((Element)v.get(145)).setAttribute("ID","EstDat" );
      ((Element)v.get(140)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("tipo","texto" );
      ((Element)v.get(146)).setAttribute("ID","EstDat2" );
      ((Element)v.get(140)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:140   */

      /* Empieza nodo:147 / Elemento padre: 116   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(116)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 116   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(148)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(148)).setAttribute("ancho","687" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(148)).setAttribute("sep","$" );
      ((Element)v.get(148)).setAttribute("x","12" );
      ((Element)v.get(148)).setAttribute("class","botonera" );
      ((Element)v.get(148)).setAttribute("y","456" );
      ((Element)v.get(148)).setAttribute("control","|" );
      ((Element)v.get(148)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(148)).setAttribute("rowset","" );
      ((Element)v.get(148)).setAttribute("cargainicial","N" );
      ((Element)v.get(148)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(116)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(149)).setAttribute("nombre","ret1" );
      ((Element)v.get(149)).setAttribute("x","37" );
      ((Element)v.get(149)).setAttribute("y","460" );
      ((Element)v.get(149)).setAttribute("ID","botonContenido" );
      ((Element)v.get(149)).setAttribute("img","retroceder_on" );
      ((Element)v.get(149)).setAttribute("tipo","0" );
      ((Element)v.get(149)).setAttribute("estado","false" );
      ((Element)v.get(149)).setAttribute("alt","" );
      ((Element)v.get(149)).setAttribute("codigo","" );
      ((Element)v.get(149)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 148   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(150)).setAttribute("nombre","ava1" );
      ((Element)v.get(150)).setAttribute("x","52" );
      ((Element)v.get(150)).setAttribute("y","460" );
      ((Element)v.get(150)).setAttribute("ID","botonContenido" );
      ((Element)v.get(150)).setAttribute("img","avanzar_on" );
      ((Element)v.get(150)).setAttribute("tipo","0" );
      ((Element)v.get(150)).setAttribute("estado","false" );
      ((Element)v.get(150)).setAttribute("alt","" );
      ((Element)v.get(150)).setAttribute("codigo","" );
      ((Element)v.get(150)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(148)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:148   */
      /* Termina nodo:116   */

      /* Empieza nodo:151 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(151)).setAttribute("nombre","primera1" );
      ((Element)v.get(151)).setAttribute("x","20" );
      ((Element)v.get(151)).setAttribute("y","460" );
      ((Element)v.get(151)).setAttribute("ID","botonContenido" );
      ((Element)v.get(151)).setAttribute("img","primera_on" );
      ((Element)v.get(151)).setAttribute("tipo","-2" );
      ((Element)v.get(151)).setAttribute("estado","false" );
      ((Element)v.get(151)).setAttribute("alt","" );
      ((Element)v.get(151)).setAttribute("codigo","" );
      ((Element)v.get(151)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(152)).setAttribute("nombre","separa" );
      ((Element)v.get(152)).setAttribute("x","59" );
      ((Element)v.get(152)).setAttribute("y","456" );
      ((Element)v.get(152)).setAttribute("ID","botonContenido" );
      ((Element)v.get(152)).setAttribute("img","separa_base" );
      ((Element)v.get(152)).setAttribute("tipo","0" );
      ((Element)v.get(152)).setAttribute("estado","false" );
      ((Element)v.get(152)).setAttribute("alt","" );
      ((Element)v.get(152)).setAttribute("codigo","" );
      ((Element)v.get(152)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(153)).setAttribute("nombre","Modificar" );
      ((Element)v.get(153)).setAttribute("x","80" );
      ((Element)v.get(153)).setAttribute("y","457" );
      ((Element)v.get(153)).setAttribute("ID","botonContenido" );
      ((Element)v.get(153)).setAttribute("tipo","html" );
      ((Element)v.get(153)).setAttribute("estado","false" );
      ((Element)v.get(153)).setAttribute("cod","2" );
      ((Element)v.get(153)).setAttribute("accion","accionModificar();" );
      ((Element)v.get(6)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(154)).setAttribute("nombre","Detalle" );
      ((Element)v.get(154)).setAttribute("x","80" );
      ((Element)v.get(154)).setAttribute("y","457" );
      ((Element)v.get(154)).setAttribute("ID","botonContenido" );
      ((Element)v.get(154)).setAttribute("tipo","html" );
      ((Element)v.get(154)).setAttribute("estado","false" );
      ((Element)v.get(154)).setAttribute("cod","3" );
      ((Element)v.get(154)).setAttribute("accion","accionDetalle();" );
      ((Element)v.get(6)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(155)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(155)).setAttribute("alto","12" );
      ((Element)v.get(155)).setAttribute("ancho","50" );
      ((Element)v.get(155)).setAttribute("colorf","" );
      ((Element)v.get(155)).setAttribute("borde","0" );
      ((Element)v.get(155)).setAttribute("imagenf","" );
      ((Element)v.get(155)).setAttribute("repeat","" );
      ((Element)v.get(155)).setAttribute("padding","" );
      ((Element)v.get(155)).setAttribute("visibilidad","visible" );
      ((Element)v.get(155)).setAttribute("contravsb","" );
      ((Element)v.get(155)).setAttribute("x","0" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(155)).setAttribute("y","479" );
      ((Element)v.get(155)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:6   */


   }

}
