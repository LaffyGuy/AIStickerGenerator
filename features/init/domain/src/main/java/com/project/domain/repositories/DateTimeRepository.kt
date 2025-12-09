package com.project.domain.repositories

import java.time.ZonedDateTime

interface DateTimeRepository {

    fun now(): ZonedDateTime
}