

/*
    INDRA/CAR/mmg
    $Id: RecTiposOperaViewTransactionComboLoad.java,v 1.1 2009/12/03 18:40:22 pecbazalar Exp $
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
public class RecTiposOperaViewTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGRecTiposOperaViewQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "RecTiposOperaViewConectorCombo";

	// Definicion del constructor
	public RecTiposOperaViewTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad RecTiposOperaView");
			
			String ropeOidOper = (String)getEntrada("ropeOidOper");
			traza("MMG:: Valor de atributo ropeOidOper: " + ropeOidOper);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			RecTiposOperaViewData recTiposOperaView =new RecTiposOperaViewData();
			es.indra.belcorp.mso.RecOperaViewData ropeOidOperData = null;
			if(ropeOidOper != null && !ropeOidOper.trim().equals("")){
				ropeOidOperData = new es.indra.belcorp.mso.RecOperaViewData();
				ropeOidOperData.setId(new Long(ropeOidOper));
			}
			recTiposOperaView.setRopeOidOper(ropeOidOperData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("recTiposOperaViewFrom", recTiposOperaView);
			dto.addProperty("recTiposOperaViewTo", recTiposOperaView.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad RecTiposOperaView");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad RecTiposOperaView");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


