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
    $Id: contenido_asistencia_cursos_registrar.js,v 1.1 2009/12/03 19:01:40 pecbazalar Exp $
    DESC
*/
var FORMULARIO = 'formulario';

function onLoadPag(){           
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
	document.all["ParticipantesDiv"].style.visibility='';     
	eval (ON_RSZ);   
    
    configurarMenuSecundario(FORMULARIO); 	
    
    var errDescripcion = get(FORMULARIO+'.errDescripcion');
	if (errDescripcion !='') {
		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
   	focaliza(FORMULARIO+'.cbMarca');   
}

function validarCodCurso(){                               
	var num = get(FORMULARIO+'.txtCodCurso'); 
	if(num != ""){
		var val = allTrim(num);             
    	//Como no nos interesa validar el número de dígitos que tiene el 
    	//entero ponemos uno suficientemente grande. 
		if ((ValidaInt(val.toString(),10000, 0)!="OK")||(val.toString() < 0)) {
			GestionarMensaje('747', null, null, null);
			focaliza(FORMULARIO+'.txtCodCurso');
			return false;
		}
	}                               
} 
function allTrim(sStr){ 
         return rTrim(lTrim(sStr)); 
}
function lTrim(sStr){ 
         while (sStr.charAt(0) == " "){
                  sStr = sStr.substr(1, sStr.length - 1); 
         }
         return sStr; 
} 
function rTrim(sStr){ 
         while (sStr.charAt(sStr.length - 1) == " ") {
                  sStr = sStr.substr(0, sStr.length - 1); 
         }
         return sStr; 
}  
               


function onSeleccionaMarca (){

	var marca = get(FORMULARIO+'.cbMarca');
	var idioma = get(FORMULARIO+'.idioma');
	var pais = get(FORMULARIO+'.pais');
	
	var DTODruida ='es.indra.sicc.dtos.edu.DTODruidaBusqueda';
	if(marca != 0){
		recargaCombo(FORMULARIO+'.cbTipoCurso','CMNObtieneTiposCurso',DTODruida, [ ['oidMarca', marca],['oidIdioma',idioma],['oidPais',pais] ]); 
		focaliza(FORMULARIO+'.cbTipoCurso');
	} else{
		set_combo(FORMULARIO+'.cbTipoCurso',[['','']],['']);
		focaliza(FORMULARIO+'.cbMarca'); 
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
                                                          
function visibleLista(){                                 
	if (!get_visibilidad('capaLista')){             
	          visibilidad('capaLista','V');         
	}                                               
}                                                         
                                                          
function invisibleLista(){                               
          if (get_visibilidad('capaLista')){              
                    visibilidad('capaLista','O');         
          }                                               
}                                                       
function onClickBuscar(){ 
	var DTO = 'es.indra.sicc.dtos.edu.DTOConsultaCurso'; 
	var idioma = get(FORMULARIO+'.idioma');
	var pais = get(FORMULARIO+'.pais');
	var marca = get(FORMULARIO+'.cbMarca');
	var canal = get(FORMULARIO+'.cbCanal');
	var tipoCurso = get(FORMULARIO+'.cbTipoCurso');
	var codigo = get(FORMULARIO+'.txtCodCurso');
	var nombre = get(FORMULARIO+'.txtNombreCurso');
	configurarPaginado(mipgndo,'EDUBusquedaRegistrarCurso', 'ConectorConsultaRegistrarCurso',DTO,
				 [ ['oidIdioma',idioma], ['oidPais',pais], ['marca',marca], ['canal',canal], 
				 ['tipoCurso',tipoCurso], ['codigo',codigo],
				 ['nombre',nombre] ]); 
					 
}
                                            
function onClickParticipantes(){
	
	if (listado1.numSelecc() == 0){
        	// Muestra el mensaje: "Debe seleccionar un elemento de la lista"
        	GestionarMensaje('50');
	} else{
    	if (listado1.numSelecc() != 1 ){
         	//Muesta el mensaje: "Debe seleccionar un solo registro"
        	GestionarMensaje('8');
            //Se limpia la lista editable
            var seleccion=listado1.codigos();
            var i=0;
            while(seleccion[i]!=null){
              	listado1.deselecciona(i); 
               	i++;           
            }
		} else{     
        	var objParams = new Object();
            objParams.oidSeleccionado = listado1.codSeleccionados();
            mostrarModalSICC('LPParticipantes','', objParams, null, null);
        }           
        focaliza(FORMULARIO+'.cbMarca');
	}
}
                                                    
function compruebashtab(){                               
	if (get_visibilidad("capaLista")){              
	        document.all['Participantes'].focus();   
	}else{                                          
	        document.all['btnBuscar'].focus();      
	}                                               
}                                                         
function compruebatab(){                                 
	if (get_visibilidad("capaLista")){              
	        document.all['Participantes'].focus();   
	}else{                                          
	        focaliza(FORMULARIO+'.cbMarca');        
	}                                               
}                                                        