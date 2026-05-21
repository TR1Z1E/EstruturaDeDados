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
            System.out.println("Colocou o medicamento " + medicamento.getNomeMedicamento() + " na caixa.");
        } else {
            System.out.println("A caixa já está cheia, não é possível adicionar mais!");
        }
    }

    public Medicamento remover() {
        if (topo >= 0) {
            Medicamento medicamentoRemovido = dados[topo];
            topo--;
            return medicamentoRemovido;
        } else {
            System.out.println("A caixa está vazia, não é possível remover!");
            return null;
        }
    }

    public Medicamento removerEspecifico(String nomeMedicamento) {
        if (topo < 0){
            System.out.println("A caixa está vazia, não é possível remover!");
            return null;
        }

        Pilha pilhaTemp = new Pilha(dados.length);
        Medicamento encontrado = null;

        while (this.topo >= 0) {
            Medicamento medicamentoAtual = this.remover();
            if (medicamentoAtual.getNomeMedicamento().equalsIgnoreCase(nomeMedicamento)) {
                encontrado = medicamentoAtual;
                break;
            } else {
                pilhaTemp.adicionar(medicamentoAtual);
            }
        }

        System.out.println("Reorganizando a caixa...");
        while (pilhaTemp.topo >= 0) {
            this.adicionar(pilhaTemp.remover());
        }

        return encontrado;
    }

    public void exibir() {
        if (topo >= 0) {
            System.out.println("Conteúdo da caixa:");
            for (int i = topo; i >= 0; i--) {
                System.out.println(dados[i].toString());
            }
        } else {
            System.out.println("A caixa está vazia!");
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
