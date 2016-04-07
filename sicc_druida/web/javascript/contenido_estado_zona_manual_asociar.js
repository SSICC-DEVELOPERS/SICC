    var varNoLimpiarSICC = true;
    
    function fLimpiar(){     

      var aCombo = new Array();         
	  aCombo[0] = get('frmAsociarEstadoZona.hDefMarca');	            
	   
	  set('frmAsociarEstadoZona.comboMarca',aCombo);      

      aCombo = new Array();         
	  aCombo[0] = "";	   
	  
	  set('frmAsociarEstadoZona.comboCanal',aCombo);      

      // Carga regiones
      traeRegiones();
	  
	  set_combo("frmAsociarEstadoZona.comboCodZona", eval('[[""],[""]]'));	
        
      focaliza("frmAsociarEstadoZona.comboMarca");

    }

    function onLoadPag(){
      DrdEnsanchaConMargenDcho('listado1',12);
      eval (ON_RSZ);  
      ocultarLista();
	  
      //accion('frmAsociarEstadoZona.comboEstados',".style.visibility='hidden'");

      configurarMenuSecundario('frmAsociarEstadoZona');

      mostrarCodigoError();

      focaliza("frmAsociarEstadoZona.comboMarca");
      if (get('frmAsociarEstadoZona.hDefMarca') != "") {
        var aCombo = new Array();
        aCombo[0] = get('frmAsociarEstadoZona.hDefMarca');
        set('frmAsociarEstadoZona.comboMarca',aCombo);
        //cargaComboEst();
      }

      set("frmAsociarEstadoZona.seleccionandoItems","SI" );

      if ( get("frmAsociarEstadoZona.marcaSelected") != "" ){
        var vArray = new Array();
        vArray[0] = get("frmAsociarEstadoZona.marcaSelected");
        set("frmAsociarEstadoZona.comboMarca",vArray);
      }
	

      if ( get("frmAsociarEstadoZona.canalSelected") != "" ){
        var vArray = new Array();
        vArray[0] = get("frmAsociarEstadoZona.canalSelected");
        set("frmAsociarEstadoZona.comboCanal",vArray);
      }
	
      if ( get("frmAsociarEstadoZona.regionSelected") != "" ){
        var vArray = new Array();
        vArray[0] = get("frmAsociarEstadoZona.regionSelected");
        set("frmAsociarEstadoZona.comboRegion",vArray);
      }

      if ( get("frmAsociarEstadoZona.codZonaSelected") != "" ){
        var vArray = new Array();
        vArray[0] = get("frmAsociarEstadoZona.codZonaSelected");
        set("frmAsociarEstadoZona.comboCodZona",vArray);
      }

      if (get('frmAsociarEstadoZona.comboMarca') == "")       
          accion('frmAsociarEstadoZona.comboRegion','.disabled=true');
      accion('frmAsociarEstadoZona.comboCodZona','.disabled=true');
      set("frmAsociarEstadoZona.seleccionandoItems","NO" );
      listado1.maxSel = 0;
      if (document.all.tblDatlistado1) {
            document.all.CpScrolllistado1.attachEvent ('onpropertychange', verificaResultado);
      }

	
    }

    function cargaComboEst() {

      var arr = new Array();
      arr[arr.length]=new Array('oidPais', get('frmAsociarEstadoZona.hPais'));
      arr[arr.length]=new Array('oidIdioma', get('frmAsociarEstadoZona.hIdioma'));
      arr[arr.length]=new Array('oidMarca', get('frmAsociarEstadoZona.comboMarca'));

      asignar([['COMBO', 'frmAsociarEstadoZona.comboEstados', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET',
              formarCadenaDT('ZONBuscarEstadosZona', 'es.indra.sicc.dtos.zon.DTOBuscaZonaEstIni', arr)]]);

    }

    //Para mostrar u ocultar la capa dependiendo si hay o no resultados
    function verificaResultado() {

      if (event.propertyName == "innerHTML") {		
          //alert(listado1.datos.length);
          if (listado1.datos.length > 0) {		
                	//btnProxy(1, '1');
                  //alert("estoy en prueba loca2 "+event.srcElement.outerHTML);
                  //En esta posicion se guardan los datos del combo
                  listado1.tiposCol[4][2] = obtenerContCombo();
                  /*for (i=0; i < listado1.tiposCol.length; i++) {
                      if (listado1.tiposCol[i][0] == "COMBO") {  //Busco el tipo de objeto COMBO
                          if (listado1.tiposCol[i][1] == "estado") {  //Busco el nombre del combo estado
                              listado1.tiposCol[i][2] = obtenerContCombo();                     
                          }
                      }
                  }*/

                  /* SOLUCION 2 pero lenta
                  for (i=0; i < listado1.datos.length; i++) {
                      llenarComboEsta('estado_'+i,listado1.datos[i][5]);
                  }*/
                  mostrarLista();
                  //Provisorio hasta que se implemente el tab en el combo de la lista editable
                  //var cmb = "estado_"+(listado1.datos.length-1);
                  //document.all[cmb].attachEvent('onkeydown', focalizaDesdeCbLista);

          } else {
              if (document.all["Cplistado1"].style.visibility == '') {
                	//btnProxy(1, '0');
                  ocultarLista();
              }
          }
      }
    }

   /* function llenarComboEsta(cmb, valor) {
        var longitud = combo_get( 'frmAsociarEstadoZona.comboEstados', 'L' );
        var combo = document.all[cmb];
        combo.length = longitud;
        for (j = 0; j < longitud; j++) {
            combo[j].value = combo_get( 'frmAsociarEstadoZona.comboEstados', 'V', j );
            combo[j].innerText = combo_get( 'frmAsociarEstadoZona.comboEstados', 'T', j );
        }
        combo.value = valor;
    }*/

    function obtenerContCombo( ){
      var cmb = 'frmAsociarEstadoZona.comboEstados';
      var longitud = combo_get( cmb, 'L' );
      var strArray = new Array(longitud);
      var i;

      for( i = 0; i < longitud; i++ ){
        var aFila = new Array(2);
        aFila[0] = combo_get( cmb, 'V', i );
        aFila[1] = combo_get( cmb, 'T', i );

        strArray[i] = aFila;
      }
	
      return strArray;
    }


    function fBuscarZonas(){

      //******* Validaciones *******
      if ( get("frmAsociarEstadoZona.comboMarca") == ""){
        GestionarMensaje('1525');
        focaliza("frmAsociarEstadoZona.comboMarca");
        return;
      }
      //******* Validaciones *******

      cargaComboEst();

      var arr = new Array();
      arr[arr.length]=new Array('oidMarca', get('frmAsociarEstadoZona.comboMarca'));
      arr[arr.length]=new Array('oidCanal', get('frmAsociarEstadoZona.comboCanal'));
      arr[arr.length]=new Array('oidRegion', get('frmAsociarEstadoZona.comboRegion'));
      arr[arr.length]=new Array('oidZona', get('frmAsociarEstadoZona.comboCodZona'));
      arr[arr.length]=new Array('oidIdioma', get('frmAsociarEstadoZona.hIdioma'));
      arr[arr.length]=new Array('oidPais', get('frmAsociarEstadoZona.hPais'));
      arr[arr.length]=new Array('indicadorSituacion', '1');
      arr[arr.length]=new Array('tamanioPagina', '10');

      set("frmAsociarEstadoZona.accion", "BUSCAR");
    //	enviaSICC("frmAsociarEstadoZona");
      configurarPaginado(mipgndo,"ZONBuscarZonaEstINI","ConectorBuscarZonasEstIni","es.indra.sicc.dtos.zon.DTOBuscaZonaEstIni", arr);

     //dmaneiro - 22/11/2005- Inc. 21810
	  listado1.tiposCol[4][2] = obtenerContCombo();
	
    }


    function fActualizar(){
      //******* Validaciones *******
 
      if ( get("frmAsociarEstadoZona.comboMarca") == ""){
        cdos_mostrarAlert("Debe seleccionar una marca");
        return;
      }
 
      if ( Lista1.seleccion.longitud <= 0 ){
        cdos_mostrarAlert("Debe seleccionar una zona");
        return;
      }

      if ( get("frmAsociarEstadoZona.comboEstado") == ""){
        cdos_mostrarAlert("Debe seleccionar un Estado");
        return;
      }

      //******* Validaciones *******
      //alert( Lista1.getSeleccion() );
	
      set("frmAsociarEstadoZona.accion", "ASIGNAR");
      set("frmAsociarEstadoZona.nuevoestadozona", Lista1.getSeleccion() ); 
      enviaSICC("frmAsociarEstadoZona");
    }

    function traeRegiones(){

      //Para cuando se carga la pagina
      if ( get("frmAsociarEstadoZona.seleccionandoItems") == "SI" ){
        return;
      }

      if ( get("frmAsociarEstadoZona.comboMarca") == "" && get("frmAsociarEstadoZona.comboCanal") == ""){
        var aCombo = new Array(new Array("",""));
        set_combo('frmAsociarEstadoZona.comboRegion',aCombo, []);
        set_combo('frmAsociarEstadoZona.comboCodZona',aCombo, []);
        accion('frmAsociarEstadoZona.comboRegion','.disabled=true');
        accion('frmAsociarEstadoZona.comboCodZona','.disabled=true');
      }
      else{
        /*
        Parametros :
        primero -> ConectorConsultaUA		 
        segundo -> BusinessID?Marca?Canal
        */
        accion('frmAsociarEstadoZona.comboRegion','.disabled=false');
        var aCombo = new Array(new Array("",""));
        set_combo('frmAsociarEstadoZona.comboCodZona',aCombo, []);
        accion('frmAsociarEstadoZona.comboCodZona','.disabled=true');

        var vMarca = get("frmAsociarEstadoZona.comboMarca") ;
        var vCanal = get("frmAsociarEstadoZona.comboCanal") ;

        var strParametros = "ConectorConsultaUA|MLNFObtenerRegionesNoBorradas?" + vMarca + "?" + vCanal;

        //alert( strParametros )
        asignar([['COMBO','frmAsociarEstadoZona.comboRegion','ConectorDTZON','dtoSalida.resultado_ROWSET',strParametros]],'','');

      }

    }


    function traeZonas(){
      //Para cuando se carga la pagina
      if ( get("frmAsociarEstadoZona.seleccionandoItems") == "SI" ){
        return;
      }

      if ( get("frmAsociarEstadoZona.comboRegion") != "" ){
        var vMarca = get("frmAsociarEstadoZona.comboMarca") ;
        var vCanal = get("frmAsociarEstadoZona.comboCanal") ;
		var vRegion = get("frmAsociarEstadoZona.comboRegion");

        accion('frmAsociarEstadoZona.comboCodZona','.disabled=false');
        var strParametros = "ConectorConsultaUA|MLNFObtenerZonasNoBorradas?" + vMarca + "?" + vCanal + "?" + vRegion;
        //alert( strParametros )
        asignar([['COMBO','frmAsociarEstadoZona.comboCodZona','ConectorDTZON','dtoSalida.resultado_ROWSET',strParametros]],'','');
			
      }
      else{
        //set_combo("frmAsociarEstadoZona.comboCodZona",new Array()  );
        var aCombo = new Array(new Array("",""));
        set_combo('frmAsociarEstadoZona.comboCodZona',aCombo, []);
        accion('frmAsociarEstadoZona.comboCodZona','.disabled=true');
      }
    }


    function mostrarCodigoError() {  

      var vErrCodigo = get('frmAsociarEstadoZona.errCodigo');
      var vErrDescrip = get('frmAsociarEstadoZona.errDescripcion');

      if (get('frmAsociarEstadoZona.errDescripcion')!=''){
        var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);
      }

    } 


    

    function ocultarLista() {
        document.all["Cplistado1"].style.visibility='hidden';
        document.all["CpLin1listado1"].style.visibility='hidden';
        document.all["CpLin2listado1"].style.visibility='hidden';
        document.all["CpLin3listado1"].style.visibility='hidden';
        document.all["CpLin4listado1"].style.visibility='hidden';
        document.all["primera1Div"].style.visibility='hidden';
        document.all["ret1Div"].style.visibility='hidden';
        document.all["ava1Div"].style.visibility='hidden';
        document.all["separaDiv"].style.visibility='hidden';
    }

    function mostrarLista() {

        document.all["Cplistado1"].style.visibility='';
        document.all["CpLin1listado1"].style.visibility='';
        document.all["CpLin2listado1"].style.visibility='';
        document.all["CpLin3listado1"].style.visibility='';
        document.all["CpLin4listado1"].style.visibility='';
        document.all["primera1Div"].style.visibility='';
        document.all["ret1Div"].style.visibility='';
        document.all["ava1Div"].style.visibility='';
        document.all["separaDiv"].style.visibility='';

        //eval (ON_RSZ);  
    }

/*-----------------------------------------------------------------------------------------*/

function ocultaCapas(){
        document.all["Cplistado1"].style.visibility='hidden';
        document.all["CpLin1listado1"].style.visibility='hidden';
        document.all["CpLin2listado1"].style.visibility='hidden';
        document.all["CpLin3listado1"].style.visibility='hidden';
        document.all["CpLin4listado1"].style.visibility='hidden';
        document.all["primera1Div"].style.visibility='hidden';
        document.all["ret1Div"].style.visibility='hidden';
        document.all["ava1Div"].style.visibility='hidden';
        document.all["separaDiv"].style.visibility='hidden';

}


function muestraCapas(){
        document.all["Cplistado1"].style.visibility='';
        document.all["CpLin1listado1"].style.visibility='';
        document.all["CpLin2listado1"].style.visibility='';
        document.all["CpLin3listado1"].style.visibility='';
        document.all["CpLin4listado1"].style.visibility='';
        document.all["primera1Div"].style.visibility='';
        document.all["ret1Div"].style.visibility='';
        document.all["ava1Div"].style.visibility='';
        document.all["separaDiv"].style.visibility='';

}



          function muestraLista( ultima, rowset, error){
                    var tamano = rowset.length;

                                      if (tamano > 0) {

                        
                              muestraCapas();
                              eval (ON_RSZ);

                                  focaliza("frmAsociarEstadoZona.comboMarca"); 
                              return true;
                    } else {
                      ocultaCapas();
                      eval (ON_RSZ);                  
                                             focaliza("frmAsociarEstadoZona.comboMarca"); 
                      cdos_mostrarAlert(error);
                      return false;
                     }
          }




/*-----------------------------------------------------------------------------------------*/


    function fGuardar() {
        if (listado1.datos.length == 0)
            return;
        var sDatos = "";
        for (i = 0; i < listado1.datos.length; i++) {
            sDatos = sDatos + listado1.datos[i][0];
            sDatos = sDatos + ",";
            sDatos = sDatos + listado1.datos[i][5];
            sDatos = sDatos + "|";
        }
        set('frmAsociarEstadoZona.hDatosGrabar',sDatos);
        set("frmAsociarEstadoZona.accion", "ASIGNAR");
        enviaSICC('frmAsociarEstadoZona');
    }

    function actuaComboListado() {
      var nombreCb = event.srcElement.name;
      var pos = nombreCb.indexOf("_");
      var fila = nombreCb.substr(pos+1, nombreCb.length);
      
/*      var pagActual = mipgndo.pagina;
      var dato = mipgndo.indices.substring(0,mipgndo.indices.lastIndexOf(mipgndo.separador));
      var posUltAnt = dato.lastIndexOf("#");
      var ultimoAnt = "";
      if (posUltAnt > -1) {
        ultimoAnt = dato.substring(0, posUltAnt);
        var pos2 = ultimoAnt.lastIndexOf("#");
        ultimoAnt = ultimoAnt.substring(pos2+1, posUltAnt);
      }
      alert("ultimoAnt: "+ultimoAnt);
      alert(listado1.datos);
      var posLista = DrIndiceEnArray(listado1.datos,ultimoAnt,0);
      alert("Pos Lista: "+posLista);*/

      listado1.datos[parseInt(fila,10)][5] = event.srcElement.value;

    }


    function canalOnChange () {  

      if (get('frmVinculo.cbCanal')!='') {
          var arr = new Array();
          arr[arr.length]=new Array('oid', get('frmVinculo.cbCanal'));
          arr[arr.length]=new Array('oidIdioma', get('frmVinculo.hIdioma'));

          recargaCombo('frmVinculo.cbAcceso', 'SEGObtenerAccesosSinFiltro', 'es.indra.sicc.util.DTOOID', arr);
          accion('frmVinculo.cbAcceso','.disabled=false');
 
          var  aComboS = new Array();
          aComboS[0] = "";
          set('frmVinculo.cbSubacceso',aComboS);
          accion('frmVinculo.cbSubacceso','.disabled=true');

          
      } else {
          accion('frmVinculo.cbAcceso','.disabled=true');
          accion('frmVinculo.cbSubacceso','.disabled=true');
          var aCombo = new Array();
          aCombo[0] = "";
          set('frmVinculo.cbAcceso',aCombo);
          set('frmVinculo.cbSubacceso',aCombo);
      }
      
    }

    function focalizaDesdeBoton() {
        if (document.all["Cplistado1"].style.visibility == 'hidden')
            focaliza('frmAsociarEstadoZona.comboMarca');
        else {
            document.all["estado_0"].focus();
            listado1.preparaCamposDR();            
            focaliza('frmlistado1.estado_0','');
        }
    }

    function focalizaListaTab(FILAEVENTO) {
		//alert('Evento ontab desde la fila '+FILAEVENTO);
		//alert('lista: ' + listado1.datos.length);
		if(FILAEVENTO == (listado1.datos.length - 1)){
			setTimeout("focaliza('frmAsociarEstadoZona.comboMarca','')",10); 
		}       
    }

	function focalizaListaShTab(FILAEVENTO) {
		
		if(FILAEVENTO == 0){
			setTimeout("focalizaBotonHTML('botonContenido','BuscarZonas')",10); 			
		}       
    }


	function focalizaBotonShtab() {
       if (document.all["Cplistado1"].style.visibility == 'hidden')
            focalizaBotonHTML('botonContenido','BuscarZonas');
        else {               
			linea= listado1.datos.length - 1;
			listado1.preparaCamposDR();            
            focaliza('frmlistado1.estado_' + linea,'');           
        }       
    }


    
