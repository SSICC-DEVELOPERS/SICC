package es.indra.sicc.util.siccDruidaBridge;

public class SICCDruidaParam {
   private String fieldNames = "";
   private boolean includeAll = false;

   public SICCDruidaParam() {
      super();
   }

   public SICCDruidaParam(String fieldNames, boolean includeAll) {
      super();
      this.fieldNames = fieldNames;
      this.includeAll = includeAll;
   }

   public boolean getIncludeAll() {
      return this.includeAll;
   }

   public void setIncludeAll(boolean newValue) {
      this.includeAll = newValue;
   }

   public String getFieldNames() {
      return this.fieldNames;
   }

   public void setFieldNames(String newFieldNames) {
      this.fieldNames = newFieldNames;
   }
}
