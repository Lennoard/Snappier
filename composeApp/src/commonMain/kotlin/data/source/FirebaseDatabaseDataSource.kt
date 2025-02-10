package data.source

import br.com.androidvip.snappier.data.models.ElementDTO
import dev.gitlive.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.flow

class FirebaseDatabaseDataSource(
    private val firebaseDatabase: FirebaseDatabase
): SnappierDataSource {
    override fun getElementById(elementId: String) = flow {
        val ref = firebaseDatabase.reference(EXAMPLE_PATH).child(elementId)
        ref.valueEvents.collect { snapshot ->
            emit(snapshot.value<ElementDTO>())
        }
    }

    companion object {
        private const val EXAMPLE_PATH = "example01"
    }
}
