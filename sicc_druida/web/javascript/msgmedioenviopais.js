

/*
    INDRA/CAR/mmg
    $Id: msgmedioenviopais.js,v 1.1 2009/12/03 19:01:55 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMsgMedioEnvioPaisId = "";
var jsMsgMedioEnvioPaisPaisOidPais = "";
var jsMsgMedioEnvioPaisMeenOidMediEnvi = "";
var jsMsgMedioEnvioPaisCodEsta = "";

//Variables de paginacion, 
var msgMedioEnvioPaisPageCount = 1;

//Varible de columna que representa el campo de choice
var msgMedioEnvioPaisChoiceColumn = 3;

//Flag de siguiente pagina;
var msgMedioEnvioPaisMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var msgMedioEnvioPaisTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 83;
var sizeFormUpdate = 83;

//Ultima busqueda realizada
var msgMedioEnvioPaisLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("msgMedioEnvioPais","paisOidPais", false);','focalizaComboDependence("msgMedioEnvioPais","paisOidPais", false);','focalizaComboDependence("msgMedioEnvioPais","paisOidPais", false);','focalizaComboDependence("msgMedioEnvioPais","paisOidPais", true);','focalizaComboDependence("msgMedioEnvioPais","paisOidPais", true);','focalizaComboDependence("msgMedioEnvioPais","paisOidPais", true);'],[3,'focalizaComboDependence("msgMedioEnvioPais","meenOidMediEnvi", false);','focalizaComboDependence("msgMedioEnvioPais","meenOidMediEnvi", false);','focalizaComboDependence("msgMedioEnvioPais","meenOidMediEnvi", false);','focalizaComboDependence("msgMedioEnvioPais","meenOidMediEnvi", true);','focalizaComboDependence("msgMedioEnvioPais","meenOidMediEnvi", true);','focalizaComboDependence("msgMedioEnvioPais","meenOidMediEnvi", true);'],[4,'','focaliza("msgMedioEnvioPaisFrm.codEsta");','focaliza("msgMedioEnvioPaisFrm.codEsta");','','focaliza("msgMedioEnvioPaisFrm.codEsta");','focaliza("msgMedioEnvioPaisFrm.codEsta");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[4,'','focaliza("msgMedioEnvioPaisFrm.codEsta");','focaliza("msgMedioEnvioPaisFrm.codEsta");','','focaliza("msgMedioEnvioPaisFrm.codEsta");','focaliza("msgMedioEnvioPaisFrm.codEsta");']]);

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
var meenOidMediEnviDependeceMap = new Vector();
meenOidMediEnviDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
meenOidMediEnviDependeceMap.agregar(['meenOidMediEnvi', padresTmp, '', 'MsgMedioEnvio']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
msgMedioEnvioPaisLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var msgMedioEnvioPaisTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function msgMedioEnvioPaisInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('msgMedioEnvioPaisFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('msgMedioEnvioPaisFrm.accion')){
		case "query": msgMedioEnvioPaisQueryInitComponents(); break;
		case "view": msgMedioEnvioPaisViewInitComponents(); break;
		case "create": msgMedioEnvioPaisCreateInitComponents(); break;
		case "update": msgMedioEnvioPaisUpdateInitComponents(); break;
		case "remove": msgMedioEnvioPaisRemoveInitComponents(); break;
		case "lov": msgMedioEnvioPaisLovInitComponents(); break;
	}
	//alert('accion :' + get('msgMedioEnvioPaisFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('msgMedioEnvioPaisFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('msgMedioEnvioPais')) msgMedioEnvioPaisCmdRequery();
}

function msgMedioEnvioPaisQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('msgMedioEnvioPaisFrm', true);	
}

function msgMedioEnvioPaisViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	//Establecemos el valor de los radiobuttons
		set('msgMedioEnvioPaisFrm.codEsta', get('msgMedioEnvioPaisFrm.codEstaCheckValue'));
		
	focusFirstField('msgMedioEnvioPaisFrm', true);
}

function msgMedioEnvioPaisCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('msgMedioEnvioPaisFrm.paisOidPais','S', GestionarMensaje('MsgMedioEnvioPais.paisOidPais.requiered.message'));
	
	setMV('msgMedioEnvioPaisFrm.meenOidMediEnvi','S', GestionarMensaje('MsgMedioEnvioPais.meenOidMediEnvi.requiered.message'));
	
	setMV('msgMedioEnvioPaisFrm.codEsta','S', GestionarMensaje('MsgMedioEnvioPais.codEsta.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('msgMedioEnvioPaisFrm', true);
}

function msgMedioEnvioPaisUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('msgMedioEnvioPaisFrm.origen') == "pagina"){
		

		//Establecemos el valor de los radiobuttons
			set('msgMedioEnvioPaisFrm.codEsta', get('msgMedioEnvioPaisFrm.codEstaCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		msgMedioEnvioPaisTmpUpdateValues = msgMedioEnvioPaisBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('msgMedioEnvioPaisFrm.paisOidPais','S', GestionarMensaje('MsgMedioEnvioPais.paisOidPais.requiered.message'));
		setMV('msgMedioEnvioPaisFrm.meenOidMediEnvi','S', GestionarMensaje('MsgMedioEnvioPais.meenOidMediEnvi.requiered.message'));
		setMV('msgMedioEnvioPaisFrm.codEsta','S', GestionarMensaje('MsgMedioEnvioPais.codEsta.requiered.message'));
		
			focusFirstFieldModify('msgMedioEnvioPaisFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('msgMedioEnvioPaisFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('msgMedioEnvioPaisFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function msgMedioEnvioPaisRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	msgMedioEnvioPaisList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('msgMedioEnvioPaisFrm', true);
}

function msgMedioEnvioPaisLovInitComponents(){
	msgMedioEnvioPaisLovReturnParameters = window.dialogArguments;
	
	focusFirstField('msgMedioEnvioPaisFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function msgMedioEnvioPaisSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('msgMedioEnvioPaisFrm.' + campo, id);
	set('msgMedioEnvioPaisFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function msgMedioEnvioPaisLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	msgMedioEnvioPaisLovReturnParameters.id = '';
	msgMedioEnvioPaisLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function msgMedioEnvioPaisLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(msgMedioEnvioPaisList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = msgMedioEnvioPaisList.codSeleccionados();
	var descripcion = msgMedioEnvioPaisList.extraeDato(
		msgMedioEnvioPaisList.codSeleccionados()[0], msgMedioEnvioPaisChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	msgMedioEnvioPaisLovReturnParameters.id = codigo;
	msgMedioEnvioPaisLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function msgMedioEnvioPaisCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('msgMedioEnvioPaisFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('msgMedioEnvioPaisFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "msgMedioEnvioPaisList", "MsgMedioEnvioPaisConectorTransactionQuery", 
		"result_ROWSET", parametros, "msgMedioEnvioPaisPostQueryActions(datos);"]], "", "");	
}

function msgMedioEnvioPaisCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('msgMedioEnvioPaisFrm.lastQueryToSession'));
	var i =0;
	set('msgMedioEnvioPaisFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('msgMedioEnvioPaisFrm.meenOidMediEnvi', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	msgMedioEnvioPaisPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	msgMedioEnvioPaisCmdQuery(msgMedioEnvioPaisPageCount);
}

function msgMedioEnvioPaisFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	msgMedioEnvioPaisPageCount = 1;
	msgMedioEnvioPaisCmdQuery(msgMedioEnvioPaisPageCount);
}

function msgMedioEnvioPaisPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != msgMedioEnvioPaisLastQuery){
		msgMedioEnvioPaisFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	msgMedioEnvioPaisPageCount--;
	msgMedioEnvioPaisCmdQuery(msgMedioEnvioPaisPageCount);
}

function msgMedioEnvioPaisNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != msgMedioEnvioPaisLastQuery){
		msgMedioEnvioPaisFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	msgMedioEnvioPaisPageCount++;
	msgMedioEnvioPaisCmdQuery(msgMedioEnvioPaisPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function msgMedioEnvioPaisPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('msgMedioEnvioPaisListLayer', 'O');
		visibilidad('msgMedioEnvioPaisListButtonsLayer', 'O');
		if(get('msgMedioEnvioPaisFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	msgMedioEnvioPaisLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 3)){
			case 'A': datosTmp.ij2(GestionarMensaje('MsgMedioEnvioPais.codEsta.A.value'), i, 3); break;
			case 'D': datosTmp.ij2(GestionarMensaje('MsgMedioEnvioPais.codEsta.D.value'), i, 3); break;
			default: datosTmp .ij2('', i, 3);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:msgMedioEnvioPaisViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, msgMedioEnvioPaisChoiceColumn) + "</A>",
			i, msgMedioEnvioPaisChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	msgMedioEnvioPaisList.setDatos(datosTmp.filtrar([0,1,2,3],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	msgMedioEnvioPaisTimeStamps = datosTmp.filtrar([4],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		msgMedioEnvioPaisMorePagesFlag = true;
		msgMedioEnvioPaisList.eliminar(mmgPageSize, 1);
	}else{
		msgMedioEnvioPaisMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('msgMedioEnvioPaisFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('msgMedioEnvioPaisListLayer', 'V');
	visibilidad('msgMedioEnvioPaisListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('msgMedioEnvioPaisList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	msgMedioEnvioPaisList.display();
	
	//Actualizamos el estado de los botones 
	if(msgMedioEnvioPaisMorePagesFlag){
		set_estado_botonera('msgMedioEnvioPaisPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('msgMedioEnvioPaisPaginationButtonBar',
			3,"inactivo");
	}
	if(msgMedioEnvioPaisPageCount > 1){
		set_estado_botonera('msgMedioEnvioPaisPaginationButtonBar',
			2,"activo");
		set_estado_botonera('msgMedioEnvioPaisPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('msgMedioEnvioPaisPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('msgMedioEnvioPaisPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function msgMedioEnvioPaisUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(msgMedioEnvioPaisList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('msgMedioEnvioPaisFrm.idSelection', msgMedioEnvioPaisList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('msgMedioEnvioPaisFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = msgMedioEnvioPaisList.codSeleccionados()[0];
		parametros["previousAction"] = get('msgMedioEnvioPaisFrm.accion');
		parametros["accion"] = get('msgMedioEnvioPaisFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MsgMedioEnvioPaisLPStartUp', get('msgMedioEnvioPaisFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) msgMedioEnvioPaisCmdRequery();
	}
}

function msgMedioEnvioPaisRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(msgMedioEnvioPaisList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = msgMedioEnvioPaisList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('msgMedioEnvioPaisFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(msgMedioEnvioPaisList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += msgMedioEnvioPaisTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('msgMedioEnvioPaisFrm.timestamp', timestamps);


	msgMedioEnvioPaisFrm.oculto='S';
	envia('msgMedioEnvioPaisFrm');
	msgMedioEnvioPaisFrm.oculto='N';
}

function msgMedioEnvioPaisViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(msgMedioEnvioPaisList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	msgMedioEnvioPaisViewDetail(msgMedioEnvioPaisList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function msgMedioEnvioPaisViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('msgMedioEnvioPaisFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MsgMedioEnvioPaisLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('msgMedioEnvioPaisFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
		
	
	if(validacion){
		msgMedioEnvioPaisFrm.oculto='S';
		envia('msgMedioEnvioPaisFrm');
		msgMedioEnvioPaisFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('msgMedioEnvioPaisFrm.paisOidPais').toString() == ''){
		set('msgMedioEnvioPaisFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'msgMedioEnvioPais');
		
	}
	if(get('msgMedioEnvioPaisFrm.meenOidMediEnvi').toString() == ''){
		set('msgMedioEnvioPaisFrm.meenOidMediEnvi', []);
		mmgResetCombosOnCascade('meenOidMediEnvi', 'meenOidMediEnvi', 'msgMedioEnvioPais');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	msgMedioEnvioPaisRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('msgMedioEnvioPaisFrm.accion');
	var origenTmp = get('msgMedioEnvioPaisFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(msgMedioEnvioPaisBuildUpdateRecordString() != msgMedioEnvioPaisTmpUpdateValues){
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
	document.all.msgMedioEnvioPaisListLayer.style.display='none';
	document.all.msgMedioEnvioPaisListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.msgMedioEnvioPaisListLayer.style.display='';
	document.all.msgMedioEnvioPaisListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMsgMedioEnvioPaisPaisOidPais = get('msgMedioEnvioPaisFrm.paisOidPais')[0];
	jsMsgMedioEnvioPaisMeenOidMediEnvi = get('msgMedioEnvioPaisFrm.meenOidMediEnvi')[0];
	
	
	var parametros = "";
	parametros += jsMsgMedioEnvioPaisPaisOidPais + "|";
	parametros += jsMsgMedioEnvioPaisMeenOidMediEnvi + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function msgMedioEnvioPaisBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMsgMedioEnvioPaisPaisOidPais + "|";
	parametros += jsMsgMedioEnvioPaisMeenOidMediEnvi + "|";
	parametros += jsMsgMedioEnvioPaisCodEsta + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('msgMedioEnvioPaisFrm.accion'), 
		get('msgMedioEnvioPaisFrm.origen'));
	
	jsMsgMedioEnvioPaisId = get('msgMedioEnvioPaisFrm.id').toString();
	jsMsgMedioEnvioPaisPaisOidPais = get('msgMedioEnvioPaisFrm.paisOidPais')[0];
	jsMsgMedioEnvioPaisMeenOidMediEnvi = get('msgMedioEnvioPaisFrm.meenOidMediEnvi')[0];
	jsMsgMedioEnvioPaisCodEsta = get('msgMedioEnvioPaisFrm.codEsta');
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('msgMedioEnvioPaisFrm.accion'), 
		get('msgMedioEnvioPaisFrm.origen'));


	set('msgMedioEnvioPaisFrm.id', jsMsgMedioEnvioPaisId);
	set('msgMedioEnvioPaisFrm.paisOidPais', [jsMsgMedioEnvioPaisPaisOidPais]);
	set('msgMedioEnvioPaisFrm.meenOidMediEnvi', [jsMsgMedioEnvioPaisMeenOidMediEnvi]);
	set('msgMedioEnvioPaisFrm.codEsta', jsMsgMedioEnvioPaisCodEsta);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMsgMedioEnvioPaisPaisOidPais = '';
	jsMsgMedioEnvioPaisMeenOidMediEnvi = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('msgMedioEnvioPaisFrm.errCodigo', errorCode);
	set('msgMedioEnvioPaisFrm.errDescripcion', description);
	set('msgMedioEnvioPaisFrm.errSeverity', severity);
	fMostrarMensajeError();
}
