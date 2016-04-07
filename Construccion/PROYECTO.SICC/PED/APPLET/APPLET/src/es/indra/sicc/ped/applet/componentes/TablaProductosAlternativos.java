package es.indra.sicc.ped.applet.componentes;

import java.awt.Color;
import java.awt.event.KeyEvent;
import es.indra.sicc.comunapplet.Columna;
import es.indra.sicc.comunapplet.TablaApplet;

public class TablaProductosAlternativos extends TablaApplet
{
   /*
    * DBLG400000395 - dmorello, 23/02/2006
    * La columna Códigos de venta sigue existiendo pero dejará de mostrarse.
    * Se agregan las columnas:
    *  - Código SAP principal
    *  - Descripción prod. principal
    *  - Código SAP alternativo
    *  - Descripción prod. alternativo
    */
   /*
    * BELC300023145 : DBLG500000661 - 03/07/2006
    * cdos gPineda - se debe mostrar el cod y descripcion del producto prinpal
    * en dos label, y no en las columnas de la lista. 
    */
   public Columna colCodVenta         = new Columna("Códigos de venta");
   //public Columna colVacia            = new Columna("");
   public Columna
//        colCodPrincipal = new Columna("Código SAP principal"),
//        colDesPrincipal = new Columna("Descripción prod. principal"),
        colCodAlternativo = new Columna("Código SAP alternativo"),
        colDesAlternativo = new Columna("Descripción prod. alternativo");
        
   public TablaProductosAlternativos(String nombre) 
   {
      super(nombre);
      try {
         jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
   public TablaProductosAlternativos() {
      super("TablaProductosAlternativos");
      try {
         jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
   private void jbInit() throws Exception {
      setShowGrid( true );
      super.setColorBackground( Color.white );
      
      /*
       * DBLG400000395 - dmorello, 23/02/2006
       * Se setean los atributos de las columnas creadas en el constructor.
       * Se comentan las líneas que corresponden a la columna vacía (ya
       * eliminada) y a la columna Códigos de venta, que no se mostrará.
       */
      
      //colCodVenta.setType( Columna.TYPE_ALFANUMERICO );
      //colCodVenta.setEditable( false );
      //colCodVenta.setWidth( 140 );
      colCodVenta.setVisible(false);
      super.add( colCodVenta );
      
      //colVacia.setType( Columna.TYPE_ALFANUMERICO );
      //colVacia.setEditable( false );
      //colVacia.setWidth( 500 );
      //super.add( colVacia );
      
      // Seteo atributos de columna Código SAP principal
      /* BELC300023145 : DBLG500000661 - cdos gPineda 03/07/2006
      colCodPrincipal.setType( Columna.TYPE_ALFANUMERICO );
      colCodPrincipal.setEditable( false );
      colCodPrincipal.setWidth( 150 );
      super.add(colCodPrincipal);
      */
      
      // Seteo atributos de columna Descripción prod. principal
      /* BELC300023145 : DBLG500000661 - cdos gPineda 03/07/2006
      colDesPrincipal.setType( Columna.TYPE_ALFANUMERICO );
      colDesPrincipal.setEditable( false );
      colDesPrincipal.setWidth( 300 );
      super.add(colDesPrincipal);
      */      
      
      // Seteo atributos de columna Código SAP alternativo
      colCodAlternativo.setType( Columna.TYPE_ALFANUMERICO );
      colCodAlternativo.setEditable( false );
      colCodAlternativo.setWidth( 200 );
      super.add(colCodAlternativo);

      // Seteo atributos de columna Descripción prod. alternativo
      colDesAlternativo.setType( Columna.TYPE_ALFANUMERICO );
      colDesAlternativo.setEditable( false );
      colDesAlternativo.setWidth( 400 );
      super.add(colDesAlternativo);
      
      super.setInsertCapable( false );
      super.setDeleteCapable( false );
      super.init();
   }
//------------------------------------------------------------------------------
   public void this_keyPressed( KeyEvent e ) {
      return;
   }

}