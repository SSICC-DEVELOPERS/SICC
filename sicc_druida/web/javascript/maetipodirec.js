

/*
    INDRA/CAR/mmg
    $Id: maetipodirec.js,v 1.1 2009/12/03 19:01:54 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeTipoDirecId = "";
var jsMaeTipoDirecCodTipoDire = "";
var jsMaeTipoDirecDescripcion = "";

//Variables de paginacion, 
var maeTipoDirecPageCount = 1;

//Varible de columna que representa el campo de choice
var maeTipoDirecChoiceColumn = 1;

//Flag de siguiente pagina;
var maeTipoDirecMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeTipoDirecTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeTipoDirecLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("maeTipoDirecFrm.codTipoDire");','focaliza("maeTipoDirecFrm.codTipoDire");','focaliza("maeTipoDirecFrm.codTipoDire");','focaliza("maeTipoDirecFrm.codTipoDire");','focaliza("maeTipoDirecFrm.codTipoDire");','focaliza("maeTipoDirecFrm.codTipoDire");'],[3,'focaliza("maeTipoDirecFrm.Descripcion");','focaliza("maeTipoDirecFrm.Descripcion");','focaliza("maeTipoDirecFrm.Descripcion");','focaliza("maeTipoDirecFrm.Descripcion");','focaliza("maeTipoDirecFrm.Descripcion");','focaliza("maeTipoDirecFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("maeTipoDirecFrm.Descripcion");','focaliza("maeTipoDirecFrm.Descripcion");','focaliza("maeTipoDirecFrm.Descripcion");','focaliza("maeTipoDirecFrm.Descripcion");','focaliza("maeTipoDirecFrm.Descripcion");','focaliza("maeTipoDirecFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeTipoDirecLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeTipoDirecTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeTipoDirecInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeTipoDirecFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeTipoDirecFrm.accion')){
		case "query": maeTipoDirecQueryInitComponents(); break;
		case "view": maeTipoDirecViewInitComponents(); break;
		case "create": maeTipoDirecCreateInitComponents(); break;
		case "update": maeTipoDirecUpdateInitComponents(); break;
		case "remove": maeTipoDirecRemoveInitComponents(); break;
		case "lov": maeTipoDirecLovInitComponents(); break;
	}
	//alert('accion :' + get('maeTipoDirecFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeTipoDirecFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeTipoDirec')) maeTipoDirecCmdRequery();
}

function maeTipoDirecQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('maeTipoDirecFrm', true);	
}

function maeTipoDirecViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeTipoDirecFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeTipoDirecFrm', true);
}

function maeTipoDirecCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeTipoDirecFrm.codTipoDire','S', GestionarMensaje('MaeTipoDirec.codTipoDire.requiered.message'));
	
	setMV('maeTipoDirecFrm.Descripcion','S', GestionarMensaje('MaeTipoDirec.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeTipoDirecFrm', true);
}

function maeTipoDirecUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeTipoDirecFrm.origen') == "pagina"){
		loadLocalizationWidget('maeTipoDirecFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeTipoDirecTmpUpdateValues = maeTipoDirecBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeTipoDirecFrm.codTipoDire','S', GestionarMensaje('MaeTipoDirec.codTipoDire.requiered.message'));
		setMV('maeTipoDirecFrm.Descripcion','S', GestionarMensaje('MaeTipoDirec.Descripcion.requiered.message'));
		
			focusFirstFieldModify('maeTipoDirecFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('maeTipoDirecFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeTipoDirecFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeTipoDirecRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeTipoDirecList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeTipoDirecFrm', true);
}

function maeTipoDirecLovInitComponents(){
	maeTipoDirecLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeTipoDirecFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad





//Función que permite cargar los datos de un elemento de lov seleccionado
function maeTipoDirecSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeTipoDirecFrm.' + campo, id);
	set('maeTipoDirecFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeTipoDirecLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeTipoDirecLovReturnParameters.id = '';
	maeTipoDirecLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeTipoDirecLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoDirecList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeTipoDirecList.codSeleccionados();
	var descripcion = maeTipoDirecList.extraeDato(
		maeTipoDirecList.codSeleccionados()[0], maeTipoDirecChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeTipoDirecLovReturnParameters.id = codigo;
	maeTipoDirecLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeTipoDirecCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeTipoDirecFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeTipoDirecFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeTipoDirecList", "MaeTipoDirecConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeTipoDirecPostQueryActions(datos);"]], "", "");	
}

function maeTipoDirecCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeTipoDirecFrm.lastQueryToSession'));
	var i =0;
	set('maeTipoDirecFrm.codTipoDire', paramsRequery.ij(i++));
	
	set('maeTipoDirecFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeTipoDirecPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeTipoDirecCmdQuery(maeTipoDirecPageCount);
}

function maeTipoDirecFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeTipoDirecPageCount = 1;
	maeTipoDirecCmdQuery(maeTipoDirecPageCount);
}

function maeTipoDirecPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoDirecLastQuery){
		maeTipoDirecFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeTipoDirecPageCount--;
	maeTipoDirecCmdQuery(maeTipoDirecPageCount);
}

function maeTipoDirecNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoDirecLastQuery){
		maeTipoDirecFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeTipoDirecPageCount++;
	maeTipoDirecCmdQuery(maeTipoDirecPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeTipoDirecPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeTipoDirecListLayer', 'O');
		visibilidad('maeTipoDirecListButtonsLayer', 'O');
		if(get('maeTipoDirecFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeTipoDirecLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeTipoDirecViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeTipoDirecChoiceColumn) + "</A>",
			i, maeTipoDirecChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeTipoDirecList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeTipoDirecTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeTipoDirecMorePagesFlag = true;
		maeTipoDirecList.eliminar(mmgPageSize, 1);
	}else{
		maeTipoDirecMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeTipoDirecFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeTipoDirecListLayer', 'V');
	visibilidad('maeTipoDirecListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeTipoDirecList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeTipoDirecList.display();
	
	//Actualizamos el estado de los botones 
	if(maeTipoDirecMorePagesFlag){
		set_estado_botonera('maeTipoDirecPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeTipoDirecPaginationButtonBar',
			3,"inactivo");
	}
	if(maeTipoDirecPageCount > 1){
		set_estado_botonera('maeTipoDirecPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeTipoDirecPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeTipoDirecPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeTipoDirecPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeTipoDirecUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoDirecList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeTipoDirecFrm.idSelection', maeTipoDirecList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeTipoDirecFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeTipoDirecList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeTipoDirecFrm.accion');
		parametros["accion"] = get('maeTipoDirecFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeTipoDirecLPStartUp', get('maeTipoDirecFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeTipoDirecCmdRequery();
	}
}

function maeTipoDirecRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoDirecList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeTipoDirecList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeTipoDirecFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeTipoDirecList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeTipoDirecTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeTipoDirecFrm.timestamp', timestamps);


	maeTipoDirecFrm.oculto='S';
	envia('maeTipoDirecFrm');
	maeTipoDirecFrm.oculto='N';
}

function maeTipoDirecViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoDirecList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeTipoDirecViewDetail(maeTipoDirecList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeTipoDirecViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeTipoDirecFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeTipoDirecLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('maeTipoDirecFrm', 
		'Descripcion', 1,
		get('maeTipoDirecFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeTipoDirecFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('maeTipoDirecFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeTipoDirec.Descripcion.requiered.message'));
		focaliza('maeTipoDirecFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		maeTipoDirecFrm.oculto='S';
		envia('maeTipoDirecFrm');
		maeTipoDirecFrm.oculto='N';
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
	maeTipoDirecRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeTipoDirecFrm.accion');
	var origenTmp = get('maeTipoDirecFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeTipoDirecBuildUpdateRecordString() != maeTipoDirecTmpUpdateValues){
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
	document.all.maeTipoDirecListLayer.style.display='none';
	document.all.maeTipoDirecListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeTipoDirecListLayer.style.display='';
	document.all.maeTipoDirecListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeTipoDirecCodTipoDire = get('maeTipoDirecFrm.codTipoDire').toString();
	jsMaeTipoDirecDescripcion = get('maeTipoDirecFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsMaeTipoDirecCodTipoDire + "|";
	parametros += jsMaeTipoDirecDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeTipoDirecBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeTipoDirecCodTipoDire + "|";
	parametros += jsMaeTipoDirecDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoDirecFrm.accion'), 
		get('maeTipoDirecFrm.origen'));
	
	jsMaeTipoDirecId = get('maeTipoDirecFrm.id').toString();
	jsMaeTipoDirecCodTipoDire = get('maeTipoDirecFrm.codTipoDire').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeTipoDirecDescripcion = buildLocalizedString('maeTipoDirecFrm', 1);
	}else{
		jsMaeTipoDirecDescripcion = get('maeTipoDirecFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoDirecFrm.accion'), 
		get('maeTipoDirecFrm.origen'));


	set('maeTipoDirecFrm.id', jsMaeTipoDirecId);
	set('maeTipoDirecFrm.codTipoDire', jsMaeTipoDirecCodTipoDire);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeTipoDirecFrm', 1,  jsMaeTipoDirecDescripcion)
		loadLocalizationWidget('maeTipoDirecFrm', 'Descripcion', 1);
	}else{
		set('maeTipoDirecFrm.Descripcion', jsMaeTipoDirecDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeTipoDirecCodTipoDire = '';
	jsMaeTipoDirecDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeTipoDirecFrm.errCodigo', errorCode);
	set('maeTipoDirecFrm.errDescripcion', description);
	set('maeTipoDirecFrm.errSeverity', severity);
	fMostrarMensajeError();
}
