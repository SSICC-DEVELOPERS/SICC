// Para eliminar todo el cronograma
function fBorrar(){
	if(GestionarMensaje('5')){
		set('frmEliminarCronograma.accion', 'eliminarCronograma');
		set('frmEliminarCronograma.conectorAction', 'LPEliminarCronograma');
		enviarFormulario();
	}
}

function inicializacion(){

  configurarMenuSecundario("frmEliminarCronograma");
  eval (ON_RSZ); 
			
	if (get('frmEliminarCronograma.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get('frmEliminarCronograma.errCodigo'), get('frmEliminarCronograma.errDescripcion'));
	}

	if(get('frmEliminarCronograma.hCronoVacio') == 'vacio' && get('frmEliminarCronograma.hOrigenCargaRejilla') == 'buscar'){
		//muestro el mensaje de "NO HAY DATOS"
	 	GestionarMensaje('160','frmEliminarCronograma.txtDescripcion');
	}

	if (get('frmEliminarCronograma.hFlag') == 'OK') {
		accion('frmEliminarCronograma.cbGruposDeZonas','.disabled=true');
	}

	if (get('frmEliminarCronograma.hGP') == 'GP') {
		accion('frmEliminarCronograma.cbSubgerenciasDeVentas','.disabled=true');
		accion('frmEliminarCronograma.cbRegiones','.disabled=true');
	}

	if( get('frmEliminarCronograma.hCapaVisible')=='v' ){
		moveTo('capaRejilla', 0, 530);
		visibilidad('capaRejilla','V');
	}
	else{
		moveTo('capaRejilla', 0, 0);
	}

	//VERIFICAR QUE LOS COMBOS NO TENGAN VALORES EN BLANCO
	LimpiarCombo( 'frmEliminarCronograma.cbMarcas' );
	//LimpiarCombo( 'frmEliminarCronograma.cbCanales' );
	LimpiarCombo( 'frmEliminarCronograma.cbCodigosDelPeriodo' );
	//LimpiarCombo( 'frmEliminarCronograma.cbGruposDeZonas' );
	//LimpiarCombo( 'frmEliminarCronograma.cbSubgerenciasDeVentas' );
	LimpiarCombo( 'frmEliminarCronograma.cbRegiones' );
	LimpiarCombo( 'frmEliminarCronograma.cbZonas' );
	
	//combo_add('frmEliminarCronograma.cbCanales', '', '')	;
	//agregarVacio('frmEliminarCronograma.cbCanales');

	focaliza('frmEliminarCronograma.cbMarcas','');
  
	accion('frmEliminarCronograma.chkTodahMarcas','.disabled=true');
	accion('frmEliminarCronograma.chkTodosGruposDeZonas','.disabled=true');
	accion('frmEliminarCronograma.chkTodasSecciones','.disabled=true');
}

/*function Limpiar(){
	setTimeout("Limpiar2()", 100);
}*/


// Agregado para limpiar las celdas del formulario *** que faltan campos
function fLimpiar() {
    //Porque si hacemos solo limpiar queda el icono guardar habilitado
    if (get('frmEliminarCronograma.hCapaVisible') == 'S') {
        set('frmEliminarCronograma.accion', '');
        set('frmEliminarCronograma.conectorAction', 'LPEliminarCronograma');
        enviaSICC('frmEliminarCronograma');
        return;
    } 
    else
      limpiarFormulario();
}


function limpiarFormulario() {
	try{
		/*var iSeleccionadoP = new Array();
		set('frmGenerarCronograma2.cbPaises',iSeleccionadoP);*/
	
		var iSeleccionadoM = new Array();
		set('frmEliminarCronograma.cbMarcas',iSeleccionadoM);
	
		var iSeleccionado = new Array();
		set('frmEliminarCronograma.cbCanales',iSeleccionado);
	
		var iSeleccionadoPER = new Array();
		set('frmEliminarCronograma.cbCodigosDelPeriodo',iSeleccionadoPER);

		var iSeleccionadoPER = new Array();
		set('frmEliminarCronograma.cbGruposDeZonas',iSeleccionadoPER);

		var iSeleccionadoPER = new Array();
		set('frmEliminarCronograma.cbSubgerenciasDeVentas',iSeleccionadoPER);

		var iSeleccionadoPER = new Array();
		set('frmEliminarCronograma.cbRegiones',iSeleccionadoPER);

		var iSeleccionadoPER = new Array();
		set('frmEliminarCronograma.cbZonas',iSeleccionadoPER);

		

		//Falta los focaliza
		//focaliza('frmGenerarCronograma2.cbPaises');
		focaliza('frmEliminarCronograma.cbMarcas');	
		
		//set('frmGenerarCronograma2.hPais','');
		set('frmEliminarCronograma.hMarca','');
		set('frmEliminarCronograma.hCanal','');
		accion('frmEliminarCronograma.cbCodigosDelPeriodo','.disabled=true');
		
		document.all.tags("INPUT")("btnBuscar").disabled = true;
		visibilidad('miscroll', 'O');	
	}
	catch(e){}
	
			
}


function Limpiar2()  {
//set('frmEliminarCronograma.cbPaises', '');
	set('frmEliminarCronograma.cbMarcas', '');
	set('frmEliminarCronograma.cbCanales', '');
	set('frmEliminarCronograma.cbCodigosDelPeriodo', '');
	set('frmEliminarCronograma.cbGruposDeZonas', '');
	set('frmEliminarCronograma.cbSubgerenciasDeVentas', '');
	set('frmEliminarCronograma.cbRegiones', '');
	set('frmEliminarCronograma.cbZonas','');

	vaciarCombo('frmEliminarCronograma.cbCodigosDelPeriodo');
	vaciarCombo('frmEliminarCronograma.cbGruposDeZonas');
	vaciarCombo('frmEliminarCronograma.cbSubgerenciasDeVentas');
	vaciarCombo('frmEliminarCronograma.cbRegiones');
	vaciarCombo('frmEliminarCronograma.cbZonas');

	focaliza('frmEliminarCronograma.cbMarcas', '');
}

function vaciarCombo(cmb){
	var longCombo = combo_get(cmb, 'L');

	try{
		if( longCombo > 0 ){
			var index2 = longCombo - 1;
			del_combo(cmb, 0, index2);
		}
	}
	catch(e){}
}

function LimpiarCombo(cmb){
  var i = 1;

  try{
    if( combo_get(cmb, 'L') > 0 ){
      while(i==1){
        if( combo_get(cmb, 'T', 0)=='' ){
          del_combo(cmb, 0);
        }
        else{
          i=0;
        }
      }
    }
  }
  catch(e){}
}

function obtenerPaisMarcaCanal(){
	//set('frmEliminarCronograma.hPais', get('frmEliminarCronograma.cbPaises'));
	set('frmEliminarCronograma.hCanal', get('frmEliminarCronograma.cbCanales'));
	set('frmEliminarCronograma.hMarca', get('frmEliminarCronograma.cbMarcas'));
	//set('frmEliminarCronograma.descPais', get('frmEliminarCronograma.cbPaises', 'T'));
	set('frmEliminarCronograma.descCanal', get('frmEliminarCronograma.cbCanales', 'T'));
	set('frmEliminarCronograma.descMarca', get('frmEliminarCronograma.cbMarcas', 'T'));
}

function enviarFormulario() {
	obtenerPaisMarcaCanal();
	set('frmEliminarCronograma.hCodigosDelPeriodo', get('frmEliminarCronograma.cbCodigosDelPeriodo'));
  set('frmEliminarCronograma.hZonas', get('frmEliminarCronograma.cbZonas'));
  
	if (cbGruposDeZonas.disabled){
  	set('frmEliminarCronograma.hSubgerenciasDeVentas', get('frmEliminarCronograma.cbSubgerenciasDeVentas'));
		set('frmEliminarCronograma.hRegiones', get('frmEliminarCronograma.cbRegiones'));
		set('frmEliminarCronograma.hGruposZonas', get('frmEliminarCronograma.cbGruposDeZonas'));
	}
	else{
  
		set('frmEliminarCronograma.hGruposZonas', get('frmEliminarCronograma.cbGruposDeZonas'));
  	set('frmEliminarCronograma.hSubgerenciasDeVentas', get('frmEliminarCronograma.cbSubgerenciasDeVentas'));
		set('frmEliminarCronograma.hRegiones', get('frmEliminarCronograma.cbRegiones'));
		set('frmEliminarCronograma.hGP', 'GP');
	}
	/*envia('frmEliminarCronograma');*/	
	
	//set('frmEliminarCronograma.hCodigosDelPeriodo', get('frmEliminarCronograma.cbCodigosDelPeriodo'));
	//deshabilitarControles();
	enviaSICC('frmEliminarCronograma');
}

function deshabilitarControles(){
	//accion('frmEliminarCronograma.cbPaises','.disabled= true');	
	accion('frmEliminarCronograma.cbMarcas','.disabled= true');
	accion('frmEliminarCronograma.cbCanales','.disabled= true');
	accion('frmEliminarCronograma.cbCodigosDelPeriodo','.disabled= true');
	accion('frmEliminarCronograma.hGruposZonas','.disabled=true');
	accion('frmEliminarCronograma.hSubgerenciasDeVentas','.disabled=true');	
	accion('frmEliminarCronograma.hRegiones','.disabled=true');
	accion('frmEliminarCronograma.hZonas','disabled=true');
	try{
		document.all.tags("INPUT")("btnBuscar").disabled = true;
	}
	catch(e){}
}

function comprobarRegion(){
	if(get('frmEliminarCronograma.cbRegiones') != ""){
		set('frmEliminarCronograma.accion', 'seleccionRegion');
		set('frmEliminarCronograma.conectorAction', 'LPEliminarCronograma');
		enviarFormulario();
	}
}

function comprobarSubgerenciaVentas(){
	if(get('frmEliminarCronograma.cbSubgerenciasDeVentas') != ""){
		set('frmEliminarCronograma.accion', 'seleccionUnidadAdministrativa');
		set('frmEliminarCronograma.conectorAction', 'LPEliminarCronograma');

		accion('frmEliminarCronograma.cbGruposDeZonas','.disabled=true');

		set('frmEliminarCronograma.cbZonas', '');

		enviarFormulario();
	}
	else{
		accion('frmEliminarCronograma.cbSubgerenciasDeVentas','.disabled=true');
		accion('frmEliminarCronograma.cbRegiones','.disabled=true');
		accion('frmEliminarCronograma.cbGruposDeZonas','.disabled=false');
	}
}

function comprobarGP(){
	if(get('frmEliminarCronograma.cbGruposDeZonas') != ""){

		accion('frmEliminarCronograma.cbSubgerenciasDeVentas','.disabled=true');
    
		accion('frmEliminarCronograma.cbRegiones','.disabled=true');
    

		set('frmEliminarCronograma.accion', 'seleccionGP');
   
		set('frmEliminarCronograma.conectorAction', 'LPEliminarCronograma');

		enviarFormulario();
	}
	else{
		accion('frmEliminarCronograma.cbSubgerenciasDeVentas','.disabled=false');
		accion('frmEliminarCronograma.cbRegiones','.disabled=false');
		accion('frmEliminarCronograma.cbGruposDeZonas','.disabled=true');
	}
}

function comprobarPaisMarcaCanal(){
	if(get('frmEliminarCronograma.cbMarcas')	!= "" && get('frmEliminarCronograma.cbCanales') != ""){
     set('frmEliminarCronograma.accion', 'seleccionPaisMarcaCanal');
		 set('frmEliminarCronograma.conectorAction', 'LPEliminarCronograma');
     set('frmEliminarCronograma.cbRegiones', '');
		 set('frmEliminarCronograma.cbZonas', '');
 		 enviarFormulario();
	}
}

function posicionarCombo() {
	/*var iSeleccionadoP = new Array();
	iSeleccionadoP[0] = get('frmEliminarCronograma.hPais');
	set('frmEliminarCronograma.cbPaises',iSeleccionadoP);*/
try{
/*		var iSeleccionadoP = new Array();
		iSeleccionadoP[0] = get('frmEliminarCronograma.hPais');
		set('frmEliminarCronograma.cbPaises',iSeleccionadoP);*/
	
		var iSeleccionadoM = new Array();
		iSeleccionadoM[0] = get('frmEliminarCronograma.hMarca');
		set('frmEliminarCronograma.cbMarcas',iSeleccionadoM);
	
		var iSeleccionado = new Array();
		iSeleccionado[0] = get('frmEliminarCronograma.hCanal');
		set('frmEliminarCronograma.cbCanales',iSeleccionado);
	
		var iSeleccionadoPER = new Array();
		iSeleccionadoPER[0] = get('frmEliminarCronograma.hCodigosDelPeriodo');
		set('frmEliminarCronograma.cbCodigosDelPeriodo',iSeleccionadoPER);
		
		var iSeleccionadoSV = new Array();
		iSeleccionadoSV[0] = get('frmEliminarCronograma.hSubgerenciasDeVentas');
		set('frmEliminarCronograma.cbSubgerenciasDeVentas',iSeleccionadoSV);

		var iSeleccionadoR = new Array();
		iSeleccionadoR[0] = get('frmEliminarCronograma.hRegiones');
		set('frmEliminarCronograma.cbRegiones',iSeleccionadoR);

		var iSeleccionadoZ = new Array();
		iSeleccionadoZ[0] = get('frmEliminarCronograma.hZonas');
		set('frmEliminarCronograma.cbZonas',iSeleccionadoZ);

		/*var iSeleccionadoPER = new Array();
		iSeleccionadoPER[0] = get('frmEliminarCronograma.hCodigosDelPeriodo');
		set('frmEliminarCronograma.cbCodigosDelPeriodo',iSeleccionadoPER);*/

		var iSeleccionadoGZ = new Array();
		iSeleccionadoGZ[0] = get('frmEliminarCronograma.hGruposZonas');
		set('frmEliminarCronograma.cbGruposDeZonas',iSeleccionadoGZ);

		focaliza('frmEliminarCronograma.cbMarcas', '');
	}
	catch(e){
	   	
	}
}

// Va a permitir limpiar las selecciones y el text field

function cargarRejilla(){
	set('frmEliminarCronograma.hOrigenCargaRejilla', 'buscar');
	if(fValidarCOMBO('frmEliminarCronograma.cbMarcas') && 
		fValidarCOMBO('frmEliminarCronograma.cbCanales') && 
		fValidarCOMBO('frmEliminarCronograma.cbCodigosDelPeriodo')){
		
		if (get('frmEliminarCronograma.hFlag') == 'OK'){
			if (get('frmEliminarCronograma.cbSubgerenciasDeVentas') != "" &&
				get('frmEliminarCronograma.cbRegiones') != ""){			
					set('frmEliminarCronograma.accion', 'completarRejilla');
					set('frmEliminarCronograma.conectorAction', 'LPEliminarCronograma');
					enviarFormulario();
			}
			else{
					GestionarMensaje('901','frmConsultarPeriodos.txtDescripcion');
			}
		}
		else if (get('frmEliminarCronograma.cbGruposDeZonas') != ""){
			set('frmEliminarCronograma.accion', 'completarRejilla');
			set('frmEliminarCronograma.conectorAction', 'LPEliminarCronograma');
			enviarFormulario();
		}
		else{
			GestionarMensaje('901','frmConsultarPeriodos.txtDescripcion');
		}
	}
	obtenerPaisMarcaCanal();

}
