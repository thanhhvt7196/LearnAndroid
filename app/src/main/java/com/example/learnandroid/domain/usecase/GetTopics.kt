package com.example.learnandroid.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.learnandroid.data.pagination.TopicPagingDataSource
import com.example.learnandroid.domain.models.Topic
import com.example.learnandroid.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetTopics @Inject constructor(private val photoRepository: PhotoRepository) :
    PagingUseCase<Topic, Unit>() {
    override fun buildFlow(params: Unit): Flow<PagingData<Topic>> {
        return Pager(
            config = PagingConfig(10, 5),
            pagingSourceFactory = { TopicPagingDataSource(photoRepository) }
        ).flow.map { pagingData ->
            pagingData.map { entity ->
                Topic.fromEntity(entity)
            }
        }
    }

}