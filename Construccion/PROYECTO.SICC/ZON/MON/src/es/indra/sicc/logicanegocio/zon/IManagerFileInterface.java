package es.indra.sicc.logicanegocio.zon;

import es.indra.sicc.dtos.zon.DTOListaFicheroDisp;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
                              
import es.indra.mare.common.exception.MareException;

public interface IManagerFileInterface  {

    public final static Long EN_EJECUCION = new Long("-1");
    public final static Long PROCESAMIENTO_FINALIZADO_OK = new Long("-2");
    public final static Long NO_INICIADO = new Long("-3");
    public final static Long PROCESAMIENTO_FINALIZADO_ERROR = new Long("-4");    
    public final static Long SIN_ESTATUS = new Long("-5");


    public void procesar(Long iDproc, String filePath, String typeProc, String filename) throws MareException;

    public DTOListaFicheroDisp  ficherosDisponibles(String typeProc) throws MareException;

    public Integer estadoProc(Long idProc) throws MareException;

    public  DTOManagerFileResult obtenerResultado(Long iDproc) throws MareException;

    public Boolean validarCabecera(Object datos, String typeProc, String filePath, String filename) throws MareException;

    public DTOManagerFileResult procesarsinc(DTOFicheroDisp datos) throws MareException;
    
}