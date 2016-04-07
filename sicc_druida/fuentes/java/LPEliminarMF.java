 /*
 Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 Avda. de Bruselas, 35
 Parque Empresarial Arroyo de la Vega
 28108 Alcobendas, Madrid
 España
 Privado y Confidencial.
 La información contenida en este documento es propiedad de Indra sistemas.
 Para uso exclusivo de empleados autorizados no permitiéndose
 la distribución de este código sin permiso expreso.
*/
//------------------------------------------------------------------------------
/* 
Sistema:             Belcorp - SICC
Modulo:              PRE - Precios
Componente:          LPEliminarMF
Fecha:               09/03/2004
Dcoumentacion:       
Observaciones:
@version             3.0
@author              Hugo Andrés Mansi
*/
//------------------------------------------------------------------------------

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;

import java.util.Vector;
//import es.indra.mare.common.exception.MareException;


public class LPEliminarMF extends LPSICCBase {
    //definicion de variables
    private String accion = null;
    private Long oidCabeceraMF = null;
    private String flag1=null;
    private String flag2=null;
    private String flag3=null;
    private Long idioma = null;
    private Long pais = null;
	
    //Contructor
    public LPEliminarMF() {
        super();
    }

    public void inicio() throws Exception {
	}

    public void ejecucion() throws Exception {
        try{
            rastreo();
            pais = UtilidadesSession.getPais(this);
            idioma = UtilidadesSession.getIdioma(this);
            //Traemos las variables de la pagina
            accion=conectorParametroLimpia("accion","",true);
            flag1= conectorParametroLimpia("flag1","",true);
            flag2= conectorParametroLimpia("flag2","",true);

            traza("FLAG 1: "+ flag1);
            traza("FLAG 2: "+ flag2);

            traza("accion: "+ accion);

            if (accion.equals("")){

                conectorParametroSesion("UltimaLP", "LPEliminarMF");
                conectorAction("LPSeleccionarMF");
                // Modificado por SICC20070322 - Rafael Romero - 25/07/2007
                // Siempre debe elegir una matriz de facturacion para eliminarla
                // No esta en la lista de casos enviados en el cmbio
                conectorActionParametro("accion", "ElegirMatriz");
                // Fin modificado SICC20070322
                conectorActionParametro("nueva", "");
            }
            if (accion.equals("Matriz seleccionada")){
                eliminarMF();
                traza("despues de eliminarMF");
            }
            if (accion.equals("Matriz")){
                pagina("salidaGenerica");
                asignarAtributo("VAR", "ejecutar", "valor", "refrescarMatriz()");
                asignarAtributo("VAR", "ejecutarError", "valor", "mostrarError()");       
                asignarAtributo("VAR","hidOcultarNueva","valor", "SI");
                asignarAtributo("VAR","hidParametro","valor", "");
				traza("entro a Matriz");
                DTOOID dto = new DTOOID();
                oidCabeceraMF = (conectorParametroSesion("oidCabeceraMF") != null)?(Long)conectorParametroSesion("oidCabeceraMF"):null;
                dto.setOid(oidCabeceraMF); 
                dto.setOidPais(pais);
                dto.setOidIdioma(idioma);
                Vector param= new Vector();
                param.add(dto);
                param.add(new MareBusinessID("PREEliminarMF"));
                DruidaConector conector = conectar("ConectorEliminarMF", param);
                this.getRequest().getSession().removeAttribute("oidCabeceraMF");
                this.getRequest().getSession().removeAttribute("descripcionPais");
                this.getRequest().getSession().removeAttribute("descripcionMarca");
                this.getRequest().getSession().removeAttribute("descripcionCanal");
                this.getRequest().getSession().removeAttribute("descripcionPeriodo");
			}    
            if (accion.equals("MatrizYOfertas")){
                pagina("salidaGenerica");
                asignarAtributo("VAR", "ejecutar", "valor", "refrescarMatriz()");
                asignarAtributo("VAR", "ejecutarError", "valor", "mostrarError()");       
                asignarAtributo("VAR","hidOcultarNueva","valor", "SI");
                traza("entro a MatrizYOfertas");
                DTOOID dto = new DTOOID();
                oidCabeceraMF = (conectorParametroSesion("oidCabeceraMF") != null)?(Long)conectorParametroSesion("oidCabeceraMF"):null;
                dto.setOid(oidCabeceraMF); 
                dto.setOidPais(pais);
                dto.setOidIdioma(idioma);
                Vector param= new Vector();
                param.add(dto);
                param.add(new MareBusinessID("PREEliminarMatrizYOfertas"));       
                DruidaConector conector = conectar("ConectorEliminarMF", param);
                this.getRequest().getSession().removeAttribute("oidCabeceraMF");
                this.getRequest().getSession().removeAttribute("descripcionPais");
                this.getRequest().getSession().removeAttribute("descripcionMarca");
                this.getRequest().getSession().removeAttribute("descripcionCanal");
                this.getRequest().getSession().removeAttribute("descripcionPeriodo");
			}

		}catch (Exception ex){
            traza("entro al catch "+ ex);	   
			asignarAtributo("VAR","hidParametro","valor", "X");
            lanzarPaginaError(ex);
        }
    }

    private void eliminarMF()throws Exception{
        conectorAction("LPSeleccionarMF");
        conectorActionParametro("accion", "ElegirMatriz");
        conectorActionParametro("hidParametro", "S");
        conectorActionParametro("nueva", "");               
    }
   
  
}



