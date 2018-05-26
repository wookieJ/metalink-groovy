package zwiwo.groovy

class Main {
	
	def hello() {
		println "Hello world!"
	}

	def run() {
		hello()
	}
	
	/**
	 * Application entry point
	 */
	static main(args) {
		new Main().run();
	}
}
