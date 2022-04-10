package education.cccp.mobile


import org.junit.Assert.assertEquals
import org.junit.Test

class PersonsGeneratorUnitTest {
    @Test
    fun output_metaSyntaxiqueVariables_content() {
        println("\nmetaSyntaxiqueVariables : ")
        metaSyntaxiqueVariables.forEach(::println)
    }

    @Test
    fun output_metaSyntaxiquePeoples_content() {
        println("\nmetaSyntaxiquePeoples : ")
        metaSyntaxiquePeoples.forEach(::println)
    }

    @Test
    fun output_generatedPersons_content() {
        println("\ngeneratedPersons : ")
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