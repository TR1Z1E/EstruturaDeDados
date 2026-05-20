public class Medicamento {

    private String nomeMedicamento;
    private String validade;

    public Medicamento(String nomeMedicamento, String validade) {
        this.nomeMedicamento = nomeMedicamento;
        this.validade = validade;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    @Override
    public String toString() {
        return nomeMedicamento + " - Validade: " + validade;
    }
}