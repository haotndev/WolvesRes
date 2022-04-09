package com.wolvesres.form.nhanvien;

import com.swing.custom.raven.RDialog.ROptionDialog;
import com.wolvesres.dao.NhanVienDAO;
import com.wolvesres.form.FormNhanVien;
import com.wolvesres.helper.XImage;
import com.wolvesres.model.ModelNhanVien;
import com.wolvesres.swing.table.EventActionBlackList;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class BlackListNhanVien extends javax.swing.JDialog {

    public BlackListNhanVien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        txtFindBlackList.setLabelText("Tìm kiếm trong danh sách đen");
        init();
        this.frame = (JFrame) parent;
    }
    private JFrame frame;
    private DefaultTableModel model;
    private boolean isChangeData = false;
    private List<ModelNhanVien> blackList = new ArrayList<ModelNhanVien>();
    private List<ModelNhanVien> listReturn = new ArrayList<ModelNhanVien>();

    FormNhanVien formParent = new FormNhanVien(frame);
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();

    private EventActionBlackList<ModelNhanVien> eventAction = new EventActionBlackList<ModelNhanVien>() {

        @Override
        public void update(ModelNhanVien emp) {
            if (tblBlackList.getSelectedRow() >= 0) {
                if (ROptionDialog.showConfirm(frame, "Xác nhận", "Bạn có chắc muốn đưa nhân viên khỏi danh sách đen không?", ROptionDialog.WARNING, Color.yellow, Color.black)) {
                    // ModelNhanVien emp = blackList.get(tblBlackList.getSelectedRow());
                    isChangeData = true;
                    emp.setTrangThai(true);
                    nhanVienDAO.update(emp, emp.getMaNV());
                    updateToList(emp);
                    addToListReturn(emp);
                    fillToTable();
                }
            }
        }
    };

    public void init() {
        initTable();
        fillToTable();
    }

    public List<ModelNhanVien> getListReturn() {
        return this.listReturn;
    }

    public void loadToBlackList() {
        blackList.clear();
        for (ModelNhanVien emp : formParent.getList()) {
            if (emp.isTrangThai() == false) {
                blackList.add(emp);
            }
        }
    }

    public boolean getIsChangeData() {
        return this.isChangeData;
    }

    public void addToListReturn(ModelNhanVien emp) {
        listReturn.add(emp);
    }

    public void updateToList(ModelNhanVien emp) {
        for (int i = 0; i < formParent.getList().size(); i++) {
            if (formParent.getList().get(i).getMaNV().equals(emp.getMaNV())) {
                formParent.getList().get(i).setTrangThai(true);
            }
        }
    }

    public void initTable() {
        tblBlackList.setOpaque(true);
        tblBlackList.setBackground(new Color(255, 255, 255));
        tblBlackList.setFillsViewportHeight(true);
        tblBlackList.fixTable(jScrollPane1);
        tblBlackList.setFont(new Font("SansSerif", 1, 12));
        model = new DefaultTableModel(new Object[][]{}, new Object[]{"Họ tên", "Giới tính", "Chức vụ", "Số ĐT", "Thao tác"});
        tblBlackList.setModel(model);
        tblBlackList.setColumnAction(4);
        tblBlackList.setActionWhiteList(false);
    }

    public void fillToTable() {
        loadToBlackList();
        model.setRowCount(0);
        for (int i = 0; i < blackList.size(); i++) {
            tblBlackList.addRow(blackList.get(i).toRowTableBlackList(eventAction));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDuaRaKBL = new com.swing.custom.raven.RButton.RButton();
        rRoundPanel1 = new com.swing.custom.raven.RPanel.RRoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBlackList = new com.wolvesres.swing.table.Table();
        txtFindBlackList = new com.swing.custom.raven.RTextField.RTextField();
        rRoundPanel2 = new com.swing.custom.raven.RPanel.RRoundPanel();
        jLabel1 = new javax.swing.JLabel();
        rImageAvatar1 = new com.swing.custom.raven.RImageAvatar.RImageAvatar();
        jLabel2 = new javax.swing.JLabel();
        rRoundPanel3 = new com.swing.custom.raven.RPanel.RRoundPanel();
        btnDong = new com.swing.custom.raven.RButton.RButton();

        btnDuaRaKBL.setBackground(new java.awt.Color(102, 102, 102));
        btnDuaRaKBL.setForeground(new java.awt.Color(255, 255, 255));
        btnDuaRaKBL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/wolvesres/icon/back.png"))); // NOI18N
        btnDuaRaKBL.setText("Đưa ra khỏi danh sách đen");
        btnDuaRaKBL.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnDuaRaKBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuaRaKBLActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Danh sách đen");
        setMaximumSize(new java.awt.Dimension(720, 710));
        setMinimumSize(new java.awt.Dimension(720, 710));

        rRoundPanel1.setBackground(new java.awt.Color(209, 220, 208));
        rRoundPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(209, 220, 208), 2));
        rRoundPanel1.setMaximumSize(new java.awt.Dimension(720, 710));
        rRoundPanel1.setOpaque(true);
        rRoundPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBlackList.setAutoCreateRowSorter(true);
        tblBlackList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblBlackList);

        rRoundPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 720, 490));

        txtFindBlackList.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtFindBlackList.setLabelText("Tìm kiếm nhân viên trong danh sách đen");
        txtFindBlackList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFindBlackListKeyReleased(evt);
            }
        });
        rRoundPanel1.add(txtFindBlackList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 720, -1));

        rRoundPanel2.setBackground(new java.awt.Color(71, 92, 77));
        rRoundPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DANH SÁCH ĐEN");
        rRoundPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, 40));

        rImageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/wolvesres/icon/ThreeWolvesResLogo.png"))); // NOI18N
        rRoundPanel2.add(rImageAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 100, 80));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("WolvesRes");
        rRoundPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, -1, -1));

        rRoundPanel1.add(rRoundPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 120));

        rRoundPanel3.setBackground(new java.awt.Color(71, 92, 77));
        rRoundPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/wolvesres/icon/huy.png"))); // NOI18N
        btnDong.setText("Đóng");
        btnDong.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDongActionPerformed(evt);
            }
        });
        rRoundPanel3.add(btnDong, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 90, -1));

        rRoundPanel1.add(rRoundPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 720, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rRoundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rRoundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDongActionPerformed
        dispose();
    }//GEN-LAST:event_btnDongActionPerformed

    private void btnDuaRaKBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuaRaKBLActionPerformed
        if (tblBlackList.getSelectedRow() >= 0) {
            if (ROptionDialog.showConfirm(frame, "Xác nhận", "Bạn có chắc muốn đưa nhân viên khỏi danh sách đen không?", ROptionDialog.WARNING, Color.yellow, Color.black)) {
                ModelNhanVien emp = blackList.get(tblBlackList.getSelectedRow());
                isChangeData = true;
                emp.setTrangThai(true);
                nhanVienDAO.update(emp, emp.getMaNV());
                updateToList(emp);
                addToListReturn(emp);
                fillToTable();
            }
        }
    }//GEN-LAST:event_btnDuaRaKBLActionPerformed

    private void txtFindBlackListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFindBlackListKeyReleased
        String keyword = txtFindBlackList.getText().trim();
        List<ModelNhanVien> listFind = new ArrayList<>();
        listFind.clear();
        for (int i = 0; i < blackList.size(); i++) {
            if (keyword.trim().length() != 0) {
                if (blackList.get(i).getHoTen().contains(keyword) || blackList.get(i).getEmail().contains(keyword)
                        || blackList.get(i).getSoDT().contains(keyword) || blackList.get(i).getCMND().contains(keyword)) {
                    listFind.add(blackList.get(i));
                    model.setRowCount(0);
                    for (ModelNhanVien emp : listFind) {
                        tblBlackList.addRow(emp.toRowTableBlackList(eventAction));
                    }
                }
            } else {
                fillToTable();
            }
        }
    }//GEN-LAST:event_txtFindBlackListKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BlackListNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlackListNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlackListNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlackListNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BlackListNhanVien dialog = new BlackListNhanVien(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.swing.custom.raven.RButton.RButton btnDong;
    private com.swing.custom.raven.RButton.RButton btnDuaRaKBL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.swing.custom.raven.RImageAvatar.RImageAvatar rImageAvatar1;
    private com.swing.custom.raven.RPanel.RRoundPanel rRoundPanel1;
    private com.swing.custom.raven.RPanel.RRoundPanel rRoundPanel2;
    private com.swing.custom.raven.RPanel.RRoundPanel rRoundPanel3;
    private com.wolvesres.swing.table.Table tblBlackList;
    private com.swing.custom.raven.RTextField.RTextField txtFindBlackList;
    // End of variables declaration//GEN-END:variables
}