

/*
    INDRA/CAR/mmg
    $Id: maetipovincu.js,v 1.1 2009/12/03 19:02:11 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeTipoVincuId = "";
var jsMaeTipoVincuPaisOidPais = "";
var jsMaeTipoVincuCodTipoVinc = "";
var jsMaeTipoVincuDescripcion = "";
var jsMaeTipoVincuIndReco = "";

//Variables de paginacion, 
var maeTipoVincuPageCount = 1;

//Varible de columna que representa el campo de choice
var maeTipoVincuChoiceColumn = 1;

//Flag de siguiente pagina;
var maeTipoVincuMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeTipoVincuTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeTipoVincuLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("maeTipoVincuFrm.codTipoVinc");','focaliza("maeTipoVincuFrm.codTipoVinc");','focaliza("maeTipoVincuFrm.codTipoVinc");','focaliza("maeTipoVincuFrm.codTipoVinc");','focaliza("maeTipoVincuFrm.codTipoVinc");','focaliza("maeTipoVincuFrm.codTipoVinc");'],[4,'focaliza("maeTipoVincuFrm.Descripcion");','focaliza("maeTipoVincuFrm.Descripcion");','focaliza("maeTipoVincuFrm.Descripcion");','focaliza("maeTipoVincuFrm.Descripcion");','focaliza("maeTipoVincuFrm.Descripcion");','focaliza("maeTipoVincuFrm.Descripcion");'],[5,'focaliza("maeTipoVincuFrm.indReco");','focaliza("maeTipoVincuFrm.indReco");','focaliza("maeTipoVincuFrm.indReco");','focaliza("maeTipoVincuFrm.indReco");','focaliza("maeTipoVincuFrm.indReco");','focaliza("maeTipoVincuFrm.indReco");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'focaliza("maeTipoVincuFrm.Descripcion");','focaliza("maeTipoVincuFrm.Descripcion");','focaliza("maeTipoVincuFrm.Descripcion");','focaliza("maeTipoVincuFrm.Descripcion");','focaliza("maeTipoVincuFrm.Descripcion");','focaliza("maeTipoVincuFrm.Descripcion");'],[5,'focaliza("maeTipoVincuFrm.indReco");','focaliza("maeTipoVincuFrm.indReco");','focaliza("maeTipoVincuFrm.indReco");','focaliza("maeTipoVincuFrm.indReco");','focaliza("maeTipoVincuFrm.indReco");','focaliza("maeTipoVincuFrm.indReco");']]);

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

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeTipoVincuLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeTipoVincuTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeTipoVincuInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeTipoVincuFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeTipoVincuFrm.accion')){
		case "query": maeTipoVincuQueryInitComponents(); break;
		case "view": maeTipoVincuViewInitComponents(); break;
		case "create": maeTipoVincuCreateInitComponents(); break;
		case "update": maeTipoVincuUpdateInitComponents(); break;
		case "remove": maeTipoVincuRemoveInitComponents(); break;
		case "lov": maeTipoVincuLovInitComponents(); break;
	}
	//alert('accion :' + get('maeTipoVincuFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeTipoVincuFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeTipoVincu')) maeTipoVincuCmdRequery();
}

function maeTipoVincuQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	focusFirstField('maeTipoVincuFrm', true);	
}

function maeTipoVincuViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeTipoVincuFrm', 'Descripcion', 1);
	
		
	//Establecemos el valor de los radiobuttons
		set('maeTipoVincuFrm.indReco', get('maeTipoVincuFrm.indRecoCheckValue'));
		
	focusFirstField('maeTipoVincuFrm', true);
}

function maeTipoVincuCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeTipoVincuFrm.codTipoVinc','S', GestionarMensaje('MaeTipoVincu.codTipoVinc.requiered.message'));
	
	setMV('maeTipoVincuFrm.Descripcion','S', GestionarMensaje('MaeTipoVincu.Descripcion.requiered.message'));
	
	setMV('maeTipoVincuFrm.indReco','S', GestionarMensaje('MaeTipoVincu.indReco.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeTipoVincuFrm', true);
}

function maeTipoVincuUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeTipoVincuFrm.origen') == "pagina"){
		loadLocalizationWidget('maeTipoVincuFrm', 'Descripcion', 1);
		

		//Establecemos el valor de los radiobuttons
			set('maeTipoVincuFrm.indReco', get('maeTipoVincuFrm.indRecoCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		maeTipoVincuTmpUpdateValues = maeTipoVincuBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeTipoVincuFrm.codTipoVinc','S', GestionarMensaje('MaeTipoVincu.codTipoVinc.requiered.message'));
		setMV('maeTipoVincuFrm.Descripcion','S', GestionarMensaje('MaeTipoVincu.Descripcion.requiered.message'));
		setMV('maeTipoVincuFrm.indReco','S', GestionarMensaje('MaeTipoVincu.indReco.requiered.message'));
		
			focusFirstFieldModify('maeTipoVincuFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		focusFirstField('maeTipoVincuFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeTipoVincuFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeTipoVincuRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeTipoVincuList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeTipoVincuFrm', true);
}

function maeTipoVincuLovInitComponents(){
	maeTipoVincuLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeTipoVincuFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function maeTipoVincuSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeTipoVincuFrm.' + campo, id);
	set('maeTipoVincuFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeTipoVincuLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeTipoVincuLovReturnParameters.id = '';
	maeTipoVincuLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeTipoVincuLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoVincuList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeTipoVincuList.codSeleccionados();
	var descripcion = maeTipoVincuList.extraeDato(
		maeTipoVincuList.codSeleccionados()[0], maeTipoVincuChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeTipoVincuLovReturnParameters.id = codigo;
	maeTipoVincuLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeTipoVincuCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeTipoVincuFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeTipoVincuFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeTipoVincuList", "MaeTipoVincuConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeTipoVincuPostQueryActions(datos);"]], "", "");	
}

function maeTipoVincuCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeTipoVincuFrm.lastQueryToSession'));
	var i =0;
	set('maeTipoVincuFrm.codTipoVinc', paramsRequery.ij(i++));
	
	set('maeTipoVincuFrm.Descripcion', paramsRequery.ij(i++));
	
	set('maeTipoVincuFrm.indReco', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeTipoVincuPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeTipoVincuCmdQuery(maeTipoVincuPageCount);
}

function maeTipoVincuFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeTipoVincuPageCount = 1;
	maeTipoVincuCmdQuery(maeTipoVincuPageCount);
}

function maeTipoVincuPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoVincuLastQuery){
		maeTipoVincuFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeTipoVincuPageCount--;
	maeTipoVincuCmdQuery(maeTipoVincuPageCount);
}

function maeTipoVincuNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeTipoVincuLastQuery){
		maeTipoVincuFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeTipoVincuPageCount++;
	maeTipoVincuCmdQuery(maeTipoVincuPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeTipoVincuPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeTipoVincuListLayer', 'O');
		visibilidad('maeTipoVincuListButtonsLayer', 'O');
		if(get('maeTipoVincuFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeTipoVincuLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 3)){
			case '1': datosTmp.ij2(GestionarMensaje('MaeTipoVincu.indReco.1.value'), i, 3); break;
			case '0': datosTmp.ij2(GestionarMensaje('MaeTipoVincu.indReco.0.value'), i, 3); break;
			default: datosTmp .ij2('', i, 3);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeTipoVincuViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeTipoVincuChoiceColumn) + "</A>",
			i, maeTipoVincuChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeTipoVincuList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeTipoVincuTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeTipoVincuMorePagesFlag = true;
		maeTipoVincuList.eliminar(mmgPageSize, 1);
	}else{
		maeTipoVincuMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeTipoVincuFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeTipoVincuListLayer', 'V');
	visibilidad('maeTipoVincuListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeTipoVincuList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeTipoVincuList.display();
	
	//Actualizamos el estado de los botones 
	if(maeTipoVincuMorePagesFlag){
		set_estado_botonera('maeTipoVincuPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeTipoVincuPaginationButtonBar',
			3,"inactivo");
	}
	if(maeTipoVincuPageCount > 1){
		set_estado_botonera('maeTipoVincuPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeTipoVincuPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeTipoVincuPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeTipoVincuPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeTipoVincuUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoVincuList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeTipoVincuFrm.idSelection', maeTipoVincuList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeTipoVincuFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeTipoVincuList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeTipoVincuFrm.accion');
		parametros["accion"] = get('maeTipoVincuFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeTipoVincuLPStartUp', get('maeTipoVincuFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeTipoVincuCmdRequery();
	}
}

function maeTipoVincuRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoVincuList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeTipoVincuList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeTipoVincuFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeTipoVincuList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeTipoVincuTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeTipoVincuFrm.timestamp', timestamps);


	maeTipoVincuFrm.oculto='S';
	envia('maeTipoVincuFrm');
	maeTipoVincuFrm.oculto='N';
}

function maeTipoVincuViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeTipoVincuList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeTipoVincuViewDetail(maeTipoVincuList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeTipoVincuViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeTipoVincuFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeTipoVincuLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeTipoVincuFrm', 
		'Descripcion', 1,
		get('maeTipoVincuFrm.Descripcion'));	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeTipoVincuFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeTipoVincuFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeTipoVincu.Descripcion.requiered.message'));
		focaliza('maeTipoVincuFrm.Descripcion');
		return;
	}	
	
	
		
	
	if(validacion){
		maeTipoVincuFrm.oculto='S';
		envia('maeTipoVincuFrm');
		maeTipoVincuFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeTipoVincuFrm.paisOidPais').toString() == ''){
		set('maeTipoVincuFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'maeTipoVincu');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeTipoVincuRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeTipoVincuFrm.accion');
	var origenTmp = get('maeTipoVincuFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeTipoVincuBuildUpdateRecordString() != maeTipoVincuTmpUpdateValues){
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
	document.all.maeTipoVincuListLayer.style.display='none';
	document.all.maeTipoVincuListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeTipoVincuListLayer.style.display='';
	document.all.maeTipoVincuListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeTipoVincuCodTipoVinc = get('maeTipoVincuFrm.codTipoVinc').toString();
	jsMaeTipoVincuDescripcion = get('maeTipoVincuFrm.Descripcion').toString();
	jsMaeTipoVincuIndReco = get('maeTipoVincuFrm.indReco');
	
	
	var parametros = "";
	parametros += jsMaeTipoVincuCodTipoVinc + "|";
	parametros += jsMaeTipoVincuDescripcion + "|";
	parametros += jsMaeTipoVincuIndReco + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeTipoVincuBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeTipoVincuCodTipoVinc + "|";
	parametros += jsMaeTipoVincuDescripcion + "|";
	parametros += jsMaeTipoVincuIndReco + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoVincuFrm.accion'), 
		get('maeTipoVincuFrm.origen'));
	
	jsMaeTipoVincuId = get('maeTipoVincuFrm.id').toString();
	jsMaeTipoVincuPaisOidPais = get('maeTipoVincuFrm.paisOidPais')[0];
	jsMaeTipoVincuCodTipoVinc = get('maeTipoVincuFrm.codTipoVinc').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeTipoVincuDescripcion = buildLocalizedString('maeTipoVincuFrm', 1);
	}else{
		jsMaeTipoVincuDescripcion = get('maeTipoVincuFrm.Descripcion');
	}
	jsMaeTipoVincuIndReco = get('maeTipoVincuFrm.indReco');
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeTipoVincuFrm.accion'), 
		get('maeTipoVincuFrm.origen'));


	set('maeTipoVincuFrm.id', jsMaeTipoVincuId);
	set('maeTipoVincuFrm.paisOidPais', [jsMaeTipoVincuPaisOidPais]);
	set('maeTipoVincuFrm.codTipoVinc', jsMaeTipoVincuCodTipoVinc);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeTipoVincuFrm', 1,  jsMaeTipoVincuDescripcion)
		loadLocalizationWidget('maeTipoVincuFrm', 'Descripcion', 1);
	}else{
		set('maeTipoVincuFrm.Descripcion', jsMaeTipoVincuDescripcion);		
	}
	set('maeTipoVincuFrm.indReco', jsMaeTipoVincuIndReco);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeTipoVincuCodTipoVinc = '';
	jsMaeTipoVincuDescripcion = '';
	jsMaeTipoVincuIndReco = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeTipoVincuFrm.errCodigo', errorCode);
	set('maeTipoVincuFrm.errDescripcion', description);
	set('maeTipoVincuFrm.errSeverity', severity);
	fMostrarMensajeError();
}
