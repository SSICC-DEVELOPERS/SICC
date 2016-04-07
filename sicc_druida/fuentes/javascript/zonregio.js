

/*
    INDRA/CAR/mmg
    $Id: zonregio.js,v 1.1 2009/12/03 19:01:44 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonRegioId = "";
var jsZonRegioCodRegi = "";
var jsZonRegioIndActi = "";
var jsZonRegioIndBorr = "";
var jsZonRegioCodNse1 = "";
var jsZonRegioCodNse2 = "";
var jsZonRegioCodNse3 = "";
var jsZonRegioZsgvOidSubgVent = "";
var jsZonRegioDesRegi = "";
var jsZonRegioClieOidClie = "";
var jsZonRegioFecRezo = "";

//Variables de paginacion, 
var zonRegioPageCount = 1;

//Varible de columna que representa el campo de choice
var zonRegioChoiceColumn = 10;

//Flag de siguiente pagina;
var zonRegioMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonRegioTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 483;
var sizeFormView = 469;
var sizeFormUpdate = 469;

//Ultima busqueda realizada
var zonRegioLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("zonRegioFrm.fecRezo");','focaliza("zonRegioFrm.fecRezo");','focaliza("zonRegioFrm.fecRezo");','focaliza("zonRegioFrm.fecRezo");','focaliza("zonRegioFrm.fecRezo");','focaliza("zonRegioFrm.fecRezo");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var zsgvOidSubgVentDependeceMap = new Vector();
zsgvOidSubgVentDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zsgvOidSubgVentDependeceMap.agregar(['zsgvOidSubgVent', padresTmp, '', 'ZonSubGerenVenta']);
var clieOidClieDependeceMap = new Vector();
clieOidClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clieOidClieDependeceMap.agregar(['clieOidClie', padresTmp, '', 'MaeClien']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonRegioLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonRegioTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function zonRegioInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonRegioFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonRegioFrm.accion')){
		case "query": zonRegioQueryInitComponents(); break;
		case "view": zonRegioViewInitComponents(); break;
		case "create": zonRegioCreateInitComponents(); break;
		case "update": zonRegioUpdateInitComponents(); break;
		case "remove": zonRegioRemoveInitComponents(); break;
		case "lov": zonRegioLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('zonRegioFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonRegio')) zonRegioCmdRequery();
}

function zonRegioQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
}

function zonRegioViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
}

function zonRegioCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonRegioFrm.codRegi','S', GestionarMensaje('ZonRegio.codRegi.requiered.message'));
	
	setMV('zonRegioFrm.zsgvOidSubgVent','S', GestionarMensaje('ZonRegio.zsgvOidSubgVent.requiered.message'));
	
	setMV('zonRegioFrm.fecRezo','S', GestionarMensaje('ZonRegio.fecRezo.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function zonRegioUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonRegioFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		zonRegioTmpUpdateValues = zonRegioBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonRegioFrm.codRegi','S', GestionarMensaje('ZonRegio.codRegi.requiered.message'));
		setMV('zonRegioFrm.zsgvOidSubgVent','S', GestionarMensaje('ZonRegio.zsgvOidSubgVent.requiered.message'));
		setMV('zonRegioFrm.fecRezo','S', GestionarMensaje('ZonRegio.fecRezo.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonRegioFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonRegioRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonRegioList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function zonRegioLovInitComponents(){
	zonRegioLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad













//Función que permite cargar los datos de un elemento de lov seleccionado
function zonRegioSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonRegioFrm.' + campo, id);
	set('zonRegioFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonRegioLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonRegioLovReturnParameters.id = '';
	zonRegioLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonRegioLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonRegioList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonRegioList.codSeleccionados();
	var descripcion = zonRegioList.extraeDato(
		zonRegioList.codSeleccionados()[0], zonRegioChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonRegioLovReturnParameters.id = codigo;
	zonRegioLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonRegioCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonRegioFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonRegioFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonRegioList", "ZonRegioConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonRegioPostQueryActions(datos);"]], "", "");	
}

function zonRegioCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonRegioFrm.lastQueryToSession'));
	var i =0;
	set('zonRegioFrm.codRegi', paramsRequery.ij(i++));
	
	set('zonRegioFrm.indActi', paramsRequery.ij(i++));
	
	set('zonRegioFrm.indBorr', paramsRequery.ij(i++));
	
	set('zonRegioFrm.codNse1', paramsRequery.ij(i++));
	
	set('zonRegioFrm.codNse2', paramsRequery.ij(i++));
	
	set('zonRegioFrm.codNse3', paramsRequery.ij(i++));
	
	set('zonRegioFrm.zsgvOidSubgVent', [paramsRequery.ij(i++)]);
	
	set('zonRegioFrm.desRegi', paramsRequery.ij(i++));
	
	set('zonRegioFrm.clieOidClie', [paramsRequery.ij(i++)]);
	
	set('zonRegioFrm.fecRezo', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	zonRegioPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonRegioCmdQuery(zonRegioPageCount);
}

function zonRegioFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonRegioPageCount = 1;
	zonRegioCmdQuery(zonRegioPageCount);
}

function zonRegioPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonRegioLastQuery){
		zonRegioFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonRegioPageCount--;
	zonRegioCmdQuery(zonRegioPageCount);
}

function zonRegioNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonRegioLastQuery){
		zonRegioFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonRegioPageCount++;
	zonRegioCmdQuery(zonRegioPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonRegioPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonRegioListLayer', 'O');
		visibilidad('zonRegioListButtonsLayer', 'O');
		if(get('zonRegioFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonRegioLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonRegioViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonRegioChoiceColumn) + "</A>",
			i, zonRegioChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonRegioList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonRegioTimeStamps = datosTmp.filtrar([11],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonRegioMorePagesFlag = true;
		zonRegioList.eliminar(mmgPageSize, 1);
	}else{
		zonRegioMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonRegioFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonRegioListLayer', 'V');
	visibilidad('zonRegioListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonRegioList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonRegioList.display();
	
	//Actualizamos el estado de los botones 
	if(zonRegioMorePagesFlag){
		set_estado_botonera('zonRegioPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonRegioPaginationButtonBar',
			3,"inactivo");
	}
	if(zonRegioPageCount > 1){
		set_estado_botonera('zonRegioPaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonRegioPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonRegioPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonRegioPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonRegioUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonRegioList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonRegioFrm.idSelection', zonRegioList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonRegioFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonRegioList.codSeleccionados()[0];
		parametros["previousAction"] = get('zonRegioFrm.accion');
		parametros["accion"] = get('zonRegioFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('ZonRegioLPStartUp', get('zonRegioFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) zonRegioCmdRequery();
	}
}

function zonRegioRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonRegioList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonRegioList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonRegioFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonRegioList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonRegioTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonRegioFrm.timestamp', timestamps);


	zonRegioFrm.oculto='S';
	envia('zonRegioFrm');
	zonRegioFrm.oculto='N';
}

function zonRegioViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonRegioList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonRegioViewDetail(zonRegioList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonRegioViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonRegioFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('ZonRegioLPStartUp', 'view', parametros, null, sizeFormView + 55);
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
	var validacion = ValidaForm('zonRegioFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		zonRegioFrm.oculto='S';
		envia('zonRegioFrm');
		zonRegioFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonRegioFrm.zsgvOidSubgVent').toString() == ''){
		set('zonRegioFrm.zsgvOidSubgVent', []);
		mmgResetCombosOnCascade('zsgvOidSubgVent', 'zsgvOidSubgVent', 'zonRegio');
		
	}
	if(get('zonRegioFrm.clieOidClie').toString() == ''){
		set('zonRegioFrm.clieOidClie', []);
		mmgResetCombosOnCascade('clieOidClie', 'clieOidClie', 'zonRegio');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonRegioRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonRegioFrm.accion');
	var origenTmp = get('zonRegioFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonRegioBuildUpdateRecordString() != zonRegioTmpUpdateValues){
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
	document.all.zonRegioListLayer.style.display='none';
	document.all.zonRegioListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonRegioListLayer.style.display='';
	document.all.zonRegioListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonRegioCodRegi = get('zonRegioFrm.codRegi').toString();
	jsZonRegioIndActi = get('zonRegioFrm.indActi').toString();
	jsZonRegioIndBorr = get('zonRegioFrm.indBorr').toString();
	jsZonRegioCodNse1 = get('zonRegioFrm.codNse1').toString();
	jsZonRegioCodNse2 = get('zonRegioFrm.codNse2').toString();
	jsZonRegioCodNse3 = get('zonRegioFrm.codNse3').toString();
	jsZonRegioZsgvOidSubgVent = get('zonRegioFrm.zsgvOidSubgVent')[0];
	jsZonRegioDesRegi = get('zonRegioFrm.desRegi').toString();
	jsZonRegioClieOidClie = get('zonRegioFrm.clieOidClie')[0];
	jsZonRegioFecRezo = get('zonRegioFrm.fecRezo').toString();
	
	
	var parametros = "";
	parametros += jsZonRegioCodRegi + "|";
	parametros += jsZonRegioIndActi + "|";
	parametros += jsZonRegioIndBorr + "|";
	parametros += jsZonRegioCodNse1 + "|";
	parametros += jsZonRegioCodNse2 + "|";
	parametros += jsZonRegioCodNse3 + "|";
	parametros += jsZonRegioZsgvOidSubgVent + "|";
	parametros += jsZonRegioDesRegi + "|";
	parametros += jsZonRegioClieOidClie + "|";
	parametros += jsZonRegioFecRezo + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonRegioBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonRegioCodRegi + "|";
	parametros += jsZonRegioIndActi + "|";
	parametros += jsZonRegioIndBorr + "|";
	parametros += jsZonRegioCodNse1 + "|";
	parametros += jsZonRegioCodNse2 + "|";
	parametros += jsZonRegioCodNse3 + "|";
	parametros += jsZonRegioZsgvOidSubgVent + "|";
	parametros += jsZonRegioDesRegi + "|";
	parametros += jsZonRegioClieOidClie + "|";
	parametros += jsZonRegioFecRezo + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonRegioFrm.accion'), 
		get('zonRegioFrm.origen'));
	
	jsZonRegioId = get('zonRegioFrm.id').toString();
	jsZonRegioCodRegi = get('zonRegioFrm.codRegi').toString();
	jsZonRegioIndActi = get('zonRegioFrm.indActi').toString();
	jsZonRegioIndBorr = get('zonRegioFrm.indBorr').toString();
	jsZonRegioCodNse1 = get('zonRegioFrm.codNse1').toString();
	jsZonRegioCodNse2 = get('zonRegioFrm.codNse2').toString();
	jsZonRegioCodNse3 = get('zonRegioFrm.codNse3').toString();
	jsZonRegioZsgvOidSubgVent = get('zonRegioFrm.zsgvOidSubgVent')[0];
	jsZonRegioDesRegi = get('zonRegioFrm.desRegi').toString();
	jsZonRegioClieOidClie = get('zonRegioFrm.clieOidClie')[0];
	jsZonRegioFecRezo = get('zonRegioFrm.fecRezo').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonRegioFrm.accion'), 
		get('zonRegioFrm.origen'));


	set('zonRegioFrm.id', jsZonRegioId);
	set('zonRegioFrm.codRegi', jsZonRegioCodRegi);
	set('zonRegioFrm.indActi', jsZonRegioIndActi);
	set('zonRegioFrm.indBorr', jsZonRegioIndBorr);
	set('zonRegioFrm.codNse1', jsZonRegioCodNse1);
	set('zonRegioFrm.codNse2', jsZonRegioCodNse2);
	set('zonRegioFrm.codNse3', jsZonRegioCodNse3);
	set('zonRegioFrm.zsgvOidSubgVent', [jsZonRegioZsgvOidSubgVent]);
	set('zonRegioFrm.desRegi', jsZonRegioDesRegi);
	set('zonRegioFrm.clieOidClie', [jsZonRegioClieOidClie]);
	set('zonRegioFrm.fecRezo', jsZonRegioFecRezo);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsZonRegioCodRegi = '';
	jsZonRegioIndActi = '';
	jsZonRegioIndBorr = '';
	jsZonRegioCodNse1 = '';
	jsZonRegioCodNse2 = '';
	jsZonRegioCodNse3 = '';
	jsZonRegioZsgvOidSubgVent = '';
	jsZonRegioDesRegi = '';
	jsZonRegioClieOidClie = '';
	jsZonRegioFecRezo = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonRegioFrm.errCodigo', errorCode);
	set('zonRegioFrm.errDescripcion', description);
	set('zonRegioFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
