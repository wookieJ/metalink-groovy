package zwiwo.groovy

import groovy.io.FileType
import org.apache.tools.ant.BuildException
import org.apache.tools.ant.Task

class MetalinkGenerator extends Task {
    String START_DIR = "start.directory"
    String DEST_DIR = "dest.directory"
    String startDir
    String destDir

    @Override
    void execute() throws BuildException {
        if (this.startDir == null)
            this.startDir = project.properties[START_DIR]
        if (destDir == null)
            destDir = project.properties[DEST_DIR]

        def startDir = new File(this.startDir)
        def destDir = new File(destDir)

        MetalinkData metalinkData = new MetalinkData()
        println metalinkData.date

        startDir.eachFileRecurse(FileType.FILES) { file ->
            if (file.isFile()) {
                String hashValue = MD5Generator.generate(file)
                Hash hash = new Hash("MD5", hashValue)
                FileData fileData = new FileData(file, hash)
                println fileData
                metalinkData.add(fileData)
            }
        }
        println "size=" + metalinkData.files.size()
        XMLGenerator xmlGenerator = new XMLGenerator(metalinkData, destDir)
        xmlGenerator.generate()
    }
}
