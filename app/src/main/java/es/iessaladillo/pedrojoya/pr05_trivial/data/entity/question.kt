package es.iessaladillo.pedrojoya.pr05_trivial.data.entity

import java.util.*

data class Question(val question: String, val right: String, val wrong: Array<String>) {
    var insertRightAnswer: Boolean = false
    fun getAnswers(): Array<String?> {
        val result: Array<String?> = arrayOfNulls(4)
        val rngesus = Random()
        for (x in 0 until 3) {
            if (!insertRightAnswer) {
                insertRightAnswer = rngesus.nextBoolean()
                if (insertRightAnswer) {
                    result[x] = right
                    result[x + 1] = wrong[x]
                } else {
                    result[x] = wrong[x]
                }
            } else {
                if (insertRightAnswer) {
                    result[x + 1] = wrong[x]
                } else result[x] = wrong[x]
            }

        }
        if (!insertRightAnswer) result[3] = right
        insertRightAnswer = false
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Question

        if (question != other.question) return false
        if (right != other.right) return false
        if (!wrong.contentEquals(other.wrong)) return false
        if (insertRightAnswer != other.insertRightAnswer) return false

        return true
    }

    override fun hashCode(): Int {
        var result = question.hashCode()
        result = 31 * result + right.hashCode()
        result = 31 * result + wrong.contentHashCode()
        result = 31 * result + insertRightAnswer.hashCode()
        return result
    }
}