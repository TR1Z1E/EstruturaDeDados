public class Pilha {
    public Medicamento[] dados;
    public int topo;

    public Pilha(int capacidade) {
        dados = new Medicamento[capacidade];
        topo = -1;
    }

    public void adicionar(Medicamento medicamento) {
        if (topo < dados.length - 1) {
            topo++;
            dados[topo] = medicamento;
            System.out.println("Colocou o medicamento " + medicamento.getNomeMedicamento() + " na pilha.");
        } else {
            System.out.println("A pilha já está cheia, não é possível adicionar mais!");
        }
    }

    public Medicamento remover() {
        if (topo >= 0) {
            Medicamento medicamentoRemovido = dados[topo];
            topo--;
            return medicamentoRemovido;
        } else {
            System.out.println("A pilha está vazia, não é possível remover!");
            return null;
        }
    }

    public void exibir() {
        if (topo >= 0) {
            System.out.println("Conteúdo da pilha:");
            for (int i = topo; i >= 0; i--) {
                System.out.println(dados[i].toString());
            }
        } else {
            System.out.println("A pilha está vazia!");
        }
    }
    public String listar() {
    String resultado = "";

    for (int i = topo; i >= 0; i--) {
        resultado += dados[i].toString() + "\n";
    }

    if (resultado.equals("")) {
        return "Compartimento vazio!";
    }

    return resultado;
}
}
