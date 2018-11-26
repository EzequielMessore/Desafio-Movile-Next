package br.com.movilenext.taco.base

import android.support.test.InstrumentationRegistry
import android.util.Log
import java.io.IOException
import java.nio.charset.Charset

fun readFixture(file: String): String {
    val path = "fixtures/"
    var json = ""
    try {
        val `is` = InstrumentationRegistry.getContext().assets.open(path + file)
        val size = `is`.available()
        val buffer = ByteArray(size)
        `is`.read(buffer)
        `is`.close()
        json = String(buffer, Charset.forName("UTF-8"))
    } catch (e: IOException) {
        Log.e("TEST", "readFixture: ", e)
        return json
    }

    return json
}