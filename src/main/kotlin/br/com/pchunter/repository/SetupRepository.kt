package br.com.pchunter.repository

import br.com.pchunter.model.Setup
import org.springframework.data.repository.CrudRepository

interface SetupRepository : CrudRepository<Setup, Long> {}