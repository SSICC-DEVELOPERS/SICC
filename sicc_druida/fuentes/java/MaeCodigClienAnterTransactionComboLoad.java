

/*
    INDRA/CAR/mmg
    $Id: MaeCodigClienAnterTransactionComboLoad.java,v 1.1 2009/12/03 18:38:44 pecbazalar Exp $
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
public class MaeCodigClienAnterTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGMaeCodigClienAnterQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "MaeCodigClienAnterConectorCombo";

	// Definicion del constructor
	public MaeCodigClienAnterTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad MaeCodigClienAnter");
			
			String clieOidClieNuev = (String)getEntrada("clieOidClieNuev");
			traza("MMG:: Valor de atributo clieOidClieNuev: " + clieOidClieNuev);
			
			String paisOidPais = (String)getEntrada("paisOidPais");
			traza("MMG:: Valor de atributo paisOidPais: " + paisOidPais);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			MaeCodigClienAnterData maeCodigClienAnter =new MaeCodigClienAnterData();
			es.indra.belcorp.mso.MaeClienData clieOidClieNuevData = null;
			if(clieOidClieNuev != null && !clieOidClieNuev.trim().equals("")){
				clieOidClieNuevData = new es.indra.belcorp.mso.MaeClienData();
				clieOidClieNuevData.setId(new Long(clieOidClieNuev));
			}
			maeCodigClienAnter.setClieOidClieNuev(clieOidClieNuevData);
			es.indra.belcorp.mso.SegPaisViewData paisOidPaisData = null;
			if(paisOidPais != null && !paisOidPais.trim().equals("")){
				paisOidPaisData = new es.indra.belcorp.mso.SegPaisViewData();
				paisOidPaisData.setId(new Long(paisOidPais));
			}
			maeCodigClienAnter.setPaisOidPais(paisOidPaisData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("maeCodigClienAnterFrom", maeCodigClienAnter);
			dto.addProperty("maeCodigClienAnterTo", maeCodigClienAnter.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad MaeCodigClienAnter");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad MaeCodigClienAnter");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


