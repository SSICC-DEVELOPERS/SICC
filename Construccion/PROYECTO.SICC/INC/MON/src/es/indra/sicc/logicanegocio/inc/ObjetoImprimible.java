package es.indra.sicc.logicanegocio.inc;
import es.indra.sicc.util.UtilidadesLog;

public class ObjetoImprimible {
    public ObjetoImprimible() {
    }

    public boolean print(Object string) {
        UtilidadesLog.debug(string);

        return true;
    }
}
