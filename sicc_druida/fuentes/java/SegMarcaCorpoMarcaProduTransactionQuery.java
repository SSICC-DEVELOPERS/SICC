

/*
    INDRA/CAR/mmg
    $Id: SegMarcaCorpoMarcaProduTransactionQuery.java,v 1.1 2009/12/03 18:33:50 pecbazalar Exp $
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
public class SegMarcaCorpoMarcaProduTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGSegMarcaCorpoMarcaProduQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "SegMarcaCorpoMarcaProduConectorQueryList";

	// Definicion del constructor
	public SegMarcaCorpoMarcaProduTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad SegMarcaCorpoMarcaProdu");
			String marcOidMarc = (String)getEntrada("marcOidMarc");
			traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
			String maprOidMarcProd = (String)getEntrada("maprOidMarcProd");
			traza("MMG:: Valor de atributo maprOidMarcProd: " + maprOidMarcProd);
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduFrom =new SegMarcaCorpoMarcaProduData();
			SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduTo = new SegMarcaCorpoMarcaProduData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
				marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
				marcOidMarcData.setId(new Long(marcOidMarc));
			}
			segMarcaCorpoMarcaProduFrom.setMarcOidMarc(marcOidMarcData);
			es.indra.belcorp.mso.SegMarcaProduData maprOidMarcProdData = null;
			if(maprOidMarcProd != null && !maprOidMarcProd.trim().equals("")){
				maprOidMarcProdData = new es.indra.belcorp.mso.SegMarcaProduData();
				maprOidMarcProdData.setId(new Long(maprOidMarcProd));
			}
			segMarcaCorpoMarcaProduFrom.setMaprOidMarcProd(maprOidMarcProdData);
			
			
			//Construimos el to
			segMarcaCorpoMarcaProduTo = (SegMarcaCorpoMarcaProduData)segMarcaCorpoMarcaProduFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, segMarcaCorpoMarcaProduFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, segMarcaCorpoMarcaProduTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("segMarcaCorpoMarcaProduFrom", segMarcaCorpoMarcaProduFrom);
			dto.addProperty("segMarcaCorpoMarcaProduTo", segMarcaCorpoMarcaProduTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(segMarcaCorpoMarcaProduFrom, segMarcaCorpoMarcaProduTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad SegMarcaCorpoMarcaProdu");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad SegMarcaCorpoMarcaProdu");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(segMarcaCorpoMarcaProduFrom, segMarcaCorpoMarcaProduTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduFrom, SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduTo) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                segMarcaCorpoMarcaProduFrom.setPaisOidPais(paisOculto);
                segMarcaCorpoMarcaProduTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
            
	}
	
	
	public void cmdPostQuery(SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduFrom, SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduTo, DruidaConector result) throws Exception{
		
                SegPaisViewData paisOculto = new SegPaisViewData();
                paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
                segMarcaCorpoMarcaProduFrom.setPaisOidPais(paisOculto);
                segMarcaCorpoMarcaProduTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
                
            
	}
	
	
}





