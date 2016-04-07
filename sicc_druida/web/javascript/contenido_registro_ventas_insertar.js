var FORMULARIO = "Formulario";
var error=false;
var guardado = false;
var clienteCompletado = true; //incidencia 13566. Variable con la que indicamos que los datos del cliente se han rellenado a partir del codigo introducido
var permitidos = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";


function onLoad(){
          configurarMenuSecundario(FORMULARIO);
          var errDescripcion = get(FORMULARIO +'.errDescripcion');
          
          if (errDescripcion !='') {
          	var errCodigo = get(FORMULARIO+'.errCodigo');
                  var wnd = fMostrarMensajeError(errCodigo, errDescripcion);
          }
         focaliza(FORMULARIO+'.cbEmpresa');
         var casodeuso = get(FORMULARIO+'.casoUso');

         if((casodeuso=='modificar')||(casodeuso=='detalle')||(casodeuso=='consultar') || (casodeuso=='eliminar') ){

					// 27/09/06 gPineda DBLG700000069
					if( get(FORMULARIO+'.cbOidEmpresa') != '' )
						set(FORMULARIO+'.cbEmpresa',[ get(FORMULARIO+'.cbOidEmpresa') ]);
					if( get(FORMULARIO+'.cbOidTipoImpuesto')  != '' )
						set(FORMULARIO+'.cbTipoImpuesto', [ get(FORMULARIO+'.cbOidTipoImpuesto') ]);
					if( get(FORMULARIO+'.cbOidCanal') != '' )
						set(FORMULARIO+'.cbCanal', [ get(FORMULARIO+'.cbOidCanal') ]);
					if( get(FORMULARIO+'.cbOidAcceso') != '' )
						set(FORMULARIO+'.cbAcceso', [ get(FORMULARIO+'.cbOidAcceso') ]);
					if( get(FORMULARIO+'.cbOidSubAcceso') != '' )
						set(FORMULARIO+'.cbSubacceso', [ get(FORMULARIO+'.cbOidSubAcceso') ]);
					if( get(FORMULARIO+'.cbOidTipoDocumentoLegal') != '' )
						set(FORMULARIO+'.cbTipoDocLegal', [ get(FORMULARIO+'.cbOidTipoDocumentoLegal') ]);
					if( get(FORMULARIO+'.cbOidTipoDocumentoRef') != '' )
						set(FORMULARIO+'.cbTipoDocLegalReferencia', [ get(FORMULARIO+'.cbOidTipoDocumentoRef') ]);

					//sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
					if( get(FORMULARIO+'.cbOidTipoDocumentoSigla') != '' )
						set(FORMULARIO+'.cbTipoDocSigla', [ get(FORMULARIO+'.cbOidTipoDocumentoSigla') ]);

                  truncar('txtImporteImpuesto');
                  truncar('totalSinFormato');
                  txt_to('lbldtImporteTotal',get(FORMULARIO+'.totalSinFormato'));
				  txt_to('lblOid',get(FORMULARIO+'.oid'));
				  
				  

                  if((casodeuso=='consultar') || (casodeuso=='eliminar') ){

                           accion(FORMULARIO+'.cbEmpresa','.disabled=true');
                           accion(FORMULARIO+'.cbTipoImpuesto','.disabled=true');
                           accion(FORMULARIO+'.cbCanal','.disabled=true');
                           accion(FORMULARIO+'.cbAcceso','.disabled=true');
                           accion(FORMULARIO+'.cbSubacceso','.disabled=true');
                           accion(FORMULARIO+'.cbTipoDocLegal','.disabled=true');
                           accion(FORMULARIO+'.cbTipoDocLegalReferencia','.disabled=true');
						   
						   //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
						   accion(FORMULARIO+'.cbTipoDocSigla','.disabled=true');
                  }
         }else{
                  txt_to('lbldtEstadoRUV','A');
                  set(FORMULARIO+'.estadoRUV', 'A');
				  
				  document.getElementById("lbldescripcionOid").style.display='none';
	    		  document.getElementById("lblOid").style.display='none';
         }

}
//Modificado por  cambio 20070451 
function calcularImporteTotal(campo){
         var separadorMiles = get(FORMULARIO+'.hid_SeparadorMiles');
         var separadorDecimales = get(FORMULARIO+'.hid_SeparadorDecimales');
         var txtimporte=get(FORMULARIO+'.txtImporteImpuesto');
         var txtbase=get(FORMULARIO+'.txtBaseImponibleNeto');
		 var txtDescuento = get(FORMULARIO+'.txtDescuento');

         //<VAR nombre="hid_NumeroDecimales" valor=""/>
         var base = obtieneNumeroDecimal(get(FORMULARIO+'.txtBaseImponibleNeto'),separadorDecimales);

         var importe = obtieneNumeroDecimal(get(FORMULARIO+'.txtImporteImpuesto'),separadorDecimales);
 
		 var descuento = obtieneNumeroDecimal(get(FORMULARIO+'.txtDescuento'),separadorDecimales); 

         if((txtbase!="")&&(campo=='txtBaseImponibleNeto')){
                  if(guardado == false){
                           if (soloNumeros(txtbase)){
                                    error = false;
                                    set(FORMULARIO+'.txtBaseImponibleNeto',formateaImporte(base, separadorMiles, separadorDecimales));
                                    set(FORMULARIO+'.baseSinFormato',base);
                                    
                           }else{
                                    error = true;
                                    GestionarMensaje('1256');
                                    focaliza(FORMULARIO+'.txtBaseImponibleNeto');
                                    return;
                           }
                  }
         }

         if((txtimporte!="")&&(campo=='txtImporteImpuesto')){
                  if(guardado == false){
                           if (soloNumeros(txtimporte)){
                                    error = false;
                                    set(FORMULARIO+'.txtImporteImpuesto',formateaImporte(importe, separadorMiles, separadorDecimales));
                                    set(FORMULARIO+'.importeSinFormato',importe);
                                    
                           }else{
                                    error = true;
                                    GestionarMensaje('1256');
                                    focaliza(FORMULARIO+'.txtImporteImpuesto');
                                    return;
                           }
                  }
         }
		 if((txtDescuento!="")&&(campo=='txtDescuento')){
                  if(guardado == false){
                           if (soloNumeros(txtDescuento)){
                                    error = false;
                                    set(FORMULARIO+'.txtDescuento',formateaImporte(descuento, separadorMiles, separadorDecimales));
                                    set(FORMULARIO+'.descuentoSinFormato',descuento);
                                    
                           }else{
                                    error = true;
                                    GestionarMensaje('1256');
                                    focaliza(FORMULARIO+'.txtDescuento');
                                    return;
                           }
                  }
         }

         if((txtbase!="")&&(txtimporte!="")){
                  if((soloNumeros(txtbase,separadorDecimales,separadorMiles)) &&
                  (soloNumeros(txtimporte,separadorDecimales,separadorMiles))){
                           var total = Number(base)+Number(importe);
                           set(FORMULARIO+'.totalSinFormato',total);
                           truncar('totalSinFormato');
                           txt_to('lbldtImporteTotal',formateaImporte(get(FORMULARIO+'.totalSinFormato'), separadorMiles, separadorDecimales));
						   

                  }
         }else{
                  txt_to('lbldtImporteTotal','');
         }
         
}

function soloNumeros(cantidad){
                   var str=cantidad;
                   var s;
                   var sepMil = get(FORMULARIO+'.hid_SeparadorMiles');
                   var sepDec = get(FORMULARIO+'.hid_SeparadorDecimales');
                   var numero = true;
                   for(var i=0;i<str.length;i++){
                           s=str.charAt(i);
                           if((s!=sepDec)&&(s!=sepMil)&&(isNaN(parseInt(s)))){
                                    numero = false;
                            }
                  }
                  return(numero);
}

function soloNumerosSinSeparador(cajaTexto) {
	
	var num = get(FORMULARIO+'.'+cajaTexto);
	
	var s;
	
	for(var i=0;i<num.length;i++){
       s=num.charAt(i);
       if(isNaN(parseInt(s))){
       		
       		GestionarMensaje('1256');
            focaliza(FORMULARIO+'.'+cajaTexto);
            return;
        }
  }
  
	
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


function esValorNumerico(cajaTexto){
		 var num = get(FORMULARIO+'.'+cajaTexto);
         if (!soloNumeros(num)){
                  GestionarMensaje('1256');
                  focaliza(FORMULARIO+'.'+cajaTexto);
                  return;
         }
}

function comprobarNumero(orden){
                   var str=orden;
                   var s;
                   var numero = true;
                   for(var i=0;i<str.length;i++){
                           s=str.charAt(i);
                           if((s=='.')||(isNaN(parseInt(s)))){
                                    numero = false;
                            }
                  }

                  if (!numero){
                           GestionarMensaje('1256');
                           focaliza(FORMULARIO+'.'+cajaTexto);
                           return;
                  }
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

//Modificado por  cambio 20070451
function fGuardar(){
 //accion="insertar_menu_principal" accion="modificar_menu_principal"
		
    if(get(FORMULARIO+'.estadoRUV') == 'A'){
           if(sicc_validaciones_generales()){
                guardado = true;
                var validado=validacionesGuardar();
				var estadoAnulado2=get(FORMULARIO+'.ckEstadoAnulado').toString();// cambio 20070451

                if (validado == true){ // cambio 20070451
                       
                     if(get(FORMULARIO+'.txtNumDocLegalFinal') != ''){ // cambio 20070451 
                    
					        if(get(FORMULARIO+'.txtNumDocLegalFinal') > get(FORMULARIO+'.txtNumDocLegal') || get(FORMULARIO+'.txtNumDocLegalFinal') == get(FORMULARIO+'.txtNumDocLegal')){ // cambio 20070451

						                if(estadoAnulado2 == 'N'){ // camobio 20070451
							                GestionarMensaje('2631');// // cambio 20070451
							                return false;
						                }else{
							                set(FORMULARIO+'.accion','guardar_menu_sec');
                                            set(FORMULARIO+'.conectorAction','LPMantenimientoRegistroVentas');
                                            guardado = false; //actualiza la variable 
                                            enviaSICC(FORMULARIO);	
											
						                }//Estado anulado
                          
				            }else{
							    	GestionarMensaje('2632');
							        return false;
                            }
                      }else{
						       set(FORMULARIO+'.accion','guardar_menu_sec');
                               set(FORMULARIO+'.conectorAction','LPMantenimientoRegistroVentas');
                               guardado = false; //actualiza la variable 
                               enviaSICC(FORMULARIO);
					  }
                            
                }else{
                         guardado = false;
                         return;
                }
           }
      } else{
                  //El registro está cerrado. Para poder modificarlo debe abrirlo antes
                   cdos_mostrarAlert(GestionarMensaje('1418'));
                   window.close();
      }
         
}
// Modificado por  cambio 20070451
function validacionesGuardar(){
		 
         var fecha = fechaValida();
         
         if(fecha != false){
                  var base = soloNumeros(get(FORMULARIO+'.txtBaseImponible')); // cambio 20070451
                  if(base == true){
					       var descuento = soloNumeros(get(FORMULARIO+'.txtDescuento'));// cambio 20070451
						   if(descuento == true){
								    var importeNeto = soloNumeros(get(FORMULARIO+'.txtBaseImponibleNeto')); // cambio 20070451
									if(importeNeto == true){
											  var importe = soloNumeros(get(FORMULARIO+'.txtImporteImpuesto'));  // cambio 20070451
											  if(importe == true){
													 return true;
											  } else{
											        GestionarMensaje('1256');
											        focaliza(FORMULARIO+'.txtImporteImpuesto');  // cambio 20070451
											        return false;
										      }
									 
							    	}else{
										    GestionarMensaje('1256');
											focaliza(FORMULARIO+'.txtBaseImponibleNeto'); // cambio 20070451
											return false;
								    }
                           }else{
								GestionarMensaje('1256');
								focaliza(FORMULARIO+'.txtDescuento'); // cambio 20070451
								return false;
							}
                          
                           
                  } else{
                           GestionarMensaje('1256');
                           focaliza(FORMULARIO+'.txtBaseImponible');
                           return false;
                  }
         } else{
                  return false;
         }
}


function fVolver(){
      //   set(FORMULARIO+'.accion','volver_menu_sec');
        // set(FORMULARIO+'.conectorAction','LPMantenimientoRegistroVentas');
         //enviaSICC(FORMULARIO);
         window.close();
}

function fLimpiar(){
         fLimpiarGenericoSICC();
         set(FORMULARIO+'.ckIndicadorTransferenciaGratuita','N');
         set(FORMULARIO+'.ckEstadoAnulado','N');
         txt_to('lbldtEstadoRUV','A');
         set(FORMULARIO+'.estadoRUV', 'A');
         vaciaSubacceso();
         vaciaAcceso();

//	27/09/06 gPineda DBLG700000069
		set(FORMULARIO+'.cbEmpresa', '');
		set(FORMULARIO+'.cbTipoImpuesto', '');
		set(FORMULARIO+'.cbCanal', '');
		set(FORMULARIO+'.cbAcceso', '');
		set(FORMULARIO+'.cbSubacceso', '');
		set(FORMULARIO+'.cbTipoDocLegal', '');
		set(FORMULARIO+'.cbTipoDocLegalReferencia', '');
		set(FORMULARIO+'.cbTipoDocSigla', '');  //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
		set(FORMULARIO+'.cbOidEmpresa', '');
		set(FORMULARIO+'.cbOidTipoImpuesto', '');
		set(FORMULARIO+'.cbOidCanal', '');
		set(FORMULARIO+'.cbOidAcceso', '');
		set(FORMULARIO+'.cbOidSubAcceso', '');
		set(FORMULARIO+'.cbOidTipoDocumentoLegal', '');
		set(FORMULARIO+'.cbOidTipoDocumentoRef', '');
		set(FORMULARIO+'.cbOidTipoDocumentoSigla', ''); //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010
		set(FORMULARIO+'.oidSeleccionado', '');
		set(FORMULARIO+'.oidCliente', '');

		set(FORMULARIO+'.txtCodCliente', '');
		set(FORMULARIO+'.txtNombre1', '');
		set(FORMULARIO+'.txtNombre2', '');
		set(FORMULARIO+'.txtApellido1', '');
		set(FORMULARIO+'.txtApellido2', '');
		set(FORMULARIO+'.txtBaseImponible', '');
		set(FORMULARIO+'.txtImporteImpuesto', '');
		set(FORMULARIO+'.txtPuntoEmision', '');
		set(FORMULARIO+'.txtSerieDocLegal', '');
		set(FORMULARIO+'.txtNumDocLegal', '');
		set(FORMULARIO+'.txtNumIdentificaionFiscal', '');
		set(FORMULARIO+'.txtNumIdentificaionNacional', '');
		set(FORMULARIO+'.txtSerieDocReferencia', '');
		set(FORMULARIO+'.txtNumDocReferencia', '');
		set(FORMULARIO+'.txtBaseImponibleNeto', ''); // cambio 20070451
		set(FORMULARIO+'.txtDescuento', '');  // cambio 20070451
		set(FORMULARIO+'.txtNumDocLegalFinal', ''); // cambio 20070451
		set(FORMULARIO+'.txtNumDocControl', ''); // sb
}
// Modificado por  cambio 20070451
function inserccionCorrecta(){
		 
         var casodeuso = get(FORMULARIO+'.casoUso');

         if(casodeuso == 'modificar'){
                  var cod_cliente=get(FORMULARIO+'.txtCodCliente').toString();
                  //var tipoImpuesto=get(FORMULARIO+'.cbTipoImpuesto').toString();
                  var tipoImpuesto=get(FORMULARIO+'.cbTipoImpuesto','T').toString();
                  var fecha_emi=get(FORMULARIO+'.txtFechaEmision').toString();
                  var base_impo=get(FORMULARIO+'.txtBaseImponible').toString();
                  
                  var importeImpuesto = get(FORMULARIO+'.txtImporteImpuesto').toString();
             	var importe_total = get(FORMULARIO+'.totalSinFormato').toString();
             	//var coeficienteImpuesto = get(FORMULARIO+'.totalSinFormato').toString();//no hacer caso a esta No se asigan en el otro lado
             	var coeficienteImpuesto = get(FORMULARIO+'.coeficienteImp').toString();
             	
             	var estadoAnulado=get(FORMULARIO+'.ckEstadoAnulado').toString();
             	if(estadoAnulado=='N'){
             		estadoAnulado='NO';
             	}else{
             		estadoAnulado='SI';
             	}
                  var estadoRuv=get(FORMULARIO+'.totalSinFormato').toString();//no hacer caso a esta No se asigan en el otro lado
                  
         
          
                   window.returnValue = [cod_cliente,tipoImpuesto,fecha_emi,base_impo,importeImpuesto,importe_total,coeficienteImpuesto,estadoAnulado,estadoRuv];
                   window.close();
                  
         } else{
                  fLimpiarGenericoSICC();
                  set(FORMULARIO+'.ckIndicadorTransferenciaGratuita','N');
                  set(FORMULARIO+'.ckEstadoAnulado','N');
                  txt_to('lbldtEstadoRUV','A');
                  set(FORMULARIO+'.estadoRUV', 'A');				  
				  fLimpiar();
				  GestionarMensaje('2633'); // cambio 20070451
         }
}

function accionBTNIMG_BuscarCliente(){
         var objParams = new Object();
         var cliente = mostrarModalSICC('LPBusquedaRapidaCliente', '', objParams, null, null);
         if(typeof cliente!='undefined') {
                  var codigoCliente = cliente[1];
                  set(FORMULARIO + '.txtCodCliente', codigoCliente);
                  set(FORMULARIO + '.txtNombre1', cliente[2]);
                  set(FORMULARIO + '.txtNombre2', cliente[3]);
                  set(FORMULARIO + '.txtApellido1', cliente[4]);
                  set(FORMULARIO + '.txtApellido2', cliente[5]);
                  //añadido por incidencia 13566
                  clienteCompletado = true;
         }
}

function fechaValida(){
	var fecha = get(FORMULARIO + '.txtFechaEmision');
	
	if (fecha != "") {
		var resul = EsFechaValida(fecha, fecha, FORMULARIO, null);
		if (resul == 1 || resul == 2) {
			GestionarMensaje('1006', get(FORMULARIO + '.hFormatoFechaPais'));
			focaliza(FORMULARIO + '.txtFechaEmision');
			return false;
		}
		else {
			return true;
		}
	}
	else {
		return false;
	}
}

function fechaValidaReferencia(){
	var	fecha = get(FORMULARIO + '.txtFechaEmisionReferencia');
         
         if(fecha != ""){
                  var resul = EsFechaValida(fecha,fecha, FORMULARIO,null);
                  if(resul==1 || resul==2){
            		GestionarMensaje('1006', get(FORMULARIO+'.hFormatoFechaPais'));
                           focaliza(FORMULARIO+'.txtFechaEmisionReferencia');
                           return false;
             		}else{
             			return true;	
             		}
         }else {
         	return false;	
        }
		
}

function comprobarFecha(){
         if(guardado == false){
                  fechaValida();
         }
}

function textCodClienteOnBlur() {
          //incidencia 13566
          if (!clienteCompletado) {
          		//Ha habido cambio en el codigo cliente, limpiamos los campos relacionados
          		set(FORMULARIO + '.oidCliente', '');
				//Mostramos nombre1, nombre2, apellido1 y apellido2 en los campos correspondientes
				set(FORMULARIO + '.txtNombre1', '');
				set(FORMULARIO + '.txtNombre2', '');
				set(FORMULARIO + '.txtApellido1', '');
				set(FORMULARIO + '.txtApellido2', '');

	          var codigoCliente = get(FORMULARIO+'.txtCodCliente').toString();
	          if (codigoCliente != '') {
	          	var longitudCodigoCliente = get(FORMULARIO+'.numDigitosCodigoCliente').toString();
	          	var longitud = codigoCliente.length;
	          	set(FORMULARIO+'.txtCodCliente',rellenaCeros(codigoCliente,longitudCodigoCliente,longitud))
	          //incidencia 13566
	          /*
	          // Método que se ejecuta al modificar el valor del campo codigoCliente 

				// Envia el formulario oculto 
				accion = "Modificar cliente" 
				formulario.oculto = "S" 
				enviaSICC(formulario) 
	          */
              
              	set(FORMULARIO+'.accion','Modificar_cliente');
         	  	set(FORMULARIO+'.conectorAction','LPMantenimientoRegistroVentas');
              	enviaSICC(FORMULARIO, null, null, "N");
	          }
        }
}

function truncar(campo) {
         var separadorDecimales = get(FORMULARIO+'.hid_SeparadorDecimales');
         var separadorMiles = get(FORMULARIO+'.hid_SeparadorMiles');
         var numdec = get(FORMULARIO+'.hid_NumeroDecimales');
         var valor = get(FORMULARIO+'.'+campo);
         array=valor.split(separadorDecimales);
         ceros = valor.split(separadorMiles);
         var miles = ceros[0];

         longitud=array.length;
         dec=array[1];
         if(longitud>1){
                  if(dec.length > numdec){
                           decAux = dec.substring(0,numdec);
                           valor = array[0]+separadorDecimales+decAux;
                           set(FORMULARIO+'.'+campo,valor);
                  } else{
                           valor = array[0]+separadorDecimales+dec;
                           set(FORMULARIO+'.'+campo,valor);
                  }
         } else{
                  if(ceros.length > 1){
                           if(ceros[ceros.length-1] == '0'){
                                    for(i=1;i<ceros.length-1;i++){
                                             miles += separadorMiles + ceros[i];
                                    }
                                    set(FORMULARIO+'.'+campo,miles);
                           }
                  }else{
                           set(FORMULARIO+'.'+campo,array[0]);
                  }
         }
}

function tipoImpuesto_onChange(){
         set(FORMULARIO+ '.cbOidTipoImpuesto',get(FORMULARIO +'.cbTipoImpuesto'));
         set(FORMULARIO+'.accion','TipoImpuesto');
         set(FORMULARIO+'.conectorAction','LPMantenimientoRegistroVentas');	
         enviaSICC(FORMULARIO,null,null,'N');
}      

function ponerCoeficiente(datos){
         
         txt_to('lbldtCoeficienteImpuesto',datos);	
        
         set(FORMULARIO+ '.coeficienteImp',datos);
         
}

function asignarDatosCliente(oid,  nombre1,  nombre2,  apellido1,  apellido2){
	/*
	Si oid != null 
{ 
Guardamos el oid del cliente 
Mostramos nombre1, nombre2, apellido1 y apellido2 en los campos correspondientes 
} 
sino 
{ 
Mostramos mensaje de error UIPED029: "Cliente no válido" 
} 

	*/
	
	if (oid != "") {
		//guardamos el oid del cliente
		set(FORMULARIO+ '.oidCliente',oid);
		//Mostramos nombre1, nombre2, apellido1 y apellido2 en los campos correspondientes
		set(FORMULARIO+ '.txtNombre1', nombre1);
		set(FORMULARIO+ '.txtNombre2', nombre2);
		set(FORMULARIO+ '.txtApellido1', apellido1);
		set(FORMULARIO+ '.txtApellido2', apellido2);
		
		
			
	} else {
		// Muestra el mensaje: "Cliente no válido" (incidencia 13566)
		GestionarMensaje('UIPED029');
		focaliza(FORMULARIO+'.txtCodCliente');

	}
	clienteCompletado = true;
	configurarMenuSecundario(FORMULARIO);
	
}

//incidencia 13566
function clienteUsuarioLupa(){
		//el usuario ha modificado el valor del codigo de cliente, clienteCompletado pasa a ser false para que en el onblur se realice la búsqueda de datos adicionales
         clienteCompletado = false;
}
	