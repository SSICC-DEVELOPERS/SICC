

/*
    INDRA/CAR/mmg
    $Id: zonsecci.js,v 1.1 2009/12/03 19:02:12 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonSecciId = "";
var jsZonSecciZzonOidZona = "";
var jsZonSecciCodSecc = "";
var jsZonSecciIndActi = "";
var jsZonSecciIndBorr = "";
var jsZonSecciClieOidClie = "";
var jsZonSecciCodNse1 = "";
var jsZonSecciCodNse2 = "";
var jsZonSecciCodNse3 = "";
var jsZonSecciDesSecci = "";
var jsZonSecciFecRezo = "";

//Variables de paginacion, 
var zonSecciPageCount = 1;

//Varible de columna que representa el campo de choice
var zonSecciChoiceColumn = 10;

//Flag de siguiente pagina;
var zonSecciMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonSecciTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 483;
var sizeFormView = 469;
var sizeFormUpdate = 469;

//Ultima busqueda realizada
var zonSecciLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("zonSecciFrm.fecRezo");','focaliza("zonSecciFrm.fecRezo");','focaliza("zonSecciFrm.fecRezo");','focaliza("zonSecciFrm.fecRezo");','focaliza("zonSecciFrm.fecRezo");','focaliza("zonSecciFrm.fecRezo");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var zzonOidZonaDependeceMap = new Vector();
zzonOidZonaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zzonOidZonaDependeceMap.agregar(['zzonOidZona', padresTmp, '', 'ZonZona']);
var clieOidClieDependeceMap = new Vector();
clieOidClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clieOidClieDependeceMap.agregar(['clieOidClie', padresTmp, '', 'MaeClien']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonSecciLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonSecciTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function zonSecciInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonSecciFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonSecciFrm.accion')){
		case "query": zonSecciQueryInitComponents(); break;
		case "view": zonSecciViewInitComponents(); break;
		case "create": zonSecciCreateInitComponents(); break;
		case "update": zonSecciUpdateInitComponents(); break;
		case "remove": zonSecciRemoveInitComponents(); break;
		case "lov": zonSecciLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('zonSecciFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonSecci')) zonSecciCmdRequery();
}

function zonSecciQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
}

function zonSecciViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
}

function zonSecciCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonSecciFrm.zzonOidZona','S', GestionarMensaje('ZonSecci.zzonOidZona.requiered.message'));
	
	setMV('zonSecciFrm.codSecc','S', GestionarMensaje('ZonSecci.codSecc.requiered.message'));
	
	setMV('zonSecciFrm.fecRezo','S', GestionarMensaje('ZonSecci.fecRezo.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function zonSecciUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonSecciFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		zonSecciTmpUpdateValues = zonSecciBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonSecciFrm.zzonOidZona','S', GestionarMensaje('ZonSecci.zzonOidZona.requiered.message'));
		setMV('zonSecciFrm.codSecc','S', GestionarMensaje('ZonSecci.codSecc.requiered.message'));
		setMV('zonSecciFrm.fecRezo','S', GestionarMensaje('ZonSecci.fecRezo.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonSecciFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonSecciRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonSecciList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function zonSecciLovInitComponents(){
	zonSecciLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad













//Función que permite cargar los datos de un elemento de lov seleccionado
function zonSecciSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonSecciFrm.' + campo, id);
	set('zonSecciFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonSecciLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonSecciLovReturnParameters.id = '';
	zonSecciLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonSecciLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSecciList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonSecciList.codSeleccionados();
	var descripcion = zonSecciList.extraeDato(
		zonSecciList.codSeleccionados()[0], zonSecciChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonSecciLovReturnParameters.id = codigo;
	zonSecciLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonSecciCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonSecciFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonSecciFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonSecciList", "ZonSecciConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonSecciPostQueryActions(datos);"]], "", "");	
}

function zonSecciCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonSecciFrm.lastQueryToSession'));
	var i =0;
	set('zonSecciFrm.zzonOidZona', [paramsRequery.ij(i++)]);
	
	set('zonSecciFrm.codSecc', paramsRequery.ij(i++));
	
	set('zonSecciFrm.indActi', paramsRequery.ij(i++));
	
	set('zonSecciFrm.indBorr', paramsRequery.ij(i++));
	
	set('zonSecciFrm.clieOidClie', [paramsRequery.ij(i++)]);
	
	set('zonSecciFrm.codNse1', paramsRequery.ij(i++));
	
	set('zonSecciFrm.codNse2', paramsRequery.ij(i++));
	
	set('zonSecciFrm.codNse3', paramsRequery.ij(i++));
	
	set('zonSecciFrm.desSecci', paramsRequery.ij(i++));
	
	set('zonSecciFrm.fecRezo', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	zonSecciPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonSecciCmdQuery(zonSecciPageCount);
}

function zonSecciFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonSecciPageCount = 1;
	zonSecciCmdQuery(zonSecciPageCount);
}

function zonSecciPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonSecciLastQuery){
		zonSecciFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonSecciPageCount--;
	zonSecciCmdQuery(zonSecciPageCount);
}

function zonSecciNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonSecciLastQuery){
		zonSecciFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonSecciPageCount++;
	zonSecciCmdQuery(zonSecciPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonSecciPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonSecciListLayer', 'O');
		visibilidad('zonSecciListButtonsLayer', 'O');
		if(get('zonSecciFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonSecciLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonSecciViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonSecciChoiceColumn) + "</A>",
			i, zonSecciChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonSecciList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonSecciTimeStamps = datosTmp.filtrar([11],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonSecciMorePagesFlag = true;
		zonSecciList.eliminar(mmgPageSize, 1);
	}else{
		zonSecciMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonSecciFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonSecciListLayer', 'V');
	visibilidad('zonSecciListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonSecciList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonSecciList.display();
	
	//Actualizamos el estado de los botones 
	if(zonSecciMorePagesFlag){
		set_estado_botonera('zonSecciPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonSecciPaginationButtonBar',
			3,"inactivo");
	}
	if(zonSecciPageCount > 1){
		set_estado_botonera('zonSecciPaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonSecciPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonSecciPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonSecciPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonSecciUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSecciList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonSecciFrm.idSelection', zonSecciList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonSecciFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonSecciList.codSeleccionados()[0];
		parametros["previousAction"] = get('zonSecciFrm.accion');
		parametros["accion"] = get('zonSecciFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('ZonSecciLPStartUp', get('zonSecciFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) zonSecciCmdRequery();
	}
}

function zonSecciRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSecciList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonSecciList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonSecciFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonSecciList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonSecciTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonSecciFrm.timestamp', timestamps);


	zonSecciFrm.oculto='S';
	envia('zonSecciFrm');
	zonSecciFrm.oculto='N';
}

function zonSecciViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonSecciList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonSecciViewDetail(zonSecciList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonSecciViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonSecciFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('ZonSecciLPStartUp', 'view', parametros, null, sizeFormView + 55);
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
	var validacion = ValidaForm('zonSecciFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		zonSecciFrm.oculto='S';
		envia('zonSecciFrm');
		zonSecciFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonSecciFrm.zzonOidZona').toString() == ''){
		set('zonSecciFrm.zzonOidZona', []);
		mmgResetCombosOnCascade('zzonOidZona', 'zzonOidZona', 'zonSecci');
		
	}
	if(get('zonSecciFrm.clieOidClie').toString() == ''){
		set('zonSecciFrm.clieOidClie', []);
		mmgResetCombosOnCascade('clieOidClie', 'clieOidClie', 'zonSecci');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonSecciRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonSecciFrm.accion');
	var origenTmp = get('zonSecciFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonSecciBuildUpdateRecordString() != zonSecciTmpUpdateValues){
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
	document.all.zonSecciListLayer.style.display='none';
	document.all.zonSecciListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonSecciListLayer.style.display='';
	document.all.zonSecciListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonSecciZzonOidZona = get('zonSecciFrm.zzonOidZona')[0];
	jsZonSecciCodSecc = get('zonSecciFrm.codSecc').toString();
	jsZonSecciIndActi = get('zonSecciFrm.indActi').toString();
	jsZonSecciIndBorr = get('zonSecciFrm.indBorr').toString();
	jsZonSecciClieOidClie = get('zonSecciFrm.clieOidClie')[0];
	jsZonSecciCodNse1 = get('zonSecciFrm.codNse1').toString();
	jsZonSecciCodNse2 = get('zonSecciFrm.codNse2').toString();
	jsZonSecciCodNse3 = get('zonSecciFrm.codNse3').toString();
	jsZonSecciDesSecci = get('zonSecciFrm.desSecci').toString();
	jsZonSecciFecRezo = get('zonSecciFrm.fecRezo').toString();
	
	
	var parametros = "";
	parametros += jsZonSecciZzonOidZona + "|";
	parametros += jsZonSecciCodSecc + "|";
	parametros += jsZonSecciIndActi + "|";
	parametros += jsZonSecciIndBorr + "|";
	parametros += jsZonSecciClieOidClie + "|";
	parametros += jsZonSecciCodNse1 + "|";
	parametros += jsZonSecciCodNse2 + "|";
	parametros += jsZonSecciCodNse3 + "|";
	parametros += jsZonSecciDesSecci + "|";
	parametros += jsZonSecciFecRezo + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonSecciBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonSecciZzonOidZona + "|";
	parametros += jsZonSecciCodSecc + "|";
	parametros += jsZonSecciIndActi + "|";
	parametros += jsZonSecciIndBorr + "|";
	parametros += jsZonSecciClieOidClie + "|";
	parametros += jsZonSecciCodNse1 + "|";
	parametros += jsZonSecciCodNse2 + "|";
	parametros += jsZonSecciCodNse3 + "|";
	parametros += jsZonSecciDesSecci + "|";
	parametros += jsZonSecciFecRezo + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonSecciFrm.accion'), 
		get('zonSecciFrm.origen'));
	
	jsZonSecciId = get('zonSecciFrm.id').toString();
	jsZonSecciZzonOidZona = get('zonSecciFrm.zzonOidZona')[0];
	jsZonSecciCodSecc = get('zonSecciFrm.codSecc').toString();
	jsZonSecciIndActi = get('zonSecciFrm.indActi').toString();
	jsZonSecciIndBorr = get('zonSecciFrm.indBorr').toString();
	jsZonSecciClieOidClie = get('zonSecciFrm.clieOidClie')[0];
	jsZonSecciCodNse1 = get('zonSecciFrm.codNse1').toString();
	jsZonSecciCodNse2 = get('zonSecciFrm.codNse2').toString();
	jsZonSecciCodNse3 = get('zonSecciFrm.codNse3').toString();
	jsZonSecciDesSecci = get('zonSecciFrm.desSecci').toString();
	jsZonSecciFecRezo = get('zonSecciFrm.fecRezo').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonSecciFrm.accion'), 
		get('zonSecciFrm.origen'));


	set('zonSecciFrm.id', jsZonSecciId);
	set('zonSecciFrm.zzonOidZona', [jsZonSecciZzonOidZona]);
	set('zonSecciFrm.codSecc', jsZonSecciCodSecc);
	set('zonSecciFrm.indActi', jsZonSecciIndActi);
	set('zonSecciFrm.indBorr', jsZonSecciIndBorr);
	set('zonSecciFrm.clieOidClie', [jsZonSecciClieOidClie]);
	set('zonSecciFrm.codNse1', jsZonSecciCodNse1);
	set('zonSecciFrm.codNse2', jsZonSecciCodNse2);
	set('zonSecciFrm.codNse3', jsZonSecciCodNse3);
	set('zonSecciFrm.desSecci', jsZonSecciDesSecci);
	set('zonSecciFrm.fecRezo', jsZonSecciFecRezo);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsZonSecciZzonOidZona = '';
	jsZonSecciCodSecc = '';
	jsZonSecciIndActi = '';
	jsZonSecciIndBorr = '';
	jsZonSecciClieOidClie = '';
	jsZonSecciCodNse1 = '';
	jsZonSecciCodNse2 = '';
	jsZonSecciCodNse3 = '';
	jsZonSecciDesSecci = '';
	jsZonSecciFecRezo = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonSecciFrm.errCodigo', errorCode);
	set('zonSecciFrm.errDescripcion', description);
	set('zonSecciFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
