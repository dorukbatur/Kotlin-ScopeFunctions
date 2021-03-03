/** Scope Functions
 *	Doruk Batur 02.03.2021
 *	Made for kotlin and tried to simplify asap the scope functions of kotlin
 *
 * "with"
 * for non null objects
 * rule 1: refer to context object by using "this"
 * rule 2: The return value is the "lambda result"
 *
 * "apply"
 * for initialise or configure an object
 * rule 1: refer to context object by using "this"
 * rule 2: the return value is the "context object"
 *
 * "also"
 * for some additional object configs or operations
 * rule 1: refer to context object by using "it"
 * rule 2: the return value is the "context object"
 *
 * "let"
 * for avoiding null pointer exc
 * rule 1: refer to context object by using "it"
 * rule 2: the return value is the "lambda result"
 *
 *
 * "run"
 * for a combination of the with and let functions
 * with func with nullable object kinda function
 * rule 1: refer to context object by using "this"
 * rule 2: the return value is the "lambda result"
 *
 */
class Person {
    var name: String = "doruki"
    var age: Int = 25
}

fun main() {
    val human = Person()
    println(human.name + " " + human.age)

    with(human) {
        println(name + " " + age)
    }
//aplly
    val human1 = Person().apply {
        this.name = "debele"
        this.age = 30
    }
//with
    with(human1) {
        println(name + " " + age)
    }
//also
    human.also {
        it.name = "moruki"
        println(it.name)
    }



//let
    val name: String? = null

    val stringLength = name?.let{
        println(it.reversed())
        println(it.capitalize())
        it.length
    }
    println(stringLength)
//run
    val humanRun: Person? = null

    humanRun?.run {
        println(name + " " + age)
    }

}