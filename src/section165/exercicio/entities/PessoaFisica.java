package section165.exercicio.entities;

public class PessoaFisica extends Pessoa{
    private Double gastoSaude;

    public PessoaFisica() {
        super();
    }
    public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
        super(nome, rendaAnual);
        this.gastoSaude = gastoSaude;
    }

    public Double getGastoSaude() {
        return gastoSaude;
    }

    public void setGastoSaude(Double gastoSaude) {
        this.gastoSaude = gastoSaude;
    }

    @Override
    public Double imposto() {
        //operador ternário: aPagar = (getRendaAnual() >= 20000.00) ? (getRendaAnual() * 0.25) - (gastoSaude * 0.5) : (getRendaAnual() * 0.15) - (gastoSaude * 0.5);
        double aPagar = 0.00;
        if (getRendaAnual() >= 20000.00) {
             aPagar = (getRendaAnual() * 0.25) - (gastoSaude * 0.5);
             //o professor fez assim: aPagar = (getRendaAnual() * 0.25)
        }
        else
        {
             aPagar = (getRendaAnual() * 0.15) - (gastoSaude * 0.5);
            //o professor fez assim: aPagar = (getRendaAnual() * 0.15)
        }
        //e depois ele fez: aPagar -= gastoSaude * 0.5;
        if (aPagar < 0.0) { //se o gasto com saude for muito alto, o imposto pode vir negativo, para isso não ocorrer, eu retorno zero
            return 0.0;
        } else {
            return aPagar;
        }
    }
}
