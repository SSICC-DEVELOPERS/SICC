

/*
    INDRA/CAR/mmg
    $Id: pretipoofert.js,v 1.1 2009/12/03 19:02:23 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPreTipoOfertId = "";
var jsPreTipoOfertCanaOidCana = "";
var jsPreTipoOfertCodTipoOfer = "";
var jsPreTipoOfertDescripcion = "";
var jsPreTipoOfertIndComi = "";
var jsPreTipoOfertIndPunt = "";
var jsPreTipoOfertIndEsta = "";
var jsPreTipoOfertIndMontMini = "";
var jsPreTipoOfertIndAporMontEsca = "";
var jsPreTipoOfertIndGrat = "";

//Variables de paginacion, 
var preTipoOfertPageCount = 1;

//Varible de columna que representa el campo de choice
var preTipoOfertChoiceColumn = 2;

//Flag de siguiente pagina;
var preTipoOfertMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var preTipoOfertTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 105;
var sizeFormView = 167;
var sizeFormUpdate = 167;

//Ultima busqueda realizada
var preTipoOfertLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("preTipoOfert","canaOidCana", false);','focalizaComboDependence("preTipoOfert","canaOidCana", false);','focalizaComboDependence("preTipoOfert","canaOidCana", false);','focalizaComboDependence("preTipoOfert","canaOidCana", true);','focalizaComboDependence("preTipoOfert","canaOidCana", true);','focalizaComboDependence("preTipoOfert","canaOidCana", true);'],[3,'focaliza("preTipoOfertFrm.codTipoOfer");','focaliza("preTipoOfertFrm.codTipoOfer");','focaliza("preTipoOfertFrm.codTipoOfer");','focaliza("preTipoOfertFrm.codTipoOfer");','focaliza("preTipoOfertFrm.codTipoOfer");','focaliza("preTipoOfertFrm.codTipoOfer");'],[4,'','focaliza("preTipoOfertFrm.Descripcion");','focaliza("preTipoOfertFrm.Descripcion");','','focaliza("preTipoOfertFrm.Descripcion");','focaliza("preTipoOfertFrm.Descripcion");'],[5,'','focaliza("preTipoOfertFrm.indComi");','focaliza("preTipoOfertFrm.indComi");','','focaliza("preTipoOfertFrm.indComi");','focaliza("preTipoOfertFrm.indComi");'],[6,'','focaliza("preTipoOfertFrm.indPunt");','focaliza("preTipoOfertFrm.indPunt");','','focaliza("preTipoOfertFrm.indPunt");','focaliza("preTipoOfertFrm.indPunt");'],[7,'','focaliza("preTipoOfertFrm.indEsta");','focaliza("preTipoOfertFrm.indEsta");','','focaliza("preTipoOfertFrm.indEsta");','focaliza("preTipoOfertFrm.indEsta");'],[8,'','focaliza("preTipoOfertFrm.indMontMini");','focaliza("preTipoOfertFrm.indMontMini");','','focaliza("preTipoOfertFrm.indMontMini");','focaliza("preTipoOfertFrm.indMontMini");'],[9,'','focaliza("preTipoOfertFrm.indAporMontEsca");','focaliza("preTipoOfertFrm.indAporMontEsca");','','focaliza("preTipoOfertFrm.indAporMontEsca");','focaliza("preTipoOfertFrm.indAporMontEsca");'],[10,'','focaliza("preTipoOfertFrm.indGrat");','focaliza("preTipoOfertFrm.indGrat");','','focaliza("preTipoOfertFrm.indGrat");','focaliza("preTipoOfertFrm.indGrat");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focalizaComboDependence("preTipoOfert","canaOidCana", false);','focalizaComboDependence("preTipoOfert","canaOidCana", false);','focalizaComboDependence("preTipoOfert","canaOidCana", false);','focalizaComboDependence("preTipoOfert","canaOidCana", true);','focalizaComboDependence("preTipoOfert","canaOidCana", true);','focalizaComboDependence("preTipoOfert","canaOidCana", true);'],[3,'focaliza("preTipoOfertFrm.codTipoOfer");','focaliza("preTipoOfertFrm.codTipoOfer");','focaliza("preTipoOfertFrm.codTipoOfer");','focaliza("preTipoOfertFrm.codTipoOfer");','focaliza("preTipoOfertFrm.codTipoOfer");','focaliza("preTipoOfertFrm.codTipoOfer");'],[4,'','focaliza("preTipoOfertFrm.Descripcion");','focaliza("preTipoOfertFrm.Descripcion");','','focaliza("preTipoOfertFrm.Descripcion");','focaliza("preTipoOfertFrm.Descripcion");'],[5,'','focaliza("preTipoOfertFrm.indComi");','focaliza("preTipoOfertFrm.indComi");','','focaliza("preTipoOfertFrm.indComi");','focaliza("preTipoOfertFrm.indComi");'],[6,'','focaliza("preTipoOfertFrm.indPunt");','focaliza("preTipoOfertFrm.indPunt");','','focaliza("preTipoOfertFrm.indPunt");','focaliza("preTipoOfertFrm.indPunt");'],[7,'','focaliza("preTipoOfertFrm.indEsta");','focaliza("preTipoOfertFrm.indEsta");','','focaliza("preTipoOfertFrm.indEsta");','focaliza("preTipoOfertFrm.indEsta");'],[8,'','focaliza("preTipoOfertFrm.indMontMini");','focaliza("preTipoOfertFrm.indMontMini");','','focaliza("preTipoOfertFrm.indMontMini");','focaliza("preTipoOfertFrm.indMontMini");'],[9,'','focaliza("preTipoOfertFrm.indAporMontEsca");','focaliza("preTipoOfertFrm.indAporMontEsca");','','focaliza("preTipoOfertFrm.indAporMontEsca");','focaliza("preTipoOfertFrm.indAporMontEsca");'],[10,'','focaliza("preTipoOfertFrm.indGrat");','focaliza("preTipoOfertFrm.indGrat");','','focaliza("preTipoOfertFrm.indGrat");','focaliza("preTipoOfertFrm.indGrat");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var canaOidCanaDependeceMap = new Vector();
canaOidCanaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
canaOidCanaDependeceMap.agregar(['canaOidCana', padresTmp, '', 'SegCanalView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
preTipoOfertLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var preTipoOfertTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function preTipoOfertInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('preTipoOfertFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('preTipoOfertFrm.accion')){
		case "query": preTipoOfertQueryInitComponents(); break;
		case "view": preTipoOfertViewInitComponents(); break;
		case "create": preTipoOfertCreateInitComponents(); break;
		case "update": preTipoOfertUpdateInitComponents(); break;
		case "remove": preTipoOfertRemoveInitComponents(); break;
		case "lov": preTipoOfertLovInitComponents(); break;
	}
	//alert('accion :' + get('preTipoOfertFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('preTipoOfertFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('preTipoOfert')) preTipoOfertCmdRequery();

	//Seteamos en el load los valores por default de combos estructurales
	var entityFormName = 'preTipoOfert';
	var comboEntityName;
	var comboRealName;
	var valorDefault; 
	
	comboEntityName = '';
	comboRealName   = '';
	valorDefault    = '';
	comboEntityName = 'SegCanal';	
	comboRealName   = 'canaOidCana';

	valorDefault    = mmgGetStructuralEntityDefaultValue(entityFormName, comboEntityName);
	if(valorDefault != null || valorDefault != '') set(entityFormName + "Frm." + comboRealName, [valorDefault]);

	
	
}

function preTipoOfertQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	focusFirstField('preTipoOfertFrm', true);	
}

function preTipoOfertViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	loadLocalizationWidget('preTipoOfertFrm', 'Descripcion', 1);
	
		
	
	focusFirstField('preTipoOfertFrm', true);
}

function preTipoOfertCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('preTipoOfertFrm.canaOidCana','S', GestionarMensaje('PreTipoOfert.canaOidCana.requiered.message'));
	
	setMV('preTipoOfertFrm.codTipoOfer','S', GestionarMensaje('PreTipoOfert.codTipoOfer.requiered.message'));
	
	setMV('preTipoOfertFrm.Descripcion','S', GestionarMensaje('PreTipoOfert.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('preTipoOfertFrm', true);
}

function preTipoOfertUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('preTipoOfertFrm.origen') == "pagina"){
		loadLocalizationWidget('preTipoOfertFrm', 'Descripcion', 1);
		

		

		//Registramos el valor del elemento que estamos modificando
		preTipoOfertTmpUpdateValues = preTipoOfertBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('preTipoOfertFrm.canaOidCana','S', GestionarMensaje('PreTipoOfert.canaOidCana.requiered.message'));
		setMV('preTipoOfertFrm.codTipoOfer','S', GestionarMensaje('PreTipoOfert.codTipoOfer.requiered.message'));
		setMV('preTipoOfertFrm.Descripcion','S', GestionarMensaje('PreTipoOfert.Descripcion.requiered.message'));
		
			focusFirstFieldModify('preTipoOfertFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		focusFirstField('preTipoOfertFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('preTipoOfertFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function preTipoOfertRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	preTipoOfertList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('preTipoOfertFrm', true);
}

function preTipoOfertLovInitComponents(){
	preTipoOfertLovReturnParameters = window.dialogArguments;
	
	focusFirstField('preTipoOfertFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad












//Función que permite cargar los datos de un elemento de lov seleccionado
function preTipoOfertSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('preTipoOfertFrm.' + campo, id);
	set('preTipoOfertFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function preTipoOfertLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	preTipoOfertLovReturnParameters.id = '';
	preTipoOfertLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function preTipoOfertLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preTipoOfertList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = preTipoOfertList.codSeleccionados();
	var descripcion = preTipoOfertList.extraeDato(
		preTipoOfertList.codSeleccionados()[0], preTipoOfertChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	preTipoOfertLovReturnParameters.id = codigo;
	preTipoOfertLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function preTipoOfertCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('preTipoOfertFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('preTipoOfertFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "preTipoOfertList", "PreTipoOfertConectorTransactionQuery", 
		"result_ROWSET", parametros, "preTipoOfertPostQueryActions(datos);"]], "", "");	
}

function preTipoOfertCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('preTipoOfertFrm.lastQueryToSession'));
	var i =0;
	set('preTipoOfertFrm.canaOidCana', [paramsRequery.ij(i++)]);
	
	set('preTipoOfertFrm.codTipoOfer', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	preTipoOfertPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	preTipoOfertCmdQuery(preTipoOfertPageCount);
}

function preTipoOfertFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	preTipoOfertPageCount = 1;
	preTipoOfertCmdQuery(preTipoOfertPageCount);
}

function preTipoOfertPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preTipoOfertLastQuery){
		preTipoOfertFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	preTipoOfertPageCount--;
	preTipoOfertCmdQuery(preTipoOfertPageCount);
}

function preTipoOfertNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != preTipoOfertLastQuery){
		preTipoOfertFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	preTipoOfertPageCount++;
	preTipoOfertCmdQuery(preTipoOfertPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function preTipoOfertPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('preTipoOfertListLayer', 'O');
		visibilidad('preTipoOfertListButtonsLayer', 'O');
		if(get('preTipoOfertFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	preTipoOfertLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 4) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 4);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 4);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 5) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 5);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 5);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 6) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 6);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 6);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 7) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 7);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 7);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 8) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 8);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 8);
		}
	}
	for(var i=0; i < datosTmp.longitud; i++){
		if(datosTmp.ij(i, 9) == "true"){
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.yes.message'), i, 9);
		}else{
			datosTmp.ij2(GestionarMensaje('MMGGlobal.checkbox.no.message'), i, 9);
		}
	}
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:preTipoOfertViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, preTipoOfertChoiceColumn) + "</A>",
			i, preTipoOfertChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	preTipoOfertList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	preTipoOfertTimeStamps = datosTmp.filtrar([10],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		preTipoOfertMorePagesFlag = true;
		preTipoOfertList.eliminar(mmgPageSize, 1);
	}else{
		preTipoOfertMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('preTipoOfertFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('preTipoOfertListLayer', 'V');
	visibilidad('preTipoOfertListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('preTipoOfertList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	preTipoOfertList.display();
	
	//Actualizamos el estado de los botones 
	if(preTipoOfertMorePagesFlag){
		set_estado_botonera('preTipoOfertPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('preTipoOfertPaginationButtonBar',
			3,"inactivo");
	}
	if(preTipoOfertPageCount > 1){
		set_estado_botonera('preTipoOfertPaginationButtonBar',
			2,"activo");
		set_estado_botonera('preTipoOfertPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('preTipoOfertPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('preTipoOfertPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function preTipoOfertUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preTipoOfertList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('preTipoOfertFrm.idSelection', preTipoOfertList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('preTipoOfertFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = preTipoOfertList.codSeleccionados()[0];
		parametros["previousAction"] = get('preTipoOfertFrm.accion');
		parametros["accion"] = get('preTipoOfertFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PreTipoOfertLPStartUp', get('preTipoOfertFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) preTipoOfertCmdRequery();
	}
}

function preTipoOfertRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preTipoOfertList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = preTipoOfertList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('preTipoOfertFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(preTipoOfertList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += preTipoOfertTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('preTipoOfertFrm.timestamp', timestamps);


	preTipoOfertFrm.oculto='S';
	envia('preTipoOfertFrm');
	preTipoOfertFrm.oculto='N';
}

function preTipoOfertViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(preTipoOfertList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	preTipoOfertViewDetail(preTipoOfertList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function preTipoOfertViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('preTipoOfertFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PreTipoOfertLPStartUp', 'view', parametros, null, null);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar no dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('preTipoOfertFrm', 
		'Descripcion', 1,
		get('preTipoOfertFrm.Descripcion'));	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('preTipoOfertFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('preTipoOfertFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('PreTipoOfert.Descripcion.requiered.message'));
		focaliza('preTipoOfertFrm.Descripcion');
		return;
	}	
	
	
	
	
	
	
	
		
	
	if(validacion){
		preTipoOfertFrm.oculto='S';
		envia('preTipoOfertFrm');
		preTipoOfertFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('preTipoOfertFrm.canaOidCana').toString() == ''){
		set('preTipoOfertFrm.canaOidCana', []);
		mmgResetCombosOnCascade('canaOidCana', 'canaOidCana', 'preTipoOfert');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	preTipoOfertRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('preTipoOfertFrm.accion');
	var origenTmp = get('preTipoOfertFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(preTipoOfertBuildUpdateRecordString() != preTipoOfertTmpUpdateValues){
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
	document.all.preTipoOfertListLayer.style.display='none';
	document.all.preTipoOfertListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.preTipoOfertListLayer.style.display='';
	document.all.preTipoOfertListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPreTipoOfertCanaOidCana = get('preTipoOfertFrm.canaOidCana')[0];
	jsPreTipoOfertCodTipoOfer = get('preTipoOfertFrm.codTipoOfer').toString();
	
	
	var parametros = "";
	parametros += jsPreTipoOfertCanaOidCana + "|";
	parametros += jsPreTipoOfertCodTipoOfer + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function preTipoOfertBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPreTipoOfertCanaOidCana + "|";
	parametros += jsPreTipoOfertCodTipoOfer + "|";
	parametros += jsPreTipoOfertDescripcion + "|";
	parametros += jsPreTipoOfertIndComi + "|";
	parametros += jsPreTipoOfertIndPunt + "|";
	parametros += jsPreTipoOfertIndEsta + "|";
	parametros += jsPreTipoOfertIndMontMini + "|";
	parametros += jsPreTipoOfertIndAporMontEsca + "|";
	parametros += jsPreTipoOfertIndGrat + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preTipoOfertFrm.accion'), 
		get('preTipoOfertFrm.origen'));
	
	jsPreTipoOfertId = get('preTipoOfertFrm.id').toString();
	jsPreTipoOfertCanaOidCana = get('preTipoOfertFrm.canaOidCana')[0];
	jsPreTipoOfertCodTipoOfer = get('preTipoOfertFrm.codTipoOfer').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsPreTipoOfertDescripcion = buildLocalizedString('preTipoOfertFrm', 1);
	}else{
		jsPreTipoOfertDescripcion = get('preTipoOfertFrm.Descripcion');
	}
	if(get('preTipoOfertFrm.indComi').toString() == 'S') jsPreTipoOfertIndComi = "true";
		else jsPreTipoOfertIndComi = "false";
	if(get('preTipoOfertFrm.indPunt').toString() == 'S') jsPreTipoOfertIndPunt = "true";
		else jsPreTipoOfertIndPunt = "false";
	if(get('preTipoOfertFrm.indEsta').toString() == 'S') jsPreTipoOfertIndEsta = "true";
		else jsPreTipoOfertIndEsta = "false";
	if(get('preTipoOfertFrm.indMontMini').toString() == 'S') jsPreTipoOfertIndMontMini = "true";
		else jsPreTipoOfertIndMontMini = "false";
	if(get('preTipoOfertFrm.indAporMontEsca').toString() == 'S') jsPreTipoOfertIndAporMontEsca = "true";
		else jsPreTipoOfertIndAporMontEsca = "false";
	if(get('preTipoOfertFrm.indGrat').toString() == 'S') jsPreTipoOfertIndGrat = "true";
		else jsPreTipoOfertIndGrat = "false";
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('preTipoOfertFrm.accion'), 
		get('preTipoOfertFrm.origen'));


	set('preTipoOfertFrm.id', jsPreTipoOfertId);
	set('preTipoOfertFrm.canaOidCana', [jsPreTipoOfertCanaOidCana]);
	set('preTipoOfertFrm.codTipoOfer', jsPreTipoOfertCodTipoOfer);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('preTipoOfertFrm', 1,  jsPreTipoOfertDescripcion)
		loadLocalizationWidget('preTipoOfertFrm', 'Descripcion', 1);
	}else{
		set('preTipoOfertFrm.Descripcion', jsPreTipoOfertDescripcion);		
	}
	
			
			if(jsPreTipoOfertIndComi == "true") set('preTipoOfertFrm.indComi', 'S');
			else set('preTipoOfertFrm.indComi', 'N');
	
			
			if(jsPreTipoOfertIndPunt == "true") set('preTipoOfertFrm.indPunt', 'S');
			else set('preTipoOfertFrm.indPunt', 'N');
	
			
			if(jsPreTipoOfertIndEsta == "true") set('preTipoOfertFrm.indEsta', 'S');
			else set('preTipoOfertFrm.indEsta', 'N');
	
			
			if(jsPreTipoOfertIndMontMini == "true") set('preTipoOfertFrm.indMontMini', 'S');
			else set('preTipoOfertFrm.indMontMini', 'N');
	
			
			if(jsPreTipoOfertIndAporMontEsca == "true") set('preTipoOfertFrm.indAporMontEsca', 'S');
			else set('preTipoOfertFrm.indAporMontEsca', 'N');
	
			
			if(jsPreTipoOfertIndGrat == "true") set('preTipoOfertFrm.indGrat', 'S');
			else set('preTipoOfertFrm.indGrat', 'N');
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPreTipoOfertCanaOidCana = '';
	jsPreTipoOfertCodTipoOfer = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('preTipoOfertFrm.errCodigo', errorCode);
	set('preTipoOfertFrm.errDescripcion', description);
	set('preTipoOfertFrm.errSeverity', severity);
	fMostrarMensajeError();
}
