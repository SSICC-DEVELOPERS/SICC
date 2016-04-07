

/*
    INDRA/CAR/mmg
    $Id: ZonZonaView2TransactionQuery.java,v 1.1 2009/12/03 18:32:39 pecbazalar Exp $
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
public class ZonZonaView2TransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	public static final String CHOICE_ATTRIBUTE = "codZona";
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGZonZonaView2QueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "ZonZonaView2ConectorQueryList";

	// Definicion del constructor
	public ZonZonaView2TransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad ZonZonaView2");
			String marcOidMarc = (String)getEntrada("marcOidMarc");
			traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
			String canaOidCana = (String)getEntrada("canaOidCana");
			traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
			String codZona = (String)getEntrada("codZona");
			traza("MMG:: Valor de atributo codZona: " + codZona);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			ZonZonaView2Data zonZonaView2From =new ZonZonaView2Data();
			ZonZonaView2Data zonZonaView2To = new ZonZonaView2Data();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
				marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
				marcOidMarcData.setId(new Long(marcOidMarc));
			}
			zonZonaView2From.setMarcOidMarc(marcOidMarcData);
			es.indra.belcorp.mso.SegCanalViewData canaOidCanaData = null;
			if(canaOidCana != null && !canaOidCana.trim().equals("")){
				canaOidCanaData = new es.indra.belcorp.mso.SegCanalViewData();
				canaOidCanaData.setId(new Long(canaOidCana));
			}
			zonZonaView2From.setCanaOidCana(canaOidCanaData);
			zonZonaView2From.setCodZona(
				(java.lang.String)FormatUtils.parseObject(codZona, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			zonZonaView2To = (ZonZonaView2Data)zonZonaView2From.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, zonZonaView2From);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, zonZonaView2To);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("zonZonaView2From", zonZonaView2From);
			dto.addProperty("zonZonaView2To", zonZonaView2To);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(zonZonaView2From, zonZonaView2To);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad ZonZonaView2");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad ZonZonaView2");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(zonZonaView2From, zonZonaView2To, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(ZonZonaView2Data zonZonaView2From, ZonZonaView2Data zonZonaView2To) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				zonZonaView2From.setPaisOidPais(paisOculto);
				zonZonaView2To.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(ZonZonaView2Data zonZonaView2From, ZonZonaView2Data zonZonaView2To, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				zonZonaView2From.setPaisOidPais(paisOculto); 
				zonZonaView2To.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





