package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/academico?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "12345";
	
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			return con;
		} catch (Exception e) {
			
			return null;
			
		}
	}
	public void teste() {
		
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	//criar professor
	
	public void inserirProf(Professor prof) {
		
			String criar = "insert into professor(nome,telefone,email) values(?,?,?)";
			
			try {
				
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(criar);
				pst.setString(1, prof.getNome());
				pst.setString(2, prof.getFone());
				pst.setString(3, prof.getEmail());
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		
	}
	
	public void inserirDisc(Disciplina disc) {
		
		String criar = "insert into disciplina(nome,semestre,carga_horario) values(?,?,?)";
		
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(criar);
			pst.setString(1, disc.getNome());
			pst.setString(2, disc.getSemestre());
			pst.setString(3, disc.getCarga_horaria());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
	public void inserirTurma(Turmas turma) {
		
		String criar = "insert into turma(sala,quant_alunos,disciplina_id,professor_id) values(?,?,?,?)";
		
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(criar);
			pst.setString(1, turma.getSala());
			pst.setString(2, turma.getQuant());
			pst.setString(3, turma.getDisc());
			pst.setString(4, turma.getProf());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
	public ArrayList<Professor>  listarProf(){
		
		ArrayList<Professor> lista = new ArrayList<>();
		
		String read = "select * from professor order by id";
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				
				lista.add(new Professor(id,nome,fone,email));
			}
			con.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	public ArrayList<Disciplina>  listarDisc(){
			
		ArrayList<Disciplina> lista = new ArrayList<>();
		String read = "select * from disciplina order by id";
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String semestre = rs.getString(3);
				String carga_horario = rs.getString(4);
				
				lista.add(new Disciplina(id,nome,semestre,carga_horario));
			}
			con.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
			
	}
	
	public ArrayList<Turmas>  listarTurmas(){
		
		ArrayList<Turmas> lista = new ArrayList<>();
		String read = "SELECT t.id,t.sala,t.quant_alunos, d.nome AS disciplina,p.nome AS professor from turma t inner join professor p on t.professor_id = p.id inner join disciplina d on t.disciplina_id = d.id order by id";
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				String id = rs.getString(1);
				String sala = rs.getString(2);
				String quant_alunos = rs.getString(3);
				String disciplina_id = rs.getString(4);
				String professor_id = rs.getString(5);
				
				lista.add(new Turmas(id,sala,quant_alunos,disciplina_id,professor_id));
			}
			con.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	public void selectProf(Professor prof) {
		
		String read = "select * from professor where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1,prof.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				prof.setId(rs.getString(1));
				prof.setNome(rs.getString(2));
				prof.setFone(rs.getString(3));
				prof.setEmail(rs.getString(4));
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void selectDisc(Disciplina disc) {
		
		String read = "select * from disciplina where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1,disc.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				disc.setId(rs.getString(1));
				disc.setNome(rs.getString(2));
				disc.setSemestre(rs.getString(3));
				disc.setCarga_horaria(rs.getString(4));
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void selectTurma(Turmas turma) {
		
		String read = "select * from turma where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1,turma.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				turma.setId(rs.getString(1));
				turma.setSala(rs.getString(2));
				turma.setQuant(rs.getString(3));
				turma.setDisc(rs.getString(4));
				turma.setProf(rs.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void alterarProf(Professor prof) {
		
		String create = "update professor set nome=?,telefone=?,email=? where id=?";
		
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1,prof.getNome());
			pst.setString(2,prof.getFone());
			pst.setString(3,prof.getEmail());
			pst.setString(4,prof.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void alterarDisc(Disciplina disc) {
		
		String create = "update disciplina set nome=?,semestre=?,carga_horario=? where id=?";
		
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1,disc.getNome());
			pst.setString(2,disc.getSemestre());
			pst.setString(3,disc.getCarga_horaria());
			pst.setString(4,disc.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public void alterarTurma(Turmas turma) {
		
		String create = "update turma set sala=?,quant_alunos=?,disciplina_id=?,professor_id=? where id=?";
		
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1,turma.getSala());
			pst.setString(2,turma.getQuant());
			pst.setString(3,turma.getDisc());
			pst.setString(4,turma.getProf());
			pst.setString(5,turma.getId());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void profDisc(profDisc profD) {
		
		
		
		String query = "insert into professor_disciplina (professor_id,disciplina_id)values (?,?);";
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,profD.getIdProfessor());
			pst.setString(2,profD.getIdDisciplina());
			pst.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	
	public void delProf(Professor prof) {
		
		String del = "delete from professor where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(del);
			pst.setString(1, prof.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public void delDisc(Disciplina disc) {
		
		String del = "delete from disciplina where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(del);
			pst.setString(1, disc.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void delTurma(Turmas turma) {
		
		String del = "delete from turma where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(del);
			pst.setString(1, turma.getId());
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public ArrayList<Professor>  atualizarTurma(String id){
		
		ArrayList<Professor> lista = new ArrayList<>();
		String read = "SELECT p.nome, p.id FROM disciplina d INNER JOIN professor_disciplina pd ON d.id = pd.disciplina_id INNER JOIN professor p ON pd.professor_id= p.id WHERE d.id =?";
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				
				String nome = rs.getString(1);
				String id1 = rs.getString(2);
				
				lista.add(new Professor(id1,nome,null,null));
			}
			con.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
			
	}
	public ArrayList<Disciplina>  listarDiscTurma(String id){
		
		ArrayList<Disciplina> lista = new ArrayList<>();
		
		String read = "select id,nome from disciplina where id=?";
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1,id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				
				String id1 = rs.getString(1);
				String nome = rs.getString(2);
				
				
				lista.add(new Disciplina(id1,nome,null,null));
			}
			con.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	public ArrayList<Professor>  histProf(String id){
		
		ArrayList<Professor> lista = new ArrayList<>();
		String read = "SELECT p.nome, d.nome, SUM(d.carga_horario), SUM(t.quant_alunos) FROM professor p JOIN professor_disciplina pd ON p.id = pd.professor_id JOIN disciplina d ON pd.disciplina_id = d.id LEFT JOIN turma t ON d.id = t.disciplina_id and p.id = t.professor_id WHERE p.id = ? GROUP BY d.nome;";
		try {
			
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String nome = rs.getString(1);
				String disciplina = rs.getString(2);
				String carga_horaria = rs.getString(3);
				String quant = rs.getString(4);
				if(quant == null) {
					
					quant = "";
					carga_horaria="";
					
				}
				lista.add(new Professor(nome,disciplina,carga_horaria,quant));
			}
			con.close();
			return lista;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
			
	}

}
