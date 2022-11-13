package br.com.pchunter.model

import br.com.pchunter.util.zeroLongNumber
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
data class Setup(
    @Id
    @GeneratedValue()
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    val id: Long = zeroLongNumber(),
    @OneToOne(cascade = [CascadeType.PERSIST])
    val cpu: Part = Part(),
    @OneToOne(cascade = [CascadeType.PERSIST])
    val motherboard: Part = Part(),
    @OneToMany(cascade = [CascadeType.PERSIST])
    val gpus: List<Part> = listOf(Part()),
    @OneToMany(cascade = [CascadeType.PERSIST])
    val hds: List<Part> = listOf(Part()),
    @OneToMany(cascade = [CascadeType.PERSIST])
    val ssds: List<Part> = listOf(Part()),
    @OneToMany(cascade = [CascadeType.PERSIST])
    val rams: List<Part> = listOf(Part()),
    @OneToMany(cascade = [CascadeType.PERSIST])
    val fans: List<Part> = listOf(Part()),
    @OneToOne(cascade = [CascadeType.PERSIST])
    val powerSupply: Part = Part(),
    @OneToOne(cascade = [CascadeType.PERSIST])
    val cabinet: Part = Part(),
    @OneToMany(cascade = [CascadeType.PERSIST])
    val monitors: List<Part> = listOf(Part()),
    @OneToOne(cascade = [CascadeType.PERSIST])
    val keyboard: Part = Part(),
    @OneToOne(cascade = [CascadeType.PERSIST])
    val mouse: Part = Part()
) {
    val totalValue: Float
        get() {
            var acm = 0.0f
            acm += cpu.value +
                    motherboard.value +
                    powerSupply.value +
                    cabinet.value +
                    keyboard.value +
                    mouse.value
            gpus.forEach { gpu ->
                acm += gpu.value
            }
            hds.forEach { hd ->
                acm += hd.value
            }
            ssds.forEach { ssd ->
                acm += ssd.value
            }
            rams.forEach { ram ->
                acm += ram.value
            }
            fans.forEach { fan ->
                acm += fan.value
            }
            monitors.forEach { monitor ->
                acm += monitor.value
            }
            return acm
        }
}
