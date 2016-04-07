function fLimpiar() {
	onLoadPag();
}

function onTabBuscar() {
	var oculto = document.all["Cplistado1"].style.visibility;
    if(oculto=='hidden') {
		focaliza('formulario.cbNumConcurso','');
		return;
    }  

    var opcionMenu = get('formulario.opcionMenu').toLowerCase();
    if(opcionMenu=='modificar concurso'){
		focalizaBotonHTML_XY('Modificar');
    }
	else if(opcionMenu=='consultar concurso'){
		focalizaBotonHTML_XY('Detalle');
    }
}

//Metodo modificado por Cristian Valenzuela - 4/5/2006
//Cambios versionado
function onLoadPag(){	
	configurarMenuSecundario("formulario");
	fMostrarMensajeError();
	manejarLista('hidden');

	var opcionMenu = get('formulario.opcionMenu').toLowerCase();
	if(opcionMenu == 'modificar concurso'){
		document.getElementById("lblVersion").style.display='none';
		document.getElementById("txtVersion").style.display='none';
	}

	focaliza("formulario.cbNumConcurso", "");
	if (window.dialogArguments) { // Si es modal (se abrió mediante showModalDialog) DBLG500000915
            btnProxy(2,1);  // boton 'volver', habilitado
            btnProxy(3,0);  // boton 'Ir a pantalla de inicio', deshabilitado
        }


     }

// -------------------------------------------------------------------------------------------------------------------------------------------
	function fVolver(){     
					  window.close();
	}

// -------------------------------------------------------------------------------------------------------------------------------------------


function gestionarBotones(visible){
	var opcionMenu = get('formulario.opcionMenu').toLowerCase();

    if (visible == 'hidden'){
        document.all["ModificarDiv"].style.visibility = 'hidden';
        document.all["DetalleDiv"].style.visibility = 'hidden';
    } else {
        if (opcionMenu == 'consultar concurso'){
            document.all["ModificarDiv"].style.visibility = 'hidden';
            document.all["DetalleDiv"].style.visibility = '';
        } else if(opcionMenu == 'modificar concurso'){
            document.all["ModificarDiv"].style.visibility = '';
            document.all["DetalleDiv"].style.visibility = 'hidden';
        }
    }
}

function accionBuscar(){
	var arrayBusqueda = armarArray();
	manejarLista('hidden');
	configurarPaginado(mipgndo, "INCBuscarConcursos", "ConectorBuscarConcursos", 
                        "es.indra.sicc.dtos.inc.DTOBuscarConcursos", arrayBusqueda);
}

/*
Modificado por Cristian Valenzuela
4/5/2006
Cambios versionado
*/
function armarArray(){
	// Arma el Array con los criterios de Búsqueda para realizar el paginado al Buscar.
	var array = new Array();

	var oidIdioma = get("formulario.hIdioma");
	var oidPais = get("formulario.hPais");
	var nroConcurso = get("formulario.cbNumConcurso");
	var nombreConcurso = get("formulario.textNombreConcurso");
	var oidPlantilla = get("formulario.cbNumPlantilla");
	var nombrePlantilla = get("formulario.textNombrePlantilla");	
	var oidMarca = get("formulario.cbMarca");
	var oidCanal = get("formulario.cbCanal");
	var indActivo = "true";	

	// Setea los valores en el Array a retornar
	if ( nroConcurso != "")
		array[array.length] = ["nroConcurso", nroConcurso];

	if ( nombreConcurso != "")
		array[array.length] = ["nombreConcurso", nombreConcurso];

	if ( oidPlantilla != "" )
		array[array.length] = ["oidPlantilla", oidPlantilla];

	if ( nombrePlantilla != "")	
		array[array.length] = ["nombrePlantilla", nombrePlantilla];

	var opcionMenu = get("formulario.opcionMenu");
	if (opcionMenu == 'Consultar Concurso'){
		var version = get("formulario.txtVersion");
		if ( version != "")
			array[array.length] = ["version", version];
	}

	if ( oidMarca != "")
		array[array.length] = ["oidMarca", oidMarca];

	if ( oidCanal != "")
		array[array.length] = ["oidCanal", oidCanal];

	if ( indActivo != "")
		array[array.length] = ["indActivo", indActivo];

	array[array.length] = ["oidIdioma", oidIdioma];
	array[array.length] = ["oidPais", oidPais];

	return array;
}

function manejarLista(visible){
	DrdEnsanchaConMargenDcho('listado1',12);
	document.all["Cplistado1"].style.visibility = visible;
	document.all["CpLin1listado1"].style.visibility = visible;
	document.all["CpLin2listado1"].style.visibility = visible;
	document.all["CpLin3listado1"].style.visibility = visible;
	document.all["CpLin4listado1"].style.visibility = visible;
	document.all["separaDiv"].style.visibility = visible;
	document.all["primera1Div"].style.visibility = visible;
	document.all["ret1Div"].style.visibility = visible;
	document.all["ava1Div"].style.visibility = visible;

	gestionarBotones(visible);

	eval (ON_RSZ);  
}

//Autor: Marcelo J. Maidana
//Fecha: 11/06/2005
function muestraLista(ultima, rowset){
    var tamano = rowset.length;
    
    if (tamano > 0) {
        manejarLista('');
        eval(ON_RSZ);
        return true;
    } else {
        manejarLista('hidden');
        return false;
    }
}

// Funcion creada por Cristian Valenzuela
// 4-5-2006
// Cambios versionado
function accionModificar() {
	var opcionMenu = get("formulario.opcionMenu");
	var oidPlantilla = null;
	var numPlantilla = null;
	var oidParamGrales = null;
	var filaMarcada = null;
	var codSeleccionados = null;
	var datos = null;	

	listado1.actualizaDat();
	datos = listado1.datos;
	codSeleccionados = listado1.codSeleccionados();

	if (codSeleccionados.length > 1) {
        GestionarMensaje('8');
		return;
	}

	if ( codSeleccionados.length < 1)	{
        GestionarMensaje('4');
		return;
	}

	// Obtengo el índice de la fila marcada (en este punto, solo una estará marcada)
	var filaMarcada = listado1.filaSelecc;

	// Obtengo el oid de Param. Generales (oid del valor seleccionado, está al final de la lista por el tema del ROWNUM)
	oidParamGrales = datos[filaMarcada][9]; 

	// Obtengo Oid de la Entidad PlantillaConcurso (AKA Numero de Plantilla);
	numPlantilla = datos[filaMarcada][3];

	var oidVigenciaConcurso = datos[filaMarcada][10]; 
	var oidEstadoConcurso = datos[filaMarcada][11]; 
	var noVigencia = get("formulario.noVigencia");
	var estConcuAprobado = get("formulario.estConcuAprobado");

	if((parseInt(oidVigenciaConcurso) == parseInt(noVigencia)) && 		
	(parseInt(oidEstadoConcurso)!=parseInt(estConcuAprobado))) {
		var obj = new Object();
		// Seteo los valores obtenidos. 
		obj.oidConcurso = oidParamGrales;
		obj.oidPlantilla = numPlantilla;
		obj.opcionMenu = opcionMenu;
		var retorno = mostrarModalSICC('LPMantenerParametrosGenerales', '', obj);
		accionBuscar();
	}
	else {
		var indDespacho = datos[filaMarcada][12];
		if (oidVigenciaConcurso == '1' &&  parseInt(indDespacho) == 0) {
			if (GestionarMensaje('3385')) {
				var obj = new Object();
				// Seteo los valores obtenidos. 
				obj.oidConcurso = oidParamGrales;
				obj.oidPlantilla = numPlantilla;
				obj.opcionMenu = opcionMenu;
				obj.oidVigenciaConcurso = oidVigenciaConcurso;
				var retorno = mostrarModalSICC('LPMantenerParametrosGenerales', '', obj);
				accionBuscar();
			}	
		}
		else {
			//El concurso seleccionado no puede ser modificado
			GestionarMensaje('INC052');
		}
	}
}

function accionDetalle(){
	var opcionMenu = get("formulario.opcionMenu");
	var oidPlantilla = null;
	var numPlantilla = null;
	var oidParamGrales = null;
	var filaMarcada = null;
	var codSeleccionados = null;
	var datos = null;
	var obj = new Object();

	listado1.actualizaDat();
	datos = listado1.datos;
	codSeleccionados = listado1.codSeleccionados();

	if (codSeleccionados.length > 1) {
        GestionarMensaje('8');
		return;
	}

	if ( codSeleccionados.length < 1)	{
        GestionarMensaje('4');
		return;
	}

	// Obtengo el índice de la fila marcada (en este punto, solo una estará marcada)
	var filaMarcada = listado1.filaSelecc;

	// Obtengo el oid de Param. Generales (oid del valor seleccionado, está al final de la lista por el tema del ROWNUM)
	oidParamGrales = datos[filaMarcada][9]; 

	// Obtengo Oid de la Entidad PlantillaConcurso (AKA Numero de Plantilla);
	numPlantilla = datos[filaMarcada][3];

	// Seteo los valores obtenidos. 
	obj.oidConcurso = oidParamGrales;
	obj.oidPlantilla = numPlantilla;
	obj.opcionMenu = opcionMenu;
	var retorno = mostrarModalSICC('LPMantenerParametrosGenerales', '', obj);
	accionBuscar();
}
