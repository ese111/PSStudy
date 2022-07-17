class Solution {
    fun solution(record: Array<String>): Array<String> {
        val users = getUser(record)

        return getLog(record, users)
    }

    private fun getUser(record: Array<String>): Map<String, String> {
        val users = mutableMapOf<String, String>()
        record.forEach {
            val log = it.split(" ")
            when (log[0]) {
                "Enter" -> {
                    users[log[1]] = log[2]
                }
                "Change" -> {
                    users[log[1]] = log[2]
                }
            }
        }
        return users
    }

    private fun getLog(record: Array<String>, users: Map<String, String>) = record.map { data ->
        val log = data.split(" ")

        when (log[0]) {
            "Enter" -> {
                "${users[log[1]]}님이 들어왔습니다."
            }
            "Leave" -> {
                "${users[log[1]]}님이 나갔습니다."
            }
            else -> ""
        }
    }.filter { it != "" }.toTypedArray()

}