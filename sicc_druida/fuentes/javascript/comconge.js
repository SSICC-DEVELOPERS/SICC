

/*
    INDRA/CAR/mmg
    $Id: comconge.js,v 1.1 2009/12/03 19:02:10 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsComCongeId = "";
var jsComCongeCodCong = "";
var jsComCongeFecDesd = "";
var jsComCongeFecHast = "";
var jsComCongeImpCong = "";
var jsComCongeIndDescAuto = "";
var jsComCongeClieOidClie = "";

//Variables de paginacion, 
var comCongePageCount = 1;

//Varible de columna que representa el campo de choice
var comCongeChoiceColumn = 5;

//Flag de siguiente pagina;
var comCongeMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var comCongeTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 273;
var sizeFormView = 313;
var sizeFormUpdate = 267;

//Ultima busqueda realizada
var comCongeLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focaliza("comCongeFrm.fecDesd");','focaliza("comCongeFrm.fecDesd");','focaliza("comCongeFrm.fecDesd");','focaliza("comCongeFrm.fecDesd");','focaliza("comCongeFrm.fecDesd");','focaliza("comCongeFrm.fecDesd");'],[4,'focaliza("comCongeFrm.fecHast");','focaliza("comCongeFrm.fecHast");','focaliza("comCongeFrm.fecHast");','focaliza("comCongeFrm.fecHast");','focaliza("comCongeFrm.fecHast");','focaliza("comCongeFrm.fecHast");'],[5,'focaliza("comCongeFrm.impCong");','focaliza("comCongeFrm.impCong");','focaliza("comCongeFrm.impCong");','focaliza("comCongeFrm.impCong");','focaliza("comCongeFrm.impCong");','focaliza("comCongeFrm.impCong");'],[6,'focaliza("comCongeFrm.indDescAuto");','focaliza("comCongeFrm.indDescAuto");','focaliza("comCongeFrm.indDescAuto");','focaliza("comCongeFrm.indDescAuto");','focaliza("comCongeFrm.indDescAuto");','focaliza("comCongeFrm.indDescAuto");'],[7,'focalizaComboDependence("comConge","clieOidClie", false);','focalizaComboDependence("comConge","clieOidClie", false);','focalizaComboDependence("comConge","clieOidClie", false);','focalizaComboDependence("comConge","clieOidClie", true);','focalizaComboDependence("comConge","clieOidClie", true);','focalizaComboDependence("comConge","clieOidClie", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[3,'focaliza("comCongeFrm.fecDesd");','focaliza("comCongeFrm.fecDesd");','focaliza("comCongeFrm.fecDesd");','focaliza("comCongeFrm.fecDesd");','focaliza("comCongeFrm.fecDesd");','focaliza("comCongeFrm.fecDesd");'],[4,'focaliza("comCongeFrm.fecHast");','focaliza("comCongeFrm.fecHast");','focaliza("comCongeFrm.fecHast");','focaliza("comCongeFrm.fecHast");','focaliza("comCongeFrm.fecHast");','focaliza("comCongeFrm.fecHast");'],[5,'focaliza("comCongeFrm.impCong");','focaliza("comCongeFrm.impCong");','focaliza("comCongeFrm.impCong");','focaliza("comCongeFrm.impCong");','focaliza("comCongeFrm.impCong");','focaliza("comCongeFrm.impCong");'],[6,'focaliza("comCongeFrm.indDescAuto");','focaliza("comCongeFrm.indDescAuto");','focaliza("comCongeFrm.indDescAuto");','focaliza("comCongeFrm.indDescAuto");','focaliza("comCongeFrm.indDescAuto");','focaliza("comCongeFrm.indDescAuto");'],[7,'focalizaComboDependence("comConge","clieOidClie", false);','focalizaComboDependence("comConge","clieOidClie", false);','focalizaComboDependence("comConge","clieOidClie", false);','focalizaComboDependence("comConge","clieOidClie", true);','focalizaComboDependence("comConge","clieOidClie", true);','focalizaComboDependence("comConge","clieOidClie", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var clieOidClieDependeceMap = new Vector();
clieOidClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clieOidClieDependeceMap.agregar(['clieOidClie', padresTmp, '', 'MaeClienView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
comCongeLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var comCongeTmpUpdateValues;


		//funcion para fecHast y su validación con fecDesd
		function validacionfecHastfecDesd(){
			if ((get('comCongeFrm.fecHast','T').toString()=="") || 
			(get('comCongeFrm.fecDesd','T').toString()==""))
				//en este caso no hay alguno de los valores introducidos y no se puede realizar la verificación.
				return 'OK';
			
				var errorLevel = EsFechaValida(get('comCongeFrm.fecDesd','T') ,get('comCongeFrm.fecHast','T') , "comCongeFrm", "N");
				
			
			if ( errorLevel == 3){
			     return GestionarMensaje("ComConge.fecHastfecDesd.message");
			}else
			     return 'OK';
		}
		

//Función ejecutada en el onload de la pagina
function comCongeInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('comCongeFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('comCongeFrm.accion')){
		case "query": comCongeQueryInitComponents(); break;
		case "view": comCongeViewInitComponents(); break;
		case "create": comCongeCreateInitComponents(); break;
		case "update": comCongeUpdateInitComponents(); break;
		case "remove": comCongeRemoveInitComponents(); break;
		case "lov": comCongeLovInitComponents(); break;
	}
	//alert('accion :' + get('comCongeFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('comCongeFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('comConge')) comCongeCmdRequery();
}

function comCongeQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	focusFirstField('comCongeFrm', true);	
}

function comCongeViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	//Establecemos el valor de los radiobuttons
		set('comCongeFrm.indDescAuto', get('comCongeFrm.indDescAutoCheckValue'));
		
	focusFirstField('comCongeFrm', true);
}

function comCongeCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('comCongeFrm.fecDesd','S', GestionarMensaje('ComConge.fecDesd.requiered.message'));
	
	setMV('comCongeFrm.fecHast','S', GestionarMensaje('ComConge.fecHast.requiered.message'));
	
	setMV('comCongeFrm.impCong','S', GestionarMensaje('ComConge.impCong.requiered.message'));
	
	setMV('comCongeFrm.indDescAuto','S', GestionarMensaje('ComConge.indDescAuto.requiered.message'));
	
	setMV('comCongeFrm.clieOidClie','S', GestionarMensaje('ComConge.clieOidClie.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('comCongeFrm', true);
}

function comCongeUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('comCongeFrm.origen') == "pagina"){
		

		//Establecemos el valor de los radiobuttons
			set('comCongeFrm.indDescAuto', get('comCongeFrm.indDescAutoCheckValue'));
			

		//Registramos el valor del elemento que estamos modificando
		comCongeTmpUpdateValues = comCongeBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('comCongeFrm.fecDesd','S', GestionarMensaje('ComConge.fecDesd.requiered.message'));
		setMV('comCongeFrm.fecHast','S', GestionarMensaje('ComConge.fecHast.requiered.message'));
		setMV('comCongeFrm.impCong','S', GestionarMensaje('ComConge.impCong.requiered.message'));
		setMV('comCongeFrm.indDescAuto','S', GestionarMensaje('ComConge.indDescAuto.requiered.message'));
		setMV('comCongeFrm.clieOidClie','S', GestionarMensaje('ComConge.clieOidClie.requiered.message'));
		
			focusFirstFieldModify('comCongeFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		focusFirstField('comCongeFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('comCongeFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function comCongeRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	comCongeList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('comCongeFrm', true);
}

function comCongeLovInitComponents(){
	comCongeLovReturnParameters = window.dialogArguments;
	
	focusFirstField('comCongeFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad









//Función que permite cargar los datos de un elemento de lov seleccionado
function comCongeSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('comCongeFrm.' + campo, id);
	set('comCongeFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function comCongeLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	comCongeLovReturnParameters.id = '';
	comCongeLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function comCongeLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(comCongeList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = comCongeList.codSeleccionados();
	var descripcion = comCongeList.extraeDato(
		comCongeList.codSeleccionados()[0], comCongeChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	comCongeLovReturnParameters.id = codigo;
	comCongeLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function comCongeCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('comCongeFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('comCongeFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "comCongeList", "ComCongeConectorTransactionQuery", 
		"result_ROWSET", parametros, "comCongePostQueryActions(datos);"]], "", "");	
}

function comCongeCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('comCongeFrm.lastQueryToSession'));
	var i =0;
	set('comCongeFrm.fecDesd', paramsRequery.ij(i++));
	
	set('comCongeFrm.fecHast', paramsRequery.ij(i++));
	
	set('comCongeFrm.impCong', paramsRequery.ij(i++));
	
	set('comCongeFrm.indDescAuto', paramsRequery.ij(i++));
	
	set('comCongeFrm.clieOidClie', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	comCongePageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	comCongeCmdQuery(comCongePageCount);
}

function comCongeFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	comCongePageCount = 1;
	comCongeCmdQuery(comCongePageCount);
}

function comCongePreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != comCongeLastQuery){
		comCongeFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	comCongePageCount--;
	comCongeCmdQuery(comCongePageCount);
}

function comCongeNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != comCongeLastQuery){
		comCongeFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	comCongePageCount++;
	comCongeCmdQuery(comCongePageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function comCongePostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('comCongeListLayer', 'O');
		visibilidad('comCongeListButtonsLayer', 'O');
		if(get('comCongeFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	comCongeLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	for(var i=0; i < datosTmp.longitud; i++){ 
		switch(datosTmp.ij(i, 4)){
			case '0': datosTmp.ij2(GestionarMensaje('ComConge.indDescAuto.0.value'), i, 4); break;
			case '1': datosTmp.ij2(GestionarMensaje('ComConge.indDescAuto.1.value'), i, 4); break;
			default: datosTmp .ij2('', i, 4);
		}
	}
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:comCongeViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, comCongeChoiceColumn) + "</A>",
			i, comCongeChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	comCongeList.setDatos(datosTmp.filtrar([0,1,2,3,4,5],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	comCongeTimeStamps = datosTmp.filtrar([6],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		comCongeMorePagesFlag = true;
		comCongeList.eliminar(mmgPageSize, 1);
	}else{
		comCongeMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('comCongeFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('comCongeListLayer', 'V');
	visibilidad('comCongeListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('comCongeList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	comCongeList.display();
	
	//Actualizamos el estado de los botones 
	if(comCongeMorePagesFlag){
		set_estado_botonera('comCongePaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('comCongePaginationButtonBar',
			3,"inactivo");
	}
	if(comCongePageCount > 1){
		set_estado_botonera('comCongePaginationButtonBar',
			2,"activo");
		set_estado_botonera('comCongePaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('comCongePaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('comCongePaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function comCongeUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(comCongeList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('comCongeFrm.idSelection', comCongeList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('comCongeFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = comCongeList.codSeleccionados()[0];
		parametros["previousAction"] = get('comCongeFrm.accion');
		parametros["accion"] = get('comCongeFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('ComCongeLPStartUp', get('comCongeFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) comCongeCmdRequery();
	}
}

function comCongeRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(comCongeList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = comCongeList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('comCongeFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(comCongeList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += comCongeTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('comCongeFrm.timestamp', timestamps);


	comCongeFrm.oculto='S';
	envia('comCongeFrm');
	comCongeFrm.oculto='N';
}

function comCongeViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(comCongeList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	comCongeViewDetail(comCongeList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function comCongeViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('comCongeFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('ComCongeLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('comCongeFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
		
	
	if(validacion){
		comCongeFrm.oculto='S';
		envia('comCongeFrm');
		comCongeFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('comCongeFrm.clieOidClie').toString() == ''){
		set('comCongeFrm.clieOidClie', []);
		mmgResetCombosOnCascade('clieOidClie', 'clieOidClie', 'comConge');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	comCongeRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('comCongeFrm.accion');
	var origenTmp = get('comCongeFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(comCongeBuildUpdateRecordString() != comCongeTmpUpdateValues){
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
	document.all.comCongeListLayer.style.display='none';
	document.all.comCongeListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.comCongeListLayer.style.display='';
	document.all.comCongeListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsComCongeFecDesd = get('comCongeFrm.fecDesd').toString();
	jsComCongeFecHast = get('comCongeFrm.fecHast').toString();
	jsComCongeImpCong = get('comCongeFrm.impCong').toString();
	jsComCongeIndDescAuto = get('comCongeFrm.indDescAuto');
	jsComCongeClieOidClie = get('comCongeFrm.clieOidClie')[0];
	
	
	var parametros = "";
	parametros += jsComCongeFecDesd + "|";
	parametros += jsComCongeFecHast + "|";
	parametros += jsComCongeImpCong + "|";
	parametros += jsComCongeIndDescAuto + "|";
	parametros += jsComCongeClieOidClie + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function comCongeBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsComCongeFecDesd + "|";
	parametros += jsComCongeFecHast + "|";
	parametros += jsComCongeImpCong + "|";
	parametros += jsComCongeIndDescAuto + "|";
	parametros += jsComCongeClieOidClie + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('comCongeFrm.accion'), 
		get('comCongeFrm.origen'));
	
	jsComCongeId = get('comCongeFrm.id').toString();
	jsComCongeCodCong = get('comCongeFrm.codCong').toString();
	jsComCongeFecDesd = get('comCongeFrm.fecDesd').toString();
	jsComCongeFecHast = get('comCongeFrm.fecHast').toString();
	jsComCongeImpCong = get('comCongeFrm.impCong').toString();
	jsComCongeIndDescAuto = get('comCongeFrm.indDescAuto');
	jsComCongeClieOidClie = get('comCongeFrm.clieOidClie')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('comCongeFrm.accion'), 
		get('comCongeFrm.origen'));


	set('comCongeFrm.id', jsComCongeId);
	set('comCongeFrm.codCong', jsComCongeCodCong);
	set('comCongeFrm.fecDesd', jsComCongeFecDesd);
	set('comCongeFrm.fecHast', jsComCongeFecHast);
	set('comCongeFrm.impCong', jsComCongeImpCong);
	set('comCongeFrm.indDescAuto', jsComCongeIndDescAuto);
	set('comCongeFrm.clieOidClie', [jsComCongeClieOidClie]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsComCongeFecDesd = '';
	jsComCongeFecHast = '';
	jsComCongeImpCong = '';
	jsComCongeIndDescAuto = '';
	jsComCongeClieOidClie = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('comCongeFrm.errCodigo', errorCode);
	set('comCongeFrm.errDescripcion', description);
	set('comCongeFrm.errSeverity', severity);
	fMostrarMensajeError();
}
