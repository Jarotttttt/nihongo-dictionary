package id.nihongodictionary.app.core.database.dictionary

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
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
        const val REQUIRED_VERSION = 2
        private const val TAG = "DictDbHelper"
    }

    private var database: SQLiteDatabase? = null

    @Synchronized
    fun getReadableDatabase(): SQLiteDatabase {
        database?.let {
            if (it.isOpen) return it
        }

        val dbFile = context.getDatabasePath(DB_NAME)
        val needsCopy = if (!dbFile.exists()) {
            Log.i(TAG, "File database belum ada di storage lokal. Memulai ekstraksi dari aset...")
            true
        } else {
            try {
                SQLiteDatabase.openDatabase(dbFile.absolutePath, null, SQLiteDatabase.OPEN_READONLY).use { checkDb ->
                    val currentVersion = checkDb.version
                    Log.i(TAG, "Versi database saat ini: $currentVersion, Versi target: $REQUIRED_VERSION")
                    currentVersion < REQUIRED_VERSION
                }
            } catch (e: Exception) {
                Log.w(TAG, "Gagal memeriksa versi database yang ada, akan mengekstrak ulang.", e)
                true
            }
        }

        if (needsCopy) {
            database?.close()
            database = null
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

        val tempFile = File(destFile.parentFile, "$DB_NAME.tmp")
        if (tempFile.exists()) {
            tempFile.delete()
        }

        Log.i(TAG, "Mengekstraksi basis data kamus produksi (${destFile.name})...")
        try {
            context.assets.open(DB_NAME).use { input ->
                FileOutputStream(tempFile).use { output ->
                    val buffer = ByteArray(65536)
                    var length: Int
                    while (input.read(buffer).also { length = it } > 0) {
                        output.write(buffer, 0, length)
                    }
                    output.flush()
                }
            }

            if (destFile.exists()) {
                destFile.delete()
            }

            if (!tempFile.renameTo(destFile)) {
                tempFile.copyTo(destFile, overwrite = true)
                tempFile.delete()
            }
            Log.i(TAG, "Ekstraksi basis data selesai! Ukuran: ${destFile.length() / (1024 * 1024)} MB")
        } catch (e: IOException) {
            tempFile.delete()
            Log.e(TAG, "Gagal mengekstraksi basis data kamus", e)
            throw IllegalStateException("Gagal mengekstraksi basis data kamus dari aset aplikasi", e)
        }
    }
}
