/*
 * FrameNotasCreditoPendientes.java
 *
 * Created on 28 de febrero de 2005, 16:51
 */
package es.indra.sicc.bel.applet.componentes;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.comunapplet.ConstantesBotones;
import es.indra.sicc.comunapplet.ConstantesBundlesApplet;
import es.indra.sicc.comunapplet.ConstantesMarcos;
import es.indra.sicc.comunapplet.PropertiesApplet;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
//import es.indra.sicc.ped.applet.componentes.ComboBoxApplet;
//import es.indra.sicc.ped.applet.util.ConstantesApplet;

/**
 *
 * @author  pluna
 */

public class FrameNotasCreditoPendientes extends JDialog
{
  private String                    sTitle                              =null;
  private JPanel                    pnNotas                 =new JPanel();
  private JPanel                    pnGrillaNotas        =new JPanel();
  private JScrollPane           spGrillaNotas     =new JScrollPane();
  public TablaNotasCreditoPendientes notas     =new TablaNotasCreditoPendientes();
  private int                       height;
  private int                       width;
  private int                       hSpace;
  private int                       vSpace;
  private int                       btnheight;
  private int                       btnwidth;
  
  private JPanel pnBotones = new JPanel();
  private JButton btnVolver = new JButton();
   
   public FrameNotasCreditoPendientes( String sTitle) {
        
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
        pnNotas.setBackground(color);
        getContentPane().setBackground(color);
        
        
        
      //Layouts
        getContentPane().setLayout( null );
        pnNotas.setLayout( null );
        pnGrillaNotas.setLayout( null );
        
      //Borders
        //pnAceptar.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Aceptar"));
        pnGrillaNotas.setBorder( new EtchedBorder() );
      
      //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_MARCOS_BUNDLE);
      
/*       pnGrillaNotas.setBorder(new CompoundBorder(new EmptyBorder(
          new Insets(1, 1, 1, 1)), new TitledBorder(
          new EtchedBorder(), PropertiesApplet.getPropertie(ConstantesMarcos.MARCOS_NOTAS_CREDITO_PENDIENTES), 
          TitledBorder.DEFAULT_JUSTIFICATION, //"Datos de detalle"
          TitledBorder.DEFAULT_POSITION, new Font("Dialog", 1, 11), new Color(153, 153, 153))));
  */      
        //pnNotas.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Notas Crédito Pendientes"));
    
       pnNotas.setBorder(new CompoundBorder(new EmptyBorder(
          new Insets(1, 1, 1, 1)), new TitledBorder(
          new EtchedBorder(), PropertiesApplet.getPropertie(ConstantesMarcos.MARCOS_NOTAS_CREDITO_PENDIENTES, ConstantesBundlesApplet.APPLET_MARCOS_BUNDLE), 
          TitledBorder.DEFAULT_JUSTIFICATION, //"Datos de detalle"
          TitledBorder.DEFAULT_POSITION, new Font("Dialog", 1, 11), new Color(153, 153, 153))));
    
        
      //atributes
        
        spGrillaNotas.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        spGrillaNotas.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        spGrillaNotas.getViewport().add( notas );

        setTitle( this.sTitle );

      //Bounds
        pnNotas.setBounds(this.hSpace, this.vSpace, this.width-2*this.hSpace, this.height-5*this.vSpace);//6, 240, 670, 220
        pnGrillaNotas.setBounds(2*this.hSpace, 3*this.vSpace, this.width-6*this.hSpace, this.height-15*this.vSpace);
        spGrillaNotas.setBounds(0, 0, this.width-6*this.hSpace, this.height-15*this.vSpace);

        pnBotones.setLayout(null);
        pnBotones.setBorder(new javax.swing.border.EtchedBorder() );
        pnBotones.setForeground(new java.awt.Color(255, 255, 255));
        
        this.btnVolver.setBackground(new java.awt.Color(5, 123, 162));
        this.btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE);
        this.btnVolver.setText(PropertiesApplet.getPropertie(ConstantesBotones.BUTTON_VOLVER, ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE));        
        this.btnVolver.setMnemonic('V');
        this.btnVolver.setEnabled(true);
        this.btnVolver.addActionListener(        
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              setVisible(false);
            }
          }
        );
        pnBotones.add(this.btnVolver);
        this.btnVolver.setBounds(0,0, 90, 20);
        pnBotones.setBounds(2*this.hSpace, this.height-10*this.vSpace, this.width-6*this.hSpace , 20);
      
        //Adds
        pnGrillaNotas.add( spGrillaNotas );
        pnNotas.add( pnGrillaNotas );
        pnNotas.add( pnBotones );
        getContentPane().add( pnNotas );         

        pack();
        
  }
  public void cargarTabla(RecordSet rs){
    
    String colNConsolidado = null;
    String colFecha=null;
    String colTotalPagar=null;
    String colMoneda=null;
    String colTotalPagarMoneda=null;
    
    Object o = null;

    notas.deleteEmptyRows();
    notas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    if(rs != null && !rs.esVacio()){
      for(int i = 0; i < rs.getRowCount(); i++){
        colNConsolidado = (o = rs.getValueAt(i, "CONSOLIDADO")) != null ? o.toString() : "";
        colFecha =  (o = rs.getValueAt(i, "FECHA")) != null ? o.toString() : "";
        colTotalPagar =  (o = rs.getValueAt(i, "TOTAL_PAGAR")) != null ? o.toString() : "";
        colMoneda =  (o = rs.getValueAt(i, "MONEDA")) != null ? o.toString() : "";
        colTotalPagarMoneda =  (o = rs.getValueAt(i, "TOTAL_PAGAR_DOCUMENTO")) != null ? o.toString() : "";
        notas.newRow();
        //cargar cols
        notas.colNConsolidado.setText(colNConsolidado, i);
        notas.colFecha.setText(colFecha, i);
        notas.colTotalPagar.setText(colTotalPagar, i);
        notas.colMoneda.setText(colMoneda, i);
        notas.colTotalPagarMoneda.setText(colTotalPagarMoneda, i);
      }
    }
  }
  
  public static void main(String []args) {
    FrameNotasCreditoPendientes f = new FrameNotasCreditoPendientes("sarasa");
    f.show();
  }
 
}