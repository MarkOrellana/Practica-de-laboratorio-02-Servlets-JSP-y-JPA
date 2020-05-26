package ups.edu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ups.edu.dao.DAOFactory;
import ups.edu.dao.UsuarioDAO;
import ups.edu.entidades.Usuario;


@WebServlet(name = "MyAgenda", urlPatterns = {"/my-agenda"})
public class MyAgenda extends HttpServlet {

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

        String sesion = request.getParameter("logout");
        if (sesion != null) {
            if (sesion.equals("true")) {
                request.getSession().invalidate();
                response.sendRedirect("/Practica01Servelets");

            }
        } else {
            UsuarioDAO usuarioDao = DAOFactory.getDAOFactory().getUsuarioDAO();
            Usuario usuario = usuarioDao.findById(String.valueOf(request.getSession().getAttribute("userID")));

            request.setAttribute("user", usuario);
            getServletContext().getRequestDispatcher("/views/jsp/my-agenda.jsp").forward(request, response);
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/views/jsp/my-agenda.jsp");
            //dispatcher.forward(request, response);
        }
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
        //processRequest(request, response);
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
