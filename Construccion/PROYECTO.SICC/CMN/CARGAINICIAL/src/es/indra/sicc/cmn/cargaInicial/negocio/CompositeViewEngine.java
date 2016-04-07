package es.indra.sicc.cmn.cargaInicial.negocio;

import java.util.ArrayList;
import java.util.List;

import es.indra.mare.common.activator.ActivatorFactory;
import es.indra.mare.common.activator.ActivatorNotFoundException;
import es.indra.mare.common.activator.OperationDefinition;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dts.IMareDTS;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.exception.MareSystemLevelException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.mln.businessdefinition.BusinessDefinition;
import es.indra.mare.common.mln.engine.simple.FlatEngine;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.DTODatosPantalla;
import es.indra.sicc.util.DTOSalida;

/**
 * This engine is intended for workflows with several activities in a row
 */
public class CompositeViewEngine extends FlatEngine{

	/**
	 * Constructor for FlatEngine.
	 * @param businessDefinition
	 */
	public CompositeViewEngine(BusinessDefinition businessDefinition) {
		super(businessDefinition);
	}

	/**
	 * @see es.indra.mare.common.mln.engine.IMareEngine#execute(IMareDTS)
	 */
	public void execute(MareBusinessID mareBusinessID, IMareDTS context) throws MareSystemLevelException, MareException {

		ActivatorFactory af;
		try {
			af = (ActivatorFactory) MareMii.getService(new MareTopic("ActivatorService"));
		} catch (MareMiiServiceNotFoundException e) {
			throw new MareSystemLevelException("Can´t find Activator Service", e);
		}
		
		//We get the input
		Object input = context.getProperty(IMareDTS.DTO_INPUT_KEY );
		if (!(input instanceof ComposerViewElementList)){
			throw new MareException("In order to use this engine, a ComposerViewElementList must be used as input");
		}
		//Create the composite view from several business operations
		Object output = executeComposite(context, af, (ComposerViewElementList)input);
		
		//We set the result in the contextM
		context.addProperty(IMareDTS.DTO_OUTPUT_KEY, output);
	}
	
	private DTODatosPantalla executeComposite(IMareDTS context, ActivatorFactory af, ComposerViewElementList lista)
	 	throws MareSystemLevelException, MareException{ 
		List resultados = new ArrayList(); //Aqui vamos guardando los recordsets
		ComposerViewElement cv = null;
		IMareDTO dto = null;
		OperationDefinition operation = null;
	
		//Procesamos cada una de las peticiones
		for (int i=0; i<lista.getSize(); i++) {
			cv = lista.getViewElement(i);
			dto = cv.getDTOE();
			context.addProperty(IMareDTS.DTO_INPUT_KEY, dto);
			try {
				operation = af.create(cv.getIDBusiness(), context);
			} catch (ActivatorNotFoundException e) {
				throw new MareSystemLevelException(cv.getIDBusiness(), e);
			}
			try{
				operation.invoke();
				resultados.add(context.getLastResult());
			} catch(MareException e) {
				//We could'nt get the result from this operation
        if(e.getCode()==5){
  				resultados.add(null);	
        }else{
          throw e;
        }
			}			
		}
		return adaptarResultados(resultados);
	}
	
	/** Prepara el dto de salida con los resultados de las llamadas
	 * @param resultados
	 * @return
	 */
	protected DTODatosPantalla adaptarResultados(List resultados) {
		if (resultados == null) {
			return new DTODatosPantalla(0);
		}
		
		int numResultados = resultados.size();
		DTODatosPantalla dto = new DTODatosPantalla(numResultados);
		
		RecordSet rs = null;
		Object objeto = null;
		for (int i=0; i<numResultados; i++){
			objeto = resultados.get(i);
			//Obtenemos el recordset que hay en el elemento de la lista (si lo hay)
			if (objeto == null) {
				rs = null;
			} else if (objeto instanceof RecordSet){
				rs = (RecordSet)objeto;
			} else if (objeto instanceof DTOSalida){
				rs = ((DTOSalida)objeto).getResultado();
			} else {
				rs = null;
			}						
			dto.asignarDatos(i, rs);
		}		
		return dto;
	}	
}
