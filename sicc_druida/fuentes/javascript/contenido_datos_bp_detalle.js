var criterioAsignacionGlobal = "";
var varNoLimpiarSICC = true;
// ------------------------------------------------------------------------------------------------------------
function carga()
{
		// *************
		// * Onload  *
		// *************
		configurarMenuSecundario("frmUnico");
		fMostrarMensajeError();

		// Agregado por ssantana, 14/12/2004
		// Inc. 11448. - Si el combo estado no contiene ningún valor, entonces se deshabilita (ya que la actividad
		// no tiene asociado ningún estado).
		var cantFilasComboEstado = combo_get("frmUnico.cbEstado", "L");
		if (cantFilasComboEstado == 1)  // Solo el combo con el valor ""
		 	    accion("frmUnico.cbEstado" , ".disabled=true");


		// Modificacion 29/12/2004 - el TextBox Codigo de Venta se deshabilita siempre (ya que el usuario no lo introduce a mano)
		accion("frmUnico.txtCodVenta" , ".disabled=true");


		var casoUso = get("frmUnico.casoUso");
		//alert(casoUso);
		//alert("CasoUso: " + casoUso);
		if ( casoUso == "detalle")
		{
			// Mapea las variables de detalle a los controles corresp.
			seteaPantalla();

			// Modificado por incidencia SiCC20070189
            // No se deshabilita nada para estados 1,2,3
			
			// Deshabilita el campo Forma de Pago si Forma de Cobro es  "Gratis"
			//onchangeFormaCobro();
			// Agregado por ssantana, 23/11/2005, inc. 21444
			//seleccionaComboFormaPago();
			seleccionaComboFormaCobro();
			seleccionComboFormaPago();
			accion("frmUnico.cbFormaPago" , ".disabled=true");
			accion("frmUnico.cbFormaCobro" , ".disabled=true");
			setRequerido("cbFormaPago", false);
			setRequerido("cbFormaCobro", false);
			setMV("frmUnico.cbFormaPago","c"); 
			setMV("frmUnico.cbFormaCobro","c"); 
			// Fin Agregado por ssantana, 23/11/2005, inc. 21444

			/* Agregado por ssantana, inc. 18072, 23/6/2005
			   Si existe una Lista de Clientes, deshabilita los campos 
			   - cmbSubgerencia
			   - cmbRegión
			   - cmbZona
			   - cmbTerritorio
			   - txtObservaciones
			   - cmbSubtipoCliente
			   - cmbTipoClasificación
			   - cmbClasificación
			   - cmbEstado
			   - cmbCriterioAsignacion */

			var listaClientes = get("frmUnico.varListaCliente");
			if ( listaClientes != "" )
				manejaPantallaPorListaClientes()
			// Fin Agregado ssantana, inc. 18072, 23/6/2005

			//setRequerido("cbPeriodoFin", false);
			setMV("frmUnico.cbPeriodoFin" , "c");
			setMV("frmUnico.atxtObservaciones" , "c");
			setMV("frmUnico.txtCodProducto" , "c");
			setMV("frmUnico.txtCodVenta" , "c");
			setMV("frmUnico.txtPrecioEstandar" , "c");
			setMV("frmUnico.txtBaseDestinatarios" , "c");
			setMV("frmUnico.txtFactorCorreccion" , "c");
			setMV("frmUnico.txtPromedio" , "c");
			setMV("frmUnico.txtUnidades" , "c");
			setMV("frmUnico.txtCriterio" , "c");
            
            // Agregado por Rafael Romero
            // SiCC 20070189 - 23/04/2007
            // Modificaciones para manejar los diferentes estados en accion de "detalle"
            // Si estadoProceso = 4 deshabilitar todo
            var estadoProceso = get('frmUnico.varEstadoProceso');
            
            if(estadoProceso=="4"){
                // Deshabilitar todo
                accion("frmUnico.cbTipoOferta" , ".disabled=true");
                
                accion("frmUnico.txtCodProducto" , ".disabled=true");
                accion("frmUnico.cbTipoOferta" , ".disabled=true");
                accion("frmUnico.cbCicloVida" , ".disabled=true");
                accion("frmUnico.txtBaseDestinatarios" , ".disabled=true");
                accion("frmUnico.txtFactorCorreccion" , ".disabled=true");
                accion("frmUnico.txtCriterio" , ".disabled=true");
                accion("frmUnico.txtPromedio" , ".disabled=true");
                accion("frmUnico.txtUnidades" , ".disabled=true");
                accion("frmUnico.atxtObservaciones" , ".disabled=true");
                accion("frmUnico.cbPeriodoFin" , ".disabled=true");
                accion("frmUnico.txtPrecio" , ".disabled=true");
                accion("frmUnico.txtPrecioEstandar" , ".disabled=true");
                accion("frmUnico.txtPrecioContable" , ".disabled=true");
                accion("frmUnico.cbTipoDespacho" , ".disabled=true");
                accion("frmUnico.cbEnvioSolicitud" , ".disabled=true");
                accion("frmUnico.cbAcceso" , ".disabled=true");
                accion("frmUnico.cbSubacceso" , ".disabled=true");
                accion("frmUnico.cbSubgerencia" , ".disabled=true");
                accion("frmUnico.cbRegion" , ".disabled=true");
                accion("frmUnico.cbZona" , ".disabled=true");
                accion("frmUnico.cbSubtipoCliente" , ".disabled=true");
                accion("frmUnico.cbTipoClasificacionCliente" , ".disabled=true");
                accion("frmUnico.cbClasificacionCliente" , ".disabled=true");
                accion("frmUnico.cbEstado" , ".disabled=true");
                accion("frmUnico.cbCriterioAsignacion" , ".disabled=true");
                //accion("frmUnico.rbEnviarMensaje2" , ".disabled=true");
                accion("frmUnico.cbCodMensaje2" , ".disabled=true");
                //document.all["btnListaClientes"].disabled=true;
                document.all["rbEnviarMensaje2"][0].disabled=true;
                document.all["rbEnviarMensaje2"][1].disabled=true;
            }

		} else
		{
			// Si no es Detalle (es Nueva Entrada), deja seteado el RadioButton de Envio Mensaje con el valor
			// "S"
			set("frmUnico.rbEnviarMensaje2", "S");
			set("frmUnico.rbEnviarMensaje3", "S");
            
            // Agregado por SICC20070356 - Rafael Romero - 05/09/2007
            establecerValoresDefecto();
            // Fin agregado SICC20070356
            
		}

		cambiaRadio2();
		cambiaRadio3();

}

// ------------------------------------------------------------------------------------------------------------
function fGuardar()
{
	// *******************************************
	//  Llama al método de la LP que graba 
	// *******************************************

	// ------------------------------------------------
	//	    Primero realiza validaciones 
	// ------------------------------------------------
	//alert("a");
	if( !sicc_validaciones_generales("todos") )
		return;

	// Inc. 15553, 7/4/2005, ssantana
	// Si Tipo Clasificacion tiene valor, entonces es obligatorio seleccionar una Clasificacion
	/*var tipoClasificacion = get("frmUnico.cbTipoClasificacionCliente");
	if ( tipoClasificacion != "")
	{
		if ( !sicc_validaciones_generales("grupoTipoClasificacion") )
				return;
	}*/

	//alert(get("frmUnico.cbClasificacionCliente") );
	//var clasificacionCliente = get("frmUnico.cbClasificacionCliente");
	//set("frmUnico.varClasificacionCliente", clasificacionCliente);
		
	var casoUso = get("frmUnico.casoUso");
//	alert(casoUso);
	if ( casoUso == "detalle") {
	//	alert("entro a 3a")	;
		setMV("frmUnico.cbCodMensaje3","c"); 
		setMV("frmUnico.cbCodMensaje2","c"); 
		if ( !sicc_validaciones_generales("cbCodMensaje2") ){

		//	alert("cb 2" + get("frmUnico.cbCodMensaje2"));
		//	alert("cb 3" + get("frmUnico.cbCodMensaje3"));
		//	alert("entro a 3b")	;
			return;
		}
	} else {
      //   alert("entro a 2a")	;
		setMV("frmUnico.cbCodMensaje2","c"); 
		setMV("frmUnico.cbCodMensaje3","c"); 
		if ( !sicc_validaciones_generales("cbCodMensaje3") ){

		//	alert("cb 2" + get("frmUnico.cbCodMensaje2"));
		//	alert("cb 3" + get("frmUnico.cbCodMensaje3"));
		//	alert("entro a 2b")	;
			return;
		}
	}

	var varValidaPrecioContable = get("frmUnico.varValidaPrecioContable");
	if(varValidaPrecioContable != "") {
		if(varValidaPrecioContable == "1") {
			var txtPrecio = get("frmUnico.txtPrecio");
			var txtPrecioContable = get("frmUnico.txtPrecioContable");
			
			if(txtPrecio == "") {
				txtPrecio = "0";
				set("frmUnico.txtPrecio", "0");
			}
			if(txtPrecioContable == "") {
				txtPrecioContable = "0";
				set("frmUnico.txtPrecioContable", "0");
			}
			
			if(parseFloat(txtPrecio)==0) {
				if(parseFloat(txtPrecioContable)==0) {
					GestionarMensaje('3392', null, null, null);
				    focaliza("frmUnico.txtPrecioContable", "");
			 	    return;
				}
			}
		}
	} else {
		GestionarMensaje('3393', null, null, null);
	    focaliza("frmUnico.txtPrecio", "");
 	    return;
	}

	// ssantana, 23/6/2005
	// inc. 18072 - Solamente se exige que se haya seleccionado algún Criterio y Subcriterio, si no se ha
	// elegido Lista Clientes. 
	// Valida que se halla elegido algun subcriterio (Esto implica que se ha entrado a alguna de las 3 modales
	// y se ha elegido los elementos que corresponden).

	var listaCliente = get("frmUnico.varListaCliente");
	
	if ( listaCliente == "" ) {
		  // Primero valido que el combo Criterio Asignación tenga valor.
  		  if (!sicc_validaciones_generales("criterioAsignacion") )
			return; 

		  // Ahora valida que se haya elegio algún subcriterio.
  		  var subcriterio = get("frmUnico.varSubcriterio");
		  if ( subcriterio == "") {
		  	  GestionarMensaje("1386", null, null, null);
			  return;
		  }
	} else {
		/* 
			Agregado por ssantana, 26/04/2006,
			1- Valido que haya valor en uno de los campos Unidades y Promedio.
			2- Valido que ambos campos campos no tengan valores (solo uno puede tenerlo 
			   a la vez). 
			Nota: El formato ya se ha validado mas arriba en esta misma funcion.

		*/
		var txtPromedio = get("frmUnico.txtPromedio");
		var txtUnidades = get("frmUnico.txtUnidades");

		if (txtPromedio == "" && txtUnidades == "") {
		   GestionarMensaje('MAV100', null, null, null);
	       if (txtPromedio == "") {
    		  focaliza("frmUnico.txtPromedio", "");
	       } else if (txtUnidades == "") {
			  focaliza("frmUnico.txtUnidades", "");
		   }
		   return;
		}

		if (txtPromedio != "" && txtUnidades != "") {
		   GestionarMensaje('MAV101', null, null, null);
		   focaliza("frmUnico.txtPromedio", "");
		   return;
		}
		/* 
			Fin Agregado por ssantana, 26/04/2006
		*/
	}


	eval("frmUnico").oculto="S";
	set("frmUnico.conectorAction", "LPCompletaDatosBP");
	set("frmUnico.accion", "guardar");
	//alert("Envia");
	enviaSICC("frmUnico");

}

// ------------------------------------------------------------------------------------------------------------
function seteaVars()
{
	// *****************************************************************************************
	//   Setea las vars. de form. correspondientes con los valores de los elementos
	// *****************************************************************************************


	return;


}

// ------------------------------------------------------------------------------------------------------------
function cambiaAcceso()
{
		// Refresca el combo subacceso con los valores correspondientes segun
		// lo cliqueado en acceso
		var codSeleccionados = get("frmUnico.cbAcceso");
		//alert("Acceso: " + codSeleccionados);
		var arraySubAcceso = new Array();
		arraySubAcceso[0] = ["",""];
		var z = 1;

		for (var i = 0; i < codSeleccionados.length; i++)
		{
			 var codigoActual = codSeleccionados[i];
			 var longListaSubAccesos = listaSubaccesos.datos.longitud;

			 for (var n = 0; n < longListaSubAccesos; n++ )
			 {
				 if ( listaSubaccesos.datos.ij(n, 2) == codigoActual )
				 {
					 var oid = listaSubaccesos.datos.ij(n, 0);
					 var desc = listaSubaccesos.datos.ij(n, 1);
					 var newArray = new Array();
					 newArray[0] = oid;
					 newArray[1] = desc;
					 arraySubAcceso[z] = newArray;
					 z++;
				 }
			 }
		}
  	    set_combo("frmUnico.cbSubacceso", arraySubAcceso);
}

// ------------------------------------------------------------------------------------------------------------
function cambiaRegion()
{
		var codSeleccionados = get("frmUnico.cbSubgerencia");
		var arrayRegiones = new Array();
		arrayRegiones[0] = ["",""];
		//gacevedo, segun incidencia SiCC 20070095
		//armamos un objeto que contenga las claves de
		//subgerencia seleccionadas
		var objSubgerencias = new Object();
		for (var i = 0; i < codSeleccionados.length; i++){
			//por cada subgerencia seleccionada, agregamos una "propiedad" al objeto
			//de modo luego de poder preguntar por ella. (gacevedo 13/03/2007)
			objSubgerencias[codSeleccionados[i]+""]=true;
		}
		//ahora, usando el objeto previo, recorremos las regiones
		//que estan ordenadas por descripcion. si todo sale bien
		//se seleccione lo que se seleccione en las subgerencias,
		//las regiones se mostraran ordenadas por descripcion. (gacevedo 13/03/2007)
		var longListaRegiones = listaRegiones.datos.longitud;
		for (var n = 0; n < longListaRegiones; n++){
			var regActual = listaRegiones.datos.ij(n, 0)+"";
			if(objSubgerencias[regActual]){
				var oid = listaRegiones.datos.ij(n, 1);
				var desc = listaRegiones.datos.ij(n,2);
				var newArray = new Array();
				newArray[0] = oid;
				newArray[1] = desc;
				arrayRegiones[arrayRegiones.length] = newArray;
			}
		}
		set_combo("frmUnico.cbRegion", arrayRegiones);
		set_combo("frmUnico.cbZona", new Array() );

}

// ------------------------------------------------------------------------------------------------------------
function cambiaZona()
{

		var codSeleccionados = get("frmUnico.cbRegion");
		var arrayZonas = new Array();
		arrayZonas[0] = ["",""];
		var objRegiones = new Object();
		//gacevedo(13/03/2007), segun incidencia SiCC 20070095
		//Aplicamos el mismo tratamiento que en el metodo cambiaRegion()
		for (var i = 0; i < codSeleccionados.length; i++){
			objRegiones[codSeleccionados[i]+""]=true;
		}
		//idem anterior (gacevedo. 13/03/2007)
		var longListaZonas = listaZonas.datos.longitud;
		for (var n = 0; n < longListaZonas; n++){
			if (objRegiones[listaZonas.datos.ij(n, 1)+""]){
				var oid = listaZonas.datos.ij(n, 0);
				var desc = listaZonas.datos.ij(n,2);
				var newArray = new Array();
				newArray[0] = oid;
				newArray[1] = desc;
				arrayZonas[arrayZonas.length] = newArray;
			}
		}
		set_combo("frmUnico.cbZona", arrayZonas);
}

// ------------------------------------------------------------------------------------------------------------
function cambiaTiposClasificacion()
{
		var codSeleccionados = get("frmUnico.cbSubtipoCliente");
		//alert("Subtipo: " + codSeleccionados);
		var arrayTipos = new Array();
		arrayTipos[0] = ["",""];
		var z = 1;

		for (var i = 0; i < codSeleccionados.length; i++)
		{
				var codigoActual = codSeleccionados[i];
				var longListaTipos = listaTiposClasificacion.datos.longitud;
				for (var n = 0; n < longListaTipos; n++)
				{
					if (listaTiposClasificacion.datos.ij(n, 1) == codigoActual)
					{
						var oid = listaTiposClasificacion.datos.ij(n, 0);
						var desc = listaTiposClasificacion.datos.ij(n,2);
						var newArray = new Array();
						newArray[0] = oid;
						newArray[1] = desc;
						arrayTipos[z] = newArray;
						z++;
					}
				}
		}

		set_combo("frmUnico.cbTipoClasificacionCliente", arrayTipos);
		set_combo("frmUnico.cbClasificacionCliente", new Array() );

}

// ------------------------------------------------------------------------------------------------------------
function cambiaClasificaciones()
{
		var codSeleccionados = get("frmUnico.cbTipoClasificacionCliente");
		var arrayClasi = new Array();
		arrayClasi[0] = ["",""];
		var z = 1;

		for (var i = 0; i < codSeleccionados.length; i++)
		{
				var codigoActual = codSeleccionados[i];
				var longListaClasi = listaClasificaciones.datos.longitud;
				for (var n = 0; n < longListaClasi; n++)
				{
					if (listaClasificaciones.datos.ij(n, 1) == codigoActual)
					{
						var oid = listaClasificaciones.datos.ij(n, 0);
						var desc = listaClasificaciones.datos.ij(n,2);
						var newArray = new Array();
						newArray[0] = oid;
						newArray[1] = desc;
						arrayClasi[z] = newArray;
						z++;
					}
				}
		}

		set_combo("frmUnico.cbClasificacionCliente", arrayClasi);

}


// ------------------------------------------------------------------------------------------------------------
function cambiaDespacho(detalle)
{
	// Modificado x ssantana, 9/12/2004
	// por incidencia 11073. Ahora se recarga el combo "EnvioSolicitud" a partir de la lista oculta "listaEnvioSolicitud"

	var tipoDespacho = get("frmUnico.cbTipoDespacho");
	var oidEnvioSolicitud = ""
	var descEnvioSolicitud = ""
	var array = new Array();

	if (tipoDespacho != "")
	{
		// Fin Combo de Mensajes
		var arrayTipoDespacho = new Array();
		arrayTipoDespacho[0] = ["oid", tipoDespacho];
		if ( detalle == "detalle")
		{
			recargaCombo('frmUnico.cbCodMensaje2', 'MAVObtieneMensajesDespacho', 'es.indra.sicc.util.DTOOID', arrayTipoDespacho, "marcaComboMensaje1(datos, 1);" );	
			recargaCombo('frmUnico.cbCodMensaje3', 'MAVObtieneMensajesDespacho', 'es.indra.sicc.util.DTOOID', arrayTipoDespacho, "marcaComboMensaje1(datos, 2);" );
		}
		else
		{
			recargaCombo('frmUnico.cbCodMensaje2', 'MAVObtieneMensajesDespacho', 'es.indra.sicc.util.DTOOID', arrayTipoDespacho );
			recargaCombo('frmUnico.cbCodMensaje3', 'MAVObtieneMensajesDespacho', 'es.indra.sicc.util.DTOOID', arrayTipoDespacho );
		}
		// Fin manejo de combo de Mensajes

		var longLista = listaEnvioSolicitud.datos.longitud;
		var match = false;

		for (var i = 0; (i < longLista) && (!match); i++ )
		{
			var oidTipoDespacho = listaEnvioSolicitud.datos.ij(i,0);
			if (parseInt(oidTipoDespacho, 10) == parseInt(tipoDespacho, 10) )
			{
				// Se encontro coincidencia.
				oidEnvioSolicitud = listaEnvioSolicitud.datos.ij(i,1);
				descEnvioSolicitud = listaEnvioSolicitud.datos.ij(i,2);
			}
		}

	}

	array[0] = [oidEnvioSolicitud, descEnvioSolicitud];

	set_combo("frmUnico.cbEnvioSolicitud", array);
	set("frmUnico.cbEnvioSolicitud", new Array( array[0][0] ) );



}

// ------------------------------------------------------------------------------------------------------------
function marcaComboMensaje1(datos, combo)
{
	var mensaje = get("frmUnico.varMensaje");

	// Setea espacio en blanco.
	var datosNuevo = new Array();
	datosNuevo[0] = ["",""];

	for (var i = 0; i < datos.length; i++ )
		datosNuevo[i+1]  = datos[i];


	// Procede a setear valores en el combo.
	if ( combo == "1")
	{
		set_combo("frmUnico.cbCodMensaje2", datosNuevo);
		marcaCombo("cbCodMensaje2", new Array(mensaje) );
	}
	else if ( combo == "2")
	{
		set_combo("frmUnico.cbCodMensaje3", datosNuevo);
		marcaCombo("cbCodMensaje3", new Array(mensaje) );
	}


}

// ------------------------------------------------------------------------------------------------------------
function listaClientes()
{
	var obj = new Object();
	obj.varListaCliente = get("frmUnico.varListaCliente");
	obj.estadoProceso = get('frmUnico.varEstadoProceso');
	
	var listaClientes = mostrarModalSICC('LPCargaListaClientes','',obj);

	if (listaClientes != null && listaClientes != undefined && listaClientes != "")	{
		set("frmUnico.varListaCliente", listaClientes);
		manejaPantallaPorListaClientes();
	}
	return;
}

// ------------------------------------------------------------------------------------------------------------
function criteriosAsignacion()
{
	//alert("criterios");
	var criterio = get("frmUnico.cbCriterioAsignacion");

	switch ( parseInt(criterio, 10) )
	{
	case 1:
		muestraPantallaAtributo();
		break;
	case 2:
		muestraPantallaVariables();
		break;
	case 3:
		muestraPantallaFormula();
		break;
	
	}


}

// ------------------------------------------------------------------------------------------------------------
function muestraPantallaAtributo()
{
    //alert('muestraPantallaAtributo()');
	set("frmUnico.conectorAction", "LPCompletaCriteriosBP");
	set("frmUnico.accion", "atributos");

	var obj = new Object();
	obj.varCriterio = get("frmUnico.cbCriterioAsignacion");
	obj.varMarca = get("frmUnico.varLblMarca");
	//obj.varMarca = get("frmUnico.varMarca");
	obj.varCanal = get("frmUnico.varCanal");
	obj.varPeriodo = get("frmUnico.varPeriodo");

    // Agregado por Rafael Romero - SiCC20070189 23/04/2007
    // manejar estados proceso 3 y 4
    obj.estadoProceso = get('frmUnico.varEstadoProceso');
    // fin agregar

	var flagCriterioExistente = chequeaCriterioAsigExistente(criterioAsignacionGlobal);
	//alert("Atributo - flagCriterioExistente: " + flagCriterioExistente);
	if ( flagCriterioExistente == true)
	{
		obj.varSubcriterio = get("frmUnico.varSubcriterio");
		obj.varNumUnidadesCliente = get("frmUnico.varNumUnidadesCliente");
		obj.varCampanyaFuente = get("frmUnico.varCampanyaFuente");

		obj.varNumeroAniversario = get("frmUnico.varNumeroAniversario");
		obj.varEdadDesde = get("frmUnico.varEdadDesde");
		obj.varEdadHasta = get("frmUnico.varEdadHasta");
		obj.varMonto = get("frmUnico.varMonto");
		obj.varPeriodoDesde = get("frmUnico.varPeriodoDesde");
		obj.varPeriodoHasta = get("frmUnico.varPeriodoHasta");
		obj.varMarcaCriterio = get("frmUnico.varMarcaCriterio");
		obj.varCatalogo = get("frmUnico.varCatalogo");
		obj.varUnidadNegocio = get("frmUnico.varUnidadNegocio");
		obj.varNegocio = get("frmUnico.varNegocio");

/*		set("frmUnico.varNumeroAniversario", aniversario);
		set("frmUnico.varEdadDesde", edadDesde);
		set("frmUnico.varEdadHasta", edadHasta);
		set("frmUnico.varMonto", monto);
		set("frmUnico.varPeriodoDesde", periodoDesde);
		set("frmUnico.varPeriodoHasta", periodoHasta);
		set("frmUnico.varMarca", marca);
		set("frmUnico.varCatalogo", catalogo);
		set("frmUnico.varUnidadNegocio", uNegocio);
		set("frmUnico.varNegocio", negocio);

		obj.varSubcriterio = get("frmUnico.varSubcriterio");
		obj.varNumUnidadesTotales = get("frmUnico.varNumUnidadesTotales");
		obj.varCampanyaFuente = get("frmUnico.varCampanyaFuente");*/
	}

	var arrayRetorno = mostrarModalSICC('LPCompletaCriteriosBP','atributos',obj);

	if ( arrayRetorno != null)
	{
		//arrayRetorno = arrayRetorno.split(",");
		//alert(arrayRetorno);

		seteaVariablesCriterios(arrayRetorno);
		criterioAsignacionGlobal = 1;
	}

	return;

}

// ------------------------------------------------------------------------------------------------------------
function seteaVariablesCriterios(array)
{
		//alert('seteaVariablesCriterios ' + array);
		var subCriterio = array[0];
		var numUnidades = array[1];

		var aniversario = "";
		var edadDesde = "";
		var edadHasta = "";
		var monto = "";
		var periodoDesde = "";
		var periodoHasta = "";
		var marca = "";
		var catalogo = "";
		var uNegocio = "";
		var negocio = "";

		switch ( parseInt(subCriterio, 10) )
		{
		case 1:  // Todos 
			aniversario = array[2];
			edadDesde = array[3];
			edadHasta = array[4];
			monto = array[5];
			periodoDesde = array[6];
			periodoHasta = array[7];
			marca = array[8];
			catalogo = array[9];
			uNegocio = array[10];
			negocio = array[11];
			break;

		case 2: // Cumpleaños
			aniversario = array[2];
			break;

		case 3: // Aniversario
			aniversario = array[2];
			break;

		case 4: // Edad
			edadDesde = array[2];
			edadHasta = array[3];
			break;

		case 5:  // Pedido Supera Monto
			monto = array[2];
			periodoDesde = array[3];
			periodoHasta = array[4];
			break;

		case 6: // Pedido Supera Monto Marca
			monto = array[2];
			marca = array[3];
			periodoDesde = array[4];
			periodoHasta = array[5];
			break;

		case 7: // Pedido Supera Monto Unidad Negocio

			monto = array[2];
			uNegocio = array[3];
			periodoDesde = array[4]; 
			periodoHasta = array[5];
			break;

		case 8: // Pedido Supera Monto Negocio
			monto = array[2];
			negocio = array[3];
			periodoDesde = 	array[4]; 
			periodoHasta = array[5];
			break;

		case 9: // Pedido Supera Monto Catalogo
			monto = array[2];
			catalogo = array[3];
			periodoDesde = array[4]; 
			periodoHasta = array[5];
			break;
		case 23:  // Pedido NO Supera Monto
			monto = array[2];
			periodoDesde = array[3];
			periodoHasta = array[4];
			break;
		case 24: // Pedido NO Supera Monto Marca
			monto = array[2];
			marca = array[3];
			periodoDesde = array[4];
			periodoHasta = array[5];
			break;
		case 25: // Pedido NO Supera Monto Unidad Negocio
			monto = array[2];
			uNegocio = array[3];
			periodoDesde = array[4]; 
			periodoHasta = array[5];
			break;
		case 26: // Pedido NO Supera Monto Negocio
			monto = array[2];
			negocio = array[3];
			periodoDesde = 	array[4]; 
			periodoHasta = array[5];
			break;
		case 27: // Pedido NO Supera Monto Catalogo
			monto = array[2];
			catalogo = array[3];
			periodoDesde = array[4]; 
			periodoHasta = array[5];
			break;

		// sapaza -- PER-SiCC-2010-0628 -- 20/10/2010			
		case 28: // DuplaCyzone
			periodoDesde = array[2]; 
			periodoHasta = array[3];
			break;			
						
		}

		set("frmUnico.varSubcriterio", subCriterio);
		set("frmUnico.varNumUnidadesCliente", numUnidades);  // Para "atributos" es por Num. Unidades x Cliente.

		set("frmUnico.varNumeroAniversario", aniversario);
		set("frmUnico.varEdadDesde", edadDesde);
		set("frmUnico.varEdadHasta", edadHasta);
		set("frmUnico.varMonto", monto);
		set("frmUnico.varPeriodoDesde", periodoDesde);
		set("frmUnico.varPeriodoHasta", periodoHasta);
		set("frmUnico.varMarcaCriterio", marca);
		set("frmUnico.varCatalogo", catalogo);
		set("frmUnico.varUnidadNegocio", uNegocio);
		set("frmUnico.varNegocio", negocio);

		return;
		

}

// ------------------------------------------------------------------------------------------------------------
function muestraPantallaVariables() 
{
	// Chequea si se ha ingresado a esta pantalla anteriormente.
	// comparando el valor de la variable global criterioAsignacionGlobal con el valor
	// del combo criterioAsignacion 


	var obj = new Object();
	obj.varCriterio = get("frmUnico.cbCriterioAsignacion");
	obj.varActividad = get("frmUnico.varActividad");
    // Agregado por Rafael Romero - SiCC20070189 23/04/2007
    // manejar estados proceso 3 y 4
    obj.estadoProceso = get('frmUnico.varEstadoProceso');
    // fin agregar

	var flagCriterioExistente = chequeaCriterioAsigExistente(criterioAsignacionGlobal);
	if ( flagCriterioExistente == true)
	{
		obj.varSubcriterio = get("frmUnico.varSubcriterio");
		obj.varNumUnidadesTotales = get("frmUnico.varNumUnidadesTotales");
		obj.varCampanyaFuente = get("frmUnico.varCampanyaFuente");
	}

	var arrayRetorno = mostrarModalSICC('LPCompletaCriteriosBP','variables',obj);


	if ( arrayRetorno != null)
	{
		//alert("arrayRetorno: " + arrayRetorno);
		set("frmUnico.varSubcriterio", arrayRetorno[0] );
		set("frmUnico.varNumUnidadesTotales", arrayRetorno[1] );
		set("frmUnico.varCampanyaFuente", arrayRetorno[2] );
		criterioAsignacionGlobal = 2;
	}

	return;
}

// ------------------------------------------------------------------------------------------------------------
function muestraPantallaFormula()
{
	var obj = new Object();
	obj.varCriterio = get("frmUnico.cbCriterioAsignacion");
	obj.varMarca = get("frmUnico.varLblMarca");
	obj.varCanal = get("frmUnico.varCanal");
	obj.varActividad = get("frmUnico.varActividad");
    // Agregado por Rafael Romero - SiCC20070189 23/04/2007
    // manejar estados proceso 3 y 4
    obj.estadoProceso = get('frmUnico.varEstadoProceso');
    // fin agregar

	var flagCriterioExistente = chequeaCriterioAsigExistente(criterioAsignacionGlobal);
	if ( flagCriterioExistente == true)
	{

/*		set("frmUnico.varSubcriterio", subCriterio);
		set("frmUnico.varNumUnidadesTotales", numUnidades);
		set("frmUnico.varCampanyaFuente", campanya);
		set("frmUnico.varCurso", asistenciaCurso);
		set("frmUnico.varPeriodoCurso", periodo);*/

		obj.varSubcriterio = get("frmUnico.varSubcriterio");
		//obj.varNumUnidadesTotales = get("frmUnico.varNumUnidadesTotales");
		obj.varNumUnidadesCliente = get("frmUnico.varNumUnidadesCliente");
		obj.varCampanyaFuente = get("frmUnico.varCampanyaFuente");
		obj.varCurso = get("frmUnico.varCurso");
		obj.varPeriodoCurso = get("frmUnico.varPeriodoCurso");
		
		obj.varTipoClienteCriterio = get("frmUnico.varTipoClienteCriterio");
		obj.varSubtipoClienteCriterio = get("frmUnico.varSubtipoClienteCriterio");
		obj.varTipoClasificacionClienteCriterio = get("frmUnico.varTipoClasificacionClienteCriterio");
		obj.varClasificacionClienteCriterio = get("frmUnico.varClasificacionClienteCriterio");
	}


	var arrayRetorno = mostrarModalSICC('LPCompletaCriteriosBP','formula',obj);
	if ( arrayRetorno != null)
	{
		//alert("arrayRetorno: " + arrayRetorno);
		var numUnidades = arrayRetorno[0];  // Siempre es el 0.
		var subCriterio = arrayRetorno[1];  // Siempre es el 1.
		var campanya = "";
		var asistenciaCurso = "";
		var periodo = ""; 
		
		var TipoClienteCriterio = "";
		var SubtipoClienteCriterio = "";
		var TipoClasificacionClienteCriterio = "";
		var ClasificacionClienteCriterio = "";
		
		
		switch ( parseInt(subCriterio,10) )
		{
			case 15:  // Asistencia a curso
				asistenciaCurso = arrayRetorno[2];
				periodo = arrayRetorno[3];
				//campanya = arrayRetorno[4];
				campanya = "";   // Por inc. 6177 supuestamente no va para este subcriterio
				break;
			case 16:  // Asistencia a conferencia Ventas
				periodo = arrayRetorno[2];
				//campanya = arrayRetorno[3];
				campanya = "";   // Por inc. 6177 supuestamente no va para este subcriterio
				break;

			case 17: // Activas finales
			case 18: // Ingresos
			case 19: // Reingresos
			case 20: // Egresos
			case 21: // Número de pedidos
			case 22: // Número de zonas
				campanya = arrayRetorno[2];
				break;
			
			// sapaza -- PER-SiCC-2010-0674 -- 29/11/2010	
			case 29: // Tipificacion de Clientes
				campanya = arrayRetorno[2];
				TipoClienteCriterio = arrayRetorno[3];
				SubtipoClienteCriterio = arrayRetorno[4];
				TipoClasificacionClienteCriterio = arrayRetorno[5];
				ClasificacionClienteCriterio = arrayRetorno[6];
				break;				
		}

		// Asigna Variables.
		set("frmUnico.varSubcriterio", subCriterio);
		set("frmUnico.varNumUnidadesCliente", numUnidades);
		//set("frmUnico.varNumUnidadesTotales", numUnidades);
		set("frmUnico.varCampanyaFuente", campanya);
		set("frmUnico.varCurso", asistenciaCurso);
		set("frmUnico.varPeriodoCurso", periodo);
		
		// sapaza -- PER-SiCC-2010-0674 -- 29/11/2010
		set("frmUnico.varTipoClienteCriterio", TipoClienteCriterio);
		set("frmUnico.varSubtipoClienteCriterio", SubtipoClienteCriterio);
		set("frmUnico.varTipoClasificacionClienteCriterio", TipoClasificacionClienteCriterio);
		set("frmUnico.varClasificacionClienteCriterio", ClasificacionClienteCriterio);
		
		criterioAsignacionGlobal = 3;

	}

}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function errorAlGuardar()
{

	//alert("Error al guardar");
	fMostrarMensajeError();
}


// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function noHayError()
{
	/*set("frmUnico.conectorAction", "LPCompletaDatosBP");+
	set("frmUnico.accion", "");
	eval("frmUnico").oculto = "N";
	enviaSICC("frmUnico");*/
	// Modificado por ssantana, 16/11/2005, inc. BELC300021698 (Performance)
	returnValue = "hacePaginado";
	window.close();

}


// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function nuevaEntrada()
{
	// Al hacer click en el boton "Nueva Entrada"

	set("frmUnico.conectorAction", "LPCompletaDatosBP");
	set("frmUnico.accion", "nuevoDetalle");
	eval("frmUnico").oculto = "N";
	enviaSICC("frmUnico", null, null, "N");

}



// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function validaNumero()
{
	// TODO: Hacer!




}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function parseaArray(array)
{
		// Recibe una cadena con formato  xxx,yyy,zzz y la parsea en un Array.
		// (Funcion usada para separar los oid de los combos multiseleccion)

		var arrayRetorno = array.split(",");
		return arrayRetorno;

}


// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function marcaCombo(combo, array)
{
	// Recibe el nombre del combo, y el array de valores a marcar. 
	// Procede a activar esos valores en el combo. 
	set("frmUnico." + combo, array);

}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onchangeCriterioAsignacion()
{
	// Se llama en el onchange del combo de Criterio Asignacion
	borrarVariablesCriterios();

}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function borrarVariablesCriterios()
{
	// Limpia todas las variables de formulario correspondiente a los criterios de asignacion
	// y sus respectivas modales.

	set("frmUnico.varSubcriterio", "");
	set("frmUnico.varNumUnidadesTotales", "");
	set("frmUnico.varCampanyaFuente", "");
	set("frmUnico.varCurso", "");
	set("frmUnico.varPeriodoCurso", "");
	set("frmUnico.varNumUnidadesCliente", "");  
	set("frmUnico.varNumeroAniversario", "");
	set("frmUnico.varEdadDesde", "");
	set("frmUnico.varEdadHasta", "");
	set("frmUnico.varMonto", "");
	set("frmUnico.varPeriodoDesde", "");
	set("frmUnico.varPeriodoHasta", "");
	set("frmUnico.varMarcaCriterio", "");
	set("frmUnico.varCatalogo", "");
	set("frmUnico.varUnidadNegocio", "");
	set("frmUnico.varNegocio", "");
	criterioAsignacionGlobal = "";


}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function chequeaCriterioAsigExistente(valor)
{
	// Compara "valor" con la opcion seleccionada en el combo de Criterio de Asignacion
	// Se usa para compar si el valor del combo es el mismo para el que ya existen datos.
	// Si coincide, devuelve true
	// Si no, false
	var valorCombo = get("frmUnico.cbCriterioAsignacion");
	var flag = false;

	if (parseInt(valor,10) == parseInt(valorCombo,10) )
		flag = true;
	else
		flag = flag;

	return flag;



}


// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function shtab()
{
	var casoUso = get("frmUnico.casoUso");
	if ( casoUso == "detalle")  // Se Muestra el boton "Nueva entrada" de la capa 2
		 focalizaBotonHTML('botonContenido', 'btnNuevaEntrada');
	else // Focaliza sobre el combo correspondiente a la capa 3.
	{
		// Pero primero chequea que esté habilitado. Si no lo está, focaliza sobre el RadioButton
		var objetoHTML = document.getElementById("cbCodMensaje3");
		var deshabilitado = objetoHTML.getAttribute("disabled");

		if ( !deshabilitado)
			focaliza("frmUnico.cbCodMensaje3", "");
		else	
			focaliza("frmUnico.rbEnviarMensaje3", "");

	}
}


// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tabAceptar()
{

	var casoUso = get("frmUnico.casoUso");
	if ( casoUso == "detalle")  // Se Muestra el boton "Nueva entrada" de la capa 2
		 focaliza("frmUnico.rbEnviarMensaje2", "");
	else // Focaliza sobre el combo correspondiente a la capa 3.
		focaliza("frmUnico.rbEnviarMensaje3", "");
}


// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function fLimpiar()
{
	seteaPantalla();
	document.selection.empty();
	focaliza("frmUnico.txtCodProducto", "");
}

// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// Modificado por HRCS - Fecha 19/02/2007 - Incidencia DBLG700000145
function seteaPantalla()
{
			focaliza("frmUnico.txtCodProducto", "");	
			// Subgerencia
			var subgerencia = get("frmUnico.varSubgerencia");
			//alert("subGerencia: " + subgerencia);
			if ( subgerencia != "" )
			{
				subgerencia = parseaArray(subgerencia);
				marcaCombo("cbSubgerencia", subgerencia);
				cambiaRegion();
			}

			// Region
			var region = get("frmUnico.varRegion");
			//alert("region: " + region);
			if ( region != "")
			{
				region = parseaArray(region);
				marcaCombo("cbRegion", region)
				cambiaZona();
			}

			// Zona
			var zona = get("frmUnico.varZona");
			//alert("zona: " + zona);
			if ( zona != "")
			{
				zona = parseaArray(zona);
				marcaCombo("cbZona", zona);
			}

			// Observaciones 
			var observaciones = get("frmUnico.varObservaciones");
			//alert("observaciones: " + observaciones);
			set("frmUnico.atxtObservaciones", observaciones);

			// Subtipo Cliente
			var subtipoCliente = get("frmUnico.varSubtipoCliente");
			//alert("subtipoCliente: " + subtipoCliente);
			if ( subtipoCliente != "")
			{
				subtipoCliente = parseaArray(subtipoCliente);
				marcaCombo("cbSubtipoCliente", subtipoCliente);
				cambiaTiposClasificacion();
			}
			else	{		//	Setea el valor por defecto (Primer registro) del combo
				var numElem = combo_get('frmUnico.cbSubtipoCliente', 'L', null);
				if ( numElem == 2 )	{
					var codigo = combo_get('frmUnico.cbSubtipoCliente', 'V', 1);
					if (codigo != "")	{
						var arrayN = codigo.split(",");
						set('frmUnico.cbSubtipoCliente', arrayN );
						cambiaTiposClasificacion();
					}
				}
			}

			// Tipo Clasificacion
			var tipoClasificacion = get("frmUnico.varTipoClasificacionCliente");
			//alert("Tipo Clasificacion cliente: " + tipoClasificacion);
			if ( tipoClasificacion != "")
			{
				tipoClasificacion = parseaArray(tipoClasificacion);
				marcaCombo("cbTipoClasificacionCliente", tipoClasificacion);
				cambiaClasificaciones();
			}

			// Clasificacion 
			var clasificacion = get("frmUnico.varClasificacionCliente");
			//alert("Clasificacion Cliente: " + clasificacion);
			if ( clasificacion != "")
			{
				clasificacion = parseaArray(clasificacion);
				marcaCombo("cbClasificacionCliente", clasificacion);
			}

			// Estado
			var estado = get("frmUnico.varEstado");
			//alert("Estado: " + estado);
			if ( estado != "" )
			{
				estado = parseaArray(estado);
				marcaCombo("cbEstado", estado);
			}
			else	{		//	Setea el valor por defecto (Primer registro) del combo
				var numElem = combo_get('frmUnico.cbEstado', 'L', null);
				if ( numElem == 2 )	{
					var codigo = combo_get('frmUnico.cbEstado', 'V', 1);
					if (codigo != "")	{
						var arrayN = codigo.split(",");
						set('frmUnico.cbEstado', arrayN );
					}
				}
			}

			// Criterio Asignacion
			var criterioAsig = get("frmUnico.varCriterioAsig");
			//alert("Criterio de Asignacion: " + criterioAsig);
			if ( criterioAsig != "")
			{
				criterioAsig = parseaArray(criterioAsig);
				criterioAsignacionGlobal = criterioAsig;  // Usado luego para cargar correctamente la modal con los datos ya existentes
				marcaCombo("cbCriterioAsignacion", criterioAsig);
			}
			else	{		//	Setea el valor por defecto (Primer registro) del combo
				var numElem = combo_get('frmUnico.cbCriterioAsignacion', 'L', null);
				//alert('NumElem: ' + combo_get('frmUnico.cbCriterioAsignacion', 'L', null) );
				if ( numElem == 2 )	{
					var codigo = combo_get('frmUnico.cbCriterioAsignacion', 'V', 1);
					//alert('frmUnico.cbCriterioAsignacion: (' + numElem + ') - Codigo:' +  codigo );
					if (codigo != "")	{
						var arrayN = codigo.split(",");
						set('frmUnico.cbCriterioAsignacion', arrayN );
						criterioAsignacionGlobal = arrayN;
					}
				}
			}

			// Acceso
			var acceso = get("frmUnico.varAcceso");
			//alert("Acceso: " + acceso);
			if ( acceso != "")
			{
				acceso = parseaArray(acceso);
				marcaCombo("cbAcceso", acceso);
				cambiaAcceso();
			}

			// Subacceso
			var subAcceso = get("frmUnico.varSubacceso");
			//alert("SubAcceso: " + subAcceso);
			if ( subAcceso != "")
			{
				subAcceso = parseaArray(subAcceso);
				marcaCombo("cbSubacceso", subAcceso);
			}

			// Periodo Fin
			var periodoFin = get("frmUnico.varPeriodoFin");
			//alert("Periodo Fin: " + periodoFin);
			if ( periodoFin != "")
			{
				periodoFin = parseaArray(periodoFin);
				marcaCombo("cbPeriodoFin", periodoFin);
			}

			// Tipo Oferta
			var tipoOferta = get("frmUnico.varTipoOferta");
			//alert("tipo Oferta: " + tipoOferta);
			if ( tipoOferta != "")
			{
				tipoOferta = parseaArray(tipoOferta);
				marcaCombo("cbTipoOferta", tipoOferta);
			}
			else	{		//	Setea el valor por defecto (Primer registro) del combo
				var numElem = combo_get('frmUnico.cbTipoOferta', 'L', null);
				if ( numElem == 2 )	{
					var codigo = combo_get('frmUnico.cbTipoOferta', 'V', 1);
					if (codigo != "")	{
						var arrayN = codigo.split(",");
						set('frmUnico.cbTipoOferta', arrayN );
					}
				}
			}

			// Ciclo Vida
			var cicloVida = get("frmUnico.varCicloVida");
			//alert("ciclo Vida: " + cicloVida);
			if ( cicloVida != "")
			{
				cicloVida = parseaArray(cicloVida);
				marcaCombo("cbCicloVida", cicloVida);
			}
			else	{		//	Setea el valor por defecto (Primer registro) del combo
				var numElem = combo_get('frmUnico.cbCicloVida', 'L', null);
				if ( numElem == 2 )	{
					var codigo = combo_get('frmUnico.cbCicloVida', 'V', 1);
					if (codigo != "")	{
						var arrayN = codigo.split(",");
						set('frmUnico.cbCicloVida', arrayN );
					}
				}
			}

			// Codigo Producto
			var codProducto = get("frmUnico.varCodProducto");
			//alert("Codigo Producto: " + codProducto);
			set("frmUnico.txtCodProducto", codProducto);


			// Modificado por Inc. BELC300015618, 1/8/2005
			/*var codVenta = get("frmUnico.varCodVenta");
			set("frmUnico.txtCodVenta", codVenta);*/
			// Fin Modificacion por Inc. BELC300015618, 1/8/2005

			// Precio Estandar
			var precioEstandar = get("frmUnico.varPrecioEstandar");
			//alert("Precio Estandar: " + precioEstandar);
			set("frmUnico.txtPrecioEstandar", precioEstandar);
			
			// Precio
			var precio = get("frmUnico.varPrecio");
			//alert("Precio: " + precio);
			set("frmUnico.txtPrecio", precio);

			// Precio Contable
			var precioContable = get("frmUnico.varPrecioContable");
			//alert("Precio Contable: " + precioContable);
			set("frmUnico.txtPrecioContable", precioContable);

			// Base Destinatarios
			var baseDestinatarios = get("frmUnico.varBaseDestinatarios");
			//alert("Base Destinatarios: " + baseDestinatarios);
			set("frmUnico.txtBaseDestinatarios", baseDestinatarios);

			// Factor Corrección
			var factorCorreccion = get("frmUnico.varFactorCorreccion");
			//alert("Factor Correccion: " + factorCorreccion);
			set("frmUnico.txtFactorCorreccion", factorCorreccion);

			// Numero Unidades Estimadas
			var numUnidades = get("frmUnico.varUEstimadas");
			//alert("Unidades Estimadas (Promedio): " + numUnidades);
			set("frmUnico.txtPromedio", numUnidades);

			// Numero Unidades Totales Estimadas. 
			var numUnidadesTotales = get("frmUnico.varUTotalesEstimadas");
			//alert("Unidades Estimadas Totales: " + numUnidadesTotales);
			set("frmUnico.txtUnidades", numUnidadesTotales);

			// Criterio
			var criterio = get("frmUnico.varCriterio");
			//alert("Criterio: " + criterio);
			set("frmUnico.txtCriterio", criterio);

			// Forma Cobro
			//var formaCobro = get("frmUnico.varFormaCobro");
			//alert("Forma Cobro: " + formaCobro);
//			if ( formaCobro != "")
//				set("frmUnico.cbFormaCobro", new Array(formaCobro) );
	
			// Forma Pago
//			var formaPago = get("frmUnico.varFormaPago");
			//alert("Forma Pago: " + formaPago);
//			if ( formaPago != "")
//				set("frmUnico.cbFormaPago", new Array(formaPago) );

			// Tipo Despacho
			var tipoDespacho = get("frmUnico.varTipoDespacho");
			//alert("Tipo Despacho: " + tipoDespacho);
			if (tipoDespacho != "")
			{
				set("frmUnico.cbTipoDespacho", new Array(tipoDespacho) );
				cambiaDespacho("detalle");
			}
			else	{		//	Setea el valor por defecto (Primer registro) del combo
				var numElem = combo_get('frmUnico.cbTipoDespacho', 'L', null);
				if ( numElem == 2 )	{
					var codigo = combo_get('frmUnico.cbTipoDespacho', 'V', 1);
					if (codigo != "")	{
						var arrayN = codigo.split(",");
						set('frmUnico.cbTipoDespacho', arrayN );
						cambiaDespacho("detalle");
					}
				}
			}

			// Envio con solicitud
			var envioSolicitud = get("frmUnico.varEnvioSolicitud");
			//alert("Envio con solicitud: " + envioSolicitud);
			if ( envioSolicitud != "")
				set("frmUnico.cbEnvioSolicitud", new Array(envioSolicitud) );

			// RadioButton Enviar Mensaje
			var enviarMensaje = get("frmUnico.varRadioMensaje");
			//alert("Envio Mensaje: " + enviarMensaje);
			if (enviarMensaje != "" )
			{
				if (enviarMensaje == "true")
				{
						set("frmUnico.rbEnviarMensaje3", "S");
						set("frmUnico.rbEnviarMensaje2", "S");
				} else
				{
						set("frmUnico.rbEnviarMensaje3", "N");
						set("frmUnico.rbEnviarMensaje2", "N");
				}
			}

			// sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
			var exclusionTipoClasificacion = get("frmUnico.varRadioExclusionTipoClasificacion");
			if (exclusionTipoClasificacion != "" )
			{
				if (exclusionTipoClasificacion == "true")
				{
						set("frmUnico.rbExclusionTipoClasificacion", "S");
				} else
				{
						set("frmUnico.rbExclusionTipoClasificacion", "N");
				}
			}

			// ---------------------------------------------------- Campos ocultos -----------------------------------------------------------

			// Subcriterio
			var subcriterio = get("frmUnico.varSubcriterio");
			//alert("subCriterio: " + subcriterio);

			// Num. Unidades Cliente
			var numUnidadesC = get("frmUnico.varNumUnidadesCliente");
			//alert("numUnidadesC: " + numUnidadesC);

			// Num. Unidades Totales

			// Campanya
			var campanya = get("frmUnico.varCampanyaFuente");
			//alert("campanya: " + campanya);

			// Num Aniversario
			var numAniversario = get("frmUnico.varNumeroAniversario");
			//alert("Numero Aniversario: " + numAniversario);

			// Edad Desde
			var edadDesde = get("frmUnico.varEdadDesde");
			//alert("Edad Desde: " + edadDesde);

			// Edad Hasta
			var edadHasta = get("frmUnico.varEdadHasta");
			//alert("Edad Hasta: " + edadHasta);

			// Monto
			var monto = get("frmUnico.varMonto");
			//alert("Monto: " + monto);

			// Periodo Desde
			var periodoDesde = get("frmUnico.varPeriodoDesde");
			//alert("Periodo Desde: " + periodoDesde);

			// Periodo Hasta
			var periodoHasta = get("frmUnico.varPeriodoHasta");
			//alert("Periodo Hasta: "  + periodoHasta);

			// Catalogo
			var catalogo = get("frmUnico.varCatalogo");
			//alert("Catalogo: " + catalogo);

			// Unidad Negocio
			var uNegocio = get("frmUnico.varUnidadNegocio");
			//alert("U. Negocio: " + uNegocio);

			// Negocio
			var negocio = get("frmUnico.varNegocio");
			//alert("Negocio: " + negocio);

			// Curso
			var curso = get("frmUnico.varCurso");
			//alert("Curso: " + curso);

			// Periodo Curso 
			var periodoCurso = get("frmUnico.varPeriodoCurso");
			//alert("Periodo Curso: " + periodoCurso);



}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onchangeFormaCobro()
{
	var valorCombo = get("frmUnico.cbFormaCobro");
	// No hace falta validar si Forma de Cobro tiene "" porque entonces nunca se llegaría a validar Forma de Pago
	// ya que Forma de Cobro es si o si obligatorio.

	if ( valorCombo == 1 )  // Gratis - Deshabilita forma de Pago, setea valor seleccionado a "" y lo pone no obligatorio.
	{
		set("frmUnico.cbFormaPago", new Array("") );
		accion("frmUnico.cbFormaPago" , ".disabled=true");
		setRequerido("cbFormaPago", false);
		setMV("frmUnico.cbFormaPago","c"); 
	} else if ( valorCombo == 2 )  // Facturado
	{
		accion("frmUnico.cbFormaPago" , ".disabled=false");
		setMV("frmUnico.cbFormaPago","C");
		setRequerido("cbFormaPago", true);
	} 

}



// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function cambiaRadio2()
{
		var valorRadio = get("frmUnico.rbEnviarMensaje2");
		if ( valorRadio == "N")  // Deshabilita Combo Mensaje y lo limpia.
		{
			set("frmUnico.cbCodMensaje2", new Array("") );
			accion("frmUnico.cbCodMensaje2", ".disabled=true");
			setRequerido("cbCodMensaje2", false);
		} else 
		{
			accion("frmUnico.cbCodMensaje2", ".disabled=false");
			setRequerido("cbCodMensaje2", true);
		}
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function cambiaRadio3()
{
		var valorRadio = get("frmUnico.rbEnviarMensaje3");
		if ( valorRadio == "N")  // Deshabilita Combo Mensaje y lo limpia.
		{
			set("frmUnico.cbCodMensaje3", new Array("") );
			accion("frmUnico.cbCodMensaje3", ".disabled=true");
			setRequerido("cbCodMensaje3", false);
		} else
		{
			accion("frmUnico.cbCodMensaje3", ".disabled=false");
			setRequerido("cbCodMensaje3", true);
		}
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

// Funcion que setea un campo como requerido o no, dependiendo
// de la variable booleana esRequerido.
// Parametros de entrada: 
// campo es el elemento que se seteará como requerido o no, el mismo
// no debe incluir el nombre del formulario.
// esRequerido, es un valor booleano que indica si el elemento sera
// requerido o no.
function setRequerido(campo, esRequerido){
	if( campo == null ) return;
	if( esRequerido != true && esRequerido != false ){
		return;
	}
	for(var i=0; i < objValidacionSICC.length; i++){
		if(objValidacionSICC[i].nombre == campo){
			objValidacionSICC[i].requerido = esRequerido;
			return;
		}
	}
	return;
}


// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function tabRbEnviarMensaje(campoAFocalizar)
{
	var objetoHTML = document.getElementById(campoAFocalizar);
	var deshabilitado = objetoHTML.getAttribute("disabled");
	//alert(campoAFocalizar + ": " + objetoHTML.getAttribute("disabled") );

	if ( !deshabilitado )  // Si el combo dado por <campoAFocalizar> no está deshabilitado, lo focaliza.
	{
		focaliza("frmUnico." + campoAFocalizar, "");
	} else  // Si el combo dado por <campoAFocalizar> está deshabilitado.
	{
		// Si pide focalizar el Combo cbCodMensaje2, entonces es la capa que posee boton "Nueva Entrada", así que 
		// focaliza "Nueva Entrada".
		if ( campoAFocalizar == "cbCodMensaje2")
			focalizaBotonHTML('botonContenido', 'btnNuevaEntrada');

		// Si pide focalizar el Combo cbCodMensaje3, entonces es la capa que NO posee boton "Nueva Entrada", así que 
		// focaliza campo "Producto" (wraparound)
		if ( campoAFocalizar == "cbCodMensaje3")
			focalizaCampoProducto();

	}


}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function focalizaCampoProducto()
{
	// Se intenta focalizar el campo Producto. 
	// Chequea si Producto está deshabilitado. Si es así, focaliza Combo Tipo Oferta.
	
	var objetoHTML = document.getElementById("txtCodProducto");
	var deshabilitado = objetoHTML.getAttribute("disabled");

	if ( !deshabilitado )
		focaliza("frmUnico.txtCodProducto", "");
	else
		focaliza("frmUnico.cbTipoOferta", "");

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function shTabOferta()
{
	// Se realiza en el evento OnShTab del Combo Tipo Oferta. Como Producto puede estar deshabilitado, 
	// debe chequear si este campo esta deshabilitado. Si es así, realiza wraparound.

	var objetoHTML = document.getElementById("txtCodProducto");
	var deshabilitado = objetoHTML.getAttribute("disabled");

	if ( !deshabilitado )  // Producto no está deshabilitado. Lo focaliza.
		focaliza("frmUnico.txtCodProducto", "");
	else // Esta deshabilitado. Ejecuta wraparound
		shtab();   // Función que se llama cuando se hace onShTab en Producto, que realiza el wraparound.

}

// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function onshTabRadio3()
{
	// Se crea esta funcion debido a que si
	// 
	// 1- Se focaliza Radiobutton3 haciendo wraparound estando el valor de éste en NO
	// 2- Se realiza onShTab de Radiobutton3 luego de (1).
	//
	// Por alguna razón no se focaliza el control anterior, sino que se focaliza el Frame de la pagina.
	// Esta función focaliza "a mano" el botón <Aceptar>
	focalizaBotonHTML('botonContenido', 'btnAceptar');

}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function manejaPantallaPorListaClientes()
{
	   /* Inc. 18072 - 23/6/2005 - ssantana
		   Deshabilita los controles 
			- cmbSubgerencia
			- cmbRegión
			- cmbZona
			- cmbTerritorio
			- txtObservaciones
			- cmbSubtipoCliente
			- cmbTipoClasificación
			- cmbClasificación
			- cmbEstado
			- cmbCriterioAsinacion 
		
		Y Limpia las variables correspondientes a los criterios de Asignacion */

		/*
			Agregado por ssantana, 26/04/2006
			Si existe lista de Clientes y los campos Promedio y Unidades no tienen valor, 
			o ambos tiene valor, estos campos se habilitan
			para permitirle al usuario modificarlos.
		*/
		var txtPromedio = get("frmUnico.txtPromedio");
		var txtUnidades = get("frmUnico.txtUnidades");

		if ( (txtPromedio == "" && txtUnidades == "") ||
				(txtPromedio != "" && txtUnidades != "") ) {
		   accion("frmUnico.txtPromedio", ".disabled=false");
		   accion("frmUnico.txtUnidades", ".disabled=false");
		}
		/* 
			Fin Agregado por ssantana, 26/04/2006
		 */

		accion("frmUnico.cbSubgerencia", ".disabled=true");
		accion("frmUnico.cbRegion", ".disabled=true");
		accion("frmUnico.cbZona", ".disabled=true");
		accion("frmUnico.atxtObservaciones", ".disabled=true");
		accion("frmUnico.cbSubtipoCliente", ".disabled=true");
		accion("frmUnico.cbTipoClasificacionCliente", ".disabled=true");
		accion("frmUnico.cbClasificacionCliente", ".disabled=true");
		accion("frmUnico.cbEstado", ".disabled=true");
		accion("frmUnico.cbCriterioAsignacion", ".disabled=true");

		var arrayVacio = new Array();
		arrayVacio[0] = ["", ""];


		set_combo("frmUnico.cbSubgerencia", arrayVacio);
		set("frmUnico.cbSubgerencia", new Array() );

		set_combo("frmUnico.cbRegion", arrayVacio);
		set("frmUnico.cbRegion", new Array() );

		set_combo("frmUnico.cbZona", arrayVacio);
		set("frmUnico.cbZona", new Array() );

		set("frmUnico.atxtObservaciones", "" );

		set_combo("frmUnico.cbSubtipoCliente", arrayVacio);
		set("frmUnico.cbSubtipoCliente", new Array() );

		set_combo("frmUnico.cbTipoClasificacionCliente", arrayVacio);
		set("frmUnico.cbTipoClasificacionCliente", new Array() );

		set_combo("frmUnico.cbClasificacionCliente", arrayVacio);
		set("frmUnico.cbClasificacionCliente", new Array() );

		set_combo("frmUnico.cbEstado", arrayVacio);
		set("frmUnico.cbEstado", new Array() );

		set("frmUnico.cbCriterioAsignacion", new Array() );

		borrarVariablesCriterios();
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function seleccionaComboFormaCobro() {
	/*
		Agregado por ssantana, 24/11/2005, inc. 21444
	*/
	var cantElementos = combo_get("frmUnico.cbFormaCobro", "L", null);
	var elementoUltimaPosicion = combo_get("frmUnico.cbFormaCobro", "V", cantElementos-1);

	var array = new Array();
	array[0] = elementoUltimaPosicion;

	set("frmUnico.cbFormaCobro", array);
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
function seleccionComboFormaPago() {
	/*
		Agregado por ssantana, 24/11/2005, inc. 21444
	*/
	var cantElementos = combo_get("frmUnico.cbFormaPago", "L", null);
	var elementoUltimaPosicion = combo_get("frmUnico.cbFormaPago", "V", cantElementos-1);

	var array = new Array();
	array[0] = elementoUltimaPosicion;

	set("frmUnico.cbFormaPago", array);
}


// Agregado por SICC20070356 - Rafael Romero - 05/09/2007
function establecerValoresDefecto(){
    var vdAcce = get('frmUnico.hOidAcce');
    var vdSubAcce = get('frmUnico.hOidSubAcce');
    var vdTipOfer = get('frmUnico.hOidTipOfer');
    var vdSubTipoClie = get('frmUnico.hOidSubTipClie');
    var vdCicVida = get('frmUnico.hOidCicVida');
    var vdCriAsig = get('frmUnico.hOidCriAsig');
    var vdTipDesp = get('frmUnico.hOidTipDesp');
    var vdPerFin = get('frmUnico.varPeriodo');
    
    if(vdAcce != null && vdAcce!=''){
        set('frmUnico.cbAcceso',[vdAcce]);
        cambiaAcceso();
        if(vdSubAcce != null && vdSubAcce!=''){
            set('frmUnico.cbSubacceso',[vdSubAcce]);
        }
    }
    if(vdTipOfer != null && vdTipOfer!=''){
        set('frmUnico.cbTipoOferta',[vdTipOfer]);
    }
    if(vdSubTipoClie != null && vdSubTipoClie!=''){
        set('frmUnico.cbSubtipoCliente',[vdSubTipoClie]);
        cambiaTiposClasificacion();
    }
    if(vdCicVida != null && vdCicVida!=''){
        set('frmUnico.cbCicloVida',[vdCicVida]);
    }
    if(vdCriAsig != null && vdCriAsig!=''){
        set('frmUnico.cbCriterioAsignacion',[vdCriAsig]);
        onchangeCriterioAsignacion();
    }
    if(vdTipDesp != null && vdTipDesp!=''){
        set('frmUnico.cbTipoDespacho',[vdTipDesp]);
        cambiaDespacho('noDetalle');
    }
    if(vdPerFin != null && vdPerFin!=''){
        set('frmUnico.cbPeriodoFin',[vdPerFin]);
    }
    
    set('frmUnico.rbEnviarMensaje2','N');
    set('frmUnico.rbEnviarMensaje3','N');
    
    revisarCombo('frmUnico.cbFormaCobro');
    revisarCombo('frmUnico.cbFormaPago');
    
    revisarCombo('frmUnico.cbTipoOferta');
    revisarCombo('frmUnico.cbCicloVida');
    revisarCombo('frmUnico.cbTipoDespacho');

	// sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
	set('frmUnico.rbExclusionTipoClasificacion','N');
}


function revisarCombo(combo){
	var cantElementos = combo_get(combo, "L", null);
    if(cantElementos==2){
        var elementoUltimaPosicion = combo_get(combo, "V", cantElementos-1);
        var array = new Array();
        array[0] = elementoUltimaPosicion;
        set(combo, array);
        del_combo(combo,0);
    }
}


// Fin agregado SICC20070356

function desProducto(){
		 eval('frmUnico').oculto = 'S';			       
  	     set('frmUnico.conectorAction','LPCompletaDatosBP');
		 set('frmUnico.accion', 'desProducto'); 
		 enviaSICC('frmUnico'); 
}
function fverProducto(desProducto){
	set('frmUnico.varDesProducto', desProducto);
	txt_to('lblDesProducto',get('frmUnico.varDesProducto'));	
	
}
function fBuscarErr(){
	focaliza('frmUnico.txtCodProducto');
	//set('frmUnico.txtCodProducto', '');
	set('frmUnico.varDesProducto','');
	txt_to('lblDesProducto',get('frmUnico.varDesProducto'));	

}

// ------------------------------------------------------------------------------------------------------------
function listaRegionZonas()
{
	var obj = new Object();
	obj.varListaSubgerencia = get("frmUnico.cbSubgerencia");
	obj.varListaRegiones = get("frmUnico.cbRegion");
	obj.varListaZonas = get("frmUnico.cbZona");
	obj.varListaUnidades = get("frmUnico.varListaUnidades");
	obj.estadoProceso = get('frmUnico.varEstadoProceso');
	
	var array = mostrarModalSICC('LPCargaListaRegionZonas','',obj);

	if (array != null)	{
		// Subgerencia
		var subgerencia = array[0];
		if ( subgerencia != "" )
		{
			subgerencia = parseaArray(subgerencia);
			marcaCombo("cbSubgerencia", subgerencia);
			cambiaRegion();
		}		
		
		// Region
		var region = array[1];
		if ( region != "")
		{
			region = parseaArray(region);
			marcaCombo("cbRegion", region)
			cambiaZona();
		}

		// Zona
		var zona = array[2];
		if ( zona != "")
		{
			zona = parseaArray(zona);
			marcaCombo("cbZona", zona);
		}
		
		// Unidades
		var unidades = array[3];
		if ( unidades != "")
		{
			set("frmUnico.varListaUnidades", unidades);
		}
	}
	return;
}
