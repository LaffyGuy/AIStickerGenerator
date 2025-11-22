package com.project.core.common_android

import android.content.Context
import com.project.core.essentials.resources.StringResources
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AndroidStringResources @Inject constructor(
    @ApplicationContext private val context: Context,
) : StringResources {

    override fun getString(resId: Int, vararg args: Any?): String {
        return context.getString(resId, *args)
    }
}
