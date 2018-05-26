package zwiwo.groovy

class FileData {
    String name
    String url
    String hash
    long size

    FileData(String name, String url, String hash, long size) {
        this.name = name
        this.url = url
        this.hash = hash
        this.size = size
    }

    FileData(File file, String hashValue) {
        this.name = file.getName()
        this.url = file.getAbsolutePath()
        this.hash = hashValue
        this.size = file.length()
    }

    @Override
    String toString() {
        return "name=" + name + ", url=" + url + ", hash=" + hash + ", size=" + size
    }
}
