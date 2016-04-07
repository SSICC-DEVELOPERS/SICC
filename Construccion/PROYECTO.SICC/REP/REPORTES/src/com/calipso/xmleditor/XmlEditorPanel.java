package com.calipso.xmleditor;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;

import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import java.util.Map;
import java.util.Enumeration;
import java.awt.CardLayout;
import java.awt.BorderLayout;

/**
 * Created by IntelliJ IDEA.
 * User: soliveri
 * Date: 26-sep-2003
 * Time: 14:17:16
 * To change this template use Options | File Templates.
 */

public class XmlEditorPanel extends JPanel implements TreeSelectionListener {

  private String name;
  private JPanel pnlMain;
  private CardLayout cardLayout;
  private JTree tree;
  private DefaultTreeModel model;
  private XmlEditorTreeModelNode currentNode;
  private XmlEditorTreeModelNode lastNode;
  private HashMap subPanels;
  private XmlEditorTreeDefinitionNode nodeDefinition;
  private Vector treeNodesHistory;
  private boolean isBlocked;
  private Node domRoot;
  private boolean isJustXml;
  private boolean isOnlyXsd = false;

  public void setOnlyXsd(boolean onlyXsd) {
    this.isOnlyXsd = onlyXsd;
  }

  /**
   * Crea un nuevo panel en base a una definicion
   * @param nodeDefinition
   * @throws XmlEditorException
   */
  public XmlEditorPanel(XmlEditorTreeDefinitionNode nodeDefinition) throws XmlEditorException{
    name = nodeDefinition.getValue();
    isBlocked = false;
    isJustXml = false;
    initialize(nodeDefinition);
  }

  /**
   * Crea un nuevo panel con un modelo y un nodo Root
   * @param model
   * @param domRoot
   */
  public XmlEditorPanel(DefaultTreeModel model, Node domRoot) {
    this.model = model;
    isJustXml = true;
    this.domRoot = domRoot;
    initialize();
  }

  /**
   * Inicializa los paneles. Inicializa el panel con CardLayout
   */
  private void initialize() {
    createCardLayoutPanels();
    setLayout(new BorderLayout());
    JSplitPane splitPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, createCenterPanel(), createSouthPanel());
    splitPanel.setDividerLocation(200);
    splitPanel.setDividerSize(2);
    add(splitPanel, BorderLayout.CENTER);
  }

  /**
   * Crea el panel con CardLayout, genera los subpaneles y llena los datos.
   */
  private void createCardLayoutPanels() {
    cardLayout = new CardLayout();
    pnlMain = new JPanel(cardLayout);
    HashMap subPanels = new HashMap();
    getLeafsFrom(domRoot, subPanels);
    Iterator iterator = subPanels.keySet().iterator();
    while(iterator.hasNext()) {
      String currentKey = iterator.next().toString();
      pnlMain.add(((JPanel)subPanels.get(currentKey)), currentKey);
    }
    this.subPanels = (HashMap) subPanels.clone();
  }

  /**
   * Inicia la creacion recursiva de los subpaneles, en base a los hijos de los nodos.
   * @param node
   * @param subPanels
   */
  private void getLeafsFrom(Node node, HashMap subPanels) {
    if(node.getAttributes().getLength() > 0) {
      subPanels.put(node.getNodeName(), new XmlEditorSubPanel(getAttrsNamesFrom(node)));
      getSubPanelsFrom(node.getChildNodes(), subPanels);
    } else {
      getSubPanelsFrom(node.getChildNodes(), subPanels);
    }
  }

  /**
   * Obtiene los subpaneles en base a una lista de nodos hijos. Se llama recursivamente con los hijos de cada nodo visitado
   * @param children
   * @param subPanels
   */
  private void getSubPanelsFrom(NodeList children, HashMap subPanels) {
    for(int i = 0 ; i < children.getLength(); i++) {
      Node node = children.item(i);
      if(node.getNodeType() == Node.ELEMENT_NODE) {
        if(node.getAttributes().getLength() > 0) {
          subPanels.put(node.getNodeName(), new XmlEditorSubPanel(getAttrsNamesFrom(node)));
        } else {
          subPanels.put(node.getNodeName(), new XmlEditorSubPanel(new Vector()));
          getSubPanelsFrom(node.getChildNodes(), subPanels);
        }
      }
    }
  }

  /**
   * Obtiene los nombres de los atributos de un nodo.
   * @param node
   * @return
   */
  private Vector getAttrsNamesFrom(Node node) {
    Vector vector = new Vector();
    NamedNodeMap attrs = node.getAttributes();
    for(int i = 0 ; i < attrs.getLength() ; i++) {
      Node attr = attrs.item(i);
      vector.add(attr.getNodeName());
    }
    return vector;
  }

  /**
   * Inicializa los paneles, pero basandose en una definicion.
   * @param nodeDefinition
   * @throws XmlEditorException
   */
  private void initialize(XmlEditorTreeDefinitionNode nodeDefinition) throws XmlEditorException{
    this.nodeDefinition = nodeDefinition;
    model = getModelFrom(nodeDefinition);
    createCardLayoutPanels(nodeDefinition);
    setLayout(new BorderLayout());
    JSplitPane splitPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, createCenterPanel(), createSouthPanel());
    splitPanel.setDividerLocation(200);
    splitPanel.setDividerSize(2);
    add(splitPanel, BorderLayout.CENTER);
  }

  /**
   * Obtiene un modelo de arbol en base a un definicion.
   * @param nodeDefinition
   * @return
   */
  private DefaultTreeModel getModelFrom(XmlEditorTreeDefinitionNode nodeDefinition) {
    XmlEditorTreeModelNode node = new XmlEditorTreeModelNode(nodeDefinition.getValue());
    fillTreeModel(nodeDefinition, node);
    return new DefaultTreeModel(node);
  }

  /**
   * Llena un nodo en base a una definicion de nodo. Itera los subnodos llamandose recursivamente para cada uno.
   * @param nodeDefinition
   * @param node
   */
  private void fillTreeModel(XmlEditorTreeDefinitionNode nodeDefinition, XmlEditorTreeModelNode node) {
    Iterator iterator = nodeDefinition.getSubnodes().keySet().iterator();
    while(iterator.hasNext()) {
      XmlEditorTreeDefinitionNode definition = (XmlEditorTreeDefinitionNode) nodeDefinition.getSubnodes().get(iterator.next());
      XmlEditorTreeModelNode newNode = new XmlEditorTreeModelNode(definition.getValue());
      node.add(newNode);
      fillTreeModel(definition, newNode);
    }
  }

  private JPanel createSouthPanel() {
    JPanel pnlSouth = new JPanel(new BorderLayout());
    JScrollPane pane = new JScrollPane(pnlMain);
    pnlSouth.add(pane, BorderLayout.CENTER);
    return pnlSouth;
  }

  /**
   * Crea los paneles CardLayout cuando hay una definicion.
   * @param nodeDefinition
   * @throws XmlEditorException
   */
  private void createCardLayoutPanels(XmlEditorTreeDefinitionNode nodeDefinition) throws XmlEditorException{
    cardLayout = new CardLayout();
    pnlMain = new JPanel(cardLayout);
    HashMap subPanels = new HashMap();
    getLeafsFrom(nodeDefinition, subPanels);
    Iterator iterator = subPanels.keySet().iterator();
    while(iterator.hasNext()) {
      String currentKey = iterator.next().toString();
      pnlMain.add(((JPanel)subPanels.get(currentKey)), currentKey);
    }
    this.subPanels = (HashMap) subPanels.clone();
  }

  /**
   * Obtiene los paneles, en base a una definicion.
   * @param nodeDefinition
   * @param subPanels
   * @throws XmlEditorException
   */
  private void getLeafsFrom(XmlEditorTreeDefinitionNode nodeDefinition, HashMap subPanels) throws XmlEditorException{
    if(nodeDefinition.getItemsKeys().size() > 0) {
      subPanels.put(nodeDefinition.getValue(), new XmlEditorSubPanel(nodeDefinition.getItemsKeys(), nodeDefinition.getItems()));
      getSubPanelsFrom(nodeDefinition.getSubnodes(), subPanels);
    } else {
      getSubPanelsFrom(nodeDefinition.getSubnodes(), subPanels);
    }
  }

  private void getSubPanelsFrom(Map nodes, HashMap subPanels) throws XmlEditorException{
    Iterator iterator = nodes.keySet().iterator();
    while(iterator.hasNext()) {
      XmlEditorTreeDefinitionNode node = (XmlEditorTreeDefinitionNode) nodes.get(iterator.next().toString());
      if(node.getItemsKeys().size() > 0) {
        subPanels.put(node.getValue(), new XmlEditorSubPanel(node.getItemsKeys(), node.getItems()));
        Map newNodes = node.getSubnodes();
        getSubPanelsFrom(newNodes, subPanels);
      } else {
        subPanels.put(node.getValue(), new XmlEditorSubPanel(new Vector(), new HashMap()));
        Map newNodes = node.getSubnodes();
        getSubPanelsFrom(newNodes, subPanels);
      }
    }
  }

  private JPanel createCenterPanel() {
    JPanel centerPanel = new JPanel(new BorderLayout());
    tree = new JTree(model);
    tree.addTreeSelectionListener(this);
    JScrollPane scrollTree  = new JScrollPane(tree);
    centerPanel.add(scrollTree, BorderLayout.CENTER);
    return centerPanel;
  }

  public void valueChanged(TreeSelectionEvent e) {
    currentNode = (XmlEditorTreeModelNode) (e.getPath().getLastPathComponent());
    valueChanged();
  }

  public void valueChanged(){
    getTreeNodesHistory().add(currentNode);
    if(getTreeNodesHistory().size() > 1) {
      lastNode = (XmlEditorTreeModelNode) getTreeNodesHistory().elementAt(getTreeNodesHistory().size() - 2);
    }
    if(/*currentNode.getAttributes().size() != 0 &&*/ currentNode.isLeaf()) {
      leafHasBeenSelected();
    } else if(!currentNode.isLeaf() && currentNode.getChildCount() > 0) {
      folderHasBeenSelected();
    } else {
      cardLayout.show(pnlMain, currentNode.toString());
    }

  }

  /**
   * Realiza las acciones necesarias a realizar cuando se ha seleccionado una carpeta
   */
  private void folderHasBeenSelected() {
    if(!isJustXml) {
      if(lastNode != currentNode) {
        verifyModelNodeChanges(false);
      }
      if(!isBlocked) {
        if(currentNode.getAttributes()!= null //((XmlEditorSubPanel) subPanels.get(currentNode.toString())).getInputComponents().isEmpty()
                      && currentNode != getTreeModel().getRoot()){
          cardLayout.show(pnlMain, currentNode.toString());
        }//else{
         //((XmlEditorSubPanel) subPanels.get(currentNode.toString())).eraseInputFields();
         //}
      }
    } else {
      verifyModelNodeChanges(false);
      ((XmlEditorSubPanel) subPanels.get(currentNode.toString())).eraseInputFields();
      cardLayout.show(pnlMain, currentNode.toString());
    }
  }

  /**
   * Realiza las acciones necesarias a realizar cuando se ha seleccionado una hoja
   */
  private void leafHasBeenSelected() {
    if(!isJustXml) {
      if(lastNode != currentNode) {
        verifyModelNodeChanges(true);
      }
      if(!isBlocked) {
        XmlEditorTreeModelNode parent = (XmlEditorTreeModelNode) currentNode.getParent();
        XmlEditorSubPanel subPanel = null;
        if(parent!=null){
          subPanel = (XmlEditorSubPanel) subPanels.get(parent.toString());
          if(subPanel!=null){
            if(!isOnlyXsd){
              subPanel.fillFrom(currentNode);
              cardLayout.show(pnlMain, parent.toString());
            }
            cardLayout.show(pnlMain, currentNode.toString());
          }
        }
      }
    } else {
      verifyModelNodeChanges(true);
      XmlEditorTreeModelNode parent = (XmlEditorTreeModelNode) currentNode.getParent();
      if(parent!=null){
        XmlEditorSubPanel subPanel = (XmlEditorSubPanel) subPanels.get(parent.toString());
        subPanel.fillFrom(currentNode);
        cardLayout.show(pnlMain, parent.toString());
      }
    }
  }

  /**
   * Verifica que los cambios realizados para un nodo sean correctos.
   * @param isLeaf
   */
  private void verifyModelNodeChanges(boolean isLeaf) {
    if(getTreeNodesHistory().size() > 1) {
      if(isLeaf) {
        verifyModelNodeChangesIfLeaf();
      } else {
        verifyModelNodeChangesIfFolder();
      }
    }
  }

  /**
   * Verifica las modificaciones si se selecciono una carpeta.
   * Realiza el update del modelo.
   */
  private void verifyModelNodeChangesIfFolder() {
    if(currentNode == lastNode.getParent() && lastNode.isLeaf()) {
      XmlEditorSubPanel subPanel = (XmlEditorSubPanel) subPanels.get(currentNode.toString());
      updateModelNodeFrom(subPanel, lastNode);
    } else if(currentNode != lastNode.getParent() && lastNode.isLeaf()) {
      XmlEditorTreeModelNode parent = (XmlEditorTreeModelNode) lastNode.getParent();
      XmlEditorSubPanel subPanel = (XmlEditorSubPanel) subPanels.get(parent.toString());
      updateModelNodeFrom(subPanel, lastNode);
    }
  }

  /**
   * Verifica las modificaciones si se selecciono una hoja.
   * Realiza el update del modelo.
   */
  private void verifyModelNodeChangesIfLeaf() {
    if((lastNode.getParent() == currentNode.getParent()) && lastNode.isLeaf()) {
      XmlEditorTreeModelNode parent = (XmlEditorTreeModelNode) lastNode.getParent();
      if(parent!=null){
        XmlEditorSubPanel subPanel = (XmlEditorSubPanel) subPanels.get(parent.toString());
        updateModelNodeFrom(subPanel, lastNode);
      }
    } else if(lastNode.getParent() != null) {
      if(lastNode.getParent() != currentNode.getParent() && lastNode.isLeaf()) {
        XmlEditorTreeModelNode parent = (XmlEditorTreeModelNode) lastNode.getParent();
        XmlEditorSubPanel subPanel = (XmlEditorSubPanel) subPanels.get(parent.toString());
        updateModelNodeFrom(subPanel, lastNode);
      }
    }
  }

  /**
   * Verifica que no halla ningun error de datos. En ese caso actualiza los datos. Sino, bloquea el modelo.
   * @param subPanel
   * @param node
   */
  private void updateModelNodeFrom(XmlEditorSubPanel subPanel, XmlEditorTreeModelNode node) {
    String id = "";
    if(node.getId() != null){
      id = node.getId();
    }
    if(!isJustXml && !isOnlyXsd) {
      String wrongElement = validateFrom(subPanel, (XmlEditorTreeModelNode) node/*.getParent()*/);
      if(wrongElement != null) {
        JOptionPane.showMessageDialog(this, "Falta completar el campo " + wrongElement);
        isBlocked = true;
        getTreeNodesHistory().removeElementAt(getTreeNodesHistory().size() - 1);
        tree.setSelectionPath(new TreePath(node));
      } else {
        isBlocked = false;
        node.updateAttributesFrom(subPanel);
      }
    } else if(!isOnlyXsd){
      node.updateAttributesFrom(subPanel);
    }
    String newId = "";
    if(node.getId()!=null){
      newId = node.getId();
    }
    if(!id.equalsIgnoreCase(newId)){
      node.setUserObject(newId);
      this.invalidate();
    }
  }

  /**
   * Obtiene el root para una definicion.
   * @param children
   * @return
   */
  private XmlEditorTreeModelNode getRootSpecs(Enumeration children) {
    while(children.hasMoreElements()) {
      XmlEditorTreeModelNode modelNode = (XmlEditorTreeModelNode) children.nextElement();
      if(modelNode.isLeaf()) {
        return modelNode;
      }
    }
    return null;
  }

  /**
   * Borra un nodo del arbol.
   */
  public void deleteNode() {
    if(!isJustXml){
      if(currentNode == getRootSpecs(((XmlEditorTreeModelNode)model.getRoot()).children()) || currentNode == model.getRoot()){
        JOptionPane.showMessageDialog(this, "Debe existir una instancia de " + ((XmlEditorTreeModelNode)model.getRoot()).getUserObject());
        return;
      }
    }
    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
    TreeNode parent = currentNode.getParent();
    if(parent!=null){
      ((XmlEditorSubPanel) subPanels.get(parent.toString())).eraseInputFields();
      model.removeNodeFromParent(currentNode);
    }
    //updateModelNodeFrom(, currentNode);
  }

  /**
   * Agrega un nodo hijo al nodo seleccionado, en base a sus atributos.
   */
  public void addNode() {
    if(!isJustXml) {
      if(currentNode != getRootSpecs(((XmlEditorTreeModelNode)model.getRoot()).children()) && currentNode != model.getRoot()){
      //if(getRootSpecs(((XmlEditorTreeModelNode)model.getRoot()).children()) == null) {
        //XmlEditorSubPanel subPanel = (XmlEditorSubPanel) subPanels.get(currentNode.toString());
        if(subPanels.get(currentNode.toString())==null){
          currentNode = (XmlEditorTreeModelNode)currentNode.getParent();
        }
        XmlEditorSubPanel subPanel = getSubPanelFor(currentNode);
        if(subPanel!=null){
          String wrongElement = validateFrom(subPanel, currentNode);
          if(wrongElement != null) {
            JOptionPane.showMessageDialog(this, "Falta completar el campo " + wrongElement);
          } else {
            updateTreeModel(getId(currentNode), subPanel);
          }
        }
      } else {
        JOptionPane.showMessageDialog(this, "Solo debe existir una instancia de " + ((XmlEditorTreeModelNode)model.getRoot()).getUserObject());
      }
    } else {
      XmlEditorSubPanel subPanel = getSubPanelFor(currentNode);
      if(subPanel!=null){
        updateTreeModel(getId(subPanel), subPanel);
      }
    }
  }

  private String getId(XmlEditorTreeModelNode node) {
    if(subPanels.get(node.toString())!=null){
      return node.toString();
    }else{
      return node.getParent().toString();
    }
  }

  /**
   * Obtiene el subpanel que corresponde a un nodo.
   * @param node
   * @return
   */
  private XmlEditorSubPanel getSubPanelFor(XmlEditorTreeModelNode node) {
    XmlEditorSubPanel subPanel = (XmlEditorSubPanel)subPanels.get(node.toString());
    if(subPanel==null){
      subPanel = (XmlEditorSubPanel)subPanels.get(node.getParent().toString());
    }
    return subPanel;
  }

  private String validateFrom(XmlEditorSubPanel subPanel, XmlEditorTreeModelNode modelNode) {
    //XmlEditorTreeDefinitionNode definition = getNodeDefinitionFrom(nodeDefinition, modelNode);
    //return XmlEditorSubPanelValidator.validateFrom(subPanel, definition);
    XmlEditorTreeModelNode auxModelNode;
    if(subPanels.get(modelNode.toString())==null){
      auxModelNode = (XmlEditorTreeModelNode)modelNode.getParent();
    }else{
      auxModelNode = modelNode;
    }
    XmlEditorTreeDefinitionNode definition = getNodeDefinitionFrom(nodeDefinition, auxModelNode);
    if(definition!=null && !modelNode.toString().equalsIgnoreCase(definition.getValue())){
      return XmlEditorSubPanelValidator.validateFrom(subPanel, definition);
    }
    return null;
  }

  private String getId(XmlEditorSubPanel subPanel) {
    if(subPanel.getInputComponents()!=null && !subPanel.getInputComponents().isEmpty()){
      return ((JTextField)subPanel.getInputComponents().elementAt(0)).getText();
    }else{
      return "";
    }
  }

  /**
   * Realiza el update del modelo despues de agregar un nodo. Crea el subpanel y limpia sus atributos.
   * @param nodeName
   * @param subPanel
   */
  private void updateTreeModel(String nodeName, XmlEditorSubPanel subPanel) {
    XmlEditorTreeModelNode modelNode = new XmlEditorTreeModelNode("New " + nodeName);
    modelNode.addAttributesFrom(subPanel);
    ((XmlEditorSubPanel) subPanels.get(getId(currentNode))).eraseInputFields();
    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
    model.insertNodeInto(modelNode, currentNode, 0);
    int [] selRows = tree.getSelectionRows();
    for(int i = 0 ; i < selRows.length ; i++) {
      tree.expandRow(selRows [i]);
    }
  }

  /**
   * Obtiene la definicion para un nodo, en base a una definicion (si no es la correspondiente buscara recursivamente entre sus hijos)
   * @param definition
   * @param modelNode
   * @return
   */
  private XmlEditorTreeDefinitionNode getNodeDefinitionFrom(XmlEditorTreeDefinitionNode definition, XmlEditorTreeModelNode modelNode) {
    if(definition.getValue().equals(modelNode.toString())) {
      return definition;
    } else {
      return getNodeDefinitionFrom(definition.getSubnodes(), false, modelNode);
    }
  }

  private XmlEditorTreeDefinitionNode getNodeDefinitionFrom(Map subNodes, boolean found, XmlEditorTreeModelNode modelNode) {
    XmlEditorTreeDefinitionNode returnVal = null;
    Iterator iterator = subNodes.keySet().iterator();
    while(iterator.hasNext() && !found) {
      XmlEditorTreeDefinitionNode definition = (XmlEditorTreeDefinitionNode) subNodes.get(iterator.next().toString());
      if(definition.getValue().equals(modelNode.toString())) {
        return definition;
      } else {
        returnVal = getNodeDefinitionFrom(definition.getSubnodes(), found, modelNode);
        if(returnVal != null) {
          found = true;
        }
      }
    }
    return returnVal;
  }

  public DefaultTreeModel getTreeModel() {
      return model;
  }

  public String getName() {
    return name;
  }

  public Map getSubPanels() {
    return subPanels;
  }

  private Vector getTreeNodesHistory() {
    if(treeNodesHistory == null) {
      treeNodesHistory = new Vector();
    }
    return treeNodesHistory;
  }

  public JTree getTree() {
    return tree;
  }

  public XmlEditorTreeDefinitionNode getNodeDefinition() {
    return nodeDefinition;
  }

  /**
   * Colapsa todos los nodos del arbol recursivamente, dejando solo desplegada la raiz.
   */
  public void collapseAllNodes() {
    int j = tree.getRowCount();
    for(int i=0; j==tree.getRowCount() && i<tree.getRowCount(); i++){
      tree.collapseRow(tree.getRowCount()-i);
    }
    if(j!=tree.getRowCount()){
      collapseAllNodes();
    }
  }

  private XmlEditorTreeModelNode getRootNode() {
    XmlEditorTreeModelNode node = currentNode;
    while(node.getParent() != null){
      node = (XmlEditorTreeModelNode)node.getParent();
    }
    return node;
  }

}
