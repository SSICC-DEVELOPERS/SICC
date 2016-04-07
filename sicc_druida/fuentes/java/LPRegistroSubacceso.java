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

import LPSICCBase;

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.dtos.seg.DTOColeccionSubaccesos;
import es.indra.sicc.dtos.seg.DTOSubacceso;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.sql.Date;

import java.util.*;
import java.util.Vector;

import es.indra.sicc.dtos.seg.*;
import es.indra.sicc.util.*;

/** 
 * Sistema:           Belcorp
 * Modulo:            SEG 
 * Submódulo:         Seguridad
 * Componente:        LP
 * Fecha:             05/12/2003
 * Observaciones:     Componente construido de acuerdo a SIC-DDIU-SEG-001-200
 *                    y SICC-DMCO-SEG-001-202                
 * @version           1.0
 * @autor             Juan Pablo Bosnjak, Nicolas Rodriguez Minetti
 */


// Definicion de la clase
public class LPRegistroSubacceso extends LPSICCBase {
    private String accion = null;
    private String casoDeUso = null;

    public void inicio(){}
    // Definicion del constructor
    public LPRegistroSubacceso() { super(); }


    // Definicion del metodo abstracto ejecucion
    public void ejecucion() throws Exception {
      
      setTrazaFichero();
      
      try {
        
        accion    = "";
        casoDeUso = "insertar";
  
        conectorAction("LPBuscarSubacceso");
        conectorActionParametro("accion", accion );
        conectorActionParametro("casoDeUso", casoDeUso );
         
      }catch (Exception ex) {
		  this.lanzarPaginaError(ex);
		  /*
          BelcorpError belcorpError = new BelcorpError();
          DTOError dtoError = belcorpError.obtenerError(ex,"ES","ES");
          asignarAtributo("VAR","errCodigo", "valor", "" + dtoError.getCodigoError());
          asignarAtributo("VAR","errDescripcion", "valor", dtoError.getDescripcionError());
		  */
      }    
  }
}
