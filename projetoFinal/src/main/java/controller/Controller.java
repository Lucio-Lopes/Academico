package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.Disciplina;
import model.Professor;
import model.Turmas;
import model.profDisc;

@WebServlet(urlPatterns ={"/Controller","/atualizar","/insertProf", "/insertTurma", "/insertDisc", "/updateProf", "/updateDisc", "/updateTurma","/deleteProf","/deleteTurma","/deleteDisc","/listarProf","/listarDisc","/listarTurma","/selectProf","/selectDisc","/selectTurma","/profDisc","/insertProfDisc","/novaTurma","/detalhes"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DAO dao = new DAO();
	Professor prof = new Professor();
	Disciplina disc = new Disciplina();
	Turmas turma = new Turmas();
	profDisc profD = new profDisc();
	
    public Controller() {
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		switch(action) {
			case "/insertProf":
				insertProf(request,response);
			break;
			case "/insertTurma":
				insertTurma(request,response);
			break;
			case "/insertDisc":
				insertDisc(request,response);
			break;
			case "/updateProf":
				updateProf(request,response);
			break;
			case "/updateTurma":
				updateTurma(request,response);
			break;
			case "/updateDisc":
				updateDisc(request,response);
			break;
			case "/deleteProf":
				deleteProf(request,response);
			break;
			case "/deleteTurma":
				deleteTurma(request,response);
			break;
			case "/deleteDisc":
				deleteDisc(request,response);
			break;
			case "/selectProf":
				selectProf(request,response);
			break;
			case "/selectDisc":
				selectDisc(request,response);
			break;
			case "/selectTurma":
				selectTurma(request,response);
			break;
			case "/listarProf":
				professores(request,response);
			break;
			case "/listarDisc":
				disciplinas(request,response);
			break;
			case "/listarTurma":
				turmas(request,response);
			break;
			case "/profDisc":
				profDisc(request,response);
			break;
			case "/insertProfDisc":
				insertProfDisc(request,response);
			break;
			case "/novaTurma":
				novaTurma(request,response);
			break;
			case "/atualizar":
				atualizar(request,response);
			break;
			case "/detalhes":
				detalhes(request,response);
			break;
			default:
				response.sendRedirect("index.html");
			break;
		}	
	}
	
	protected void professores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Professor> listaProf = dao.listarProf();
		request.setAttribute("professores", listaProf);
		RequestDispatcher rd = request.getRequestDispatcher("professor.jsp");
		rd.forward(request,response);
		
	}

	protected void disciplinas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Disciplina> listaDisc = dao.listarDisc();
		request.setAttribute("disciplinas", listaDisc);
		RequestDispatcher rd = request.getRequestDispatcher("disciplina.jsp");
		rd.forward(request,response);
	}
	
	protected void profDisc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Disciplina> listaDisc = dao.listarDisc();
		ArrayList<Professor> listaProf = dao.listarProf();
		request.setAttribute("disciplinas", listaDisc);
		request.setAttribute("professores", listaProf);
		RequestDispatcher rd = request.getRequestDispatcher("profDisc.jsp");
		rd.forward(request,response);
		
		response.sendRedirect("profDisc.jsp");
		
	}
	
	protected void turmas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Turmas> listaTurma = dao.listarTurmas();
		request.setAttribute("turmas", listaTurma);
		RequestDispatcher rd = request.getRequestDispatcher("turma.jsp");
		rd.forward(request,response);
		
	}

	
	protected void insertProf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		prof.setNome(request.getParameter("nome"));
		prof.setFone(request.getParameter("telefone"));
		prof.setEmail(request.getParameter("email"));
		
		dao.inserirProf(prof);
		response.sendRedirect("listarProf");
	}
	
	protected void insertProfDisc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		profD.setIdProfessor(request.getParameter("professor"));
		profD.setIdDisciplina(request.getParameter("disciplina"));
		dao.profDisc(profD);
		response.sendRedirect("index.html");
		
	}
	
	protected void insertTurma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		turma.setSala(request.getParameter("sala"));
		turma.setQuant(request.getParameter("quant"));
		turma.setProf(request.getParameter("professor"));
		turma.setDisc(request.getParameter("disciplina"));
		dao.inserirTurma(turma);
		response.sendRedirect("listarTurma");
		
	}
	
	protected void insertDisc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		disc.setNome(request.getParameter("nome"));
		disc.setSemestre(request.getParameter("semestre"));
		disc.setCarga_horaria(request.getParameter("hora"));
		dao.inserirDisc(disc);
		response.sendRedirect("listarDisc");
	}
	
	protected void updateProf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		prof.setNome(request.getParameter("nome"));
		prof.setFone(request.getParameter("telefone"));
		prof.setEmail(request.getParameter("email"));
		dao.alterarProf(prof);
		response.sendRedirect("listarProf");
		
	}
	
	protected void updateTurma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		turma.setSala(request.getParameter("sala"));
		turma.setQuant(request.getParameter("quant"));
		dao.alterarTurma(turma);
		response.sendRedirect("listarTurma");
	}
	
	protected void updateDisc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		disc.setNome(request.getParameter("nome"));
		disc.setSemestre(request.getParameter("semestre"));
		disc.setCarga_horaria(request.getParameter("hora"));
		dao.alterarDisc(disc);
		response.sendRedirect("listarDisc");
		
	}
	
	protected void deleteProf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		prof.setId(request.getParameter("id"));
		dao.delProf(prof);
		response.sendRedirect("listarProf");
		
	}
	
	protected void deleteTurma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		turma.setId(request.getParameter("id"));
		dao.delTurma(turma);
		response.sendRedirect("listarTurma");
		
	}
	
	protected void deleteDisc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		disc.setId(request.getParameter("id"));
		dao.delDisc(disc);
		response.sendRedirect("listarDisc");
		
	}
	protected void selectProf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		prof.setId(request.getParameter("id"));
		dao.selectProf(prof);
		request.setAttribute("nome", prof.getNome());
		request.setAttribute("telefone", prof.getFone());
		request.setAttribute("email", prof.getEmail());
		RequestDispatcher rd = request.getRequestDispatcher("editarProf.jsp");
		rd.forward(request, response);
		
	}
	protected void selectDisc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		disc.setId(request.getParameter("id"));
		dao.selectDisc(disc);
		request.setAttribute("nome", disc.getNome());
		request.setAttribute("semestre", disc.getSemestre());
		request.setAttribute("carga_horaria", disc.getCarga_horaria());
		RequestDispatcher rd = request.getRequestDispatcher("editarDisc.jsp");
		rd.forward(request, response);
	}
	protected void selectTurma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		turma.setId(request.getParameter("id"));
		dao.selectTurma(turma);
		request.setAttribute("sala", turma.getSala());
		request.setAttribute("quant", turma.getQuant());
		RequestDispatcher rd = request.getRequestDispatcher("editarTurma.jsp");
		rd.forward(request, response);
	}
	
	protected void novaTurma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Disciplina> listaDisc = dao.listarDisc();
		request.setAttribute("disc", listaDisc);
		RequestDispatcher rd = request.getRequestDispatcher("novaTurma.jsp");
		rd.forward(request,response);
		response.sendRedirect("novaTurma.jsp");	
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		ArrayList<Professor> listaProf = dao.atualizarTurma(id);
		ArrayList<Disciplina> listaDisc = dao.listarDiscTurma(id);
		request.setAttribute("disc", listaDisc);
		request.setAttribute("prof", listaProf);
		RequestDispatcher rd = request.getRequestDispatcher("novaTurma2.jsp");
		rd.forward(request, response);
		
		
	}
	
	protected void detalhes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		ArrayList<Professor> listaProf = dao.histProf(id);
		request.setAttribute("prof", listaProf);
		request.setAttribute("nome", nome);
		RequestDispatcher rd = request.getRequestDispatcher("detalhes.jsp");
		rd.forward(request, response);
		System.out.println(id);
		
		
	}
	
}

