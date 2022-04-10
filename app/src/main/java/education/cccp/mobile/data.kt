@file:Suppress("unused")

package education.cccp.mobile

import education.cccp.mobile.model.Person

val metaSyntaxiqueVariables: List<String>
    get() = listOf(
        "foo",
        "bar",
        "baz",
        "qux",
        "quux",
        "corge",
        "grault",
        "garply",
        "waldo",
        "fred",
        "plugh",
        "xyzzy",
        "thud"
    )

val metaSyntaxiquePeoples: List<Map<String, String>>
    get() = listOf(
        mapOf(pair = "Ashok" to "Kumar"),
        mapOf(pair = "Baby" to "Doe"),
        mapOf(pair = "Brett" to "Boe"),
        mapOf(pair = "Carla" to "Coe"),
        mapOf(pair = "Donna" to "Doe"),
        mapOf(pair = "Frank" to "Foe"),
        mapOf(pair = "Grace" to "Goe"),
        mapOf(pair = "Harry" to "Hoe"),
        mapOf(pair = "Jackie" to "Joe"),
        mapOf(pair = "Jane" to "Doe"),
        mapOf(pair = "Jane" to "Poe"),
        mapOf(pair = "Jane" to "Roe"),
        mapOf(pair = "Joe" to "Bloggs"),
        mapOf(pair = "Joe" to "Public"),
        mapOf(pair = "John" to "Doe"),
        mapOf(pair = "John" to "Noakes"),
        mapOf(pair = "John" to "Nokes"),
        mapOf(pair = "John" to "Public"),
        mapOf(pair = "John" to "Smith"),
        mapOf(pair = "John" to "Stiles"),
        mapOf(pair = "Juan" to "Doe"),
        mapOf(pair = "Karren" to "Koe"),
        mapOf(pair = "Larry" to "Loe"),
        mapOf(pair = "Mark" to "Moe"),
        mapOf(pair = "Marta" to "Moe"),
        mapOf(pair = "Mary" to "Major"),
        mapOf(pair = "Norma" to "Noe"),
        mapOf(pair = "Paula" to "Poe"),
        mapOf(pair = "Quintin" to "Qoe"),
        mapOf(pair = "Ralph" to "Roe"),
        mapOf(pair = "Richard" to "Miles"),
        mapOf(pair = "Robert" to "Roe"),
        mapOf(pair = "Sammy" to "Soe"),
        mapOf(pair = "Tommy" to "Toe"),
        mapOf(pair = "Vince" to "Voe"),
        mapOf(pair = "William" to "Woe"),
        mapOf(pair = "Xerxes" to "Xoe"),
        mapOf(pair = "Yvonne" to "Yoe"),
        mapOf(pair = "Zachery" to "Zoe")
    )

val generatedPersons: List<Person>
    get() = metaSyntaxiquePeoples.map {
        Person(
            id = null,
            firstName = it.keys.first(),
            lastName = it.values.first(),
            email = "${it.keys.first().lowercase()}.${it.values.first().lowercase()}@acme.com",
            nickname = "${it.keys.first().lowercase()}.${it.values.first().lowercase()}"
        )
    }
