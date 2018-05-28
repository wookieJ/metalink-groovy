package zwiwo.groovy

import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBException
import javax.xml.bind.Marshaller

class XMLGenerator {
    File destFile
    MetalinkData metalinkData

    XMLGenerator(MetalinkData metalinkData, File destDir) {
        this.destFile = destDir
        this.metalinkData = metalinkData
    }

    void generate() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(metalinkData.getClass())
        Marshaller m = context.createMarshaller()
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)
        m.marshal(metalinkData, destFile)
    }
}
