

/*
    INDRA/CAR/mmg
    $Id: RecOperaLPExecution.java,v 1.1 2009/12/03 18:39:08 pecbazalar Exp $
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

public class RecOperaLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGRecOperaCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGRecOperaUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGRecOperaRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGRecOperaQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "RecOperaConectorCreate";
	public static final String CONECTOR_UPDATE = "RecOperaConectorUpdate";
	public static final String CONECTOR_REMOVE = "RecOperaConectorRemove";

	public RecOperaLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("RecOperaPage");
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
  	correspondiente a la creación de un/a nuevo RecOpera*/  
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
		
		traza("MMG::Creando RecOpera");
		
		String codOper = conectorParametro("codOper").trim();
		traza("MMG:: Valor de atributo codOper: " + codOper);
		if(codOper != null && !codOper.trim().equals("")) codOper = codOper.toUpperCase();
		
		String valDescLarg = conectorParametro("valDescLarg").trim();
		traza("MMG:: Valor de atributo valDescLarg: " + valDescLarg);
		
		String indAnul = conectorParametro("indAnul").trim();
		traza("MMG:: Valor de atributo indAnul: " + indAnul);
		
		String indIngrEnvi = conectorParametro("indIngrEnvi").trim();
		traza("MMG:: Valor de atributo indIngrEnvi: " + indIngrEnvi);
		
		String valIngrDevu = conectorParametro("valIngrDevu").trim();
		traza("MMG:: Valor de atributo valIngrDevu: " + valIngrDevu);
		
		String valPerd = conectorParametro("valPerd").trim();
		traza("MMG:: Valor de atributo valPerd: " + valPerd);
		
		String indEspeMercFisi = conectorParametro("indEspeMercFisi").trim();
		traza("MMG:: Valor de atributo indEspeMercFisi: " + indEspeMercFisi);
		
		String indDevuFisiFact = conectorParametro("indDevuFisiFact").trim();
		traza("MMG:: Valor de atributo indDevuFisiFact: " + indDevuFisiFact);
		
		String numCampHist = conectorParametro("numCampHist").trim();
		traza("MMG:: Valor de atributo numCampHist: " + numCampHist);
		
		String indEnviGeneDevu = conectorParametro("indEnviGeneDevu").trim();
		traza("MMG:: Valor de atributo indEnviGeneDevu: " + indEnviGeneDevu);
		
		String indDevuGeneEnvi = conectorParametro("indDevuGeneEnvi").trim();
		traza("MMG:: Valor de atributo indDevuGeneEnvi: " + indDevuGeneEnvi);
		
		String almcOidAlma = conectorParametro("almcOidAlma").trim();
		traza("MMG:: Valor de atributo almcOidAlma: " + almcOidAlma);
		
		String peciOidPeci = conectorParametro("peciOidPeci").trim();
		traza("MMG:: Valor de atributo peciOidPeci: " + peciOidPeci);
		
		String mensOidMens = conectorParametro("mensOidMens").trim();
		traza("MMG:: Valor de atributo mensOidMens: " + mensOidMens);
		
		String tspaOidSoliPaisPerd = conectorParametro("tspaOidSoliPaisPerd").trim();
		traza("MMG:: Valor de atributo tspaOidSoliPaisPerd: " + tspaOidSoliPaisPerd);
		
		String tmalOidTipoMoviAlma = conectorParametro("tmalOidTipoMoviAlma").trim();
		traza("MMG:: Valor de atributo tmalOidTipoMoviAlma: " + tmalOidTipoMoviAlma);
		
		String mdefOidModoAbonDefe = conectorParametro("mdefOidModoAbonDefe").trim();
		traza("MMG:: Valor de atributo mdefOidModoAbonDefe: " + mdefOidModoAbonDefe);
		
		String penvOidPrecioEnvia = conectorParametro("penvOidPrecioEnvia").trim();
		traza("MMG:: Valor de atributo penvOidPrecioEnvia: " + penvOidPrecioEnvia);
		
		String tspaOidSoliPaisGene = conectorParametro("tspaOidSoliPaisGene").trim();
		traza("MMG:: Valor de atributo tspaOidSoliPaisGene: " + tspaOidSoliPaisGene);
		
		String moblOidMotiBloq = conectorParametro("moblOidMotiBloq").trim();
		traza("MMG:: Valor de atributo moblOidMotiBloq: " + moblOidMotiBloq);
		
		String indFaltMerc = conectorParametro("indFaltMerc").trim();
		traza("MMG:: Valor de atributo indFaltMerc: " + indFaltMerc);
		
		String tspaOidSoliSinStoc = conectorParametro("tspaOidSoliSinStoc").trim();
		traza("MMG:: Valor de atributo tspaOidSoliSinStoc: " + tspaOidSoliSinStoc);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		RecOperaData recOpera= new RecOperaData();
		recOpera.setCodOper(
			(java.lang.String)FormatUtils.parseObject(codOper, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setValDescLarg(
			(java.lang.String)FormatUtils.parseObject(valDescLarg, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setIndAnul(
			(java.lang.Long)FormatUtils.parseObject(indAnul, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setIndIngrEnvi(
			(java.lang.Long)FormatUtils.parseObject(indIngrEnvi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setValIngrDevu(
			(java.lang.Long)FormatUtils.parseObject(valIngrDevu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setValPerd(
			(java.lang.Long)FormatUtils.parseObject(valPerd, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setIndEspeMercFisi(
			(java.lang.Long)FormatUtils.parseObject(indEspeMercFisi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setIndDevuFisiFact(
			(java.lang.Long)FormatUtils.parseObject(indDevuFisiFact, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setNumCampHist(
			(java.lang.Long)FormatUtils.parseObject(numCampHist, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setIndEnviGeneDevu(
			(java.lang.Long)FormatUtils.parseObject(indEnviGeneDevu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setIndDevuGeneEnvi(
			(java.lang.Long)FormatUtils.parseObject(indDevuGeneEnvi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.BelAlmacData almcOidAlmaData = null;
		if(almcOidAlma != null && !almcOidAlma.trim().equals("")){
			almcOidAlmaData = new es.indra.belcorp.mso.BelAlmacData();
			almcOidAlmaData.setId(new Long(almcOidAlma));
		}
		recOpera.setAlmcOidAlma(almcOidAlmaData);
		es.indra.belcorp.mso.RecPreciData peciOidPeciData = null;
		if(peciOidPeci != null && !peciOidPeci.trim().equals("")){
			peciOidPeciData = new es.indra.belcorp.mso.RecPreciData();
			peciOidPeciData.setId(new Long(peciOidPeci));
		}
		recOpera.setPeciOidPeci(peciOidPeciData);
		es.indra.belcorp.mso.MsgMensaData mensOidMensData = null;
		if(mensOidMens != null && !mensOidMens.trim().equals("")){
			mensOidMensData = new es.indra.belcorp.mso.MsgMensaData();
			mensOidMensData.setId(new Long(mensOidMens));
		}
		recOpera.setMensOidMens(mensOidMensData);
		es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliPaisPerdData = null;
		if(tspaOidSoliPaisPerd != null && !tspaOidSoliPaisPerd.trim().equals("")){
			tspaOidSoliPaisPerdData = new es.indra.belcorp.mso.PedTipoSolicPaisData();
			tspaOidSoliPaisPerdData.setId(new Long(tspaOidSoliPaisPerd));
		}
		recOpera.setTspaOidSoliPaisPerd(tspaOidSoliPaisPerdData);
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviAlmaData = null;
		if(tmalOidTipoMoviAlma != null && !tmalOidTipoMoviAlma.trim().equals("")){
			tmalOidTipoMoviAlmaData = new es.indra.belcorp.mso.BelTipoMovimAlmacData();
			tmalOidTipoMoviAlmaData.setId(new Long(tmalOidTipoMoviAlma));
		}
		recOpera.setTmalOidTipoMoviAlma(tmalOidTipoMoviAlmaData);
		es.indra.belcorp.mso.RecModoAbonoDefecData mdefOidModoAbonDefeData = null;
		if(mdefOidModoAbonDefe != null && !mdefOidModoAbonDefe.trim().equals("")){
			mdefOidModoAbonDefeData = new es.indra.belcorp.mso.RecModoAbonoDefecData();
			mdefOidModoAbonDefeData.setId(new Long(mdefOidModoAbonDefe));
		}
		recOpera.setMdefOidModoAbonDefe(mdefOidModoAbonDefeData);
		es.indra.belcorp.mso.RecPreciEnviaData penvOidPrecioEnviaData = null;
		if(penvOidPrecioEnvia != null && !penvOidPrecioEnvia.trim().equals("")){
			penvOidPrecioEnviaData = new es.indra.belcorp.mso.RecPreciEnviaData();
			penvOidPrecioEnviaData.setId(new Long(penvOidPrecioEnvia));
		}
		recOpera.setPenvOidPrecioEnvia(penvOidPrecioEnviaData);
		es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliPaisGeneData = null;
		if(tspaOidSoliPaisGene != null && !tspaOidSoliPaisGene.trim().equals("")){
			tspaOidSoliPaisGeneData = new es.indra.belcorp.mso.PedTipoSolicPaisData();
			tspaOidSoliPaisGeneData.setId(new Long(tspaOidSoliPaisGene));
		}
		recOpera.setTspaOidSoliPaisGene(tspaOidSoliPaisGeneData);
		es.indra.belcorp.mso.RecMotivBloquData moblOidMotiBloqData = null;
		if(moblOidMotiBloq != null && !moblOidMotiBloq.trim().equals("")){
			moblOidMotiBloqData = new es.indra.belcorp.mso.RecMotivBloquData();
			moblOidMotiBloqData.setId(new Long(moblOidMotiBloq));
		}
		recOpera.setMoblOidMotiBloq(moblOidMotiBloqData);
		recOpera.setIndFaltMerc(
			(java.lang.Long)FormatUtils.parseObject(indFaltMerc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliSinStocData = null;
		if(tspaOidSoliSinStoc != null && !tspaOidSoliSinStoc.trim().equals("")){
			tspaOidSoliSinStocData = new es.indra.belcorp.mso.PedTipoSolicPaisData();
			tspaOidSoliSinStocData.setId(new Long(tspaOidSoliSinStoc));
		}
		recOpera.setTspaOidSoliSinStoc(tspaOidSoliSinStocData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("recOpera", recOpera);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(recOpera);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad RecOpera");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad RecOpera");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(recOpera);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("RecOperaLPStartUp");
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
		traza("MMG::Creando RecOpera");
		
		String codOper = conectorParametro("codOper").trim();
		traza("MMG:: Valor de atributo codOper: " + codOper);
		if(codOper != null && !codOper.trim().equals("")) codOper = codOper.toUpperCase();
		
		String valDescLarg = conectorParametro("valDescLarg").trim();
		traza("MMG:: Valor de atributo valDescLarg: " + valDescLarg);
		
		String indAnul = conectorParametro("indAnul").trim();
		traza("MMG:: Valor de atributo indAnul: " + indAnul);
		
		String indIngrEnvi = conectorParametro("indIngrEnvi").trim();
		traza("MMG:: Valor de atributo indIngrEnvi: " + indIngrEnvi);
		
		String valIngrDevu = conectorParametro("valIngrDevu").trim();
		traza("MMG:: Valor de atributo valIngrDevu: " + valIngrDevu);
		
		String valPerd = conectorParametro("valPerd").trim();
		traza("MMG:: Valor de atributo valPerd: " + valPerd);
		
		String indEspeMercFisi = conectorParametro("indEspeMercFisi").trim();
		traza("MMG:: Valor de atributo indEspeMercFisi: " + indEspeMercFisi);
		
		String indDevuFisiFact = conectorParametro("indDevuFisiFact").trim();
		traza("MMG:: Valor de atributo indDevuFisiFact: " + indDevuFisiFact);
		
		String numCampHist = conectorParametro("numCampHist").trim();
		traza("MMG:: Valor de atributo numCampHist: " + numCampHist);
		
		String indEnviGeneDevu = conectorParametro("indEnviGeneDevu").trim();
		traza("MMG:: Valor de atributo indEnviGeneDevu: " + indEnviGeneDevu);
		
		String indDevuGeneEnvi = conectorParametro("indDevuGeneEnvi").trim();
		traza("MMG:: Valor de atributo indDevuGeneEnvi: " + indDevuGeneEnvi);
		
		String almcOidAlma = conectorParametro("almcOidAlma").trim();
		traza("MMG:: Valor de atributo almcOidAlma: " + almcOidAlma);
		
		String peciOidPeci = conectorParametro("peciOidPeci").trim();
		traza("MMG:: Valor de atributo peciOidPeci: " + peciOidPeci);
		
		String mensOidMens = conectorParametro("mensOidMens").trim();
		traza("MMG:: Valor de atributo mensOidMens: " + mensOidMens);
		
		String tspaOidSoliPaisPerd = conectorParametro("tspaOidSoliPaisPerd").trim();
		traza("MMG:: Valor de atributo tspaOidSoliPaisPerd: " + tspaOidSoliPaisPerd);
		
		String tmalOidTipoMoviAlma = conectorParametro("tmalOidTipoMoviAlma").trim();
		traza("MMG:: Valor de atributo tmalOidTipoMoviAlma: " + tmalOidTipoMoviAlma);
		
		String mdefOidModoAbonDefe = conectorParametro("mdefOidModoAbonDefe").trim();
		traza("MMG:: Valor de atributo mdefOidModoAbonDefe: " + mdefOidModoAbonDefe);
		
		String penvOidPrecioEnvia = conectorParametro("penvOidPrecioEnvia").trim();
		traza("MMG:: Valor de atributo penvOidPrecioEnvia: " + penvOidPrecioEnvia);
		
		String tspaOidSoliPaisGene = conectorParametro("tspaOidSoliPaisGene").trim();
		traza("MMG:: Valor de atributo tspaOidSoliPaisGene: " + tspaOidSoliPaisGene);
		
		String moblOidMotiBloq = conectorParametro("moblOidMotiBloq").trim();
		traza("MMG:: Valor de atributo moblOidMotiBloq: " + moblOidMotiBloq);
		
		String indFaltMerc = conectorParametro("indFaltMerc").trim();
		traza("MMG:: Valor de atributo indFaltMerc: " + indFaltMerc);
		
		String tspaOidSoliSinStoc = conectorParametro("tspaOidSoliSinStoc").trim();
		traza("MMG:: Valor de atributo tspaOidSoliSinStoc: " + tspaOidSoliSinStoc);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		RecOperaData recOpera= new RecOperaData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			recOpera.setId(new Long(id));
		}
		recOpera = (RecOperaData)getSingleObject(BUSINESSID_QUERY, recOpera, 
			recOpera.clone(), "recOpera");
		
		if(recOpera == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		recOpera.setCodOper(
			(java.lang.String)FormatUtils.parseObject(codOper, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setValDescLarg(
			(java.lang.String)FormatUtils.parseObject(valDescLarg, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setIndAnul(
			(java.lang.Long)FormatUtils.parseObject(indAnul, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setIndIngrEnvi(
			(java.lang.Long)FormatUtils.parseObject(indIngrEnvi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setValIngrDevu(
			(java.lang.Long)FormatUtils.parseObject(valIngrDevu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setValPerd(
			(java.lang.Long)FormatUtils.parseObject(valPerd, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setIndEspeMercFisi(
			(java.lang.Long)FormatUtils.parseObject(indEspeMercFisi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setIndDevuFisiFact(
			(java.lang.Long)FormatUtils.parseObject(indDevuFisiFact, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setNumCampHist(
			(java.lang.Long)FormatUtils.parseObject(numCampHist, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setIndEnviGeneDevu(
			(java.lang.Long)FormatUtils.parseObject(indEnviGeneDevu, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		recOpera.setIndDevuGeneEnvi(
			(java.lang.Long)FormatUtils.parseObject(indDevuGeneEnvi, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.BelAlmacData almcOidAlmaData = null;
		if(almcOidAlma != null && !almcOidAlma.trim().equals("")){
			almcOidAlmaData = new es.indra.belcorp.mso.BelAlmacData();
			almcOidAlmaData.setId(new Long(almcOidAlma));
		}
		recOpera.setAlmcOidAlma(almcOidAlmaData);
		es.indra.belcorp.mso.RecPreciData peciOidPeciData = null;
		if(peciOidPeci != null && !peciOidPeci.trim().equals("")){
			peciOidPeciData = new es.indra.belcorp.mso.RecPreciData();
			peciOidPeciData.setId(new Long(peciOidPeci));
		}
		recOpera.setPeciOidPeci(peciOidPeciData);
		es.indra.belcorp.mso.MsgMensaData mensOidMensData = null;
		if(mensOidMens != null && !mensOidMens.trim().equals("")){
			mensOidMensData = new es.indra.belcorp.mso.MsgMensaData();
			mensOidMensData.setId(new Long(mensOidMens));
		}
		recOpera.setMensOidMens(mensOidMensData);
		es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliPaisPerdData = null;
		if(tspaOidSoliPaisPerd != null && !tspaOidSoliPaisPerd.trim().equals("")){
			tspaOidSoliPaisPerdData = new es.indra.belcorp.mso.PedTipoSolicPaisData();
			tspaOidSoliPaisPerdData.setId(new Long(tspaOidSoliPaisPerd));
		}
		recOpera.setTspaOidSoliPaisPerd(tspaOidSoliPaisPerdData);
		es.indra.belcorp.mso.BelTipoMovimAlmacData tmalOidTipoMoviAlmaData = null;
		if(tmalOidTipoMoviAlma != null && !tmalOidTipoMoviAlma.trim().equals("")){
			tmalOidTipoMoviAlmaData = new es.indra.belcorp.mso.BelTipoMovimAlmacData();
			tmalOidTipoMoviAlmaData.setId(new Long(tmalOidTipoMoviAlma));
		}
		recOpera.setTmalOidTipoMoviAlma(tmalOidTipoMoviAlmaData);
		es.indra.belcorp.mso.RecModoAbonoDefecData mdefOidModoAbonDefeData = null;
		if(mdefOidModoAbonDefe != null && !mdefOidModoAbonDefe.trim().equals("")){
			mdefOidModoAbonDefeData = new es.indra.belcorp.mso.RecModoAbonoDefecData();
			mdefOidModoAbonDefeData.setId(new Long(mdefOidModoAbonDefe));
		}
		recOpera.setMdefOidModoAbonDefe(mdefOidModoAbonDefeData);
		es.indra.belcorp.mso.RecPreciEnviaData penvOidPrecioEnviaData = null;
		if(penvOidPrecioEnvia != null && !penvOidPrecioEnvia.trim().equals("")){
			penvOidPrecioEnviaData = new es.indra.belcorp.mso.RecPreciEnviaData();
			penvOidPrecioEnviaData.setId(new Long(penvOidPrecioEnvia));
		}
		recOpera.setPenvOidPrecioEnvia(penvOidPrecioEnviaData);
		es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliPaisGeneData = null;
		if(tspaOidSoliPaisGene != null && !tspaOidSoliPaisGene.trim().equals("")){
			tspaOidSoliPaisGeneData = new es.indra.belcorp.mso.PedTipoSolicPaisData();
			tspaOidSoliPaisGeneData.setId(new Long(tspaOidSoliPaisGene));
		}
		recOpera.setTspaOidSoliPaisGene(tspaOidSoliPaisGeneData);
		es.indra.belcorp.mso.RecMotivBloquData moblOidMotiBloqData = null;
		if(moblOidMotiBloq != null && !moblOidMotiBloq.trim().equals("")){
			moblOidMotiBloqData = new es.indra.belcorp.mso.RecMotivBloquData();
			moblOidMotiBloqData.setId(new Long(moblOidMotiBloq));
		}
		recOpera.setMoblOidMotiBloq(moblOidMotiBloqData);
		recOpera.setIndFaltMerc(
			(java.lang.Long)FormatUtils.parseObject(indFaltMerc, "java.lang.Long", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.PedTipoSolicPaisData tspaOidSoliSinStocData = null;
		if(tspaOidSoliSinStoc != null && !tspaOidSoliSinStoc.trim().equals("")){
			tspaOidSoliSinStocData = new es.indra.belcorp.mso.PedTipoSolicPaisData();
			tspaOidSoliSinStocData.setId(new Long(tspaOidSoliSinStoc));
		}
		recOpera.setTspaOidSoliSinStoc(tspaOidSoliSinStocData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//recOpera.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("recOpera", recOpera);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(recOpera);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad RecOpera");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad RecOpera");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(recOpera);
		
		
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
			RecOperaData recOpera = new RecOperaData();
			recOpera.setId(new Long(claves.nextToken()));
			//recOpera.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(recOpera);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad RecOpera");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad RecOpera");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("RecOperaLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(RecOperaData recOpera) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recOpera.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(RecOperaData recOpera) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recOpera.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(RecOperaData recOpera) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recOpera.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(RecOperaData recOpera) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				recOpera.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




