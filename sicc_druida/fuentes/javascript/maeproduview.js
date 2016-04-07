

/*
    INDRA/CAR/mmg
    $Id: maeproduview.js,v 1.1 2009/12/03 19:02:12 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeProduViewId = "";
var jsMaeProduViewPaisOidPais = "";
var jsMaeProduViewCodSap = "";
var jsMaeProduViewCodiAnti = "";
var jsMaeProduViewDesCort = "";
var jsMaeProduViewValJera1 = "";
var jsMaeProduViewValJera2 = "";
var jsMaeProduViewValJera3 = "";
var jsMaeProduViewValAtri1 = "";
var jsMaeProduViewValAtri2 = "";
var jsMaeProduViewValAtri3 = "";
var jsMaeProduViewValDimeAlto = "";
var jsMaeProduViewValDimeLarg = "";
var jsMaeProduViewValDimeAnch = "";
var jsMaeProduViewValPeso = "";
var jsMaeProduViewValVolu = "";
var jsMaeProduViewValCostEstd = "";
var jsMaeProduViewValPrecPosi = "";
var jsMaeProduViewValPrecCata = "";
var jsMaeProduViewValPrecCont = "";
var jsMaeProduViewNumUnidDentPedi = "";
var jsMaeProduViewNumUnidCaja = "";
var jsMaeProduViewCodImpu = "";
var jsMaeProduViewPctUnid = "";
var jsMaeProduViewIndLote = "";
var jsMaeProduViewIndProdServ = "";
var jsMaeProduViewCodIndSitu = "";
var jsMaeProduViewCodIndDentCaja = "";
var jsMaeProduViewIndKit = "";
var jsMaeProduViewValGrupArti = "";

//Variables de paginacion, 
var maeProduViewPageCount = 1;

//Varible de columna que representa el campo de choice
var maeProduViewChoiceColumn = 1;

//Flag de siguiente pagina;
var maeProduViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeProduViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 1281;
var sizeFormView = 1263;
var sizeFormUpdate = 1263;

//Ultima busqueda realizada
var maeProduViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("maeProduViewFrm.valGrupArti");','focaliza("maeProduViewFrm.valGrupArti");','focaliza("maeProduViewFrm.valGrupArti");','focaliza("maeProduViewFrm.valGrupArti");','focaliza("maeProduViewFrm.valGrupArti");','focaliza("maeProduViewFrm.valGrupArti");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[0,'focaliza("maeProduViewFrm.valGrupArti");','focaliza("maeProduViewFrm.valGrupArti");','focaliza("maeProduViewFrm.valGrupArti");','focaliza("maeProduViewFrm.valGrupArti");','focaliza("maeProduViewFrm.valGrupArti");','focaliza("maeProduViewFrm.valGrupArti");']]);

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
maeProduViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeProduViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function maeProduViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeProduViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeProduViewFrm.accion')){
		case "query": maeProduViewQueryInitComponents(); break;
		case "view": maeProduViewViewInitComponents(); break;
		case "create": maeProduViewCreateInitComponents(); break;
		case "update": maeProduViewUpdateInitComponents(); break;
		case "remove": maeProduViewRemoveInitComponents(); break;
		case "lov": maeProduViewLovInitComponents(); break;
	}
	//alert('accion :' + get('maeProduViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('maeProduViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeProduView')) maeProduViewCmdRequery();
}

function maeProduViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('maeProduViewFrm', true);	
}

function maeProduViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('maeProduViewFrm', true);
}

function maeProduViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeProduViewFrm.paisOidPais','S', GestionarMensaje('MaeProduView.paisOidPais.requiered.message'));
	
	setMV('maeProduViewFrm.codSap','S', GestionarMensaje('MaeProduView.codSap.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('maeProduViewFrm', true);
}

function maeProduViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeProduViewFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		maeProduViewTmpUpdateValues = maeProduViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeProduViewFrm.paisOidPais','S', GestionarMensaje('MaeProduView.paisOidPais.requiered.message'));
		setMV('maeProduViewFrm.codSap','S', GestionarMensaje('MaeProduView.codSap.requiered.message'));
		
			focusFirstFieldModify('maeProduViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('maeProduViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeProduViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeProduViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeProduViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('maeProduViewFrm', true);
}

function maeProduViewLovInitComponents(){
	maeProduViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('maeProduViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad
































//Función que permite cargar los datos de un elemento de lov seleccionado
function maeProduViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeProduViewFrm.' + campo, id);
	set('maeProduViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeProduViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeProduViewLovReturnParameters.id = '';
	maeProduViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeProduViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeProduViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeProduViewList.codSeleccionados();
	var descripcion = maeProduViewList.extraeDato(
		maeProduViewList.codSeleccionados()[0], maeProduViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeProduViewLovReturnParameters.id = codigo;
	maeProduViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeProduViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeProduViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeProduViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeProduViewList", "MaeProduViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeProduViewPostQueryActions(datos);"]], "", "");	
}

function maeProduViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeProduViewFrm.lastQueryToSession'));
	var i =0;
	set('maeProduViewFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('maeProduViewFrm.codSap', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.codiAnti', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.desCort', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valJera1', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valJera2', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valJera3', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valAtri1', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valAtri2', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valAtri3', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valDimeAlto', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valDimeLarg', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valDimeAnch', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valPeso', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valVolu', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valCostEstd', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valPrecPosi', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valPrecCata', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valPrecCont', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.numUnidDentPedi', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.numUnidCaja', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.codImpu', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.pctUnid', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.indLote', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.indProdServ', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.codIndSitu', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.codIndDentCaja', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.indKit', paramsRequery.ij(i++));
	
	set('maeProduViewFrm.valGrupArti', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	maeProduViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeProduViewCmdQuery(maeProduViewPageCount);
}

function maeProduViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeProduViewPageCount = 1;
	maeProduViewCmdQuery(maeProduViewPageCount);
}

function maeProduViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeProduViewLastQuery){
		maeProduViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeProduViewPageCount--;
	maeProduViewCmdQuery(maeProduViewPageCount);
}

function maeProduViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeProduViewLastQuery){
		maeProduViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeProduViewPageCount++;
	maeProduViewCmdQuery(maeProduViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeProduViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeProduViewListLayer', 'O');
		visibilidad('maeProduViewListButtonsLayer', 'O');
		if(get('maeProduViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeProduViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeProduViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeProduViewChoiceColumn) + "</A>",
			i, maeProduViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeProduViewList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeProduViewTimeStamps = datosTmp.filtrar([30],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeProduViewMorePagesFlag = true;
		maeProduViewList.eliminar(mmgPageSize, 1);
	}else{
		maeProduViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeProduViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeProduViewListLayer', 'V');
	visibilidad('maeProduViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeProduViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeProduViewList.display();
	
	//Actualizamos el estado de los botones 
	if(maeProduViewMorePagesFlag){
		set_estado_botonera('maeProduViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeProduViewPaginationButtonBar',
			3,"inactivo");
	}
	if(maeProduViewPageCount > 1){
		set_estado_botonera('maeProduViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeProduViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeProduViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeProduViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeProduViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeProduViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeProduViewFrm.idSelection', maeProduViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeProduViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = maeProduViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeProduViewFrm.accion');
		parametros["accion"] = get('maeProduViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('MaeProduViewLPStartUp', get('maeProduViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) maeProduViewCmdRequery();
	}
}

function maeProduViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeProduViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeProduViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeProduViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeProduViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeProduViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeProduViewFrm.timestamp', timestamps);


	maeProduViewFrm.oculto='S';
	envia('maeProduViewFrm');
	maeProduViewFrm.oculto='N';
}

function maeProduViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeProduViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	maeProduViewViewDetail(maeProduViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeProduViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeProduViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('MaeProduViewLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('maeProduViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		maeProduViewFrm.oculto='S';
		envia('maeProduViewFrm');
		maeProduViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('maeProduViewFrm.paisOidPais').toString() == ''){
		set('maeProduViewFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'maeProduView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeProduViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeProduViewFrm.accion');
	var origenTmp = get('maeProduViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeProduViewBuildUpdateRecordString() != maeProduViewTmpUpdateValues){
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
	document.all.maeProduViewListLayer.style.display='none';
	document.all.maeProduViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeProduViewListLayer.style.display='';
	document.all.maeProduViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsMaeProduViewPaisOidPais = get('maeProduViewFrm.paisOidPais')[0];
	jsMaeProduViewCodSap = get('maeProduViewFrm.codSap').toString();
	jsMaeProduViewCodiAnti = get('maeProduViewFrm.codiAnti').toString();
	jsMaeProduViewDesCort = get('maeProduViewFrm.desCort').toString();
	jsMaeProduViewValJera1 = get('maeProduViewFrm.valJera1').toString();
	jsMaeProduViewValJera2 = get('maeProduViewFrm.valJera2').toString();
	jsMaeProduViewValJera3 = get('maeProduViewFrm.valJera3').toString();
	jsMaeProduViewValAtri1 = get('maeProduViewFrm.valAtri1').toString();
	jsMaeProduViewValAtri2 = get('maeProduViewFrm.valAtri2').toString();
	jsMaeProduViewValAtri3 = get('maeProduViewFrm.valAtri3').toString();
	jsMaeProduViewValDimeAlto = get('maeProduViewFrm.valDimeAlto').toString();
	jsMaeProduViewValDimeLarg = get('maeProduViewFrm.valDimeLarg').toString();
	jsMaeProduViewValDimeAnch = get('maeProduViewFrm.valDimeAnch').toString();
	jsMaeProduViewValPeso = get('maeProduViewFrm.valPeso').toString();
	jsMaeProduViewValVolu = get('maeProduViewFrm.valVolu').toString();
	jsMaeProduViewValCostEstd = get('maeProduViewFrm.valCostEstd').toString();
	jsMaeProduViewValPrecPosi = get('maeProduViewFrm.valPrecPosi').toString();
	jsMaeProduViewValPrecCata = get('maeProduViewFrm.valPrecCata').toString();
	jsMaeProduViewValPrecCont = get('maeProduViewFrm.valPrecCont').toString();
	jsMaeProduViewNumUnidDentPedi = get('maeProduViewFrm.numUnidDentPedi').toString();
	jsMaeProduViewNumUnidCaja = get('maeProduViewFrm.numUnidCaja').toString();
	jsMaeProduViewCodImpu = get('maeProduViewFrm.codImpu').toString();
	jsMaeProduViewPctUnid = get('maeProduViewFrm.pctUnid').toString();
	jsMaeProduViewIndLote = get('maeProduViewFrm.indLote').toString();
	jsMaeProduViewIndProdServ = get('maeProduViewFrm.indProdServ').toString();
	jsMaeProduViewCodIndSitu = get('maeProduViewFrm.codIndSitu').toString();
	jsMaeProduViewCodIndDentCaja = get('maeProduViewFrm.codIndDentCaja').toString();
	jsMaeProduViewIndKit = get('maeProduViewFrm.indKit').toString();
	jsMaeProduViewValGrupArti = get('maeProduViewFrm.valGrupArti').toString();
	
	
	var parametros = "";
	parametros += jsMaeProduViewPaisOidPais + "|";
	parametros += jsMaeProduViewCodSap + "|";
	parametros += jsMaeProduViewCodiAnti + "|";
	parametros += jsMaeProduViewDesCort + "|";
	parametros += jsMaeProduViewValJera1 + "|";
	parametros += jsMaeProduViewValJera2 + "|";
	parametros += jsMaeProduViewValJera3 + "|";
	parametros += jsMaeProduViewValAtri1 + "|";
	parametros += jsMaeProduViewValAtri2 + "|";
	parametros += jsMaeProduViewValAtri3 + "|";
	parametros += jsMaeProduViewValDimeAlto + "|";
	parametros += jsMaeProduViewValDimeLarg + "|";
	parametros += jsMaeProduViewValDimeAnch + "|";
	parametros += jsMaeProduViewValPeso + "|";
	parametros += jsMaeProduViewValVolu + "|";
	parametros += jsMaeProduViewValCostEstd + "|";
	parametros += jsMaeProduViewValPrecPosi + "|";
	parametros += jsMaeProduViewValPrecCata + "|";
	parametros += jsMaeProduViewValPrecCont + "|";
	parametros += jsMaeProduViewNumUnidDentPedi + "|";
	parametros += jsMaeProduViewNumUnidCaja + "|";
	parametros += jsMaeProduViewCodImpu + "|";
	parametros += jsMaeProduViewPctUnid + "|";
	parametros += jsMaeProduViewIndLote + "|";
	parametros += jsMaeProduViewIndProdServ + "|";
	parametros += jsMaeProduViewCodIndSitu + "|";
	parametros += jsMaeProduViewCodIndDentCaja + "|";
	parametros += jsMaeProduViewIndKit + "|";
	parametros += jsMaeProduViewValGrupArti + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeProduViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeProduViewPaisOidPais + "|";
	parametros += jsMaeProduViewCodSap + "|";
	parametros += jsMaeProduViewCodiAnti + "|";
	parametros += jsMaeProduViewDesCort + "|";
	parametros += jsMaeProduViewValJera1 + "|";
	parametros += jsMaeProduViewValJera2 + "|";
	parametros += jsMaeProduViewValJera3 + "|";
	parametros += jsMaeProduViewValAtri1 + "|";
	parametros += jsMaeProduViewValAtri2 + "|";
	parametros += jsMaeProduViewValAtri3 + "|";
	parametros += jsMaeProduViewValDimeAlto + "|";
	parametros += jsMaeProduViewValDimeLarg + "|";
	parametros += jsMaeProduViewValDimeAnch + "|";
	parametros += jsMaeProduViewValPeso + "|";
	parametros += jsMaeProduViewValVolu + "|";
	parametros += jsMaeProduViewValCostEstd + "|";
	parametros += jsMaeProduViewValPrecPosi + "|";
	parametros += jsMaeProduViewValPrecCata + "|";
	parametros += jsMaeProduViewValPrecCont + "|";
	parametros += jsMaeProduViewNumUnidDentPedi + "|";
	parametros += jsMaeProduViewNumUnidCaja + "|";
	parametros += jsMaeProduViewCodImpu + "|";
	parametros += jsMaeProduViewPctUnid + "|";
	parametros += jsMaeProduViewIndLote + "|";
	parametros += jsMaeProduViewIndProdServ + "|";
	parametros += jsMaeProduViewCodIndSitu + "|";
	parametros += jsMaeProduViewCodIndDentCaja + "|";
	parametros += jsMaeProduViewIndKit + "|";
	parametros += jsMaeProduViewValGrupArti + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeProduViewFrm.accion'), 
		get('maeProduViewFrm.origen'));
	
	jsMaeProduViewId = get('maeProduViewFrm.id').toString();
	jsMaeProduViewPaisOidPais = get('maeProduViewFrm.paisOidPais')[0];
	jsMaeProduViewCodSap = get('maeProduViewFrm.codSap').toString();
	jsMaeProduViewCodiAnti = get('maeProduViewFrm.codiAnti').toString();
	jsMaeProduViewDesCort = get('maeProduViewFrm.desCort').toString();
	jsMaeProduViewValJera1 = get('maeProduViewFrm.valJera1').toString();
	jsMaeProduViewValJera2 = get('maeProduViewFrm.valJera2').toString();
	jsMaeProduViewValJera3 = get('maeProduViewFrm.valJera3').toString();
	jsMaeProduViewValAtri1 = get('maeProduViewFrm.valAtri1').toString();
	jsMaeProduViewValAtri2 = get('maeProduViewFrm.valAtri2').toString();
	jsMaeProduViewValAtri3 = get('maeProduViewFrm.valAtri3').toString();
	jsMaeProduViewValDimeAlto = get('maeProduViewFrm.valDimeAlto').toString();
	jsMaeProduViewValDimeLarg = get('maeProduViewFrm.valDimeLarg').toString();
	jsMaeProduViewValDimeAnch = get('maeProduViewFrm.valDimeAnch').toString();
	jsMaeProduViewValPeso = get('maeProduViewFrm.valPeso').toString();
	jsMaeProduViewValVolu = get('maeProduViewFrm.valVolu').toString();
	jsMaeProduViewValCostEstd = get('maeProduViewFrm.valCostEstd').toString();
	jsMaeProduViewValPrecPosi = get('maeProduViewFrm.valPrecPosi').toString();
	jsMaeProduViewValPrecCata = get('maeProduViewFrm.valPrecCata').toString();
	jsMaeProduViewValPrecCont = get('maeProduViewFrm.valPrecCont').toString();
	jsMaeProduViewNumUnidDentPedi = get('maeProduViewFrm.numUnidDentPedi').toString();
	jsMaeProduViewNumUnidCaja = get('maeProduViewFrm.numUnidCaja').toString();
	jsMaeProduViewCodImpu = get('maeProduViewFrm.codImpu').toString();
	jsMaeProduViewPctUnid = get('maeProduViewFrm.pctUnid').toString();
	jsMaeProduViewIndLote = get('maeProduViewFrm.indLote').toString();
	jsMaeProduViewIndProdServ = get('maeProduViewFrm.indProdServ').toString();
	jsMaeProduViewCodIndSitu = get('maeProduViewFrm.codIndSitu').toString();
	jsMaeProduViewCodIndDentCaja = get('maeProduViewFrm.codIndDentCaja').toString();
	jsMaeProduViewIndKit = get('maeProduViewFrm.indKit').toString();
	jsMaeProduViewValGrupArti = get('maeProduViewFrm.valGrupArti').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeProduViewFrm.accion'), 
		get('maeProduViewFrm.origen'));


	set('maeProduViewFrm.id', jsMaeProduViewId);
	set('maeProduViewFrm.paisOidPais', [jsMaeProduViewPaisOidPais]);
	set('maeProduViewFrm.codSap', jsMaeProduViewCodSap);
	set('maeProduViewFrm.codiAnti', jsMaeProduViewCodiAnti);
	set('maeProduViewFrm.desCort', jsMaeProduViewDesCort);
	set('maeProduViewFrm.valJera1', jsMaeProduViewValJera1);
	set('maeProduViewFrm.valJera2', jsMaeProduViewValJera2);
	set('maeProduViewFrm.valJera3', jsMaeProduViewValJera3);
	set('maeProduViewFrm.valAtri1', jsMaeProduViewValAtri1);
	set('maeProduViewFrm.valAtri2', jsMaeProduViewValAtri2);
	set('maeProduViewFrm.valAtri3', jsMaeProduViewValAtri3);
	set('maeProduViewFrm.valDimeAlto', jsMaeProduViewValDimeAlto);
	set('maeProduViewFrm.valDimeLarg', jsMaeProduViewValDimeLarg);
	set('maeProduViewFrm.valDimeAnch', jsMaeProduViewValDimeAnch);
	set('maeProduViewFrm.valPeso', jsMaeProduViewValPeso);
	set('maeProduViewFrm.valVolu', jsMaeProduViewValVolu);
	set('maeProduViewFrm.valCostEstd', jsMaeProduViewValCostEstd);
	set('maeProduViewFrm.valPrecPosi', jsMaeProduViewValPrecPosi);
	set('maeProduViewFrm.valPrecCata', jsMaeProduViewValPrecCata);
	set('maeProduViewFrm.valPrecCont', jsMaeProduViewValPrecCont);
	set('maeProduViewFrm.numUnidDentPedi', jsMaeProduViewNumUnidDentPedi);
	set('maeProduViewFrm.numUnidCaja', jsMaeProduViewNumUnidCaja);
	set('maeProduViewFrm.codImpu', jsMaeProduViewCodImpu);
	set('maeProduViewFrm.pctUnid', jsMaeProduViewPctUnid);
	set('maeProduViewFrm.indLote', jsMaeProduViewIndLote);
	set('maeProduViewFrm.indProdServ', jsMaeProduViewIndProdServ);
	set('maeProduViewFrm.codIndSitu', jsMaeProduViewCodIndSitu);
	set('maeProduViewFrm.codIndDentCaja', jsMaeProduViewCodIndDentCaja);
	set('maeProduViewFrm.indKit', jsMaeProduViewIndKit);
	set('maeProduViewFrm.valGrupArti', jsMaeProduViewValGrupArti);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsMaeProduViewPaisOidPais = '';
	jsMaeProduViewCodSap = '';
	jsMaeProduViewCodiAnti = '';
	jsMaeProduViewDesCort = '';
	jsMaeProduViewValJera1 = '';
	jsMaeProduViewValJera2 = '';
	jsMaeProduViewValJera3 = '';
	jsMaeProduViewValAtri1 = '';
	jsMaeProduViewValAtri2 = '';
	jsMaeProduViewValAtri3 = '';
	jsMaeProduViewValDimeAlto = '';
	jsMaeProduViewValDimeLarg = '';
	jsMaeProduViewValDimeAnch = '';
	jsMaeProduViewValPeso = '';
	jsMaeProduViewValVolu = '';
	jsMaeProduViewValCostEstd = '';
	jsMaeProduViewValPrecPosi = '';
	jsMaeProduViewValPrecCata = '';
	jsMaeProduViewValPrecCont = '';
	jsMaeProduViewNumUnidDentPedi = '';
	jsMaeProduViewNumUnidCaja = '';
	jsMaeProduViewCodImpu = '';
	jsMaeProduViewPctUnid = '';
	jsMaeProduViewIndLote = '';
	jsMaeProduViewIndProdServ = '';
	jsMaeProduViewCodIndSitu = '';
	jsMaeProduViewCodIndDentCaja = '';
	jsMaeProduViewIndKit = '';
	jsMaeProduViewValGrupArti = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeProduViewFrm.errCodigo', errorCode);
	set('maeProduViewFrm.errDescripcion', description);
	set('maeProduViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
