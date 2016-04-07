var FORMULARIO = 'formulario';

function onLoadPag(){  
          
    configurarMenuSecundario('formulario');

    recargaPeriodo();
    
    fMostrarMensajeError();

	focaliza(FORMULARIO + '.cbPeriodoInicialEvaluacion');
}


function recargaPeriodo() {

	var dtoPeriodo = [         
		                  ["pais", get(FORMULARIO + '.pais')],
		                  ["oidPais", get(FORMULARIO + '.pais')], 
		                  ["oidIdioma", get(FORMULARIO + '.idioma')],
		                  ["marca", get(FORMULARIO + '.hOidMarca')],
		                  ["canal", get(FORMULARIO + '.hOidCanal')]
				     		];

  
   recargaCombo(FORMULARIO + '.cbPeriodoInicialEvaluacion', 
				     'CRAObtenerPeriodos', 
				     'es.indra.sicc.dtos.cra.DTOPeriodo', 
				     dtoPeriodo 
				     );
   
 
}		

function cbPeriodoInicialEvaluacionOnChange() {
	  var periodoDesde = get(FORMULARIO + '.cbPeriodoInicialEvaluacion');  

	  if(periodoDesde!="") {
			recargaCombo(FORMULARIO + '.cbPeriodoFinalEvaluacion', 'CRAObtenerPeriodosPosterioresActivos', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArrayDTOPeriodoComboHasta());
	  }
	  else {
			 var array = new Array();
			 array[0] = ['', ''];    
			 set_combo(FORMULARIO + '.cbPeriodoFinalEvaluacion', array);           
	  }      
}

function armarArrayDTOPeriodoComboHasta(){
	   var pais = get(FORMULARIO + '.pais');
	   var marca = get(FORMULARIO + '.hOidMarca');
	   var canal = get(FORMULARIO + '.hOidCanal'); 
	   var periodoDesde = get(FORMULARIO + '.cbPeriodoInicialEvaluacion');

	   var array = new Array();
	   var index = 0;

	   if( pais != null && pais != '' ){
				 array[index] = new Array('pais', pais);
			index++;
	   }      

       if( marca != null && marca != '' ){
				 array[index] = new Array('marca', marca);
			index++;
	   }

	   if( canal != null && canal != '' ){
							array[index] = new Array('canal', canal);
			index++;
	   }

		if( periodoDesde != null && periodoDesde != '' ){
							array[index] = new Array('oid', periodoDesde);
			index++;
	   }

	   return array;
}



function btnAceptarOnClick() {

	 if(sicc_validaciones_generales("gAceptar")) {

		 eval('formulario').oculto = 'S';
		 set('formulario.conectorAction', 'LPIntroducirOrdenesChequeos');
		 set('formulario.accion', 'verificarChequeosDefinidosLineaCampo');
		 enviaSICC('formulario', null, null, 'N');
	 }

}


function fLimpiar() {

	set(FORMULARIO+'.cbPeriodoInicialEvaluacion','');
	vaciaCombo(FORMULARIO + '.cbPeriodoFinalEvaluacion');
}

function vaciaCombo(combo) {
	set_combo(combo, [['','']], ['']);	
}	

function btnCancelarOnClick() {

	 var retorno = new Array();
     retorno[0] = "CANCELAR";
    
     returnValue = retorno;
     close();
}

function fVolver() {
	window.close();
}

function ejecutarErrorVerificar() {
	  focaliza("formulario.cbPeriodoInicialEvaluacion");
}


function aniadirChequeo() {
	  window.close();
}

function focalizaCbPeriodoInicialEvaluacion() {
	  focaliza("formulario.cbPeriodoInicialEvaluacion");
}

function focalizaShTab(){
    focalizaBotonHTML('botonContenido','btnCancelar');
}
