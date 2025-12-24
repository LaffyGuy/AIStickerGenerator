package com.project.data.stickergenerate.remote

import com.project.data.stickergenerate.remote.dto.GenerateImageRequestDto
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

internal interface StickerGenerationApi {

    @POST("models/stabilityai/stable-diffusion-xl-base-1.0")
    suspend fun generateSticker(
        @Header("Authorization") auth: String,
        @Body request: GenerateImageRequestDto
    ): Response<ResponseBody>
}