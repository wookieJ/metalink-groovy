package zwiwo.groovy

import java.time.LocalDate

class MetalinkData {
    LocalDate date
    def files = []

    MetalinkData() {
        date = LocalDate.now()
    }

    def add(FileData fileData) {
        files.add(fileData)
    }

    def printAll() {
        files.each {f -> println(f)}
    }
}
