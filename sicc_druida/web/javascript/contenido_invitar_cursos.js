/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/ 

/*
    INDRA/CAR/PROY
    $Id: contenido_invitar_cursos.js,v 1.1 2009/12/03 19:01:59 pecbazalar Exp $
    DESC
*/


var FORMULARIO = 'formulario';

function onLoadPag() {           
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
	document.all["AceptarDiv"].style.visibility='';
	eval (ON_RSZ); 

	if (get(FORMULARIO+'.errDescripcion')!='') {                      
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
	}
	
	configurarMenuSecundario(FORMULARIO);
}

function visibleLista() {
         if (!get_visibilidad("capaLista")){
                  visibilidad('capaLista','V');           
         }
}
 
function invisibleLista() {
         if (get_visibilidad("capaLista")){
                  visibilidad('capaLista','O');
         }
}
function muestraLista( ultima, rowset){
	var tamano = rowset.length;
	if (tamano > 0) {
	        visibleLista();
	        return true;
	} else {
	        invisibleLista();              
	        focaliza(FORMULARIO+'.cbMarca');
	        return false;
	}
}

function compruebashtab(){                               
	if (get_visibilidad("capaLista")){              
	        document.all['Aceptar'].focus();   
	}else{                                          
	        document.all['btnBuscar'].focus();      
	}                                               
} 
                                                        
function compruebatab(){                                 
	if (get_visibilidad("capaLista")){              
	        document.all['Aceptar'].focus();   
	}else{                                          
	        focaliza(FORMULARIO+'.cbMarca');        
	}  
}                                        

function onSeleccionaMarca(){
	vaciaSubgerencia();
	var marca = get(FORMULARIO + '.cbMarca');
	var canal = get(FORMULARIO + '.cbCanal');
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');
	var DTOUnidadAdministrativa = 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa';
	
	if (marca != "" && canal != ""){
	
		recargaCombo(FORMULARIO + '.cbSubgerenciaVentas', 'ZONRecargaSubgerenciaVentas', DTOUnidadAdministrativa,
		 	[['oidPais', pais], ['oidMarca', marca], ['oidCanal', canal], ['oidIdioma', idioma]] );
	}
}

function onSeleccionaSubgerencia(){
	vaciaRegion();
	var subgerencia = get(FORMULARIO + '.cbSubgerenciaVentas');
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');
	var DTOUnidadAdministrativa = 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa';
	
	if (subgerencia != ""){
		recargaCombo(FORMULARIO + '.cbRegion', 'ZONRecargaRegiones', DTOUnidadAdministrativa,
		 	[['oidPais', pais], ['oidSGV', subgerencia], ['oidIdioma', idioma]] );
	}
}

function onSeleccionaRegion(){
	vaciaZona();
	var region = get(FORMULARIO + '.cbRegion');
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');
	var DTOUnidadAdministrativa = 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa';
	
	if (region != ""){
		recargaCombo(FORMULARIO + '.cbZona', 'ZONRecargaZonas', DTOUnidadAdministrativa,
		 	[['oidPais', pais], ['oidRegion', region], ['oidIdioma', idioma]] );
	} 
}

function onSeleccionaZona(){
	vaciaSeccion();
	var zona = get(FORMULARIO + '.cbZona');
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');
	var DTOUnidadAdministrativa = 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa';
	
	if (zona != ""){
		recargaCombo(FORMULARIO + '.cbSeccion', 'ZONRecargaSecciones', DTOUnidadAdministrativa,
		 	[['oidPais', pais], ['oidZona', zona], ['oidIdioma', idioma]] );
	} 
}

function onSeleccionaSeccion(){
	vaciaTerritorio();
	var seccion = get(FORMULARIO + '.cbSeccion');
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');
	var DTOUnidadAdministrativa = 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa';
	
	if (seccion != ""){
		recargaCombo(FORMULARIO + '.cbTerritorio', 'ZONRecargaTerritorios', DTOUnidadAdministrativa,
		 	[['oidPais', pais], ['oidSeccion', seccion], ['oidIdioma', idioma]] );
	}
}

function vaciaTerritorio(){
	set_combo(FORMULARIO+'.cbTerritorio',[['','']],['']);
}

function vaciaSeccion(){
	set_combo(FORMULARIO+'.cbSeccion',[['','']],['']);
	vaciaTerritorio();
}

function vaciaZona(){
	set_combo(FORMULARIO+'.cbZona',[['','']],['']);
	vaciaSeccion();
}

function vaciaRegion(){
	set_combo(FORMULARIO+'.cbRegion',[['','']],['']);
	vaciaZona();
}

function vaciaSubgerencia(){
	set_combo(FORMULARIO+'.cbSubgerenciaVentas',[['','']],['']);
	vaciaRegion();
}

function onClickBuscar(){
	
	var marca = get(FORMULARIO + '.cbMarca');
	var canal = get(FORMULARIO + '.cbCanal');
	var codigo = get(FORMULARIO + '.txtCodCliente');
	var subgerencia = get(FORMULARIO + '.cbSubgerenciaVentas');
	var region = get(FORMULARIO + '.cbRegion');
	var zona = get(FORMULARIO + '.cbZona');
	var seccion = get(FORMULARIO + '.cbSeccion');
	var territorio = get(FORMULARIO + '.cbTerritorio');
	var pais = get(FORMULARIO + '.pais');
	var idioma = get(FORMULARIO + '.idioma');
	
	var DTOBuscarClientesCurso = 'es.indra.sicc.dtos.mae.DTOBuscarClientesCursos';

	configurarPaginado(mipgndo,
					 "MAEBuscarClientesParaCurso", 
					 "ConectorBuscarClientesParaCurso",
					 DTOBuscarClientesCurso, 
					 [ 
					 	["oidIdioma", idioma], 
						["oidPais", pais],
					 	["marca", marca], 
					 	["canal", canal], 
					 	["codigo", codigo], 
						["subgerencia", subgerencia], 
						["region", region], 
						["zona", zona], 
						["seccion", seccion], 
						["territorio", territorio]
					] );
} 

function onClickAceptar(){
	if (listado1.numSelecc() == 0 ){
		GestionarMensaje('50'); 
		return;
	}
	var iguales = 0;
	listado1.actualizaDat(); //Actualiza el array 'datos'
	var datos = listado1.datos;
	var seleccionados = listado1.codSeleccionados();
	for(i=0; i<seleccionados.length; i++){
		
		for(j=i+1; j<seleccionados.length; j++){
			if(seleccionados[i] == seleccionados[j]){
				
				iguales = 1;
				break;
			}
			
		}	
	}
	if(iguales == 1){
		//Muestra el mensaje: "Al menos hay un cliente seleccionado 
		// más de una vez" (UIEDU0002) 

		cdos_mostrarAlert(GestionarMensaje('1370'));
	} else{
		var k = 0;
		var cadena = '';
		for (var i = 0; i < datos.length; i++){
			if (seleccionados[k] == datos[i][0]){
				var fila = datos[i];
				cadena += fila[0] + ',' + fila[13] + '*';
				k++;
			}
		}
		
		set(FORMULARIO + '.accion','Invitar');
		set(FORMULARIO + '.conectorAction','LPInvitadas');
		set(FORMULARIO + '.datosInvitadas', cadena);
		enviaSICC(FORMULARIO);
	}
}

function fLimpiar(){
	set(FORMULARIO + '.cbMarca', '');
	set(FORMULARIO + '.cbCanal', '');
	set(FORMULARIO + '.txtCodCliente', '');
	vaciaSubgerencia();
}

function fVolver(){
	window.close();
}

//Funcion que se ejecuta cuando se pincha sobre la lupa
function accionSeleccionarCliente() {

         //Abrimos un popup modal con la direccion de la LPBusquedaRapidaCliente, 
         //cuando se cierra el popup si el usuario ha seleleccionado un cliente 
         //se nos devuelven dos valores en un array. 
         //Con el segundo valor rellenamos el campo codigoCliente

    //Llamamos al proceso correspondiente Modal
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);        
	if (typeof(cliente)!='undefined'){
		var codigoCliente = cliente[1];
    	set(FORMULARIO+'.txtCodCliente',codigoCliente);
    }
}
function textCodClienteOnBlur() {
	var codigoCliente = get(FORMULARIO+'.txtCodCliente').toString();
    if (codigoCliente != '') {
    	var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
		var longitud = codigoCliente.length;
		set(FORMULARIO+'.txtCodCliente',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud));
	}
}
