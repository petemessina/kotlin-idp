package com.example

import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class CRUDController @Autowired constructor(private val cosmosDBService: CosmosDBService) {

    @PostMapping("/create")
    fun create(@RequestBody document: Document) {
        cosmosDBService.create(document)
    }

    @GetMapping("/read")
    fun read(@RequestParam filter: Map<String, Any>): Document? {
        val filterDocument = Document(filter)
        return cosmosDBService.read(filterDocument)
    }

    @PutMapping("/update")
    fun update(@RequestParam filter: Map<String, Any>, @RequestBody update: Document) {
        val filterDocument = Document(filter)
        cosmosDBService.update(filterDocument, update)
    }

    @DeleteMapping("/delete")
    fun delete(@RequestParam filter: Map<String, Any>) {
        val filterDocument = Document(filter)
        cosmosDBService.delete(filterDocument)
    }
}
