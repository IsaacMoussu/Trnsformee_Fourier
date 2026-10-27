class transformeeInverseRapide2D{

    public static void main(String[] args) {


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