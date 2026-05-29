package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    static String url = "jdbc:postgresql://localhost:5432/banco";
    static String user = "postgres";
    static String password = "postgres";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void Cadastrar(String nome, int idade) {
        String sql = "INSERT INTO usuarios(nome, idade) VALUES (?, ?)";

        try (
                Connection conexao = conectar();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setInt(2, idade);

            ps.executeUpdate();

            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }
    }

    public static void Listar() {
        String sql = "SELECT * FROM usuarios ORDER BY id";

        try (
                Connection conexao = conectar();
                PreparedStatement ps = conexao.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Idade: " + rs.getInt("idade"));
                System.out.println("----------------------");
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
    }

    public static void Atualizar(int id, String nome, int idade) {
        String sql = "UPDATE usuarios SET nome = ?, idade = ? WHERE id = ?";

        try (
                Connection conexao = conectar();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setInt(2, idade);
            ps.setInt(3, id);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Usuário atualizado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com esse ID.");
            }

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }

    public static void Deletar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (
                Connection conexao = conectar();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Usuário deletado com sucesso!");
            } else {
                System.out.println("Nenhum usuário encontrado com esse ID.");
            }

        } catch (Exception e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}