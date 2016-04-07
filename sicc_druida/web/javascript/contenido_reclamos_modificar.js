var FORMULARIO = 'frmContenido';

function onLoadPag() {
	    
	var errDescripcion = get(FORMULARIO + '.errDescripcion');
	if(errDescripcion != '') {
	         var errCodigo = get(FORMULARIO +'.errCodigo');
	         var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
	}
	
	configurarMenuSecundario(FORMULARIO);
	
	document.all["GenerarSolicitudes"].disabled = true;
	
	// Asignados los valores a los elementos de la pantalla. 
	// boton generar deshabilitado 
	// Llamamos a configurarPaginado pasándole los siguientes parametros: 
	// Objeto paginado (lstResultados) 
	// idBusiness ("RECObtenerDetalleModificacion") 
	// "ConectorObtenerDetalleModificacionREC" 
	// "DTODetalleReclamosREC" 
	// Parametro del DTODetalleReclamosREC: 
	// oidReclamo = oid recibido
	
	configurarPaginado(mipgndo, 
    	"RECObtenerDetalleModificacion",
        "ConectorObtenerDetalleModificacionREC",
        "es.indra.sicc.dtos.rec.DTODetalleReclamosREC",
        	[	
            	["oidPais", get(FORMULARIO + '.pais')], 
            	["oidIdioma", get(FORMULARIO + '.idioma')], 
               	["oidReclamo", get(FORMULARIO + '.oidSeleccionado')]      
            ]);
    // lbEnviaTotal <- sumatorio de la columna importeAbono de la lista de resultados 
    var separadorMiles = get(FORMULARIO+'.hid_SeparadorMiles');
   	var separadorDecimales = get(FORMULARIO+'.hid_SeparadorDecimales');
     
    var totalEnvia = get(FORMULARIO+'.totalEnvia');
	var totalEnviaFormateado = formateaImporte(totalEnvia,separadorMiles,separadorDecimales);
	txt_to('lblTotalEnvX', totalEnviaFormateado);
	
	var totalDevuelve = get(FORMULARIO+'.totalDevuelve');
	var totalDevuelveFormateado = formateaImporte(totalDevuelve,separadorMiles,separadorDecimales);
	txt_to('lblTotalDevX', totalDevuelveFormateado);
	
	var saldoAPagar = get(FORMULARIO+'.saldoAPagar');
	var saldoAPagarFormateado = formateaImporte(saldoAPagar,separadorMiles,separadorDecimales);
	txt_to('lblSaldoPagX', saldoAPagarFormateado);

}

function onClickGenerar() {
	// Llamar a CU Generar Solicitudes 
	// Llamar a la LPReclamosEnLinea con accion = "generar solicitudes" y 
	// la variable oculta numAtencion 
	
	set(FORMULARIO + '.accion', 'generar_solicitudes');
	set(FORMULARIO + '.conectorAction', 'LPReclamosEnLinea');
    enviaSICC(FORMULARIO);	
}

function fBorrar(){
	accionEliminar();
}

function accionEliminar() {
	
	if (listado1.numSelecc() == 0) {
        //Muestra el mensaje: "Debe seleccionar un elemento de la lista"
    	GestionarMensaje('50');
    }else {
		var flag = false;
	 	var oidsOperaciones = listado1.codSeleccionados();
		var oid = oidsOperaciones[0];	
    	var borra = listado1.extraeDato(oid,9);
        
    	if (borra == 'No' ){
    		flag = true;
    	}
		
		if (!flag){
		
        	set(FORMULARIO + '.oidsOperaciones',oidsOperaciones);
			//Llamamos a la LPMantenerReclamos con la accion="EliminarOperaciones",con los oid de los
			//registros seleccionados y los valores lbEnviaTotal y lbDevuelveTotal.  			
		
			var totalEnvia = get(FORMULARIO + '.totalEnvia');
			var totalDevuelve = get(FORMULARIO + '.totalDevuelve');
			
			var separadorMiles = get(FORMULARIO+'.hid_SeparadorMiles');
    		var separadorDecimales = get(FORMULARIO+'.hid_SeparadorDecimales');
    		
			var totalEnviaSinFormato = quitarSeparadorMiles(totalEnvia, separadorMiles,separadorDecimales);
			var totalDevuelveSinFormato = quitarSeparadorMiles(totalDevuelve, separadorMiles,separadorDecimales);
				
			set(FORMULARIO + '.totalEnvia',totalEnviaSinFormato);
			set(FORMULARIO + '.totalDevuelve',totalDevuelveSinFormato);
			
			set(FORMULARIO + '.accion','eliminarOperaciones');
			set(FORMULARIO + '.conectorAction','LPMantenerReclamos');
    		enviaSICC(FORMULARIO);	
            
    	}else{
    		GestionarMensaje('REC023');
    	}
	}   		
}

function mostrarLista() {
	
	var opcionMenu = get(FORMULARIO + '.opcionMenu');
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
    document.all["AgregarOperacionDiv"].style.visibility='visible';
    document.all["GenerarSolicitudesDiv"].style.visibility='visible';  
    eval (ON_RSZ);  
}

function muestraLista( ultima, rowset){                                                 
                                                                                        
	mostrarLista();
	var tamano = rowset.length; 
	if (tamano > 0) {                                                              
    	btnProxy(4, 1);                                                    
        return true;                                                             
    } else {           
        btnProxy(4, 0);                                                        
    } 
	
    
                                                 
}

function fVolver(){
	window.close();
}

function onClickAgregar () {
	
	var objParams = new Object();
    objParams.oidNumDocumento = get(FORMULARIO + '.oidNumDocumento');
	objParams.oidCliente = get(FORMULARIO + '.oidCliente');
	objParams.numAtencion = get(FORMULARIO + '.numAtencion');
	
    var datosRetorno = mostrarModalSICC('LPOperacionReclamos', 'agregar operacion', objParams, null, null); 
    
		if(datosRetorno!=undefined){
        	var operacion = "";        
            if ( 	datosRetorno.numAtencion != "" ){
            	operacion += datosRetorno.numAtencion + "@";
            } else {
            	operacion += "-@";
            }
            if ( 	datosRetorno.oidCliente != "" ){
            	operacion += datosRetorno.oidCliente + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.oidNumDocumento != "" ){
            	operacion += datosRetorno.oidNumDocumento + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.oidTipoOperacion != "" ){
            	operacion += datosRetorno.oidTipoOperacion + "@";
            	} else {
            	operacion += "-@";
            }
            if ( 	datosRetorno.oidCodOperacion != "" ){
            	operacion += datosRetorno.oidCodOperacion + "@";
            	} else {
            	operacion += "-@";
            }
            if ( 	datosRetorno.uReclamadas != "" ){
            	operacion += datosRetorno.uReclamadas + "@";
            } else {
            	operacion += "-@";
            }
            if ( 	datosRetorno.uDevueltas != "" ){
            	operacion += datosRetorno.uDevueltas + "@";
            	} else {
            	operacion += "-@";
            }
            if (	datosRetorno.totalCargo != ""){
            	operacion += parseFloat(datosRetorno.totalCargo) + "@";
            	} else {
            	operacion += "-@";
            }
            if ( 	datosRetorno.totalAbono != ""){                      
            	operacion += parseFloat(datosRetorno.totalAbono) + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.oidMotivoBloqueo != ""){
            	operacion += datosRetorno.oidMotivoBloqueo	+ "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.oidEstadoOperacion != "" ){
            	operacion += datosRetorno.oidEstadoOperacion  + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.tipoBloqueo != "" ){
            	operacion += datosRetorno.tipoBloqueo  + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.numSecOper != "" ){
            	operacion += datosRetorno.numSecOper  + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.codOper != "" ){
            	operacion += datosRetorno.codOper  + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.codTipoOper != "" ){
            	operacion += datosRetorno.codTipoOper  + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.montoPerdida != "" ){
            	operacion += datosRetorno.montoPerdida  + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.monedaDoc != "" ){
            	operacion += datosRetorno.monedaDoc  + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.docReferencia != "" ){
            	operacion += datosRetorno.docReferencia  + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.producto != "" ){
            	operacion += datosRetorno.producto  + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.clienteSeguro != "" ){
            	operacion += datosRetorno.clienteSeguro  + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.importe != "" ){
            	operacion += datosRetorno.importe  + "@";
            } else {
            	operacion += "-@";
            }
            if (	datosRetorno.asume != "" ){
            	operacion += datosRetorno.asume  + "@";
            } else {
            	operacion += "-@";
            }
                                
            set(FORMULARIO + ".hoperacion",operacion);   
                        
            var linea = "";
            for(j=0;j<datosRetorno.lista.length;j++){
                           
            	if ( datosRetorno.lista[j].numLinea != "" ){
                	linea += datosRetorno.lista[j].numLinea + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].tipoMovi != "" ){                                  
                	linea += datosRetorno.lista[j].tipoMovi + "@";           
                } else {                                                           
                	linea += "-@";                                                 
                }
                if ( datosRetorno.lista[j].oidTipoMovi != "" ){        
					linea += datosRetorno.lista[j].oidTipoMovi + "@"; 
				} else {                                                     
					linea += "-@";                                                                                  	
                }
                if ( datosRetorno.lista[j].codVenta != "" ){
                	linea += datosRetorno.lista[j].codVenta + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].codProducto != "" ){
                	linea += datosRetorno.lista[j].codProducto + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].descProducto != "" ){
                	linea += datosRetorno.lista[j].descProducto + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].unidadesReclamadas != "" ){
                	linea += datosRetorno.lista[j].unidadesReclamadas + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].motivoDevolucion != "" ){
                	linea += datosRetorno.lista[j].motivoDevolucion + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].oidMotivo != "" ){
                	linea += datosRetorno.lista[j].oidMotivo + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].precioProducto != "" ){
                	linea += datosRetorno.lista[j].precioProducto + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].importeCargo != ""){
                	linea += parseFloat(datosRetorno.lista[j].importeCargo)	+ "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].importeAbono != "" ){
                	linea += parseFloat(datosRetorno.lista[j].importeAbono)  + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].unidadesDevueltas != ""){                      
                	linea += datosRetorno.lista[j].unidadesDevueltas + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].descuentoUnitario != ""){
                	linea += datosRetorno.lista[j].descuentoUnitario + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].oidMonedaDoc != ""){
                	linea += datosRetorno.lista[j].oidMonedaDoc + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].monedaDoc != ""){
                	linea += datosRetorno.lista[j].monedaDoc + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].oidCodProducto != ""){
                	linea += datosRetorno.lista[j].oidCodProducto + "@";
                } else {
                	linea += "-@";
                }
                if ( datosRetorno.lista[j].oidCodVenta != ""){
                	linea += datosRetorno.lista[j].oidCodVenta + "@";
                } else {
                	linea += "-@";
                }
                 if ( datosRetorno.lista[j].oidTipoOferta != ""){
                	linea += datosRetorno.lista[j].oidTipoOferta + "@";
                } else {
                	linea += "-@";
                }
                linea +=  "|";                                                                                                       
			}    
            
            set(FORMULARIO + ".hlinea",linea);   
                                                              
			set(FORMULARIO + '.accion', 'actualizar reclamo');
			set(FORMULARIO + '.conectorAction', 'LPMantenerReclamos');
	    	enviaSICC(FORMULARIO);
		}
            	
        	
    			            				
}

function borrado(importeAbono,importeCargo,total){
 	
	configurarPaginado(mipgndo, 
    	"RECObtenerDetalleModificacion",
        "ConectorObtenerDetalleModificacionREC",
        "es.indra.sicc.dtos.rec.DTODetalleReclamosREC",
        	[	
            	["oidPais", get(FORMULARIO + '.pais')], 
            	["oidIdioma", get(FORMULARIO + '.idioma')], 
               	["oidReclamo", get(FORMULARIO + '.oidSeleccionado')]      
            ]);
   
	// lbEnviaTotal <- sumatorio de la columna importeAbono de la lista de resultados 
    var separadorMiles = get(FORMULARIO+'.hid_SeparadorMiles');
    var separadorDecimales = get(FORMULARIO+'.hid_SeparadorDecimales');
    
	var abonoFormateado = formateaImporte(importeAbono,separadorMiles,separadorDecimales);
	txt_to('lblTotalEnvX', abonoFormateado);
	
	set(FORMULARIO + '.totalEnvia',abonoFormateado);
	var cargoFormateado = formateaImporte(importeCargo,separadorMiles,separadorDecimales);
	txt_to('lblTotalDevX', cargoFormateado);
	
	set(FORMULARIO + '.totalDevuelve',cargoFormateado);
	var totalFormateado = formateaImporte(total,separadorMiles,separadorDecimales);
	txt_to('lblSaldoPagX', totalFormateado);            
}

function agregado(importeAbono,importeCargo,total){
 	
	configurarPaginado(mipgndo, 
    	"RECObtenerDetalleModificacion",
        "ConectorObtenerDetalleModificacionREC",
        "es.indra.sicc.dtos.rec.DTODetalleReclamosREC",
        	[	
            	["oidPais", get(FORMULARIO + '.pais')], 
            	["oidIdioma", get(FORMULARIO + '.idioma')], 
               	["oidReclamo", get(FORMULARIO + '.oidSeleccionado')]      
            ]);
              
    document.all["GenerarSolicitudes"].disabled = false;
            
    var separadorMiles = get(FORMULARIO+'.hid_SeparadorMiles');
    var separadorDecimales = get(FORMULARIO+'.hid_SeparadorDecimales');
   
	var abonoFormateado = formateaImporte(importeAbono,separadorMiles,separadorDecimales);
	txt_to('lblTotalEnvX', abonoFormateado);
	
	set(FORMULARIO + '.totalEnvia',abonoFormateado);
	var cargoFormateado = formateaImporte(importeCargo,separadorMiles,separadorDecimales);
	txt_to('lblTotalDevX', cargoFormateado);
	
	set(FORMULARIO + '.totalDevuelve',cargoFormateado);
	var totalFormateado = formateaImporte(total,separadorMiles,separadorDecimales);
	txt_to('lblSaldoPagX', totalFormateado);
	                      
}

function error(){
	var tam = listado1.datos.length;
	
	if (tam > 0){
		btnProxy(4, 1);   
	}else{
		btnProxy(4, 0);   
	}
}

function formateaImporte(numeroDecimal, separadorMiles, separadorDecimales){
    var dineroEntrada = "" + numeroDecimal;
    var negativo = false;
    if (dineroEntrada.indexOf('-') == 0) {
                dineroEntrada = dineroEntrada.replace('-', '');
                negativo = true;
    }
    var tokens = dineroEntrada.split('.');
    var bufferEntero = tokens[0];// almacena la parte entera.
    var bufferDinero = "";//almacena el resultado
    var bufferDecimales = "";//almacena la parte decimal
    if (tokens.length > 1)
                bufferDecimales = tokens[1];
    while (bufferEntero.length > 0) {
                if (bufferEntero.length > 3) {
                            bufferDinero = separadorMiles + bufferEntero.substr(bufferEntero.length-3) + bufferDinero ;
                            bufferEntero = bufferEntero.substr(0, bufferEntero.length-3);
                } else {
                            bufferDinero = bufferEntero.substr(0) + bufferDinero ;
                            bufferEntero = "";
                }
    }
    if (bufferDecimales != "") {
                if (bufferDecimales != "0" && bufferDecimales != "00") {
                            bufferDinero = bufferDinero + separadorDecimales + bufferDecimales;
                }
    }
    if (negativo)
                            bufferDinero = '-' + bufferDinero;
    return bufferDinero;
}

function quitarSeparadorMiles(cantidad, separadorMiles,separadorDecimales) {
         var resultado = '';
         var cantidadString=new String(cantidad);
         if(cantidadString!=""){
                  var arrayNumero=cantidadString.split(separadorDecimales);
                  var numeroEntero=arrayNumero[0];
                  var decimales="";
                  if(arrayNumero[1]!=undefined){
                           decimales=new String(arrayNumero[1]);                                 
                  }
                  var numeroEnteroSep=numeroEntero.split(separadorMiles);
                  for (n=0;n<numeroEnteroSep.length;n++){
                           resultado=resultado+numeroEnteroSep[n];
                  }
                  if(decimales!=""){
                           resultado=resultado+"."+decimales;
                  }
         }        
         return resultado;
}         

