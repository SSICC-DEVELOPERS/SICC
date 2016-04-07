

/*
    INDRA/CAR/mmg
    $Id: PedTipoSolicPaisLPExecution.java,v 1.1 2009/12/03 18:36:02 pecbazalar Exp $
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

public class PedTipoSolicPaisLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGPedTipoSolicPaisCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGPedTipoSolicPaisUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGPedTipoSolicPaisRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGPedTipoSolicPaisQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "PedTipoSolicPaisConectorCreate";
	public static final String CONECTOR_UPDATE = "PedTipoSolicPaisConectorUpdate";
	public static final String CONECTOR_REMOVE = "PedTipoSolicPaisConectorRemove";

	public PedTipoSolicPaisLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("PedTipoSolicPaisPage");
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
  	correspondiente a la creación de un/a nuevo PedTipoSolicPais*/  
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
		
		traza("MMG::Creando PedTipoSolicPais");
		
		String tsolOidTipoSoli = conectorParametro("tsolOidTipoSoli").trim();
		traza("MMG:: Valor de atributo tsolOidTipoSoli: " + tsolOidTipoSoli);
		
		String numSoliLote = conectorParametro("numSoliLote").trim();
		traza("MMG:: Valor de atributo numSoliLote: " + numSoliLote);
		
		String numUnidAlar = conectorParametro("numUnidAlar").trim();
		traza("MMG:: Valor de atributo numUnidAlar: " + numUnidAlar);
		
		String fopaOidFormPago = conectorParametro("fopaOidFormPago").trim();
		traza("MMG:: Valor de atributo fopaOidFormPago: " + fopaOidFormPago);
		
		String indSujeFlet = conectorParametro("indSujeFlet").trim();
		traza("MMG:: Valor de atributo indSujeFlet: " + indSujeFlet);
		
		String indReseStoc = conectorParametro("indReseStoc").trim();
		traza("MMG:: Valor de atributo indReseStoc: " + indReseStoc);
		
		String indPermReve = conectorParametro("indPermReve").trim();
		traza("MMG:: Valor de atributo indPermReve: " + indPermReve);
		
		String indPediPrue = conectorParametro("indPediPrue").trim();
		traza("MMG:: Valor de atributo indPediPrue: " + indPediPrue);
		
		String indComi = conectorParametro("indComi").trim();
		traza("MMG:: Valor de atributo indComi: " + indComi);
		
		String indVentInteSab14 = conectorParametro("indVentInteSab14").trim();
		traza("MMG:: Valor de atributo indVentInteSab14: " + indVentInteSab14);
		
		String cactOidActi = conectorParametro("cactOidActi").trim();
		traza("MMG:: Valor de atributo cactOidActi: " + cactOidActi);
		
		String moneOidMone = conectorParametro("moneOidMone").trim();
		traza("MMG:: Valor de atributo moneOidMone: " + moneOidMone);
		
		String tmalOidTipoMoviAsig = conectorParametro("tmalOidTipoMoviAsig").trim();
		traza("MMG:: Valor de atributo tmalOidTipoMoviAsig: " + tmalOidTipoMoviAsig);
		
		String tmalOidTipoMoviRese = conectorParametro("tmalOidTipoMoviRese").trim();
		traza("MMG:: Valor de atributo tmalOidTipoMoviRese: " + tmalOidTipoMoviRese);
		
		String tmalOidTipoMoviFact = conectorParametro("tmalOidTipoMoviFact").trim();
		traza("MMG:: Valor de atributo tmalOidTipoMoviFact: " + tmalOidTipoMoviFact);
		
		String tidoOidTipoDocu = conectorParametro("tidoOidTipoDocu").trim();
		traza("MMG:: Valor de atributo tidoOidTipoDocu: " + tidoOidTipoDocu);
		
		String indPermUnio = conectorParametro("indPermUnio").trim();
		traza("MMG:: Valor de atributo indPermUnio: " + indPermUnio);
		
		String indPediGtZona = conectorParametro("indPediGtZona").trim();
		traza("MMG:: Valor de atributo indPediGtZona: " + indPediGtZona);
		
		String indCambVentBel = conectorParametro("indCambVentBel").trim();
		traza("MMG:: Valor de atributo indCambVentBel: " + indCambVentBel);
		
		String almcOidAlma = conectorParametro("almcOidAlma").trim();
		traza("MMG:: Valor de atributo almcOidAlma: " + almcOidAlma);
		
		String sociOidSoci = conectorParametro("sociOidSoci").trim();
		traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
		
		String valGlos = conectorParametro("valGlos").trim();
		traza("MMG:: Valor de atributo valGlos: " + valGlos);
		
		String tsolOidTipoCons = conectorParametro("tsolOidTipoCons").trim();
		traza("MMG:: Valor de atributo tsolOidTipoCons: " + tsolOidTipoCons);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		PedTipoSolicPaisData pedTipoSolicPais= new PedTipoSolicPaisData();
		es.indra.belcorp.mso.PedTipoSolicViewData tsolOidTipoSoliData = null;
		if(tsolOidTipoSoli != null && !tsolOidTipoSoli.trim().equals("")){
			tsolOidTipoSoliData = new es.indra.belcorp.mso.PedTipoSolicViewData();
			tsolOidTipoSoliData.setId(new Long(tsolOidTipoSoli));
		}
		pedTipoSolicPais.setTsolOidTipoSoli(tsolOidTipoSoliData);
		pedTipoSolicPais.setNumSoliLote(
			(java.lang.Long)FormatUtils.parseObject(numSoliLote, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setNumUnidAlar(
			(java.lang.Long)FormatUtils.parseObject(numUnidAlar, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.BelFormaPagoData fopaOidFormPagoData = null;
		if(fopaOidFormPago != null && !fopaOidFormPago.trim().equals("")){
			fopaOidFormPagoData = new es.indra.belcorp.mso.BelFormaPagoData();
			fopaOidFormPagoData.setId(new Long(fopaOidFormPago));
		}
		pedTipoSolicPais.setFopaOidFormPago(fopaOidFormPagoData);
		pedTipoSolicPais.setIndSujeFlet(
			(java.lang.Long)FormatUtils.parseObject(indSujeFlet, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndReseStoc(
			(java.lang.Long)FormatUtils.parseObject(indReseStoc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndPermReve(
			(java.lang.Long)FormatUtils.parseObject(indPermReve, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndPediPrue(
			(java.lang.Long)FormatUtils.parseObject(indPediPrue, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndComi(
			(java.lang.Long)FormatUtils.parseObject(indComi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndVentInteSab14(
			(java.lang.Long)FormatUtils.parseObject(indVentInteSab14, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CraActivData cactOidActiData = null;
		if(cactOidActi != null && !cactOidActi.trim().equals("")){
			cactOidActiData = new es.indra.belcorp.mso.CraActivData();
			cactOidActiData.setId(new Long(cactOidActi));
		}
		pedTipoSolicPais.setCactOidActi(cactOidActiData);
		es.indra.belcorp.mso.SegMonedData moneOidMoneData = null;
		if(moneOidMone != null && !moneOidMone.trim().equals("")){
			moneOidMoneData = new es.indra.belcorp.mso.SegMonedData();
			moneOidMoneData.setId(new Long(moneOidMone));
		}
		pedTipoSolicPais.setMoneOidMone(moneOidMoneData);
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviAsigData = null;
		if(tmalOidTipoMoviAsig != null && !tmalOidTipoMoviAsig.trim().equals("")){
			tmalOidTipoMoviAsigData = new es.indra.belcorp.mso.BelTipoMovimAlmacData();
			tmalOidTipoMoviAsigData.setId(new Long(tmalOidTipoMoviAsig));
		}
		pedTipoSolicPais.setTmalOidTipoMoviAsig(tmalOidTipoMoviAsigData);
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviReseData = null;
		if(tmalOidTipoMoviRese != null && !tmalOidTipoMoviRese.trim().equals("")){
			tmalOidTipoMoviReseData = new es.indra.belcorp.mso.BelTipoMovimAlmacData();
			tmalOidTipoMoviReseData.setId(new Long(tmalOidTipoMoviRese));
		}
		pedTipoSolicPais.setTmalOidTipoMoviRese(tmalOidTipoMoviReseData);
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviFactData = null;
		if(tmalOidTipoMoviFact != null && !tmalOidTipoMoviFact.trim().equals("")){
			tmalOidTipoMoviFactData = new es.indra.belcorp.mso.BelTipoMovimAlmacData();
			tmalOidTipoMoviFactData.setId(new Long(tmalOidTipoMoviFact));
		}
		pedTipoSolicPais.setTmalOidTipoMoviFact(tmalOidTipoMoviFactData);
		es.indra.belcorp.mso.FacTipoDocumData tidoOidTipoDocuData = null;
		if(tidoOidTipoDocu != null && !tidoOidTipoDocu.trim().equals("")){
			tidoOidTipoDocuData = new es.indra.belcorp.mso.FacTipoDocumData();
			tidoOidTipoDocuData.setId(new Long(tidoOidTipoDocu));
		}
		pedTipoSolicPais.setTidoOidTipoDocu(tidoOidTipoDocuData);
		pedTipoSolicPais.setIndPermUnio(
			(java.lang.Long)FormatUtils.parseObject(indPermUnio, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndPediGtZona(
			(java.lang.Long)FormatUtils.parseObject(indPediGtZona, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndCambVentBel(
			(java.lang.Long)FormatUtils.parseObject(indCambVentBel, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.BelAlmacData almcOidAlmaData = null;
		if(almcOidAlma != null && !almcOidAlma.trim().equals("")){
			almcOidAlmaData = new es.indra.belcorp.mso.BelAlmacData();
			almcOidAlmaData.setId(new Long(almcOidAlma));
		}
		pedTipoSolicPais.setAlmcOidAlma(almcOidAlmaData);
		es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
		if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
			sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
			sociOidSociData.setId(new Long(sociOidSoci));
		}
		pedTipoSolicPais.setSociOidSoci(sociOidSociData);
		pedTipoSolicPais.setValGlos(
			(java.lang.String)FormatUtils.parseObject(valGlos, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.PedTipoSolicPaisViewData tsolOidTipoConsData = null;
		if(tsolOidTipoCons != null && !tsolOidTipoCons.trim().equals("")){
			tsolOidTipoConsData = new es.indra.belcorp.mso.PedTipoSolicPaisViewData();
			tsolOidTipoConsData.setId(new Long(tsolOidTipoCons));
		}
		pedTipoSolicPais.setTsolOidTipoCons(tsolOidTipoConsData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("pedTipoSolicPais", pedTipoSolicPais);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(pedTipoSolicPais);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad PedTipoSolicPais");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad PedTipoSolicPais");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(pedTipoSolicPais);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("PedTipoSolicPaisLPStartUp");
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
		traza("MMG::Creando PedTipoSolicPais");
		
		String tsolOidTipoSoli = conectorParametro("tsolOidTipoSoli").trim();
		traza("MMG:: Valor de atributo tsolOidTipoSoli: " + tsolOidTipoSoli);
		
		String numSoliLote = conectorParametro("numSoliLote").trim();
		traza("MMG:: Valor de atributo numSoliLote: " + numSoliLote);
		
		String numUnidAlar = conectorParametro("numUnidAlar").trim();
		traza("MMG:: Valor de atributo numUnidAlar: " + numUnidAlar);
		
		String fopaOidFormPago = conectorParametro("fopaOidFormPago").trim();
		traza("MMG:: Valor de atributo fopaOidFormPago: " + fopaOidFormPago);
		
		String indSujeFlet = conectorParametro("indSujeFlet").trim();
		traza("MMG:: Valor de atributo indSujeFlet: " + indSujeFlet);
		
		String indReseStoc = conectorParametro("indReseStoc").trim();
		traza("MMG:: Valor de atributo indReseStoc: " + indReseStoc);
		
		String indPermReve = conectorParametro("indPermReve").trim();
		traza("MMG:: Valor de atributo indPermReve: " + indPermReve);
		
		String indPediPrue = conectorParametro("indPediPrue").trim();
		traza("MMG:: Valor de atributo indPediPrue: " + indPediPrue);
		
		String indComi = conectorParametro("indComi").trim();
		traza("MMG:: Valor de atributo indComi: " + indComi);
		
		String indVentInteSab14 = conectorParametro("indVentInteSab14").trim();
		traza("MMG:: Valor de atributo indVentInteSab14: " + indVentInteSab14);
		
		String cactOidActi = conectorParametro("cactOidActi").trim();
		traza("MMG:: Valor de atributo cactOidActi: " + cactOidActi);
		
		String moneOidMone = conectorParametro("moneOidMone").trim();
		traza("MMG:: Valor de atributo moneOidMone: " + moneOidMone);
		
		String tmalOidTipoMoviAsig = conectorParametro("tmalOidTipoMoviAsig").trim();
		traza("MMG:: Valor de atributo tmalOidTipoMoviAsig: " + tmalOidTipoMoviAsig);
		
		String tmalOidTipoMoviRese = conectorParametro("tmalOidTipoMoviRese").trim();
		traza("MMG:: Valor de atributo tmalOidTipoMoviRese: " + tmalOidTipoMoviRese);
		
		String tmalOidTipoMoviFact = conectorParametro("tmalOidTipoMoviFact").trim();
		traza("MMG:: Valor de atributo tmalOidTipoMoviFact: " + tmalOidTipoMoviFact);
		
		String tidoOidTipoDocu = conectorParametro("tidoOidTipoDocu").trim();
		traza("MMG:: Valor de atributo tidoOidTipoDocu: " + tidoOidTipoDocu);
		
		String indPermUnio = conectorParametro("indPermUnio").trim();
		traza("MMG:: Valor de atributo indPermUnio: " + indPermUnio);
		
		String indPediGtZona = conectorParametro("indPediGtZona").trim();
		traza("MMG:: Valor de atributo indPediGtZona: " + indPediGtZona);
		
		String indCambVentBel = conectorParametro("indCambVentBel").trim();
		traza("MMG:: Valor de atributo indCambVentBel: " + indCambVentBel);
		
		String almcOidAlma = conectorParametro("almcOidAlma").trim();
		traza("MMG:: Valor de atributo almcOidAlma: " + almcOidAlma);
		
		String sociOidSoci = conectorParametro("sociOidSoci").trim();
		traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
		
		String valGlos = conectorParametro("valGlos").trim();
		traza("MMG:: Valor de atributo valGlos: " + valGlos);
		
		String tsolOidTipoCons = conectorParametro("tsolOidTipoCons").trim();
		traza("MMG:: Valor de atributo tsolOidTipoCons: " + tsolOidTipoCons);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		PedTipoSolicPaisData pedTipoSolicPais= new PedTipoSolicPaisData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			pedTipoSolicPais.setId(new Long(id));
		}
		pedTipoSolicPais = (PedTipoSolicPaisData)getSingleObject(BUSINESSID_QUERY, pedTipoSolicPais, 
			pedTipoSolicPais.clone(), "pedTipoSolicPais");
		
		if(pedTipoSolicPais == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.PedTipoSolicViewData tsolOidTipoSoliData = null;
		if(tsolOidTipoSoli != null && !tsolOidTipoSoli.trim().equals("")){
			tsolOidTipoSoliData = new es.indra.belcorp.mso.PedTipoSolicViewData();
			tsolOidTipoSoliData.setId(new Long(tsolOidTipoSoli));
		}
		pedTipoSolicPais.setTsolOidTipoSoli(tsolOidTipoSoliData);
		pedTipoSolicPais.setNumSoliLote(
			(java.lang.Long)FormatUtils.parseObject(numSoliLote, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setNumUnidAlar(
			(java.lang.Long)FormatUtils.parseObject(numUnidAlar, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.BelFormaPagoData fopaOidFormPagoData = null;
		if(fopaOidFormPago != null && !fopaOidFormPago.trim().equals("")){
			fopaOidFormPagoData = new es.indra.belcorp.mso.BelFormaPagoData();
			fopaOidFormPagoData.setId(new Long(fopaOidFormPago));
		}
		pedTipoSolicPais.setFopaOidFormPago(fopaOidFormPagoData);
		pedTipoSolicPais.setIndSujeFlet(
			(java.lang.Long)FormatUtils.parseObject(indSujeFlet, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndReseStoc(
			(java.lang.Long)FormatUtils.parseObject(indReseStoc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndPermReve(
			(java.lang.Long)FormatUtils.parseObject(indPermReve, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndPediPrue(
			(java.lang.Long)FormatUtils.parseObject(indPediPrue, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndComi(
			(java.lang.Long)FormatUtils.parseObject(indComi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndVentInteSab14(
			(java.lang.Long)FormatUtils.parseObject(indVentInteSab14, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CraActivData cactOidActiData = null;
		if(cactOidActi != null && !cactOidActi.trim().equals("")){
			cactOidActiData = new es.indra.belcorp.mso.CraActivData();
			cactOidActiData.setId(new Long(cactOidActi));
		}
		pedTipoSolicPais.setCactOidActi(cactOidActiData);
		es.indra.belcorp.mso.SegMonedData moneOidMoneData = null;
		if(moneOidMone != null && !moneOidMone.trim().equals("")){
			moneOidMoneData = new es.indra.belcorp.mso.SegMonedData();
			moneOidMoneData.setId(new Long(moneOidMone));
		}
		pedTipoSolicPais.setMoneOidMone(moneOidMoneData);
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviAsigData = null;
		if(tmalOidTipoMoviAsig != null && !tmalOidTipoMoviAsig.trim().equals("")){
			tmalOidTipoMoviAsigData = new es.indra.belcorp.mso.BelTipoMovimAlmacData();
			tmalOidTipoMoviAsigData.setId(new Long(tmalOidTipoMoviAsig));
		}
		pedTipoSolicPais.setTmalOidTipoMoviAsig(tmalOidTipoMoviAsigData);
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviReseData = null;
		if(tmalOidTipoMoviRese != null && !tmalOidTipoMoviRese.trim().equals("")){
			tmalOidTipoMoviReseData = new es.indra.belcorp.mso.BelTipoMovimAlmacData();
			tmalOidTipoMoviReseData.setId(new Long(tmalOidTipoMoviRese));
		}
		pedTipoSolicPais.setTmalOidTipoMoviRese(tmalOidTipoMoviReseData);
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviFactData = null;
		if(tmalOidTipoMoviFact != null && !tmalOidTipoMoviFact.trim().equals("")){
			tmalOidTipoMoviFactData = new es.indra.belcorp.mso.BelTipoMovimAlmacData();
			tmalOidTipoMoviFactData.setId(new Long(tmalOidTipoMoviFact));
		}
		pedTipoSolicPais.setTmalOidTipoMoviFact(tmalOidTipoMoviFactData);
		es.indra.belcorp.mso.FacTipoDocumData tidoOidTipoDocuData = null;
		if(tidoOidTipoDocu != null && !tidoOidTipoDocu.trim().equals("")){
			tidoOidTipoDocuData = new es.indra.belcorp.mso.FacTipoDocumData();
			tidoOidTipoDocuData.setId(new Long(tidoOidTipoDocu));
		}
		pedTipoSolicPais.setTidoOidTipoDocu(tidoOidTipoDocuData);
		pedTipoSolicPais.setIndPermUnio(
			(java.lang.Long)FormatUtils.parseObject(indPermUnio, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndPediGtZona(
			(java.lang.Long)FormatUtils.parseObject(indPediGtZona, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		pedTipoSolicPais.setIndCambVentBel(
			(java.lang.Long)FormatUtils.parseObject(indCambVentBel, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.BelAlmacData almcOidAlmaData = null;
		if(almcOidAlma != null && !almcOidAlma.trim().equals("")){
			almcOidAlmaData = new es.indra.belcorp.mso.BelAlmacData();
			almcOidAlmaData.setId(new Long(almcOidAlma));
		}
		pedTipoSolicPais.setAlmcOidAlma(almcOidAlmaData);
		es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
		if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
			sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
			sociOidSociData.setId(new Long(sociOidSoci));
		}
		pedTipoSolicPais.setSociOidSoci(sociOidSociData);
		pedTipoSolicPais.setValGlos(
			(java.lang.String)FormatUtils.parseObject(valGlos, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.PedTipoSolicPaisViewData tsolOidTipoConsData = null;
		if(tsolOidTipoCons != null && !tsolOidTipoCons.trim().equals("")){
			tsolOidTipoConsData = new es.indra.belcorp.mso.PedTipoSolicPaisViewData();
			tsolOidTipoConsData.setId(new Long(tsolOidTipoCons));
		}
		pedTipoSolicPais.setTsolOidTipoCons(tsolOidTipoConsData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//pedTipoSolicPais.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("pedTipoSolicPais", pedTipoSolicPais);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(pedTipoSolicPais);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad PedTipoSolicPais");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad PedTipoSolicPais");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(pedTipoSolicPais);
		
		
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
			PedTipoSolicPaisData pedTipoSolicPais = new PedTipoSolicPaisData();
			pedTipoSolicPais.setId(new Long(claves.nextToken()));
			//pedTipoSolicPais.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(pedTipoSolicPais);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad PedTipoSolicPais");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad PedTipoSolicPais");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("PedTipoSolicPaisLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(PedTipoSolicPaisData pedTipoSolicPais) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                pedTipoSolicPais.setPaisOidPais(paisOculto);
               
			
	}
	

	protected void cmdPreUpdate(PedTipoSolicPaisData pedTipoSolicPais) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                pedTipoSolicPais.setPaisOidPais(paisOculto);
                
			
	}
	
	
	

	protected void cmdPostCreate(PedTipoSolicPaisData pedTipoSolicPais) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                pedTipoSolicPais.setPaisOidPais(paisOculto);
                
			
	}
	

	protected void cmdPostUpdate(PedTipoSolicPaisData pedTipoSolicPais) throws Exception{
		
				
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                pedTipoSolicPais.setPaisOidPais(paisOculto);
                
			
	}
	
	
	
	
}




