package com.example.solarsystemclean.data.mapper

abstract class AbstractMapper<D, E> {
    abstract fun toEntity(dto: D): E

    open fun toEntityList(dtoList: List<D>): List<E> {
        return dtoList.map { toEntity(it) }
    }

    abstract fun toDto(entity: E): D

    open fun toDtoList(entityList: List<E>): List<D> {
        return entityList.map { toDto(it) }
    }
}