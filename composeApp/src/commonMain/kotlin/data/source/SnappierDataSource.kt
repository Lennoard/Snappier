package data.source

import br.com.androidvip.snappier.domain.component.base.Element
import kotlinx.coroutines.flow.Flow

interface SnappierDataSource {
    fun getElementById(elementId: String): Flow<Element>
}