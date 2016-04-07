

/*
    INDRA/CAR/mmg
    $Id: CccCuentCorriBancaLPExecution.java,v 1.1 2009/12/03 18:38:48 pecbazalar Exp $
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

public class CccCuentCorriBancaLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCccCuentCorriBancaCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCccCuentCorriBancaUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCccCuentCorriBancaRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCccCuentCorriBancaQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CccCuentCorriBancaConectorCreate";
	public static final String CONECTOR_UPDATE = "CccCuentCorriBancaConectorUpdate";
	public static final String CONECTOR_REMOVE = "CccCuentCorriBancaConectorRemove";

	public CccCuentCorriBancaLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CccCuentCorriBancaPage");
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
  	correspondiente a la creación de un/a nuevo CccCuentCorriBanca*/  
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
		
		traza("MMG::Creando CccCuentCorriBanca");
		
		String codCc = conectorParametro("codCc").trim();
		traza("MMG:: Valor de atributo codCc: " + codCc);
		if(codCc != null && !codCc.trim().equals("")) codCc = codCc.toUpperCase();
		
		String sociOidSoci = conectorParametro("sociOidSoci").trim();
		traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
		if(sociOidSoci != null && !sociOidSoci.trim().equals("")) sociOidSoci = sociOidSoci.toUpperCase();
		
		String desCc = conectorParametro("desCc").trim();
		traza("MMG:: Valor de atributo desCc: " + desCc);
		if(desCc != null && !desCc.trim().equals("")) desCc = desCc.toUpperCase();
		
		String cucoOidCcTeso = conectorParametro("cucoOidCcTeso").trim();
		traza("MMG:: Valor de atributo cucoOidCcTeso: " + cucoOidCcTeso);
		if(cucoOidCcTeso != null && !cucoOidCcTeso.trim().equals("")) cucoOidCcTeso = cucoOidCcTeso.toUpperCase();
		
		String cucoOidCcPnte = conectorParametro("cucoOidCcPnte").trim();
		traza("MMG:: Valor de atributo cucoOidCcPnte: " + cucoOidCcPnte);
		if(cucoOidCcPnte != null && !cucoOidCcPnte.trim().equals("")) cucoOidCcPnte = cucoOidCcPnte.toUpperCase();
		
		String codCcBanc = conectorParametro("codCcBanc").trim();
		traza("MMG:: Valor de atributo codCcBanc: " + codCcBanc);
		if(codCcBanc != null && !codCcBanc.trim().equals("")) codCcBanc = codCcBanc.toUpperCase();
		
		String sucuOidSucu = conectorParametro("sucuOidSucu").trim();
		traza("MMG:: Valor de atributo sucuOidSucu: " + sucuOidSucu);
		if(sucuOidSucu != null && !sucuOidSucu.trim().equals("")) sucuOidSucu = sucuOidSucu.toUpperCase();
		
		String valNumeSwif = conectorParametro("valNumeSwif").trim();
		traza("MMG:: Valor de atributo valNumeSwif: " + valNumeSwif);
		if(valNumeSwif != null && !valNumeSwif.trim().equals("")) valNumeSwif = valNumeSwif.toUpperCase();
		
		String valDire = conectorParametro("valDire").trim();
		traza("MMG:: Valor de atributo valDire: " + valDire);
		if(valDire != null && !valDire.trim().equals("")) valDire = valDire.toUpperCase();
		
		String valCont = conectorParametro("valCont").trim();
		traza("MMG:: Valor de atributo valCont: " + valCont);
		if(valCont != null && !valCont.trim().equals("")) valCont = valCont.toUpperCase();
		
		String valTele = conectorParametro("valTele").trim();
		traza("MMG:: Valor de atributo valTele: " + valTele);
		if(valTele != null && !valTele.trim().equals("")) valTele = valTele.toUpperCase();
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		if(valObse != null && !valObse.trim().equals("")) valObse = valObse.toUpperCase();
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CccCuentCorriBancaData cccCuentCorriBanca= new CccCuentCorriBancaData();
		cccCuentCorriBanca.setCodCc(
			(java.lang.String)FormatUtils.parseObject(codCc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
		if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
			sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
			sociOidSociData.setId(new Long(sociOidSoci));
		}
		cccCuentCorriBanca.setSociOidSoci(sociOidSociData);
		cccCuentCorriBanca.setDesCc(
			(java.lang.String)FormatUtils.parseObject(desCc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CccCuentContaData cucoOidCcTesoData = null;
		if(cucoOidCcTeso != null && !cucoOidCcTeso.trim().equals("")){
			cucoOidCcTesoData = new es.indra.belcorp.mso.CccCuentContaData();
			cucoOidCcTesoData.setId(new Long(cucoOidCcTeso));
		}
		cccCuentCorriBanca.setCucoOidCcTeso(cucoOidCcTesoData);
		es.indra.belcorp.mso.CccCuentContaData cucoOidCcPnteData = null;
		if(cucoOidCcPnte != null && !cucoOidCcPnte.trim().equals("")){
			cucoOidCcPnteData = new es.indra.belcorp.mso.CccCuentContaData();
			cucoOidCcPnteData.setId(new Long(cucoOidCcPnte));
		}
		cccCuentCorriBanca.setCucoOidCcPnte(cucoOidCcPnteData);
		cccCuentCorriBanca.setCodCcBanc(
			(java.lang.String)FormatUtils.parseObject(codCcBanc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CccSucurData sucuOidSucuData = null;
		if(sucuOidSucu != null && !sucuOidSucu.trim().equals("")){
			sucuOidSucuData = new es.indra.belcorp.mso.CccSucurData();
			sucuOidSucuData.setId(new Long(sucuOidSucu));
		}
		cccCuentCorriBanca.setSucuOidSucu(sucuOidSucuData);
		cccCuentCorriBanca.setValNumeSwif(
			(java.lang.String)FormatUtils.parseObject(valNumeSwif, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccCuentCorriBanca.setValDire(
			(java.lang.String)FormatUtils.parseObject(valDire, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccCuentCorriBanca.setValCont(
			(java.lang.String)FormatUtils.parseObject(valCont, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccCuentCorriBanca.setValTele(
			(java.lang.String)FormatUtils.parseObject(valTele, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccCuentCorriBanca.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccCuentCorriBanca", cccCuentCorriBanca);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(cccCuentCorriBanca);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CccCuentCorriBanca");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CccCuentCorriBanca");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(cccCuentCorriBanca);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CccCuentCorriBancaLPStartUp");
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
		traza("MMG::Creando CccCuentCorriBanca");
		
		String codCc = conectorParametro("codCc").trim();
		traza("MMG:: Valor de atributo codCc: " + codCc);
		if(codCc != null && !codCc.trim().equals("")) codCc = codCc.toUpperCase();
		
		String sociOidSoci = conectorParametro("sociOidSoci").trim();
		traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
		if(sociOidSoci != null && !sociOidSoci.trim().equals("")) sociOidSoci = sociOidSoci.toUpperCase();
		
		String desCc = conectorParametro("desCc").trim();
		traza("MMG:: Valor de atributo desCc: " + desCc);
		if(desCc != null && !desCc.trim().equals("")) desCc = desCc.toUpperCase();
		
		String cucoOidCcTeso = conectorParametro("cucoOidCcTeso").trim();
		traza("MMG:: Valor de atributo cucoOidCcTeso: " + cucoOidCcTeso);
		if(cucoOidCcTeso != null && !cucoOidCcTeso.trim().equals("")) cucoOidCcTeso = cucoOidCcTeso.toUpperCase();
		
		String cucoOidCcPnte = conectorParametro("cucoOidCcPnte").trim();
		traza("MMG:: Valor de atributo cucoOidCcPnte: " + cucoOidCcPnte);
		if(cucoOidCcPnte != null && !cucoOidCcPnte.trim().equals("")) cucoOidCcPnte = cucoOidCcPnte.toUpperCase();
		
		String codCcBanc = conectorParametro("codCcBanc").trim();
		traza("MMG:: Valor de atributo codCcBanc: " + codCcBanc);
		if(codCcBanc != null && !codCcBanc.trim().equals("")) codCcBanc = codCcBanc.toUpperCase();
		
		String sucuOidSucu = conectorParametro("sucuOidSucu").trim();
		traza("MMG:: Valor de atributo sucuOidSucu: " + sucuOidSucu);
		if(sucuOidSucu != null && !sucuOidSucu.trim().equals("")) sucuOidSucu = sucuOidSucu.toUpperCase();
		
		String valNumeSwif = conectorParametro("valNumeSwif").trim();
		traza("MMG:: Valor de atributo valNumeSwif: " + valNumeSwif);
		if(valNumeSwif != null && !valNumeSwif.trim().equals("")) valNumeSwif = valNumeSwif.toUpperCase();
		
		String valDire = conectorParametro("valDire").trim();
		traza("MMG:: Valor de atributo valDire: " + valDire);
		if(valDire != null && !valDire.trim().equals("")) valDire = valDire.toUpperCase();
		
		String valCont = conectorParametro("valCont").trim();
		traza("MMG:: Valor de atributo valCont: " + valCont);
		if(valCont != null && !valCont.trim().equals("")) valCont = valCont.toUpperCase();
		
		String valTele = conectorParametro("valTele").trim();
		traza("MMG:: Valor de atributo valTele: " + valTele);
		if(valTele != null && !valTele.trim().equals("")) valTele = valTele.toUpperCase();
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		if(valObse != null && !valObse.trim().equals("")) valObse = valObse.toUpperCase();
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CccCuentCorriBancaData cccCuentCorriBanca= new CccCuentCorriBancaData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cccCuentCorriBanca.setId(new Long(id));
		}
		cccCuentCorriBanca = (CccCuentCorriBancaData)getSingleObject(BUSINESSID_QUERY, cccCuentCorriBanca, 
			cccCuentCorriBanca.clone(), "cccCuentCorriBanca");
		
		if(cccCuentCorriBanca == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		cccCuentCorriBanca.setCodCc(
			(java.lang.String)FormatUtils.parseObject(codCc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
		if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
			sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
			sociOidSociData.setId(new Long(sociOidSoci));
		}
		cccCuentCorriBanca.setSociOidSoci(sociOidSociData);
		cccCuentCorriBanca.setDesCc(
			(java.lang.String)FormatUtils.parseObject(desCc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CccCuentContaData cucoOidCcTesoData = null;
		if(cucoOidCcTeso != null && !cucoOidCcTeso.trim().equals("")){
			cucoOidCcTesoData = new es.indra.belcorp.mso.CccCuentContaData();
			cucoOidCcTesoData.setId(new Long(cucoOidCcTeso));
		}
		cccCuentCorriBanca.setCucoOidCcTeso(cucoOidCcTesoData);
		es.indra.belcorp.mso.CccCuentContaData cucoOidCcPnteData = null;
		if(cucoOidCcPnte != null && !cucoOidCcPnte.trim().equals("")){
			cucoOidCcPnteData = new es.indra.belcorp.mso.CccCuentContaData();
			cucoOidCcPnteData.setId(new Long(cucoOidCcPnte));
		}
		cccCuentCorriBanca.setCucoOidCcPnte(cucoOidCcPnteData);
		cccCuentCorriBanca.setCodCcBanc(
			(java.lang.String)FormatUtils.parseObject(codCcBanc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CccSucurData sucuOidSucuData = null;
		if(sucuOidSucu != null && !sucuOidSucu.trim().equals("")){
			sucuOidSucuData = new es.indra.belcorp.mso.CccSucurData();
			sucuOidSucuData.setId(new Long(sucuOidSucu));
		}
		cccCuentCorriBanca.setSucuOidSucu(sucuOidSucuData);
		cccCuentCorriBanca.setValNumeSwif(
			(java.lang.String)FormatUtils.parseObject(valNumeSwif, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccCuentCorriBanca.setValDire(
			(java.lang.String)FormatUtils.parseObject(valDire, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccCuentCorriBanca.setValCont(
			(java.lang.String)FormatUtils.parseObject(valCont, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccCuentCorriBanca.setValTele(
			(java.lang.String)FormatUtils.parseObject(valTele, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccCuentCorriBanca.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cccCuentCorriBanca.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccCuentCorriBanca", cccCuentCorriBanca);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(cccCuentCorriBanca);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CccCuentCorriBanca");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CccCuentCorriBanca");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(cccCuentCorriBanca);
		
		
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
			CccCuentCorriBancaData cccCuentCorriBanca = new CccCuentCorriBancaData();
			cccCuentCorriBanca.setId(new Long(claves.nextToken()));
			//cccCuentCorriBanca.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cccCuentCorriBanca);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CccCuentCorriBanca");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CccCuentCorriBanca");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CccCuentCorriBancaLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(CccCuentCorriBancaData cccCuentCorriBanca) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentCorriBanca.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPreUpdate(CccCuentCorriBancaData cccCuentCorriBanca) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentCorriBanca.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(CccCuentCorriBancaData cccCuentCorriBanca) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentCorriBanca.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(CccCuentCorriBancaData cccCuentCorriBanca) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentCorriBanca.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




