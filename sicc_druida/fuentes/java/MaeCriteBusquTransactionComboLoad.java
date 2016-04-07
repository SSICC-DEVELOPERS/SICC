

/*
    INDRA/CAR/mmg
    $Id: MaeCriteBusquTransactionComboLoad.java,v 1.1 2009/12/03 18:39:54 pecbazalar Exp $
    DESC
*/

import java.util.*;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.druida.belcorp.MMGDruidaTransaction;
import es.indra.druida.belcorp.MMGException;
import es.indra.druida.belcorp.MMGNoSessionException;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.belcorp.mso.*;

// Definicion de la clase
public class MaeCriteBusquTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeCriteBusquQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "MaeCriteBusquConectorCombo";

	// Definicion del constructor
	public MaeCriteBusquTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad MaeCriteBusqu");
			
			String atreOidAtriEsp1 = (String)getEntrada("atreOidAtriEsp1");
			traza("MMG:: Valor de atributo atreOidAtriEsp1: " + atreOidAtriEsp1);
			
			String atreOidAtriEsp2 = (String)getEntrada("atreOidAtriEsp2");
			traza("MMG:: Valor de atributo atreOidAtriEsp2: " + atreOidAtriEsp2);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeCriteBusquData maeCriteBusqu =new MaeCriteBusquData();
			es.indra.belcorp.mso.PedAtribEspecData atreOidAtriEsp1Data = null;
			if(atreOidAtriEsp1 != null && !atreOidAtriEsp1.trim().equals("")){
				atreOidAtriEsp1Data = new es.indra.belcorp.mso.PedAtribEspecData();
				atreOidAtriEsp1Data.setId(new Long(atreOidAtriEsp1));
			}
			maeCriteBusqu.setAtreOidAtriEsp1(atreOidAtriEsp1Data);
			es.indra.belcorp.mso.PedAtribEspecData atreOidAtriEsp2Data = null;
			if(atreOidAtriEsp2 != null && !atreOidAtriEsp2.trim().equals("")){
				atreOidAtriEsp2Data = new es.indra.belcorp.mso.PedAtribEspecData();
				atreOidAtriEsp2Data.setId(new Long(atreOidAtriEsp2));
			}
			maeCriteBusqu.setAtreOidAtriEsp2(atreOidAtriEsp2Data);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeCriteBusquFrom", maeCriteBusqu);
			dto.addProperty("maeCriteBusquTo", maeCriteBusqu.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeCriteBusqu");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeCriteBusqu");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


