package src.br.com.jessdev.models;

public class Cep {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String regiao;

    public Cep(CepResponse cepResponse) {
        this.cep = cepResponse.cep();
        this.logradouro = cepResponse.logradouro();
        this.bairro = cepResponse.bairro();
        this.localidade = cepResponse.localidade();
        this.uf = cepResponse.uf();
        this.regiao = cepResponse.regiao();
    }

    public String getCep() { return cep; }

    public String getLogradouro() { return logradouro; }

    public String getBairro() { return bairro; }

    public String getLocalidade() { return localidade; }

    public String getUf() { return uf; }

    public String getRegiao() { return regiao; }
}
