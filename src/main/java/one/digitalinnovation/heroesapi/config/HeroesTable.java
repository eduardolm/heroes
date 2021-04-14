package one.digitalinnovation.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.Collections;

import static one.digitalinnovation.heroesapi.constants.HeroesConstant.DYNAMO_ENDPOINT;
import static one.digitalinnovation.heroesapi.constants.HeroesConstant.DYNAMO_REGION;

public class HeroesTable {

    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(DYNAMO_ENDPOINT, DYNAMO_REGION))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "Heroes_Table";

        try {

            System.out.println("Iniciando criação da tabela. Por favor aguarde....");
            Table table = dynamoDB.createTable(tableName,
                    Collections.singletonList(new KeySchemaElement("id", KeyType.HASH)),
                    Collections.singletonList(new AttributeDefinition("id", ScalarAttributeType.S)),
                    new ProvisionedThroughput(5L, 5L));
            table.waitForActive();
            System.out.println("Tabela criada com sucesso: " + table.getDescription().getTableStatus());

        } catch (Exception e) {

            System.out.println("Não foi possível criar a tabela.");
            System.out.println(e.getMessage());
        }
    }
}
