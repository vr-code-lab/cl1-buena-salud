package buenasalud.model;

import java.util.Scanner;

import buenasalud.configuration.Conn;
import buenasalud.entity.Citas;
import buenasalud.entity.Doctores;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class MainJPA {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		EntityManager em = Conn.getInstancia().getFactory().createEntityManager();
		
		Doctores doctor1 = new Doctores();
		doctor1.setNomDoc("Juan");
		doctor1.setEspDoc("Cardiologia");
		
		Doctores doctor2 = new Doctores();
		doctor2.setNomDoc("Elver");
		doctor2.setEspDoc("Oftalmologia");
		
		Doctores doctor3 = new Doctores();
		doctor3.setNomDoc("Luis");
		doctor3.setEspDoc("Otorrinolaringologia");
		
		em.getTransaction().begin();
		em.persist(doctor1);
		em.persist(doctor2);
		em.persist(doctor3);
		em.getTransaction().commit();
		

		System.out.println("1. Ingresar Cita\n2. Mostrar Citas del doctor\n3. Salir");
		System.out.println("Elija opción según el numero:");
		int opc = Integer.parseInt(sc.nextLine());
		
		boolean correcto = false;
		String imputNumCita = null;
		String imputFecCita = null;
		String imputNomPac = null;
		String imputNomDoc = null;
		
		
		if(opc == 1) {
			
			System.out.println("1. Nro de Cita: ");
			imputNumCita = (sc.nextLine());
			
			System.out.println("-> Fecha de la cita(DD/MM/YYYY): ");
			imputFecCita = (sc.nextLine());
			
			System.out.println("-> Nombre del paciente: ");
			imputNomPac = (sc.nextLine());
			
			System.out.println("-> Nombre del Doctor ");
			imputNomDoc = (sc.nextLine());
			
			if(imputNumCita != null && imputFecCita != null && imputNomPac != null && imputNomDoc != null) {
				correcto = true;
				
			}else {
				correcto = false;
				System.out.println("-> Error los campos deben estar llenos");
			}

		}
		
		if(opc == 2) {
			System.out.println("-> Ingrese el nombre del doctor: ");
			imputNomDoc = (sc.nextLine());
			
			String query = "SELECT d FROM Doctores d WHERE d.nomDoc = :nombre";
			Query q = em.createQuery(query);
			q.setParameter("nombre", imputNomDoc);
			
			Doctores doctorx = (Doctores) q.getSingleResult();
			
			System.out.println("Nombre el banco: " + doctorx.getNomDoc());
			
			for(int i = 0; i < doctorx.getCitas().size()-1;i++) {
				System.out.println("Id: " + doctorx.getCitas().get(i).getIdeCita() + " Fecha: " + doctorx.getCitas().get(i).getFecCita() + " paciente: " + doctorx.getCitas().get(i).getNomPacCit());
			}
		}
		
		if(opc==3) {
			System.out.println("Saliendo del sistema");
			System.exit(0);
		}
		
		if(correcto == true) {
			
			String query = "SELECT d FROM Doctores d WHERE d.nomDoc = :nombre";
			Query q = em.createQuery(query);
			q.setParameter("nombre", imputNomDoc);
			Doctores doctor = (Doctores) q.getSingleResult();
			
			Citas citax = new Citas();
			citax.setNumCita(imputNumCita);
			citax.setFecCita(imputFecCita);
			citax.setNomPacCit(imputNomPac);
			citax.setC_doctores(doctor);
			
			em.getTransaction().begin();
			em.persist(citax);
			em.getTransaction().commit();
			System.out.println("-> Cita Añadida con éxito");
		}
		
	}

}
