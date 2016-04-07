
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_base_calculo_crear  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1710(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_base_calculo_crear" );
      ((Element)v.get(0)).setAttribute("cod","0664" );
      ((Element)v.get(0)).setAttribute("titulo","Ingresar valores de descuento" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \rvar arrLimpia = new Array();\r    var btnBuscarHab = 'S';\r    var vBCDM = 'N';     var vBCDUN= 'N';\r    var vBCDN = 'N';\r    var vBCDSG= 'N';\r    var vBCDG = 'N';\r    \r	 var arrComboTipoOferta;\r	 var arrComboCicloVida ;\r\r    function onLoadPag()   {\r		guardoConExito();\r        DrdEnsanchaConMargenDcho('listado1',24);\r        document.all[\"Cplistado1\"].style.visibility='';\r        document.all[\"CpLin1listado1\"].style.visibility='';\r        document.all[\"CpLin2listado1\"].style.visibility='';\r        document.all[\"CpLin3listado1\"].style.visibility='';\r        document.all[\"CpLin4listado1\"].style.visibility='';\r        document.all[\"separaDiv\"].style.visibility='hidden';\r        document.all[\"primera1Div\"].style.visibility='hidden';\r        document.all[\"ret1Div\"].style.visibility='hidden';\r        document.all[\"ava1Div\"].style.visibility='hidden';\r        document.all[\"btnBuscarDiv\"].style.visibility='';\r        document.all[\"btnEliminarDiv\"].style.visibility='';\r    \r        DrdEnsanchaConMargenDcho('listado2',12);\r        document.all[\"Cplistado2\"].style.visibility='';\r        document.all[\"CpLin1listado2\"].style.visibility='';\r        document.all[\"CpLin2listado2\"].style.visibility='';\r        document.all[\"CpLin3listado2\"].style.visibility='';\r        document.all[\"CpLin4listado2\"].style.visibility='';\r        document.all[\"separa2Div\"].style.visibility='hidden';\r        document.all[\"primera2Div\"].style.visibility='hidden';\r        document.all[\"ret2Div\"].style.visibility='hidden';\r        document.all[\"ava2Div\"].style.visibility='hidden';\r        document.all[\"btnSiguienteDiv\"].style.visibility='';\r		document.all[\"btnEliminar2Div\"].style.visibility='';\r        eval (ON_RSZ);  \r\r        document.getElementById(\"InsertarP4\").style.backgroundColor = \"#496A9A\";\r        document.getElementById(\"InsertarP4\").style.color = \"#FFFFFF\";\r        \r        seteaValoresMatriz();\r        set('formulario.hidUltimoElementoEnLaLista','1');\r        configurarMenuSecundario('formulario');\r		fMostrarMensajeError();\r                		btnProxy(2,\"1\");\r        \r        if ( get('formulario.casoDeUso')=='consultar' || get('formulario.casoDeUso')=='modificar' ) {\r			seleccionaComponenetes();\r			if ( get('formulario.casoDeUso')=='consultar'){\r                               configurarPaginaConsulta();\r                focalizaBotonHTML_XY('btnSiguiente');\r            }\r            if (get('formulario.casoDeUso')=='modificar' ){\r                 if(get(\"formulario.VisibleBCDM\")==\"S\")\r                        marcaOnChange();\r            }\r        }\r        else {\r            set(\"formulario.cbTipoOferta\",0);\r            set(\"formulario.cbCicloVida\",0);\r        }\r            \r        tomarDatosPagina();    \r        \r        if(get(\"formulario.VisibleBCDM\")==\"S\")\r        {\r            vBCDM = 'S';\r        }\r\r        if(get(\"formulario.VisibleBCDUN\")==\"S\")\r        {\r            accion(\"formulario.cbUnidadNegocio\",\".disabled=true\");\r            vBCDUN = 'S';\r        }\r        if(get(\"formulario.VisibleBCDN\")==\"S\")\r        {\r            accion(\"formulario.cbNegocio\",\".disabled=true\");\r            vBCDN = 'S';\r        }\r        if(get(\"formulario.VisibleBCDG\")==\"S\")                \r        {\r            accion(\"formulario.cbGenerico\",\".disabled=true\");\r            vBCDG = 'S';\r        }\r        \r        if(get(\"formulario.VisibleBCDSG\")==\"S\")\r        {\r            accion(\"formulario.cbSupergenerico\",\".disabled=true\");\r            vBCDSG = 'S';\r        }\r        \r        if ( get('formulario.casoDeUso')!='consultar')\r            validaBotonBuscar();  \r\r\r        marcaOnChange();\r        \r        if ( get('formulario.casoDeUso')!='consultar')\r        {\r            if(get(\"formulario.VisibleBCDM\")==\"S\")\r                focaliza(\"formulario.cbMarca\");\r            else\r            if(get(\"formulario.VisibleBCDUN\")==\"S\")\r                focaliza(\"formulario.cbUnidadNegocio\");\r            else\r            if(get(\"formulario.VisibleBCDN\")==\"S\")\r                focaliza(\"formulario.cbNegocio\");               \r            else\r            if(get(\"formulario.VisibleBCDSG\")==\"S\")\r                focaliza(\"formulario.cbSupergenerico\");\r            else\r            if(get(\"formulario.VisibleBCDG\")==\"S\")                \r                focaliza(\"formulario.cbGenerico\");\r            else            \r                focaliza(\"formulario.ExclusionTipoOferta\");\r        }            \r		onTabEliminar2();\r    \r    }\r\r    function seteaValoresMatriz(){    \r                if(get(\"formulario.VisibleBCDM\")==\"N\") {\r			document.getElementById(\"lblMarca\").style.visibility='hidden';        \r            document.getElementById(\"cbMarca\").style.visibility='hidden';        \r		}\r        if(get(\"formulario.ObligatorioBCDM\")==\"S\")\r                sicc_cambiar_estado(\"cbMarca\",true);    \r        if(get(\"formulario.ModificableBCDM\")==\"N\")\r                accion(\"formulario.cbMarca\",\".disabled=true\");\r            \r                if(get(\"formulario.VisibleBCDUN\")==\"N\") {\r			document.getElementById(\"lblUnidadNegocio\").style.visibility='hidden';        \r            document.getElementById(\"cbUnidadNegocio\").style.visibility='hidden';        \r		}\r        if(get(\"formulario.ObligatorioBCDUN\")==\"S\")\r                sicc_cambiar_estado(\"cbUnidadNegocio\",true);        \r        if(get(\"formulario.ModificableBCDUN\")==\"N\")\r                accion(\"formulario.cbUnidadNegocio\",\".disabled=true\");    \r            \r                if(get(\"formulario.VisibleBCDN\")==\"N\") {\r			document.getElementById(\"lblNegocio\").style.visibility='hidden';        \r            document.getElementById(\"cbNegocio\").style.visibility='hidden';        \r		}\r        if(get(\"formulario.ObligatorioBCDN\")==\"S\")\r                sicc_cambiar_estado(\"cbNegocio\",true);        \r        if(get(\"formulario.ModificableBCDN\")==\"N\")\r                accion(\"formulario.cbNegocio\",\".disabled=true\");    \r            \r                if(get(\"formulario.VisibleBCDSG\")==\"N\") {\r			document.getElementById(\"lblSupergenerico\").style.visibility='hidden';        \r            document.getElementById(\"cbSupergenerico\").style.visibility='hidden';        \r		}        \r        if(get(\"formulario.ObligatorioBCDSG\")==\"S\") \r                sicc_cambiar_estado(\"cbSupergenerico\",true);    \r        if(get(\"formulario.ModificableBCDSG\")==\"N\")\r                accion(\"formulario.cbSupergenerico\",\".disabled=true\");\r            \r                if(get(\"formulario.VisibleBCDG\")==\"N\") {\r			document.getElementById(\"lblGenerico\").style.visibility='hidden';        \r            document.getElementById(\"cbGenerico\").style.visibility='hidden';  \r		}        \r        if(get(\"formulario.ObligatorioBCDG\")==\"S\") \r                sicc_cambiar_estado(\"cbGenerico\",true);    \r        if(get(\"formulario.ModificableBCDG\")==\"N\")\r                accion(\"formulario.cbGenerico\",\".disabled=true\");            \r    }\r\r	function seleccionaComponenetes(){\r			set(\"formulario.cbMarca\",new Array(get(\"formulario.hidMarcasSel\")));\r			set(\"formulario.cbUnidadNegocio\",new Array(get(\"formulario.hidUniNegSel\")));\r			set(\"formulario.cbNegocio\",new Array(get(\"formulario.hidNegocioSel\")));\r			set(\"formulario.cbSupergenerico\",new Array(get(\"formulario.hidSuperGenericoSel\")));\r			set(\"formulario.cbGenerico\",new Array(get(\"formulario.hidGenericoSel\")));\r						if(get(\"formulario.hidETO\")==\"true\") set(\"formulario.ExclusionTipoOferta\",\"S\");\r			  else set(\"formulario.ExclusionTipoOferta\",\"N\");\r			\r			var selTO = get(\"formulario.selTipoOferta\"); \r			selTO = selTO.split(\",\");\r			set(\"formulario.cbTipoOferta\",selTO);\r			var selCV = get(\"formulario.selCicloVida\");\r			selCV = selCV.split(\",\");\r			set(\"formulario.cbCicloVida\",selCV);\r	}\r\r    function configurarPaginaConsulta()\r	{\r		deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');\r		deshabilitarHabilitarBoton('botonContenido','btnEliminar','D');\r		deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');\r		deshabilitarHabilitarBoton('botonContenido','btnEliminar2','D');\r		accion('formulario.cbMarca','.disabled=true');\r		accion('formulario.cbUnidadNegocio','.disabled=true');\r		accion('formulario.cbNegocio','.disabled=true');\r		accion('formulario.cbSupergenerico','.disabled=true');\r		accion('formulario.cbGenerico','.disabled=true');\r		accion('formulario.ExclusionTipoOferta','.disabled=true');\r		\r				\r				arrComboTipoOferta	  = get('formulario.cbTipoOferta'	);\r		arrComboCicloVida	=	 get ('formulario.cbCicloVida');\r    }\r    \r	 function cbTipoOfertaOnChange(){\r	 	   if (get('formulario.casoDeUso')=='consultar' ){		\r					set('formulario.cbTipoOferta',arrComboTipoOferta);	 \r			}\r	 }\r\r	 function cbCicloVidaOnChange(){\r	 	   if (get('formulario.casoDeUso')=='consultar' ){\r					set('formulario.cbCicloVida',arrComboCicloVida);	 \r			}\r	 }\r\r   function accionBuscarProductos() {\r        if (!validaExclusion()){\r            GestionarMensaje(1394,null,null,null);\r\r            return false;\r        }\r        \r        var obj = new Object();        \r        obj.oidMarcaCorporativa = get('formulario.oidMarcaCorporativa');\r        var whnd = mostrarModalSICC('LPBuscarProductosDTO','',obj,\r                    null, 570);\r        if(whnd!=null)\r        {\r            accion(\"formulario.cbMarca\",\".disabled=false\");\r            accion(\"formulario.cbUnidadNegocio\",\".disabled=false\");\r            accion(\"formulario.cbNegocio\",\".disabled=false\");\r            accion(\"formulario.cbGenerico\",\".disabled=false\");\r            accion(\"formulario.cbSupergenerico\",\".disabled=false\");\r        \r            actualizaListado(whnd[0]);\r            \r            if (whnd[1] != '' && whnd[1] != null )             {\r                set('formulario.cbMarca',whnd[1]);\r            }\r            \r            if (whnd[2] != '' && whnd[2] != null )             {\r                set('formulario.cbUnidadNegocio',whnd[2]);\r            }\r\r            accion(\"formulario.cbMarca\",\".disabled=true\");\r            accion(\"formulario.cbUnidadNegocio\",\".disabled=true\");\r            accion(\"formulario.cbNegocio\",\".disabled=true\");\r            accion(\"formulario.cbGenerico\",\".disabled=true\");\r            accion(\"formulario.cbSupergenerico\",\".disabled=true\");     \r        }\r    }\r\r	function actualizaListado(listaItems){\r		var fila = listaItems.split('$');\r		for(i=0;i<fila.length;i++){\r			if (fila[i] != ''){\r				var newRow = new Array();\r				newRow = fila[i].split(\"|\");\r				listado1.insertar(newRow);\r			}\r		}\r	}\r\r	function actualizaListado2(){\r	\r	}\r\r    function accionEliminar() {\r        var vMostrarMensaje ='';\r		var cantElementosL1 = listado1.codSeleccionados();		\r\r		if ( cantElementosL1.length == 0){\r			GestionarMensaje(\"4\", null, null, null);\r			return ;\r		}\r				\r		if ( cantElementosL1.length > 0 )\r        {\r			listado1.eliminarSelecc();\r\r            if(get(\"formulario.VisibleBCDM\")==\"S\")\r                accion(\"formulario.cbMarca\",\".disabled=false\");\r                \r            if(get(\"formulario.VisibleBCDUN\")==\"S\")\r                accion(\"formulario.cbUnidadNegocio\",\".disabled=false\");\r\r            if(get(\"formulario.VisibleBCDN\")==\"S\")\r                accion(\"formulario.cbNegocio\",\".disabled=false\");                \r\r            if(get(\"formulario.VisibleBCDG\")==\"S\")                \r                accion(\"formulario.cbGenerico\",\".disabled=false\");\r            \r            if(get(\"formulario.VisibleBCDSG\")==\"S\")\r                accion(\"formulario.cbSupergenerico\",\".disabled=false\");\r\r            if((btnBuscarHab =='N') && (VisibleBADP == 'S') && (ModificableBADP == 'S'))\r            {\r                deshabilitarHabilitarBoton('botonContenido','btnBuscar','A');\r                btnBuscarHab ='S';    \r            }\r        }\r    }\r   \r	function accionEliminar2() {\r        var vMostrarMensaje ='';\r		var cantElementosL1 = listado2.codSeleccionados();		\r  \r		if ( cantElementosL1.length == 0){\r			GestionarMensaje(\"4\", null, null, null);\r			return ;\r		}\r				\r		if ( cantElementosL1.length > 0 )\r			listado2.eliminarSelecc();\r    }\r  \r  function accionAniadir(){\r  \r        var vExcluyeTipoOfe = get('formulario.ExclusionTipoOferta');\r        var vTipoOfertaSel  = get('formulario.cbTipoOferta');\r\r        var vCicloVidaSel   = get('formulario.cbCicloVida');\r        \r        if (vCicloVidaSel =='' || vCicloVidaSel == null)\r        {\r            GestionarMensaje('1201','Ciclo de Vida');\r            focaliza('formulario.cbCicloVida');\r            return false;\r        }\r        \r        if (vExcluyeTipoOfe == 'N'){\r          if(vTipoOfertaSel =='' || vTipoOfertaSel == null){\r            GestionarMensaje('1415');\r            focaliza('formulario.cbTipoOferta');\r            return false;\r          }\r        }\r        \r        var codigo = listado1.codigos();\r        \r        if( codigo.length > 0  )\r            armaCriterioDeProductos();\r        else\r            armaCriterioBloqueUno();\r    }\r\r  function armaCriterioBloqueUno() {\r      \r      var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);\r      \r      var codigo = listado2.generaCodigo( posi );\r            \r      set('formulario.hidUltimoElementoEnLaLista', codigo);\r\r                        var oidMarSel       = get('formulario.cbMarca','V');\r            var desMarSel       = get('formulario.cbMarca','T');\r\r            var oidUnidNegSel   = get('formulario.cbUnidadNegocio','V');\r            var desUnidNegSel   = get('formulario.cbUnidadNegocio','T');\r\r            var oidNegSel       = get('formulario.cbNegocio','V');\r            var desNegSel       = get('formulario.cbNegocio','T');\r\r            var oidSuperGenSel  = get('formulario.cbSupergenerico','V');\r            var desSuperGenSel  = get('formulario.cbSupergenerico','T');\r\r            var oidGenSel       = get('formulario.cbGenerico','V');\r            var desGenSel       = get('formulario.cbGenerico','T');\r\r            var vExcluyeTipoOfe = get('formulario.ExclusionTipoOferta');\r\r            var vTipoOfertaSel  = get('formulario.cbTipoOferta');\r            var vCicloVidaSel   = get('formulario.cbCicloVida');\r\r                var oidT       = get('formulario.cbTipoOferta','V');\r                var desT       = get('formulario.cbTipoOferta','T');\r                var oidC       = get('formulario.cbCicloVida','V');\r                var desC       = get('formulario.cbCicloVida','T');\r\r            var vTope;\r            \r            if(vExcluyeTipoOfe =='N' && vTipoOfertaSel.length == 0){\r                vTope = 1;\r            }else{\r                vTope = vTipoOfertaSel.length;\r            }\r            \r                                    if(vExcluyeTipoOfe=='S' && vTope==0){\r            \r                for (var j = 0; j < vCicloVidaSel.length; j++){\r                      \r                    if (oidC[j] != '' && oidC[j] !=null ){\r                          \r                        var datos = codigo + \"|\" + oidMarSel + \"|\" + desMarSel;\r                        datos = datos + \"|\" + oidUnidNegSel + \"|\" + desUnidNegSel;\r                        datos = datos + \"|\" + oidNegSel + \"|\" + desNegSel;\r                        datos = datos + \"|\" + oidSuperGenSel + \"|\" + desSuperGenSel;\r                        datos = datos + \"|\" + oidGenSel + \"|\" + desGenSel + \"|\" + vExcluyeTipoOfe;\r                        datos = datos + \"|\" + '' + \"|\" + '';\r                        \r                        var oidCicloVida       = oidC[j];\r                        var desCicloVida       = desC[j];\r                        datos = datos + \"|\" + oidCicloVida + \"|\" + desCicloVida+ \"|\" +''+ \"|\" +'';\r\r                        if (!existeFilaCriterio(datos)){\r                          var newRow = new Array();\r                          newRow = datos.split(\"|\");\r                          listado2.insertar(newRow);\r                          codigo = listado2.generaCodigo(codigo);\r                        }\r                    }\r                }\r            \r            }else{\r            \r                for (var i = 0; i < vTope; i++){\r                  \r                  var oidTipoOferta       = oidT[i];\r                  var desTipoOferta       = desT[i];\r                \r                  for (var j = 0; j < vCicloVidaSel.length; j++){\r                      \r                      if (oidC[j] != '' && oidC[j] !=null )\r                      {\r                          var datos = codigo + \"|\" + oidMarSel + \"|\" + desMarSel;\r                          datos = datos + \"|\" + oidUnidNegSel + \"|\" + desUnidNegSel;\r                          datos = datos + \"|\" + oidNegSel + \"|\" + desNegSel;\r                          datos = datos + \"|\" + oidSuperGenSel + \"|\" + desSuperGenSel;\r                          datos = datos + \"|\" + oidGenSel + \"|\" + desGenSel + \"|\" + vExcluyeTipoOfe;\r              \r                          if (oidTipoOferta != null)\r                              datos = datos + \"|\" + oidTipoOferta + \"|\" + desTipoOferta;\r                          else\r                              datos = datos + \"|\" + '' + \"|\" + '';\r                  \r                          var oidCicloVida       = oidC[j];\r                          var desCicloVida       = desC[j];\r                          datos = datos + \"|\" + oidCicloVida + \"|\" + desCicloVida+ \"|\" +''+ \"|\" +'';\r\r                          if (!existeFilaCriterio(datos)){\r                              var newRow = new Array();\r                              newRow = datos.split(\"|\");\r                              listado2.insertar(newRow);\r                              codigo = listado2.generaCodigo(codigo);\r                          }\r                      }\r                  }\r                }\r            }\r            \r            \r            var codigo = listado2.codigos();\r                        \r            \r            set('formulario.hidUltimoElementoEnLaLista', codigo);\r    \r    }\r    \r    \r    function existeFilaCriterio(datos)\r    {\r        var codigo = listado2.codigos();\r        var newRow = new Array();\r        newRow = datos.split(\"|\");\r        var flag = false;\r        var a = 0;\r\r        while( (a < codigo.length ) && (flag == false) ){\r            \r            if( newRow[1] ==listado2.extraeDato(codigo[a], 0)!=\"\") {              if( newRow[3] == cdos_trim(listado2.extraeDato(codigo[a], 2))){               if( newRow[5] == cdos_trim(listado2.extraeDato(codigo[a], 4))){                if( newRow[7] == cdos_trim(listado2.extraeDato(codigo[a], 6))){                 if( newRow[9] == cdos_trim(listado2.extraeDato(codigo[a], 8))){                  if( newRow[11] == cdos_trim(listado2.extraeDato(codigo[a], 10))){                   if( newRow[12] == cdos_trim(listado2.extraeDato(codigo[a], 11))){                   if( newRow[14] == cdos_trim(listado2.extraeDato(codigo[a], 13))){                        flag = true;\r                   }\r                  }\r                 }\r                }\r               }\r              }\r             }\r            }\r            a++;\r		}        return flag;\r    }\r\r    function validaExclusion() {\r        var codigo = listado1.codigos();\r        if ( ( (get('formulario.cbMarca','V') != '') || \r					 (get('formulario.cbMarca','V') != '') ||\r					 (get('formulario.cbUnidadNegocio','V') != '') ||\r                (get('formulario.cbNegocio','V') != '') ||\r					 (get('formulario.cbSupergenerico','V') != '') ||\r					 (get('formulario.cbGenerico','V') !='' ))\r                     ){\r                     \r            return false;\r        }\r        return true;\r    }\r\r    function validaSeleccionDeValoresDeCombos(){\r                		if ( (get('formulario.ObligatorioBCDM') == 'S') &&\r			 (fValidarCOMBO('formulario.cbMarca')== false))\r                return false;\r\r		\r				if ( ( get('formulario.ObligatorioBCDUN') == 'S') &&\r			 (fValidarCOMBO('formulario.cbUnidadNegocio') == false))\r    			return false;\r			\r				if( ( get('formulario.ObligatorioBCDN') == 'S') &&\r			 (fValidarCOMBO('formulario.cbNegocio')) )\r    			return false;\r	\r				if( ( get('formulario.ObligatorioBCDSG') == 'S')	&&\r			(fValidarCOMBO('formulario.cbSupergenerico') == false) )\r    			return false;	\r\r				if( ( get('formulario.ObligatorioBCDG') == 'S') &&\r			 (fValidarCOMBO('formulario.cbGenerico')== false) )\r    			return false;\r\r    }\r\r    function armaCriterioDeProductos() {\r      \r      var cant = listado1.numSelecc();\r		var cantTemporal = listado2.codigos().length;  		var toAdd = \"\";\r		var codigo = \"\";\r\r		if ( cant == 0 ){\r				GestionarMensaje('UIDTO0001');\r		}else{\r				codigo = listado1.codSeleccionados();\r			\r   				var posi = parseInt(get('formulario.hidUltimoElementoEnLaLista'), 10);\r                for(var a = 0; a < codigo.length ; a++){\r					var exTO= get(\"formulario.ExclusionTipoOferta\");\r					var to = get(\"formulario.cbTipoOferta\");\r					var toD = get(\"formulario.cbTipoOferta\",\"T\");\r					var cv = get(\"formulario.cbCicloVida\");\r					var cvD = get(\"formulario.cbCicloVida\",\"T\");					\r                    var datos = \"\";\r					\r                    datos = \"||||||||||\";                    \r					datos = datos + \"|\" + exTO;\r\r										var numIterTiposOfertas = to.length;\r					if (numIterTiposOfertas == 0) { \r						numIterTiposOfertas = 1;\r						to = new Array(\"\");\r						toD = new Array(\"\");\r					}\r\r										for(var j = 0; j < numIterTiposOfertas; j++){\r						var datos1 = datos + \"|\" + to[j] + \"|\" + toD[j];\r\r												for(var i = 0; i < cv.length; i++){\r        					var codig = listado2.generaCodigo( posi);\r							var dat = codig + datos1 + \"|\" + cv[i] + \"|\" + cvD[i] + \"|\" + codigo[a] + \"|\" + listado1.extraeDato(codigo[a], 0);\r                            \r							if(!existeFila(dat))\r                            {\r                                var newRow = new Array();\r                                newRow = dat.split(\"|\");\r                                \r                                listado2.insertar(newRow);\r                                posi++;\r                            }\r						}\r					}\r                }\r				GestionarMensaje(\"000000000000079\", null,null,null);\r		}\r\r	}\r\r       \r    function existeFila(datos)\r    {\r        var codigo = listado2.codigos();\r        var newRow = new Array();\r        newRow = datos.split(\"|\");\r        var flag = false;\r        var a = 0;\r        \r        while( (a < codigo.length ) && (flag == false) ){\r            \r            if( newRow[11] == cdos_trim(listado2.extraeDato(codigo[a], 10)) )\r            {                if( newRow[12] == cdos_trim(listado2.extraeDato(codigo[a], 11)))\r                {                    if( newRow[14] == cdos_trim(listado2.extraeDato(codigo[a], 13)))\r                    {                        if( newRow[16] == cdos_trim(listado2.extraeDato(codigo[a], 15)))\r                        {                            flag = true;\r                        }\r                    }\r                }\r            }\r            a++;\r		}        return flag;\r    }\r\r    function pasaListaTemporal(codigo, dato){\r        var codigosTemporal = listado2.codigos();\r        var match = rowMatch(codigo, codigosTemporal);\r        if (match){\r                    }else{\r				var dat = verificoCampos();\r            				datos = codigo;\r				datos = datos + \"|\";    				datos = datos + \"|\";\r				datos = datos + \"|\";\r				datos = datos + \"|\";    				datos = datos + \"|\";\r            datos = datos + \"|\";    				datos = datos + \"|\";\r            datos = datos + \"|\";    				datos = datos + \"|\";\r            datos = datos + \"|\";                datos = datos + \"|\" + dat;  \r            datos = datos + \"|\" + dato;\r				\r            var newRow = new Array();\r            newRow = datos.split(\"|\");\r				\r            listado2.insertar(newRow);\r        }\r    }\r\r	 function verificoCampos(){\r			var exTO= get(\"formulario.ExclusionTipoOferta\");\r			var to = get(\"formulario.cbTipoOferta\");\r			var toD = get(\"formulario.cbTipoOferta\",\"T\");\r			var cv = get(\"formulario.cbCicloVida\");\r			var cvD = get(\"formulario.cbCicloVida\",\"T\");\r			var dat  = exTO + \"|\" + to + \"|\" + toD + \"|\" + cv  + \"|\" + cvD;\r			\r			return dat;\r	 }\r\r	function rowMatch(codigo, codigosTemporal){\r        var flag = false;\r        var i = 0;\r        while ( (i < codigosTemporal.length) && (flag == false) ){\r            if ( codigo == codigosTemporal[i] )\r                flag = true;	\r            i++;\r        }\r        return flag;\r    }\r\r    function tomaValoresListaCriterios() {\r        if(sicc_validaciones_generales()) {  \r            var listadoSeleccionado = '';\r            if (listado2.datos.length > 0) {\r                listadoSeleccionado = listado2string();\r                set('formulario.hidDetalleCriterios', listadoSeleccionado);\r				\r				var productos = productos2string();\r				set('formulario.hidDetalleProductos', productos);\r\r                return true;\r            }\r        }\r        else { \r			return false;\r		}\r    }\r\r	function productos2string() {\r		var codigo = listado1.codigos();\r		var total = \"\";\r\r		for(var a = 0; a < codigo.length ; a++){\r    		var toAdd = \"\";\r\r	        toAdd = \"oid:\"+ codigo[a];\r\r		    if(listado1.extraeDato(codigo[a], 0)!= null && listado1.extraeDato(codigo[a], 0)!=\"\")\r			  toAdd = toAdd + \"|\" + \"codigosap:\" + listado1.extraeDato(codigo[a], 0);    \r			if(listado1.extraeDato(codigo[a], 1)!= null && listado1.extraeDato(codigo[a], 1)!=\"\")\r		      toAdd = toAdd + \"|\" + \"descripcion:\"  + listado1.extraeDato(codigo[a], 1);    		\r			total = total + \"$\" + toAdd;\r		}	\r		return total;\r	}\r\r    function listado2string(){\r      var codigo = listado2.codigos();\r      var total = \"\";\r      for(var a = 0; a < codigo.length ; a++){\r    		var toAdd = \"\";\r\r        toAdd = \"oid:\"+ codigo[a];\r\r        if(listado2.extraeDato(codigo[a], 0)!= null && listado2.extraeDato(codigo[a], 0)!=\"\")\r          toAdd = toAdd + \"|\" + \"m:\" + listado2.extraeDato(codigo[a], 0);    \r		if(listado2.extraeDato(codigo[a], 2)!= null && listado2.extraeDato(codigo[a], 2)!=\"\")\r          toAdd = toAdd + \"|\" + \"un:\"  + listado2.extraeDato(codigo[a], 2);            \r		if(listado2.extraeDato(codigo[a], 4)!= null && listado2.extraeDato(codigo[a], 4)!=\"\")\r           toAdd = toAdd + \"|\" + \"n:\"  + listado2.extraeDato(codigo[a], 4);            \r		if(listado2.extraeDato(codigo[a], 6)!= null && listado2.extraeDato(codigo[a], 6)!=\"\")\r           toAdd = toAdd + \"|\" + \"sg:\"  + listado2.extraeDato(codigo[a], 6);            \r		if(listado2.extraeDato(codigo[a], 8)!= null && listado2.extraeDato(codigo[a], 8)!=\"\")\r           toAdd = toAdd + \"|\" + \"g:\"  + listado2.extraeDato(codigo[a], 8);            \r		if(listado2.extraeDato(codigo[a], 10)!= null && listado2.extraeDato(codigo[a], 10)!=\"\")\r           toAdd = toAdd + \"|\" + \"eto:\"  + listado2.extraeDato(codigo[a], 10);           \r		if(listado2.extraeDato(codigo[a], 11)!= null && listado2.extraeDato(codigo[a], 11)!=\"\")\r           toAdd = toAdd + \"|\" + \"to:\"  + listado2.extraeDato(codigo[a], 11);           \r		if(listado2.extraeDato(codigo[a], 13)!= null && listado2.extraeDato(codigo[a], 13)!=\"\")\r           toAdd = toAdd + \"|\" + \"cv:\"  + listado2.extraeDato(codigo[a], 13);           \r		if(listado2.extraeDato(codigo[a], 15)!= null && listado2.extraeDato(codigo[a], 15)!=\"\")\r	         toAdd = toAdd + \"|\" + \"pr:\"  + listado2.extraeDato(codigo[a], 15);   \r		if(listado2.extraeDato(codigo[a], 1)!= null && listado2.extraeDato(codigo[a], 1)!=\"\")\r	         toAdd = toAdd + \"|\" + \"descmarca:\"  + listado2.extraeDato(codigo[a], 1);   \r		if(listado2.extraeDato(codigo[a], 3)!= null && listado2.extraeDato(codigo[a], 3)!=\"\")\r	         toAdd = toAdd + \"|\" + \"descunidad:\"  + listado2.extraeDato(codigo[a], 3);   \r		if(listado2.extraeDato(codigo[a], 5)!= null && listado2.extraeDato(codigo[a], 5)!=\"\")\r	         toAdd = toAdd + \"|\" + \"descnegocio:\"  + listado2.extraeDato(codigo[a], 5);   \r		if(listado2.extraeDato(codigo[a], 7)!= null && listado2.extraeDato(codigo[a], 7)!=\"\")\r	         toAdd = toAdd + \"|\" + \"descsuper:\"  + listado2.extraeDato(codigo[a], 7);   		\r		if(listado2.extraeDato(codigo[a], 9)!= null && listado2.extraeDato(codigo[a], 9)!=\"\")\r	         toAdd = toAdd + \"|\" + \"descgenerico:\"  + listado2.extraeDato(codigo[a], 9);   \r		if(listado2.extraeDato(codigo[a], 12)!= null && listado2.extraeDato(codigo[a], 12)!=\"\")\r	         toAdd = toAdd + \"|\" + \"desctipo:\"  + listado2.extraeDato(codigo[a], 12);   \r		if(listado2.extraeDato(codigo[a], 14)!= null && listado2.extraeDato(codigo[a], 14)!=\"\")\r	         toAdd = toAdd + \"|\" + \"descciclo:\"  + listado2.extraeDato(codigo[a], 14);   \r		if(listado2.extraeDato(codigo[a], 16)!= null && listado2.extraeDato(codigo[a], 16)!=\"\")\r	         toAdd = toAdd + \"|\" + \"descproducto:\"  + listado2.extraeDato(codigo[a], 16);   		\r		total = total + \"$\" + toAdd;\r		}	\r		return total;\r	}\r\r    function fGuardar(){\r      \r          accionGuardar();\r    }\r\r	function accionSiguiente(){\r            if (validacion())\r        {\r            ponerEnFalseTodos();\r            tomaValoresListaCriterios();\r            set('formulario.conectorAction', 'LPMantenimientoBaseCalculo');\r            set('formulario.accion', 'siguiente');\r            /*if  (get('formulario.casoDeUso') != 'consultar'){\r              eval('formulario').oculto=\"S\"; \r            }*/\r            enviaSICC('formulario');\r        }\r  } \r   \r    function tomarDatosPagina(){\r			arrLimpia[0] = get(\"formulario.cbMarca\");\r			arrLimpia[1] = get(\"formulario.cbUnidadNegocio\");\r			arrLimpia[2] = get(\"formulario.cbNegocio\");\r			arrLimpia[3] = get(\"formulario.cbSupergenerico\");\r			arrLimpia[4] = get(\"formulario.cbGenerico\");\r			arrLimpia[5] = get(\"formulario.cbTipoOferta\");\r			arrLimpia[6] = get(\"formulario.cbCicloVida\");\r			arrLimpia[7] = get(\"formulario.ExclusionTipoOferta\");\r	 }\r\r    function fLimpiar()\r    {\r        if (get('formulario.casoDeUso') != 'consultar' ){\r            set(\"formulario.cbMarca\",new Array(arrLimpia[0]));			\r			set(\"formulario.cbUnidadNegocio\",new Array(arrLimpia[1]));\r			set(\"formulario.cbNegocio\",new Array(arrLimpia[2]));\r			set(\"formulario.cbSupergenerico\",new Array(arrLimpia[3]));\r			set(\"formulario.cbGenerico\",new Array(arrLimpia[4]));\r			set(\"formulario.cbTipoOferta\",arrLimpia[5]);\r			set(\"formulario.cbCicloVida\",arrLimpia[6]);\r			set(\"formulario.ExclusionTipoOferta\",arrLimpia[7]);\r\r            seteaValoresMatriz();\r            \r            if(get(\"formulario.VisibleBCDM\")==\"S\"){\r                focaliza(\"formulario.cbMarca\");\r            }\r            else\r            {\r                if(get(\"formulario.VisibleBCDUN\")==\"S\")\r                    focaliza(\"formulario.cbUnidadNegocio\");\r                else if(get(\"formulario.VisibleBCDN\")==\"S\")\r                    focaliza(\"formulario.cbNegocio\");\r                else if(get(\"formulario.VisibleBCDG\")==\"S\")                \r                    focaliza(\"formulario.cbGenerico\");\r                else if(get(\"formulario.VisibleBCDSG\")==\"S\")\r                    focaliza(\"formulario.cbSupergenerico\");\r            }\r        }\r        deshabilitarHabilitarBoton('botonContenido','btnBuscar','A');\r    }\r\r    function accionMensajeDeExito(){\r		if (get(\"formulario.accion\") == \"siguiente\"){\r			eval('formulario').oculto=\"N\"; \r			set(\"formulario.conectorAction\",\"LPMantenimientoBaseAplicacion\");\r			set(\"formulario.accion\",\"\");\r			set(\"formulario.casoDeUso\",\"modificar\");\r			enviaSICC(\"formulario\");\r		} else {\r			window.close();\r		}\r            }\r\r	function accionError(){\r		eval('formulario').oculto=\"N\"; \r	}\r\r	   function fVolver(){\r		onClickPestanya('2');\r		\r		/*window.close();\r        set(\"formulario.conectorAction\",\"LPMantenimientoDTO\");\r        set(\"formulario.accion\",\"volver\");\r        enviaSICC(\"formulario\");*/\r    }\r\r    function navegaPestaniasDetalle(pestanya)\r    {\r        if (validacion())\r        {\r            tomaValoresListaCriterios();        \r            set('formulario.conectorAction', 'LPMantenimientoBaseCalculo');\r            set('formulario.accion', 'siguiente');\r            if (pestanya == 4)\r            {\r                set(\"formulario.hidPestanya\", \"4\");\r                enviaSICC('formulario');  \r            }\r        }  \r    }\r    \r    function cambiaEstado(){\r        if(get('formulario.ExclusionTipoOferta')=='S')\r   			sicc_cambiar_estado(\"cbTipoOferta\",true);   \r        else sicc_cambiar_estado(\"cbTipoOferta\",false);       \r   }\r\r    function marcaOnChange()\r    {\r        var oidMarSel       = get('formulario.cbMarca','V');\r        if ( oidMarSel!='' && oidMarSel != null )\r        {\r            if(get(\"formulario.VisibleBCDUN\")==\"S\")\r            {\r                accion(\"formulario.cbUnidadNegocio\",\".disabled=false\");\r                vBCDUN = 'N';\r            }\r            \r            if(get(\"formulario.VisibleBCDG\")==\"S\")\r            {\r                accion(\"formulario.cbGenerico\",\".disabled=false\");\r                vBCDG= 'N';\r            }\r            \r            if(get(\"formulario.VisibleBCDSG\")==\"S\")\r            {\r                accion(\"formulario.cbSupergenerico\",\".disabled=false\");\r                vBCDSG= 'N';\r            }\r                \r            deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');\r            btnBuscarHab ='N';\r        }\r        else\r        {\r            var datosNuevo = new Array();\r            datosNuevo[0] = [\"\",\"\"];    \r            set(\"formulario.cbUnidadNegocio\", datosNuevo);\r            set(\"formulario.cbGenerico\", datosNuevo);\r            set(\"formulario.cbSupergenerico\", datosNuevo);\r\r            if(get(\"formulario.VisibleBCDUN\")==\"S\")\r            {\r                accion(\"formulario.cbUnidadNegocio\",\".disabled=true\");\r                vBCDUN= 'S';\r            }\r            \r            if(get(\"formulario.VisibleBCDG\")==\"S\")  \r            {\r                accion(\"formulario.cbGenerico\",\".disabled=true\");\r                vBCDG= 'S';\r            }\r            \r            if(get(\"formulario.VisibleBCDSG\")==\"S\")\r            {\r                accion(\"formulario.cbSupergenerico\",\".disabled=true\");\r                vBCDSG= 'S';\r            }\r            unidadNegocioOnChange();    \r        }\r        NegocioOnChange();\r    }\r\r    function unidadNegocioOnChange()\r    {\r        var oidUniNegSel       = get('formulario.cbUnidadNegocio','V');\r        if ( oidUniNegSel!='' && oidUniNegSel != null )\r        {\r            if(get(\"formulario.VisibleBCDN\")==\"S\")\r            {\r                accion(\"formulario.cbNegocio\",\".disabled=false\");\r                vBCDN =\"N\";\r            }\r\r            btnBuscarHab ='N';    \r        }\r        else\r        {\r            var datosNuevo = new Array();\r            datosNuevo[0] = [\"\",\"\"];            \r            set(\"formulario.cbNegocio\", datosNuevo);\r            if(get(\"formulario.VisibleBCDN\")==\"S\")\r            {\r                accion(\"formulario.cbNegocio\",\".disabled=true\");\r                vBCDN =\"S\";\r            }\r        }\r        NegocioOnChange();\r    }\r\r    function NegocioOnChange()\r    {\r        validaBotonBuscar();\r    }\r\r    function validaBotonBuscar()\r    {\r        var oidUniNegSel       = get('formulario.cbUnidadNegocio','V');\r        var oidMarca = get('formulario.cbMarca','V');\r        var oidNegocio = get('formulario.cbNegocio','V');\r        var oidGenerico = get('formulario.cbGenerico','V');\r        var oidSuperGen = get('formulario.cbSupergenerico','V');\r        \r        if(get(\"formulario.VisibleBCDP\")==\"S\"){\r            if( \r            ( oidMarca!='' && oidMarca != null ) ||\r            ( oidUniNegSel!='' && oidUniNegSel != null ) ||\r            ( oidGenerico!='' && oidGenerico != null ) ||\r            ( oidNegocio!='' && oidNegocio != null ) ||\r            ( oidSuperGen!='' && oidSuperGen != null ) )\r            {\r                deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');\r                btnBuscarHab ='N';\r            }\r            else\r            {\r                if( \r                    ( oidMarca == '' ) &&  ( oidUniNegSel == '' ) &&\r                    ( oidGenerico == '' ) &&  ( oidNegocio == '' ) &&\r                    ( oidSuperGen == '' ) )\r                    {\r                        deshabilitarHabilitarBoton('botonContenido','btnBuscar','A');\r                        btnBuscarHab ='S';\r                    }\r            }\r        }\r        else{\r                deshabilitarHabilitarBoton('botonContenido','btnBuscar','D');\r                btnBuscarHab ='N';\r            }\r    }\r\r    function SuperGenericoOnChange()\r    {\r        if(btnBuscarHab =='N')\r            NegocioOnChange();\r    }\r\r    function GenericoOnChange()\r    {\r        if(btnBuscarHab =='N')\r            NegocioOnChange();\r    }\r\r\r    /*-------- Inc 11429 -------*/\r    function accionGuardar()\r    {\r        if (validacion())\r        {\r            \r            ponerEnFalseTodos();\r            tomaValoresListaCriterios();\r            set('formulario.conectorAction', 'LPMantenimientoBaseCalculo');\r                        set('formulario.accion', 'guardarBaseCalculo');\r            enviaSICC('formulario');\r        }\r    }\r    \r    function validacion()\r    {\r        if (validarCriteriosSeleccionados()) \r            return true; \r        else \r            return false;\r    }\r    \r    function validarCriteriosSeleccionados()\r    {\r        if (listado2.datos.length == 0)\r        {\r            GestionarMensaje(\"1442\");\r            return false;\r        }\r        else\r            return true;\r    }\r    /*-------- Inc 11429 -------*/\r\r    function onTabEliminar()\r    {\r        if (btnBuscarHab == 'N')\r        {\r            focalizaBotonHTML('botonContenido','btnAnadir');\r        }\r        else\r        {\r            focalizaBotonHTML('botonContenido','btnBuscar');\r        }\r    }\r\r    function onShTabAnadir()\r    {\r        if (btnBuscarHab == 'N')\r        {\r            focalizaBotonHTML('botonContenido','btnEliminar');\r        }\r        else\r        {\r            focalizaBotonHTML('botonContenido','btnBuscar');\r        }\r    }\r\r\r    function onTabSiguiente()\r    {\r        if (get('formulario.casoDeUso') != 'consultar' )\r            focalizaBotonHTML('botonContenido','btnEliminar2');\r        else\r            focalizaBotonHTML_XY('btnSiguiente');    \r    }\r    \r    function onShTabSiguiente()\r    {\r        if (get('formulario.casoDeUso') != 'consultar' )\r            focalizaBotonHTML('botonContenido','btnAnadir');\r        else\r            focalizaBotonHTML_XY('btnSiguiente');\r    }\r\r    function onTabEliminar2() {\r        if ( get('formulario.casoDeUso')!='consultar') {\r			if(document.getElementById(\"cbMarca\").style.visibility!='hidden') {\r				if(document.getElementById(\"cbMarca\").disabled!=true) {\r					focaliza(\"formulario.cbMarca\");\r				}\r				else {\r					ontabComboMarca();\r				}\r			}\r			else {\r				ontabComboMarca();\r			}\r        }\r    }\r\r    function onShTabExclusionTipoOferta()\r    {\r        if ( get('formulario.casoDeUso')!='consultar')\r        {\r            /*if(get(\"formulario.VisibleBCDG\")==\"S\")                \r                focaliza(\"formulario.cbGenerico\");\r            else\r            if(get(\"formulario.VisibleBCDSG\")==\"S\")\r                focaliza(\"formulario.cbSupergenerico\");                \r            else\r             if(get(\"formulario.VisibleBCDN\")==\"S\")\r                focaliza(\"formulario.cbNegocio\");               \r            else \r            if(get(\"formulario.VisibleBCDUN\")==\"S\")\r                focaliza(\"formulario.cbUnidadNegocio\");\r            else\r             if(get(\"formulario.VisibleBCDM\")==\"S\")\r                focaliza(\"formulario.cbMarca\");*/\r             if( vBCDG == 'N' )\r               focaliza(\"formulario.cbGenerico\");\r            else\r            if( vBCDSG == 'N' )\r                focaliza(\"formulario.cbSupergenerico\");\r            else\r            if( vBCDN == 'N')\r                focaliza(\"formulario.cbNegocio\");\r            else\r            if( vBCDUN == 'N')\r                focaliza(\"formulario.cbUnidadNegocio\");\r            else            \r            if( vBCDM == 'N')\r                focaliza(\"formulario.cbMarca\");   \r             else   \r                focalizaBotonHTML('botonContenido','btnEliminar2');\r        }\r    }\r\r			function onClickPestanya(pestanya) {		\r		set(\"formulario.idPestanyaDest\", pestanya);\r\r		if ( get('formulario.casoDeUso')!='consultar'){\r			\r      if(validacion()) {\r      	ponerEnFalseTodos();\r        tomaValoresListaCriterios();\r				set('formulario.conectorAction', 'LPMantenimientoBaseCalculo');\r				set('formulario.accion', 'almacenar');              \r				enviaSICC('formulario');\r			}			\r		}\r		else {\r			set('formulario.conectorAction', 'LPMantenimientoBaseCalculo');\r			set('formulario.accion', 'redirigir');              \r			enviaSICC('formulario');\r		}\r	}\r\r	\r  function ponerEnFalseTodos(){\r    \r    sicc_cambiar_estado(\"cbMarca\",false);\r    sicc_cambiar_estado(\"cbUnidadNegocio\",false);\r    sicc_cambiar_estado(\"cbNegocio\",false);\r    sicc_cambiar_estado(\"cbSupergenerico\",false);\r    sicc_cambiar_estado(\"cbGenerico\",false);\r    sicc_cambiar_estado(\"cbTipoOferta\",false);\r    sicc_cambiar_estado(\"cbCicloVida\",false);\r    \r  }\r  \r  function ontabComboMarca() {\r		if(document.getElementById(\"cbUnidadNegocio\").style.visibility!='hidden') {\r			if(document.getElementById(\"cbUnidadNegocio\").disabled!=true) {\r				focaliza(\"formulario.cbUnidadNegocio\");\r			}\r			else {\r				ontabComboUnidadNegocio();\r			}\r		}\r		else {\r			ontabComboUnidadNegocio();\r		}\r	}\r\r	function ontabComboUnidadNegocio() {\r		if(document.getElementById(\"cbNegocio\").style.visibility!='hidden') {\r			if(document.getElementById(\"cbNegocio\").disabled!=true) {\r				focaliza(\"formulario.cbNegocio\");\r			}\r			else {\r				ontabComboNegocio();\r			}\r		}\r		else {\r			ontabComboNegocio();\r		}		\r	}\r\r	function ontabComboNegocio() {\r		if(document.getElementById(\"cbSupergenerico\").style.visibility!='hidden') {\r			if(document.getElementById(\"cbSupergenerico\").disabled!=true) {\r				focaliza(\"formulario.cbSupergenerico\");\r			}\r			else {\r				ontabComboSuperGenerico();\r			}\r		}\r		else {\r			ontabComboSuperGenerico();\r		}		\r	}\r\r	function ontabComboSuperGenerico() {\r		if(document.getElementById(\"cbGenerico\").style.visibility!='hidden') {\r			if(document.getElementById(\"cbGenerico\").disabled!=true) {\r				focaliza(\"formulario.cbGenerico\");\r			}\r			else {\r				ontabComboGenerico();\r			}\r		}\r		else {\r			ontabComboGenerico();\r		}		\r	}\r\r	function ontabComboGenerico() {\r	    focaliza(\"formulario.ExclusionTipoOferta\");\r	}\r\r	function onshtabCicloVida() {\r		if(document.getElementById(\"cbTipoOferta\").style.visibility!='hidden') {\r			if(document.getElementById(\"cbTipoOferta\").disabled!=true) {\r				focaliza(\"formulario.cbTipoOferta\");\r			}\r			else {\r				onshtabTipoOferta();\r			}\r		}\r		else {\r			onshtabTipoOferta();\r		}				\r	}\r\r	function onshtabTipoOferta() {\r		if(document.getElementById(\"ExclusionTipoOferta\").style.visibility!='hidden') {\r			if(document.getElementById(\"ExclusionTipoOferta\").disabled!=true) {\r				focaliza(\"formulario.ExclusionTipoOferta\");\r			}\r			else {\r				onshtabExclusionTipoOferta();\r			}\r		}\r		else {\r			onshtabExclusionTipoOferta();\r		}			\r	}\r\r	function onshtabExclusionTipoOferta() {\r		if(document.getElementById(\"cbGenerico\").style.visibility!='hidden') {\r			if(document.getElementById(\"cbGenerico\").disabled!=true) {\r				focaliza(\"formulario.cbGenerico\");\r			}\r			else {\r				onshtabGenerico();\r			}\r		}\r		else {\r			onshtabGenerico();\r		}			\r	}\r\r	function onshtabGenerico() {\r		if(document.getElementById(\"cbSupergenerico\").style.visibility!='hidden') {\r			if(document.getElementById(\"cbSupergenerico\").disabled!=true) {\r				focaliza(\"formulario.cbSupergenerico\");\r			}\r			else {\r				onshtabSuperGenerico();\r			}\r		}\r		else {\r			onshtabSuperGenerico();\r		}			\r	}\r\r	function onshtabSuperGenerico() {\r		if(document.getElementById(\"cbNegocio\").style.visibility!='hidden') {\r			if(document.getElementById(\"cbNegocio\").disabled!=true) {\r				focaliza(\"formulario.cbNegocio\");\r			}\r			else {\r				onshtabNegocio();\r			}\r		}\r		else {\r			onshtabNegocio();\r		}		\r	}\r\r	function onshtabNegocio() {\r		if(document.getElementById(\"cbUnidadNegocio\").style.visibility!='hidden') {\r			if(document.getElementById(\"cbUnidadNegocio\").disabled!=true) {\r				focaliza(\"formulario.cbUnidadNegocio\");\r			}\r			else {\r				onshtabUnidadNegocio();\r			}\r		}\r		else {\r			onshtabUnidadNegocio();\r		}		\r	}\r\r	function onshtabUnidadNegocio() {\r		if(document.getElementById(\"cbMarca\").style.visibility!='hidden') {\r			if(document.getElementById(\"cbMarca\").disabled!=true) {\r				focaliza(\"formulario.cbMarca\");\r			}\r			else {\r				onshtabMarca();\r			}\r		}\r		else {\r			onshtabMarca();\r		}		\r	}\r\r	function onshtabMarca() {\r		focalizaBotonHTML('botonContenido','btnEliminar2')\r	}\r    \r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","utilidadesIngresarDesc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","utilidadesDTO.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbMarca" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","2448" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbUnidadNegocio" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","537" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbNegocio" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","588" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbSupergenerico" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","590" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbGenerico" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","589" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbCicloVida" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","581" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:7   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(14)).setAttribute("nombre","formulario" );
      ((Element)v.get(14)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","accion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidOidBase" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidOidDescuento" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 14   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidDetalleCriterios" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidDetalleProductos" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hExito" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidMarcasSel" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidUniNegSel" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidNegocioSel" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidSuperGenericoSel" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidGenericoSel" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidETO" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","selTipoOferta" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","selCicloVida" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","VisibleBCDM" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","ObligatorioBCDM" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","ModificableBCDM" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","VisibleBCDUN" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","ObligatorioBCDUN" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","ModificableBCDUN" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","VisibleBCDN" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","ObligatorioBCDN" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","ModificableBCDN" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","VisibleBCDSG" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","ObligatorioBCDSG" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","ModificableBCDSG" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","VisibleBCDG" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","ObligatorioBCDG" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","ModificableBCDG" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","VisibleBCDP" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","ObligatorioBCDP" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","ModificableBCDP" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hidUltimoElementoEnLaLista" );
      ((Element)v.get(52)).setAttribute("valor","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","oidMarcaCorporativa" );
      ((Element)v.get(53)).setAttribute("valor","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(54)).setAttribute("nombre","capaTamanyo" );
      ((Element)v.get(14)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("bgcolor","red" );
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(55)).setAttribute("height","100%" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("class","menu5" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","12" );
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(57)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","12" );
      ((Element)v.get(58)).setAttribute("height","10" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(59)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Elemento padre:59 / Elemento actual: 60   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(59)).appendChild((Text)v.get(60));

      /* Termina nodo Texto:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","10" );
      ((Element)v.get(61)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(61)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","10" );
      ((Element)v.get(62)).setAttribute("height","0" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","10" );
      ((Element)v.get(63)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","10" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","20" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(66)).setAttribute("width","75" );
      ((Element)v.get(66)).setAttribute("border","0" );
      ((Element)v.get(66)).setAttribute("align","center" );
      ((Element)v.get(66)).setAttribute("cellpadding","1" );
      ((Element)v.get(66)).setAttribute("cellspacing","0" );
      ((Element)v.get(66)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("a"));
      ((Element)v.get(69)).setAttribute("href","#" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(70)).setAttribute("ID","InsertarP1" );
      ((Element)v.get(70)).setAttribute("onmouseover","poneManito('InsertarP1');" );
      ((Element)v.get(70)).setAttribute("onclick","onClickPestanya('0')" );
      ((Element)v.get(70)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Elemento padre:70 / Elemento actual: 71   */
      v.add(doc.createTextNode("Datos generales"));
      ((Element)v.get(70)).appendChild((Text)v.get(71));

      /* Termina nodo Texto:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:72 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","10" );
      ((Element)v.get(72)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","10" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","20" );
      ((Element)v.get(74)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(74)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("table"));
      ((Element)v.get(75)).setAttribute("width","75" );
      ((Element)v.get(75)).setAttribute("border","0" );
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(75)).setAttribute("cellpadding","1" );
      ((Element)v.get(75)).setAttribute("cellspacing","0" );
      ((Element)v.get(75)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).setAttribute("align","center" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(78)).setAttribute("ID","InsertarP2" );
      ((Element)v.get(78)).setAttribute("onmouseover","poneManito('InsertarP2');" );
      ((Element)v.get(78)).setAttribute("onclick","onClickPestanya('1')" );
      ((Element)v.get(78)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Elemento padre:78 / Elemento actual: 79   */
      v.add(doc.createTextNode("Tipo de cliente"));
      ((Element)v.get(78)).appendChild((Text)v.get(79));

      /* Termina nodo Texto:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:80 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","10" );
      ((Element)v.get(80)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","10" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","20" );
      ((Element)v.get(82)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("table"));
      ((Element)v.get(83)).setAttribute("width","75" );
      ((Element)v.get(83)).setAttribute("border","0" );
      ((Element)v.get(83)).setAttribute("align","center" );
      ((Element)v.get(83)).setAttribute("cellpadding","1" );
      ((Element)v.get(83)).setAttribute("cellspacing","0" );
      ((Element)v.get(83)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(84)).setAttribute("align","center" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(86)).setAttribute("ID","InsertarP3" );
      ((Element)v.get(86)).setAttribute("onmouseover","poneManito('InsertarP3');" );
      ((Element)v.get(86)).setAttribute("onclick","onClickPestanya('2')" );
      ((Element)v.get(86)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Elemento padre:86 / Elemento actual: 87   */
      v.add(doc.createTextNode("Alcance administrativo"));
      ((Element)v.get(86)).appendChild((Text)v.get(87));

      /* Termina nodo Texto:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:88 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","10" );
      ((Element)v.get(88)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","10" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("width","20" );
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("table"));
      ((Element)v.get(91)).setAttribute("width","75" );
      ((Element)v.get(91)).setAttribute("border","0" );
      ((Element)v.get(91)).setAttribute("align","center" );
      ((Element)v.get(91)).setAttribute("cellpadding","1" );
      ((Element)v.get(91)).setAttribute("cellspacing","0" );
      ((Element)v.get(91)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(92)).setAttribute("align","center" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(94)).setAttribute("ID","InsertarP4" );
      ((Element)v.get(94)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Elemento padre:94 / Elemento actual: 95   */
      v.add(doc.createTextNode("Base de cálculo"));
      ((Element)v.get(94)).appendChild((Text)v.get(95));

      /* Termina nodo Texto:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:96 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","10" );
      ((Element)v.get(96)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","10" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("width","20" );
      ((Element)v.get(98)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(98)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("table"));
      ((Element)v.get(99)).setAttribute("width","75" );
      ((Element)v.get(99)).setAttribute("border","0" );
      ((Element)v.get(99)).setAttribute("align","center" );
      ((Element)v.get(99)).setAttribute("cellpadding","1" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).setAttribute("align","center" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(101)).setAttribute("class","menu5textonegrita" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(102)).setAttribute("ID","InsertarP5" );
      ((Element)v.get(102)).setAttribute("onmouseover","poneManito('InsertarP5');" );
      ((Element)v.get(102)).setAttribute("onclick","onClickPestanya('4')" );
      ((Element)v.get(102)).setAttribute("style","width:80px;border-style:solid; border-color:#496A9A;border-width:2px;position:relative;top:3px;text-align:center;color:#496A9A;font-family: Arial, Helvetica, sans-serif;font-size: 11px;font-weight: bold; visibility:visible" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Elemento padre:102 / Elemento actual: 103   */
      v.add(doc.createTextNode("Aplicación de descuento"));
      ((Element)v.get(102)).appendChild((Text)v.get(103));

      /* Termina nodo Texto:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:104 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","16" );
      ((Element)v.get(104)).setAttribute("class","menu5texto" );
      ((Element)v.get(56)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","12" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:106 / Elemento padre: 54   */
      v.add(doc.createElement("table"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(106)).setAttribute("border","0" );
      ((Element)v.get(106)).setAttribute("cellspacing","0" );
      ((Element)v.get(106)).setAttribute("cellpadding","0" );
      ((Element)v.get(54)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","12" );
      ((Element)v.get(108)).setAttribute("align","center" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","12" );
      ((Element)v.get(109)).setAttribute("height","12" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","750" );
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","12" );
      ((Element)v.get(107)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","12" );
      ((Element)v.get(113)).setAttribute("height","1" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:107   */

      /* Empieza nodo:114 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(119)).setAttribute("class","legend" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lblDefinicionBases" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("cod","0097" );
      ((Element)v.get(120)).setAttribute("id","legend" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 118   */
      v.add(doc.createElement("table"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(121)).setAttribute("border","0" );
      ((Element)v.get(121)).setAttribute("align","center" );
      ((Element)v.get(121)).setAttribute("cellspacing","0" );
      ((Element)v.get(121)).setAttribute("cellpadding","0" );
      ((Element)v.get(118)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","575" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("align","left" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("colspan","4" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:128 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","2448" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","25" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(136)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(136)).setAttribute("alto","13" );
      ((Element)v.get(136)).setAttribute("filas","1" );
      ((Element)v.get(136)).setAttribute("valor","" );
      ((Element)v.get(136)).setAttribute("id","datosTitle" );
      ((Element)v.get(136)).setAttribute("cod","587" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(137)).setAttribute("colspan","2" );
      ((Element)v.get(128)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:128   */

      /* Empieza nodo:139 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(143)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(143)).setAttribute("id","datosCampos" );
      ((Element)v.get(143)).setAttribute("size","1" );
      ((Element)v.get(143)).setAttribute("multiple","N" );
      ((Element)v.get(143)).setAttribute("req","N" );
      ((Element)v.get(143)).setAttribute("valorinicial","" );
      ((Element)v.get(143)).setAttribute("textoinicial","" );
      ((Element)v.get(143)).setAttribute("ontab","ontabComboMarca();" );
      ((Element)v.get(143)).setAttribute("onshtab","onshtabMarca();" );
      ((Element)v.get(143)).setAttribute("onchange","marcaOnChange();" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:145 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","25" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(139)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(148)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(148)).setAttribute("id","datosCampos" );
      ((Element)v.get(148)).setAttribute("size","1" );
      ((Element)v.get(148)).setAttribute("multiple","N" );
      ((Element)v.get(148)).setAttribute("req","N" );
      ((Element)v.get(148)).setAttribute("valorinicial","" );
      ((Element)v.get(148)).setAttribute("textoinicial","" );
      ((Element)v.get(148)).setAttribute("ontab","ontabComboUnidadNegocio();" );
      ((Element)v.get(148)).setAttribute("onchange","unidadNegocioOnChange();" );
      ((Element)v.get(148)).setAttribute("onshtab","onshtabUnidadNegocio();" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:150 / Elemento padre: 139   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(139)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:139   */

      /* Empieza nodo:152 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("colspan","4" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:155 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("table"));
      ((Element)v.get(157)).setAttribute("width","575" );
      ((Element)v.get(157)).setAttribute("border","0" );
      ((Element)v.get(157)).setAttribute("align","left" );
      ((Element)v.get(157)).setAttribute("cellspacing","0" );
      ((Element)v.get(157)).setAttribute("cellpadding","0" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(162)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(162)).setAttribute("alto","13" );
      ((Element)v.get(162)).setAttribute("filas","1" );
      ((Element)v.get(162)).setAttribute("valor","" );
      ((Element)v.get(162)).setAttribute("id","datosTitle" );
      ((Element)v.get(162)).setAttribute("cod","588" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","25" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(166)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(166)).setAttribute("alto","13" );
      ((Element)v.get(166)).setAttribute("filas","1" );
      ((Element)v.get(166)).setAttribute("valor","" );
      ((Element)v.get(166)).setAttribute("id","datosTitle" );
      ((Element)v.get(166)).setAttribute("cod","590" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","100%" );
      ((Element)v.get(167)).setAttribute("colspan","2" );
      ((Element)v.get(158)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:158   */

      /* Empieza nodo:169 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(169)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(173)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(173)).setAttribute("id","datosCampos" );
      ((Element)v.get(173)).setAttribute("size","1" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(173)).setAttribute("multiple","N" );
      ((Element)v.get(173)).setAttribute("req","N" );
      ((Element)v.get(173)).setAttribute("valorinicial","" );
      ((Element)v.get(173)).setAttribute("textoinicial","" );
      ((Element)v.get(173)).setAttribute("ontab","ontabComboNegocio();" );
      ((Element)v.get(173)).setAttribute("onchange","NegocioOnChange();" );
      ((Element)v.get(173)).setAttribute("onshtab","onshtabNegocio();" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:175 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","25" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(169)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(178)).setAttribute("nombre","cbSupergenerico" );
      ((Element)v.get(178)).setAttribute("id","datosCampos" );
      ((Element)v.get(178)).setAttribute("size","1" );
      ((Element)v.get(178)).setAttribute("multiple","N" );
      ((Element)v.get(178)).setAttribute("req","N" );
      ((Element)v.get(178)).setAttribute("valorinicial","" );
      ((Element)v.get(178)).setAttribute("textoinicial","" );
      ((Element)v.get(178)).setAttribute("ontab","ontabComboSuperGenerico();" );
      ((Element)v.get(178)).setAttribute("onchange","SuperGenericoOnChange();" );
      ((Element)v.get(178)).setAttribute("onshtab","onshtabSuperGenerico();" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:180 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(169)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:169   */

      /* Empieza nodo:182 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("colspan","4" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:185 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("table"));
      ((Element)v.get(187)).setAttribute("width","575" );
      ((Element)v.get(187)).setAttribute("border","0" );
      ((Element)v.get(187)).setAttribute("align","left" );
      ((Element)v.get(187)).setAttribute("cellspacing","0" );
      ((Element)v.get(187)).setAttribute("cellpadding","0" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("valor","" );
      ((Element)v.get(192)).setAttribute("id","datosTitle" );
      ((Element)v.get(192)).setAttribute("cod","589" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","25" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(188)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(196)).setAttribute("nombre","lblExclusionTipoOferta" );
      ((Element)v.get(196)).setAttribute("alto","13" );
      ((Element)v.get(196)).setAttribute("filas","1" );
      ((Element)v.get(196)).setAttribute("valor","Exclusión tipo oferta" );
      ((Element)v.get(196)).setAttribute("id","datosTitle" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("width","100%" );
      ((Element)v.get(197)).setAttribute("colspan","2" );
      ((Element)v.get(188)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:188   */

      /* Empieza nodo:199 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(187)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(199)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(203)).setAttribute("nombre","cbGenerico" );
      ((Element)v.get(203)).setAttribute("id","datosCampos" );
      ((Element)v.get(203)).setAttribute("size","1" );
      ((Element)v.get(203)).setAttribute("multiple","N" );
      ((Element)v.get(203)).setAttribute("req","N" );
      ((Element)v.get(203)).setAttribute("valorinicial","" );
      ((Element)v.get(203)).setAttribute("textoinicial","" );
      ((Element)v.get(203)).setAttribute("ontab","ontabComboGenerico();" );
      ((Element)v.get(203)).setAttribute("onchange","GenericoOnChange();" );
      ((Element)v.get(203)).setAttribute("onshtab","onshtabGenerico();" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:205 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","25" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(208)).setAttribute("nombre","ExclusionTipoOferta" );
      ((Element)v.get(208)).setAttribute("id","datosCampos" );
      ((Element)v.get(208)).setAttribute("onclick","cambiaEstado();" );
      ((Element)v.get(208)).setAttribute("check","N" );
      ((Element)v.get(208)).setAttribute("onshtab","onshtabExclusionTipoOferta();" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("width","100%" );
      ((Element)v.get(199)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","8" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:199   */

      /* Empieza nodo:211 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(187)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("colspan","4" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:214 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("table"));
      ((Element)v.get(216)).setAttribute("width","575" );
      ((Element)v.get(216)).setAttribute("border","0" );
      ((Element)v.get(216)).setAttribute("align","left" );
      ((Element)v.get(216)).setAttribute("cellspacing","0" );
      ((Element)v.get(216)).setAttribute("cellpadding","0" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(221)).setAttribute("nombre","lblTipoOferta" );
      ((Element)v.get(221)).setAttribute("alto","13" );
      ((Element)v.get(221)).setAttribute("filas","1" );
      ((Element)v.get(221)).setAttribute("valor","" );
      ((Element)v.get(221)).setAttribute("id","datosTitle" );
      ((Element)v.get(221)).setAttribute("cod","608" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","25" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(225)).setAttribute("nombre","lblCicloVida" );
      ((Element)v.get(225)).setAttribute("alto","13" );
      ((Element)v.get(225)).setAttribute("filas","1" );
      ((Element)v.get(225)).setAttribute("valor","" );
      ((Element)v.get(225)).setAttribute("id","datosTitle" );
      ((Element)v.get(225)).setAttribute("cod","581" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("width","100%" );
      ((Element)v.get(226)).setAttribute("colspan","2" );
      ((Element)v.get(217)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:217   */

      /* Empieza nodo:228 / Elemento padre: 216   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(216)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(228)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(232)).setAttribute("nombre","cbTipoOferta" );
      ((Element)v.get(232)).setAttribute("id","datosCampos" );
      ((Element)v.get(232)).setAttribute("size","5" );
      ((Element)v.get(232)).setAttribute("multiple","S" );
      ((Element)v.get(232)).setAttribute("req","N" );
      ((Element)v.get(232)).setAttribute("valorinicial","" );
      ((Element)v.get(232)).setAttribute("textoinicial","" );
      ((Element)v.get(232)).setAttribute("onchange","cbTipoOfertaOnChange();" );
      ((Element)v.get(232)).setAttribute("onshtab","onshtabTipoOferta();" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:234 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","25" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(228)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(237)).setAttribute("nombre","cbCicloVida" );
      ((Element)v.get(237)).setAttribute("id","datosCampos" );
      ((Element)v.get(237)).setAttribute("size","5" );
      ((Element)v.get(237)).setAttribute("multiple","S" );
      ((Element)v.get(237)).setAttribute("req","S" );
      ((Element)v.get(237)).setAttribute("valorinicial","" );
      ((Element)v.get(237)).setAttribute("textoinicial","" );
      ((Element)v.get(237)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnEliminar');" );
      ((Element)v.get(237)).setAttribute("onchange","cbCicloVidaOnChange();" );
      ((Element)v.get(237)).setAttribute("onshtab","onshtabCicloVida();" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:239 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("width","100%" );
      ((Element)v.get(228)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:228   */

      /* Empieza nodo:241 / Elemento padre: 216   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(216)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("colspan","4" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","331" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:121   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:244 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(245)).setAttribute("height","12" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:114   */

      /* Empieza nodo:246 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("table"));
      ((Element)v.get(251)).setAttribute("width","100%" );
      ((Element)v.get(251)).setAttribute("border","0" );
      ((Element)v.get(251)).setAttribute("align","center" );
      ((Element)v.get(251)).setAttribute("cellspacing","0" );
      ((Element)v.get(251)).setAttribute("cellpadding","0" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("class","botonera" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(254)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(254)).setAttribute("ID","botonContenido" );
      ((Element)v.get(254)).setAttribute("tipo","html" );
      ((Element)v.get(254)).setAttribute("accion","accionAniadir();" );
      ((Element)v.get(254)).setAttribute("estado","false" );
      ((Element)v.get(254)).setAttribute("cod","404" );
      ((Element)v.get(254)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnSiguiente')" );
      ((Element)v.get(254)).setAttribute("onshtab","onShTabAnadir();" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:255 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:246   */

      /* Empieza nodo:257 / Elemento padre: 106   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(106)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).setAttribute("width","12" );
      ((Element)v.get(258)).setAttribute("align","center" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","12" );
      ((Element)v.get(259)).setAttribute("height","12" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).setAttribute("width","756" );
      ((Element)v.get(257)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("width","12" );
      ((Element)v.get(257)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","12" );
      ((Element)v.get(263)).setAttribute("height","12" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:257   */
      /* Termina nodo:106   */
      /* Termina nodo:54   */

      /* Empieza nodo:264 / Elemento padre: 14   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(264)).setAttribute("nombre","listado1" );
      ((Element)v.get(264)).setAttribute("ancho","555" );
      ((Element)v.get(264)).setAttribute("alto","301" );
      ((Element)v.get(264)).setAttribute("x","24" );
      ((Element)v.get(264)).setAttribute("y","261" );
      ((Element)v.get(264)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(264)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(265)).setAttribute("precarga","S" );
      ((Element)v.get(265)).setAttribute("conROver","S" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(266)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(266)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(266)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(266)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 265   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(267)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(267)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(267)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(267)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(265)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 265   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(268)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(268)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(265)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:265   */

      /* Empieza nodo:269 / Elemento padre: 264   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(264)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(270)).setAttribute("borde","1" );
      ((Element)v.get(270)).setAttribute("horizDatos","1" );
      ((Element)v.get(270)).setAttribute("horizCabecera","1" );
      ((Element)v.get(270)).setAttribute("vertical","0" );
      ((Element)v.get(270)).setAttribute("horizTitulo","1" );
      ((Element)v.get(270)).setAttribute("horizBase","1" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 269   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(271)).setAttribute("borde","#999999" );
      ((Element)v.get(271)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(271)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(271)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(271)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(271)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(271)).setAttribute("horizBase","#999999" );
      ((Element)v.get(269)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:269   */

      /* Empieza nodo:272 / Elemento padre: 264   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(272)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(272)).setAttribute("alto","22" );
      ((Element)v.get(272)).setAttribute("imgFondo","" );
      ((Element)v.get(272)).setAttribute("cod","515" );
      ((Element)v.get(272)).setAttribute("ID","datosTitle" );
      ((Element)v.get(264)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 264   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(273)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(273)).setAttribute("alto","22" );
      ((Element)v.get(273)).setAttribute("imgFondo","" );
      ((Element)v.get(264)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 264   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(274)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(274)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(274)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(274)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(274)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(274)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(264)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("ancho","20" );
      ((Element)v.get(275)).setAttribute("minimizable","S" );
      ((Element)v.get(275)).setAttribute("minimizada","N" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 274   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("ancho","40" );
      ((Element)v.get(276)).setAttribute("minimizable","S" );
      ((Element)v.get(276)).setAttribute("minimizada","N" );
      ((Element)v.get(276)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(274)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:274   */

      /* Empieza nodo:277 / Elemento padre: 264   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(277)).setAttribute("alto","20" );
      ((Element)v.get(277)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(277)).setAttribute("imgFondo","" );
      ((Element)v.get(277)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(264)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("colFondo","" );
      ((Element)v.get(278)).setAttribute("ID","EstCab" );
      ((Element)v.get(278)).setAttribute("align","center" );
      ((Element)v.get(278)).setAttribute("cod","337" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Elemento padre:278 / Elemento actual: 279   */
      v.add(doc.createTextNode("Código producto"));
      ((Element)v.get(278)).appendChild((Text)v.get(279));

      /* Termina nodo Texto:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 277   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("colFondo","" );
      ((Element)v.get(280)).setAttribute("ID","EstCab" );
      ((Element)v.get(280)).setAttribute("cod","338" );
      ((Element)v.get(277)).appendChild((Element)v.get(280));

      /* Elemento padre:280 / Elemento actual: 281   */
      v.add(doc.createTextNode("Descripción producto"));
      ((Element)v.get(280)).appendChild((Text)v.get(281));

      /* Termina nodo Texto:281   */
      /* Termina nodo:280   */
      /* Termina nodo:277   */

      /* Empieza nodo:282 / Elemento padre: 264   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(282)).setAttribute("alto","22" );
      ((Element)v.get(282)).setAttribute("accion","" );
      ((Element)v.get(282)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(282)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(282)).setAttribute("maxSel","-1" );
      ((Element)v.get(282)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(282)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(282)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(282)).setAttribute("onLoad","" );
      ((Element)v.get(282)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(264)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("tipo","texto" );
      ((Element)v.get(283)).setAttribute("ID","EstDat" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 282   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("tipo","texto" );
      ((Element)v.get(284)).setAttribute("ID","EstDat2" );
      ((Element)v.get(282)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:282   */

      /* Empieza nodo:285 / Elemento padre: 264   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(264)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 264   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(286)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(286)).setAttribute("ancho","555" );
      ((Element)v.get(286)).setAttribute("sep","$" );
      ((Element)v.get(286)).setAttribute("x","24" );
      ((Element)v.get(286)).setAttribute("class","botonera" );
      ((Element)v.get(286)).setAttribute("y","519" );
      ((Element)v.get(286)).setAttribute("control","|" );
      ((Element)v.get(286)).setAttribute("conector","" );
      ((Element)v.get(286)).setAttribute("rowset","" );
      ((Element)v.get(286)).setAttribute("cargainicial","N" );
      ((Element)v.get(264)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(287)).setAttribute("nombre","ret1" );
      ((Element)v.get(287)).setAttribute("x","49" );
      ((Element)v.get(287)).setAttribute("y","543" );
      ((Element)v.get(287)).setAttribute("ID","botonContenido" );
      ((Element)v.get(287)).setAttribute("img","retroceder_on" );
      ((Element)v.get(287)).setAttribute("tipo","0" );
      ((Element)v.get(287)).setAttribute("estado","false" );
      ((Element)v.get(287)).setAttribute("alt","" );
      ((Element)v.get(287)).setAttribute("codigo","" );
      ((Element)v.get(287)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 286   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(288)).setAttribute("nombre","ava1" );
      ((Element)v.get(288)).setAttribute("x","64" );
      ((Element)v.get(288)).setAttribute("y","543" );
      ((Element)v.get(288)).setAttribute("ID","botonContenido" );
      ((Element)v.get(288)).setAttribute("img","avanzar_on" );
      ((Element)v.get(288)).setAttribute("tipo","0" );
      ((Element)v.get(288)).setAttribute("estado","false" );
      ((Element)v.get(288)).setAttribute("alt","" );
      ((Element)v.get(288)).setAttribute("codigo","" );
      ((Element)v.get(288)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(286)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:286   */
      /* Termina nodo:264   */

      /* Empieza nodo:289 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(289)).setAttribute("nombre","primera1" );
      ((Element)v.get(289)).setAttribute("x","32" );
      ((Element)v.get(289)).setAttribute("y","543" );
      ((Element)v.get(289)).setAttribute("ID","botonContenido" );
      ((Element)v.get(289)).setAttribute("img","primera_on" );
      ((Element)v.get(289)).setAttribute("tipo","-2" );
      ((Element)v.get(289)).setAttribute("estado","false" );
      ((Element)v.get(289)).setAttribute("alt","" );
      ((Element)v.get(289)).setAttribute("codigo","" );
      ((Element)v.get(289)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(14)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(290)).setAttribute("nombre","separa" );
      ((Element)v.get(290)).setAttribute("x","71" );
      ((Element)v.get(290)).setAttribute("y","539" );
      ((Element)v.get(290)).setAttribute("ID","botonContenido" );
      ((Element)v.get(290)).setAttribute("img","separa_base" );
      ((Element)v.get(290)).setAttribute("tipo","0" );
      ((Element)v.get(290)).setAttribute("estado","false" );
      ((Element)v.get(290)).setAttribute("alt","" );
      ((Element)v.get(290)).setAttribute("codigo","" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(290)).setAttribute("accion","" );
      ((Element)v.get(14)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(291)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(291)).setAttribute("x","79" );
      ((Element)v.get(291)).setAttribute("y","540" );
      ((Element)v.get(291)).setAttribute("ID","botonContenido" );
      ((Element)v.get(291)).setAttribute("tipo","html" );
      ((Element)v.get(291)).setAttribute("estado","false" );
      ((Element)v.get(291)).setAttribute("cod","445" );
      ((Element)v.get(291)).setAttribute("accion","accionBuscarProductos();" );
      ((Element)v.get(291)).setAttribute("ontab","focalizaBotonHTML('botonContenido','btnAnadir')" );
      ((Element)v.get(291)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnEliminar')" );
      ((Element)v.get(14)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(292)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(292)).setAttribute("x","25" );
      ((Element)v.get(292)).setAttribute("y","540" );
      ((Element)v.get(292)).setAttribute("ID","botonContenido" );
      ((Element)v.get(292)).setAttribute("tipo","html" );
      ((Element)v.get(292)).setAttribute("estado","false" );
      ((Element)v.get(292)).setAttribute("cod","1254" );
      ((Element)v.get(292)).setAttribute("accion","accionEliminar();" );
      ((Element)v.get(292)).setAttribute("ontab","onTabEliminar();" );
      ((Element)v.get(292)).setAttribute("onshtab","focaliza('formulario.cbCicloVida')" );
      ((Element)v.get(14)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 14   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(293)).setAttribute("nombre","listado2" );
      ((Element)v.get(293)).setAttribute("ancho","579" );
      ((Element)v.get(293)).setAttribute("alto","317" );
      ((Element)v.get(293)).setAttribute("x","12" );
      ((Element)v.get(293)).setAttribute("y","611" );
      ((Element)v.get(293)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(293)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(294)).setAttribute("precarga","S" );
      ((Element)v.get(294)).setAttribute("conROver","S" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(295)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(295)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(295)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(295)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 294   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(296)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(296)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(296)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(296)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(294)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 294   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(297)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(297)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(294)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:294   */

      /* Empieza nodo:298 / Elemento padre: 293   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(293)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(299)).setAttribute("borde","1" );
      ((Element)v.get(299)).setAttribute("horizDatos","1" );
      ((Element)v.get(299)).setAttribute("horizCabecera","1" );
      ((Element)v.get(299)).setAttribute("vertical","0" );
      ((Element)v.get(299)).setAttribute("horizTitulo","1" );
      ((Element)v.get(299)).setAttribute("horizBase","1" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 298   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(300)).setAttribute("borde","#999999" );
      ((Element)v.get(300)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(300)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(300)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(300)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(300)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(300)).setAttribute("horizBase","#999999" );
      ((Element)v.get(298)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:298   */

      /* Empieza nodo:301 / Elemento padre: 293   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(301)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(301)).setAttribute("alto","22" );
      ((Element)v.get(301)).setAttribute("imgFondo","" );
      ((Element)v.get(301)).setAttribute("ID","datosTitle" );
      ((Element)v.get(301)).setAttribute("cod","00579" );
      ((Element)v.get(293)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 293   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(302)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(302)).setAttribute("alto","22" );
      ((Element)v.get(302)).setAttribute("imgFondo","" );
      ((Element)v.get(293)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 293   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(303)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(303)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(303)).setAttribute("blancosAInsertar","1" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(303)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(303)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(303)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(293)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("ancho","30" );
      ((Element)v.get(304)).setAttribute("minimizable","S" );
      ((Element)v.get(304)).setAttribute("minimizada","N" );
      ((Element)v.get(304)).setAttribute("oculta","S" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("ancho","50" );
      ((Element)v.get(305)).setAttribute("minimizable","S" );
      ((Element)v.get(305)).setAttribute("minimizada","N" );
      ((Element)v.get(303)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("ancho","30" );
      ((Element)v.get(306)).setAttribute("minimizable","S" );
      ((Element)v.get(306)).setAttribute("minimizada","N" );
      ((Element)v.get(306)).setAttribute("oculta","S" );
      ((Element)v.get(303)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("ancho","100" );
      ((Element)v.get(307)).setAttribute("minimizable","S" );
      ((Element)v.get(307)).setAttribute("minimizada","N" );
      ((Element)v.get(303)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("ancho","30" );
      ((Element)v.get(308)).setAttribute("minimizable","S" );
      ((Element)v.get(308)).setAttribute("minimizada","N" );
      ((Element)v.get(308)).setAttribute("oculta","S" );
      ((Element)v.get(303)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("ancho","50" );
      ((Element)v.get(309)).setAttribute("minimizable","S" );
      ((Element)v.get(309)).setAttribute("minimizada","N" );
      ((Element)v.get(303)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("ancho","30" );
      ((Element)v.get(310)).setAttribute("minimizable","S" );
      ((Element)v.get(310)).setAttribute("minimizada","N" );
      ((Element)v.get(310)).setAttribute("oculta","S" );
      ((Element)v.get(303)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("ancho","80" );
      ((Element)v.get(311)).setAttribute("minimizable","S" );
      ((Element)v.get(311)).setAttribute("minimizada","N" );
      ((Element)v.get(303)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("ancho","30" );
      ((Element)v.get(312)).setAttribute("minimizable","S" );
      ((Element)v.get(312)).setAttribute("minimizada","N" );
      ((Element)v.get(312)).setAttribute("oculta","S" );
      ((Element)v.get(303)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("ancho","50" );
      ((Element)v.get(313)).setAttribute("minimizable","S" );
      ((Element)v.get(313)).setAttribute("minimizada","N" );
      ((Element)v.get(303)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(314)).setAttribute("ancho","120" );
      ((Element)v.get(314)).setAttribute("minimizable","S" );
      ((Element)v.get(314)).setAttribute("minimizada","N" );
      ((Element)v.get(303)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("ancho","30" );
      ((Element)v.get(315)).setAttribute("minimizable","S" );
      ((Element)v.get(315)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).setAttribute("oculta","S" );
      ((Element)v.get(303)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("ancho","100" );
      ((Element)v.get(316)).setAttribute("minimizable","S" );
      ((Element)v.get(316)).setAttribute("minimizada","N" );
      ((Element)v.get(303)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("ancho","30" );
      ((Element)v.get(317)).setAttribute("minimizable","S" );
      ((Element)v.get(317)).setAttribute("minimizada","N" );
      ((Element)v.get(317)).setAttribute("oculta","S" );
      ((Element)v.get(303)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("ancho","100" );
      ((Element)v.get(318)).setAttribute("minimizable","S" );
      ((Element)v.get(318)).setAttribute("minimizada","N" );
      ((Element)v.get(303)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("ancho","30" );
      ((Element)v.get(319)).setAttribute("minimizable","S" );
      ((Element)v.get(319)).setAttribute("minimizada","N" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(319)).setAttribute("oculta","S" );
      ((Element)v.get(303)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 303   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("ancho","80" );
      ((Element)v.get(320)).setAttribute("minimizable","S" );
      ((Element)v.get(320)).setAttribute("minimizada","N" );
      ((Element)v.get(303)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:303   */

      /* Empieza nodo:321 / Elemento padre: 293   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(321)).setAttribute("alto","20" );
      ((Element)v.get(321)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(321)).setAttribute("imgFondo","" );
      ((Element)v.get(321)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(293)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("colFondo","" );
      ((Element)v.get(322)).setAttribute("ID","EstCab" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Elemento padre:322 / Elemento actual: 323   */
      v.add(doc.createTextNode("oidMarca"));
      ((Element)v.get(322)).appendChild((Text)v.get(323));

      /* Termina nodo Texto:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("colFondo","" );
      ((Element)v.get(324)).setAttribute("ID","EstCab" );
      ((Element)v.get(324)).setAttribute("cod","6" );
      ((Element)v.get(321)).appendChild((Element)v.get(324));

      /* Elemento padre:324 / Elemento actual: 325   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(324)).appendChild((Text)v.get(325));

      /* Termina nodo Texto:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("colFondo","" );
      ((Element)v.get(326)).setAttribute("ID","EstCab" );
      ((Element)v.get(321)).appendChild((Element)v.get(326));

      /* Elemento padre:326 / Elemento actual: 327   */
      v.add(doc.createTextNode("oidUnidadNegocio"));
      ((Element)v.get(326)).appendChild((Text)v.get(327));

      /* Termina nodo Texto:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("colFondo","" );
      ((Element)v.get(328)).setAttribute("ID","EstCab" );
      ((Element)v.get(328)).setAttribute("cod","587" );
      ((Element)v.get(321)).appendChild((Element)v.get(328));

      /* Elemento padre:328 / Elemento actual: 329   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(328)).appendChild((Text)v.get(329));

      /* Termina nodo Texto:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(330)).setAttribute("colFondo","" );
      ((Element)v.get(330)).setAttribute("ID","EstCab" );
      ((Element)v.get(321)).appendChild((Element)v.get(330));

      /* Elemento padre:330 / Elemento actual: 331   */
      v.add(doc.createTextNode("oidNegocio"));
      ((Element)v.get(330)).appendChild((Text)v.get(331));

      /* Termina nodo Texto:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(332)).setAttribute("colFondo","" );
      ((Element)v.get(332)).setAttribute("ID","EstCab" );
      ((Element)v.get(332)).setAttribute("cod","588" );
      ((Element)v.get(321)).appendChild((Element)v.get(332));

      /* Elemento padre:332 / Elemento actual: 333   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(332)).appendChild((Text)v.get(333));

      /* Termina nodo Texto:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(334)).setAttribute("colFondo","" );
      ((Element)v.get(334)).setAttribute("ID","EstCab" );
      ((Element)v.get(321)).appendChild((Element)v.get(334));

      /* Elemento padre:334 / Elemento actual: 335   */
      v.add(doc.createTextNode("oidSupergenerico"));
      ((Element)v.get(334)).appendChild((Text)v.get(335));

      /* Termina nodo Texto:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(336)).setAttribute("colFondo","" );
      ((Element)v.get(336)).setAttribute("ID","EstCab" );
      ((Element)v.get(336)).setAttribute("cod","590" );
      ((Element)v.get(321)).appendChild((Element)v.get(336));

      /* Elemento padre:336 / Elemento actual: 337   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(336)).appendChild((Text)v.get(337));

      /* Termina nodo Texto:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(338)).setAttribute("colFondo","" );
      ((Element)v.get(338)).setAttribute("ID","EstCab" );
      ((Element)v.get(321)).appendChild((Element)v.get(338));

      /* Elemento padre:338 / Elemento actual: 339   */
      v.add(doc.createTextNode("oidGenerico"));
      ((Element)v.get(338)).appendChild((Text)v.get(339));

      /* Termina nodo Texto:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:340 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(340)).setAttribute("colFondo","" );
      ((Element)v.get(340)).setAttribute("ID","EstCab" );
      ((Element)v.get(340)).setAttribute("cod","589" );
      ((Element)v.get(321)).appendChild((Element)v.get(340));

      /* Elemento padre:340 / Elemento actual: 341   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(340)).appendChild((Text)v.get(341));

      /* Termina nodo Texto:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(342)).setAttribute("colFondo","" );
      ((Element)v.get(342)).setAttribute("ID","EstCab" );
      ((Element)v.get(342)).setAttribute("cod","2371" );
      ((Element)v.get(321)).appendChild((Element)v.get(342));

      /* Elemento padre:342 / Elemento actual: 343   */
      v.add(doc.createTextNode("Exclusión tipo oferta"));
      ((Element)v.get(342)).appendChild((Text)v.get(343));

      /* Termina nodo Texto:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("colFondo","" );
      ((Element)v.get(344)).setAttribute("ID","EstCab" );
      ((Element)v.get(321)).appendChild((Element)v.get(344));

      /* Elemento padre:344 / Elemento actual: 345   */
      v.add(doc.createTextNode("oidTipoOferta"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(344)).appendChild((Text)v.get(345));

      /* Termina nodo Texto:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(346)).setAttribute("colFondo","" );
      ((Element)v.get(346)).setAttribute("ID","EstCab" );
      ((Element)v.get(346)).setAttribute("cod","608" );
      ((Element)v.get(321)).appendChild((Element)v.get(346));

      /* Elemento padre:346 / Elemento actual: 347   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(346)).appendChild((Text)v.get(347));

      /* Termina nodo Texto:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("colFondo","" );
      ((Element)v.get(348)).setAttribute("ID","EstCab" );
      ((Element)v.get(321)).appendChild((Element)v.get(348));

      /* Elemento padre:348 / Elemento actual: 349   */
      v.add(doc.createTextNode("oidCicloVida"));
      ((Element)v.get(348)).appendChild((Text)v.get(349));

      /* Termina nodo Texto:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(350)).setAttribute("colFondo","" );
      ((Element)v.get(350)).setAttribute("ID","EstCab" );
      ((Element)v.get(350)).setAttribute("cod","581" );
      ((Element)v.get(321)).appendChild((Element)v.get(350));

      /* Elemento padre:350 / Elemento actual: 351   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(350)).appendChild((Text)v.get(351));

      /* Termina nodo Texto:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("colFondo","" );
      ((Element)v.get(352)).setAttribute("ID","EstCab" );
      ((Element)v.get(321)).appendChild((Element)v.get(352));

      /* Elemento padre:352 / Elemento actual: 353   */
      v.add(doc.createTextNode("oidProducto"));
      ((Element)v.get(352)).appendChild((Text)v.get(353));

      /* Termina nodo Texto:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("colFondo","" );
      ((Element)v.get(354)).setAttribute("ID","EstCab" );
      ((Element)v.get(354)).setAttribute("cod","574" );
      ((Element)v.get(321)).appendChild((Element)v.get(354));

      /* Elemento padre:354 / Elemento actual: 355   */
      v.add(doc.createTextNode("Producto"));
      ((Element)v.get(354)).appendChild((Text)v.get(355));

      /* Termina nodo Texto:355   */
      /* Termina nodo:354   */
      /* Termina nodo:321   */

      /* Empieza nodo:356 / Elemento padre: 293   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(356)).setAttribute("alto","22" );
      ((Element)v.get(356)).setAttribute("accion","" );
      ((Element)v.get(356)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(356)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(356)).setAttribute("maxSel","-1" );
      ((Element)v.get(356)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(356)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(356)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(356)).setAttribute("onLoad","" );
      ((Element)v.get(356)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(293)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("tipo","texto" );
      ((Element)v.get(357)).setAttribute("ID","EstDat" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("tipo","texto" );
      ((Element)v.get(358)).setAttribute("ID","EstDat" );
      ((Element)v.get(356)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(359)).setAttribute("tipo","texto" );
      ((Element)v.get(359)).setAttribute("ID","EstDat2" );
      ((Element)v.get(356)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(360)).setAttribute("tipo","texto" );
      ((Element)v.get(360)).setAttribute("ID","EstDat2" );
      ((Element)v.get(356)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */

      /* Empieza nodo:361 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(361)).setAttribute("tipo","texto" );
      ((Element)v.get(361)).setAttribute("ID","EstDat" );
      ((Element)v.get(356)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(362)).setAttribute("tipo","texto" );
      ((Element)v.get(362)).setAttribute("ID","EstDat" );
      ((Element)v.get(356)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(363)).setAttribute("tipo","texto" );
      ((Element)v.get(363)).setAttribute("ID","EstDat2" );
      ((Element)v.get(356)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(364)).setAttribute("tipo","texto" );
      ((Element)v.get(364)).setAttribute("ID","EstDat2" );
      ((Element)v.get(356)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(365)).setAttribute("tipo","texto" );
      ((Element)v.get(365)).setAttribute("ID","EstDat" );
      ((Element)v.get(356)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(366)).setAttribute("tipo","texto" );
      ((Element)v.get(366)).setAttribute("ID","EstDat" );
      ((Element)v.get(356)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(367)).setAttribute("tipo","texto" );
      ((Element)v.get(367)).setAttribute("ID","EstDat2" );
      ((Element)v.get(356)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 356   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("tipo","texto" );
      ((Element)v.get(368)).setAttribute("ID","EstDat2" );
      ((Element)v.get(356)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(369)).setAttribute("tipo","texto" );
      ((Element)v.get(369)).setAttribute("ID","EstDat" );
      ((Element)v.get(356)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(370)).setAttribute("tipo","texto" );
      ((Element)v.get(370)).setAttribute("ID","EstDat" );
      ((Element)v.get(356)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(371)).setAttribute("tipo","texto" );
      ((Element)v.get(371)).setAttribute("ID","EstDat2" );
      ((Element)v.get(356)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(372)).setAttribute("tipo","texto" );
      ((Element)v.get(372)).setAttribute("ID","EstDat2" );
      ((Element)v.get(356)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */

      /* Empieza nodo:373 / Elemento padre: 356   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(373)).setAttribute("tipo","texto" );
      ((Element)v.get(373)).setAttribute("ID","EstDat" );
      ((Element)v.get(356)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:356   */

      /* Empieza nodo:374 / Elemento padre: 293   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(293)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 293   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(375)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(375)).setAttribute("ancho","579" );
      ((Element)v.get(375)).setAttribute("sep","$" );
      ((Element)v.get(375)).setAttribute("x","12" );
      ((Element)v.get(375)).setAttribute("class","botonera" );
      ((Element)v.get(375)).setAttribute("y","905" );
      ((Element)v.get(375)).setAttribute("control","|" );
      ((Element)v.get(375)).setAttribute("conector","" );
      ((Element)v.get(375)).setAttribute("rowset","" );
      ((Element)v.get(375)).setAttribute("cargainicial","N" );
      ((Element)v.get(293)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(376)).setAttribute("nombre","ret2" );
      ((Element)v.get(376)).setAttribute("x","37" );
      ((Element)v.get(376)).setAttribute("y","909" );
      ((Element)v.get(376)).setAttribute("ID","botonContenido" );
      ((Element)v.get(376)).setAttribute("img","retroceder_on" );
      ((Element)v.get(376)).setAttribute("tipo","0" );
      ((Element)v.get(376)).setAttribute("estado","false" );
      ((Element)v.get(376)).setAttribute("alt","" );
      ((Element)v.get(376)).setAttribute("codigo","" );
      ((Element)v.get(376)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 375   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(377)).setAttribute("nombre","ava2" );
      ((Element)v.get(377)).setAttribute("x","52" );
      ((Element)v.get(377)).setAttribute("y","909" );
      ((Element)v.get(377)).setAttribute("ID","botonContenido" );
      ((Element)v.get(377)).setAttribute("img","avanzar_on" );
      ((Element)v.get(377)).setAttribute("tipo","0" );
      ((Element)v.get(377)).setAttribute("estado","false" );
      ((Element)v.get(377)).setAttribute("alt","" );
      ((Element)v.get(377)).setAttribute("codigo","" );
      ((Element)v.get(377)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(375)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:375   */
      /* Termina nodo:293   */

      /* Empieza nodo:378 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(378)).setAttribute("nombre","primera2" );
      ((Element)v.get(378)).setAttribute("x","20" );
      ((Element)v.get(378)).setAttribute("y","909" );
      ((Element)v.get(378)).setAttribute("ID","botonContenido" );
      ((Element)v.get(378)).setAttribute("img","primera_on" );
      ((Element)v.get(378)).setAttribute("tipo","-2" );
      ((Element)v.get(378)).setAttribute("estado","false" );
      ((Element)v.get(378)).setAttribute("alt","" );
      ((Element)v.get(378)).setAttribute("codigo","" );
      ((Element)v.get(378)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(14)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(379)).setAttribute("nombre","separa2" );
      ((Element)v.get(379)).setAttribute("x","59" );
      ((Element)v.get(379)).setAttribute("y","905" );
      ((Element)v.get(379)).setAttribute("ID","botonContenido" );
      ((Element)v.get(379)).setAttribute("img","separa_base" );
      ((Element)v.get(379)).setAttribute("tipo","0" );
      ((Element)v.get(379)).setAttribute("estado","false" );
      ((Element)v.get(379)).setAttribute("alt","" );
      ((Element)v.get(379)).setAttribute("codigo","" );
      ((Element)v.get(379)).setAttribute("accion","" );
      ((Element)v.get(14)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(380)).setAttribute("nombre","btnSiguiente" );
      ((Element)v.get(380)).setAttribute("x","13" );
      ((Element)v.get(380)).setAttribute("y","906" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(380)).setAttribute("ID","botonContenido" );
      ((Element)v.get(380)).setAttribute("tipo","html" );
      ((Element)v.get(380)).setAttribute("estado","false" );
      ((Element)v.get(380)).setAttribute("cod","446" );
      ((Element)v.get(380)).setAttribute("accion","accionSiguiente();" );
      ((Element)v.get(380)).setAttribute("ontab","onTabSiguiente();" );
      ((Element)v.get(380)).setAttribute("onshtab","onShTabSiguiente();" );
      ((Element)v.get(14)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(381)).setAttribute("nombre","btnEliminar2" );
      ((Element)v.get(381)).setAttribute("x","79" );
      ((Element)v.get(381)).setAttribute("y","906" );
      ((Element)v.get(381)).setAttribute("ID","botonContenido" );
      ((Element)v.get(381)).setAttribute("tipo","html" );
      ((Element)v.get(381)).setAttribute("estado","false" );
      ((Element)v.get(381)).setAttribute("cod","1254" );
      ((Element)v.get(381)).setAttribute("accion","accionEliminar2()" );
      ((Element)v.get(381)).setAttribute("ontab","onTabEliminar2();" );
      ((Element)v.get(14)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(382)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(382)).setAttribute("alto","12" );
      ((Element)v.get(382)).setAttribute("ancho","100%" );
      ((Element)v.get(382)).setAttribute("colorf","" );
      ((Element)v.get(382)).setAttribute("borde","0" );
      ((Element)v.get(382)).setAttribute("imagenf","" );
      ((Element)v.get(382)).setAttribute("repeat","" );
      ((Element)v.get(382)).setAttribute("padding","" );
      ((Element)v.get(382)).setAttribute("visibilidad","visible" );
      ((Element)v.get(382)).setAttribute("contravsb","" );
      ((Element)v.get(382)).setAttribute("x","0" );
      ((Element)v.get(382)).setAttribute("y","928" );
      ((Element)v.get(382)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:14   */


   }

}
