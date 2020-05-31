package aula09;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	public static Usuario validar (Usuario user){
		
		String sqlInsert = "SELECT * from usuario where login=? and senha=?";
		Usuario u = new Usuario();
		
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setString(1, user.getLogin());
			
			
			byte[] senhaCifrada = null;
			CryptoAES caes = new CryptoAES();
			File chave = new File("chave.simetrica");
			if(!chave.exists()) {
				try {
					caes.geraChave(chave);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			try {
				caes.geraCifra(user.getSenha().getBytes("ISO-8859-1"), chave);
				senhaCifrada = caes.getTextoCifrado();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			stm.setBytes(2, senhaCifrada);
			stm.execute();
			
			try(ResultSet rs = stm.executeQuery();){
				
				if(rs.next()) {
					u.setId(rs.getInt(1));
					u.setNome(rs.getString(2));
					
					byte[] senhaDecifrada = null;
					try {
						caes.geraDecifra(rs.getBytes(3), new File("chave.simetrica"));
						senhaDecifrada = caes.getTextoDecifrado();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						u.setSenha(new String(senhaDecifrada, "ISO-8859-1"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
					u.setLogin(rs.getString(4));
				}
					
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			conn.close();
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return u;
	}
	
	public static void criar (Usuario user){
		String sqlInsert = "INSERT INTO usuario(Nome, Senha, Login) VALUES (?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			stm.setString(1, user.getNome());
			
			byte[] senhaCifrada = null;
			CryptoAES caes = new CryptoAES();
			try {
				caes.geraCifra(user.getSenha().getBytes("ISO-8859-1"), new File("chave.simetrica"));
				senhaCifrada = caes.getTextoCifrado();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			stm.setBytes(2, senhaCifrada);
			stm.setString(3, user.getLogin());
			stm.execute();
			
			conn.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}
}
