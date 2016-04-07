var FORMULARIO = "frmFormulario";
var codigoClienteValidado=false;
var clienteReasignado;
var aguardar = false;
var busquedaRapida = false;

function onLoadPag(){
	if (get(FORMULARIO+'.errDescripcion')!='') {
		var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'), get(FORMULARIO+'.errDescripcion'));
	}
	configurarMenuSecundario(FORMULARIO);
	completarValoresDefecto();
}


function completarValoresDefecto(){
	var params = window.dialogArguments.parametros.datosSeleccionados;
	clienteReasignado = params[2];
	set(FORMULARIO+".nroCupon",params[14]+"");
	set(FORMULARIO+".nroBoletaFactura",params[15]+"");
}


function buscarCliente(){
	var objParams = new Object();
	var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);
	if (cliente != null && cliente.length > 1) {
		set(FORMULARIO+'.codigoCliente', cliente[1].toString());
		set(FORMULARIO+'.oidClienteReceptor', cliente[0].toString());
		//concatenamos el nombre para asignar al label
		txt_labelCliente(cliente[2] +" "+ cliente[3] +" "+ cliente[4] +" "+ cliente[5], "350px");
		codigoClienteValidado = true;
	}
}

function fLimpiar() {
	set(FORMULARIO+".codigoCliente","");
	completarValoresDefecto();
	set(FORMULARIO+".observaciones","");
	txt_labelCliente("");
}

function fGuardar(){
	if(busquedaRapida) {aguardar=true;return;} else {aguardar=false;}
	if(!sicc_validaciones_generales()){return;}
	if(!codigoClienteValidado){
			GestionarMensaje("UICAL0003");
			foco(FORMULARIO+'.codigoCliente');
			return;
	}
	if(get(FORMULARIO+'.codigoCliente') == clienteReasignado) {
		GestionarMensaje("UICCC0038");
		set(FORMULARIO+'.codigoCliente',"");
		txt_labelCliente("");
		foco(FORMULARIO+'.codigoCliente');
		return;
	}
	//guardamos las variables que necesitamos de la pantalla principal,
	//que se reduce al oid de movimiento bancario seleccionado.
	set(FORMULARIO+".oidMovimientoReasignar", window.dialogArguments.parametros.datosSeleccionados[0]);
	set(FORMULARIO+".conectorAction","LPReasignacionPagos");
	set(FORMULARIO+".accion","reasignar");
	eval(FORMULARIO).oculto = 'S';
	enviaSICC(FORMULARIO);
}

function fVolver(){
	window.returnValue = false;
	window.close();
}

function salidaExito(){
	window.returnValue = true;
	window.close();
}

function completarCodigoCliente(){
	var codigoActual = get(FORMULARIO +'.codigoCliente');
	txt_labelCliente("");
	if((codigoActual+"")==""){return;}

	var longitud = get(FORMULARIO +'.longitudCodigo');
	if(isNaN(parseInt(longitud,10))){return;}
	longitud = new Number(longitud);//forzamos la conversion a numero
	var largoActual = codigoActual.length;

	if(largoActual != longitud){
		var salida = "";
		for(var i=0; i<longitud;i++){
			if(i+largoActual<longitud){
				salida = salida+"0";
			}else{
				salida = (salida+"")+(codigoActual+"");
				break;
			}
		}
		set(FORMULARIO+'.codigoCliente',salida);
	}

	busquedaRapida=true;
	buscarClientePorCodigo(get(FORMULARIO+'.codigoCliente'));
	
	return true;
}

function buscarClientePorCodigo(codigo){
	//esta funcion busca el nombre del cliente 
	//segun el codigo del parametro
	var arr = new Array();
	arr[arr.length] = new Array("codigoCliente", codigo+"");
    arr[arr.length] = new Array("oidPais", get(FORMULARIO+'.pais'));
    arr[arr.length] = new Array("oidIdioma", get(FORMULARIO+'.idioma'));

	recargaCombo("DUMMY", "MAEBusquedaRapidaNombresCliente","es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente", 
		arr,"evaluarNombreCliente(datos)");    
}

function evaluarNombreCliente(datos){
	if(datos.length>0) {
		txt_labelCliente(datos[0][1], "350px");
		set(FORMULARIO+'.oidClienteReceptor', datos[0][0]);
	}

	busquedaRapida=false;
	if(aguardar){fGuardar();}

	return false;
}

function txt_labelCliente(texto, ancho){
	codigoClienteValidado = !(texto=="");
	txt_to('lblNombreCliente',texto);
	if(ancho){
		document.all.tags("SPAN")[0].style.width=ancho;
	}
}
