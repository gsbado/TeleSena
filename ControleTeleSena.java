/*
 * Gabriela Spanemberg Bado
 * Algoritmos e Programação: Fundamentos
 * 2023/01
 * Essa classe realiza todo o gerenciamento das vendas e sorteios de Tele Senas
 */

public class ControleTeleSena
{
    protected Pessoa[] pessoas; //array com as pessoas que compraram e irão concorrer na TeleSena

    //método construtor
    public ControleTeleSena (int quantidadePessoas) {
        this.pessoas = new Pessoa [quantidadePessoas]; //somente 20 pessoas poderão concorrer segundo as instruções do desafio
    }

    //getters e setters
    public Pessoa[] getPessoas(){
        return pessoas;
    }

    public void setPessoas(Pessoa[] pessoas){
        this.pessoas = pessoas;
    }

    public void criarPessoa(String nome, int quantidadeTeleSenasCompradas, double premioParticipante) {
        Pessoa pessoa = new Pessoa(nome, quantidadeTeleSenasCompradas, premioParticipante);

        for (int i = 0; i < pessoa.unidadesTeleSenasCompradas(); i++) {
            if (pessoas[i] == null) {
                pessoas[i] = pessoa;
                break;
            }
        }
    }

    //método para gerenciar a venda de Tele Senas
    public boolean venderTeleSena (Pessoa pessoa, TeleSena teleSena) {
        //verificação se foram vendidas mais de 300 Tele Senas (que é o total de títulos a serem vendidos)
        if (quantidadeTeleSenasVendidas() >= 300) {
            return false;
        }

        for(int i = 0; i < pessoas.length; i++){
            if (pessoas[i] == null) {
                pessoas[i] = pessoa;
                return pessoa.comprarTeleSena(teleSena);
            }
        }
        return false;
    }

    //método que obtem a quantidade total de Tele Senas vendidas (soma do total de títulos vendidos por pessoa)
    public int quantidadeTeleSenasVendidas() {
        int unidades = 0; //variável iniciada com o valor 0 e que será utilizada para acumular a quantidade das Tele Senas vendidas

        for (int i = 0; i <pessoas.length; i++) {
            if (pessoas[i] != null) {
                unidades += pessoas[i].unidadesTeleSenasCompradas();
            }
        }
        return unidades;
    }

    //método que obtem o valor total de Tele Senas vendidas
    public double valorTotalTSVendidas() {
        int unidades = 0; // variável iniciada com o valor 0 e que será utilizada para acumular a quantidade das Tele Senas vendidas

        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                unidades += pessoas[i].unidadesTeleSenasCompradas();
            }
        }
        return unidades;
    }

    //método com informações sobre os prêmios (80% do valor total das Tele Senas vendidas)
    public double Premios() {
        double valorPremio = valorTotalTSVendidas() * 0.8;
        return valorPremio;
    }

    //método com informações sobre o lucro do Sílvio Santos (20% do valor total das Tele Senas vendidas)
    public double Lucro() {
        double valorLucro = valorTotalTSVendidas() * 0.2;
        return valorLucro;
    }

    //método para realizar o sorteio da Tele Sena
    public boolean Sorteio() {
        int[] numerosSorteados = new int[25]; // array para armazenar os números sorteados
        TeleSena teleSenaPremiada = null; // variável para Tele Sena premiada
        TeleSena teleSena = new TeleSena(); // criação da instância de TeleSena

        boolean pessoaVencedora = false; // variável para ajudar na verificação se um premiado foi encontrado

        // sorteio inicial de 25 números
        for (int i = 0; i < 25; i++) {
            numerosSorteados[i] = teleSena.sortearNumeros(numerosSorteados);
        }

        // loop até que encontre uma Tele Sena premiada. percorre o array "pessoas" e procura se alguma foi premiada
        while (pessoaVencedora == false) {
            for (int g = 0; g < numerosSorteados.length + 1; g++) {
                numerosSorteados = teleSena.adicionarNumero(numerosSorteados, teleSena.sortearNumeros(numerosSorteados));
            }
            for (int k = 0; k < pessoas.length; k++) {
                if (pessoas[k] != null) {
                    TeleSena[] teleSenas = pessoas[k].getTeleSenasCompradas();
                    for (int j = 0; j < teleSenas.length; j++) {
                        if (teleSenas[j] != null && teleSenas[j].verificarPremios(numerosSorteados)) {
                            teleSenaPremiada = teleSenas[j];
                            pessoas[k].temTelePremiadas();
                            pessoaVencedora = true;
                            break;
                        }
                    }
                }

                if (pessoaVencedora == true) {
                    break;
                }
            }

            if (pessoaVencedora == false) {
                int novoNumero = teleSena.sortearNumeros(numerosSorteados);
                numerosSorteados = teleSena.adicionarNumero(numerosSorteados, novoNumero);
            }
        }
        return pessoaVencedora;
    }

    //método que apresenta as informações sobre os ganhadores
    public int Ganhadores() {
        int Ganhadores = 0; //variável iniciada com o valor 0 e que será utilizada para acumular a quantidade de ganhadores da Tele Sena
        for (int i = 0; i <pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].temTelePremiadas()) {
                Ganhadores++;
            }
        } 
        return Ganhadores;
    }

    public double premioPorGanhador() {
        int quantidadeGanhadores = Ganhadores();

        if (quantidadeGanhadores > 0) {
            return Premios() / quantidadeGanhadores;
        } else {
            // caso não haja nenhum ganhador
            System.out.println ("Infelizmente não houve nenhum vencedor"); 
            return 0.0;
        }
    }
}

