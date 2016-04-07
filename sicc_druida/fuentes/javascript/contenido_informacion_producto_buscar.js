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


function onLoadPag()   {
  
    DrdEnsanchaConMargenDcho('listado1',12);
    document.all['Cplistado1'].style.visibility='';
    document.all['CpLin1listado1'].style.visibility='';
    document.all['CpLin2listado1'].style.visibility='';
    document.all['CpLin3listado1'].style.visibility='';
    document.all['CpLin4listado1'].style.visibility='';
    document.all['separaDiv'].style.visibility='';
    document.all['primera1Div'].style.visibility='';

    eval (ON_RSZ);  

    configurarMenuSecundario(FORMULARIO);

    if (get(FORMULARIO+'.errDescripcion')!='') {		
        var wnd = fMostrarMensajeError(get(FORMULARIO+'.errCodigo'),get(FORMULARIO+'.errDescripcion'));
    }
    
    cargaCombos();          

    focaliza(FORMULARIO+'.txtCodSAP');
}

function muestraLista(ultima, rowset){
	var tamano = rowset.length;
    if (tamano > 0) {
    	visibleLista();
        DrdEnsanchaConMargenDcho('listado1',12);
        eval (ON_RSZ);
        return true;
	} else {
    	invisibleLista();                         
        return false;
	}
}

function visibleLista(){
	if (!get_visibilidad('capaLista')){
    	visibilidad('capaLista','V');
    }
}

function invisibleLista() {
    if (get_visibilidad('capaLista')){
          visibilidad('capaLista','O');
    }
} 

function ontabBtnBuscar() {
	// Si la lista no es visible, voy al primer elemento. 
	if (!get_visibilidad('capaLista')){
		focaliza(FORMULARIO+'.txtCodSAP');                      
	} else {
        document.all['btnDetalle'].focus();
	}
}

function ontabBtnDetalle() {
	focaliza(FORMULARIO+'.txtCodSAP');                      
}

function onshtabTxtCodSAP() {

	// Si la lista no es visible, voy al primer elemento. 
	if (!get_visibilidad('capaLista')){
        document.all['btnBuscar'].focus();
	} else {
        document.all['btnDetalle'].focus();
    }
}

// Terminado. Funciona. Pendiente de incidencia BELC300012939.
function onClickBuscar() {
    var iProductoServicio = '';
    var sSituacion = '';

    if(get(FORMULARIO+'.cbProductoServicio')==get(FORMULARIO+'.MAE_TXT_PRODUCTO')){
         iProductoServicio = get(FORMULARIO+'.CMN_VAL_FALSE');
    } else if(get(FORMULARIO+'.cbProductoServicio')==get(FORMULARIO+'.MAE_TXT_SERVICIO')) {
         iProductoServicio = get(FORMULARIO+'.CMN_VAL_TRUE');
    }

    if(get(FORMULARIO+'.cbSituacion')==get(FORMULARIO+'.MAE_TXT_PRODUCTO_ACTIVO')){
         sSituacion = get(FORMULARIO+'.MAE_PRODUCTO_ACTIVO');
    } else if(get(FORMULARIO+'.cbSituacion')==get(FORMULARIO+'.MAE_TXT_PRODUCTO_INACTIVO')) {
         sSituacion = get(FORMULARIO+'.MAE_PRODUCTO_INACTIVO');
    }
     
    var pais = get(FORMULARIO+'.pais');
    var idioma = get(FORMULARIO+'.idioma');

    var codSAP = get(FORMULARIO+'.txtCodSAP');
    var codAntiguo = get(FORMULARIO+'.txtCodAntiguo');
    var descCorta = get(FORMULARIO+'.txtDescripcionCorta');
    var descSAP = get(FORMULARIO+'.txtDescripcionSAP');
    var marcaProducto = get(FORMULARIO+'.cbMarcaProducto');
    var unidadesNegocio = get(FORMULARIO+'.cbUnidadNegocio');
    var negocio = get(FORMULARIO+'.cbNegocio');
    var linea = get(FORMULARIO+'.cbLinea');
    var estatusProducto = get(FORMULARIO+'.cbEstatusProducto');
    var precioCatalogo = get(FORMULARIO+'.txtPrecioCatalogo');
    var precioContable = get(FORMULARIO+'.txtPrecioContable');

    configurarPaginado(mipgndo, 'CALBuscarInformacionProductos', 
                        'ConectorBuscarInformacionProductos', 'es.indra.sicc.dtos.cal.DTOBuscarInformacionProductos', 
                        [['oidPais', pais], ['oidIdioma', idioma], 
                        ['codSAP', codSAP], 
                        ['codAntiguo', codAntiguo], 
                        ['descCorta', descCorta], 
                        ['descSAP', descSAP], 
                        ['productoServicio', iProductoServicio], 
                        ['marcaProducto', marcaProducto], 
                        ['unidadesNegocio', unidadesNegocio], 
                        ['negocio', negocio], 
                        ['linea', linea], 
                        ['situacion', sSituacion], 
                        ['estatusProducto', estatusProducto], 
                        ['precioCatalogo', precioCatalogo], 
                        ['precioContable', precioContable]]);
    
}

function onClickDetalle(){
    if (listado1.numSelecc() == 0) {
        // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
        GestionarMensaje('50');
    } else {
        if (listado1.numSelecc() != 1 ) {
            //Muesta el mensaje: "Debe seleccionar un solo registro"
            GestionarMensaje('8');
            deseleccionaListado();
            
        } else {
            var objParams = new Object();
            objParams.oid = listado1.codSeleccionados();

            mostrarModalSICC('LPInformacionProductos', 'detalle', objParams, null, null);
        }
    }
}

         function deseleccionaListado() {
                  for (i = 0; i < listado1.datos.length; i++)
                                    listado1.deselecciona(i); 
         }


// Función que carga los combos cbProductoServicio y cbSituacion
function cargaCombos(){
    var txtProducto = get(FORMULARIO+'.MAE_TXT_PRODUCTO');
    var txtServicio = get(FORMULARIO+'.MAE_TXT_SERVICIO');
    var txtProductoActivo = get(FORMULARIO+'.MAE_TXT_PRODUCTO_ACTIVO');
    var txtProductoInactivo = get(FORMULARIO+'.MAE_TXT_PRODUCTO_INACTIVO');
    set_combo(FORMULARIO+'.cbProductoServicio', [['00', ''], [txtProducto, txtProducto], [txtServicio, txtServicio]], '00'); 
    set_combo(FORMULARIO+'.cbSituacion', [['00', ''], [txtProductoActivo, txtProductoActivo], [txtProductoInactivo, txtProductoInactivo]], '00'); 
}

function fLimpiar(){
    set(FORMULARIO + '.cbProductoServicio', ['']);
    set(FORMULARIO + '.cbSituacion', ['']);
    //invisibleLista();

	focaliza(FORMULARIO+'.txtCodSAP');                      
}

function fVolver(){
    window.returnValue=get(FORMULARIO+'.oidContacto');
    window.close();            
}

function unLoadPag(){
    window.returnValue=get(FORMULARIO+'.oidContacto');
}

function validaPrecio(nombreElemento) {
    var valorElemento = get(FORMULARIO+'.'+nombreElemento);
    var separadorMiles = get(FORMULARIO+'.hid_SeparadorMiles');
    var numeroDecimales = get(FORMULARIO+'.hid_NumeroDecimales');
    var separadorDecimales = get(FORMULARIO+'.hid_SeparadorDecimales').toString();
                  
    if (valorElemento != '') {
        var mensaje = ValidaMilesDecimales(valorElemento, 10, numeroDecimales, separadorMiles, separadorDecimales, 0);
        if (mensaje != 'OK') {
            cdos_mostrarAlert(mensaje);
            focaliza(FORMULARIO+'.'+nombreElemento);
            return false;
        }
    } 
}

function mayusculas(nombreCampo) {
    var valor = get(FORMULARIO+'.'+nombreCampo)
    if(valor!=''){
        valor = valor.toUpperCase();
        set(FORMULARIO+'.'+nombreCampo, valor);
    }
}
