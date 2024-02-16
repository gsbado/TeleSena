/*
 * Gabriela Spanemberg Bado
 * Algoritmos e Programação: Fundamentos
 * 2023/01
 * Essa classe é de um título de Tele Sena
 */

public class TeleSena
{
    protected double valorTeleSena; //variável com o valor fixo da Tele Sena
    protected int [] numerosTeleSena1; //array com primeiro conjunto de números que a Tele Sena possui
    protected int [] numerosTeleSena2; //array com segundo conjunto de números que a Tele Sena possui

    //método construtor
    public TeleSena () {
        valorTeleSena = 10.00;
        this.numerosTeleSena1 = new int [25];
        this.numerosTeleSena2 = new int [25];
    }

    //getters 
    public double getValorTeleSena() {
        return valorTeleSena;
    }

    public int[] getNumerosTeleSena1() {
        return numerosTeleSena1;
    }

    public int[] getNumerosTeleSena2() {
        return numerosTeleSena2;
    }

    //métodos utilizados para preencher o array de números do sorteio da TeleSena. enquanto não preencher o array, ele chamará o método sortearNumeros
    public void preencherNumeros1(){

        for(int i = 0; i < numerosTeleSena1.length; i++){
            numerosTeleSena1[i] = sortearNumeros (numerosTeleSena1);
        }

    }

    public void preencherNumeros2(){

        for(int i = 0; i < numerosTeleSena2.length; i++){
            numerosTeleSena2[i] = sortearNumeros (numerosTeleSena2);
        }

    }

    // método para sortear números utilizando Math.random e evitar a repetição deles no preenchimento dos arrays numerosTeleSena1 e numerosTeleSena2
    protected int sortearNumeros (int[] numerosSorteados) {
        int novonumero = (int) (Math.random() * 60 + 1); //geração do número aleatório
        boolean numeroRepetido = false; //variável para mostrar se o número sorteado já está presente no array

        //loop para verificar se o número sorteado já existe
        for (int i = 0; i < numerosSorteados.length; i++){
            if (numerosSorteados[i] == novonumero) {
                numeroRepetido = true;
                break; //se o número já existe, o loop para
            }
        }

        //se o loop anterior parou, esse if/else chama novamente o método para sortear números
        if (numeroRepetido) {
            return sortearNumeros(numerosSorteados);
        }
        else {
            return novonumero;
        }
    }

    public int[] adicionarNumero(int[] numerosSorteados, int novoNumero) {
        int[] listanumeros = new int[numerosSorteados.length + 1];

        for (int i = 0; i < numerosSorteados.length; i++) {
            listanumeros[i] = numerosSorteados[i];
        }

        listanumeros[numerosSorteados.length] = novoNumero;

        return listanumeros;

    }

    public int[] gerarNumerosSorteados() {
        int[] numerosSorteados = new int[25];

        for (int i = 0; i < numerosSorteados.length; i++) {
            numerosSorteados[i] = sortearNumeros(numerosSorteados);
        }

        return numerosSorteados;
    }

    //métodos para verificar se existe alguma Tele Sena premiada
    public boolean verificarPremios(int[] numerosSorteados) {
        return premiada(numerosTeleSena1, numerosSorteados) || premiada(numerosTeleSena2, numerosSorteados);
    }

    //métodos que percorrem um conjunto de números (que seriam os premiados) e verificam se eles estão presentes nesse array
    protected boolean premiada (int[] teleSena, int[] numerosSorteados) {
        for (int i = 0; i < teleSena.length; i++) {
            if (numeroPremiado(numerosSorteados, teleSena[i])) {
                return false;
            }
        }
        return true;
    }

    protected boolean numeroPremiado (int[] numeropremiado, int numero) {
        for (int i = 0; i < numeropremiado.length; i++) {
            if (numeropremiado[i] == numero) {
                return true;
            }
        }
        return false;
    }
}
