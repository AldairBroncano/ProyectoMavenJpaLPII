package Test;

import java.util.List;

import Dao.TblClienteImp;
import model.TblCliente;

public class TestCliente {

	public static void main(String[] args) {
		//realizamos las respectiva instancias..
		TblCliente cliente=new TblCliente();
		TblClienteImp crud=new TblClienteImp();
		//insertamos datos
		/*cliente.setNombre("nena");
		cliente.setApellido("rivera rivera");
		cliente.setDni("104534589");
		cliente.setEmail("alex@gmail.com");
		cliente.setTelf("387459");
		cliente.setSexo("M");
		cliente.setNacionalidad("colombia");
		//invocamos el metodo registrar...
		crud.RegistrarCliente(cliente);
		
		*/
		
		
		List<TblCliente>listado=crud.ListarCliente();
		
		for(TblCliente lis:listado){
			System.out.println("codigo: " +  lis.getIdcliente() +
					"Nombre: " +  lis.getNombre() +
					"Apellido: " +  lis.getApellido() +
					"Dni: " +  lis.getDni() +
					"Email: " +  lis.getEmail() +
					"Telf: " +  lis.getTelf() +
					"sexo: " +  lis.getSexo() +
					"Nacionalidad: " +  lis.getNacionalidad() 
					);
		}
		

	}//fin del metodo principal...

}   //fin de la clase...
