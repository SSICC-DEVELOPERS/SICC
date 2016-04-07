package es.indra.sicc.ped.applet.util;

/**
 * @deprecated Las validaciones son hechas por los editores en
 * {@link es.indra.rector.client.swingview.comun.tabla
 * es.indra.rector.client.swingview.comun.tabla}, por
 * {@link es.indra.rector.client.swingview.comun.JTextRector JTextRector} y/o
 * {@link es.indra.rector.client.controller.RectorDataController#validateData()
 * RectorDataController.validateData()} /
 * {@link es.indra.rector.client.controller.RectorDataController#validateData()
 * RectorController.validateData()}.
 *
 */
public class StringValidation {
    
    private CharacterValidation cVal = null;
    
    public StringValidation() {
        cVal = new CharacterValidation();
    }
    
    public boolean isNull(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isNumeric(String s) {
        if (this.isNull(s)) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( !this.cVal.isNumeric(c) ) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isAlpha(String s) {
        if (this.isNull(s)) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( !this.cVal.isAlpha(c) ) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isAlphaNumeric(String s) {
        if (this.isNull(s)) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( !this.cVal.isAlphaNumeric(c) ) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isLength(String s, int len) {
        if (this.isNull(s)) {
            return false;
        }
        if (s.length() == len) {
            return true;
        }
        return false;
    }
}