package data.source

import br.com.androidvip.snappier.data.models.ElementDTO
import dev.gitlive.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.flow

class FirebaseDatabaseDataSource(
    private val firebaseDatabase: FirebaseDatabase
): SnappierDataSource {
    override fun getHomeScreenElement() = flow {
        val ref = firebaseDatabase.reference(HOME_SCREEN_PATH)
        ref.valueEvents.collect { snapshot ->
            emit(snapshot.value<ElementDTO>())
        }
    }

    companion object {
        private const val HOME_SCREEN_PATH = "/example02/home"
    }
}
