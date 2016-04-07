import java.lang.Exception;
import es.indra.sicc.util.UtilidadesSession;


public class LPModificarGerenteCongelado extends LPSICCBase {

	public Long aPais;
	public Long aIdioma;


    public LPModificarGerenteCongelado() {
        super();
    }


    public void inicio() throws Exception{
		/**	Proceso: 
		-> Asignar página "ContenidoModificarGerenteCongelado"
		*/
        traza("Entro a inicio contenido_mantenimiento_gerente_congelado_modificar");
        pagina("contenido_mantenimiento_gerente_congelado_modificar");
	this.getFormatosValidaciones();
    	asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
		
	}

    public void ejecucion() throws Exception {
		getConfiguracionMenu("LPModificarGerenteCongelado","");
		aPais = UtilidadesSession.getPais(this);
		aIdioma = UtilidadesSession.getIdioma(this);

		asignarAtributo("VAR", "varPais", "valor", aPais.toString());
		asignarAtributo("VAR", "varIdioma", "valor", aIdioma.toString());
    }

}
