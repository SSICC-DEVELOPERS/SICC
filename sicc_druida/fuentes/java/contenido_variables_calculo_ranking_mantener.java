
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_variables_calculo_ranking_mantener  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_variables_calculo_ranking_mantener" );
      ((Element)v.get(0)).setAttribute("cod","0702" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","pestanyas_concurso_ranking_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","sicc_util.js" );
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
      v.add(doc.createTextNode("    \r  \r   function onLoadPag(){\r   \r      configurarMenuSecundario('formulario');\r      DrdEnsanchaConMargenDcho('listado1',12); \r      \r      document.all[\"Cplistado1\"].style.visibility=''; \r      document.all[\"CpLin1listado1\"].style.visibility='';  \r      document.all[\"CpLin2listado1\"].style.visibility=''; \r      document.all[\"CpLin3listado1\"].style.visibility='';\r      document.all[\"CpLin4listado1\"].style.visibility=''; \r\r      document.all[\"primera1Div\"].style.visibility='hidden'; \r      document.all[\"ret1Div\"].style.visibility='hidden';\r      document.all[\"ava1Div\"].style.visibility='hidden';  \r      document.all[\"separaDiv\"].style.visibility='hidden'; \r      document.all[\"btnEliminarDiv\"].style.visibility=''; \r      eval(ON_RSZ);\r      \r      setearHabilitacion();\r\r	  finCargaPagina=true;\r      \r      \r      if(get(\"formulario.opcionMenu\") == \"Consultar Concurso Ranking\"){\r          accion('formulario.cbVariableVentas','.disabled=true');\r          accion('formulario.ckAplicable','.disabled=true');\r          accion('formulario.txtPeso','.disabled=true');\r          accion('formulario.txtDivisor','.disabled=true');\r          deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');\r          deshabilitarHabilitarBoton('botonContenido','btnEliminar','D');\r      }\r      \r      focaliza('formulario.cbVariableVentas');\r    }\r    \r    function setearHabilitacion(){\r        if (get('formulario.habilitarcbVariableVentas')=='N') {\r          accion('formulario.cbVariableVentas','.disabled=true');\r        }\r        if (get('formulario.habilitarckAplicable')=='N') {\r          accion('formulario.ckAplicable','.disabled=true');\r        }\r        if (get('formulario.habilitartxtPeso')=='N') {\r          accion('formulario.txtPeso','.disabled=true');\r        }\r        if (get('formulario.habilitartxtDivisor')=='N') {\r          accion('formulario.txtDivisor','.disabled=true');\r        }\r        if (get('formulario.habilitartxtNumDiasCobro')=='N') {\r          accion('formulario.txtNumDiasCobro','.disabled=true');\r        }\r        if (get('formulario.habilitarbtnAnadir')=='N') {\r          document.all[\"btnAnadirDiv\"].style.visibility='hidden'\r        }\r        if (get('formulario.habilitarbtnEliminar')=='N') {\r          document.all[\"btnEliminarDiv\"].style.visibility='hidden';\r        }        \r    }\r    \r    function comprobarDatosObligatorios(){\r                var cantElementos = listado1.codigos();\r        \r        var listadoSeleccionado = listado1string();\r        set('formulario.listado1STR', listadoSeleccionado);\r        \r        if(cantElementos!=0) {\r            return true;\r        } else{\r            return false;\r        }        \r		}\r    \r    function onChangeVariableVentas(){\r    \r        if (get('formulario.cbVariableVentas')==get('formulario.oidVarVtaRankPorcCobr')){\r            accion('formulario.txtNumDiasCobro','.disabled=false');\r        } else {\r            if (get('formulario.txtNumDiasCobro')!=''){\r                set('formulario.txtNumDiasCobro','');                \r            }\r            accion('formulario.txtNumDiasCobro','.disabled=true');\r        }\r    }\r\r    function guardarKO(){       \r        if(get('formulario.opcionMenu')==\"Modificar Concurso Ranking\"){  \r            btnProxy(1,1);\r            btnProxy(2,1);\r            btnProxy(3,0);\r            btnProxy(4,0);\r            btnProxy(5,1);\r            btnProxy(7,0);\r            btnProxy(8,0);\r            btnProxy(9,0);\r          \r            focaliza('formulario.cbVariableVentas');\r          \r        } else {\r                focaliza('formulario.cbVariableVentas');\r        }\r    }\r \r    \r    function botonAniadir(){\r          if(!sicc_validaciones_generales(\"gen,num\")){\r            return false;\r          }\r          if (get('formulario.ckAplicable')=='S'){\r            if(!sicc_validaciones_generales(\"numobl\")){\r              return false;\r            }          \r          }\r          var toAdd = \"\";\r          \r          \r          \r          toAdd = get('formulario.cbVariableVentas','T');\r          if (get('formulario.ckAplicable')=='S'){\r              toAdd = toAdd + \"|\" + \"SI\";         \r              var peso = new Number(get('formulario.txtPeso'));\r              var divisor = new Number(get('formulario.txtDivisor'));\r              var pesoVariable = (peso/divisor);\r              toAdd = toAdd + \"|\" + peso;\r              toAdd = toAdd + \"|\" + divisor;\r              toAdd = toAdd + \"|\" + toFix(pesoVariable);\r          } else {\r              toAdd = toAdd + \"|\" + \"NO\";\r              if (get('formulario.txtPeso')!='') {\r                toAdd = toAdd + \"|\" + get('formulario.txtPeso');\r              } else {\r                toAdd = toAdd + \"|\" + get('formulario.valDefMantenim');\r              }\r              if (get('formulario.txtDivisor')!='') {\r                toAdd = toAdd + \"|\" + get('formulario.txtDivisor');\r              } else {\r                toAdd = toAdd + \"|\" + get('formulario.valDefMantenim');\r              }\r              toAdd = toAdd + \"|\" + get('formulario.valDefMantenim');\r          }          \r\r          if (get('formulario.cbVariableVentas','V')==get('formulario.oidVarVtaRankPorcCobr')){\r              toAdd = toAdd + \"|\" + get('formulario.txtNumDiasCobro');\r          } else {\r              toAdd = toAdd + \"|\" + \" \";\r          }\r          toAdd = toAdd + \"|\" + \" \";          \r          pasaListaTemporal(get('formulario.cbVariableVentas','V'), toAdd);\r         \r          if(muestraMsg == true){\r              muestraMsg = false;\r                        } else {\r              set('formulario.cbVariableVentas','');\r              set('formulario.ckAplicable','N');\r              set('formulario.txtPeso',get('formulario.valDefMantenim'));\r              set('formulario.txtDivisor',get('formulario.valDefMantenim'));\r              accion('formulario.txtPeso','.disabled=true');              \r              accion('formulario.txtDivisor','.disabled=true');\r              txt_to('lbldtPesoVariable',get('formulario.valDefMantenim'));              \r              set('formulario.txtNumDiasCobro','');              \r              accion('formulario.txtNumDiasCobro','.disabled=true');\r          }\r          focaliza('formulario.cbVariableVentas');\r      }\r      \r     var muestraMsg = false;\r     function pasaListaTemporal(codigo, datos){\r        var codigosTemporal = listado1.codigos();\r        var match = rowMatch(codigo, codigosTemporal);\r        if (match){\r             muestraMsg = true;        }else{\r             datos = codigo + \"|\" + datos;               var newRow = new Array();\r             newRow = datos.split(\"|\");\r             listado1.insertar(newRow);         }\r      }\r      \r            function dejaEsp(a){\r          if (a.length == 0){\r              return ' ';\r          }else{\r              return a;\r          }\r      }\r\r          function rowMatch(codigo, codigosTemporal){\r        var flag = false;\r        var i = 0;\r        while ( (i < codigosTemporal.length) && (flag == false) ){\r             if ( codigo == codigosTemporal[i] )\r                  flag = true;      \r             i++;\r        }\r        return flag;\r     }\r     \r          function listado1string(){\r        var codigo = listado1.codigos();\r        var toAdd = \"\";\r        var total = \"\";\r  \r        for(var a = 0; a < codigo.length ; a++){\r             toAdd = codigo[a];\r             toAdd = toAdd + \"|\" + listado1.extraeDato(codigo[a], 0);\r             toAdd = toAdd + \"|\" + dejaEsp(listado1.extraeDato(codigo[a], 1));\r             toAdd = toAdd + \"|\" + dejaEsp(listado1.extraeDato(codigo[a], 2));\r             toAdd = toAdd + \"|\" + dejaEsp(listado1.extraeDato(codigo[a], 3));\r             toAdd = toAdd + \"|\" + dejaEsp(listado1.extraeDato(codigo[a], 4));\r             toAdd = toAdd + \"|\" + dejaEsp(listado1.extraeDato(codigo[a], 5));\r             toAdd = toAdd + \"|\" + dejaEsp(listado1.extraeDato(codigo[a], 6));                        \r             total = total + \"$\" + toAdd;\r        }          \r        return total;\r    }\r    \r        function botonEliminar() {\r          var cantElementos = listado1.codSeleccionados();\r          if ( cantElementos.length == 0 ){\r             GestionarMensaje(\"4\", null, null, null);\r                       }else{\r               listado1.eliminarSelecc();\r          }\r    }\r    \r    function onChangeAplicable(){         \r        if (get('formulario.ckAplicable')=='S'){\r            accion('formulario.txtPeso','.disabled=false');\r            accion('formulario.txtDivisor','.disabled=false');\r        } else {            \r            set('formulario.txtPeso', get('formulario.valDefMantenim'));\r            accion('formulario.txtPeso','.disabled=true');\r            set('formulario.txtDivisor', get('formulario.valDefMantenim'));\r            accion('formulario.txtDivisor','.disabled=true');\r            txt_to('lbldtPesoVariable',get('formulario.valDefMantenim'));\r        }\r    }\r    \r    function onChangePeso(){\r        if(!sicc_validaciones_generales(\"num\")){\r          return false;\r        }       \r        txt_to('lbldtPesoVariable','');\r        if (get('formulario.txtPeso')!=''){\r            if ((get('formulario.txtDivisor')!='')&&(get('formulario.txtDivisor')!='0')){\r                obtenerPesoVariable();\r            }\r        }\r    }\r\r    function onChangeDivisor(){\r        if(!sicc_validaciones_generales(\"num\")){\r          return false;\r        }\r        txt_to('lbldtPesoVariable','');\r        if ((get('formulario.txtDivisor')!='')&&(get('formulario.txtDivisor')!='0')){\r            if(get('formulario.txtPeso')!=''){\r                obtenerPesoVariable();\r            }\r        }    \r    }\r    \r    function obtenerPesoVariable(){          \r          var peso = new Number(get('formulario.txtPeso'));\r          var divisor = new Number(get('formulario.txtDivisor'));          \r          var pesoVariable = (peso/divisor);          \r          txt_to('lbldtPesoVariable',toFix(pesoVariable));\r    }    \r\r    function fGuardar(){\r          var datosObligatorios = comprobarDatosObligatorios();\r          eval('formulario').oculto = 'S';\r          set('formulario.accion','guardar');\r          set('formulario.datosObligatorios',datosObligatorios);\r          enviaSICC('formulario','','','N');\r    }\r    \r        function toFix(num){\r      var str = num.toString();\r      var point = str.indexOf(\".\");\r      var new_str = '';\r      if (point!='-1'){\r         var new_str = str.substring(0,point+3);\r      } else {\r         var new_str = str;\r      }\r      return (parseFloat(new_str));\r    } \r    \r	function fVolver(){\r		  window.close();\r	}\r\r\r    function fLimpiar(){\r        if(get('formulario.opcionMenu')!=\"Modificar Concurso Ranking\"){  \r        \r            set('formulario.cbVariableVentas','');\r            set('formulario.ckAplicable','N');\r            set('formulario.txtPeso',get('formulario.valDefMantenim'));\r            set('formulario.txtDivisor',get('formulario.valDefMantenim'));\r            accion('formulario.txtPeso','.disabled=true');              \r            accion('formulario.txtDivisor','.disabled=true');\r            txt_to('lbldtPesoVariable',get('formulario.valDefMantenim'));              \r            set('formulario.txtNumDiasCobro','');\r            \r            focaliza('formulario.cbVariableVentas');    \r            \r        } else {\r            eval('formulario').oculto = 'N';\r            set('formulario.accion','');\r            enviaSICC('formulario','','','N');\r        }\r    }\r     \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbVariableVentas" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","1021" );
      ((Element)v.get(7)).setAttribute("group","gen" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtPeso" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","1115" );
      ((Element)v.get(8)).setAttribute("format","e" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("max","999" );
      ((Element)v.get(8)).setAttribute("group","num" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtDivisor" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","2453" );
      ((Element)v.get(9)).setAttribute("format","e" );
      ((Element)v.get(9)).setAttribute("min","1" );
      ((Element)v.get(9)).setAttribute("max","99" );
      ((Element)v.get(9)).setAttribute("group","num" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtNumDiasCobro" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","2455" );
      ((Element)v.get(10)).setAttribute("format","e" );
      ((Element)v.get(10)).setAttribute("min","1" );
      ((Element)v.get(10)).setAttribute("max","99" );
      ((Element)v.get(10)).setAttribute("group","num" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtPeso" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1115" );
      ((Element)v.get(11)).setAttribute("format","e" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","999" );
      ((Element)v.get(11)).setAttribute("group","numobl" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtDivisor" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","2453" );
      ((Element)v.get(12)).setAttribute("format","e" );
      ((Element)v.get(12)).setAttribute("min","1" );
      ((Element)v.get(12)).setAttribute("max","99" );
      ((Element)v.get(12)).setAttribute("group","numobl" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:6   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(13)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","LPMantenerVariablesCalculoRanking" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(16)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","idioma" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","pais" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidVarVtaRankPorcCobr" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","valDefMantenim" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","listado1STR" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hIndEstadoParametrosGerentes" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hIndEstadoParametrosConsultoras" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hIndEstadoVariablesVenta" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","habilitarcbVariableVentas" );
      ((Element)v.get(30)).setAttribute("valor","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","habilitarckAplicable" );
      ((Element)v.get(31)).setAttribute("valor","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","habilitartxtPeso" );
      ((Element)v.get(32)).setAttribute("valor","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","habilitartxtDivisor" );
      ((Element)v.get(33)).setAttribute("valor","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","habilitartxtNumDiasCobro" );
      ((Element)v.get(34)).setAttribute("valor","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","habilitarbtnAnadir" );
      ((Element)v.get(35)).setAttribute("valor","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","habilitarbtnEliminar" );
      ((Element)v.get(36)).setAttribute("valor","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 13   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","100%" );
      ((Element)v.get(37)).setAttribute("height","100%" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("class","menu4" );
      ((Element)v.get(13)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(39)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(39)).setAttribute("class","menu5texto" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(40)).setAttribute("height","30" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(41)).setAttribute("class","menu5texto" );
      ((Element)v.get(38)).appendChild((Element)v.get(41));

      /* Elemento padre:41 / Elemento actual: 42   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(41)).appendChild((Text)v.get(42));

      /* Termina nodo Texto:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("width","10" );
      ((Element)v.get(43)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(43)).setAttribute("class","menu5texto" );
      ((Element)v.get(38)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","10" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","92" );
      ((Element)v.get(45)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(45)).setAttribute("class","menu5texto" );
      ((Element)v.get(38)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("table"));
      ((Element)v.get(46)).setAttribute("width","75" );
      ((Element)v.get(46)).setAttribute("border","1" );
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(46)).setAttribute("cellpadding","1" );
      ((Element)v.get(46)).setAttribute("cellspacing","0" );
      ((Element)v.get(46)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(46)).setAttribute("onmouseover","activarPuntero('formulario', 1, 'lblDatosGenerales');" );
      ((Element)v.get(46)).setAttribute("onclick","onClickPestanyaHabilitada(1, 'formulario', 'LPMantenerVariablesCalculoRanking');" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(47)).setAttribute("align","center" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(48)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblDatosGenerales" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(49)).setAttribute("cod","0011" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:50 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","10" );
      ((Element)v.get(50)).setAttribute("class","menu5texto" );
      ((Element)v.get(38)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","10" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","20" );
      ((Element)v.get(52)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(52)).setAttribute("class","menu5texto" );
      ((Element)v.get(38)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("width","75" );
      ((Element)v.get(53)).setAttribute("border","1" );
      ((Element)v.get(53)).setAttribute("align","center" );
      ((Element)v.get(53)).setAttribute("cellpadding","1" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(53)).setAttribute("onmouseover","activarPuntero('formulario', 2, 'lblAlcanceGeografico');" );
      ((Element)v.get(53)).setAttribute("onclick","onClickPestanyaHabilitada(2, 'formulario', 'LPMantenerVariablesCalculoRanking');" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).setAttribute("align","center" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(56)).setAttribute("nombre","lblAlcanceGeografico" );
      ((Element)v.get(56)).setAttribute("alto","13" );
      ((Element)v.get(56)).setAttribute("filas","1" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(56)).setAttribute("cod","00368" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:57 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","10" );
      ((Element)v.get(57)).setAttribute("class","menu5texto" );
      ((Element)v.get(38)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","10" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","20" );
      ((Element)v.get(59)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(59)).setAttribute("class","menu5texto" );
      ((Element)v.get(38)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("table"));
      ((Element)v.get(60)).setAttribute("width","75" );
      ((Element)v.get(60)).setAttribute("border","1" );
      ((Element)v.get(60)).setAttribute("align","center" );
      ((Element)v.get(60)).setAttribute("cellpadding","1" );
      ((Element)v.get(60)).setAttribute("cellspacing","0" );
      ((Element)v.get(60)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(60)).setAttribute("onmouseover","activarPuntero('formulario', 3, 'lblParametrosGerentes');" );
      ((Element)v.get(60)).setAttribute("onclick","onClickPestanyaHabilitada(3, 'formulario', 'LPMantenerVariablesCalculoRanking');" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(62)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(63)).setAttribute("nombre","lblParametrosGerentes" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(63)).setAttribute("cod","00594" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:64 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","10" );
      ((Element)v.get(64)).setAttribute("class","menu5texto" );
      ((Element)v.get(38)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","10" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","20" );
      ((Element)v.get(66)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(66)).setAttribute("class","menu5texto" );
      ((Element)v.get(38)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("table"));
      ((Element)v.get(67)).setAttribute("width","75" );
      ((Element)v.get(67)).setAttribute("border","1" );
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(67)).setAttribute("cellpadding","1" );
      ((Element)v.get(67)).setAttribute("cellspacing","0" );
      ((Element)v.get(67)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(67)).setAttribute("onmouseover","activarPuntero('formulario', 4, 'lblParametrosConsultoras');" );
      ((Element)v.get(67)).setAttribute("onclick","onClickPestanyaHabilitada(4, 'formulario', 'LPMantenerVariablesCalculoRanking');" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).setAttribute("align","center" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(69)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lblParametrosConsultoras" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(70)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(70)).setAttribute("cod","00595" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:71 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","16" );
      ((Element)v.get(71)).setAttribute("class","menu5texto" );
      ((Element)v.get(38)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","12" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:73 / Elemento padre: 13   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(73)).setAttribute("height","100%" );
      ((Element)v.get(73)).setAttribute("border","0" );
      ((Element)v.get(73)).setAttribute("align","center" );
      ((Element)v.get(73)).setAttribute("cellpadding","0" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("class","menu4" );
      ((Element)v.get(13)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(75)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(75)).setAttribute("class","menu5texto" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","12" );
      ((Element)v.get(76)).setAttribute("height","30" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).setAttribute("class","menu5texto" );
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Elemento padre:77 / Elemento actual: 78   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(77)).appendChild((Text)v.get(78));

      /* Termina nodo Texto:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","10" );
      ((Element)v.get(79)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(79)).setAttribute("class","menu5texto" );
      ((Element)v.get(74)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","10" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","20" );
      ((Element)v.get(81)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(81)).setAttribute("class","menu5texto" );
      ((Element)v.get(74)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("table"));
      ((Element)v.get(82)).setAttribute("width","75" );
      ((Element)v.get(82)).setAttribute("border","1" );
      ((Element)v.get(82)).setAttribute("align","center" );
      ((Element)v.get(82)).setAttribute("cellpadding","1" );
      ((Element)v.get(82)).setAttribute("cellspacing","0" );
      ((Element)v.get(82)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(82)).setAttribute("onmouseover","activarPuntero('formulario', 5, 'lblProductos');" );
      ((Element)v.get(82)).setAttribute("onclick","onClickPestanyaHabilitada(5, 'formulario', 'LPMantenerVariablesCalculoRanking');" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(83)).setAttribute("align","center" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(84)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(85)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(85)).setAttribute("alto","13" );
      ((Element)v.get(85)).setAttribute("filas","1" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(85)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(85)).setAttribute("cod","0094" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:86 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","10" );
      ((Element)v.get(86)).setAttribute("class","menu5texto" );
      ((Element)v.get(74)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","10" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","20" );
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).setAttribute("class","menu5texto" );
      ((Element)v.get(74)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("table"));
      ((Element)v.get(89)).setAttribute("width","75" );
      ((Element)v.get(89)).setAttribute("border","1" );
      ((Element)v.get(89)).setAttribute("align","center" );
      ((Element)v.get(89)).setAttribute("cellpadding","1" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(89)).setAttribute("cellspacing","0" );
      ((Element)v.get(89)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(89)).setAttribute("onmouseover","activarPuntero('formulario', 6, 'lblPremios');" );
      ((Element)v.get(89)).setAttribute("onclick","onClickPestanyaHabilitada(6, 'formulario', 'LPMantenerVariablesCalculoRanking');" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).setAttribute("align","center" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(92)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(92)).setAttribute("alto","13" );
      ((Element)v.get(92)).setAttribute("filas","1" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(92)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(92)).setAttribute("cod","00394" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:93 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","10" );
      ((Element)v.get(93)).setAttribute("class","menu5texto" );
      ((Element)v.get(74)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","10" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","20" );
      ((Element)v.get(95)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(95)).setAttribute("class","menu5texto" );
      ((Element)v.get(74)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("table"));
      ((Element)v.get(96)).setAttribute("width","75" );
      ((Element)v.get(96)).setAttribute("border","1" );
      ((Element)v.get(96)).setAttribute("align","center" );
      ((Element)v.get(96)).setAttribute("cellpadding","1" );
      ((Element)v.get(96)).setAttribute("cellspacing","0" );
      ((Element)v.get(96)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(96)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(96)).setAttribute("onmouseover","activarPuntero('formulario', 7, 'lblVariablesVenta');" );
      ((Element)v.get(96)).setAttribute("onclick","onClickPestanyaHabilitada(7, 'formulario', 'LPMantenerVariablesCalculoRanking');" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).setAttribute("align","center" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(98)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(99)).setAttribute("nombre","lblVariablesVenta" );
      ((Element)v.get(99)).setAttribute("alto","13" );
      ((Element)v.get(99)).setAttribute("filas","1" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(99)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(99)).setAttribute("cod","1951" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:100 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("width","16" );
      ((Element)v.get(100)).setAttribute("class","menu5texto" );
      ((Element)v.get(74)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:102 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(102)).setAttribute("nombre","capa1" );
      ((Element)v.get(13)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("table"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(103)).setAttribute("border","0" );
      ((Element)v.get(103)).setAttribute("cellspacing","0" );
      ((Element)v.get(103)).setAttribute("cellpadding","0" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","12" );
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","12" );
      ((Element)v.get(106)).setAttribute("height","12" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(107)).setAttribute("width","750" );
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("width","12" );
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","12" );
      ((Element)v.get(110)).setAttribute("height","1" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:104   */

      /* Empieza nodo:111 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(116)).setAttribute("class","legend" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lblDatosVariablesCalculoRanking" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(117)).setAttribute("id","legend" );
      ((Element)v.get(117)).setAttribute("cod","00601" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("table"));
      ((Element)v.get(118)).setAttribute("width","100%" );
      ((Element)v.get(118)).setAttribute("border","0" );
      ((Element)v.get(118)).setAttribute("align","center" );
      ((Element)v.get(118)).setAttribute("cellspacing","0" );
      ((Element)v.get(118)).setAttribute("cellpadding","0" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("table"));
      ((Element)v.get(121)).setAttribute("width","625" );
      ((Element)v.get(121)).setAttribute("border","0" );
      ((Element)v.get(121)).setAttribute("align","left" );
      ((Element)v.get(121)).setAttribute("cellspacing","0" );
      ((Element)v.get(121)).setAttribute("cellpadding","0" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("colspan","4" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:125 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(129)).setAttribute("nombre","lblVariableVentas" );
      ((Element)v.get(129)).setAttribute("alto","13" );
      ((Element)v.get(129)).setAttribute("filas","1" );
      ((Element)v.get(129)).setAttribute("valor","" );
      ((Element)v.get(129)).setAttribute("id","datosTitle" );
      ((Element)v.get(129)).setAttribute("cod","1021" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","25" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(125)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(133)).setAttribute("nombre","lblAplicable" );
      ((Element)v.get(133)).setAttribute("alto","13" );
      ((Element)v.get(133)).setAttribute("filas","1" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("id","datosTitle" );
      ((Element)v.get(133)).setAttribute("cod","2452" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","25" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(137)).setAttribute("nombre","lblPeso" );
      ((Element)v.get(137)).setAttribute("alto","13" );
      ((Element)v.get(137)).setAttribute("filas","1" );
      ((Element)v.get(137)).setAttribute("valor","" );
      ((Element)v.get(137)).setAttribute("id","datosTitle" );
      ((Element)v.get(137)).setAttribute("cod","1115" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","25" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(141)).setAttribute("nombre","lblDivisor" );
      ((Element)v.get(141)).setAttribute("alto","13" );
      ((Element)v.get(141)).setAttribute("filas","1" );
      ((Element)v.get(141)).setAttribute("valor","" );
      ((Element)v.get(141)).setAttribute("id","datosTitle" );
      ((Element)v.get(141)).setAttribute("cod","2453" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","25" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(145)).setAttribute("nombre","lblPesoVariable" );
      ((Element)v.get(145)).setAttribute("alto","13" );
      ((Element)v.get(145)).setAttribute("filas","1" );
      ((Element)v.get(145)).setAttribute("valor","" );
      ((Element)v.get(145)).setAttribute("id","datosTitle" );
      ((Element)v.get(145)).setAttribute("cod","2454" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","25" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(149)).setAttribute("nombre","lblNumDiasCobro" );
      ((Element)v.get(149)).setAttribute("alto","13" );
      ((Element)v.get(149)).setAttribute("filas","1" );
      ((Element)v.get(149)).setAttribute("valor","" );
      ((Element)v.get(149)).setAttribute("id","datosTitle" );
      ((Element)v.get(149)).setAttribute("cod","2455" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(125)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:125   */

      /* Empieza nodo:152 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(152)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(156)).setAttribute("nombre","cbVariableVentas" );
      ((Element)v.get(156)).setAttribute("id","datosCampos" );
      ((Element)v.get(156)).setAttribute("size","1" );
      ((Element)v.get(156)).setAttribute("multiple","N" );
      ((Element)v.get(156)).setAttribute("req","S" );
      ((Element)v.get(156)).setAttribute("onchange","onChangeVariableVentas();" );
      ((Element)v.get(156)).setAttribute("onshtab","focalizaBotonHTML_XY('btnEliminar');" );
      ((Element)v.get(156)).setAttribute("valorinicial","" );
      ((Element)v.get(156)).setAttribute("textoinicial","" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:158 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","25" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(152)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(161)).setAttribute("id","datosCampos" );
      ((Element)v.get(161)).setAttribute("nombre","ckAplicable" );
      ((Element)v.get(161)).setAttribute("onclick","onChangeAplicable();" );
      ((Element)v.get(161)).setAttribute("req","" );
      ((Element)v.get(161)).setAttribute("texto","" );
      ((Element)v.get(161)).setAttribute("validacion","" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","25" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(152)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(165)).setAttribute("nombre","txtPeso" );
      ((Element)v.get(165)).setAttribute("id","datosCampos" );
      ((Element)v.get(165)).setAttribute("max","3" );
      ((Element)v.get(165)).setAttribute("tipo","" );
      ((Element)v.get(165)).setAttribute("onblur","onChangePeso();" );
      ((Element)v.get(165)).setAttribute("req","N" );
      ((Element)v.get(165)).setAttribute("size","3" );
      ((Element)v.get(165)).setAttribute("valor","" );
      ((Element)v.get(165)).setAttribute("validacion","" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","25" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(152)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(169)).setAttribute("nombre","txtDivisor" );
      ((Element)v.get(169)).setAttribute("id","datosCampos" );
      ((Element)v.get(169)).setAttribute("max","2" );
      ((Element)v.get(169)).setAttribute("tipo","" );
      ((Element)v.get(169)).setAttribute("onblur","onChangeDivisor();" );
      ((Element)v.get(169)).setAttribute("req","N" );
      ((Element)v.get(169)).setAttribute("size","2" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("validacion","" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","25" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(173)).setAttribute("nombre","lbldtPesoVariable" );
      ((Element)v.get(173)).setAttribute("alto","13" );
      ((Element)v.get(173)).setAttribute("filas","1" );
      ((Element)v.get(173)).setAttribute("valor","" );
      ((Element)v.get(173)).setAttribute("id","datosCampos" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","25" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(152)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(177)).setAttribute("nombre","txtNumDiasCobro" );
      ((Element)v.get(177)).setAttribute("id","datosCampos" );
      ((Element)v.get(177)).setAttribute("max","3" );
      ((Element)v.get(177)).setAttribute("tipo","" );
      ((Element)v.get(177)).setAttribute("onchange","" );
      ((Element)v.get(177)).setAttribute("req","N" );
      ((Element)v.get(177)).setAttribute("size","3" );
      ((Element)v.get(177)).setAttribute("valor","" );
      ((Element)v.get(177)).setAttribute("validacion","" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(152)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:152   */

      /* Empieza nodo:180 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("colspan","4" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:183 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","12" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:111   */

      /* Empieza nodo:185 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("table"));
      ((Element)v.get(190)).setAttribute("width","100%" );
      ((Element)v.get(190)).setAttribute("border","0" );
      ((Element)v.get(190)).setAttribute("align","center" );
      ((Element)v.get(190)).setAttribute("cellspacing","0" );
      ((Element)v.get(190)).setAttribute("cellpadding","0" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("class","botonera" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(193)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(193)).setAttribute("ID","botonContenido" );
      ((Element)v.get(193)).setAttribute("tipo","html" );
      ((Element)v.get(193)).setAttribute("accion","botonAniadir();" );
      ((Element)v.get(193)).setAttribute("estado","false" );
      ((Element)v.get(193)).setAttribute("cod","404" );
      ((Element)v.get(193)).setAttribute("ontab","focalizaBotonHTML_XY('btnEliminar');" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:194 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","12" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:185   */

      /* Empieza nodo:196 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("width","12" );
      ((Element)v.get(197)).setAttribute("align","center" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","12" );
      ((Element)v.get(198)).setAttribute("height","12" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("width","750" );
      ((Element)v.get(196)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("width","12" );
      ((Element)v.get(196)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","12" );
      ((Element)v.get(202)).setAttribute("height","12" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:196   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:203 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(203)).setAttribute("nombre","listado1" );
      ((Element)v.get(203)).setAttribute("ancho","628" );
      ((Element)v.get(203)).setAttribute("alto","309" );
      ((Element)v.get(203)).setAttribute("x","12" );
      ((Element)v.get(203)).setAttribute("y","176" );
      ((Element)v.get(203)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(203)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(204)).setAttribute("precarga","S" );
      ((Element)v.get(204)).setAttribute("conROver","S" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(205)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(205)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(205)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(205)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 204   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(206)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(206)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(206)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(206)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(204)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 204   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(207)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(207)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(204)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:204   */

      /* Empieza nodo:208 / Elemento padre: 203   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(203)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(209)).setAttribute("borde","1" );
      ((Element)v.get(209)).setAttribute("horizDatos","1" );
      ((Element)v.get(209)).setAttribute("horizCabecera","1" );
      ((Element)v.get(209)).setAttribute("vertical","1" );
      ((Element)v.get(209)).setAttribute("horizTitulo","1" );
      ((Element)v.get(209)).setAttribute("horizBase","1" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 208   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(210)).setAttribute("borde","#999999" );
      ((Element)v.get(210)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(210)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(210)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(210)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(210)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(210)).setAttribute("horizBase","#999999" );
      ((Element)v.get(208)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:208   */

      /* Empieza nodo:211 / Elemento padre: 203   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(211)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(211)).setAttribute("alto","22" );
      ((Element)v.get(211)).setAttribute("imgFondo","" );
      ((Element)v.get(211)).setAttribute("cod","00601" );
      ((Element)v.get(211)).setAttribute("ID","datosTitle" );
      ((Element)v.get(203)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 203   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(212)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(212)).setAttribute("alto","22" );
      ((Element)v.get(212)).setAttribute("imgFondo","" );
      ((Element)v.get(203)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 203   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(213)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(213)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(213)).setAttribute("blancosAInsertar","1" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(213)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(213)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(213)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(203)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("ancho","190" );
      ((Element)v.get(214)).setAttribute("minimizable","S" );
      ((Element)v.get(214)).setAttribute("minimizada","N" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("ancho","50" );
      ((Element)v.get(215)).setAttribute("minimizable","S" );
      ((Element)v.get(215)).setAttribute("minimizada","N" );
      ((Element)v.get(213)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("ancho","40" );
      ((Element)v.get(216)).setAttribute("minimizable","S" );
      ((Element)v.get(216)).setAttribute("minimizada","N" );
      ((Element)v.get(213)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("ancho","40" );
      ((Element)v.get(217)).setAttribute("minimizable","S" );
      ((Element)v.get(217)).setAttribute("minimizada","N" );
      ((Element)v.get(213)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("ancho","70" );
      ((Element)v.get(218)).setAttribute("minimizable","S" );
      ((Element)v.get(218)).setAttribute("minimizada","N" );
      ((Element)v.get(213)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("ancho","70" );
      ((Element)v.get(219)).setAttribute("minimizable","S" );
      ((Element)v.get(219)).setAttribute("minimizada","N" );
      ((Element)v.get(213)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 213   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("ancho","0" );
      ((Element)v.get(220)).setAttribute("minimizable","S" );
      ((Element)v.get(220)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).setAttribute("oculta","S" );
      ((Element)v.get(213)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:213   */

      /* Empieza nodo:221 / Elemento padre: 203   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(221)).setAttribute("alto","20" );
      ((Element)v.get(221)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(221)).setAttribute("imgFondo","" );
      ((Element)v.get(221)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(221)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(203)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("colFondo","" );
      ((Element)v.get(222)).setAttribute("ID","EstCab" );
      ((Element)v.get(222)).setAttribute("cod","1021" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("colFondo","" );
      ((Element)v.get(223)).setAttribute("ID","EstCab" );
      ((Element)v.get(223)).setAttribute("cod","2452" );
      ((Element)v.get(221)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("colFondo","" );
      ((Element)v.get(224)).setAttribute("ID","EstCab" );
      ((Element)v.get(224)).setAttribute("cod","1115" );
      ((Element)v.get(221)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("colFondo","" );
      ((Element)v.get(225)).setAttribute("ID","EstCab" );
      ((Element)v.get(225)).setAttribute("cod","2453" );
      ((Element)v.get(221)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("colFondo","" );
      ((Element)v.get(226)).setAttribute("ID","EstCab" );
      ((Element)v.get(226)).setAttribute("cod","2454" );
      ((Element)v.get(221)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("colFondo","" );
      ((Element)v.get(227)).setAttribute("ID","EstCab" );
      ((Element)v.get(227)).setAttribute("cod","2455" );
      ((Element)v.get(221)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:221   */

      /* Empieza nodo:228 / Elemento padre: 203   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(228)).setAttribute("alto","22" );
      ((Element)v.get(228)).setAttribute("accion","" );
      ((Element)v.get(228)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(228)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(228)).setAttribute("maxSel","-1" );
      ((Element)v.get(228)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(228)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(228)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(228)).setAttribute("onLoad","" );
      ((Element)v.get(228)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(203)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(229)).setAttribute("tipo","texto" );
      ((Element)v.get(229)).setAttribute("ID","EstDat" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("tipo","texto" );
      ((Element)v.get(230)).setAttribute("ID","EstDat2" );
      ((Element)v.get(228)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("tipo","texto" );
      ((Element)v.get(231)).setAttribute("ID","EstDat" );
      ((Element)v.get(228)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("tipo","texto" );
      ((Element)v.get(232)).setAttribute("ID","EstDat2" );
      ((Element)v.get(228)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("tipo","texto" );
      ((Element)v.get(233)).setAttribute("ID","EstDat" );
      ((Element)v.get(228)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("tipo","texto" );
      ((Element)v.get(234)).setAttribute("ID","EstDat2" );
      ((Element)v.get(228)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 228   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("tipo","texto" );
      ((Element)v.get(235)).setAttribute("ID","EstDat" );
      ((Element)v.get(228)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:228   */

      /* Empieza nodo:236 / Elemento padre: 203   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(203)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 203   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(237)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(237)).setAttribute("ancho","628" );
      ((Element)v.get(237)).setAttribute("sep","$" );
      ((Element)v.get(237)).setAttribute("x","12" );
      ((Element)v.get(237)).setAttribute("class","botonera" );
      ((Element)v.get(237)).setAttribute("y","402" );
      ((Element)v.get(237)).setAttribute("control","|" );
      ((Element)v.get(237)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(237)).setAttribute("rowset","" );
      ((Element)v.get(237)).setAttribute("cargainicial","N" );
      ((Element)v.get(203)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(238)).setAttribute("nombre","ret1" );
      ((Element)v.get(238)).setAttribute("x","37" );
      ((Element)v.get(238)).setAttribute("y","406" );
      ((Element)v.get(238)).setAttribute("ID","botonContenido" );
      ((Element)v.get(238)).setAttribute("img","retroceder_on" );
      ((Element)v.get(238)).setAttribute("tipo","0" );
      ((Element)v.get(238)).setAttribute("estado","false" );
      ((Element)v.get(238)).setAttribute("alt","" );
      ((Element)v.get(238)).setAttribute("codigo","" );
      ((Element)v.get(238)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 237   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(239)).setAttribute("nombre","ava1" );
      ((Element)v.get(239)).setAttribute("x","52" );
      ((Element)v.get(239)).setAttribute("y","406" );
      ((Element)v.get(239)).setAttribute("ID","botonContenido" );
      ((Element)v.get(239)).setAttribute("img","avanzar_on" );
      ((Element)v.get(239)).setAttribute("tipo","0" );
      ((Element)v.get(239)).setAttribute("estado","false" );
      ((Element)v.get(239)).setAttribute("alt","" );
      ((Element)v.get(239)).setAttribute("codigo","" );
      ((Element)v.get(239)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(237)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:237   */
      /* Termina nodo:203   */

      /* Empieza nodo:240 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(240)).setAttribute("nombre","primera1" );
      ((Element)v.get(240)).setAttribute("x","20" );
      ((Element)v.get(240)).setAttribute("y","406" );
      ((Element)v.get(240)).setAttribute("ID","botonContenido" );
      ((Element)v.get(240)).setAttribute("img","primera_on" );
      ((Element)v.get(240)).setAttribute("tipo","-2" );
      ((Element)v.get(240)).setAttribute("estado","false" );
      ((Element)v.get(240)).setAttribute("alt","" );
      ((Element)v.get(240)).setAttribute("codigo","" );
      ((Element)v.get(240)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(13)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(241)).setAttribute("nombre","separa" );
      ((Element)v.get(241)).setAttribute("x","59" );
      ((Element)v.get(241)).setAttribute("y","402" );
      ((Element)v.get(241)).setAttribute("ID","botonContenido" );
      ((Element)v.get(241)).setAttribute("img","separa_base" );
      ((Element)v.get(241)).setAttribute("tipo","0" );
      ((Element)v.get(241)).setAttribute("estado","false" );
      ((Element)v.get(241)).setAttribute("alt","" );
      ((Element)v.get(241)).setAttribute("codigo","" );
      ((Element)v.get(241)).setAttribute("accion","" );
      ((Element)v.get(13)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(242)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(242)).setAttribute("x","13" );
      ((Element)v.get(242)).setAttribute("y","463" );
      ((Element)v.get(242)).setAttribute("ID","botonContenido" );
      ((Element)v.get(242)).setAttribute("tipo","html" );
      ((Element)v.get(242)).setAttribute("accion","botonEliminar();" );
      ((Element)v.get(242)).setAttribute("estado","false" );
      ((Element)v.get(242)).setAttribute("cod","1254" );
      ((Element)v.get(242)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnAnadir');" );
      ((Element)v.get(242)).setAttribute("ontab","focaliza('formulario.cbVariableVentas');" );
      ((Element)v.get(13)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(243)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(243)).setAttribute("alto","12" );
      ((Element)v.get(243)).setAttribute("ancho","50" );
      ((Element)v.get(243)).setAttribute("x","0" );
      ((Element)v.get(243)).setAttribute("y","425" );
      ((Element)v.get(13)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:13   */


   }

}
