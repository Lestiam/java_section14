package section165.exercicio.entities;

public class PessoaJuridica extends Pessoa {
    private Integer numeroFuncionario;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionario) {
        super(nome, rendaAnual);
        this.numeroFuncionario = numeroFuncionario;
    }

    public Integer getNumeroFuncionario() {
        return numeroFuncionario;
    }

    public void setNumeroFuncionario(Integer numeroFuncionario) {
        this.numeroFuncionario = numeroFuncionario;
    }

    @Override
    public Double imposto() {
        double aPagar = 0.00;
        if (numeroFuncionario <= 10)
        {
            aPagar = (getRendaAnual() * 0.16);
        }
        else {
            aPagar = (getRendaAnual() * 0.14);
        }
        return aPagar;
    }
}
