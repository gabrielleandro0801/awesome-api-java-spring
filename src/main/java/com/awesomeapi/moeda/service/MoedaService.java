package com.awesomeapi.moeda.service;

import com.awesomeapi.moeda.entity.MoedaEntity;
import com.awesomeapi.moeda.utils.Constants;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MoedaService {

    public MoedaEntity buscaMoeda(String nomeMoeda) throws Exception {
        String url = Constants.URL + nomeMoeda + "/";

        try{
            RequestService requestService = new RequestService();
            HashMap<String, String> parameters = new HashMap<>();
            HttpEntity httpEntity = requestService.get(url, parameters);

            if (httpEntity == null){
                throw new Exception("Error on calling API");
            }

            String returnFromApi = EntityUtils.toString(httpEntity);
            JSONArray entityArray = new JSONArray(returnFromApi);

            JSONObject entity = entityArray.getJSONObject(0);

            return MoedaEntity.builder()
                    .bid(entity.getDouble("bid"))
                    .name(entity.getString("name"))
                    .code(entity.getString("code"))
                    .build();

        }catch(Exception e){
            throw new Exception("Erro: " + e);
        }
    }
}
