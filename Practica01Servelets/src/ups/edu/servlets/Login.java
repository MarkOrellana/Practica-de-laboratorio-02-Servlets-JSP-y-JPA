package ups.edu.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ups.edu.dao.DAOFactory;
import ups.edu.dao.UsuarioDAO;
import ups.edu.entidades.Usuario;


@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/html/pagina-login.html");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mail = request.getParameter("mail");
        String pass = request.getParameter("pass");
        
        UsuarioDAO usuarioDao = DAOFactory.getDAOFactory().getUsuarioDAO();
        Usuario usuario = usuarioDao.findUser(mail, pass);
        if (usuario != null && usuario.getActivo() == 1) {
            System.out.println("usuario encontrado");
            HttpSession session = request.getSession(true);
            System.out.println("Sesion iniciada con id " + request.getSession().getId());
            session.setAttribute("sesionID", String.valueOf(session.getId()));
            session.setAttribute("userID", usuario.getCedula());
            
            response.sendRedirect("my-agenda");
            
        }else{
            response.sendRedirect("login");
        }     
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
