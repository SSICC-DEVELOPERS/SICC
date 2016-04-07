

/*
    INDRA/CAR/mmg
    $Id: cobguionargumdetal.js,v 1.1 2009/12/03 19:02:15 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCobGuionArgumDetalId = "";
var jsCobGuionArgumDetalGacaOidGuioArguCabe = "";
var jsCobGuionArgumDetalArguOidArgu = "";
var jsCobGuionArgumDetalNumOrdeArgu = "";
var jsCobGuionArgumDetalIndActiAtriObse = "";
var jsCobGuionArgumDetalValObse = "";
var jsCobGuionArgumDetalVaarOidValoArgu = "";

//Variables de paginacion, 
var cobGuionArgumDetalPageCount = 1;

//Varible de columna que representa el campo de choice
var cobGuionArgumDetalChoiceColumn = 2;

//Flag de siguiente pagina;
var cobGuionArgumDetalMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cobGuionArgumDetalTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 305;
var sizeFormUpdate = 305;

//Ultima busqueda realizada
var cobGuionArgumDetalLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("cobGuionArgumDetal","gacaOidGuioArguCabe", false);','focalizaComboDependence("cobGuionArgumDetal","gacaOidGuioArguCabe", false);','focalizaComboDependence("cobGuionArgumDetal","gacaOidGuioArguCabe", false);','focalizaComboDependence("cobGuionArgumDetal","gacaOidGuioArguCabe", true);','focalizaComboDependence("cobGuionArgumDetal","gacaOidGuioArguCabe", true);','focalizaComboDependence("cobGuionArgumDetal","gacaOidGuioArguCabe", true);'],[3,'focalizaComboDependence("cobGuionArgumDetal","arguOidArgu", false);','focalizaComboDependence("cobGuionArgumDetal","arguOidArgu", false);','focalizaComboDependence("cobGuionArgumDetal","arguOidArgu", false);','focalizaComboDependence("cobGuionArgumDetal","arguOidArgu", true);','focalizaComboDependence("cobGuionArgumDetal","arguOidArgu", true);','focalizaComboDependence("cobGuionArgumDetal","arguOidArgu", true);'],[4,'','focaliza("cobGuionArgumDetalFrm.numOrdeArgu");','focaliza("cobGuionArgumDetalFrm.numOrdeArgu");','','focaliza("cobGuionArgumDetalFrm.numOrdeArgu");','focaliza("cobGuionArgumDetalFrm.numOrdeArgu");'],[5,'','focaliza("cobGuionArgumDetalFrm.indActiAtriObse");','focaliza("cobGuionArgumDetalFrm.indActiAtriObse");','','focaliza("cobGuionArgumDetalFrm.indActiAtriObse");','focaliza("cobGuionArgumDetalFrm.indActiAtriObse");'],[6,'','focaliza("cobGuionArgumDetalFrm.valObse");','focaliza("cobGuionArgumDetalFrm.valObse");','','focaliza("cobGuionArgumDetalFrm.valObse");','focaliza("cobGuionArgumDetalFrm.valObse");'],[7,'','focalizaComboDependence("cobGuionArgumDetal","vaarOidValoArgu", false);','focalizaComboDependence("cobGuionArgumDetal","vaarOidValoArgu", false);','','focalizaComboDependence("cobGuionArgumDetal","vaarOidValoArgu", true);','focalizaComboDependence("cobGuionArgumDetal","vaarOidValoArgu", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'','focaliza("cobGuionArgumDetalFrm.numOrdeArgu");','focaliza("cobGuionArgumDetalFrm.numOrdeArgu");','','focaliza("cobGuionArgumDetalFrm.numOrdeArgu");','focaliza("cobGuionArgumDetalFrm.numOrdeArgu");'],[5,'','focaliza("cobGuionArgumDetalFrm.indActiAtriObse");','focaliza("cobGuionArgumDetalFrm.indActiAtriObse");','','focaliza("cobGuionArgumDetalFrm.indActiAtriObse");','focaliza("cobGuionArgumDetalFrm.indActiAtriObse");'],[6,'','focaliza("cobGuionArgumDetalFrm.valObse");','focaliza("cobGuionArgumDetalFrm.valObse");','','focaliza("cobGuionArgumDetalFrm.valObse");','focaliza("cobGuionArgumDetalFrm.valObse");'],[7,'','focalizaComboDependence("cobGuionArgumDetal","vaarOidValoArgu", false);','focalizaComboDependence("cobGuionArgumDetal","vaarOidValoArgu", false);','','focalizaComboDependence("cobGuionArgumDetal","vaarOidValoArgu", true);','focalizaComboDependence("cobGuionArgumDetal","vaarOidValoArgu", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var gacaOidGuioArguCabeDependeceMap = new Vector();
gacaOidGuioArguCabeDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
gacaOidGuioArguCabeDependeceMap.agregar(['gacaOidGuioArguCabe', padresTmp, '', 'CobGuionArgumCabec']);
var arguOidArguDependeceMap = new Vector();
arguOidArguDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
arguOidArguDependeceMap.agregar(['arguOidArgu', padresTmp, '', 'CobArgum']);
var vaarOidValoArguDependeceMap = new Vector();
vaarOidValoArguDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
vaarOidValoArguDependeceMap.agregar(['vaarOidValoArgu_arguOidArgu', padresTmp, 'vaarOidValoArgu', 'CobArgum']);
padresTmp =  new Vector();
padresTmp.cargar(['vaarOidValoArgu_arguOidArgu'])
vaarOidValoArguDependeceMap.agregar(['vaarOidValoArgu', padresTmp, '', 'CobValorArgum']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cobGuionArgumDetalLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cobGuionArgumDetalTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function cobGuionArgumDetalInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cobGuionArgumDetalFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cobGuionArgumDetalFrm.accion')){
		case "query": cobGuionArgumDetalQueryInitComponents(); break;
		case "view": cobGuionArgumDetalViewInitComponents(); break;
		case "create": cobGuionArgumDetalCreateInitComponents(); break;
		case "update": cobGuionArgumDetalUpdateInitComponents(); break;
		case "remove": cobGuionArgumDetalRemoveInitComponents(); break;
		case "lov": cobGuionArgumDetalLovInitComponents(); break;
	}
	//alert('accion :' + get('cobGuionArgumDetalFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cobGuionArgumDetalFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cobGuionArgumDetal')) cobGuionArgumDetalCmdRequery();
}

function cobGuionArgumDetalQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('cobGuionArgumDetalFrm', true);	
}

function cobGuionArgumDetalViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	//Establecemos el valor de los radiobuttons
		set('cobGuionArgumDetalFrm.indActiAtriObse', get('cobGuionArgumDetalFrm.indActiAtriObseCheckValue'));
		
	focusFirstField('cobGuionArgumDetalFrm', true);
}

function cobGuionArgumDetalCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cobGuionArgumDetalFrm.gacaOidGuioArguCabe','S', GestionarMensaje('CobGuionArgumDetal.gacaOidGuioArguCabe.requiered.message'));
	
	setMV('cobGuionArgumDetalFrm.arguOidArgu','S', GestionarMensaje('CobGuionArgumDetal.arguOidArgu.requiered.message'));
	
	setMV('cobGuionArgumDetalFrm.numOrdeArgu','S', GestionarMensaje('CobGuionArgumDetal.numOrdeArgu.requiered.message'));
	
	setMV('cobGuionArgumDetalFrm.indActiAtriObse','S', GestionarMensaje('CobGuionArgumDetal.indActiAtriObse.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cobGuionArgumDetalFrm', true);
}

function cobGuionArgumDetalUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cobGuionArgumDetalFrm.origen') == "pagina"){
		

		//Establecemos el valor de los radiobuttons
			set('cobGuionArgumDetalFrm.indActiAtriObse', get('cobGuionArgumDetalFrm.indActiAtriObseCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		cobGuionArgumDetalTmpUpdateValues = cobGuionArgumDetalBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cobGuionArgumDetalFrm.gacaOidGuioArguCabe','S', GestionarMensaje('CobGuionArgumDetal.gacaOidGuioArguCabe.requiered.message'));
		setMV('cobGuionArgumDetalFrm.arguOidArgu','S', GestionarMensaje('CobGuionArgumDetal.arguOidArgu.requiered.message'));
		setMV('cobGuionArgumDetalFrm.numOrdeArgu','S', GestionarMensaje('CobGuionArgumDetal.numOrdeArgu.requiered.message'));
		setMV('cobGuionArgumDetalFrm.indActiAtriObse','S', GestionarMensaje('CobGuionArgumDetal.indActiAtriObse.requiered.message'));
		
			focusFirstFieldModify('cobGuionArgumDetalFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('cobGuionArgumDetalFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cobGuionArgumDetalFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cobGuionArgumDetalRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cobGuionArgumDetalList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cobGuionArgumDetalFrm', true);
}

function cobGuionArgumDetalLovInitComponents(){
	cobGuionArgumDetalLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cobGuionArgumDetalFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad









//Función que permite cargar los datos de un elemento de lov seleccionado
function cobGuionArgumDetalSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cobGuionArgumDetalFrm.' + campo, id);
	set('cobGuionArgumDetalFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cobGuionArgumDetalLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cobGuionArgumDetalLovReturnParameters.id = '';
	cobGuionArgumDetalLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cobGuionArgumDetalLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobGuionArgumDetalList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cobGuionArgumDetalList.codSeleccionados();
	var descripcion = cobGuionArgumDetalList.extraeDato(
		cobGuionArgumDetalList.codSeleccionados()[0], cobGuionArgumDetalChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cobGuionArgumDetalLovReturnParameters.id = codigo;
	cobGuionArgumDetalLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cobGuionArgumDetalCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cobGuionArgumDetalFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cobGuionArgumDetalFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cobGuionArgumDetalList", "CobGuionArgumDetalConectorTransactionQuery", 
		"result_ROWSET", parametros, "cobGuionArgumDetalPostQueryActions(datos);"]], "", "");	
}

function cobGuionArgumDetalCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cobGuionArgumDetalFrm.lastQueryToSession'));
	var i =0;
	set('cobGuionArgumDetalFrm.gacaOidGuioArguCabe', [paramsRequery.ij(i++)]);
	
	set('cobGuionArgumDetalFrm.arguOidArgu', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	cobGuionArgumDetalPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cobGuionArgumDetalCmdQuery(cobGuionArgumDetalPageCount);
}

function cobGuionArgumDetalFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cobGuionArgumDetalPageCount = 1;
	cobGuionArgumDetalCmdQuery(cobGuionArgumDetalPageCount);
}

function cobGuionArgumDetalPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobGuionArgumDetalLastQuery){
		cobGuionArgumDetalFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cobGuionArgumDetalPageCount--;
	cobGuionArgumDetalCmdQuery(cobGuionArgumDetalPageCount);
}

function cobGuionArgumDetalNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobGuionArgumDetalLastQuery){
		cobGuionArgumDetalFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cobGuionArgumDetalPageCount++;
	cobGuionArgumDetalCmdQuery(cobGuionArgumDetalPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cobGuionArgumDetalPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cobGuionArgumDetalListLayer', 'O');
		visibilidad('cobGuionArgumDetalListButtonsLayer', 'O');
		if(get('cobGuionArgumDetalFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cobGuionArgumDetalLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cobGuionArgumDetalViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cobGuionArgumDetalChoiceColumn) + "</A>",
			i, cobGuionArgumDetalChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cobGuionArgumDetalList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cobGuionArgumDetalTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cobGuionArgumDetalMorePagesFlag = true;
		cobGuionArgumDetalList.eliminar(mmgPageSize, 1);
	}else{
		cobGuionArgumDetalMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cobGuionArgumDetalFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cobGuionArgumDetalListLayer', 'V');
	visibilidad('cobGuionArgumDetalListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cobGuionArgumDetalList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cobGuionArgumDetalList.display();
	
	//Actualizamos el estado de los botones 
	if(cobGuionArgumDetalMorePagesFlag){
		set_estado_botonera('cobGuionArgumDetalPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cobGuionArgumDetalPaginationButtonBar',
			3,"inactivo");
	}
	if(cobGuionArgumDetalPageCount > 1){
		set_estado_botonera('cobGuionArgumDetalPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cobGuionArgumDetalPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cobGuionArgumDetalPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cobGuionArgumDetalPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cobGuionArgumDetalUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobGuionArgumDetalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cobGuionArgumDetalFrm.idSelection', cobGuionArgumDetalList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cobGuionArgumDetalFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cobGuionArgumDetalList.codSeleccionados()[0];
		parametros["previousAction"] = get('cobGuionArgumDetalFrm.accion');
		parametros["accion"] = get('cobGuionArgumDetalFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CobGuionArgumDetalLPStartUp', get('cobGuionArgumDetalFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cobGuionArgumDetalCmdRequery();
	}
}

function cobGuionArgumDetalRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobGuionArgumDetalList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cobGuionArgumDetalList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cobGuionArgumDetalFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cobGuionArgumDetalList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cobGuionArgumDetalTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cobGuionArgumDetalFrm.timestamp', timestamps);


	cobGuionArgumDetalFrm.oculto='S';
	envia('cobGuionArgumDetalFrm');
	cobGuionArgumDetalFrm.oculto='N';
}

function cobGuionArgumDetalViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobGuionArgumDetalList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cobGuionArgumDetalViewDetail(cobGuionArgumDetalList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cobGuionArgumDetalViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cobGuionArgumDetalFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CobGuionArgumDetalLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('cobGuionArgumDetalFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
		
	
	if(validacion){
		cobGuionArgumDetalFrm.oculto='S';
		envia('cobGuionArgumDetalFrm');
		cobGuionArgumDetalFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('cobGuionArgumDetalFrm.gacaOidGuioArguCabe').toString() == ''){
		set('cobGuionArgumDetalFrm.gacaOidGuioArguCabe', []);
		mmgResetCombosOnCascade('gacaOidGuioArguCabe', 'gacaOidGuioArguCabe', 'cobGuionArgumDetal');
		
	}
	if(get('cobGuionArgumDetalFrm.arguOidArgu').toString() == ''){
		set('cobGuionArgumDetalFrm.arguOidArgu', []);
		mmgResetCombosOnCascade('arguOidArgu', 'arguOidArgu', 'cobGuionArgumDetal');
		
	}
	if(get('cobGuionArgumDetalFrm.vaarOidValoArgu').toString() == ''){
		set('cobGuionArgumDetalFrm.vaarOidValoArgu_arguOidArgu', []);
		mmgResetCombosOnCascade('vaarOidValoArgu_arguOidArgu', 'vaarOidValoArgu', 'cobGuionArgumDetal');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cobGuionArgumDetalRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cobGuionArgumDetalFrm.accion');
	var origenTmp = get('cobGuionArgumDetalFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cobGuionArgumDetalBuildUpdateRecordString() != cobGuionArgumDetalTmpUpdateValues){
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
	document.all.cobGuionArgumDetalListLayer.style.display='none';
	document.all.cobGuionArgumDetalListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cobGuionArgumDetalListLayer.style.display='';
	document.all.cobGuionArgumDetalListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCobGuionArgumDetalGacaOidGuioArguCabe = get('cobGuionArgumDetalFrm.gacaOidGuioArguCabe')[0];
	jsCobGuionArgumDetalArguOidArgu = get('cobGuionArgumDetalFrm.arguOidArgu')[0];
	
	
	var parametros = "";
	parametros += jsCobGuionArgumDetalGacaOidGuioArguCabe + "|";
	parametros += jsCobGuionArgumDetalArguOidArgu + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cobGuionArgumDetalBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCobGuionArgumDetalGacaOidGuioArguCabe + "|";
	parametros += jsCobGuionArgumDetalArguOidArgu + "|";
	parametros += jsCobGuionArgumDetalNumOrdeArgu + "|";
	parametros += jsCobGuionArgumDetalIndActiAtriObse + "|";
	parametros += jsCobGuionArgumDetalValObse + "|";
	parametros += jsCobGuionArgumDetalVaarOidValoArgu + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobGuionArgumDetalFrm.accion'), 
		get('cobGuionArgumDetalFrm.origen'));
	
	jsCobGuionArgumDetalId = get('cobGuionArgumDetalFrm.id').toString();
	jsCobGuionArgumDetalGacaOidGuioArguCabe = get('cobGuionArgumDetalFrm.gacaOidGuioArguCabe')[0];
	jsCobGuionArgumDetalArguOidArgu = get('cobGuionArgumDetalFrm.arguOidArgu')[0];
	jsCobGuionArgumDetalNumOrdeArgu = get('cobGuionArgumDetalFrm.numOrdeArgu').toString();
	jsCobGuionArgumDetalIndActiAtriObse = get('cobGuionArgumDetalFrm.indActiAtriObse');
	jsCobGuionArgumDetalValObse = get('cobGuionArgumDetalFrm.valObse').toString();
	jsCobGuionArgumDetalVaarOidValoArgu = get('cobGuionArgumDetalFrm.vaarOidValoArgu')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobGuionArgumDetalFrm.accion'), 
		get('cobGuionArgumDetalFrm.origen'));


	set('cobGuionArgumDetalFrm.id', jsCobGuionArgumDetalId);
	set('cobGuionArgumDetalFrm.gacaOidGuioArguCabe', [jsCobGuionArgumDetalGacaOidGuioArguCabe]);
	set('cobGuionArgumDetalFrm.arguOidArgu', [jsCobGuionArgumDetalArguOidArgu]);
	set('cobGuionArgumDetalFrm.numOrdeArgu', jsCobGuionArgumDetalNumOrdeArgu);
	set('cobGuionArgumDetalFrm.indActiAtriObse', jsCobGuionArgumDetalIndActiAtriObse);
	set('cobGuionArgumDetalFrm.valObse', jsCobGuionArgumDetalValObse);
	set('cobGuionArgumDetalFrm.vaarOidValoArgu', [jsCobGuionArgumDetalVaarOidValoArgu]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCobGuionArgumDetalGacaOidGuioArguCabe = '';
	jsCobGuionArgumDetalArguOidArgu = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cobGuionArgumDetalFrm.errCodigo', errorCode);
	set('cobGuionArgumDetalFrm.errDescripcion', description);
	set('cobGuionArgumDetalFrm.errSeverity', severity);
	fMostrarMensajeError();
}
