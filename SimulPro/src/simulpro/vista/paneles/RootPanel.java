package simulpro.vista.paneles;

import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author Ariel Arnedo
 */
public abstract class RootPanel extends JPanel{

    
    public RootPanel() {
        super();
    }
    
    public RootPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public RootPanel(LayoutManager layout) {
        super(layout);
    }
    
    public RootPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }
    
    protected javax.swing.JTextField createTextField(){
        final javax.swing.JTextField campo = new javax.swing.JTextField();
        campo.setFont(new java.awt.Font("Arial", 0, 17));
        campo.setForeground(new java.awt.Color(102, 102, 102));
        campo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        return campo;
    }
    
    protected javax.swing.JTextField createNumberField(){
        final javax.swing.JTextField campo = createTextField();
        javax.swing.text.Document document = new javax.swing.text.PlainDocument(){
 
            @Override
            public void insertString(int offs, String str, javax.swing.text.AttributeSet a) throws javax.swing.text.BadLocationException {
                char fuente[] = str.toCharArray();
                char resultado[] = new char[fuente.length];
                int j = 0;
                for(int i = 0 ; i < fuente.length ; i++){
                    if(fuente[i] >= '0' && fuente[i] <= '9' || fuente[i] == '.'|| fuente[i] == '-'){
                        resultado[j++] = fuente[i];
                    }
                }
                super.insertString(offs, new String(resultado, 0, j), a);
            }
           
        };
        campo.setDocument(document);
        return campo;
    }
    
//    protected abstract void initValues();
}

