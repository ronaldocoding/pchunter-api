package br.com.pchunter.model

import br.com.pchunter.util.emptyString
import br.com.pchunter.util.zeroFloatNumber
import br.com.pchunter.util.zeroLongNumber
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
data class Part(
    @Id
    @GeneratedValue()
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    val id: Long = zeroLongNumber(),
    val title: String = emptyString(),
    val description: String = emptyString(),
    val url: String = emptyString(),
    val value: Float = zeroFloatNumber()
)
