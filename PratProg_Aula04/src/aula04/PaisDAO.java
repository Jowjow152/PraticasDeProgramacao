package aula04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaisDAO {

	public static void create (PaisTO pais){
		String sqlInsert = "INSERT INTO pais(idPais, Nome, Populacao, Area) VALUES (?, ?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setInt(1, pais.getId());
			stm.setString(2, pais.getNome());
			stm.setLong(3, pais.getPopulacao());
			stm.setDouble(4, pais.getArea());
			stm.execute();
			
			conn.close();
			
			System.out.println("Pais " + pais.getNome() + " adicionado com sucesso!");
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static PaisTO read (int id) {
		
		String sqlSelect = "SELECT * FROM Pais WHERE idPais = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			
			stm.setInt(1, id);
			stm.execute();
			
			try(ResultSet rs = stm.executeQuery();){
	
				if(rs.next()) 
					return new PaisTO(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4));
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			conn.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		System.out.println("Não foi possível encontrar o pais");
		
		return new PaisTO();
	}
	
	public static PaisTO read (String nome) {
		
		String sqlSelect = "SELECT * FROM Pais WHERE nome = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			
			stm.setString(1, nome);
			stm.execute();
			
			try(ResultSet rs = stm.executeQuery();){
	
				if(rs.next()) 
					return new PaisTO(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4));
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			conn.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		System.out.println("Não foi possível encontrar o pais");
		
		return new PaisTO();
	}
	
	public static void delete(int id) {
		
		String sqlDelete = "DELETE FROM pais.pais WHERE idPais = ?";
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			
			stm.setInt(1, id);
			stm.execute();
			
			conn.close();
			
			System.out.println("Pais deletado com sucesso!");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void update (int id, PaisTO paisNovo) {
		
		String sqlUpdate = "UPDATE pais SET Nome = ?, Populacao = ?, Area = ? WHERE idPais = ?";
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			
			stm.setString(1, paisNovo.getNome());
			stm.setLong(2, paisNovo.getPopulacao());
			stm.setDouble(3, paisNovo.getArea());
			stm.setInt(4, id);
			stm.execute();
			
			conn.close();
			
			System.out.println("O pais foi atualizado para " + paisNovo);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
				
		
	}
	
	public static PaisTO maiorPopulacao() {
		String sqlMaiorPopulacao = "SELECT * FROM pais.pais ORDER BY Populacao DESC LIMIT 1";
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlMaiorPopulacao);){
			
			try(ResultSet rs = stm.executeQuery()){
				
				if(rs.next())
					return new PaisTO(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4));
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Não foi possível encontrar");
		return new PaisTO();
		
	}
	
	public static PaisTO menorArea() {
		
		String sqlMenorArea = "SELECT * FROM pais.pais ORDER BY Area ASC LIMIT 1";
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlMenorArea);){
			
			try(ResultSet rs = stm.executeQuery();){
				
				if(rs.next())
					return new PaisTO(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4));
					
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Não foi possível encontrar");
		return new PaisTO();
	}
	
	public static Pais[] tresPaises() {
		
		String sqlTresPaises = "SELECT * FROM pais.pais";
		Pais paises[] = new Pais[3];
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlTresPaises);){
			
			try(ResultSet rs = stm.executeQuery()){
				
				for(int i = 0; i < 3; i++) {
					if(rs.next()) {
						paises[i] = new Pais(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4));
					}
					else
						System.out.println("Nao foi possivel ler o pais " + i);
				}
				
				return paises;
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return paises;
	}
	
	public static ArrayList<Pais> listaPaises(){
		
		String sqlListaPaises = "SELECT * FROM pais.pais";
		ArrayList<Pais> paises = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlListaPaises);){
			
			try(ResultSet rs = stm.executeQuery();){
				
				while(rs.next()) 
					paises.add(new Pais(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getDouble(4)));
						
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return paises;
	}
	
}
