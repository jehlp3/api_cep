package src.br.com.jessdev.models;

public record CepResponse(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf,
        String regiao) {
}
