/**
* Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

/*
    INDRA/CAR/PROY
    $Id: contenido_registro_ventas_modificar.js,v 1.3 2011/02/03 15:29:58 pecbazalar Exp $
    DESC
*/

var FORMULARIO = "Formulario";
var permitidos = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";

function onLoadPag()   {
  
     configurarMenuSecundario(FORMULARIO);
       
      var errDescripcion = get(FORMULARIO +'.errDescripcion');
      if (errDescripcion !='') {                    
          var errCodigo = get(FORMULARIO+'.errCodigo');
          var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
      }
    	
    DrdEnsanchaConMargenDcho('listado1',12);
    document.all["Cplistado1"].style.visibility='';
    document.all["CpLin1listado1"].style.visibility='';
    document.all["CpLin2listado1"].style.visibility='';
    document.all["CpLin3listado1"].style.visibility='';
    document.all["CpLin4listado1"].style.visibility='';
    document.all["separaDiv"].style.visibility='';
    document.all["primera1Div"].style.visibility='';
    document.all["ret1Div"].style.visibility='';
    document.all["ava1Div"].style.visibility='';
    if((get(FORMULARIO +'.casoUso')=='consultar')||(get(FORMULARIO +'.casoUso')=='eliminar')){
                        document.all["btnModificarDiv"].style.visibility='hidden';
                        document.all["btnDetalleDiv"].style.visibility='';
						document.all["btnExportar"].style.visibility='';
            }else{
                      
                        document.all["btnDetalleDiv"].style.visibility='hidden';
                        document.all["btnModificarDiv"].style.visibility='';
						document.all["btnExportar"].style.visibility='';
            }

    
    //document.all["btnModificarDiv"].style.visibility='';
    //document.all["btnDetalleDiv"].style.visibility='hidden';
    
    eval (ON_RSZ);
    
    focaliza(FORMULARIO+'.txtFechaEmisionDesde','');

   }
   
function muestraLista( ultima, rowset){
                    
            var tamano = rowset.length;
            if (tamano > 0) {
                         visibleLista();
                         if (get(FORMULARIO+'.casoUso') == 'eliminar')
                  		btnProxy(4, 1);

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
function desplazar(){
         	
           if(get_visibilidad("capaLista")){
           	 if((get(FORMULARIO +'.casoUso')=='consultar')||(get(FORMULARIO +'.casoUso')=='eliminar')){
           	 		
                              document.all['btnDetalle'].focus();
                 }else{
                 		
                              document.all['btnModificar'].focus();
                 }
           }else{
           		
                focaliza(FORMULARIO+'.txtFechaEmisionDesde'); 
           }
}
function desplazarSift(){
          
           if(get_visibilidad("capaLista")){
           	 if(get(FORMULARIO +'.casoUso')=='modificar'){
                      //si caso de uso es tal unboton sino al otro.
                      document.all['btnModificar'].focus();
                }
                 if(get(FORMULARIO +'.casoUso')=='consultar'){
                 	document.all['btnDetalle'].focus();
                }
                 	
           }else{
                      document.all['btnBuscar'].focus();
                    
           }
           
}
function desplazarONStab(){
                    document.all['btnBuscar'].focus();
}

/*function EsFechaValida_SICC(fecCurso, formName)   
         que se encuentra en sicc_util.js.  
         Antes de llamar a esta función, 
         en la LP hay que llamar al método generarHiddenFormatoFecha() que está en LPSICCBase. 
         Este método genera un campo hidden con el formato de fecha, que es utilizado por la función  javascript.
         */	
function comprobarFecha(txtFecha){ 
         
         var fecha = get(FORMULARIO+'.'+txtFecha);
          
         if(fecha != ""){
         var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
                  if(resul==1 || resul==2){  
                  GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais')); 
                           focaliza(FORMULARIO+'.'+txtFecha);
                           return false;
				  }
         }
}

function accionBTNBuscar(){
	/*Llamamos a configurarPaginado: 

//Función <<JavaScript>> del subsistema <<Paginacion>> 
- Llamamos a PaginacionSicc.configurarPaginadoExt(); 

Pasándole los parámetros siguientes:  

-la lista "resultados", 
-CCCBuscarRegistroVentas, ConectorBuscarRegistrosVentas, -DTOBuscarRegistroVentas*/
	
		 var nume = 0;
		 var idioma = get(FORMULARIO+'.idioma');
		 var pais = get(FORMULARIO+'.pais');
		 
		 var fechaEmisionDesde = get(FORMULARIO+'.txtFechaEmisionDesde');
		 var fechaEmisionHasta = get(FORMULARIO+'.txtFechaEmisionHasta');
		 var codigoClienteDesde = get(FORMULARIO+'.txtCodClienteDesde');
		 var codigoClienteHasta = get(FORMULARIO+'.txtCodClienteHasta');
		 var oidImpuestos = get(FORMULARIO+'.cbImpuesto');
		 var oidCanal = get(FORMULARIO+'.cbCanal'); //  cambio 20070451
		 var oidAcceso = get(FORMULARIO+'.cbAcceso');//  cambio 20070451
		 var oidSubacceso = get(FORMULARIO+'.cbSubacceso'); //  cambio 20070451
		 var oidTipoDocLegal = get(FORMULARIO+'.cbTipoDocLegal'); //  cambio 20070451
		 var serieDocLegal = get(FORMULARIO+'.txtSerieDocLegal'); //  cambio 20070451
		 var numeroDocLegalDesde = get(FORMULARIO+'.txtSerieNumeroDocLegalDesde'); //  cambio 20070451
		 var numeroDocLegalHasta = get(FORMULARIO+'.txtSerieNumeroDocLegalHasta'); //  cambio 20070451
		 
		 var oid = get(FORMULARIO+'.txtOid'); //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
    
		 if (get(FORMULARIO+'.casoUso') == 'eliminar')
				btnProxy(4, 0); 
		
		if((fechaEmisionDesde != null)&&(fechaEmisionDesde != "")){
		       nume++;	
		}
		if((fechaEmisionHasta != null)&&(fechaEmisionHasta != "")){
		               nume++;	
		}
		if((codigoClienteDesde != null)&&(codigoClienteDesde != "")){
		               nume++;	
		}
		if((codigoClienteHasta != null)&&(codigoClienteHasta != "")){
		               nume++;	
		}
		if((oidImpuestos != null)&&(oidImpuestos != "")){
		               nume++;	
		}
		if((oidCanal != null) &&(oidCanal != "")){
						nume++;
		}
		if((oidAcceso != null)&&(oidAcceso != "")){
						nume++;
		}
        if((oidSubacceso != null)&&(oidSubacceso != "")){
						nume++;
		}
		if((oidTipoDocLegal != null)&&(oidTipoDocLegal !="")){
						nume++;
		}
		if((serieDocLegal != null)&&(serieDocLegal !="")){
						nume++;
		}
		if((numeroDocLegalDesde != null)&&(numeroDocLegalDesde != "")){
						nume++;
		}
		if((numeroDocLegalHasta != null)&&(numeroDocLegalHasta != "")){
		
						nume++
		}
		if ((oid != null) && (oid != "")) {
						nume = nume + 2;
		}	
	
		if(nume < 2){
                           //Muestra el mensaje:"Debe introducir al menos dos criterios de filtro" (UICCC005)
                           //GestionarMensaje('1405');
        	//Modificado por la incidencia 14590:
        	//Debe introducir al menos dos criterios de búsqueda
        	GestionarMensaje('1389',2);
			return;
		} 

		// DBLG700000069 - gPineda - 26/10/2006		
		if( ! comprobarFechas() ){
			return;
		}
		if ( ! validarRangoCodigosClientes() ){
			return;
		}

		configurarPaginado(mipgndo, "CCCBuscarRegistroVentas", "ConectorBuscarRegistrosVentas","es.indra.sicc.dtos.ccc.DTOBuscarRegistroVentas",[["oidPais", pais],["oidIdioma", idioma],["fechaEmisionDesde", fechaEmisionDesde],["fechaEmisionHasta", fechaEmisionHasta], ["codigoClienteDesde", codigoClienteDesde], ["codigoClienteHasta", codigoClienteHasta],["oidImpuestos", oidImpuestos], ["oidSubacceso", oidSubacceso], ["oidTipoDocLegal",oidTipoDocLegal], ["serieDocuLegal", serieDocLegal],["numeroDocLegalDesde", numeroDocLegalDesde], ["numeroDocLegalHasta", numeroDocLegalHasta], ["oid", oid] ]); 
	}

function accionBTN_Modificar(){
	
	if (listado1.numSelecc() == 0) {
                    // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                    GestionarMensaje('50');
    } else {
             if (listado1.numSelecc() != 1 ) {
                    //Muesta el mensaje: "Debe seleccionar un solo registro"
                    GestionarMensaje('8');
                    //Se limpia la lista editable
                    var seleccion=listado1.codigos();
                  	var i=0;
                 	while(seleccion[i]!=null){
                    		listado1.deselecciona(i); 
                  			i++;           
                  	}
              } else {
                     var objParams = new Object();
                     var codigoSeleccionado = listado1.codSeleccionados();
                     objParams.oidSeleccionado = codigoSeleccionado;
                     objParams.casodeUso = get(FORMULARIO+'.casoUso');
                     var seleccionados = listado1.codSeleccionados();
                     var fila = mostrarModalSICC("LPPopup","btn_modificar", objParams, null, null);
                    
			   	     if(typeof(fila)!='undefined') {
			                 if(fila.length!=0) { 
				
	        		            	listado1.actualizaDat();
			 	                    var datosFinal = listado1.datos;
				                    for (i = 0; i < datosFinal.length; i++) {
					                          var filaaux = datosFinal[i];
					                          if(filaaux[0]== seleccionados){
											
						
						                             filaaux[1] = fila[0];//fechaEmision
						                             filaaux[2] = fila[1];// codigoCliente 
						                             filaaux[3] = fila[2];// oidTipoDocLegal
						                             filaaux[4] = fila[3];// descTipoDocLegal
						                             filaaux[5] = fila[4];// numeroSerieDocLegal
						                             filaaux[6] = fila[5];// numer
						                             filaaux[7] = fila[6];
						                             filaaux[8] = fila[7];
						                             //filaaux[9] = fila[8];
                                                     //filaaux[10] = fila[9];
						   						     //filaaux[11] = fila[10];
													 //filaaux[12] = fila[11];
													 //filaaux[13] = fila[12];
													 //filaaux[14] = fila[13];
						
						
					                          }
				                     }//for
			                         listado1.reajusta();
			   
			                    }
		              }
					  if(typeof(fila)!='undefined'){
							accionBTNBuscar(); 
					 }
                     focaliza(FORMULARIO+'.txtFechaEmisionDesde');
              }

    }
   
}

function accionBTN_Detalle(){
	
	if (listado1.numSelecc() == 0) {
                    // Muestra el mensaje: "Debe seleccionar un elemento de la lista"
                    GestionarMensaje('50');
          } else {
                    if (listado1.numSelecc() != 1 ) {
                              //Muesta el mensaje: "Debe seleccionar un solo registro"
                              GestionarMensaje('8');
                                                //Se limpia la lista editable
                  		var seleccion=listado1.codigos();
                  		var i=0;
                 		 while(seleccion[i]!=null){
                  			listado1.deselecciona(i); 
                  			i++;           
                  		}

                   } else {
                           var objParams = new Object();
                           var codigoSeleccionado = listado1.codSeleccionados();
                           objParams.oidSeleccionado = codigoSeleccionado;
                           objParams.casodeUso = get(FORMULARIO+'.casoUso');      
                           
                           mostrarModalSICC("LPPopup","btn_detalle", objParams, null, null);
                           focaliza(FORMULARIO+'.txtFechaEmisionDesde');
                    }
          } 
              
}
function fLimpiar() {
	
    fLimpiarGenericoSICC(); //habra que borrar el combo a pelo.???
       
}
function accionBTNIMG_BuscarClienteDesde(){
	
	//Diseño csanchez: Invocamos  Busqueda Rápida de clientes
	 //Abrimos un popup modal con la direccion de la LPBusquedaRapidaCliente, 
          //cuando se cierra el popup si el usuario ha seleleccionado un cliente 
          //se nos devuelven dos valores en un array. 
          //Con el segundo valor rellenamos el campo codigoCliente

    //Llamamos al proceso correspondiente Modal
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);         

    if(typeof cliente!='undefined') {
	var codigoClienteDesde = cliente[1];
    	set(FORMULARIO+'.txtCodClienteDesde',codigoClienteDesde);
    }
}

function accionBTNIMG_BuscarClienteHasta(){
	
   
    var objParams = new Object();
    var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);         

    if(typeof cliente!='undefined') {
	var codigoClienteHasta = cliente[1];
    	set(FORMULARIO+'.txtCodClienteHasta',codigoClienteHasta);
    }
}


/*
Esta opción del Menú Secundario solo estará disponible 
para el Caso de uso: Eliminar Registro de Ventas que 
se corresponde con: 
accion="eliminar_menu_principal" 
Creamos un array con los oid_reg de las filas que han sido seleccionadas en la tabla. 
Llamamos directamente al Eliminación con los 
parámetros: 
idBusiness="CCCEliminarRegistrosVentas" 
DTOOIDs (con el array de los oid_reg obtenidos de la selección en la lista).

*/
function eliminar(){
	
		var codSeleccionados = listado1.codSeleccionados();
          
          if (codSeleccionados.length == 0){
                    GestionarMensaje('1021',null,null,null);
                    return false;
          }
		  else {
                    listado1.actualizaDat();
                    datos = listado1.datos;
                    
                    if ( codSeleccionados.length < 1){
                              GestionarMensaje('4');
                              return;
                    }

                    var arrOids = new Array();
                    for(var i = 0; i < codSeleccionados.length; i++){
                         var oidRegisVenta = codSeleccionados[i];
                         arrOids[arrOids.length] = oidRegisVenta;

                    }
              eliminarFilas(arrOids,"CCCEliminarRegistrosVentas", mipgndo);
			  focaliza(FORMULARIO+'.txtFechaEmisionDesde','');
          }
	
	
}

function fBorrar(){
	eliminar();
}	

// Función que se ejecuta en el OnBlur del campo textCodClienteD.
// Rellena con ceros el la parte izquierda de código de cliente.
function textCodClienteDOnBlur() {
         var codigoCliente = get(FORMULARIO+'.txtCodClienteDesde').toString();
         if (codigoCliente != '') {
                  var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
                  var longitud = codigoCliente.length;
                  set(FORMULARIO+'.txtCodClienteDesde',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud));
         }
}

// Función que se ejecuta en el OnBlur del campo textCodClienteH.
// Rellena con ceros el la parte izquierda de código de cliente.
function textCodClienteHOnBlur() {
         var codigoCliente = get(FORMULARIO+'.txtCodClienteHasta').toString();	
         if (codigoCliente != '') {
                  var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
                  var longitud = codigoCliente.length;
                  set(FORMULARIO+'.txtCodClienteHasta',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud));
         }
}

// DBLG700000069 - gPineda - 26/10/2006
function validarRangoCodigosClientes(){
		var codigoClienteDesde = get(FORMULARIO+'.txtCodClienteDesde').toString();	
		var codigoClienteHasta = get(FORMULARIO+'.txtCodClienteHasta').toString();	
		if( codigoClienteDesde != "" && codigoClienteHasta != "" ){
			if( codigoClienteDesde > codigoClienteHasta ){
				GestionarMensaje('3339'); 
				focaliza(FORMULARIO+'.txtCodClienteHasta');
				return false;
			}
		}
		return true;
}

// DBLG700000069 - gPineda - 26/10/2006
function comprobarFechas(){
	var fechaDesde = get(FORMULARIO+'.txtFechaEmisionDesde');
	var fechaHasta = get(FORMULARIO+'.txtFechaEmisionHasta');
		if(fechaDesde!="" && fechaHasta != ""){
	    	var resul = EsFechaValida(fechaDesde,fechaHasta, FORMULARIO,null);
			if(resul == 3){
				GestionarMensaje('1007', get(FORMULARIO+'.hFormatoFechaPais')); 
				focaliza(FORMULARIO+'.txtFechaEmisionHasta');
				return false;
			}
		}
	return true;
}
function canal_onChange(){
         vaciaAcceso();
         var oidcanal = get(FORMULARIO+'.cbCanal');
         if (oidcanal != ""){
                  var oidpais = get(FORMULARIO+'.pais');
                  var oididioma = get(FORMULARIO+'.idioma');
                  recargaCombo(FORMULARIO+'.cbAcceso', 'SEGObtieneAccesosPorCanal', 'es.indra.sicc.util.DTOOID', [['oidPais', oidpais], ['oidIdioma', oididioma], ['oid', oidcanal]]);
                  //recargaCombo(FORMULARIO + '.cbAcceso', 'SEGObtenerAccesosPorCanal', 'es.indra.sicc.dtos.seg.DTOAccesosPorCanal', [['oidPais', oidpais], ['oidIdioma', oididioma], ['oidCanal', oidcanal]]);
         }
}

function acceso_onChange(){
         vaciaSubacceso();
         var oidacceso = get(FORMULARIO+'.cbAcceso');
         if (oidacceso != ""){
                  var oidpais = get(FORMULARIO+'.pais');
                  var oididioma = get(FORMULARIO+'.idioma');
                  //BELC300007688
                  recargaCombo(FORMULARIO+'.cbSubacceso','SegObtenerSubaccesosPorAcceso','es.indra.sicc.util.DTOOID',[['oidPais', oidpais ], ['oidIdioma', oididioma ], ['oid', oidacceso ]]);
         }
}
function vaciaSubacceso(){
          set_combo(FORMULARIO+'.cbSubacceso',[['','']],['']);
}
function vaciaAcceso(){
          set_combo(FORMULARIO+'.cbAcceso',[['','']],['']);
          vaciaSubacceso();
}
function vaciaCanal(){
          set_combo(FORMULARIO+'.cbCanal',[['','']],['']);
          vaciaAcceso();
}

// vbongiov -- Cambio 20070451 --14/11/2008
function accionBTN_Exportar(){

	 eval(FORMULARIO).oculto = 'S';
	 set(FORMULARIO+'.conectorAction', 'LPMantenimientoRegistroVentas');
	 set(FORMULARIO+'.accion', 'exportarArchivo');
	 enviaSICC(FORMULARIO, null, null, 'N');
}

function descargar(url){
	window.open("../descargas/"+url,"","height=5,width=5,status=no,toolbar=no,menubar=yes,location=no, resizable=yes");
}

function soloAlfaNumericos(cajaTexto){
	var valor = get(FORMULARIO+'.'+cajaTexto);	
	var s;
	
	for(var i=0;i<valor.length;i++){
       s=valor.charAt(i);
       if (permitidos.indexOf(s) == -1 ){
       		
       		GestionarMensaje('1256');
            focaliza(FORMULARIO+'.'+cajaTexto);
            return;
        }
   }		
}
