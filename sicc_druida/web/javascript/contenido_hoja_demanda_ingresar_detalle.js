var FORMULARIO = "formularios";
var comboDisabled = true;

function onLoadPag(){
	var errDescripcion = get(FORMULARIO +'.errDescripcion');
    if(errDescripcion != ''){
    	var errCodigo = get(FORMULARIO +'.errCodigo');
    	var wnd = fMostrarMensajeError(errCodigo,errDescripcion);
    }
    if(get(FORMULARIO +'.casoUso') == "añadir"){
    	set(FORMULARIO+'.cbFlagActuacion', ['03']);
    	set(FORMULARIO +'.oidActuacion',get(FORMULARIO +'.cbFlagActuacion','T'));
    	accion(FORMULARIO+'.cbFlagActuacion','.disabled=true');
    	comboDisabled = false;	
    }
    if(get(FORMULARIO +'.casoUso') == "modificar"){
    	var unidaConfir = get(FORMULARIO +'.unidConfir');
    	var unidaAtendi = get(FORMULARIO +'.txtUnidadesAtendidas');
      if(unidaConfir.length > unidaAtendi.length){

        while(unidaConfir.length > unidaAtendi.length){          
          unidaAtendi = "0" + unidaAtendi;          
        }

      }else if (unidaConfir.length < unidaAtendi.length){

          while(unidaConfir.length < unidaAtendi.length){          
            unidaConfir = "0" + unidaConfir;          
          }      
      }

    	if(unidaConfir == unidaAtendi){
    		set(FORMULARIO+'.cbFlagActuacion', ['00']);
    		set(FORMULARIO +'.oidActuacion',get(FORMULARIO +'.cbFlagActuacion','T'));
    		accion(FORMULARIO+'.cbFlagActuacion','.disabled=true');	
    		comboDisabled = false;
    	}else if(unidaConfir > unidaAtendi){
    		set(FORMULARIO+'.cbFlagActuacion', ['01']);
    		set(FORMULARIO +'.oidActuacion',get(FORMULARIO +'.cbFlagActuacion','T'));
    		accion(FORMULARIO+'.cbFlagActuacion','.disabled=true');	
    		comboDisabled = false;
    	}else{
    		set_combo(FORMULARIO +'.cbFlagActuacion',[['',''],['02','3'],['03','4']],['','']);
    	}
    }
    
    configurarMenuSecundario(FORMULARIO);
    
    focaliza(FORMULARIO +'.txtCodigoProducto');
}

function accionAceptar(){
	if (sicc_validaciones_generales()) {
		set(FORMULARIO + '.accion','guardarLineaDetalle');
    	set(FORMULARIO + '.conectorAction',"LPIngresoFisicoHojaDemanda");
		var arr = new Array();
		var repetido = 0;
		codigoProducto = get(FORMULARIO +'.txtCodigoProducto');
		arr = get(FORMULARIO + ".hArrCodigosProductos").split('#');

		for (i = 1; i < arr.length; i++)  
		{
			var filaCod = arr[i];	    
			if (filaCod == codigoProducto) {
				repetido = 1;
			    GestionarMensaje('UIBEL0013');
				break;				
			}    
		}
		if (repetido != 1)
		{
			enviaSICC(FORMULARIO);
		}else {
				setTimeout("focaliza(FORMULARIO +'.txtCodigoProducto')",1);	
    			set(FORMULARIO +'.txtCodigoProducto','');
				txt_to('lbldtDescripcionProducto','');		
		}
    }
}

function codigoProductoOnChange(){
	var codigo = get(FORMULARIO +'.txtCodigoProducto');
	set(FORMULARIO +'.txtCodigoProducto',codigo.toUpperCase());
	if (sicc_validaciones_generales("grupo1")) {
		set(FORMULARIO + '.accion','buscarProducto');
    	set(FORMULARIO + '.conectorAction',"LPIngresoFisicoHojaDemanda");
    	enviaSICC(FORMULARIO,null,null,'N');
    }
}

function errorProducto(){
	txt_to('lbldtDescripcionProducto','');
	set(FORMULARIO +'.txtCodigoProducto','');
	focaliza(FORMULARIO +'.txtCodigoProducto');
}

function fVolver(){
	window.close();	
}

function focoshboton(){
	if(!comboDisabled){
		focaliza(FORMULARIO +'.txtUnidadesAtendidas');
	}else{
		focaliza(FORMULARIO +'.cbFlagActuacion');
	}
}

function focotabboton(){
	focaliza(FORMULARIO +'.txtCodigoProducto');	
}

function focoshcodigo(){
	document.all['btnAceptar'].focus();
}

function onChangeFlag(){
	set(FORMULARIO +'.oidActuacion',get(FORMULARIO +'.cbFlagActuacion','T'));	
}

function cerrarVentana(){
	window.close();	
}

function cargaDescrip(datos,oid){
	txt_to('lbldtDescripcionProducto',datos);
	set(FORMULARIO +'.oidProducto',oid);
	focaliza(FORMULARIO +'.txtUnidadesAtendidas');
}




function validarUnidades(){
	var unidades = get(FORMULARIO +'.txtUnidadesAtendidas');
	var separadorMiles = get(FORMULARIO + '.hid_SeparadorMiles');
	if(unidades != ""){
		if(ValidaInt(unidades.toString(),10000, 0)!="OK"){
			//Las Unidades Atendidas deben ser un número entero mayor que cero
			GestionarMensaje('1460');
			//GestionarMensaje('50');
			setTimeout("focaliza(FORMULARIO +'.txtUnidadesAtendidas')",1);	
			set(FORMULARIO +'.txtUnidadesAtendidas','');
		}
	}
}

function fLimpiar(){
	if(!comboDisabled){
		if(get(FORMULARIO +'.casoUso') == "añadir"){
    		set(FORMULARIO+'.cbFlagActuacion', ['03']);
    		set(FORMULARIO+'.oidActuacion', "4");
    	}
    	if(get(FORMULARIO +'.casoUso') == "modificar"){
    		var unidaConfir = get(FORMULARIO +'.unidConfir');
    		var unidaAtendi = get(FORMULARIO +'.txtUnidadesAtendidas');
    		if(unidaConfir == unidaAtendi){
    			set(FORMULARIO+'.cbFlagActuacion', ['00']);	
    			set(FORMULARIO+'.oidActuacion', "1");
    		}else if(unidaConfir > unidaAtendi){
    			set(FORMULARIO+'.cbFlagActuacion', ['01']);
    			set(FORMULARIO+'.oidActuacion', "2");
    		}
    	}
	}
	focaliza(FORMULARIO +'.txtCodigoProducto');
}
