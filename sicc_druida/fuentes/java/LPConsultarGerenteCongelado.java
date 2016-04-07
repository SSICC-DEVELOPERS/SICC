import java.lang.Exception;
import es.indra.sicc.util.UtilidadesSession;

public class  LPConsultarGerenteCongelado extends LPSICCBase {


	public Long aPais;
	public Long aIdioma;

    public  LPConsultarGerenteCongelado() {
        super();
    }


    public void inicio() throws Exception{
		/**	Proceso: 
		-> Asignar página "ContenidoConsultarGerenteCongelado"
		*/
        traza("Entro a inicio contenido_mantenimiento_gerente_congelado_consultar");
        pagina("contenido_mantenimiento_gerente_congelado_consultar");
	this.getFormatosValidaciones();
    	asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());

	}

    public void ejecucion() throws Exception {
		getConfiguracionMenu("LPConsultarGerenteCongelado"," ");
		aPais = UtilidadesSession.getPais(this);
		aIdioma = UtilidadesSession.getIdioma(this);

		asignarAtributo("VAR", "varPais", "valor", aPais.toString());
		asignarAtributo("VAR", "varIdioma", "valor", aIdioma.toString());
	}

}