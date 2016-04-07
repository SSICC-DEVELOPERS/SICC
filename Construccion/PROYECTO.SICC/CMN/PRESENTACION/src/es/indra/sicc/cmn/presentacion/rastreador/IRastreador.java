package es.indra.sicc.cmn.presentacion.rastreador;

import java.sql.Date;
import es.indra.mare.common.exception.MareException;

public interface IRastreador  {

    public void RastrearFuncion(Date fechaHora, String codigoFuncion, String usuario, String password) throws MareException;
        
}