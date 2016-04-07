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
    $Id: contenido_formas_pago_detalle_insertar_detalle.js,v 1.1 2009/12/03 19:02:13 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'formulario';

//Funcion que se ejecuta al cargar la pagina
function onLoadPag()   {
	
    if (get(FORMULARIO+'.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
    }   
    
    var tipo=get(FORMULARIO+'.tipoAccion');
    var dias = get(FORMULARIO+'.cargaComboDias');
    
    if (tipo=="modificar"){
    	
    	document.all["btnAceptar"].style.visibility = '';
    	focaliza(FORMULARIO + ".txtPorcentajePago");
    	var dias = get(FORMULARIO+'.cargaComboDias');
    	if(dias == '00'){
   				accion(FORMULARIO+'.txtNumDias','.disabled=false');
   		}else{
   				accion(FORMULARIO+'.txtNumDias','.disabled=true');
   		}
   		if(dias == '03'){ //opcion A
   				accion(FORMULARIO+'.cbActividad','.disabled=false');
   				accion(FORMULARIO+'.cbMarca','.disabled=false');
   				accion(FORMULARIO+'.cbCanal','.disabled=false');
   		}else{
   				accion(FORMULARIO+'.cbActividad','.disabled=true');
   				accion(FORMULARIO+'.cbMarca','.disabled=true');
   				accion(FORMULARIO+'.cbCanal','.disabled=true');
   		}
   		if (dias != "")
  			set(FORMULARIO+'.cbIndicadorDias', [dias]);
   	}
    
    if (tipo=="detalle"){
    	//document.all["btnAceptar"].style.visibility = 'hidden';
    	visibilidad('capaEspacio2','O');
    }
   
   configurarMenuSecundario(FORMULARIO); 
}

function marcaOnChange() {
         
    //Cuando cambie el combo de marca recargamos el de actividad en función del primero. 
		          
    var marca = get(FORMULARIO+'.cbMarca');
    var canal = get(FORMULARIO+'.cbCanal');
    var pais = get(FORMULARIO+'.pais');
    var idioma = get(FORMULARIO+'.idioma');
    if((canal != "")&&(marca != "")){
   		recargaCombo(FORMULARIO+'.cbActividad','BELRecargaComboActividad', 'es.indra.sicc.dtos.cra.DTOActividad',[["oidMarca", marca],["oidCanal", canal],["oidPais",pais],["oidIdioma",idioma]]);         
		accion(FORMULARIO+'.cbActividad','.disabled=false');
	}else{
    	vaciaCombo(".cbActividad");
    }
    
}

//Funcion que se ejecuta cuando cambia el combo canal
function canalOnChange() {
         
    //Cuando cambie el combo de canal recargamos el de actividad en función del primero. 
	         
    var marca = get(FORMULARIO+'.cbMarca');
    var canal = get(FORMULARIO+'.cbCanal');
    var pais = get(FORMULARIO+'.pais');
    var idioma = get(FORMULARIO+'.idioma');
    if((canal != "")&&(marca != "")){
   		recargaCombo(FORMULARIO+'.cbActividad','BELRecargaComboActividad', 'es.indra.sicc.dtos.cra.DTOActividad',[["oidMarca", marca],["oidCanal", canal],["oidPais",pais],["oidIdioma",idioma]]);         
		accion(FORMULARIO+'.cbActividad','.disabled=false');
	}else{
    	vaciaCombo(".cbActividad");
    }
    
}

//Funcion que se ejecuta cuando se pulsa aceptar
function accionAceptar() {
	//Modifica los datos del registro de la lista de registros 
	//de Forma Pago Detalle de la pantalla llamante que contiene 
	//la posición guardada en la variable oculta "posicionDetalle" 
	//con los datos de esta página.
	
	//Validamos que todo sea correcto
	if (sicc_validaciones_generales()) {
		
		//Obtenemos todos los datos
		//Los devolvemos en una fila para actualizar la anterior
		
		
		var formaPagoCabecera = get(FORMULARIO+'.desCabecera').toString();
        var posicionDetalle = get(FORMULARIO+'.posicion').toString();
		var medioPago = get(FORMULARIO+'.cbCodigoMedioPago','T').toString();
		var porcentajePago = get(FORMULARIO+'.txtPorcentajePago').toString();
		var indicadorDeDias = get(FORMULARIO+'.cbIndicadorDias','T').toString();
		var numeroDeDias = get(FORMULARIO+'.txtNumDias').toString();
		var marca = get(FORMULARIO+'.cbMarca','T').toString();
		var canal = get(FORMULARIO+'.cbCanal','T').toString();
		var actividad = get(FORMULARIO+'.cbActividad','T').toString();
		//Oids ocultos
		//var oidformaPagoCabecera = get(FORMULARIO+'.oidCabecera');
		var oidFormaPagoDetalle = get(FORMULARIO+'.oidFormaPagoDetalle').toString();
		var oidmedioPago = get(FORMULARIO+'.cbCodigoMedioPago').toString();
		var oidmarca = get(FORMULARIO+'.cbMarca').toString();
		var oidcanal = get(FORMULARIO+'.cbCanal').toString();
		var oidactividad = get(FORMULARIO+'.cbActividad').toString();
		var oidindicadorDeDias = get(FORMULARIO+'.cbIndicadorDias').toString();
		
		
		window.returnValue = [posicionDetalle,formaPagoCabecera,posicionDetalle,porcentajePago,medioPago,indicadorDeDias,numeroDeDias,marca,canal,actividad,oidFormaPagoDetalle,oidmedioPago,oidmarca,oidcanal,oidactividad,oidindicadorDeDias];
		
		window.close();
	}
	
}

function fVolver(){
	window.close();	
}

function seleccionaActividad(datos){
	
	var actividad = get(FORMULARIO +'.oidActividad');

	set_combo(FORMULARIO+'.cbActividad', datos);
	set(FORMULARIO +'.cbActividad',  [actividad]);
	
}

function vaciaCombo(combo) {

    if (eval('document'+combo) != 'undefined') 
        set_combo(FORMULARIO + combo,[['','']],['']);
    return true;
}

function onBlurPorcentaje(){
	var porcentaje = get(FORMULARIO+'.txtPorcentajePago');
	if(esNumero(porcentaje) == '-1'){
		GestionarMensaje('1256');
		focaliza(FORMULARIO+'.txtPorcentajePago');
	}
}

function activarDias(){
	
	   var indicador = get(FORMULARIO +'.cbIndicadorDias','T');
         if (indicador == 'N') {
                  accion(FORMULARIO+'.txtNumDias','.disabled=false');
         } else {
                  set(FORMULARIO +'.txtNumDias','');
                  accion(FORMULARIO+'.txtNumDias','.disabled=true');
         }

         if (indicador == 'N'){
                           for (var i = 0; i < objValidacionSICC.length; i++) {
                                    if (objValidacionSICC[i].nombre == 'txtNumDias')
                                             objValidacionSICC[i].requerido = true;
                           }
         } else {
                           for (var i = 0; i < objValidacionSICC.length; i++) {
                                    if (objValidacionSICC[i].nombre == 'txtNumDias')
                                             objValidacionSICC[i].requerido = false;
                           }
         }

         if (indicador == 'A') {
         	
         	
		  
                  for (var i = 0; i < objValidacionSICC.length; i++) {
                           if (objValidacionSICC[i].nombre == 'cbMarca' || objValidacionSICC[i].nombre == 'cbCanal' || objValidacionSICC[i].nombre == 'cbActividad')
                                    objValidacionSICC[i].requerido = true;
                  }
                  
		 
                  accion(FORMULARIO+'.cbMarca','.disabled=false');
                  
                  accion(FORMULARIO+'.cbCanal','.disabled=false');
              
                 // set(FORMULARIO +'.cbMarca',[omarcaPorDefectoa]);	
                  
                  //set(FORMULARIO +'.cbCanal',[canalPorDefecto]);  
                  //Se eliminan estas dos lineas ya que impiden la carga correcta de los combos
                
                  
                  if (get(FORMULARIO +'.cbMarca') == ''){	//puede haber problemas de evidencia de foco	
                           
                           set(FORMULARIO +'.cbMarca', ['']);
                        }
                  if (get(FORMULARIO +'.cbCanal') == ''){
                  
                           set(FORMULARIO +'.cbCanal', ['']);
                        }
                 // marcaOnChange();		
         } else {
         		
                  for (var i = 0; i < objValidacionSICC.length; i++) {
                           if (objValidacionSICC[i].nombre == 'cbMarca' || objValidacionSICC[i].nombre == 'cbCanal' || objValidacionSICC[i].nombre == 'cbActividad')
                                    objValidacionSICC[i].requerido = false;
                  }
                  accion(FORMULARIO+'.cbActividad','.disabled=true');
                  set(FORMULARIO +'.cbMarca', ['']);
                  set(FORMULARIO +'.cbCanal', ['']);
                  accion(FORMULARIO+'.cbMarca','.disabled=true');
                  accion(FORMULARIO+'.cbCanal','.disabled=true');
                  vaciaCombo('.cbActividad');
         }
}

function focoBoton(){
	document.all['btnAceptar'].focus();
}

function fLimpiar(){
	
	
	var dias = get(FORMULARIO +'.cargaComboDias');
	var marca = get(FORMULARIO +'.oidMarca');
	var canal = get(FORMULARIO +'.oidCanal');
	var medioPago = get(FORMULARIO +'.oidMedioPago');
	
	if (dias != "") {
  		set(FORMULARIO +'.cbIndicadorDias', [dias]);
	}
	if(canal != ""){
		set(FORMULARIO +'.cbCanal',[canal]);	
	}
	if(marca != ""){
		set(FORMULARIO +'.cbMarca',[marca]);	
	}
	
	set(FORMULARIO +'.cbCodigoMedioPago',[medioPago]);
	
	if(dias == '00'){
		accion(FORMULARIO+'.txtNumDias','.disabled=false');
	}else{
		accion(FORMULARIO+'.txtNumDias','.disabled=true');
	}
	if(dias == '03'){
		accion(FORMULARIO+'.cbMarca','.disabled=false');
		accion(FORMULARIO+'.cbCanal','.disabled=false');
		if((canal != "")&&(marca != "")){
			var pais = get(FORMULARIO+'.pais');
    		var idioma = get(FORMULARIO+'.idioma');
			asignar([["COMBO",FORMULARIO +'.cbActividad', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', formarCadenaDT('BELRecargaComboActividad', 'es.indra.sicc.dtos.cra.DTOActividad', [["oidMarca", marca],["oidCanal", canal],["oidPais",pais],["oidIdioma",idioma]]),"seleccionaActividad(datos)"]],"","");         	
			accion(FORMULARIO+'.cbActividad','.disabled=false');
		}
	}else{
		accion(FORMULARIO+'.cbActividad','.disabled=true');
		accion(FORMULARIO+'.cbMarca','.disabled=true');
		accion(FORMULARIO+'.cbCanal','.disabled=true');
	}
}

function seleccionaActividad(datos){

	var actividad = get(FORMULARIO +'.oidActividad');
	set_combo(FORMULARIO +'.cbActividad', datos);
	if(actividad != ""){
		set(FORMULARIO +'.cbActividad',[actividad]);	
	}
}