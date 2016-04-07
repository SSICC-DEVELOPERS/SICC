import java.lang.Exception;

public class LPInsertarGerenteCongelado extends LPSICCBase {

    public LPInsertarGerenteCongelado() {
        super();
    }


    public void inicio() throws Exception{
		/**	Proceso: 
		-> Asignar página "ContenidoInsertarGerenteCongelado"
		*/
        traza("Entro Inicio contenido_mantenimiento_gerente_congelado_insertar");
        pagina("contenido_mantenimiento_gerente_congelado_insertar");
	this.getFormatosValidaciones();
    	asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
	}

    public void ejecucion() throws Exception {
        getConfiguracionMenu("LPInsertarGerenteCongelado","");
    }

}
