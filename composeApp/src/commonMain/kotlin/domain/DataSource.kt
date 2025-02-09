package domain

sealed interface DataSource {
    data object FirebaseDatabase : DataSource
    data object LocalApi : DataSource
    data object InMemory : DataSource
}
