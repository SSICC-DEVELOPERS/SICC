

/*
    INDRA/CAR/mmg
    $Id: CobEtapaDeudaLPExecution.java,v 1.1 2009/12/03 18:36:18 pecbazalar Exp $
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

public class CobEtapaDeudaLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCobEtapaDeudaCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCobEtapaDeudaUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCobEtapaDeudaRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCobEtapaDeudaQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CobEtapaDeudaConectorCreate";
	public static final String CONECTOR_UPDATE = "CobEtapaDeudaConectorUpdate";
	public static final String CONECTOR_REMOVE = "CobEtapaDeudaConectorRemove";

	public CobEtapaDeudaLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CobEtapaDeudaPage");
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
  	correspondiente a la creación de un/a nuevo CobEtapaDeuda*/  
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
		
		traza("MMG::Creando CobEtapaDeuda");
		
		String codEtapDeud = conectorParametro("codEtapDeud").trim();
		traza("MMG:: Valor de atributo codEtapDeud: " + codEtapDeud);
		if(codEtapDeud != null && !codEtapDeud.trim().equals("")) codEtapDeud = codEtapDeud.toUpperCase();
		
		String valDesc = conectorParametro("valDesc").trim();
		traza("MMG:: Valor de atributo valDesc: " + valDesc);
		
		String indExcl = conectorParametro("indExcl").trim();
		traza("MMG:: Valor de atributo indExcl: " + indExcl);
		
		String valEdadInic = conectorParametro("valEdadInic").trim();
		traza("MMG:: Valor de atributo valEdadInic: " + valEdadInic);
		
		String valEdadFina = conectorParametro("valEdadFina").trim();
		traza("MMG:: Valor de atributo valEdadFina: " + valEdadFina);
		
		String indTelf = conectorParametro("indTelf").trim();
		traza("MMG:: Valor de atributo indTelf: " + indTelf);
		
		String impDesd = conectorParametro("impDesd").trim();
		traza("MMG:: Valor de atributo impDesd: " + impDesd);
		
		String impHast = conectorParametro("impHast").trim();
		traza("MMG:: Valor de atributo impHast: " + impHast);
		
		String numDiasGracCompPago = conectorParametro("numDiasGracCompPago").trim();
		traza("MMG:: Valor de atributo numDiasGracCompPago: " + numDiasGracCompPago);
		
		String valPorcIncu = conectorParametro("valPorcIncu").trim();
		traza("MMG:: Valor de atributo valPorcIncu: " + valPorcIncu);
		
		String mensOidMens = conectorParametro("mensOidMens").trim();
		traza("MMG:: Valor de atributo mensOidMens: " + mensOidMens);
		
		String melcOidMetoLiquCobr = conectorParametro("melcOidMetoLiquCobr").trim();
		traza("MMG:: Valor de atributo melcOidMetoLiquCobr: " + melcOidMetoLiquCobr);
		
		String tbalOidTipoBala = conectorParametro("tbalOidTipoBala").trim();
		traza("MMG:: Valor de atributo tbalOidTipoBala: " + tbalOidTipoBala);
		
		String gacaOidGuioArguCabe = conectorParametro("gacaOidGuioArguCabe").trim();
		traza("MMG:: Valor de atributo gacaOidGuioArguCabe: " + gacaOidGuioArguCabe);
		
		String oredOidEtapDeu1 = conectorParametro("oredOidEtapDeu1").trim();
		traza("MMG:: Valor de atributo oredOidEtapDeu1: " + oredOidEtapDeu1);
		
		String oredOidEtapDeu2 = conectorParametro("oredOidEtapDeu2").trim();
		traza("MMG:: Valor de atributo oredOidEtapDeu2: " + oredOidEtapDeu2);
		
		String oredOidEtapDeu3 = conectorParametro("oredOidEtapDeu3").trim();
		traza("MMG:: Valor de atributo oredOidEtapDeu3: " + oredOidEtapDeu3);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CobEtapaDeudaData cobEtapaDeuda= new CobEtapaDeudaData();
		cobEtapaDeuda.setCodEtapDeud(
			(java.lang.String)FormatUtils.parseObject(codEtapDeud, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setValDesc(
			(java.lang.String)FormatUtils.parseObject(valDesc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setIndExcl(
			(java.lang.Long)FormatUtils.parseObject(indExcl, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setValEdadInic(
			(java.lang.Long)FormatUtils.parseObject(valEdadInic, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setValEdadFina(
			(java.lang.Long)FormatUtils.parseObject(valEdadFina, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setIndTelf(
			(java.lang.Long)FormatUtils.parseObject(indTelf, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setImpDesd(
			(java.lang.Double)FormatUtils.parseObject(impDesd, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setImpHast(
			(java.lang.Double)FormatUtils.parseObject(impHast, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setNumDiasGracCompPago(
			(java.lang.Long)FormatUtils.parseObject(numDiasGracCompPago, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setValPorcIncu(
			(java.lang.Double)FormatUtils.parseObject(valPorcIncu, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.MsgMensaData mensOidMensData = null;
		if(mensOidMens != null && !mensOidMens.trim().equals("")){
			mensOidMensData = new es.indra.belcorp.mso.MsgMensaData();
			mensOidMensData.setId(new Long(mensOidMens));
		}
		cobEtapaDeuda.setMensOidMens(mensOidMensData);
		es.indra.belcorp.mso.CobMetodLiquiViewData melcOidMetoLiquCobrData = null;
		if(melcOidMetoLiquCobr != null && !melcOidMetoLiquCobr.trim().equals("")){
			melcOidMetoLiquCobrData = new es.indra.belcorp.mso.CobMetodLiquiViewData();
			melcOidMetoLiquCobrData.setId(new Long(melcOidMetoLiquCobr));
		}
		cobEtapaDeuda.setMelcOidMetoLiquCobr(melcOidMetoLiquCobrData);
		es.indra.belcorp.mso.CobTipoBalanData tbalOidTipoBalaData = null;
		if(tbalOidTipoBala != null && !tbalOidTipoBala.trim().equals("")){
			tbalOidTipoBalaData = new es.indra.belcorp.mso.CobTipoBalanData();
			tbalOidTipoBalaData.setId(new Long(tbalOidTipoBala));
		}
		cobEtapaDeuda.setTbalOidTipoBala(tbalOidTipoBalaData);
		es.indra.belcorp.mso.CobGuionArgumCabecViewData gacaOidGuioArguCabeData = null;
		if(gacaOidGuioArguCabe != null && !gacaOidGuioArguCabe.trim().equals("")){
			gacaOidGuioArguCabeData = new es.indra.belcorp.mso.CobGuionArgumCabecViewData();
			gacaOidGuioArguCabeData.setId(new Long(gacaOidGuioArguCabe));
		}
		cobEtapaDeuda.setGacaOidGuioArguCabe(gacaOidGuioArguCabeData);
		es.indra.belcorp.mso.CobOrdenEtapaDeudaData oredOidEtapDeu1Data = null;
		if(oredOidEtapDeu1 != null && !oredOidEtapDeu1.trim().equals("")){
			oredOidEtapDeu1Data = new es.indra.belcorp.mso.CobOrdenEtapaDeudaData();
			oredOidEtapDeu1Data.setId(new Long(oredOidEtapDeu1));
		}
		cobEtapaDeuda.setOredOidEtapDeu1(oredOidEtapDeu1Data);
		es.indra.belcorp.mso.CobOrdenEtapaDeudaData oredOidEtapDeu2Data = null;
		if(oredOidEtapDeu2 != null && !oredOidEtapDeu2.trim().equals("")){
			oredOidEtapDeu2Data = new es.indra.belcorp.mso.CobOrdenEtapaDeudaData();
			oredOidEtapDeu2Data.setId(new Long(oredOidEtapDeu2));
		}
		cobEtapaDeuda.setOredOidEtapDeu2(oredOidEtapDeu2Data);
		es.indra.belcorp.mso.CobOrdenEtapaDeudaData oredOidEtapDeu3Data = null;
		if(oredOidEtapDeu3 != null && !oredOidEtapDeu3.trim().equals("")){
			oredOidEtapDeu3Data = new es.indra.belcorp.mso.CobOrdenEtapaDeudaData();
			oredOidEtapDeu3Data.setId(new Long(oredOidEtapDeu3));
		}
		cobEtapaDeuda.setOredOidEtapDeu3(oredOidEtapDeu3Data);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobEtapaDeuda", cobEtapaDeuda);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(cobEtapaDeuda);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CobEtapaDeuda");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CobEtapaDeuda");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(cobEtapaDeuda);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CobEtapaDeudaLPStartUp");
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
		traza("MMG::Creando CobEtapaDeuda");
		
		String codEtapDeud = conectorParametro("codEtapDeud").trim();
		traza("MMG:: Valor de atributo codEtapDeud: " + codEtapDeud);
		if(codEtapDeud != null && !codEtapDeud.trim().equals("")) codEtapDeud = codEtapDeud.toUpperCase();
		
		String valDesc = conectorParametro("valDesc").trim();
		traza("MMG:: Valor de atributo valDesc: " + valDesc);
		
		String indExcl = conectorParametro("indExcl").trim();
		traza("MMG:: Valor de atributo indExcl: " + indExcl);
		
		String valEdadInic = conectorParametro("valEdadInic").trim();
		traza("MMG:: Valor de atributo valEdadInic: " + valEdadInic);
		
		String valEdadFina = conectorParametro("valEdadFina").trim();
		traza("MMG:: Valor de atributo valEdadFina: " + valEdadFina);
		
		String indTelf = conectorParametro("indTelf").trim();
		traza("MMG:: Valor de atributo indTelf: " + indTelf);
		
		String impDesd = conectorParametro("impDesd").trim();
		traza("MMG:: Valor de atributo impDesd: " + impDesd);
		
		String impHast = conectorParametro("impHast").trim();
		traza("MMG:: Valor de atributo impHast: " + impHast);
		
		String numDiasGracCompPago = conectorParametro("numDiasGracCompPago").trim();
		traza("MMG:: Valor de atributo numDiasGracCompPago: " + numDiasGracCompPago);
		
		String valPorcIncu = conectorParametro("valPorcIncu").trim();
		traza("MMG:: Valor de atributo valPorcIncu: " + valPorcIncu);
		
		String mensOidMens = conectorParametro("mensOidMens").trim();
		traza("MMG:: Valor de atributo mensOidMens: " + mensOidMens);
		
		String melcOidMetoLiquCobr = conectorParametro("melcOidMetoLiquCobr").trim();
		traza("MMG:: Valor de atributo melcOidMetoLiquCobr: " + melcOidMetoLiquCobr);
		
		String tbalOidTipoBala = conectorParametro("tbalOidTipoBala").trim();
		traza("MMG:: Valor de atributo tbalOidTipoBala: " + tbalOidTipoBala);
		
		String gacaOidGuioArguCabe = conectorParametro("gacaOidGuioArguCabe").trim();
		traza("MMG:: Valor de atributo gacaOidGuioArguCabe: " + gacaOidGuioArguCabe);
		
		String oredOidEtapDeu1 = conectorParametro("oredOidEtapDeu1").trim();
		traza("MMG:: Valor de atributo oredOidEtapDeu1: " + oredOidEtapDeu1);
		
		String oredOidEtapDeu2 = conectorParametro("oredOidEtapDeu2").trim();
		traza("MMG:: Valor de atributo oredOidEtapDeu2: " + oredOidEtapDeu2);
		
		String oredOidEtapDeu3 = conectorParametro("oredOidEtapDeu3").trim();
		traza("MMG:: Valor de atributo oredOidEtapDeu3: " + oredOidEtapDeu3);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CobEtapaDeudaData cobEtapaDeuda= new CobEtapaDeudaData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cobEtapaDeuda.setId(new Long(id));
		}
		cobEtapaDeuda = (CobEtapaDeudaData)getSingleObject(BUSINESSID_QUERY, cobEtapaDeuda, 
			cobEtapaDeuda.clone(), "cobEtapaDeuda");
		
		if(cobEtapaDeuda == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		cobEtapaDeuda.setCodEtapDeud(
			(java.lang.String)FormatUtils.parseObject(codEtapDeud, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setValDesc(
			(java.lang.String)FormatUtils.parseObject(valDesc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setIndExcl(
			(java.lang.Long)FormatUtils.parseObject(indExcl, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setValEdadInic(
			(java.lang.Long)FormatUtils.parseObject(valEdadInic, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setValEdadFina(
			(java.lang.Long)FormatUtils.parseObject(valEdadFina, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setIndTelf(
			(java.lang.Long)FormatUtils.parseObject(indTelf, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setImpDesd(
			(java.lang.Double)FormatUtils.parseObject(impDesd, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setImpHast(
			(java.lang.Double)FormatUtils.parseObject(impHast, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setNumDiasGracCompPago(
			(java.lang.Long)FormatUtils.parseObject(numDiasGracCompPago, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cobEtapaDeuda.setValPorcIncu(
			(java.lang.Double)FormatUtils.parseObject(valPorcIncu, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.MsgMensaData mensOidMensData = null;
		if(mensOidMens != null && !mensOidMens.trim().equals("")){
			mensOidMensData = new es.indra.belcorp.mso.MsgMensaData();
			mensOidMensData.setId(new Long(mensOidMens));
		}
		cobEtapaDeuda.setMensOidMens(mensOidMensData);
		es.indra.belcorp.mso.CobMetodLiquiViewData melcOidMetoLiquCobrData = null;
		if(melcOidMetoLiquCobr != null && !melcOidMetoLiquCobr.trim().equals("")){
			melcOidMetoLiquCobrData = new es.indra.belcorp.mso.CobMetodLiquiViewData();
			melcOidMetoLiquCobrData.setId(new Long(melcOidMetoLiquCobr));
		}
		cobEtapaDeuda.setMelcOidMetoLiquCobr(melcOidMetoLiquCobrData);
		es.indra.belcorp.mso.CobTipoBalanData tbalOidTipoBalaData = null;
		if(tbalOidTipoBala != null && !tbalOidTipoBala.trim().equals("")){
			tbalOidTipoBalaData = new es.indra.belcorp.mso.CobTipoBalanData();
			tbalOidTipoBalaData.setId(new Long(tbalOidTipoBala));
		}
		cobEtapaDeuda.setTbalOidTipoBala(tbalOidTipoBalaData);
		es.indra.belcorp.mso.CobGuionArgumCabecViewData gacaOidGuioArguCabeData = null;
		if(gacaOidGuioArguCabe != null && !gacaOidGuioArguCabe.trim().equals("")){
			gacaOidGuioArguCabeData = new es.indra.belcorp.mso.CobGuionArgumCabecViewData();
			gacaOidGuioArguCabeData.setId(new Long(gacaOidGuioArguCabe));
		}
		cobEtapaDeuda.setGacaOidGuioArguCabe(gacaOidGuioArguCabeData);
		es.indra.belcorp.mso.CobOrdenEtapaDeudaData oredOidEtapDeu1Data = null;
		if(oredOidEtapDeu1 != null && !oredOidEtapDeu1.trim().equals("")){
			oredOidEtapDeu1Data = new es.indra.belcorp.mso.CobOrdenEtapaDeudaData();
			oredOidEtapDeu1Data.setId(new Long(oredOidEtapDeu1));
		}
		cobEtapaDeuda.setOredOidEtapDeu1(oredOidEtapDeu1Data);
		es.indra.belcorp.mso.CobOrdenEtapaDeudaData oredOidEtapDeu2Data = null;
		if(oredOidEtapDeu2 != null && !oredOidEtapDeu2.trim().equals("")){
			oredOidEtapDeu2Data = new es.indra.belcorp.mso.CobOrdenEtapaDeudaData();
			oredOidEtapDeu2Data.setId(new Long(oredOidEtapDeu2));
		}
		cobEtapaDeuda.setOredOidEtapDeu2(oredOidEtapDeu2Data);
		es.indra.belcorp.mso.CobOrdenEtapaDeudaData oredOidEtapDeu3Data = null;
		if(oredOidEtapDeu3 != null && !oredOidEtapDeu3.trim().equals("")){
			oredOidEtapDeu3Data = new es.indra.belcorp.mso.CobOrdenEtapaDeudaData();
			oredOidEtapDeu3Data.setId(new Long(oredOidEtapDeu3));
		}
		cobEtapaDeuda.setOredOidEtapDeu3(oredOidEtapDeu3Data);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cobEtapaDeuda.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cobEtapaDeuda", cobEtapaDeuda);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(cobEtapaDeuda);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CobEtapaDeuda");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CobEtapaDeuda");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(cobEtapaDeuda);
		
		
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
			CobEtapaDeudaData cobEtapaDeuda = new CobEtapaDeudaData();
			cobEtapaDeuda.setId(new Long(claves.nextToken()));
			//cobEtapaDeuda.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cobEtapaDeuda);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CobEtapaDeuda");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CobEtapaDeuda");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CobEtapaDeudaLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(CobEtapaDeudaData cobEtapaDeuda) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cobEtapaDeuda.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(CobEtapaDeudaData cobEtapaDeuda) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cobEtapaDeuda.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(CobEtapaDeudaData cobEtapaDeuda) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cobEtapaDeuda.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(CobEtapaDeudaData cobEtapaDeuda) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cobEtapaDeuda.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




