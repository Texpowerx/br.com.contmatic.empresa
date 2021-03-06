package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contato {

	private String email;

	private Telefone telefone;

	private String usuario;

	private Date dataAlteracao;

	private Date dataCadastro;

	public Contato(String email, Telefone telefone) {
		this.setEmail(email);
		this.setTelefone(telefone);
	}

	public Contato(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.emailDaEmpresaNaoDeveSerNulo(email);
		this.emailDaEmpresaDeveSerValido(email);
		this.email = email;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefoneNaoDeveSerNulo(telefone);
		this.telefone = telefone;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		usuarioNaoDeveSerNulo(usuario);
		this.usuario = usuario;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date data) {
		validarIntervalo(data);
		this.dataAlteracao = data;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date data) {
		validarIntervalo(data);
		this.dataCadastro = data;
	}

	private void usuarioNaoDeveSerNulo(String usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Usuario Não Deve Ser Nulo");
		}
	}

	private void telefoneNaoDeveSerNulo(Telefone telefone) {
		if (telefone == null) {
			throw new IllegalArgumentException("Telefone da Empresa não deve ser nulo");
		}
	}

	private void emailDaEmpresaNaoDeveSerNulo(String email) {
		if (email == null) {
			throw new IllegalArgumentException("Email da Empresa não deve ser nulo");
		}
	}

	private void emailDaEmpresaDeveSerValido(String email) {
		if (!this.validarEmail(email)) {
			throw new IllegalStateException("Este email não é valido");
		}
	}

	private boolean validarEmail(String email) {
		boolean isEmailIdValid = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailIdValid = true;
			}
		}
		return isEmailIdValid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contato [email=" + email + ", telefone=" + telefone + "]";
	}
}
