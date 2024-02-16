/*
 * Gabriela Spanemberg Bado
 * Algoritmos e Programação: Fundamentos
 * 2023/01
 * Essa classe é de uma pessoa que compra títulos de Tele Senas
 */

public class Pessoa
{
    protected String nome; //variável com o nome da pessoa que irá comprar a Tele Sena
    protected TeleSena [] TeleSenasCompradas; //array com as Tele Senas que a pessoa possui para concorrer
    protected double premioParticipante; //variável com o valor de premiação recebido pelas Tele Senas premiadas

    public Pessoa (String nome, int quantidadeTeleSenasCompradas, double premioParticipante) {
        this.nome = nome; 
        this.TeleSenasCompradas = new TeleSena [quantidadeTeleSenasCompradas];
        this.premioParticipante = 0.0;
    }

    //getters e setters
    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public TeleSena[] getTeleSenasCompradas(){
        return TeleSenasCompradas;
    }

    public void setTeleSenasCompradas(TeleSena[] TeleSenasCompradas){
        this.TeleSenasCompradas = TeleSenasCompradas;
    }

    public double getPremioParticipante(){
        return premioParticipante;
    }

    public void setPremioParticipante(double premioParticipante){
        this.premioParticipante = premioParticipante;
    }

    //método para comprar Tele Senas
    public boolean comprarTeleSena(TeleSena novoTitulo){
        for(int i = 0; i < TeleSenasCompradas.length; i++){
            if (TeleSenasCompradas[i] == null) {
                TeleSenasCompradas[i] = novoTitulo;
                return true;
            }
        }

        return false;
    }

    //método para verificar a quantidade de Tele Senas compradas pelas pessoas
    public int unidadesTeleSenasCompradas(){
        int quantidade = 0;
        for(int i = 0; i < TeleSenasCompradas.length; i++){
            if (TeleSenasCompradas[i] != null) {
                quantidade++;
            }
        }

        return TeleSenasCompradas.length + quantidade;
    }
    
    //método que apresenta o valor total em dinheiro das Tele Senas compradas pelas pessoas
    public double valorTotalTSCompradas(){
        double valorTotal = 0.0;

        for(int i = 0; i < TeleSenasCompradas.length; i++){
            if (TeleSenasCompradas[i] != null) {
                valorTotal += TeleSenasCompradas[i].getValorTeleSena();
            }
        }

        return valorTotal;
    }
    
    //método para verificar se existe uma Tele Sena premiada
    public boolean temTelePremiadas() {

        for(int i = 0; i < TeleSenasCompradas.length; i++){
            if (TeleSenasCompradas[i] != null) {
                int[] numerosSorteados = TeleSenasCompradas[i].gerarNumerosSorteados();
                if (TeleSenasCompradas[i] != null && TeleSenasCompradas[i].verificarPremios(numerosSorteados)) {
                return true;
                }
            }
        }
        return false;
    }
    
    //método para atualizar o valor do prêmio caso necessário
    public void atualizarPremioParticipante(double valorPremio) {
        this.premioParticipante += valorPremio;
    }
}
