package DynamoDbSetup;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.local.embedded.DynamoDBEmbedded;
import com.amazonaws.services.dynamodbv2.local.main.ServerRunner;
import com.amazonaws.services.dynamodbv2.local.server.DynamoDBProxyServer;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;

public class DynamoDBLocalFixture {
    /**
     * You can use mvn to run DynamoDBLocalFixture, e.g.
     * <p>
     * $ mvn clean package
     * <p>
     * $ mvn exec:java -Dexec.mainClass="com.amazonaws.services.dynamodbv2.DynamoDBLocalFixture" \
     * -Dexec.classpathScope="test" \
     * -Dsqlite4java.library.path=target/dependencies
     * <p>
     * It's recommended to run "aws configure" one time before you run DynamoDBLocalFixture
     *
     * @param args - no args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        AmazonDynamoDB dynamodb = null;
        try {
            // Create an in-memory and in-process instance of DynamoDB Local that skips HTTP
            dynamodb = DynamoDBEmbedded.create().amazonDynamoDB();
            // use the DynamoDB API with DynamoDBEmbedded
            listTables(dynamodb.listTables(), "DynamoDB Embedded");
        } finally {
            // Shutdown the thread pools in DynamoDB Local / Embedded
            if(dynamodb != null) {
                dynamodb.shutdown();
            }
        }

        // Create an in-memory and in-process instance of DynamoDB Local that runs over HTTP
        final String[] localArgs = { "-inMemory" };
        DynamoDBProxyServer server = null;
        try {
            server = ServerRunner.createServerFromCommandLineArgs(localArgs);
            server.start();

            dynamodb = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
                    // we can use any region here
                    new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
                    .build();

            // use the DynamoDB API over HTTP
            listTables(dynamodb.listTables(), "DynamoDB Local over HTTP");
        } finally {
            // Stop the DynamoDB Local endpoint
            if(server != null) {
                server.stop();
            }
        }
    }

    public static void listTables(ListTablesResult result, String method) {
        System.out.println("found " + Integer.toString(result.getTableNames().size()) + " tables with " + method);
        for(String table : result.getTableNames()) {
            System.out.println(table);
        }
    }

}
