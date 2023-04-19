package section165.exercicio.entities;

public abstract class Pessoa { //este conceito é chamado de herança total, significa que eu não vou instanciar um
    // objeto da SuperClasse (pessoa), só vou instanciar os objetos específicos, PessoaFisica e PessoaJuridica
    private String nome;
    private Double rendaAnual;

    public Pessoa() {
    }
    public Pessoa(String nome, Double rendaAnual) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getRendaAnual() {
        return rendaAnual;
    }

    public void setRendaAnual(Double rendaAnual) {
        this.rendaAnual = rendaAnual;
    }

    public abstract Double imposto(); //não faz sentido eu pensar em implementar imposto nesta classe genérica, pois,
                                    // como eu não sei ainda qual a classe específica, eu não sei a regra específica de imspoto
    //por isso, este é um caso de método abstrato, ou seja, não terá implementação aqui

    //IMPORTANTE: Se eu não especificasse aqui que o imposto é um método abstrato, eu não teria condição de colocar todo mundo em uma única lista
    //lá na calsse Program. Eu precisei colocar todo mundo em uma única lista na classe Program para percorrer esta lista de uma vez só, na ordem que foi digitado
    //chamando o pessoa.imposto
}
