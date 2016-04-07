

/*
    INDRA/CAR/mmg
    $Id: maeciclovidatapon.js,v 1.1 2009/12/03 19:02:13 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeCicloVidaTaponId = "";
var jsMaeCicloVidaTaponPaisOidPais = "";
var jsMaeCicloVidaTaponCodCiclVida = "";
var jsMaeCicloVidaTaponDescripcion = "";

//Variables de paginacion, 
var maeCicloVidaTaponPageCount = 1;

//Varible de columna que representa el campo de choice
var maeCicloVidaTaponChoiceColumn = 1;

//Flag de siguiente pagina;
var maeCicloVidaTaponMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeCicloVidaTaponTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var maeCicloVidaTaponLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("maeCicloVidaTaponFrm.codCiclVida");','focaliza("maeCicloVidaTaponFrm.codCiclVida");','','focaliza("maeCicloVidaTaponFrm.codCiclVida");','focaliza("maeCicloVidaTaponFrm.codCiclVida");',''],[4,'focaliza("maeCicloVidaTaponFrm.Descripcion");','focaliza("maeCicloVidaTaponFrm.Descripcion");','focaliza("maeCicloVidaTaponFrm.Descripcion");','focaliza("maeCicloVidaTaponFrm.Descripcion");','focaliza("maeCicloVidaTaponFrm.Descripcion");','focaliza("maeCicloVidaTaponFrm.Descripcion");']]);

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
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMoneAlt', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMone', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar(['paisOidPais_fopaOidFormPago','paisOidPais_moneOidMoneAlt','paisOidPais_moneOidMone'])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPais']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeCicloVidaTaponLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeCicloVidaTaponTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function maeCicloVidaTaponInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeCicloVidaTaponFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeCicloVidaTaponFrm.accion')){
		case "query": maeCicloVidaTaponQueryInitComponents(); break;
		case "view": maeCicloVidaTaponViewInitComponents(); break;
		case "create": maeCicloVidaTaponCreateInitComponents(); break;
		case "update": maeCicloVidaTaponUpdateInitComponents(); break;
		case "remove": maeCicloVidaTaponRemoveInitComponents(); break;
		case "lov": maeCicloVidaTaponLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('maeCicloVidaTaponFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeCicloVidaTapon')) maeCicloVidaTaponCmdRequery();
}

function maeCicloVidaTaponQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
}

function maeCicloVidaTaponViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('maeCicloVidaTaponFrm', 'Descripcion', 1);
	
		
	
}

function maeCicloVidaTaponCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeCicloVidaTaponFrm.codCiclVida','S', GestionarMensaje('MaeCicloVidaTapon.codCiclVida.requiered.message'));
	
	setMV('maeCicloVidaTaponFrm.Descripcion','S', GestionarMensaje('MaeCicloVidaTapon.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function maeCicloVidaTaponUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeCicloVidaTaponFrm.origen') == "pagina"){
		loadLocalizationWidget('maeCicloVidaTaponFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		maeCicloVidaTaponTmpUpdateValues = maeCicloVidaTaponBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeCicloVidaTaponFrm.Descripcion','S', GestionarMensaje('MaeCicloVidaTapon.Descripcion.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeCicloVidaTaponFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeCicloVidaTaponRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeCicloVidaTaponList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function maeCicloVidaTaponLovInitComponents(){
	maeCicloVidaTaponLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function maeCicloVidaTaponSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeCicloVidaTaponFrm.' + campo, id);
	set('maeCicloVidaTaponFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeCicloVidaTaponLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeCicloVidaTaponLovReturnParameters.id = '';
	maeCicloVidaTaponLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeCicloVidaTaponLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCicloVidaTaponList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeCicloVidaTaponList.codSeleccionados();
	var descripcion = maeCicloVidaTaponList.extraeDato(
		maeCicloVidaTaponList.codSeleccionados()[0], maeCicloVidaTaponChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeCicloVidaTaponLovReturnParameters.id = codigo;
	maeCicloVidaTaponLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeCicloVidaTaponCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeCicloVidaTaponFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeCicloVidaTaponFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeCicloVidaTaponList", "MaeCicloVidaTaponConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeCicloVidaTaponPostQueryActions(datos);"]], "", "");	
}

function maeCicloVidaTaponCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeCicloVidaTaponFrm.lastQueryToSession'));
	var i =0;
	set('maeCicloVidaTaponFrm.codCiclVida', paramsRequery.ij(i++));
	
	set('maeCicloVidaTaponFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeCicloVidaTaponPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeCicloVidaTaponCmdQuery(maeCicloVidaTaponPageCount);
}

function maeCicloVidaTaponFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeCicloVidaTaponPageCount = 1;
	maeCicloVidaTaponCmdQuery(maeCicloVidaTaponPageCount);
}

function maeCicloVidaTaponPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeCicloVidaTaponLastQuery){
		maeCicloVidaTaponFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeCicloVidaTaponPageCount--;
	maeCicloVidaTaponCmdQuery(maeCicloVidaTaponPageCount);
}

function maeCicloVidaTaponNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeCicloVidaTaponLastQuery){
		maeCicloVidaTaponFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeCicloVidaTaponPageCount++;
	maeCicloVidaTaponCmdQuery(maeCicloVidaTaponPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeCicloVidaTaponPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeCicloVidaTaponListLayer', 'O');
		visibilidad('maeCicloVidaTaponListButtonsLayer', 'O');
		if(get('maeCicloVidaTaponFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeCicloVidaTaponLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeCicloVidaTaponViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeCicloVidaTaponChoiceColumn) + "</A>",
			i, maeCicloVidaTaponChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeCicloVidaTaponList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeCicloVidaTaponTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeCicloVidaTaponMorePagesFlag = true;
		maeCicloVidaTaponList.eliminar(mmgPageSize, 1);
	}else{
		maeCicloVidaTaponMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeCicloVidaTaponFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeCicloVidaTaponListLayer', 'V');
	visibilidad('maeCicloVidaTaponListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeCicloVidaTaponList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeCicloVidaTaponList.display();
	
	//Actualizamos el estado de los botones 
	if(maeCicloVidaTaponMorePagesFlag){
		set_estado_botonera('maeCicloVidaTaponPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeCicloVidaTaponPaginationButtonBar',
			3,"inactivo");
	}
	if(maeCicloVidaTaponPageCount > 1){
		set_estado_botonera('maeCicloVidaTaponPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeCicloVidaTaponPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeCicloVidaTaponPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeCicloVidaTaponPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeCicloVidaTaponUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCicloVidaTaponList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeCicloVidaTaponFrm.idSelection', maeCicloVidaTaponList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeCicloVidaTaponFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeCicloVidaTaponList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeCicloVidaTaponFrm.accion');
		parametros["accion"] = get('maeCicloVidaTaponFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('MaeCicloVidaTaponLPStartUp', get('maeCicloVidaTaponFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) maeCicloVidaTaponCmdRequery();
	}
}

function maeCicloVidaTaponRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCicloVidaTaponList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeCicloVidaTaponList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeCicloVidaTaponFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeCicloVidaTaponList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeCicloVidaTaponTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeCicloVidaTaponFrm.timestamp', timestamps);


	maeCicloVidaTaponFrm.oculto='S';
	envia('maeCicloVidaTaponFrm');
	maeCicloVidaTaponFrm.oculto='N';
}

function maeCicloVidaTaponViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCicloVidaTaponList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeCicloVidaTaponViewDetail(maeCicloVidaTaponList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeCicloVidaTaponViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeCicloVidaTaponFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('MaeCicloVidaTaponLPStartUp', 'view', parametros, null, sizeFormView + 55);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeCicloVidaTaponFrm', 
		'Descripcion', 1,
		get('maeCicloVidaTaponFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeCicloVidaTaponFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeCicloVidaTaponFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeCicloVidaTapon.Descripcion.requiered.message'));
		focaliza('maeCicloVidaTaponFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion){
		maeCicloVidaTaponFrm.oculto='S';
		envia('maeCicloVidaTaponFrm');
		maeCicloVidaTaponFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeCicloVidaTaponFrm.paisOidPais').toString() == ''){
		set('maeCicloVidaTaponFrm.paisOidPais_fopaOidFormPago', []);
		mmgResetCombosOnCascade('paisOidPais_fopaOidFormPago', 'paisOidPais', 'maeCicloVidaTapon');
		set('maeCicloVidaTaponFrm.paisOidPais_moneOidMoneAlt', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMoneAlt', 'paisOidPais', 'maeCicloVidaTapon');
		set('maeCicloVidaTaponFrm.paisOidPais_moneOidMone', []);
		mmgResetCombosOnCascade('paisOidPais_moneOidMone', 'paisOidPais', 'maeCicloVidaTapon');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeCicloVidaTaponRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeCicloVidaTaponFrm.accion');
	var origenTmp = get('maeCicloVidaTaponFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeCicloVidaTaponBuildUpdateRecordString() != maeCicloVidaTaponTmpUpdateValues){
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
	document.all.maeCicloVidaTaponListLayer.style.display='none';
	document.all.maeCicloVidaTaponListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeCicloVidaTaponListLayer.style.display='';
	document.all.maeCicloVidaTaponListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeCicloVidaTaponCodCiclVida = get('maeCicloVidaTaponFrm.codCiclVida').toString();
	jsMaeCicloVidaTaponDescripcion = get('maeCicloVidaTaponFrm.Descripcion').toString();
	
	
	var parametros = "";
	parametros += jsMaeCicloVidaTaponCodCiclVida + "|";
	parametros += jsMaeCicloVidaTaponDescripcion + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeCicloVidaTaponBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeCicloVidaTaponDescripcion + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeCicloVidaTaponFrm.accion'), 
		get('maeCicloVidaTaponFrm.origen'));
	
	jsMaeCicloVidaTaponId = get('maeCicloVidaTaponFrm.id').toString();
	jsMaeCicloVidaTaponPaisOidPais = get('maeCicloVidaTaponFrm.paisOidPais')[0];
	jsMaeCicloVidaTaponCodCiclVida = get('maeCicloVidaTaponFrm.codCiclVida').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeCicloVidaTaponDescripcion = buildLocalizedString('maeCicloVidaTaponFrm', 1);
	}else{
		jsMaeCicloVidaTaponDescripcion = get('maeCicloVidaTaponFrm.Descripcion');
	}
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeCicloVidaTaponFrm.accion'), 
		get('maeCicloVidaTaponFrm.origen'));


	set('maeCicloVidaTaponFrm.id', jsMaeCicloVidaTaponId);
	set('maeCicloVidaTaponFrm.paisOidPais', [jsMaeCicloVidaTaponPaisOidPais]);
	set('maeCicloVidaTaponFrm.codCiclVida', jsMaeCicloVidaTaponCodCiclVida);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeCicloVidaTaponFrm', 1,  jsMaeCicloVidaTaponDescripcion)
		loadLocalizationWidget('maeCicloVidaTaponFrm', 'Descripcion', 1);
	}else{
		set('maeCicloVidaTaponFrm.Descripcion', jsMaeCicloVidaTaponDescripcion);		
	}
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeCicloVidaTaponCodCiclVida = '';
	jsMaeCicloVidaTaponDescripcion = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeCicloVidaTaponFrm.errCodigo', errorCode);
	set('maeCicloVidaTaponFrm.errDescripcion', description);
	set('maeCicloVidaTaponFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
