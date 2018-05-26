package zwiwo.groovy

import org.apache.tools.ant.Task

class ShowLanguages extends Task{
	private static languagesMapping = [PL:"Polish", EN:"English", DE:"German", FR:"French", RU:"Russian"]
	
	String mode = "debug"
	
	void execute()
	{
		def langs = project.properties["lang.$mode"]
		.split(/[ ]*, [ ]*/)
		.collect{languagesMapping[it]}
		.join(", ")
		println "Chosen languages: $langs"
	}
}
