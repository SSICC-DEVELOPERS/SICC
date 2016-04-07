

/*
    INDRA/CAR/mmg
    $Id: PedAsignAlmacTransactionQuery.java,v 1.1 2009/12/03 18:39:49 pecbazalar Exp $
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
public class PedAsignAlmacTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedAsignAlmacQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "PedAsignAlmacConectorQueryList";

	// Definicion del constructor
	public PedAsignAlmacTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad PedAsignAlmac");
			String marcOidMarc = (String)getEntrada("marcOidMarc");
			traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
			String sbacOidSbac = (String)getEntrada("sbacOidSbac");
			traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
			String almcOidAlma = (String)getEntrada("almcOidAlma");
			traza("MMG:: Valor de atributo almcOidAlma: " + almcOidAlma);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PedAsignAlmacData pedAsignAlmacFrom =new PedAsignAlmacData();
			PedAsignAlmacData pedAsignAlmacTo = new PedAsignAlmacData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
				marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
				marcOidMarcData.setId(new Long(marcOidMarc));
			}
			pedAsignAlmacFrom.setMarcOidMarc(marcOidMarcData);
			es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
				sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
				sbacOidSbacData.setId(new Long(sbacOidSbac));
			}
			pedAsignAlmacFrom.setSbacOidSbac(sbacOidSbacData);
			es.indra.belcorp.mso.BelAlmacData almcOidAlmaData = null;
			if(almcOidAlma != null && !almcOidAlma.trim().equals("")){
				almcOidAlmaData = new es.indra.belcorp.mso.BelAlmacData();
				almcOidAlmaData.setId(new Long(almcOidAlma));
			}
			pedAsignAlmacFrom.setAlmcOidAlma(almcOidAlmaData);
			
			
			//Construimos el to
			pedAsignAlmacTo = (PedAsignAlmacData)pedAsignAlmacFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, pedAsignAlmacFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, pedAsignAlmacTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedAsignAlmacFrom", pedAsignAlmacFrom);
			dto.addProperty("pedAsignAlmacTo", pedAsignAlmacTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(pedAsignAlmacFrom, pedAsignAlmacTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PedAsignAlmac");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PedAsignAlmac");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(pedAsignAlmacFrom, pedAsignAlmacTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(PedAsignAlmacData pedAsignAlmacFrom, PedAsignAlmacData pedAsignAlmacTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				pedAsignAlmacFrom.setPaisOidPais(paisOculto);
				pedAsignAlmacTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(PedAsignAlmacData pedAsignAlmacFrom, PedAsignAlmacData pedAsignAlmacTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				pedAsignAlmacFrom.setPaisOidPais(paisOculto);
				pedAsignAlmacTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





