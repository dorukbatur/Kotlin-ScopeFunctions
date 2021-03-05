/** Scope Functions
 *	Doruk Batur 02.03.2021
 *	edited 06.03.2021
 *	Made for kotlin and tried to simplify amap the scope functions of kotlin
 *
 *	
 *
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
 
 
//in this example lets say we have person object with 2 variables in it 
//lets make them with default values


class Person {
    var name: String = "doruki"
    var age: Int = 25
}

fun main() {
    val human = Person()
    println(human.name + " " + human.age)

	//with function uses context object and does operations with it and returns the lambda result 


    with(human) {
        println(name + " " + age)
    }
	
	//apply function has use of you have an object created or create an object and you want to "apply" into something it and returns context object itself

    val human1 = Person().apply {
        this.name = "debele"
        this.age = 30
    }
    with(human1) {
        println(name + " " + age)
    }
	
	//also function has use of something like you had an object before i mean its created before sometime and you want to change something in it and returns object itself
	
    human.also {
        it.name = "moruki"
        println(it.name)
    }



	//let and run functions is being used for NullPointerExceptions
	//let function simply doesnt let the object or variable or whatever you use to go through the lambda function 
	//something like "if" method that simply looks for the variable if its null or not ,if its not it simply "let" the lambda to continue
	//and lambda has a return so you use it as a return function

    val name: String? = null

    val stringLength = name?.let{
        println(it.reversed())
        println(it.capitalize())
        it.length
    }
    println(stringLength)
	
	
	//run is simply combination of let and with functions
	
	
    val humanRun: Person? = null

    humanRun?.run {
        println(name + " " + age)
    }

}
