/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
var FORMULARIO = 'formulario';

function onLoadPag() {
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
    if(errDescripcion != ''){
         var errCodigo = get(FORMULARIO +'.errCodigo');
         var wnd = fMostrarMensajeError(errCodigo,errDescripcion);
    }

	configurarMenuSecundario(FORMULARIO);
	focaliza('formulario.cbMarca');	
}
function accionActualizarStock(){	
	if(sicc_validaciones_generales()){
	
		set(FORMULARIO+'.accion','actualizar');
		set(FORMULARIO+'.conectorAction','LPActualizarStockMinimo');
	        enviaSICC(FORMULARIO);
	        
	}
	}
function marcaOnChange() {
          //recargamos el de accesos a partir de las listas ocultas
          var marca =get(FORMULARIO + '.cbMarca');
          var pais =get(FORMULARIO + '.pais');
          var canal =get(FORMULARIO + '.canal');
          if (marca != "") {
                   recargaCombo(FORMULARIO+'.cbPeriodo', 'CRAObtienePeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', [[ 'pais', pais ], ['marca', marca], ['canal', canal]] );                                    
          			focaliza(FORMULARIO +'.cbMarca');
          } else {
                   vaciarCombos();            
          }	
}
function vaciarCombos(){
	set_combo(FORMULARIO + '.cbPeriodo',[['',''],['']]);
}
function fLimpiar(){
	vaciarCombos();	
	focaliza(FORMULARIO +'.cbMarca');
}

function Correcto(){
	vaciarCombos();
	set(FORMULARIO+'.cbMarca', ['']);	
}