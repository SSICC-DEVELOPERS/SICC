/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.logicanegocio.zon;

/**
 * Sistema:           Belcorp - SICC
 * Modulo:            ZON - Zonificacion
 * Componente:        EstructuraVialFileWrapper
 * Fecha:             20/11/2003
 * Documentacion:     
 * Observaciones:     
 *
 * @version           1.0
 * @author            Dario Hruszecki
 */ 

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Collection;
import es.indra.sicc.dtos.zon.DTOEstructuraVialRegistro;
import es.indra.sicc.dtos.zon.DTOEstructuraVialCabecera;
import es.indra.sicc.util.UtilidadesFecha;
import java.sql.Timestamp;
import java.util.StringTokenizer;
import java.util.Vector;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

public class EstructuralVialFileWrapper extends FileWrapper  {

    private static int CANT_LINEAS_CABECERA = 3;
    private static int CANT_LINEAS_REGISTRO = 1;
    private static int CANT_COLS_REGISTRO = 9;
    private static String SEPARADOR = ";";
    private static String FORMATO_FECHA = "yyyyMMdd";//"AAAAMMDD"; 

    public EstructuralVialFileWrapper() {
    }

    public EstructuralVialFileWrapper(String path, String filename) 
    throws MareException {
        UtilidadesLog.info("EstructuralVialFileWrapper(String path, String filename) : Entrada");
        cant_lineas_cabecera = CANT_LINEAS_CABECERA;
        cant_lineas_registro = CANT_LINEAS_REGISTRO;
        abrirArchivo(path,filename);
        UtilidadesLog.info("EstructuralVialFileWrapper(String path, String filename) : Salida");
    }
    
    /*
     * Retorna en una referencia de tipo object, un dto de tipo 
     * DTOEstructuraVialRegistro
     * Registros: 
     * Operacion (Ej. "A") 
     * codTerritorio 
     * tipoVia 
     * nombreVia 
     * numInicio 
     * numFin 
     * sentido 
     * lado 
     * Cod de UG
     */  

	/**
	 * Sistema:     Belcorp
	 * Modulo:      ZON
	 * Fecha:       31/08/2004
	 * @version     Modificación V3.1
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: 
	 */
	 // Registros: 
	 // 	Operacion (Ej. "A") 
	 // 	codTerritorio 
	 // 	codVia 
	 // 	numViaSegmento 
	 // 	numInicio 
	 // 	numFin 
	 // 	sentido 
	 // 	lado 
	 // 	UBIGEO 

    public Object parseRegistro(Collection reg) throws MareException {
        UtilidadesLog.info("EstructuralVialFileWrapper.parseRegistro(Collection reg): Entrada");
        DTOEstructuraVialRegistro dtos = new DTOEstructuraVialRegistro();
        StringTokenizer stk;
        String codigoError;

        if ((reg != null) && (reg.size()==0)) {
           return null;
        } else {
            stk = new StringTokenizer(UtilidadesBelcorp.replace((String)((Vector)reg).get(0),";;","; ;"),this.SEPARADOR);
            
            UtilidadesLog.info("stk.countTokens(): " + stk.countTokens());
            
            if (stk.countTokens() == CANT_COLS_REGISTRO) {
                /*
                 * Seteo los datos en el DTO
                 */
                dtos.setOperacion(stk.nextToken());
                dtos.setCodTerritorio(stk.nextToken());
                dtos.setCodVia(stk.nextToken());
				dtos.setNumViaSegmento(stk.nextToken());
				dtos.setNumInicio(stk.nextToken());
                dtos.setNumFin(stk.nextToken());
				dtos.setSentido(stk.nextToken());
                dtos.setLado(stk.nextToken());                
                dtos.setUBIGEO(stk.nextToken());
                
                /*
                 * Valido registro
                 * Campos que debo validar:
                 * numInicio (Integer)
                 * numFin (Integer)
                 * Sentido (Character)
                 * Lado (Character)
                 */
                try {
					UtilidadesBelcorp.StringToInteger(dtos.getCodVia());
					UtilidadesBelcorp.StringToInteger(dtos.getNumViaSegmento());
                    UtilidadesBelcorp.StringToInteger(dtos.getNumInicio());
                    UtilidadesBelcorp.StringToInteger(dtos.getNumFin());
                    UtilidadesBelcorp.StringToCharacter(dtos.getLado());
                    UtilidadesBelcorp.StringToCharacter(dtos.getSentido());
                } catch(MareException me) {
                    UtilidadesLog.debug(me);
                    me.printStackTrace();
                    // 23002 - dmorello, 15/06/2006: Como "message" de la excepción irá el registro erróneo
                    String regErroneo = (String)((Vector)reg).get(0);
                    UtilidadesLog.debug("Linea erronea: " + regErroneo);
                    UtilidadesLog.info("EstructuralVialFileWrapper.parseRegistro(Collection reg): Salida");
                    throw new MareException(regErroneo, me,
		                  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.DATO_DE_REGISTRO_ERRONEO));
                }
            } else {
                    // 23002 - dmorello, 15/06/2006: Como "message" de la excepción irá el registro erróneo
                    String regErroneo = (String)((Vector)reg).get(0);
                    UtilidadesLog.debug("Linea erronea: " + regErroneo);                    
                    UtilidadesLog.info("EstructuralVialFileWrapper.parseRegistro(Collection reg): Salida");
                    throw new MareException(regErroneo, null,
		                  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.DATO_DE_REGISTRO_ERRONEO));
            }
        }       
        
        UtilidadesLog.info("EstructuralVialFileWrapper.parseRegistro(Collection reg): Salida");
        return dtos;
    }

     /*
     * Retorna en una referencia de tipo object, un dto de tipo 
     * DTOEstructuraVialCabecera 
     * CABECERA: 
     * Pais (Ej. PERU) 
     * Tipo Fichero (Ej. "CARGA VIAL") 
     * Fecha (Ej. DD/MM/YYYY) 
     */
    public Object parseCabecera(Collection  cab) throws MareException {
        try {
            UtilidadesLog.info("EstructuralVialFileWrapper.parseCabecera(Collection  cab): Entrada");
            DTOEstructuraVialCabecera dtos = new DTOEstructuraVialCabecera();
            /*
             * un registro porlinea
             */
             Object[] lineas = cab.toArray();
    
             /*
              * obtengo los atributos
              */
             dtos.setPais(lineas[0].toString());
             dtos.setTipoFichero(lineas[1].toString());
             dtos.setFecha(UtilidadesFecha.convertirATimestamp(lineas[2].toString(),FORMATO_FECHA));
    
             /*
              * retorno el dtos
              */
            UtilidadesLog.info("EstructuralVialFileWrapper.parseCabecera(Collection  cab): Salida");
             return dtos;
        } catch (MareException e) {
            UtilidadesLog.info("EstructuralVialFileWrapper.parseCabecera(Collection  cab): Salida");
            throw e;
        } catch(Exception e) {
            UtilidadesLog.debug(e);
            UtilidadesLog.info("EstructuralVialFileWrapper.parseCabecera(Collection  cab): Salida");
            throw new MareException(e,
		                  UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", ErroresDeNegocio.CABECERA_FICHERO_NO_VALIDA));
        }
    }
}