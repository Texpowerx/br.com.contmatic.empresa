package br.com.contmatic.empresa;

import static br.com.contmatic.empresa.util.Constantes.STRING_MAX_LENGTH;
import static br.com.contmatic.empresa.util.Datas.definirData;
import static br.com.contmatic.empresa.util.Datas.validarIntervalo;

import java.util.Date;

public class SituacaoCadastral {

	private String motivo;

	private String status;

	private Date data;

	private String usuario;

	private Date dataAlteracao;

	private Date dataCadastro;

	public SituacaoCadastral(String motivo, String status, int year, int month, int date) {
		this.setMotivo(motivo);
		this.setStatus(status);
		this.setData(year, month, date);
	}

	public Date getDataSituacaoCadastral() {
		return data;
	}

	public void setData(int year, int month, int date) {
		validarIntervalo(definirData(year, month, date));
		this.data = definirData(year, month, date);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.statusNaoDeveSerNulo(status);
		this.statusNaoDeveUltrapassarOLimiteDeCaracteres(status);
		this.status = status;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivoNaoDeveSerNulo(motivo);
		this.motivoNaoDeveUltrapassarLimiteDeCaracteres(motivo);
		this.motivo = motivo;
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

	public void setDataAlteracao(int year, int month, int date) {
		validarIntervalo(dataAlteracao);
		this.dataAlteracao = definirData(year, month, date);
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(int year, int month, int date) {
		validarIntervalo(dataCadastro);
		this.dataCadastro = definirData(year, month, date);
	}

	private void usuarioNaoDeveSerNulo(String usuario) {
		if (usuario == null) {
			throw new IllegalArgumentException("Usuario Não Deve Ser Nulo");
		}
	}

	private void statusNaoDeveSerNulo(String status) {
		if (status == null) {
			throw new IllegalArgumentException("A Situação Cadastral não deve ser nula");
		}
	}

	private void motivoNaoDeveUltrapassarLimiteDeCaracteres(String motivo) {
		if (motivo.length() > STRING_MAX_LENGTH) {
			throw new IllegalArgumentException("O Motivo da Situação Cadastral não deve ultrapassar 255 caracteres");
		}
	}

	private void motivoNaoDeveSerNulo(String motivo) {
		if (motivo == null) {
			throw new IllegalArgumentException("O Motivo da Situação Cadastral não deve ser nulo");
		}
	}

	private void statusNaoDeveUltrapassarOLimiteDeCaracteres(String status) {
		if (status.length() > STRING_MAX_LENGTH) {
			throw new IllegalArgumentException("A Situação Cadastral não deve ultrapassar 255 caracteres");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((motivo == null) ? 0 : motivo.hashCode());
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
		SituacaoCadastral other = (SituacaoCadastral) obj;
		if (motivo == null) {
			if (other.motivo != null)
				return false;
		} else if (!motivo.equals(other.motivo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SituacaoCadastral [motivo=" + motivo + ", status=" + status + ", data=" + data + "]";
	}
}
