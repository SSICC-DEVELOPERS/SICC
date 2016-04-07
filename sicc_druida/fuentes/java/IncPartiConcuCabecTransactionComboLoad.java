

/*
    INDRA/CAR/mmg
    $Id: IncPartiConcuCabecTransactionComboLoad.java,v 1.1 2009/12/03 18:37:35 pecbazalar Exp $
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
public class IncPartiConcuCabecTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGIncPartiConcuCabecQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "IncPartiConcuCabecConectorCombo";

	// Definicion del constructor
	public IncPartiConcuCabecTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad IncPartiConcuCabec");
			
			String diriOidDiri = (String)getEntrada("diriOidDiri");
			traza("MMG:: Valor de atributo diriOidDiri: " + diriOidDiri);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			IncPartiConcuCabecData incPartiConcuCabec =new IncPartiConcuCabecData();
			es.indra.belcorp.mso.IncDirigData diriOidDiriData = null;
			if(diriOidDiri != null && !diriOidDiri.trim().equals("")){
				diriOidDiriData = new es.indra.belcorp.mso.IncDirigData();
				diriOidDiriData.setId(new Long(diriOidDiri));
			}
			incPartiConcuCabec.setDiriOidDiri(diriOidDiriData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("incPartiConcuCabecFrom", incPartiConcuCabec);
			dto.addProperty("incPartiConcuCabecTo", incPartiConcuCabec.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad IncPartiConcuCabec");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad IncPartiConcuCabec");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


