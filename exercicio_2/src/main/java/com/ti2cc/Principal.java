package com.ti2cc;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		DAO dao = new DAO();
		dao.conectar();

		int codigo = 0, opcao = 0;
		String login = "", senha = "";
		char sexo = ' ';

		Usuario[] usuarios = dao.getUsuarios();
		Usuario usuario = new Usuario(codigo, login, senha, sexo);

		System.out.println("Selecione uma das opções abaixo: ");
		System.out.println(" ");

		while (opcao != 5) {

			// Opções
			System.out.println("1 - Exibir a tabela");
			System.out.println("2 - Atualizar usuário");
			System.out.println("3 - Inserir usuário");
			System.out.println("4 - Excluir usuário");
			System.out.println("5 - Sair");

			opcao = scanner.nextInt();

			switch (opcao) {

				case 1:

					usuarios = dao.getUsuarios();

					System.out.println(" ");
					System.out.println(" Usuários ");
					System.out.println(" ");

					for (int i = 0; i < usuarios.length; i++) {

						System.out.println(usuarios[i].toString());

					}

					System.out.println(" ");

					break;

				case 2:

				    System.out.println("Insira o codigo que será atualizado: ");
					codigo = scanner.nextInt();

					scanner.nextLine();

					System.out.println("Insira o login do usuário: ");
					login = scanner.nextLine();

					System.out.println("Insira a senha do usuário e confirme-a: ");
					senha = scanner.nextLine();

					scanner.nextLine();

					System.out.println("Insira o sexo do usuário: ");
					sexo = scanner.next().charAt(0);

					Usuario aux = new Usuario(codigo, login, senha, sexo);

					dao.atualizarUsuario(aux);

					System.out.println(" ");

					break;

				case 3:
				    System.out.println("Insira o código (permanente) do usuário: ");
					codigo = scanner.nextInt();
					usuario.setCodigo(codigo);

					scanner.nextLine();

					System.out.println("Insira o login do usuário: ");
					login = scanner.nextLine();
					usuario.setLogin(login);

					System.out.println("Insira a senha do usuário e confirme-a: ");
					senha = scanner.nextLine();
					usuario.setSenha(senha);

					scanner.nextLine();

					System.out.println("Insira o sexo do usuário: ");
					sexo = scanner.next().charAt(0);
					usuario.setSexo(sexo);

					if (dao.inserirUsuario(usuario) == true) {

						System.out.println("Inserido com sucesso! " + usuario.toString());

					}

					System.out.println(" ");
					
					break;

				case 4:
					System.out.println("Insira o codigo do usuário que será excluido: ");
					codigo = scanner.nextInt();

					dao.excluirUsuario(codigo);

					System.out.println(" ");

					break;

				case 5:					
					opcao = 5; 

					break;

				default:
				    opcao = 5; 

					break;

			}

		}

		scanner.close();
		dao.close();

	}

}