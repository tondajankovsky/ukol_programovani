package internet.fehu.post

import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException


class file_manip {
    companion object {
        fun myChange(file : File, input: String) {
            try {
                file.writeText(input)

            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }

}
