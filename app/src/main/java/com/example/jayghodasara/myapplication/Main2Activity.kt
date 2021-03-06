package com.example.jayghodasara.myapplication

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        var packagename = applicationContext.packageName.toString()
        var label: String = applicationInfo.loadLabel(packageManager).toString()

        var packageInfo: PackageInfo = packageManager.getPackageInfo(packageName, 0)
        var version: Int = packageInfo.versionCode
        var version_name: String = packageInfo.versionName.toString()
        var version_os: String? = android.os.Build.VERSION.RELEASE

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = displayMetrics.heightPixels
        val width = displayMetrics.widthPixels

        val deviceName = Build.MANUFACTURER+ " "+ Build.MODEL


        value.text = "Package Name:- " + packagename + "\n" +
                "Label:- " + label + "\n" +
                "Version:- " + version + "\n" +
                "Version name:- " + version_name + "\n" +
                "Version OS:- " + version_os + "\n" +
                "Height:- " + height + "\n" +
                "Width:- " + width + "\n" +
                "Device Name:- " + deviceName

    }
}
