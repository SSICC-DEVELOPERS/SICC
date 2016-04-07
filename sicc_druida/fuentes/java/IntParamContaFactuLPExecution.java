

/*
    INDRA/CAR/mmg
    $Id: IntParamContaFactuLPExecution.java,v 1.1 2009/12/03 18:39:44 pecbazalar Exp $
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

public class IntParamContaFactuLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGIntParamContaFactuCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGIntParamContaFactuUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGIntParamContaFactuRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGIntParamContaFactuQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "IntParamContaFactuConectorCreate";
	public static final String CONECTOR_UPDATE = "IntParamContaFactuConectorUpdate";
	public static final String CONECTOR_REMOVE = "IntParamContaFactuConectorRemove";

	public IntParamContaFactuLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("IntParamContaFactuPage");
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
  	correspondiente a la creación de un/a nuevo IntParamContaFactu*/  
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
		
		traza("MMG::Creando IntParamContaFactu");
		
		String codApun = conectorParametro("codApun").trim();
		traza("MMG:: Valor de atributo codApun: " + codApun);
		if(codApun != null && !codApun.trim().equals("")) codApun = codApun.toUpperCase();
		
		String valTipoAsie = conectorParametro("valTipoAsie").trim();
		traza("MMG:: Valor de atributo valTipoAsie: " + valTipoAsie);
		
		String valIdenCabeDeta = conectorParametro("valIdenCabeDeta").trim();
		traza("MMG:: Valor de atributo valIdenCabeDeta: " + valIdenCabeDeta);
		
		String valDesc = conectorParametro("valDesc").trim();
		traza("MMG:: Valor de atributo valDesc: " + valDesc);
		
		String valGrupArti = conectorParametro("valGrupArti").trim();
		traza("MMG:: Valor de atributo valGrupArti: " + valGrupArti);
		
		String maprOidMarcProd = conectorParametro("maprOidMarcProd").trim();
		traza("MMG:: Valor de atributo maprOidMarcProd: " + maprOidMarcProd);
		
		String negoOidNego = conectorParametro("negoOidNego").trim();
		traza("MMG:: Valor de atributo negoOidNego: " + negoOidNego);
		
		String prodOidProd = conectorParametro("prodOidProd").trim();
		traza("MMG:: Valor de atributo prodOidProd: " + prodOidProd);
		
		String cucoOidCuenCont = conectorParametro("cucoOidCuenCont").trim();
		traza("MMG:: Valor de atributo cucoOidCuenCont: " + cucoOidCuenCont);
		
		String valIndiDebeHabe = conectorParametro("valIndiDebeHabe").trim();
		traza("MMG:: Valor de atributo valIndiDebeHabe: " + valIndiDebeHabe);
		
		String imcfOidImpoContFact = conectorParametro("imcfOidImpoContFact").trim();
		traza("MMG:: Valor de atributo imcfOidImpoContFact: " + imcfOidImpoContFact);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		IntParamContaFactuData intParamContaFactu= new IntParamContaFactuData();
		intParamContaFactu.setCodApun(
			(java.lang.String)FormatUtils.parseObject(codApun, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		intParamContaFactu.setValTipoAsie(
			(java.lang.String)FormatUtils.parseObject(valTipoAsie, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		intParamContaFactu.setValIdenCabeDeta(
			(java.lang.String)FormatUtils.parseObject(valIdenCabeDeta, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		intParamContaFactu.setValDesc(
			(java.lang.String)FormatUtils.parseObject(valDesc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		intParamContaFactu.setValGrupArti(
			(java.lang.String)FormatUtils.parseObject(valGrupArti, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegMarcaProduData maprOidMarcProdData = null;
		if(maprOidMarcProd != null && !maprOidMarcProd.trim().equals("")){
			maprOidMarcProdData = new es.indra.belcorp.mso.SegMarcaProduData();
			maprOidMarcProdData.setId(new Long(maprOidMarcProd));
		}
		intParamContaFactu.setMaprOidMarcProd(maprOidMarcProdData);
		es.indra.belcorp.mso.MaeNegocViewData negoOidNegoData = null;
		if(negoOidNego != null && !negoOidNego.trim().equals("")){
			negoOidNegoData = new es.indra.belcorp.mso.MaeNegocViewData();
			negoOidNegoData.setId(new Long(negoOidNego));
		}
		intParamContaFactu.setNegoOidNego(negoOidNegoData);
		intParamContaFactu.setProdOidProd(
			(java.lang.String)FormatUtils.parseObject(prodOidProd, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CccCuentContaViewData cucoOidCuenContData = null;
		if(cucoOidCuenCont != null && !cucoOidCuenCont.trim().equals("")){
			cucoOidCuenContData = new es.indra.belcorp.mso.CccCuentContaViewData();
			cucoOidCuenContData.setId(new Long(cucoOidCuenCont));
		}
		intParamContaFactu.setCucoOidCuenCont(cucoOidCuenContData);
		intParamContaFactu.setValIndiDebeHabe(
			(java.lang.String)FormatUtils.parseObject(valIndiDebeHabe, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.IntImporContaFactuData imcfOidImpoContFactData = null;
		if(imcfOidImpoContFact != null && !imcfOidImpoContFact.trim().equals("")){
			imcfOidImpoContFactData = new es.indra.belcorp.mso.IntImporContaFactuData();
			imcfOidImpoContFactData.setId(new Long(imcfOidImpoContFact));
		}
		intParamContaFactu.setImcfOidImpoContFact(imcfOidImpoContFactData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("intParamContaFactu", intParamContaFactu);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Ejecutamos la acción de precreate
		cmdPreCreate(intParamContaFactu);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad IntParamContaFactu");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad IntParamContaFactu");
		
		//Ejecutamos la acción de postcreate
		cmdPostCreate(intParamContaFactu);
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("IntParamContaFactuLPStartUp");
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
		traza("MMG::Creando IntParamContaFactu");
		
		String codApun = conectorParametro("codApun").trim();
		traza("MMG:: Valor de atributo codApun: " + codApun);
		if(codApun != null && !codApun.trim().equals("")) codApun = codApun.toUpperCase();
		
		String valTipoAsie = conectorParametro("valTipoAsie").trim();
		traza("MMG:: Valor de atributo valTipoAsie: " + valTipoAsie);
		
		String valIdenCabeDeta = conectorParametro("valIdenCabeDeta").trim();
		traza("MMG:: Valor de atributo valIdenCabeDeta: " + valIdenCabeDeta);
		
		String valDesc = conectorParametro("valDesc").trim();
		traza("MMG:: Valor de atributo valDesc: " + valDesc);
		
		String valGrupArti = conectorParametro("valGrupArti").trim();
		traza("MMG:: Valor de atributo valGrupArti: " + valGrupArti);
		
		String maprOidMarcProd = conectorParametro("maprOidMarcProd").trim();
		traza("MMG:: Valor de atributo maprOidMarcProd: " + maprOidMarcProd);
		
		String negoOidNego = conectorParametro("negoOidNego").trim();
		traza("MMG:: Valor de atributo negoOidNego: " + negoOidNego);
		
		String prodOidProd = conectorParametro("prodOidProd").trim();
		traza("MMG:: Valor de atributo prodOidProd: " + prodOidProd);
		
		String cucoOidCuenCont = conectorParametro("cucoOidCuenCont").trim();
		traza("MMG:: Valor de atributo cucoOidCuenCont: " + cucoOidCuenCont);
		
		String valIndiDebeHabe = conectorParametro("valIndiDebeHabe").trim();
		traza("MMG:: Valor de atributo valIndiDebeHabe: " + valIndiDebeHabe);
		
		String imcfOidImpoContFact = conectorParametro("imcfOidImpoContFact").trim();
		traza("MMG:: Valor de atributo imcfOidImpoContFact: " + imcfOidImpoContFact);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		IntParamContaFactuData intParamContaFactu= new IntParamContaFactuData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			intParamContaFactu.setId(new Long(id));
		}
		intParamContaFactu = (IntParamContaFactuData)getSingleObject(BUSINESSID_QUERY, intParamContaFactu, 
			intParamContaFactu.clone(), "intParamContaFactu");
		
		if(intParamContaFactu == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		intParamContaFactu.setCodApun(
			(java.lang.String)FormatUtils.parseObject(codApun, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		intParamContaFactu.setValTipoAsie(
			(java.lang.String)FormatUtils.parseObject(valTipoAsie, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		intParamContaFactu.setValIdenCabeDeta(
			(java.lang.String)FormatUtils.parseObject(valIdenCabeDeta, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		intParamContaFactu.setValDesc(
			(java.lang.String)FormatUtils.parseObject(valDesc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		intParamContaFactu.setValGrupArti(
			(java.lang.String)FormatUtils.parseObject(valGrupArti, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.SegMarcaProduData maprOidMarcProdData = null;
		if(maprOidMarcProd != null && !maprOidMarcProd.trim().equals("")){
			maprOidMarcProdData = new es.indra.belcorp.mso.SegMarcaProduData();
			maprOidMarcProdData.setId(new Long(maprOidMarcProd));
		}
		intParamContaFactu.setMaprOidMarcProd(maprOidMarcProdData);
		es.indra.belcorp.mso.MaeNegocViewData negoOidNegoData = null;
		if(negoOidNego != null && !negoOidNego.trim().equals("")){
			negoOidNegoData = new es.indra.belcorp.mso.MaeNegocViewData();
			negoOidNegoData.setId(new Long(negoOidNego));
		}
		intParamContaFactu.setNegoOidNego(negoOidNegoData);
		intParamContaFactu.setProdOidProd(
			(java.lang.String)FormatUtils.parseObject(prodOidProd, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.CccCuentContaViewData cucoOidCuenContData = null;
		if(cucoOidCuenCont != null && !cucoOidCuenCont.trim().equals("")){
			cucoOidCuenContData = new es.indra.belcorp.mso.CccCuentContaViewData();
			cucoOidCuenContData.setId(new Long(cucoOidCuenCont));
		}
		intParamContaFactu.setCucoOidCuenCont(cucoOidCuenContData);
		intParamContaFactu.setValIndiDebeHabe(
			(java.lang.String)FormatUtils.parseObject(valIndiDebeHabe, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.IntImporContaFactuData imcfOidImpoContFactData = null;
		if(imcfOidImpoContFact != null && !imcfOidImpoContFact.trim().equals("")){
			imcfOidImpoContFactData = new es.indra.belcorp.mso.IntImporContaFactuData();
			imcfOidImpoContFactData.setId(new Long(imcfOidImpoContFact));
		}
		intParamContaFactu.setImcfOidImpoContFact(imcfOidImpoContFactData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//intParamContaFactu.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("intParamContaFactu", intParamContaFactu);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Ejecutamos la acción de preupdate
		cmdPreUpdate(intParamContaFactu);
		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad IntParamContaFactu");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad IntParamContaFactu");

		//Ejecutamos la acción de postupdate
		cmdPostUpdate(intParamContaFactu);
		
		
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
			IntParamContaFactuData intParamContaFactu = new IntParamContaFactuData();
			intParamContaFactu.setId(new Long(claves.nextToken()));
			//intParamContaFactu.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(intParamContaFactu);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad IntParamContaFactu");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad IntParamContaFactu");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("IntParamContaFactuLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_REMOVE);
		conectorActionParametro(VAR_PERFORM_REQUERY, "true");
	}
	
	protected Vector buildLocalizationValues() throws Exception{
		ArrayList languages = getIdiomas();
		Vector localizationLabels = new Vector();;
		
		
		return localizationLabels;
	}
	
	protected void cmdPreCreate(IntParamContaFactuData intParamContaFactu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData(); 
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				intParamContaFactu.setPaisOidPais(paisOculto); 
			
	}
	

	protected void cmdPreUpdate(IntParamContaFactuData intParamContaFactu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				intParamContaFactu.setPaisOidPais(paisOculto);
			
	}
	
	
	

	protected void cmdPostCreate(IntParamContaFactuData intParamContaFactu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				intParamContaFactu.setPaisOidPais(paisOculto);
			
	}
	

	protected void cmdPostUpdate(IntParamContaFactuData intParamContaFactu) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				intParamContaFactu.setPaisOidPais(paisOculto);
			
	}
	
	
	
	
}




