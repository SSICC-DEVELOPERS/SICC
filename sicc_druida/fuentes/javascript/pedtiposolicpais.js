

/*
    INDRA/CAR/mmg
    $Id: pedtiposolicpais.js,v 1.1 2009/12/03 19:01:33 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsPedTipoSolicPaisId = "";
var jsPedTipoSolicPaisPaisOidPais = "";
var jsPedTipoSolicPaisTsolOidTipoSoli = "";
var jsPedTipoSolicPaisNumSoliLote = "";
var jsPedTipoSolicPaisNumUnidAlar = "";
var jsPedTipoSolicPaisFopaOidFormPago = "";
var jsPedTipoSolicPaisIndSujeFlet = "";
var jsPedTipoSolicPaisIndReseStoc = "";
var jsPedTipoSolicPaisIndPermReve = "";
var jsPedTipoSolicPaisIndPediPrue = "";
var jsPedTipoSolicPaisIndComi = "";
var jsPedTipoSolicPaisIndVentInteSab14 = "";
var jsPedTipoSolicPaisCactOidActi = "";
var jsPedTipoSolicPaisMoneOidMone = "";
var jsPedTipoSolicPaisTmalOidTipoMoviAsig = "";
var jsPedTipoSolicPaisTmalOidTipoMoviRese = "";
var jsPedTipoSolicPaisTmalOidTipoMoviFact = "";
var jsPedTipoSolicPaisTidoOidTipoDocu = "";
var jsPedTipoSolicPaisIndPermUnio = "";
var jsPedTipoSolicPaisIndPediGtZona = "";
var jsPedTipoSolicPaisIndCambVentBel = "";
var jsPedTipoSolicPaisAlmcOidAlma = "";
var jsPedTipoSolicPaisSociOidSoci = "";
var jsPedTipoSolicPaisValGlos = "";
var jsPedTipoSolicPaisTsolOidTipoCons = "";

//Variables de paginacion, 
var pedTipoSolicPaisPageCount = 1;

//Varible de columna que representa el campo de choice
var pedTipoSolicPaisChoiceColumn = 23;

//Flag de siguiente pagina;
var pedTipoSolicPaisMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var pedTipoSolicPaisTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 1029;
var sizeFormView = 1007;
var sizeFormUpdate = 1007;

//Ultima busqueda realizada
var pedTipoSolicPaisLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'','','','','',''],[3,'focalizaComboDependence("pedTipoSolicPais","tsolOidTipoSoli", false);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoSoli", false);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoSoli", false);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoSoli", true);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoSoli", true);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoSoli", true);'],[4,'focaliza("pedTipoSolicPaisFrm.numSoliLote");','focaliza("pedTipoSolicPaisFrm.numSoliLote");','focaliza("pedTipoSolicPaisFrm.numSoliLote");','focaliza("pedTipoSolicPaisFrm.numSoliLote");','focaliza("pedTipoSolicPaisFrm.numSoliLote");','focaliza("pedTipoSolicPaisFrm.numSoliLote");'],[5,'focaliza("pedTipoSolicPaisFrm.numUnidAlar");','focaliza("pedTipoSolicPaisFrm.numUnidAlar");','focaliza("pedTipoSolicPaisFrm.numUnidAlar");','focaliza("pedTipoSolicPaisFrm.numUnidAlar");','focaliza("pedTipoSolicPaisFrm.numUnidAlar");','focaliza("pedTipoSolicPaisFrm.numUnidAlar");'],[6,'focalizaComboDependence("pedTipoSolicPais","fopaOidFormPago", false);','focalizaComboDependence("pedTipoSolicPais","fopaOidFormPago", false);','focalizaComboDependence("pedTipoSolicPais","fopaOidFormPago", false);','focalizaComboDependence("pedTipoSolicPais","fopaOidFormPago", true);','focalizaComboDependence("pedTipoSolicPais","fopaOidFormPago", true);','focalizaComboDependence("pedTipoSolicPais","fopaOidFormPago", true);'],[7,'focaliza("pedTipoSolicPaisFrm.indSujeFlet");','focaliza("pedTipoSolicPaisFrm.indSujeFlet");','focaliza("pedTipoSolicPaisFrm.indSujeFlet");','focaliza("pedTipoSolicPaisFrm.indSujeFlet");','focaliza("pedTipoSolicPaisFrm.indSujeFlet");','focaliza("pedTipoSolicPaisFrm.indSujeFlet");'],[8,'focaliza("pedTipoSolicPaisFrm.indReseStoc");','focaliza("pedTipoSolicPaisFrm.indReseStoc");','focaliza("pedTipoSolicPaisFrm.indReseStoc");','focaliza("pedTipoSolicPaisFrm.indReseStoc");','focaliza("pedTipoSolicPaisFrm.indReseStoc");','focaliza("pedTipoSolicPaisFrm.indReseStoc");'],[9,'focaliza("pedTipoSolicPaisFrm.indPermReve");','focaliza("pedTipoSolicPaisFrm.indPermReve");','focaliza("pedTipoSolicPaisFrm.indPermReve");','focaliza("pedTipoSolicPaisFrm.indPermReve");','focaliza("pedTipoSolicPaisFrm.indPermReve");','focaliza("pedTipoSolicPaisFrm.indPermReve");'],[10,'focaliza("pedTipoSolicPaisFrm.indPediPrue");','focaliza("pedTipoSolicPaisFrm.indPediPrue");','focaliza("pedTipoSolicPaisFrm.indPediPrue");','focaliza("pedTipoSolicPaisFrm.indPediPrue");','focaliza("pedTipoSolicPaisFrm.indPediPrue");','focaliza("pedTipoSolicPaisFrm.indPediPrue");'],[11,'focaliza("pedTipoSolicPaisFrm.indComi");','focaliza("pedTipoSolicPaisFrm.indComi");','focaliza("pedTipoSolicPaisFrm.indComi");','focaliza("pedTipoSolicPaisFrm.indComi");','focaliza("pedTipoSolicPaisFrm.indComi");','focaliza("pedTipoSolicPaisFrm.indComi");'],[12,'focaliza("pedTipoSolicPaisFrm.indVentInteSab14");','focaliza("pedTipoSolicPaisFrm.indVentInteSab14");','focaliza("pedTipoSolicPaisFrm.indVentInteSab14");','focaliza("pedTipoSolicPaisFrm.indVentInteSab14");','focaliza("pedTipoSolicPaisFrm.indVentInteSab14");','focaliza("pedTipoSolicPaisFrm.indVentInteSab14");'],[13,'focalizaComboDependence("pedTipoSolicPais","cactOidActi", false);','focalizaComboDependence("pedTipoSolicPais","cactOidActi", false);','focalizaComboDependence("pedTipoSolicPais","cactOidActi", false);','focalizaComboDependence("pedTipoSolicPais","cactOidActi", true);','focalizaComboDependence("pedTipoSolicPais","cactOidActi", true);','focalizaComboDependence("pedTipoSolicPais","cactOidActi", true);'],[14,'focalizaComboDependence("pedTipoSolicPais","moneOidMone", false);','focalizaComboDependence("pedTipoSolicPais","moneOidMone", false);','focalizaComboDependence("pedTipoSolicPais","moneOidMone", false);','focalizaComboDependence("pedTipoSolicPais","moneOidMone", true);','focalizaComboDependence("pedTipoSolicPais","moneOidMone", true);','focalizaComboDependence("pedTipoSolicPais","moneOidMone", true);'],[15,'focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviAsig", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviAsig", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviAsig", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviAsig", true);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviAsig", true);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviAsig", true);'],[16,'focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviRese", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviRese", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviRese", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviRese", true);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviRese", true);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviRese", true);'],[17,'focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviFact", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviFact", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviFact", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviFact", true);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviFact", true);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviFact", true);'],[18,'focalizaComboDependence("pedTipoSolicPais","tidoOidTipoDocu", false);','focalizaComboDependence("pedTipoSolicPais","tidoOidTipoDocu", false);','focalizaComboDependence("pedTipoSolicPais","tidoOidTipoDocu", false);','focalizaComboDependence("pedTipoSolicPais","tidoOidTipoDocu", true);','focalizaComboDependence("pedTipoSolicPais","tidoOidTipoDocu", true);','focalizaComboDependence("pedTipoSolicPais","tidoOidTipoDocu", true);'],[19,'focaliza("pedTipoSolicPaisFrm.indPermUnio");','focaliza("pedTipoSolicPaisFrm.indPermUnio");','focaliza("pedTipoSolicPaisFrm.indPermUnio");','focaliza("pedTipoSolicPaisFrm.indPermUnio");','focaliza("pedTipoSolicPaisFrm.indPermUnio");','focaliza("pedTipoSolicPaisFrm.indPermUnio");'],[20,'focaliza("pedTipoSolicPaisFrm.indPediGtZona");','focaliza("pedTipoSolicPaisFrm.indPediGtZona");','focaliza("pedTipoSolicPaisFrm.indPediGtZona");','focaliza("pedTipoSolicPaisFrm.indPediGtZona");','focaliza("pedTipoSolicPaisFrm.indPediGtZona");','focaliza("pedTipoSolicPaisFrm.indPediGtZona");'],[21,'focaliza("pedTipoSolicPaisFrm.indCambVentBel");','focaliza("pedTipoSolicPaisFrm.indCambVentBel");','focaliza("pedTipoSolicPaisFrm.indCambVentBel");','focaliza("pedTipoSolicPaisFrm.indCambVentBel");','focaliza("pedTipoSolicPaisFrm.indCambVentBel");','focaliza("pedTipoSolicPaisFrm.indCambVentBel");'],[22,'focalizaComboDependence("pedTipoSolicPais","almcOidAlma", false);','focalizaComboDependence("pedTipoSolicPais","almcOidAlma", false);','focalizaComboDependence("pedTipoSolicPais","almcOidAlma", false);','focalizaComboDependence("pedTipoSolicPais","almcOidAlma", true);','focalizaComboDependence("pedTipoSolicPais","almcOidAlma", true);','focalizaComboDependence("pedTipoSolicPais","almcOidAlma", true);'],[23,'focalizaComboDependence("pedTipoSolicPais","sociOidSoci", false);','focalizaComboDependence("pedTipoSolicPais","sociOidSoci", false);','focalizaComboDependence("pedTipoSolicPais","sociOidSoci", false);','focalizaComboDependence("pedTipoSolicPais","sociOidSoci", true);','focalizaComboDependence("pedTipoSolicPais","sociOidSoci", true);','focalizaComboDependence("pedTipoSolicPais","sociOidSoci", true);'],[24,'focaliza("pedTipoSolicPaisFrm.valGlos");','focaliza("pedTipoSolicPaisFrm.valGlos");','focaliza("pedTipoSolicPaisFrm.valGlos");','focaliza("pedTipoSolicPaisFrm.valGlos");','focaliza("pedTipoSolicPaisFrm.valGlos");','focaliza("pedTipoSolicPaisFrm.valGlos");'],[25,'focalizaComboDependence("pedTipoSolicPais","tsolOidTipoCons", false);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoCons", false);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoCons", false);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoCons", true);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoCons", true);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoCons", true);']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'','','','','',''],[3,'focalizaComboDependence("pedTipoSolicPais","tsolOidTipoSoli", false);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoSoli", false);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoSoli", false);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoSoli", true);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoSoli", true);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoSoli", true);'],[4,'focaliza("pedTipoSolicPaisFrm.numSoliLote");','focaliza("pedTipoSolicPaisFrm.numSoliLote");','focaliza("pedTipoSolicPaisFrm.numSoliLote");','focaliza("pedTipoSolicPaisFrm.numSoliLote");','focaliza("pedTipoSolicPaisFrm.numSoliLote");','focaliza("pedTipoSolicPaisFrm.numSoliLote");'],[5,'focaliza("pedTipoSolicPaisFrm.numUnidAlar");','focaliza("pedTipoSolicPaisFrm.numUnidAlar");','focaliza("pedTipoSolicPaisFrm.numUnidAlar");','focaliza("pedTipoSolicPaisFrm.numUnidAlar");','focaliza("pedTipoSolicPaisFrm.numUnidAlar");','focaliza("pedTipoSolicPaisFrm.numUnidAlar");'],[6,'focalizaComboDependence("pedTipoSolicPais","fopaOidFormPago", false);','focalizaComboDependence("pedTipoSolicPais","fopaOidFormPago", false);','focalizaComboDependence("pedTipoSolicPais","fopaOidFormPago", false);','focalizaComboDependence("pedTipoSolicPais","fopaOidFormPago", true);','focalizaComboDependence("pedTipoSolicPais","fopaOidFormPago", true);','focalizaComboDependence("pedTipoSolicPais","fopaOidFormPago", true);'],[7,'focaliza("pedTipoSolicPaisFrm.indSujeFlet");','focaliza("pedTipoSolicPaisFrm.indSujeFlet");','focaliza("pedTipoSolicPaisFrm.indSujeFlet");','focaliza("pedTipoSolicPaisFrm.indSujeFlet");','focaliza("pedTipoSolicPaisFrm.indSujeFlet");','focaliza("pedTipoSolicPaisFrm.indSujeFlet");'],[8,'focaliza("pedTipoSolicPaisFrm.indReseStoc");','focaliza("pedTipoSolicPaisFrm.indReseStoc");','focaliza("pedTipoSolicPaisFrm.indReseStoc");','focaliza("pedTipoSolicPaisFrm.indReseStoc");','focaliza("pedTipoSolicPaisFrm.indReseStoc");','focaliza("pedTipoSolicPaisFrm.indReseStoc");'],[9,'focaliza("pedTipoSolicPaisFrm.indPermReve");','focaliza("pedTipoSolicPaisFrm.indPermReve");','focaliza("pedTipoSolicPaisFrm.indPermReve");','focaliza("pedTipoSolicPaisFrm.indPermReve");','focaliza("pedTipoSolicPaisFrm.indPermReve");','focaliza("pedTipoSolicPaisFrm.indPermReve");'],[10,'focaliza("pedTipoSolicPaisFrm.indPediPrue");','focaliza("pedTipoSolicPaisFrm.indPediPrue");','focaliza("pedTipoSolicPaisFrm.indPediPrue");','focaliza("pedTipoSolicPaisFrm.indPediPrue");','focaliza("pedTipoSolicPaisFrm.indPediPrue");','focaliza("pedTipoSolicPaisFrm.indPediPrue");'],[11,'focaliza("pedTipoSolicPaisFrm.indComi");','focaliza("pedTipoSolicPaisFrm.indComi");','focaliza("pedTipoSolicPaisFrm.indComi");','focaliza("pedTipoSolicPaisFrm.indComi");','focaliza("pedTipoSolicPaisFrm.indComi");','focaliza("pedTipoSolicPaisFrm.indComi");'],[12,'focaliza("pedTipoSolicPaisFrm.indVentInteSab14");','focaliza("pedTipoSolicPaisFrm.indVentInteSab14");','focaliza("pedTipoSolicPaisFrm.indVentInteSab14");','focaliza("pedTipoSolicPaisFrm.indVentInteSab14");','focaliza("pedTipoSolicPaisFrm.indVentInteSab14");','focaliza("pedTipoSolicPaisFrm.indVentInteSab14");'],[13,'focalizaComboDependence("pedTipoSolicPais","cactOidActi", false);','focalizaComboDependence("pedTipoSolicPais","cactOidActi", false);','focalizaComboDependence("pedTipoSolicPais","cactOidActi", false);','focalizaComboDependence("pedTipoSolicPais","cactOidActi", true);','focalizaComboDependence("pedTipoSolicPais","cactOidActi", true);','focalizaComboDependence("pedTipoSolicPais","cactOidActi", true);'],[14,'focalizaComboDependence("pedTipoSolicPais","moneOidMone", false);','focalizaComboDependence("pedTipoSolicPais","moneOidMone", false);','focalizaComboDependence("pedTipoSolicPais","moneOidMone", false);','focalizaComboDependence("pedTipoSolicPais","moneOidMone", true);','focalizaComboDependence("pedTipoSolicPais","moneOidMone", true);','focalizaComboDependence("pedTipoSolicPais","moneOidMone", true);'],[15,'focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviAsig", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviAsig", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviAsig", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviAsig", true);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviAsig", true);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviAsig", true);'],[16,'focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviRese", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviRese", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviRese", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviRese", true);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviRese", true);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviRese", true);'],[17,'focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviFact", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviFact", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviFact", false);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviFact", true);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviFact", true);','focalizaComboDependence("pedTipoSolicPais","tmalOidTipoMoviFact", true);'],[18,'focalizaComboDependence("pedTipoSolicPais","tidoOidTipoDocu", false);','focalizaComboDependence("pedTipoSolicPais","tidoOidTipoDocu", false);','focalizaComboDependence("pedTipoSolicPais","tidoOidTipoDocu", false);','focalizaComboDependence("pedTipoSolicPais","tidoOidTipoDocu", true);','focalizaComboDependence("pedTipoSolicPais","tidoOidTipoDocu", true);','focalizaComboDependence("pedTipoSolicPais","tidoOidTipoDocu", true);'],[19,'focaliza("pedTipoSolicPaisFrm.indPermUnio");','focaliza("pedTipoSolicPaisFrm.indPermUnio");','focaliza("pedTipoSolicPaisFrm.indPermUnio");','focaliza("pedTipoSolicPaisFrm.indPermUnio");','focaliza("pedTipoSolicPaisFrm.indPermUnio");','focaliza("pedTipoSolicPaisFrm.indPermUnio");'],[20,'focaliza("pedTipoSolicPaisFrm.indPediGtZona");','focaliza("pedTipoSolicPaisFrm.indPediGtZona");','focaliza("pedTipoSolicPaisFrm.indPediGtZona");','focaliza("pedTipoSolicPaisFrm.indPediGtZona");','focaliza("pedTipoSolicPaisFrm.indPediGtZona");','focaliza("pedTipoSolicPaisFrm.indPediGtZona");'],[21,'focaliza("pedTipoSolicPaisFrm.indCambVentBel");','focaliza("pedTipoSolicPaisFrm.indCambVentBel");','focaliza("pedTipoSolicPaisFrm.indCambVentBel");','focaliza("pedTipoSolicPaisFrm.indCambVentBel");','focaliza("pedTipoSolicPaisFrm.indCambVentBel");','focaliza("pedTipoSolicPaisFrm.indCambVentBel");'],[22,'focalizaComboDependence("pedTipoSolicPais","almcOidAlma", false);','focalizaComboDependence("pedTipoSolicPais","almcOidAlma", false);','focalizaComboDependence("pedTipoSolicPais","almcOidAlma", false);','focalizaComboDependence("pedTipoSolicPais","almcOidAlma", true);','focalizaComboDependence("pedTipoSolicPais","almcOidAlma", true);','focalizaComboDependence("pedTipoSolicPais","almcOidAlma", true);'],[23,'focalizaComboDependence("pedTipoSolicPais","sociOidSoci", false);','focalizaComboDependence("pedTipoSolicPais","sociOidSoci", false);','focalizaComboDependence("pedTipoSolicPais","sociOidSoci", false);','focalizaComboDependence("pedTipoSolicPais","sociOidSoci", true);','focalizaComboDependence("pedTipoSolicPais","sociOidSoci", true);','focalizaComboDependence("pedTipoSolicPais","sociOidSoci", true);'],[24,'focaliza("pedTipoSolicPaisFrm.valGlos");','focaliza("pedTipoSolicPaisFrm.valGlos");','focaliza("pedTipoSolicPaisFrm.valGlos");','focaliza("pedTipoSolicPaisFrm.valGlos");','focaliza("pedTipoSolicPaisFrm.valGlos");','focaliza("pedTipoSolicPaisFrm.valGlos");'],[25,'focalizaComboDependence("pedTipoSolicPais","tsolOidTipoCons", false);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoCons", false);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoCons", false);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoCons", true);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoCons", true);','focalizaComboDependence("pedTipoSolicPais","tsolOidTipoCons", true);']]);

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
var tsolOidTipoSoliDependeceMap = new Vector();
tsolOidTipoSoliDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tsolOidTipoSoliDependeceMap.agregar(['tsolOidTipoSoli', padresTmp, '', 'PedTipoSolicView']);
var fopaOidFormPagoDependeceMap = new Vector();
fopaOidFormPagoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
fopaOidFormPagoDependeceMap.agregar(['fopaOidFormPago', padresTmp, '', 'BelFormaPago']);
var cactOidActiDependeceMap = new Vector();
cactOidActiDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
cactOidActiDependeceMap.agregar(['cactOidActi', padresTmp, '', 'CraActiv']);
var moneOidMoneDependeceMap = new Vector();
moneOidMoneDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
moneOidMoneDependeceMap.agregar(['moneOidMone', padresTmp, '', 'SegMoned']);
var tmalOidTipoMoviAsigDependeceMap = new Vector();
tmalOidTipoMoviAsigDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmalOidTipoMoviAsigDependeceMap.agregar(['tmalOidTipoMoviAsig', padresTmp, '', 'BelTipoMovimAlmac']);
var tmalOidTipoMoviReseDependeceMap = new Vector();
tmalOidTipoMoviReseDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmalOidTipoMoviReseDependeceMap.agregar(['tmalOidTipoMoviRese', padresTmp, '', 'BelTipoMovimAlmac']);
var tmalOidTipoMoviFactDependeceMap = new Vector();
tmalOidTipoMoviFactDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmalOidTipoMoviFactDependeceMap.agregar(['tmalOidTipoMoviFact', padresTmp, '', 'BelTipoMovimAlmac']);
var tidoOidTipoDocuDependeceMap = new Vector();
tidoOidTipoDocuDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tidoOidTipoDocuDependeceMap.agregar(['tidoOidTipoDocu', padresTmp, '', 'FacTipoDocum']);
var almcOidAlmaDependeceMap = new Vector();
almcOidAlmaDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
almcOidAlmaDependeceMap.agregar(['almcOidAlma', padresTmp, '', 'BelAlmac']);
var sociOidSociDependeceMap = new Vector();
sociOidSociDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sociOidSociDependeceMap.agregar(['sociOidSoci', padresTmp, '', 'SegSocie']);
var tsolOidTipoConsDependeceMap = new Vector();
tsolOidTipoConsDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tsolOidTipoConsDependeceMap.agregar(['tsolOidTipoCons', padresTmp, '', 'PedTipoSolicPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
pedTipoSolicPaisLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var pedTipoSolicPaisTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function pedTipoSolicPaisInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('pedTipoSolicPaisFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('pedTipoSolicPaisFrm.accion')){
		case "query": pedTipoSolicPaisQueryInitComponents(); break;
		case "view": pedTipoSolicPaisViewInitComponents(); break;
		case "create": pedTipoSolicPaisCreateInitComponents(); break;
		case "update": pedTipoSolicPaisUpdateInitComponents(); break;
		case "remove": pedTipoSolicPaisRemoveInitComponents(); break;
		case "lov": pedTipoSolicPaisLovInitComponents(); break;
	}
	//alert('accion :' + get('pedTipoSolicPaisFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('pedTipoSolicPaisFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('pedTipoSolicPais')) pedTipoSolicPaisCmdRequery();
}

function pedTipoSolicPaisQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('pedTipoSolicPaisFrm', true);	
}

function pedTipoSolicPaisViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('pedTipoSolicPaisFrm', true);
}

function pedTipoSolicPaisCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('pedTipoSolicPaisFrm.tsolOidTipoSoli','S', GestionarMensaje('PedTipoSolicPais.tsolOidTipoSoli.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('pedTipoSolicPaisFrm', true);
}

function pedTipoSolicPaisUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('pedTipoSolicPaisFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		pedTipoSolicPaisTmpUpdateValues = pedTipoSolicPaisBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('pedTipoSolicPaisFrm.tsolOidTipoSoli','S', GestionarMensaje('PedTipoSolicPais.tsolOidTipoSoli.requiered.message'));
		
			focusFirstFieldModify('pedTipoSolicPaisFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('pedTipoSolicPaisFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('pedTipoSolicPaisFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function pedTipoSolicPaisRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	pedTipoSolicPaisList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('pedTipoSolicPaisFrm', true);
}

function pedTipoSolicPaisLovInitComponents(){
	pedTipoSolicPaisLovReturnParameters = window.dialogArguments;
	
	focusFirstField('pedTipoSolicPaisFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad



























//Función que permite cargar los datos de un elemento de lov seleccionado
function pedTipoSolicPaisSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('pedTipoSolicPaisFrm.' + campo, id);
	set('pedTipoSolicPaisFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function pedTipoSolicPaisLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	pedTipoSolicPaisLovReturnParameters.id = '';
	pedTipoSolicPaisLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function pedTipoSolicPaisLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedTipoSolicPaisList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = pedTipoSolicPaisList.codSeleccionados();
	var descripcion = pedTipoSolicPaisList.extraeDato(
		pedTipoSolicPaisList.codSeleccionados()[0], pedTipoSolicPaisChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	pedTipoSolicPaisLovReturnParameters.id = codigo;
	pedTipoSolicPaisLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function pedTipoSolicPaisCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('pedTipoSolicPaisFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('pedTipoSolicPaisFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "pedTipoSolicPaisList", "PedTipoSolicPaisConectorTransactionQuery", 
		"result_ROWSET", parametros, "pedTipoSolicPaisPostQueryActions(datos);"]], "", "");	
}

function pedTipoSolicPaisCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('pedTipoSolicPaisFrm.lastQueryToSession'));
	var i =0;
	set('pedTipoSolicPaisFrm.tsolOidTipoSoli', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicPaisFrm.numSoliLote', paramsRequery.ij(i++));
	
	set('pedTipoSolicPaisFrm.numUnidAlar', paramsRequery.ij(i++));
	
	set('pedTipoSolicPaisFrm.fopaOidFormPago', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicPaisFrm.indSujeFlet', paramsRequery.ij(i++));
	
	set('pedTipoSolicPaisFrm.indReseStoc', paramsRequery.ij(i++));
	
	set('pedTipoSolicPaisFrm.indPermReve', paramsRequery.ij(i++));
	
	set('pedTipoSolicPaisFrm.indPediPrue', paramsRequery.ij(i++));
	
	set('pedTipoSolicPaisFrm.indComi', paramsRequery.ij(i++));
	
	set('pedTipoSolicPaisFrm.indVentInteSab14', paramsRequery.ij(i++));
	
	set('pedTipoSolicPaisFrm.cactOidActi', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicPaisFrm.moneOidMone', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicPaisFrm.tmalOidTipoMoviAsig', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicPaisFrm.tmalOidTipoMoviRese', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicPaisFrm.tmalOidTipoMoviFact', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicPaisFrm.tidoOidTipoDocu', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicPaisFrm.indPermUnio', paramsRequery.ij(i++));
	
	set('pedTipoSolicPaisFrm.indPediGtZona', paramsRequery.ij(i++));
	
	set('pedTipoSolicPaisFrm.indCambVentBel', paramsRequery.ij(i++));
	
	set('pedTipoSolicPaisFrm.almcOidAlma', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicPaisFrm.sociOidSoci', [paramsRequery.ij(i++)]);
	
	set('pedTipoSolicPaisFrm.valGlos', paramsRequery.ij(i++));
	
	set('pedTipoSolicPaisFrm.tsolOidTipoCons', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	pedTipoSolicPaisPageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	pedTipoSolicPaisCmdQuery(pedTipoSolicPaisPageCount);
}

function pedTipoSolicPaisFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	pedTipoSolicPaisPageCount = 1;
	pedTipoSolicPaisCmdQuery(pedTipoSolicPaisPageCount);
}

function pedTipoSolicPaisPreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedTipoSolicPaisLastQuery){
		pedTipoSolicPaisFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	pedTipoSolicPaisPageCount--;
	pedTipoSolicPaisCmdQuery(pedTipoSolicPaisPageCount);
}

function pedTipoSolicPaisNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != pedTipoSolicPaisLastQuery){
		pedTipoSolicPaisFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	pedTipoSolicPaisPageCount++;
	pedTipoSolicPaisCmdQuery(pedTipoSolicPaisPageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function pedTipoSolicPaisPostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('pedTipoSolicPaisListLayer', 'O');
		visibilidad('pedTipoSolicPaisListButtonsLayer', 'O');
		if(get('pedTipoSolicPaisFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	pedTipoSolicPaisLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:pedTipoSolicPaisViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, pedTipoSolicPaisChoiceColumn) + "</A>",
			i, pedTipoSolicPaisChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	pedTipoSolicPaisList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	pedTipoSolicPaisTimeStamps = datosTmp.filtrar([24],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		pedTipoSolicPaisMorePagesFlag = true;
		pedTipoSolicPaisList.eliminar(mmgPageSize, 1);
	}else{
		pedTipoSolicPaisMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('pedTipoSolicPaisFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('pedTipoSolicPaisListLayer', 'V');
	visibilidad('pedTipoSolicPaisListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('pedTipoSolicPaisList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	pedTipoSolicPaisList.display();
	
	//Actualizamos el estado de los botones 
	if(pedTipoSolicPaisMorePagesFlag){
		set_estado_botonera('pedTipoSolicPaisPaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('pedTipoSolicPaisPaginationButtonBar',
			3,"inactivo");
	}
	if(pedTipoSolicPaisPageCount > 1){
		set_estado_botonera('pedTipoSolicPaisPaginationButtonBar',
			2,"activo");
		set_estado_botonera('pedTipoSolicPaisPaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('pedTipoSolicPaisPaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('pedTipoSolicPaisPaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function pedTipoSolicPaisUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedTipoSolicPaisList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('pedTipoSolicPaisFrm.idSelection', pedTipoSolicPaisList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('pedTipoSolicPaisFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = pedTipoSolicPaisList.codSeleccionados()[0];
		parametros["previousAction"] = get('pedTipoSolicPaisFrm.accion');
		parametros["accion"] = get('pedTipoSolicPaisFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('PedTipoSolicPaisLPStartUp', get('pedTipoSolicPaisFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) pedTipoSolicPaisCmdRequery();
	}
}

function pedTipoSolicPaisRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedTipoSolicPaisList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = pedTipoSolicPaisList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('pedTipoSolicPaisFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(pedTipoSolicPaisList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += pedTipoSolicPaisTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('pedTipoSolicPaisFrm.timestamp', timestamps);


	pedTipoSolicPaisFrm.oculto='S';
	envia('pedTipoSolicPaisFrm');
	pedTipoSolicPaisFrm.oculto='N';
}

function pedTipoSolicPaisViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(pedTipoSolicPaisList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	pedTipoSolicPaisViewDetail(pedTipoSolicPaisList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function pedTipoSolicPaisViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('pedTipoSolicPaisFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('PedTipoSolicPaisLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('pedTipoSolicPaisFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		pedTipoSolicPaisFrm.oculto='S';
		envia('pedTipoSolicPaisFrm');
		pedTipoSolicPaisFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('pedTipoSolicPaisFrm.paisOidPais').toString() == ''){
		set('pedTipoSolicPaisFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'pedTipoSolicPais');
		
	}
	if(get('pedTipoSolicPaisFrm.tsolOidTipoSoli').toString() == ''){
		set('pedTipoSolicPaisFrm.tsolOidTipoSoli', []);
		mmgResetCombosOnCascade('tsolOidTipoSoli', 'tsolOidTipoSoli', 'pedTipoSolicPais');
		
	}
	if(get('pedTipoSolicPaisFrm.fopaOidFormPago').toString() == ''){
		set('pedTipoSolicPaisFrm.fopaOidFormPago', []);
		mmgResetCombosOnCascade('fopaOidFormPago', 'fopaOidFormPago', 'pedTipoSolicPais');
		
	}
	if(get('pedTipoSolicPaisFrm.cactOidActi').toString() == ''){
		set('pedTipoSolicPaisFrm.cactOidActi', []);
		mmgResetCombosOnCascade('cactOidActi', 'cactOidActi', 'pedTipoSolicPais');
		
	}
	if(get('pedTipoSolicPaisFrm.moneOidMone').toString() == ''){
		set('pedTipoSolicPaisFrm.moneOidMone', []);
		mmgResetCombosOnCascade('moneOidMone', 'moneOidMone', 'pedTipoSolicPais');
		
	}
	if(get('pedTipoSolicPaisFrm.tmalOidTipoMoviAsig').toString() == ''){
		set('pedTipoSolicPaisFrm.tmalOidTipoMoviAsig', []);
		mmgResetCombosOnCascade('tmalOidTipoMoviAsig', 'tmalOidTipoMoviAsig', 'pedTipoSolicPais');
		
	}
	if(get('pedTipoSolicPaisFrm.tmalOidTipoMoviRese').toString() == ''){
		set('pedTipoSolicPaisFrm.tmalOidTipoMoviRese', []);
		mmgResetCombosOnCascade('tmalOidTipoMoviRese', 'tmalOidTipoMoviRese', 'pedTipoSolicPais');
		
	}
	if(get('pedTipoSolicPaisFrm.tmalOidTipoMoviFact').toString() == ''){
		set('pedTipoSolicPaisFrm.tmalOidTipoMoviFact', []);
		mmgResetCombosOnCascade('tmalOidTipoMoviFact', 'tmalOidTipoMoviFact', 'pedTipoSolicPais');
		
	}
	if(get('pedTipoSolicPaisFrm.tidoOidTipoDocu').toString() == ''){
		set('pedTipoSolicPaisFrm.tidoOidTipoDocu', []);
		mmgResetCombosOnCascade('tidoOidTipoDocu', 'tidoOidTipoDocu', 'pedTipoSolicPais');
		
	}
	if(get('pedTipoSolicPaisFrm.almcOidAlma').toString() == ''){
		set('pedTipoSolicPaisFrm.almcOidAlma', []);
		mmgResetCombosOnCascade('almcOidAlma', 'almcOidAlma', 'pedTipoSolicPais');
		
	}
	if(get('pedTipoSolicPaisFrm.sociOidSoci').toString() == ''){
		set('pedTipoSolicPaisFrm.sociOidSoci', []);
		mmgResetCombosOnCascade('sociOidSoci', 'sociOidSoci', 'pedTipoSolicPais');
		
	}
	if(get('pedTipoSolicPaisFrm.tsolOidTipoCons').toString() == ''){
		set('pedTipoSolicPaisFrm.tsolOidTipoCons', []);
		mmgResetCombosOnCascade('tsolOidTipoCons', 'tsolOidTipoCons', 'pedTipoSolicPais');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	pedTipoSolicPaisRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('pedTipoSolicPaisFrm.accion');
	var origenTmp = get('pedTipoSolicPaisFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(pedTipoSolicPaisBuildUpdateRecordString() != pedTipoSolicPaisTmpUpdateValues){
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
	document.all.pedTipoSolicPaisListLayer.style.display='none';
	document.all.pedTipoSolicPaisListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.pedTipoSolicPaisListLayer.style.display='';
	document.all.pedTipoSolicPaisListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsPedTipoSolicPaisTsolOidTipoSoli = get('pedTipoSolicPaisFrm.tsolOidTipoSoli')[0];
	jsPedTipoSolicPaisNumSoliLote = get('pedTipoSolicPaisFrm.numSoliLote').toString();
	jsPedTipoSolicPaisNumUnidAlar = get('pedTipoSolicPaisFrm.numUnidAlar').toString();
	jsPedTipoSolicPaisFopaOidFormPago = get('pedTipoSolicPaisFrm.fopaOidFormPago')[0];
	jsPedTipoSolicPaisIndSujeFlet = get('pedTipoSolicPaisFrm.indSujeFlet').toString();
	jsPedTipoSolicPaisIndReseStoc = get('pedTipoSolicPaisFrm.indReseStoc').toString();
	jsPedTipoSolicPaisIndPermReve = get('pedTipoSolicPaisFrm.indPermReve').toString();
	jsPedTipoSolicPaisIndPediPrue = get('pedTipoSolicPaisFrm.indPediPrue').toString();
	jsPedTipoSolicPaisIndComi = get('pedTipoSolicPaisFrm.indComi').toString();
	jsPedTipoSolicPaisIndVentInteSab14 = get('pedTipoSolicPaisFrm.indVentInteSab14').toString();
	jsPedTipoSolicPaisCactOidActi = get('pedTipoSolicPaisFrm.cactOidActi')[0];
	jsPedTipoSolicPaisMoneOidMone = get('pedTipoSolicPaisFrm.moneOidMone')[0];
	jsPedTipoSolicPaisTmalOidTipoMoviAsig = get('pedTipoSolicPaisFrm.tmalOidTipoMoviAsig')[0];
	jsPedTipoSolicPaisTmalOidTipoMoviRese = get('pedTipoSolicPaisFrm.tmalOidTipoMoviRese')[0];
	jsPedTipoSolicPaisTmalOidTipoMoviFact = get('pedTipoSolicPaisFrm.tmalOidTipoMoviFact')[0];
	jsPedTipoSolicPaisTidoOidTipoDocu = get('pedTipoSolicPaisFrm.tidoOidTipoDocu')[0];
	jsPedTipoSolicPaisIndPermUnio = get('pedTipoSolicPaisFrm.indPermUnio').toString();
	jsPedTipoSolicPaisIndPediGtZona = get('pedTipoSolicPaisFrm.indPediGtZona').toString();
	jsPedTipoSolicPaisIndCambVentBel = get('pedTipoSolicPaisFrm.indCambVentBel').toString();
	jsPedTipoSolicPaisAlmcOidAlma = get('pedTipoSolicPaisFrm.almcOidAlma')[0];
	jsPedTipoSolicPaisSociOidSoci = get('pedTipoSolicPaisFrm.sociOidSoci')[0];
	jsPedTipoSolicPaisValGlos = get('pedTipoSolicPaisFrm.valGlos').toString();
	jsPedTipoSolicPaisTsolOidTipoCons = get('pedTipoSolicPaisFrm.tsolOidTipoCons')[0];
	
	
	var parametros = "";
	parametros += jsPedTipoSolicPaisTsolOidTipoSoli + "|";
	parametros += jsPedTipoSolicPaisNumSoliLote + "|";
	parametros += jsPedTipoSolicPaisNumUnidAlar + "|";
	parametros += jsPedTipoSolicPaisFopaOidFormPago + "|";
	parametros += jsPedTipoSolicPaisIndSujeFlet + "|";
	parametros += jsPedTipoSolicPaisIndReseStoc + "|";
	parametros += jsPedTipoSolicPaisIndPermReve + "|";
	parametros += jsPedTipoSolicPaisIndPediPrue + "|";
	parametros += jsPedTipoSolicPaisIndComi + "|";
	parametros += jsPedTipoSolicPaisIndVentInteSab14 + "|";
	parametros += jsPedTipoSolicPaisCactOidActi + "|";
	parametros += jsPedTipoSolicPaisMoneOidMone + "|";
	parametros += jsPedTipoSolicPaisTmalOidTipoMoviAsig + "|";
	parametros += jsPedTipoSolicPaisTmalOidTipoMoviRese + "|";
	parametros += jsPedTipoSolicPaisTmalOidTipoMoviFact + "|";
	parametros += jsPedTipoSolicPaisTidoOidTipoDocu + "|";
	parametros += jsPedTipoSolicPaisIndPermUnio + "|";
	parametros += jsPedTipoSolicPaisIndPediGtZona + "|";
	parametros += jsPedTipoSolicPaisIndCambVentBel + "|";
	parametros += jsPedTipoSolicPaisAlmcOidAlma + "|";
	parametros += jsPedTipoSolicPaisSociOidSoci + "|";
	parametros += jsPedTipoSolicPaisValGlos + "|";
	parametros += jsPedTipoSolicPaisTsolOidTipoCons + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function pedTipoSolicPaisBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsPedTipoSolicPaisTsolOidTipoSoli + "|";
	parametros += jsPedTipoSolicPaisNumSoliLote + "|";
	parametros += jsPedTipoSolicPaisNumUnidAlar + "|";
	parametros += jsPedTipoSolicPaisFopaOidFormPago + "|";
	parametros += jsPedTipoSolicPaisIndSujeFlet + "|";
	parametros += jsPedTipoSolicPaisIndReseStoc + "|";
	parametros += jsPedTipoSolicPaisIndPermReve + "|";
	parametros += jsPedTipoSolicPaisIndPediPrue + "|";
	parametros += jsPedTipoSolicPaisIndComi + "|";
	parametros += jsPedTipoSolicPaisIndVentInteSab14 + "|";
	parametros += jsPedTipoSolicPaisCactOidActi + "|";
	parametros += jsPedTipoSolicPaisMoneOidMone + "|";
	parametros += jsPedTipoSolicPaisTmalOidTipoMoviAsig + "|";
	parametros += jsPedTipoSolicPaisTmalOidTipoMoviRese + "|";
	parametros += jsPedTipoSolicPaisTmalOidTipoMoviFact + "|";
	parametros += jsPedTipoSolicPaisTidoOidTipoDocu + "|";
	parametros += jsPedTipoSolicPaisIndPermUnio + "|";
	parametros += jsPedTipoSolicPaisIndPediGtZona + "|";
	parametros += jsPedTipoSolicPaisIndCambVentBel + "|";
	parametros += jsPedTipoSolicPaisAlmcOidAlma + "|";
	parametros += jsPedTipoSolicPaisSociOidSoci + "|";
	parametros += jsPedTipoSolicPaisValGlos + "|";
	parametros += jsPedTipoSolicPaisTsolOidTipoCons + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedTipoSolicPaisFrm.accion'), 
		get('pedTipoSolicPaisFrm.origen'));
	
	jsPedTipoSolicPaisId = get('pedTipoSolicPaisFrm.id').toString();
	jsPedTipoSolicPaisPaisOidPais = get('pedTipoSolicPaisFrm.paisOidPais')[0];
	jsPedTipoSolicPaisTsolOidTipoSoli = get('pedTipoSolicPaisFrm.tsolOidTipoSoli')[0];
	jsPedTipoSolicPaisNumSoliLote = get('pedTipoSolicPaisFrm.numSoliLote').toString();
	jsPedTipoSolicPaisNumUnidAlar = get('pedTipoSolicPaisFrm.numUnidAlar').toString();
	jsPedTipoSolicPaisFopaOidFormPago = get('pedTipoSolicPaisFrm.fopaOidFormPago')[0];
	jsPedTipoSolicPaisIndSujeFlet = get('pedTipoSolicPaisFrm.indSujeFlet').toString();
	jsPedTipoSolicPaisIndReseStoc = get('pedTipoSolicPaisFrm.indReseStoc').toString();
	jsPedTipoSolicPaisIndPermReve = get('pedTipoSolicPaisFrm.indPermReve').toString();
	jsPedTipoSolicPaisIndPediPrue = get('pedTipoSolicPaisFrm.indPediPrue').toString();
	jsPedTipoSolicPaisIndComi = get('pedTipoSolicPaisFrm.indComi').toString();
	jsPedTipoSolicPaisIndVentInteSab14 = get('pedTipoSolicPaisFrm.indVentInteSab14').toString();
	jsPedTipoSolicPaisCactOidActi = get('pedTipoSolicPaisFrm.cactOidActi')[0];
	jsPedTipoSolicPaisMoneOidMone = get('pedTipoSolicPaisFrm.moneOidMone')[0];
	jsPedTipoSolicPaisTmalOidTipoMoviAsig = get('pedTipoSolicPaisFrm.tmalOidTipoMoviAsig')[0];
	jsPedTipoSolicPaisTmalOidTipoMoviRese = get('pedTipoSolicPaisFrm.tmalOidTipoMoviRese')[0];
	jsPedTipoSolicPaisTmalOidTipoMoviFact = get('pedTipoSolicPaisFrm.tmalOidTipoMoviFact')[0];
	jsPedTipoSolicPaisTidoOidTipoDocu = get('pedTipoSolicPaisFrm.tidoOidTipoDocu')[0];
	jsPedTipoSolicPaisIndPermUnio = get('pedTipoSolicPaisFrm.indPermUnio').toString();
	jsPedTipoSolicPaisIndPediGtZona = get('pedTipoSolicPaisFrm.indPediGtZona').toString();
	jsPedTipoSolicPaisIndCambVentBel = get('pedTipoSolicPaisFrm.indCambVentBel').toString();
	jsPedTipoSolicPaisAlmcOidAlma = get('pedTipoSolicPaisFrm.almcOidAlma')[0];
	jsPedTipoSolicPaisSociOidSoci = get('pedTipoSolicPaisFrm.sociOidSoci')[0];
	jsPedTipoSolicPaisValGlos = get('pedTipoSolicPaisFrm.valGlos').toString();
	jsPedTipoSolicPaisTsolOidTipoCons = get('pedTipoSolicPaisFrm.tsolOidTipoCons')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('pedTipoSolicPaisFrm.accion'), 
		get('pedTipoSolicPaisFrm.origen'));


	set('pedTipoSolicPaisFrm.id', jsPedTipoSolicPaisId);
	set('pedTipoSolicPaisFrm.paisOidPais', [jsPedTipoSolicPaisPaisOidPais]);
	set('pedTipoSolicPaisFrm.tsolOidTipoSoli', [jsPedTipoSolicPaisTsolOidTipoSoli]);
	set('pedTipoSolicPaisFrm.numSoliLote', jsPedTipoSolicPaisNumSoliLote);
	set('pedTipoSolicPaisFrm.numUnidAlar', jsPedTipoSolicPaisNumUnidAlar);
	set('pedTipoSolicPaisFrm.fopaOidFormPago', [jsPedTipoSolicPaisFopaOidFormPago]);
	set('pedTipoSolicPaisFrm.indSujeFlet', jsPedTipoSolicPaisIndSujeFlet);
	set('pedTipoSolicPaisFrm.indReseStoc', jsPedTipoSolicPaisIndReseStoc);
	set('pedTipoSolicPaisFrm.indPermReve', jsPedTipoSolicPaisIndPermReve);
	set('pedTipoSolicPaisFrm.indPediPrue', jsPedTipoSolicPaisIndPediPrue);
	set('pedTipoSolicPaisFrm.indComi', jsPedTipoSolicPaisIndComi);
	set('pedTipoSolicPaisFrm.indVentInteSab14', jsPedTipoSolicPaisIndVentInteSab14);
	set('pedTipoSolicPaisFrm.cactOidActi', [jsPedTipoSolicPaisCactOidActi]);
	set('pedTipoSolicPaisFrm.moneOidMone', [jsPedTipoSolicPaisMoneOidMone]);
	set('pedTipoSolicPaisFrm.tmalOidTipoMoviAsig', [jsPedTipoSolicPaisTmalOidTipoMoviAsig]);
	set('pedTipoSolicPaisFrm.tmalOidTipoMoviRese', [jsPedTipoSolicPaisTmalOidTipoMoviRese]);
	set('pedTipoSolicPaisFrm.tmalOidTipoMoviFact', [jsPedTipoSolicPaisTmalOidTipoMoviFact]);
	set('pedTipoSolicPaisFrm.tidoOidTipoDocu', [jsPedTipoSolicPaisTidoOidTipoDocu]);
	set('pedTipoSolicPaisFrm.indPermUnio', jsPedTipoSolicPaisIndPermUnio);
	set('pedTipoSolicPaisFrm.indPediGtZona', jsPedTipoSolicPaisIndPediGtZona);
	set('pedTipoSolicPaisFrm.indCambVentBel', jsPedTipoSolicPaisIndCambVentBel);
	set('pedTipoSolicPaisFrm.almcOidAlma', [jsPedTipoSolicPaisAlmcOidAlma]);
	set('pedTipoSolicPaisFrm.sociOidSoci', [jsPedTipoSolicPaisSociOidSoci]);
	set('pedTipoSolicPaisFrm.valGlos', jsPedTipoSolicPaisValGlos);
	set('pedTipoSolicPaisFrm.tsolOidTipoCons', [jsPedTipoSolicPaisTsolOidTipoCons]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsPedTipoSolicPaisTsolOidTipoSoli = '';
	jsPedTipoSolicPaisNumSoliLote = '';
	jsPedTipoSolicPaisNumUnidAlar = '';
	jsPedTipoSolicPaisFopaOidFormPago = '';
	jsPedTipoSolicPaisIndSujeFlet = '';
	jsPedTipoSolicPaisIndReseStoc = '';
	jsPedTipoSolicPaisIndPermReve = '';
	jsPedTipoSolicPaisIndPediPrue = '';
	jsPedTipoSolicPaisIndComi = '';
	jsPedTipoSolicPaisIndVentInteSab14 = '';
	jsPedTipoSolicPaisCactOidActi = '';
	jsPedTipoSolicPaisMoneOidMone = '';
	jsPedTipoSolicPaisTmalOidTipoMoviAsig = '';
	jsPedTipoSolicPaisTmalOidTipoMoviRese = '';
	jsPedTipoSolicPaisTmalOidTipoMoviFact = '';
	jsPedTipoSolicPaisTidoOidTipoDocu = '';
	jsPedTipoSolicPaisIndPermUnio = '';
	jsPedTipoSolicPaisIndPediGtZona = '';
	jsPedTipoSolicPaisIndCambVentBel = '';
	jsPedTipoSolicPaisAlmcOidAlma = '';
	jsPedTipoSolicPaisSociOidSoci = '';
	jsPedTipoSolicPaisValGlos = '';
	jsPedTipoSolicPaisTsolOidTipoCons = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('pedTipoSolicPaisFrm.errCodigo', errorCode);
	set('pedTipoSolicPaisFrm.errDescripcion', description);
	set('pedTipoSolicPaisFrm.errSeverity', severity);
	fMostrarMensajeError();
}
