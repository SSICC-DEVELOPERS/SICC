

/*
    INDRA/CAR/mmg
    $Id: MaeProduLPExecution.java,v 1.1 2009/12/03 18:35:58 pecbazalar Exp $
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

public class MaeProduLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGMaeProduCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGMaeProduUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGMaeProduRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGMaeProduQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "MaeProduConectorCreate";
	public static final String CONECTOR_UPDATE = "MaeProduConectorUpdate";
	public static final String CONECTOR_REMOVE = "MaeProduConectorRemove";

	public MaeProduLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("MaeProduPage");
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
  	correspondiente a la creación de un/a nuevo MaeProdu*/  
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
		
		traza("MMG::Creando MaeProdu");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String codSap = conectorParametro("codSap").trim();
		traza("MMG:: Valor de atributo codSap: " + codSap);
		
		String codiAnti = conectorParametro("codiAnti").trim();
		traza("MMG:: Valor de atributo codiAnti: " + codiAnti);
		
		String desCort = conectorParametro("desCort").trim();
		traza("MMG:: Valor de atributo desCort: " + desCort);
		
		String valJera1 = conectorParametro("valJera1").trim();
		traza("MMG:: Valor de atributo valJera1: " + valJera1);
		
		String valJera2 = conectorParametro("valJera2").trim();
		traza("MMG:: Valor de atributo valJera2: " + valJera2);
		
		String valJera3 = conectorParametro("valJera3").trim();
		traza("MMG:: Valor de atributo valJera3: " + valJera3);
		
		String valAtri1 = conectorParametro("valAtri1").trim();
		traza("MMG:: Valor de atributo valAtri1: " + valAtri1);
		
		String valAtri2 = conectorParametro("valAtri2").trim();
		traza("MMG:: Valor de atributo valAtri2: " + valAtri2);
		
		String valAtri3 = conectorParametro("valAtri3").trim();
		traza("MMG:: Valor de atributo valAtri3: " + valAtri3);
		
		String valDimeAlto = conectorParametro("valDimeAlto").trim();
		traza("MMG:: Valor de atributo valDimeAlto: " + valDimeAlto);
		
		String valDimeLarg = conectorParametro("valDimeLarg").trim();
		traza("MMG:: Valor de atributo valDimeLarg: " + valDimeLarg);
		
		String valDimeAnch = conectorParametro("valDimeAnch").trim();
		traza("MMG:: Valor de atributo valDimeAnch: " + valDimeAnch);
		
		String valPeso = conectorParametro("valPeso").trim();
		traza("MMG:: Valor de atributo valPeso: " + valPeso);
		
		String valVolu = conectorParametro("valVolu").trim();
		traza("MMG:: Valor de atributo valVolu: " + valVolu);
		
		String valCostEstd = conectorParametro("valCostEstd").trim();
		traza("MMG:: Valor de atributo valCostEstd: " + valCostEstd);
		
		String valPrecPosi = conectorParametro("valPrecPosi").trim();
		traza("MMG:: Valor de atributo valPrecPosi: " + valPrecPosi);
		
		String valPrecCata = conectorParametro("valPrecCata").trim();
		traza("MMG:: Valor de atributo valPrecCata: " + valPrecCata);
		
		String valPrecCont = conectorParametro("valPrecCont").trim();
		traza("MMG:: Valor de atributo valPrecCont: " + valPrecCont);
		
		String numUnidDentPedi = conectorParametro("numUnidDentPedi").trim();
		traza("MMG:: Valor de atributo numUnidDentPedi: " + numUnidDentPedi);
		
		String numUnidCaja = conectorParametro("numUnidCaja").trim();
		traza("MMG:: Valor de atributo numUnidCaja: " + numUnidCaja);
		
		String codImpu = conectorParametro("codImpu").trim();
		traza("MMG:: Valor de atributo codImpu: " + codImpu);
		
		String pctUnid = conectorParametro("pctUnid").trim();
		traza("MMG:: Valor de atributo pctUnid: " + pctUnid);
		
		String geneOidGene = conectorParametro("geneOidGene").trim();
		traza("MMG:: Valor de atributo geneOidGene: " + geneOidGene);
		
		String sgenOidSupeGene = conectorParametro("sgenOidSupeGene").trim();
		traza("MMG:: Valor de atributo sgenOidSupeGene: " + sgenOidSupeGene);
		
		String unmdOidUnidMedi = conectorParametro("unmdOidUnidMedi").trim();
		traza("MMG:: Valor de atributo unmdOidUnidMedi: " + unmdOidUnidMedi);
		
		String unmdOidUnidMediPeso = conectorParametro("unmdOidUnidMediPeso").trim();
		traza("MMG:: Valor de atributo unmdOidUnidMediPeso: " + unmdOidUnidMediPeso);
		
		String unmdOidUnidMediDime = conectorParametro("unmdOidUnidMediDime").trim();
		traza("MMG:: Valor de atributo unmdOidUnidMediDime: " + unmdOidUnidMediDime);
		
		String negoOidNego = conectorParametro("negoOidNego").trim();
		traza("MMG:: Valor de atributo negoOidNego: " + negoOidNego);
		
		String meudOidEstaProd = conectorParametro("meudOidEstaProd").trim();
		traza("MMG:: Valor de atributo meudOidEstaProd: " + meudOidEstaProd);
		
		String liprOidLineProd = conectorParametro("liprOidLineProd").trim();
		traza("MMG:: Valor de atributo liprOidLineProd: " + liprOidLineProd);
		
		String unegOidUnidNego = conectorParametro("unegOidUnidNego").trim();
		traza("MMG:: Valor de atributo unegOidUnidNego: " + unegOidUnidNego);
		
		String perdOidPeriInic = conectorParametro("perdOidPeriInic").trim();
		traza("MMG:: Valor de atributo perdOidPeriInic: " + perdOidPeriInic);
		
		String perdOidPeriFin = conectorParametro("perdOidPeriFin").trim();
		traza("MMG:: Valor de atributo perdOidPeriFin: " + perdOidPeriFin);
		
		String indLote = conectorParametro("indLote").trim();
		traza("MMG:: Valor de atributo indLote: " + indLote);
		
		String indProdServ = conectorParametro("indProdServ").trim();
		traza("MMG:: Valor de atributo indProdServ: " + indProdServ);
		
		String codIndSitu = conectorParametro("codIndSitu").trim();
		traza("MMG:: Valor de atributo codIndSitu: " + codIndSitu);
		
		String codIndDentCaja = conectorParametro("codIndDentCaja").trim();
		traza("MMG:: Valor de atributo codIndDentCaja: " + codIndDentCaja);
		
		String indKit = conectorParametro("indKit").trim();
		traza("MMG:: Valor de atributo indKit: " + indKit);
		
		String fopaOidFormPago = conectorParametro("fopaOidFormPago").trim();
		traza("MMG:: Valor de atributo fopaOidFormPago: " + fopaOidFormPago);
		
		String maprOidMarcProd = conectorParametro("maprOidMarcProd").trim();
		traza("MMG:: Valor de atributo maprOidMarcProd: " + maprOidMarcProd);
		
		String valGrupArti = conectorParametro("valGrupArti").trim();
		traza("MMG:: Valor de atributo valGrupArti: " + valGrupArti);
		
		String codUnicVent = conectorParametro("codUnicVent").trim();
		traza("MMG:: Valor de atributo codUnicVent: " + codUnicVent);
		
		String prfiOidProgFide = conectorParametro("prfiOidProgFide").trim();
		traza("MMG:: Valor de atributo prfiOidProgFide: " + prfiOidProgFide);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		MaeProduData maeProdu= new MaeProduData();
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		maeProdu.setPaisOidPais(paisOidPaisData);
		maeProdu.setCodSap(
			(java.lang.String)FormatUtils.parseObject(codSap, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setCodiAnti(
			(java.lang.String)FormatUtils.parseObject(codiAnti, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setDesCort(
			(java.lang.String)FormatUtils.parseObject(desCort, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValJera1(
			(java.lang.String)FormatUtils.parseObject(valJera1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValJera2(
			(java.lang.String)FormatUtils.parseObject(valJera2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValJera3(
			(java.lang.String)FormatUtils.parseObject(valJera3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValAtri1(
			(java.lang.String)FormatUtils.parseObject(valAtri1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValAtri2(
			(java.lang.String)FormatUtils.parseObject(valAtri2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValAtri3(
			(java.lang.String)FormatUtils.parseObject(valAtri3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValDimeAlto(
			(java.lang.Long)FormatUtils.parseObject(valDimeAlto, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValDimeLarg(
			(java.lang.Long)FormatUtils.parseObject(valDimeLarg, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValDimeAnch(
			(java.lang.Long)FormatUtils.parseObject(valDimeAnch, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValPeso(
			(java.lang.Long)FormatUtils.parseObject(valPeso, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValVolu(
			(java.lang.Long)FormatUtils.parseObject(valVolu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValCostEstd(
			(java.lang.Double)FormatUtils.parseObject(valCostEstd, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValPrecPosi(
			(java.lang.Double)FormatUtils.parseObject(valPrecPosi, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValPrecCata(
			(java.lang.Double)FormatUtils.parseObject(valPrecCata, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValPrecCont(
			(java.lang.Double)FormatUtils.parseObject(valPrecCont, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setNumUnidDentPedi(
			(java.lang.Long)FormatUtils.parseObject(numUnidDentPedi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setNumUnidCaja(
			(java.lang.Long)FormatUtils.parseObject(numUnidCaja, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setCodImpu(
			(java.lang.String)FormatUtils.parseObject(codImpu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setPctUnid(
			(java.lang.Long)FormatUtils.parseObject(pctUnid, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.MaeGenerData geneOidGeneData = null;
		if(geneOidGene != null && !geneOidGene.trim().equals("")){
			geneOidGeneData = new es.indra.belcorp.mso.MaeGenerData();
			geneOidGeneData.setId(new Long(geneOidGene));
		}
		maeProdu.setGeneOidGene(geneOidGeneData);
		es.indra.belcorp.mso.MaeSuperGenerData sgenOidSupeGeneData = null;
		if(sgenOidSupeGene != null && !sgenOidSupeGene.trim().equals("")){
			sgenOidSupeGeneData = new es.indra.belcorp.mso.MaeSuperGenerData();
			sgenOidSupeGeneData.setId(new Long(sgenOidSupeGene));
		}
		maeProdu.setSgenOidSupeGene(sgenOidSupeGeneData);
		es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMediData = null;
		if(unmdOidUnidMedi != null && !unmdOidUnidMedi.trim().equals("")){
			unmdOidUnidMediData = new es.indra.belcorp.mso.MaeUnidaMedidData();
			unmdOidUnidMediData.setId(new Long(unmdOidUnidMedi));
		}
		maeProdu.setUnmdOidUnidMedi(unmdOidUnidMediData);
		es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMediPesoData = null;
		if(unmdOidUnidMediPeso != null && !unmdOidUnidMediPeso.trim().equals("")){
			unmdOidUnidMediPesoData = new es.indra.belcorp.mso.MaeUnidaMedidData();
			unmdOidUnidMediPesoData.setId(new Long(unmdOidUnidMediPeso));
		}
		maeProdu.setUnmdOidUnidMediPeso(unmdOidUnidMediPesoData);
		es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMediDimeData = null;
		if(unmdOidUnidMediDime != null && !unmdOidUnidMediDime.trim().equals("")){
			unmdOidUnidMediDimeData = new es.indra.belcorp.mso.MaeUnidaMedidData();
			unmdOidUnidMediDimeData.setId(new Long(unmdOidUnidMediDime));
		}
		maeProdu.setUnmdOidUnidMediDime(unmdOidUnidMediDimeData);
		es.indra.belcorp.mso.MaeNegocData negoOidNegoData = null;
		if(negoOidNego != null && !negoOidNego.trim().equals("")){
			negoOidNegoData = new es.indra.belcorp.mso.MaeNegocData();
			negoOidNegoData.setId(new Long(negoOidNego));
		}
		maeProdu.setNegoOidNego(negoOidNegoData);
		es.indra.belcorp.mso.MaeEstatProduData meudOidEstaProdData = null;
		if(meudOidEstaProd != null && !meudOidEstaProd.trim().equals("")){
			meudOidEstaProdData = new es.indra.belcorp.mso.MaeEstatProduData();
			meudOidEstaProdData.setId(new Long(meudOidEstaProd));
		}
		maeProdu.setMeudOidEstaProd(meudOidEstaProdData);
		es.indra.belcorp.mso.MaeLineaProduData liprOidLineProdData = null;
		if(liprOidLineProd != null && !liprOidLineProd.trim().equals("")){
			liprOidLineProdData = new es.indra.belcorp.mso.MaeLineaProduData();
			liprOidLineProdData.setId(new Long(liprOidLineProd));
		}
		maeProdu.setLiprOidLineProd(liprOidLineProdData);
		es.indra.belcorp.mso.MaeUnidaNegocData unegOidUnidNegoData = null;
		if(unegOidUnidNego != null && !unegOidUnidNego.trim().equals("")){
			unegOidUnidNegoData = new es.indra.belcorp.mso.MaeUnidaNegocData();
			unegOidUnidNegoData.setId(new Long(unegOidUnidNego));
		}
		maeProdu.setUnegOidUnidNego(unegOidUnidNegoData);
		es.indra.belcorp.mso.CraPerioData perdOidPeriInicData = null;
		if(perdOidPeriInic != null && !perdOidPeriInic.trim().equals("")){
			perdOidPeriInicData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriInicData.setId(new Long(perdOidPeriInic));
		}
		maeProdu.setPerdOidPeriInic(perdOidPeriInicData);
		es.indra.belcorp.mso.CraPerioData perdOidPeriFinData = null;
		if(perdOidPeriFin != null && !perdOidPeriFin.trim().equals("")){
			perdOidPeriFinData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriFinData.setId(new Long(perdOidPeriFin));
		}
		maeProdu.setPerdOidPeriFin(perdOidPeriFinData);
		maeProdu.setIndLote(
			(java.lang.Long)FormatUtils.parseObject(indLote, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setIndProdServ(
			(java.lang.Long)FormatUtils.parseObject(indProdServ, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setCodIndSitu(
			(java.lang.String)FormatUtils.parseObject(codIndSitu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setCodIndDentCaja(
			(java.lang.String)FormatUtils.parseObject(codIndDentCaja, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setIndKit(
			(java.lang.Long)FormatUtils.parseObject(indKit, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.BelFormaPagoData fopaOidFormPagoData = null;
		if(fopaOidFormPago != null && !fopaOidFormPago.trim().equals("")){
			fopaOidFormPagoData = new es.indra.belcorp.mso.BelFormaPagoData();
			fopaOidFormPagoData.setId(new Long(fopaOidFormPago));
		}
		maeProdu.setFopaOidFormPago(fopaOidFormPagoData);
		es.indra.belcorp.mso.SegMarcaProduData maprOidMarcProdData = null;
		if(maprOidMarcProd != null && !maprOidMarcProd.trim().equals("")){
			maprOidMarcProdData = new es.indra.belcorp.mso.SegMarcaProduData();
			maprOidMarcProdData.setId(new Long(maprOidMarcProd));
		}
		maeProdu.setMaprOidMarcProd(maprOidMarcProdData);
		maeProdu.setValGrupArti(
			(java.lang.String)FormatUtils.parseObject(valGrupArti, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setCodUnicVent(
			(java.lang.String)FormatUtils.parseObject(codUnicVent, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.MaeProgrFidelData prfiOidProgFideData = null;
		if(prfiOidProgFide != null && !prfiOidProgFide.trim().equals("")){
			prfiOidProgFideData = new es.indra.belcorp.mso.MaeProgrFidelData();
			prfiOidProgFideData.setId(new Long(prfiOidProgFide));
		}
		maeProdu.setPrfiOidProgFide(prfiOidProgFideData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeProdu", maeProdu);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(maeProdu);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad MaeProdu");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad MaeProdu");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(maeProdu);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("MaeProduLPStartUp");
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
		traza("MMG::Creando MaeProdu");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String codSap = conectorParametro("codSap").trim();
		traza("MMG:: Valor de atributo codSap: " + codSap);
		
		String codiAnti = conectorParametro("codiAnti").trim();
		traza("MMG:: Valor de atributo codiAnti: " + codiAnti);
		
		String desCort = conectorParametro("desCort").trim();
		traza("MMG:: Valor de atributo desCort: " + desCort);
		
		String valJera1 = conectorParametro("valJera1").trim();
		traza("MMG:: Valor de atributo valJera1: " + valJera1);
		
		String valJera2 = conectorParametro("valJera2").trim();
		traza("MMG:: Valor de atributo valJera2: " + valJera2);
		
		String valJera3 = conectorParametro("valJera3").trim();
		traza("MMG:: Valor de atributo valJera3: " + valJera3);
		
		String valAtri1 = conectorParametro("valAtri1").trim();
		traza("MMG:: Valor de atributo valAtri1: " + valAtri1);
		
		String valAtri2 = conectorParametro("valAtri2").trim();
		traza("MMG:: Valor de atributo valAtri2: " + valAtri2);
		
		String valAtri3 = conectorParametro("valAtri3").trim();
		traza("MMG:: Valor de atributo valAtri3: " + valAtri3);
		
		String valDimeAlto = conectorParametro("valDimeAlto").trim();
		traza("MMG:: Valor de atributo valDimeAlto: " + valDimeAlto);
		
		String valDimeLarg = conectorParametro("valDimeLarg").trim();
		traza("MMG:: Valor de atributo valDimeLarg: " + valDimeLarg);
		
		String valDimeAnch = conectorParametro("valDimeAnch").trim();
		traza("MMG:: Valor de atributo valDimeAnch: " + valDimeAnch);
		
		String valPeso = conectorParametro("valPeso").trim();
		traza("MMG:: Valor de atributo valPeso: " + valPeso);
		
		String valVolu = conectorParametro("valVolu").trim();
		traza("MMG:: Valor de atributo valVolu: " + valVolu);
		
		String valCostEstd = conectorParametro("valCostEstd").trim();
		traza("MMG:: Valor de atributo valCostEstd: " + valCostEstd);
		
		String valPrecPosi = conectorParametro("valPrecPosi").trim();
		traza("MMG:: Valor de atributo valPrecPosi: " + valPrecPosi);
		
		String valPrecCata = conectorParametro("valPrecCata").trim();
		traza("MMG:: Valor de atributo valPrecCata: " + valPrecCata);
		
		String valPrecCont = conectorParametro("valPrecCont").trim();
		traza("MMG:: Valor de atributo valPrecCont: " + valPrecCont);
		
		String numUnidDentPedi = conectorParametro("numUnidDentPedi").trim();
		traza("MMG:: Valor de atributo numUnidDentPedi: " + numUnidDentPedi);
		
		String numUnidCaja = conectorParametro("numUnidCaja").trim();
		traza("MMG:: Valor de atributo numUnidCaja: " + numUnidCaja);
		
		String codImpu = conectorParametro("codImpu").trim();
		traza("MMG:: Valor de atributo codImpu: " + codImpu);
		
		String pctUnid = conectorParametro("pctUnid").trim();
		traza("MMG:: Valor de atributo pctUnid: " + pctUnid);
		
		String geneOidGene = conectorParametro("geneOidGene").trim();
		traza("MMG:: Valor de atributo geneOidGene: " + geneOidGene);
		
		String sgenOidSupeGene = conectorParametro("sgenOidSupeGene").trim();
		traza("MMG:: Valor de atributo sgenOidSupeGene: " + sgenOidSupeGene);
		
		String unmdOidUnidMedi = conectorParametro("unmdOidUnidMedi").trim();
		traza("MMG:: Valor de atributo unmdOidUnidMedi: " + unmdOidUnidMedi);
		
		String unmdOidUnidMediPeso = conectorParametro("unmdOidUnidMediPeso").trim();
		traza("MMG:: Valor de atributo unmdOidUnidMediPeso: " + unmdOidUnidMediPeso);
		
		String unmdOidUnidMediDime = conectorParametro("unmdOidUnidMediDime").trim();
		traza("MMG:: Valor de atributo unmdOidUnidMediDime: " + unmdOidUnidMediDime);
		
		String negoOidNego = conectorParametro("negoOidNego").trim();
		traza("MMG:: Valor de atributo negoOidNego: " + negoOidNego);
		
		String meudOidEstaProd = conectorParametro("meudOidEstaProd").trim();
		traza("MMG:: Valor de atributo meudOidEstaProd: " + meudOidEstaProd);
		
		String liprOidLineProd = conectorParametro("liprOidLineProd").trim();
		traza("MMG:: Valor de atributo liprOidLineProd: " + liprOidLineProd);
		
		String unegOidUnidNego = conectorParametro("unegOidUnidNego").trim();
		traza("MMG:: Valor de atributo unegOidUnidNego: " + unegOidUnidNego);
		
		String perdOidPeriInic = conectorParametro("perdOidPeriInic").trim();
		traza("MMG:: Valor de atributo perdOidPeriInic: " + perdOidPeriInic);
		
		String perdOidPeriFin = conectorParametro("perdOidPeriFin").trim();
		traza("MMG:: Valor de atributo perdOidPeriFin: " + perdOidPeriFin);
		
		String indLote = conectorParametro("indLote").trim();
		traza("MMG:: Valor de atributo indLote: " + indLote);
		
		String indProdServ = conectorParametro("indProdServ").trim();
		traza("MMG:: Valor de atributo indProdServ: " + indProdServ);
		
		String codIndSitu = conectorParametro("codIndSitu").trim();
		traza("MMG:: Valor de atributo codIndSitu: " + codIndSitu);
		
		String codIndDentCaja = conectorParametro("codIndDentCaja").trim();
		traza("MMG:: Valor de atributo codIndDentCaja: " + codIndDentCaja);
		
		String indKit = conectorParametro("indKit").trim();
		traza("MMG:: Valor de atributo indKit: " + indKit);
		
		String fopaOidFormPago = conectorParametro("fopaOidFormPago").trim();
		traza("MMG:: Valor de atributo fopaOidFormPago: " + fopaOidFormPago);
		
		String maprOidMarcProd = conectorParametro("maprOidMarcProd").trim();
		traza("MMG:: Valor de atributo maprOidMarcProd: " + maprOidMarcProd);
		
		String valGrupArti = conectorParametro("valGrupArti").trim();
		traza("MMG:: Valor de atributo valGrupArti: " + valGrupArti);
		
		String codUnicVent = conectorParametro("codUnicVent").trim();
		traza("MMG:: Valor de atributo codUnicVent: " + codUnicVent);
		
		String prfiOidProgFide = conectorParametro("prfiOidProgFide").trim();
		traza("MMG:: Valor de atributo prfiOidProgFide: " + prfiOidProgFide);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		MaeProduData maeProdu= new MaeProduData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			maeProdu.setId(new Long(id));
		}
		maeProdu = (MaeProduData)getSingleObject(BUSINESSID_QUERY, maeProdu, 
			maeProdu.clone(), "maeProdu");
		
		if(maeProdu == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		maeProdu.setPaisOidPais(paisOidPaisData);
		maeProdu.setCodSap(
			(java.lang.String)FormatUtils.parseObject(codSap, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setCodiAnti(
			(java.lang.String)FormatUtils.parseObject(codiAnti, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setDesCort(
			(java.lang.String)FormatUtils.parseObject(desCort, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValJera1(
			(java.lang.String)FormatUtils.parseObject(valJera1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValJera2(
			(java.lang.String)FormatUtils.parseObject(valJera2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValJera3(
			(java.lang.String)FormatUtils.parseObject(valJera3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValAtri1(
			(java.lang.String)FormatUtils.parseObject(valAtri1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValAtri2(
			(java.lang.String)FormatUtils.parseObject(valAtri2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValAtri3(
			(java.lang.String)FormatUtils.parseObject(valAtri3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValDimeAlto(
			(java.lang.Long)FormatUtils.parseObject(valDimeAlto, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValDimeLarg(
			(java.lang.Long)FormatUtils.parseObject(valDimeLarg, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValDimeAnch(
			(java.lang.Long)FormatUtils.parseObject(valDimeAnch, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValPeso(
			(java.lang.Long)FormatUtils.parseObject(valPeso, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValVolu(
			(java.lang.Long)FormatUtils.parseObject(valVolu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValCostEstd(
			(java.lang.Double)FormatUtils.parseObject(valCostEstd, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValPrecPosi(
			(java.lang.Double)FormatUtils.parseObject(valPrecPosi, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValPrecCata(
			(java.lang.Double)FormatUtils.parseObject(valPrecCata, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setValPrecCont(
			(java.lang.Double)FormatUtils.parseObject(valPrecCont, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setNumUnidDentPedi(
			(java.lang.Long)FormatUtils.parseObject(numUnidDentPedi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setNumUnidCaja(
			(java.lang.Long)FormatUtils.parseObject(numUnidCaja, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setCodImpu(
			(java.lang.String)FormatUtils.parseObject(codImpu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setPctUnid(
			(java.lang.Long)FormatUtils.parseObject(pctUnid, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.MaeGenerData geneOidGeneData = null;
		if(geneOidGene != null && !geneOidGene.trim().equals("")){
			geneOidGeneData = new es.indra.belcorp.mso.MaeGenerData();
			geneOidGeneData.setId(new Long(geneOidGene));
		}
		maeProdu.setGeneOidGene(geneOidGeneData);
		es.indra.belcorp.mso.MaeSuperGenerData sgenOidSupeGeneData = null;
		if(sgenOidSupeGene != null && !sgenOidSupeGene.trim().equals("")){
			sgenOidSupeGeneData = new es.indra.belcorp.mso.MaeSuperGenerData();
			sgenOidSupeGeneData.setId(new Long(sgenOidSupeGene));
		}
		maeProdu.setSgenOidSupeGene(sgenOidSupeGeneData);
		es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMediData = null;
		if(unmdOidUnidMedi != null && !unmdOidUnidMedi.trim().equals("")){
			unmdOidUnidMediData = new es.indra.belcorp.mso.MaeUnidaMedidData();
			unmdOidUnidMediData.setId(new Long(unmdOidUnidMedi));
		}
		maeProdu.setUnmdOidUnidMedi(unmdOidUnidMediData);
		es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMediPesoData = null;
		if(unmdOidUnidMediPeso != null && !unmdOidUnidMediPeso.trim().equals("")){
			unmdOidUnidMediPesoData = new es.indra.belcorp.mso.MaeUnidaMedidData();
			unmdOidUnidMediPesoData.setId(new Long(unmdOidUnidMediPeso));
		}
		maeProdu.setUnmdOidUnidMediPeso(unmdOidUnidMediPesoData);
		es.indra.belcorp.mso.MaeUnidaMedidData unmdOidUnidMediDimeData = null;
		if(unmdOidUnidMediDime != null && !unmdOidUnidMediDime.trim().equals("")){
			unmdOidUnidMediDimeData = new es.indra.belcorp.mso.MaeUnidaMedidData();
			unmdOidUnidMediDimeData.setId(new Long(unmdOidUnidMediDime));
		}
		maeProdu.setUnmdOidUnidMediDime(unmdOidUnidMediDimeData);
		es.indra.belcorp.mso.MaeNegocData negoOidNegoData = null;
		if(negoOidNego != null && !negoOidNego.trim().equals("")){
			negoOidNegoData = new es.indra.belcorp.mso.MaeNegocData();
			negoOidNegoData.setId(new Long(negoOidNego));
		}
		maeProdu.setNegoOidNego(negoOidNegoData);
		es.indra.belcorp.mso.MaeEstatProduData meudOidEstaProdData = null;
		if(meudOidEstaProd != null && !meudOidEstaProd.trim().equals("")){
			meudOidEstaProdData = new es.indra.belcorp.mso.MaeEstatProduData();
			meudOidEstaProdData.setId(new Long(meudOidEstaProd));
		}
		maeProdu.setMeudOidEstaProd(meudOidEstaProdData);
		es.indra.belcorp.mso.MaeLineaProduData liprOidLineProdData = null;
		if(liprOidLineProd != null && !liprOidLineProd.trim().equals("")){
			liprOidLineProdData = new es.indra.belcorp.mso.MaeLineaProduData();
			liprOidLineProdData.setId(new Long(liprOidLineProd));
		}
		maeProdu.setLiprOidLineProd(liprOidLineProdData);
		es.indra.belcorp.mso.MaeUnidaNegocData unegOidUnidNegoData = null;
		if(unegOidUnidNego != null && !unegOidUnidNego.trim().equals("")){
			unegOidUnidNegoData = new es.indra.belcorp.mso.MaeUnidaNegocData();
			unegOidUnidNegoData.setId(new Long(unegOidUnidNego));
		}
		maeProdu.setUnegOidUnidNego(unegOidUnidNegoData);
		es.indra.belcorp.mso.CraPerioData perdOidPeriInicData = null;
		if(perdOidPeriInic != null && !perdOidPeriInic.trim().equals("")){
			perdOidPeriInicData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriInicData.setId(new Long(perdOidPeriInic));
		}
		maeProdu.setPerdOidPeriInic(perdOidPeriInicData);
		es.indra.belcorp.mso.CraPerioData perdOidPeriFinData = null;
		if(perdOidPeriFin != null && !perdOidPeriFin.trim().equals("")){
			perdOidPeriFinData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriFinData.setId(new Long(perdOidPeriFin));
		}
		maeProdu.setPerdOidPeriFin(perdOidPeriFinData);
		maeProdu.setIndLote(
			(java.lang.Long)FormatUtils.parseObject(indLote, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setIndProdServ(
			(java.lang.Long)FormatUtils.parseObject(indProdServ, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setCodIndSitu(
			(java.lang.String)FormatUtils.parseObject(codIndSitu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setCodIndDentCaja(
			(java.lang.String)FormatUtils.parseObject(codIndDentCaja, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setIndKit(
			(java.lang.Long)FormatUtils.parseObject(indKit, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.BelFormaPagoData fopaOidFormPagoData = null;
		if(fopaOidFormPago != null && !fopaOidFormPago.trim().equals("")){
			fopaOidFormPagoData = new es.indra.belcorp.mso.BelFormaPagoData();
			fopaOidFormPagoData.setId(new Long(fopaOidFormPago));
		}
		maeProdu.setFopaOidFormPago(fopaOidFormPagoData);
		es.indra.belcorp.mso.SegMarcaProduData maprOidMarcProdData = null;
		if(maprOidMarcProd != null && !maprOidMarcProd.trim().equals("")){
			maprOidMarcProdData = new es.indra.belcorp.mso.SegMarcaProduData();
			maprOidMarcProdData.setId(new Long(maprOidMarcProd));
		}
		maeProdu.setMaprOidMarcProd(maprOidMarcProdData);
		maeProdu.setValGrupArti(
			(java.lang.String)FormatUtils.parseObject(valGrupArti, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProdu.setCodUnicVent(
			(java.lang.String)FormatUtils.parseObject(codUnicVent, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.MaeProgrFidelData prfiOidProgFideData = null;
		if(prfiOidProgFide != null && !prfiOidProgFide.trim().equals("")){
			prfiOidProgFideData = new es.indra.belcorp.mso.MaeProgrFidelData();
			prfiOidProgFideData.setId(new Long(prfiOidProgFide));
		}
		maeProdu.setPrfiOidProgFide(prfiOidProgFideData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//maeProdu.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeProdu", maeProdu);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(maeProdu);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad MaeProdu");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad MaeProdu");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(maeProdu);
		
		
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
			MaeProduData maeProdu = new MaeProduData();
			maeProdu.setId(new Long(claves.nextToken()));
			//maeProdu.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(maeProdu);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad MaeProdu");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad MaeProdu");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("MaeProduLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(MaeProduData maeProdu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				maeProdu.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(MaeProduData maeProdu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				maeProdu.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(MaeProduData maeProdu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				maeProdu.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(MaeProduData maeProdu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				maeProdu.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




