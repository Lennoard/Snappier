package domain.repository

import br.com.androidvip.snappier.domain.component.base.Element
import domain.DataSource
import kotlinx.coroutines.flow.Flow

interface SnappierRepository {
    suspend fun getHomeScreenElement(source: DataSource): Flow<Element>
}
