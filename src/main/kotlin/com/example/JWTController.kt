package com.example

import org.bson.Document
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import java.util.Date

@RestController
class JWTController @Autowired constructor(private val cosmosDBService: CosmosDBService) {

    @GetMapping("/generate-token")
    fun generateToken(@RequestParam filter: Map<String, Any>): String {
        val filterDocument = Document(filter)
        val data = cosmosDBService.fetchDataForJWT(filterDocument)

        val claims = mutableMapOf<String, Any>()
        data?.forEach { key, value -> claims[key] = value }

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 3600000)) // 1 hour expiration
            .signWith(SignatureAlgorithm.HS256, "your-secret-key")
            .compact()
    }
}
