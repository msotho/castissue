package com.example.castissue

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


interface Repo {
    suspend fun fetch(): Result<Unit>
}

@Repository
class RepoImpl : Repo {
    override suspend fun fetch(): Result<Unit> {
        return Result.success(Unit)
    }
}

@RestController
class HomeAPI(private val repo: Repo) {

    @GetMapping("/")
    suspend fun index(): ResponseEntity<Unit> {
        repo.fetch().getOrThrow()

        return ResponseEntity(HttpStatus.OK)
    }

}