package data.repository

import br.com.androidvip.snappier.domain.component.base.Element
import data.source.SnappierDataSource
import domain.DataSource
import domain.repository.SnappierRepository
import kotlinx.coroutines.flow.Flow

class SnappierRepositoryImpl(
    private val apiDataSource: SnappierDataSource,
    private val inMemoryDataSource: SnappierDataSource
): SnappierRepository {
    override suspend fun getElementById(elementId: String, source: DataSource): Flow<Element> {
        return when (source) {
            DataSource.LocalApi -> apiDataSource.getElementById(elementId)
            DataSource.InMemory -> inMemoryDataSource.getElementById(elementId)
        }
    }
}