

/*
    INDRA/CAR/mmg
    $Id: BelParamBelceLPExecution.java,v 1.1 2009/12/03 18:41:03 pecbazalar Exp $
    DESC
*/

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.druida.belcorp.MMGDruidaBase;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGException;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.i18n.Idioma;
import es.indra.utils.FormatUtils;
import java.util.HashMap;
import java.text.DecimalFormatSymbols;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.belcorp.mso.*;

public class BelParamBelceLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGBelParamBelceCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGBelParamBelceUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGBelParamBelceRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGBelParamBelceQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "BelParamBelceConectorCreate";
	public static final String CONECTOR_UPDATE = "BelParamBelceConectorUpdate";
	public static final String CONECTOR_REMOVE = "BelParamBelceConectorRemove";

	public BelParamBelceLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("BelParamBelcePage");
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		//Activamos las trazas
		setTrazaFichero();
	
		try{
			//Sacamos la acción a realizar y ejecutamos la acción correspondiente
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			
			//Caragamos los elemetnos en la pagina
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
	
			//Ejecutamos la acción indicada
			if(accion.equals(ACCION_CREATE)) cmdCreate();
			if(accion.equals(ACCION_UPDATE)) cmdUpdate();
			if(accion.equals(ACCION_REMOVE)) cmdRemove();
		}catch(Exception e){
			handleException(e);
		}
  }
  
  /**Permite crear un nuevo elemento de la entidad. Invoca la lógica de negocio
  	correspondiente a la creación de un/a nuevo BelParamBelce*/  
	protected void cmdCreate() throws Exception{
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
		Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		traza("datePattern" + datePattern);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator.charAt(0));
		symbols.setGroupingSeparator(separadorMiles.charAt(0));	
		
		traza("MMG::Creando BelParamBelce");
		
		String sbacOidSbac = conectorParametro("sbacOidSbac").trim();
		traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
		
		String valDire = conectorParametro("valDire").trim();
		traza("MMG:: Valor de atributo valDire: " + valDire);
		
		String valTfno = conectorParametro("valTfno").trim();
		traza("MMG:: Valor de atributo valTfno: " + valTfno);
		
		String valMontMaxiDife = conectorParametro("valMontMaxiDife").trim();
		traza("MMG:: Valor de atributo valMontMaxiDife: " + valMontMaxiDife);
		
		String valLimiEfecCaja = conectorParametro("valLimiEfecCaja").trim();
		traza("MMG:: Valor de atributo valLimiEfecCaja: " + valLimiEfecCaja);
		
		String numCaja = conectorParametro("numCaja").trim();
		traza("MMG:: Valor de atributo numCaja: " + numCaja);
		
		String valNombLoca = conectorParametro("valNombLoca").trim();
		traza("MMG:: Valor de atributo valNombLoca: " + valNombLoca);
		
		String valTiempRepo = conectorParametro("valTiempRepo").trim();
		traza("MMG:: Valor de atributo valTiempRepo: " + valTiempRepo);
		
		String valFactLoca = conectorParametro("valFactLoca").trim();
		traza("MMG:: Valor de atributo valFactLoca: " + valFactLoca);
		
		String numMaxiProd = conectorParametro("numMaxiProd").trim();
		traza("MMG:: Valor de atributo numMaxiProd: " + numMaxiProd);
		
		String valAlerStoc = conectorParametro("valAlerStoc").trim();
		traza("MMG:: Valor de atributo valAlerStoc: " + valAlerStoc);
		
		String valUsua = conectorParametro("valUsua").trim();
		traza("MMG:: Valor de atributo valUsua: " + valUsua);
		
		String clieOidClie = conectorParametro("clieOidClie").trim();
		traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
		
		String sociOidSoci = conectorParametro("sociOidSoci").trim();
		traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
		
		String ttraOidTipoTran = conectorParametro("ttraOidTipoTran").trim();
		traza("MMG:: Valor de atributo ttraOidTipoTran: " + ttraOidTipoTran);
		
		String ccbaOidCuenCorrBanc = conectorParametro("ccbaOidCuenCorrBanc").trim();
		traza("MMG:: Valor de atributo ccbaOidCuenCorrBanc: " + ccbaOidCuenCorrBanc);
		
		String tmvcOidCobr = conectorParametro("tmvcOidCobr").trim();
		traza("MMG:: Valor de atributo tmvcOidCobr: " + tmvcOidCobr);
		
		String tmvcOidCier = conectorParametro("tmvcOidCier").trim();
		traza("MMG:: Valor de atributo tmvcOidCier: " + tmvcOidCier);
		
		String tmalOidConfStoc = conectorParametro("tmalOidConfStoc").trim();
		traza("MMG:: Valor de atributo tmalOidConfStoc: " + tmalOidConfStoc);
		
		String tmalOidConfStocTran = conectorParametro("tmalOidConfStocTran").trim();
		traza("MMG:: Valor de atributo tmalOidConfStocTran: " + tmalOidConfStocTran);
		
		String tmalOidStocTran = conectorParametro("tmalOidStocTran").trim();
		traza("MMG:: Valor de atributo tmalOidStocTran: " + tmalOidStocTran);
		
		String tmalOidStocDevo = conectorParametro("tmalOidStocDevo").trim();
		traza("MMG:: Valor de atributo tmalOidStocDevo: " + tmalOidStocDevo);
		
		String tmalOidRegu = conectorParametro("tmalOidRegu").trim();
		traza("MMG:: Valor de atributo tmalOidRegu: " + tmalOidRegu);
		
		String tmalOidReguSap = conectorParametro("tmalOidReguSap").trim();
		traza("MMG:: Valor de atributo tmalOidReguSap: " + tmalOidReguSap);
		
		String tmalOidDevoStoc = conectorParametro("tmalOidDevoStoc").trim();
		traza("MMG:: Valor de atributo tmalOidDevoStoc: " + tmalOidDevoStoc);
		
		String tmalOidPetiExis = conectorParametro("tmalOidPetiExis").trim();
		traza("MMG:: Valor de atributo tmalOidPetiExis: " + tmalOidPetiExis);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		BelParamBelceData belParamBelce= new BelParamBelceData();
		es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
		if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
			sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
			sbacOidSbacData.setId(new Long(sbacOidSbac));
		}
		belParamBelce.setSbacOidSbac(sbacOidSbacData);
		belParamBelce.setValDire(
			(java.lang.String)FormatUtils.parseObject(valDire, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValTfno(
			(java.lang.String)FormatUtils.parseObject(valTfno, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValMontMaxiDife(
			(java.lang.Double)FormatUtils.parseObject(valMontMaxiDife, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValLimiEfecCaja(
			(java.lang.Double)FormatUtils.parseObject(valLimiEfecCaja, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setNumCaja(
			(java.lang.Long)FormatUtils.parseObject(numCaja, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValNombLoca(
			(java.lang.String)FormatUtils.parseObject(valNombLoca, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValTiempRepo(
			(java.lang.Long)FormatUtils.parseObject(valTiempRepo, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValFactLoca(
			(java.lang.Double)FormatUtils.parseObject(valFactLoca, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setNumMaxiProd(
			(java.lang.Long)FormatUtils.parseObject(numMaxiProd, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValAlerStoc(
			(java.lang.Long)FormatUtils.parseObject(valAlerStoc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValUsua(
			(java.lang.String)FormatUtils.parseObject(valUsua, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.MaeClienViewData clieOidClieData = null;
		if(clieOidClie != null && !clieOidClie.trim().equals("")){
			clieOidClieData = new es.indra.belcorp.mso.MaeClienViewData();
			clieOidClieData.setId(new Long(clieOidClie));
		}
		belParamBelce.setClieOidClie(clieOidClieData);
		es.indra.belcorp.mso.SegSocieViewData sociOidSociData = null;
		if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
			sociOidSociData = new es.indra.belcorp.mso.SegSocieViewData();
			sociOidSociData.setId(new Long(sociOidSoci));
		}
		belParamBelce.setSociOidSoci(sociOidSociData);
		es.indra.belcorp.mso.CccTipoTransViewData ttraOidTipoTranData = null;
		if(ttraOidTipoTran != null && !ttraOidTipoTran.trim().equals("")){
			ttraOidTipoTranData = new es.indra.belcorp.mso.CccTipoTransViewData();
			ttraOidTipoTranData.setId(new Long(ttraOidTipoTran));
		}
		belParamBelce.setTtraOidTipoTran(ttraOidTipoTranData);
		es.indra.belcorp.mso.CccCuentCorriBancaData ccbaOidCuenCorrBancData = null;
		if(ccbaOidCuenCorrBanc != null && !ccbaOidCuenCorrBanc.trim().equals("")){
			ccbaOidCuenCorrBancData = new es.indra.belcorp.mso.CccCuentCorriBancaData();
			ccbaOidCuenCorrBancData.setId(new Long(ccbaOidCuenCorrBanc));
		}
		belParamBelce.setCcbaOidCuenCorrBanc(ccbaOidCuenCorrBancData);
		es.indra.belcorp.mso.BelTipoMovimCajaData tmvcOidCobrData = null;
		if(tmvcOidCobr != null && !tmvcOidCobr.trim().equals("")){
			tmvcOidCobrData = new es.indra.belcorp.mso.BelTipoMovimCajaData();
			tmvcOidCobrData.setId(new Long(tmvcOidCobr));
		}
		belParamBelce.setTmvcOidCobr(tmvcOidCobrData);
		es.indra.belcorp.mso.BelTipoMovimCajaData tmvcOidCierData = null;
		if(tmvcOidCier != null && !tmvcOidCier.trim().equals("")){
			tmvcOidCierData = new es.indra.belcorp.mso.BelTipoMovimCajaData();
			tmvcOidCierData.setId(new Long(tmvcOidCier));
		}
		belParamBelce.setTmvcOidCier(tmvcOidCierData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidConfStocData = null;
		if(tmalOidConfStoc != null && !tmalOidConfStoc.trim().equals("")){
			tmalOidConfStocData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidConfStocData.setId(new Long(tmalOidConfStoc));
		}
		belParamBelce.setTmalOidConfStoc(tmalOidConfStocData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidConfStocTranData = null;
		if(tmalOidConfStocTran != null && !tmalOidConfStocTran.trim().equals("")){
			tmalOidConfStocTranData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidConfStocTranData.setId(new Long(tmalOidConfStocTran));
		}
		belParamBelce.setTmalOidConfStocTran(tmalOidConfStocTranData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidStocTranData = null;
		if(tmalOidStocTran != null && !tmalOidStocTran.trim().equals("")){
			tmalOidStocTranData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidStocTranData.setId(new Long(tmalOidStocTran));
		}
		belParamBelce.setTmalOidStocTran(tmalOidStocTranData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidStocDevoData = null;
		if(tmalOidStocDevo != null && !tmalOidStocDevo.trim().equals("")){
			tmalOidStocDevoData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidStocDevoData.setId(new Long(tmalOidStocDevo));
		}
		belParamBelce.setTmalOidStocDevo(tmalOidStocDevoData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidReguData = null;
		if(tmalOidRegu != null && !tmalOidRegu.trim().equals("")){
			tmalOidReguData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidReguData.setId(new Long(tmalOidRegu));
		}
		belParamBelce.setTmalOidRegu(tmalOidReguData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidReguSapData = null;
		if(tmalOidReguSap != null && !tmalOidReguSap.trim().equals("")){
			tmalOidReguSapData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidReguSapData.setId(new Long(tmalOidReguSap));
		}
		belParamBelce.setTmalOidReguSap(tmalOidReguSapData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidDevoStocData = null;
		if(tmalOidDevoStoc != null && !tmalOidDevoStoc.trim().equals("")){
			tmalOidDevoStocData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidDevoStocData.setId(new Long(tmalOidDevoStoc));
		}
		belParamBelce.setTmalOidDevoStoc(tmalOidDevoStocData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidPetiExisData = null;
		if(tmalOidPetiExis != null && !tmalOidPetiExis.trim().equals("")){
			tmalOidPetiExisData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidPetiExisData.setId(new Long(tmalOidPetiExis));
		}
		belParamBelce.setTmalOidPetiExis(tmalOidPetiExisData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("belParamBelce", belParamBelce);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(belParamBelce);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad BelParamBelce");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad BelParamBelce");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(belParamBelce);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("BelParamBelceLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
	        Long loidPais = UtilidadesSession.getPais(this);
	        userProperties.put("loidPais",loidPais);

		String datePattern = UtilidadesSession.getFormatoFecha(this);
		traza("datePattern" + datePattern);
		String decimalSeparator = UtilidadesSession.getSeparadorDecimales(this);
		String decimales = UtilidadesSession.getFormatoNumerico(this);
		String separadorMiles = decimalSeparator.equals(".") ? "," : ".";		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(decimalSeparator.charAt(0));
		symbols.setGroupingSeparator(separadorMiles.charAt(0));	
		traza("MMG::Creando BelParamBelce");
		
		String sbacOidSbac = conectorParametro("sbacOidSbac").trim();
		traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
		
		String valDire = conectorParametro("valDire").trim();
		traza("MMG:: Valor de atributo valDire: " + valDire);
		
		String valTfno = conectorParametro("valTfno").trim();
		traza("MMG:: Valor de atributo valTfno: " + valTfno);
		
		String valMontMaxiDife = conectorParametro("valMontMaxiDife").trim();
		traza("MMG:: Valor de atributo valMontMaxiDife: " + valMontMaxiDife);
		
		String valLimiEfecCaja = conectorParametro("valLimiEfecCaja").trim();
		traza("MMG:: Valor de atributo valLimiEfecCaja: " + valLimiEfecCaja);
		
		String numCaja = conectorParametro("numCaja").trim();
		traza("MMG:: Valor de atributo numCaja: " + numCaja);
		
		String valNombLoca = conectorParametro("valNombLoca").trim();
		traza("MMG:: Valor de atributo valNombLoca: " + valNombLoca);
		
		String valTiempRepo = conectorParametro("valTiempRepo").trim();
		traza("MMG:: Valor de atributo valTiempRepo: " + valTiempRepo);
		
		String valFactLoca = conectorParametro("valFactLoca").trim();
		traza("MMG:: Valor de atributo valFactLoca: " + valFactLoca);
		
		String numMaxiProd = conectorParametro("numMaxiProd").trim();
		traza("MMG:: Valor de atributo numMaxiProd: " + numMaxiProd);
		
		String valAlerStoc = conectorParametro("valAlerStoc").trim();
		traza("MMG:: Valor de atributo valAlerStoc: " + valAlerStoc);
		
		String valUsua = conectorParametro("valUsua").trim();
		traza("MMG:: Valor de atributo valUsua: " + valUsua);
		
		String clieOidClie = conectorParametro("clieOidClie").trim();
		traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
		
		String sociOidSoci = conectorParametro("sociOidSoci").trim();
		traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
		
		String ttraOidTipoTran = conectorParametro("ttraOidTipoTran").trim();
		traza("MMG:: Valor de atributo ttraOidTipoTran: " + ttraOidTipoTran);
		
		String ccbaOidCuenCorrBanc = conectorParametro("ccbaOidCuenCorrBanc").trim();
		traza("MMG:: Valor de atributo ccbaOidCuenCorrBanc: " + ccbaOidCuenCorrBanc);
		
		String tmvcOidCobr = conectorParametro("tmvcOidCobr").trim();
		traza("MMG:: Valor de atributo tmvcOidCobr: " + tmvcOidCobr);
		
		String tmvcOidCier = conectorParametro("tmvcOidCier").trim();
		traza("MMG:: Valor de atributo tmvcOidCier: " + tmvcOidCier);
		
		String tmalOidConfStoc = conectorParametro("tmalOidConfStoc").trim();
		traza("MMG:: Valor de atributo tmalOidConfStoc: " + tmalOidConfStoc);
		
		String tmalOidConfStocTran = conectorParametro("tmalOidConfStocTran").trim();
		traza("MMG:: Valor de atributo tmalOidConfStocTran: " + tmalOidConfStocTran);
		
		String tmalOidStocTran = conectorParametro("tmalOidStocTran").trim();
		traza("MMG:: Valor de atributo tmalOidStocTran: " + tmalOidStocTran);
		
		String tmalOidStocDevo = conectorParametro("tmalOidStocDevo").trim();
		traza("MMG:: Valor de atributo tmalOidStocDevo: " + tmalOidStocDevo);
		
		String tmalOidRegu = conectorParametro("tmalOidRegu").trim();
		traza("MMG:: Valor de atributo tmalOidRegu: " + tmalOidRegu);
		
		String tmalOidReguSap = conectorParametro("tmalOidReguSap").trim();
		traza("MMG:: Valor de atributo tmalOidReguSap: " + tmalOidReguSap);
		
		String tmalOidDevoStoc = conectorParametro("tmalOidDevoStoc").trim();
		traza("MMG:: Valor de atributo tmalOidDevoStoc: " + tmalOidDevoStoc);
		
		String tmalOidPetiExis = conectorParametro("tmalOidPetiExis").trim();
		traza("MMG:: Valor de atributo tmalOidPetiExis: " + tmalOidPetiExis);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		BelParamBelceData belParamBelce= new BelParamBelceData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			belParamBelce.setId(new Long(id));
		}
		belParamBelce = (BelParamBelceData)getSingleObject(BUSINESSID_QUERY, belParamBelce, 
			belParamBelce.clone(), "belParamBelce");
		
		if(belParamBelce == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
		if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
			sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
			sbacOidSbacData.setId(new Long(sbacOidSbac));
		}
		belParamBelce.setSbacOidSbac(sbacOidSbacData);
		belParamBelce.setValDire(
			(java.lang.String)FormatUtils.parseObject(valDire, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValTfno(
			(java.lang.String)FormatUtils.parseObject(valTfno, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValMontMaxiDife(
			(java.lang.Double)FormatUtils.parseObject(valMontMaxiDife, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValLimiEfecCaja(
			(java.lang.Double)FormatUtils.parseObject(valLimiEfecCaja, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setNumCaja(
			(java.lang.Long)FormatUtils.parseObject(numCaja, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValNombLoca(
			(java.lang.String)FormatUtils.parseObject(valNombLoca, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValTiempRepo(
			(java.lang.Long)FormatUtils.parseObject(valTiempRepo, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValFactLoca(
			(java.lang.Double)FormatUtils.parseObject(valFactLoca, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setNumMaxiProd(
			(java.lang.Long)FormatUtils.parseObject(numMaxiProd, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValAlerStoc(
			(java.lang.Long)FormatUtils.parseObject(valAlerStoc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		belParamBelce.setValUsua(
			(java.lang.String)FormatUtils.parseObject(valUsua, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.MaeClienViewData clieOidClieData = null;
		if(clieOidClie != null && !clieOidClie.trim().equals("")){
			clieOidClieData = new es.indra.belcorp.mso.MaeClienViewData();
			clieOidClieData.setId(new Long(clieOidClie));
		}
		belParamBelce.setClieOidClie(clieOidClieData);
		es.indra.belcorp.mso.SegSocieViewData sociOidSociData = null;
		if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
			sociOidSociData = new es.indra.belcorp.mso.SegSocieViewData();
			sociOidSociData.setId(new Long(sociOidSoci));
		}
		belParamBelce.setSociOidSoci(sociOidSociData);
		es.indra.belcorp.mso.CccTipoTransViewData ttraOidTipoTranData = null;
		if(ttraOidTipoTran != null && !ttraOidTipoTran.trim().equals("")){
			ttraOidTipoTranData = new es.indra.belcorp.mso.CccTipoTransViewData();
			ttraOidTipoTranData.setId(new Long(ttraOidTipoTran));
		}
		belParamBelce.setTtraOidTipoTran(ttraOidTipoTranData);
		es.indra.belcorp.mso.CccCuentCorriBancaData ccbaOidCuenCorrBancData = null;
		if(ccbaOidCuenCorrBanc != null && !ccbaOidCuenCorrBanc.trim().equals("")){
			ccbaOidCuenCorrBancData = new es.indra.belcorp.mso.CccCuentCorriBancaData();
			ccbaOidCuenCorrBancData.setId(new Long(ccbaOidCuenCorrBanc));
		}
		belParamBelce.setCcbaOidCuenCorrBanc(ccbaOidCuenCorrBancData);
		es.indra.belcorp.mso.BelTipoMovimCajaData tmvcOidCobrData = null;
		if(tmvcOidCobr != null && !tmvcOidCobr.trim().equals("")){
			tmvcOidCobrData = new es.indra.belcorp.mso.BelTipoMovimCajaData();
			tmvcOidCobrData.setId(new Long(tmvcOidCobr));
		}
		belParamBelce.setTmvcOidCobr(tmvcOidCobrData);
		es.indra.belcorp.mso.BelTipoMovimCajaData tmvcOidCierData = null;
		if(tmvcOidCier != null && !tmvcOidCier.trim().equals("")){
			tmvcOidCierData = new es.indra.belcorp.mso.BelTipoMovimCajaData();
			tmvcOidCierData.setId(new Long(tmvcOidCier));
		}
		belParamBelce.setTmvcOidCier(tmvcOidCierData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidConfStocData = null;
		if(tmalOidConfStoc != null && !tmalOidConfStoc.trim().equals("")){
			tmalOidConfStocData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidConfStocData.setId(new Long(tmalOidConfStoc));
		}
		belParamBelce.setTmalOidConfStoc(tmalOidConfStocData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidConfStocTranData = null;
		if(tmalOidConfStocTran != null && !tmalOidConfStocTran.trim().equals("")){
			tmalOidConfStocTranData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidConfStocTranData.setId(new Long(tmalOidConfStocTran));
		}
		belParamBelce.setTmalOidConfStocTran(tmalOidConfStocTranData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidStocTranData = null;
		if(tmalOidStocTran != null && !tmalOidStocTran.trim().equals("")){
			tmalOidStocTranData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidStocTranData.setId(new Long(tmalOidStocTran));
		}
		belParamBelce.setTmalOidStocTran(tmalOidStocTranData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidStocDevoData = null;
		if(tmalOidStocDevo != null && !tmalOidStocDevo.trim().equals("")){
			tmalOidStocDevoData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidStocDevoData.setId(new Long(tmalOidStocDevo));
		}
		belParamBelce.setTmalOidStocDevo(tmalOidStocDevoData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidReguData = null;
		if(tmalOidRegu != null && !tmalOidRegu.trim().equals("")){
			tmalOidReguData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidReguData.setId(new Long(tmalOidRegu));
		}
		belParamBelce.setTmalOidRegu(tmalOidReguData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidReguSapData = null;
		if(tmalOidReguSap != null && !tmalOidReguSap.trim().equals("")){
			tmalOidReguSapData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidReguSapData.setId(new Long(tmalOidReguSap));
		}
		belParamBelce.setTmalOidReguSap(tmalOidReguSapData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidDevoStocData = null;
		if(tmalOidDevoStoc != null && !tmalOidDevoStoc.trim().equals("")){
			tmalOidDevoStocData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidDevoStocData.setId(new Long(tmalOidDevoStoc));
		}
		belParamBelce.setTmalOidDevoStoc(tmalOidDevoStocData);
		es.indra.belcorp.mso.BelTipoMovimAlmacViewData tmalOidPetiExisData = null;
		if(tmalOidPetiExis != null && !tmalOidPetiExis.trim().equals("")){
			tmalOidPetiExisData = new es.indra.belcorp.mso.BelTipoMovimAlmacViewData();
			tmalOidPetiExisData.setId(new Long(tmalOidPetiExis));
		}
		belParamBelce.setTmalOidPetiExis(tmalOidPetiExisData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//belParamBelce.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("belParamBelce", belParamBelce);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(belParamBelce);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad BelParamBelce");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad BelParamBelce");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(belParamBelce);
		
		
		//Redirigimos a la LP que cierra el dialogo
		//Registramos que se recagen los datos en la venta en la cual se ha producido la operación
		conectorAction(LP_CLOSE_DIALOG);
		conectorActionOpener(false);
	}
	
	/**Nos permite borrar los elementos de la entidad seleccionados*/
	protected void cmdRemove() throws Exception{
		//Determinamos los elementos a eliminar. De cada uno sacamos el id y el timestamp
		Vector entities = new Vector();
		StringTokenizer claves = new StringTokenizer(conectorParametro("idSelection"), "|");
		StringTokenizer timestamps = new StringTokenizer(conectorParametro("timestamp"), "|");
		traza("MMG::Se van a borrar " + claves.countTokens() + " y son " + conectorParametro("idSelection"));
		while(claves.hasMoreTokens() && timestamps.hasMoreTokens()){
			BelParamBelceData belParamBelce = new BelParamBelceData();
			belParamBelce.setId(new Long(claves.nextToken()));
			//belParamBelce.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(belParamBelce);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad BelParamBelce");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad BelParamBelce");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("BelParamBelceLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(BelParamBelceData belParamBelce) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); 
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				belParamBelce.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(BelParamBelceData belParamBelce) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				belParamBelce.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(BelParamBelceData belParamBelce) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); 
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				belParamBelce.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(BelParamBelceData belParamBelce) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				belParamBelce.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




