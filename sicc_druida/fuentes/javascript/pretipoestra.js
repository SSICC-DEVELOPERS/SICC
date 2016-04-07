

/*
    INDRA/CAR/mmg
    $Id: pretipoestra.js,v 1.1 2009/12/03 19:02:19 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPreTipoEstraId = "";
var jsPreTipoEstraCodTipoEstr = "";
var jsPreTipoEstraDesTipoEstr = "";
var jsPreTipoEstraIndEstrGrup = "";
var jsPreTipoEstraIndEstrCond = "";
var jsPreTipoEstraIndEstrVs = "";
var jsPreTipoEstraIndEstrPaqu = "";

//Variables de paginacion, 
var preTipoEstraPageCount = 1;

//Varible de columna que representa el campo de choice
var preTipoEstraChoiceColumn = 1;

//Flag de siguiente pagina;
var preTipoEstraMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var preTipoEstraTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 315;
var sizeFormView = 297;
var sizeFormUpdate = 297;

//Ultima busqueda realizada
var preTipoEstraLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("preTipoEstraFrm.codTipoEstr");','focaliza("preTipoEstraFrm.codTipoEstr");','focaliza("preTipoEstraFrm.codTipoEstr");','focaliza("preTipoEstraFrm.codTipoEstr");','focaliza("preTipoEstraFrm.codTipoEstr");','focaliza("preTipoEstraFrm.codTipoEstr");'],[3,'focaliza("preTipoEstraFrm.desTipoEstr");','focaliza("preTipoEstraFrm.desTipoEstr");','focaliza("preTipoEstraFrm.desTipoEstr");','focaliza("preTipoEstraFrm.desTipoEstr");','focaliza("preTipoEstraFrm.desTipoEstr");','focaliza("preTipoEstraFrm.desTipoEstr");'],[4,'focaliza("preTipoEstraFrm.indEstrGrup");','focaliza("preTipoEstraFrm.indEstrGrup");','focaliza("preTipoEstraFrm.indEstrGrup");','focaliza("preTipoEstraFrm.indEstrGrup");','focaliza("preTipoEstraFrm.indEstrGrup");','focaliza("preTipoEstraFrm.indEstrGrup");'],[5,'focaliza("preTipoEstraFrm.indEstrCond");','focaliza("preTipoEstraFrm.indEstrCond");','focaliza("preTipoEstraFrm.indEstrCond");','focaliza("preTipoEstraFrm.indEstrCond");','focaliza("preTipoEstraFrm.indEstrCond");','focaliza("preTipoEstraFrm.indEstrCond");'],[6,'focaliza("preTipoEstraFrm.indEstrVs");','focaliza("preTipoEstraFrm.indEstrVs");','focaliza("preTipoEstraFrm.indEstrVs");','focaliza("preTipoEstraFrm.indEstrVs");','focaliza("preTipoEstraFrm.indEstrVs");','focaliza("preTipoEstraFrm.indEstrVs");'],[7,'focaliza("preTipoEstraFrm.indEstrPaqu");','focaliza("preTipoEstraFrm.indEstrPaqu");','focaliza("preTipoEstraFrm.indEstrPaqu");','focaliza("preTipoEstraFrm.indEstrPaqu");','focaliza("preTipoEstraFrm.indEstrPaqu");','focaliza("preTipoEstraFrm.indEstrPaqu");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("preTipoEstraFrm.codTipoEstr");','focaliza("preTipoEstraFrm.codTipoEstr");','focaliza("preTipoEstraFrm.codTipoEstr");','focaliza("preTipoEstraFrm.codTipoEstr");','focaliza("preTipoEstraFrm.codTipoEstr");','focaliza("preTipoEstraFrm.codTipoEstr");'],[3,'focaliza("preTipoEstraFrm.desTipoEstr");','focaliza("preTipoEstraFrm.desTipoEstr");','focaliza("preTipoEstraFrm.desTipoEstr");','focaliza("preTipoEstraFrm.desTipoEstr");','focaliza("preTipoEstraFrm.desTipoEstr");','focaliza("preTipoEstraFrm.desTipoEstr");'],[4,'focaliza("preTipoEstraFrm.indEstrGrup");','focaliza("preTipoEstraFrm.indEstrGrup");','focaliza("preTipoEstraFrm.indEstrGrup");','focaliza("preTipoEstraFrm.indEstrGrup");','focaliza("preTipoEstraFrm.indEstrGrup");','focaliza("preTipoEstraFrm.indEstrGrup");'],[5,'focaliza("preTipoEstraFrm.indEstrCond");','focaliza("preTipoEstraFrm.indEstrCond");','focaliza("preTipoEstraFrm.indEstrCond");','focaliza("preTipoEstraFrm.indEstrCond");','focaliza("preTipoEstraFrm.indEstrCond");','focaliza("preTipoEstraFrm.indEstrCond");'],[6,'focaliza("preTipoEstraFrm.indEstrVs");','focaliza("preTipoEstraFrm.indEstrVs");','focaliza("preTipoEstraFrm.indEstrVs");','focaliza("preTipoEstraFrm.indEstrVs");','focaliza("preTipoEstraFrm.indEstrVs");','focaliza("preTipoEstraFrm.indEstrVs");'],[7,'focaliza("preTipoEstraFrm.indEstrPaqu");','focaliza("preTipoEstraFrm.indEstrPaqu");','focaliza("preTipoEstraFrm.indEstrPaqu");','focaliza("preTipoEstraFrm.indEstrPaqu");','focaliza("preTipoEstraFrm.indEstrPaqu");','focaliza("preTipoEstraFrm.indEstrPaqu");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
preTipoEstraLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var preTipoEstraTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function preTipoEstraInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('preTipoEstraFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('preTipoEstraFrm.accion')){
		case "query": preTipoEstraQueryInitComponents(); break;
		case "view": preTipoEstraViewInitComponents(); break;
		case "create": preTipoEstraCreateInitComponents(); break;
		case "update": preTipoEstraUpdateInitComponents(); break;
		case "remove": preTipoEstraRemoveInitComponents(); break;
		case "lov": preTipoEstraLovInitComponents(); break;
	}
	//alert('accion :' + get('preTipoEstraFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('preTipoEstraFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('preTipoEstra')) preTipoEstraCmdRequery();
}

function preTipoEstraQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	focusFirstField('preTipoEstraFrm', true);	
}

function preTipoEstraViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('preTipoEstraFrm', true);
}

function preTipoEstraCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('preTipoEstraFrm.codTipoEstr','S', GestionarMensaje('PreTipoEstra.codTipoEstr.requiered.message'));
	
	setMV('preTipoEstraFrm.desTipoEstr','S', GestionarMensaje('PreTipoEstra.desTipoEstr.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('preTipoEstraFrm', true);
}

function preTipoEstraUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('preTipoEstraFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		preTipoEstraTmpUpdateValues = preTipoEstraBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('preTipoEstraFrm.codTipoEstr','S', GestionarMensaje('PreTipoEstra.codTipoEstr.requiered.message'));
		setMV('preTipoEstraFrm.desTipoEstr','S', GestionarMensaje('PreTipoEstra.desTipoEstr.requiered.message'));
		
			focusFirstFieldModify('preTipoEstraFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		focusFirstField('preTipoEstraFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('preTipoEstraFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function preTipoEstraRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	preTipoEstraList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('preTipoEstraFrm', true);
}

function preTipoEstraLovInitComponents(){
	preTipoEstraLovReturnParameters = window.dialogArguments;
	
	focusFirstField('preTipoEstraFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad









//Función que permite cargar los datos de un elemento de lov seleccionado
function preTipoEstraSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('preTipoEstraFrm.' + campo, id);
	set('preTipoEstraFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function preTipoEstraLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	preTipoEstraLovReturnParameters.id = '';
	preTipoEstraLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function preTipoEstraLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preTipoEstraList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = preTipoEstraList.codSeleccionados();
	var descripcion = preTipoEstraList.extraeDato(
		preTipoEstraList.codSeleccionados()[0], preTipoEstraChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	preTipoEstraLovReturnParameters.id = codigo;
	preTipoEstraLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function preTipoEstraCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('preTipoEstraFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('preTipoEstraFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "preTipoEstraList", "PreTipoEstraConectorTransactionQuery", 
		"result_ROWSET", parametros, "preTipoEstraPostQueryActions(datos);"]], "", "");	
}

function preTipoEstraCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('preTipoEstraFrm.lastQueryToSession'));
	var i =0;
	set('preTipoEstraFrm.codTipoEstr', paramsRequery.ij(i++));
	
	set('preTipoEstraFrm.desTipoEstr', paramsRequery.ij(i++));
	
	set('preTipoEstraFrm.indEstrGrup', paramsRequery.ij(i++));
	
	set('preTipoEstraFrm.indEstrCond', paramsRequery.ij(i++));
	
	set('preTipoEstraFrm.indEstrVs', paramsRequery.ij(i++));
	
	set('preTipoEstraFrm.indEstrPaqu', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	preTipoEstraPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	preTipoEstraCmdQuery(preTipoEstraPageCount);
}

function preTipoEstraFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	preTipoEstraPageCount = 1;
	preTipoEstraCmdQuery(preTipoEstraPageCount);
}

function preTipoEstraPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preTipoEstraLastQuery){
		preTipoEstraFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	preTipoEstraPageCount--;
	preTipoEstraCmdQuery(preTipoEstraPageCount);
}

function preTipoEstraNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preTipoEstraLastQuery){
		preTipoEstraFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	preTipoEstraPageCount++;
	preTipoEstraCmdQuery(preTipoEstraPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function preTipoEstraPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('preTipoEstraListLayer', 'O');
		visibilidad('preTipoEstraListButtonsLayer', 'O');
		if(get('preTipoEstraFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	preTipoEstraLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:preTipoEstraViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, preTipoEstraChoiceColumn) + "</A>",
			i, preTipoEstraChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	preTipoEstraList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	preTipoEstraTimeStamps = datosTmp.filtrar([7],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		preTipoEstraMorePagesFlag = true;
		preTipoEstraList.eliminar(mmgPageSize, 1);
	}else{
		preTipoEstraMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('preTipoEstraFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('preTipoEstraListLayer', 'V');
	visibilidad('preTipoEstraListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('preTipoEstraList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	preTipoEstraList.display();
	
	//Actualizamos el estado de los botones 
	if(preTipoEstraMorePagesFlag){
		set_estado_botonera('preTipoEstraPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('preTipoEstraPaginationButtonBar',
			3,"inactivo");
	}
	if(preTipoEstraPageCount > 1){
		set_estado_botonera('preTipoEstraPaginationButtonBar',
			2,"activo");
		set_estado_botonera('preTipoEstraPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('preTipoEstraPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('preTipoEstraPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function preTipoEstraUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preTipoEstraList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('preTipoEstraFrm.idSelection', preTipoEstraList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('preTipoEstraFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = preTipoEstraList.codSeleccionados()[0];
		parametros["previousAction"] = get('preTipoEstraFrm.accion');
		parametros["accion"] = get('preTipoEstraFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PreTipoEstraLPStartUp', get('preTipoEstraFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) preTipoEstraCmdRequery();
	}
}

function preTipoEstraRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preTipoEstraList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = preTipoEstraList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('preTipoEstraFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(preTipoEstraList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += preTipoEstraTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('preTipoEstraFrm.timestamp', timestamps);


	preTipoEstraFrm.oculto='S';
	envia('preTipoEstraFrm');
	preTipoEstraFrm.oculto='N';
}

function preTipoEstraViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preTipoEstraList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	preTipoEstraViewDetail(preTipoEstraList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function preTipoEstraViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('preTipoEstraFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PreTipoEstraLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('preTipoEstraFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
		
	
	if(validacion){
		preTipoEstraFrm.oculto='S';
		envia('preTipoEstraFrm');
		preTipoEstraFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	preTipoEstraRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('preTipoEstraFrm.accion');
	var origenTmp = get('preTipoEstraFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(preTipoEstraBuildUpdateRecordString() != preTipoEstraTmpUpdateValues){
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
	document.all.preTipoEstraListLayer.style.display='none';
	document.all.preTipoEstraListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.preTipoEstraListLayer.style.display='';
	document.all.preTipoEstraListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPreTipoEstraCodTipoEstr = get('preTipoEstraFrm.codTipoEstr').toString();
	jsPreTipoEstraDesTipoEstr = get('preTipoEstraFrm.desTipoEstr').toString();
	jsPreTipoEstraIndEstrGrup = get('preTipoEstraFrm.indEstrGrup').toString();
	jsPreTipoEstraIndEstrCond = get('preTipoEstraFrm.indEstrCond').toString();
	jsPreTipoEstraIndEstrVs = get('preTipoEstraFrm.indEstrVs').toString();
	jsPreTipoEstraIndEstrPaqu = get('preTipoEstraFrm.indEstrPaqu').toString();
	
	
	var parametros = "";
	parametros += jsPreTipoEstraCodTipoEstr + "|";
	parametros += jsPreTipoEstraDesTipoEstr + "|";
	parametros += jsPreTipoEstraIndEstrGrup + "|";
	parametros += jsPreTipoEstraIndEstrCond + "|";
	parametros += jsPreTipoEstraIndEstrVs + "|";
	parametros += jsPreTipoEstraIndEstrPaqu + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function preTipoEstraBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPreTipoEstraCodTipoEstr + "|";
	parametros += jsPreTipoEstraDesTipoEstr + "|";
	parametros += jsPreTipoEstraIndEstrGrup + "|";
	parametros += jsPreTipoEstraIndEstrCond + "|";
	parametros += jsPreTipoEstraIndEstrVs + "|";
	parametros += jsPreTipoEstraIndEstrPaqu + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preTipoEstraFrm.accion'), 
		get('preTipoEstraFrm.origen'));
	
	jsPreTipoEstraId = get('preTipoEstraFrm.id').toString();
	jsPreTipoEstraCodTipoEstr = get('preTipoEstraFrm.codTipoEstr').toString();
	jsPreTipoEstraDesTipoEstr = get('preTipoEstraFrm.desTipoEstr').toString();
	jsPreTipoEstraIndEstrGrup = get('preTipoEstraFrm.indEstrGrup').toString();
	jsPreTipoEstraIndEstrCond = get('preTipoEstraFrm.indEstrCond').toString();
	jsPreTipoEstraIndEstrVs = get('preTipoEstraFrm.indEstrVs').toString();
	jsPreTipoEstraIndEstrPaqu = get('preTipoEstraFrm.indEstrPaqu').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preTipoEstraFrm.accion'), 
		get('preTipoEstraFrm.origen'));


	set('preTipoEstraFrm.id', jsPreTipoEstraId);
	set('preTipoEstraFrm.codTipoEstr', jsPreTipoEstraCodTipoEstr);
	set('preTipoEstraFrm.desTipoEstr', jsPreTipoEstraDesTipoEstr);
	set('preTipoEstraFrm.indEstrGrup', jsPreTipoEstraIndEstrGrup);
	set('preTipoEstraFrm.indEstrCond', jsPreTipoEstraIndEstrCond);
	set('preTipoEstraFrm.indEstrVs', jsPreTipoEstraIndEstrVs);
	set('preTipoEstraFrm.indEstrPaqu', jsPreTipoEstraIndEstrPaqu);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPreTipoEstraCodTipoEstr = '';
	jsPreTipoEstraDesTipoEstr = '';
	jsPreTipoEstraIndEstrGrup = '';
	jsPreTipoEstraIndEstrCond = '';
	jsPreTipoEstraIndEstrVs = '';
	jsPreTipoEstraIndEstrPaqu = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('preTipoEstraFrm.errCodigo', errorCode);
	set('preTipoEstraFrm.errDescripcion', description);
	set('preTipoEstraFrm.errSeverity', severity);
	fMostrarMensajeError();
}
