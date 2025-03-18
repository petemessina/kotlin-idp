package com.example

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CosmosDBService @Autowired constructor(private val mongoClient: MongoClient) {

    private val database: MongoDatabase = mongoClient.getDatabase("your-database-name")
    private val collection: MongoCollection<Document> = database.getCollection("your-collection-name")

    fun create(document: Document) {
        collection.insertOne(document)
    }

    fun read(filter: Document): Document? {
        return collection.find(filter).firstOrNull()
    }

    fun update(filter: Document, update: Document) {
        collection.updateOne(filter, Document("\$set", update))
    }

    fun delete(filter: Document) {
        collection.deleteOne(filter)
    }

    fun fetchDataForJWT(filter: Document): Document? {
        return collection.find(filter).firstOrNull()
    }
}
