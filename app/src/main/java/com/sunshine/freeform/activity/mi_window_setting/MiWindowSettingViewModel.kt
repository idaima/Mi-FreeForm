package com.sunshine.freeform.activity.mi_window_setting

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sunshine.freeform.room.DatabaseRepository
import com.sunshine.freeform.utils.ShellUtils

/**
 * @author sunshine
 * @date 2021/1/31
 */
class MiWindowSettingViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = DatabaseRepository(application)
    private val sp = application.getSharedPreferences("com.sunshine.freeform_preferences", Context.MODE_PRIVATE)

    fun getAllFreeFormApps(): LiveData<List<String>?> {
        return repository.getAllFreeForm()
    }

    fun getAllNotificationApps(): LiveData<List<String>?> {
        return repository.getAllNotification()
    }


}