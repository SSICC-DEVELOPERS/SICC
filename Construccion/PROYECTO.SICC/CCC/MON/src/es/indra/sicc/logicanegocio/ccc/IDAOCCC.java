package es.indra.sicc.logicanegocio.ccc;
import es.indra.mare.common.exception.MareException;

public interface IDAOCCC  {
        /*
         * Operation Long obtenerOidCC (String codigo), in Class IDAOCCC
        Documentation
        Devuelve el oid correspondiente al código de cuenta corriente especificado. 
        Devuelve null si no existe
         * 
         * */
        public Long obtenerOidCC(String codigo) throws MareException;


         /*
          * Operation Long obtenerOidTipoTransaccion (String codigo), in Class IDAOCCC
            Documentation
            Devuelve el oid del tipo de transaccion para el código especificado, null si no existe
          * 
          * */
          public Long obtenerOidTipoTransaccion (String codigo, Long pais) throws MareException;
}