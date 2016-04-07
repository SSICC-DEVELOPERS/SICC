var varNoLimpiarSICC = true;
//inc 21620
var totalUnidRecla = 0;

/*var objControlProductosDevuelve = null;*/  /* Poblado al retornar del CU Buscar Productos. */
// -------------------------------------------------------------------------------------------------------------------------------------
function onLoadPag() {

   configurarMenuSecundario("frmContenido");
   fMostrarMensajeError();

   DrdEnsanchaConMargenDcho('listado1',12);
   document.all["Cplistado1"].style.visibility='visible';
   document.all["CpLin1listado1"].style.visibility='visible';
   document.all["CpLin2listado1"].style.visibility='visible';
   document.all["CpLin3listado1"].style.visibility='visible';
   document.all["CpLin4listado1"].style.visibility='visible';
   document.all["separaDiv"].style.visibility='visible';
   document.all["primera1Div"].style.visibility='visible';
   document.all["ret1Div"].style.visibility='visible';
   document.all["ava1Div"].style.visibility='visible';
   eval (ON_RSZ);  

         /* Deshabilita boton Buscar Producto  */
         btnProxy(1,0);   // Por defecto, deshabilita el boton Guardar.
         deshabilitarHabilitarBoton('botonContenido', 'BuscarProd', 'D');

         var existeOperacion = get("frmContenido.existeOperacion"); 

}

// -------------------------------------------------------------------------------------------------------------------------------------
function onChangeCodigoOperacion() {
         var opSeleccionada = get("frmContenido.cbCodOper");

         if ( opSeleccionada == "" )
         {
			  /* Limpiamos el combo Tipo Operacion */
			  var arrayVacio = ["",""];
			  set_combo("frmContenido.cbCodTipoOper", arrayVacio);
         } else {
			  /* Armamos el array del DTO */
			  var array = new Array(); 
			  array[0] = ['oid', opSeleccionada];
	 
			  /* Recargamos combo Tipo Operacion */ 
			  recargaCombo('frmContenido.cbCodTipoOper',
															  'RECObtenerTiposOperacionAgregar', 
															  'es.indra.sicc.util.DTOOID', 
											array);	

			  setTimeout('ValorTipoOperDefe();',400);

		 }
	
}

function ValorTipoOperDefe(){
				
		var numElem = combo_get('frmContenido.cbCodTipoOper', 'L', null);

		if ( numElem > 1 )	{
		
			var codigo = combo_get('frmContenido.cbCodTipoOper', 'V', 1);

			if (codigo != "")	{
				var arrayN = codigo.split(",");
				set('frmContenido.cbCodTipoOper', arrayN );
			}
		}

}

// -------------------------------------------------------------------------------------------------------------------------------------
function onClickAceptar() {

         if ( sicc_validaciones_generales() ) {
                  var opSeleccionada = get("frmContenido.cbCodOper");
                  var tipoOperacionSelecc = get("frmContenido.cbCodTipoOper");

                  set("frmContenido.conectorAction", "LPOperacionReclamos"); 
                  set("frmContenido.accion", "obtenerIndicadoresOperacion");
                  set("frmContenido.oidOperacion", opSeleccionada);
                  set("frmContenido.oidTipoOperacion", tipoOperacionSelecc);

                  eval("frmContenido").oculto = "S";

                  /* Luego de volver de la LP continua en "manejoAnulacion()" */ 
                  /* Si hay error, continua en errorIndicadores */ 
                  enviaSICC("frmContenido");
         }
}

// -------------------------------------------------------------------------------------------------------------------------------------
function errorIndicadores() { 
         fLimpiar();
}

// -------------------------------------------------------------------------------------------------------------------------------------
function manejoAnulacion(params) {

                  /* Params tiene el sig. formato "Ind1;Ind2;...", valores posibles: "0" o "1"
                     El orden de los indicadores es el sig. 
                                    - bIngresaDevuelve
                                    - bIngresaEnvia
                                    - bEnviaGeneraDevuelve
                                    - bDevuelveGeneraEnvia
                                    - bDevuelveFisicoFactura
                                    - bDevuelveFactura
                                    - bEnviaFactura
                                    - bAnulacion
                                    - bPerdida
                                    - sChequeoFisico
									- sPrecioEnvia, que devuelve C(atalago) o F(actura)
                  */

                  /* Guardo los params en variables de formulario para posterior uso */
                  var arrayParams = params.split(";");
                  btnProxy(1,0);
                  set("frmContenido.hIngresaDevuelve", arrayParams[0]); 
                  set("frmContenido.hIngresaEnvia", arrayParams[1]);
                  set("frmContenido.hEnviaGeneraDevuelve", arrayParams[2]); 
                  set("frmContenido.hDevuelveGeneraEnvia", arrayParams[3]);
                  set("frmContenido.hDevuelveFisicoFactura", arrayParams[4]);
                  set("frmContenido.hDevuelveFactura", arrayParams[5]);
                  set("frmContenido.hEnviaFactura", arrayParams[6]);
                  set("frmContenido.hAnulacion", arrayParams[7]);
                  set("frmContenido.hPerdida", arrayParams[8]);
                  set("frmContenido.sChequeoFisico", arrayParams[9]);
				  set("frmContenido.sPrecioEnvia", arrayParams[10]);
				  set("frmContenido.matriz", arrayParams[11]);
				  set("frmContenido.hRecojo", arrayParams[12]);


                  var anulacion = arrayParams[7]; 

                  if ( anulacion == '1') {
                           /* Chequea si ya existe una operacion */
                           var existeOperacion = get("frmContenido.existeOperacion"); 
                           if ( existeOperacion == 'true') {

                                    /* alert("No se puede ingresar una Operación de anulación al existir operaciones definidas en el Reclamo ");*/
                                    /* No se puede ingresar una Operación de anulación al existir operaciones definidas en el Reclamo */
                                    GestionarMensaje("REC027");

                                    window.close();

                           } else { 

                                    /* Armo DTOOID */
                                    var pais = get('frmContenido.pais');
                                    var idioma = get('frmContenido.idioma');
                                    var numDocumento = get('frmContenido.oidNumDocumento');
                                    var sOpeAEliminar = get('frmContenido.opeAEliminar');
									


                                    var array = new Array();
                                    array[0] = ['oidDocumentoReferencia', numDocumento];
									array[1] = ['oidPais', pais];
                                    array[2] = ['oidIdioma', idioma];

									/*array[2] = ['tamanioPagina', 999999]; pisar 2 veces la misma posicion del array no ayuda*/
                                    
									array[3] = ['opeAEliminar', sOpeAEliminar];

                                    /* Realizo Paginado */ 
                                    configurarPaginado( mipgndo, 
                                                                                                     'RECBuscarProductosAnulacion', 
                                                                                                     'ConectorBuscarProductosAnulacion',
//'es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado',
																	                                 'es.indra.sicc.dtos.rec.DTOReclamo',
																										array);
                                    /* (Continua ejecucion en "muestraLista()" )*/

                           }
                  
                  } else {
                           /* No es anulacion */ 
                           deshabilitarHabilitarBoton('botonContenido', 'BuscarProd', 'A');
							
						   // vbongiov -- Cambio 20080756 -- 29/04/2009		
						   var opSeleccionada = get("frmContenido.cbCodOper");
						   set("frmContenido.oidOperacion", opSeleccionada);
						   set("frmContenido.accion", "validarFaltantes");
                           set("frmContenido.conectorAction", "LPOperacionReclamos");
						   eval("frmContenido").oculto = "S";
                           enviaSICC("frmContenido", null, null, "N");

                  }
                  
                  /* Deshabilita capa de Datos Operacion*/
                  manejoCapa("true");

}

// vbongiov -- Cambio 20080756 -- 29/04/2009
function mostrarMensaje() {
    // Documento de referencia con chequeo conforme
	if (GestionarMensaje('2637')) { 
		buscarCampanya();

	} else {
		close();
	}
  
}


// vbongiov -- Cambio 20080756 -- 29/04/2009
function buscarCampanya() {

   var tipoOperacion = get("frmContenido.cbCodTipoOper");

   set("frmContenido.accion", "buscarCampanya");
   set("frmContenido.conectorAction", "LPOperacionReclamos");
   set("frmContenido.oidTipoOperacion", tipoOperacion);
   eval("frmContenido").oculto = "S";
   enviaSICC("frmContenido", null, null, "N");
}

// vbongiov -- Cambio 20080756 -- 29/04/2009
function ejecutarErrorValidarFaltantes() {
  focalizaBotonHTML('botonContenido','btnAceptar');
}


// -------------------------------------------------------------------------------------------------------------------------------------
function muestraLista(ultima,rowset,error) {

         error = cdos_trim(error);

         if (error != "") { 
                  var codigoErrorExisteReclamo = get('frmContenido.hCodErrorExisteReclamo');
                  fLimpiar(); 
         
                  if (error.indexOf(codigoErrorExisteReclamo) != -1){
                           window.close();
                           return false;
                  }
         }

         if ( rowset.length > 0 ) {
                  return true;
         } else {
                  return false;
         }
}

// -------------------------------------------------------------------------------------------------------------------------------------
function manejoCapa(estado) {
         accion("frmContenido.cbCodOper" , ".disabled=" + estado);
         accion("frmContenido.cbCodTipoOper" , ".disabled=" + estado);
         accion("frmContenido.cbMotivoBloq" , ".disabled=" + estado);

         if ( estado == 'true' ) {
                  deshabilitarHabilitarBoton('botonContenido', 'btnAceptar', 'D');
         } else {
                  deshabilitarHabilitarBoton('botonContenido', 'btnAceptar', 'A');
         }
         
}

// -------------------------------------------------------------------------------------------------------------------------------------
function onClickBuscarProducto() {

         /* Muestra Modal Busqueda Productos */ 
         var obj = new Object(); 
         var numeroLinea = 	obtieneNumeroLinea();
    var existeLinea = false;
         numeroLinea++;
         obj.oidOperacion = get("frmContenido.cbCodOper"); 
         obj.oidTipoOperacion = get("frmContenido.cbCodTipoOper");
         obj.oidNumDocumento = get("frmContenido.oidNumDocumento");
         obj.oidCliente = get("frmContenido.oidCliente");
         obj.numeroLinea = numeroLinea;
         obj.ingresaDevuelve = get("frmContenido.hIngresaDevuelve");
         obj.ingresaEnvia = get("frmContenido.hIngresaEnvia");
         obj.enviaGeneraDevuelve = get("frmContenido.hEnviaGeneraDevuelve");
         obj.devuelveGeneraEnvia = get("frmContenido.hDevuelveGeneraEnvia");
         obj.devuelveFisicoFactura = get("frmContenido.hDevuelveFisicoFactura");
         obj.devuelveFactura = get("frmContenido.hDevuelveFactura");
         obj.enviaFactura = get("frmContenido.hEnviaFactura");
         obj.recojo = get("frmContenido.hRecojo");

	 	 obj.precioEnvia = get("frmContenido.sPrecioEnvia");
    /* alert("get('frmContenido.controlProductosDevuelve'): " + get("frmContenido.controlProductosDevuelve"));*/
         obj.controlProductosDevuelve = get("frmContenido.controlProductosDevuelve");
         obj.matriz = get("frmContenido.matriz");
		 /* Invoca a Buscar Productos */ 
         var objRetorno = mostrarModalSICC("LPOperacionReclamos", "buscarProducto", obj);
         if (objRetorno != null && objRetorno != undefined) {
                  /* Guarda datos de Control de Producto */ 
                  set("frmContenido.controlProductosDevuelve", objRetorno.controlProductosDevuelve);
        // listado1.eliminar(listado1.datos.length-1); se elimina por incidencia 972 de v35
                  /* Maneja datos de Salida de Buscar Productos */ 
                  var retorno = objRetorno.arrayLineas;
                  if (retorno != null && retorno != undefined) {

                            var cantProductos = retorno.length;
                            var objLinea = null;
                            var datosToAdd = new Array();
                            var datosLista = listado1.datos;
                            

                            for (var i = 0; i < cantProductos; i++ ) {
                                     objLinea = retorno[i];

                                     /* alert("NumeroLinea:"  + numeroLinea
                                                   + "\n TipoMovimiento: " + objLinea.tipoMovimiento
                                                   + "\n Cód. venta: " + objLinea.codigoVenta
                                                        + "\n Cód. producto: " + objLinea.codigoProducto
                                                        + "\n Descripción producto: " + objLinea.descripcion
                                                        + "\n Nº unid. reclamadas: " + objLinea.unidadesAReclamar
                                                        + "\n Motivo devolución: " + objLinea.motivoDevolucion
                                                        + "\n Precio producto: " + objLinea.precioFacturaUnitario
                                                        + "\n Importe cargo: " + objLinea.importeCargo
                                                        + "\n Importe abono: " + objLinea.importeAbono
                                                        + "\n Nº unid. devueltas: " + objLinea.unidadesADevolver
                                                        + "\n Monto Perdida (''): "
                                                        + "\n Val_tota_paga_xxx (''): "
                                                        + "\n OidTipoMovimiento: " + objLinea.oidTipoMovimiento
                                                        + "\n OidTipoOferta: " + objLinea.oidTipoOferta
                                                        + "\n MFCA_OID_CABE: " + objLinea.oidCodVenta
                                                        + "\n Oid Producto: " + objLinea.oidProducto
                                                        + "\n Oid Motivo Devolucion: " + objLinea.oidMotivoDevolucion
                                                        + "\n Descuento: " + objLinea.descuentoUnitario
                                                        + "\n Precio Perdida: " + objLinea.precioCatalogoUnitario);*/

									 // Selecciona el precio a utilizar
									 var precio = "";

									 if(objLinea.tipoMovimiento=='D') {
										 precio = objLinea.precioFacturaUnitario;
									 }

									 if(objLinea.tipoMovimiento=='E') {
										 if(get('frmContenido.sPrecioEnvia')=='F') {
											 precio = objLinea.precioFacturaUnitario;
										 } else if(get('frmContenido.sPrecioEnvia')=='C') {
											 precio = objLinea.precioCatalogoUnitario;
										 }
									 }

									/* Calculo de Importe Abono */
									/* Se utiliza numeroDeFormatoSICC */
									var numberUnidadesAReclamar = numeroDeFormatoSICC(objLinea.unidadesAReclamar);
									var numberPrecio = numeroDeFormatoSICC(precio);
									var nUnidadesAReclamar = numberUnidadesAReclamar.valueOf();
									var nPrecio = numberPrecio.valueOf();
									// var importeAbono = nUnidadesAReclamar * nPrecio;

                                     var filaNueva = [numeroLinea,
                                                                                            numeroLinea,
                                                                                            objLinea.tipoMovimiento,
                                                                                            objLinea.codigoVenta,
                                                                                            objLinea.descripcion,  // Descripcion Producto
                                                                                            objLinea.unidadesAReclamar,
                                                                                            /* se reemplaza precioFacturaUnitario por precioCatalogoUnitario, por  */
                                                                                            /* inc DBLG500000907 */
                                                                                            /*objLinea.precioFacturaUnitario,*/ // ?? Precio Factura Unitario ??? 
																							/*objLinea.precioCatalogoUnitario,*/
																							precio,
                                                                                            objLinea.importeCargo,
                                                                                            objLinea.importeAbono,
                                                                                            objLinea.codigoProducto,
                                                                                            objLinea.motivoDevolucion,
																							objLinea.unidadesADevolver,
                                                                                            "",  // Monto Perdida
                                                                                            "",  // Val_tota_paga_xxx ??? == objLinea.precioTotal ????
                                                                                            objLinea.oidTipoMovimiento,  // OidTipoMovimiento
                                                                                            objLinea.oidTipoOferta,  // OidTipoOferta
                                                                                            objLinea.oidCodVenta,  // MFCA_OID_CABE
                                                                                            objLinea.oidProducto,  // Oid Producto
                                                                                            objLinea.oidMotivoDevolucion,  // Oid Motivo Devolucion
                                                                                            objLinea.descuentoUnitario,
                                                                                            objLinea.precioCatalogoUnitario,
																						    objLinea.oidPosicion,
																							objLinea.oidConcurso,
																							objLinea.oidNivel,
																							objLinea.oidPremio,
																							objLinea.precioContableUnitario];

//                                       alert("LineaNueva: " + 	filaNueva);
                                      existeLinea = this.chequeaExistenciaProducto(filaNueva);
                                      if (!existeLinea) {
                                                datosLista[datosLista.length] = filaNueva;
                                                numeroLinea++;
                                      }else{
                                        //inc 21620
										if(listado1.datos[i]!=null){
											listado1.datos[i][6]= totalUnidRecla;
											listado1.datos[i][10]= (totalUnidRecla * listado1.datos[i][8]);
										}
									  }
                            }
                            listado1.repintaDat();

                            /*listado1.setDatos(datosLista); */
                            /* para repintar cambios */
                            validarPerdida();
                  }

         }

}

// -------------------------------------------------------------------------------------------------------------------------------------
function chequeaExistenciaProducto(lineaAChequear) {
         
         /* Chequea linea por linea de la ListaEditable, 
            e indica si la linea de entrada ya se ha insertado anteriormente */ 
         var datos = listado1.datos; 
         var cantFilas = datos.length; 
         var bEquality = false;
         var separadorMiles = get("frmContenido.hSeparadorDecimalPais");


         if ( cantFilas > 0) {
                  /* Si ya existen Lineas en la Lista Editable, busca que no se repita */ 
                  var lineaExistente = null;
                  var importeExistente =0;
                  var importeAChequear =0;
                  totalUnidRecla=0
                  for (var i = 0; (i < cantFilas) && (!bEquality); i++ ) {
                           lineaExistente = datos[i];
                           bEquality = this.comparaLinea(lineaExistente, lineaAChequear); 
                           // inc 21620
                           importeExistente = lineaExistente[6];
                           importeAChequear = lineaAChequear[6];
                           
                           importeExistente = obtieneNumeroDecimal(importeExistente, separadorMiles);
                           importeAChequear = obtieneNumeroDecimal(importeAChequear, separadorMiles);

                           totalUnidRecla = parseFloat(importeExistente, 10) + parseFloat(importeAChequear, 10); 				
                  }
         } else {
                  /* Si no existen lineas en la Lista Editable, indica q la linea no existe */ 
                  bEquality = false;
         }

         return bEquality;

}

// -------------------------------------------------------------------------------------------------------------------------------------
function comparaLinea(linea1, linea2) {

         /* Las Lineas tienen el sig. formato: 
                           N° Linea (oculto) 0 
                           Nº línea 
                           Tipo movimiento 
                           Cód. venta 
                           Cód. producto 
                           Descripción producto 5
                           Nº unid. reclamadas 
                           Motivo devolución 
                           Precio producto 
                           Importe cargo 
                           Importe abono 10 
                           Nº unid. devueltas 

                           Monto Perdida 
                           Val_tota_paga_xxx
                           OidTipoMovimiento  
                           OidTipoOferta  15
                           MFCA_OID_CABE
                           Oid Producto 
                           Oid MotivoDevolucion
                           Descuento  
                           Precio Perdida 	20
						   Oid Posicion Solic
                           
                  Nota: No se toman en cuenta los dos campos "N° Linea" ni "Monto Perdida"	*/

         var longLinea = linea1.length;
         var bEqual = true;
         var campoLinea1 = null;
         var campoLinea2 = null;

         /* Comienzo en indice 2 (Tipo Movimiento). */
         for (var i = 2; (i < longLinea) && (bEqual); i++) {
                  /* Salteo indice 13 (Monto Perdida)  
                  Salteo Precio Producto i 6 
                  Salteo Importe Cargo i 9
                  Salteo Importe Abono 10
                  Salteo Importe Nro unid recla i 11*/	
                           
                  
                  if (i != 12 && i != 6 && i != 9 && i !=11 && i !=10 ) {
                           //alert('linea1[i]  '+ linea1[i] + ' linea2[i] '+ linea2[i] ) ;
                           campoLinea1 = linea1[i];
                           campoLinea2 = linea2[i];
                           

                           if ( campoLinea1 != campoLinea2) {
                                    /*alert("Distintas en campo " + i);*/
                                    bEqual = false;
                           }
                  }
                  
         }

         return bEqual;
}

// -------------------------------------------------------------------------------------------------------------------------------------
function obtieneNumeroLinea() {
         listado1.actualizaDat();
         var cantRegistros = listado1.codigos().length;
         return cantRegistros;
}


// -------------------------------------------------------------------------------------------------------------------------------------
function validarPerdida() {
         
         var oidOperacion = get("frmContenido.cbCodOper");
         var indPerdida = get("frmContenido.hPerdida");

         var datos = listado1.datos;
         if ( datos.length > 0) {
                  btnProxy(1,1);
                  if(get("frmContenido.hAnulacion")=='1'){
                           this.actualizaSumaImportes();
                  }
                  /* Solamente chequeo perdida si la operacion es de Perdida */ 
                  if (indPerdida == "1" ) {

                           /* Chequeo si ya existen datos de perdida para esa operacion */ 
                           var arrayRetorno = existenDatosPerdida(oidOperacion);
                           if ( arrayRetorno == null ) {
                                    /* Si no existen datos Perdida para la operacion, levanto el caso de uso Introducir Datos Perdida */ 
                                    var obj = new Object();
                                    arrayRetorno = mostrarModalSICC("LPCapturaProcesoReclamos", "buscar", obj);
                           }

                           /* Chequeo que arrayRetorno no sea null (si es null, indica q se ha llamado a
                             Introducir Datos Perdida y no se ha completado correctamente la ejecucion del mismo */
                           if ( arrayRetorno == null || arrayRetorno == undefined) {
                                    GestionarMensaje("REC029", null, null, null); 
                                    fLimpiar();
                                    btnProxy(1,0);   /* Deshabilita el boton Guardar. */
                           } else {
                                    calcularMontoPerdida(arrayRetorno);
                                    agregaOpListaPerdida(oidOperacion, arrayRetorno);
                           }

                  }

                  return;
         } 


}


// -------------------------------------------------------------------------------------------------------------------------------------
function actualizaSumaImportes() {

         /* Suma el campo Importe Abono de todas las lineas */ 
         var datos = listado1.datos;

         var cantRegistros = datos.length;
         var separadorMiles = get("frmContenido.hSeparadorDecimalPais");
         var sumaImportesAbono = 0;
         var importeTotalPagar = 0;	
         var importesAbono = 0;

         

         for (var  i = 0; i < cantRegistros; i++) {
                  var importeAbonoCampo = datos[i][10]
				  listado1.datos[i][11] = 0; //cambio SC-REC-10 se setea en 0 las unidades a devolver para todas las lineas
				  if ( importeAbonoCampo == null || importeAbonoCampo == "") {
                           importeAbonoCampo = 0;
                  }
                  importeAbonoCampo = obtieneNumeroDecimal(importeAbonoCampo, separadorMiles);
                  importeTotalPagar = datos[0][13];
                  sumaImportesAbono = parseFloat(sumaImportesAbono, 10) + parseFloat(importeAbonoCampo, 10); 
                  //txt_to("lbldtImporteCabeceraDevolver", sumaImportesAbono); // comentado por inc. 22744
         }
/*
         incidencia 22744 */ 

         importeTotalPagar = obtieneNumeroDecimal(importeTotalPagar, separadorMiles);
         if ( importeTotalPagar == null || importeTotalPagar == "") {
                  importeTotalPagar = 0;
         }
         importeTotalPagar = obtieneNumeroDecimal(importeTotalPagar, separadorMiles);

         importesAbono = Math.abs(parseFloat(importeTotalPagar, 10)) - parseFloat(sumaImportesAbono, 10); 
         importesAbono = obtieneNumeroDecimal(importesAbono, separadorMiles);
		 var a="";
         var filaNueva  =  [cantRegistros, a, a, a, a, "Cargos adicionales",  a, a, a, a, importesAbono, a, a, a, a, a, a, a, a, a,a];
         var importeAMostrar = Math.abs(importeTotalPagar);
         var filaNueva2 =  [cantRegistros, a, a, a, a, "Total Factura",  a, a, a, a, importeAMostrar, a, a, a, a, a, a, a, a,a,a];
         listado1.insertar(filaNueva);
         listado1.insertar(filaNueva2);
         listado1.actualizaDat();
    

         /* Muestra capa de Importe */
         /*var capa = document.getElementById("capa1");
         capa.style.visibility = 'visible';
    */
}


// -------------------------------------------------------------------------------------------------------------------------------------
function existenDatosPerdida(oidOperacion) {
         
         var longListaOperaciones = lstOperacionesPerdida.length;
         var arrayRetorno = null;
         var bMatch = false;

         for (var i = 0; (i < longListaOperaciones) && (!bMatch); i++)	{
                   var oidOperacionLista = lstOperacionesPerdida[i][0];
                   if (parseInt(oidOperacion, 10) == parseInt(oidOperacionLista, 10) ) {
                            arrayRetorno = new Array();
                            arrayRetorno[0] = lstOperacionesPerdida[i][1]; /* OidCliente */
                            arrayRetorno[1] = lstOperacionesPerdida[i][2]; /* OidAsumePerdida */
                            arrayRetorno[2] = lstOperacionesPerdida[i][3]; /* Precio Calculo */ 
                            arrayRetorno[3] = lstOperacionesPerdida[i][4]; /* PorcentajeRecargo */
                            arrayRetorno[4] = lstOperacionesPerdida[i][5]; /* OidProductoSeguro */
                            arrayRetorno[5] = lstOperacionesPerdida[i][6];  /* OidClienteSeguro */
                            arrayRetorno[6] = lstOperacionesPerdida[i][7];  /* ImporteSeguro */
                            bMatch = true;
                   }
         }
         return arrayRetorno;
         
}

// -------------------------------------------------------------------------------------------------------------------------------------
function agregaOpListaPerdida(oidOperacion, params) {
         
         /* Similar a existenDatosPerdida, agrega la parametrizacion de la operacion si no 
                  existe en la lista "listaOperacionesPerdida" */ 
         var longListaOperaciones = lstOperacionesPerdida.length;
         var bMatch = false;
         /* Chequea la existencia de la operacion */
         for (var i = 0; (i < longListaOperaciones) && (!bMatch); i++)	{
                   var oidOperacionLista = lstOperacionesPerdida[i][0];
                   if (parseInt(oidOperacion, 10) == parseInt(oidOperacionLista, 10) ) {
                            bMatch = true;
                   }
         }
         /* No hubo coincidencias, asi q agrega la operacion junto con su parametrizacion de Perdida, 
                  en la lista */
         if ( !bMatch) {
                  lstOperacionesPerdida[lstOperacionesPerdida.length] = [oidOperacion,
                                                                                                                          params[0], /* OidCliente */
                                                                                                                          params[1], /* OidAsumePerdida */ 
                                                                                                                          params[2], /* Precio Calculo */ 
                                                                                                                          params[3], /* Porcentaje Recargo */ 
                                                                                                                          params[4], /* OidProductoSeguro */ 
                                                                                                                          params[5], /* OidClienteSeguro */ 
                                                                                                                          params[6]]; /*  Importe Seguro */ 
                  //listaOperacionesPerdida.setDatos(datosLista);
    }

}

// -------------------------------------------------------------------------------------------------------------------------------------
function calcularMontoPerdida(params) {
	var oidAsumeCliente = get("frmContenido.constantesAsumeCliente");
	var oidPrecioPerdida = get("frmContenido.constantesPrecioPerdida");

	var oidAsumePerdida = params[1];
	var precioCalculo = params[2];

	if (oidAsumePerdida == oidAsumeCliente ) {
		var separadorMiles = get("frmContenido.hSeparadorDecimalPais");
		var datos = listado1.datos;
		var cantRegistros = datos.length;
                   
		var porcentajeRecargo = obtieneNumeroDecimal(params[3], separadorMiles);
		porcentajeRecargo = parseFloat(porcentajeRecargo, 10);

		if (precioCalculo  == oidPrecioPerdida) {
			for (var i = 0; i < cantRegistros; i++) {
				var precioCatalogoUnit = obtieneNumeroDecimal(datos[i][20], separadorMiles);
				var dtoUnitario = obtieneNumeroDecimal(datos[i][19], separadorMiles);
				var nroUnidadesReclamadas = obtieneNumeroDecimal(datos[i][6], separadorMiles);
				precioCatalogoUnit = parseFloat(precioCatalogoUnit, 10);
				dtoUnitario = parseFloat(dtoUnitario, 10);
				nroUnidadesReclamadas = parseFloat(nroUnidadesReclamadas, 10);

				// inc DBLG400001083   var montoPerdida = (precioCatalogoUnit - dtoUnitario) * nroUnidadesReclamadas * porcentajeRecargo / 100;
				/* var montoPerdida = (precioCatalogoUnit - dtoUnitario) *  porcentajeRecargo / 100; */

				/* inc DBLG700000023 */
				var montoPerdida = (precioCatalogoUnit - dtoUnitario) + (precioCatalogoUnit - dtoUnitario) * porcentajeRecargo / 100;

				/*alert("(" + precioCatalogoUnit  + " - " + dtoUnitario + ") * " + nroUnidadesReclamadas + " * " + porcentajeRecargo + " / 100;");*/
				datos[i][12] = montoPerdida;
			}
		} else {
			for (var i = 0; i < cantRegistros; i++) {
				var precioCatalogoUnit = obtieneNumeroDecimal(datos[i][20], separadorMiles);
				var nroUnidadesReclamadas = obtieneNumeroDecimal(datos[i][6], separadorMiles);
				precioCatalogoUnit = parseFloat(precioCatalogoUnit, 10);
				nroUnidadesReclamadas = parseFloat(nroUnidadesReclamadas, 10);

				// inc DBLG400001083    var montoPerdida = precioCatalogoUnit * nroUnidadesReclamadas * porcentajeRecargo / 100;
				/* var montoPerdida = precioCatalogoUnit * porcentajeRecargo / 100; */

				/* inc DBLG700000023 */
				var montoPerdida = precioCatalogoUnit + precioCatalogoUnit * porcentajeRecargo / 100;

				/*alert(precioCatalogoUnit + " * " + nroUnidadesReclamadas + " * " + porcentajeRecargo + " / 100;");*/
				datos[i][12] = montoPerdida;
			}
		}
	}
}


// -------------------------------------------------------------------------------------------------------------------------------------
function cambiarCampanya(flag) {
         /* Se invoca desde la LPOperacionReclamos, a través de un asignar("VAR", "ejecutar"...); */
         btnProxy(1,0);

         if ( flag == "1"){
                   /* "El tipo de operacion permite la seleccion de otra campaña, ¿desea cambiarla? "  */
         var mensaje = GestionarMensaje('REC031');
         var  cambiarCampanya = cdos_mostrarConfirm(mensaje);
			
                  if ( !cambiarCampanya ) {

               /*            var obj = new Object();
                           var tipoOperacion = get("frmContenido.cbCodTipoOper");
                           var oidNumDoc = get("frmContenido.oidNumDocumento");
                           var oidCliente = get("frmContenido.oidCliente"); 

                           obj.tipoOperacion = tipoOperacion;
                           obj.oidNumDoc = oidNumDoc;
                           obj.oidCliente = oidCliente;

                           var retorno = mostrarModalSICC("LPOperacionReclamos", "cambiar campanya", obj);
                           if (retorno != undefined && retorno != null) {
                                    /* Asigno a oidNumDocumento el valor del Oid Doc. seleccionado en la pantalla anterior */
                          /*          var array = retorno.split("|");
                                    var oidNuevoDoc = array[0];
                                    var codNuevoDoc = array[1];
                                    set("frmContenido.oidNumDocumento", oidNuevoDoc);
                                    set("frmContenido.numDocumento", codNuevoDoc);
                           }*/
						   fLimpiar();
                  }
         }

}

// -------------------------------------------------------------------------------------------------------------------------------------
function fGuardar() {
         var codOperacion = get("frmContenido.cbCodOper");
         var xmlLista = this.listaToXML();
         set("frmContenido.oidOperacion", codOperacion); 
         set("frmContenido.conectorAction", "LPOperacionReclamos");
         set("frmContenido.accion", "guardar operacion");
         set("frmContenido.hListaLineasOperacion", xmlLista);
         
         
         eval("frmContenido").oculto = "S";
         enviaSICC("frmContenido", null, null, "N");

}

// -------------------------------------------------------------------------------------------------------------------------------------
function listaToXML() {

         var separadorMiles = get("frmContenido.hSeparadorDecimalPais");

         var arrayNombreCampos = new Array();
         arrayNombreCampos[0] = "N. linea";
         arrayNombreCampos[1] = "N. linea";
         arrayNombreCampos[2] = "Tipo movimiento";
         arrayNombreCampos[3] = "Cod. venta";
         arrayNombreCampos[4] = "Descripcion producto";
         arrayNombreCampos[5] = "N. unid. reclamadas";
         arrayNombreCampos[6] = "Precio producto";
         arrayNombreCampos[7] = "Importe cargo";
         arrayNombreCampos[8] = "Importe abono";
         arrayNombreCampos[9] = "Cod. producto";
         arrayNombreCampos[10] = "Motivo devolucion";
		 arrayNombreCampos[11] = "N. unid. devueltas";
         arrayNombreCampos[12] = "Monto Perdida";
         arrayNombreCampos[13] = "Val_tota_paga";
         arrayNombreCampos[14] = "OidTipoMovimiento";
         arrayNombreCampos[15] = "OidTipoOferta";
         arrayNombreCampos[16] = "MFCA_OID_CABE";
         arrayNombreCampos[17] = "Oid Producto";
         arrayNombreCampos[18] = "Oid MotivoDevolucion";
         arrayNombreCampos[19] = "Descuento";
         arrayNombreCampos[20] = "Precio Perdida";
		 arrayNombreCampos[21] = "Oid Posicion Solic";

		 arrayNombreCampos[22] = "Oid Concurso";
		 arrayNombreCampos[23] = "Oid Nivel";
		 arrayNombreCampos[24] = "Oid Premio";
		 arrayNombreCampos[25] = "Importe Contable";


/*     var oXml = new ActiveXObject("Msxml2.DOMDocument.5.0");
          var encabezado = 
                           oXml.createProcessingInstruction("xml", "version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"yes\"");

          oXml.loadXML("<DOC/>");
          oXml.insertBefore(encabezado, oXml.childNodes.item(0));


          var datos = listado1.datos;
          var cantFilas = datos.length;
          var linea = null;
          var campo = null;
          var oAtributo = null;
          var oCampo = null;
          for (var i = 0; i < cantFilas; i++) {
                  linea = datos[i]; 
             var oRow = oXml.createElement("ROW");
                  var cantCampos = linea.length;
                  for (var j = 0; j < cantCampos; j++ ) {
                           campo = linea[j]; 
                           if (j == 6 || j == 8 || j == 9 || j == 10 || j == 11) {
                                    if ( campo != "") {
                                             campo = campo + "";
                                             campo = obtieneNumeroDecimal(campo, separadorMiles);
                                    }
                           }
                           oCampo = oXml.createElement("CAMPO");
                           oCampo.setAttribute("nombre", arrayNombreCampos[j]);
                           oCampo.text = campo;
                           oRow.appendChild(oCampo);
                  }

                  oXml.documentElement.appendChild(oRow);

         }
         return oXml.xml; */

         var xmlDoc = "<?xml version='1.0' encoding='ISO-8859-1' standalone='yes'?>";

         xmlDoc = xmlDoc + "<DOC>";
         var datos = listado1.datos;
         var cantFilas = datos.length;
         var ultimaLinea = 1;
         if(get("frmContenido.hAnulacion")=='1')	{
                  cantFilas = cantFilas - 2;
         }
         
         /* Recorre las filas */ 

         for (var i = 0; i < cantFilas; i++) {
         
                 
                           var linea = datos[i]; 
//                           alert(linea);
						   xmlDoc = xmlDoc + "<ROW>";
                           /* Recorre los campos dentro de la fila */

                           var cantCampos = linea.length;

                           
                           for (var j = 0; j < cantCampos; j++ ) {
                                    /* Quito formato local de numero */ 
                                    var campo = linea[j]; 
                                    if (j == 6 || j == 8 || j == 9 || j == 10 || j == 11) {
                                             if ( campo != "") {
                                                      if (campo == undefined || campo == "undefined"){
														  campo = "";
                                                      }
													  campo = campo + "";
                                                      campo = obtieneNumeroDecimal(campo, separadorMiles);
                                             }
                                    }

                                    xmlDoc = xmlDoc + "<CAMPO nombre='" + arrayNombreCampos[j] + "'>" + SICC_DrdEscXML(campo) + "</CAMPO>";

                           }
                           xmlDoc = xmlDoc + "</ROW>"
                 
         }
         xmlDoc = xmlDoc + "</DOC>";
         
         return xmlDoc; 
}

// -------------------------------------------------------------------------------------------------------------------------------------
function generaCadenaLista() {
         
         var datos = listado1.datos; 
         var cantRegistros = datos.length;
         var cadena = "";

         for (var i = 0; i < cantRegistros; i++ ) {
                  var linea = datos[i];
                  var cantCampos = linea.length;

                  if (i != 0) {
                           cadena = cadena + "|";
                  }
                  for (var j = 0;  j < cantCampos; j++) {
                           var campo = linea[j];
                           if ( j != 0) {
                                    cadena = cadena + "@";
                           }
                           if (campo == null || campo == undefined || campo == "") {
                                    cadena = cadena + " ";
                           } else {
                                    cadena = cadena + campo;
                           }
                  }
         }
         return cadena;
}


// -------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar() {
         limpiarControlProductos();
		 listado1.setDatos( new Array() );
         set("frmContenido.cbCodOper", new Array("") );
         set("frmContenido.cbMotivoBloq", new Array("") );
         this.onChangeCodigoOperacion();
         this.manejoCapa("false"); /* Habilita la capa. */
         btnProxy(1,0);   /*  Deshabilita el boton Guardar. */

         /* Restauro Oid Num. Doc. original (en caso que se haya cambiado) */ 
         set("frmContenido.oidNumDocumento", get("frmContenido.oidNumDocumentoOriginal") );
         set("frmContenido.numDocumento", get("frmContenido.numDocumentoOriginal") );

         deshabilitarHabilitarBoton('botonContenido', 'BuscarProd', 'D');

}

// -------------------------------------------------------------------------------------------------------------------------------------
function armaObjetoOperacionesPerdida() {
         /* Retorna un Object con */ 
         var cantOperaciones = lstOperacionesPerdida.length;
         var arrayOperaciones = new Array();
         /* alert("lstOperacionesPerdida: " + lstOperacionesPerdida); */

         var objOperacion = null;
         for (var i = 0; i < cantOperaciones; i++ ) {
                  objOperacion = new Object(); 
                  objOperacion.oidOperacion = lstOperacionesPerdida[i][0];
                  objOperacion.oidCliente = lstOperacionesPerdida[i][1];
                  objOperacion.oidAsumePerdida = lstOperacionesPerdida[i][2];
                  objOperacion.precioCalculo = lstOperacionesPerdida[i][3];
                  objOperacion.porcentajeRecargo = lstOperacionesPerdida[i][4];
                  objOperacion.oidProductoSeguro = lstOperacionesPerdida[i][5];
                  objOperacion.oidClienteSeguro = lstOperacionesPerdida[i][6];
                  objOperacion.importeSeguro = lstOperacionesPerdida[i][7]; 

                  arrayOperaciones[i] = objOperacion;
         }
         return arrayOperaciones;
}

// -------------------------------------------------------------------------------------------------------------------------------------
function obtieneDescOperacion(oidOperacion) {
         var cantOps = lsOperacion.length;
         var bMatch = false;
         var descRetorno = "";
         for (var i = 0; (i < cantOps) && (!bMatch); i++ ) {
                  var oidOperacionArray = lsOperacion[i][0];
                  if (parseInt(oidOperacionArray, 10)  == parseInt(oidOperacion, 10)  ) {
                           descRetorno = lsOperacion[i][2];
                           bMatch = true;
                  }	
         }
         return descRetorno;
}

// -------------------------------------------------------------------------------------------------------------------------------------
function armaObjetoDatosLista(sDatosLista) {
         
         var arrSalida = new Array();
         var arr = new Array();
         arr = sDatosLista.split("|");

         var arrLineas = new Array();
         
         for (var i=0;i< arr.length ; i++){
                  arrLineas[arrLineas.length] = arr[i].split("~");
         }
         
         var arrayLineasOperaciones = new Array();
         var objLineaOperacion = null;
		for (var j = 0; j < arrLineas.length; j++ ) {
			var atributos = arrLineas[j];
			/* alert("atributos[" + i + "]: " + atributos); */
			objLineaOperacion = new Object(); 
			objLineaOperacion.numLinea = atributos[0];
			objLineaOperacion.tipoMovimiento = atributos[1];
			objLineaOperacion.oidTipoMovimiento = atributos[2];
			objLineaOperacion.codVenta = atributos[3];
			objLineaOperacion.codProducto = atributos[4];
			objLineaOperacion.descProducto = atributos[5];
			objLineaOperacion.uReclamadas = atributos[6];
			objLineaOperacion.motivoDevolucion = atributos[7];
			objLineaOperacion.oidMotivoDevolucion = atributos[8];
			objLineaOperacion.precioProducto = atributos[9];
			objLineaOperacion.importeCargo = atributos[10];
			objLineaOperacion.importeAbono = atributos[11];
			objLineaOperacion.uDevueltas = atributos[12];
			objLineaOperacion.oidCodigoVenta = atributos[13];
			objLineaOperacion.oidCodigoProducto = atributos[14];
			objLineaOperacion.montoPerdida = atributos[15];
			objLineaOperacion.descuentoUnitario = atributos[16];
			objLineaOperacion.oidPosicion = atributos[17];
			objLineaOperacion.oidTipoOferta = atributos[18];
			objLineaOperacion.oidConcurso = atributos[19];
			objLineaOperacion.oidNivel = atributos[20];
			objLineaOperacion.oidPremio = atributos[21];
			objLineaOperacion.precioContable = atributos[22];

			arrSalida[arrSalida.length] = objLineaOperacion;
		}
		return arrSalida;
}


// -------------------------------------------------------------------------------------------------------------------------------------
function funcionRetornoSSSS(sExisteOperacionAnulacion, sExisteOperacion, sChequeoFisico, sDatosBloqueo, sDatosLista) {
         var objRetorno = new Object(); 

         /* Manejo de existencia de operacin de Anulacion */ 
         objRetorno.existeOperacionAnulacion = sExisteOperacionAnulacion;
         objRetorno.existeOperacion = sExisteOperacion;

         /* Datos de Operacion / Tipo Operacion seleccionada */ 
         var oidOperacion = get("frmContenido.cbCodOper"); 
         var oidTipoOperacion = get("frmContenido.cbCodTipoOper");
         var oidMotivoBloqueo = get("frmContenido.cbMotivoBloq");
         var codOperacion = get("frmContenido.cbCodOper", "T"); 
         var codTipoOperacion = get("frmContenido.cbCodTipoOper", "T");
         var descOperacion = this.obtieneDescOperacion(oidOperacion);
         var oidNumDocumento = get("frmContenido.oidNumDocumento");
         var numDocumento = get("frmContenido.numDocumento");
         var objControlProductosDevuelve = get("frmContenido.controlProductosDevuelve");

         objRetorno.oidOpSeleccionada = oidOperacion;
         objRetorno.oidTipoOpSeleccionada = oidTipoOperacion;
         objRetorno.oidMotivoBloqueo = oidMotivoBloqueo;
         objRetorno.descRetorno = descOperacion;
         objRetorno.codOperacion = codOperacion;
         objRetorno.codTipoOperacion = codTipoOperacion;
         objRetorno.oidNumDocumento = oidNumDocumento;
         objRetorno.numDocumento = numDocumento;

         objRetorno.controlProductosDevuelve = objControlProductosDevuelve;

         /* Chequeo Fisico */ 
         objRetorno.chequeoFisico = sChequeoFisico; 

         /* lstOperacionesPerdida */
         var arrayOperaciones = this.armaObjetoOperacionesPerdida();
         objRetorno.operacionesPerdida = arrayOperaciones;

         /* Datos Bloqueo */ 
         var objDatosBloqueo = new Object();
         var datosBloqueo = sDatosBloqueo.split(";");

         if (datosBloqueo[0] == "null"){ datosBloqueo[0] = null; }
         if (datosBloqueo[1] == "null"){ datosBloqueo[1] = null; }
         if (datosBloqueo[2] == "null"){ datosBloqueo[2] = null; }

         objDatosBloqueo.oidMotivoBloqueo = datosBloqueo[0];
         objDatosBloqueo.oidEstadoOperacion = datosBloqueo[1];
         objDatosBloqueo.tipoBloqueo = datosBloqueo[2];
		 //alert(" 12 "+get("frmContenido.hDevuelveFactura"));
         objRetorno.datosBloqueo = objDatosBloqueo; 

         /* Datos Lista */ 
         objRetorno.datosLista = this.armaObjetoDatosLista(sDatosLista);
		 //alert(" aaa"+objRetorno.datosLista[0].oidPosicion);
         /* objControlProductosDevuelve */ 

         
         returnValue = objRetorno;
         window.close();
         
}

// ------------------------------------------------------------------------------------------------------------------------------------- 
function fVolver() {
         window.close();
}


// ------------------------------------------------------------------------------------------------------------------------------------- 
function onShTabComboOperacion() {
         /* Si boton Productos esta habilitado */
         var btnBuscaProd = document.getElementById("BuscarProd");

         if (btnBuscaProd.disabled) { 
                   /* Focaliza Aceptar */
                   focalizaBotonHTML("botonContenido", "btnAceptar")
         } else {
                   focalizaBotonHTML_XY("BuscarProd");
    }

}

// ------------------------------------------------------------------------------------------------------------------------------------- 
function onShTabBuscarProducto() {
         var btnAceptar = document.getElementById("btnAceptar");

         if (!btnAceptar.disabled) {
                  /* Lo focalizo */
                   focalizaBotonHTML("botonContenido", "btnAceptar")
         } 	
                  /* Si el boton Aceptar está deshabilitado, el resto de los controles de la capa tambien...
                           No se hace nada en ese caso.*/
}


// ------------------------------------------------------------------------------------------------------------------------------------- 
function onTabAceptar(){
         /* Chequea si Productos esta habilitado */ 
         var btnBuscaProd = document.getElementById("BuscarProd");

         if (btnBuscaProd.disabled) { 
                   /* Focaliza Combo Operacion */
                   focaliza("frmContenido.cbCodOper", "");
         } else {
                   focalizaBotonHTML_XY("BuscarProd");
    }

}

// ------------------------------------------------------------------------------------------------------------------------------------- 
function onTabBuscarProducto() {
         /* Chequea si Operacion esta habilitado */
         var cbOperacion = document.getElementById("cbCodOper");

         if ( !cbOperacion.disabled) {
        focaliza("frmContenido.cbCodOper", "");
         }

}


function limpiarControlProductos(){


        var str = get("frmContenido.controlProductosDevuelve");
		var objLinea = new Object();
		var arrayLineas = str.split('|');
		var linea = new Array();
		var strLinea = '';
		var strSalida = '';
		var numero = "";
		var encontrado = false;
		
		if (str != null && str != undefined && str != ''){
			for (var i = 0; i < arrayLineas.length; i++){
				linea = arrayLineas[i].split(',');

				objLinea = new Object();
				objLinea.oidPosicion = linea[0];
				objLinea.unidadesReclamadas = linea[1];
				objLinea.unidadesDisponibles = linea[2];
    			for(h=0;h<listado1.datos.length;h++){ 
					if(listado1.datos[h][21]==objLinea.oidPosicion){			
						numero = h;
						encontrado = true;
						break;
					}	
				}
				if (encontrado == true){

					objLinea.unidadesReclamadas = new Number(objLinea.unidadesReclamadas) - new Number(listado1.datos[numero][11]);
					objLinea.unidadesDisponibles = new Number(objLinea.unidadesDisponibles) + new Number(listado1.datos[numero][11]);
					strLinea = objLinea.oidPosicion + ',' + objLinea.unidadesReclamadas + ',' + objLinea.unidadesDisponibles;
					if (strSalida == null || strSalida == undefined || strSalida == ''){
						strSalida = strLinea;
					} else {
						strSalida += '|' + strLinea;
					}
				}else{
					strLinea = objLinea.oidPosicion + ',' + objLinea.unidadesReclamadas + ',' + objLinea.unidadesDisponibles;

					if (strSalida == null || strSalida == undefined || strSalida == ''){
						strSalida = strLinea;
					} else {
						strSalida += '|' + strLinea;
					}
				}
			
			}
		set("frmContenido.controlProductosDevuelve",strSalida);
	   }
}