package id.nihongodictionary.app.core.common

sealed class DataError(message: String, cause: Throwable? = null) : Exception(message, cause) {
    class Database(cause: Throwable) : DataError("Gagal mengakses basis data kamus", cause)
    class CorruptedFile(cause: Throwable) : DataError("Berkas basis data rusak atau tidak valid", cause)
    class NotFound(val identifier: String) : DataError("Entri tidak ditemukan: $identifier")
    class Local(cause: Throwable) : DataError("Kesalahan penyimpanan lokal", cause)
    class TtsUnavailable(val reason: String) : DataError("Mesin TextToSpeech Jepang tidak tersedia: $reason")
}
