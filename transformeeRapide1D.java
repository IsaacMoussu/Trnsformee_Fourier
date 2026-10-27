public class transformeeRapide1D {
    public static void main(String[] args) {
        
        int[] image = {1,0,0,0};

        ImgComplexe1D img = new ImgComplexe1D(image.length);
        for (int i = 0; i < image.length; i++){
            img.reel[i] = image[i];
            img.imag[i] = 0.0;
        }

        ImgComplexe1D Ô = direct(image);
        ImgComplexe1D Î = rapide(img);
        
        affiche(Ô);
        System.out.println();
        affiche(Î);
    }

    public static class ImgComplexe1D{

        public double[] reel;
        public double[] imag;

        public ImgComplexe1D(int longueur){
            reel = new double[longueur];
            imag = new double[longueur];
        }

    }

    public static ImgComplexe1D direct(int[] image){

        int N = image.length;
        ImgComplexe1D Î = new ImgComplexe1D(N);

        for (int i = 0; i < N; i++){
            double sumReel = 0;
            double sumImag = 0;

            for (int j = 0; j < N; j++){
                double angle = 2 * Math.PI * ((double)(i*j) / N);
                sumReel += image[j] * Math.cos(angle);
                sumImag -= image[j] * Math.sin(angle);
            }
            Î.reel[i] = sumReel;
            Î.imag[i] = sumImag;
        }

        return Î;
    }

    public static ImgComplexe1D rapide(ImgComplexe1D image){

        int N = image.reel.length;
        ImgComplexe1D Î = new ImgComplexe1D(N);

        if(N == 1){
            Î.reel[0] = image.reel[0];
            Î.imag[0] = image.imag[0];

            return Î;
        } else {
            ImgComplexe1D img1 = new ImgComplexe1D(N/2);
            ImgComplexe1D img2 = new ImgComplexe1D(N/2);

            for (int i = 0; i < N; i++){
                if(i%2 == 0){
                    img1.reel[i/2] = image.reel[i];
                    img1.imag[i/2] = image.imag[i];
                } else {
                    img2.reel[i/2] = image.reel[i];
                    img2.imag[i/2] = image.imag[i];
                }
            }

            ImgComplexe1D pair = rapide(img1);
            ImgComplexe1D impair = rapide(img2);

            for (int j = 0; j < N/2; j++){
                double angle = -2 * Math.PI * j / N;
                double constReel = Math.cos(angle);
                double constImag = Math.sin(angle);

                double sumReel = constReel * impair.reel[j] - constImag * impair.imag[j];
                double sumImag = constReel * impair.imag[j] + constImag * impair.reel[j];

                Î.reel[j] = pair.reel[j] + sumReel;
                Î.imag[j] = pair.imag[j] + sumImag;

                Î.reel[j + N/2] = pair.reel[j] - sumReel;
                Î.imag[j + N/2] = pair.imag[j] - sumImag;
            }

            return Î;
        }
    }

    

    public static void affiche(ImgComplexe1D image){
        int N = image.reel.length;

        for (int i = 0; i < N; i++){
            
            System.out.print("[ " + image.reel[i] + "i" + image.imag[i] + " ] ");
        }
    }
}
