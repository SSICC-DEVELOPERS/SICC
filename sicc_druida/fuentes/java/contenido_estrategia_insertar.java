
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_estrategia_insertar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1350(doc);
         

      getXML1440(doc);
         

      getXML1530(doc);
         

      getXML1620(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_estrategia_insertar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPage();" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("    \r  \rvar xrbTipoProducto;\r\r    function onLoadPage(){\r      configurarMenuSecundario(\"formulario\");\r      fMostrarMensajeError();\r		if(get(\"formulario.accion\")==\"\")\r            tipoEstrategiaOnChange();\r            \r        if(get(\"formulario.opcionMenu\")==\"Insertar\"){    \r            loadOnInitComponent();\r            focaliza(\"formulario.txtCodEstrategia\");    \r\r        }\r        if((get(\"formulario.opcionMenu\")==\"Modificar\")  || (get(\"formulario.opcionMenu\")==\"Consultar\")) {       \r                        seteaCheck();\r                        set(\"formulario.cbTipoEstrategia\",new Array(get(\"formulario.indCvTipoEstrategia\")) );        \r                        xrbTipoProducto = get(\"formulario.tipoCli\");\r            seteaTipoProducto(xrbTipoProducto);\r                        deshabilita();\r            if(get(\"formulario.opcionMenu\")==\"Modificar\" ){\r                loadOnInitComponent();                \r                                xrbTipoProducto = get(\"formulario.tipoCli\");\r                seteaTipoProducto(xrbTipoProducto);\r                tipoEstrategiaOnChange();\r                focaliza(\"formulario.txtDescipcion\");\r\r            }\r        }\r    }\r\r    function seteaCheck(){\r        set(\"formulario.ckEstrategiaGrupo\",get(\"formulario.indgrupo\") );\r        set(\"formulario.ckEstrategiaCondicionada\",get(\"formulario.indcondi\") );\r        set(\"formulario.ckVS\",get(\"formulario.indvs\") );\r        set(\"formulario.ckPaquetes\",get(\"formulario.indpaq\") );\r        set(\"formulario.ckListaRanking\",get(\"formulario.indlista\") );\r        set(\"formulario.ckSolicitarIndicadorCuadre\",get(\"formulario.indCGru\") );        \r        set(\"formulario.ckCodVentaImprimibles\",get(\"formulario.indCvimp\") );\r        set(\"formulario.ckModificableImprimibles\",get(\"formulario.indMImp\") );        \r        set(\"formulario.ckCodVentaDespachoAutomatico\",get(\"formulario.indCvDesp\") );            \r        set(\"formulario.ckModificableDespachoAutomatico\",get(\"formulario.indMDesp\") );\r        set(\"formulario.ckCodVentaDigitables\",get(\"formulario.indCvDig\") );        \r        set(\"formulario.ckModificableDigitables\",get(\"formulario.indMDig\") );\r    }\r\r        \r    function seteaTipoProducto(ticl){        \r        if(ticl == get(\"formulario.ORDEN_COMPRA\") ){\r            document.all[\"rbTipoProducto\"][0].checked=true;           \r        }\r        if(ticl == get(\"formulario.ALTERNATIVO\") ){\r            document.all[\"rbTipoProducto\"][1].checked=true;\r        }\r        if(ticl == get(\"formulario.REEMPLAZO\") ){\r            document.all[\"rbTipoProducto\"][2].checked=true;\r        }\r        if(ticl == get(\"formulario.RECUPERACION\") ){\r            document.all[\"rbTipoProducto\"][3].checked=true;\r        }\r        set(\"formulario.rbTipoProducto\",ticl);\r    }\r \r    function cambioTipoProd(){\r        var sel = get(\"formulario.cbTipoEstrategia\");\r                if(((document.all[\"rbTipoProducto\"][0].disabled==true) && (sel!=\"2\") && (sel!=\"6\")) ||\r           ((document.all[\"rbTipoProducto\"][0].disabled==false) && (get(\"formulario.rbTipoProducto\")==\"1\") && (sel!=\"2\") && (sel!=\"6\"))){ \r              accion(\"formulario.txtOrdenAsignacionCUV\",\".disabled=false\");\r        } else {\r              accion(\"formulario.txtOrdenAsignacionCUV\",\".disabled=true\");\r              set(\"formulario.txtOrdenAsignacionCUV\",\"\");\r        }      \r    }\r\r	function deshabilita(){\r        if(get(\"formulario.opcionMenu\") != \"Insertar\"){\r                        accion(\"formulario.cbTipoEstrategia\",\".disabled=true\");\r            accion(\"formulario.txtCodEstrategia\",\".disabled=true\" );\r        }\r        \r        deshabilitaObjects(true, 'ck');\r        deshabilitaRadio(true);\r\r        if(get(\"formulario.opcionMenu\")==\"Consultar\"){\r            deshabilitaObjects(true, 'txt'); \r        }\r	 }\r\r    function tipoEstrategiaOnChange(){\r    \r        if(get(\"formulario.opcionMenu\")==\"Insertar\"){\r                        deshabilita();\r            accion(\"formulario.cbTipoEstrategia\",\".disabled=false\" );\r            accion(\"formulario.txtCodEstrategia\",\".disabled=false\" );\r        }\r                accion(\"formulario.txtDescipcion\",\".disabled=false\" );\r        accion(\"formulario.ckCodVentaImprimibles\", \".disabled=false\");\r        accion(\"formulario.ckModificableImprimibles\",\".disabled=false\" );        \r        accion(\"formulario.ckCodVentaDespachoAutomatico\",\".disabled=false\" );            \r        accion(\"formulario.ckModificableDespachoAutomatico\",\".disabled=false\" );\r        accion(\"formulario.ckCodVentaDigitables\",\".disabled=false\" );        \r        accion(\"formulario.ckModificableDigitables\",\".disabled=false\" );\r        \r        var sel = get(\"formulario.cbTipoEstrategia\");\r        if(sel == ''){\r                        deshabilitaObjects(true, 'ck');       \r                      deshabilitaRadio(true);\r           accion(\"formulario.txtNumMaximoGrupo\",\".disabled=true\");\r           accion(\"formulario.txtOrdenAsignacionCUV\",\".disabled=true\");\r           accion(\"formulario.txtNumMaximoGrupoCondicionados\",\".disabled=true\");\r           accion(\"formulario.txtNumMaximoGrupoCondicionantes\",\".disabled=true\");\r           set(\"formulario.ckEstrategiaGrupo\",\"N\");\r           set(\"formulario.ckEstrategiaCondicionada\",\"N\");\r           set(\"formulario.ckEstrategiaVR\",\"N\");\r           set(\"formulario.ckEstrategiaPaquetes\",\"N\");                \r        }\r        \r        var array = listaEstrategia.datos;\r        for(var i=0; i < array.length; i++){\r          if(array[i][0] == sel){\r                if(array[i][2]==\"1\") {set(\"formulario.ckEstrategiaGrupo\",\"S\");}else{set(\"formulario.ckEstrategiaGrupo\",\"N\");}\r                if(array[i][3]==\"1\") {set(\"formulario.ckEstrategiaCondicionada\",\"S\");}else{set(\"formulario.ckEstrategiaCondicionada\",\"N\");} \r                if(array[i][4]==\"1\") {set(\"formulario.ckEstrategiaVR\",\"S\");}else{set(\"formulario.ckEstrategiaVR\",\"N\");} \r                if(array[i][5]==\"1\") {set(\"formulario.ckEstrategiaPaquetes\",\"S\");}else{set(\"formulario.ckEstrategiaPaquetes\",\"N\");} \r                \r                if((array[i][2]==\"1\") || (array[i][5]==\"1\")){	accion(\"formulario.txtNumMaximoGrupo\",\".disabled=false\");}\r																							  else {set(\"formulario.txtNumMaximoGrupo\",\"\");accion(\"formulario.txtNumMaximoGrupo\",\".disabled=true\");}\r                if((array[i][2]==\"1\") && (array[i][3]==\"1\"))	accion(\"formulario.txtNumMaximoGrupoCondicionantes\",\".disabled=false\");\r																							  else{set(\"formulario.txtNumMaximoGrupoCondicionantes\",\"\"); accion(\"formulario.txtNumMaximoGrupoCondicionantes\",\".disabled=true\");}\r                if((array[i][2]==\"1\") && (array[i][3]==\"1\"))	accion(\"formulario.txtNumMaximoGrupoCondicionados\",\".disabled=false\");\r																							  else{set(\"formulario.txtNumMaximoGrupoCondicionados\",\"\"); accion(\"formulario.txtNumMaximoGrupoCondicionados\",\".disabled=true\");}\r                if((array[i][2]==\"1\") || (array[i][5]==\"1\"))	accion(\"formulario.ckListaRanking\",\".disabled=false\");\r																							  else{set(\"formulario.ckListaRanking\",\"N\");  accion(\"formulario.ckListaRanking\",\".disabled=true\");}\r                /*if(sel==\"4\") accion(\"formulario.ckEstrategiaCondicionada\",\".disabled=false\");\r                                                else{set(\"formulario.ckEstrategiaCondicionada\",\"N\"); accion(\"formulario.ckEstrategiaCondicionada\",\".disabled=true\");}\r                */\r                if(sel==\"4\"){ \r                  set(\"formulario.ckIndicadorCuadrePorGrupo\",\"S\");          \r                  accion(\"formulario.txtNumMaximoGrupoCondicionados\",\".disabled=false\");\r                  accion(\"formulario.txtNumMaximoGrupoCondicionantes\",\".disabled=false\");\r                } else { \r                  set(\"formulario.ckIndicadorCuadrePorGrupo\",\"N\");\r                  accion(\"formulario.txtNumMaximoGrupoCondicionados\",\".disabled=true\");\r                  accion(\"formulario.txtNumMaximoGrupoCondicionantes\",\".disabled=true\");\r                }\r        \r                if((sel==\"1\") || (sel==\"2\")){ \r                    if((get(\"formulario.opcionMenu\")!=\"Modificar\")&&(get(\"formulario.opcionMenu\")!=\"Consultar\")){\r                      set(\"formulario.rbTipoProducto\",\"1\");\r                    }\r                    document.all[\"rbTipoProducto\"][0].disabled=false;\r                    document.all[\"rbTipoProducto\"][1].disabled=false;\r                    document.all[\"rbTipoProducto\"][2].disabled=false;\r                    document.all[\"rbTipoProducto\"][3].disabled=false;                    \r                      \r                } else { \r                    accion(\"formulario.rbTipoProducto\",\".disabled=true\");\r                    set(\"formulario.rbTipoProducto\",\"\");\r                }\r                \r                                if(((document.all[\"rbTipoProducto\"][0].disabled==true) && (sel!=\"2\") && (sel!=\"6\")) ||\r                   ((document.all[\"rbTipoProducto\"][0].disabled==false) && (get(\"formulario.rbTipoProducto\")==\"1\") && (sel!=\"2\") && (sel!=\"6\"))){ \r                      accion(\"formulario.txtOrdenAsignacionCUV\",\".disabled=false\");\r                } else {\r                      accion(\"formulario.txtOrdenAsignacionCUV\",\".disabled=true\");\r                      set(\"formulario.txtOrdenAsignacionCUV\",\"\");\r                }\r			     }\r		    }\r    }\r\r    function accionGuardar(){\r        var testr = get(\"formulario.cbTipoEstrategia\");\r\r        if (testr == '' ){             if(!sicc_validaciones_generales(\"general\")){return false;}          \r        } \r        if(testr == 1 ){             if(!sicc_validaciones_generales(\"general\")){return false;}         \r        }\r\r        if(testr == 2){             if(!sicc_validaciones_generales(\"general\")){return false;}        \r        }\r\r       if(testr == 3){             if(!sicc_validaciones_generales(\"general,maxgrupo\")){return false;}\r        }\r\r        if(testr == 4){             if(!sicc_validaciones_generales(\"general,maxgrupo,maxgrupocondicionante,maxgrupocondicionado\")){return false;}\r        }\r\r        if(testr == 5){             if(!sicc_validaciones_generales(\"general\")){return false;}\r        }\r        if(testr == 6){             if(!sicc_validaciones_generales(\"general,maxgrupo\")){return false;}\r        }\r        if(testr == 7){             if(!sicc_validaciones_generales(\"general,maxgrupo\")){return false;}        \r        }        \r\r                if(((document.all[\"rbTipoProducto\"][0].disabled==true) && (testr!=\"2\") && (testr!=\"6\")) ||\r           ((document.all[\"rbTipoProducto\"][0].disabled==false) && (get(\"formulario.rbTipoProducto\")==\"1\") && (testr!=\"2\") && (testr!=\"6\"))){ \r           if(!sicc_validaciones_generales(\"cuv\")){return false;}\r        } else {\r           setMV('formulario.txtOrdenAsignacionCUV','N');\r        }\r        \r             \r        if(get(\"formulario.opcionMenu\")!=\"Modificar\"){ \r\r        		set(\"formulario.cbTipoEstrategiaTxt\",get(\"formulario.cbTipoEstrategia\"));\r            	set(\"formulario.accion\", \"Guardar\");\r                set('formulario.conectorAction','LPMantenimientoEstrategias');\r                setVariables();\r                set('formulario.ckCodVentaImprimibles',get('formulario.ckCodVentaImprimibles'));\r                set(\"formulario.txtCodEstrategia\", get(\"formulario.txtCodEstrategia\").toUpperCase());\r\r                enviaSICC('formulario');\r\r        }else{\r                            setVariables();\r        		set(\"formulario.cbTipoEstrategiaTxt\",get(\"formulario.cbTipoEstrategia\"));\r            	set(\"formulario.accion\", \"Guardar\");\r                set('formulario.conectorAction','LPMantenimientoEstrategias');\r                set(\"formulario.txtCodEstrategia\", get(\"formulario.txtCodEstrategia\").toUpperCase());\r                enviaSICC(\"formulario\");\r        \r\r        }\r    } \r\r    function validacionFuncionales(){\r        if(!valida_sumatoriaGrupos()){\r            alert(\"Los grupos son la composicion de los grupos condicionantes y condicionados\")\r        }else{\r            return true;\r        }\r    }\r\r    function valida_sumatoriaGrupos(){\r           var gr       = parseInt(get(\"formulario.txtNumMaximoGrupo\"));\r           var grcdos   = parseInt(get(\"formulario.txtNumMaximoGrupoCondicionados\"));\r           var grctes   = parseInt(get(\"formulario.txtNumMaximoGrupoCondicionantes\"));\r        if((get(\"formulario.txtNumMaximoGrupoCondicionados\") == '') && (get(\"formulario.txtNumMaximoGrupoCondicionantes\") == '') ){\r            return true;\r        }\r        if((grcdos + grctes) <= gr ){\r            return true;\r        }else{\r            return false;\r        }\r            \r    }    \r    function fGuardar(){    \r        accionGuardar();\r    }\r\r    function fLimpiar(){\r        limpiaI18N(\"formulario\", 1 );\r        set(\"formulario.cbTipoEstrategia\",new Array(get(\"formulario.indCvTipoEstrategia\")) ); \r        if(get(\"formulario.opcionMenu\") == 'Insertar'){\r            set(\"formulario.rbTipoProducto\",\"\");\r            restoreComponent();\r            deshabilitaObjects(false, 'ck');       \r            deshabilitaObjects(false, 'txt');\r            deshabilitaRadio(false);\r            tipoEstrategiaOnChange();\r            focaliza(\"formulario.txtCodEstrategia\");\r        }else{\r            seteaTipoProducto(xrbTipoProducto);\r            focaliza(\"formulario.txtDescipcion\");\r        }\r        restoreComponent();\r        \r        \r    }\r\r    function setVariables(){\r        \r        set('formulario.vtxtCodEstrategia',get('formulario.txtCodEstrategia'));\r        set('formulario.vcbTipoEstrategia',get('formulario.cbTipoEstrategia'));\r        set('formulario.vtxtDescipcion',get('formulario.txtDescipcion'));\r        set('formulario.vckEstrategiaGrupo',get('formulario.ckEstrategiaGrupo'));\r        set('formulario.vckSolicitarIndicadorCuadre',get('formulario.ckSolicitarIndicadorCuadre'));\r        set('formulario.vckEstrategiaCondicionada',get('formulario.ckEstrategiaCondicionada'));\r        set('formulario.vckVS',get('formulario.ckVS'));\r        set('formulario.vckPaquetes',get('formulario.ckPaquetes'));        \r        set('formulario.vckListaRanking',get('formulario.ckListaRanking'));                \r        set('formulario.vckSolicitarIndicadorCuadre',get('formulario.ckSolicitarIndicadorCuadre')); \r\r\r        set('formulario.vckCodVentaImprimibles',get('formulario.ckCodVentaImprimibles'));\r        set('formulario.vckModificableImprimibles',get('formulario.ckModificableImprimibles'));\r        set('formulario.vckCodVentaDespachoAutomatico',get('formulario.ckCodVentaDespachoAutomatico'));\r        set('formulario.vckModificableDespachoAutomatico',get('formulario.ckModificableDespachoAutomatico'));        \r        set('formulario.vckCodVentaDigitables',get('formulario.ckCodVentaDigitables'));        \r        set('formulario.vckModificableDigitables',get('formulario.ckModificableDigitables'));\r\r        set('formulario.vtxtNumMaximoGrupo',get('formulario.txtNumMaximoGrupo')); \r        set('formulario.vtxtNumMaximoGrupoCondicionados',get('formulario.txtNumMaximoGrupoCondicionados')); \r        set('formulario.vtxtNumMaximoGrupoCondicionantes',get('formulario.txtNumMaximoGrupoCondicionantes')); \r\r    }\r    \r    function deshabilitaObjects(boole, pattern ){\r        var td2 = document.all.tags(\"INPUT\");\r        for(var i=0;i<td2.length;i++){\r            if(td2.item(i).name.substring(0,pattern.length) == pattern){\r                td2.item(i).disabled=boole;\r            }\r        }\r        \r    }\r    \r    \r    function deshabilitaRadio(boole){\r        document.all[\"rbTipoProducto\"][0].disabled=boole;\r        document.all[\"rbTipoProducto\"][1].disabled=boole;\r        document.all[\"rbTipoProducto\"][2].disabled=boole;\r        document.all[\"rbTipoProducto\"][3].disabled=boole;\r    }\r\r \r    function guardoOk(){\r\r        this.close();\r        fLimpiar();\r    }\r\r    function noGuardo(){    }\r\r    function tabularTXTHasta(tipo, campo){\r                var sel = get(\"formulario.cbTipoEstrategia\");\r        document.selection.empty();\r        if(sel == ''){\r           if(tipo=='shtab' && (campo == 'txtCodEstrategia' || get('formulario.opcionMenu')=='Modificar')){\r           \r                focaliza(\"formulario.cbTipoEstrategia\");\r                return;\r            }else{\r                if(campo == 'txtDescipcion' && get('formulario.opcionMenu')=='Insertar' ){\r                    focaliza('formulario.txtCodEstrategia');\r                    return;\r                }\r            }\r        }\r                if (get('formulario.opcionMenu')=='Modificar' ){\r             if (tipo=='tab'){\r                  focaliza('formulario.txtDescipcion');\r             }else if (tipo=='shtab'){\r                  focaliza('formulario.ckModificableDigitables');\r             }\r        }\r        \r                 if (!(get('formulario.opcionMenu')=='Modificar' || get('formulario.opcionMenu')=='Mostrar datos')){\r             if (tipo=='tab'){\r                  focaliza('formulario.txtCodEstrategia');\r             }else if (tipo=='shtab'){\r                if(campo == 'txtCodEstrategia' ){\r                  focaliza('formulario.ckModificableDigitables');\r                }else{\r                  focaliza('formulario.txtCodEstrategia');\r                }\r             }\r         }\r         \r    }\r\r\r\r\r\r\r    \r    var arrNCheck = new Array();\r    var arrNCombo = new Array();\r    var arrNText = new Array();\r    var arrNrad = new Array();\r    \r    var arrCombos = new Array();\r    var observaciones = '';\r    var activa = '' ;\r         \r    function loadOnInitComponent(){\r             \r         var arrN = new Array();\r         arrN.length = d3_componentes.length;\r             \r         arrNCheck.length = d3_componentes.length;\r         arrNCombo.length = d3_componentes.length;\r         arrNText.length = d3_componentes.length;\r         arrNrad.length = d3_componentes.length;\r    \r         var ich = 0;\r         var ico = 0;\r         var ict = 0;\r         var icr = 0;\r                 \r         for(var j = 0 ; j < d3_componentes.length ; j++) {\r             var tipo = d3_componentes[j][0];\r             var nombre = d3_componentes[j][1];\r                          if(tipo == 'RADIOB') {\r                  arrNrad[ich] =  get(nombre);\r                  icr++;\r\r             }\r             if(tipo == 'CHECKBOX') {\r                  arrNCheck[ich] =  get(nombre);\r                  ich++;\r             }\r             if(tipo == 'CTEXTO') {\r                  arrNText[ict] =  get(nombre);\r                  ict++;\r             }\r             if(tipo == 'COMBO') {\r                  arrNCombo[ico] =  get(nombre);\r                  arrCombos[ico] = nombre;\r                  ico++;\r             }\r\r        }\r        \r    }\r\r\r    \r    function restoreComponent(){\r         var ich = 0;\r         var ico = 0;\r         var ict = 0;\r         var icr = 0;\r        \r         for(var j = 0 ; j < d3_componentes.length ; j++) {\r             var tipo = d3_componentes[j][0];\r\r             var nombre = d3_componentes[j][1];\r             if(tipo == 'RADIOB') {\r                 set(nombre,  arrNrad[ich] );\r                  icr++;\r             }\r             if(tipo == 'CHECKBOX') {\r                 set(nombre,  arrNCheck[ich] );\r                  ich++;\r             }\r             if(tipo == 'CTEXTO') {\r                  if(arrNText[ict] != undefined){    \r                      set(nombre,  arrNText[ict] );\r                  }\r                  ict++;\r             }\r             if(tipo == 'COMBO') {\r                  set(nombre,  arrNCombo[ico] );\r                  ico++;\r             }\r       \r         }\r       \r     }\r\r\r    function validaTab(){\r                var sel = get(\"formulario.cbTipoEstrategia\");\r\r        if(sel == ''){\r            if(get(\"formulario.opcionMenu\")==\"Insertar\"){    \r                focaliza(\"formulario.txtCodEstrategia\");\r            }\r            if(get(\"formulario.opcionMenu\")==\"Modificar\"){    \r                focaliza(\"formulario.txtDescipcion\");\r            }\r        }else{\r            manejaTab('ckEstrategiaGrupo')\r        }        \r    }\r\r\r\r    \r    function manejaTab(campo){\r        if( campo == 'ckEstrategiaGrupo' ){\r    		if( ckEstrategiaCondicionada.disabled == false ){\r        		focaliza('formulario.ckEstrategiaCondicionada');\r            }else{\r                manejaTab('ckEstrategiaCondicionada');\r        	}\r        }else if( campo == 'ckEstrategiaCondicionada' ){\r            if( ckEstrategiaVR.disabled == false ){\r        		focaliza('formulario.ckEstrategiaVR');\r    		}else{\r            	manejaTab('ckEstrategiaVR');\r            }\r		}else if( campo == 'ckEstrategiaVR' ){\r            if( ckEstrategiaPaquetes.disabled == false ){\r                focaliza('formulario.ckEstrategiaPaquetes');\r    		}else{\r        		manejaTab('ckEstrategiaPaquetes');\r    		}   \r        }else if( campo == 'ckEstrategiaPaquetes' ){\r            if( txtNumMaximoGrupo.disabled == false ){\r                focaliza('formulario.txtNumMaximoGrupo');\r    		}else{\r        		manejaTab('txtNumMaximoGrupo');\r    		}\r        }else if( campo == 'txtNumMaximoGrupo' ){\r            if( txtNumMaximoGrupoCondicionados.disabled == false ){\r                focaliza('formulario.txtNumMaximoGrupoCondicionados');\r    		}else{\r        		manejaTab('txtNumMaximoGrupoCondicionados');\r    		}\r        }else if( campo == 'txtNumMaximoGrupoCondicionados' ){\r            if( txtNumMaximoGrupoCondicionantes.disabled == false ){\r                focaliza('formulario.txtNumMaximoGrupoCondicionantes');\r    		}else{\r        		manejaTab('txtNumMaximoGrupoCondicionantes');\r    		}\r        }else{  \r            focaliza('formulario.ckCodVentaImprimibles');\r        }\r        \r    }\r\r    function fVolver(){\r        this.close();\r    }\r  \r\r     \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(5)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtCodEstrategia" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","2592" );
      ((Element)v.get(8)).setAttribute("group","general" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtDescipcion" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","9" );
      ((Element)v.get(9)).setAttribute("group","general" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbTipoEstrategia" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","460" );
      ((Element)v.get(10)).setAttribute("group","general" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtNumMaximoGrupo" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","2597" );
      ((Element)v.get(11)).setAttribute("format","e" );
      ((Element)v.get(11)).setAttribute("min","1" );
      ((Element)v.get(11)).setAttribute("max","99" );
      ((Element)v.get(11)).setAttribute("group","maxgrupo" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtNumMaximoGrupoCondicionados" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","2599" );
      ((Element)v.get(12)).setAttribute("format","e" );
      ((Element)v.get(12)).setAttribute("min","1" );
      ((Element)v.get(12)).setAttribute("max","99" );
      ((Element)v.get(12)).setAttribute("group","maxgrupocondicionado" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtNumMaximoGrupoCondicionantes" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","2598" );
      ((Element)v.get(13)).setAttribute("format","e" );
      ((Element)v.get(13)).setAttribute("min","1" );
      ((Element)v.get(13)).setAttribute("max","99" );
      ((Element)v.get(13)).setAttribute("group","maxgrupocondicionante" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtOrdenAsignacionCUV" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","3035" );
      ((Element)v.get(14)).setAttribute("format","e" );
      ((Element)v.get(14)).setAttribute("min","0" );
      ((Element)v.get(14)).setAttribute("max","99" );
      ((Element)v.get(14)).setAttribute("group","cuv" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:7   */
      /* Termina nodo:5   */

      /* Empieza nodo:15 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(15)).setAttribute("nombre","formulario" );
      ((Element)v.get(15)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","accion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 15   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","acciones" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","idioma" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","pais" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(20)).setAttribute("valor","LPMantenimientoEstrategias" );
      ((Element)v.get(15)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","cbTipoEstrategiaTxt" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","indgrupo" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","indcondi" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","indvs" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","indpaq" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","indlista" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","indCGru" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","indCvimp" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","indMImp" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","indCvDesp" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","indMDesp" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","indCvDig" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","indMDig" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","indCvTipoEstrategia" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","tipoCli" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","oidEstr" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","ORDEN_COMPRA" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","REEMPLAZO" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","ALTERNATIVO" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","RECUPERACION" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","vtxtCodEstrategia" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","vcbTipoEstrategia" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","vtxtDescipcion" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","vckEstrategiaGrupo" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","vckSolicitarIndicadorCuadre" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","vckEstrategiaCondicionada" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","vckVS" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","vckPaquetes" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","vckListaRanking" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","vckSolicitarIndicadorCuadre" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","vtxtNumMaximoGrupoCondicionantes" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","vtxtNumMaximoGrupoCondicionados" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","vtxtNumMaximoGrupo" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","vckCodVentaImprimibles" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","vckModificableImprimibles" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","vckCodVentaDigitables" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","vckModificableDigitables" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 15   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","vckCodVentaDespachoAutomatico" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 15   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","vckModificableDespachoAutomatico" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(15)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 15   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(64)).setAttribute("nombre","capa1" );
      ((Element)v.get(15)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("table"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(65)).setAttribute("border","0" );
      ((Element)v.get(65)).setAttribute("cellspacing","0" );
      ((Element)v.get(65)).setAttribute("cellpadding","0" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","12" );
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","12" );
      ((Element)v.get(68)).setAttribute("height","12" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","750" );
      ((Element)v.get(66)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","12" );
      ((Element)v.get(66)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","12" );
      ((Element)v.get(72)).setAttribute("height","1" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:66   */

      /* Empieza nodo:73 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(78)).setAttribute("class","legend" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(79)).setAttribute("nombre","lblDatosAlta" );
      ((Element)v.get(79)).setAttribute("alto","13" );
      ((Element)v.get(79)).setAttribute("filas","1" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(79)).setAttribute("id","legend" );
      ((Element)v.get(79)).setAttribute("cod","00127" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(80)).setAttribute("width","100%" );
      ((Element)v.get(80)).setAttribute("border","0" );
      ((Element)v.get(80)).setAttribute("align","center" );
      ((Element)v.get(80)).setAttribute("cellspacing","0" );
      ((Element)v.get(80)).setAttribute("cellpadding","0" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("table"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(83)).setAttribute("border","0" );
      ((Element)v.get(83)).setAttribute("align","center" );
      ((Element)v.get(83)).setAttribute("cellspacing","0" );
      ((Element)v.get(83)).setAttribute("cellpadding","0" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("colspan","4" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:87 / Elemento padre: 83   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(83)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(91)).setAttribute("nombre","lblCodEstrategia" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("id","datosTitle" );
      ((Element)v.get(91)).setAttribute("cod","2592" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","25" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("colspan","3" );
      ((Element)v.get(87)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(95)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(95)).setAttribute("alto","13" );
      ((Element)v.get(95)).setAttribute("filas","1" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("id","datosTitle" );
      ((Element)v.get(95)).setAttribute("cod","9" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(87)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:87   */

      /* Empieza nodo:98 / Elemento padre: 83   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(83)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(98)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(102)).setAttribute("nombre","txtCodEstrategia" );
      ((Element)v.get(102)).setAttribute("id","datosCampos" );
      ((Element)v.get(102)).setAttribute("max","3" );
      ((Element)v.get(102)).setAttribute("tipo","" );
      ((Element)v.get(102)).setAttribute("onchange","" );
      ((Element)v.get(102)).setAttribute("req","S" );
      ((Element)v.get(102)).setAttribute("size","3" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("validacion","" );
      ((Element)v.get(102)).setAttribute("onshtab","tabularTXTHasta('shtab', 'txtCodEstrategia')" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","25" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(98)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(106)).setAttribute("nombre","txtDescipcion" );
      ((Element)v.get(106)).setAttribute("id","datosCampos" );
      ((Element)v.get(106)).setAttribute("max","30" );
      ((Element)v.get(106)).setAttribute("tipo","" );
      ((Element)v.get(106)).setAttribute("onchange","" );
      ((Element)v.get(106)).setAttribute("req","S" );
      ((Element)v.get(106)).setAttribute("size","30" );
      ((Element)v.get(106)).setAttribute("valor","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(106)).setAttribute("validacion","" );
      ((Element)v.get(106)).setAttribute("onshtab","tabularTXTHasta('shtab','txtDescipcion')" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(110)).setAttribute("onclick","levantarI18N('formulario','1');" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(98)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:98   */

      /* Empieza nodo:113 / Elemento padre: 83   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(83)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("colspan","4" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:116 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("table"));
      ((Element)v.get(118)).setAttribute("width","100%" );
      ((Element)v.get(118)).setAttribute("border","0" );
      ((Element)v.get(118)).setAttribute("align","center" );
      ((Element)v.get(118)).setAttribute("cellspacing","0" );
      ((Element)v.get(118)).setAttribute("cellpadding","0" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(123)).setAttribute("nombre","lblTipoEstrategia" );
      ((Element)v.get(123)).setAttribute("alto","13" );
      ((Element)v.get(123)).setAttribute("filas","1" );
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(123)).setAttribute("id","datosTitle" );
      ((Element)v.get(123)).setAttribute("cod","460" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","25" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(127)).setAttribute("nombre","lblEstrategiaGrupo" );
      ((Element)v.get(127)).setAttribute("alto","13" );
      ((Element)v.get(127)).setAttribute("filas","1" );
      ((Element)v.get(127)).setAttribute("valor","" );
      ((Element)v.get(127)).setAttribute("id","datosTitle" );
      ((Element)v.get(127)).setAttribute("cod","2593" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","25" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblEstrategiaCondicionada" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("id","datosTitle" );
      ((Element)v.get(131)).setAttribute("cod","2594" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","25" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblEstrategiaVR" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("id","datosTitle" );
      ((Element)v.get(135)).setAttribute("cod","2595" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","25" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(139)).setAttribute("nombre","lblEstrategiaPaquetes" );
      ((Element)v.get(139)).setAttribute("alto","13" );
      ((Element)v.get(139)).setAttribute("filas","1" );
      ((Element)v.get(139)).setAttribute("valor","" );
      ((Element)v.get(139)).setAttribute("id","datosTitle" );
      ((Element)v.get(139)).setAttribute("cod","2596" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","100%" );
      ((Element)v.get(119)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:119   */

      /* Empieza nodo:142 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(142)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(146)).setAttribute("nombre","cbTipoEstrategia" );
      ((Element)v.get(146)).setAttribute("id","datosCampos" );
      ((Element)v.get(146)).setAttribute("size","1" );
      ((Element)v.get(146)).setAttribute("multiple","N" );
      ((Element)v.get(146)).setAttribute("req","S" );
      ((Element)v.get(146)).setAttribute("onchange","tipoEstrategiaOnChange();focaliza('formulario.cbTipoEstrategia');" );
      ((Element)v.get(146)).setAttribute("valorinicial","" );
      ((Element)v.get(146)).setAttribute("textoinicial","" );
      ((Element)v.get(146)).setAttribute("ontab","validaTab()" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:148 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","25" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(142)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(151)).setAttribute("check","" );
      ((Element)v.get(151)).setAttribute("id","" );
      ((Element)v.get(151)).setAttribute("msjreq","" );
      ((Element)v.get(151)).setAttribute("nombre","ckEstrategiaGrupo" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(151)).setAttribute("onclick","" );
      ((Element)v.get(151)).setAttribute("onfocus","" );
      ((Element)v.get(151)).setAttribute("readonly","" );
      ((Element)v.get(151)).setAttribute("req","" );
      ((Element)v.get(151)).setAttribute("tabindex","1" );
      ((Element)v.get(151)).setAttribute("texto","" );
      ((Element)v.get(151)).setAttribute("validacion","" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","25" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(142)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(155)).setAttribute("check","" );
      ((Element)v.get(155)).setAttribute("id","" );
      ((Element)v.get(155)).setAttribute("msjreq","" );
      ((Element)v.get(155)).setAttribute("nombre","ckEstrategiaCondicionada" );
      ((Element)v.get(155)).setAttribute("onclick","" );
      ((Element)v.get(155)).setAttribute("onfocus","" );
      ((Element)v.get(155)).setAttribute("readonly","" );
      ((Element)v.get(155)).setAttribute("req","" );
      ((Element)v.get(155)).setAttribute("tabindex","1" );
      ((Element)v.get(155)).setAttribute("texto","" );
      ((Element)v.get(155)).setAttribute("validacion","" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","25" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(142)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(159)).setAttribute("check","" );
      ((Element)v.get(159)).setAttribute("id","" );
      ((Element)v.get(159)).setAttribute("msjreq","" );
      ((Element)v.get(159)).setAttribute("nombre","ckEstrategiaVR" );
      ((Element)v.get(159)).setAttribute("onclick","" );
      ((Element)v.get(159)).setAttribute("onfocus","" );
      ((Element)v.get(159)).setAttribute("readonly","" );
      ((Element)v.get(159)).setAttribute("req","" );
      ((Element)v.get(159)).setAttribute("tabindex","1" );
      ((Element)v.get(159)).setAttribute("texto","" );
      ((Element)v.get(159)).setAttribute("validacion","" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","25" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(142)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(163)).setAttribute("check","" );
      ((Element)v.get(163)).setAttribute("id","" );
      ((Element)v.get(163)).setAttribute("msjreq","" );
      ((Element)v.get(163)).setAttribute("nombre","ckEstrategiaPaquetes" );
      ((Element)v.get(163)).setAttribute("onclick","" );
      ((Element)v.get(163)).setAttribute("onfocus","" );
      ((Element)v.get(163)).setAttribute("readonly","" );
      ((Element)v.get(163)).setAttribute("req","" );
      ((Element)v.get(163)).setAttribute("tabindex","1" );
      ((Element)v.get(163)).setAttribute("texto","" );
      ((Element)v.get(163)).setAttribute("validacion","" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","100%" );
      ((Element)v.get(142)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:142   */

      /* Empieza nodo:166 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("colspan","4" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:169 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("table"));
      ((Element)v.get(171)).setAttribute("width","100%" );
      ((Element)v.get(171)).setAttribute("border","0" );
      ((Element)v.get(171)).setAttribute("align","center" );
      ((Element)v.get(171)).setAttribute("cellspacing","0" );
      ((Element)v.get(171)).setAttribute("cellpadding","0" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

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
      ((Element)v.get(176)).setAttribute("nombre","lblNumMaximoGrupo" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","2597" );
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
      ((Element)v.get(180)).setAttribute("nombre","lblNumMaximoGrupoCondicionantes" );
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("filas","1" );
      ((Element)v.get(180)).setAttribute("valor","" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("cod","2598" );
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
      ((Element)v.get(184)).setAttribute("nombre","lblNumMaximoGrupoCondicionados" );
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","2599" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:172   */

      /* Empieza nodo:187 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","8" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(187)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("CTEXTO"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(191)).setAttribute("nombre","txtNumMaximoGrupo" );
      ((Element)v.get(191)).setAttribute("id","datosCampos" );
      ((Element)v.get(191)).setAttribute("max","2" );
      ((Element)v.get(191)).setAttribute("tipo","" );
      ((Element)v.get(191)).setAttribute("onchange","" );
      ((Element)v.get(191)).setAttribute("req","N" );
      ((Element)v.get(191)).setAttribute("size","2" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("validacion","" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","25" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(187)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(195)).setAttribute("nombre","txtNumMaximoGrupoCondicionantes" );
      ((Element)v.get(195)).setAttribute("id","datosCampos" );
      ((Element)v.get(195)).setAttribute("max","2" );
      ((Element)v.get(195)).setAttribute("tipo","" );
      ((Element)v.get(195)).setAttribute("onchange","" );
      ((Element)v.get(195)).setAttribute("req","N" );
      ((Element)v.get(195)).setAttribute("size","2" );
      ((Element)v.get(195)).setAttribute("valor","" );
      ((Element)v.get(195)).setAttribute("validacion","" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","25" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(187)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(199)).setAttribute("nombre","txtNumMaximoGrupoCondicionados" );
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(199)).setAttribute("max","2" );
      ((Element)v.get(199)).setAttribute("tipo","" );
      ((Element)v.get(199)).setAttribute("onchange","" );
      ((Element)v.get(199)).setAttribute("req","N" );
      ((Element)v.get(199)).setAttribute("size","2" );
      ((Element)v.get(199)).setAttribute("valor","" );
      ((Element)v.get(199)).setAttribute("validacion","" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("width","100%" );
      ((Element)v.get(187)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:187   */

      /* Empieza nodo:202 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("colspan","4" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:205 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("table"));
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(207)).setAttribute("border","0" );
      ((Element)v.get(207)).setAttribute("align","center" );
      ((Element)v.get(207)).setAttribute("cellspacing","0" );
      ((Element)v.get(207)).setAttribute("cellpadding","0" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","8" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 208   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(212)).setAttribute("nombre","lblListaRanking" );
      ((Element)v.get(212)).setAttribute("alto","13" );
      ((Element)v.get(212)).setAttribute("filas","1" );
      ((Element)v.get(212)).setAttribute("valor","" );
      ((Element)v.get(212)).setAttribute("id","datosTitle" );
      ((Element)v.get(212)).setAttribute("cod","2600" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","25" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(216)).setAttribute("nombre","lblIndicadorCuadrePorGrupo" );
      ((Element)v.get(216)).setAttribute("alto","13" );
      ((Element)v.get(216)).setAttribute("filas","1" );
      ((Element)v.get(216)).setAttribute("valor","" );
      ((Element)v.get(216)).setAttribute("id","datosTitle" );
      ((Element)v.get(216)).setAttribute("cod","2601" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","25" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(220)).setAttribute("nombre","lblTipoProducto" );
      ((Element)v.get(220)).setAttribute("alto","13" );
      ((Element)v.get(220)).setAttribute("filas","1" );
      ((Element)v.get(220)).setAttribute("valor","Tipo producto" );
      ((Element)v.get(220)).setAttribute("id","datosTitle" );
      ((Element)v.get(220)).setAttribute("cod","2602" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 208   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("width","100%" );
      ((Element)v.get(208)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:208   */

      /* Empieza nodo:223 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(223)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(227)).setAttribute("check","" );
      ((Element)v.get(227)).setAttribute("id","" );
      ((Element)v.get(227)).setAttribute("msjreq","" );
      ((Element)v.get(227)).setAttribute("nombre","ckListaRanking" );
      ((Element)v.get(227)).setAttribute("onclick","" );
      ((Element)v.get(227)).setAttribute("onfocus","" );
      ((Element)v.get(227)).setAttribute("readonly","" );
      ((Element)v.get(227)).setAttribute("req","" );
      ((Element)v.get(227)).setAttribute("tabindex","1" );
      ((Element)v.get(227)).setAttribute("texto","" );
      ((Element)v.get(227)).setAttribute("validacion","" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","25" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(223)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(231)).setAttribute("check","" );
      ((Element)v.get(231)).setAttribute("id","" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(231)).setAttribute("msjreq","" );
      ((Element)v.get(231)).setAttribute("nombre","ckIndicadorCuadrePorGrupo" );
      ((Element)v.get(231)).setAttribute("onclick","" );
      ((Element)v.get(231)).setAttribute("onfocus","" );
      ((Element)v.get(231)).setAttribute("readonly","" );
      ((Element)v.get(231)).setAttribute("req","" );
      ((Element)v.get(231)).setAttribute("tabindex","1" );
      ((Element)v.get(231)).setAttribute("texto","" );
      ((Element)v.get(231)).setAttribute("validacion","" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","25" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("class","datosCampos" );
      ((Element)v.get(234)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(223)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("table"));
      ((Element)v.get(235)).setAttribute("width","100%" );
      ((Element)v.get(235)).setAttribute("border","0" );
      ((Element)v.get(235)).setAttribute("cellspacing","0" );
      ((Element)v.get(235)).setAttribute("cellpadding","0" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(238)).setAttribute("nombre","rbTipoProducto" );
      ((Element)v.get(238)).setAttribute("tipo","H" );
      ((Element)v.get(238)).setAttribute("id","datosCampos" );
      ((Element)v.get(238)).setAttribute("onclick","cambioTipoProd();" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(239)).setAttribute("valor","1" );
      ((Element)v.get(239)).setAttribute("onfocus","" );
      ((Element)v.get(239)).setAttribute("id","datosCampos" );
      ((Element)v.get(239)).setAttribute("cod","2603" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 238   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(240)).setAttribute("valor","3" );
      ((Element)v.get(240)).setAttribute("onfocus","" );
      ((Element)v.get(240)).setAttribute("id","datosCampos" );
      ((Element)v.get(240)).setAttribute("cod","2604" );
      ((Element)v.get(238)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 238   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(241)).setAttribute("valor","2" );
      ((Element)v.get(241)).setAttribute("onfocus","" );
      ((Element)v.get(241)).setAttribute("id","datosCampos" );
      ((Element)v.get(241)).setAttribute("cod","2605" );
      ((Element)v.get(238)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 238   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(242)).setAttribute("valor","4" );
      ((Element)v.get(242)).setAttribute("onfocus","" );
      ((Element)v.get(242)).setAttribute("id","datosCampos" );
      ((Element)v.get(242)).setAttribute("cod","2606" );
      ((Element)v.get(238)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:243 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("width","100%" );
      ((Element)v.get(223)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","8" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:223   */

      /* Empieza nodo:245 / Elemento padre: 207   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(207)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).setAttribute("colspan","4" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","8" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:248 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("table"));
      ((Element)v.get(250)).setAttribute("width","100%" );
      ((Element)v.get(250)).setAttribute("border","0" );
      ((Element)v.get(250)).setAttribute("align","center" );
      ((Element)v.get(250)).setAttribute("cellspacing","0" );
      ((Element)v.get(250)).setAttribute("cellpadding","0" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","8" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(255)).setAttribute("nombre","lblOrdenAsignacionCUV" );
      ((Element)v.get(255)).setAttribute("alto","13" );
      ((Element)v.get(255)).setAttribute("filas","1" );
      ((Element)v.get(255)).setAttribute("valor","" );
      ((Element)v.get(255)).setAttribute("id","datosTitle" );
      ((Element)v.get(255)).setAttribute("cod","3035" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("width","100%" );
      ((Element)v.get(251)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:251   */

      /* Empieza nodo:258 / Elemento padre: 250   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(250)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","8" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(258)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(262)).setAttribute("nombre","txtOrdenAsignacionCUV" );
      ((Element)v.get(262)).setAttribute("id","datosCampos" );
      ((Element)v.get(262)).setAttribute("max","2" );
      ((Element)v.get(262)).setAttribute("tipo","" );
      ((Element)v.get(262)).setAttribute("onchange","" );
      ((Element)v.get(262)).setAttribute("req","S" );
      ((Element)v.get(262)).setAttribute("size","2" );
      ((Element)v.get(262)).setAttribute("valor","" );
      ((Element)v.get(262)).setAttribute("validacion","" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 258   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).setAttribute("width","100%" );
      ((Element)v.get(258)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","8" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:258   */

      /* Empieza nodo:265 / Elemento padre: 250   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(250)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("colspan","4" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(267)).setAttribute("height","15" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:268 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(80)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("table"));
      ((Element)v.get(270)).setAttribute("width","100%" );
      ((Element)v.get(270)).setAttribute("border","0" );
      ((Element)v.get(270)).setAttribute("align","center" );
      ((Element)v.get(270)).setAttribute("cellspacing","0" );
      ((Element)v.get(270)).setAttribute("cellpadding","0" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("td"));
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","12" );
      ((Element)v.get(273)).setAttribute("height","12" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 271   */
      v.add(doc.createElement("td"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(274)).setAttribute("width","100%" );
      ((Element)v.get(271)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("table"));
      ((Element)v.get(275)).setAttribute("width","100%" );
      ((Element)v.get(275)).setAttribute("border","0" );
      ((Element)v.get(275)).setAttribute("cellspacing","0" );
      ((Element)v.get(275)).setAttribute("cellpadding","0" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("td"));
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(279)).setAttribute("class","legend" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(280)).setAttribute("nombre","lblEtiqueta" );
      ((Element)v.get(280)).setAttribute("alto","13" );
      ((Element)v.get(280)).setAttribute("filas","1" );
      ((Element)v.get(280)).setAttribute("valor","" );
      ((Element)v.get(280)).setAttribute("id","legend" );
      ((Element)v.get(280)).setAttribute("cod","00630" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 278   */
      v.add(doc.createElement("table"));
      ((Element)v.get(281)).setAttribute("width","100%" );
      ((Element)v.get(281)).setAttribute("border","0" );
      ((Element)v.get(281)).setAttribute("align","center" );
      ((Element)v.get(281)).setAttribute("cellspacing","0" );
      ((Element)v.get(281)).setAttribute("cellpadding","0" );
      ((Element)v.get(278)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).setAttribute("colspan","3" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","8" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:285 / Elemento padre: 281   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(281)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","8" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(289)).setAttribute("nombre","lblCodVentaImprimibles" );
      ((Element)v.get(289)).setAttribute("alto","13" );
      ((Element)v.get(289)).setAttribute("filas","1" );
      ((Element)v.get(289)).setAttribute("valor","" );
      ((Element)v.get(289)).setAttribute("id","datosTitle" );
      ((Element)v.get(289)).setAttribute("cod","2607" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","25" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(293)).setAttribute("nombre","lblModificableImprimibles" );
      ((Element)v.get(293)).setAttribute("alto","13" );
      ((Element)v.get(293)).setAttribute("filas","1" );
      ((Element)v.get(293)).setAttribute("valor","" );
      ((Element)v.get(293)).setAttribute("id","datosTitle" );
      ((Element)v.get(293)).setAttribute("cod","914" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","25" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(297)).setAttribute("nombre","lblCodVentaDespachoAutomatico" );
      ((Element)v.get(297)).setAttribute("alto","13" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(297)).setAttribute("filas","1" );
      ((Element)v.get(297)).setAttribute("valor","" );
      ((Element)v.get(297)).setAttribute("id","datosTitle" );
      ((Element)v.get(297)).setAttribute("cod","2608" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","25" );
      ((Element)v.get(299)).setAttribute("height","8" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(301)).setAttribute("nombre","lblModificableDespachoAutomatico" );
      ((Element)v.get(301)).setAttribute("alto","13" );
      ((Element)v.get(301)).setAttribute("filas","1" );
      ((Element)v.get(301)).setAttribute("valor","" );
      ((Element)v.get(301)).setAttribute("id","datosTitle" );
      ((Element)v.get(301)).setAttribute("cod","914" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).setAttribute("width","25" );
      ((Element)v.get(303)).setAttribute("height","8" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(305)).setAttribute("nombre","lblCodVentaDigitables" );
      ((Element)v.get(305)).setAttribute("alto","13" );
      ((Element)v.get(305)).setAttribute("filas","1" );
      ((Element)v.get(305)).setAttribute("valor","" );
      ((Element)v.get(305)).setAttribute("id","datosTitle" );
      ((Element)v.get(305)).setAttribute("cod","2609" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","25" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(309)).setAttribute("nombre","lblModificableDigitables" );
      ((Element)v.get(309)).setAttribute("alto","13" );
      ((Element)v.get(309)).setAttribute("filas","1" );
      ((Element)v.get(309)).setAttribute("valor","" );
      ((Element)v.get(309)).setAttribute("id","datosTitle" );
      ((Element)v.get(309)).setAttribute("cod","914" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).setAttribute("width","100%" );
      ((Element)v.get(285)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","8" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:285   */

      /* Empieza nodo:312 / Elemento padre: 281   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(281)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","8" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(312)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(316)).setAttribute("check","" );
      ((Element)v.get(316)).setAttribute("id","" );
      ((Element)v.get(316)).setAttribute("msjreq","" );
      ((Element)v.get(316)).setAttribute("nombre","ckCodVentaImprimibles" );
      ((Element)v.get(316)).setAttribute("onclick","" );
      ((Element)v.get(316)).setAttribute("onfocus","" );
      ((Element)v.get(316)).setAttribute("readonly","" );
      ((Element)v.get(316)).setAttribute("req","" );
      ((Element)v.get(316)).setAttribute("tabindex","1" );
      ((Element)v.get(316)).setAttribute("texto","" );
      ((Element)v.get(316)).setAttribute("validacion","" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(312)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","25" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(312)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(320)).setAttribute("check","" );
      ((Element)v.get(320)).setAttribute("id","" );
      ((Element)v.get(320)).setAttribute("msjreq","" );
      ((Element)v.get(320)).setAttribute("nombre","ckModificableImprimibles" );
      ((Element)v.get(320)).setAttribute("onclick","" );
      ((Element)v.get(320)).setAttribute("onfocus","" );
      ((Element)v.get(320)).setAttribute("readonly","" );
      ((Element)v.get(320)).setAttribute("req","" );
      ((Element)v.get(320)).setAttribute("tabindex","1" );
      ((Element)v.get(320)).setAttribute("texto","" );
      ((Element)v.get(320)).setAttribute("validacion","" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","25" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(312)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(324)).setAttribute("check","" );
      ((Element)v.get(324)).setAttribute("id","" );
      ((Element)v.get(324)).setAttribute("msjreq","" );
      ((Element)v.get(324)).setAttribute("nombre","ckCodVentaDespachoAutomatico" );
      ((Element)v.get(324)).setAttribute("onclick","" );
      ((Element)v.get(324)).setAttribute("onfocus","" );
      ((Element)v.get(324)).setAttribute("readonly","" );
      ((Element)v.get(324)).setAttribute("req","" );
      ((Element)v.get(324)).setAttribute("tabindex","1" );
      ((Element)v.get(324)).setAttribute("texto","" );
      ((Element)v.get(324)).setAttribute("validacion","" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","25" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(312)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(328)).setAttribute("check","" );
      ((Element)v.get(328)).setAttribute("id","" );
      ((Element)v.get(328)).setAttribute("msjreq","" );
      ((Element)v.get(328)).setAttribute("nombre","ckModificableDespachoAutomatico" );
      ((Element)v.get(328)).setAttribute("onclick","" );
      ((Element)v.get(328)).setAttribute("onfocus","" );
      ((Element)v.get(328)).setAttribute("readonly","" );
      ((Element)v.get(328)).setAttribute("req","" );
      ((Element)v.get(328)).setAttribute("tabindex","1" );
      ((Element)v.get(328)).setAttribute("texto","" );
      ((Element)v.get(328)).setAttribute("validacion","" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","25" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(312)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(332)).setAttribute("check","" );
      ((Element)v.get(332)).setAttribute("id","" );
      ((Element)v.get(332)).setAttribute("msjreq","" );
      ((Element)v.get(332)).setAttribute("nombre","ckCodVentaDigitables" );
      ((Element)v.get(332)).setAttribute("onclick","" );
      ((Element)v.get(332)).setAttribute("onfocus","" );
      ((Element)v.get(332)).setAttribute("readonly","" );
      ((Element)v.get(332)).setAttribute("req","" );
      ((Element)v.get(332)).setAttribute("tabindex","1" );
      ((Element)v.get(332)).setAttribute("texto","" );
      ((Element)v.get(332)).setAttribute("validacion","" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","25" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(312)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(336)).setAttribute("check","" );
      ((Element)v.get(336)).setAttribute("id","" );
      ((Element)v.get(336)).setAttribute("msjreq","" );
      ((Element)v.get(336)).setAttribute("nombre","ckModificableDigitables" );
      ((Element)v.get(336)).setAttribute("onclick","" );
      ((Element)v.get(336)).setAttribute("onfocus","" );
      ((Element)v.get(336)).setAttribute("ontab","tabularTXTHasta('tab','ckModificableDigitables')" );
      ((Element)v.get(336)).setAttribute("readonly","" );
      ((Element)v.get(336)).setAttribute("req","" );
      ((Element)v.get(336)).setAttribute("tabindex","1" );
      ((Element)v.get(336)).setAttribute("texto","" );
      ((Element)v.get(336)).setAttribute("validacion","" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("width","100%" );
      ((Element)v.get(312)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:312   */

      /* Empieza nodo:339 / Elemento padre: 281   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(281)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(340)).setAttribute("colspan","3" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:281   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:342 / Elemento padre: 271   */
      v.add(doc.createElement("td"));
      ((Element)v.get(271)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","12" );
      ((Element)v.get(343)).setAttribute("height","12" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:271   */

      /* Empieza nodo:344 / Elemento padre: 270   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(270)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).setAttribute("colspan","4" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","12" );
      ((Element)v.get(346)).setAttribute("height","12" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:80   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:347 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:73   */

      /* Empieza nodo:349 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(350)).setAttribute("width","12" );
      ((Element)v.get(350)).setAttribute("align","center" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","12" );
      ((Element)v.get(351)).setAttribute("height","12" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).setAttribute("width","750" );
      ((Element)v.get(349)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(354)).setAttribute("width","12" );
      ((Element)v.get(349)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","12" );
      ((Element)v.get(355)).setAttribute("height","1" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:349   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:356 / Elemento padre: 15   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(356)).setAttribute("nombre","capa2" );
      ((Element)v.get(356)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(15)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(357)).setAttribute("nombre","listaEstrategia" );
      ((Element)v.get(357)).setAttribute("ancho","703" );
      ((Element)v.get(357)).setAttribute("alto","299" );
      ((Element)v.get(357)).setAttribute("x","12" );
      ((Element)v.get(357)).setAttribute("y","0" );
      ((Element)v.get(357)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(357)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(358)).setAttribute("precarga","S" );
      ((Element)v.get(358)).setAttribute("conROver","S" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(359)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(359)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(359)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(359)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 358   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(360)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(360)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(360)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(360)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(358)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */

      /* Empieza nodo:361 / Elemento padre: 358   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(361)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(361)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(358)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:358   */

      /* Empieza nodo:362 / Elemento padre: 357   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(357)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(363)).setAttribute("borde","1" );
      ((Element)v.get(363)).setAttribute("horizDatos","1" );
      ((Element)v.get(363)).setAttribute("horizCabecera","1" );
      ((Element)v.get(363)).setAttribute("vertical","1" );
      ((Element)v.get(363)).setAttribute("horizTitulo","1" );
      ((Element)v.get(363)).setAttribute("horizBase","1" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 362   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(364)).setAttribute("borde","#999999" );
      ((Element)v.get(364)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(364)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(364)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(364)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(364)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(364)).setAttribute("horizBase","#999999" );
      ((Element)v.get(362)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:362   */

      /* Empieza nodo:365 / Elemento padre: 357   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(365)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(365)).setAttribute("alto","22" );
      ((Element)v.get(365)).setAttribute("imgFondo","" );
      ((Element)v.get(365)).setAttribute("cod","00135" );
      ((Element)v.get(365)).setAttribute("ID","datosTitle" );
      ((Element)v.get(357)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 357   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(366)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(366)).setAttribute("alto","22" );
      ((Element)v.get(366)).setAttribute("imgFondo","" );
      ((Element)v.get(357)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 357   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(367)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(367)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(367)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(367)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(367)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(367)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(357)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("ancho","180" );
      ((Element)v.get(368)).setAttribute("minimizable","S" );
      ((Element)v.get(368)).setAttribute("minimizada","N" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 367   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(369)).setAttribute("ancho","100" );
      ((Element)v.get(369)).setAttribute("minimizable","S" );
      ((Element)v.get(369)).setAttribute("minimizada","N" );
      ((Element)v.get(367)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 367   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(370)).setAttribute("ancho","100" );
      ((Element)v.get(370)).setAttribute("minimizable","S" );
      ((Element)v.get(370)).setAttribute("minimizada","N" );
      ((Element)v.get(367)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 367   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(371)).setAttribute("ancho","100" );
      ((Element)v.get(371)).setAttribute("minimizable","S" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(371)).setAttribute("minimizada","N" );
      ((Element)v.get(367)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 367   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(372)).setAttribute("ancho","100" );
      ((Element)v.get(372)).setAttribute("minimizable","S" );
      ((Element)v.get(372)).setAttribute("minimizada","N" );
      ((Element)v.get(367)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:367   */

      /* Empieza nodo:373 / Elemento padre: 357   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(373)).setAttribute("alto","20" );
      ((Element)v.get(373)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(373)).setAttribute("imgFondo","" );
      ((Element)v.get(373)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(357)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(374)).setAttribute("colFondo","" );
      ((Element)v.get(374)).setAttribute("ID","EstCab" );
      ((Element)v.get(374)).setAttribute("cod","460" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(375)).setAttribute("colFondo","" );
      ((Element)v.get(375)).setAttribute("ID","EstCab" );
      ((Element)v.get(375)).setAttribute("cod","2592" );
      ((Element)v.get(373)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */

      /* Empieza nodo:376 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(376)).setAttribute("colFondo","" );
      ((Element)v.get(376)).setAttribute("ID","EstCab" );
      ((Element)v.get(376)).setAttribute("cod","9" );
      ((Element)v.get(373)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("colFondo","" );
      ((Element)v.get(377)).setAttribute("ID","EstCab" );
      ((Element)v.get(377)).setAttribute("cod","9" );
      ((Element)v.get(373)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 373   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(378)).setAttribute("colFondo","" );
      ((Element)v.get(378)).setAttribute("ID","EstCab" );
      ((Element)v.get(378)).setAttribute("cod","9" );
      ((Element)v.get(373)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:373   */

      /* Empieza nodo:379 / Elemento padre: 357   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(379)).setAttribute("alto","22" );
      ((Element)v.get(379)).setAttribute("accion","" );
      ((Element)v.get(379)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(379)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(379)).setAttribute("maxSel","-1" );
      ((Element)v.get(379)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(379)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(379)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(379)).setAttribute("onLoad","" );
      ((Element)v.get(379)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(357)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(380)).setAttribute("tipo","texto" );
      ((Element)v.get(380)).setAttribute("ID","EstDat" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 379   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("tipo","texto" );
      ((Element)v.get(381)).setAttribute("ID","EstDat2" );
      ((Element)v.get(379)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 379   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("tipo","texto" );
      ((Element)v.get(382)).setAttribute("ID","EstDat" );
      ((Element)v.get(379)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 379   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("tipo","texto" );
      ((Element)v.get(383)).setAttribute("ID","EstDat" );
      ((Element)v.get(379)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */

      /* Empieza nodo:384 / Elemento padre: 379   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(384)).setAttribute("tipo","texto" );
      ((Element)v.get(384)).setAttribute("ID","EstDat" );
      ((Element)v.get(379)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:379   */

      /* Empieza nodo:385 / Elemento padre: 357   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(357)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:15   */


   }

}
