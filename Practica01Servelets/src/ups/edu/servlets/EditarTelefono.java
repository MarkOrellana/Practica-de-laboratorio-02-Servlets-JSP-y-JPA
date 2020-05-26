package ups.edu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ups.edu.dao.DAOFactory;
import ups.edu.dao.TelefonoDAO;
import ups.edu.entidades.Telefono;
import ups.edu.entidades.Usuario;


@WebServlet(name = "EditarTelefono", urlPatterns = {"/editar-telefono"})
public class EditarTelefono extends HttpServlet {



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
        String sesion = request.getParameter("delete");
        String id = request.getParameter("idTelefono");
        if (sesion != null && id != null) {
            if (sesion.equals("true")) {  
                TelefonoDAO telefonoDao = DAOFactory.getDAOFactory().getTelefonoDAO();
                Telefono telefono = telefonoDao.findById(Integer.parseInt(id));
                telefonoDao.delete(telefono);
                
                response.sendRedirect("my-agenda");
            }
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
        String numero = request.getParameter("numero");
        String tipo = request.getParameter("tipo");
        String operadora = request.getParameter("operadora");
        String idTelefono = request.getParameter("idtel");

        TelefonoDAO telefonoDao = DAOFactory.getDAOFactory().getTelefonoDAO();
        Telefono telefono = telefonoDao.findById(Integer.parseInt(idTelefono));
        Usuario usuario = DAOFactory.getDAOFactory().getUsuarioDAO().findById(String.valueOf(request.getSession().getAttribute("userID")));
        telefono.setUsuario(usuario);
        telefono.setNumero(numero);
        telefono.setTipo(tipo);
        telefono.setOperadora(operadora);
        
        telefonoDao.update(telefono);

        response.sendRedirect("my-agenda");
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
