package com.mc.innuce;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DataController {
		@GetMapping("/") 
		public String main() {
			return "wordCloud";
		}

    @GetMapping("/wordCloud")
    public @ResponseBody void wordCloud(HttpServletResponse res, HttpServletRequest req) throws IOException {

       String word = req.getParameter("word");
       
       System.out.println(word);
       ParsingKomoran pk = new ParsingKomoran();
        HashMap<String, Integer> crawlerData = pk.parsingData(word);
        
      	System.out.println("DataController(wordCloud): "+crawlerData.toString());
        JSONArray jsonArray = new JSONArray();
        //명사들을 하나씩
        for(String token : crawlerData.keySet()){
            JSONObject informationObject = new JSONObject();
            
//            {"x": "token"}
            informationObject.put("x", token);
//            { value: 80 }
            informationObject.put("value", crawlerData.get(token));
//						{"x": "token", value: 80}
            jsonArray.put(informationObject);
        }
//        jsonArray = {
//        		{"x": "token", value: 80},
//        		{"x": "token", value: 80},
//        		{"x": "token", value: 80},
//        		{"x": "token", value: 80}
//        }
        
        

        // printwriter 과 print 를 사용하여 값을 response 로 값을 전달함
        // pw 로 값을 전달하면 값이 response body 에 들어가서 보내짐
        res.setContentType("application/json;charset=utf-8");//한글을 정상적으로 출력
        PrintWriter pw = res.getWriter();
        pw.print(jsonArray.toString());
        System.out.println(jsonArray.toString());
//        	return jsonArray.toString();
    }
    
}