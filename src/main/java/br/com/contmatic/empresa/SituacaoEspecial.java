package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

import java.util.Date;

public class SituacaoEspecial {

	public SituacaoEspecial(String status, Date data) {
		this.setStatus(status);
		this.setData(data);
	}

	public SituacaoEspecial(String status) {
		this.status = status;
	}

	private String status;

	private Date data;

	private String usuario;

	private Date dataAlteracao;

	private Date dataCadastro;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.statusNaoDeveSerNulo(status);
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		validarIntervalo(data);
		this.data = data;
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

	private void statusNaoDeveSerNulo(String status) {
		if (status == null) {
			throw new IllegalArgumentException("Situação especial não deve ser nula");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		SituacaoEspecial other = (SituacaoEspecial) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SituacaoEspecial [SituaçãoEspecial=" + status + "]";
	}
}
