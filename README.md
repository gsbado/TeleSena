# TeleSena
Este projeto implementa um sistema em Java para gerenciar as vendas, realizar sorteios e controlar os ganhadores de uma edição da Tele Sena. O sistema segue as regras estabelecidas, incluindo a venda de Tele Senas, sorteios, premiações e exibição de resultados detalhados.

## **Informações Importantes**

- Cada Tele Sena custa R$10,00.  <br/>
- Cada Tele Sena contém dois conjuntos de 25 números, proporcionando duas chances de ganhar. <br/>
- O sorteio inicialmente seleciona 25 números. Se nenhum ganhador for encontrado, o sorteio continua até que pelo menos uma Tele Sena seja premiada. <br/>
- Um total de 20 pessoas concorre na Tele Sena, com cada pessoa podendo comprar no máximo 15 Tele Senas. <br/>
- Existem 300 Tele Senas disponíveis para compra, mas o sorteio pode ocorrer mesmo que nem todas sejam vendidas. <br/>
- O valor do prêmio é 80% do total de vendas, dividido igualmente entre os ganhadores em caso de múltiplos vencedores. <br/>


## **Estrutura do projeto**

**1. TeleSena:** <br/>
A classe representa uma Tele Sena, com métodos para gerenciar os conjuntos de números. <br/>
**2. Pessoa:** <br/>
Representa uma pessoa participante, com métodos para gerenciar Tele Senas e informações sobre premiações. <br/>
**3. ControleTeleSena:** <br/>
Gerencia a venda de Tele Senas, controla a quantidade de Tele Senas vendidas, calcula prêmios, realiza sorteios e fornece informações sobre ganhadores e lucros. <br/>

## **Como Usar:** <br/>
Compile o projeto Java. <br/>
O arquivo Principal.java contém o método main, onde os métodos das classes principais são chamados para realizar as operações descritas no enunciado. <br/>
Siga as instruções apresentadas no menu para interagir com o sistema. <br/>
