// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function init() {	
	configurarMenuSecundario("formulario");  
	
  
	var valor = get("formulario.valorMenu");
	if (valor =="no"){
		btnProxy(1, 0);
	}

    guardarKO();
	finCargaPagina = true;
  
   var menu = get("formulario.opcionMenu");   
  
  //Modificado por Paola C.  
  // if(menu =="Consultar Concurso"){
    btnProxy(4, 0);
     if (menu == "Consultar Concurso Ranking"){  
     
        /// Modificado dado que de esta manera, no se puede consultar
        /// un producto
        
		// accion("formulario.cbProductos", ".disabled=true");   
		 //deshabilitarHabilitarBoton('botonContenido','btnAceptar','D');
		 btnProxy(1, 0);
         btnProxy(2, 1);
         btnProxy(4, 0);
		 btnProxy(5, 0);
         btnProxy(7, 0);
         btnProxy(8, 0);
   }
   
   if((menu == "Modificar Concurso Ranking")){
        btnProxy(2, 1);
        btnProxy(7, 0);
        btnProxy(8, 0);
        btnProxy(9, 0);
    
    }

	//Si la pagina se esta abriendo en una modal, se ocultan las pestanyas
	if (get('formulario.ocultarPestanyas') == 'S'){
		document.getElementById('tblPestanyas1').style.display='none';
		document.getElementById('tblPestanyas2').style.display='none';
	}

}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function accionAceptar() {
		var seleccionCombo = get("formulario.cbProductos");
		var menu = get("formulario.opcionMenu");   

		if ( sicc_validaciones_generales("combo") )
		{
			// Obtiene la desc. del elemento del combo. 
			var descCombo = get("formulario.cbProductos", "T"); 
			var entroAModal = get("formulario.yaEntroAModal");

			var params = new Object();
			params.oidCombo = seleccionCombo;
			params.descCombo = descCombo;
			params.yaEntroAModal = entroAModal;
			params.opcionMenu = menu;

			this.mostrarModalSICC('LPMantenerProductosRanking', 'mantener', params);

			// Setea indicador que ya entró a la modal (de forma de poder, la proxima vez, tomar el DTO copia de sesión
			//  en lugar del original.
			set("formulario.yaEntroAModal", "SI");
		}
}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Marcelo J. Maidana -- 16/06/2005
function onClickPestanyaHabilitadaSS(valor, form, nombreLP){
    //Esta funcion condiciona el cambio de pestanya dependiendo del estado de la 
    //pestanya en las siguientes:

    //PESTANYA_PARAMETROS_GERENTES_RANKING      3
    //PESTANYA_PARAMETROS_CONSULTORAS_RANKING   4
    //PESTANYA_VARIABLES_VENTA_RANKING          7

    switch (valor){
        case 3:
            if (get(form + '.hIndEstadoParametrosGerentes')=='S'){
                onClickPestanyaSS(valor, form, nombreLP);
            }
            break;
        case 4:
            if (get(form + '.hIndEstadoParametrosConsultoras')=='S'){
                onClickPestanyaSS(valor, form, nombreLP);
            }
            break;
        case 7:
            if (get(form + '.hIndEstadoVariablesVenta')=='S'){
                onClickPestanyaSS(valor, form, nombreLP);
            }
            break;
        default:
            onClickPestanyaSS(valor, form, nombreLP);
    }
}


// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onClickPestanyaSS(valor, form, nombreLP) {
  eval("formulario").oculto = "N";
	set(form + '.conectorAction', nombreLP);
    set(form + '.accion', 'redirigir');
    set(form + '.idPestanyaDest', valor);
    enviaSICC(form, null, null, 'N');
}


// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fGuardar() {
	eval("formulario").oculto = "S";
	set("formulario.accion", "guardar");
	set("formulario.conectorAction", "LPMantenerProductosRanking");
  
  //--se modifica el enviaSiCC--
	enviaSICC("formulario", "", "", "N");
}


// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function guardarKO(){
    if(get('formulario.opcionMenu')=="Modificar Concurso Ranking"){  
          btnProxy(1,1);
          btnProxy(2,1);
          btnProxy(3,0);
          btnProxy(4,0);
          btnProxy(5,1);
          btnProxy(7,0);
          btnProxy(8,0);
          btnProxy(9,0);
          
          focaliza('formulario.cbProductos');
          
      } else {
          focaliza('formulario.cbProductos');
      }
}


function fLimpiar() {
    set("formulario.cbProductos", '' );
    focaliza('formulario.cbProductos');
}

function fVolver(){
  window.close();
}

