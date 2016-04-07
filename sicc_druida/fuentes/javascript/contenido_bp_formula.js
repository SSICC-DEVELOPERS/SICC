// ----------------------------------------------------------------------------------------------
function init()
{
	configurarMenuSecundario("frmFormula");
	fMostrarMensajeError();
	setearPantalla();

	focaliza("frmFormula.txtNumUnidadesTotalesRepartir", "");
    
    // [1] Agregado por Rafael Romero / SiCC 20070189 - 24/04/2007
    var estadoProceso = get('frmFormula.varEstadoProceso');
    if(estadoProceso == "4"){
        accion("frmFormula.txtNumUnidadesTotalesRepartir" , ".disabled=true");
        accion("frmFormula.cbFormulaReparto" , ".disabled=true");
        accion("frmFormula.cbCampanaEvaluaFuenteVentas" , ".disabled=true");
        if(document.getElementById("btnAceptar").value == GestionarMensaje("1291")){
            document.all["btnAceptar"].disabled=true;
        }
		
		// sapaza -- PER-SiCC-2010-0628 -- 20/10/2010
		var subcriterio = get("frmFormula.hidFormula");
		switch ( parseInt(subcriterio, 10) )
        {
            case 29: // Tipificacion de Cliente
		        accion("frmFormula.cbTipoCliente" , ".disabled=true");
		        accion("frmFormula.cbSubTipoCliente" , ".disabled=true");
				accion("frmFormula.cbTipoClasificacion" , ".disabled=true");
				accion("frmFormula.cbClasificacion" , ".disabled=true");
		        document.all["btnContinuar4"].disabled=true;
		        break;	      
 		}
    }
    // fin agregar [1]
    
}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------
function aceptar()
{
	var formula = get("frmFormula.cbFormulaReparto");
	if ( formula == "")
	{
		GestionarMensaje("1294", GestionarMensaje("1293") );
		focaliza("frmFormula.cbFormulaReparto");
		return;
	} else
	{

			var campanya = "";
			var numUnidades = "";
			var periodo = "";
			var asistenciaCurso = "";
			var valido = true;
			var array = new Array();

			switch ( parseInt(formula, 10) )
			{
						// 15 y 16 ********* NO DEBEN HACER NADA ACA *********
						case 15:  // Asistencia a curso
						case 16:  // Asistencia a conferencia Ventas
							break;

						case 17: // Activas finales
						case 18: // Ingresos
						case 19: // Reingresos
						case 20: // Egresos
						case 21: // Número de pedidos
						case 22: // Número de zonas

							if ( !sicc_validaciones_generales("g1") )
								return;

							if ( !sicc_validaciones_generales("cbCampanaEvaluaFuenteVentas") )
								return;

							//alert("formula: " + formula);
							numUnidades = get("frmFormula.txtNumUnidadesTotalesRepartir");
							valido = validaNumUnidades(numUnidades);
							if (valido)  // Num. de Unidades es Valido.
							{
									campanya = get("frmFormula.cbCampanaEvaluaFuenteVentas");
									if ( campanya == "")  // Segun Inc. 6177, al ser opcional, se asume 0 si no se eligió.
										campanya = "0";

									array[0] = numUnidades;
									array[1] = formula;
									array[2] = campanya;
									//alert("array a Devolver: " + array);

									returnValue =array;
									window.close();
							 }
							
							break;

						case 29: // Tipificacion de clientes
							break;

 			  }  // Fin switch

	} // Fin if

	return;

}

// ----------------------------------------------------------------------------------------------------------------------------------------------------------
function cambiaFuente()
{

	var aceptar = GestionarMensaje("1291");
	var continuar = GestionarMensaje("1292");

	var formula = get("frmFormula.cbFormulaReparto");
	
	if ( formula == "")
	{
		document.getElementById("capa2").style.visibility = "hidden";
		document.getElementById("capa3").style.visibility = "hidden";
		document.getElementById("capa4").style.visibility = "hidden";
		document.getElementById("btnAceptar").value = aceptar;
		accion("frmFormula.cbCampanaEvaluaFuenteVentas", ".disabled=false");
	} else
	{
			switch ( parseInt(formula, 10) )
			{
				case 15:  // Asistencia a curso
					document.getElementById("capa2").style.visibility = "visible";
					document.getElementById("capa3").style.visibility = "hidden";
					document.getElementById("capa4").style.visibility = "hidden";
					document.getElementById("btnAceptar").value = aceptar;
					accion("frmFormula.cbCampanaEvaluaFuenteVentas", ".disabled=true"); // Deshabilitados x inc. 6177
					break;

				case 16:  // Asistencia a conferencia Ventas
					document.getElementById("capa2").style.visibility = "hidden";
					document.getElementById("capa3").style.visibility = "visible";
					document.getElementById("capa4").style.visibility = "hidden";
					document.getElementById("btnAceptar").value = aceptar;
					accion("frmFormula.cbCampanaEvaluaFuenteVentas", ".disabled=true"); // Deshabilitados x inc. 6177
					break;

				case 17: // Activas finales
				case 18: // Ingresos
				case 19: // Reingresos
				case 20: // Egresos
				case 21: // Número de pedidos
				case 22: // Número de zonas
					document.getElementById("capa2").style.visibility = "hidden";
					document.getElementById("capa3").style.visibility = "hidden";
					document.getElementById("capa4").style.visibility = "hidden";
					document.getElementById("btnAceptar").value = continuar;
					accion("frmFormula.cbCampanaEvaluaFuenteVentas", ".disabled=false");
					break;
					
				case 29:  // Tipificacion de Clientes
					document.getElementById("capa2").style.visibility = "hidden";
					document.getElementById("capa3").style.visibility = "hidden";
					document.getElementById("capa4").style.visibility = "visible";
					document.getElementById("btnAceptar").value = aceptar;
					accion("frmFormula.cbCampanaEvaluaFuenteVentas", ".disabled=true"); 
					break;
					
			}

	}

}


// ----------------------------------------------------------------------------------------------------------------------------------------------------------
function retornaModal()
{
		// Se ejecuta al cliquear en algun "Continuar" (así que solo puede ser llamado cuando el combo 
		// Formula tiene el elemento 15 o 16 - los 2 primeros).
		var formula = get("frmFormula.cbFormulaReparto");
		var campanya = "";
		var numUnidades = "";
		var periodo = "";
		var asistenciaCurso = "";
		var valido = true;
		var array = new Array();

		numUnidades = get("frmFormula.txtNumUnidadesTotalesRepartir");
		valido = validaNumUnidades(numUnidades);
		if (valido)  // Num. de Unidades es Valido.
	 	{
				campanya = get("frmFormula.cbCampanaEvaluaFuenteVentas");
				if ( campanya == "")  // Segun Inc. 6177, al ser opcional, se asume 0 si no se eligió.
					campanya = "0";

				switch ( parseInt(formula, 10) )
				{
					case 15:  // Asistencia a curso
							if ( !sicc_validaciones_generales("g1") )
								return;

							if ( !sicc_validaciones_generales("asistenciaCurso") )
								return;

							asistenciaCurso = get("frmFormula.cbAsistenciaCurso");
							periodo = get("frmFormula.cbPeriodo2");
							
							array[0] = numUnidades;
							array[1] = formula;
							array[2] = asistenciaCurso;
							array[3] = periodo;
							//array[4] = campanya;    - Al parece no va por inc. 6177, para estos dos casos.

							//alert("array a Devolver: " + array);

							returnValue =array;
							window.close();

							break;

					case 16:  // Asistencia a conferencia Ventas

							if ( !sicc_validaciones_generales("g1") )
								return;

							if ( !sicc_validaciones_generales("asistenciaConferenciaVentas") )
								return;


							periodo = get("frmFormula.cbPeriodo3");
							array[0] = numUnidades;
							array[1] = formula;
							array[2] = periodo;
							//array[3] = campanya;   - Al parece no va por inc. 6177, para estos dos casos.

							returnValue =array;
							//alert("array a Devolver: " + array);
							window.close();
							break;
							
					case 29: // Tipificacion de clientes

						if ( !sicc_validaciones_generales("g1") )
							return;

						if ( !sicc_validaciones_generales("cbCampanaEvaluaFuenteVentas") )
							return;

						numUnidades = get("frmFormula.txtNumUnidadesTotalesRepartir");
						valido = validaNumUnidades(numUnidades);
						if (valido)  // Num. de Unidades es Valido.
						{
								campanya = get("frmFormula.cbCampanaEvaluaFuenteVentas");
								if ( campanya == "")  
									campanya = "0";

								array[0] = numUnidades;
								array[1] = formula;
								array[2] = campanya;
								
								array[3] = get("frmFormula.cbTipoCliente");;
								array[4] = get("frmFormula.cbSubTipoCliente");;
								array[5] = get("frmFormula.cbTipoClasificacion");;
								array[6] = get("frmFormula.cbClasificacion");;

								returnValue =array;
								window.close();
						 }
						
						break;
							
				}
		 }

}



// ----------------------------------------------------------------------------------------------------------------------------------------------------------
function validaComboFormula()
{
	// Valida que se haya seleccionado algo en el Combo Formula Reparto. 
	var formula = get("frmFormula.cbFormulaReparto");
	
	if ( formula == "")
	{
		GestionarMensaje("1201", "Formula Reparto");
		focaliza("frmFormula.cbFormulaReparto");
		return false;
	}
	return true;
}


// ----------------------------------------------------------------------------------------------------------------------------------------------------------
function validaNumUnidades(numUnidades)
{
	// Valida que Numero de Unidades no este vacío, sea numérico  y sea mayor que cero.
	var valido = true;
	if ( numUnidades == "" )
	{
		GestionarMensaje("1294", GestionarMensaje("1295") );
		//alert("El campo Numero de Unidades es obligatorio");
		focaliza("frmFormula.txtNumUnidadesTotalesRepartir", "");
		valido = false;
	}

	var validoNumerico = validarCaracteres(numUnidades);

	if ( valido && !validoNumerico)
	{
		GestionarMensaje("1297", GestionarMensaje("1295") );
		//alert("El campo Numero de Unidades solo puede contener valores numéricos");
		focaliza("frmFormula.txtNumUnidadesTotalesRepartir", "");
		valido = false;
	}

	if ( valido && (parseInt(numUnidades, 10) == 0) )
	{
		GestionarMensaje("1296", GestionarMensaje("1295") );
		//alert("El valor del campo Numero de Unidades debe ser mayor que cero");
		focaliza("frmFormula.txtNumUnidadesTotalesRepartir", "");
		valido = false;

	}

	return valido;


}


// ----------------------------------------------------------------------------------------------------------------------------------------------------------
function validarCaracteres(valor) 
{
	var c;
	var permitidos = "0123456789";
	for(var i=0; i<valor.length; i++) 
	{
			c = valor.charAt(i);
			if (permitidos.indexOf(c) == -1 ) 
				return false;
	}
	return true;
}

// -------------------------------------------------------------------------------------------------------
function fVolver()
{
		window.close();
}

// -------------------------------------------------------------------------------------------------------
function fLimpiar()
{
	setearPantalla();
	focaliza("frmFormula.txtNumUnidadesTotalesRepartir", "");
}

// -------------------------------------------------------------------------------------------------------
function setearPantalla()
{
	var campanya = get("frmFormula.campanya");
	set("frmFormula.cbCampanaEvaluaFuenteVentas", new Array(campanya) );

	var numUnidadesRepartir = get("frmFormula.hidNumUnidadesRepartir");
	set("frmFormula.txtNumUnidadesTotalesRepartir", numUnidadesRepartir);

	var formulaReparto = get("frmFormula.hidFormula");
	set("frmFormula.cbFormulaReparto", new Array(formulaReparto) );

	var asistenciaCurso = get("frmFormula.hidAsistenciaCurso");
	set("frmFormula.cbAsistenciaCurso", new Array(asistenciaCurso) );

	var periodo = get("frmFormula.hidPeriodo");
	set("frmFormula.cbPeriodo2", new Array(periodo) );
	set("frmFormula.cbPeriodo3", new Array(periodo) );

	// Llama a la function cambiaFuente() para simular el onchange en el combo Formula (valor seteado arriba)
	cambiaFuente();
	
	//PER-SiCC-2010-0674 - Sergio Apaza - 29/11/2010
	seteaTipificacionClientes();

}

// ------------------------------------------------------------------------------------------------------------
function tabAceptarContinuar()
{

	// Se llama desde el primer boton de la pantalla (el que cambia aceptar/continuar de acuerdo al combo).
	var formula = get("frmFormula.cbFormulaReparto");
	if ( formula == ""){
			focaliza("frmFormula.txtNumUnidadesTotalesRepartir", "");
	} else
	{
		switch ( parseInt(formula,10) )
		{
		case 15:
			focaliza("frmFormula.cbAsistenciaCurso", "");		
			break;
		case 16:
			focaliza("frmFormula.cbPeriodo3", "");
			break;
		default:
			focaliza("frmFormula.txtNumUnidadesTotalesRepartir", "");		
			break;
		}
	}


}

// ------------------------------------------------------------------------------------------------------------
function onshTab()
{
	// Maneja el foco en el onshTab
	var formula = get("frmFormula.cbFormulaReparto");
	document.selection.empty();
	if ( formula != 15 && formula != 16 ) {
		focalizaBotonHTML('botonContenido', 'btnAceptar');
	} else
	{
		switch ( parseInt(formula, 10) )
		{
		case 15:
			focalizaBotonHTML('botonContenido', 'btnContinuar2');
			break;
		case 16:
			focalizaBotonHTML('botonContenido', 'btnContinuar3');
			break;
		}
	}

}

function seteaTipificacionClientes(){
	var idioma = get("frmFormula.hidIdioma");
	var oidd = get("frmFormula.hidTipoCliente");
	
	if(oidd == '') return;
	 
	var arr = new Array();   	 
	arr[arr.length] = new Array("oid", oidd +"");
	arr[arr.length] = new Array("oidIdioma", idioma +"");
	
	var a = new Array(get("frmFormula.hidTipoCliente"));

	set("frmFormula.cbTipoCliente", a);	
	recargaCombo('frmFormula.cbSubTipoCliente', 'MAEobtenerSubtipos', 'es.indra.sicc.util.DTOOID', arr, 'cargaSubTipoCliente(datos);' );	
}


function cargaSubTipoCliente(datos){
	set_combo("frmFormula.cbSubTipoCliente", agregarBlanco(datos));
	iSeleccionado = new Array(get("frmFormula.hidSubtipoCliente"));
	set("frmFormula.cbSubTipoCliente", iSeleccionado);

	if ((get("frmFormula.cbSubTipoCliente")) !=""){	
		recargaCombo('frmFormula.cbTipoClasificacion', 'MAEobtenerTipoClasificacion', 'es.indra.sicc.util.DTOOID', makeParameter('oid',get('frmFormula.cbSubTipoCliente')), 'cargaTipoClasificacion(datos);' );
	}
	else{
			set_combo("frmFormula.cbSubTipoCliente", arrayVacio());
			set_combo("frmFormula.cbTipoClasificacion", arrayVacio());
			set_combo("frmFormula.cbClasificacion", arrayVacio());
	}
} 

function cargaTipoClasificacion(datos){  
		set_combo("frmFormula.cbTipoClasificacion", agregarBlanco(datos));
		iSeleccionado = new Array(get("frmFormula.hidTipoClasificacionCliente"));
		set("frmFormula.cbTipoClasificacion", iSeleccionado);

		if (iSeleccionado !=""){
				recargaCombo('frmFormula.cbClasificacion', 'MAEobtenerClasificacionesPorTipo', 'es.indra.sicc.util.DTOOID', makeParameter('oid', get("frmFormula.cbTipoClasificacion")), 'cargaClasificacion(datos);' ); 
		}else{
				//alert('desabilita los combos');
				set_combo("frmFormula.cbClasificacion", arrayVacio() );
		}
}

function cargaClasificacion(datos){  
		set_combo("frmFormula.cbClasificacion", agregarBlanco(datos));
		iSeleccionado = new Array(get("frmFormula.hidClasificacionCliente")); 
		set("frmFormula.cbClasificacion", iSeleccionado);
}


function onChangeTipoCliente(){
	   var idioma = get("frmFormula.hidIdioma");
	   var arr = new Array();   
	   var oidd = get("frmFormula.cbTipoCliente");   

	   arr[arr.length] = new Array("oid", get("frmFormula.cbTipoCliente")+"");
	   arr[arr.length] = new Array("oidIdioma", idioma +"");
		
	   if (oidd != ""){
				recargaCombo("frmFormula.cbSubTipoCliente", 'MAEobtenerSubtipos', 'es.indra.sicc.util.DTOOID',arr);
				set_combo("frmFormula.cbTipoClasificacion", arrayVacio());
				set_combo("frmFormula.cbClasificacion", arrayVacio());			
		}else{

				set_combo("frmFormula.cbSubTipoCliente", arrayVacio() );
				set_combo("frmFormula.cbTipoClasificacion", arrayVacio());
			    set_combo("frmFormula.cbClasificacion", arrayVacio());
		}	
}

function onChangeSubtipoCliente(){

	   var idioma = get("frmFormula.hidIdioma");	
	   
	   var arr = new Array();
	   var sub = get("frmFormula.cbSubTipoCliente");	
	  
	   arr[arr.length] = new Array("oid", sub +"");
	   arr[arr.length] = new Array("oidIdioma", idioma +"");

	   if (sub !=""){	  
			   recargaCombo("frmFormula.cbTipoClasificacion", 'MAEobtenerTipoClasificacion', 'es.indra.sicc.util.DTOOID',arr);
			   set_combo("frmFormula.cbClasificacion", arrayVacio());	
	  }else{
				set_combo("frmFormula.cbTipoClasificacion", arrayVacio());
				set_combo("frmFormula.cbClasificacion", arrayVacio() );
	  }
}


function onChangeTipoClasificacion(){
	   var idioma = get("frmFormula.hidIdioma");	
	   var clasi =  get("frmFormula.cbTipoClasificacion");
	   
	   var arr = new Array();
	   arr[arr.length] = new Array("oidIdioma",idioma +"");
	   arr[arr.length] = new Array("oid", get("frmFormula.cbTipoClasificacion")+"");
	
	   if(clasi !=""){		
				recargaCombo('frmFormula.cbClasificacion', 'MAEobtenerClasificacionesPorTipo', 'es.indra.sicc.util.DTOOID',arr);
		}else{
				set_combo("frmFormula.cbClasificacion", arrayVacio());
		}
}

function agregarBlanco(datos){  
	    datosBlanco = new Array();

		datosBlanco[0]= new Array("","");

		for(var i=0; i< datos.length; i++){		
              datosBlanco[i+1] = new Array(datos[i][0], datos[i][1]);             
		}
		return datosBlanco;
}

function arrayVacio(){  
		var array = new Array();             
        array[0] = new Array('','');
		return array;
}

 function makeParameter(nombre, oid){
       var array = new Array();
       var i=0;
       array[i] = new Array('oidPais', get('frmFormula.hidPais') );
       i++;
       array[i] = new Array('oidIdioma', get('frmFormula.hidIdioma') );
       i++;
       array[i] = new Array(nombre,oid);              
       return array;
}		
