  var varNoLimpiarSICC = true;
  var comboSGV;
  var comboRegion;
  var comboZona;  
  var comboNivel;
  var comboGrupo;

  function obtieneValoresGrupo(){
    var cantElems = combo_get("frmInsertarCartera.cbGrupoSolicitud", "L", "");
    var oids = new Array();

    for (var i = 0; i < cantElems; i++)	{
      var oid = combo_get("frmInsertarCartera.cbGrupoSolicitud", "V", i);
      var desc = combo_get("frmInsertarCartera.cbGrupoSolicitud", "T", i);
      if ( oid != "")		{
        var array = new Array(oid, desc);
        oids[oids.length] = array;
      }
    }
    return oids;
  }

  function obtieneValoresNivel(){
    var cantElems = combo_get("frmInsertarCartera.cbNivelRiesgo", "L", "");
    var oids = new Array();

    for (var i = 0; i < cantElems; i++)	{
      var oid = combo_get("frmInsertarCartera.cbNivelRiesgo", "V", i);
      var desc = combo_get("frmInsertarCartera.cbNivelRiesgo", "T", i);
      if ( oid != "")		{
        var array = new Array(oid, desc);
        oids[oids.length] = array;
      }
    }
    return oids;
  }

  function obtieneValoresSGV(){
    var cantElems = combo_get("frmInsertarCartera.cbSubgerenciaVentas", "L", "");
    var oids = new Array();

    for (var i = 0; i < cantElems; i++)	{
      var oid = combo_get("frmInsertarCartera.cbSubgerenciaVentas", "V", i);
      var desc = combo_get("frmInsertarCartera.cbSubgerenciaVentas", "T", i);
      if ( oid != "")		{
        var array = new Array(oid, desc);
        oids[oids.length] = array;
      }
    }
    return oids;
  }

  function obtieneValoresRegion(){
    var cantElems = combo_get("frmInsertarCartera.cbRegion", "L", "");
    var oids = new Array();

    for (var i = 0; i < cantElems; i++)	{
      var oid = combo_get("frmInsertarCartera.cbRegion", "V", i);
      var desc = combo_get("frmInsertarCartera.cbRegion", "T", i);
      if ( oid != "")		{
        var array = new Array(oid, desc);
        oids[oids.length] = array;
      }
    }
    return oids;
  }  

  function obtieneValoresZona(){
    var cantElems = combo_get("frmInsertarCartera.cbZona", "L", "");
    var oids = new Array();

    for (var i = 0; i < cantElems; i++)	{
      var oid = combo_get("frmInsertarCartera.cbZona", "V", i);
      var desc = combo_get("frmInsertarCartera.cbZona", "T", i);
      if ( oid != "")		{
        var array = new Array(oid, desc);
        oids[oids.length] = array;
      }
    }
    return oids;
  }  

  function agregaEspacioBlanco(array) {
    var nuevoArray = new Array();
    nuevoArray[0] = ["", ""];

    for (var i = 0; i < array.length; i++) {
      nuevoArray[i+1] = array[i];
    }
    return nuevoArray;
  }

    function onLoadPag()   {       
       configurarMenuSecundario("frmInsertarCartera");                
    
       DrdEnsanchaConMargenDcho('listado1',12);

       document.all["Cplistado1"].style.visibility='';
       document.all["CpLin1listado1"].style.visibility='';
       document.all["CpLin2listado1"].style.visibility='';
       document.all["CpLin3listado1"].style.visibility='';
       document.all["CpLin4listado1"].style.visibility='';

       document.all["primera1Div"].style.visibility='';
       document.all["ret1Div"].style.visibility='';
       document.all["ava1Div"].style.visibility='';
       document.all["separaDiv"].style.visibility='';

		//07/08/06 gPineda BELC300023377
		visibilidadBotones( 'aniadir' );
		moveBy( 'btnAplicarCambiosCAPA', 2, -5 );
		moveBy( 'btnAnadirCAPA', 2, -5 );

       eval (ON_RSZ);  
    
       if((get('frmInsertarCartera.casoDeUso') == 'consultarDetalle') ||(get('frmInsertarCartera.casoDeUso') == 'consultarEliminar') ){
          var marca = get('frmInsertarCartera.marcaDefecto');
          var canal = get('frmInsertarCartera.canalDefecto');   
          var sgv = get('frmInsertarCartera.sgvDefecto');
          var region = get('frmInsertarCartera.regionDefecto');
          var zona = get('frmInsertarCartera.zonaDefecto');  

          set('frmInsertarCartera.cbMarca', new Array(marca));
          set('frmInsertarCartera.cbCanal', new Array(canal));
          set('frmInsertarCartera.cbSubgerenciaVentas', new Array(sgv));
          set('frmInsertarCartera.cbRegion', new Array(region));
          set('frmInsertarCartera.cbZona', new Array(zona)); 
          
          deshabilitarTodo();
          cargaLista();
          deshabilitarHabilitarBoton('botonContenido','btnAnadir','D')
          deshabilitarHabilitarBoton('botonContenido','btnModificar','D')
          deshabilitarHabilitarBoton('botonContenido','btnCopiar','D')                
       }

        if(get('frmInsertarCartera.casoDeUso') == 'consultarModificar'){
           deshabilitarHabilitarBoton('botonContenido','btnCopiar','D')
           cargaLista();

           set('frmInsertarCartera.txtLineaCreditoInicial', '');
           set('frmInsertarCartera.cbNivelRiesgoInicial', '');

           set('frmInsertarCartera.cbCodConfiguracion', '');     

           var marca = get('frmInsertarCartera.marcaDefecto');
           var canal = get('frmInsertarCartera.canalDefecto'); 
           var sgv = get('frmInsertarCartera.sgvDefecto');
           var region = get('frmInsertarCartera.regionDefecto');
           var zona = get('frmInsertarCartera.zonaDefecto');  

           set('frmInsertarCartera.cbMarca', new Array(marca));
           set('frmInsertarCartera.cbCanal', new Array(canal));
           set('frmInsertarCartera.cbSubgerenciaVentas', new Array(sgv));
           set('frmInsertarCartera.cbRegion', new Array(region));
           set('frmInsertarCartera.cbZona', new Array(zona)); 

           comboSGV = obtieneValoresSGV();      
           comboRegion = obtieneValoresRegion();
           comboZona = obtieneValoresZona();      
           comboNivel = obtieneValoresNivel();         
           comboGrupo = obtieneValoresGrupo();

           if(get('frmInsertarCartera.focoSolapa') == 'true') {
              focalizaBotonHTML('botonContenido','btnModificar');
           }
           else {
              focaliza('frmInsertarCartera.cbCodConfiguracion');
           }          
        }

        if(get('frmInsertarCartera.casoDeUso') == 'insertar') {
          var aCombo = new Array(new Array("",""));
          
          set_combo('frmInsertarCartera.cbNivelRiesgo', aCombo, []);
          set_combo('frmInsertarCartera.cbGrupoSolicitud', aCombo, []);
          //set_combo('frmInsertarCartera.cbSubgerenciaVentas',aCombo, []);
          //set_combo('frmInsertarCartera.cbRegion',aCombo, []);
          //set_combo('frmInsertarCartera.cbZona',aCombo, []);             

          set('frmInsertarCartera.txtLineaCreditoInicial', '');
          set('frmInsertarCartera.cbNivelRiesgoInicial', '');

          set('frmInsertarCartera.cbCodConfiguracion', '');     

          var marca = get('frmInsertarCartera.marcaDefecto');
          var canal = get('frmInsertarCartera.canalDefecto'); 
          var sgv = get('frmInsertarCartera.sgvDefecto');
          var region = get('frmInsertarCartera.regionDefecto');
          var zona = get('frmInsertarCartera.zonaDefecto');  

          set('frmInsertarCartera.cbMarca', new Array(marca));
          set('frmInsertarCartera.cbCanal', new Array(canal));
          set('frmInsertarCartera.cbSubgerenciaVentas', new Array(sgv));
          set('frmInsertarCartera.cbRegion', new Array(region));
          set('frmInsertarCartera.cbZona', new Array(zona)); 

          comboSGV = obtieneValoresSGV();      
          comboRegion = obtieneValoresRegion();
          comboZona = obtieneValoresZona();

          if(get('frmInsertarCartera.focoSolapa') == 'true') {
            focalizaBotonHTML('botonContenido','btnModificar');
          }
          else {
            for(var i=0; i<5; i++) {
              focaliza('frmInsertarCartera.cbCodConfiguracion');
            }            
          }          
        }
    }

/*
Agregado por: Cristian Valenzuela
Incidencia bloqueante: V_CAR_01
Fecha: 12/12/2006
Comentario: Al cargar la pantalla modal se recuperaban
4700 registros y se caia la aplicacion, ahora se
carga la lista usando el configurar paginado 
y recuperando solo los primeros 20 registros
*/

function muestraLista(ultima, rowset) {
       var tamanio = rowset.length;
       if (tamanio > 0) {
		   return true;
		 } else {
			return false;
		 }
    } 

/*
Modificado por: Cristian Valenzuela
Incidencia bloqueante: V_CAR_01
Fecha: 12/12/2006
Comentario: Al cargar la pantalla modal se recuperaban
4700 registros y se caia la aplicacion, ahora se
carga la lista usando el configurar paginado 
y recuperando solo los primeros 20 registros
*/

     function cargaLista(){
	    var arr = new Array();

		arr[arr.length] = new Array("oid", get("frmInsertarCartera.oid")+"");
		arr[arr.length] = new Array("oidPais", get("frmInsertarCartera.hPais")+"");
		arr[arr.length] = new Array("oidIdioma", get("frmInsertarCartera.hIdioma")+"");
    
	    configurarPaginado(mipgndo,"CARBuscarAsignacionesCodigoConf","ConectorBuscarAsignacionesCodigoConf",
		"es.indra.sicc.util.DTOOID",arr); 

        /*var asignaciones = get('frmInsertarCartera.hidAsignaciones');
        var arra = asignaciones.split('|');

        for (var i=0;i<arra.length-1 ;i++)  {
            var asign = arra[i].split('@');
            var newRow = new Array();

            oidAsignacion         = asign[0];
            strCodConf            = asign[1];
            strNivelRiesgo        = asign[2];
            strGrupoSolicitud     = asign[3];
            strMarca              = asign[4];
            strCanal              = asign[5];
            strSubgerenciasVentas = asign[6];
            strRegion             = asign[7];
            strZona               = asign[8];
            strLinCreIni          = asign[9];
            strNiveRiesIni        = asign[10];
            oidCodConf            = asign[11];
            oidNieRies            = asign[12];
            oidGrupoSolicitud     = asign[13];
            oidMarca              = asign[14];
            oidCanal              = asign[15];
            oidSGV                = asign[16];
            oidRegion             = asign[17];
            oidZona               = asign[18];
            oidNiveRiesIni        = asign[19];
            
            newRow[newRow.length] = oidAsignacion;
            agregarALlistado(newRow);
        }*/        
    }

     function agregarALlistado(newRow){

            newRow[newRow.length] = "";
            newRow[newRow.length] = strCodConf;
            newRow[newRow.length] = strNivelRiesgo;
            newRow[newRow.length] = strGrupoSolicitud;
            newRow[newRow.length] = strMarca;
            newRow[newRow.length] = strCanal;
            newRow[newRow.length] = strSubgerenciasVentas;
            newRow[newRow.length] = strRegion;
            newRow[newRow.length] = strZona;
            newRow[newRow.length] = strLinCreIni;
            newRow[newRow.length] = strNiveRiesIni;
            newRow[newRow.length] = oidCodConf;
            newRow[newRow.length] = oidNieRies;
            newRow[newRow.length] = oidGrupoSolicitud;
            newRow[newRow.length] = oidMarca;
            newRow[newRow.length] = oidCanal;
            newRow[newRow.length] = oidSGV;
            newRow[newRow.length] = oidRegion;
            newRow[newRow.length] = oidZona;
            newRow[newRow.length] = oidNiveRiesIni;
            
            
            listado1.insertar(newRow);
            listado1.repinta();
    }

    function deshabilitarTodo(){
       
      accion("frmInsertarCartera.cbCodConfiguracion", ".disabled=true");
      accion("frmInsertarCartera.cbNivelRiesgo", ".disabled=true");
      accion("frmInsertarCartera.cbGrupoSolicitud", ".disabled=true");
      accion("frmInsertarCartera.cbMarca", ".disabled=true");
      accion("frmInsertarCartera.cbCanal", ".disabled=true");
      accion("frmInsertarCartera.cbSubgerenciaVentas", ".disabled=true");
      accion("frmInsertarCartera.cbRegion", ".disabled=true");
      accion("frmInsertarCartera.cbZona", ".disabled=true");
      accion("frmInsertarCartera.txtLineaCreditoInicial", ".disabled=true");
      accion("frmInsertarCartera.cbNivelRiesgoInicial", ".disabled=true");
    }
    
    function copiar(){
        if(get('frmInsertarCartera.cbCodConfiguracion') == ''){
           GestionarMensaje("1299");
        }else{
           var codigoConfig       = document.getElementById('cbCodConfiguracion');
           var oidCodigoConfig    = codigoConfig.options[codigoConfig.selectedIndex].value;
                     
           set('frmInsertarCartera.oid', oidCodigoConfig);
           set("frmInsertarCartera.conectorAction", "LPParametrosCAR");
           set("frmInsertarCartera.accion", "copiaCodConf");
           set("frmInsertarCartera.casoDeUso", "copiar");
            
           //eval('frmInsertarCartera').oculto = 'S';
           enviaSICC('frmInsertarCartera', '', '', 'N');
        }
    }

    function fVolver(){
       this.close();
    }

    function fBorrar(){
       if(listado1.numSelecc() < 1){
          GestionarMensaje("4");
       }else{
          listado1.eliminarSelecc();
          
       }

    }

    function aniadir(){

        var codigoConfig       = document.getElementById('cbCodConfiguracion');
        var nivelRiesgo        = document.getElementById('cbNivelRiesgo');
        var grupoSolicitud     = document.getElementById('cbGrupoSolicitud');
        var marca              = document.getElementById('cbMarca');
        var canal              = document.getElementById('cbCanal');
        var subgerencia        = document.getElementById('cbSubgerenciaVentas');
        var region             = document.getElementById('cbRegion');
        var zona               = document.getElementById('cbZona');
        var lineaCredito       = get('frmInsertarCartera.txtLineaCreditoInicial');
        var nivelRiesgoInicial = document.getElementById('cbNivelRiesgoInicial');

        if(validarCamposInsercionLista()){          
            srtCodigoConfig       = codigoConfig.options[codigoConfig.selectedIndex].text;
            oidCodigoConfig       = codigoConfig.options[codigoConfig.selectedIndex].value;  
            strNivelRiesgo        = nivelRiesgo.options[nivelRiesgo.selectedIndex].text;
            oidNivelRiesgo        = nivelRiesgo.options[nivelRiesgo.selectedIndex].value;
            strGrupoSolicitud     = grupoSolicitud.options[grupoSolicitud.selectedIndex].text;
            oidGrupoSolicitud     = grupoSolicitud.options[grupoSolicitud.selectedIndex].value;
            strMarca              = marca.options[marca.selectedIndex].text;
            oidMarca              = marca.options[marca.selectedIndex].value;
            strCanal              = canal.options[canal.selectedIndex].text;
            oidCanal              = canal.options[canal.selectedIndex].value;
            strSubgerencia        = subgerencia.options[subgerencia.selectedIndex].text;
            oidSubgerencia        = subgerencia.options[subgerencia.selectedIndex].value;

   	    strRegion             = '';
      	    oidRegion             = '';
	    strZona               = '';
	    oidZona               = '';


	    if (region.selectedIndex != -1){
     	       strRegion             = region.options[region.selectedIndex].text;
      	       oidRegion             = region.options[region.selectedIndex].value;				
	    }

	    if (zona.selectedIndex != -1){
		strZona               = zona.options[zona.selectedIndex].text;
		oidZona               = zona.options[zona.selectedIndex].value;	
	    }
            
	    strNivelRiesgoInicial = nivelRiesgoInicial.options[nivelRiesgoInicial.selectedIndex].text;
            oidNivelRiesgoInicial = nivelRiesgoInicial.options[nivelRiesgoInicial.selectedIndex].value;
            var oidTemp = get('frmInsertarCartera.hidAsignTemp'); 
            var arr = new Array();

            if(oidTemp == ''){
               arr[arr.length] = listado1.generaCodigo();
            }
            arr[arr.length] = '';
            arr[arr.length] = srtCodigoConfig;
            arr[arr.length] = strNivelRiesgo;
            arr[arr.length] = strGrupoSolicitud
            arr[arr.length] = strMarca;
            arr[arr.length] = strCanal;
            arr[arr.length] = strSubgerencia;
            arr[arr.length] = strRegion;
            arr[arr.length] = strZona;

			// gPïneda 07/08/06 BELC300023377
			// Para que no se les vuelva a agregar los separadores, si los tenía.
			lineaCredito = numeroDeFormatoSICC(lineaCredito);
            arr[arr.length] = numeroAsFormatoSICC(lineaCredito);
            arr[arr.length] = strNivelRiesgoInicial;
            arr[arr.length] = oidCodigoConfig;
            arr[arr.length] = oidNivelRiesgo;
            arr[arr.length] = oidGrupoSolicitud;
            arr[arr.length] = oidMarca;
            arr[arr.length] = oidCanal;
            arr[arr.length] = oidSubgerencia;
            arr[arr.length] = oidRegion;
            arr[arr.length] = oidZona;
            arr[arr.length] = oidNivelRiesgoInicial;

            if(oidTemp == ''){
               listado1.insertar(arr);
               listado1.repinta();
            }else{
                 for (var i=0; i< arr.length; i++) {
                    listado1.insertaDato(oidTemp, i, arr[i])
                 }
                 set('frmInsertarCartera.hidAsignTemp', '');
            }
			//07/08/06 gPineda BELC300023377
			fLimpiar( true );
       }        
              
    }

    function validarLineaCredito(){
        var lineaCreditoValidada = fValidarFloat(get("frmInsertarCartera.txtLineaCreditoInicial"), 10, 2, false, 0, 999999999999999, false);
         
        if(lineaCreditoValidada != 'OK'){
           cdos_mostrarAlert(lineaCreditoValidada);
           focaliza("frmInsertarCartera.txtLineaCreditoInicial");
           return false;
        }else{
           return true; 
        }
    }

    function validarCamposInsercionLista(){

       if(!sicc_validaciones_generales()){
          return false;
       }else{
          return true;
       }
    }

    // Agregado por Sergio Platas - 19/07/2005 - Inc.19834
	// Modificado por Damasia Maneiro -23/08/2005- Solucion de Guardar
	// se agrega el oidCodConf como parametro en la recarga del combo
    function onchange_nivelRiesgo(){
        var oidNRiesgo = get('frmInsertarCartera.cbNivelRiesgo');
		var oidCodConf = get('frmInsertarCartera.cbCodConfiguracion');
		          
        if(oidNRiesgo != ""){
            var arr = new Array();
			arr[arr.length] = new Array("oidCodConf", oidCodConf);
            arr[arr.length] = new Array("nivelRiesgo", oidNRiesgo);
            arr[arr.length] = new Array("oidIdioma", get('frmInsertarCartera.hIdioma'));
                  
            recargaCombo('frmInsertarCartera.cbGrupoSolicitud', 'CARGruposSolicitud', 
                         'es.indra.sicc.dtos.car.DTOFiltroGrupoSolicitud', arr);
        } else {
            set_combo('frmInsertarCartera.cbGrupoSolicitud', [], []);
        }
    }
    
    // Modificado por Sergio Platas - 19/07/2005 - Inc.19834
    function onchange_SelecCodigoConfiguracion(){
	     var oidCodConf = get('frmInsertarCartera.cbCodConfiguracion');
		         
        if(oidCodConf != ""){
            var arr = new Array();
            arr[arr.length] = new Array("oid", oidCodConf);
            arr[arr.length] = new Array("oidIdioma", get('frmInsertarCartera.hIdioma'));
            
            recargaCombo('frmInsertarCartera.cbNivelRiesgo', 'CARNivelesRiesgo', 
                         'es.indra.sicc.util.DTOOID', arr);
            set_combo('frmInsertarCartera.cbGrupoSolicitud', [], []);
            
        } else {
            set_combo('frmInsertarCartera.cbNivelRiesgo', [], []);
            set_combo('frmInsertarCartera.cbGrupoSolicitud', [], []);
        }
    }

    function onchange_canal(){
        vaciarCbSubgerencia();
        if(get('frmInsertarCartera.cbMarca')!=""){
            if(get('frmInsertarCartera.cbCanal')!=""){
                var array = new Array();
                array[array.length] = new Array("oidPais", get('frmInsertarCartera.hPais'));
                array[array.length] = new Array("oidMarca",get('frmInsertarCartera.cbMarca'));
                array[array.length] = new Array("oidCanal",get('frmInsertarCartera.cbCanal'));
                recargaCombo('frmInsertarCartera.cbSubgerenciaVentas', 'ZONRecargaSubgerenciaVentas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', array ); 
            }
        }
      
    }

    function onchange_marca(){
        vaciarCbSubgerencia();
        if(get('frmInsertarCartera.cbMarca')!=""){
            if(get('frmInsertarCartera.cbCanal')!=""){
                var array = new Array();
                array[array.length] = new Array("oidPais", get('frmInsertarCartera.hPais'));
                array[array.length] = new Array("oidMarca",get('frmInsertarCartera.cbMarca'));
                array[array.length] = new Array("oidCanal",get('frmInsertarCartera.cbCanal'));
                recargaCombo('frmInsertarCartera.cbSubgerenciaVentas', 'ZONRecargaSubgerenciaVentas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', array );
            }
        }
    }

    function vaciarCbSubgerencia(){
        var aCombo = new Array(new Array("",""));
        set_combo('frmInsertarCartera.cbSubgerenciaVentas', aCombo, []);
        set_combo('frmInsertarCartera.cbRegion', aCombo, []);
        set_combo('frmInsertarCartera.cbZona', aCombo, []);
    }

    function vaciarCbRegion(){
        var aCombo = new Array(new Array("",""));
        set_combo('frmInsertarCartera.cbRegion', aCombo, []);
        set_combo('frmInsertarCartera.cbZona', aCombo, []);

    }

    function vaciarCbZona(){
        var aCombo = new Array(new Array("",""));
        set_combo('frmInsertarCartera.cbZona', aCombo, []);
    }

    function onchange_subgerenciaVenta(){
        vaciarCbRegion();
        if(get('frmInsertarCartera.cbSubgerenciaVentas') != ''){
           recargaCombo('frmInsertarCartera.cbRegion', 'ZONRecargaRegiones', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', [[ "oidSGV", get('frmInsertarCartera.cbSubgerenciaVentas') ]] );
        }
    }

    function onchange_Region(){
        vaciarCbZona();
        if(get('frmInsertarCartera.cbRegion') != ''){
           recargaCombo('frmInsertarCartera.cbZona', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',[[ "oidRegion", get('frmInsertarCartera.cbRegion') ]] );
        }
    }


    function pasoACodigo(){
          set('frmInsertarCartera.conectorAction','LPParametrosCAR');
          set('frmInsertarCartera.accion','inserta');
          enviaSICC('frmInsertarCartera', '', '', 'N');						  
    }

  function fGuardar(){
    if(listado1.datos.length > 0){ 
        var lista = recolectarDatos();
        eval('frmInsertarCartera').oculto = 'S';
        set('frmInsertarCartera.hDatosLista', lista);
        set('frmInsertarCartera.conectorAction','LPParametrosCAR');
        set('frmInsertarCartera.accion','guardaAsignacion');            
        enviaSICC('frmInsertarCartera', '', '', 'N');
    
    }   else {
        GestionarMensaje('1392',null,null,null); 
        focaliza('frmInsertarCartera.cbCodConfiguracion','');
        return false;            
	}       
  }

    function recolectarDatos(){
       var cantidad = listado1.codigos().length;
       var toAdd = "";
       var codigo = "";
       
       codigo = listado1.codigos();
       for (var i=0; i< cantidad; i++) {
            toAdd = toAdd + "#" + codigo[i];
            toAdd = toAdd + "|" + listado1.extraeDato(codigo[i], 9);
            toAdd = toAdd + "|" + listado1.extraeDato(codigo[i], 11);
            toAdd = toAdd + "|" + listado1.extraeDato(codigo[i], 12);
            toAdd = toAdd + "|" + listado1.extraeDato(codigo[i], 13);            
            toAdd = toAdd + "|" + listado1.extraeDato(codigo[i], 14);
	    toAdd = toAdd + "|" + listado1.extraeDato(codigo[i], 15);
	    toAdd = toAdd + "|" + listado1.extraeDato(codigo[i], 16);

	    if (cdos_trim(listado1.extraeDato(codigo[i], 17)).length == 0) {
	        toAdd = toAdd + "|" + '_'
	    }else{
	        toAdd = toAdd + "|" + listado1.extraeDato(codigo[i], 17);			
	    }

	    if (cdos_trim(listado1.extraeDato(codigo[i], 18)).length == 0) {
	        toAdd = toAdd + "|" + '_'
	    }else{
                toAdd = toAdd + "|" + listado1.extraeDato(codigo[i], 18);	        
	    }
	    
            toAdd = toAdd + "|" + listado1.extraeDato(codigo[i], 19);
        }

        return toAdd;
    }

    function modificar(){
        if(listado1.numSelecc()== 1){
           var iSeleccionado = new Array(); 
           var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
           
           //Seteo el combo de codigo de configuracion
           var oidAsignaciones = listado1.codSeleccionados();
           set('frmInsertarCartera.hidAsignTemp', oidAsignaciones);
           
           // Llama a recargar combos
           reloadCombos(posicion);  

			//07/08/06 gPineda BELC300023377
			visibilidadBotones( 'modificar' );

                 
      }else{
         GestionarMensaje("4");

		//07/08/06 gPineda BELC300023377
		visibilidadBotones( 'aniadir' );
		fLimpiar( true );

      }

    }


    //07/08/06 gPineda BELC300023377
	function visibilidadBotones( modo ){
		if( modo == 'aniadir' ){
			visibilidad('btnAplicarCambiosCAPA',"O");
			visibilidad('btnAnadirCAPA',"V");
		} 
		if( modo == 'modificar' ){
			visibilidad('btnAplicarCambiosCAPA',"V");
			visibilidad('btnAnadirCAPA',"O");
		}
	}


    // - splatas - 02/09/2005 -
    // Recarga combos
    function reloadCombos(posicion){
          asignar([['COMBO', 'frmInsertarCartera.cbCodConfiguracion',
                  'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',
                  formarCadenaDT('CARCodigosConfiguracion', 
                                 'es.indra.sicc.util.DTOBelcorp', 
                                 makeParametersCodConf()),
                  'reloadCodConfig(datos);']]);
    }
    
    // - splatas - 02/09/2005 - 
    // Recarga combo: Cód.Configuracion
    function reloadCodConfig(datos){
        var arr = new Array();
        var oidCodConf = listado1.datos[posicion][12];
        arr[arr.length] = oidCodConf; 
        set('frmInsertarCartera.cbCodConfiguracion', arr);
        
        asignar([['COMBO','frmInsertarCartera.cbNivelRiesgo',
                  'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',
                  formarCadenaDT('CARNivelesRiesgo', 
                                 'es.indra.sicc.util.DTOOID',
                                 makeParametersNRies()),
                  'reloadNivRies(datos);']]);
    }
    
    // - splatas - 02/09/2005 - 
    // Recarga combo: Nivel Riesgo
    function reloadNivRies(datos){
        var  arr = new Array();        
        arr[arr.length] = new Array([''],['']);
        
        for (var i=0 ;i< datos.length ; i++)  {
            arr[arr.length] = datos[i];
        }        
        set_combo('frmInsertarCartera.cbNivelRiesgo', arr);
        
        var iSeleccionado = new Array(); 
        var nivelRiesgo = listado1.datos[posicion][13];        
        iSeleccionado[0] = nivelRiesgo ;
        
        set('frmInsertarCartera.cbNivelRiesgo',iSeleccionado);
        
  
        asignar([['COMBO', 'frmInsertarCartera.cbGrupoSolicitud',
                  'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',
                  formarCadenaDT('CARGruposSolicitud', 
                                 'es.indra.sicc.dtos.car.DTOFiltroGrupoSolicitud',
                                 makeParametersGSolic()), 
                  'reloadGSolic(datos);']]);
    }
    
    // - splatas - 02/09/2005 - 
    // Recarga combo: Grupo Solicitud
    function reloadGSolic(datos){
        var  arr = new Array();
        
        arr[arr.length] = new Array([''],['']);
        for (var i=0 ;i< datos.length ; i++)  {
            arr[arr.length] = datos[i];
        }        

        set_combo('frmInsertarCartera.cbGrupoSolicitud', arr);

        //var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
        var grupSolic = listado1.datos[posicion][14];
        
        var iSeleccionado = new Array();
        iSeleccionado[0] = grupSolic;        
        
        set('frmInsertarCartera.cbGrupoSolicitud', iSeleccionado);
        
        reloadMarca(posicion);          
        
    }
    
    // - splatas - 02/09/2005 -
    // Genera los parámetros del DTOBelcorp para CodConf
    function makeParametersCodConf(){
        var arrParam = new Array();
        arrParam[arrParam.length] = new Array("oidPais", get('frmInsertarCartera.hPais'));
        arrParam[arrParam.length] = new Array("oidIdioma", get('frmInsertarCartera.hIdioma'));
        
        return arrParam;
    }
    
    // - splatas - 02/09/2005 - 
    // Genera los parámetros  del DTOOID para NivRiesgo
    function makeParametersNRies(){
        var arrParam = new Array();
        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
        var oidCodConf = listado1.datos[posicion][12];

        arrParam[arrParam.length] = new Array("oid", oidCodConf);
        arrParam[arrParam.length] = new Array("oidIdioma", get('frmInsertarCartera.hIdioma'));
        
        return arrParam;    
    }   
        
    // - splatas - 02/09/2005 - 
    // Genera los parámetros del DTOFiltroGrupoSolicitud para GrupoSolicitud 
    function makeParametersGSolic(){
        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
        var oidCodConf = listado1.datos[posicion][12];
        var nivelRiesgo = listado1.datos[posicion][13];
        
        var arrParam = new Array();
        arrParam[arrParam.length] = new Array("oidCodConf", oidCodConf);
        arrParam[arrParam.length] = new Array("nivelRiesgo", nivelRiesgo);
        arrParam[arrParam.length] = new Array("oidIdioma", get('frmInsertarCartera.hIdioma'));
        
        return arrParam;
    }

    function reloadMarca(posicion){
        var iSeleccionado = new Array(); 
        var oidMar = listado1.datos[posicion][15];
        var oidCanal = listado1.datos[posicion][16];

        iSeleccionado[0] = oidMar ;
        set('frmInsertarCartera.cbMarca',iSeleccionado);
        iSeleccionado[0] = oidCanal ;
        set('frmInsertarCartera.cbCanal',iSeleccionado);

		asignar([['COMBO','frmInsertarCartera.cbSubgerenciaVentas',
                  'ConectorDruidaTransactionQuery',
                  'dtoSalida.resultado_ROWSET',
                  formarCadenaDT('ZONRecargaSubgerenciaVentas', 
                  'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
                  MakeParametersSG()), 
				  'recargarSubgerencia(datos);']]);	
    }

    function recargarSubgerencia(datos){
        var iSeleccionado = new Array(); 
        var oidSubGer = listado1.datos[posicion][17];
        iSeleccionado[0] = oidSubGer ;

        set('frmInsertarCartera.cbSubgerenciaVentas',iSeleccionado);
        
        asignar([['COMBO','frmInsertarCartera.cbRegion',
                  'ConectorDruidaTransactionQuery',
                  'dtoSalida.resultado_ROWSET',
                  formarCadenaDT('ZONRecargaRegiones', 
                    'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
                    MakeParametersRG()), 
                  'recargarRegion(datos);']]);	
                          
    }

    function recargarRegion(datos){
        var  arr = new Array();
        arr[arr.length] = new Array([''],['']);
        
        for (var i=0 ;i< datos.length ; i++)  {
            arr[arr.length] = datos[i];
        }

        set_combo('frmInsertarCartera.cbRegion',arr);
        
        var iSeleccionado = new Array(); 
        var oidReg = listado1.datos[posicion][18];

        iSeleccionado[0] = oidReg;
        set('frmInsertarCartera.cbRegion', iSeleccionado); 

        asignar([['COMBO','frmInsertarCartera.cbZona',
                  'ConectorDruidaTransactionQuery',
                  'dtoSalida.resultado_ROWSET',
                  formarCadenaDT('ZONRecargaZonas', 
                    'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
                    MakeParametersZN()), 
				  'recargarZona(datos);']]);	
    }

    function recargarZona(datos){
        var  arr = new Array();
        arr[arr.length] = new Array([''],['']);

        for (var i=0 ;i< datos.length ; i++)  {
            arr[arr.length] = datos[i];
        }

        set_combo('frmInsertarCartera.cbZona', arr);
        
        var iSeleccionado = new Array(); 
        var oidZon = listado1.datos[posicion][19];
        iSeleccionado[0] = oidZon;
        
        set('frmInsertarCartera.cbZona', iSeleccionado);
        
        //Seteo la linea de credito inicial
        var linCrediIni      = listado1.datos[posicion][10];
        set('frmInsertarCartera.txtLineaCreditoInicial', linCrediIni);
          
        //Seteo el combo de nivel de riesgo inicial
        var oidNivRiesgoInicial = listado1.datos[posicion][20];
        iSeleccionado[0] = oidNivRiesgoInicial; 
        set('frmInsertarCartera.cbNivelRiesgoInicial', iSeleccionado);
    }

     function MakeParametersSG(){
        var arr = new Array();
        arr[arr.length] = new Array("oidMarca", get('frmInsertarCartera.cbMarca'));
        arr[arr.length] = new Array("oidCanal", get('frmInsertarCartera.cbCanal'));
        return arr;
    }

    function MakeParametersRG(){
        var arr = new Array();
        var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);
        var oidSubGV = listado1.datos[posicion][17];
        
        //arr[arr.length] = new Array("oidSGV", get('frmInsertarCartera.cbSubgerenciaVentas'));
        // PRUEBAS
        arr[arr.length] = new Array("oidSGV", oidSubGV);
        
        return arr;        
    }

    function MakeParametersZN(){
        var arr = new Array();
        
        // splatas - 06/09/2005
        arr[arr.length] = new Array("oidSGV", get('frmInsertarCartera.cbSubgerenciaVentas'));
        arr[arr.length] = new Array("oidRegion", get('frmInsertarCartera.cbRegion'));

        return arr;    
    }

    function obtenerPosicionListaEditable(clave, lista){
          this.posicion = 0;
          if (lista.codSeleccionados().length > 0){
              for(var k=0;k<lista.datos.length;k++) {
                     if (lista.datos[k][0] == clave) {
                        posicion=k;
                        break;
                     }
                            }          
                     return posicion;
                  }
    }

//    function fLimpiar(){
	function fLimpiar( noLimpiaLista ){
       set('frmInsertarCartera.cbCodConfiguracion', '');

       var nuevoSGV = agregaEspacioBlanco(comboSGV);
       var nuevoRegion = agregaEspacioBlanco(comboRegion);
       var nuevoZona = agregaEspacioBlanco(comboZona);      

       set_combo('frmInsertarCartera.cbSubgerenciaVentas',nuevoSGV, []);
       set_combo('frmInsertarCartera.cbRegion',nuevoRegion, []);
       set_combo('frmInsertarCartera.cbZona',nuevoZona, []);       

       var marca = get('frmInsertarCartera.marcaDefecto');
       var canal = get('frmInsertarCartera.canalDefecto'); 
       var sgv = get('frmInsertarCartera.sgvDefecto');
       var region = get('frmInsertarCartera.regionDefecto');
       var zona = get('frmInsertarCartera.zonaDefecto');         

       set('frmInsertarCartera.cbMarca', new Array(marca));
       set('frmInsertarCartera.cbCanal', new Array(canal));
       set('frmInsertarCartera.cbSubgerenciaVentas', new Array(sgv));
       set('frmInsertarCartera.cbRegion', new Array(region));
       set('frmInsertarCartera.cbZona', new Array(zona)); 

       if(get('frmInsertarCartera.casoDeUso') != 'consultarModificar'){
        var aCombo = new Array(new Array("",""));
        set_combo('frmInsertarCartera.cbNivelRiesgo', aCombo, []);
        set_combo('frmInsertarCartera.cbGrupoSolicitud', aCombo, []);       
       }

       if(get('frmInsertarCartera.casoDeUso') == 'consultarModificar'){
        var nuevoNivel = agregaEspacioBlanco(comboNivel);
        set_combo('frmInsertarCartera.cbNivelRiesgo',nuevoNivel, []);  

        var nuevoGrupo = agregaEspacioBlanco(comboGrupo);
        set_combo('frmInsertarCartera.cbGrupoSolicitud',nuevoGrupo, []);        
       }
             
       set('frmInsertarCartera.txtLineaCreditoInicial', '');
       set('frmInsertarCartera.cbNivelRiesgoInicial', '');

		//07/08/06 gPineda BELC300023377
		// Para que se pueda utilizar despues de añadir ó modificar
		if( ! noLimpiaLista ){
			listado1.setDatos(new Array());
			cargaLista();
		}
		visibilidadBotones( 'aniadir' );


       for(var i = 0; i<5; i++) {
        focaliza('frmInsertarCartera.cbCodConfiguracion');
       }       
    }

    function guardoOk(){ 
       eval('frmInsertarCartera').oculto = 'N';
       fLimpiar();
    }

    function noGuardo(){
       eval('frmInsertarCartera').oculto = 'N';
       for(var i = 0; i<5; i++) {
        focaliza('frmInsertarCartera.cbCodConfiguracion');
       }       
    }

    function focoSolapa() {
      pasoACodigo();
    }

    function focoBotonAniadir() {
      focalizaBotonHTML('botonContenido','btnAnadir');
    }

    function focoBotonModificar() {
      focalizaBotonHTML('botonContenido','btnModificar');
    }

    function poneManito(nombre) {          
          var nombre = document.getElementById(nombre);
          nombre.style.cursor = "hand";
    }

    function focoNivelRiesgo() {
      for(var i=0 ; i<5; i++) {
        focaliza('frmInsertarCartera.cbNivelRiesgoInicial');
      }
      
    }
