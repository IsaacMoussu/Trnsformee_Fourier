public class transformeeDirecte {
    public static void main(String[] args) {
        
        int[][] image = {{3,0,0},{0,0,0},{0,0,0}};
        ImgComplexe Î = I(image);
        affiche(Î);


    }

    public static class ImgComplexe{

        public double[][] reel;
        public double[][] imag;

        public ImgComplexe(int longueur, int hauteur){
            reel = new double[longueur][hauteur];
            imag = new double[longueur][hauteur];
        }

    }

    public static ImgComplexe I(int[][] image){

        int M = image[0].length;
        int N = image.length;
        ImgComplexe Î = new ImgComplexe(M, N);

        for (int k = 0; k < M; k++)
            for (int l = 0; l < N; l++){
                double sumReel = 0;
                double sumImag = 0;

                for (int i = 0; i < M; i++)
                    for (int j = 0; j < N; j++){
                        double angle = 2 * Math.PI * ((double)(k*i) / M + (double)(l*j) / N);
                        sumReel += image[i][j] * Math.cos(angle);
                        sumImag -= image[i][j] * Math.sin(angle);
                    }
                Î.reel[k][l] = sumReel;
                Î.imag[k][l] = sumImag;
            }

        return Î;
    }

    public static void affiche(ImgComplexe image){
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
