import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import kotlin.test.assertEquals
//import kotlin.test.assertEqualsThat
import kotlin.test.Test


class PojoJacksonTest {

    @Test
    fun `jackson json serdes`() {
        val mapper = ObjectMapper().registerKotlinModule()

        listOf(
            Pojo("only required") to
                    """{"message":"only required"}""",
            Pojo("required", "and optional") to
                    """{"message":"required","message2":"and optional"}"""
        ).forEach { (pojo, json) ->

            assertEquals(mapper.readValue<Pojo>(json),pojo)
            assertEquals(mapper.writeValueAsString(pojo), json)
        }

    }
}

data class Pojo(
    val message: String,

    @JsonProperty("message2")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    val optionalPayload: String? = null
) {
    private val payload = message + optionalPayload
}

