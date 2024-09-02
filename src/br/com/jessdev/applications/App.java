package src.br.com.jessdev.applications;

import src.br.com.jessdev.models.Cep;
import src.br.com.jessdev.models.HttpRequestResponse;
import src.br.com.jessdev.models.JsonWorking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        String option = "";
        List<Cep> cepList = new ArrayList<>();
        JsonWorking jsonWorking = new JsonWorking();

        System.out.println("__API Consultas de CEP utilizando ViaCep__");

        while (!option.equalsIgnoreCase( "n")){
            System.out.println("Digite o cep desejado:");
            String inputCep = input.next();
            String formatedCep = inputCep.replaceAll("-", "");

            if (formatedCep.length() != 8){
                System.out.println("Cep inválido");
                continue;
            }

            String uriAddress = "https://viacep.com.br/ws/" +formatedCep+"/json/";

            System.out.println("Request: "+uriAddress);

            HttpRequestResponse http = new HttpRequestResponse();
            String json = http.getJson(uriAddress);

            jsonWorking.convertToObject(json, cepList);

            System.out.println("Deseja continuar? S ou N: ");
            option = input.next();
            input.nextLine();
        }

        System.out.println("\n__Imprimindo lista__");
        jsonWorking.convertToJson(cepList);

        System.out.println("Encerrando...");
    }
}
