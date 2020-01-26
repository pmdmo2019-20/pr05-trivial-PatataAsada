package es.iessaladillo.pedrojoya.pr05_trivial.data.entity

import java.util.*

data class Question(val question: String, val right: String, val wrong: Array<String>) {
    var insert_right: Boolean = false
    fun getAnswers(): Array<String?> {
        var result: Array<String?> = arrayOfNulls(4)
        var rngesus = Random()
        for (x in 0 until 3) {
            if (!insert_right) {
                insert_right = rngesus.nextBoolean()
                if (insert_right) {
                    result[x] = right
                    result[x + 1] = wrong[x]
                }else{
                    result[x] = wrong[x]
                }
            } else {
                if (insert_right) {
                    result[x+1] = wrong[x]
                } else result[x] = wrong[x]
            }

        }
        if (!insert_right) result[3] = right
        insert_right = false
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Question

        if (question != other.question) return false
        if (right != other.right) return false
        if (!wrong.contentEquals(other.wrong)) return false
        if (insert_right != other.insert_right) return false

        return true
    }

    override fun hashCode(): Int {
        var result = question.hashCode()
        result = 31 * result + right.hashCode()
        result = 31 * result + wrong.contentHashCode()
        result = 31 * result + insert_right.hashCode()
        return result
    }
}