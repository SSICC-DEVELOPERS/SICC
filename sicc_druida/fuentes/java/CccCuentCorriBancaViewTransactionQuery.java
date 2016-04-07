

/*
    INDRA/CAR/mmg
    $Id: CccCuentCorriBancaViewTransactionQuery.java,v 1.1 2009/12/03 18:34:20 pecbazalar Exp $
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
public class CccCuentCorriBancaViewTransactionQuery extends MMGDruidaTransaction {
	//Constante que determina el atributo chocice de la entidada
	
	
	
	
	

	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGCccCuentCorriBancaViewQueryFromToUserPage";
	public static final String CONECTOR_QUERY_LIST = "CccCuentCorriBancaViewConectorQueryList";

	// Definicion del constructor
	public CccCuentCorriBancaViewTransactionQuery(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
		
			//Metemos en la sesi�n la query de la busqueda en formato param1|param2|....|paramN(para el tema de volver a la 
			//pagina anterior y ,mantener los �ltimos resultados)
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY, 
				conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY));
			
			traza("MMG:: LLegao a transaction Query de entidad CccCuentCorriBancaView");
			String sociOidSoci = (String)getEntrada("sociOidSoci");
			traza("MMG:: Valor de atributo sociOidSoci: " + sociOidSoci);
			if(sociOidSoci != null && !sociOidSoci.trim().equals("")) sociOidSoci = sociOidSoci.toUpperCase();
			String desCc = (String)getEntrada("desCc");
			traza("MMG:: Valor de atributo desCc: " + desCc);
			if(desCc != null && !desCc.trim().equals("")) desCc = desCc.toUpperCase();
			
		
			//Construimos los MSOs (from y to) con los elementos de la b�squeda
			CccCuentCorriBancaViewData cccCuentCorriBancaViewFrom =new CccCuentCorriBancaViewData();
			CccCuentCorriBancaViewData cccCuentCorriBancaViewTo = new CccCuentCorriBancaViewData();
			
			//Construimos el from. Los campos que no sean de intervalo ponemos
			//el mismo valor que el from. y los que si sen de intervalo ponemos el valor
			//corespondiente
			es.indra.belcorp.mso.SegSocieData sociOidSociData = null;
			if(sociOidSoci != null && !sociOidSoci.trim().equals("")){
				sociOidSociData = new es.indra.belcorp.mso.SegSocieData();
				sociOidSociData.setId(new Long(sociOidSoci));
			}
			cccCuentCorriBancaViewFrom.setSociOidSoci(sociOidSociData);
			cccCuentCorriBancaViewFrom.setDesCc(
				(java.lang.String)FormatUtils.parseObject(desCc, "java.lang.String", 
			MMGDruidaHelper.getUserDecimalFormatPattern(this)
			, MMGDruidaHelper.getUserDecimalFormatSymbols(this)));
			
			
			//Construimos el to
			cccCuentCorriBancaViewTo = (CccCuentCorriBancaViewData)cccCuentCorriBancaViewFrom.clone();
			
			
			//Metemos tanto el fromo como el to como �ltimos mso con par�metros de b�squeda
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_FROM, cccCuentCorriBancaViewFrom);
			conectorParametroSesion(SESSION_ATTRIBUTE_LAST_QUERY_OBJ_TO, cccCuentCorriBancaViewTo);
			
			//Sacamos los datos de paginaci�n
			Integer pageCount = new Integer((String)getEntrada("pageCount"));
			Integer pageSize = new Integer((String)getEntrada("pageSize"));
			
			//Creamos el dto y el bussines id correspondientes a la acci�n de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("cccCuentCorriBancaViewFrom", cccCuentCorriBancaViewFrom);
			dto.addProperty("cccCuentCorriBancaViewTo", cccCuentCorriBancaViewTo);
			dto.addProperty("pageCount", pageCount);
			dto.addProperty("pageSize", pageSize);
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
			
			//Ejecutamos la acci�n de prequery
			cmdPreQuery(cccCuentCorriBancaViewFrom, cccCuentCorriBancaViewTo);
			
			
			//Invocamos la l�gica de negocio
			traza("MMG:: Iniciada ejecuci�n Query de entidad CccCuentCorriBancaView");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_LIST, datos);
			traza("MMG:: Finalizada ejecuci�n Query de entidad CccCuentCorriBancaView");
			
			//Ejecutamos la acci�n de postquery
			cmdPostQuery(cccCuentCorriBancaViewFrom, cccCuentCorriBancaViewTo, conectorQuery);
			
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
	
	public void cmdPreQuery(CccCuentCorriBancaViewData cccCuentCorriBancaViewFrom, CccCuentCorriBancaViewData cccCuentCorriBancaViewTo) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentCorriBancaViewFrom.setPaisOidPais(paisOculto);
				cccCuentCorriBancaViewTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
	public void cmdPostQuery(CccCuentCorriBancaViewData cccCuentCorriBancaViewFrom, CccCuentCorriBancaViewData cccCuentCorriBancaViewTo, DruidaConector result) throws Exception{
		
				SegPaisViewData paisOculto = new SegPaisViewData();
				paisOculto.setId(new Long(MMGDruidaHelper.getUserDefaultCountry(this)));
				cccCuentCorriBancaViewFrom.setPaisOidPais(paisOculto);
				cccCuentCorriBancaViewTo.setPaisOidPais((SegPaisViewData)paisOculto.clone());
			
	}
	
	
}





