

/*
    INDRA/CAR/mmg
    $Id: recopera.js,v 1.1 2009/12/03 19:02:03 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsRecOperaId = "";
var jsRecOperaCodOper = "";
var jsRecOperaValDescLarg = "";
var jsRecOperaIndAnul = "";
var jsRecOperaIndIngrEnvi = "";
var jsRecOperaValIngrDevu = "";
var jsRecOperaValPerd = "";
var jsRecOperaIndEspeMercFisi = "";
var jsRecOperaIndDevuFisiFact = "";
var jsRecOperaNumCampHist = "";
var jsRecOperaIndEnviGeneDevu = "";
var jsRecOperaIndDevuGeneEnvi = "";
var jsRecOperaAlmcOidAlma = "";
var jsRecOperaPeciOidPeci = "";
var jsRecOperaMensOidMens = "";
var jsRecOperaPaisOidPais = "";
var jsRecOperaTspaOidSoliPaisPerd = "";
var jsRecOperaTmalOidTipoMoviAlma = "";
var jsRecOperaMdefOidModoAbonDefe = "";
var jsRecOperaPenvOidPrecioEnvia = "";
var jsRecOperaTspaOidSoliPaisGene = "";
var jsRecOperaMoblOidMotiBloq = "";
var jsRecOperaIndFaltMerc = "";
var jsRecOperaTspaOidSoliSinStoc = "";

//Variables de paginacion, 
var recOperaPageCount = 1;

//Varible de columna que representa el campo de choice
var recOperaChoiceColumn = 22;

//Flag de siguiente pagina;
var recOperaMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var recOperaTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 987;
var sizeFormView = 977;
var sizeFormUpdate = 977;

//Ultima busqueda realizada
var recOperaLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focaliza("recOperaFrm.codOper");','focaliza("recOperaFrm.codOper");','focaliza("recOperaFrm.codOper");','focaliza("recOperaFrm.codOper");','focaliza("recOperaFrm.codOper");','focaliza("recOperaFrm.codOper");'],[3,'focaliza("recOperaFrm.valDescLarg");','focaliza("recOperaFrm.valDescLarg");','focaliza("recOperaFrm.valDescLarg");','focaliza("recOperaFrm.valDescLarg");','focaliza("recOperaFrm.valDescLarg");','focaliza("recOperaFrm.valDescLarg");'],[4,'focaliza("recOperaFrm.indAnul");','focaliza("recOperaFrm.indAnul");','focaliza("recOperaFrm.indAnul");','focaliza("recOperaFrm.indAnul");','focaliza("recOperaFrm.indAnul");','focaliza("recOperaFrm.indAnul");'],[5,'focaliza("recOperaFrm.indIngrEnvi");','focaliza("recOperaFrm.indIngrEnvi");','focaliza("recOperaFrm.indIngrEnvi");','focaliza("recOperaFrm.indIngrEnvi");','focaliza("recOperaFrm.indIngrEnvi");','focaliza("recOperaFrm.indIngrEnvi");'],[6,'focaliza("recOperaFrm.valIngrDevu");','focaliza("recOperaFrm.valIngrDevu");','focaliza("recOperaFrm.valIngrDevu");','focaliza("recOperaFrm.valIngrDevu");','focaliza("recOperaFrm.valIngrDevu");','focaliza("recOperaFrm.valIngrDevu");'],[7,'focaliza("recOperaFrm.valPerd");','focaliza("recOperaFrm.valPerd");','focaliza("recOperaFrm.valPerd");','focaliza("recOperaFrm.valPerd");','focaliza("recOperaFrm.valPerd");','focaliza("recOperaFrm.valPerd");'],[8,'focaliza("recOperaFrm.indEspeMercFisi");','focaliza("recOperaFrm.indEspeMercFisi");','focaliza("recOperaFrm.indEspeMercFisi");','focaliza("recOperaFrm.indEspeMercFisi");','focaliza("recOperaFrm.indEspeMercFisi");','focaliza("recOperaFrm.indEspeMercFisi");'],[9,'focaliza("recOperaFrm.indDevuFisiFact");','focaliza("recOperaFrm.indDevuFisiFact");','focaliza("recOperaFrm.indDevuFisiFact");','focaliza("recOperaFrm.indDevuFisiFact");','focaliza("recOperaFrm.indDevuFisiFact");','focaliza("recOperaFrm.indDevuFisiFact");'],[10,'focaliza("recOperaFrm.numCampHist");','focaliza("recOperaFrm.numCampHist");','focaliza("recOperaFrm.numCampHist");','focaliza("recOperaFrm.numCampHist");','focaliza("recOperaFrm.numCampHist");','focaliza("recOperaFrm.numCampHist");'],[11,'focaliza("recOperaFrm.indEnviGeneDevu");','focaliza("recOperaFrm.indEnviGeneDevu");','focaliza("recOperaFrm.indEnviGeneDevu");','focaliza("recOperaFrm.indEnviGeneDevu");','focaliza("recOperaFrm.indEnviGeneDevu");','focaliza("recOperaFrm.indEnviGeneDevu");'],[12,'focaliza("recOperaFrm.indDevuGeneEnvi");','focaliza("recOperaFrm.indDevuGeneEnvi");','focaliza("recOperaFrm.indDevuGeneEnvi");','focaliza("recOperaFrm.indDevuGeneEnvi");','focaliza("recOperaFrm.indDevuGeneEnvi");','focaliza("recOperaFrm.indDevuGeneEnvi");'],[13,'focalizaComboDependence("recOpera","almcOidAlma", false);','focalizaComboDependence("recOpera","almcOidAlma", false);','focalizaComboDependence("recOpera","almcOidAlma", false);','focalizaComboDependence("recOpera","almcOidAlma", true);','focalizaComboDependence("recOpera","almcOidAlma", true);','focalizaComboDependence("recOpera","almcOidAlma", true);'],[14,'focalizaComboDependence("recOpera","peciOidPeci", false);','focalizaComboDependence("recOpera","peciOidPeci", false);','focalizaComboDependence("recOpera","peciOidPeci", false);','focalizaComboDependence("recOpera","peciOidPeci", true);','focalizaComboDependence("recOpera","peciOidPeci", true);','focalizaComboDependence("recOpera","peciOidPeci", true);'],[15,'focalizaComboDependence("recOpera","mensOidMens", false);','focalizaComboDependence("recOpera","mensOidMens", false);','focalizaComboDependence("recOpera","mensOidMens", false);','focalizaComboDependence("recOpera","mensOidMens", true);','focalizaComboDependence("recOpera","mensOidMens", true);','focalizaComboDependence("recOpera","mensOidMens", true);'],[16,'','','','','',''],[17,'focalizaComboDependence("recOpera","tspaOidSoliPaisPerd", false);','focalizaComboDependence("recOpera","tspaOidSoliPaisPerd", false);','focalizaComboDependence("recOpera","tspaOidSoliPaisPerd", false);','focalizaComboDependence("recOpera","tspaOidSoliPaisPerd", true);','focalizaComboDependence("recOpera","tspaOidSoliPaisPerd", true);','focalizaComboDependence("recOpera","tspaOidSoliPaisPerd", true);'],[18,'focalizaComboDependence("recOpera","tmalOidTipoMoviAlma", false);','focalizaComboDependence("recOpera","tmalOidTipoMoviAlma", false);','focalizaComboDependence("recOpera","tmalOidTipoMoviAlma", false);','focalizaComboDependence("recOpera","tmalOidTipoMoviAlma", true);','focalizaComboDependence("recOpera","tmalOidTipoMoviAlma", true);','focalizaComboDependence("recOpera","tmalOidTipoMoviAlma", true);'],[19,'focalizaComboDependence("recOpera","mdefOidModoAbonDefe", false);','focalizaComboDependence("recOpera","mdefOidModoAbonDefe", false);','focalizaComboDependence("recOpera","mdefOidModoAbonDefe", false);','focalizaComboDependence("recOpera","mdefOidModoAbonDefe", true);','focalizaComboDependence("recOpera","mdefOidModoAbonDefe", true);','focalizaComboDependence("recOpera","mdefOidModoAbonDefe", true);'],[20,'focalizaComboDependence("recOpera","penvOidPrecioEnvia", false);','focalizaComboDependence("recOpera","penvOidPrecioEnvia", false);','focalizaComboDependence("recOpera","penvOidPrecioEnvia", false);','focalizaComboDependence("recOpera","penvOidPrecioEnvia", true);','focalizaComboDependence("recOpera","penvOidPrecioEnvia", true);','focalizaComboDependence("recOpera","penvOidPrecioEnvia", true);'],[21,'focalizaComboDependence("recOpera","tspaOidSoliPaisGene", false);','focalizaComboDependence("recOpera","tspaOidSoliPaisGene", false);','focalizaComboDependence("recOpera","tspaOidSoliPaisGene", false);','focalizaComboDependence("recOpera","tspaOidSoliPaisGene", true);','focalizaComboDependence("recOpera","tspaOidSoliPaisGene", true);','focalizaComboDependence("recOpera","tspaOidSoliPaisGene", true);'],[22,'focalizaComboDependence("recOpera","moblOidMotiBloq", false);','focalizaComboDependence("recOpera","moblOidMotiBloq", false);','focalizaComboDependence("recOpera","moblOidMotiBloq", false);','focalizaComboDependence("recOpera","moblOidMotiBloq", true);','focalizaComboDependence("recOpera","moblOidMotiBloq", true);','focalizaComboDependence("recOpera","moblOidMotiBloq", true);'],[23,'focaliza("recOperaFrm.indFaltMerc");','focaliza("recOperaFrm.indFaltMerc");','focaliza("recOperaFrm.indFaltMerc");','focaliza("recOperaFrm.indFaltMerc");','focaliza("recOperaFrm.indFaltMerc");','focaliza("recOperaFrm.indFaltMerc");'],[24,'focalizaComboDependence("recOpera","tspaOidSoliSinStoc", false);','focalizaComboDependence("recOpera","tspaOidSoliSinStoc", false);','focalizaComboDependence("recOpera","tspaOidSoliSinStoc", false);','focalizaComboDependence("recOpera","tspaOidSoliSinStoc", true);','focalizaComboDependence("recOpera","tspaOidSoliSinStoc", true);','focalizaComboDependence("recOpera","tspaOidSoliSinStoc", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focaliza("recOperaFrm.codOper");','focaliza("recOperaFrm.codOper");','focaliza("recOperaFrm.codOper");','focaliza("recOperaFrm.codOper");','focaliza("recOperaFrm.codOper");','focaliza("recOperaFrm.codOper");'],[3,'focaliza("recOperaFrm.valDescLarg");','focaliza("recOperaFrm.valDescLarg");','focaliza("recOperaFrm.valDescLarg");','focaliza("recOperaFrm.valDescLarg");','focaliza("recOperaFrm.valDescLarg");','focaliza("recOperaFrm.valDescLarg");'],[4,'focaliza("recOperaFrm.indAnul");','focaliza("recOperaFrm.indAnul");','focaliza("recOperaFrm.indAnul");','focaliza("recOperaFrm.indAnul");','focaliza("recOperaFrm.indAnul");','focaliza("recOperaFrm.indAnul");'],[5,'focaliza("recOperaFrm.indIngrEnvi");','focaliza("recOperaFrm.indIngrEnvi");','focaliza("recOperaFrm.indIngrEnvi");','focaliza("recOperaFrm.indIngrEnvi");','focaliza("recOperaFrm.indIngrEnvi");','focaliza("recOperaFrm.indIngrEnvi");'],[6,'focaliza("recOperaFrm.valIngrDevu");','focaliza("recOperaFrm.valIngrDevu");','focaliza("recOperaFrm.valIngrDevu");','focaliza("recOperaFrm.valIngrDevu");','focaliza("recOperaFrm.valIngrDevu");','focaliza("recOperaFrm.valIngrDevu");'],[7,'focaliza("recOperaFrm.valPerd");','focaliza("recOperaFrm.valPerd");','focaliza("recOperaFrm.valPerd");','focaliza("recOperaFrm.valPerd");','focaliza("recOperaFrm.valPerd");','focaliza("recOperaFrm.valPerd");'],[8,'focaliza("recOperaFrm.indEspeMercFisi");','focaliza("recOperaFrm.indEspeMercFisi");','focaliza("recOperaFrm.indEspeMercFisi");','focaliza("recOperaFrm.indEspeMercFisi");','focaliza("recOperaFrm.indEspeMercFisi");','focaliza("recOperaFrm.indEspeMercFisi");'],[9,'focaliza("recOperaFrm.indDevuFisiFact");','focaliza("recOperaFrm.indDevuFisiFact");','focaliza("recOperaFrm.indDevuFisiFact");','focaliza("recOperaFrm.indDevuFisiFact");','focaliza("recOperaFrm.indDevuFisiFact");','focaliza("recOperaFrm.indDevuFisiFact");'],[10,'focaliza("recOperaFrm.numCampHist");','focaliza("recOperaFrm.numCampHist");','focaliza("recOperaFrm.numCampHist");','focaliza("recOperaFrm.numCampHist");','focaliza("recOperaFrm.numCampHist");','focaliza("recOperaFrm.numCampHist");'],[11,'focaliza("recOperaFrm.indEnviGeneDevu");','focaliza("recOperaFrm.indEnviGeneDevu");','focaliza("recOperaFrm.indEnviGeneDevu");','focaliza("recOperaFrm.indEnviGeneDevu");','focaliza("recOperaFrm.indEnviGeneDevu");','focaliza("recOperaFrm.indEnviGeneDevu");'],[12,'focaliza("recOperaFrm.indDevuGeneEnvi");','focaliza("recOperaFrm.indDevuGeneEnvi");','focaliza("recOperaFrm.indDevuGeneEnvi");','focaliza("recOperaFrm.indDevuGeneEnvi");','focaliza("recOperaFrm.indDevuGeneEnvi");','focaliza("recOperaFrm.indDevuGeneEnvi");'],[13,'focalizaComboDependence("recOpera","almcOidAlma", false);','focalizaComboDependence("recOpera","almcOidAlma", false);','focalizaComboDependence("recOpera","almcOidAlma", false);','focalizaComboDependence("recOpera","almcOidAlma", true);','focalizaComboDependence("recOpera","almcOidAlma", true);','focalizaComboDependence("recOpera","almcOidAlma", true);'],[14,'focalizaComboDependence("recOpera","peciOidPeci", false);','focalizaComboDependence("recOpera","peciOidPeci", false);','focalizaComboDependence("recOpera","peciOidPeci", false);','focalizaComboDependence("recOpera","peciOidPeci", true);','focalizaComboDependence("recOpera","peciOidPeci", true);','focalizaComboDependence("recOpera","peciOidPeci", true);'],[15,'focalizaComboDependence("recOpera","mensOidMens", false);','focalizaComboDependence("recOpera","mensOidMens", false);','focalizaComboDependence("recOpera","mensOidMens", false);','focalizaComboDependence("recOpera","mensOidMens", true);','focalizaComboDependence("recOpera","mensOidMens", true);','focalizaComboDependence("recOpera","mensOidMens", true);'],[16,'','','','','',''],[17,'focalizaComboDependence("recOpera","tspaOidSoliPaisPerd", false);','focalizaComboDependence("recOpera","tspaOidSoliPaisPerd", false);','focalizaComboDependence("recOpera","tspaOidSoliPaisPerd", false);','focalizaComboDependence("recOpera","tspaOidSoliPaisPerd", true);','focalizaComboDependence("recOpera","tspaOidSoliPaisPerd", true);','focalizaComboDependence("recOpera","tspaOidSoliPaisPerd", true);'],[18,'focalizaComboDependence("recOpera","tmalOidTipoMoviAlma", false);','focalizaComboDependence("recOpera","tmalOidTipoMoviAlma", false);','focalizaComboDependence("recOpera","tmalOidTipoMoviAlma", false);','focalizaComboDependence("recOpera","tmalOidTipoMoviAlma", true);','focalizaComboDependence("recOpera","tmalOidTipoMoviAlma", true);','focalizaComboDependence("recOpera","tmalOidTipoMoviAlma", true);'],[19,'focalizaComboDependence("recOpera","mdefOidModoAbonDefe", false);','focalizaComboDependence("recOpera","mdefOidModoAbonDefe", false);','focalizaComboDependence("recOpera","mdefOidModoAbonDefe", false);','focalizaComboDependence("recOpera","mdefOidModoAbonDefe", true);','focalizaComboDependence("recOpera","mdefOidModoAbonDefe", true);','focalizaComboDependence("recOpera","mdefOidModoAbonDefe", true);'],[20,'focalizaComboDependence("recOpera","penvOidPrecioEnvia", false);','focalizaComboDependence("recOpera","penvOidPrecioEnvia", false);','focalizaComboDependence("recOpera","penvOidPrecioEnvia", false);','focalizaComboDependence("recOpera","penvOidPrecioEnvia", true);','focalizaComboDependence("recOpera","penvOidPrecioEnvia", true);','focalizaComboDependence("recOpera","penvOidPrecioEnvia", true);'],[21,'focalizaComboDependence("recOpera","tspaOidSoliPaisGene", false);','focalizaComboDependence("recOpera","tspaOidSoliPaisGene", false);','focalizaComboDependence("recOpera","tspaOidSoliPaisGene", false);','focalizaComboDependence("recOpera","tspaOidSoliPaisGene", true);','focalizaComboDependence("recOpera","tspaOidSoliPaisGene", true);','focalizaComboDependence("recOpera","tspaOidSoliPaisGene", true);'],[22,'focalizaComboDependence("recOpera","moblOidMotiBloq", false);','focalizaComboDependence("recOpera","moblOidMotiBloq", false);','focalizaComboDependence("recOpera","moblOidMotiBloq", false);','focalizaComboDependence("recOpera","moblOidMotiBloq", true);','focalizaComboDependence("recOpera","moblOidMotiBloq", true);','focalizaComboDependence("recOpera","moblOidMotiBloq", true);'],[23,'focaliza("recOperaFrm.indFaltMerc");','focaliza("recOperaFrm.indFaltMerc");','focaliza("recOperaFrm.indFaltMerc");','focaliza("recOperaFrm.indFaltMerc");','focaliza("recOperaFrm.indFaltMerc");','focaliza("recOperaFrm.indFaltMerc");'],[24,'focalizaComboDependence("recOpera","tspaOidSoliSinStoc", false);','focalizaComboDependence("recOpera","tspaOidSoliSinStoc", false);','focalizaComboDependence("recOpera","tspaOidSoliSinStoc", false);','focalizaComboDependence("recOpera","tspaOidSoliSinStoc", true);','focalizaComboDependence("recOpera","tspaOidSoliSinStoc", true);','focalizaComboDependence("recOpera","tspaOidSoliSinStoc", true);']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
var almcOidAlmaDependeceMap = new Vector();
almcOidAlmaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
almcOidAlmaDependeceMap.agregar(['almcOidAlma', padresTmp, '', 'BelAlmac']);
var peciOidPeciDependeceMap = new Vector();
peciOidPeciDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
peciOidPeciDependeceMap.agregar(['peciOidPeci', padresTmp, '', 'RecPreci']);
var mensOidMensDependeceMap = new Vector();
mensOidMensDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
mensOidMensDependeceMap.agregar(['mensOidMens', padresTmp, '', 'MsgMensa']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);
var tspaOidSoliPaisPerdDependeceMap = new Vector();
tspaOidSoliPaisPerdDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tspaOidSoliPaisPerdDependeceMap.agregar(['tspaOidSoliPaisPerd', padresTmp, '', 'PedTipoSolicPais']);
var tmalOidTipoMoviAlmaDependeceMap = new Vector();
tmalOidTipoMoviAlmaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmalOidTipoMoviAlmaDependeceMap.agregar(['tmalOidTipoMoviAlma', padresTmp, '', 'BelTipoMovimAlmac']);
var mdefOidModoAbonDefeDependeceMap = new Vector();
mdefOidModoAbonDefeDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
mdefOidModoAbonDefeDependeceMap.agregar(['mdefOidModoAbonDefe', padresTmp, '', 'RecModoAbonoDefec']);
var penvOidPrecioEnviaDependeceMap = new Vector();
penvOidPrecioEnviaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
penvOidPrecioEnviaDependeceMap.agregar(['penvOidPrecioEnvia', padresTmp, '', 'RecPreciEnvia']);
var tspaOidSoliPaisGeneDependeceMap = new Vector();
tspaOidSoliPaisGeneDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tspaOidSoliPaisGeneDependeceMap.agregar(['tspaOidSoliPaisGene', padresTmp, '', 'PedTipoSolicPais']);
var moblOidMotiBloqDependeceMap = new Vector();
moblOidMotiBloqDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
moblOidMotiBloqDependeceMap.agregar(['moblOidMotiBloq', padresTmp, '', 'RecMotivBloqu']);
var tspaOidSoliSinStocDependeceMap = new Vector();
tspaOidSoliSinStocDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tspaOidSoliSinStocDependeceMap.agregar(['tspaOidSoliSinStoc', padresTmp, '', 'PedTipoSolicPais']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
recOperaLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var recOperaTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function recOperaInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('recOperaFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('recOperaFrm.accion')){
		case "query": recOperaQueryInitComponents(); break;
		case "view": recOperaViewInitComponents(); break;
		case "create": recOperaCreateInitComponents(); break;
		case "update": recOperaUpdateInitComponents(); break;
		case "remove": recOperaRemoveInitComponents(); break;
		case "lov": recOperaLovInitComponents(); break;
	}
	//alert('accion :' + get('recOperaFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('recOperaFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('recOpera')) recOperaCmdRequery();
}

function recOperaQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('recOperaFrm', true);	
}

function recOperaViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('recOperaFrm', true);
}

function recOperaCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('recOperaFrm.codOper','S', GestionarMensaje('RecOpera.codOper.requiered.message'));
	
	setMV('recOperaFrm.valDescLarg','S', GestionarMensaje('RecOpera.valDescLarg.requiered.message'));
	
	setMV('recOperaFrm.indAnul','S', GestionarMensaje('RecOpera.indAnul.requiered.message'));
	
	setMV('recOperaFrm.peciOidPeci','S', GestionarMensaje('RecOpera.peciOidPeci.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('recOperaFrm', true);
}

function recOperaUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('recOperaFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		recOperaTmpUpdateValues = recOperaBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('recOperaFrm.codOper','S', GestionarMensaje('RecOpera.codOper.requiered.message'));
		setMV('recOperaFrm.valDescLarg','S', GestionarMensaje('RecOpera.valDescLarg.requiered.message'));
		setMV('recOperaFrm.indAnul','S', GestionarMensaje('RecOpera.indAnul.requiered.message'));
		setMV('recOperaFrm.peciOidPeci','S', GestionarMensaje('RecOpera.peciOidPeci.requiered.message'));
		
			focusFirstFieldModify('recOperaFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('recOperaFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('recOperaFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function recOperaRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	recOperaList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('recOperaFrm', true);
}

function recOperaLovInitComponents(){
	recOperaLovReturnParameters = window.dialogArguments;
	
	focusFirstField('recOperaFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad


























//Función que permite cargar los datos de un elemento de lov seleccionado
function recOperaSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('recOperaFrm.' + campo, id);
	set('recOperaFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function recOperaLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	recOperaLovReturnParameters.id = '';
	recOperaLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function recOperaLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recOperaList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = recOperaList.codSeleccionados();
	var descripcion = recOperaList.extraeDato(
		recOperaList.codSeleccionados()[0], recOperaChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	recOperaLovReturnParameters.id = codigo;
	recOperaLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function recOperaCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('recOperaFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('recOperaFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "recOperaList", "RecOperaConectorTransactionQuery", 
		"result_ROWSET", parametros, "recOperaPostQueryActions(datos);"]], "", "");	
}

function recOperaCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('recOperaFrm.lastQueryToSession'));
	var i =0;
	set('recOperaFrm.codOper', paramsRequery.ij(i++));
	
	set('recOperaFrm.valDescLarg', paramsRequery.ij(i++));
	
	set('recOperaFrm.indAnul', paramsRequery.ij(i++));
	
	set('recOperaFrm.indIngrEnvi', paramsRequery.ij(i++));
	
	set('recOperaFrm.valIngrDevu', paramsRequery.ij(i++));
	
	set('recOperaFrm.valPerd', paramsRequery.ij(i++));
	
	set('recOperaFrm.indEspeMercFisi', paramsRequery.ij(i++));
	
	set('recOperaFrm.indDevuFisiFact', paramsRequery.ij(i++));
	
	set('recOperaFrm.numCampHist', paramsRequery.ij(i++));
	
	set('recOperaFrm.indEnviGeneDevu', paramsRequery.ij(i++));
	
	set('recOperaFrm.indDevuGeneEnvi', paramsRequery.ij(i++));
	
	set('recOperaFrm.almcOidAlma', [paramsRequery.ij(i++)]);
	
	set('recOperaFrm.peciOidPeci', [paramsRequery.ij(i++)]);
	
	set('recOperaFrm.mensOidMens', [paramsRequery.ij(i++)]);
	
	set('recOperaFrm.tspaOidSoliPaisPerd', [paramsRequery.ij(i++)]);
	
	set('recOperaFrm.tmalOidTipoMoviAlma', [paramsRequery.ij(i++)]);
	
	set('recOperaFrm.mdefOidModoAbonDefe', [paramsRequery.ij(i++)]);
	
	set('recOperaFrm.penvOidPrecioEnvia', [paramsRequery.ij(i++)]);
	
	set('recOperaFrm.tspaOidSoliPaisGene', [paramsRequery.ij(i++)]);
	
	set('recOperaFrm.moblOidMotiBloq', [paramsRequery.ij(i++)]);
	
	set('recOperaFrm.indFaltMerc', paramsRequery.ij(i++));
	
	set('recOperaFrm.tspaOidSoliSinStoc', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	recOperaPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	recOperaCmdQuery(recOperaPageCount);
}

function recOperaFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	recOperaPageCount = 1;
	recOperaCmdQuery(recOperaPageCount);
}

function recOperaPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != recOperaLastQuery){
		recOperaFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	recOperaPageCount--;
	recOperaCmdQuery(recOperaPageCount);
}

function recOperaNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != recOperaLastQuery){
		recOperaFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	recOperaPageCount++;
	recOperaCmdQuery(recOperaPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function recOperaPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('recOperaListLayer', 'O');
		visibilidad('recOperaListButtonsLayer', 'O');
		if(get('recOperaFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	recOperaLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:recOperaViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, recOperaChoiceColumn) + "</A>",
			i, recOperaChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	recOperaList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	recOperaTimeStamps = datosTmp.filtrar([23],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		recOperaMorePagesFlag = true;
		recOperaList.eliminar(mmgPageSize, 1);
	}else{
		recOperaMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('recOperaFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('recOperaListLayer', 'V');
	visibilidad('recOperaListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('recOperaList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	recOperaList.display();
	
	//Actualizamos el estado de los botones 
	if(recOperaMorePagesFlag){
		set_estado_botonera('recOperaPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('recOperaPaginationButtonBar',
			3,"inactivo");
	}
	if(recOperaPageCount > 1){
		set_estado_botonera('recOperaPaginationButtonBar',
			2,"activo");
		set_estado_botonera('recOperaPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('recOperaPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('recOperaPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function recOperaUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recOperaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('recOperaFrm.idSelection', recOperaList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('recOperaFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = recOperaList.codSeleccionados()[0];
		parametros["previousAction"] = get('recOperaFrm.accion');
		parametros["accion"] = get('recOperaFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('RecOperaLPStartUp', get('recOperaFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) recOperaCmdRequery();
	}
}

function recOperaRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recOperaList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = recOperaList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('recOperaFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(recOperaList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += recOperaTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('recOperaFrm.timestamp', timestamps);


	recOperaFrm.oculto='S';
	envia('recOperaFrm');
	recOperaFrm.oculto='N';
}

function recOperaViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(recOperaList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	recOperaViewDetail(recOperaList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function recOperaViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('recOperaFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('RecOperaLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('recOperaFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		recOperaFrm.oculto='S';
		envia('recOperaFrm');
		recOperaFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('recOperaFrm.almcOidAlma').toString() == ''){
		set('recOperaFrm.almcOidAlma', []);
		mmgResetCombosOnCascade('almcOidAlma', 'almcOidAlma', 'recOpera');
		
	}
	if(get('recOperaFrm.peciOidPeci').toString() == ''){
		set('recOperaFrm.peciOidPeci', []);
		mmgResetCombosOnCascade('peciOidPeci', 'peciOidPeci', 'recOpera');
		
	}
	if(get('recOperaFrm.mensOidMens').toString() == ''){
		set('recOperaFrm.mensOidMens', []);
		mmgResetCombosOnCascade('mensOidMens', 'mensOidMens', 'recOpera');
		
	}
	if(get('recOperaFrm.paisOidPais').toString() == ''){
		set('recOperaFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'recOpera');
		
	}
	if(get('recOperaFrm.tspaOidSoliPaisPerd').toString() == ''){
		set('recOperaFrm.tspaOidSoliPaisPerd', []);
		mmgResetCombosOnCascade('tspaOidSoliPaisPerd', 'tspaOidSoliPaisPerd', 'recOpera');
		
	}
	if(get('recOperaFrm.tmalOidTipoMoviAlma').toString() == ''){
		set('recOperaFrm.tmalOidTipoMoviAlma', []);
		mmgResetCombosOnCascade('tmalOidTipoMoviAlma', 'tmalOidTipoMoviAlma', 'recOpera');
		
	}
	if(get('recOperaFrm.mdefOidModoAbonDefe').toString() == ''){
		set('recOperaFrm.mdefOidModoAbonDefe', []);
		mmgResetCombosOnCascade('mdefOidModoAbonDefe', 'mdefOidModoAbonDefe', 'recOpera');
		
	}
	if(get('recOperaFrm.penvOidPrecioEnvia').toString() == ''){
		set('recOperaFrm.penvOidPrecioEnvia', []);
		mmgResetCombosOnCascade('penvOidPrecioEnvia', 'penvOidPrecioEnvia', 'recOpera');
		
	}
	if(get('recOperaFrm.tspaOidSoliPaisGene').toString() == ''){
		set('recOperaFrm.tspaOidSoliPaisGene', []);
		mmgResetCombosOnCascade('tspaOidSoliPaisGene', 'tspaOidSoliPaisGene', 'recOpera');
		
	}
	if(get('recOperaFrm.moblOidMotiBloq').toString() == ''){
		set('recOperaFrm.moblOidMotiBloq', []);
		mmgResetCombosOnCascade('moblOidMotiBloq', 'moblOidMotiBloq', 'recOpera');
		
	}
	if(get('recOperaFrm.tspaOidSoliSinStoc').toString() == ''){
		set('recOperaFrm.tspaOidSoliSinStoc', []);
		mmgResetCombosOnCascade('tspaOidSoliSinStoc', 'tspaOidSoliSinStoc', 'recOpera');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	recOperaRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('recOperaFrm.accion');
	var origenTmp = get('recOperaFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(recOperaBuildUpdateRecordString() != recOperaTmpUpdateValues){
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
	document.all.recOperaListLayer.style.display='none';
	document.all.recOperaListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.recOperaListLayer.style.display='';
	document.all.recOperaListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsRecOperaCodOper = get('recOperaFrm.codOper').toString();
	jsRecOperaValDescLarg = get('recOperaFrm.valDescLarg').toString();
	jsRecOperaIndAnul = get('recOperaFrm.indAnul').toString();
	jsRecOperaIndIngrEnvi = get('recOperaFrm.indIngrEnvi').toString();
	jsRecOperaValIngrDevu = get('recOperaFrm.valIngrDevu').toString();
	jsRecOperaValPerd = get('recOperaFrm.valPerd').toString();
	jsRecOperaIndEspeMercFisi = get('recOperaFrm.indEspeMercFisi').toString();
	jsRecOperaIndDevuFisiFact = get('recOperaFrm.indDevuFisiFact').toString();
	jsRecOperaNumCampHist = get('recOperaFrm.numCampHist').toString();
	jsRecOperaIndEnviGeneDevu = get('recOperaFrm.indEnviGeneDevu').toString();
	jsRecOperaIndDevuGeneEnvi = get('recOperaFrm.indDevuGeneEnvi').toString();
	jsRecOperaAlmcOidAlma = get('recOperaFrm.almcOidAlma')[0];
	jsRecOperaPeciOidPeci = get('recOperaFrm.peciOidPeci')[0];
	jsRecOperaMensOidMens = get('recOperaFrm.mensOidMens')[0];
	jsRecOperaTspaOidSoliPaisPerd = get('recOperaFrm.tspaOidSoliPaisPerd')[0];
	jsRecOperaTmalOidTipoMoviAlma = get('recOperaFrm.tmalOidTipoMoviAlma')[0];
	jsRecOperaMdefOidModoAbonDefe = get('recOperaFrm.mdefOidModoAbonDefe')[0];
	jsRecOperaPenvOidPrecioEnvia = get('recOperaFrm.penvOidPrecioEnvia')[0];
	jsRecOperaTspaOidSoliPaisGene = get('recOperaFrm.tspaOidSoliPaisGene')[0];
	jsRecOperaMoblOidMotiBloq = get('recOperaFrm.moblOidMotiBloq')[0];
	jsRecOperaIndFaltMerc = get('recOperaFrm.indFaltMerc').toString();
	jsRecOperaTspaOidSoliSinStoc = get('recOperaFrm.tspaOidSoliSinStoc')[0];
	
	
	var parametros = "";
	parametros += jsRecOperaCodOper + "|";
	parametros += jsRecOperaValDescLarg + "|";
	parametros += jsRecOperaIndAnul + "|";
	parametros += jsRecOperaIndIngrEnvi + "|";
	parametros += jsRecOperaValIngrDevu + "|";
	parametros += jsRecOperaValPerd + "|";
	parametros += jsRecOperaIndEspeMercFisi + "|";
	parametros += jsRecOperaIndDevuFisiFact + "|";
	parametros += jsRecOperaNumCampHist + "|";
	parametros += jsRecOperaIndEnviGeneDevu + "|";
	parametros += jsRecOperaIndDevuGeneEnvi + "|";
	parametros += jsRecOperaAlmcOidAlma + "|";
	parametros += jsRecOperaPeciOidPeci + "|";
	parametros += jsRecOperaMensOidMens + "|";
	parametros += jsRecOperaTspaOidSoliPaisPerd + "|";
	parametros += jsRecOperaTmalOidTipoMoviAlma + "|";
	parametros += jsRecOperaMdefOidModoAbonDefe + "|";
	parametros += jsRecOperaPenvOidPrecioEnvia + "|";
	parametros += jsRecOperaTspaOidSoliPaisGene + "|";
	parametros += jsRecOperaMoblOidMotiBloq + "|";
	parametros += jsRecOperaIndFaltMerc + "|";
	parametros += jsRecOperaTspaOidSoliSinStoc + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function recOperaBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsRecOperaCodOper + "|";
	parametros += jsRecOperaValDescLarg + "|";
	parametros += jsRecOperaIndAnul + "|";
	parametros += jsRecOperaIndIngrEnvi + "|";
	parametros += jsRecOperaValIngrDevu + "|";
	parametros += jsRecOperaValPerd + "|";
	parametros += jsRecOperaIndEspeMercFisi + "|";
	parametros += jsRecOperaIndDevuFisiFact + "|";
	parametros += jsRecOperaNumCampHist + "|";
	parametros += jsRecOperaIndEnviGeneDevu + "|";
	parametros += jsRecOperaIndDevuGeneEnvi + "|";
	parametros += jsRecOperaAlmcOidAlma + "|";
	parametros += jsRecOperaPeciOidPeci + "|";
	parametros += jsRecOperaMensOidMens + "|";
	parametros += jsRecOperaTspaOidSoliPaisPerd + "|";
	parametros += jsRecOperaTmalOidTipoMoviAlma + "|";
	parametros += jsRecOperaMdefOidModoAbonDefe + "|";
	parametros += jsRecOperaPenvOidPrecioEnvia + "|";
	parametros += jsRecOperaTspaOidSoliPaisGene + "|";
	parametros += jsRecOperaMoblOidMotiBloq + "|";
	parametros += jsRecOperaIndFaltMerc + "|";
	parametros += jsRecOperaTspaOidSoliSinStoc + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('recOperaFrm.accion'), 
		get('recOperaFrm.origen'));
	
	jsRecOperaId = get('recOperaFrm.id').toString();
	jsRecOperaCodOper = get('recOperaFrm.codOper').toString();
	jsRecOperaValDescLarg = get('recOperaFrm.valDescLarg').toString();
	jsRecOperaIndAnul = get('recOperaFrm.indAnul').toString();
	jsRecOperaIndIngrEnvi = get('recOperaFrm.indIngrEnvi').toString();
	jsRecOperaValIngrDevu = get('recOperaFrm.valIngrDevu').toString();
	jsRecOperaValPerd = get('recOperaFrm.valPerd').toString();
	jsRecOperaIndEspeMercFisi = get('recOperaFrm.indEspeMercFisi').toString();
	jsRecOperaIndDevuFisiFact = get('recOperaFrm.indDevuFisiFact').toString();
	jsRecOperaNumCampHist = get('recOperaFrm.numCampHist').toString();
	jsRecOperaIndEnviGeneDevu = get('recOperaFrm.indEnviGeneDevu').toString();
	jsRecOperaIndDevuGeneEnvi = get('recOperaFrm.indDevuGeneEnvi').toString();
	jsRecOperaAlmcOidAlma = get('recOperaFrm.almcOidAlma')[0];
	jsRecOperaPeciOidPeci = get('recOperaFrm.peciOidPeci')[0];
	jsRecOperaMensOidMens = get('recOperaFrm.mensOidMens')[0];
	jsRecOperaPaisOidPais = get('recOperaFrm.paisOidPais')[0];
	jsRecOperaTspaOidSoliPaisPerd = get('recOperaFrm.tspaOidSoliPaisPerd')[0];
	jsRecOperaTmalOidTipoMoviAlma = get('recOperaFrm.tmalOidTipoMoviAlma')[0];
	jsRecOperaMdefOidModoAbonDefe = get('recOperaFrm.mdefOidModoAbonDefe')[0];
	jsRecOperaPenvOidPrecioEnvia = get('recOperaFrm.penvOidPrecioEnvia')[0];
	jsRecOperaTspaOidSoliPaisGene = get('recOperaFrm.tspaOidSoliPaisGene')[0];
	jsRecOperaMoblOidMotiBloq = get('recOperaFrm.moblOidMotiBloq')[0];
	jsRecOperaIndFaltMerc = get('recOperaFrm.indFaltMerc').toString();
	jsRecOperaTspaOidSoliSinStoc = get('recOperaFrm.tspaOidSoliSinStoc')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('recOperaFrm.accion'), 
		get('recOperaFrm.origen'));


	set('recOperaFrm.id', jsRecOperaId);
	set('recOperaFrm.codOper', jsRecOperaCodOper);
	set('recOperaFrm.valDescLarg', jsRecOperaValDescLarg);
	set('recOperaFrm.indAnul', jsRecOperaIndAnul);
	set('recOperaFrm.indIngrEnvi', jsRecOperaIndIngrEnvi);
	set('recOperaFrm.valIngrDevu', jsRecOperaValIngrDevu);
	set('recOperaFrm.valPerd', jsRecOperaValPerd);
	set('recOperaFrm.indEspeMercFisi', jsRecOperaIndEspeMercFisi);
	set('recOperaFrm.indDevuFisiFact', jsRecOperaIndDevuFisiFact);
	set('recOperaFrm.numCampHist', jsRecOperaNumCampHist);
	set('recOperaFrm.indEnviGeneDevu', jsRecOperaIndEnviGeneDevu);
	set('recOperaFrm.indDevuGeneEnvi', jsRecOperaIndDevuGeneEnvi);
	set('recOperaFrm.almcOidAlma', [jsRecOperaAlmcOidAlma]);
	set('recOperaFrm.peciOidPeci', [jsRecOperaPeciOidPeci]);
	set('recOperaFrm.mensOidMens', [jsRecOperaMensOidMens]);
	set('recOperaFrm.paisOidPais', [jsRecOperaPaisOidPais]);
	set('recOperaFrm.tspaOidSoliPaisPerd', [jsRecOperaTspaOidSoliPaisPerd]);
	set('recOperaFrm.tmalOidTipoMoviAlma', [jsRecOperaTmalOidTipoMoviAlma]);
	set('recOperaFrm.mdefOidModoAbonDefe', [jsRecOperaMdefOidModoAbonDefe]);
	set('recOperaFrm.penvOidPrecioEnvia', [jsRecOperaPenvOidPrecioEnvia]);
	set('recOperaFrm.tspaOidSoliPaisGene', [jsRecOperaTspaOidSoliPaisGene]);
	set('recOperaFrm.moblOidMotiBloq', [jsRecOperaMoblOidMotiBloq]);
	set('recOperaFrm.indFaltMerc', jsRecOperaIndFaltMerc);
	set('recOperaFrm.tspaOidSoliSinStoc', [jsRecOperaTspaOidSoliSinStoc]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsRecOperaCodOper = '';
	jsRecOperaValDescLarg = '';
	jsRecOperaIndAnul = '';
	jsRecOperaIndIngrEnvi = '';
	jsRecOperaValIngrDevu = '';
	jsRecOperaValPerd = '';
	jsRecOperaIndEspeMercFisi = '';
	jsRecOperaIndDevuFisiFact = '';
	jsRecOperaNumCampHist = '';
	jsRecOperaIndEnviGeneDevu = '';
	jsRecOperaIndDevuGeneEnvi = '';
	jsRecOperaAlmcOidAlma = '';
	jsRecOperaPeciOidPeci = '';
	jsRecOperaMensOidMens = '';
	jsRecOperaTspaOidSoliPaisPerd = '';
	jsRecOperaTmalOidTipoMoviAlma = '';
	jsRecOperaMdefOidModoAbonDefe = '';
	jsRecOperaPenvOidPrecioEnvia = '';
	jsRecOperaTspaOidSoliPaisGene = '';
	jsRecOperaMoblOidMotiBloq = '';
	jsRecOperaIndFaltMerc = '';
	jsRecOperaTspaOidSoliSinStoc = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('recOperaFrm.errCodigo', errorCode);
	set('recOperaFrm.errDescripcion', description);
	set('recOperaFrm.errSeverity', severity);
	fMostrarMensajeError();
}
