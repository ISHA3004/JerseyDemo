/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.demojersey;

import java.math.BigDecimal;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author ISHA MISTRY
 */
public class ExternalService {
    public void makeData(String responseBody)
    {
        JSONParser parser = new JSONParser();
            try{
                JSONObject responsejson = (JSONObject)parser.parse(responseBody);
                
                JSONArray products = (JSONArray)responsejson.get("products");
                
                for(Object product: products)
                {
                    ExternalDTO extdto = new ExternalDTO();
                    JSONObject jsonproduct = (JSONObject)product;
                    extdto.setRating((double)jsonproduct.get("rating"));
                    extdto.setThumbnail((String)jsonproduct.get("thumbnail"));
                    extdto.setWeight(((Long)jsonproduct.get("weight")).intValue());
                    extdto.setCategory((String)jsonproduct.get("category"));
                    
                    JSONObject dim = (JSONObject)jsonproduct.get("dimensions");
                    extdto.setDimDepth((double)dim.get("depth"));
                    extdto.setDimHeight((double)dim.get("height"));
                    extdto.setDimWidth((double)dim.get("width"));
                   
                    ExternalDAO extdao = new ExternalDAO();
                    extdao.insertData(extdto);
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
                
            }
    }
    
    public JSONObject selectData(String responseBody,String url)
    {
        JSONParser parser = new JSONParser();
        try
        {
            JSONObject responsejson = (JSONObject)parser.parse(responseBody);
                
            JSONArray products = (JSONArray)responsejson.get("products");
            JSONArray myproducts = new JSONArray();
            
            for(Object product: products)
            {
                JSONObject jsonproduct = (JSONObject)product;
                JSONObject myproduct = new JSONObject();
                myproduct.put("rating",jsonproduct.get("rating"));
                myproduct.put("thumbnail",jsonproduct.get("thumbnail"));
                myproduct.put("weight",jsonproduct.get("weight"));
                myproduct.put("category",jsonproduct.get("category"));
                
                JSONObject dimensions = (JSONObject)jsonproduct.get("dimensions");
                JSONObject mydimension = new JSONObject();
                mydimension.put("depth",dimensions.get("depth"));
                mydimension.put("height",dimensions.get("height"));
                mydimension.put("width",dimensions.get("width"));
                
                myproduct.put("dimensions",mydimension);
                
                myproducts.add(myproduct);
            }
            JSONObject myjson = new JSONObject();
            myjson.put("products",myproducts);
            
            ExternalDAO extdao = new ExternalDAO();
            extdao.enterlogs(myjson.toString(),url);
            return myjson;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}
