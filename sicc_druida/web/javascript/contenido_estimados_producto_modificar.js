//array de elementos que pueden tener el foco con TAB/SHTAB
var elementos = new Array('cbCentroDistribucion','cbLineaArmado','cbMarca',
                'cbCanal', 'cbPeriodo', 'txtCodigoProducto', 'ChkFueraPedido' );

function onLoadPag() {
         var centroDefecto = get('formulario.hOidCentroDistribucionDefecto');
         set('formulario.cbCentroDistribucion', new Array(centroDefecto)); 
         onChangeCbCentroDistribucion();
         accion('formulario.cbPeriodo', '.disabled=true');
         configurarMenuSecundario('formulario');
         DrdEnsanchaConMargenDcho('listado1', 23);         
         invisibleLista();         
         eval (ON_RSZ); 
         fMostrarMensajeError();
         focaliza('formulario.cbCentroDistribucion');
}

/*--------------------------------------------------------------------------------------------------------*/
 function onChangeCbCentroDistribucion() {
        centroDistribucion = get('formulario.cbCentroDistribucion');
        if (centroDistribucion != '') {
                              var idioma = get('formulario.idioma');
                              recargaCombo(
                                         'formulario.cbLineaArmado',
                                         'APEObtenerLineasArmadoCD', 
                                         'es.indra.sicc.util.DTOOID',
                                         [["oid", centroDistribucion], ["oidIdioma", idioma]],
                                         'setearCbLineaArmado(datos)'
                              );
        }
     } 

//--------------------------------------------------------------------------------------------------------

function setearCbLineaArmado(datos) {
	var arrayNuevo = new Array();
	arrayNuevo[0] = new Array('','');
	arrayNuevo = arrayNuevo.concat(datos);
	set_combo('formulario.cbLineaArmado',arrayNuevo);

	/*Se agrega la seleccion de la linea por defecto */
	var longitudCombo = combo_get('formulario.cbLineaArmado', 'L');
	var oidsLineasDef = get('formulario.hOidsLineasArmadoDefecto').split('|');
	// Comienzo desde 1 para obviar la primera linea, que se que esta en blanco
	for (var i = 1; i < longitudCombo; i++) {
		var value = combo_get('formulario.cbLineaArmado', 'V', i);
		for (var j = 0; j < oidsLineasDef.length; j++) {
			if (value == oidsLineasDef[j]) {
				set('formulario.cbLineaArmado', new Array(value));
				// Salgo de los FOR anidados
				j = oidsLineasDef.length;
				i = longitudCombo;
			}
		}
	}
}

/*--------------------------------------------------------------------------------------------------------*/     
    function onChangeCbMarca(){
    	GestionarComboPeriodo();
    }

/*--------------------------------------------------------------------------------------------------------*/
    function onChangeCbCanal(){
    	GestionarComboPeriodo();
    }
/*--------------------------------------------------------------------------------------------------------*/
    function GestionarComboPeriodo(){
        if( get('formulario.cbMarca')=='' || get('formulario.cbCanal')=='' ){
    		if( combo_get('formulario.cbPeriodo', 'L') > 0 ){
                set_combo('formulario.cbPeriodo', arrayVacio());
            }
            accion('formulario.cbPeriodo', '.disabled=true');
        }else{
            accion('formulario.cbPeriodo', '.disabled=false');
            set_combo('formulario.cbPeriodo', arrayVacio());
            recargaComboPeriodo();
        }
    }

    function arrayVacio(){
    	var array = new Array();
    	array[0] = new Array('','');
    	return array;
    }

    function recargaComboPeriodo(){
    	recargaCombo('formulario.cbPeriodo', 'CRAObtenerPeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArrayDTOPeriodo(), 'asignaComboPeriodo(datos)');
    }

    function asignaComboPeriodo(datos){
    	if(datos.length > 0){
            asignarArrayACombo(datos);
            set_combo('formulario.cbPeriodo', datos);
            accion('formulario.cbPeriodo', '.disabled=false');
        }
    }

    function asignarArrayACombo(datos){
    	if( datos != null && datos.length > 0 ){
            //combo_add('formulario.cbPeriodo', '', '');
            for(i = 0; i < datos.length; i++){
    			combo_add('formulario.cbPeriodo', datos[i][0], datos[i][1]);
            }
        }
    }

    function armarArrayDTOPeriodo(){
        var marca = get('formulario.cbMarca');
        var canal = get('formulario.cbCanal');
        var array = new Array();
        var index = 0;
    
        if( marca != null && marca[0] != null && marca[0] != '' ){
            array[index] = new Array('marca', marca[0]);
            index++;
        }
    
        if( canal != null && canal[0] != null && canal[0] != '' ){
            array[index] = new Array('canal', canal[0]);
        index++;
        }
    
        var pais = get("formulario.pais");
        array[index] = ["pais", pais];
        return array;
    }


/*---------------------------------------------------------------------------------------------------------*/

function onClickDetalle() {
         elementosSeleccionados("detalle");
}      

function onClickModificar() {
         elementosSeleccionados("detalleModificar");
}          

function elementosSeleccionados(casoUsoSeleccionado) {
	var seleccionados = listado1.codSeleccionados();
	var cantSeleccionados = seleccionados.length;
	if (cantSeleccionados == 0) {
        GestionarMensaje("4", null, null, null);
		return false;
	}
	else if (casoUsoSeleccionado == "detalle" || casoUsoSeleccionado == "detalleModificar") {
		  if (cantSeleccionados == 1) {
					codigo = seleccionados[0];
					var objParams = new Object();
                    
					objParams.oidEstimado = seleccionados[0];
					objParams.hCbCentroDistribucion = listado1.extraeDato(codigo,0);
                    objParams.hDescCentroDistribucion = listado1.extraeDato(codigo,1);                    
					objParams.hCbLineaArmado = listado1.extraeDato(codigo,2);
                    objParams.hDescLineaArmado = listado1.extraeDato(codigo,3);                                        
					objParams.hCbMarca = listado1.extraeDato(codigo,4);
                    objParams.hDescMarca = listado1.extraeDato(codigo,5);
					objParams.hCbCanal = listado1.extraeDato(codigo,6);
                    objParams.hDescCanal = listado1.extraeDato(codigo,7);
					objParams.hCbPeriodo = listado1.extraeDato(codigo,8);
                    objParams.hDescPeriodo = listado1.extraeDato(codigo,9);
					objParams.txtCodigoProducto = listado1.extraeDato(codigo,10);
					objParams.txtDesProducto = listado1.extraeDato(codigo,11);
                    objParams.txtUnidadesEstimadas = listado1.extraeDato(codigo,12);                                        
                    objParams.ChkFueraPedido = listado1.extraeDato(codigo,13);  
                    objParams.hOidProcedencia = listado1.extraeDato(codigo,14); // LG_V400000056 Hace falta para el CU Consultar


					objParams.opcionMenu = get('formulario.opcionMenu');                             
                    objParams.accion = get('formulario.accion');
				   
				   if (casoUsoSeleccionado == "detalle") {
							mostrarModalSICC("LPMantenerEstimadosProducto", "detalle", objParams, null, null);	
				   } else {
							mostrarModalSICC("LPMantenerEstimadosProducto", "detalleModificar", objParams, null, null);	
							btnBuscarOnClick();
				   }

				   return true;
		  } else {
                   GestionarMensaje("8", null, null, null);
				   return false;
		  }
	} else if (casoUsoSeleccionado == "eliminar") {
			eliminarFilas(seleccionados, "APEEliminarEstimadosProducto", mipgndo);
			return true;
	}  
}
/*--------------------------------------------------------------------------------------------------------*/
     function btnBuscarOnClick(){
         if (sicc_validaciones_generales()){
                  var centroDistribucion = get('formulario.cbCentroDistribucion');
                  var lineaArmado = get('formulario.cbLineaArmado');
                  var marca = get('formulario.cbMarca');
                  var canal = get('formulario.cbCanal');
                  var periodo = get('formulario.cbPeriodo');
                  var codProducto = get('formulario.txtCodigoProducto');
                  var fueraPedido = get('formulario.ChkFueraPedido');                  
				  var desProducto = get('formulario.txtDescripcionProducto');
                  fueraPedido = (fueraPedido=="N") ? "false" : "true";
                  
                  var pais = get('formulario.pais');
                  var idioma = get('formulario.idioma');

                  configurarPaginado(mipgndo, 'APEConsultarEstimadosProducto', 'ConectorConsultarEstimadosProducto', 
                                              'es.indra.sicc.dtos.ape.DTOMantenerEstimadosProducto', 
                                              [['oidCentroDistribucion',centroDistribucion],
                                              ['oidLineaArmado',lineaArmado],                                         
                                              ['oidMarca', marca],
                                              ['oidCanal', canal], 
                                              ['oidPeriodo', periodo],
                                              ['codigoProducto',codProducto],
                                              ['fueraPedido',fueraPedido], 
											  ['desProducto',desProducto]]
                                             );
                  }
                  
     }
 
/*--------------------------------------------------------------------------------------------------------*/
function muestraLista(ultima, rowset) {
		 var tamano = rowset.length;
		 if (tamano > 0) {
			  //Si se obtuvo algún resultado 
			 var s = GestionarMensaje(84);
             var n = GestionarMensaje(86);
             for ( f=0; f<rowset.length; f++) {
                 if ( rowset[f][14] == "1" ) rowset[f][14] = s;
                 else rowset[f][14] = n;
             }             
             listado1.setDatos(rowset);
			 visibleLista();         
			 return true;
		 } else {
			invisibleLista();
			focaliza('formulario.cbCentroDistribucion');
			return false;
		 }
}

/*--------------------------------------------------------------------------------------------------------*/

function visibleLista(){
    document.all["Cplistado1"].style.visibility='visible';
    document.all["CpLin1listado1"].style.visibility='visible';
    document.all["CpLin2listado1"].style.visibility='visible';
    document.all["CpLin3listado1"].style.visibility='visible';
    document.all["CpLin4listado1"].style.visibility='visible';
    
    document.all["primera1Div"].style.visibility='visible';
    document.all["ret1Div"].style.visibility='visible';
    document.all["ava1Div"].style.visibility='visible';
    document.all["separaDiv"].style.visibility='visible';
    
    var opcionMenu = get('formulario.opcionMenu');
 
    if (opcionMenu =='modificar') {
        document.all["btnModificarDiv"].style.visibility='visible';
        document.all["btnDetalleDiv"].style.visibility='hidden';
    } else if (opcionMenu == 'consultar') {
        document.all["btnModificarDiv"].style.visibility='hidden';
        document.all["btnDetalleDiv"].style.visibility='visible';
    } else if (opcionMenu == 'eliminar') {
        document.all["btnModificarDiv"].style.visibility='hidden';
        document.all["btnDetalleDiv"].style.visibility='visible';
        btnProxy(4, 1);
    }
}

function invisibleLista() {
    document.all["Cplistado1"].style.visibility='hidden';
    document.all["CpLin1listado1"].style.visibility='hidden';
    document.all["CpLin2listado1"].style.visibility='hidden';
    document.all["CpLin3listado1"].style.visibility='hidden';
    document.all["CpLin4listado1"].style.visibility='hidden';

    document.all["primera1Div"].style.visibility='hidden';
    document.all["ret1Div"].style.visibility='hidden';
    document.all["ava1Div"].style.visibility='hidden';
    document.all["separaDiv"].style.visibility='hidden';

    document.all["btnDetalleDiv"].style.visibility='hidden';
    document.all["btnModificarDiv"].style.visibility='hidden';
    
    if (get('formulario.opcionMenu') == 'eliminar') {
        btnProxy(4, 0);
    }   
}  

/*--------------------------------------------------------------------------------------------------------*/
/*************** Funciones TOOLBAR ****************/


 function fBorrar(){
		  elementosSeleccionados("eliminar");
 }

function fLimpiar() {

	var centroPorDefecto = get('formulario.hOidCentroDistribucionDefecto');
	set('formulario.cbCentroDistribucion', new Array(centroPorDefecto));
	onChangeCbCentroDistribucion();

	set("formulario.cbMarca","");    
	set("formulario.cbCanal","");    
	set("formulario.cbPeriodo","");    
    set("formulario.cbPeriodo", new Array(''));    
    accion('formulario.cbPeriodo', '.disabled=true');    
    
	set("formulario.cbProcedencia","");    
	set("formulario.txtCodigoProducto","");    
    set("formulario.txtUnidadesEstimadas","");    
    set("formulario.ChkFueraPedido","");        
	set("formulario.txtDescripcionProducto","");        
    invisibleLista();
	focaliza('formulario.cbCentroDistribucion');
}  


/*--------------------------------------------------------------------------------------------------------*/
function tab(elemento){
		try{
				 for(i=0; i < elementos.length; i++){
						  if( elementos[i] == elemento ){
									if( i == elementos.length - 1 )   i = 0;
									else   i++;
									document.selection.empty();
									focaliza('formulario.' + elementos[i]);	
									return;
							}
				 }
			 }
		catch(e){
				 tab(elementos[i]);
		}
}

function shtab(elemento){
		try{
				 for(i=elementos.length - 1; i >= 0 ; i--){
						  if( elementos[i] == elemento ){
									if( i == 0 ) i = elementos.length - 1;
									else i--;
									document.selection.empty();
									focaliza('formulario.' + elementos[i]);
									return;
						  }
				 }
		}catch(e){
				 shtab(elementos[i]);
		}
}

function descripcionProducto(){
  	    eval('formulario').oculto = 'S';			        
        set('formulario.conectorAction', 'LPMantenerEstimadosProducto');
        set('formulario.accion', 'buscar'); 
        enviaSICC('formulario'); 
}
function fverProducto(desProducto){
			set('formulario.txtDescripcionProducto',desProducto);		
}
function fProductoERR(){
		focaliza('formulario.txtCodigoProducto');
        set('formulario.txtDescripcionProducto', '');	

}
