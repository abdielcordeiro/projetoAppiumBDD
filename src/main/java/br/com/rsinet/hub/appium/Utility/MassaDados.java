package br.com.rsinet.hub.appium.Utility;

import java.util.Random;

public class MassaDados {

	private int linhaTipo = 2;
	private int linhaCadastro = 1;
	private static int linhaFalha = 9;

	public void proximaLinha() {
		this.linhaCadastro += 1;
	}

	public void setNomeUsuario(String nome) throws Exception {
		ExcelUtils.setCellData(nome, linhaCadastro, Constant.Usuario);
	}

	public String getNomeUsuarioExcel() throws Exception {
		return ExcelUtils.getCellDataString(linhaCadastro, Constant.Usuario);
	}

	public String getNomeUsuario(int quantidadeLetra) {
		Random quantidadedeletras = new Random();
		int index;

		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVYWXZabcdefghijklmnopqrstuvxwyz0123456789";
		String palavraRandom = "";

		for (int i = 0; i <= quantidadeLetra - 1; i++) {
			index = quantidadedeletras.nextInt(caracteres.length());
			palavraRandom += caracteres.substring(index, index + 1);
		}
		return palavraRandom;
	}

	public String getSenha() throws Exception {
		return ExcelUtils.getCellDataString(linhaCadastro, Constant.Senha);
	}

	public String getEmail() throws Exception {
		return ExcelUtils.getCellDataString(linhaCadastro, Constant.Email);
	}

	public String getPrimeiroNome() throws Exception {
		return ExcelUtils.getCellDataString(linhaCadastro, Constant.PrimeiroNome);
	}

	public String getUltimoNome() throws Exception {
		return ExcelUtils.getCellDataString(linhaCadastro, Constant.UltimoNome);
	}

	public String getNumeroTelefone() throws Exception {
		return ExcelUtils.getCellDataString(linhaCadastro, Constant.NumeroTelefone);
	}

	public String getCidade() throws Exception {
		return ExcelUtils.getCellDataString(linhaCadastro, Constant.Cidade);
	}

	public String getNomeProduto() throws Exception {
		return ExcelUtils.getCellDataString(linhaTipo, Constant.NomeProduto);
	}

	public String getNomeProdutoFalha() throws Exception {
		return ExcelUtils.getCellDataString(linhaFalha, Constant.NomeProdutoFalha);
	}

	public String getTipoProduto() throws Exception {
		return ExcelUtils.getCellDataString(linhaTipo, Constant.TipoProduto);
	}

	public Integer getQuantidadeProduto() throws Exception {
		return Integer.valueOf(ExcelUtils.getCellDataNumber(linhaCadastro, Constant.QuantidadeProduto));
	}

}
