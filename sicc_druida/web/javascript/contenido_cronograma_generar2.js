/*
    INDRA/CAR/PROY
    $Id: contenido_cronograma_generar2.js,v 1.1 2009/12/03 19:01:44 pecbazalar Exp $
    DESC
*/

function mostrarCodigoError(){
	var vErrCodigo = get('frmGenerarCronograma2.errCodigo');
	var vErrDescrip = get('frmGenerarCronograma2.errDescripcion');

	if (get('frmGenerarCronograma2.errDescripcion')!=''){
		var wnd = fMostrarMensajeError( vErrCodigo,vErrDescrip);
		if (wnd == 1){
			return -1;
		}	
	}
	return 0;
} 

function cambiarFecha() {
    var celda;
    var zona;
    var activ;
    var pos;

    alert("Cambiar fecha");
    //alert(event.srcElement.name);
    celda = event.srcElement.name;
    pos = celda.indexOf("_");
    celda = celda.substring(pos+1,celda.length);
    pos = celda.indexOf("_");
    zona = celda.substring(1,pos);
    activ = celda.substring(pos+2,celda.length);

    set('frmGenerarCronograma2.hZonaSelec',zona);
    set('frmGenerarCronograma2.hActivSelec',activ);
    set('frmGenerarCronograma2.accion','nuevaFecha');
    //set('frmCabDigitar.hidDescCondiPago',cbCondiPago[cbCondiPago.selectedIndex].innerText);
    //set('frmCabDigitar.hidDescDocumento',cbDocumento[cbDocumento.selectedIndex].innerText);
    enviarFormulario();

}

function cambiarFechaLink(zona, activ, fecha, hora) {
    var celda;
    var pos;
    var sAnio;
    var sMes;
    var sDia;

    //alert("Cambiar fecha Link");

    set('frmGenerarCronograma2.hZonaSelec',zona);
    set('frmGenerarCronograma2.hActivSelec',activ);
    set('frmGenerarCronograma2.hFechaVieja',fecha);
    set('frmGenerarCronograma2.hHoraVieja',hora);
    set('frmGenerarCronograma2.hCodigoPeriodo',get('frmGenerarCronograma2.hCodigoPeriodo'));
    set('frmGenerarCronograma2.accion','nuevaFecha');
    enviarFormulario();

}

function posicionarCombo() {
	try{
/*		var iSeleccionadoP = new Array();
		iSeleccionadoP[0] = get('frmGenerarCronograma2.hPais');
		set('frmGenerarCronograma2.cbPaises',iSeleccionadoP);*/
	
		var iSeleccionadoM = new Array();
		iSeleccionadoM[0] = get('frmGenerarCronograma2.hMarca');
		set('frmGenerarCronograma2.cbMarcas',iSeleccionadoM);
	
		var iSeleccionado = new Array();
		iSeleccionado[0] = get('frmGenerarCronograma2.hCanal');
		set('frmGenerarCronograma2.cbCanales',iSeleccionado);
	
		var iSeleccionadoPER = new Array();
		iSeleccionadoPER[0] = get('frmGenerarCronograma2.hCodigoPeriodo');
		set('frmGenerarCronograma2.cbCodigosDelPeriodo',iSeleccionadoPER);
	}
	catch(e){
	}
}

function disableGenerar(){
	try {
		document.all.tags("INPUT")("btnGenerar").disabled = true;
	} catch(e){}
}

function enableGenerar(){
	try {
		document.all.tags("INPUT")("btnGenerar").disabled = false;
	} catch(e){}
}

function enableGuardar(){
	try {
		document.all.tags("INPUT")("btnGuardar").disabled = false;
	} catch(e){}
}

function cambio() {
	var todo = get('frmGenerarCronograma.cbPaises') != '' &&
	get('frmGenerarCronograma.cbMarcas') != '' &&
	get('frmGenerarCronograma.cbCanales') != '';
	if (todo)
		enableGenerar();
	else
		disableGenerar();
}


function inicializacion(){
  var res;

	configurarMenuSecundario("frmGenerarCronograma2");
	posicionarCombo();
	mostrarCodigoError();
	set('frmGenerarCronograma2.hlblActiFija',GestionarMensaje('1002'));
	set('frmGenerarCronograma2.hlblActiRefe',GestionarMensaje('1003'));

	if (	get('frmGenerarCronograma2.hPais') != "" && 
			get('frmGenerarCronograma2.hMarca') != "" &&
			get('frmGenerarCronograma2.hCanal') != "" 
		){
			accion('frmGenerarCronograma2.cbCodigosDelPeriodo','.disabled= false');
			try{
			document.all.tags("INPUT")("btnBuscar").disabled = false;
			}
			catch(e){}		
      if (get('frmGenerarCronograma2.hExisteCrono') == "S" ) {
          //res = cdos_mostrarConfirm("Ya existe un cronograma para los datos seleccionados. ¿Desea eliminarlo y generar uno nuevo?");
          res = GestionarMensaje('1004');
          if (res) {
            	set('frmGenerarCronograma2.hExisteCrono', 'S');
              cargarRejilla();
              return;
          }
          else
              obtenerPaisMarcaCanal();
      } else {
          if (get('frmGenerarCronograma2.hExisteCrono') == "N" ) {
              cargarRejilla();
              return;
          }
      }
      
	}
	else{
			accion('frmGenerarCronograma2.cbCodigosDelPeriodo','.disabled=true');
			try{
			document.all.tags("INPUT")("btnBuscar").disabled = true;
			}
			catch(e){
			}		
	}
	
	//cdosFC('frmGenerarCronograma2.cbPaises');
	cdosFC('frmGenerarCronograma2.cbMarcas');
	
}

function obtenerPaisMarcaCanal(){
	//set('frmGenerarCronograma2.hPais', get('frmGenerarCronograma2.cbPaises'));
	set('frmGenerarCronograma2.hPais', get('frmGenerarCronograma2.hPais'));
	set('frmGenerarCronograma2.hCanal', get('frmGenerarCronograma2.cbCanales'));
	set('frmGenerarCronograma2.hMarca', get('frmGenerarCronograma2.cbMarcas'));
	//set('frmGenerarCronograma2.descPais', get('frmGenerarCronograma2.cbPaises', 'T'));
	set('frmGenerarCronograma2.descPais', get('frmGenerarCronograma2.descPais'));
	set('frmGenerarCronograma2.descCanal', get('frmGenerarCronograma2.cbCanales', 'T'));
	set('frmGenerarCronograma2.descMarca', get('frmGenerarCronograma2.cbMarcas', 'T'));
}

function enviarFormulario() {
	obtenerPaisMarcaCanal();
	//set('frmGenerarCronograma2.hCodigosDelPeriodo', get('frmGenerarCronograma2.cbCodigosDelPeriodo'));
	deshabilitarControles();
	enviaSICC('frmGenerarCronograma2');
}

function deshabilitarControles(){
	//accion('frmGenerarCronograma2.cbPaises','.disabled= true');
	accion('frmGenerarCronograma2.cbCanales','.disabled= true');
	accion('frmGenerarCronograma2.cbMarcas','.disabled= true');
	accion('frmGenerarCronograma2.cbCodigosDelPeriodo','.disabled= true');
	try{
		document.all.tags("INPUT")("btnBuscar").disabled = true;
	}
	catch(e){}
}

 



function comprobarPaisMarcaCanal(){
	if (	get('frmGenerarCronograma2.hPais')	!= "" && 
			get('frmGenerarCronograma2.cbMarcas')	!= "" && 
			get('frmGenerarCronograma2.cbCanales') != ""   
		)	{
		
		set('frmGenerarCronograma2.accion', 'seleccionPaisMarcaCanal');
		set('frmGenerarCronograma2.conectorAction', 'LPGenerarCronogramaFase2');

		enviarFormulario();
		return;
	}
	
	if (	get('frmGenerarCronograma2.lblPaisDato')	== "" || 
			get('frmGenerarCronograma2.cbMarcas')	== "" || 
			get('frmGenerarCronograma2.cbCanales') == ""   
		)	{
		set('frmGenerarCronograma2.cbCodigosDelPeriodo',new Array());
		set_combo('frmGenerarCronograma2.cbCodigosDelPeriodo',new Array());			
		accion("frmGenerarCronograma2.cbCodigosDelPeriodo",".disabled=true");
		try{
			document.all.tags("INPUT")("btnBuscar").disabled = true;
		}
		catch(e){
		}						
	}	
}

function onLoadCargarBarra() {
	cargarBarra("barra_cronograma_generar2");
}



 
function fnTAB_al_principio(pControl){
	if ( pControl == "cbCanales" ){
		try{
			focaliza('frmGenerarCronograma2.cbCodigosDelPeriodo');
		}
		catch(e){
			try{
				//focaliza('frmGenerarCronograma2.cbPaises');
				focaliza('frmGenerarCronograma2.cbMarcas');
			}
			catch(e1){
			}
		}
	}
	else{
			try{
				//focaliza('frmGenerarCronograma2.cbPaises');
				focaliza('frmGenerarCronograma2.cbMarcas');
			}
			catch(e2){
			}
	}
}

function fLimpiar() {
    //Porque si hacemos solo limpiar queda el icono guardar habilitado
    if (get('frmGenerarCronograma2.hTablaVisible') == 'S') {
        set('frmGenerarCronograma2.accion', '');
        set('frmGenerarCronograma2.conectorAction', 'LPGenerarCronogramaFase2');
        enviaSICC('frmGenerarCronograma2');
        return;
    } 
    else
      limpiarFormulario();
}

// Va a permitir limpiar las selecciones y el text field
function limpiarFormulario() {
	try{
		/*var iSeleccionadoP = new Array();
		set('frmGenerarCronograma2.cbPaises',iSeleccionadoP);*/
	
		var iSeleccionadoM = new Array();
		set('frmGenerarCronograma2.cbMarcas',iSeleccionadoM);
	
		var iSeleccionado = new Array();
		set('frmGenerarCronograma2.cbCanales',iSeleccionado);
	
		var iSeleccionadoPER = new Array();
		set('frmGenerarCronograma2.cbCodigosDelPeriodo',iSeleccionadoPER);
		
		//focaliza('frmGenerarCronograma2.cbPaises');
		focaliza('frmGenerarCronograma2.cbMarcas');
		
		
		//set('frmGenerarCronograma2.hPais','');
		set('frmGenerarCronograma2.hMarca','');
		set('frmGenerarCronograma2.hCanal','');
		accion('frmGenerarCronograma2.cbCodigosDelPeriodo','.disabled=true');
		
		document.all.tags("INPUT")("btnBuscar").disabled = true;
		visibilidad('miscroll', 'O');	
	}
	catch(e){}
	
			
}

function existeCronograma() {
/** PARA PROBAR ***************************************************************************************************/
	if ( get('frmGenerarCronograma2.cbCodigosDelPeriodo')[0] == "" ){
      //cdos_mostrarAlert("Debe seleccionar un Período.");
  		GestionarMensaje('416','frmGenerarCronograma2.cbCodigosDelPeriodo');
      return;
	}

	obtenerPaisMarcaCanal();
	
	set('frmGenerarCronograma2.hCodigosDelPeriodo', get('frmGenerarCronograma2.cbCodigosDelPeriodo'));
	set('frmGenerarCronograma2.accion', 'existeCronograma');
	set('frmGenerarCronograma2.conectorAction', 'LPGenerarCronogramaFase2');
	
	
	deshabilitarControles()
	enviaSICC('frmGenerarCronograma2');
}


function fGuardar() {

	obtenerPaisMarcaCanal();
	
	set('frmGenerarCronograma2.hCodigosDelPeriodo', get('frmGenerarCronograma2.cbCodigosDelPeriodo'));
	set('frmGenerarCronograma2.accion', 'guardarCronograma');
	set('frmGenerarCronograma2.conectorAction', 'LPGenerarCronogramaFase2');
	
	
	deshabilitarControles();
	enviaSICC('frmGenerarCronograma2');
}


function cargarRejilla(){
  var i;

  /* PARA PROBAR *************************************************************************************** 	
	if ( get('frmGenerarCronograma2.cbCodigosDelPeriodo')[0] == "" ){
		cdos_mostrarAlert("Debe seleccionar un Período.");
		return;
	}*/
  
  //Agregado para probar
	/*var iSeleccionadoPER = new Array("354","354");
	set('frmGenerarCronograma2.cbCodigosDelPeriodo',iSeleccionadoPER);*/
	
	obtenerPaisMarcaCanal();

//  alert(i);
//  alert(document.frmGenerarCronograma2.cbCodigosDelPeriodo.value);
  
	set('frmGenerarCronograma2.hCodigosDelPeriodo', get('frmGenerarCronograma2.cbCodigosDelPeriodo'));
	set('frmGenerarCronograma2.accion', 'completarRejilla');
	set('frmGenerarCronograma2.conectorAction', 'LPGenerarCronogramaFase2');
	
	
	deshabilitarControles()
	enviaSICC('frmGenerarCronograma2');
}

function cdosFC(componente) {
	if (componente == null || componente == '') return;
	try{
		setTimeout('focaliza(\'' + componente + '\', \'\')', 100);
	}
	catch(e){
	}
	
}
