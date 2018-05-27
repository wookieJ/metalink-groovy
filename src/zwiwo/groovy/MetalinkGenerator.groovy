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
        if(startDir == null)
            startDir = project.properties[START_DIR]
        def startDir = new File(startDir)
        MetalinkData metalinkData = new MetalinkData()
        startDir.eachFileRecurse(FileType.FILES) { file ->
            if (file.isFile()) {
                String hashValue = MD5Generator.generate(file)
                FileData fileData = new FileData(file, hashValue)
                println fileData
                metalinkData.add(fileData)
            }
        }
        println "size=" + metalinkData.files.size()
    }
}
