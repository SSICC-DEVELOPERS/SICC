

/*
    INDRA/CAR/mmg
    $Id: edufrecucurso.js,v 1.1 2009/12/03 19:01:39 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsEduFrecuCursoId = "";
var jsEduFrecuCursoCodFrec = "";
var jsEduFrecuCursoDescripcion = "";

//Variables de paginacion, 
var eduFrecuCursoPageCount = 1;

//Varible de columna que representa el campo de choice
var eduFrecuCursoChoiceColumn = 2;

//Flag de siguiente pagina;
var eduFrecuCursoMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var eduFrecuCursoTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var eduFrecuCursoLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("eduFrecuCursoFrm.codFrec");','focaliza("eduFrecuCursoFrm.codFrec");','focaliza("eduFrecuCursoFrm.codFrec");','focaliza("eduFrecuCursoFrm.codFrec");','focaliza("eduFrecuCursoFrm.codFrec");','focaliza("eduFrecuCursoFrm.codFrec");'],[3,'focaliza("eduFrecuCursoFrm.Descripcion");','focaliza("eduFrecuCursoFrm.Descripcion");','focaliza("eduFrecuCursoFrm.Descripcion");','focaliza("eduFrecuCursoFrm.Descripcion");','focaliza("eduFrecuCursoFrm.Descripcion");','focaliza("eduFrecuCursoFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("eduFrecuCursoFrm.Descripcion");','focaliza("eduFrecuCursoFrm.Descripcion");','focaliza("eduFrecuCursoFrm.Descripcion");','focaliza("eduFrecuCursoFrm.Descripcion");','focaliza("eduFrecuCursoFrm.Descripcion");','focaliza("eduFrecuCursoFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
eduFrecuCursoLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var eduFrecuCursoTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function eduFrecuCursoInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('eduFrecuCursoFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('eduFrecuCursoFrm.accion')){
		case "query": eduFrecuCursoQueryInitComponents(); break;
		case "view": eduFrecuCursoViewInitComponents(); break;
		case "create": eduFrecuCursoCreateInitComponents(); break;
		case "update": eduFrecuCursoUpdateInitComponents(); break;
		case "remove": eduFrecuCursoRemoveInitComponents(); break;
		case "lov": eduFrecuCursoLovInitComponents(); break;
	}
	//alert('accion :' + get('eduFrecuCursoFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('eduFrecuCursoFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('eduFrecuCurso')) eduFrecuCursoCmdRequery();
}

function eduFrecuCursoQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('eduFrecuCursoFrm', true);	
}

function eduFrecuCursoViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('eduFrecuCursoFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('eduFrecuCursoFrm', true);
}

function eduFrecuCursoCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('eduFrecuCursoFrm.codFrec','S', GestionarMensaje('EduFrecuCurso.codFrec.requiered.message'));
	
	setMV('eduFrecuCursoFrm.Descripcion','S', GestionarMensaje('EduFrecuCurso.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('eduFrecuCursoFrm', true);
}

function eduFrecuCursoUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('eduFrecuCursoFrm.origen') == "pagina"){
		loadLocalizationWidget('eduFrecuCursoFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		eduFrecuCursoTmpUpdateValues = eduFrecuCursoBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('eduFrecuCursoFrm.codFrec','S', GestionarMensaje('EduFrecuCurso.codFrec.requiered.message'));
		setMV('eduFrecuCursoFrm.Descripcion','S', GestionarMensaje('EduFrecuCurso.Descripcion.requiered.message'));
		
			focusFirstFieldModify('eduFrecuCursoFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('eduFrecuCursoFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('eduFrecuCursoFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function eduFrecuCursoRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	eduFrecuCursoList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('eduFrecuCursoFrm', true);
}

function eduFrecuCursoLovInitComponents(){
	eduFrecuCursoLovReturnParameters = window.dialogArguments;
	
	focusFirstField('eduFrecuCursoFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad





//Función que permite cargar los datos de un elemento de lov seleccionado
function eduFrecuCursoSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('eduFrecuCursoFrm.' + campo, id);
	set('eduFrecuCursoFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function eduFrecuCursoLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	eduFrecuCursoLovReturnParameters.id = '';
	eduFrecuCursoLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function eduFrecuCursoLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(eduFrecuCursoList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = eduFrecuCursoList.codSeleccionados();
	var descripcion = eduFrecuCursoList.extraeDato(
		eduFrecuCursoList.codSeleccionados()[0], eduFrecuCursoChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	eduFrecuCursoLovReturnParameters.id = codigo;
	eduFrecuCursoLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function eduFrecuCursoCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('eduFrecuCursoFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('eduFrecuCursoFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "eduFrecuCursoList", "EduFrecuCursoConectorTransactionQuery", 
		"result_ROWSET", parametros, "eduFrecuCursoPostQueryActions(datos);"]], "", "");	
}

function eduFrecuCursoCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('eduFrecuCursoFrm.lastQueryToSession'));
	var i =0;
	set('eduFrecuCursoFrm.codFrec', paramsRequery.ij(i++));
	
	set('eduFrecuCursoFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	eduFrecuCursoPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	eduFrecuCursoCmdQuery(eduFrecuCursoPageCount);
}

function eduFrecuCursoFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	eduFrecuCursoPageCount = 1;
	eduFrecuCursoCmdQuery(eduFrecuCursoPageCount);
}

function eduFrecuCursoPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != eduFrecuCursoLastQuery){
		eduFrecuCursoFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	eduFrecuCursoPageCount--;
	eduFrecuCursoCmdQuery(eduFrecuCursoPageCount);
}

function eduFrecuCursoNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != eduFrecuCursoLastQuery){
		eduFrecuCursoFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	eduFrecuCursoPageCount++;
	eduFrecuCursoCmdQuery(eduFrecuCursoPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function eduFrecuCursoPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('eduFrecuCursoListLayer', 'O');
		visibilidad('eduFrecuCursoListButtonsLayer', 'O');
		if(get('eduFrecuCursoFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	eduFrecuCursoLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:eduFrecuCursoViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, eduFrecuCursoChoiceColumn) + "</A>",
			i, eduFrecuCursoChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	eduFrecuCursoList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	eduFrecuCursoTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		eduFrecuCursoMorePagesFlag = true;
		eduFrecuCursoList.eliminar(mmgPageSize, 1);
	}else{
		eduFrecuCursoMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('eduFrecuCursoFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('eduFrecuCursoListLayer', 'V');
	visibilidad('eduFrecuCursoListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('eduFrecuCursoList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	eduFrecuCursoList.display();
	
	//Actualizamos el estado de los botones 
	if(eduFrecuCursoMorePagesFlag){
		set_estado_botonera('eduFrecuCursoPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('eduFrecuCursoPaginationButtonBar',
			3,"inactivo");
	}
	if(eduFrecuCursoPageCount > 1){
		set_estado_botonera('eduFrecuCursoPaginationButtonBar',
			2,"activo");
		set_estado_botonera('eduFrecuCursoPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('eduFrecuCursoPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('eduFrecuCursoPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function eduFrecuCursoUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(eduFrecuCursoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('eduFrecuCursoFrm.idSelection', eduFrecuCursoList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('eduFrecuCursoFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = eduFrecuCursoList.codSeleccionados()[0];
		parametros["previousAction"] = get('eduFrecuCursoFrm.accion');
		parametros["accion"] = get('eduFrecuCursoFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('EduFrecuCursoLPStartUp', get('eduFrecuCursoFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) eduFrecuCursoCmdRequery();
	}
}

function eduFrecuCursoRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(eduFrecuCursoList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = eduFrecuCursoList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('eduFrecuCursoFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(eduFrecuCursoList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += eduFrecuCursoTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('eduFrecuCursoFrm.timestamp', timestamps);


	eduFrecuCursoFrm.oculto='S';
	envia('eduFrecuCursoFrm');
	eduFrecuCursoFrm.oculto='N';
}

function eduFrecuCursoViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(eduFrecuCursoList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	eduFrecuCursoViewDetail(eduFrecuCursoList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function eduFrecuCursoViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('eduFrecuCursoFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('EduFrecuCursoLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('eduFrecuCursoFrm', 
		'Descripcion', 1,
		get('eduFrecuCursoFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('eduFrecuCursoFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('eduFrecuCursoFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('EduFrecuCurso.Descripcion.requiered.message'));
		focaliza('eduFrecuCursoFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		eduFrecuCursoFrm.oculto='S';
		envia('eduFrecuCursoFrm');
		eduFrecuCursoFrm.oculto='N';
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
	eduFrecuCursoRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('eduFrecuCursoFrm.accion');
	var origenTmp = get('eduFrecuCursoFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(eduFrecuCursoBuildUpdateRecordString() != eduFrecuCursoTmpUpdateValues){
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
	document.all.eduFrecuCursoListLayer.style.display='none';
	document.all.eduFrecuCursoListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.eduFrecuCursoListLayer.style.display='';
	document.all.eduFrecuCursoListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsEduFrecuCursoCodFrec = get('eduFrecuCursoFrm.codFrec').toString();
	jsEduFrecuCursoDescripcion = get('eduFrecuCursoFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsEduFrecuCursoCodFrec + "|";
	parametros += jsEduFrecuCursoDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function eduFrecuCursoBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsEduFrecuCursoCodFrec + "|";
	parametros += jsEduFrecuCursoDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('eduFrecuCursoFrm.accion'), 
		get('eduFrecuCursoFrm.origen'));
	
	jsEduFrecuCursoId = get('eduFrecuCursoFrm.id').toString();
	jsEduFrecuCursoCodFrec = get('eduFrecuCursoFrm.codFrec').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsEduFrecuCursoDescripcion = buildLocalizedString('eduFrecuCursoFrm', 1);
	}else{
		jsEduFrecuCursoDescripcion = get('eduFrecuCursoFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('eduFrecuCursoFrm.accion'), 
		get('eduFrecuCursoFrm.origen'));


	set('eduFrecuCursoFrm.id', jsEduFrecuCursoId);
	set('eduFrecuCursoFrm.codFrec', jsEduFrecuCursoCodFrec);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('eduFrecuCursoFrm', 1,  jsEduFrecuCursoDescripcion)
		loadLocalizationWidget('eduFrecuCursoFrm', 'Descripcion', 1);
	}else{
		set('eduFrecuCursoFrm.Descripcion', jsEduFrecuCursoDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsEduFrecuCursoCodFrec = '';
	jsEduFrecuCursoDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('eduFrecuCursoFrm.errCodigo', errorCode);
	set('eduFrecuCursoFrm.errDescripcion', description);
	set('eduFrecuCursoFrm.errSeverity', severity);
	fMostrarMensajeError();
}
