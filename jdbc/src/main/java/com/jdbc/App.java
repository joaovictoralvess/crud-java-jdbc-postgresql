package com.jdbc;

import java.util.Scanner;

import com.dao.UsuarioDAO;

public class App {
    // Conexão com o UsuarioDAO de Dados

    public static void main(String[] args) {
        boolean rodando = true;
        Scanner sc = new Scanner(System.in);
        while (rodando) {
            int id = 0;
            String nome = "";
            int idade = 0;

            System.out.println("Digite o Número Para Fazer a Ação");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Sair");
            int resposta = sc.nextInt();

            switch (resposta) {
                case 1:
                    System.out.println("Digite o nome: ");
                    nome = sc.next();
                    System.out.println("Digite a idade: ");
                    idade = sc.nextInt();
                    UsuarioDAO.Cadastrar(nome, idade);
                    break;

                case 2:
                    System.out.println("Listando usuários...");
                    UsuarioDAO.Listar();
                    break;

                case 3:
                    System.out.println("Atualizar...");
                    System.out.println("Digite o ID que deseja mudar: ");
                    id = sc.nextInt();
                    System.out.println("Digite o nome: ");
                    nome = sc.next();
                    System.out.println("Digite a idade: ");
                    idade = sc.nextInt();
                    UsuarioDAO.Atualizar(id, nome, idade);
                    break;

                case 4:
                    System.out.println("Digite o ID que você quer deletar: ");
                    id = sc.nextInt();
                    UsuarioDAO.Deletar(id);
                    System.out.println("Deletado com sucesso!");
                    break;

                case 0:
                    System.out.println("Encerrando programa...");
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        }
        sc.close();
    }
}