package src.br.com.jessdev.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWorking {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public void convertToObject(String json, List<Cep> cepList) {
        CepResponse cepResponse = gson.fromJson(json, CepResponse.class);

        try {
            Cep cep = new Cep(cepResponse);
            cepList.add(cep);
        }catch (Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }

    }

    public void convertToJson(List<Cep> cepList) throws IOException {
        String json = gson.toJson(cepList);

        FileWriter writer = new FileWriter("ceps.json");
        writer.write(json);
        writer.close();

        System.out.println(json);
    }
}
