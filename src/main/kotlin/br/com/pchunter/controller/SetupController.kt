package br.com.pchunter.controller

import br.com.pchunter.model.Setup
import br.com.pchunter.repository.SetupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("setup")
class SetupController {

    @Autowired
    lateinit var repository: SetupRepository

    @GetMapping
    fun getAllSetups(): List<Setup> = repository.findAll().toList()

    @PostMapping
    fun addSetup(@RequestBody setup: Setup) = repository.save(setup)
}