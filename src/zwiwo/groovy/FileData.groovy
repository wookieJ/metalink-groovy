package zwiwo.groovy

import groovy.transform.EqualsAndHashCode

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.FIELD)
class FileData {
    @XmlAttribute(name = "name")
    String name
    String url
    Hash hash
    long size

    FileData() {}

    FileData(String name, String url, Hash hash, long size) {
        this.name = name
        this.url = url
        this.hash = hash
        this.size = size
    }

    FileData(File file, Hash hash) {
        this.name = file.getName()
        this.url = file.getAbsolutePath()
        this.hash = hash
        this.size = file.length()
    }

    @Override
    String toString() {
        return "name=" + name + ", url=" + url + ", hash=" + hash + ", size=" + size
    }
}
