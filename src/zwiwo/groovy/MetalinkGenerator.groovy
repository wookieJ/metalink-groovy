package zwiwo.groovy

import groovy.io.FileType
import org.apache.tools.ant.BuildException
import org.apache.tools.ant.Task

class MetalinkGenerator extends Task {
    String USER_DIR = "user.directory"

    @Override
    void execute() throws BuildException {
        String userDir = project.properties[USER_DIR]

        def dir = new File(userDir)
        MetalinkData metalinkData = new MetalinkData()
        dir.eachFileRecurse(FileType.FILES) { file ->
            if (file.isFile()) {
                String hashValue = MD5Generator.generate(file)
                FileData fileData = new FileData(file, hashValue)
                println fileData
                metalinkData.add(fileData)
            }
        }
    }
}
