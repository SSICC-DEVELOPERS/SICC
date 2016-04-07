

/*
    INDRA/CAR/mmg
    $Id: PedTipoSolicTransactionQuery.java,v 1.1 2009/12/03 18:39:59 pecbazalar Exp $
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
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class PedTipoSolicTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedTipoSolicQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PedTipoSolicConectorQueryList";

	// Definicion del constructor
	public PedTipoSolicTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad PedTipoSolic");
			String codTipoSoli = (String)getEntrada("codTipoSoli");
			traza("MMG:: Valor de atributo codTipoSoli: " + codTipoSoli);
			String ticlOidTipoClie = (String)getEntrada("ticlOidTipoClie");
			traza("MMG:: Valor de atributo ticlOidTipoClie: " + ticlOidTipoClie);
			String marcOidMarc = (String)getEntrada("marcOidMarc");
			traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
			String acceOidAcce = (String)getEntrada("acceOidAcce");
			traza("MMG:: Valor de atributo acceOidAcce: " + acceOidAcce);
			String clsoOidClasSoli = (String)getEntrada("clsoOidClasSoli");
			traza("MMG:: Valor de atributo clsoOidClasSoli: " + clsoOidClasSoli);
			String indCons = (String)getEntrada("indCons");
			traza("MMG:: Valor de atributo indCons: " + indCons);
			String indSoliNega = (String)getEntrada("indSoliNega");
			traza("MMG:: Valor de atributo indSoliNega: " + indSoliNega);
			String grsoOidGrupSoli = (String)getEntrada("grsoOidGrupSoli");
			traza("MMG:: Valor de atributo grsoOidGrupSoli: " + grsoOidGrupSoli);
			String indDevo = (String)getEntrada("indDevo");
			traza("MMG:: Valor de atributo indDevo: " + indDevo);
			String indAnul = (String)getEntrada("indAnul");
			traza("MMG:: Valor de atributo indAnul: " + indAnul);
			String sbacOidSbac = (String)getEntrada("sbacOidSbac");
			traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
			String codGrupSoli = (String)getEntrada("codGrupSoli");
			traza("MMG:: Valor de atributo codGrupSoli: " + codGrupSoli);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PedTipoSolicData pedTipoSolicFrom =new PedTipoSolicData();
			PedTipoSolicData pedTipoSolicTo = new PedTipoSolicData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			pedTipoSolicFrom.setCodTipoSoli(
				(java.lang.String)FormatUtils.parseObject(codTipoSoli, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.MaeTipoClienData ticlOidTipoClieData = null;
			if(ticlOidTipoClie != null && !ticlOidTipoClie.trim().equals("")){
				ticlOidTipoClieData = new es.indra.belcorp.mso.MaeTipoClienData();
				ticlOidTipoClieData.setId(new Long(ticlOidTipoClie));
			}
			pedTipoSolicFrom.setTiclOidTipoClie(ticlOidTipoClieData);
			es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
				marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
				marcOidMarcData.setId(new Long(marcOidMarc));
			}
			pedTipoSolicFrom.setMarcOidMarc(marcOidMarcData);
			es.indra.belcorp.mso.SegAccesData acceOidAcceData = null;
			if(acceOidAcce != null && !acceOidAcce.trim().equals("")){
				acceOidAcceData = new es.indra.belcorp.mso.SegAccesData();
				acceOidAcceData.setId(new Long(acceOidAcce));
			}
			pedTipoSolicFrom.setAcceOidAcce(acceOidAcceData);
			es.indra.belcorp.mso.PedClaseSolicData clsoOidClasSoliData = null;
			if(clsoOidClasSoli != null && !clsoOidClasSoli.trim().equals("")){
				clsoOidClasSoliData = new es.indra.belcorp.mso.PedClaseSolicData();
				clsoOidClasSoliData.setId(new Long(clsoOidClasSoli));
			}
			pedTipoSolicFrom.setClsoOidClasSoli(clsoOidClasSoliData);
			pedTipoSolicFrom.setIndCons(
				(java.lang.Long)FormatUtils.parseObject(indCons, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTipoSolicFrom.setIndSoliNega(
				(java.lang.Long)FormatUtils.parseObject(indSoliNega, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.CarGrupoSolicData grsoOidGrupSoliData = null;
			if(grsoOidGrupSoli != null && !grsoOidGrupSoli.trim().equals("")){
				grsoOidGrupSoliData = new es.indra.belcorp.mso.CarGrupoSolicData();
				grsoOidGrupSoliData.setId(new Long(grsoOidGrupSoli));
			}
			pedTipoSolicFrom.setGrsoOidGrupSoli(grsoOidGrupSoliData);
			pedTipoSolicFrom.setIndDevo(
				(java.lang.Long)FormatUtils.parseObject(indDevo, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			pedTipoSolicFrom.setIndAnul(
				(java.lang.Long)FormatUtils.parseObject(indAnul, "java.lang.Long", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
				sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
				sbacOidSbacData.setId(new Long(sbacOidSbac));
			}
			pedTipoSolicFrom.setSbacOidSbac(sbacOidSbacData);
			pedTipoSolicFrom.setCodGrupSoli(
				(java.lang.String)FormatUtils.parseObject(codGrupSoli, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			pedTipoSolicTo = (PedTipoSolicData)pedTipoSolicFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, pedTipoSolicFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, pedTipoSolicTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedTipoSolicFrom", pedTipoSolicFrom);
			dto.addProperty("pedTipoSolicTo", pedTipoSolicTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PedTipoSolic");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PedTipoSolic");
			
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	
	
	
	
}





