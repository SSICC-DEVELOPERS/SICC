

/*
    INDRA/CAR/mmg
    $Id: intaccesbuzonivrzn.js,v 1.1 2009/12/03 19:02:03 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsIntAccesBuzonIvrznId = "";
var jsIntAccesBuzonIvrznCodAcceBuzoIvrz = "";
var jsIntAccesBuzonIvrznZzonOidZona = "";

//Variables de paginacion, 
var intAccesBuzonIvrznPageCount = 1;

//Varible de columna que representa el campo de choice
var intAccesBuzonIvrznChoiceColumn = 2;

//Flag de siguiente pagina;
var intAccesBuzonIvrznMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var intAccesBuzonIvrznTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 147;
var sizeFormView = 129;
var sizeFormUpdate = 129;

//Ultima busqueda realizada
var intAccesBuzonIvrznLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("intAccesBuzonIvrznFrm.codAcceBuzoIvrz");','focaliza("intAccesBuzonIvrznFrm.codAcceBuzoIvrz");','focaliza("intAccesBuzonIvrznFrm.codAcceBuzoIvrz");','focaliza("intAccesBuzonIvrznFrm.codAcceBuzoIvrz");','focaliza("intAccesBuzonIvrznFrm.codAcceBuzoIvrz");','focaliza("intAccesBuzonIvrznFrm.codAcceBuzoIvrz");'],[3,'focalizaComboDependence("intAccesBuzonIvrzn","zzonOidZona", false);','focalizaComboDependence("intAccesBuzonIvrzn","zzonOidZona", false);','focalizaComboDependence("intAccesBuzonIvrzn","zzonOidZona", false);','focalizaComboDependence("intAccesBuzonIvrzn","zzonOidZona", true);','focalizaComboDependence("intAccesBuzonIvrzn","zzonOidZona", true);','focalizaComboDependence("intAccesBuzonIvrzn","zzonOidZona", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focalizaComboDependence("intAccesBuzonIvrzn","zzonOidZona", false);','focalizaComboDependence("intAccesBuzonIvrzn","zzonOidZona", false);','focalizaComboDependence("intAccesBuzonIvrzn","zzonOidZona", false);','focalizaComboDependence("intAccesBuzonIvrzn","zzonOidZona", true);','focalizaComboDependence("intAccesBuzonIvrzn","zzonOidZona", true);','focalizaComboDependence("intAccesBuzonIvrzn","zzonOidZona", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var zzonOidZonaDependeceMap = new Vector();
zzonOidZonaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zzonOidZonaDependeceMap.agregar(['zzonOidZona_canaOidCana', padresTmp, 'zzonOidZona', 'SegCanalView']);
padresTmp =  new Vector();
padresTmp.cargar([])
zzonOidZonaDependeceMap.agregar(['zzonOidZona_marcOidMarc', padresTmp, 'zzonOidZona', 'SegMarca']);
padresTmp =  new Vector();
padresTmp.cargar(['zzonOidZona_marcOidMarc','zzonOidZona_canaOidCana'])
zzonOidZonaDependeceMap.agregar(['zzonOidZona', padresTmp, '', 'ZonZonaView2']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
intAccesBuzonIvrznLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var intAccesBuzonIvrznTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function intAccesBuzonIvrznInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('intAccesBuzonIvrznFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('intAccesBuzonIvrznFrm.accion')){
		case "query": intAccesBuzonIvrznQueryInitComponents(); break;
		case "view": intAccesBuzonIvrznViewInitComponents(); break;
		case "create": intAccesBuzonIvrznCreateInitComponents(); break;
		case "update": intAccesBuzonIvrznUpdateInitComponents(); break;
		case "remove": intAccesBuzonIvrznRemoveInitComponents(); break;
		case "lov": intAccesBuzonIvrznLovInitComponents(); break;
	}
	//alert('accion :' + get('intAccesBuzonIvrznFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('intAccesBuzonIvrznFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('intAccesBuzonIvrzn')) intAccesBuzonIvrznCmdRequery();
}

function intAccesBuzonIvrznQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('intAccesBuzonIvrznFrm', true);	
}

function intAccesBuzonIvrznViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('intAccesBuzonIvrznFrm', true);
}

function intAccesBuzonIvrznCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('intAccesBuzonIvrznFrm.codAcceBuzoIvrz','S', GestionarMensaje('IntAccesBuzonIvrzn.codAcceBuzoIvrz.requiered.message'));
	
	setMV('intAccesBuzonIvrznFrm.zzonOidZona','S', GestionarMensaje('IntAccesBuzonIvrzn.zzonOidZona.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('intAccesBuzonIvrznFrm', true);
}

function intAccesBuzonIvrznUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('intAccesBuzonIvrznFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		intAccesBuzonIvrznTmpUpdateValues = intAccesBuzonIvrznBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('intAccesBuzonIvrznFrm.codAcceBuzoIvrz','S', GestionarMensaje('IntAccesBuzonIvrzn.codAcceBuzoIvrz.requiered.message'));
		setMV('intAccesBuzonIvrznFrm.zzonOidZona','S', GestionarMensaje('IntAccesBuzonIvrzn.zzonOidZona.requiered.message'));
		
			focusFirstFieldModify('intAccesBuzonIvrznFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('intAccesBuzonIvrznFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('intAccesBuzonIvrznFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function intAccesBuzonIvrznRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	intAccesBuzonIvrznList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('intAccesBuzonIvrznFrm', true);
}

function intAccesBuzonIvrznLovInitComponents(){
	intAccesBuzonIvrznLovReturnParameters = window.dialogArguments;
	
	focusFirstField('intAccesBuzonIvrznFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad





//Función que permite cargar los datos de un elemento de lov seleccionado
function intAccesBuzonIvrznSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('intAccesBuzonIvrznFrm.' + campo, id);
	set('intAccesBuzonIvrznFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function intAccesBuzonIvrznLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	intAccesBuzonIvrznLovReturnParameters.id = '';
	intAccesBuzonIvrznLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function intAccesBuzonIvrznLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(intAccesBuzonIvrznList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = intAccesBuzonIvrznList.codSeleccionados();
	var descripcion = intAccesBuzonIvrznList.extraeDato(
		intAccesBuzonIvrznList.codSeleccionados()[0], intAccesBuzonIvrznChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	intAccesBuzonIvrznLovReturnParameters.id = codigo;
	intAccesBuzonIvrznLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function intAccesBuzonIvrznCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('intAccesBuzonIvrznFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('intAccesBuzonIvrznFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "intAccesBuzonIvrznList", "IntAccesBuzonIvrznConectorTransactionQuery", 
		"result_ROWSET", parametros, "intAccesBuzonIvrznPostQueryActions(datos);"]], "", "");	
}

function intAccesBuzonIvrznCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('intAccesBuzonIvrznFrm.lastQueryToSession'));
	var i =0;
	set('intAccesBuzonIvrznFrm.codAcceBuzoIvrz', paramsRequery.ij(i++));
	
	set('intAccesBuzonIvrznFrm.zzonOidZona', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	intAccesBuzonIvrznPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	intAccesBuzonIvrznCmdQuery(intAccesBuzonIvrznPageCount);
}

function intAccesBuzonIvrznFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	intAccesBuzonIvrznPageCount = 1;
	intAccesBuzonIvrznCmdQuery(intAccesBuzonIvrznPageCount);
}

function intAccesBuzonIvrznPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != intAccesBuzonIvrznLastQuery){
		intAccesBuzonIvrznFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	intAccesBuzonIvrznPageCount--;
	intAccesBuzonIvrznCmdQuery(intAccesBuzonIvrznPageCount);
}

function intAccesBuzonIvrznNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != intAccesBuzonIvrznLastQuery){
		intAccesBuzonIvrznFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	intAccesBuzonIvrznPageCount++;
	intAccesBuzonIvrznCmdQuery(intAccesBuzonIvrznPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function intAccesBuzonIvrznPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('intAccesBuzonIvrznListLayer', 'O');
		visibilidad('intAccesBuzonIvrznListButtonsLayer', 'O');
		if(get('intAccesBuzonIvrznFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	intAccesBuzonIvrznLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:intAccesBuzonIvrznViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, intAccesBuzonIvrznChoiceColumn) + "</A>",
			i, intAccesBuzonIvrznChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	intAccesBuzonIvrznList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	intAccesBuzonIvrznTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		intAccesBuzonIvrznMorePagesFlag = true;
		intAccesBuzonIvrznList.eliminar(mmgPageSize, 1);
	}else{
		intAccesBuzonIvrznMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('intAccesBuzonIvrznFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('intAccesBuzonIvrznListLayer', 'V');
	visibilidad('intAccesBuzonIvrznListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('intAccesBuzonIvrznList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	intAccesBuzonIvrznList.display();
	
	//Actualizamos el estado de los botones 
	if(intAccesBuzonIvrznMorePagesFlag){
		set_estado_botonera('intAccesBuzonIvrznPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('intAccesBuzonIvrznPaginationButtonBar',
			3,"inactivo");
	}
	if(intAccesBuzonIvrznPageCount > 1){
		set_estado_botonera('intAccesBuzonIvrznPaginationButtonBar',
			2,"activo");
		set_estado_botonera('intAccesBuzonIvrznPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('intAccesBuzonIvrznPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('intAccesBuzonIvrznPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function intAccesBuzonIvrznUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(intAccesBuzonIvrznList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('intAccesBuzonIvrznFrm.idSelection', intAccesBuzonIvrznList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('intAccesBuzonIvrznFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = intAccesBuzonIvrznList.codSeleccionados()[0];
		parametros["previousAction"] = get('intAccesBuzonIvrznFrm.accion');
		parametros["accion"] = get('intAccesBuzonIvrznFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('IntAccesBuzonIvrznLPStartUp', get('intAccesBuzonIvrznFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) intAccesBuzonIvrznCmdRequery();
	}
}

function intAccesBuzonIvrznRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(intAccesBuzonIvrznList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = intAccesBuzonIvrznList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('intAccesBuzonIvrznFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(intAccesBuzonIvrznList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += intAccesBuzonIvrznTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('intAccesBuzonIvrznFrm.timestamp', timestamps);


	intAccesBuzonIvrznFrm.oculto='S';
	envia('intAccesBuzonIvrznFrm');
	intAccesBuzonIvrznFrm.oculto='N';
}

function intAccesBuzonIvrznViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(intAccesBuzonIvrznList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	intAccesBuzonIvrznViewDetail(intAccesBuzonIvrznList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function intAccesBuzonIvrznViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('intAccesBuzonIvrznFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('IntAccesBuzonIvrznLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('intAccesBuzonIvrznFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
		
	
	if(validacion){
		intAccesBuzonIvrznFrm.oculto='S';
		envia('intAccesBuzonIvrznFrm');
		intAccesBuzonIvrznFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('intAccesBuzonIvrznFrm.zzonOidZona').toString() == ''){
		set('intAccesBuzonIvrznFrm.zzonOidZona_canaOidCana', []);
		mmgResetCombosOnCascade('zzonOidZona_canaOidCana', 'zzonOidZona', 'intAccesBuzonIvrzn');
		set('intAccesBuzonIvrznFrm.zzonOidZona_marcOidMarc', []);
		mmgResetCombosOnCascade('zzonOidZona_marcOidMarc', 'zzonOidZona', 'intAccesBuzonIvrzn');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	intAccesBuzonIvrznRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('intAccesBuzonIvrznFrm.accion');
	var origenTmp = get('intAccesBuzonIvrznFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(intAccesBuzonIvrznBuildUpdateRecordString() != intAccesBuzonIvrznTmpUpdateValues){
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
	document.all.intAccesBuzonIvrznListLayer.style.display='none';
	document.all.intAccesBuzonIvrznListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.intAccesBuzonIvrznListLayer.style.display='';
	document.all.intAccesBuzonIvrznListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsIntAccesBuzonIvrznCodAcceBuzoIvrz = get('intAccesBuzonIvrznFrm.codAcceBuzoIvrz').toString();
	jsIntAccesBuzonIvrznZzonOidZona = get('intAccesBuzonIvrznFrm.zzonOidZona')[0];
	
	
	var parametros = "";
	parametros += jsIntAccesBuzonIvrznCodAcceBuzoIvrz + "|";
	parametros += jsIntAccesBuzonIvrznZzonOidZona + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function intAccesBuzonIvrznBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsIntAccesBuzonIvrznCodAcceBuzoIvrz + "|";
	parametros += jsIntAccesBuzonIvrznZzonOidZona + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('intAccesBuzonIvrznFrm.accion'), 
		get('intAccesBuzonIvrznFrm.origen'));
	
	jsIntAccesBuzonIvrznId = get('intAccesBuzonIvrznFrm.id').toString();
	jsIntAccesBuzonIvrznCodAcceBuzoIvrz = get('intAccesBuzonIvrznFrm.codAcceBuzoIvrz').toString();
	jsIntAccesBuzonIvrznZzonOidZona = get('intAccesBuzonIvrznFrm.zzonOidZona')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('intAccesBuzonIvrznFrm.accion'), 
		get('intAccesBuzonIvrznFrm.origen'));


	set('intAccesBuzonIvrznFrm.id', jsIntAccesBuzonIvrznId);
	set('intAccesBuzonIvrznFrm.codAcceBuzoIvrz', jsIntAccesBuzonIvrznCodAcceBuzoIvrz);
	set('intAccesBuzonIvrznFrm.zzonOidZona', [jsIntAccesBuzonIvrznZzonOidZona]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsIntAccesBuzonIvrznCodAcceBuzoIvrz = '';
	jsIntAccesBuzonIvrznZzonOidZona = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('intAccesBuzonIvrznFrm.errCodigo', errorCode);
	set('intAccesBuzonIvrznFrm.errDescripcion', description);
	set('intAccesBuzonIvrznFrm.errSeverity', severity);
	fMostrarMensajeError();
}
