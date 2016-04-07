

/*
    INDRA/CAR/mmg
    $Id: belparambelce.js,v 1.1 2009/12/03 19:01:34 pecbazalar Exp $
    DESC
*/

//Variables temporales para almacenar los valores de los campos del formualrio
var jsBelParamBelceId = "";
var jsBelParamBelceSbacOidSbac = "";
var jsBelParamBelceValDire = "";
var jsBelParamBelceValTfno = "";
var jsBelParamBelceValMontMaxiDife = "";
var jsBelParamBelceValLimiEfecCaja = "";
var jsBelParamBelceNumCaja = "";
var jsBelParamBelceValNombLoca = "";
var jsBelParamBelceValTiempRepo = "";
var jsBelParamBelceValFactLoca = "";
var jsBelParamBelceNumMaxiProd = "";
var jsBelParamBelceValAlerStoc = "";
var jsBelParamBelceValUsua = "";
var jsBelParamBelceClieOidClie = "";
var jsBelParamBelceSociOidSoci = "";
var jsBelParamBelceTtraOidTipoTran = "";
var jsBelParamBelceCcbaOidCuenCorrBanc = "";
var jsBelParamBelceTmvcOidCobr = "";
var jsBelParamBelceTmvcOidCier = "";
var jsBelParamBelceTmalOidConfStoc = "";
var jsBelParamBelceTmalOidConfStocTran = "";
var jsBelParamBelceTmalOidStocTran = "";
var jsBelParamBelceTmalOidStocDevo = "";
var jsBelParamBelceTmalOidRegu = "";
var jsBelParamBelceTmalOidReguSap = "";
var jsBelParamBelceTmalOidDevoStoc = "";
var jsBelParamBelceTmalOidPetiExis = "";
var jsBelParamBelcePaisOidPais = "";

//Variables de paginacion, 
var belParamBelcePageCount = 1;

//Varible de columna que representa el campo de choice
var belParamBelceChoiceColumn = 26;

//Flag de siguiente pagina;
var belParamBelceMorePagesFlag = false;

//Vector con los timestamps de los elementos de la lista
var belParamBelceTimeStamps = null;

//Tamaños del formulario
var sizeFormQuery = 1155;
var sizeFormView = 1229;
var sizeFormUpdate = 1229;

//Ultima busqueda realizada
var belParamBelceLastQuery= null;

//Vector con acciones de foco. El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFoco = new Vector();
accionesFoco.cargar([[2,'focalizaComboDependence("belParamBelce","sbacOidSbac", false);','focalizaComboDependence("belParamBelce","sbacOidSbac", false);','focalizaComboDependence("belParamBelce","sbacOidSbac", false);','focalizaComboDependence("belParamBelce","sbacOidSbac", true);','focalizaComboDependence("belParamBelce","sbacOidSbac", true);','focalizaComboDependence("belParamBelce","sbacOidSbac", true);'],[3,'focaliza("belParamBelceFrm.valDire");','focaliza("belParamBelceFrm.valDire");','focaliza("belParamBelceFrm.valDire");','focaliza("belParamBelceFrm.valDire");','focaliza("belParamBelceFrm.valDire");','focaliza("belParamBelceFrm.valDire");'],[4,'focaliza("belParamBelceFrm.valTfno");','focaliza("belParamBelceFrm.valTfno");','focaliza("belParamBelceFrm.valTfno");','focaliza("belParamBelceFrm.valTfno");','focaliza("belParamBelceFrm.valTfno");','focaliza("belParamBelceFrm.valTfno");'],[5,'focaliza("belParamBelceFrm.valMontMaxiDife");','focaliza("belParamBelceFrm.valMontMaxiDife");','focaliza("belParamBelceFrm.valMontMaxiDife");','focaliza("belParamBelceFrm.valMontMaxiDife");','focaliza("belParamBelceFrm.valMontMaxiDife");','focaliza("belParamBelceFrm.valMontMaxiDife");'],[6,'focaliza("belParamBelceFrm.valLimiEfecCaja");','focaliza("belParamBelceFrm.valLimiEfecCaja");','focaliza("belParamBelceFrm.valLimiEfecCaja");','focaliza("belParamBelceFrm.valLimiEfecCaja");','focaliza("belParamBelceFrm.valLimiEfecCaja");','focaliza("belParamBelceFrm.valLimiEfecCaja");'],[7,'focaliza("belParamBelceFrm.numCaja");','focaliza("belParamBelceFrm.numCaja");','focaliza("belParamBelceFrm.numCaja");','focaliza("belParamBelceFrm.numCaja");','focaliza("belParamBelceFrm.numCaja");','focaliza("belParamBelceFrm.numCaja");'],[8,'focaliza("belParamBelceFrm.valNombLoca");','focaliza("belParamBelceFrm.valNombLoca");','focaliza("belParamBelceFrm.valNombLoca");','focaliza("belParamBelceFrm.valNombLoca");','focaliza("belParamBelceFrm.valNombLoca");','focaliza("belParamBelceFrm.valNombLoca");'],[9,'focaliza("belParamBelceFrm.valTiempRepo");','focaliza("belParamBelceFrm.valTiempRepo");','focaliza("belParamBelceFrm.valTiempRepo");','focaliza("belParamBelceFrm.valTiempRepo");','focaliza("belParamBelceFrm.valTiempRepo");','focaliza("belParamBelceFrm.valTiempRepo");'],[10,'focaliza("belParamBelceFrm.valFactLoca");','focaliza("belParamBelceFrm.valFactLoca");','focaliza("belParamBelceFrm.valFactLoca");','focaliza("belParamBelceFrm.valFactLoca");','focaliza("belParamBelceFrm.valFactLoca");','focaliza("belParamBelceFrm.valFactLoca");'],[11,'focaliza("belParamBelceFrm.numMaxiProd");','focaliza("belParamBelceFrm.numMaxiProd");','focaliza("belParamBelceFrm.numMaxiProd");','focaliza("belParamBelceFrm.numMaxiProd");','focaliza("belParamBelceFrm.numMaxiProd");','focaliza("belParamBelceFrm.numMaxiProd");'],[12,'focaliza("belParamBelceFrm.valAlerStoc");','focaliza("belParamBelceFrm.valAlerStoc");','focaliza("belParamBelceFrm.valAlerStoc");','focaliza("belParamBelceFrm.valAlerStoc");','focaliza("belParamBelceFrm.valAlerStoc");','focaliza("belParamBelceFrm.valAlerStoc");'],[13,'focaliza("belParamBelceFrm.valUsua");','focaliza("belParamBelceFrm.valUsua");','focaliza("belParamBelceFrm.valUsua");','focaliza("belParamBelceFrm.valUsua");','focaliza("belParamBelceFrm.valUsua");','focaliza("belParamBelceFrm.valUsua");'],[14,'focalizaComboDependence("belParamBelce","clieOidClie", false);','focalizaComboDependence("belParamBelce","clieOidClie", false);','focalizaComboDependence("belParamBelce","clieOidClie", false);','focalizaComboDependence("belParamBelce","clieOidClie", true);','focalizaComboDependence("belParamBelce","clieOidClie", true);','focalizaComboDependence("belParamBelce","clieOidClie", true);'],[15,'focalizaComboDependence("belParamBelce","sociOidSoci", false);','focalizaComboDependence("belParamBelce","sociOidSoci", false);','focalizaComboDependence("belParamBelce","sociOidSoci", false);','focalizaComboDependence("belParamBelce","sociOidSoci", true);','focalizaComboDependence("belParamBelce","sociOidSoci", true);','focalizaComboDependence("belParamBelce","sociOidSoci", true);'],[16,'focalizaComboDependence("belParamBelce","ttraOidTipoTran", false);','focalizaComboDependence("belParamBelce","ttraOidTipoTran", false);','focalizaComboDependence("belParamBelce","ttraOidTipoTran", false);','focalizaComboDependence("belParamBelce","ttraOidTipoTran", true);','focalizaComboDependence("belParamBelce","ttraOidTipoTran", true);','focalizaComboDependence("belParamBelce","ttraOidTipoTran", true);'],[17,'focalizaComboDependence("belParamBelce","ccbaOidCuenCorrBanc", false);','focalizaComboDependence("belParamBelce","ccbaOidCuenCorrBanc", false);','focalizaComboDependence("belParamBelce","ccbaOidCuenCorrBanc", false);','focalizaComboDependence("belParamBelce","ccbaOidCuenCorrBanc", true);','focalizaComboDependence("belParamBelce","ccbaOidCuenCorrBanc", true);','focalizaComboDependence("belParamBelce","ccbaOidCuenCorrBanc", true);'],[18,'focalizaComboDependence("belParamBelce","tmvcOidCobr", false);','focalizaComboDependence("belParamBelce","tmvcOidCobr", false);','focalizaComboDependence("belParamBelce","tmvcOidCobr", false);','focalizaComboDependence("belParamBelce","tmvcOidCobr", true);','focalizaComboDependence("belParamBelce","tmvcOidCobr", true);','focalizaComboDependence("belParamBelce","tmvcOidCobr", true);'],[19,'focalizaComboDependence("belParamBelce","tmvcOidCier", false);','focalizaComboDependence("belParamBelce","tmvcOidCier", false);','focalizaComboDependence("belParamBelce","tmvcOidCier", false);','focalizaComboDependence("belParamBelce","tmvcOidCier", true);','focalizaComboDependence("belParamBelce","tmvcOidCier", true);','focalizaComboDependence("belParamBelce","tmvcOidCier", true);'],[20,'focalizaComboDependence("belParamBelce","tmalOidConfStoc", false);','focalizaComboDependence("belParamBelce","tmalOidConfStoc", false);','focalizaComboDependence("belParamBelce","tmalOidConfStoc", false);','focalizaComboDependence("belParamBelce","tmalOidConfStoc", true);','focalizaComboDependence("belParamBelce","tmalOidConfStoc", true);','focalizaComboDependence("belParamBelce","tmalOidConfStoc", true);'],[21,'focalizaComboDependence("belParamBelce","tmalOidConfStocTran", false);','focalizaComboDependence("belParamBelce","tmalOidConfStocTran", false);','focalizaComboDependence("belParamBelce","tmalOidConfStocTran", false);','focalizaComboDependence("belParamBelce","tmalOidConfStocTran", true);','focalizaComboDependence("belParamBelce","tmalOidConfStocTran", true);','focalizaComboDependence("belParamBelce","tmalOidConfStocTran", true);'],[22,'focalizaComboDependence("belParamBelce","tmalOidStocTran", false);','focalizaComboDependence("belParamBelce","tmalOidStocTran", false);','focalizaComboDependence("belParamBelce","tmalOidStocTran", false);','focalizaComboDependence("belParamBelce","tmalOidStocTran", true);','focalizaComboDependence("belParamBelce","tmalOidStocTran", true);','focalizaComboDependence("belParamBelce","tmalOidStocTran", true);'],[23,'focalizaComboDependence("belParamBelce","tmalOidStocDevo", false);','focalizaComboDependence("belParamBelce","tmalOidStocDevo", false);','focalizaComboDependence("belParamBelce","tmalOidStocDevo", false);','focalizaComboDependence("belParamBelce","tmalOidStocDevo", true);','focalizaComboDependence("belParamBelce","tmalOidStocDevo", true);','focalizaComboDependence("belParamBelce","tmalOidStocDevo", true);'],[24,'focalizaComboDependence("belParamBelce","tmalOidRegu", false);','focalizaComboDependence("belParamBelce","tmalOidRegu", false);','focalizaComboDependence("belParamBelce","tmalOidRegu", false);','focalizaComboDependence("belParamBelce","tmalOidRegu", true);','focalizaComboDependence("belParamBelce","tmalOidRegu", true);','focalizaComboDependence("belParamBelce","tmalOidRegu", true);'],[25,'focalizaComboDependence("belParamBelce","tmalOidReguSap", false);','focalizaComboDependence("belParamBelce","tmalOidReguSap", false);','focalizaComboDependence("belParamBelce","tmalOidReguSap", false);','focalizaComboDependence("belParamBelce","tmalOidReguSap", true);','focalizaComboDependence("belParamBelce","tmalOidReguSap", true);','focalizaComboDependence("belParamBelce","tmalOidReguSap", true);'],[26,'focalizaComboDependence("belParamBelce","tmalOidDevoStoc", false);','focalizaComboDependence("belParamBelce","tmalOidDevoStoc", false);','focalizaComboDependence("belParamBelce","tmalOidDevoStoc", false);','focalizaComboDependence("belParamBelce","tmalOidDevoStoc", true);','focalizaComboDependence("belParamBelce","tmalOidDevoStoc", true);','focalizaComboDependence("belParamBelce","tmalOidDevoStoc", true);'],[27,'focalizaComboDependence("belParamBelce","tmalOidPetiExis", false);','focalizaComboDependence("belParamBelce","tmalOidPetiExis", false);','focalizaComboDependence("belParamBelce","tmalOidPetiExis", false);','focalizaComboDependence("belParamBelce","tmalOidPetiExis", true);','focalizaComboDependence("belParamBelce","tmalOidPetiExis", true);','focalizaComboDependence("belParamBelce","tmalOidPetiExis", true);'],[28,'','','','','','']]);

//Vector con acciones de foco para la pantalla de modificación.
//El vector esta compuesto por 7 columnas. 
//La primera columna contiene el orden del foco 
//Las otras seis columnas son las acción a ejecutar en los tres posibles modos (query, modify, update) y para los dos evento de foco (siguinete campo y campo)
//[ordenFoco, anterior-Query, anterior-Create, anterior-Update, siguiente-Query, siguinet-Create, siguiente-Upate]
var accionesFocoModificacion = new Vector();
accionesFocoModificacion.cargar([[2,'focalizaComboDependence("belParamBelce","sbacOidSbac", false);','focalizaComboDependence("belParamBelce","sbacOidSbac", false);','focalizaComboDependence("belParamBelce","sbacOidSbac", false);','focalizaComboDependence("belParamBelce","sbacOidSbac", true);','focalizaComboDependence("belParamBelce","sbacOidSbac", true);','focalizaComboDependence("belParamBelce","sbacOidSbac", true);'],[3,'focaliza("belParamBelceFrm.valDire");','focaliza("belParamBelceFrm.valDire");','focaliza("belParamBelceFrm.valDire");','focaliza("belParamBelceFrm.valDire");','focaliza("belParamBelceFrm.valDire");','focaliza("belParamBelceFrm.valDire");'],[4,'focaliza("belParamBelceFrm.valTfno");','focaliza("belParamBelceFrm.valTfno");','focaliza("belParamBelceFrm.valTfno");','focaliza("belParamBelceFrm.valTfno");','focaliza("belParamBelceFrm.valTfno");','focaliza("belParamBelceFrm.valTfno");'],[5,'focaliza("belParamBelceFrm.valMontMaxiDife");','focaliza("belParamBelceFrm.valMontMaxiDife");','focaliza("belParamBelceFrm.valMontMaxiDife");','focaliza("belParamBelceFrm.valMontMaxiDife");','focaliza("belParamBelceFrm.valMontMaxiDife");','focaliza("belParamBelceFrm.valMontMaxiDife");'],[6,'focaliza("belParamBelceFrm.valLimiEfecCaja");','focaliza("belParamBelceFrm.valLimiEfecCaja");','focaliza("belParamBelceFrm.valLimiEfecCaja");','focaliza("belParamBelceFrm.valLimiEfecCaja");','focaliza("belParamBelceFrm.valLimiEfecCaja");','focaliza("belParamBelceFrm.valLimiEfecCaja");'],[7,'focaliza("belParamBelceFrm.numCaja");','focaliza("belParamBelceFrm.numCaja");','focaliza("belParamBelceFrm.numCaja");','focaliza("belParamBelceFrm.numCaja");','focaliza("belParamBelceFrm.numCaja");','focaliza("belParamBelceFrm.numCaja");'],[8,'focaliza("belParamBelceFrm.valNombLoca");','focaliza("belParamBelceFrm.valNombLoca");','focaliza("belParamBelceFrm.valNombLoca");','focaliza("belParamBelceFrm.valNombLoca");','focaliza("belParamBelceFrm.valNombLoca");','focaliza("belParamBelceFrm.valNombLoca");'],[9,'focaliza("belParamBelceFrm.valTiempRepo");','focaliza("belParamBelceFrm.valTiempRepo");','focaliza("belParamBelceFrm.valTiempRepo");','focaliza("belParamBelceFrm.valTiempRepo");','focaliza("belParamBelceFrm.valTiempRepo");','focaliza("belParamBelceFrm.valTiempRepo");'],[10,'focaliza("belParamBelceFrm.valFactLoca");','focaliza("belParamBelceFrm.valFactLoca");','focaliza("belParamBelceFrm.valFactLoca");','focaliza("belParamBelceFrm.valFactLoca");','focaliza("belParamBelceFrm.valFactLoca");','focaliza("belParamBelceFrm.valFactLoca");'],[11,'focaliza("belParamBelceFrm.numMaxiProd");','focaliza("belParamBelceFrm.numMaxiProd");','focaliza("belParamBelceFrm.numMaxiProd");','focaliza("belParamBelceFrm.numMaxiProd");','focaliza("belParamBelceFrm.numMaxiProd");','focaliza("belParamBelceFrm.numMaxiProd");'],[12,'focaliza("belParamBelceFrm.valAlerStoc");','focaliza("belParamBelceFrm.valAlerStoc");','focaliza("belParamBelceFrm.valAlerStoc");','focaliza("belParamBelceFrm.valAlerStoc");','focaliza("belParamBelceFrm.valAlerStoc");','focaliza("belParamBelceFrm.valAlerStoc");'],[13,'focaliza("belParamBelceFrm.valUsua");','focaliza("belParamBelceFrm.valUsua");','focaliza("belParamBelceFrm.valUsua");','focaliza("belParamBelceFrm.valUsua");','focaliza("belParamBelceFrm.valUsua");','focaliza("belParamBelceFrm.valUsua");'],[14,'focalizaComboDependence("belParamBelce","clieOidClie", false);','focalizaComboDependence("belParamBelce","clieOidClie", false);','focalizaComboDependence("belParamBelce","clieOidClie", false);','focalizaComboDependence("belParamBelce","clieOidClie", true);','focalizaComboDependence("belParamBelce","clieOidClie", true);','focalizaComboDependence("belParamBelce","clieOidClie", true);'],[15,'focalizaComboDependence("belParamBelce","sociOidSoci", false);','focalizaComboDependence("belParamBelce","sociOidSoci", false);','focalizaComboDependence("belParamBelce","sociOidSoci", false);','focalizaComboDependence("belParamBelce","sociOidSoci", true);','focalizaComboDependence("belParamBelce","sociOidSoci", true);','focalizaComboDependence("belParamBelce","sociOidSoci", true);'],[16,'focalizaComboDependence("belParamBelce","ttraOidTipoTran", false);','focalizaComboDependence("belParamBelce","ttraOidTipoTran", false);','focalizaComboDependence("belParamBelce","ttraOidTipoTran", false);','focalizaComboDependence("belParamBelce","ttraOidTipoTran", true);','focalizaComboDependence("belParamBelce","ttraOidTipoTran", true);','focalizaComboDependence("belParamBelce","ttraOidTipoTran", true);'],[17,'focalizaComboDependence("belParamBelce","ccbaOidCuenCorrBanc", false);','focalizaComboDependence("belParamBelce","ccbaOidCuenCorrBanc", false);','focalizaComboDependence("belParamBelce","ccbaOidCuenCorrBanc", false);','focalizaComboDependence("belParamBelce","ccbaOidCuenCorrBanc", true);','focalizaComboDependence("belParamBelce","ccbaOidCuenCorrBanc", true);','focalizaComboDependence("belParamBelce","ccbaOidCuenCorrBanc", true);'],[18,'focalizaComboDependence("belParamBelce","tmvcOidCobr", false);','focalizaComboDependence("belParamBelce","tmvcOidCobr", false);','focalizaComboDependence("belParamBelce","tmvcOidCobr", false);','focalizaComboDependence("belParamBelce","tmvcOidCobr", true);','focalizaComboDependence("belParamBelce","tmvcOidCobr", true);','focalizaComboDependence("belParamBelce","tmvcOidCobr", true);'],[19,'focalizaComboDependence("belParamBelce","tmvcOidCier", false);','focalizaComboDependence("belParamBelce","tmvcOidCier", false);','focalizaComboDependence("belParamBelce","tmvcOidCier", false);','focalizaComboDependence("belParamBelce","tmvcOidCier", true);','focalizaComboDependence("belParamBelce","tmvcOidCier", true);','focalizaComboDependence("belParamBelce","tmvcOidCier", true);'],[20,'focalizaComboDependence("belParamBelce","tmalOidConfStoc", false);','focalizaComboDependence("belParamBelce","tmalOidConfStoc", false);','focalizaComboDependence("belParamBelce","tmalOidConfStoc", false);','focalizaComboDependence("belParamBelce","tmalOidConfStoc", true);','focalizaComboDependence("belParamBelce","tmalOidConfStoc", true);','focalizaComboDependence("belParamBelce","tmalOidConfStoc", true);'],[21,'focalizaComboDependence("belParamBelce","tmalOidConfStocTran", false);','focalizaComboDependence("belParamBelce","tmalOidConfStocTran", false);','focalizaComboDependence("belParamBelce","tmalOidConfStocTran", false);','focalizaComboDependence("belParamBelce","tmalOidConfStocTran", true);','focalizaComboDependence("belParamBelce","tmalOidConfStocTran", true);','focalizaComboDependence("belParamBelce","tmalOidConfStocTran", true);'],[22,'focalizaComboDependence("belParamBelce","tmalOidStocTran", false);','focalizaComboDependence("belParamBelce","tmalOidStocTran", false);','focalizaComboDependence("belParamBelce","tmalOidStocTran", false);','focalizaComboDependence("belParamBelce","tmalOidStocTran", true);','focalizaComboDependence("belParamBelce","tmalOidStocTran", true);','focalizaComboDependence("belParamBelce","tmalOidStocTran", true);'],[23,'focalizaComboDependence("belParamBelce","tmalOidStocDevo", false);','focalizaComboDependence("belParamBelce","tmalOidStocDevo", false);','focalizaComboDependence("belParamBelce","tmalOidStocDevo", false);','focalizaComboDependence("belParamBelce","tmalOidStocDevo", true);','focalizaComboDependence("belParamBelce","tmalOidStocDevo", true);','focalizaComboDependence("belParamBelce","tmalOidStocDevo", true);'],[24,'focalizaComboDependence("belParamBelce","tmalOidRegu", false);','focalizaComboDependence("belParamBelce","tmalOidRegu", false);','focalizaComboDependence("belParamBelce","tmalOidRegu", false);','focalizaComboDependence("belParamBelce","tmalOidRegu", true);','focalizaComboDependence("belParamBelce","tmalOidRegu", true);','focalizaComboDependence("belParamBelce","tmalOidRegu", true);'],[25,'focalizaComboDependence("belParamBelce","tmalOidReguSap", false);','focalizaComboDependence("belParamBelce","tmalOidReguSap", false);','focalizaComboDependence("belParamBelce","tmalOidReguSap", false);','focalizaComboDependence("belParamBelce","tmalOidReguSap", true);','focalizaComboDependence("belParamBelce","tmalOidReguSap", true);','focalizaComboDependence("belParamBelce","tmalOidReguSap", true);'],[26,'focalizaComboDependence("belParamBelce","tmalOidDevoStoc", false);','focalizaComboDependence("belParamBelce","tmalOidDevoStoc", false);','focalizaComboDependence("belParamBelce","tmalOidDevoStoc", false);','focalizaComboDependence("belParamBelce","tmalOidDevoStoc", true);','focalizaComboDependence("belParamBelce","tmalOidDevoStoc", true);','focalizaComboDependence("belParamBelce","tmalOidDevoStoc", true);'],[27,'focalizaComboDependence("belParamBelce","tmalOidPetiExis", false);','focalizaComboDependence("belParamBelce","tmalOidPetiExis", false);','focalizaComboDependence("belParamBelce","tmalOidPetiExis", false);','focalizaComboDependence("belParamBelce","tmalOidPetiExis", true);','focalizaComboDependence("belParamBelce","tmalOidPetiExis", true);','focalizaComboDependence("belParamBelce","tmalOidPetiExis", true);'],[28,'','','','','','']]);

//Creamos la información de las jerarquías de dependencias de combos (si existen)
//Para cada jerarquía de dependencia definimos un vector donde se defina la jeraría
//La definición de la jerarquía consiste en definir para cada combo de la jerarquía cuales 
//son sus padres (combos de los que depende para determinar sus valores) cual es su 
//hijo(combo que depende de él para determianr sus valores) y el  nombre de la entidad 
//de los objetos que se representan en el combo. 
//Las columnas del vector quedarían [nombreCombo, vectorEntidadesPadre, entidadHija, nombreEntidadObjetos]
var padresTmp = null;
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
var clieOidClieDependeceMap = new Vector();
clieOidClieDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
clieOidClieDependeceMap.agregar(['clieOidClie', padresTmp, '', 'MaeClienView']);
var sociOidSociDependeceMap = new Vector();
sociOidSociDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
sociOidSociDependeceMap.agregar(['sociOidSoci', padresTmp, '', 'SegSocieView']);
var ttraOidTipoTranDependeceMap = new Vector();
ttraOidTipoTranDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ttraOidTipoTranDependeceMap.agregar(['ttraOidTipoTran', padresTmp, '', 'CccTipoTransView']);
var ccbaOidCuenCorrBancDependeceMap = new Vector();
ccbaOidCuenCorrBancDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
ccbaOidCuenCorrBancDependeceMap.agregar(['ccbaOidCuenCorrBanc_cucoOidCcPnte', padresTmp, 'ccbaOidCuenCorrBanc', 'CccCuentConta']);
padresTmp =  new Vector();
padresTmp.cargar([])
ccbaOidCuenCorrBancDependeceMap.agregar(['ccbaOidCuenCorrBanc_sociOidSoci', padresTmp, 'ccbaOidCuenCorrBanc', 'SegSocie']);
padresTmp =  new Vector();
padresTmp.cargar([])
ccbaOidCuenCorrBancDependeceMap.agregar(['ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc', padresTmp, 'ccbaOidCuenCorrBanc_sucuOidSucu', 'CccBanco']);
padresTmp =  new Vector();
padresTmp.cargar(['ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc'])
ccbaOidCuenCorrBancDependeceMap.agregar(['ccbaOidCuenCorrBanc_sucuOidSucu', padresTmp, 'ccbaOidCuenCorrBanc', 'CccSucur']);
padresTmp =  new Vector();
padresTmp.cargar([])
ccbaOidCuenCorrBancDependeceMap.agregar(['ccbaOidCuenCorrBanc_cucoOidCcTeso', padresTmp, 'ccbaOidCuenCorrBanc', 'CccCuentConta']);
padresTmp =  new Vector();
padresTmp.cargar(['ccbaOidCuenCorrBanc_cucoOidCcPnte','ccbaOidCuenCorrBanc_sociOidSoci','ccbaOidCuenCorrBanc_sucuOidSucu','ccbaOidCuenCorrBanc_cucoOidCcTeso'])
ccbaOidCuenCorrBancDependeceMap.agregar(['ccbaOidCuenCorrBanc', padresTmp, '', 'CccCuentCorriBanca']);
var tmvcOidCobrDependeceMap = new Vector();
tmvcOidCobrDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmvcOidCobrDependeceMap.agregar(['tmvcOidCobr', padresTmp, '', 'BelTipoMovimCaja']);
var tmvcOidCierDependeceMap = new Vector();
tmvcOidCierDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmvcOidCierDependeceMap.agregar(['tmvcOidCier', padresTmp, '', 'BelTipoMovimCaja']);
var tmalOidConfStocDependeceMap = new Vector();
tmalOidConfStocDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmalOidConfStocDependeceMap.agregar(['tmalOidConfStoc', padresTmp, '', 'BelTipoMovimAlmacView']);
var tmalOidConfStocTranDependeceMap = new Vector();
tmalOidConfStocTranDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmalOidConfStocTranDependeceMap.agregar(['tmalOidConfStocTran', padresTmp, '', 'BelTipoMovimAlmacView']);
var tmalOidStocTranDependeceMap = new Vector();
tmalOidStocTranDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmalOidStocTranDependeceMap.agregar(['tmalOidStocTran', padresTmp, '', 'BelTipoMovimAlmacView']);
var tmalOidStocDevoDependeceMap = new Vector();
tmalOidStocDevoDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmalOidStocDevoDependeceMap.agregar(['tmalOidStocDevo', padresTmp, '', 'BelTipoMovimAlmacView']);
var tmalOidReguDependeceMap = new Vector();
tmalOidReguDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmalOidReguDependeceMap.agregar(['tmalOidRegu', padresTmp, '', 'BelTipoMovimAlmacView']);
var tmalOidReguSapDependeceMap = new Vector();
tmalOidReguSapDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmalOidReguSapDependeceMap.agregar(['tmalOidReguSap', padresTmp, '', 'BelTipoMovimAlmacView']);
var tmalOidDevoStocDependeceMap = new Vector();
tmalOidDevoStocDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmalOidDevoStocDependeceMap.agregar(['tmalOidDevoStoc', padresTmp, '', 'BelTipoMovimAlmacView']);
var tmalOidPetiExisDependeceMap = new Vector();
tmalOidPetiExisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
tmalOidPetiExisDependeceMap.agregar(['tmalOidPetiExis', padresTmp, '', 'BelTipoMovimAlmacView']);
var paisOidPaisDependeceMap = new Vector();
paisOidPaisDependeceMap.cargar([['','','','']]);
padresTmp =  new Vector();
padresTmp.cargar([])
paisOidPaisDependeceMap.agregar(['paisOidPais', padresTmp, '', 'SegPaisView']);

	
//variable conreferencia al obejto usado para devolver los resultados de una búsqueda lov
belParamBelceLovReturnParameters = null;

//varible temporal donde se almacenan el valor del registro que se está modifica para chequear
//que no se pierden datos
var belParamBelceTmpUpdateValues;



//Función ejecutada en el onload de la pagina
function belParamBelceInitComponents(){
	//Deshabilitamos la limpieza genérica del formulario
	varNoLimpiarSICC = false;

	//Inicalizamos el estado del menú secundario
	configurarMenuSecundario('belParamBelceFrm');

	//Encogemos las capas de resultados y botones
	minimizeLayers();
	
	//Guardamos los valores de los campos para poder recuperarlos tras una operación de limpiar
	populateForm2Js();
	
	//Simplemente analiza el tipo de acción a realizar y llama a la función correspondiente
	switch(get('belParamBelceFrm.accion')){
		case "query": belParamBelceQueryInitComponents(); break;
		case "view": belParamBelceViewInitComponents(); break;
		case "create": belParamBelceCreateInitComponents(); break;
		case "update": belParamBelceUpdateInitComponents(); break;
		case "remove": belParamBelceRemoveInitComponents(); break;
		case "lov": belParamBelceLovInitComponents(); break;
	}
	//alert('accion :' + get('belParamBelceFrm.accion'));
	
	//Ponemos el foco en el primer campo
	//focusFirstField('belParamBelceFrm', true);
	
	//Si hay que hacer requery lo realizamos
	if(isPerformRequery('belParamBelce')) belParamBelceCmdRequery();
}

function belParamBelceQueryInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	focusFirstField('belParamBelceFrm', true);	
}

function belParamBelceViewInitComponents(){
	//Cargamos la descripción en el idioma por defecto del usuario de los atributos internacionalizables
	
		
	
	focusFirstField('belParamBelceFrm', true);
}

function belParamBelceCreateInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Asignamos los textos de campo requerido
	setMV('belParamBelceFrm.sbacOidSbac','S', GestionarMensaje('BelParamBelce.sbacOidSbac.requiered.message'));
	
	setMV('belParamBelceFrm.valDire','S', GestionarMensaje('BelParamBelce.valDire.requiered.message'));
	
	setMV('belParamBelceFrm.valMontMaxiDife','S', GestionarMensaje('BelParamBelce.valMontMaxiDife.requiered.message'));
	
	setMV('belParamBelceFrm.valLimiEfecCaja','S', GestionarMensaje('BelParamBelce.valLimiEfecCaja.requiered.message'));
	
	setMV('belParamBelceFrm.numCaja','S', GestionarMensaje('BelParamBelce.numCaja.requiered.message'));
	
	setMV('belParamBelceFrm.valNombLoca','S', GestionarMensaje('BelParamBelce.valNombLoca.requiered.message'));
	
	setMV('belParamBelceFrm.valTiempRepo','S', GestionarMensaje('BelParamBelce.valTiempRepo.requiered.message'));
	
	setMV('belParamBelceFrm.valFactLoca','S', GestionarMensaje('BelParamBelce.valFactLoca.requiered.message'));
	
	setMV('belParamBelceFrm.numMaxiProd','S', GestionarMensaje('BelParamBelce.numMaxiProd.requiered.message'));
	
	setMV('belParamBelceFrm.valAlerStoc','S', GestionarMensaje('BelParamBelce.valAlerStoc.requiered.message'));
	
	setMV('belParamBelceFrm.valUsua','S', GestionarMensaje('BelParamBelce.valUsua.requiered.message'));
	
	setMV('belParamBelceFrm.clieOidClie','S', GestionarMensaje('BelParamBelce.clieOidClie.requiered.message'));
	
	setMV('belParamBelceFrm.sociOidSoci','S', GestionarMensaje('BelParamBelce.sociOidSoci.requiered.message'));
	
	setMV('belParamBelceFrm.ttraOidTipoTran','S', GestionarMensaje('BelParamBelce.ttraOidTipoTran.requiered.message'));
	
	setMV('belParamBelceFrm.ccbaOidCuenCorrBanc','S', GestionarMensaje('BelParamBelce.ccbaOidCuenCorrBanc.requiered.message'));
	
	setMV('belParamBelceFrm.tmvcOidCobr','S', GestionarMensaje('BelParamBelce.tmvcOidCobr.requiered.message'));
	
	setMV('belParamBelceFrm.tmvcOidCier','S', GestionarMensaje('BelParamBelce.tmvcOidCier.requiered.message'));
	
	setMV('belParamBelceFrm.tmalOidConfStoc','S', GestionarMensaje('BelParamBelce.tmalOidConfStoc.requiered.message'));
	
	setMV('belParamBelceFrm.tmalOidConfStocTran','S', GestionarMensaje('BelParamBelce.tmalOidConfStocTran.requiered.message'));
	
	setMV('belParamBelceFrm.tmalOidStocTran','S', GestionarMensaje('BelParamBelce.tmalOidStocTran.requiered.message'));
	
	setMV('belParamBelceFrm.tmalOidStocDevo','S', GestionarMensaje('BelParamBelce.tmalOidStocDevo.requiered.message'));
	
	setMV('belParamBelceFrm.tmalOidRegu','S', GestionarMensaje('BelParamBelce.tmalOidRegu.requiered.message'));
	
	setMV('belParamBelceFrm.tmalOidReguSap','S', GestionarMensaje('BelParamBelce.tmalOidReguSap.requiered.message'));
	
	setMV('belParamBelceFrm.tmalOidDevoStoc','S', GestionarMensaje('BelParamBelce.tmalOidDevoStoc.requiered.message'));
	
	setMV('belParamBelceFrm.tmalOidPetiExis','S', GestionarMensaje('BelParamBelce.tmalOidPetiExis.requiered.message'));
	
	

	//Activamos el botón de guardar de la botonera;
	parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	
	focusFirstField('belParamBelceFrm', true);
}

function belParamBelceUpdateInitComponents(){
	//Desactivamos los campos y situamos el foco en el primer campo editable
	//Dependiendo del origen menu (para buscar) o de pagina (para modificar los datos)
	//En el caso de origen == menu desactivamos lsoc ampos que no sean de búsqueda
	//En el caso de origen == pagina desactivamos los campos que no sean de modificación
	if(get('belParamBelceFrm.origen') == "pagina"){
		

		

		//Registramos el valor del elemento que estamos modificando
		belParamBelceTmpUpdateValues = belParamBelceBuildUpdateRecordString();

		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Asignamos los textos de campo requerido siempre y cuando estemos en el modo que lo requiea
		setMV('belParamBelceFrm.sbacOidSbac','S', GestionarMensaje('BelParamBelce.sbacOidSbac.requiered.message'));
		setMV('belParamBelceFrm.valDire','S', GestionarMensaje('BelParamBelce.valDire.requiered.message'));
		setMV('belParamBelceFrm.valMontMaxiDife','S', GestionarMensaje('BelParamBelce.valMontMaxiDife.requiered.message'));
		setMV('belParamBelceFrm.valLimiEfecCaja','S', GestionarMensaje('BelParamBelce.valLimiEfecCaja.requiered.message'));
		setMV('belParamBelceFrm.numCaja','S', GestionarMensaje('BelParamBelce.numCaja.requiered.message'));
		setMV('belParamBelceFrm.valNombLoca','S', GestionarMensaje('BelParamBelce.valNombLoca.requiered.message'));
		setMV('belParamBelceFrm.valTiempRepo','S', GestionarMensaje('BelParamBelce.valTiempRepo.requiered.message'));
		setMV('belParamBelceFrm.valFactLoca','S', GestionarMensaje('BelParamBelce.valFactLoca.requiered.message'));
		setMV('belParamBelceFrm.numMaxiProd','S', GestionarMensaje('BelParamBelce.numMaxiProd.requiered.message'));
		setMV('belParamBelceFrm.valAlerStoc','S', GestionarMensaje('BelParamBelce.valAlerStoc.requiered.message'));
		setMV('belParamBelceFrm.valUsua','S', GestionarMensaje('BelParamBelce.valUsua.requiered.message'));
		setMV('belParamBelceFrm.clieOidClie','S', GestionarMensaje('BelParamBelce.clieOidClie.requiered.message'));
		setMV('belParamBelceFrm.sociOidSoci','S', GestionarMensaje('BelParamBelce.sociOidSoci.requiered.message'));
		setMV('belParamBelceFrm.ttraOidTipoTran','S', GestionarMensaje('BelParamBelce.ttraOidTipoTran.requiered.message'));
		setMV('belParamBelceFrm.ccbaOidCuenCorrBanc','S', GestionarMensaje('BelParamBelce.ccbaOidCuenCorrBanc.requiered.message'));
		setMV('belParamBelceFrm.tmvcOidCobr','S', GestionarMensaje('BelParamBelce.tmvcOidCobr.requiered.message'));
		setMV('belParamBelceFrm.tmvcOidCier','S', GestionarMensaje('BelParamBelce.tmvcOidCier.requiered.message'));
		setMV('belParamBelceFrm.tmalOidConfStoc','S', GestionarMensaje('BelParamBelce.tmalOidConfStoc.requiered.message'));
		setMV('belParamBelceFrm.tmalOidConfStocTran','S', GestionarMensaje('BelParamBelce.tmalOidConfStocTran.requiered.message'));
		setMV('belParamBelceFrm.tmalOidStocTran','S', GestionarMensaje('BelParamBelce.tmalOidStocTran.requiered.message'));
		setMV('belParamBelceFrm.tmalOidStocDevo','S', GestionarMensaje('BelParamBelce.tmalOidStocDevo.requiered.message'));
		setMV('belParamBelceFrm.tmalOidRegu','S', GestionarMensaje('BelParamBelce.tmalOidRegu.requiered.message'));
		setMV('belParamBelceFrm.tmalOidReguSap','S', GestionarMensaje('BelParamBelce.tmalOidReguSap.requiered.message'));
		setMV('belParamBelceFrm.tmalOidDevoStoc','S', GestionarMensaje('BelParamBelce.tmalOidDevoStoc.requiered.message'));
		setMV('belParamBelceFrm.tmalOidPetiExis','S', GestionarMensaje('BelParamBelce.tmalOidPetiExis.requiered.message'));
		
			focusFirstFieldModify('belParamBelceFrm', true);
	}else{
		//Los campos de los atributos de tipo list los desactivamos
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		focusFirstField('belParamBelceFrm', true);
	}
	
	//Activamos el botón de guardar de la botonera solo si el origen es pagina
	if(get('belParamBelceFrm.origen') == "pagina") parent.iconos.set_estado_botonera('btnBarra',1,'activo');
	else parent.iconos.set_estado_botonera('btnBarra',1,'inactivo');
}

function belParamBelceRemoveInitComponents(){
	//Los campos de los atributos de tipo list los desactivamos
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Ponemos el criterio de multiselección a la lista de resultados
	belParamBelceList.maxSel = -1;
	
	//Desctivamos el botón de borra de la botonera. Al realizar la query se activará;
	parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
	
	focusFirstField('belParamBelceFrm', true);
}

function belParamBelceLovInitComponents(){
	belParamBelceLovReturnParameters = window.dialogArguments;
	
	focusFirstField('belParamBelceFrm', true);
}

//Funciones de apertura de dialogos de lob de los atributos de la entidad






























//Función que permite cargar los datos de un elemento de lov seleccionado
function belParamBelceSetLovSelection(campo, id, descripcion){
	//Actualizamos el valor del campo oculto y el valor de la caja de texto
	//del campo que es una lista
	set('belParamBelceFrm.' + campo, id);
	set('belParamBelceFrm.' + campo + 'LovDescription', descripcion);
	
}

//Funciones cuando la entidad es abierta en diálogo de lov
function belParamBelceLovNullSelectionAction(){
	//Indicamos en el parametro de retorno de lov que hau que poner valor null
	belParamBelceLovReturnParameters.id = '';
	belParamBelceLovReturnParameters.description = '';
	
	//Finalmente cerramos la ventana
	window.close();
}

function belParamBelceLovSelectionAction(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belParamBelceList.numSelecc() <= 0) return;


	//Determinamos el codigo del elemento seleccionado y la descripcion
	//Debido a que en la columna del choice hay codigo html habrá que limpiar para sólo coger 
	//(Esto ultimo queda comentado ya que la columna delm choice a fecha 29/10/2003 no aparece como codigo HTML)
	//el valor real
	var codigo = belParamBelceList.codSeleccionados();
	var descripcion = belParamBelceList.extraeDato(
		belParamBelceList.codSeleccionados()[0], belParamBelceChoiceColumn);
	//descripcion = descripcion.substring(descripcion.indexOf('>')+1, descripcion.lastIndexOf('<'));
	
	belParamBelceLovReturnParameters.id = codigo;
	belParamBelceLovReturnParameters.description = descripcion;

	//Finalmente cerramos la ventana
	window.close();
}

//Funciones para completar los campos to de los atributos con búqueda por intervalo


//Nos permite ejecutar la búsqueda
function belParamBelceCmdQuery(pageNumber){
	//Llamamos a la validación del formualrio. Si la validación no es true finalizamos la ejecujcion
	var isValid = ValidaForm('belParamBelceFrm', true);
	if(!isValid) return;

	//Construimos la cadena de parametros que pasamos en la función
	var parametros = generateQuery();
	
	//Añadimos el pageCount y el pageSize a los parámetros de la búsqueda
	parametros += pageNumber + "|";
	parametros += mmgPageSize;
	
	//Guardamos los parámetros de la última busqueda. (en la variable del formulario para el tema
	//de volver a la página anterior)
	set('belParamBelceFrm.lastQueryToSession', parametros);
	
	//Ponemos el cursor a wait y hacemos la llamada al conector y cargamos los datos en la combo y volvemosa poner el
	//curor al estado normal
	document.body.style.cursor='wait';
	asignar([["LISTA", "belParamBelceList", "BelParamBelceConectorTransactionQuery", 
		"result_ROWSET", parametros, "belParamBelcePostQueryActions(datos);"]], "", "");	
}

function belParamBelceCmdRequery(){
	//Vamos estableciendo en el formulario los valores de la última búsqueda
	var paramsRequery = new Vector();
	paramsRequery.token('|', get('belParamBelceFrm.lastQueryToSession'));
	var i =0;
	set('belParamBelceFrm.sbacOidSbac', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.valDire', paramsRequery.ij(i++));
	
	set('belParamBelceFrm.valTfno', paramsRequery.ij(i++));
	
	set('belParamBelceFrm.valMontMaxiDife', paramsRequery.ij(i++));
	
	set('belParamBelceFrm.valLimiEfecCaja', paramsRequery.ij(i++));
	
	set('belParamBelceFrm.numCaja', paramsRequery.ij(i++));
	
	set('belParamBelceFrm.valNombLoca', paramsRequery.ij(i++));
	
	set('belParamBelceFrm.valTiempRepo', paramsRequery.ij(i++));
	
	set('belParamBelceFrm.valFactLoca', paramsRequery.ij(i++));
	
	set('belParamBelceFrm.numMaxiProd', paramsRequery.ij(i++));
	
	set('belParamBelceFrm.valAlerStoc', paramsRequery.ij(i++));
	
	set('belParamBelceFrm.valUsua', paramsRequery.ij(i++));
	
	set('belParamBelceFrm.clieOidClie', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.sociOidSoci', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.ttraOidTipoTran', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.ccbaOidCuenCorrBanc', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.tmvcOidCobr', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.tmvcOidCier', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.tmalOidConfStoc', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.tmalOidConfStocTran', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.tmalOidStocTran', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.tmalOidStocDevo', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.tmalOidRegu', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.tmalOidReguSap', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.tmalOidDevoStoc', [paramsRequery.ij(i++)]);
	
	set('belParamBelceFrm.tmalOidPetiExis', [paramsRequery.ij(i++)]);
	
	
	
	//Establecemos la página de busqueda como la actual
	belParamBelcePageCount = paramsRequery.ij(i++);
	
	//Ejecutamos de nuevo la query
	belParamBelceCmdQuery(belParamBelcePageCount);
}

function belParamBelceFirstPage(){
	//Restemaos el contados de paginas y ejecutamos la query
	belParamBelcePageCount = 1;
	belParamBelceCmdQuery(belParamBelcePageCount);
}

function belParamBelcePreviousPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belParamBelceLastQuery){
		belParamBelceFirstPage();
		return;
	}
	
	//Disminuimos en una unidad el contador de paginas y ejecutamos la query
	belParamBelcePageCount--;
	belParamBelceCmdQuery(belParamBelcePageCount);
}

function belParamBelceNextPage(){
	//Si los parámetros de busqueda han cambiado hacemos una búsqueda de firstpage
	if(generateQuery() != belParamBelceLastQuery){
		belParamBelceFirstPage();
		return;
	}

	//Aumentamos en una unidad el contador de paginas y ejecutamos la query
	belParamBelcePageCount++;
	belParamBelceCmdQuery(belParamBelcePageCount);
}

//Esta fucnion ejecuta las acciones necesarias de realizar una vez ejecutada la query
function belParamBelcePostQueryActions(datos){
	//Primer comprovamos que hay datos. Si no hay datos lo  indicamos, ocultamos las capas,
	//que estubiesen visibles, las minimizamos y finalizamos
	if(datos.length == 0){
		document.body.style.cursor='default';
		visibilidad('belParamBelceListLayer', 'O');
		visibilidad('belParamBelceListButtonsLayer', 'O');
		if(get('belParamBelceFrm.accion') == "remove"){
			parent.iconos.set_estado_botonera('btnBarra',4,'inactivo');
		}
		resetJsAttributeVars();
		minimizeLayers();
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.query.noresults.message'));
		return;
	}
	
	//Guardamos los parámetros de la última busqueda. (en la variable javascript)
	belParamBelceLastQuery = generateQuery();

	//Antes de cargar los datos en la lista preparamos los datos
	//Las columnas que sean de tipo valores predeterminados ponemos la descripción en vez del codigo
	//Las columnas que tengan widget de tipo checkbox sustituimos el true/false por el texto en idioma
	var datosTmp = new Vector();
	datosTmp.cargar(datos);
	
		
	
	
	//Ponemos en el campo del choice un link para poder visualizar el registro (DESHABILITADO. Existe el modo view.
	//A este se accede desde el modo de consulta o desde el modo de eliminación)
	/*for(var i=0; i < datosTmp.longitud; i++){
		datosTmp.ij2("<A HREF=\'javascript:belParamBelceViewDetail(" + datosTmp.ij(i, 0) + ")\'>" + datosTmp.ij(i, belParamBelceChoiceColumn) + "</A>",
			i, belParamBelceChoiceColumn);
	}*/

	//Filtramos el resultado para coger sólo los datos correspondientes a
	//las columnas de la lista Y cargamos los datos en la lista
	belParamBelceList.setDatos(datosTmp.filtrar([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26],'*'));
	
	//La última fila de datos representa a los timestamps que debemos guardarlos
	belParamBelceTimeStamps = datosTmp.filtrar([27],'*');
	
	//SI hay mas paginas reigistramos que es así e eliminamos el último registro
	if(datosTmp.longitud > mmgPageSize){
		belParamBelceMorePagesFlag = true;
		belParamBelceList.eliminar(mmgPageSize, 1);
	}else{
		belParamBelceMorePagesFlag = false;
	}
	
	//Activamos el botón de borrar si estamos en la acción
	if(get('belParamBelceFrm.accion') == "remove")
		parent.iconos.set_estado_botonera('btnBarra',4,'activo');

	//Estiramos y hacemos visibles las capas que sean necesarias
	maximizeLayers();
	visibilidad('belParamBelceListLayer', 'V');
	visibilidad('belParamBelceListButtonsLayer', 'V');

	//Ajustamos la lista de resultados con el margen derecho de la ventana
	DrdEnsanchaConMargenDcho('belParamBelceList',20);
	eval(ON_RSZ);  

	//Es necesario realizar un repintado de la tabla debido a que hemos eliminado registro
	belParamBelceList.display();
	
	//Actualizamos el estado de los botones 
	if(belParamBelceMorePagesFlag){
		set_estado_botonera('belParamBelcePaginationButtonBar',
			3,"activo");
	}else{
		set_estado_botonera('belParamBelcePaginationButtonBar',
			3,"inactivo");
	}
	if(belParamBelcePageCount > 1){
		set_estado_botonera('belParamBelcePaginationButtonBar',
			2,"activo");
		set_estado_botonera('belParamBelcePaginationButtonBar',
			1,"activo");
	}else{
		set_estado_botonera('belParamBelcePaginationButtonBar',
			2,"inactivo");
		set_estado_botonera('belParamBelcePaginationButtonBar',
			1,"inactivo");
	}
	
	//Ponemos el cursor de vuelta a su estado normal
	document.body.style.cursor='default';
}

function belParamBelceUpdateSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belParamBelceList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.update.noselection.message'));
		return;
	}

	//Guardamos en la variable ID el id de la fila seleccionada
	set('belParamBelceFrm.idSelection', belParamBelceList.codSeleccionados()[0]);

	//Validamos el formualrio y lo enviamos. Cambiamos el ON para que vaya al startup y prepare el formulario
	//para la modificación
	var validacion = ValidaForm('belParamBelceFrm', true);
	if(validacion){
		var parametros = new Array();
		parametros["idSelection"] = belParamBelceList.codSeleccionados()[0];
		parametros["previousAction"] = get('belParamBelceFrm.accion');
		parametros["accion"] = get('belParamBelceFrm.accion');
		parametros["origen"] = 'pagina';
		
		
		
		var result = mostrarModalSICC('BelParamBelceLPStartUp', get('belParamBelceFrm.accion'), parametros, null, null);
		if(result == MMG_RC_OK) belParamBelceCmdRequery();
	}
}

function belParamBelceRemoveSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belParamBelceList.numSelecc() == 0){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.remove.noselection.message'));
		return;
	}

	//Solicitamos confirmación para borrar 
	if(cdos_mostrarConfirm(GestionarMensaje('MMGGlobal.remove.confirmation.message')) == false) return;

	//Guardamos en la variable ID el id de la fila seleccionada 
	//y enviamos el formulario
	var ids = belParamBelceList.codSeleccionados();
	var idsTmp = new Vector();
	idsTmp.cargar(ids);
	set('belParamBelceFrm.idSelection', idsTmp.unir('|'));

	//Sacamos los timestamps
	var timestamps = '';
	var idsSeleccionados = new Vector();
	var datosList = new Vector();
	idsSeleccionados.cargar(ids);
	datosList.cargar(belParamBelceList.datos);
	for(var i=0; i< idsSeleccionados.longitud; i++){
		timestamps += belParamBelceTimeStamps[
			datosList.buscar(idsSeleccionados.ij(i),0)][0] + '|';
	}
	timestamps = timestamps.substr(0, timestamps.length-1);
	set('belParamBelceFrm.timestamp', timestamps);


	belParamBelceFrm.oculto='S';
	envia('belParamBelceFrm');
	belParamBelceFrm.oculto='N';
}

function belParamBelceViewSelection(){
	//Si no se ha seleccionado ningún elemento no hacemos nada
	if(belParamBelceList.numSelecc() != 1){
		cdos_mostrarAlert(GestionarMensaje('MMGGlobal.view.singleselection.message'));
		return;
	}
	
	//Enviamos el formualrio
	belParamBelceViewDetail(belParamBelceList.codSeleccionados()[0]);
}

//Esta función nos permite abrir un dialogo que permite visualiza un registro determianado
function belParamBelceViewDetail(idRegistro){
	//Abrimos ventana modal en modo de detalle pasando como parametros el id del elemento seleccionado
	//y los parametros de acción, origen y previousAction para que la lp de startup pueda determinar el modo
	var parametros = new Array();
	parametros["idSelection"] = idRegistro;
	parametros["previousAction"] = get('belParamBelceFrm.accion');
	parametros["accion"] = 'view'
	parametros["origen"] = 'pagina';
	
	
	mostrarModalSICC('BelParamBelceLPStartUp', 'view', parametros, null, null);
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
	var validacion = ValidaForm('belParamBelceFrm', true);
	setNonEditableElementsStatus(true);
	
	//Si ha habido un pete volvemos
	if(!validacion) return;
	
	//Determinamos que los campos internacionalizables requeridos tengan valor y que se haya dado
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
	if(validacion){
		belParamBelceFrm.oculto='S';
		envia('belParamBelceFrm');
		belParamBelceFrm.oculto='N';
	}
}

function Limpiar(){
	//Recuperamos los valores que tenía el formaulario al cargar la pantalla
	populateJs2Form();
	
	//Si los valores raices de las combos de una generarquía de dependencia no tienen valor
	//limpiamops el resto de combos
	if(get('belParamBelceFrm.sbacOidSbac').toString() == ''){
		set('belParamBelceFrm.sbacOidSbac_acceOidAcce_canaOidCana', []);
		mmgResetCombosOnCascade('sbacOidSbac_acceOidAcce_canaOidCana', 'sbacOidSbac', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.clieOidClie').toString() == ''){
		set('belParamBelceFrm.clieOidClie', []);
		mmgResetCombosOnCascade('clieOidClie', 'clieOidClie', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.sociOidSoci').toString() == ''){
		set('belParamBelceFrm.sociOidSoci', []);
		mmgResetCombosOnCascade('sociOidSoci', 'sociOidSoci', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.ttraOidTipoTran').toString() == ''){
		set('belParamBelceFrm.ttraOidTipoTran', []);
		mmgResetCombosOnCascade('ttraOidTipoTran', 'ttraOidTipoTran', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.ccbaOidCuenCorrBanc').toString() == ''){
		set('belParamBelceFrm.ccbaOidCuenCorrBanc_cucoOidCcPnte', []);
		mmgResetCombosOnCascade('ccbaOidCuenCorrBanc_cucoOidCcPnte', 'ccbaOidCuenCorrBanc', 'belParamBelce');
		set('belParamBelceFrm.ccbaOidCuenCorrBanc_sociOidSoci', []);
		mmgResetCombosOnCascade('ccbaOidCuenCorrBanc_sociOidSoci', 'ccbaOidCuenCorrBanc', 'belParamBelce');
		set('belParamBelceFrm.ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc', []);
		mmgResetCombosOnCascade('ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc', 'ccbaOidCuenCorrBanc', 'belParamBelce');
		set('belParamBelceFrm.ccbaOidCuenCorrBanc_cucoOidCcTeso', []);
		mmgResetCombosOnCascade('ccbaOidCuenCorrBanc_cucoOidCcTeso', 'ccbaOidCuenCorrBanc', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.tmvcOidCobr').toString() == ''){
		set('belParamBelceFrm.tmvcOidCobr', []);
		mmgResetCombosOnCascade('tmvcOidCobr', 'tmvcOidCobr', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.tmvcOidCier').toString() == ''){
		set('belParamBelceFrm.tmvcOidCier', []);
		mmgResetCombosOnCascade('tmvcOidCier', 'tmvcOidCier', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.tmalOidConfStoc').toString() == ''){
		set('belParamBelceFrm.tmalOidConfStoc', []);
		mmgResetCombosOnCascade('tmalOidConfStoc', 'tmalOidConfStoc', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.tmalOidConfStocTran').toString() == ''){
		set('belParamBelceFrm.tmalOidConfStocTran', []);
		mmgResetCombosOnCascade('tmalOidConfStocTran', 'tmalOidConfStocTran', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.tmalOidStocTran').toString() == ''){
		set('belParamBelceFrm.tmalOidStocTran', []);
		mmgResetCombosOnCascade('tmalOidStocTran', 'tmalOidStocTran', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.tmalOidStocDevo').toString() == ''){
		set('belParamBelceFrm.tmalOidStocDevo', []);
		mmgResetCombosOnCascade('tmalOidStocDevo', 'tmalOidStocDevo', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.tmalOidRegu').toString() == ''){
		set('belParamBelceFrm.tmalOidRegu', []);
		mmgResetCombosOnCascade('tmalOidRegu', 'tmalOidRegu', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.tmalOidReguSap').toString() == ''){
		set('belParamBelceFrm.tmalOidReguSap', []);
		mmgResetCombosOnCascade('tmalOidReguSap', 'tmalOidReguSap', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.tmalOidDevoStoc').toString() == ''){
		set('belParamBelceFrm.tmalOidDevoStoc', []);
		mmgResetCombosOnCascade('tmalOidDevoStoc', 'tmalOidDevoStoc', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.tmalOidPetiExis').toString() == ''){
		set('belParamBelceFrm.tmalOidPetiExis', []);
		mmgResetCombosOnCascade('tmalOidPetiExis', 'tmalOidPetiExis', 'belParamBelce');
		
	}
	if(get('belParamBelceFrm.paisOidPais').toString() == ''){
		set('belParamBelceFrm.paisOidPais', []);
		mmgResetCombosOnCascade('paisOidPais', 'paisOidPais', 'belParamBelce');
		
	}
	
	
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de eliminar
function Borrar(){
	belParamBelceRemoveSelection();
}

//Función que se ejecuta cuando en la botonera se pulsa el botón de volver
function Volver(){
	var accionTmp = get('belParamBelceFrm.accion');
	var origenTmp = get('belParamBelceFrm.origen');
	
	//Si estamo en modo de view el volver hacia atrás significa ejecutar un requery sobre el modo anterior
	//Si no simplemente es volver para atrás
	if(accionTmp == 'update' && origenTmp == 'pagina'){
		//chequemaos que no se vaya a perder cambios 
		if(belParamBelceBuildUpdateRecordString() != belParamBelceTmpUpdateValues){
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
	document.all.belParamBelceListLayer.style.display='none';
	document.all.belParamBelceListButtonsLayer.style.display='none';
}

function maximizeLayers(){
	document.all.belParamBelceListLayer.style.display='';
	document.all.belParamBelceListButtonsLayer.style.display='';
}

//Esta función genera los parametros de la búsqueda
function generateQuery(){
	//Determinamos los valores para realziar la búsqueda
	jsBelParamBelceSbacOidSbac = get('belParamBelceFrm.sbacOidSbac')[0];
	jsBelParamBelceValDire = get('belParamBelceFrm.valDire').toString();
	jsBelParamBelceValTfno = get('belParamBelceFrm.valTfno').toString();
	jsBelParamBelceValMontMaxiDife = get('belParamBelceFrm.valMontMaxiDife').toString();
	jsBelParamBelceValLimiEfecCaja = get('belParamBelceFrm.valLimiEfecCaja').toString();
	jsBelParamBelceNumCaja = get('belParamBelceFrm.numCaja').toString();
	jsBelParamBelceValNombLoca = get('belParamBelceFrm.valNombLoca').toString();
	jsBelParamBelceValTiempRepo = get('belParamBelceFrm.valTiempRepo').toString();
	jsBelParamBelceValFactLoca = get('belParamBelceFrm.valFactLoca').toString();
	jsBelParamBelceNumMaxiProd = get('belParamBelceFrm.numMaxiProd').toString();
	jsBelParamBelceValAlerStoc = get('belParamBelceFrm.valAlerStoc').toString();
	jsBelParamBelceValUsua = get('belParamBelceFrm.valUsua').toString();
	jsBelParamBelceClieOidClie = get('belParamBelceFrm.clieOidClie')[0];
	jsBelParamBelceSociOidSoci = get('belParamBelceFrm.sociOidSoci')[0];
	jsBelParamBelceTtraOidTipoTran = get('belParamBelceFrm.ttraOidTipoTran')[0];
	jsBelParamBelceCcbaOidCuenCorrBanc = get('belParamBelceFrm.ccbaOidCuenCorrBanc')[0];
	jsBelParamBelceTmvcOidCobr = get('belParamBelceFrm.tmvcOidCobr')[0];
	jsBelParamBelceTmvcOidCier = get('belParamBelceFrm.tmvcOidCier')[0];
	jsBelParamBelceTmalOidConfStoc = get('belParamBelceFrm.tmalOidConfStoc')[0];
	jsBelParamBelceTmalOidConfStocTran = get('belParamBelceFrm.tmalOidConfStocTran')[0];
	jsBelParamBelceTmalOidStocTran = get('belParamBelceFrm.tmalOidStocTran')[0];
	jsBelParamBelceTmalOidStocDevo = get('belParamBelceFrm.tmalOidStocDevo')[0];
	jsBelParamBelceTmalOidRegu = get('belParamBelceFrm.tmalOidRegu')[0];
	jsBelParamBelceTmalOidReguSap = get('belParamBelceFrm.tmalOidReguSap')[0];
	jsBelParamBelceTmalOidDevoStoc = get('belParamBelceFrm.tmalOidDevoStoc')[0];
	jsBelParamBelceTmalOidPetiExis = get('belParamBelceFrm.tmalOidPetiExis')[0];
	
	
	var parametros = "";
	parametros += jsBelParamBelceSbacOidSbac + "|";
	parametros += jsBelParamBelceValDire + "|";
	parametros += jsBelParamBelceValTfno + "|";
	parametros += jsBelParamBelceValMontMaxiDife + "|";
	parametros += jsBelParamBelceValLimiEfecCaja + "|";
	parametros += jsBelParamBelceNumCaja + "|";
	parametros += jsBelParamBelceValNombLoca + "|";
	parametros += jsBelParamBelceValTiempRepo + "|";
	parametros += jsBelParamBelceValFactLoca + "|";
	parametros += jsBelParamBelceNumMaxiProd + "|";
	parametros += jsBelParamBelceValAlerStoc + "|";
	parametros += jsBelParamBelceValUsua + "|";
	parametros += jsBelParamBelceClieOidClie + "|";
	parametros += jsBelParamBelceSociOidSoci + "|";
	parametros += jsBelParamBelceTtraOidTipoTran + "|";
	parametros += jsBelParamBelceCcbaOidCuenCorrBanc + "|";
	parametros += jsBelParamBelceTmvcOidCobr + "|";
	parametros += jsBelParamBelceTmvcOidCier + "|";
	parametros += jsBelParamBelceTmalOidConfStoc + "|";
	parametros += jsBelParamBelceTmalOidConfStocTran + "|";
	parametros += jsBelParamBelceTmalOidStocTran + "|";
	parametros += jsBelParamBelceTmalOidStocDevo + "|";
	parametros += jsBelParamBelceTmalOidRegu + "|";
	parametros += jsBelParamBelceTmalOidReguSap + "|";
	parametros += jsBelParamBelceTmalOidDevoStoc + "|";
	parametros += jsBelParamBelceTmalOidPetiExis + "|";
	
	return parametros;
}

//Esta función nos permite obteber los valore del formulario cuando está en modo de update form
//El metodo esta pensado para saber si se han modificado los campos
function belParamBelceBuildUpdateRecordString(){
	//Sacamos los valores del formulario
	populateForm2Js();

	var parametros = "";
	parametros += jsBelParamBelceSbacOidSbac + "|";
	parametros += jsBelParamBelceValDire + "|";
	parametros += jsBelParamBelceValTfno + "|";
	parametros += jsBelParamBelceValMontMaxiDife + "|";
	parametros += jsBelParamBelceValLimiEfecCaja + "|";
	parametros += jsBelParamBelceNumCaja + "|";
	parametros += jsBelParamBelceValNombLoca + "|";
	parametros += jsBelParamBelceValTiempRepo + "|";
	parametros += jsBelParamBelceValFactLoca + "|";
	parametros += jsBelParamBelceNumMaxiProd + "|";
	parametros += jsBelParamBelceValAlerStoc + "|";
	parametros += jsBelParamBelceValUsua + "|";
	parametros += jsBelParamBelceClieOidClie + "|";
	parametros += jsBelParamBelceSociOidSoci + "|";
	parametros += jsBelParamBelceTtraOidTipoTran + "|";
	parametros += jsBelParamBelceCcbaOidCuenCorrBanc + "|";
	parametros += jsBelParamBelceTmvcOidCobr + "|";
	parametros += jsBelParamBelceTmvcOidCier + "|";
	parametros += jsBelParamBelceTmalOidConfStoc + "|";
	parametros += jsBelParamBelceTmalOidConfStocTran + "|";
	parametros += jsBelParamBelceTmalOidStocTran + "|";
	parametros += jsBelParamBelceTmalOidStocDevo + "|";
	parametros += jsBelParamBelceTmalOidRegu + "|";
	parametros += jsBelParamBelceTmalOidReguSap + "|";
	parametros += jsBelParamBelceTmalOidDevoStoc + "|";
	parametros += jsBelParamBelceTmalOidPetiExis + "|";
	
	return parametros;
}

//Nos permite volcar todos los valores del formulario a variables javascript
function populateForm2Js(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belParamBelceFrm.accion'), 
		get('belParamBelceFrm.origen'));
	
	jsBelParamBelceId = get('belParamBelceFrm.id').toString();
	jsBelParamBelceSbacOidSbac = get('belParamBelceFrm.sbacOidSbac')[0];
	jsBelParamBelceValDire = get('belParamBelceFrm.valDire').toString();
	jsBelParamBelceValTfno = get('belParamBelceFrm.valTfno').toString();
	jsBelParamBelceValMontMaxiDife = get('belParamBelceFrm.valMontMaxiDife').toString();
	jsBelParamBelceValLimiEfecCaja = get('belParamBelceFrm.valLimiEfecCaja').toString();
	jsBelParamBelceNumCaja = get('belParamBelceFrm.numCaja').toString();
	jsBelParamBelceValNombLoca = get('belParamBelceFrm.valNombLoca').toString();
	jsBelParamBelceValTiempRepo = get('belParamBelceFrm.valTiempRepo').toString();
	jsBelParamBelceValFactLoca = get('belParamBelceFrm.valFactLoca').toString();
	jsBelParamBelceNumMaxiProd = get('belParamBelceFrm.numMaxiProd').toString();
	jsBelParamBelceValAlerStoc = get('belParamBelceFrm.valAlerStoc').toString();
	jsBelParamBelceValUsua = get('belParamBelceFrm.valUsua').toString();
	jsBelParamBelceClieOidClie = get('belParamBelceFrm.clieOidClie')[0];
	jsBelParamBelceSociOidSoci = get('belParamBelceFrm.sociOidSoci')[0];
	jsBelParamBelceTtraOidTipoTran = get('belParamBelceFrm.ttraOidTipoTran')[0];
	jsBelParamBelceCcbaOidCuenCorrBanc = get('belParamBelceFrm.ccbaOidCuenCorrBanc')[0];
	jsBelParamBelceTmvcOidCobr = get('belParamBelceFrm.tmvcOidCobr')[0];
	jsBelParamBelceTmvcOidCier = get('belParamBelceFrm.tmvcOidCier')[0];
	jsBelParamBelceTmalOidConfStoc = get('belParamBelceFrm.tmalOidConfStoc')[0];
	jsBelParamBelceTmalOidConfStocTran = get('belParamBelceFrm.tmalOidConfStocTran')[0];
	jsBelParamBelceTmalOidStocTran = get('belParamBelceFrm.tmalOidStocTran')[0];
	jsBelParamBelceTmalOidStocDevo = get('belParamBelceFrm.tmalOidStocDevo')[0];
	jsBelParamBelceTmalOidRegu = get('belParamBelceFrm.tmalOidRegu')[0];
	jsBelParamBelceTmalOidReguSap = get('belParamBelceFrm.tmalOidReguSap')[0];
	jsBelParamBelceTmalOidDevoStoc = get('belParamBelceFrm.tmalOidDevoStoc')[0];
	jsBelParamBelceTmalOidPetiExis = get('belParamBelceFrm.tmalOidPetiExis')[0];
	jsBelParamBelcePaisOidPais = get('belParamBelceFrm.paisOidPais')[0];
	
}

//Nos permite volcar los valores de las variables js al formulario
function populateJs2Form(){
	//Primero determinamos el modo en el que estamos;
	var mode = getMMGMode(get('belParamBelceFrm.accion'), 
		get('belParamBelceFrm.origen'));


	set('belParamBelceFrm.id', jsBelParamBelceId);
	set('belParamBelceFrm.sbacOidSbac', [jsBelParamBelceSbacOidSbac]);
	set('belParamBelceFrm.valDire', jsBelParamBelceValDire);
	set('belParamBelceFrm.valTfno', jsBelParamBelceValTfno);
	set('belParamBelceFrm.valMontMaxiDife', jsBelParamBelceValMontMaxiDife);
	set('belParamBelceFrm.valLimiEfecCaja', jsBelParamBelceValLimiEfecCaja);
	set('belParamBelceFrm.numCaja', jsBelParamBelceNumCaja);
	set('belParamBelceFrm.valNombLoca', jsBelParamBelceValNombLoca);
	set('belParamBelceFrm.valTiempRepo', jsBelParamBelceValTiempRepo);
	set('belParamBelceFrm.valFactLoca', jsBelParamBelceValFactLoca);
	set('belParamBelceFrm.numMaxiProd', jsBelParamBelceNumMaxiProd);
	set('belParamBelceFrm.valAlerStoc', jsBelParamBelceValAlerStoc);
	set('belParamBelceFrm.valUsua', jsBelParamBelceValUsua);
	set('belParamBelceFrm.clieOidClie', [jsBelParamBelceClieOidClie]);
	set('belParamBelceFrm.sociOidSoci', [jsBelParamBelceSociOidSoci]);
	set('belParamBelceFrm.ttraOidTipoTran', [jsBelParamBelceTtraOidTipoTran]);
	set('belParamBelceFrm.ccbaOidCuenCorrBanc', [jsBelParamBelceCcbaOidCuenCorrBanc]);
	set('belParamBelceFrm.tmvcOidCobr', [jsBelParamBelceTmvcOidCobr]);
	set('belParamBelceFrm.tmvcOidCier', [jsBelParamBelceTmvcOidCier]);
	set('belParamBelceFrm.tmalOidConfStoc', [jsBelParamBelceTmalOidConfStoc]);
	set('belParamBelceFrm.tmalOidConfStocTran', [jsBelParamBelceTmalOidConfStocTran]);
	set('belParamBelceFrm.tmalOidStocTran', [jsBelParamBelceTmalOidStocTran]);
	set('belParamBelceFrm.tmalOidStocDevo', [jsBelParamBelceTmalOidStocDevo]);
	set('belParamBelceFrm.tmalOidRegu', [jsBelParamBelceTmalOidRegu]);
	set('belParamBelceFrm.tmalOidReguSap', [jsBelParamBelceTmalOidReguSap]);
	set('belParamBelceFrm.tmalOidDevoStoc', [jsBelParamBelceTmalOidDevoStoc]);
	set('belParamBelceFrm.tmalOidPetiExis', [jsBelParamBelceTmalOidPetiExis]);
	set('belParamBelceFrm.paisOidPais', [jsBelParamBelcePaisOidPais]);
	
}

//Limpia los valores de la variables js correspondientes a los campos del formulario
function resetJsAttributeVars(){
	//Determinamos los valores para realizar la búsqueda
	jsBelParamBelceSbacOidSbac = '';
	jsBelParamBelceValDire = '';
	jsBelParamBelceValTfno = '';
	jsBelParamBelceValMontMaxiDife = '';
	jsBelParamBelceValLimiEfecCaja = '';
	jsBelParamBelceNumCaja = '';
	jsBelParamBelceValNombLoca = '';
	jsBelParamBelceValTiempRepo = '';
	jsBelParamBelceValFactLoca = '';
	jsBelParamBelceNumMaxiProd = '';
	jsBelParamBelceValAlerStoc = '';
	jsBelParamBelceValUsua = '';
	jsBelParamBelceClieOidClie = '';
	jsBelParamBelceSociOidSoci = '';
	jsBelParamBelceTtraOidTipoTran = '';
	jsBelParamBelceCcbaOidCuenCorrBanc = '';
	jsBelParamBelceTmvcOidCobr = '';
	jsBelParamBelceTmvcOidCier = '';
	jsBelParamBelceTmalOidConfStoc = '';
	jsBelParamBelceTmalOidConfStocTran = '';
	jsBelParamBelceTmalOidStocTran = '';
	jsBelParamBelceTmalOidStocDevo = '';
	jsBelParamBelceTmalOidRegu = '';
	jsBelParamBelceTmalOidReguSap = '';
	jsBelParamBelceTmalOidDevoStoc = '';
	jsBelParamBelceTmalOidPetiExis = '';
	
}

//Permite disprar una acción para mostrar un error
function fireErrorDialog(errorCode, description, severity){
	set('belParamBelceFrm.errCodigo', errorCode);
	set('belParamBelceFrm.errDescripcion', description);
	set('belParamBelceFrm.errSeverity', severity);
	fMostrarMensajeError();
}
