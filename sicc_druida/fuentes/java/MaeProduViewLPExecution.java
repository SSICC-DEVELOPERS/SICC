

/*
    INDRA/CAR/mmg
    $Id: MaeProduViewLPExecution.java,v 1.1 2009/12/03 18:41:36 pecbazalar Exp $
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

public class MaeProduViewLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGMaeProduViewCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGMaeProduViewUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGMaeProduViewRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGMaeProduViewQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "MaeProduViewConectorCreate";
	public static final String CONECTOR_UPDATE = "MaeProduViewConectorUpdate";
	public static final String CONECTOR_REMOVE = "MaeProduViewConectorRemove";

	public MaeProduViewLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("MaeProduViewPage");
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
  	correspondiente a la creación de un/a nuevo MaeProduView*/  
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
		
		traza("MMG::Creando MaeProduView");
		
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
		
		String valGrupArti = conectorParametro("valGrupArti").trim();
		traza("MMG:: Valor de atributo valGrupArti: " + valGrupArti);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		MaeProduViewData maeProduView= new MaeProduViewData();
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		maeProduView.setPaisOidPais(paisOidPaisData);
		maeProduView.setCodSap(
			(java.lang.String)FormatUtils.parseObject(codSap, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setCodiAnti(
			(java.lang.String)FormatUtils.parseObject(codiAnti, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setDesCort(
			(java.lang.String)FormatUtils.parseObject(desCort, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValJera1(
			(java.lang.String)FormatUtils.parseObject(valJera1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValJera2(
			(java.lang.String)FormatUtils.parseObject(valJera2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValJera3(
			(java.lang.String)FormatUtils.parseObject(valJera3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValAtri1(
			(java.lang.String)FormatUtils.parseObject(valAtri1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValAtri2(
			(java.lang.String)FormatUtils.parseObject(valAtri2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValAtri3(
			(java.lang.String)FormatUtils.parseObject(valAtri3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValDimeAlto(
			(java.lang.Long)FormatUtils.parseObject(valDimeAlto, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValDimeLarg(
			(java.lang.Long)FormatUtils.parseObject(valDimeLarg, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValDimeAnch(
			(java.lang.Long)FormatUtils.parseObject(valDimeAnch, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValPeso(
			(java.lang.Long)FormatUtils.parseObject(valPeso, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValVolu(
			(java.lang.Long)FormatUtils.parseObject(valVolu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValCostEstd(
			(java.lang.Double)FormatUtils.parseObject(valCostEstd, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValPrecPosi(
			(java.lang.Double)FormatUtils.parseObject(valPrecPosi, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValPrecCata(
			(java.lang.Double)FormatUtils.parseObject(valPrecCata, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValPrecCont(
			(java.lang.Double)FormatUtils.parseObject(valPrecCont, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setNumUnidDentPedi(
			(java.lang.Long)FormatUtils.parseObject(numUnidDentPedi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setNumUnidCaja(
			(java.lang.Long)FormatUtils.parseObject(numUnidCaja, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setCodImpu(
			(java.lang.String)FormatUtils.parseObject(codImpu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setPctUnid(
			(java.lang.Long)FormatUtils.parseObject(pctUnid, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setIndLote(
			(java.lang.Long)FormatUtils.parseObject(indLote, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setIndProdServ(
			(java.lang.Long)FormatUtils.parseObject(indProdServ, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setCodIndSitu(
			(java.lang.String)FormatUtils.parseObject(codIndSitu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setCodIndDentCaja(
			(java.lang.String)FormatUtils.parseObject(codIndDentCaja, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setIndKit(
			(java.lang.Long)FormatUtils.parseObject(indKit, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValGrupArti(
			(java.lang.String)FormatUtils.parseObject(valGrupArti, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeProduView", maeProduView);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad MaeProduView");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad MaeProduView");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("MaeProduViewLPStartUp");
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
		traza("MMG::Creando MaeProduView");
		
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
		
		String valGrupArti = conectorParametro("valGrupArti").trim();
		traza("MMG:: Valor de atributo valGrupArti: " + valGrupArti);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		MaeProduViewData maeProduView= new MaeProduViewData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			maeProduView.setId(new Long(id));
		}
		maeProduView = (MaeProduViewData)getSingleObject(BUSINESSID_QUERY, maeProduView, 
			maeProduView.clone(), "maeProduView");
		
		if(maeProduView == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
			paisOidPaisData.setId(new Long(paisOidPais));
		}
		maeProduView.setPaisOidPais(paisOidPaisData);
		maeProduView.setCodSap(
			(java.lang.String)FormatUtils.parseObject(codSap, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setCodiAnti(
			(java.lang.String)FormatUtils.parseObject(codiAnti, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setDesCort(
			(java.lang.String)FormatUtils.parseObject(desCort, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValJera1(
			(java.lang.String)FormatUtils.parseObject(valJera1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValJera2(
			(java.lang.String)FormatUtils.parseObject(valJera2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValJera3(
			(java.lang.String)FormatUtils.parseObject(valJera3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValAtri1(
			(java.lang.String)FormatUtils.parseObject(valAtri1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValAtri2(
			(java.lang.String)FormatUtils.parseObject(valAtri2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValAtri3(
			(java.lang.String)FormatUtils.parseObject(valAtri3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValDimeAlto(
			(java.lang.Long)FormatUtils.parseObject(valDimeAlto, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValDimeLarg(
			(java.lang.Long)FormatUtils.parseObject(valDimeLarg, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValDimeAnch(
			(java.lang.Long)FormatUtils.parseObject(valDimeAnch, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValPeso(
			(java.lang.Long)FormatUtils.parseObject(valPeso, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValVolu(
			(java.lang.Long)FormatUtils.parseObject(valVolu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValCostEstd(
			(java.lang.Double)FormatUtils.parseObject(valCostEstd, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValPrecPosi(
			(java.lang.Double)FormatUtils.parseObject(valPrecPosi, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValPrecCata(
			(java.lang.Double)FormatUtils.parseObject(valPrecCata, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValPrecCont(
			(java.lang.Double)FormatUtils.parseObject(valPrecCont, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setNumUnidDentPedi(
			(java.lang.Long)FormatUtils.parseObject(numUnidDentPedi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setNumUnidCaja(
			(java.lang.Long)FormatUtils.parseObject(numUnidCaja, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setCodImpu(
			(java.lang.String)FormatUtils.parseObject(codImpu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setPctUnid(
			(java.lang.Long)FormatUtils.parseObject(pctUnid, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setIndLote(
			(java.lang.Long)FormatUtils.parseObject(indLote, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setIndProdServ(
			(java.lang.Long)FormatUtils.parseObject(indProdServ, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setCodIndSitu(
			(java.lang.String)FormatUtils.parseObject(codIndSitu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setCodIndDentCaja(
			(java.lang.String)FormatUtils.parseObject(codIndDentCaja, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setIndKit(
			(java.lang.Long)FormatUtils.parseObject(indKit, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		maeProduView.setValGrupArti(
			(java.lang.String)FormatUtils.parseObject(valGrupArti, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//maeProduView.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("maeProduView", maeProduView);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad MaeProduView");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad MaeProduView");

		
		
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
			MaeProduViewData maeProduView = new MaeProduViewData();
			maeProduView.setId(new Long(claves.nextToken()));
			//maeProduView.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(maeProduView);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad MaeProduView");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad MaeProduView");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("MaeProduViewLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	

	
	
	

	

	
	
	
	
}




