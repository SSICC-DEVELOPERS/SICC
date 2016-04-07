import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaBaseComun;
import es.indra.druida.Contexto;

public class LPTimeout extends DruidaBase
{

    public LPTimeout()
    {
    }

    public void inicio()
        throws Exception
    {
        pagina("timeout");
    }

    public void ejecucion()
        throws Exception
    {
		 asignarAtributo("VAR", "destino", "valor", Contexto.getPropiedad("SITE", "BASEURL"));
    }
}