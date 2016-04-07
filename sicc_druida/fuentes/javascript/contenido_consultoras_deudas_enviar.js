var FORMULARIO = "frmFormulario";
var tipoClienteSeleccionado = false;
var SubClieteSeleccionado = false;
var tipoClasificacionSeleccionado = false;
var SubClasificacionSeleccionado = false;

function onLoadPag(){
	
	
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
        if (errDescripcion !='') {
        	var errCodigo = get(FORMULARIO+'.errCodigo');
                var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
        }
        configurarMenuSecundario(FORMULARIO);
    	focaliza(FORMULARIO+'.Descripcion');
         
}

function cerrarVentana(){
	var formulario = getFormularioSICC();
	set(formulario+".conectorAction","LPInicioBelcorp");
	set(formulario+".accion","");
	try{
		//parent.frames['menu'].location.reload();
		parent.frames["iconos"].mostrarCapa();
	}catch(e){}
	eval(formulario).oculto = 'N';
	enviaSICC(formulario,'','','N');
}


function fLimpiar() {
	 fLimpiarGenericoSICC();
         //vaciaCombo(FORMULARIO + '.cbEmpresa');
         set(FORMULARIO + '.cbEmpresa',['']);
         //vaciaCombo(FORMULARIO + '.cbRegion');
         set(FORMULARIO+'.cbRegion',['']);  
         vaciaCombo(FORMULARIO + '.cbZona');
         //vaciaCombo(FORMULARIO + '.cbTipoCliente');
         set(FORMULARIO+'.cbTipoCliente',['']);  
         vaciaCombo(FORMULARIO + '.cbSubtipocliente');
         vaciaCombo(FORMULARIO + '.cbTipoClasificacion');
         vaciaCombo(FORMULARIO + '.cbClasificacion');

         set(FORMULARIO+'.ConsultorasDeudas','N');
         set(FORMULARIO+'.DeudaPendiente','Y');
	 set(FORMULARIO+'.ckConsultora', get(FORMULARIO+'.ConsultorasDeudas'));
	 set(FORMULARIO+'.ckMovimientos', get(FORMULARIO+'.DeudaPendiente'));
         
         set(FORMULARIO+'.areatxtObservaciones','');
         focaliza(FORMULARIO + ".Descripcion");         
}

function onChangeRegion(){
	//Carga el control lstZona utilizando el array listaZonas 
	//y los oids de los valores seleccionados en lstRegion 
	vaciaCombo(FORMULARIO+'.cbZona');
	
	var regionesSeleccionadas = new String(get(FORMULARIO+'.cbRegion'));
        var listaTemporal = regionesSeleccionadas.split(",");
        var zonas = new Array();
        zonas[0] = ['',''];
        
        if (listaTemporal.length == 1 && listaTemporal[0] == '') { // lstRegiones no tiene selecciones, se toman todas (Requisitos generales)
        	
        	for(j=0; j<listaZonas.length; j++){
        		zonas[zonas.length] = [listaZonas[j][0],listaZonas[j][2]];
        	} 
                           
        }else{
        	for (i=0; i<listaTemporal.length; i++){
        		var region = listaTemporal[i];
        		
        		if(typeof(listaZonas) != 'undefined'){
        			for(k=0;k<listaZonas.length;k++){
        				
        				if(listaZonas[k][1] == region){
        					zonas[zonas.length] = [listaZonas[k][0],listaZonas[k][2]];
        					
        				}
        			
        			}
        		}
        	}
        }
        set_combo(FORMULARIO+'.cbZona',zonas,['']);
        
}

function onChangeTipoCliente(){
	//Carga el control lstSubtipoCliente utilizando el array listaSubtipos y
	// los oids de los valores seleccionados en lstTipoCliente 
	//Limpia el control lstTipoClasificacion 
	//Limpia el control lstClasificacionCliente 
	
	tipoClienteSeleccionado = true;
	
	
	vaciaCombo(FORMULARIO+'.cbSubtipocliente');
	var tiposCliente = new String(get(FORMULARIO+'.cbTipoCliente'));
        var listaTemporal = tiposCliente.split(",");
        
        var subTipos = new Array();
        subTipos[0] = ['',''];
        
        if (listaTemporal.length == 1 && listaTemporal[0] == '') { // lstTipocliente no tiene selecciones, se toman todas (Requisitos generales)
        	
        	for(j=0; j<listaSubtipos.length; j++){
        		subTipos[subTipos.length] = [listaSubtipos[j][0],listaSubtipos[j][2]];
        	} 
                           
        }else{
        	for (i=0; i<listaTemporal.length; i++){
        		var tipoCliente = listaTemporal[i];
        		
        		if(typeof(listaSubtipos) != 'undefined'){
        			
        			for(k=0;k<listaSubtipos.length;k++){
        				
        				
        				
        				if(listaSubtipos[k][1] == tipoCliente){
        					subTipos[subTipos.length] = [listaSubtipos[k][0],listaSubtipos[k][2]];
        				}
        			
        			}
        		}
        	}
        }
        set_combo(FORMULARIO+'.cbSubtipocliente',subTipos,['']);
        vaciaCombo(FORMULARIO+'.cbTipoClasificacion');
        vaciaCombo(FORMULARIO+'.cbClasificacion');
}


function onChangeSubtipoCliente(){

	//Carga el control lstTipoClasificacion utilizando el array listaTiposClasificacion y 
	//los oids de los valores seleccionados en lstSubtipoCliente 
	//Limpia el control lstClasificacionCliente 
	SubClieteSeleccionado = true;


	vaciaCombo(FORMULARIO+'.cbTipoClasificacion');
	vaciaCombo(FORMULARIO+'.cbClasificacion');
	
	
	var subTiposCliente = new String(get(FORMULARIO+'.cbSubtipocliente'));
        var listaTemporal = subTiposCliente.split(",");
        var tiposClasificacion = new Array();
        tiposClasificacion[0] = ['',''];
        if (listaTemporal.length == 1 && listaTemporal[0] == '') { // lstSubtipoCliente no tiene selecciones, se toman todas (Requisitos generales)
        	
        	for(j=0; j<listaTiposClasificacion.length; j++){
        		tiposClasificacion[tiposClasificacion.length] = [listaTiposClasificacion[j][0],listaTiposClasificacion[j][2]];
        	} 
                           
        }else{
        	for (i=0; i<listaTemporal.length; i++){
        		var subTipoCl = listaTemporal[i];
        		if(typeof(listaTiposClasificacion) != 'undefined'){
        			for(k=0;k<listaTiposClasificacion.length;k++){
        				if(listaTiposClasificacion[k][1] == subTipoCl){
        					tiposClasificacion[tiposClasificacion.length] = [listaTiposClasificacion[k][0],listaTiposClasificacion[k][2]];
        				}
        			
        			}
        		}
        	}
        }
        set_combo(FORMULARIO+'.cbTipoClasificacion',tiposClasificacion,['']);
        
        vaciaCombo(FORMULARIO+'.cbClasificacion');

}
function onChangeTipoClasificacion(){

	tipoClasificacionSeleccionado = true;
	
	
	//Carga el control lstClasificacionCliente utilizando el array listaSClasificacionCliente y 
	//los oids de los valores seleccionados en lstTipoClasificacion 
	var tiposClasificacion = new String(get(FORMULARIO+'.cbTipoClasificacion'));
        var listaTemporal = tiposClasificacion.split(",");
        var clasificacion = new Array();
        clasificacion[0] = ['',''];
        if (listaTemporal.length == 1 && listaTemporal[0] == '') { // lstTiposClasificacion no tiene selecciones, se toman todas (Requisitos generales)
        	
        	for(j=0; j<listaClasificacionCliente.length; j++){
        		clasificacion[clasificacion.length] = [listaClasificacionCliente[j][0],listaClasificacionCliente[j][2]];
        	} 
                           
        }else{
        	for (i=0; i<listaTemporal.length; i++){
        		var tipoClasif = listaTemporal[i];
        		if(typeof(listaClasificacionCliente) != 'undefined'){
        			for(k=0;k<listaClasificacionCliente.length;k++){
        				if(listaClasificacionCliente[k][1] == tipoClasif){
        					clasificacion[clasificacion.length] = [listaClasificacionCliente[k][0],listaClasificacionCliente[k][2]];
        				}
        			
        			}
        		}
        	}
        }
        set_combo(FORMULARIO+'.cbClasificacion',clasificacion,['']);
}

function vaciaCombo(combo) {
         set_combo(combo,[['','']],['']);
}

function onClickEnviar(){
	var lista = '';
	
	if(sicc_validaciones_generales()){
		set(FORMULARIO+'.descripcionLote', get(FORMULARIO+'.Descripcion'));
		set(FORMULARIO+'.fechaDesde', get(FORMULARIO+'.FechaDesde'));
		set(FORMULARIO+'.fechaHasta', get(FORMULARIO+'.FechaHasta'));
		set(FORMULARIO+'.observaciones', get(FORMULARIO+'.areatxtObservaciones'));
		var empresas = new String(get(FORMULARIO+'.cbEmpresa'));
		set(FORMULARIO+'.empresa',empresas);
		var regiones = new String(get(FORMULARIO+'.cbRegion'));
        	set(FORMULARIO+'.regiones',regiones);
        	var zonas = new String(get(FORMULARIO+'.cbZona'));
        	set(FORMULARIO+'.zonas', zonas);	
        	        	
        	var tiposCliente = new String(get(FORMULARIO+'.cbTipoCliente'));
        	lista =tiposCliente.split(",");
        	if (lista.length == 1 && lista[0] == '') { 
			var todosTiposCliente = document.all['cbTipoCliente'][0].options;
        	        set(FORMULARIO+'.tiposCliente',obtenerCadena(todosTiposCliente)); 
        	} else{
			set(FORMULARIO+'.tiposCliente',tiposCliente);
		}                         
		
		var subTiposCliente = new String(get(FORMULARIO+'.cbSubtipocliente'));
		lista = subTiposCliente.split(",");
		if (lista.length == 1 && lista[0] == '' && tipoClienteSeleccionado==true ) { 
			var todosSubTiposCliente = document.all['cbSubtipocliente'][0].options;
        	        set(FORMULARIO+'.subTiposCliente',obtenerCadena(todosSubTiposCliente)); 
        	} else{
			set(FORMULARIO+'.subTiposCliente',subTiposCliente);
		}        
			
		if(get(FORMULARIO+'.cbTipoClasificacion') != ''){
		var tiposClasificacion = new String(get(FORMULARIO+'.cbTipoClasificacion'));
			lista = tiposClasificacion.split(",");
			if (lista.length == 1 && lista[0] == '' && SubClieteSeleccionado==true ) { 
				var todosTiposClasificacion = document.all['cbTipoClasificacion'][0].options;
						set(FORMULARIO+'.tiposClasificacion',obtenerCadena(todosTiposClasificacion)); 
				} else{
				set(FORMULARIO+'.tiposClasificacion',tiposClasificacion);
			}  
		}
        
		if(get(FORMULARIO+'.cbClasificacion') != ''){
			var clasificaciones = new String(get(FORMULARIO+'.cbClasificacion')); 
			lista = clasificaciones.split(",");
			if (lista.length == 1 && lista[0] == '' && tipoClasificacionSeleccionado==true ) { 
				var todasClasificacion = document.all['cbClasificacion'][0].options;
						set(FORMULARIO+'.clasificaciones',obtenerCadena(todasClasificacion)); 
				} else{
				set(FORMULARIO+'.clasificaciones',clasificaciones);
			}  
		}
				
		set(FORMULARIO+'.ckConsultora', get(FORMULARIO+'.ConsultorasDeudas'));
		set(FORMULARIO+'.ckMovimientos', get(FORMULARIO+'.DeudaPendiente'));
        	
		if(comprobarDatos()){ 
			//Envia el formulario oculto 
			set(FORMULARIO+'.accion','enviar');
        	        set(FORMULARIO+'.conectorAction','LPEnviarConsultorasDeudasMovsDeudaPdte');            
        	        enviaSICC(FORMULARIO);
        	} else{
			cdos_mostrarAlert(GestionarMensaje('1457'));	
		}
	}        
}

function obtenerCadena(lista){	
	
	var salida = '';
	ponerSeparador = false;
        for (i=0; i<lista.length; i++) {
        	if (lista[i].value != '') {
                	if (ponerSeparador) {
                        	salida += ',';
                        }
                        if (!ponerSeparador) {
                        	ponerSeparador = true;
                        }
                        salida += lista[i].value;
                }
	}
	return salida;
}
	
                 





function comprobarFecha(txtFecha){
         var fecha = get(FORMULARIO+'.'+txtFecha);
         if(fecha != ""){
         var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
                  if(resul==1 || resul==2){  
                  GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
                           focaliza(FORMULARIO+'.'+txtFecha);
                           return ;
         }
    }
}

function desplazarOnTab(){
         focaliza(FORMULARIO+'.Descripcion');
}

function desplazarOnShTab(){
         document.all["btnEnviar"].focus();
}

function comprobarDatos(){
	
	fechaHasta = get(FORMULARIO+'.FechaHasta');
	fechaDesde = get(FORMULARIO+'.FechaDesde');
	var aux = EsFechaValida(fechaDesde,fechaHasta,FORMULARIO,null);
	// EsFechaValida devuelve un 3 si fechaDesde es mayor que fechaHasta
	
	if(aux == 3){
		return false;
	} else{
		return true;
	}
}

