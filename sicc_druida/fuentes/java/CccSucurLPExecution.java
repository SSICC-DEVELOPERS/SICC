

/*
    INDRA/CAR/mmg
    $Id: CccSucurLPExecution.java,v 1.1 2009/12/03 18:34:45 pecbazalar Exp $
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

public class CccSucurLPExecution extends MMGDruidaBase{
	//Constantes de l�ogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCccSucurCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCccSucurUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCccSucurRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCccSucurQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "CccSucurConectorCreate";
	public static final String CONECTOR_UPDATE = "CccSucurConectorUpdate";
	public static final String CONECTOR_REMOVE = "CccSucurConectorRemove";

	public CccSucurLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CccSucurPage");
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		//Activamos las trazas
		setTrazaFichero();
	
		try{
			//Sacamos la acci�n a realizar y ejecutamos la acci�n correspondiente
			String accion = conectorParametro(PARAMETRO_GENERICO_ACCION);
			String origen = conectorParametro(PARAMETRO_GENERICO_ORIGEN);
			
			//Caragamos los elemetnos en la pagina
			asignar("VAR",PARAMETRO_GENERICO_ACCION,accion);
			asignar("VAR",PARAMETRO_GENERICO_ORIGEN,origen);
	
			//Ejecutamos la acci�n indicada
			if(accion.equals(ACCION_CREATE)) cmdCreate();
			if(accion.equals(ACCION_UPDATE)) cmdUpdate();
			if(accion.equals(ACCION_REMOVE)) cmdRemove();
		}catch(Exception e){
			handleException(e);
		}
  }
  
  /**Permite crear un nuevo elemento de la entidad. Invoca la l�gica de negocio
  	correspondiente a la creaci�n de un/a nuevo CccSucur*/  
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
		
		traza("MMG::Creando CccSucur");
		
		String cbanOidBanc = conectorParametro("cbanOidBanc").trim();
		traza("MMG:: Valor de atributo cbanOidBanc: " + cbanOidBanc);
		
		String codSucu = conectorParametro("codSucu").trim();
		traza("MMG:: Valor de atributo codSucu: " + codSucu);
		if(codSucu != null && !codSucu.trim().equals("")) codSucu = codSucu.toUpperCase();
		
		String valDire = conectorParametro("valDire").trim();
		traza("MMG:: Valor de atributo valDire: " + valDire);
		
		String valCiud = conectorParametro("valCiud").trim();
		traza("MMG:: Valor de atributo valCiud: " + valCiud);
		
		String valDepa = conectorParametro("valDepa").trim();
		traza("MMG:: Valor de atributo valDepa: " + valDepa);
		
		String valDist = conectorParametro("valDist").trim();
		traza("MMG:: Valor de atributo valDist: " + valDist);
		
		String valCont = conectorParametro("valCont").trim();
		traza("MMG:: Valor de atributo valCont: " + valCont);
		
		String valTfno = conectorParametro("valTfno").trim();
		traza("MMG:: Valor de atributo valTfno: " + valTfno);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		CccSucurData cccSucur= new CccSucurData();
		es.indra.belcorp.mso.CccBancoData cbanOidBancData = null;
		if(cbanOidBanc != null && !cbanOidBanc.trim().equals("")){
			cbanOidBancData = new es.indra.belcorp.mso.CccBancoData();
			cbanOidBancData.setId(new Long(cbanOidBanc));
		}
		cccSucur.setCbanOidBanc(cbanOidBancData);
		cccSucur.setCodSucu(
			(java.lang.String)FormatUtils.parseObject(codSucu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValDire(
			(java.lang.String)FormatUtils.parseObject(valDire, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValCiud(
			(java.lang.String)FormatUtils.parseObject(valCiud, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValDepa(
			(java.lang.String)FormatUtils.parseObject(valDepa, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValDist(
			(java.lang.String)FormatUtils.parseObject(valDist, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValCont(
			(java.lang.String)FormatUtils.parseObject(valCont, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValTfno(
			(java.lang.String)FormatUtils.parseObject(valTfno, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccSucur", cccSucur);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Create de entidad CccSucur");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecuci�n Create de entidad CccSucur");
		
		
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp
		conectorAction("CccSucurLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operaci�n de modificaci�n sobre el elemento seleccionado*/  
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
		traza("MMG::Creando CccSucur");
		
		String cbanOidBanc = conectorParametro("cbanOidBanc").trim();
		traza("MMG:: Valor de atributo cbanOidBanc: " + cbanOidBanc);
		
		String codSucu = conectorParametro("codSucu").trim();
		traza("MMG:: Valor de atributo codSucu: " + codSucu);
		if(codSucu != null && !codSucu.trim().equals("")) codSucu = codSucu.toUpperCase();
		
		String valDire = conectorParametro("valDire").trim();
		traza("MMG:: Valor de atributo valDire: " + valDire);
		
		String valCiud = conectorParametro("valCiud").trim();
		traza("MMG:: Valor de atributo valCiud: " + valCiud);
		
		String valDepa = conectorParametro("valDepa").trim();
		traza("MMG:: Valor de atributo valDepa: " + valDepa);
		
		String valDist = conectorParametro("valDist").trim();
		traza("MMG:: Valor de atributo valDist: " + valDist);
		
		String valCont = conectorParametro("valCont").trim();
		traza("MMG:: Valor de atributo valCont: " + valCont);
		
		String valTfno = conectorParametro("valTfno").trim();
		traza("MMG:: Valor de atributo valTfno: " + valTfno);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CccSucurData cccSucur= new CccSucurData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			cccSucur.setId(new Long(id));
		}
		cccSucur = (CccSucurData)getSingleObject(BUSINESSID_QUERY, cccSucur, 
			cccSucur.clone(), "cccSucur");
		
		if(cccSucur == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.CccBancoData cbanOidBancData = null;
		if(cbanOidBanc != null && !cbanOidBanc.trim().equals("")){
			cbanOidBancData = new es.indra.belcorp.mso.CccBancoData();
			cbanOidBancData.setId(new Long(cbanOidBanc));
		}
		cccSucur.setCbanOidBanc(cbanOidBancData);
		cccSucur.setCodSucu(
			(java.lang.String)FormatUtils.parseObject(codSucu, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValDire(
			(java.lang.String)FormatUtils.parseObject(valDire, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValCiud(
			(java.lang.String)FormatUtils.parseObject(valCiud, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValDepa(
			(java.lang.String)FormatUtils.parseObject(valDepa, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValDist(
			(java.lang.String)FormatUtils.parseObject(valDist, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValCont(
			(java.lang.String)FormatUtils.parseObject(valCont, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValTfno(
			(java.lang.String)FormatUtils.parseObject(valTfno, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		cccSucur.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//cccSucur.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acci�n de realizar una modificaci�n
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("cccSucur", cccSucur);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Update de entidad CccSucur");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecuci�n Update de entidad CccSucur");

		
		
		//Redirigimos a la LP que cierra el dialogo
		//Registramos que se recagen los datos en la venta en la cual se ha producido la operaci�n
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
			CccSucurData cccSucur = new CccSucurData();
			cccSucur.setId(new Long(claves.nextToken()));
			//cccSucur.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(cccSucur);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la l�gica de negocio
		traza("MMG:: Iniciada ejecuci�n Remove de entidad CccSucur");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecuci�n Remove de entidad CccSucur");
		
		

		//metemos en la sesi�n las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acci�n de StartUp y requery
		conectorAction("CccSucurLPStartUp");
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




