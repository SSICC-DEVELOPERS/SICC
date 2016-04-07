

/*
    INDRA/CAR/mmg
    $Id: pedatribespec.js,v 1.1 2009/12/03 19:01:54 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPedAtribEspecId = "";
var jsPedAtribEspecCodAtri = "";
var jsPedAtribEspecDesAtri = "";
var jsPedAtribEspecValForm = "";
var jsPedAtribEspecModuOidModu = "";

//Variables de paginacion, 
var pedAtribEspecPageCount = 1;

//Varible de columna que representa el campo de choice
var pedAtribEspecChoiceColumn = 1;

//Flag de siguiente pagina;
var pedAtribEspecMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var pedAtribEspecTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 231;
var sizeFormView = 217;
var sizeFormUpdate = 217;

//Ultima busqueda realizada
var pedAtribEspecLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("pedAtribEspecFrm.codAtri");','focaliza("pedAtribEspecFrm.codAtri");','focaliza("pedAtribEspecFrm.codAtri");','focaliza("pedAtribEspecFrm.codAtri");','focaliza("pedAtribEspecFrm.codAtri");','focaliza("pedAtribEspecFrm.codAtri");'],[3,'focaliza("pedAtribEspecFrm.desAtri");','focaliza("pedAtribEspecFrm.desAtri");','focaliza("pedAtribEspecFrm.desAtri");','focaliza("pedAtribEspecFrm.desAtri");','focaliza("pedAtribEspecFrm.desAtri");','focaliza("pedAtribEspecFrm.desAtri");'],[4,'focaliza("pedAtribEspecFrm.valForm");','focaliza("pedAtribEspecFrm.valForm");','focaliza("pedAtribEspecFrm.valForm");','focaliza("pedAtribEspecFrm.valForm");','focaliza("pedAtribEspecFrm.valForm");','focaliza("pedAtribEspecFrm.valForm");'],[5,'focalizaComboDependence("pedAtribEspec","moduOidModu", false);','focalizaComboDependence("pedAtribEspec","moduOidModu", false);','focalizaComboDependence("pedAtribEspec","moduOidModu", false);','focalizaComboDependence("pedAtribEspec","moduOidModu", true);','focalizaComboDependence("pedAtribEspec","moduOidModu", true);','focalizaComboDependence("pedAtribEspec","moduOidModu", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("pedAtribEspecFrm.codAtri");','focaliza("pedAtribEspecFrm.codAtri");','focaliza("pedAtribEspecFrm.codAtri");','focaliza("pedAtribEspecFrm.codAtri");','focaliza("pedAtribEspecFrm.codAtri");','focaliza("pedAtribEspecFrm.codAtri");'],[3,'focaliza("pedAtribEspecFrm.desAtri");','focaliza("pedAtribEspecFrm.desAtri");','focaliza("pedAtribEspecFrm.desAtri");','focaliza("pedAtribEspecFrm.desAtri");','focaliza("pedAtribEspecFrm.desAtri");','focaliza("pedAtribEspecFrm.desAtri");'],[4,'focaliza("pedAtribEspecFrm.valForm");','focaliza("pedAtribEspecFrm.valForm");','focaliza("pedAtribEspecFrm.valForm");','focaliza("pedAtribEspecFrm.valForm");','focaliza("pedAtribEspecFrm.valForm");','focaliza("pedAtribEspecFrm.valForm");'],[5,'focalizaComboDependence("pedAtribEspec","moduOidModu", false);','focalizaComboDependence("pedAtribEspec","moduOidModu", false);','focalizaComboDependence("pedAtribEspec","moduOidModu", false);','focalizaComboDependence("pedAtribEspec","moduOidModu", true);','focalizaComboDependence("pedAtribEspec","moduOidModu", true);','focalizaComboDependence("pedAtribEspec","moduOidModu", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var moduOidModuDependeceMap = new Vector();
moduOidModuDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
moduOidModuDependeceMap.agregar(['moduOidModu', padresTmp, '', 'SegModul']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
pedAtribEspecLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var pedAtribEspecTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function pedAtribEspecInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('pedAtribEspecFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('pedAtribEspecFrm.accion')){
		case "query": pedAtribEspecQueryInitComponents(); break;
		case "view": pedAtribEspecViewInitComponents(); break;
		case "create": pedAtribEspecCreateInitComponents(); break;
		case "update": pedAtribEspecUpdateInitComponents(); break;
		case "remove": pedAtribEspecRemoveInitComponents(); break;
		case "lov": pedAtribEspecLovInitComponents(); break;
	}
	//alert('accion :' + get('pedAtribEspecFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('pedAtribEspecFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('pedAtribEspec')) pedAtribEspecCmdRequery();
}

function pedAtribEspecQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	focusFirstField('pedAtribEspecFrm', true);	
}

function pedAtribEspecViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('pedAtribEspecFrm', true);
}

function pedAtribEspecCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('pedAtribEspecFrm.codAtri','S', GestionarMensaje('PedAtribEspec.codAtri.requiered.message'));
	
	setMV('pedAtribEspecFrm.desAtri','S', GestionarMensaje('PedAtribEspec.desAtri.requiered.message'));
	
	setMV('pedAtribEspecFrm.moduOidModu','S', GestionarMensaje('PedAtribEspec.moduOidModu.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('pedAtribEspecFrm', true);
}

function pedAtribEspecUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('pedAtribEspecFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		pedAtribEspecTmpUpdateValues = pedAtribEspecBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('pedAtribEspecFrm.codAtri','S', GestionarMensaje('PedAtribEspec.codAtri.requiered.message'));
		setMV('pedAtribEspecFrm.desAtri','S', GestionarMensaje('PedAtribEspec.desAtri.requiered.message'));
		setMV('pedAtribEspecFrm.moduOidModu','S', GestionarMensaje('PedAtribEspec.moduOidModu.requiered.message'));
		
			focusFirstFieldModify('pedAtribEspecFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		focusFirstField('pedAtribEspecFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('pedAtribEspecFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function pedAtribEspecRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	pedAtribEspecList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('pedAtribEspecFrm', true);
}

function pedAtribEspecLovInitComponents(){
	pedAtribEspecLovReturnParameters = window.dialogArguments;
	
	focusFirstField('pedAtribEspecFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







//Función que permite cargar los datos de un elemento de lov seleccionado
function pedAtribEspecSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('pedAtribEspecFrm.' + campo, id);
	set('pedAtribEspecFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function pedAtribEspecLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	pedAtribEspecLovReturnParameters.id = '';
	pedAtribEspecLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function pedAtribEspecLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedAtribEspecList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = pedAtribEspecList.codSeleccionados();
	var descripcion = pedAtribEspecList.extraeDato(
		pedAtribEspecList.codSeleccionados()[0], pedAtribEspecChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	pedAtribEspecLovReturnParameters.id = codigo;
	pedAtribEspecLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function pedAtribEspecCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('pedAtribEspecFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('pedAtribEspecFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "pedAtribEspecList", "PedAtribEspecConectorTransactionQuery", 
		"result_ROWSET", parametros, "pedAtribEspecPostQueryActions(datos);"]], "", "");	
}

function pedAtribEspecCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('pedAtribEspecFrm.lastQueryToSession'));
	var i =0;
	set('pedAtribEspecFrm.codAtri', paramsRequery.ij(i++));
	
	set('pedAtribEspecFrm.desAtri', paramsRequery.ij(i++));
	
	set('pedAtribEspecFrm.valForm', paramsRequery.ij(i++));
	
	set('pedAtribEspecFrm.moduOidModu', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	pedAtribEspecPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	pedAtribEspecCmdQuery(pedAtribEspecPageCount);
}

function pedAtribEspecFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	pedAtribEspecPageCount = 1;
	pedAtribEspecCmdQuery(pedAtribEspecPageCount);
}

function pedAtribEspecPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedAtribEspecLastQuery){
		pedAtribEspecFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	pedAtribEspecPageCount--;
	pedAtribEspecCmdQuery(pedAtribEspecPageCount);
}

function pedAtribEspecNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedAtribEspecLastQuery){
		pedAtribEspecFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	pedAtribEspecPageCount++;
	pedAtribEspecCmdQuery(pedAtribEspecPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function pedAtribEspecPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('pedAtribEspecListLayer', 'O');
		visibilidad('pedAtribEspecListButtonsLayer', 'O');
		if(get('pedAtribEspecFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	pedAtribEspecLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:pedAtribEspecViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, pedAtribEspecChoiceColumn) + "</A>",
			i, pedAtribEspecChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	pedAtribEspecList.setDatos(datosTmp.filtrar([0,1,2,3,4],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	pedAtribEspecTimeStamps = datosTmp.filtrar([5],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		pedAtribEspecMorePagesFlag = true;
		pedAtribEspecList.eliminar(mmgPageSize, 1);
	}else{
		pedAtribEspecMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('pedAtribEspecFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('pedAtribEspecListLayer', 'V');
	visibilidad('pedAtribEspecListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('pedAtribEspecList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	pedAtribEspecList.display();
	
	//Actualizamos el estado de los botones 
	if(pedAtribEspecMorePagesFlag){
		set_estado_botonera('pedAtribEspecPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('pedAtribEspecPaginationButtonBar',
			3,"inactivo");
	}
	if(pedAtribEspecPageCount > 1){
		set_estado_botonera('pedAtribEspecPaginationButtonBar',
			2,"activo");
		set_estado_botonera('pedAtribEspecPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('pedAtribEspecPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('pedAtribEspecPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function pedAtribEspecUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedAtribEspecList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('pedAtribEspecFrm.idSelection', pedAtribEspecList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('pedAtribEspecFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = pedAtribEspecList.codSeleccionados()[0];
		parametros["previousAction"] = get('pedAtribEspecFrm.accion');
		parametros["accion"] = get('pedAtribEspecFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PedAtribEspecLPStartUp', get('pedAtribEspecFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) pedAtribEspecCmdRequery();
	}
}

function pedAtribEspecRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedAtribEspecList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = pedAtribEspecList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('pedAtribEspecFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(pedAtribEspecList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += pedAtribEspecTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('pedAtribEspecFrm.timestamp', timestamps);


	pedAtribEspecFrm.oculto='S';
	envia('pedAtribEspecFrm');
	pedAtribEspecFrm.oculto='N';
}

function pedAtribEspecViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedAtribEspecList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	pedAtribEspecViewDetail(pedAtribEspecList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function pedAtribEspecViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('pedAtribEspecFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PedAtribEspecLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('pedAtribEspecFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
		
	
	if(validacion){
		pedAtribEspecFrm.oculto='S';
		envia('pedAtribEspecFrm');
		pedAtribEspecFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('pedAtribEspecFrm.moduOidModu').toString() == ''){
		set('pedAtribEspecFrm.moduOidModu', []);
		mmgResetCombosOnCascade('moduOidModu', 'moduOidModu', 'pedAtribEspec');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	pedAtribEspecRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('pedAtribEspecFrm.accion');
	var origenTmp = get('pedAtribEspecFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(pedAtribEspecBuildUpdateRecordString() != pedAtribEspecTmpUpdateValues){
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
	document.all.pedAtribEspecListLayer.style.display='none';
	document.all.pedAtribEspecListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.pedAtribEspecListLayer.style.display='';
	document.all.pedAtribEspecListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPedAtribEspecCodAtri = get('pedAtribEspecFrm.codAtri').toString();
	jsPedAtribEspecDesAtri = get('pedAtribEspecFrm.desAtri').toString();
	jsPedAtribEspecValForm = get('pedAtribEspecFrm.valForm').toString();
	jsPedAtribEspecModuOidModu = get('pedAtribEspecFrm.moduOidModu')[0];
	
	
	var parametros = "";
	parametros += jsPedAtribEspecCodAtri + "|";
	parametros += jsPedAtribEspecDesAtri + "|";
	parametros += jsPedAtribEspecValForm + "|";
	parametros += jsPedAtribEspecModuOidModu + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function pedAtribEspecBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPedAtribEspecCodAtri + "|";
	parametros += jsPedAtribEspecDesAtri + "|";
	parametros += jsPedAtribEspecValForm + "|";
	parametros += jsPedAtribEspecModuOidModu + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedAtribEspecFrm.accion'), 
		get('pedAtribEspecFrm.origen'));
	
	jsPedAtribEspecId = get('pedAtribEspecFrm.id').toString();
	jsPedAtribEspecCodAtri = get('pedAtribEspecFrm.codAtri').toString();
	jsPedAtribEspecDesAtri = get('pedAtribEspecFrm.desAtri').toString();
	jsPedAtribEspecValForm = get('pedAtribEspecFrm.valForm').toString();
	jsPedAtribEspecModuOidModu = get('pedAtribEspecFrm.moduOidModu')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedAtribEspecFrm.accion'), 
		get('pedAtribEspecFrm.origen'));


	set('pedAtribEspecFrm.id', jsPedAtribEspecId);
	set('pedAtribEspecFrm.codAtri', jsPedAtribEspecCodAtri);
	set('pedAtribEspecFrm.desAtri', jsPedAtribEspecDesAtri);
	set('pedAtribEspecFrm.valForm', jsPedAtribEspecValForm);
	set('pedAtribEspecFrm.moduOidModu', [jsPedAtribEspecModuOidModu]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPedAtribEspecCodAtri = '';
	jsPedAtribEspecDesAtri = '';
	jsPedAtribEspecValForm = '';
	jsPedAtribEspecModuOidModu = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('pedAtribEspecFrm.errCodigo', errorCode);
	set('pedAtribEspecFrm.errDescripcion', description);
	set('pedAtribEspecFrm.errSeverity', severity);
	fMostrarMensajeError();
}
