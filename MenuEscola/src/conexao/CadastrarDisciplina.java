
package conexao;

import beans.Disciplina;
import beans.Professor;
import dao.DisciplinaDAO;
import dao.ProfessorDAO;
import java.util.List;
import javax.swing.JOptionPane;


public class CadastrarDisciplina extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(CadastrarDisciplina.class.getName());


    public CadastrarDisciplina() {
        initComponents();
        preencherComboProfessores();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCarga = new javax.swing.JLabel();
        lblProfessor = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCarga = new javax.swing.JTextField();
        cmbProfessor = new javax.swing.JComboBox();
        btnLimparForm = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Cadastro de Disciplinas");

        lblNome.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblNome.setText("Nome");

        lblCarga.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblCarga.setText("Carga");

        lblProfessor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblProfessor.setText("Professor");

        btnLimparForm.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLimparForm.setText("Limpar Formulário");
        btnLimparForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparFormActionPerformed(evt);
            }
        });

        btnAdicionar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btnAdicionar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNome)
                                        .addGap(73, 73, 73))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(37, 37, 37)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblProfessor)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLimparForm)
                                    .addComponent(cmbProfessor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblTitulo)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCarga)
                    .addComponent(txtCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProfessor)
                    .addComponent(cmbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLimparForm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnAdicionar)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparFormActionPerformed
        limparFormulario();
    }//GEN-LAST:event_btnLimparFormActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        Professor p = (Professor) cmbProfessor.getSelectedItem();
        
        Disciplina d = new Disciplina();
        d.setNome(txtNome.getText());
        d.setCargaHoraria(Integer.parseInt(txtCarga.getText()));
        d.setProfessorID(p);

        DisciplinaDAO dDAO = new DisciplinaDAO();
        dDAO.inserir(d);
        JOptionPane.showMessageDialog(null, "Disciplina cadastrada!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        limparFormulario();
    }//GEN-LAST:event_btnAdicionarActionPerformed
    
    public void preencherComboProfessores(){
        ProfessorDAO pDAO = new ProfessorDAO();
        List<Professor> listaP = pDAO.getProfessores();
        for(Professor p : listaP){
            cmbProfessor.addItem(p);
        }
    }
    
    public void limparFormulario(){
        txtNome.setText("");
        txtCarga.setText("");
        cmbProfessor.setSelectedItem(0);
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new CadastrarDisciplina().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnLimparForm;
    private javax.swing.JComboBox cmbProfessor;
    private javax.swing.JLabel lblCarga;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblProfessor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCarga;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
