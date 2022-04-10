package education.cccp.mobile


import org.junit.Assert.assertEquals
import org.junit.Test

class PersonsGeneratorUnitTest {
    @Test
    fun output_metaSyntaxiqueVariables_content() {
        println("\neducation.cccp.mobile.model.getMetaSyntaxiqueVariables : ")
        metaSyntaxiqueVariables.forEach(::println)
    }

    @Test
    fun output_metaSyntaxiquePeoples_content() {
        println("\neducation.cccp.mobile.model.getMetaSyntaxiquePeoples : ")
        metaSyntaxiquePeoples.forEach(::println)
    }

    @Test
    fun output_generatedPersons_content() {
        println("\neducation.cccp.mobile.model.getGeneratedPersons : ")
        generatedPersons.forEach(::println)
    }

    @Test
    fun test_generatedPersons_size_is_ok() {
        assertEquals(
            metaSyntaxiquePeoples.size,
            generatedPersons.size
        )
    }
}