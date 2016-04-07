package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import java.util.ArrayList;

public interface ISerializableDocument
{
    public void addSeccion(int numeroSeccion);
	public void addMensaje(int mensaje, ArrayList datos);
}
