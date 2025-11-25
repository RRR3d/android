package io.hivebit.companion.android

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.hivebit.companion.android.common.util.MessagingToken
import io.hivebit.companion.android.common.util.MessagingTokenProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MinimalApplicationModule {
    @Provides
    @Singleton
    fun provideMessagingTokenProvider(): MessagingTokenProvider {
        return MessagingTokenProvider {
            return@MessagingTokenProvider MessagingToken("")
        }
    }
}
