

/*
    INDRA/CAR/mmg
    $Id: vcasegacces.js,v 1.1 2009/12/03 19:02:04 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsVcaSegAccesCodUsua = "";
var jsVcaSegAccesOidAcce = "";
var jsVcaSegAccesCanaOidCana = "";
var jsVcaSegAccesCodAcce = "";

//Variables de paginacion, 
var vcaSegAccesPageCount = 1;

//Varible de columna que representa el campo de choice
var vcaSegAccesChoiceColumn = 4;

//Flag de siguiente pagina;
var vcaSegAccesMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var vcaSegAccesTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 220;
var sizeFormView = 220;
var sizeFormUpdate = 220;

//Ultima busqueda realizada
var vcaSegAccesLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("vcaSegAccesFrm.codAcce");','focaliza("vcaSegAccesFrm.codAcce");','focaliza("vcaSegAccesFrm.codAcce");','focaliza("vcaSegAccesFrm.codAcce");','focaliza("vcaSegAccesFrm.codAcce");','focaliza("vcaSegAccesFrm.codAcce");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
vcaSegAccesLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var vcaSegAccesTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function vcaSegAccesInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('vcaSegAccesFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('vcaSegAccesFrm.accion')){
		case "query": vcaSegAccesQueryInitComponents(); break;
		case "view": vcaSegAccesViewInitComponents(); break;
		case "create": vcaSegAccesCreateInitComponents(); break;
		case "update": vcaSegAccesUpdateInitComponents(); break;
		case "remove": vcaSegAccesRemoveInitComponents(); break;
		case "lov": vcaSegAccesLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('vcaSegAccesFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('vcaSegAcces')) vcaSegAccesCmdRequery();
}

function vcaSegAccesQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
}

function vcaSegAccesViewInitComponents(){
	//En principiono se hace nada
}

function vcaSegAccesCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('vcaSegAccesFrm.codUsua','S', GestionarMensaje('VcaSegAcces.codUsua.requiered.message'));
	
	setMV('vcaSegAccesFrm.oidAcce','S', GestionarMensaje('VcaSegAcces.oidAcce.requiered.message'));
	
	setMV('vcaSegAccesFrm.canaOidCana','S', GestionarMensaje('VcaSegAcces.canaOidCana.requiered.message'));
	
	setMV('vcaSegAccesFrm.codAcce','S', GestionarMensaje('VcaSegAcces.codAcce.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function vcaSegAccesUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('vcaSegAccesFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		vcaSegAccesTmpUpdateValues = vcaSegAccesBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('vcaSegAccesFrm.codUsua','S', GestionarMensaje('VcaSegAcces.codUsua.requiered.message'));
		
		setMV('vcaSegAccesFrm.oidAcce','S', GestionarMensaje('VcaSegAcces.oidAcce.requiered.message'));
		
		setMV('vcaSegAccesFrm.canaOidCana','S', GestionarMensaje('VcaSegAcces.canaOidCana.requiered.message'));
		
		setMV('vcaSegAccesFrm.codAcce','S', GestionarMensaje('VcaSegAcces.codAcce.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('vcaSegAccesFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function vcaSegAccesRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	vcaSegAccesList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function vcaSegAccesLovInitComponents(){
	vcaSegAccesLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function vcaSegAccesSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('vcaSegAccesFrm.' + campo, id);
	set('vcaSegAccesFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function vcaSegAccesLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	vcaSegAccesLovReturnParameters.id = '';
	vcaSegAccesLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function vcaSegAccesLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(vcaSegAccesList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = vcaSegAccesList.codSeleccionados();
	var descripcion = vcaSegAccesList.extraeDato(
		vcaSegAccesList.codSeleccionados()[0], vcaSegAccesChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	vcaSegAccesLovReturnParameters.id = codigo;
	vcaSegAccesLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function vcaSegAccesCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('vcaSegAccesFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	vcaSegAccesLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('vcaSegAccesFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "vcaSegAccesList", "VcaSegAccesConectorTransactionQuery", 
		"result_ROWSET", parametros, "vcaSegAccesPostQueryActions(datos);"]], "", "");	
}

function vcaSegAccesCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('vcaSegAccesFrm.lastQueryToSession'));
	var i =0;
	set('vcaSegAccesFrm.codUsua', paramsRequery.ij(i++));
	
	set('vcaSegAccesFrm.oidAcce', paramsRequery.ij(i++));
	
	set('vcaSegAccesFrm.canaOidCana', paramsRequery.ij(i++));
	
	set('vcaSegAccesFrm.codAcce', paramsRequery.ij(i++));
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	vcaSegAccesPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	vcaSegAccesCmdQuery(vcaSegAccesPageCount);
}

function vcaSegAccesFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	vcaSegAccesPageCount = 1;
	vcaSegAccesCmdQuery(vcaSegAccesPageCount);
}

function vcaSegAccesPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != vcaSegAccesLastQuery){
		vcaSegAccesFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	vcaSegAccesPageCount--;
	vcaSegAccesCmdQuery(vcaSegAccesPageCount);
}

function vcaSegAccesNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != vcaSegAccesLastQuery){
		vcaSegAccesFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	vcaSegAccesPageCount++;
	vcaSegAccesCmdQuery(vcaSegAccesPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function vcaSegAccesPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('vcaSegAccesListLayer', 'O');
		visibilidad('vcaSegAccesListButtonsLayer', 'O');
		if(get('vcaSegAccesFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:vcaSegAccesViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, vcaSegAccesChoiceColumn) + "</A>",
			i, vcaSegAccesChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	vcaSegAccesList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	vcaSegAccesTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		vcaSegAccesMorePagesFlag = true;
		vcaSegAccesList.eliminar(mmgPageSize, 1);
	}else{
		vcaSegAccesMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('vcaSegAccesFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('vcaSegAccesListLayer', 'V');
	visibilidad('vcaSegAccesListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('vcaSegAccesList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	vcaSegAccesList.display();
	
	//Actualizamos el estado de los botones 
	if(vcaSegAccesMorePagesFlag){
		set_estado_botonera('vcaSegAccesPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('vcaSegAccesPaginationButtonBar',
			3,"inactivo");
	}
	if(vcaSegAccesPageCount > 1){
		set_estado_botonera('vcaSegAccesPaginationButtonBar',
			2,"activo");
		set_estado_botonera('vcaSegAccesPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('vcaSegAccesPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('vcaSegAccesPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function vcaSegAccesUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(vcaSegAccesList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('vcaSegAccesFrm.idSelection', vcaSegAccesList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('vcaSegAccesFrm', true);
	if(validacion){
		/*set('vcaSegAccesFrm.previousAction', 'update');
		set('vcaSegAccesFrm.ON', 'VcaSegAccesLPStartUp');
		set('vcaSegAccesFrm.conectorAction', 'VcaSegAccesLPStartUp');
		set('vcaSegAccesFrm.origen', 'pagina');
		envia('vcaSegAccesFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = vcaSegAccesList.codSeleccionados()[0];
		parametros["previousAction"] = get('vcaSegAccesFrm.accion');
		parametros["accion"] = get('vcaSegAccesFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('VcaSegAccesLPStartUp', get('vcaSegAccesFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) vcaSegAccesCmdRequery();
	}
}

function vcaSegAccesRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(vcaSegAccesList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = vcaSegAccesList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('vcaSegAccesFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(vcaSegAccesList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += vcaSegAccesTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('vcaSegAccesFrm.timestamp', timestamps);
	envia('vcaSegAccesFrm');
}

function vcaSegAccesViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(vcaSegAccesList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('vcaSegAccesFrm.previousAction', get('vcaSegAccesFrm.accion'));
	set('vcaSegAccesFrm.accion', 'view');
	set('vcaSegAccesFrm.origen', 'pagina');
	set('vcaSegAccesFrm.ON', 'VcaSegAccesLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('vcaSegAccesFrm.idSelection', vcaSegAccesList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('vcaSegAccesFrm');
	vcaSegAccesViewDetail(vcaSegAccesList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function vcaSegAccesViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('vcaSegAccesFrm.accion');
	parametros["accion"] = get('vcaSegAccesFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('VcaSegAccesLPStartUp', get('vcaSegAccesFrm.accion'), parametros, null, sizeFormView + 30);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar on dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('vcaSegAccesFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
		
	
	if(validacion)envia('vcaSegAccesFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	vcaSegAccesRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('vcaSegAccesFrm.accion');
	var origenTmp = get('vcaSegAccesFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(vcaSegAccesBuildUpdateRecordString() != vcaSegAccesTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('vcaSegAccesFrm.performRequery', 'true');
		set('vcaSegAccesFrm.accion', 
			get('vcaSegAccesFrm.previousAction'));
		set('vcaSegAccesFrm.origen', 'menu');
		set('vcaSegAccesFrm.ON', 'VcaSegAccesLPStartUp');
		set('vcaSegAccesFrm.conectorAction', 'VcaSegAccesLPStartUp');
		vcaSegAccesFrm.oculto='N';
		envia('vcaSegAccesFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.vcaSegAccesListLayer.style.display='none';
	document.all.vcaSegAccesListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.vcaSegAccesListLayer.style.display='';
	document.all.vcaSegAccesListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsVcaSegAccesCodUsua = get('vcaSegAccesFrm.codUsua').toString();






	jsVcaSegAccesOidAcce = get('vcaSegAccesFrm.oidAcce').toString();






	jsVcaSegAccesCanaOidCana = get('vcaSegAccesFrm.canaOidCana').toString();






	jsVcaSegAccesCodAcce = get('vcaSegAccesFrm.codAcce').toString();








	var parametros = "";
	parametros += jsVcaSegAccesCodUsua + "|";



	parametros += jsVcaSegAccesOidAcce + "|";



	parametros += jsVcaSegAccesCanaOidCana + "|";



	parametros += jsVcaSegAccesCodAcce + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function vcaSegAccesBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsVcaSegAccesCodUsua + "|";
	parametros += jsVcaSegAccesOidAcce + "|";
	parametros += jsVcaSegAccesCanaOidCana + "|";
	parametros += jsVcaSegAccesCodAcce + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('vcaSegAccesFrm.accion'), 
		get('vcaSegAccesFrm.origen'));
	
	jsVcaSegAccesCodUsua = get('vcaSegAccesFrm.codUsua').toString();
	jsVcaSegAccesOidAcce = get('vcaSegAccesFrm.oidAcce').toString();
	jsVcaSegAccesCanaOidCana = get('vcaSegAccesFrm.canaOidCana').toString();
	jsVcaSegAccesCodAcce = get('vcaSegAccesFrm.codAcce').toString();

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('vcaSegAccesFrm.accion'), 
		get('vcaSegAccesFrm.origen'));


	set('vcaSegAccesFrm.codUsua', jsVcaSegAccesCodUsua);
	set('vcaSegAccesFrm.oidAcce', jsVcaSegAccesOidAcce);
	set('vcaSegAccesFrm.canaOidCana', jsVcaSegAccesCanaOidCana);
	set('vcaSegAccesFrm.codAcce', jsVcaSegAccesCodAcce);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('vcaSegAccesFrm.errCodigo', errorCode);
	set('vcaSegAccesFrm.errDescripcion', description);
	set('vcaSegAccesFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
