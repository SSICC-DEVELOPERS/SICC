


function onLoad(){
         configurarMenuSecundario('formulario');
         var accion = get('formulario.accion');
         var opcionMenu = get('formulario.opcionMenu');

		fMostrarMensajeError();

         if (accion == 'detalleModificar') {

			mostrarDatos();
            set('formulario.txtDescripcion',get('formulario.htxtDescripcion'));
            deshabilitarCombos();
            focaliza('formulario.txtDescripcion');

		 } else if (accion == 'detalle') {

            deshabilitarTodos();	
			mostrarDatos();
			set('formulario.txtDescripcion',get('formulario.htxtDescripcion'));
            
         } else if (accion == 'insertar') {		
                   focaliza('formulario.cbSubClasificacion');
         }
}

//------------------------------------------------------------------------------------------------------------

function asignarArrayAComboGen(datos, combo, oid){
	if( datos != null && datos.length > 0 ){
		
		var  arr = new Array();

        arr[arr.length] = new Array([''],['']);
        for (var i=0 ;i< datos.length ; i++)  {
            arr[arr.length] = datos[i];
        }

		set_combo('formulario.'+combo,arr);

		iSeleccionado = new Array(); 
		iSeleccionado[0] = oid;
		set('formulario.' + combo ,iSeleccionado); 
	}
}

function paramDTOOID(paramOid){
        var arr = new Array();
        arr[arr.length] = new Array("oid", get('formulario.' + paramOid));
        arr[arr.length] = new Array("oidPais", get('formulario.pais'));
		arr[arr.length] = new Array("oidIdioma", get('formulario.idioma'));
        return arr;
}


function mostrarDatos() {

	asignar([['COMBO','formulario.cbSubTipoCliente',
                          'ConectorDruidaTransactionQuery',
                          'dtoSalida.resultado_ROWSET',
                          formarCadenaDT('MAEobtenerSubtipos', 
										 'es.indra.sicc.util.DTOOID', 
										 paramDTOOID('hOidTipoCliente')),
						  'asignarArrayAComboGen(datos,"cbSubTipoCliente",get("formulario.hOidSubTipoCliente"))']]);	

	asignar([['COMBO','formulario.cbTipoClasificacion',
                          'ConectorDruidaTransactionQuery',
                          'dtoSalida.resultado_ROWSET',
                          formarCadenaDT('MAEobtenerTipoClasificacion', 
										 'es.indra.sicc.util.DTOOID', 
										 paramDTOOID('hOidSubTipoCliente')),
						  'asignarArrayAComboGen(datos,"cbTipoClasificacion",get("formulario.hOidTipoClasificacion"))']]);	

	asignar([['COMBO','formulario.cbClasificacion',
                          'ConectorDruidaTransactionQuery',
                          'dtoSalida.resultado_ROWSET',
                          formarCadenaDT('MAEobtenerClasificacionesPorTipo', 
										 'es.indra.sicc.util.DTOOID', 
										 paramDTOOID('hOidTipoClasificacion')),
						  'asignarArrayAComboGen(datos,"cbClasificacion",get("formulario.hOidClasificacion"))']]);	

    iSeleccionado1 = new Array(); 
    iSeleccionado1[0] = get('formulario.hOidSubClasificacion'); 
    set('formulario.cbSubClasificacion',iSeleccionado1); 

    iSeleccionado2 = new Array(); 
    iSeleccionado2[0] = get('formulario.hOidTipoCliente'); 
	set('formulario.cbTipoCliente',iSeleccionado2);
}

//------------------------------------------------------------------------------------------------------------

function deshabilitarTodos() {
	deshabilitarCombos();
	accion('formulario.txtDescripcion','.disabled = true');
}

function deshabilitarCombos() {
	accion('formulario.cbSubClasificacion','.disabled = true');
	accion('formulario.cbTipoCliente','.disabled = true');
	accion('formulario.cbSubTipoCliente','.disabled = true');
	accion('formulario.cbTipoClasificacion','.disabled = true');
	accion('formulario.cbClasificacion','.disabled = true');
}

//------------------------------------------------------------------------------------------------------------

function onTab(campoActual) {

         if (campoActual == 'cbSubClasificacion') {
                  focaliza('formulario.cbTipoCliente');
         } else if (campoActual == 'cbTipoCliente') {
                  focaliza('formulario.cbSubTipoCliente');
         } else if (campoActual == 'cbSubTipoCliente') {
                  focaliza('formulario.cbTipoClasificacion');
         } else if (campoActual == 'cbTipoClasificacion') {
                  focaliza('formulario.cbClasificacion');
         } else if (campoActual == 'cbClasificacion') {
                  focaliza('formulario.txtDescripcion');
         } else if (campoActual == 'txtDescripcion') {
                  if (get('formulario.opcionMenu') == 'insertarTipoClienteCom') {
                           focaliza('formulario.cbSubClasificacion');
                  } else {
                           focaliza('formulario.cbClasificacion');
                  }
         }          
}

function onShiftTab(campoActual) {
         if (campoActual == 'cbSubClasificacion') {
                  focaliza('formulario.txtDescripcion');
         } else if (campoActual == 'txtDescripcion') {
                  focaliza('formulario.cbClasificacion');
         } else if (campoActual == 'cbClasificacion') {
                  focaliza('formulario.cbTipoClasificacion');
         } else if (campoActual == 'cbTipoClasificacion') {
                  focaliza('formulario.cbSubTipoCliente');
         } else if (campoActual == 'cbSubTipoCliente') {
                  focaliza('formulario.cbTipoCliente');
         } else if (campoActual == 'cbTipoCliente') {
                  focaliza('formulario.cbSubClasificacion');
         } 
}

//------------------------------------------------------------------------------------------------------------
function cbTipoClienteOnChange() {
	recargaCombo('formulario.cbSubTipoCliente', 
	'MAEobtenerSubtipos', 
	'es.indra.sicc.util.DTOOID', 
	[["oid", get('formulario.cbTipoCliente')],
	 ["oidIdioma", get('formulario.idioma')],
	 ["oidPais", get('formulario.pais')]]);
}

function cbSubtipoClienteOnChange() {
	recargaCombo('formulario.cbTipoClasificacion', 
	'MAEobtenerTipoClasificacion', 
	'es.indra.sicc.util.DTOOID', 
	[["oid", get('formulario.cbSubTipoCliente')],
	 ["oidIdioma", get('formulario.idioma')],
	 ["oidPais", get('formulario.pais')]]);
}

function cbTipoClasificacionOnChange() {
	recargaCombo('formulario.cbClasificacion', 
	'MAEobtenerClasificacionesPorTipo', 
	'es.indra.sicc.util.DTOOID', 
	[["oid", get('formulario.cbTipoClasificacion')],
	 ["oidIdioma", get('formulario.idioma')],
	 ["oidPais", get('formulario.pais')]]);
}

//------------------------------------------------------------------------------------------------------------

function fGuardar() {

	if(!sicc_validaciones_generales()){
	  return false;
	}

	eval('formulario').oculto = "S";
	set('formulario.conectorAction','LPParamTipoClienteComDetalle');
	set('formulario.accion','guardar');
	enviaSICC('formulario');
}


function fLimpiar() {
	set('formulario.cbTipoCliente', '');
	set('formulario.cbSubClasificacion', '');
	set_combo('formulario.cbSubTipoCliente', [['','']],['']);
	set_combo('formulario.cbTipoClasificacion', [['','']],['']);
	set_combo('formulario.cbClasificacion', [['','']],['']);
	set('formulario.txtDescripcion', '');
	limpiaI18N('formulario', '1');
}

//------------------------------------------------------------------------------------------------------------

function guardoCorrectamente(opcion) {
	fLimpiar();
}

function noPudoGuardar() {
}

//------------------------------------------------------------------------------------------------------------

function fVolver() {
		window.returnValue = null; // Para que no actualice el LISTADO si no se 'guardó' correctamente.
		window.close();
}

