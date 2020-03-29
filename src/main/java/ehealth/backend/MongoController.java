package ehealth.backend;

import java.util.ArrayList;
import java.util.function.Consumer;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document; 
import com.mongodb.client.model.Filters; 
import com.mongodb.client.model.Updates; 
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.MediaType;



@Controller("/rs")
public class MongoController {
    private MongoClient db;
    public MongoController(){
        this.db = new MongoClient();
    }

    private MongoCollection<Document> getCollection(){
        return this.db
                   .getDatabase("ehealth")
                   .getCollection("buku");
    }

    @Get("/")
    public ArrayList<Test> index(){
        ArrayList<Test> test = new ArrayList<>();

        Consumer<Document> setMhs = document -> {
            test.add(new Test(document.getObjectId("_id").toString(), document.getString("judul"), document.getString("alamat") )
            	);
        };

        getCollection().find().forEach(setMhs);
        return test;
    }

    @Post(produces=MediaType.APPLICATION_JSON, consumes=MediaType.APPLICATION_JSON)
    public ArrayList<Test> index(@Body String mhs){

        JsonObject data = new JsonParser().parse(mhs).getAsJsonObject();
        String name = data.get("judul").getAsString();
        
        ArrayList<Test> test = new ArrayList<>();
        return test;

    }

    @Put
    public String ubahData(){
        getCollection().updateOne(Filters.eq("id","5d60b8eb384bd64d994099cc" ), Updates.set("judul", 150));
        return "berhasil ubah dada"; 
    }
    
}