import org.junit.Assert;
import org.junit.Test;

public class TestaTriangulo {

    @Test
    public void testarTriangulo() {

        Triangulo triangulo = new Triangulo();
        Assert.assertEquals("Não é triangulo", "Não é triangulo",triangulo.tipoDoTriangulo(0,0,0));
        Assert.assertEquals("Não é triangulo", "Não é triangulo",triangulo.tipoDoTriangulo(10,1,2));
        Assert.assertEquals("Não é triangulo", "Não é triangulo",triangulo.tipoDoTriangulo(-10,-1,-2));
        Assert.assertEquals("Não é triangulo", "Não é triangulo",triangulo.tipoDoTriangulo(-10,1,-2));
        Assert.assertEquals("Não é triangulo", "Não é triangulo",triangulo.tipoDoTriangulo(-10,1,2));
        Assert.assertEquals("Não é triangulo", "Não é triangulo",triangulo.tipoDoTriangulo(10,-1,-2));
        Assert.assertEquals("Não é triangulo", "Não é triangulo",triangulo.tipoDoTriangulo(10,-1,2));
        Assert.assertEquals("Não é triangulo", "Não é triangulo",triangulo.tipoDoTriangulo(0,1,2));
        Assert.assertEquals("Não é triangulo", "Não é triangulo",triangulo.tipoDoTriangulo(10,1,0));
        Assert.assertEquals("Não é triangulo", "Não é triangulo",triangulo.tipoDoTriangulo(10,0,2));

    }

    @Test
    public void testarIsoceles() {

        Triangulo triangulo = new Triangulo();
        Assert.assertEquals("Isóceles", "Isóceles",triangulo.tipoDoTriangulo(4,5,5));
        Assert.assertEquals("Isóceles", "Isóceles",triangulo.tipoDoTriangulo(5,4,5));
        Assert.assertEquals("Isóceles", "Isóceles",triangulo.tipoDoTriangulo(5,5,4));

    }

    @Test
    public void testarEquilatero() {

        Triangulo triangulo = new Triangulo();
        Assert.assertEquals("Equilátero", "Equilátero",triangulo.tipoDoTriangulo(5,5,5));

    }

    @Test
    public void testarEscaleno() {

        Triangulo triangulo = new Triangulo();
        Assert.assertEquals("Escaleno", "Escaleno",triangulo.tipoDoTriangulo(5,4,3));

    }
}
