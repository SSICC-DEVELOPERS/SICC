var auxAccion="";
var varNoLimpiarSICC = true;
var listaModif;
var arZonasReg;

function inicializaListaModif(){
	listaModif = new Object();
	listaModif.length =0;
	listaModif.keys = new Array();
}
function onLoadPag(){

		inicializaListaModif();
		configurarMenuSecundario("frmContenido");

		fMostrarMensajeError();

	    DrdEnsanchaConMargenDcho('listado1',12);
	    
		setTimeout('eval (ON_RSZ)',200);

		set('frmContenido.hSiI18N', GestionarMensaje('84'));
		set('frmContenido.hNoI18N', GestionarMensaje('86'));

		if( get('frmContenido.hCargarMarcaCanalDefecto')=='S' ){
			cargarMarcaCanalDefecto();
		}
	
		if( get('frmContenido.hAsignarCombosBusqueda')=='S' ){
			posicionarCombosBusqueda();
		}

		if( get('frmContenido.accion') == '' ) {
			//set_combo('frmContenido.cbZona', ['','']);
			//accion('frmContenido.cbZona', '.disabled=true');
			set_combo('frmContenido.cbSubtipoCliente', ['','']);
			set_combo('frmContenido.cbTipoClasificacion', ['','']);
			set_combo('frmContenido.cbClasificacion', ['','']);
			accion('frmContenido.cbSubtipoCliente', '.disabled=true');
			accion('frmContenido.cbTipoClasificacion', '.disabled=true');
			accion('frmContenido.cbClasificacion', '.disabled=true');
		}
		
		cargaZona();
		habilitarListaRegionZona();

		focaliza('frmContenido.cbMarca');
		
	}

function fLimpiar(){

	if( get_visibilidad('capaContenido2') != false ){
		/*setMV('frmContenido.cbMarca', 'N');
		setMV('frmContenido.cbCanal', 'N');
		setMV('frmContenido.cbPeriodo', 'N');

		setMV('frmContenido.txtCodigoVenta', 'N');
		set_combo('frmContenido.cbZona', ['','']);
		accion('frmContenido.cbZona', '.disabled=true');
		set_combo('frmContenido.cbSubtipoCliente', ['','']);
		set_combo('frmContenido.cbTipoClasificacion', ['','']);
		set_combo('frmContenido.cbClasificacion', ['','']);
		accion('frmContenido.cbSubtipoCliente', '.disabled=true');
		accion('frmContenido.cbTipoClasificacion', '.disabled=true');
		accion('frmContenido.cbClasificacion', '.disabled=true');*/
		limpiarCamposPantalla();
	}else{
		limpiarCamposPantalla();
		cargarMarcaCanalDefecto();
		set('frmContenido.cbPeriodo', '');
	}
	focaliza('frmContenido.cbMarca');

}

function cargarMarcaCanalDefecto(){
	var array = new Array();

	array[0] = get('frmContenido.hMarcaDefecto');
	set('frmContenido.cbMarca', array);
	array[0] = get('frmContenido.hCanalDefecto');
	set('frmContenido.cbCanal', array);
	recargaComboPeriodo();
}

function ocultarLista(){
	document.all["Cplistado1"].style.visibility='hidden';
	document.all["CpLin1listado1"].style.visibility='hidden';
	document.all["CpLin2listado1"].style.visibility='hidden';
	document.all["CpLin3listado1"].style.visibility='hidden';
	document.all["CpLin4listado1"].style.visibility='hidden';

	document.all["primera1Div"].style.visibility='hidden';
	document.all["ret1Div"].style.visibility='hidden';
	document.all["ava1Div"].style.visibility='hidden';
	document.all["separaDiv"].style.visibility='hidden';
	document.all["ModificarDiv"].style.visibility='hidden';
	document.all["EliminarDiv"].style.visibility='hidden';
}


function mostrarLista(){
	document.all["Cplistado1"].style.visibility='visible';
	document.all["CpLin1listado1"].style.visibility='visible';
	document.all["CpLin2listado1"].style.visibility='visible';
	document.all["CpLin3listado1"].style.visibility='visible';
	document.all["CpLin4listado1"].style.visibility='visible';

	document.all["primera1Div"].style.visibility='visible';
	document.all["ret1Div"].style.visibility='visible';
	document.all["ava1Div"].style.visibility='visible';
	document.all["separaDiv"].style.visibility='hidden';
	document.all["ModificarDiv"].style.visibility='visible';
	document.all["EliminarDiv"].style.visibility='visible';
}

function onClickBuscar(){
	if( sicc_validaciones_generales('GrupoBusqueda') ){
        ocultarLista();
		auxAccion="";
		configurarPaginado(mipgndo,"PEDConsultaGestionStock",
                              "ConectorConsultaGestionStock2",
                              "es.indra.sicc.dtos.ped.DTOListaGestionStock",
                              armaArray());
		
		visibilidad( 'capaContenido2', 'V' );

		mostrarLista();

	}
}


function onClickAnyadir(){
	//1° - Se valida que existan valores para los campos:
	// - Combo Tipo cliente
	// - Limite venta, control stock o contro stock porcentual
	if( sicc_validaciones_generales('GrupoAnyadir') ){

		//2° - Se valida que exista un valor para el Combo Codigo venta
		if( combo_get('frmContenido.cbCodVenta2', 'L') <= 1 ){
			GestionarMensaje('PED-0002');
			focaliza('frmContenido.txtCodigoVenta');
			return;
		}

		var ultimasNoticias = get('frmContenido.chkUltimasNoticias');
		var limiteVenta = get('frmContenido.txtLimiteVenta');

		var controlStock = get('frmContenido.txtControlStock');
		var controlStockPorcentual = get('frmContenido.txtControlStockPorcentual');
		var controlLiquidacion = get('frmContenido.chkControlLiquidacion');


		//Se valida que se ingrese al menos un valor para limite venta, control stock, control stock
		//porcentual

		if( controlStock == '' && controlStockPorcentual == '' && limiteVenta == '' && controlLiquidacion == 'N' ){
			GestionarMensaje('1431');
			//Debe introducir al menos un valor de Límite de Venta, Control de Stock o Control de Liquidación
			return;
		}

		// Incidencia BELC300011088:
		// 2.- Si se rellenan los campos txtControlStock y txtControlStockPorcentual se mostrará un mensaje al 
		// usuario "Se ha especificado un Control de Stock en unidades y en porcentaje" Sino se continúa el proceso. 
		if( controlStock != '' &&  controlStockPorcentual != '' ){
			GestionarMensaje('1343');
			return;
		}


		//Recupera los oids de los combos

		var oidRegion ;
		var oidZona ;
		//var oidRegion = get('frmContenido.cbRegion');
		//var oidZona = get('frmContenido.cbZona');
		var oidTipoCliente = get('frmContenido.cbTipoCliente');
		var oidSubtipoCliente = get('frmContenido.cbSubtipoCliente');
		var oidTipoClasificacion = get('frmContenido.cbTipoClasificacion');
		var oidClasificacion = get('frmContenido.cbClasificacion');

		//Recupera los textos de los combos

		var txtRegion ;
		var txtZona ;
		//var txtRegion = recuperaTextoCombo('frmContenido.cbRegion', oidRegion[0]);
		//var txtZona = recuperaTextoCombo('frmContenido.cbZona', oidZona[0]);
		var txtTipoCliente = recuperaTextoCombo('frmContenido.cbTipoCliente', oidTipoCliente[0]);
		var txtSubtipoCliente = recuperaTextoCombo('frmContenido.cbSubtipoCliente', oidSubtipoCliente[0]);
		var txtTipoClasificacion = recuperaTextoCombo('frmContenido.cbTipoClasificacion', oidTipoClasificacion[0]);
		var txtClasificacion = recuperaTextoCombo('frmContenido.cbClasificacion', oidClasificacion[0]);

		//SE DESHABILITA EL BOTON DE BUSQUEDA
		deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');

		//Se guardan las descripciones para actualizar la lista editable
		
		var codSelecListaEdi = get('frmContenido.hCodSeleccionadosEnListaEditable');
		inicializaListaModif();
		if (codSelecListaEdi !='' && codSelecListaEdi != null){ // Modificando un elemento que ya estaba en la lista editable
			if (listaModif[codSelecListaEdi]== null){
				listaModif.keys[listaModif.length] = codSelecListaEdi;
				listaModif.length = listaModif.length + 1;
			}
			var longitud = combo_get('frmContenido.cbCodVenta2', 'L');
			for ( i = 0; i < longitud ; i++ ){
				if (combo_get('frmContenido.cbCodVenta2', 'V', i)!=''){
					// Comentado por Rafael Romero - 16/05/2005
					//oidRegion = quitarItemVacio(get('frmContenido.cbRegion'))[0];
					//txtRegion = obtenerRegion(oidRegion);
					//var aroZoRdZ = quitarItemVacio(get('frmContenido.cbZona'))[0];
					//oidZona = aroZoRdZ.substr(0,aroZoRdZ.indexOf('@'));
					//txtZona = aroZoRdZ.substr(aroZoRdZ.indexOf('$')+1, aroZoRdZ.length - aroZoRdZ.indexOf('$')); 

					listaModif[codSelecListaEdi] = [codSelecListaEdi, //0
								listado1.extraeDato(codSelecListaEdi,6), //oidRegion, // 1
                                listado1.extraeDato(codSelecListaEdi,7), //txtRegion, // 2
								listado1.extraeDato(codSelecListaEdi,8), //oidZona, // 3
                                listado1.extraeDato(codSelecListaEdi,9), //txtZona, // 4
								listado1.extraeDato(codSelecListaEdi,10), //oidTipoCliente, // 5
                                listado1.extraeDato(codSelecListaEdi,11), //txtTipoCliente, // 6
								listado1.extraeDato(codSelecListaEdi,12), //oidSubtipoCliente, // 7
                                listado1.extraeDato(codSelecListaEdi,13), //txtSubtipoCliente, // 8
								listado1.extraeDato(codSelecListaEdi,14), //oidTipoClasificacion, //9
                                listado1.extraeDato(codSelecListaEdi,15), //txtTipoClasificacion, //10
								listado1.extraeDato(codSelecListaEdi,16), //oidClasificacion, // 11
                                listado1.extraeDato(codSelecListaEdi,17), //txtClasificacion,// 12
								get('frmContenido.txtLimiteVenta'),//13
								get('frmContenido.txtControlStock'),//14
								get('frmContenido.txtControlStockPorcentual'),//15
								get('frmContenido.chkControlLiquidacion'),//16
								get('frmContenido.chkUltimasNoticias'),//17
								combo_get('frmContenido.cbCodVenta2', 'V', i),//18
								combo_get('frmContenido.cbCodVenta2', 'T', i),//19
								"N"]; //20 indicador eliminar
								
				}
			}
	
		}else {// Insertando uno nuevo un elemento hacia la lista editable
			oidRegion = inicializaOid();
			txtRegion = "";
			oidZona = inicializaOid();
			txtZona = "";
			var nuevoCodigo;
			var longitud = combo_get('frmContenido.cbCodVenta2', 'L');
			var longitudregion = 0;
			var longitudzona = 0;
			var arRegion = quitarItemVacio(get('frmContenido.cbRegion'));
			var arZona = quitarItemVacio(get('frmContenido.cbZona'));
			if (arRegion.length){
				longitudregion = arRegion.length;
			}
			if (arZona.length){
				longitudzona = arZona.length;
			}
			var auxArRegion = new Array(); //CONTIENE LOS CODIGOS DE REGION ESCOGIDOS CON UN FLAG QUE INDICA SI TIENE ZONAS O NO ASOCIADAS
			auxArRegion = IniciarListRegionwFlag(arRegion);
			//valido que haya datos en lista de codigos de venta
			
			//Si es que eligio option button Zona y los longitudes de codigos de venta y zonas son mayores que cero
			// Y ELIGIO POR LO MENOS UNA ZONA
			if (get("frmContenido.rbTipoUbic")=="Z" && 0 < longitud && 0 < longitudzona ) { 
				//SE GRABA TODAS LAS ZONAS E INTERNAMENTE SE BUSCA EN EL ARREGLO arZonasReg
				//SU CORRESPONDIENTE REGION
				//SI ES QUE NO ESCOGIO ZONA GRABA REGION CON VALOR NULO EN LUGAR DE ZONA
				for ( i = 0; i < longitud ; i++ ){
					if (combo_get('frmContenido.cbCodVenta2', 'V', i)!=''){
						for ( k = 0; k < longitudzona ; k++ ){
							var aroZoRdZ = arZona[k];
							oidRegion = aroZoRdZ.substr(aroZoRdZ.indexOf('@')+1, aroZoRdZ.indexOf('$')- aroZoRdZ.indexOf('@')-1);
							txtRegion = obtenerRegion(oidRegion);

							oidZona = aroZoRdZ.substr(0,aroZoRdZ.indexOf('@'));
							txtZona = aroZoRdZ.substr(aroZoRdZ.indexOf('$')+1, aroZoRdZ.length - aroZoRdZ.indexOf('$')); 
							
							nuevoCodigo = 'nuevoItem' + listaModif.length ;
							listaModif.keys[listaModif.length] = nuevoCodigo ;
							listaModif.length = listaModif.length + 1;
							
							listaModif[nuevoCodigo] = [nuevoCodigo,//0
								oidRegion,txtRegion, //1,2
								oidZona,txtZona,     //3,4
								oidTipoCliente,txtTipoCliente, // 5,6
								oidSubtipoCliente,txtSubtipoCliente,//7,8
								oidTipoClasificacion,txtTipoClasificacion,//9,10
								oidClasificacion,txtClasificacion,//11,12
								get('frmContenido.txtLimiteVenta'),//13
								get('frmContenido.txtControlStock'),//14
								get('frmContenido.txtControlStockPorcentual'),//15
								get('frmContenido.chkControlLiquidacion'),//16
								get('frmContenido.chkUltimasNoticias'),//17
								combo_get('frmContenido.cbCodVenta2', 'V', i),//18
								combo_get('frmContenido.cbCodVenta2', 'T', i),//19
								"N"];//20 indicador eliminar
						}
					}
				}
			}
			else if(get("frmContenido.rbTipoUbic")=="R" && 0 < longitud && 0 < longitudregion ){
				//HA ELEGIDO OPTION BUTTON DE REGION Y HA SELECCIONADO POR LO MENOS UNA REGION
				//ENVIAR TODAS LAS REGIONES (DE LA FORMA REGION,NULO)
				//ES DECIR NULO EN LUGAR DE ZONA
				for ( i = 0; i < longitud ; i++ ){
					if (combo_get('frmContenido.cbCodVenta2', 'V', i)!=''){
						for ( j = 0; j < longitudregion ; j++ ){
							oidRegion = arRegion[j];
							txtRegion = obtenerRegion(arRegion[j]);

							oidZona = inicializaOid();
							txtZona = "";
							
							nuevoCodigo = 'nuevoItem' + listaModif.length ;
							listaModif.keys[listaModif.length] = nuevoCodigo ;
							listaModif.length = listaModif.length + 1;
							
							listaModif[nuevoCodigo] = [nuevoCodigo,//0
								oidRegion,txtRegion, //1,2
								oidZona,txtZona,     //3,4
								oidTipoCliente,txtTipoCliente, // 5,6
								oidSubtipoCliente,txtSubtipoCliente,//7,8
								oidTipoClasificacion,txtTipoClasificacion,//9,10
								oidClasificacion,txtClasificacion,//11,12
								get('frmContenido.txtLimiteVenta'),//13
								get('frmContenido.txtControlStock'),//14
								get('frmContenido.txtControlStockPorcentual'),//15
								get('frmContenido.chkControlLiquidacion'),//16
								get('frmContenido.chkUltimasNoticias'),//17
								combo_get('frmContenido.cbCodVenta2', 'V', i),//18
								combo_get('frmContenido.cbCodVenta2', 'T', i),//19
								"N"];//20 indicador eliminar
						}
					}
				}			
			}		
			else{
				//EN CASO NO HAYA ELEGIDO NI REGION NI ZONA, OSEA QUE SOLO HAYA DEJADO MARCADO EL OPTION BUTTON REGION O ZONA
				for ( i = 0; i < longitud ; i++ ){
					if (combo_get('frmContenido.cbCodVenta2', 'V', i)!=''){
						nuevoCodigo = 'nuevoItem' + listaModif.length ;
						listaModif.keys[listaModif.length] = nuevoCodigo ;
						listaModif.length = listaModif.length + 1;
						
						listaModif[nuevoCodigo] = [nuevoCodigo,//0
							oidRegion,txtRegion, //1,2
							oidZona,txtZona,     //3,4
							oidTipoCliente,txtTipoCliente, // 5,6
							oidSubtipoCliente,txtSubtipoCliente,//7,8
							oidTipoClasificacion,txtTipoClasificacion,//9,10
							oidClasificacion,txtClasificacion,//11,12
							get('frmContenido.txtLimiteVenta'),//13
							get('frmContenido.txtControlStock'),//14
							get('frmContenido.txtControlStockPorcentual'),//15
							get('frmContenido.chkControlLiquidacion'),//16
							get('frmContenido.chkUltimasNoticias'),//17
							combo_get('frmContenido.cbCodVenta2', 'V', i),//18
							combo_get('frmContenido.cbCodVenta2', 'T', i),//19
							"N"];//20 indicador eliminar
					}
				}			
			}
			//} // if de valiadacion de que haya codigos de venta
		}// fin else
		
		var objParamsInt = new Object();
		objParamsInt.opener = window;
		objParamsInt.destino ='LPMantieneGestionStock';
		objParamsInt.conectorAction= 'LPMantieneGestionStock';
		listaModif.accion = 'guarda2'; 
		listaModif.hPeriodo = get('frmContenido.cbPeriodo');
		objParamsInt.parametros = listaModif;
		setValues(objParamsInt);
		auxAccion="";
		//*/[1]
	}// fin validaciones
}// fin funcion

function actualizaListado1(codSelecListaEdi){

	var i=DrIndiceEnArray(listado1.datos,codSelecListaEdi,0);
	if(i != -1){
        
		listado1.datos[i][7]= listaModif[codSelecListaEdi][1];
		listado1.datos[i][8]= listaModif[codSelecListaEdi][2];
		listado1.datos[i][9]= listaModif[codSelecListaEdi][3];
		listado1.datos[i][10]= listaModif[codSelecListaEdi][4];
		listado1.datos[i][11]= listaModif[codSelecListaEdi][5];
		listado1.datos[i][12]= listaModif[codSelecListaEdi][6];
		listado1.datos[i][13]= listaModif[codSelecListaEdi][7];
		listado1.datos[i][14]= listaModif[codSelecListaEdi][8];
		listado1.datos[i][15]= listaModif[codSelecListaEdi][9];
		listado1.datos[i][16]= listaModif[codSelecListaEdi][10];
		listado1.datos[i][17]= listaModif[codSelecListaEdi][11];
		listado1.datos[i][18]= listaModif[codSelecListaEdi][12];
		listado1.datos[i][19]= listaModif[codSelecListaEdi][13];
		listado1.datos[i][20]= listaModif[codSelecListaEdi][14];
		listado1.datos[i][21]= listaModif[codSelecListaEdi][15];
		var s = GestionarMensaje(84);
		var n = GestionarMensaje(86);
		//16: chkControlLiquidacion
		//17: chkUltimasNoticias
		listado1.datos[i][22]= (listaModif[codSelecListaEdi][16]=='S')?s:n;
		listado1.datos[i][23]= (listaModif[codSelecListaEdi][17]=='S')?s:n;
		//listado1.actualizaDat()
		listado1.repinta();

		//HABILITAR TIPO CLIENTE
		accion('frmContenido.cbTipoCliente', '.disabled=false');
		//LIMPIAR EL CODIGO SELECCIONADO EN LA LISTA EDITABLE DEBIDO 
		//A QUE ACABA DE MODIFICARLO
		set('frmContenido.hCodSeleccionadosEnListaEditable', '');
	}
	
}
function setValues(objParams){
	if(objParams.parametros){

		var atributos;
		//Limpio todos los campos insertados del frm que envio
		eliminaElementosDinamicos();
		for(atributos in objParams.parametros){
			if(atributos != "window" && atributos != "length"){
				var hidden = document.createElement("INPUT");
				hidden.type = "hidden";
				hidden.insertado = "1";
				hidden.name = atributos;
				hidden.value = (objParams.parametros[atributos]==null)?"":objParams.parametros[atributos];
				document.forms["frmContenidoEnvia"].appendChild(hidden);
			}
		}
		set('frmContenidoEnvia.conectorAction', objParams.conectorAction);
		enviaSICC("frmContenidoEnvia");
	}
	
}

function resultadoGuardado(codSeleccionado, blnEliminar){
	if (blnEliminar== 0){
		actualizaListado1(codSeleccionado);
		limpiarCamposPantalla();
		//EN CASO SEA UNA INSERCION VIENE codSeleccionado EN NULL
		if(codSeleccionado==null){
			onClickBuscar();
			
		}
	}else if (blnEliminar== 1){
		eliminarRegistrosLista ();
		limpiarCamposPantalla();
		
	}

}

function eliminarRegistrosLista(){
	onClickBuscar();
	
}

/*Limpio todos los campos insertados 
dinámicamente porque sino crea otros con el mismo nombre y se arma bardo
*/
function eliminaElementosDinamicos(){
	var elementos = document.forms["frmContenidoEnvia"].elements;
	var longitud = elementos.length;
	for ( i = 0;i < longitud; i++ ){
		var oChild=document.forms["frmContenidoEnvia"].children(i);	
		if (oChild!= null && oChild.insertado=="1"){
			document.forms["frmContenidoEnvia"].removeChild(oChild);
			i = i-1;
		}
	}
}

function limpiarCamposPantalla(){
	inicializaListaModif();
	set_combo ('frmContenido.cbCodVenta2',new Array(new Array('','')));

	//set ('frmContenido.txtCodigoVentaBuscar','');
	set ('frmContenido.cbRegion','');
	set ('frmContenido.cbZona','');
	set ('frmContenido.cbTipoCliente','');
	set ('frmContenido.cbSubtipoCliente','');
	set ('frmContenido.cbTipoClasificacion','');
	set ('frmContenido.cbClasificacion','');

	set ('frmContenido.txtCodigoVenta','');
	set ('frmContenido.txtLimiteVenta','');
	set ('frmContenido.txtControlStock','');
	set ('frmContenido.txtControlStockPorcentual','');
	set ('frmContenido.chkControlLiquidacion','N');
	set ('frmContenido.chkUltimasNoticias','N');
	set ('frmContenido.hCodSeleccionadosEnListaEditable','');

	
	habilitarControlesCodigoVenta();
			
	//SE HABILITA EL BOTON DE BUSQUEDA
	deshabilitarHabilitarBoton('botonContenido','btnAnadir','A');
}

function estadoCampos(valorABM){
	if (valorABM == 'A'){
		habilitarControlesCodigoVenta();

	}else if (valorABM == 'M'){
		deshabilitarControlesCodigoVenta();

	}else if (valorABM == 'B'){
		habilitarControlesCodigoVenta();
	}
}

function recuperaTextoCombo(combo, oid){
	var len;
	var temp;
	var texto = '';

	len = combo_get(combo, 'L');

	for(i = 0; i < len; i++){
		temp = combo_get(combo, 'V', i);
		if(temp == oid){
			texto = combo_get(combo, 'T', i);
			break;
		}
	}
	return texto
}

function onClickBuscarCodVenta(){
	var parametros = new Object();
	var array;
	var registros;

	parametros.hPeriodo = get('frmContenido.cbPeriodo');
	parametros.varPeriodo = get('frmContenido.cbPeriodo');
	var modifiedData = mostrarModalSICC("LPMantieneGestionStock", "buscarCodVenta", parametros );

	if( modifiedData != null){
		for( i = 0; i < modifiedData.length; i++ ){
			combo_add( 'frmContenido.cbCodVenta2', modifiedData[i].codigoVenta, modifiedData[i].txtCodigoVenta + " - " + modifiedData[i].descripcionSAP);
		}
	}
}

function onClickModificar(){
	auxAccion="M";
	setMV('frmContenido.txtCodigoVenta', 'N');
	setMV('frmContenido.cbTipoCliente', 'N');
	limpiarCamposPantalla();
	var seleccionados = listado1.codSeleccionados();
    var sel;
	if( seleccionados.length == 1 ){
		set( 'frmContenido.hTipoClasificacion' , listado1.datos[DrIndiceEnArray(listado1.datos,seleccionados[0],0)][15]);
		set( 'frmContenido.hClasificacion' , listado1.datos[DrIndiceEnArray(listado1.datos,seleccionados[0],0)][17]);
		inicializaListaModif();
		var objParamsInt = new Object();
		objParamsInt.opener = window;
		objParamsInt.destino ='LPMantieneGestionStock';
		objParamsInt.conectorAction= 'LPMantieneGestionStock';
		listaModif.accion = 'muestra2';
		objParamsInt.parametros = listaModif;
		objParamsInt.claves = listaModif.keys;
		defineSeleccionados();
		estadoCampos ('M');
	}else if( seleccionados.length > 1 ){
		GestionarMensaje('8');
	}else{
		GestionarMensaje('4');
	}
}

var listaDependencias = new Object();
listaDependencias['cbRegion'] = ['onChangeRegion();'];
listaDependencias['cbTipoCliente'] = ['onChangeTipoClienteRecargaLista();'];
listaDependencias['cbSubtipoCliente'] = ['onChangeSubtipoCliente();'];

function asignarArrayAComboGen(datos, combo,posicion){
	if( datos != null && datos.length > 0 ){
		
		var  arr = new Array();

        arr[arr.length] = new Array([''],['']);
        for (var i=0 ;i< datos.length ; i++)  {
            arr[arr.length] = datos[i];
        }

		set_combo('frmContenido.'+combo,arr);
		var i=DrIndiceEnArray(listado1.datos,listado1.codSeleccionados()[0],0);

		if (listado1.datos[i][posicion]!= null && listado1.datos[i][posicion]!=''){
			arr = new Array(listado1.datos[i][posicion]);
			set( 'frmContenido.'+combo,arr);
			var arrDepend = listaDependencias[combo];
			if (arrDepend!=null){
				eval(arrDepend[0]);
			}
		}
	}
}

function MakeParametersSG(){
        var arr = new Array();
        arr[arr.length] = new Array("oidPais", get('frmContenido.hPais'));
		arr[arr.length] = new Array("oidIdioma", get('frmContenido.hIdioma'));
        return arr;
}

function defineSeleccionados(){
	var seleccionados = listado1.codSeleccionados();
    
	set('frmContenido.hCodSeleccionadosEnListaEditable', seleccionados[0]);
	var i=DrIndiceEnArray(listado1.datos,seleccionados[0],0);
	var datosListado = listado1.datos[i];
	
    /*
	if (datosListado[9]!= null && datosListado[9]!=''){
		set( 'frmContenido.hZona', datosListado[9]+'@'+datosListado[7]+'$'+datosListado[10]);
	}

	if (datosListado[13]!= null && datosListado[13]!=''){
		set( 'frmContenido.hSubtipoCliente', datosListado[13] );
	}
    */
    
	set_combo('frmContenido.cbCodVenta2', [['',''],[datosListado[2],datosListado[3] + " - " + datosListado[4]]]);
    set ('frmContenido.cbCodVenta2',[datosListado[2]]);
    
	/*
    SiCC20070284 - Rafael Romero - 12/06/2007
    Los valores de los combos de Zona, Region, Tipo de Cliente, Subtipo Cliente,
    Tipo Clasificacion y Clasificacion no son editables.
    Se llenaran los combos con los valores del registro seleccionado
    asignar([['COMBO','frmContenido.cbTipoCliente',
                          'ConectorDruidaTransactionQuery',
                          'dtoSalida.resultado_ROWSET',
                          formarCadenaDT('MAEObtenerTipos', 
                            'es.indra.sicc.util.DTOBelcorp', 
                           MakeParametersSG() ), 
						  'asignarArrayAComboGen(datos,"cbTipoCliente",11);']]);	
	
	asignar([['COMBO','frmContenido.cbRegion',
                          'ConectorDruidaTransactionQuery',
                          'dtoSalida.resultado_ROWSET',
                          formarCadenaDT('ZONRecargaRegiones', 
                          'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
                           MakeParametersSG() ), 
						  'asignarArrayAComboGen(datos,"cbRegion",7);']]);	
    */
    set('frmContenido.cbRegion',[datosListado[7]]);
    if(datosListado[9]!= null && datosListado[9]!=''){
        set('frmContenido.cbZona',[datosListado[9]+"@"+datosListado[7]+"$"+datosListado[10]]);
    }else{
        set('frmContenido.cbZona',['']);
    }
    set('frmContenido.cbTipoCliente',[datosListado[11]]);
	set_combo('frmContenido.cbSubtipoCliente', [[datosListado[13],datosListado[14]]]);
    set('frmContenido.cbSubtipoCliente',[datosListado[13]]);
	set_combo('frmContenido.cbTipoClasificacion', [[datosListado[15],datosListado[16]]]);
    set('frmContenido.cbTipoClasificacion',[datosListado[15]]);
	set_combo('frmContenido.cbClasificacion', [[datosListado[17],datosListado[18]]]);
    set('frmContenido.cbClasificacion',[datosListado[17]]);

	if (datosListado[19]!= null && datosListado[19]!=''){
		set( 'frmContenido.txtLimiteVenta', datosListado[19] );
	}
	if (datosListado[20]!= null && datosListado[20]!=''){
		set( 'frmContenido.txtControlStock', datosListado[20] );
	}
	if (datosListado[21]!= null && datosListado[21]!=''){
		set( 'frmContenido.txtControlStockPorcentual', datosListado[21] );
	}

	var s = GestionarMensaje(84);
	var n = GestionarMensaje(86);
	if (datosListado[22]!= null && datosListado[22]!=''){
		if(datosListado[22] == s)
			set( 'frmContenido.chkControlLiquidacion',  'S');
		else
			set( 'frmContenido.chkControlLiquidacion',  'N' );			
	}
	if (datosListado[23]!= null && datosListado[23]!=''){
		if(datosListado[23] == s)
			set( 'frmContenido.chkUltimasNoticias',  'S' );
		else
			set( 'frmContenido.chkUltimasNoticias',  'N' );
	}
	//HHERNANDEZ-20070423: Deshabilitar las listas de seleccion multiple
	accion('frmContenido.cbCodVenta2', '.disabled=true');
	accion('frmContenido.cbZona', '.disabled=true');
	accion('frmContenido.cbRegion', '.disabled=true');
	accion('frmContenido.cbTipoCliente', '.disabled=true');
	accion('frmContenido.cbSubtipoCliente', '.disabled=true');
	accion('frmContenido.cbTipoClasificacion', '.disabled=true');
	accion('frmContenido.cbClasificacion', '.disabled=true');
	//DESHABILITANDO LOS RADIO
	var lstRadio=eval(eval("frmContenido.rbTipoUbicIE"));
	for(x=0; x<(lstRadio.length); x++){
		lstRadio[x].disabled = true;
        lstRadio[x].checked = false;
	}
    // Seleccionando un RB segun las caracteristicas del registro editandose
    if(datosListado[9]!=''){
        lstRadio[1].checked = true;
    }else{
        if(datosListado[7]!=''){
            lstRadio[0].checked = true;
        }
    }

}

function fGuardar(){
	onClickAnyadir();
}

function onClickAnyadirCodigo(){

	sicc_cambiar_estado('txtCodigoVenta', true);

	if( sicc_validaciones_generales('GrupoCodigoVenta') ){

	var longitud = combo_get('frmContenido.cbCodVenta2', 'L');
	var vecOidsIngresados = new Array();
	for(i = 0; i < longitud; i++){
		if (combo_get('frmContenido.cbCodVenta2', 'V',i)!=null 
			&& combo_get('frmContenido.cbCodVenta2', 'V',i)!=''){

			vecOidsIngresados[vecOidsIngresados.length] = combo_get('frmContenido.cbCodVenta2', 'V',i);
		}

	}

	/* Comentado por HRCS - Fecha 25/06/2007 - Incidencia Sicc20070324
	var objParamsInt = new Object();
	objParamsInt.opener = window;
	objParamsInt.destino ='LPMantieneGestionStock';
	objParamsInt.conectorAction= 'LPMantieneGestionStock';

	var obj = new Object();
	obj.hOidCodigoVenta = vecOidsIngresados;
	obj.hPeriodo = get('frmContenido.cbPeriodo');
	obj.txtCodigoVenta = get('frmContenido.txtCodigoVenta');
	obj.accion = 'anyadeCodigoVenta2';
	objParamsInt.parametros = obj;
	setValues(objParamsInt);
	*/
	// Agregado por HRCS - Fecha 25/06/2007 - Incidencia Sicc20070324
	var array = new Array();
	array[0] = new Array('periodo', get('frmContenido.cbPeriodo') );
	array[1] = new Array('codigoVenta', get('frmContenido.txtCodigoVenta') );
	array[2] = new Array('oidIdioma', get('frmContenido.hIdioma') );
    asignarException = "mostrarErrorSubsistemaRecargaCombo(msgError)";
	var param = formarCadenaDT('PREBuscarCodigoVentaPeriodo3', 'es.indra.sicc.dtos.pre.DTOBuscarCodigoVentaPeriodo', array);
	var datos = new Array();
	asignar([['COMBO', 'frmContenido.cbTemporal', 'ConectorDruidaTransactionQuery', 'dtoSalida.resultado_ROWSET', param, 'salidaBusqueda(datos);']]);
	}
	//*/[1]
}

//	Agregado por HRCS - Fecha 24/06/2007 - Incidencia Sicc20070324
function salidaBusqueda(datos)	{
	//alert(datos); 
	var codigos;
	var numElem = combo_get('frmContenido.cbCodVenta2', 'L', null);
	if ( numElem > 1 )	{
		codigos = combo_get('frmContenido.cbCodVenta2', 'V', 1);
	}
	var oidCodigoVenta = '[[';
	var txtCodigoVenta = '[[';
	for(var i = 0; i<datos.length; i++)	{
		var existe = false;
		if ( numElem > 1 )	{
			for(var j = 0; (j<codigos.length && !existe); j++){
				if(codigos[j]==datos[i][0]) {
					existe = true;
				}
			}
		}
		//	Si no existe, entonces se agrega a la lista
		if(!existe)	{
			if (i==0)	{
				oidCodigoVenta = oidCodigoVenta + datos[i][0];
				txtCodigoVenta = txtCodigoVenta + datos[i][1];
			}
			else	{
				oidCodigoVenta = oidCodigoVenta + ',' + datos[i][0];
				txtCodigoVenta = txtCodigoVenta + ',' + datos[i][1];
			}
			oidCodigoVenta = oidCodigoVenta + ']]';
			txtCodigoVenta = txtCodigoVenta + ']]';
			//alert('oidCodigoVenta: ' + oidCodigoVenta );
			//alert('txtCodigoVenta: ' + txtCodigoVenta );
			anyadeCodigosVenta( oidCodigoVenta, txtCodigoVenta );
		}
	}
	return false;
}

function onClickEliminarCodigo(){

	//Se obtienen los seleccionados
	var seleccionados = get('frmContenido.cbCodVenta2');
	
	if( seleccionados != '' ){
		//Se obtienen los items de todo el combo
		var items;
		var itemsAEliminar = new Array();
		var indiceItemAEliminar = 0;
		var longitud = combo_get('frmContenido.cbCodVenta2', 'L');

		for(j = 0; j < longitud; j++){
			for(i = 0; i < seleccionados.length; i++){
				//if( combo_get('frmContenido.cbCodVenta2', 'V', j) == seleccionados[i] ){
				//	del_combo('frmContenido.cbCodVenta2', itemsAEliminar[k]);
				//}
				del_combo('frmContenido.cbCodVenta2','V', seleccionados[i]);
			}
		}

	}else{
		GestionarMensaje('4');
	}
}

function onClickEliminar(){
	var seleccionados = listado1.codSeleccionados();
	var sel;

	if( seleccionados.length >= 1 ){
		for(i = 0; i < seleccionados.length; i++){
			
			if( i == 0 ){
				sel = seleccionados[i];
			}else{
				sel = sel + '|' + seleccionados[i];
			}
		}

		inicializaListaModif();
		for(i = 0; i < seleccionados.length; i++){
			listaModif.keys[listaModif.length] = seleccionados[i];
			listaModif.length = listaModif.length +1;
			listaModif[seleccionados[i]] = [seleccionados[i],
					"","",//get('frmContenido.cbRegion'),"", //1,2
					"","",//get('frmContenido.cbZona'),"",     //3,4
					"","",//get('frmContenido.cbTipoCliente'),"", // 5,6
					"","",//get('frmContenido.cbSubtipoCliente'),"",//7,8
					"","",//get('frmContenido.cbTipoClasificacion') ,"",//9,10
					"","",//get('frmContenido.cbClasificacion'),"",//11,12
					"",//get('frmContenido.txtLimiteVenta'),//13
					"",//get('frmContenido.txtControlStock'),//14
					"",//get('frmContenido.txtControlStockPorcentual'),//15
					"",//get('frmContenido.chkControlLiquidacion'),//16
					"",//get('frmContenido.chkUltimasNoticias'),//17
					"",//18
					"",//19
					"S"	]; //20 indicador eliminar
		}
		

		var objParamsInt = new Object();
		objParamsInt.opener = window;
		objParamsInt.destino ='LPMantieneGestionStock';
		objParamsInt.conectorAction= 'LPMantieneGestionStock';
		listaModif.accion = 'guarda2'; 
		listaModif.hPeriodo = get('frmContenido.cbPeriodo');
		objParamsInt.parametros = listaModif;
		setValues(objParamsInt);		
		estadoCampos('B');
		
		
	
	}else{

		GestionarMensaje('4');
	}
}

function onChangeMarca(){
	GestionarComboPeriodo();
}

function onChangeCanal(){
	GestionarComboPeriodo();
}

function GestionarComboPeriodo(){
	if( get('frmContenido.cbMarca')=='' || get('frmContenido.cbCanal')=='' ){
		if( combo_get('frmContenido.cbPeriodo', 'L') > 0 ){
			set_combo('frmContenido.cbPeriodo', arrayVacio());
		}
		accion('frmContenido.cbPeriodo', '.disabled=true');
	}else{
		accion('frmContenido.cbPeriodo', '.disabled=false');
		set_combo('frmContenido.cbPeriodo', arrayVacio());
		recargaComboPeriodo();
	}
}

function arrayVacio(){
	var array = new Array();
	array[0] = new Array('','');
	return array;
}

function recargaComboPeriodo(){
	recargaCombo('frmContenido.cbPeriodo', 'CRAObtenerPeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', armarArrayDTOPeriodo(), 'asignaComboPeriodo(datos)');
}

function asignaComboPeriodo(datos){
	if(datos.length > 0){
		asignarArrayACombo(datos);
		//set_combo('frmContenido.cbPeriodo', datos);
		accion('frmContenido.cbPeriodo', '.disabled=false');
	}
}

function asignarArrayACombo(datos){
	if( datos != null && datos.length > 0 ){
		//combo_add('frmContenido.cbPeriodo', '', '');
		for(i = 0; i < datos.length; i++){
			combo_add('frmContenido.cbPeriodo', datos[i][0], datos[i][1]);
		}
	}
}

function onChangeRegion(){
	if( get('frmContenido.cbRegion') == '' ){
		set_combo('frmContenido.cbZona', ['','']);
		accion('frmContenido.cbZona', '.disabled=true');
	}else{
		if(auxAccion=="M"){
			accion('frmContenido.cbZona', '.disabled=true');
		}
		else{
			accion('frmContenido.cbZona', '.disabled=false');
		}
		//recargaComboZona();
		cambioRegion();		
	}
}

function recargaComboZona(){
	recargaCombo('frmContenido.cbZona', 'ZONRecargaZonas', 'es.indra.sicc.dtos.zon.DTOUnidadAdministrativa', 
		armarArrayDTOUnidadAdministrativa(), 'asignaComboZona(datos)');
}

function asignaComboZona(datos){
	var sel = new Array();
	sel[0] = get( 'frmContenido.hZona' );
	set_combo('frmContenido.cbZona', armarArrayParaZona(datos), sel);
}

function asignaComboSubtipoClien(datos){
	var sel = new Array();
	sel[0] = get( 'frmContenido.hSubtipoCliente' );
	set_combo('frmContenido.cbSubtipoCliente', armarArray(datos), sel);

	if(auxAccion=="M"){
		accion('frmContenido.cbSubtipoCliente', '.disabled=true');
	}
	else{
		accion('frmContenido.cbSubtipoCliente', '.disabled=false');
	}
}

function armarArray(datos){
	var valores = new Array();
	valores[0] = ['', ''];
	for(i=0; i < datos.length; i++ ){
		valores[i+1] = datos[i];
	}
	return valores;
}

function armarArrayParaZona(datos){
	var valores = new Array();
	arZonasReg = new Array();
	var aux1 = new Array();
	var aux2 = new Array();
	valores[0] = ['', ''];
	arZonasReg[0] = ['', '', ''];
	aux1[0] = ['', ''];
	aux2[0] = ['', ''];
	for(i=0; i < datos.length; i++ ){
		var aux1 = new Array();
		var aux2 = new Array();
		aux1[0] = datos[i][0];
		aux1[1] = datos[i][1];
		/*aux2[0] = datos[i][0].substr(0,datos[i][0].indexOf('@'));//oidZona
		aux2[1] = datos[i][1];//DesZona
		aux2[2] = datos[i][0].substr(datos[i][0].indexOf('@')+1, datos[i][0].indexOf('$') - datos[i][0].indexOf('@'));//oidReg
		*/
		//
		//valores[i+1] = datos[i];
		valores[i+1] = aux1;
		arZonasReg[i+1] = aux2;
	}
	return valores;
}

function onChangeTipoCliente(){
	set_combo('frmContenido.cbTipoClasificacion', ['','']);
	set_combo('frmContenido.cbClasificacion', ['','']);
	accion('frmContenido.cbTipoClasificacion', '.disabled=true');
	accion('frmContenido.cbClasificacion', '.disabled=true');
	if( get('frmContenido.cbTipoCliente') == '' ){
		set_combo('frmContenido.cbSubtipoCliente', ['','']);
		accion('frmContenido.cbSubtipoCliente', '.disabled=true');
	}else{
		accion('frmContenido.cbSubtipoCliente', '.disabled=false');
		/*asignar([['COMBO','frmContenido.cbSubtipoCliente',
                          'ConectorDruidaTransactionQuery',
                          'dtoSalida.resultado_ROWSET',
                          formarCadenaDT('MAEobtenerSubtipos', 
                          'es.indra.sicc.util.DTOOID', 
                            armarArrayDTOOID('cbTipoCliente') ), 
						  'asignarArrayAComboGen(datos,"cbSubtipoCliente",12);']]);	*/
		recargaCombo('frmContenido.cbSubtipoCliente', 'MAEobtenerSubtipos', 
			'es.indra.sicc.util.DTOOID', armarArrayDTOOID('cbTipoCliente'), 'asignaComboSubtipoClien(datos)');
	}
}

function onChangeTipoClienteRecargaLista(){
	set_combo('frmContenido.cbTipoClasificacion', ['','']);
	set_combo('frmContenido.cbClasificacion', ['','']);
	accion('frmContenido.cbTipoClasificacion', '.disabled=true');
	accion('frmContenido.cbClasificacion', '.disabled=true');
	if( get('frmContenido.cbTipoCliente') == '' ){
		set_combo('frmContenido.cbSubtipoCliente', ['','']);
		accion('frmContenido.cbSubtipoCliente', '.disabled=true');
	}else{
		//accion('frmContenido.cbSubtipoCliente', '.disabled=false');
		if(auxAccion=="M"){
			accion('frmContenido.cbSubtipoCliente', '.disabled=true');
		}
		else{
			accion('frmContenido.cbSubtipoCliente', '.disabled=false');
		}
		asignar([['COMBO','frmContenido.cbSubtipoCliente',
                          'ConectorDruidaTransactionQuery',
                          'dtoSalida.resultado_ROWSET',
                          formarCadenaDT('MAEobtenerSubtipos', 
                          'es.indra.sicc.util.DTOOID', 
                            armarArrayDTOOID('cbTipoCliente') ), 
						  'asignarArrayAComboGen(datos,"cbSubtipoCliente",12);']]);	
		
	}
}

function onChangeSubtipoCliente(){
	set_combo('frmContenido.cbClasificacion', ['','']);
	accion('frmContenido.cbClasificacion', '.disabled=true');
	if( get('frmContenido.cbSubtipoCliente') == '' ){
		set_combo('frmContenido.cbTipoClasificacion', ['','']);
		accion('frmContenido.cbTipoClasificacion', '.disabled=true');
	}else{
		accion('frmContenido.cbTipoClasificacion', '.disabled=false');
		recargaCombo('frmContenido.cbTipoClasificacion', 'MAEobtenerTipoClasificacion', 
			'es.indra.sicc.util.DTOOID', armarArrayDTOOID('cbSubtipoCliente'),'cargaTipoClasificacion(datos)');
		if(auxAccion=="M"){
			accion('frmContenido.cbSubtipoCliente', '.disabled=true');
		}
		else{
			accion('frmContenido.cbSubtipoCliente', '.disabled=false');
		}
	}
}

function onChangeTipoClasificacion(){
	if( get('frmContenido.cbTipoClasificacion') == '' ){
		set_combo('frmContenido.cbClasificacion', ['','']);
		accion('frmContenido.cbClasificacion', '.disabled=true');
	}else{
		accion('frmContenido.cbClasificacion', '.disabled=false');
		recargaCombo('frmContenido.cbClasificacion', 'MAEobtenerClasificacionesPorTipo', 
			'es.indra.sicc.util.DTOOID', armarArrayDTOOID('cbTipoClasificacion'));
	}
}

function fBorrar(){
	onClickEliminar();
}

function armarArrayDTOPeriodo(){
	var marca = get('frmContenido.cbMarca');
	var canal = get('frmContenido.cbCanal');
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

	var pais = get("frmContenido.hPais");
	array[index] = ["pais", pais];
	return array;
}

function armarArrayDTOUnidadAdministrativa(){
	var marca = get('frmContenido.cbMarca');
	var canal = get('frmContenido.cbCanal');
	var region = get('frmContenido.cbRegion');
	var pais = get('frmContenido.hPais');
	var array = new Array();
	var index = 0;

	if( marca != null && marca[0] != null && marca[0] != '' ){
		array[index] = new Array('oidMarca', marca[0]);
		index++;
	}

	if( canal != null && canal[0] != null && canal[0] != '' ){
		array[index] = new Array('oidCanal', canal[0]);
		index++;
	}
	
	if( region != null && region != '' ){
		array[index] = new Array('oidRegion', region);
		index++;
	}

	if( pais != null && pais != '' ){
		array[index] = new Array('oidPais', pais);
	}	
	
	return array;
}

function armarArrayDTOOID(combo){
	var idioma = get('frmContenido.hIdioma');
	var oid = get('frmContenido.' + combo); //cbTipoCliente
	var array = new Array();

	index = 0;

	if( idioma != null && idioma != '' ){
		array[index] = new Array('oidIdioma', idioma);
		index++;
	}

	if( oid != null && oid[0] != null && oid[0] != '' ){
		array[index] = new Array('oid', oid[0]);
	}
	return array;
}

function anyadeCodigosVenta( oids, textos ){
	var nuevaCadena1 = "";

	for(var i = 0; i<oids.length; i++) {
	   var caracter = oids.charAt(i) ;

	   if ((caracter != "]") && (caracter != "[")) {
		 nuevaCadena1 = nuevaCadena1 + caracter;
	   }
	
	}

	var nuevaCadena2 = "";

	for(var i = 0; i<textos.length; i++) {
	   var caracter = textos.charAt(i) ;

	   if ((caracter != "]") && (caracter != "[")) {
		 nuevaCadena2 = nuevaCadena2 + caracter;
	   }
		
	}

	var arrayOids = nuevaCadena1.split(",");
	var arrayCodigos = nuevaCadena2.split(",");

		for(i = 0; i < arrayOids.length; i++){
			if( !existeCodigoVentaEnCombo(arrayOids[i]) ){
				combo_add('frmContenido.cbCodVenta2', arrayOids[i], arrayCodigos[i]);
			}
		}
		set('frmContenido.txtCodigoVenta', '');
		focaliza('frmContenido.txtCodigoVenta');
}

function existeCodigoVentaEnCombo(oid){
	var len = combo_get('frmContenido.cbCodVenta2', 'L');

	if(oid != null && len < 0){
		for(j = 0; j < len; j++){
			if( oid == combo_get('frmContenido.cbCodVenta2', 'V', j) ){
				return true;
			}
		}
	}else{
		return false;
	}
	return false;
}

function fEjecutarError(){
	focaliza('frmContenido.txtCodigoVenta');
}

function posicionarCombosBusqueda(){
	var sel = new Array();

	sel[0] = get( 'frmContenido.hMarca' );
	set( 'frmContenido.cbMarca', sel );

	sel[0] = get( 'frmContenido.hCanal' );
	set( 'frmContenido.cbCanal', sel );

	recargaCombo('frmContenido.cbPeriodo', 'CRAObtenerPeriodos', 'es.indra.sicc.dtos.cra.DTOPeriodo', 
			armarArrayDTOPeriodo(), 'cargaPeriodos(datos)');
}

function cargaPeriodos(datos){
	var array = new Array( get( 'frmContenido.hPeriodo' ) );
	set_combo('frmContenido.cbPeriodo', datos, array);
}

function posicionarCombosModificar(){

	//Asignar checkboxes
	if( get('frmContenido.hControlLiquidacion') == 'S' ){
		set('frmContenido.chkControlLiquidacion', 'S');
	}

	if( get('frmContenido.hUltimasNoticias') == 'S' ){
		set('frmContenido.chkUltimasNoticias', 'S');
	}

	var sel = new Array();

	sel[0] = get( 'frmContenido.hRegion' );
	set( 'frmContenido.cbRegion', sel );

	recargaComboZona();

	sel[0] = get( 'frmContenido.hTipoCliente' );
	set( 'frmContenido.cbTipoCliente', sel );

	recargaCombo('frmContenido.cbSubtipoCliente', 'MAEobtenerSubtipos', 
			'es.indra.sicc.util.DTOOID', armarArrayDTOOID('cbTipoCliente'), 'cargaSubtipoCliente(datos)');
}

function cargaSubtipoCliente(datos){
	var array = new Array( get( 'frmContenido.hSubtipoCliente' ) );
	set_combo('frmContenido.cbSubtipoCliente', armarArray(datos), array);

	recargaCombo('frmContenido.cbTipoClasificacion', 'MAEobtenerTipoClasificacion', 
			'es.indra.sicc.util.DTOOID', armarArrayDTOOID('cbSubtipoCliente'), 'cargaTipoClasificacion(datos)');
	if(auxAccion=="M"){
		accion('frmContenido.cbSubtipoCliente', '.disabled=true');
	}
	else{
		accion('frmContenido.cbSubtipoCliente', '.disabled=false');
	}
}

function cargaTipoClasificacion(datos){
	var array = new Array( get( 'frmContenido.hTipoClasificacion' ) );
	set_combo('frmContenido.cbTipoClasificacion', armarArray(datos), array);
	accion('frmContenido.cbClasificacion', '.disabled=false');
	recargaCombo('frmContenido.cbClasificacion', 'MAEobtenerClasificacionesPorTipo', 
			'es.indra.sicc.util.DTOOID', armarArrayDTOOID('cbTipoClasificacion'), 'cargaClasificacion(datos)');
	if(auxAccion=="M"){
		accion('frmContenido.cbTipoClasificacion', '.disabled=true');
	}
	else{
		accion('frmContenido.cbTipoClasificacion', '.disabled=false');
	}
}

function cargaClasificacion(datos){
	var array = new Array( get( 'frmContenido.hClasificacion' ) );
	set_combo('frmContenido.cbClasificacion', armarArray(datos), array);
	if(auxAccion=="M"){
		accion('frmContenido.cbClasificacion', '.disabled=true');
	}
	else{
		accion('frmContenido.cbClasificacion', '.disabled=false');
	}
}

function deshabilitarControlesCodigoVenta(){
	deshabilitarHabilitarBoton('botonContenido','btnAnyadirCodigo','D');
	deshabilitarHabilitarBoton('botonContenido','btnBuscarCodVenta','D');
	deshabilitarHabilitarBoton('botonContenido','btnEliminarCodigo','D');

	accion('frmContenido.txtCodigoVenta', '.disabled=true');
}

function habilitarControlesCodigoVenta(){
	deshabilitarHabilitarBoton('botonContenido','btnAnyadirCodigo','A');
	deshabilitarHabilitarBoton('botonContenido','btnBuscarCodVenta','A');
	deshabilitarHabilitarBoton('botonContenido','btnEliminarCodigo','A');

	accion('frmContenido.txtCodigoVenta', '.disabled=false');
	accion('frmContenido.cbRegion', '.disabled=false');
	accion('frmContenido.cbZona', '.disabled=false');
	accion('frmContenido.cbCodVenta2', '.disabled=false');
	accion('frmContenido.cbTipoCliente', '.disabled=false');
	//HABILITANDO LOS RADIOs
	var lstRadio=eval(eval("frmContenido.rbTipoUbicIE"));
	for(x=0; x<(lstRadio.length); x++){
		lstRadio[x].disabled = false;
	}
	//SELECCIONANDO EL PRIMER RADIO
	lstRadio[0].selected = true;
	habilitarListaRegionZona();
}

function setTabFocus( campo ){
	if( campo == 'cbMarca' ){
		focaliza('frmContenido.cbCanal');
	}
  else if( campo == 'cbCanal' ){
		focaliza('frmContenido.cbPeriodo');
	}
  else if( campo == 'cbPeriodo' ){
		focalizaBotonHTML('botonContenido','txtCodigoVentaBuscar');
	}
  else if( campo == 'btnBuscar' ){
		if( get_visibilidad('capaContenido2') != false ){
			if(  txtCodigoVenta.disabled == false  ){
				focaliza('frmContenido.txtCodigoVenta');
			}
      else{
				setTabFocus('txtCodigoVenta');
			}
		}
    else{
			focaliza('frmContenido.cbMarca');
		}
	}
  else if( campo == 'txtCodigoVenta' ){
		if( document.all["btnAnyadirCodigo"].disabled == false ){
			focalizaBotonHTML('botonContenido','btnAnyadirCodigo');
		}
    else{
			setTabFocus('btnAnyadirCodigo');
		}
	}
  else if( campo == 'btnAnyadirCodigo' ){
		if( document.all["btnBuscarCodVenta"].disabled == false ){
			focalizaBotonHTML('botonContenido','btnBuscarCodVenta');
		}
    else{
			setTabFocus('btnBuscarCodVenta');
		}
	}
  else if( campo == 'btnBuscarCodVenta' ){
		if(  cbCodVenta2.disabled == false  ){
			focaliza('frmContenido.cbCodVenta2');
		}
    else{
			setTabFocus('cbCodVenta2');
		}
	}
  else if( campo == 'cbCodVenta2' ){
		if( document.all["btnEliminarCodigo"].disabled == false ){
			focalizaBotonHTML('botonContenido','btnEliminarCodigo');
		}
    else{
			setTabFocus('btnEliminarCodigo');
		}
	}
  else if( campo == 'btnEliminarCodigo' ){
		focaliza('frmContenido.cbRegion');
	}

  else if( campo == 'cbRegion' ){
    try {
      focaliza('frmContenido.cbZona');
    }
    catch(e) {
      setTabFocus('cbZona');
    }  
		
	}
  else if( campo == 'cbZona' ){
		focaliza('frmContenido.cbTipoCliente');
	}
  else if( campo == 'cbTipoCliente' ){
    try {
      focaliza('frmContenido.cbSubtipoCliente');
    }
    catch(e) {
      setTabFocus('cbSubtipoCliente');
    }  
		
	}
  else if( campo == 'cbSubtipoCliente' ){
    try {
      focaliza('frmContenido.cbTipoClasificacion');
    }
    catch(e){
      setTabFocus('cbTipoClasificacion');
    }		
	}
  else if( campo == 'cbTipoClasificacion' ){
    try {
      focaliza('frmContenido.cbClasificacion');
    }
    catch(e) {
      setTabFocus('cbClasificacion');
    }
		
	}
  else if( campo == 'cbClasificacion' ){
		focaliza('frmContenido.txtLimiteVenta');
	}
  else if( campo == 'txtLimiteVenta' ){
		focaliza('frmContenido.txtControlStock');
	}
  else if( campo == 'txtControlStock' ){
		focaliza('frmContenido.txtControlStockPorcentual');
	}
  else if( campo == 'txtControlStockPorcentual' ){
		focaliza('frmContenido.chkControlLiquidacion');
	}
  else if( campo == 'chkControlLiquidacion' ){
		focaliza('frmContenido.chkUltimasNoticias');
	}
  else if( campo == 'chkUltimasNoticias' ){
		focalizaBotonHTML('botonContenido','btnAnadir');
	}
  else if( campo == 'btnAnadir' ){
		if( document.all["ModificarDiv"].style.visibility != 'hidden' ){
			focalizaBotonHTML_XY('Modificar');
		}else{
			setTabFocus('Modificar');
		}
	}
  else if( campo == 'Modificar' ){
		if( document.all["EliminarDiv"].style.visibility != 'hidden' ){
			focalizaBotonHTML_XY('Eliminar');
		}else{
			setTabFocus('Eliminar');
		}
	}
  else if( campo == 'Eliminar' ){
		focaliza('frmContenido.cbMarca');
	}
  else if( campo == 'txtCodigoVentaBuscar' ){
		focaliza('frmContenido.btnBuscar');
  }
}

function setSHTabFocus( campo ){
	if( campo == 'Eliminar' ){
		if( document.all["ModificarDiv"].style.visibility != 'hidden' ){
			focalizaBotonHTML_XY('Modificar');
		}else{
			setSHTabFocus('Modificar');
		}
	}

  else if( campo == 'Modificar' ){
		if( get_visibilidad('capaContenido2') != false ){
			focalizaBotonHTML('botonContenido','btnAnadir');
		}else{
			focalizaBotonHTML('botonContenido','btnBuscar');
		}
	}

  else if( campo == 'btnAnadir' ){
		focaliza('frmContenido.chkUltimasNoticias');
	}

  else if( campo == 'chkUltimasNoticias' ){
		focaliza('frmContenido.chkControlLiquidacion');
	}

  else if( campo == 'chkControlLiquidacion' ){
		focaliza('frmContenido.txtControlStockPorcentual');
	}

  else if( campo == 'txtControlStockPorcentual' ){
		focaliza('frmContenido.txtControlStock');
	}

  else if( campo == 'txtControlStock' ){
		focaliza('frmContenido.txtLimiteVenta');
	}

  else if( campo == 'txtLimiteVenta' ){
    try {
      focaliza('frmContenido.cbClasificacion');
    }
    catch(e) {
      setSHTabFocus('cbClasificacion');
    }
  
		
	}

  else if( campo == 'cbClasificacion' ){
    try {
      focaliza('frmContenido.cbTipoClasificacion');
    }
    catch(e) {
      setSHTabFocus('cbTipoClasificacion');
    }	
	}

  else if( campo == 'cbTipoClasificacion' ){
    try {
      focaliza('frmContenido.cbSubtipoCliente');
    }
    catch(e) {
      setSHTabFocus('cbSubtipoCliente');
    }		
	}

  else if( campo == 'cbSubtipoCliente' ){
    try {
      focaliza('frmContenido.cbTipoCliente');
    }
    catch(e) {
      setSHTabFocus('cbTipoCliente');
    }		
	}

  else if( campo == 'cbTipoCliente' ){
    try {
      focaliza('frmContenido.cbZona');
    }
    catch(e) {
      setSHTabFocus('cbZona');
    }  
		
	}

  else if( campo == 'cbZona' ){
    try {
      focaliza('frmContenido.cbRegion');
    }
    catch(e) {
      setSHTabFocus('cbRegion');
    }	
	}

  else if( campo == 'cbRegion' ){
    try {
      focalizaBotonHTML('botonContenido','btnEliminarCodigo');
    }
    catch(e) {
      setSHTabFocus('btnEliminarCodigo');
    }
	}

  else if( campo == 'btnEliminarCodigo' ){
    try {
      focaliza('frmContenido.cbCodVenta2');
    }
    catch(e) {
      setSHTabFocus('cbCodVenta2');
    }
	}

  else if( campo == 'cbCodVenta2' ){
    try {
      focalizaBotonHTML('botonContenido','btnBuscarCodVenta');
    }
    catch(e) {
      setSHTabFocus('btnBuscarCodVenta');
    }
	}

  else if( campo == 'btnBuscarCodVenta' ){
    try {
      focalizaBotonHTML('botonContenido','btnAnyadirCodigo');
    }
    catch(e) {
      setSHTabFocus('btnAnyadirCodigo');
    }
	}

  else if( campo == 'btnAnyadirCodigo' ){
    try {
      focaliza('frmContenido.txtCodigoVenta');
    }
    catch(e) {
      setSHTabFocus('txtCodigoVenta');
    }
	}

  else if( campo == 'txtCodigoVenta' ){
    try {
      focalizaBotonHTML('botonContenido','btnBuscar');
    }
    catch(e) {
      setSHTabFocus('btnBuscar');
    }
	}

  else if( campo == 'btnBuscar' ){
		focaliza('frmContenido.cbPeriodo');
	}

  else if( campo == 'cbPeriodo' ){
		focaliza('frmContenido.cbCanal');
	}

  else if( campo == 'cbCanal' ){
		focaliza('frmContenido.cbMarca');
	}

  else if( campo == 'cbMarca' ){
		if( document.all["EliminarDiv"].style.visibility != 'hidden' ){
			focalizaBotonHTML_XY('Eliminar');
		}else{
			focalizaBotonHTML('botonContenido','btnBuscar');
		}
	}
  else if( campo == 'txtCodigoVentaBuscar' ){
		focaliza('frmContenido.cbPeriodo');
  }
}

function muestraLista( ultima, rowset){
    var tamano = rowset.length;
    if (tamano > 0) {
	  mostrarLista();

	  //Si se obtuvo algún resultado 
	  var s = GestionarMensaje(84);
	  var n = GestionarMensaje(86);
	  var f;
	  for ( f=0; f<rowset.length; f++) {
		if ( rowset[f][22] == "1" ) rowset[f][22] = s;
		else rowset[f][22] = n;
	  }
	  for ( f=0; f<rowset.length; f++) {
		if ( rowset[f][23] == "1" ) rowset[f][23] = s;
		else rowset[f][23] = n;
	  }
	  setTimeout('eval (ON_RSZ)',200);
	  focaliza("frmContenido.cbMarca");
	  return true;
    } else {
	  ocultarLista();
	  focaliza("frmContenido.cbMarca");
	  return false;
    }
	
}

 function armaArray(){ 
      var arrDatos = new Array();
      var i=0;

      if (get('frmContenido.hIdioma')!=''){
           arrDatos[i] = new Array('oidIdioma',get('frmContenido.hIdioma'));
           i++;
	  }
	  if (get('frmContenido.hMarca')!=''){
           arrDatos[i] = new Array('marca',get('frmContenido.hMarca'));
           i++;
	  }
	  if (get('frmContenido.hCanal')!=''){
           arrDatos[i] = new Array('canal',get('frmContenido.hCanal'));
           i++;
	  }
	  //incidencia  DBLG500000999, filtrado de campos incorrecto
	  if (get('frmContenido.cbPeriodo')!=''){
           arrDatos[i] = new Array('periodo',get('frmContenido.cbPeriodo')[0]);
           i++;
	  }
	  if (get('frmContenido.txtCodigoVentaBuscar')!=''){
           arrDatos[i] = new Array('codigoVentaBuscar',get('frmContenido.txtCodigoVentaBuscar'));
           i++;
	  }
	  arrDatos[i] = new Array('numID','-1');
       i++;

      return arrDatos;
                    
  }

   function quitarItemVacio(elemento){
      var elementoADevolver = new Array();
     
      for(var k=0;k<elemento.length;k++) {
          if (elemento[k] != ''){                            
             elementoADevolver[elementoADevolver.length] = elemento[k];
          }
      }
         
      return elementoADevolver;
      
   }

   function obtenerRegion(codigoRegion){
		var longitud = combo_get('frmContenido.cbRegion', 'L');
		var x=0;
		for ( x = 0; x < longitud ; x++ ){
			if (combo_get('frmContenido.cbRegion', 'V', x)==codigoRegion){
				return combo_get('frmContenido.cbRegion', 'T', x);
			}
		}
		return "";
   }

   function obtenerZona(codigoZona){
		var longitud = combo_get('frmContenido.cbZona', 'L');
		var x=0;
		for ( x = 0; x < longitud ; x++ ){
			if (combo_get('frmContenido.cbZona', 'V', x)==codigoZona){
				return combo_get('frmContenido.cbZona', 'T', x);;
			}
		}
		return "";
   }

function cambioRegion(){
    
    opciones = new Array();
    
	set_combo('frmContenido.cbZona',opciones);
       
    combo_add('frmContenido.cbZona', '', '');
    var regiones = quitarItemVacio(get('frmContenido.cbRegion'));
    var pais = get('frmContenido.hPais');
    var regionConc = new String();
    
    for(i=0;i<regiones.length;i++){
       regionConc += regiones[i] + "x";
    }
        
    regionConc = regionConc.substring(0, regionConc.length-1);

    
    var arr = new Array();
    arr[arr.length] = ['cadena', regionConc];
    arr[arr.length] = ['oidPais', pais]
    
    if(regionConc != ''){
       recargaCombo("frmContenido.cbZona", "ZONRecargaZonasReg", "es.indra.sicc.util.DTOString",arr,'asignaComboZona(datos)');
    }     
    
  }

function inicializaOid(){
	var oid = new Array();
	oid[0]=""
	return oid;
}

function ObtenerOidRegion(oid){
	var i=0;
	for(i=0; i < arZonasReg.length; i++ ){
		if(arZonasReg[i][0]==oid){
			return arZonasReg[i][2];
		}
	}
	return "";
}

function IniciarListRegionwFlag(arRegion){
	var i=0;
	var auxArRegion = new Array();
	auxArRegion[0] = ['',''];
	for(i=0; i < arRegion.length; i++ ){
		var aux = new Array();
		aux[0] = arRegion[i];
		aux[1] = '';
		auxArRegion[i] = aux;
	}
	return auxArRegion;
}

function IndicarRegionTieneZona(auxArRegion,oidregion){
	var i=0;
	for(i=0; i < auxArRegion.length; i++ ){
		if(auxArRegion[i][0]==oidregion){
			//CON ESTE FLAG INDICA QUE LA REGION TIENE ZONA
			auxArRegion[i][1] = '1' ;
			return auxArRegion;
		}
	}
	return auxArRegion;
}

function habilitarListaRegionZona(){
   var i ;
   if (get("frmContenido.rbTipoUbic")=="R") { 
		//HA ESCOGIDO REGION, DEBE DESHABILITAR cbZona
		accion('frmContenido.cbZona', '.disabled=true');
		accion('frmContenido.cbRegion', '.disabled=false');
		var lstZona=eval(eval("frmContenido.cbZonaIE"));
		for(x=0; x<(lstZona.length); x++){
			lstZona.options[x].selected = false;
		}
   }
   else{
	 accion('frmContenido.cbRegion', '.disabled=true');
	 accion('frmContenido.cbZona', '.disabled=false');
	 var lstRegion=eval(eval("frmContenido.cbRegionIE"));
	 for(x=0; x<(lstRegion.length); x++){
		lstRegion.options[x].selected = false;
	 }
   }
   return true;
}

function cargaZona(){
    opciones = new Array();
	set_combo('frmContenido.cbZona',opciones);
    combo_add('frmContenido.cbZona', '', '');
    var pais = get('frmContenido.hPais');
    var arr = new Array();
    arr[arr.length] = ['oidPais', pais]
    recargaCombo("frmContenido.cbZona", "ZONRecargaZonasReg", "es.indra.sicc.util.DTOString",arr,'asignaComboZona(datos)');
  }