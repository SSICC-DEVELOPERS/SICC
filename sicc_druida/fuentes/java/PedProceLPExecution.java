

/*
    INDRA/CAR/mmg
    $Id: PedProceLPExecution.java,v 1.1 2009/12/03 18:32:30 pecbazalar Exp $
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

public class PedProceLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGPedProceCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGPedProceUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGPedProceRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGPedProceQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "PedProceConectorCreate";
	public static final String CONECTOR_UPDATE = "PedProceConectorUpdate";
	public static final String CONECTOR_REMOVE = "PedProceConectorRemove";

	public PedProceLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("PedProcePage");
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
  	correspondiente a la creación de un/a nuevo PedProce*/  
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
		
		traza("MMG::Creando PedProce");
		
		String codProc = conectorParametro("codProc").trim();
		traza("MMG:: Valor de atributo codProc: " + codProc);
		if(codProc != null && !codProc.trim().equals("")) codProc = codProc.toUpperCase();
		
		String grprOidGrupProc = conectorParametro("grprOidGrupProc").trim();
		traza("MMG:: Valor de atributo grprOidGrupProc: " + grprOidGrupProc);
		
		String progOidProg = conectorParametro("progOidProg").trim();
		traza("MMG:: Valor de atributo progOidProg: " + progOidProg);
		
		String procOidProc = conectorParametro("procOidProc").trim();
		traza("MMG:: Valor de atributo procOidProc: " + procOidProc);
		
		String tposOidTipoPosi = conectorParametro("tposOidTipoPosi").trim();
		traza("MMG:: Valor de atributo tposOidTipoPosi: " + tposOidTipoPosi);
		
		String stpoOidSubtPosi = conectorParametro("stpoOidSubtPosi").trim();
		traza("MMG:: Valor de atributo stpoOidSubtPosi: " + stpoOidSubtPosi);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		PedProceData pedProce= new PedProceData();
		pedProce.setCodProc(
			(java.lang.String)FormatUtils.parseObject(codProc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.PedGrupoProceData grprOidGrupProcData = null;
		if(grprOidGrupProc != null && !grprOidGrupProc.trim().equals("")){
			grprOidGrupProcData = new es.indra.belcorp.mso.PedGrupoProceData();
			grprOidGrupProcData.setId(new Long(grprOidGrupProc));
		}
		pedProce.setGrprOidGrupProc(grprOidGrupProcData);
		es.indra.belcorp.mso.PedProgrData progOidProgData = null;
		if(progOidProg != null && !progOidProg.trim().equals("")){
			progOidProgData = new es.indra.belcorp.mso.PedProgrData();
			progOidProgData.setId(new Long(progOidProg));
		}
		pedProce.setProgOidProg(progOidProgData);
		es.indra.belcorp.mso.PedProceViewData procOidProcData = null;
		if(procOidProc != null && !procOidProc.trim().equals("")){
			procOidProcData = new es.indra.belcorp.mso.PedProceViewData();
			procOidProcData.setId(new Long(procOidProc));
		}
		pedProce.setProcOidProc(procOidProcData);
		es.indra.belcorp.mso.PedTipoPosicData tposOidTipoPosiData = null;
		if(tposOidTipoPosi != null && !tposOidTipoPosi.trim().equals("")){
			tposOidTipoPosiData = new es.indra.belcorp.mso.PedTipoPosicData();
			tposOidTipoPosiData.setId(new Long(tposOidTipoPosi));
		}
		pedProce.setTposOidTipoPosi(tposOidTipoPosiData);
		es.indra.belcorp.mso.PedSubtiPosicViewData stpoOidSubtPosiData = null;
		if(stpoOidSubtPosi != null && !stpoOidSubtPosi.trim().equals("")){
			stpoOidSubtPosiData = new es.indra.belcorp.mso.PedSubtiPosicViewData();
			stpoOidSubtPosiData.setId(new Long(stpoOidSubtPosi));
		}
		pedProce.setStpoOidSubtPosi(stpoOidSubtPosiData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("pedProce", pedProce);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", userProperties);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad PedProce");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad PedProce");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("PedProceLPStartUp");
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
		traza("MMG::Creando PedProce");
		
		String codProc = conectorParametro("codProc").trim();
		traza("MMG:: Valor de atributo codProc: " + codProc);
		if(codProc != null && !codProc.trim().equals("")) codProc = codProc.toUpperCase();
		
		String grprOidGrupProc = conectorParametro("grprOidGrupProc").trim();
		traza("MMG:: Valor de atributo grprOidGrupProc: " + grprOidGrupProc);
		
		String progOidProg = conectorParametro("progOidProg").trim();
		traza("MMG:: Valor de atributo progOidProg: " + progOidProg);
		
		String procOidProc = conectorParametro("procOidProc").trim();
		traza("MMG:: Valor de atributo procOidProc: " + procOidProc);
		
		String tposOidTipoPosi = conectorParametro("tposOidTipoPosi").trim();
		traza("MMG:: Valor de atributo tposOidTipoPosi: " + tposOidTipoPosi);
		
		String stpoOidSubtPosi = conectorParametro("stpoOidSubtPosi").trim();
		traza("MMG:: Valor de atributo stpoOidSubtPosi: " + stpoOidSubtPosi);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		PedProceData pedProce= new PedProceData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			pedProce.setId(new Long(id));
		}
		pedProce = (PedProceData)getSingleObject(BUSINESSID_QUERY, pedProce, 
			pedProce.clone(), "pedProce");
		
		if(pedProce == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		pedProce.setCodProc(
			(java.lang.String)FormatUtils.parseObject(codProc, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), symbols));
		es.indra.belcorp.mso.PedGrupoProceData grprOidGrupProcData = null;
		if(grprOidGrupProc != null && !grprOidGrupProc.trim().equals("")){
			grprOidGrupProcData = new es.indra.belcorp.mso.PedGrupoProceData();
			grprOidGrupProcData.setId(new Long(grprOidGrupProc));
		}
		pedProce.setGrprOidGrupProc(grprOidGrupProcData);
		es.indra.belcorp.mso.PedProgrData progOidProgData = null;
		if(progOidProg != null && !progOidProg.trim().equals("")){
			progOidProgData = new es.indra.belcorp.mso.PedProgrData();
			progOidProgData.setId(new Long(progOidProg));
		}
		pedProce.setProgOidProg(progOidProgData);
		es.indra.belcorp.mso.PedProceViewData procOidProcData = null;
		if(procOidProc != null && !procOidProc.trim().equals("")){
			procOidProcData = new es.indra.belcorp.mso.PedProceViewData();
			procOidProcData.setId(new Long(procOidProc));
		}
		pedProce.setProcOidProc(procOidProcData);
		es.indra.belcorp.mso.PedTipoPosicData tposOidTipoPosiData = null;
		if(tposOidTipoPosi != null && !tposOidTipoPosi.trim().equals("")){
			tposOidTipoPosiData = new es.indra.belcorp.mso.PedTipoPosicData();
			tposOidTipoPosiData.setId(new Long(tposOidTipoPosi));
		}
		pedProce.setTposOidTipoPosi(tposOidTipoPosiData);
		es.indra.belcorp.mso.PedSubtiPosicViewData stpoOidSubtPosiData = null;
		if(stpoOidSubtPosi != null && !stpoOidSubtPosi.trim().equals("")){
			stpoOidSubtPosiData = new es.indra.belcorp.mso.PedSubtiPosicViewData();
			stpoOidSubtPosiData.setId(new Long(stpoOidSubtPosi));
		}
		pedProce.setStpoOidSubtPosi(stpoOidSubtPosiData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//pedProce.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("pedProce", pedProce);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad PedProce");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad PedProce");

		
		
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
			PedProceData pedProce = new PedProceData();
			pedProce.setId(new Long(claves.nextToken()));
			//pedProce.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(pedProce);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad PedProce");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad PedProce");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("PedProceLPStartUp");
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
			label.setEnti("PED_PROCE");
			label.setDeta(value != null? value: "");
			localizationLabels.add(label);
		}
		
		
		return localizationLabels;
	}
	
	

	
	
	

	

	
	
	
	
}




