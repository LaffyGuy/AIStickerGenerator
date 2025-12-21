package com.project.features.domain

interface GenerateIconUseCase {

    suspend operator fun invoke(prompt: String): String
}