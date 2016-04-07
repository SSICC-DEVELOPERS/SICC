// Para eliminar todo el cronograma
function borrar(){
	if(GestionarMensaje('5')){
		set('frmConsultarCronograma.accion', 'eliminarCronograma');
		set('frmConsultarCronograma.conectorAction', 'LPConsultarCronograma');
		enviarFormulario();
	}
}

function inicializacion(){

  configurarMenuSecundario("frmConsultarCronograma");
  eval (ON_RSZ); 
			
	if (get('frmConsultarCronograma.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get('frmConsultarCronograma.errCodigo'), get('frmConsultarCronograma.errDescripcion'));
	}

	if(get('frmConsultarCronograma.hCronoVacio') == 'vacio' && get('frmConsultarCronograma.hOrigenCargaRejilla') == 'buscar'){
		//muestro el mensaje de "NO HAY DATOS"
	 	GestionarMensaje('160','frmConsultarCronograma.txtDescripcion');
	}

	if (get('frmConsultarCronograma.hFlag') == 'OK') {
		accion('frmConsultarCronograma.cbGruposDeZonas','.disabled=true');
	}

	if (get('frmConsultarCronograma.hGP') == 'GP') {
		accion('frmConsultarCronograma.cbSubgerenciasDeVentas','.disabled=true');
		accion('frmConsultarCronograma.cbRegiones','.disabled=true');
	}

	if( get('frmConsultarCronograma.hCapaVisible')=='v' ){
		moveTo('capaRejilla', 0, 530);
		visibilidad('capaRejilla','V');
	}
	else{
		moveTo('capaRejilla', 0, 0);
	}
	//VERIFICAR QUE LOS COMBOS NO TENGAN VALORES EN BLANCO
	LimpiarCombo( 'frmConsultarCronograma.cbMarcas' );
	//LimpiarCombo( 'frmConsultarCronograma.cbCanales' );
	LimpiarCombo( 'frmConsultarCronograma.cbCodigosDelPeriodo' );
	LimpiarCombo( 'frmConsultarCronograma.cbRegiones' );
	LimpiarCombo( 'frmConsultarCronograma.cbZonas' );
	
	//combo_add('frmConsultarCronograma.cbCanales', '', '')	;
	//agregarVacio('frmConsultarCronograma.cbCanales');

	focaliza('frmConsultarCronograma.cbMarcas','');
  
	accion('frmConsultarCronograma.chkTodahMarcas','.disabled=true');
	accion('frmConsultarCronograma.chkTodosGruposDeZonas','.disabled=true');
	accion('frmConsultarCronograma.chkTodasSecciones','.disabled=true');
}

/*function Limpiar(){
	setTimeout("Limpiar2()", 100);
}*/


// Agregado para limpiar las celdas del formulario *** que faltan campos
function fLimpiar() {
    //Porque si hacemos solo limpiar queda el icono guardar habilitado
    if (get('frmConsultarCronograma.hCapaVisible') == 'S') {
        set('frmConsultarCronograma.accion', '');
        set('frmConsultarCronograma.conectorAction', 'LPConsultarCronograma');
        enviaSICC('frmConsultarCronograma');
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
		set('frmConsultarCronograma.cbMarcas',iSeleccionadoM);
	
		var iSeleccionado = new Array();
		set('frmConsultarCronograma.cbCanales',iSeleccionado);
	
		var iSeleccionadoPER = new Array();
		set('frmConsultarCronograma.cbCodigosDelPeriodo',iSeleccionadoPER);

		var iSeleccionadoPER = new Array();
		set('frmConsultarCronograma.cbGruposDeZonas',iSeleccionadoPER);

		var iSeleccionadoPER = new Array();
		set('frmConsultarCronograma.cbSubgerenciasDeVentas',iSeleccionadoPER);

		var iSeleccionadoPER = new Array();
		set('frmConsultarCronograma.cbRegiones',iSeleccionadoPER);

		var iSeleccionadoPER = new Array();
		set('frmConsultarCronograma.cbZonas',iSeleccionadoPER);	
		
		focaliza('frmConsultarCronograma.cbMarcas');	
		
		//set('frmGenerarCronograma2.hPais','');
		set('frmConsultarCronograma.hMarca','');
		set('frmConsultarCronograma.hCanal','');
		accion('frmConsultarCronograma.cbCodigosDelPeriodo','.disabled=true');
		
		document.all.tags("INPUT")("btnBuscar").disabled = true;
		visibilidad('miscroll', 'O');	
	}
	catch(e){}
	
			
}


function Limpiar2()  {
	set('frmConsultarCronograma.cbMarcas', '');
	set('frmConsultarCronograma.cbCanales', '');
	set('frmConsultarCronograma.cbCodigosDelPeriodo', '');
	set('frmConsultarCronograma.cbGruposDeZonas', '');
	set('frmConsultarCronograma.cbSubgerenciasDeVentas', '');
	set('frmConsultarCronograma.cbRegiones', '');
	set('frmConsultarCronograma.cbZonas','');

	vaciarCombo('frmConsultarCronograma.cbCodigosDelPeriodo');
	vaciarCombo('frmConsultarCronograma.cbGruposDeZonas');
	vaciarCombo('frmConsultarCronograma.cbSubgerenciasDeVentas');
	vaciarCombo('frmConsultarCronograma.cbRegiones');
	vaciarCombo('frmConsultarCronograma.cbZonas');

	focaliza('frmConsultarCronograma.cbMarcas', '');
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
	//set('frmConsultarCronograma.hPais', get('frmConsultarCronograma.cbPaises'));
	set('frmConsultarCronograma.hCanal', get('frmConsultarCronograma.cbCanales'));
	set('frmConsultarCronograma.hMarca', get('frmConsultarCronograma.cbMarcas'));
	//set('frmConsultarCronograma.descPais', get('frmConsultarCronograma.cbPaises', 'T'));
	set('frmConsultarCronograma.descCanal', get('frmConsultarCronograma.cbCanales', 'T'));
	set('frmConsultarCronograma.descMarca', get('frmConsultarCronograma.cbMarcas', 'T'));
}

function enviarFormulario() {
	obtenerPaisMarcaCanal();
	set('frmConsultarCronograma.hCodigosDelPeriodo', get('frmConsultarCronograma.cbCodigosDelPeriodo'));
  set('frmConsultarCronograma.hZonas', get('frmConsultarCronograma.cbZonas'));
  
	if (cbGruposDeZonas.disabled){
  	set('frmConsultarCronograma.hSubgerenciasDeVentas', get('frmConsultarCronograma.cbSubgerenciasDeVentas'));
		set('frmConsultarCronograma.hRegiones', get('frmConsultarCronograma.cbRegiones'));
		set('frmConsultarCronograma.hGruposZonas', get('frmConsultarCronograma.cbGruposDeZonas'));
	}
	else{
  
		set('frmConsultarCronograma.hGruposZonas', get('frmConsultarCronograma.cbGruposDeZonas'));
  	set('frmConsultarCronograma.hSubgerenciasDeVentas', get('frmConsultarCronograma.cbSubgerenciasDeVentas'));
		set('frmConsultarCronograma.hRegiones', get('frmConsultarCronograma.cbRegiones'));
		set('frmConsultarCronograma.hGP', 'GP');
	}
	/*envia('frmConsultarCronograma');*/	
	
	//set('frmConsultarCronograma.hCodigosDelPeriodo', get('frmConsultarCronograma.cbCodigosDelPeriodo'));
	//deshabilitarControles(); 

	enviaSICC('frmConsultarCronograma');
}

function deshabilitarControles(){
	//accion('frmConsultarCronograma.cbPaises','.disabled= true');	
	accion('frmConsultarCronograma.cbMarcas','.disabled= true');
	accion('frmConsultarCronograma.cbCanales','.disabled= true');
	accion('frmConsultarCronograma.cbCodigosDelPeriodo','.disabled= true');
	accion('frmConsultarCronograma.hGruposZonas','.disabled=true');
	accion('frmConsultarCronograma.hSubgerenciasDeVentas','.disabled=true');	
	accion('frmConsultarCronograma.hRegiones','.disabled=true');
	accion('frmConsultarCronograma.hZonas','disabled=true');
	try{
		document.all.tags("INPUT")("btnBuscar").disabled = true;
	}
	catch(e){}
}

function comprobarRegion(){
	if(get('frmConsultarCronograma.cbRegiones') != ""){
		set('frmConsultarCronograma.accion', 'seleccionRegion');
		set('frmConsultarCronograma.conectorAction', 'LPConsultarCronograma');
		enviarFormulario();
	}
}

function comprobarSubgerenciaVentas(){
	if(get('frmConsultarCronograma.cbSubgerenciasDeVentas') != ""){
		set('frmConsultarCronograma.accion', 'seleccionUnidadAdministrativa');
		set('frmConsultarCronograma.conectorAction', 'LPConsultarCronograma');

		accion('frmConsultarCronograma.cbGruposDeZonas','.disabled=true');

		set('frmConsultarCronograma.cbZonas', '');

		enviarFormulario();
	}
	else{
		accion('frmConsultarCronograma.cbSubgerenciasDeVentas','.disabled=true');
		accion('frmConsultarCronograma.cbRegiones','.disabled=true');
		accion('frmConsultarCronograma.cbGruposDeZonas','.disabled=false');
	}
}

function comprobarGP(){
	if(get('frmConsultarCronograma.cbGruposDeZonas') != ""){

		accion('frmConsultarCronograma.cbSubgerenciasDeVentas','.disabled=true');
    
		accion('frmConsultarCronograma.cbRegiones','.disabled=true');
    

		set('frmConsultarCronograma.accion', 'seleccionGP');
   
		set('frmConsultarCronograma.conectorAction', 'LPConsultarCronograma');

		enviarFormulario();
	}
	else{
		accion('frmConsultarCronograma.cbSubgerenciasDeVentas','.disabled=false');
		accion('frmConsultarCronograma.cbRegiones','.disabled=false');
		accion('frmConsultarCronograma.cbGruposDeZonas','.disabled=true');
	}
}

function comprobarPaisMarcaCanal(){
	if(get('frmConsultarCronograma.cbMarcas')	!= "" && get('frmConsultarCronograma.cbCanales') != ""){
     set('frmConsultarCronograma.accion', 'seleccionPaisMarcaCanal');
		 set('frmConsultarCronograma.conectorAction', 'LPConsultarCronograma');
     set('frmConsultarCronograma.cbRegiones', '');
		 set('frmConsultarCronograma.cbZonas', '');
 		 enviarFormulario();
	}
}

function posicionarCombo() {
	/*var iSeleccionadoP = new Array();
	iSeleccionadoP[0] = get('frmConsultarCronograma.hPais');
	set('frmConsultarCronograma.cbPaises',iSeleccionadoP);*/
try{
/*		var iSeleccionadoP = new Array();
		iSeleccionadoP[0] = get('frmConsultarCronograma.hPais');
		set('frmConsultarCronograma.cbPaises',iSeleccionadoP);*/
	
		var iSeleccionadoM = new Array();
		iSeleccionadoM[0] = get('frmConsultarCronograma.hMarca');
		set('frmConsultarCronograma.cbMarcas',iSeleccionadoM);
	
		var iSeleccionado = new Array();
		iSeleccionado[0] = get('frmConsultarCronograma.hCanal');
		set('frmConsultarCronograma.cbCanales',iSeleccionado);
	
		var iSeleccionadoPER = new Array();
		iSeleccionadoPER[0] = get('frmConsultarCronograma.hCodigosDelPeriodo');
		set('frmConsultarCronograma.cbCodigosDelPeriodo',iSeleccionadoPER);
		
		var iSeleccionadoSV = new Array();
		iSeleccionadoSV[0] = get('frmConsultarCronograma.hSubgerenciasDeVentas');
		set('frmConsultarCronograma.cbSubgerenciasDeVentas',iSeleccionadoSV);

		var iSeleccionadoR = new Array();
		iSeleccionadoR[0] = get('frmConsultarCronograma.hRegiones');
		set('frmConsultarCronograma.cbRegiones',iSeleccionadoR);

		var iSeleccionadoZ = new Array();
		iSeleccionadoZ[0] = get('frmConsultarCronograma.hZonas');
		set('frmConsultarCronograma.cbZonas',iSeleccionadoZ);

		/*var iSeleccionadoPER = new Array();
		iSeleccionadoPER[0] = get('frmConsultarCronograma.hCodigosDelPeriodo');
		set('frmConsultarCronograma.cbCodigosDelPeriodo',iSeleccionadoPER);*/

		var iSeleccionadoGZ = new Array();
		iSeleccionadoGZ[0] = get('frmConsultarCronograma.hGruposZonas');
		set('frmConsultarCronograma.cbGruposDeZonas',iSeleccionadoGZ);

		focaliza('frmConsultarCronograma.cbMarcas', '');
	}
	catch(e){
	   	
	}
}

// Va a permitir limpiar las selecciones y el text field

function cargarRejilla(){
	set('frmConsultarCronograma.hOrigenCargaRejilla', 'buscar');
	if(fValidarCOMBO('frmConsultarCronograma.cbMarcas') && 
		fValidarCOMBO('frmConsultarCronograma.cbCanales') && 
		fValidarCOMBO('frmConsultarCronograma.cbCodigosDelPeriodo')){
		
		if (get('frmConsultarCronograma.hFlag') == 'OK'){
			if (get('frmConsultarCronograma.cbSubgerenciasDeVentas') != "" &&
				get('frmConsultarCronograma.cbRegiones') != ""){			
					set('frmConsultarCronograma.accion', 'completarRejilla');
					set('frmConsultarCronograma.conectorAction', 'LPConsultarCronograma');
					enviarFormulario();
			}
			else{
					GestionarMensaje('901','frmConsultarPeriodos.txtDescripcion');
			}
		}
		else if (get('frmConsultarCronograma.cbGruposDeZonas') != ""){
			set('frmConsultarCronograma.accion', 'completarRejilla');
			set('frmConsultarCronograma.conectorAction', 'LPConsultarCronograma');
			enviarFormulario();
		}
		else{
			GestionarMensaje('901','frmConsultarPeriodos.txtDescripcion');
		}
	}
	obtenerPaisMarcaCanal();

}
