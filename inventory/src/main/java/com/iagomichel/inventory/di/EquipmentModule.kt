package com.iagomichel.inventory.di

import com.iagomichel.inventory.data.local.dao.EquipmentDao
import com.iagomichel.inventory.data.repository.EquipmentRepositoryImpl
import com.iagomichel.inventory.domain.usecase.GetFilteredEquipmentsUseCase
import com.iagomichel.inventory.domain.usecase.GetFilteredEquipmentsUseCaseImpl
import com.iagomichel.inventory.domain.usecase.SaveEquipmentUseCase
import com.iagomichel.inventory.domain.usecase.SaveEquipmentUseCaseImpl
import com.iagomichel.inventory.repository.EquipmentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object EquipmentModule {

    @Provides
    fun provideEquipmentRepository(dao: EquipmentDao): EquipmentRepository {
        return EquipmentRepositoryImpl(dao)
    }

    @Provides
    fun provideSaveEquipmentUseCase(repository: EquipmentRepository): SaveEquipmentUseCase {
        return SaveEquipmentUseCaseImpl(repository)
    }

    @Provides
    fun provideGetFilteredEquipmentsUseCase(repository: EquipmentRepository): GetFilteredEquipmentsUseCase {
        return GetFilteredEquipmentsUseCaseImpl(repository)
    }
}
