

/*
    INDRA/CAR/mmg
    $Id: zonzona.js,v 1.1 2009/12/03 19:01:56 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsZonZonaId = "";
var jsZonZonaClieOidClie = "";
var jsZonZonaZorgOidRegi = "";
var jsZonZonaCodZona = "";
var jsZonZonaIndActi = "";
var jsZonZonaIndRezo = "";
var jsZonZonaCodNse1 = "";
var jsZonZonaCodNse2 = "";
var jsZonZonaCodNse3 = "";
var jsZonZonaIndBorr = "";
var jsZonZonaEszoOidEstaZona = "";
var jsZonZonaDesZona = "";
var jsZonZonaFecCambEsta = "";
var jsZonZonaFecRezo = "";

//Variables de paginacion, 
var zonZonaPageCount = 1;

//Varible de columna que representa el campo de choice
var zonZonaChoiceColumn = 13;

//Flag de siguiente pagina;
var zonZonaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var zonZonaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 609;
var sizeFormView = 595;
var sizeFormUpdate = 595;

//Ultima busqueda realizada
var zonZonaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("zonZonaFrm.fecRezo");','focaliza("zonZonaFrm.fecRezo");','focaliza("zonZonaFrm.fecRezo");','focaliza("zonZonaFrm.fecRezo");','focaliza("zonZonaFrm.fecRezo");','focaliza("zonZonaFrm.fecRezo");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var clieOidClieDependeceMap = new Vector();
clieOidClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clieOidClieDependeceMap.agregar(['clieOidClie', padresTmp, '', 'MaeClien']);
var zorgOidRegiDependeceMap = new Vector();
zorgOidRegiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
zorgOidRegiDependeceMap.agregar(['zorgOidRegi', padresTmp, '', 'ZonRegio']);
var eszoOidEstaZonaDependeceMap = new Vector();
eszoOidEstaZonaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
eszoOidEstaZonaDependeceMap.agregar(['eszoOidEstaZona_marcOidMarc', padresTmp, 'eszoOidEstaZona', 'SegMarca']);
padresTmp =  new Vector();
padresTmp.cargar([])
eszoOidEstaZonaDependeceMap.agregar(['eszoOidEstaZona_paisOidPais', padresTmp, 'eszoOidEstaZona', 'SegPaisView']);
padresTmp =  new Vector();
padresTmp.cargar(['eszoOidEstaZona_marcOidMarc','eszoOidEstaZona_paisOidPais'])
eszoOidEstaZonaDependeceMap.agregar(['eszoOidEstaZona', padresTmp, '', 'ZonEstadZona']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
zonZonaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var zonZonaTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function zonZonaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('zonZonaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('zonZonaFrm.accion')){
		case "query": zonZonaQueryInitComponents(); break;
		case "view": zonZonaViewInitComponents(); break;
		case "create": zonZonaCreateInitComponents(); break;
		case "update": zonZonaUpdateInitComponents(); break;
		case "remove": zonZonaRemoveInitComponents(); break;
		case "lov": zonZonaLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('zonZonaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('zonZona')) zonZonaCmdRequery();
}

function zonZonaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

function zonZonaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
}

function zonZonaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('zonZonaFrm.zorgOidRegi','S', GestionarMensaje('ZonZona.zorgOidRegi.requiered.message'));
	
	setMV('zonZonaFrm.codZona','S', GestionarMensaje('ZonZona.codZona.requiered.message'));
	
	setMV('zonZonaFrm.fecRezo','S', GestionarMensaje('ZonZona.fecRezo.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function zonZonaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('zonZonaFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		zonZonaTmpUpdateValues = zonZonaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('zonZonaFrm.zorgOidRegi','S', GestionarMensaje('ZonZona.zorgOidRegi.requiered.message'));
		setMV('zonZonaFrm.codZona','S', GestionarMensaje('ZonZona.codZona.requiered.message'));
		setMV('zonZonaFrm.fecRezo','S', GestionarMensaje('ZonZona.fecRezo.requiered.message'));
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('zonZonaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function zonZonaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	zonZonaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function zonZonaLovInitComponents(){
	zonZonaLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad
















//Función que permite cargar los datos de un elemento de lov seleccionado
function zonZonaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('zonZonaFrm.' + campo, id);
	set('zonZonaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function zonZonaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	zonZonaLovReturnParameters.id = '';
	zonZonaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function zonZonaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonZonaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = zonZonaList.codSeleccionados();
	var descripcion = zonZonaList.extraeDato(
		zonZonaList.codSeleccionados()[0], zonZonaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	zonZonaLovReturnParameters.id = codigo;
	zonZonaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function zonZonaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('zonZonaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('zonZonaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "zonZonaList", "ZonZonaConectorTransactionQuery", 
		"result_ROWSET", parametros, "zonZonaPostQueryActions(datos);"]], "", "");	
}

function zonZonaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('zonZonaFrm.lastQueryToSession'));
	var i =0;
	set('zonZonaFrm.clieOidClie', [paramsRequery.ij(i++)]);
	
	set('zonZonaFrm.zorgOidRegi', [paramsRequery.ij(i++)]);
	
	set('zonZonaFrm.codZona', paramsRequery.ij(i++));
	
	set('zonZonaFrm.indActi', paramsRequery.ij(i++));
	
	set('zonZonaFrm.indRezo', paramsRequery.ij(i++));
	
	set('zonZonaFrm.codNse1', paramsRequery.ij(i++));
	
	set('zonZonaFrm.codNse2', paramsRequery.ij(i++));
	
	set('zonZonaFrm.codNse3', paramsRequery.ij(i++));
	
	set('zonZonaFrm.indBorr', paramsRequery.ij(i++));
	
	set('zonZonaFrm.eszoOidEstaZona', [paramsRequery.ij(i++)]);
	
	set('zonZonaFrm.desZona', paramsRequery.ij(i++));
	
	set('zonZonaFrm.fecCambEsta', paramsRequery.ij(i++));
	
	set('zonZonaFrm.fecRezo', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	zonZonaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	zonZonaCmdQuery(zonZonaPageCount);
}

function zonZonaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	zonZonaPageCount = 1;
	zonZonaCmdQuery(zonZonaPageCount);
}

function zonZonaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonZonaLastQuery){
		zonZonaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	zonZonaPageCount--;
	zonZonaCmdQuery(zonZonaPageCount);
}

function zonZonaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != zonZonaLastQuery){
		zonZonaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	zonZonaPageCount++;
	zonZonaCmdQuery(zonZonaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function zonZonaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('zonZonaListLayer', 'O');
		visibilidad('zonZonaListButtonsLayer', 'O');
		if(get('zonZonaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	zonZonaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:zonZonaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, zonZonaChoiceColumn) + "</A>",
			i, zonZonaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	zonZonaList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12,13],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	zonZonaTimeStamps = datosTmp.filtrar([14],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		zonZonaMorePagesFlag = true;
		zonZonaList.eliminar(mmgPageSize, 1);
	}else{
		zonZonaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('zonZonaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('zonZonaListLayer', 'V');
	visibilidad('zonZonaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('zonZonaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	zonZonaList.display();
	
	//Actualizamos el estado de los botones 
	if(zonZonaMorePagesFlag){
		set_estado_botonera('zonZonaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('zonZonaPaginationButtonBar',
			3,"inactivo");
	}
	if(zonZonaPageCount > 1){
		set_estado_botonera('zonZonaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('zonZonaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('zonZonaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('zonZonaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function zonZonaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonZonaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('zonZonaFrm.idSelection', zonZonaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('zonZonaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = zonZonaList.codSeleccionados()[0];
		parametros["previousAction"] = get('zonZonaFrm.accion');
		parametros["accion"] = get('zonZonaFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('ZonZonaLPStartUp', get('zonZonaFrm.accion'), parametros, null, sizeFormView + 55);
		if(result == MMG_RC_OK) zonZonaCmdRequery();
	}
}

function zonZonaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonZonaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = zonZonaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('zonZonaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(zonZonaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += zonZonaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('zonZonaFrm.timestamp', timestamps);


	zonZonaFrm.oculto='S';
	envia('zonZonaFrm');
	zonZonaFrm.oculto='N';
}

function zonZonaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(zonZonaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	zonZonaViewDetail(zonZonaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function zonZonaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('zonZonaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	mostrarModalSICC('ZonZonaLPStartUp', 'view', parametros, null, sizeFormView + 55);
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
	var validacion = ValidaForm('zonZonaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		zonZonaFrm.oculto='S';
		envia('zonZonaFrm');
		zonZonaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('zonZonaFrm.clieOidClie').toString() == ''){
		set('zonZonaFrm.clieOidClie', []);
		mmgResetCombosOnCascade('clieOidClie', 'clieOidClie', 'zonZona');
		
	}
	if(get('zonZonaFrm.zorgOidRegi').toString() == ''){
		set('zonZonaFrm.zorgOidRegi', []);
		mmgResetCombosOnCascade('zorgOidRegi', 'zorgOidRegi', 'zonZona');
		
	}
	if(get('zonZonaFrm.eszoOidEstaZona').toString() == ''){
		set('zonZonaFrm.eszoOidEstaZona_marcOidMarc', []);
		mmgResetCombosOnCascade('eszoOidEstaZona_marcOidMarc', 'eszoOidEstaZona', 'zonZona');
		set('zonZonaFrm.eszoOidEstaZona_paisOidPais', []);
		mmgResetCombosOnCascade('eszoOidEstaZona_paisOidPais', 'eszoOidEstaZona', 'zonZona');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	zonZonaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('zonZonaFrm.accion');
	var origenTmp = get('zonZonaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(zonZonaBuildUpdateRecordString() != zonZonaTmpUpdateValues){
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
	document.all.zonZonaListLayer.style.display='none';
	document.all.zonZonaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.zonZonaListLayer.style.display='';
	document.all.zonZonaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsZonZonaClieOidClie = get('zonZonaFrm.clieOidClie')[0];
	jsZonZonaZorgOidRegi = get('zonZonaFrm.zorgOidRegi')[0];
	jsZonZonaCodZona = get('zonZonaFrm.codZona').toString();
	jsZonZonaIndActi = get('zonZonaFrm.indActi').toString();
	jsZonZonaIndRezo = get('zonZonaFrm.indRezo').toString();
	jsZonZonaCodNse1 = get('zonZonaFrm.codNse1').toString();
	jsZonZonaCodNse2 = get('zonZonaFrm.codNse2').toString();
	jsZonZonaCodNse3 = get('zonZonaFrm.codNse3').toString();
	jsZonZonaIndBorr = get('zonZonaFrm.indBorr').toString();
	jsZonZonaEszoOidEstaZona = get('zonZonaFrm.eszoOidEstaZona')[0];
	jsZonZonaDesZona = get('zonZonaFrm.desZona').toString();
	jsZonZonaFecCambEsta = get('zonZonaFrm.fecCambEsta').toString();
	jsZonZonaFecRezo = get('zonZonaFrm.fecRezo').toString();
	
	
	var parametros = "";
	parametros += jsZonZonaClieOidClie + "|";
	parametros += jsZonZonaZorgOidRegi + "|";
	parametros += jsZonZonaCodZona + "|";
	parametros += jsZonZonaIndActi + "|";
	parametros += jsZonZonaIndRezo + "|";
	parametros += jsZonZonaCodNse1 + "|";
	parametros += jsZonZonaCodNse2 + "|";
	parametros += jsZonZonaCodNse3 + "|";
	parametros += jsZonZonaIndBorr + "|";
	parametros += jsZonZonaEszoOidEstaZona + "|";
	parametros += jsZonZonaDesZona + "|";
	parametros += jsZonZonaFecCambEsta + "|";
	parametros += jsZonZonaFecRezo + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function zonZonaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsZonZonaClieOidClie + "|";
	parametros += jsZonZonaZorgOidRegi + "|";
	parametros += jsZonZonaCodZona + "|";
	parametros += jsZonZonaIndActi + "|";
	parametros += jsZonZonaIndRezo + "|";
	parametros += jsZonZonaCodNse1 + "|";
	parametros += jsZonZonaCodNse2 + "|";
	parametros += jsZonZonaCodNse3 + "|";
	parametros += jsZonZonaIndBorr + "|";
	parametros += jsZonZonaEszoOidEstaZona + "|";
	parametros += jsZonZonaDesZona + "|";
	parametros += jsZonZonaFecCambEsta + "|";
	parametros += jsZonZonaFecRezo + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonZonaFrm.accion'), 
		get('zonZonaFrm.origen'));
	
	jsZonZonaId = get('zonZonaFrm.id').toString();
	jsZonZonaClieOidClie = get('zonZonaFrm.clieOidClie')[0];
	jsZonZonaZorgOidRegi = get('zonZonaFrm.zorgOidRegi')[0];
	jsZonZonaCodZona = get('zonZonaFrm.codZona').toString();
	jsZonZonaIndActi = get('zonZonaFrm.indActi').toString();
	jsZonZonaIndRezo = get('zonZonaFrm.indRezo').toString();
	jsZonZonaCodNse1 = get('zonZonaFrm.codNse1').toString();
	jsZonZonaCodNse2 = get('zonZonaFrm.codNse2').toString();
	jsZonZonaCodNse3 = get('zonZonaFrm.codNse3').toString();
	jsZonZonaIndBorr = get('zonZonaFrm.indBorr').toString();
	jsZonZonaEszoOidEstaZona = get('zonZonaFrm.eszoOidEstaZona')[0];
	jsZonZonaDesZona = get('zonZonaFrm.desZona').toString();
	jsZonZonaFecCambEsta = get('zonZonaFrm.fecCambEsta').toString();
	jsZonZonaFecRezo = get('zonZonaFrm.fecRezo').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('zonZonaFrm.accion'), 
		get('zonZonaFrm.origen'));


	set('zonZonaFrm.id', jsZonZonaId);
	set('zonZonaFrm.clieOidClie', [jsZonZonaClieOidClie]);
	set('zonZonaFrm.zorgOidRegi', [jsZonZonaZorgOidRegi]);
	set('zonZonaFrm.codZona', jsZonZonaCodZona);
	set('zonZonaFrm.indActi', jsZonZonaIndActi);
	set('zonZonaFrm.indRezo', jsZonZonaIndRezo);
	set('zonZonaFrm.codNse1', jsZonZonaCodNse1);
	set('zonZonaFrm.codNse2', jsZonZonaCodNse2);
	set('zonZonaFrm.codNse3', jsZonZonaCodNse3);
	set('zonZonaFrm.indBorr', jsZonZonaIndBorr);
	set('zonZonaFrm.eszoOidEstaZona', [jsZonZonaEszoOidEstaZona]);
	set('zonZonaFrm.desZona', jsZonZonaDesZona);
	set('zonZonaFrm.fecCambEsta', jsZonZonaFecCambEsta);
	set('zonZonaFrm.fecRezo', jsZonZonaFecRezo);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realziar la búsqueda
	jsZonZonaClieOidClie = '';
	jsZonZonaZorgOidRegi = '';
	jsZonZonaCodZona = '';
	jsZonZonaIndActi = '';
	jsZonZonaIndRezo = '';
	jsZonZonaCodNse1 = '';
	jsZonZonaCodNse2 = '';
	jsZonZonaCodNse3 = '';
	jsZonZonaIndBorr = '';
	jsZonZonaEszoOidEstaZona = '';
	jsZonZonaDesZona = '';
	jsZonZonaFecCambEsta = '';
	jsZonZonaFecRezo = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('zonZonaFrm.errCodigo', errorCode);
	set('zonZonaFrm.errDescripcion', description);
	set('zonZonaFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
