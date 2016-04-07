//array de elementos que pueden tener el foco con TAB/SHTAB
var elementos = new Array('cbCentroDistribucion','cbLineaArmado','txtCodigoSublinea',
                'txtDescripcion', 'cbSistemaPicado', 
                'cbLetraAnaquel','cbCodigoImpresora','btnBuscar');
                
function onLoadPag(){  
         var centroDefecto = get('formulario.hOidCentroDistribucionDefecto');
         set('formulario.cbCentroDistribucion', new Array(centroDefecto)); 
         onChangeCbCentroDistribucion();
         cargaCbLetraAnaquel();
         configurarMenuSecundario('formulario');
         invisibleLista();         
         fMostrarMensajeError();
         focaliza("formulario.cbCentroDistribucion");         
}

/*--------------------------------------------------------------------------------------------------------*/
function cargaCbLetraAnaquel() {
         set_combo('formulario.cbLetraAnaquel', [[" "," "], 
                                             ["A","A"],["B","B"],
                                             ["C","C"],["D","D"],
                                             ["E","E"],["F","F"],
                                             ["G","G"],["H","H"],
                                             ["I","I"],["J","J"],
                                             ["K","K"],["L","L"],
                                             ["M","M"],["N","N"],
                                             ["O","O"],["P","P"],
                                             ["Q","Q"],["R","R"],                                             
                                             ["S","S"],["T","T"],                                             
                                             ["U","U"],["V","V"],
                                             ["W","W"],["X","X"],
                                             ["Y","Y"],["Z","Z"]
                                             ],
                                            [" "])  
}

/*--------------------------------------------------------------------------------------------------------*/

function visibleLista(){
    DrdEnsanchaConMargenDcho('listado1', 30);

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
    
    eval(ON_RSZ);
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
    
function arrayVacio(){  
    var array = new Array();              
         array[0] = new Array('','');
  
    return array;
}

function onChangeCbCentroDistribucion(){
    if(get('formulario.cbCentroDistribucion') != ''){
        accion('formulario.cbLineaArmado', '.disabled=false');
        recargaCombo('formulario.cbLineaArmado', 'APEObtenerLineasArmadoCD', 
          'es.indra.sicc.util.DTOOID', 
          [['oid', get('formulario.cbCentroDistribucion')], 
          ['oidIdioma', get('formulario.idioma')]], 
          'setearCbLineaArmado(datos)' );
    } else {
        set_combo('formulario.cbLineaArmado', arrayVacio());
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
function btnBuscarOnClick(){
	// ciglesias incidencia 496 - se quita la validacion de obligatorios para Consulta
	configurarPaginado( mipgndo, 'APEBuscarSublineasArmado', 'ConectorBuscarSublineasArmado', 
						'es.indra.sicc.dtos.ape.DTOBuscarSublineaArmado', 
						armarArrayValoresDto() );
}

/*--------------------------------------------------------------------------------------------------------*/
function muestraLista(ultima, rowset) {
                   var tamano = rowset.length;
                   if (tamano > 0) {
                            //listado1.setDatos(rowset);
                            visibleLista();
                            return true;
                   } else {
                           invisibleLista();
                           focaliza('formulario.cbCentroDistribucion');
                           return false;
                   }
}

/*--------------------------------------------------------------------------------------------------------*/


function onClickModificar(){
    elementosSeleccionados("detalleModificar");
}          

function onClickDetalle(){
    elementosSeleccionados("detalle");
}      
    
function onClickEliminar(){
    elementosSeleccionados("eliminar");
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
                
					objParams.hOidSublinea = seleccionados[0]; //OID_SUB_LINE_ARMA
                    objParams.hCbCentroDistribucion = listado1.extraeDato(codigo,0);//OID_CONF_CENT_DIST
					objParams.hDescCentroDistribucion = listado1.extraeDato(codigo,1);//DESC_CENT_DIST
                    objParams.hCbLineaArmado = listado1.extraeDato(codigo,2);//OID_LINE_ARMA                    
                    objParams.hDescLineaArmado = listado1.extraeDato(codigo,3);  //DESC_LINEA_ARMADO                  
					objParams.hCodSubLineaArmado = listado1.extraeDato(codigo,4);//COD_SUBL_ARMA
                    objParams.hDescSubLineaArmado = listado1.extraeDato(codigo,5); //DESC_SUBLINEA_ARMADO                                       
                    objParams.hCbSistPicado = listado1.extraeDato(codigo,6);//OID_SIST_PICA					
                    objParams.hDescSistPicado = listado1.extraeDato(codigo,7); //DESC_SIST_PICADO
                    objParams.hDescLetraAnaquel = listado1.extraeDato(codigo,8); //letraParaAnaquel 
					objParams.hChkImprimirListaPicado = listado1.extraeDato(codigo,9); //imprimirListaPicado
                    objParams.hChkPostVenta = listado1.extraeDato(codigo,10);//postVenta
					objParams.hChkFrenteEspalda = listado1.extraeDato(codigo,11);//frenteEspalda
                    objParams.hTxtBahiasFrente = listado1.extraeDato(codigo,12);//bahiasFrente
					objParams.hTxtBahiasEspalda = listado1.extraeDato(codigo,13);//bahiasEspalda
                    objParams.hTxtNivelesFrente = listado1.extraeDato(codigo,14);//numeroNivelesFrente
                    objParams.hTxtNivelesEspalda = listado1.extraeDato(codigo,15); //numeroNivelesEspalda
					objParams.hTxtColumnasBahiaFrente = listado1.extraeDato(codigo,16);//numeroColumnasFrente
                    objParams.hTxtColumnasBahiaEspalda = listado1.extraeDato(codigo,17);//numeroColumnasEspalda
                    objParams.hTxtNumeroOrdenBalanceo = listado1.extraeDato(codigo,18); //numeroOrdenBalanceo
					objParams.hOidCodigoImpresora = listado1.extraeDato(codigo,21); //oid Codigo impresora //ciglesias incidencia 480
					objParams.hTxtNroImpresoraPTL = listado1.extraeDato(codigo,20); //Nro Impresora PTL //ciglesias incidencia 480


					objParams.opcionMenu = get('formulario.opcionMenu');                             
                    objParams.accion = get('formulario.accion');
				   
				   if (casoUsoSeleccionado == "detalle") {
							mostrarModalSICC("LPMantenimientoSublineaArmado", "detalle", objParams, null, null);	
				   } else {
							mostrarModalSICC("LPMantenimientoSublineaArmado", "detalleModificar", objParams, null, null);	
							btnBuscarOnClick();
				   }

				   return true;
		  } else if (cantSeleccionados < 1) {
			  GestionarMensaje('50');
	      } else if (cantSeleccionados > 1) {
			  cdos_mostrarAlert(GestionarMensaje('240'));
		  }		  
	} else if (casoUsoSeleccionado == "eliminar") {
			eliminarFilas(seleccionados, "APEEliminarSubineasArmado", mipgndo);
			return true;
	}  
}

function fLimpiar(){
        set('formulario.cbCentroDistribucion',new Array(get('formulario.hOidCentroDistribucionDefecto')));
        onChangeCentroDistribucion();        
        set('formulario.txtCodigoSublinea',get('formulario.hTxtCodigoSublinea'));
        set('formulario.cbLetraAnaquel', new Array(' '));
   
        set('formulario.cbSistemaPicado',new Array(get('formulario.hCbSistemaPicado')));
        set('formulario.txtDescripcion','');
    
        set('formulario.txtBahiasSublineaFrente','');
        set('formulario.txtBahiasSublineaEspalda','');
        set('formulario.txtNroNivelesFrente','');
        set('formulario.txtNroNivelesEspalda','');
        set('formulario.txtNroColumnasBahiaFrente','');
        set('formulario.txtNroColumnasBahiaEspalda','');
        set('formulario.txtNroOrdenBalanceo','');
        
        set('formulario.chkSublineaPostVenta','N');    
        set('formulario.chkImprimirListaPicado','N');   
        set('formulario.chkFrenteEspalda','N');   
        
        listado1.tiposCol[0][2] = arrayVacio();
        listado1.limpia();
        
        btnProxy(1,0);
        if(get('formulario.opcionMenu')=="eliminar"){
            btnProxy(4,1);
        }
        focaliza("formulario.cbCentroDistribucion");
}


function fBorrar(){
    onClickEliminar();
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

function armarArrayValoresDto() {
	var arrDatos = new Array();
	var i=0;
	
	arrDatos[i] = new Array('oidPais', get('formulario.pais'));
	i++;
	arrDatos[i] = new Array('oidIdioma', get('formulario.idioma'));
	i++;
	
	if (get('formulario.cbCentroDistribucion') != '') {
		arrDatos[i] = new Array('oidCentroDistribucion', get('formulario.cbCentroDistribucion'));
		i++;
	}
	
	if (get('formulario.cbLineaArmado') != '') {
		arrDatos[i] = new Array('oidLineaArmado', get('formulario.cbLineaArmado'));
		i++;
	}
	
	if (get('formulario.txtCodigoSublinea') != '') {
		arrDatos[i] = new Array('codigoSublinea', get('formulario.txtCodigoSublinea'));
		i++;
	}
	
	if (get('formulario.txtDescripcion') != '') {
		arrDatos[i] = new Array('descripcionSublinea', get('formulario.txtDescripcion'));
		i++;
	}
	
	if (get('formulario.cbSistemaPicado') != '') {
		arrDatos[i] = new Array('oidSistemaPicado', get('formulario.cbSistemaPicado'));
		i++;
	}
	
	if (get('formulario.cbLetraAnaquel') != '') {
		arrDatos[i] = new Array('letraParaAnaquel', get('formulario.cbLetraAnaquel'));
		i++;
	}
	
	if (get('formulario.cbCodigoImpresora') != '') {
		arrDatos[i] = new Array('impresoraVirtual', get('formulario.cbCodigoImpresora'));
		i++;
	}
	
	return arrDatos;
}
