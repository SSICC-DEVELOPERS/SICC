

/*
    INDRA/CAR/mmg
    $Id: SegPaisViewLPExecution.java,v 1.1 2009/12/03 18:38:23 pecbazalar Exp $
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

public class SegPaisViewLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGSegPaisViewCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGSegPaisViewUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGSegPaisViewRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGSegPaisViewQueryFromToUserPageStructuralSecurity";	
	
	
	public static final String CONECTOR_CREATE = "SegPaisViewConectorCreate";
	public static final String CONECTOR_UPDATE = "SegPaisViewConectorUpdate";
	public static final String CONECTOR_REMOVE = "SegPaisViewConectorRemove";

	public SegPaisViewLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("SegPaisViewPage");
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
  	correspondiente a la creación de un/a nuevo SegPaisView*/  
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
		
		traza("MMG::Creando SegPaisView");
		
		String codPais = conectorParametro("codPais").trim();
		traza("MMG:: Valor de atributo codPais: " + codPais);
		if(codPais != null && !codPais.trim().equals("")) codPais = codPais.toUpperCase();
		
		String moneOidMone = conectorParametro("moneOidMone").trim();
		traza("MMG:: Valor de atributo moneOidMone: " + moneOidMone);
		
		String moneOidMoneAlt = conectorParametro("moneOidMoneAlt").trim();
		traza("MMG:: Valor de atributo moneOidMoneAlt: " + moneOidMoneAlt);
		
		String indInteGis = conectorParametro("indInteGis").trim();
		traza("MMG:: Valor de atributo indInteGis: " + indInteGis);
		
		String valIden = conectorParametro("valIden").trim();
		traza("MMG:: Valor de atributo valIden: " + valIden);
		
		String indSaldUnic = conectorParametro("indSaldUnic").trim();
		traza("MMG:: Valor de atributo indSaldUnic: " + indSaldUnic);
		
		String valProgEjec = conectorParametro("valProgEjec").trim();
		traza("MMG:: Valor de atributo valProgEjec: " + valProgEjec);
		
		String valPorcAlar = conectorParametro("valPorcAlar").trim();
		traza("MMG:: Valor de atributo valPorcAlar: " + valPorcAlar);
		
		String indCompAuto = conectorParametro("indCompAuto").trim();
		traza("MMG:: Valor de atributo indCompAuto: " + indCompAuto);
		
		String numDiasMora = conectorParametro("numDiasMora").trim();
		traza("MMG:: Valor de atributo numDiasMora: " + numDiasMora);
		
		String indTratAcumDesc = conectorParametro("indTratAcumDesc").trim();
		traza("MMG:: Valor de atributo indTratAcumDesc: " + indTratAcumDesc);
		
		String valTiemRezo = conectorParametro("valTiemRezo").trim();
		traza("MMG:: Valor de atributo valTiemRezo: " + valTiemRezo);
		
		String valConfSecuCcc = conectorParametro("valConfSecuCcc").trim();
		traza("MMG:: Valor de atributo valConfSecuCcc: " + valConfSecuCcc);
		
		String numDiasFact = conectorParametro("numDiasFact").trim();
		traza("MMG:: Valor de atributo numDiasFact: " + numDiasFact);
		
		String numLimiDifePago = conectorParametro("numLimiDifePago").trim();
		traza("MMG:: Valor de atributo numLimiDifePago: " + numLimiDifePago);
		
		String indEmisVenc = conectorParametro("indEmisVenc").trim();
		traza("MMG:: Valor de atributo indEmisVenc: " + indEmisVenc);
		
		String valMaxiDifeAnlsComb = conectorParametro("valMaxiDifeAnlsComb").trim();
		traza("MMG:: Valor de atributo valMaxiDifeAnlsComb: " + valMaxiDifeAnlsComb);
		
		String numPosiNumeClie = conectorParametro("numPosiNumeClie").trim();
		traza("MMG:: Valor de atributo numPosiNumeClie: " + numPosiNumeClie);
		
		String valFormFech = conectorParametro("valFormFech").trim();
		traza("MMG:: Valor de atributo valFormFech: " + valFormFech);
		
		String valSepaMile = conectorParametro("valSepaMile").trim();
		traza("MMG:: Valor de atributo valSepaMile: " + valSepaMile);
		
		String valSepaDeci = conectorParametro("valSepaDeci").trim();
		traza("MMG:: Valor de atributo valSepaDeci: " + valSepaDeci);
		
		String numPeriEgre = conectorParametro("numPeriEgre").trim();
		traza("MMG:: Valor de atributo numPeriEgre: " + numPeriEgre);
		
		String numPeriReti = conectorParametro("numPeriReti").trim();
		traza("MMG:: Valor de atributo numPeriReti: " + numPeriReti);
		
		String fopaOidFormPago = conectorParametro("fopaOidFormPago").trim();
		traza("MMG:: Valor de atributo fopaOidFormPago: " + fopaOidFormPago);
		
		String valCompTele = conectorParametro("valCompTele").trim();
		traza("MMG:: Valor de atributo valCompTele: " + valCompTele);
		
		String indFletZonaUbig = conectorParametro("indFletZonaUbig").trim();
		traza("MMG:: Valor de atributo indFletZonaUbig: " + indFletZonaUbig);
		
		String valIndiSecuMoni = conectorParametro("valIndiSecuMoni").trim();
		traza("MMG:: Valor de atributo valIndiSecuMoni: " + valIndiSecuMoni);
		
		String indSecu = conectorParametro("indSecu").trim();
		traza("MMG:: Valor de atributo indSecu: " + indSecu);
		
		String indBalaAreaCheq = conectorParametro("indBalaAreaCheq").trim();
		traza("MMG:: Valor de atributo indBalaAreaCheq: " + indBalaAreaCheq);
		
		String valUrl = conectorParametro("valUrl").trim();
		traza("MMG:: Valor de atributo valUrl: " + valUrl);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		SegPaisViewData segPaisView= new SegPaisViewData();
		segPaisView.setCodPais(
			(java.lang.String)FormatUtils.parseObject(codPais, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegMonedData moneOidMoneData = null;
		if(moneOidMone != null && !moneOidMone.trim().equals("")){
			moneOidMoneData = new es.indra.belcorp.mso.SegMonedData();
			moneOidMoneData.setId(new Long(moneOidMone));
		}
		segPaisView.setMoneOidMone(moneOidMoneData);
		es.indra.belcorp.mso.SegMonedData moneOidMoneAltData = null;
		if(moneOidMoneAlt != null && !moneOidMoneAlt.trim().equals("")){
			moneOidMoneAltData = new es.indra.belcorp.mso.SegMonedData();
			moneOidMoneAltData.setId(new Long(moneOidMoneAlt));
		}
		segPaisView.setMoneOidMoneAlt(moneOidMoneAltData);
		segPaisView.setIndInteGis(
			(java.lang.String)FormatUtils.parseObject(indInteGis, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValIden(
			(java.lang.String)FormatUtils.parseObject(valIden, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndSaldUnic(
			(java.lang.String)FormatUtils.parseObject(indSaldUnic, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValProgEjec(
			(java.lang.String)FormatUtils.parseObject(valProgEjec, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValPorcAlar(
			(java.lang.Double)FormatUtils.parseObject(valPorcAlar, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndCompAuto(
			(java.lang.String)FormatUtils.parseObject(indCompAuto, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setNumDiasMora(
			(java.lang.Long)FormatUtils.parseObject(numDiasMora, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndTratAcumDesc(
			(java.lang.String)FormatUtils.parseObject(indTratAcumDesc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValTiemRezo(
			(java.lang.Long)FormatUtils.parseObject(valTiemRezo, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValConfSecuCcc(
			(java.lang.String)FormatUtils.parseObject(valConfSecuCcc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setNumDiasFact(
			(java.lang.Long)FormatUtils.parseObject(numDiasFact, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setNumLimiDifePago(
			(java.lang.Double)FormatUtils.parseObject(numLimiDifePago, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndEmisVenc(
			(java.lang.String)FormatUtils.parseObject(indEmisVenc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValMaxiDifeAnlsComb(
			(java.lang.Double)FormatUtils.parseObject(valMaxiDifeAnlsComb, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setNumPosiNumeClie(
			(java.lang.Long)FormatUtils.parseObject(numPosiNumeClie, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValFormFech(
			(java.lang.String)FormatUtils.parseObject(valFormFech, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValSepaMile(
			(java.lang.String)FormatUtils.parseObject(valSepaMile, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValSepaDeci(
			(java.lang.String)FormatUtils.parseObject(valSepaDeci, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setNumPeriEgre(
			(java.lang.Long)FormatUtils.parseObject(numPeriEgre, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setNumPeriReti(
			(java.lang.Long)FormatUtils.parseObject(numPeriReti, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.BelFormaPagoTaponData fopaOidFormPagoData = null;
		if(fopaOidFormPago != null && !fopaOidFormPago.trim().equals("")){
			fopaOidFormPagoData = new es.indra.belcorp.mso.BelFormaPagoTaponData();
			fopaOidFormPagoData.setId(new Long(fopaOidFormPago));
		}
		segPaisView.setFopaOidFormPago(fopaOidFormPagoData);
		segPaisView.setValCompTele(
			(java.lang.String)FormatUtils.parseObject(valCompTele, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndFletZonaUbig(
			(java.lang.String)FormatUtils.parseObject(indFletZonaUbig, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValIndiSecuMoni(
			(java.lang.String)FormatUtils.parseObject(valIndiSecuMoni, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndSecu(
			(java.lang.String)FormatUtils.parseObject(indSecu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndBalaAreaCheq(
			(java.lang.String)FormatUtils.parseObject(indBalaAreaCheq, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValUrl(
			(java.lang.String)FormatUtils.parseObject(valUrl, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("segPaisView", segPaisView);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad SegPaisView");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad SegPaisView");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("SegPaisViewLPStartUp");
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
		traza("MMG::Creando SegPaisView");
		
		String codPais = conectorParametro("codPais").trim();
		traza("MMG:: Valor de atributo codPais: " + codPais);
		if(codPais != null && !codPais.trim().equals("")) codPais = codPais.toUpperCase();
		
		String moneOidMone = conectorParametro("moneOidMone").trim();
		traza("MMG:: Valor de atributo moneOidMone: " + moneOidMone);
		
		String moneOidMoneAlt = conectorParametro("moneOidMoneAlt").trim();
		traza("MMG:: Valor de atributo moneOidMoneAlt: " + moneOidMoneAlt);
		
		String indInteGis = conectorParametro("indInteGis").trim();
		traza("MMG:: Valor de atributo indInteGis: " + indInteGis);
		
		String valIden = conectorParametro("valIden").trim();
		traza("MMG:: Valor de atributo valIden: " + valIden);
		
		String indSaldUnic = conectorParametro("indSaldUnic").trim();
		traza("MMG:: Valor de atributo indSaldUnic: " + indSaldUnic);
		
		String valProgEjec = conectorParametro("valProgEjec").trim();
		traza("MMG:: Valor de atributo valProgEjec: " + valProgEjec);
		
		String valPorcAlar = conectorParametro("valPorcAlar").trim();
		traza("MMG:: Valor de atributo valPorcAlar: " + valPorcAlar);
		
		String indCompAuto = conectorParametro("indCompAuto").trim();
		traza("MMG:: Valor de atributo indCompAuto: " + indCompAuto);
		
		String numDiasMora = conectorParametro("numDiasMora").trim();
		traza("MMG:: Valor de atributo numDiasMora: " + numDiasMora);
		
		String indTratAcumDesc = conectorParametro("indTratAcumDesc").trim();
		traza("MMG:: Valor de atributo indTratAcumDesc: " + indTratAcumDesc);
		
		String valTiemRezo = conectorParametro("valTiemRezo").trim();
		traza("MMG:: Valor de atributo valTiemRezo: " + valTiemRezo);
		
		String valConfSecuCcc = conectorParametro("valConfSecuCcc").trim();
		traza("MMG:: Valor de atributo valConfSecuCcc: " + valConfSecuCcc);
		
		String numDiasFact = conectorParametro("numDiasFact").trim();
		traza("MMG:: Valor de atributo numDiasFact: " + numDiasFact);
		
		String numLimiDifePago = conectorParametro("numLimiDifePago").trim();
		traza("MMG:: Valor de atributo numLimiDifePago: " + numLimiDifePago);
		
		String indEmisVenc = conectorParametro("indEmisVenc").trim();
		traza("MMG:: Valor de atributo indEmisVenc: " + indEmisVenc);
		
		String valMaxiDifeAnlsComb = conectorParametro("valMaxiDifeAnlsComb").trim();
		traza("MMG:: Valor de atributo valMaxiDifeAnlsComb: " + valMaxiDifeAnlsComb);
		
		String numPosiNumeClie = conectorParametro("numPosiNumeClie").trim();
		traza("MMG:: Valor de atributo numPosiNumeClie: " + numPosiNumeClie);
		
		String valFormFech = conectorParametro("valFormFech").trim();
		traza("MMG:: Valor de atributo valFormFech: " + valFormFech);
		
		String valSepaMile = conectorParametro("valSepaMile").trim();
		traza("MMG:: Valor de atributo valSepaMile: " + valSepaMile);
		
		String valSepaDeci = conectorParametro("valSepaDeci").trim();
		traza("MMG:: Valor de atributo valSepaDeci: " + valSepaDeci);
		
		String numPeriEgre = conectorParametro("numPeriEgre").trim();
		traza("MMG:: Valor de atributo numPeriEgre: " + numPeriEgre);
		
		String numPeriReti = conectorParametro("numPeriReti").trim();
		traza("MMG:: Valor de atributo numPeriReti: " + numPeriReti);
		
		String fopaOidFormPago = conectorParametro("fopaOidFormPago").trim();
		traza("MMG:: Valor de atributo fopaOidFormPago: " + fopaOidFormPago);
		
		String valCompTele = conectorParametro("valCompTele").trim();
		traza("MMG:: Valor de atributo valCompTele: " + valCompTele);
		
		String indFletZonaUbig = conectorParametro("indFletZonaUbig").trim();
		traza("MMG:: Valor de atributo indFletZonaUbig: " + indFletZonaUbig);
		
		String valIndiSecuMoni = conectorParametro("valIndiSecuMoni").trim();
		traza("MMG:: Valor de atributo valIndiSecuMoni: " + valIndiSecuMoni);
		
		String indSecu = conectorParametro("indSecu").trim();
		traza("MMG:: Valor de atributo indSecu: " + indSecu);
		
		String indBalaAreaCheq = conectorParametro("indBalaAreaCheq").trim();
		traza("MMG:: Valor de atributo indBalaAreaCheq: " + indBalaAreaCheq);
		
		String valUrl = conectorParametro("valUrl").trim();
		traza("MMG:: Valor de atributo valUrl: " + valUrl);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		SegPaisViewData segPaisView= new SegPaisViewData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			segPaisView.setId(new Long(id));
		}
		segPaisView = (SegPaisViewData)getSingleObject(BUSINESSID_QUERY, segPaisView, 
			segPaisView.clone(), "segPaisView", false);
		
		if(segPaisView == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		segPaisView.setCodPais(
			(java.lang.String)FormatUtils.parseObject(codPais, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegMonedData moneOidMoneData = null;
		if(moneOidMone != null && !moneOidMone.trim().equals("")){
			moneOidMoneData = new es.indra.belcorp.mso.SegMonedData();
			moneOidMoneData.setId(new Long(moneOidMone));
		}
		segPaisView.setMoneOidMone(moneOidMoneData);
		es.indra.belcorp.mso.SegMonedData moneOidMoneAltData = null;
		if(moneOidMoneAlt != null && !moneOidMoneAlt.trim().equals("")){
			moneOidMoneAltData = new es.indra.belcorp.mso.SegMonedData();
			moneOidMoneAltData.setId(new Long(moneOidMoneAlt));
		}
		segPaisView.setMoneOidMoneAlt(moneOidMoneAltData);
		segPaisView.setIndInteGis(
			(java.lang.String)FormatUtils.parseObject(indInteGis, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValIden(
			(java.lang.String)FormatUtils.parseObject(valIden, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndSaldUnic(
			(java.lang.String)FormatUtils.parseObject(indSaldUnic, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValProgEjec(
			(java.lang.String)FormatUtils.parseObject(valProgEjec, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValPorcAlar(
			(java.lang.Double)FormatUtils.parseObject(valPorcAlar, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndCompAuto(
			(java.lang.String)FormatUtils.parseObject(indCompAuto, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setNumDiasMora(
			(java.lang.Long)FormatUtils.parseObject(numDiasMora, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndTratAcumDesc(
			(java.lang.String)FormatUtils.parseObject(indTratAcumDesc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValTiemRezo(
			(java.lang.Long)FormatUtils.parseObject(valTiemRezo, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValConfSecuCcc(
			(java.lang.String)FormatUtils.parseObject(valConfSecuCcc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setNumDiasFact(
			(java.lang.Long)FormatUtils.parseObject(numDiasFact, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setNumLimiDifePago(
			(java.lang.Double)FormatUtils.parseObject(numLimiDifePago, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndEmisVenc(
			(java.lang.String)FormatUtils.parseObject(indEmisVenc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValMaxiDifeAnlsComb(
			(java.lang.Double)FormatUtils.parseObject(valMaxiDifeAnlsComb, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setNumPosiNumeClie(
			(java.lang.Long)FormatUtils.parseObject(numPosiNumeClie, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValFormFech(
			(java.lang.String)FormatUtils.parseObject(valFormFech, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValSepaMile(
			(java.lang.String)FormatUtils.parseObject(valSepaMile, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValSepaDeci(
			(java.lang.String)FormatUtils.parseObject(valSepaDeci, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setNumPeriEgre(
			(java.lang.Long)FormatUtils.parseObject(numPeriEgre, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setNumPeriReti(
			(java.lang.Long)FormatUtils.parseObject(numPeriReti, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.BelFormaPagoTaponData fopaOidFormPagoData = null;
		if(fopaOidFormPago != null && !fopaOidFormPago.trim().equals("")){
			fopaOidFormPagoData = new es.indra.belcorp.mso.BelFormaPagoTaponData();
			fopaOidFormPagoData.setId(new Long(fopaOidFormPago));
		}
		segPaisView.setFopaOidFormPago(fopaOidFormPagoData);
		segPaisView.setValCompTele(
			(java.lang.String)FormatUtils.parseObject(valCompTele, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndFletZonaUbig(
			(java.lang.String)FormatUtils.parseObject(indFletZonaUbig, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValIndiSecuMoni(
			(java.lang.String)FormatUtils.parseObject(valIndiSecuMoni, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndSecu(
			(java.lang.String)FormatUtils.parseObject(indSecu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setIndBalaAreaCheq(
			(java.lang.String)FormatUtils.parseObject(indBalaAreaCheq, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		segPaisView.setValUrl(
			(java.lang.String)FormatUtils.parseObject(valUrl, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//segPaisView.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("segPaisView", segPaisView);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad SegPaisView");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad SegPaisView");

		
		
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
			SegPaisViewData segPaisView = new SegPaisViewData();
			segPaisView.setId(new Long(claves.nextToken()));
			//segPaisView.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(segPaisView);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad SegPaisView");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad SegPaisView");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("SegPaisViewLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		for(int i=0; i < languages.size(); i++){
			Idioma languageTmp = (Idioma)languages.get(i);
			String value = conectorParametro("hi18NTraduccion_1_" + 
				languageTmp.getOid().longValue());
			if(value == null || value.trim().equals("")) continue;
			
			GenDetaSiccData label = new GenDetaSiccData();
			label.setAtri(new Long(1));
			SegIdiomData language = new SegIdiomData();
			language.setId(new Long(languageTmp.getOid().longValue()));
			label.setIdioOidIdio(language);
			label.setEnti("SEG_PAIS");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	

	
	
	

	

	
	
	
	
}




