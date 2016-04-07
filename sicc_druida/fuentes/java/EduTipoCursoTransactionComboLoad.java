

/*
    INDRA/CAR/mmg
    $Id: EduTipoCursoTransactionComboLoad.java,v 1.1 2009/12/03 18:33:36 pecbazalar Exp $
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
public class EduTipoCursoTransactionComboLoad extends MMGDruidaTransaction {
	//Constantes usadas en la clase. Simplemente representan 
	//los nombre de conectore y de logicas de negocio
	public static final String BUSINESSID_QUERY = "MMGEduTipoCursoQueryFromToUserStructuralSecurity";
	public static final String CONECTOR_QUERY_COMBO= "EduTipoCursoConectorCombo";

	// Definicion del constructor
	public EduTipoCursoTransactionComboLoad(){
		super();
	}

	// Definicion del metodo abstracto ejecucion
	public void ejecucion() throws Exception {
		try{
			//Ejecutamos las acciones comunes
			super.ejecucion();
			
			traza("MMG:: LLegao a transaction Query de entidad EduTipoCurso");
			
			String marcOidMarc = (String)getEntrada("marcOidMarc");
			traza("MMG:: Valor de atributo marcOidMarc: " + marcOidMarc);
			
			
			//Determinamos el flag de aplicación de seguridad estructural
			Boolean mmgApplyStructuralSecurity = new Boolean((String)getEntrada("mmgApplyStructuralSecurity"));
		
			//Construimos los MSOs (from y to) con los elementos de la búsqueda
			EduTipoCursoData eduTipoCurso =new EduTipoCursoData();
			es.indra.belcorp.mso.SegMarcaData marcOidMarcData = null;
			if(marcOidMarc != null && !marcOidMarc.trim().equals("")){
				marcOidMarcData = new es.indra.belcorp.mso.SegMarcaData();
				marcOidMarcData.setId(new Long(marcOidMarc));
			}
			eduTipoCurso.setMarcOidMarc(marcOidMarcData);
						
			
			//Creamos el dto y el bussines id correspondientes a la acción de realiza una query
			Vector datos = new Vector();
			MareDTO dto = new MareDTO();
			dto.addProperty("eduTipoCursoFrom", eduTipoCurso);
			dto.addProperty("eduTipoCursoTo", eduTipoCurso.clone());
			dto.addProperty("userProperties", MMGDruidaHelper.getUserProperties(this));
			dto.addProperty("applyStructuralSecurity", mmgApplyStructuralSecurity);
			datos.add(dto);
			datos.add(new MareBusinessID(BUSINESSID_QUERY));
	
			//Invocamos la lógica de negocio
			traza("MMG:: Iniciada ejecución Query de entidad EduTipoCurso");
			DruidaConector conectorQuery =  conectar(CONECTOR_QUERY_COMBO, datos);
			traza("MMG:: Finalizada ejecución Query de entidad EduTipoCurso");
	
			//Definimos el resultado del conector
			setConector(conectorQuery);
		}catch(Exception e){
			handleException(e);
		}
	}
}


