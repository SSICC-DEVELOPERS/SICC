

/*
    INDRA/CAR/mmg
    $Id: maetipotarje.js,v 1.1 2009/12/03 19:02:18 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeTipoTarjeId = "";
var jsMaeTipoTarjeCodTipoTarj = "";
var jsMaeTipoTarjeDescripcion = "";

//Variables de paginacion, 
var maeTipoTarjePageCount = 1;

//Varible de columna que representa el campo de choice
var maeTipoTarjeChoiceColumn = 1;

//Flag de siguiente pagina;
var maeTipoTarjeMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeTipoTarjeTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeTipoTarjeLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("maeTipoTarjeFrm.codTipoTarj");','focaliza("maeTipoTarjeFrm.codTipoTarj");','focaliza("maeTipoTarjeFrm.codTipoTarj");','focaliza("maeTipoTarjeFrm.codTipoTarj");','focaliza("maeTipoTarjeFrm.codTipoTarj");','focaliza("maeTipoTarjeFrm.codTipoTarj");'],[3,'focaliza("maeTipoTarjeFrm.Descripcion");','focaliza("maeTipoTarjeFrm.Descripcion");','focaliza("maeTipoTarjeFrm.Descripcion");','focaliza("maeTipoTarjeFrm.Descripcion");','focaliza("maeTipoTarjeFrm.Descripcion");','focaliza("maeTipoTarjeFrm.Descripcion");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[3,'focaliza("maeTipoTarjeFrm.Descripcion");','focaliza("maeTipoTarjeFrm.Descripcion");','focaliza("maeTipoTarjeFrm.Descripcion");','focaliza("maeTipoTarjeFrm.Descripcion");','focaliza("maeTipoTarjeFrm.Descripcion");','focaliza("maeTipoTarjeFrm.Descripcion");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeTipoTarjeLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeTipoTarjeTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeTipoTarjeInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeTipoTarjeFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeTipoTarjeFrm.accion')){
		case "query": maeTipoTarjeQueryInitComponents(); break;
		case "view": maeTipoTarjeViewInitComponents(); break;
		case "create": maeTipoTarjeCreateInitComponents(); break;
		case "update": maeTipoTarjeUpdateInitComponents(); break;
		case "remove": maeTipoTarjeRemoveInitComponents(); break;
		case "lov": maeTipoTarjeLovInitComponents(); break;
	}
	//alert('accion :' + get('maeTipoTarjeFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeTipoTarjeFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeTipoTarje')) maeTipoTarjeCmdRequery();
}

function maeTipoTarjeQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('maeTipoTarjeFrm', true);	
}

function maeTipoTarjeViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeTipoTarjeFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('maeTipoTarjeFrm', true);
}

function maeTipoTarjeCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeTipoTarjeFrm.codTipoTarj','S', GestionarMensaje('MaeTipoTarje.codTipoTarj.requiered.message'));
	
	setMV('maeTipoTarjeFrm.Descripcion','S', GestionarMensaje('MaeTipoTarje.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeTipoTarjeFrm', true);
}

function maeTipoTarjeUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeTipoTarjeFrm.origen') == "pagina"){
		loadLocalizationWidget('maeTipoTarjeFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeTipoTarjeTmpUpdateValues = maeTipoTarjeBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeTipoTarjeFrm.codTipoTarj','S', GestionarMensaje('MaeTipoTarje.codTipoTarj.requiered.message'));
		setMV('maeTipoTarjeFrm.Descripcion','S', GestionarMensaje('MaeTipoTarje.Descripcion.requiered.message'));
		
			focusFirstFieldModify('maeTipoTarjeFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('maeTipoTarjeFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeTipoTarjeFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeTipoTarjeRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeTipoTarjeList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeTipoTarjeFrm', true);
}

function maeTipoTarjeLovInitComponents(){
	maeTipoTarjeLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeTipoTarjeFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad





//Función que permite cargar los datos de un elemento de lov seleccionado
function maeTipoTarjeSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeTipoTarjeFrm.' + campo, id);
	set('maeTipoTarjeFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeTipoTarjeLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeTipoTarjeLovReturnParameters.id = '';
	maeTipoTarjeLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeTipoTarjeLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoTarjeList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeTipoTarjeList.codSeleccionados();
	var descripcion = maeTipoTarjeList.extraeDato(
		maeTipoTarjeList.codSeleccionados()[0], maeTipoTarjeChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeTipoTarjeLovReturnParameters.id = codigo;
	maeTipoTarjeLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeTipoTarjeCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeTipoTarjeFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeTipoTarjeFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeTipoTarjeList", "MaeTipoTarjeConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeTipoTarjePostQueryActions(datos);"]], "", "");	
}

function maeTipoTarjeCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeTipoTarjeFrm.lastQueryToSession'));
	var i =0;
	set('maeTipoTarjeFrm.codTipoTarj', paramsRequery.ij(i++));
	
	set('maeTipoTarjeFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeTipoTarjePageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeTipoTarjeCmdQuery(maeTipoTarjePageCount);
}

function maeTipoTarjeFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeTipoTarjePageCount = 1;
	maeTipoTarjeCmdQuery(maeTipoTarjePageCount);
}

function maeTipoTarjePreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoTarjeLastQuery){
		maeTipoTarjeFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeTipoTarjePageCount--;
	maeTipoTarjeCmdQuery(maeTipoTarjePageCount);
}

function maeTipoTarjeNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoTarjeLastQuery){
		maeTipoTarjeFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeTipoTarjePageCount++;
	maeTipoTarjeCmdQuery(maeTipoTarjePageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeTipoTarjePostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeTipoTarjeListLayer', 'O');
		visibilidad('maeTipoTarjeListButtonsLayer', 'O');
		if(get('maeTipoTarjeFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeTipoTarjeLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeTipoTarjeViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeTipoTarjeChoiceColumn) + "</A>",
			i, maeTipoTarjeChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeTipoTarjeList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeTipoTarjeTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeTipoTarjeMorePagesFlag = true;
		maeTipoTarjeList.eliminar(mmgPageSize, 1);
	}else{
		maeTipoTarjeMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeTipoTarjeFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeTipoTarjeListLayer', 'V');
	visibilidad('maeTipoTarjeListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeTipoTarjeList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeTipoTarjeList.display();
	
	//Actualizamos el estado de los botones 
	if(maeTipoTarjeMorePagesFlag){
		set_estado_botonera('maeTipoTarjePaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeTipoTarjePaginationButtonBar',
			3,"inactivo");
	}
	if(maeTipoTarjePageCount > 1){
		set_estado_botonera('maeTipoTarjePaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeTipoTarjePaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeTipoTarjePaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeTipoTarjePaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeTipoTarjeUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoTarjeList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeTipoTarjeFrm.idSelection', maeTipoTarjeList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeTipoTarjeFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeTipoTarjeList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeTipoTarjeFrm.accion');
		parametros["accion"] = get('maeTipoTarjeFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeTipoTarjeLPStartUp', get('maeTipoTarjeFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeTipoTarjeCmdRequery();
	}
}

function maeTipoTarjeRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoTarjeList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeTipoTarjeList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeTipoTarjeFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeTipoTarjeList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeTipoTarjeTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeTipoTarjeFrm.timestamp', timestamps);


	maeTipoTarjeFrm.oculto='S';
	envia('maeTipoTarjeFrm');
	maeTipoTarjeFrm.oculto='N';
}

function maeTipoTarjeViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoTarjeList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeTipoTarjeViewDetail(maeTipoTarjeList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeTipoTarjeViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeTipoTarjeFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeTipoTarjeLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	setDefaultLanguageValue('maeTipoTarjeFrm', 
		'Descripcion', 1,
		get('maeTipoTarjeFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeTipoTarjeFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	if(!hasDefaultLanguageValue('maeTipoTarjeFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeTipoTarje.Descripcion.requiered.message'));
		focaliza('maeTipoTarjeFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		maeTipoTarjeFrm.oculto='S';
		envia('maeTipoTarjeFrm');
		maeTipoTarjeFrm.oculto='N';
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
	maeTipoTarjeRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeTipoTarjeFrm.accion');
	var origenTmp = get('maeTipoTarjeFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeTipoTarjeBuildUpdateRecordString() != maeTipoTarjeTmpUpdateValues){
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
	document.all.maeTipoTarjeListLayer.style.display='none';
	document.all.maeTipoTarjeListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeTipoTarjeListLayer.style.display='';
	document.all.maeTipoTarjeListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeTipoTarjeCodTipoTarj = get('maeTipoTarjeFrm.codTipoTarj').toString();
	jsMaeTipoTarjeDescripcion = get('maeTipoTarjeFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsMaeTipoTarjeCodTipoTarj + "|";
	parametros += jsMaeTipoTarjeDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeTipoTarjeBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeTipoTarjeCodTipoTarj + "|";
	parametros += jsMaeTipoTarjeDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoTarjeFrm.accion'), 
		get('maeTipoTarjeFrm.origen'));
	
	jsMaeTipoTarjeId = get('maeTipoTarjeFrm.id').toString();
	jsMaeTipoTarjeCodTipoTarj = get('maeTipoTarjeFrm.codTipoTarj').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeTipoTarjeDescripcion = buildLocalizedString('maeTipoTarjeFrm', 1);
	}else{
		jsMaeTipoTarjeDescripcion = get('maeTipoTarjeFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoTarjeFrm.accion'), 
		get('maeTipoTarjeFrm.origen'));


	set('maeTipoTarjeFrm.id', jsMaeTipoTarjeId);
	set('maeTipoTarjeFrm.codTipoTarj', jsMaeTipoTarjeCodTipoTarj);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeTipoTarjeFrm', 1,  jsMaeTipoTarjeDescripcion)
		loadLocalizationWidget('maeTipoTarjeFrm', 'Descripcion', 1);
	}else{
		set('maeTipoTarjeFrm.Descripcion', jsMaeTipoTarjeDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeTipoTarjeCodTipoTarj = '';
	jsMaeTipoTarjeDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeTipoTarjeFrm.errCodigo', errorCode);
	set('maeTipoTarjeFrm.errDescripcion', description);
	set('maeTipoTarjeFrm.errSeverity', severity);
	fMostrarMensajeError();
}
