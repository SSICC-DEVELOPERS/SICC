

/*
    INDRA/CAR/mmg
    $Id: PedImpueGenerTransactionQuery.java,v 1.1 2009/12/03 18:41:06 pecbazalar Exp $
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
public class PedImpueGenerTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedImpueGenerQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PedImpueGenerConectorQueryList";

	// Definicion del constructor
	public PedImpueGenerTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad PedImpueGener");
			String sbacOidSbac = (String)getEntrada("sbacOidSbac");
			traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
			String taimOidTasaImpu = (String)getEntrada("taimOidTasaImpu");
			traza("MMG:: Valor de atributo taimOidTasaImpu: " + taimOidTasaImpu);
			String taimOidTasaImpuFlet = (String)getEntrada("taimOidTasaImpuFlet");
			traza("MMG:: Valor de atributo taimOidTasaImpuFlet: " + taimOidTasaImpuFlet);
			String indTasaUnic = (String)getEntrada("indTasaUnic");
			traza("MMG:: Valor de atributo indTasaUnic: " + indTasaUnic);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PedImpueGenerData pedImpueGenerFrom =new PedImpueGenerData();
			PedImpueGenerData pedImpueGenerTo = new PedImpueGenerData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
				sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
				sbacOidSbacData.setId(new Long(sbacOidSbac));
			}
			pedImpueGenerFrom.setSbacOidSbac(sbacOidSbacData);
			es.indra.belcorp.mso.PedTasaImpueData taimOidTasaImpuData = null;
			if(taimOidTasaImpu != null && !taimOidTasaImpu.trim().equals("")){
				taimOidTasaImpuData = new es.indra.belcorp.mso.PedTasaImpueData();
				taimOidTasaImpuData.setId(new Long(taimOidTasaImpu));
			}
			pedImpueGenerFrom.setTaimOidTasaImpu(taimOidTasaImpuData);
			es.indra.belcorp.mso.PedTasaImpueData taimOidTasaImpuFletData = null;
			if(taimOidTasaImpuFlet != null && !taimOidTasaImpuFlet.trim().equals("")){
				taimOidTasaImpuFletData = new es.indra.belcorp.mso.PedTasaImpueData();
				taimOidTasaImpuFletData.setId(new Long(taimOidTasaImpuFlet));
			}
			pedImpueGenerFrom.setTaimOidTasaImpuFlet(taimOidTasaImpuFletData);
			pedImpueGenerFrom.setIndTasaUnic(
				(java.lang.Boolean)FormatUtils.parseObject(indTasaUnic, "java.lang.Boolean", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			pedImpueGenerTo = (PedImpueGenerData)pedImpueGenerFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, pedImpueGenerFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, pedImpueGenerTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedImpueGenerFrom", pedImpueGenerFrom);
			dto.addProperty("pedImpueGenerTo", pedImpueGenerTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(pedImpueGenerFrom, pedImpueGenerTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PedImpueGener");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PedImpueGener");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(pedImpueGenerFrom, pedImpueGenerTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(PedImpueGenerData pedImpueGenerFrom, PedImpueGenerData pedImpueGenerTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedImpueGenerFrom.setPaisOidPais(paisOculto);pedImpueGenerTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(PedImpueGenerData pedImpueGenerFrom, PedImpueGenerData pedImpueGenerTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));pedImpueGenerFrom.setPaisOidPais(paisOculto);pedImpueGenerTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





