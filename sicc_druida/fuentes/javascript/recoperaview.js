

/*
    INDRA/CAR/mmg
    $Id: recoperaview.js,v 1.1 2009/12/03 19:01:49 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsRecOperaViewId = "";
var jsRecOperaViewCodOper = "";
var jsRecOperaViewValDescLarg = "";
var jsRecOperaViewIndAnul = "";
var jsRecOperaViewIndIngrEnvi = "";
var jsRecOperaViewValIngrDevu = "";
var jsRecOperaViewValPerd = "";
var jsRecOperaViewIndEspeMercFisi = "";
var jsRecOperaViewIndDevuFisiFact = "";
var jsRecOperaViewNumCampHist = "";
var jsRecOperaViewIndEnviGeneDevu = "";
var jsRecOperaViewIndDevuGeneEnvi = "";
var jsRecOperaViewPaisOidPais = "";
var jsRecOperaViewIndFaltMerc = "";

//Variables de paginacion, 
var recOperaViewPageCount = 1;

//Varible de columna que representa el campo de choice
var recOperaViewChoiceColumn = 1;

//Flag de siguiente pagina;
var recOperaViewMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var recOperaViewTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 567;
var sizeFormView = 553;
var sizeFormUpdate = 553;

//Ultima busqueda realizada
var recOperaViewLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("recOperaViewFrm.codOper");','focaliza("recOperaViewFrm.codOper");','focaliza("recOperaViewFrm.codOper");','focaliza("recOperaViewFrm.codOper");','focaliza("recOperaViewFrm.codOper");','focaliza("recOperaViewFrm.codOper");'],[3,'focaliza("recOperaViewFrm.valDescLarg");','focaliza("recOperaViewFrm.valDescLarg");','focaliza("recOperaViewFrm.valDescLarg");','focaliza("recOperaViewFrm.valDescLarg");','focaliza("recOperaViewFrm.valDescLarg");','focaliza("recOperaViewFrm.valDescLarg");'],[4,'focaliza("recOperaViewFrm.indAnul");','focaliza("recOperaViewFrm.indAnul");','focaliza("recOperaViewFrm.indAnul");','focaliza("recOperaViewFrm.indAnul");','focaliza("recOperaViewFrm.indAnul");','focaliza("recOperaViewFrm.indAnul");'],[5,'focaliza("recOperaViewFrm.indIngrEnvi");','focaliza("recOperaViewFrm.indIngrEnvi");','focaliza("recOperaViewFrm.indIngrEnvi");','focaliza("recOperaViewFrm.indIngrEnvi");','focaliza("recOperaViewFrm.indIngrEnvi");','focaliza("recOperaViewFrm.indIngrEnvi");'],[6,'focaliza("recOperaViewFrm.valIngrDevu");','focaliza("recOperaViewFrm.valIngrDevu");','focaliza("recOperaViewFrm.valIngrDevu");','focaliza("recOperaViewFrm.valIngrDevu");','focaliza("recOperaViewFrm.valIngrDevu");','focaliza("recOperaViewFrm.valIngrDevu");'],[7,'focaliza("recOperaViewFrm.valPerd");','focaliza("recOperaViewFrm.valPerd");','focaliza("recOperaViewFrm.valPerd");','focaliza("recOperaViewFrm.valPerd");','focaliza("recOperaViewFrm.valPerd");','focaliza("recOperaViewFrm.valPerd");'],[8,'focaliza("recOperaViewFrm.indEspeMercFisi");','focaliza("recOperaViewFrm.indEspeMercFisi");','focaliza("recOperaViewFrm.indEspeMercFisi");','focaliza("recOperaViewFrm.indEspeMercFisi");','focaliza("recOperaViewFrm.indEspeMercFisi");','focaliza("recOperaViewFrm.indEspeMercFisi");'],[9,'focaliza("recOperaViewFrm.indDevuFisiFact");','focaliza("recOperaViewFrm.indDevuFisiFact");','focaliza("recOperaViewFrm.indDevuFisiFact");','focaliza("recOperaViewFrm.indDevuFisiFact");','focaliza("recOperaViewFrm.indDevuFisiFact");','focaliza("recOperaViewFrm.indDevuFisiFact");'],[10,'focaliza("recOperaViewFrm.numCampHist");','focaliza("recOperaViewFrm.numCampHist");','focaliza("recOperaViewFrm.numCampHist");','focaliza("recOperaViewFrm.numCampHist");','focaliza("recOperaViewFrm.numCampHist");','focaliza("recOperaViewFrm.numCampHist");'],[11,'focaliza("recOperaViewFrm.indEnviGeneDevu");','focaliza("recOperaViewFrm.indEnviGeneDevu");','focaliza("recOperaViewFrm.indEnviGeneDevu");','focaliza("recOperaViewFrm.indEnviGeneDevu");','focaliza("recOperaViewFrm.indEnviGeneDevu");','focaliza("recOperaViewFrm.indEnviGeneDevu");'],[12,'focaliza("recOperaViewFrm.indDevuGeneEnvi");','focaliza("recOperaViewFrm.indDevuGeneEnvi");','focaliza("recOperaViewFrm.indDevuGeneEnvi");','focaliza("recOperaViewFrm.indDevuGeneEnvi");','focaliza("recOperaViewFrm.indDevuGeneEnvi");','focaliza("recOperaViewFrm.indDevuGeneEnvi");'],[16,'','','','','',''],[23,'focaliza("recOperaViewFrm.indFaltMerc");','focaliza("recOperaViewFrm.indFaltMerc");','focaliza("recOperaViewFrm.indFaltMerc");','focaliza("recOperaViewFrm.indFaltMerc");','focaliza("recOperaViewFrm.indFaltMerc");','focaliza("recOperaViewFrm.indFaltMerc");']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("recOperaViewFrm.codOper");','focaliza("recOperaViewFrm.codOper");','focaliza("recOperaViewFrm.codOper");','focaliza("recOperaViewFrm.codOper");','focaliza("recOperaViewFrm.codOper");','focaliza("recOperaViewFrm.codOper");'],[3,'focaliza("recOperaViewFrm.valDescLarg");','focaliza("recOperaViewFrm.valDescLarg");','focaliza("recOperaViewFrm.valDescLarg");','focaliza("recOperaViewFrm.valDescLarg");','focaliza("recOperaViewFrm.valDescLarg");','focaliza("recOperaViewFrm.valDescLarg");'],[4,'focaliza("recOperaViewFrm.indAnul");','focaliza("recOperaViewFrm.indAnul");','focaliza("recOperaViewFrm.indAnul");','focaliza("recOperaViewFrm.indAnul");','focaliza("recOperaViewFrm.indAnul");','focaliza("recOperaViewFrm.indAnul");'],[5,'focaliza("recOperaViewFrm.indIngrEnvi");','focaliza("recOperaViewFrm.indIngrEnvi");','focaliza("recOperaViewFrm.indIngrEnvi");','focaliza("recOperaViewFrm.indIngrEnvi");','focaliza("recOperaViewFrm.indIngrEnvi");','focaliza("recOperaViewFrm.indIngrEnvi");'],[6,'focaliza("recOperaViewFrm.valIngrDevu");','focaliza("recOperaViewFrm.valIngrDevu");','focaliza("recOperaViewFrm.valIngrDevu");','focaliza("recOperaViewFrm.valIngrDevu");','focaliza("recOperaViewFrm.valIngrDevu");','focaliza("recOperaViewFrm.valIngrDevu");'],[7,'focaliza("recOperaViewFrm.valPerd");','focaliza("recOperaViewFrm.valPerd");','focaliza("recOperaViewFrm.valPerd");','focaliza("recOperaViewFrm.valPerd");','focaliza("recOperaViewFrm.valPerd");','focaliza("recOperaViewFrm.valPerd");'],[8,'focaliza("recOperaViewFrm.indEspeMercFisi");','focaliza("recOperaViewFrm.indEspeMercFisi");','focaliza("recOperaViewFrm.indEspeMercFisi");','focaliza("recOperaViewFrm.indEspeMercFisi");','focaliza("recOperaViewFrm.indEspeMercFisi");','focaliza("recOperaViewFrm.indEspeMercFisi");'],[9,'focaliza("recOperaViewFrm.indDevuFisiFact");','focaliza("recOperaViewFrm.indDevuFisiFact");','focaliza("recOperaViewFrm.indDevuFisiFact");','focaliza("recOperaViewFrm.indDevuFisiFact");','focaliza("recOperaViewFrm.indDevuFisiFact");','focaliza("recOperaViewFrm.indDevuFisiFact");'],[10,'focaliza("recOperaViewFrm.numCampHist");','focaliza("recOperaViewFrm.numCampHist");','focaliza("recOperaViewFrm.numCampHist");','focaliza("recOperaViewFrm.numCampHist");','focaliza("recOperaViewFrm.numCampHist");','focaliza("recOperaViewFrm.numCampHist");'],[11,'focaliza("recOperaViewFrm.indEnviGeneDevu");','focaliza("recOperaViewFrm.indEnviGeneDevu");','focaliza("recOperaViewFrm.indEnviGeneDevu");','focaliza("recOperaViewFrm.indEnviGeneDevu");','focaliza("recOperaViewFrm.indEnviGeneDevu");','focaliza("recOperaViewFrm.indEnviGeneDevu");'],[12,'focaliza("recOperaViewFrm.indDevuGeneEnvi");','focaliza("recOperaViewFrm.indDevuGeneEnvi");','focaliza("recOperaViewFrm.indDevuGeneEnvi");','focaliza("recOperaViewFrm.indDevuGeneEnvi");','focaliza("recOperaViewFrm.indDevuGeneEnvi");','focaliza("recOperaViewFrm.indDevuGeneEnvi");'],[16,'','','','','',''],[23,'focaliza("recOperaViewFrm.indFaltMerc");','focaliza("recOperaViewFrm.indFaltMerc");','focaliza("recOperaViewFrm.indFaltMerc");','focaliza("recOperaViewFrm.indFaltMerc");','focaliza("recOperaViewFrm.indFaltMerc");','focaliza("recOperaViewFrm.indFaltMerc");']]);

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
recOperaViewLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var recOperaViewTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function recOperaViewInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('recOperaViewFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('recOperaViewFrm.accion')){
		case "query": recOperaViewQueryInitComponents(); break;
		case "view": recOperaViewViewInitComponents(); break;
		case "create": recOperaViewCreateInitComponents(); break;
		case "update": recOperaViewUpdateInitComponents(); break;
		case "remove": recOperaViewRemoveInitComponents(); break;
		case "lov": recOperaViewLovInitComponents(); break;
	}
	//alert('accion :' + get('recOperaViewFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('recOperaViewFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('recOperaView')) recOperaViewCmdRequery();
}

function recOperaViewQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('recOperaViewFrm', true);	
}

function recOperaViewViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('recOperaViewFrm', true);
}

function recOperaViewCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('recOperaViewFrm.codOper','S', GestionarMensaje('RecOperaView.codOper.requiered.message'));
	
	setMV('recOperaViewFrm.valDescLarg','S', GestionarMensaje('RecOperaView.valDescLarg.requiered.message'));
	
	setMV('recOperaViewFrm.indAnul','S', GestionarMensaje('RecOperaView.indAnul.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('recOperaViewFrm', true);
}

function recOperaViewUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('recOperaViewFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		recOperaViewTmpUpdateValues = recOperaViewBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('recOperaViewFrm.codOper','S', GestionarMensaje('RecOperaView.codOper.requiered.message'));
		setMV('recOperaViewFrm.valDescLarg','S', GestionarMensaje('RecOperaView.valDescLarg.requiered.message'));
		setMV('recOperaViewFrm.indAnul','S', GestionarMensaje('RecOperaView.indAnul.requiered.message'));
		
			focusFirstFieldModify('recOperaViewFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('recOperaViewFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('recOperaViewFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function recOperaViewRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	recOperaViewList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('recOperaViewFrm', true);
}

function recOperaViewLovInitComponents(){
	recOperaViewLovReturnParameters = window.dialogArguments;
	
	focusFirstField('recOperaViewFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad
















//Función que permite cargar los datos de un elemento de lov seleccionado
function recOperaViewSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('recOperaViewFrm.' + campo, id);
	set('recOperaViewFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function recOperaViewLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	recOperaViewLovReturnParameters.id = '';
	recOperaViewLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function recOperaViewLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recOperaViewList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = recOperaViewList.codSeleccionados();
	var descripcion = recOperaViewList.extraeDato(
		recOperaViewList.codSeleccionados()[0], recOperaViewChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	recOperaViewLovReturnParameters.id = codigo;
	recOperaViewLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function recOperaViewCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('recOperaViewFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('recOperaViewFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "recOperaViewList", "RecOperaViewConectorTransactionQuery", 
		"result_ROWSET", parametros, "recOperaViewPostQueryActions(datos);"]], "", "");	
}

function recOperaViewCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('recOperaViewFrm.lastQueryToSession'));
	var i =0;
	set('recOperaViewFrm.codOper', paramsRequery.ij(i++));
	
	set('recOperaViewFrm.valDescLarg', paramsRequery.ij(i++));
	
	set('recOperaViewFrm.indAnul', paramsRequery.ij(i++));
	
	set('recOperaViewFrm.indIngrEnvi', paramsRequery.ij(i++));
	
	set('recOperaViewFrm.valIngrDevu', paramsRequery.ij(i++));
	
	set('recOperaViewFrm.valPerd', paramsRequery.ij(i++));
	
	set('recOperaViewFrm.indEspeMercFisi', paramsRequery.ij(i++));
	
	set('recOperaViewFrm.indDevuFisiFact', paramsRequery.ij(i++));
	
	set('recOperaViewFrm.numCampHist', paramsRequery.ij(i++));
	
	set('recOperaViewFrm.indEnviGeneDevu', paramsRequery.ij(i++));
	
	set('recOperaViewFrm.indDevuGeneEnvi', paramsRequery.ij(i++));
	
	set('recOperaViewFrm.indFaltMerc', paramsRequery.ij(i++));
	
	
	
	//Establecemos la página de busqueda como la actual
	recOperaViewPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	recOperaViewCmdQuery(recOperaViewPageCount);
}

function recOperaViewFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	recOperaViewPageCount = 1;
	recOperaViewCmdQuery(recOperaViewPageCount);
}

function recOperaViewPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != recOperaViewLastQuery){
		recOperaViewFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	recOperaViewPageCount--;
	recOperaViewCmdQuery(recOperaViewPageCount);
}

function recOperaViewNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != recOperaViewLastQuery){
		recOperaViewFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	recOperaViewPageCount++;
	recOperaViewCmdQuery(recOperaViewPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function recOperaViewPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('recOperaViewListLayer', 'O');
		visibilidad('recOperaViewListButtonsLayer', 'O');
		if(get('recOperaViewFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	recOperaViewLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:recOperaViewViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, recOperaViewChoiceColumn) + "</A>",
			i, recOperaViewChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	recOperaViewList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	recOperaViewTimeStamps = datosTmp.filtrar([13],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		recOperaViewMorePagesFlag = true;
		recOperaViewList.eliminar(mmgPageSize, 1);
	}else{
		recOperaViewMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('recOperaViewFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('recOperaViewListLayer', 'V');
	visibilidad('recOperaViewListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('recOperaViewList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	recOperaViewList.display();
	
	//Actualizamos el estado de los botones 
	if(recOperaViewMorePagesFlag){
		set_estado_botonera('recOperaViewPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('recOperaViewPaginationButtonBar',
			3,"inactivo");
	}
	if(recOperaViewPageCount > 1){
		set_estado_botonera('recOperaViewPaginationButtonBar',
			2,"activo");
		set_estado_botonera('recOperaViewPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('recOperaViewPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('recOperaViewPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function recOperaViewUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recOperaViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('recOperaViewFrm.idSelection', recOperaViewList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('recOperaViewFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = recOperaViewList.codSeleccionados()[0];
		parametros["previousAction"] = get('recOperaViewFrm.accion');
		parametros["accion"] = get('recOperaViewFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('RecOperaViewLPStartUp', get('recOperaViewFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) recOperaViewCmdRequery();
	}
}

function recOperaViewRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recOperaViewList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = recOperaViewList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('recOperaViewFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(recOperaViewList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += recOperaViewTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('recOperaViewFrm.timestamp', timestamps);


	recOperaViewFrm.oculto='S';
	envia('recOperaViewFrm');
	recOperaViewFrm.oculto='N';
}

function recOperaViewViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recOperaViewList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	recOperaViewViewDetail(recOperaViewList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function recOperaViewViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('recOperaViewFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('RecOperaViewLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('recOperaViewFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		recOperaViewFrm.oculto='S';
		envia('recOperaViewFrm');
		recOperaViewFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('recOperaViewFrm.paisOidPais').toString() == ''){
		set('recOperaViewFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'recOperaView');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	recOperaViewRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('recOperaViewFrm.accion');
	var origenTmp = get('recOperaViewFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(recOperaViewBuildUpdateRecordString() != recOperaViewTmpUpdateValues){
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
	document.all.recOperaViewListLayer.style.display='none';
	document.all.recOperaViewListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.recOperaViewListLayer.style.display='';
	document.all.recOperaViewListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsRecOperaViewCodOper = get('recOperaViewFrm.codOper').toString();
	jsRecOperaViewValDescLarg = get('recOperaViewFrm.valDescLarg').toString();
	jsRecOperaViewIndAnul = get('recOperaViewFrm.indAnul').toString();
	jsRecOperaViewIndIngrEnvi = get('recOperaViewFrm.indIngrEnvi').toString();
	jsRecOperaViewValIngrDevu = get('recOperaViewFrm.valIngrDevu').toString();
	jsRecOperaViewValPerd = get('recOperaViewFrm.valPerd').toString();
	jsRecOperaViewIndEspeMercFisi = get('recOperaViewFrm.indEspeMercFisi').toString();
	jsRecOperaViewIndDevuFisiFact = get('recOperaViewFrm.indDevuFisiFact').toString();
	jsRecOperaViewNumCampHist = get('recOperaViewFrm.numCampHist').toString();
	jsRecOperaViewIndEnviGeneDevu = get('recOperaViewFrm.indEnviGeneDevu').toString();
	jsRecOperaViewIndDevuGeneEnvi = get('recOperaViewFrm.indDevuGeneEnvi').toString();
	jsRecOperaViewIndFaltMerc = get('recOperaViewFrm.indFaltMerc').toString();
	
	
	var parametros = "";
	parametros += jsRecOperaViewCodOper + "|";
	parametros += jsRecOperaViewValDescLarg + "|";
	parametros += jsRecOperaViewIndAnul + "|";
	parametros += jsRecOperaViewIndIngrEnvi + "|";
	parametros += jsRecOperaViewValIngrDevu + "|";
	parametros += jsRecOperaViewValPerd + "|";
	parametros += jsRecOperaViewIndEspeMercFisi + "|";
	parametros += jsRecOperaViewIndDevuFisiFact + "|";
	parametros += jsRecOperaViewNumCampHist + "|";
	parametros += jsRecOperaViewIndEnviGeneDevu + "|";
	parametros += jsRecOperaViewIndDevuGeneEnvi + "|";
	parametros += jsRecOperaViewIndFaltMerc + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function recOperaViewBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsRecOperaViewCodOper + "|";
	parametros += jsRecOperaViewValDescLarg + "|";
	parametros += jsRecOperaViewIndAnul + "|";
	parametros += jsRecOperaViewIndIngrEnvi + "|";
	parametros += jsRecOperaViewValIngrDevu + "|";
	parametros += jsRecOperaViewValPerd + "|";
	parametros += jsRecOperaViewIndEspeMercFisi + "|";
	parametros += jsRecOperaViewIndDevuFisiFact + "|";
	parametros += jsRecOperaViewNumCampHist + "|";
	parametros += jsRecOperaViewIndEnviGeneDevu + "|";
	parametros += jsRecOperaViewIndDevuGeneEnvi + "|";
	parametros += jsRecOperaViewIndFaltMerc + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('recOperaViewFrm.accion'), 
		get('recOperaViewFrm.origen'));
	
	jsRecOperaViewId = get('recOperaViewFrm.id').toString();
	jsRecOperaViewCodOper = get('recOperaViewFrm.codOper').toString();
	jsRecOperaViewValDescLarg = get('recOperaViewFrm.valDescLarg').toString();
	jsRecOperaViewIndAnul = get('recOperaViewFrm.indAnul').toString();
	jsRecOperaViewIndIngrEnvi = get('recOperaViewFrm.indIngrEnvi').toString();
	jsRecOperaViewValIngrDevu = get('recOperaViewFrm.valIngrDevu').toString();
	jsRecOperaViewValPerd = get('recOperaViewFrm.valPerd').toString();
	jsRecOperaViewIndEspeMercFisi = get('recOperaViewFrm.indEspeMercFisi').toString();
	jsRecOperaViewIndDevuFisiFact = get('recOperaViewFrm.indDevuFisiFact').toString();
	jsRecOperaViewNumCampHist = get('recOperaViewFrm.numCampHist').toString();
	jsRecOperaViewIndEnviGeneDevu = get('recOperaViewFrm.indEnviGeneDevu').toString();
	jsRecOperaViewIndDevuGeneEnvi = get('recOperaViewFrm.indDevuGeneEnvi').toString();
	jsRecOperaViewPaisOidPais = get('recOperaViewFrm.paisOidPais')[0];
	jsRecOperaViewIndFaltMerc = get('recOperaViewFrm.indFaltMerc').toString();
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('recOperaViewFrm.accion'), 
		get('recOperaViewFrm.origen'));


	set('recOperaViewFrm.id', jsRecOperaViewId);
	set('recOperaViewFrm.codOper', jsRecOperaViewCodOper);
	set('recOperaViewFrm.valDescLarg', jsRecOperaViewValDescLarg);
	set('recOperaViewFrm.indAnul', jsRecOperaViewIndAnul);
	set('recOperaViewFrm.indIngrEnvi', jsRecOperaViewIndIngrEnvi);
	set('recOperaViewFrm.valIngrDevu', jsRecOperaViewValIngrDevu);
	set('recOperaViewFrm.valPerd', jsRecOperaViewValPerd);
	set('recOperaViewFrm.indEspeMercFisi', jsRecOperaViewIndEspeMercFisi);
	set('recOperaViewFrm.indDevuFisiFact', jsRecOperaViewIndDevuFisiFact);
	set('recOperaViewFrm.numCampHist', jsRecOperaViewNumCampHist);
	set('recOperaViewFrm.indEnviGeneDevu', jsRecOperaViewIndEnviGeneDevu);
	set('recOperaViewFrm.indDevuGeneEnvi', jsRecOperaViewIndDevuGeneEnvi);
	set('recOperaViewFrm.paisOidPais', [jsRecOperaViewPaisOidPais]);
	set('recOperaViewFrm.indFaltMerc', jsRecOperaViewIndFaltMerc);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsRecOperaViewCodOper = '';
	jsRecOperaViewValDescLarg = '';
	jsRecOperaViewIndAnul = '';
	jsRecOperaViewIndIngrEnvi = '';
	jsRecOperaViewValIngrDevu = '';
	jsRecOperaViewValPerd = '';
	jsRecOperaViewIndEspeMercFisi = '';
	jsRecOperaViewIndDevuFisiFact = '';
	jsRecOperaViewNumCampHist = '';
	jsRecOperaViewIndEnviGeneDevu = '';
	jsRecOperaViewIndDevuGeneEnvi = '';
	jsRecOperaViewIndFaltMerc = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('recOperaViewFrm.errCodigo', errorCode);
	set('recOperaViewFrm.errDescripcion', description);
	set('recOperaViewFrm.errSeverity', severity);
	fMostrarMensajeError();
}
