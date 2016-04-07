/*
    INDRA/CAR/PROY
    $Id: LPModificarCabeceraMF.java,v 1.1 2009/12/03 18:40:21 pecbazalar Exp $
    DESC
	 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * 1° L.P: by Patricio Peralta L.P., B.A., Argentina
*/


//import LPSICCBase;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import java.util.Vector;

//import es.indra.mare.common.mgu.manager.Property;

//import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.pre.DTOECabeceraMF;
//import java.io.*;
//import LPConsultarCabeceraMF;


public class LPModificarCabeceraMF extends LPConsultarCabeceraMF {

    public LPModificarCabeceraMF() {
        super ();
        this.nombreLogica ="LPModificarCabeceraMF";
        this.nombrePagina ="contenido_cabecera_matriz_facturacion_modificar";
        this.tag ="CTEXTO";
    }
  
    public void Guardar() throws Exception {
        traza("* * * Entre a la LPModificarCabeceraMF * * *");
        pagina("salidaGenerica");
        Long oidMatrizSeleccionada = (Long) this.conectorParametroSesion("oidCabeceraMF");
        Long oidMarcaSelec = (Long) conectorParametroSesion("oidMarca");
        Long oidCanalSelec = (Long) conectorParametroSesion("oidCanal");
        Long oidPeriSelec = (Long) conectorParametroSesion("oidPeriodo");
	
	
        DruidaConector conector = null;	
	
        conectorParametro();

        DTOECabeceraMF dtoe = new DTOECabeceraMF();
        MareBusinessID bsId = new MareBusinessID("PREModificarCabeceraMF"); 


        dtoe.setOid(oidMatrizSeleccionada);	
        dtoe.setOidMarca(oidMarcaSelec);
        dtoe.setOidCanal(oidCanalSelec);	
        dtoe.setOidPeriodo(oidPeriSelec);
        dtoe.setNumeroPedidosEstimado(new Long(this.conectorParametroNumero("NumeroPedidosEstimados",this.FORMATO_DEFAULT)));
        //dtoe.setNumeroPedidosEstimado(new Integer(this.conectorParametroLimpia("NumeroPedidosEstimados","0",true)));
        dtoe.setUnidadesEstimadas(new Long(this.conectorParametroNumero("UnidadesEstimadas",this.FORMATO_DEFAULT)));
        //dtoe.setUnidadesEstimadas(new Integer(this.conectorParametroLimpia("UnidadesEstimadas","0",true)));
        dtoe.setClientesEstimados(new Long(this.conectorParametroNumero("ClientesEstimados",this.FORMATO_DEFAULT)));
        //dtoe.setClientesEstimados(new Integer(this.conectorParametroLimpia("ClientesEstimados","0",true)));
        dtoe.setTotalMontoVentaNeta(new Long(this.conectorParametroNumero("ValorEstimado",this.FORMATO_DEFAULT)));
        //dtoe.setTotalMontoVentaNeta(new Integer(this.conectorParametroLimpia("ValorEstimado","0",true)));
        if (conectorParametro("TipoCambio")==null || conectorParametro("TipoCambio").equals(""))
            dtoe.setTipoCambioPromedioPeriodo(null);
        else
            dtoe.setTipoCambioPromedioPeriodo(new Double(conectorParametroNumero("TipoCambio",LPSICCBase.FORMATO_ALTERNATIVA)));
            //dtoe.setTipoCambioPromedioPeriodo(new Double(conectorParametroLimpia("TipoCambio","0",true)));

        Vector params = new Vector();
        params.add(dtoe);
        params.add(bsId);

        traza("contenido de params --- " + params);
	
        traza("* * * Antes de conectar * * *");	
	
        conector = conectar("ConectorGuardarCabeceraMF",params);
	
        traza("* * * Despues de conectar * * *");

        //Para mostrar el mensaje de Exito en la pantalla 
        asignarAtributo("VAR","varExitoModifica","valor","Exito");	
        
        //inc. BELC300011946 
        defaultAction();
    }
	
}
