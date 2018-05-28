package zwiwo.groovy

import groovy.transform.EqualsAndHashCode

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlAttribute
import javax.xml.bind.annotation.XmlRootElement
import javax.xml.bind.annotation.XmlValue

@XmlRootElement
@EqualsAndHashCode
@XmlAccessorType(XmlAccessType.FIELD)
class Hash {
    @XmlAttribute(name = "type")
    String type
    @XmlValue
    String value

    Hash(String type, String value) {
        this.type = type
        this.value = value
    }

    Hash() {
    }
}
