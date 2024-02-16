
/*
 * Gabriela Spanemberg Bado
 * Algoritmos e Programação: Fundamentos
 * 2023/01
 * Essa classe possui o método main e chama os métodos das outras classes para que o sistema funcione corretamente e imprima na tela as informações necessárias
 */

public class Principal
{
    public static void main (String[] args) {
        ControleTeleSena controle = new ControleTeleSena(20);
        Pessoa[] pessoas = new Pessoa[20];
        double premioParticipante = controle.premioPorGanhador();

        TeleSena novoTitulo = new TeleSena(); //crie uma instância de TeleSena para comprar

        pessoas[1] = new Pessoa("Rodolfo", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[2] = new Pessoa("Beatriz", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[3] = new Pessoa("Helena", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[4] = new Pessoa("Santiago", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[5] = new Pessoa("Madalena", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[6] = new Pessoa("Adeobaldo", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[7] = new Pessoa("Louise", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[8] = new Pessoa("Afonso", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[9] = new Pessoa("Maria Cecília", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[10] = new Pessoa("Noah", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[11] = new Pessoa("Lorena", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[12] = new Pessoa("Ravi", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[13] = new Pessoa("Greta", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[14] = new Pessoa("David", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[15] = new Pessoa("Yolanda", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[16] = new Pessoa("Gael", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[17] = new Pessoa("Teobalda", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[18] = new Pessoa("Benjamin", (int) (Math.random() * 20) + 1, premioParticipante);
        pessoas[19] = new Pessoa("Ana Carolina", (int) (Math.random() * 20) + 1, premioParticipante);

        controle.setPessoas(pessoas);
        System.out.println("******** Bem vindo ao sistema de sorteios da Tele Sena! ********"); 
        //pausa do sistema por 1 segundo
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nVamos realizar o sorteio em alguns instantes... Compre as suas Tele Senas!"); 

        TeleSena teleSena = new TeleSena();

        //impressão do nome das pessoas e quantidade de Tele Senas que foram compradas
        System.out.println("\nNomes dos participantes e quantidade de Tele Senas adquiridas:");
        for (int i = 1; i < pessoas.length; i++) {
            Pessoa pessoa = pessoas[i];

            if (pessoa != null) {
                System.out.println("Nome: " + pessoa.getNome());
                System.out.println("Quantidade de Tele Senas: " + pessoa.unidadesTeleSenasCompradas());
                System.out.println("-------------------");
            }
        }

        //método do sorteio dos números da Tele Sena
        teleSena.preencherNumeros1();
        teleSena.preencherNumeros2();
        int[] numerosSorteados = teleSena.gerarNumerosSorteados();

        //pausa do sistema por 1 segundo
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //impressão dos números sorteados
        System.out.println("\n\nEsses foram os números sorteados nessa edição da Tele Sena: ");
        for (int i = 0; i < numerosSorteados.length; i++) {
            System.out.println(numerosSorteados[i] + " ");
        }

        //pausa do sistema por 1 segundo
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //impressão da quantidade de Tele Senas vendidas
        System.out.println("\nConfira a quantidade de Tele Senas vendidas nessa edição: " + controle.quantidadeTeleSenasVendidas());

        //pausa do sistema por 1 segundo
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //impressão a quantidade de ganhadores e o nome de cada um deles
        int quantidadeGanhadores = controle.Ganhadores();
        System.out.println("\nQuantos sortudos ganharam o prêmio? " + quantidadeGanhadores);
        System.out.println("\nEsses são os nomes dos nossos ganhadores: ");
        for (int i = 0; i < controle.getPessoas().length; i++) {
            Pessoa pessoa = controle.getPessoas()[i];
            if (pessoa != null && pessoa.temTelePremiadas()) {
                System.out.println(pessoa.getNome());
            }
        }

        //pausa do sistema por 1 segundo
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //impressão do valor do prêmio para cada ganhador
        double premioPorGanhador = controle.premioPorGanhador();
        System.out.println("\nCada ganhador levou esse valor no prêmio dessa edição: R$" + premioPorGanhador);

        //pausa do sistema por 1 segundo
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //impressão do valor total de Tele Senas vendidas 
        double valorTotalTSVendidas = controle.valorTotalTSVendidas();
        System.out.println("\nValor total das Tele Senas vendidas: R$" + valorTotalTSVendidas);

        //pausa do sistema por 1 segundo
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //impressão do lucro obtido pelo Sílvio Santos com a Tele Sena
        double lucroSilvioSantos = controle.Lucro();
        System.out.println("\nSílvio Santos e toda equipe da Tele Sena lucraram R$" + lucroSilvioSantos);

        //pausa do sistema por 1 segundo
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
