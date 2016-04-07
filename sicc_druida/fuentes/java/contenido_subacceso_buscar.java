
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_subacceso_buscar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_subacceso_modificar" );
      ((Element)v.get(0)).setAttribute("cod","038" );
      ((Element)v.get(0)).setAttribute("titulo","Modificar subacceso" );
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
      ((Element)v.get(2)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r\r   \r\r  var varNoLimpiarSICC = true;\r\r  function onLoadPag()   {\r  \r    DrdEnsanchaConMargenDcho('listado1',12);\r    eval (ON_RSZ);  \r\r    ocultarLista();\r    \r    configurarMenuSecundario(\"frmModificarSubacceso\");\r\r    configurarPagina();\r/* ------------------------------------------------------------    \r    if (document.all.tblDatlistado1) {\r     \r        document.all.CpScrolllistado1.attachEvent ('onpropertychange', verificaResultados);\r    }\r----------------------------------------------------------*/\r    focaliza('frmModificarSubacceso.txtCodigoSubacceso');\r    accion('frmModificarSubacceso.cbCodigoAcceso','.disabled=true');\r    \r   }\r\r   function fLimpiar(){\r\r        limpiar();\r        inicializarComboCanal();\r        \r        var arr = new Array();\r        arr[arr.length]=new Array(\"oid\", get(\"frmModificarSubacceso.cbCodigoCanal\"));\r        arr[arr.length]=new Array(\"oidIdioma\", get('frmModificarSubacceso.hidOidIdioma'));\r\r        set_combo('frmModificarSubacceso.cbCodigoAcceso', arr, []);  \r\r                        accion('frmModificarSubacceso.cbCodigoAcceso','.disabled=true');\r        focaliza('frmModificarSubacceso.txtCodigoSubacceso');\r   }\r   function setearyposicionarcbacceso(datos){\r                              set_combo('frmModificarSubacceso.cbCodigoAcceso',datos, []);\r          if (get('frmModificarSubacceso.hidAccesoPrevio')!=''){\r                        iSeleccionadob = new Array();         \r            iSeleccionadob[0] = get('frmModificarSubacceso.hidAccesoPrevio');      \r            set('frmModificarSubacceso.cbCodigoAcceso',iSeleccionadob);       \r          }\r   }\r\r/*---------------------------------------------------------------------------*/\r\rfunction ocultaCapas(){\r        document.all[\"Cplistado1\"].style.visibility='hidden';\r        document.all[\"CpLin1listado1\"].style.visibility='hidden';\r        document.all[\"CpLin2listado1\"].style.visibility='hidden';\r        document.all[\"CpLin3listado1\"].style.visibility='hidden';\r        document.all[\"CpLin4listado1\"].style.visibility='hidden';\r        document.all[\"primera1Div\"].style.visibility='hidden';\r        document.all[\"ret1Div\"].style.visibility='hidden';\r        document.all[\"ava1Div\"].style.visibility='hidden';\r                document.all[\"DetalleDiv\"].style.visibility='hidden';\r        document.all[\"ModificarDiv\"].style.visibility='hidden';\r\r}\r\r\rfunction muestraCapas(){\r        document.all[\"Cplistado1\"].style.visibility='';\r        document.all[\"CpLin1listado1\"].style.visibility='';\r        document.all[\"CpLin2listado1\"].style.visibility='';\r        document.all[\"CpLin3listado1\"].style.visibility='';\r        document.all[\"CpLin4listado1\"].style.visibility='';\r        document.all[\"primera1Div\"].style.visibility='';\r        document.all[\"ret1Div\"].style.visibility='';\r        document.all[\"ava1Div\"].style.visibility='';\r        \r\r        \r        \r}\r  function muestraLista( ultima, rowset, error){\r                    var tamano = rowset.length;\r                    if (tamano > 0) {\r					\r				                    var casoDeUso = get(\"frmModificarSubacceso.casoDeUso\");\r                    if (casoDeUso == 'consultar') {\r								                              document.all[\"DetalleDiv\"].style.visibility='';         \r                              document.all[\"ModificarDiv\"].style.visibility='hidden';\r\r                    } else {\r						if (casoDeUso == 'modificar') {\r                                        document.all[\"DetalleDiv\"].style.visibility='hidden';          \r                                         document.all[\"ModificarDiv\"].style.visibility='';\r                              } else if( casoDeUso == 'eliminar' ){\r																					                	btnProxy(4, '1');\r                                        document.all[\"DetalleDiv\"].style.visibility='';        \r                                         document.all[\"ModificarDiv\"].style.visibility='hidden';\r                              }else {\r                                         document.all[\"DetalleDiv\"].style.visibility='hidden';          \r                                         document.all[\"ModificarDiv\"].style.visibility='hidden';\r                              }\r                    }\r\r                              muestraCapas();\r                              eval (ON_RSZ);\r								                	\r                                             focaliza(\"frmModificarSubacceso.txtCodigoSubacceso\"); \r                              return true;\r                    } else {\r											  btnProxy(4, '0');\r                      ocultaCapas();\r\r        focaliza(\"frmModificarSubacceso.txtCodigoSubacceso\"); \r                      cdos_mostrarAlert(error);\r                      return false;\r                     }\r  }\r\r/*-----------------------------------------------------------------------------------------------------*/\r\r   function limpiar(){\r\r      set('frmModificarSubacceso.txtCodigoSubacceso','');\r      set('frmModificarSubacceso.txtDescripcionSubacceso','');\r        \r   }\r\r   function configurarPagina()   {\r      if (get('frmModificarSubacceso.hmultiselec')=='false'){         \r          listado1.maxSel = 1;\r	    } else {\r          listado1.maxSel = -1;\r	    }\r\r      inicializarComboCanal();\r      inicializarComboAcceso();\r          \r   }\r\r   function inicializarComboCanal(){\r            iSeleccionado = new Array();         \r	    iSeleccionado[0] = get('frmModificarSubacceso.hidCanalPrevio');	       \r      set('frmModificarSubacceso.cbCodigoCanal',iSeleccionado);      \r   }\r   function inicializarComboAcceso(){\r      if (get('frmModificarSubacceso.hidAccesoPrevio')!=''){\r        iSeleccionadob = new Array();         \r        iSeleccionadob[0] = get('frmModificarSubacceso.hidAccesoPrevio');      \r        set('frmModificarSubacceso.cbCodigoAcceso',iSeleccionadob);\r      }   \r   }\r   \r   function modificar(){\r      if (listado1.numSelecc() >= 1){\r          if (listado1.numSelecc() == 1){                       		\r              var parametros = new Object();\r              parametros.hidOidSubacceso = listado1.codSeleccionados();\r               \r               \r              var res = mostrarModalSICC(\"LPMantenimientoSubacceso\", \"modificar\", parametros, 620, 200);\r\r              if (res=='guardo')\r                  buscar();\r                        }else{\r              GestionarMensaje('8',null,null,null);\r          }\r      }else{\r          GestionarMensaje('4',null,null,null);			\r      }	 \r    }\r    function buscar() {\r                ocultarLista();\r		btnProxy(4, '0');\r    \r		configurarPaginado(mipgndo,\"SEGBuscarSubaccesos\",\r              \"conectorBusquedaSubaccesos\",\r              \"es.indra.sicc.dtos.seg.DTOEBuscarSubaccesos\",\r              armaArray());\r        \r    }\r    \r    function armaArray(){\r      var arrDatos = new Array();\r      var i=0;\r\r      if (get('frmModificarSubacceso.txtCodigoSubacceso')!=''){\r          arrDatos[i] = new Array('codigoSubacceso',get('frmModificarSubacceso.txtCodigoSubacceso'));\r          i++;\r      }\r      if (get('frmModificarSubacceso.txtDescripcionSubacceso')!=''){\r            arrDatos[i] = new Array('descripcionSubacceso',get('frmModificarSubacceso.txtDescripcionSubacceso'));\r            i++;\r      }\r      if (get('frmModificarSubacceso.cbCodigoCanal')!=''){\r            arrDatos[i] = new Array('oidCanal',get('frmModificarSubacceso.cbCodigoCanal'));\r            i++;\r      }\r      if (get('frmModificarSubacceso.cbCodigoAcceso')!=''){\r            arrDatos[i] = new Array('oidAcceso',get('frmModificarSubacceso.cbCodigoAcceso'));\r            i++;\r      }\r      if (get('frmModificarSubacceso.hidOidIdioma')!=''){\r            arrDatos[i] = new Array('oidIdioma',get('frmModificarSubacceso.hidOidIdioma'));\r            i++;\r      }      \r      return arrDatos;      \r  }\r  function detalle(){\r        \r        if (listado1.numSelecc() >= 1){\r          if (listado1.numSelecc() == 1){                         \r              set('frmModificarSubacceso.accion','detalle');\r              var parametros = new Object();  \r              parametros.hidOidSubacceso = listado1.codSeleccionados();\r              parametros.hCasoDetalle = get('frmModificarSubacceso.casoDeUso');\r              mostrarModalSICC(\"LPMantenimientoSubacceso\", \"detalle\", parametros, 620, 200);\r                        }else{\r              GestionarMensaje('8',null,null,null);\r          }\r      }else{\r          GestionarMensaje('4',null,null,null);			\r      }	               \r  }\r  function eliminar(){\r    if (listado1.numSelecc() >= 1){\r        var oids = listado1.codSeleccionados();\r                eliminarFilas(oids,\"SEGEliminarSubaccesos\",mipgndo);\r    }else{\r        GestionarMensaje('4',null,null,null);			\r    }	 \r  }\r  function canalOnChange(){\r    if (get(\"frmModificarSubacceso.cbCodigoCanal\")==''){\r        accion('frmModificarSubacceso.cbCodigoAcceso','.disabled=true');    \r        set_combo('frmModificarSubacceso.cbCodigoAcceso',['','']);        \r    } else {\r        accion('frmModificarSubacceso.cbCodigoAcceso','.disabled=false');\r        var arr = new Array();\r        arr[arr.length]=new Array(\"oid\", get(\"frmModificarSubacceso.cbCodigoCanal\"));\r        arr[arr.length]=new Array(\"oidIdioma\", get('frmModificarSubacceso.hidOidIdioma'));\r        recargaCombo('frmModificarSubacceso.cbCodigoAcceso', 'SEGObtenerAccesosSinFiltro', \"es.indra.sicc.util.DTOOID\",arr);\r    }  \r  }\r  function fBorrar(){\r    eliminar();\r  }\r  function focalizaBotonShtab() {\r      if (document.all.Cplistado1.style.visibility != \"hidden\")\r          if (get('frmModificarSubacceso.casoDeUso')=='consultar'||get('frmModificarSubacceso.casoDeUso')=='eliminar')      \r              document.all.Detalle.focus();\r          else\r              document.all.Modificar.focus();\r      else\r          document.all.btnBuscar.focus();\r  }\r  function focalizatabtnbuscar() {\r      if (document.all.Cplistado1.style.visibility != \"hidden\")\r          if (get('frmModificarSubacceso.casoDeUso')=='consultar'||get('frmModificarSubacceso.casoDeUso')=='eliminar')          \r              document.all.Detalle.focus();\r          else\r              document.all.Modificar.focus();\r      else\r          focaliza('frmModificarSubacceso.txtCodigoSubacceso');\r  }  \r\r    function verificaResultados() {\r      if (event.propertyName == \"innerHTML\") {\r          alert(\"estoy en verificaResultados: \" + listado1.datos.length);\r          if (listado1.datos.length > 0) {\r              if (document.all[\"Cplistado1\"].style.visibility == 'hidden')\r                  mostrarLista();\r              if (get('frmModificarSubacceso.casoDeUso') ==\"eliminar\")\r                	btnProxy(4, '1');\r     /*         if (get('frmModificarSubacceso.hdetalle')=='true'){\r                  document.all[\"DetalleDiv\"].style.visibility='visible';                  \r              } else {\r                  document.all[\"DetalleDiv\"].style.visibility='hidden';\r              }*/\r              if (get('frmModificarSubacceso.hmodificar')=='true'){\r                  document.all[\"ModificarDiv\"].style.visibility='visible';\r              } else {\r                  document.all[\"ModificarDiv\"].style.visibility='hidden';\r              } \r          } else {\r              if (get('frmModificarSubacceso.casoDeUso') ==\"eliminar\")\r                	btnProxy(4, '0');\r\r          }\r      }\r  }\r  \r  function ocultarLista() {\r        document.all[\"Cplistado1\"].style.visibility='hidden';\r        document.all[\"CpLin1listado1\"].style.visibility='hidden';\r        document.all[\"CpLin2listado1\"].style.visibility='hidden';\r        document.all[\"CpLin3listado1\"].style.visibility='hidden';\r        document.all[\"CpLin4listado1\"].style.visibility='hidden';\r        document.all[\"primera1Div\"].style.visibility='hidden';\r        document.all[\"ret1Div\"].style.visibility='hidden';\r        document.all[\"ava1Div\"].style.visibility='hidden';\r                document.all[\"DetalleDiv\"].style.visibility='hidden';\r        document.all[\"ModificarDiv\"].style.visibility='hidden';\r    }\r\r    function mostrarLista() {\r        document.all[\"Cplistado1\"].style.visibility='';\r        document.all[\"CpLin1listado1\"].style.visibility='';\r        document.all[\"CpLin2listado1\"].style.visibility='';\r        document.all[\"CpLin3listado1\"].style.visibility='';\r        document.all[\"CpLin4listado1\"].style.visibility='';\r        document.all[\"primera1Div\"].style.visibility='';\r        document.all[\"ret1Div\"].style.visibility='';\r        document.all[\"ava1Div\"].style.visibility='';\r               \r        \r        \r    }\r   \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","frmModificarSubacceso" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","LPMantenimientoSubacceso" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hmultiselec" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hdetalle" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hCasoDetalle" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hmodificar" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidOidSubacceso" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidOidIdioma" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidCanalPrevio" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidAccesoPrevio" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(21)).setAttribute("width","100%" );
      ((Element)v.get(21)).setAttribute("border","0" );
      ((Element)v.get(21)).setAttribute("cellspacing","0" );
      ((Element)v.get(21)).setAttribute("cellpadding","0" );
      ((Element)v.get(7)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("align","center" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","750" );
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","1" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:22   */

      /* Empieza nodo:29 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(34)).setAttribute("class","legend" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(35)).setAttribute("alto","13" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(35)).setAttribute("id","legend" );
      ((Element)v.get(35)).setAttribute("cod","0075" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","743" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("align","left" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("colspan","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:43 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","31" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","25" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblDescripcionSubacceso" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","9" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","25" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(55)).setAttribute("nombre","lblCanales" );
      ((Element)v.get(55)).setAttribute("alto","13" );
      ((Element)v.get(55)).setAttribute("filas","1" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(55)).setAttribute("id","datosTitle" );
      ((Element)v.get(55)).setAttribute("cod","7" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","25" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(59)).setAttribute("nombre","lblAccesos" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","datosTitle" );
      ((Element)v.get(59)).setAttribute("cod","10" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(43)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:43   */

      /* Empieza nodo:62 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(66)).setAttribute("nombre","txtCodigoSubacceso" );
      ((Element)v.get(66)).setAttribute("id","datosCampos" );
      ((Element)v.get(66)).setAttribute("max","3" );
      ((Element)v.get(66)).setAttribute("tipo","" );
      ((Element)v.get(66)).setAttribute("onchange","" );
      ((Element)v.get(66)).setAttribute("req","N" );
      ((Element)v.get(66)).setAttribute("size","3" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("validacion","" );
      ((Element)v.get(66)).setAttribute("onshtab","focalizaBotonShtab();" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","25" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 62   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(70)).setAttribute("nombre","txtDescripcionSubacceso" );
      ((Element)v.get(70)).setAttribute("id","datosCampos" );
      ((Element)v.get(70)).setAttribute("max","30" );
      ((Element)v.get(70)).setAttribute("tipo","" );
      ((Element)v.get(70)).setAttribute("onchange","" );
      ((Element)v.get(70)).setAttribute("req","N" );
      ((Element)v.get(70)).setAttribute("size","30" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(70)).setAttribute("validacion","" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(74)).setAttribute("nombre","cbCodigoCanal" );
      ((Element)v.get(74)).setAttribute("id","datosCampos" );
      ((Element)v.get(74)).setAttribute("size","1" );
      ((Element)v.get(74)).setAttribute("multiple","N" );
      ((Element)v.get(74)).setAttribute("req","N" );
      ((Element)v.get(74)).setAttribute("valorinicial","" );
      ((Element)v.get(74)).setAttribute("textoinicial","" );
      ((Element)v.get(74)).setAttribute("onchange","canalOnChange();" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:76 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","25" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(79)).setAttribute("nombre","cbCodigoAcceso" );
      ((Element)v.get(79)).setAttribute("id","datosCampos" );
      ((Element)v.get(79)).setAttribute("size","1" );
      ((Element)v.get(79)).setAttribute("multiple","N" );
      ((Element)v.get(79)).setAttribute("req","N" );
      ((Element)v.get(79)).setAttribute("valorinicial","" );
      ((Element)v.get(79)).setAttribute("textoinicial","" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:81 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(62)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:62   */

      /* Empieza nodo:83 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("colspan","9" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:86 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:29   */

      /* Empieza nodo:88 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("table"));
      ((Element)v.get(93)).setAttribute("width","100%" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).setAttribute("border","0" );
      ((Element)v.get(93)).setAttribute("align","center" );
      ((Element)v.get(93)).setAttribute("cellspacing","0" );
      ((Element)v.get(93)).setAttribute("cellpadding","0" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("class","botonera" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(96)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(96)).setAttribute("ID","botonContenido" );
      ((Element)v.get(96)).setAttribute("tipo","html" );
      ((Element)v.get(96)).setAttribute("accion","buscar();" );
      ((Element)v.get(96)).setAttribute("estado","false" );
      ((Element)v.get(96)).setAttribute("cod","1" );
      ((Element)v.get(96)).setAttribute("ontab","focalizatabtnbuscar();" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:97 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","12" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:88   */

      /* Empieza nodo:99 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("width","12" );
      ((Element)v.get(100)).setAttribute("align","center" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("height","12" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","756" );
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","12" );
      ((Element)v.get(99)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","12" );
      ((Element)v.get(105)).setAttribute("height","1" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:99   */
      /* Termina nodo:21   */

      /* Empieza nodo:106 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(106)).setAttribute("nombre","listado1" );
      ((Element)v.get(106)).setAttribute("ancho","747" );
      ((Element)v.get(106)).setAttribute("alto","317" );
      ((Element)v.get(106)).setAttribute("x","12" );
      ((Element)v.get(106)).setAttribute("y","124" );
      ((Element)v.get(106)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(106)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(107)).setAttribute("precarga","S" );
      ((Element)v.get(107)).setAttribute("conROver","S" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(108)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(108)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(108)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(108)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 107   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(109)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(109)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(109)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(109)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(107)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(110)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(110)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(107)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:107   */

      /* Empieza nodo:111 / Elemento padre: 106   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(106)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(112)).setAttribute("borde","1" );
      ((Element)v.get(112)).setAttribute("horizDatos","1" );
      ((Element)v.get(112)).setAttribute("horizCabecera","1" );
      ((Element)v.get(112)).setAttribute("vertical","1" );
      ((Element)v.get(112)).setAttribute("horizTitulo","1" );
      ((Element)v.get(112)).setAttribute("horizBase","1" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 111   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(113)).setAttribute("borde","#999999" );
      ((Element)v.get(113)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(113)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(113)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(113)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(113)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(113)).setAttribute("horizBase","#999999" );
      ((Element)v.get(111)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:111   */

      /* Empieza nodo:114 / Elemento padre: 106   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(114)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(114)).setAttribute("alto","22" );
      ((Element)v.get(114)).setAttribute("imgFondo","" );
      ((Element)v.get(114)).setAttribute("cod","00135" );
      ((Element)v.get(114)).setAttribute("ID","datosTitle" );
      ((Element)v.get(106)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 106   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(115)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(115)).setAttribute("alto","22" );
      ((Element)v.get(115)).setAttribute("imgFondo","" );
      ((Element)v.get(106)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 106   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(116)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(116)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(116)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(116)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(116)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(116)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(106)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("ancho","40" );
      ((Element)v.get(117)).setAttribute("minimizable","S" );
      ((Element)v.get(117)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("ancho","50" );
      ((Element)v.get(118)).setAttribute("minimizable","S" );
      ((Element)v.get(118)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("ancho","30" );
      ((Element)v.get(119)).setAttribute("minimizable","S" );
      ((Element)v.get(119)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 116   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("ancho","30" );
      ((Element)v.get(120)).setAttribute("minimizable","S" );
      ((Element)v.get(120)).setAttribute("minimizada","N" );
      ((Element)v.get(116)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:116   */

      /* Empieza nodo:121 / Elemento padre: 106   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(121)).setAttribute("alto","20" );
      ((Element)v.get(121)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(121)).setAttribute("imgFondo","" );
      ((Element)v.get(121)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(106)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("colFondo","" );
      ((Element)v.get(122)).setAttribute("ID","EstCab" );
      ((Element)v.get(122)).setAttribute("align","center" );
      ((Element)v.get(122)).setAttribute("cod","31" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Elemento padre:122 / Elemento actual: 123   */
      v.add(doc.createTextNode("Cód. subacceso"));
      ((Element)v.get(122)).appendChild((Text)v.get(123));

      /* Termina nodo Texto:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("colFondo","" );
      ((Element)v.get(124)).setAttribute("ID","EstCab" );
      ((Element)v.get(124)).setAttribute("cod","9" );
      ((Element)v.get(121)).appendChild((Element)v.get(124));

      /* Elemento padre:124 / Elemento actual: 125   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(124)).appendChild((Text)v.get(125));

      /* Termina nodo Texto:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("colFondo","" );
      ((Element)v.get(126)).setAttribute("ID","EstCab" );
      ((Element)v.get(126)).setAttribute("cod","7" );
      ((Element)v.get(121)).appendChild((Element)v.get(126));

      /* Elemento padre:126 / Elemento actual: 127   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(126)).appendChild((Text)v.get(127));

      /* Termina nodo Texto:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 121   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("colFondo","" );
      ((Element)v.get(128)).setAttribute("ID","EstCab" );
      ((Element)v.get(128)).setAttribute("cod","10" );
      ((Element)v.get(121)).appendChild((Element)v.get(128));

      /* Elemento padre:128 / Elemento actual: 129   */
      v.add(doc.createTextNode("Acceso"));
      ((Element)v.get(128)).appendChild((Text)v.get(129));

      /* Termina nodo Texto:129   */
      /* Termina nodo:128   */
      /* Termina nodo:121   */

      /* Empieza nodo:130 / Elemento padre: 106   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(130)).setAttribute("alto","22" );
      ((Element)v.get(130)).setAttribute("accion","" );
      ((Element)v.get(130)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(130)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(130)).setAttribute("maxSel","-1" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(130)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(130)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(130)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(130)).setAttribute("onLoad","" );
      ((Element)v.get(130)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(106)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("tipo","texto" );
      ((Element)v.get(131)).setAttribute("ID","EstDat" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 130   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("tipo","texto" );
      ((Element)v.get(132)).setAttribute("ID","EstDat2" );
      ((Element)v.get(130)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("tipo","texto" );
      ((Element)v.get(133)).setAttribute("ID","EstDat" );
      ((Element)v.get(130)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 130   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("tipo","texto" );
      ((Element)v.get(134)).setAttribute("ID","EstDat2" );
      ((Element)v.get(130)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:130   */

      /* Empieza nodo:135 / Elemento padre: 106   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(106)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 106   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(136)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(136)).setAttribute("ancho","747" );
      ((Element)v.get(136)).setAttribute("sep","$" );
      ((Element)v.get(136)).setAttribute("x","12" );
      ((Element)v.get(136)).setAttribute("class","botonera" );
      ((Element)v.get(136)).setAttribute("y","418" );
      ((Element)v.get(136)).setAttribute("control","|" );
      ((Element)v.get(136)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(136)).setAttribute("rowset","" );
      ((Element)v.get(136)).setAttribute("cargainicial","N" );
      ((Element)v.get(136)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(106)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(137)).setAttribute("nombre","ret1" );
      ((Element)v.get(137)).setAttribute("x","37" );
      ((Element)v.get(137)).setAttribute("y","422" );
      ((Element)v.get(137)).setAttribute("ID","botonContenido" );
      ((Element)v.get(137)).setAttribute("img","retroceder_on" );
      ((Element)v.get(137)).setAttribute("tipo","0" );
      ((Element)v.get(137)).setAttribute("estado","false" );
      ((Element)v.get(137)).setAttribute("alt","" );
      ((Element)v.get(137)).setAttribute("codigo","" );
      ((Element)v.get(137)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 136   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(138)).setAttribute("nombre","ava1" );
      ((Element)v.get(138)).setAttribute("x","52" );
      ((Element)v.get(138)).setAttribute("y","422" );
      ((Element)v.get(138)).setAttribute("ID","botonContenido" );
      ((Element)v.get(138)).setAttribute("img","avanzar_on" );
      ((Element)v.get(138)).setAttribute("tipo","0" );
      ((Element)v.get(138)).setAttribute("estado","false" );
      ((Element)v.get(138)).setAttribute("alt","" );
      ((Element)v.get(138)).setAttribute("codigo","" );
      ((Element)v.get(138)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(136)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:136   */
      /* Termina nodo:106   */

      /* Empieza nodo:139 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(139)).setAttribute("nombre","primera1" );
      ((Element)v.get(139)).setAttribute("x","20" );
      ((Element)v.get(139)).setAttribute("y","422" );
      ((Element)v.get(139)).setAttribute("ID","botonContenido" );
      ((Element)v.get(139)).setAttribute("img","primera_on" );
      ((Element)v.get(139)).setAttribute("tipo","-2" );
      ((Element)v.get(139)).setAttribute("estado","false" );
      ((Element)v.get(139)).setAttribute("alt","" );
      ((Element)v.get(139)).setAttribute("codigo","" );
      ((Element)v.get(139)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(140)).setAttribute("nombre","Modificar" );
      ((Element)v.get(140)).setAttribute("x","80" );
      ((Element)v.get(140)).setAttribute("y","419" );
      ((Element)v.get(140)).setAttribute("ID","botonContenido" );
      ((Element)v.get(140)).setAttribute("tipo","html" );
      ((Element)v.get(140)).setAttribute("estado","false" );
      ((Element)v.get(140)).setAttribute("cod","2" );
      ((Element)v.get(140)).setAttribute("accion","modificar();" );
      ((Element)v.get(140)).setAttribute("ontab","focaliza('frmModificarSubacceso.txtCodigoSubacceso');" );
      ((Element)v.get(140)).setAttribute("onshtab","document.all.btnBuscar.focus();" );
      ((Element)v.get(7)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(141)).setAttribute("nombre","Detalle" );
      ((Element)v.get(141)).setAttribute("x","80" );
      ((Element)v.get(141)).setAttribute("y","419" );
      ((Element)v.get(141)).setAttribute("ID","botonContenido" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(141)).setAttribute("tipo","html" );
      ((Element)v.get(141)).setAttribute("estado","false" );
      ((Element)v.get(141)).setAttribute("cod","3" );
      ((Element)v.get(141)).setAttribute("accion","detalle();" );
      ((Element)v.get(141)).setAttribute("ontab","focaliza('frmModificarSubacceso.txtCodigoSubacceso');" );
      ((Element)v.get(141)).setAttribute("onshtab","document.all.btnBuscar.focus();" );
      ((Element)v.get(7)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(142)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(142)).setAttribute("alto","12" );
      ((Element)v.get(142)).setAttribute("ancho","100%" );
      ((Element)v.get(142)).setAttribute("colorf","" );
      ((Element)v.get(142)).setAttribute("borde","0" );
      ((Element)v.get(142)).setAttribute("imagenf","" );
      ((Element)v.get(142)).setAttribute("repeat","" );
      ((Element)v.get(142)).setAttribute("padding","" );
      ((Element)v.get(142)).setAttribute("visibilidad","visible" );
      ((Element)v.get(142)).setAttribute("contravsb","" );
      ((Element)v.get(142)).setAttribute("x","0" );
      ((Element)v.get(142)).setAttribute("y","441" );
      ((Element)v.get(142)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:7   */


   }

}
