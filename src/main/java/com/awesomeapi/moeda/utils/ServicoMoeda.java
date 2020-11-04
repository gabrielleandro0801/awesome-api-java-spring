package com.awesomeapi.moeda.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ServicoMoeda {
    static String webService = "https://economia.awesomeapi.com.br/";
    static int codigoSucesso = 200;

    public static Moeda buscaMoeda(String nomeMoeda) throws Exception {
        String urlParaChamada = webService + nomeMoeda + "/";

        try{
            URL url = new URL(urlParaChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if(conexao.getResponseCode() != codigoSucesso){
                throw new RuntimeException("HTTP Error code: " + conexao.getResponseCode());
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Util.converteJsonEmString(resposta);
            Gson gson = new Gson();
            List<Moeda> lista = gson.fromJson(jsonEmString, new TypeToken<ArrayList<Moeda>>(){}.getType());

            Moeda moeda = lista.remove(0);
            //gson.fromJson(jsonEmString, Moeda.class);
            //Moeda moeda = new Moeda();
            return moeda;
        }catch(Exception e){
            throw new Exception("Erro: " + e);
        }
    }
}
