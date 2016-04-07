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
    // Pulsa sobre el botón btnAdelante 
    // Obtiene el oid del último registro de la página actual 
    System.out.println("btnAdelante_click()");
    System.out.println("pilaPaginado al inicio: " + pilaPaginado);
    
    Long oidUltimo = (Long)pilaPaginado.get(pilaPaginado.size()-1);

    // Se invoca al método de negocio para obtener la siguiente página y obtenemos el oid del último registro para la nueva página 
    oidUltimo = obtenerPagina(oidUltimo);

    // Añade a la pila de paginado el oid del último registro de la lista 
    pilaPaginado.add(oidUltimo);

    System.out.println("pilaPaginado al final: " + pilaPaginado);

    // Configura los botones 
    configurarBotones();    
  }
  
  protected void btnAtras_click() {
    // Pulsa sobre el botón btnAtras 

    // Elimina de la pila de paginado los últimos 2 oids para obtener el oid de la página anterior a la 
    //página deseada. Es decir, si estamos en la página 4 y queremos regresar a la página 3, eliminamos 
    //de la pila el último oid de las páginas 4 y 3 para llamar posteriormente a negocio con el oid de 
    //la página 2 
    System.out.println("btnAtras_click()");
    System.out.println("pilaPaginado antes de remover: " + pilaPaginado);
    
    pilaPaginado.remove(pilaPaginado.size()-1);
    pilaPaginado.remove(pilaPaginado.size()-1);
    
    System.out.println("pilaPaginado luego de remover: " + pilaPaginado);

    // Se invoca al método de negocio para obtener la página anterior pasando el oid del último 
    //registro de la pila 
    Long oidUltimo = (Long)pilaPaginado.get(pilaPaginado.size()-1);
    oidUltimo = obtenerPagina(oidUltimo);

    // Añade a la pila de paginado el oid del último registro de la lista 
    pilaPaginado.add(oidUltimo);
    
    System.out.println("pilaPaginado luego de añadir: " + pilaPaginado);

    // Configura los botones 
    configurarBotones();
  }

  protected void btnInicio_click() {
    // Pulsa sobre el botón btnInicio 
    System.out.println("btnInicio_click()");
    System.out.println("pilaPaginado antes de remover: " + pilaPaginado);
    
    // Elimina de la pila de paginado todos los oids excepto el primero 
    for (int i = 1; i < pilaPaginado.size(); ++i) {
      pilaPaginado.remove(i);
    }
    
    System.out.println("pilaPaginado luego de remover: " + pilaPaginado);
    
    // Se invoca al método de negocio para obtener la página inicial pasando el oid del primer registro (0) 
    Long oidUltimo = obtenerPagina(new Long(0));
    
    // Añade a la pila de paginado el oid del último registro de la lista 
    pilaPaginado.add(oidUltimo);
    
    System.out.println("pilaPaginado luego de añadir: " + pilaPaginado);
    
    // Configura los botones 
    configurarBotones();
  }
  
  private void configurarBotones() {
    // Configura los botones de paginado 
    
    // Si estamos en la primera página, deshabilitamos el botón Atrás 
    if (pilaPaginado.size() <= 2) { 
      this.btnAtras.setEnabled(false); 
    } else {
      this.btnAtras.setEnabled(true); 
    }
    
    // Si estamos en la última página, deshabilitamos el botón Adelante 
    if (pagina == null || pagina.getRowCount() < this.tamPagina.intValue()) { 
      this.btnAdelante.setEnabled(false); 
    } else {
      this.btnAdelante.setEnabled(true); 
    }
  }
  
  protected Long obtenerUltimoRegistroPagina() {
    Long oidUltimo = null;
    
    // Si la página contiene registros, devuelve el oid del último 
    if (pagina != null && pagina.getRowCount() > 0) {
      System.out.println("Toma oidUltimo de pagina");
      // Recupera el valor de la primera columna para la última fila 
      oidUltimo = new Long(((BigDecimal) pagina.getValueAt(pagina.getRowCount()-1, "OID")).longValue());
    } else {
      // Devuelve el último oid de la pila de paginado (correspondiente a la página anterior) 
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

    // Añade el valor 0 
    pilaPaginado.add(new Long(0));

    // Añade el último registro de la página 
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