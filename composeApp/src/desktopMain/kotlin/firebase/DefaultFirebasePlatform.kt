package firebase

import com.google.firebase.FirebasePlatform

object DefaultFirebasePlatform : FirebasePlatform() {
    private val storage = mutableMapOf<String, String>()

    override fun clear(key: String) {
        storage.remove(key)
    }

    override fun log(msg: String) = println(msg)

    override fun retrieve(key: String): String? = storage[key]

    override fun store(key: String, value: String) = storage.set(key, value)

}