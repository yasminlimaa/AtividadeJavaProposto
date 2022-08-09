package aulavilsonjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aulavilsonjdbc.entidades.Livro;
import aulavilsonjdbc.interfaces.ICrud;
import aulavilsonjdbc.utilidades.Conexao;

public class DaoLivro implements ICrud<Livro> {

	@Override
	public boolean salvar(Livro obj) {
		String sql = "insert into livro(nome, paginas, genero)values(?,?,?)";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getNome());
			stm.setString(2, obj.getPaginas());
			stm.setString(3, obj.getGenero());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			Conexao.fechar();
		}
		return true;
		
		
	}

	@Override
	public boolean alterar(Livro obj) {
		String sql = "update livro set "+
                "nome = ?,"+
                "paginas = ?,"+
                "genero = ? "+
                "where id = ?";
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getPaginas());
            stm.setString(3, obj.getGenero());
            stm.setInt(4, obj.getId());
            stm.execute();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        finally {
            Conexao.fechar();
        }
        return true;
		
	}

	@Override
	public void excluir(int id) {
		String sql = "delete from livro where id = " + id;
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Conexao.fechar();
        }
		
	}

	@Override
	public Livro consultar(int id) {
		Livro livro = new Livro();
        String sql = "select * from livro where id= " + id;
        Connection con = Conexao.conectar();        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                livro.setId(rs.getInt("id"));
                livro.setNome(rs.getString("nome"));
                livro.setPaginas(rs.getString("paginas"));
                livro.setGenero(rs.getString("genero"));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Conexao.fechar();
        }
        return livro;
		
	}

	@Override
	public List<Livro> consultar() {
		List<Livro>/ livros = new ArrayList<>();
        String sql = "select * from livro";
        
        Connection con = Conexao.conectar();
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setNome(rs.getString("nome"));
                livro.setPaginas(rs.getString("paginas"));
                livro.setGenero(rs.getString("genero"));
                livros.add(livro);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            Conexao.fechar();
        }
        return alunos;
		
	}

	

}
