

/*
    INDRA/CAR/mmg
    $Id: maeparamclien_old.js,v 1.1 2009/12/03 19:02:12 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeParamClienId = "";
var jsMaeParamClienPaisOidPais = "";
var jsMaeParamClienTiclOidTipoClie = "";
var jsMaeParamClienCodTipoAsig = "";

//Variables de paginacion, 
var maeParamClienPageCount = 1;

//Varible de columna que representa el campo de choice
var maeParamClienChoiceColumn = 1;

//Flag de siguiente pagina;
var maeParamClienMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeParamClienTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 115;
var sizeFormView = 115;
var sizeFormUpdate = 80;

//Ultima busqueda realizada
var maeParamClienLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'','','','','',''],[4,'focaliza("maeParamClienFrm.codTipoAsig");','focaliza("maeParamClienFrm.codTipoAsig");','','focaliza("maeParamClienFrm.codTipoAsig");','focaliza("maeParamClienFrm.codTipoAsig");','']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
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

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeParamClienLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeParamClienTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function maeParamClienInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeParamClienFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeParamClienFrm.accion')){
		case "query": maeParamClienQueryInitComponents(); break;
		case "view": maeParamClienViewInitComponents(); break;
		case "create": maeParamClienCreateInitComponents(); break;
		case "update": maeParamClienUpdateInitComponents(); break;
		case "remove": maeParamClienRemoveInitComponents(); break;
		case "lov": maeParamClienLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('maeParamClienFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeParamClien')) maeParamClienCmdRequery();
}

function maeParamClienQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
}

function maeParamClienViewInitComponents(){
	//En principiono se hace nada
}

function maeParamClienCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeParamClienFrm.codTipoAsig','S', GestionarMensaje('MaeParamClien.codTipoAsig.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function maeParamClienUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeParamClienFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		maeParamClienTmpUpdateValues = maeParamClienBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeParamClienFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeParamClienRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeParamClienList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function maeParamClienLovInitComponents(){
	maeParamClienLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function maeParamClienSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeParamClienFrm.' + campo, id);
	set('maeParamClienFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeParamClienLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeParamClienLovReturnParameters.id = '';
	maeParamClienLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeParamClienLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeParamClienList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeParamClienList.codSeleccionados();
	var descripcion = maeParamClienList.extraeDato(
		maeParamClienList.codSeleccionados()[0], maeParamClienChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeParamClienLovReturnParameters.id = codigo;
	maeParamClienLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeParamClienCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeParamClienFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeParamClienLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeParamClienFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeParamClienList", "MaeParamClienConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeParamClienPostQueryActions(datos);"]], "", "");	
}

function maeParamClienCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeParamClienFrm.lastQueryToSession'));
	var i =0;
	set('maeParamClienFrm.codTipoAsig', [paramsRequery.ij(i++)]);
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	maeParamClienPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeParamClienCmdQuery(maeParamClienPageCount);
}

function maeParamClienFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeParamClienPageCount = 1;
	maeParamClienCmdQuery(maeParamClienPageCount);
}

function maeParamClienPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeParamClienLastQuery){
		maeParamClienFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeParamClienPageCount--;
	maeParamClienCmdQuery(maeParamClienPageCount);
}

function maeParamClienNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeParamClienLastQuery){
		maeParamClienFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeParamClienPageCount++;
	maeParamClienCmdQuery(maeParamClienPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeParamClienPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeParamClienListLayer', 'O');
		visibilidad('maeParamClienListButtonsLayer', 'O');
		visibilidad('maeParamClienPreListLayer', 'O');
		if(get('maeParamClienFrm.accion') == "remove"){
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
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 1)){
			case 'M': datosTmp.ij2('Manual', i, 1); break;
			case 'A': datosTmp.ij2('Automatico', i, 1); break;
			default: datosTmp .ij2('', i, 1);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeParamClienViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeParamClienChoiceColumn) + "</A>",
			i, maeParamClienChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeParamClienList.setDatos(datosTmp.filtrar([0,1],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeParamClienTimeStamps = datosTmp.filtrar([2],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeParamClienMorePagesFlag = true;
		maeParamClienList.eliminar(mmgPageSize, 1);
	}else{
		maeParamClienMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeParamClienFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeParamClienListLayer', 'V');
	visibilidad('maeParamClienListButtonsLayer', 'V');
	visibilidad('maeParamClienPreListLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeParamClienList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeParamClienList.display();
	
	//Actualizamos el estado de los botones 
	if(maeParamClienMorePagesFlag){
		set_estado_botonera('maeParamClienPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeParamClienPaginationButtonBar',
			3,"inactivo");
	}
	if(maeParamClienPageCount > 1){
		set_estado_botonera('maeParamClienPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeParamClienPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeParamClienPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeParamClienPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeParamClienUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeParamClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeParamClienFrm.idSelection', maeParamClienList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeParamClienFrm', true);
	if(validacion){
		/*set('maeParamClienFrm.previousAction', 'update');
		set('maeParamClienFrm.ON', 'MaeParamClienLPStartUp');
		set('maeParamClienFrm.conectorAction', 'MaeParamClienLPStartUp');
		set('maeParamClienFrm.origen', 'pagina');
		envia('maeParamClienFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = maeParamClienList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeParamClienFrm.accion');
		parametros["accion"] = get('maeParamClienFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('MaeParamClienLPStartUp', get('maeParamClienFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) maeParamClienCmdRequery();
	}
}

function maeParamClienRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeParamClienList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeParamClienList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeParamClienFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeParamClienList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeParamClienTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeParamClienFrm.timestamp', timestamps);
	envia('maeParamClienFrm');
}

function maeParamClienViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeParamClienList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('maeParamClienFrm.previousAction', get('maeParamClienFrm.accion'));
	set('maeParamClienFrm.accion', 'view');
	set('maeParamClienFrm.origen', 'pagina');
	set('maeParamClienFrm.ON', 'MaeParamClienLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('maeParamClienFrm.idSelection', maeParamClienList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('maeParamClienFrm');
	maeParamClienViewDetail(maeParamClienList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeParamClienViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeParamClienFrm.accion');
	parametros["accion"] = get('maeParamClienFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('MaeParamClienLPStartUp', get('maeParamClienFrm.accion'), parametros, null, sizeFormView + 30);
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
	var validacion = ValidaForm('maeParamClienFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
		
	
	if(validacion)envia('maeParamClienFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeParamClienRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeParamClienFrm.accion');
	var origenTmp = get('maeParamClienFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeParamClienBuildUpdateRecordString() != maeParamClienTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('maeParamClienFrm.performRequery', 'true');
		set('maeParamClienFrm.accion', 
			get('maeParamClienFrm.previousAction'));
		set('maeParamClienFrm.origen', 'menu');
		set('maeParamClienFrm.ON', 'MaeParamClienLPStartUp');
		set('maeParamClienFrm.conectorAction', 'MaeParamClienLPStartUp');
		maeParamClienFrm.oculto='N';
		envia('maeParamClienFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.maeParamClienListLayer.style.display='none';
	document.all.maeParamClienListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeParamClienListLayer.style.display='';
	document.all.maeParamClienListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda

	jsMaeParamClienCodTipoAsig = get('maeParamClienFrm.codTipoAsig')[0];






	var parametros = "";
	parametros += jsMaeParamClienCodTipoAsig + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeParamClienBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeParamClienFrm.accion'), 
		get('maeParamClienFrm.origen'));
	
	jsMaeParamClienId = get('maeParamClienFrm.id').toString();
	jsMaeParamClienPaisOidPais = get('maeParamClienFrm.paisOidPais')[0];
	jsMaeParamClienTiclOidTipoClie = get('maeParamClienFrm.ticlOidTipoClie').toString();
	jsMaeParamClienCodTipoAsig = get('maeParamClienFrm.codTipoAsig')[0];

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeParamClienFrm.accion'), 
		get('maeParamClienFrm.origen'));


	set('maeParamClienFrm.id', jsMaeParamClienId);
	set('maeParamClienFrm.paisOidPais', [jsMaeParamClienPaisOidPais]);
	set('maeParamClienFrm.ticlOidTipoClie', jsMaeParamClienTiclOidTipoClie);
	set('maeParamClienFrm.codTipoAsig', [jsMaeParamClienCodTipoAsig]);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeParamClienFrm.errCodigo', errorCode);
	set('maeParamClienFrm.errDescripcion', description);
	set('maeParamClienFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
