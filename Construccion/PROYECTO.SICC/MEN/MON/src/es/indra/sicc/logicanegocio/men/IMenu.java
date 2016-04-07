package es.indra.sicc.logicanegocio.men;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;

public interface IMenu 
{
  public RecordSet obtenerFuncionesI(String usuario, Long idIdioma) throws MareException;
}