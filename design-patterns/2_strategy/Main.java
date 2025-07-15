interface FileCompressorInterface{
    void compress();
}

class ZipCompressor implements FileCompressorInterface{
    @Override
    public void compress() {
        System.out.println("this is zip compression");
    }
}

class GZipCompression implements FileCompressorInterface{
    @Override
    public void compress() {
        System.out.println("this is a gzip compression");
    }
}

class RARCompression implements FileCompressorInterface {
    @Override
    public void compress() {
        System.out.println("this is a rar compression");
    }
}


abstract class FileCompressor{
    FileCompressorInterface fileCompressorInterface;
    abstract void reFormat();

    FileCompressor(FileCompressorInterface fileCompressorInterface){
        this.fileCompressorInterface = fileCompressorInterface;
    }

    void setFileCompressor(FileCompressorInterface fileCompressorInterface){
        this.fileCompressorInterface = fileCompressorInterface;
    }

    void compress(){
        fileCompressorInterface.compress();
    }
}

class AutoFileCompressor extends FileCompressor{

    public AutoFileCompressor(FileCompressorInterface fileCompressorInterface){
        super(fileCompressorInterface);
    }

    void reFormat(){
        System.out.println("reformatting!!");
    }

}


public class Main{
    public static void main(String args[]){
        AutoFileCompressor autoFileCompressor = new AutoFileCompressor(new RARCompression());
        autoFileCompressor.compress();
        autoFileCompressor.setFileCompressor(new GZipCompression());
        autoFileCompressor.compress();
    }
}
class FileCompressorAlgos {
    public void zipCompression(){
        System.out.println("this is zip compression");
    }

    public void gZipCompression(){
        System.out.println("this is a gzip compression");
    }

    public void rarCompression(){
        System.out.println("this is a rar compression");
    }
}

class FileCompressorNaive{

    FileCompressorAlgos fileCompressorAlgos;
    String algo;

    public void setAlgo(String algo){
        this.algo = algo;
    }

    public void compressFile(){
        if(this.algo.equals("zip")){
            fileCompressorAlgos.zipCompression();
        }else{
            fileCompressorAlgos.gZipCompression();
        }
    }

    public static void main(String args[]){
        
    }
}


