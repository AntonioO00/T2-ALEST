# Otimização de um Sistema de Mercadorias

## Descrição do Problema 
Você foi contratado por uma empresa do ramo de varejo que está enfrentando sérios problemas de performance em um de seus aplicativos usados para pesquisar informações sobre mercadorias. A aplicação atual permite a abertura de um banco de dados armazenado em um arquivo CSV e, após a carga, permite que o usuário faça consultas às mercadorias cadastradas informando o código da mercadoria
![Texto Alternativo](https://github.com/AntonioO00/T2-ALEST/blob/main/Imagens/Aplica%C3%A7%C3%A3o.jpg)

### Problema

A aplicação apresenta os seguintes problemas de performance:

    Demora de 30 segundos para abrir o banco de dados.
    Pesquisa pela mercadoria de código NM70K3QR leva cerca de 45 segundos para retornar que a mesma não existe.
    Pesquisa pelo código VRL9CRB leva 35 segundos para retornar os dados da mercadoria.

Essa performance ruim torna inviável a utilização da aplicação, impactando negativamente a operação da empresa.

### Objetivo 
O objetivo deste trabalho é analisar o motivo pelo qual a carga do banco de dados e a consulta de uma mercadoria estão tão demoradas e, obviamente, corrigir o problema. O tempo aceitável tanto para a carga quanto para a pesquisa de um código qualquer é de 1 a 3 segundos em uma máquina com configuração média para os dias atuais.
