public class Triangulo {
    private int A, B, C;
    private String tipo;

    public Triangulo() {

       // if((Math.abs(b-c) < a && a < (b+c)) && (Math.abs(a-c) < b && b < (a+c)) && (Math.abs(a-b) < c && a < (a+b))){
        //A = a;
       // B = b;
       // C = c;
       // tipo = this.tipoDoTriangulo(A, B, C);
    }


    public String tipoDoTriangulo(int a, int b, int c) {
    int  i = 0;

        if ((Math.abs(b - c) < a && a < (b + c)) && (Math.abs(a - c) < b && b < (a + c)) && (Math.abs(a - b) < c && a < (a + b))) {

            if (a == b) {
                i++;
            }
            if (a == c) {
                i++;
            }
            if (b == c) {
                i++;
            }

            if (i == 1) {
                return "Isóceles";
            }
            if (i == 0) {
                return "Escaleno";
            }
            if (i == 3) {
                return "Equilátero";
            }

        }


        return "Não é triangulo";
    }
}
