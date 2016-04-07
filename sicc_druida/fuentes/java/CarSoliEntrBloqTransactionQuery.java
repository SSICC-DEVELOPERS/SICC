

/*
    INDRA/CAR/mmg
    $Id: CarSoliEntrBloqTransactionQuery.java,v 1.1 2009/12/03 18:35:39 pecbazalar Exp $
    DESC
*/

import java.util.*;
import es.indra.utils.*;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGDruidaTransaction;
import es.indra.druida.belcorp.MMGException;
import es.indra.druida.belcorp.MMGNoSessionException;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class CarSoliEntrBloqTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCarSoliEntrBloqQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CarSoliEntrBloqConectorQueryList";

	// Definicion del constructor
	public CarSoliEntrBloqTransactionQuery(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
		
			//Metemos en la sesión la query de la busqueda en formato param1|param2|....|paramN(para el tema de volver a la 
			//pagina anterior y ,mantener los últimos resultados)
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, 
				conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY));
			
			traza("MMG:: LLegao a transaction Query de entidad CarSoliEntrBloq");
			
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			
			
			String sbacOidSbac = (String)getEntrada("sbacOidSbac");
			traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
			
			
			String tsolOidTipoSoli = (String)getEntrada("tsolOidTipoSoli");
			traza("MMG:: Valor de atributo tsolOidTipoSoli: " + tsolOidTipoSoli);
			
			
			String socaOidSoliCabe = (String)getEntrada("socaOidSoliCabe");
			traza("MMG:: Valor de atributo socaOidSoliCabe: " + socaOidSoliCabe);
			
			
			String fecDocu = (String)getEntrada("fecDocu");
			traza("MMG:: Valor de atributo fecDocu: " + fecDocu);
			
			
			String indNoti = (String)getEntrada("indNoti");
			traza("MMG:: Valor de atributo indNoti: " + indNoti);
			
			
			String valMontOrde = (String)getEntrada("valMontOrde");
			traza("MMG:: Valor de atributo valMontOrde: " + valMontOrde);
			
			
			String valMontDeudVenc = (String)getEntrada("valMontDeudVenc");
			traza("MMG:: Valor de atributo valMontDeudVenc: " + valMontDeudVenc);
			
			
			String indVali1 = (String)getEntrada("indVali1");
			traza("MMG:: Valor de atributo indVali1: " + indVali1);
			
			
			String indVali2 = (String)getEntrada("indVali2");
			traza("MMG:: Valor de atributo indVali2: " + indVali2);
			
			
			String indVali3 = (String)getEntrada("indVali3");
			traza("MMG:: Valor de atributo indVali3: " + indVali3);
			
			
			String indVali4 = (String)getEntrada("indVali4");
			traza("MMG:: Valor de atributo indVali4: " + indVali4);
			
			
			String fecHoraLibe = (String)getEntrada("fecHoraLibe");
			traza("MMG:: Valor de atributo fecHoraLibe: " + fecHoraLibe);
			
			
			String valObse = (String)getEntrada("valObse");
			traza("MMG:: Valor de atributo valObse: " + valObse);
			
			
			String jeraOidJera = (String)getEntrada("jeraOidJera");
			traza("MMG:: Valor de atributo jeraOidJera: " + jeraOidJera);
			
			
			String espeOidEstaPedi = (String)getEntrada("espeOidEstaPedi");
			traza("MMG:: Valor de atributo espeOidEstaPedi: " + espeOidEstaPedi);
			
			
			String perdOidPeri = (String)getEntrada("perdOidPeri");
			traza("MMG:: Valor de atributo perdOidPeri: " + perdOidPeri);
			
			
			String clieOidClie = (String)getEntrada("clieOidClie");
			traza("MMG:: Valor de atributo clieOidClie: " + clieOidClie);
			
			
			String clieOidGereZona = (String)getEntrada("clieOidGereZona");
			traza("MMG:: Valor de atributo clieOidGereZona: " + clieOidGereZona);
			
			
			String cuadOidClieUnidAdmi = (String)getEntrada("cuadOidClieUnidAdmi");
			traza("MMG:: Valor de atributo cuadOidClieUnidAdmi: " + cuadOidClieUnidAdmi);
			
			
			String coapOidCodiApro = (String)getEntrada("coapOidCodiApro");
			traza("MMG:: Valor de atributo coapOidCodiApro: " + coapOidCodiApro);
			
			
			String ejcuOidEjecCuen = (String)getEntrada("ejcuOidEjecCuen");
			traza("MMG:: Valor de atributo ejcuOidEjecCuen: " + ejcuOidEjecCuen);
			
			
			String ejcuOidUsuaLibe = (String)getEntrada("ejcuOidUsuaLibe");
			traza("MMG:: Valor de atributo ejcuOidUsuaLibe: " + ejcuOidUsuaLibe);
			
			
			String niriOidNiveRies = (String)getEntrada("niriOidNiveRies");
			traza("MMG:: Valor de atributo niriOidNiveRies: " + niriOidNiveRies);
			
			
			String grsoOidGrupSoli = (String)getEntrada("grsoOidGrupSoli");
			traza("MMG:: Valor de atributo grsoOidGrupSoli: " + grsoOidGrupSoli);
			
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			CarSoliEntrBloqData carSoliEntrBloqFrom =new CarSoliEntrBloqData();
			CarSoliEntrBloqData carSoliEntrBloqTo = new CarSoliEntrBloqData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			
			es.indra.belcorp.mso.SegPaisData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisData();
				paisOidPaisData.setId(new Integer(paisOidPais));
			}
			carSoliEntrBloqFrom.setPaisOidPais(paisOidPaisData);
			
			es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
				sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
				sbacOidSbacData.setId(new Integer(sbacOidSbac));
			}
			carSoliEntrBloqFrom.setSbacOidSbac(sbacOidSbacData);
			
			es.indra.belcorp.mso.PedTipoSolicData tsolOidTipoSoliData = null;
			if(tsolOidTipoSoli != null && !tsolOidTipoSoli.trim().equals("")){
				tsolOidTipoSoliData = new es.indra.belcorp.mso.PedTipoSolicData();
				tsolOidTipoSoliData.setId(new Integer(tsolOidTipoSoli));
			}
			carSoliEntrBloqFrom.setTsolOidTipoSoli(tsolOidTipoSoliData);
			
			es.indra.belcorp.mso.PedSolicCabecData socaOidSoliCabeData = null;
			if(socaOidSoliCabe != null && !socaOidSoliCabe.trim().equals("")){
				socaOidSoliCabeData = new es.indra.belcorp.mso.PedSolicCabecData();
				socaOidSoliCabeData.setId(new Integer(socaOidSoliCabe));
			}
			carSoliEntrBloqFrom.setSocaOidSoliCabe(socaOidSoliCabeData);
			carSoliEntrBloqFrom.setFecDocu(
				(java.sql.Date)FormatUtils.parseObject(fecDocu, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carSoliEntrBloqFrom.setIndNoti(
				(java.lang.Integer)FormatUtils.parseObject(indNoti, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carSoliEntrBloqFrom.setValMontOrde(
				(java.lang.Double)FormatUtils.parseObject(valMontOrde, "java.lang.Double", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carSoliEntrBloqFrom.setValMontDeudVenc(
				(java.lang.Double)FormatUtils.parseObject(valMontDeudVenc, "java.lang.Double", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carSoliEntrBloqFrom.setIndVali1(
				(java.lang.Integer)FormatUtils.parseObject(indVali1, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carSoliEntrBloqFrom.setIndVali2(
				(java.lang.Integer)FormatUtils.parseObject(indVali2, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carSoliEntrBloqFrom.setIndVali3(
				(java.lang.Integer)FormatUtils.parseObject(indVali3, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carSoliEntrBloqFrom.setIndVali4(
				(java.lang.Integer)FormatUtils.parseObject(indVali4, "java.lang.Integer", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carSoliEntrBloqFrom.setFecHoraLibe(
				(java.sql.Date)FormatUtils.parseObject(fecHoraLibe, "java.sql.Date", 
				 MMGDruidaHelper.getUserDatePattern(this, true), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			carSoliEntrBloqFrom.setValObse(
				(java.lang.String)FormatUtils.parseObject(valObse, "java.lang.String", 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			es.indra.belcorp.mso.CarJerarData jeraOidJeraData = null;
			if(jeraOidJera != null && !jeraOidJera.trim().equals("")){
				jeraOidJeraData = new es.indra.belcorp.mso.CarJerarData();
				jeraOidJeraData.setId(new Integer(jeraOidJera));
			}
			carSoliEntrBloqFrom.setJeraOidJera(jeraOidJeraData);
			
			es.indra.belcorp.mso.CarEstatPedidData espeOidEstaPediData = null;
			if(espeOidEstaPedi != null && !espeOidEstaPedi.trim().equals("")){
				espeOidEstaPediData = new es.indra.belcorp.mso.CarEstatPedidData();
				espeOidEstaPediData.setId(new Integer(espeOidEstaPedi));
			}
			carSoliEntrBloqFrom.setEspeOidEstaPedi(espeOidEstaPediData);
			
			es.indra.belcorp.mso.CraPerioData perdOidPeriData = null;
			if(perdOidPeri != null && !perdOidPeri.trim().equals("")){
				perdOidPeriData = new es.indra.belcorp.mso.CraPerioData();
				perdOidPeriData.setId(new Integer(perdOidPeri));
			}
			carSoliEntrBloqFrom.setPerdOidPeri(perdOidPeriData);
			
			es.indra.belcorp.mso.MaeClienData clieOidClieData = null;
			if(clieOidClie != null && !clieOidClie.trim().equals("")){
				clieOidClieData = new es.indra.belcorp.mso.MaeClienData();
				clieOidClieData.setId(new Integer(clieOidClie));
			}
			carSoliEntrBloqFrom.setClieOidClie(clieOidClieData);
			
			es.indra.belcorp.mso.MaeClienData clieOidGereZonaData = null;
			if(clieOidGereZona != null && !clieOidGereZona.trim().equals("")){
				clieOidGereZonaData = new es.indra.belcorp.mso.MaeClienData();
				clieOidGereZonaData.setId(new Integer(clieOidGereZona));
			}
			carSoliEntrBloqFrom.setClieOidGereZona(clieOidGereZonaData);
			
			es.indra.belcorp.mso.MaeClienUnidaAdminData cuadOidClieUnidAdmiData = null;
			if(cuadOidClieUnidAdmi != null && !cuadOidClieUnidAdmi.trim().equals("")){
				cuadOidClieUnidAdmiData = new es.indra.belcorp.mso.MaeClienUnidaAdminData();
				cuadOidClieUnidAdmiData.setId(new Integer(cuadOidClieUnidAdmi));
			}
			carSoliEntrBloqFrom.setCuadOidClieUnidAdmi(cuadOidClieUnidAdmiData);
			
			es.indra.belcorp.mso.CarCodigAprobData coapOidCodiAproData = null;
			if(coapOidCodiApro != null && !coapOidCodiApro.trim().equals("")){
				coapOidCodiAproData = new es.indra.belcorp.mso.CarCodigAprobData();
				coapOidCodiAproData.setId(new Integer(coapOidCodiApro));
			}
			carSoliEntrBloqFrom.setCoapOidCodiApro(coapOidCodiAproData);
			
			es.indra.belcorp.mso.CarEjecuCuentData ejcuOidEjecCuenData = null;
			if(ejcuOidEjecCuen != null && !ejcuOidEjecCuen.trim().equals("")){
				ejcuOidEjecCuenData = new es.indra.belcorp.mso.CarEjecuCuentData();
				ejcuOidEjecCuenData.setId(new Integer(ejcuOidEjecCuen));
			}
			carSoliEntrBloqFrom.setEjcuOidEjecCuen(ejcuOidEjecCuenData);
			
			es.indra.belcorp.mso.CarEjecuCuentData ejcuOidUsuaLibeData = null;
			if(ejcuOidUsuaLibe != null && !ejcuOidUsuaLibe.trim().equals("")){
				ejcuOidUsuaLibeData = new es.indra.belcorp.mso.CarEjecuCuentData();
				ejcuOidUsuaLibeData.setId(new Integer(ejcuOidUsuaLibe));
			}
			carSoliEntrBloqFrom.setEjcuOidUsuaLibe(ejcuOidUsuaLibeData);
			
			es.indra.belcorp.mso.CarNivelRiesgData niriOidNiveRiesData = null;
			if(niriOidNiveRies != null && !niriOidNiveRies.trim().equals("")){
				niriOidNiveRiesData = new es.indra.belcorp.mso.CarNivelRiesgData();
				niriOidNiveRiesData.setId(new Integer(niriOidNiveRies));
			}
			carSoliEntrBloqFrom.setNiriOidNiveRies(niriOidNiveRiesData);
			
			es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoliData = null;
			if(grsoOidGrupSoli != null && !grsoOidGrupSoli.trim().equals("")){
				grsoOidGrupSoliData = new es.indra.belcorp.mso.CarGrupoSolicData();
				grsoOidGrupSoliData.setId(new Integer(grsoOidGrupSoli));
			}
			carSoliEntrBloqFrom.setGrsoOidGrupSoli(grsoOidGrupSoliData);
			
			
			//Construimos el to
			carSoliEntrBloqTo = (CarSoliEntrBloqData)carSoliEntrBloqFrom.clone();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, carSoliEntrBloqFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, carSoliEntrBloqTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("carSoliEntrBloqFrom", carSoliEntrBloqFrom);
			dto.addProperty("carSoliEntrBloqTo", carSoliEntrBloqTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad CarSoliEntrBloq");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad CarSoliEntrBloq");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}





