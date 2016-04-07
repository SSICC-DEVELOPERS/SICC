function onLoadPag()
{
	configurarMenuSecundario("frmPBuscarTiposError");
	var datos = listado1.datos;
	var ultimoOidLista = datos[datos.length-1][0];
	DrdEnsanchaConMargenDcho('listado1',12);
	eval (ON_RSZ);  
	fMostrarMensajeError();
	ocultaBotones();

	i18n();
	mypgndo.ava.tipo = -2;

	var cadenaParametros = get("frmPBuscarTiposError.hidCadenaParametros");
	mypgndo.setControl("0|" + cadenaParametros); //Los parametros de la lista paginada 
	//mypgndo.avanzar();
}

// ------------------------------------------------------------------------------------------------------------------
	function ocultaBotones(){
		var casoUso = get("frmPBuscarTiposError.casoDeUso");
		//alert("casoUso: " + casoUso);
		if (casoUso == "consultar")	{
				// Oculta los botones de la lista EXCEPTO el de Detalle.
			    document.all["detalleDiv"].style.visibility='visible';	    
			    document.all["modificarDiv"].style.visibility='hidden';
				 document.all["cambiarEstatusDiv"].style.visibility='hidden';	    
		}

		if (casoUso == "modificar"){
  			 // Oculta los botones de la lista EXCEPTO el de Modificar.
		    document.all["detalleDiv"].style.visibility='hidden';	    
		    document.all["modificarDiv"].style.visibility='visible';
			 document.all["cambiarEstatusDiv"].style.visibility='hidden';	    

		}

		if (casoUso == "cambiarStatus"){
			// Oculta los botones de la lista EXCEPTO el de Cambiar Status
		    document.all["detalleDiv"].style.visibility='hidden';	    
		    document.all["modificarDiv"].style.visibility='hidden';
			 document.all["cambiarEstatusDiv"].style.visibility='visible';	    
		}

	}

// ------------------------------------------------------------------------------------------------------------------
	function codigoBusqueda(indPos){
			//alert("nuevo Indicador de Posicion: " + pos);
			var cadenaParametros = get("frmPBuscarTiposError.hidCadenaParametros");
			//alert("cadenaParametros: " + cadenaParametros);
			mypgndo.clear(); 
			mypgndo.setConector("ConectorTransactionBuscarCliente"); 
			mypgndo.setRowset("dtoSalida.resultado");        

			mypgndo.setControl("0|" + cadenaParametros); //Los parametros de la lista paginada 

			mypgndo.avanzar(); //Cargamos la primeraPagina 
	}

// ------------------------------------------------------------------------------------------------------------------
	function accionConsultar()
	{
/*					  var obj = new Object();
				     obj.dtoOid = "152";
				     obj.hidPestanya = "0";
				     obj.hidCodigoCliente = "00000010019";
      			  mostrarModalSICC('LPBusquedaCliente','consultar',obj,700,500);  */

		var oid = listado1.codSeleccionados();

		if (oid.length == 0)
		{
			GestionarMensaje("50",null,null,null);
			//alert("Debe seleccionar un elemento de la lista");
		}else if (oid.length > 1)
		{
			       cdos_mostrarAlert( GestionarMensaje("240",null,null,null) );
			       //alert("Debe seleccionar sólo un elemento de la lista");
		}else
		{
			       var codigo = listado1.extraeDato (oid,0);
 	 		       var obj = new Object();
				    obj.dtoOid = oid;
				    obj.hidPestanya = "0";
				    obj.hidCodigoCliente = codigo;
      			 mostrarModalSICC('LPBusquedaCliente','consultar',obj,700,500); 

    /*				set("frmPBuscarTiposError.conectorAction", "LPBusquedaCliente");
            set("frmPBuscarTiposError.accion", "consultar");
            set("frmPBuscarTiposError.dtoOid", oid);
            set("frmPBuscarTiposError.hidCodigoCliente", codigo); 
            set("frmPBuscarTiposError.hidPestanya", "0");
				
            enviaSICC("frmPBuscarTiposError"); */
		}


	}

// ------------------------------------------------------------------------------------------------------------------
	function fLimpiar(){
			var codigosSelec = listado1.codSeleccionados();
			var allCodes = listado1.codigos();
			var listSize = listado1.codigos().length;

			if (codigosSelec != ""){
				for (var i = 0; i < codigosSelec.length; i++){
						for (var j = 0; j < listSize; j++){
							if (allCodes[j] == codigosSelec[i])
								listado1.deselecciona(j);
						}
				 }
			}

	}

// ------------------------------------------------------------------------------------------------------------------
	function accionStatus(){
			var codigosSelec = listado1.codSeleccionados();
			//alert("codigosSelec"+codigosSelec);
			var arrIndActi = new Array();
			if (codigosSelec.length == 0){
				GestionarMensaje("50",null,null,null);
			}else{
				var posIndActi = obtenerPosicionListaEditable(codigosSelec, listado1);
				//alert("posIndActi: "+posIndActi);
				for(var p=0;p<posIndActi.length;p++){
					arrIndActi[p] = listado1.datos[posIndActi[p]][2];
				}
				
				//alert("arrIndActi: "+arrIndActi);
				set("frmPBuscarTiposError.hidIndActivo", parseaArray(arrIndActi));
				set("frmPBuscarTiposError.hidCodigosStatus", codigosSelec);
				set("frmPBuscarTiposError.conectorAction", "LPBusquedaCliente");
				set("frmPBuscarTiposError.accion", "desactivar");
				enviaSICC("frmPBuscarTiposError");

			}

 	 }
//-------------------------------------------------------------------------------------------------------------------
	function parseaArray(arrPosiciones){
		var valores = "";
		for(var i=0;arrPosiciones.length>i;i++){
			if(valores==""){
				valores = arrPosiciones[i];
//				alert("***1era vez");
			} else{
					valores = valores +","+arrPosiciones[i];	
				  }
		}
//		alert(valores);
		return valores;
	}

//-------------------------------------------------------------------------------------------------------------------
function obtenerPosicionListaEditable(arrClaves, lista){
	var posicion;
	var arrPosic = new Array();
	var clave;
//	alert("arrClaves: "+arrClaves);
	//alert("",);
	for(var j=0;arrClaves.length>j;j++){
		clave = arrClaves[j];
//		alert("clave: "+clave);
		for(var k=0;k<lista.datos.length;k++) {
				if (lista.datos[k][0] == clave) {
					posicion=k;
//					alert("posicion: "+posicion);
					break;
				}
		}        
		arrPosic[j] = posicion; 
		
	}
	return arrPosic;
}

// ------------------------------------------------------------------------------------------------------------------
	 function accionModificar() {
			var oid = listado1.codSeleccionados();

			if (oid.length == 0){
				GestionarMensaje("50",null,null,null);
				//alert("Debe seleccionar un elemento de la lista");
			} else if (oid.length > 1){
				        cdos_mostrarAlert( GestionarMensaje("240",null,null,null) );
				        //alert("Debe seleccionar sólo un elemento de la lista");
			       }else{
				        var codigo = listado1.extraeDato(oid,0);
                var obj = new Object();
                obj.dtoOid = oid;
                obj.hidPestanya = "0";
                obj.hidCodigoCliente = codigo;
                obj.hPestanya = "-1";

				/* inicio Modificado incidencia DBLG700000052 */
           		var valores = mostrarModalSICC('LPModificarCliente',"",obj); 


				if (valores != null) {
					if ((valores.length == 2) && (valores[0] != null) && (valores[1] != null)) {
						eval('frmPBuscarTiposError').oculto = "N";
						set("frmPBuscarTiposError.hRecomendado", valores[0]);
						set("frmPBuscarTiposError.hRecomendante", valores[1]);
						set("frmPBuscarTiposError.accion", "llamarAPremioRecomen");
						set('frmPBuscarTiposError.conectorAction','LPBusquedaCliente');
						enviaSICC('frmPBuscarTiposError');
					} else {
						codigoBusqueda("");
					}
				}
				/* fin Modificado incidencia DBLG700000052 */
   			}
	 }

// -------------------------------------------------------------------------------------------------------------------------------------------------------
function muestraLista( ultima, rowset){
	ocultaBotones()
	if(rowset.length > 0){
		return true;
	}else{
		return false;
	}
}

// -------------------------------------------------------------------------------------------------------------------------------------------------------
 function fVolver(){

		set("frmPBuscarTiposError.conectorAction", "LPBusquedaCliente");
		set("frmPBuscarTiposError.accion", "");

		enviaSICC("frmPBuscarTiposError");
 }

// -------------------------------------------------------------------------------------------------------------------------------------------------------
function i18n() {
	// Internacionaliza la columna de Activo de la ListaEditable. 
	listado1.actualizaDat();

	var datos = listado1.datos;
	var cantRegistros = datos.length;

	var si = GestionarMensaje("1010", null, null, null);
	var no = GestionarMensaje("1011", null, null, null);


	for ( var i = 0; i < cantRegistros; i++ ) {
		var campo = datos[i][2]; 
		var campoValor = parseInt(campo, 10);
		if (campoValor == 1) {
			campo = si;
		} else if (campoValor == 0) {
			campo = no;
		}

		datos[i][2] = campo;
	}

	listado1.setDatos(datos);
}


/*  ------------------------------------------------------------------------------------------------------------------------------------------------------- */
function retrocederPag() {
	mypgndo.retroceder();
	deshabilitarHabilitarBoton('botonContenido','detalle','A');
	deshabilitarHabilitarBoton('botonContenido','cambiarEstatus','A');
}


/* ------------------------------------------------------------------------------------------------------------------------------------------------------- */
function avanzarPag() {
	mypgndo.avanzar();
	deshabilitarHabilitarBoton('botonContenido','detalle','A');
	deshabilitarHabilitarBoton('botonContenido','cambiarEstatus','A');
}

/* ------------------------------------------------------------------------------------------------------------------------------------------------------- */
function seleccionarCliente(fila) {
    var casoDeUso = get("frmPBuscarTiposError.casoDeUso");
    var seleccionados = listado1.codSeleccionados();
    var cantSeleccionados = seleccionados.length;
    var deshabilitarBotonDetalle = false;
    var deshabilitarBotonCambiarEstatus = false;
    
    
    if (cantSeleccionados > 0) {
        var datosLista = listado1.datos;
        var cantFilas = datosLista.length;
        var oidClienteSeleccionado;
        
        for (var i = 0; i < cantSeleccionados ; i++) { // Recorro los clientes que fueron seleccionados
            oidClienteSeleccionado = seleccionados[i]; // oid del cliente actual
            
            for (var j = 0; j < cantFilas ; j++) {
                if (datosLista[j][0] == oidClienteSeleccionado) {
					
					if (casoDeUso == "consultar") { // CU CONSULTAR CLIENTE
  					    if (datosLista[j][3] == '' && datosLista[j][4] == '') { // Tipo Cliente y Subtipo Cliente son null (vacios)
					        deshabilitarBotonDetalle = true;
				        }
					}
						
					if (casoDeUso == "cambiar") {   // CU CAMBIAR ESTATUS CLIENTE
					    if (datosLista[j][2] == '') {                           // Indicador activo es null (vacio)
					        deshabilitarBotonCambiarEstatus = true;
				        }
					}
                }
		    }
		}
	} // fin if (cantSeleccionados > 0)

	if (deshabilitarBotonDetalle) {
	    deshabilitarHabilitarBoton('botonContenido','detalle','D');
    } else if (deshabilitarBotonCambiarEstatus) {
		deshabilitarHabilitarBoton('botonContenido','cambiarEstatus','D');
	} else {
	    deshabilitarHabilitarBoton('botonContenido','detalle','A');
		deshabilitarHabilitarBoton('botonContenido','cambiarEstatus','A');
	}   
}
