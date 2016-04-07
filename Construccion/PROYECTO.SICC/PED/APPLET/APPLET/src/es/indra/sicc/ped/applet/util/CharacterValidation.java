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
public class CharacterValidation {
    
    public CharacterValidation()
    {}
    
    public boolean isNumeric(char c) {
        if ( !(c > 47 && c < 58)) {
            return false;
        }
        return true;
    }
    
    public boolean isAlpha(char c) {
        if ( !(c > 64 && c < 91 ||	// uppercase letters
        c > 96 && c < 123 ))	// lowercase letters
        {
            return false;
        }
        return true;
    }
    
    public boolean isAlphaNumeric(char c) {
        if (this.isAlpha(c) || this.isNumeric(c)) {
            return true;
        }
        return false;
    }
    
}