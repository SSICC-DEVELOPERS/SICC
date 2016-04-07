package es.indra.sicc.comunapplet;

import es.indra.sicc.comunapplet.dtos.applet.DTOPaginacionClientePesado;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class PaginacionClientePesado extends JDialog {
  
  private Integer tamPagina;
  private ArrayList pilaPaginado;
  private RecordSet pagina;
  protected JButton btnAdelante;
  protected JButton btnAtras;
  protected JButton btnInicio;
  
  protected void jbInit() throws Exception {
    btnAdelante = new JButton();
    btnAdelante.setBackground( new Color(5, 123, 162) );        
    btnAdelante.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              btnAdelante_click();
            }
          }
        );
    btnAdelante.setForeground( new Color (255, 255, 255) );
    btnAdelante.setFont( new Font ( "Dialog", 1, 11 ) );
    btnAdelante.setText( "Adelante" );
    btnAdelante.setMnemonic( KeyEvent.VK_N );
        
    btnAtras = new JButton();
    btnAtras.setBackground( new Color(5, 123, 162) );        
    btnAtras.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              btnAtras_click();
            }
          }
        );
    btnAtras.setForeground( new Color (255, 255, 255) );
    btnAtras.setFont( new Font ( "Dialog", 1, 11 ) );
    btnAtras.setText( "Atras" );
    btnAtras.setMnemonic( KeyEvent.VK_T );
    
    btnInicio = new JButton();
    btnInicio.setBackground( new Color(5, 123, 162) );        
    btnInicio.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              btnInicio_click();
            }
          }
        );
    btnInicio.setForeground( new Color (255, 255, 255) );
    btnInicio.setFont( new Font ( "Dialog", 1, 11 ) );
    btnInicio.setText( "Inicio" );
    btnInicio.setMnemonic( KeyEvent.VK_I );
  }
  
  protected abstract Long obtenerPagina();
  protected abstract Long obtenerPagina(Long oidUltimo);
  
  protected void btnAdelante_click () {
    // Pulsa sobre el bot�n btnAdelante 
    // Obtiene el oid del �ltimo registro de la p�gina actual 
    System.out.println("btnAdelante_click()");
    System.out.println("pilaPaginado al inicio: " + pilaPaginado);
    
    Long oidUltimo = (Long)pilaPaginado.get(pilaPaginado.size()-1);

    // Se invoca al m�todo de negocio para obtener la siguiente p�gina y obtenemos el oid del �ltimo registro para la nueva p�gina 
    oidUltimo = obtenerPagina(oidUltimo);

    // A�ade a la pila de paginado el oid del �ltimo registro de la lista 
    pilaPaginado.add(oidUltimo);

    System.out.println("pilaPaginado al final: " + pilaPaginado);

    // Configura los botones 
    configurarBotones();    
  }
  
  protected void btnAtras_click() {
    // Pulsa sobre el bot�n btnAtras 

    // Elimina de la pila de paginado los �ltimos 2 oids para obtener el oid de la p�gina anterior a la 
    //p�gina deseada. Es decir, si estamos en la p�gina 4 y queremos regresar a la p�gina 3, eliminamos 
    //de la pila el �ltimo oid de las p�ginas 4 y 3 para llamar posteriormente a negocio con el oid de 
    //la p�gina 2 
    System.out.println("btnAtras_click()");
    System.out.println("pilaPaginado antes de remover: " + pilaPaginado);
    
    pilaPaginado.remove(pilaPaginado.size()-1);
    pilaPaginado.remove(pilaPaginado.size()-1);
    
    System.out.println("pilaPaginado luego de remover: " + pilaPaginado);

    // Se invoca al m�todo de negocio para obtener la p�gina anterior pasando el oid del �ltimo 
    //registro de la pila 
    Long oidUltimo = (Long)pilaPaginado.get(pilaPaginado.size()-1);
    oidUltimo = obtenerPagina(oidUltimo);

    // A�ade a la pila de paginado el oid del �ltimo registro de la lista 
    pilaPaginado.add(oidUltimo);
    
    System.out.println("pilaPaginado luego de a�adir: " + pilaPaginado);

    // Configura los botones 
    configurarBotones();
  }

  protected void btnInicio_click() {
    // Pulsa sobre el bot�n btnInicio 
    System.out.println("btnInicio_click()");
    System.out.println("pilaPaginado antes de remover: " + pilaPaginado);
    
    // Elimina de la pila de paginado todos los oids excepto el primero 
    for (int i = 1; i < pilaPaginado.size(); ++i) {
      pilaPaginado.remove(i);
    }
    
    System.out.println("pilaPaginado luego de remover: " + pilaPaginado);
    
    // Se invoca al m�todo de negocio para obtener la p�gina inicial pasando el oid del primer registro (0) 
    Long oidUltimo = obtenerPagina(new Long(0));
    
    // A�ade a la pila de paginado el oid del �ltimo registro de la lista 
    pilaPaginado.add(oidUltimo);
    
    System.out.println("pilaPaginado luego de a�adir: " + pilaPaginado);
    
    // Configura los botones 
    configurarBotones();
  }
  
  private void configurarBotones() {
    // Configura los botones de paginado 
    
    // Si estamos en la primera p�gina, deshabilitamos el bot�n Atr�s 
    if (pilaPaginado.size() <= 2) { 
      this.btnAtras.setEnabled(false); 
    } else {
      this.btnAtras.setEnabled(true); 
    }
    
    // Si estamos en la �ltima p�gina, deshabilitamos el bot�n Adelante 
    if (pagina == null || pagina.getRowCount() < this.tamPagina.intValue()) { 
      this.btnAdelante.setEnabled(false); 
    } else {
      this.btnAdelante.setEnabled(true); 
    }
  }
  
  protected Long obtenerUltimoRegistroPagina() {
    Long oidUltimo = null;
    
    // Si la p�gina contiene registros, devuelve el oid del �ltimo 
    if (pagina != null && pagina.getRowCount() > 0) {
      System.out.println("Toma oidUltimo de pagina");
      // Recupera el valor de la primera columna para la �ltima fila 
      oidUltimo = new Long(((BigDecimal) pagina.getValueAt(pagina.getRowCount()-1, "OID")).longValue());
    } else {
      // Devuelve el �ltimo oid de la pila de paginado (correspondiente a la p�gina anterior) 
      if(pilaPaginado != null && pilaPaginado.size() > 0) { 
        System.out.println("Toma oidUltimo de pilaPaginado");
        oidUltimo = (Long)pilaPaginado.get(pilaPaginado.size() - 1);
      } 
    } 
    
    System.out.println("oidUltimo: " + oidUltimo);
    return oidUltimo;
  }

  protected void inicializar(DTOPaginacionClientePesado dto) {
    // Inicializa la pila de paginado 
    this.pilaPaginado = new ArrayList();
    this.tamPagina = dto.getTamanioPagina();
    if(this.tamPagina == null) {
      this.tamPagina = new Integer(20);
    }

    // A�ade el valor 0 
    pilaPaginado.add(new Long(0));

    // A�ade el �ltimo registro de la p�gina 
    Long oidUltimo = obtenerUltimoRegistroPagina();
    if(oidUltimo != null) {
      pilaPaginado.add(oidUltimo);
    }

    // Configura los botones 
    configurarBotones();
  }
  
  public Integer getTamPagina()
  {
    return tamPagina;
  }

  public void setTamPagina(Integer tamPagina)
  {
    this.tamPagina = tamPagina;
  }

  public ArrayList getPilaPaginado()
  {
    return pilaPaginado;
  }

  public void setPilaPaginado(ArrayList pilaPaginado)
  {
    this.pilaPaginado = pilaPaginado;
  }

  public RecordSet getPagina()
  {
    return pagina;
  }

  public void setPagina(RecordSet pagina)
  {
    this.pagina = pagina;
  }
}