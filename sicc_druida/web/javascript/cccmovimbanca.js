

/*
    INDRA/CAR/mmg
    $Id: cccmovimbanca.js,v 1.1 2009/12/03 19:01:45 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCccMovimBancaId = "";
var jsCccMovimBancaSociOidSoci = "";
var jsCccMovimBancaSubpOidMarcUlti = "";
var jsCccMovimBancaSubpOidMarcCrea = "";
var jsCccMovimBancaTcabOidAbonUlti = "";
var jsCccMovimBancaTcabOidAbonCrea = "";
var jsCccMovimBancaTtraOidTipoTrans = "";
var jsCccMovimBancaCcbaOidCcBanc = "";
var jsCccMovimBancaNumConsTran = "";
var jsCccMovimBancaNumLote = "";
var jsCccMovimBancaCodCons = "";
var jsCccMovimBancaCodConsReal = "";
var jsCccMovimBancaCodErro = "";
var jsCccMovimBancaValDigiCheqFact = "";
var jsCccMovimBancaValDocuApliAnio = "";
var jsCccMovimBancaValDocuApliMesSeri = "";
var jsCccMovimBancaValDocuApliNume = "";
var jsCccMovimBancaValDocuCreaAnio = "";
var jsCccMovimBancaValDocuCreaMesSeri = "";
var jsCccMovimBancaValDocuCreaNume = "";
var jsCccMovimBancaValEstaMoviPend = "";
var jsCccMovimBancaFecCont = "";
var jsCccMovimBancaFecPago = "";
var jsCccMovimBancaFecProc = "";
var jsCccMovimBancaValHoraProc = "";
var jsCccMovimBancaValHoraNormAdic = "";
var jsCccMovimBancaCodIdenProc = "";
var jsCccMovimBancaImpPago = "";
var jsCccMovimBancaValNombOfic = "";
var jsCccMovimBancaNumCupo = "";
var jsCccMovimBancaValNumeDocu = "";
var jsCccMovimBancaNumFactBole = "";
var jsCccMovimBancaValNumeLoteCont = "";
var jsCccMovimBancaValObse = "";
var jsCccMovimBancaCodOficReca = "";
var jsCccMovimBancaValUsuaProc = "";
var jsCccMovimBancaFecMoviApli = "";

//Variables de paginacion, 
var cccMovimBancaPageCount = 1;

//Varible de columna que representa el campo de choice
var cccMovimBancaChoiceColumn = 36;

//Flag de siguiente pagina;
var cccMovimBancaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var cccMovimBancaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 1830;
var sizeFormView = 1830;
var sizeFormUpdate = 1830;

//Ultima busqueda realizada
var cccMovimBancaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focaliza("cccMovimBancaFrm.fecMoviApli");','focaliza("cccMovimBancaFrm.fecMoviApli");','focaliza("cccMovimBancaFrm.fecMoviApli");','focaliza("cccMovimBancaFrm.fecMoviApli");','focaliza("cccMovimBancaFrm.fecMoviApli");','focaliza("cccMovimBancaFrm.fecMoviApli");']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquí consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nomrbe de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var sociOidSociDependeceMap = new Vector();
sociOidSociDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sociOidSociDependeceMap.agregar(['sociOidSoci', padresTmp, '', 'SegSocie']);
var subpOidMarcUltiDependeceMap = new Vector();
subpOidMarcUltiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
subpOidMarcUltiDependeceMap.agregar(['subpOidMarcUlti_ccprOidProc', padresTmp, 'subpOidMarcUlti', 'CccProce']);
padresTmp =  new Vector();
padresTmp.cargar(['subpOidMarcUlti_ccprOidProc'])
subpOidMarcUltiDependeceMap.agregar(['subpOidMarcUlti', padresTmp, '', 'CccSubpr']);
var subpOidMarcCreaDependeceMap = new Vector();
subpOidMarcCreaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
subpOidMarcCreaDependeceMap.agregar(['subpOidMarcCrea_ccprOidProc', padresTmp, 'subpOidMarcCrea', 'CccProce']);
padresTmp =  new Vector();
padresTmp.cargar(['subpOidMarcCrea_ccprOidProc'])
subpOidMarcCreaDependeceMap.agregar(['subpOidMarcCrea', padresTmp, '', 'CccSubpr']);
var tcabOidAbonUltiDependeceMap = new Vector();
tcabOidAbonUltiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tcabOidAbonUltiDependeceMap.agregar(['tcabOidAbonUlti', padresTmp, '', 'CccTipoCargoAbono']);
var tcabOidAbonCreaDependeceMap = new Vector();
tcabOidAbonCreaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tcabOidAbonCreaDependeceMap.agregar(['tcabOidAbonCrea', padresTmp, '', 'CccTipoCargoAbono']);
var ttraOidTipoTransDependeceMap = new Vector();
ttraOidTipoTransDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ttraOidTipoTransDependeceMap.agregar(['ttraOidTipoTrans', padresTmp, '', 'CccTipoTrans']);
var ccbaOidCcBancDependeceMap = new Vector();
ccbaOidCcBancDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ccbaOidCcBancDependeceMap.agregar(['ccbaOidCcBanc_cucoOidCcTeso', padresTmp, 'ccbaOidCcBanc', 'CccCuentConta']);
padresTmp =  new Vector();
padresTmp.cargar([])
ccbaOidCcBancDependeceMap.agregar(['ccbaOidCcBanc_sociOidSoci', padresTmp, 'ccbaOidCcBanc', 'SegSocie']);
padresTmp =  new Vector();
padresTmp.cargar([])
ccbaOidCcBancDependeceMap.agregar(['ccbaOidCcBanc_cucoOidCcPnte', padresTmp, 'ccbaOidCcBanc', 'CccCuentConta']);
padresTmp =  new Vector();
padresTmp.cargar([])
ccbaOidCcBancDependeceMap.agregar(['ccbaOidCcBanc_sucuOidSucu_cbanOidBanc', padresTmp, 'ccbaOidCcBanc_sucuOidSucu', 'CccBanco']);
padresTmp =  new Vector();
padresTmp.cargar(['ccbaOidCcBanc_sucuOidSucu_cbanOidBanc'])
ccbaOidCcBancDependeceMap.agregar(['ccbaOidCcBanc_sucuOidSucu', padresTmp, 'ccbaOidCcBanc', 'CccSucur']);
padresTmp =  new Vector();
padresTmp.cargar(['ccbaOidCcBanc_cucoOidCcTeso','ccbaOidCcBanc_sociOidSoci','ccbaOidCcBanc_cucoOidCcPnte','ccbaOidCcBanc_sucuOidSucu'])
ccbaOidCcBancDependeceMap.agregar(['ccbaOidCcBanc', padresTmp, '', 'CccCuentCorriBanca']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
cccMovimBancaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var cccMovimBancaTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function cccMovimBancaInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('cccMovimBancaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('cccMovimBancaFrm.accion')){
		case "query": cccMovimBancaQueryInitComponents(); break;
		case "view": cccMovimBancaViewInitComponents(); break;
		case "create": cccMovimBancaCreateInitComponents(); break;
		case "update": cccMovimBancaUpdateInitComponents(); break;
		case "remove": cccMovimBancaRemoveInitComponents(); break;
		case "lov": cccMovimBancaLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('cccMovimBancaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('cccMovimBanca')) cccMovimBancaCmdRequery();
}

function cccMovimBancaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

function cccMovimBancaViewInitComponents(){
	//En principiono se hace nada
}

function cccMovimBancaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('cccMovimBancaFrm.sociOidSoci','S', GestionarMensaje('CccMovimBanca.sociOidSoci.requiered.message'));
	
	setMV('cccMovimBancaFrm.ttraOidTipoTrans','S', GestionarMensaje('CccMovimBanca.ttraOidTipoTrans.requiered.message'));
	
	setMV('cccMovimBancaFrm.ccbaOidCcBanc','S', GestionarMensaje('CccMovimBanca.ccbaOidCcBanc.requiered.message'));
	
	setMV('cccMovimBancaFrm.numConsTran','S', GestionarMensaje('CccMovimBanca.numConsTran.requiered.message'));
	
	setMV('cccMovimBancaFrm.numLote','S', GestionarMensaje('CccMovimBanca.numLote.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function cccMovimBancaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('cccMovimBancaFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		cccMovimBancaTmpUpdateValues = cccMovimBancaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('cccMovimBancaFrm.sociOidSoci','S', GestionarMensaje('CccMovimBanca.sociOidSoci.requiered.message'));
		
		setMV('cccMovimBancaFrm.ttraOidTipoTrans','S', GestionarMensaje('CccMovimBanca.ttraOidTipoTrans.requiered.message'));
		
		setMV('cccMovimBancaFrm.ccbaOidCcBanc','S', GestionarMensaje('CccMovimBanca.ccbaOidCcBanc.requiered.message'));
		
		setMV('cccMovimBancaFrm.numConsTran','S', GestionarMensaje('CccMovimBanca.numConsTran.requiered.message'));
		
		setMV('cccMovimBancaFrm.numLote','S', GestionarMensaje('CccMovimBanca.numLote.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('cccMovimBancaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function cccMovimBancaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	cccMovimBancaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function cccMovimBancaLovInitComponents(){
	cccMovimBancaLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad







































//Función que permite cargar los datos de un elemento de lov seleccionado
function cccMovimBancaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('cccMovimBancaFrm.' + campo, id);
	set('cccMovimBancaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function cccMovimBancaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	cccMovimBancaLovReturnParameters.id = '';
	cccMovimBancaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function cccMovimBancaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccMovimBancaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = cccMovimBancaList.codSeleccionados();
	var descripcion = cccMovimBancaList.extraeDato(
		cccMovimBancaList.codSeleccionados()[0], cccMovimBancaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	cccMovimBancaLovReturnParameters.id = codigo;
	cccMovimBancaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function cccMovimBancaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('cccMovimBancaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	cccMovimBancaLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('cccMovimBancaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "cccMovimBancaList", "CccMovimBancaConectorTransactionQuery", 
		"result_ROWSET", parametros, "cccMovimBancaPostQueryActions(datos);"]], "", "");	
}

function cccMovimBancaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('cccMovimBancaFrm.lastQueryToSession'));
	var i =0;
	set('cccMovimBancaFrm.sociOidSoci', [paramsRequery.ij(i++)]);
	
	set('cccMovimBancaFrm.subpOidMarcUlti', [paramsRequery.ij(i++)]);
	
	set('cccMovimBancaFrm.subpOidMarcCrea', [paramsRequery.ij(i++)]);
	
	set('cccMovimBancaFrm.tcabOidAbonUlti', [paramsRequery.ij(i++)]);
	
	set('cccMovimBancaFrm.tcabOidAbonCrea', [paramsRequery.ij(i++)]);
	
	set('cccMovimBancaFrm.ttraOidTipoTrans', [paramsRequery.ij(i++)]);
	
	set('cccMovimBancaFrm.ccbaOidCcBanc', [paramsRequery.ij(i++)]);
	
	set('cccMovimBancaFrm.numConsTran', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.numLote', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.codCons', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.codConsReal', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.codErro', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valDigiCheqFact', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valDocuApliAnio', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valDocuApliMesSeri', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valDocuApliNume', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valDocuCreaAnio', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valDocuCreaMesSeri', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valDocuCreaNume', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valEstaMoviPend', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.fecCont', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.fecPago', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.fecProc', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valHoraProc', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valHoraNormAdic', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.codIdenProc', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.impPago', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valNombOfic', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.numCupo', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valNumeDocu', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.numFactBole', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valNumeLoteCont', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valObse', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.codOficReca', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.valUsuaProc', paramsRequery.ij(i++));
	
	set('cccMovimBancaFrm.fecMoviApli', paramsRequery.ij(i++));
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	cccMovimBancaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	cccMovimBancaCmdQuery(cccMovimBancaPageCount);
}

function cccMovimBancaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	cccMovimBancaPageCount = 1;
	cccMovimBancaCmdQuery(cccMovimBancaPageCount);
}

function cccMovimBancaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccMovimBancaLastQuery){
		cccMovimBancaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	cccMovimBancaPageCount--;
	cccMovimBancaCmdQuery(cccMovimBancaPageCount);
}

function cccMovimBancaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != cccMovimBancaLastQuery){
		cccMovimBancaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	cccMovimBancaPageCount++;
	cccMovimBancaCmdQuery(cccMovimBancaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function cccMovimBancaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('cccMovimBancaListLayer', 'O');
		visibilidad('cccMovimBancaListButtonsLayer', 'O');
		if(get('cccMovimBancaFrm.accion') == "remove"){
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
		datosTmp.ij2("<A HREF=\'javascript:cccMovimBancaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, cccMovimBancaChoiceColumn) + "</A>",
			i, cccMovimBancaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	cccMovimBancaList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	cccMovimBancaTimeStamps = datosTmp.filtrar([37],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		cccMovimBancaMorePagesFlag = true;
		cccMovimBancaList.eliminar(mmgPageSize, 1);
	}else{
		cccMovimBancaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('cccMovimBancaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('cccMovimBancaListLayer', 'V');
	visibilidad('cccMovimBancaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('cccMovimBancaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	cccMovimBancaList.display();
	
	//Actualizamos el estado de los botones 
	if(cccMovimBancaMorePagesFlag){
		set_estado_botonera('cccMovimBancaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('cccMovimBancaPaginationButtonBar',
			3,"inactivo");
	}
	if(cccMovimBancaPageCount > 1){
		set_estado_botonera('cccMovimBancaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('cccMovimBancaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('cccMovimBancaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('cccMovimBancaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function cccMovimBancaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccMovimBancaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('cccMovimBancaFrm.idSelection', cccMovimBancaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('cccMovimBancaFrm', true);
	if(validacion){
		/*set('cccMovimBancaFrm.previousAction', 'update');
		set('cccMovimBancaFrm.ON', 'CccMovimBancaLPStartUp');
		set('cccMovimBancaFrm.conectorAction', 'CccMovimBancaLPStartUp');
		set('cccMovimBancaFrm.origen', 'pagina');
		envia('cccMovimBancaFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = cccMovimBancaList.codSeleccionados()[0];
		parametros["previousAction"] = get('cccMovimBancaFrm.accion');
		parametros["accion"] = get('cccMovimBancaFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('CccMovimBancaLPStartUp', get('cccMovimBancaFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) cccMovimBancaCmdRequery();
	}
}

function cccMovimBancaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccMovimBancaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = cccMovimBancaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('cccMovimBancaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(cccMovimBancaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += cccMovimBancaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('cccMovimBancaFrm.timestamp', timestamps);
	envia('cccMovimBancaFrm');
}

function cccMovimBancaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(cccMovimBancaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('cccMovimBancaFrm.previousAction', get('cccMovimBancaFrm.accion'));
	set('cccMovimBancaFrm.accion', 'view');
	set('cccMovimBancaFrm.origen', 'pagina');
	set('cccMovimBancaFrm.ON', 'CccMovimBancaLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('cccMovimBancaFrm.idSelection', cccMovimBancaList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('cccMovimBancaFrm');
	cccMovimBancaViewDetail(cccMovimBancaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function cccMovimBancaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('cccMovimBancaFrm.accion');
	parametros["accion"] = get('cccMovimBancaFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('CccMovimBancaLPStartUp', get('cccMovimBancaFrm.accion'), parametros, null, sizeFormView + 30);
}

//Función ejecutada cuando se pulsa el botón de guardar en la botonera
function Guardar(){
	//Nos aseguramos que de los campos i18n se coge la descripción del idioma por defecto
	//intreoducido directamente a través del widget. Esto se pone debio a que la tecla rápida
	//de guardar on dispara un evento de onblur sobre el componte que tenga el foco
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		

	//Validamos el formualrio y lo enviamos.
	//Druida al detectar un error en un campo lleva el foco a el para mostrar que es el campo del error
	//Si el campo es de tipo list pega un casque de javascript luego antes de validar hacemos los campos
	//de los list editables. Una vez hecha la validación los volvemos a poner a no editables
	setNonEditableElementsStatus(false);
	var validacion = ValidaForm('cccMovimBancaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion)envia('cccMovimBancaFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	cccMovimBancaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('cccMovimBancaFrm.accion');
	var origenTmp = get('cccMovimBancaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(cccMovimBancaBuildUpdateRecordString() != cccMovimBancaTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('cccMovimBancaFrm.performRequery', 'true');
		set('cccMovimBancaFrm.accion', 
			get('cccMovimBancaFrm.previousAction'));
		set('cccMovimBancaFrm.origen', 'menu');
		set('cccMovimBancaFrm.ON', 'CccMovimBancaLPStartUp');
		set('cccMovimBancaFrm.conectorAction', 'CccMovimBancaLPStartUp');
		cccMovimBancaFrm.oculto='N';
		envia('cccMovimBancaFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.cccMovimBancaListLayer.style.display='none';
	document.all.cccMovimBancaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.cccMovimBancaListLayer.style.display='';
	document.all.cccMovimBancaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda

	jsCccMovimBancaSociOidSoci = get('cccMovimBancaFrm.sociOidSoci')[0];





	jsCccMovimBancaSubpOidMarcUlti = get('cccMovimBancaFrm.subpOidMarcUlti')[0];





	jsCccMovimBancaSubpOidMarcCrea = get('cccMovimBancaFrm.subpOidMarcCrea')[0];





	jsCccMovimBancaTcabOidAbonUlti = get('cccMovimBancaFrm.tcabOidAbonUlti')[0];





	jsCccMovimBancaTcabOidAbonCrea = get('cccMovimBancaFrm.tcabOidAbonCrea')[0];





	jsCccMovimBancaTtraOidTipoTrans = get('cccMovimBancaFrm.ttraOidTipoTrans')[0];





	jsCccMovimBancaCcbaOidCcBanc = get('cccMovimBancaFrm.ccbaOidCcBanc')[0];




	jsCccMovimBancaNumConsTran = get('cccMovimBancaFrm.numConsTran').toString();






	jsCccMovimBancaNumLote = get('cccMovimBancaFrm.numLote').toString();






	jsCccMovimBancaCodCons = get('cccMovimBancaFrm.codCons').toString();






	jsCccMovimBancaCodConsReal = get('cccMovimBancaFrm.codConsReal').toString();






	jsCccMovimBancaCodErro = get('cccMovimBancaFrm.codErro').toString();






	jsCccMovimBancaValDigiCheqFact = get('cccMovimBancaFrm.valDigiCheqFact').toString();






	jsCccMovimBancaValDocuApliAnio = get('cccMovimBancaFrm.valDocuApliAnio').toString();






	jsCccMovimBancaValDocuApliMesSeri = get('cccMovimBancaFrm.valDocuApliMesSeri').toString();






	jsCccMovimBancaValDocuApliNume = get('cccMovimBancaFrm.valDocuApliNume').toString();






	jsCccMovimBancaValDocuCreaAnio = get('cccMovimBancaFrm.valDocuCreaAnio').toString();






	jsCccMovimBancaValDocuCreaMesSeri = get('cccMovimBancaFrm.valDocuCreaMesSeri').toString();






	jsCccMovimBancaValDocuCreaNume = get('cccMovimBancaFrm.valDocuCreaNume').toString();






	jsCccMovimBancaValEstaMoviPend = get('cccMovimBancaFrm.valEstaMoviPend').toString();






	jsCccMovimBancaFecCont = get('cccMovimBancaFrm.fecCont').toString();






	jsCccMovimBancaFecPago = get('cccMovimBancaFrm.fecPago').toString();






	jsCccMovimBancaFecProc = get('cccMovimBancaFrm.fecProc').toString();






	jsCccMovimBancaValHoraProc = get('cccMovimBancaFrm.valHoraProc').toString();






	jsCccMovimBancaValHoraNormAdic = get('cccMovimBancaFrm.valHoraNormAdic').toString();






	jsCccMovimBancaCodIdenProc = get('cccMovimBancaFrm.codIdenProc').toString();






	jsCccMovimBancaImpPago = get('cccMovimBancaFrm.impPago').toString();






	jsCccMovimBancaValNombOfic = get('cccMovimBancaFrm.valNombOfic').toString();






	jsCccMovimBancaNumCupo = get('cccMovimBancaFrm.numCupo').toString();






	jsCccMovimBancaValNumeDocu = get('cccMovimBancaFrm.valNumeDocu').toString();






	jsCccMovimBancaNumFactBole = get('cccMovimBancaFrm.numFactBole').toString();






	jsCccMovimBancaValNumeLoteCont = get('cccMovimBancaFrm.valNumeLoteCont').toString();






	jsCccMovimBancaValObse = get('cccMovimBancaFrm.valObse').toString();






	jsCccMovimBancaCodOficReca = get('cccMovimBancaFrm.codOficReca').toString();






	jsCccMovimBancaValUsuaProc = get('cccMovimBancaFrm.valUsuaProc').toString();






	jsCccMovimBancaFecMoviApli = get('cccMovimBancaFrm.fecMoviApli').toString();








	var parametros = "";
	parametros += jsCccMovimBancaSociOidSoci + "|";



	parametros += jsCccMovimBancaSubpOidMarcUlti + "|";



	parametros += jsCccMovimBancaSubpOidMarcCrea + "|";



	parametros += jsCccMovimBancaTcabOidAbonUlti + "|";



	parametros += jsCccMovimBancaTcabOidAbonCrea + "|";



	parametros += jsCccMovimBancaTtraOidTipoTrans + "|";



	parametros += jsCccMovimBancaCcbaOidCcBanc + "|";



	parametros += jsCccMovimBancaNumConsTran + "|";



	parametros += jsCccMovimBancaNumLote + "|";



	parametros += jsCccMovimBancaCodCons + "|";



	parametros += jsCccMovimBancaCodConsReal + "|";



	parametros += jsCccMovimBancaCodErro + "|";



	parametros += jsCccMovimBancaValDigiCheqFact + "|";



	parametros += jsCccMovimBancaValDocuApliAnio + "|";



	parametros += jsCccMovimBancaValDocuApliMesSeri + "|";



	parametros += jsCccMovimBancaValDocuApliNume + "|";



	parametros += jsCccMovimBancaValDocuCreaAnio + "|";



	parametros += jsCccMovimBancaValDocuCreaMesSeri + "|";



	parametros += jsCccMovimBancaValDocuCreaNume + "|";



	parametros += jsCccMovimBancaValEstaMoviPend + "|";



	parametros += jsCccMovimBancaFecCont + "|";



	parametros += jsCccMovimBancaFecPago + "|";



	parametros += jsCccMovimBancaFecProc + "|";



	parametros += jsCccMovimBancaValHoraProc + "|";



	parametros += jsCccMovimBancaValHoraNormAdic + "|";



	parametros += jsCccMovimBancaCodIdenProc + "|";



	parametros += jsCccMovimBancaImpPago + "|";



	parametros += jsCccMovimBancaValNombOfic + "|";



	parametros += jsCccMovimBancaNumCupo + "|";



	parametros += jsCccMovimBancaValNumeDocu + "|";



	parametros += jsCccMovimBancaNumFactBole + "|";



	parametros += jsCccMovimBancaValNumeLoteCont + "|";



	parametros += jsCccMovimBancaValObse + "|";



	parametros += jsCccMovimBancaCodOficReca + "|";



	parametros += jsCccMovimBancaValUsuaProc + "|";



	parametros += jsCccMovimBancaFecMoviApli + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function cccMovimBancaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCccMovimBancaSociOidSoci + "|";
	parametros += jsCccMovimBancaSubpOidMarcUlti + "|";
	parametros += jsCccMovimBancaSubpOidMarcCrea + "|";
	parametros += jsCccMovimBancaTcabOidAbonUlti + "|";
	parametros += jsCccMovimBancaTcabOidAbonCrea + "|";
	parametros += jsCccMovimBancaTtraOidTipoTrans + "|";
	parametros += jsCccMovimBancaCcbaOidCcBanc + "|";
	parametros += jsCccMovimBancaNumConsTran + "|";
	parametros += jsCccMovimBancaNumLote + "|";
	parametros += jsCccMovimBancaCodCons + "|";
	parametros += jsCccMovimBancaCodConsReal + "|";
	parametros += jsCccMovimBancaCodErro + "|";
	parametros += jsCccMovimBancaValDigiCheqFact + "|";
	parametros += jsCccMovimBancaValDocuApliAnio + "|";
	parametros += jsCccMovimBancaValDocuApliMesSeri + "|";
	parametros += jsCccMovimBancaValDocuApliNume + "|";
	parametros += jsCccMovimBancaValDocuCreaAnio + "|";
	parametros += jsCccMovimBancaValDocuCreaMesSeri + "|";
	parametros += jsCccMovimBancaValDocuCreaNume + "|";
	parametros += jsCccMovimBancaValEstaMoviPend + "|";
	parametros += jsCccMovimBancaFecCont + "|";
	parametros += jsCccMovimBancaFecPago + "|";
	parametros += jsCccMovimBancaFecProc + "|";
	parametros += jsCccMovimBancaValHoraProc + "|";
	parametros += jsCccMovimBancaValHoraNormAdic + "|";
	parametros += jsCccMovimBancaCodIdenProc + "|";
	parametros += jsCccMovimBancaImpPago + "|";
	parametros += jsCccMovimBancaValNombOfic + "|";
	parametros += jsCccMovimBancaNumCupo + "|";
	parametros += jsCccMovimBancaValNumeDocu + "|";
	parametros += jsCccMovimBancaNumFactBole + "|";
	parametros += jsCccMovimBancaValNumeLoteCont + "|";
	parametros += jsCccMovimBancaValObse + "|";
	parametros += jsCccMovimBancaCodOficReca + "|";
	parametros += jsCccMovimBancaValUsuaProc + "|";
	parametros += jsCccMovimBancaFecMoviApli + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccMovimBancaFrm.accion'), 
		get('cccMovimBancaFrm.origen'));
	
	jsCccMovimBancaId = get('cccMovimBancaFrm.id').toString();
	jsCccMovimBancaSociOidSoci = get('cccMovimBancaFrm.sociOidSoci')[0];
	jsCccMovimBancaSubpOidMarcUlti = get('cccMovimBancaFrm.subpOidMarcUlti')[0];
	jsCccMovimBancaSubpOidMarcCrea = get('cccMovimBancaFrm.subpOidMarcCrea')[0];
	jsCccMovimBancaTcabOidAbonUlti = get('cccMovimBancaFrm.tcabOidAbonUlti')[0];
	jsCccMovimBancaTcabOidAbonCrea = get('cccMovimBancaFrm.tcabOidAbonCrea')[0];
	jsCccMovimBancaTtraOidTipoTrans = get('cccMovimBancaFrm.ttraOidTipoTrans')[0];
	jsCccMovimBancaCcbaOidCcBanc = get('cccMovimBancaFrm.ccbaOidCcBanc')[0];
	jsCccMovimBancaNumConsTran = get('cccMovimBancaFrm.numConsTran').toString();
	jsCccMovimBancaNumLote = get('cccMovimBancaFrm.numLote').toString();
	jsCccMovimBancaCodCons = get('cccMovimBancaFrm.codCons').toString();
	jsCccMovimBancaCodConsReal = get('cccMovimBancaFrm.codConsReal').toString();
	jsCccMovimBancaCodErro = get('cccMovimBancaFrm.codErro').toString();
	jsCccMovimBancaValDigiCheqFact = get('cccMovimBancaFrm.valDigiCheqFact').toString();
	jsCccMovimBancaValDocuApliAnio = get('cccMovimBancaFrm.valDocuApliAnio').toString();
	jsCccMovimBancaValDocuApliMesSeri = get('cccMovimBancaFrm.valDocuApliMesSeri').toString();
	jsCccMovimBancaValDocuApliNume = get('cccMovimBancaFrm.valDocuApliNume').toString();
	jsCccMovimBancaValDocuCreaAnio = get('cccMovimBancaFrm.valDocuCreaAnio').toString();
	jsCccMovimBancaValDocuCreaMesSeri = get('cccMovimBancaFrm.valDocuCreaMesSeri').toString();
	jsCccMovimBancaValDocuCreaNume = get('cccMovimBancaFrm.valDocuCreaNume').toString();
	jsCccMovimBancaValEstaMoviPend = get('cccMovimBancaFrm.valEstaMoviPend').toString();
	jsCccMovimBancaFecCont = get('cccMovimBancaFrm.fecCont').toString();
	jsCccMovimBancaFecPago = get('cccMovimBancaFrm.fecPago').toString();
	jsCccMovimBancaFecProc = get('cccMovimBancaFrm.fecProc').toString();
	jsCccMovimBancaValHoraProc = get('cccMovimBancaFrm.valHoraProc').toString();
	jsCccMovimBancaValHoraNormAdic = get('cccMovimBancaFrm.valHoraNormAdic').toString();
	jsCccMovimBancaCodIdenProc = get('cccMovimBancaFrm.codIdenProc').toString();
	jsCccMovimBancaImpPago = get('cccMovimBancaFrm.impPago').toString();
	jsCccMovimBancaValNombOfic = get('cccMovimBancaFrm.valNombOfic').toString();
	jsCccMovimBancaNumCupo = get('cccMovimBancaFrm.numCupo').toString();
	jsCccMovimBancaValNumeDocu = get('cccMovimBancaFrm.valNumeDocu').toString();
	jsCccMovimBancaNumFactBole = get('cccMovimBancaFrm.numFactBole').toString();
	jsCccMovimBancaValNumeLoteCont = get('cccMovimBancaFrm.valNumeLoteCont').toString();
	jsCccMovimBancaValObse = get('cccMovimBancaFrm.valObse').toString();
	jsCccMovimBancaCodOficReca = get('cccMovimBancaFrm.codOficReca').toString();
	jsCccMovimBancaValUsuaProc = get('cccMovimBancaFrm.valUsuaProc').toString();
	jsCccMovimBancaFecMoviApli = get('cccMovimBancaFrm.fecMoviApli').toString();

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('cccMovimBancaFrm.accion'), 
		get('cccMovimBancaFrm.origen'));


	set('cccMovimBancaFrm.id', jsCccMovimBancaId);
	set('cccMovimBancaFrm.sociOidSoci', [jsCccMovimBancaSociOidSoci]);
	set('cccMovimBancaFrm.subpOidMarcUlti', [jsCccMovimBancaSubpOidMarcUlti]);
	set('cccMovimBancaFrm.subpOidMarcCrea', [jsCccMovimBancaSubpOidMarcCrea]);
	set('cccMovimBancaFrm.tcabOidAbonUlti', [jsCccMovimBancaTcabOidAbonUlti]);
	set('cccMovimBancaFrm.tcabOidAbonCrea', [jsCccMovimBancaTcabOidAbonCrea]);
	set('cccMovimBancaFrm.ttraOidTipoTrans', [jsCccMovimBancaTtraOidTipoTrans]);
	set('cccMovimBancaFrm.ccbaOidCcBanc', [jsCccMovimBancaCcbaOidCcBanc]);
	set('cccMovimBancaFrm.numConsTran', jsCccMovimBancaNumConsTran);
	set('cccMovimBancaFrm.numLote', jsCccMovimBancaNumLote);
	set('cccMovimBancaFrm.codCons', jsCccMovimBancaCodCons);
	set('cccMovimBancaFrm.codConsReal', jsCccMovimBancaCodConsReal);
	set('cccMovimBancaFrm.codErro', jsCccMovimBancaCodErro);
	set('cccMovimBancaFrm.valDigiCheqFact', jsCccMovimBancaValDigiCheqFact);
	set('cccMovimBancaFrm.valDocuApliAnio', jsCccMovimBancaValDocuApliAnio);
	set('cccMovimBancaFrm.valDocuApliMesSeri', jsCccMovimBancaValDocuApliMesSeri);
	set('cccMovimBancaFrm.valDocuApliNume', jsCccMovimBancaValDocuApliNume);
	set('cccMovimBancaFrm.valDocuCreaAnio', jsCccMovimBancaValDocuCreaAnio);
	set('cccMovimBancaFrm.valDocuCreaMesSeri', jsCccMovimBancaValDocuCreaMesSeri);
	set('cccMovimBancaFrm.valDocuCreaNume', jsCccMovimBancaValDocuCreaNume);
	set('cccMovimBancaFrm.valEstaMoviPend', jsCccMovimBancaValEstaMoviPend);
	set('cccMovimBancaFrm.fecCont', jsCccMovimBancaFecCont);
	set('cccMovimBancaFrm.fecPago', jsCccMovimBancaFecPago);
	set('cccMovimBancaFrm.fecProc', jsCccMovimBancaFecProc);
	set('cccMovimBancaFrm.valHoraProc', jsCccMovimBancaValHoraProc);
	set('cccMovimBancaFrm.valHoraNormAdic', jsCccMovimBancaValHoraNormAdic);
	set('cccMovimBancaFrm.codIdenProc', jsCccMovimBancaCodIdenProc);
	set('cccMovimBancaFrm.impPago', jsCccMovimBancaImpPago);
	set('cccMovimBancaFrm.valNombOfic', jsCccMovimBancaValNombOfic);
	set('cccMovimBancaFrm.numCupo', jsCccMovimBancaNumCupo);
	set('cccMovimBancaFrm.valNumeDocu', jsCccMovimBancaValNumeDocu);
	set('cccMovimBancaFrm.numFactBole', jsCccMovimBancaNumFactBole);
	set('cccMovimBancaFrm.valNumeLoteCont', jsCccMovimBancaValNumeLoteCont);
	set('cccMovimBancaFrm.valObse', jsCccMovimBancaValObse);
	set('cccMovimBancaFrm.codOficReca', jsCccMovimBancaCodOficReca);
	set('cccMovimBancaFrm.valUsuaProc', jsCccMovimBancaValUsuaProc);
	set('cccMovimBancaFrm.fecMoviApli', jsCccMovimBancaFecMoviApli);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('cccMovimBancaFrm.errCodigo', errorCode);
	set('cccMovimBancaFrm.errDescripcion', description);
	set('cccMovimBancaFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
