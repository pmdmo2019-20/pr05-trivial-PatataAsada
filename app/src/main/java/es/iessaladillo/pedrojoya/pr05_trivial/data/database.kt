package es.iessaladillo.pedrojoya.pr05_trivial.data

import es.iessaladillo.pedrojoya.pr05_trivial.data.entity.Question

object Database {
    private val questions = listOf(
        Question("Pregunta 1", "Correcta", arrayOf("incorrecta", "incorrecta", "incorrecta")),
        Question("Pregunta 2", "Correcta", arrayOf("incorrecta", "incorrecta", "incorrecta")),
        Question("Pregunta 3", "Correcta", arrayOf("incorrecta", "incorrecta", "incorrecta")),
        Question("Pregunta 4", "Correcta", arrayOf("incorrecta", "incorrecta", "incorrecta")),
        Question("Pregunta 5", "Correcta", arrayOf("incorrecta", "incorrecta", "incorrecta")),
        Question("Pregunta 6", "Correcta", arrayOf("incorrecta", "incorrecta", "incorrecta")),
        Question("Pregunta 7", "Correcta", arrayOf("incorrecta", "incorrecta", "incorrecta")),
        Question("Pregunta 8", "Correcta", arrayOf("incorrecta", "incorrecta", "incorrecta")),
        Question("Pregunta 9", "Correcta", arrayOf("incorrecta", "incorrecta", "incorrecta")),
        Question("Pregunta 10", "Correcta", arrayOf("incorrecta", "incorrecta", "incorrecta"))
    )

    fun queryQuestions(): List<Question> = questions
}