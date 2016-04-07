/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.intsys;
import java.math.BigDecimal;

public interface IAdam {
    
    
        public static final String ADA1_RELLENO_BLANC1  = "rellenoBlanc1";      
        public static final String ADA1_CODIGO_PLANILLA  = "codigoPlanilla";    
        public static final String ADA1_RELLENO_BLANC2  = "rellenoBlanc2";      
        public static final String ADA1_IMPORTE  = "importe";                   
                                                                               
        public static final String ADA2_RELLENO_BLANC1  = "rellenoBlanc1";      
        public static final String ADA2_CODIGO_PLANILLA  = "codigoPlanilla";    
        public static final String ADA2_RELLENO_BLANC2  = "rellenoBlanc2";      
        public static final String ADA2_IMPORTE  = "importe";                   
                                                                               
                                                                               
        public static final String ADA3_RELLENO_BLANC1  = "rellenoBlanc1";      
        public static final String ADA3_CODIGO_PLANILLA  = "codigoPlanilla";    
        public static final String ADA3_RELLENO_BLANC2  = "rellenoBlanc2";      
        public static final String ADA3_IMPORTE = "importe";                    
        
		void ingresarComisionesEIncentivos(Long moduloGenerador, Long oidCliente, BigDecimal importe); 
    }