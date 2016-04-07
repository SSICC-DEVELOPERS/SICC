/*
 * FrameSimularCambiosVentas.java
 *
 * Created on 28 de febrero de 2005, 16:51
 */
package es.indra.sicc.bel.applet.componentes;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.comunapplet.ConstantesBotones;
import es.indra.sicc.comunapplet.ConstantesBundlesApplet;
import es.indra.sicc.comunapplet.PropertiesApplet;
import java.awt.Color;
import java.awt.Dimension;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
//import es.indra.sicc.ped.applet.componentes.ComboBoxApplet;
//import es.indra.sicc.ped.applet.util.ConstantesApplet;

/**
 *
 * @author  pluna
 */

public class FrameSimularCambiosVentas extends JDialog
{
  private String                    sTitle                              =null;
  private JPanel                    pnSimular                 =new JPanel();
  private JPanel                    pnGrillaSimular        =new JPanel();
  private JScrollPane           spGrillaSimular     =new JScrollPane();
  public TablaSimularCambiosVentas notas     =new TablaSimularCambiosVentas();
  private int                       height;
  private int                       width;
  private int                       hSpace;
  private int                       vSpace;
  private int                       btnheight;
  private int                       btnwidth;

  private JPanel pnBotones = new JPanel();
  private JButton btnVolver = new JButton();
   
   public FrameSimularCambiosVentas( String sTitle) {
        
        this.sTitle = sTitle;
        this.height=500;
        this.width=700;
        try {
          initComponents();
        } catch ( Exception e ) {
          e.printStackTrace();
        }
        setSize( new Dimension( width, height ) );
        setResizable( false );
        getContentPane().setBackground(new Color(242,242,241));
    }
  private void initComponents() throws Exception
  {
      //Dimensions  
        this.hSpace=6;
        this.vSpace=6;
        this.btnheight=20;
        this.btnwidth=75;
        
      //Backgournds
        Color color = new Color(242,242,241);//242,242,241
        pnSimular.setBackground(color);
        getContentPane().setBackground(color);
        
        
        
      //Layouts
        getContentPane().setLayout( null );
        pnSimular.setLayout( null );
        pnGrillaSimular.setLayout( null );
        
      //Borders
        //pnAceptar.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Aceptar"));
        pnGrillaSimular.setBorder( new EtchedBorder() );
        pnSimular.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Simular cambios y ventas Belcenter"));
        
      //atributes
        
        spGrillaSimular.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        spGrillaSimular.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        spGrillaSimular.getViewport().add( notas );

        setTitle( this.sTitle );
        
      //Bounds
        pnSimular.setBounds(this.hSpace, this.vSpace, this.width-2*this.hSpace, this.height-5*this.vSpace);//6, 240, 670, 220
        pnGrillaSimular.setBounds(2*this.hSpace, 3*this.vSpace, this.width-6*this.hSpace, this.height-15*this.vSpace);
        spGrillaSimular.setBounds(0, 0, this.width-6*this.hSpace, this.height-15*this.vSpace);
        
        pnBotones.setLayout(null);
        pnBotones.setBorder(new javax.swing.border.EtchedBorder() );
        pnBotones.setForeground(new java.awt.Color(255, 255, 255));
        
        this.btnVolver.setBackground(new java.awt.Color(5, 123, 162));
        this.btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        //PropertiesApplet.setProperties();
        this.btnVolver.setText(PropertiesApplet.getPropertie(ConstantesBotones.BUTTON_VOLVER, ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE));        
        this.btnVolver.setEnabled(true);
        this.btnVolver.setMnemonic('V');
        this.btnVolver.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              setVisible(false);
            }
          }
        );
        pnBotones.add(this.btnVolver);
        this.btnVolver.setBounds(0,0, 90, 20);
        pnBotones.setBounds(2*this.hSpace, this.height-10*this.vSpace, this.width*this.hSpace , 20);
        
        //Adds
        pnGrillaSimular.add( spGrillaSimular );
        pnSimular.add( pnGrillaSimular );
        pnSimular.add( pnBotones );
        getContentPane().add( pnSimular );
        
        pack();
        
  }
//  public void cargarTabla()
  public void cargarTabla(RecordSet rs){

    //RecordSet rs = new RecordSet();
    String productos = null;
    String unidades=null;
    String monto=null;
    String unidadesCambio=null;
    String unidadesVenta=null;
    
    Object o = null;
/*test de cargarTabla
    rs.addColumn(new String("PRODUCTO"));
    rs.addColumn(new String("UNIDADES"));
    rs.addColumn(new String("MONTO"));
    rs.addColumn(new String("UNIDADES_CAMBIO"));
     rs.addColumn(new String("UNIDADES_VENTA"));
     Vector v = new Vector();
     v.add("1");
     v.add("2");
     v.add("3");
     v.add("4");
     v.add("5");
    rs.addRow(v);  
    rs.addRow(v);  
fin test */
    notas.deleteEmptyRows();
    notas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    String name;
    if(rs != null && !rs.esVacio()){
    
      for(int i = 0; i < rs.getRowCount(); i++){
 //test
  //      String na=rs.getColumnName(i);
//fintest
        productos = (o = rs.getValueAt(i, "PRODUCTO")) != null ? o.toString() : "";
        unidades =  (o = rs.getValueAt(i, "UNIDADES")) != null ? o.toString() : "";
        monto =  (o = rs.getValueAt(i, "MONTO")) != null ? o.toString() : "";
        unidadesCambio =  (o = rs.getValueAt(i, "UNIDADES_CAMBIO")) != null ? o.toString() : "";
        unidadesVenta =  (o = rs.getValueAt(i, "UNIDADES_VENTA")) != null ? o.toString() : "";
        notas.newRow();
        //cargar cols
        notas.colProductos.setText(productos, i);
        notas.colUnidades.setText(unidades, i);
        notas.colMonto.setText(monto, i);
        notas.colUnidadesCambio.setText(unidadesCambio, i);
        notas.colUnidadesVenta.setText(unidadesVenta, i);
      }
    }
  } 
  
  public static void main(String []args) {
    FrameSimularCambiosVentas f = new FrameSimularCambiosVentas("sarasa");
    f.show();
  }
 
}