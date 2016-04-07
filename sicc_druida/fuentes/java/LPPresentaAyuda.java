/*
    INDRA/CAR/PROY
    $Id: LPPresentaAyuda.java,v 1.1 2009/12/03 18:39:52 pecbazalar Exp $
    DESC
*/
import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.IVariablesSesion;

import es.indra.sicc.dtos.seg.AyudaDTO;

import java.util.Vector;
//import LPSICCBase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LPPresentaAyuda extends LPSICCBase {
    public LPPresentaAyuda() {
        super();
    }

    public void inicio() throws Exception {
        pagina("contenido_ayuda_men");
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();

        try {
			String idFuncion = (String) conectorParametroSesion(IVariablesSesion.ID_FUNCION);
traza("idFuncion - " + IVariablesSesion.ID_FUNCION);
traza("idFuncion1: " + (String) conectorParametroSesion("idFuncion"));
traza("idFuncion2: " + idFuncion);
     
			if ((idFuncion == null) || (idFuncion.length() == 0)) {
				idFuncion = "-1"; //fuerzo a que salga en blanco la pantalla
				//throw new Exception("ERR_81");
			}

traza("11");
            AyudaDTO dtoeAyuda = new AyudaDTO();
            dtoeAyuda.setOidFuncion(new Long(Long.parseLong(idFuncion)));
			dtoeAyuda.setOidAyuda(new Long(Long.parseLong(idFuncion)));
traza("21");
			dtoeAyuda.setPrograma(UtilidadesSession.getFuncion(this));
			dtoeAyuda.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
			dtoeAyuda.setOidIdioma(UtilidadesSession.getIdioma(this));

traza("dtoeAyuda " + dtoeAyuda);
				
            MareBusinessID id = new MareBusinessID("BuscarAyudaFuncion");
            Vector paramEntrada = new Vector();
            paramEntrada.addElement(dtoeAyuda);
            paramEntrada.addElement(id);
traza("31");
            DruidaConector conectorPresentarAyuda = conectar("ConectorBuscarAyudaFuncion", paramEntrada);
traza("41");
            AyudaDTO dtoSalida = (AyudaDTO) conectorPresentarAyuda.objeto("dtoSalida");
traza("51");
            String outMessage = dtoSalida.getTextoAyuda();

            if (outMessage != null) {
                asignarAtributo("LABELC", "lblcontenido", "valor", outMessage);
            } else {
				asignarAtributo("LABELC", "lblcontenido", "valor", "");
                //throw new Exception("ERR_81");
            }
        } catch (Exception e) {

			ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            PrintStream printstream = new PrintStream(bytearrayoutputstream);
            e.printStackTrace(printstream);
            traza("EXCEPCION:" + bytearrayoutputstream.toString());
 
			lanzarPaginaError(e);
 			
        }
    }
}
