package ehealth.backend;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;


public class Test{
	// @BsonProperty("id") 
	public String id;
	// @BsonProperty("name") 
	public String name;
    // @BsonProperty("nim") 
    public String title;

    public Test() {
    }

    public Test(String id, String name , String title) {
        this.id = id;
        this.name = name;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Test{" + "id= "+ id +
                "name='" + name + '\'' +
                ", title=" + title +
                '}';
    }
}