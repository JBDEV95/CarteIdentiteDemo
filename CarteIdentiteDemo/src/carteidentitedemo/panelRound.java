package carteidentitedemo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author JBDEV95
 */
public class panelRound extends javax.swing.JPanel {

    /**
     * Creates new form panelRound
     */
    /**
     * Taille du trait. il est recommandé de le régler sur 1 pour une meilleure vue
     */
    protected int taille_trait = 1;
    /**
     * Couleur de l'ombre
     */
    protected Color couleur_ombre = Color.black;
    /**
     * Définit s'il laisse tomber l'ombre
     */
    protected boolean tomber_ombre = true;
    /**
     * Définit s'il a une vue de haute qualité
     */
    protected boolean qualite_ombre = true;
    /**
     * Valeurs doubles pour le rayon horizontal et vertical des arcs de coin
     */
    protected Dimension arc_coin = new Dimension(20, 20);
    /**
     * Distance entre la bordure ombrée et la bordure du panneau opaque
     */
    protected int distance_ombre = 6;
    /**
     * Le décalage de l'ombre.
     */
    protected int decalage_ombre = 4;
    /**
     * La valeur de transparence de l'ombre entre ( 0 - 255)
     */
    protected int transparence = 150;

    public panelRound() {
        initComponents();

        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int largeur = getWidth();
        int hauteur = getHeight();
        int distance = this.distance_ombre;
        // recuperer les valeur rgb (rouge, vert, bleu) dans une bouvelle variable + notre transparence
        Color couleur = new Color(couleur_ombre.getRed(),
                couleur_ombre.getGreen(), couleur_ombre.getBlue(), transparence);
        Graphics2D graphics = (Graphics2D) g;

//        Définit l'anticrénelage si Oui.
        if (qualite_ombre) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }

        //Dessine les bordures d'ombre.
        if (tomber_ombre) {
            graphics.setColor(couleur);
            //FillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight)
            //Est une classe
            graphics.fillRoundRect(
                    decalage_ombre,//position x
                    decalage_ombre,// position y
                    largeur - taille_trait - decalage_ombre, // width
                    hauteur - taille_trait - decalage_ombre, // height
                    arc_coin.width, arc_coin.height);// arc Dimension
        } else {
            distance = 1;
        }

        //Dessine le panneau opaque arrondi avec des bordures.
        graphics.setColor(getBackground());
        //FillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight)
        //Est une classe
        graphics.fillRoundRect(0, 0, largeur - distance,
                hauteur - distance, arc_coin.width, arc_coin.height);
        graphics.setColor(getForeground());
        graphics.setStroke(new BasicStroke(taille_trait));
        graphics.drawRoundRect(0, 0, largeur - distance,
                hauteur - distance, arc_coin.width, arc_coin.height);

//        Définit les traits par défaut, c'est mieux.
        graphics.setStroke(new BasicStroke());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
