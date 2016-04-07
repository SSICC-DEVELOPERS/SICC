/*
    INDRA/CAR/PROY
    $Id: LPPantallaAlert.java,v 1.1 2009/12/03 18:34:20 pecbazalar Exp $
    DESC
*/

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.sicc.util.ErrorManager;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;



public class LPPantallaAlert extends DruidaBase {

    public LPPantallaAlert() {super();}

    public void inicio() throws Exception {
        pagina("PantallaAlert");
    }

    public void ejecucion() throws Exception {
    }

}