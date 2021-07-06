package test;

import model.Empregado;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.horasException;

public class EmpregadoTest {

	private Empregado empregado;
	
	@BeforeEach
	private void instanciaObjeto() {
		empregado = new Empregado();
		empregado.setNome("RODRIGO MIRANDA");
	}
	
	/** 
	 * Salario abaixo do minimo
	 **/
	
	@Test
	public void abaixoDoSalarioMinimo() {
		empregado.setHoras(15);
		empregado.setValorPorHora(70);
		assertEquals(1100.0, empregado.realizarPagamento(), 0.0001);
	}
	
	/** 
	 * Salario Dentro do Permitido
	 **/
	
	@Test
	public void acimaDoSalarioMinimo() {
		empregado.setHoras(10);
		empregado.setValorPorHora(140);
		assertEquals(1400.0, empregado.realizarPagamento(), 0.0001);
	}
	
	/** 
	 * valor hora invalido
	 **/
	
	@Test
	public void valorHoraInvalido(){
		empregado.setHoras(15);
		empregado.setValorPorHora(50);
		assertEquals(1100.0, empregado.realizarPagamento(), 0.0001);
	}
	
	
	/** 
	 * Horas trabalhadas Acima de 40
	 **/
	
	@Test
	public void horasAcimaPermitido() throws horasException {
		empregado.setHoras(42);
		assertEquals(40, empregado.getHoras());
	}


	/** 
	 * Horas trabalhadas abaixo de 40
	 **/
	
	@Test
	public void horasAbaixoPermitido() throws horasException{
		empregado.setHoras(35);
		assertEquals(35 ,empregado.getHoras());
	}

	/**Salario igual ao minimo
	 **/
	
	@Test
	public void salarioIgualAoMinimo() {
		empregado.setHoras(40);
		empregado.setValorPorHora(27.5);
		assertEquals(1100.0, empregado.realizarPagamento(), 0.0001);
	}

}
