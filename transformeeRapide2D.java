public class transformeeRapide2D {
    public static void main(String[] args) {
        
        int[][] image = {{3,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

        ImgComplexe2D img = new ImgComplexe2D(image[0].length, image.length);
        for(int j = 0; j < image[0].length; j++)
            for (int i = 0; i < image.length; i++){
                img.reel[j][i] = image[j][i];
                img.imag[j][i] = 0.0;
            }

        ImgComplexe2D o = rapide2D(img);
        affiche(o);

    }

    public static class ImgComplexe1D{

        public double[] reel;
        public double[] imag;

        public ImgComplexe1D(int longueur){
            reel = new double[longueur];
            imag = new double[longueur];
        }

    }

    public static class ImgComplexe2D{

        public double[][] reel;
        public double[][] imag;

        public ImgComplexe2D(int longueur, int hauteur){
            reel = new double[longueur][hauteur];
            imag = new double[longueur][hauteur];
        }

    }

    public static ImgComplexe2D rapide2D(ImgComplexe2D image){

        int N = image.reel.length;
        ImgComplexe1D ligne = new ImgComplexe1D(N);

        for (int i = 0; i < N; i++){

        }

        return null;
    }

    public static void affiche(ImgComplexe2D image){
        int M = image.reel[0].length;
        int N = image.reel.length;

        for (int i = 0; i < M; i++){
            System.out.print("[ ");
            for (int j = 0; j < N; j++){
                    System.out.print("[ " + image.reel[i][j] + "i" + image.imag[i][j] + " ] ");
            }
            System.out.println(" ]");
        }
    }

}
