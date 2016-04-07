

/*
    INDRA/CAR/mmg
    $Id: genprincipals.js,v 1.1 2009/12/03 19:01:35 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsGenPrincipalsId = "";
var jsGenPrincipalsName = "";
var jsGenPrincipalsType = "";
var jsGenPrincipalsDescription = "";

//Variables de paginacion, 
var genPrincipalsPageCount = 1;

//Varible de columna que representa el campo de choice
var genPrincipalsChoiceColumn = 0;

//Flag de siguiente pagina;
var genPrincipalsMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var genPrincipalsTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 189;
var sizeFormView = 167;
var sizeFormUpdate = 167;

//Ultima busqueda realizada
var genPrincipalsLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("genPrincipalsFrm.description");','focaliza("genPrincipalsFrm.description");','focaliza("genPrincipalsFrm.description");','focaliza("genPrincipalsFrm.description");','focaliza("genPrincipalsFrm.description");','focaliza("genPrincipalsFrm.description");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[0,'focaliza("genPrincipalsFrm.description");','focaliza("genPrincipalsFrm.description");','focaliza("genPrincipalsFrm.description");','focaliza("genPrincipalsFrm.description");','focaliza("genPrincipalsFrm.description");','focaliza("genPrincipalsFrm.description");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
genPrincipalsLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var genPrincipalsTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function genPrincipalsInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('genPrincipalsFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('genPrincipalsFrm.accion')){
		case "query": genPrincipalsQueryInitComponents(); break;
		case "view": genPrincipalsViewInitComponents(); break;
		case "create": genPrincipalsCreateInitComponents(); break;
		case "update": genPrincipalsUpdateInitComponents(); break;
		case "remove": genPrincipalsRemoveInitComponents(); break;
		case "lov": genPrincipalsLovInitComponents(); break;
	}
	//alert('accion :' + get('genPrincipalsFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('genPrincipalsFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('genPrincipals')) genPrincipalsCmdRequery();
}

function genPrincipalsQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('genPrincipalsFrm', true);	
}

function genPrincipalsViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('genPrincipalsFrm', true);
}

function genPrincipalsCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('genPrincipalsFrm.name','S', GestionarMensaje('GenPrincipals.name.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('genPrincipalsFrm', true);
}

function genPrincipalsUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('genPrincipalsFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		genPrincipalsTmpUpdateValues = genPrincipalsBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('genPrincipalsFrm.name','S', GestionarMensaje('GenPrincipals.name.requiered.message'));
		
			focusFirstFieldModify('genPrincipalsFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('genPrincipalsFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('genPrincipalsFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function genPrincipalsRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	genPrincipalsList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('genPrincipalsFrm', true);
}

function genPrincipalsLovInitComponents(){
	genPrincipalsLovReturnParameters = window.dialogArguments;
	
	focusFirstField('genPrincipalsFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function genPrincipalsSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('genPrincipalsFrm.' + campo, id);
	set('genPrincipalsFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function genPrincipalsLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	genPrincipalsLovReturnParameters.id = '';
	genPrincipalsLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function genPrincipalsLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(genPrincipalsList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = genPrincipalsList.codSeleccionados();
	var descripcion = genPrincipalsList.extraeDato(
		genPrincipalsList.codSeleccionados()[0], genPrincipalsChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	genPrincipalsLovReturnParameters.id = codigo;
	genPrincipalsLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function genPrincipalsCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('genPrincipalsFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('genPrincipalsFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "genPrincipalsList", "GenPrincipalsConectorTransactionQuery", 
		"result_ROWSET", parametros, "genPrincipalsPostQueryActions(datos);"]], "", "");	
}

function genPrincipalsCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('genPrincipalsFrm.lastQueryToSession'));
	var i =0;
	set('genPrincipalsFrm.name', paramsRequery.ij(i++));
	
	set('genPrincipalsFrm.type', paramsRequery.ij(i++));
	
	set('genPrincipalsFrm.description', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	genPrincipalsPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	genPrincipalsCmdQuery(genPrincipalsPageCount);
}

function genPrincipalsFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	genPrincipalsPageCount = 1;
	genPrincipalsCmdQuery(genPrincipalsPageCount);
}

function genPrincipalsPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != genPrincipalsLastQuery){
		genPrincipalsFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	genPrincipalsPageCount--;
	genPrincipalsCmdQuery(genPrincipalsPageCount);
}

function genPrincipalsNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != genPrincipalsLastQuery){
		genPrincipalsFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	genPrincipalsPageCount++;
	genPrincipalsCmdQuery(genPrincipalsPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function genPrincipalsPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('genPrincipalsListLayer', 'O');
		visibilidad('genPrincipalsListButtonsLayer', 'O');
		if(get('genPrincipalsFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	genPrincipalsLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:genPrincipalsViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, genPrincipalsChoiceColumn) + "</A>",
			i, genPrincipalsChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	genPrincipalsList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	genPrincipalsTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		genPrincipalsMorePagesFlag = true;
		genPrincipalsList.eliminar(mmgPageSize, 1);
	}else{
		genPrincipalsMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('genPrincipalsFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('genPrincipalsListLayer', 'V');
	visibilidad('genPrincipalsListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('genPrincipalsList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	genPrincipalsList.display();
	
	//Actualizamos el estado de los botones 
	if(genPrincipalsMorePagesFlag){
		set_estado_botonera('genPrincipalsPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('genPrincipalsPaginationButtonBar',
			3,"inactivo");
	}
	if(genPrincipalsPageCount > 1){
		set_estado_botonera('genPrincipalsPaginationButtonBar',
			2,"activo");
		set_estado_botonera('genPrincipalsPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('genPrincipalsPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('genPrincipalsPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function genPrincipalsUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(genPrincipalsList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('genPrincipalsFrm.idSelection', genPrincipalsList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('genPrincipalsFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = genPrincipalsList.codSeleccionados()[0];
		parametros["previousAction"] = get('genPrincipalsFrm.accion');
		parametros["accion"] = get('genPrincipalsFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('GenPrincipalsLPStartUp', get('genPrincipalsFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) genPrincipalsCmdRequery();
	}
}

function genPrincipalsRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(genPrincipalsList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = genPrincipalsList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('genPrincipalsFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(genPrincipalsList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += genPrincipalsTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('genPrincipalsFrm.timestamp', timestamps);


	genPrincipalsFrm.oculto='S';
	envia('genPrincipalsFrm');
	genPrincipalsFrm.oculto='N';
}

function genPrincipalsViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(genPrincipalsList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	genPrincipalsViewDetail(genPrincipalsList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function genPrincipalsViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('genPrincipalsFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('GenPrincipalsLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('genPrincipalsFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
		
	
	if(validacion){
		genPrincipalsFrm.oculto='S';
		envia('genPrincipalsFrm');
		genPrincipalsFrm.oculto='N';
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
	genPrincipalsRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('genPrincipalsFrm.accion');
	var origenTmp = get('genPrincipalsFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(genPrincipalsBuildUpdateRecordString() != genPrincipalsTmpUpdateValues){
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
	document.all.genPrincipalsListLayer.style.display='none';
	document.all.genPrincipalsListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.genPrincipalsListLayer.style.display='';
	document.all.genPrincipalsListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsGenPrincipalsName = get('genPrincipalsFrm.name').toString();
	jsGenPrincipalsType = get('genPrincipalsFrm.type').toString();
	jsGenPrincipalsDescription = get('genPrincipalsFrm.description').toString();
	
	
	var parametros = "";
	parametros += jsGenPrincipalsName + "|";
	parametros += jsGenPrincipalsType + "|";
	parametros += jsGenPrincipalsDescription + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function genPrincipalsBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsGenPrincipalsName + "|";
	parametros += jsGenPrincipalsType + "|";
	parametros += jsGenPrincipalsDescription + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('genPrincipalsFrm.accion'), 
		get('genPrincipalsFrm.origen'));
	
	jsGenPrincipalsId = get('genPrincipalsFrm.id').toString();
	jsGenPrincipalsName = get('genPrincipalsFrm.name').toString();
	jsGenPrincipalsType = get('genPrincipalsFrm.type').toString();
	jsGenPrincipalsDescription = get('genPrincipalsFrm.description').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('genPrincipalsFrm.accion'), 
		get('genPrincipalsFrm.origen'));


	set('genPrincipalsFrm.id', jsGenPrincipalsId);
	set('genPrincipalsFrm.name', jsGenPrincipalsName);
	set('genPrincipalsFrm.type', jsGenPrincipalsType);
	set('genPrincipalsFrm.description', jsGenPrincipalsDescription);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsGenPrincipalsName = '';
	jsGenPrincipalsType = '';
	jsGenPrincipalsDescription = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('genPrincipalsFrm.errCodigo', errorCode);
	set('genPrincipalsFrm.errDescripcion', description);
	set('genPrincipalsFrm.errSeverity', severity);
	fMostrarMensajeError();
}
