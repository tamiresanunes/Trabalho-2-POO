package View;

public class EstadoDoJogo {
	private static String[][] matriz = new String[5][5];
	static boolean jogador1 = false;
	static boolean tok = false;
	static int jogadas = 1;
	static int linhaOrigem = -1;
	static int colunaOrigem = -1;

	// inicia o jogo com as posi  es iniciais
	public static void organizarMatriz() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == 0) {
					matriz[i][j] = "1";
				} else {
					if (i == 4) {
						matriz[i][j] = "2";
					} else if (i == 2 & j == 2) {
						matriz[i][j] = "TOK";
					} else {
						matriz[i][j] = ".";
					}
				}
			}
		}
	}

	public static String[][] getMatriz() {
		return matriz;
	}

	// testa se na posi  o recebida h  o n mero 2
	static void validar(int linhaAtual, int colunaAtual) {
		if (jogadas == 1) {
			if (matriz[linhaAtual][colunaAtual].equals("2")) {
				linhaOrigem = linhaAtual;
				colunaOrigem = colunaAtual;
			} else if (matriz[linhaAtual][colunaAtual].equals(".") && linhaOrigem != -1 
					&& colunaOrigem != -1 && validaJogada(linhaOrigem, colunaOrigem, linhaAtual, colunaAtual)) {
				matriz[linhaAtual][colunaAtual] = "2";
				matriz[linhaOrigem][colunaOrigem] = ".";
				linhaOrigem = -1;
				colunaOrigem = -1;
				jogadas++;
				tok = true;
			}
		}
		alterarVezDoJogador();
		if (jogadas % 2 == 0) {
			if (tok == true) {
				if (matriz[linhaAtual][colunaAtual].equals("TOK")) {
					linhaOrigem = linhaAtual;
					colunaOrigem = colunaAtual;
				} else if (matriz[linhaAtual][colunaAtual].equals(".") && linhaOrigem != -1 
						&& colunaOrigem != -1 && validaJogada(linhaOrigem, colunaOrigem, linhaAtual, colunaAtual)) {
					matriz[linhaAtual][colunaAtual] = "TOK";
					matriz[linhaOrigem][colunaOrigem] = ".";
					linhaOrigem = -1;
					colunaOrigem = -1;
					tok = false;
				}
			}
			if (tok == false) {
				if (matriz[linhaAtual][colunaAtual].equals("1")) {
					linhaOrigem = linhaAtual;
					colunaOrigem = colunaAtual;
				} else if (matriz[linhaAtual][colunaAtual].equals(".") && linhaOrigem != -1 
						&& colunaOrigem != -1 && validaJogada(linhaOrigem, colunaOrigem, linhaAtual, colunaAtual)) {
					matriz[linhaAtual][colunaAtual] = "1";
					matriz[linhaOrigem][colunaOrigem] = ".";
					linhaOrigem = -1;
					colunaOrigem = -1;
					jogadas++;
					tok = true;

				}
			}
		}
		alterarVezDoJogador();
		if (jogadas % 2 == 1) {
			if (tok == true) {
				if (matriz[linhaAtual][colunaAtual].equals("TOK")) {
					linhaOrigem = linhaAtual;
					colunaOrigem = colunaAtual;
				} else if (matriz[linhaAtual][colunaAtual].equals(".") && linhaOrigem != -1
						&& colunaOrigem != -1 && validaJogada(linhaOrigem, colunaOrigem, linhaAtual, colunaAtual)) {
					matriz[linhaAtual][colunaAtual] = "TOK";
					matriz[linhaOrigem][colunaOrigem] = ".";
					linhaOrigem = -1;
					colunaOrigem = -1;
					tok = false;
				}
			}
			if (tok == false) {
				if (matriz[linhaAtual][colunaAtual].equals("2")) {
					linhaOrigem = linhaAtual;
					colunaOrigem = colunaAtual;
				} else if (matriz[linhaAtual][colunaAtual].equals(".") && linhaOrigem != -1
						&& colunaOrigem != -1 && validaJogada(linhaOrigem, colunaOrigem, linhaAtual, colunaAtual)) {
					matriz[linhaAtual][colunaAtual] = "2";
					matriz[linhaOrigem][colunaOrigem] = ".";
					linhaOrigem = -1;
					colunaOrigem = -1;
					jogadas++;
					tok = true;

				}
			}
		}
		alterarVezDoJogador();
	}

	static void alterarVezDoJogador() {
		jogador1 = !jogador1;
	}
	
	private static boolean validaJogada(int linhaOrigem, int colunaOrigem, int linhaAtual, int colunaAtual) {
	    // Movimento na vertical para cima
	    if (colunaOrigem == colunaAtual) {
	    	if(linhaOrigem > linhaAtual) {
		        for (int i = linhaOrigem - 1; i >= linhaAtual; i--) {
		            if (!matriz[i][colunaOrigem].equals(".")) {
		                // Há uma peça no caminho
		                return false;
		            }   
		        }
		        if(linhaAtual - 1 == 0 && matriz[linhaAtual -1][colunaAtual].equals(".")) {
		        	return false;
		        }
		        return true; 
	    	}
	    	if(linhaOrigem < linhaAtual) {
		        for (int i = linhaOrigem +1; i <= linhaAtual; i++) {
		            if (!matriz[i][colunaOrigem].equals(".")) {
		                // Há uma peça no caminho
		                return false;
		            }
		        }
		        if(linhaAtual + 1 == 0 && matriz[linhaAtual +1][colunaAtual].equals(".")) {
		        	return false;
		        }
		        return true; // Movimento na horizontal é válido
	    	}
	    }
	    
	    // Movimento na horizontal
	    if (linhaOrigem == linhaAtual) {
	    	if(colunaOrigem > colunaAtual) {
		        for (int i = colunaOrigem; i < colunaAtual; i--) {
		            if (!matriz[linhaOrigem][i].equals(".")) {
		                // Há uma peça no caminho
		                return false;
		            }
		        }

		        return true; // Movimento na horizontal é válido
	    	}
	    	if(colunaOrigem < colunaAtual) {
		        for (int i = colunaOrigem; i > colunaAtual; i++) {
		            if (!matriz[linhaOrigem][i].equals(".")) {
		                // Há uma peça no caminho
		                return false;
		            }
		        }
		        return true; // Movimento na horizontal é válido
	    	}
	    }

	    return false; // Movimento diagonal não é válido
	}
	
	// Novo método para verificar a condição de vitória
	static boolean verificarVitoria() {
		// Verificar se o TOK alcançou a primeira linha
		for (int i = 0; i < 5; i++) {
			if (matriz[0][i].equals("TOK")) {
				exibirMensagemVitoria("Jogador 1");
				return true;
			} else if (matriz[4][i].equals("TOK")) {
				exibirMensagemVitoria("Jogador 2");
				return true;
			}
		}

		// Verificar se uma jogadora bloqueou totalmente o movimento do TOK na vez da
		// outra jogadora
		if (bloquearMovimentoTOK()) {
			exibirMensagemVitoria(jogador1 ? "Jogador 2" : "Jogador 1");
			return true;
		}

		return false;
		}

		// Método auxiliar para exibir mensagem de vitória
		static void exibirMensagemVitoria(String vencedor) {
			System.out.println("Vitória de " + vencedor + "!");
		}

		// Método auxiliar para verificar se uma jogadora bloqueou totalmente o
		// movimento do TOK
		static boolean bloquearMovimentoTOK() {
			// Obtenha a posição atual do TOK
			int linhaTOK = -1;
			int colunaTOK = -1;

			// Encontre a posição do TOK na matriz
			outerloop: for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (matriz[i][j].equals("TOK")) {
						linhaTOK = i;
						colunaTOK = j;
						break outerloop;
					}
				}
			}

			// Se não encontrou o TOK, algo está errado, retorne false
			if (linhaTOK == -1 || colunaTOK == -1) {
				return false;
			}

			// Verifique se as 4 posições ao redor do TOK estão ocupadas
			boolean acima = linhaTOK > 0 && !matriz[linhaTOK - 1][colunaTOK].equals(".");
			boolean abaixo = linhaTOK < 4 && !matriz[linhaTOK + 1][colunaTOK].equals(".");
			boolean esquerda = colunaTOK > 0 && !matriz[linhaTOK][colunaTOK - 1].equals(".");
			boolean direita = colunaTOK < 4 && !matriz[linhaTOK][colunaTOK + 1].equals(".");
			boolean pertoDaBordaColunaEsquerda = (colunaTOK == 0 && !matriz[linhaTOK][colunaTOK + 1].equals(".") 
					&& (linhaTOK > 0 && !matriz[linhaTOK - 1][colunaTOK].equals(".")) && (linhaTOK < 4 && !matriz[linhaTOK + 1][colunaTOK].equals("."))) ;
			boolean pertoDaBordaColunaDireita = (colunaTOK == 4 && !matriz[linhaTOK][colunaTOK - 1].equals(".") 
					&& (linhaTOK > 0 && !matriz[linhaTOK - 1][colunaTOK].equals(".")) && (linhaTOK < 4 && !matriz[linhaTOK + 1][colunaTOK].equals("."))) ;
			// Se todas as posições ao redor do TOK estão ocupadas, então o movimento está
			// bloqueado
			return (acima && abaixo && esquerda && direita) || pertoDaBordaColunaEsquerda || pertoDaBordaColunaDireita;
		}
		
		public static void reiniciarJogo() {
		    jogador1 = false;
		    tok = false;
		    jogadas = 1;
		    linhaOrigem = -1;
		    colunaOrigem = -1;
		    organizarMatriz();
		}

}
