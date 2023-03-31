package arvore;

public class ArvoreAVL {

    public Node no;

    public ArvoreAVL() {
    }

    public ArvoreAVL(Node no) {
        this.no = no;
    }

    public Node getNo() {
        return no;
    }

    public void setNo(Node no) {
        this.no = no;
    }

    // retorna a altura de um nó (ou 0 caso seja null)
    int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // retorna o balanceamento de um nó (ou 0 caso seja null)
    int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }



    // rotação à direita
    public Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // realiza a rotação
        x.right = y;
        y.left = T2;

        // atualiza as alturas dos nós afetados
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // rotação à esquerda
    public Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // realiza a rotação
        y.left = x;
        x.right = T2;

        // atualiza as alturas dos nós afetados
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // inserção de um nó
    public Node insert(Node node, int key) {
        // realiza a inserção normal de um nó de uma BST
        if (node == null)
            return (new Node(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // nó com chave igual já existe na árvore
            return node;

        // atualiza a altura do nó pai
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // calcula o fator de balanceamento
        int balance = getBalance(node);

        // caso de rotação à direita (LL)
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // caso de rotação à esquerda (RR)
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // caso de rotação à esquerda-direita (LR)
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // caso de rotação à direita-esquerda (RL)
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // encontra o nó com a menor chave (ou seja, o mais a esquerda)
    public Node minValueNode(Node node) {
        Node current = node;

        while (current.left != null)
            current = current.left;

        return current;
    }

    // remoção de um nó
    public Node deleteNode(Node no, int key) {
        // realiza a remoção normal de um nó de uma BST
        if (no == null)
            return no;

        if (key < no.key)
            no.left = deleteNode(no.left, key);
        else if (key > no.key)
            no.right = deleteNode(no.right, key);
        else {
            // nó com chave igual encontrada, realiza a remoção
            if ((no.left == null) || (no.right == null)) {
                Node temp = null;
                if (temp == no.left)
                    temp = no.right;
                else
                    temp = no.left;

                // caso de nó folha (sem filhos)
                if (temp == null) {
                    temp = no;
                    no = null;
                } else // caso de nó com um filho
                    no = temp;
            } else {
                // caso de nó com dois filhos, encontra o sucessor
                Node temp = minValueNode(no.right);

                // copia o conteúdo do sucessor para o nó atual
                no.key = temp.key;

                // remove o sucessor
                no.right = deleteNode(no.right, temp.key);
            }
        }

        // caso a árvore possua apenas um nó ou tenha sido completamente removida
        if (no == null)
            return no;

        // atualiza a altura do nó pai
        no.height = 1 + Math.max(height(no.left), height(no.right));

        // calcula o fator de balanceamento
        int balance = getBalance(no);

        // caso de rotação à direita (LL)
        if (balance > 1 && getBalance(no.left) >= 0)
            return rightRotate(no);

        // caso de rotação à esquerda (RR)
        if (balance < -1 && getBalance(no.right) <= 0)
            return leftRotate(no);

        // caso de rotação à esquerda-direita (LR)
        if (balance > 1 && getBalance(no.left) < 0) {
            no.left = leftRotate(no.left);
            return rightRotate(no);
        }

        // caso de rotação à direita-esquerda (RL)
        if (balance < -1 && getBalance(no.right) > 0) {
            no.right = rightRotate(no.right);
            return leftRotate(no);
        }

        return no;
    }

    public void printTree(Node root, int level) {
        System.out.println();
        if (root == null) {
            return;
        }

        printTree(root.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|       ");
            }
            System.out.println("|-------" + root.key);
        } else {
            System.out.println(root.key);
        }

        // Imprime o nó esquerdo, se existir
        if (root.left != null) {
            for (int i = 0; i < level; i++) {
                System.out.print("|       ");
            }
            System.out.println("|");
            printTree(root.left, level + 1);
        }
    }



    // imprime os nós da árvore em ordem crescente
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }



}


