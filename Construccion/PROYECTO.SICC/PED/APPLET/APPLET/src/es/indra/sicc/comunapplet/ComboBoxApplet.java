package es.indra.sicc.comunapplet;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.text.BadLocationException;
import javax.swing.text.AttributeSet;
import javax.swing.text.JTextComponent;
import javax.swing.text.PlainDocument;

public class ComboBoxApplet extends JComboBox implements ActionListener {
   private List listKey = new List();
   private boolean bCargando;
   private boolean bNoSeleccion;
   private boolean bAction = false;
   private TextFieldApplet txKey = null;

//------------------------------------------------------------------------------
   public ComboBoxApplet() {
      super();
      
      try {
         jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
//------------------------------------------------------------------------------
   private void jbInit () throws Exception {
      this.addActionListener( this );
      this.bNoSeleccion = true;
      this.bCargando    = false;

      JTextComponent editor = ( JTextComponent ) this.getEditor().getEditorComponent();
      editor.setDocument( new ComboAutoSelection( this ) );
   }
//------------------------------------------------------------------------------
// Métodos propios
//------------------------------------------------------------------------------
   public boolean getCargando(){
      return this.bCargando;
   }
//------------------------------------------------------------------------------
   public void setNoSeleccion ( boolean bNoSeleccion ) {
      this.bNoSeleccion = bNoSeleccion;
   }
   public boolean getNoSeleccion () {
      return this.bNoSeleccion;
   }
//------------------------------------------------------------------------------
   public void setNoIndex () {
      this.bAction = false;
      this.setSelectedIndex( -1 );
      this.bAction = true;
   }
//------------------------------------------------------------------------------
   public void setObjectKey ( TextFieldApplet txKey ) {
      txKey.setCombo( this );
      this.txKey = txKey;
   }
   public TextFieldApplet getObjectKey () {
      return this.txKey;
   }
//------------------------------------------------------------------------------
   public int setSelectedIndexByKey ( int key ) {
      return setSelectedIndexByKey ( String.valueOf( key ) );     
   }
   
   public int setSelectedIndexByKey ( String key ) {
      int i;

      for ( i = 0; i < this.listKey.getItemCount(); i++ ) {
         if ( this.listKey.getItem( i ).equals( key ) ) break;
      }
      if ( i < this.getItemCount() ) {
         this.bAction = false;
         this.setSelectedIndex( i );
         this.bAction = true;
         return i;
      } else {
         this.setNoIndex();
         return -1;
      }
   }
   
   public int setSelectedIndexByText ( String key ) {
    int i;

    for(i=0; i<this.getItemCount(); i++){
      if(this.getItemAt(i).equals(key)) break;
    }
    
    if(i<this.getItemCount()){
      this.bAction = false;
      this.setSelectedIndex(i);
      this.bAction = true;
      return i;
    }else{
      this.setNoIndex();
      return -1;
    }
  }
   
   
//------------------------------------------------------------------------------
   public String getKey () {
      if ( this.getItemCount() == 0 || this.getSelectedIndex() < 0 )
         return "";
      else 
         return this.listKey.getItem( this.getSelectedIndex() );
   }
//------------------------------------------------------------------------------
   public void addItem ( int key, Object value ) {
      addItem( String.valueOf( key ), value );
   }

   public void addItem ( String key, Object value ) {
      this.bCargando = true;
      this.bAction   = false;
      this.listKey.add( key );
      addItem( value );
      this.bAction   = true;
      this.bCargando = false;
   }
//------------------------------------------------------------------------------
   public void removeAllItems () {
      super.removeAllItems();
      this.listKey.removeAll();
   }
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
// Manejo de eventos
//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
   public void actionPerformed ( ActionEvent evt ) {
      if ( !isLoading() )
         this.updateRelation();
   }
//------------------------------------------------------------------------------
   public boolean isActionPerformed () {
      return this.bAction;
   }
//------------------------------------------------------------------------------
   public boolean isLoading () {
      return this.bCargando;
   }
//------------------------------------------------------------------------------
   public void updateRelation () {
      if ( txKey == null || this.getCargando() ) return;
      txKey.setText( this.getKey() );
   }
//------------------------------------------------------------------------------
   void this_keyPressed ( KeyEvent e ) {
      if ( e.getKeyCode() == KeyEvent.VK_SPACE ) {
         showPopup();
      } 
   }   
//------------------------------------------------------------------------------
// Inner class que personaliza el Document del JComboBox
//------------------------------------------------------------------------------
   /**
   * Autor:wchere
   * Fecha: 23/11/04
   * Define la selección de items en el combo
   */
   class ComboAutoSelection extends PlainDocument {

      private ComboBoxApplet    combo;
      private ComboBoxModel  model;
      private JTextComponent editor;
      
      private boolean selected     = false;
      private boolean hitBackSpace = false; 
      private boolean hitSpace     = false;
      private boolean hitVkDown    = false;
      private boolean hitBackSpaceOnSelection;
      
   //---------------------------------------------------------------------------
      public ComboAutoSelection ( final ComboBoxApplet combo  ) {
         this.combo  = combo;
         this.model  = combo.getModel();
         this.editor = ( JTextComponent ) combo.getEditor().getEditorComponent();

         combo.addActionListener( new ActionListener () {
            public void actionPerformed ( ActionEvent evt ) {
               if ( !selected ) highlightCompletedText( 0 );
            }
         });
         
         editor.addKeyListener( new KeyAdapter () {
            public void keyPressed ( KeyEvent evt ) {
               if ( combo.isDisplayable() ) {
                  combo.setPopupVisible( true );   
               }
               
               hitBackSpace = false;
               hitSpace     = false;
               hitVkDown    = false;
               switch ( evt.getKeyCode() ) {
                  case KeyEvent.VK_BACK_SPACE: {
                     hitBackSpace = true;
                     hitBackSpaceOnSelection = editor.getSelectionStart() != editor.getSelectionEnd();
                     break;
                  }
                  case KeyEvent.VK_SPACE: {
                     hitSpace = true;
                     showPopup();   
                     break;
                  }
                  case KeyEvent.VK_ENTER: {
                     combo.setPopupVisible( false );
                     break;
                  }
                  case KeyEvent.VK_ALT: {
                     combo.setPopupVisible( false );
                     break;
                  }
                  case KeyEvent.VK_CONTROL: {
                     combo.setPopupVisible( false );
                     break;
                  }
                  case KeyEvent.VK_SHIFT: {
                     combo.setPopupVisible( false );
                     break;
                  }
                  case KeyEvent.VK_DELETE: {
                     evt.consume();
                     combo.getToolkit().beep();
                     break;
                  }
                  case KeyEvent.VK_TAB: {
                     evt.consume();
                     combo.getToolkit().beep();
                     break;
                  }
               }   
            }
         });
         Object selected = combo.getSelectedItem();
         if ( selected != null ) setText( selected.toString() );
         highlightCompletedText( 0 );
      }
   //---------------------------------------------------------------------------
      public void remove ( int offs, int len ) throws BadLocationException {
         if ( selected ) return;
         super.remove( offs, len );
         /*if ( hitBackSpace ) {
            /*if ( offs > 0 ) {
               if ( hitBackSpaceOnSelection ) offs--;
            } else {
               editor.getToolkit().beep();   
            }
            highlightCompletedText ( offs - 1 );
         } else {*/
         //}
      }
   //---------------------------------------------------------------------------
      public void insertString ( int offs, String str, AttributeSet a ) throws BadLocationException {
         //retorna inmediatamente cuando encuentra un item
         if ( selected ) return;
         //inserta el String en el Document
         super.insertString( offs, str, a );
         //observa y selecciona un item semejante
         Object item = lookupItem( getText( 0, getLength() ) );

         if ( item != null ) {
            setSelectedItem( item );
         } else {
            //mantiene el item anterior seleccionado si no hay semejanzas
            item = combo.getSelectedItem();
            offs = offs - str.length();
            if ( str != null && str.length() > 0 && !hitSpace ) {
               combo.getToolkit().beep();   
            }
         }
         
         if ( str != null && str.length() > 0 ) {
            setText( item.toString() );
         } else {
            super.insertString( 0, "", null );
         }
         highlightCompletedText( offs+str.length() );  
      }
   //---------------------------------------------------------------------------
      private void setText ( String text ) {
         try {
            super.remove(0, getLength() );
            super.insertString( 0, text, null );      
         } catch ( BadLocationException e ) {
            throw new RuntimeException ( e.toString() );
         }
      }
   //---------------------------------------------------------------------------
      private void highlightCompletedText ( int start ) {
         editor.setCaretPosition( getLength() );
         editor.moveCaretPosition( start );
      }
   //---------------------------------------------------------------------------
      private Object lookupItem ( String pattern ) {
         Object selectedItem = model.getSelectedItem();
         if ( selectedItem != null && startsWithIgnoreCase( selectedItem.toString(), pattern ) ) {
            return selectedItem;
         } else {
            int sizeList = this.model.getSize();
            for ( int i = 0; i < sizeList; i++ ) {
               Object currentItem = model.getElementAt( i );
               if ( startsWithIgnoreCase( currentItem.toString(), pattern ) ) 
                  return currentItem;
            }   
         }
         //Si ningún item empieza con el pattern, retorna null
         return null;
      }
   //---------------------------------------------------------------------------
      private void setSelectedItem ( Object item ) {
         selected = true;
         this.model.setSelectedItem( item );
         selected = false;
      }
   //---------------------------------------------------------------------------
      private boolean startsWithIgnoreCase ( String str1, String str2 ) {
         return str1.toUpperCase().startsWith( str2.toUpperCase() );
      }
   //---------------------------------------------------------------------------
   }
}