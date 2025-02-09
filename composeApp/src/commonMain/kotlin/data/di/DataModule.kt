package data.di

import data.repository.SnappierRepositoryImpl
import data.source.FirebaseDatabaseDataSource
import data.source.InMemoryDataSource
import data.source.LocalApiDataSource
import data.source.SnappierDataSource
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.database.database
import domain.DataSource
import domain.repository.SnappierRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.named
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    factory {
        HttpClient {
            install(Logging)
            install(ContentNegotiation) { json() }
        }
    }

    single { Firebase.database }

    singleOf(::LocalApiDataSource) {
        named<DataSource.LocalApi>()
        bind<SnappierDataSource>()
    }

    singleOf(::FirebaseDatabaseDataSource) {
        named<DataSource.FirebaseDatabase>()
        bind<SnappierDataSource>()
    }

    single<SnappierDataSource>(qualifier = named<DataSource.InMemory>()) {
        InMemoryDataSource
    }

    single<SnappierRepository> {
        SnappierRepositoryImpl(
            apiDataSource = get(named<DataSource.LocalApi>()),
            firebaseDataSource = get(named<DataSource.FirebaseDatabase>()),
            inMemoryDataSource = get(named<DataSource.InMemory>())
        )
    }
}