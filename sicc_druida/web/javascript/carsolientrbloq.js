

/*
    INDRA/CAR/mmg
    $Id: carsolientrbloq.js,v 1.1 2009/12/03 19:01:41 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsCarSoliEntrBloqId = "";
var jsCarSoliEntrBloqPaisOidPais = "";
var jsCarSoliEntrBloqSbacOidSbac = "";
var jsCarSoliEntrBloqTsolOidTipoSoli = "";
var jsCarSoliEntrBloqSocaOidSoliCabe = "";
var jsCarSoliEntrBloqFecDocu = "";
var jsCarSoliEntrBloqIndNoti = "";
var jsCarSoliEntrBloqValMontOrde = "";
var jsCarSoliEntrBloqValMontDeudVenc = "";
var jsCarSoliEntrBloqIndVali1 = "";
var jsCarSoliEntrBloqIndVali2 = "";
var jsCarSoliEntrBloqIndVali3 = "";
var jsCarSoliEntrBloqIndVali4 = "";
var jsCarSoliEntrBloqFecHoraLibe = "";
var jsCarSoliEntrBloqValObse = "";
var jsCarSoliEntrBloqJeraOidJera = "";
var jsCarSoliEntrBloqEspeOidEstaPedi = "";
var jsCarSoliEntrBloqPerdOidPeri = "";
var jsCarSoliEntrBloqClieOidClie = "";
var jsCarSoliEntrBloqClieOidGereZona = "";
var jsCarSoliEntrBloqCuadOidClieUnidAdmi = "";
var jsCarSoliEntrBloqCoapOidCodiApro = "";
var jsCarSoliEntrBloqEjcuOidEjecCuen = "";
var jsCarSoliEntrBloqEjcuOidUsuaLibe = "";
var jsCarSoliEntrBloqNiriOidNiveRies = "";
var jsCarSoliEntrBloqGrsoOidGrupSoli = "";

//Variables de paginacion, 
var carSoliEntrBloqPageCount = 1;

//Varible de columna que representa el campo de choice
var carSoliEntrBloqChoiceColumn = 25;

//Flag de siguiente pagina;
var carSoliEntrBloqMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var carSoliEntrBloqTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 1655;
var sizeFormView = 1655;
var sizeFormUpdate = 1655;

//Ultima busqueda realizada
var carSoliEntrBloqLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[0,'focalizaComboDependence("carSoliEntrBloq","grsoOidGrupSoli", false);','focalizaComboDependence("carSoliEntrBloq","grsoOidGrupSoli", false);','focalizaComboDependence("carSoliEntrBloq","grsoOidGrupSoli", false);','focalizaComboDependence("carSoliEntrBloq","grsoOidGrupSoli", true);','focalizaComboDependence("carSoliEntrBloq","grsoOidGrupSoli", true);','focalizaComboDependence("carSoliEntrBloq","grsoOidGrupSoli", true);']]);

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
paisOidPaisDependeceMap.agregar(['paisOidPais_fopaOidFormPago', padresTmp, 'paisOidPais', 'BelFormaPagoTapon']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMoneAlt', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais_moneOidMone', padresTmp, 'paisOidPais', 'SegMoned']);
padresTmp =  new Vector();
padresTmp.cargar(['paisOidPais_fopaOidFormPago','paisOidPais_moneOidMoneAlt','paisOidPais_moneOidMone'])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPais']);
var sbacOidSbacDependeceMap = new Vector();
sbacOidSbacDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sbacOidSbacDependeceMap.agregar(['sbacOidSbac_acceOidAcce_canaOidCana', padresTmp, 'sbacOidSbac_acceOidAcce', 'SegCanalView']);
padresTmp =  new Vector();
padresTmp.cargar(['sbacOidSbac_acceOidAcce_canaOidCana'])
sbacOidSbacDependeceMap.agregar(['sbacOidSbac_acceOidAcce', padresTmp, 'sbacOidSbac', 'SegAcces']);
padresTmp =  new Vector();
padresTmp.cargar(['sbacOidSbac_acceOidAcce'])
sbacOidSbacDependeceMap.agregar(['sbacOidSbac', padresTmp, '', 'SegSubac']);
var tsolOidTipoSoliDependeceMap = new Vector();
tsolOidTipoSoliDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tsolOidTipoSoliDependeceMap.agregar(['tsolOidTipoSoli', padresTmp, '', 'PedTipoSolic']);
var socaOidSoliCabeDependeceMap = new Vector();
socaOidSoliCabeDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
socaOidSoliCabeDependeceMap.agregar(['socaOidSoliCabe', padresTmp, '', 'PedSolicCabec']);
var jeraOidJeraDependeceMap = new Vector();
jeraOidJeraDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
jeraOidJeraDependeceMap.agregar(['jeraOidJera', padresTmp, '', 'CarJerar']);
var espeOidEstaPediDependeceMap = new Vector();
espeOidEstaPediDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
espeOidEstaPediDependeceMap.agregar(['espeOidEstaPedi', padresTmp, '', 'CarEstatPedid']);
var perdOidPeriDependeceMap = new Vector();
perdOidPeriDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
perdOidPeriDependeceMap.agregar(['perdOidPeri', padresTmp, '', 'CraPerio']);
var clieOidClieDependeceMap = new Vector();
clieOidClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clieOidClieDependeceMap.agregar(['clieOidClie', padresTmp, '', 'MaeClien']);
var clieOidGereZonaDependeceMap = new Vector();
clieOidGereZonaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clieOidGereZonaDependeceMap.agregar(['clieOidGereZona', padresTmp, '', 'MaeClien']);
var cuadOidClieUnidAdmiDependeceMap = new Vector();
cuadOidClieUnidAdmiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
cuadOidClieUnidAdmiDependeceMap.agregar(['cuadOidClieUnidAdmi', padresTmp, '', 'MaeClienUnidaAdmin']);
var coapOidCodiAproDependeceMap = new Vector();
coapOidCodiAproDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
coapOidCodiAproDependeceMap.agregar(['coapOidCodiApro', padresTmp, '', 'CarCodigAprob']);
var ejcuOidEjecCuenDependeceMap = new Vector();
ejcuOidEjecCuenDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ejcuOidEjecCuenDependeceMap.agregar(['ejcuOidEjecCuen', padresTmp, '', 'CarEjecuCuent']);
var ejcuOidUsuaLibeDependeceMap = new Vector();
ejcuOidUsuaLibeDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ejcuOidUsuaLibeDependeceMap.agregar(['ejcuOidUsuaLibe', padresTmp, '', 'CarEjecuCuent']);
var niriOidNiveRiesDependeceMap = new Vector();
niriOidNiveRiesDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
niriOidNiveRiesDependeceMap.agregar(['niriOidNiveRies', padresTmp, '', 'CarNivelRiesg']);
var grsoOidGrupSoliDependeceMap = new Vector();
grsoOidGrupSoliDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
grsoOidGrupSoliDependeceMap.agregar(['grsoOidGrupSoli', padresTmp, '', 'CarGrupoSolic']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
carSoliEntrBloqLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var carSoliEntrBloqTmpUpdateValues;


//Función ejecutada en el onload de la pagina
function carSoliEntrBloqInitComponents(){
	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('carSoliEntrBloqFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('carSoliEntrBloqFrm.accion')){
		case "query": carSoliEntrBloqQueryInitComponents(); break;
		case "view": carSoliEntrBloqViewInitComponents(); break;
		case "create": carSoliEntrBloqCreateInitComponents(); break;
		case "update": carSoliEntrBloqUpdateInitComponents(); break;
		case "remove": carSoliEntrBloqRemoveInitComponents(); break;
		case "lov": carSoliEntrBloqLovInitComponents(); break;
	}
	
	//Ponemos el foco en el primer campo
	focusFirstField('carSoliEntrBloqFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('carSoliEntrBloq')) carSoliEntrBloqCmdRequery();
}

function carSoliEntrBloqQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

function carSoliEntrBloqViewInitComponents(){
	//En principiono se hace nada
}

function carSoliEntrBloqCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('carSoliEntrBloqFrm.paisOidPais','S', GestionarMensaje('CarSoliEntrBloq.paisOidPais.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.sbacOidSbac','S', GestionarMensaje('CarSoliEntrBloq.sbacOidSbac.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.tsolOidTipoSoli','S', GestionarMensaje('CarSoliEntrBloq.tsolOidTipoSoli.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.socaOidSoliCabe','S', GestionarMensaje('CarSoliEntrBloq.socaOidSoliCabe.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.fecDocu','S', GestionarMensaje('CarSoliEntrBloq.fecDocu.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.indNoti','S', GestionarMensaje('CarSoliEntrBloq.indNoti.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.valMontOrde','S', GestionarMensaje('CarSoliEntrBloq.valMontOrde.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.valMontDeudVenc','S', GestionarMensaje('CarSoliEntrBloq.valMontDeudVenc.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.jeraOidJera','S', GestionarMensaje('CarSoliEntrBloq.jeraOidJera.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.espeOidEstaPedi','S', GestionarMensaje('CarSoliEntrBloq.espeOidEstaPedi.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.perdOidPeri','S', GestionarMensaje('CarSoliEntrBloq.perdOidPeri.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.clieOidClie','S', GestionarMensaje('CarSoliEntrBloq.clieOidClie.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.cuadOidClieUnidAdmi','S', GestionarMensaje('CarSoliEntrBloq.cuadOidClieUnidAdmi.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.ejcuOidEjecCuen','S', GestionarMensaje('CarSoliEntrBloq.ejcuOidEjecCuen.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.niriOidNiveRies','S', GestionarMensaje('CarSoliEntrBloq.niriOidNiveRies.requiered.message'));
	
	setMV('carSoliEntrBloqFrm.grsoOidGrupSoli','S', GestionarMensaje('CarSoliEntrBloq.grsoOidGrupSoli.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
}

function carSoliEntrBloqUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('carSoliEntrBloqFrm.origen') == "pagina"){
		

		//Registramos el valor del elemento que estamos modificando
		carSoliEntrBloqTmpUpdateValues = carSoliEntrBloqBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('carSoliEntrBloqFrm.paisOidPais','S', GestionarMensaje('CarSoliEntrBloq.paisOidPais.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.sbacOidSbac','S', GestionarMensaje('CarSoliEntrBloq.sbacOidSbac.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.tsolOidTipoSoli','S', GestionarMensaje('CarSoliEntrBloq.tsolOidTipoSoli.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.socaOidSoliCabe','S', GestionarMensaje('CarSoliEntrBloq.socaOidSoliCabe.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.fecDocu','S', GestionarMensaje('CarSoliEntrBloq.fecDocu.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.indNoti','S', GestionarMensaje('CarSoliEntrBloq.indNoti.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.valMontOrde','S', GestionarMensaje('CarSoliEntrBloq.valMontOrde.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.valMontDeudVenc','S', GestionarMensaje('CarSoliEntrBloq.valMontDeudVenc.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.jeraOidJera','S', GestionarMensaje('CarSoliEntrBloq.jeraOidJera.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.espeOidEstaPedi','S', GestionarMensaje('CarSoliEntrBloq.espeOidEstaPedi.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.perdOidPeri','S', GestionarMensaje('CarSoliEntrBloq.perdOidPeri.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.clieOidClie','S', GestionarMensaje('CarSoliEntrBloq.clieOidClie.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.cuadOidClieUnidAdmi','S', GestionarMensaje('CarSoliEntrBloq.cuadOidClieUnidAdmi.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.ejcuOidEjecCuen','S', GestionarMensaje('CarSoliEntrBloq.ejcuOidEjecCuen.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.niriOidNiveRies','S', GestionarMensaje('CarSoliEntrBloq.niriOidNiveRies.requiered.message'));
		
		setMV('carSoliEntrBloqFrm.grsoOidGrupSoli','S', GestionarMensaje('CarSoliEntrBloq.grsoOidGrupSoli.requiered.message'));
		
		
	
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('carSoliEntrBloqFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function carSoliEntrBloqRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	carSoliEntrBloqList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');			
}

function carSoliEntrBloqLovInitComponents(){
	carSoliEntrBloqLovReturnParameters = window.dialogArguments;
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad




























//Función que permite cargar los datos de un elemento de lov seleccionado
function carSoliEntrBloqSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('carSoliEntrBloqFrm.' + campo, id);
	set('carSoliEntrBloqFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function carSoliEntrBloqLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	carSoliEntrBloqLovReturnParameters.id = '';
	carSoliEntrBloqLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function carSoliEntrBloqLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carSoliEntrBloqList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = carSoliEntrBloqList.codSeleccionados();
	var descripcion = carSoliEntrBloqList.extraeDato(
		carSoliEntrBloqList.codSeleccionados()[0], carSoliEntrBloqChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	carSoliEntrBloqLovReturnParameters.id = codigo;
	carSoliEntrBloqLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function carSoliEntrBloqCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('carSoliEntrBloqFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	carSoliEntrBloqLastQuery = parametros;

	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('carSoliEntrBloqFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "carSoliEntrBloqList", "CarSoliEntrBloqConectorTransactionQuery", 
		"result_ROWSET", parametros, "carSoliEntrBloqPostQueryActions(datos);"]], "", "");	
}

function carSoliEntrBloqCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('carSoliEntrBloqFrm.lastQueryToSession'));
	var i =0;
	set('carSoliEntrBloqFrm.paisOidPais', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.sbacOidSbac', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.tsolOidTipoSoli', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.socaOidSoliCabe', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.fecDocu', paramsRequery.ij(i++));
	
	set('carSoliEntrBloqFrm.indNoti', paramsRequery.ij(i++));
	
	set('carSoliEntrBloqFrm.valMontOrde', paramsRequery.ij(i++));
	
	set('carSoliEntrBloqFrm.valMontDeudVenc', paramsRequery.ij(i++));
	
	set('carSoliEntrBloqFrm.indVali1', paramsRequery.ij(i++));
	
	set('carSoliEntrBloqFrm.indVali2', paramsRequery.ij(i++));
	
	set('carSoliEntrBloqFrm.indVali3', paramsRequery.ij(i++));
	
	set('carSoliEntrBloqFrm.indVali4', paramsRequery.ij(i++));
	
	set('carSoliEntrBloqFrm.fecHoraLibe', paramsRequery.ij(i++));
	
	set('carSoliEntrBloqFrm.valObse', paramsRequery.ij(i++));
	
	set('carSoliEntrBloqFrm.jeraOidJera', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.espeOidEstaPedi', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.perdOidPeri', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.clieOidClie', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.clieOidGereZona', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.cuadOidClieUnidAdmi', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.coapOidCodiApro', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.ejcuOidEjecCuen', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.ejcuOidUsuaLibe', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.niriOidNiveRies', [paramsRequery.ij(i++)]);
	
	set('carSoliEntrBloqFrm.grsoOidGrupSoli', [paramsRequery.ij(i++)]);
	
	
	
	//No se nos actualizar los parmámetros de la paginación
	carSoliEntrBloqPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	carSoliEntrBloqCmdQuery(carSoliEntrBloqPageCount);
}

function carSoliEntrBloqFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	carSoliEntrBloqPageCount = 1;
	carSoliEntrBloqCmdQuery(carSoliEntrBloqPageCount);
}

function carSoliEntrBloqPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carSoliEntrBloqLastQuery){
		carSoliEntrBloqFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	carSoliEntrBloqPageCount--;
	carSoliEntrBloqCmdQuery(carSoliEntrBloqPageCount);
}

function carSoliEntrBloqNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != carSoliEntrBloqLastQuery){
		carSoliEntrBloqFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	carSoliEntrBloqPageCount++;
	carSoliEntrBloqCmdQuery(carSoliEntrBloqPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function carSoliEntrBloqPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('carSoliEntrBloqListLayer', 'O');
		visibilidad('carSoliEntrBloqListButtonsLayer', 'O');
		visibilidad('carSoliEntrBloqPreListLayer', 'O');
		if(get('carSoliEntrBloqFrm.accion') == "remove"){
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
		datosTmp.ij2("<A HREF=\'javascript:carSoliEntrBloqViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, carSoliEntrBloqChoiceColumn) + "</A>",
			i, carSoliEntrBloqChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	carSoliEntrBloqList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	carSoliEntrBloqTimeStamps = datosTmp.filtrar([26],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		carSoliEntrBloqMorePagesFlag = true;
		carSoliEntrBloqList.eliminar(mmgPageSize, 1);
	}else{
		carSoliEntrBloqMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('carSoliEntrBloqFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('carSoliEntrBloqListLayer', 'V');
	visibilidad('carSoliEntrBloqListButtonsLayer', 'V');
	visibilidad('carSoliEntrBloqPreListLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('carSoliEntrBloqList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	carSoliEntrBloqList.display();
	
	//Actualizamos el estado de los botones 
	if(carSoliEntrBloqMorePagesFlag){
		set_estado_botonera('carSoliEntrBloqPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('carSoliEntrBloqPaginationButtonBar',
			3,"inactivo");
	}
	if(carSoliEntrBloqPageCount > 1){
		set_estado_botonera('carSoliEntrBloqPaginationButtonBar',
			2,"activo");
		set_estado_botonera('carSoliEntrBloqPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('carSoliEntrBloqPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('carSoliEntrBloqPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function carSoliEntrBloqUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carSoliEntrBloqList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('carSoliEntrBloqFrm.idSelection', carSoliEntrBloqList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('carSoliEntrBloqFrm', true);
	if(validacion){
		/*set('carSoliEntrBloqFrm.previousAction', 'update');
		set('carSoliEntrBloqFrm.ON', 'CarSoliEntrBloqLPStartUp');
		set('carSoliEntrBloqFrm.conectorAction', 'CarSoliEntrBloqLPStartUp');
		set('carSoliEntrBloqFrm.origen', 'pagina');
		envia('carSoliEntrBloqFrm');*/

		var parametros = new Array();
		parametros["idSelection"] = carSoliEntrBloqList.codSeleccionados()[0];
		parametros["previousAction"] = get('carSoliEntrBloqFrm.accion');
		parametros["accion"] = get('carSoliEntrBloqFrm.accion');
		parametros["origen"] = 'pagina';
		var result = mostrarModalSICC('CarSoliEntrBloqLPStartUp', get('carSoliEntrBloqFrm.accion'), parametros, null, sizeFormView + 30);
		if(result == MMG_RC_OK) carSoliEntrBloqCmdRequery();
	}
}

function carSoliEntrBloqRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carSoliEntrBloqList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = carSoliEntrBloqList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('carSoliEntrBloqFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(carSoliEntrBloqList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += carSoliEntrBloqTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('carSoliEntrBloqFrm.timestamp', timestamps);
	envia('carSoliEntrBloqFrm');
}

function carSoliEntrBloqViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(carSoliEntrBloqList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Actualizamos la accion a view, el origen a pagina, el action a la LP de StartUp y el modo desde el cual hemos
	//ido al view
	set('carSoliEntrBloqFrm.previousAction', get('carSoliEntrBloqFrm.accion'));
	set('carSoliEntrBloqFrm.accion', 'view');
	set('carSoliEntrBloqFrm.origen', 'pagina');
	set('carSoliEntrBloqFrm.ON', 'CarSoliEntrBloqLPStartUp');
	
	//Establcemos el id del elemento seleccionado
	set('carSoliEntrBloqFrm.idSelection', carSoliEntrBloqList.codSeleccionados()[0]);
	
	//Enviamos el formualrio
	//envia('carSoliEntrBloqFrm');
	carSoliEntrBloqViewDetail(carSoliEntrBloqList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function carSoliEntrBloqViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('carSoliEntrBloqFrm.accion');
	parametros["accion"] = get('carSoliEntrBloqFrm.accion');
	parametros["origen"] = 'pagina';
	mostrarModalSICC('CarSoliEntrBloqLPStartUp', get('carSoliEntrBloqFrm.accion'), parametros, null, sizeFormView + 30);
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
	var validacion = ValidaForm('carSoliEntrBloqFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion)envia('carSoliEntrBloqFrm');
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	carSoliEntrBloqRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('carSoliEntrBloqFrm.accion');
	var origenTmp = get('carSoliEntrBloqFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(carSoliEntrBloqBuildUpdateRecordString() != carSoliEntrBloqTmpUpdateValues){
			var respuesta = cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.update.lostchanges.message'));
			if(respuesta == true){
				Guardar();
				return;
			}
		}
	
		set('carSoliEntrBloqFrm.performRequery', 'true');
		set('carSoliEntrBloqFrm.accion', 
			get('carSoliEntrBloqFrm.previousAction'));
		set('carSoliEntrBloqFrm.origen', 'menu');
		set('carSoliEntrBloqFrm.ON', 'CarSoliEntrBloqLPStartUp');
		set('carSoliEntrBloqFrm.conectorAction', 'CarSoliEntrBloqLPStartUp');
		carSoliEntrBloqFrm.oculto='N';
		envia('carSoliEntrBloqFrm');
	}else if(accionTmp == 'view'){
		window.close();
	}else Volver();
}

//Cambia el estado de las cajas de texto de los lovs del formulario
function setNonEditableElementsStatus(status){
	
}

function minimizeLayers(){
	document.all.carSoliEntrBloqListLayer.style.display='none';
	document.all.carSoliEntrBloqListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.carSoliEntrBloqListLayer.style.display='';
	document.all.carSoliEntrBloqListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda

	jsCarSoliEntrBloqPaisOidPais = get('carSoliEntrBloqFrm.paisOidPais')[0];





	jsCarSoliEntrBloqSbacOidSbac = get('carSoliEntrBloqFrm.sbacOidSbac')[0];





	jsCarSoliEntrBloqTsolOidTipoSoli = get('carSoliEntrBloqFrm.tsolOidTipoSoli')[0];





	jsCarSoliEntrBloqSocaOidSoliCabe = get('carSoliEntrBloqFrm.socaOidSoliCabe')[0];




	jsCarSoliEntrBloqFecDocu = get('carSoliEntrBloqFrm.fecDocu').toString();






	jsCarSoliEntrBloqIndNoti = get('carSoliEntrBloqFrm.indNoti').toString();






	jsCarSoliEntrBloqValMontOrde = get('carSoliEntrBloqFrm.valMontOrde').toString();






	jsCarSoliEntrBloqValMontDeudVenc = get('carSoliEntrBloqFrm.valMontDeudVenc').toString();






	jsCarSoliEntrBloqIndVali1 = get('carSoliEntrBloqFrm.indVali1').toString();






	jsCarSoliEntrBloqIndVali2 = get('carSoliEntrBloqFrm.indVali2').toString();






	jsCarSoliEntrBloqIndVali3 = get('carSoliEntrBloqFrm.indVali3').toString();






	jsCarSoliEntrBloqIndVali4 = get('carSoliEntrBloqFrm.indVali4').toString();






	jsCarSoliEntrBloqFecHoraLibe = get('carSoliEntrBloqFrm.fecHoraLibe').toString();






	jsCarSoliEntrBloqValObse = get('carSoliEntrBloqFrm.valObse').toString();







	jsCarSoliEntrBloqJeraOidJera = get('carSoliEntrBloqFrm.jeraOidJera')[0];





	jsCarSoliEntrBloqEspeOidEstaPedi = get('carSoliEntrBloqFrm.espeOidEstaPedi')[0];





	jsCarSoliEntrBloqPerdOidPeri = get('carSoliEntrBloqFrm.perdOidPeri')[0];





	jsCarSoliEntrBloqClieOidClie = get('carSoliEntrBloqFrm.clieOidClie')[0];





	jsCarSoliEntrBloqClieOidGereZona = get('carSoliEntrBloqFrm.clieOidGereZona')[0];





	jsCarSoliEntrBloqCuadOidClieUnidAdmi = get('carSoliEntrBloqFrm.cuadOidClieUnidAdmi')[0];





	jsCarSoliEntrBloqCoapOidCodiApro = get('carSoliEntrBloqFrm.coapOidCodiApro')[0];





	jsCarSoliEntrBloqEjcuOidEjecCuen = get('carSoliEntrBloqFrm.ejcuOidEjecCuen')[0];





	jsCarSoliEntrBloqEjcuOidUsuaLibe = get('carSoliEntrBloqFrm.ejcuOidUsuaLibe')[0];





	jsCarSoliEntrBloqNiriOidNiveRies = get('carSoliEntrBloqFrm.niriOidNiveRies')[0];





	jsCarSoliEntrBloqGrsoOidGrupSoli = get('carSoliEntrBloqFrm.grsoOidGrupSoli')[0];






	var parametros = "";
	parametros += jsCarSoliEntrBloqPaisOidPais + "|";



	parametros += jsCarSoliEntrBloqSbacOidSbac + "|";



	parametros += jsCarSoliEntrBloqTsolOidTipoSoli + "|";



	parametros += jsCarSoliEntrBloqSocaOidSoliCabe + "|";



	parametros += jsCarSoliEntrBloqFecDocu + "|";



	parametros += jsCarSoliEntrBloqIndNoti + "|";



	parametros += jsCarSoliEntrBloqValMontOrde + "|";



	parametros += jsCarSoliEntrBloqValMontDeudVenc + "|";



	parametros += jsCarSoliEntrBloqIndVali1 + "|";



	parametros += jsCarSoliEntrBloqIndVali2 + "|";



	parametros += jsCarSoliEntrBloqIndVali3 + "|";



	parametros += jsCarSoliEntrBloqIndVali4 + "|";



	parametros += jsCarSoliEntrBloqFecHoraLibe + "|";



	parametros += jsCarSoliEntrBloqValObse + "|";



	parametros += jsCarSoliEntrBloqJeraOidJera + "|";



	parametros += jsCarSoliEntrBloqEspeOidEstaPedi + "|";



	parametros += jsCarSoliEntrBloqPerdOidPeri + "|";



	parametros += jsCarSoliEntrBloqClieOidClie + "|";



	parametros += jsCarSoliEntrBloqClieOidGereZona + "|";



	parametros += jsCarSoliEntrBloqCuadOidClieUnidAdmi + "|";



	parametros += jsCarSoliEntrBloqCoapOidCodiApro + "|";



	parametros += jsCarSoliEntrBloqEjcuOidEjecCuen + "|";



	parametros += jsCarSoliEntrBloqEjcuOidUsuaLibe + "|";



	parametros += jsCarSoliEntrBloqNiriOidNiveRies + "|";



	parametros += jsCarSoliEntrBloqGrsoOidGrupSoli + "|";




	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function carSoliEntrBloqBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsCarSoliEntrBloqPaisOidPais + "|";
	parametros += jsCarSoliEntrBloqSbacOidSbac + "|";
	parametros += jsCarSoliEntrBloqTsolOidTipoSoli + "|";
	parametros += jsCarSoliEntrBloqSocaOidSoliCabe + "|";
	parametros += jsCarSoliEntrBloqFecDocu + "|";
	parametros += jsCarSoliEntrBloqIndNoti + "|";
	parametros += jsCarSoliEntrBloqValMontOrde + "|";
	parametros += jsCarSoliEntrBloqValMontDeudVenc + "|";
	parametros += jsCarSoliEntrBloqIndVali1 + "|";
	parametros += jsCarSoliEntrBloqIndVali2 + "|";
	parametros += jsCarSoliEntrBloqIndVali3 + "|";
	parametros += jsCarSoliEntrBloqIndVali4 + "|";
	parametros += jsCarSoliEntrBloqFecHoraLibe + "|";
	parametros += jsCarSoliEntrBloqValObse + "|";
	parametros += jsCarSoliEntrBloqJeraOidJera + "|";
	parametros += jsCarSoliEntrBloqEspeOidEstaPedi + "|";
	parametros += jsCarSoliEntrBloqPerdOidPeri + "|";
	parametros += jsCarSoliEntrBloqClieOidClie + "|";
	parametros += jsCarSoliEntrBloqClieOidGereZona + "|";
	parametros += jsCarSoliEntrBloqCuadOidClieUnidAdmi + "|";
	parametros += jsCarSoliEntrBloqCoapOidCodiApro + "|";
	parametros += jsCarSoliEntrBloqEjcuOidEjecCuen + "|";
	parametros += jsCarSoliEntrBloqEjcuOidUsuaLibe + "|";
	parametros += jsCarSoliEntrBloqNiriOidNiveRies + "|";
	parametros += jsCarSoliEntrBloqGrsoOidGrupSoli + "|";

	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carSoliEntrBloqFrm.accion'), 
		get('carSoliEntrBloqFrm.origen'));
	
	jsCarSoliEntrBloqId = get('carSoliEntrBloqFrm.id').toString();
	jsCarSoliEntrBloqPaisOidPais = get('carSoliEntrBloqFrm.paisOidPais')[0];
	jsCarSoliEntrBloqSbacOidSbac = get('carSoliEntrBloqFrm.sbacOidSbac')[0];
	jsCarSoliEntrBloqTsolOidTipoSoli = get('carSoliEntrBloqFrm.tsolOidTipoSoli')[0];
	jsCarSoliEntrBloqSocaOidSoliCabe = get('carSoliEntrBloqFrm.socaOidSoliCabe')[0];
	jsCarSoliEntrBloqFecDocu = get('carSoliEntrBloqFrm.fecDocu').toString();
	jsCarSoliEntrBloqIndNoti = get('carSoliEntrBloqFrm.indNoti').toString();
	jsCarSoliEntrBloqValMontOrde = get('carSoliEntrBloqFrm.valMontOrde').toString();
	jsCarSoliEntrBloqValMontDeudVenc = get('carSoliEntrBloqFrm.valMontDeudVenc').toString();
	jsCarSoliEntrBloqIndVali1 = get('carSoliEntrBloqFrm.indVali1').toString();
	jsCarSoliEntrBloqIndVali2 = get('carSoliEntrBloqFrm.indVali2').toString();
	jsCarSoliEntrBloqIndVali3 = get('carSoliEntrBloqFrm.indVali3').toString();
	jsCarSoliEntrBloqIndVali4 = get('carSoliEntrBloqFrm.indVali4').toString();
	jsCarSoliEntrBloqFecHoraLibe = get('carSoliEntrBloqFrm.fecHoraLibe').toString();
	jsCarSoliEntrBloqValObse = get('carSoliEntrBloqFrm.valObse').toString();
	jsCarSoliEntrBloqJeraOidJera = get('carSoliEntrBloqFrm.jeraOidJera')[0];
	jsCarSoliEntrBloqEspeOidEstaPedi = get('carSoliEntrBloqFrm.espeOidEstaPedi')[0];
	jsCarSoliEntrBloqPerdOidPeri = get('carSoliEntrBloqFrm.perdOidPeri')[0];
	jsCarSoliEntrBloqClieOidClie = get('carSoliEntrBloqFrm.clieOidClie')[0];
	jsCarSoliEntrBloqClieOidGereZona = get('carSoliEntrBloqFrm.clieOidGereZona')[0];
	jsCarSoliEntrBloqCuadOidClieUnidAdmi = get('carSoliEntrBloqFrm.cuadOidClieUnidAdmi')[0];
	jsCarSoliEntrBloqCoapOidCodiApro = get('carSoliEntrBloqFrm.coapOidCodiApro')[0];
	jsCarSoliEntrBloqEjcuOidEjecCuen = get('carSoliEntrBloqFrm.ejcuOidEjecCuen')[0];
	jsCarSoliEntrBloqEjcuOidUsuaLibe = get('carSoliEntrBloqFrm.ejcuOidUsuaLibe')[0];
	jsCarSoliEntrBloqNiriOidNiveRies = get('carSoliEntrBloqFrm.niriOidNiveRies')[0];
	jsCarSoliEntrBloqGrsoOidGrupSoli = get('carSoliEntrBloqFrm.grsoOidGrupSoli')[0];

}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('carSoliEntrBloqFrm.accion'), 
		get('carSoliEntrBloqFrm.origen'));


	set('carSoliEntrBloqFrm.id', jsCarSoliEntrBloqId);
	set('carSoliEntrBloqFrm.paisOidPais', [jsCarSoliEntrBloqPaisOidPais]);
	set('carSoliEntrBloqFrm.sbacOidSbac', [jsCarSoliEntrBloqSbacOidSbac]);
	set('carSoliEntrBloqFrm.tsolOidTipoSoli', [jsCarSoliEntrBloqTsolOidTipoSoli]);
	set('carSoliEntrBloqFrm.socaOidSoliCabe', [jsCarSoliEntrBloqSocaOidSoliCabe]);
	set('carSoliEntrBloqFrm.fecDocu', jsCarSoliEntrBloqFecDocu);
	set('carSoliEntrBloqFrm.indNoti', jsCarSoliEntrBloqIndNoti);
	set('carSoliEntrBloqFrm.valMontOrde', jsCarSoliEntrBloqValMontOrde);
	set('carSoliEntrBloqFrm.valMontDeudVenc', jsCarSoliEntrBloqValMontDeudVenc);
	set('carSoliEntrBloqFrm.indVali1', jsCarSoliEntrBloqIndVali1);
	set('carSoliEntrBloqFrm.indVali2', jsCarSoliEntrBloqIndVali2);
	set('carSoliEntrBloqFrm.indVali3', jsCarSoliEntrBloqIndVali3);
	set('carSoliEntrBloqFrm.indVali4', jsCarSoliEntrBloqIndVali4);
	set('carSoliEntrBloqFrm.fecHoraLibe', jsCarSoliEntrBloqFecHoraLibe);
	set('carSoliEntrBloqFrm.valObse', jsCarSoliEntrBloqValObse);
	set('carSoliEntrBloqFrm.jeraOidJera', [jsCarSoliEntrBloqJeraOidJera]);
	set('carSoliEntrBloqFrm.espeOidEstaPedi', [jsCarSoliEntrBloqEspeOidEstaPedi]);
	set('carSoliEntrBloqFrm.perdOidPeri', [jsCarSoliEntrBloqPerdOidPeri]);
	set('carSoliEntrBloqFrm.clieOidClie', [jsCarSoliEntrBloqClieOidClie]);
	set('carSoliEntrBloqFrm.clieOidGereZona', [jsCarSoliEntrBloqClieOidGereZona]);
	set('carSoliEntrBloqFrm.cuadOidClieUnidAdmi', [jsCarSoliEntrBloqCuadOidClieUnidAdmi]);
	set('carSoliEntrBloqFrm.coapOidCodiApro', [jsCarSoliEntrBloqCoapOidCodiApro]);
	set('carSoliEntrBloqFrm.ejcuOidEjecCuen', [jsCarSoliEntrBloqEjcuOidEjecCuen]);
	set('carSoliEntrBloqFrm.ejcuOidUsuaLibe', [jsCarSoliEntrBloqEjcuOidUsuaLibe]);
	set('carSoliEntrBloqFrm.niriOidNiveRies', [jsCarSoliEntrBloqNiriOidNiveRies]);
	set('carSoliEntrBloqFrm.grsoOidGrupSoli', [jsCarSoliEntrBloqGrsoOidGrupSoli]);

}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('carSoliEntrBloqFrm.errCodigo', errorCode);
	set('carSoliEntrBloqFrm.errDescripcion', description);
	set('carSoliEntrBloqFrm.errSeverity', severity);
	fMostrarMensajeError();
}





	
