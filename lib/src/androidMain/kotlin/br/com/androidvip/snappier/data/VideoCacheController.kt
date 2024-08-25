package br.com.androidvip.snappier.data

import android.content.Context
import com.google.android.exoplayer2.database.StandaloneDatabaseProvider
import com.google.android.exoplayer2.upstream.DefaultDataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.exoplayer2.upstream.FileDataSource
import com.google.android.exoplayer2.upstream.cache.CacheDataSink
import com.google.android.exoplayer2.upstream.cache.CacheDataSource
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor
import com.google.android.exoplayer2.upstream.cache.SimpleCache
import java.io.File

object VideoCacheController {
    private var cacheDataSourceFactory: CacheDataSource.Factory? = null
    private const val CACHE_SIZE_BYTES = 100L + 1024 * 1024
    private const val CACHE_DIR = "snappier_cache"

    fun getCacheDataSourceFactory(context: Context): CacheDataSource.Factory {
        if (cacheDataSourceFactory == null) {
            synchronized(this) {
                if (cacheDataSourceFactory == null) {
                    val upstreamFactory = DefaultDataSource.Factory(
                        context,
                        DefaultHttpDataSource.Factory()
                    )
                    val cache = SimpleCache(
                        File(context.cacheDir, CACHE_DIR),
                        LeastRecentlyUsedCacheEvictor(CACHE_SIZE_BYTES),
                        StandaloneDatabaseProvider(context)
                    )
                    cacheDataSourceFactory = CacheDataSource.Factory()
                        .setCache(cache)
                        .setCacheWriteDataSinkFactory(CacheDataSink.Factory().setCache(cache))
                        .setCacheReadDataSourceFactory(FileDataSource.Factory())
                        .setUpstreamDataSourceFactory(upstreamFactory)
                }
            }
        }
        return cacheDataSourceFactory!!
    }
}
