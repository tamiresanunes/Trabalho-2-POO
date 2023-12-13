package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaInicial {

	private JFrame frmJogoDoTok;
	private JButton[][] btnMatriz;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaginaInicial window = new PaginaInicial();
					window.frmJogoDoTok.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PaginaInicial() {
		initialize();
	}

	private void atualizarMatriz() {
		String[][] matriz = EstadoDoJogo.getMatriz();
		int linhas = matriz.length;
		int colunas = matriz[0].length;

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				btnMatriz[i][j].setText(matriz[i][j]);
			}
		}
	}

	private void initialize() {
		frmJogoDoTok = new JFrame();
		frmJogoDoTok.setTitle("Jogo do TOK");
		frmJogoDoTok.setBounds(100, 100, 600, 600);
		frmJogoDoTok.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJogoDoTok.getContentPane().setLayout(new BorderLayout());

		JMenuBar menuBar = new JMenuBar();
		frmJogoDoTok.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Jogo");
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Reiniciar jogo");
		mntmNewMenuItem.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente reiniciar o jogo?", "Confirmação",
						JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {
					EstadoDoJogo.reiniciarJogo(); // Chama o método para reiniciar o jogo
					atualizarMatriz();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sair");
		mntmNewMenuItem_1.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirma��o",
						JOptionPane.YES_NO_OPTION);

				if (resposta == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_1 = new JMenu("Autores");
		mnNewMenu_1.setFont(new Font("Arial", Font.BOLD, 12));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ver nomes");
		mntmNewMenuItem_2.setFont(new Font("Arial", Font.PLAIN, 12));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Gabriela da Silva Ramires e Tamires Antunes Nunes");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);

		// EstadoDoJogo jogo = new EstadoDoJogo();
		EstadoDoJogo.organizarMatriz();
		String[][] matriz = EstadoDoJogo.getMatriz();
		int linhas = matriz.length;
		int colunas = matriz[0].length;

		btnMatriz = new JButton[linhas][colunas];
		JPanel buttonPanel = new JPanel(new GridLayout(linhas, colunas));

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				btnMatriz[i][j] = new JButton(matriz[i][j]);
				btnMatriz[i][j].setFont(new Font("Arial", Font.PLAIN, 18));
				buttonPanel.add(btnMatriz[i][j]);

				int linha = i;
				int coluna = j;

				btnMatriz[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						EstadoDoJogo.validar(linha, coluna);
						atualizarMatriz();
						EstadoDoJogo.verificarVitoria();

					}
				});
			}
		}

		frmJogoDoTok.getContentPane().add(buttonPanel, BorderLayout.CENTER);
	}
}
