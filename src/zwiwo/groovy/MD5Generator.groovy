package zwiwo.groovy

class MD5Generator {
    def static generate( File file ) {
        def digest = java.security.MessageDigest.getInstance("MD5")
        file.eachByte( 4096 ) { buffer, length ->
            digest.update( buffer, 0, length )
        }
        def result = new BigInteger(1, digest.digest()).toString(16).padLeft(32, '0')
        return result
    }
}