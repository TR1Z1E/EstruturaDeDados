import javax.swing.*;
import java.awt.*;

public class MenuGUI {

    static Pilha[][] Caixa = new Pilha[3][3];
    static int capacidadePilha = 5;

    public static void main(String[] args) {

        // Inicializando pilhas
        for (int i = 0; i < Caixa.length; i++) {
            for (int j = 0; j < Caixa[i].length; j++) {
                Caixa[i][j] = new Pilha(capacidadePilha);
            }
        }

        JFrame frame = new JFrame("Sistema de Medicamentos");
        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel painel = new JPanel();
        painel.setBackground(new Color(245, 247, 250));
        painel.setLayout(new GridLayout(5, 1, 15, 15));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titulo = new JLabel("Sistema de Armazenamento", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        JButton btnAdd = new JButton("Adicionar Medicamento");
        JButton btnRemove = new JButton("Remover Medicamento");
        JButton btnView = new JButton("Visualizar Compartimento");
        JButton btnAll = new JButton("Ver todas as caixas");

        JButton[] botoes = {btnAdd, btnRemove, btnView, btnAll};

        for (JButton botao : botoes) {
            botao.setFocusPainted(false);
            botao.setFont(new Font("Arial", Font.PLAIN, 14));
            botao.setBackground(new Color(200, 220, 255));
            botao.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        }

        // 🔥 ADICIONAR
        btnAdd.addActionListener(e -> {

            String[] caixasOp = {"Caixa 1", "Caixa 2", "Caixa 3"};
            String[] compOp = {"Compartimento 1", "Compartimento 2", "Compartimento 3"};

            int indiceCaixa = JOptionPane.showOptionDialog(null, "Escolha a caixa:",
                    "Caixa", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, caixasOp, caixasOp[0]);

            int indiceCompartimento = JOptionPane.showOptionDialog(null, "Escolha o compartimento:",
                    "Compartimento", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, compOp, compOp[0]);

            String nome = JOptionPane.showInputDialog("Nome do medicamento:");
            if (nome == null) return;

            String validade;
            while (true) {
                validade = JOptionPane.showInputDialog("Validade (MM/AAAA):");

                if (validade == null) return;

                if (validade.matches("\\d{2}/\\d{4}")) {
                    break;
                }

                JOptionPane.showMessageDialog(null,
                        "Formato inválido! Use MM/AAAA\nEx: 05/2026",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }

            Medicamento m = new Medicamento(nome, validade);
            Caixa[indiceCaixa][indiceCompartimento].adicionar(m);

            JOptionPane.showMessageDialog(null,
                    "✔ Medicamento adicionado!\n\n" +
                    "📦 Caixa: " + (indiceCaixa + 1) +
                    "\n🗂 Compartimento: " + (indiceCompartimento + 1),
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // 🔥 REMOVER
        btnRemove.addActionListener(e -> {

            String[] caixasOp = {"Caixa 1", "Caixa 2", "Caixa 3"};
            String[] compOp = {"Compartimento 1", "Compartimento 2", "Compartimento 3"};

            int indiceCaixa = JOptionPane.showOptionDialog(null, "Escolha a caixa:",
                    "Caixa", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, caixasOp, caixasOp[0]);

            int indiceCompartimento = JOptionPane.showOptionDialog(null, "Escolha o compartimento:",
                    "Compartimento", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, compOp, compOp[0]);

            Medicamento removido = Caixa[indiceCaixa][indiceCompartimento].remover();

            if (removido != null) {
                JOptionPane.showMessageDialog(null,
                        "Removido:\n" + removido,
                        "Remoção",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Compartimento vazio!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // 🔥 VISUALIZAR
        btnView.addActionListener(e -> {

            String[] caixasOp = {"Caixa 1", "Caixa 2", "Caixa 3"};
            String[] compOp = {"Compartimento 1", "Compartimento 2", "Compartimento 3"};

            int indiceCaixa = JOptionPane.showOptionDialog(null, "Escolha a caixa:",
                    "Caixa", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, caixasOp, caixasOp[0]);

            int indiceCompartimento = JOptionPane.showOptionDialog(null, "Escolha o compartimento:",
                    "Compartimento", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, compOp, compOp[0]);

            String conteudo = Caixa[indiceCaixa][indiceCompartimento].listar();

            JTextArea area = new JTextArea(conteudo);
            area.setEditable(false);

            JScrollPane scroll = new JScrollPane(area);

            JOptionPane.showMessageDialog(null,
                    scroll,
                    "📦 Caixa " + (indiceCaixa + 1),
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // 🔥 VISÃO GERAL EM GRADE
        btnAll.addActionListener(e -> {

            JFrame tela = new JFrame("Visão Geral das Caixas");
            tela.setSize(600, 500);
            tela.setLocationRelativeTo(null);

            JPanel grid = new JPanel(new GridLayout(3, 3, 10, 10));
            grid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            for (int i = 0; i < Caixa.length; i++) {
                for (int j = 0; j < Caixa[i].length; j++) {

                    String tituloCard = "Caixa " + (i + 1) + " - Comp. " + (j + 1);

                    JTextArea area = new JTextArea(Caixa[i][j].listar());
                    area.setEditable(false);

                    JScrollPane scroll = new JScrollPane(area);

                    JPanel card = new JPanel(new BorderLayout());
                    card.setBorder(BorderFactory.createTitledBorder(tituloCard));

                    if (Caixa[i][j].topo == -1) {
                        card.setBackground(new Color(255, 230, 230));
                    } else {
                        card.setBackground(new Color(230, 255, 230));
                    }

                    card.setOpaque(true);
                    card.add(scroll, BorderLayout.CENTER);
                    grid.add(card);
                }
            }

            tela.add(grid);
            tela.setVisible(true);
        });

        painel.add(titulo);
        painel.add(btnAdd);
        painel.add(btnRemove);
        painel.add(btnView);
        painel.add(btnAll);

        frame.add(painel);
        frame.setVisible(true);
    }
}