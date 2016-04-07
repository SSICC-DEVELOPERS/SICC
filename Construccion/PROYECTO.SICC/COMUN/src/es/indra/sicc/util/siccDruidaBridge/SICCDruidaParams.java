package es.indra.sicc.util.siccDruidaBridge;

import java.util.HashMap;
import java.util.Set;


public class SICCDruidaParams {
   private HashMap mapa = new HashMap();

   public SICCDruidaParams() {
      super();
   }

   public void put(String rowsetId, SICCDruidaParam params) {
      this.mapa.put(rowsetId, params);
   }

   public SICCDruidaParam get(String rowsetId) {
      return (SICCDruidaParam) this.mapa.get(rowsetId);
   }

   public int size() {
      return this.mapa.size();
   }

   public boolean isEmpty() {
      return this.mapa.isEmpty();
   }

   public void clear() {
      this.mapa.clear();
   }

   public boolean contains(String rowsetId) {
      return this.mapa.keySet().contains(rowsetId);
   }
}
