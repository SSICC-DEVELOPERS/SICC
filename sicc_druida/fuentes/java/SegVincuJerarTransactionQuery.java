

/*
    INDRA/CAR/mmg
    $Id: SegVincuJerarTransactionQuery.java,v 1.1 2009/12/03 18:36:47 pecbazalar Exp $
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
public class SegVincuJerarTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGSegVincuJerarQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "SegVincuJerarConectorQueryList";

	// Definicion del constructor
	public SegVincuJerarTransactionQuery(){
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
			
			traza("MMG:: LLegao a transaction Query de entidad SegVincuJerar");
			String marcOidMarc = (String)getEntrada("marcOidMarc");
			traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")) marcOidMarc = marcOidMarc.toUpperCase();
			String canaOidCana = (String)getEntrada("canaOidCana");
			traza("MMG:: Valor de atributo canaOidCana: " + canaOidCana);
			if(canaOidCana != null && !canaOidCana.trim().equals("")) canaOidCana = canaOidCana.toUpperCase();
			String acceOidAcce = (String)getEntrada("acceOidAcce");
			traza("MMG:: Valor de atributo acceOidAcce: " + acceOidAcce);
			if(acceOidAcce != null && !acceOidAcce.trim().equals("")) acceOidAcce = acceOidAcce.toUpperCase();
			String sbacOidSbac = (String)getEntrada("sbacOidSbac");
			traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")) sbacOidSbac = sbacOidSbac.toUpperCase();
			String sociOidSoci = (String)getEntrada("sociOidSoci");
			traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
			if(sociOidSoci != null && !sociOidSoci.trim().equals("")) sociOidSoci = sociOidSoci.toUpperCase();
			
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			SegVincuJerarData segVincuJerarFrom =new SegVincuJerarData();
			SegVincuJerarData segVincuJerarTo = new SegVincuJerarData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
				marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
				marcOidMarcData.setId(new Long(marcOidMarc));
			}
			segVincuJerarFrom.setMarcOidMarc(marcOidMarcData);
			es.indra.belcorp.mso.SegCanalData canaOidCanaData = null;
			if(canaOidCana != null && !canaOidCana.trim().equals("")){
				canaOidCanaData = new es.indra.belcorp.mso.SegCanalData();
				canaOidCanaData.setId(new Long(canaOidCana));
			}
			segVincuJerarFrom.setCanaOidCana(canaOidCanaData);
			es.indra.belcorp.mso.SegAccesData acceOidAcceData = null;
			if(acceOidAcce != null && !acceOidAcce.trim().equals("")){
				acceOidAcceData = new es.indra.belcorp.mso.SegAccesData();
				acceOidAcceData.setId(new Long(acceOidAcce));
			}
			segVincuJerarFrom.setAcceOidAcce(acceOidAcceData);
			es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
				sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
				sbacOidSbacData.setId(new Long(sbacOidSbac));
			}
			segVincuJerarFrom.setSbacOidSbac(sbacOidSbacData);
			es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
			if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
				sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
				sociOidSociData.setId(new Long(sociOidSoci));
			}
			segVincuJerarFrom.setSociOidSoci(sociOidSociData);
			
			
			//Construimos el to
			segVincuJerarTo = (SegVincuJerarData)segVincuJerarFrom.clone();
			
			
			//Metemos tanto el fromo como el to como últimos mso con parámetros de búsqueda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, segVincuJerarFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, segVincuJerarTo);
			
			//Sacamos los datos de paginación
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("segVincuJerarFrom", segVincuJerarFrom);
			dto.addProperty("segVincuJerarTo", segVincuJerarTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acción de prequery
			cmdPreQuery(segVincuJerarFrom, segVincuJerarTo);
			
			
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad SegVincuJerar");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecución Query de entidad SegVincuJerar");
			
			//Ejecutamos la acción de postquery
			cmdPostQuery(segVincuJerarFrom, segVincuJerarTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(SegVincuJerarData segVincuJerarFrom, SegVincuJerarData segVincuJerarTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));segVincuJerarFrom.setPaisOidPais(paisOculto);segVincuJerarTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(SegVincuJerarData segVincuJerarFrom, SegVincuJerarData segVincuJerarTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();paisOculto.setId(new
				Long(MMGDruidaHelper.getUserDefaultCountry(this)));segVincuJerarFrom.setPaisOidPais(paisOculto);segVincuJerarTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





