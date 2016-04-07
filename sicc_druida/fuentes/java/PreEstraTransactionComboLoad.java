

/*
    INDRA/CAR/mmg
    $Id: PreEstraTransactionComboLoad.java,v 1.1 2009/12/03 18:39:20 pecbazalar Exp $
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
public class PreEstraTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPreEstraQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "PreEstraConectorCombo";

	// Definicion del constructor
	public PreEstraTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad PreEstra");
			
			String tiesOidTipoEstr = (String)getEntrada("tiesOidTipoEstr");
			traza("MMG:: Valor de atributo tiesOidTipoEstr: " + tiesOidTipoEstr);
			
			String tiprOidTipoProd = (String)getEntrada("tiprOidTipoProd");
			traza("MMG:: Valor de atributo tiprOidTipoProd: " + tiprOidTipoProd);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PreEstraData preEstra =new PreEstraData();
			es.indra.belcorp.mso.PreTipoEstraData tiesOidTipoEstrData = null;
			if(tiesOidTipoEstr != null && !tiesOidTipoEstr.trim().equals("")){
				tiesOidTipoEstrData = new es.indra.belcorp.mso.PreTipoEstraData();
				tiesOidTipoEstrData.setId(new Integer(tiesOidTipoEstr));
			}
			preEstra.setTiesOidTipoEstr(tiesOidTipoEstrData);
			es.indra.belcorp.mso.PreTipoProduData tiprOidTipoProdData = null;
			if(tiprOidTipoProd != null && !tiprOidTipoProd.trim().equals("")){
				tiprOidTipoProdData = new es.indra.belcorp.mso.PreTipoProduData();
				tiprOidTipoProdData.setId(new Integer(tiprOidTipoProd));
			}
			preEstra.setTiprOidTipoProd(tiprOidTipoProdData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("preEstraFrom", preEstra);
			dto.addProperty("preEstraTo", preEstra.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PreEstra");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PreEstra");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


