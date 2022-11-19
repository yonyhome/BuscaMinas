package proyectofinal_rodolfotorrescaballero_yonyhoyosmeza;

import java.awt.Color;
import java.util.Random;
import javax.swing.table.DefaultTableModel;
import static proyectofinal_rodolfotorrescaballero_yonyhoyosmeza.ProyectoFinal_RodolfoTorresCaballero_YonyHoyosMeza.ini;
import static proyectofinal_rodolfotorrescaballero_yonyhoyosmeza.ProyectoFinal_RodolfoTorresCaballero_YonyHoyosMeza.recur;

/**
 *
 * @author yonyh
 */
public class Recursivo extends javax.swing.JFrame {

    Random r = new Random();
    int n, m, x, y;

    public Recursivo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        inicio = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Busca minas");
        setName("buscaminas"); // NOI18N
        setPreferredSize(new java.awt.Dimension(782, 503));

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabla2MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabla2);

        inicio.setText("Iniciar");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(inicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(inicio)
                    .addComponent(salir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        inicio.setText("Reinicio");
        n = r.nextInt(40) + 25;
        m = r.nextInt(25) + 20;
        DefaultTableModel tb = (DefaultTableModel) tabla2.getModel();
        tb.setColumnCount(m);
        tb.setRowCount(n);
        tabla2.getTableHeader().setUI(null);
        llenar2(n, m, 0, 0);
        llenar(n, m, r.nextInt(n), r.nextInt(m), 0);
    }//GEN-LAST:event_inicioActionPerformed

    private void tabla2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla2MousePressed
        y = tabla2.getSelectedColumn();
        x = tabla2.getSelectedRow();
    }//GEN-LAST:event_tabla2MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        recur.setVisible(false);
        ini.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabla2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla2MouseReleased
        try {
            if ((tabla2.getValueAt(x, y)).equals("◙")) {
                tabla2.setValueAt("•", x, y);
                explotarxar(x, y, n, m);
            }
        } catch (NullPointerException e) {
        }
    }//GEN-LAST:event_tabla2MouseReleased
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recursivo().setVisible(true);
            }
        });
    }

    void llenar(int n, int m, int i, int j, int c) {
        if (c < 20 * n && c < 20 * m) {
            tabla2.setValueAt("◙", i, j);
            llenar(n, m, r.nextInt(n), r.nextInt(m), c + 1);
        }
    }

    void llenar2(int n, int m, int i, int j) {
        if (i <= n && j < m) {
            if (i == n) {
                i = 0;
                tabla2.setValueAt("•", i, j);
                j++;

            } else {
                tabla2.setValueAt("•", i, j);
            }
            llenar2(n, m, i + 1, j);
        }
    }

    void explotarxar(int x, int y, int n, int m) {

        if (x > 0 && x < n && y > 0 && y < m) {
            if ((tabla2.getValueAt(x - 1, y)).equals("◙")) {
                tabla2.setValueAt("•", x - 1, y);
                explotarxar(x - 1, y, n, m);
            }
        }
        if ((tabla2.getValueAt(x + 1, y)).equals("◙")) {
            tabla2.setValueAt("•", x + 1, y);
            explotarxar(x + 1, y, n, m);
        }
        if ((tabla2.getValueAt(x, y + 1)).equals("◙")) {
            tabla2.setValueAt("•", x, y + 1);
            explotarxar(x, y + 1, n, m);
        }
        if ((tabla2.getValueAt(x, y - 1)).equals("◙")) {
            tabla2.setValueAt("•", x, y - 1);
            explotarxar(x, y - 1, n, m);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton inicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla2;
    // End of variables declaration//GEN-END:variables

}
