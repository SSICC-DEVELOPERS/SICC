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
    $Id: contenido_cursos_participacion.js,v 1.1 2009/12/03 19:02:21 pecbazalar Exp $
    DESC
*/

var FORMULARIO = 'formulario';

function onLoadPag(){ 
	DrdEnsanchaConMargenDcho('listado1',12);
	var DTO ='es.indra.sicc.dtos.edu.DTOOIDCurso';
	var idioma = get(FORMULARIO+'.idioma');
	var pais = get(FORMULARIO+'.pais');
	var oidCurso = get(FORMULARIO+'.oidCurso');
	configurarPaginado(mipgndo, 'EDUBusquedaParticipantes', 'ConectorConsultaParticipantes', DTO, [ ['oidIdioma',idioma], ['oidPais',pais], ['oid',oidCurso] ] ); 
	configurarMenuSecundario(FORMULARIO); 
			
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
	 
	var errDescripcion = get(FORMULARIO+'.errDescripcion');
	if (errDescripcion !='') {
		var errCodigo = get(FORMULARIO+'.errCodigo');
		var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
}	

function onClickAceptar(){
/* modificado por Noziglia C.
 * fecha 22/08/2005
 * incidencia: BELC300019688
 */
	var lista = "";
   	listado1.actualizaDat(); //Actualiza el array 'datos'
   	datosFinal = listado1.datos;
	for (var i = 0; i < listado1.datos.length; i++) {

		var fila = datosFinal[i];
        if(!fila[6]==""){
		//alert("este lo guardo");
			for (k = 0; k < fila.length; k++) { 
				if(fila[k] == "") { 
       				fila[k] = "-";
           		}
			}
			lista += fila[0] + "@" + fila[6] + "@" + fila[9] + "@" + fila[10] + "#";
		}
	} 

    //alert('lista quitar este alert = '+lista);
    set(FORMULARIO+'.lista', lista);
	set(FORMULARIO+'.conectorAction','LPParticipantes');
	set(FORMULARIO+'.accion','Registrar');
	enviaSICC(FORMULARIO);
	
}

function insercionCorrecta(){
	//cerramos la ventana
    window.close();	
}
function fVolver(){
	//cerramos la ventana
    window.close();		
}
function fLimpiar(){ 
	listado1.actualizaDat();
    var datosFinal = listado1.datos;
    for (i = 0; i < datosFinal.length; i++) {
    	datosFinal[i][6] = ''; 
    }
    listado1.reajusta();
    mandaElFoco(0);
    
}

function validaFormularioOnBlur(fila){
    validaFecha(fila);
    	
}

function validaFecha(numFila) {
	var resul = 0;
	var fecha = "";
	listado1.actualizaDat();
	datosFinal = listado1.datos;
	var fila = datosFinal[numFila];
	fecha=fila[6]; 
	if(fecha != ""){
		resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
		if(resul==1 || resul==2){  
        	GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
        	mandaElFoco(numFila);
        	return false;
        } else{
        	return true;
        }
    }	
}	

function mandaElFoco(fila){  // focaliza una caja de texto
   var nombrelistado="listado1"; 
   var nombreCajaText="txtFechaAsistencia"; 
   var indiceFila=fila;   //Empezando desde 0 
   eval(nombrelistado+".preparaCamposDR()"); 
   focaliza('frm'+nombrelistado+'.'+nombreCajaText+'_'+indiceFila,''); //Focalizo 
   
} 

function muestraLista( ultima, rowset){
	var tamano = rowset.length;
	if (tamano > 0) {
	        visibleLista(); 
	        return true;
	} else {
	        noVisibleLista();     
	        window.close();	
	        return false;
	}
}
function visibleLista(){                                 
	visibilidad('capaLista','V'); 
	DrdEnsanchaConMargenDcho('listado1',12);
    eval (ON_RSZ);  
	document.body.focus();
    setTimeout('listado1.form.txtFechaAsistencia_0.focus();var tr=listado1.form.txtFechaAsistencia_0.createTextRange();tr.execCommand("SelectAll");',5)     
}

function noVisibleLista() {
	visibilidad('capaLista','O');
}

/*function focalizaAnterior(FILAEVENTO, TECLAEVENTO){
	if (TECLAEVENTO == 9 && FILAEVENTO == 0) {
    	document.all['Aceptar'].focus();
    }
}*/
    
function focalizaSiguiente(FILAEVENTO, TECLAEVENTO){
           	if (FILAEVENTO == listado1.datos.length-1 && TECLAEVENTO == 9) {
           		document.body.focus();
           		setTimeout("document.all['Aceptar'].focus();",5);
           	}
}


function focalizaAnterior(FILAEVENTO, TECLAEVENTO){
         if (TECLAEVENTO == 9 && FILAEVENTO == 0) {
         	document.body.focus();
        	setTimeout("document.all['Aceptar'].focus();",5);
         }
}

                                   








