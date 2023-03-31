package arvore;

import java.util.Scanner;

public class application {
    // método principal para testar as operações da árvore AVL
    public static ArvoreAVL arvore = new ArvoreAVL();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menorNoValue() {
        System.out.println("nó com a menor chave (ou seja, o mais a esquerda)");
        arvore.minValueNode(arvore.no);
        menu();

    }

    private static void ordenarArvore() {
        System.out.println("Impressão em ordem crescente dos nós da árvore AVL construída ");
        arvore.inorder(arvore.no);
        System.out.println();
        menu();

    }

    private static void visualizarArvore() {
        arvore.printTree(arvore.no, 0);
        System.out.println();
        menu();
    }

    private static void alturaNo() {
//        if (arvore.no == null) {
//            System.out.println("Arvore vazia");
//        } else {
//            Scanner input = new Scanner(System.in);
//            System.out.print("Digite o valor do no: ");
//            int valor = input.nextInt();
//            Node no = arvore.buscaNo(arvore.no, valor);
//            int altura = arvore.height(no);
//            System.out.println("Altura do no " + valor + ": " + altura);
//        }
//        menu();
    }



    private static void visualizarBalanceamento() {
        Scanner sc = new Scanner(System.in);
        ArvoreAVL arvore = new ArvoreAVL();
        System.out.println("Balanceamento de arvore: ");
        System.out.println("Entre com o no que deseja saber o balanceamento: ");
        int node = sc.nextInt();
        Node node1 = new Node(node);
        System.out.println("Balanceamento : "+ arvore.getBalance(node1));
        menu();
    }

    private static void excluir() {
        System.out.println("Entre com o no que deseja excluir: ");
        int number = sc.nextInt();
        arvore.deleteNode(arvore.no, number);
        ordenarArvore();
        menu();
        System.out.println();
    }

    public static void insert() {

        System.out.println("Quantos nós serão inseridos: ");
        int qtdNos = sc.nextInt();
        System.out.println("Entre com os " + qtdNos + " nós: ");
        int[] nos = new int[qtdNos];
        for (int i = 0; i < qtdNos; i++) {
            nos[i] = sc.nextInt();
            arvore.no = arvore.insert(arvore.no, nos[i]);
        }
        ordenarArvore();
        System.out.println();
        menu();
    }

    public static void menu() {
        System.out.println();
        System.out.println("Seja Bem vindo ao Progarama de Arvore AVL");
        System.out.println("O que deseja fazer: ");
        System.out.println("(1)Inserir No");
        System.out.println("(2)Excluir No");
        System.out.println("(3)Visualizar Balanceamento");
        System.out.println("(4)Altura de um No");
        System.out.println("(5)Visualizar Arvore");
        System.out.println("(6)Ordenar Arvore:");
        System.out.println("(7)No com menor Valor");
        System.out.println("(0)Sair");
        int op = 0;

        do {
            switch (op) {
                case 1:
                    insert();
                    break;
                case 2:
                    excluir();
                    break;
                case 3:
                    visualizarBalanceamento();
                    break;
                case 4:
                    alturaNo();
                    break;
                case 5:
                    visualizarArvore();
                    break;
                case 6:
                    ordenarArvore();
                    break;
                case 7:
                    menorNoValue();
                    break;
                case 8:
                    return;
            }
            op = sc.nextInt();
        } while (op != 0);
        System.out.println("Programa encerrado!");
    }

}


