# Trabalho-2-POO
Jogo do TOK

Você deve criar um programa e Java referente a um jogo que representa dois grupos da
componente curricular de Resolução de Problemas (RP) competindo por um TOK (Total
OK, que representa 100% de nota em uma atividade).

O Jogo do TOK é jogado em uma matriz 5 x 5, e cada jogadora controla 5 peças
representando estudantes do seu grupo de RP. Além disso, há uma peça no centro do
tabuleiro que representa o tão desejado TOK. O tabuleiro antes do começo do jogo deve
estar da seguinte forma:

① ① ① ① ①
   TOK
② ② ② ② ②

No exemplo acima, as peças estão sendo representadas por círculos numerados das
jogadoras 1 e 2 e a peça no TOK está representada pelo seu texto, mas você pode usar o tipo
de peça que quiser.

Todas as peças se movem somente em linha reta (horizontalmente e verticalmente), mas elas
devem se mover o máximo de quadrados vazios que puderem até encontrarem um obstáculo
(a borda do tabuleiro, outra peça ou o TOK).
Não existe captura de peças nesse jogo, então nenhuma peça desaparece ao longo da partida.

O esquema do jogo é o seguinte:
1. O jogo começa com a jogadora 2 (das peças de baixo) movendo uma das peças dela.
2. O próximo movimento é da jogadora 1 que move primeiro o TOK (que se
movimenta da mesma forma que as outras peças) e depois uma das peças dela.
3. O movimento seguinte é da jogadora 2 que move primeiro o TOK e depois uma das
peças dela.
4. O jogo segue dessa forma, alternando os turnos das jogadoras: primeiro move o TOK
e depois move uma das peças daquela jogadora em questão.

O objetivo do jogo é mover o TOK para a linha inicial das suas peças (a primeira linha no
caso da jogadora 1 e a última linha no caso da jogadora 2), forçar a oponente a mover o
TOK para a linha inicial de suas peças (toda jogadora é obrigada a mover o TOK na vez
dela) ou bloquear completamente o movimento do TOK na vez da oponente.
Ou seja, a jogadora 1 vence se:
1. Mover o TOK para a primeira linha.
2. Forçar a jogadora 2 a mover o TOK para a primeira linha.
3. Bloquear totalmente o movimento do TOK na vez da jogadora 2.
O contexto de vitória da jogadora 2 é análogo aos itens acima.

O jogo deve impedir movimentos inválidos das jogadoras e detectar automaticamente a
condição de vitória. Uma mensagem deve ser mostrada no final do jogo, indicando a
ganhadora.

Você está livre para fazer a interface gráfica com usuário (GUI) da forma que quiser, mas o
tamanho mínimo da janela é 800 x 600 pixels.
Finalmente, o jogo deve possuir uma barra de menus contendo dois menus diferentes. O
primeiro menu será “jogo” e terá as opções de “reiniciar” e “sair”. A opção de reiniciar volta
o jogo ao estado inicial e pronto para jogar, e a opção de sair termina o programa. O
segundo menu será “autores” e terá apenas a opção de “ver nomes”. A opção de ver nomes
dos autores mostrará (você pode escolher a melhor forma de fazer isso) os nomes das
pessoas autoras do jogo.

