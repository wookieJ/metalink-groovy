package zwiwo.groovy

import groovy.io.FileType
import org.apache.tools.ant.BuildException
import org.apache.tools.ant.Task
import org.apache.tools.ant.types.FileSet

class MetalinkGenerator extends Task {
    String URL = "url.directory"
    String FILE = "file.directory"
    String url
    String file
    Vector filesets = new Vector()
    MetalinkData metalinkData = new MetalinkData()

    @Override
    void execute() throws BuildException {
        if (this.url == null)
            this.url = project.properties[URL]
        if (file == null)
            file = project.properties[FILE]

        filesets.each { FileSet fileSet ->
            addFiles(fileSet.getDir())
        }

        XMLGenerator xmlGenerator = new XMLGenerator(metalinkData, new File(file))
        xmlGenerator.generate()
    }

    def addFiles(File file) {
        file.eachFileRecurse(FileType.FILES) { f ->
            if (f.isFile()) {
                addMetalinkData(f)
            }
        }
    }

    private void addMetalinkData(File file) {
        String hashValue = MD5Generator.generate(file)
        Hash hash = new Hash("MD5", hashValue)
        FileData fileData = new FileData(file, hash)
        metalinkData.add(fileData)
    }
    
    void addFileset(FileSet fileset) {
        filesets.add(fileset)
    }
}
