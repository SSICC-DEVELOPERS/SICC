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
 * 
 * Autor: Emilio Noziglia
 */

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.inc.DTOListaVariablesVentaRanking;
import es.indra.sicc.dtos.inc.DTOVariablesVentaRankingConcurso;
import es.indra.sicc.util.DTOBelcorp; 
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.StringTokenizer;
import java.util.Vector;
 
 	/**
	 * Sistema:	Sicc Belcorp
	 * Modulo:	INC 
	 * Fecha:		17/06/2005
	 * @version	1.0
	 * @autor		enozigli
	 */
public class LPMantenerVariablesCalculoRanking extends LPIncentivosRanking{


   public LPMantenerVariablesCalculoRanking(){
            super();
   }

   public void inicio() throws Exception { }

   public void ejecucion() throws Exception{

            this.setTrazaFichero();
            traza("entra a ejecucion() en LPMantenerVariablesCalculoRanking");

            try{
                //this.rastreo();                

                this.obtenerFlagsPestanyas();
                this.accion = conectorParametroLimpia("accion","",true);
                this.opcionMenu = conectorParametroLimpia("opcionMenu","",true);                
                traza("accion:"+this.accion);

                if ((this.accion == null)||(this.accion.equals(""))){
                        this.cargarPantalla();  
                } else if (this.accion.equals("almacenar")) {
                        this.almacenar();                          
                        this.redirigir();//idPestanyaDest lo toma el metodo redirigir
                } else if (this.accion.equals("redirigir")) {
                        this.redirigir();//idPestanyaDest lo toma el metodo redirigir
                } else if (this.accion.equals("guardar")) {
                        this.almacenar();
                        this.guardar();
                }

            } catch(Exception e){
                traza("Excepcion en LPMantenerVariablesCalculoRanking: " + e.toString());
                traza(e);
                this.lanzarPaginaError(e);
            }
   }

   /**
    * @Autor: Emilio Noziglia
    * @Fecha : 17/06/2005
    * @Recibe: void
    * @Retorna: void 
    * @Descripción: implementacion de metodo de herencia para guardar los datos de pestaña.
    * @Referencia:
    */ 
   public void almacenar() throws Exception{
      traza("entra a almacenar() en LPMantenerVariablesCalculoRanking");

      this.dtoConcurso = this.getConcurso();      
      
      String sdatosObligatorios = conectorParametroLimpia("datosObligatorios","false",true);
      Boolean datosObligatorios = (sdatosObligatorios.equalsIgnoreCase("true"))?new Boolean(true):new Boolean(false);
      
      this.dtoConcurso.setIndObligVariablesVentaRanking(datosObligatorios); 
      
      // Verifica si hay que registros en la base de datos
      opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
      
      if(opcionMenu.equals("Modificar Concurso Ranking") && !datosObligatorios.booleanValue()) {
          this.dtoConcurso.setIndBorradoVariablesVentaRanking(Boolean.TRUE);
      }
      
      Boolean indVarVentaRank = this.dtoConcurso.getIndVariablesVentaRanking();
      
      if ((indVarVentaRank!=null)&&(indVarVentaRank.booleanValue())){
          if (this.dtoConcurso.getVariablesVentaRanking()==null){
            this.dtoConcurso.setVariablesVentaRanking(new DTOListaVariablesVentaRanking());
          }
          this.dtoConcurso.getVariablesVentaRanking().setListaVariables(new ArrayList());
      }
      
      this.dtoConcurso.setIndVariablesVentaRanking(new Boolean(true));
      
      String listado1STR = conectorParametro("listado1STR");
      traza("listado1STR " + listado1STR);
      StringTokenizer stRows = new StringTokenizer(listado1STR, "$");
      int rowCount = stRows.countTokens();
      ArrayList listaVariables = new ArrayList();
      for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
          StringTokenizer stCols = new StringTokenizer(stRows.nextToken(), "|");
          DTOVariablesVentaRankingConcurso dtoVar = new DTOVariablesVentaRankingConcurso();              
          /*0*/if (stCols.hasMoreTokens()) { 
                  Object oidVv = getNull(stCols.nextToken(),new Long(0));
                  traza("oidVv " + oidVv);
                  dtoVar.setOidVariableVenta((oidVv!=null)?(Long)oidVv:null); 
               }
          /*1*/if (stCols.hasMoreTokens()) { 
                  dtoVar.setVariableVenta(stCols.nextToken()); 
                  traza("VariableVenta " + dtoVar.getVariableVenta());
               }
          /*2*/if (stCols.hasMoreTokens()) {
                  String aplicable = stCols.nextToken();
                  traza("aplicable " + aplicable);
                  dtoVar.setAplicable(((aplicable!=null)&&(aplicable.equalsIgnoreCase("SI")))?
                                                new Boolean(true):new Boolean(false)); 
               }
          /*3*/if (stCols.hasMoreTokens()) { 
                  Object peso = getNull(stCols.nextToken(),new Integer(0));
                  traza("peso " + peso);
                  dtoVar.setPeso((peso!=null)?(Integer)peso:null); 
               }
          /*4*/if (stCols.hasMoreTokens()) {
                  Object divisor = getNull(stCols.nextToken(),new Integer(0));
                  traza("divisor " + divisor);
                  dtoVar.setDivisor((divisor!=null)?(Integer)divisor:null);
               }
          /* 
           * el 5 es el peso variable que se calcula con el peso y el divisor por lo tanto no se
           * almancena en el DTOVariablesVentaRankingConcurso, y por lo tanto consumo el token.
           */ 
          /*5*/stCols.nextToken(); 
          /*6*/if (stCols.hasMoreTokens()) { 
                  Object nDc = getNull(stCols.nextToken(),new Integer(0));
                  traza("NumeroDiasCobro " + nDc);
                  dtoVar.setNumeroDiasCobro((nDc!=null)?(Integer)nDc:null); 
               }
          /*7*/if (stCols.hasMoreTokens()) { 
                  Object oid = getNull(stCols.nextToken(),new Long(0));
                  traza("oid " + oid);
                  dtoVar.setOid((oid!=null)?(Long)oid:null); 
               }
          listaVariables.add(dtoVar);
      }
      if (this.dtoConcurso.getVariablesVentaRanking()==null){
         this.dtoConcurso.setVariablesVentaRanking(new DTOListaVariablesVentaRanking());
      }
      this.dtoConcurso.getVariablesVentaRanking().setListaVariables(listaVariables);
      
      this.setConcurso(this.dtoConcurso);
      
      traza("sale de almacenar() en LPMantenerVariablesCalculoRanking");
   }           
   
 /**
  * @Autor: Emilio Noziglia
  * @Fecha : 17/06/2005
  * @Recibe: void
  * @Retorna: void 
  * @Descripción: implementacion de metodo de herencia para carga de la pestaña.
  * @Referencia: 
  */ 
   public void cargarPantalla() throws Exception {
        traza("entra a cargarPantalla() en LPMantenerVariablesCalculoRanking");
        
        this.pagina("contenido_variables_calculo_ranking_mantener");
        this.getFormatosValidaciones();
        this.cargarFlagsPestanyas();
        this.dtoConcurso = this.getConcurso();
        
        //invocacion al subsistema de carga inicial
        DTOBelcorp dtob = new DTOBelcorp();
        if (dtoConcurso!=null){
          dtob.setOidPais(dtoConcurso.getOidPais());
          dtob.setOidIdioma(dtoConcurso.getOidIdioma());
        } else {
          traza("El dtoConcurso esta vacio");
          dtob.setOidPais(UtilidadesSession.getPais(this));
          dtob.setOidIdioma(UtilidadesSession.getIdioma(this));                
        }
        
        ComposerViewElementList lista = new ComposerViewElementList();
        ComposerViewElement comboVariablesVenta = new ComposerViewElement();             
        comboVariablesVenta.setIDBusiness("INCObtenerVariablesVentaRanking");
        comboVariablesVenta.setDTOE(dtob);
             
        lista.addViewElement(comboVariablesVenta);

        ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
        traza("antes del conector.ejecucion");
        conector.ejecucion();
        traza("luego del conector");
        DruidaConector resultados = conector.getConector();
        traza("antes de asignar al COMBO");
        asignar("COMBO","cbVariableVentas",resultados,"INCObtenerVariablesVentaRanking");
        //fin invocacion al subsistema de carga inicial
        
        asignarAtributo("VAR","habilitartxtNumDiasCobro","valor","N");
        
        asignarAtributo("VAR","accion","valor",this.accion!=null?this.accion:"");
        asignarAtributo("VAR","opcionMenu","valor",this.opcionMenu!=null?this.opcionMenu:"");
        
        asignarAtributo("CHECKBOX","ckAplicable","valor",ConstantesINC.IND_INACTIVO.toString());
        asignarAtributo("CTEXTO","txtPeso","valor",ConstantesINC.VALOR_DEFECTO_MANT.toString());
        asignarAtributo("CTEXTO","txtDivisor","valor",ConstantesINC.VALOR_DEFECTO_MANT.toString());
        asignarAtributo("VAR","oidVarVtaRankPorcCobr","valor",ConstantesINC.OID_VAR_VTA_RANKING_PORC_COBR.toString());
        asignarAtributo("VAR","valDefMantenim","valor",ConstantesINC.VALOR_DEFECTO_MANT.toString());
        
        if ((dtoConcurso!=null)
              &&(dtoConcurso.getIndVariablesVentaRanking() != null)
              &&(dtoConcurso.getIndVariablesVentaRanking().booleanValue())) {
            //Se muestran los datos dtoConcurso.variablesVentaRanking.listaVariables en la pantalla                                     
            asignarVariablesVenta(dtoConcurso.getVariablesVentaRanking().getListaVariables(),new String("listado1"));
        }
        
        if ((this.opcionMenu != null)&&(this.opcionMenu.equals("Concultar Concurso Ranking"))){
            asignarAtributo("VAR","habilitarcbVariableVentas","valor","N");
            asignarAtributo("VAR","habilitarckAplicable","valor","N");
            asignarAtributo("VAR","habilitartxtPeso","valor","N");
            asignarAtributo("VAR","habilitartxtDivisor","valor","N");
            asignarAtributo("VAR","habilitartxtNumDiasCobro","valor","N");
            asignarAtributo("VAR","habilitarbtnAnadir","valor","N");
            asignarAtributo("VAR","habilitarbtnEliminar","valor","N");
            this.getConfiguracionMenu("LPMantenerConcursosRanking","Consultar Concurso Ranking");            
        } else if ((this.opcionMenu != null)&&(this.opcionMenu.equals("Crear Concurso Ranking"))){
            this.getConfiguracionMenu("LPMantenerConcursosRanking","Crear Concurso Ranking");
        } else if ((this.opcionMenu != null)&&(this.opcionMenu.equals("Modificar Concurso Ranking"))){
            this.getConfiguracionMenu("LPMantenerConcursosRanking","Modificar Concurso Ranking");
        }        
             if (opcionMenu.equals("Crear Concurso Ranking")){
                asignarAtributoPagina("cod", "0508");  
             }else if (opcionMenu.equals("Consultar Concurso Ranking")){
                asignarAtributoPagina("cod", "0525");
             }else if (opcionMenu.equals("Modificar Concurso Ranking")){
                asignarAtributoPagina("cod", "0524");
             }
        
        traza("sale de cargarPantalla() en LPMantenerVariablesCalculoRanking");
   } 
         
  /**
   * @Autor: Emilio Noziglia
   * @Fecha : 22/06/2005
   * @Recibe: ArrayList arrList, String listado
   * @Retorna: void 
   * @Descripción: metodo que toma un arraylist de DTOVariablesVentaRankingConcurso y lo asigna a
   *               la lista editable de la pantalla con el nombre que se le pase. 
   */ 
    private void asignarVariablesVenta(ArrayList listaVariables, String listado) throws Exception {

        traza("entra al metodo asignarVariablesVenta con listaVariables:"+listaVariables+
                  " listado:"+listado);
        
        RecordSet recordSet = new RecordSet();

        llenarRecordSetVariablesVenta(recordSet);
        
        Iterator itListaVariables = listaVariables.iterator();
        int i = 0;        
        while (itListaVariables.hasNext()){            
            DTOVariablesVentaRankingConcurso dtoVVRC = (DTOVariablesVentaRankingConcurso) itListaVariables.next();            
            
            recordSet.addRow(new Vector());            
            if (dtoVVRC.getOidVariableVenta() != null) recordSet.setValueAt(dtoVVRC.getOidVariableVenta(), i, 0);
            traza("getOidVariableVenta");
            if (dtoVVRC.getVariableVenta() != null) recordSet.setValueAt(dtoVVRC.getVariableVenta() , i, 1);
            
            String apl = ((dtoVVRC.getAplicable()!=null)&&(dtoVVRC.getAplicable().booleanValue()==true))?new String("SI"):new String("NO");
            recordSet.setValueAt(apl, i, 2);
            
            traza("getAplicable");
            if (dtoVVRC.getPeso() != null) recordSet.setValueAt(dtoVVRC.getPeso(), i, 3);
            traza("getPeso");
            if (dtoVVRC.getDivisor() != null) recordSet.setValueAt(dtoVVRC.getDivisor(), i, 4);
            traza("getDivisor");
            if ((dtoVVRC.getDivisor() != null)&&(dtoVVRC.getDivisor().intValue()>0)){
                BigDecimal peso = (dtoVVRC.getPeso()!=null)?new BigDecimal(dtoVVRC.getPeso().intValue()):new BigDecimal(0);
                BigDecimal divisor = new BigDecimal(dtoVVRC.getDivisor().intValue());
                traza("getDivisor peso "+peso+" divisor"+divisor);
                BigDecimal pesoVariable = peso.divide(divisor,2,BigDecimal.ROUND_HALF_DOWN);
                String spesoVariable = pesoVariable.toString();
                traza("getDivisor pesoVariable "+pesoVariable+" spesoVariable.indexOf(.) "+spesoVariable.indexOf("."));
                if (spesoVariable.indexOf(".")!=-1){
                    spesoVariable = spesoVariable.substring(0,spesoVariable.indexOf(".")+3);
                }
                traza("getDivisor spesoVariable "+spesoVariable);
                recordSet.setValueAt(spesoVariable, i, 5);
            }
            traza("pesoVariable");
            if (dtoVVRC.getNumeroDiasCobro() != null) recordSet.setValueAt(dtoVVRC.getNumeroDiasCobro(), i, 6);
            traza("getNumeroDiasCobro");
            if (dtoVVRC.getOid() != null) recordSet.setValueAt(dtoVVRC.getOid() , i, 7);//oidVariableRankingConcurso
            traza("getOid");
            i++;
        }

        asignar("LISTADOA", listado, UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
                                                recordSet.getColumnIdentifiers()), "dtoSalida");
        traza("sale del metodo asignarVariablesVenta");                                                
    }
  /**
   * @Autor: Emilio Noziglia
   * @Fecha : 22/06/2005
   * @Recibe: RecordSet r
   * @Retorna: void 
   * @Descripción: setea las columnas del recordset que sera seteado en la lista editable de la
   *               pantalla
   */ 
    private void llenarRecordSetVariablesVenta(RecordSet r) throws Exception{
        traza("entra a llenarRecordSetVariablesVenta");
        r.addColumn("OID");
        r.addColumn("VAL_DESC");
        r.addColumn("VAL_APL");
        r.addColumn("VAL_PESO");
        r.addColumn("VAL_DIVI");
        r.addColumn("VAL_PESO_VAR");
        r.addColumn("NUM_DIAS_COBR");
        r.addColumn("OID_RANK_CONC");
        traza("sale de llenarRecordSetVariablesVenta");
    }         
         
    private Object getNull(String val, Object obj){
        if (val.equals(" ")){
            try{traza("Valor ---" + val  + "---") ;}catch(Exception e){}
            return null;
        }else{
            if(obj instanceof Double) return new Double(val);
            if(obj instanceof Long) return new Long(val);
            if(obj instanceof Integer) return new Integer(val);            
            if(obj instanceof Float) return new Float(val);            
        }
        return null;
    }
    

}
