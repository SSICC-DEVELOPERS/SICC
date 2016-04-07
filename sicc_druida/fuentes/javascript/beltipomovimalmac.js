

/*
    INDRA/CAR/mmg
    $Id: beltipomovimalmac.js,v 1.1 2009/12/03 19:01:44 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsBelTipoMovimAlmacId = "";
var jsBelTipoMovimAlmacPaisOidPais = "";
var jsBelTipoMovimAlmacCodTipoMovi = "";
var jsBelTipoMovimAlmacCodMoviSap = "";
var jsBelTipoMovimAlmacIndMoviEntrAlma = "";
var jsBelTipoMovimAlmacIndMantMovi = "";
var jsBelTipoMovimAlmacIndSap = "";
var jsBelTipoMovimAlmacEsmeOidEstaMerc1 = "";
var jsBelTipoMovimAlmacEsmeOidEstaMerc2 = "";
var jsBelTipoMovimAlmacCodOper1 = "";
var jsBelTipoMovimAlmacCodOper2 = "";

//Variables de paginacion, 
var belTipoMovimAlmacPageCount = 1;

//Varible de columna que representa el campo de choice
var belTipoMovimAlmacChoiceColumn = 1;

//Flag de siguiente pagina;
var belTipoMovimAlmacMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var belTipoMovimAlmacTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 483;
var sizeFormView = 477;
var sizeFormUpdate = 477;

//Ultima busqueda realizada
var belTipoMovimAlmacLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("belTipoMovimAlmac","paisOidPais", false);','focalizaComboDependence("belTipoMovimAlmac","paisOidPais", false);','focalizaComboDependence("belTipoMovimAlmac","paisOidPais", false);','focalizaComboDependence("belTipoMovimAlmac","paisOidPais", true);','focalizaComboDependence("belTipoMovimAlmac","paisOidPais", true);','focalizaComboDependence("belTipoMovimAlmac","paisOidPais", true);'],[3,'focaliza("belTipoMovimAlmacFrm.codTipoMovi");','focaliza("belTipoMovimAlmacFrm.codTipoMovi");','focaliza("belTipoMovimAlmacFrm.codTipoMovi");','focaliza("belTipoMovimAlmacFrm.codTipoMovi");','focaliza("belTipoMovimAlmacFrm.codTipoMovi");','focaliza("belTipoMovimAlmacFrm.codTipoMovi");'],[4,'focaliza("belTipoMovimAlmacFrm.codMoviSap");','focaliza("belTipoMovimAlmacFrm.codMoviSap");','focaliza("belTipoMovimAlmacFrm.codMoviSap");','focaliza("belTipoMovimAlmacFrm.codMoviSap");','focaliza("belTipoMovimAlmacFrm.codMoviSap");','focaliza("belTipoMovimAlmacFrm.codMoviSap");'],[5,'focaliza("belTipoMovimAlmacFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacFrm.indMoviEntrAlma");'],[6,'focaliza("belTipoMovimAlmacFrm.indMantMovi");','focaliza("belTipoMovimAlmacFrm.indMantMovi");','focaliza("belTipoMovimAlmacFrm.indMantMovi");','focaliza("belTipoMovimAlmacFrm.indMantMovi");','focaliza("belTipoMovimAlmacFrm.indMantMovi");','focaliza("belTipoMovimAlmacFrm.indMantMovi");'],[7,'focaliza("belTipoMovimAlmacFrm.indSap");','focaliza("belTipoMovimAlmacFrm.indSap");','focaliza("belTipoMovimAlmacFrm.indSap");','focaliza("belTipoMovimAlmacFrm.indSap");','focaliza("belTipoMovimAlmacFrm.indSap");','focaliza("belTipoMovimAlmacFrm.indSap");'],[8,'focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc1", false);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc1", false);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc1", false);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc1", true);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc1", true);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc1", true);'],[9,'focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc2", false);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc2", false);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc2", false);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc2", true);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc2", true);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc2", true);'],[10,'focaliza("belTipoMovimAlmacFrm.codOper1");','focaliza("belTipoMovimAlmacFrm.codOper1");','focaliza("belTipoMovimAlmacFrm.codOper1");','focaliza("belTipoMovimAlmacFrm.codOper1");','focaliza("belTipoMovimAlmacFrm.codOper1");','focaliza("belTipoMovimAlmacFrm.codOper1");'],[11,'focaliza("belTipoMovimAlmacFrm.codOper2");','focaliza("belTipoMovimAlmacFrm.codOper2");','focaliza("belTipoMovimAlmacFrm.codOper2");','focaliza("belTipoMovimAlmacFrm.codOper2");','focaliza("belTipoMovimAlmacFrm.codOper2");','focaliza("belTipoMovimAlmacFrm.codOper2");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focalizaComboDependence("belTipoMovimAlmac","paisOidPais", false);','focalizaComboDependence("belTipoMovimAlmac","paisOidPais", false);','focalizaComboDependence("belTipoMovimAlmac","paisOidPais", false);','focalizaComboDependence("belTipoMovimAlmac","paisOidPais", true);','focalizaComboDependence("belTipoMovimAlmac","paisOidPais", true);','focalizaComboDependence("belTipoMovimAlmac","paisOidPais", true);'],[3,'focaliza("belTipoMovimAlmacFrm.codTipoMovi");','focaliza("belTipoMovimAlmacFrm.codTipoMovi");','focaliza("belTipoMovimAlmacFrm.codTipoMovi");','focaliza("belTipoMovimAlmacFrm.codTipoMovi");','focaliza("belTipoMovimAlmacFrm.codTipoMovi");','focaliza("belTipoMovimAlmacFrm.codTipoMovi");'],[4,'focaliza("belTipoMovimAlmacFrm.codMoviSap");','focaliza("belTipoMovimAlmacFrm.codMoviSap");','focaliza("belTipoMovimAlmacFrm.codMoviSap");','focaliza("belTipoMovimAlmacFrm.codMoviSap");','focaliza("belTipoMovimAlmacFrm.codMoviSap");','focaliza("belTipoMovimAlmacFrm.codMoviSap");'],[5,'focaliza("belTipoMovimAlmacFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacFrm.indMoviEntrAlma");','focaliza("belTipoMovimAlmacFrm.indMoviEntrAlma");'],[6,'focaliza("belTipoMovimAlmacFrm.indMantMovi");','focaliza("belTipoMovimAlmacFrm.indMantMovi");','focaliza("belTipoMovimAlmacFrm.indMantMovi");','focaliza("belTipoMovimAlmacFrm.indMantMovi");','focaliza("belTipoMovimAlmacFrm.indMantMovi");','focaliza("belTipoMovimAlmacFrm.indMantMovi");'],[7,'focaliza("belTipoMovimAlmacFrm.indSap");','focaliza("belTipoMovimAlmacFrm.indSap");','focaliza("belTipoMovimAlmacFrm.indSap");','focaliza("belTipoMovimAlmacFrm.indSap");','focaliza("belTipoMovimAlmacFrm.indSap");','focaliza("belTipoMovimAlmacFrm.indSap");'],[8,'focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc1", false);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc1", false);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc1", false);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc1", true);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc1", true);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc1", true);'],[9,'focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc2", false);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc2", false);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc2", false);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc2", true);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc2", true);','focalizaComboDependence("belTipoMovimAlmac","esmeOidEstaMerc2", true);'],[10,'focaliza("belTipoMovimAlmacFrm.codOper1");','focaliza("belTipoMovimAlmacFrm.codOper1");','focaliza("belTipoMovimAlmacFrm.codOper1");','focaliza("belTipoMovimAlmacFrm.codOper1");','focaliza("belTipoMovimAlmacFrm.codOper1");','focaliza("belTipoMovimAlmacFrm.codOper1");'],[11,'focaliza("belTipoMovimAlmacFrm.codOper2");','focaliza("belTipoMovimAlmacFrm.codOper2");','focaliza("belTipoMovimAlmacFrm.codOper2");','focaliza("belTipoMovimAlmacFrm.codOper2");','focaliza("belTipoMovimAlmacFrm.codOper2");','focaliza("belTipoMovimAlmacFrm.codOper2");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_fopaOidFormPago', padresTmp, 'paisOidPais', 'BelFormaPagoTapon']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMone', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMoneAlt', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar(['paisOidPais_fopaOidFormPago','paisOidPais_moneOidMone','paisOidPais_moneOidMoneAlt'])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPais']);
var esmeOidEstaMerc1DependeceMap = new Vector();
esmeOidEstaMerc1DependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
esmeOidEstaMerc1DependeceMap.agregar(['esmeOidEstaMerc1', padresTmp, '', 'BelEstadMerca']);
var esmeOidEstaMerc2DependeceMap = new Vector();
esmeOidEstaMerc2DependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
esmeOidEstaMerc2DependeceMap.agregar(['esmeOidEstaMerc2', padresTmp, '', 'BelEstadMerca']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
belTipoMovimAlmacLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var belTipoMovimAlmacTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function belTipoMovimAlmacInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('belTipoMovimAlmacFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('belTipoMovimAlmacFrm.accion')){
		case "query": belTipoMovimAlmacQueryInitComponents(); break;
		case "view": belTipoMovimAlmacViewInitComponents(); break;
		case "create": belTipoMovimAlmacCreateInitComponents(); break;
		case "update": belTipoMovimAlmacUpdateInitComponents(); break;
		case "remove": belTipoMovimAlmacRemoveInitComponents(); break;
		case "lov": belTipoMovimAlmacLovInitComponents(); break;
	}
	//alert('accion :' + get('belTipoMovimAlmacFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('belTipoMovimAlmacFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('belTipoMovimAlmac')) belTipoMovimAlmacCmdRequery();
}

function belTipoMovimAlmacQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('belTipoMovimAlmacFrm', true);	
}

function belTipoMovimAlmacViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('belTipoMovimAlmacFrm', true);
}

function belTipoMovimAlmacCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('belTipoMovimAlmacFrm.paisOidPais','S', GestionarMensaje('BelTipoMovimAlmac.paisOidPais.requiered.message'));
	
	setMV('belTipoMovimAlmacFrm.codTipoMovi','S', GestionarMensaje('BelTipoMovimAlmac.codTipoMovi.requiered.message'));
	
	setMV('belTipoMovimAlmacFrm.indMoviEntrAlma','S', GestionarMensaje('BelTipoMovimAlmac.indMoviEntrAlma.requiered.message'));
	
	setMV('belTipoMovimAlmacFrm.indMantMovi','S', GestionarMensaje('BelTipoMovimAlmac.indMantMovi.requiered.message'));
	
	setMV('belTipoMovimAlmacFrm.indSap','S', GestionarMensaje('BelTipoMovimAlmac.indSap.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('belTipoMovimAlmacFrm', true);
}

function belTipoMovimAlmacUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('belTipoMovimAlmacFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		belTipoMovimAlmacTmpUpdateValues = belTipoMovimAlmacBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('belTipoMovimAlmacFrm.paisOidPais','S', GestionarMensaje('BelTipoMovimAlmac.paisOidPais.requiered.message'));
		setMV('belTipoMovimAlmacFrm.codTipoMovi','S', GestionarMensaje('BelTipoMovimAlmac.codTipoMovi.requiered.message'));
		setMV('belTipoMovimAlmacFrm.indMoviEntrAlma','S', GestionarMensaje('BelTipoMovimAlmac.indMoviEntrAlma.requiered.message'));
		setMV('belTipoMovimAlmacFrm.indMantMovi','S', GestionarMensaje('BelTipoMovimAlmac.indMantMovi.requiered.message'));
		setMV('belTipoMovimAlmacFrm.indSap','S', GestionarMensaje('BelTipoMovimAlmac.indSap.requiered.message'));
		
			focusFirstFieldModify('belTipoMovimAlmacFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('belTipoMovimAlmacFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('belTipoMovimAlmacFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function belTipoMovimAlmacRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	belTipoMovimAlmacList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('belTipoMovimAlmacFrm', true);
}

function belTipoMovimAlmacLovInitComponents(){
	belTipoMovimAlmacLovReturnParameters = window.dialogArguments;
	
	focusFirstField('belTipoMovimAlmacFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad













//Función que permite cargar los datos de un elemento de lov seleccionado
function belTipoMovimAlmacSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('belTipoMovimAlmacFrm.' + campo, id);
	set('belTipoMovimAlmacFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function belTipoMovimAlmacLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	belTipoMovimAlmacLovReturnParameters.id = '';
	belTipoMovimAlmacLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function belTipoMovimAlmacLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belTipoMovimAlmacList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = belTipoMovimAlmacList.codSeleccionados();
	var descripcion = belTipoMovimAlmacList.extraeDato(
		belTipoMovimAlmacList.codSeleccionados()[0], belTipoMovimAlmacChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	belTipoMovimAlmacLovReturnParameters.id = codigo;
	belTipoMovimAlmacLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function belTipoMovimAlmacCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('belTipoMovimAlmacFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('belTipoMovimAlmacFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "belTipoMovimAlmacList", "BelTipoMovimAlmacConectorTransactionQuery", 
		"result_ROWSET", parametros, "belTipoMovimAlmacPostQueryActions(datos);"]], "", "");	
}

function belTipoMovimAlmacCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('belTipoMovimAlmacFrm.lastQueryToSession'));
	var i =0;
	set('belTipoMovimAlmacFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('belTipoMovimAlmacFrm.codTipoMovi', paramsRequery.ij(i++));
	
	set('belTipoMovimAlmacFrm.codMoviSap', paramsRequery.ij(i++));
	
	set('belTipoMovimAlmacFrm.indMoviEntrAlma', paramsRequery.ij(i++));
	
	set('belTipoMovimAlmacFrm.indMantMovi', paramsRequery.ij(i++));
	
	set('belTipoMovimAlmacFrm.indSap', paramsRequery.ij(i++));
	
	set('belTipoMovimAlmacFrm.esmeOidEstaMerc1', [paramsRequery.ij(i++)]);
	
	set('belTipoMovimAlmacFrm.esmeOidEstaMerc2', [paramsRequery.ij(i++)]);
	
	set('belTipoMovimAlmacFrm.codOper1', paramsRequery.ij(i++));
	
	set('belTipoMovimAlmacFrm.codOper2', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	belTipoMovimAlmacPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	belTipoMovimAlmacCmdQuery(belTipoMovimAlmacPageCount);
}

function belTipoMovimAlmacFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	belTipoMovimAlmacPageCount = 1;
	belTipoMovimAlmacCmdQuery(belTipoMovimAlmacPageCount);
}

function belTipoMovimAlmacPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belTipoMovimAlmacLastQuery){
		belTipoMovimAlmacFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	belTipoMovimAlmacPageCount--;
	belTipoMovimAlmacCmdQuery(belTipoMovimAlmacPageCount);
}

function belTipoMovimAlmacNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belTipoMovimAlmacLastQuery){
		belTipoMovimAlmacFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	belTipoMovimAlmacPageCount++;
	belTipoMovimAlmacCmdQuery(belTipoMovimAlmacPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function belTipoMovimAlmacPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('belTipoMovimAlmacListLayer', 'O');
		visibilidad('belTipoMovimAlmacListButtonsLayer', 'O');
		if(get('belTipoMovimAlmacFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	belTipoMovimAlmacLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:belTipoMovimAlmacViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, belTipoMovimAlmacChoiceColumn) + "</A>",
			i, belTipoMovimAlmacChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	belTipoMovimAlmacList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	belTipoMovimAlmacTimeStamps = datosTmp.filtrar([11],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		belTipoMovimAlmacMorePagesFlag = true;
		belTipoMovimAlmacList.eliminar(mmgPageSize, 1);
	}else{
		belTipoMovimAlmacMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('belTipoMovimAlmacFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('belTipoMovimAlmacListLayer', 'V');
	visibilidad('belTipoMovimAlmacListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('belTipoMovimAlmacList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	belTipoMovimAlmacList.display();
	
	//Actualizamos el estado de los botones 
	if(belTipoMovimAlmacMorePagesFlag){
		set_estado_botonera('belTipoMovimAlmacPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('belTipoMovimAlmacPaginationButtonBar',
			3,"inactivo");
	}
	if(belTipoMovimAlmacPageCount > 1){
		set_estado_botonera('belTipoMovimAlmacPaginationButtonBar',
			2,"activo");
		set_estado_botonera('belTipoMovimAlmacPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('belTipoMovimAlmacPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('belTipoMovimAlmacPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function belTipoMovimAlmacUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belTipoMovimAlmacList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('belTipoMovimAlmacFrm.idSelection', belTipoMovimAlmacList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('belTipoMovimAlmacFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = belTipoMovimAlmacList.codSeleccionados()[0];
		parametros["previousAction"] = get('belTipoMovimAlmacFrm.accion');
		parametros["accion"] = get('belTipoMovimAlmacFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('BelTipoMovimAlmacLPStartUp', get('belTipoMovimAlmacFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) belTipoMovimAlmacCmdRequery();
	}
}

function belTipoMovimAlmacRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belTipoMovimAlmacList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = belTipoMovimAlmacList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('belTipoMovimAlmacFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(belTipoMovimAlmacList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += belTipoMovimAlmacTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('belTipoMovimAlmacFrm.timestamp', timestamps);


	belTipoMovimAlmacFrm.oculto='S';
	envia('belTipoMovimAlmacFrm');
	belTipoMovimAlmacFrm.oculto='N';
}

function belTipoMovimAlmacViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belTipoMovimAlmacList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	belTipoMovimAlmacViewDetail(belTipoMovimAlmacList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function belTipoMovimAlmacViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('belTipoMovimAlmacFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('BelTipoMovimAlmacLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('belTipoMovimAlmacFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		belTipoMovimAlmacFrm.oculto='S';
		envia('belTipoMovimAlmacFrm');
		belTipoMovimAlmacFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('belTipoMovimAlmacFrm.paisOidPais').toString() == ''){
		set('belTipoMovimAlmacFrm.paisOidPais_fopaOidFormPago', []);
		mmgResetCombosOnCascade('paisOidPais_fopaOidFormPago', 'paisOidPais', 'belTipoMovimAlmac');
		set('belTipoMovimAlmacFrm.paisOidPais_moneOidMone', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMone', 'paisOidPais', 'belTipoMovimAlmac');
		set('belTipoMovimAlmacFrm.paisOidPais_moneOidMoneAlt', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMoneAlt', 'paisOidPais', 'belTipoMovimAlmac');
		
	}
	if(get('belTipoMovimAlmacFrm.esmeOidEstaMerc1').toString() == ''){
		set('belTipoMovimAlmacFrm.esmeOidEstaMerc1', []);
		mmgResetCombosOnCascade('esmeOidEstaMerc1', 'esmeOidEstaMerc1', 'belTipoMovimAlmac');
		
	}
	if(get('belTipoMovimAlmacFrm.esmeOidEstaMerc2').toString() == ''){
		set('belTipoMovimAlmacFrm.esmeOidEstaMerc2', []);
		mmgResetCombosOnCascade('esmeOidEstaMerc2', 'esmeOidEstaMerc2', 'belTipoMovimAlmac');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	belTipoMovimAlmacRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('belTipoMovimAlmacFrm.accion');
	var origenTmp = get('belTipoMovimAlmacFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(belTipoMovimAlmacBuildUpdateRecordString() != belTipoMovimAlmacTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
		window.close();
	}else if(accionTmp == 'view'){
		window.close();
	}
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.belTipoMovimAlmacListLayer.style.display='none';
	document.all.belTipoMovimAlmacListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.belTipoMovimAlmacListLayer.style.display='';
	document.all.belTipoMovimAlmacListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsBelTipoMovimAlmacPaisOidPais = get('belTipoMovimAlmacFrm.paisOidPais')[0];
	jsBelTipoMovimAlmacCodTipoMovi = get('belTipoMovimAlmacFrm.codTipoMovi').toString();
	jsBelTipoMovimAlmacCodMoviSap = get('belTipoMovimAlmacFrm.codMoviSap').toString();
	jsBelTipoMovimAlmacIndMoviEntrAlma = get('belTipoMovimAlmacFrm.indMoviEntrAlma').toString();
	jsBelTipoMovimAlmacIndMantMovi = get('belTipoMovimAlmacFrm.indMantMovi').toString();
	jsBelTipoMovimAlmacIndSap = get('belTipoMovimAlmacFrm.indSap').toString();
	jsBelTipoMovimAlmacEsmeOidEstaMerc1 = get('belTipoMovimAlmacFrm.esmeOidEstaMerc1')[0];
	jsBelTipoMovimAlmacEsmeOidEstaMerc2 = get('belTipoMovimAlmacFrm.esmeOidEstaMerc2')[0];
	jsBelTipoMovimAlmacCodOper1 = get('belTipoMovimAlmacFrm.codOper1').toString();
	jsBelTipoMovimAlmacCodOper2 = get('belTipoMovimAlmacFrm.codOper2').toString();
	
	
	var parametros = "";
	parametros += jsBelTipoMovimAlmacPaisOidPais + "|";
	parametros += jsBelTipoMovimAlmacCodTipoMovi + "|";
	parametros += jsBelTipoMovimAlmacCodMoviSap + "|";
	parametros += jsBelTipoMovimAlmacIndMoviEntrAlma + "|";
	parametros += jsBelTipoMovimAlmacIndMantMovi + "|";
	parametros += jsBelTipoMovimAlmacIndSap + "|";
	parametros += jsBelTipoMovimAlmacEsmeOidEstaMerc1 + "|";
	parametros += jsBelTipoMovimAlmacEsmeOidEstaMerc2 + "|";
	parametros += jsBelTipoMovimAlmacCodOper1 + "|";
	parametros += jsBelTipoMovimAlmacCodOper2 + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function belTipoMovimAlmacBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsBelTipoMovimAlmacPaisOidPais + "|";
	parametros += jsBelTipoMovimAlmacCodTipoMovi + "|";
	parametros += jsBelTipoMovimAlmacCodMoviSap + "|";
	parametros += jsBelTipoMovimAlmacIndMoviEntrAlma + "|";
	parametros += jsBelTipoMovimAlmacIndMantMovi + "|";
	parametros += jsBelTipoMovimAlmacIndSap + "|";
	parametros += jsBelTipoMovimAlmacEsmeOidEstaMerc1 + "|";
	parametros += jsBelTipoMovimAlmacEsmeOidEstaMerc2 + "|";
	parametros += jsBelTipoMovimAlmacCodOper1 + "|";
	parametros += jsBelTipoMovimAlmacCodOper2 + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belTipoMovimAlmacFrm.accion'), 
		get('belTipoMovimAlmacFrm.origen'));
	
	jsBelTipoMovimAlmacId = get('belTipoMovimAlmacFrm.id').toString();
	jsBelTipoMovimAlmacPaisOidPais = get('belTipoMovimAlmacFrm.paisOidPais')[0];
	jsBelTipoMovimAlmacCodTipoMovi = get('belTipoMovimAlmacFrm.codTipoMovi').toString();
	jsBelTipoMovimAlmacCodMoviSap = get('belTipoMovimAlmacFrm.codMoviSap').toString();
	jsBelTipoMovimAlmacIndMoviEntrAlma = get('belTipoMovimAlmacFrm.indMoviEntrAlma').toString();
	jsBelTipoMovimAlmacIndMantMovi = get('belTipoMovimAlmacFrm.indMantMovi').toString();
	jsBelTipoMovimAlmacIndSap = get('belTipoMovimAlmacFrm.indSap').toString();
	jsBelTipoMovimAlmacEsmeOidEstaMerc1 = get('belTipoMovimAlmacFrm.esmeOidEstaMerc1')[0];
	jsBelTipoMovimAlmacEsmeOidEstaMerc2 = get('belTipoMovimAlmacFrm.esmeOidEstaMerc2')[0];
	jsBelTipoMovimAlmacCodOper1 = get('belTipoMovimAlmacFrm.codOper1').toString();
	jsBelTipoMovimAlmacCodOper2 = get('belTipoMovimAlmacFrm.codOper2').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belTipoMovimAlmacFrm.accion'), 
		get('belTipoMovimAlmacFrm.origen'));


	set('belTipoMovimAlmacFrm.id', jsBelTipoMovimAlmacId);
	set('belTipoMovimAlmacFrm.paisOidPais', [jsBelTipoMovimAlmacPaisOidPais]);
	set('belTipoMovimAlmacFrm.codTipoMovi', jsBelTipoMovimAlmacCodTipoMovi);
	set('belTipoMovimAlmacFrm.codMoviSap', jsBelTipoMovimAlmacCodMoviSap);
	set('belTipoMovimAlmacFrm.indMoviEntrAlma', jsBelTipoMovimAlmacIndMoviEntrAlma);
	set('belTipoMovimAlmacFrm.indMantMovi', jsBelTipoMovimAlmacIndMantMovi);
	set('belTipoMovimAlmacFrm.indSap', jsBelTipoMovimAlmacIndSap);
	set('belTipoMovimAlmacFrm.esmeOidEstaMerc1', [jsBelTipoMovimAlmacEsmeOidEstaMerc1]);
	set('belTipoMovimAlmacFrm.esmeOidEstaMerc2', [jsBelTipoMovimAlmacEsmeOidEstaMerc2]);
	set('belTipoMovimAlmacFrm.codOper1', jsBelTipoMovimAlmacCodOper1);
	set('belTipoMovimAlmacFrm.codOper2', jsBelTipoMovimAlmacCodOper2);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsBelTipoMovimAlmacPaisOidPais = '';
	jsBelTipoMovimAlmacCodTipoMovi = '';
	jsBelTipoMovimAlmacCodMoviSap = '';
	jsBelTipoMovimAlmacIndMoviEntrAlma = '';
	jsBelTipoMovimAlmacIndMantMovi = '';
	jsBelTipoMovimAlmacIndSap = '';
	jsBelTipoMovimAlmacEsmeOidEstaMerc1 = '';
	jsBelTipoMovimAlmacEsmeOidEstaMerc2 = '';
	jsBelTipoMovimAlmacCodOper1 = '';
	jsBelTipoMovimAlmacCodOper2 = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('belTipoMovimAlmacFrm.errCodigo', errorCode);
	set('belTipoMovimAlmacFrm.errDescripcion', description);
	set('belTipoMovimAlmacFrm.errSeverity', severity);
	fMostrarMensajeError();
}
