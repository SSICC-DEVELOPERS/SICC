

/*
    INDRA/CAR/mmg
    $Id: incparticoncucabec.js,v 1.1 2009/12/03 19:01:38 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsIncPartiConcuCabecId = "";
var jsIncPartiConcuCabecValGrupClie = "";
var jsIncPartiConcuCabecPaisOidPais = "";
var jsIncPartiConcuCabecDiriOidDiri = "";
var jsIncPartiConcuCabecDesDesc = "";

//Variables de paginacion, 
var incPartiConcuCabecPageCount = 1;

//Varible de columna que representa el campo de choice
var incPartiConcuCabecChoiceColumn = 3;

//Flag de siguiente pagina;
var incPartiConcuCabecMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var incPartiConcuCabecTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 189;
var sizeFormView = 171;
var sizeFormUpdate = 171;

//Ultima busqueda realizada
var incPartiConcuCabecLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();

	//splatas - 13/07/2006 - DBLG500000885
	//accionesFoco.cargar([[2,'focaliza("incPartiConcuCabecFrm.valGrupClie");','focaliza("incPartiConcuCabecFrm.valGrupClie");','focaliza("incPartiConcuCabecFrm.valGrupClie");','focaliza("incPartiConcuCabecFrm.valGrupClie");','focaliza("incPartiConcuCabecFrm.valGrupClie");','focaliza("incPartiConcuCabecFrm.valGrupClie");'],[3,'','','','','',''],[4,'focalizaComboDependence("incPartiConcuCabec","diriOidDiri", false);','focalizaComboDependence("incPartiConcuCabec","diriOidDiri", false);','focalizaComboDependence("incPartiConcuCabec","diriOidDiri", false);','focalizaComboDependence("incPartiConcuCabec","diriOidDiri", true);','focalizaComboDependence("incPartiConcuCabec","diriOidDiri", true);','focalizaComboDependence("incPartiConcuCabec","diriOidDiri", true);'],[5,'focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");']]);
accionesFoco.cargar([[3,'','','','','',''],[4,'focalizaComboDependence("incPartiConcuCabec","diriOidDiri", false);','focalizaComboDependence("incPartiConcuCabec","diriOidDiri", false);','focalizaComboDependence("incPartiConcuCabec","diriOidDiri", false);','focalizaComboDependence("incPartiConcuCabec","diriOidDiri", true);','focalizaComboDependence("incPartiConcuCabec","diriOidDiri", true);','focalizaComboDependence("incPartiConcuCabec","diriOidDiri", true);'],[5,'focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'','','','','',''],[5,'focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");','focaliza("incPartiConcuCabecFrm.desDesc");']]);

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
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);
var diriOidDiriDependeceMap = new Vector();
diriOidDiriDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
diriOidDiriDependeceMap.agregar(['diriOidDiri', padresTmp, '', 'IncDirig']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
incPartiConcuCabecLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var incPartiConcuCabecTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function incPartiConcuCabecInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('incPartiConcuCabecFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('incPartiConcuCabecFrm.accion')){
		case "query": incPartiConcuCabecQueryInitComponents(); break;
		case "view": incPartiConcuCabecViewInitComponents(); break;
		case "create": incPartiConcuCabecCreateInitComponents(); break;
		case "update": incPartiConcuCabecUpdateInitComponents(); break;
		case "remove": incPartiConcuCabecRemoveInitComponents(); break;
		case "lov": incPartiConcuCabecLovInitComponents(); break;
	}
	//alert('accion :' + get('incPartiConcuCabecFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('incPartiConcuCabecFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('incPartiConcuCabec')) incPartiConcuCabecCmdRequery();
}

function incPartiConcuCabecQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('incPartiConcuCabecFrm', true);	
}

function incPartiConcuCabecViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('incPartiConcuCabecFrm', true);
}

function incPartiConcuCabecCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('incPartiConcuCabecFrm.diriOidDiri','S', GestionarMensaje('IncPartiConcuCabec.diriOidDiri.requiered.message'));
	
	setMV('incPartiConcuCabecFrm.desDesc','S', GestionarMensaje('IncPartiConcuCabec.desDesc.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('incPartiConcuCabecFrm', true);
}

function incPartiConcuCabecUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('incPartiConcuCabecFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		incPartiConcuCabecTmpUpdateValues = incPartiConcuCabecBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('incPartiConcuCabecFrm.diriOidDiri','S', GestionarMensaje('IncPartiConcuCabec.diriOidDiri.requiered.message'));
		setMV('incPartiConcuCabecFrm.desDesc','S', GestionarMensaje('IncPartiConcuCabec.desDesc.requiered.message'));
		
			focusFirstFieldModify('incPartiConcuCabecFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('incPartiConcuCabecFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('incPartiConcuCabecFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function incPartiConcuCabecRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	incPartiConcuCabecList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('incPartiConcuCabecFrm', true);
}

function incPartiConcuCabecLovInitComponents(){
	incPartiConcuCabecLovReturnParameters = window.dialogArguments;
	
	focusFirstField('incPartiConcuCabecFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function incPartiConcuCabecSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('incPartiConcuCabecFrm.' + campo, id);
	set('incPartiConcuCabecFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function incPartiConcuCabecLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	incPartiConcuCabecLovReturnParameters.id = '';
	incPartiConcuCabecLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function incPartiConcuCabecLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(incPartiConcuCabecList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = incPartiConcuCabecList.codSeleccionados();
	var descripcion = incPartiConcuCabecList.extraeDato(
		incPartiConcuCabecList.codSeleccionados()[0], incPartiConcuCabecChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	incPartiConcuCabecLovReturnParameters.id = codigo;
	incPartiConcuCabecLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function incPartiConcuCabecCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('incPartiConcuCabecFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('incPartiConcuCabecFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "incPartiConcuCabecList", "IncPartiConcuCabecConectorTransactionQuery", 
		"result_ROWSET", parametros, "incPartiConcuCabecPostQueryActions(datos);"]], "", "");	
}

function incPartiConcuCabecCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('incPartiConcuCabecFrm.lastQueryToSession'));
	var i =0;
	set('incPartiConcuCabecFrm.valGrupClie', paramsRequery.ij(i++));
	
	set('incPartiConcuCabecFrm.diriOidDiri', [paramsRequery.ij(i++)]);
	
	set('incPartiConcuCabecFrm.desDesc', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	incPartiConcuCabecPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	incPartiConcuCabecCmdQuery(incPartiConcuCabecPageCount);
}

function incPartiConcuCabecFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	incPartiConcuCabecPageCount = 1;
	incPartiConcuCabecCmdQuery(incPartiConcuCabecPageCount);
}

function incPartiConcuCabecPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != incPartiConcuCabecLastQuery){
		incPartiConcuCabecFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	incPartiConcuCabecPageCount--;
	incPartiConcuCabecCmdQuery(incPartiConcuCabecPageCount);
}

function incPartiConcuCabecNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != incPartiConcuCabecLastQuery){
		incPartiConcuCabecFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	incPartiConcuCabecPageCount++;
	incPartiConcuCabecCmdQuery(incPartiConcuCabecPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function incPartiConcuCabecPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('incPartiConcuCabecListLayer', 'O');
		visibilidad('incPartiConcuCabecListButtonsLayer', 'O');
		if(get('incPartiConcuCabecFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	incPartiConcuCabecLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:incPartiConcuCabecViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, incPartiConcuCabecChoiceColumn) + "</A>",
			i, incPartiConcuCabecChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	incPartiConcuCabecList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	incPartiConcuCabecTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		incPartiConcuCabecMorePagesFlag = true;
		incPartiConcuCabecList.eliminar(mmgPageSize, 1);
	}else{
		incPartiConcuCabecMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('incPartiConcuCabecFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('incPartiConcuCabecListLayer', 'V');
	visibilidad('incPartiConcuCabecListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('incPartiConcuCabecList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	incPartiConcuCabecList.display();
	
	//Actualizamos el estado de los botones 
	if(incPartiConcuCabecMorePagesFlag){
		set_estado_botonera('incPartiConcuCabecPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('incPartiConcuCabecPaginationButtonBar',
			3,"inactivo");
	}
	if(incPartiConcuCabecPageCount > 1){
		set_estado_botonera('incPartiConcuCabecPaginationButtonBar',
			2,"activo");
		set_estado_botonera('incPartiConcuCabecPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('incPartiConcuCabecPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('incPartiConcuCabecPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function incPartiConcuCabecUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(incPartiConcuCabecList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('incPartiConcuCabecFrm.idSelection', incPartiConcuCabecList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('incPartiConcuCabecFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = incPartiConcuCabecList.codSeleccionados()[0];
		parametros["previousAction"] = get('incPartiConcuCabecFrm.accion');
		parametros["accion"] = get('incPartiConcuCabecFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('IncPartiConcuCabecLPStartUp', get('incPartiConcuCabecFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) incPartiConcuCabecCmdRequery();
	}
}

function incPartiConcuCabecRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(incPartiConcuCabecList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = incPartiConcuCabecList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('incPartiConcuCabecFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(incPartiConcuCabecList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += incPartiConcuCabecTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('incPartiConcuCabecFrm.timestamp', timestamps);


	incPartiConcuCabecFrm.oculto='S';
	envia('incPartiConcuCabecFrm');
	incPartiConcuCabecFrm.oculto='N';
}

function incPartiConcuCabecViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(incPartiConcuCabecList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	incPartiConcuCabecViewDetail(incPartiConcuCabecList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function incPartiConcuCabecViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('incPartiConcuCabecFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('IncPartiConcuCabecLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('incPartiConcuCabecFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		incPartiConcuCabecFrm.oculto='S';
		envia('incPartiConcuCabecFrm');
		incPartiConcuCabecFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('incPartiConcuCabecFrm.paisOidPais').toString() == ''){
		set('incPartiConcuCabecFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'incPartiConcuCabec');
		
	}
	if(get('incPartiConcuCabecFrm.diriOidDiri').toString() == ''){
		set('incPartiConcuCabecFrm.diriOidDiri', []);
		mmgResetCombosOnCascade('diriOidDiri', 'diriOidDiri', 'incPartiConcuCabec');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	incPartiConcuCabecRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('incPartiConcuCabecFrm.accion');
	var origenTmp = get('incPartiConcuCabecFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(incPartiConcuCabecBuildUpdateRecordString() != incPartiConcuCabecTmpUpdateValues){
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
	document.all.incPartiConcuCabecListLayer.style.display='none';
	document.all.incPartiConcuCabecListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.incPartiConcuCabecListLayer.style.display='';
	document.all.incPartiConcuCabecListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsIncPartiConcuCabecValGrupClie = get('incPartiConcuCabecFrm.valGrupClie').toString();
	jsIncPartiConcuCabecDiriOidDiri = get('incPartiConcuCabecFrm.diriOidDiri')[0];
	jsIncPartiConcuCabecDesDesc = get('incPartiConcuCabecFrm.desDesc').toString();
	
	
	var parametros = "";
	parametros += jsIncPartiConcuCabecValGrupClie + "|";
	parametros += jsIncPartiConcuCabecDiriOidDiri + "|";
	parametros += jsIncPartiConcuCabecDesDesc + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function incPartiConcuCabecBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsIncPartiConcuCabecValGrupClie + "|";
	parametros += jsIncPartiConcuCabecDiriOidDiri + "|";
	parametros += jsIncPartiConcuCabecDesDesc + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('incPartiConcuCabecFrm.accion'), 
		get('incPartiConcuCabecFrm.origen'));
	
	jsIncPartiConcuCabecId = get('incPartiConcuCabecFrm.id').toString();
	jsIncPartiConcuCabecValGrupClie = get('incPartiConcuCabecFrm.valGrupClie').toString();
	jsIncPartiConcuCabecPaisOidPais = get('incPartiConcuCabecFrm.paisOidPais')[0];
	jsIncPartiConcuCabecDiriOidDiri = get('incPartiConcuCabecFrm.diriOidDiri')[0];
	jsIncPartiConcuCabecDesDesc = get('incPartiConcuCabecFrm.desDesc').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('incPartiConcuCabecFrm.accion'), 
		get('incPartiConcuCabecFrm.origen'));


	set('incPartiConcuCabecFrm.id', jsIncPartiConcuCabecId);
	set('incPartiConcuCabecFrm.valGrupClie', jsIncPartiConcuCabecValGrupClie);
	set('incPartiConcuCabecFrm.paisOidPais', [jsIncPartiConcuCabecPaisOidPais]);
	set('incPartiConcuCabecFrm.diriOidDiri', [jsIncPartiConcuCabecDiriOidDiri]);
	set('incPartiConcuCabecFrm.desDesc', jsIncPartiConcuCabecDesDesc);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsIncPartiConcuCabecValGrupClie = '';
	jsIncPartiConcuCabecDiriOidDiri = '';
	jsIncPartiConcuCabecDesDesc = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('incPartiConcuCabecFrm.errCodigo', errorCode);
	set('incPartiConcuCabecFrm.errDescripcion', description);
	set('incPartiConcuCabecFrm.errSeverity', severity);
	fMostrarMensajeError();
}
