# Heroes API

## Objetivos
Desenvolver uma API de gerenciamento de heróis utilizando WebFlux, tecnologia adotada por empresas como Netflix e Pivotal.
Esta API terá um CRUD básico, permitindo cadastrar, listar e excluir heróis do banco de dados.

## Tecnologias utilizadas
Esta API foi desenvolvida utilizando-se as seguintes tecnologias:

 + Java 11
 + Spring Boot 2.4.4
 + WebFlux 2.4.4
 + Junit 5
 + AWS DynamoDB
 + Docker
 + Github

## Banco de dados
De forma a evitar geração de custos dos serviços AWS pela utilização de um banco de dados DynamoDB hospedado na nuvem, escolhemos utilizar o mesmo banco de dados sendo executado localmente em um container Docker.

## Execução da API
Para executar a API é preciso que o DynamoDB esteja sendo executado localmente. Todos os procedimentos para download e execução deste serviço localmente estão disponíveis no site da própria AWS:

`https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html`

Para execução:

 + Fazer um fork deste repositório;
 + Abrir o projeto em sua IDE preferida
 + Editar o arquivo:
    `src/main/resources/application-sample.properties`, inserindo as informações relacionadas à AWS
 + Executar o arquivo:
    `src/main/java/one.digitalinnovation.heroesapi/HeroesApiApplication.java`

Os requests podem ser feitos utilizando-se Postman, Insomnia ou similares.