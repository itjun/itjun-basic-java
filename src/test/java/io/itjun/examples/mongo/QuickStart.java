package io.itjun.examples.mongo;

import java.util.ArrayList;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

public class QuickStart {

    public static void main(String[] args) {
        MongoCollection<Document> collection = MongoConfig.getDatabase().getCollection("movies");
        Document doc = collection.find(Filters.eq("title", "Back to the Future")).first();
        if (doc != null) {
            System.out.println(doc.toJson());
        } else {
            System.out.println("No matching documents found.");
        }

        ArrayList<Document> list = collection.find().into(new ArrayList<Document>());
        list.forEach(System.out::println);
    }

}