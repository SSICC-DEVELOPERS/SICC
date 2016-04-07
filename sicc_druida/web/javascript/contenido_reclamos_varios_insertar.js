var FORMULARIO = 'formulario';
//Funcion que se ejecuta al cargar la pagina
function onLoadPag(){
         if (get(FORMULARIO+'.errDescripcion')!='') {                    
                  var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
         }                   
	
         
         focaliza(FORMULARIO+".cbCodUsuario");
         configurarMenuSecundario(FORMULARIO); //comentado hasta implementar menú secundario
		 if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
				btnProxy(2,1);  // boton 'volver', habilitado
				btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
				ModificarToolbar();
		}
}									  

/*
	Esta funcion se encarga de configurar la botonera, cuando se 
	la pagina es modal.Para eso se modifica la variable oculta 	
	SICC_TOOLBAR_CONFIG	  
	que viene por defecto para indicar la configuracion del menu.
*/
function ModificarToolbar(){

		//obtengo el String con la configuracion a aplicar
		var strCodigos = get(FORMULARIO+".SICC_TOOLBAR_CONFIG");

		/*Dentro del SICC_TOOLBAR_CONFIG, luego del segundo espacio en blanco, 
		 se encuentra la informacion sobre el ícono volver */
		 
		pos = strCodigos.indexOf(" ");
		pos = strCodigos.indexOf(" ",pos+1);
		pos= pos+2;
		//activo el boton volver
		strCodigos= setCharAt(strCodigos, pos, '1') ;
		
		/*La cuarte posicion del string  SICC_TOOLBAR_CONFIG 
		  (es decir luego del tercer espacio en blanco) contiene la informacion
		   sobre el icono inicio
		*/
		pos = strCodigos.indexOf(" ",pos);	
		pos = pos +2;
		//desactivo el boton inicio
		strCodigos= setCharAt(strCodigos, pos, '0') ;

		set(FORMULARIO+".SICC_TOOLBAR_CONFIG",strCodigos);
	
	}

	function setCharAt(str, index, ch) {
		return str.substr(0, index - 1) + ch + str.substr(index);
	}



function focalizaOnshtab(){
	document.all['btnRealizarRec'].focus();
}
function focalizaOntab(){
	
	focaliza(FORMULARIO+".cbCodUsuario");
}

/*Llamar al método recargaCombo utilizando el DTOCliente y el idBusiness = "CALObtenerBuzonUsuario". 

Parametros del DTOCliente: 
- DTOCliente.codCliente = codigo de usuario seleccionado en la combo cbCodUsuario 
- DTOCliente.pais = pais activo 

Obtenemos un DTOSalida y cargamos la combo cbBuzon*/
function cbCodUsuarioOnChange(){
	var dto = 'es.indra.sicc.dtos.cal.DTOCliente';
	var idioma = get(FORMULARIO+'.hIdioma');
	var pais = get(FORMULARIO+'.hPais');
	var codUsuario = get(FORMULARIO+'.cbCodUsuario');
	
	recargaCombo(FORMULARIO+'.cbBuzon','CALObtenerBuzonUsuario', 'es.indra.sicc.dtos.cal.DTOCliente' , [['oidIdioma',idioma],['oidPais',pais],['codCliente',codUsuario]] );
	//recargaCombo(FORMULARIO+'.cbTipoCurso', 'CMNObtieneTiposCurso', 'es.indra.sicc.dtos.edu.DTODruidaBusqueda', [['oidIdioma',idioma],['oidMarca', marca],['oidPais',pais]] );	
}
/*
Llama a la LPReclamos con: 
- accion="insertarReclamo" 
- oidContacto 
- codUsuario: idUsuario seleccionado en la cbCodUsuario 
- oidCabecera: oid del valor seleccionado en la cbBuzon 
- descripcionActividad 
- oidGestion: oid del valor seleccionado en la cbTipoGestionCliente 
- observaciones*/

function onClickRealizarReclamo(){
	if(sicc_validaciones_generales()){
		set(FORMULARIO+'.accion','insertarReclamo');
		set(FORMULARIO+'.conectorAction','LPReclamos');
		enviaSICC(FORMULARIO);
	}
}
function insercionCorrecta(){
         fLimpiarGenericoSICC();
         set(FORMULARIO+'.atxtObservaciones','');
         vaciaCombo(FORMULARIO+'.cbBuzon');
}
function fGuardar() {
	if(sicc_validaciones_generales()){
		set(FORMULARIO+'.accion','insertarReclamo');
		set(FORMULARIO+'.conectorAction','LPReclamos');
		enviaSICC(FORMULARIO);
		
	}
}
function fLimpiar(){
	set(FORMULARIO+'.atxtObservaciones','');
	vaciaCombo(FORMULARIO+'.cbBuzon');
}
function vaciaCombo(combo) {

         set_combo(combo,[['','']],['']);

}
  function fVolver(){
     window.returnValue=get(FORMULARIO+'.oidContacto');
 	window.close();            

 }

  function unLoadPag(){
    window.returnValue=get(FORMULARIO+'.oidContacto');
 }



 

