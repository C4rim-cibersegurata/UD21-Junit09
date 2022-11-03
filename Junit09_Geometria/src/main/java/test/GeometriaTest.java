package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import JUnit.Junit09_Geometria.dto.Geometria;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
class GeometriaTest {
	
	Geometria gem;
	Geometria gem1;
	
	private static Stream<Arguments> getFormatFixture() {// argumentos para la prueba parametrizada
		return Stream.of(
				Arguments.of(1, "cuadrado"),
				Arguments.of(2, "Circulo"),
				Arguments.of(3, "Triangulo"),
				Arguments.of(4, "Rectangulo"),
				Arguments.of(5, "Pentagono"),
				Arguments.of(6, "Rombo"),
				Arguments.of(7, "Romboide"),
				Arguments.of(8, "Trapecio")
				);
	}
	
	@BeforeEach
	public void before() throws Exception {//crear el objeto con cada test
		gem = new Geometria();
		gem1 = new Geometria(70);//creamos este nuevo objeto para el constructor id de geometria
	}
	
	/*Tests de los metodos propios*/
	
	@Test
	public void testAreaCuadrado() {
		System.out.println("TestAreaCuadrado()");
		int result = gem.areacuadrado(3);
		int predict = 9;
		assertEquals(predict, result);
	}
	
	@Test
	public void testAreaCirculo() {
		System.out.println("TestAreaCirculo()");
		double result = gem.areaCirculo(1);
		double delta = 1.0;
		double predict = Math.PI;
		assertEquals(predict, result, delta);
	}
	
	@Test
	public void testAreaTriangulo() {
		System.out.println("TestAreaTriangulo()");
		int result = gem.areatriangulo(2, 5);
		int predict = 5;
		assertEquals(predict, result);
	}
	
	@Test
	public void testAreaRectangulo() {
		System.out.println("testAreaRectangulo()");
		int result = gem.arearectangulo(10, 3);
		int predict = 30;
		assertEquals(predict, result);
	}
	
	@Test
	public void testAreaPentagono() {
		System.out.println("testAreaPentagono()");
		int result = gem.areapentagono(12, 3);
		int predict = 18;
		assertEquals(predict, result);
	}
	
	@Test
	public void testAreaRombo() {
		System.out.println("testAreaRombo()");
		int result = gem.arearombo(10, 4);
		int predict = 20;
		assertEquals(predict, result);
	}
	
	@Test
	public void testAreaRomboide() {
		System.out.println("testAreaRomboide()");
		int result = gem.arearomboide(8, 3);
		int predict = 24;
		assertEquals(predict, result);
	}
	
	@Test
	public void testAreaTrapecio() {
		System.out.println("testAreaTrapecio()");
		int result = gem.areatrapecio(12,8,5);
		int predict = 50;
		assertEquals(predict, result);
	}
	@ParameterizedTest
	@MethodSource("getFormatFixture")// test parametrizado
	public void testFigura(int num, String predict) {
		System.out.println("testFigura()");
		assertEquals(predict, gem.figura(num));
	}
	
	/*Tests para los getters y setters*/
	
	@Test
	public void testSetterGetId() {
		System.out.println("testSetterGetId()");
		gem.setId(4);
		int predict = 4;
		assertEquals(predict, gem.getId());
	}
	
	@Test
	public void testSetterGetNom() {
		System.out.println("testSetterGetNom()");
		gem.setNom("Carim");;
		String predict = "Carim";
		assertEquals(predict, gem.getNom());
	}
	
	@Test
	public void testSetterGetArea() {
		System.out.println("testSetterGetArea()");
		gem.setArea(33);
		double predict = 33;
		assertEquals(predict, gem.getArea());
	}
	/*Test para el metodo toString*/
	public void testToString() {
		System.out.println("testToString()");//teniendo el id 70 nuestro objeto obtendrá
		String predict = "Geometria [id=70, nom=Default, area=0]";//el nombre por defecto con el metodo figura
		assertEquals(predict, gem1.toString());
		
	}
}
