

/*
    INDRA/CAR/mmg
    $Id: CarSoliEntrBloqLPExecution.java,v 1.1 2009/12/03 18:35:55 pecbazalar Exp $
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

public class CarSoliEntrBloqLPExecution extends MMGDruidaBase{
	//Constantes de lçogica de negocio
	public static final String BUSINESSID_CREATE= "MMGCarSoliEntrBloqCreateI18N";
	public static final String BUSINESSID_UPDATE = "MMGCarSoliEntrBloqUpdateI18N";
	public static final String BUSINESSID_REMOVE = "MMGCarSoliEntrBloqRemoveSeveral";
	public static final String BUSINESSID_QUERY = "MMGCarSoliEntrBloqQueryFromToUserPage";	
	public static final String CONECTOR_CREATE = "CarSoliEntrBloqConectorCreate";
	public static final String CONECTOR_UPDATE = "CarSoliEntrBloqConectorUpdate";
	public static final String CONECTOR_REMOVE = "CarSoliEntrBloqConectorRemove";

	public CarSoliEntrBloqLPExecution(){
		super();
	}

	public void inicio() throws Exception {
	    pagina("CarSoliEntrBloqPage");
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
  	correspondiente a la creación de un/a nuevo CarSoliEntrBloq*/  
	protected void cmdCreate() throws Exception{
		traza("MMG::Creando CarSoliEntrBloq");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String sbacOidSbac = conectorParametro("sbacOidSbac").trim();
		traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
		
		String tsolOidTipoSoli = conectorParametro("tsolOidTipoSoli").trim();
		traza("MMG:: Valor de atributo tsolOidTipoSoli: " + tsolOidTipoSoli);
		
		String socaOidSoliCabe = conectorParametro("socaOidSoliCabe").trim();
		traza("MMG:: Valor de atributo socaOidSoliCabe: " + socaOidSoliCabe);
		
		String fecDocu = conectorParametro("fecDocu").trim();
		traza("MMG:: Valor de atributo fecDocu: " + fecDocu);
		
		String indNoti = conectorParametro("indNoti").trim();
		traza("MMG:: Valor de atributo indNoti: " + indNoti);
		
		String valMontOrde = conectorParametro("valMontOrde").trim();
		traza("MMG:: Valor de atributo valMontOrde: " + valMontOrde);
		
		String valMontDeudVenc = conectorParametro("valMontDeudVenc").trim();
		traza("MMG:: Valor de atributo valMontDeudVenc: " + valMontDeudVenc);
		
		String indVali1 = conectorParametro("indVali1").trim();
		traza("MMG:: Valor de atributo indVali1: " + indVali1);
		
		String indVali2 = conectorParametro("indVali2").trim();
		traza("MMG:: Valor de atributo indVali2: " + indVali2);
		
		String indVali3 = conectorParametro("indVali3").trim();
		traza("MMG:: Valor de atributo indVali3: " + indVali3);
		
		String indVali4 = conectorParametro("indVali4").trim();
		traza("MMG:: Valor de atributo indVali4: " + indVali4);
		
		String fecHoraLibe = conectorParametro("fecHoraLibe").trim();
		traza("MMG:: Valor de atributo fecHoraLibe: " + fecHoraLibe);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		String jeraOidJera = conectorParametro("jeraOidJera").trim();
		traza("MMG:: Valor de atributo jeraOidJera: " + jeraOidJera);
		
		String espeOidEstaPedi = conectorParametro("espeOidEstaPedi").trim();
		traza("MMG:: Valor de atributo espeOidEstaPedi: " + espeOidEstaPedi);
		
		String perdOidPeri = conectorParametro("perdOidPeri").trim();
		traza("MMG:: Valor de atributo perdOidPeri: " + perdOidPeri);
		
		String clieOidClie = conectorParametro("clieOidClie").trim();
		traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
		
		String clieOidGereZona = conectorParametro("clieOidGereZona").trim();
		traza("MMG:: Valor de atributo clieOidGereZona: " + clieOidGereZona);
		
		String cuadOidClieUnidAdmi = conectorParametro("cuadOidClieUnidAdmi").trim();
		traza("MMG:: Valor de atributo cuadOidClieUnidAdmi: " + cuadOidClieUnidAdmi);
		
		String coapOidCodiApro = conectorParametro("coapOidCodiApro").trim();
		traza("MMG:: Valor de atributo coapOidCodiApro: " + coapOidCodiApro);
		
		String ejcuOidEjecCuen = conectorParametro("ejcuOidEjecCuen").trim();
		traza("MMG:: Valor de atributo ejcuOidEjecCuen: " + ejcuOidEjecCuen);
		
		String ejcuOidUsuaLibe = conectorParametro("ejcuOidUsuaLibe").trim();
		traza("MMG:: Valor de atributo ejcuOidUsuaLibe: " + ejcuOidUsuaLibe);
		
		String niriOidNiveRies = conectorParametro("niriOidNiveRies").trim();
		traza("MMG:: Valor de atributo niriOidNiveRies: " + niriOidNiveRies);
		
		String grsoOidGrupSoli = conectorParametro("grsoOidGrupSoli").trim();
		traza("MMG:: Valor de atributo grsoOidGrupSoli: " + grsoOidGrupSoli);
		
	
		//Construimos el mso con los elementos de la búsqueda
		CarSoliEntrBloqData carSoliEntrBloq= new CarSoliEntrBloqData();
		
		
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		carSoliEntrBloq.setPaisOidPais(paisOidPaisData);
		
		es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
		if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
			sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
			sbacOidSbacData.setId(new Integer(sbacOidSbac));
		}
		carSoliEntrBloq.setSbacOidSbac(sbacOidSbacData);
		
		es.indra.belcorp.mso.PedTipoSolicData tsolOidTipoSoliData = null;
		if(tsolOidTipoSoli != null && !tsolOidTipoSoli.trim().equals("")){
			tsolOidTipoSoliData = new es.indra.belcorp.mso.PedTipoSolicData();
			tsolOidTipoSoliData.setId(new Integer(tsolOidTipoSoli));
		}
		carSoliEntrBloq.setTsolOidTipoSoli(tsolOidTipoSoliData);
		
		es.indra.belcorp.mso.PedSolicCabecData socaOidSoliCabeData = null;
		if(socaOidSoliCabe != null && !socaOidSoliCabe.trim().equals("")){
			socaOidSoliCabeData = new es.indra.belcorp.mso.PedSolicCabecData();
			socaOidSoliCabeData.setId(new Integer(socaOidSoliCabe));
		}
		carSoliEntrBloq.setSocaOidSoliCabe(socaOidSoliCabeData);
		carSoliEntrBloq.setFecDocu(
			(java.sql.Date)FormatUtils.parseObject(fecDocu, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setIndNoti(
			(java.lang.Integer)FormatUtils.parseObject(indNoti, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setValMontOrde(
			(java.lang.Double)FormatUtils.parseObject(valMontOrde, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setValMontDeudVenc(
			(java.lang.Double)FormatUtils.parseObject(valMontDeudVenc, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setIndVali1(
			(java.lang.Integer)FormatUtils.parseObject(indVali1, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setIndVali2(
			(java.lang.Integer)FormatUtils.parseObject(indVali2, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setIndVali3(
			(java.lang.Integer)FormatUtils.parseObject(indVali3, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setIndVali4(
			(java.lang.Integer)FormatUtils.parseObject(indVali4, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setFecHoraLibe(
			(java.sql.Date)FormatUtils.parseObject(fecHoraLibe, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		
		es.indra.belcorp.mso.CarJerarData jeraOidJeraData = null;
		if(jeraOidJera != null && !jeraOidJera.trim().equals("")){
			jeraOidJeraData = new es.indra.belcorp.mso.CarJerarData();
			jeraOidJeraData.setId(new Integer(jeraOidJera));
		}
		carSoliEntrBloq.setJeraOidJera(jeraOidJeraData);
		
		es.indra.belcorp.mso.CarEstatPedidData espeOidEstaPediData = null;
		if(espeOidEstaPedi != null && !espeOidEstaPedi.trim().equals("")){
			espeOidEstaPediData = new es.indra.belcorp.mso.CarEstatPedidData();
			espeOidEstaPediData.setId(new Integer(espeOidEstaPedi));
		}
		carSoliEntrBloq.setEspeOidEstaPedi(espeOidEstaPediData);
		
		es.indra.belcorp.mso.CraPerioData perdOidPeriData = null;
		if(perdOidPeri != null && !perdOidPeri.trim().equals("")){
			perdOidPeriData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriData.setId(new Integer(perdOidPeri));
		}
		carSoliEntrBloq.setPerdOidPeri(perdOidPeriData);
		
		es.indra.belcorp.mso.MaeClienData clieOidClieData = null;
		if(clieOidClie != null && !clieOidClie.trim().equals("")){
			clieOidClieData = new es.indra.belcorp.mso.MaeClienData();
			clieOidClieData.setId(new Integer(clieOidClie));
		}
		carSoliEntrBloq.setClieOidClie(clieOidClieData);
		
		es.indra.belcorp.mso.MaeClienData clieOidGereZonaData = null;
		if(clieOidGereZona != null && !clieOidGereZona.trim().equals("")){
			clieOidGereZonaData = new es.indra.belcorp.mso.MaeClienData();
			clieOidGereZonaData.setId(new Integer(clieOidGereZona));
		}
		carSoliEntrBloq.setClieOidGereZona(clieOidGereZonaData);
		
		es.indra.belcorp.mso.MaeClienUnidaAdminData cuadOidClieUnidAdmiData = null;
		if(cuadOidClieUnidAdmi != null && !cuadOidClieUnidAdmi.trim().equals("")){
			cuadOidClieUnidAdmiData = new es.indra.belcorp.mso.MaeClienUnidaAdminData();
			cuadOidClieUnidAdmiData.setId(new Integer(cuadOidClieUnidAdmi));
		}
		carSoliEntrBloq.setCuadOidClieUnidAdmi(cuadOidClieUnidAdmiData);
		
		es.indra.belcorp.mso.CarCodigAprobData coapOidCodiAproData = null;
		if(coapOidCodiApro != null && !coapOidCodiApro.trim().equals("")){
			coapOidCodiAproData = new es.indra.belcorp.mso.CarCodigAprobData();
			coapOidCodiAproData.setId(new Integer(coapOidCodiApro));
		}
		carSoliEntrBloq.setCoapOidCodiApro(coapOidCodiAproData);
		
		es.indra.belcorp.mso.CarEjecuCuentData ejcuOidEjecCuenData = null;
		if(ejcuOidEjecCuen != null && !ejcuOidEjecCuen.trim().equals("")){
			ejcuOidEjecCuenData = new es.indra.belcorp.mso.CarEjecuCuentData();
			ejcuOidEjecCuenData.setId(new Integer(ejcuOidEjecCuen));
		}
		carSoliEntrBloq.setEjcuOidEjecCuen(ejcuOidEjecCuenData);
		
		es.indra.belcorp.mso.CarEjecuCuentData ejcuOidUsuaLibeData = null;
		if(ejcuOidUsuaLibe != null && !ejcuOidUsuaLibe.trim().equals("")){
			ejcuOidUsuaLibeData = new es.indra.belcorp.mso.CarEjecuCuentData();
			ejcuOidUsuaLibeData.setId(new Integer(ejcuOidUsuaLibe));
		}
		carSoliEntrBloq.setEjcuOidUsuaLibe(ejcuOidUsuaLibeData);
		
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesData = null;
		if(niriOidNiveRies != null && !niriOidNiveRies.trim().equals("")){
			niriOidNiveRiesData = new es.indra.belcorp.mso.CarNivelRiesgData();
			niriOidNiveRiesData.setId(new Integer(niriOidNiveRies));
		}
		carSoliEntrBloq.setNiriOidNiveRies(niriOidNiveRiesData);
		
		es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoliData = null;
		if(grsoOidGrupSoli != null && !grsoOidGrupSoli.trim().equals("")){
			grsoOidGrupSoliData = new es.indra.belcorp.mso.CarGrupoSolicData();
			grsoOidGrupSoliData.setId(new Integer(grsoOidGrupSoli));
		}
		carSoliEntrBloq.setGrsoOidGrupSoli(grsoOidGrupSoliData);
		
		
		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Creamos el dto y el bussines id correspondientes a la acción de create
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("carSoliEntrBloq", carSoliEntrBloq);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_CREATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Create de entidad CarSoliEntrBloq");
		DruidaConector conectorCreate =  conectar(CONECTOR_CREATE, datos);
		traza("MMG:: Finalizada ejecución Create de entidad CarSoliEntrBloq");
		
		//Redirigimos a la LP de StartUp con la acción de StartUp
		conectorAction("CarSoliEntrBloqLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, ACCION_CREATE);
	}
	
	
  /**Invoca la operación de modificación sobre el elemento seleccionado*/  
	protected void cmdUpdate() throws Exception{
		traza("MMG::Creando CarSoliEntrBloq");
		
		String paisOidPais = conectorParametro("paisOidPais").trim();
		traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
		
		String sbacOidSbac = conectorParametro("sbacOidSbac").trim();
		traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
		
		String tsolOidTipoSoli = conectorParametro("tsolOidTipoSoli").trim();
		traza("MMG:: Valor de atributo tsolOidTipoSoli: " + tsolOidTipoSoli);
		
		String socaOidSoliCabe = conectorParametro("socaOidSoliCabe").trim();
		traza("MMG:: Valor de atributo socaOidSoliCabe: " + socaOidSoliCabe);
		
		String fecDocu = conectorParametro("fecDocu").trim();
		traza("MMG:: Valor de atributo fecDocu: " + fecDocu);
		
		String indNoti = conectorParametro("indNoti").trim();
		traza("MMG:: Valor de atributo indNoti: " + indNoti);
		
		String valMontOrde = conectorParametro("valMontOrde").trim();
		traza("MMG:: Valor de atributo valMontOrde: " + valMontOrde);
		
		String valMontDeudVenc = conectorParametro("valMontDeudVenc").trim();
		traza("MMG:: Valor de atributo valMontDeudVenc: " + valMontDeudVenc);
		
		String indVali1 = conectorParametro("indVali1").trim();
		traza("MMG:: Valor de atributo indVali1: " + indVali1);
		
		String indVali2 = conectorParametro("indVali2").trim();
		traza("MMG:: Valor de atributo indVali2: " + indVali2);
		
		String indVali3 = conectorParametro("indVali3").trim();
		traza("MMG:: Valor de atributo indVali3: " + indVali3);
		
		String indVali4 = conectorParametro("indVali4").trim();
		traza("MMG:: Valor de atributo indVali4: " + indVali4);
		
		String fecHoraLibe = conectorParametro("fecHoraLibe").trim();
		traza("MMG:: Valor de atributo fecHoraLibe: " + fecHoraLibe);
		
		String valObse = conectorParametro("valObse").trim();
		traza("MMG:: Valor de atributo valObse: " + valObse);
		
		String jeraOidJera = conectorParametro("jeraOidJera").trim();
		traza("MMG:: Valor de atributo jeraOidJera: " + jeraOidJera);
		
		String espeOidEstaPedi = conectorParametro("espeOidEstaPedi").trim();
		traza("MMG:: Valor de atributo espeOidEstaPedi: " + espeOidEstaPedi);
		
		String perdOidPeri = conectorParametro("perdOidPeri").trim();
		traza("MMG:: Valor de atributo perdOidPeri: " + perdOidPeri);
		
		String clieOidClie = conectorParametro("clieOidClie").trim();
		traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
		
		String clieOidGereZona = conectorParametro("clieOidGereZona").trim();
		traza("MMG:: Valor de atributo clieOidGereZona: " + clieOidGereZona);
		
		String cuadOidClieUnidAdmi = conectorParametro("cuadOidClieUnidAdmi").trim();
		traza("MMG:: Valor de atributo cuadOidClieUnidAdmi: " + cuadOidClieUnidAdmi);
		
		String coapOidCodiApro = conectorParametro("coapOidCodiApro").trim();
		traza("MMG:: Valor de atributo coapOidCodiApro: " + coapOidCodiApro);
		
		String ejcuOidEjecCuen = conectorParametro("ejcuOidEjecCuen").trim();
		traza("MMG:: Valor de atributo ejcuOidEjecCuen: " + ejcuOidEjecCuen);
		
		String ejcuOidUsuaLibe = conectorParametro("ejcuOidUsuaLibe").trim();
		traza("MMG:: Valor de atributo ejcuOidUsuaLibe: " + ejcuOidUsuaLibe);
		
		String niriOidNiveRies = conectorParametro("niriOidNiveRies").trim();
		traza("MMG:: Valor de atributo niriOidNiveRies: " + niriOidNiveRies);
		
		String grsoOidGrupSoli = conectorParametro("grsoOidGrupSoli").trim();
		traza("MMG:: Valor de atributo grsoOidGrupSoli: " + grsoOidGrupSoli);
		
		
		//Sacamos de la base de datos el elemento a modificar. SI ya no existe lanzamos excepcion
		CarSoliEntrBloqData carSoliEntrBloq= new CarSoliEntrBloqData();
		String id = conectorParametro("idSelection");
		if(id != null && !id.trim().equals("")){
			carSoliEntrBloq.setId(new Integer(id));
		}
		carSoliEntrBloq = (CarSoliEntrBloqData)getSingleObject(BUSINESSID_QUERY, carSoliEntrBloq, 
			carSoliEntrBloq.clone(), "carSoliEntrBloq");
		if(carSoliEntrBloq == null) throw new MMGException(ERRORCODE_ELEMENTO_INEXISTENTE);
		
		//Vamos actualizando los valores
		es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
		if(paisOidPais != null && !paisOidPais.trim().equals("")){
			paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
			paisOidPaisData.setId(new Integer(paisOidPais));
		}
		carSoliEntrBloq.setPaisOidPais(paisOidPaisData);
		es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
		if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
			sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
			sbacOidSbacData.setId(new Integer(sbacOidSbac));
		}
		carSoliEntrBloq.setSbacOidSbac(sbacOidSbacData);
		es.indra.belcorp.mso.PedTipoSolicData tsolOidTipoSoliData = null;
		if(tsolOidTipoSoli != null && !tsolOidTipoSoli.trim().equals("")){
			tsolOidTipoSoliData = new es.indra.belcorp.mso.PedTipoSolicData();
			tsolOidTipoSoliData.setId(new Integer(tsolOidTipoSoli));
		}
		carSoliEntrBloq.setTsolOidTipoSoli(tsolOidTipoSoliData);
		es.indra.belcorp.mso.PedSolicCabecData socaOidSoliCabeData = null;
		if(socaOidSoliCabe != null && !socaOidSoliCabe.trim().equals("")){
			socaOidSoliCabeData = new es.indra.belcorp.mso.PedSolicCabecData();
			socaOidSoliCabeData.setId(new Integer(socaOidSoliCabe));
		}
		carSoliEntrBloq.setSocaOidSoliCabe(socaOidSoliCabeData);
		carSoliEntrBloq.setFecDocu(
			(java.sql.Date)FormatUtils.parseObject(fecDocu, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setIndNoti(
			(java.lang.Integer)FormatUtils.parseObject(indNoti, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setValMontOrde(
			(java.lang.Double)FormatUtils.parseObject(valMontOrde, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setValMontDeudVenc(
			(java.lang.Double)FormatUtils.parseObject(valMontDeudVenc, "java.lang.Double", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setIndVali1(
			(java.lang.Integer)FormatUtils.parseObject(indVali1, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setIndVali2(
			(java.lang.Integer)FormatUtils.parseObject(indVali2, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setIndVali3(
			(java.lang.Integer)FormatUtils.parseObject(indVali3, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setIndVali4(
			(java.lang.Integer)FormatUtils.parseObject(indVali4, "java.lang.Integer", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setFecHoraLibe(
			(java.sql.Date)FormatUtils.parseObject(fecHoraLibe, "java.sql.Date", 
			 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		carSoliEntrBloq.setValObse(
			(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
			 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
		es.indra.belcorp.mso.CarJerarData jeraOidJeraData = null;
		if(jeraOidJera != null && !jeraOidJera.trim().equals("")){
			jeraOidJeraData = new es.indra.belcorp.mso.CarJerarData();
			jeraOidJeraData.setId(new Integer(jeraOidJera));
		}
		carSoliEntrBloq.setJeraOidJera(jeraOidJeraData);
		es.indra.belcorp.mso.CarEstatPedidData espeOidEstaPediData = null;
		if(espeOidEstaPedi != null && !espeOidEstaPedi.trim().equals("")){
			espeOidEstaPediData = new es.indra.belcorp.mso.CarEstatPedidData();
			espeOidEstaPediData.setId(new Integer(espeOidEstaPedi));
		}
		carSoliEntrBloq.setEspeOidEstaPedi(espeOidEstaPediData);
		es.indra.belcorp.mso.CraPerioData perdOidPeriData = null;
		if(perdOidPeri != null && !perdOidPeri.trim().equals("")){
			perdOidPeriData = new es.indra.belcorp.mso.CraPerioData();
			perdOidPeriData.setId(new Integer(perdOidPeri));
		}
		carSoliEntrBloq.setPerdOidPeri(perdOidPeriData);
		es.indra.belcorp.mso.MaeClienData clieOidClieData = null;
		if(clieOidClie != null && !clieOidClie.trim().equals("")){
			clieOidClieData = new es.indra.belcorp.mso.MaeClienData();
			clieOidClieData.setId(new Integer(clieOidClie));
		}
		carSoliEntrBloq.setClieOidClie(clieOidClieData);
		es.indra.belcorp.mso.MaeClienData clieOidGereZonaData = null;
		if(clieOidGereZona != null && !clieOidGereZona.trim().equals("")){
			clieOidGereZonaData = new es.indra.belcorp.mso.MaeClienData();
			clieOidGereZonaData.setId(new Integer(clieOidGereZona));
		}
		carSoliEntrBloq.setClieOidGereZona(clieOidGereZonaData);
		es.indra.belcorp.mso.MaeClienUnidaAdminData cuadOidClieUnidAdmiData = null;
		if(cuadOidClieUnidAdmi != null && !cuadOidClieUnidAdmi.trim().equals("")){
			cuadOidClieUnidAdmiData = new es.indra.belcorp.mso.MaeClienUnidaAdminData();
			cuadOidClieUnidAdmiData.setId(new Integer(cuadOidClieUnidAdmi));
		}
		carSoliEntrBloq.setCuadOidClieUnidAdmi(cuadOidClieUnidAdmiData);
		es.indra.belcorp.mso.CarCodigAprobData coapOidCodiAproData = null;
		if(coapOidCodiApro != null && !coapOidCodiApro.trim().equals("")){
			coapOidCodiAproData = new es.indra.belcorp.mso.CarCodigAprobData();
			coapOidCodiAproData.setId(new Integer(coapOidCodiApro));
		}
		carSoliEntrBloq.setCoapOidCodiApro(coapOidCodiAproData);
		es.indra.belcorp.mso.CarEjecuCuentData ejcuOidEjecCuenData = null;
		if(ejcuOidEjecCuen != null && !ejcuOidEjecCuen.trim().equals("")){
			ejcuOidEjecCuenData = new es.indra.belcorp.mso.CarEjecuCuentData();
			ejcuOidEjecCuenData.setId(new Integer(ejcuOidEjecCuen));
		}
		carSoliEntrBloq.setEjcuOidEjecCuen(ejcuOidEjecCuenData);
		es.indra.belcorp.mso.CarEjecuCuentData ejcuOidUsuaLibeData = null;
		if(ejcuOidUsuaLibe != null && !ejcuOidUsuaLibe.trim().equals("")){
			ejcuOidUsuaLibeData = new es.indra.belcorp.mso.CarEjecuCuentData();
			ejcuOidUsuaLibeData.setId(new Integer(ejcuOidUsuaLibe));
		}
		carSoliEntrBloq.setEjcuOidUsuaLibe(ejcuOidUsuaLibeData);
		es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesData = null;
		if(niriOidNiveRies != null && !niriOidNiveRies.trim().equals("")){
			niriOidNiveRiesData = new es.indra.belcorp.mso.CarNivelRiesgData();
			niriOidNiveRiesData.setId(new Integer(niriOidNiveRies));
		}
		carSoliEntrBloq.setNiriOidNiveRies(niriOidNiveRiesData);
		es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoliData = null;
		if(grsoOidGrupSoli != null && !grsoOidGrupSoli.trim().equals("")){
			grsoOidGrupSoliData = new es.indra.belcorp.mso.CarGrupoSolicData();
			grsoOidGrupSoliData.setId(new Integer(grsoOidGrupSoli));
		}
		carSoliEntrBloq.setGrsoOidGrupSoli(grsoOidGrupSoliData);
		

		//Determinamos las descripciones de los atributos internacionalizables
		Vector localizationLabels = buildLocalizationValues();
		
		//Sacamos el timestamp y se lo ponemos el timestamp. Queda deshabilitado ya que en druida no hay bloqueos.....
		//carSoliEntrBloq.jdoSetTimeStamp(Long.parseLong(conectorParametro("timestamp")));
		
		//Creamos el dto y el bussines id correspondientes a la acción de realizar una modificación
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("carSoliEntrBloq", carSoliEntrBloq);
		dto.addProperty("localizationLabels", localizationLabels);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_UPDATE));

		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Update de entidad CarSoliEntrBloq");
		DruidaConector conectorCreate =  conectar(MMG_UPDATE_CONNECTOR, datos);
		traza("MMG:: Finalizada ejecución Update de entidad CarSoliEntrBloq");
		
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
			CarSoliEntrBloqData carSoliEntrBloq = new CarSoliEntrBloqData();
			carSoliEntrBloq.setId(new Integer(claves.nextToken()));
			//carSoliEntrBloq.jdoSetTimeStamp(Long.parseLong(timestamps.nextToken()));
			entities.addElement(carSoliEntrBloq);
		}
		
		//Construimos el DTO para realizar la llamada
		Vector datos = new Vector();
		MareDTO dto = new MareDTO();
		dto.addProperty("entities", entities);
		datos.add(dto);
		datos.add(new MareBusinessID(BUSINESSID_REMOVE));
		
		//Invocamos la lógica de negocio
		traza("MMG:: Iniciada ejecución Remove de entidad CarSoliEntrBloq");
		DruidaConector conectorCreate =  conectar(CONECTOR_REMOVE, datos);
		traza("MMG:: Finalizada ejecución Remove de entidad CarSoliEntrBloq");

		//metemos en la sesión las query para realizar la requery
		conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, conectorParametro(VAR_LAST_QUERY_TO_SESSION));
		
		//Redirigimos a la LP de StartUp con la acción de StartUp y requery
		conectorAction("CarSoliEntrBloqLPStartUp");
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


