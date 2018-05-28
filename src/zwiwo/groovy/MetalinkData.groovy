package zwiwo.groovy

import groovy.transform.EqualsAndHashCode

import javax.xml.bind.annotation.*

@XmlRootElement
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.FIELD)
class MetalinkData {
    @XmlElement(name = "published")
    Date date
    @XmlElement(name = "file")
    @XmlElementWrapper(name = "files")
    List<FileData> files

    MetalinkData() {
        date = new Date()
        files = new ArrayList<>()
    }

    def add(FileData fileData) {
        files.add(fileData)
    }

    def printAll() {
        files.each { f -> println(f) }
    }
}
