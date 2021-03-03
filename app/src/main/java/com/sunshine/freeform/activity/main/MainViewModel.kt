package com.sunshine.freeform.activity.main

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.sunshine.freeform.room.DatabaseRepository
import com.sunshine.freeform.utils.ShellUtils

/**
 * @author sunshine
 * @date 2021/2/1
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val sp = application.getSharedPreferences("com.sunshine.freeform_preferences", Context.MODE_PRIVATE)
    private val repository = DatabaseRepository(application)

    fun isShowFloating(): Boolean {
        return sp.getBoolean("switch_floating", false)
    }

    fun isNotification(): Boolean {
        return sp.getBoolean("switch_notify", false)
    }

    /**
     * 关闭本地服务
     */
    fun closeService() {
        sp.edit().apply {
            putBoolean("switch_service", false)
            putBoolean("switch_floating", false)
            putBoolean("switch_notify", false)
            apply()
        }
    }

    /**
     * 远程服务是否开启
     */
    fun serviceIsClose(): Boolean {
        val pid = ShellUtils.execCommand("ps -ef | grep com.sunshine.freeform.Server | grep -v grep | awk '{print \$2}'", true).successMsg
        return pid.isNullOrBlank()
    }

    fun getControlModel(): Int {
        return sp.getInt("freeform_control_model", 1)
    }

    fun getAllFreeFormApps(): LiveData<List<String>?> {
        return repository.getAllFreeForm()
    }

    fun getAllNotificationApps(): LiveData<List<String>?> {
        return repository.getAllNotification()
    }
}