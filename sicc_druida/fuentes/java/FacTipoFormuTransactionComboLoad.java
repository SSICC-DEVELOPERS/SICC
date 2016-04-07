

/*
    INDRA/CAR/mmg
    $Id: FacTipoFormuTransactionComboLoad.java,v 1.1 2009/12/03 18:40:39 pecbazalar Exp $
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
public class FacTipoFormuTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGFacTipoFormuQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "FacTipoFormuConectorCombo";

	// Definicion del constructor
	public FacTipoFormuTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad FacTipoFormu");
			
			
			//Determinamos el flag de aplicaci�n de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la b�squeda
			FacTipoFormuData facTipoFormu =new FacTipoFormuData();
						
			
			//Creamos el dto y el bussines id correspondientes a la acci�n de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("facTipoFormuFrom", facTipoFormu);
			dto.addProperty("facTipoFormuTo", facTipoFormu.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la l�gica de negocio
			traza("MMG:: Iniciada ejecuci�n Query de entidad FacTipoFormu");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecuci�n Query de entidad FacTipoFormu");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


