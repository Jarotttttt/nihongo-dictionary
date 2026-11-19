package id.nihongodictionary.app.core.database.dictionary

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DictionaryDatabaseHelper @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        const val DB_NAME = "dictionary.db"
    }

    private var database: SQLiteDatabase? = null

    @Synchronized
    fun getReadableDatabase(): SQLiteDatabase {
        database?.let {
            if (it.isOpen) return it
        }

        val dbFile = context.getDatabasePath(DB_NAME)
        if (!dbFile.exists()) {
            copyDatabaseFromAssets(dbFile)
        }

        val db = SQLiteDatabase.openDatabase(
            dbFile.absolutePath,
            null,
            SQLiteDatabase.OPEN_READONLY or SQLiteDatabase.NO_LOCALIZED_COLLATORS
        )
        database = db
        return db
    }

    private fun copyDatabaseFromAssets(destFile: File) {
        destFile.parentFile?.let {
            if (!it.exists()) it.mkdirs()
        }

        try {
            context.assets.open(DB_NAME).use { input ->
                FileOutputStream(destFile).use { output ->
                    val buffer = ByteArray(16384)
                    var length: Int
                    while (input.read(buffer).also { length = it } > 0) {
                        output.write(buffer, 0, length)
                    }
                    output.flush()
                }
            }
        } catch (e: IOException) {
            throw IllegalStateException("Gagal mengekstraksi basis data kamus dari aset aplikasi", e)
        }
    }
}
