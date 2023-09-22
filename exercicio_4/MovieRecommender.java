/* Projeto no Azure  */

/*
    Utilizando a Azure Machine Learning Studio fazer o upload dos dados da MovieLens 1M Dataset

    Criar um experiemento no Azure Machine Learning para criar e treinar o modelo de recomendção (que vai ser o que o meu código vai acessar)
    E então seguir os passos:
        -Carregar o conjunto de dados
        -Pré-processar os dados selcionando as colunas "UserID","MovieID" e "Rating" --> as colunas relevantes
        -Dividir o conjunto de dados em conjuntos de treinamentos e teste
        -Treinar o modelo de recomendação
        -Avaliar o desempenho

    Depois de treinar implementá-lo na Azure Machine Learning

    Gerar uma URL com a opção "Predictive Web Services" --> crio uma maneira de acessar remotamente o meu sistema de recomendção
        ^Certificar que a url está configurada pra aceitar solicitações no formato de JSON --> pq é assim que formatei o código

    Não configurei o código para exceções, e nem tratei erros porque não tive acesso ao azure, então não pude testar meu código :(
    DUUURO

*/

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

public class MovieRecommender {
    public static void main(String[] args) throws IOException, InterruptedException {

        // Azure ML
        String azure_URL = "NAO_CONSEGUI_ACESSO_AO_AZURE_URL"; //Minha url quando um dia eu tiver ela :(

        // IDs do usuario e dos filmes
        int user_id = 123;
        int movie_id = 456;

        // Cliente Http
        HttpClient http_client = HttpClient.newHttpClient();

        // HTTP request utilizando os IDs do usuario e dos filmes
        String request_body = String.format("{\"user_id\": %d, \"movie_id\": %d}", user_id, movie_id);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(azure_URL))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(request_body))
            .build();

        // Mandar o HTTP request
        HttpResponse<String> response = http_client.send(request, HttpResponse.BodyHandlers.ofString());

        // Pegar a resposta e bora...
        if (response.statusCode() == 200) {

            String response_body = response.body();

            // Recomendações baseadas nas respostas
            List<Integer> recommended_movie_ids = Arrays.asList(1, 2, 3); // Aqui estaria a lógica da minha Ai
            System.out.println("IDs dos filmes recomendados: " + recommended_movie_ids);
        }
        else {

            System.err.println("Erro: " + response.statusCode() + " - " + response.body());
        }
    }
}