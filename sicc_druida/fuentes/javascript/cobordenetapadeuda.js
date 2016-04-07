

/*
    INDRA/CAR/mmg
    $Id: cobordenetapadeuda.js,v 1.1 2009/12/03 19:02:12 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCobOrdenEtapaDeudaId = "";
var jsCobOrdenEtapaDeudaCodOrdeEtapDeud = "";
var jsCobOrdenEtapaDeudaDescripcion = "";

//Variables de paginacion, 
var cobOrdenEtapaDeudaPageCount = 1;

//Varible de columna que representa el campo de choice
var cobOrdenEtapaDeudaChoiceColumn = 1;

//Flag de siguiente pagina;
var cobOrdenEtapaDeudaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cobOrdenEtapaDeudaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 129;
var sizeFormUpdate = 129;

//Ultima busqueda realizada
var cobOrdenEtapaDeudaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("cobOrdenEtapaDeudaFrm.codOrdeEtapDeud");','focaliza("cobOrdenEtapaDeudaFrm.codOrdeEtapDeud");','focaliza("cobOrdenEtapaDeudaFrm.codOrdeEtapDeud");','focaliza("cobOrdenEtapaDeudaFrm.codOrdeEtapDeud");','focaliza("cobOrdenEtapaDeudaFrm.codOrdeEtapDeud");','focaliza("cobOrdenEtapaDeudaFrm.codOrdeEtapDeud");'],[3,'','focaliza("cobOrdenEtapaDeudaFrm.Descripcion");','focaliza("cobOrdenEtapaDeudaFrm.Descripcion");','','focaliza("cobOrdenEtapaDeudaFrm.Descripcion");','focaliza("cobOrdenEtapaDeudaFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("cobOrdenEtapaDeudaFrm.codOrdeEtapDeud");','focaliza("cobOrdenEtapaDeudaFrm.codOrdeEtapDeud");','focaliza("cobOrdenEtapaDeudaFrm.codOrdeEtapDeud");','focaliza("cobOrdenEtapaDeudaFrm.codOrdeEtapDeud");','focaliza("cobOrdenEtapaDeudaFrm.codOrdeEtapDeud");','focaliza("cobOrdenEtapaDeudaFrm.codOrdeEtapDeud");'],[3,'','focaliza("cobOrdenEtapaDeudaFrm.Descripcion");','focaliza("cobOrdenEtapaDeudaFrm.Descripcion");','','focaliza("cobOrdenEtapaDeudaFrm.Descripcion");','focaliza("cobOrdenEtapaDeudaFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cobOrdenEtapaDeudaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cobOrdenEtapaDeudaTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function cobOrdenEtapaDeudaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cobOrdenEtapaDeudaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cobOrdenEtapaDeudaFrm.accion')){
		case "query": cobOrdenEtapaDeudaQueryInitComponents(); break;
		case "view": cobOrdenEtapaDeudaViewInitComponents(); break;
		case "create": cobOrdenEtapaDeudaCreateInitComponents(); break;
		case "update": cobOrdenEtapaDeudaUpdateInitComponents(); break;
		case "remove": cobOrdenEtapaDeudaRemoveInitComponents(); break;
		case "lov": cobOrdenEtapaDeudaLovInitComponents(); break;
	}
	//alert('accion :' + get('cobOrdenEtapaDeudaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('cobOrdenEtapaDeudaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cobOrdenEtapaDeuda')) cobOrdenEtapaDeudaCmdRequery();
}

function cobOrdenEtapaDeudaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	focusFirstField('cobOrdenEtapaDeudaFrm', true);	
}

function cobOrdenEtapaDeudaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('cobOrdenEtapaDeudaFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('cobOrdenEtapaDeudaFrm', true);
}

function cobOrdenEtapaDeudaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cobOrdenEtapaDeudaFrm.codOrdeEtapDeud','S', GestionarMensaje('CobOrdenEtapaDeuda.codOrdeEtapDeud.requiered.message'));
	
	setMV('cobOrdenEtapaDeudaFrm.Descripcion','S', GestionarMensaje('CobOrdenEtapaDeuda.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('cobOrdenEtapaDeudaFrm', true);
}

function cobOrdenEtapaDeudaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cobOrdenEtapaDeudaFrm.origen') == "pagina"){
		loadLocalizationWidget('cobOrdenEtapaDeudaFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		cobOrdenEtapaDeudaTmpUpdateValues = cobOrdenEtapaDeudaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cobOrdenEtapaDeudaFrm.codOrdeEtapDeud','S', GestionarMensaje('CobOrdenEtapaDeuda.codOrdeEtapDeud.requiered.message'));
		setMV('cobOrdenEtapaDeudaFrm.Descripcion','S', GestionarMensaje('CobOrdenEtapaDeuda.Descripcion.requiered.message'));
		
			focusFirstFieldModify('cobOrdenEtapaDeudaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		focusFirstField('cobOrdenEtapaDeudaFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cobOrdenEtapaDeudaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cobOrdenEtapaDeudaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cobOrdenEtapaDeudaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('cobOrdenEtapaDeudaFrm', true);
}

function cobOrdenEtapaDeudaLovInitComponents(){
	cobOrdenEtapaDeudaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('cobOrdenEtapaDeudaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad





//Función que permite cargar los datos de un elemento de lov seleccionado
function cobOrdenEtapaDeudaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cobOrdenEtapaDeudaFrm.' + campo, id);
	set('cobOrdenEtapaDeudaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cobOrdenEtapaDeudaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cobOrdenEtapaDeudaLovReturnParameters.id = '';
	cobOrdenEtapaDeudaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cobOrdenEtapaDeudaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobOrdenEtapaDeudaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cobOrdenEtapaDeudaList.codSeleccionados();
	var descripcion = cobOrdenEtapaDeudaList.extraeDato(
		cobOrdenEtapaDeudaList.codSeleccionados()[0], cobOrdenEtapaDeudaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cobOrdenEtapaDeudaLovReturnParameters.id = codigo;
	cobOrdenEtapaDeudaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cobOrdenEtapaDeudaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cobOrdenEtapaDeudaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cobOrdenEtapaDeudaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cobOrdenEtapaDeudaList", "CobOrdenEtapaDeudaConectorTransactionQuery", 
		"result_ROWSET", parametros, "cobOrdenEtapaDeudaPostQueryActions(datos);"]], "", "");	
}

function cobOrdenEtapaDeudaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cobOrdenEtapaDeudaFrm.lastQueryToSession'));
	var i =0;
	set('cobOrdenEtapaDeudaFrm.codOrdeEtapDeud', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	cobOrdenEtapaDeudaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cobOrdenEtapaDeudaCmdQuery(cobOrdenEtapaDeudaPageCount);
}

function cobOrdenEtapaDeudaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cobOrdenEtapaDeudaPageCount = 1;
	cobOrdenEtapaDeudaCmdQuery(cobOrdenEtapaDeudaPageCount);
}

function cobOrdenEtapaDeudaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobOrdenEtapaDeudaLastQuery){
		cobOrdenEtapaDeudaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cobOrdenEtapaDeudaPageCount--;
	cobOrdenEtapaDeudaCmdQuery(cobOrdenEtapaDeudaPageCount);
}

function cobOrdenEtapaDeudaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cobOrdenEtapaDeudaLastQuery){
		cobOrdenEtapaDeudaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cobOrdenEtapaDeudaPageCount++;
	cobOrdenEtapaDeudaCmdQuery(cobOrdenEtapaDeudaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cobOrdenEtapaDeudaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cobOrdenEtapaDeudaListLayer', 'O');
		visibilidad('cobOrdenEtapaDeudaListButtonsLayer', 'O');
		if(get('cobOrdenEtapaDeudaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cobOrdenEtapaDeudaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:cobOrdenEtapaDeudaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cobOrdenEtapaDeudaChoiceColumn) + "</A>",
			i, cobOrdenEtapaDeudaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cobOrdenEtapaDeudaList.setDatos(datosTmp.filtrar([0,1],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cobOrdenEtapaDeudaTimeStamps = datosTmp.filtrar([2],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cobOrdenEtapaDeudaMorePagesFlag = true;
		cobOrdenEtapaDeudaList.eliminar(mmgPageSize, 1);
	}else{
		cobOrdenEtapaDeudaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cobOrdenEtapaDeudaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cobOrdenEtapaDeudaListLayer', 'V');
	visibilidad('cobOrdenEtapaDeudaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cobOrdenEtapaDeudaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cobOrdenEtapaDeudaList.display();
	
	//Actualizamos el estado de los botones 
	if(cobOrdenEtapaDeudaMorePagesFlag){
		set_estado_botonera('cobOrdenEtapaDeudaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cobOrdenEtapaDeudaPaginationButtonBar',
			3,"inactivo");
	}
	if(cobOrdenEtapaDeudaPageCount > 1){
		set_estado_botonera('cobOrdenEtapaDeudaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cobOrdenEtapaDeudaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cobOrdenEtapaDeudaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cobOrdenEtapaDeudaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cobOrdenEtapaDeudaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobOrdenEtapaDeudaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cobOrdenEtapaDeudaFrm.idSelection', cobOrdenEtapaDeudaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cobOrdenEtapaDeudaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = cobOrdenEtapaDeudaList.codSeleccionados()[0];
		parametros["previousAction"] = get('cobOrdenEtapaDeudaFrm.accion');
		parametros["accion"] = get('cobOrdenEtapaDeudaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('CobOrdenEtapaDeudaLPStartUp', get('cobOrdenEtapaDeudaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) cobOrdenEtapaDeudaCmdRequery();
	}
}

function cobOrdenEtapaDeudaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobOrdenEtapaDeudaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cobOrdenEtapaDeudaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cobOrdenEtapaDeudaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cobOrdenEtapaDeudaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cobOrdenEtapaDeudaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cobOrdenEtapaDeudaFrm.timestamp', timestamps);


	cobOrdenEtapaDeudaFrm.oculto='S';
	envia('cobOrdenEtapaDeudaFrm');
	cobOrdenEtapaDeudaFrm.oculto='N';
}

function cobOrdenEtapaDeudaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cobOrdenEtapaDeudaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	cobOrdenEtapaDeudaViewDetail(cobOrdenEtapaDeudaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cobOrdenEtapaDeudaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cobOrdenEtapaDeudaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('CobOrdenEtapaDeudaLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('cobOrdenEtapaDeudaFrm', 
		'Descripcion', 1,
		get('cobOrdenEtapaDeudaFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('cobOrdenEtapaDeudaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('cobOrdenEtapaDeudaFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('CobOrdenEtapaDeuda.Descripcion.requiered.message'));
		focaliza('cobOrdenEtapaDeudaFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		cobOrdenEtapaDeudaFrm.oculto='S';
		envia('cobOrdenEtapaDeudaFrm');
		cobOrdenEtapaDeudaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cobOrdenEtapaDeudaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cobOrdenEtapaDeudaFrm.accion');
	var origenTmp = get('cobOrdenEtapaDeudaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cobOrdenEtapaDeudaBuildUpdateRecordString() != cobOrdenEtapaDeudaTmpUpdateValues){
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
	document.all.cobOrdenEtapaDeudaListLayer.style.display='none';
	document.all.cobOrdenEtapaDeudaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cobOrdenEtapaDeudaListLayer.style.display='';
	document.all.cobOrdenEtapaDeudaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsCobOrdenEtapaDeudaCodOrdeEtapDeud = get('cobOrdenEtapaDeudaFrm.codOrdeEtapDeud').toString();
	
	
	var parametros = "";
	parametros += jsCobOrdenEtapaDeudaCodOrdeEtapDeud + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cobOrdenEtapaDeudaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCobOrdenEtapaDeudaCodOrdeEtapDeud + "|";
	parametros += jsCobOrdenEtapaDeudaDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobOrdenEtapaDeudaFrm.accion'), 
		get('cobOrdenEtapaDeudaFrm.origen'));
	
	jsCobOrdenEtapaDeudaId = get('cobOrdenEtapaDeudaFrm.id').toString();
	jsCobOrdenEtapaDeudaCodOrdeEtapDeud = get('cobOrdenEtapaDeudaFrm.codOrdeEtapDeud').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsCobOrdenEtapaDeudaDescripcion = buildLocalizedString('cobOrdenEtapaDeudaFrm', 1);
	}else{
		jsCobOrdenEtapaDeudaDescripcion = get('cobOrdenEtapaDeudaFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cobOrdenEtapaDeudaFrm.accion'), 
		get('cobOrdenEtapaDeudaFrm.origen'));


	set('cobOrdenEtapaDeudaFrm.id', jsCobOrdenEtapaDeudaId);
	set('cobOrdenEtapaDeudaFrm.codOrdeEtapDeud', jsCobOrdenEtapaDeudaCodOrdeEtapDeud);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('cobOrdenEtapaDeudaFrm', 1,  jsCobOrdenEtapaDeudaDescripcion)
		loadLocalizationWidget('cobOrdenEtapaDeudaFrm', 'Descripcion', 1);
	}else{
		set('cobOrdenEtapaDeudaFrm.Descripcion', jsCobOrdenEtapaDeudaDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsCobOrdenEtapaDeudaCodOrdeEtapDeud = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cobOrdenEtapaDeudaFrm.errCodigo', errorCode);
	set('cobOrdenEtapaDeudaFrm.errDescripcion', description);
	set('cobOrdenEtapaDeudaFrm.errSeverity', severity);
	fMostrarMensajeError();
}
