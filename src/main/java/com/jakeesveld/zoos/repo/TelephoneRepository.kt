package com.jakeesveld.zoos.repo

import com.jakeesveld.zoos.model.Telephone
import org.springframework.data.repository.CrudRepository

interface TelephoneRepository : CrudRepository<Telephone, Long>
