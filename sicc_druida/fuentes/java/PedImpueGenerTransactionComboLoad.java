

/*
    INDRA/CAR/mmg
    $Id: PedImpueGenerTransactionComboLoad.java,v 1.1 2009/12/03 18:43:38 pecbazalar Exp $
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
public class PedImpueGenerTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGPedImpueGenerQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "PedImpueGenerConectorCombo";

	// Definicion del constructor
	public PedImpueGenerTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad PedImpueGener");
			
			String sbacOidSbac = (String)getEntrada("sbacOidSbac");
			traza("MMG:: Valor de atributo sbacOidSbac: " + sbacOidSbac);
			
			String taimOidTasaImpu = (String)getEntrada("taimOidTasaImpu");
			traza("MMG:: Valor de atributo taimOidTasaImpu: " + taimOidTasaImpu);
			
			String taimOidTasaImpuFlet = (String)getEntrada("taimOidTasaImpuFlet");
			traza("MMG:: Valor de atributo taimOidTasaImpuFlet: " + taimOidTasaImpuFlet);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			PedImpueGenerData pedImpueGener =new PedImpueGenerData();
			es.indra.belcorp.mso.SegSubacData sbacOidSbacData = null;
			if(sbacOidSbac != null && !sbacOidSbac.trim().equals("")){
				sbacOidSbacData = new es.indra.belcorp.mso.SegSubacData();
				sbacOidSbacData.setId(new Long(sbacOidSbac));
			}
			pedImpueGener.setSbacOidSbac(sbacOidSbacData);
			es.indra.belcorp.mso.PedTasaImpueData taimOidTasaImpuData = null;
			if(taimOidTasaImpu != null && !taimOidTasaImpu.trim().equals("")){
				taimOidTasaImpuData = new es.indra.belcorp.mso.PedTasaImpueData();
				taimOidTasaImpuData.setId(new Long(taimOidTasaImpu));
			}
			pedImpueGener.setTaimOidTasaImpu(taimOidTasaImpuData);
			es.indra.belcorp.mso.PedTasaImpueData taimOidTasaImpuFletData = null;
			if(taimOidTasaImpuFlet != null && !taimOidTasaImpuFlet.trim().equals("")){
				taimOidTasaImpuFletData = new es.indra.belcorp.mso.PedTasaImpueData();
				taimOidTasaImpuFletData.setId(new Long(taimOidTasaImpuFlet));
			}
			pedImpueGener.setTaimOidTasaImpuFlet(taimOidTasaImpuFletData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("pedImpueGenerFrom", pedImpueGener);
			dto.addProperty("pedImpueGenerTo", pedImpueGener.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad PedImpueGener");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad PedImpueGener");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


