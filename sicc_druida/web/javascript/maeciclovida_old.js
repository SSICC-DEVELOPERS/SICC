

/*
    INDRA/CAR/mmg
    $Id: maeciclovida_old.js,v 1.1 2009/12/03 19:01:36 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsMaeCicloVidaId = "";
var jsMaeCicloVidaPaisOidPais = "";
var jsMaeCicloVidaCodCiclVida = "";
var jsMaeCicloVidaDescripcion = "";

//Variables de paginacion, 
var maeCicloVidaPageCount = 1;

//Varible de columna que representa el campo de choice
var maeCicloVidaChoiceColumn = 1;

//Flag de siguiente pagina;
var maeCicloVidaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var maeCicloVidaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 220;
var sizeFormView = 150;
var sizeFormUpdate = 185;

//Ultima busqueda realizada
var maeCicloVidaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("maeCicloVida","paisOidPais", false);','','focalizaComboDependence("maeCicloVida","paisOidPais", false);','focalizaComboDependence("maeCicloVida","paisOidPais", true);','','focalizaComboDependence("maeCicloVida","paisOidPais", true);'],[3,'focaliza("maeCicloVidaFrm.codCiclVida");','focaliza("maeCicloVidaFrm.codCiclVida");','','focaliza("maeCicloVidaFrm.codCiclVida");','focaliza("maeCicloVidaFrm.codCiclVida");',''],[4,'focaliza("maeCicloVidaFrm.Descripcion");','focaliza("maeCicloVidaFrm.Descripcion");','focaliza("maeCicloVidaFrm.Descripcion");','focaliza("maeCicloVidaFrm.Descripcion");','focaliza("maeCicloVidaFrm.Descripcion");','focaliza("maeCicloVidaFrm.Descripcion");']]);

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
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
maeCicloVidaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var maeCicloVidaTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function maeCicloVidaInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('maeCicloVidaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('maeCicloVidaFrm.accion')){
		case "query": maeCicloVidaQueryInitComponents(); break;
		case "view": maeCicloVidaViewInitComponents(); break;
		case "create": maeCicloVidaCreateInitComponents(); break;
		case "update": maeCicloVidaUpdateInitComponents(); break;
		case "remove": maeCicloVidaRemoveInitComponents(); break;
		case "lov": maeCicloVidaLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('maeCicloVidaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('maeCicloVida')) maeCicloVidaCmdRequery();
}

function maeCicloVidaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
}

function maeCicloVidaViewInitComponents(){
	//En principiono se hace nada
}

function maeCicloVidaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('maeCicloVidaFrm.codCiclVida','S', GestionarMensaje('MaeCicloVida.codCiclVida.requiered.message'));
	
	setMV('maeCicloVidaFrm.Descripcion','S', GestionarMensaje('MaeCicloVida.Descripcion.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function maeCicloVidaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('maeCicloVidaFrm.origen') == "pagina"){
		loadLocalizationWidget('maeCicloVidaFrm', 'Descripcion', 1);
		

		//Registramos el valor del elemento que estamos modificando
		maeCicloVidaTmpUpdateValues = maeCicloVidaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('maeCicloVidaFrm.paisOidPais','S', GestionarMensaje('MaeCicloVida.paisOidPais.requiered.message'));
		
		setMV('maeCicloVidaFrm.Descripcion','S', GestionarMensaje('MaeCicloVida.Descripcion.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('maeCicloVidaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function maeCicloVidaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	maeCicloVidaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function maeCicloVidaLovInitComponents(){
	maeCicloVidaLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






//Función que permite cargar los datos de un elemento de lov seleccionado
function maeCicloVidaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('maeCicloVidaFrm.' + campo, id);
	set('maeCicloVidaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function maeCicloVidaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	maeCicloVidaLovReturnParameters.id = '';
	maeCicloVidaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function maeCicloVidaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCicloVidaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = maeCicloVidaList.codSeleccionados();
	var descripcion = maeCicloVidaList.extraeDato(
		maeCicloVidaList.codSeleccionados()[0], maeCicloVidaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	maeCicloVidaLovReturnParameters.id = codigo;
	maeCicloVidaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function maeCicloVidaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('maeCicloVidaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	maeCicloVidaLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('maeCicloVidaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "maeCicloVidaList", "MaeCicloVidaConectorTransactionQuery", 
		"result_ROWSET", parametros, "maeCicloVidaPostQueryActions(datos);"]], "", "");	
}

function maeCicloVidaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('maeCicloVidaFrm.lastQueryToSession'));
	var i =0;
	set('maeCicloVidaFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('maeCicloVidaFrm.codCiclVida', paramsRequery.ij(i++));
	
	set('maeCicloVidaFrm.Descripcion', paramsRequery.ij(i++));
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	maeCicloVidaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	maeCicloVidaCmdQuery(maeCicloVidaPageCount);
}

function maeCicloVidaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	maeCicloVidaPageCount = 1;
	maeCicloVidaCmdQuery(maeCicloVidaPageCount);
}

function maeCicloVidaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeCicloVidaLastQuery){
		maeCicloVidaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	maeCicloVidaPageCount--;
	maeCicloVidaCmdQuery(maeCicloVidaPageCount);
}

function maeCicloVidaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != maeCicloVidaLastQuery){
		maeCicloVidaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	maeCicloVidaPageCount++;
	maeCicloVidaCmdQuery(maeCicloVidaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function maeCicloVidaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('maeCicloVidaListLayer', 'O');
		visibilidad('maeCicloVidaListButtonsLayer', 'O');
		visibilidad('maeCicloVidaPreListLayer', 'O');
		if(get('maeCicloVidaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:maeCicloVidaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, maeCicloVidaChoiceColumn) + "</A>",
			i, maeCicloVidaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	maeCicloVidaList.setDatos(datosTmp.filtrar([0,1,2],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	maeCicloVidaTimeStamps = datosTmp.filtrar([3],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		maeCicloVidaMorePagesFlag = true;
		maeCicloVidaList.eliminar(mmgPageSize, 1);
	}else{
		maeCicloVidaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('maeCicloVidaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('maeCicloVidaListLayer', 'V');
	visibilidad('maeCicloVidaListButtonsLayer', 'V');
	visibilidad('maeCicloVidaPreListLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('maeCicloVidaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	maeCicloVidaList.display();
	
	//Actualizamos el estado de los botones 
	if(maeCicloVidaMorePagesFlag){
		set_estado_botonera('maeCicloVidaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('maeCicloVidaPaginationButtonBar',
			3,"inactivo");
	}
	if(maeCicloVidaPageCount > 1){
		set_estado_botonera('maeCicloVidaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('maeCicloVidaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('maeCicloVidaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('maeCicloVidaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function maeCicloVidaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCicloVidaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('maeCicloVidaFrm.idSelection', maeCicloVidaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('maeCicloVidaFrm', true);
	if(validacion){
		/*set('maeCicloVidaFrm.previousAction', 'update');
		set('maeCicloVidaFrm.ON', 'MaeCicloVidaLPStartUp');
		set('maeCicloVidaFrm.conectorAction', 'MaeCicloVidaLPStartUp');
		set('maeCicloVidaFrm.origen', 'pagina');
		envia('maeCicloVidaFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = maeCicloVidaList.codSeleccionados()[0];
		parametros["previousAction"] = get('maeCicloVidaFrm.accion');
		parametros["accion"] = get('maeCicloVidaFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('MaeCicloVidaLPStartUp', get('maeCicloVidaFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) maeCicloVidaCmdRequery();
	}
}

function maeCicloVidaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCicloVidaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = maeCicloVidaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('maeCicloVidaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(maeCicloVidaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += maeCicloVidaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('maeCicloVidaFrm.timestamp', timestamps);
	envia('maeCicloVidaFrm');
}

function maeCicloVidaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(maeCicloVidaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('maeCicloVidaFrm.previousAction', get('maeCicloVidaFrm.accion'));
	set('maeCicloVidaFrm.accion', 'view');
	set('maeCicloVidaFrm.origen', 'pagina');
	set('maeCicloVidaFrm.ON', 'MaeCicloVidaLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('maeCicloVidaFrm.idSelection', maeCicloVidaList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('maeCicloVidaFrm');
	maeCicloVidaViewDetail(maeCicloVidaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function maeCicloVidaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('maeCicloVidaFrm.accion');
	parametros["accion"] = get('maeCicloVidaFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('MaeCicloVidaLPStartUp', get('maeCicloVidaFrm.accion'), parametros, null, sizeFormView + 30);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar on dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	setDefaultLanguageValue('maeCicloVidaFrm', 
		'Descripcion', 1,
		get('maeCicloVidaFrm.Descripcion'));	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('maeCicloVidaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	if(!hasDefaultLanguageValue('maeCicloVidaFrm', 1)){
		cdos_mostrarAlert(GestionarMensaje('MaeCicloVida.Descripcion.requiered.message'));
		focaliza('maeCicloVidaFrm.Descripcion');
		return;
	}	
	
		
	
	if(validacion)envia('maeCicloVidaFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	maeCicloVidaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('maeCicloVidaFrm.accion');
	var origenTmp = get('maeCicloVidaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(maeCicloVidaBuildUpdateRecordString() != maeCicloVidaTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('maeCicloVidaFrm.performRequery', 'true');
		set('maeCicloVidaFrm.accion', 
			get('maeCicloVidaFrm.previousAction'));
		set('maeCicloVidaFrm.origen', 'menu');
		set('maeCicloVidaFrm.ON', 'MaeCicloVidaLPStartUp');
		set('maeCicloVidaFrm.conectorAction', 'MaeCicloVidaLPStartUp');
		maeCicloVidaFrm.oculto='N';
		envia('maeCicloVidaFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.maeCicloVidaListLayer.style.display='none';
	document.all.maeCicloVidaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.maeCicloVidaListLayer.style.display='';
	document.all.maeCicloVidaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda

	jsMaeCicloVidaPaisOidPais = get('maeCicloVidaFrm.paisOidPais')[0];




	jsMaeCicloVidaCodCiclVida = get('maeCicloVidaFrm.codCiclVida').toString();






	jsMaeCicloVidaDescripcion = get('maeCicloVidaFrm.Descripcion').toString();








	var parametros = "";
	parametros += jsMaeCicloVidaPaisOidPais + "|";



	parametros += jsMaeCicloVidaCodCiclVida + "|";



	parametros += jsMaeCicloVidaDescripcion + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function maeCicloVidaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsMaeCicloVidaPaisOidPais + "|";
	parametros += jsMaeCicloVidaDescripcion + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeCicloVidaFrm.accion'), 
		get('maeCicloVidaFrm.origen'));
	
	jsMaeCicloVidaId = get('maeCicloVidaFrm.id').toString();
	jsMaeCicloVidaPaisOidPais = get('maeCicloVidaFrm.paisOidPais')[0];
	jsMaeCicloVidaCodCiclVida = get('maeCicloVidaFrm.codCiclVida').toString();
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		jsMaeCicloVidaDescripcion = buildLocalizedString('maeCicloVidaFrm', 1);
	}else{
		jsMaeCicloVidaDescripcion = get('maeCicloVidaFrm.Descripcion');
	}

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('maeCicloVidaFrm.accion'), 
		get('maeCicloVidaFrm.origen'));


	set('maeCicloVidaFrm.id', jsMaeCicloVidaId);
	set('maeCicloVidaFrm.paisOidPais', [jsMaeCicloVidaPaisOidPais]);
	set('maeCicloVidaFrm.codCiclVida', jsMaeCicloVidaCodCiclVida);
	if(mode == MMG_MODE_CREATE || mode == MMG_MODE_UPDATE_FORM){
		unbuildLocalizedString('maeCicloVidaFrm', 1,  jsMaeCicloVidaDescripcion)
		loadLocalizationWidget('maeCicloVidaFrm', 'Descripcion', 1);
	}else{
		set('maeCicloVidaFrm.Descripcion', jsMaeCicloVidaDescripcion);		
	}

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('maeCicloVidaFrm.errCodigo', errorCode);
	set('maeCicloVidaFrm.errDescripcion', description);
	set('maeCicloVidaFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
