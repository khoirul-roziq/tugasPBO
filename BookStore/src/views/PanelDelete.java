/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import inc.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author asus
 */
public class PanelDelete extends javax.swing.JPanel {
    DefaultTableModel model;
    /**
     * Creates new form PanelDelete
     */
    public PanelDelete() throws SQLException {
        initComponents();
        model = new DefaultTableModel();
        tableBuku.setModel(model);
        
        model.addColumn("ISBN");
        model.addColumn("Judul Buku");
        model.addColumn("Penulis");
        model.addColumn("Penerbit");
        model.addColumn("Tahun Terbit");
        model.addColumn("Tempat Terbit");
        model.addColumn("Harga");
        model.addColumn("Stock Tersedia");
        model.addColumn("Lokasi");
        
        tampilkanTable("SELECT * FROM book");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableBuku = new javax.swing.JTable();
        tfSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bSearch = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bDeleteData = new javax.swing.JLabel();

        setDoubleBuffered(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableBuku.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(tableBuku);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 198, 630, 291));
        add(tfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 113, 382, 31));

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(54, 33, 89));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Delete!");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 34, 152, -1));

        bSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_search_16px.png"))); // NOI18N
        bSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bSearchMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bSearchMousePressed(evt);
            }
        });
        add(bSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 113, 17, 31));

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(54, 33, 89));
        jLabel2.setText("(Masukkan ISBN)");
        jLabel2.setToolTipText("");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 93, -1, -1));

        bDeleteData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bDeleteData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8_delete_file_16px.png"))); // NOI18N
        bDeleteData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bDeleteDataMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bDeleteDataMousePressed(evt);
            }
        });
        add(bDeleteData, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 113, -1, 31));
    }// </editor-fold>//GEN-END:initComponents

    private void bDeleteDataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDeleteDataMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bDeleteDataMousePressed

    private void bSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSearchMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bSearchMousePressed

    private void bDeleteDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDeleteDataMouseClicked
       String isbn = tfSearch.getText();
       
       
        try {
            Database db = new Database();
            if(db.isAvailable(isbn)){
                int konfirmasi = JOptionPane.showOptionDialog(this, 
                "Apa yakin menghapus data dengan ISBN "+isbn+"?", 
                "Hapus", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, null, null);
                if(konfirmasi == JOptionPane.YES_OPTION){
                db.hapusData(isbn);
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                tampilkanTable("SELECT * FROM book");
                }
            }else{
                JOptionPane.showMessageDialog(null, "isbn tidak ditemukan");
            }
            tfSearch.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data gagal dihapus");
        }
    }//GEN-LAST:event_bDeleteDataMouseClicked

    private void bSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bSearchMouseClicked
        String isbn = tfSearch.getText();
        if(isbn.isEmpty()){
            try {
                tampilkanTable("SELECT * FROM book");
            } catch (SQLException ex) {
                Logger.getLogger(PanelDelete.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
            Database db = new Database();
            if(db.isAvailable(isbn)){
            tampilkanTable("SELECT * FROM book WHERE isbn = '"+isbn+"'");
            }else JOptionPane.showMessageDialog(null, "isbn tidak ditemukan");
        } catch (SQLException ex) {
        }
        }
    }//GEN-LAST:event_bSearchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bDeleteData;
    private javax.swing.JLabel bSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBuku;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables

    void tampilkanTable(String query) throws SQLException {
        Database db = new Database();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        ResultSet rs = db.tampilBuku(query);  
        try{
            while(rs.next()){
            Object[] data = new Object[9];
            data[0]=rs.getString("isbn");
            data[1]=rs.getString("judul_buku");
            data[2]=rs.getString("pengarang");
            data[3]=rs.getString("penerbit");
            data[4]=rs.getString("tahun_terbit");
            data[5]=rs.getString("tempat_terbit");
            data[6]=rs.getString("harga");
            data[7]=rs.getString("jumlah_stok");
            data[8]=rs.getString("lokasi_penempatan");
            model.addRow(data);
         }   
        }catch(SQLException e){
            System.out.println("gagal");
        }
    }
}
