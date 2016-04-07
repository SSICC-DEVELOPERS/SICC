/*
    $Id: contenido_matriz_codigos_reemplazo_registrar.js,v 1.1 2009/12/03 19:01:29 pecbazalar Exp $
*/

var formName = 'frmFormulario.';
var formNameSinPunto = 'frmFormulario';
		
function fGuardar(){	
	if (get(formName + 'hidDatosReemp')=="S"){
		//alert("guardar");		
		cargarAccion("guardarMatriz", "S");
	}else{
		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoReemplazo');	
	}
}

function fLimpiar(){	
	cargarAccion("Matriz seleccionada", "N");
}

function inicializar(){
	//alert("menu :" + get(formName + 'SICC_TOOLBAR_CONFIG'));
	configurarMenuSecundario("frmFormulario");

	focalizaBotonHTML('botonContenido' ,'btnBuscarProductoActual');	

	if( !fMostrarMensajeError() ){
		if(get(formName + 'accion')=="Matriz seleccionada") {			
			accion(formName + 'cbReemplazo','.disabled=true');  
			accion(formName + 'ckEmitirMensaje','.disabled=true');    
			deshabilitarHabilitarBoton('botonContenido','btnBuscarProductoReemplazo','D')			
	    } else {
			deshabilitarHabilitarBoton('botonContenido','btnBuscarProductoReemplazo','A')			
			if(get(formName + 'hidDatosReemp')=="N") {
				//GestionarMensaje('1209',null,null,null);
				accion(formName + 'cbReemplazo','.disabled=true');  
				accion(formName + 'ckEmitirMensaje','.disabled=true');      
			} else if(get(formName + 'hidDatosReemp')=="S") {
				// Combo de Reeemplazo
				opciones = new Array();

                opciones[0] = [0, " "];	
				opciones[1] = [1, GestionarMensaje('1207')];
				opciones[2] = [2, GestionarMensaje('1208')];

				set_combo(formName + 'cbReemplazo',opciones); 

				iSeleccionado = new Array(); 

				iSeleccionado[0] = get(formName + 'hidReemAntesCuadre')==""?" ":get(formName + 'hidReemAntesCuadre');				
				set(formName + 'cbReemplazo',iSeleccionado);
					

				btnProxy(1,'1');
			}
	
		}
			accion('frmFormulario.rbRegion', '.checked=true');
			this.onClickRegion();
	}
}



function cargarAccion(accion, oculto){
//	alert('Acciono: ' + accion);
    eval(formNameSinPunto).oculto= oculto;
	//alert("oculto");
    set(formName + "conectorAction" ,"LPMantenimientoMatrizCodigosReemplazo"); 
	set(formName + 'accion', accion);
	enviaSICC(formNameSinPunto);	
}


function focalizaTab(componente) {  
	if (componente==1){
	
	   if(get(formName + 'accion')=="Matriz seleccionada") {
			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoActual');	
	   } else if ((get(formName + 'accion')=="productoPrincipalSeleccionado" || get(formName + 'accion')=="grupoProductosSeleccionado")
					&& get(formName + 'hidDatosReemp')=="S") {
			focaliza(formName + 'cbReemplazo','');  
	   } else if ((get(formName + 'accion')=="productoPrincipalSeleccionado" || get(formName + 'accion')=="grupoProductosSeleccionado")
					&& get(formName + 'hidDatosReemp')=="N") {
			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoReemplazo');
	   }  
	}else if (componente==2){
			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoActual');	
	}
}


function focalizaTabShift(componente) {    
    if (componente==1){
	
	   if(get(formName + 'accion')=="Matriz seleccionada") {
			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoActual');	
	   } else if (get(formName + 'accion')=="productoPrincipalSeleccionado" || get(formName + 'accion')=="grupoProductosSeleccionado"){				
			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoReemplazo');	
	   }
	}
}

	function onClickRegion(){
    	set('frmFormulario.cbRegion', '');
		set('frmFormulario.hZona', '');
		set('frmFormulario.hRegion', 'S');
		accion('frmFormulario.rbZona', '.checked=false');
		set('frmFormulario.cbZona', '');	
		accion('frmFormulario.cbZona', '.disabled=true');	
		accion('frmFormulario.cbRegion', '.disabled=false');
	}

	function onClickZona(){
		accion('frmFormulario.rbRegion', '.checked=false');
		set('frmFormulario.hZona', 'S');
		set('frmFormulario.hRegion', '');
		set('frmFormulario.cbRegion', '');
		accion('frmFormulario.cbRegion', '.disabled=true');
		accion('frmFormulario.cbZona', '.disabled=false');	
	}
	

	function tipoClienteOnChange(){

	  recargaCombo('frmFormulario.cbSubTipoCliente', 'MAEobtenerSubtipos', 'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbTipoCliente') ));

	  set_combo('frmFormulario.cbTipoClasificacion',new Array()); 
	  set_combo('frmFormulario.cbClasificacion',new Array()); 
	}

	function onChangeSubtipoCliente(){

	  recargaCombo('frmFormulario.cbTipoClasificacion', 'MAEobtenerTipoClasificacion', 
				   'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbSubTipoCliente')));
	  set_combo('frmFormulario.cbClasificacion',new Array()); 
	}

	function onChangeTipoClasificacion(){

	  recargaCombo('frmFormulario.cbClasificacion', 'MAEobtenerClasificacionesPorTipo', 
				   'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormulario.cbTipoClasificacion')));
	}





	
	
	function makeParameter(nombre, oid){

              var array = new Array();
              var i=0;
              array[i] = new Array('oidPais', get('frmFormulario.hPais') );
              i++;
              array[i] = new Array('oidIdioma', get('frmFormulario.hIdioma') );
              i++;
			  if(oid!=null){
		          array[i] = new Array(nombre,oid);              
			  }
              return array;
     }


	function focalizaTab(campo){  

		if(campo==1){
			if( cbSubTipoCliente.disabled == false )
				focaliza("frmFormulario.cbSubTipoCliente");
			else
				focoPrimerCampo();
		} else if(campo==2){
			if( cbTipoClasificacion.disabled == false )
				focaliza("frmFormulario.cbTipoClasificacion");
			else
				focoPrimerCampo();
		}else if(campo==3){
			if( cbClasificacion.disabled == false )
				focaliza("frmFormulario.cbClasificacion");
			else
				focoPrimerCampo();
		}else if(campo==4){
			focoPrimerCampo();
		}
   }

   function agregarBlanco(datos){  
	    datosBlanco = new Array();

		datosBlanco[0]= new Array("","");

		for(var i=0; i< datos.length; i++){		
              datosBlanco[i+1] = new Array(datos[i][0], datos[i][1]);
             
		}

		//alert(datosBlanco);
		return datosBlanco;
	}

	function arrayVacio(){  
		var array = new Array();             
        array[0] = new Array('','');

		return array;
	}