

/*
    INDRA/CAR/mmg
    $Id: MsgMetacTransactionComboLoad.java,v 1.1 2009/12/03 18:40:41 pecbazalar Exp $
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
public class MsgMetacTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMsgMetacQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "MsgMetacConectorCombo";

	// Definicion del constructor
	public MsgMetacTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad MsgMetac");
			
			String timeOidTipo = (String)getEntrada("timeOidTipo");
			traza("MMG:: Valor de atributo timeOidTipo: " + timeOidTipo);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MsgMetacData msgMetac =new MsgMetacData();
			es.indra.belcorp.mso.MsgTipoMetacData timeOidTipoData = null;
			if(timeOidTipo != null && !timeOidTipo.trim().equals("")){
				timeOidTipoData = new es.indra.belcorp.mso.MsgTipoMetacData();
				timeOidTipoData.setId(new Long(timeOidTipo));
			}
			msgMetac.setTimeOidTipo(timeOidTipoData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("msgMetacFrom", msgMetac);
			dto.addProperty("msgMetacTo", msgMetac.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MsgMetac");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MsgMetac");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


