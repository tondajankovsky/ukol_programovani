package internet.fehu.post

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.util.Log
import android.widget.Toast
import okio.FileHandle
import org.apache.commons.net.ftp.FTP
import org.apache.commons.net.ftp.FTPClient
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import kotlin.arrayOf
import kotlin.Boolean

open class FTPsomething  {
    companion object {
        var files = arrayOf<String>()
        val client = FTPClient()
        fun FUCKTHIS(hostname : String ,user : String, password : String, fileName : String) {
            try {
                client.connect(hostname)
                client.login(user, password)
                client.enterLocalPassiveMode()

                client.setFileType(FTP.BINARY_FILE_TYPE)
                val inputStream = FileInputStream(fileName)
                val done = (client.storeFile("test.php",inputStream ))
            }catch (e: java.lang.reflect.InvocationTargetException) {
                }finally {
                    client.logout()
                    client.disconnect()
                }
            }
        }
    }


