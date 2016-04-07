

/*
    INDRA/CAR/mmg
    $Id: ZonValorEstruGeopoLPExecution.java,v 1.1 2009/12/03 18:41:07 pecbazalar Exp $
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
import es.indra.belcorp.mso.*;

public class ZonValorEstruGeopoLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGZonValorEstruGeopoCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGZonValorEstruGeopoUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGZonValorEstruGeopoRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGZonValorEstruGeopoQueryFromToUserPage";	
	
	
	public static final String CONECTOR_CREATE = "ZonValorEstruGeopoConectorCreate";
	public static final String CONECTOR_UPDATE = "ZonValorEstruGeopoConectorUpdate";
	public static final String CONECTOR_REMOVE = "ZonValorEstruGeopoConectorRemove";

	public ZonValorEstruGeopoLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("ZonValorEstruGeopoPage");
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
  	correspondiente a la creación de un/a nuevo ZonValorEstruGeopo*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando ZonValorEstruGeopo");
		
		String codUnidGeog = conectorParametro("codUnidGeog").trim();
		traza("MMG:: Valor de atributo codUnidGeog: " + codUnidGeog);
		
		String desGeog = conectorParametro("desGeog").trim();
		traza("MMG:: Valor de atributo desGeog: " + desGeog);
		
		String codNse1 = conectorParametro("codNse1").trim();
		traza("MMG:: Valor de atributo codNse1: " + codNse1);
		
		String codNse2 = conectorParametro("codNse2").trim();
		traza("MMG:: Valor de atributo codNse2: " + codNse2);
		
		String codNse3 = conectorParametro("codNse3").trim();
		traza("MMG:: Valor de atributo codNse3: " + codNse3);
		
		String codPost = conectorParametro("codPost").trim();
		traza("MMG:: Valor de atributo codPost: " + codPost);
		
		String indActi = conectorParametro("indActi").trim();
		traza("MMG:: Valor de atributo indActi: " + indActi);
		
		String indAsig = conectorParametro("indAsig").trim();
		traza("MMG:: Valor de atributo indAsig: " + indAsig);
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		
		String orde1 = conectorParametro("orde1").trim();
		traza("MMG:: Valor de atributo orde1: " + orde1);
		
		String orde2 = conectorParametro("orde2").trim();
		traza("MMG:: Valor de atributo orde2: " + orde2);
		
		String orde3 = conectorParametro("orde3").trim();
		traza("MMG:: Valor de atributo orde3: " + orde3);
		
		String orde4 = conectorParametro("orde4").trim();
		traza("MMG:: Valor de atributo orde4: " + orde4);
		
		String orde5 = conectorParametro("orde5").trim();
		traza("MMG:: Valor de atributo orde5: " + orde5);
		
		String orde6 = conectorParametro("orde6").trim();
		traza("MMG:: Valor de atributo orde6: " + orde6);
		
		String orde7 = conectorParametro("orde7").trim();
		traza("MMG:: Valor de atributo orde7: " + orde7);
		
		String orde8 = conectorParametro("orde8").trim();
		traza("MMG:: Valor de atributo orde8: " + orde8);
		
		String orde9 = conectorParametro("orde9").trim();
		traza("MMG:: Valor de atributo orde9: " + orde9);
		
		String egeoOidEstrGeop = conectorParametro("egeoOidEstrGeop").trim();
		traza("MMG:: Valor de atributo egeoOidEstrGeop: " + egeoOidEstrGeop);
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String fecActu = conectorParametro("fecActu").trim();
		traza("MMG:: Valor de atributo fecActu: " + fecActu);
		
		String sgeoOidSubeGeop = conectorParametro("sgeoOidSubeGeop").trim();
		traza("MMG:: Valor de atributo sgeoOidSubeGeop: " + sgeoOidSubeGeop);
		
		
		//Construimos el mso y le vamos haciendo los sets de los atributo
		ZonValorEstruGeopoData zonValorEstruGeopo= new ZonValorEstruGeopoData();
		zonValorEstruGeopo.setCodUnidGeog(
			(java.lang.Integer)FormatUtils.parseObject(codUnidGeog, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setDesGeog(
			(java.lang.String)FormatUtils.parseObject(desGeog, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setCodNse1(
			(java.lang.String)FormatUtils.parseObject(codNse1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setCodNse2(
			(java.lang.String)FormatUtils.parseObject(codNse2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setCodNse3(
			(java.lang.String)FormatUtils.parseObject(codNse3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setCodPost(
			(java.lang.String)FormatUtils.parseObject(codPost, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setIndActi(
			(java.lang.Integer)FormatUtils.parseObject(indActi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setIndAsig(
			(java.lang.Integer)FormatUtils.parseObject(indAsig, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setIndBorr(
			(java.lang.Integer)FormatUtils.parseObject(indBorr, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde1(
			(java.lang.String)FormatUtils.parseObject(orde1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde2(
			(java.lang.String)FormatUtils.parseObject(orde2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde3(
			(java.lang.String)FormatUtils.parseObject(orde3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde4(
			(java.lang.String)FormatUtils.parseObject(orde4, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde5(
			(java.lang.String)FormatUtils.parseObject(orde5, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde6(
			(java.lang.String)FormatUtils.parseObject(orde6, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde7(
			(java.lang.String)FormatUtils.parseObject(orde7, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde8(
			(java.lang.String)FormatUtils.parseObject(orde8, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde9(
			(java.lang.String)FormatUtils.parseObject(orde9, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.ZonEstruGeopoData egeoOidEstrGeopData = null;
		if(egeoOidEstrGeop != null && !egeoOidEstrGeop.trim().equals("")){
			egeoOidEstrGeopData = new es.indra.belcorp.mso.ZonEstruGeopoData();
			egeoOidEstrGeopData.setId(new Integer(egeoOidEstrGeop));
		}
		zonValorEstruGeopo.setEgeoOidEstrGeop(egeoOidEstrGeopData);
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		zonValorEstruGeopo.setPaisOidPais(paisOidPaisData);
		zonValorEstruGeopo.setFecActu(
			(java.sql.Date)FormatUtils.parseObject(fecActu, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.ZonSubesGeopoData sgeoOidSubeGeopData = null;
		if(sgeoOidSubeGeop != null && !sgeoOidSubeGeop.trim().equals("")){
			sgeoOidSubeGeopData = new es.indra.belcorp.mso.ZonSubesGeopoData();
			sgeoOidSubeGeopData.setId(new Integer(sgeoOidSubeGeop));
		}
		zonValorEstruGeopo.setSgeoOidSubeGeop(sgeoOidSubeGeopData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonValorEstruGeopo", zonValorEstruGeopo);
		dto.addProperty("localizationLabels", localizationLabels);
		dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad ZonValorEstruGeopo");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad ZonValorEstruGeopo");
		
		
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("ZonValorEstruGeopoLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando ZonValorEstruGeopo");
		
		String codUnidGeog = conectorParametro("codUnidGeog").trim();
		traza("MMG:: Valor de atributo codUnidGeog: " + codUnidGeog);
		
		String desGeog = conectorParametro("desGeog").trim();
		traza("MMG:: Valor de atributo desGeog: " + desGeog);
		
		String codNse1 = conectorParametro("codNse1").trim();
		traza("MMG:: Valor de atributo codNse1: " + codNse1);
		
		String codNse2 = conectorParametro("codNse2").trim();
		traza("MMG:: Valor de atributo codNse2: " + codNse2);
		
		String codNse3 = conectorParametro("codNse3").trim();
		traza("MMG:: Valor de atributo codNse3: " + codNse3);
		
		String codPost = conectorParametro("codPost").trim();
		traza("MMG:: Valor de atributo codPost: " + codPost);
		
		String indActi = conectorParametro("indActi").trim();
		traza("MMG:: Valor de atributo indActi: " + indActi);
		
		String indAsig = conectorParametro("indAsig").trim();
		traza("MMG:: Valor de atributo indAsig: " + indAsig);
		
		String indBorr = conectorParametro("indBorr").trim();
		traza("MMG:: Valor de atributo indBorr: " + indBorr);
		
		String orde1 = conectorParametro("orde1").trim();
		traza("MMG:: Valor de atributo orde1: " + orde1);
		
		String orde2 = conectorParametro("orde2").trim();
		traza("MMG:: Valor de atributo orde2: " + orde2);
		
		String orde3 = conectorParametro("orde3").trim();
		traza("MMG:: Valor de atributo orde3: " + orde3);
		
		String orde4 = conectorParametro("orde4").trim();
		traza("MMG:: Valor de atributo orde4: " + orde4);
		
		String orde5 = conectorParametro("orde5").trim();
		traza("MMG:: Valor de atributo orde5: " + orde5);
		
		String orde6 = conectorParametro("orde6").trim();
		traza("MMG:: Valor de atributo orde6: " + orde6);
		
		String orde7 = conectorParametro("orde7").trim();
		traza("MMG:: Valor de atributo orde7: " + orde7);
		
		String orde8 = conectorParametro("orde8").trim();
		traza("MMG:: Valor de atributo orde8: " + orde8);
		
		String orde9 = conectorParametro("orde9").trim();
		traza("MMG:: Valor de atributo orde9: " + orde9);
		
		String egeoOidEstrGeop = conectorParametro("egeoOidEstrGeop").trim();
		traza("MMG:: Valor de atributo egeoOidEstrGeop: " + egeoOidEstrGeop);
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String fecActu = conectorParametro("fecActu").trim();
		traza("MMG:: Valor de atributo fecActu: " + fecActu);
		
		String sgeoOidSubeGeop = conectorParametro("sgeoOidSubeGeop").trim();
		traza("MMG:: Valor de atributo sgeoOidSubeGeop: " + sgeoOidSubeGeop);
		
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		ZonValorEstruGeopoData zonValorEstruGeopo= new ZonValorEstruGeopoData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			zonValorEstruGeopo.setId(new Integer(id));
		}
		zonValorEstruGeopo = (ZonValorEstruGeopoData)getSingleObject(BUSINESSID_QUERY, zonValorEstruGeopo, 
			zonValorEstruGeopo.clone(), "zonValorEstruGeopo");
		
		if(zonValorEstruGeopo == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		zonValorEstruGeopo.setCodUnidGeog(
			(java.lang.Integer)FormatUtils.parseObject(codUnidGeog, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setDesGeog(
			(java.lang.String)FormatUtils.parseObject(desGeog, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setCodNse1(
			(java.lang.String)FormatUtils.parseObject(codNse1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setCodNse2(
			(java.lang.String)FormatUtils.parseObject(codNse2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setCodNse3(
			(java.lang.String)FormatUtils.parseObject(codNse3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setCodPost(
			(java.lang.String)FormatUtils.parseObject(codPost, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setIndActi(
			(java.lang.Integer)FormatUtils.parseObject(indActi, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setIndAsig(
			(java.lang.Integer)FormatUtils.parseObject(indAsig, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setIndBorr(
			(java.lang.Integer)FormatUtils.parseObject(indBorr, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde1(
			(java.lang.String)FormatUtils.parseObject(orde1, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde2(
			(java.lang.String)FormatUtils.parseObject(orde2, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde3(
			(java.lang.String)FormatUtils.parseObject(orde3, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde4(
			(java.lang.String)FormatUtils.parseObject(orde4, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde5(
			(java.lang.String)FormatUtils.parseObject(orde5, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde6(
			(java.lang.String)FormatUtils.parseObject(orde6, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde7(
			(java.lang.String)FormatUtils.parseObject(orde7, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde8(
			(java.lang.String)FormatUtils.parseObject(orde8, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		zonValorEstruGeopo.setOrde9(
			(java.lang.String)FormatUtils.parseObject(orde9, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.ZonEstruGeopoData egeoOidEstrGeopData = null;
		if(egeoOidEstrGeop != null && !egeoOidEstrGeop.trim().equals("")){
			egeoOidEstrGeopData = new es.indra.belcorp.mso.ZonEstruGeopoData();
			egeoOidEstrGeopData.setId(new Integer(egeoOidEstrGeop));
		}
		zonValorEstruGeopo.setEgeoOidEstrGeop(egeoOidEstrGeopData);
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		zonValorEstruGeopo.setPaisOidPais(paisOidPaisData);
		zonValorEstruGeopo.setFecActu(
			(java.sql.Date)FormatUtils.parseObject(fecActu, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.ZonSubesGeopoData sgeoOidSubeGeopData = null;
		if(sgeoOidSubeGeop != null && !sgeoOidSubeGeop.trim().equals("")){
			sgeoOidSubeGeopData = new es.indra.belcorp.mso.ZonSubesGeopoData();
			sgeoOidSubeGeopData.setId(new Integer(sgeoOidSubeGeop));
		}
		zonValorEstruGeopo.setSgeoOidSubeGeop(sgeoOidSubeGeopData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en sicc no hay bloqueos.....
		//zonValorEstruGeopo.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("zonValorEstruGeopo", zonValorEstruGeopo);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad ZonValorEstruGeopo");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad ZonValorEstruGeopo");

		
		
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
			ZonValorEstruGeopoData zonValorEstruGeopo = new ZonValorEstruGeopoData();
			zonValorEstruGeopo.setId(new Integer(claves.nextToken()));
			//zonValorEstruGeopo.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(zonValorEstruGeopo);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad ZonValorEstruGeopo");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad ZonValorEstruGeopo");
		
		

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("ZonValorEstruGeopoLPStartUp");
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




