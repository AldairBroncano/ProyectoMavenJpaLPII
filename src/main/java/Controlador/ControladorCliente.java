package Controlador;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.TblClienteImp;
import model.TblCliente;


/**
 * Servlet implementation class ControladorCliente
 */
public class ControladorCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorCliente() {
       // super();
        // TODO Auto-generated constructor stub
    }  //fin del constructor...

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TblCliente cliente = new TblCliente();
		TblClienteImp crud= new TblClienteImp();
		List<TblCliente>listadocliente =crud.ListarCliente();
	
		
		
		
		
		request.setAttribute("listadoclientes", listadocliente);
		
		
		
		
		//response.getWriter().append("Controlador Cliente ").append(request.getContextPath());
	    request.getRequestDispatcher("/ListadoClientes.jsp").forward(request, response);
	
	}  //fin del metodo doget..

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//Recuperamos los datos del formulario
		String nombre=request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String dni = request.getParameter("dni");
		String email = request.getParameter("email");
		String telef = request.getParameter("telefono");
		String sexo = request.getParameter("sexo");
		String nacion = request.getParameter("nacionalidad");
		
		//instacioamos los clases
		
		TblCliente cliente= new TblCliente();
		TblClienteImp crud = new TblClienteImp();	
		
		
		cliente.setNombre(nombre);
		cliente.setApellido(apellido);
		cliente.setDni(dni);
		cliente.setEmail(email);
		cliente.setTelf(telef);
		cliente.setSexo(sexo);
		cliente.setNacionalidad(nacion);
		
		crud.RegistrarCliente(cliente);
		
		//Actualizar el listado
      List<TblCliente>listadocliente =crud.ListarCliente();
		
		request.setAttribute("listadoclientes", listadocliente);
		
		
		
		//redireccionamos hacia el listado de clientes...
		request.getRequestDispatcher("/ListadoClientes.jsp").forward(request, response);
	}  //fin del metodo dopost...

}
