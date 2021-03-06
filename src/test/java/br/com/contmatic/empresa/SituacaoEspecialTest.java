package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SituacaoEspecialTest {

	SituacaoEspecial sitEspecial = null;
	
	SituacaoEspecial sitEspecial2 = null;
	
	SituacaoEspecial sitEspecial3 = null;
	
	SituacaoEspecial sitEspecial4 = null;
	
	SituacaoEspecial sitEspecial5 = null;

	@BeforeAll
	public static void init() {
		System.out.println("Iniciando os Testes de Situação Especial");
	}

	@BeforeEach
	public void initEach() throws ParseException {
		sitEspecial = new SituacaoEspecial("INATIVA", new Date());
		sitEspecial.setUsuario("Alexandre");
		sitEspecial2 = new SituacaoEspecial("INATIVA", new Date());
		sitEspecial3 = new SituacaoEspecial("ATIVA", new Date());
		sitEspecial4 = new SituacaoEspecial(null);
		sitEspecial5 = new SituacaoEspecial(null);
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("Finalizando os testes de Situação Especial");
	}

	@Test
	@Order(2)
	void situacao_especial_nao_deve_ser_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			sitEspecial.setStatus(null);
		});
	}

	@Test
	@Order(1)
	void testar_dados_validos() {
		this.deve_aceitar_data_de_alteracao_valida();
		this.deve_aceitar_data_de_cadastro_valida();
		this.deve_aceitar_data_valida();
		this.deve_aceitar_status_valido();
		this.deve_aceitar_usuario_valido();
	}

	@Test
	@Order(3)
	void toString_deve_retornar_corretamente() {
		assertEquals("SituacaoEspecial [SituaçãoEspecial=INATIVA]", sitEspecial.toString());
	}

	@Test
	void nao_deve_aceitar_usuario_nulo() {
		assertThrows(IllegalArgumentException.class, () -> {
			sitEspecial.setUsuario(null);
		});
	}
	
	@Test
	void deve_aceitar_hashcode_valido() {
		assertEquals(sitEspecial.hashCode(), sitEspecial2.hashCode());
	}
	
	@Test
	void nao_deve_aceitar_hashcode_diferente() {
		assertEquals(false, sitEspecial3.hashCode() == sitEspecial.hashCode());
	}
	
	@Test
	void teste_equals() {
		assertEquals(true,sitEspecial.equals(sitEspecial));
		assertEquals(false,sitEspecial.equals(null));
		assertEquals(false,sitEspecial.equals(1));
		assertEquals(false,sitEspecial.equals(sitEspecial3));
		assertEquals(false,sitEspecial4.equals(sitEspecial));
		assertEquals(true,sitEspecial.equals(sitEspecial2));
		assertEquals(true,sitEspecial4.equals(sitEspecial5));
		assertEquals(true,sitEspecial.hashCode() == sitEspecial2.hashCode());
		assertEquals(false,sitEspecial4.hashCode() == sitEspecial2.hashCode());
	}

	
	@Test
	void nao_deve_aceitar_status_diferentes() {
		assertEquals(true,sitEspecial.getStatus().equals(sitEspecial2.getStatus()));
	}

	private void deve_aceitar_usuario_valido() {
		assertEquals("Alexandre", sitEspecial.getUsuario());
	}

	private void deve_aceitar_data_de_alteracao_valida() {
		sitEspecial.setDataAlteracao(new Date());
		assertEquals(new Date(), sitEspecial.getDataAlteracao());
	}

	private void deve_aceitar_data_de_cadastro_valida() {
		sitEspecial.setDataCadastro(new Date());
		assertEquals(new Date(), sitEspecial.getDataCadastro());
	}

	private void deve_aceitar_data_valida() {
		assertEquals(new Date(), sitEspecial.getData());
	}

	private void deve_aceitar_status_valido() {
		assertEquals("INATIVA", sitEspecial.getStatus());
	}
}