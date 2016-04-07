import java.lang.Exception;
import es.indra.sicc.util.UtilidadesSession;

public class  LPEliminarGerenteCongelado extends LPSICCBase {

	public Long aPais;
	public Long aIdioma;

    public  LPEliminarGerenteCongelado() {
        super();
    }


    public void inicio() throws Exception{
		/**	Proceso: 
		-> Asignar página "ContenidoEliminarGerenteCongelado"
		*/
        traza("Entro a inicio contenido_mantenimiento_gerente_congelado_eliminar");
        pagina("contenido_mantenimiento_gerente_congelado_eliminar");
	this.getFormatosValidaciones();
    	asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
	}

    public void ejecucion() throws Exception {
		getConfiguracionMenu("LPEliminarGerenteCongelado","");
	 	aPais = UtilidadesSession.getPais(this);
		aIdioma = UtilidadesSession.getIdioma(this);

		asignarAtributo("VAR", "varPais", "valor", aPais.toString());
		asignarAtributo("VAR", "varIdioma", "valor", aIdioma.toString());
    }

}

