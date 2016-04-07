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

function onLoadPag(){
  	 	
    	if (get(FORMULARIO + '.errDescripcion')!='') {
        	var wnd = fMostrarMensajeError(get(FORMULARIO + '.errCodigo'), get(FORMULARIO + '.errDescripcion'));
        }
        
        //Control del foco
        focaliza(FORMULARIO+'.cbMarca');
                 
       configurarMenuSecundario(FORMULARIO);
    	
	   if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
            btnProxy(2,1);  // boton 'volver', habilitado
            btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
        }
                 
   }

   
function onTabBuscar(){
	focaliza(FORMULARIO+'.cbMarca');
}

function onShTabCbMarca(){
	document.all['btnBuscar'].focus();	
}

function marcaOnChange(){
          
          var pais = get(FORMULARIO+'.pais');
          var marca = get(FORMULARIO+'.cbMarca');
          var canal = get(FORMULARIO+'.cbCanal');
          vaciaCombo(FORMULARIO + '.cbPeriodo');
          vaciaCombo(FORMULARIO + '.cbRegion');
          vaciaCombo(FORMULARIO + '.cbZona');
         
          if (marca != '' && canal != '') {
                    recargaCombo(
                              FORMULARIO + '.cbPeriodo',
                              'CRAObtienePeriodos', 
                              'es.indra.sicc.dtos.cra.DTOPeriodo', 
                              [["pais", pais], ["marca", marca], ["canal", canal]]                   
                    ) 
                    
                    recargaCombo(
                              FORMULARIO + '.cbRegion',
                              'ZONRecargaRegiones', 
                              'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
                              [["oidPais", pais], ["oidMarca", marca], ["oidCanal", canal]]                   
                    )                                		
         } 
}

function canalOnChange(){
         
	var canal = get(FORMULARIO+'.cbCanal');
	var idioma = get(FORMULARIO + '.idioma');
	var pais = get(FORMULARIO+'.pais');
	vaciaCombo(FORMULARIO + '.cbPeriodo');
        vaciaCombo(FORMULARIO + '.cbRegion');
        vaciaCombo(FORMULARIO + '.cbZona');
        vaciaCombo(FORMULARIO + '.cbAcceso');
        vaciaCombo(FORMULARIO + '.cbSubacceso');
          
        if (canal != '') {
        	var marca = get(FORMULARIO+'.cbMarca');
                if (marca != '') {
                        recargaCombo(
                        	FORMULARIO + '.cbPeriodo',
                                'CRAObtienePeriodos', 
                                'es.indra.sicc.dtos.cra.DTOPeriodo', 
                                [["pais", pais], ["marca", marca], ["canal", canal]]                           
                        );
                              
                        recargaCombo(
                              	FORMULARIO + '.cbRegion',
                              	'ZONRecargaRegiones', 
                              	'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
                              	[["oidPais", pais], ["oidMarca", marca], ["oidCanal", canal]]                   
                    	);                    

                }
	
		recargaCombo(
        		FORMULARIO + '.cbAcceso',
                	'SEGObtenerAccesosPorCanal', 
                	'es.indra.sicc.dtos.seg.DTOAccesosPorCanal', 
                	[["oidPais", pais], ["oidIdioma", idioma], ["oidCanal", canal]]
        	);                 
        }
}

function accesoOnChange() {
	
	var acceso = get(FORMULARIO + '.cbAcceso');
        var idioma = get(FORMULARIO + '.idioma');
        var pais = get(FORMULARIO + '.pais');
        vaciaCombo(FORMULARIO + '.cbSubacceso');
        
        if (acceso != "")
        	recargaCombo(
        		FORMULARIO + '.cbSubacceso', 
                	'SegObtenerSubaccesosPorAcceso', 
                        'es.indra.sicc.util.DTOOID',  
                        [["oidPais", pais], ["oidIdioma", idioma], ["oid", acceso]] );
}

function regionOnChange() {
	
	var region = get(FORMULARIO + '.cbRegion');
	var idioma = get(FORMULARIO + '.idioma');
        var pais = get(FORMULARIO + '.pais');
        vaciaCombo(FORMULARIO + '.cbZona');
        
        if (region != "")
        	recargaCombo(
                           	
                	FORMULARIO + '.cbZona', 
                        'ZONRecargaZonas', 
                        'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa',  [["oidPais", pais], 
                         ["oidRegion", region]] 
                           	
                 );
}

 

function fVolver(){
    window.returnValue=get(FORMULARIO+'.oidContacto');
 	window.close();            
 }

 

function unLoadPag(){
    window.returnValue=get(FORMULARIO+'.oidContacto');
 }



function accionBuscar() {

	var marca = get(FORMULARIO + '.cbMarca');
        var canal = get(FORMULARIO + '.cbCanal');
       	var periodo = get(FORMULARIO + '.cbPeriodo');
        var acceso = get(FORMULARIO + '.cbAcceso');
        var subacceso = get(FORMULARIO + '.cbSubacceso');
        var almacen = get(FORMULARIO + '.cbAlmacen');
        var codProducto = get(FORMULARIO + '.txtCodProducto');
        var descProducto = get(FORMULARIO + '.txtDescripcionProducto');
        var codVenta = get(FORMULARIO + '.txtCodVenta');
        var region = get(FORMULARIO + '.cbRegion');
        var zona = get(FORMULARIO + '.cbZona');
                           
        var idioma = get(FORMULARIO+'.idioma');
        var pais = get(FORMULARIO+'.pais');
       
        configurarPaginado(mipgndo, "CALBuscarStockProducto", "ConectorBuscarStockProducto", "es.indra.sicc.dtos.cal.DTOBuscarStockProducto",
                                    [['oidMarca', marca], 
                                    ['oidCanal', canal], 
                                    ['oidPeriodo', periodo], 
                                    ['oidAcceso', acceso], 
                                    ['oidSubacceso', subacceso], 
                                    ['oidAlmacen', almacen], 
                                    ['codProducto', codProducto],                                   
                                    ['descProducto', descProducto], 
                                    ['codVenta', codVenta], 
                                    ['oidRegion', region],
                                    ['oidZona', zona],
                                    ['oidPais', pais], 
                                    ['oidIdioma', idioma]]);
}

function vaciaCombo(combo) {
	set_combo(combo,[['','']],['']);
}

function mostrarLista() {
                  DrdEnsanchaConMargenDcho('listado1',12);
                  document.all["Cplistado1"].style.visibility='visible';
                  document.all["CpLin1listado1"].style.visibility='visible';
                  document.all["CpLin2listado1"].style.visibility='visible';
                  document.all["CpLin3listado1"].style.visibility='visible';
                  document.all["CpLin4listado1"].style.visibility='visible';
                  document.all["primera1Div"].style.visibility='visible';
                  document.all["ret1Div"].style.visibility='visible';
                  document.all["ava1Div"].style.visibility='visible';
                  document.all["separaDiv"].style.visibility='visible';
                  eval (ON_RSZ);  
}

function ocultarLista() {
                  document.all["Cplistado1"].style.visibility='hidden';
                  document.all["CpLin1listado1"].style.visibility='hidden';
                  document.all["CpLin2listado1" ].style.visibility='hidden';
                  document.all["CpLin3listado1"].style.visibility='hidden';
                  document.all["CpLin4listado1"].style.visibility='hidden';
                  document.all["primera1Div"].style.visibility='hidden';
                  document.all["ret1Div"].style.visibility='hidden';
                  document.all["ava1Div"].style.visibility='hidden';
                  document.all["separaDiv"].style.visibility='hidden';
}

function muestraLista( ultima, rowset){

	var tamano = rowset.length;
        if (tamano > 0) {
        	mostrarLista();
                return true;
        } else {
                ocultarLista();
                // No se ha encontrado ningún elemento con los criterios especificados
                //Control del foco
                focaliza(FORMULARIO+'.cbMarca');
                return false;
               }
}

function fLimpiar() {
	
	vaciaCombo(FORMULARIO + '.cbPeriodo');
        vaciaCombo(FORMULARIO + '.cbRegion');
        vaciaCombo(FORMULARIO + '.cbZona');
        vaciaCombo(FORMULARIO + '.cbAcceso');
        vaciaCombo(FORMULARIO + '.cbSubacceso');
        
        focaliza(FORMULARIO+'.cbMarca');
                
}

function aMayusculas(campo){
         if (get(FORMULARIO+'.'+campo)!='') {
                  set(FORMULARIO+'.'+campo,get(FORMULARIO+'.'+campo).toUpperCase());
         }
}

   
  